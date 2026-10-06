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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoPictureResourceInfoKHR.html"><code>VkVideoPictureResourceInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkVideoPictureResourceInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkOffset2D codedOffset; // @link substring="VkOffset2D" target="VkOffset2D" @link substring="codedOffset" target="#codedOffset"
///     VkExtent2D codedExtent; // @link substring="VkExtent2D" target="VkExtent2D" @link substring="codedExtent" target="#codedExtent"
///     uint32_t baseArrayLayer; // @link substring="baseArrayLayer" target="#baseArrayLayer"
///     VkImageView imageViewBinding; // @link substring="VkImageView" target="VkImageView" @link substring="imageViewBinding" target="#imageViewBinding"
/// } VkVideoPictureResourceInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_VIDEO_PICTURE_RESOURCE_INFO_KHR`
///
/// The {@code allocate} ({@link VkVideoPictureResourceInfoKHR#allocate(Arena)}, {@link VkVideoPictureResourceInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkVideoPictureResourceInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoPictureResourceInfoKHR.html"><code>VkVideoPictureResourceInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkVideoPictureResourceInfoKHR(@NotNull MemorySegment segment) implements IVkVideoPictureResourceInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoPictureResourceInfoKHR.html"><code>VkVideoPictureResourceInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkVideoPictureResourceInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkVideoPictureResourceInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkVideoPictureResourceInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkVideoPictureResourceInfoKHR, Iterable<VkVideoPictureResourceInfoKHR> {
        public long size() {
            return segment.byteSize() / VkVideoPictureResourceInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkVideoPictureResourceInfoKHR at(long index) {
            return new VkVideoPictureResourceInfoKHR(segment.asSlice(index * VkVideoPictureResourceInfoKHR.BYTES, VkVideoPictureResourceInfoKHR.BYTES));
        }

        public VkVideoPictureResourceInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkVideoPictureResourceInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkVideoPictureResourceInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkVideoPictureResourceInfoKHR.BYTES, VkVideoPictureResourceInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkVideoPictureResourceInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkVideoPictureResourceInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkVideoPictureResourceInfoKHR.BYTES,
                (end - start) * VkVideoPictureResourceInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkVideoPictureResourceInfoKHR.BYTES));
        }

        public VkVideoPictureResourceInfoKHR[] toArray() {
            VkVideoPictureResourceInfoKHR[] ret = new VkVideoPictureResourceInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkVideoPictureResourceInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkVideoPictureResourceInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkVideoPictureResourceInfoKHR.BYTES;
            }

            @Override
            public VkVideoPictureResourceInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkVideoPictureResourceInfoKHR ret = new VkVideoPictureResourceInfoKHR(segment.asSlice(0, VkVideoPictureResourceInfoKHR.BYTES));
                segment = segment.asSlice(VkVideoPictureResourceInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkVideoPictureResourceInfoKHR allocate(Arena arena) {
        VkVideoPictureResourceInfoKHR ret = new VkVideoPictureResourceInfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.VIDEO_PICTURE_RESOURCE_INFO_KHR);
        return ret;
    }

    public static VkVideoPictureResourceInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkVideoPictureResourceInfoKHR.Ptr ret = new VkVideoPictureResourceInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.VIDEO_PICTURE_RESOURCE_INFO_KHR);
        }
        return ret;
    }

    public static VkVideoPictureResourceInfoKHR clone(Arena arena, VkVideoPictureResourceInfoKHR src) {
        VkVideoPictureResourceInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.VIDEO_PICTURE_RESOURCE_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkVideoPictureResourceInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkVideoPictureResourceInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkVideoPictureResourceInfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NotNull VkOffset2D codedOffset() {
        return new VkOffset2D(segment.asSlice(OFFSET$codedOffset, LAYOUT$codedOffset));
    }

    public VkVideoPictureResourceInfoKHR codedOffset(@NotNull VkOffset2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$codedOffset, SIZE$codedOffset);
        return this;
    }

    public VkVideoPictureResourceInfoKHR codedOffset(Consumer<@NotNull VkOffset2D> consumer) {
        consumer.accept(codedOffset());
        return this;
    }

    public @NotNull VkExtent2D codedExtent() {
        return new VkExtent2D(segment.asSlice(OFFSET$codedExtent, LAYOUT$codedExtent));
    }

    public VkVideoPictureResourceInfoKHR codedExtent(@NotNull VkExtent2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$codedExtent, SIZE$codedExtent);
        return this;
    }

    public VkVideoPictureResourceInfoKHR codedExtent(Consumer<@NotNull VkExtent2D> consumer) {
        consumer.accept(codedExtent());
        return this;
    }

    public @Unsigned int baseArrayLayer() {
        return segment.get(LAYOUT$baseArrayLayer, OFFSET$baseArrayLayer);
    }

    public VkVideoPictureResourceInfoKHR baseArrayLayer(@Unsigned int value) {
        segment.set(LAYOUT$baseArrayLayer, OFFSET$baseArrayLayer, value);
        return this;
    }

    public @Nullable VkImageView imageViewBinding() {
        MemorySegment s = segment.asSlice(OFFSET$imageViewBinding, SIZE$imageViewBinding);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkImageView(s);
    }

    public VkVideoPictureResourceInfoKHR imageViewBinding(@Nullable VkImageView value) {
        segment.set(LAYOUT$imageViewBinding, OFFSET$imageViewBinding, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        VkOffset2D.LAYOUT.withName("codedOffset"),
        VkExtent2D.LAYOUT.withName("codedExtent"),
        ValueLayout.JAVA_INT.withName("baseArrayLayer"),
        ValueLayout.ADDRESS.withName("imageViewBinding")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$codedOffset = PathElement.groupElement("codedOffset");
    public static final PathElement PATH$codedExtent = PathElement.groupElement("codedExtent");
    public static final PathElement PATH$baseArrayLayer = PathElement.groupElement("baseArrayLayer");
    public static final PathElement PATH$imageViewBinding = PathElement.groupElement("imageViewBinding");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final StructLayout LAYOUT$codedOffset = (StructLayout) LAYOUT.select(PATH$codedOffset);
    public static final StructLayout LAYOUT$codedExtent = (StructLayout) LAYOUT.select(PATH$codedExtent);
    public static final OfInt LAYOUT$baseArrayLayer = (OfInt) LAYOUT.select(PATH$baseArrayLayer);
    public static final AddressLayout LAYOUT$imageViewBinding = (AddressLayout) LAYOUT.select(PATH$imageViewBinding);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$codedOffset = LAYOUT$codedOffset.byteSize();
    public static final long SIZE$codedExtent = LAYOUT$codedExtent.byteSize();
    public static final long SIZE$baseArrayLayer = LAYOUT$baseArrayLayer.byteSize();
    public static final long SIZE$imageViewBinding = LAYOUT$imageViewBinding.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$codedOffset = LAYOUT.byteOffset(PATH$codedOffset);
    public static final long OFFSET$codedExtent = LAYOUT.byteOffset(PATH$codedExtent);
    public static final long OFFSET$baseArrayLayer = LAYOUT.byteOffset(PATH$baseArrayLayer);
    public static final long OFFSET$imageViewBinding = LAYOUT.byteOffset(PATH$imageViewBinding);
}
