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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceExtendedDynamicState3FeaturesEXT.html"><code>VkPhysicalDeviceExtendedDynamicState3FeaturesEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceExtendedDynamicState3FeaturesEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 extendedDynamicState3TessellationDomainOrigin; // @link substring="extendedDynamicState3TessellationDomainOrigin" target="#extendedDynamicState3TessellationDomainOrigin"
///     VkBool32 extendedDynamicState3DepthClampEnable; // @link substring="extendedDynamicState3DepthClampEnable" target="#extendedDynamicState3DepthClampEnable"
///     VkBool32 extendedDynamicState3PolygonMode; // @link substring="extendedDynamicState3PolygonMode" target="#extendedDynamicState3PolygonMode"
///     VkBool32 extendedDynamicState3RasterizationSamples; // @link substring="extendedDynamicState3RasterizationSamples" target="#extendedDynamicState3RasterizationSamples"
///     VkBool32 extendedDynamicState3SampleMask; // @link substring="extendedDynamicState3SampleMask" target="#extendedDynamicState3SampleMask"
///     VkBool32 extendedDynamicState3AlphaToCoverageEnable; // @link substring="extendedDynamicState3AlphaToCoverageEnable" target="#extendedDynamicState3AlphaToCoverageEnable"
///     VkBool32 extendedDynamicState3AlphaToOneEnable; // @link substring="extendedDynamicState3AlphaToOneEnable" target="#extendedDynamicState3AlphaToOneEnable"
///     VkBool32 extendedDynamicState3LogicOpEnable; // @link substring="extendedDynamicState3LogicOpEnable" target="#extendedDynamicState3LogicOpEnable"
///     VkBool32 extendedDynamicState3ColorBlendEnable; // @link substring="extendedDynamicState3ColorBlendEnable" target="#extendedDynamicState3ColorBlendEnable"
///     VkBool32 extendedDynamicState3ColorBlendEquation; // @link substring="extendedDynamicState3ColorBlendEquation" target="#extendedDynamicState3ColorBlendEquation"
///     VkBool32 extendedDynamicState3ColorWriteMask; // @link substring="extendedDynamicState3ColorWriteMask" target="#extendedDynamicState3ColorWriteMask"
///     VkBool32 extendedDynamicState3RasterizationStream; // @link substring="extendedDynamicState3RasterizationStream" target="#extendedDynamicState3RasterizationStream"
///     VkBool32 extendedDynamicState3ConservativeRasterizationMode; // @link substring="extendedDynamicState3ConservativeRasterizationMode" target="#extendedDynamicState3ConservativeRasterizationMode"
///     VkBool32 extendedDynamicState3ExtraPrimitiveOverestimationSize; // @link substring="extendedDynamicState3ExtraPrimitiveOverestimationSize" target="#extendedDynamicState3ExtraPrimitiveOverestimationSize"
///     VkBool32 extendedDynamicState3DepthClipEnable; // @link substring="extendedDynamicState3DepthClipEnable" target="#extendedDynamicState3DepthClipEnable"
///     VkBool32 extendedDynamicState3SampleLocationsEnable; // @link substring="extendedDynamicState3SampleLocationsEnable" target="#extendedDynamicState3SampleLocationsEnable"
///     VkBool32 extendedDynamicState3ColorBlendAdvanced; // @link substring="extendedDynamicState3ColorBlendAdvanced" target="#extendedDynamicState3ColorBlendAdvanced"
///     VkBool32 extendedDynamicState3ProvokingVertexMode; // @link substring="extendedDynamicState3ProvokingVertexMode" target="#extendedDynamicState3ProvokingVertexMode"
///     VkBool32 extendedDynamicState3LineRasterizationMode; // @link substring="extendedDynamicState3LineRasterizationMode" target="#extendedDynamicState3LineRasterizationMode"
///     VkBool32 extendedDynamicState3LineStippleEnable; // @link substring="extendedDynamicState3LineStippleEnable" target="#extendedDynamicState3LineStippleEnable"
///     VkBool32 extendedDynamicState3DepthClipNegativeOneToOne; // @link substring="extendedDynamicState3DepthClipNegativeOneToOne" target="#extendedDynamicState3DepthClipNegativeOneToOne"
///     VkBool32 extendedDynamicState3ViewportWScalingEnable; // @link substring="extendedDynamicState3ViewportWScalingEnable" target="#extendedDynamicState3ViewportWScalingEnable"
///     VkBool32 extendedDynamicState3ViewportSwizzle; // @link substring="extendedDynamicState3ViewportSwizzle" target="#extendedDynamicState3ViewportSwizzle"
///     VkBool32 extendedDynamicState3CoverageToColorEnable; // @link substring="extendedDynamicState3CoverageToColorEnable" target="#extendedDynamicState3CoverageToColorEnable"
///     VkBool32 extendedDynamicState3CoverageToColorLocation; // @link substring="extendedDynamicState3CoverageToColorLocation" target="#extendedDynamicState3CoverageToColorLocation"
///     VkBool32 extendedDynamicState3CoverageModulationMode; // @link substring="extendedDynamicState3CoverageModulationMode" target="#extendedDynamicState3CoverageModulationMode"
///     VkBool32 extendedDynamicState3CoverageModulationTableEnable; // @link substring="extendedDynamicState3CoverageModulationTableEnable" target="#extendedDynamicState3CoverageModulationTableEnable"
///     VkBool32 extendedDynamicState3CoverageModulationTable; // @link substring="extendedDynamicState3CoverageModulationTable" target="#extendedDynamicState3CoverageModulationTable"
///     VkBool32 extendedDynamicState3CoverageReductionMode; // @link substring="extendedDynamicState3CoverageReductionMode" target="#extendedDynamicState3CoverageReductionMode"
///     VkBool32 extendedDynamicState3RepresentativeFragmentTestEnable; // @link substring="extendedDynamicState3RepresentativeFragmentTestEnable" target="#extendedDynamicState3RepresentativeFragmentTestEnable"
///     VkBool32 extendedDynamicState3ShadingRateImageEnable; // @link substring="extendedDynamicState3ShadingRateImageEnable" target="#extendedDynamicState3ShadingRateImageEnable"
/// } VkPhysicalDeviceExtendedDynamicState3FeaturesEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_EXTENDED_DYNAMIC_STATE_3_FEATURES_EXT`
///
/// The {@code allocate} ({@link VkPhysicalDeviceExtendedDynamicState3FeaturesEXT#allocate(Arena)}, {@link VkPhysicalDeviceExtendedDynamicState3FeaturesEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceExtendedDynamicState3FeaturesEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceExtendedDynamicState3FeaturesEXT.html"><code>VkPhysicalDeviceExtendedDynamicState3FeaturesEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceExtendedDynamicState3FeaturesEXT(@NotNull MemorySegment segment) implements IVkPhysicalDeviceExtendedDynamicState3FeaturesEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceExtendedDynamicState3FeaturesEXT.html"><code>VkPhysicalDeviceExtendedDynamicState3FeaturesEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceExtendedDynamicState3FeaturesEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceExtendedDynamicState3FeaturesEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceExtendedDynamicState3FeaturesEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceExtendedDynamicState3FeaturesEXT, Iterable<VkPhysicalDeviceExtendedDynamicState3FeaturesEXT> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceExtendedDynamicState3FeaturesEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceExtendedDynamicState3FeaturesEXT at(long index) {
            return new VkPhysicalDeviceExtendedDynamicState3FeaturesEXT(segment.asSlice(index * VkPhysicalDeviceExtendedDynamicState3FeaturesEXT.BYTES, VkPhysicalDeviceExtendedDynamicState3FeaturesEXT.BYTES));
        }

        public VkPhysicalDeviceExtendedDynamicState3FeaturesEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceExtendedDynamicState3FeaturesEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceExtendedDynamicState3FeaturesEXT value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceExtendedDynamicState3FeaturesEXT.BYTES, VkPhysicalDeviceExtendedDynamicState3FeaturesEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceExtendedDynamicState3FeaturesEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceExtendedDynamicState3FeaturesEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceExtendedDynamicState3FeaturesEXT.BYTES,
                (end - start) * VkPhysicalDeviceExtendedDynamicState3FeaturesEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceExtendedDynamicState3FeaturesEXT.BYTES));
        }

        public VkPhysicalDeviceExtendedDynamicState3FeaturesEXT[] toArray() {
            VkPhysicalDeviceExtendedDynamicState3FeaturesEXT[] ret = new VkPhysicalDeviceExtendedDynamicState3FeaturesEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceExtendedDynamicState3FeaturesEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceExtendedDynamicState3FeaturesEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceExtendedDynamicState3FeaturesEXT.BYTES;
            }

            @Override
            public VkPhysicalDeviceExtendedDynamicState3FeaturesEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceExtendedDynamicState3FeaturesEXT ret = new VkPhysicalDeviceExtendedDynamicState3FeaturesEXT(segment.asSlice(0, VkPhysicalDeviceExtendedDynamicState3FeaturesEXT.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceExtendedDynamicState3FeaturesEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceExtendedDynamicState3FeaturesEXT allocate(Arena arena) {
        VkPhysicalDeviceExtendedDynamicState3FeaturesEXT ret = new VkPhysicalDeviceExtendedDynamicState3FeaturesEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_EXTENDED_DYNAMIC_STATE_3_FEATURES_EXT);
        return ret;
    }

    public static VkPhysicalDeviceExtendedDynamicState3FeaturesEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceExtendedDynamicState3FeaturesEXT.Ptr ret = new VkPhysicalDeviceExtendedDynamicState3FeaturesEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_EXTENDED_DYNAMIC_STATE_3_FEATURES_EXT);
        }
        return ret;
    }

    public static VkPhysicalDeviceExtendedDynamicState3FeaturesEXT clone(Arena arena, VkPhysicalDeviceExtendedDynamicState3FeaturesEXT src) {
        VkPhysicalDeviceExtendedDynamicState3FeaturesEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_EXTENDED_DYNAMIC_STATE_3_FEATURES_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceExtendedDynamicState3FeaturesEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceExtendedDynamicState3FeaturesEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceExtendedDynamicState3FeaturesEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int extendedDynamicState3TessellationDomainOrigin() {
        return segment.get(LAYOUT$extendedDynamicState3TessellationDomainOrigin, OFFSET$extendedDynamicState3TessellationDomainOrigin);
    }

    public VkPhysicalDeviceExtendedDynamicState3FeaturesEXT extendedDynamicState3TessellationDomainOrigin(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$extendedDynamicState3TessellationDomainOrigin, OFFSET$extendedDynamicState3TessellationDomainOrigin, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int extendedDynamicState3DepthClampEnable() {
        return segment.get(LAYOUT$extendedDynamicState3DepthClampEnable, OFFSET$extendedDynamicState3DepthClampEnable);
    }

    public VkPhysicalDeviceExtendedDynamicState3FeaturesEXT extendedDynamicState3DepthClampEnable(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$extendedDynamicState3DepthClampEnable, OFFSET$extendedDynamicState3DepthClampEnable, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int extendedDynamicState3PolygonMode() {
        return segment.get(LAYOUT$extendedDynamicState3PolygonMode, OFFSET$extendedDynamicState3PolygonMode);
    }

    public VkPhysicalDeviceExtendedDynamicState3FeaturesEXT extendedDynamicState3PolygonMode(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$extendedDynamicState3PolygonMode, OFFSET$extendedDynamicState3PolygonMode, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int extendedDynamicState3RasterizationSamples() {
        return segment.get(LAYOUT$extendedDynamicState3RasterizationSamples, OFFSET$extendedDynamicState3RasterizationSamples);
    }

    public VkPhysicalDeviceExtendedDynamicState3FeaturesEXT extendedDynamicState3RasterizationSamples(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$extendedDynamicState3RasterizationSamples, OFFSET$extendedDynamicState3RasterizationSamples, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int extendedDynamicState3SampleMask() {
        return segment.get(LAYOUT$extendedDynamicState3SampleMask, OFFSET$extendedDynamicState3SampleMask);
    }

    public VkPhysicalDeviceExtendedDynamicState3FeaturesEXT extendedDynamicState3SampleMask(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$extendedDynamicState3SampleMask, OFFSET$extendedDynamicState3SampleMask, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int extendedDynamicState3AlphaToCoverageEnable() {
        return segment.get(LAYOUT$extendedDynamicState3AlphaToCoverageEnable, OFFSET$extendedDynamicState3AlphaToCoverageEnable);
    }

    public VkPhysicalDeviceExtendedDynamicState3FeaturesEXT extendedDynamicState3AlphaToCoverageEnable(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$extendedDynamicState3AlphaToCoverageEnable, OFFSET$extendedDynamicState3AlphaToCoverageEnable, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int extendedDynamicState3AlphaToOneEnable() {
        return segment.get(LAYOUT$extendedDynamicState3AlphaToOneEnable, OFFSET$extendedDynamicState3AlphaToOneEnable);
    }

    public VkPhysicalDeviceExtendedDynamicState3FeaturesEXT extendedDynamicState3AlphaToOneEnable(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$extendedDynamicState3AlphaToOneEnable, OFFSET$extendedDynamicState3AlphaToOneEnable, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int extendedDynamicState3LogicOpEnable() {
        return segment.get(LAYOUT$extendedDynamicState3LogicOpEnable, OFFSET$extendedDynamicState3LogicOpEnable);
    }

    public VkPhysicalDeviceExtendedDynamicState3FeaturesEXT extendedDynamicState3LogicOpEnable(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$extendedDynamicState3LogicOpEnable, OFFSET$extendedDynamicState3LogicOpEnable, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int extendedDynamicState3ColorBlendEnable() {
        return segment.get(LAYOUT$extendedDynamicState3ColorBlendEnable, OFFSET$extendedDynamicState3ColorBlendEnable);
    }

    public VkPhysicalDeviceExtendedDynamicState3FeaturesEXT extendedDynamicState3ColorBlendEnable(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$extendedDynamicState3ColorBlendEnable, OFFSET$extendedDynamicState3ColorBlendEnable, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int extendedDynamicState3ColorBlendEquation() {
        return segment.get(LAYOUT$extendedDynamicState3ColorBlendEquation, OFFSET$extendedDynamicState3ColorBlendEquation);
    }

    public VkPhysicalDeviceExtendedDynamicState3FeaturesEXT extendedDynamicState3ColorBlendEquation(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$extendedDynamicState3ColorBlendEquation, OFFSET$extendedDynamicState3ColorBlendEquation, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int extendedDynamicState3ColorWriteMask() {
        return segment.get(LAYOUT$extendedDynamicState3ColorWriteMask, OFFSET$extendedDynamicState3ColorWriteMask);
    }

    public VkPhysicalDeviceExtendedDynamicState3FeaturesEXT extendedDynamicState3ColorWriteMask(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$extendedDynamicState3ColorWriteMask, OFFSET$extendedDynamicState3ColorWriteMask, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int extendedDynamicState3RasterizationStream() {
        return segment.get(LAYOUT$extendedDynamicState3RasterizationStream, OFFSET$extendedDynamicState3RasterizationStream);
    }

    public VkPhysicalDeviceExtendedDynamicState3FeaturesEXT extendedDynamicState3RasterizationStream(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$extendedDynamicState3RasterizationStream, OFFSET$extendedDynamicState3RasterizationStream, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int extendedDynamicState3ConservativeRasterizationMode() {
        return segment.get(LAYOUT$extendedDynamicState3ConservativeRasterizationMode, OFFSET$extendedDynamicState3ConservativeRasterizationMode);
    }

    public VkPhysicalDeviceExtendedDynamicState3FeaturesEXT extendedDynamicState3ConservativeRasterizationMode(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$extendedDynamicState3ConservativeRasterizationMode, OFFSET$extendedDynamicState3ConservativeRasterizationMode, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int extendedDynamicState3ExtraPrimitiveOverestimationSize() {
        return segment.get(LAYOUT$extendedDynamicState3ExtraPrimitiveOverestimationSize, OFFSET$extendedDynamicState3ExtraPrimitiveOverestimationSize);
    }

    public VkPhysicalDeviceExtendedDynamicState3FeaturesEXT extendedDynamicState3ExtraPrimitiveOverestimationSize(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$extendedDynamicState3ExtraPrimitiveOverestimationSize, OFFSET$extendedDynamicState3ExtraPrimitiveOverestimationSize, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int extendedDynamicState3DepthClipEnable() {
        return segment.get(LAYOUT$extendedDynamicState3DepthClipEnable, OFFSET$extendedDynamicState3DepthClipEnable);
    }

    public VkPhysicalDeviceExtendedDynamicState3FeaturesEXT extendedDynamicState3DepthClipEnable(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$extendedDynamicState3DepthClipEnable, OFFSET$extendedDynamicState3DepthClipEnable, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int extendedDynamicState3SampleLocationsEnable() {
        return segment.get(LAYOUT$extendedDynamicState3SampleLocationsEnable, OFFSET$extendedDynamicState3SampleLocationsEnable);
    }

    public VkPhysicalDeviceExtendedDynamicState3FeaturesEXT extendedDynamicState3SampleLocationsEnable(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$extendedDynamicState3SampleLocationsEnable, OFFSET$extendedDynamicState3SampleLocationsEnable, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int extendedDynamicState3ColorBlendAdvanced() {
        return segment.get(LAYOUT$extendedDynamicState3ColorBlendAdvanced, OFFSET$extendedDynamicState3ColorBlendAdvanced);
    }

    public VkPhysicalDeviceExtendedDynamicState3FeaturesEXT extendedDynamicState3ColorBlendAdvanced(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$extendedDynamicState3ColorBlendAdvanced, OFFSET$extendedDynamicState3ColorBlendAdvanced, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int extendedDynamicState3ProvokingVertexMode() {
        return segment.get(LAYOUT$extendedDynamicState3ProvokingVertexMode, OFFSET$extendedDynamicState3ProvokingVertexMode);
    }

    public VkPhysicalDeviceExtendedDynamicState3FeaturesEXT extendedDynamicState3ProvokingVertexMode(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$extendedDynamicState3ProvokingVertexMode, OFFSET$extendedDynamicState3ProvokingVertexMode, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int extendedDynamicState3LineRasterizationMode() {
        return segment.get(LAYOUT$extendedDynamicState3LineRasterizationMode, OFFSET$extendedDynamicState3LineRasterizationMode);
    }

    public VkPhysicalDeviceExtendedDynamicState3FeaturesEXT extendedDynamicState3LineRasterizationMode(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$extendedDynamicState3LineRasterizationMode, OFFSET$extendedDynamicState3LineRasterizationMode, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int extendedDynamicState3LineStippleEnable() {
        return segment.get(LAYOUT$extendedDynamicState3LineStippleEnable, OFFSET$extendedDynamicState3LineStippleEnable);
    }

    public VkPhysicalDeviceExtendedDynamicState3FeaturesEXT extendedDynamicState3LineStippleEnable(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$extendedDynamicState3LineStippleEnable, OFFSET$extendedDynamicState3LineStippleEnable, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int extendedDynamicState3DepthClipNegativeOneToOne() {
        return segment.get(LAYOUT$extendedDynamicState3DepthClipNegativeOneToOne, OFFSET$extendedDynamicState3DepthClipNegativeOneToOne);
    }

    public VkPhysicalDeviceExtendedDynamicState3FeaturesEXT extendedDynamicState3DepthClipNegativeOneToOne(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$extendedDynamicState3DepthClipNegativeOneToOne, OFFSET$extendedDynamicState3DepthClipNegativeOneToOne, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int extendedDynamicState3ViewportWScalingEnable() {
        return segment.get(LAYOUT$extendedDynamicState3ViewportWScalingEnable, OFFSET$extendedDynamicState3ViewportWScalingEnable);
    }

    public VkPhysicalDeviceExtendedDynamicState3FeaturesEXT extendedDynamicState3ViewportWScalingEnable(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$extendedDynamicState3ViewportWScalingEnable, OFFSET$extendedDynamicState3ViewportWScalingEnable, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int extendedDynamicState3ViewportSwizzle() {
        return segment.get(LAYOUT$extendedDynamicState3ViewportSwizzle, OFFSET$extendedDynamicState3ViewportSwizzle);
    }

    public VkPhysicalDeviceExtendedDynamicState3FeaturesEXT extendedDynamicState3ViewportSwizzle(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$extendedDynamicState3ViewportSwizzle, OFFSET$extendedDynamicState3ViewportSwizzle, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int extendedDynamicState3CoverageToColorEnable() {
        return segment.get(LAYOUT$extendedDynamicState3CoverageToColorEnable, OFFSET$extendedDynamicState3CoverageToColorEnable);
    }

    public VkPhysicalDeviceExtendedDynamicState3FeaturesEXT extendedDynamicState3CoverageToColorEnable(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$extendedDynamicState3CoverageToColorEnable, OFFSET$extendedDynamicState3CoverageToColorEnable, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int extendedDynamicState3CoverageToColorLocation() {
        return segment.get(LAYOUT$extendedDynamicState3CoverageToColorLocation, OFFSET$extendedDynamicState3CoverageToColorLocation);
    }

    public VkPhysicalDeviceExtendedDynamicState3FeaturesEXT extendedDynamicState3CoverageToColorLocation(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$extendedDynamicState3CoverageToColorLocation, OFFSET$extendedDynamicState3CoverageToColorLocation, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int extendedDynamicState3CoverageModulationMode() {
        return segment.get(LAYOUT$extendedDynamicState3CoverageModulationMode, OFFSET$extendedDynamicState3CoverageModulationMode);
    }

    public VkPhysicalDeviceExtendedDynamicState3FeaturesEXT extendedDynamicState3CoverageModulationMode(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$extendedDynamicState3CoverageModulationMode, OFFSET$extendedDynamicState3CoverageModulationMode, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int extendedDynamicState3CoverageModulationTableEnable() {
        return segment.get(LAYOUT$extendedDynamicState3CoverageModulationTableEnable, OFFSET$extendedDynamicState3CoverageModulationTableEnable);
    }

    public VkPhysicalDeviceExtendedDynamicState3FeaturesEXT extendedDynamicState3CoverageModulationTableEnable(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$extendedDynamicState3CoverageModulationTableEnable, OFFSET$extendedDynamicState3CoverageModulationTableEnable, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int extendedDynamicState3CoverageModulationTable() {
        return segment.get(LAYOUT$extendedDynamicState3CoverageModulationTable, OFFSET$extendedDynamicState3CoverageModulationTable);
    }

    public VkPhysicalDeviceExtendedDynamicState3FeaturesEXT extendedDynamicState3CoverageModulationTable(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$extendedDynamicState3CoverageModulationTable, OFFSET$extendedDynamicState3CoverageModulationTable, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int extendedDynamicState3CoverageReductionMode() {
        return segment.get(LAYOUT$extendedDynamicState3CoverageReductionMode, OFFSET$extendedDynamicState3CoverageReductionMode);
    }

    public VkPhysicalDeviceExtendedDynamicState3FeaturesEXT extendedDynamicState3CoverageReductionMode(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$extendedDynamicState3CoverageReductionMode, OFFSET$extendedDynamicState3CoverageReductionMode, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int extendedDynamicState3RepresentativeFragmentTestEnable() {
        return segment.get(LAYOUT$extendedDynamicState3RepresentativeFragmentTestEnable, OFFSET$extendedDynamicState3RepresentativeFragmentTestEnable);
    }

    public VkPhysicalDeviceExtendedDynamicState3FeaturesEXT extendedDynamicState3RepresentativeFragmentTestEnable(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$extendedDynamicState3RepresentativeFragmentTestEnable, OFFSET$extendedDynamicState3RepresentativeFragmentTestEnable, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int extendedDynamicState3ShadingRateImageEnable() {
        return segment.get(LAYOUT$extendedDynamicState3ShadingRateImageEnable, OFFSET$extendedDynamicState3ShadingRateImageEnable);
    }

    public VkPhysicalDeviceExtendedDynamicState3FeaturesEXT extendedDynamicState3ShadingRateImageEnable(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$extendedDynamicState3ShadingRateImageEnable, OFFSET$extendedDynamicState3ShadingRateImageEnable, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("extendedDynamicState3TessellationDomainOrigin"),
        ValueLayout.JAVA_INT.withName("extendedDynamicState3DepthClampEnable"),
        ValueLayout.JAVA_INT.withName("extendedDynamicState3PolygonMode"),
        ValueLayout.JAVA_INT.withName("extendedDynamicState3RasterizationSamples"),
        ValueLayout.JAVA_INT.withName("extendedDynamicState3SampleMask"),
        ValueLayout.JAVA_INT.withName("extendedDynamicState3AlphaToCoverageEnable"),
        ValueLayout.JAVA_INT.withName("extendedDynamicState3AlphaToOneEnable"),
        ValueLayout.JAVA_INT.withName("extendedDynamicState3LogicOpEnable"),
        ValueLayout.JAVA_INT.withName("extendedDynamicState3ColorBlendEnable"),
        ValueLayout.JAVA_INT.withName("extendedDynamicState3ColorBlendEquation"),
        ValueLayout.JAVA_INT.withName("extendedDynamicState3ColorWriteMask"),
        ValueLayout.JAVA_INT.withName("extendedDynamicState3RasterizationStream"),
        ValueLayout.JAVA_INT.withName("extendedDynamicState3ConservativeRasterizationMode"),
        ValueLayout.JAVA_INT.withName("extendedDynamicState3ExtraPrimitiveOverestimationSize"),
        ValueLayout.JAVA_INT.withName("extendedDynamicState3DepthClipEnable"),
        ValueLayout.JAVA_INT.withName("extendedDynamicState3SampleLocationsEnable"),
        ValueLayout.JAVA_INT.withName("extendedDynamicState3ColorBlendAdvanced"),
        ValueLayout.JAVA_INT.withName("extendedDynamicState3ProvokingVertexMode"),
        ValueLayout.JAVA_INT.withName("extendedDynamicState3LineRasterizationMode"),
        ValueLayout.JAVA_INT.withName("extendedDynamicState3LineStippleEnable"),
        ValueLayout.JAVA_INT.withName("extendedDynamicState3DepthClipNegativeOneToOne"),
        ValueLayout.JAVA_INT.withName("extendedDynamicState3ViewportWScalingEnable"),
        ValueLayout.JAVA_INT.withName("extendedDynamicState3ViewportSwizzle"),
        ValueLayout.JAVA_INT.withName("extendedDynamicState3CoverageToColorEnable"),
        ValueLayout.JAVA_INT.withName("extendedDynamicState3CoverageToColorLocation"),
        ValueLayout.JAVA_INT.withName("extendedDynamicState3CoverageModulationMode"),
        ValueLayout.JAVA_INT.withName("extendedDynamicState3CoverageModulationTableEnable"),
        ValueLayout.JAVA_INT.withName("extendedDynamicState3CoverageModulationTable"),
        ValueLayout.JAVA_INT.withName("extendedDynamicState3CoverageReductionMode"),
        ValueLayout.JAVA_INT.withName("extendedDynamicState3RepresentativeFragmentTestEnable"),
        ValueLayout.JAVA_INT.withName("extendedDynamicState3ShadingRateImageEnable")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$extendedDynamicState3TessellationDomainOrigin = PathElement.groupElement("extendedDynamicState3TessellationDomainOrigin");
    public static final PathElement PATH$extendedDynamicState3DepthClampEnable = PathElement.groupElement("extendedDynamicState3DepthClampEnable");
    public static final PathElement PATH$extendedDynamicState3PolygonMode = PathElement.groupElement("extendedDynamicState3PolygonMode");
    public static final PathElement PATH$extendedDynamicState3RasterizationSamples = PathElement.groupElement("extendedDynamicState3RasterizationSamples");
    public static final PathElement PATH$extendedDynamicState3SampleMask = PathElement.groupElement("extendedDynamicState3SampleMask");
    public static final PathElement PATH$extendedDynamicState3AlphaToCoverageEnable = PathElement.groupElement("extendedDynamicState3AlphaToCoverageEnable");
    public static final PathElement PATH$extendedDynamicState3AlphaToOneEnable = PathElement.groupElement("extendedDynamicState3AlphaToOneEnable");
    public static final PathElement PATH$extendedDynamicState3LogicOpEnable = PathElement.groupElement("extendedDynamicState3LogicOpEnable");
    public static final PathElement PATH$extendedDynamicState3ColorBlendEnable = PathElement.groupElement("extendedDynamicState3ColorBlendEnable");
    public static final PathElement PATH$extendedDynamicState3ColorBlendEquation = PathElement.groupElement("extendedDynamicState3ColorBlendEquation");
    public static final PathElement PATH$extendedDynamicState3ColorWriteMask = PathElement.groupElement("extendedDynamicState3ColorWriteMask");
    public static final PathElement PATH$extendedDynamicState3RasterizationStream = PathElement.groupElement("extendedDynamicState3RasterizationStream");
    public static final PathElement PATH$extendedDynamicState3ConservativeRasterizationMode = PathElement.groupElement("extendedDynamicState3ConservativeRasterizationMode");
    public static final PathElement PATH$extendedDynamicState3ExtraPrimitiveOverestimationSize = PathElement.groupElement("extendedDynamicState3ExtraPrimitiveOverestimationSize");
    public static final PathElement PATH$extendedDynamicState3DepthClipEnable = PathElement.groupElement("extendedDynamicState3DepthClipEnable");
    public static final PathElement PATH$extendedDynamicState3SampleLocationsEnable = PathElement.groupElement("extendedDynamicState3SampleLocationsEnable");
    public static final PathElement PATH$extendedDynamicState3ColorBlendAdvanced = PathElement.groupElement("extendedDynamicState3ColorBlendAdvanced");
    public static final PathElement PATH$extendedDynamicState3ProvokingVertexMode = PathElement.groupElement("extendedDynamicState3ProvokingVertexMode");
    public static final PathElement PATH$extendedDynamicState3LineRasterizationMode = PathElement.groupElement("extendedDynamicState3LineRasterizationMode");
    public static final PathElement PATH$extendedDynamicState3LineStippleEnable = PathElement.groupElement("extendedDynamicState3LineStippleEnable");
    public static final PathElement PATH$extendedDynamicState3DepthClipNegativeOneToOne = PathElement.groupElement("extendedDynamicState3DepthClipNegativeOneToOne");
    public static final PathElement PATH$extendedDynamicState3ViewportWScalingEnable = PathElement.groupElement("extendedDynamicState3ViewportWScalingEnable");
    public static final PathElement PATH$extendedDynamicState3ViewportSwizzle = PathElement.groupElement("extendedDynamicState3ViewportSwizzle");
    public static final PathElement PATH$extendedDynamicState3CoverageToColorEnable = PathElement.groupElement("extendedDynamicState3CoverageToColorEnable");
    public static final PathElement PATH$extendedDynamicState3CoverageToColorLocation = PathElement.groupElement("extendedDynamicState3CoverageToColorLocation");
    public static final PathElement PATH$extendedDynamicState3CoverageModulationMode = PathElement.groupElement("extendedDynamicState3CoverageModulationMode");
    public static final PathElement PATH$extendedDynamicState3CoverageModulationTableEnable = PathElement.groupElement("extendedDynamicState3CoverageModulationTableEnable");
    public static final PathElement PATH$extendedDynamicState3CoverageModulationTable = PathElement.groupElement("extendedDynamicState3CoverageModulationTable");
    public static final PathElement PATH$extendedDynamicState3CoverageReductionMode = PathElement.groupElement("extendedDynamicState3CoverageReductionMode");
    public static final PathElement PATH$extendedDynamicState3RepresentativeFragmentTestEnable = PathElement.groupElement("extendedDynamicState3RepresentativeFragmentTestEnable");
    public static final PathElement PATH$extendedDynamicState3ShadingRateImageEnable = PathElement.groupElement("extendedDynamicState3ShadingRateImageEnable");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$extendedDynamicState3TessellationDomainOrigin = (OfInt) LAYOUT.select(PATH$extendedDynamicState3TessellationDomainOrigin);
    public static final OfInt LAYOUT$extendedDynamicState3DepthClampEnable = (OfInt) LAYOUT.select(PATH$extendedDynamicState3DepthClampEnable);
    public static final OfInt LAYOUT$extendedDynamicState3PolygonMode = (OfInt) LAYOUT.select(PATH$extendedDynamicState3PolygonMode);
    public static final OfInt LAYOUT$extendedDynamicState3RasterizationSamples = (OfInt) LAYOUT.select(PATH$extendedDynamicState3RasterizationSamples);
    public static final OfInt LAYOUT$extendedDynamicState3SampleMask = (OfInt) LAYOUT.select(PATH$extendedDynamicState3SampleMask);
    public static final OfInt LAYOUT$extendedDynamicState3AlphaToCoverageEnable = (OfInt) LAYOUT.select(PATH$extendedDynamicState3AlphaToCoverageEnable);
    public static final OfInt LAYOUT$extendedDynamicState3AlphaToOneEnable = (OfInt) LAYOUT.select(PATH$extendedDynamicState3AlphaToOneEnable);
    public static final OfInt LAYOUT$extendedDynamicState3LogicOpEnable = (OfInt) LAYOUT.select(PATH$extendedDynamicState3LogicOpEnable);
    public static final OfInt LAYOUT$extendedDynamicState3ColorBlendEnable = (OfInt) LAYOUT.select(PATH$extendedDynamicState3ColorBlendEnable);
    public static final OfInt LAYOUT$extendedDynamicState3ColorBlendEquation = (OfInt) LAYOUT.select(PATH$extendedDynamicState3ColorBlendEquation);
    public static final OfInt LAYOUT$extendedDynamicState3ColorWriteMask = (OfInt) LAYOUT.select(PATH$extendedDynamicState3ColorWriteMask);
    public static final OfInt LAYOUT$extendedDynamicState3RasterizationStream = (OfInt) LAYOUT.select(PATH$extendedDynamicState3RasterizationStream);
    public static final OfInt LAYOUT$extendedDynamicState3ConservativeRasterizationMode = (OfInt) LAYOUT.select(PATH$extendedDynamicState3ConservativeRasterizationMode);
    public static final OfInt LAYOUT$extendedDynamicState3ExtraPrimitiveOverestimationSize = (OfInt) LAYOUT.select(PATH$extendedDynamicState3ExtraPrimitiveOverestimationSize);
    public static final OfInt LAYOUT$extendedDynamicState3DepthClipEnable = (OfInt) LAYOUT.select(PATH$extendedDynamicState3DepthClipEnable);
    public static final OfInt LAYOUT$extendedDynamicState3SampleLocationsEnable = (OfInt) LAYOUT.select(PATH$extendedDynamicState3SampleLocationsEnable);
    public static final OfInt LAYOUT$extendedDynamicState3ColorBlendAdvanced = (OfInt) LAYOUT.select(PATH$extendedDynamicState3ColorBlendAdvanced);
    public static final OfInt LAYOUT$extendedDynamicState3ProvokingVertexMode = (OfInt) LAYOUT.select(PATH$extendedDynamicState3ProvokingVertexMode);
    public static final OfInt LAYOUT$extendedDynamicState3LineRasterizationMode = (OfInt) LAYOUT.select(PATH$extendedDynamicState3LineRasterizationMode);
    public static final OfInt LAYOUT$extendedDynamicState3LineStippleEnable = (OfInt) LAYOUT.select(PATH$extendedDynamicState3LineStippleEnable);
    public static final OfInt LAYOUT$extendedDynamicState3DepthClipNegativeOneToOne = (OfInt) LAYOUT.select(PATH$extendedDynamicState3DepthClipNegativeOneToOne);
    public static final OfInt LAYOUT$extendedDynamicState3ViewportWScalingEnable = (OfInt) LAYOUT.select(PATH$extendedDynamicState3ViewportWScalingEnable);
    public static final OfInt LAYOUT$extendedDynamicState3ViewportSwizzle = (OfInt) LAYOUT.select(PATH$extendedDynamicState3ViewportSwizzle);
    public static final OfInt LAYOUT$extendedDynamicState3CoverageToColorEnable = (OfInt) LAYOUT.select(PATH$extendedDynamicState3CoverageToColorEnable);
    public static final OfInt LAYOUT$extendedDynamicState3CoverageToColorLocation = (OfInt) LAYOUT.select(PATH$extendedDynamicState3CoverageToColorLocation);
    public static final OfInt LAYOUT$extendedDynamicState3CoverageModulationMode = (OfInt) LAYOUT.select(PATH$extendedDynamicState3CoverageModulationMode);
    public static final OfInt LAYOUT$extendedDynamicState3CoverageModulationTableEnable = (OfInt) LAYOUT.select(PATH$extendedDynamicState3CoverageModulationTableEnable);
    public static final OfInt LAYOUT$extendedDynamicState3CoverageModulationTable = (OfInt) LAYOUT.select(PATH$extendedDynamicState3CoverageModulationTable);
    public static final OfInt LAYOUT$extendedDynamicState3CoverageReductionMode = (OfInt) LAYOUT.select(PATH$extendedDynamicState3CoverageReductionMode);
    public static final OfInt LAYOUT$extendedDynamicState3RepresentativeFragmentTestEnable = (OfInt) LAYOUT.select(PATH$extendedDynamicState3RepresentativeFragmentTestEnable);
    public static final OfInt LAYOUT$extendedDynamicState3ShadingRateImageEnable = (OfInt) LAYOUT.select(PATH$extendedDynamicState3ShadingRateImageEnable);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$extendedDynamicState3TessellationDomainOrigin = LAYOUT$extendedDynamicState3TessellationDomainOrigin.byteSize();
    public static final long SIZE$extendedDynamicState3DepthClampEnable = LAYOUT$extendedDynamicState3DepthClampEnable.byteSize();
    public static final long SIZE$extendedDynamicState3PolygonMode = LAYOUT$extendedDynamicState3PolygonMode.byteSize();
    public static final long SIZE$extendedDynamicState3RasterizationSamples = LAYOUT$extendedDynamicState3RasterizationSamples.byteSize();
    public static final long SIZE$extendedDynamicState3SampleMask = LAYOUT$extendedDynamicState3SampleMask.byteSize();
    public static final long SIZE$extendedDynamicState3AlphaToCoverageEnable = LAYOUT$extendedDynamicState3AlphaToCoverageEnable.byteSize();
    public static final long SIZE$extendedDynamicState3AlphaToOneEnable = LAYOUT$extendedDynamicState3AlphaToOneEnable.byteSize();
    public static final long SIZE$extendedDynamicState3LogicOpEnable = LAYOUT$extendedDynamicState3LogicOpEnable.byteSize();
    public static final long SIZE$extendedDynamicState3ColorBlendEnable = LAYOUT$extendedDynamicState3ColorBlendEnable.byteSize();
    public static final long SIZE$extendedDynamicState3ColorBlendEquation = LAYOUT$extendedDynamicState3ColorBlendEquation.byteSize();
    public static final long SIZE$extendedDynamicState3ColorWriteMask = LAYOUT$extendedDynamicState3ColorWriteMask.byteSize();
    public static final long SIZE$extendedDynamicState3RasterizationStream = LAYOUT$extendedDynamicState3RasterizationStream.byteSize();
    public static final long SIZE$extendedDynamicState3ConservativeRasterizationMode = LAYOUT$extendedDynamicState3ConservativeRasterizationMode.byteSize();
    public static final long SIZE$extendedDynamicState3ExtraPrimitiveOverestimationSize = LAYOUT$extendedDynamicState3ExtraPrimitiveOverestimationSize.byteSize();
    public static final long SIZE$extendedDynamicState3DepthClipEnable = LAYOUT$extendedDynamicState3DepthClipEnable.byteSize();
    public static final long SIZE$extendedDynamicState3SampleLocationsEnable = LAYOUT$extendedDynamicState3SampleLocationsEnable.byteSize();
    public static final long SIZE$extendedDynamicState3ColorBlendAdvanced = LAYOUT$extendedDynamicState3ColorBlendAdvanced.byteSize();
    public static final long SIZE$extendedDynamicState3ProvokingVertexMode = LAYOUT$extendedDynamicState3ProvokingVertexMode.byteSize();
    public static final long SIZE$extendedDynamicState3LineRasterizationMode = LAYOUT$extendedDynamicState3LineRasterizationMode.byteSize();
    public static final long SIZE$extendedDynamicState3LineStippleEnable = LAYOUT$extendedDynamicState3LineStippleEnable.byteSize();
    public static final long SIZE$extendedDynamicState3DepthClipNegativeOneToOne = LAYOUT$extendedDynamicState3DepthClipNegativeOneToOne.byteSize();
    public static final long SIZE$extendedDynamicState3ViewportWScalingEnable = LAYOUT$extendedDynamicState3ViewportWScalingEnable.byteSize();
    public static final long SIZE$extendedDynamicState3ViewportSwizzle = LAYOUT$extendedDynamicState3ViewportSwizzle.byteSize();
    public static final long SIZE$extendedDynamicState3CoverageToColorEnable = LAYOUT$extendedDynamicState3CoverageToColorEnable.byteSize();
    public static final long SIZE$extendedDynamicState3CoverageToColorLocation = LAYOUT$extendedDynamicState3CoverageToColorLocation.byteSize();
    public static final long SIZE$extendedDynamicState3CoverageModulationMode = LAYOUT$extendedDynamicState3CoverageModulationMode.byteSize();
    public static final long SIZE$extendedDynamicState3CoverageModulationTableEnable = LAYOUT$extendedDynamicState3CoverageModulationTableEnable.byteSize();
    public static final long SIZE$extendedDynamicState3CoverageModulationTable = LAYOUT$extendedDynamicState3CoverageModulationTable.byteSize();
    public static final long SIZE$extendedDynamicState3CoverageReductionMode = LAYOUT$extendedDynamicState3CoverageReductionMode.byteSize();
    public static final long SIZE$extendedDynamicState3RepresentativeFragmentTestEnable = LAYOUT$extendedDynamicState3RepresentativeFragmentTestEnable.byteSize();
    public static final long SIZE$extendedDynamicState3ShadingRateImageEnable = LAYOUT$extendedDynamicState3ShadingRateImageEnable.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$extendedDynamicState3TessellationDomainOrigin = LAYOUT.byteOffset(PATH$extendedDynamicState3TessellationDomainOrigin);
    public static final long OFFSET$extendedDynamicState3DepthClampEnable = LAYOUT.byteOffset(PATH$extendedDynamicState3DepthClampEnable);
    public static final long OFFSET$extendedDynamicState3PolygonMode = LAYOUT.byteOffset(PATH$extendedDynamicState3PolygonMode);
    public static final long OFFSET$extendedDynamicState3RasterizationSamples = LAYOUT.byteOffset(PATH$extendedDynamicState3RasterizationSamples);
    public static final long OFFSET$extendedDynamicState3SampleMask = LAYOUT.byteOffset(PATH$extendedDynamicState3SampleMask);
    public static final long OFFSET$extendedDynamicState3AlphaToCoverageEnable = LAYOUT.byteOffset(PATH$extendedDynamicState3AlphaToCoverageEnable);
    public static final long OFFSET$extendedDynamicState3AlphaToOneEnable = LAYOUT.byteOffset(PATH$extendedDynamicState3AlphaToOneEnable);
    public static final long OFFSET$extendedDynamicState3LogicOpEnable = LAYOUT.byteOffset(PATH$extendedDynamicState3LogicOpEnable);
    public static final long OFFSET$extendedDynamicState3ColorBlendEnable = LAYOUT.byteOffset(PATH$extendedDynamicState3ColorBlendEnable);
    public static final long OFFSET$extendedDynamicState3ColorBlendEquation = LAYOUT.byteOffset(PATH$extendedDynamicState3ColorBlendEquation);
    public static final long OFFSET$extendedDynamicState3ColorWriteMask = LAYOUT.byteOffset(PATH$extendedDynamicState3ColorWriteMask);
    public static final long OFFSET$extendedDynamicState3RasterizationStream = LAYOUT.byteOffset(PATH$extendedDynamicState3RasterizationStream);
    public static final long OFFSET$extendedDynamicState3ConservativeRasterizationMode = LAYOUT.byteOffset(PATH$extendedDynamicState3ConservativeRasterizationMode);
    public static final long OFFSET$extendedDynamicState3ExtraPrimitiveOverestimationSize = LAYOUT.byteOffset(PATH$extendedDynamicState3ExtraPrimitiveOverestimationSize);
    public static final long OFFSET$extendedDynamicState3DepthClipEnable = LAYOUT.byteOffset(PATH$extendedDynamicState3DepthClipEnable);
    public static final long OFFSET$extendedDynamicState3SampleLocationsEnable = LAYOUT.byteOffset(PATH$extendedDynamicState3SampleLocationsEnable);
    public static final long OFFSET$extendedDynamicState3ColorBlendAdvanced = LAYOUT.byteOffset(PATH$extendedDynamicState3ColorBlendAdvanced);
    public static final long OFFSET$extendedDynamicState3ProvokingVertexMode = LAYOUT.byteOffset(PATH$extendedDynamicState3ProvokingVertexMode);
    public static final long OFFSET$extendedDynamicState3LineRasterizationMode = LAYOUT.byteOffset(PATH$extendedDynamicState3LineRasterizationMode);
    public static final long OFFSET$extendedDynamicState3LineStippleEnable = LAYOUT.byteOffset(PATH$extendedDynamicState3LineStippleEnable);
    public static final long OFFSET$extendedDynamicState3DepthClipNegativeOneToOne = LAYOUT.byteOffset(PATH$extendedDynamicState3DepthClipNegativeOneToOne);
    public static final long OFFSET$extendedDynamicState3ViewportWScalingEnable = LAYOUT.byteOffset(PATH$extendedDynamicState3ViewportWScalingEnable);
    public static final long OFFSET$extendedDynamicState3ViewportSwizzle = LAYOUT.byteOffset(PATH$extendedDynamicState3ViewportSwizzle);
    public static final long OFFSET$extendedDynamicState3CoverageToColorEnable = LAYOUT.byteOffset(PATH$extendedDynamicState3CoverageToColorEnable);
    public static final long OFFSET$extendedDynamicState3CoverageToColorLocation = LAYOUT.byteOffset(PATH$extendedDynamicState3CoverageToColorLocation);
    public static final long OFFSET$extendedDynamicState3CoverageModulationMode = LAYOUT.byteOffset(PATH$extendedDynamicState3CoverageModulationMode);
    public static final long OFFSET$extendedDynamicState3CoverageModulationTableEnable = LAYOUT.byteOffset(PATH$extendedDynamicState3CoverageModulationTableEnable);
    public static final long OFFSET$extendedDynamicState3CoverageModulationTable = LAYOUT.byteOffset(PATH$extendedDynamicState3CoverageModulationTable);
    public static final long OFFSET$extendedDynamicState3CoverageReductionMode = LAYOUT.byteOffset(PATH$extendedDynamicState3CoverageReductionMode);
    public static final long OFFSET$extendedDynamicState3RepresentativeFragmentTestEnable = LAYOUT.byteOffset(PATH$extendedDynamicState3RepresentativeFragmentTestEnable);
    public static final long OFFSET$extendedDynamicState3ShadingRateImageEnable = LAYOUT.byteOffset(PATH$extendedDynamicState3ShadingRateImageEnable);
}
