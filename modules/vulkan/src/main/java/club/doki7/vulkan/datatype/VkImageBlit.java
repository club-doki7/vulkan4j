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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageBlit.html"><code>VkImageBlit</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkImageBlit {
///     VkImageSubresourceLayers srcSubresource; // @link substring="VkImageSubresourceLayers" target="VkImageSubresourceLayers" @link substring="srcSubresource" target="#srcSubresource"
///     VkOffset3D[2] srcOffsets; // @link substring="VkOffset3D" target="VkOffset3D" @link substring="srcOffsets" target="#srcOffsets"
///     VkImageSubresourceLayers dstSubresource; // @link substring="VkImageSubresourceLayers" target="VkImageSubresourceLayers" @link substring="dstSubresource" target="#dstSubresource"
///     VkOffset3D[2] dstOffsets; // @link substring="VkOffset3D" target="VkOffset3D" @link substring="dstOffsets" target="#dstOffsets"
/// } VkImageBlit;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageBlit.html"><code>VkImageBlit</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkImageBlit(@NotNull MemorySegment segment) implements IVkImageBlit {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageBlit.html"><code>VkImageBlit</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkImageBlit}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkImageBlit to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkImageBlit.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkImageBlit, Iterable<VkImageBlit> {
        public long size() {
            return segment.byteSize() / VkImageBlit.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkImageBlit at(long index) {
            return new VkImageBlit(segment.asSlice(index * VkImageBlit.BYTES, VkImageBlit.BYTES));
        }

        public VkImageBlit.Ptr at(long index, @NotNull Consumer<@NotNull VkImageBlit> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkImageBlit value) {
            MemorySegment s = segment.asSlice(index * VkImageBlit.BYTES, VkImageBlit.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkImageBlit.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkImageBlit.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkImageBlit.BYTES,
                (end - start) * VkImageBlit.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkImageBlit.BYTES));
        }

        public VkImageBlit[] toArray() {
            VkImageBlit[] ret = new VkImageBlit[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkImageBlit> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkImageBlit> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkImageBlit.BYTES;
            }

            @Override
            public VkImageBlit next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkImageBlit ret = new VkImageBlit(segment.asSlice(0, VkImageBlit.BYTES));
                segment = segment.asSlice(VkImageBlit.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkImageBlit allocate(Arena arena) {
        return new VkImageBlit(arena.allocate(LAYOUT));
    }

    public static VkImageBlit.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkImageBlit.Ptr(segment);
    }

    public static VkImageBlit clone(Arena arena, VkImageBlit src) {
        VkImageBlit ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull VkImageSubresourceLayers srcSubresource() {
        return new VkImageSubresourceLayers(segment.asSlice(OFFSET$srcSubresource, LAYOUT$srcSubresource));
    }

    public VkImageBlit srcSubresource(@NotNull VkImageSubresourceLayers value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$srcSubresource, SIZE$srcSubresource);
        return this;
    }

    public VkImageBlit srcSubresource(Consumer<@NotNull VkImageSubresourceLayers> consumer) {
        consumer.accept(srcSubresource());
        return this;
    }

    public VkOffset3D.Ptr srcOffsets() {
        return new VkOffset3D.Ptr(srcOffsetsRaw());
    }

    public VkImageBlit srcOffsets(@NotNull Consumer<VkOffset3D.Ptr> consumer) {
        VkOffset3D.Ptr ptr = srcOffsets();
        consumer.accept(ptr);
        return this;
    }

    public VkImageBlit srcOffsets(VkOffset3D.Ptr value) {
        MemorySegment s = srcOffsetsRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public VkOffset3D srcOffsetsAt(int index) {
        MemorySegment s = srcOffsetsRaw();
        return new VkOffset3D(s.asSlice(index * VkOffset3D.BYTES, VkOffset3D.BYTES));
    }

    public void srcOffsetsAt(int index, VkOffset3D value) {
        MemorySegment s = srcOffsetsRaw();
        MemorySegment.copy(value.segment(), 0, s, index * VkOffset3D.BYTES, VkOffset3D.BYTES);
    }

    public @NotNull MemorySegment srcOffsetsRaw() {
        return segment.asSlice(OFFSET$srcOffsets, SIZE$srcOffsets);
    }

    public @NotNull VkImageSubresourceLayers dstSubresource() {
        return new VkImageSubresourceLayers(segment.asSlice(OFFSET$dstSubresource, LAYOUT$dstSubresource));
    }

    public VkImageBlit dstSubresource(@NotNull VkImageSubresourceLayers value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$dstSubresource, SIZE$dstSubresource);
        return this;
    }

    public VkImageBlit dstSubresource(Consumer<@NotNull VkImageSubresourceLayers> consumer) {
        consumer.accept(dstSubresource());
        return this;
    }

    public VkOffset3D.Ptr dstOffsets() {
        return new VkOffset3D.Ptr(dstOffsetsRaw());
    }

    public VkImageBlit dstOffsets(@NotNull Consumer<VkOffset3D.Ptr> consumer) {
        VkOffset3D.Ptr ptr = dstOffsets();
        consumer.accept(ptr);
        return this;
    }

    public VkImageBlit dstOffsets(VkOffset3D.Ptr value) {
        MemorySegment s = dstOffsetsRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public VkOffset3D dstOffsetsAt(int index) {
        MemorySegment s = dstOffsetsRaw();
        return new VkOffset3D(s.asSlice(index * VkOffset3D.BYTES, VkOffset3D.BYTES));
    }

    public void dstOffsetsAt(int index, VkOffset3D value) {
        MemorySegment s = dstOffsetsRaw();
        MemorySegment.copy(value.segment(), 0, s, index * VkOffset3D.BYTES, VkOffset3D.BYTES);
    }

    public @NotNull MemorySegment dstOffsetsRaw() {
        return segment.asSlice(OFFSET$dstOffsets, SIZE$dstOffsets);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        VkImageSubresourceLayers.LAYOUT.withName("srcSubresource"),
        MemoryLayout.sequenceLayout(2, VkOffset3D.LAYOUT).withName("srcOffsets"),
        VkImageSubresourceLayers.LAYOUT.withName("dstSubresource"),
        MemoryLayout.sequenceLayout(2, VkOffset3D.LAYOUT).withName("dstOffsets")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$srcSubresource = PathElement.groupElement("srcSubresource");
    public static final PathElement PATH$srcOffsets = PathElement.groupElement("srcOffsets");
    public static final PathElement PATH$dstSubresource = PathElement.groupElement("dstSubresource");
    public static final PathElement PATH$dstOffsets = PathElement.groupElement("dstOffsets");

    public static final StructLayout LAYOUT$srcSubresource = (StructLayout) LAYOUT.select(PATH$srcSubresource);
    public static final SequenceLayout LAYOUT$srcOffsets = (SequenceLayout) LAYOUT.select(PATH$srcOffsets);
    public static final StructLayout LAYOUT$dstSubresource = (StructLayout) LAYOUT.select(PATH$dstSubresource);
    public static final SequenceLayout LAYOUT$dstOffsets = (SequenceLayout) LAYOUT.select(PATH$dstOffsets);

    public static final long SIZE$srcSubresource = LAYOUT$srcSubresource.byteSize();
    public static final long SIZE$srcOffsets = LAYOUT$srcOffsets.byteSize();
    public static final long SIZE$dstSubresource = LAYOUT$dstSubresource.byteSize();
    public static final long SIZE$dstOffsets = LAYOUT$dstOffsets.byteSize();

    public static final long OFFSET$srcSubresource = LAYOUT.byteOffset(PATH$srcSubresource);
    public static final long OFFSET$srcOffsets = LAYOUT.byteOffset(PATH$srcOffsets);
    public static final long OFFSET$dstSubresource = LAYOUT.byteOffset(PATH$dstSubresource);
    public static final long OFFSET$dstOffsets = LAYOUT.byteOffset(PATH$dstOffsets);
}
