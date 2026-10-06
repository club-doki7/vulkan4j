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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeH265RateControlInfoKHR.html"><code>VkVideoEncodeH265RateControlInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkVideoEncodeH265RateControlInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkVideoEncodeH265RateControlFlagsKHR flags; // optional // @link substring="VkVideoEncodeH265RateControlFlagsKHR" target="VkVideoEncodeH265RateControlFlagsKHR" @link substring="flags" target="#flags"
///     uint32_t gopFrameCount; // @link substring="gopFrameCount" target="#gopFrameCount"
///     uint32_t idrPeriod; // @link substring="idrPeriod" target="#idrPeriod"
///     uint32_t consecutiveBFrameCount; // @link substring="consecutiveBFrameCount" target="#consecutiveBFrameCount"
///     uint32_t subLayerCount; // @link substring="subLayerCount" target="#subLayerCount"
/// } VkVideoEncodeH265RateControlInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_VIDEO_ENCODE_H265_RATE_CONTROL_INFO_KHR`
///
/// The {@code allocate} ({@link VkVideoEncodeH265RateControlInfoKHR#allocate(Arena)}, {@link VkVideoEncodeH265RateControlInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkVideoEncodeH265RateControlInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeH265RateControlInfoKHR.html"><code>VkVideoEncodeH265RateControlInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkVideoEncodeH265RateControlInfoKHR(@NotNull MemorySegment segment) implements IVkVideoEncodeH265RateControlInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeH265RateControlInfoKHR.html"><code>VkVideoEncodeH265RateControlInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkVideoEncodeH265RateControlInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkVideoEncodeH265RateControlInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkVideoEncodeH265RateControlInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkVideoEncodeH265RateControlInfoKHR, Iterable<VkVideoEncodeH265RateControlInfoKHR> {
        public long size() {
            return segment.byteSize() / VkVideoEncodeH265RateControlInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkVideoEncodeH265RateControlInfoKHR at(long index) {
            return new VkVideoEncodeH265RateControlInfoKHR(segment.asSlice(index * VkVideoEncodeH265RateControlInfoKHR.BYTES, VkVideoEncodeH265RateControlInfoKHR.BYTES));
        }

        public VkVideoEncodeH265RateControlInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkVideoEncodeH265RateControlInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkVideoEncodeH265RateControlInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkVideoEncodeH265RateControlInfoKHR.BYTES, VkVideoEncodeH265RateControlInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkVideoEncodeH265RateControlInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkVideoEncodeH265RateControlInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkVideoEncodeH265RateControlInfoKHR.BYTES,
                (end - start) * VkVideoEncodeH265RateControlInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkVideoEncodeH265RateControlInfoKHR.BYTES));
        }

        public VkVideoEncodeH265RateControlInfoKHR[] toArray() {
            VkVideoEncodeH265RateControlInfoKHR[] ret = new VkVideoEncodeH265RateControlInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkVideoEncodeH265RateControlInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkVideoEncodeH265RateControlInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkVideoEncodeH265RateControlInfoKHR.BYTES;
            }

            @Override
            public VkVideoEncodeH265RateControlInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkVideoEncodeH265RateControlInfoKHR ret = new VkVideoEncodeH265RateControlInfoKHR(segment.asSlice(0, VkVideoEncodeH265RateControlInfoKHR.BYTES));
                segment = segment.asSlice(VkVideoEncodeH265RateControlInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkVideoEncodeH265RateControlInfoKHR allocate(Arena arena) {
        VkVideoEncodeH265RateControlInfoKHR ret = new VkVideoEncodeH265RateControlInfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.VIDEO_ENCODE_H265_RATE_CONTROL_INFO_KHR);
        return ret;
    }

    public static VkVideoEncodeH265RateControlInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkVideoEncodeH265RateControlInfoKHR.Ptr ret = new VkVideoEncodeH265RateControlInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.VIDEO_ENCODE_H265_RATE_CONTROL_INFO_KHR);
        }
        return ret;
    }

    public static VkVideoEncodeH265RateControlInfoKHR clone(Arena arena, VkVideoEncodeH265RateControlInfoKHR src) {
        VkVideoEncodeH265RateControlInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.VIDEO_ENCODE_H265_RATE_CONTROL_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkVideoEncodeH265RateControlInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkVideoEncodeH265RateControlInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkVideoEncodeH265RateControlInfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkVideoEncodeH265RateControlFlagsKHR.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkVideoEncodeH265RateControlInfoKHR flags(@Bitmask(VkVideoEncodeH265RateControlFlagsKHR.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @Unsigned int gopFrameCount() {
        return segment.get(LAYOUT$gopFrameCount, OFFSET$gopFrameCount);
    }

    public VkVideoEncodeH265RateControlInfoKHR gopFrameCount(@Unsigned int value) {
        segment.set(LAYOUT$gopFrameCount, OFFSET$gopFrameCount, value);
        return this;
    }

    public @Unsigned int idrPeriod() {
        return segment.get(LAYOUT$idrPeriod, OFFSET$idrPeriod);
    }

    public VkVideoEncodeH265RateControlInfoKHR idrPeriod(@Unsigned int value) {
        segment.set(LAYOUT$idrPeriod, OFFSET$idrPeriod, value);
        return this;
    }

    public @Unsigned int consecutiveBFrameCount() {
        return segment.get(LAYOUT$consecutiveBFrameCount, OFFSET$consecutiveBFrameCount);
    }

    public VkVideoEncodeH265RateControlInfoKHR consecutiveBFrameCount(@Unsigned int value) {
        segment.set(LAYOUT$consecutiveBFrameCount, OFFSET$consecutiveBFrameCount, value);
        return this;
    }

    public @Unsigned int subLayerCount() {
        return segment.get(LAYOUT$subLayerCount, OFFSET$subLayerCount);
    }

    public VkVideoEncodeH265RateControlInfoKHR subLayerCount(@Unsigned int value) {
        segment.set(LAYOUT$subLayerCount, OFFSET$subLayerCount, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("gopFrameCount"),
        ValueLayout.JAVA_INT.withName("idrPeriod"),
        ValueLayout.JAVA_INT.withName("consecutiveBFrameCount"),
        ValueLayout.JAVA_INT.withName("subLayerCount")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$gopFrameCount = PathElement.groupElement("gopFrameCount");
    public static final PathElement PATH$idrPeriod = PathElement.groupElement("idrPeriod");
    public static final PathElement PATH$consecutiveBFrameCount = PathElement.groupElement("consecutiveBFrameCount");
    public static final PathElement PATH$subLayerCount = PathElement.groupElement("subLayerCount");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$gopFrameCount = (OfInt) LAYOUT.select(PATH$gopFrameCount);
    public static final OfInt LAYOUT$idrPeriod = (OfInt) LAYOUT.select(PATH$idrPeriod);
    public static final OfInt LAYOUT$consecutiveBFrameCount = (OfInt) LAYOUT.select(PATH$consecutiveBFrameCount);
    public static final OfInt LAYOUT$subLayerCount = (OfInt) LAYOUT.select(PATH$subLayerCount);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$gopFrameCount = LAYOUT$gopFrameCount.byteSize();
    public static final long SIZE$idrPeriod = LAYOUT$idrPeriod.byteSize();
    public static final long SIZE$consecutiveBFrameCount = LAYOUT$consecutiveBFrameCount.byteSize();
    public static final long SIZE$subLayerCount = LAYOUT$subLayerCount.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$gopFrameCount = LAYOUT.byteOffset(PATH$gopFrameCount);
    public static final long OFFSET$idrPeriod = LAYOUT.byteOffset(PATH$idrPeriod);
    public static final long OFFSET$consecutiveBFrameCount = LAYOUT.byteOffset(PATH$consecutiveBFrameCount);
    public static final long OFFSET$subLayerCount = LAYOUT.byteOffset(PATH$subLayerCount);
}
