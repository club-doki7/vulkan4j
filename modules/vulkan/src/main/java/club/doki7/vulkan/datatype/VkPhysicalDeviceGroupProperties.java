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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceGroupProperties.html"><code>VkPhysicalDeviceGroupProperties</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceGroupProperties {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t physicalDeviceCount; // @link substring="physicalDeviceCount" target="#physicalDeviceCount"
///     VkPhysicalDevice[VK_MAX_DEVICE_GROUP_SIZE] physicalDevices; // @link substring="VkPhysicalDevice" target="VkPhysicalDevice" @link substring="physicalDevices" target="#physicalDevices"
///     VkBool32 subsetAllocation; // @link substring="subsetAllocation" target="#subsetAllocation"
/// } VkPhysicalDeviceGroupProperties;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_GROUP_PROPERTIES`
///
/// The {@code allocate} ({@link VkPhysicalDeviceGroupProperties#allocate(Arena)}, {@link VkPhysicalDeviceGroupProperties#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceGroupProperties#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceGroupProperties.html"><code>VkPhysicalDeviceGroupProperties</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceGroupProperties(@NotNull MemorySegment segment) implements IVkPhysicalDeviceGroupProperties {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceGroupProperties.html"><code>VkPhysicalDeviceGroupProperties</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceGroupProperties}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceGroupProperties to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceGroupProperties.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceGroupProperties, Iterable<VkPhysicalDeviceGroupProperties> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceGroupProperties.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceGroupProperties at(long index) {
            return new VkPhysicalDeviceGroupProperties(segment.asSlice(index * VkPhysicalDeviceGroupProperties.BYTES, VkPhysicalDeviceGroupProperties.BYTES));
        }

        public VkPhysicalDeviceGroupProperties.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceGroupProperties> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceGroupProperties value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceGroupProperties.BYTES, VkPhysicalDeviceGroupProperties.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceGroupProperties.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceGroupProperties.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceGroupProperties.BYTES,
                (end - start) * VkPhysicalDeviceGroupProperties.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceGroupProperties.BYTES));
        }

        public VkPhysicalDeviceGroupProperties[] toArray() {
            VkPhysicalDeviceGroupProperties[] ret = new VkPhysicalDeviceGroupProperties[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceGroupProperties> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceGroupProperties> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceGroupProperties.BYTES;
            }

            @Override
            public VkPhysicalDeviceGroupProperties next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceGroupProperties ret = new VkPhysicalDeviceGroupProperties(segment.asSlice(0, VkPhysicalDeviceGroupProperties.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceGroupProperties.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceGroupProperties allocate(Arena arena) {
        VkPhysicalDeviceGroupProperties ret = new VkPhysicalDeviceGroupProperties(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_GROUP_PROPERTIES);
        return ret;
    }

    public static VkPhysicalDeviceGroupProperties.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceGroupProperties.Ptr ret = new VkPhysicalDeviceGroupProperties.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_GROUP_PROPERTIES);
        }
        return ret;
    }

    public static VkPhysicalDeviceGroupProperties clone(Arena arena, VkPhysicalDeviceGroupProperties src) {
        VkPhysicalDeviceGroupProperties ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_GROUP_PROPERTIES);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceGroupProperties sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceGroupProperties pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceGroupProperties pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int physicalDeviceCount() {
        return segment.get(LAYOUT$physicalDeviceCount, OFFSET$physicalDeviceCount);
    }

    public VkPhysicalDeviceGroupProperties physicalDeviceCount(@Unsigned int value) {
        segment.set(LAYOUT$physicalDeviceCount, OFFSET$physicalDeviceCount, value);
        return this;
    }

    public @NotNull MemorySegment physicalDevicesRaw() {
        return segment.asSlice(OFFSET$physicalDevices, SIZE$physicalDevices);
    }

    public VkPhysicalDevice.Ptr physicalDevices() {
        return new VkPhysicalDevice.Ptr(physicalDevicesRaw());
    }

    public VkPhysicalDeviceGroupProperties physicalDevices(@NotNull Consumer<VkPhysicalDevice.Ptr> consumer) {
        VkPhysicalDevice.Ptr ptr = physicalDevices();
        consumer.accept(ptr);
        return this;
    }
    public VkPhysicalDeviceGroupProperties physicalDevices(VkPhysicalDevice.Ptr value) {
        MemorySegment s = physicalDevicesRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public VkPhysicalDevice physicalDevicesAt(int index) {
        MemorySegment s = physicalDevicesRaw();
        MemorySegment deref = s.get(ValueLayout.ADDRESS, index * ValueLayout.ADDRESS.byteSize());
        return new VkPhysicalDevice(deref);
    }

    public void physicalDevicesAt(int index, VkPhysicalDevice value) {
        MemorySegment s = physicalDevicesRaw();
        s.set(ValueLayout.ADDRESS, index * ValueLayout.ADDRESS.byteSize(), value.segment());
    }

    public @NativeType("VkBool32") @Unsigned int subsetAllocation() {
        return segment.get(LAYOUT$subsetAllocation, OFFSET$subsetAllocation);
    }

    public VkPhysicalDeviceGroupProperties subsetAllocation(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$subsetAllocation, OFFSET$subsetAllocation, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("physicalDeviceCount"),
        MemoryLayout.sequenceLayout(MAX_DEVICE_GROUP_SIZE, ValueLayout.ADDRESS).withName("physicalDevices"),
        ValueLayout.JAVA_INT.withName("subsetAllocation")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$physicalDeviceCount = PathElement.groupElement("physicalDeviceCount");
    public static final PathElement PATH$physicalDevices = PathElement.groupElement("physicalDevices");
    public static final PathElement PATH$subsetAllocation = PathElement.groupElement("subsetAllocation");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$physicalDeviceCount = (OfInt) LAYOUT.select(PATH$physicalDeviceCount);
    public static final SequenceLayout LAYOUT$physicalDevices = (SequenceLayout) LAYOUT.select(PATH$physicalDevices);
    public static final OfInt LAYOUT$subsetAllocation = (OfInt) LAYOUT.select(PATH$subsetAllocation);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$physicalDeviceCount = LAYOUT$physicalDeviceCount.byteSize();
    public static final long SIZE$physicalDevices = LAYOUT$physicalDevices.byteSize();
    public static final long SIZE$subsetAllocation = LAYOUT$subsetAllocation.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$physicalDeviceCount = LAYOUT.byteOffset(PATH$physicalDeviceCount);
    public static final long OFFSET$physicalDevices = LAYOUT.byteOffset(PATH$physicalDevices);
    public static final long OFFSET$subsetAllocation = LAYOUT.byteOffset(PATH$subsetAllocation);
}
