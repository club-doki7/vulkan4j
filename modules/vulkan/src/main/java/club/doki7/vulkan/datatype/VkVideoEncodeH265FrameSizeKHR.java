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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeH265FrameSizeKHR.html"><code>VkVideoEncodeH265FrameSizeKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkVideoEncodeH265FrameSizeKHR {
///     uint32_t frameISize; // @link substring="frameISize" target="#frameISize"
///     uint32_t framePSize; // @link substring="framePSize" target="#framePSize"
///     uint32_t frameBSize; // @link substring="frameBSize" target="#frameBSize"
/// } VkVideoEncodeH265FrameSizeKHR;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeH265FrameSizeKHR.html"><code>VkVideoEncodeH265FrameSizeKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkVideoEncodeH265FrameSizeKHR(@NotNull MemorySegment segment) implements IVkVideoEncodeH265FrameSizeKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeH265FrameSizeKHR.html"><code>VkVideoEncodeH265FrameSizeKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkVideoEncodeH265FrameSizeKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkVideoEncodeH265FrameSizeKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkVideoEncodeH265FrameSizeKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkVideoEncodeH265FrameSizeKHR, Iterable<VkVideoEncodeH265FrameSizeKHR> {
        public long size() {
            return segment.byteSize() / VkVideoEncodeH265FrameSizeKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkVideoEncodeH265FrameSizeKHR at(long index) {
            return new VkVideoEncodeH265FrameSizeKHR(segment.asSlice(index * VkVideoEncodeH265FrameSizeKHR.BYTES, VkVideoEncodeH265FrameSizeKHR.BYTES));
        }

        public VkVideoEncodeH265FrameSizeKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkVideoEncodeH265FrameSizeKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkVideoEncodeH265FrameSizeKHR value) {
            MemorySegment s = segment.asSlice(index * VkVideoEncodeH265FrameSizeKHR.BYTES, VkVideoEncodeH265FrameSizeKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkVideoEncodeH265FrameSizeKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkVideoEncodeH265FrameSizeKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkVideoEncodeH265FrameSizeKHR.BYTES,
                (end - start) * VkVideoEncodeH265FrameSizeKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkVideoEncodeH265FrameSizeKHR.BYTES));
        }

        public VkVideoEncodeH265FrameSizeKHR[] toArray() {
            VkVideoEncodeH265FrameSizeKHR[] ret = new VkVideoEncodeH265FrameSizeKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkVideoEncodeH265FrameSizeKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkVideoEncodeH265FrameSizeKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkVideoEncodeH265FrameSizeKHR.BYTES;
            }

            @Override
            public VkVideoEncodeH265FrameSizeKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkVideoEncodeH265FrameSizeKHR ret = new VkVideoEncodeH265FrameSizeKHR(segment.asSlice(0, VkVideoEncodeH265FrameSizeKHR.BYTES));
                segment = segment.asSlice(VkVideoEncodeH265FrameSizeKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkVideoEncodeH265FrameSizeKHR allocate(Arena arena) {
        return new VkVideoEncodeH265FrameSizeKHR(arena.allocate(LAYOUT));
    }

    public static VkVideoEncodeH265FrameSizeKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkVideoEncodeH265FrameSizeKHR.Ptr(segment);
    }

    public static VkVideoEncodeH265FrameSizeKHR clone(Arena arena, VkVideoEncodeH265FrameSizeKHR src) {
        VkVideoEncodeH265FrameSizeKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned int frameISize() {
        return segment.get(LAYOUT$frameISize, OFFSET$frameISize);
    }

    public VkVideoEncodeH265FrameSizeKHR frameISize(@Unsigned int value) {
        segment.set(LAYOUT$frameISize, OFFSET$frameISize, value);
        return this;
    }

    public @Unsigned int framePSize() {
        return segment.get(LAYOUT$framePSize, OFFSET$framePSize);
    }

    public VkVideoEncodeH265FrameSizeKHR framePSize(@Unsigned int value) {
        segment.set(LAYOUT$framePSize, OFFSET$framePSize, value);
        return this;
    }

    public @Unsigned int frameBSize() {
        return segment.get(LAYOUT$frameBSize, OFFSET$frameBSize);
    }

    public VkVideoEncodeH265FrameSizeKHR frameBSize(@Unsigned int value) {
        segment.set(LAYOUT$frameBSize, OFFSET$frameBSize, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("frameISize"),
        ValueLayout.JAVA_INT.withName("framePSize"),
        ValueLayout.JAVA_INT.withName("frameBSize")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$frameISize = PathElement.groupElement("frameISize");
    public static final PathElement PATH$framePSize = PathElement.groupElement("framePSize");
    public static final PathElement PATH$frameBSize = PathElement.groupElement("frameBSize");

    public static final OfInt LAYOUT$frameISize = (OfInt) LAYOUT.select(PATH$frameISize);
    public static final OfInt LAYOUT$framePSize = (OfInt) LAYOUT.select(PATH$framePSize);
    public static final OfInt LAYOUT$frameBSize = (OfInt) LAYOUT.select(PATH$frameBSize);

    public static final long SIZE$frameISize = LAYOUT$frameISize.byteSize();
    public static final long SIZE$framePSize = LAYOUT$framePSize.byteSize();
    public static final long SIZE$frameBSize = LAYOUT$frameBSize.byteSize();

    public static final long OFFSET$frameISize = LAYOUT.byteOffset(PATH$frameISize);
    public static final long OFFSET$framePSize = LAYOUT.byteOffset(PATH$framePSize);
    public static final long OFFSET$frameBSize = LAYOUT.byteOffset(PATH$frameBSize);
}
