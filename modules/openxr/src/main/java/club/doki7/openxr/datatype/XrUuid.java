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

/// Represents a pointer to a <a href="https://registry.khronos.org/OpenXR/specs/1.1/man/html/XrUuid.html"><code>XrUuid</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct XrUuid {
///     uint8_t[XR_UUID_SIZE] data; // @link substring="data" target="#data"
/// } XrUuid;
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
/// @see <a href="https://registry.khronos.org/OpenXR/specs/1.1/man/html/XrUuid.html"><code>XrUuid</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record XrUuid(@NotNull MemorySegment segment) implements IXrUuid {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/OpenXR/specs/1.1/man/html/XrUuid.html"><code>XrUuid</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link XrUuid}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IXrUuid to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code XrUuid.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IXrUuid, Iterable<XrUuid> {
        public long size() {
            return segment.byteSize() / XrUuid.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull XrUuid at(long index) {
            return new XrUuid(segment.asSlice(index * XrUuid.BYTES, XrUuid.BYTES));
        }

        public XrUuid.Ptr at(long index, @NotNull Consumer<@NotNull XrUuid> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull XrUuid value) {
            MemorySegment s = segment.asSlice(index * XrUuid.BYTES, XrUuid.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * XrUuid.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * XrUuid.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * XrUuid.BYTES,
                (end - start) * XrUuid.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * XrUuid.BYTES));
        }

        public XrUuid[] toArray() {
            XrUuid[] ret = new XrUuid[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<XrUuid> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<XrUuid> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= XrUuid.BYTES;
            }

            @Override
            public XrUuid next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                XrUuid ret = new XrUuid(segment.asSlice(0, XrUuid.BYTES));
                segment = segment.asSlice(XrUuid.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static XrUuid allocate(Arena arena) {
        return new XrUuid(arena.allocate(LAYOUT));
    }

    public static XrUuid.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new XrUuid.Ptr(segment);
    }

    public static XrUuid clone(Arena arena, XrUuid src) {
        XrUuid ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned BytePtr data() {
        return new BytePtr(dataRaw());
    }

    public XrUuid data(@NotNull Consumer<BytePtr> consumer) {
        @Unsigned BytePtr ptr = data();
        consumer.accept(ptr);
        return this;
    }

    public XrUuid data(@Unsigned BytePtr value) {
        MemorySegment s = dataRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment dataRaw() {
        return segment.asSlice(OFFSET$data, SIZE$data);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        MemoryLayout.sequenceLayout(UUID_SIZE, ValueLayout.JAVA_BYTE).withName("data")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$data = PathElement.groupElement("data");

    public static final SequenceLayout LAYOUT$data = (SequenceLayout) LAYOUT.select(PATH$data);

    public static final long SIZE$data = LAYOUT$data.byteSize();

    public static final long OFFSET$data = LAYOUT.byteOffset(PATH$data);
}
