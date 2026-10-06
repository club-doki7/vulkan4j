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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX.html"><code>VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkDeviceOrHostAddressConstKHR compressedData; // @link substring="VkDeviceOrHostAddressConstKHR" target="VkDeviceOrHostAddressConstKHR" @link substring="compressedData" target="#compressedData"
///     VkDeviceSize dataSize; // @link substring="dataSize" target="#dataSize"
///     uint32_t numTriangles; // @link substring="numTriangles" target="#numTriangles"
///     uint32_t numVertices; // @link substring="numVertices" target="#numVertices"
///     uint32_t maxPrimitiveIndex; // @link substring="maxPrimitiveIndex" target="#maxPrimitiveIndex"
///     uint32_t maxGeometryIndex; // @link substring="maxGeometryIndex" target="#maxGeometryIndex"
///     VkCompressedTriangleFormatAMDX format; // @link substring="VkCompressedTriangleFormatAMDX" target="VkCompressedTriangleFormatAMDX" @link substring="format" target="#format"
/// } VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_ACCELERATION_STRUCTURE_DENSE_GEOMETRY_FORMAT_TRIANGLES_DATA_AMDX`
///
/// The {@code allocate} ({@link VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX#allocate(Arena)}, {@link VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX.html"><code>VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX(@NotNull MemorySegment segment) implements IVkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX.html"><code>VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX, Iterable<VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX> {
        public long size() {
            return segment.byteSize() / VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX at(long index) {
            return new VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX(segment.asSlice(index * VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX.BYTES, VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX.BYTES));
        }

        public VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX.Ptr at(long index, @NotNull Consumer<@NotNull VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX value) {
            MemorySegment s = segment.asSlice(index * VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX.BYTES, VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX.BYTES,
                (end - start) * VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX.BYTES));
        }

        public VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX[] toArray() {
            VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX[] ret = new VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX.BYTES;
            }

            @Override
            public VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX ret = new VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX(segment.asSlice(0, VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX.BYTES));
                segment = segment.asSlice(VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX allocate(Arena arena) {
        VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX ret = new VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.ACCELERATION_STRUCTURE_DENSE_GEOMETRY_FORMAT_TRIANGLES_DATA_AMDX);
        return ret;
    }

    public static VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX.Ptr ret = new VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.ACCELERATION_STRUCTURE_DENSE_GEOMETRY_FORMAT_TRIANGLES_DATA_AMDX);
        }
        return ret;
    }

    public static VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX clone(Arena arena, VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX src) {
        VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.ACCELERATION_STRUCTURE_DENSE_GEOMETRY_FORMAT_TRIANGLES_DATA_AMDX);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NotNull VkDeviceOrHostAddressConstKHR compressedData() {
        return new VkDeviceOrHostAddressConstKHR(segment.asSlice(OFFSET$compressedData, LAYOUT$compressedData));
    }

    public VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX compressedData(@NotNull VkDeviceOrHostAddressConstKHR value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$compressedData, SIZE$compressedData);
        return this;
    }

    public VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX compressedData(Consumer<@NotNull VkDeviceOrHostAddressConstKHR> consumer) {
        consumer.accept(compressedData());
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long dataSize() {
        return segment.get(LAYOUT$dataSize, OFFSET$dataSize);
    }

    public VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX dataSize(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$dataSize, OFFSET$dataSize, value);
        return this;
    }

    public @Unsigned int numTriangles() {
        return segment.get(LAYOUT$numTriangles, OFFSET$numTriangles);
    }

    public VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX numTriangles(@Unsigned int value) {
        segment.set(LAYOUT$numTriangles, OFFSET$numTriangles, value);
        return this;
    }

    public @Unsigned int numVertices() {
        return segment.get(LAYOUT$numVertices, OFFSET$numVertices);
    }

    public VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX numVertices(@Unsigned int value) {
        segment.set(LAYOUT$numVertices, OFFSET$numVertices, value);
        return this;
    }

    public @Unsigned int maxPrimitiveIndex() {
        return segment.get(LAYOUT$maxPrimitiveIndex, OFFSET$maxPrimitiveIndex);
    }

    public VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX maxPrimitiveIndex(@Unsigned int value) {
        segment.set(LAYOUT$maxPrimitiveIndex, OFFSET$maxPrimitiveIndex, value);
        return this;
    }

    public @Unsigned int maxGeometryIndex() {
        return segment.get(LAYOUT$maxGeometryIndex, OFFSET$maxGeometryIndex);
    }

    public VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX maxGeometryIndex(@Unsigned int value) {
        segment.set(LAYOUT$maxGeometryIndex, OFFSET$maxGeometryIndex, value);
        return this;
    }

    public @EnumType(VkCompressedTriangleFormatAMDX.class) int format() {
        return segment.get(LAYOUT$format, OFFSET$format);
    }

    public VkAccelerationStructureDenseGeometryFormatTrianglesDataAMDX format(@EnumType(VkCompressedTriangleFormatAMDX.class) int value) {
        segment.set(LAYOUT$format, OFFSET$format, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        VkDeviceOrHostAddressConstKHR.LAYOUT.withName("compressedData"),
        ValueLayout.JAVA_LONG.withName("dataSize"),
        ValueLayout.JAVA_INT.withName("numTriangles"),
        ValueLayout.JAVA_INT.withName("numVertices"),
        ValueLayout.JAVA_INT.withName("maxPrimitiveIndex"),
        ValueLayout.JAVA_INT.withName("maxGeometryIndex"),
        ValueLayout.JAVA_INT.withName("format")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$compressedData = PathElement.groupElement("compressedData");
    public static final PathElement PATH$dataSize = PathElement.groupElement("dataSize");
    public static final PathElement PATH$numTriangles = PathElement.groupElement("numTriangles");
    public static final PathElement PATH$numVertices = PathElement.groupElement("numVertices");
    public static final PathElement PATH$maxPrimitiveIndex = PathElement.groupElement("maxPrimitiveIndex");
    public static final PathElement PATH$maxGeometryIndex = PathElement.groupElement("maxGeometryIndex");
    public static final PathElement PATH$format = PathElement.groupElement("format");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final UnionLayout LAYOUT$compressedData = (UnionLayout) LAYOUT.select(PATH$compressedData);
    public static final OfLong LAYOUT$dataSize = (OfLong) LAYOUT.select(PATH$dataSize);
    public static final OfInt LAYOUT$numTriangles = (OfInt) LAYOUT.select(PATH$numTriangles);
    public static final OfInt LAYOUT$numVertices = (OfInt) LAYOUT.select(PATH$numVertices);
    public static final OfInt LAYOUT$maxPrimitiveIndex = (OfInt) LAYOUT.select(PATH$maxPrimitiveIndex);
    public static final OfInt LAYOUT$maxGeometryIndex = (OfInt) LAYOUT.select(PATH$maxGeometryIndex);
    public static final OfInt LAYOUT$format = (OfInt) LAYOUT.select(PATH$format);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$compressedData = LAYOUT$compressedData.byteSize();
    public static final long SIZE$dataSize = LAYOUT$dataSize.byteSize();
    public static final long SIZE$numTriangles = LAYOUT$numTriangles.byteSize();
    public static final long SIZE$numVertices = LAYOUT$numVertices.byteSize();
    public static final long SIZE$maxPrimitiveIndex = LAYOUT$maxPrimitiveIndex.byteSize();
    public static final long SIZE$maxGeometryIndex = LAYOUT$maxGeometryIndex.byteSize();
    public static final long SIZE$format = LAYOUT$format.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$compressedData = LAYOUT.byteOffset(PATH$compressedData);
    public static final long OFFSET$dataSize = LAYOUT.byteOffset(PATH$dataSize);
    public static final long OFFSET$numTriangles = LAYOUT.byteOffset(PATH$numTriangles);
    public static final long OFFSET$numVertices = LAYOUT.byteOffset(PATH$numVertices);
    public static final long OFFSET$maxPrimitiveIndex = LAYOUT.byteOffset(PATH$maxPrimitiveIndex);
    public static final long OFFSET$maxGeometryIndex = LAYOUT.byteOffset(PATH$maxGeometryIndex);
    public static final long OFFSET$format = LAYOUT.byteOffset(PATH$format);
}
