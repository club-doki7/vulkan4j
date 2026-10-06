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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSparseImageMemoryBind.html"><code>VkSparseImageMemoryBind</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkSparseImageMemoryBind {
///     VkImageSubresource subresource; // @link substring="VkImageSubresource" target="VkImageSubresource" @link substring="subresource" target="#subresource"
///     VkOffset3D offset; // @link substring="VkOffset3D" target="VkOffset3D" @link substring="offset" target="#offset"
///     VkExtent3D extent; // @link substring="VkExtent3D" target="VkExtent3D" @link substring="extent" target="#extent"
///     VkDeviceMemory memory; // optional // @link substring="VkDeviceMemory" target="VkDeviceMemory" @link substring="memory" target="#memory"
///     VkDeviceSize memoryOffset; // @link substring="memoryOffset" target="#memoryOffset"
///     VkSparseMemoryBindFlags flags; // optional // @link substring="VkSparseMemoryBindFlags" target="VkSparseMemoryBindFlags" @link substring="flags" target="#flags"
/// } VkSparseImageMemoryBind;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSparseImageMemoryBind.html"><code>VkSparseImageMemoryBind</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkSparseImageMemoryBind(@NotNull MemorySegment segment) implements IVkSparseImageMemoryBind {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSparseImageMemoryBind.html"><code>VkSparseImageMemoryBind</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkSparseImageMemoryBind}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkSparseImageMemoryBind to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkSparseImageMemoryBind.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkSparseImageMemoryBind, Iterable<VkSparseImageMemoryBind> {
        public long size() {
            return segment.byteSize() / VkSparseImageMemoryBind.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkSparseImageMemoryBind at(long index) {
            return new VkSparseImageMemoryBind(segment.asSlice(index * VkSparseImageMemoryBind.BYTES, VkSparseImageMemoryBind.BYTES));
        }

        public VkSparseImageMemoryBind.Ptr at(long index, @NotNull Consumer<@NotNull VkSparseImageMemoryBind> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkSparseImageMemoryBind value) {
            MemorySegment s = segment.asSlice(index * VkSparseImageMemoryBind.BYTES, VkSparseImageMemoryBind.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkSparseImageMemoryBind.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkSparseImageMemoryBind.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkSparseImageMemoryBind.BYTES,
                (end - start) * VkSparseImageMemoryBind.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkSparseImageMemoryBind.BYTES));
        }

        public VkSparseImageMemoryBind[] toArray() {
            VkSparseImageMemoryBind[] ret = new VkSparseImageMemoryBind[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkSparseImageMemoryBind> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkSparseImageMemoryBind> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkSparseImageMemoryBind.BYTES;
            }

            @Override
            public VkSparseImageMemoryBind next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkSparseImageMemoryBind ret = new VkSparseImageMemoryBind(segment.asSlice(0, VkSparseImageMemoryBind.BYTES));
                segment = segment.asSlice(VkSparseImageMemoryBind.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkSparseImageMemoryBind allocate(Arena arena) {
        return new VkSparseImageMemoryBind(arena.allocate(LAYOUT));
    }

    public static VkSparseImageMemoryBind.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkSparseImageMemoryBind.Ptr(segment);
    }

    public static VkSparseImageMemoryBind clone(Arena arena, VkSparseImageMemoryBind src) {
        VkSparseImageMemoryBind ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull VkImageSubresource subresource() {
        return new VkImageSubresource(segment.asSlice(OFFSET$subresource, LAYOUT$subresource));
    }

    public VkSparseImageMemoryBind subresource(@NotNull VkImageSubresource value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$subresource, SIZE$subresource);
        return this;
    }

    public VkSparseImageMemoryBind subresource(Consumer<@NotNull VkImageSubresource> consumer) {
        consumer.accept(subresource());
        return this;
    }

    public @NotNull VkOffset3D offset() {
        return new VkOffset3D(segment.asSlice(OFFSET$offset, LAYOUT$offset));
    }

    public VkSparseImageMemoryBind offset(@NotNull VkOffset3D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$offset, SIZE$offset);
        return this;
    }

    public VkSparseImageMemoryBind offset(Consumer<@NotNull VkOffset3D> consumer) {
        consumer.accept(offset());
        return this;
    }

    public @NotNull VkExtent3D extent() {
        return new VkExtent3D(segment.asSlice(OFFSET$extent, LAYOUT$extent));
    }

    public VkSparseImageMemoryBind extent(@NotNull VkExtent3D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$extent, SIZE$extent);
        return this;
    }

    public VkSparseImageMemoryBind extent(Consumer<@NotNull VkExtent3D> consumer) {
        consumer.accept(extent());
        return this;
    }

    public @Nullable VkDeviceMemory memory() {
        MemorySegment s = segment.asSlice(OFFSET$memory, SIZE$memory);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkDeviceMemory(s);
    }

    public VkSparseImageMemoryBind memory(@Nullable VkDeviceMemory value) {
        segment.set(LAYOUT$memory, OFFSET$memory, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long memoryOffset() {
        return segment.get(LAYOUT$memoryOffset, OFFSET$memoryOffset);
    }

    public VkSparseImageMemoryBind memoryOffset(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$memoryOffset, OFFSET$memoryOffset, value);
        return this;
    }

    public @Bitmask(VkSparseMemoryBindFlags.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkSparseImageMemoryBind flags(@Bitmask(VkSparseMemoryBindFlags.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        VkImageSubresource.LAYOUT.withName("subresource"),
        VkOffset3D.LAYOUT.withName("offset"),
        VkExtent3D.LAYOUT.withName("extent"),
        ValueLayout.ADDRESS.withName("memory"),
        ValueLayout.JAVA_LONG.withName("memoryOffset"),
        ValueLayout.JAVA_INT.withName("flags")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$subresource = PathElement.groupElement("subresource");
    public static final PathElement PATH$offset = PathElement.groupElement("offset");
    public static final PathElement PATH$extent = PathElement.groupElement("extent");
    public static final PathElement PATH$memory = PathElement.groupElement("memory");
    public static final PathElement PATH$memoryOffset = PathElement.groupElement("memoryOffset");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");

    public static final StructLayout LAYOUT$subresource = (StructLayout) LAYOUT.select(PATH$subresource);
    public static final StructLayout LAYOUT$offset = (StructLayout) LAYOUT.select(PATH$offset);
    public static final StructLayout LAYOUT$extent = (StructLayout) LAYOUT.select(PATH$extent);
    public static final AddressLayout LAYOUT$memory = (AddressLayout) LAYOUT.select(PATH$memory);
    public static final OfLong LAYOUT$memoryOffset = (OfLong) LAYOUT.select(PATH$memoryOffset);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);

    public static final long SIZE$subresource = LAYOUT$subresource.byteSize();
    public static final long SIZE$offset = LAYOUT$offset.byteSize();
    public static final long SIZE$extent = LAYOUT$extent.byteSize();
    public static final long SIZE$memory = LAYOUT$memory.byteSize();
    public static final long SIZE$memoryOffset = LAYOUT$memoryOffset.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();

    public static final long OFFSET$subresource = LAYOUT.byteOffset(PATH$subresource);
    public static final long OFFSET$offset = LAYOUT.byteOffset(PATH$offset);
    public static final long OFFSET$extent = LAYOUT.byteOffset(PATH$extent);
    public static final long OFFSET$memory = LAYOUT.byteOffset(PATH$memory);
    public static final long OFFSET$memoryOffset = LAYOUT.byteOffset(PATH$memoryOffset);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
}
