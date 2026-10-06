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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkClusterAccelerationStructureTriangleClusterInputNV.html"><code>VkClusterAccelerationStructureTriangleClusterInputNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkClusterAccelerationStructureTriangleClusterInputNV {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkFormat vertexFormat; // @link substring="VkFormat" target="VkFormat" @link substring="vertexFormat" target="#vertexFormat"
///     uint32_t maxGeometryIndexValue; // @link substring="maxGeometryIndexValue" target="#maxGeometryIndexValue"
///     uint32_t maxClusterUniqueGeometryCount; // @link substring="maxClusterUniqueGeometryCount" target="#maxClusterUniqueGeometryCount"
///     uint32_t maxClusterTriangleCount; // @link substring="maxClusterTriangleCount" target="#maxClusterTriangleCount"
///     uint32_t maxClusterVertexCount; // @link substring="maxClusterVertexCount" target="#maxClusterVertexCount"
///     uint32_t maxTotalTriangleCount; // @link substring="maxTotalTriangleCount" target="#maxTotalTriangleCount"
///     uint32_t maxTotalVertexCount; // @link substring="maxTotalVertexCount" target="#maxTotalVertexCount"
///     uint32_t minPositionTruncateBitCount; // @link substring="minPositionTruncateBitCount" target="#minPositionTruncateBitCount"
/// } VkClusterAccelerationStructureTriangleClusterInputNV;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_CLUSTER_ACCELERATION_STRUCTURE_TRIANGLE_CLUSTER_INPUT_NV`
///
/// The {@code allocate} ({@link VkClusterAccelerationStructureTriangleClusterInputNV#allocate(Arena)}, {@link VkClusterAccelerationStructureTriangleClusterInputNV#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkClusterAccelerationStructureTriangleClusterInputNV#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkClusterAccelerationStructureTriangleClusterInputNV.html"><code>VkClusterAccelerationStructureTriangleClusterInputNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkClusterAccelerationStructureTriangleClusterInputNV(@NotNull MemorySegment segment) implements IVkClusterAccelerationStructureTriangleClusterInputNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkClusterAccelerationStructureTriangleClusterInputNV.html"><code>VkClusterAccelerationStructureTriangleClusterInputNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkClusterAccelerationStructureTriangleClusterInputNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkClusterAccelerationStructureTriangleClusterInputNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkClusterAccelerationStructureTriangleClusterInputNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkClusterAccelerationStructureTriangleClusterInputNV, Iterable<VkClusterAccelerationStructureTriangleClusterInputNV> {
        public long size() {
            return segment.byteSize() / VkClusterAccelerationStructureTriangleClusterInputNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkClusterAccelerationStructureTriangleClusterInputNV at(long index) {
            return new VkClusterAccelerationStructureTriangleClusterInputNV(segment.asSlice(index * VkClusterAccelerationStructureTriangleClusterInputNV.BYTES, VkClusterAccelerationStructureTriangleClusterInputNV.BYTES));
        }

        public VkClusterAccelerationStructureTriangleClusterInputNV.Ptr at(long index, @NotNull Consumer<@NotNull VkClusterAccelerationStructureTriangleClusterInputNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkClusterAccelerationStructureTriangleClusterInputNV value) {
            MemorySegment s = segment.asSlice(index * VkClusterAccelerationStructureTriangleClusterInputNV.BYTES, VkClusterAccelerationStructureTriangleClusterInputNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkClusterAccelerationStructureTriangleClusterInputNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkClusterAccelerationStructureTriangleClusterInputNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkClusterAccelerationStructureTriangleClusterInputNV.BYTES,
                (end - start) * VkClusterAccelerationStructureTriangleClusterInputNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkClusterAccelerationStructureTriangleClusterInputNV.BYTES));
        }

        public VkClusterAccelerationStructureTriangleClusterInputNV[] toArray() {
            VkClusterAccelerationStructureTriangleClusterInputNV[] ret = new VkClusterAccelerationStructureTriangleClusterInputNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkClusterAccelerationStructureTriangleClusterInputNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkClusterAccelerationStructureTriangleClusterInputNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkClusterAccelerationStructureTriangleClusterInputNV.BYTES;
            }

            @Override
            public VkClusterAccelerationStructureTriangleClusterInputNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkClusterAccelerationStructureTriangleClusterInputNV ret = new VkClusterAccelerationStructureTriangleClusterInputNV(segment.asSlice(0, VkClusterAccelerationStructureTriangleClusterInputNV.BYTES));
                segment = segment.asSlice(VkClusterAccelerationStructureTriangleClusterInputNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkClusterAccelerationStructureTriangleClusterInputNV allocate(Arena arena) {
        VkClusterAccelerationStructureTriangleClusterInputNV ret = new VkClusterAccelerationStructureTriangleClusterInputNV(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.CLUSTER_ACCELERATION_STRUCTURE_TRIANGLE_CLUSTER_INPUT_NV);
        return ret;
    }

    public static VkClusterAccelerationStructureTriangleClusterInputNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkClusterAccelerationStructureTriangleClusterInputNV.Ptr ret = new VkClusterAccelerationStructureTriangleClusterInputNV.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.CLUSTER_ACCELERATION_STRUCTURE_TRIANGLE_CLUSTER_INPUT_NV);
        }
        return ret;
    }

    public static VkClusterAccelerationStructureTriangleClusterInputNV clone(Arena arena, VkClusterAccelerationStructureTriangleClusterInputNV src) {
        VkClusterAccelerationStructureTriangleClusterInputNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.CLUSTER_ACCELERATION_STRUCTURE_TRIANGLE_CLUSTER_INPUT_NV);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkClusterAccelerationStructureTriangleClusterInputNV sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkClusterAccelerationStructureTriangleClusterInputNV pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkClusterAccelerationStructureTriangleClusterInputNV pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @EnumType(VkFormat.class) int vertexFormat() {
        return segment.get(LAYOUT$vertexFormat, OFFSET$vertexFormat);
    }

    public VkClusterAccelerationStructureTriangleClusterInputNV vertexFormat(@EnumType(VkFormat.class) int value) {
        segment.set(LAYOUT$vertexFormat, OFFSET$vertexFormat, value);
        return this;
    }

    public @Unsigned int maxGeometryIndexValue() {
        return segment.get(LAYOUT$maxGeometryIndexValue, OFFSET$maxGeometryIndexValue);
    }

    public VkClusterAccelerationStructureTriangleClusterInputNV maxGeometryIndexValue(@Unsigned int value) {
        segment.set(LAYOUT$maxGeometryIndexValue, OFFSET$maxGeometryIndexValue, value);
        return this;
    }

    public @Unsigned int maxClusterUniqueGeometryCount() {
        return segment.get(LAYOUT$maxClusterUniqueGeometryCount, OFFSET$maxClusterUniqueGeometryCount);
    }

    public VkClusterAccelerationStructureTriangleClusterInputNV maxClusterUniqueGeometryCount(@Unsigned int value) {
        segment.set(LAYOUT$maxClusterUniqueGeometryCount, OFFSET$maxClusterUniqueGeometryCount, value);
        return this;
    }

    public @Unsigned int maxClusterTriangleCount() {
        return segment.get(LAYOUT$maxClusterTriangleCount, OFFSET$maxClusterTriangleCount);
    }

    public VkClusterAccelerationStructureTriangleClusterInputNV maxClusterTriangleCount(@Unsigned int value) {
        segment.set(LAYOUT$maxClusterTriangleCount, OFFSET$maxClusterTriangleCount, value);
        return this;
    }

    public @Unsigned int maxClusterVertexCount() {
        return segment.get(LAYOUT$maxClusterVertexCount, OFFSET$maxClusterVertexCount);
    }

    public VkClusterAccelerationStructureTriangleClusterInputNV maxClusterVertexCount(@Unsigned int value) {
        segment.set(LAYOUT$maxClusterVertexCount, OFFSET$maxClusterVertexCount, value);
        return this;
    }

    public @Unsigned int maxTotalTriangleCount() {
        return segment.get(LAYOUT$maxTotalTriangleCount, OFFSET$maxTotalTriangleCount);
    }

    public VkClusterAccelerationStructureTriangleClusterInputNV maxTotalTriangleCount(@Unsigned int value) {
        segment.set(LAYOUT$maxTotalTriangleCount, OFFSET$maxTotalTriangleCount, value);
        return this;
    }

    public @Unsigned int maxTotalVertexCount() {
        return segment.get(LAYOUT$maxTotalVertexCount, OFFSET$maxTotalVertexCount);
    }

    public VkClusterAccelerationStructureTriangleClusterInputNV maxTotalVertexCount(@Unsigned int value) {
        segment.set(LAYOUT$maxTotalVertexCount, OFFSET$maxTotalVertexCount, value);
        return this;
    }

    public @Unsigned int minPositionTruncateBitCount() {
        return segment.get(LAYOUT$minPositionTruncateBitCount, OFFSET$minPositionTruncateBitCount);
    }

    public VkClusterAccelerationStructureTriangleClusterInputNV minPositionTruncateBitCount(@Unsigned int value) {
        segment.set(LAYOUT$minPositionTruncateBitCount, OFFSET$minPositionTruncateBitCount, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("vertexFormat"),
        ValueLayout.JAVA_INT.withName("maxGeometryIndexValue"),
        ValueLayout.JAVA_INT.withName("maxClusterUniqueGeometryCount"),
        ValueLayout.JAVA_INT.withName("maxClusterTriangleCount"),
        ValueLayout.JAVA_INT.withName("maxClusterVertexCount"),
        ValueLayout.JAVA_INT.withName("maxTotalTriangleCount"),
        ValueLayout.JAVA_INT.withName("maxTotalVertexCount"),
        ValueLayout.JAVA_INT.withName("minPositionTruncateBitCount")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$vertexFormat = PathElement.groupElement("vertexFormat");
    public static final PathElement PATH$maxGeometryIndexValue = PathElement.groupElement("maxGeometryIndexValue");
    public static final PathElement PATH$maxClusterUniqueGeometryCount = PathElement.groupElement("maxClusterUniqueGeometryCount");
    public static final PathElement PATH$maxClusterTriangleCount = PathElement.groupElement("maxClusterTriangleCount");
    public static final PathElement PATH$maxClusterVertexCount = PathElement.groupElement("maxClusterVertexCount");
    public static final PathElement PATH$maxTotalTriangleCount = PathElement.groupElement("maxTotalTriangleCount");
    public static final PathElement PATH$maxTotalVertexCount = PathElement.groupElement("maxTotalVertexCount");
    public static final PathElement PATH$minPositionTruncateBitCount = PathElement.groupElement("minPositionTruncateBitCount");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$vertexFormat = (OfInt) LAYOUT.select(PATH$vertexFormat);
    public static final OfInt LAYOUT$maxGeometryIndexValue = (OfInt) LAYOUT.select(PATH$maxGeometryIndexValue);
    public static final OfInt LAYOUT$maxClusterUniqueGeometryCount = (OfInt) LAYOUT.select(PATH$maxClusterUniqueGeometryCount);
    public static final OfInt LAYOUT$maxClusterTriangleCount = (OfInt) LAYOUT.select(PATH$maxClusterTriangleCount);
    public static final OfInt LAYOUT$maxClusterVertexCount = (OfInt) LAYOUT.select(PATH$maxClusterVertexCount);
    public static final OfInt LAYOUT$maxTotalTriangleCount = (OfInt) LAYOUT.select(PATH$maxTotalTriangleCount);
    public static final OfInt LAYOUT$maxTotalVertexCount = (OfInt) LAYOUT.select(PATH$maxTotalVertexCount);
    public static final OfInt LAYOUT$minPositionTruncateBitCount = (OfInt) LAYOUT.select(PATH$minPositionTruncateBitCount);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$vertexFormat = LAYOUT$vertexFormat.byteSize();
    public static final long SIZE$maxGeometryIndexValue = LAYOUT$maxGeometryIndexValue.byteSize();
    public static final long SIZE$maxClusterUniqueGeometryCount = LAYOUT$maxClusterUniqueGeometryCount.byteSize();
    public static final long SIZE$maxClusterTriangleCount = LAYOUT$maxClusterTriangleCount.byteSize();
    public static final long SIZE$maxClusterVertexCount = LAYOUT$maxClusterVertexCount.byteSize();
    public static final long SIZE$maxTotalTriangleCount = LAYOUT$maxTotalTriangleCount.byteSize();
    public static final long SIZE$maxTotalVertexCount = LAYOUT$maxTotalVertexCount.byteSize();
    public static final long SIZE$minPositionTruncateBitCount = LAYOUT$minPositionTruncateBitCount.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$vertexFormat = LAYOUT.byteOffset(PATH$vertexFormat);
    public static final long OFFSET$maxGeometryIndexValue = LAYOUT.byteOffset(PATH$maxGeometryIndexValue);
    public static final long OFFSET$maxClusterUniqueGeometryCount = LAYOUT.byteOffset(PATH$maxClusterUniqueGeometryCount);
    public static final long OFFSET$maxClusterTriangleCount = LAYOUT.byteOffset(PATH$maxClusterTriangleCount);
    public static final long OFFSET$maxClusterVertexCount = LAYOUT.byteOffset(PATH$maxClusterVertexCount);
    public static final long OFFSET$maxTotalTriangleCount = LAYOUT.byteOffset(PATH$maxTotalTriangleCount);
    public static final long OFFSET$maxTotalVertexCount = LAYOUT.byteOffset(PATH$maxTotalVertexCount);
    public static final long OFFSET$minPositionTruncateBitCount = LAYOUT.byteOffset(PATH$minPositionTruncateBitCount);
}
