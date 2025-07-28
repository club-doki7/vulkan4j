package club.doki7.babel.extract.webgpu

import club.doki7.babel.util.putEntityIfAbsent
import club.doki7.sennaar.cpl.CIntLiteralExpr
import club.doki7.sennaar.registry.Bitflag
import club.doki7.sennaar.registry.Bitmask
import club.doki7.sennaar.registry.Command
import club.doki7.sennaar.registry.Constant
import club.doki7.sennaar.registry.EnumVariant
import club.doki7.sennaar.registry.Enumeration
import club.doki7.sennaar.registry.FunctionTypedef
import club.doki7.sennaar.registry.IdentifierType
import club.doki7.sennaar.registry.Member
import club.doki7.sennaar.registry.OpaqueHandleTypedef
import club.doki7.sennaar.registry.Param
import club.doki7.sennaar.registry.PointerType
import club.doki7.sennaar.registry.Registry
import club.doki7.sennaar.registry.Structure
import club.doki7.sennaar.registry.Typedef
import kotlin.io.path.Path
import kotlinx.serialization.json.*
import java.math.BigInteger

private val inputDir = Path("codegen-v2/input")

fun extractWebGPURegistry(): Registry {
    val jsonString = inputDir.resolve("webgpu.json").toFile().readText()
    val idl = Json.decodeFromString<IDL>(jsonString)

    val registry = Registry("")
    extractObjects(registry, idl.objects)
    extractFunctionTypedefs(registry, idl.callbacks)
    extractStructures(registry, idl.structs)
    extractEnumeration(registry, idl.enums)
    extractBitmask(registry, idl.bitflags)
    extractFunctions(registry, idl.functions)
    extractConstants(registry, idl.constants)

    for (structure in coreStructures) {
        registry.structs.putEntityIfAbsent(structure)
    }
    registry.aliases.putEntityIfAbsent(Typedef(
        name = "WGPUBool",
        target = IdentifierType("uint32_t")
    ))

    registry.mergeWith(extractRustWGPURegistry())

    return registry
}

private fun extractObjects(registry: Registry, objects: List<IDLObject>) {
    for (obj in objects) {
        val objectTypeName = renameWGPUType(obj.name)
        registry.opaqueHandleTypedefs.putEntityIfAbsent(OpaqueHandleTypedef(name = objectTypeName))
        extractObjectMethods(registry, objectTypeName, obj.name, obj.methods)

        val idlReferenceCommandName = "${obj.name}_add_ref"
        val referenceCommand = Command(
            name = renameWGPUFunction(idlReferenceCommandName),
            params = mutableListOf(Param(
                name = renameWGPUVar(obj.name),
                ty = IdentifierType(objectTypeName),
                len = null,
                optional = false
            )),
            result = IdentifierType("void"),
            successCodes = mutableListOf(),
            errorCodes = mutableListOf()
        )
        referenceCommand.rename(renameWGPUVar(idlReferenceCommandName))
        registry.commands.putEntityIfAbsent(referenceCommand)

        val idlReleaseCommandName = "${obj.name}_release"
        val releaseCommand = Command(
            name = renameWGPUFunction(idlReleaseCommandName),
            params = mutableListOf(Param(
                name = renameWGPUVar(obj.name),
                ty = IdentifierType(objectTypeName),
                len = null,
                optional = false
            )),
            result = IdentifierType("void"),
            successCodes = mutableListOf(),
            errorCodes = mutableListOf()
        )
        releaseCommand.rename(renameWGPUVar(idlReleaseCommandName))
        registry.commands.putEntityIfAbsent(releaseCommand)
    }
}

private fun extractObjectMethods(
    registry: Registry,
    objectType: String,
    objectTypeOriginalName: String,
    methods: List<IDLFunction>
) {
    for (method in methods) {
        val idlMethodName = "${objectTypeOriginalName}_${method.name}"

        val params = mutableListOf(Param(
            name = renameWGPUVar(objectTypeOriginalName),
            ty = IdentifierType(objectType),
            len = null,
            optional = false
        ))
        method.args?.forEach {
            arg -> if (isIDLTypeArray(arg.type)) {
                params.add(Param(
                    name = renameWGPUVar(singularize(arg.name)) + "Count",
                    ty = IdentifierType("size_t"),
                    len = null,
                    optional = arg.optional
                ))

                val type = classifyType(arg.type.removeSurrounding("array<", ">"), arg.pointer)
                params.add(Param(
                    name = renameWGPUVar(arg.name),
                    ty = type,
                    len = null,
                    optional = arg.optional
                ))
            } else {
                params.add(extractFunctionParam(arg))
            }
        }

        val result = if (method.callback != null) {
            IdentifierType("WGPUFuture")
        } else if (method.returns != null) {
            classifyType(method.returns.type, method.returns.pointer)
        } else {
            IdentifierType("void")
        }

        if (method.callback != null) {
            params.add(Param(
                name = "callbackInfo",
                ty = classifyCallbackInfoType(method.callback),
                len = null,
                optional = false
            ))
        }

        val command = Command(
            name = renameWGPUFunction(idlMethodName),
            params = params,
            result = result,
            successCodes = mutableListOf(),
            errorCodes = mutableListOf()
        )
        command.rename(renameWGPUVar(idlMethodName))
        registry.commands.putEntityIfAbsent(command)
    }
}

private fun extractFunctionTypedefs(registry: Registry, callbacks: List<IDLCallback>) {
    for (callback in callbacks) {
        val callbackName = renameWGPUFunctionPointer(callback.name)
        val params = callback.args.map { arg -> Param(
            name = arg.name,
            ty = classifyType(arg.type, arg.pointer),
            optional = true,
            len = null
        ) }.toMutableList()
        params.add(Param(
            name = "userdata1",
            ty = PointerType(IdentifierType("void"), isConst = false, pointerToOne = false, nullable = true),
            optional = true,
            len = null
        ))
        params.add(Param(
            name = "userdata2",
            ty = PointerType(IdentifierType("void"), isConst = false, pointerToOne = false, nullable = true),
            optional = true,
            len = null
        ))

        registry.functionTypedefs.putEntityIfAbsent(FunctionTypedef(
            name = callbackName,
            params = params,
            result = IdentifierType("void"),
            isPointer = true,
            isNativeAPI = false
        ))

        val callbackInfoName = "${callbackName}Info"
        registry.structs.putEntityIfAbsent(Structure(
            name = callbackInfoName,
            members = mutableListOf(
                Member(
                    name = "nextInChain",
                    ty = PointerType(IdentifierType("WGPUChainedStruct"), isConst = true, pointerToOne = false, nullable = false),
                    init = null,
                    len = null,
                    optional = true,
                    bits = null
                ),
                Member(
                    name = "mode",
                    ty = IdentifierType("WGPUCallbackMode"),
                    init = null,
                    len = null,
                    optional = false,
                    bits = null
                ),
                Member(
                    name = "callback",
                    ty = IdentifierType(callbackName),
                    init = null,
                    len = null,
                    optional = true,
                    bits = null
                ),
                Member(
                    name = "userdata1",
                    ty = PointerType(IdentifierType("void"), isConst = false, pointerToOne = false, nullable = true),
                    init = null,
                    len = null,
                    optional = true,
                    bits = null
                ),
                Member(
                    name = "userdata2",
                    ty = PointerType(IdentifierType("void"), isConst = false, pointerToOne = false, nullable = true),
                    init = null,
                    len = null,
                    optional = true,
                    bits = null
                )
            )
        ))
    }
}

private fun extractStructures(registry: Registry, structs: List<IDLStructure>) {
    for (struct in structs) {
        val members = mutableListOf<Member>()

        when (struct.type) {
            "base_in", "base_out", "base_in_or_out" -> {
                members.add(Member(
                    name = "nextInChain",
                    ty = PointerType(IdentifierType("WGPUChainedStruct"), isConst = true, pointerToOne = false, nullable = true),
                    init = null,
                    len = null,
                    optional = true,
                    bits = null
                ))
            }
            "extension_in", "extension_out", "extension_in_Or_out" -> {
                members.add(Member(
                    name = "chain",
                    ty = IdentifierType("WGPUChainedStruct"),
                    init = null,
                    len = null,
                    optional = false,
                    bits = null
                ))
            }
            "standalone" -> {
                // do nothing
            }
            else -> {
                error("Unknown structure type: ${struct.type} for structure ${struct.name}")
            }
        }

        struct.members.forEach { member ->
            if (isIDLTypeArray(member.type)) {
                val type = classifyType(member.type.removeSurrounding("array<", ">"), member.pointer)
                members.add(Member(
                    name = renameWGPUVar(singularize(member.name)) + "Count",
                    ty = IdentifierType("size_t"),
                    init = null,
                    len = null,
                    optional = member.optional,
                    bits = null
                ))
                members.add(Member(
                    name = renameWGPUVar(member.name),
                    ty = type,
                    init = null,
                    len = null,
                    optional = member.optional,
                    bits = null
                ))
            } else if (member.type.startsWith("callback.")) {
                val typeName = renameWGPUFunctionPointer(member.type.removePrefix("callback.")) + "Info"
                members.add(Member(
                    name = renameWGPUVar(member.name),
                    ty = IdentifierType(typeName),
                    init = null,
                    len = null,
                    optional = member.optional,
                    bits = null
                ))
            } else {
                members.add(Member(
                    name = renameWGPUVar(member.name),
                    ty = classifyType(member.type, member.pointer),
                    init = null,
                    len = null,
                    optional = member.optional,
                    bits = null
                ))
            }
        }

        registry.structs.putEntityIfAbsent(Structure(
            name = renameWGPUType(struct.name),
            members = members
        ))
    }
}

private fun extractEnumeration(registry: Registry, enums: List<IDLEnumeration>) {
    for (enum in enums) {
        registry.enumerations.putEntityIfAbsent(Enumeration(
            name = renameWGPUType(enum.name),
            variants = enum.entries.mapIndexed { idx, variant ->
                if (variant == null) {
                    null
                } else {
                    var variantName = variant.name.uppercase()
                    if (variantName.first().isDigit()) {
                        variantName = "_$variantName"
                    }
                    EnumVariant(
                        name = variantName,
                        value = CIntLiteralExpr("0x" + idx.toULong().toString(16)),
                    )
                }
            }.filter { it -> it != null }.map { it as EnumVariant }.toMutableList()
        ))
    }
}

private fun extractBitmask(registry: Registry, bitmasks: List<IDLBitmask>) {
    for (bitmask in bitmasks) {
        registry.bitmasks.putEntityIfAbsent(Bitmask(
            name = renameWGPUType(bitmask.name),
            bitwidth = 64,
            bitflags = bitmask.entries.mapIndexed { idx, bitflag ->
                var bitflagName = bitflag.name.uppercase()
                if (bitflagName.first().isDigit()) {
                    bitflagName = "_$bitflagName"
                }

                if (bitflag.value_combination != null) {
                    Bitflag(
                        name = bitflagName,
                        value = bitflag.value_combination.map { it.uppercase() }.toMutableList()
                    )
                } else {
                    Bitflag(
                        name = bitflagName,
                        value = if (idx == 0) BigInteger.ZERO else BigInteger.ONE.shiftLeft(idx - 1),
                    )
                }
            }.toMutableList()
        ))
    }
}

private fun extractFunctions(registry: Registry, functions: List<IDLFunction>) {
    for (function in functions) {
        val command = Command(
            name = renameWGPUFunction(function.name),
            params = if (function.args != null) {
                function.args.map(::extractFunctionParam).toMutableList()
            } else {
                mutableListOf()
            },
            result = if (function.returns != null) {
                classifyType(function.returns.type, function.returns.pointer)
            } else {
                IdentifierType("void")
            },
            successCodes = mutableListOf(),
            errorCodes = mutableListOf()
        )
        command.rename(renameWGPUVar(function.name))
        registry.commands.putEntityIfAbsent(command)
    }
}

private fun extractConstants(registry: Registry, constants: List<IDLConstant>) {
    for (constant in constants) {
        val mappedConstant = constantTypeMappings[constant.value]
            ?: error("Unknown constant value: ${constant.value}")

        registry.constants.putEntityIfAbsent(Constant(
            name = constant.name.uppercase(),
            ty = mappedConstant.identType,
            expr = mappedConstant.expr
        ))
    }
}

private fun extractFunctionParam(arg: IDLFunctionArg): Param = Param(
    name = renameWGPUVar(arg.name),
    ty = classifyType(arg.type, arg.pointer),
    len = null,
    optional = arg.optional
)

private fun classifyCallbackInfoType(callbackString: String): IdentifierType {
    val typeName = renameWGPUFunctionPointer(callbackString.removePrefix("callback.")) + "Info"
    return IdentifierType(typeName)
}

// https://github.com/webgpu-native/webgpu-headers/blob/bac520839ff5ed2e2b648ed540bd9ec45edbccbc/gen/utils.go#L112
private fun singularize(s: String) = if (s == "entries") "entry" else s.removeSuffix("s")

private val coreStructures = listOf(
    Structure(
        name = "WGPUStringView",
        members = mutableListOf(
            Member(
                name = "data",
                ty = PointerType(IdentifierType("char"), isConst = true, pointerToOne = false, nullable = true),
                init = null,
                len = null,
                optional = true,
                bits = null
            ),
            Member(
                name = "length",
                ty = IdentifierType("size_t"),
                init = null,
                len = null,
                optional = false,
                bits = null
            )
        )
    ),
    Structure(
        name = "WGPUChainedStruct",
        members = mutableListOf(
            Member(
                name = "next",
                ty = PointerType(IdentifierType("WGPUChainedStruct"), isConst = false, pointerToOne = false, nullable = true),
                init = null,
                len = null,
                optional = true,
                bits = null
            ),
            Member(
                name = "sType",
                ty = IdentifierType("WGPUSType"),
                init = null,
                len = null,
                optional = false,
                bits = null
            )
        )
    ),
    Structure(
        name = "WGPUChainedStructOut",
        members = mutableListOf(
            Member(
                name = "next",
                ty = PointerType(IdentifierType("WGPUChainedStructOut"), isConst = false, pointerToOne = false, nullable = true),
                init = null,
                len = null,
                optional = true,
                bits = null
            ),
            Member(
                name = "sType",
                ty = IdentifierType("WGPUSType"),
                init = null,
                len = null,
                optional = false,
                bits = null
            )
        )
    )
)
