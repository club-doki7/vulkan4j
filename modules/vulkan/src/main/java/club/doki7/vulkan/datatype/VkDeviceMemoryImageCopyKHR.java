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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDeviceMemoryImageCopyKHR.html"><code>VkDeviceMemoryImageCopyKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDeviceMemoryImageCopyKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkDeviceAddressRangeKHR addressRange; // @link substring="VkDeviceAddressRangeKHR" target="VkDeviceAddressRangeKHR" @link substring="addressRange" target="#addressRange"
///     VkAddressCommandFlagsKHR addressFlags; // optional // @link substring="VkAddressCommandFlagsKHR" target="VkAddressCommandFlagsKHR" @link substring="addressFlags" target="#addressFlags"
///     uint32_t addressRowLength; // @link substring="addressRowLength" target="#addressRowLength"
///     uint32_t addressImageHeight; // @link substring="addressImageHeight" target="#addressImageHeight"
///     VkImageSubresourceLayers imageSubresource; // @link substring="VkImageSubresourceLayers" target="VkImageSubresourceLayers" @link substring="imageSubresource" target="#imageSubresource"
///     VkImageLayout imageLayout; // @link substring="VkImageLayout" target="VkImageLayout" @link substring="imageLayout" target="#imageLayout"
///     VkOffset3D imageOffset; // @link substring="VkOffset3D" target="VkOffset3D" @link substring="imageOffset" target="#imageOffset"
///     VkExtent3D imageExtent; // @link substring="VkExtent3D" target="VkExtent3D" @link substring="imageExtent" target="#imageExtent"
/// } VkDeviceMemoryImageCopyKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_DEVICE_MEMORY_IMAGE_COPY_KHR`
///
/// The {@code allocate} ({@link VkDeviceMemoryImageCopyKHR#allocate(Arena)}, {@link VkDeviceMemoryImageCopyKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkDeviceMemoryImageCopyKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDeviceMemoryImageCopyKHR.html"><code>VkDeviceMemoryImageCopyKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDeviceMemoryImageCopyKHR(@NotNull MemorySegment segment) implements IVkDeviceMemoryImageCopyKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDeviceMemoryImageCopyKHR.html"><code>VkDeviceMemoryImageCopyKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDeviceMemoryImageCopyKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDeviceMemoryImageCopyKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDeviceMemoryImageCopyKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDeviceMemoryImageCopyKHR, Iterable<VkDeviceMemoryImageCopyKHR> {
        public long size() {
            return segment.byteSize() / VkDeviceMemoryImageCopyKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDeviceMemoryImageCopyKHR at(long index) {
            return new VkDeviceMemoryImageCopyKHR(segment.asSlice(index * VkDeviceMemoryImageCopyKHR.BYTES, VkDeviceMemoryImageCopyKHR.BYTES));
        }

        public VkDeviceMemoryImageCopyKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkDeviceMemoryImageCopyKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDeviceMemoryImageCopyKHR value) {
            MemorySegment s = segment.asSlice(index * VkDeviceMemoryImageCopyKHR.BYTES, VkDeviceMemoryImageCopyKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDeviceMemoryImageCopyKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDeviceMemoryImageCopyKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDeviceMemoryImageCopyKHR.BYTES,
                (end - start) * VkDeviceMemoryImageCopyKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDeviceMemoryImageCopyKHR.BYTES));
        }

        public VkDeviceMemoryImageCopyKHR[] toArray() {
            VkDeviceMemoryImageCopyKHR[] ret = new VkDeviceMemoryImageCopyKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDeviceMemoryImageCopyKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDeviceMemoryImageCopyKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDeviceMemoryImageCopyKHR.BYTES;
            }

            @Override
            public VkDeviceMemoryImageCopyKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDeviceMemoryImageCopyKHR ret = new VkDeviceMemoryImageCopyKHR(segment.asSlice(0, VkDeviceMemoryImageCopyKHR.BYTES));
                segment = segment.asSlice(VkDeviceMemoryImageCopyKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDeviceMemoryImageCopyKHR allocate(Arena arena) {
        VkDeviceMemoryImageCopyKHR ret = new VkDeviceMemoryImageCopyKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.DEVICE_MEMORY_IMAGE_COPY_KHR);
        return ret;
    }

    public static VkDeviceMemoryImageCopyKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkDeviceMemoryImageCopyKHR.Ptr ret = new VkDeviceMemoryImageCopyKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.DEVICE_MEMORY_IMAGE_COPY_KHR);
        }
        return ret;
    }

    public static VkDeviceMemoryImageCopyKHR clone(Arena arena, VkDeviceMemoryImageCopyKHR src) {
        VkDeviceMemoryImageCopyKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.DEVICE_MEMORY_IMAGE_COPY_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkDeviceMemoryImageCopyKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkDeviceMemoryImageCopyKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkDeviceMemoryImageCopyKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NotNull VkDeviceAddressRangeKHR addressRange() {
        return new VkDeviceAddressRangeKHR(segment.asSlice(OFFSET$addressRange, LAYOUT$addressRange));
    }

    public VkDeviceMemoryImageCopyKHR addressRange(@NotNull VkDeviceAddressRangeKHR value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$addressRange, SIZE$addressRange);
        return this;
    }

    public VkDeviceMemoryImageCopyKHR addressRange(Consumer<@NotNull VkDeviceAddressRangeKHR> consumer) {
        consumer.accept(addressRange());
        return this;
    }

    public @Bitmask(VkAddressCommandFlagsKHR.class) int addressFlags() {
        return segment.get(LAYOUT$addressFlags, OFFSET$addressFlags);
    }

    public VkDeviceMemoryImageCopyKHR addressFlags(@Bitmask(VkAddressCommandFlagsKHR.class) int value) {
        segment.set(LAYOUT$addressFlags, OFFSET$addressFlags, value);
        return this;
    }

    public @Unsigned int addressRowLength() {
        return segment.get(LAYOUT$addressRowLength, OFFSET$addressRowLength);
    }

    public VkDeviceMemoryImageCopyKHR addressRowLength(@Unsigned int value) {
        segment.set(LAYOUT$addressRowLength, OFFSET$addressRowLength, value);
        return this;
    }

    public @Unsigned int addressImageHeight() {
        return segment.get(LAYOUT$addressImageHeight, OFFSET$addressImageHeight);
    }

    public VkDeviceMemoryImageCopyKHR addressImageHeight(@Unsigned int value) {
        segment.set(LAYOUT$addressImageHeight, OFFSET$addressImageHeight, value);
        return this;
    }

    public @NotNull VkImageSubresourceLayers imageSubresource() {
        return new VkImageSubresourceLayers(segment.asSlice(OFFSET$imageSubresource, LAYOUT$imageSubresource));
    }

    public VkDeviceMemoryImageCopyKHR imageSubresource(@NotNull VkImageSubresourceLayers value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$imageSubresource, SIZE$imageSubresource);
        return this;
    }

    public VkDeviceMemoryImageCopyKHR imageSubresource(Consumer<@NotNull VkImageSubresourceLayers> consumer) {
        consumer.accept(imageSubresource());
        return this;
    }

    public @EnumType(VkImageLayout.class) int imageLayout() {
        return segment.get(LAYOUT$imageLayout, OFFSET$imageLayout);
    }

    public VkDeviceMemoryImageCopyKHR imageLayout(@EnumType(VkImageLayout.class) int value) {
        segment.set(LAYOUT$imageLayout, OFFSET$imageLayout, value);
        return this;
    }

    public @NotNull VkOffset3D imageOffset() {
        return new VkOffset3D(segment.asSlice(OFFSET$imageOffset, LAYOUT$imageOffset));
    }

    public VkDeviceMemoryImageCopyKHR imageOffset(@NotNull VkOffset3D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$imageOffset, SIZE$imageOffset);
        return this;
    }

    public VkDeviceMemoryImageCopyKHR imageOffset(Consumer<@NotNull VkOffset3D> consumer) {
        consumer.accept(imageOffset());
        return this;
    }

    public @NotNull VkExtent3D imageExtent() {
        return new VkExtent3D(segment.asSlice(OFFSET$imageExtent, LAYOUT$imageExtent));
    }

    public VkDeviceMemoryImageCopyKHR imageExtent(@NotNull VkExtent3D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$imageExtent, SIZE$imageExtent);
        return this;
    }

    public VkDeviceMemoryImageCopyKHR imageExtent(Consumer<@NotNull VkExtent3D> consumer) {
        consumer.accept(imageExtent());
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        VkDeviceAddressRangeKHR.LAYOUT.withName("addressRange"),
        ValueLayout.JAVA_INT.withName("addressFlags"),
        ValueLayout.JAVA_INT.withName("addressRowLength"),
        ValueLayout.JAVA_INT.withName("addressImageHeight"),
        VkImageSubresourceLayers.LAYOUT.withName("imageSubresource"),
        ValueLayout.JAVA_INT.withName("imageLayout"),
        VkOffset3D.LAYOUT.withName("imageOffset"),
        VkExtent3D.LAYOUT.withName("imageExtent")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$addressRange = PathElement.groupElement("addressRange");
    public static final PathElement PATH$addressFlags = PathElement.groupElement("addressFlags");
    public static final PathElement PATH$addressRowLength = PathElement.groupElement("addressRowLength");
    public static final PathElement PATH$addressImageHeight = PathElement.groupElement("addressImageHeight");
    public static final PathElement PATH$imageSubresource = PathElement.groupElement("imageSubresource");
    public static final PathElement PATH$imageLayout = PathElement.groupElement("imageLayout");
    public static final PathElement PATH$imageOffset = PathElement.groupElement("imageOffset");
    public static final PathElement PATH$imageExtent = PathElement.groupElement("imageExtent");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final StructLayout LAYOUT$addressRange = (StructLayout) LAYOUT.select(PATH$addressRange);
    public static final OfInt LAYOUT$addressFlags = (OfInt) LAYOUT.select(PATH$addressFlags);
    public static final OfInt LAYOUT$addressRowLength = (OfInt) LAYOUT.select(PATH$addressRowLength);
    public static final OfInt LAYOUT$addressImageHeight = (OfInt) LAYOUT.select(PATH$addressImageHeight);
    public static final StructLayout LAYOUT$imageSubresource = (StructLayout) LAYOUT.select(PATH$imageSubresource);
    public static final OfInt LAYOUT$imageLayout = (OfInt) LAYOUT.select(PATH$imageLayout);
    public static final StructLayout LAYOUT$imageOffset = (StructLayout) LAYOUT.select(PATH$imageOffset);
    public static final StructLayout LAYOUT$imageExtent = (StructLayout) LAYOUT.select(PATH$imageExtent);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$addressRange = LAYOUT$addressRange.byteSize();
    public static final long SIZE$addressFlags = LAYOUT$addressFlags.byteSize();
    public static final long SIZE$addressRowLength = LAYOUT$addressRowLength.byteSize();
    public static final long SIZE$addressImageHeight = LAYOUT$addressImageHeight.byteSize();
    public static final long SIZE$imageSubresource = LAYOUT$imageSubresource.byteSize();
    public static final long SIZE$imageLayout = LAYOUT$imageLayout.byteSize();
    public static final long SIZE$imageOffset = LAYOUT$imageOffset.byteSize();
    public static final long SIZE$imageExtent = LAYOUT$imageExtent.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$addressRange = LAYOUT.byteOffset(PATH$addressRange);
    public static final long OFFSET$addressFlags = LAYOUT.byteOffset(PATH$addressFlags);
    public static final long OFFSET$addressRowLength = LAYOUT.byteOffset(PATH$addressRowLength);
    public static final long OFFSET$addressImageHeight = LAYOUT.byteOffset(PATH$addressImageHeight);
    public static final long OFFSET$imageSubresource = LAYOUT.byteOffset(PATH$imageSubresource);
    public static final long OFFSET$imageLayout = LAYOUT.byteOffset(PATH$imageLayout);
    public static final long OFFSET$imageOffset = LAYOUT.byteOffset(PATH$imageOffset);
    public static final long OFFSET$imageExtent = LAYOUT.byteOffset(PATH$imageExtent);
}
