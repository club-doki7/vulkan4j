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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSparseImageFormatProperties.html"><code>VkSparseImageFormatProperties</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkSparseImageFormatProperties {
///     VkImageAspectFlags aspectMask; // optional // @link substring="VkImageAspectFlags" target="VkImageAspectFlags" @link substring="aspectMask" target="#aspectMask"
///     VkExtent3D imageGranularity; // @link substring="VkExtent3D" target="VkExtent3D" @link substring="imageGranularity" target="#imageGranularity"
///     VkSparseImageFormatFlags flags; // optional // @link substring="VkSparseImageFormatFlags" target="VkSparseImageFormatFlags" @link substring="flags" target="#flags"
/// } VkSparseImageFormatProperties;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSparseImageFormatProperties.html"><code>VkSparseImageFormatProperties</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkSparseImageFormatProperties(@NotNull MemorySegment segment) implements IVkSparseImageFormatProperties {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSparseImageFormatProperties.html"><code>VkSparseImageFormatProperties</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkSparseImageFormatProperties}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkSparseImageFormatProperties to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkSparseImageFormatProperties.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkSparseImageFormatProperties, Iterable<VkSparseImageFormatProperties> {
        public long size() {
            return segment.byteSize() / VkSparseImageFormatProperties.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkSparseImageFormatProperties at(long index) {
            return new VkSparseImageFormatProperties(segment.asSlice(index * VkSparseImageFormatProperties.BYTES, VkSparseImageFormatProperties.BYTES));
        }

        public VkSparseImageFormatProperties.Ptr at(long index, @NotNull Consumer<@NotNull VkSparseImageFormatProperties> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkSparseImageFormatProperties value) {
            MemorySegment s = segment.asSlice(index * VkSparseImageFormatProperties.BYTES, VkSparseImageFormatProperties.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkSparseImageFormatProperties.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkSparseImageFormatProperties.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkSparseImageFormatProperties.BYTES,
                (end - start) * VkSparseImageFormatProperties.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkSparseImageFormatProperties.BYTES));
        }

        public VkSparseImageFormatProperties[] toArray() {
            VkSparseImageFormatProperties[] ret = new VkSparseImageFormatProperties[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkSparseImageFormatProperties> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkSparseImageFormatProperties> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkSparseImageFormatProperties.BYTES;
            }

            @Override
            public VkSparseImageFormatProperties next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkSparseImageFormatProperties ret = new VkSparseImageFormatProperties(segment.asSlice(0, VkSparseImageFormatProperties.BYTES));
                segment = segment.asSlice(VkSparseImageFormatProperties.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkSparseImageFormatProperties allocate(Arena arena) {
        return new VkSparseImageFormatProperties(arena.allocate(LAYOUT));
    }

    public static VkSparseImageFormatProperties.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkSparseImageFormatProperties.Ptr(segment);
    }

    public static VkSparseImageFormatProperties clone(Arena arena, VkSparseImageFormatProperties src) {
        VkSparseImageFormatProperties ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Bitmask(VkImageAspectFlags.class) int aspectMask() {
        return segment.get(LAYOUT$aspectMask, OFFSET$aspectMask);
    }

    public VkSparseImageFormatProperties aspectMask(@Bitmask(VkImageAspectFlags.class) int value) {
        segment.set(LAYOUT$aspectMask, OFFSET$aspectMask, value);
        return this;
    }

    public @NotNull VkExtent3D imageGranularity() {
        return new VkExtent3D(segment.asSlice(OFFSET$imageGranularity, LAYOUT$imageGranularity));
    }

    public VkSparseImageFormatProperties imageGranularity(@NotNull VkExtent3D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$imageGranularity, SIZE$imageGranularity);
        return this;
    }

    public VkSparseImageFormatProperties imageGranularity(Consumer<@NotNull VkExtent3D> consumer) {
        consumer.accept(imageGranularity());
        return this;
    }

    public @Bitmask(VkSparseImageFormatFlags.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkSparseImageFormatProperties flags(@Bitmask(VkSparseImageFormatFlags.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("aspectMask"),
        VkExtent3D.LAYOUT.withName("imageGranularity"),
        ValueLayout.JAVA_INT.withName("flags")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$aspectMask = PathElement.groupElement("aspectMask");
    public static final PathElement PATH$imageGranularity = PathElement.groupElement("imageGranularity");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");

    public static final OfInt LAYOUT$aspectMask = (OfInt) LAYOUT.select(PATH$aspectMask);
    public static final StructLayout LAYOUT$imageGranularity = (StructLayout) LAYOUT.select(PATH$imageGranularity);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);

    public static final long SIZE$aspectMask = LAYOUT$aspectMask.byteSize();
    public static final long SIZE$imageGranularity = LAYOUT$imageGranularity.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();

    public static final long OFFSET$aspectMask = LAYOUT.byteOffset(PATH$aspectMask);
    public static final long OFFSET$imageGranularity = LAYOUT.byteOffset(PATH$imageGranularity);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
}
