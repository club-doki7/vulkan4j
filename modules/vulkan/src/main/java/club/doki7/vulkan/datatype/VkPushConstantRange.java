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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPushConstantRange.html"><code>VkPushConstantRange</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPushConstantRange {
///     VkShaderStageFlags stageFlags; // @link substring="VkShaderStageFlags" target="VkShaderStageFlags" @link substring="stageFlags" target="#stageFlags"
///     uint32_t offset; // @link substring="offset" target="#offset"
///     uint32_t size; // @link substring="size" target="#size"
/// } VkPushConstantRange;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPushConstantRange.html"><code>VkPushConstantRange</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPushConstantRange(@NotNull MemorySegment segment) implements IVkPushConstantRange {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPushConstantRange.html"><code>VkPushConstantRange</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPushConstantRange}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPushConstantRange to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPushConstantRange.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPushConstantRange, Iterable<VkPushConstantRange> {
        public long size() {
            return segment.byteSize() / VkPushConstantRange.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPushConstantRange at(long index) {
            return new VkPushConstantRange(segment.asSlice(index * VkPushConstantRange.BYTES, VkPushConstantRange.BYTES));
        }

        public VkPushConstantRange.Ptr at(long index, @NotNull Consumer<@NotNull VkPushConstantRange> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPushConstantRange value) {
            MemorySegment s = segment.asSlice(index * VkPushConstantRange.BYTES, VkPushConstantRange.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPushConstantRange.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPushConstantRange.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPushConstantRange.BYTES,
                (end - start) * VkPushConstantRange.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPushConstantRange.BYTES));
        }

        public VkPushConstantRange[] toArray() {
            VkPushConstantRange[] ret = new VkPushConstantRange[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPushConstantRange> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPushConstantRange> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPushConstantRange.BYTES;
            }

            @Override
            public VkPushConstantRange next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPushConstantRange ret = new VkPushConstantRange(segment.asSlice(0, VkPushConstantRange.BYTES));
                segment = segment.asSlice(VkPushConstantRange.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPushConstantRange allocate(Arena arena) {
        return new VkPushConstantRange(arena.allocate(LAYOUT));
    }

    public static VkPushConstantRange.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkPushConstantRange.Ptr(segment);
    }

    public static VkPushConstantRange clone(Arena arena, VkPushConstantRange src) {
        VkPushConstantRange ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Bitmask(VkShaderStageFlags.class) int stageFlags() {
        return segment.get(LAYOUT$stageFlags, OFFSET$stageFlags);
    }

    public VkPushConstantRange stageFlags(@Bitmask(VkShaderStageFlags.class) int value) {
        segment.set(LAYOUT$stageFlags, OFFSET$stageFlags, value);
        return this;
    }

    public @Unsigned int offset() {
        return segment.get(LAYOUT$offset, OFFSET$offset);
    }

    public VkPushConstantRange offset(@Unsigned int value) {
        segment.set(LAYOUT$offset, OFFSET$offset, value);
        return this;
    }

    public @Unsigned int size() {
        return segment.get(LAYOUT$size, OFFSET$size);
    }

    public VkPushConstantRange size(@Unsigned int value) {
        segment.set(LAYOUT$size, OFFSET$size, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("stageFlags"),
        ValueLayout.JAVA_INT.withName("offset"),
        ValueLayout.JAVA_INT.withName("size")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$stageFlags = PathElement.groupElement("stageFlags");
    public static final PathElement PATH$offset = PathElement.groupElement("offset");
    public static final PathElement PATH$size = PathElement.groupElement("size");

    public static final OfInt LAYOUT$stageFlags = (OfInt) LAYOUT.select(PATH$stageFlags);
    public static final OfInt LAYOUT$offset = (OfInt) LAYOUT.select(PATH$offset);
    public static final OfInt LAYOUT$size = (OfInt) LAYOUT.select(PATH$size);

    public static final long SIZE$stageFlags = LAYOUT$stageFlags.byteSize();
    public static final long SIZE$offset = LAYOUT$offset.byteSize();
    public static final long SIZE$size = LAYOUT$size.byteSize();

    public static final long OFFSET$stageFlags = LAYOUT.byteOffset(PATH$stageFlags);
    public static final long OFFSET$offset = LAYOUT.byteOffset(PATH$offset);
    public static final long OFFSET$size = LAYOUT.byteOffset(PATH$size);
}
