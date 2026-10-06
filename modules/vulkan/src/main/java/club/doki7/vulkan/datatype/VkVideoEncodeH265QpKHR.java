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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeH265QpKHR.html"><code>VkVideoEncodeH265QpKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkVideoEncodeH265QpKHR {
///     int32_t qpI; // @link substring="qpI" target="#qpI"
///     int32_t qpP; // @link substring="qpP" target="#qpP"
///     int32_t qpB; // @link substring="qpB" target="#qpB"
/// } VkVideoEncodeH265QpKHR;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeH265QpKHR.html"><code>VkVideoEncodeH265QpKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkVideoEncodeH265QpKHR(@NotNull MemorySegment segment) implements IVkVideoEncodeH265QpKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeH265QpKHR.html"><code>VkVideoEncodeH265QpKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkVideoEncodeH265QpKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkVideoEncodeH265QpKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkVideoEncodeH265QpKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkVideoEncodeH265QpKHR, Iterable<VkVideoEncodeH265QpKHR> {
        public long size() {
            return segment.byteSize() / VkVideoEncodeH265QpKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkVideoEncodeH265QpKHR at(long index) {
            return new VkVideoEncodeH265QpKHR(segment.asSlice(index * VkVideoEncodeH265QpKHR.BYTES, VkVideoEncodeH265QpKHR.BYTES));
        }

        public VkVideoEncodeH265QpKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkVideoEncodeH265QpKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkVideoEncodeH265QpKHR value) {
            MemorySegment s = segment.asSlice(index * VkVideoEncodeH265QpKHR.BYTES, VkVideoEncodeH265QpKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkVideoEncodeH265QpKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkVideoEncodeH265QpKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkVideoEncodeH265QpKHR.BYTES,
                (end - start) * VkVideoEncodeH265QpKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkVideoEncodeH265QpKHR.BYTES));
        }

        public VkVideoEncodeH265QpKHR[] toArray() {
            VkVideoEncodeH265QpKHR[] ret = new VkVideoEncodeH265QpKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkVideoEncodeH265QpKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkVideoEncodeH265QpKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkVideoEncodeH265QpKHR.BYTES;
            }

            @Override
            public VkVideoEncodeH265QpKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkVideoEncodeH265QpKHR ret = new VkVideoEncodeH265QpKHR(segment.asSlice(0, VkVideoEncodeH265QpKHR.BYTES));
                segment = segment.asSlice(VkVideoEncodeH265QpKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkVideoEncodeH265QpKHR allocate(Arena arena) {
        return new VkVideoEncodeH265QpKHR(arena.allocate(LAYOUT));
    }

    public static VkVideoEncodeH265QpKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkVideoEncodeH265QpKHR.Ptr(segment);
    }

    public static VkVideoEncodeH265QpKHR clone(Arena arena, VkVideoEncodeH265QpKHR src) {
        VkVideoEncodeH265QpKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public int qpI() {
        return segment.get(LAYOUT$qpI, OFFSET$qpI);
    }

    public VkVideoEncodeH265QpKHR qpI(int value) {
        segment.set(LAYOUT$qpI, OFFSET$qpI, value);
        return this;
    }

    public int qpP() {
        return segment.get(LAYOUT$qpP, OFFSET$qpP);
    }

    public VkVideoEncodeH265QpKHR qpP(int value) {
        segment.set(LAYOUT$qpP, OFFSET$qpP, value);
        return this;
    }

    public int qpB() {
        return segment.get(LAYOUT$qpB, OFFSET$qpB);
    }

    public VkVideoEncodeH265QpKHR qpB(int value) {
        segment.set(LAYOUT$qpB, OFFSET$qpB, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("qpI"),
        ValueLayout.JAVA_INT.withName("qpP"),
        ValueLayout.JAVA_INT.withName("qpB")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$qpI = PathElement.groupElement("qpI");
    public static final PathElement PATH$qpP = PathElement.groupElement("qpP");
    public static final PathElement PATH$qpB = PathElement.groupElement("qpB");

    public static final OfInt LAYOUT$qpI = (OfInt) LAYOUT.select(PATH$qpI);
    public static final OfInt LAYOUT$qpP = (OfInt) LAYOUT.select(PATH$qpP);
    public static final OfInt LAYOUT$qpB = (OfInt) LAYOUT.select(PATH$qpB);

    public static final long SIZE$qpI = LAYOUT$qpI.byteSize();
    public static final long SIZE$qpP = LAYOUT$qpP.byteSize();
    public static final long SIZE$qpB = LAYOUT$qpB.byteSize();

    public static final long OFFSET$qpI = LAYOUT.byteOffset(PATH$qpI);
    public static final long OFFSET$qpP = LAYOUT.byteOffset(PATH$qpP);
    public static final long OFFSET$qpB = LAYOUT.byteOffset(PATH$qpB);
}
