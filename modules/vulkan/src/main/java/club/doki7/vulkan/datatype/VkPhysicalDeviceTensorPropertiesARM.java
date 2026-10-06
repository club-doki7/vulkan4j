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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceTensorPropertiesARM.html"><code>VkPhysicalDeviceTensorPropertiesARM</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceTensorPropertiesARM {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t maxTensorDimensionCount; // @link substring="maxTensorDimensionCount" target="#maxTensorDimensionCount"
///     uint64_t maxTensorElements; // @link substring="maxTensorElements" target="#maxTensorElements"
///     uint64_t maxPerDimensionTensorElements; // @link substring="maxPerDimensionTensorElements" target="#maxPerDimensionTensorElements"
///     int64_t maxTensorStride; // @link substring="maxTensorStride" target="#maxTensorStride"
///     uint64_t maxTensorSize; // @link substring="maxTensorSize" target="#maxTensorSize"
///     uint32_t maxTensorShaderAccessArrayLength; // @link substring="maxTensorShaderAccessArrayLength" target="#maxTensorShaderAccessArrayLength"
///     uint32_t maxTensorShaderAccessSize; // @link substring="maxTensorShaderAccessSize" target="#maxTensorShaderAccessSize"
///     uint32_t maxDescriptorSetStorageTensors; // @link substring="maxDescriptorSetStorageTensors" target="#maxDescriptorSetStorageTensors"
///     uint32_t maxPerStageDescriptorSetStorageTensors; // @link substring="maxPerStageDescriptorSetStorageTensors" target="#maxPerStageDescriptorSetStorageTensors"
///     uint32_t maxDescriptorSetUpdateAfterBindStorageTensors; // @link substring="maxDescriptorSetUpdateAfterBindStorageTensors" target="#maxDescriptorSetUpdateAfterBindStorageTensors"
///     uint32_t maxPerStageDescriptorUpdateAfterBindStorageTensors; // @link substring="maxPerStageDescriptorUpdateAfterBindStorageTensors" target="#maxPerStageDescriptorUpdateAfterBindStorageTensors"
///     VkBool32 shaderStorageTensorArrayNonUniformIndexingNative; // @link substring="shaderStorageTensorArrayNonUniformIndexingNative" target="#shaderStorageTensorArrayNonUniformIndexingNative"
///     VkShaderStageFlags shaderTensorSupportedStages; // @link substring="VkShaderStageFlags" target="VkShaderStageFlags" @link substring="shaderTensorSupportedStages" target="#shaderTensorSupportedStages"
/// } VkPhysicalDeviceTensorPropertiesARM;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_TENSOR_PROPERTIES_ARM`
///
/// The {@code allocate} ({@link VkPhysicalDeviceTensorPropertiesARM#allocate(Arena)}, {@link VkPhysicalDeviceTensorPropertiesARM#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceTensorPropertiesARM#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceTensorPropertiesARM.html"><code>VkPhysicalDeviceTensorPropertiesARM</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceTensorPropertiesARM(@NotNull MemorySegment segment) implements IVkPhysicalDeviceTensorPropertiesARM {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceTensorPropertiesARM.html"><code>VkPhysicalDeviceTensorPropertiesARM</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceTensorPropertiesARM}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceTensorPropertiesARM to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceTensorPropertiesARM.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceTensorPropertiesARM, Iterable<VkPhysicalDeviceTensorPropertiesARM> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceTensorPropertiesARM.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceTensorPropertiesARM at(long index) {
            return new VkPhysicalDeviceTensorPropertiesARM(segment.asSlice(index * VkPhysicalDeviceTensorPropertiesARM.BYTES, VkPhysicalDeviceTensorPropertiesARM.BYTES));
        }

        public VkPhysicalDeviceTensorPropertiesARM.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceTensorPropertiesARM> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceTensorPropertiesARM value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceTensorPropertiesARM.BYTES, VkPhysicalDeviceTensorPropertiesARM.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceTensorPropertiesARM.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceTensorPropertiesARM.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceTensorPropertiesARM.BYTES,
                (end - start) * VkPhysicalDeviceTensorPropertiesARM.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceTensorPropertiesARM.BYTES));
        }

        public VkPhysicalDeviceTensorPropertiesARM[] toArray() {
            VkPhysicalDeviceTensorPropertiesARM[] ret = new VkPhysicalDeviceTensorPropertiesARM[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceTensorPropertiesARM> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceTensorPropertiesARM> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceTensorPropertiesARM.BYTES;
            }

            @Override
            public VkPhysicalDeviceTensorPropertiesARM next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceTensorPropertiesARM ret = new VkPhysicalDeviceTensorPropertiesARM(segment.asSlice(0, VkPhysicalDeviceTensorPropertiesARM.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceTensorPropertiesARM.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceTensorPropertiesARM allocate(Arena arena) {
        VkPhysicalDeviceTensorPropertiesARM ret = new VkPhysicalDeviceTensorPropertiesARM(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_TENSOR_PROPERTIES_ARM);
        return ret;
    }

    public static VkPhysicalDeviceTensorPropertiesARM.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceTensorPropertiesARM.Ptr ret = new VkPhysicalDeviceTensorPropertiesARM.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_TENSOR_PROPERTIES_ARM);
        }
        return ret;
    }

    public static VkPhysicalDeviceTensorPropertiesARM clone(Arena arena, VkPhysicalDeviceTensorPropertiesARM src) {
        VkPhysicalDeviceTensorPropertiesARM ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_TENSOR_PROPERTIES_ARM);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceTensorPropertiesARM sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceTensorPropertiesARM pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceTensorPropertiesARM pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int maxTensorDimensionCount() {
        return segment.get(LAYOUT$maxTensorDimensionCount, OFFSET$maxTensorDimensionCount);
    }

    public VkPhysicalDeviceTensorPropertiesARM maxTensorDimensionCount(@Unsigned int value) {
        segment.set(LAYOUT$maxTensorDimensionCount, OFFSET$maxTensorDimensionCount, value);
        return this;
    }

    public @Unsigned long maxTensorElements() {
        return segment.get(LAYOUT$maxTensorElements, OFFSET$maxTensorElements);
    }

    public VkPhysicalDeviceTensorPropertiesARM maxTensorElements(@Unsigned long value) {
        segment.set(LAYOUT$maxTensorElements, OFFSET$maxTensorElements, value);
        return this;
    }

    public @Unsigned long maxPerDimensionTensorElements() {
        return segment.get(LAYOUT$maxPerDimensionTensorElements, OFFSET$maxPerDimensionTensorElements);
    }

    public VkPhysicalDeviceTensorPropertiesARM maxPerDimensionTensorElements(@Unsigned long value) {
        segment.set(LAYOUT$maxPerDimensionTensorElements, OFFSET$maxPerDimensionTensorElements, value);
        return this;
    }

    public long maxTensorStride() {
        return segment.get(LAYOUT$maxTensorStride, OFFSET$maxTensorStride);
    }

    public VkPhysicalDeviceTensorPropertiesARM maxTensorStride(long value) {
        segment.set(LAYOUT$maxTensorStride, OFFSET$maxTensorStride, value);
        return this;
    }

    public @Unsigned long maxTensorSize() {
        return segment.get(LAYOUT$maxTensorSize, OFFSET$maxTensorSize);
    }

    public VkPhysicalDeviceTensorPropertiesARM maxTensorSize(@Unsigned long value) {
        segment.set(LAYOUT$maxTensorSize, OFFSET$maxTensorSize, value);
        return this;
    }

    public @Unsigned int maxTensorShaderAccessArrayLength() {
        return segment.get(LAYOUT$maxTensorShaderAccessArrayLength, OFFSET$maxTensorShaderAccessArrayLength);
    }

    public VkPhysicalDeviceTensorPropertiesARM maxTensorShaderAccessArrayLength(@Unsigned int value) {
        segment.set(LAYOUT$maxTensorShaderAccessArrayLength, OFFSET$maxTensorShaderAccessArrayLength, value);
        return this;
    }

    public @Unsigned int maxTensorShaderAccessSize() {
        return segment.get(LAYOUT$maxTensorShaderAccessSize, OFFSET$maxTensorShaderAccessSize);
    }

    public VkPhysicalDeviceTensorPropertiesARM maxTensorShaderAccessSize(@Unsigned int value) {
        segment.set(LAYOUT$maxTensorShaderAccessSize, OFFSET$maxTensorShaderAccessSize, value);
        return this;
    }

    public @Unsigned int maxDescriptorSetStorageTensors() {
        return segment.get(LAYOUT$maxDescriptorSetStorageTensors, OFFSET$maxDescriptorSetStorageTensors);
    }

    public VkPhysicalDeviceTensorPropertiesARM maxDescriptorSetStorageTensors(@Unsigned int value) {
        segment.set(LAYOUT$maxDescriptorSetStorageTensors, OFFSET$maxDescriptorSetStorageTensors, value);
        return this;
    }

    public @Unsigned int maxPerStageDescriptorSetStorageTensors() {
        return segment.get(LAYOUT$maxPerStageDescriptorSetStorageTensors, OFFSET$maxPerStageDescriptorSetStorageTensors);
    }

    public VkPhysicalDeviceTensorPropertiesARM maxPerStageDescriptorSetStorageTensors(@Unsigned int value) {
        segment.set(LAYOUT$maxPerStageDescriptorSetStorageTensors, OFFSET$maxPerStageDescriptorSetStorageTensors, value);
        return this;
    }

    public @Unsigned int maxDescriptorSetUpdateAfterBindStorageTensors() {
        return segment.get(LAYOUT$maxDescriptorSetUpdateAfterBindStorageTensors, OFFSET$maxDescriptorSetUpdateAfterBindStorageTensors);
    }

    public VkPhysicalDeviceTensorPropertiesARM maxDescriptorSetUpdateAfterBindStorageTensors(@Unsigned int value) {
        segment.set(LAYOUT$maxDescriptorSetUpdateAfterBindStorageTensors, OFFSET$maxDescriptorSetUpdateAfterBindStorageTensors, value);
        return this;
    }

    public @Unsigned int maxPerStageDescriptorUpdateAfterBindStorageTensors() {
        return segment.get(LAYOUT$maxPerStageDescriptorUpdateAfterBindStorageTensors, OFFSET$maxPerStageDescriptorUpdateAfterBindStorageTensors);
    }

    public VkPhysicalDeviceTensorPropertiesARM maxPerStageDescriptorUpdateAfterBindStorageTensors(@Unsigned int value) {
        segment.set(LAYOUT$maxPerStageDescriptorUpdateAfterBindStorageTensors, OFFSET$maxPerStageDescriptorUpdateAfterBindStorageTensors, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderStorageTensorArrayNonUniformIndexingNative() {
        return segment.get(LAYOUT$shaderStorageTensorArrayNonUniformIndexingNative, OFFSET$shaderStorageTensorArrayNonUniformIndexingNative);
    }

    public VkPhysicalDeviceTensorPropertiesARM shaderStorageTensorArrayNonUniformIndexingNative(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderStorageTensorArrayNonUniformIndexingNative, OFFSET$shaderStorageTensorArrayNonUniformIndexingNative, value);
        return this;
    }

    public @Bitmask(VkShaderStageFlags.class) int shaderTensorSupportedStages() {
        return segment.get(LAYOUT$shaderTensorSupportedStages, OFFSET$shaderTensorSupportedStages);
    }

    public VkPhysicalDeviceTensorPropertiesARM shaderTensorSupportedStages(@Bitmask(VkShaderStageFlags.class) int value) {
        segment.set(LAYOUT$shaderTensorSupportedStages, OFFSET$shaderTensorSupportedStages, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("maxTensorDimensionCount"),
        ValueLayout.JAVA_LONG.withName("maxTensorElements"),
        ValueLayout.JAVA_LONG.withName("maxPerDimensionTensorElements"),
        ValueLayout.JAVA_LONG.withName("maxTensorStride"),
        ValueLayout.JAVA_LONG.withName("maxTensorSize"),
        ValueLayout.JAVA_INT.withName("maxTensorShaderAccessArrayLength"),
        ValueLayout.JAVA_INT.withName("maxTensorShaderAccessSize"),
        ValueLayout.JAVA_INT.withName("maxDescriptorSetStorageTensors"),
        ValueLayout.JAVA_INT.withName("maxPerStageDescriptorSetStorageTensors"),
        ValueLayout.JAVA_INT.withName("maxDescriptorSetUpdateAfterBindStorageTensors"),
        ValueLayout.JAVA_INT.withName("maxPerStageDescriptorUpdateAfterBindStorageTensors"),
        ValueLayout.JAVA_INT.withName("shaderStorageTensorArrayNonUniformIndexingNative"),
        ValueLayout.JAVA_INT.withName("shaderTensorSupportedStages")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$maxTensorDimensionCount = PathElement.groupElement("maxTensorDimensionCount");
    public static final PathElement PATH$maxTensorElements = PathElement.groupElement("maxTensorElements");
    public static final PathElement PATH$maxPerDimensionTensorElements = PathElement.groupElement("maxPerDimensionTensorElements");
    public static final PathElement PATH$maxTensorStride = PathElement.groupElement("maxTensorStride");
    public static final PathElement PATH$maxTensorSize = PathElement.groupElement("maxTensorSize");
    public static final PathElement PATH$maxTensorShaderAccessArrayLength = PathElement.groupElement("maxTensorShaderAccessArrayLength");
    public static final PathElement PATH$maxTensorShaderAccessSize = PathElement.groupElement("maxTensorShaderAccessSize");
    public static final PathElement PATH$maxDescriptorSetStorageTensors = PathElement.groupElement("maxDescriptorSetStorageTensors");
    public static final PathElement PATH$maxPerStageDescriptorSetStorageTensors = PathElement.groupElement("maxPerStageDescriptorSetStorageTensors");
    public static final PathElement PATH$maxDescriptorSetUpdateAfterBindStorageTensors = PathElement.groupElement("maxDescriptorSetUpdateAfterBindStorageTensors");
    public static final PathElement PATH$maxPerStageDescriptorUpdateAfterBindStorageTensors = PathElement.groupElement("maxPerStageDescriptorUpdateAfterBindStorageTensors");
    public static final PathElement PATH$shaderStorageTensorArrayNonUniformIndexingNative = PathElement.groupElement("shaderStorageTensorArrayNonUniformIndexingNative");
    public static final PathElement PATH$shaderTensorSupportedStages = PathElement.groupElement("shaderTensorSupportedStages");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$maxTensorDimensionCount = (OfInt) LAYOUT.select(PATH$maxTensorDimensionCount);
    public static final OfLong LAYOUT$maxTensorElements = (OfLong) LAYOUT.select(PATH$maxTensorElements);
    public static final OfLong LAYOUT$maxPerDimensionTensorElements = (OfLong) LAYOUT.select(PATH$maxPerDimensionTensorElements);
    public static final OfLong LAYOUT$maxTensorStride = (OfLong) LAYOUT.select(PATH$maxTensorStride);
    public static final OfLong LAYOUT$maxTensorSize = (OfLong) LAYOUT.select(PATH$maxTensorSize);
    public static final OfInt LAYOUT$maxTensorShaderAccessArrayLength = (OfInt) LAYOUT.select(PATH$maxTensorShaderAccessArrayLength);
    public static final OfInt LAYOUT$maxTensorShaderAccessSize = (OfInt) LAYOUT.select(PATH$maxTensorShaderAccessSize);
    public static final OfInt LAYOUT$maxDescriptorSetStorageTensors = (OfInt) LAYOUT.select(PATH$maxDescriptorSetStorageTensors);
    public static final OfInt LAYOUT$maxPerStageDescriptorSetStorageTensors = (OfInt) LAYOUT.select(PATH$maxPerStageDescriptorSetStorageTensors);
    public static final OfInt LAYOUT$maxDescriptorSetUpdateAfterBindStorageTensors = (OfInt) LAYOUT.select(PATH$maxDescriptorSetUpdateAfterBindStorageTensors);
    public static final OfInt LAYOUT$maxPerStageDescriptorUpdateAfterBindStorageTensors = (OfInt) LAYOUT.select(PATH$maxPerStageDescriptorUpdateAfterBindStorageTensors);
    public static final OfInt LAYOUT$shaderStorageTensorArrayNonUniformIndexingNative = (OfInt) LAYOUT.select(PATH$shaderStorageTensorArrayNonUniformIndexingNative);
    public static final OfInt LAYOUT$shaderTensorSupportedStages = (OfInt) LAYOUT.select(PATH$shaderTensorSupportedStages);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$maxTensorDimensionCount = LAYOUT$maxTensorDimensionCount.byteSize();
    public static final long SIZE$maxTensorElements = LAYOUT$maxTensorElements.byteSize();
    public static final long SIZE$maxPerDimensionTensorElements = LAYOUT$maxPerDimensionTensorElements.byteSize();
    public static final long SIZE$maxTensorStride = LAYOUT$maxTensorStride.byteSize();
    public static final long SIZE$maxTensorSize = LAYOUT$maxTensorSize.byteSize();
    public static final long SIZE$maxTensorShaderAccessArrayLength = LAYOUT$maxTensorShaderAccessArrayLength.byteSize();
    public static final long SIZE$maxTensorShaderAccessSize = LAYOUT$maxTensorShaderAccessSize.byteSize();
    public static final long SIZE$maxDescriptorSetStorageTensors = LAYOUT$maxDescriptorSetStorageTensors.byteSize();
    public static final long SIZE$maxPerStageDescriptorSetStorageTensors = LAYOUT$maxPerStageDescriptorSetStorageTensors.byteSize();
    public static final long SIZE$maxDescriptorSetUpdateAfterBindStorageTensors = LAYOUT$maxDescriptorSetUpdateAfterBindStorageTensors.byteSize();
    public static final long SIZE$maxPerStageDescriptorUpdateAfterBindStorageTensors = LAYOUT$maxPerStageDescriptorUpdateAfterBindStorageTensors.byteSize();
    public static final long SIZE$shaderStorageTensorArrayNonUniformIndexingNative = LAYOUT$shaderStorageTensorArrayNonUniformIndexingNative.byteSize();
    public static final long SIZE$shaderTensorSupportedStages = LAYOUT$shaderTensorSupportedStages.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$maxTensorDimensionCount = LAYOUT.byteOffset(PATH$maxTensorDimensionCount);
    public static final long OFFSET$maxTensorElements = LAYOUT.byteOffset(PATH$maxTensorElements);
    public static final long OFFSET$maxPerDimensionTensorElements = LAYOUT.byteOffset(PATH$maxPerDimensionTensorElements);
    public static final long OFFSET$maxTensorStride = LAYOUT.byteOffset(PATH$maxTensorStride);
    public static final long OFFSET$maxTensorSize = LAYOUT.byteOffset(PATH$maxTensorSize);
    public static final long OFFSET$maxTensorShaderAccessArrayLength = LAYOUT.byteOffset(PATH$maxTensorShaderAccessArrayLength);
    public static final long OFFSET$maxTensorShaderAccessSize = LAYOUT.byteOffset(PATH$maxTensorShaderAccessSize);
    public static final long OFFSET$maxDescriptorSetStorageTensors = LAYOUT.byteOffset(PATH$maxDescriptorSetStorageTensors);
    public static final long OFFSET$maxPerStageDescriptorSetStorageTensors = LAYOUT.byteOffset(PATH$maxPerStageDescriptorSetStorageTensors);
    public static final long OFFSET$maxDescriptorSetUpdateAfterBindStorageTensors = LAYOUT.byteOffset(PATH$maxDescriptorSetUpdateAfterBindStorageTensors);
    public static final long OFFSET$maxPerStageDescriptorUpdateAfterBindStorageTensors = LAYOUT.byteOffset(PATH$maxPerStageDescriptorUpdateAfterBindStorageTensors);
    public static final long OFFSET$shaderStorageTensorArrayNonUniformIndexingNative = LAYOUT.byteOffset(PATH$shaderStorageTensorArrayNonUniformIndexingNative);
    public static final long OFFSET$shaderTensorSupportedStages = LAYOUT.byteOffset(PATH$shaderTensorSupportedStages);
}
