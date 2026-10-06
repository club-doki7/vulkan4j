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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeCapabilitiesKHR.html"><code>VkVideoEncodeCapabilitiesKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkVideoEncodeCapabilitiesKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkVideoEncodeCapabilityFlagsKHR flags; // @link substring="VkVideoEncodeCapabilityFlagsKHR" target="VkVideoEncodeCapabilityFlagsKHR" @link substring="flags" target="#flags"
///     VkVideoEncodeRateControlModeFlagsKHR rateControlModes; // @link substring="VkVideoEncodeRateControlModeFlagsKHR" target="VkVideoEncodeRateControlModeFlagsKHR" @link substring="rateControlModes" target="#rateControlModes"
///     uint32_t maxRateControlLayers; // @link substring="maxRateControlLayers" target="#maxRateControlLayers"
///     uint64_t maxBitrate; // @link substring="maxBitrate" target="#maxBitrate"
///     uint32_t maxQualityLevels; // @link substring="maxQualityLevels" target="#maxQualityLevels"
///     VkExtent2D encodeInputPictureGranularity; // @link substring="VkExtent2D" target="VkExtent2D" @link substring="encodeInputPictureGranularity" target="#encodeInputPictureGranularity"
///     VkVideoEncodeFeedbackFlagsKHR supportedEncodeFeedbackFlags; // @link substring="VkVideoEncodeFeedbackFlagsKHR" target="VkVideoEncodeFeedbackFlagsKHR" @link substring="supportedEncodeFeedbackFlags" target="#supportedEncodeFeedbackFlags"
/// } VkVideoEncodeCapabilitiesKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_VIDEO_ENCODE_CAPABILITIES_KHR`
///
/// The {@code allocate} ({@link VkVideoEncodeCapabilitiesKHR#allocate(Arena)}, {@link VkVideoEncodeCapabilitiesKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkVideoEncodeCapabilitiesKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeCapabilitiesKHR.html"><code>VkVideoEncodeCapabilitiesKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkVideoEncodeCapabilitiesKHR(@NotNull MemorySegment segment) implements IVkVideoEncodeCapabilitiesKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeCapabilitiesKHR.html"><code>VkVideoEncodeCapabilitiesKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkVideoEncodeCapabilitiesKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkVideoEncodeCapabilitiesKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkVideoEncodeCapabilitiesKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkVideoEncodeCapabilitiesKHR, Iterable<VkVideoEncodeCapabilitiesKHR> {
        public long size() {
            return segment.byteSize() / VkVideoEncodeCapabilitiesKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkVideoEncodeCapabilitiesKHR at(long index) {
            return new VkVideoEncodeCapabilitiesKHR(segment.asSlice(index * VkVideoEncodeCapabilitiesKHR.BYTES, VkVideoEncodeCapabilitiesKHR.BYTES));
        }

        public VkVideoEncodeCapabilitiesKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkVideoEncodeCapabilitiesKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkVideoEncodeCapabilitiesKHR value) {
            MemorySegment s = segment.asSlice(index * VkVideoEncodeCapabilitiesKHR.BYTES, VkVideoEncodeCapabilitiesKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkVideoEncodeCapabilitiesKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkVideoEncodeCapabilitiesKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkVideoEncodeCapabilitiesKHR.BYTES,
                (end - start) * VkVideoEncodeCapabilitiesKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkVideoEncodeCapabilitiesKHR.BYTES));
        }

        public VkVideoEncodeCapabilitiesKHR[] toArray() {
            VkVideoEncodeCapabilitiesKHR[] ret = new VkVideoEncodeCapabilitiesKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkVideoEncodeCapabilitiesKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkVideoEncodeCapabilitiesKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkVideoEncodeCapabilitiesKHR.BYTES;
            }

            @Override
            public VkVideoEncodeCapabilitiesKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkVideoEncodeCapabilitiesKHR ret = new VkVideoEncodeCapabilitiesKHR(segment.asSlice(0, VkVideoEncodeCapabilitiesKHR.BYTES));
                segment = segment.asSlice(VkVideoEncodeCapabilitiesKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkVideoEncodeCapabilitiesKHR allocate(Arena arena) {
        VkVideoEncodeCapabilitiesKHR ret = new VkVideoEncodeCapabilitiesKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.VIDEO_ENCODE_CAPABILITIES_KHR);
        return ret;
    }

    public static VkVideoEncodeCapabilitiesKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkVideoEncodeCapabilitiesKHR.Ptr ret = new VkVideoEncodeCapabilitiesKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.VIDEO_ENCODE_CAPABILITIES_KHR);
        }
        return ret;
    }

    public static VkVideoEncodeCapabilitiesKHR clone(Arena arena, VkVideoEncodeCapabilitiesKHR src) {
        VkVideoEncodeCapabilitiesKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.VIDEO_ENCODE_CAPABILITIES_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkVideoEncodeCapabilitiesKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkVideoEncodeCapabilitiesKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkVideoEncodeCapabilitiesKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkVideoEncodeCapabilityFlagsKHR.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkVideoEncodeCapabilitiesKHR flags(@Bitmask(VkVideoEncodeCapabilityFlagsKHR.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @Bitmask(VkVideoEncodeRateControlModeFlagsKHR.class) int rateControlModes() {
        return segment.get(LAYOUT$rateControlModes, OFFSET$rateControlModes);
    }

    public VkVideoEncodeCapabilitiesKHR rateControlModes(@Bitmask(VkVideoEncodeRateControlModeFlagsKHR.class) int value) {
        segment.set(LAYOUT$rateControlModes, OFFSET$rateControlModes, value);
        return this;
    }

    public @Unsigned int maxRateControlLayers() {
        return segment.get(LAYOUT$maxRateControlLayers, OFFSET$maxRateControlLayers);
    }

    public VkVideoEncodeCapabilitiesKHR maxRateControlLayers(@Unsigned int value) {
        segment.set(LAYOUT$maxRateControlLayers, OFFSET$maxRateControlLayers, value);
        return this;
    }

    public @Unsigned long maxBitrate() {
        return segment.get(LAYOUT$maxBitrate, OFFSET$maxBitrate);
    }

    public VkVideoEncodeCapabilitiesKHR maxBitrate(@Unsigned long value) {
        segment.set(LAYOUT$maxBitrate, OFFSET$maxBitrate, value);
        return this;
    }

    public @Unsigned int maxQualityLevels() {
        return segment.get(LAYOUT$maxQualityLevels, OFFSET$maxQualityLevels);
    }

    public VkVideoEncodeCapabilitiesKHR maxQualityLevels(@Unsigned int value) {
        segment.set(LAYOUT$maxQualityLevels, OFFSET$maxQualityLevels, value);
        return this;
    }

    public @NotNull VkExtent2D encodeInputPictureGranularity() {
        return new VkExtent2D(segment.asSlice(OFFSET$encodeInputPictureGranularity, LAYOUT$encodeInputPictureGranularity));
    }

    public VkVideoEncodeCapabilitiesKHR encodeInputPictureGranularity(@NotNull VkExtent2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$encodeInputPictureGranularity, SIZE$encodeInputPictureGranularity);
        return this;
    }

    public VkVideoEncodeCapabilitiesKHR encodeInputPictureGranularity(Consumer<@NotNull VkExtent2D> consumer) {
        consumer.accept(encodeInputPictureGranularity());
        return this;
    }

    public @Bitmask(VkVideoEncodeFeedbackFlagsKHR.class) int supportedEncodeFeedbackFlags() {
        return segment.get(LAYOUT$supportedEncodeFeedbackFlags, OFFSET$supportedEncodeFeedbackFlags);
    }

    public VkVideoEncodeCapabilitiesKHR supportedEncodeFeedbackFlags(@Bitmask(VkVideoEncodeFeedbackFlagsKHR.class) int value) {
        segment.set(LAYOUT$supportedEncodeFeedbackFlags, OFFSET$supportedEncodeFeedbackFlags, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("rateControlModes"),
        ValueLayout.JAVA_INT.withName("maxRateControlLayers"),
        ValueLayout.JAVA_LONG.withName("maxBitrate"),
        ValueLayout.JAVA_INT.withName("maxQualityLevels"),
        VkExtent2D.LAYOUT.withName("encodeInputPictureGranularity"),
        ValueLayout.JAVA_INT.withName("supportedEncodeFeedbackFlags")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$rateControlModes = PathElement.groupElement("rateControlModes");
    public static final PathElement PATH$maxRateControlLayers = PathElement.groupElement("maxRateControlLayers");
    public static final PathElement PATH$maxBitrate = PathElement.groupElement("maxBitrate");
    public static final PathElement PATH$maxQualityLevels = PathElement.groupElement("maxQualityLevels");
    public static final PathElement PATH$encodeInputPictureGranularity = PathElement.groupElement("encodeInputPictureGranularity");
    public static final PathElement PATH$supportedEncodeFeedbackFlags = PathElement.groupElement("supportedEncodeFeedbackFlags");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$rateControlModes = (OfInt) LAYOUT.select(PATH$rateControlModes);
    public static final OfInt LAYOUT$maxRateControlLayers = (OfInt) LAYOUT.select(PATH$maxRateControlLayers);
    public static final OfLong LAYOUT$maxBitrate = (OfLong) LAYOUT.select(PATH$maxBitrate);
    public static final OfInt LAYOUT$maxQualityLevels = (OfInt) LAYOUT.select(PATH$maxQualityLevels);
    public static final StructLayout LAYOUT$encodeInputPictureGranularity = (StructLayout) LAYOUT.select(PATH$encodeInputPictureGranularity);
    public static final OfInt LAYOUT$supportedEncodeFeedbackFlags = (OfInt) LAYOUT.select(PATH$supportedEncodeFeedbackFlags);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$rateControlModes = LAYOUT$rateControlModes.byteSize();
    public static final long SIZE$maxRateControlLayers = LAYOUT$maxRateControlLayers.byteSize();
    public static final long SIZE$maxBitrate = LAYOUT$maxBitrate.byteSize();
    public static final long SIZE$maxQualityLevels = LAYOUT$maxQualityLevels.byteSize();
    public static final long SIZE$encodeInputPictureGranularity = LAYOUT$encodeInputPictureGranularity.byteSize();
    public static final long SIZE$supportedEncodeFeedbackFlags = LAYOUT$supportedEncodeFeedbackFlags.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$rateControlModes = LAYOUT.byteOffset(PATH$rateControlModes);
    public static final long OFFSET$maxRateControlLayers = LAYOUT.byteOffset(PATH$maxRateControlLayers);
    public static final long OFFSET$maxBitrate = LAYOUT.byteOffset(PATH$maxBitrate);
    public static final long OFFSET$maxQualityLevels = LAYOUT.byteOffset(PATH$maxQualityLevels);
    public static final long OFFSET$encodeInputPictureGranularity = LAYOUT.byteOffset(PATH$encodeInputPictureGranularity);
    public static final long OFFSET$supportedEncodeFeedbackFlags = LAYOUT.byteOffset(PATH$supportedEncodeFeedbackFlags);
}
