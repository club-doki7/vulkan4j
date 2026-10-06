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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceIDProperties.html"><code>VkPhysicalDeviceIDProperties</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceIDProperties {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint8_t[VK_UUID_SIZE] deviceUUID; // @link substring="deviceUUID" target="#deviceUUID"
///     uint8_t[VK_UUID_SIZE] driverUUID; // @link substring="driverUUID" target="#driverUUID"
///     uint8_t[VK_LUID_SIZE] deviceLUID; // @link substring="deviceLUID" target="#deviceLUID"
///     uint32_t deviceNodeMask; // @link substring="deviceNodeMask" target="#deviceNodeMask"
///     VkBool32 deviceLUIDValid; // @link substring="deviceLUIDValid" target="#deviceLUIDValid"
/// } VkPhysicalDeviceIDProperties;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_ID_PROPERTIES`
///
/// The {@code allocate} ({@link VkPhysicalDeviceIDProperties#allocate(Arena)}, {@link VkPhysicalDeviceIDProperties#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceIDProperties#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceIDProperties.html"><code>VkPhysicalDeviceIDProperties</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceIDProperties(@NotNull MemorySegment segment) implements IVkPhysicalDeviceIDProperties {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceIDProperties.html"><code>VkPhysicalDeviceIDProperties</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceIDProperties}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceIDProperties to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceIDProperties.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceIDProperties, Iterable<VkPhysicalDeviceIDProperties> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceIDProperties.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceIDProperties at(long index) {
            return new VkPhysicalDeviceIDProperties(segment.asSlice(index * VkPhysicalDeviceIDProperties.BYTES, VkPhysicalDeviceIDProperties.BYTES));
        }

        public VkPhysicalDeviceIDProperties.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceIDProperties> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceIDProperties value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceIDProperties.BYTES, VkPhysicalDeviceIDProperties.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceIDProperties.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceIDProperties.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceIDProperties.BYTES,
                (end - start) * VkPhysicalDeviceIDProperties.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceIDProperties.BYTES));
        }

        public VkPhysicalDeviceIDProperties[] toArray() {
            VkPhysicalDeviceIDProperties[] ret = new VkPhysicalDeviceIDProperties[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceIDProperties> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceIDProperties> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceIDProperties.BYTES;
            }

            @Override
            public VkPhysicalDeviceIDProperties next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceIDProperties ret = new VkPhysicalDeviceIDProperties(segment.asSlice(0, VkPhysicalDeviceIDProperties.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceIDProperties.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceIDProperties allocate(Arena arena) {
        VkPhysicalDeviceIDProperties ret = new VkPhysicalDeviceIDProperties(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_ID_PROPERTIES);
        return ret;
    }

    public static VkPhysicalDeviceIDProperties.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceIDProperties.Ptr ret = new VkPhysicalDeviceIDProperties.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_ID_PROPERTIES);
        }
        return ret;
    }

    public static VkPhysicalDeviceIDProperties clone(Arena arena, VkPhysicalDeviceIDProperties src) {
        VkPhysicalDeviceIDProperties ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_ID_PROPERTIES);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceIDProperties sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceIDProperties pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceIDProperties pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned BytePtr deviceUUID() {
        return new BytePtr(deviceUUIDRaw());
    }

    public VkPhysicalDeviceIDProperties deviceUUID(@NotNull Consumer<BytePtr> consumer) {
        @Unsigned BytePtr ptr = deviceUUID();
        consumer.accept(ptr);
        return this;
    }

    public VkPhysicalDeviceIDProperties deviceUUID(@Unsigned BytePtr value) {
        MemorySegment s = deviceUUIDRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment deviceUUIDRaw() {
        return segment.asSlice(OFFSET$deviceUUID, SIZE$deviceUUID);
    }

    public @Unsigned BytePtr driverUUID() {
        return new BytePtr(driverUUIDRaw());
    }

    public VkPhysicalDeviceIDProperties driverUUID(@NotNull Consumer<BytePtr> consumer) {
        @Unsigned BytePtr ptr = driverUUID();
        consumer.accept(ptr);
        return this;
    }

    public VkPhysicalDeviceIDProperties driverUUID(@Unsigned BytePtr value) {
        MemorySegment s = driverUUIDRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment driverUUIDRaw() {
        return segment.asSlice(OFFSET$driverUUID, SIZE$driverUUID);
    }

    public @Unsigned BytePtr deviceLUID() {
        return new BytePtr(deviceLUIDRaw());
    }

    public VkPhysicalDeviceIDProperties deviceLUID(@NotNull Consumer<BytePtr> consumer) {
        @Unsigned BytePtr ptr = deviceLUID();
        consumer.accept(ptr);
        return this;
    }

    public VkPhysicalDeviceIDProperties deviceLUID(@Unsigned BytePtr value) {
        MemorySegment s = deviceLUIDRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment deviceLUIDRaw() {
        return segment.asSlice(OFFSET$deviceLUID, SIZE$deviceLUID);
    }

    public @Unsigned int deviceNodeMask() {
        return segment.get(LAYOUT$deviceNodeMask, OFFSET$deviceNodeMask);
    }

    public VkPhysicalDeviceIDProperties deviceNodeMask(@Unsigned int value) {
        segment.set(LAYOUT$deviceNodeMask, OFFSET$deviceNodeMask, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int deviceLUIDValid() {
        return segment.get(LAYOUT$deviceLUIDValid, OFFSET$deviceLUIDValid);
    }

    public VkPhysicalDeviceIDProperties deviceLUIDValid(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$deviceLUIDValid, OFFSET$deviceLUIDValid, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        MemoryLayout.sequenceLayout(UUID_SIZE, ValueLayout.JAVA_BYTE).withName("deviceUUID"),
        MemoryLayout.sequenceLayout(UUID_SIZE, ValueLayout.JAVA_BYTE).withName("driverUUID"),
        MemoryLayout.sequenceLayout(LUID_SIZE, ValueLayout.JAVA_BYTE).withName("deviceLUID"),
        ValueLayout.JAVA_INT.withName("deviceNodeMask"),
        ValueLayout.JAVA_INT.withName("deviceLUIDValid")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$deviceUUID = PathElement.groupElement("deviceUUID");
    public static final PathElement PATH$driverUUID = PathElement.groupElement("driverUUID");
    public static final PathElement PATH$deviceLUID = PathElement.groupElement("deviceLUID");
    public static final PathElement PATH$deviceNodeMask = PathElement.groupElement("deviceNodeMask");
    public static final PathElement PATH$deviceLUIDValid = PathElement.groupElement("deviceLUIDValid");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final SequenceLayout LAYOUT$deviceUUID = (SequenceLayout) LAYOUT.select(PATH$deviceUUID);
    public static final SequenceLayout LAYOUT$driverUUID = (SequenceLayout) LAYOUT.select(PATH$driverUUID);
    public static final SequenceLayout LAYOUT$deviceLUID = (SequenceLayout) LAYOUT.select(PATH$deviceLUID);
    public static final OfInt LAYOUT$deviceNodeMask = (OfInt) LAYOUT.select(PATH$deviceNodeMask);
    public static final OfInt LAYOUT$deviceLUIDValid = (OfInt) LAYOUT.select(PATH$deviceLUIDValid);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$deviceUUID = LAYOUT$deviceUUID.byteSize();
    public static final long SIZE$driverUUID = LAYOUT$driverUUID.byteSize();
    public static final long SIZE$deviceLUID = LAYOUT$deviceLUID.byteSize();
    public static final long SIZE$deviceNodeMask = LAYOUT$deviceNodeMask.byteSize();
    public static final long SIZE$deviceLUIDValid = LAYOUT$deviceLUIDValid.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$deviceUUID = LAYOUT.byteOffset(PATH$deviceUUID);
    public static final long OFFSET$driverUUID = LAYOUT.byteOffset(PATH$driverUUID);
    public static final long OFFSET$deviceLUID = LAYOUT.byteOffset(PATH$deviceLUID);
    public static final long OFFSET$deviceNodeMask = LAYOUT.byteOffset(PATH$deviceNodeMask);
    public static final long OFFSET$deviceLUIDValid = LAYOUT.byteOffset(PATH$deviceLUIDValid);
}
