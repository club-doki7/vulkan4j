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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkColorBlendEquationEXT.html"><code>VkColorBlendEquationEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkColorBlendEquationEXT {
///     VkBlendFactor srcColorBlendFactor; // @link substring="VkBlendFactor" target="VkBlendFactor" @link substring="srcColorBlendFactor" target="#srcColorBlendFactor"
///     VkBlendFactor dstColorBlendFactor; // @link substring="VkBlendFactor" target="VkBlendFactor" @link substring="dstColorBlendFactor" target="#dstColorBlendFactor"
///     VkBlendOp colorBlendOp; // @link substring="VkBlendOp" target="VkBlendOp" @link substring="colorBlendOp" target="#colorBlendOp"
///     VkBlendFactor srcAlphaBlendFactor; // @link substring="VkBlendFactor" target="VkBlendFactor" @link substring="srcAlphaBlendFactor" target="#srcAlphaBlendFactor"
///     VkBlendFactor dstAlphaBlendFactor; // @link substring="VkBlendFactor" target="VkBlendFactor" @link substring="dstAlphaBlendFactor" target="#dstAlphaBlendFactor"
///     VkBlendOp alphaBlendOp; // @link substring="VkBlendOp" target="VkBlendOp" @link substring="alphaBlendOp" target="#alphaBlendOp"
/// } VkColorBlendEquationEXT;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkColorBlendEquationEXT.html"><code>VkColorBlendEquationEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkColorBlendEquationEXT(@NotNull MemorySegment segment) implements IVkColorBlendEquationEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkColorBlendEquationEXT.html"><code>VkColorBlendEquationEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkColorBlendEquationEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkColorBlendEquationEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkColorBlendEquationEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkColorBlendEquationEXT, Iterable<VkColorBlendEquationEXT> {
        public long size() {
            return segment.byteSize() / VkColorBlendEquationEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkColorBlendEquationEXT at(long index) {
            return new VkColorBlendEquationEXT(segment.asSlice(index * VkColorBlendEquationEXT.BYTES, VkColorBlendEquationEXT.BYTES));
        }

        public VkColorBlendEquationEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkColorBlendEquationEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkColorBlendEquationEXT value) {
            MemorySegment s = segment.asSlice(index * VkColorBlendEquationEXT.BYTES, VkColorBlendEquationEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkColorBlendEquationEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkColorBlendEquationEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkColorBlendEquationEXT.BYTES,
                (end - start) * VkColorBlendEquationEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkColorBlendEquationEXT.BYTES));
        }

        public VkColorBlendEquationEXT[] toArray() {
            VkColorBlendEquationEXT[] ret = new VkColorBlendEquationEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkColorBlendEquationEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkColorBlendEquationEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkColorBlendEquationEXT.BYTES;
            }

            @Override
            public VkColorBlendEquationEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkColorBlendEquationEXT ret = new VkColorBlendEquationEXT(segment.asSlice(0, VkColorBlendEquationEXT.BYTES));
                segment = segment.asSlice(VkColorBlendEquationEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkColorBlendEquationEXT allocate(Arena arena) {
        return new VkColorBlendEquationEXT(arena.allocate(LAYOUT));
    }

    public static VkColorBlendEquationEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkColorBlendEquationEXT.Ptr(segment);
    }

    public static VkColorBlendEquationEXT clone(Arena arena, VkColorBlendEquationEXT src) {
        VkColorBlendEquationEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @EnumType(VkBlendFactor.class) int srcColorBlendFactor() {
        return segment.get(LAYOUT$srcColorBlendFactor, OFFSET$srcColorBlendFactor);
    }

    public VkColorBlendEquationEXT srcColorBlendFactor(@EnumType(VkBlendFactor.class) int value) {
        segment.set(LAYOUT$srcColorBlendFactor, OFFSET$srcColorBlendFactor, value);
        return this;
    }

    public @EnumType(VkBlendFactor.class) int dstColorBlendFactor() {
        return segment.get(LAYOUT$dstColorBlendFactor, OFFSET$dstColorBlendFactor);
    }

    public VkColorBlendEquationEXT dstColorBlendFactor(@EnumType(VkBlendFactor.class) int value) {
        segment.set(LAYOUT$dstColorBlendFactor, OFFSET$dstColorBlendFactor, value);
        return this;
    }

    public @EnumType(VkBlendOp.class) int colorBlendOp() {
        return segment.get(LAYOUT$colorBlendOp, OFFSET$colorBlendOp);
    }

    public VkColorBlendEquationEXT colorBlendOp(@EnumType(VkBlendOp.class) int value) {
        segment.set(LAYOUT$colorBlendOp, OFFSET$colorBlendOp, value);
        return this;
    }

    public @EnumType(VkBlendFactor.class) int srcAlphaBlendFactor() {
        return segment.get(LAYOUT$srcAlphaBlendFactor, OFFSET$srcAlphaBlendFactor);
    }

    public VkColorBlendEquationEXT srcAlphaBlendFactor(@EnumType(VkBlendFactor.class) int value) {
        segment.set(LAYOUT$srcAlphaBlendFactor, OFFSET$srcAlphaBlendFactor, value);
        return this;
    }

    public @EnumType(VkBlendFactor.class) int dstAlphaBlendFactor() {
        return segment.get(LAYOUT$dstAlphaBlendFactor, OFFSET$dstAlphaBlendFactor);
    }

    public VkColorBlendEquationEXT dstAlphaBlendFactor(@EnumType(VkBlendFactor.class) int value) {
        segment.set(LAYOUT$dstAlphaBlendFactor, OFFSET$dstAlphaBlendFactor, value);
        return this;
    }

    public @EnumType(VkBlendOp.class) int alphaBlendOp() {
        return segment.get(LAYOUT$alphaBlendOp, OFFSET$alphaBlendOp);
    }

    public VkColorBlendEquationEXT alphaBlendOp(@EnumType(VkBlendOp.class) int value) {
        segment.set(LAYOUT$alphaBlendOp, OFFSET$alphaBlendOp, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("srcColorBlendFactor"),
        ValueLayout.JAVA_INT.withName("dstColorBlendFactor"),
        ValueLayout.JAVA_INT.withName("colorBlendOp"),
        ValueLayout.JAVA_INT.withName("srcAlphaBlendFactor"),
        ValueLayout.JAVA_INT.withName("dstAlphaBlendFactor"),
        ValueLayout.JAVA_INT.withName("alphaBlendOp")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$srcColorBlendFactor = PathElement.groupElement("srcColorBlendFactor");
    public static final PathElement PATH$dstColorBlendFactor = PathElement.groupElement("dstColorBlendFactor");
    public static final PathElement PATH$colorBlendOp = PathElement.groupElement("colorBlendOp");
    public static final PathElement PATH$srcAlphaBlendFactor = PathElement.groupElement("srcAlphaBlendFactor");
    public static final PathElement PATH$dstAlphaBlendFactor = PathElement.groupElement("dstAlphaBlendFactor");
    public static final PathElement PATH$alphaBlendOp = PathElement.groupElement("alphaBlendOp");

    public static final OfInt LAYOUT$srcColorBlendFactor = (OfInt) LAYOUT.select(PATH$srcColorBlendFactor);
    public static final OfInt LAYOUT$dstColorBlendFactor = (OfInt) LAYOUT.select(PATH$dstColorBlendFactor);
    public static final OfInt LAYOUT$colorBlendOp = (OfInt) LAYOUT.select(PATH$colorBlendOp);
    public static final OfInt LAYOUT$srcAlphaBlendFactor = (OfInt) LAYOUT.select(PATH$srcAlphaBlendFactor);
    public static final OfInt LAYOUT$dstAlphaBlendFactor = (OfInt) LAYOUT.select(PATH$dstAlphaBlendFactor);
    public static final OfInt LAYOUT$alphaBlendOp = (OfInt) LAYOUT.select(PATH$alphaBlendOp);

    public static final long SIZE$srcColorBlendFactor = LAYOUT$srcColorBlendFactor.byteSize();
    public static final long SIZE$dstColorBlendFactor = LAYOUT$dstColorBlendFactor.byteSize();
    public static final long SIZE$colorBlendOp = LAYOUT$colorBlendOp.byteSize();
    public static final long SIZE$srcAlphaBlendFactor = LAYOUT$srcAlphaBlendFactor.byteSize();
    public static final long SIZE$dstAlphaBlendFactor = LAYOUT$dstAlphaBlendFactor.byteSize();
    public static final long SIZE$alphaBlendOp = LAYOUT$alphaBlendOp.byteSize();

    public static final long OFFSET$srcColorBlendFactor = LAYOUT.byteOffset(PATH$srcColorBlendFactor);
    public static final long OFFSET$dstColorBlendFactor = LAYOUT.byteOffset(PATH$dstColorBlendFactor);
    public static final long OFFSET$colorBlendOp = LAYOUT.byteOffset(PATH$colorBlendOp);
    public static final long OFFSET$srcAlphaBlendFactor = LAYOUT.byteOffset(PATH$srcAlphaBlendFactor);
    public static final long OFFSET$dstAlphaBlendFactor = LAYOUT.byteOffset(PATH$dstAlphaBlendFactor);
    public static final long OFFSET$alphaBlendOp = LAYOUT.byteOffset(PATH$alphaBlendOp);
}
