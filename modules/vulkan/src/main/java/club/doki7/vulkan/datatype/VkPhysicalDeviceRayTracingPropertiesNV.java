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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceRayTracingPropertiesNV.html"><code>VkPhysicalDeviceRayTracingPropertiesNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceRayTracingPropertiesNV {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t shaderGroupHandleSize; // @link substring="shaderGroupHandleSize" target="#shaderGroupHandleSize"
///     uint32_t maxRecursionDepth; // @link substring="maxRecursionDepth" target="#maxRecursionDepth"
///     uint32_t maxShaderGroupStride; // @link substring="maxShaderGroupStride" target="#maxShaderGroupStride"
///     uint32_t shaderGroupBaseAlignment; // @link substring="shaderGroupBaseAlignment" target="#shaderGroupBaseAlignment"
///     uint64_t maxGeometryCount; // @link substring="maxGeometryCount" target="#maxGeometryCount"
///     uint64_t maxInstanceCount; // @link substring="maxInstanceCount" target="#maxInstanceCount"
///     uint64_t maxTriangleCount; // @link substring="maxTriangleCount" target="#maxTriangleCount"
///     uint32_t maxDescriptorSetAccelerationStructures; // @link substring="maxDescriptorSetAccelerationStructures" target="#maxDescriptorSetAccelerationStructures"
/// } VkPhysicalDeviceRayTracingPropertiesNV;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_RAY_TRACING_PROPERTIES_NV`
///
/// The {@code allocate} ({@link VkPhysicalDeviceRayTracingPropertiesNV#allocate(Arena)}, {@link VkPhysicalDeviceRayTracingPropertiesNV#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceRayTracingPropertiesNV#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceRayTracingPropertiesNV.html"><code>VkPhysicalDeviceRayTracingPropertiesNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceRayTracingPropertiesNV(@NotNull MemorySegment segment) implements IVkPhysicalDeviceRayTracingPropertiesNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceRayTracingPropertiesNV.html"><code>VkPhysicalDeviceRayTracingPropertiesNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceRayTracingPropertiesNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceRayTracingPropertiesNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceRayTracingPropertiesNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceRayTracingPropertiesNV, Iterable<VkPhysicalDeviceRayTracingPropertiesNV> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceRayTracingPropertiesNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceRayTracingPropertiesNV at(long index) {
            return new VkPhysicalDeviceRayTracingPropertiesNV(segment.asSlice(index * VkPhysicalDeviceRayTracingPropertiesNV.BYTES, VkPhysicalDeviceRayTracingPropertiesNV.BYTES));
        }

        public VkPhysicalDeviceRayTracingPropertiesNV.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceRayTracingPropertiesNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceRayTracingPropertiesNV value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceRayTracingPropertiesNV.BYTES, VkPhysicalDeviceRayTracingPropertiesNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceRayTracingPropertiesNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceRayTracingPropertiesNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceRayTracingPropertiesNV.BYTES,
                (end - start) * VkPhysicalDeviceRayTracingPropertiesNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceRayTracingPropertiesNV.BYTES));
        }

        public VkPhysicalDeviceRayTracingPropertiesNV[] toArray() {
            VkPhysicalDeviceRayTracingPropertiesNV[] ret = new VkPhysicalDeviceRayTracingPropertiesNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceRayTracingPropertiesNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceRayTracingPropertiesNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceRayTracingPropertiesNV.BYTES;
            }

            @Override
            public VkPhysicalDeviceRayTracingPropertiesNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceRayTracingPropertiesNV ret = new VkPhysicalDeviceRayTracingPropertiesNV(segment.asSlice(0, VkPhysicalDeviceRayTracingPropertiesNV.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceRayTracingPropertiesNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceRayTracingPropertiesNV allocate(Arena arena) {
        VkPhysicalDeviceRayTracingPropertiesNV ret = new VkPhysicalDeviceRayTracingPropertiesNV(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_RAY_TRACING_PROPERTIES_NV);
        return ret;
    }

    public static VkPhysicalDeviceRayTracingPropertiesNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceRayTracingPropertiesNV.Ptr ret = new VkPhysicalDeviceRayTracingPropertiesNV.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_RAY_TRACING_PROPERTIES_NV);
        }
        return ret;
    }

    public static VkPhysicalDeviceRayTracingPropertiesNV clone(Arena arena, VkPhysicalDeviceRayTracingPropertiesNV src) {
        VkPhysicalDeviceRayTracingPropertiesNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_RAY_TRACING_PROPERTIES_NV);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceRayTracingPropertiesNV sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceRayTracingPropertiesNV pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceRayTracingPropertiesNV pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int shaderGroupHandleSize() {
        return segment.get(LAYOUT$shaderGroupHandleSize, OFFSET$shaderGroupHandleSize);
    }

    public VkPhysicalDeviceRayTracingPropertiesNV shaderGroupHandleSize(@Unsigned int value) {
        segment.set(LAYOUT$shaderGroupHandleSize, OFFSET$shaderGroupHandleSize, value);
        return this;
    }

    public @Unsigned int maxRecursionDepth() {
        return segment.get(LAYOUT$maxRecursionDepth, OFFSET$maxRecursionDepth);
    }

    public VkPhysicalDeviceRayTracingPropertiesNV maxRecursionDepth(@Unsigned int value) {
        segment.set(LAYOUT$maxRecursionDepth, OFFSET$maxRecursionDepth, value);
        return this;
    }

    public @Unsigned int maxShaderGroupStride() {
        return segment.get(LAYOUT$maxShaderGroupStride, OFFSET$maxShaderGroupStride);
    }

    public VkPhysicalDeviceRayTracingPropertiesNV maxShaderGroupStride(@Unsigned int value) {
        segment.set(LAYOUT$maxShaderGroupStride, OFFSET$maxShaderGroupStride, value);
        return this;
    }

    public @Unsigned int shaderGroupBaseAlignment() {
        return segment.get(LAYOUT$shaderGroupBaseAlignment, OFFSET$shaderGroupBaseAlignment);
    }

    public VkPhysicalDeviceRayTracingPropertiesNV shaderGroupBaseAlignment(@Unsigned int value) {
        segment.set(LAYOUT$shaderGroupBaseAlignment, OFFSET$shaderGroupBaseAlignment, value);
        return this;
    }

    public @Unsigned long maxGeometryCount() {
        return segment.get(LAYOUT$maxGeometryCount, OFFSET$maxGeometryCount);
    }

    public VkPhysicalDeviceRayTracingPropertiesNV maxGeometryCount(@Unsigned long value) {
        segment.set(LAYOUT$maxGeometryCount, OFFSET$maxGeometryCount, value);
        return this;
    }

    public @Unsigned long maxInstanceCount() {
        return segment.get(LAYOUT$maxInstanceCount, OFFSET$maxInstanceCount);
    }

    public VkPhysicalDeviceRayTracingPropertiesNV maxInstanceCount(@Unsigned long value) {
        segment.set(LAYOUT$maxInstanceCount, OFFSET$maxInstanceCount, value);
        return this;
    }

    public @Unsigned long maxTriangleCount() {
        return segment.get(LAYOUT$maxTriangleCount, OFFSET$maxTriangleCount);
    }

    public VkPhysicalDeviceRayTracingPropertiesNV maxTriangleCount(@Unsigned long value) {
        segment.set(LAYOUT$maxTriangleCount, OFFSET$maxTriangleCount, value);
        return this;
    }

    public @Unsigned int maxDescriptorSetAccelerationStructures() {
        return segment.get(LAYOUT$maxDescriptorSetAccelerationStructures, OFFSET$maxDescriptorSetAccelerationStructures);
    }

    public VkPhysicalDeviceRayTracingPropertiesNV maxDescriptorSetAccelerationStructures(@Unsigned int value) {
        segment.set(LAYOUT$maxDescriptorSetAccelerationStructures, OFFSET$maxDescriptorSetAccelerationStructures, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("shaderGroupHandleSize"),
        ValueLayout.JAVA_INT.withName("maxRecursionDepth"),
        ValueLayout.JAVA_INT.withName("maxShaderGroupStride"),
        ValueLayout.JAVA_INT.withName("shaderGroupBaseAlignment"),
        ValueLayout.JAVA_LONG.withName("maxGeometryCount"),
        ValueLayout.JAVA_LONG.withName("maxInstanceCount"),
        ValueLayout.JAVA_LONG.withName("maxTriangleCount"),
        ValueLayout.JAVA_INT.withName("maxDescriptorSetAccelerationStructures")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$shaderGroupHandleSize = PathElement.groupElement("shaderGroupHandleSize");
    public static final PathElement PATH$maxRecursionDepth = PathElement.groupElement("maxRecursionDepth");
    public static final PathElement PATH$maxShaderGroupStride = PathElement.groupElement("maxShaderGroupStride");
    public static final PathElement PATH$shaderGroupBaseAlignment = PathElement.groupElement("shaderGroupBaseAlignment");
    public static final PathElement PATH$maxGeometryCount = PathElement.groupElement("maxGeometryCount");
    public static final PathElement PATH$maxInstanceCount = PathElement.groupElement("maxInstanceCount");
    public static final PathElement PATH$maxTriangleCount = PathElement.groupElement("maxTriangleCount");
    public static final PathElement PATH$maxDescriptorSetAccelerationStructures = PathElement.groupElement("maxDescriptorSetAccelerationStructures");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$shaderGroupHandleSize = (OfInt) LAYOUT.select(PATH$shaderGroupHandleSize);
    public static final OfInt LAYOUT$maxRecursionDepth = (OfInt) LAYOUT.select(PATH$maxRecursionDepth);
    public static final OfInt LAYOUT$maxShaderGroupStride = (OfInt) LAYOUT.select(PATH$maxShaderGroupStride);
    public static final OfInt LAYOUT$shaderGroupBaseAlignment = (OfInt) LAYOUT.select(PATH$shaderGroupBaseAlignment);
    public static final OfLong LAYOUT$maxGeometryCount = (OfLong) LAYOUT.select(PATH$maxGeometryCount);
    public static final OfLong LAYOUT$maxInstanceCount = (OfLong) LAYOUT.select(PATH$maxInstanceCount);
    public static final OfLong LAYOUT$maxTriangleCount = (OfLong) LAYOUT.select(PATH$maxTriangleCount);
    public static final OfInt LAYOUT$maxDescriptorSetAccelerationStructures = (OfInt) LAYOUT.select(PATH$maxDescriptorSetAccelerationStructures);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$shaderGroupHandleSize = LAYOUT$shaderGroupHandleSize.byteSize();
    public static final long SIZE$maxRecursionDepth = LAYOUT$maxRecursionDepth.byteSize();
    public static final long SIZE$maxShaderGroupStride = LAYOUT$maxShaderGroupStride.byteSize();
    public static final long SIZE$shaderGroupBaseAlignment = LAYOUT$shaderGroupBaseAlignment.byteSize();
    public static final long SIZE$maxGeometryCount = LAYOUT$maxGeometryCount.byteSize();
    public static final long SIZE$maxInstanceCount = LAYOUT$maxInstanceCount.byteSize();
    public static final long SIZE$maxTriangleCount = LAYOUT$maxTriangleCount.byteSize();
    public static final long SIZE$maxDescriptorSetAccelerationStructures = LAYOUT$maxDescriptorSetAccelerationStructures.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$shaderGroupHandleSize = LAYOUT.byteOffset(PATH$shaderGroupHandleSize);
    public static final long OFFSET$maxRecursionDepth = LAYOUT.byteOffset(PATH$maxRecursionDepth);
    public static final long OFFSET$maxShaderGroupStride = LAYOUT.byteOffset(PATH$maxShaderGroupStride);
    public static final long OFFSET$shaderGroupBaseAlignment = LAYOUT.byteOffset(PATH$shaderGroupBaseAlignment);
    public static final long OFFSET$maxGeometryCount = LAYOUT.byteOffset(PATH$maxGeometryCount);
    public static final long OFFSET$maxInstanceCount = LAYOUT.byteOffset(PATH$maxInstanceCount);
    public static final long OFFSET$maxTriangleCount = LAYOUT.byteOffset(PATH$maxTriangleCount);
    public static final long OFFSET$maxDescriptorSetAccelerationStructures = LAYOUT.byteOffset(PATH$maxDescriptorSetAccelerationStructures);
}
