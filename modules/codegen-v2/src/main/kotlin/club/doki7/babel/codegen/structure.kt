package club.doki7.babel.codegen

import club.doki7.babel.codegen.accessor.*
import club.doki7.babel.ctype.*
import club.doki7.babel.ctype.lowerType
import club.doki7.sennaar.Identifier
import club.doki7.sennaar.registry.IdentifierType
import club.doki7.sennaar.registry.Member
import club.doki7.sennaar.registry.PointerType
import club.doki7.sennaar.registry.Registry
import club.doki7.sennaar.registry.Structure
import club.doki7.sennaar.registry.Type
import club.doki7.babel.util.tryFindIdentifierType
import club.doki7.babel.util.Doc
import club.doki7.babel.util.buildDoc
import club.doki7.babel.util.interfaceName
import club.doki7.sennaar.registry.ArrayType

private val Type.cDisplay: String get() = when(this) {
    is ArrayType -> "${element.cDisplay}[$length]"
    is IdentifierType -> this.ident.original
    is PointerType -> if (isConst) {
        "${pointee.cDisplay}*"
    } else {
        "${pointee.cDisplay} const*"
    }
}

/**
 * @param name the name of the layout, such as "pNext"
 */
sealed class LayoutField(
    val jLayoutType: String?,
    val name: String,
    val value: String,
) {
    abstract val layoutName: String
    abstract val sizeName: String
    abstract val pathName: String
    abstract val offsetName: String

    class Typed(
        jLayoutType: String?,
        name: String,
        value: String,
        val type: CType,
        val unresolvedType:
        Type,
        val optional: Boolean
    ) : LayoutField(jLayoutType, name, value) {
        override val layoutName: String = "LAYOUT$$name"
        override val sizeName: String = "SIZE$$name"
        override val pathName: String = "PATH$$name"
        override val offsetName: String = "OFFSET$$name"
        val rawName = "${name}Raw"
    }

    /**
     * The [name] is guaranteed to be `[bitfields.first().bitfieldName]_[bitfields.last().bitfieldName]`
     */
    class Bitfields(
        jLayoutType: String,
        name: String,
        value: String,
        val unresolvedType: Type,
        val bitfields: List<Bitfield>,
        val length: Int
    ) : LayoutField(jLayoutType, name, value) {
        override val layoutName: String = "LAYOUT\$bitfield$$name"
        override val sizeName: String = "SIZE\$bitfield$$name"
        override val pathName: String = "PATH\$bitfield$$name"
        override val offsetName: String = "OFFSET\$bitfield$$name"
    }

    data class Bitfield(val bitfieldName: String, val offset: Int, val bits: Int)
}

fun generateStructureInterface(
    structure: Structure,
    codegenOptions: CodegenOptions
) = buildDoc {
    val packageName = codegenOptions.packageName
    val className = structure.name.toString()

    +"package $packageName.datatype;"
    +""
    imports("club.doki7.ffm.IPointer")
    +""
    +"/// Auxiliary interface for unifying {@link $className} and {@link ${className}.Ptr} operations."
    +"///"
    +"/// See package level documentation for more details."
    +"public sealed interface I${className}"
    indent {
        +"extends IPointer"
        +"permits $className, ${className}.Ptr"
    }
    +"{}"
}

fun generateStructure(
    registry: Registry,
    structure: Structure,
    isUnion: Boolean,
    codegenOptions: CodegenOptions,
): Doc = buildDoc {
    val packageName = codegenOptions.packageName
    val className = structure.name.toString()
    val originalTypeName = structure.name.original
    val layouts = mutableListOf<LayoutField>()

    val importEnums = mutableSetOf<Pair<Identifier, Identifier>>()

    lowerMemberTypes(
        registry,
        codegenOptions,
        structure,
        layouts,
        importEnums
    )

    /// region import
    +"package $packageName.datatype;"
    +""
    imports("java.lang.foreign.*")
    imports("java.lang.foreign.ValueLayout.*", true)
    imports("java.util.List")
    imports("java.util.Iterator")
    imports("java.util.NoSuchElementException")
    imports("java.util.function.Consumer")

    +""
    imports("org.jetbrains.annotations.Nullable")
    imports("org.jetbrains.annotations.NotNull")
    imports("club.doki7.ffm.IPointer")
    imports("club.doki7.ffm.NativeLayout")
    if (layouts.any { it is LayoutField.Bitfields }) {
        imports("club.doki7.ffm.bits.BitfieldUtil")
    }
    imports("club.doki7.ffm.annotation.*")
    imports("club.doki7.ffm.ptr.*")

    if (registry.bitmasks.isNotEmpty()) {
        imports("$packageName.bitmask.*")
    }

    if (registry.opaqueHandleTypedefs.isNotEmpty() || registry.opaqueTypedefs.isNotEmpty()) {
        imports("$packageName.handle.*")
    }

    if (registry.enumerations.isNotEmpty()) {
        imports("$packageName.enumtype.*")
    }
    if (importEnums.isNotEmpty()) {
        for (enum in importEnums) {
            imports("$packageName.enumtype.${enum.first}.${enum.second}", true)
        }
    }

    if (registry.constants.isNotEmpty()) {
        imports("$packageName.${codegenOptions.constantClassName}.*", true)
    }

    importFunctionTypedefs(registry, codegenOptions)

    for (extra in codegenOptions.extraImport) {
        imports(extra)
    }

    +""
    /// endregion import

    val seeLink = codegenOptions.seeLinkProvider(structure)

    if (structure.doc.isNotEmpty()) {
        for (line in structure.doc) {
            +"/// $line"
        }
    } else if (seeLink != null) {
        +"/// Represents a pointer to a $seeLink structure in native memory."
    } else {
        +"/// Represents a pointer to a {@code $originalTypeName} structure in native memory."
    }
    +"///"

    +"/// ## Structure"
    +"///"
    +"/// {@snippet lang=c :"
    +"/// typedef ${if (isUnion) "union" else "struct"} $originalTypeName {"
    layouts.forEach {
        when (it) {
            is LayoutField.Bitfields -> {
                it.bitfields.forEach { bitfield ->
                    if (bitfield.bitfieldName.isUnusedReservedField()) {
                        +"///     ${it.unresolvedType.cDisplay} ${bitfield.bitfieldName} : ${bitfield.bits};"
                    } else {
                        val fieldLink = "@link substring=\"${bitfield.bitfieldName}\" target=\"#${bitfield.bitfieldName}\""
                        +"///     ${it.unresolvedType.cDisplay} ${bitfield.bitfieldName} : ${bitfield.bits}; // $fieldLink"
                    }
                }
            }
            is LayoutField.Typed -> {
                if (it.name.isUnusedReservedField()) {
                    +"///     ${it.unresolvedType.cDisplay} ${it.name};"
                } else {
                    val fieldLink = " @link substring=\"${it.name}\" target=\"#${it.name}\""
                    val maybeOptionalComment = if (it.optional) " // optional" else ""
                    val cType = it.type
                    val fieldTypeSubstring = tryFindRootNonPlainType(cType)
                    val fieldTypeTarget = if (cType is CFunctionPointerType && !cType.functionTypedef.isNativeAPI) {
                        cType.functionTypedef.interfaceName
                    } else {
                        tryFindIdentifierType(it.unresolvedType)
                    }
                    val maybeTypeLink = if (fieldTypeSubstring != null && fieldTypeTarget != null) {
                        " @link substring=\"$fieldTypeSubstring\" target=\"${fieldTypeTarget}\""
                    } else {
                        ""
                    }
                    +"///     ${it.unresolvedType.cDisplay} ${it.name};$maybeOptionalComment //$maybeTypeLink$fieldLink"
                }
            }
        }
    }
    +"/// } $originalTypeName;"
    +"/// }"
    +"///"

    val autoInitMembers = getAutoInit(structure, registry, codegenOptions, mutableSetOf())
    if (autoInitMembers != null) {
        +"/// ## Auto initialization"
        +"///"
        +"/// This structure has the following members that can be automatically initialized:"
        autoInitMembers.forEach {
            if (it.init != null) {
                +"/// - `${it.name} = ${it.init}`"
            } else {
                +"/// - `${it.name}.autoInit()`"
            }
        }
        +"///"
        +"/// The {@code allocate} ({@link $className#allocate(Arena)}, {@link $className#allocate(Arena, long)})"
        +"/// functions will automatically initialize these fields. Also, you may call {@link $className#autoInit}"
        +"/// to initialize these fields manually for non-allocated instances."
        +"///"
    }

    +"/// ## Contracts"
    +"///"
    +"/// The property {@link #segment()} should always be not-null"
    +"/// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to"
    +"/// {@code LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java"
    +"/// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details."
    +"///"
    +"/// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not"
    +"/// perform any runtime check. The constructor can be useful for automatic code generators."

    val hasMemberDoc = structure.members.any { it.doc.isNotEmpty() }
    if (hasMemberDoc) {
        +"///"
        +"/// ## Member documentation"
        +"///"
        +"/// <ul>"
        structure.members.forEach {
            if (it.doc.isNotEmpty()) {
                val first = it.doc.first()
                val following = it.doc.subList(1, it.doc.size)

                +"/// <li>{@link #${it.name}} $first${if (following.isEmpty()) "</li>" else ""}"
                if (following.isNotEmpty()) {
                    following.forEach { line ->
                        +"/// $line"
                    }
                    +"/// </li>"
                }
            }
        }
        +"/// </ul>"
    }

    if (seeLink != null) {
        +"///"
        +"/// @see $seeLink"
    }

    +"@ValueBasedCandidate"
    +"@UnsafeConstructor"
    +"public record $className(@NotNull MemorySegment segment) implements I${className} {"

    indent {
        +"/// Represents a pointer to / an array of $seeLink structure(s) in native memory."
        +"///"
        +"/// Technically speaking, this type has no difference with {@link $className}. This type"
        +"/// is introduced mainly for user to distinguish between a pointer to a single structure"
        +"/// and a pointer to (potentially) an array of structure(s). APIs should use interface"
        +"/// I$className to handle both types uniformly. See package level documentation for more"
        +"/// details."
        +"///"
        +"/// ## Contracts"
        +"///"
        +"/// The property {@link #segment()} should always be not-null"
        +"/// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to"
        +"/// {@code $className.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java"
        +"/// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details."
        +"///"
        +"/// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not"
        +"/// perform any runtime check. The constructor can be useful for automatic code generators."
        +"@ValueBasedCandidate"
        +"@UnsafeConstructor"
        +"public record Ptr(@NotNull MemorySegment segment) implements I${className}, Iterable<${className}> {"
        indent {
            defun("public", "long", "size") {
                +"return segment.byteSize() / $className.BYTES;"
            }
            +""

            +"/// Returns (a pointer to) the structure at the given index."
            +"///"
            +"/// Note that unlike {@code read} series functions ({@link IntPtr#read()} for"
            +"/// example), modification on returned structure will be reflected on the original"
            +"/// structure array. So this function is called {@code at} to explicitly"
            +"/// indicate that the returned structure is a view of the original structure."
            defun("public @NotNull", className, "at", "long index") {
                +"return new $className(segment.asSlice(index * $className.BYTES, $className.BYTES));"
            }
            +""

            defun("public", "$className.Ptr", "at", "long index", "@NotNull Consumer<@NotNull ${className}> consumer") {
                +"consumer.accept(at(index));"
                +"return this;"
            }
            +""

            defun("public", "void", "write", "long index", "@NotNull $className value") {
                +"MemorySegment s = segment.asSlice(index * $className.BYTES, $className.BYTES);"
                +"s.copyFrom(value.segment);"
            }
            +""

            +"/// Assume the {@link Ptr} is capable of holding at least {@code newSize} structures,"
            +"/// create a new view {@link Ptr} that uses the same backing storage as this"
            +"/// {@link Ptr}, but with the new size. Since there is actually no way to really check"
            +"/// whether the new size is valid, while buffer overflow is undefined behavior, this method is"
            +"/// marked as {@link Unsafe}."
            +"///"
            +"/// This method could be useful when handling data returned from some C API, where the size of"
            +"/// the data is not known in advance."
            +"///"
            +"/// If the size of the underlying segment is actually known in advance and correctly set, and"
            +"/// you want to create a shrunk view, you may use {@link #slice(long)} (with validation)"
            +"/// instead."
            +"@Unsafe"
            defun("public @NotNull", "Ptr", "reinterpret", "long newSize") {
                +"return new Ptr(segment.reinterpret(newSize * $className.BYTES));"
            }
            +""

            defun("public @NotNull", "Ptr", "offset", "long offset") {
                +"return new Ptr(segment.asSlice(offset * $className.BYTES));"
            }
            +""

            +"/// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,"
            +"/// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics"
            +"/// (offset + newSize). Be careful with the difference"
            defun("public @NotNull", "Ptr", "slice", "long start", "long end") {
                +"return new Ptr(segment.asSlice("
                indent {
                    +"start * $className.BYTES,"
                    +"(end - start) * $className.BYTES"
                }
                +"));"
            }
            +""

            defun("public", "Ptr", "slice", "long end") {
                +"return new Ptr(segment.asSlice(0, end * $className.BYTES));"
            }
            +""

            defun("public", "$className[]", "toArray") {
                +"$className[] ret = new $className[(int) size()];"
                +"for (long i = 0; i < size(); i++) {"
                indent {
                    +"ret[(int) i] = at(i);"
                }
                +"}"
                +"return ret;"
            }
            +""

            +"@Override"
            defun("public", "@NotNull Iterator<$className>", "iterator") {
                +"return new Iter(this.segment());"
            }
            +""

            +"/// An iterator over the structures."
            +"private static final class Iter implements Iterator<$className> {"
            indent {
                +"Iter(@NotNull MemorySegment segment) {"
                indent {
                    +"this.segment = segment;"
                }
                +"}"
                +""

                +"@Override"
                defun("public", "boolean", "hasNext") {
                    +"return segment.byteSize() >= $className.BYTES;"
                }
                +""

                +"@Override"
                defun("public", className, "next") {
                    +"if (!hasNext()) {"
                    indent {
                        +"throw new NoSuchElementException();"
                    }
                    +"}"
                    +"$className ret = new $className(segment.asSlice(0, $className.BYTES));"
                    +"segment = segment.asSlice($className.BYTES);"
                    +"return ret;"
                }
                +""

                +"private @NotNull MemorySegment segment;"
            }
            +"}"
        }
        +"}"
        +""

        defun("public static", className, "allocate", "Arena arena") {
            if (autoInitMembers != null) {
                +"$className ret = new $className(arena.allocate(LAYOUT));"
                if (autoInitMembers.size == 1) {
                    val it = autoInitMembers.first()
                    if (it.init != null) {
                        +"ret.${it.name}(${(it.ty as IdentifierType).ident}.${it.init});"
                    } else {
                        +"ret.${it.name}().autoInit();"
                    }
                } else {
                    +"ret.autoInit();"
                }
                +"return ret;"
            } else {
                +"return new $className(arena.allocate(LAYOUT));"
            }
        }
        +""

        defun("public static", "$className.Ptr", "allocate", "Arena arena", "long count") {
            +"MemorySegment segment = arena.allocate(LAYOUT, count);"
            if (autoInitMembers != null) {
                +"$className.Ptr ret = new $className.Ptr(segment);"
                "for (long i = 0; i < count; i++)" {
                    if (autoInitMembers.size == 1) {
                        val it = autoInitMembers.first()
                        if (it.init != null) {
                            +"ret.at(i).${it.name}(${(it.ty as IdentifierType).ident}.${it.init});"
                        } else {
                            +"ret.at(i).${it.name}().autoInit();"
                        }
                    } else {
                        +"ret.at(i).autoInit();"
                    }
                }
                +"return ret;"
            } else {
                +"return new $className.Ptr(segment);"
            }
        }
        +""

        defun("public static", className, "clone", "Arena arena", "$className src") {
            +"$className ret = allocate(arena);"
            +"ret.segment.copyFrom(src.segment);"
            +"return ret;"
        }
        +""

        if (autoInitMembers != null) {
            +"public void autoInit() {"
            indent {
                autoInitMembers.forEach {
                    if (it.init != null) {
                        +"${it.name}(${(it.ty as IdentifierType).ident}.${it.init});"
                    } else {
                        +"${it.name}().autoInit();"
                    }
                }
            }
            +"}"
            +""
        }

        layouts.forEach {
            when (it) {
                is LayoutField.Bitfields -> +generateBitfieldAccessor(className, it)
                is LayoutField.Typed -> if (!it.name.isUnusedReservedField()) {
                    +generateMemberAccessor(className, it)
                }
            }
            +""
        }

        // layout of the whole structure (or union)
        val layoutType = if (isUnion) "UnionLayout" else "StructLayout"
        val layoutCtor = if (isUnion) "NativeLayout.unionLayout" else "NativeLayout.structLayout"

        if (layouts.isEmpty()) {
            +"public static final $layoutType LAYOUT = $layoutCtor();"
        } else {
            +"public static final $layoutType LAYOUT = $layoutCtor("
            indent {
                layouts.forEachIndexed { idx, layout ->
                    if (idx == layouts.size - 1) {
                        +layout.value
                    } else {
                        +"${layout.value},"
                    }
                }
            }
            +");"
        }
        defConst("long", "BYTES", "LAYOUT.byteSize()")
        +""

        // `PathElement`s
        layouts.forEach { layout ->
            if (layout is LayoutField.Typed && layout.name.isUnusedReservedField()) {
                return@forEach
            }
            defConst("PathElement", layout.pathName, "PathElement.groupElement(\"${layout.name}\")")
        }

        +""

        // separate layouts
        layouts.forEach { layout ->
            if (layout is LayoutField.Typed && layout.name.isUnusedReservedField()) {
                return@forEach
            }
            if (layout.jLayoutType != null) {
                defConst(layout.jLayoutType, layout.layoutName, "(${layout.jLayoutType}) LAYOUT.select(${layout.pathName})")
            }
        }

        +""

        // size
        layouts.forEach { layout ->
            if (layout is LayoutField.Typed && layout.name.isUnusedReservedField()) {
                return@forEach
            }

            if (layout is LayoutField.Typed) {
                val value = if (layout.type is CPlatformDependentIntType) {
                    "${layout.type.jLayout}.byteSize()"
                } else {
                    "${layout.layoutName}.byteSize()"
                }

                defConst("long", layout.sizeName, value)
            }
        }

        +""

        // offsets
        layouts.forEach { layout ->
            if (layout is LayoutField.Typed && layout.name.isUnusedReservedField()) {
                return@forEach
            }

            defConst("long", layout.offsetName, "LAYOUT.byteOffset(${layout.pathName})")
        }
    }

    +"}"
}

internal fun String.isUnusedReservedField() = this.startsWith("reserved") && this.removePrefix("reserved").all { it.isDigit() }

private fun lowerMemberTypes(
    registry: Registry,
    codegenOptions: CodegenOptions,
    structure: Structure,
    layouts: MutableList<LayoutField>,
    importEnums: MutableSet<Pair<Identifier, Identifier>>
) {
    var i = 0
    while (i < structure.members.size) {
        val current = structure.members[i]
        val cType = lowerType(registry, codegenOptions.refRegistries, current.ty, importEnums)
        if (current.bits != null) {
            val storageUnitBits = (cType as CFixedSizeType).byteSize * 8
            var storageUnitBegin = i
            var alreadyStoredBits: Int = current.bits!!
            i += 1

            var storageUnitCounter = 0

            while (true) {
                if (i >= structure.members.size) {
                    break
                }

                val field = structure.members[i]
                if (field.bits == null) {
                    break
                }

                if (field.ty != current.ty) {
                    val fieldTypeLowered = lowerType(
                        registry,
                        codegenOptions.refRegistries,
                        field.ty
                    )

                    if ((fieldTypeLowered as CFixedSizeType).byteSize != cType.byteSize) {
                        // Quit the loop, summarize the last storage unit. The new bitfield
                        // would be handled in the next iteration of the outer loop
                        break
                    }
                }

                if (field.bits!! > storageUnitBits) {
                    error("Field ${field.name} exceeds storage unit size ($storageUnitBits)")
                }

                if (alreadyStoredBits + field.bits!! > storageUnitBits) {
                    // summarize previous bit fields
                    val storageUnitEnd = i - 1
                    summarizeBitfieldStorageUnit(
                        structure,
                        cType,
                        storageUnitBegin,
                        storageUnitEnd,
                        layouts
                    )

                    // begin a new storage unit
                    storageUnitBegin = i
                    alreadyStoredBits = 0
                    storageUnitCounter += 1
                }

                alreadyStoredBits += field.bits!!
                i += 1
            }

            // summarize the last storage unit
            val storageUnitEnd = i - 1
            summarizeBitfieldStorageUnit(
                structure,
                cType,
                storageUnitBegin,
                storageUnitEnd,
                layouts
            )
        } else {
            val identifierType = if (current.ty is PointerType) tryFindIdentifierType(current.ty) else null
            val layout = if (identifierType != null && identifierType == structure.name.toString()) {
                // avoid cyclic reference
                "ValueLayout.ADDRESS.withName(\"${current.name}\")"
            } else {
                "${cType.jLayout}.withName(\"${current.name}\")"
            }

            val layoutType = if (cType is CPlatformDependentIntType) {
                null
            } else {
                cType.jLayoutType
            }

            layouts.add(LayoutField.Typed(
                layoutType,
                current.name.toString(),
                layout,
                cType,
                current.ty,
                current.optional
            ))

            i += 1
        }
    }
}

private fun summarizeBitfieldStorageUnit(
    structure: Structure,
    storageUnitType: CType,
    storageUnitBegin: Int,
    storageUnitEnd: Int,
    layouts: MutableList<LayoutField>,
) {
    val storageUnitUnresolvedType = structure.members[storageUnitBegin].ty
    val storageUnitBeginMemberName = structure.members[storageUnitBegin].name.value
    val storageUnitEndMemberName = structure.members[storageUnitEnd].name.value

    val storageUnitName = "${storageUnitBeginMemberName}$${storageUnitEndMemberName}"
    val layout = "${storageUnitType.jLayout}.withName(\"bitfield$$storageUnitName\")"

    val bitfields = mutableListOf<LayoutField.Bitfield>()
    var bitfieldOffset = 0
    for (i in storageUnitBegin..storageUnitEnd) {
        val member = structure.members[i]
        bitfields.add(LayoutField.Bitfield(member.name.toString(), bitfieldOffset, member.bits!!))
        bitfieldOffset += member.bits!!
    }

    layouts.add(
        LayoutField.Bitfields(
            storageUnitType.jLayoutType,
            storageUnitName,
            layout,
            storageUnitUnresolvedType,
            bitfields,
            bitfieldOffset
        )
    )
}

private fun generateMemberAccessor(className: String, layout: LayoutField.Typed): Doc {
    return when (val cType = layout.type) {
        is CArrayType -> generateArrayAccessor(className, cType, layout)
        is CHandleType -> generateHandleAccessor(className, cType, layout)
        is CNonRefType -> generateNonRefAccessor(className, cType, layout)
        is CPointerType -> generatePtrAccessor(className, cType, layout)
        is CFunctionPointerType -> generatePFNAccessor(className, cType, layout)
        is CStructType -> generateStructureTypeAccessor(className, cType, layout)
        is CVoidType -> throw Exception("void type not allowed in struct")
    }
}

private fun tryFindRootNonPlainType(cType: CType): String? = when (cType) {
    is CArrayType -> tryFindRootNonPlainType(cType.element)
    is CPointerType -> tryFindRootNonPlainType(cType.pointee)
    is CFunctionPointerType -> if (cType.functionTypedef.isNativeAPI) null else cType.functionTypedef.name.value
    is CHandleType -> cType.name
    is CEnumType -> cType.name
    is CStructType -> cType.name
    is CVoidType, is CBoolType, is CFixedIntType, is CFloatType, is CPlatformDependentIntType -> null
}

private fun getAutoInit(
    structure: Structure,
    registry: Registry,
    codegenOptions: CodegenOptions,
    importEnumerations: MutableSet<Pair<Identifier, Identifier>>?
): Set<Member>? {
    if (autoInitCached.contains(structure.name)) {
        return autoInitCached[structure.name]
    }

    if (structure.members.isEmpty()) {
        return null
    }

    val autoInit = mutableSetOf<Member>()
    for (member in structure.members) {
        if (member.init != null) {
            autoInit.add(member)
            continue
        }

        val loweredType = lowerType(registry, codegenOptions.refRegistries, member.ty, importEnumerations)
        if (loweredType is CStructType
            && !loweredType.isUnion
            && getAutoInit(loweredType.structureRef, registry, codegenOptions, importEnumerations) != null) {
            autoInit.add(member)
        }
    }

    if (autoInit.isEmpty()) {
        autoInitCached[structure.name] = null
        return null
    } else {
        val ret = autoInit.toSet()
        autoInitCached[structure.name] = ret
        return autoInit
    }
}

private val autoInitCached: MutableMap<Identifier, Set<Member>?> = mutableMapOf()
