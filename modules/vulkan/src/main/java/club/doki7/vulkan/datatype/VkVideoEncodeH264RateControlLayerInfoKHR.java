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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeH264RateControlLayerInfoKHR.html"><code>VkVideoEncodeH264RateControlLayerInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkVideoEncodeH264RateControlLayerInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 useMinQp; // @link substring="useMinQp" target="#useMinQp"
///     VkVideoEncodeH264QpKHR minQp; // @link substring="VkVideoEncodeH264QpKHR" target="VkVideoEncodeH264QpKHR" @link substring="minQp" target="#minQp"
///     VkBool32 useMaxQp; // @link substring="useMaxQp" target="#useMaxQp"
///     VkVideoEncodeH264QpKHR maxQp; // @link substring="VkVideoEncodeH264QpKHR" target="VkVideoEncodeH264QpKHR" @link substring="maxQp" target="#maxQp"
///     VkBool32 useMaxFrameSize; // @link substring="useMaxFrameSize" target="#useMaxFrameSize"
///     VkVideoEncodeH264FrameSizeKHR maxFrameSize; // @link substring="VkVideoEncodeH264FrameSizeKHR" target="VkVideoEncodeH264FrameSizeKHR" @link substring="maxFrameSize" target="#maxFrameSize"
/// } VkVideoEncodeH264RateControlLayerInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_VIDEO_ENCODE_H264_RATE_CONTROL_LAYER_INFO_KHR`
///
/// The {@code allocate} ({@link VkVideoEncodeH264RateControlLayerInfoKHR#allocate(Arena)}, {@link VkVideoEncodeH264RateControlLayerInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkVideoEncodeH264RateControlLayerInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeH264RateControlLayerInfoKHR.html"><code>VkVideoEncodeH264RateControlLayerInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkVideoEncodeH264RateControlLayerInfoKHR(@NotNull MemorySegment segment) implements IVkVideoEncodeH264RateControlLayerInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeH264RateControlLayerInfoKHR.html"><code>VkVideoEncodeH264RateControlLayerInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkVideoEncodeH264RateControlLayerInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkVideoEncodeH264RateControlLayerInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkVideoEncodeH264RateControlLayerInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkVideoEncodeH264RateControlLayerInfoKHR, Iterable<VkVideoEncodeH264RateControlLayerInfoKHR> {
        public long size() {
            return segment.byteSize() / VkVideoEncodeH264RateControlLayerInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkVideoEncodeH264RateControlLayerInfoKHR at(long index) {
            return new VkVideoEncodeH264RateControlLayerInfoKHR(segment.asSlice(index * VkVideoEncodeH264RateControlLayerInfoKHR.BYTES, VkVideoEncodeH264RateControlLayerInfoKHR.BYTES));
        }

        public VkVideoEncodeH264RateControlLayerInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkVideoEncodeH264RateControlLayerInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkVideoEncodeH264RateControlLayerInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkVideoEncodeH264RateControlLayerInfoKHR.BYTES, VkVideoEncodeH264RateControlLayerInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkVideoEncodeH264RateControlLayerInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkVideoEncodeH264RateControlLayerInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkVideoEncodeH264RateControlLayerInfoKHR.BYTES,
                (end - start) * VkVideoEncodeH264RateControlLayerInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkVideoEncodeH264RateControlLayerInfoKHR.BYTES));
        }

        public VkVideoEncodeH264RateControlLayerInfoKHR[] toArray() {
            VkVideoEncodeH264RateControlLayerInfoKHR[] ret = new VkVideoEncodeH264RateControlLayerInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkVideoEncodeH264RateControlLayerInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkVideoEncodeH264RateControlLayerInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkVideoEncodeH264RateControlLayerInfoKHR.BYTES;
            }

            @Override
            public VkVideoEncodeH264RateControlLayerInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkVideoEncodeH264RateControlLayerInfoKHR ret = new VkVideoEncodeH264RateControlLayerInfoKHR(segment.asSlice(0, VkVideoEncodeH264RateControlLayerInfoKHR.BYTES));
                segment = segment.asSlice(VkVideoEncodeH264RateControlLayerInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkVideoEncodeH264RateControlLayerInfoKHR allocate(Arena arena) {
        VkVideoEncodeH264RateControlLayerInfoKHR ret = new VkVideoEncodeH264RateControlLayerInfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.VIDEO_ENCODE_H264_RATE_CONTROL_LAYER_INFO_KHR);
        return ret;
    }

    public static VkVideoEncodeH264RateControlLayerInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkVideoEncodeH264RateControlLayerInfoKHR.Ptr ret = new VkVideoEncodeH264RateControlLayerInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.VIDEO_ENCODE_H264_RATE_CONTROL_LAYER_INFO_KHR);
        }
        return ret;
    }

    public static VkVideoEncodeH264RateControlLayerInfoKHR clone(Arena arena, VkVideoEncodeH264RateControlLayerInfoKHR src) {
        VkVideoEncodeH264RateControlLayerInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.VIDEO_ENCODE_H264_RATE_CONTROL_LAYER_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkVideoEncodeH264RateControlLayerInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkVideoEncodeH264RateControlLayerInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkVideoEncodeH264RateControlLayerInfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int useMinQp() {
        return segment.get(LAYOUT$useMinQp, OFFSET$useMinQp);
    }

    public VkVideoEncodeH264RateControlLayerInfoKHR useMinQp(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$useMinQp, OFFSET$useMinQp, value);
        return this;
    }

    public @NotNull VkVideoEncodeH264QpKHR minQp() {
        return new VkVideoEncodeH264QpKHR(segment.asSlice(OFFSET$minQp, LAYOUT$minQp));
    }

    public VkVideoEncodeH264RateControlLayerInfoKHR minQp(@NotNull VkVideoEncodeH264QpKHR value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$minQp, SIZE$minQp);
        return this;
    }

    public VkVideoEncodeH264RateControlLayerInfoKHR minQp(Consumer<@NotNull VkVideoEncodeH264QpKHR> consumer) {
        consumer.accept(minQp());
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int useMaxQp() {
        return segment.get(LAYOUT$useMaxQp, OFFSET$useMaxQp);
    }

    public VkVideoEncodeH264RateControlLayerInfoKHR useMaxQp(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$useMaxQp, OFFSET$useMaxQp, value);
        return this;
    }

    public @NotNull VkVideoEncodeH264QpKHR maxQp() {
        return new VkVideoEncodeH264QpKHR(segment.asSlice(OFFSET$maxQp, LAYOUT$maxQp));
    }

    public VkVideoEncodeH264RateControlLayerInfoKHR maxQp(@NotNull VkVideoEncodeH264QpKHR value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$maxQp, SIZE$maxQp);
        return this;
    }

    public VkVideoEncodeH264RateControlLayerInfoKHR maxQp(Consumer<@NotNull VkVideoEncodeH264QpKHR> consumer) {
        consumer.accept(maxQp());
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int useMaxFrameSize() {
        return segment.get(LAYOUT$useMaxFrameSize, OFFSET$useMaxFrameSize);
    }

    public VkVideoEncodeH264RateControlLayerInfoKHR useMaxFrameSize(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$useMaxFrameSize, OFFSET$useMaxFrameSize, value);
        return this;
    }

    public @NotNull VkVideoEncodeH264FrameSizeKHR maxFrameSize() {
        return new VkVideoEncodeH264FrameSizeKHR(segment.asSlice(OFFSET$maxFrameSize, LAYOUT$maxFrameSize));
    }

    public VkVideoEncodeH264RateControlLayerInfoKHR maxFrameSize(@NotNull VkVideoEncodeH264FrameSizeKHR value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$maxFrameSize, SIZE$maxFrameSize);
        return this;
    }

    public VkVideoEncodeH264RateControlLayerInfoKHR maxFrameSize(Consumer<@NotNull VkVideoEncodeH264FrameSizeKHR> consumer) {
        consumer.accept(maxFrameSize());
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("useMinQp"),
        VkVideoEncodeH264QpKHR.LAYOUT.withName("minQp"),
        ValueLayout.JAVA_INT.withName("useMaxQp"),
        VkVideoEncodeH264QpKHR.LAYOUT.withName("maxQp"),
        ValueLayout.JAVA_INT.withName("useMaxFrameSize"),
        VkVideoEncodeH264FrameSizeKHR.LAYOUT.withName("maxFrameSize")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$useMinQp = PathElement.groupElement("useMinQp");
    public static final PathElement PATH$minQp = PathElement.groupElement("minQp");
    public static final PathElement PATH$useMaxQp = PathElement.groupElement("useMaxQp");
    public static final PathElement PATH$maxQp = PathElement.groupElement("maxQp");
    public static final PathElement PATH$useMaxFrameSize = PathElement.groupElement("useMaxFrameSize");
    public static final PathElement PATH$maxFrameSize = PathElement.groupElement("maxFrameSize");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$useMinQp = (OfInt) LAYOUT.select(PATH$useMinQp);
    public static final StructLayout LAYOUT$minQp = (StructLayout) LAYOUT.select(PATH$minQp);
    public static final OfInt LAYOUT$useMaxQp = (OfInt) LAYOUT.select(PATH$useMaxQp);
    public static final StructLayout LAYOUT$maxQp = (StructLayout) LAYOUT.select(PATH$maxQp);
    public static final OfInt LAYOUT$useMaxFrameSize = (OfInt) LAYOUT.select(PATH$useMaxFrameSize);
    public static final StructLayout LAYOUT$maxFrameSize = (StructLayout) LAYOUT.select(PATH$maxFrameSize);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$useMinQp = LAYOUT$useMinQp.byteSize();
    public static final long SIZE$minQp = LAYOUT$minQp.byteSize();
    public static final long SIZE$useMaxQp = LAYOUT$useMaxQp.byteSize();
    public static final long SIZE$maxQp = LAYOUT$maxQp.byteSize();
    public static final long SIZE$useMaxFrameSize = LAYOUT$useMaxFrameSize.byteSize();
    public static final long SIZE$maxFrameSize = LAYOUT$maxFrameSize.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$useMinQp = LAYOUT.byteOffset(PATH$useMinQp);
    public static final long OFFSET$minQp = LAYOUT.byteOffset(PATH$minQp);
    public static final long OFFSET$useMaxQp = LAYOUT.byteOffset(PATH$useMaxQp);
    public static final long OFFSET$maxQp = LAYOUT.byteOffset(PATH$maxQp);
    public static final long OFFSET$useMaxFrameSize = LAYOUT.byteOffset(PATH$useMaxFrameSize);
    public static final long OFFSET$maxFrameSize = LAYOUT.byteOffset(PATH$maxFrameSize);
}
