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

/// Represents a pointer to a <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_queue_family_properties_intel.html">cl_queue_family_properties_intel</a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct cl_queue_family_properties_intel {
///     cl_command_queue_properties properties; // @link substring="properties" target="#properties"
///     cl_command_queue_capabilities_intel capabilities; // @link substring="capabilities" target="#capabilities"
///     cl_uint count; // @link substring="count" target="#count"
///     char[CL_QUEUE_FAMILY_MAX_NAME_SIZE_INTEL] name; // @link substring="name" target="#name"
/// } cl_queue_family_properties_intel;
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
/// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_queue_family_properties_intel.html">cl_queue_family_properties_intel</a>
@ValueBasedCandidate
@UnsafeConstructor
public record CLQueueFamilyPropertiesIntel(@NotNull MemorySegment segment) implements ICLQueueFamilyPropertiesIntel {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_queue_family_properties_intel.html">cl_queue_family_properties_intel</a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link CLQueueFamilyPropertiesIntel}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// ICLQueueFamilyPropertiesIntel to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code CLQueueFamilyPropertiesIntel.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements ICLQueueFamilyPropertiesIntel, Iterable<CLQueueFamilyPropertiesIntel> {
        public long size() {
            return segment.byteSize() / CLQueueFamilyPropertiesIntel.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull CLQueueFamilyPropertiesIntel at(long index) {
            return new CLQueueFamilyPropertiesIntel(segment.asSlice(index * CLQueueFamilyPropertiesIntel.BYTES, CLQueueFamilyPropertiesIntel.BYTES));
        }

        public CLQueueFamilyPropertiesIntel.Ptr at(long index, @NotNull Consumer<@NotNull CLQueueFamilyPropertiesIntel> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull CLQueueFamilyPropertiesIntel value) {
            MemorySegment s = segment.asSlice(index * CLQueueFamilyPropertiesIntel.BYTES, CLQueueFamilyPropertiesIntel.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * CLQueueFamilyPropertiesIntel.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * CLQueueFamilyPropertiesIntel.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * CLQueueFamilyPropertiesIntel.BYTES,
                (end - start) * CLQueueFamilyPropertiesIntel.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * CLQueueFamilyPropertiesIntel.BYTES));
        }

        public CLQueueFamilyPropertiesIntel[] toArray() {
            CLQueueFamilyPropertiesIntel[] ret = new CLQueueFamilyPropertiesIntel[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<CLQueueFamilyPropertiesIntel> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<CLQueueFamilyPropertiesIntel> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= CLQueueFamilyPropertiesIntel.BYTES;
            }

            @Override
            public CLQueueFamilyPropertiesIntel next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                CLQueueFamilyPropertiesIntel ret = new CLQueueFamilyPropertiesIntel(segment.asSlice(0, CLQueueFamilyPropertiesIntel.BYTES));
                segment = segment.asSlice(CLQueueFamilyPropertiesIntel.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static CLQueueFamilyPropertiesIntel allocate(Arena arena) {
        return new CLQueueFamilyPropertiesIntel(arena.allocate(LAYOUT));
    }

    public static CLQueueFamilyPropertiesIntel.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new CLQueueFamilyPropertiesIntel.Ptr(segment);
    }

    public static CLQueueFamilyPropertiesIntel clone(Arena arena, CLQueueFamilyPropertiesIntel src) {
        CLQueueFamilyPropertiesIntel ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NativeType("cl_command_queue_properties") @Unsigned long properties() {
        return segment.get(LAYOUT$properties, OFFSET$properties);
    }

    public CLQueueFamilyPropertiesIntel properties(@NativeType("cl_command_queue_properties") @Unsigned long value) {
        segment.set(LAYOUT$properties, OFFSET$properties, value);
        return this;
    }

    public @NativeType("cl_command_queue_capabilities_intel") @Unsigned long capabilities() {
        return segment.get(LAYOUT$capabilities, OFFSET$capabilities);
    }

    public CLQueueFamilyPropertiesIntel capabilities(@NativeType("cl_command_queue_capabilities_intel") @Unsigned long value) {
        segment.set(LAYOUT$capabilities, OFFSET$capabilities, value);
        return this;
    }

    public @NativeType("cl_uint") @Unsigned int count() {
        return segment.get(LAYOUT$count, OFFSET$count);
    }

    public CLQueueFamilyPropertiesIntel count(@NativeType("cl_uint") @Unsigned int value) {
        segment.set(LAYOUT$count, OFFSET$count, value);
        return this;
    }

    public BytePtr name() {
        return new BytePtr(nameRaw());
    }

    public CLQueueFamilyPropertiesIntel name(@NotNull Consumer<BytePtr> consumer) {
        BytePtr ptr = name();
        consumer.accept(ptr);
        return this;
    }

    public CLQueueFamilyPropertiesIntel name(BytePtr value) {
        MemorySegment s = nameRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment nameRaw() {
        return segment.asSlice(OFFSET$name, SIZE$name);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_LONG.withName("properties"),
        ValueLayout.JAVA_LONG.withName("capabilities"),
        ValueLayout.JAVA_INT.withName("count"),
        MemoryLayout.sequenceLayout(QUEUE_FAMILY_MAX_NAME_SIZE_INTEL, ValueLayout.JAVA_BYTE).withName("name")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$properties = PathElement.groupElement("properties");
    public static final PathElement PATH$capabilities = PathElement.groupElement("capabilities");
    public static final PathElement PATH$count = PathElement.groupElement("count");
    public static final PathElement PATH$name = PathElement.groupElement("name");

    public static final OfLong LAYOUT$properties = (OfLong) LAYOUT.select(PATH$properties);
    public static final OfLong LAYOUT$capabilities = (OfLong) LAYOUT.select(PATH$capabilities);
    public static final OfInt LAYOUT$count = (OfInt) LAYOUT.select(PATH$count);
    public static final SequenceLayout LAYOUT$name = (SequenceLayout) LAYOUT.select(PATH$name);

    public static final long SIZE$properties = LAYOUT$properties.byteSize();
    public static final long SIZE$capabilities = LAYOUT$capabilities.byteSize();
    public static final long SIZE$count = LAYOUT$count.byteSize();
    public static final long SIZE$name = LAYOUT$name.byteSize();

    public static final long OFFSET$properties = LAYOUT.byteOffset(PATH$properties);
    public static final long OFFSET$capabilities = LAYOUT.byteOffset(PATH$capabilities);
    public static final long OFFSET$count = LAYOUT.byteOffset(PATH$count);
    public static final long OFFSET$name = LAYOUT.byteOffset(PATH$name);
}
