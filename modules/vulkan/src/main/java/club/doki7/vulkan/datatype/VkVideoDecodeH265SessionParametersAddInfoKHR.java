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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoDecodeH265SessionParametersAddInfoKHR.html"><code>VkVideoDecodeH265SessionParametersAddInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkVideoDecodeH265SessionParametersAddInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t stdVPSCount; // optional // @link substring="stdVPSCount" target="#stdVPSCount"
///     StdVideoH265VideoParameterSet const* pStdVPSs; // optional // @link substring="StdVideoH265VideoParameterSet" target="StdVideoH265VideoParameterSet" @link substring="pStdVPSs" target="#pStdVPSs"
///     uint32_t stdSPSCount; // optional // @link substring="stdSPSCount" target="#stdSPSCount"
///     StdVideoH265SequenceParameterSet const* pStdSPSs; // optional // @link substring="StdVideoH265SequenceParameterSet" target="StdVideoH265SequenceParameterSet" @link substring="pStdSPSs" target="#pStdSPSs"
///     uint32_t stdPPSCount; // optional // @link substring="stdPPSCount" target="#stdPPSCount"
///     StdVideoH265PictureParameterSet const* pStdPPSs; // optional // @link substring="StdVideoH265PictureParameterSet" target="StdVideoH265PictureParameterSet" @link substring="pStdPPSs" target="#pStdPPSs"
/// } VkVideoDecodeH265SessionParametersAddInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_VIDEO_DECODE_H265_SESSION_PARAMETERS_ADD_INFO_KHR`
///
/// The {@code allocate} ({@link VkVideoDecodeH265SessionParametersAddInfoKHR#allocate(Arena)}, {@link VkVideoDecodeH265SessionParametersAddInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkVideoDecodeH265SessionParametersAddInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoDecodeH265SessionParametersAddInfoKHR.html"><code>VkVideoDecodeH265SessionParametersAddInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkVideoDecodeH265SessionParametersAddInfoKHR(@NotNull MemorySegment segment) implements IVkVideoDecodeH265SessionParametersAddInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoDecodeH265SessionParametersAddInfoKHR.html"><code>VkVideoDecodeH265SessionParametersAddInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkVideoDecodeH265SessionParametersAddInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkVideoDecodeH265SessionParametersAddInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkVideoDecodeH265SessionParametersAddInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkVideoDecodeH265SessionParametersAddInfoKHR, Iterable<VkVideoDecodeH265SessionParametersAddInfoKHR> {
        public long size() {
            return segment.byteSize() / VkVideoDecodeH265SessionParametersAddInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkVideoDecodeH265SessionParametersAddInfoKHR at(long index) {
            return new VkVideoDecodeH265SessionParametersAddInfoKHR(segment.asSlice(index * VkVideoDecodeH265SessionParametersAddInfoKHR.BYTES, VkVideoDecodeH265SessionParametersAddInfoKHR.BYTES));
        }

        public VkVideoDecodeH265SessionParametersAddInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkVideoDecodeH265SessionParametersAddInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkVideoDecodeH265SessionParametersAddInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkVideoDecodeH265SessionParametersAddInfoKHR.BYTES, VkVideoDecodeH265SessionParametersAddInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkVideoDecodeH265SessionParametersAddInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkVideoDecodeH265SessionParametersAddInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkVideoDecodeH265SessionParametersAddInfoKHR.BYTES,
                (end - start) * VkVideoDecodeH265SessionParametersAddInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkVideoDecodeH265SessionParametersAddInfoKHR.BYTES));
        }

        public VkVideoDecodeH265SessionParametersAddInfoKHR[] toArray() {
            VkVideoDecodeH265SessionParametersAddInfoKHR[] ret = new VkVideoDecodeH265SessionParametersAddInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkVideoDecodeH265SessionParametersAddInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkVideoDecodeH265SessionParametersAddInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkVideoDecodeH265SessionParametersAddInfoKHR.BYTES;
            }

            @Override
            public VkVideoDecodeH265SessionParametersAddInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkVideoDecodeH265SessionParametersAddInfoKHR ret = new VkVideoDecodeH265SessionParametersAddInfoKHR(segment.asSlice(0, VkVideoDecodeH265SessionParametersAddInfoKHR.BYTES));
                segment = segment.asSlice(VkVideoDecodeH265SessionParametersAddInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkVideoDecodeH265SessionParametersAddInfoKHR allocate(Arena arena) {
        VkVideoDecodeH265SessionParametersAddInfoKHR ret = new VkVideoDecodeH265SessionParametersAddInfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.VIDEO_DECODE_H265_SESSION_PARAMETERS_ADD_INFO_KHR);
        return ret;
    }

    public static VkVideoDecodeH265SessionParametersAddInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkVideoDecodeH265SessionParametersAddInfoKHR.Ptr ret = new VkVideoDecodeH265SessionParametersAddInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.VIDEO_DECODE_H265_SESSION_PARAMETERS_ADD_INFO_KHR);
        }
        return ret;
    }

    public static VkVideoDecodeH265SessionParametersAddInfoKHR clone(Arena arena, VkVideoDecodeH265SessionParametersAddInfoKHR src) {
        VkVideoDecodeH265SessionParametersAddInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.VIDEO_DECODE_H265_SESSION_PARAMETERS_ADD_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkVideoDecodeH265SessionParametersAddInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkVideoDecodeH265SessionParametersAddInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkVideoDecodeH265SessionParametersAddInfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int stdVPSCount() {
        return segment.get(LAYOUT$stdVPSCount, OFFSET$stdVPSCount);
    }

    public VkVideoDecodeH265SessionParametersAddInfoKHR stdVPSCount(@Unsigned int value) {
        segment.set(LAYOUT$stdVPSCount, OFFSET$stdVPSCount, value);
        return this;
    }

    public VkVideoDecodeH265SessionParametersAddInfoKHR pStdVPSs(@Nullable IStdVideoH265VideoParameterSet value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pStdVPSsRaw(s);
        return this;
    }

    @Unsafe public @Nullable StdVideoH265VideoParameterSet.Ptr pStdVPSs(int assumedCount) {
        MemorySegment s = pStdVPSsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * StdVideoH265VideoParameterSet.BYTES);
        return new StdVideoH265VideoParameterSet.Ptr(s);
    }

    public @Nullable StdVideoH265VideoParameterSet pStdVPSs() {
        MemorySegment s = pStdVPSsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new StdVideoH265VideoParameterSet(s);
    }

    public @Pointer(target=StdVideoH265VideoParameterSet.class) @NotNull MemorySegment pStdVPSsRaw() {
        return segment.get(LAYOUT$pStdVPSs, OFFSET$pStdVPSs);
    }

    public void pStdVPSsRaw(@Pointer(target=StdVideoH265VideoParameterSet.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pStdVPSs, OFFSET$pStdVPSs, value);
    }

    public @Unsigned int stdSPSCount() {
        return segment.get(LAYOUT$stdSPSCount, OFFSET$stdSPSCount);
    }

    public VkVideoDecodeH265SessionParametersAddInfoKHR stdSPSCount(@Unsigned int value) {
        segment.set(LAYOUT$stdSPSCount, OFFSET$stdSPSCount, value);
        return this;
    }

    public VkVideoDecodeH265SessionParametersAddInfoKHR pStdSPSs(@Nullable IStdVideoH265SequenceParameterSet value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pStdSPSsRaw(s);
        return this;
    }

    @Unsafe public @Nullable StdVideoH265SequenceParameterSet.Ptr pStdSPSs(int assumedCount) {
        MemorySegment s = pStdSPSsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * StdVideoH265SequenceParameterSet.BYTES);
        return new StdVideoH265SequenceParameterSet.Ptr(s);
    }

    public @Nullable StdVideoH265SequenceParameterSet pStdSPSs() {
        MemorySegment s = pStdSPSsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new StdVideoH265SequenceParameterSet(s);
    }

    public @Pointer(target=StdVideoH265SequenceParameterSet.class) @NotNull MemorySegment pStdSPSsRaw() {
        return segment.get(LAYOUT$pStdSPSs, OFFSET$pStdSPSs);
    }

    public void pStdSPSsRaw(@Pointer(target=StdVideoH265SequenceParameterSet.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pStdSPSs, OFFSET$pStdSPSs, value);
    }

    public @Unsigned int stdPPSCount() {
        return segment.get(LAYOUT$stdPPSCount, OFFSET$stdPPSCount);
    }

    public VkVideoDecodeH265SessionParametersAddInfoKHR stdPPSCount(@Unsigned int value) {
        segment.set(LAYOUT$stdPPSCount, OFFSET$stdPPSCount, value);
        return this;
    }

    public VkVideoDecodeH265SessionParametersAddInfoKHR pStdPPSs(@Nullable IStdVideoH265PictureParameterSet value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pStdPPSsRaw(s);
        return this;
    }

    @Unsafe public @Nullable StdVideoH265PictureParameterSet.Ptr pStdPPSs(int assumedCount) {
        MemorySegment s = pStdPPSsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * StdVideoH265PictureParameterSet.BYTES);
        return new StdVideoH265PictureParameterSet.Ptr(s);
    }

    public @Nullable StdVideoH265PictureParameterSet pStdPPSs() {
        MemorySegment s = pStdPPSsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new StdVideoH265PictureParameterSet(s);
    }

    public @Pointer(target=StdVideoH265PictureParameterSet.class) @NotNull MemorySegment pStdPPSsRaw() {
        return segment.get(LAYOUT$pStdPPSs, OFFSET$pStdPPSs);
    }

    public void pStdPPSsRaw(@Pointer(target=StdVideoH265PictureParameterSet.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pStdPPSs, OFFSET$pStdPPSs, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("stdVPSCount"),
        ValueLayout.ADDRESS.withTargetLayout(StdVideoH265VideoParameterSet.LAYOUT).withName("pStdVPSs"),
        ValueLayout.JAVA_INT.withName("stdSPSCount"),
        ValueLayout.ADDRESS.withTargetLayout(StdVideoH265SequenceParameterSet.LAYOUT).withName("pStdSPSs"),
        ValueLayout.JAVA_INT.withName("stdPPSCount"),
        ValueLayout.ADDRESS.withTargetLayout(StdVideoH265PictureParameterSet.LAYOUT).withName("pStdPPSs")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$stdVPSCount = PathElement.groupElement("stdVPSCount");
    public static final PathElement PATH$pStdVPSs = PathElement.groupElement("pStdVPSs");
    public static final PathElement PATH$stdSPSCount = PathElement.groupElement("stdSPSCount");
    public static final PathElement PATH$pStdSPSs = PathElement.groupElement("pStdSPSs");
    public static final PathElement PATH$stdPPSCount = PathElement.groupElement("stdPPSCount");
    public static final PathElement PATH$pStdPPSs = PathElement.groupElement("pStdPPSs");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$stdVPSCount = (OfInt) LAYOUT.select(PATH$stdVPSCount);
    public static final AddressLayout LAYOUT$pStdVPSs = (AddressLayout) LAYOUT.select(PATH$pStdVPSs);
    public static final OfInt LAYOUT$stdSPSCount = (OfInt) LAYOUT.select(PATH$stdSPSCount);
    public static final AddressLayout LAYOUT$pStdSPSs = (AddressLayout) LAYOUT.select(PATH$pStdSPSs);
    public static final OfInt LAYOUT$stdPPSCount = (OfInt) LAYOUT.select(PATH$stdPPSCount);
    public static final AddressLayout LAYOUT$pStdPPSs = (AddressLayout) LAYOUT.select(PATH$pStdPPSs);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$stdVPSCount = LAYOUT$stdVPSCount.byteSize();
    public static final long SIZE$pStdVPSs = LAYOUT$pStdVPSs.byteSize();
    public static final long SIZE$stdSPSCount = LAYOUT$stdSPSCount.byteSize();
    public static final long SIZE$pStdSPSs = LAYOUT$pStdSPSs.byteSize();
    public static final long SIZE$stdPPSCount = LAYOUT$stdPPSCount.byteSize();
    public static final long SIZE$pStdPPSs = LAYOUT$pStdPPSs.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$stdVPSCount = LAYOUT.byteOffset(PATH$stdVPSCount);
    public static final long OFFSET$pStdVPSs = LAYOUT.byteOffset(PATH$pStdVPSs);
    public static final long OFFSET$stdSPSCount = LAYOUT.byteOffset(PATH$stdSPSCount);
    public static final long OFFSET$pStdSPSs = LAYOUT.byteOffset(PATH$pStdSPSs);
    public static final long OFFSET$stdPPSCount = LAYOUT.byteOffset(PATH$stdPPSCount);
    public static final long OFFSET$pStdPPSs = LAYOUT.byteOffset(PATH$pStdPPSs);
}
