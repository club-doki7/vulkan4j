package club.doki7.openxr.datatype;

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
import club.doki7.openxr.bitmask.*;
import club.doki7.openxr.handle.*;
import club.doki7.openxr.enumtype.*;
import static club.doki7.openxr.XRConstants.*;
import club.doki7.openxr.XRFunctionTypes.*;
import club.doki7.vulkan.bitmask.*;
import club.doki7.vulkan.datatype.*;
import club.doki7.vulkan.enumtype.*;
import club.doki7.vulkan.handle.*;

/// Represents a pointer to a <a href="https://registry.khronos.org/OpenXR/specs/1.1/man/html/XrSpherefKHR.html"><code>XrSpherefKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct XrSpherefKHR {
///     XrPosef center; // @link substring="XrPosef" target="XrPosef" @link substring="center" target="#center"
///     float radius; // @link substring="radius" target="#radius"
/// } XrSpherefKHR;
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
/// @see <a href="https://registry.khronos.org/OpenXR/specs/1.1/man/html/XrSpherefKHR.html"><code>XrSpherefKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record XrSpherefKHR(@NotNull MemorySegment segment) implements IXrSpherefKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/OpenXR/specs/1.1/man/html/XrSpherefKHR.html"><code>XrSpherefKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link XrSpherefKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IXrSpherefKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code XrSpherefKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IXrSpherefKHR, Iterable<XrSpherefKHR> {
        public long size() {
            return segment.byteSize() / XrSpherefKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull XrSpherefKHR at(long index) {
            return new XrSpherefKHR(segment.asSlice(index * XrSpherefKHR.BYTES, XrSpherefKHR.BYTES));
        }

        public XrSpherefKHR.Ptr at(long index, @NotNull Consumer<@NotNull XrSpherefKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull XrSpherefKHR value) {
            MemorySegment s = segment.asSlice(index * XrSpherefKHR.BYTES, XrSpherefKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * XrSpherefKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * XrSpherefKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * XrSpherefKHR.BYTES,
                (end - start) * XrSpherefKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * XrSpherefKHR.BYTES));
        }

        public XrSpherefKHR[] toArray() {
            XrSpherefKHR[] ret = new XrSpherefKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<XrSpherefKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<XrSpherefKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= XrSpherefKHR.BYTES;
            }

            @Override
            public XrSpherefKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                XrSpherefKHR ret = new XrSpherefKHR(segment.asSlice(0, XrSpherefKHR.BYTES));
                segment = segment.asSlice(XrSpherefKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static XrSpherefKHR allocate(Arena arena) {
        return new XrSpherefKHR(arena.allocate(LAYOUT));
    }

    public static XrSpherefKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new XrSpherefKHR.Ptr(segment);
    }

    public static XrSpherefKHR clone(Arena arena, XrSpherefKHR src) {
        XrSpherefKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull XrPosef center() {
        return new XrPosef(segment.asSlice(OFFSET$center, LAYOUT$center));
    }

    public XrSpherefKHR center(@NotNull XrPosef value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$center, SIZE$center);
        return this;
    }

    public XrSpherefKHR center(Consumer<@NotNull XrPosef> consumer) {
        consumer.accept(center());
        return this;
    }

    public float radius() {
        return segment.get(LAYOUT$radius, OFFSET$radius);
    }

    public XrSpherefKHR radius(float value) {
        segment.set(LAYOUT$radius, OFFSET$radius, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        XrPosef.LAYOUT.withName("center"),
        ValueLayout.JAVA_FLOAT.withName("radius")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$center = PathElement.groupElement("center");
    public static final PathElement PATH$radius = PathElement.groupElement("radius");

    public static final StructLayout LAYOUT$center = (StructLayout) LAYOUT.select(PATH$center);
    public static final OfFloat LAYOUT$radius = (OfFloat) LAYOUT.select(PATH$radius);

    public static final long SIZE$center = LAYOUT$center.byteSize();
    public static final long SIZE$radius = LAYOUT$radius.byteSize();

    public static final long OFFSET$center = LAYOUT.byteOffset(PATH$center);
    public static final long OFFSET$radius = LAYOUT.byteOffset(PATH$radius);
}
