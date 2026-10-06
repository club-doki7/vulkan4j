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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkViewportSwizzleNV.html"><code>VkViewportSwizzleNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkViewportSwizzleNV {
///     VkViewportCoordinateSwizzleNV x; // @link substring="VkViewportCoordinateSwizzleNV" target="VkViewportCoordinateSwizzleNV" @link substring="x" target="#x"
///     VkViewportCoordinateSwizzleNV y; // @link substring="VkViewportCoordinateSwizzleNV" target="VkViewportCoordinateSwizzleNV" @link substring="y" target="#y"
///     VkViewportCoordinateSwizzleNV z; // @link substring="VkViewportCoordinateSwizzleNV" target="VkViewportCoordinateSwizzleNV" @link substring="z" target="#z"
///     VkViewportCoordinateSwizzleNV w; // @link substring="VkViewportCoordinateSwizzleNV" target="VkViewportCoordinateSwizzleNV" @link substring="w" target="#w"
/// } VkViewportSwizzleNV;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkViewportSwizzleNV.html"><code>VkViewportSwizzleNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkViewportSwizzleNV(@NotNull MemorySegment segment) implements IVkViewportSwizzleNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkViewportSwizzleNV.html"><code>VkViewportSwizzleNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkViewportSwizzleNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkViewportSwizzleNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkViewportSwizzleNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkViewportSwizzleNV, Iterable<VkViewportSwizzleNV> {
        public long size() {
            return segment.byteSize() / VkViewportSwizzleNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkViewportSwizzleNV at(long index) {
            return new VkViewportSwizzleNV(segment.asSlice(index * VkViewportSwizzleNV.BYTES, VkViewportSwizzleNV.BYTES));
        }

        public VkViewportSwizzleNV.Ptr at(long index, @NotNull Consumer<@NotNull VkViewportSwizzleNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkViewportSwizzleNV value) {
            MemorySegment s = segment.asSlice(index * VkViewportSwizzleNV.BYTES, VkViewportSwizzleNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkViewportSwizzleNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkViewportSwizzleNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkViewportSwizzleNV.BYTES,
                (end - start) * VkViewportSwizzleNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkViewportSwizzleNV.BYTES));
        }

        public VkViewportSwizzleNV[] toArray() {
            VkViewportSwizzleNV[] ret = new VkViewportSwizzleNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkViewportSwizzleNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkViewportSwizzleNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkViewportSwizzleNV.BYTES;
            }

            @Override
            public VkViewportSwizzleNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkViewportSwizzleNV ret = new VkViewportSwizzleNV(segment.asSlice(0, VkViewportSwizzleNV.BYTES));
                segment = segment.asSlice(VkViewportSwizzleNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkViewportSwizzleNV allocate(Arena arena) {
        return new VkViewportSwizzleNV(arena.allocate(LAYOUT));
    }

    public static VkViewportSwizzleNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkViewportSwizzleNV.Ptr(segment);
    }

    public static VkViewportSwizzleNV clone(Arena arena, VkViewportSwizzleNV src) {
        VkViewportSwizzleNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @EnumType(VkViewportCoordinateSwizzleNV.class) int x() {
        return segment.get(LAYOUT$x, OFFSET$x);
    }

    public VkViewportSwizzleNV x(@EnumType(VkViewportCoordinateSwizzleNV.class) int value) {
        segment.set(LAYOUT$x, OFFSET$x, value);
        return this;
    }

    public @EnumType(VkViewportCoordinateSwizzleNV.class) int y() {
        return segment.get(LAYOUT$y, OFFSET$y);
    }

    public VkViewportSwizzleNV y(@EnumType(VkViewportCoordinateSwizzleNV.class) int value) {
        segment.set(LAYOUT$y, OFFSET$y, value);
        return this;
    }

    public @EnumType(VkViewportCoordinateSwizzleNV.class) int z() {
        return segment.get(LAYOUT$z, OFFSET$z);
    }

    public VkViewportSwizzleNV z(@EnumType(VkViewportCoordinateSwizzleNV.class) int value) {
        segment.set(LAYOUT$z, OFFSET$z, value);
        return this;
    }

    public @EnumType(VkViewportCoordinateSwizzleNV.class) int w() {
        return segment.get(LAYOUT$w, OFFSET$w);
    }

    public VkViewportSwizzleNV w(@EnumType(VkViewportCoordinateSwizzleNV.class) int value) {
        segment.set(LAYOUT$w, OFFSET$w, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("x"),
        ValueLayout.JAVA_INT.withName("y"),
        ValueLayout.JAVA_INT.withName("z"),
        ValueLayout.JAVA_INT.withName("w")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$x = PathElement.groupElement("x");
    public static final PathElement PATH$y = PathElement.groupElement("y");
    public static final PathElement PATH$z = PathElement.groupElement("z");
    public static final PathElement PATH$w = PathElement.groupElement("w");

    public static final OfInt LAYOUT$x = (OfInt) LAYOUT.select(PATH$x);
    public static final OfInt LAYOUT$y = (OfInt) LAYOUT.select(PATH$y);
    public static final OfInt LAYOUT$z = (OfInt) LAYOUT.select(PATH$z);
    public static final OfInt LAYOUT$w = (OfInt) LAYOUT.select(PATH$w);

    public static final long SIZE$x = LAYOUT$x.byteSize();
    public static final long SIZE$y = LAYOUT$y.byteSize();
    public static final long SIZE$z = LAYOUT$z.byteSize();
    public static final long SIZE$w = LAYOUT$w.byteSize();

    public static final long OFFSET$x = LAYOUT.byteOffset(PATH$x);
    public static final long OFFSET$y = LAYOUT.byteOffset(PATH$y);
    public static final long OFFSET$z = LAYOUT.byteOffset(PATH$z);
    public static final long OFFSET$w = LAYOUT.byteOffset(PATH$w);
}
