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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoDecodeAV1InlineSessionParametersInfoKHR.html"><code>VkVideoDecodeAV1InlineSessionParametersInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkVideoDecodeAV1InlineSessionParametersInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     StdVideoAV1SequenceHeader const* pStdSequenceHeader; // optional // @link substring="StdVideoAV1SequenceHeader" target="StdVideoAV1SequenceHeader" @link substring="pStdSequenceHeader" target="#pStdSequenceHeader"
/// } VkVideoDecodeAV1InlineSessionParametersInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_VIDEO_DECODE_AV1_INLINE_SESSION_PARAMETERS_INFO_KHR`
///
/// The {@code allocate} ({@link VkVideoDecodeAV1InlineSessionParametersInfoKHR#allocate(Arena)}, {@link VkVideoDecodeAV1InlineSessionParametersInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkVideoDecodeAV1InlineSessionParametersInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoDecodeAV1InlineSessionParametersInfoKHR.html"><code>VkVideoDecodeAV1InlineSessionParametersInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkVideoDecodeAV1InlineSessionParametersInfoKHR(@NotNull MemorySegment segment) implements IVkVideoDecodeAV1InlineSessionParametersInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoDecodeAV1InlineSessionParametersInfoKHR.html"><code>VkVideoDecodeAV1InlineSessionParametersInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkVideoDecodeAV1InlineSessionParametersInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkVideoDecodeAV1InlineSessionParametersInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkVideoDecodeAV1InlineSessionParametersInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkVideoDecodeAV1InlineSessionParametersInfoKHR, Iterable<VkVideoDecodeAV1InlineSessionParametersInfoKHR> {
        public long size() {
            return segment.byteSize() / VkVideoDecodeAV1InlineSessionParametersInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkVideoDecodeAV1InlineSessionParametersInfoKHR at(long index) {
            return new VkVideoDecodeAV1InlineSessionParametersInfoKHR(segment.asSlice(index * VkVideoDecodeAV1InlineSessionParametersInfoKHR.BYTES, VkVideoDecodeAV1InlineSessionParametersInfoKHR.BYTES));
        }

        public VkVideoDecodeAV1InlineSessionParametersInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkVideoDecodeAV1InlineSessionParametersInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkVideoDecodeAV1InlineSessionParametersInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkVideoDecodeAV1InlineSessionParametersInfoKHR.BYTES, VkVideoDecodeAV1InlineSessionParametersInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkVideoDecodeAV1InlineSessionParametersInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkVideoDecodeAV1InlineSessionParametersInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkVideoDecodeAV1InlineSessionParametersInfoKHR.BYTES,
                (end - start) * VkVideoDecodeAV1InlineSessionParametersInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkVideoDecodeAV1InlineSessionParametersInfoKHR.BYTES));
        }

        public VkVideoDecodeAV1InlineSessionParametersInfoKHR[] toArray() {
            VkVideoDecodeAV1InlineSessionParametersInfoKHR[] ret = new VkVideoDecodeAV1InlineSessionParametersInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkVideoDecodeAV1InlineSessionParametersInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkVideoDecodeAV1InlineSessionParametersInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkVideoDecodeAV1InlineSessionParametersInfoKHR.BYTES;
            }

            @Override
            public VkVideoDecodeAV1InlineSessionParametersInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkVideoDecodeAV1InlineSessionParametersInfoKHR ret = new VkVideoDecodeAV1InlineSessionParametersInfoKHR(segment.asSlice(0, VkVideoDecodeAV1InlineSessionParametersInfoKHR.BYTES));
                segment = segment.asSlice(VkVideoDecodeAV1InlineSessionParametersInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkVideoDecodeAV1InlineSessionParametersInfoKHR allocate(Arena arena) {
        VkVideoDecodeAV1InlineSessionParametersInfoKHR ret = new VkVideoDecodeAV1InlineSessionParametersInfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.VIDEO_DECODE_AV1_INLINE_SESSION_PARAMETERS_INFO_KHR);
        return ret;
    }

    public static VkVideoDecodeAV1InlineSessionParametersInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkVideoDecodeAV1InlineSessionParametersInfoKHR.Ptr ret = new VkVideoDecodeAV1InlineSessionParametersInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.VIDEO_DECODE_AV1_INLINE_SESSION_PARAMETERS_INFO_KHR);
        }
        return ret;
    }

    public static VkVideoDecodeAV1InlineSessionParametersInfoKHR clone(Arena arena, VkVideoDecodeAV1InlineSessionParametersInfoKHR src) {
        VkVideoDecodeAV1InlineSessionParametersInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.VIDEO_DECODE_AV1_INLINE_SESSION_PARAMETERS_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkVideoDecodeAV1InlineSessionParametersInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkVideoDecodeAV1InlineSessionParametersInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkVideoDecodeAV1InlineSessionParametersInfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public VkVideoDecodeAV1InlineSessionParametersInfoKHR pStdSequenceHeader(@Nullable IStdVideoAV1SequenceHeader value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pStdSequenceHeaderRaw(s);
        return this;
    }

    @Unsafe public @Nullable StdVideoAV1SequenceHeader.Ptr pStdSequenceHeader(int assumedCount) {
        MemorySegment s = pStdSequenceHeaderRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * StdVideoAV1SequenceHeader.BYTES);
        return new StdVideoAV1SequenceHeader.Ptr(s);
    }

    public @Nullable StdVideoAV1SequenceHeader pStdSequenceHeader() {
        MemorySegment s = pStdSequenceHeaderRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new StdVideoAV1SequenceHeader(s);
    }

    public @Pointer(target=StdVideoAV1SequenceHeader.class) @NotNull MemorySegment pStdSequenceHeaderRaw() {
        return segment.get(LAYOUT$pStdSequenceHeader, OFFSET$pStdSequenceHeader);
    }

    public void pStdSequenceHeaderRaw(@Pointer(target=StdVideoAV1SequenceHeader.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pStdSequenceHeader, OFFSET$pStdSequenceHeader, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withTargetLayout(StdVideoAV1SequenceHeader.LAYOUT).withName("pStdSequenceHeader")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$pStdSequenceHeader = PathElement.groupElement("pStdSequenceHeader");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$pStdSequenceHeader = (AddressLayout) LAYOUT.select(PATH$pStdSequenceHeader);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$pStdSequenceHeader = LAYOUT$pStdSequenceHeader.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$pStdSequenceHeader = LAYOUT.byteOffset(PATH$pStdSequenceHeader);
}
