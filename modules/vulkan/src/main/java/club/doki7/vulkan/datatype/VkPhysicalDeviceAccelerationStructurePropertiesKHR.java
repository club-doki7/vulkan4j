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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceAccelerationStructurePropertiesKHR.html"><code>VkPhysicalDeviceAccelerationStructurePropertiesKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceAccelerationStructurePropertiesKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint64_t maxGeometryCount; // @link substring="maxGeometryCount" target="#maxGeometryCount"
///     uint64_t maxInstanceCount; // @link substring="maxInstanceCount" target="#maxInstanceCount"
///     uint64_t maxPrimitiveCount; // @link substring="maxPrimitiveCount" target="#maxPrimitiveCount"
///     uint32_t maxPerStageDescriptorAccelerationStructures; // @link substring="maxPerStageDescriptorAccelerationStructures" target="#maxPerStageDescriptorAccelerationStructures"
///     uint32_t maxPerStageDescriptorUpdateAfterBindAccelerationStructures; // @link substring="maxPerStageDescriptorUpdateAfterBindAccelerationStructures" target="#maxPerStageDescriptorUpdateAfterBindAccelerationStructures"
///     uint32_t maxDescriptorSetAccelerationStructures; // @link substring="maxDescriptorSetAccelerationStructures" target="#maxDescriptorSetAccelerationStructures"
///     uint32_t maxDescriptorSetUpdateAfterBindAccelerationStructures; // @link substring="maxDescriptorSetUpdateAfterBindAccelerationStructures" target="#maxDescriptorSetUpdateAfterBindAccelerationStructures"
///     uint32_t minAccelerationStructureScratchOffsetAlignment; // @link substring="minAccelerationStructureScratchOffsetAlignment" target="#minAccelerationStructureScratchOffsetAlignment"
/// } VkPhysicalDeviceAccelerationStructurePropertiesKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_ACCELERATION_STRUCTURE_PROPERTIES_KHR`
///
/// The {@code allocate} ({@link VkPhysicalDeviceAccelerationStructurePropertiesKHR#allocate(Arena)}, {@link VkPhysicalDeviceAccelerationStructurePropertiesKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceAccelerationStructurePropertiesKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceAccelerationStructurePropertiesKHR.html"><code>VkPhysicalDeviceAccelerationStructurePropertiesKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceAccelerationStructurePropertiesKHR(@NotNull MemorySegment segment) implements IVkPhysicalDeviceAccelerationStructurePropertiesKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceAccelerationStructurePropertiesKHR.html"><code>VkPhysicalDeviceAccelerationStructurePropertiesKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceAccelerationStructurePropertiesKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceAccelerationStructurePropertiesKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceAccelerationStructurePropertiesKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceAccelerationStructurePropertiesKHR, Iterable<VkPhysicalDeviceAccelerationStructurePropertiesKHR> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceAccelerationStructurePropertiesKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceAccelerationStructurePropertiesKHR at(long index) {
            return new VkPhysicalDeviceAccelerationStructurePropertiesKHR(segment.asSlice(index * VkPhysicalDeviceAccelerationStructurePropertiesKHR.BYTES, VkPhysicalDeviceAccelerationStructurePropertiesKHR.BYTES));
        }

        public VkPhysicalDeviceAccelerationStructurePropertiesKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceAccelerationStructurePropertiesKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceAccelerationStructurePropertiesKHR value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceAccelerationStructurePropertiesKHR.BYTES, VkPhysicalDeviceAccelerationStructurePropertiesKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceAccelerationStructurePropertiesKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceAccelerationStructurePropertiesKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceAccelerationStructurePropertiesKHR.BYTES,
                (end - start) * VkPhysicalDeviceAccelerationStructurePropertiesKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceAccelerationStructurePropertiesKHR.BYTES));
        }

        public VkPhysicalDeviceAccelerationStructurePropertiesKHR[] toArray() {
            VkPhysicalDeviceAccelerationStructurePropertiesKHR[] ret = new VkPhysicalDeviceAccelerationStructurePropertiesKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceAccelerationStructurePropertiesKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceAccelerationStructurePropertiesKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceAccelerationStructurePropertiesKHR.BYTES;
            }

            @Override
            public VkPhysicalDeviceAccelerationStructurePropertiesKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceAccelerationStructurePropertiesKHR ret = new VkPhysicalDeviceAccelerationStructurePropertiesKHR(segment.asSlice(0, VkPhysicalDeviceAccelerationStructurePropertiesKHR.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceAccelerationStructurePropertiesKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceAccelerationStructurePropertiesKHR allocate(Arena arena) {
        VkPhysicalDeviceAccelerationStructurePropertiesKHR ret = new VkPhysicalDeviceAccelerationStructurePropertiesKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_ACCELERATION_STRUCTURE_PROPERTIES_KHR);
        return ret;
    }

    public static VkPhysicalDeviceAccelerationStructurePropertiesKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceAccelerationStructurePropertiesKHR.Ptr ret = new VkPhysicalDeviceAccelerationStructurePropertiesKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_ACCELERATION_STRUCTURE_PROPERTIES_KHR);
        }
        return ret;
    }

    public static VkPhysicalDeviceAccelerationStructurePropertiesKHR clone(Arena arena, VkPhysicalDeviceAccelerationStructurePropertiesKHR src) {
        VkPhysicalDeviceAccelerationStructurePropertiesKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_ACCELERATION_STRUCTURE_PROPERTIES_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceAccelerationStructurePropertiesKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceAccelerationStructurePropertiesKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceAccelerationStructurePropertiesKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned long maxGeometryCount() {
        return segment.get(LAYOUT$maxGeometryCount, OFFSET$maxGeometryCount);
    }

    public VkPhysicalDeviceAccelerationStructurePropertiesKHR maxGeometryCount(@Unsigned long value) {
        segment.set(LAYOUT$maxGeometryCount, OFFSET$maxGeometryCount, value);
        return this;
    }

    public @Unsigned long maxInstanceCount() {
        return segment.get(LAYOUT$maxInstanceCount, OFFSET$maxInstanceCount);
    }

    public VkPhysicalDeviceAccelerationStructurePropertiesKHR maxInstanceCount(@Unsigned long value) {
        segment.set(LAYOUT$maxInstanceCount, OFFSET$maxInstanceCount, value);
        return this;
    }

    public @Unsigned long maxPrimitiveCount() {
        return segment.get(LAYOUT$maxPrimitiveCount, OFFSET$maxPrimitiveCount);
    }

    public VkPhysicalDeviceAccelerationStructurePropertiesKHR maxPrimitiveCount(@Unsigned long value) {
        segment.set(LAYOUT$maxPrimitiveCount, OFFSET$maxPrimitiveCount, value);
        return this;
    }

    public @Unsigned int maxPerStageDescriptorAccelerationStructures() {
        return segment.get(LAYOUT$maxPerStageDescriptorAccelerationStructures, OFFSET$maxPerStageDescriptorAccelerationStructures);
    }

    public VkPhysicalDeviceAccelerationStructurePropertiesKHR maxPerStageDescriptorAccelerationStructures(@Unsigned int value) {
        segment.set(LAYOUT$maxPerStageDescriptorAccelerationStructures, OFFSET$maxPerStageDescriptorAccelerationStructures, value);
        return this;
    }

    public @Unsigned int maxPerStageDescriptorUpdateAfterBindAccelerationStructures() {
        return segment.get(LAYOUT$maxPerStageDescriptorUpdateAfterBindAccelerationStructures, OFFSET$maxPerStageDescriptorUpdateAfterBindAccelerationStructures);
    }

    public VkPhysicalDeviceAccelerationStructurePropertiesKHR maxPerStageDescriptorUpdateAfterBindAccelerationStructures(@Unsigned int value) {
        segment.set(LAYOUT$maxPerStageDescriptorUpdateAfterBindAccelerationStructures, OFFSET$maxPerStageDescriptorUpdateAfterBindAccelerationStructures, value);
        return this;
    }

    public @Unsigned int maxDescriptorSetAccelerationStructures() {
        return segment.get(LAYOUT$maxDescriptorSetAccelerationStructures, OFFSET$maxDescriptorSetAccelerationStructures);
    }

    public VkPhysicalDeviceAccelerationStructurePropertiesKHR maxDescriptorSetAccelerationStructures(@Unsigned int value) {
        segment.set(LAYOUT$maxDescriptorSetAccelerationStructures, OFFSET$maxDescriptorSetAccelerationStructures, value);
        return this;
    }

    public @Unsigned int maxDescriptorSetUpdateAfterBindAccelerationStructures() {
        return segment.get(LAYOUT$maxDescriptorSetUpdateAfterBindAccelerationStructures, OFFSET$maxDescriptorSetUpdateAfterBindAccelerationStructures);
    }

    public VkPhysicalDeviceAccelerationStructurePropertiesKHR maxDescriptorSetUpdateAfterBindAccelerationStructures(@Unsigned int value) {
        segment.set(LAYOUT$maxDescriptorSetUpdateAfterBindAccelerationStructures, OFFSET$maxDescriptorSetUpdateAfterBindAccelerationStructures, value);
        return this;
    }

    public @Unsigned int minAccelerationStructureScratchOffsetAlignment() {
        return segment.get(LAYOUT$minAccelerationStructureScratchOffsetAlignment, OFFSET$minAccelerationStructureScratchOffsetAlignment);
    }

    public VkPhysicalDeviceAccelerationStructurePropertiesKHR minAccelerationStructureScratchOffsetAlignment(@Unsigned int value) {
        segment.set(LAYOUT$minAccelerationStructureScratchOffsetAlignment, OFFSET$minAccelerationStructureScratchOffsetAlignment, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_LONG.withName("maxGeometryCount"),
        ValueLayout.JAVA_LONG.withName("maxInstanceCount"),
        ValueLayout.JAVA_LONG.withName("maxPrimitiveCount"),
        ValueLayout.JAVA_INT.withName("maxPerStageDescriptorAccelerationStructures"),
        ValueLayout.JAVA_INT.withName("maxPerStageDescriptorUpdateAfterBindAccelerationStructures"),
        ValueLayout.JAVA_INT.withName("maxDescriptorSetAccelerationStructures"),
        ValueLayout.JAVA_INT.withName("maxDescriptorSetUpdateAfterBindAccelerationStructures"),
        ValueLayout.JAVA_INT.withName("minAccelerationStructureScratchOffsetAlignment")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$maxGeometryCount = PathElement.groupElement("maxGeometryCount");
    public static final PathElement PATH$maxInstanceCount = PathElement.groupElement("maxInstanceCount");
    public static final PathElement PATH$maxPrimitiveCount = PathElement.groupElement("maxPrimitiveCount");
    public static final PathElement PATH$maxPerStageDescriptorAccelerationStructures = PathElement.groupElement("maxPerStageDescriptorAccelerationStructures");
    public static final PathElement PATH$maxPerStageDescriptorUpdateAfterBindAccelerationStructures = PathElement.groupElement("maxPerStageDescriptorUpdateAfterBindAccelerationStructures");
    public static final PathElement PATH$maxDescriptorSetAccelerationStructures = PathElement.groupElement("maxDescriptorSetAccelerationStructures");
    public static final PathElement PATH$maxDescriptorSetUpdateAfterBindAccelerationStructures = PathElement.groupElement("maxDescriptorSetUpdateAfterBindAccelerationStructures");
    public static final PathElement PATH$minAccelerationStructureScratchOffsetAlignment = PathElement.groupElement("minAccelerationStructureScratchOffsetAlignment");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfLong LAYOUT$maxGeometryCount = (OfLong) LAYOUT.select(PATH$maxGeometryCount);
    public static final OfLong LAYOUT$maxInstanceCount = (OfLong) LAYOUT.select(PATH$maxInstanceCount);
    public static final OfLong LAYOUT$maxPrimitiveCount = (OfLong) LAYOUT.select(PATH$maxPrimitiveCount);
    public static final OfInt LAYOUT$maxPerStageDescriptorAccelerationStructures = (OfInt) LAYOUT.select(PATH$maxPerStageDescriptorAccelerationStructures);
    public static final OfInt LAYOUT$maxPerStageDescriptorUpdateAfterBindAccelerationStructures = (OfInt) LAYOUT.select(PATH$maxPerStageDescriptorUpdateAfterBindAccelerationStructures);
    public static final OfInt LAYOUT$maxDescriptorSetAccelerationStructures = (OfInt) LAYOUT.select(PATH$maxDescriptorSetAccelerationStructures);
    public static final OfInt LAYOUT$maxDescriptorSetUpdateAfterBindAccelerationStructures = (OfInt) LAYOUT.select(PATH$maxDescriptorSetUpdateAfterBindAccelerationStructures);
    public static final OfInt LAYOUT$minAccelerationStructureScratchOffsetAlignment = (OfInt) LAYOUT.select(PATH$minAccelerationStructureScratchOffsetAlignment);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$maxGeometryCount = LAYOUT$maxGeometryCount.byteSize();
    public static final long SIZE$maxInstanceCount = LAYOUT$maxInstanceCount.byteSize();
    public static final long SIZE$maxPrimitiveCount = LAYOUT$maxPrimitiveCount.byteSize();
    public static final long SIZE$maxPerStageDescriptorAccelerationStructures = LAYOUT$maxPerStageDescriptorAccelerationStructures.byteSize();
    public static final long SIZE$maxPerStageDescriptorUpdateAfterBindAccelerationStructures = LAYOUT$maxPerStageDescriptorUpdateAfterBindAccelerationStructures.byteSize();
    public static final long SIZE$maxDescriptorSetAccelerationStructures = LAYOUT$maxDescriptorSetAccelerationStructures.byteSize();
    public static final long SIZE$maxDescriptorSetUpdateAfterBindAccelerationStructures = LAYOUT$maxDescriptorSetUpdateAfterBindAccelerationStructures.byteSize();
    public static final long SIZE$minAccelerationStructureScratchOffsetAlignment = LAYOUT$minAccelerationStructureScratchOffsetAlignment.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$maxGeometryCount = LAYOUT.byteOffset(PATH$maxGeometryCount);
    public static final long OFFSET$maxInstanceCount = LAYOUT.byteOffset(PATH$maxInstanceCount);
    public static final long OFFSET$maxPrimitiveCount = LAYOUT.byteOffset(PATH$maxPrimitiveCount);
    public static final long OFFSET$maxPerStageDescriptorAccelerationStructures = LAYOUT.byteOffset(PATH$maxPerStageDescriptorAccelerationStructures);
    public static final long OFFSET$maxPerStageDescriptorUpdateAfterBindAccelerationStructures = LAYOUT.byteOffset(PATH$maxPerStageDescriptorUpdateAfterBindAccelerationStructures);
    public static final long OFFSET$maxDescriptorSetAccelerationStructures = LAYOUT.byteOffset(PATH$maxDescriptorSetAccelerationStructures);
    public static final long OFFSET$maxDescriptorSetUpdateAfterBindAccelerationStructures = LAYOUT.byteOffset(PATH$maxDescriptorSetUpdateAfterBindAccelerationStructures);
    public static final long OFFSET$minAccelerationStructureScratchOffsetAlignment = LAYOUT.byteOffset(PATH$minAccelerationStructureScratchOffsetAlignment);
}
