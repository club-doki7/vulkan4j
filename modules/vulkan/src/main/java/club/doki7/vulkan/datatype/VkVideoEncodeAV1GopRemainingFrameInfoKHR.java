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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeAV1GopRemainingFrameInfoKHR.html"><code>VkVideoEncodeAV1GopRemainingFrameInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkVideoEncodeAV1GopRemainingFrameInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 useGopRemainingFrames; // @link substring="useGopRemainingFrames" target="#useGopRemainingFrames"
///     uint32_t gopRemainingIntra; // @link substring="gopRemainingIntra" target="#gopRemainingIntra"
///     uint32_t gopRemainingPredictive; // @link substring="gopRemainingPredictive" target="#gopRemainingPredictive"
///     uint32_t gopRemainingBipredictive; // @link substring="gopRemainingBipredictive" target="#gopRemainingBipredictive"
/// } VkVideoEncodeAV1GopRemainingFrameInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_VIDEO_ENCODE_AV1_GOP_REMAINING_FRAME_INFO_KHR`
///
/// The {@code allocate} ({@link VkVideoEncodeAV1GopRemainingFrameInfoKHR#allocate(Arena)}, {@link VkVideoEncodeAV1GopRemainingFrameInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkVideoEncodeAV1GopRemainingFrameInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeAV1GopRemainingFrameInfoKHR.html"><code>VkVideoEncodeAV1GopRemainingFrameInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkVideoEncodeAV1GopRemainingFrameInfoKHR(@NotNull MemorySegment segment) implements IVkVideoEncodeAV1GopRemainingFrameInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeAV1GopRemainingFrameInfoKHR.html"><code>VkVideoEncodeAV1GopRemainingFrameInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkVideoEncodeAV1GopRemainingFrameInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkVideoEncodeAV1GopRemainingFrameInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkVideoEncodeAV1GopRemainingFrameInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkVideoEncodeAV1GopRemainingFrameInfoKHR, Iterable<VkVideoEncodeAV1GopRemainingFrameInfoKHR> {
        public long size() {
            return segment.byteSize() / VkVideoEncodeAV1GopRemainingFrameInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkVideoEncodeAV1GopRemainingFrameInfoKHR at(long index) {
            return new VkVideoEncodeAV1GopRemainingFrameInfoKHR(segment.asSlice(index * VkVideoEncodeAV1GopRemainingFrameInfoKHR.BYTES, VkVideoEncodeAV1GopRemainingFrameInfoKHR.BYTES));
        }

        public VkVideoEncodeAV1GopRemainingFrameInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkVideoEncodeAV1GopRemainingFrameInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkVideoEncodeAV1GopRemainingFrameInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkVideoEncodeAV1GopRemainingFrameInfoKHR.BYTES, VkVideoEncodeAV1GopRemainingFrameInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkVideoEncodeAV1GopRemainingFrameInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkVideoEncodeAV1GopRemainingFrameInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkVideoEncodeAV1GopRemainingFrameInfoKHR.BYTES,
                (end - start) * VkVideoEncodeAV1GopRemainingFrameInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkVideoEncodeAV1GopRemainingFrameInfoKHR.BYTES));
        }

        public VkVideoEncodeAV1GopRemainingFrameInfoKHR[] toArray() {
            VkVideoEncodeAV1GopRemainingFrameInfoKHR[] ret = new VkVideoEncodeAV1GopRemainingFrameInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkVideoEncodeAV1GopRemainingFrameInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkVideoEncodeAV1GopRemainingFrameInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkVideoEncodeAV1GopRemainingFrameInfoKHR.BYTES;
            }

            @Override
            public VkVideoEncodeAV1GopRemainingFrameInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkVideoEncodeAV1GopRemainingFrameInfoKHR ret = new VkVideoEncodeAV1GopRemainingFrameInfoKHR(segment.asSlice(0, VkVideoEncodeAV1GopRemainingFrameInfoKHR.BYTES));
                segment = segment.asSlice(VkVideoEncodeAV1GopRemainingFrameInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkVideoEncodeAV1GopRemainingFrameInfoKHR allocate(Arena arena) {
        VkVideoEncodeAV1GopRemainingFrameInfoKHR ret = new VkVideoEncodeAV1GopRemainingFrameInfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.VIDEO_ENCODE_AV1_GOP_REMAINING_FRAME_INFO_KHR);
        return ret;
    }

    public static VkVideoEncodeAV1GopRemainingFrameInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkVideoEncodeAV1GopRemainingFrameInfoKHR.Ptr ret = new VkVideoEncodeAV1GopRemainingFrameInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.VIDEO_ENCODE_AV1_GOP_REMAINING_FRAME_INFO_KHR);
        }
        return ret;
    }

    public static VkVideoEncodeAV1GopRemainingFrameInfoKHR clone(Arena arena, VkVideoEncodeAV1GopRemainingFrameInfoKHR src) {
        VkVideoEncodeAV1GopRemainingFrameInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.VIDEO_ENCODE_AV1_GOP_REMAINING_FRAME_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkVideoEncodeAV1GopRemainingFrameInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkVideoEncodeAV1GopRemainingFrameInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkVideoEncodeAV1GopRemainingFrameInfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int useGopRemainingFrames() {
        return segment.get(LAYOUT$useGopRemainingFrames, OFFSET$useGopRemainingFrames);
    }

    public VkVideoEncodeAV1GopRemainingFrameInfoKHR useGopRemainingFrames(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$useGopRemainingFrames, OFFSET$useGopRemainingFrames, value);
        return this;
    }

    public @Unsigned int gopRemainingIntra() {
        return segment.get(LAYOUT$gopRemainingIntra, OFFSET$gopRemainingIntra);
    }

    public VkVideoEncodeAV1GopRemainingFrameInfoKHR gopRemainingIntra(@Unsigned int value) {
        segment.set(LAYOUT$gopRemainingIntra, OFFSET$gopRemainingIntra, value);
        return this;
    }

    public @Unsigned int gopRemainingPredictive() {
        return segment.get(LAYOUT$gopRemainingPredictive, OFFSET$gopRemainingPredictive);
    }

    public VkVideoEncodeAV1GopRemainingFrameInfoKHR gopRemainingPredictive(@Unsigned int value) {
        segment.set(LAYOUT$gopRemainingPredictive, OFFSET$gopRemainingPredictive, value);
        return this;
    }

    public @Unsigned int gopRemainingBipredictive() {
        return segment.get(LAYOUT$gopRemainingBipredictive, OFFSET$gopRemainingBipredictive);
    }

    public VkVideoEncodeAV1GopRemainingFrameInfoKHR gopRemainingBipredictive(@Unsigned int value) {
        segment.set(LAYOUT$gopRemainingBipredictive, OFFSET$gopRemainingBipredictive, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("useGopRemainingFrames"),
        ValueLayout.JAVA_INT.withName("gopRemainingIntra"),
        ValueLayout.JAVA_INT.withName("gopRemainingPredictive"),
        ValueLayout.JAVA_INT.withName("gopRemainingBipredictive")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$useGopRemainingFrames = PathElement.groupElement("useGopRemainingFrames");
    public static final PathElement PATH$gopRemainingIntra = PathElement.groupElement("gopRemainingIntra");
    public static final PathElement PATH$gopRemainingPredictive = PathElement.groupElement("gopRemainingPredictive");
    public static final PathElement PATH$gopRemainingBipredictive = PathElement.groupElement("gopRemainingBipredictive");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$useGopRemainingFrames = (OfInt) LAYOUT.select(PATH$useGopRemainingFrames);
    public static final OfInt LAYOUT$gopRemainingIntra = (OfInt) LAYOUT.select(PATH$gopRemainingIntra);
    public static final OfInt LAYOUT$gopRemainingPredictive = (OfInt) LAYOUT.select(PATH$gopRemainingPredictive);
    public static final OfInt LAYOUT$gopRemainingBipredictive = (OfInt) LAYOUT.select(PATH$gopRemainingBipredictive);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$useGopRemainingFrames = LAYOUT$useGopRemainingFrames.byteSize();
    public static final long SIZE$gopRemainingIntra = LAYOUT$gopRemainingIntra.byteSize();
    public static final long SIZE$gopRemainingPredictive = LAYOUT$gopRemainingPredictive.byteSize();
    public static final long SIZE$gopRemainingBipredictive = LAYOUT$gopRemainingBipredictive.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$useGopRemainingFrames = LAYOUT.byteOffset(PATH$useGopRemainingFrames);
    public static final long OFFSET$gopRemainingIntra = LAYOUT.byteOffset(PATH$gopRemainingIntra);
    public static final long OFFSET$gopRemainingPredictive = LAYOUT.byteOffset(PATH$gopRemainingPredictive);
    public static final long OFFSET$gopRemainingBipredictive = LAYOUT.byteOffset(PATH$gopRemainingBipredictive);
}
