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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceConservativeRasterizationPropertiesEXT.html"><code>VkPhysicalDeviceConservativeRasterizationPropertiesEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceConservativeRasterizationPropertiesEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     float primitiveOverestimationSize; // @link substring="primitiveOverestimationSize" target="#primitiveOverestimationSize"
///     float maxExtraPrimitiveOverestimationSize; // @link substring="maxExtraPrimitiveOverestimationSize" target="#maxExtraPrimitiveOverestimationSize"
///     float extraPrimitiveOverestimationSizeGranularity; // @link substring="extraPrimitiveOverestimationSizeGranularity" target="#extraPrimitiveOverestimationSizeGranularity"
///     VkBool32 primitiveUnderestimation; // @link substring="primitiveUnderestimation" target="#primitiveUnderestimation"
///     VkBool32 conservativePointAndLineRasterization; // @link substring="conservativePointAndLineRasterization" target="#conservativePointAndLineRasterization"
///     VkBool32 degenerateTrianglesRasterized; // @link substring="degenerateTrianglesRasterized" target="#degenerateTrianglesRasterized"
///     VkBool32 degenerateLinesRasterized; // @link substring="degenerateLinesRasterized" target="#degenerateLinesRasterized"
///     VkBool32 fullyCoveredFragmentShaderInputVariable; // @link substring="fullyCoveredFragmentShaderInputVariable" target="#fullyCoveredFragmentShaderInputVariable"
///     VkBool32 conservativeRasterizationPostDepthCoverage; // @link substring="conservativeRasterizationPostDepthCoverage" target="#conservativeRasterizationPostDepthCoverage"
/// } VkPhysicalDeviceConservativeRasterizationPropertiesEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_CONSERVATIVE_RASTERIZATION_PROPERTIES_EXT`
///
/// The {@code allocate} ({@link VkPhysicalDeviceConservativeRasterizationPropertiesEXT#allocate(Arena)}, {@link VkPhysicalDeviceConservativeRasterizationPropertiesEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceConservativeRasterizationPropertiesEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceConservativeRasterizationPropertiesEXT.html"><code>VkPhysicalDeviceConservativeRasterizationPropertiesEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceConservativeRasterizationPropertiesEXT(@NotNull MemorySegment segment) implements IVkPhysicalDeviceConservativeRasterizationPropertiesEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceConservativeRasterizationPropertiesEXT.html"><code>VkPhysicalDeviceConservativeRasterizationPropertiesEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceConservativeRasterizationPropertiesEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceConservativeRasterizationPropertiesEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceConservativeRasterizationPropertiesEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceConservativeRasterizationPropertiesEXT, Iterable<VkPhysicalDeviceConservativeRasterizationPropertiesEXT> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceConservativeRasterizationPropertiesEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceConservativeRasterizationPropertiesEXT at(long index) {
            return new VkPhysicalDeviceConservativeRasterizationPropertiesEXT(segment.asSlice(index * VkPhysicalDeviceConservativeRasterizationPropertiesEXT.BYTES, VkPhysicalDeviceConservativeRasterizationPropertiesEXT.BYTES));
        }

        public VkPhysicalDeviceConservativeRasterizationPropertiesEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceConservativeRasterizationPropertiesEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceConservativeRasterizationPropertiesEXT value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceConservativeRasterizationPropertiesEXT.BYTES, VkPhysicalDeviceConservativeRasterizationPropertiesEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceConservativeRasterizationPropertiesEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceConservativeRasterizationPropertiesEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceConservativeRasterizationPropertiesEXT.BYTES,
                (end - start) * VkPhysicalDeviceConservativeRasterizationPropertiesEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceConservativeRasterizationPropertiesEXT.BYTES));
        }

        public VkPhysicalDeviceConservativeRasterizationPropertiesEXT[] toArray() {
            VkPhysicalDeviceConservativeRasterizationPropertiesEXT[] ret = new VkPhysicalDeviceConservativeRasterizationPropertiesEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceConservativeRasterizationPropertiesEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceConservativeRasterizationPropertiesEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceConservativeRasterizationPropertiesEXT.BYTES;
            }

            @Override
            public VkPhysicalDeviceConservativeRasterizationPropertiesEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceConservativeRasterizationPropertiesEXT ret = new VkPhysicalDeviceConservativeRasterizationPropertiesEXT(segment.asSlice(0, VkPhysicalDeviceConservativeRasterizationPropertiesEXT.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceConservativeRasterizationPropertiesEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceConservativeRasterizationPropertiesEXT allocate(Arena arena) {
        VkPhysicalDeviceConservativeRasterizationPropertiesEXT ret = new VkPhysicalDeviceConservativeRasterizationPropertiesEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_CONSERVATIVE_RASTERIZATION_PROPERTIES_EXT);
        return ret;
    }

    public static VkPhysicalDeviceConservativeRasterizationPropertiesEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceConservativeRasterizationPropertiesEXT.Ptr ret = new VkPhysicalDeviceConservativeRasterizationPropertiesEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_CONSERVATIVE_RASTERIZATION_PROPERTIES_EXT);
        }
        return ret;
    }

    public static VkPhysicalDeviceConservativeRasterizationPropertiesEXT clone(Arena arena, VkPhysicalDeviceConservativeRasterizationPropertiesEXT src) {
        VkPhysicalDeviceConservativeRasterizationPropertiesEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_CONSERVATIVE_RASTERIZATION_PROPERTIES_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceConservativeRasterizationPropertiesEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceConservativeRasterizationPropertiesEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceConservativeRasterizationPropertiesEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public float primitiveOverestimationSize() {
        return segment.get(LAYOUT$primitiveOverestimationSize, OFFSET$primitiveOverestimationSize);
    }

    public VkPhysicalDeviceConservativeRasterizationPropertiesEXT primitiveOverestimationSize(float value) {
        segment.set(LAYOUT$primitiveOverestimationSize, OFFSET$primitiveOverestimationSize, value);
        return this;
    }

    public float maxExtraPrimitiveOverestimationSize() {
        return segment.get(LAYOUT$maxExtraPrimitiveOverestimationSize, OFFSET$maxExtraPrimitiveOverestimationSize);
    }

    public VkPhysicalDeviceConservativeRasterizationPropertiesEXT maxExtraPrimitiveOverestimationSize(float value) {
        segment.set(LAYOUT$maxExtraPrimitiveOverestimationSize, OFFSET$maxExtraPrimitiveOverestimationSize, value);
        return this;
    }

    public float extraPrimitiveOverestimationSizeGranularity() {
        return segment.get(LAYOUT$extraPrimitiveOverestimationSizeGranularity, OFFSET$extraPrimitiveOverestimationSizeGranularity);
    }

    public VkPhysicalDeviceConservativeRasterizationPropertiesEXT extraPrimitiveOverestimationSizeGranularity(float value) {
        segment.set(LAYOUT$extraPrimitiveOverestimationSizeGranularity, OFFSET$extraPrimitiveOverestimationSizeGranularity, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int primitiveUnderestimation() {
        return segment.get(LAYOUT$primitiveUnderestimation, OFFSET$primitiveUnderestimation);
    }

    public VkPhysicalDeviceConservativeRasterizationPropertiesEXT primitiveUnderestimation(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$primitiveUnderestimation, OFFSET$primitiveUnderestimation, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int conservativePointAndLineRasterization() {
        return segment.get(LAYOUT$conservativePointAndLineRasterization, OFFSET$conservativePointAndLineRasterization);
    }

    public VkPhysicalDeviceConservativeRasterizationPropertiesEXT conservativePointAndLineRasterization(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$conservativePointAndLineRasterization, OFFSET$conservativePointAndLineRasterization, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int degenerateTrianglesRasterized() {
        return segment.get(LAYOUT$degenerateTrianglesRasterized, OFFSET$degenerateTrianglesRasterized);
    }

    public VkPhysicalDeviceConservativeRasterizationPropertiesEXT degenerateTrianglesRasterized(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$degenerateTrianglesRasterized, OFFSET$degenerateTrianglesRasterized, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int degenerateLinesRasterized() {
        return segment.get(LAYOUT$degenerateLinesRasterized, OFFSET$degenerateLinesRasterized);
    }

    public VkPhysicalDeviceConservativeRasterizationPropertiesEXT degenerateLinesRasterized(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$degenerateLinesRasterized, OFFSET$degenerateLinesRasterized, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int fullyCoveredFragmentShaderInputVariable() {
        return segment.get(LAYOUT$fullyCoveredFragmentShaderInputVariable, OFFSET$fullyCoveredFragmentShaderInputVariable);
    }

    public VkPhysicalDeviceConservativeRasterizationPropertiesEXT fullyCoveredFragmentShaderInputVariable(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$fullyCoveredFragmentShaderInputVariable, OFFSET$fullyCoveredFragmentShaderInputVariable, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int conservativeRasterizationPostDepthCoverage() {
        return segment.get(LAYOUT$conservativeRasterizationPostDepthCoverage, OFFSET$conservativeRasterizationPostDepthCoverage);
    }

    public VkPhysicalDeviceConservativeRasterizationPropertiesEXT conservativeRasterizationPostDepthCoverage(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$conservativeRasterizationPostDepthCoverage, OFFSET$conservativeRasterizationPostDepthCoverage, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_FLOAT.withName("primitiveOverestimationSize"),
        ValueLayout.JAVA_FLOAT.withName("maxExtraPrimitiveOverestimationSize"),
        ValueLayout.JAVA_FLOAT.withName("extraPrimitiveOverestimationSizeGranularity"),
        ValueLayout.JAVA_INT.withName("primitiveUnderestimation"),
        ValueLayout.JAVA_INT.withName("conservativePointAndLineRasterization"),
        ValueLayout.JAVA_INT.withName("degenerateTrianglesRasterized"),
        ValueLayout.JAVA_INT.withName("degenerateLinesRasterized"),
        ValueLayout.JAVA_INT.withName("fullyCoveredFragmentShaderInputVariable"),
        ValueLayout.JAVA_INT.withName("conservativeRasterizationPostDepthCoverage")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$primitiveOverestimationSize = PathElement.groupElement("primitiveOverestimationSize");
    public static final PathElement PATH$maxExtraPrimitiveOverestimationSize = PathElement.groupElement("maxExtraPrimitiveOverestimationSize");
    public static final PathElement PATH$extraPrimitiveOverestimationSizeGranularity = PathElement.groupElement("extraPrimitiveOverestimationSizeGranularity");
    public static final PathElement PATH$primitiveUnderestimation = PathElement.groupElement("primitiveUnderestimation");
    public static final PathElement PATH$conservativePointAndLineRasterization = PathElement.groupElement("conservativePointAndLineRasterization");
    public static final PathElement PATH$degenerateTrianglesRasterized = PathElement.groupElement("degenerateTrianglesRasterized");
    public static final PathElement PATH$degenerateLinesRasterized = PathElement.groupElement("degenerateLinesRasterized");
    public static final PathElement PATH$fullyCoveredFragmentShaderInputVariable = PathElement.groupElement("fullyCoveredFragmentShaderInputVariable");
    public static final PathElement PATH$conservativeRasterizationPostDepthCoverage = PathElement.groupElement("conservativeRasterizationPostDepthCoverage");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfFloat LAYOUT$primitiveOverestimationSize = (OfFloat) LAYOUT.select(PATH$primitiveOverestimationSize);
    public static final OfFloat LAYOUT$maxExtraPrimitiveOverestimationSize = (OfFloat) LAYOUT.select(PATH$maxExtraPrimitiveOverestimationSize);
    public static final OfFloat LAYOUT$extraPrimitiveOverestimationSizeGranularity = (OfFloat) LAYOUT.select(PATH$extraPrimitiveOverestimationSizeGranularity);
    public static final OfInt LAYOUT$primitiveUnderestimation = (OfInt) LAYOUT.select(PATH$primitiveUnderestimation);
    public static final OfInt LAYOUT$conservativePointAndLineRasterization = (OfInt) LAYOUT.select(PATH$conservativePointAndLineRasterization);
    public static final OfInt LAYOUT$degenerateTrianglesRasterized = (OfInt) LAYOUT.select(PATH$degenerateTrianglesRasterized);
    public static final OfInt LAYOUT$degenerateLinesRasterized = (OfInt) LAYOUT.select(PATH$degenerateLinesRasterized);
    public static final OfInt LAYOUT$fullyCoveredFragmentShaderInputVariable = (OfInt) LAYOUT.select(PATH$fullyCoveredFragmentShaderInputVariable);
    public static final OfInt LAYOUT$conservativeRasterizationPostDepthCoverage = (OfInt) LAYOUT.select(PATH$conservativeRasterizationPostDepthCoverage);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$primitiveOverestimationSize = LAYOUT$primitiveOverestimationSize.byteSize();
    public static final long SIZE$maxExtraPrimitiveOverestimationSize = LAYOUT$maxExtraPrimitiveOverestimationSize.byteSize();
    public static final long SIZE$extraPrimitiveOverestimationSizeGranularity = LAYOUT$extraPrimitiveOverestimationSizeGranularity.byteSize();
    public static final long SIZE$primitiveUnderestimation = LAYOUT$primitiveUnderestimation.byteSize();
    public static final long SIZE$conservativePointAndLineRasterization = LAYOUT$conservativePointAndLineRasterization.byteSize();
    public static final long SIZE$degenerateTrianglesRasterized = LAYOUT$degenerateTrianglesRasterized.byteSize();
    public static final long SIZE$degenerateLinesRasterized = LAYOUT$degenerateLinesRasterized.byteSize();
    public static final long SIZE$fullyCoveredFragmentShaderInputVariable = LAYOUT$fullyCoveredFragmentShaderInputVariable.byteSize();
    public static final long SIZE$conservativeRasterizationPostDepthCoverage = LAYOUT$conservativeRasterizationPostDepthCoverage.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$primitiveOverestimationSize = LAYOUT.byteOffset(PATH$primitiveOverestimationSize);
    public static final long OFFSET$maxExtraPrimitiveOverestimationSize = LAYOUT.byteOffset(PATH$maxExtraPrimitiveOverestimationSize);
    public static final long OFFSET$extraPrimitiveOverestimationSizeGranularity = LAYOUT.byteOffset(PATH$extraPrimitiveOverestimationSizeGranularity);
    public static final long OFFSET$primitiveUnderestimation = LAYOUT.byteOffset(PATH$primitiveUnderestimation);
    public static final long OFFSET$conservativePointAndLineRasterization = LAYOUT.byteOffset(PATH$conservativePointAndLineRasterization);
    public static final long OFFSET$degenerateTrianglesRasterized = LAYOUT.byteOffset(PATH$degenerateTrianglesRasterized);
    public static final long OFFSET$degenerateLinesRasterized = LAYOUT.byteOffset(PATH$degenerateLinesRasterized);
    public static final long OFFSET$fullyCoveredFragmentShaderInputVariable = LAYOUT.byteOffset(PATH$fullyCoveredFragmentShaderInputVariable);
    public static final long OFFSET$conservativeRasterizationPostDepthCoverage = LAYOUT.byteOffset(PATH$conservativeRasterizationPostDepthCoverage);
}
