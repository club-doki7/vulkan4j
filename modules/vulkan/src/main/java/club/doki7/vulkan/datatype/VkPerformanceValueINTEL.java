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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPerformanceValueINTEL.html"><code>VkPerformanceValueINTEL</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPerformanceValueINTEL {
///     VkPerformanceValueTypeINTEL type; // @link substring="VkPerformanceValueTypeINTEL" target="VkPerformanceValueTypeINTEL" @link substring="type" target="#type"
///     VkPerformanceValueDataINTEL data; // @link substring="VkPerformanceValueDataINTEL" target="VkPerformanceValueDataINTEL" @link substring="data" target="#data"
/// } VkPerformanceValueINTEL;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPerformanceValueINTEL.html"><code>VkPerformanceValueINTEL</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPerformanceValueINTEL(@NotNull MemorySegment segment) implements IVkPerformanceValueINTEL {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPerformanceValueINTEL.html"><code>VkPerformanceValueINTEL</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPerformanceValueINTEL}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPerformanceValueINTEL to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPerformanceValueINTEL.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPerformanceValueINTEL, Iterable<VkPerformanceValueINTEL> {
        public long size() {
            return segment.byteSize() / VkPerformanceValueINTEL.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPerformanceValueINTEL at(long index) {
            return new VkPerformanceValueINTEL(segment.asSlice(index * VkPerformanceValueINTEL.BYTES, VkPerformanceValueINTEL.BYTES));
        }

        public VkPerformanceValueINTEL.Ptr at(long index, @NotNull Consumer<@NotNull VkPerformanceValueINTEL> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPerformanceValueINTEL value) {
            MemorySegment s = segment.asSlice(index * VkPerformanceValueINTEL.BYTES, VkPerformanceValueINTEL.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPerformanceValueINTEL.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPerformanceValueINTEL.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPerformanceValueINTEL.BYTES,
                (end - start) * VkPerformanceValueINTEL.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPerformanceValueINTEL.BYTES));
        }

        public VkPerformanceValueINTEL[] toArray() {
            VkPerformanceValueINTEL[] ret = new VkPerformanceValueINTEL[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPerformanceValueINTEL> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPerformanceValueINTEL> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPerformanceValueINTEL.BYTES;
            }

            @Override
            public VkPerformanceValueINTEL next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPerformanceValueINTEL ret = new VkPerformanceValueINTEL(segment.asSlice(0, VkPerformanceValueINTEL.BYTES));
                segment = segment.asSlice(VkPerformanceValueINTEL.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPerformanceValueINTEL allocate(Arena arena) {
        return new VkPerformanceValueINTEL(arena.allocate(LAYOUT));
    }

    public static VkPerformanceValueINTEL.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkPerformanceValueINTEL.Ptr(segment);
    }

    public static VkPerformanceValueINTEL clone(Arena arena, VkPerformanceValueINTEL src) {
        VkPerformanceValueINTEL ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @EnumType(VkPerformanceValueTypeINTEL.class) int type() {
        return segment.get(LAYOUT$type, OFFSET$type);
    }

    public VkPerformanceValueINTEL type(@EnumType(VkPerformanceValueTypeINTEL.class) int value) {
        segment.set(LAYOUT$type, OFFSET$type, value);
        return this;
    }

    public @NotNull VkPerformanceValueDataINTEL data() {
        return new VkPerformanceValueDataINTEL(segment.asSlice(OFFSET$data, LAYOUT$data));
    }

    public VkPerformanceValueINTEL data(@NotNull VkPerformanceValueDataINTEL value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$data, SIZE$data);
        return this;
    }

    public VkPerformanceValueINTEL data(Consumer<@NotNull VkPerformanceValueDataINTEL> consumer) {
        consumer.accept(data());
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("type"),
        VkPerformanceValueDataINTEL.LAYOUT.withName("data")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$type = PathElement.groupElement("type");
    public static final PathElement PATH$data = PathElement.groupElement("data");

    public static final OfInt LAYOUT$type = (OfInt) LAYOUT.select(PATH$type);
    public static final UnionLayout LAYOUT$data = (UnionLayout) LAYOUT.select(PATH$data);

    public static final long SIZE$type = LAYOUT$type.byteSize();
    public static final long SIZE$data = LAYOUT$data.byteSize();

    public static final long OFFSET$type = LAYOUT.byteOffset(PATH$type);
    public static final long OFFSET$data = LAYOUT.byteOffset(PATH$data);
}
