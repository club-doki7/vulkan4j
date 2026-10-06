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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeH264CapabilitiesKHR.html"><code>VkVideoEncodeH264CapabilitiesKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkVideoEncodeH264CapabilitiesKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkVideoEncodeH264CapabilityFlagsKHR flags; // @link substring="VkVideoEncodeH264CapabilityFlagsKHR" target="VkVideoEncodeH264CapabilityFlagsKHR" @link substring="flags" target="#flags"
///     StdVideoH264LevelIdc maxLevelIdc; // @link substring="StdVideoH264LevelIdc" target="StdVideoH264LevelIdc" @link substring="maxLevelIdc" target="#maxLevelIdc"
///     uint32_t maxSliceCount; // @link substring="maxSliceCount" target="#maxSliceCount"
///     uint32_t maxPPictureL0ReferenceCount; // @link substring="maxPPictureL0ReferenceCount" target="#maxPPictureL0ReferenceCount"
///     uint32_t maxBPictureL0ReferenceCount; // @link substring="maxBPictureL0ReferenceCount" target="#maxBPictureL0ReferenceCount"
///     uint32_t maxL1ReferenceCount; // @link substring="maxL1ReferenceCount" target="#maxL1ReferenceCount"
///     uint32_t maxTemporalLayerCount; // @link substring="maxTemporalLayerCount" target="#maxTemporalLayerCount"
///     VkBool32 expectDyadicTemporalLayerPattern; // @link substring="expectDyadicTemporalLayerPattern" target="#expectDyadicTemporalLayerPattern"
///     int32_t minQp; // @link substring="minQp" target="#minQp"
///     int32_t maxQp; // @link substring="maxQp" target="#maxQp"
///     VkBool32 prefersGopRemainingFrames; // @link substring="prefersGopRemainingFrames" target="#prefersGopRemainingFrames"
///     VkBool32 requiresGopRemainingFrames; // @link substring="requiresGopRemainingFrames" target="#requiresGopRemainingFrames"
///     VkVideoEncodeH264StdFlagsKHR stdSyntaxFlags; // @link substring="VkVideoEncodeH264StdFlagsKHR" target="VkVideoEncodeH264StdFlagsKHR" @link substring="stdSyntaxFlags" target="#stdSyntaxFlags"
/// } VkVideoEncodeH264CapabilitiesKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_VIDEO_ENCODE_H264_CAPABILITIES_KHR`
///
/// The {@code allocate} ({@link VkVideoEncodeH264CapabilitiesKHR#allocate(Arena)}, {@link VkVideoEncodeH264CapabilitiesKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkVideoEncodeH264CapabilitiesKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeH264CapabilitiesKHR.html"><code>VkVideoEncodeH264CapabilitiesKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkVideoEncodeH264CapabilitiesKHR(@NotNull MemorySegment segment) implements IVkVideoEncodeH264CapabilitiesKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeH264CapabilitiesKHR.html"><code>VkVideoEncodeH264CapabilitiesKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkVideoEncodeH264CapabilitiesKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkVideoEncodeH264CapabilitiesKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkVideoEncodeH264CapabilitiesKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkVideoEncodeH264CapabilitiesKHR, Iterable<VkVideoEncodeH264CapabilitiesKHR> {
        public long size() {
            return segment.byteSize() / VkVideoEncodeH264CapabilitiesKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkVideoEncodeH264CapabilitiesKHR at(long index) {
            return new VkVideoEncodeH264CapabilitiesKHR(segment.asSlice(index * VkVideoEncodeH264CapabilitiesKHR.BYTES, VkVideoEncodeH264CapabilitiesKHR.BYTES));
        }

        public VkVideoEncodeH264CapabilitiesKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkVideoEncodeH264CapabilitiesKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkVideoEncodeH264CapabilitiesKHR value) {
            MemorySegment s = segment.asSlice(index * VkVideoEncodeH264CapabilitiesKHR.BYTES, VkVideoEncodeH264CapabilitiesKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkVideoEncodeH264CapabilitiesKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkVideoEncodeH264CapabilitiesKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkVideoEncodeH264CapabilitiesKHR.BYTES,
                (end - start) * VkVideoEncodeH264CapabilitiesKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkVideoEncodeH264CapabilitiesKHR.BYTES));
        }

        public VkVideoEncodeH264CapabilitiesKHR[] toArray() {
            VkVideoEncodeH264CapabilitiesKHR[] ret = new VkVideoEncodeH264CapabilitiesKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkVideoEncodeH264CapabilitiesKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkVideoEncodeH264CapabilitiesKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkVideoEncodeH264CapabilitiesKHR.BYTES;
            }

            @Override
            public VkVideoEncodeH264CapabilitiesKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkVideoEncodeH264CapabilitiesKHR ret = new VkVideoEncodeH264CapabilitiesKHR(segment.asSlice(0, VkVideoEncodeH264CapabilitiesKHR.BYTES));
                segment = segment.asSlice(VkVideoEncodeH264CapabilitiesKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkVideoEncodeH264CapabilitiesKHR allocate(Arena arena) {
        VkVideoEncodeH264CapabilitiesKHR ret = new VkVideoEncodeH264CapabilitiesKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.VIDEO_ENCODE_H264_CAPABILITIES_KHR);
        return ret;
    }

    public static VkVideoEncodeH264CapabilitiesKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkVideoEncodeH264CapabilitiesKHR.Ptr ret = new VkVideoEncodeH264CapabilitiesKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.VIDEO_ENCODE_H264_CAPABILITIES_KHR);
        }
        return ret;
    }

    public static VkVideoEncodeH264CapabilitiesKHR clone(Arena arena, VkVideoEncodeH264CapabilitiesKHR src) {
        VkVideoEncodeH264CapabilitiesKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.VIDEO_ENCODE_H264_CAPABILITIES_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkVideoEncodeH264CapabilitiesKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkVideoEncodeH264CapabilitiesKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkVideoEncodeH264CapabilitiesKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkVideoEncodeH264CapabilityFlagsKHR.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkVideoEncodeH264CapabilitiesKHR flags(@Bitmask(VkVideoEncodeH264CapabilityFlagsKHR.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @EnumType(StdVideoH264LevelIdc.class) int maxLevelIdc() {
        return segment.get(LAYOUT$maxLevelIdc, OFFSET$maxLevelIdc);
    }

    public VkVideoEncodeH264CapabilitiesKHR maxLevelIdc(@EnumType(StdVideoH264LevelIdc.class) int value) {
        segment.set(LAYOUT$maxLevelIdc, OFFSET$maxLevelIdc, value);
        return this;
    }

    public @Unsigned int maxSliceCount() {
        return segment.get(LAYOUT$maxSliceCount, OFFSET$maxSliceCount);
    }

    public VkVideoEncodeH264CapabilitiesKHR maxSliceCount(@Unsigned int value) {
        segment.set(LAYOUT$maxSliceCount, OFFSET$maxSliceCount, value);
        return this;
    }

    public @Unsigned int maxPPictureL0ReferenceCount() {
        return segment.get(LAYOUT$maxPPictureL0ReferenceCount, OFFSET$maxPPictureL0ReferenceCount);
    }

    public VkVideoEncodeH264CapabilitiesKHR maxPPictureL0ReferenceCount(@Unsigned int value) {
        segment.set(LAYOUT$maxPPictureL0ReferenceCount, OFFSET$maxPPictureL0ReferenceCount, value);
        return this;
    }

    public @Unsigned int maxBPictureL0ReferenceCount() {
        return segment.get(LAYOUT$maxBPictureL0ReferenceCount, OFFSET$maxBPictureL0ReferenceCount);
    }

    public VkVideoEncodeH264CapabilitiesKHR maxBPictureL0ReferenceCount(@Unsigned int value) {
        segment.set(LAYOUT$maxBPictureL0ReferenceCount, OFFSET$maxBPictureL0ReferenceCount, value);
        return this;
    }

    public @Unsigned int maxL1ReferenceCount() {
        return segment.get(LAYOUT$maxL1ReferenceCount, OFFSET$maxL1ReferenceCount);
    }

    public VkVideoEncodeH264CapabilitiesKHR maxL1ReferenceCount(@Unsigned int value) {
        segment.set(LAYOUT$maxL1ReferenceCount, OFFSET$maxL1ReferenceCount, value);
        return this;
    }

    public @Unsigned int maxTemporalLayerCount() {
        return segment.get(LAYOUT$maxTemporalLayerCount, OFFSET$maxTemporalLayerCount);
    }

    public VkVideoEncodeH264CapabilitiesKHR maxTemporalLayerCount(@Unsigned int value) {
        segment.set(LAYOUT$maxTemporalLayerCount, OFFSET$maxTemporalLayerCount, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int expectDyadicTemporalLayerPattern() {
        return segment.get(LAYOUT$expectDyadicTemporalLayerPattern, OFFSET$expectDyadicTemporalLayerPattern);
    }

    public VkVideoEncodeH264CapabilitiesKHR expectDyadicTemporalLayerPattern(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$expectDyadicTemporalLayerPattern, OFFSET$expectDyadicTemporalLayerPattern, value);
        return this;
    }

    public int minQp() {
        return segment.get(LAYOUT$minQp, OFFSET$minQp);
    }

    public VkVideoEncodeH264CapabilitiesKHR minQp(int value) {
        segment.set(LAYOUT$minQp, OFFSET$minQp, value);
        return this;
    }

    public int maxQp() {
        return segment.get(LAYOUT$maxQp, OFFSET$maxQp);
    }

    public VkVideoEncodeH264CapabilitiesKHR maxQp(int value) {
        segment.set(LAYOUT$maxQp, OFFSET$maxQp, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int prefersGopRemainingFrames() {
        return segment.get(LAYOUT$prefersGopRemainingFrames, OFFSET$prefersGopRemainingFrames);
    }

    public VkVideoEncodeH264CapabilitiesKHR prefersGopRemainingFrames(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$prefersGopRemainingFrames, OFFSET$prefersGopRemainingFrames, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int requiresGopRemainingFrames() {
        return segment.get(LAYOUT$requiresGopRemainingFrames, OFFSET$requiresGopRemainingFrames);
    }

    public VkVideoEncodeH264CapabilitiesKHR requiresGopRemainingFrames(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$requiresGopRemainingFrames, OFFSET$requiresGopRemainingFrames, value);
        return this;
    }

    public @Bitmask(VkVideoEncodeH264StdFlagsKHR.class) int stdSyntaxFlags() {
        return segment.get(LAYOUT$stdSyntaxFlags, OFFSET$stdSyntaxFlags);
    }

    public VkVideoEncodeH264CapabilitiesKHR stdSyntaxFlags(@Bitmask(VkVideoEncodeH264StdFlagsKHR.class) int value) {
        segment.set(LAYOUT$stdSyntaxFlags, OFFSET$stdSyntaxFlags, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("maxLevelIdc"),
        ValueLayout.JAVA_INT.withName("maxSliceCount"),
        ValueLayout.JAVA_INT.withName("maxPPictureL0ReferenceCount"),
        ValueLayout.JAVA_INT.withName("maxBPictureL0ReferenceCount"),
        ValueLayout.JAVA_INT.withName("maxL1ReferenceCount"),
        ValueLayout.JAVA_INT.withName("maxTemporalLayerCount"),
        ValueLayout.JAVA_INT.withName("expectDyadicTemporalLayerPattern"),
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
    public static final PathElement PATH$maxSliceCount = PathElement.groupElement("maxSliceCount");
    public static final PathElement PATH$maxPPictureL0ReferenceCount = PathElement.groupElement("maxPPictureL0ReferenceCount");
    public static final PathElement PATH$maxBPictureL0ReferenceCount = PathElement.groupElement("maxBPictureL0ReferenceCount");
    public static final PathElement PATH$maxL1ReferenceCount = PathElement.groupElement("maxL1ReferenceCount");
    public static final PathElement PATH$maxTemporalLayerCount = PathElement.groupElement("maxTemporalLayerCount");
    public static final PathElement PATH$expectDyadicTemporalLayerPattern = PathElement.groupElement("expectDyadicTemporalLayerPattern");
    public static final PathElement PATH$minQp = PathElement.groupElement("minQp");
    public static final PathElement PATH$maxQp = PathElement.groupElement("maxQp");
    public static final PathElement PATH$prefersGopRemainingFrames = PathElement.groupElement("prefersGopRemainingFrames");
    public static final PathElement PATH$requiresGopRemainingFrames = PathElement.groupElement("requiresGopRemainingFrames");
    public static final PathElement PATH$stdSyntaxFlags = PathElement.groupElement("stdSyntaxFlags");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$maxLevelIdc = (OfInt) LAYOUT.select(PATH$maxLevelIdc);
    public static final OfInt LAYOUT$maxSliceCount = (OfInt) LAYOUT.select(PATH$maxSliceCount);
    public static final OfInt LAYOUT$maxPPictureL0ReferenceCount = (OfInt) LAYOUT.select(PATH$maxPPictureL0ReferenceCount);
    public static final OfInt LAYOUT$maxBPictureL0ReferenceCount = (OfInt) LAYOUT.select(PATH$maxBPictureL0ReferenceCount);
    public static final OfInt LAYOUT$maxL1ReferenceCount = (OfInt) LAYOUT.select(PATH$maxL1ReferenceCount);
    public static final OfInt LAYOUT$maxTemporalLayerCount = (OfInt) LAYOUT.select(PATH$maxTemporalLayerCount);
    public static final OfInt LAYOUT$expectDyadicTemporalLayerPattern = (OfInt) LAYOUT.select(PATH$expectDyadicTemporalLayerPattern);
    public static final OfInt LAYOUT$minQp = (OfInt) LAYOUT.select(PATH$minQp);
    public static final OfInt LAYOUT$maxQp = (OfInt) LAYOUT.select(PATH$maxQp);
    public static final OfInt LAYOUT$prefersGopRemainingFrames = (OfInt) LAYOUT.select(PATH$prefersGopRemainingFrames);
    public static final OfInt LAYOUT$requiresGopRemainingFrames = (OfInt) LAYOUT.select(PATH$requiresGopRemainingFrames);
    public static final OfInt LAYOUT$stdSyntaxFlags = (OfInt) LAYOUT.select(PATH$stdSyntaxFlags);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$maxLevelIdc = LAYOUT$maxLevelIdc.byteSize();
    public static final long SIZE$maxSliceCount = LAYOUT$maxSliceCount.byteSize();
    public static final long SIZE$maxPPictureL0ReferenceCount = LAYOUT$maxPPictureL0ReferenceCount.byteSize();
    public static final long SIZE$maxBPictureL0ReferenceCount = LAYOUT$maxBPictureL0ReferenceCount.byteSize();
    public static final long SIZE$maxL1ReferenceCount = LAYOUT$maxL1ReferenceCount.byteSize();
    public static final long SIZE$maxTemporalLayerCount = LAYOUT$maxTemporalLayerCount.byteSize();
    public static final long SIZE$expectDyadicTemporalLayerPattern = LAYOUT$expectDyadicTemporalLayerPattern.byteSize();
    public static final long SIZE$minQp = LAYOUT$minQp.byteSize();
    public static final long SIZE$maxQp = LAYOUT$maxQp.byteSize();
    public static final long SIZE$prefersGopRemainingFrames = LAYOUT$prefersGopRemainingFrames.byteSize();
    public static final long SIZE$requiresGopRemainingFrames = LAYOUT$requiresGopRemainingFrames.byteSize();
    public static final long SIZE$stdSyntaxFlags = LAYOUT$stdSyntaxFlags.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$maxLevelIdc = LAYOUT.byteOffset(PATH$maxLevelIdc);
    public static final long OFFSET$maxSliceCount = LAYOUT.byteOffset(PATH$maxSliceCount);
    public static final long OFFSET$maxPPictureL0ReferenceCount = LAYOUT.byteOffset(PATH$maxPPictureL0ReferenceCount);
    public static final long OFFSET$maxBPictureL0ReferenceCount = LAYOUT.byteOffset(PATH$maxBPictureL0ReferenceCount);
    public static final long OFFSET$maxL1ReferenceCount = LAYOUT.byteOffset(PATH$maxL1ReferenceCount);
    public static final long OFFSET$maxTemporalLayerCount = LAYOUT.byteOffset(PATH$maxTemporalLayerCount);
    public static final long OFFSET$expectDyadicTemporalLayerPattern = LAYOUT.byteOffset(PATH$expectDyadicTemporalLayerPattern);
    public static final long OFFSET$minQp = LAYOUT.byteOffset(PATH$minQp);
    public static final long OFFSET$maxQp = LAYOUT.byteOffset(PATH$maxQp);
    public static final long OFFSET$prefersGopRemainingFrames = LAYOUT.byteOffset(PATH$prefersGopRemainingFrames);
    public static final long OFFSET$requiresGopRemainingFrames = LAYOUT.byteOffset(PATH$requiresGopRemainingFrames);
    public static final long OFFSET$stdSyntaxFlags = LAYOUT.byteOffset(PATH$stdSyntaxFlags);
}
