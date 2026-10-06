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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoProfileInfoKHR.html"><code>VkVideoProfileInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkVideoProfileInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkVideoCodecOperationFlagsKHR videoCodecOperation; // @link substring="VkVideoCodecOperationFlagsKHR" target="VkVideoCodecOperationFlagsKHR" @link substring="videoCodecOperation" target="#videoCodecOperation"
///     VkVideoChromaSubsamplingFlagsKHR chromaSubsampling; // @link substring="VkVideoChromaSubsamplingFlagsKHR" target="VkVideoChromaSubsamplingFlagsKHR" @link substring="chromaSubsampling" target="#chromaSubsampling"
///     VkVideoComponentBitDepthFlagsKHR lumaBitDepth; // @link substring="VkVideoComponentBitDepthFlagsKHR" target="VkVideoComponentBitDepthFlagsKHR" @link substring="lumaBitDepth" target="#lumaBitDepth"
///     VkVideoComponentBitDepthFlagsKHR chromaBitDepth; // optional // @link substring="VkVideoComponentBitDepthFlagsKHR" target="VkVideoComponentBitDepthFlagsKHR" @link substring="chromaBitDepth" target="#chromaBitDepth"
/// } VkVideoProfileInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_VIDEO_PROFILE_INFO_KHR`
///
/// The {@code allocate} ({@link VkVideoProfileInfoKHR#allocate(Arena)}, {@link VkVideoProfileInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkVideoProfileInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoProfileInfoKHR.html"><code>VkVideoProfileInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkVideoProfileInfoKHR(@NotNull MemorySegment segment) implements IVkVideoProfileInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoProfileInfoKHR.html"><code>VkVideoProfileInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkVideoProfileInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkVideoProfileInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkVideoProfileInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkVideoProfileInfoKHR, Iterable<VkVideoProfileInfoKHR> {
        public long size() {
            return segment.byteSize() / VkVideoProfileInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkVideoProfileInfoKHR at(long index) {
            return new VkVideoProfileInfoKHR(segment.asSlice(index * VkVideoProfileInfoKHR.BYTES, VkVideoProfileInfoKHR.BYTES));
        }

        public VkVideoProfileInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkVideoProfileInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkVideoProfileInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkVideoProfileInfoKHR.BYTES, VkVideoProfileInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkVideoProfileInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkVideoProfileInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkVideoProfileInfoKHR.BYTES,
                (end - start) * VkVideoProfileInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkVideoProfileInfoKHR.BYTES));
        }

        public VkVideoProfileInfoKHR[] toArray() {
            VkVideoProfileInfoKHR[] ret = new VkVideoProfileInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkVideoProfileInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkVideoProfileInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkVideoProfileInfoKHR.BYTES;
            }

            @Override
            public VkVideoProfileInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkVideoProfileInfoKHR ret = new VkVideoProfileInfoKHR(segment.asSlice(0, VkVideoProfileInfoKHR.BYTES));
                segment = segment.asSlice(VkVideoProfileInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkVideoProfileInfoKHR allocate(Arena arena) {
        VkVideoProfileInfoKHR ret = new VkVideoProfileInfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.VIDEO_PROFILE_INFO_KHR);
        return ret;
    }

    public static VkVideoProfileInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkVideoProfileInfoKHR.Ptr ret = new VkVideoProfileInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.VIDEO_PROFILE_INFO_KHR);
        }
        return ret;
    }

    public static VkVideoProfileInfoKHR clone(Arena arena, VkVideoProfileInfoKHR src) {
        VkVideoProfileInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.VIDEO_PROFILE_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkVideoProfileInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkVideoProfileInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkVideoProfileInfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkVideoCodecOperationFlagsKHR.class) int videoCodecOperation() {
        return segment.get(LAYOUT$videoCodecOperation, OFFSET$videoCodecOperation);
    }

    public VkVideoProfileInfoKHR videoCodecOperation(@Bitmask(VkVideoCodecOperationFlagsKHR.class) int value) {
        segment.set(LAYOUT$videoCodecOperation, OFFSET$videoCodecOperation, value);
        return this;
    }

    public @Bitmask(VkVideoChromaSubsamplingFlagsKHR.class) int chromaSubsampling() {
        return segment.get(LAYOUT$chromaSubsampling, OFFSET$chromaSubsampling);
    }

    public VkVideoProfileInfoKHR chromaSubsampling(@Bitmask(VkVideoChromaSubsamplingFlagsKHR.class) int value) {
        segment.set(LAYOUT$chromaSubsampling, OFFSET$chromaSubsampling, value);
        return this;
    }

    public @Bitmask(VkVideoComponentBitDepthFlagsKHR.class) int lumaBitDepth() {
        return segment.get(LAYOUT$lumaBitDepth, OFFSET$lumaBitDepth);
    }

    public VkVideoProfileInfoKHR lumaBitDepth(@Bitmask(VkVideoComponentBitDepthFlagsKHR.class) int value) {
        segment.set(LAYOUT$lumaBitDepth, OFFSET$lumaBitDepth, value);
        return this;
    }

    public @Bitmask(VkVideoComponentBitDepthFlagsKHR.class) int chromaBitDepth() {
        return segment.get(LAYOUT$chromaBitDepth, OFFSET$chromaBitDepth);
    }

    public VkVideoProfileInfoKHR chromaBitDepth(@Bitmask(VkVideoComponentBitDepthFlagsKHR.class) int value) {
        segment.set(LAYOUT$chromaBitDepth, OFFSET$chromaBitDepth, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("videoCodecOperation"),
        ValueLayout.JAVA_INT.withName("chromaSubsampling"),
        ValueLayout.JAVA_INT.withName("lumaBitDepth"),
        ValueLayout.JAVA_INT.withName("chromaBitDepth")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$videoCodecOperation = PathElement.groupElement("videoCodecOperation");
    public static final PathElement PATH$chromaSubsampling = PathElement.groupElement("chromaSubsampling");
    public static final PathElement PATH$lumaBitDepth = PathElement.groupElement("lumaBitDepth");
    public static final PathElement PATH$chromaBitDepth = PathElement.groupElement("chromaBitDepth");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$videoCodecOperation = (OfInt) LAYOUT.select(PATH$videoCodecOperation);
    public static final OfInt LAYOUT$chromaSubsampling = (OfInt) LAYOUT.select(PATH$chromaSubsampling);
    public static final OfInt LAYOUT$lumaBitDepth = (OfInt) LAYOUT.select(PATH$lumaBitDepth);
    public static final OfInt LAYOUT$chromaBitDepth = (OfInt) LAYOUT.select(PATH$chromaBitDepth);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$videoCodecOperation = LAYOUT$videoCodecOperation.byteSize();
    public static final long SIZE$chromaSubsampling = LAYOUT$chromaSubsampling.byteSize();
    public static final long SIZE$lumaBitDepth = LAYOUT$lumaBitDepth.byteSize();
    public static final long SIZE$chromaBitDepth = LAYOUT$chromaBitDepth.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$videoCodecOperation = LAYOUT.byteOffset(PATH$videoCodecOperation);
    public static final long OFFSET$chromaSubsampling = LAYOUT.byteOffset(PATH$chromaSubsampling);
    public static final long OFFSET$lumaBitDepth = LAYOUT.byteOffset(PATH$lumaBitDepth);
    public static final long OFFSET$chromaBitDepth = LAYOUT.byteOffset(PATH$chromaBitDepth);
}
