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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoDecodeAV1PictureInfoKHR.html"><code>VkVideoDecodeAV1PictureInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkVideoDecodeAV1PictureInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     StdVideoDecodeAV1PictureInfo const* pStdPictureInfo; // @link substring="StdVideoDecodeAV1PictureInfo" target="StdVideoDecodeAV1PictureInfo" @link substring="pStdPictureInfo" target="#pStdPictureInfo"
///     int32_t[VK_MAX_VIDEO_AV1_REFERENCES_PER_FRAME_KHR] referenceNameSlotIndices; // @link substring="referenceNameSlotIndices" target="#referenceNameSlotIndices"
///     uint32_t frameHeaderOffset; // @link substring="frameHeaderOffset" target="#frameHeaderOffset"
///     uint32_t tileCount; // @link substring="tileCount" target="#tileCount"
///     uint32_t const* pTileOffsets; // @link substring="pTileOffsets" target="#pTileOffsets"
///     uint32_t const* pTileSizes; // @link substring="pTileSizes" target="#pTileSizes"
/// } VkVideoDecodeAV1PictureInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_VIDEO_DECODE_AV1_PICTURE_INFO_KHR`
///
/// The {@code allocate} ({@link VkVideoDecodeAV1PictureInfoKHR#allocate(Arena)}, {@link VkVideoDecodeAV1PictureInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkVideoDecodeAV1PictureInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoDecodeAV1PictureInfoKHR.html"><code>VkVideoDecodeAV1PictureInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkVideoDecodeAV1PictureInfoKHR(@NotNull MemorySegment segment) implements IVkVideoDecodeAV1PictureInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoDecodeAV1PictureInfoKHR.html"><code>VkVideoDecodeAV1PictureInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkVideoDecodeAV1PictureInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkVideoDecodeAV1PictureInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkVideoDecodeAV1PictureInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkVideoDecodeAV1PictureInfoKHR, Iterable<VkVideoDecodeAV1PictureInfoKHR> {
        public long size() {
            return segment.byteSize() / VkVideoDecodeAV1PictureInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkVideoDecodeAV1PictureInfoKHR at(long index) {
            return new VkVideoDecodeAV1PictureInfoKHR(segment.asSlice(index * VkVideoDecodeAV1PictureInfoKHR.BYTES, VkVideoDecodeAV1PictureInfoKHR.BYTES));
        }

        public VkVideoDecodeAV1PictureInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkVideoDecodeAV1PictureInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkVideoDecodeAV1PictureInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkVideoDecodeAV1PictureInfoKHR.BYTES, VkVideoDecodeAV1PictureInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkVideoDecodeAV1PictureInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkVideoDecodeAV1PictureInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkVideoDecodeAV1PictureInfoKHR.BYTES,
                (end - start) * VkVideoDecodeAV1PictureInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkVideoDecodeAV1PictureInfoKHR.BYTES));
        }

        public VkVideoDecodeAV1PictureInfoKHR[] toArray() {
            VkVideoDecodeAV1PictureInfoKHR[] ret = new VkVideoDecodeAV1PictureInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkVideoDecodeAV1PictureInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkVideoDecodeAV1PictureInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkVideoDecodeAV1PictureInfoKHR.BYTES;
            }

            @Override
            public VkVideoDecodeAV1PictureInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkVideoDecodeAV1PictureInfoKHR ret = new VkVideoDecodeAV1PictureInfoKHR(segment.asSlice(0, VkVideoDecodeAV1PictureInfoKHR.BYTES));
                segment = segment.asSlice(VkVideoDecodeAV1PictureInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkVideoDecodeAV1PictureInfoKHR allocate(Arena arena) {
        VkVideoDecodeAV1PictureInfoKHR ret = new VkVideoDecodeAV1PictureInfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.VIDEO_DECODE_AV1_PICTURE_INFO_KHR);
        return ret;
    }

    public static VkVideoDecodeAV1PictureInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkVideoDecodeAV1PictureInfoKHR.Ptr ret = new VkVideoDecodeAV1PictureInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.VIDEO_DECODE_AV1_PICTURE_INFO_KHR);
        }
        return ret;
    }

    public static VkVideoDecodeAV1PictureInfoKHR clone(Arena arena, VkVideoDecodeAV1PictureInfoKHR src) {
        VkVideoDecodeAV1PictureInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.VIDEO_DECODE_AV1_PICTURE_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkVideoDecodeAV1PictureInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkVideoDecodeAV1PictureInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkVideoDecodeAV1PictureInfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public VkVideoDecodeAV1PictureInfoKHR pStdPictureInfo(@Nullable IStdVideoDecodeAV1PictureInfo value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pStdPictureInfoRaw(s);
        return this;
    }

    @Unsafe public @Nullable StdVideoDecodeAV1PictureInfo.Ptr pStdPictureInfo(int assumedCount) {
        MemorySegment s = pStdPictureInfoRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * StdVideoDecodeAV1PictureInfo.BYTES);
        return new StdVideoDecodeAV1PictureInfo.Ptr(s);
    }

    public @Nullable StdVideoDecodeAV1PictureInfo pStdPictureInfo() {
        MemorySegment s = pStdPictureInfoRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new StdVideoDecodeAV1PictureInfo(s);
    }

    public @Pointer(target=StdVideoDecodeAV1PictureInfo.class) @NotNull MemorySegment pStdPictureInfoRaw() {
        return segment.get(LAYOUT$pStdPictureInfo, OFFSET$pStdPictureInfo);
    }

    public void pStdPictureInfoRaw(@Pointer(target=StdVideoDecodeAV1PictureInfo.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pStdPictureInfo, OFFSET$pStdPictureInfo, value);
    }

    public IntPtr referenceNameSlotIndices() {
        return new IntPtr(referenceNameSlotIndicesRaw());
    }

    public VkVideoDecodeAV1PictureInfoKHR referenceNameSlotIndices(@NotNull Consumer<IntPtr> consumer) {
        IntPtr ptr = referenceNameSlotIndices();
        consumer.accept(ptr);
        return this;
    }

    public VkVideoDecodeAV1PictureInfoKHR referenceNameSlotIndices(IntPtr value) {
        MemorySegment s = referenceNameSlotIndicesRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment referenceNameSlotIndicesRaw() {
        return segment.asSlice(OFFSET$referenceNameSlotIndices, SIZE$referenceNameSlotIndices);
    }

    public @Unsigned int frameHeaderOffset() {
        return segment.get(LAYOUT$frameHeaderOffset, OFFSET$frameHeaderOffset);
    }

    public VkVideoDecodeAV1PictureInfoKHR frameHeaderOffset(@Unsigned int value) {
        segment.set(LAYOUT$frameHeaderOffset, OFFSET$frameHeaderOffset, value);
        return this;
    }

    public @Unsigned int tileCount() {
        return segment.get(LAYOUT$tileCount, OFFSET$tileCount);
    }

    public VkVideoDecodeAV1PictureInfoKHR tileCount(@Unsigned int value) {
        segment.set(LAYOUT$tileCount, OFFSET$tileCount, value);
        return this;
    }

    /// Note: the returned {@link IntPtr} does not have correct
    /// {@link IntPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link IntPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable @Unsigned IntPtr pTileOffsets() {
        MemorySegment s = pTileOffsetsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new IntPtr(s);
    }

    public VkVideoDecodeAV1PictureInfoKHR pTileOffsets(@Nullable @Unsigned IntPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pTileOffsetsRaw(s);
        return this;
    }

    public @Pointer(comment="uint32_t*") @NotNull MemorySegment pTileOffsetsRaw() {
        return segment.get(LAYOUT$pTileOffsets, OFFSET$pTileOffsets);
    }

    public void pTileOffsetsRaw(@Pointer(comment="uint32_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pTileOffsets, OFFSET$pTileOffsets, value);
    }

    /// Note: the returned {@link IntPtr} does not have correct
    /// {@link IntPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link IntPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable @Unsigned IntPtr pTileSizes() {
        MemorySegment s = pTileSizesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new IntPtr(s);
    }

    public VkVideoDecodeAV1PictureInfoKHR pTileSizes(@Nullable @Unsigned IntPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pTileSizesRaw(s);
        return this;
    }

    public @Pointer(comment="uint32_t*") @NotNull MemorySegment pTileSizesRaw() {
        return segment.get(LAYOUT$pTileSizes, OFFSET$pTileSizes);
    }

    public void pTileSizesRaw(@Pointer(comment="uint32_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pTileSizes, OFFSET$pTileSizes, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withTargetLayout(StdVideoDecodeAV1PictureInfo.LAYOUT).withName("pStdPictureInfo"),
        MemoryLayout.sequenceLayout(MAX_VIDEO_AV1_REFERENCES_PER_FRAME_KHR, ValueLayout.JAVA_INT).withName("referenceNameSlotIndices"),
        ValueLayout.JAVA_INT.withName("frameHeaderOffset"),
        ValueLayout.JAVA_INT.withName("tileCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pTileOffsets"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pTileSizes")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$pStdPictureInfo = PathElement.groupElement("pStdPictureInfo");
    public static final PathElement PATH$referenceNameSlotIndices = PathElement.groupElement("referenceNameSlotIndices");
    public static final PathElement PATH$frameHeaderOffset = PathElement.groupElement("frameHeaderOffset");
    public static final PathElement PATH$tileCount = PathElement.groupElement("tileCount");
    public static final PathElement PATH$pTileOffsets = PathElement.groupElement("pTileOffsets");
    public static final PathElement PATH$pTileSizes = PathElement.groupElement("pTileSizes");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$pStdPictureInfo = (AddressLayout) LAYOUT.select(PATH$pStdPictureInfo);
    public static final SequenceLayout LAYOUT$referenceNameSlotIndices = (SequenceLayout) LAYOUT.select(PATH$referenceNameSlotIndices);
    public static final OfInt LAYOUT$frameHeaderOffset = (OfInt) LAYOUT.select(PATH$frameHeaderOffset);
    public static final OfInt LAYOUT$tileCount = (OfInt) LAYOUT.select(PATH$tileCount);
    public static final AddressLayout LAYOUT$pTileOffsets = (AddressLayout) LAYOUT.select(PATH$pTileOffsets);
    public static final AddressLayout LAYOUT$pTileSizes = (AddressLayout) LAYOUT.select(PATH$pTileSizes);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$pStdPictureInfo = LAYOUT$pStdPictureInfo.byteSize();
    public static final long SIZE$referenceNameSlotIndices = LAYOUT$referenceNameSlotIndices.byteSize();
    public static final long SIZE$frameHeaderOffset = LAYOUT$frameHeaderOffset.byteSize();
    public static final long SIZE$tileCount = LAYOUT$tileCount.byteSize();
    public static final long SIZE$pTileOffsets = LAYOUT$pTileOffsets.byteSize();
    public static final long SIZE$pTileSizes = LAYOUT$pTileSizes.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$pStdPictureInfo = LAYOUT.byteOffset(PATH$pStdPictureInfo);
    public static final long OFFSET$referenceNameSlotIndices = LAYOUT.byteOffset(PATH$referenceNameSlotIndices);
    public static final long OFFSET$frameHeaderOffset = LAYOUT.byteOffset(PATH$frameHeaderOffset);
    public static final long OFFSET$tileCount = LAYOUT.byteOffset(PATH$tileCount);
    public static final long OFFSET$pTileOffsets = LAYOUT.byteOffset(PATH$pTileOffsets);
    public static final long OFFSET$pTileSizes = LAYOUT.byteOffset(PATH$pTileSizes);
}
