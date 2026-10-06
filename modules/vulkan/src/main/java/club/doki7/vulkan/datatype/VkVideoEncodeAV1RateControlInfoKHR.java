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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeAV1RateControlInfoKHR.html"><code>VkVideoEncodeAV1RateControlInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkVideoEncodeAV1RateControlInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkVideoEncodeAV1RateControlFlagsKHR flags; // optional // @link substring="VkVideoEncodeAV1RateControlFlagsKHR" target="VkVideoEncodeAV1RateControlFlagsKHR" @link substring="flags" target="#flags"
///     uint32_t gopFrameCount; // @link substring="gopFrameCount" target="#gopFrameCount"
///     uint32_t keyFramePeriod; // @link substring="keyFramePeriod" target="#keyFramePeriod"
///     uint32_t consecutiveBipredictiveFrameCount; // @link substring="consecutiveBipredictiveFrameCount" target="#consecutiveBipredictiveFrameCount"
///     uint32_t temporalLayerCount; // @link substring="temporalLayerCount" target="#temporalLayerCount"
/// } VkVideoEncodeAV1RateControlInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_VIDEO_ENCODE_AV1_RATE_CONTROL_INFO_KHR`
///
/// The {@code allocate} ({@link VkVideoEncodeAV1RateControlInfoKHR#allocate(Arena)}, {@link VkVideoEncodeAV1RateControlInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkVideoEncodeAV1RateControlInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeAV1RateControlInfoKHR.html"><code>VkVideoEncodeAV1RateControlInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkVideoEncodeAV1RateControlInfoKHR(@NotNull MemorySegment segment) implements IVkVideoEncodeAV1RateControlInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeAV1RateControlInfoKHR.html"><code>VkVideoEncodeAV1RateControlInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkVideoEncodeAV1RateControlInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkVideoEncodeAV1RateControlInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkVideoEncodeAV1RateControlInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkVideoEncodeAV1RateControlInfoKHR, Iterable<VkVideoEncodeAV1RateControlInfoKHR> {
        public long size() {
            return segment.byteSize() / VkVideoEncodeAV1RateControlInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkVideoEncodeAV1RateControlInfoKHR at(long index) {
            return new VkVideoEncodeAV1RateControlInfoKHR(segment.asSlice(index * VkVideoEncodeAV1RateControlInfoKHR.BYTES, VkVideoEncodeAV1RateControlInfoKHR.BYTES));
        }

        public VkVideoEncodeAV1RateControlInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkVideoEncodeAV1RateControlInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkVideoEncodeAV1RateControlInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkVideoEncodeAV1RateControlInfoKHR.BYTES, VkVideoEncodeAV1RateControlInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkVideoEncodeAV1RateControlInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkVideoEncodeAV1RateControlInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkVideoEncodeAV1RateControlInfoKHR.BYTES,
                (end - start) * VkVideoEncodeAV1RateControlInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkVideoEncodeAV1RateControlInfoKHR.BYTES));
        }

        public VkVideoEncodeAV1RateControlInfoKHR[] toArray() {
            VkVideoEncodeAV1RateControlInfoKHR[] ret = new VkVideoEncodeAV1RateControlInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkVideoEncodeAV1RateControlInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkVideoEncodeAV1RateControlInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkVideoEncodeAV1RateControlInfoKHR.BYTES;
            }

            @Override
            public VkVideoEncodeAV1RateControlInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkVideoEncodeAV1RateControlInfoKHR ret = new VkVideoEncodeAV1RateControlInfoKHR(segment.asSlice(0, VkVideoEncodeAV1RateControlInfoKHR.BYTES));
                segment = segment.asSlice(VkVideoEncodeAV1RateControlInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkVideoEncodeAV1RateControlInfoKHR allocate(Arena arena) {
        VkVideoEncodeAV1RateControlInfoKHR ret = new VkVideoEncodeAV1RateControlInfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.VIDEO_ENCODE_AV1_RATE_CONTROL_INFO_KHR);
        return ret;
    }

    public static VkVideoEncodeAV1RateControlInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkVideoEncodeAV1RateControlInfoKHR.Ptr ret = new VkVideoEncodeAV1RateControlInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.VIDEO_ENCODE_AV1_RATE_CONTROL_INFO_KHR);
        }
        return ret;
    }

    public static VkVideoEncodeAV1RateControlInfoKHR clone(Arena arena, VkVideoEncodeAV1RateControlInfoKHR src) {
        VkVideoEncodeAV1RateControlInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.VIDEO_ENCODE_AV1_RATE_CONTROL_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkVideoEncodeAV1RateControlInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkVideoEncodeAV1RateControlInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkVideoEncodeAV1RateControlInfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkVideoEncodeAV1RateControlFlagsKHR.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkVideoEncodeAV1RateControlInfoKHR flags(@Bitmask(VkVideoEncodeAV1RateControlFlagsKHR.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @Unsigned int gopFrameCount() {
        return segment.get(LAYOUT$gopFrameCount, OFFSET$gopFrameCount);
    }

    public VkVideoEncodeAV1RateControlInfoKHR gopFrameCount(@Unsigned int value) {
        segment.set(LAYOUT$gopFrameCount, OFFSET$gopFrameCount, value);
        return this;
    }

    public @Unsigned int keyFramePeriod() {
        return segment.get(LAYOUT$keyFramePeriod, OFFSET$keyFramePeriod);
    }

    public VkVideoEncodeAV1RateControlInfoKHR keyFramePeriod(@Unsigned int value) {
        segment.set(LAYOUT$keyFramePeriod, OFFSET$keyFramePeriod, value);
        return this;
    }

    public @Unsigned int consecutiveBipredictiveFrameCount() {
        return segment.get(LAYOUT$consecutiveBipredictiveFrameCount, OFFSET$consecutiveBipredictiveFrameCount);
    }

    public VkVideoEncodeAV1RateControlInfoKHR consecutiveBipredictiveFrameCount(@Unsigned int value) {
        segment.set(LAYOUT$consecutiveBipredictiveFrameCount, OFFSET$consecutiveBipredictiveFrameCount, value);
        return this;
    }

    public @Unsigned int temporalLayerCount() {
        return segment.get(LAYOUT$temporalLayerCount, OFFSET$temporalLayerCount);
    }

    public VkVideoEncodeAV1RateControlInfoKHR temporalLayerCount(@Unsigned int value) {
        segment.set(LAYOUT$temporalLayerCount, OFFSET$temporalLayerCount, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("gopFrameCount"),
        ValueLayout.JAVA_INT.withName("keyFramePeriod"),
        ValueLayout.JAVA_INT.withName("consecutiveBipredictiveFrameCount"),
        ValueLayout.JAVA_INT.withName("temporalLayerCount")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$gopFrameCount = PathElement.groupElement("gopFrameCount");
    public static final PathElement PATH$keyFramePeriod = PathElement.groupElement("keyFramePeriod");
    public static final PathElement PATH$consecutiveBipredictiveFrameCount = PathElement.groupElement("consecutiveBipredictiveFrameCount");
    public static final PathElement PATH$temporalLayerCount = PathElement.groupElement("temporalLayerCount");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$gopFrameCount = (OfInt) LAYOUT.select(PATH$gopFrameCount);
    public static final OfInt LAYOUT$keyFramePeriod = (OfInt) LAYOUT.select(PATH$keyFramePeriod);
    public static final OfInt LAYOUT$consecutiveBipredictiveFrameCount = (OfInt) LAYOUT.select(PATH$consecutiveBipredictiveFrameCount);
    public static final OfInt LAYOUT$temporalLayerCount = (OfInt) LAYOUT.select(PATH$temporalLayerCount);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$gopFrameCount = LAYOUT$gopFrameCount.byteSize();
    public static final long SIZE$keyFramePeriod = LAYOUT$keyFramePeriod.byteSize();
    public static final long SIZE$consecutiveBipredictiveFrameCount = LAYOUT$consecutiveBipredictiveFrameCount.byteSize();
    public static final long SIZE$temporalLayerCount = LAYOUT$temporalLayerCount.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$gopFrameCount = LAYOUT.byteOffset(PATH$gopFrameCount);
    public static final long OFFSET$keyFramePeriod = LAYOUT.byteOffset(PATH$keyFramePeriod);
    public static final long OFFSET$consecutiveBipredictiveFrameCount = LAYOUT.byteOffset(PATH$consecutiveBipredictiveFrameCount);
    public static final long OFFSET$temporalLayerCount = LAYOUT.byteOffset(PATH$temporalLayerCount);
}
