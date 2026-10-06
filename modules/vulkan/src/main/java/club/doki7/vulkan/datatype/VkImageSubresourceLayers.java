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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageSubresourceLayers.html"><code>VkImageSubresourceLayers</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkImageSubresourceLayers {
///     VkImageAspectFlags aspectMask; // @link substring="VkImageAspectFlags" target="VkImageAspectFlags" @link substring="aspectMask" target="#aspectMask"
///     uint32_t mipLevel; // @link substring="mipLevel" target="#mipLevel"
///     uint32_t baseArrayLayer; // @link substring="baseArrayLayer" target="#baseArrayLayer"
///     uint32_t layerCount; // @link substring="layerCount" target="#layerCount"
/// } VkImageSubresourceLayers;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageSubresourceLayers.html"><code>VkImageSubresourceLayers</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkImageSubresourceLayers(@NotNull MemorySegment segment) implements IVkImageSubresourceLayers {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageSubresourceLayers.html"><code>VkImageSubresourceLayers</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkImageSubresourceLayers}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkImageSubresourceLayers to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkImageSubresourceLayers.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkImageSubresourceLayers, Iterable<VkImageSubresourceLayers> {
        public long size() {
            return segment.byteSize() / VkImageSubresourceLayers.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkImageSubresourceLayers at(long index) {
            return new VkImageSubresourceLayers(segment.asSlice(index * VkImageSubresourceLayers.BYTES, VkImageSubresourceLayers.BYTES));
        }

        public VkImageSubresourceLayers.Ptr at(long index, @NotNull Consumer<@NotNull VkImageSubresourceLayers> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkImageSubresourceLayers value) {
            MemorySegment s = segment.asSlice(index * VkImageSubresourceLayers.BYTES, VkImageSubresourceLayers.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkImageSubresourceLayers.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkImageSubresourceLayers.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkImageSubresourceLayers.BYTES,
                (end - start) * VkImageSubresourceLayers.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkImageSubresourceLayers.BYTES));
        }

        public VkImageSubresourceLayers[] toArray() {
            VkImageSubresourceLayers[] ret = new VkImageSubresourceLayers[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkImageSubresourceLayers> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkImageSubresourceLayers> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkImageSubresourceLayers.BYTES;
            }

            @Override
            public VkImageSubresourceLayers next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkImageSubresourceLayers ret = new VkImageSubresourceLayers(segment.asSlice(0, VkImageSubresourceLayers.BYTES));
                segment = segment.asSlice(VkImageSubresourceLayers.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkImageSubresourceLayers allocate(Arena arena) {
        return new VkImageSubresourceLayers(arena.allocate(LAYOUT));
    }

    public static VkImageSubresourceLayers.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkImageSubresourceLayers.Ptr(segment);
    }

    public static VkImageSubresourceLayers clone(Arena arena, VkImageSubresourceLayers src) {
        VkImageSubresourceLayers ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Bitmask(VkImageAspectFlags.class) int aspectMask() {
        return segment.get(LAYOUT$aspectMask, OFFSET$aspectMask);
    }

    public VkImageSubresourceLayers aspectMask(@Bitmask(VkImageAspectFlags.class) int value) {
        segment.set(LAYOUT$aspectMask, OFFSET$aspectMask, value);
        return this;
    }

    public @Unsigned int mipLevel() {
        return segment.get(LAYOUT$mipLevel, OFFSET$mipLevel);
    }

    public VkImageSubresourceLayers mipLevel(@Unsigned int value) {
        segment.set(LAYOUT$mipLevel, OFFSET$mipLevel, value);
        return this;
    }

    public @Unsigned int baseArrayLayer() {
        return segment.get(LAYOUT$baseArrayLayer, OFFSET$baseArrayLayer);
    }

    public VkImageSubresourceLayers baseArrayLayer(@Unsigned int value) {
        segment.set(LAYOUT$baseArrayLayer, OFFSET$baseArrayLayer, value);
        return this;
    }

    public @Unsigned int layerCount() {
        return segment.get(LAYOUT$layerCount, OFFSET$layerCount);
    }

    public VkImageSubresourceLayers layerCount(@Unsigned int value) {
        segment.set(LAYOUT$layerCount, OFFSET$layerCount, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("aspectMask"),
        ValueLayout.JAVA_INT.withName("mipLevel"),
        ValueLayout.JAVA_INT.withName("baseArrayLayer"),
        ValueLayout.JAVA_INT.withName("layerCount")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$aspectMask = PathElement.groupElement("aspectMask");
    public static final PathElement PATH$mipLevel = PathElement.groupElement("mipLevel");
    public static final PathElement PATH$baseArrayLayer = PathElement.groupElement("baseArrayLayer");
    public static final PathElement PATH$layerCount = PathElement.groupElement("layerCount");

    public static final OfInt LAYOUT$aspectMask = (OfInt) LAYOUT.select(PATH$aspectMask);
    public static final OfInt LAYOUT$mipLevel = (OfInt) LAYOUT.select(PATH$mipLevel);
    public static final OfInt LAYOUT$baseArrayLayer = (OfInt) LAYOUT.select(PATH$baseArrayLayer);
    public static final OfInt LAYOUT$layerCount = (OfInt) LAYOUT.select(PATH$layerCount);

    public static final long SIZE$aspectMask = LAYOUT$aspectMask.byteSize();
    public static final long SIZE$mipLevel = LAYOUT$mipLevel.byteSize();
    public static final long SIZE$baseArrayLayer = LAYOUT$baseArrayLayer.byteSize();
    public static final long SIZE$layerCount = LAYOUT$layerCount.byteSize();

    public static final long OFFSET$aspectMask = LAYOUT.byteOffset(PATH$aspectMask);
    public static final long OFFSET$mipLevel = LAYOUT.byteOffset(PATH$mipLevel);
    public static final long OFFSET$baseArrayLayer = LAYOUT.byteOffset(PATH$baseArrayLayer);
    public static final long OFFSET$layerCount = LAYOUT.byteOffset(PATH$layerCount);
}
