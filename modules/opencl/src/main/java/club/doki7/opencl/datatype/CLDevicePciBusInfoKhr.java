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

/// Represents a pointer to a <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_device_pci_bus_info_khr.html">cl_device_pci_bus_info_khr</a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct cl_device_pci_bus_info_khr {
///     cl_uint pciDomain; // @link substring="pciDomain" target="#pciDomain"
///     cl_uint pciBus; // @link substring="pciBus" target="#pciBus"
///     cl_uint pciDevice; // @link substring="pciDevice" target="#pciDevice"
///     cl_uint pciFunction; // @link substring="pciFunction" target="#pciFunction"
/// } cl_device_pci_bus_info_khr;
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
/// @see <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_device_pci_bus_info_khr.html">cl_device_pci_bus_info_khr</a>
@ValueBasedCandidate
@UnsafeConstructor
public record CLDevicePciBusInfoKhr(@NotNull MemorySegment segment) implements ICLDevicePciBusInfoKhr {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/OpenCL/sdk/latest/docs/man/html/cl_device_pci_bus_info_khr.html">cl_device_pci_bus_info_khr</a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link CLDevicePciBusInfoKhr}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// ICLDevicePciBusInfoKhr to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code CLDevicePciBusInfoKhr.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements ICLDevicePciBusInfoKhr, Iterable<CLDevicePciBusInfoKhr> {
        public long size() {
            return segment.byteSize() / CLDevicePciBusInfoKhr.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull CLDevicePciBusInfoKhr at(long index) {
            return new CLDevicePciBusInfoKhr(segment.asSlice(index * CLDevicePciBusInfoKhr.BYTES, CLDevicePciBusInfoKhr.BYTES));
        }

        public CLDevicePciBusInfoKhr.Ptr at(long index, @NotNull Consumer<@NotNull CLDevicePciBusInfoKhr> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull CLDevicePciBusInfoKhr value) {
            MemorySegment s = segment.asSlice(index * CLDevicePciBusInfoKhr.BYTES, CLDevicePciBusInfoKhr.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * CLDevicePciBusInfoKhr.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * CLDevicePciBusInfoKhr.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * CLDevicePciBusInfoKhr.BYTES,
                (end - start) * CLDevicePciBusInfoKhr.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * CLDevicePciBusInfoKhr.BYTES));
        }

        public CLDevicePciBusInfoKhr[] toArray() {
            CLDevicePciBusInfoKhr[] ret = new CLDevicePciBusInfoKhr[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<CLDevicePciBusInfoKhr> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<CLDevicePciBusInfoKhr> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= CLDevicePciBusInfoKhr.BYTES;
            }

            @Override
            public CLDevicePciBusInfoKhr next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                CLDevicePciBusInfoKhr ret = new CLDevicePciBusInfoKhr(segment.asSlice(0, CLDevicePciBusInfoKhr.BYTES));
                segment = segment.asSlice(CLDevicePciBusInfoKhr.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static CLDevicePciBusInfoKhr allocate(Arena arena) {
        return new CLDevicePciBusInfoKhr(arena.allocate(LAYOUT));
    }

    public static CLDevicePciBusInfoKhr.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new CLDevicePciBusInfoKhr.Ptr(segment);
    }

    public static CLDevicePciBusInfoKhr clone(Arena arena, CLDevicePciBusInfoKhr src) {
        CLDevicePciBusInfoKhr ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NativeType("cl_uint") @Unsigned int pciDomain() {
        return segment.get(LAYOUT$pciDomain, OFFSET$pciDomain);
    }

    public CLDevicePciBusInfoKhr pciDomain(@NativeType("cl_uint") @Unsigned int value) {
        segment.set(LAYOUT$pciDomain, OFFSET$pciDomain, value);
        return this;
    }

    public @NativeType("cl_uint") @Unsigned int pciBus() {
        return segment.get(LAYOUT$pciBus, OFFSET$pciBus);
    }

    public CLDevicePciBusInfoKhr pciBus(@NativeType("cl_uint") @Unsigned int value) {
        segment.set(LAYOUT$pciBus, OFFSET$pciBus, value);
        return this;
    }

    public @NativeType("cl_uint") @Unsigned int pciDevice() {
        return segment.get(LAYOUT$pciDevice, OFFSET$pciDevice);
    }

    public CLDevicePciBusInfoKhr pciDevice(@NativeType("cl_uint") @Unsigned int value) {
        segment.set(LAYOUT$pciDevice, OFFSET$pciDevice, value);
        return this;
    }

    public @NativeType("cl_uint") @Unsigned int pciFunction() {
        return segment.get(LAYOUT$pciFunction, OFFSET$pciFunction);
    }

    public CLDevicePciBusInfoKhr pciFunction(@NativeType("cl_uint") @Unsigned int value) {
        segment.set(LAYOUT$pciFunction, OFFSET$pciFunction, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("pciDomain"),
        ValueLayout.JAVA_INT.withName("pciBus"),
        ValueLayout.JAVA_INT.withName("pciDevice"),
        ValueLayout.JAVA_INT.withName("pciFunction")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$pciDomain = PathElement.groupElement("pciDomain");
    public static final PathElement PATH$pciBus = PathElement.groupElement("pciBus");
    public static final PathElement PATH$pciDevice = PathElement.groupElement("pciDevice");
    public static final PathElement PATH$pciFunction = PathElement.groupElement("pciFunction");

    public static final OfInt LAYOUT$pciDomain = (OfInt) LAYOUT.select(PATH$pciDomain);
    public static final OfInt LAYOUT$pciBus = (OfInt) LAYOUT.select(PATH$pciBus);
    public static final OfInt LAYOUT$pciDevice = (OfInt) LAYOUT.select(PATH$pciDevice);
    public static final OfInt LAYOUT$pciFunction = (OfInt) LAYOUT.select(PATH$pciFunction);

    public static final long SIZE$pciDomain = LAYOUT$pciDomain.byteSize();
    public static final long SIZE$pciBus = LAYOUT$pciBus.byteSize();
    public static final long SIZE$pciDevice = LAYOUT$pciDevice.byteSize();
    public static final long SIZE$pciFunction = LAYOUT$pciFunction.byteSize();

    public static final long OFFSET$pciDomain = LAYOUT.byteOffset(PATH$pciDomain);
    public static final long OFFSET$pciBus = LAYOUT.byteOffset(PATH$pciBus);
    public static final long OFFSET$pciDevice = LAYOUT.byteOffset(PATH$pciDevice);
    public static final long OFFSET$pciFunction = LAYOUT.byteOffset(PATH$pciFunction);
}
