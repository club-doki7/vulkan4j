package club.doki7.vulkan.datatype;

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
import club.doki7.vulkan.bitmask.*;
import club.doki7.vulkan.handle.*;
import club.doki7.vulkan.enumtype.*;
import static club.doki7.vulkan.VkConstants.*;
import club.doki7.vulkan.VkFunctionTypes.*;

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDevicePCIBusInfoPropertiesEXT.html"><code>VkPhysicalDevicePCIBusInfoPropertiesEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDevicePCIBusInfoPropertiesEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t pciDomain; // @link substring="pciDomain" target="#pciDomain"
///     uint32_t pciBus; // @link substring="pciBus" target="#pciBus"
///     uint32_t pciDevice; // @link substring="pciDevice" target="#pciDevice"
///     uint32_t pciFunction; // @link substring="pciFunction" target="#pciFunction"
/// } VkPhysicalDevicePCIBusInfoPropertiesEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_PCI_BUS_INFO_PROPERTIES_EXT`
///
/// The {@code allocate} ({@link VkPhysicalDevicePCIBusInfoPropertiesEXT#allocate(Arena)}, {@link VkPhysicalDevicePCIBusInfoPropertiesEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDevicePCIBusInfoPropertiesEXT#autoInit}
/// to initialize these fields manually for non-allocated instances.
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDevicePCIBusInfoPropertiesEXT.html"><code>VkPhysicalDevicePCIBusInfoPropertiesEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDevicePCIBusInfoPropertiesEXT(@NotNull MemorySegment segment) implements IVkPhysicalDevicePCIBusInfoPropertiesEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDevicePCIBusInfoPropertiesEXT.html"><code>VkPhysicalDevicePCIBusInfoPropertiesEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDevicePCIBusInfoPropertiesEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDevicePCIBusInfoPropertiesEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDevicePCIBusInfoPropertiesEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDevicePCIBusInfoPropertiesEXT, Iterable<VkPhysicalDevicePCIBusInfoPropertiesEXT> {
        public long size() {
            return segment.byteSize() / VkPhysicalDevicePCIBusInfoPropertiesEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDevicePCIBusInfoPropertiesEXT at(long index) {
            return new VkPhysicalDevicePCIBusInfoPropertiesEXT(segment.asSlice(index * VkPhysicalDevicePCIBusInfoPropertiesEXT.BYTES, VkPhysicalDevicePCIBusInfoPropertiesEXT.BYTES));
        }

        public VkPhysicalDevicePCIBusInfoPropertiesEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDevicePCIBusInfoPropertiesEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDevicePCIBusInfoPropertiesEXT value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDevicePCIBusInfoPropertiesEXT.BYTES, VkPhysicalDevicePCIBusInfoPropertiesEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDevicePCIBusInfoPropertiesEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDevicePCIBusInfoPropertiesEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDevicePCIBusInfoPropertiesEXT.BYTES,
                (end - start) * VkPhysicalDevicePCIBusInfoPropertiesEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDevicePCIBusInfoPropertiesEXT.BYTES));
        }

        public VkPhysicalDevicePCIBusInfoPropertiesEXT[] toArray() {
            VkPhysicalDevicePCIBusInfoPropertiesEXT[] ret = new VkPhysicalDevicePCIBusInfoPropertiesEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDevicePCIBusInfoPropertiesEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDevicePCIBusInfoPropertiesEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDevicePCIBusInfoPropertiesEXT.BYTES;
            }

            @Override
            public VkPhysicalDevicePCIBusInfoPropertiesEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDevicePCIBusInfoPropertiesEXT ret = new VkPhysicalDevicePCIBusInfoPropertiesEXT(segment.asSlice(0, VkPhysicalDevicePCIBusInfoPropertiesEXT.BYTES));
                segment = segment.asSlice(VkPhysicalDevicePCIBusInfoPropertiesEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDevicePCIBusInfoPropertiesEXT allocate(Arena arena) {
        VkPhysicalDevicePCIBusInfoPropertiesEXT ret = new VkPhysicalDevicePCIBusInfoPropertiesEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_PCI_BUS_INFO_PROPERTIES_EXT);
        return ret;
    }

    public static VkPhysicalDevicePCIBusInfoPropertiesEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDevicePCIBusInfoPropertiesEXT.Ptr ret = new VkPhysicalDevicePCIBusInfoPropertiesEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_PCI_BUS_INFO_PROPERTIES_EXT);
        }
        return ret;
    }

    public static VkPhysicalDevicePCIBusInfoPropertiesEXT clone(Arena arena, VkPhysicalDevicePCIBusInfoPropertiesEXT src) {
        VkPhysicalDevicePCIBusInfoPropertiesEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_PCI_BUS_INFO_PROPERTIES_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDevicePCIBusInfoPropertiesEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDevicePCIBusInfoPropertiesEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDevicePCIBusInfoPropertiesEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int pciDomain() {
        return segment.get(LAYOUT$pciDomain, OFFSET$pciDomain);
    }

    public VkPhysicalDevicePCIBusInfoPropertiesEXT pciDomain(@Unsigned int value) {
        segment.set(LAYOUT$pciDomain, OFFSET$pciDomain, value);
        return this;
    }

    public @Unsigned int pciBus() {
        return segment.get(LAYOUT$pciBus, OFFSET$pciBus);
    }

    public VkPhysicalDevicePCIBusInfoPropertiesEXT pciBus(@Unsigned int value) {
        segment.set(LAYOUT$pciBus, OFFSET$pciBus, value);
        return this;
    }

    public @Unsigned int pciDevice() {
        return segment.get(LAYOUT$pciDevice, OFFSET$pciDevice);
    }

    public VkPhysicalDevicePCIBusInfoPropertiesEXT pciDevice(@Unsigned int value) {
        segment.set(LAYOUT$pciDevice, OFFSET$pciDevice, value);
        return this;
    }

    public @Unsigned int pciFunction() {
        return segment.get(LAYOUT$pciFunction, OFFSET$pciFunction);
    }

    public VkPhysicalDevicePCIBusInfoPropertiesEXT pciFunction(@Unsigned int value) {
        segment.set(LAYOUT$pciFunction, OFFSET$pciFunction, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("pciDomain"),
        ValueLayout.JAVA_INT.withName("pciBus"),
        ValueLayout.JAVA_INT.withName("pciDevice"),
        ValueLayout.JAVA_INT.withName("pciFunction")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$pciDomain = PathElement.groupElement("pciDomain");
    public static final PathElement PATH$pciBus = PathElement.groupElement("pciBus");
    public static final PathElement PATH$pciDevice = PathElement.groupElement("pciDevice");
    public static final PathElement PATH$pciFunction = PathElement.groupElement("pciFunction");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$pciDomain = (OfInt) LAYOUT.select(PATH$pciDomain);
    public static final OfInt LAYOUT$pciBus = (OfInt) LAYOUT.select(PATH$pciBus);
    public static final OfInt LAYOUT$pciDevice = (OfInt) LAYOUT.select(PATH$pciDevice);
    public static final OfInt LAYOUT$pciFunction = (OfInt) LAYOUT.select(PATH$pciFunction);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$pciDomain = LAYOUT$pciDomain.byteSize();
    public static final long SIZE$pciBus = LAYOUT$pciBus.byteSize();
    public static final long SIZE$pciDevice = LAYOUT$pciDevice.byteSize();
    public static final long SIZE$pciFunction = LAYOUT$pciFunction.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$pciDomain = LAYOUT.byteOffset(PATH$pciDomain);
    public static final long OFFSET$pciBus = LAYOUT.byteOffset(PATH$pciBus);
    public static final long OFFSET$pciDevice = LAYOUT.byteOffset(PATH$pciDevice);
    public static final long OFFSET$pciFunction = LAYOUT.byteOffset(PATH$pciFunction);
}
