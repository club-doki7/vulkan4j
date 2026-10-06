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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageCopy.html"><code>VkImageCopy</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkImageCopy {
///     VkImageSubresourceLayers srcSubresource; // @link substring="VkImageSubresourceLayers" target="VkImageSubresourceLayers" @link substring="srcSubresource" target="#srcSubresource"
///     VkOffset3D srcOffset; // @link substring="VkOffset3D" target="VkOffset3D" @link substring="srcOffset" target="#srcOffset"
///     VkImageSubresourceLayers dstSubresource; // @link substring="VkImageSubresourceLayers" target="VkImageSubresourceLayers" @link substring="dstSubresource" target="#dstSubresource"
///     VkOffset3D dstOffset; // @link substring="VkOffset3D" target="VkOffset3D" @link substring="dstOffset" target="#dstOffset"
///     VkExtent3D extent; // @link substring="VkExtent3D" target="VkExtent3D" @link substring="extent" target="#extent"
/// } VkImageCopy;
/// }
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageCopy.html"><code>VkImageCopy</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkImageCopy(@NotNull MemorySegment segment) implements IVkImageCopy {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageCopy.html"><code>VkImageCopy</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkImageCopy}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkImageCopy to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkImageCopy.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkImageCopy, Iterable<VkImageCopy> {
        public long size() {
            return segment.byteSize() / VkImageCopy.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkImageCopy at(long index) {
            return new VkImageCopy(segment.asSlice(index * VkImageCopy.BYTES, VkImageCopy.BYTES));
        }

        public VkImageCopy.Ptr at(long index, @NotNull Consumer<@NotNull VkImageCopy> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkImageCopy value) {
            MemorySegment s = segment.asSlice(index * VkImageCopy.BYTES, VkImageCopy.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkImageCopy.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkImageCopy.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkImageCopy.BYTES,
                (end - start) * VkImageCopy.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkImageCopy.BYTES));
        }

        public VkImageCopy[] toArray() {
            VkImageCopy[] ret = new VkImageCopy[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkImageCopy> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkImageCopy> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkImageCopy.BYTES;
            }

            @Override
            public VkImageCopy next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkImageCopy ret = new VkImageCopy(segment.asSlice(0, VkImageCopy.BYTES));
                segment = segment.asSlice(VkImageCopy.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkImageCopy allocate(Arena arena) {
        return new VkImageCopy(arena.allocate(LAYOUT));
    }

    public static VkImageCopy.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkImageCopy.Ptr(segment);
    }

    public static VkImageCopy clone(Arena arena, VkImageCopy src) {
        VkImageCopy ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull VkImageSubresourceLayers srcSubresource() {
        return new VkImageSubresourceLayers(segment.asSlice(OFFSET$srcSubresource, LAYOUT$srcSubresource));
    }

    public VkImageCopy srcSubresource(@NotNull VkImageSubresourceLayers value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$srcSubresource, SIZE$srcSubresource);
        return this;
    }

    public VkImageCopy srcSubresource(Consumer<@NotNull VkImageSubresourceLayers> consumer) {
        consumer.accept(srcSubresource());
        return this;
    }

    public @NotNull VkOffset3D srcOffset() {
        return new VkOffset3D(segment.asSlice(OFFSET$srcOffset, LAYOUT$srcOffset));
    }

    public VkImageCopy srcOffset(@NotNull VkOffset3D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$srcOffset, SIZE$srcOffset);
        return this;
    }

    public VkImageCopy srcOffset(Consumer<@NotNull VkOffset3D> consumer) {
        consumer.accept(srcOffset());
        return this;
    }

    public @NotNull VkImageSubresourceLayers dstSubresource() {
        return new VkImageSubresourceLayers(segment.asSlice(OFFSET$dstSubresource, LAYOUT$dstSubresource));
    }

    public VkImageCopy dstSubresource(@NotNull VkImageSubresourceLayers value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$dstSubresource, SIZE$dstSubresource);
        return this;
    }

    public VkImageCopy dstSubresource(Consumer<@NotNull VkImageSubresourceLayers> consumer) {
        consumer.accept(dstSubresource());
        return this;
    }

    public @NotNull VkOffset3D dstOffset() {
        return new VkOffset3D(segment.asSlice(OFFSET$dstOffset, LAYOUT$dstOffset));
    }

    public VkImageCopy dstOffset(@NotNull VkOffset3D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$dstOffset, SIZE$dstOffset);
        return this;
    }

    public VkImageCopy dstOffset(Consumer<@NotNull VkOffset3D> consumer) {
        consumer.accept(dstOffset());
        return this;
    }

    public @NotNull VkExtent3D extent() {
        return new VkExtent3D(segment.asSlice(OFFSET$extent, LAYOUT$extent));
    }

    public VkImageCopy extent(@NotNull VkExtent3D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$extent, SIZE$extent);
        return this;
    }

    public VkImageCopy extent(Consumer<@NotNull VkExtent3D> consumer) {
        consumer.accept(extent());
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        VkImageSubresourceLayers.LAYOUT.withName("srcSubresource"),
        VkOffset3D.LAYOUT.withName("srcOffset"),
        VkImageSubresourceLayers.LAYOUT.withName("dstSubresource"),
        VkOffset3D.LAYOUT.withName("dstOffset"),
        VkExtent3D.LAYOUT.withName("extent")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$srcSubresource = PathElement.groupElement("srcSubresource");
    public static final PathElement PATH$srcOffset = PathElement.groupElement("srcOffset");
    public static final PathElement PATH$dstSubresource = PathElement.groupElement("dstSubresource");
    public static final PathElement PATH$dstOffset = PathElement.groupElement("dstOffset");
    public static final PathElement PATH$extent = PathElement.groupElement("extent");

    public static final StructLayout LAYOUT$srcSubresource = (StructLayout) LAYOUT.select(PATH$srcSubresource);
    public static final StructLayout LAYOUT$srcOffset = (StructLayout) LAYOUT.select(PATH$srcOffset);
    public static final StructLayout LAYOUT$dstSubresource = (StructLayout) LAYOUT.select(PATH$dstSubresource);
    public static final StructLayout LAYOUT$dstOffset = (StructLayout) LAYOUT.select(PATH$dstOffset);
    public static final StructLayout LAYOUT$extent = (StructLayout) LAYOUT.select(PATH$extent);

    public static final long SIZE$srcSubresource = LAYOUT$srcSubresource.byteSize();
    public static final long SIZE$srcOffset = LAYOUT$srcOffset.byteSize();
    public static final long SIZE$dstSubresource = LAYOUT$dstSubresource.byteSize();
    public static final long SIZE$dstOffset = LAYOUT$dstOffset.byteSize();
    public static final long SIZE$extent = LAYOUT$extent.byteSize();

    public static final long OFFSET$srcSubresource = LAYOUT.byteOffset(PATH$srcSubresource);
    public static final long OFFSET$srcOffset = LAYOUT.byteOffset(PATH$srcOffset);
    public static final long OFFSET$dstSubresource = LAYOUT.byteOffset(PATH$dstSubresource);
    public static final long OFFSET$dstOffset = LAYOUT.byteOffset(PATH$dstOffset);
    public static final long OFFSET$extent = LAYOUT.byteOffset(PATH$extent);
}
