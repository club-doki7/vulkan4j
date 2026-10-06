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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeH265CapabilitiesKHR.html"><code>VkVideoEncodeH265CapabilitiesKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkVideoEncodeH265CapabilitiesKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkVideoEncodeH265CapabilityFlagsKHR flags; // @link substring="VkVideoEncodeH265CapabilityFlagsKHR" target="VkVideoEncodeH265CapabilityFlagsKHR" @link substring="flags" target="#flags"
///     StdVideoH265LevelIdc maxLevelIdc; // @link substring="StdVideoH265LevelIdc" target="StdVideoH265LevelIdc" @link substring="maxLevelIdc" target="#maxLevelIdc"
///     uint32_t maxSliceSegmentCount; // @link substring="maxSliceSegmentCount" target="#maxSliceSegmentCount"
///     VkExtent2D maxTiles; // @link substring="VkExtent2D" target="VkExtent2D" @link substring="maxTiles" target="#maxTiles"
///     VkVideoEncodeH265CtbSizeFlagsKHR ctbSizes; // @link substring="VkVideoEncodeH265CtbSizeFlagsKHR" target="VkVideoEncodeH265CtbSizeFlagsKHR" @link substring="ctbSizes" target="#ctbSizes"
///     VkVideoEncodeH265TransformBlockSizeFlagsKHR transformBlockSizes; // @link substring="VkVideoEncodeH265TransformBlockSizeFlagsKHR" target="VkVideoEncodeH265TransformBlockSizeFlagsKHR" @link substring="transformBlockSizes" target="#transformBlockSizes"
///     uint32_t maxPPictureL0ReferenceCount; // @link substring="maxPPictureL0ReferenceCount" target="#maxPPictureL0ReferenceCount"
///     uint32_t maxBPictureL0ReferenceCount; // @link substring="maxBPictureL0ReferenceCount" target="#maxBPictureL0ReferenceCount"
///     uint32_t maxL1ReferenceCount; // @link substring="maxL1ReferenceCount" target="#maxL1ReferenceCount"
///     uint32_t maxSubLayerCount; // @link substring="maxSubLayerCount" target="#maxSubLayerCount"
///     VkBool32 expectDyadicTemporalSubLayerPattern; // @link substring="expectDyadicTemporalSubLayerPattern" target="#expectDyadicTemporalSubLayerPattern"
///     int32_t minQp; // @link substring="minQp" target="#minQp"
///     int32_t maxQp; // @link substring="maxQp" target="#maxQp"
///     VkBool32 prefersGopRemainingFrames; // @link substring="prefersGopRemainingFrames" target="#prefersGopRemainingFrames"
///     VkBool32 requiresGopRemainingFrames; // @link substring="requiresGopRemainingFrames" target="#requiresGopRemainingFrames"
///     VkVideoEncodeH265StdFlagsKHR stdSyntaxFlags; // @link substring="VkVideoEncodeH265StdFlagsKHR" target="VkVideoEncodeH265StdFlagsKHR" @link substring="stdSyntaxFlags" target="#stdSyntaxFlags"
/// } VkVideoEncodeH265CapabilitiesKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_VIDEO_ENCODE_H265_CAPABILITIES_KHR`
///
/// The {@code allocate} ({@link VkVideoEncodeH265CapabilitiesKHR#allocate(Arena)}, {@link VkVideoEncodeH265CapabilitiesKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkVideoEncodeH265CapabilitiesKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeH265CapabilitiesKHR.html"><code>VkVideoEncodeH265CapabilitiesKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkVideoEncodeH265CapabilitiesKHR(@NotNull MemorySegment segment) implements IVkVideoEncodeH265CapabilitiesKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeH265CapabilitiesKHR.html"><code>VkVideoEncodeH265CapabilitiesKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkVideoEncodeH265CapabilitiesKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkVideoEncodeH265CapabilitiesKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkVideoEncodeH265CapabilitiesKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkVideoEncodeH265CapabilitiesKHR, Iterable<VkVideoEncodeH265CapabilitiesKHR> {
        public long size() {
            return segment.byteSize() / VkVideoEncodeH265CapabilitiesKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkVideoEncodeH265CapabilitiesKHR at(long index) {
            return new VkVideoEncodeH265CapabilitiesKHR(segment.asSlice(index * VkVideoEncodeH265CapabilitiesKHR.BYTES, VkVideoEncodeH265CapabilitiesKHR.BYTES));
        }

        public VkVideoEncodeH265CapabilitiesKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkVideoEncodeH265CapabilitiesKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkVideoEncodeH265CapabilitiesKHR value) {
            MemorySegment s = segment.asSlice(index * VkVideoEncodeH265CapabilitiesKHR.BYTES, VkVideoEncodeH265CapabilitiesKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkVideoEncodeH265CapabilitiesKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkVideoEncodeH265CapabilitiesKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkVideoEncodeH265CapabilitiesKHR.BYTES,
                (end - start) * VkVideoEncodeH265CapabilitiesKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkVideoEncodeH265CapabilitiesKHR.BYTES));
        }

        public VkVideoEncodeH265CapabilitiesKHR[] toArray() {
            VkVideoEncodeH265CapabilitiesKHR[] ret = new VkVideoEncodeH265CapabilitiesKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkVideoEncodeH265CapabilitiesKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkVideoEncodeH265CapabilitiesKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkVideoEncodeH265CapabilitiesKHR.BYTES;
            }

            @Override
            public VkVideoEncodeH265CapabilitiesKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkVideoEncodeH265CapabilitiesKHR ret = new VkVideoEncodeH265CapabilitiesKHR(segment.asSlice(0, VkVideoEncodeH265CapabilitiesKHR.BYTES));
                segment = segment.asSlice(VkVideoEncodeH265CapabilitiesKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkVideoEncodeH265CapabilitiesKHR allocate(Arena arena) {
        VkVideoEncodeH265CapabilitiesKHR ret = new VkVideoEncodeH265CapabilitiesKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.VIDEO_ENCODE_H265_CAPABILITIES_KHR);
        return ret;
    }

    public static VkVideoEncodeH265CapabilitiesKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkVideoEncodeH265CapabilitiesKHR.Ptr ret = new VkVideoEncodeH265CapabilitiesKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.VIDEO_ENCODE_H265_CAPABILITIES_KHR);
        }
        return ret;
    }

    public static VkVideoEncodeH265CapabilitiesKHR clone(Arena arena, VkVideoEncodeH265CapabilitiesKHR src) {
        VkVideoEncodeH265CapabilitiesKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.VIDEO_ENCODE_H265_CAPABILITIES_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkVideoEncodeH265CapabilitiesKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkVideoEncodeH265CapabilitiesKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkVideoEncodeH265CapabilitiesKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkVideoEncodeH265CapabilityFlagsKHR.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkVideoEncodeH265CapabilitiesKHR flags(@Bitmask(VkVideoEncodeH265CapabilityFlagsKHR.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @EnumType(StdVideoH265LevelIdc.class) int maxLevelIdc() {
        return segment.get(LAYOUT$maxLevelIdc, OFFSET$maxLevelIdc);
    }

    public VkVideoEncodeH265CapabilitiesKHR maxLevelIdc(@EnumType(StdVideoH265LevelIdc.class) int value) {
        segment.set(LAYOUT$maxLevelIdc, OFFSET$maxLevelIdc, value);
        return this;
    }

    public @Unsigned int maxSliceSegmentCount() {
        return segment.get(LAYOUT$maxSliceSegmentCount, OFFSET$maxSliceSegmentCount);
    }

    public VkVideoEncodeH265CapabilitiesKHR maxSliceSegmentCount(@Unsigned int value) {
        segment.set(LAYOUT$maxSliceSegmentCount, OFFSET$maxSliceSegmentCount, value);
        return this;
    }

    public @NotNull VkExtent2D maxTiles() {
        return new VkExtent2D(segment.asSlice(OFFSET$maxTiles, LAYOUT$maxTiles));
    }

    public VkVideoEncodeH265CapabilitiesKHR maxTiles(@NotNull VkExtent2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$maxTiles, SIZE$maxTiles);
        return this;
    }

    public VkVideoEncodeH265CapabilitiesKHR maxTiles(Consumer<@NotNull VkExtent2D> consumer) {
        consumer.accept(maxTiles());
        return this;
    }

    public @Bitmask(VkVideoEncodeH265CtbSizeFlagsKHR.class) int ctbSizes() {
        return segment.get(LAYOUT$ctbSizes, OFFSET$ctbSizes);
    }

    public VkVideoEncodeH265CapabilitiesKHR ctbSizes(@Bitmask(VkVideoEncodeH265CtbSizeFlagsKHR.class) int value) {
        segment.set(LAYOUT$ctbSizes, OFFSET$ctbSizes, value);
        return this;
    }

    public @Bitmask(VkVideoEncodeH265TransformBlockSizeFlagsKHR.class) int transformBlockSizes() {
        return segment.get(LAYOUT$transformBlockSizes, OFFSET$transformBlockSizes);
    }

    public VkVideoEncodeH265CapabilitiesKHR transformBlockSizes(@Bitmask(VkVideoEncodeH265TransformBlockSizeFlagsKHR.class) int value) {
        segment.set(LAYOUT$transformBlockSizes, OFFSET$transformBlockSizes, value);
        return this;
    }

    public @Unsigned int maxPPictureL0ReferenceCount() {
        return segment.get(LAYOUT$maxPPictureL0ReferenceCount, OFFSET$maxPPictureL0ReferenceCount);
    }

    public VkVideoEncodeH265CapabilitiesKHR maxPPictureL0ReferenceCount(@Unsigned int value) {
        segment.set(LAYOUT$maxPPictureL0ReferenceCount, OFFSET$maxPPictureL0ReferenceCount, value);
        return this;
    }

    public @Unsigned int maxBPictureL0ReferenceCount() {
        return segment.get(LAYOUT$maxBPictureL0ReferenceCount, OFFSET$maxBPictureL0ReferenceCount);
    }

    public VkVideoEncodeH265CapabilitiesKHR maxBPictureL0ReferenceCount(@Unsigned int value) {
        segment.set(LAYOUT$maxBPictureL0ReferenceCount, OFFSET$maxBPictureL0ReferenceCount, value);
        return this;
    }

    public @Unsigned int maxL1ReferenceCount() {
        return segment.get(LAYOUT$maxL1ReferenceCount, OFFSET$maxL1ReferenceCount);
    }

    public VkVideoEncodeH265CapabilitiesKHR maxL1ReferenceCount(@Unsigned int value) {
        segment.set(LAYOUT$maxL1ReferenceCount, OFFSET$maxL1ReferenceCount, value);
        return this;
    }

    public @Unsigned int maxSubLayerCount() {
        return segment.get(LAYOUT$maxSubLayerCount, OFFSET$maxSubLayerCount);
    }

    public VkVideoEncodeH265CapabilitiesKHR maxSubLayerCount(@Unsigned int value) {
        segment.set(LAYOUT$maxSubLayerCount, OFFSET$maxSubLayerCount, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int expectDyadicTemporalSubLayerPattern() {
        return segment.get(LAYOUT$expectDyadicTemporalSubLayerPattern, OFFSET$expectDyadicTemporalSubLayerPattern);
    }

    public VkVideoEncodeH265CapabilitiesKHR expectDyadicTemporalSubLayerPattern(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$expectDyadicTemporalSubLayerPattern, OFFSET$expectDyadicTemporalSubLayerPattern, value);
        return this;
    }

    public int minQp() {
        return segment.get(LAYOUT$minQp, OFFSET$minQp);
    }

    public VkVideoEncodeH265CapabilitiesKHR minQp(int value) {
        segment.set(LAYOUT$minQp, OFFSET$minQp, value);
        return this;
    }

    public int maxQp() {
        return segment.get(LAYOUT$maxQp, OFFSET$maxQp);
    }

    public VkVideoEncodeH265CapabilitiesKHR maxQp(int value) {
        segment.set(LAYOUT$maxQp, OFFSET$maxQp, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int prefersGopRemainingFrames() {
        return segment.get(LAYOUT$prefersGopRemainingFrames, OFFSET$prefersGopRemainingFrames);
    }

    public VkVideoEncodeH265CapabilitiesKHR prefersGopRemainingFrames(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$prefersGopRemainingFrames, OFFSET$prefersGopRemainingFrames, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int requiresGopRemainingFrames() {
        return segment.get(LAYOUT$requiresGopRemainingFrames, OFFSET$requiresGopRemainingFrames);
    }

    public VkVideoEncodeH265CapabilitiesKHR requiresGopRemainingFrames(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$requiresGopRemainingFrames, OFFSET$requiresGopRemainingFrames, value);
        return this;
    }

    public @Bitmask(VkVideoEncodeH265StdFlagsKHR.class) int stdSyntaxFlags() {
        return segment.get(LAYOUT$stdSyntaxFlags, OFFSET$stdSyntaxFlags);
    }

    public VkVideoEncodeH265CapabilitiesKHR stdSyntaxFlags(@Bitmask(VkVideoEncodeH265StdFlagsKHR.class) int value) {
        segment.set(LAYOUT$stdSyntaxFlags, OFFSET$stdSyntaxFlags, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("maxLevelIdc"),
        ValueLayout.JAVA_INT.withName("maxSliceSegmentCount"),
        VkExtent2D.LAYOUT.withName("maxTiles"),
        ValueLayout.JAVA_INT.withName("ctbSizes"),
        ValueLayout.JAVA_INT.withName("transformBlockSizes"),
        ValueLayout.JAVA_INT.withName("maxPPictureL0ReferenceCount"),
        ValueLayout.JAVA_INT.withName("maxBPictureL0ReferenceCount"),
        ValueLayout.JAVA_INT.withName("maxL1ReferenceCount"),
        ValueLayout.JAVA_INT.withName("maxSubLayerCount"),
        ValueLayout.JAVA_INT.withName("expectDyadicTemporalSubLayerPattern"),
        ValueLayout.JAVA_INT.withName("minQp"),
        ValueLayout.JAVA_INT.withName("maxQp"),
        ValueLayout.JAVA_INT.withName("prefersGopRemainingFrames"),
        ValueLayout.JAVA_INT.withName("requiresGopRemainingFrames"),
        ValueLayout.JAVA_INT.withName("stdSyntaxFlags")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$maxLevelIdc = PathElement.groupElement("maxLevelIdc");
    public static final PathElement PATH$maxSliceSegmentCount = PathElement.groupElement("maxSliceSegmentCount");
    public static final PathElement PATH$maxTiles = PathElement.groupElement("maxTiles");
    public static final PathElement PATH$ctbSizes = PathElement.groupElement("ctbSizes");
    public static final PathElement PATH$transformBlockSizes = PathElement.groupElement("transformBlockSizes");
    public static final PathElement PATH$maxPPictureL0ReferenceCount = PathElement.groupElement("maxPPictureL0ReferenceCount");
    public static final PathElement PATH$maxBPictureL0ReferenceCount = PathElement.groupElement("maxBPictureL0ReferenceCount");
    public static final PathElement PATH$maxL1ReferenceCount = PathElement.groupElement("maxL1ReferenceCount");
    public static final PathElement PATH$maxSubLayerCount = PathElement.groupElement("maxSubLayerCount");
    public static final PathElement PATH$expectDyadicTemporalSubLayerPattern = PathElement.groupElement("expectDyadicTemporalSubLayerPattern");
    public static final PathElement PATH$minQp = PathElement.groupElement("minQp");
    public static final PathElement PATH$maxQp = PathElement.groupElement("maxQp");
    public static final PathElement PATH$prefersGopRemainingFrames = PathElement.groupElement("prefersGopRemainingFrames");
    public static final PathElement PATH$requiresGopRemainingFrames = PathElement.groupElement("requiresGopRemainingFrames");
    public static final PathElement PATH$stdSyntaxFlags = PathElement.groupElement("stdSyntaxFlags");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$maxLevelIdc = (OfInt) LAYOUT.select(PATH$maxLevelIdc);
    public static final OfInt LAYOUT$maxSliceSegmentCount = (OfInt) LAYOUT.select(PATH$maxSliceSegmentCount);
    public static final StructLayout LAYOUT$maxTiles = (StructLayout) LAYOUT.select(PATH$maxTiles);
    public static final OfInt LAYOUT$ctbSizes = (OfInt) LAYOUT.select(PATH$ctbSizes);
    public static final OfInt LAYOUT$transformBlockSizes = (OfInt) LAYOUT.select(PATH$transformBlockSizes);
    public static final OfInt LAYOUT$maxPPictureL0ReferenceCount = (OfInt) LAYOUT.select(PATH$maxPPictureL0ReferenceCount);
    public static final OfInt LAYOUT$maxBPictureL0ReferenceCount = (OfInt) LAYOUT.select(PATH$maxBPictureL0ReferenceCount);
    public static final OfInt LAYOUT$maxL1ReferenceCount = (OfInt) LAYOUT.select(PATH$maxL1ReferenceCount);
    public static final OfInt LAYOUT$maxSubLayerCount = (OfInt) LAYOUT.select(PATH$maxSubLayerCount);
    public static final OfInt LAYOUT$expectDyadicTemporalSubLayerPattern = (OfInt) LAYOUT.select(PATH$expectDyadicTemporalSubLayerPattern);
    public static final OfInt LAYOUT$minQp = (OfInt) LAYOUT.select(PATH$minQp);
    public static final OfInt LAYOUT$maxQp = (OfInt) LAYOUT.select(PATH$maxQp);
    public static final OfInt LAYOUT$prefersGopRemainingFrames = (OfInt) LAYOUT.select(PATH$prefersGopRemainingFrames);
    public static final OfInt LAYOUT$requiresGopRemainingFrames = (OfInt) LAYOUT.select(PATH$requiresGopRemainingFrames);
    public static final OfInt LAYOUT$stdSyntaxFlags = (OfInt) LAYOUT.select(PATH$stdSyntaxFlags);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$maxLevelIdc = LAYOUT$maxLevelIdc.byteSize();
    public static final long SIZE$maxSliceSegmentCount = LAYOUT$maxSliceSegmentCount.byteSize();
    public static final long SIZE$maxTiles = LAYOUT$maxTiles.byteSize();
    public static final long SIZE$ctbSizes = LAYOUT$ctbSizes.byteSize();
    public static final long SIZE$transformBlockSizes = LAYOUT$transformBlockSizes.byteSize();
    public static final long SIZE$maxPPictureL0ReferenceCount = LAYOUT$maxPPictureL0ReferenceCount.byteSize();
    public static final long SIZE$maxBPictureL0ReferenceCount = LAYOUT$maxBPictureL0ReferenceCount.byteSize();
    public static final long SIZE$maxL1ReferenceCount = LAYOUT$maxL1ReferenceCount.byteSize();
    public static final long SIZE$maxSubLayerCount = LAYOUT$maxSubLayerCount.byteSize();
    public static final long SIZE$expectDyadicTemporalSubLayerPattern = LAYOUT$expectDyadicTemporalSubLayerPattern.byteSize();
    public static final long SIZE$minQp = LAYOUT$minQp.byteSize();
    public static final long SIZE$maxQp = LAYOUT$maxQp.byteSize();
    public static final long SIZE$prefersGopRemainingFrames = LAYOUT$prefersGopRemainingFrames.byteSize();
    public static final long SIZE$requiresGopRemainingFrames = LAYOUT$requiresGopRemainingFrames.byteSize();
    public static final long SIZE$stdSyntaxFlags = LAYOUT$stdSyntaxFlags.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$maxLevelIdc = LAYOUT.byteOffset(PATH$maxLevelIdc);
    public static final long OFFSET$maxSliceSegmentCount = LAYOUT.byteOffset(PATH$maxSliceSegmentCount);
    public static final long OFFSET$maxTiles = LAYOUT.byteOffset(PATH$maxTiles);
    public static final long OFFSET$ctbSizes = LAYOUT.byteOffset(PATH$ctbSizes);
    public static final long OFFSET$transformBlockSizes = LAYOUT.byteOffset(PATH$transformBlockSizes);
    public static final long OFFSET$maxPPictureL0ReferenceCount = LAYOUT.byteOffset(PATH$maxPPictureL0ReferenceCount);
    public static final long OFFSET$maxBPictureL0ReferenceCount = LAYOUT.byteOffset(PATH$maxBPictureL0ReferenceCount);
    public static final long OFFSET$maxL1ReferenceCount = LAYOUT.byteOffset(PATH$maxL1ReferenceCount);
    public static final long OFFSET$maxSubLayerCount = LAYOUT.byteOffset(PATH$maxSubLayerCount);
    public static final long OFFSET$expectDyadicTemporalSubLayerPattern = LAYOUT.byteOffset(PATH$expectDyadicTemporalSubLayerPattern);
    public static final long OFFSET$minQp = LAYOUT.byteOffset(PATH$minQp);
    public static final long OFFSET$maxQp = LAYOUT.byteOffset(PATH$maxQp);
    public static final long OFFSET$prefersGopRemainingFrames = LAYOUT.byteOffset(PATH$prefersGopRemainingFrames);
    public static final long OFFSET$requiresGopRemainingFrames = LAYOUT.byteOffset(PATH$requiresGopRemainingFrames);
    public static final long OFFSET$stdSyntaxFlags = LAYOUT.byteOffset(PATH$stdSyntaxFlags);
}
