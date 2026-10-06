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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoDecodeH265InlineSessionParametersInfoKHR.html"><code>VkVideoDecodeH265InlineSessionParametersInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkVideoDecodeH265InlineSessionParametersInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     StdVideoH265VideoParameterSet const* pStdVPS; // optional // @link substring="StdVideoH265VideoParameterSet" target="StdVideoH265VideoParameterSet" @link substring="pStdVPS" target="#pStdVPS"
///     StdVideoH265SequenceParameterSet const* pStdSPS; // optional // @link substring="StdVideoH265SequenceParameterSet" target="StdVideoH265SequenceParameterSet" @link substring="pStdSPS" target="#pStdSPS"
///     StdVideoH265PictureParameterSet const* pStdPPS; // optional // @link substring="StdVideoH265PictureParameterSet" target="StdVideoH265PictureParameterSet" @link substring="pStdPPS" target="#pStdPPS"
/// } VkVideoDecodeH265InlineSessionParametersInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_VIDEO_DECODE_H265_INLINE_SESSION_PARAMETERS_INFO_KHR`
///
/// The {@code allocate} ({@link VkVideoDecodeH265InlineSessionParametersInfoKHR#allocate(Arena)}, {@link VkVideoDecodeH265InlineSessionParametersInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkVideoDecodeH265InlineSessionParametersInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoDecodeH265InlineSessionParametersInfoKHR.html"><code>VkVideoDecodeH265InlineSessionParametersInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkVideoDecodeH265InlineSessionParametersInfoKHR(@NotNull MemorySegment segment) implements IVkVideoDecodeH265InlineSessionParametersInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoDecodeH265InlineSessionParametersInfoKHR.html"><code>VkVideoDecodeH265InlineSessionParametersInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkVideoDecodeH265InlineSessionParametersInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkVideoDecodeH265InlineSessionParametersInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkVideoDecodeH265InlineSessionParametersInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkVideoDecodeH265InlineSessionParametersInfoKHR, Iterable<VkVideoDecodeH265InlineSessionParametersInfoKHR> {
        public long size() {
            return segment.byteSize() / VkVideoDecodeH265InlineSessionParametersInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkVideoDecodeH265InlineSessionParametersInfoKHR at(long index) {
            return new VkVideoDecodeH265InlineSessionParametersInfoKHR(segment.asSlice(index * VkVideoDecodeH265InlineSessionParametersInfoKHR.BYTES, VkVideoDecodeH265InlineSessionParametersInfoKHR.BYTES));
        }

        public VkVideoDecodeH265InlineSessionParametersInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkVideoDecodeH265InlineSessionParametersInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkVideoDecodeH265InlineSessionParametersInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkVideoDecodeH265InlineSessionParametersInfoKHR.BYTES, VkVideoDecodeH265InlineSessionParametersInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkVideoDecodeH265InlineSessionParametersInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkVideoDecodeH265InlineSessionParametersInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkVideoDecodeH265InlineSessionParametersInfoKHR.BYTES,
                (end - start) * VkVideoDecodeH265InlineSessionParametersInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkVideoDecodeH265InlineSessionParametersInfoKHR.BYTES));
        }

        public VkVideoDecodeH265InlineSessionParametersInfoKHR[] toArray() {
            VkVideoDecodeH265InlineSessionParametersInfoKHR[] ret = new VkVideoDecodeH265InlineSessionParametersInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkVideoDecodeH265InlineSessionParametersInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkVideoDecodeH265InlineSessionParametersInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkVideoDecodeH265InlineSessionParametersInfoKHR.BYTES;
            }

            @Override
            public VkVideoDecodeH265InlineSessionParametersInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkVideoDecodeH265InlineSessionParametersInfoKHR ret = new VkVideoDecodeH265InlineSessionParametersInfoKHR(segment.asSlice(0, VkVideoDecodeH265InlineSessionParametersInfoKHR.BYTES));
                segment = segment.asSlice(VkVideoDecodeH265InlineSessionParametersInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkVideoDecodeH265InlineSessionParametersInfoKHR allocate(Arena arena) {
        VkVideoDecodeH265InlineSessionParametersInfoKHR ret = new VkVideoDecodeH265InlineSessionParametersInfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.VIDEO_DECODE_H265_INLINE_SESSION_PARAMETERS_INFO_KHR);
        return ret;
    }

    public static VkVideoDecodeH265InlineSessionParametersInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkVideoDecodeH265InlineSessionParametersInfoKHR.Ptr ret = new VkVideoDecodeH265InlineSessionParametersInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.VIDEO_DECODE_H265_INLINE_SESSION_PARAMETERS_INFO_KHR);
        }
        return ret;
    }

    public static VkVideoDecodeH265InlineSessionParametersInfoKHR clone(Arena arena, VkVideoDecodeH265InlineSessionParametersInfoKHR src) {
        VkVideoDecodeH265InlineSessionParametersInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.VIDEO_DECODE_H265_INLINE_SESSION_PARAMETERS_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkVideoDecodeH265InlineSessionParametersInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkVideoDecodeH265InlineSessionParametersInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkVideoDecodeH265InlineSessionParametersInfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public VkVideoDecodeH265InlineSessionParametersInfoKHR pStdVPS(@Nullable IStdVideoH265VideoParameterSet value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pStdVPSRaw(s);
        return this;
    }

    @Unsafe public @Nullable StdVideoH265VideoParameterSet.Ptr pStdVPS(int assumedCount) {
        MemorySegment s = pStdVPSRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * StdVideoH265VideoParameterSet.BYTES);
        return new StdVideoH265VideoParameterSet.Ptr(s);
    }

    public @Nullable StdVideoH265VideoParameterSet pStdVPS() {
        MemorySegment s = pStdVPSRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new StdVideoH265VideoParameterSet(s);
    }

    public @Pointer(target=StdVideoH265VideoParameterSet.class) @NotNull MemorySegment pStdVPSRaw() {
        return segment.get(LAYOUT$pStdVPS, OFFSET$pStdVPS);
    }

    public void pStdVPSRaw(@Pointer(target=StdVideoH265VideoParameterSet.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pStdVPS, OFFSET$pStdVPS, value);
    }

    public VkVideoDecodeH265InlineSessionParametersInfoKHR pStdSPS(@Nullable IStdVideoH265SequenceParameterSet value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pStdSPSRaw(s);
        return this;
    }

    @Unsafe public @Nullable StdVideoH265SequenceParameterSet.Ptr pStdSPS(int assumedCount) {
        MemorySegment s = pStdSPSRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * StdVideoH265SequenceParameterSet.BYTES);
        return new StdVideoH265SequenceParameterSet.Ptr(s);
    }

    public @Nullable StdVideoH265SequenceParameterSet pStdSPS() {
        MemorySegment s = pStdSPSRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new StdVideoH265SequenceParameterSet(s);
    }

    public @Pointer(target=StdVideoH265SequenceParameterSet.class) @NotNull MemorySegment pStdSPSRaw() {
        return segment.get(LAYOUT$pStdSPS, OFFSET$pStdSPS);
    }

    public void pStdSPSRaw(@Pointer(target=StdVideoH265SequenceParameterSet.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pStdSPS, OFFSET$pStdSPS, value);
    }

    public VkVideoDecodeH265InlineSessionParametersInfoKHR pStdPPS(@Nullable IStdVideoH265PictureParameterSet value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pStdPPSRaw(s);
        return this;
    }

    @Unsafe public @Nullable StdVideoH265PictureParameterSet.Ptr pStdPPS(int assumedCount) {
        MemorySegment s = pStdPPSRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * StdVideoH265PictureParameterSet.BYTES);
        return new StdVideoH265PictureParameterSet.Ptr(s);
    }

    public @Nullable StdVideoH265PictureParameterSet pStdPPS() {
        MemorySegment s = pStdPPSRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new StdVideoH265PictureParameterSet(s);
    }

    public @Pointer(target=StdVideoH265PictureParameterSet.class) @NotNull MemorySegment pStdPPSRaw() {
        return segment.get(LAYOUT$pStdPPS, OFFSET$pStdPPS);
    }

    public void pStdPPSRaw(@Pointer(target=StdVideoH265PictureParameterSet.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pStdPPS, OFFSET$pStdPPS, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withTargetLayout(StdVideoH265VideoParameterSet.LAYOUT).withName("pStdVPS"),
        ValueLayout.ADDRESS.withTargetLayout(StdVideoH265SequenceParameterSet.LAYOUT).withName("pStdSPS"),
        ValueLayout.ADDRESS.withTargetLayout(StdVideoH265PictureParameterSet.LAYOUT).withName("pStdPPS")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$pStdVPS = PathElement.groupElement("pStdVPS");
    public static final PathElement PATH$pStdSPS = PathElement.groupElement("pStdSPS");
    public static final PathElement PATH$pStdPPS = PathElement.groupElement("pStdPPS");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$pStdVPS = (AddressLayout) LAYOUT.select(PATH$pStdVPS);
    public static final AddressLayout LAYOUT$pStdSPS = (AddressLayout) LAYOUT.select(PATH$pStdSPS);
    public static final AddressLayout LAYOUT$pStdPPS = (AddressLayout) LAYOUT.select(PATH$pStdPPS);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$pStdVPS = LAYOUT$pStdVPS.byteSize();
    public static final long SIZE$pStdSPS = LAYOUT$pStdSPS.byteSize();
    public static final long SIZE$pStdPPS = LAYOUT$pStdPPS.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$pStdVPS = LAYOUT.byteOffset(PATH$pStdVPS);
    public static final long OFFSET$pStdSPS = LAYOUT.byteOffset(PATH$pStdSPS);
    public static final long OFFSET$pStdPPS = LAYOUT.byteOffset(PATH$pStdPPS);
}
