package club.doki7.opencl.datatype;

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
import club.doki7.opencl.handle.*;
import static club.doki7.opencl.CLConstants.*;
import club.doki7.opencl.CLFunctionTypes.*;

/// Represents a pointer to a <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_name_version.html">cl_name_version</a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct cl_name_version {
///     cl_version version; // @link substring="version" target="#version"
///     char[CL_NAME_VERSION_MAX_NAME_SIZE] name; // @link substring="name" target="#name"
/// } cl_name_version;
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
/// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_name_version.html">cl_name_version</a>
@ValueBasedCandidate
@UnsafeConstructor
public record CLNameVersion(@NotNull MemorySegment segment) implements ICLNameVersion {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_name_version.html">cl_name_version</a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link CLNameVersion}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// ICLNameVersion to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code CLNameVersion.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements ICLNameVersion, Iterable<CLNameVersion> {
        public long size() {
            return segment.byteSize() / CLNameVersion.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull CLNameVersion at(long index) {
            return new CLNameVersion(segment.asSlice(index * CLNameVersion.BYTES, CLNameVersion.BYTES));
        }

        public CLNameVersion.Ptr at(long index, @NotNull Consumer<@NotNull CLNameVersion> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull CLNameVersion value) {
            MemorySegment s = segment.asSlice(index * CLNameVersion.BYTES, CLNameVersion.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * CLNameVersion.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * CLNameVersion.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * CLNameVersion.BYTES,
                (end - start) * CLNameVersion.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * CLNameVersion.BYTES));
        }

        public CLNameVersion[] toArray() {
            CLNameVersion[] ret = new CLNameVersion[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<CLNameVersion> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<CLNameVersion> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= CLNameVersion.BYTES;
            }

            @Override
            public CLNameVersion next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                CLNameVersion ret = new CLNameVersion(segment.asSlice(0, CLNameVersion.BYTES));
                segment = segment.asSlice(CLNameVersion.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static CLNameVersion allocate(Arena arena) {
        return new CLNameVersion(arena.allocate(LAYOUT));
    }

    public static CLNameVersion.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new CLNameVersion.Ptr(segment);
    }

    public static CLNameVersion clone(Arena arena, CLNameVersion src) {
        CLNameVersion ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NativeType("cl_version") @Unsigned int version() {
        return segment.get(LAYOUT$version, OFFSET$version);
    }

    public CLNameVersion version(@NativeType("cl_version") @Unsigned int value) {
        segment.set(LAYOUT$version, OFFSET$version, value);
        return this;
    }

    public BytePtr name() {
        return new BytePtr(nameRaw());
    }

    public CLNameVersion name(@NotNull Consumer<BytePtr> consumer) {
        BytePtr ptr = name();
        consumer.accept(ptr);
        return this;
    }

    public CLNameVersion name(BytePtr value) {
        MemorySegment s = nameRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment nameRaw() {
        return segment.asSlice(OFFSET$name, SIZE$name);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("version"),
        MemoryLayout.sequenceLayout(NAME_VERSION_MAX_NAME_SIZE, ValueLayout.JAVA_BYTE).withName("name")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$version = PathElement.groupElement("version");
    public static final PathElement PATH$name = PathElement.groupElement("name");

    public static final OfInt LAYOUT$version = (OfInt) LAYOUT.select(PATH$version);
    public static final SequenceLayout LAYOUT$name = (SequenceLayout) LAYOUT.select(PATH$name);

    public static final long SIZE$version = LAYOUT$version.byteSize();
    public static final long SIZE$name = LAYOUT$name.byteSize();

    public static final long OFFSET$version = LAYOUT.byteOffset(PATH$version);
    public static final long OFFSET$name = LAYOUT.byteOffset(PATH$name);
}
