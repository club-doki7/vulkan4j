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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDevicePerformanceCountersByRegionPropertiesARM.html"><code>VkPhysicalDevicePerformanceCountersByRegionPropertiesARM</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDevicePerformanceCountersByRegionPropertiesARM {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t maxPerRegionPerformanceCounters; // @link substring="maxPerRegionPerformanceCounters" target="#maxPerRegionPerformanceCounters"
///     VkExtent2D performanceCounterRegionSize; // @link substring="VkExtent2D" target="VkExtent2D" @link substring="performanceCounterRegionSize" target="#performanceCounterRegionSize"
///     uint32_t rowStrideAlignment; // @link substring="rowStrideAlignment" target="#rowStrideAlignment"
///     uint32_t regionAlignment; // @link substring="regionAlignment" target="#regionAlignment"
///     VkBool32 identityTransformOrder; // @link substring="identityTransformOrder" target="#identityTransformOrder"
/// } VkPhysicalDevicePerformanceCountersByRegionPropertiesARM;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_PERFORMANCE_COUNTERS_BY_REGION_PROPERTIES_ARM`
///
/// The {@code allocate} ({@link VkPhysicalDevicePerformanceCountersByRegionPropertiesARM#allocate(Arena)}, {@link VkPhysicalDevicePerformanceCountersByRegionPropertiesARM#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDevicePerformanceCountersByRegionPropertiesARM#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDevicePerformanceCountersByRegionPropertiesARM.html"><code>VkPhysicalDevicePerformanceCountersByRegionPropertiesARM</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDevicePerformanceCountersByRegionPropertiesARM(@NotNull MemorySegment segment) implements IVkPhysicalDevicePerformanceCountersByRegionPropertiesARM {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDevicePerformanceCountersByRegionPropertiesARM.html"><code>VkPhysicalDevicePerformanceCountersByRegionPropertiesARM</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDevicePerformanceCountersByRegionPropertiesARM}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDevicePerformanceCountersByRegionPropertiesARM to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDevicePerformanceCountersByRegionPropertiesARM.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDevicePerformanceCountersByRegionPropertiesARM, Iterable<VkPhysicalDevicePerformanceCountersByRegionPropertiesARM> {
        public long size() {
            return segment.byteSize() / VkPhysicalDevicePerformanceCountersByRegionPropertiesARM.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDevicePerformanceCountersByRegionPropertiesARM at(long index) {
            return new VkPhysicalDevicePerformanceCountersByRegionPropertiesARM(segment.asSlice(index * VkPhysicalDevicePerformanceCountersByRegionPropertiesARM.BYTES, VkPhysicalDevicePerformanceCountersByRegionPropertiesARM.BYTES));
        }

        public VkPhysicalDevicePerformanceCountersByRegionPropertiesARM.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDevicePerformanceCountersByRegionPropertiesARM> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDevicePerformanceCountersByRegionPropertiesARM value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDevicePerformanceCountersByRegionPropertiesARM.BYTES, VkPhysicalDevicePerformanceCountersByRegionPropertiesARM.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDevicePerformanceCountersByRegionPropertiesARM.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDevicePerformanceCountersByRegionPropertiesARM.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDevicePerformanceCountersByRegionPropertiesARM.BYTES,
                (end - start) * VkPhysicalDevicePerformanceCountersByRegionPropertiesARM.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDevicePerformanceCountersByRegionPropertiesARM.BYTES));
        }

        public VkPhysicalDevicePerformanceCountersByRegionPropertiesARM[] toArray() {
            VkPhysicalDevicePerformanceCountersByRegionPropertiesARM[] ret = new VkPhysicalDevicePerformanceCountersByRegionPropertiesARM[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDevicePerformanceCountersByRegionPropertiesARM> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDevicePerformanceCountersByRegionPropertiesARM> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDevicePerformanceCountersByRegionPropertiesARM.BYTES;
            }

            @Override
            public VkPhysicalDevicePerformanceCountersByRegionPropertiesARM next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDevicePerformanceCountersByRegionPropertiesARM ret = new VkPhysicalDevicePerformanceCountersByRegionPropertiesARM(segment.asSlice(0, VkPhysicalDevicePerformanceCountersByRegionPropertiesARM.BYTES));
                segment = segment.asSlice(VkPhysicalDevicePerformanceCountersByRegionPropertiesARM.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDevicePerformanceCountersByRegionPropertiesARM allocate(Arena arena) {
        VkPhysicalDevicePerformanceCountersByRegionPropertiesARM ret = new VkPhysicalDevicePerformanceCountersByRegionPropertiesARM(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_PERFORMANCE_COUNTERS_BY_REGION_PROPERTIES_ARM);
        return ret;
    }

    public static VkPhysicalDevicePerformanceCountersByRegionPropertiesARM.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDevicePerformanceCountersByRegionPropertiesARM.Ptr ret = new VkPhysicalDevicePerformanceCountersByRegionPropertiesARM.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_PERFORMANCE_COUNTERS_BY_REGION_PROPERTIES_ARM);
        }
        return ret;
    }

    public static VkPhysicalDevicePerformanceCountersByRegionPropertiesARM clone(Arena arena, VkPhysicalDevicePerformanceCountersByRegionPropertiesARM src) {
        VkPhysicalDevicePerformanceCountersByRegionPropertiesARM ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_PERFORMANCE_COUNTERS_BY_REGION_PROPERTIES_ARM);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDevicePerformanceCountersByRegionPropertiesARM sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDevicePerformanceCountersByRegionPropertiesARM pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDevicePerformanceCountersByRegionPropertiesARM pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int maxPerRegionPerformanceCounters() {
        return segment.get(LAYOUT$maxPerRegionPerformanceCounters, OFFSET$maxPerRegionPerformanceCounters);
    }

    public VkPhysicalDevicePerformanceCountersByRegionPropertiesARM maxPerRegionPerformanceCounters(@Unsigned int value) {
        segment.set(LAYOUT$maxPerRegionPerformanceCounters, OFFSET$maxPerRegionPerformanceCounters, value);
        return this;
    }

    public @NotNull VkExtent2D performanceCounterRegionSize() {
        return new VkExtent2D(segment.asSlice(OFFSET$performanceCounterRegionSize, LAYOUT$performanceCounterRegionSize));
    }

    public VkPhysicalDevicePerformanceCountersByRegionPropertiesARM performanceCounterRegionSize(@NotNull VkExtent2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$performanceCounterRegionSize, SIZE$performanceCounterRegionSize);
        return this;
    }

    public VkPhysicalDevicePerformanceCountersByRegionPropertiesARM performanceCounterRegionSize(Consumer<@NotNull VkExtent2D> consumer) {
        consumer.accept(performanceCounterRegionSize());
        return this;
    }

    public @Unsigned int rowStrideAlignment() {
        return segment.get(LAYOUT$rowStrideAlignment, OFFSET$rowStrideAlignment);
    }

    public VkPhysicalDevicePerformanceCountersByRegionPropertiesARM rowStrideAlignment(@Unsigned int value) {
        segment.set(LAYOUT$rowStrideAlignment, OFFSET$rowStrideAlignment, value);
        return this;
    }

    public @Unsigned int regionAlignment() {
        return segment.get(LAYOUT$regionAlignment, OFFSET$regionAlignment);
    }

    public VkPhysicalDevicePerformanceCountersByRegionPropertiesARM regionAlignment(@Unsigned int value) {
        segment.set(LAYOUT$regionAlignment, OFFSET$regionAlignment, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int identityTransformOrder() {
        return segment.get(LAYOUT$identityTransformOrder, OFFSET$identityTransformOrder);
    }

    public VkPhysicalDevicePerformanceCountersByRegionPropertiesARM identityTransformOrder(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$identityTransformOrder, OFFSET$identityTransformOrder, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("maxPerRegionPerformanceCounters"),
        VkExtent2D.LAYOUT.withName("performanceCounterRegionSize"),
        ValueLayout.JAVA_INT.withName("rowStrideAlignment"),
        ValueLayout.JAVA_INT.withName("regionAlignment"),
        ValueLayout.JAVA_INT.withName("identityTransformOrder")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$maxPerRegionPerformanceCounters = PathElement.groupElement("maxPerRegionPerformanceCounters");
    public static final PathElement PATH$performanceCounterRegionSize = PathElement.groupElement("performanceCounterRegionSize");
    public static final PathElement PATH$rowStrideAlignment = PathElement.groupElement("rowStrideAlignment");
    public static final PathElement PATH$regionAlignment = PathElement.groupElement("regionAlignment");
    public static final PathElement PATH$identityTransformOrder = PathElement.groupElement("identityTransformOrder");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$maxPerRegionPerformanceCounters = (OfInt) LAYOUT.select(PATH$maxPerRegionPerformanceCounters);
    public static final StructLayout LAYOUT$performanceCounterRegionSize = (StructLayout) LAYOUT.select(PATH$performanceCounterRegionSize);
    public static final OfInt LAYOUT$rowStrideAlignment = (OfInt) LAYOUT.select(PATH$rowStrideAlignment);
    public static final OfInt LAYOUT$regionAlignment = (OfInt) LAYOUT.select(PATH$regionAlignment);
    public static final OfInt LAYOUT$identityTransformOrder = (OfInt) LAYOUT.select(PATH$identityTransformOrder);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$maxPerRegionPerformanceCounters = LAYOUT$maxPerRegionPerformanceCounters.byteSize();
    public static final long SIZE$performanceCounterRegionSize = LAYOUT$performanceCounterRegionSize.byteSize();
    public static final long SIZE$rowStrideAlignment = LAYOUT$rowStrideAlignment.byteSize();
    public static final long SIZE$regionAlignment = LAYOUT$regionAlignment.byteSize();
    public static final long SIZE$identityTransformOrder = LAYOUT$identityTransformOrder.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$maxPerRegionPerformanceCounters = LAYOUT.byteOffset(PATH$maxPerRegionPerformanceCounters);
    public static final long OFFSET$performanceCounterRegionSize = LAYOUT.byteOffset(PATH$performanceCounterRegionSize);
    public static final long OFFSET$rowStrideAlignment = LAYOUT.byteOffset(PATH$rowStrideAlignment);
    public static final long OFFSET$regionAlignment = LAYOUT.byteOffset(PATH$regionAlignment);
    public static final long OFFSET$identityTransformOrder = LAYOUT.byteOffset(PATH$identityTransformOrder);
}
