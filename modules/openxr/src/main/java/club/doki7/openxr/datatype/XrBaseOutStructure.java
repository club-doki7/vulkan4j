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

/// Represents a pointer to a <a href="https://registry.khronos.org/OpenXR/specs/1.1/man/html/XrBaseOutStructure.html"><code>XrBaseOutStructure</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct XrBaseOutStructure {
///     XrStructureType type; // @link substring="XrStructureType" target="XrStructureType" @link substring="type" target="#type"
///     XrBaseOutStructure* next; // @link substring="XrBaseOutStructure" target="XrBaseOutStructure" @link substring="next" target="#next"
/// } XrBaseOutStructure;
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
/// @see <a href="https://registry.khronos.org/OpenXR/specs/1.1/man/html/XrBaseOutStructure.html"><code>XrBaseOutStructure</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record XrBaseOutStructure(@NotNull MemorySegment segment) implements IXrBaseOutStructure {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/OpenXR/specs/1.1/man/html/XrBaseOutStructure.html"><code>XrBaseOutStructure</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link XrBaseOutStructure}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IXrBaseOutStructure to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code XrBaseOutStructure.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IXrBaseOutStructure, Iterable<XrBaseOutStructure> {
        public long size() {
            return segment.byteSize() / XrBaseOutStructure.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull XrBaseOutStructure at(long index) {
            return new XrBaseOutStructure(segment.asSlice(index * XrBaseOutStructure.BYTES, XrBaseOutStructure.BYTES));
        }

        public XrBaseOutStructure.Ptr at(long index, @NotNull Consumer<@NotNull XrBaseOutStructure> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull XrBaseOutStructure value) {
            MemorySegment s = segment.asSlice(index * XrBaseOutStructure.BYTES, XrBaseOutStructure.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * XrBaseOutStructure.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * XrBaseOutStructure.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * XrBaseOutStructure.BYTES,
                (end - start) * XrBaseOutStructure.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * XrBaseOutStructure.BYTES));
        }

        public XrBaseOutStructure[] toArray() {
            XrBaseOutStructure[] ret = new XrBaseOutStructure[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<XrBaseOutStructure> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<XrBaseOutStructure> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= XrBaseOutStructure.BYTES;
            }

            @Override
            public XrBaseOutStructure next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                XrBaseOutStructure ret = new XrBaseOutStructure(segment.asSlice(0, XrBaseOutStructure.BYTES));
                segment = segment.asSlice(XrBaseOutStructure.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static XrBaseOutStructure allocate(Arena arena) {
        return new XrBaseOutStructure(arena.allocate(LAYOUT));
    }

    public static XrBaseOutStructure.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new XrBaseOutStructure.Ptr(segment);
    }

    public static XrBaseOutStructure clone(Arena arena, XrBaseOutStructure src) {
        XrBaseOutStructure ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @EnumType(XrStructureType.class) int type() {
        return segment.get(LAYOUT$type, OFFSET$type);
    }

    public XrBaseOutStructure type(@EnumType(XrStructureType.class) int value) {
        segment.set(LAYOUT$type, OFFSET$type, value);
        return this;
    }

    public XrBaseOutStructure next(@Nullable IXrBaseOutStructure value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        nextRaw(s);
        return this;
    }

    @Unsafe public @Nullable XrBaseOutStructure.Ptr next(int assumedCount) {
        MemorySegment s = nextRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * XrBaseOutStructure.BYTES);
        return new XrBaseOutStructure.Ptr(s);
    }

    public @Nullable XrBaseOutStructure next() {
        MemorySegment s = nextRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new XrBaseOutStructure(s);
    }

    public @Pointer(target=XrBaseOutStructure.class) @NotNull MemorySegment nextRaw() {
        return segment.get(LAYOUT$next, OFFSET$next);
    }

    public void nextRaw(@Pointer(target=XrBaseOutStructure.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$next, OFFSET$next, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("type"),
        ValueLayout.ADDRESS.withName("next")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$type = PathElement.groupElement("type");
    public static final PathElement PATH$next = PathElement.groupElement("next");

    public static final OfInt LAYOUT$type = (OfInt) LAYOUT.select(PATH$type);
    public static final AddressLayout LAYOUT$next = (AddressLayout) LAYOUT.select(PATH$next);

    public static final long SIZE$type = LAYOUT$type.byteSize();
    public static final long SIZE$next = LAYOUT$next.byteSize();

    public static final long OFFSET$type = LAYOUT.byteOffset(PATH$type);
    public static final long OFFSET$next = LAYOUT.byteOffset(PATH$next);
}
