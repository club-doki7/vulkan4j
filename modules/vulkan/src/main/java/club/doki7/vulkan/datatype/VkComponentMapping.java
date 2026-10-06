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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkComponentMapping.html"><code>VkComponentMapping</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkComponentMapping {
///     VkComponentSwizzle r; // @link substring="VkComponentSwizzle" target="VkComponentSwizzle" @link substring="r" target="#r"
///     VkComponentSwizzle g; // @link substring="VkComponentSwizzle" target="VkComponentSwizzle" @link substring="g" target="#g"
///     VkComponentSwizzle b; // @link substring="VkComponentSwizzle" target="VkComponentSwizzle" @link substring="b" target="#b"
///     VkComponentSwizzle a; // @link substring="VkComponentSwizzle" target="VkComponentSwizzle" @link substring="a" target="#a"
/// } VkComponentMapping;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkComponentMapping.html"><code>VkComponentMapping</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkComponentMapping(@NotNull MemorySegment segment) implements IVkComponentMapping {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkComponentMapping.html"><code>VkComponentMapping</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkComponentMapping}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkComponentMapping to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkComponentMapping.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkComponentMapping, Iterable<VkComponentMapping> {
        public long size() {
            return segment.byteSize() / VkComponentMapping.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkComponentMapping at(long index) {
            return new VkComponentMapping(segment.asSlice(index * VkComponentMapping.BYTES, VkComponentMapping.BYTES));
        }

        public VkComponentMapping.Ptr at(long index, @NotNull Consumer<@NotNull VkComponentMapping> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkComponentMapping value) {
            MemorySegment s = segment.asSlice(index * VkComponentMapping.BYTES, VkComponentMapping.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkComponentMapping.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkComponentMapping.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkComponentMapping.BYTES,
                (end - start) * VkComponentMapping.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkComponentMapping.BYTES));
        }

        public VkComponentMapping[] toArray() {
            VkComponentMapping[] ret = new VkComponentMapping[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkComponentMapping> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkComponentMapping> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkComponentMapping.BYTES;
            }

            @Override
            public VkComponentMapping next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkComponentMapping ret = new VkComponentMapping(segment.asSlice(0, VkComponentMapping.BYTES));
                segment = segment.asSlice(VkComponentMapping.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkComponentMapping allocate(Arena arena) {
        return new VkComponentMapping(arena.allocate(LAYOUT));
    }

    public static VkComponentMapping.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkComponentMapping.Ptr(segment);
    }

    public static VkComponentMapping clone(Arena arena, VkComponentMapping src) {
        VkComponentMapping ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @EnumType(VkComponentSwizzle.class) int r() {
        return segment.get(LAYOUT$r, OFFSET$r);
    }

    public VkComponentMapping r(@EnumType(VkComponentSwizzle.class) int value) {
        segment.set(LAYOUT$r, OFFSET$r, value);
        return this;
    }

    public @EnumType(VkComponentSwizzle.class) int g() {
        return segment.get(LAYOUT$g, OFFSET$g);
    }

    public VkComponentMapping g(@EnumType(VkComponentSwizzle.class) int value) {
        segment.set(LAYOUT$g, OFFSET$g, value);
        return this;
    }

    public @EnumType(VkComponentSwizzle.class) int b() {
        return segment.get(LAYOUT$b, OFFSET$b);
    }

    public VkComponentMapping b(@EnumType(VkComponentSwizzle.class) int value) {
        segment.set(LAYOUT$b, OFFSET$b, value);
        return this;
    }

    public @EnumType(VkComponentSwizzle.class) int a() {
        return segment.get(LAYOUT$a, OFFSET$a);
    }

    public VkComponentMapping a(@EnumType(VkComponentSwizzle.class) int value) {
        segment.set(LAYOUT$a, OFFSET$a, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("r"),
        ValueLayout.JAVA_INT.withName("g"),
        ValueLayout.JAVA_INT.withName("b"),
        ValueLayout.JAVA_INT.withName("a")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$r = PathElement.groupElement("r");
    public static final PathElement PATH$g = PathElement.groupElement("g");
    public static final PathElement PATH$b = PathElement.groupElement("b");
    public static final PathElement PATH$a = PathElement.groupElement("a");

    public static final OfInt LAYOUT$r = (OfInt) LAYOUT.select(PATH$r);
    public static final OfInt LAYOUT$g = (OfInt) LAYOUT.select(PATH$g);
    public static final OfInt LAYOUT$b = (OfInt) LAYOUT.select(PATH$b);
    public static final OfInt LAYOUT$a = (OfInt) LAYOUT.select(PATH$a);

    public static final long SIZE$r = LAYOUT$r.byteSize();
    public static final long SIZE$g = LAYOUT$g.byteSize();
    public static final long SIZE$b = LAYOUT$b.byteSize();
    public static final long SIZE$a = LAYOUT$a.byteSize();

    public static final long OFFSET$r = LAYOUT.byteOffset(PATH$r);
    public static final long OFFSET$g = LAYOUT.byteOffset(PATH$g);
    public static final long OFFSET$b = LAYOUT.byteOffset(PATH$b);
    public static final long OFFSET$a = LAYOUT.byteOffset(PATH$a);
}
