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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkConvertCooperativeVectorMatrixInfoNV.html"><code>VkConvertCooperativeVectorMatrixInfoNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkConvertCooperativeVectorMatrixInfoNV {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     size_t srcSize; // @link substring="srcSize" target="#srcSize"
///     VkDeviceOrHostAddressConstKHR srcData; // @link substring="VkDeviceOrHostAddressConstKHR" target="VkDeviceOrHostAddressConstKHR" @link substring="srcData" target="#srcData"
///     size_t* pDstSize; // @link substring="pDstSize" target="#pDstSize"
///     VkDeviceOrHostAddressKHR dstData; // @link substring="VkDeviceOrHostAddressKHR" target="VkDeviceOrHostAddressKHR" @link substring="dstData" target="#dstData"
///     VkComponentTypeKHR srcComponentType; // @link substring="VkComponentTypeKHR" target="VkComponentTypeKHR" @link substring="srcComponentType" target="#srcComponentType"
///     VkComponentTypeKHR dstComponentType; // @link substring="VkComponentTypeKHR" target="VkComponentTypeKHR" @link substring="dstComponentType" target="#dstComponentType"
///     uint32_t numRows; // @link substring="numRows" target="#numRows"
///     uint32_t numColumns; // @link substring="numColumns" target="#numColumns"
///     VkCooperativeVectorMatrixLayoutNV srcLayout; // @link substring="VkCooperativeVectorMatrixLayoutNV" target="VkCooperativeVectorMatrixLayoutNV" @link substring="srcLayout" target="#srcLayout"
///     size_t srcStride; // @link substring="srcStride" target="#srcStride"
///     VkCooperativeVectorMatrixLayoutNV dstLayout; // @link substring="VkCooperativeVectorMatrixLayoutNV" target="VkCooperativeVectorMatrixLayoutNV" @link substring="dstLayout" target="#dstLayout"
///     size_t dstStride; // @link substring="dstStride" target="#dstStride"
/// } VkConvertCooperativeVectorMatrixInfoNV;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_CONVERT_COOPERATIVE_VECTOR_MATRIX_INFO_NV`
///
/// The {@code allocate} ({@link VkConvertCooperativeVectorMatrixInfoNV#allocate(Arena)}, {@link VkConvertCooperativeVectorMatrixInfoNV#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkConvertCooperativeVectorMatrixInfoNV#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkConvertCooperativeVectorMatrixInfoNV.html"><code>VkConvertCooperativeVectorMatrixInfoNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkConvertCooperativeVectorMatrixInfoNV(@NotNull MemorySegment segment) implements IVkConvertCooperativeVectorMatrixInfoNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkConvertCooperativeVectorMatrixInfoNV.html"><code>VkConvertCooperativeVectorMatrixInfoNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkConvertCooperativeVectorMatrixInfoNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkConvertCooperativeVectorMatrixInfoNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkConvertCooperativeVectorMatrixInfoNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkConvertCooperativeVectorMatrixInfoNV, Iterable<VkConvertCooperativeVectorMatrixInfoNV> {
        public long size() {
            return segment.byteSize() / VkConvertCooperativeVectorMatrixInfoNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkConvertCooperativeVectorMatrixInfoNV at(long index) {
            return new VkConvertCooperativeVectorMatrixInfoNV(segment.asSlice(index * VkConvertCooperativeVectorMatrixInfoNV.BYTES, VkConvertCooperativeVectorMatrixInfoNV.BYTES));
        }

        public VkConvertCooperativeVectorMatrixInfoNV.Ptr at(long index, @NotNull Consumer<@NotNull VkConvertCooperativeVectorMatrixInfoNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkConvertCooperativeVectorMatrixInfoNV value) {
            MemorySegment s = segment.asSlice(index * VkConvertCooperativeVectorMatrixInfoNV.BYTES, VkConvertCooperativeVectorMatrixInfoNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkConvertCooperativeVectorMatrixInfoNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkConvertCooperativeVectorMatrixInfoNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkConvertCooperativeVectorMatrixInfoNV.BYTES,
                (end - start) * VkConvertCooperativeVectorMatrixInfoNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkConvertCooperativeVectorMatrixInfoNV.BYTES));
        }

        public VkConvertCooperativeVectorMatrixInfoNV[] toArray() {
            VkConvertCooperativeVectorMatrixInfoNV[] ret = new VkConvertCooperativeVectorMatrixInfoNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkConvertCooperativeVectorMatrixInfoNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkConvertCooperativeVectorMatrixInfoNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkConvertCooperativeVectorMatrixInfoNV.BYTES;
            }

            @Override
            public VkConvertCooperativeVectorMatrixInfoNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkConvertCooperativeVectorMatrixInfoNV ret = new VkConvertCooperativeVectorMatrixInfoNV(segment.asSlice(0, VkConvertCooperativeVectorMatrixInfoNV.BYTES));
                segment = segment.asSlice(VkConvertCooperativeVectorMatrixInfoNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkConvertCooperativeVectorMatrixInfoNV allocate(Arena arena) {
        VkConvertCooperativeVectorMatrixInfoNV ret = new VkConvertCooperativeVectorMatrixInfoNV(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.CONVERT_COOPERATIVE_VECTOR_MATRIX_INFO_NV);
        return ret;
    }

    public static VkConvertCooperativeVectorMatrixInfoNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkConvertCooperativeVectorMatrixInfoNV.Ptr ret = new VkConvertCooperativeVectorMatrixInfoNV.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.CONVERT_COOPERATIVE_VECTOR_MATRIX_INFO_NV);
        }
        return ret;
    }

    public static VkConvertCooperativeVectorMatrixInfoNV clone(Arena arena, VkConvertCooperativeVectorMatrixInfoNV src) {
        VkConvertCooperativeVectorMatrixInfoNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.CONVERT_COOPERATIVE_VECTOR_MATRIX_INFO_NV);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkConvertCooperativeVectorMatrixInfoNV sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkConvertCooperativeVectorMatrixInfoNV pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkConvertCooperativeVectorMatrixInfoNV pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned long srcSize() {
        return NativeLayout.readCSizeT(segment, OFFSET$srcSize);
    }

    public VkConvertCooperativeVectorMatrixInfoNV srcSize(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$srcSize, value);
        return this;
    }

    public @NotNull VkDeviceOrHostAddressConstKHR srcData() {
        return new VkDeviceOrHostAddressConstKHR(segment.asSlice(OFFSET$srcData, LAYOUT$srcData));
    }

    public VkConvertCooperativeVectorMatrixInfoNV srcData(@NotNull VkDeviceOrHostAddressConstKHR value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$srcData, SIZE$srcData);
        return this;
    }

    public VkConvertCooperativeVectorMatrixInfoNV srcData(Consumer<@NotNull VkDeviceOrHostAddressConstKHR> consumer) {
        consumer.accept(srcData());
        return this;
    }

    /// Note: the returned {@link PointerPtr} does not have correct
    /// {@link PointerPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link PointerPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable PointerPtr pDstSize() {
        MemorySegment s = pDstSizeRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new PointerPtr(s);
    }

    public VkConvertCooperativeVectorMatrixInfoNV pDstSize(@Nullable PointerPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pDstSizeRaw(s);
        return this;
    }

    public @Pointer(comment="size_t*") @NotNull MemorySegment pDstSizeRaw() {
        return segment.get(LAYOUT$pDstSize, OFFSET$pDstSize);
    }

    public void pDstSizeRaw(@Pointer(comment="size_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pDstSize, OFFSET$pDstSize, value);
    }

    public @NotNull VkDeviceOrHostAddressKHR dstData() {
        return new VkDeviceOrHostAddressKHR(segment.asSlice(OFFSET$dstData, LAYOUT$dstData));
    }

    public VkConvertCooperativeVectorMatrixInfoNV dstData(@NotNull VkDeviceOrHostAddressKHR value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$dstData, SIZE$dstData);
        return this;
    }

    public VkConvertCooperativeVectorMatrixInfoNV dstData(Consumer<@NotNull VkDeviceOrHostAddressKHR> consumer) {
        consumer.accept(dstData());
        return this;
    }

    public @EnumType(VkComponentTypeKHR.class) int srcComponentType() {
        return segment.get(LAYOUT$srcComponentType, OFFSET$srcComponentType);
    }

    public VkConvertCooperativeVectorMatrixInfoNV srcComponentType(@EnumType(VkComponentTypeKHR.class) int value) {
        segment.set(LAYOUT$srcComponentType, OFFSET$srcComponentType, value);
        return this;
    }

    public @EnumType(VkComponentTypeKHR.class) int dstComponentType() {
        return segment.get(LAYOUT$dstComponentType, OFFSET$dstComponentType);
    }

    public VkConvertCooperativeVectorMatrixInfoNV dstComponentType(@EnumType(VkComponentTypeKHR.class) int value) {
        segment.set(LAYOUT$dstComponentType, OFFSET$dstComponentType, value);
        return this;
    }

    public @Unsigned int numRows() {
        return segment.get(LAYOUT$numRows, OFFSET$numRows);
    }

    public VkConvertCooperativeVectorMatrixInfoNV numRows(@Unsigned int value) {
        segment.set(LAYOUT$numRows, OFFSET$numRows, value);
        return this;
    }

    public @Unsigned int numColumns() {
        return segment.get(LAYOUT$numColumns, OFFSET$numColumns);
    }

    public VkConvertCooperativeVectorMatrixInfoNV numColumns(@Unsigned int value) {
        segment.set(LAYOUT$numColumns, OFFSET$numColumns, value);
        return this;
    }

    public @EnumType(VkCooperativeVectorMatrixLayoutNV.class) int srcLayout() {
        return segment.get(LAYOUT$srcLayout, OFFSET$srcLayout);
    }

    public VkConvertCooperativeVectorMatrixInfoNV srcLayout(@EnumType(VkCooperativeVectorMatrixLayoutNV.class) int value) {
        segment.set(LAYOUT$srcLayout, OFFSET$srcLayout, value);
        return this;
    }

    public @Unsigned long srcStride() {
        return NativeLayout.readCSizeT(segment, OFFSET$srcStride);
    }

    public VkConvertCooperativeVectorMatrixInfoNV srcStride(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$srcStride, value);
        return this;
    }

    public @EnumType(VkCooperativeVectorMatrixLayoutNV.class) int dstLayout() {
        return segment.get(LAYOUT$dstLayout, OFFSET$dstLayout);
    }

    public VkConvertCooperativeVectorMatrixInfoNV dstLayout(@EnumType(VkCooperativeVectorMatrixLayoutNV.class) int value) {
        segment.set(LAYOUT$dstLayout, OFFSET$dstLayout, value);
        return this;
    }

    public @Unsigned long dstStride() {
        return NativeLayout.readCSizeT(segment, OFFSET$dstStride);
    }

    public VkConvertCooperativeVectorMatrixInfoNV dstStride(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$dstStride, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        NativeLayout.C_SIZE_T.withName("srcSize"),
        VkDeviceOrHostAddressConstKHR.LAYOUT.withName("srcData"),
        ValueLayout.ADDRESS.withTargetLayout(NativeLayout.C_SIZE_T).withName("pDstSize"),
        VkDeviceOrHostAddressKHR.LAYOUT.withName("dstData"),
        ValueLayout.JAVA_INT.withName("srcComponentType"),
        ValueLayout.JAVA_INT.withName("dstComponentType"),
        ValueLayout.JAVA_INT.withName("numRows"),
        ValueLayout.JAVA_INT.withName("numColumns"),
        ValueLayout.JAVA_INT.withName("srcLayout"),
        NativeLayout.C_SIZE_T.withName("srcStride"),
        ValueLayout.JAVA_INT.withName("dstLayout"),
        NativeLayout.C_SIZE_T.withName("dstStride")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$srcSize = PathElement.groupElement("srcSize");
    public static final PathElement PATH$srcData = PathElement.groupElement("srcData");
    public static final PathElement PATH$pDstSize = PathElement.groupElement("pDstSize");
    public static final PathElement PATH$dstData = PathElement.groupElement("dstData");
    public static final PathElement PATH$srcComponentType = PathElement.groupElement("srcComponentType");
    public static final PathElement PATH$dstComponentType = PathElement.groupElement("dstComponentType");
    public static final PathElement PATH$numRows = PathElement.groupElement("numRows");
    public static final PathElement PATH$numColumns = PathElement.groupElement("numColumns");
    public static final PathElement PATH$srcLayout = PathElement.groupElement("srcLayout");
    public static final PathElement PATH$srcStride = PathElement.groupElement("srcStride");
    public static final PathElement PATH$dstLayout = PathElement.groupElement("dstLayout");
    public static final PathElement PATH$dstStride = PathElement.groupElement("dstStride");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final UnionLayout LAYOUT$srcData = (UnionLayout) LAYOUT.select(PATH$srcData);
    public static final AddressLayout LAYOUT$pDstSize = (AddressLayout) LAYOUT.select(PATH$pDstSize);
    public static final UnionLayout LAYOUT$dstData = (UnionLayout) LAYOUT.select(PATH$dstData);
    public static final OfInt LAYOUT$srcComponentType = (OfInt) LAYOUT.select(PATH$srcComponentType);
    public static final OfInt LAYOUT$dstComponentType = (OfInt) LAYOUT.select(PATH$dstComponentType);
    public static final OfInt LAYOUT$numRows = (OfInt) LAYOUT.select(PATH$numRows);
    public static final OfInt LAYOUT$numColumns = (OfInt) LAYOUT.select(PATH$numColumns);
    public static final OfInt LAYOUT$srcLayout = (OfInt) LAYOUT.select(PATH$srcLayout);
    public static final OfInt LAYOUT$dstLayout = (OfInt) LAYOUT.select(PATH$dstLayout);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$srcSize = NativeLayout.C_SIZE_T.byteSize();
    public static final long SIZE$srcData = LAYOUT$srcData.byteSize();
    public static final long SIZE$pDstSize = LAYOUT$pDstSize.byteSize();
    public static final long SIZE$dstData = LAYOUT$dstData.byteSize();
    public static final long SIZE$srcComponentType = LAYOUT$srcComponentType.byteSize();
    public static final long SIZE$dstComponentType = LAYOUT$dstComponentType.byteSize();
    public static final long SIZE$numRows = LAYOUT$numRows.byteSize();
    public static final long SIZE$numColumns = LAYOUT$numColumns.byteSize();
    public static final long SIZE$srcLayout = LAYOUT$srcLayout.byteSize();
    public static final long SIZE$srcStride = NativeLayout.C_SIZE_T.byteSize();
    public static final long SIZE$dstLayout = LAYOUT$dstLayout.byteSize();
    public static final long SIZE$dstStride = NativeLayout.C_SIZE_T.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$srcSize = LAYOUT.byteOffset(PATH$srcSize);
    public static final long OFFSET$srcData = LAYOUT.byteOffset(PATH$srcData);
    public static final long OFFSET$pDstSize = LAYOUT.byteOffset(PATH$pDstSize);
    public static final long OFFSET$dstData = LAYOUT.byteOffset(PATH$dstData);
    public static final long OFFSET$srcComponentType = LAYOUT.byteOffset(PATH$srcComponentType);
    public static final long OFFSET$dstComponentType = LAYOUT.byteOffset(PATH$dstComponentType);
    public static final long OFFSET$numRows = LAYOUT.byteOffset(PATH$numRows);
    public static final long OFFSET$numColumns = LAYOUT.byteOffset(PATH$numColumns);
    public static final long OFFSET$srcLayout = LAYOUT.byteOffset(PATH$srcLayout);
    public static final long OFFSET$srcStride = LAYOUT.byteOffset(PATH$srcStride);
    public static final long OFFSET$dstLayout = LAYOUT.byteOffset(PATH$dstLayout);
    public static final long OFFSET$dstStride = LAYOUT.byteOffset(PATH$dstStride);
}
