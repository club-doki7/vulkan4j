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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceFeatures.html"><code>VkPhysicalDeviceFeatures</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceFeatures {
///     VkBool32 robustBufferAccess; // @link substring="robustBufferAccess" target="#robustBufferAccess"
///     VkBool32 fullDrawIndexUint32; // @link substring="fullDrawIndexUint32" target="#fullDrawIndexUint32"
///     VkBool32 imageCubeArray; // @link substring="imageCubeArray" target="#imageCubeArray"
///     VkBool32 independentBlend; // @link substring="independentBlend" target="#independentBlend"
///     VkBool32 geometryShader; // @link substring="geometryShader" target="#geometryShader"
///     VkBool32 tessellationShader; // @link substring="tessellationShader" target="#tessellationShader"
///     VkBool32 sampleRateShading; // @link substring="sampleRateShading" target="#sampleRateShading"
///     VkBool32 dualSrcBlend; // @link substring="dualSrcBlend" target="#dualSrcBlend"
///     VkBool32 logicOp; // @link substring="logicOp" target="#logicOp"
///     VkBool32 multiDrawIndirect; // @link substring="multiDrawIndirect" target="#multiDrawIndirect"
///     VkBool32 drawIndirectFirstInstance; // @link substring="drawIndirectFirstInstance" target="#drawIndirectFirstInstance"
///     VkBool32 depthClamp; // @link substring="depthClamp" target="#depthClamp"
///     VkBool32 depthBiasClamp; // @link substring="depthBiasClamp" target="#depthBiasClamp"
///     VkBool32 fillModeNonSolid; // @link substring="fillModeNonSolid" target="#fillModeNonSolid"
///     VkBool32 depthBounds; // @link substring="depthBounds" target="#depthBounds"
///     VkBool32 wideLines; // @link substring="wideLines" target="#wideLines"
///     VkBool32 largePoints; // @link substring="largePoints" target="#largePoints"
///     VkBool32 alphaToOne; // @link substring="alphaToOne" target="#alphaToOne"
///     VkBool32 multiViewport; // @link substring="multiViewport" target="#multiViewport"
///     VkBool32 samplerAnisotropy; // @link substring="samplerAnisotropy" target="#samplerAnisotropy"
///     VkBool32 textureCompressionETC2; // @link substring="textureCompressionETC2" target="#textureCompressionETC2"
///     VkBool32 textureCompressionASTC_LDR; // @link substring="textureCompressionASTC_LDR" target="#textureCompressionASTC_LDR"
///     VkBool32 textureCompressionBC; // @link substring="textureCompressionBC" target="#textureCompressionBC"
///     VkBool32 occlusionQueryPrecise; // @link substring="occlusionQueryPrecise" target="#occlusionQueryPrecise"
///     VkBool32 pipelineStatisticsQuery; // @link substring="pipelineStatisticsQuery" target="#pipelineStatisticsQuery"
///     VkBool32 vertexPipelineStoresAndAtomics; // @link substring="vertexPipelineStoresAndAtomics" target="#vertexPipelineStoresAndAtomics"
///     VkBool32 fragmentStoresAndAtomics; // @link substring="fragmentStoresAndAtomics" target="#fragmentStoresAndAtomics"
///     VkBool32 shaderTessellationAndGeometryPointSize; // @link substring="shaderTessellationAndGeometryPointSize" target="#shaderTessellationAndGeometryPointSize"
///     VkBool32 shaderImageGatherExtended; // @link substring="shaderImageGatherExtended" target="#shaderImageGatherExtended"
///     VkBool32 shaderStorageImageExtendedFormats; // @link substring="shaderStorageImageExtendedFormats" target="#shaderStorageImageExtendedFormats"
///     VkBool32 shaderStorageImageMultisample; // @link substring="shaderStorageImageMultisample" target="#shaderStorageImageMultisample"
///     VkBool32 shaderStorageImageReadWithoutFormat; // @link substring="shaderStorageImageReadWithoutFormat" target="#shaderStorageImageReadWithoutFormat"
///     VkBool32 shaderStorageImageWriteWithoutFormat; // @link substring="shaderStorageImageWriteWithoutFormat" target="#shaderStorageImageWriteWithoutFormat"
///     VkBool32 shaderUniformBufferArrayDynamicIndexing; // @link substring="shaderUniformBufferArrayDynamicIndexing" target="#shaderUniformBufferArrayDynamicIndexing"
///     VkBool32 shaderSampledImageArrayDynamicIndexing; // @link substring="shaderSampledImageArrayDynamicIndexing" target="#shaderSampledImageArrayDynamicIndexing"
///     VkBool32 shaderStorageBufferArrayDynamicIndexing; // @link substring="shaderStorageBufferArrayDynamicIndexing" target="#shaderStorageBufferArrayDynamicIndexing"
///     VkBool32 shaderStorageImageArrayDynamicIndexing; // @link substring="shaderStorageImageArrayDynamicIndexing" target="#shaderStorageImageArrayDynamicIndexing"
///     VkBool32 shaderClipDistance; // @link substring="shaderClipDistance" target="#shaderClipDistance"
///     VkBool32 shaderCullDistance; // @link substring="shaderCullDistance" target="#shaderCullDistance"
///     VkBool32 shaderFloat64; // @link substring="shaderFloat64" target="#shaderFloat64"
///     VkBool32 shaderInt64; // @link substring="shaderInt64" target="#shaderInt64"
///     VkBool32 shaderInt16; // @link substring="shaderInt16" target="#shaderInt16"
///     VkBool32 shaderResourceResidency; // @link substring="shaderResourceResidency" target="#shaderResourceResidency"
///     VkBool32 shaderResourceMinLod; // @link substring="shaderResourceMinLod" target="#shaderResourceMinLod"
///     VkBool32 sparseBinding; // @link substring="sparseBinding" target="#sparseBinding"
///     VkBool32 sparseResidencyBuffer; // @link substring="sparseResidencyBuffer" target="#sparseResidencyBuffer"
///     VkBool32 sparseResidencyImage2D; // @link substring="sparseResidencyImage2D" target="#sparseResidencyImage2D"
///     VkBool32 sparseResidencyImage3D; // @link substring="sparseResidencyImage3D" target="#sparseResidencyImage3D"
///     VkBool32 sparseResidency2Samples; // @link substring="sparseResidency2Samples" target="#sparseResidency2Samples"
///     VkBool32 sparseResidency4Samples; // @link substring="sparseResidency4Samples" target="#sparseResidency4Samples"
///     VkBool32 sparseResidency8Samples; // @link substring="sparseResidency8Samples" target="#sparseResidency8Samples"
///     VkBool32 sparseResidency16Samples; // @link substring="sparseResidency16Samples" target="#sparseResidency16Samples"
///     VkBool32 sparseResidencyAliased; // @link substring="sparseResidencyAliased" target="#sparseResidencyAliased"
///     VkBool32 variableMultisampleRate; // @link substring="variableMultisampleRate" target="#variableMultisampleRate"
///     VkBool32 inheritedQueries; // @link substring="inheritedQueries" target="#inheritedQueries"
/// } VkPhysicalDeviceFeatures;
/// }
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceFeatures.html"><code>VkPhysicalDeviceFeatures</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceFeatures(@NotNull MemorySegment segment) implements IVkPhysicalDeviceFeatures {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceFeatures.html"><code>VkPhysicalDeviceFeatures</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceFeatures}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceFeatures to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceFeatures.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceFeatures, Iterable<VkPhysicalDeviceFeatures> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceFeatures.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceFeatures at(long index) {
            return new VkPhysicalDeviceFeatures(segment.asSlice(index * VkPhysicalDeviceFeatures.BYTES, VkPhysicalDeviceFeatures.BYTES));
        }

        public VkPhysicalDeviceFeatures.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceFeatures> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceFeatures value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceFeatures.BYTES, VkPhysicalDeviceFeatures.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceFeatures.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceFeatures.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceFeatures.BYTES,
                (end - start) * VkPhysicalDeviceFeatures.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceFeatures.BYTES));
        }

        public VkPhysicalDeviceFeatures[] toArray() {
            VkPhysicalDeviceFeatures[] ret = new VkPhysicalDeviceFeatures[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceFeatures> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceFeatures> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceFeatures.BYTES;
            }

            @Override
            public VkPhysicalDeviceFeatures next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceFeatures ret = new VkPhysicalDeviceFeatures(segment.asSlice(0, VkPhysicalDeviceFeatures.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceFeatures.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceFeatures allocate(Arena arena) {
        return new VkPhysicalDeviceFeatures(arena.allocate(LAYOUT));
    }

    public static VkPhysicalDeviceFeatures.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkPhysicalDeviceFeatures.Ptr(segment);
    }

    public static VkPhysicalDeviceFeatures clone(Arena arena, VkPhysicalDeviceFeatures src) {
        VkPhysicalDeviceFeatures ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NativeType("VkBool32") @Unsigned int robustBufferAccess() {
        return segment.get(LAYOUT$robustBufferAccess, OFFSET$robustBufferAccess);
    }

    public VkPhysicalDeviceFeatures robustBufferAccess(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$robustBufferAccess, OFFSET$robustBufferAccess, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int fullDrawIndexUint32() {
        return segment.get(LAYOUT$fullDrawIndexUint32, OFFSET$fullDrawIndexUint32);
    }

    public VkPhysicalDeviceFeatures fullDrawIndexUint32(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$fullDrawIndexUint32, OFFSET$fullDrawIndexUint32, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int imageCubeArray() {
        return segment.get(LAYOUT$imageCubeArray, OFFSET$imageCubeArray);
    }

    public VkPhysicalDeviceFeatures imageCubeArray(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$imageCubeArray, OFFSET$imageCubeArray, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int independentBlend() {
        return segment.get(LAYOUT$independentBlend, OFFSET$independentBlend);
    }

    public VkPhysicalDeviceFeatures independentBlend(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$independentBlend, OFFSET$independentBlend, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int geometryShader() {
        return segment.get(LAYOUT$geometryShader, OFFSET$geometryShader);
    }

    public VkPhysicalDeviceFeatures geometryShader(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$geometryShader, OFFSET$geometryShader, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int tessellationShader() {
        return segment.get(LAYOUT$tessellationShader, OFFSET$tessellationShader);
    }

    public VkPhysicalDeviceFeatures tessellationShader(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$tessellationShader, OFFSET$tessellationShader, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int sampleRateShading() {
        return segment.get(LAYOUT$sampleRateShading, OFFSET$sampleRateShading);
    }

    public VkPhysicalDeviceFeatures sampleRateShading(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$sampleRateShading, OFFSET$sampleRateShading, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int dualSrcBlend() {
        return segment.get(LAYOUT$dualSrcBlend, OFFSET$dualSrcBlend);
    }

    public VkPhysicalDeviceFeatures dualSrcBlend(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$dualSrcBlend, OFFSET$dualSrcBlend, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int logicOp() {
        return segment.get(LAYOUT$logicOp, OFFSET$logicOp);
    }

    public VkPhysicalDeviceFeatures logicOp(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$logicOp, OFFSET$logicOp, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int multiDrawIndirect() {
        return segment.get(LAYOUT$multiDrawIndirect, OFFSET$multiDrawIndirect);
    }

    public VkPhysicalDeviceFeatures multiDrawIndirect(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$multiDrawIndirect, OFFSET$multiDrawIndirect, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int drawIndirectFirstInstance() {
        return segment.get(LAYOUT$drawIndirectFirstInstance, OFFSET$drawIndirectFirstInstance);
    }

    public VkPhysicalDeviceFeatures drawIndirectFirstInstance(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$drawIndirectFirstInstance, OFFSET$drawIndirectFirstInstance, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int depthClamp() {
        return segment.get(LAYOUT$depthClamp, OFFSET$depthClamp);
    }

    public VkPhysicalDeviceFeatures depthClamp(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$depthClamp, OFFSET$depthClamp, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int depthBiasClamp() {
        return segment.get(LAYOUT$depthBiasClamp, OFFSET$depthBiasClamp);
    }

    public VkPhysicalDeviceFeatures depthBiasClamp(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$depthBiasClamp, OFFSET$depthBiasClamp, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int fillModeNonSolid() {
        return segment.get(LAYOUT$fillModeNonSolid, OFFSET$fillModeNonSolid);
    }

    public VkPhysicalDeviceFeatures fillModeNonSolid(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$fillModeNonSolid, OFFSET$fillModeNonSolid, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int depthBounds() {
        return segment.get(LAYOUT$depthBounds, OFFSET$depthBounds);
    }

    public VkPhysicalDeviceFeatures depthBounds(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$depthBounds, OFFSET$depthBounds, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int wideLines() {
        return segment.get(LAYOUT$wideLines, OFFSET$wideLines);
    }

    public VkPhysicalDeviceFeatures wideLines(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$wideLines, OFFSET$wideLines, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int largePoints() {
        return segment.get(LAYOUT$largePoints, OFFSET$largePoints);
    }

    public VkPhysicalDeviceFeatures largePoints(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$largePoints, OFFSET$largePoints, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int alphaToOne() {
        return segment.get(LAYOUT$alphaToOne, OFFSET$alphaToOne);
    }

    public VkPhysicalDeviceFeatures alphaToOne(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$alphaToOne, OFFSET$alphaToOne, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int multiViewport() {
        return segment.get(LAYOUT$multiViewport, OFFSET$multiViewport);
    }

    public VkPhysicalDeviceFeatures multiViewport(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$multiViewport, OFFSET$multiViewport, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int samplerAnisotropy() {
        return segment.get(LAYOUT$samplerAnisotropy, OFFSET$samplerAnisotropy);
    }

    public VkPhysicalDeviceFeatures samplerAnisotropy(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$samplerAnisotropy, OFFSET$samplerAnisotropy, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int textureCompressionETC2() {
        return segment.get(LAYOUT$textureCompressionETC2, OFFSET$textureCompressionETC2);
    }

    public VkPhysicalDeviceFeatures textureCompressionETC2(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$textureCompressionETC2, OFFSET$textureCompressionETC2, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int textureCompressionASTC_LDR() {
        return segment.get(LAYOUT$textureCompressionASTC_LDR, OFFSET$textureCompressionASTC_LDR);
    }

    public VkPhysicalDeviceFeatures textureCompressionASTC_LDR(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$textureCompressionASTC_LDR, OFFSET$textureCompressionASTC_LDR, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int textureCompressionBC() {
        return segment.get(LAYOUT$textureCompressionBC, OFFSET$textureCompressionBC);
    }

    public VkPhysicalDeviceFeatures textureCompressionBC(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$textureCompressionBC, OFFSET$textureCompressionBC, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int occlusionQueryPrecise() {
        return segment.get(LAYOUT$occlusionQueryPrecise, OFFSET$occlusionQueryPrecise);
    }

    public VkPhysicalDeviceFeatures occlusionQueryPrecise(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$occlusionQueryPrecise, OFFSET$occlusionQueryPrecise, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int pipelineStatisticsQuery() {
        return segment.get(LAYOUT$pipelineStatisticsQuery, OFFSET$pipelineStatisticsQuery);
    }

    public VkPhysicalDeviceFeatures pipelineStatisticsQuery(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$pipelineStatisticsQuery, OFFSET$pipelineStatisticsQuery, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int vertexPipelineStoresAndAtomics() {
        return segment.get(LAYOUT$vertexPipelineStoresAndAtomics, OFFSET$vertexPipelineStoresAndAtomics);
    }

    public VkPhysicalDeviceFeatures vertexPipelineStoresAndAtomics(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$vertexPipelineStoresAndAtomics, OFFSET$vertexPipelineStoresAndAtomics, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int fragmentStoresAndAtomics() {
        return segment.get(LAYOUT$fragmentStoresAndAtomics, OFFSET$fragmentStoresAndAtomics);
    }

    public VkPhysicalDeviceFeatures fragmentStoresAndAtomics(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$fragmentStoresAndAtomics, OFFSET$fragmentStoresAndAtomics, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderTessellationAndGeometryPointSize() {
        return segment.get(LAYOUT$shaderTessellationAndGeometryPointSize, OFFSET$shaderTessellationAndGeometryPointSize);
    }

    public VkPhysicalDeviceFeatures shaderTessellationAndGeometryPointSize(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderTessellationAndGeometryPointSize, OFFSET$shaderTessellationAndGeometryPointSize, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderImageGatherExtended() {
        return segment.get(LAYOUT$shaderImageGatherExtended, OFFSET$shaderImageGatherExtended);
    }

    public VkPhysicalDeviceFeatures shaderImageGatherExtended(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderImageGatherExtended, OFFSET$shaderImageGatherExtended, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderStorageImageExtendedFormats() {
        return segment.get(LAYOUT$shaderStorageImageExtendedFormats, OFFSET$shaderStorageImageExtendedFormats);
    }

    public VkPhysicalDeviceFeatures shaderStorageImageExtendedFormats(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderStorageImageExtendedFormats, OFFSET$shaderStorageImageExtendedFormats, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderStorageImageMultisample() {
        return segment.get(LAYOUT$shaderStorageImageMultisample, OFFSET$shaderStorageImageMultisample);
    }

    public VkPhysicalDeviceFeatures shaderStorageImageMultisample(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderStorageImageMultisample, OFFSET$shaderStorageImageMultisample, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderStorageImageReadWithoutFormat() {
        return segment.get(LAYOUT$shaderStorageImageReadWithoutFormat, OFFSET$shaderStorageImageReadWithoutFormat);
    }

    public VkPhysicalDeviceFeatures shaderStorageImageReadWithoutFormat(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderStorageImageReadWithoutFormat, OFFSET$shaderStorageImageReadWithoutFormat, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderStorageImageWriteWithoutFormat() {
        return segment.get(LAYOUT$shaderStorageImageWriteWithoutFormat, OFFSET$shaderStorageImageWriteWithoutFormat);
    }

    public VkPhysicalDeviceFeatures shaderStorageImageWriteWithoutFormat(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderStorageImageWriteWithoutFormat, OFFSET$shaderStorageImageWriteWithoutFormat, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderUniformBufferArrayDynamicIndexing() {
        return segment.get(LAYOUT$shaderUniformBufferArrayDynamicIndexing, OFFSET$shaderUniformBufferArrayDynamicIndexing);
    }

    public VkPhysicalDeviceFeatures shaderUniformBufferArrayDynamicIndexing(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderUniformBufferArrayDynamicIndexing, OFFSET$shaderUniformBufferArrayDynamicIndexing, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderSampledImageArrayDynamicIndexing() {
        return segment.get(LAYOUT$shaderSampledImageArrayDynamicIndexing, OFFSET$shaderSampledImageArrayDynamicIndexing);
    }

    public VkPhysicalDeviceFeatures shaderSampledImageArrayDynamicIndexing(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderSampledImageArrayDynamicIndexing, OFFSET$shaderSampledImageArrayDynamicIndexing, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderStorageBufferArrayDynamicIndexing() {
        return segment.get(LAYOUT$shaderStorageBufferArrayDynamicIndexing, OFFSET$shaderStorageBufferArrayDynamicIndexing);
    }

    public VkPhysicalDeviceFeatures shaderStorageBufferArrayDynamicIndexing(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderStorageBufferArrayDynamicIndexing, OFFSET$shaderStorageBufferArrayDynamicIndexing, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderStorageImageArrayDynamicIndexing() {
        return segment.get(LAYOUT$shaderStorageImageArrayDynamicIndexing, OFFSET$shaderStorageImageArrayDynamicIndexing);
    }

    public VkPhysicalDeviceFeatures shaderStorageImageArrayDynamicIndexing(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderStorageImageArrayDynamicIndexing, OFFSET$shaderStorageImageArrayDynamicIndexing, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderClipDistance() {
        return segment.get(LAYOUT$shaderClipDistance, OFFSET$shaderClipDistance);
    }

    public VkPhysicalDeviceFeatures shaderClipDistance(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderClipDistance, OFFSET$shaderClipDistance, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderCullDistance() {
        return segment.get(LAYOUT$shaderCullDistance, OFFSET$shaderCullDistance);
    }

    public VkPhysicalDeviceFeatures shaderCullDistance(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderCullDistance, OFFSET$shaderCullDistance, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderFloat64() {
        return segment.get(LAYOUT$shaderFloat64, OFFSET$shaderFloat64);
    }

    public VkPhysicalDeviceFeatures shaderFloat64(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderFloat64, OFFSET$shaderFloat64, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderInt64() {
        return segment.get(LAYOUT$shaderInt64, OFFSET$shaderInt64);
    }

    public VkPhysicalDeviceFeatures shaderInt64(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderInt64, OFFSET$shaderInt64, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderInt16() {
        return segment.get(LAYOUT$shaderInt16, OFFSET$shaderInt16);
    }

    public VkPhysicalDeviceFeatures shaderInt16(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderInt16, OFFSET$shaderInt16, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderResourceResidency() {
        return segment.get(LAYOUT$shaderResourceResidency, OFFSET$shaderResourceResidency);
    }

    public VkPhysicalDeviceFeatures shaderResourceResidency(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderResourceResidency, OFFSET$shaderResourceResidency, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderResourceMinLod() {
        return segment.get(LAYOUT$shaderResourceMinLod, OFFSET$shaderResourceMinLod);
    }

    public VkPhysicalDeviceFeatures shaderResourceMinLod(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderResourceMinLod, OFFSET$shaderResourceMinLod, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int sparseBinding() {
        return segment.get(LAYOUT$sparseBinding, OFFSET$sparseBinding);
    }

    public VkPhysicalDeviceFeatures sparseBinding(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$sparseBinding, OFFSET$sparseBinding, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int sparseResidencyBuffer() {
        return segment.get(LAYOUT$sparseResidencyBuffer, OFFSET$sparseResidencyBuffer);
    }

    public VkPhysicalDeviceFeatures sparseResidencyBuffer(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$sparseResidencyBuffer, OFFSET$sparseResidencyBuffer, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int sparseResidencyImage2D() {
        return segment.get(LAYOUT$sparseResidencyImage2D, OFFSET$sparseResidencyImage2D);
    }

    public VkPhysicalDeviceFeatures sparseResidencyImage2D(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$sparseResidencyImage2D, OFFSET$sparseResidencyImage2D, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int sparseResidencyImage3D() {
        return segment.get(LAYOUT$sparseResidencyImage3D, OFFSET$sparseResidencyImage3D);
    }

    public VkPhysicalDeviceFeatures sparseResidencyImage3D(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$sparseResidencyImage3D, OFFSET$sparseResidencyImage3D, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int sparseResidency2Samples() {
        return segment.get(LAYOUT$sparseResidency2Samples, OFFSET$sparseResidency2Samples);
    }

    public VkPhysicalDeviceFeatures sparseResidency2Samples(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$sparseResidency2Samples, OFFSET$sparseResidency2Samples, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int sparseResidency4Samples() {
        return segment.get(LAYOUT$sparseResidency4Samples, OFFSET$sparseResidency4Samples);
    }

    public VkPhysicalDeviceFeatures sparseResidency4Samples(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$sparseResidency4Samples, OFFSET$sparseResidency4Samples, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int sparseResidency8Samples() {
        return segment.get(LAYOUT$sparseResidency8Samples, OFFSET$sparseResidency8Samples);
    }

    public VkPhysicalDeviceFeatures sparseResidency8Samples(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$sparseResidency8Samples, OFFSET$sparseResidency8Samples, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int sparseResidency16Samples() {
        return segment.get(LAYOUT$sparseResidency16Samples, OFFSET$sparseResidency16Samples);
    }

    public VkPhysicalDeviceFeatures sparseResidency16Samples(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$sparseResidency16Samples, OFFSET$sparseResidency16Samples, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int sparseResidencyAliased() {
        return segment.get(LAYOUT$sparseResidencyAliased, OFFSET$sparseResidencyAliased);
    }

    public VkPhysicalDeviceFeatures sparseResidencyAliased(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$sparseResidencyAliased, OFFSET$sparseResidencyAliased, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int variableMultisampleRate() {
        return segment.get(LAYOUT$variableMultisampleRate, OFFSET$variableMultisampleRate);
    }

    public VkPhysicalDeviceFeatures variableMultisampleRate(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$variableMultisampleRate, OFFSET$variableMultisampleRate, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int inheritedQueries() {
        return segment.get(LAYOUT$inheritedQueries, OFFSET$inheritedQueries);
    }

    public VkPhysicalDeviceFeatures inheritedQueries(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$inheritedQueries, OFFSET$inheritedQueries, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("robustBufferAccess"),
        ValueLayout.JAVA_INT.withName("fullDrawIndexUint32"),
        ValueLayout.JAVA_INT.withName("imageCubeArray"),
        ValueLayout.JAVA_INT.withName("independentBlend"),
        ValueLayout.JAVA_INT.withName("geometryShader"),
        ValueLayout.JAVA_INT.withName("tessellationShader"),
        ValueLayout.JAVA_INT.withName("sampleRateShading"),
        ValueLayout.JAVA_INT.withName("dualSrcBlend"),
        ValueLayout.JAVA_INT.withName("logicOp"),
        ValueLayout.JAVA_INT.withName("multiDrawIndirect"),
        ValueLayout.JAVA_INT.withName("drawIndirectFirstInstance"),
        ValueLayout.JAVA_INT.withName("depthClamp"),
        ValueLayout.JAVA_INT.withName("depthBiasClamp"),
        ValueLayout.JAVA_INT.withName("fillModeNonSolid"),
        ValueLayout.JAVA_INT.withName("depthBounds"),
        ValueLayout.JAVA_INT.withName("wideLines"),
        ValueLayout.JAVA_INT.withName("largePoints"),
        ValueLayout.JAVA_INT.withName("alphaToOne"),
        ValueLayout.JAVA_INT.withName("multiViewport"),
        ValueLayout.JAVA_INT.withName("samplerAnisotropy"),
        ValueLayout.JAVA_INT.withName("textureCompressionETC2"),
        ValueLayout.JAVA_INT.withName("textureCompressionASTC_LDR"),
        ValueLayout.JAVA_INT.withName("textureCompressionBC"),
        ValueLayout.JAVA_INT.withName("occlusionQueryPrecise"),
        ValueLayout.JAVA_INT.withName("pipelineStatisticsQuery"),
        ValueLayout.JAVA_INT.withName("vertexPipelineStoresAndAtomics"),
        ValueLayout.JAVA_INT.withName("fragmentStoresAndAtomics"),
        ValueLayout.JAVA_INT.withName("shaderTessellationAndGeometryPointSize"),
        ValueLayout.JAVA_INT.withName("shaderImageGatherExtended"),
        ValueLayout.JAVA_INT.withName("shaderStorageImageExtendedFormats"),
        ValueLayout.JAVA_INT.withName("shaderStorageImageMultisample"),
        ValueLayout.JAVA_INT.withName("shaderStorageImageReadWithoutFormat"),
        ValueLayout.JAVA_INT.withName("shaderStorageImageWriteWithoutFormat"),
        ValueLayout.JAVA_INT.withName("shaderUniformBufferArrayDynamicIndexing"),
        ValueLayout.JAVA_INT.withName("shaderSampledImageArrayDynamicIndexing"),
        ValueLayout.JAVA_INT.withName("shaderStorageBufferArrayDynamicIndexing"),
        ValueLayout.JAVA_INT.withName("shaderStorageImageArrayDynamicIndexing"),
        ValueLayout.JAVA_INT.withName("shaderClipDistance"),
        ValueLayout.JAVA_INT.withName("shaderCullDistance"),
        ValueLayout.JAVA_INT.withName("shaderFloat64"),
        ValueLayout.JAVA_INT.withName("shaderInt64"),
        ValueLayout.JAVA_INT.withName("shaderInt16"),
        ValueLayout.JAVA_INT.withName("shaderResourceResidency"),
        ValueLayout.JAVA_INT.withName("shaderResourceMinLod"),
        ValueLayout.JAVA_INT.withName("sparseBinding"),
        ValueLayout.JAVA_INT.withName("sparseResidencyBuffer"),
        ValueLayout.JAVA_INT.withName("sparseResidencyImage2D"),
        ValueLayout.JAVA_INT.withName("sparseResidencyImage3D"),
        ValueLayout.JAVA_INT.withName("sparseResidency2Samples"),
        ValueLayout.JAVA_INT.withName("sparseResidency4Samples"),
        ValueLayout.JAVA_INT.withName("sparseResidency8Samples"),
        ValueLayout.JAVA_INT.withName("sparseResidency16Samples"),
        ValueLayout.JAVA_INT.withName("sparseResidencyAliased"),
        ValueLayout.JAVA_INT.withName("variableMultisampleRate"),
        ValueLayout.JAVA_INT.withName("inheritedQueries")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$robustBufferAccess = PathElement.groupElement("robustBufferAccess");
    public static final PathElement PATH$fullDrawIndexUint32 = PathElement.groupElement("fullDrawIndexUint32");
    public static final PathElement PATH$imageCubeArray = PathElement.groupElement("imageCubeArray");
    public static final PathElement PATH$independentBlend = PathElement.groupElement("independentBlend");
    public static final PathElement PATH$geometryShader = PathElement.groupElement("geometryShader");
    public static final PathElement PATH$tessellationShader = PathElement.groupElement("tessellationShader");
    public static final PathElement PATH$sampleRateShading = PathElement.groupElement("sampleRateShading");
    public static final PathElement PATH$dualSrcBlend = PathElement.groupElement("dualSrcBlend");
    public static final PathElement PATH$logicOp = PathElement.groupElement("logicOp");
    public static final PathElement PATH$multiDrawIndirect = PathElement.groupElement("multiDrawIndirect");
    public static final PathElement PATH$drawIndirectFirstInstance = PathElement.groupElement("drawIndirectFirstInstance");
    public static final PathElement PATH$depthClamp = PathElement.groupElement("depthClamp");
    public static final PathElement PATH$depthBiasClamp = PathElement.groupElement("depthBiasClamp");
    public static final PathElement PATH$fillModeNonSolid = PathElement.groupElement("fillModeNonSolid");
    public static final PathElement PATH$depthBounds = PathElement.groupElement("depthBounds");
    public static final PathElement PATH$wideLines = PathElement.groupElement("wideLines");
    public static final PathElement PATH$largePoints = PathElement.groupElement("largePoints");
    public static final PathElement PATH$alphaToOne = PathElement.groupElement("alphaToOne");
    public static final PathElement PATH$multiViewport = PathElement.groupElement("multiViewport");
    public static final PathElement PATH$samplerAnisotropy = PathElement.groupElement("samplerAnisotropy");
    public static final PathElement PATH$textureCompressionETC2 = PathElement.groupElement("textureCompressionETC2");
    public static final PathElement PATH$textureCompressionASTC_LDR = PathElement.groupElement("textureCompressionASTC_LDR");
    public static final PathElement PATH$textureCompressionBC = PathElement.groupElement("textureCompressionBC");
    public static final PathElement PATH$occlusionQueryPrecise = PathElement.groupElement("occlusionQueryPrecise");
    public static final PathElement PATH$pipelineStatisticsQuery = PathElement.groupElement("pipelineStatisticsQuery");
    public static final PathElement PATH$vertexPipelineStoresAndAtomics = PathElement.groupElement("vertexPipelineStoresAndAtomics");
    public static final PathElement PATH$fragmentStoresAndAtomics = PathElement.groupElement("fragmentStoresAndAtomics");
    public static final PathElement PATH$shaderTessellationAndGeometryPointSize = PathElement.groupElement("shaderTessellationAndGeometryPointSize");
    public static final PathElement PATH$shaderImageGatherExtended = PathElement.groupElement("shaderImageGatherExtended");
    public static final PathElement PATH$shaderStorageImageExtendedFormats = PathElement.groupElement("shaderStorageImageExtendedFormats");
    public static final PathElement PATH$shaderStorageImageMultisample = PathElement.groupElement("shaderStorageImageMultisample");
    public static final PathElement PATH$shaderStorageImageReadWithoutFormat = PathElement.groupElement("shaderStorageImageReadWithoutFormat");
    public static final PathElement PATH$shaderStorageImageWriteWithoutFormat = PathElement.groupElement("shaderStorageImageWriteWithoutFormat");
    public static final PathElement PATH$shaderUniformBufferArrayDynamicIndexing = PathElement.groupElement("shaderUniformBufferArrayDynamicIndexing");
    public static final PathElement PATH$shaderSampledImageArrayDynamicIndexing = PathElement.groupElement("shaderSampledImageArrayDynamicIndexing");
    public static final PathElement PATH$shaderStorageBufferArrayDynamicIndexing = PathElement.groupElement("shaderStorageBufferArrayDynamicIndexing");
    public static final PathElement PATH$shaderStorageImageArrayDynamicIndexing = PathElement.groupElement("shaderStorageImageArrayDynamicIndexing");
    public static final PathElement PATH$shaderClipDistance = PathElement.groupElement("shaderClipDistance");
    public static final PathElement PATH$shaderCullDistance = PathElement.groupElement("shaderCullDistance");
    public static final PathElement PATH$shaderFloat64 = PathElement.groupElement("shaderFloat64");
    public static final PathElement PATH$shaderInt64 = PathElement.groupElement("shaderInt64");
    public static final PathElement PATH$shaderInt16 = PathElement.groupElement("shaderInt16");
    public static final PathElement PATH$shaderResourceResidency = PathElement.groupElement("shaderResourceResidency");
    public static final PathElement PATH$shaderResourceMinLod = PathElement.groupElement("shaderResourceMinLod");
    public static final PathElement PATH$sparseBinding = PathElement.groupElement("sparseBinding");
    public static final PathElement PATH$sparseResidencyBuffer = PathElement.groupElement("sparseResidencyBuffer");
    public static final PathElement PATH$sparseResidencyImage2D = PathElement.groupElement("sparseResidencyImage2D");
    public static final PathElement PATH$sparseResidencyImage3D = PathElement.groupElement("sparseResidencyImage3D");
    public static final PathElement PATH$sparseResidency2Samples = PathElement.groupElement("sparseResidency2Samples");
    public static final PathElement PATH$sparseResidency4Samples = PathElement.groupElement("sparseResidency4Samples");
    public static final PathElement PATH$sparseResidency8Samples = PathElement.groupElement("sparseResidency8Samples");
    public static final PathElement PATH$sparseResidency16Samples = PathElement.groupElement("sparseResidency16Samples");
    public static final PathElement PATH$sparseResidencyAliased = PathElement.groupElement("sparseResidencyAliased");
    public static final PathElement PATH$variableMultisampleRate = PathElement.groupElement("variableMultisampleRate");
    public static final PathElement PATH$inheritedQueries = PathElement.groupElement("inheritedQueries");

    public static final OfInt LAYOUT$robustBufferAccess = (OfInt) LAYOUT.select(PATH$robustBufferAccess);
    public static final OfInt LAYOUT$fullDrawIndexUint32 = (OfInt) LAYOUT.select(PATH$fullDrawIndexUint32);
    public static final OfInt LAYOUT$imageCubeArray = (OfInt) LAYOUT.select(PATH$imageCubeArray);
    public static final OfInt LAYOUT$independentBlend = (OfInt) LAYOUT.select(PATH$independentBlend);
    public static final OfInt LAYOUT$geometryShader = (OfInt) LAYOUT.select(PATH$geometryShader);
    public static final OfInt LAYOUT$tessellationShader = (OfInt) LAYOUT.select(PATH$tessellationShader);
    public static final OfInt LAYOUT$sampleRateShading = (OfInt) LAYOUT.select(PATH$sampleRateShading);
    public static final OfInt LAYOUT$dualSrcBlend = (OfInt) LAYOUT.select(PATH$dualSrcBlend);
    public static final OfInt LAYOUT$logicOp = (OfInt) LAYOUT.select(PATH$logicOp);
    public static final OfInt LAYOUT$multiDrawIndirect = (OfInt) LAYOUT.select(PATH$multiDrawIndirect);
    public static final OfInt LAYOUT$drawIndirectFirstInstance = (OfInt) LAYOUT.select(PATH$drawIndirectFirstInstance);
    public static final OfInt LAYOUT$depthClamp = (OfInt) LAYOUT.select(PATH$depthClamp);
    public static final OfInt LAYOUT$depthBiasClamp = (OfInt) LAYOUT.select(PATH$depthBiasClamp);
    public static final OfInt LAYOUT$fillModeNonSolid = (OfInt) LAYOUT.select(PATH$fillModeNonSolid);
    public static final OfInt LAYOUT$depthBounds = (OfInt) LAYOUT.select(PATH$depthBounds);
    public static final OfInt LAYOUT$wideLines = (OfInt) LAYOUT.select(PATH$wideLines);
    public static final OfInt LAYOUT$largePoints = (OfInt) LAYOUT.select(PATH$largePoints);
    public static final OfInt LAYOUT$alphaToOne = (OfInt) LAYOUT.select(PATH$alphaToOne);
    public static final OfInt LAYOUT$multiViewport = (OfInt) LAYOUT.select(PATH$multiViewport);
    public static final OfInt LAYOUT$samplerAnisotropy = (OfInt) LAYOUT.select(PATH$samplerAnisotropy);
    public static final OfInt LAYOUT$textureCompressionETC2 = (OfInt) LAYOUT.select(PATH$textureCompressionETC2);
    public static final OfInt LAYOUT$textureCompressionASTC_LDR = (OfInt) LAYOUT.select(PATH$textureCompressionASTC_LDR);
    public static final OfInt LAYOUT$textureCompressionBC = (OfInt) LAYOUT.select(PATH$textureCompressionBC);
    public static final OfInt LAYOUT$occlusionQueryPrecise = (OfInt) LAYOUT.select(PATH$occlusionQueryPrecise);
    public static final OfInt LAYOUT$pipelineStatisticsQuery = (OfInt) LAYOUT.select(PATH$pipelineStatisticsQuery);
    public static final OfInt LAYOUT$vertexPipelineStoresAndAtomics = (OfInt) LAYOUT.select(PATH$vertexPipelineStoresAndAtomics);
    public static final OfInt LAYOUT$fragmentStoresAndAtomics = (OfInt) LAYOUT.select(PATH$fragmentStoresAndAtomics);
    public static final OfInt LAYOUT$shaderTessellationAndGeometryPointSize = (OfInt) LAYOUT.select(PATH$shaderTessellationAndGeometryPointSize);
    public static final OfInt LAYOUT$shaderImageGatherExtended = (OfInt) LAYOUT.select(PATH$shaderImageGatherExtended);
    public static final OfInt LAYOUT$shaderStorageImageExtendedFormats = (OfInt) LAYOUT.select(PATH$shaderStorageImageExtendedFormats);
    public static final OfInt LAYOUT$shaderStorageImageMultisample = (OfInt) LAYOUT.select(PATH$shaderStorageImageMultisample);
    public static final OfInt LAYOUT$shaderStorageImageReadWithoutFormat = (OfInt) LAYOUT.select(PATH$shaderStorageImageReadWithoutFormat);
    public static final OfInt LAYOUT$shaderStorageImageWriteWithoutFormat = (OfInt) LAYOUT.select(PATH$shaderStorageImageWriteWithoutFormat);
    public static final OfInt LAYOUT$shaderUniformBufferArrayDynamicIndexing = (OfInt) LAYOUT.select(PATH$shaderUniformBufferArrayDynamicIndexing);
    public static final OfInt LAYOUT$shaderSampledImageArrayDynamicIndexing = (OfInt) LAYOUT.select(PATH$shaderSampledImageArrayDynamicIndexing);
    public static final OfInt LAYOUT$shaderStorageBufferArrayDynamicIndexing = (OfInt) LAYOUT.select(PATH$shaderStorageBufferArrayDynamicIndexing);
    public static final OfInt LAYOUT$shaderStorageImageArrayDynamicIndexing = (OfInt) LAYOUT.select(PATH$shaderStorageImageArrayDynamicIndexing);
    public static final OfInt LAYOUT$shaderClipDistance = (OfInt) LAYOUT.select(PATH$shaderClipDistance);
    public static final OfInt LAYOUT$shaderCullDistance = (OfInt) LAYOUT.select(PATH$shaderCullDistance);
    public static final OfInt LAYOUT$shaderFloat64 = (OfInt) LAYOUT.select(PATH$shaderFloat64);
    public static final OfInt LAYOUT$shaderInt64 = (OfInt) LAYOUT.select(PATH$shaderInt64);
    public static final OfInt LAYOUT$shaderInt16 = (OfInt) LAYOUT.select(PATH$shaderInt16);
    public static final OfInt LAYOUT$shaderResourceResidency = (OfInt) LAYOUT.select(PATH$shaderResourceResidency);
    public static final OfInt LAYOUT$shaderResourceMinLod = (OfInt) LAYOUT.select(PATH$shaderResourceMinLod);
    public static final OfInt LAYOUT$sparseBinding = (OfInt) LAYOUT.select(PATH$sparseBinding);
    public static final OfInt LAYOUT$sparseResidencyBuffer = (OfInt) LAYOUT.select(PATH$sparseResidencyBuffer);
    public static final OfInt LAYOUT$sparseResidencyImage2D = (OfInt) LAYOUT.select(PATH$sparseResidencyImage2D);
    public static final OfInt LAYOUT$sparseResidencyImage3D = (OfInt) LAYOUT.select(PATH$sparseResidencyImage3D);
    public static final OfInt LAYOUT$sparseResidency2Samples = (OfInt) LAYOUT.select(PATH$sparseResidency2Samples);
    public static final OfInt LAYOUT$sparseResidency4Samples = (OfInt) LAYOUT.select(PATH$sparseResidency4Samples);
    public static final OfInt LAYOUT$sparseResidency8Samples = (OfInt) LAYOUT.select(PATH$sparseResidency8Samples);
    public static final OfInt LAYOUT$sparseResidency16Samples = (OfInt) LAYOUT.select(PATH$sparseResidency16Samples);
    public static final OfInt LAYOUT$sparseResidencyAliased = (OfInt) LAYOUT.select(PATH$sparseResidencyAliased);
    public static final OfInt LAYOUT$variableMultisampleRate = (OfInt) LAYOUT.select(PATH$variableMultisampleRate);
    public static final OfInt LAYOUT$inheritedQueries = (OfInt) LAYOUT.select(PATH$inheritedQueries);

    public static final long SIZE$robustBufferAccess = LAYOUT$robustBufferAccess.byteSize();
    public static final long SIZE$fullDrawIndexUint32 = LAYOUT$fullDrawIndexUint32.byteSize();
    public static final long SIZE$imageCubeArray = LAYOUT$imageCubeArray.byteSize();
    public static final long SIZE$independentBlend = LAYOUT$independentBlend.byteSize();
    public static final long SIZE$geometryShader = LAYOUT$geometryShader.byteSize();
    public static final long SIZE$tessellationShader = LAYOUT$tessellationShader.byteSize();
    public static final long SIZE$sampleRateShading = LAYOUT$sampleRateShading.byteSize();
    public static final long SIZE$dualSrcBlend = LAYOUT$dualSrcBlend.byteSize();
    public static final long SIZE$logicOp = LAYOUT$logicOp.byteSize();
    public static final long SIZE$multiDrawIndirect = LAYOUT$multiDrawIndirect.byteSize();
    public static final long SIZE$drawIndirectFirstInstance = LAYOUT$drawIndirectFirstInstance.byteSize();
    public static final long SIZE$depthClamp = LAYOUT$depthClamp.byteSize();
    public static final long SIZE$depthBiasClamp = LAYOUT$depthBiasClamp.byteSize();
    public static final long SIZE$fillModeNonSolid = LAYOUT$fillModeNonSolid.byteSize();
    public static final long SIZE$depthBounds = LAYOUT$depthBounds.byteSize();
    public static final long SIZE$wideLines = LAYOUT$wideLines.byteSize();
    public static final long SIZE$largePoints = LAYOUT$largePoints.byteSize();
    public static final long SIZE$alphaToOne = LAYOUT$alphaToOne.byteSize();
    public static final long SIZE$multiViewport = LAYOUT$multiViewport.byteSize();
    public static final long SIZE$samplerAnisotropy = LAYOUT$samplerAnisotropy.byteSize();
    public static final long SIZE$textureCompressionETC2 = LAYOUT$textureCompressionETC2.byteSize();
    public static final long SIZE$textureCompressionASTC_LDR = LAYOUT$textureCompressionASTC_LDR.byteSize();
    public static final long SIZE$textureCompressionBC = LAYOUT$textureCompressionBC.byteSize();
    public static final long SIZE$occlusionQueryPrecise = LAYOUT$occlusionQueryPrecise.byteSize();
    public static final long SIZE$pipelineStatisticsQuery = LAYOUT$pipelineStatisticsQuery.byteSize();
    public static final long SIZE$vertexPipelineStoresAndAtomics = LAYOUT$vertexPipelineStoresAndAtomics.byteSize();
    public static final long SIZE$fragmentStoresAndAtomics = LAYOUT$fragmentStoresAndAtomics.byteSize();
    public static final long SIZE$shaderTessellationAndGeometryPointSize = LAYOUT$shaderTessellationAndGeometryPointSize.byteSize();
    public static final long SIZE$shaderImageGatherExtended = LAYOUT$shaderImageGatherExtended.byteSize();
    public static final long SIZE$shaderStorageImageExtendedFormats = LAYOUT$shaderStorageImageExtendedFormats.byteSize();
    public static final long SIZE$shaderStorageImageMultisample = LAYOUT$shaderStorageImageMultisample.byteSize();
    public static final long SIZE$shaderStorageImageReadWithoutFormat = LAYOUT$shaderStorageImageReadWithoutFormat.byteSize();
    public static final long SIZE$shaderStorageImageWriteWithoutFormat = LAYOUT$shaderStorageImageWriteWithoutFormat.byteSize();
    public static final long SIZE$shaderUniformBufferArrayDynamicIndexing = LAYOUT$shaderUniformBufferArrayDynamicIndexing.byteSize();
    public static final long SIZE$shaderSampledImageArrayDynamicIndexing = LAYOUT$shaderSampledImageArrayDynamicIndexing.byteSize();
    public static final long SIZE$shaderStorageBufferArrayDynamicIndexing = LAYOUT$shaderStorageBufferArrayDynamicIndexing.byteSize();
    public static final long SIZE$shaderStorageImageArrayDynamicIndexing = LAYOUT$shaderStorageImageArrayDynamicIndexing.byteSize();
    public static final long SIZE$shaderClipDistance = LAYOUT$shaderClipDistance.byteSize();
    public static final long SIZE$shaderCullDistance = LAYOUT$shaderCullDistance.byteSize();
    public static final long SIZE$shaderFloat64 = LAYOUT$shaderFloat64.byteSize();
    public static final long SIZE$shaderInt64 = LAYOUT$shaderInt64.byteSize();
    public static final long SIZE$shaderInt16 = LAYOUT$shaderInt16.byteSize();
    public static final long SIZE$shaderResourceResidency = LAYOUT$shaderResourceResidency.byteSize();
    public static final long SIZE$shaderResourceMinLod = LAYOUT$shaderResourceMinLod.byteSize();
    public static final long SIZE$sparseBinding = LAYOUT$sparseBinding.byteSize();
    public static final long SIZE$sparseResidencyBuffer = LAYOUT$sparseResidencyBuffer.byteSize();
    public static final long SIZE$sparseResidencyImage2D = LAYOUT$sparseResidencyImage2D.byteSize();
    public static final long SIZE$sparseResidencyImage3D = LAYOUT$sparseResidencyImage3D.byteSize();
    public static final long SIZE$sparseResidency2Samples = LAYOUT$sparseResidency2Samples.byteSize();
    public static final long SIZE$sparseResidency4Samples = LAYOUT$sparseResidency4Samples.byteSize();
    public static final long SIZE$sparseResidency8Samples = LAYOUT$sparseResidency8Samples.byteSize();
    public static final long SIZE$sparseResidency16Samples = LAYOUT$sparseResidency16Samples.byteSize();
    public static final long SIZE$sparseResidencyAliased = LAYOUT$sparseResidencyAliased.byteSize();
    public static final long SIZE$variableMultisampleRate = LAYOUT$variableMultisampleRate.byteSize();
    public static final long SIZE$inheritedQueries = LAYOUT$inheritedQueries.byteSize();

    public static final long OFFSET$robustBufferAccess = LAYOUT.byteOffset(PATH$robustBufferAccess);
    public static final long OFFSET$fullDrawIndexUint32 = LAYOUT.byteOffset(PATH$fullDrawIndexUint32);
    public static final long OFFSET$imageCubeArray = LAYOUT.byteOffset(PATH$imageCubeArray);
    public static final long OFFSET$independentBlend = LAYOUT.byteOffset(PATH$independentBlend);
    public static final long OFFSET$geometryShader = LAYOUT.byteOffset(PATH$geometryShader);
    public static final long OFFSET$tessellationShader = LAYOUT.byteOffset(PATH$tessellationShader);
    public static final long OFFSET$sampleRateShading = LAYOUT.byteOffset(PATH$sampleRateShading);
    public static final long OFFSET$dualSrcBlend = LAYOUT.byteOffset(PATH$dualSrcBlend);
    public static final long OFFSET$logicOp = LAYOUT.byteOffset(PATH$logicOp);
    public static final long OFFSET$multiDrawIndirect = LAYOUT.byteOffset(PATH$multiDrawIndirect);
    public static final long OFFSET$drawIndirectFirstInstance = LAYOUT.byteOffset(PATH$drawIndirectFirstInstance);
    public static final long OFFSET$depthClamp = LAYOUT.byteOffset(PATH$depthClamp);
    public static final long OFFSET$depthBiasClamp = LAYOUT.byteOffset(PATH$depthBiasClamp);
    public static final long OFFSET$fillModeNonSolid = LAYOUT.byteOffset(PATH$fillModeNonSolid);
    public static final long OFFSET$depthBounds = LAYOUT.byteOffset(PATH$depthBounds);
    public static final long OFFSET$wideLines = LAYOUT.byteOffset(PATH$wideLines);
    public static final long OFFSET$largePoints = LAYOUT.byteOffset(PATH$largePoints);
    public static final long OFFSET$alphaToOne = LAYOUT.byteOffset(PATH$alphaToOne);
    public static final long OFFSET$multiViewport = LAYOUT.byteOffset(PATH$multiViewport);
    public static final long OFFSET$samplerAnisotropy = LAYOUT.byteOffset(PATH$samplerAnisotropy);
    public static final long OFFSET$textureCompressionETC2 = LAYOUT.byteOffset(PATH$textureCompressionETC2);
    public static final long OFFSET$textureCompressionASTC_LDR = LAYOUT.byteOffset(PATH$textureCompressionASTC_LDR);
    public static final long OFFSET$textureCompressionBC = LAYOUT.byteOffset(PATH$textureCompressionBC);
    public static final long OFFSET$occlusionQueryPrecise = LAYOUT.byteOffset(PATH$occlusionQueryPrecise);
    public static final long OFFSET$pipelineStatisticsQuery = LAYOUT.byteOffset(PATH$pipelineStatisticsQuery);
    public static final long OFFSET$vertexPipelineStoresAndAtomics = LAYOUT.byteOffset(PATH$vertexPipelineStoresAndAtomics);
    public static final long OFFSET$fragmentStoresAndAtomics = LAYOUT.byteOffset(PATH$fragmentStoresAndAtomics);
    public static final long OFFSET$shaderTessellationAndGeometryPointSize = LAYOUT.byteOffset(PATH$shaderTessellationAndGeometryPointSize);
    public static final long OFFSET$shaderImageGatherExtended = LAYOUT.byteOffset(PATH$shaderImageGatherExtended);
    public static final long OFFSET$shaderStorageImageExtendedFormats = LAYOUT.byteOffset(PATH$shaderStorageImageExtendedFormats);
    public static final long OFFSET$shaderStorageImageMultisample = LAYOUT.byteOffset(PATH$shaderStorageImageMultisample);
    public static final long OFFSET$shaderStorageImageReadWithoutFormat = LAYOUT.byteOffset(PATH$shaderStorageImageReadWithoutFormat);
    public static final long OFFSET$shaderStorageImageWriteWithoutFormat = LAYOUT.byteOffset(PATH$shaderStorageImageWriteWithoutFormat);
    public static final long OFFSET$shaderUniformBufferArrayDynamicIndexing = LAYOUT.byteOffset(PATH$shaderUniformBufferArrayDynamicIndexing);
    public static final long OFFSET$shaderSampledImageArrayDynamicIndexing = LAYOUT.byteOffset(PATH$shaderSampledImageArrayDynamicIndexing);
    public static final long OFFSET$shaderStorageBufferArrayDynamicIndexing = LAYOUT.byteOffset(PATH$shaderStorageBufferArrayDynamicIndexing);
    public static final long OFFSET$shaderStorageImageArrayDynamicIndexing = LAYOUT.byteOffset(PATH$shaderStorageImageArrayDynamicIndexing);
    public static final long OFFSET$shaderClipDistance = LAYOUT.byteOffset(PATH$shaderClipDistance);
    public static final long OFFSET$shaderCullDistance = LAYOUT.byteOffset(PATH$shaderCullDistance);
    public static final long OFFSET$shaderFloat64 = LAYOUT.byteOffset(PATH$shaderFloat64);
    public static final long OFFSET$shaderInt64 = LAYOUT.byteOffset(PATH$shaderInt64);
    public static final long OFFSET$shaderInt16 = LAYOUT.byteOffset(PATH$shaderInt16);
    public static final long OFFSET$shaderResourceResidency = LAYOUT.byteOffset(PATH$shaderResourceResidency);
    public static final long OFFSET$shaderResourceMinLod = LAYOUT.byteOffset(PATH$shaderResourceMinLod);
    public static final long OFFSET$sparseBinding = LAYOUT.byteOffset(PATH$sparseBinding);
    public static final long OFFSET$sparseResidencyBuffer = LAYOUT.byteOffset(PATH$sparseResidencyBuffer);
    public static final long OFFSET$sparseResidencyImage2D = LAYOUT.byteOffset(PATH$sparseResidencyImage2D);
    public static final long OFFSET$sparseResidencyImage3D = LAYOUT.byteOffset(PATH$sparseResidencyImage3D);
    public static final long OFFSET$sparseResidency2Samples = LAYOUT.byteOffset(PATH$sparseResidency2Samples);
    public static final long OFFSET$sparseResidency4Samples = LAYOUT.byteOffset(PATH$sparseResidency4Samples);
    public static final long OFFSET$sparseResidency8Samples = LAYOUT.byteOffset(PATH$sparseResidency8Samples);
    public static final long OFFSET$sparseResidency16Samples = LAYOUT.byteOffset(PATH$sparseResidency16Samples);
    public static final long OFFSET$sparseResidencyAliased = LAYOUT.byteOffset(PATH$sparseResidencyAliased);
    public static final long OFFSET$variableMultisampleRate = LAYOUT.byteOffset(PATH$variableMultisampleRate);
    public static final long OFFSET$inheritedQueries = LAYOUT.byteOffset(PATH$inheritedQueries);
}
