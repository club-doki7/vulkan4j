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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageMemoryBarrier.html"><code>VkImageMemoryBarrier</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkImageMemoryBarrier {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkAccessFlags srcAccessMask; // @link substring="VkAccessFlags" target="VkAccessFlags" @link substring="srcAccessMask" target="#srcAccessMask"
///     VkAccessFlags dstAccessMask; // @link substring="VkAccessFlags" target="VkAccessFlags" @link substring="dstAccessMask" target="#dstAccessMask"
///     VkImageLayout oldLayout; // @link substring="VkImageLayout" target="VkImageLayout" @link substring="oldLayout" target="#oldLayout"
///     VkImageLayout newLayout; // @link substring="VkImageLayout" target="VkImageLayout" @link substring="newLayout" target="#newLayout"
///     uint32_t srcQueueFamilyIndex; // @link substring="srcQueueFamilyIndex" target="#srcQueueFamilyIndex"
///     uint32_t dstQueueFamilyIndex; // @link substring="dstQueueFamilyIndex" target="#dstQueueFamilyIndex"
///     VkImage image; // @link substring="VkImage" target="VkImage" @link substring="image" target="#image"
///     VkImageSubresourceRange subresourceRange; // @link substring="VkImageSubresourceRange" target="VkImageSubresourceRange" @link substring="subresourceRange" target="#subresourceRange"
/// } VkImageMemoryBarrier;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_IMAGE_MEMORY_BARRIER`
///
/// The {@code allocate} ({@link VkImageMemoryBarrier#allocate(Arena)}, {@link VkImageMemoryBarrier#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkImageMemoryBarrier#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageMemoryBarrier.html"><code>VkImageMemoryBarrier</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkImageMemoryBarrier(@NotNull MemorySegment segment) implements IVkImageMemoryBarrier {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageMemoryBarrier.html"><code>VkImageMemoryBarrier</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkImageMemoryBarrier}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkImageMemoryBarrier to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkImageMemoryBarrier.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkImageMemoryBarrier, Iterable<VkImageMemoryBarrier> {
        public long size() {
            return segment.byteSize() / VkImageMemoryBarrier.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkImageMemoryBarrier at(long index) {
            return new VkImageMemoryBarrier(segment.asSlice(index * VkImageMemoryBarrier.BYTES, VkImageMemoryBarrier.BYTES));
        }

        public VkImageMemoryBarrier.Ptr at(long index, @NotNull Consumer<@NotNull VkImageMemoryBarrier> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkImageMemoryBarrier value) {
            MemorySegment s = segment.asSlice(index * VkImageMemoryBarrier.BYTES, VkImageMemoryBarrier.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkImageMemoryBarrier.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkImageMemoryBarrier.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkImageMemoryBarrier.BYTES,
                (end - start) * VkImageMemoryBarrier.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkImageMemoryBarrier.BYTES));
        }

        public VkImageMemoryBarrier[] toArray() {
            VkImageMemoryBarrier[] ret = new VkImageMemoryBarrier[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkImageMemoryBarrier> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkImageMemoryBarrier> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkImageMemoryBarrier.BYTES;
            }

            @Override
            public VkImageMemoryBarrier next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkImageMemoryBarrier ret = new VkImageMemoryBarrier(segment.asSlice(0, VkImageMemoryBarrier.BYTES));
                segment = segment.asSlice(VkImageMemoryBarrier.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkImageMemoryBarrier allocate(Arena arena) {
        VkImageMemoryBarrier ret = new VkImageMemoryBarrier(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.IMAGE_MEMORY_BARRIER);
        return ret;
    }

    public static VkImageMemoryBarrier.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkImageMemoryBarrier.Ptr ret = new VkImageMemoryBarrier.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.IMAGE_MEMORY_BARRIER);
        }
        return ret;
    }

    public static VkImageMemoryBarrier clone(Arena arena, VkImageMemoryBarrier src) {
        VkImageMemoryBarrier ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.IMAGE_MEMORY_BARRIER);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkImageMemoryBarrier sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkImageMemoryBarrier pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkImageMemoryBarrier pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkAccessFlags.class) int srcAccessMask() {
        return segment.get(LAYOUT$srcAccessMask, OFFSET$srcAccessMask);
    }

    public VkImageMemoryBarrier srcAccessMask(@Bitmask(VkAccessFlags.class) int value) {
        segment.set(LAYOUT$srcAccessMask, OFFSET$srcAccessMask, value);
        return this;
    }

    public @Bitmask(VkAccessFlags.class) int dstAccessMask() {
        return segment.get(LAYOUT$dstAccessMask, OFFSET$dstAccessMask);
    }

    public VkImageMemoryBarrier dstAccessMask(@Bitmask(VkAccessFlags.class) int value) {
        segment.set(LAYOUT$dstAccessMask, OFFSET$dstAccessMask, value);
        return this;
    }

    public @EnumType(VkImageLayout.class) int oldLayout() {
        return segment.get(LAYOUT$oldLayout, OFFSET$oldLayout);
    }

    public VkImageMemoryBarrier oldLayout(@EnumType(VkImageLayout.class) int value) {
        segment.set(LAYOUT$oldLayout, OFFSET$oldLayout, value);
        return this;
    }

    public @EnumType(VkImageLayout.class) int newLayout() {
        return segment.get(LAYOUT$newLayout, OFFSET$newLayout);
    }

    public VkImageMemoryBarrier newLayout(@EnumType(VkImageLayout.class) int value) {
        segment.set(LAYOUT$newLayout, OFFSET$newLayout, value);
        return this;
    }

    public @Unsigned int srcQueueFamilyIndex() {
        return segment.get(LAYOUT$srcQueueFamilyIndex, OFFSET$srcQueueFamilyIndex);
    }

    public VkImageMemoryBarrier srcQueueFamilyIndex(@Unsigned int value) {
        segment.set(LAYOUT$srcQueueFamilyIndex, OFFSET$srcQueueFamilyIndex, value);
        return this;
    }

    public @Unsigned int dstQueueFamilyIndex() {
        return segment.get(LAYOUT$dstQueueFamilyIndex, OFFSET$dstQueueFamilyIndex);
    }

    public VkImageMemoryBarrier dstQueueFamilyIndex(@Unsigned int value) {
        segment.set(LAYOUT$dstQueueFamilyIndex, OFFSET$dstQueueFamilyIndex, value);
        return this;
    }

    public @Nullable VkImage image() {
        MemorySegment s = segment.asSlice(OFFSET$image, SIZE$image);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkImage(s);
    }

    public VkImageMemoryBarrier image(@Nullable VkImage value) {
        segment.set(LAYOUT$image, OFFSET$image, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @NotNull VkImageSubresourceRange subresourceRange() {
        return new VkImageSubresourceRange(segment.asSlice(OFFSET$subresourceRange, LAYOUT$subresourceRange));
    }

    public VkImageMemoryBarrier subresourceRange(@NotNull VkImageSubresourceRange value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$subresourceRange, SIZE$subresourceRange);
        return this;
    }

    public VkImageMemoryBarrier subresourceRange(Consumer<@NotNull VkImageSubresourceRange> consumer) {
        consumer.accept(subresourceRange());
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("srcAccessMask"),
        ValueLayout.JAVA_INT.withName("dstAccessMask"),
        ValueLayout.JAVA_INT.withName("oldLayout"),
        ValueLayout.JAVA_INT.withName("newLayout"),
        ValueLayout.JAVA_INT.withName("srcQueueFamilyIndex"),
        ValueLayout.JAVA_INT.withName("dstQueueFamilyIndex"),
        ValueLayout.ADDRESS.withName("image"),
        VkImageSubresourceRange.LAYOUT.withName("subresourceRange")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$srcAccessMask = PathElement.groupElement("srcAccessMask");
    public static final PathElement PATH$dstAccessMask = PathElement.groupElement("dstAccessMask");
    public static final PathElement PATH$oldLayout = PathElement.groupElement("oldLayout");
    public static final PathElement PATH$newLayout = PathElement.groupElement("newLayout");
    public static final PathElement PATH$srcQueueFamilyIndex = PathElement.groupElement("srcQueueFamilyIndex");
    public static final PathElement PATH$dstQueueFamilyIndex = PathElement.groupElement("dstQueueFamilyIndex");
    public static final PathElement PATH$image = PathElement.groupElement("image");
    public static final PathElement PATH$subresourceRange = PathElement.groupElement("subresourceRange");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$srcAccessMask = (OfInt) LAYOUT.select(PATH$srcAccessMask);
    public static final OfInt LAYOUT$dstAccessMask = (OfInt) LAYOUT.select(PATH$dstAccessMask);
    public static final OfInt LAYOUT$oldLayout = (OfInt) LAYOUT.select(PATH$oldLayout);
    public static final OfInt LAYOUT$newLayout = (OfInt) LAYOUT.select(PATH$newLayout);
    public static final OfInt LAYOUT$srcQueueFamilyIndex = (OfInt) LAYOUT.select(PATH$srcQueueFamilyIndex);
    public static final OfInt LAYOUT$dstQueueFamilyIndex = (OfInt) LAYOUT.select(PATH$dstQueueFamilyIndex);
    public static final AddressLayout LAYOUT$image = (AddressLayout) LAYOUT.select(PATH$image);
    public static final StructLayout LAYOUT$subresourceRange = (StructLayout) LAYOUT.select(PATH$subresourceRange);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$srcAccessMask = LAYOUT$srcAccessMask.byteSize();
    public static final long SIZE$dstAccessMask = LAYOUT$dstAccessMask.byteSize();
    public static final long SIZE$oldLayout = LAYOUT$oldLayout.byteSize();
    public static final long SIZE$newLayout = LAYOUT$newLayout.byteSize();
    public static final long SIZE$srcQueueFamilyIndex = LAYOUT$srcQueueFamilyIndex.byteSize();
    public static final long SIZE$dstQueueFamilyIndex = LAYOUT$dstQueueFamilyIndex.byteSize();
    public static final long SIZE$image = LAYOUT$image.byteSize();
    public static final long SIZE$subresourceRange = LAYOUT$subresourceRange.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$srcAccessMask = LAYOUT.byteOffset(PATH$srcAccessMask);
    public static final long OFFSET$dstAccessMask = LAYOUT.byteOffset(PATH$dstAccessMask);
    public static final long OFFSET$oldLayout = LAYOUT.byteOffset(PATH$oldLayout);
    public static final long OFFSET$newLayout = LAYOUT.byteOffset(PATH$newLayout);
    public static final long OFFSET$srcQueueFamilyIndex = LAYOUT.byteOffset(PATH$srcQueueFamilyIndex);
    public static final long OFFSET$dstQueueFamilyIndex = LAYOUT.byteOffset(PATH$dstQueueFamilyIndex);
    public static final long OFFSET$image = LAYOUT.byteOffset(PATH$image);
    public static final long OFFSET$subresourceRange = LAYOUT.byteOffset(PATH$subresourceRange);
}
