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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeAV1PictureInfoKHR.html"><code>VkVideoEncodeAV1PictureInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkVideoEncodeAV1PictureInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkVideoEncodeAV1PredictionModeKHR predictionMode; // @link substring="VkVideoEncodeAV1PredictionModeKHR" target="VkVideoEncodeAV1PredictionModeKHR" @link substring="predictionMode" target="#predictionMode"
///     VkVideoEncodeAV1RateControlGroupKHR rateControlGroup; // @link substring="VkVideoEncodeAV1RateControlGroupKHR" target="VkVideoEncodeAV1RateControlGroupKHR" @link substring="rateControlGroup" target="#rateControlGroup"
///     uint32_t constantQIndex; // @link substring="constantQIndex" target="#constantQIndex"
///     StdVideoEncodeAV1PictureInfo const* pStdPictureInfo; // @link substring="StdVideoEncodeAV1PictureInfo" target="StdVideoEncodeAV1PictureInfo" @link substring="pStdPictureInfo" target="#pStdPictureInfo"
///     int32_t[VK_MAX_VIDEO_AV1_REFERENCES_PER_FRAME_KHR] referenceNameSlotIndices; // @link substring="referenceNameSlotIndices" target="#referenceNameSlotIndices"
///     VkBool32 primaryReferenceCdfOnly; // @link substring="primaryReferenceCdfOnly" target="#primaryReferenceCdfOnly"
///     VkBool32 generateObuExtensionHeader; // @link substring="generateObuExtensionHeader" target="#generateObuExtensionHeader"
/// } VkVideoEncodeAV1PictureInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_VIDEO_ENCODE_AV1_PICTURE_INFO_KHR`
///
/// The {@code allocate} ({@link VkVideoEncodeAV1PictureInfoKHR#allocate(Arena)}, {@link VkVideoEncodeAV1PictureInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkVideoEncodeAV1PictureInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeAV1PictureInfoKHR.html"><code>VkVideoEncodeAV1PictureInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkVideoEncodeAV1PictureInfoKHR(@NotNull MemorySegment segment) implements IVkVideoEncodeAV1PictureInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeAV1PictureInfoKHR.html"><code>VkVideoEncodeAV1PictureInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkVideoEncodeAV1PictureInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkVideoEncodeAV1PictureInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkVideoEncodeAV1PictureInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkVideoEncodeAV1PictureInfoKHR, Iterable<VkVideoEncodeAV1PictureInfoKHR> {
        public long size() {
            return segment.byteSize() / VkVideoEncodeAV1PictureInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkVideoEncodeAV1PictureInfoKHR at(long index) {
            return new VkVideoEncodeAV1PictureInfoKHR(segment.asSlice(index * VkVideoEncodeAV1PictureInfoKHR.BYTES, VkVideoEncodeAV1PictureInfoKHR.BYTES));
        }

        public VkVideoEncodeAV1PictureInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkVideoEncodeAV1PictureInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkVideoEncodeAV1PictureInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkVideoEncodeAV1PictureInfoKHR.BYTES, VkVideoEncodeAV1PictureInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkVideoEncodeAV1PictureInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkVideoEncodeAV1PictureInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkVideoEncodeAV1PictureInfoKHR.BYTES,
                (end - start) * VkVideoEncodeAV1PictureInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkVideoEncodeAV1PictureInfoKHR.BYTES));
        }

        public VkVideoEncodeAV1PictureInfoKHR[] toArray() {
            VkVideoEncodeAV1PictureInfoKHR[] ret = new VkVideoEncodeAV1PictureInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkVideoEncodeAV1PictureInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkVideoEncodeAV1PictureInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkVideoEncodeAV1PictureInfoKHR.BYTES;
            }

            @Override
            public VkVideoEncodeAV1PictureInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkVideoEncodeAV1PictureInfoKHR ret = new VkVideoEncodeAV1PictureInfoKHR(segment.asSlice(0, VkVideoEncodeAV1PictureInfoKHR.BYTES));
                segment = segment.asSlice(VkVideoEncodeAV1PictureInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkVideoEncodeAV1PictureInfoKHR allocate(Arena arena) {
        VkVideoEncodeAV1PictureInfoKHR ret = new VkVideoEncodeAV1PictureInfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.VIDEO_ENCODE_AV1_PICTURE_INFO_KHR);
        return ret;
    }

    public static VkVideoEncodeAV1PictureInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkVideoEncodeAV1PictureInfoKHR.Ptr ret = new VkVideoEncodeAV1PictureInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.VIDEO_ENCODE_AV1_PICTURE_INFO_KHR);
        }
        return ret;
    }

    public static VkVideoEncodeAV1PictureInfoKHR clone(Arena arena, VkVideoEncodeAV1PictureInfoKHR src) {
        VkVideoEncodeAV1PictureInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.VIDEO_ENCODE_AV1_PICTURE_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkVideoEncodeAV1PictureInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkVideoEncodeAV1PictureInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkVideoEncodeAV1PictureInfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @EnumType(VkVideoEncodeAV1PredictionModeKHR.class) int predictionMode() {
        return segment.get(LAYOUT$predictionMode, OFFSET$predictionMode);
    }

    public VkVideoEncodeAV1PictureInfoKHR predictionMode(@EnumType(VkVideoEncodeAV1PredictionModeKHR.class) int value) {
        segment.set(LAYOUT$predictionMode, OFFSET$predictionMode, value);
        return this;
    }

    public @EnumType(VkVideoEncodeAV1RateControlGroupKHR.class) int rateControlGroup() {
        return segment.get(LAYOUT$rateControlGroup, OFFSET$rateControlGroup);
    }

    public VkVideoEncodeAV1PictureInfoKHR rateControlGroup(@EnumType(VkVideoEncodeAV1RateControlGroupKHR.class) int value) {
        segment.set(LAYOUT$rateControlGroup, OFFSET$rateControlGroup, value);
        return this;
    }

    public @Unsigned int constantQIndex() {
        return segment.get(LAYOUT$constantQIndex, OFFSET$constantQIndex);
    }

    public VkVideoEncodeAV1PictureInfoKHR constantQIndex(@Unsigned int value) {
        segment.set(LAYOUT$constantQIndex, OFFSET$constantQIndex, value);
        return this;
    }

    public VkVideoEncodeAV1PictureInfoKHR pStdPictureInfo(@Nullable IStdVideoEncodeAV1PictureInfo value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pStdPictureInfoRaw(s);
        return this;
    }

    @Unsafe public @Nullable StdVideoEncodeAV1PictureInfo.Ptr pStdPictureInfo(int assumedCount) {
        MemorySegment s = pStdPictureInfoRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * StdVideoEncodeAV1PictureInfo.BYTES);
        return new StdVideoEncodeAV1PictureInfo.Ptr(s);
    }

    public @Nullable StdVideoEncodeAV1PictureInfo pStdPictureInfo() {
        MemorySegment s = pStdPictureInfoRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new StdVideoEncodeAV1PictureInfo(s);
    }

    public @Pointer(target=StdVideoEncodeAV1PictureInfo.class) @NotNull MemorySegment pStdPictureInfoRaw() {
        return segment.get(LAYOUT$pStdPictureInfo, OFFSET$pStdPictureInfo);
    }

    public void pStdPictureInfoRaw(@Pointer(target=StdVideoEncodeAV1PictureInfo.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pStdPictureInfo, OFFSET$pStdPictureInfo, value);
    }

    public IntPtr referenceNameSlotIndices() {
        return new IntPtr(referenceNameSlotIndicesRaw());
    }

    public VkVideoEncodeAV1PictureInfoKHR referenceNameSlotIndices(@NotNull Consumer<IntPtr> consumer) {
        IntPtr ptr = referenceNameSlotIndices();
        consumer.accept(ptr);
        return this;
    }

    public VkVideoEncodeAV1PictureInfoKHR referenceNameSlotIndices(IntPtr value) {
        MemorySegment s = referenceNameSlotIndicesRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment referenceNameSlotIndicesRaw() {
        return segment.asSlice(OFFSET$referenceNameSlotIndices, SIZE$referenceNameSlotIndices);
    }

    public @NativeType("VkBool32") @Unsigned int primaryReferenceCdfOnly() {
        return segment.get(LAYOUT$primaryReferenceCdfOnly, OFFSET$primaryReferenceCdfOnly);
    }

    public VkVideoEncodeAV1PictureInfoKHR primaryReferenceCdfOnly(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$primaryReferenceCdfOnly, OFFSET$primaryReferenceCdfOnly, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int generateObuExtensionHeader() {
        return segment.get(LAYOUT$generateObuExtensionHeader, OFFSET$generateObuExtensionHeader);
    }

    public VkVideoEncodeAV1PictureInfoKHR generateObuExtensionHeader(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$generateObuExtensionHeader, OFFSET$generateObuExtensionHeader, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("predictionMode"),
        ValueLayout.JAVA_INT.withName("rateControlGroup"),
        ValueLayout.JAVA_INT.withName("constantQIndex"),
        ValueLayout.ADDRESS.withTargetLayout(StdVideoEncodeAV1PictureInfo.LAYOUT).withName("pStdPictureInfo"),
        MemoryLayout.sequenceLayout(MAX_VIDEO_AV1_REFERENCES_PER_FRAME_KHR, ValueLayout.JAVA_INT).withName("referenceNameSlotIndices"),
        ValueLayout.JAVA_INT.withName("primaryReferenceCdfOnly"),
        ValueLayout.JAVA_INT.withName("generateObuExtensionHeader")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$predictionMode = PathElement.groupElement("predictionMode");
    public static final PathElement PATH$rateControlGroup = PathElement.groupElement("rateControlGroup");
    public static final PathElement PATH$constantQIndex = PathElement.groupElement("constantQIndex");
    public static final PathElement PATH$pStdPictureInfo = PathElement.groupElement("pStdPictureInfo");
    public static final PathElement PATH$referenceNameSlotIndices = PathElement.groupElement("referenceNameSlotIndices");
    public static final PathElement PATH$primaryReferenceCdfOnly = PathElement.groupElement("primaryReferenceCdfOnly");
    public static final PathElement PATH$generateObuExtensionHeader = PathElement.groupElement("generateObuExtensionHeader");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$predictionMode = (OfInt) LAYOUT.select(PATH$predictionMode);
    public static final OfInt LAYOUT$rateControlGroup = (OfInt) LAYOUT.select(PATH$rateControlGroup);
    public static final OfInt LAYOUT$constantQIndex = (OfInt) LAYOUT.select(PATH$constantQIndex);
    public static final AddressLayout LAYOUT$pStdPictureInfo = (AddressLayout) LAYOUT.select(PATH$pStdPictureInfo);
    public static final SequenceLayout LAYOUT$referenceNameSlotIndices = (SequenceLayout) LAYOUT.select(PATH$referenceNameSlotIndices);
    public static final OfInt LAYOUT$primaryReferenceCdfOnly = (OfInt) LAYOUT.select(PATH$primaryReferenceCdfOnly);
    public static final OfInt LAYOUT$generateObuExtensionHeader = (OfInt) LAYOUT.select(PATH$generateObuExtensionHeader);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$predictionMode = LAYOUT$predictionMode.byteSize();
    public static final long SIZE$rateControlGroup = LAYOUT$rateControlGroup.byteSize();
    public static final long SIZE$constantQIndex = LAYOUT$constantQIndex.byteSize();
    public static final long SIZE$pStdPictureInfo = LAYOUT$pStdPictureInfo.byteSize();
    public static final long SIZE$referenceNameSlotIndices = LAYOUT$referenceNameSlotIndices.byteSize();
    public static final long SIZE$primaryReferenceCdfOnly = LAYOUT$primaryReferenceCdfOnly.byteSize();
    public static final long SIZE$generateObuExtensionHeader = LAYOUT$generateObuExtensionHeader.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$predictionMode = LAYOUT.byteOffset(PATH$predictionMode);
    public static final long OFFSET$rateControlGroup = LAYOUT.byteOffset(PATH$rateControlGroup);
    public static final long OFFSET$constantQIndex = LAYOUT.byteOffset(PATH$constantQIndex);
    public static final long OFFSET$pStdPictureInfo = LAYOUT.byteOffset(PATH$pStdPictureInfo);
    public static final long OFFSET$referenceNameSlotIndices = LAYOUT.byteOffset(PATH$referenceNameSlotIndices);
    public static final long OFFSET$primaryReferenceCdfOnly = LAYOUT.byteOffset(PATH$primaryReferenceCdfOnly);
    public static final long OFFSET$generateObuExtensionHeader = LAYOUT.byteOffset(PATH$generateObuExtensionHeader);
}
