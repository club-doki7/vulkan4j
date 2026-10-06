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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoDecodeH264ProfileInfoKHR.html"><code>VkVideoDecodeH264ProfileInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkVideoDecodeH264ProfileInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     StdVideoH264ProfileIdc stdProfileIdc; // @link substring="StdVideoH264ProfileIdc" target="StdVideoH264ProfileIdc" @link substring="stdProfileIdc" target="#stdProfileIdc"
///     VkVideoDecodeH264PictureLayoutFlagsKHR pictureLayout; // optional // @link substring="VkVideoDecodeH264PictureLayoutFlagsKHR" target="VkVideoDecodeH264PictureLayoutFlagsKHR" @link substring="pictureLayout" target="#pictureLayout"
/// } VkVideoDecodeH264ProfileInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_VIDEO_DECODE_H264_PROFILE_INFO_KHR`
///
/// The {@code allocate} ({@link VkVideoDecodeH264ProfileInfoKHR#allocate(Arena)}, {@link VkVideoDecodeH264ProfileInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkVideoDecodeH264ProfileInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoDecodeH264ProfileInfoKHR.html"><code>VkVideoDecodeH264ProfileInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkVideoDecodeH264ProfileInfoKHR(@NotNull MemorySegment segment) implements IVkVideoDecodeH264ProfileInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoDecodeH264ProfileInfoKHR.html"><code>VkVideoDecodeH264ProfileInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkVideoDecodeH264ProfileInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkVideoDecodeH264ProfileInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkVideoDecodeH264ProfileInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkVideoDecodeH264ProfileInfoKHR, Iterable<VkVideoDecodeH264ProfileInfoKHR> {
        public long size() {
            return segment.byteSize() / VkVideoDecodeH264ProfileInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkVideoDecodeH264ProfileInfoKHR at(long index) {
            return new VkVideoDecodeH264ProfileInfoKHR(segment.asSlice(index * VkVideoDecodeH264ProfileInfoKHR.BYTES, VkVideoDecodeH264ProfileInfoKHR.BYTES));
        }

        public VkVideoDecodeH264ProfileInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkVideoDecodeH264ProfileInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkVideoDecodeH264ProfileInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkVideoDecodeH264ProfileInfoKHR.BYTES, VkVideoDecodeH264ProfileInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkVideoDecodeH264ProfileInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkVideoDecodeH264ProfileInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkVideoDecodeH264ProfileInfoKHR.BYTES,
                (end - start) * VkVideoDecodeH264ProfileInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkVideoDecodeH264ProfileInfoKHR.BYTES));
        }

        public VkVideoDecodeH264ProfileInfoKHR[] toArray() {
            VkVideoDecodeH264ProfileInfoKHR[] ret = new VkVideoDecodeH264ProfileInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkVideoDecodeH264ProfileInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkVideoDecodeH264ProfileInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkVideoDecodeH264ProfileInfoKHR.BYTES;
            }

            @Override
            public VkVideoDecodeH264ProfileInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkVideoDecodeH264ProfileInfoKHR ret = new VkVideoDecodeH264ProfileInfoKHR(segment.asSlice(0, VkVideoDecodeH264ProfileInfoKHR.BYTES));
                segment = segment.asSlice(VkVideoDecodeH264ProfileInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkVideoDecodeH264ProfileInfoKHR allocate(Arena arena) {
        VkVideoDecodeH264ProfileInfoKHR ret = new VkVideoDecodeH264ProfileInfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.VIDEO_DECODE_H264_PROFILE_INFO_KHR);
        return ret;
    }

    public static VkVideoDecodeH264ProfileInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkVideoDecodeH264ProfileInfoKHR.Ptr ret = new VkVideoDecodeH264ProfileInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.VIDEO_DECODE_H264_PROFILE_INFO_KHR);
        }
        return ret;
    }

    public static VkVideoDecodeH264ProfileInfoKHR clone(Arena arena, VkVideoDecodeH264ProfileInfoKHR src) {
        VkVideoDecodeH264ProfileInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.VIDEO_DECODE_H264_PROFILE_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkVideoDecodeH264ProfileInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkVideoDecodeH264ProfileInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkVideoDecodeH264ProfileInfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @EnumType(StdVideoH264ProfileIdc.class) int stdProfileIdc() {
        return segment.get(LAYOUT$stdProfileIdc, OFFSET$stdProfileIdc);
    }

    public VkVideoDecodeH264ProfileInfoKHR stdProfileIdc(@EnumType(StdVideoH264ProfileIdc.class) int value) {
        segment.set(LAYOUT$stdProfileIdc, OFFSET$stdProfileIdc, value);
        return this;
    }

    public @Bitmask(VkVideoDecodeH264PictureLayoutFlagsKHR.class) int pictureLayout() {
        return segment.get(LAYOUT$pictureLayout, OFFSET$pictureLayout);
    }

    public VkVideoDecodeH264ProfileInfoKHR pictureLayout(@Bitmask(VkVideoDecodeH264PictureLayoutFlagsKHR.class) int value) {
        segment.set(LAYOUT$pictureLayout, OFFSET$pictureLayout, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("stdProfileIdc"),
        ValueLayout.JAVA_INT.withName("pictureLayout")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$stdProfileIdc = PathElement.groupElement("stdProfileIdc");
    public static final PathElement PATH$pictureLayout = PathElement.groupElement("pictureLayout");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$stdProfileIdc = (OfInt) LAYOUT.select(PATH$stdProfileIdc);
    public static final OfInt LAYOUT$pictureLayout = (OfInt) LAYOUT.select(PATH$pictureLayout);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$stdProfileIdc = LAYOUT$stdProfileIdc.byteSize();
    public static final long SIZE$pictureLayout = LAYOUT$pictureLayout.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$stdProfileIdc = LAYOUT.byteOffset(PATH$stdProfileIdc);
    public static final long OFFSET$pictureLayout = LAYOUT.byteOffset(PATH$pictureLayout);
}
