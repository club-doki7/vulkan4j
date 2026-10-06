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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceVulkan14Properties.html"><code>VkPhysicalDeviceVulkan14Properties</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceVulkan14Properties {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t lineSubPixelPrecisionBits; // @link substring="lineSubPixelPrecisionBits" target="#lineSubPixelPrecisionBits"
///     uint32_t maxVertexAttribDivisor; // @link substring="maxVertexAttribDivisor" target="#maxVertexAttribDivisor"
///     VkBool32 supportsNonZeroFirstInstance; // @link substring="supportsNonZeroFirstInstance" target="#supportsNonZeroFirstInstance"
///     uint32_t maxPushDescriptors; // @link substring="maxPushDescriptors" target="#maxPushDescriptors"
///     VkBool32 dynamicRenderingLocalReadDepthStencilAttachments; // @link substring="dynamicRenderingLocalReadDepthStencilAttachments" target="#dynamicRenderingLocalReadDepthStencilAttachments"
///     VkBool32 dynamicRenderingLocalReadMultisampledAttachments; // @link substring="dynamicRenderingLocalReadMultisampledAttachments" target="#dynamicRenderingLocalReadMultisampledAttachments"
///     VkBool32 earlyFragmentMultisampleCoverageAfterSampleCounting; // @link substring="earlyFragmentMultisampleCoverageAfterSampleCounting" target="#earlyFragmentMultisampleCoverageAfterSampleCounting"
///     VkBool32 earlyFragmentSampleMaskTestBeforeSampleCounting; // @link substring="earlyFragmentSampleMaskTestBeforeSampleCounting" target="#earlyFragmentSampleMaskTestBeforeSampleCounting"
///     VkBool32 depthStencilSwizzleOneSupport; // @link substring="depthStencilSwizzleOneSupport" target="#depthStencilSwizzleOneSupport"
///     VkBool32 polygonModePointSize; // @link substring="polygonModePointSize" target="#polygonModePointSize"
///     VkBool32 nonStrictSinglePixelWideLinesUseParallelogram; // @link substring="nonStrictSinglePixelWideLinesUseParallelogram" target="#nonStrictSinglePixelWideLinesUseParallelogram"
///     VkBool32 nonStrictWideLinesUseParallelogram; // @link substring="nonStrictWideLinesUseParallelogram" target="#nonStrictWideLinesUseParallelogram"
///     VkBool32 blockTexelViewCompatibleMultipleLayers; // @link substring="blockTexelViewCompatibleMultipleLayers" target="#blockTexelViewCompatibleMultipleLayers"
///     uint32_t maxCombinedImageSamplerDescriptorCount; // @link substring="maxCombinedImageSamplerDescriptorCount" target="#maxCombinedImageSamplerDescriptorCount"
///     VkBool32 fragmentShadingRateClampCombinerInputs; // @link substring="fragmentShadingRateClampCombinerInputs" target="#fragmentShadingRateClampCombinerInputs"
///     VkPipelineRobustnessBufferBehavior defaultRobustnessStorageBuffers; // @link substring="VkPipelineRobustnessBufferBehavior" target="VkPipelineRobustnessBufferBehavior" @link substring="defaultRobustnessStorageBuffers" target="#defaultRobustnessStorageBuffers"
///     VkPipelineRobustnessBufferBehavior defaultRobustnessUniformBuffers; // @link substring="VkPipelineRobustnessBufferBehavior" target="VkPipelineRobustnessBufferBehavior" @link substring="defaultRobustnessUniformBuffers" target="#defaultRobustnessUniformBuffers"
///     VkPipelineRobustnessBufferBehavior defaultRobustnessVertexInputs; // @link substring="VkPipelineRobustnessBufferBehavior" target="VkPipelineRobustnessBufferBehavior" @link substring="defaultRobustnessVertexInputs" target="#defaultRobustnessVertexInputs"
///     VkPipelineRobustnessImageBehavior defaultRobustnessImages; // @link substring="VkPipelineRobustnessImageBehavior" target="VkPipelineRobustnessImageBehavior" @link substring="defaultRobustnessImages" target="#defaultRobustnessImages"
///     uint32_t copySrcLayoutCount; // optional // @link substring="copySrcLayoutCount" target="#copySrcLayoutCount"
///     VkImageLayout* pCopySrcLayouts; // optional // @link substring="VkImageLayout" target="VkImageLayout" @link substring="pCopySrcLayouts" target="#pCopySrcLayouts"
///     uint32_t copyDstLayoutCount; // optional // @link substring="copyDstLayoutCount" target="#copyDstLayoutCount"
///     VkImageLayout* pCopyDstLayouts; // optional // @link substring="VkImageLayout" target="VkImageLayout" @link substring="pCopyDstLayouts" target="#pCopyDstLayouts"
///     uint8_t[VK_UUID_SIZE] optimalTilingLayoutUUID; // optional // @link substring="optimalTilingLayoutUUID" target="#optimalTilingLayoutUUID"
///     VkBool32 identicalMemoryTypeRequirements; // @link substring="identicalMemoryTypeRequirements" target="#identicalMemoryTypeRequirements"
/// } VkPhysicalDeviceVulkan14Properties;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_VULKAN_1_4_PROPERTIES`
///
/// The {@code allocate} ({@link VkPhysicalDeviceVulkan14Properties#allocate(Arena)}, {@link VkPhysicalDeviceVulkan14Properties#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceVulkan14Properties#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceVulkan14Properties.html"><code>VkPhysicalDeviceVulkan14Properties</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceVulkan14Properties(@NotNull MemorySegment segment) implements IVkPhysicalDeviceVulkan14Properties {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceVulkan14Properties.html"><code>VkPhysicalDeviceVulkan14Properties</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceVulkan14Properties}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceVulkan14Properties to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceVulkan14Properties.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceVulkan14Properties, Iterable<VkPhysicalDeviceVulkan14Properties> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceVulkan14Properties.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceVulkan14Properties at(long index) {
            return new VkPhysicalDeviceVulkan14Properties(segment.asSlice(index * VkPhysicalDeviceVulkan14Properties.BYTES, VkPhysicalDeviceVulkan14Properties.BYTES));
        }

        public VkPhysicalDeviceVulkan14Properties.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceVulkan14Properties> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceVulkan14Properties value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceVulkan14Properties.BYTES, VkPhysicalDeviceVulkan14Properties.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceVulkan14Properties.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceVulkan14Properties.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceVulkan14Properties.BYTES,
                (end - start) * VkPhysicalDeviceVulkan14Properties.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceVulkan14Properties.BYTES));
        }

        public VkPhysicalDeviceVulkan14Properties[] toArray() {
            VkPhysicalDeviceVulkan14Properties[] ret = new VkPhysicalDeviceVulkan14Properties[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceVulkan14Properties> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceVulkan14Properties> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceVulkan14Properties.BYTES;
            }

            @Override
            public VkPhysicalDeviceVulkan14Properties next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceVulkan14Properties ret = new VkPhysicalDeviceVulkan14Properties(segment.asSlice(0, VkPhysicalDeviceVulkan14Properties.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceVulkan14Properties.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceVulkan14Properties allocate(Arena arena) {
        VkPhysicalDeviceVulkan14Properties ret = new VkPhysicalDeviceVulkan14Properties(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_VULKAN_1_4_PROPERTIES);
        return ret;
    }

    public static VkPhysicalDeviceVulkan14Properties.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceVulkan14Properties.Ptr ret = new VkPhysicalDeviceVulkan14Properties.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_VULKAN_1_4_PROPERTIES);
        }
        return ret;
    }

    public static VkPhysicalDeviceVulkan14Properties clone(Arena arena, VkPhysicalDeviceVulkan14Properties src) {
        VkPhysicalDeviceVulkan14Properties ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_VULKAN_1_4_PROPERTIES);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceVulkan14Properties sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceVulkan14Properties pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceVulkan14Properties pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int lineSubPixelPrecisionBits() {
        return segment.get(LAYOUT$lineSubPixelPrecisionBits, OFFSET$lineSubPixelPrecisionBits);
    }

    public VkPhysicalDeviceVulkan14Properties lineSubPixelPrecisionBits(@Unsigned int value) {
        segment.set(LAYOUT$lineSubPixelPrecisionBits, OFFSET$lineSubPixelPrecisionBits, value);
        return this;
    }

    public @Unsigned int maxVertexAttribDivisor() {
        return segment.get(LAYOUT$maxVertexAttribDivisor, OFFSET$maxVertexAttribDivisor);
    }

    public VkPhysicalDeviceVulkan14Properties maxVertexAttribDivisor(@Unsigned int value) {
        segment.set(LAYOUT$maxVertexAttribDivisor, OFFSET$maxVertexAttribDivisor, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int supportsNonZeroFirstInstance() {
        return segment.get(LAYOUT$supportsNonZeroFirstInstance, OFFSET$supportsNonZeroFirstInstance);
    }

    public VkPhysicalDeviceVulkan14Properties supportsNonZeroFirstInstance(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$supportsNonZeroFirstInstance, OFFSET$supportsNonZeroFirstInstance, value);
        return this;
    }

    public @Unsigned int maxPushDescriptors() {
        return segment.get(LAYOUT$maxPushDescriptors, OFFSET$maxPushDescriptors);
    }

    public VkPhysicalDeviceVulkan14Properties maxPushDescriptors(@Unsigned int value) {
        segment.set(LAYOUT$maxPushDescriptors, OFFSET$maxPushDescriptors, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int dynamicRenderingLocalReadDepthStencilAttachments() {
        return segment.get(LAYOUT$dynamicRenderingLocalReadDepthStencilAttachments, OFFSET$dynamicRenderingLocalReadDepthStencilAttachments);
    }

    public VkPhysicalDeviceVulkan14Properties dynamicRenderingLocalReadDepthStencilAttachments(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$dynamicRenderingLocalReadDepthStencilAttachments, OFFSET$dynamicRenderingLocalReadDepthStencilAttachments, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int dynamicRenderingLocalReadMultisampledAttachments() {
        return segment.get(LAYOUT$dynamicRenderingLocalReadMultisampledAttachments, OFFSET$dynamicRenderingLocalReadMultisampledAttachments);
    }

    public VkPhysicalDeviceVulkan14Properties dynamicRenderingLocalReadMultisampledAttachments(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$dynamicRenderingLocalReadMultisampledAttachments, OFFSET$dynamicRenderingLocalReadMultisampledAttachments, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int earlyFragmentMultisampleCoverageAfterSampleCounting() {
        return segment.get(LAYOUT$earlyFragmentMultisampleCoverageAfterSampleCounting, OFFSET$earlyFragmentMultisampleCoverageAfterSampleCounting);
    }

    public VkPhysicalDeviceVulkan14Properties earlyFragmentMultisampleCoverageAfterSampleCounting(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$earlyFragmentMultisampleCoverageAfterSampleCounting, OFFSET$earlyFragmentMultisampleCoverageAfterSampleCounting, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int earlyFragmentSampleMaskTestBeforeSampleCounting() {
        return segment.get(LAYOUT$earlyFragmentSampleMaskTestBeforeSampleCounting, OFFSET$earlyFragmentSampleMaskTestBeforeSampleCounting);
    }

    public VkPhysicalDeviceVulkan14Properties earlyFragmentSampleMaskTestBeforeSampleCounting(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$earlyFragmentSampleMaskTestBeforeSampleCounting, OFFSET$earlyFragmentSampleMaskTestBeforeSampleCounting, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int depthStencilSwizzleOneSupport() {
        return segment.get(LAYOUT$depthStencilSwizzleOneSupport, OFFSET$depthStencilSwizzleOneSupport);
    }

    public VkPhysicalDeviceVulkan14Properties depthStencilSwizzleOneSupport(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$depthStencilSwizzleOneSupport, OFFSET$depthStencilSwizzleOneSupport, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int polygonModePointSize() {
        return segment.get(LAYOUT$polygonModePointSize, OFFSET$polygonModePointSize);
    }

    public VkPhysicalDeviceVulkan14Properties polygonModePointSize(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$polygonModePointSize, OFFSET$polygonModePointSize, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int nonStrictSinglePixelWideLinesUseParallelogram() {
        return segment.get(LAYOUT$nonStrictSinglePixelWideLinesUseParallelogram, OFFSET$nonStrictSinglePixelWideLinesUseParallelogram);
    }

    public VkPhysicalDeviceVulkan14Properties nonStrictSinglePixelWideLinesUseParallelogram(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$nonStrictSinglePixelWideLinesUseParallelogram, OFFSET$nonStrictSinglePixelWideLinesUseParallelogram, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int nonStrictWideLinesUseParallelogram() {
        return segment.get(LAYOUT$nonStrictWideLinesUseParallelogram, OFFSET$nonStrictWideLinesUseParallelogram);
    }

    public VkPhysicalDeviceVulkan14Properties nonStrictWideLinesUseParallelogram(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$nonStrictWideLinesUseParallelogram, OFFSET$nonStrictWideLinesUseParallelogram, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int blockTexelViewCompatibleMultipleLayers() {
        return segment.get(LAYOUT$blockTexelViewCompatibleMultipleLayers, OFFSET$blockTexelViewCompatibleMultipleLayers);
    }

    public VkPhysicalDeviceVulkan14Properties blockTexelViewCompatibleMultipleLayers(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$blockTexelViewCompatibleMultipleLayers, OFFSET$blockTexelViewCompatibleMultipleLayers, value);
        return this;
    }

    public @Unsigned int maxCombinedImageSamplerDescriptorCount() {
        return segment.get(LAYOUT$maxCombinedImageSamplerDescriptorCount, OFFSET$maxCombinedImageSamplerDescriptorCount);
    }

    public VkPhysicalDeviceVulkan14Properties maxCombinedImageSamplerDescriptorCount(@Unsigned int value) {
        segment.set(LAYOUT$maxCombinedImageSamplerDescriptorCount, OFFSET$maxCombinedImageSamplerDescriptorCount, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int fragmentShadingRateClampCombinerInputs() {
        return segment.get(LAYOUT$fragmentShadingRateClampCombinerInputs, OFFSET$fragmentShadingRateClampCombinerInputs);
    }

    public VkPhysicalDeviceVulkan14Properties fragmentShadingRateClampCombinerInputs(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$fragmentShadingRateClampCombinerInputs, OFFSET$fragmentShadingRateClampCombinerInputs, value);
        return this;
    }

    public @EnumType(VkPipelineRobustnessBufferBehavior.class) int defaultRobustnessStorageBuffers() {
        return segment.get(LAYOUT$defaultRobustnessStorageBuffers, OFFSET$defaultRobustnessStorageBuffers);
    }

    public VkPhysicalDeviceVulkan14Properties defaultRobustnessStorageBuffers(@EnumType(VkPipelineRobustnessBufferBehavior.class) int value) {
        segment.set(LAYOUT$defaultRobustnessStorageBuffers, OFFSET$defaultRobustnessStorageBuffers, value);
        return this;
    }

    public @EnumType(VkPipelineRobustnessBufferBehavior.class) int defaultRobustnessUniformBuffers() {
        return segment.get(LAYOUT$defaultRobustnessUniformBuffers, OFFSET$defaultRobustnessUniformBuffers);
    }

    public VkPhysicalDeviceVulkan14Properties defaultRobustnessUniformBuffers(@EnumType(VkPipelineRobustnessBufferBehavior.class) int value) {
        segment.set(LAYOUT$defaultRobustnessUniformBuffers, OFFSET$defaultRobustnessUniformBuffers, value);
        return this;
    }

    public @EnumType(VkPipelineRobustnessBufferBehavior.class) int defaultRobustnessVertexInputs() {
        return segment.get(LAYOUT$defaultRobustnessVertexInputs, OFFSET$defaultRobustnessVertexInputs);
    }

    public VkPhysicalDeviceVulkan14Properties defaultRobustnessVertexInputs(@EnumType(VkPipelineRobustnessBufferBehavior.class) int value) {
        segment.set(LAYOUT$defaultRobustnessVertexInputs, OFFSET$defaultRobustnessVertexInputs, value);
        return this;
    }

    public @EnumType(VkPipelineRobustnessImageBehavior.class) int defaultRobustnessImages() {
        return segment.get(LAYOUT$defaultRobustnessImages, OFFSET$defaultRobustnessImages);
    }

    public VkPhysicalDeviceVulkan14Properties defaultRobustnessImages(@EnumType(VkPipelineRobustnessImageBehavior.class) int value) {
        segment.set(LAYOUT$defaultRobustnessImages, OFFSET$defaultRobustnessImages, value);
        return this;
    }

    public @Unsigned int copySrcLayoutCount() {
        return segment.get(LAYOUT$copySrcLayoutCount, OFFSET$copySrcLayoutCount);
    }

    public VkPhysicalDeviceVulkan14Properties copySrcLayoutCount(@Unsigned int value) {
        segment.set(LAYOUT$copySrcLayoutCount, OFFSET$copySrcLayoutCount, value);
        return this;
    }


    /// Note: the returned {@link IntPtr} does not have correct
    /// {@link IntPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link IntPtr#reinterpret} to set the size before actually reading fro
    /// or writing to the buffer.
    public @Nullable @EnumType(VkImageLayout.class) IntPtr pCopySrcLayouts() {
        MemorySegment s = pCopySrcLayoutsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new IntPtr(s);
    }

    public VkPhysicalDeviceVulkan14Properties pCopySrcLayouts(@Nullable @EnumType(VkImageLayout.class) IntPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pCopySrcLayoutsRaw(s);
        return this;
    }

    public @Pointer(target=VkImageLayout.class) @NotNull MemorySegment pCopySrcLayoutsRaw() {
        return segment.get(LAYOUT$pCopySrcLayouts, OFFSET$pCopySrcLayouts);
    }

    public void pCopySrcLayoutsRaw(@Pointer(target=VkImageLayout.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pCopySrcLayouts, OFFSET$pCopySrcLayouts, value);
    }

    public @Unsigned int copyDstLayoutCount() {
        return segment.get(LAYOUT$copyDstLayoutCount, OFFSET$copyDstLayoutCount);
    }

    public VkPhysicalDeviceVulkan14Properties copyDstLayoutCount(@Unsigned int value) {
        segment.set(LAYOUT$copyDstLayoutCount, OFFSET$copyDstLayoutCount, value);
        return this;
    }


    /// Note: the returned {@link IntPtr} does not have correct
    /// {@link IntPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link IntPtr#reinterpret} to set the size before actually reading fro
    /// or writing to the buffer.
    public @Nullable @EnumType(VkImageLayout.class) IntPtr pCopyDstLayouts() {
        MemorySegment s = pCopyDstLayoutsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new IntPtr(s);
    }

    public VkPhysicalDeviceVulkan14Properties pCopyDstLayouts(@Nullable @EnumType(VkImageLayout.class) IntPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pCopyDstLayoutsRaw(s);
        return this;
    }

    public @Pointer(target=VkImageLayout.class) @NotNull MemorySegment pCopyDstLayoutsRaw() {
        return segment.get(LAYOUT$pCopyDstLayouts, OFFSET$pCopyDstLayouts);
    }

    public void pCopyDstLayoutsRaw(@Pointer(target=VkImageLayout.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pCopyDstLayouts, OFFSET$pCopyDstLayouts, value);
    }

    public @Unsigned BytePtr optimalTilingLayoutUUID() {
        return new BytePtr(optimalTilingLayoutUUIDRaw());
    }

    public VkPhysicalDeviceVulkan14Properties optimalTilingLayoutUUID(@NotNull Consumer<BytePtr> consumer) {
        @Unsigned BytePtr ptr = optimalTilingLayoutUUID();
        consumer.accept(ptr);
        return this;
    }

    public VkPhysicalDeviceVulkan14Properties optimalTilingLayoutUUID(@Unsigned BytePtr value) {
        MemorySegment s = optimalTilingLayoutUUIDRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment optimalTilingLayoutUUIDRaw() {
        return segment.asSlice(OFFSET$optimalTilingLayoutUUID, SIZE$optimalTilingLayoutUUID);
    }

    public @NativeType("VkBool32") @Unsigned int identicalMemoryTypeRequirements() {
        return segment.get(LAYOUT$identicalMemoryTypeRequirements, OFFSET$identicalMemoryTypeRequirements);
    }

    public VkPhysicalDeviceVulkan14Properties identicalMemoryTypeRequirements(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$identicalMemoryTypeRequirements, OFFSET$identicalMemoryTypeRequirements, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("lineSubPixelPrecisionBits"),
        ValueLayout.JAVA_INT.withName("maxVertexAttribDivisor"),
        ValueLayout.JAVA_INT.withName("supportsNonZeroFirstInstance"),
        ValueLayout.JAVA_INT.withName("maxPushDescriptors"),
        ValueLayout.JAVA_INT.withName("dynamicRenderingLocalReadDepthStencilAttachments"),
        ValueLayout.JAVA_INT.withName("dynamicRenderingLocalReadMultisampledAttachments"),
        ValueLayout.JAVA_INT.withName("earlyFragmentMultisampleCoverageAfterSampleCounting"),
        ValueLayout.JAVA_INT.withName("earlyFragmentSampleMaskTestBeforeSampleCounting"),
        ValueLayout.JAVA_INT.withName("depthStencilSwizzleOneSupport"),
        ValueLayout.JAVA_INT.withName("polygonModePointSize"),
        ValueLayout.JAVA_INT.withName("nonStrictSinglePixelWideLinesUseParallelogram"),
        ValueLayout.JAVA_INT.withName("nonStrictWideLinesUseParallelogram"),
        ValueLayout.JAVA_INT.withName("blockTexelViewCompatibleMultipleLayers"),
        ValueLayout.JAVA_INT.withName("maxCombinedImageSamplerDescriptorCount"),
        ValueLayout.JAVA_INT.withName("fragmentShadingRateClampCombinerInputs"),
        ValueLayout.JAVA_INT.withName("defaultRobustnessStorageBuffers"),
        ValueLayout.JAVA_INT.withName("defaultRobustnessUniformBuffers"),
        ValueLayout.JAVA_INT.withName("defaultRobustnessVertexInputs"),
        ValueLayout.JAVA_INT.withName("defaultRobustnessImages"),
        ValueLayout.JAVA_INT.withName("copySrcLayoutCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pCopySrcLayouts"),
        ValueLayout.JAVA_INT.withName("copyDstLayoutCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pCopyDstLayouts"),
        MemoryLayout.sequenceLayout(UUID_SIZE, ValueLayout.JAVA_BYTE).withName("optimalTilingLayoutUUID"),
        ValueLayout.JAVA_INT.withName("identicalMemoryTypeRequirements")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$lineSubPixelPrecisionBits = PathElement.groupElement("lineSubPixelPrecisionBits");
    public static final PathElement PATH$maxVertexAttribDivisor = PathElement.groupElement("maxVertexAttribDivisor");
    public static final PathElement PATH$supportsNonZeroFirstInstance = PathElement.groupElement("supportsNonZeroFirstInstance");
    public static final PathElement PATH$maxPushDescriptors = PathElement.groupElement("maxPushDescriptors");
    public static final PathElement PATH$dynamicRenderingLocalReadDepthStencilAttachments = PathElement.groupElement("dynamicRenderingLocalReadDepthStencilAttachments");
    public static final PathElement PATH$dynamicRenderingLocalReadMultisampledAttachments = PathElement.groupElement("dynamicRenderingLocalReadMultisampledAttachments");
    public static final PathElement PATH$earlyFragmentMultisampleCoverageAfterSampleCounting = PathElement.groupElement("earlyFragmentMultisampleCoverageAfterSampleCounting");
    public static final PathElement PATH$earlyFragmentSampleMaskTestBeforeSampleCounting = PathElement.groupElement("earlyFragmentSampleMaskTestBeforeSampleCounting");
    public static final PathElement PATH$depthStencilSwizzleOneSupport = PathElement.groupElement("depthStencilSwizzleOneSupport");
    public static final PathElement PATH$polygonModePointSize = PathElement.groupElement("polygonModePointSize");
    public static final PathElement PATH$nonStrictSinglePixelWideLinesUseParallelogram = PathElement.groupElement("nonStrictSinglePixelWideLinesUseParallelogram");
    public static final PathElement PATH$nonStrictWideLinesUseParallelogram = PathElement.groupElement("nonStrictWideLinesUseParallelogram");
    public static final PathElement PATH$blockTexelViewCompatibleMultipleLayers = PathElement.groupElement("blockTexelViewCompatibleMultipleLayers");
    public static final PathElement PATH$maxCombinedImageSamplerDescriptorCount = PathElement.groupElement("maxCombinedImageSamplerDescriptorCount");
    public static final PathElement PATH$fragmentShadingRateClampCombinerInputs = PathElement.groupElement("fragmentShadingRateClampCombinerInputs");
    public static final PathElement PATH$defaultRobustnessStorageBuffers = PathElement.groupElement("defaultRobustnessStorageBuffers");
    public static final PathElement PATH$defaultRobustnessUniformBuffers = PathElement.groupElement("defaultRobustnessUniformBuffers");
    public static final PathElement PATH$defaultRobustnessVertexInputs = PathElement.groupElement("defaultRobustnessVertexInputs");
    public static final PathElement PATH$defaultRobustnessImages = PathElement.groupElement("defaultRobustnessImages");
    public static final PathElement PATH$copySrcLayoutCount = PathElement.groupElement("copySrcLayoutCount");
    public static final PathElement PATH$pCopySrcLayouts = PathElement.groupElement("pCopySrcLayouts");
    public static final PathElement PATH$copyDstLayoutCount = PathElement.groupElement("copyDstLayoutCount");
    public static final PathElement PATH$pCopyDstLayouts = PathElement.groupElement("pCopyDstLayouts");
    public static final PathElement PATH$optimalTilingLayoutUUID = PathElement.groupElement("optimalTilingLayoutUUID");
    public static final PathElement PATH$identicalMemoryTypeRequirements = PathElement.groupElement("identicalMemoryTypeRequirements");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$lineSubPixelPrecisionBits = (OfInt) LAYOUT.select(PATH$lineSubPixelPrecisionBits);
    public static final OfInt LAYOUT$maxVertexAttribDivisor = (OfInt) LAYOUT.select(PATH$maxVertexAttribDivisor);
    public static final OfInt LAYOUT$supportsNonZeroFirstInstance = (OfInt) LAYOUT.select(PATH$supportsNonZeroFirstInstance);
    public static final OfInt LAYOUT$maxPushDescriptors = (OfInt) LAYOUT.select(PATH$maxPushDescriptors);
    public static final OfInt LAYOUT$dynamicRenderingLocalReadDepthStencilAttachments = (OfInt) LAYOUT.select(PATH$dynamicRenderingLocalReadDepthStencilAttachments);
    public static final OfInt LAYOUT$dynamicRenderingLocalReadMultisampledAttachments = (OfInt) LAYOUT.select(PATH$dynamicRenderingLocalReadMultisampledAttachments);
    public static final OfInt LAYOUT$earlyFragmentMultisampleCoverageAfterSampleCounting = (OfInt) LAYOUT.select(PATH$earlyFragmentMultisampleCoverageAfterSampleCounting);
    public static final OfInt LAYOUT$earlyFragmentSampleMaskTestBeforeSampleCounting = (OfInt) LAYOUT.select(PATH$earlyFragmentSampleMaskTestBeforeSampleCounting);
    public static final OfInt LAYOUT$depthStencilSwizzleOneSupport = (OfInt) LAYOUT.select(PATH$depthStencilSwizzleOneSupport);
    public static final OfInt LAYOUT$polygonModePointSize = (OfInt) LAYOUT.select(PATH$polygonModePointSize);
    public static final OfInt LAYOUT$nonStrictSinglePixelWideLinesUseParallelogram = (OfInt) LAYOUT.select(PATH$nonStrictSinglePixelWideLinesUseParallelogram);
    public static final OfInt LAYOUT$nonStrictWideLinesUseParallelogram = (OfInt) LAYOUT.select(PATH$nonStrictWideLinesUseParallelogram);
    public static final OfInt LAYOUT$blockTexelViewCompatibleMultipleLayers = (OfInt) LAYOUT.select(PATH$blockTexelViewCompatibleMultipleLayers);
    public static final OfInt LAYOUT$maxCombinedImageSamplerDescriptorCount = (OfInt) LAYOUT.select(PATH$maxCombinedImageSamplerDescriptorCount);
    public static final OfInt LAYOUT$fragmentShadingRateClampCombinerInputs = (OfInt) LAYOUT.select(PATH$fragmentShadingRateClampCombinerInputs);
    public static final OfInt LAYOUT$defaultRobustnessStorageBuffers = (OfInt) LAYOUT.select(PATH$defaultRobustnessStorageBuffers);
    public static final OfInt LAYOUT$defaultRobustnessUniformBuffers = (OfInt) LAYOUT.select(PATH$defaultRobustnessUniformBuffers);
    public static final OfInt LAYOUT$defaultRobustnessVertexInputs = (OfInt) LAYOUT.select(PATH$defaultRobustnessVertexInputs);
    public static final OfInt LAYOUT$defaultRobustnessImages = (OfInt) LAYOUT.select(PATH$defaultRobustnessImages);
    public static final OfInt LAYOUT$copySrcLayoutCount = (OfInt) LAYOUT.select(PATH$copySrcLayoutCount);
    public static final AddressLayout LAYOUT$pCopySrcLayouts = (AddressLayout) LAYOUT.select(PATH$pCopySrcLayouts);
    public static final OfInt LAYOUT$copyDstLayoutCount = (OfInt) LAYOUT.select(PATH$copyDstLayoutCount);
    public static final AddressLayout LAYOUT$pCopyDstLayouts = (AddressLayout) LAYOUT.select(PATH$pCopyDstLayouts);
    public static final SequenceLayout LAYOUT$optimalTilingLayoutUUID = (SequenceLayout) LAYOUT.select(PATH$optimalTilingLayoutUUID);
    public static final OfInt LAYOUT$identicalMemoryTypeRequirements = (OfInt) LAYOUT.select(PATH$identicalMemoryTypeRequirements);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$lineSubPixelPrecisionBits = LAYOUT$lineSubPixelPrecisionBits.byteSize();
    public static final long SIZE$maxVertexAttribDivisor = LAYOUT$maxVertexAttribDivisor.byteSize();
    public static final long SIZE$supportsNonZeroFirstInstance = LAYOUT$supportsNonZeroFirstInstance.byteSize();
    public static final long SIZE$maxPushDescriptors = LAYOUT$maxPushDescriptors.byteSize();
    public static final long SIZE$dynamicRenderingLocalReadDepthStencilAttachments = LAYOUT$dynamicRenderingLocalReadDepthStencilAttachments.byteSize();
    public static final long SIZE$dynamicRenderingLocalReadMultisampledAttachments = LAYOUT$dynamicRenderingLocalReadMultisampledAttachments.byteSize();
    public static final long SIZE$earlyFragmentMultisampleCoverageAfterSampleCounting = LAYOUT$earlyFragmentMultisampleCoverageAfterSampleCounting.byteSize();
    public static final long SIZE$earlyFragmentSampleMaskTestBeforeSampleCounting = LAYOUT$earlyFragmentSampleMaskTestBeforeSampleCounting.byteSize();
    public static final long SIZE$depthStencilSwizzleOneSupport = LAYOUT$depthStencilSwizzleOneSupport.byteSize();
    public static final long SIZE$polygonModePointSize = LAYOUT$polygonModePointSize.byteSize();
    public static final long SIZE$nonStrictSinglePixelWideLinesUseParallelogram = LAYOUT$nonStrictSinglePixelWideLinesUseParallelogram.byteSize();
    public static final long SIZE$nonStrictWideLinesUseParallelogram = LAYOUT$nonStrictWideLinesUseParallelogram.byteSize();
    public static final long SIZE$blockTexelViewCompatibleMultipleLayers = LAYOUT$blockTexelViewCompatibleMultipleLayers.byteSize();
    public static final long SIZE$maxCombinedImageSamplerDescriptorCount = LAYOUT$maxCombinedImageSamplerDescriptorCount.byteSize();
    public static final long SIZE$fragmentShadingRateClampCombinerInputs = LAYOUT$fragmentShadingRateClampCombinerInputs.byteSize();
    public static final long SIZE$defaultRobustnessStorageBuffers = LAYOUT$defaultRobustnessStorageBuffers.byteSize();
    public static final long SIZE$defaultRobustnessUniformBuffers = LAYOUT$defaultRobustnessUniformBuffers.byteSize();
    public static final long SIZE$defaultRobustnessVertexInputs = LAYOUT$defaultRobustnessVertexInputs.byteSize();
    public static final long SIZE$defaultRobustnessImages = LAYOUT$defaultRobustnessImages.byteSize();
    public static final long SIZE$copySrcLayoutCount = LAYOUT$copySrcLayoutCount.byteSize();
    public static final long SIZE$pCopySrcLayouts = LAYOUT$pCopySrcLayouts.byteSize();
    public static final long SIZE$copyDstLayoutCount = LAYOUT$copyDstLayoutCount.byteSize();
    public static final long SIZE$pCopyDstLayouts = LAYOUT$pCopyDstLayouts.byteSize();
    public static final long SIZE$optimalTilingLayoutUUID = LAYOUT$optimalTilingLayoutUUID.byteSize();
    public static final long SIZE$identicalMemoryTypeRequirements = LAYOUT$identicalMemoryTypeRequirements.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$lineSubPixelPrecisionBits = LAYOUT.byteOffset(PATH$lineSubPixelPrecisionBits);
    public static final long OFFSET$maxVertexAttribDivisor = LAYOUT.byteOffset(PATH$maxVertexAttribDivisor);
    public static final long OFFSET$supportsNonZeroFirstInstance = LAYOUT.byteOffset(PATH$supportsNonZeroFirstInstance);
    public static final long OFFSET$maxPushDescriptors = LAYOUT.byteOffset(PATH$maxPushDescriptors);
    public static final long OFFSET$dynamicRenderingLocalReadDepthStencilAttachments = LAYOUT.byteOffset(PATH$dynamicRenderingLocalReadDepthStencilAttachments);
    public static final long OFFSET$dynamicRenderingLocalReadMultisampledAttachments = LAYOUT.byteOffset(PATH$dynamicRenderingLocalReadMultisampledAttachments);
    public static final long OFFSET$earlyFragmentMultisampleCoverageAfterSampleCounting = LAYOUT.byteOffset(PATH$earlyFragmentMultisampleCoverageAfterSampleCounting);
    public static final long OFFSET$earlyFragmentSampleMaskTestBeforeSampleCounting = LAYOUT.byteOffset(PATH$earlyFragmentSampleMaskTestBeforeSampleCounting);
    public static final long OFFSET$depthStencilSwizzleOneSupport = LAYOUT.byteOffset(PATH$depthStencilSwizzleOneSupport);
    public static final long OFFSET$polygonModePointSize = LAYOUT.byteOffset(PATH$polygonModePointSize);
    public static final long OFFSET$nonStrictSinglePixelWideLinesUseParallelogram = LAYOUT.byteOffset(PATH$nonStrictSinglePixelWideLinesUseParallelogram);
    public static final long OFFSET$nonStrictWideLinesUseParallelogram = LAYOUT.byteOffset(PATH$nonStrictWideLinesUseParallelogram);
    public static final long OFFSET$blockTexelViewCompatibleMultipleLayers = LAYOUT.byteOffset(PATH$blockTexelViewCompatibleMultipleLayers);
    public static final long OFFSET$maxCombinedImageSamplerDescriptorCount = LAYOUT.byteOffset(PATH$maxCombinedImageSamplerDescriptorCount);
    public static final long OFFSET$fragmentShadingRateClampCombinerInputs = LAYOUT.byteOffset(PATH$fragmentShadingRateClampCombinerInputs);
    public static final long OFFSET$defaultRobustnessStorageBuffers = LAYOUT.byteOffset(PATH$defaultRobustnessStorageBuffers);
    public static final long OFFSET$defaultRobustnessUniformBuffers = LAYOUT.byteOffset(PATH$defaultRobustnessUniformBuffers);
    public static final long OFFSET$defaultRobustnessVertexInputs = LAYOUT.byteOffset(PATH$defaultRobustnessVertexInputs);
    public static final long OFFSET$defaultRobustnessImages = LAYOUT.byteOffset(PATH$defaultRobustnessImages);
    public static final long OFFSET$copySrcLayoutCount = LAYOUT.byteOffset(PATH$copySrcLayoutCount);
    public static final long OFFSET$pCopySrcLayouts = LAYOUT.byteOffset(PATH$pCopySrcLayouts);
    public static final long OFFSET$copyDstLayoutCount = LAYOUT.byteOffset(PATH$copyDstLayoutCount);
    public static final long OFFSET$pCopyDstLayouts = LAYOUT.byteOffset(PATH$pCopyDstLayouts);
    public static final long OFFSET$optimalTilingLayoutUUID = LAYOUT.byteOffset(PATH$optimalTilingLayoutUUID);
    public static final long OFFSET$identicalMemoryTypeRequirements = LAYOUT.byteOffset(PATH$identicalMemoryTypeRequirements);
}
