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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceMaintenance3Properties.html"><code>VkPhysicalDeviceMaintenance3Properties</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceMaintenance3Properties {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t maxPerSetDescriptors; // @link substring="maxPerSetDescriptors" target="#maxPerSetDescriptors"
///     VkDeviceSize maxMemoryAllocationSize; // @link substring="maxMemoryAllocationSize" target="#maxMemoryAllocationSize"
/// } VkPhysicalDeviceMaintenance3Properties;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_MAINTENANCE_3_PROPERTIES`
///
/// The {@code allocate} ({@link VkPhysicalDeviceMaintenance3Properties#allocate(Arena)}, {@link VkPhysicalDeviceMaintenance3Properties#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceMaintenance3Properties#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceMaintenance3Properties.html"><code>VkPhysicalDeviceMaintenance3Properties</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceMaintenance3Properties(@NotNull MemorySegment segment) implements IVkPhysicalDeviceMaintenance3Properties {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceMaintenance3Properties.html"><code>VkPhysicalDeviceMaintenance3Properties</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceMaintenance3Properties}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceMaintenance3Properties to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceMaintenance3Properties.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceMaintenance3Properties, Iterable<VkPhysicalDeviceMaintenance3Properties> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceMaintenance3Properties.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceMaintenance3Properties at(long index) {
            return new VkPhysicalDeviceMaintenance3Properties(segment.asSlice(index * VkPhysicalDeviceMaintenance3Properties.BYTES, VkPhysicalDeviceMaintenance3Properties.BYTES));
        }

        public VkPhysicalDeviceMaintenance3Properties.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceMaintenance3Properties> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceMaintenance3Properties value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceMaintenance3Properties.BYTES, VkPhysicalDeviceMaintenance3Properties.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceMaintenance3Properties.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceMaintenance3Properties.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceMaintenance3Properties.BYTES,
                (end - start) * VkPhysicalDeviceMaintenance3Properties.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceMaintenance3Properties.BYTES));
        }

        public VkPhysicalDeviceMaintenance3Properties[] toArray() {
            VkPhysicalDeviceMaintenance3Properties[] ret = new VkPhysicalDeviceMaintenance3Properties[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceMaintenance3Properties> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceMaintenance3Properties> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceMaintenance3Properties.BYTES;
            }

            @Override
            public VkPhysicalDeviceMaintenance3Properties next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceMaintenance3Properties ret = new VkPhysicalDeviceMaintenance3Properties(segment.asSlice(0, VkPhysicalDeviceMaintenance3Properties.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceMaintenance3Properties.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceMaintenance3Properties allocate(Arena arena) {
        VkPhysicalDeviceMaintenance3Properties ret = new VkPhysicalDeviceMaintenance3Properties(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_MAINTENANCE_3_PROPERTIES);
        return ret;
    }

    public static VkPhysicalDeviceMaintenance3Properties.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceMaintenance3Properties.Ptr ret = new VkPhysicalDeviceMaintenance3Properties.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_MAINTENANCE_3_PROPERTIES);
        }
        return ret;
    }

    public static VkPhysicalDeviceMaintenance3Properties clone(Arena arena, VkPhysicalDeviceMaintenance3Properties src) {
        VkPhysicalDeviceMaintenance3Properties ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_MAINTENANCE_3_PROPERTIES);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceMaintenance3Properties sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceMaintenance3Properties pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceMaintenance3Properties pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int maxPerSetDescriptors() {
        return segment.get(LAYOUT$maxPerSetDescriptors, OFFSET$maxPerSetDescriptors);
    }

    public VkPhysicalDeviceMaintenance3Properties maxPerSetDescriptors(@Unsigned int value) {
        segment.set(LAYOUT$maxPerSetDescriptors, OFFSET$maxPerSetDescriptors, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long maxMemoryAllocationSize() {
        return segment.get(LAYOUT$maxMemoryAllocationSize, OFFSET$maxMemoryAllocationSize);
    }

    public VkPhysicalDeviceMaintenance3Properties maxMemoryAllocationSize(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$maxMemoryAllocationSize, OFFSET$maxMemoryAllocationSize, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("maxPerSetDescriptors"),
        ValueLayout.JAVA_LONG.withName("maxMemoryAllocationSize")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$maxPerSetDescriptors = PathElement.groupElement("maxPerSetDescriptors");
    public static final PathElement PATH$maxMemoryAllocationSize = PathElement.groupElement("maxMemoryAllocationSize");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$maxPerSetDescriptors = (OfInt) LAYOUT.select(PATH$maxPerSetDescriptors);
    public static final OfLong LAYOUT$maxMemoryAllocationSize = (OfLong) LAYOUT.select(PATH$maxMemoryAllocationSize);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$maxPerSetDescriptors = LAYOUT$maxPerSetDescriptors.byteSize();
    public static final long SIZE$maxMemoryAllocationSize = LAYOUT$maxMemoryAllocationSize.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$maxPerSetDescriptors = LAYOUT.byteOffset(PATH$maxPerSetDescriptors);
    public static final long OFFSET$maxMemoryAllocationSize = LAYOUT.byteOffset(PATH$maxMemoryAllocationSize);
}
