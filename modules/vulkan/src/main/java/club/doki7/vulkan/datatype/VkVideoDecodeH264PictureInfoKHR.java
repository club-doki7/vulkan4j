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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoDecodeH264PictureInfoKHR.html"><code>VkVideoDecodeH264PictureInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkVideoDecodeH264PictureInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     StdVideoDecodeH264PictureInfo const* pStdPictureInfo; // @link substring="StdVideoDecodeH264PictureInfo" target="StdVideoDecodeH264PictureInfo" @link substring="pStdPictureInfo" target="#pStdPictureInfo"
///     uint32_t sliceCount; // @link substring="sliceCount" target="#sliceCount"
///     uint32_t const* pSliceOffsets; // @link substring="pSliceOffsets" target="#pSliceOffsets"
/// } VkVideoDecodeH264PictureInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_VIDEO_DECODE_H264_PICTURE_INFO_KHR`
///
/// The {@code allocate} ({@link VkVideoDecodeH264PictureInfoKHR#allocate(Arena)}, {@link VkVideoDecodeH264PictureInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkVideoDecodeH264PictureInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoDecodeH264PictureInfoKHR.html"><code>VkVideoDecodeH264PictureInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkVideoDecodeH264PictureInfoKHR(@NotNull MemorySegment segment) implements IVkVideoDecodeH264PictureInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoDecodeH264PictureInfoKHR.html"><code>VkVideoDecodeH264PictureInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkVideoDecodeH264PictureInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkVideoDecodeH264PictureInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkVideoDecodeH264PictureInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkVideoDecodeH264PictureInfoKHR, Iterable<VkVideoDecodeH264PictureInfoKHR> {
        public long size() {
            return segment.byteSize() / VkVideoDecodeH264PictureInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkVideoDecodeH264PictureInfoKHR at(long index) {
            return new VkVideoDecodeH264PictureInfoKHR(segment.asSlice(index * VkVideoDecodeH264PictureInfoKHR.BYTES, VkVideoDecodeH264PictureInfoKHR.BYTES));
        }

        public VkVideoDecodeH264PictureInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkVideoDecodeH264PictureInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkVideoDecodeH264PictureInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkVideoDecodeH264PictureInfoKHR.BYTES, VkVideoDecodeH264PictureInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkVideoDecodeH264PictureInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkVideoDecodeH264PictureInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkVideoDecodeH264PictureInfoKHR.BYTES,
                (end - start) * VkVideoDecodeH264PictureInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkVideoDecodeH264PictureInfoKHR.BYTES));
        }

        public VkVideoDecodeH264PictureInfoKHR[] toArray() {
            VkVideoDecodeH264PictureInfoKHR[] ret = new VkVideoDecodeH264PictureInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkVideoDecodeH264PictureInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkVideoDecodeH264PictureInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkVideoDecodeH264PictureInfoKHR.BYTES;
            }

            @Override
            public VkVideoDecodeH264PictureInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkVideoDecodeH264PictureInfoKHR ret = new VkVideoDecodeH264PictureInfoKHR(segment.asSlice(0, VkVideoDecodeH264PictureInfoKHR.BYTES));
                segment = segment.asSlice(VkVideoDecodeH264PictureInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkVideoDecodeH264PictureInfoKHR allocate(Arena arena) {
        VkVideoDecodeH264PictureInfoKHR ret = new VkVideoDecodeH264PictureInfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.VIDEO_DECODE_H264_PICTURE_INFO_KHR);
        return ret;
    }

    public static VkVideoDecodeH264PictureInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkVideoDecodeH264PictureInfoKHR.Ptr ret = new VkVideoDecodeH264PictureInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.VIDEO_DECODE_H264_PICTURE_INFO_KHR);
        }
        return ret;
    }

    public static VkVideoDecodeH264PictureInfoKHR clone(Arena arena, VkVideoDecodeH264PictureInfoKHR src) {
        VkVideoDecodeH264PictureInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.VIDEO_DECODE_H264_PICTURE_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkVideoDecodeH264PictureInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkVideoDecodeH264PictureInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkVideoDecodeH264PictureInfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public VkVideoDecodeH264PictureInfoKHR pStdPictureInfo(@Nullable IStdVideoDecodeH264PictureInfo value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pStdPictureInfoRaw(s);
        return this;
    }

    @Unsafe public @Nullable StdVideoDecodeH264PictureInfo.Ptr pStdPictureInfo(int assumedCount) {
        MemorySegment s = pStdPictureInfoRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * StdVideoDecodeH264PictureInfo.BYTES);
        return new StdVideoDecodeH264PictureInfo.Ptr(s);
    }

    public @Nullable StdVideoDecodeH264PictureInfo pStdPictureInfo() {
        MemorySegment s = pStdPictureInfoRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new StdVideoDecodeH264PictureInfo(s);
    }

    public @Pointer(target=StdVideoDecodeH264PictureInfo.class) @NotNull MemorySegment pStdPictureInfoRaw() {
        return segment.get(LAYOUT$pStdPictureInfo, OFFSET$pStdPictureInfo);
    }

    public void pStdPictureInfoRaw(@Pointer(target=StdVideoDecodeH264PictureInfo.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pStdPictureInfo, OFFSET$pStdPictureInfo, value);
    }

    public @Unsigned int sliceCount() {
        return segment.get(LAYOUT$sliceCount, OFFSET$sliceCount);
    }

    public VkVideoDecodeH264PictureInfoKHR sliceCount(@Unsigned int value) {
        segment.set(LAYOUT$sliceCount, OFFSET$sliceCount, value);
        return this;
    }

    /// Note: the returned {@link IntPtr} does not have correct
    /// {@link IntPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link IntPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable @Unsigned IntPtr pSliceOffsets() {
        MemorySegment s = pSliceOffsetsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new IntPtr(s);
    }

    public VkVideoDecodeH264PictureInfoKHR pSliceOffsets(@Nullable @Unsigned IntPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pSliceOffsetsRaw(s);
        return this;
    }

    public @Pointer(comment="uint32_t*") @NotNull MemorySegment pSliceOffsetsRaw() {
        return segment.get(LAYOUT$pSliceOffsets, OFFSET$pSliceOffsets);
    }

    public void pSliceOffsetsRaw(@Pointer(comment="uint32_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pSliceOffsets, OFFSET$pSliceOffsets, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withTargetLayout(StdVideoDecodeH264PictureInfo.LAYOUT).withName("pStdPictureInfo"),
        ValueLayout.JAVA_INT.withName("sliceCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pSliceOffsets")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$pStdPictureInfo = PathElement.groupElement("pStdPictureInfo");
    public static final PathElement PATH$sliceCount = PathElement.groupElement("sliceCount");
    public static final PathElement PATH$pSliceOffsets = PathElement.groupElement("pSliceOffsets");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$pStdPictureInfo = (AddressLayout) LAYOUT.select(PATH$pStdPictureInfo);
    public static final OfInt LAYOUT$sliceCount = (OfInt) LAYOUT.select(PATH$sliceCount);
    public static final AddressLayout LAYOUT$pSliceOffsets = (AddressLayout) LAYOUT.select(PATH$pSliceOffsets);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$pStdPictureInfo = LAYOUT$pStdPictureInfo.byteSize();
    public static final long SIZE$sliceCount = LAYOUT$sliceCount.byteSize();
    public static final long SIZE$pSliceOffsets = LAYOUT$pSliceOffsets.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$pStdPictureInfo = LAYOUT.byteOffset(PATH$pStdPictureInfo);
    public static final long OFFSET$sliceCount = LAYOUT.byteOffset(PATH$sliceCount);
    public static final long OFFSET$pSliceOffsets = LAYOUT.byteOffset(PATH$pSliceOffsets);
}
