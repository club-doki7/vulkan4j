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

/// Represents a pointer to a <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_image_desc.html">cl_image_desc</a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct cl_image_desc {
///     cl_mem_object_type imageType; // @link substring="imageType" target="#imageType"
///     size_t imageWidth; // @link substring="imageWidth" target="#imageWidth"
///     size_t imageHeight; // @link substring="imageHeight" target="#imageHeight"
///     size_t imageDepth; // @link substring="imageDepth" target="#imageDepth"
///     size_t imageArraySize; // @link substring="imageArraySize" target="#imageArraySize"
///     size_t imageRowPitch; // @link substring="imageRowPitch" target="#imageRowPitch"
///     size_t imageSlicePitch; // @link substring="imageSlicePitch" target="#imageSlicePitch"
///     cl_uint numMipLevels; // @link substring="numMipLevels" target="#numMipLevels"
///     cl_uint numSamples; // @link substring="numSamples" target="#numSamples"
///     cl_image_desc_buffer_or_mem_object bufferOrMemObject; // @link substring="CLImageDescBufferOrMemObject" target="CLImageDescBufferOrMemObject" @link substring="bufferOrMemObject" target="#bufferOrMemObject"
/// } cl_image_desc;
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
/// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_image_desc.html">cl_image_desc</a>
@ValueBasedCandidate
@UnsafeConstructor
public record CLImageDesc(@NotNull MemorySegment segment) implements ICLImageDesc {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_image_desc.html">cl_image_desc</a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link CLImageDesc}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// ICLImageDesc to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code CLImageDesc.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements ICLImageDesc, Iterable<CLImageDesc> {
        public long size() {
            return segment.byteSize() / CLImageDesc.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull CLImageDesc at(long index) {
            return new CLImageDesc(segment.asSlice(index * CLImageDesc.BYTES, CLImageDesc.BYTES));
        }

        public CLImageDesc.Ptr at(long index, @NotNull Consumer<@NotNull CLImageDesc> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull CLImageDesc value) {
            MemorySegment s = segment.asSlice(index * CLImageDesc.BYTES, CLImageDesc.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * CLImageDesc.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * CLImageDesc.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * CLImageDesc.BYTES,
                (end - start) * CLImageDesc.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * CLImageDesc.BYTES));
        }

        public CLImageDesc[] toArray() {
            CLImageDesc[] ret = new CLImageDesc[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<CLImageDesc> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<CLImageDesc> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= CLImageDesc.BYTES;
            }

            @Override
            public CLImageDesc next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                CLImageDesc ret = new CLImageDesc(segment.asSlice(0, CLImageDesc.BYTES));
                segment = segment.asSlice(CLImageDesc.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static CLImageDesc allocate(Arena arena) {
        return new CLImageDesc(arena.allocate(LAYOUT));
    }

    public static CLImageDesc.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new CLImageDesc.Ptr(segment);
    }

    public static CLImageDesc clone(Arena arena, CLImageDesc src) {
        CLImageDesc ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NativeType("cl_mem_object_type") @Unsigned int imageType() {
        return segment.get(LAYOUT$imageType, OFFSET$imageType);
    }

    public CLImageDesc imageType(@NativeType("cl_mem_object_type") @Unsigned int value) {
        segment.set(LAYOUT$imageType, OFFSET$imageType, value);
        return this;
    }

    public @Unsigned long imageWidth() {
        return NativeLayout.readCSizeT(segment, OFFSET$imageWidth);
    }

    public CLImageDesc imageWidth(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$imageWidth, value);
        return this;
    }

    public @Unsigned long imageHeight() {
        return NativeLayout.readCSizeT(segment, OFFSET$imageHeight);
    }

    public CLImageDesc imageHeight(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$imageHeight, value);
        return this;
    }

    public @Unsigned long imageDepth() {
        return NativeLayout.readCSizeT(segment, OFFSET$imageDepth);
    }

    public CLImageDesc imageDepth(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$imageDepth, value);
        return this;
    }

    public @Unsigned long imageArraySize() {
        return NativeLayout.readCSizeT(segment, OFFSET$imageArraySize);
    }

    public CLImageDesc imageArraySize(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$imageArraySize, value);
        return this;
    }

    public @Unsigned long imageRowPitch() {
        return NativeLayout.readCSizeT(segment, OFFSET$imageRowPitch);
    }

    public CLImageDesc imageRowPitch(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$imageRowPitch, value);
        return this;
    }

    public @Unsigned long imageSlicePitch() {
        return NativeLayout.readCSizeT(segment, OFFSET$imageSlicePitch);
    }

    public CLImageDesc imageSlicePitch(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$imageSlicePitch, value);
        return this;
    }

    public @NativeType("cl_uint") @Unsigned int numMipLevels() {
        return segment.get(LAYOUT$numMipLevels, OFFSET$numMipLevels);
    }

    public CLImageDesc numMipLevels(@NativeType("cl_uint") @Unsigned int value) {
        segment.set(LAYOUT$numMipLevels, OFFSET$numMipLevels, value);
        return this;
    }

    public @NativeType("cl_uint") @Unsigned int numSamples() {
        return segment.get(LAYOUT$numSamples, OFFSET$numSamples);
    }

    public CLImageDesc numSamples(@NativeType("cl_uint") @Unsigned int value) {
        segment.set(LAYOUT$numSamples, OFFSET$numSamples, value);
        return this;
    }

    public @NotNull CLImageDescBufferOrMemObject bufferOrMemObject() {
        return new CLImageDescBufferOrMemObject(segment.asSlice(OFFSET$bufferOrMemObject, LAYOUT$bufferOrMemObject));
    }

    public CLImageDesc bufferOrMemObject(@NotNull CLImageDescBufferOrMemObject value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$bufferOrMemObject, SIZE$bufferOrMemObject);
        return this;
    }

    public CLImageDesc bufferOrMemObject(Consumer<@NotNull CLImageDescBufferOrMemObject> consumer) {
        consumer.accept(bufferOrMemObject());
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("imageType"),
        NativeLayout.C_SIZE_T.withName("imageWidth"),
        NativeLayout.C_SIZE_T.withName("imageHeight"),
        NativeLayout.C_SIZE_T.withName("imageDepth"),
        NativeLayout.C_SIZE_T.withName("imageArraySize"),
        NativeLayout.C_SIZE_T.withName("imageRowPitch"),
        NativeLayout.C_SIZE_T.withName("imageSlicePitch"),
        ValueLayout.JAVA_INT.withName("numMipLevels"),
        ValueLayout.JAVA_INT.withName("numSamples"),
        CLImageDescBufferOrMemObject.LAYOUT.withName("bufferOrMemObject")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$imageType = PathElement.groupElement("imageType");
    public static final PathElement PATH$imageWidth = PathElement.groupElement("imageWidth");
    public static final PathElement PATH$imageHeight = PathElement.groupElement("imageHeight");
    public static final PathElement PATH$imageDepth = PathElement.groupElement("imageDepth");
    public static final PathElement PATH$imageArraySize = PathElement.groupElement("imageArraySize");
    public static final PathElement PATH$imageRowPitch = PathElement.groupElement("imageRowPitch");
    public static final PathElement PATH$imageSlicePitch = PathElement.groupElement("imageSlicePitch");
    public static final PathElement PATH$numMipLevels = PathElement.groupElement("numMipLevels");
    public static final PathElement PATH$numSamples = PathElement.groupElement("numSamples");
    public static final PathElement PATH$bufferOrMemObject = PathElement.groupElement("bufferOrMemObject");

    public static final OfInt LAYOUT$imageType = (OfInt) LAYOUT.select(PATH$imageType);
    public static final OfInt LAYOUT$numMipLevels = (OfInt) LAYOUT.select(PATH$numMipLevels);
    public static final OfInt LAYOUT$numSamples = (OfInt) LAYOUT.select(PATH$numSamples);
    public static final UnionLayout LAYOUT$bufferOrMemObject = (UnionLayout) LAYOUT.select(PATH$bufferOrMemObject);

    public static final long SIZE$imageType = LAYOUT$imageType.byteSize();
    public static final long SIZE$imageWidth = NativeLayout.C_SIZE_T.byteSize();
    public static final long SIZE$imageHeight = NativeLayout.C_SIZE_T.byteSize();
    public static final long SIZE$imageDepth = NativeLayout.C_SIZE_T.byteSize();
    public static final long SIZE$imageArraySize = NativeLayout.C_SIZE_T.byteSize();
    public static final long SIZE$imageRowPitch = NativeLayout.C_SIZE_T.byteSize();
    public static final long SIZE$imageSlicePitch = NativeLayout.C_SIZE_T.byteSize();
    public static final long SIZE$numMipLevels = LAYOUT$numMipLevels.byteSize();
    public static final long SIZE$numSamples = LAYOUT$numSamples.byteSize();
    public static final long SIZE$bufferOrMemObject = LAYOUT$bufferOrMemObject.byteSize();

    public static final long OFFSET$imageType = LAYOUT.byteOffset(PATH$imageType);
    public static final long OFFSET$imageWidth = LAYOUT.byteOffset(PATH$imageWidth);
    public static final long OFFSET$imageHeight = LAYOUT.byteOffset(PATH$imageHeight);
    public static final long OFFSET$imageDepth = LAYOUT.byteOffset(PATH$imageDepth);
    public static final long OFFSET$imageArraySize = LAYOUT.byteOffset(PATH$imageArraySize);
    public static final long OFFSET$imageRowPitch = LAYOUT.byteOffset(PATH$imageRowPitch);
    public static final long OFFSET$imageSlicePitch = LAYOUT.byteOffset(PATH$imageSlicePitch);
    public static final long OFFSET$numMipLevels = LAYOUT.byteOffset(PATH$numMipLevels);
    public static final long OFFSET$numSamples = LAYOUT.byteOffset(PATH$numSamples);
    public static final long OFFSET$bufferOrMemObject = LAYOUT.byteOffset(PATH$bufferOrMemObject);
}
