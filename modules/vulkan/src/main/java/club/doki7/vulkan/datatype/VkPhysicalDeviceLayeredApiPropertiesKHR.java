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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceLayeredApiPropertiesKHR.html"><code>VkPhysicalDeviceLayeredApiPropertiesKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceLayeredApiPropertiesKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t vendorID; // @link substring="vendorID" target="#vendorID"
///     uint32_t deviceID; // @link substring="deviceID" target="#deviceID"
///     VkPhysicalDeviceLayeredApiKHR layeredAPI; // @link substring="VkPhysicalDeviceLayeredApiKHR" target="VkPhysicalDeviceLayeredApiKHR" @link substring="layeredAPI" target="#layeredAPI"
///     char[VK_MAX_PHYSICAL_DEVICE_NAME_SIZE] deviceName; // @link substring="deviceName" target="#deviceName"
/// } VkPhysicalDeviceLayeredApiPropertiesKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_LAYERED_API_PROPERTIES_KHR`
///
/// The {@code allocate} ({@link VkPhysicalDeviceLayeredApiPropertiesKHR#allocate(Arena)}, {@link VkPhysicalDeviceLayeredApiPropertiesKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceLayeredApiPropertiesKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceLayeredApiPropertiesKHR.html"><code>VkPhysicalDeviceLayeredApiPropertiesKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceLayeredApiPropertiesKHR(@NotNull MemorySegment segment) implements IVkPhysicalDeviceLayeredApiPropertiesKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceLayeredApiPropertiesKHR.html"><code>VkPhysicalDeviceLayeredApiPropertiesKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceLayeredApiPropertiesKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceLayeredApiPropertiesKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceLayeredApiPropertiesKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceLayeredApiPropertiesKHR, Iterable<VkPhysicalDeviceLayeredApiPropertiesKHR> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceLayeredApiPropertiesKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceLayeredApiPropertiesKHR at(long index) {
            return new VkPhysicalDeviceLayeredApiPropertiesKHR(segment.asSlice(index * VkPhysicalDeviceLayeredApiPropertiesKHR.BYTES, VkPhysicalDeviceLayeredApiPropertiesKHR.BYTES));
        }

        public VkPhysicalDeviceLayeredApiPropertiesKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceLayeredApiPropertiesKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceLayeredApiPropertiesKHR value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceLayeredApiPropertiesKHR.BYTES, VkPhysicalDeviceLayeredApiPropertiesKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceLayeredApiPropertiesKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceLayeredApiPropertiesKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceLayeredApiPropertiesKHR.BYTES,
                (end - start) * VkPhysicalDeviceLayeredApiPropertiesKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceLayeredApiPropertiesKHR.BYTES));
        }

        public VkPhysicalDeviceLayeredApiPropertiesKHR[] toArray() {
            VkPhysicalDeviceLayeredApiPropertiesKHR[] ret = new VkPhysicalDeviceLayeredApiPropertiesKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceLayeredApiPropertiesKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceLayeredApiPropertiesKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceLayeredApiPropertiesKHR.BYTES;
            }

            @Override
            public VkPhysicalDeviceLayeredApiPropertiesKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceLayeredApiPropertiesKHR ret = new VkPhysicalDeviceLayeredApiPropertiesKHR(segment.asSlice(0, VkPhysicalDeviceLayeredApiPropertiesKHR.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceLayeredApiPropertiesKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceLayeredApiPropertiesKHR allocate(Arena arena) {
        VkPhysicalDeviceLayeredApiPropertiesKHR ret = new VkPhysicalDeviceLayeredApiPropertiesKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_LAYERED_API_PROPERTIES_KHR);
        return ret;
    }

    public static VkPhysicalDeviceLayeredApiPropertiesKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceLayeredApiPropertiesKHR.Ptr ret = new VkPhysicalDeviceLayeredApiPropertiesKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_LAYERED_API_PROPERTIES_KHR);
        }
        return ret;
    }

    public static VkPhysicalDeviceLayeredApiPropertiesKHR clone(Arena arena, VkPhysicalDeviceLayeredApiPropertiesKHR src) {
        VkPhysicalDeviceLayeredApiPropertiesKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_LAYERED_API_PROPERTIES_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceLayeredApiPropertiesKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceLayeredApiPropertiesKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceLayeredApiPropertiesKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int vendorID() {
        return segment.get(LAYOUT$vendorID, OFFSET$vendorID);
    }

    public VkPhysicalDeviceLayeredApiPropertiesKHR vendorID(@Unsigned int value) {
        segment.set(LAYOUT$vendorID, OFFSET$vendorID, value);
        return this;
    }

    public @Unsigned int deviceID() {
        return segment.get(LAYOUT$deviceID, OFFSET$deviceID);
    }

    public VkPhysicalDeviceLayeredApiPropertiesKHR deviceID(@Unsigned int value) {
        segment.set(LAYOUT$deviceID, OFFSET$deviceID, value);
        return this;
    }

    public @EnumType(VkPhysicalDeviceLayeredApiKHR.class) int layeredAPI() {
        return segment.get(LAYOUT$layeredAPI, OFFSET$layeredAPI);
    }

    public VkPhysicalDeviceLayeredApiPropertiesKHR layeredAPI(@EnumType(VkPhysicalDeviceLayeredApiKHR.class) int value) {
        segment.set(LAYOUT$layeredAPI, OFFSET$layeredAPI, value);
        return this;
    }

    public BytePtr deviceName() {
        return new BytePtr(deviceNameRaw());
    }

    public VkPhysicalDeviceLayeredApiPropertiesKHR deviceName(@NotNull Consumer<BytePtr> consumer) {
        BytePtr ptr = deviceName();
        consumer.accept(ptr);
        return this;
    }

    public VkPhysicalDeviceLayeredApiPropertiesKHR deviceName(BytePtr value) {
        MemorySegment s = deviceNameRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment deviceNameRaw() {
        return segment.asSlice(OFFSET$deviceName, SIZE$deviceName);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("vendorID"),
        ValueLayout.JAVA_INT.withName("deviceID"),
        ValueLayout.JAVA_INT.withName("layeredAPI"),
        MemoryLayout.sequenceLayout(MAX_PHYSICAL_DEVICE_NAME_SIZE, ValueLayout.JAVA_BYTE).withName("deviceName")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$vendorID = PathElement.groupElement("vendorID");
    public static final PathElement PATH$deviceID = PathElement.groupElement("deviceID");
    public static final PathElement PATH$layeredAPI = PathElement.groupElement("layeredAPI");
    public static final PathElement PATH$deviceName = PathElement.groupElement("deviceName");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$vendorID = (OfInt) LAYOUT.select(PATH$vendorID);
    public static final OfInt LAYOUT$deviceID = (OfInt) LAYOUT.select(PATH$deviceID);
    public static final OfInt LAYOUT$layeredAPI = (OfInt) LAYOUT.select(PATH$layeredAPI);
    public static final SequenceLayout LAYOUT$deviceName = (SequenceLayout) LAYOUT.select(PATH$deviceName);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$vendorID = LAYOUT$vendorID.byteSize();
    public static final long SIZE$deviceID = LAYOUT$deviceID.byteSize();
    public static final long SIZE$layeredAPI = LAYOUT$layeredAPI.byteSize();
    public static final long SIZE$deviceName = LAYOUT$deviceName.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$vendorID = LAYOUT.byteOffset(PATH$vendorID);
    public static final long OFFSET$deviceID = LAYOUT.byteOffset(PATH$deviceID);
    public static final long OFFSET$layeredAPI = LAYOUT.byteOffset(PATH$layeredAPI);
    public static final long OFFSET$deviceName = LAYOUT.byteOffset(PATH$deviceName);
}
