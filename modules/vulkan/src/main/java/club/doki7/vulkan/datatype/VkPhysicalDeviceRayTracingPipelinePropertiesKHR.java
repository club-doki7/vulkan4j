package club.doki7.vulkan.datatype;

import java.lang.foreign.*;
import static java.lang.foreign.ValueLayout.*;
import java.util.List;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import club.doki7.ffm.IPointer;
import club.doki7.ffm.NativeLayout;
import club.doki7.ffm.annotation.*;
import club.doki7.ffm.ptr.*;
import club.doki7.vulkan.bitmask.*;
import club.doki7.vulkan.handle.*;
import club.doki7.vulkan.enumtype.*;
import static club.doki7.vulkan.VkConstants.*;
import club.doki7.vulkan.VkFunctionTypes.*;

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceRayTracingPipelinePropertiesKHR.html"><code>VkPhysicalDeviceRayTracingPipelinePropertiesKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceRayTracingPipelinePropertiesKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t shaderGroupHandleSize; // @link substring="shaderGroupHandleSize" target="#shaderGroupHandleSize"
///     uint32_t maxRayRecursionDepth; // @link substring="maxRayRecursionDepth" target="#maxRayRecursionDepth"
///     uint32_t maxShaderGroupStride; // @link substring="maxShaderGroupStride" target="#maxShaderGroupStride"
///     uint32_t shaderGroupBaseAlignment; // @link substring="shaderGroupBaseAlignment" target="#shaderGroupBaseAlignment"
///     uint32_t shaderGroupHandleCaptureReplaySize; // @link substring="shaderGroupHandleCaptureReplaySize" target="#shaderGroupHandleCaptureReplaySize"
///     uint32_t maxRayDispatchInvocationCount; // @link substring="maxRayDispatchInvocationCount" target="#maxRayDispatchInvocationCount"
///     uint32_t shaderGroupHandleAlignment; // @link substring="shaderGroupHandleAlignment" target="#shaderGroupHandleAlignment"
///     uint32_t maxRayHitAttributeSize; // @link substring="maxRayHitAttributeSize" target="#maxRayHitAttributeSize"
/// } VkPhysicalDeviceRayTracingPipelinePropertiesKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_RAY_TRACING_PIPELINE_PROPERTIES_KHR`
///
/// The {@code allocate} ({@link VkPhysicalDeviceRayTracingPipelinePropertiesKHR#allocate(Arena)}, {@link VkPhysicalDeviceRayTracingPipelinePropertiesKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceRayTracingPipelinePropertiesKHR#autoInit}
/// to initialize these fields manually for non-allocated instances.
///
/// ## Contracts
///
/// The property {@link #segment()} should always be not-null
/// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
/// {@code LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
/// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
///
/// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
/// perform any runtime check. The constructor can be useful for automatic code generators.
///
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceRayTracingPipelinePropertiesKHR.html"><code>VkPhysicalDeviceRayTracingPipelinePropertiesKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceRayTracingPipelinePropertiesKHR(@NotNull MemorySegment segment) implements IVkPhysicalDeviceRayTracingPipelinePropertiesKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceRayTracingPipelinePropertiesKHR.html"><code>VkPhysicalDeviceRayTracingPipelinePropertiesKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceRayTracingPipelinePropertiesKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceRayTracingPipelinePropertiesKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceRayTracingPipelinePropertiesKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceRayTracingPipelinePropertiesKHR, Iterable<VkPhysicalDeviceRayTracingPipelinePropertiesKHR> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceRayTracingPipelinePropertiesKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceRayTracingPipelinePropertiesKHR at(long index) {
            return new VkPhysicalDeviceRayTracingPipelinePropertiesKHR(segment.asSlice(index * VkPhysicalDeviceRayTracingPipelinePropertiesKHR.BYTES, VkPhysicalDeviceRayTracingPipelinePropertiesKHR.BYTES));
        }

        public VkPhysicalDeviceRayTracingPipelinePropertiesKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceRayTracingPipelinePropertiesKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceRayTracingPipelinePropertiesKHR value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceRayTracingPipelinePropertiesKHR.BYTES, VkPhysicalDeviceRayTracingPipelinePropertiesKHR.BYTES);
            s.copyFrom(value.segment);
        }

        /// Assume the {@link Ptr} is capable of holding at least {@code newSize} structures,
        /// create a new view {@link Ptr} that uses the same backing storage as this
        /// {@link Ptr}, but with the new size. Since there is actually no way to really check
        /// whether the new size is valid, while buffer overflow is undefined behavior, this method is
        /// marked as {@link Unsafe}.
        ///
        /// This method could be useful when handling data returned from some C API, where the size of
        /// the data is not known in advance.
        ///
        /// If the size of the underlying segment is actually known in advance and correctly set, and
        /// you want to create a shrunk view, you may use {@link #slice(long)} (with validation)
        /// instead.
        @Unsafe
        public @NotNull Ptr reinterpret(long newSize) {
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceRayTracingPipelinePropertiesKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceRayTracingPipelinePropertiesKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceRayTracingPipelinePropertiesKHR.BYTES,
                (end - start) * VkPhysicalDeviceRayTracingPipelinePropertiesKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceRayTracingPipelinePropertiesKHR.BYTES));
        }

        public VkPhysicalDeviceRayTracingPipelinePropertiesKHR[] toArray() {
            VkPhysicalDeviceRayTracingPipelinePropertiesKHR[] ret = new VkPhysicalDeviceRayTracingPipelinePropertiesKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceRayTracingPipelinePropertiesKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceRayTracingPipelinePropertiesKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceRayTracingPipelinePropertiesKHR.BYTES;
            }

            @Override
            public VkPhysicalDeviceRayTracingPipelinePropertiesKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceRayTracingPipelinePropertiesKHR ret = new VkPhysicalDeviceRayTracingPipelinePropertiesKHR(segment.asSlice(0, VkPhysicalDeviceRayTracingPipelinePropertiesKHR.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceRayTracingPipelinePropertiesKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceRayTracingPipelinePropertiesKHR allocate(Arena arena) {
        VkPhysicalDeviceRayTracingPipelinePropertiesKHR ret = new VkPhysicalDeviceRayTracingPipelinePropertiesKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_RAY_TRACING_PIPELINE_PROPERTIES_KHR);
        return ret;
    }

    public static VkPhysicalDeviceRayTracingPipelinePropertiesKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceRayTracingPipelinePropertiesKHR.Ptr ret = new VkPhysicalDeviceRayTracingPipelinePropertiesKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_RAY_TRACING_PIPELINE_PROPERTIES_KHR);
        }
        return ret;
    }

    public static VkPhysicalDeviceRayTracingPipelinePropertiesKHR clone(Arena arena, VkPhysicalDeviceRayTracingPipelinePropertiesKHR src) {
        VkPhysicalDeviceRayTracingPipelinePropertiesKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_RAY_TRACING_PIPELINE_PROPERTIES_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceRayTracingPipelinePropertiesKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceRayTracingPipelinePropertiesKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceRayTracingPipelinePropertiesKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int shaderGroupHandleSize() {
        return segment.get(LAYOUT$shaderGroupHandleSize, OFFSET$shaderGroupHandleSize);
    }

    public VkPhysicalDeviceRayTracingPipelinePropertiesKHR shaderGroupHandleSize(@Unsigned int value) {
        segment.set(LAYOUT$shaderGroupHandleSize, OFFSET$shaderGroupHandleSize, value);
        return this;
    }

    public @Unsigned int maxRayRecursionDepth() {
        return segment.get(LAYOUT$maxRayRecursionDepth, OFFSET$maxRayRecursionDepth);
    }

    public VkPhysicalDeviceRayTracingPipelinePropertiesKHR maxRayRecursionDepth(@Unsigned int value) {
        segment.set(LAYOUT$maxRayRecursionDepth, OFFSET$maxRayRecursionDepth, value);
        return this;
    }

    public @Unsigned int maxShaderGroupStride() {
        return segment.get(LAYOUT$maxShaderGroupStride, OFFSET$maxShaderGroupStride);
    }

    public VkPhysicalDeviceRayTracingPipelinePropertiesKHR maxShaderGroupStride(@Unsigned int value) {
        segment.set(LAYOUT$maxShaderGroupStride, OFFSET$maxShaderGroupStride, value);
        return this;
    }

    public @Unsigned int shaderGroupBaseAlignment() {
        return segment.get(LAYOUT$shaderGroupBaseAlignment, OFFSET$shaderGroupBaseAlignment);
    }

    public VkPhysicalDeviceRayTracingPipelinePropertiesKHR shaderGroupBaseAlignment(@Unsigned int value) {
        segment.set(LAYOUT$shaderGroupBaseAlignment, OFFSET$shaderGroupBaseAlignment, value);
        return this;
    }

    public @Unsigned int shaderGroupHandleCaptureReplaySize() {
        return segment.get(LAYOUT$shaderGroupHandleCaptureReplaySize, OFFSET$shaderGroupHandleCaptureReplaySize);
    }

    public VkPhysicalDeviceRayTracingPipelinePropertiesKHR shaderGroupHandleCaptureReplaySize(@Unsigned int value) {
        segment.set(LAYOUT$shaderGroupHandleCaptureReplaySize, OFFSET$shaderGroupHandleCaptureReplaySize, value);
        return this;
    }

    public @Unsigned int maxRayDispatchInvocationCount() {
        return segment.get(LAYOUT$maxRayDispatchInvocationCount, OFFSET$maxRayDispatchInvocationCount);
    }

    public VkPhysicalDeviceRayTracingPipelinePropertiesKHR maxRayDispatchInvocationCount(@Unsigned int value) {
        segment.set(LAYOUT$maxRayDispatchInvocationCount, OFFSET$maxRayDispatchInvocationCount, value);
        return this;
    }

    public @Unsigned int shaderGroupHandleAlignment() {
        return segment.get(LAYOUT$shaderGroupHandleAlignment, OFFSET$shaderGroupHandleAlignment);
    }

    public VkPhysicalDeviceRayTracingPipelinePropertiesKHR shaderGroupHandleAlignment(@Unsigned int value) {
        segment.set(LAYOUT$shaderGroupHandleAlignment, OFFSET$shaderGroupHandleAlignment, value);
        return this;
    }

    public @Unsigned int maxRayHitAttributeSize() {
        return segment.get(LAYOUT$maxRayHitAttributeSize, OFFSET$maxRayHitAttributeSize);
    }

    public VkPhysicalDeviceRayTracingPipelinePropertiesKHR maxRayHitAttributeSize(@Unsigned int value) {
        segment.set(LAYOUT$maxRayHitAttributeSize, OFFSET$maxRayHitAttributeSize, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("shaderGroupHandleSize"),
        ValueLayout.JAVA_INT.withName("maxRayRecursionDepth"),
        ValueLayout.JAVA_INT.withName("maxShaderGroupStride"),
        ValueLayout.JAVA_INT.withName("shaderGroupBaseAlignment"),
        ValueLayout.JAVA_INT.withName("shaderGroupHandleCaptureReplaySize"),
        ValueLayout.JAVA_INT.withName("maxRayDispatchInvocationCount"),
        ValueLayout.JAVA_INT.withName("shaderGroupHandleAlignment"),
        ValueLayout.JAVA_INT.withName("maxRayHitAttributeSize")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$shaderGroupHandleSize = PathElement.groupElement("shaderGroupHandleSize");
    public static final PathElement PATH$maxRayRecursionDepth = PathElement.groupElement("maxRayRecursionDepth");
    public static final PathElement PATH$maxShaderGroupStride = PathElement.groupElement("maxShaderGroupStride");
    public static final PathElement PATH$shaderGroupBaseAlignment = PathElement.groupElement("shaderGroupBaseAlignment");
    public static final PathElement PATH$shaderGroupHandleCaptureReplaySize = PathElement.groupElement("shaderGroupHandleCaptureReplaySize");
    public static final PathElement PATH$maxRayDispatchInvocationCount = PathElement.groupElement("maxRayDispatchInvocationCount");
    public static final PathElement PATH$shaderGroupHandleAlignment = PathElement.groupElement("shaderGroupHandleAlignment");
    public static final PathElement PATH$maxRayHitAttributeSize = PathElement.groupElement("maxRayHitAttributeSize");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$shaderGroupHandleSize = (OfInt) LAYOUT.select(PATH$shaderGroupHandleSize);
    public static final OfInt LAYOUT$maxRayRecursionDepth = (OfInt) LAYOUT.select(PATH$maxRayRecursionDepth);
    public static final OfInt LAYOUT$maxShaderGroupStride = (OfInt) LAYOUT.select(PATH$maxShaderGroupStride);
    public static final OfInt LAYOUT$shaderGroupBaseAlignment = (OfInt) LAYOUT.select(PATH$shaderGroupBaseAlignment);
    public static final OfInt LAYOUT$shaderGroupHandleCaptureReplaySize = (OfInt) LAYOUT.select(PATH$shaderGroupHandleCaptureReplaySize);
    public static final OfInt LAYOUT$maxRayDispatchInvocationCount = (OfInt) LAYOUT.select(PATH$maxRayDispatchInvocationCount);
    public static final OfInt LAYOUT$shaderGroupHandleAlignment = (OfInt) LAYOUT.select(PATH$shaderGroupHandleAlignment);
    public static final OfInt LAYOUT$maxRayHitAttributeSize = (OfInt) LAYOUT.select(PATH$maxRayHitAttributeSize);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$shaderGroupHandleSize = LAYOUT$shaderGroupHandleSize.byteSize();
    public static final long SIZE$maxRayRecursionDepth = LAYOUT$maxRayRecursionDepth.byteSize();
    public static final long SIZE$maxShaderGroupStride = LAYOUT$maxShaderGroupStride.byteSize();
    public static final long SIZE$shaderGroupBaseAlignment = LAYOUT$shaderGroupBaseAlignment.byteSize();
    public static final long SIZE$shaderGroupHandleCaptureReplaySize = LAYOUT$shaderGroupHandleCaptureReplaySize.byteSize();
    public static final long SIZE$maxRayDispatchInvocationCount = LAYOUT$maxRayDispatchInvocationCount.byteSize();
    public static final long SIZE$shaderGroupHandleAlignment = LAYOUT$shaderGroupHandleAlignment.byteSize();
    public static final long SIZE$maxRayHitAttributeSize = LAYOUT$maxRayHitAttributeSize.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$shaderGroupHandleSize = LAYOUT.byteOffset(PATH$shaderGroupHandleSize);
    public static final long OFFSET$maxRayRecursionDepth = LAYOUT.byteOffset(PATH$maxRayRecursionDepth);
    public static final long OFFSET$maxShaderGroupStride = LAYOUT.byteOffset(PATH$maxShaderGroupStride);
    public static final long OFFSET$shaderGroupBaseAlignment = LAYOUT.byteOffset(PATH$shaderGroupBaseAlignment);
    public static final long OFFSET$shaderGroupHandleCaptureReplaySize = LAYOUT.byteOffset(PATH$shaderGroupHandleCaptureReplaySize);
    public static final long OFFSET$maxRayDispatchInvocationCount = LAYOUT.byteOffset(PATH$maxRayDispatchInvocationCount);
    public static final long OFFSET$shaderGroupHandleAlignment = LAYOUT.byteOffset(PATH$shaderGroupHandleAlignment);
    public static final long OFFSET$maxRayHitAttributeSize = LAYOUT.byteOffset(PATH$maxRayHitAttributeSize);
}
