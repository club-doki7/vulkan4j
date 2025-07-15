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

/// Represents a pointer to a <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_device_integer_dot_product_acceleration_properties_khr.html">cl_device_integer_dot_product_acceleration_properties_khr</a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct cl_device_integer_dot_product_acceleration_properties_khr {
///     cl_bool signedAccelerated; // @link substring="signedAccelerated" target="#signedAccelerated"
///     cl_bool unsignedAccelerated; // @link substring="unsignedAccelerated" target="#unsignedAccelerated"
///     cl_bool mixedSignednessAccelerated; // @link substring="mixedSignednessAccelerated" target="#mixedSignednessAccelerated"
///     cl_bool accumulatingSaturatingSignedAccelerated; // @link substring="accumulatingSaturatingSignedAccelerated" target="#accumulatingSaturatingSignedAccelerated"
///     cl_bool accumulatingSaturatingUnsignedAccelerated; // @link substring="accumulatingSaturatingUnsignedAccelerated" target="#accumulatingSaturatingUnsignedAccelerated"
///     cl_bool accumulatingSaturatingMixedSignednessAccelerated; // @link substring="accumulatingSaturatingMixedSignednessAccelerated" target="#accumulatingSaturatingMixedSignednessAccelerated"
/// } cl_device_integer_dot_product_acceleration_properties_khr;
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
/// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_device_integer_dot_product_acceleration_properties_khr.html">cl_device_integer_dot_product_acceleration_properties_khr</a>
@ValueBasedCandidate
@UnsafeConstructor
public record CLDeviceIntegerDotProductAccelerationPropertiesKhr(@NotNull MemorySegment segment) implements ICLDeviceIntegerDotProductAccelerationPropertiesKhr {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_device_integer_dot_product_acceleration_properties_khr.html">cl_device_integer_dot_product_acceleration_properties_khr</a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link CLDeviceIntegerDotProductAccelerationPropertiesKhr}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// ICLDeviceIntegerDotProductAccelerationPropertiesKhr to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code CLDeviceIntegerDotProductAccelerationPropertiesKhr.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements ICLDeviceIntegerDotProductAccelerationPropertiesKhr, Iterable<CLDeviceIntegerDotProductAccelerationPropertiesKhr> {
        public long size() {
            return segment.byteSize() / CLDeviceIntegerDotProductAccelerationPropertiesKhr.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull CLDeviceIntegerDotProductAccelerationPropertiesKhr at(long index) {
            return new CLDeviceIntegerDotProductAccelerationPropertiesKhr(segment.asSlice(index * CLDeviceIntegerDotProductAccelerationPropertiesKhr.BYTES, CLDeviceIntegerDotProductAccelerationPropertiesKhr.BYTES));
        }

        public CLDeviceIntegerDotProductAccelerationPropertiesKhr.Ptr at(long index, @NotNull Consumer<@NotNull CLDeviceIntegerDotProductAccelerationPropertiesKhr> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull CLDeviceIntegerDotProductAccelerationPropertiesKhr value) {
            MemorySegment s = segment.asSlice(index * CLDeviceIntegerDotProductAccelerationPropertiesKhr.BYTES, CLDeviceIntegerDotProductAccelerationPropertiesKhr.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * CLDeviceIntegerDotProductAccelerationPropertiesKhr.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * CLDeviceIntegerDotProductAccelerationPropertiesKhr.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * CLDeviceIntegerDotProductAccelerationPropertiesKhr.BYTES,
                (end - start) * CLDeviceIntegerDotProductAccelerationPropertiesKhr.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * CLDeviceIntegerDotProductAccelerationPropertiesKhr.BYTES));
        }

        public CLDeviceIntegerDotProductAccelerationPropertiesKhr[] toArray() {
            CLDeviceIntegerDotProductAccelerationPropertiesKhr[] ret = new CLDeviceIntegerDotProductAccelerationPropertiesKhr[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<CLDeviceIntegerDotProductAccelerationPropertiesKhr> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<CLDeviceIntegerDotProductAccelerationPropertiesKhr> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= CLDeviceIntegerDotProductAccelerationPropertiesKhr.BYTES;
            }

            @Override
            public CLDeviceIntegerDotProductAccelerationPropertiesKhr next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                CLDeviceIntegerDotProductAccelerationPropertiesKhr ret = new CLDeviceIntegerDotProductAccelerationPropertiesKhr(segment.asSlice(0, CLDeviceIntegerDotProductAccelerationPropertiesKhr.BYTES));
                segment = segment.asSlice(CLDeviceIntegerDotProductAccelerationPropertiesKhr.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static CLDeviceIntegerDotProductAccelerationPropertiesKhr allocate(Arena arena) {
        return new CLDeviceIntegerDotProductAccelerationPropertiesKhr(arena.allocate(LAYOUT));
    }

    public static CLDeviceIntegerDotProductAccelerationPropertiesKhr.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new CLDeviceIntegerDotProductAccelerationPropertiesKhr.Ptr(segment);
    }

    public static CLDeviceIntegerDotProductAccelerationPropertiesKhr clone(Arena arena, CLDeviceIntegerDotProductAccelerationPropertiesKhr src) {
        CLDeviceIntegerDotProductAccelerationPropertiesKhr ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NativeType("cl_bool") @Unsigned int signedAccelerated() {
        return segment.get(LAYOUT$signedAccelerated, OFFSET$signedAccelerated);
    }

    public CLDeviceIntegerDotProductAccelerationPropertiesKhr signedAccelerated(@NativeType("cl_bool") @Unsigned int value) {
        segment.set(LAYOUT$signedAccelerated, OFFSET$signedAccelerated, value);
        return this;
    }

    public @NativeType("cl_bool") @Unsigned int unsignedAccelerated() {
        return segment.get(LAYOUT$unsignedAccelerated, OFFSET$unsignedAccelerated);
    }

    public CLDeviceIntegerDotProductAccelerationPropertiesKhr unsignedAccelerated(@NativeType("cl_bool") @Unsigned int value) {
        segment.set(LAYOUT$unsignedAccelerated, OFFSET$unsignedAccelerated, value);
        return this;
    }

    public @NativeType("cl_bool") @Unsigned int mixedSignednessAccelerated() {
        return segment.get(LAYOUT$mixedSignednessAccelerated, OFFSET$mixedSignednessAccelerated);
    }

    public CLDeviceIntegerDotProductAccelerationPropertiesKhr mixedSignednessAccelerated(@NativeType("cl_bool") @Unsigned int value) {
        segment.set(LAYOUT$mixedSignednessAccelerated, OFFSET$mixedSignednessAccelerated, value);
        return this;
    }

    public @NativeType("cl_bool") @Unsigned int accumulatingSaturatingSignedAccelerated() {
        return segment.get(LAYOUT$accumulatingSaturatingSignedAccelerated, OFFSET$accumulatingSaturatingSignedAccelerated);
    }

    public CLDeviceIntegerDotProductAccelerationPropertiesKhr accumulatingSaturatingSignedAccelerated(@NativeType("cl_bool") @Unsigned int value) {
        segment.set(LAYOUT$accumulatingSaturatingSignedAccelerated, OFFSET$accumulatingSaturatingSignedAccelerated, value);
        return this;
    }

    public @NativeType("cl_bool") @Unsigned int accumulatingSaturatingUnsignedAccelerated() {
        return segment.get(LAYOUT$accumulatingSaturatingUnsignedAccelerated, OFFSET$accumulatingSaturatingUnsignedAccelerated);
    }

    public CLDeviceIntegerDotProductAccelerationPropertiesKhr accumulatingSaturatingUnsignedAccelerated(@NativeType("cl_bool") @Unsigned int value) {
        segment.set(LAYOUT$accumulatingSaturatingUnsignedAccelerated, OFFSET$accumulatingSaturatingUnsignedAccelerated, value);
        return this;
    }

    public @NativeType("cl_bool") @Unsigned int accumulatingSaturatingMixedSignednessAccelerated() {
        return segment.get(LAYOUT$accumulatingSaturatingMixedSignednessAccelerated, OFFSET$accumulatingSaturatingMixedSignednessAccelerated);
    }

    public CLDeviceIntegerDotProductAccelerationPropertiesKhr accumulatingSaturatingMixedSignednessAccelerated(@NativeType("cl_bool") @Unsigned int value) {
        segment.set(LAYOUT$accumulatingSaturatingMixedSignednessAccelerated, OFFSET$accumulatingSaturatingMixedSignednessAccelerated, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("signedAccelerated"),
        ValueLayout.JAVA_INT.withName("unsignedAccelerated"),
        ValueLayout.JAVA_INT.withName("mixedSignednessAccelerated"),
        ValueLayout.JAVA_INT.withName("accumulatingSaturatingSignedAccelerated"),
        ValueLayout.JAVA_INT.withName("accumulatingSaturatingUnsignedAccelerated"),
        ValueLayout.JAVA_INT.withName("accumulatingSaturatingMixedSignednessAccelerated")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$signedAccelerated = PathElement.groupElement("signedAccelerated");
    public static final PathElement PATH$unsignedAccelerated = PathElement.groupElement("unsignedAccelerated");
    public static final PathElement PATH$mixedSignednessAccelerated = PathElement.groupElement("mixedSignednessAccelerated");
    public static final PathElement PATH$accumulatingSaturatingSignedAccelerated = PathElement.groupElement("accumulatingSaturatingSignedAccelerated");
    public static final PathElement PATH$accumulatingSaturatingUnsignedAccelerated = PathElement.groupElement("accumulatingSaturatingUnsignedAccelerated");
    public static final PathElement PATH$accumulatingSaturatingMixedSignednessAccelerated = PathElement.groupElement("accumulatingSaturatingMixedSignednessAccelerated");

    public static final OfInt LAYOUT$signedAccelerated = (OfInt) LAYOUT.select(PATH$signedAccelerated);
    public static final OfInt LAYOUT$unsignedAccelerated = (OfInt) LAYOUT.select(PATH$unsignedAccelerated);
    public static final OfInt LAYOUT$mixedSignednessAccelerated = (OfInt) LAYOUT.select(PATH$mixedSignednessAccelerated);
    public static final OfInt LAYOUT$accumulatingSaturatingSignedAccelerated = (OfInt) LAYOUT.select(PATH$accumulatingSaturatingSignedAccelerated);
    public static final OfInt LAYOUT$accumulatingSaturatingUnsignedAccelerated = (OfInt) LAYOUT.select(PATH$accumulatingSaturatingUnsignedAccelerated);
    public static final OfInt LAYOUT$accumulatingSaturatingMixedSignednessAccelerated = (OfInt) LAYOUT.select(PATH$accumulatingSaturatingMixedSignednessAccelerated);

    public static final long SIZE$signedAccelerated = LAYOUT$signedAccelerated.byteSize();
    public static final long SIZE$unsignedAccelerated = LAYOUT$unsignedAccelerated.byteSize();
    public static final long SIZE$mixedSignednessAccelerated = LAYOUT$mixedSignednessAccelerated.byteSize();
    public static final long SIZE$accumulatingSaturatingSignedAccelerated = LAYOUT$accumulatingSaturatingSignedAccelerated.byteSize();
    public static final long SIZE$accumulatingSaturatingUnsignedAccelerated = LAYOUT$accumulatingSaturatingUnsignedAccelerated.byteSize();
    public static final long SIZE$accumulatingSaturatingMixedSignednessAccelerated = LAYOUT$accumulatingSaturatingMixedSignednessAccelerated.byteSize();

    public static final long OFFSET$signedAccelerated = LAYOUT.byteOffset(PATH$signedAccelerated);
    public static final long OFFSET$unsignedAccelerated = LAYOUT.byteOffset(PATH$unsignedAccelerated);
    public static final long OFFSET$mixedSignednessAccelerated = LAYOUT.byteOffset(PATH$mixedSignednessAccelerated);
    public static final long OFFSET$accumulatingSaturatingSignedAccelerated = LAYOUT.byteOffset(PATH$accumulatingSaturatingSignedAccelerated);
    public static final long OFFSET$accumulatingSaturatingUnsignedAccelerated = LAYOUT.byteOffset(PATH$accumulatingSaturatingUnsignedAccelerated);
    public static final long OFFSET$accumulatingSaturatingMixedSignednessAccelerated = LAYOUT.byteOffset(PATH$accumulatingSaturatingMixedSignednessAccelerated);
}
