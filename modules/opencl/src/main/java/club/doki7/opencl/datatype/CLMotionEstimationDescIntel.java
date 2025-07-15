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

/// Represents a pointer to a <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_motion_estimation_desc_intel.html">cl_motion_estimation_desc_intel</a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct cl_motion_estimation_desc_intel {
///     cl_uint mbBlockType; // @link substring="mbBlockType" target="#mbBlockType"
///     cl_uint subpixelMode; // @link substring="subpixelMode" target="#subpixelMode"
///     cl_uint sadAdjustMode; // @link substring="sadAdjustMode" target="#sadAdjustMode"
///     cl_uint searchPathType; // @link substring="searchPathType" target="#searchPathType"
/// } cl_motion_estimation_desc_intel;
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
/// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_motion_estimation_desc_intel.html">cl_motion_estimation_desc_intel</a>
@ValueBasedCandidate
@UnsafeConstructor
public record CLMotionEstimationDescIntel(@NotNull MemorySegment segment) implements ICLMotionEstimationDescIntel {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_motion_estimation_desc_intel.html">cl_motion_estimation_desc_intel</a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link CLMotionEstimationDescIntel}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// ICLMotionEstimationDescIntel to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code CLMotionEstimationDescIntel.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements ICLMotionEstimationDescIntel, Iterable<CLMotionEstimationDescIntel> {
        public long size() {
            return segment.byteSize() / CLMotionEstimationDescIntel.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull CLMotionEstimationDescIntel at(long index) {
            return new CLMotionEstimationDescIntel(segment.asSlice(index * CLMotionEstimationDescIntel.BYTES, CLMotionEstimationDescIntel.BYTES));
        }

        public CLMotionEstimationDescIntel.Ptr at(long index, @NotNull Consumer<@NotNull CLMotionEstimationDescIntel> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull CLMotionEstimationDescIntel value) {
            MemorySegment s = segment.asSlice(index * CLMotionEstimationDescIntel.BYTES, CLMotionEstimationDescIntel.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * CLMotionEstimationDescIntel.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * CLMotionEstimationDescIntel.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * CLMotionEstimationDescIntel.BYTES,
                (end - start) * CLMotionEstimationDescIntel.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * CLMotionEstimationDescIntel.BYTES));
        }

        public CLMotionEstimationDescIntel[] toArray() {
            CLMotionEstimationDescIntel[] ret = new CLMotionEstimationDescIntel[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<CLMotionEstimationDescIntel> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<CLMotionEstimationDescIntel> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= CLMotionEstimationDescIntel.BYTES;
            }

            @Override
            public CLMotionEstimationDescIntel next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                CLMotionEstimationDescIntel ret = new CLMotionEstimationDescIntel(segment.asSlice(0, CLMotionEstimationDescIntel.BYTES));
                segment = segment.asSlice(CLMotionEstimationDescIntel.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static CLMotionEstimationDescIntel allocate(Arena arena) {
        return new CLMotionEstimationDescIntel(arena.allocate(LAYOUT));
    }

    public static CLMotionEstimationDescIntel.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new CLMotionEstimationDescIntel.Ptr(segment);
    }

    public static CLMotionEstimationDescIntel clone(Arena arena, CLMotionEstimationDescIntel src) {
        CLMotionEstimationDescIntel ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NativeType("cl_uint") @Unsigned int mbBlockType() {
        return segment.get(LAYOUT$mbBlockType, OFFSET$mbBlockType);
    }

    public CLMotionEstimationDescIntel mbBlockType(@NativeType("cl_uint") @Unsigned int value) {
        segment.set(LAYOUT$mbBlockType, OFFSET$mbBlockType, value);
        return this;
    }

    public @NativeType("cl_uint") @Unsigned int subpixelMode() {
        return segment.get(LAYOUT$subpixelMode, OFFSET$subpixelMode);
    }

    public CLMotionEstimationDescIntel subpixelMode(@NativeType("cl_uint") @Unsigned int value) {
        segment.set(LAYOUT$subpixelMode, OFFSET$subpixelMode, value);
        return this;
    }

    public @NativeType("cl_uint") @Unsigned int sadAdjustMode() {
        return segment.get(LAYOUT$sadAdjustMode, OFFSET$sadAdjustMode);
    }

    public CLMotionEstimationDescIntel sadAdjustMode(@NativeType("cl_uint") @Unsigned int value) {
        segment.set(LAYOUT$sadAdjustMode, OFFSET$sadAdjustMode, value);
        return this;
    }

    public @NativeType("cl_uint") @Unsigned int searchPathType() {
        return segment.get(LAYOUT$searchPathType, OFFSET$searchPathType);
    }

    public CLMotionEstimationDescIntel searchPathType(@NativeType("cl_uint") @Unsigned int value) {
        segment.set(LAYOUT$searchPathType, OFFSET$searchPathType, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("mbBlockType"),
        ValueLayout.JAVA_INT.withName("subpixelMode"),
        ValueLayout.JAVA_INT.withName("sadAdjustMode"),
        ValueLayout.JAVA_INT.withName("searchPathType")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$mbBlockType = PathElement.groupElement("mbBlockType");
    public static final PathElement PATH$subpixelMode = PathElement.groupElement("subpixelMode");
    public static final PathElement PATH$sadAdjustMode = PathElement.groupElement("sadAdjustMode");
    public static final PathElement PATH$searchPathType = PathElement.groupElement("searchPathType");

    public static final OfInt LAYOUT$mbBlockType = (OfInt) LAYOUT.select(PATH$mbBlockType);
    public static final OfInt LAYOUT$subpixelMode = (OfInt) LAYOUT.select(PATH$subpixelMode);
    public static final OfInt LAYOUT$sadAdjustMode = (OfInt) LAYOUT.select(PATH$sadAdjustMode);
    public static final OfInt LAYOUT$searchPathType = (OfInt) LAYOUT.select(PATH$searchPathType);

    public static final long SIZE$mbBlockType = LAYOUT$mbBlockType.byteSize();
    public static final long SIZE$subpixelMode = LAYOUT$subpixelMode.byteSize();
    public static final long SIZE$sadAdjustMode = LAYOUT$sadAdjustMode.byteSize();
    public static final long SIZE$searchPathType = LAYOUT$searchPathType.byteSize();

    public static final long OFFSET$mbBlockType = LAYOUT.byteOffset(PATH$mbBlockType);
    public static final long OFFSET$subpixelMode = LAYOUT.byteOffset(PATH$subpixelMode);
    public static final long OFFSET$sadAdjustMode = LAYOUT.byteOffset(PATH$sadAdjustMode);
    public static final long OFFSET$searchPathType = LAYOUT.byteOffset(PATH$searchPathType);
}
