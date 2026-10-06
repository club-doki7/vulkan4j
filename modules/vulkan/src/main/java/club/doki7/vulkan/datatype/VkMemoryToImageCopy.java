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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMemoryToImageCopy.html"><code>VkMemoryToImageCopy</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkMemoryToImageCopy {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     void const* pHostPointer; // @link substring="pHostPointer" target="#pHostPointer"
///     uint32_t memoryRowLength; // @link substring="memoryRowLength" target="#memoryRowLength"
///     uint32_t memoryImageHeight; // @link substring="memoryImageHeight" target="#memoryImageHeight"
///     VkImageSubresourceLayers imageSubresource; // @link substring="VkImageSubresourceLayers" target="VkImageSubresourceLayers" @link substring="imageSubresource" target="#imageSubresource"
///     VkOffset3D imageOffset; // @link substring="VkOffset3D" target="VkOffset3D" @link substring="imageOffset" target="#imageOffset"
///     VkExtent3D imageExtent; // @link substring="VkExtent3D" target="VkExtent3D" @link substring="imageExtent" target="#imageExtent"
/// } VkMemoryToImageCopy;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_MEMORY_TO_IMAGE_COPY`
///
/// The {@code allocate} ({@link VkMemoryToImageCopy#allocate(Arena)}, {@link VkMemoryToImageCopy#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkMemoryToImageCopy#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMemoryToImageCopy.html"><code>VkMemoryToImageCopy</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkMemoryToImageCopy(@NotNull MemorySegment segment) implements IVkMemoryToImageCopy {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMemoryToImageCopy.html"><code>VkMemoryToImageCopy</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkMemoryToImageCopy}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkMemoryToImageCopy to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkMemoryToImageCopy.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkMemoryToImageCopy, Iterable<VkMemoryToImageCopy> {
        public long size() {
            return segment.byteSize() / VkMemoryToImageCopy.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkMemoryToImageCopy at(long index) {
            return new VkMemoryToImageCopy(segment.asSlice(index * VkMemoryToImageCopy.BYTES, VkMemoryToImageCopy.BYTES));
        }

        public VkMemoryToImageCopy.Ptr at(long index, @NotNull Consumer<@NotNull VkMemoryToImageCopy> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkMemoryToImageCopy value) {
            MemorySegment s = segment.asSlice(index * VkMemoryToImageCopy.BYTES, VkMemoryToImageCopy.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkMemoryToImageCopy.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkMemoryToImageCopy.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkMemoryToImageCopy.BYTES,
                (end - start) * VkMemoryToImageCopy.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkMemoryToImageCopy.BYTES));
        }

        public VkMemoryToImageCopy[] toArray() {
            VkMemoryToImageCopy[] ret = new VkMemoryToImageCopy[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkMemoryToImageCopy> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkMemoryToImageCopy> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkMemoryToImageCopy.BYTES;
            }

            @Override
            public VkMemoryToImageCopy next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkMemoryToImageCopy ret = new VkMemoryToImageCopy(segment.asSlice(0, VkMemoryToImageCopy.BYTES));
                segment = segment.asSlice(VkMemoryToImageCopy.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkMemoryToImageCopy allocate(Arena arena) {
        VkMemoryToImageCopy ret = new VkMemoryToImageCopy(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.MEMORY_TO_IMAGE_COPY);
        return ret;
    }

    public static VkMemoryToImageCopy.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkMemoryToImageCopy.Ptr ret = new VkMemoryToImageCopy.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.MEMORY_TO_IMAGE_COPY);
        }
        return ret;
    }

    public static VkMemoryToImageCopy clone(Arena arena, VkMemoryToImageCopy src) {
        VkMemoryToImageCopy ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.MEMORY_TO_IMAGE_COPY);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkMemoryToImageCopy sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkMemoryToImageCopy pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkMemoryToImageCopy pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pHostPointer() {
        return segment.get(LAYOUT$pHostPointer, OFFSET$pHostPointer);
    }

    public VkMemoryToImageCopy pHostPointer(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pHostPointer, OFFSET$pHostPointer, value);
        return this;
    }

    public VkMemoryToImageCopy pHostPointer(@Nullable IPointer pointer) {
        pHostPointer(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int memoryRowLength() {
        return segment.get(LAYOUT$memoryRowLength, OFFSET$memoryRowLength);
    }

    public VkMemoryToImageCopy memoryRowLength(@Unsigned int value) {
        segment.set(LAYOUT$memoryRowLength, OFFSET$memoryRowLength, value);
        return this;
    }

    public @Unsigned int memoryImageHeight() {
        return segment.get(LAYOUT$memoryImageHeight, OFFSET$memoryImageHeight);
    }

    public VkMemoryToImageCopy memoryImageHeight(@Unsigned int value) {
        segment.set(LAYOUT$memoryImageHeight, OFFSET$memoryImageHeight, value);
        return this;
    }

    public @NotNull VkImageSubresourceLayers imageSubresource() {
        return new VkImageSubresourceLayers(segment.asSlice(OFFSET$imageSubresource, LAYOUT$imageSubresource));
    }

    public VkMemoryToImageCopy imageSubresource(@NotNull VkImageSubresourceLayers value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$imageSubresource, SIZE$imageSubresource);
        return this;
    }

    public VkMemoryToImageCopy imageSubresource(Consumer<@NotNull VkImageSubresourceLayers> consumer) {
        consumer.accept(imageSubresource());
        return this;
    }

    public @NotNull VkOffset3D imageOffset() {
        return new VkOffset3D(segment.asSlice(OFFSET$imageOffset, LAYOUT$imageOffset));
    }

    public VkMemoryToImageCopy imageOffset(@NotNull VkOffset3D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$imageOffset, SIZE$imageOffset);
        return this;
    }

    public VkMemoryToImageCopy imageOffset(Consumer<@NotNull VkOffset3D> consumer) {
        consumer.accept(imageOffset());
        return this;
    }

    public @NotNull VkExtent3D imageExtent() {
        return new VkExtent3D(segment.asSlice(OFFSET$imageExtent, LAYOUT$imageExtent));
    }

    public VkMemoryToImageCopy imageExtent(@NotNull VkExtent3D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$imageExtent, SIZE$imageExtent);
        return this;
    }

    public VkMemoryToImageCopy imageExtent(Consumer<@NotNull VkExtent3D> consumer) {
        consumer.accept(imageExtent());
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withName("pHostPointer"),
        ValueLayout.JAVA_INT.withName("memoryRowLength"),
        ValueLayout.JAVA_INT.withName("memoryImageHeight"),
        VkImageSubresourceLayers.LAYOUT.withName("imageSubresource"),
        VkOffset3D.LAYOUT.withName("imageOffset"),
        VkExtent3D.LAYOUT.withName("imageExtent")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$pHostPointer = PathElement.groupElement("pHostPointer");
    public static final PathElement PATH$memoryRowLength = PathElement.groupElement("memoryRowLength");
    public static final PathElement PATH$memoryImageHeight = PathElement.groupElement("memoryImageHeight");
    public static final PathElement PATH$imageSubresource = PathElement.groupElement("imageSubresource");
    public static final PathElement PATH$imageOffset = PathElement.groupElement("imageOffset");
    public static final PathElement PATH$imageExtent = PathElement.groupElement("imageExtent");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$pHostPointer = (AddressLayout) LAYOUT.select(PATH$pHostPointer);
    public static final OfInt LAYOUT$memoryRowLength = (OfInt) LAYOUT.select(PATH$memoryRowLength);
    public static final OfInt LAYOUT$memoryImageHeight = (OfInt) LAYOUT.select(PATH$memoryImageHeight);
    public static final StructLayout LAYOUT$imageSubresource = (StructLayout) LAYOUT.select(PATH$imageSubresource);
    public static final StructLayout LAYOUT$imageOffset = (StructLayout) LAYOUT.select(PATH$imageOffset);
    public static final StructLayout LAYOUT$imageExtent = (StructLayout) LAYOUT.select(PATH$imageExtent);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$pHostPointer = LAYOUT$pHostPointer.byteSize();
    public static final long SIZE$memoryRowLength = LAYOUT$memoryRowLength.byteSize();
    public static final long SIZE$memoryImageHeight = LAYOUT$memoryImageHeight.byteSize();
    public static final long SIZE$imageSubresource = LAYOUT$imageSubresource.byteSize();
    public static final long SIZE$imageOffset = LAYOUT$imageOffset.byteSize();
    public static final long SIZE$imageExtent = LAYOUT$imageExtent.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$pHostPointer = LAYOUT.byteOffset(PATH$pHostPointer);
    public static final long OFFSET$memoryRowLength = LAYOUT.byteOffset(PATH$memoryRowLength);
    public static final long OFFSET$memoryImageHeight = LAYOUT.byteOffset(PATH$memoryImageHeight);
    public static final long OFFSET$imageSubresource = LAYOUT.byteOffset(PATH$imageSubresource);
    public static final long OFFSET$imageOffset = LAYOUT.byteOffset(PATH$imageOffset);
    public static final long OFFSET$imageExtent = LAYOUT.byteOffset(PATH$imageExtent);
}
