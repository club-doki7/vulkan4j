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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkClearAttachment.html"><code>VkClearAttachment</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkClearAttachment {
///     VkImageAspectFlags aspectMask; // @link substring="VkImageAspectFlags" target="VkImageAspectFlags" @link substring="aspectMask" target="#aspectMask"
///     uint32_t colorAttachment; // @link substring="colorAttachment" target="#colorAttachment"
///     VkClearValue clearValue; // @link substring="VkClearValue" target="VkClearValue" @link substring="clearValue" target="#clearValue"
/// } VkClearAttachment;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkClearAttachment.html"><code>VkClearAttachment</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkClearAttachment(@NotNull MemorySegment segment) implements IVkClearAttachment {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkClearAttachment.html"><code>VkClearAttachment</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkClearAttachment}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkClearAttachment to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkClearAttachment.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkClearAttachment, Iterable<VkClearAttachment> {
        public long size() {
            return segment.byteSize() / VkClearAttachment.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkClearAttachment at(long index) {
            return new VkClearAttachment(segment.asSlice(index * VkClearAttachment.BYTES, VkClearAttachment.BYTES));
        }

        public VkClearAttachment.Ptr at(long index, @NotNull Consumer<@NotNull VkClearAttachment> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkClearAttachment value) {
            MemorySegment s = segment.asSlice(index * VkClearAttachment.BYTES, VkClearAttachment.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkClearAttachment.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkClearAttachment.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkClearAttachment.BYTES,
                (end - start) * VkClearAttachment.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkClearAttachment.BYTES));
        }

        public VkClearAttachment[] toArray() {
            VkClearAttachment[] ret = new VkClearAttachment[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkClearAttachment> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkClearAttachment> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkClearAttachment.BYTES;
            }

            @Override
            public VkClearAttachment next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkClearAttachment ret = new VkClearAttachment(segment.asSlice(0, VkClearAttachment.BYTES));
                segment = segment.asSlice(VkClearAttachment.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkClearAttachment allocate(Arena arena) {
        return new VkClearAttachment(arena.allocate(LAYOUT));
    }

    public static VkClearAttachment.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkClearAttachment.Ptr(segment);
    }

    public static VkClearAttachment clone(Arena arena, VkClearAttachment src) {
        VkClearAttachment ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Bitmask(VkImageAspectFlags.class) int aspectMask() {
        return segment.get(LAYOUT$aspectMask, OFFSET$aspectMask);
    }

    public VkClearAttachment aspectMask(@Bitmask(VkImageAspectFlags.class) int value) {
        segment.set(LAYOUT$aspectMask, OFFSET$aspectMask, value);
        return this;
    }

    public @Unsigned int colorAttachment() {
        return segment.get(LAYOUT$colorAttachment, OFFSET$colorAttachment);
    }

    public VkClearAttachment colorAttachment(@Unsigned int value) {
        segment.set(LAYOUT$colorAttachment, OFFSET$colorAttachment, value);
        return this;
    }

    public @NotNull VkClearValue clearValue() {
        return new VkClearValue(segment.asSlice(OFFSET$clearValue, LAYOUT$clearValue));
    }

    public VkClearAttachment clearValue(@NotNull VkClearValue value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$clearValue, SIZE$clearValue);
        return this;
    }

    public VkClearAttachment clearValue(Consumer<@NotNull VkClearValue> consumer) {
        consumer.accept(clearValue());
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("aspectMask"),
        ValueLayout.JAVA_INT.withName("colorAttachment"),
        VkClearValue.LAYOUT.withName("clearValue")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$aspectMask = PathElement.groupElement("aspectMask");
    public static final PathElement PATH$colorAttachment = PathElement.groupElement("colorAttachment");
    public static final PathElement PATH$clearValue = PathElement.groupElement("clearValue");

    public static final OfInt LAYOUT$aspectMask = (OfInt) LAYOUT.select(PATH$aspectMask);
    public static final OfInt LAYOUT$colorAttachment = (OfInt) LAYOUT.select(PATH$colorAttachment);
    public static final UnionLayout LAYOUT$clearValue = (UnionLayout) LAYOUT.select(PATH$clearValue);

    public static final long SIZE$aspectMask = LAYOUT$aspectMask.byteSize();
    public static final long SIZE$colorAttachment = LAYOUT$colorAttachment.byteSize();
    public static final long SIZE$clearValue = LAYOUT$clearValue.byteSize();

    public static final long OFFSET$aspectMask = LAYOUT.byteOffset(PATH$aspectMask);
    public static final long OFFSET$colorAttachment = LAYOUT.byteOffset(PATH$colorAttachment);
    public static final long OFFSET$clearValue = LAYOUT.byteOffset(PATH$clearValue);
}
