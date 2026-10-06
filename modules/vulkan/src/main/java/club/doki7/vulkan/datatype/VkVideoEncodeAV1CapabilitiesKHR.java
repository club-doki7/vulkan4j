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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeAV1CapabilitiesKHR.html"><code>VkVideoEncodeAV1CapabilitiesKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkVideoEncodeAV1CapabilitiesKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkVideoEncodeAV1CapabilityFlagsKHR flags; // @link substring="VkVideoEncodeAV1CapabilityFlagsKHR" target="VkVideoEncodeAV1CapabilityFlagsKHR" @link substring="flags" target="#flags"
///     StdVideoAV1Level maxLevel; // @link substring="StdVideoAV1Level" target="StdVideoAV1Level" @link substring="maxLevel" target="#maxLevel"
///     VkExtent2D codedPictureAlignment; // @link substring="VkExtent2D" target="VkExtent2D" @link substring="codedPictureAlignment" target="#codedPictureAlignment"
///     VkExtent2D maxTiles; // @link substring="VkExtent2D" target="VkExtent2D" @link substring="maxTiles" target="#maxTiles"
///     VkExtent2D minTileSize; // @link substring="VkExtent2D" target="VkExtent2D" @link substring="minTileSize" target="#minTileSize"
///     VkExtent2D maxTileSize; // @link substring="VkExtent2D" target="VkExtent2D" @link substring="maxTileSize" target="#maxTileSize"
///     VkVideoEncodeAV1SuperblockSizeFlagsKHR superblockSizes; // @link substring="VkVideoEncodeAV1SuperblockSizeFlagsKHR" target="VkVideoEncodeAV1SuperblockSizeFlagsKHR" @link substring="superblockSizes" target="#superblockSizes"
///     uint32_t maxSingleReferenceCount; // @link substring="maxSingleReferenceCount" target="#maxSingleReferenceCount"
///     uint32_t singleReferenceNameMask; // @link substring="singleReferenceNameMask" target="#singleReferenceNameMask"
///     uint32_t maxUnidirectionalCompoundReferenceCount; // @link substring="maxUnidirectionalCompoundReferenceCount" target="#maxUnidirectionalCompoundReferenceCount"
///     uint32_t maxUnidirectionalCompoundGroup1ReferenceCount; // @link substring="maxUnidirectionalCompoundGroup1ReferenceCount" target="#maxUnidirectionalCompoundGroup1ReferenceCount"
///     uint32_t unidirectionalCompoundReferenceNameMask; // @link substring="unidirectionalCompoundReferenceNameMask" target="#unidirectionalCompoundReferenceNameMask"
///     uint32_t maxBidirectionalCompoundReferenceCount; // @link substring="maxBidirectionalCompoundReferenceCount" target="#maxBidirectionalCompoundReferenceCount"
///     uint32_t maxBidirectionalCompoundGroup1ReferenceCount; // @link substring="maxBidirectionalCompoundGroup1ReferenceCount" target="#maxBidirectionalCompoundGroup1ReferenceCount"
///     uint32_t maxBidirectionalCompoundGroup2ReferenceCount; // @link substring="maxBidirectionalCompoundGroup2ReferenceCount" target="#maxBidirectionalCompoundGroup2ReferenceCount"
///     uint32_t bidirectionalCompoundReferenceNameMask; // @link substring="bidirectionalCompoundReferenceNameMask" target="#bidirectionalCompoundReferenceNameMask"
///     uint32_t maxTemporalLayerCount; // @link substring="maxTemporalLayerCount" target="#maxTemporalLayerCount"
///     uint32_t maxSpatialLayerCount; // @link substring="maxSpatialLayerCount" target="#maxSpatialLayerCount"
///     uint32_t maxOperatingPoints; // @link substring="maxOperatingPoints" target="#maxOperatingPoints"
///     uint32_t minQIndex; // @link substring="minQIndex" target="#minQIndex"
///     uint32_t maxQIndex; // @link substring="maxQIndex" target="#maxQIndex"
///     VkBool32 prefersGopRemainingFrames; // @link substring="prefersGopRemainingFrames" target="#prefersGopRemainingFrames"
///     VkBool32 requiresGopRemainingFrames; // @link substring="requiresGopRemainingFrames" target="#requiresGopRemainingFrames"
///     VkVideoEncodeAV1StdFlagsKHR stdSyntaxFlags; // @link substring="VkVideoEncodeAV1StdFlagsKHR" target="VkVideoEncodeAV1StdFlagsKHR" @link substring="stdSyntaxFlags" target="#stdSyntaxFlags"
/// } VkVideoEncodeAV1CapabilitiesKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_VIDEO_ENCODE_AV1_CAPABILITIES_KHR`
///
/// The {@code allocate} ({@link VkVideoEncodeAV1CapabilitiesKHR#allocate(Arena)}, {@link VkVideoEncodeAV1CapabilitiesKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkVideoEncodeAV1CapabilitiesKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeAV1CapabilitiesKHR.html"><code>VkVideoEncodeAV1CapabilitiesKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkVideoEncodeAV1CapabilitiesKHR(@NotNull MemorySegment segment) implements IVkVideoEncodeAV1CapabilitiesKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeAV1CapabilitiesKHR.html"><code>VkVideoEncodeAV1CapabilitiesKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkVideoEncodeAV1CapabilitiesKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkVideoEncodeAV1CapabilitiesKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkVideoEncodeAV1CapabilitiesKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkVideoEncodeAV1CapabilitiesKHR, Iterable<VkVideoEncodeAV1CapabilitiesKHR> {
        public long size() {
            return segment.byteSize() / VkVideoEncodeAV1CapabilitiesKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkVideoEncodeAV1CapabilitiesKHR at(long index) {
            return new VkVideoEncodeAV1CapabilitiesKHR(segment.asSlice(index * VkVideoEncodeAV1CapabilitiesKHR.BYTES, VkVideoEncodeAV1CapabilitiesKHR.BYTES));
        }

        public VkVideoEncodeAV1CapabilitiesKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkVideoEncodeAV1CapabilitiesKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkVideoEncodeAV1CapabilitiesKHR value) {
            MemorySegment s = segment.asSlice(index * VkVideoEncodeAV1CapabilitiesKHR.BYTES, VkVideoEncodeAV1CapabilitiesKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkVideoEncodeAV1CapabilitiesKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkVideoEncodeAV1CapabilitiesKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkVideoEncodeAV1CapabilitiesKHR.BYTES,
                (end - start) * VkVideoEncodeAV1CapabilitiesKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkVideoEncodeAV1CapabilitiesKHR.BYTES));
        }

        public VkVideoEncodeAV1CapabilitiesKHR[] toArray() {
            VkVideoEncodeAV1CapabilitiesKHR[] ret = new VkVideoEncodeAV1CapabilitiesKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkVideoEncodeAV1CapabilitiesKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkVideoEncodeAV1CapabilitiesKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkVideoEncodeAV1CapabilitiesKHR.BYTES;
            }

            @Override
            public VkVideoEncodeAV1CapabilitiesKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkVideoEncodeAV1CapabilitiesKHR ret = new VkVideoEncodeAV1CapabilitiesKHR(segment.asSlice(0, VkVideoEncodeAV1CapabilitiesKHR.BYTES));
                segment = segment.asSlice(VkVideoEncodeAV1CapabilitiesKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkVideoEncodeAV1CapabilitiesKHR allocate(Arena arena) {
        VkVideoEncodeAV1CapabilitiesKHR ret = new VkVideoEncodeAV1CapabilitiesKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.VIDEO_ENCODE_AV1_CAPABILITIES_KHR);
        return ret;
    }

    public static VkVideoEncodeAV1CapabilitiesKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkVideoEncodeAV1CapabilitiesKHR.Ptr ret = new VkVideoEncodeAV1CapabilitiesKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.VIDEO_ENCODE_AV1_CAPABILITIES_KHR);
        }
        return ret;
    }

    public static VkVideoEncodeAV1CapabilitiesKHR clone(Arena arena, VkVideoEncodeAV1CapabilitiesKHR src) {
        VkVideoEncodeAV1CapabilitiesKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.VIDEO_ENCODE_AV1_CAPABILITIES_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkVideoEncodeAV1CapabilitiesKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkVideoEncodeAV1CapabilitiesKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkVideoEncodeAV1CapabilitiesKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkVideoEncodeAV1CapabilityFlagsKHR.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkVideoEncodeAV1CapabilitiesKHR flags(@Bitmask(VkVideoEncodeAV1CapabilityFlagsKHR.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @EnumType(StdVideoAV1Level.class) int maxLevel() {
        return segment.get(LAYOUT$maxLevel, OFFSET$maxLevel);
    }

    public VkVideoEncodeAV1CapabilitiesKHR maxLevel(@EnumType(StdVideoAV1Level.class) int value) {
        segment.set(LAYOUT$maxLevel, OFFSET$maxLevel, value);
        return this;
    }

    public @NotNull VkExtent2D codedPictureAlignment() {
        return new VkExtent2D(segment.asSlice(OFFSET$codedPictureAlignment, LAYOUT$codedPictureAlignment));
    }

    public VkVideoEncodeAV1CapabilitiesKHR codedPictureAlignment(@NotNull VkExtent2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$codedPictureAlignment, SIZE$codedPictureAlignment);
        return this;
    }

    public VkVideoEncodeAV1CapabilitiesKHR codedPictureAlignment(Consumer<@NotNull VkExtent2D> consumer) {
        consumer.accept(codedPictureAlignment());
        return this;
    }

    public @NotNull VkExtent2D maxTiles() {
        return new VkExtent2D(segment.asSlice(OFFSET$maxTiles, LAYOUT$maxTiles));
    }

    public VkVideoEncodeAV1CapabilitiesKHR maxTiles(@NotNull VkExtent2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$maxTiles, SIZE$maxTiles);
        return this;
    }

    public VkVideoEncodeAV1CapabilitiesKHR maxTiles(Consumer<@NotNull VkExtent2D> consumer) {
        consumer.accept(maxTiles());
        return this;
    }

    public @NotNull VkExtent2D minTileSize() {
        return new VkExtent2D(segment.asSlice(OFFSET$minTileSize, LAYOUT$minTileSize));
    }

    public VkVideoEncodeAV1CapabilitiesKHR minTileSize(@NotNull VkExtent2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$minTileSize, SIZE$minTileSize);
        return this;
    }

    public VkVideoEncodeAV1CapabilitiesKHR minTileSize(Consumer<@NotNull VkExtent2D> consumer) {
        consumer.accept(minTileSize());
        return this;
    }

    public @NotNull VkExtent2D maxTileSize() {
        return new VkExtent2D(segment.asSlice(OFFSET$maxTileSize, LAYOUT$maxTileSize));
    }

    public VkVideoEncodeAV1CapabilitiesKHR maxTileSize(@NotNull VkExtent2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$maxTileSize, SIZE$maxTileSize);
        return this;
    }

    public VkVideoEncodeAV1CapabilitiesKHR maxTileSize(Consumer<@NotNull VkExtent2D> consumer) {
        consumer.accept(maxTileSize());
        return this;
    }

    public @Bitmask(VkVideoEncodeAV1SuperblockSizeFlagsKHR.class) int superblockSizes() {
        return segment.get(LAYOUT$superblockSizes, OFFSET$superblockSizes);
    }

    public VkVideoEncodeAV1CapabilitiesKHR superblockSizes(@Bitmask(VkVideoEncodeAV1SuperblockSizeFlagsKHR.class) int value) {
        segment.set(LAYOUT$superblockSizes, OFFSET$superblockSizes, value);
        return this;
    }

    public @Unsigned int maxSingleReferenceCount() {
        return segment.get(LAYOUT$maxSingleReferenceCount, OFFSET$maxSingleReferenceCount);
    }

    public VkVideoEncodeAV1CapabilitiesKHR maxSingleReferenceCount(@Unsigned int value) {
        segment.set(LAYOUT$maxSingleReferenceCount, OFFSET$maxSingleReferenceCount, value);
        return this;
    }

    public @Unsigned int singleReferenceNameMask() {
        return segment.get(LAYOUT$singleReferenceNameMask, OFFSET$singleReferenceNameMask);
    }

    public VkVideoEncodeAV1CapabilitiesKHR singleReferenceNameMask(@Unsigned int value) {
        segment.set(LAYOUT$singleReferenceNameMask, OFFSET$singleReferenceNameMask, value);
        return this;
    }

    public @Unsigned int maxUnidirectionalCompoundReferenceCount() {
        return segment.get(LAYOUT$maxUnidirectionalCompoundReferenceCount, OFFSET$maxUnidirectionalCompoundReferenceCount);
    }

    public VkVideoEncodeAV1CapabilitiesKHR maxUnidirectionalCompoundReferenceCount(@Unsigned int value) {
        segment.set(LAYOUT$maxUnidirectionalCompoundReferenceCount, OFFSET$maxUnidirectionalCompoundReferenceCount, value);
        return this;
    }

    public @Unsigned int maxUnidirectionalCompoundGroup1ReferenceCount() {
        return segment.get(LAYOUT$maxUnidirectionalCompoundGroup1ReferenceCount, OFFSET$maxUnidirectionalCompoundGroup1ReferenceCount);
    }

    public VkVideoEncodeAV1CapabilitiesKHR maxUnidirectionalCompoundGroup1ReferenceCount(@Unsigned int value) {
        segment.set(LAYOUT$maxUnidirectionalCompoundGroup1ReferenceCount, OFFSET$maxUnidirectionalCompoundGroup1ReferenceCount, value);
        return this;
    }

    public @Unsigned int unidirectionalCompoundReferenceNameMask() {
        return segment.get(LAYOUT$unidirectionalCompoundReferenceNameMask, OFFSET$unidirectionalCompoundReferenceNameMask);
    }

    public VkVideoEncodeAV1CapabilitiesKHR unidirectionalCompoundReferenceNameMask(@Unsigned int value) {
        segment.set(LAYOUT$unidirectionalCompoundReferenceNameMask, OFFSET$unidirectionalCompoundReferenceNameMask, value);
        return this;
    }

    public @Unsigned int maxBidirectionalCompoundReferenceCount() {
        return segment.get(LAYOUT$maxBidirectionalCompoundReferenceCount, OFFSET$maxBidirectionalCompoundReferenceCount);
    }

    public VkVideoEncodeAV1CapabilitiesKHR maxBidirectionalCompoundReferenceCount(@Unsigned int value) {
        segment.set(LAYOUT$maxBidirectionalCompoundReferenceCount, OFFSET$maxBidirectionalCompoundReferenceCount, value);
        return this;
    }

    public @Unsigned int maxBidirectionalCompoundGroup1ReferenceCount() {
        return segment.get(LAYOUT$maxBidirectionalCompoundGroup1ReferenceCount, OFFSET$maxBidirectionalCompoundGroup1ReferenceCount);
    }

    public VkVideoEncodeAV1CapabilitiesKHR maxBidirectionalCompoundGroup1ReferenceCount(@Unsigned int value) {
        segment.set(LAYOUT$maxBidirectionalCompoundGroup1ReferenceCount, OFFSET$maxBidirectionalCompoundGroup1ReferenceCount, value);
        return this;
    }

    public @Unsigned int maxBidirectionalCompoundGroup2ReferenceCount() {
        return segment.get(LAYOUT$maxBidirectionalCompoundGroup2ReferenceCount, OFFSET$maxBidirectionalCompoundGroup2ReferenceCount);
    }

    public VkVideoEncodeAV1CapabilitiesKHR maxBidirectionalCompoundGroup2ReferenceCount(@Unsigned int value) {
        segment.set(LAYOUT$maxBidirectionalCompoundGroup2ReferenceCount, OFFSET$maxBidirectionalCompoundGroup2ReferenceCount, value);
        return this;
    }

    public @Unsigned int bidirectionalCompoundReferenceNameMask() {
        return segment.get(LAYOUT$bidirectionalCompoundReferenceNameMask, OFFSET$bidirectionalCompoundReferenceNameMask);
    }

    public VkVideoEncodeAV1CapabilitiesKHR bidirectionalCompoundReferenceNameMask(@Unsigned int value) {
        segment.set(LAYOUT$bidirectionalCompoundReferenceNameMask, OFFSET$bidirectionalCompoundReferenceNameMask, value);
        return this;
    }

    public @Unsigned int maxTemporalLayerCount() {
        return segment.get(LAYOUT$maxTemporalLayerCount, OFFSET$maxTemporalLayerCount);
    }

    public VkVideoEncodeAV1CapabilitiesKHR maxTemporalLayerCount(@Unsigned int value) {
        segment.set(LAYOUT$maxTemporalLayerCount, OFFSET$maxTemporalLayerCount, value);
        return this;
    }

    public @Unsigned int maxSpatialLayerCount() {
        return segment.get(LAYOUT$maxSpatialLayerCount, OFFSET$maxSpatialLayerCount);
    }

    public VkVideoEncodeAV1CapabilitiesKHR maxSpatialLayerCount(@Unsigned int value) {
        segment.set(LAYOUT$maxSpatialLayerCount, OFFSET$maxSpatialLayerCount, value);
        return this;
    }

    public @Unsigned int maxOperatingPoints() {
        return segment.get(LAYOUT$maxOperatingPoints, OFFSET$maxOperatingPoints);
    }

    public VkVideoEncodeAV1CapabilitiesKHR maxOperatingPoints(@Unsigned int value) {
        segment.set(LAYOUT$maxOperatingPoints, OFFSET$maxOperatingPoints, value);
        return this;
    }

    public @Unsigned int minQIndex() {
        return segment.get(LAYOUT$minQIndex, OFFSET$minQIndex);
    }

    public VkVideoEncodeAV1CapabilitiesKHR minQIndex(@Unsigned int value) {
        segment.set(LAYOUT$minQIndex, OFFSET$minQIndex, value);
        return this;
    }

    public @Unsigned int maxQIndex() {
        return segment.get(LAYOUT$maxQIndex, OFFSET$maxQIndex);
    }

    public VkVideoEncodeAV1CapabilitiesKHR maxQIndex(@Unsigned int value) {
        segment.set(LAYOUT$maxQIndex, OFFSET$maxQIndex, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int prefersGopRemainingFrames() {
        return segment.get(LAYOUT$prefersGopRemainingFrames, OFFSET$prefersGopRemainingFrames);
    }

    public VkVideoEncodeAV1CapabilitiesKHR prefersGopRemainingFrames(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$prefersGopRemainingFrames, OFFSET$prefersGopRemainingFrames, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int requiresGopRemainingFrames() {
        return segment.get(LAYOUT$requiresGopRemainingFrames, OFFSET$requiresGopRemainingFrames);
    }

    public VkVideoEncodeAV1CapabilitiesKHR requiresGopRemainingFrames(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$requiresGopRemainingFrames, OFFSET$requiresGopRemainingFrames, value);
        return this;
    }

    public @Bitmask(VkVideoEncodeAV1StdFlagsKHR.class) int stdSyntaxFlags() {
        return segment.get(LAYOUT$stdSyntaxFlags, OFFSET$stdSyntaxFlags);
    }

    public VkVideoEncodeAV1CapabilitiesKHR stdSyntaxFlags(@Bitmask(VkVideoEncodeAV1StdFlagsKHR.class) int value) {
        segment.set(LAYOUT$stdSyntaxFlags, OFFSET$stdSyntaxFlags, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("maxLevel"),
        VkExtent2D.LAYOUT.withName("codedPictureAlignment"),
        VkExtent2D.LAYOUT.withName("maxTiles"),
        VkExtent2D.LAYOUT.withName("minTileSize"),
        VkExtent2D.LAYOUT.withName("maxTileSize"),
        ValueLayout.JAVA_INT.withName("superblockSizes"),
        ValueLayout.JAVA_INT.withName("maxSingleReferenceCount"),
        ValueLayout.JAVA_INT.withName("singleReferenceNameMask"),
        ValueLayout.JAVA_INT.withName("maxUnidirectionalCompoundReferenceCount"),
        ValueLayout.JAVA_INT.withName("maxUnidirectionalCompoundGroup1ReferenceCount"),
        ValueLayout.JAVA_INT.withName("unidirectionalCompoundReferenceNameMask"),
        ValueLayout.JAVA_INT.withName("maxBidirectionalCompoundReferenceCount"),
        ValueLayout.JAVA_INT.withName("maxBidirectionalCompoundGroup1ReferenceCount"),
        ValueLayout.JAVA_INT.withName("maxBidirectionalCompoundGroup2ReferenceCount"),
        ValueLayout.JAVA_INT.withName("bidirectionalCompoundReferenceNameMask"),
        ValueLayout.JAVA_INT.withName("maxTemporalLayerCount"),
        ValueLayout.JAVA_INT.withName("maxSpatialLayerCount"),
        ValueLayout.JAVA_INT.withName("maxOperatingPoints"),
        ValueLayout.JAVA_INT.withName("minQIndex"),
        ValueLayout.JAVA_INT.withName("maxQIndex"),
        ValueLayout.JAVA_INT.withName("prefersGopRemainingFrames"),
        ValueLayout.JAVA_INT.withName("requiresGopRemainingFrames"),
        ValueLayout.JAVA_INT.withName("stdSyntaxFlags")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$maxLevel = PathElement.groupElement("maxLevel");
    public static final PathElement PATH$codedPictureAlignment = PathElement.groupElement("codedPictureAlignment");
    public static final PathElement PATH$maxTiles = PathElement.groupElement("maxTiles");
    public static final PathElement PATH$minTileSize = PathElement.groupElement("minTileSize");
    public static final PathElement PATH$maxTileSize = PathElement.groupElement("maxTileSize");
    public static final PathElement PATH$superblockSizes = PathElement.groupElement("superblockSizes");
    public static final PathElement PATH$maxSingleReferenceCount = PathElement.groupElement("maxSingleReferenceCount");
    public static final PathElement PATH$singleReferenceNameMask = PathElement.groupElement("singleReferenceNameMask");
    public static final PathElement PATH$maxUnidirectionalCompoundReferenceCount = PathElement.groupElement("maxUnidirectionalCompoundReferenceCount");
    public static final PathElement PATH$maxUnidirectionalCompoundGroup1ReferenceCount = PathElement.groupElement("maxUnidirectionalCompoundGroup1ReferenceCount");
    public static final PathElement PATH$unidirectionalCompoundReferenceNameMask = PathElement.groupElement("unidirectionalCompoundReferenceNameMask");
    public static final PathElement PATH$maxBidirectionalCompoundReferenceCount = PathElement.groupElement("maxBidirectionalCompoundReferenceCount");
    public static final PathElement PATH$maxBidirectionalCompoundGroup1ReferenceCount = PathElement.groupElement("maxBidirectionalCompoundGroup1ReferenceCount");
    public static final PathElement PATH$maxBidirectionalCompoundGroup2ReferenceCount = PathElement.groupElement("maxBidirectionalCompoundGroup2ReferenceCount");
    public static final PathElement PATH$bidirectionalCompoundReferenceNameMask = PathElement.groupElement("bidirectionalCompoundReferenceNameMask");
    public static final PathElement PATH$maxTemporalLayerCount = PathElement.groupElement("maxTemporalLayerCount");
    public static final PathElement PATH$maxSpatialLayerCount = PathElement.groupElement("maxSpatialLayerCount");
    public static final PathElement PATH$maxOperatingPoints = PathElement.groupElement("maxOperatingPoints");
    public static final PathElement PATH$minQIndex = PathElement.groupElement("minQIndex");
    public static final PathElement PATH$maxQIndex = PathElement.groupElement("maxQIndex");
    public static final PathElement PATH$prefersGopRemainingFrames = PathElement.groupElement("prefersGopRemainingFrames");
    public static final PathElement PATH$requiresGopRemainingFrames = PathElement.groupElement("requiresGopRemainingFrames");
    public static final PathElement PATH$stdSyntaxFlags = PathElement.groupElement("stdSyntaxFlags");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$maxLevel = (OfInt) LAYOUT.select(PATH$maxLevel);
    public static final StructLayout LAYOUT$codedPictureAlignment = (StructLayout) LAYOUT.select(PATH$codedPictureAlignment);
    public static final StructLayout LAYOUT$maxTiles = (StructLayout) LAYOUT.select(PATH$maxTiles);
    public static final StructLayout LAYOUT$minTileSize = (StructLayout) LAYOUT.select(PATH$minTileSize);
    public static final StructLayout LAYOUT$maxTileSize = (StructLayout) LAYOUT.select(PATH$maxTileSize);
    public static final OfInt LAYOUT$superblockSizes = (OfInt) LAYOUT.select(PATH$superblockSizes);
    public static final OfInt LAYOUT$maxSingleReferenceCount = (OfInt) LAYOUT.select(PATH$maxSingleReferenceCount);
    public static final OfInt LAYOUT$singleReferenceNameMask = (OfInt) LAYOUT.select(PATH$singleReferenceNameMask);
    public static final OfInt LAYOUT$maxUnidirectionalCompoundReferenceCount = (OfInt) LAYOUT.select(PATH$maxUnidirectionalCompoundReferenceCount);
    public static final OfInt LAYOUT$maxUnidirectionalCompoundGroup1ReferenceCount = (OfInt) LAYOUT.select(PATH$maxUnidirectionalCompoundGroup1ReferenceCount);
    public static final OfInt LAYOUT$unidirectionalCompoundReferenceNameMask = (OfInt) LAYOUT.select(PATH$unidirectionalCompoundReferenceNameMask);
    public static final OfInt LAYOUT$maxBidirectionalCompoundReferenceCount = (OfInt) LAYOUT.select(PATH$maxBidirectionalCompoundReferenceCount);
    public static final OfInt LAYOUT$maxBidirectionalCompoundGroup1ReferenceCount = (OfInt) LAYOUT.select(PATH$maxBidirectionalCompoundGroup1ReferenceCount);
    public static final OfInt LAYOUT$maxBidirectionalCompoundGroup2ReferenceCount = (OfInt) LAYOUT.select(PATH$maxBidirectionalCompoundGroup2ReferenceCount);
    public static final OfInt LAYOUT$bidirectionalCompoundReferenceNameMask = (OfInt) LAYOUT.select(PATH$bidirectionalCompoundReferenceNameMask);
    public static final OfInt LAYOUT$maxTemporalLayerCount = (OfInt) LAYOUT.select(PATH$maxTemporalLayerCount);
    public static final OfInt LAYOUT$maxSpatialLayerCount = (OfInt) LAYOUT.select(PATH$maxSpatialLayerCount);
    public static final OfInt LAYOUT$maxOperatingPoints = (OfInt) LAYOUT.select(PATH$maxOperatingPoints);
    public static final OfInt LAYOUT$minQIndex = (OfInt) LAYOUT.select(PATH$minQIndex);
    public static final OfInt LAYOUT$maxQIndex = (OfInt) LAYOUT.select(PATH$maxQIndex);
    public static final OfInt LAYOUT$prefersGopRemainingFrames = (OfInt) LAYOUT.select(PATH$prefersGopRemainingFrames);
    public static final OfInt LAYOUT$requiresGopRemainingFrames = (OfInt) LAYOUT.select(PATH$requiresGopRemainingFrames);
    public static final OfInt LAYOUT$stdSyntaxFlags = (OfInt) LAYOUT.select(PATH$stdSyntaxFlags);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$maxLevel = LAYOUT$maxLevel.byteSize();
    public static final long SIZE$codedPictureAlignment = LAYOUT$codedPictureAlignment.byteSize();
    public static final long SIZE$maxTiles = LAYOUT$maxTiles.byteSize();
    public static final long SIZE$minTileSize = LAYOUT$minTileSize.byteSize();
    public static final long SIZE$maxTileSize = LAYOUT$maxTileSize.byteSize();
    public static final long SIZE$superblockSizes = LAYOUT$superblockSizes.byteSize();
    public static final long SIZE$maxSingleReferenceCount = LAYOUT$maxSingleReferenceCount.byteSize();
    public static final long SIZE$singleReferenceNameMask = LAYOUT$singleReferenceNameMask.byteSize();
    public static final long SIZE$maxUnidirectionalCompoundReferenceCount = LAYOUT$maxUnidirectionalCompoundReferenceCount.byteSize();
    public static final long SIZE$maxUnidirectionalCompoundGroup1ReferenceCount = LAYOUT$maxUnidirectionalCompoundGroup1ReferenceCount.byteSize();
    public static final long SIZE$unidirectionalCompoundReferenceNameMask = LAYOUT$unidirectionalCompoundReferenceNameMask.byteSize();
    public static final long SIZE$maxBidirectionalCompoundReferenceCount = LAYOUT$maxBidirectionalCompoundReferenceCount.byteSize();
    public static final long SIZE$maxBidirectionalCompoundGroup1ReferenceCount = LAYOUT$maxBidirectionalCompoundGroup1ReferenceCount.byteSize();
    public static final long SIZE$maxBidirectionalCompoundGroup2ReferenceCount = LAYOUT$maxBidirectionalCompoundGroup2ReferenceCount.byteSize();
    public static final long SIZE$bidirectionalCompoundReferenceNameMask = LAYOUT$bidirectionalCompoundReferenceNameMask.byteSize();
    public static final long SIZE$maxTemporalLayerCount = LAYOUT$maxTemporalLayerCount.byteSize();
    public static final long SIZE$maxSpatialLayerCount = LAYOUT$maxSpatialLayerCount.byteSize();
    public static final long SIZE$maxOperatingPoints = LAYOUT$maxOperatingPoints.byteSize();
    public static final long SIZE$minQIndex = LAYOUT$minQIndex.byteSize();
    public static final long SIZE$maxQIndex = LAYOUT$maxQIndex.byteSize();
    public static final long SIZE$prefersGopRemainingFrames = LAYOUT$prefersGopRemainingFrames.byteSize();
    public static final long SIZE$requiresGopRemainingFrames = LAYOUT$requiresGopRemainingFrames.byteSize();
    public static final long SIZE$stdSyntaxFlags = LAYOUT$stdSyntaxFlags.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$maxLevel = LAYOUT.byteOffset(PATH$maxLevel);
    public static final long OFFSET$codedPictureAlignment = LAYOUT.byteOffset(PATH$codedPictureAlignment);
    public static final long OFFSET$maxTiles = LAYOUT.byteOffset(PATH$maxTiles);
    public static final long OFFSET$minTileSize = LAYOUT.byteOffset(PATH$minTileSize);
    public static final long OFFSET$maxTileSize = LAYOUT.byteOffset(PATH$maxTileSize);
    public static final long OFFSET$superblockSizes = LAYOUT.byteOffset(PATH$superblockSizes);
    public static final long OFFSET$maxSingleReferenceCount = LAYOUT.byteOffset(PATH$maxSingleReferenceCount);
    public static final long OFFSET$singleReferenceNameMask = LAYOUT.byteOffset(PATH$singleReferenceNameMask);
    public static final long OFFSET$maxUnidirectionalCompoundReferenceCount = LAYOUT.byteOffset(PATH$maxUnidirectionalCompoundReferenceCount);
    public static final long OFFSET$maxUnidirectionalCompoundGroup1ReferenceCount = LAYOUT.byteOffset(PATH$maxUnidirectionalCompoundGroup1ReferenceCount);
    public static final long OFFSET$unidirectionalCompoundReferenceNameMask = LAYOUT.byteOffset(PATH$unidirectionalCompoundReferenceNameMask);
    public static final long OFFSET$maxBidirectionalCompoundReferenceCount = LAYOUT.byteOffset(PATH$maxBidirectionalCompoundReferenceCount);
    public static final long OFFSET$maxBidirectionalCompoundGroup1ReferenceCount = LAYOUT.byteOffset(PATH$maxBidirectionalCompoundGroup1ReferenceCount);
    public static final long OFFSET$maxBidirectionalCompoundGroup2ReferenceCount = LAYOUT.byteOffset(PATH$maxBidirectionalCompoundGroup2ReferenceCount);
    public static final long OFFSET$bidirectionalCompoundReferenceNameMask = LAYOUT.byteOffset(PATH$bidirectionalCompoundReferenceNameMask);
    public static final long OFFSET$maxTemporalLayerCount = LAYOUT.byteOffset(PATH$maxTemporalLayerCount);
    public static final long OFFSET$maxSpatialLayerCount = LAYOUT.byteOffset(PATH$maxSpatialLayerCount);
    public static final long OFFSET$maxOperatingPoints = LAYOUT.byteOffset(PATH$maxOperatingPoints);
    public static final long OFFSET$minQIndex = LAYOUT.byteOffset(PATH$minQIndex);
    public static final long OFFSET$maxQIndex = LAYOUT.byteOffset(PATH$maxQIndex);
    public static final long OFFSET$prefersGopRemainingFrames = LAYOUT.byteOffset(PATH$prefersGopRemainingFrames);
    public static final long OFFSET$requiresGopRemainingFrames = LAYOUT.byteOffset(PATH$requiresGopRemainingFrames);
    public static final long OFFSET$stdSyntaxFlags = LAYOUT.byteOffset(PATH$stdSyntaxFlags);
}
