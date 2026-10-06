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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceShaderCorePropertiesAMD.html"><code>VkPhysicalDeviceShaderCorePropertiesAMD</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceShaderCorePropertiesAMD {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t shaderEngineCount; // @link substring="shaderEngineCount" target="#shaderEngineCount"
///     uint32_t shaderArraysPerEngineCount; // @link substring="shaderArraysPerEngineCount" target="#shaderArraysPerEngineCount"
///     uint32_t computeUnitsPerShaderArray; // @link substring="computeUnitsPerShaderArray" target="#computeUnitsPerShaderArray"
///     uint32_t simdPerComputeUnit; // @link substring="simdPerComputeUnit" target="#simdPerComputeUnit"
///     uint32_t wavefrontsPerSimd; // @link substring="wavefrontsPerSimd" target="#wavefrontsPerSimd"
///     uint32_t wavefrontSize; // @link substring="wavefrontSize" target="#wavefrontSize"
///     uint32_t sgprsPerSimd; // @link substring="sgprsPerSimd" target="#sgprsPerSimd"
///     uint32_t minSgprAllocation; // @link substring="minSgprAllocation" target="#minSgprAllocation"
///     uint32_t maxSgprAllocation; // @link substring="maxSgprAllocation" target="#maxSgprAllocation"
///     uint32_t sgprAllocationGranularity; // @link substring="sgprAllocationGranularity" target="#sgprAllocationGranularity"
///     uint32_t vgprsPerSimd; // @link substring="vgprsPerSimd" target="#vgprsPerSimd"
///     uint32_t minVgprAllocation; // @link substring="minVgprAllocation" target="#minVgprAllocation"
///     uint32_t maxVgprAllocation; // @link substring="maxVgprAllocation" target="#maxVgprAllocation"
///     uint32_t vgprAllocationGranularity; // @link substring="vgprAllocationGranularity" target="#vgprAllocationGranularity"
/// } VkPhysicalDeviceShaderCorePropertiesAMD;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SHADER_CORE_PROPERTIES_AMD`
///
/// The {@code allocate} ({@link VkPhysicalDeviceShaderCorePropertiesAMD#allocate(Arena)}, {@link VkPhysicalDeviceShaderCorePropertiesAMD#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceShaderCorePropertiesAMD#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceShaderCorePropertiesAMD.html"><code>VkPhysicalDeviceShaderCorePropertiesAMD</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceShaderCorePropertiesAMD(@NotNull MemorySegment segment) implements IVkPhysicalDeviceShaderCorePropertiesAMD {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceShaderCorePropertiesAMD.html"><code>VkPhysicalDeviceShaderCorePropertiesAMD</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceShaderCorePropertiesAMD}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceShaderCorePropertiesAMD to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceShaderCorePropertiesAMD.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceShaderCorePropertiesAMD, Iterable<VkPhysicalDeviceShaderCorePropertiesAMD> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceShaderCorePropertiesAMD.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceShaderCorePropertiesAMD at(long index) {
            return new VkPhysicalDeviceShaderCorePropertiesAMD(segment.asSlice(index * VkPhysicalDeviceShaderCorePropertiesAMD.BYTES, VkPhysicalDeviceShaderCorePropertiesAMD.BYTES));
        }

        public VkPhysicalDeviceShaderCorePropertiesAMD.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceShaderCorePropertiesAMD> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceShaderCorePropertiesAMD value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceShaderCorePropertiesAMD.BYTES, VkPhysicalDeviceShaderCorePropertiesAMD.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceShaderCorePropertiesAMD.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceShaderCorePropertiesAMD.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceShaderCorePropertiesAMD.BYTES,
                (end - start) * VkPhysicalDeviceShaderCorePropertiesAMD.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceShaderCorePropertiesAMD.BYTES));
        }

        public VkPhysicalDeviceShaderCorePropertiesAMD[] toArray() {
            VkPhysicalDeviceShaderCorePropertiesAMD[] ret = new VkPhysicalDeviceShaderCorePropertiesAMD[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceShaderCorePropertiesAMD> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceShaderCorePropertiesAMD> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceShaderCorePropertiesAMD.BYTES;
            }

            @Override
            public VkPhysicalDeviceShaderCorePropertiesAMD next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceShaderCorePropertiesAMD ret = new VkPhysicalDeviceShaderCorePropertiesAMD(segment.asSlice(0, VkPhysicalDeviceShaderCorePropertiesAMD.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceShaderCorePropertiesAMD.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceShaderCorePropertiesAMD allocate(Arena arena) {
        VkPhysicalDeviceShaderCorePropertiesAMD ret = new VkPhysicalDeviceShaderCorePropertiesAMD(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_SHADER_CORE_PROPERTIES_AMD);
        return ret;
    }

    public static VkPhysicalDeviceShaderCorePropertiesAMD.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceShaderCorePropertiesAMD.Ptr ret = new VkPhysicalDeviceShaderCorePropertiesAMD.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_SHADER_CORE_PROPERTIES_AMD);
        }
        return ret;
    }

    public static VkPhysicalDeviceShaderCorePropertiesAMD clone(Arena arena, VkPhysicalDeviceShaderCorePropertiesAMD src) {
        VkPhysicalDeviceShaderCorePropertiesAMD ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_SHADER_CORE_PROPERTIES_AMD);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceShaderCorePropertiesAMD sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceShaderCorePropertiesAMD pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceShaderCorePropertiesAMD pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int shaderEngineCount() {
        return segment.get(LAYOUT$shaderEngineCount, OFFSET$shaderEngineCount);
    }

    public VkPhysicalDeviceShaderCorePropertiesAMD shaderEngineCount(@Unsigned int value) {
        segment.set(LAYOUT$shaderEngineCount, OFFSET$shaderEngineCount, value);
        return this;
    }

    public @Unsigned int shaderArraysPerEngineCount() {
        return segment.get(LAYOUT$shaderArraysPerEngineCount, OFFSET$shaderArraysPerEngineCount);
    }

    public VkPhysicalDeviceShaderCorePropertiesAMD shaderArraysPerEngineCount(@Unsigned int value) {
        segment.set(LAYOUT$shaderArraysPerEngineCount, OFFSET$shaderArraysPerEngineCount, value);
        return this;
    }

    public @Unsigned int computeUnitsPerShaderArray() {
        return segment.get(LAYOUT$computeUnitsPerShaderArray, OFFSET$computeUnitsPerShaderArray);
    }

    public VkPhysicalDeviceShaderCorePropertiesAMD computeUnitsPerShaderArray(@Unsigned int value) {
        segment.set(LAYOUT$computeUnitsPerShaderArray, OFFSET$computeUnitsPerShaderArray, value);
        return this;
    }

    public @Unsigned int simdPerComputeUnit() {
        return segment.get(LAYOUT$simdPerComputeUnit, OFFSET$simdPerComputeUnit);
    }

    public VkPhysicalDeviceShaderCorePropertiesAMD simdPerComputeUnit(@Unsigned int value) {
        segment.set(LAYOUT$simdPerComputeUnit, OFFSET$simdPerComputeUnit, value);
        return this;
    }

    public @Unsigned int wavefrontsPerSimd() {
        return segment.get(LAYOUT$wavefrontsPerSimd, OFFSET$wavefrontsPerSimd);
    }

    public VkPhysicalDeviceShaderCorePropertiesAMD wavefrontsPerSimd(@Unsigned int value) {
        segment.set(LAYOUT$wavefrontsPerSimd, OFFSET$wavefrontsPerSimd, value);
        return this;
    }

    public @Unsigned int wavefrontSize() {
        return segment.get(LAYOUT$wavefrontSize, OFFSET$wavefrontSize);
    }

    public VkPhysicalDeviceShaderCorePropertiesAMD wavefrontSize(@Unsigned int value) {
        segment.set(LAYOUT$wavefrontSize, OFFSET$wavefrontSize, value);
        return this;
    }

    public @Unsigned int sgprsPerSimd() {
        return segment.get(LAYOUT$sgprsPerSimd, OFFSET$sgprsPerSimd);
    }

    public VkPhysicalDeviceShaderCorePropertiesAMD sgprsPerSimd(@Unsigned int value) {
        segment.set(LAYOUT$sgprsPerSimd, OFFSET$sgprsPerSimd, value);
        return this;
    }

    public @Unsigned int minSgprAllocation() {
        return segment.get(LAYOUT$minSgprAllocation, OFFSET$minSgprAllocation);
    }

    public VkPhysicalDeviceShaderCorePropertiesAMD minSgprAllocation(@Unsigned int value) {
        segment.set(LAYOUT$minSgprAllocation, OFFSET$minSgprAllocation, value);
        return this;
    }

    public @Unsigned int maxSgprAllocation() {
        return segment.get(LAYOUT$maxSgprAllocation, OFFSET$maxSgprAllocation);
    }

    public VkPhysicalDeviceShaderCorePropertiesAMD maxSgprAllocation(@Unsigned int value) {
        segment.set(LAYOUT$maxSgprAllocation, OFFSET$maxSgprAllocation, value);
        return this;
    }

    public @Unsigned int sgprAllocationGranularity() {
        return segment.get(LAYOUT$sgprAllocationGranularity, OFFSET$sgprAllocationGranularity);
    }

    public VkPhysicalDeviceShaderCorePropertiesAMD sgprAllocationGranularity(@Unsigned int value) {
        segment.set(LAYOUT$sgprAllocationGranularity, OFFSET$sgprAllocationGranularity, value);
        return this;
    }

    public @Unsigned int vgprsPerSimd() {
        return segment.get(LAYOUT$vgprsPerSimd, OFFSET$vgprsPerSimd);
    }

    public VkPhysicalDeviceShaderCorePropertiesAMD vgprsPerSimd(@Unsigned int value) {
        segment.set(LAYOUT$vgprsPerSimd, OFFSET$vgprsPerSimd, value);
        return this;
    }

    public @Unsigned int minVgprAllocation() {
        return segment.get(LAYOUT$minVgprAllocation, OFFSET$minVgprAllocation);
    }

    public VkPhysicalDeviceShaderCorePropertiesAMD minVgprAllocation(@Unsigned int value) {
        segment.set(LAYOUT$minVgprAllocation, OFFSET$minVgprAllocation, value);
        return this;
    }

    public @Unsigned int maxVgprAllocation() {
        return segment.get(LAYOUT$maxVgprAllocation, OFFSET$maxVgprAllocation);
    }

    public VkPhysicalDeviceShaderCorePropertiesAMD maxVgprAllocation(@Unsigned int value) {
        segment.set(LAYOUT$maxVgprAllocation, OFFSET$maxVgprAllocation, value);
        return this;
    }

    public @Unsigned int vgprAllocationGranularity() {
        return segment.get(LAYOUT$vgprAllocationGranularity, OFFSET$vgprAllocationGranularity);
    }

    public VkPhysicalDeviceShaderCorePropertiesAMD vgprAllocationGranularity(@Unsigned int value) {
        segment.set(LAYOUT$vgprAllocationGranularity, OFFSET$vgprAllocationGranularity, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("shaderEngineCount"),
        ValueLayout.JAVA_INT.withName("shaderArraysPerEngineCount"),
        ValueLayout.JAVA_INT.withName("computeUnitsPerShaderArray"),
        ValueLayout.JAVA_INT.withName("simdPerComputeUnit"),
        ValueLayout.JAVA_INT.withName("wavefrontsPerSimd"),
        ValueLayout.JAVA_INT.withName("wavefrontSize"),
        ValueLayout.JAVA_INT.withName("sgprsPerSimd"),
        ValueLayout.JAVA_INT.withName("minSgprAllocation"),
        ValueLayout.JAVA_INT.withName("maxSgprAllocation"),
        ValueLayout.JAVA_INT.withName("sgprAllocationGranularity"),
        ValueLayout.JAVA_INT.withName("vgprsPerSimd"),
        ValueLayout.JAVA_INT.withName("minVgprAllocation"),
        ValueLayout.JAVA_INT.withName("maxVgprAllocation"),
        ValueLayout.JAVA_INT.withName("vgprAllocationGranularity")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$shaderEngineCount = PathElement.groupElement("shaderEngineCount");
    public static final PathElement PATH$shaderArraysPerEngineCount = PathElement.groupElement("shaderArraysPerEngineCount");
    public static final PathElement PATH$computeUnitsPerShaderArray = PathElement.groupElement("computeUnitsPerShaderArray");
    public static final PathElement PATH$simdPerComputeUnit = PathElement.groupElement("simdPerComputeUnit");
    public static final PathElement PATH$wavefrontsPerSimd = PathElement.groupElement("wavefrontsPerSimd");
    public static final PathElement PATH$wavefrontSize = PathElement.groupElement("wavefrontSize");
    public static final PathElement PATH$sgprsPerSimd = PathElement.groupElement("sgprsPerSimd");
    public static final PathElement PATH$minSgprAllocation = PathElement.groupElement("minSgprAllocation");
    public static final PathElement PATH$maxSgprAllocation = PathElement.groupElement("maxSgprAllocation");
    public static final PathElement PATH$sgprAllocationGranularity = PathElement.groupElement("sgprAllocationGranularity");
    public static final PathElement PATH$vgprsPerSimd = PathElement.groupElement("vgprsPerSimd");
    public static final PathElement PATH$minVgprAllocation = PathElement.groupElement("minVgprAllocation");
    public static final PathElement PATH$maxVgprAllocation = PathElement.groupElement("maxVgprAllocation");
    public static final PathElement PATH$vgprAllocationGranularity = PathElement.groupElement("vgprAllocationGranularity");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$shaderEngineCount = (OfInt) LAYOUT.select(PATH$shaderEngineCount);
    public static final OfInt LAYOUT$shaderArraysPerEngineCount = (OfInt) LAYOUT.select(PATH$shaderArraysPerEngineCount);
    public static final OfInt LAYOUT$computeUnitsPerShaderArray = (OfInt) LAYOUT.select(PATH$computeUnitsPerShaderArray);
    public static final OfInt LAYOUT$simdPerComputeUnit = (OfInt) LAYOUT.select(PATH$simdPerComputeUnit);
    public static final OfInt LAYOUT$wavefrontsPerSimd = (OfInt) LAYOUT.select(PATH$wavefrontsPerSimd);
    public static final OfInt LAYOUT$wavefrontSize = (OfInt) LAYOUT.select(PATH$wavefrontSize);
    public static final OfInt LAYOUT$sgprsPerSimd = (OfInt) LAYOUT.select(PATH$sgprsPerSimd);
    public static final OfInt LAYOUT$minSgprAllocation = (OfInt) LAYOUT.select(PATH$minSgprAllocation);
    public static final OfInt LAYOUT$maxSgprAllocation = (OfInt) LAYOUT.select(PATH$maxSgprAllocation);
    public static final OfInt LAYOUT$sgprAllocationGranularity = (OfInt) LAYOUT.select(PATH$sgprAllocationGranularity);
    public static final OfInt LAYOUT$vgprsPerSimd = (OfInt) LAYOUT.select(PATH$vgprsPerSimd);
    public static final OfInt LAYOUT$minVgprAllocation = (OfInt) LAYOUT.select(PATH$minVgprAllocation);
    public static final OfInt LAYOUT$maxVgprAllocation = (OfInt) LAYOUT.select(PATH$maxVgprAllocation);
    public static final OfInt LAYOUT$vgprAllocationGranularity = (OfInt) LAYOUT.select(PATH$vgprAllocationGranularity);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$shaderEngineCount = LAYOUT$shaderEngineCount.byteSize();
    public static final long SIZE$shaderArraysPerEngineCount = LAYOUT$shaderArraysPerEngineCount.byteSize();
    public static final long SIZE$computeUnitsPerShaderArray = LAYOUT$computeUnitsPerShaderArray.byteSize();
    public static final long SIZE$simdPerComputeUnit = LAYOUT$simdPerComputeUnit.byteSize();
    public static final long SIZE$wavefrontsPerSimd = LAYOUT$wavefrontsPerSimd.byteSize();
    public static final long SIZE$wavefrontSize = LAYOUT$wavefrontSize.byteSize();
    public static final long SIZE$sgprsPerSimd = LAYOUT$sgprsPerSimd.byteSize();
    public static final long SIZE$minSgprAllocation = LAYOUT$minSgprAllocation.byteSize();
    public static final long SIZE$maxSgprAllocation = LAYOUT$maxSgprAllocation.byteSize();
    public static final long SIZE$sgprAllocationGranularity = LAYOUT$sgprAllocationGranularity.byteSize();
    public static final long SIZE$vgprsPerSimd = LAYOUT$vgprsPerSimd.byteSize();
    public static final long SIZE$minVgprAllocation = LAYOUT$minVgprAllocation.byteSize();
    public static final long SIZE$maxVgprAllocation = LAYOUT$maxVgprAllocation.byteSize();
    public static final long SIZE$vgprAllocationGranularity = LAYOUT$vgprAllocationGranularity.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$shaderEngineCount = LAYOUT.byteOffset(PATH$shaderEngineCount);
    public static final long OFFSET$shaderArraysPerEngineCount = LAYOUT.byteOffset(PATH$shaderArraysPerEngineCount);
    public static final long OFFSET$computeUnitsPerShaderArray = LAYOUT.byteOffset(PATH$computeUnitsPerShaderArray);
    public static final long OFFSET$simdPerComputeUnit = LAYOUT.byteOffset(PATH$simdPerComputeUnit);
    public static final long OFFSET$wavefrontsPerSimd = LAYOUT.byteOffset(PATH$wavefrontsPerSimd);
    public static final long OFFSET$wavefrontSize = LAYOUT.byteOffset(PATH$wavefrontSize);
    public static final long OFFSET$sgprsPerSimd = LAYOUT.byteOffset(PATH$sgprsPerSimd);
    public static final long OFFSET$minSgprAllocation = LAYOUT.byteOffset(PATH$minSgprAllocation);
    public static final long OFFSET$maxSgprAllocation = LAYOUT.byteOffset(PATH$maxSgprAllocation);
    public static final long OFFSET$sgprAllocationGranularity = LAYOUT.byteOffset(PATH$sgprAllocationGranularity);
    public static final long OFFSET$vgprsPerSimd = LAYOUT.byteOffset(PATH$vgprsPerSimd);
    public static final long OFFSET$minVgprAllocation = LAYOUT.byteOffset(PATH$minVgprAllocation);
    public static final long OFFSET$maxVgprAllocation = LAYOUT.byteOffset(PATH$maxVgprAllocation);
    public static final long OFFSET$vgprAllocationGranularity = LAYOUT.byteOffset(PATH$vgprAllocationGranularity);
}
