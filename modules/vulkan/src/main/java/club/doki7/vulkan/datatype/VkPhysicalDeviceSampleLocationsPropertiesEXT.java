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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceSampleLocationsPropertiesEXT.html"><code>VkPhysicalDeviceSampleLocationsPropertiesEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceSampleLocationsPropertiesEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkSampleCountFlags sampleLocationSampleCounts; // @link substring="VkSampleCountFlags" target="VkSampleCountFlags" @link substring="sampleLocationSampleCounts" target="#sampleLocationSampleCounts"
///     VkExtent2D maxSampleLocationGridSize; // @link substring="VkExtent2D" target="VkExtent2D" @link substring="maxSampleLocationGridSize" target="#maxSampleLocationGridSize"
///     float[2] sampleLocationCoordinateRange; // @link substring="sampleLocationCoordinateRange" target="#sampleLocationCoordinateRange"
///     uint32_t sampleLocationSubPixelBits; // @link substring="sampleLocationSubPixelBits" target="#sampleLocationSubPixelBits"
///     VkBool32 variableSampleLocations; // @link substring="variableSampleLocations" target="#variableSampleLocations"
/// } VkPhysicalDeviceSampleLocationsPropertiesEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SAMPLE_LOCATIONS_PROPERTIES_EXT`
///
/// The {@code allocate} ({@link VkPhysicalDeviceSampleLocationsPropertiesEXT#allocate(Arena)}, {@link VkPhysicalDeviceSampleLocationsPropertiesEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceSampleLocationsPropertiesEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceSampleLocationsPropertiesEXT.html"><code>VkPhysicalDeviceSampleLocationsPropertiesEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceSampleLocationsPropertiesEXT(@NotNull MemorySegment segment) implements IVkPhysicalDeviceSampleLocationsPropertiesEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceSampleLocationsPropertiesEXT.html"><code>VkPhysicalDeviceSampleLocationsPropertiesEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceSampleLocationsPropertiesEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceSampleLocationsPropertiesEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceSampleLocationsPropertiesEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceSampleLocationsPropertiesEXT, Iterable<VkPhysicalDeviceSampleLocationsPropertiesEXT> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceSampleLocationsPropertiesEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceSampleLocationsPropertiesEXT at(long index) {
            return new VkPhysicalDeviceSampleLocationsPropertiesEXT(segment.asSlice(index * VkPhysicalDeviceSampleLocationsPropertiesEXT.BYTES, VkPhysicalDeviceSampleLocationsPropertiesEXT.BYTES));
        }

        public VkPhysicalDeviceSampleLocationsPropertiesEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceSampleLocationsPropertiesEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceSampleLocationsPropertiesEXT value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceSampleLocationsPropertiesEXT.BYTES, VkPhysicalDeviceSampleLocationsPropertiesEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceSampleLocationsPropertiesEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceSampleLocationsPropertiesEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceSampleLocationsPropertiesEXT.BYTES,
                (end - start) * VkPhysicalDeviceSampleLocationsPropertiesEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceSampleLocationsPropertiesEXT.BYTES));
        }

        public VkPhysicalDeviceSampleLocationsPropertiesEXT[] toArray() {
            VkPhysicalDeviceSampleLocationsPropertiesEXT[] ret = new VkPhysicalDeviceSampleLocationsPropertiesEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceSampleLocationsPropertiesEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceSampleLocationsPropertiesEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceSampleLocationsPropertiesEXT.BYTES;
            }

            @Override
            public VkPhysicalDeviceSampleLocationsPropertiesEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceSampleLocationsPropertiesEXT ret = new VkPhysicalDeviceSampleLocationsPropertiesEXT(segment.asSlice(0, VkPhysicalDeviceSampleLocationsPropertiesEXT.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceSampleLocationsPropertiesEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceSampleLocationsPropertiesEXT allocate(Arena arena) {
        VkPhysicalDeviceSampleLocationsPropertiesEXT ret = new VkPhysicalDeviceSampleLocationsPropertiesEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_SAMPLE_LOCATIONS_PROPERTIES_EXT);
        return ret;
    }

    public static VkPhysicalDeviceSampleLocationsPropertiesEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceSampleLocationsPropertiesEXT.Ptr ret = new VkPhysicalDeviceSampleLocationsPropertiesEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_SAMPLE_LOCATIONS_PROPERTIES_EXT);
        }
        return ret;
    }

    public static VkPhysicalDeviceSampleLocationsPropertiesEXT clone(Arena arena, VkPhysicalDeviceSampleLocationsPropertiesEXT src) {
        VkPhysicalDeviceSampleLocationsPropertiesEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_SAMPLE_LOCATIONS_PROPERTIES_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceSampleLocationsPropertiesEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceSampleLocationsPropertiesEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceSampleLocationsPropertiesEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkSampleCountFlags.class) int sampleLocationSampleCounts() {
        return segment.get(LAYOUT$sampleLocationSampleCounts, OFFSET$sampleLocationSampleCounts);
    }

    public VkPhysicalDeviceSampleLocationsPropertiesEXT sampleLocationSampleCounts(@Bitmask(VkSampleCountFlags.class) int value) {
        segment.set(LAYOUT$sampleLocationSampleCounts, OFFSET$sampleLocationSampleCounts, value);
        return this;
    }

    public @NotNull VkExtent2D maxSampleLocationGridSize() {
        return new VkExtent2D(segment.asSlice(OFFSET$maxSampleLocationGridSize, LAYOUT$maxSampleLocationGridSize));
    }

    public VkPhysicalDeviceSampleLocationsPropertiesEXT maxSampleLocationGridSize(@NotNull VkExtent2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$maxSampleLocationGridSize, SIZE$maxSampleLocationGridSize);
        return this;
    }

    public VkPhysicalDeviceSampleLocationsPropertiesEXT maxSampleLocationGridSize(Consumer<@NotNull VkExtent2D> consumer) {
        consumer.accept(maxSampleLocationGridSize());
        return this;
    }

    public FloatPtr sampleLocationCoordinateRange() {
        return new FloatPtr(sampleLocationCoordinateRangeRaw());
    }

    public VkPhysicalDeviceSampleLocationsPropertiesEXT sampleLocationCoordinateRange(@NotNull Consumer<FloatPtr> consumer) {
        FloatPtr ptr = sampleLocationCoordinateRange();
        consumer.accept(ptr);
        return this;
    }

    public VkPhysicalDeviceSampleLocationsPropertiesEXT sampleLocationCoordinateRange(FloatPtr value) {
        MemorySegment s = sampleLocationCoordinateRangeRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment sampleLocationCoordinateRangeRaw() {
        return segment.asSlice(OFFSET$sampleLocationCoordinateRange, SIZE$sampleLocationCoordinateRange);
    }

    public @Unsigned int sampleLocationSubPixelBits() {
        return segment.get(LAYOUT$sampleLocationSubPixelBits, OFFSET$sampleLocationSubPixelBits);
    }

    public VkPhysicalDeviceSampleLocationsPropertiesEXT sampleLocationSubPixelBits(@Unsigned int value) {
        segment.set(LAYOUT$sampleLocationSubPixelBits, OFFSET$sampleLocationSubPixelBits, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int variableSampleLocations() {
        return segment.get(LAYOUT$variableSampleLocations, OFFSET$variableSampleLocations);
    }

    public VkPhysicalDeviceSampleLocationsPropertiesEXT variableSampleLocations(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$variableSampleLocations, OFFSET$variableSampleLocations, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("sampleLocationSampleCounts"),
        VkExtent2D.LAYOUT.withName("maxSampleLocationGridSize"),
        MemoryLayout.sequenceLayout(2, ValueLayout.JAVA_FLOAT).withName("sampleLocationCoordinateRange"),
        ValueLayout.JAVA_INT.withName("sampleLocationSubPixelBits"),
        ValueLayout.JAVA_INT.withName("variableSampleLocations")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$sampleLocationSampleCounts = PathElement.groupElement("sampleLocationSampleCounts");
    public static final PathElement PATH$maxSampleLocationGridSize = PathElement.groupElement("maxSampleLocationGridSize");
    public static final PathElement PATH$sampleLocationCoordinateRange = PathElement.groupElement("sampleLocationCoordinateRange");
    public static final PathElement PATH$sampleLocationSubPixelBits = PathElement.groupElement("sampleLocationSubPixelBits");
    public static final PathElement PATH$variableSampleLocations = PathElement.groupElement("variableSampleLocations");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$sampleLocationSampleCounts = (OfInt) LAYOUT.select(PATH$sampleLocationSampleCounts);
    public static final StructLayout LAYOUT$maxSampleLocationGridSize = (StructLayout) LAYOUT.select(PATH$maxSampleLocationGridSize);
    public static final SequenceLayout LAYOUT$sampleLocationCoordinateRange = (SequenceLayout) LAYOUT.select(PATH$sampleLocationCoordinateRange);
    public static final OfInt LAYOUT$sampleLocationSubPixelBits = (OfInt) LAYOUT.select(PATH$sampleLocationSubPixelBits);
    public static final OfInt LAYOUT$variableSampleLocations = (OfInt) LAYOUT.select(PATH$variableSampleLocations);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$sampleLocationSampleCounts = LAYOUT$sampleLocationSampleCounts.byteSize();
    public static final long SIZE$maxSampleLocationGridSize = LAYOUT$maxSampleLocationGridSize.byteSize();
    public static final long SIZE$sampleLocationCoordinateRange = LAYOUT$sampleLocationCoordinateRange.byteSize();
    public static final long SIZE$sampleLocationSubPixelBits = LAYOUT$sampleLocationSubPixelBits.byteSize();
    public static final long SIZE$variableSampleLocations = LAYOUT$variableSampleLocations.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$sampleLocationSampleCounts = LAYOUT.byteOffset(PATH$sampleLocationSampleCounts);
    public static final long OFFSET$maxSampleLocationGridSize = LAYOUT.byteOffset(PATH$maxSampleLocationGridSize);
    public static final long OFFSET$sampleLocationCoordinateRange = LAYOUT.byteOffset(PATH$sampleLocationCoordinateRange);
    public static final long OFFSET$sampleLocationSubPixelBits = LAYOUT.byteOffset(PATH$sampleLocationSubPixelBits);
    public static final long OFFSET$variableSampleLocations = LAYOUT.byteOffset(PATH$variableSampleLocations);
}
