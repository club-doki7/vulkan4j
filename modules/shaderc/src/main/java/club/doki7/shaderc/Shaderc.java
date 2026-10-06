package club.doki7.shaderc;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;
import java.util.Objects;

import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import club.doki7.ffm.NativeLayout;
import club.doki7.ffm.RawFunctionLoader;
import club.doki7.ffm.annotation.*;
import club.doki7.ffm.ptr.*;
import club.doki7.shaderc.datatype.*;
import club.doki7.shaderc.enumtype.*;
import club.doki7.shaderc.handle.*;
import static club.doki7.shaderc.ShadercFunctionTypes.*;

public final class Shaderc {
    public Shaderc(RawFunctionLoader loader) {
        SEGMENT$shaderc_assemble_into_spv = loader.apply("shaderc_assemble_into_spv");
        HANDLE$shaderc_assemble_into_spv = RawFunctionLoader.link(SEGMENT$shaderc_assemble_into_spv, Descriptors.DESCRIPTOR$shaderc_assemble_into_spv);
        SEGMENT$shaderc_compile_into_preprocessed_text = loader.apply("shaderc_compile_into_preprocessed_text");
        HANDLE$shaderc_compile_into_preprocessed_text = RawFunctionLoader.link(SEGMENT$shaderc_compile_into_preprocessed_text, Descriptors.DESCRIPTOR$shaderc_compile_into_preprocessed_text);
        SEGMENT$shaderc_compile_into_spv = loader.apply("shaderc_compile_into_spv");
        HANDLE$shaderc_compile_into_spv = RawFunctionLoader.link(SEGMENT$shaderc_compile_into_spv, Descriptors.DESCRIPTOR$shaderc_compile_into_spv);
        SEGMENT$shaderc_compile_into_spv_assembly = loader.apply("shaderc_compile_into_spv_assembly");
        HANDLE$shaderc_compile_into_spv_assembly = RawFunctionLoader.link(SEGMENT$shaderc_compile_into_spv_assembly, Descriptors.DESCRIPTOR$shaderc_compile_into_spv_assembly);
        SEGMENT$shaderc_compile_options_add_macro_definition = loader.apply("shaderc_compile_options_add_macro_definition");
        HANDLE$shaderc_compile_options_add_macro_definition = RawFunctionLoader.link(SEGMENT$shaderc_compile_options_add_macro_definition, Descriptors.DESCRIPTOR$shaderc_compile_options_add_macro_definition);
        SEGMENT$shaderc_compile_options_clone = loader.apply("shaderc_compile_options_clone");
        HANDLE$shaderc_compile_options_clone = RawFunctionLoader.link(SEGMENT$shaderc_compile_options_clone, Descriptors.DESCRIPTOR$shaderc_compile_options_clone);
        SEGMENT$shaderc_compile_options_initialize = loader.apply("shaderc_compile_options_initialize");
        HANDLE$shaderc_compile_options_initialize = RawFunctionLoader.link(SEGMENT$shaderc_compile_options_initialize, Descriptors.DESCRIPTOR$shaderc_compile_options_initialize);
        SEGMENT$shaderc_compile_options_release = loader.apply("shaderc_compile_options_release");
        HANDLE$shaderc_compile_options_release = RawFunctionLoader.link(SEGMENT$shaderc_compile_options_release, Descriptors.DESCRIPTOR$shaderc_compile_options_release);
        SEGMENT$shaderc_compile_options_set_auto_bind_uniforms = loader.apply("shaderc_compile_options_set_auto_bind_uniforms");
        HANDLE$shaderc_compile_options_set_auto_bind_uniforms = RawFunctionLoader.link(SEGMENT$shaderc_compile_options_set_auto_bind_uniforms, Descriptors.DESCRIPTOR$shaderc_compile_options_set_auto_bind_uniforms);
        SEGMENT$shaderc_compile_options_set_auto_combined_image_sampler = loader.apply("shaderc_compile_options_set_auto_combined_image_sampler");
        HANDLE$shaderc_compile_options_set_auto_combined_image_sampler = RawFunctionLoader.link(SEGMENT$shaderc_compile_options_set_auto_combined_image_sampler, Descriptors.DESCRIPTOR$shaderc_compile_options_set_auto_combined_image_sampler);
        SEGMENT$shaderc_compile_options_set_auto_map_locations = loader.apply("shaderc_compile_options_set_auto_map_locations");
        HANDLE$shaderc_compile_options_set_auto_map_locations = RawFunctionLoader.link(SEGMENT$shaderc_compile_options_set_auto_map_locations, Descriptors.DESCRIPTOR$shaderc_compile_options_set_auto_map_locations);
        SEGMENT$shaderc_compile_options_set_binding_base = loader.apply("shaderc_compile_options_set_binding_base");
        HANDLE$shaderc_compile_options_set_binding_base = RawFunctionLoader.link(SEGMENT$shaderc_compile_options_set_binding_base, Descriptors.DESCRIPTOR$shaderc_compile_options_set_binding_base);
        SEGMENT$shaderc_compile_options_set_binding_base_for_stage = loader.apply("shaderc_compile_options_set_binding_base_for_stage");
        HANDLE$shaderc_compile_options_set_binding_base_for_stage = RawFunctionLoader.link(SEGMENT$shaderc_compile_options_set_binding_base_for_stage, Descriptors.DESCRIPTOR$shaderc_compile_options_set_binding_base_for_stage);
        SEGMENT$shaderc_compile_options_set_forced_version_profile = loader.apply("shaderc_compile_options_set_forced_version_profile");
        HANDLE$shaderc_compile_options_set_forced_version_profile = RawFunctionLoader.link(SEGMENT$shaderc_compile_options_set_forced_version_profile, Descriptors.DESCRIPTOR$shaderc_compile_options_set_forced_version_profile);
        SEGMENT$shaderc_compile_options_set_generate_debug_info = loader.apply("shaderc_compile_options_set_generate_debug_info");
        HANDLE$shaderc_compile_options_set_generate_debug_info = RawFunctionLoader.link(SEGMENT$shaderc_compile_options_set_generate_debug_info, Descriptors.DESCRIPTOR$shaderc_compile_options_set_generate_debug_info);
        SEGMENT$shaderc_compile_options_set_hlsl_16bit_types = loader.apply("shaderc_compile_options_set_hlsl_16bit_types");
        HANDLE$shaderc_compile_options_set_hlsl_16bit_types = RawFunctionLoader.link(SEGMENT$shaderc_compile_options_set_hlsl_16bit_types, Descriptors.DESCRIPTOR$shaderc_compile_options_set_hlsl_16bit_types);
        SEGMENT$shaderc_compile_options_set_hlsl_functionality1 = loader.apply("shaderc_compile_options_set_hlsl_functionality1");
        HANDLE$shaderc_compile_options_set_hlsl_functionality1 = RawFunctionLoader.link(SEGMENT$shaderc_compile_options_set_hlsl_functionality1, Descriptors.DESCRIPTOR$shaderc_compile_options_set_hlsl_functionality1);
        SEGMENT$shaderc_compile_options_set_hlsl_io_mapping = loader.apply("shaderc_compile_options_set_hlsl_io_mapping");
        HANDLE$shaderc_compile_options_set_hlsl_io_mapping = RawFunctionLoader.link(SEGMENT$shaderc_compile_options_set_hlsl_io_mapping, Descriptors.DESCRIPTOR$shaderc_compile_options_set_hlsl_io_mapping);
        SEGMENT$shaderc_compile_options_set_hlsl_offsets = loader.apply("shaderc_compile_options_set_hlsl_offsets");
        HANDLE$shaderc_compile_options_set_hlsl_offsets = RawFunctionLoader.link(SEGMENT$shaderc_compile_options_set_hlsl_offsets, Descriptors.DESCRIPTOR$shaderc_compile_options_set_hlsl_offsets);
        SEGMENT$shaderc_compile_options_set_hlsl_register_set_and_binding = loader.apply("shaderc_compile_options_set_hlsl_register_set_and_binding");
        HANDLE$shaderc_compile_options_set_hlsl_register_set_and_binding = RawFunctionLoader.link(SEGMENT$shaderc_compile_options_set_hlsl_register_set_and_binding, Descriptors.DESCRIPTOR$shaderc_compile_options_set_hlsl_register_set_and_binding);
        SEGMENT$shaderc_compile_options_set_hlsl_register_set_and_binding_for_stage = loader.apply("shaderc_compile_options_set_hlsl_register_set_and_binding_for_stage");
        HANDLE$shaderc_compile_options_set_hlsl_register_set_and_binding_for_stage = RawFunctionLoader.link(SEGMENT$shaderc_compile_options_set_hlsl_register_set_and_binding_for_stage, Descriptors.DESCRIPTOR$shaderc_compile_options_set_hlsl_register_set_and_binding_for_stage);
        SEGMENT$shaderc_compile_options_set_include_callbacks = loader.apply("shaderc_compile_options_set_include_callbacks");
        HANDLE$shaderc_compile_options_set_include_callbacks = RawFunctionLoader.link(SEGMENT$shaderc_compile_options_set_include_callbacks, Descriptors.DESCRIPTOR$shaderc_compile_options_set_include_callbacks);
        SEGMENT$shaderc_compile_options_set_invert_y = loader.apply("shaderc_compile_options_set_invert_y");
        HANDLE$shaderc_compile_options_set_invert_y = RawFunctionLoader.link(SEGMENT$shaderc_compile_options_set_invert_y, Descriptors.DESCRIPTOR$shaderc_compile_options_set_invert_y);
        SEGMENT$shaderc_compile_options_set_limit = loader.apply("shaderc_compile_options_set_limit");
        HANDLE$shaderc_compile_options_set_limit = RawFunctionLoader.link(SEGMENT$shaderc_compile_options_set_limit, Descriptors.DESCRIPTOR$shaderc_compile_options_set_limit);
        SEGMENT$shaderc_compile_options_set_max_id_bound = loader.apply("shaderc_compile_options_set_max_id_bound");
        HANDLE$shaderc_compile_options_set_max_id_bound = RawFunctionLoader.link(SEGMENT$shaderc_compile_options_set_max_id_bound, Descriptors.DESCRIPTOR$shaderc_compile_options_set_max_id_bound);
        SEGMENT$shaderc_compile_options_set_nan_clamp = loader.apply("shaderc_compile_options_set_nan_clamp");
        HANDLE$shaderc_compile_options_set_nan_clamp = RawFunctionLoader.link(SEGMENT$shaderc_compile_options_set_nan_clamp, Descriptors.DESCRIPTOR$shaderc_compile_options_set_nan_clamp);
        SEGMENT$shaderc_compile_options_set_optimization_level = loader.apply("shaderc_compile_options_set_optimization_level");
        HANDLE$shaderc_compile_options_set_optimization_level = RawFunctionLoader.link(SEGMENT$shaderc_compile_options_set_optimization_level, Descriptors.DESCRIPTOR$shaderc_compile_options_set_optimization_level);
        SEGMENT$shaderc_compile_options_set_preserve_bindings = loader.apply("shaderc_compile_options_set_preserve_bindings");
        HANDLE$shaderc_compile_options_set_preserve_bindings = RawFunctionLoader.link(SEGMENT$shaderc_compile_options_set_preserve_bindings, Descriptors.DESCRIPTOR$shaderc_compile_options_set_preserve_bindings);
        SEGMENT$shaderc_compile_options_set_source_language = loader.apply("shaderc_compile_options_set_source_language");
        HANDLE$shaderc_compile_options_set_source_language = RawFunctionLoader.link(SEGMENT$shaderc_compile_options_set_source_language, Descriptors.DESCRIPTOR$shaderc_compile_options_set_source_language);
        SEGMENT$shaderc_compile_options_set_suppress_warnings = loader.apply("shaderc_compile_options_set_suppress_warnings");
        HANDLE$shaderc_compile_options_set_suppress_warnings = RawFunctionLoader.link(SEGMENT$shaderc_compile_options_set_suppress_warnings, Descriptors.DESCRIPTOR$shaderc_compile_options_set_suppress_warnings);
        SEGMENT$shaderc_compile_options_set_target_env = loader.apply("shaderc_compile_options_set_target_env");
        HANDLE$shaderc_compile_options_set_target_env = RawFunctionLoader.link(SEGMENT$shaderc_compile_options_set_target_env, Descriptors.DESCRIPTOR$shaderc_compile_options_set_target_env);
        SEGMENT$shaderc_compile_options_set_target_spirv = loader.apply("shaderc_compile_options_set_target_spirv");
        HANDLE$shaderc_compile_options_set_target_spirv = RawFunctionLoader.link(SEGMENT$shaderc_compile_options_set_target_spirv, Descriptors.DESCRIPTOR$shaderc_compile_options_set_target_spirv);
        SEGMENT$shaderc_compile_options_set_vulkan_rules_relaxed = loader.apply("shaderc_compile_options_set_vulkan_rules_relaxed");
        HANDLE$shaderc_compile_options_set_vulkan_rules_relaxed = RawFunctionLoader.link(SEGMENT$shaderc_compile_options_set_vulkan_rules_relaxed, Descriptors.DESCRIPTOR$shaderc_compile_options_set_vulkan_rules_relaxed);
        SEGMENT$shaderc_compile_options_set_warnings_as_errors = loader.apply("shaderc_compile_options_set_warnings_as_errors");
        HANDLE$shaderc_compile_options_set_warnings_as_errors = RawFunctionLoader.link(SEGMENT$shaderc_compile_options_set_warnings_as_errors, Descriptors.DESCRIPTOR$shaderc_compile_options_set_warnings_as_errors);
        SEGMENT$shaderc_compiler_initialize = loader.apply("shaderc_compiler_initialize");
        HANDLE$shaderc_compiler_initialize = RawFunctionLoader.link(SEGMENT$shaderc_compiler_initialize, Descriptors.DESCRIPTOR$shaderc_compiler_initialize);
        SEGMENT$shaderc_compiler_release = loader.apply("shaderc_compiler_release");
        HANDLE$shaderc_compiler_release = RawFunctionLoader.link(SEGMENT$shaderc_compiler_release, Descriptors.DESCRIPTOR$shaderc_compiler_release);
        SEGMENT$shaderc_get_spv_version = loader.apply("shaderc_get_spv_version");
        HANDLE$shaderc_get_spv_version = RawFunctionLoader.link(SEGMENT$shaderc_get_spv_version, Descriptors.DESCRIPTOR$shaderc_get_spv_version);
        SEGMENT$shaderc_parse_version_profile = loader.apply("shaderc_parse_version_profile");
        HANDLE$shaderc_parse_version_profile = RawFunctionLoader.link(SEGMENT$shaderc_parse_version_profile, Descriptors.DESCRIPTOR$shaderc_parse_version_profile);
        SEGMENT$shaderc_result_get_bytes = loader.apply("shaderc_result_get_bytes");
        HANDLE$shaderc_result_get_bytes = RawFunctionLoader.link(SEGMENT$shaderc_result_get_bytes, Descriptors.DESCRIPTOR$shaderc_result_get_bytes);
        SEGMENT$shaderc_result_get_compilation_status = loader.apply("shaderc_result_get_compilation_status");
        HANDLE$shaderc_result_get_compilation_status = RawFunctionLoader.link(SEGMENT$shaderc_result_get_compilation_status, Descriptors.DESCRIPTOR$shaderc_result_get_compilation_status);
        SEGMENT$shaderc_result_get_error_message = loader.apply("shaderc_result_get_error_message");
        HANDLE$shaderc_result_get_error_message = RawFunctionLoader.link(SEGMENT$shaderc_result_get_error_message, Descriptors.DESCRIPTOR$shaderc_result_get_error_message);
        SEGMENT$shaderc_result_get_length = loader.apply("shaderc_result_get_length");
        HANDLE$shaderc_result_get_length = RawFunctionLoader.link(SEGMENT$shaderc_result_get_length, Descriptors.DESCRIPTOR$shaderc_result_get_length);
        SEGMENT$shaderc_result_get_num_errors = loader.apply("shaderc_result_get_num_errors");
        HANDLE$shaderc_result_get_num_errors = RawFunctionLoader.link(SEGMENT$shaderc_result_get_num_errors, Descriptors.DESCRIPTOR$shaderc_result_get_num_errors);
        SEGMENT$shaderc_result_get_num_warnings = loader.apply("shaderc_result_get_num_warnings");
        HANDLE$shaderc_result_get_num_warnings = RawFunctionLoader.link(SEGMENT$shaderc_result_get_num_warnings, Descriptors.DESCRIPTOR$shaderc_result_get_num_warnings);
        SEGMENT$shaderc_result_release = loader.apply("shaderc_result_release");
        HANDLE$shaderc_result_release = RawFunctionLoader.link(SEGMENT$shaderc_result_release, Descriptors.DESCRIPTOR$shaderc_result_release);
    }

    // region command wrappers

    public @Nullable ShadercCompilationResult assembleIntoSPV(
        @Nullable ShadercCompiler compiler,
        @Nullable BytePtr sourceAssembly,
        long sourceAssemblySize,
        @Nullable ShadercCompileOptions additionalOptions
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_assemble_into_spv);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (compiler != null ? compiler.segment() : MemorySegment.NULL),
                (MemorySegment) (sourceAssembly != null ? sourceAssembly.segment() : MemorySegment.NULL),
                MemorySegment.ofAddress(sourceAssemblySize),
                (MemorySegment) (additionalOptions != null ? additionalOptions.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new ShadercCompilationResult(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @Nullable ShadercCompilationResult compileIntoPreprocessedText(
        @Nullable ShadercCompiler compiler,
        @Nullable BytePtr sourceText,
        long sourceTextSize,
        @EnumType(ShadercShaderKind.class) int shaderKind,
        @Nullable BytePtr inputFileName,
        @Nullable BytePtr entryPointName,
        @Nullable ShadercCompileOptions additionalOptions
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_compile_into_preprocessed_text);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (compiler != null ? compiler.segment() : MemorySegment.NULL),
                (MemorySegment) (sourceText != null ? sourceText.segment() : MemorySegment.NULL),
                MemorySegment.ofAddress(sourceTextSize),
                shaderKind,
                (MemorySegment) (inputFileName != null ? inputFileName.segment() : MemorySegment.NULL),
                (MemorySegment) (entryPointName != null ? entryPointName.segment() : MemorySegment.NULL),
                (MemorySegment) (additionalOptions != null ? additionalOptions.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new ShadercCompilationResult(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @Nullable ShadercCompilationResult compileIntoSPV(
        @Nullable ShadercCompiler compiler,
        @Nullable BytePtr sourceText,
        long sourceTextSize,
        @EnumType(ShadercShaderKind.class) int shaderKind,
        @Nullable BytePtr inputFileName,
        @Nullable BytePtr entryPointName,
        @Nullable ShadercCompileOptions additionalOptions
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_compile_into_spv);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (compiler != null ? compiler.segment() : MemorySegment.NULL),
                (MemorySegment) (sourceText != null ? sourceText.segment() : MemorySegment.NULL),
                MemorySegment.ofAddress(sourceTextSize),
                shaderKind,
                (MemorySegment) (inputFileName != null ? inputFileName.segment() : MemorySegment.NULL),
                (MemorySegment) (entryPointName != null ? entryPointName.segment() : MemorySegment.NULL),
                (MemorySegment) (additionalOptions != null ? additionalOptions.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new ShadercCompilationResult(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @Nullable ShadercCompilationResult compileIntoSPVAssembly(
        @Nullable ShadercCompiler compiler,
        @Nullable BytePtr sourceText,
        long sourceTextSize,
        @EnumType(ShadercShaderKind.class) int shaderKind,
        @Nullable BytePtr inputFileName,
        @Nullable BytePtr entryPointName,
        @Nullable ShadercCompileOptions additionalOptions
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_compile_into_spv_assembly);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (compiler != null ? compiler.segment() : MemorySegment.NULL),
                (MemorySegment) (sourceText != null ? sourceText.segment() : MemorySegment.NULL),
                MemorySegment.ofAddress(sourceTextSize),
                shaderKind,
                (MemorySegment) (inputFileName != null ? inputFileName.segment() : MemorySegment.NULL),
                (MemorySegment) (entryPointName != null ? entryPointName.segment() : MemorySegment.NULL),
                (MemorySegment) (additionalOptions != null ? additionalOptions.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new ShadercCompilationResult(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void compileOptionsAddMacroDefinition(
        @Nullable ShadercCompileOptions options,
        @Nullable BytePtr name,
        long nameLength,
        @Nullable BytePtr value,
        long valueLength
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_compile_options_add_macro_definition);
        try {
            hFunction.invokeExact(
                (MemorySegment) (options != null ? options.segment() : MemorySegment.NULL),
                (MemorySegment) (name != null ? name.segment() : MemorySegment.NULL),
                MemorySegment.ofAddress(nameLength),
                (MemorySegment) (value != null ? value.segment() : MemorySegment.NULL),
                MemorySegment.ofAddress(valueLength)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @Nullable ShadercCompileOptions compileOptionsClone(
        @Nullable ShadercCompileOptions options
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_compile_options_clone);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (options != null ? options.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new ShadercCompileOptions(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @Nullable ShadercCompileOptions compileOptionsInitialize() {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_compile_options_initialize);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
            );
            return s.equals(MemorySegment.NULL) ? null : new ShadercCompileOptions(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void compileOptionsRelease(
        @Nullable ShadercCompileOptions options
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_compile_options_release);
        try {
            hFunction.invokeExact(
                (MemorySegment) (options != null ? options.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void compileOptionsSetAutoBindUniforms(
        @Nullable ShadercCompileOptions options,
        @NativeType("boolean") boolean autoBind
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_compile_options_set_auto_bind_uniforms);
        try {
            hFunction.invokeExact(
                (MemorySegment) (options != null ? options.segment() : MemorySegment.NULL),
                autoBind
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void compileOptionsSetAutoCombinedImageSampler(
        @Nullable ShadercCompileOptions options,
        @NativeType("boolean") boolean upgrade
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_compile_options_set_auto_combined_image_sampler);
        try {
            hFunction.invokeExact(
                (MemorySegment) (options != null ? options.segment() : MemorySegment.NULL),
                upgrade
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void compileOptionsSetAutoMapLocations(
        @Nullable ShadercCompileOptions options,
        @NativeType("boolean") boolean autoMap
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_compile_options_set_auto_map_locations);
        try {
            hFunction.invokeExact(
                (MemorySegment) (options != null ? options.segment() : MemorySegment.NULL),
                autoMap
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void compileOptionsSetBindingBase(
        @Nullable ShadercCompileOptions options,
        @EnumType(ShadercUniformKind.class) int kind,
        @Unsigned int base
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_compile_options_set_binding_base);
        try {
            hFunction.invokeExact(
                (MemorySegment) (options != null ? options.segment() : MemorySegment.NULL),
                kind,
                base
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void compileOptionsSetBindingBaseForStage(
        @Nullable ShadercCompileOptions options,
        @EnumType(ShadercShaderKind.class) int shaderKind,
        @EnumType(ShadercUniformKind.class) int kind,
        @Unsigned int base
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_compile_options_set_binding_base_for_stage);
        try {
            hFunction.invokeExact(
                (MemorySegment) (options != null ? options.segment() : MemorySegment.NULL),
                shaderKind,
                kind,
                base
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void compileOptionsSetForcedVersionProfile(
        @Nullable ShadercCompileOptions options,
        int version,
        @EnumType(ShadercProfile.class) int profile
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_compile_options_set_forced_version_profile);
        try {
            hFunction.invokeExact(
                (MemorySegment) (options != null ? options.segment() : MemorySegment.NULL),
                version,
                profile
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void compileOptionsSetGenerateDebugInfo(
        @Nullable ShadercCompileOptions options
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_compile_options_set_generate_debug_info);
        try {
            hFunction.invokeExact(
                (MemorySegment) (options != null ? options.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void compileOptionsSetHLSL16bitTypes(
        @Nullable ShadercCompileOptions options,
        @NativeType("boolean") boolean enable
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_compile_options_set_hlsl_16bit_types);
        try {
            hFunction.invokeExact(
                (MemorySegment) (options != null ? options.segment() : MemorySegment.NULL),
                enable
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void compileOptionsSetHLSLFunctionality1(
        @Nullable ShadercCompileOptions options,
        @NativeType("boolean") boolean enable
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_compile_options_set_hlsl_functionality1);
        try {
            hFunction.invokeExact(
                (MemorySegment) (options != null ? options.segment() : MemorySegment.NULL),
                enable
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void compileOptionsSetHLSLIoMapping(
        @Nullable ShadercCompileOptions options,
        @NativeType("boolean") boolean hlslIomap
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_compile_options_set_hlsl_io_mapping);
        try {
            hFunction.invokeExact(
                (MemorySegment) (options != null ? options.segment() : MemorySegment.NULL),
                hlslIomap
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void compileOptionsSetHLSLOffsets(
        @Nullable ShadercCompileOptions options,
        @NativeType("boolean") boolean hlslOffsets
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_compile_options_set_hlsl_offsets);
        try {
            hFunction.invokeExact(
                (MemorySegment) (options != null ? options.segment() : MemorySegment.NULL),
                hlslOffsets
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void compileOptionsSetHLSLRegisterSetAndBinding(
        @Nullable ShadercCompileOptions options,
        @Nullable BytePtr reg,
        @Nullable BytePtr set,
        @Nullable BytePtr binding
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_compile_options_set_hlsl_register_set_and_binding);
        try {
            hFunction.invokeExact(
                (MemorySegment) (options != null ? options.segment() : MemorySegment.NULL),
                (MemorySegment) (reg != null ? reg.segment() : MemorySegment.NULL),
                (MemorySegment) (set != null ? set.segment() : MemorySegment.NULL),
                (MemorySegment) (binding != null ? binding.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void compileOptionsSetHLSLRegisterSetAndBindingForStage(
        @Nullable ShadercCompileOptions options,
        @EnumType(ShadercShaderKind.class) int shaderKind,
        @Nullable BytePtr reg,
        @Nullable BytePtr set,
        @Nullable BytePtr binding
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_compile_options_set_hlsl_register_set_and_binding_for_stage);
        try {
            hFunction.invokeExact(
                (MemorySegment) (options != null ? options.segment() : MemorySegment.NULL),
                shaderKind,
                (MemorySegment) (reg != null ? reg.segment() : MemorySegment.NULL),
                (MemorySegment) (set != null ? set.segment() : MemorySegment.NULL),
                (MemorySegment) (binding != null ? binding.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void compileOptionsSetIncludeCallbacks(
        @Nullable ShadercCompileOptions options,
        @Pointer(comment="shaderc_include_resolve_fn") @NotNull MemorySegment resolver,
        @Pointer(comment="shaderc_include_result_release_fn") @NotNull MemorySegment resultReleaser,
        @Pointer(comment="void*") @NotNull MemorySegment userData
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_compile_options_set_include_callbacks);
        try {
            hFunction.invokeExact(
                (MemorySegment) (options != null ? options.segment() : MemorySegment.NULL),
                resolver,
                resultReleaser,
                userData
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void compileOptionsSetIncludeCallbacks(
        Arena arena,
        @Nullable ShadercCompileOptions options,
        Ishaderc_include_resolve_fn resolver,
        Ishaderc_include_result_release_fn resultReleaser,
        @Pointer(comment="void*") @NotNull MemorySegment userData
    ) {
        compileOptionsSetIncludeCallbacks(
            options,
            Ishaderc_include_resolve_fn.ofNative(arena, resolver),
            Ishaderc_include_result_release_fn.ofNative(arena, resultReleaser),
            userData
        );
    }

    public void compileOptionsSetIncludeCallbacks(
        @Nullable ShadercCompileOptions options,
        Ishaderc_include_resolve_fn resolver,
        Ishaderc_include_result_release_fn resultReleaser,
        @Pointer(comment="void*") @NotNull MemorySegment userData
    ) {
        compileOptionsSetIncludeCallbacks(
            Arena.global(),
            options,
            resolver,
            resultReleaser,
            userData
        );
    }

    public void compileOptionsSetInvertY(
        @Nullable ShadercCompileOptions options,
        @NativeType("boolean") boolean enable
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_compile_options_set_invert_y);
        try {
            hFunction.invokeExact(
                (MemorySegment) (options != null ? options.segment() : MemorySegment.NULL),
                enable
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void compileOptionsSetLimit(
        @Nullable ShadercCompileOptions options,
        @EnumType(ShadercLimit.class) int limit,
        int value
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_compile_options_set_limit);
        try {
            hFunction.invokeExact(
                (MemorySegment) (options != null ? options.segment() : MemorySegment.NULL),
                limit,
                value
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void compileOptionsSetMaxIdBound(
        @Nullable ShadercCompileOptions options,
        @Unsigned int maxIdBound
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_compile_options_set_max_id_bound);
        try {
            hFunction.invokeExact(
                (MemorySegment) (options != null ? options.segment() : MemorySegment.NULL),
                maxIdBound
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void compileOptionsSetNANClamp(
        @Nullable ShadercCompileOptions options,
        @NativeType("boolean") boolean enable
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_compile_options_set_nan_clamp);
        try {
            hFunction.invokeExact(
                (MemorySegment) (options != null ? options.segment() : MemorySegment.NULL),
                enable
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void compileOptionsSetOptimizationLevel(
        @Nullable ShadercCompileOptions options,
        @EnumType(ShadercOptimizationLevel.class) int level
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_compile_options_set_optimization_level);
        try {
            hFunction.invokeExact(
                (MemorySegment) (options != null ? options.segment() : MemorySegment.NULL),
                level
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void compileOptionsSetPreserveBindings(
        @Nullable ShadercCompileOptions options,
        @NativeType("boolean") boolean preserveBindings
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_compile_options_set_preserve_bindings);
        try {
            hFunction.invokeExact(
                (MemorySegment) (options != null ? options.segment() : MemorySegment.NULL),
                preserveBindings
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void compileOptionsSetSourceLanguage(
        @Nullable ShadercCompileOptions options,
        @EnumType(ShadercSourceLanguage.class) int lang
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_compile_options_set_source_language);
        try {
            hFunction.invokeExact(
                (MemorySegment) (options != null ? options.segment() : MemorySegment.NULL),
                lang
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void compileOptionsSetSuppressWarnings(
        @Nullable ShadercCompileOptions options
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_compile_options_set_suppress_warnings);
        try {
            hFunction.invokeExact(
                (MemorySegment) (options != null ? options.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void compileOptionsSetTargetEnv(
        @Nullable ShadercCompileOptions options,
        @EnumType(ShadercTargetEnv.class) int target,
        @Unsigned int version
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_compile_options_set_target_env);
        try {
            hFunction.invokeExact(
                (MemorySegment) (options != null ? options.segment() : MemorySegment.NULL),
                target,
                version
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void compileOptionsSetTargetSPIRV(
        @Nullable ShadercCompileOptions options,
        @EnumType(ShadercSpirvVersion.class) int version
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_compile_options_set_target_spirv);
        try {
            hFunction.invokeExact(
                (MemorySegment) (options != null ? options.segment() : MemorySegment.NULL),
                version
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void compileOptionsSetVulkanRulesRelaxed(
        @Nullable ShadercCompileOptions options,
        @NativeType("boolean") boolean enable
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_compile_options_set_vulkan_rules_relaxed);
        try {
            hFunction.invokeExact(
                (MemorySegment) (options != null ? options.segment() : MemorySegment.NULL),
                enable
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void compileOptionsSetWarningsAsErrors(
        @Nullable ShadercCompileOptions options
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_compile_options_set_warnings_as_errors);
        try {
            hFunction.invokeExact(
                (MemorySegment) (options != null ? options.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @Nullable ShadercCompiler compilerInitialize() {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_compiler_initialize);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
            );
            return s.equals(MemorySegment.NULL) ? null : new ShadercCompiler(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void compilerRelease(
        @Nullable ShadercCompiler param0
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_compiler_release);
        try {
            hFunction.invokeExact(
                (MemorySegment) (param0 != null ? param0.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void getSPVVersion(
        @Nullable IntPtr version,
        @Nullable IntPtr revision
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_get_spv_version);
        try {
            hFunction.invokeExact(
                (MemorySegment) (version != null ? version.segment() : MemorySegment.NULL),
                (MemorySegment) (revision != null ? revision.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @NativeType("boolean") boolean parseVersionProfile(
        @Nullable BytePtr str,
        @Nullable IntPtr version,
        @Nullable @EnumType(ShadercProfile.class) IntPtr profile
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_parse_version_profile);
        try {
            return (boolean) hFunction.invokeExact(
                (MemorySegment) (str != null ? str.segment() : MemorySegment.NULL),
                (MemorySegment) (version != null ? version.segment() : MemorySegment.NULL),
                (MemorySegment) (profile != null ? profile.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @Nullable BytePtr resultGetBytes(
        @Nullable ShadercCompilationResult result
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_result_get_bytes);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (result != null ? result.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new BytePtr(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @EnumType(ShadercCompilationStatus.class) int resultGetCompilationStatus(
        @Nullable ShadercCompilationResult param0
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_result_get_compilation_status);
        try {
            return (int) hFunction.invokeExact(
                (MemorySegment) (param0 != null ? param0.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public @Nullable BytePtr resultGetErrorMessage(
        @Nullable ShadercCompilationResult result
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_result_get_error_message);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (result != null ? result.segment() : MemorySegment.NULL)
            );
            return s.equals(MemorySegment.NULL) ? null : new BytePtr(s);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public long resultGetLength(
        @Nullable ShadercCompilationResult result
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_result_get_length);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (result != null ? result.segment() : MemorySegment.NULL)
            );
            return s.address();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public long resultGetNumErrors(
        @Nullable ShadercCompilationResult result
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_result_get_num_errors);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (result != null ? result.segment() : MemorySegment.NULL)
            );
            return s.address();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public long resultGetNumWarnings(
        @Nullable ShadercCompilationResult result
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_result_get_num_warnings);
        try {
            MemorySegment s = (MemorySegment) hFunction.invokeExact(
                (MemorySegment) (result != null ? result.segment() : MemorySegment.NULL)
            );
            return s.address();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void resultRelease(
        @Nullable ShadercCompilationResult result
    ) {
        MethodHandle hFunction = Objects.requireNonNull(HANDLE$shaderc_result_release);
        try {
            hFunction.invokeExact(
                (MemorySegment) (result != null ? result.segment() : MemorySegment.NULL)
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    // endregion

    // region segments and handles
    public final @Nullable MemorySegment SEGMENT$shaderc_assemble_into_spv;
    public final @Nullable MemorySegment SEGMENT$shaderc_compile_into_preprocessed_text;
    public final @Nullable MemorySegment SEGMENT$shaderc_compile_into_spv;
    public final @Nullable MemorySegment SEGMENT$shaderc_compile_into_spv_assembly;
    public final @Nullable MemorySegment SEGMENT$shaderc_compile_options_add_macro_definition;
    public final @Nullable MemorySegment SEGMENT$shaderc_compile_options_clone;
    public final @Nullable MemorySegment SEGMENT$shaderc_compile_options_initialize;
    public final @Nullable MemorySegment SEGMENT$shaderc_compile_options_release;
    public final @Nullable MemorySegment SEGMENT$shaderc_compile_options_set_auto_bind_uniforms;
    public final @Nullable MemorySegment SEGMENT$shaderc_compile_options_set_auto_combined_image_sampler;
    public final @Nullable MemorySegment SEGMENT$shaderc_compile_options_set_auto_map_locations;
    public final @Nullable MemorySegment SEGMENT$shaderc_compile_options_set_binding_base;
    public final @Nullable MemorySegment SEGMENT$shaderc_compile_options_set_binding_base_for_stage;
    public final @Nullable MemorySegment SEGMENT$shaderc_compile_options_set_forced_version_profile;
    public final @Nullable MemorySegment SEGMENT$shaderc_compile_options_set_generate_debug_info;
    public final @Nullable MemorySegment SEGMENT$shaderc_compile_options_set_hlsl_16bit_types;
    public final @Nullable MemorySegment SEGMENT$shaderc_compile_options_set_hlsl_functionality1;
    public final @Nullable MemorySegment SEGMENT$shaderc_compile_options_set_hlsl_io_mapping;
    public final @Nullable MemorySegment SEGMENT$shaderc_compile_options_set_hlsl_offsets;
    public final @Nullable MemorySegment SEGMENT$shaderc_compile_options_set_hlsl_register_set_and_binding;
    public final @Nullable MemorySegment SEGMENT$shaderc_compile_options_set_hlsl_register_set_and_binding_for_stage;
    public final @Nullable MemorySegment SEGMENT$shaderc_compile_options_set_include_callbacks;
    public final @Nullable MemorySegment SEGMENT$shaderc_compile_options_set_invert_y;
    public final @Nullable MemorySegment SEGMENT$shaderc_compile_options_set_limit;
    public final @Nullable MemorySegment SEGMENT$shaderc_compile_options_set_max_id_bound;
    public final @Nullable MemorySegment SEGMENT$shaderc_compile_options_set_nan_clamp;
    public final @Nullable MemorySegment SEGMENT$shaderc_compile_options_set_optimization_level;
    public final @Nullable MemorySegment SEGMENT$shaderc_compile_options_set_preserve_bindings;
    public final @Nullable MemorySegment SEGMENT$shaderc_compile_options_set_source_language;
    public final @Nullable MemorySegment SEGMENT$shaderc_compile_options_set_suppress_warnings;
    public final @Nullable MemorySegment SEGMENT$shaderc_compile_options_set_target_env;
    public final @Nullable MemorySegment SEGMENT$shaderc_compile_options_set_target_spirv;
    public final @Nullable MemorySegment SEGMENT$shaderc_compile_options_set_vulkan_rules_relaxed;
    public final @Nullable MemorySegment SEGMENT$shaderc_compile_options_set_warnings_as_errors;
    public final @Nullable MemorySegment SEGMENT$shaderc_compiler_initialize;
    public final @Nullable MemorySegment SEGMENT$shaderc_compiler_release;
    public final @Nullable MemorySegment SEGMENT$shaderc_get_spv_version;
    public final @Nullable MemorySegment SEGMENT$shaderc_parse_version_profile;
    public final @Nullable MemorySegment SEGMENT$shaderc_result_get_bytes;
    public final @Nullable MemorySegment SEGMENT$shaderc_result_get_compilation_status;
    public final @Nullable MemorySegment SEGMENT$shaderc_result_get_error_message;
    public final @Nullable MemorySegment SEGMENT$shaderc_result_get_length;
    public final @Nullable MemorySegment SEGMENT$shaderc_result_get_num_errors;
    public final @Nullable MemorySegment SEGMENT$shaderc_result_get_num_warnings;
    public final @Nullable MemorySegment SEGMENT$shaderc_result_release;
    public final @Nullable MethodHandle HANDLE$shaderc_assemble_into_spv;
    public final @Nullable MethodHandle HANDLE$shaderc_compile_into_preprocessed_text;
    public final @Nullable MethodHandle HANDLE$shaderc_compile_into_spv;
    public final @Nullable MethodHandle HANDLE$shaderc_compile_into_spv_assembly;
    public final @Nullable MethodHandle HANDLE$shaderc_compile_options_add_macro_definition;
    public final @Nullable MethodHandle HANDLE$shaderc_compile_options_clone;
    public final @Nullable MethodHandle HANDLE$shaderc_compile_options_initialize;
    public final @Nullable MethodHandle HANDLE$shaderc_compile_options_release;
    public final @Nullable MethodHandle HANDLE$shaderc_compile_options_set_auto_bind_uniforms;
    public final @Nullable MethodHandle HANDLE$shaderc_compile_options_set_auto_combined_image_sampler;
    public final @Nullable MethodHandle HANDLE$shaderc_compile_options_set_auto_map_locations;
    public final @Nullable MethodHandle HANDLE$shaderc_compile_options_set_binding_base;
    public final @Nullable MethodHandle HANDLE$shaderc_compile_options_set_binding_base_for_stage;
    public final @Nullable MethodHandle HANDLE$shaderc_compile_options_set_forced_version_profile;
    public final @Nullable MethodHandle HANDLE$shaderc_compile_options_set_generate_debug_info;
    public final @Nullable MethodHandle HANDLE$shaderc_compile_options_set_hlsl_16bit_types;
    public final @Nullable MethodHandle HANDLE$shaderc_compile_options_set_hlsl_functionality1;
    public final @Nullable MethodHandle HANDLE$shaderc_compile_options_set_hlsl_io_mapping;
    public final @Nullable MethodHandle HANDLE$shaderc_compile_options_set_hlsl_offsets;
    public final @Nullable MethodHandle HANDLE$shaderc_compile_options_set_hlsl_register_set_and_binding;
    public final @Nullable MethodHandle HANDLE$shaderc_compile_options_set_hlsl_register_set_and_binding_for_stage;
    public final @Nullable MethodHandle HANDLE$shaderc_compile_options_set_include_callbacks;
    public final @Nullable MethodHandle HANDLE$shaderc_compile_options_set_invert_y;
    public final @Nullable MethodHandle HANDLE$shaderc_compile_options_set_limit;
    public final @Nullable MethodHandle HANDLE$shaderc_compile_options_set_max_id_bound;
    public final @Nullable MethodHandle HANDLE$shaderc_compile_options_set_nan_clamp;
    public final @Nullable MethodHandle HANDLE$shaderc_compile_options_set_optimization_level;
    public final @Nullable MethodHandle HANDLE$shaderc_compile_options_set_preserve_bindings;
    public final @Nullable MethodHandle HANDLE$shaderc_compile_options_set_source_language;
    public final @Nullable MethodHandle HANDLE$shaderc_compile_options_set_suppress_warnings;
    public final @Nullable MethodHandle HANDLE$shaderc_compile_options_set_target_env;
    public final @Nullable MethodHandle HANDLE$shaderc_compile_options_set_target_spirv;
    public final @Nullable MethodHandle HANDLE$shaderc_compile_options_set_vulkan_rules_relaxed;
    public final @Nullable MethodHandle HANDLE$shaderc_compile_options_set_warnings_as_errors;
    public final @Nullable MethodHandle HANDLE$shaderc_compiler_initialize;
    public final @Nullable MethodHandle HANDLE$shaderc_compiler_release;
    public final @Nullable MethodHandle HANDLE$shaderc_get_spv_version;
    public final @Nullable MethodHandle HANDLE$shaderc_parse_version_profile;
    public final @Nullable MethodHandle HANDLE$shaderc_result_get_bytes;
    public final @Nullable MethodHandle HANDLE$shaderc_result_get_compilation_status;
    public final @Nullable MethodHandle HANDLE$shaderc_result_get_error_message;
    public final @Nullable MethodHandle HANDLE$shaderc_result_get_length;
    public final @Nullable MethodHandle HANDLE$shaderc_result_get_num_errors;
    public final @Nullable MethodHandle HANDLE$shaderc_result_get_num_warnings;
    public final @Nullable MethodHandle HANDLE$shaderc_result_release;
    // endregion

    public static final class Descriptors {
        public static final FunctionDescriptor DESCRIPTOR$shaderc_assemble_into_spv = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$shaderc_compile_into_preprocessed_text = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            NativeLayout.C_SIZE_T,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$shaderc_compile_into_spv = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            NativeLayout.C_SIZE_T,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$shaderc_compile_into_spv_assembly = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            NativeLayout.C_SIZE_T,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$shaderc_compile_options_add_macro_definition = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            NativeLayout.C_SIZE_T
        );

        public static final FunctionDescriptor DESCRIPTOR$shaderc_compile_options_clone = FunctionDescriptor.of(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$shaderc_compile_options_initialize = FunctionDescriptor.of(
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$shaderc_compile_options_release = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$shaderc_compile_options_set_auto_bind_uniforms = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_BOOLEAN
        );

        public static final FunctionDescriptor DESCRIPTOR$shaderc_compile_options_set_auto_combined_image_sampler = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_BOOLEAN
        );

        public static final FunctionDescriptor DESCRIPTOR$shaderc_compile_options_set_auto_map_locations = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_BOOLEAN
        );

        public static final FunctionDescriptor DESCRIPTOR$shaderc_compile_options_set_binding_base = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$shaderc_compile_options_set_binding_base_for_stage = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$shaderc_compile_options_set_forced_version_profile = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$shaderc_compile_options_set_generate_debug_info = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$shaderc_compile_options_set_hlsl_16bit_types = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_BOOLEAN
        );

        public static final FunctionDescriptor DESCRIPTOR$shaderc_compile_options_set_hlsl_functionality1 = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_BOOLEAN
        );

        public static final FunctionDescriptor DESCRIPTOR$shaderc_compile_options_set_hlsl_io_mapping = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_BOOLEAN
        );

        public static final FunctionDescriptor DESCRIPTOR$shaderc_compile_options_set_hlsl_offsets = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_BOOLEAN
        );

        public static final FunctionDescriptor DESCRIPTOR$shaderc_compile_options_set_hlsl_register_set_and_binding = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)
        );

        public static final FunctionDescriptor DESCRIPTOR$shaderc_compile_options_set_hlsl_register_set_and_binding_for_stage = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE)
        );

        public static final FunctionDescriptor DESCRIPTOR$shaderc_compile_options_set_include_callbacks = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$shaderc_compile_options_set_invert_y = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_BOOLEAN
        );

        public static final FunctionDescriptor DESCRIPTOR$shaderc_compile_options_set_limit = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$shaderc_compile_options_set_max_id_bound = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$shaderc_compile_options_set_nan_clamp = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_BOOLEAN
        );

        public static final FunctionDescriptor DESCRIPTOR$shaderc_compile_options_set_optimization_level = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$shaderc_compile_options_set_preserve_bindings = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_BOOLEAN
        );

        public static final FunctionDescriptor DESCRIPTOR$shaderc_compile_options_set_source_language = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$shaderc_compile_options_set_suppress_warnings = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$shaderc_compile_options_set_target_env = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$shaderc_compile_options_set_target_spirv = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_INT
        );

        public static final FunctionDescriptor DESCRIPTOR$shaderc_compile_options_set_vulkan_rules_relaxed = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS,
            ValueLayout.JAVA_BOOLEAN
        );

        public static final FunctionDescriptor DESCRIPTOR$shaderc_compile_options_set_warnings_as_errors = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$shaderc_compiler_initialize = FunctionDescriptor.of(
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$shaderc_compiler_release = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$shaderc_get_spv_version = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$shaderc_parse_version_profile = FunctionDescriptor.of(
            ValueLayout.JAVA_BOOLEAN,
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT),
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT)
        );

        public static final FunctionDescriptor DESCRIPTOR$shaderc_result_get_bytes = FunctionDescriptor.of(
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$shaderc_result_get_compilation_status = FunctionDescriptor.of(
            ValueLayout.JAVA_INT,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$shaderc_result_get_error_message = FunctionDescriptor.of(
            ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE),
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$shaderc_result_get_length = FunctionDescriptor.of(
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$shaderc_result_get_num_errors = FunctionDescriptor.of(
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$shaderc_result_get_num_warnings = FunctionDescriptor.of(
            NativeLayout.C_SIZE_T,
            ValueLayout.ADDRESS
        );

        public static final FunctionDescriptor DESCRIPTOR$shaderc_result_release = FunctionDescriptor.ofVoid(
            ValueLayout.ADDRESS
        );

        /// Constructing this class is nonsense so the constructor is made private.
        private Descriptors() {}
    }
}
