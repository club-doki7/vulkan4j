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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceSubgroupSizeControlProperties.html"><code>VkPhysicalDeviceSubgroupSizeControlProperties</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceSubgroupSizeControlProperties {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t minSubgroupSize; // @link substring="minSubgroupSize" target="#minSubgroupSize"
///     uint32_t maxSubgroupSize; // @link substring="maxSubgroupSize" target="#maxSubgroupSize"
///     uint32_t maxComputeWorkgroupSubgroups; // @link substring="maxComputeWorkgroupSubgroups" target="#maxComputeWorkgroupSubgroups"
///     VkShaderStageFlags requiredSubgroupSizeStages; // @link substring="VkShaderStageFlags" target="VkShaderStageFlags" @link substring="requiredSubgroupSizeStages" target="#requiredSubgroupSizeStages"
/// } VkPhysicalDeviceSubgroupSizeControlProperties;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SUBGROUP_SIZE_CONTROL_PROPERTIES`
///
/// The {@code allocate} ({@link VkPhysicalDeviceSubgroupSizeControlProperties#allocate(Arena)}, {@link VkPhysicalDeviceSubgroupSizeControlProperties#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceSubgroupSizeControlProperties#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceSubgroupSizeControlProperties.html"><code>VkPhysicalDeviceSubgroupSizeControlProperties</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceSubgroupSizeControlProperties(@NotNull MemorySegment segment) implements IVkPhysicalDeviceSubgroupSizeControlProperties {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceSubgroupSizeControlProperties.html"><code>VkPhysicalDeviceSubgroupSizeControlProperties</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceSubgroupSizeControlProperties}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceSubgroupSizeControlProperties to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceSubgroupSizeControlProperties.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceSubgroupSizeControlProperties, Iterable<VkPhysicalDeviceSubgroupSizeControlProperties> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceSubgroupSizeControlProperties.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceSubgroupSizeControlProperties at(long index) {
            return new VkPhysicalDeviceSubgroupSizeControlProperties(segment.asSlice(index * VkPhysicalDeviceSubgroupSizeControlProperties.BYTES, VkPhysicalDeviceSubgroupSizeControlProperties.BYTES));
        }

        public VkPhysicalDeviceSubgroupSizeControlProperties.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceSubgroupSizeControlProperties> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceSubgroupSizeControlProperties value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceSubgroupSizeControlProperties.BYTES, VkPhysicalDeviceSubgroupSizeControlProperties.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceSubgroupSizeControlProperties.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceSubgroupSizeControlProperties.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceSubgroupSizeControlProperties.BYTES,
                (end - start) * VkPhysicalDeviceSubgroupSizeControlProperties.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceSubgroupSizeControlProperties.BYTES));
        }

        public VkPhysicalDeviceSubgroupSizeControlProperties[] toArray() {
            VkPhysicalDeviceSubgroupSizeControlProperties[] ret = new VkPhysicalDeviceSubgroupSizeControlProperties[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceSubgroupSizeControlProperties> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceSubgroupSizeControlProperties> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceSubgroupSizeControlProperties.BYTES;
            }

            @Override
            public VkPhysicalDeviceSubgroupSizeControlProperties next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceSubgroupSizeControlProperties ret = new VkPhysicalDeviceSubgroupSizeControlProperties(segment.asSlice(0, VkPhysicalDeviceSubgroupSizeControlProperties.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceSubgroupSizeControlProperties.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceSubgroupSizeControlProperties allocate(Arena arena) {
        VkPhysicalDeviceSubgroupSizeControlProperties ret = new VkPhysicalDeviceSubgroupSizeControlProperties(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_SUBGROUP_SIZE_CONTROL_PROPERTIES);
        return ret;
    }

    public static VkPhysicalDeviceSubgroupSizeControlProperties.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceSubgroupSizeControlProperties.Ptr ret = new VkPhysicalDeviceSubgroupSizeControlProperties.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_SUBGROUP_SIZE_CONTROL_PROPERTIES);
        }
        return ret;
    }

    public static VkPhysicalDeviceSubgroupSizeControlProperties clone(Arena arena, VkPhysicalDeviceSubgroupSizeControlProperties src) {
        VkPhysicalDeviceSubgroupSizeControlProperties ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_SUBGROUP_SIZE_CONTROL_PROPERTIES);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceSubgroupSizeControlProperties sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceSubgroupSizeControlProperties pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceSubgroupSizeControlProperties pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int minSubgroupSize() {
        return segment.get(LAYOUT$minSubgroupSize, OFFSET$minSubgroupSize);
    }

    public VkPhysicalDeviceSubgroupSizeControlProperties minSubgroupSize(@Unsigned int value) {
        segment.set(LAYOUT$minSubgroupSize, OFFSET$minSubgroupSize, value);
        return this;
    }

    public @Unsigned int maxSubgroupSize() {
        return segment.get(LAYOUT$maxSubgroupSize, OFFSET$maxSubgroupSize);
    }

    public VkPhysicalDeviceSubgroupSizeControlProperties maxSubgroupSize(@Unsigned int value) {
        segment.set(LAYOUT$maxSubgroupSize, OFFSET$maxSubgroupSize, value);
        return this;
    }

    public @Unsigned int maxComputeWorkgroupSubgroups() {
        return segment.get(LAYOUT$maxComputeWorkgroupSubgroups, OFFSET$maxComputeWorkgroupSubgroups);
    }

    public VkPhysicalDeviceSubgroupSizeControlProperties maxComputeWorkgroupSubgroups(@Unsigned int value) {
        segment.set(LAYOUT$maxComputeWorkgroupSubgroups, OFFSET$maxComputeWorkgroupSubgroups, value);
        return this;
    }

    public @Bitmask(VkShaderStageFlags.class) int requiredSubgroupSizeStages() {
        return segment.get(LAYOUT$requiredSubgroupSizeStages, OFFSET$requiredSubgroupSizeStages);
    }

    public VkPhysicalDeviceSubgroupSizeControlProperties requiredSubgroupSizeStages(@Bitmask(VkShaderStageFlags.class) int value) {
        segment.set(LAYOUT$requiredSubgroupSizeStages, OFFSET$requiredSubgroupSizeStages, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("minSubgroupSize"),
        ValueLayout.JAVA_INT.withName("maxSubgroupSize"),
        ValueLayout.JAVA_INT.withName("maxComputeWorkgroupSubgroups"),
        ValueLayout.JAVA_INT.withName("requiredSubgroupSizeStages")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$minSubgroupSize = PathElement.groupElement("minSubgroupSize");
    public static final PathElement PATH$maxSubgroupSize = PathElement.groupElement("maxSubgroupSize");
    public static final PathElement PATH$maxComputeWorkgroupSubgroups = PathElement.groupElement("maxComputeWorkgroupSubgroups");
    public static final PathElement PATH$requiredSubgroupSizeStages = PathElement.groupElement("requiredSubgroupSizeStages");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$minSubgroupSize = (OfInt) LAYOUT.select(PATH$minSubgroupSize);
    public static final OfInt LAYOUT$maxSubgroupSize = (OfInt) LAYOUT.select(PATH$maxSubgroupSize);
    public static final OfInt LAYOUT$maxComputeWorkgroupSubgroups = (OfInt) LAYOUT.select(PATH$maxComputeWorkgroupSubgroups);
    public static final OfInt LAYOUT$requiredSubgroupSizeStages = (OfInt) LAYOUT.select(PATH$requiredSubgroupSizeStages);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$minSubgroupSize = LAYOUT$minSubgroupSize.byteSize();
    public static final long SIZE$maxSubgroupSize = LAYOUT$maxSubgroupSize.byteSize();
    public static final long SIZE$maxComputeWorkgroupSubgroups = LAYOUT$maxComputeWorkgroupSubgroups.byteSize();
    public static final long SIZE$requiredSubgroupSizeStages = LAYOUT$requiredSubgroupSizeStages.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$minSubgroupSize = LAYOUT.byteOffset(PATH$minSubgroupSize);
    public static final long OFFSET$maxSubgroupSize = LAYOUT.byteOffset(PATH$maxSubgroupSize);
    public static final long OFFSET$maxComputeWorkgroupSubgroups = LAYOUT.byteOffset(PATH$maxComputeWorkgroupSubgroups);
    public static final long OFFSET$requiredSubgroupSizeStages = LAYOUT.byteOffset(PATH$requiredSubgroupSizeStages);
}
