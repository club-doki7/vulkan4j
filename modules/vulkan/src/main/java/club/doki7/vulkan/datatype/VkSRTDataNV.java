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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSRTDataNV.html"><code>VkSRTDataNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkSRTDataNV {
///     float sx; // @link substring="sx" target="#sx"
///     float a; // @link substring="a" target="#a"
///     float b; // @link substring="b" target="#b"
///     float pvx; // @link substring="pvx" target="#pvx"
///     float sy; // @link substring="sy" target="#sy"
///     float c; // @link substring="c" target="#c"
///     float pvy; // @link substring="pvy" target="#pvy"
///     float sz; // @link substring="sz" target="#sz"
///     float pvz; // @link substring="pvz" target="#pvz"
///     float qx; // @link substring="qx" target="#qx"
///     float qy; // @link substring="qy" target="#qy"
///     float qz; // @link substring="qz" target="#qz"
///     float qw; // @link substring="qw" target="#qw"
///     float tx; // @link substring="tx" target="#tx"
///     float ty; // @link substring="ty" target="#ty"
///     float tz; // @link substring="tz" target="#tz"
/// } VkSRTDataNV;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSRTDataNV.html"><code>VkSRTDataNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkSRTDataNV(@NotNull MemorySegment segment) implements IVkSRTDataNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSRTDataNV.html"><code>VkSRTDataNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkSRTDataNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkSRTDataNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkSRTDataNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkSRTDataNV, Iterable<VkSRTDataNV> {
        public long size() {
            return segment.byteSize() / VkSRTDataNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkSRTDataNV at(long index) {
            return new VkSRTDataNV(segment.asSlice(index * VkSRTDataNV.BYTES, VkSRTDataNV.BYTES));
        }

        public VkSRTDataNV.Ptr at(long index, @NotNull Consumer<@NotNull VkSRTDataNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkSRTDataNV value) {
            MemorySegment s = segment.asSlice(index * VkSRTDataNV.BYTES, VkSRTDataNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkSRTDataNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkSRTDataNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkSRTDataNV.BYTES,
                (end - start) * VkSRTDataNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkSRTDataNV.BYTES));
        }

        public VkSRTDataNV[] toArray() {
            VkSRTDataNV[] ret = new VkSRTDataNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkSRTDataNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkSRTDataNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkSRTDataNV.BYTES;
            }

            @Override
            public VkSRTDataNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkSRTDataNV ret = new VkSRTDataNV(segment.asSlice(0, VkSRTDataNV.BYTES));
                segment = segment.asSlice(VkSRTDataNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkSRTDataNV allocate(Arena arena) {
        return new VkSRTDataNV(arena.allocate(LAYOUT));
    }

    public static VkSRTDataNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkSRTDataNV.Ptr(segment);
    }

    public static VkSRTDataNV clone(Arena arena, VkSRTDataNV src) {
        VkSRTDataNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public float sx() {
        return segment.get(LAYOUT$sx, OFFSET$sx);
    }

    public VkSRTDataNV sx(float value) {
        segment.set(LAYOUT$sx, OFFSET$sx, value);
        return this;
    }

    public float a() {
        return segment.get(LAYOUT$a, OFFSET$a);
    }

    public VkSRTDataNV a(float value) {
        segment.set(LAYOUT$a, OFFSET$a, value);
        return this;
    }

    public float b() {
        return segment.get(LAYOUT$b, OFFSET$b);
    }

    public VkSRTDataNV b(float value) {
        segment.set(LAYOUT$b, OFFSET$b, value);
        return this;
    }

    public float pvx() {
        return segment.get(LAYOUT$pvx, OFFSET$pvx);
    }

    public VkSRTDataNV pvx(float value) {
        segment.set(LAYOUT$pvx, OFFSET$pvx, value);
        return this;
    }

    public float sy() {
        return segment.get(LAYOUT$sy, OFFSET$sy);
    }

    public VkSRTDataNV sy(float value) {
        segment.set(LAYOUT$sy, OFFSET$sy, value);
        return this;
    }

    public float c() {
        return segment.get(LAYOUT$c, OFFSET$c);
    }

    public VkSRTDataNV c(float value) {
        segment.set(LAYOUT$c, OFFSET$c, value);
        return this;
    }

    public float pvy() {
        return segment.get(LAYOUT$pvy, OFFSET$pvy);
    }

    public VkSRTDataNV pvy(float value) {
        segment.set(LAYOUT$pvy, OFFSET$pvy, value);
        return this;
    }

    public float sz() {
        return segment.get(LAYOUT$sz, OFFSET$sz);
    }

    public VkSRTDataNV sz(float value) {
        segment.set(LAYOUT$sz, OFFSET$sz, value);
        return this;
    }

    public float pvz() {
        return segment.get(LAYOUT$pvz, OFFSET$pvz);
    }

    public VkSRTDataNV pvz(float value) {
        segment.set(LAYOUT$pvz, OFFSET$pvz, value);
        return this;
    }

    public float qx() {
        return segment.get(LAYOUT$qx, OFFSET$qx);
    }

    public VkSRTDataNV qx(float value) {
        segment.set(LAYOUT$qx, OFFSET$qx, value);
        return this;
    }

    public float qy() {
        return segment.get(LAYOUT$qy, OFFSET$qy);
    }

    public VkSRTDataNV qy(float value) {
        segment.set(LAYOUT$qy, OFFSET$qy, value);
        return this;
    }

    public float qz() {
        return segment.get(LAYOUT$qz, OFFSET$qz);
    }

    public VkSRTDataNV qz(float value) {
        segment.set(LAYOUT$qz, OFFSET$qz, value);
        return this;
    }

    public float qw() {
        return segment.get(LAYOUT$qw, OFFSET$qw);
    }

    public VkSRTDataNV qw(float value) {
        segment.set(LAYOUT$qw, OFFSET$qw, value);
        return this;
    }

    public float tx() {
        return segment.get(LAYOUT$tx, OFFSET$tx);
    }

    public VkSRTDataNV tx(float value) {
        segment.set(LAYOUT$tx, OFFSET$tx, value);
        return this;
    }

    public float ty() {
        return segment.get(LAYOUT$ty, OFFSET$ty);
    }

    public VkSRTDataNV ty(float value) {
        segment.set(LAYOUT$ty, OFFSET$ty, value);
        return this;
    }

    public float tz() {
        return segment.get(LAYOUT$tz, OFFSET$tz);
    }

    public VkSRTDataNV tz(float value) {
        segment.set(LAYOUT$tz, OFFSET$tz, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_FLOAT.withName("sx"),
        ValueLayout.JAVA_FLOAT.withName("a"),
        ValueLayout.JAVA_FLOAT.withName("b"),
        ValueLayout.JAVA_FLOAT.withName("pvx"),
        ValueLayout.JAVA_FLOAT.withName("sy"),
        ValueLayout.JAVA_FLOAT.withName("c"),
        ValueLayout.JAVA_FLOAT.withName("pvy"),
        ValueLayout.JAVA_FLOAT.withName("sz"),
        ValueLayout.JAVA_FLOAT.withName("pvz"),
        ValueLayout.JAVA_FLOAT.withName("qx"),
        ValueLayout.JAVA_FLOAT.withName("qy"),
        ValueLayout.JAVA_FLOAT.withName("qz"),
        ValueLayout.JAVA_FLOAT.withName("qw"),
        ValueLayout.JAVA_FLOAT.withName("tx"),
        ValueLayout.JAVA_FLOAT.withName("ty"),
        ValueLayout.JAVA_FLOAT.withName("tz")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sx = PathElement.groupElement("sx");
    public static final PathElement PATH$a = PathElement.groupElement("a");
    public static final PathElement PATH$b = PathElement.groupElement("b");
    public static final PathElement PATH$pvx = PathElement.groupElement("pvx");
    public static final PathElement PATH$sy = PathElement.groupElement("sy");
    public static final PathElement PATH$c = PathElement.groupElement("c");
    public static final PathElement PATH$pvy = PathElement.groupElement("pvy");
    public static final PathElement PATH$sz = PathElement.groupElement("sz");
    public static final PathElement PATH$pvz = PathElement.groupElement("pvz");
    public static final PathElement PATH$qx = PathElement.groupElement("qx");
    public static final PathElement PATH$qy = PathElement.groupElement("qy");
    public static final PathElement PATH$qz = PathElement.groupElement("qz");
    public static final PathElement PATH$qw = PathElement.groupElement("qw");
    public static final PathElement PATH$tx = PathElement.groupElement("tx");
    public static final PathElement PATH$ty = PathElement.groupElement("ty");
    public static final PathElement PATH$tz = PathElement.groupElement("tz");

    public static final OfFloat LAYOUT$sx = (OfFloat) LAYOUT.select(PATH$sx);
    public static final OfFloat LAYOUT$a = (OfFloat) LAYOUT.select(PATH$a);
    public static final OfFloat LAYOUT$b = (OfFloat) LAYOUT.select(PATH$b);
    public static final OfFloat LAYOUT$pvx = (OfFloat) LAYOUT.select(PATH$pvx);
    public static final OfFloat LAYOUT$sy = (OfFloat) LAYOUT.select(PATH$sy);
    public static final OfFloat LAYOUT$c = (OfFloat) LAYOUT.select(PATH$c);
    public static final OfFloat LAYOUT$pvy = (OfFloat) LAYOUT.select(PATH$pvy);
    public static final OfFloat LAYOUT$sz = (OfFloat) LAYOUT.select(PATH$sz);
    public static final OfFloat LAYOUT$pvz = (OfFloat) LAYOUT.select(PATH$pvz);
    public static final OfFloat LAYOUT$qx = (OfFloat) LAYOUT.select(PATH$qx);
    public static final OfFloat LAYOUT$qy = (OfFloat) LAYOUT.select(PATH$qy);
    public static final OfFloat LAYOUT$qz = (OfFloat) LAYOUT.select(PATH$qz);
    public static final OfFloat LAYOUT$qw = (OfFloat) LAYOUT.select(PATH$qw);
    public static final OfFloat LAYOUT$tx = (OfFloat) LAYOUT.select(PATH$tx);
    public static final OfFloat LAYOUT$ty = (OfFloat) LAYOUT.select(PATH$ty);
    public static final OfFloat LAYOUT$tz = (OfFloat) LAYOUT.select(PATH$tz);

    public static final long SIZE$sx = LAYOUT$sx.byteSize();
    public static final long SIZE$a = LAYOUT$a.byteSize();
    public static final long SIZE$b = LAYOUT$b.byteSize();
    public static final long SIZE$pvx = LAYOUT$pvx.byteSize();
    public static final long SIZE$sy = LAYOUT$sy.byteSize();
    public static final long SIZE$c = LAYOUT$c.byteSize();
    public static final long SIZE$pvy = LAYOUT$pvy.byteSize();
    public static final long SIZE$sz = LAYOUT$sz.byteSize();
    public static final long SIZE$pvz = LAYOUT$pvz.byteSize();
    public static final long SIZE$qx = LAYOUT$qx.byteSize();
    public static final long SIZE$qy = LAYOUT$qy.byteSize();
    public static final long SIZE$qz = LAYOUT$qz.byteSize();
    public static final long SIZE$qw = LAYOUT$qw.byteSize();
    public static final long SIZE$tx = LAYOUT$tx.byteSize();
    public static final long SIZE$ty = LAYOUT$ty.byteSize();
    public static final long SIZE$tz = LAYOUT$tz.byteSize();

    public static final long OFFSET$sx = LAYOUT.byteOffset(PATH$sx);
    public static final long OFFSET$a = LAYOUT.byteOffset(PATH$a);
    public static final long OFFSET$b = LAYOUT.byteOffset(PATH$b);
    public static final long OFFSET$pvx = LAYOUT.byteOffset(PATH$pvx);
    public static final long OFFSET$sy = LAYOUT.byteOffset(PATH$sy);
    public static final long OFFSET$c = LAYOUT.byteOffset(PATH$c);
    public static final long OFFSET$pvy = LAYOUT.byteOffset(PATH$pvy);
    public static final long OFFSET$sz = LAYOUT.byteOffset(PATH$sz);
    public static final long OFFSET$pvz = LAYOUT.byteOffset(PATH$pvz);
    public static final long OFFSET$qx = LAYOUT.byteOffset(PATH$qx);
    public static final long OFFSET$qy = LAYOUT.byteOffset(PATH$qy);
    public static final long OFFSET$qz = LAYOUT.byteOffset(PATH$qz);
    public static final long OFFSET$qw = LAYOUT.byteOffset(PATH$qw);
    public static final long OFFSET$tx = LAYOUT.byteOffset(PATH$tx);
    public static final long OFFSET$ty = LAYOUT.byteOffset(PATH$ty);
    public static final long OFFSET$tz = LAYOUT.byteOffset(PATH$tz);
}
