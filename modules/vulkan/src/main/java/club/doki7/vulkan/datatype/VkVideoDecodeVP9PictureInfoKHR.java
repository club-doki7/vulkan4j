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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoDecodeVP9PictureInfoKHR.html"><code>VkVideoDecodeVP9PictureInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkVideoDecodeVP9PictureInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     StdVideoDecodeVP9PictureInfo const* pStdPictureInfo; // @link substring="StdVideoDecodeVP9PictureInfo" target="StdVideoDecodeVP9PictureInfo" @link substring="pStdPictureInfo" target="#pStdPictureInfo"
///     int32_t[VK_MAX_VIDEO_VP9_REFERENCES_PER_FRAME_KHR] referenceNameSlotIndices; // @link substring="referenceNameSlotIndices" target="#referenceNameSlotIndices"
///     uint32_t uncompressedHeaderOffset; // @link substring="uncompressedHeaderOffset" target="#uncompressedHeaderOffset"
///     uint32_t compressedHeaderOffset; // @link substring="compressedHeaderOffset" target="#compressedHeaderOffset"
///     uint32_t tilesOffset; // @link substring="tilesOffset" target="#tilesOffset"
/// } VkVideoDecodeVP9PictureInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_VIDEO_DECODE_VP9_PICTURE_INFO_KHR`
///
/// The {@code allocate} ({@link VkVideoDecodeVP9PictureInfoKHR#allocate(Arena)}, {@link VkVideoDecodeVP9PictureInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkVideoDecodeVP9PictureInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoDecodeVP9PictureInfoKHR.html"><code>VkVideoDecodeVP9PictureInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkVideoDecodeVP9PictureInfoKHR(@NotNull MemorySegment segment) implements IVkVideoDecodeVP9PictureInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoDecodeVP9PictureInfoKHR.html"><code>VkVideoDecodeVP9PictureInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkVideoDecodeVP9PictureInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkVideoDecodeVP9PictureInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkVideoDecodeVP9PictureInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkVideoDecodeVP9PictureInfoKHR, Iterable<VkVideoDecodeVP9PictureInfoKHR> {
        public long size() {
            return segment.byteSize() / VkVideoDecodeVP9PictureInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkVideoDecodeVP9PictureInfoKHR at(long index) {
            return new VkVideoDecodeVP9PictureInfoKHR(segment.asSlice(index * VkVideoDecodeVP9PictureInfoKHR.BYTES, VkVideoDecodeVP9PictureInfoKHR.BYTES));
        }

        public VkVideoDecodeVP9PictureInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkVideoDecodeVP9PictureInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkVideoDecodeVP9PictureInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkVideoDecodeVP9PictureInfoKHR.BYTES, VkVideoDecodeVP9PictureInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkVideoDecodeVP9PictureInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkVideoDecodeVP9PictureInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkVideoDecodeVP9PictureInfoKHR.BYTES,
                (end - start) * VkVideoDecodeVP9PictureInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkVideoDecodeVP9PictureInfoKHR.BYTES));
        }

        public VkVideoDecodeVP9PictureInfoKHR[] toArray() {
            VkVideoDecodeVP9PictureInfoKHR[] ret = new VkVideoDecodeVP9PictureInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkVideoDecodeVP9PictureInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkVideoDecodeVP9PictureInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkVideoDecodeVP9PictureInfoKHR.BYTES;
            }

            @Override
            public VkVideoDecodeVP9PictureInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkVideoDecodeVP9PictureInfoKHR ret = new VkVideoDecodeVP9PictureInfoKHR(segment.asSlice(0, VkVideoDecodeVP9PictureInfoKHR.BYTES));
                segment = segment.asSlice(VkVideoDecodeVP9PictureInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkVideoDecodeVP9PictureInfoKHR allocate(Arena arena) {
        VkVideoDecodeVP9PictureInfoKHR ret = new VkVideoDecodeVP9PictureInfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.VIDEO_DECODE_VP9_PICTURE_INFO_KHR);
        return ret;
    }

    public static VkVideoDecodeVP9PictureInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkVideoDecodeVP9PictureInfoKHR.Ptr ret = new VkVideoDecodeVP9PictureInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.VIDEO_DECODE_VP9_PICTURE_INFO_KHR);
        }
        return ret;
    }

    public static VkVideoDecodeVP9PictureInfoKHR clone(Arena arena, VkVideoDecodeVP9PictureInfoKHR src) {
        VkVideoDecodeVP9PictureInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.VIDEO_DECODE_VP9_PICTURE_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkVideoDecodeVP9PictureInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkVideoDecodeVP9PictureInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkVideoDecodeVP9PictureInfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public VkVideoDecodeVP9PictureInfoKHR pStdPictureInfo(@Nullable IStdVideoDecodeVP9PictureInfo value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pStdPictureInfoRaw(s);
        return this;
    }

    @Unsafe public @Nullable StdVideoDecodeVP9PictureInfo.Ptr pStdPictureInfo(int assumedCount) {
        MemorySegment s = pStdPictureInfoRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * StdVideoDecodeVP9PictureInfo.BYTES);
        return new StdVideoDecodeVP9PictureInfo.Ptr(s);
    }

    public @Nullable StdVideoDecodeVP9PictureInfo pStdPictureInfo() {
        MemorySegment s = pStdPictureInfoRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new StdVideoDecodeVP9PictureInfo(s);
    }

    public @Pointer(target=StdVideoDecodeVP9PictureInfo.class) @NotNull MemorySegment pStdPictureInfoRaw() {
        return segment.get(LAYOUT$pStdPictureInfo, OFFSET$pStdPictureInfo);
    }

    public void pStdPictureInfoRaw(@Pointer(target=StdVideoDecodeVP9PictureInfo.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pStdPictureInfo, OFFSET$pStdPictureInfo, value);
    }

    public IntPtr referenceNameSlotIndices() {
        return new IntPtr(referenceNameSlotIndicesRaw());
    }

    public VkVideoDecodeVP9PictureInfoKHR referenceNameSlotIndices(@NotNull Consumer<IntPtr> consumer) {
        IntPtr ptr = referenceNameSlotIndices();
        consumer.accept(ptr);
        return this;
    }

    public VkVideoDecodeVP9PictureInfoKHR referenceNameSlotIndices(IntPtr value) {
        MemorySegment s = referenceNameSlotIndicesRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment referenceNameSlotIndicesRaw() {
        return segment.asSlice(OFFSET$referenceNameSlotIndices, SIZE$referenceNameSlotIndices);
    }

    public @Unsigned int uncompressedHeaderOffset() {
        return segment.get(LAYOUT$uncompressedHeaderOffset, OFFSET$uncompressedHeaderOffset);
    }

    public VkVideoDecodeVP9PictureInfoKHR uncompressedHeaderOffset(@Unsigned int value) {
        segment.set(LAYOUT$uncompressedHeaderOffset, OFFSET$uncompressedHeaderOffset, value);
        return this;
    }

    public @Unsigned int compressedHeaderOffset() {
        return segment.get(LAYOUT$compressedHeaderOffset, OFFSET$compressedHeaderOffset);
    }

    public VkVideoDecodeVP9PictureInfoKHR compressedHeaderOffset(@Unsigned int value) {
        segment.set(LAYOUT$compressedHeaderOffset, OFFSET$compressedHeaderOffset, value);
        return this;
    }

    public @Unsigned int tilesOffset() {
        return segment.get(LAYOUT$tilesOffset, OFFSET$tilesOffset);
    }

    public VkVideoDecodeVP9PictureInfoKHR tilesOffset(@Unsigned int value) {
        segment.set(LAYOUT$tilesOffset, OFFSET$tilesOffset, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withTargetLayout(StdVideoDecodeVP9PictureInfo.LAYOUT).withName("pStdPictureInfo"),
        MemoryLayout.sequenceLayout(MAX_VIDEO_VP9_REFERENCES_PER_FRAME_KHR, ValueLayout.JAVA_INT).withName("referenceNameSlotIndices"),
        ValueLayout.JAVA_INT.withName("uncompressedHeaderOffset"),
        ValueLayout.JAVA_INT.withName("compressedHeaderOffset"),
        ValueLayout.JAVA_INT.withName("tilesOffset")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$pStdPictureInfo = PathElement.groupElement("pStdPictureInfo");
    public static final PathElement PATH$referenceNameSlotIndices = PathElement.groupElement("referenceNameSlotIndices");
    public static final PathElement PATH$uncompressedHeaderOffset = PathElement.groupElement("uncompressedHeaderOffset");
    public static final PathElement PATH$compressedHeaderOffset = PathElement.groupElement("compressedHeaderOffset");
    public static final PathElement PATH$tilesOffset = PathElement.groupElement("tilesOffset");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$pStdPictureInfo = (AddressLayout) LAYOUT.select(PATH$pStdPictureInfo);
    public static final SequenceLayout LAYOUT$referenceNameSlotIndices = (SequenceLayout) LAYOUT.select(PATH$referenceNameSlotIndices);
    public static final OfInt LAYOUT$uncompressedHeaderOffset = (OfInt) LAYOUT.select(PATH$uncompressedHeaderOffset);
    public static final OfInt LAYOUT$compressedHeaderOffset = (OfInt) LAYOUT.select(PATH$compressedHeaderOffset);
    public static final OfInt LAYOUT$tilesOffset = (OfInt) LAYOUT.select(PATH$tilesOffset);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$pStdPictureInfo = LAYOUT$pStdPictureInfo.byteSize();
    public static final long SIZE$referenceNameSlotIndices = LAYOUT$referenceNameSlotIndices.byteSize();
    public static final long SIZE$uncompressedHeaderOffset = LAYOUT$uncompressedHeaderOffset.byteSize();
    public static final long SIZE$compressedHeaderOffset = LAYOUT$compressedHeaderOffset.byteSize();
    public static final long SIZE$tilesOffset = LAYOUT$tilesOffset.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$pStdPictureInfo = LAYOUT.byteOffset(PATH$pStdPictureInfo);
    public static final long OFFSET$referenceNameSlotIndices = LAYOUT.byteOffset(PATH$referenceNameSlotIndices);
    public static final long OFFSET$uncompressedHeaderOffset = LAYOUT.byteOffset(PATH$uncompressedHeaderOffset);
    public static final long OFFSET$compressedHeaderOffset = LAYOUT.byteOffset(PATH$compressedHeaderOffset);
    public static final long OFFSET$tilesOffset = LAYOUT.byteOffset(PATH$tilesOffset);
}
