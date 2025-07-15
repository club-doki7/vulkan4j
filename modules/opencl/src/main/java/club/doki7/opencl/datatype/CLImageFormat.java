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

/// Represents a pointer to a <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_image_format.html">cl_image_format</a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct cl_image_format {
///     cl_channel_order imageChannelOrder; // @link substring="imageChannelOrder" target="#imageChannelOrder"
///     cl_channel_type imageChannelDataType; // @link substring="imageChannelDataType" target="#imageChannelDataType"
/// } cl_image_format;
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
/// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_image_format.html">cl_image_format</a>
@ValueBasedCandidate
@UnsafeConstructor
public record CLImageFormat(@NotNull MemorySegment segment) implements ICLImageFormat {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_image_format.html">cl_image_format</a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link CLImageFormat}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// ICLImageFormat to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code CLImageFormat.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements ICLImageFormat, Iterable<CLImageFormat> {
        public long size() {
            return segment.byteSize() / CLImageFormat.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull CLImageFormat at(long index) {
            return new CLImageFormat(segment.asSlice(index * CLImageFormat.BYTES, CLImageFormat.BYTES));
        }

        public CLImageFormat.Ptr at(long index, @NotNull Consumer<@NotNull CLImageFormat> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull CLImageFormat value) {
            MemorySegment s = segment.asSlice(index * CLImageFormat.BYTES, CLImageFormat.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * CLImageFormat.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * CLImageFormat.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * CLImageFormat.BYTES,
                (end - start) * CLImageFormat.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * CLImageFormat.BYTES));
        }

        public CLImageFormat[] toArray() {
            CLImageFormat[] ret = new CLImageFormat[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<CLImageFormat> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<CLImageFormat> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= CLImageFormat.BYTES;
            }

            @Override
            public CLImageFormat next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                CLImageFormat ret = new CLImageFormat(segment.asSlice(0, CLImageFormat.BYTES));
                segment = segment.asSlice(CLImageFormat.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static CLImageFormat allocate(Arena arena) {
        return new CLImageFormat(arena.allocate(LAYOUT));
    }

    public static CLImageFormat.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new CLImageFormat.Ptr(segment);
    }

    public static CLImageFormat clone(Arena arena, CLImageFormat src) {
        CLImageFormat ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NativeType("cl_channel_order") @Unsigned int imageChannelOrder() {
        return segment.get(LAYOUT$imageChannelOrder, OFFSET$imageChannelOrder);
    }

    public CLImageFormat imageChannelOrder(@NativeType("cl_channel_order") @Unsigned int value) {
        segment.set(LAYOUT$imageChannelOrder, OFFSET$imageChannelOrder, value);
        return this;
    }

    public @NativeType("cl_channel_type") @Unsigned int imageChannelDataType() {
        return segment.get(LAYOUT$imageChannelDataType, OFFSET$imageChannelDataType);
    }

    public CLImageFormat imageChannelDataType(@NativeType("cl_channel_type") @Unsigned int value) {
        segment.set(LAYOUT$imageChannelDataType, OFFSET$imageChannelDataType, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("imageChannelOrder"),
        ValueLayout.JAVA_INT.withName("imageChannelDataType")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$imageChannelOrder = PathElement.groupElement("imageChannelOrder");
    public static final PathElement PATH$imageChannelDataType = PathElement.groupElement("imageChannelDataType");

    public static final OfInt LAYOUT$imageChannelOrder = (OfInt) LAYOUT.select(PATH$imageChannelOrder);
    public static final OfInt LAYOUT$imageChannelDataType = (OfInt) LAYOUT.select(PATH$imageChannelDataType);

    public static final long SIZE$imageChannelOrder = LAYOUT$imageChannelOrder.byteSize();
    public static final long SIZE$imageChannelDataType = LAYOUT$imageChannelDataType.byteSize();

    public static final long OFFSET$imageChannelOrder = LAYOUT.byteOffset(PATH$imageChannelOrder);
    public static final long OFFSET$imageChannelDataType = LAYOUT.byteOffset(PATH$imageChannelDataType);
}
