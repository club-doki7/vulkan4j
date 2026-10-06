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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceFragmentDensityMap2PropertiesEXT.html"><code>VkPhysicalDeviceFragmentDensityMap2PropertiesEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceFragmentDensityMap2PropertiesEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 subsampledLoads; // @link substring="subsampledLoads" target="#subsampledLoads"
///     VkBool32 subsampledCoarseReconstructionEarlyAccess; // @link substring="subsampledCoarseReconstructionEarlyAccess" target="#subsampledCoarseReconstructionEarlyAccess"
///     uint32_t maxSubsampledArrayLayers; // @link substring="maxSubsampledArrayLayers" target="#maxSubsampledArrayLayers"
///     uint32_t maxDescriptorSetSubsampledSamplers; // @link substring="maxDescriptorSetSubsampledSamplers" target="#maxDescriptorSetSubsampledSamplers"
/// } VkPhysicalDeviceFragmentDensityMap2PropertiesEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_FRAGMENT_DENSITY_MAP_2_PROPERTIES_EXT`
///
/// The {@code allocate} ({@link VkPhysicalDeviceFragmentDensityMap2PropertiesEXT#allocate(Arena)}, {@link VkPhysicalDeviceFragmentDensityMap2PropertiesEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceFragmentDensityMap2PropertiesEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceFragmentDensityMap2PropertiesEXT.html"><code>VkPhysicalDeviceFragmentDensityMap2PropertiesEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceFragmentDensityMap2PropertiesEXT(@NotNull MemorySegment segment) implements IVkPhysicalDeviceFragmentDensityMap2PropertiesEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceFragmentDensityMap2PropertiesEXT.html"><code>VkPhysicalDeviceFragmentDensityMap2PropertiesEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceFragmentDensityMap2PropertiesEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceFragmentDensityMap2PropertiesEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceFragmentDensityMap2PropertiesEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceFragmentDensityMap2PropertiesEXT, Iterable<VkPhysicalDeviceFragmentDensityMap2PropertiesEXT> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceFragmentDensityMap2PropertiesEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceFragmentDensityMap2PropertiesEXT at(long index) {
            return new VkPhysicalDeviceFragmentDensityMap2PropertiesEXT(segment.asSlice(index * VkPhysicalDeviceFragmentDensityMap2PropertiesEXT.BYTES, VkPhysicalDeviceFragmentDensityMap2PropertiesEXT.BYTES));
        }

        public VkPhysicalDeviceFragmentDensityMap2PropertiesEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceFragmentDensityMap2PropertiesEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceFragmentDensityMap2PropertiesEXT value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceFragmentDensityMap2PropertiesEXT.BYTES, VkPhysicalDeviceFragmentDensityMap2PropertiesEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceFragmentDensityMap2PropertiesEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceFragmentDensityMap2PropertiesEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceFragmentDensityMap2PropertiesEXT.BYTES,
                (end - start) * VkPhysicalDeviceFragmentDensityMap2PropertiesEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceFragmentDensityMap2PropertiesEXT.BYTES));
        }

        public VkPhysicalDeviceFragmentDensityMap2PropertiesEXT[] toArray() {
            VkPhysicalDeviceFragmentDensityMap2PropertiesEXT[] ret = new VkPhysicalDeviceFragmentDensityMap2PropertiesEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceFragmentDensityMap2PropertiesEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceFragmentDensityMap2PropertiesEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceFragmentDensityMap2PropertiesEXT.BYTES;
            }

            @Override
            public VkPhysicalDeviceFragmentDensityMap2PropertiesEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceFragmentDensityMap2PropertiesEXT ret = new VkPhysicalDeviceFragmentDensityMap2PropertiesEXT(segment.asSlice(0, VkPhysicalDeviceFragmentDensityMap2PropertiesEXT.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceFragmentDensityMap2PropertiesEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceFragmentDensityMap2PropertiesEXT allocate(Arena arena) {
        VkPhysicalDeviceFragmentDensityMap2PropertiesEXT ret = new VkPhysicalDeviceFragmentDensityMap2PropertiesEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_FRAGMENT_DENSITY_MAP_2_PROPERTIES_EXT);
        return ret;
    }

    public static VkPhysicalDeviceFragmentDensityMap2PropertiesEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceFragmentDensityMap2PropertiesEXT.Ptr ret = new VkPhysicalDeviceFragmentDensityMap2PropertiesEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_FRAGMENT_DENSITY_MAP_2_PROPERTIES_EXT);
        }
        return ret;
    }

    public static VkPhysicalDeviceFragmentDensityMap2PropertiesEXT clone(Arena arena, VkPhysicalDeviceFragmentDensityMap2PropertiesEXT src) {
        VkPhysicalDeviceFragmentDensityMap2PropertiesEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_FRAGMENT_DENSITY_MAP_2_PROPERTIES_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceFragmentDensityMap2PropertiesEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceFragmentDensityMap2PropertiesEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceFragmentDensityMap2PropertiesEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int subsampledLoads() {
        return segment.get(LAYOUT$subsampledLoads, OFFSET$subsampledLoads);
    }

    public VkPhysicalDeviceFragmentDensityMap2PropertiesEXT subsampledLoads(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$subsampledLoads, OFFSET$subsampledLoads, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int subsampledCoarseReconstructionEarlyAccess() {
        return segment.get(LAYOUT$subsampledCoarseReconstructionEarlyAccess, OFFSET$subsampledCoarseReconstructionEarlyAccess);
    }

    public VkPhysicalDeviceFragmentDensityMap2PropertiesEXT subsampledCoarseReconstructionEarlyAccess(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$subsampledCoarseReconstructionEarlyAccess, OFFSET$subsampledCoarseReconstructionEarlyAccess, value);
        return this;
    }

    public @Unsigned int maxSubsampledArrayLayers() {
        return segment.get(LAYOUT$maxSubsampledArrayLayers, OFFSET$maxSubsampledArrayLayers);
    }

    public VkPhysicalDeviceFragmentDensityMap2PropertiesEXT maxSubsampledArrayLayers(@Unsigned int value) {
        segment.set(LAYOUT$maxSubsampledArrayLayers, OFFSET$maxSubsampledArrayLayers, value);
        return this;
    }

    public @Unsigned int maxDescriptorSetSubsampledSamplers() {
        return segment.get(LAYOUT$maxDescriptorSetSubsampledSamplers, OFFSET$maxDescriptorSetSubsampledSamplers);
    }

    public VkPhysicalDeviceFragmentDensityMap2PropertiesEXT maxDescriptorSetSubsampledSamplers(@Unsigned int value) {
        segment.set(LAYOUT$maxDescriptorSetSubsampledSamplers, OFFSET$maxDescriptorSetSubsampledSamplers, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("subsampledLoads"),
        ValueLayout.JAVA_INT.withName("subsampledCoarseReconstructionEarlyAccess"),
        ValueLayout.JAVA_INT.withName("maxSubsampledArrayLayers"),
        ValueLayout.JAVA_INT.withName("maxDescriptorSetSubsampledSamplers")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$subsampledLoads = PathElement.groupElement("subsampledLoads");
    public static final PathElement PATH$subsampledCoarseReconstructionEarlyAccess = PathElement.groupElement("subsampledCoarseReconstructionEarlyAccess");
    public static final PathElement PATH$maxSubsampledArrayLayers = PathElement.groupElement("maxSubsampledArrayLayers");
    public static final PathElement PATH$maxDescriptorSetSubsampledSamplers = PathElement.groupElement("maxDescriptorSetSubsampledSamplers");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$subsampledLoads = (OfInt) LAYOUT.select(PATH$subsampledLoads);
    public static final OfInt LAYOUT$subsampledCoarseReconstructionEarlyAccess = (OfInt) LAYOUT.select(PATH$subsampledCoarseReconstructionEarlyAccess);
    public static final OfInt LAYOUT$maxSubsampledArrayLayers = (OfInt) LAYOUT.select(PATH$maxSubsampledArrayLayers);
    public static final OfInt LAYOUT$maxDescriptorSetSubsampledSamplers = (OfInt) LAYOUT.select(PATH$maxDescriptorSetSubsampledSamplers);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$subsampledLoads = LAYOUT$subsampledLoads.byteSize();
    public static final long SIZE$subsampledCoarseReconstructionEarlyAccess = LAYOUT$subsampledCoarseReconstructionEarlyAccess.byteSize();
    public static final long SIZE$maxSubsampledArrayLayers = LAYOUT$maxSubsampledArrayLayers.byteSize();
    public static final long SIZE$maxDescriptorSetSubsampledSamplers = LAYOUT$maxDescriptorSetSubsampledSamplers.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$subsampledLoads = LAYOUT.byteOffset(PATH$subsampledLoads);
    public static final long OFFSET$subsampledCoarseReconstructionEarlyAccess = LAYOUT.byteOffset(PATH$subsampledCoarseReconstructionEarlyAccess);
    public static final long OFFSET$maxSubsampledArrayLayers = LAYOUT.byteOffset(PATH$maxSubsampledArrayLayers);
    public static final long OFFSET$maxDescriptorSetSubsampledSamplers = LAYOUT.byteOffset(PATH$maxDescriptorSetSubsampledSamplers);
}
