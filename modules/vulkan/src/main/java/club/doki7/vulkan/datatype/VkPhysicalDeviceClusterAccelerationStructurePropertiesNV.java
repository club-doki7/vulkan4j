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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceClusterAccelerationStructurePropertiesNV.html"><code>VkPhysicalDeviceClusterAccelerationStructurePropertiesNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceClusterAccelerationStructurePropertiesNV {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t maxVerticesPerCluster; // @link substring="maxVerticesPerCluster" target="#maxVerticesPerCluster"
///     uint32_t maxTrianglesPerCluster; // @link substring="maxTrianglesPerCluster" target="#maxTrianglesPerCluster"
///     uint32_t clusterScratchByteAlignment; // @link substring="clusterScratchByteAlignment" target="#clusterScratchByteAlignment"
///     uint32_t clusterByteAlignment; // @link substring="clusterByteAlignment" target="#clusterByteAlignment"
///     uint32_t clusterTemplateByteAlignment; // @link substring="clusterTemplateByteAlignment" target="#clusterTemplateByteAlignment"
///     uint32_t clusterBottomLevelByteAlignment; // @link substring="clusterBottomLevelByteAlignment" target="#clusterBottomLevelByteAlignment"
///     uint32_t clusterTemplateBoundsByteAlignment; // @link substring="clusterTemplateBoundsByteAlignment" target="#clusterTemplateBoundsByteAlignment"
///     uint32_t maxClusterGeometryIndex; // @link substring="maxClusterGeometryIndex" target="#maxClusterGeometryIndex"
/// } VkPhysicalDeviceClusterAccelerationStructurePropertiesNV;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_CLUSTER_ACCELERATION_STRUCTURE_PROPERTIES_NV`
///
/// The {@code allocate} ({@link VkPhysicalDeviceClusterAccelerationStructurePropertiesNV#allocate(Arena)}, {@link VkPhysicalDeviceClusterAccelerationStructurePropertiesNV#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceClusterAccelerationStructurePropertiesNV#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceClusterAccelerationStructurePropertiesNV.html"><code>VkPhysicalDeviceClusterAccelerationStructurePropertiesNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceClusterAccelerationStructurePropertiesNV(@NotNull MemorySegment segment) implements IVkPhysicalDeviceClusterAccelerationStructurePropertiesNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceClusterAccelerationStructurePropertiesNV.html"><code>VkPhysicalDeviceClusterAccelerationStructurePropertiesNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceClusterAccelerationStructurePropertiesNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceClusterAccelerationStructurePropertiesNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceClusterAccelerationStructurePropertiesNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceClusterAccelerationStructurePropertiesNV, Iterable<VkPhysicalDeviceClusterAccelerationStructurePropertiesNV> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceClusterAccelerationStructurePropertiesNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceClusterAccelerationStructurePropertiesNV at(long index) {
            return new VkPhysicalDeviceClusterAccelerationStructurePropertiesNV(segment.asSlice(index * VkPhysicalDeviceClusterAccelerationStructurePropertiesNV.BYTES, VkPhysicalDeviceClusterAccelerationStructurePropertiesNV.BYTES));
        }

        public VkPhysicalDeviceClusterAccelerationStructurePropertiesNV.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceClusterAccelerationStructurePropertiesNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceClusterAccelerationStructurePropertiesNV value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceClusterAccelerationStructurePropertiesNV.BYTES, VkPhysicalDeviceClusterAccelerationStructurePropertiesNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceClusterAccelerationStructurePropertiesNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceClusterAccelerationStructurePropertiesNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceClusterAccelerationStructurePropertiesNV.BYTES,
                (end - start) * VkPhysicalDeviceClusterAccelerationStructurePropertiesNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceClusterAccelerationStructurePropertiesNV.BYTES));
        }

        public VkPhysicalDeviceClusterAccelerationStructurePropertiesNV[] toArray() {
            VkPhysicalDeviceClusterAccelerationStructurePropertiesNV[] ret = new VkPhysicalDeviceClusterAccelerationStructurePropertiesNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceClusterAccelerationStructurePropertiesNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceClusterAccelerationStructurePropertiesNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceClusterAccelerationStructurePropertiesNV.BYTES;
            }

            @Override
            public VkPhysicalDeviceClusterAccelerationStructurePropertiesNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceClusterAccelerationStructurePropertiesNV ret = new VkPhysicalDeviceClusterAccelerationStructurePropertiesNV(segment.asSlice(0, VkPhysicalDeviceClusterAccelerationStructurePropertiesNV.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceClusterAccelerationStructurePropertiesNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceClusterAccelerationStructurePropertiesNV allocate(Arena arena) {
        VkPhysicalDeviceClusterAccelerationStructurePropertiesNV ret = new VkPhysicalDeviceClusterAccelerationStructurePropertiesNV(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_CLUSTER_ACCELERATION_STRUCTURE_PROPERTIES_NV);
        return ret;
    }

    public static VkPhysicalDeviceClusterAccelerationStructurePropertiesNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceClusterAccelerationStructurePropertiesNV.Ptr ret = new VkPhysicalDeviceClusterAccelerationStructurePropertiesNV.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_CLUSTER_ACCELERATION_STRUCTURE_PROPERTIES_NV);
        }
        return ret;
    }

    public static VkPhysicalDeviceClusterAccelerationStructurePropertiesNV clone(Arena arena, VkPhysicalDeviceClusterAccelerationStructurePropertiesNV src) {
        VkPhysicalDeviceClusterAccelerationStructurePropertiesNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_CLUSTER_ACCELERATION_STRUCTURE_PROPERTIES_NV);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceClusterAccelerationStructurePropertiesNV sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceClusterAccelerationStructurePropertiesNV pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceClusterAccelerationStructurePropertiesNV pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int maxVerticesPerCluster() {
        return segment.get(LAYOUT$maxVerticesPerCluster, OFFSET$maxVerticesPerCluster);
    }

    public VkPhysicalDeviceClusterAccelerationStructurePropertiesNV maxVerticesPerCluster(@Unsigned int value) {
        segment.set(LAYOUT$maxVerticesPerCluster, OFFSET$maxVerticesPerCluster, value);
        return this;
    }

    public @Unsigned int maxTrianglesPerCluster() {
        return segment.get(LAYOUT$maxTrianglesPerCluster, OFFSET$maxTrianglesPerCluster);
    }

    public VkPhysicalDeviceClusterAccelerationStructurePropertiesNV maxTrianglesPerCluster(@Unsigned int value) {
        segment.set(LAYOUT$maxTrianglesPerCluster, OFFSET$maxTrianglesPerCluster, value);
        return this;
    }

    public @Unsigned int clusterScratchByteAlignment() {
        return segment.get(LAYOUT$clusterScratchByteAlignment, OFFSET$clusterScratchByteAlignment);
    }

    public VkPhysicalDeviceClusterAccelerationStructurePropertiesNV clusterScratchByteAlignment(@Unsigned int value) {
        segment.set(LAYOUT$clusterScratchByteAlignment, OFFSET$clusterScratchByteAlignment, value);
        return this;
    }

    public @Unsigned int clusterByteAlignment() {
        return segment.get(LAYOUT$clusterByteAlignment, OFFSET$clusterByteAlignment);
    }

    public VkPhysicalDeviceClusterAccelerationStructurePropertiesNV clusterByteAlignment(@Unsigned int value) {
        segment.set(LAYOUT$clusterByteAlignment, OFFSET$clusterByteAlignment, value);
        return this;
    }

    public @Unsigned int clusterTemplateByteAlignment() {
        return segment.get(LAYOUT$clusterTemplateByteAlignment, OFFSET$clusterTemplateByteAlignment);
    }

    public VkPhysicalDeviceClusterAccelerationStructurePropertiesNV clusterTemplateByteAlignment(@Unsigned int value) {
        segment.set(LAYOUT$clusterTemplateByteAlignment, OFFSET$clusterTemplateByteAlignment, value);
        return this;
    }

    public @Unsigned int clusterBottomLevelByteAlignment() {
        return segment.get(LAYOUT$clusterBottomLevelByteAlignment, OFFSET$clusterBottomLevelByteAlignment);
    }

    public VkPhysicalDeviceClusterAccelerationStructurePropertiesNV clusterBottomLevelByteAlignment(@Unsigned int value) {
        segment.set(LAYOUT$clusterBottomLevelByteAlignment, OFFSET$clusterBottomLevelByteAlignment, value);
        return this;
    }

    public @Unsigned int clusterTemplateBoundsByteAlignment() {
        return segment.get(LAYOUT$clusterTemplateBoundsByteAlignment, OFFSET$clusterTemplateBoundsByteAlignment);
    }

    public VkPhysicalDeviceClusterAccelerationStructurePropertiesNV clusterTemplateBoundsByteAlignment(@Unsigned int value) {
        segment.set(LAYOUT$clusterTemplateBoundsByteAlignment, OFFSET$clusterTemplateBoundsByteAlignment, value);
        return this;
    }

    public @Unsigned int maxClusterGeometryIndex() {
        return segment.get(LAYOUT$maxClusterGeometryIndex, OFFSET$maxClusterGeometryIndex);
    }

    public VkPhysicalDeviceClusterAccelerationStructurePropertiesNV maxClusterGeometryIndex(@Unsigned int value) {
        segment.set(LAYOUT$maxClusterGeometryIndex, OFFSET$maxClusterGeometryIndex, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("maxVerticesPerCluster"),
        ValueLayout.JAVA_INT.withName("maxTrianglesPerCluster"),
        ValueLayout.JAVA_INT.withName("clusterScratchByteAlignment"),
        ValueLayout.JAVA_INT.withName("clusterByteAlignment"),
        ValueLayout.JAVA_INT.withName("clusterTemplateByteAlignment"),
        ValueLayout.JAVA_INT.withName("clusterBottomLevelByteAlignment"),
        ValueLayout.JAVA_INT.withName("clusterTemplateBoundsByteAlignment"),
        ValueLayout.JAVA_INT.withName("maxClusterGeometryIndex")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$maxVerticesPerCluster = PathElement.groupElement("maxVerticesPerCluster");
    public static final PathElement PATH$maxTrianglesPerCluster = PathElement.groupElement("maxTrianglesPerCluster");
    public static final PathElement PATH$clusterScratchByteAlignment = PathElement.groupElement("clusterScratchByteAlignment");
    public static final PathElement PATH$clusterByteAlignment = PathElement.groupElement("clusterByteAlignment");
    public static final PathElement PATH$clusterTemplateByteAlignment = PathElement.groupElement("clusterTemplateByteAlignment");
    public static final PathElement PATH$clusterBottomLevelByteAlignment = PathElement.groupElement("clusterBottomLevelByteAlignment");
    public static final PathElement PATH$clusterTemplateBoundsByteAlignment = PathElement.groupElement("clusterTemplateBoundsByteAlignment");
    public static final PathElement PATH$maxClusterGeometryIndex = PathElement.groupElement("maxClusterGeometryIndex");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$maxVerticesPerCluster = (OfInt) LAYOUT.select(PATH$maxVerticesPerCluster);
    public static final OfInt LAYOUT$maxTrianglesPerCluster = (OfInt) LAYOUT.select(PATH$maxTrianglesPerCluster);
    public static final OfInt LAYOUT$clusterScratchByteAlignment = (OfInt) LAYOUT.select(PATH$clusterScratchByteAlignment);
    public static final OfInt LAYOUT$clusterByteAlignment = (OfInt) LAYOUT.select(PATH$clusterByteAlignment);
    public static final OfInt LAYOUT$clusterTemplateByteAlignment = (OfInt) LAYOUT.select(PATH$clusterTemplateByteAlignment);
    public static final OfInt LAYOUT$clusterBottomLevelByteAlignment = (OfInt) LAYOUT.select(PATH$clusterBottomLevelByteAlignment);
    public static final OfInt LAYOUT$clusterTemplateBoundsByteAlignment = (OfInt) LAYOUT.select(PATH$clusterTemplateBoundsByteAlignment);
    public static final OfInt LAYOUT$maxClusterGeometryIndex = (OfInt) LAYOUT.select(PATH$maxClusterGeometryIndex);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$maxVerticesPerCluster = LAYOUT$maxVerticesPerCluster.byteSize();
    public static final long SIZE$maxTrianglesPerCluster = LAYOUT$maxTrianglesPerCluster.byteSize();
    public static final long SIZE$clusterScratchByteAlignment = LAYOUT$clusterScratchByteAlignment.byteSize();
    public static final long SIZE$clusterByteAlignment = LAYOUT$clusterByteAlignment.byteSize();
    public static final long SIZE$clusterTemplateByteAlignment = LAYOUT$clusterTemplateByteAlignment.byteSize();
    public static final long SIZE$clusterBottomLevelByteAlignment = LAYOUT$clusterBottomLevelByteAlignment.byteSize();
    public static final long SIZE$clusterTemplateBoundsByteAlignment = LAYOUT$clusterTemplateBoundsByteAlignment.byteSize();
    public static final long SIZE$maxClusterGeometryIndex = LAYOUT$maxClusterGeometryIndex.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$maxVerticesPerCluster = LAYOUT.byteOffset(PATH$maxVerticesPerCluster);
    public static final long OFFSET$maxTrianglesPerCluster = LAYOUT.byteOffset(PATH$maxTrianglesPerCluster);
    public static final long OFFSET$clusterScratchByteAlignment = LAYOUT.byteOffset(PATH$clusterScratchByteAlignment);
    public static final long OFFSET$clusterByteAlignment = LAYOUT.byteOffset(PATH$clusterByteAlignment);
    public static final long OFFSET$clusterTemplateByteAlignment = LAYOUT.byteOffset(PATH$clusterTemplateByteAlignment);
    public static final long OFFSET$clusterBottomLevelByteAlignment = LAYOUT.byteOffset(PATH$clusterBottomLevelByteAlignment);
    public static final long OFFSET$clusterTemplateBoundsByteAlignment = LAYOUT.byteOffset(PATH$clusterTemplateBoundsByteAlignment);
    public static final long OFFSET$maxClusterGeometryIndex = LAYOUT.byteOffset(PATH$maxClusterGeometryIndex);
}
