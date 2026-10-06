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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageSubresourceRange.html"><code>VkImageSubresourceRange</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkImageSubresourceRange {
///     VkImageAspectFlags aspectMask; // @link substring="VkImageAspectFlags" target="VkImageAspectFlags" @link substring="aspectMask" target="#aspectMask"
///     uint32_t baseMipLevel; // @link substring="baseMipLevel" target="#baseMipLevel"
///     uint32_t levelCount; // @link substring="levelCount" target="#levelCount"
///     uint32_t baseArrayLayer; // @link substring="baseArrayLayer" target="#baseArrayLayer"
///     uint32_t layerCount; // @link substring="layerCount" target="#layerCount"
/// } VkImageSubresourceRange;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageSubresourceRange.html"><code>VkImageSubresourceRange</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkImageSubresourceRange(@NotNull MemorySegment segment) implements IVkImageSubresourceRange {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageSubresourceRange.html"><code>VkImageSubresourceRange</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkImageSubresourceRange}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkImageSubresourceRange to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkImageSubresourceRange.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkImageSubresourceRange, Iterable<VkImageSubresourceRange> {
        public long size() {
            return segment.byteSize() / VkImageSubresourceRange.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkImageSubresourceRange at(long index) {
            return new VkImageSubresourceRange(segment.asSlice(index * VkImageSubresourceRange.BYTES, VkImageSubresourceRange.BYTES));
        }

        public VkImageSubresourceRange.Ptr at(long index, @NotNull Consumer<@NotNull VkImageSubresourceRange> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkImageSubresourceRange value) {
            MemorySegment s = segment.asSlice(index * VkImageSubresourceRange.BYTES, VkImageSubresourceRange.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkImageSubresourceRange.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkImageSubresourceRange.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkImageSubresourceRange.BYTES,
                (end - start) * VkImageSubresourceRange.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkImageSubresourceRange.BYTES));
        }

        public VkImageSubresourceRange[] toArray() {
            VkImageSubresourceRange[] ret = new VkImageSubresourceRange[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkImageSubresourceRange> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkImageSubresourceRange> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkImageSubresourceRange.BYTES;
            }

            @Override
            public VkImageSubresourceRange next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkImageSubresourceRange ret = new VkImageSubresourceRange(segment.asSlice(0, VkImageSubresourceRange.BYTES));
                segment = segment.asSlice(VkImageSubresourceRange.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkImageSubresourceRange allocate(Arena arena) {
        return new VkImageSubresourceRange(arena.allocate(LAYOUT));
    }

    public static VkImageSubresourceRange.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkImageSubresourceRange.Ptr(segment);
    }

    public static VkImageSubresourceRange clone(Arena arena, VkImageSubresourceRange src) {
        VkImageSubresourceRange ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Bitmask(VkImageAspectFlags.class) int aspectMask() {
        return segment.get(LAYOUT$aspectMask, OFFSET$aspectMask);
    }

    public VkImageSubresourceRange aspectMask(@Bitmask(VkImageAspectFlags.class) int value) {
        segment.set(LAYOUT$aspectMask, OFFSET$aspectMask, value);
        return this;
    }

    public @Unsigned int baseMipLevel() {
        return segment.get(LAYOUT$baseMipLevel, OFFSET$baseMipLevel);
    }

    public VkImageSubresourceRange baseMipLevel(@Unsigned int value) {
        segment.set(LAYOUT$baseMipLevel, OFFSET$baseMipLevel, value);
        return this;
    }

    public @Unsigned int levelCount() {
        return segment.get(LAYOUT$levelCount, OFFSET$levelCount);
    }

    public VkImageSubresourceRange levelCount(@Unsigned int value) {
        segment.set(LAYOUT$levelCount, OFFSET$levelCount, value);
        return this;
    }

    public @Unsigned int baseArrayLayer() {
        return segment.get(LAYOUT$baseArrayLayer, OFFSET$baseArrayLayer);
    }

    public VkImageSubresourceRange baseArrayLayer(@Unsigned int value) {
        segment.set(LAYOUT$baseArrayLayer, OFFSET$baseArrayLayer, value);
        return this;
    }

    public @Unsigned int layerCount() {
        return segment.get(LAYOUT$layerCount, OFFSET$layerCount);
    }

    public VkImageSubresourceRange layerCount(@Unsigned int value) {
        segment.set(LAYOUT$layerCount, OFFSET$layerCount, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("aspectMask"),
        ValueLayout.JAVA_INT.withName("baseMipLevel"),
        ValueLayout.JAVA_INT.withName("levelCount"),
        ValueLayout.JAVA_INT.withName("baseArrayLayer"),
        ValueLayout.JAVA_INT.withName("layerCount")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$aspectMask = PathElement.groupElement("aspectMask");
    public static final PathElement PATH$baseMipLevel = PathElement.groupElement("baseMipLevel");
    public static final PathElement PATH$levelCount = PathElement.groupElement("levelCount");
    public static final PathElement PATH$baseArrayLayer = PathElement.groupElement("baseArrayLayer");
    public static final PathElement PATH$layerCount = PathElement.groupElement("layerCount");

    public static final OfInt LAYOUT$aspectMask = (OfInt) LAYOUT.select(PATH$aspectMask);
    public static final OfInt LAYOUT$baseMipLevel = (OfInt) LAYOUT.select(PATH$baseMipLevel);
    public static final OfInt LAYOUT$levelCount = (OfInt) LAYOUT.select(PATH$levelCount);
    public static final OfInt LAYOUT$baseArrayLayer = (OfInt) LAYOUT.select(PATH$baseArrayLayer);
    public static final OfInt LAYOUT$layerCount = (OfInt) LAYOUT.select(PATH$layerCount);

    public static final long SIZE$aspectMask = LAYOUT$aspectMask.byteSize();
    public static final long SIZE$baseMipLevel = LAYOUT$baseMipLevel.byteSize();
    public static final long SIZE$levelCount = LAYOUT$levelCount.byteSize();
    public static final long SIZE$baseArrayLayer = LAYOUT$baseArrayLayer.byteSize();
    public static final long SIZE$layerCount = LAYOUT$layerCount.byteSize();

    public static final long OFFSET$aspectMask = LAYOUT.byteOffset(PATH$aspectMask);
    public static final long OFFSET$baseMipLevel = LAYOUT.byteOffset(PATH$baseMipLevel);
    public static final long OFFSET$levelCount = LAYOUT.byteOffset(PATH$levelCount);
    public static final long OFFSET$baseArrayLayer = LAYOUT.byteOffset(PATH$baseArrayLayer);
    public static final long OFFSET$layerCount = LAYOUT.byteOffset(PATH$layerCount);
}
