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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDeviceGroupDeviceCreateInfo.html"><code>VkDeviceGroupDeviceCreateInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDeviceGroupDeviceCreateInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t physicalDeviceCount; // optional // @link substring="physicalDeviceCount" target="#physicalDeviceCount"
///     VkPhysicalDevice const* pPhysicalDevices; // optional // @link substring="VkPhysicalDevice" target="VkPhysicalDevice" @link substring="pPhysicalDevices" target="#pPhysicalDevices"
/// } VkDeviceGroupDeviceCreateInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_DEVICE_GROUP_DEVICE_CREATE_INFO`
///
/// The {@code allocate} ({@link VkDeviceGroupDeviceCreateInfo#allocate(Arena)}, {@link VkDeviceGroupDeviceCreateInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkDeviceGroupDeviceCreateInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDeviceGroupDeviceCreateInfo.html"><code>VkDeviceGroupDeviceCreateInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDeviceGroupDeviceCreateInfo(@NotNull MemorySegment segment) implements IVkDeviceGroupDeviceCreateInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDeviceGroupDeviceCreateInfo.html"><code>VkDeviceGroupDeviceCreateInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDeviceGroupDeviceCreateInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDeviceGroupDeviceCreateInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDeviceGroupDeviceCreateInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDeviceGroupDeviceCreateInfo, Iterable<VkDeviceGroupDeviceCreateInfo> {
        public long size() {
            return segment.byteSize() / VkDeviceGroupDeviceCreateInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDeviceGroupDeviceCreateInfo at(long index) {
            return new VkDeviceGroupDeviceCreateInfo(segment.asSlice(index * VkDeviceGroupDeviceCreateInfo.BYTES, VkDeviceGroupDeviceCreateInfo.BYTES));
        }

        public VkDeviceGroupDeviceCreateInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkDeviceGroupDeviceCreateInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDeviceGroupDeviceCreateInfo value) {
            MemorySegment s = segment.asSlice(index * VkDeviceGroupDeviceCreateInfo.BYTES, VkDeviceGroupDeviceCreateInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDeviceGroupDeviceCreateInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDeviceGroupDeviceCreateInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDeviceGroupDeviceCreateInfo.BYTES,
                (end - start) * VkDeviceGroupDeviceCreateInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDeviceGroupDeviceCreateInfo.BYTES));
        }

        public VkDeviceGroupDeviceCreateInfo[] toArray() {
            VkDeviceGroupDeviceCreateInfo[] ret = new VkDeviceGroupDeviceCreateInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDeviceGroupDeviceCreateInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDeviceGroupDeviceCreateInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDeviceGroupDeviceCreateInfo.BYTES;
            }

            @Override
            public VkDeviceGroupDeviceCreateInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDeviceGroupDeviceCreateInfo ret = new VkDeviceGroupDeviceCreateInfo(segment.asSlice(0, VkDeviceGroupDeviceCreateInfo.BYTES));
                segment = segment.asSlice(VkDeviceGroupDeviceCreateInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDeviceGroupDeviceCreateInfo allocate(Arena arena) {
        VkDeviceGroupDeviceCreateInfo ret = new VkDeviceGroupDeviceCreateInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.DEVICE_GROUP_DEVICE_CREATE_INFO);
        return ret;
    }

    public static VkDeviceGroupDeviceCreateInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkDeviceGroupDeviceCreateInfo.Ptr ret = new VkDeviceGroupDeviceCreateInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.DEVICE_GROUP_DEVICE_CREATE_INFO);
        }
        return ret;
    }

    public static VkDeviceGroupDeviceCreateInfo clone(Arena arena, VkDeviceGroupDeviceCreateInfo src) {
        VkDeviceGroupDeviceCreateInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.DEVICE_GROUP_DEVICE_CREATE_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkDeviceGroupDeviceCreateInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkDeviceGroupDeviceCreateInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkDeviceGroupDeviceCreateInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int physicalDeviceCount() {
        return segment.get(LAYOUT$physicalDeviceCount, OFFSET$physicalDeviceCount);
    }

    public VkDeviceGroupDeviceCreateInfo physicalDeviceCount(@Unsigned int value) {
        segment.set(LAYOUT$physicalDeviceCount, OFFSET$physicalDeviceCount, value);
        return this;
    }

    /// Note: the returned {@link VkPhysicalDevice.Ptr} does not have correct {@link VkPhysicalDevice.Ptr#size}
    /// property. It's up to user to track the size of the buffer, and use
    /// {@link VkPhysicalDevice.Ptr#reinterpret} to set the size before actually reading from or writing to the
    /// buffer.
    public @Nullable VkPhysicalDevice.Ptr pPhysicalDevices() {
        MemorySegment s = pPhysicalDevicesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkPhysicalDevice.Ptr(s);
    }

    public VkDeviceGroupDeviceCreateInfo pPhysicalDevices(@Nullable VkPhysicalDevice.Ptr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pPhysicalDevicesRaw(s);
        return this;
    }

    public @Pointer(target=VkPhysicalDevice.class) @NotNull MemorySegment pPhysicalDevicesRaw() {
        return segment.get(LAYOUT$pPhysicalDevices, OFFSET$pPhysicalDevices);
    }

    public void pPhysicalDevicesRaw(@Pointer(target=VkPhysicalDevice.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pPhysicalDevices, OFFSET$pPhysicalDevices, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("physicalDeviceCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS).withName("pPhysicalDevices")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$physicalDeviceCount = PathElement.groupElement("physicalDeviceCount");
    public static final PathElement PATH$pPhysicalDevices = PathElement.groupElement("pPhysicalDevices");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$physicalDeviceCount = (OfInt) LAYOUT.select(PATH$physicalDeviceCount);
    public static final AddressLayout LAYOUT$pPhysicalDevices = (AddressLayout) LAYOUT.select(PATH$pPhysicalDevices);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$physicalDeviceCount = LAYOUT$physicalDeviceCount.byteSize();
    public static final long SIZE$pPhysicalDevices = LAYOUT$pPhysicalDevices.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$physicalDeviceCount = LAYOUT.byteOffset(PATH$physicalDeviceCount);
    public static final long OFFSET$pPhysicalDevices = LAYOUT.byteOffset(PATH$pPhysicalDevices);
}
