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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceVulkan12Properties.html"><code>VkPhysicalDeviceVulkan12Properties</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceVulkan12Properties {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkDriverId driverID; // @link substring="VkDriverId" target="VkDriverId" @link substring="driverID" target="#driverID"
///     char[VK_MAX_DRIVER_NAME_SIZE] driverName; // @link substring="driverName" target="#driverName"
///     char[VK_MAX_DRIVER_INFO_SIZE] driverInfo; // @link substring="driverInfo" target="#driverInfo"
///     VkConformanceVersion conformanceVersion; // @link substring="VkConformanceVersion" target="VkConformanceVersion" @link substring="conformanceVersion" target="#conformanceVersion"
///     VkShaderFloatControlsIndependence denormBehaviorIndependence; // @link substring="VkShaderFloatControlsIndependence" target="VkShaderFloatControlsIndependence" @link substring="denormBehaviorIndependence" target="#denormBehaviorIndependence"
///     VkShaderFloatControlsIndependence roundingModeIndependence; // @link substring="VkShaderFloatControlsIndependence" target="VkShaderFloatControlsIndependence" @link substring="roundingModeIndependence" target="#roundingModeIndependence"
///     VkBool32 shaderSignedZeroInfNanPreserveFloat16; // @link substring="shaderSignedZeroInfNanPreserveFloat16" target="#shaderSignedZeroInfNanPreserveFloat16"
///     VkBool32 shaderSignedZeroInfNanPreserveFloat32; // @link substring="shaderSignedZeroInfNanPreserveFloat32" target="#shaderSignedZeroInfNanPreserveFloat32"
///     VkBool32 shaderSignedZeroInfNanPreserveFloat64; // @link substring="shaderSignedZeroInfNanPreserveFloat64" target="#shaderSignedZeroInfNanPreserveFloat64"
///     VkBool32 shaderDenormPreserveFloat16; // @link substring="shaderDenormPreserveFloat16" target="#shaderDenormPreserveFloat16"
///     VkBool32 shaderDenormPreserveFloat32; // @link substring="shaderDenormPreserveFloat32" target="#shaderDenormPreserveFloat32"
///     VkBool32 shaderDenormPreserveFloat64; // @link substring="shaderDenormPreserveFloat64" target="#shaderDenormPreserveFloat64"
///     VkBool32 shaderDenormFlushToZeroFloat16; // @link substring="shaderDenormFlushToZeroFloat16" target="#shaderDenormFlushToZeroFloat16"
///     VkBool32 shaderDenormFlushToZeroFloat32; // @link substring="shaderDenormFlushToZeroFloat32" target="#shaderDenormFlushToZeroFloat32"
///     VkBool32 shaderDenormFlushToZeroFloat64; // @link substring="shaderDenormFlushToZeroFloat64" target="#shaderDenormFlushToZeroFloat64"
///     VkBool32 shaderRoundingModeRTEFloat16; // @link substring="shaderRoundingModeRTEFloat16" target="#shaderRoundingModeRTEFloat16"
///     VkBool32 shaderRoundingModeRTEFloat32; // @link substring="shaderRoundingModeRTEFloat32" target="#shaderRoundingModeRTEFloat32"
///     VkBool32 shaderRoundingModeRTEFloat64; // @link substring="shaderRoundingModeRTEFloat64" target="#shaderRoundingModeRTEFloat64"
///     VkBool32 shaderRoundingModeRTZFloat16; // @link substring="shaderRoundingModeRTZFloat16" target="#shaderRoundingModeRTZFloat16"
///     VkBool32 shaderRoundingModeRTZFloat32; // @link substring="shaderRoundingModeRTZFloat32" target="#shaderRoundingModeRTZFloat32"
///     VkBool32 shaderRoundingModeRTZFloat64; // @link substring="shaderRoundingModeRTZFloat64" target="#shaderRoundingModeRTZFloat64"
///     uint32_t maxUpdateAfterBindDescriptorsInAllPools; // @link substring="maxUpdateAfterBindDescriptorsInAllPools" target="#maxUpdateAfterBindDescriptorsInAllPools"
///     VkBool32 shaderUniformBufferArrayNonUniformIndexingNative; // @link substring="shaderUniformBufferArrayNonUniformIndexingNative" target="#shaderUniformBufferArrayNonUniformIndexingNative"
///     VkBool32 shaderSampledImageArrayNonUniformIndexingNative; // @link substring="shaderSampledImageArrayNonUniformIndexingNative" target="#shaderSampledImageArrayNonUniformIndexingNative"
///     VkBool32 shaderStorageBufferArrayNonUniformIndexingNative; // @link substring="shaderStorageBufferArrayNonUniformIndexingNative" target="#shaderStorageBufferArrayNonUniformIndexingNative"
///     VkBool32 shaderStorageImageArrayNonUniformIndexingNative; // @link substring="shaderStorageImageArrayNonUniformIndexingNative" target="#shaderStorageImageArrayNonUniformIndexingNative"
///     VkBool32 shaderInputAttachmentArrayNonUniformIndexingNative; // @link substring="shaderInputAttachmentArrayNonUniformIndexingNative" target="#shaderInputAttachmentArrayNonUniformIndexingNative"
///     VkBool32 robustBufferAccessUpdateAfterBind; // @link substring="robustBufferAccessUpdateAfterBind" target="#robustBufferAccessUpdateAfterBind"
///     VkBool32 quadDivergentImplicitLod; // @link substring="quadDivergentImplicitLod" target="#quadDivergentImplicitLod"
///     uint32_t maxPerStageDescriptorUpdateAfterBindSamplers; // @link substring="maxPerStageDescriptorUpdateAfterBindSamplers" target="#maxPerStageDescriptorUpdateAfterBindSamplers"
///     uint32_t maxPerStageDescriptorUpdateAfterBindUniformBuffers; // @link substring="maxPerStageDescriptorUpdateAfterBindUniformBuffers" target="#maxPerStageDescriptorUpdateAfterBindUniformBuffers"
///     uint32_t maxPerStageDescriptorUpdateAfterBindStorageBuffers; // @link substring="maxPerStageDescriptorUpdateAfterBindStorageBuffers" target="#maxPerStageDescriptorUpdateAfterBindStorageBuffers"
///     uint32_t maxPerStageDescriptorUpdateAfterBindSampledImages; // @link substring="maxPerStageDescriptorUpdateAfterBindSampledImages" target="#maxPerStageDescriptorUpdateAfterBindSampledImages"
///     uint32_t maxPerStageDescriptorUpdateAfterBindStorageImages; // @link substring="maxPerStageDescriptorUpdateAfterBindStorageImages" target="#maxPerStageDescriptorUpdateAfterBindStorageImages"
///     uint32_t maxPerStageDescriptorUpdateAfterBindInputAttachments; // @link substring="maxPerStageDescriptorUpdateAfterBindInputAttachments" target="#maxPerStageDescriptorUpdateAfterBindInputAttachments"
///     uint32_t maxPerStageUpdateAfterBindResources; // @link substring="maxPerStageUpdateAfterBindResources" target="#maxPerStageUpdateAfterBindResources"
///     uint32_t maxDescriptorSetUpdateAfterBindSamplers; // @link substring="maxDescriptorSetUpdateAfterBindSamplers" target="#maxDescriptorSetUpdateAfterBindSamplers"
///     uint32_t maxDescriptorSetUpdateAfterBindUniformBuffers; // @link substring="maxDescriptorSetUpdateAfterBindUniformBuffers" target="#maxDescriptorSetUpdateAfterBindUniformBuffers"
///     uint32_t maxDescriptorSetUpdateAfterBindUniformBuffersDynamic; // @link substring="maxDescriptorSetUpdateAfterBindUniformBuffersDynamic" target="#maxDescriptorSetUpdateAfterBindUniformBuffersDynamic"
///     uint32_t maxDescriptorSetUpdateAfterBindStorageBuffers; // @link substring="maxDescriptorSetUpdateAfterBindStorageBuffers" target="#maxDescriptorSetUpdateAfterBindStorageBuffers"
///     uint32_t maxDescriptorSetUpdateAfterBindStorageBuffersDynamic; // @link substring="maxDescriptorSetUpdateAfterBindStorageBuffersDynamic" target="#maxDescriptorSetUpdateAfterBindStorageBuffersDynamic"
///     uint32_t maxDescriptorSetUpdateAfterBindSampledImages; // @link substring="maxDescriptorSetUpdateAfterBindSampledImages" target="#maxDescriptorSetUpdateAfterBindSampledImages"
///     uint32_t maxDescriptorSetUpdateAfterBindStorageImages; // @link substring="maxDescriptorSetUpdateAfterBindStorageImages" target="#maxDescriptorSetUpdateAfterBindStorageImages"
///     uint32_t maxDescriptorSetUpdateAfterBindInputAttachments; // @link substring="maxDescriptorSetUpdateAfterBindInputAttachments" target="#maxDescriptorSetUpdateAfterBindInputAttachments"
///     VkResolveModeFlags supportedDepthResolveModes; // @link substring="VkResolveModeFlags" target="VkResolveModeFlags" @link substring="supportedDepthResolveModes" target="#supportedDepthResolveModes"
///     VkResolveModeFlags supportedStencilResolveModes; // @link substring="VkResolveModeFlags" target="VkResolveModeFlags" @link substring="supportedStencilResolveModes" target="#supportedStencilResolveModes"
///     VkBool32 independentResolveNone; // @link substring="independentResolveNone" target="#independentResolveNone"
///     VkBool32 independentResolve; // @link substring="independentResolve" target="#independentResolve"
///     VkBool32 filterMinmaxSingleComponentFormats; // @link substring="filterMinmaxSingleComponentFormats" target="#filterMinmaxSingleComponentFormats"
///     VkBool32 filterMinmaxImageComponentMapping; // @link substring="filterMinmaxImageComponentMapping" target="#filterMinmaxImageComponentMapping"
///     uint64_t maxTimelineSemaphoreValueDifference; // @link substring="maxTimelineSemaphoreValueDifference" target="#maxTimelineSemaphoreValueDifference"
///     VkSampleCountFlags framebufferIntegerColorSampleCounts; // optional // @link substring="VkSampleCountFlags" target="VkSampleCountFlags" @link substring="framebufferIntegerColorSampleCounts" target="#framebufferIntegerColorSampleCounts"
/// } VkPhysicalDeviceVulkan12Properties;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_VULKAN_1_2_PROPERTIES`
///
/// The {@code allocate} ({@link VkPhysicalDeviceVulkan12Properties#allocate(Arena)}, {@link VkPhysicalDeviceVulkan12Properties#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceVulkan12Properties#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceVulkan12Properties.html"><code>VkPhysicalDeviceVulkan12Properties</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceVulkan12Properties(@NotNull MemorySegment segment) implements IVkPhysicalDeviceVulkan12Properties {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceVulkan12Properties.html"><code>VkPhysicalDeviceVulkan12Properties</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceVulkan12Properties}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceVulkan12Properties to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceVulkan12Properties.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceVulkan12Properties, Iterable<VkPhysicalDeviceVulkan12Properties> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceVulkan12Properties.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceVulkan12Properties at(long index) {
            return new VkPhysicalDeviceVulkan12Properties(segment.asSlice(index * VkPhysicalDeviceVulkan12Properties.BYTES, VkPhysicalDeviceVulkan12Properties.BYTES));
        }

        public VkPhysicalDeviceVulkan12Properties.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceVulkan12Properties> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceVulkan12Properties value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceVulkan12Properties.BYTES, VkPhysicalDeviceVulkan12Properties.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceVulkan12Properties.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceVulkan12Properties.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceVulkan12Properties.BYTES,
                (end - start) * VkPhysicalDeviceVulkan12Properties.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceVulkan12Properties.BYTES));
        }

        public VkPhysicalDeviceVulkan12Properties[] toArray() {
            VkPhysicalDeviceVulkan12Properties[] ret = new VkPhysicalDeviceVulkan12Properties[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceVulkan12Properties> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceVulkan12Properties> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceVulkan12Properties.BYTES;
            }

            @Override
            public VkPhysicalDeviceVulkan12Properties next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceVulkan12Properties ret = new VkPhysicalDeviceVulkan12Properties(segment.asSlice(0, VkPhysicalDeviceVulkan12Properties.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceVulkan12Properties.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceVulkan12Properties allocate(Arena arena) {
        VkPhysicalDeviceVulkan12Properties ret = new VkPhysicalDeviceVulkan12Properties(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_VULKAN_1_2_PROPERTIES);
        return ret;
    }

    public static VkPhysicalDeviceVulkan12Properties.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceVulkan12Properties.Ptr ret = new VkPhysicalDeviceVulkan12Properties.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_VULKAN_1_2_PROPERTIES);
        }
        return ret;
    }

    public static VkPhysicalDeviceVulkan12Properties clone(Arena arena, VkPhysicalDeviceVulkan12Properties src) {
        VkPhysicalDeviceVulkan12Properties ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_VULKAN_1_2_PROPERTIES);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceVulkan12Properties sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceVulkan12Properties pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceVulkan12Properties pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @EnumType(VkDriverId.class) int driverID() {
        return segment.get(LAYOUT$driverID, OFFSET$driverID);
    }

    public VkPhysicalDeviceVulkan12Properties driverID(@EnumType(VkDriverId.class) int value) {
        segment.set(LAYOUT$driverID, OFFSET$driverID, value);
        return this;
    }

    public BytePtr driverName() {
        return new BytePtr(driverNameRaw());
    }

    public VkPhysicalDeviceVulkan12Properties driverName(@NotNull Consumer<BytePtr> consumer) {
        BytePtr ptr = driverName();
        consumer.accept(ptr);
        return this;
    }

    public VkPhysicalDeviceVulkan12Properties driverName(BytePtr value) {
        MemorySegment s = driverNameRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment driverNameRaw() {
        return segment.asSlice(OFFSET$driverName, SIZE$driverName);
    }

    public BytePtr driverInfo() {
        return new BytePtr(driverInfoRaw());
    }

    public VkPhysicalDeviceVulkan12Properties driverInfo(@NotNull Consumer<BytePtr> consumer) {
        BytePtr ptr = driverInfo();
        consumer.accept(ptr);
        return this;
    }

    public VkPhysicalDeviceVulkan12Properties driverInfo(BytePtr value) {
        MemorySegment s = driverInfoRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment driverInfoRaw() {
        return segment.asSlice(OFFSET$driverInfo, SIZE$driverInfo);
    }

    public @NotNull VkConformanceVersion conformanceVersion() {
        return new VkConformanceVersion(segment.asSlice(OFFSET$conformanceVersion, LAYOUT$conformanceVersion));
    }

    public VkPhysicalDeviceVulkan12Properties conformanceVersion(@NotNull VkConformanceVersion value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$conformanceVersion, SIZE$conformanceVersion);
        return this;
    }

    public VkPhysicalDeviceVulkan12Properties conformanceVersion(Consumer<@NotNull VkConformanceVersion> consumer) {
        consumer.accept(conformanceVersion());
        return this;
    }

    public @EnumType(VkShaderFloatControlsIndependence.class) int denormBehaviorIndependence() {
        return segment.get(LAYOUT$denormBehaviorIndependence, OFFSET$denormBehaviorIndependence);
    }

    public VkPhysicalDeviceVulkan12Properties denormBehaviorIndependence(@EnumType(VkShaderFloatControlsIndependence.class) int value) {
        segment.set(LAYOUT$denormBehaviorIndependence, OFFSET$denormBehaviorIndependence, value);
        return this;
    }

    public @EnumType(VkShaderFloatControlsIndependence.class) int roundingModeIndependence() {
        return segment.get(LAYOUT$roundingModeIndependence, OFFSET$roundingModeIndependence);
    }

    public VkPhysicalDeviceVulkan12Properties roundingModeIndependence(@EnumType(VkShaderFloatControlsIndependence.class) int value) {
        segment.set(LAYOUT$roundingModeIndependence, OFFSET$roundingModeIndependence, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderSignedZeroInfNanPreserveFloat16() {
        return segment.get(LAYOUT$shaderSignedZeroInfNanPreserveFloat16, OFFSET$shaderSignedZeroInfNanPreserveFloat16);
    }

    public VkPhysicalDeviceVulkan12Properties shaderSignedZeroInfNanPreserveFloat16(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderSignedZeroInfNanPreserveFloat16, OFFSET$shaderSignedZeroInfNanPreserveFloat16, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderSignedZeroInfNanPreserveFloat32() {
        return segment.get(LAYOUT$shaderSignedZeroInfNanPreserveFloat32, OFFSET$shaderSignedZeroInfNanPreserveFloat32);
    }

    public VkPhysicalDeviceVulkan12Properties shaderSignedZeroInfNanPreserveFloat32(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderSignedZeroInfNanPreserveFloat32, OFFSET$shaderSignedZeroInfNanPreserveFloat32, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderSignedZeroInfNanPreserveFloat64() {
        return segment.get(LAYOUT$shaderSignedZeroInfNanPreserveFloat64, OFFSET$shaderSignedZeroInfNanPreserveFloat64);
    }

    public VkPhysicalDeviceVulkan12Properties shaderSignedZeroInfNanPreserveFloat64(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderSignedZeroInfNanPreserveFloat64, OFFSET$shaderSignedZeroInfNanPreserveFloat64, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderDenormPreserveFloat16() {
        return segment.get(LAYOUT$shaderDenormPreserveFloat16, OFFSET$shaderDenormPreserveFloat16);
    }

    public VkPhysicalDeviceVulkan12Properties shaderDenormPreserveFloat16(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderDenormPreserveFloat16, OFFSET$shaderDenormPreserveFloat16, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderDenormPreserveFloat32() {
        return segment.get(LAYOUT$shaderDenormPreserveFloat32, OFFSET$shaderDenormPreserveFloat32);
    }

    public VkPhysicalDeviceVulkan12Properties shaderDenormPreserveFloat32(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderDenormPreserveFloat32, OFFSET$shaderDenormPreserveFloat32, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderDenormPreserveFloat64() {
        return segment.get(LAYOUT$shaderDenormPreserveFloat64, OFFSET$shaderDenormPreserveFloat64);
    }

    public VkPhysicalDeviceVulkan12Properties shaderDenormPreserveFloat64(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderDenormPreserveFloat64, OFFSET$shaderDenormPreserveFloat64, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderDenormFlushToZeroFloat16() {
        return segment.get(LAYOUT$shaderDenormFlushToZeroFloat16, OFFSET$shaderDenormFlushToZeroFloat16);
    }

    public VkPhysicalDeviceVulkan12Properties shaderDenormFlushToZeroFloat16(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderDenormFlushToZeroFloat16, OFFSET$shaderDenormFlushToZeroFloat16, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderDenormFlushToZeroFloat32() {
        return segment.get(LAYOUT$shaderDenormFlushToZeroFloat32, OFFSET$shaderDenormFlushToZeroFloat32);
    }

    public VkPhysicalDeviceVulkan12Properties shaderDenormFlushToZeroFloat32(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderDenormFlushToZeroFloat32, OFFSET$shaderDenormFlushToZeroFloat32, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderDenormFlushToZeroFloat64() {
        return segment.get(LAYOUT$shaderDenormFlushToZeroFloat64, OFFSET$shaderDenormFlushToZeroFloat64);
    }

    public VkPhysicalDeviceVulkan12Properties shaderDenormFlushToZeroFloat64(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderDenormFlushToZeroFloat64, OFFSET$shaderDenormFlushToZeroFloat64, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderRoundingModeRTEFloat16() {
        return segment.get(LAYOUT$shaderRoundingModeRTEFloat16, OFFSET$shaderRoundingModeRTEFloat16);
    }

    public VkPhysicalDeviceVulkan12Properties shaderRoundingModeRTEFloat16(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderRoundingModeRTEFloat16, OFFSET$shaderRoundingModeRTEFloat16, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderRoundingModeRTEFloat32() {
        return segment.get(LAYOUT$shaderRoundingModeRTEFloat32, OFFSET$shaderRoundingModeRTEFloat32);
    }

    public VkPhysicalDeviceVulkan12Properties shaderRoundingModeRTEFloat32(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderRoundingModeRTEFloat32, OFFSET$shaderRoundingModeRTEFloat32, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderRoundingModeRTEFloat64() {
        return segment.get(LAYOUT$shaderRoundingModeRTEFloat64, OFFSET$shaderRoundingModeRTEFloat64);
    }

    public VkPhysicalDeviceVulkan12Properties shaderRoundingModeRTEFloat64(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderRoundingModeRTEFloat64, OFFSET$shaderRoundingModeRTEFloat64, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderRoundingModeRTZFloat16() {
        return segment.get(LAYOUT$shaderRoundingModeRTZFloat16, OFFSET$shaderRoundingModeRTZFloat16);
    }

    public VkPhysicalDeviceVulkan12Properties shaderRoundingModeRTZFloat16(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderRoundingModeRTZFloat16, OFFSET$shaderRoundingModeRTZFloat16, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderRoundingModeRTZFloat32() {
        return segment.get(LAYOUT$shaderRoundingModeRTZFloat32, OFFSET$shaderRoundingModeRTZFloat32);
    }

    public VkPhysicalDeviceVulkan12Properties shaderRoundingModeRTZFloat32(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderRoundingModeRTZFloat32, OFFSET$shaderRoundingModeRTZFloat32, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderRoundingModeRTZFloat64() {
        return segment.get(LAYOUT$shaderRoundingModeRTZFloat64, OFFSET$shaderRoundingModeRTZFloat64);
    }

    public VkPhysicalDeviceVulkan12Properties shaderRoundingModeRTZFloat64(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderRoundingModeRTZFloat64, OFFSET$shaderRoundingModeRTZFloat64, value);
        return this;
    }

    public @Unsigned int maxUpdateAfterBindDescriptorsInAllPools() {
        return segment.get(LAYOUT$maxUpdateAfterBindDescriptorsInAllPools, OFFSET$maxUpdateAfterBindDescriptorsInAllPools);
    }

    public VkPhysicalDeviceVulkan12Properties maxUpdateAfterBindDescriptorsInAllPools(@Unsigned int value) {
        segment.set(LAYOUT$maxUpdateAfterBindDescriptorsInAllPools, OFFSET$maxUpdateAfterBindDescriptorsInAllPools, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderUniformBufferArrayNonUniformIndexingNative() {
        return segment.get(LAYOUT$shaderUniformBufferArrayNonUniformIndexingNative, OFFSET$shaderUniformBufferArrayNonUniformIndexingNative);
    }

    public VkPhysicalDeviceVulkan12Properties shaderUniformBufferArrayNonUniformIndexingNative(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderUniformBufferArrayNonUniformIndexingNative, OFFSET$shaderUniformBufferArrayNonUniformIndexingNative, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderSampledImageArrayNonUniformIndexingNative() {
        return segment.get(LAYOUT$shaderSampledImageArrayNonUniformIndexingNative, OFFSET$shaderSampledImageArrayNonUniformIndexingNative);
    }

    public VkPhysicalDeviceVulkan12Properties shaderSampledImageArrayNonUniformIndexingNative(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderSampledImageArrayNonUniformIndexingNative, OFFSET$shaderSampledImageArrayNonUniformIndexingNative, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderStorageBufferArrayNonUniformIndexingNative() {
        return segment.get(LAYOUT$shaderStorageBufferArrayNonUniformIndexingNative, OFFSET$shaderStorageBufferArrayNonUniformIndexingNative);
    }

    public VkPhysicalDeviceVulkan12Properties shaderStorageBufferArrayNonUniformIndexingNative(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderStorageBufferArrayNonUniformIndexingNative, OFFSET$shaderStorageBufferArrayNonUniformIndexingNative, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderStorageImageArrayNonUniformIndexingNative() {
        return segment.get(LAYOUT$shaderStorageImageArrayNonUniformIndexingNative, OFFSET$shaderStorageImageArrayNonUniformIndexingNative);
    }

    public VkPhysicalDeviceVulkan12Properties shaderStorageImageArrayNonUniformIndexingNative(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderStorageImageArrayNonUniformIndexingNative, OFFSET$shaderStorageImageArrayNonUniformIndexingNative, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderInputAttachmentArrayNonUniformIndexingNative() {
        return segment.get(LAYOUT$shaderInputAttachmentArrayNonUniformIndexingNative, OFFSET$shaderInputAttachmentArrayNonUniformIndexingNative);
    }

    public VkPhysicalDeviceVulkan12Properties shaderInputAttachmentArrayNonUniformIndexingNative(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderInputAttachmentArrayNonUniformIndexingNative, OFFSET$shaderInputAttachmentArrayNonUniformIndexingNative, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int robustBufferAccessUpdateAfterBind() {
        return segment.get(LAYOUT$robustBufferAccessUpdateAfterBind, OFFSET$robustBufferAccessUpdateAfterBind);
    }

    public VkPhysicalDeviceVulkan12Properties robustBufferAccessUpdateAfterBind(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$robustBufferAccessUpdateAfterBind, OFFSET$robustBufferAccessUpdateAfterBind, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int quadDivergentImplicitLod() {
        return segment.get(LAYOUT$quadDivergentImplicitLod, OFFSET$quadDivergentImplicitLod);
    }

    public VkPhysicalDeviceVulkan12Properties quadDivergentImplicitLod(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$quadDivergentImplicitLod, OFFSET$quadDivergentImplicitLod, value);
        return this;
    }

    public @Unsigned int maxPerStageDescriptorUpdateAfterBindSamplers() {
        return segment.get(LAYOUT$maxPerStageDescriptorUpdateAfterBindSamplers, OFFSET$maxPerStageDescriptorUpdateAfterBindSamplers);
    }

    public VkPhysicalDeviceVulkan12Properties maxPerStageDescriptorUpdateAfterBindSamplers(@Unsigned int value) {
        segment.set(LAYOUT$maxPerStageDescriptorUpdateAfterBindSamplers, OFFSET$maxPerStageDescriptorUpdateAfterBindSamplers, value);
        return this;
    }

    public @Unsigned int maxPerStageDescriptorUpdateAfterBindUniformBuffers() {
        return segment.get(LAYOUT$maxPerStageDescriptorUpdateAfterBindUniformBuffers, OFFSET$maxPerStageDescriptorUpdateAfterBindUniformBuffers);
    }

    public VkPhysicalDeviceVulkan12Properties maxPerStageDescriptorUpdateAfterBindUniformBuffers(@Unsigned int value) {
        segment.set(LAYOUT$maxPerStageDescriptorUpdateAfterBindUniformBuffers, OFFSET$maxPerStageDescriptorUpdateAfterBindUniformBuffers, value);
        return this;
    }

    public @Unsigned int maxPerStageDescriptorUpdateAfterBindStorageBuffers() {
        return segment.get(LAYOUT$maxPerStageDescriptorUpdateAfterBindStorageBuffers, OFFSET$maxPerStageDescriptorUpdateAfterBindStorageBuffers);
    }

    public VkPhysicalDeviceVulkan12Properties maxPerStageDescriptorUpdateAfterBindStorageBuffers(@Unsigned int value) {
        segment.set(LAYOUT$maxPerStageDescriptorUpdateAfterBindStorageBuffers, OFFSET$maxPerStageDescriptorUpdateAfterBindStorageBuffers, value);
        return this;
    }

    public @Unsigned int maxPerStageDescriptorUpdateAfterBindSampledImages() {
        return segment.get(LAYOUT$maxPerStageDescriptorUpdateAfterBindSampledImages, OFFSET$maxPerStageDescriptorUpdateAfterBindSampledImages);
    }

    public VkPhysicalDeviceVulkan12Properties maxPerStageDescriptorUpdateAfterBindSampledImages(@Unsigned int value) {
        segment.set(LAYOUT$maxPerStageDescriptorUpdateAfterBindSampledImages, OFFSET$maxPerStageDescriptorUpdateAfterBindSampledImages, value);
        return this;
    }

    public @Unsigned int maxPerStageDescriptorUpdateAfterBindStorageImages() {
        return segment.get(LAYOUT$maxPerStageDescriptorUpdateAfterBindStorageImages, OFFSET$maxPerStageDescriptorUpdateAfterBindStorageImages);
    }

    public VkPhysicalDeviceVulkan12Properties maxPerStageDescriptorUpdateAfterBindStorageImages(@Unsigned int value) {
        segment.set(LAYOUT$maxPerStageDescriptorUpdateAfterBindStorageImages, OFFSET$maxPerStageDescriptorUpdateAfterBindStorageImages, value);
        return this;
    }

    public @Unsigned int maxPerStageDescriptorUpdateAfterBindInputAttachments() {
        return segment.get(LAYOUT$maxPerStageDescriptorUpdateAfterBindInputAttachments, OFFSET$maxPerStageDescriptorUpdateAfterBindInputAttachments);
    }

    public VkPhysicalDeviceVulkan12Properties maxPerStageDescriptorUpdateAfterBindInputAttachments(@Unsigned int value) {
        segment.set(LAYOUT$maxPerStageDescriptorUpdateAfterBindInputAttachments, OFFSET$maxPerStageDescriptorUpdateAfterBindInputAttachments, value);
        return this;
    }

    public @Unsigned int maxPerStageUpdateAfterBindResources() {
        return segment.get(LAYOUT$maxPerStageUpdateAfterBindResources, OFFSET$maxPerStageUpdateAfterBindResources);
    }

    public VkPhysicalDeviceVulkan12Properties maxPerStageUpdateAfterBindResources(@Unsigned int value) {
        segment.set(LAYOUT$maxPerStageUpdateAfterBindResources, OFFSET$maxPerStageUpdateAfterBindResources, value);
        return this;
    }

    public @Unsigned int maxDescriptorSetUpdateAfterBindSamplers() {
        return segment.get(LAYOUT$maxDescriptorSetUpdateAfterBindSamplers, OFFSET$maxDescriptorSetUpdateAfterBindSamplers);
    }

    public VkPhysicalDeviceVulkan12Properties maxDescriptorSetUpdateAfterBindSamplers(@Unsigned int value) {
        segment.set(LAYOUT$maxDescriptorSetUpdateAfterBindSamplers, OFFSET$maxDescriptorSetUpdateAfterBindSamplers, value);
        return this;
    }

    public @Unsigned int maxDescriptorSetUpdateAfterBindUniformBuffers() {
        return segment.get(LAYOUT$maxDescriptorSetUpdateAfterBindUniformBuffers, OFFSET$maxDescriptorSetUpdateAfterBindUniformBuffers);
    }

    public VkPhysicalDeviceVulkan12Properties maxDescriptorSetUpdateAfterBindUniformBuffers(@Unsigned int value) {
        segment.set(LAYOUT$maxDescriptorSetUpdateAfterBindUniformBuffers, OFFSET$maxDescriptorSetUpdateAfterBindUniformBuffers, value);
        return this;
    }

    public @Unsigned int maxDescriptorSetUpdateAfterBindUniformBuffersDynamic() {
        return segment.get(LAYOUT$maxDescriptorSetUpdateAfterBindUniformBuffersDynamic, OFFSET$maxDescriptorSetUpdateAfterBindUniformBuffersDynamic);
    }

    public VkPhysicalDeviceVulkan12Properties maxDescriptorSetUpdateAfterBindUniformBuffersDynamic(@Unsigned int value) {
        segment.set(LAYOUT$maxDescriptorSetUpdateAfterBindUniformBuffersDynamic, OFFSET$maxDescriptorSetUpdateAfterBindUniformBuffersDynamic, value);
        return this;
    }

    public @Unsigned int maxDescriptorSetUpdateAfterBindStorageBuffers() {
        return segment.get(LAYOUT$maxDescriptorSetUpdateAfterBindStorageBuffers, OFFSET$maxDescriptorSetUpdateAfterBindStorageBuffers);
    }

    public VkPhysicalDeviceVulkan12Properties maxDescriptorSetUpdateAfterBindStorageBuffers(@Unsigned int value) {
        segment.set(LAYOUT$maxDescriptorSetUpdateAfterBindStorageBuffers, OFFSET$maxDescriptorSetUpdateAfterBindStorageBuffers, value);
        return this;
    }

    public @Unsigned int maxDescriptorSetUpdateAfterBindStorageBuffersDynamic() {
        return segment.get(LAYOUT$maxDescriptorSetUpdateAfterBindStorageBuffersDynamic, OFFSET$maxDescriptorSetUpdateAfterBindStorageBuffersDynamic);
    }

    public VkPhysicalDeviceVulkan12Properties maxDescriptorSetUpdateAfterBindStorageBuffersDynamic(@Unsigned int value) {
        segment.set(LAYOUT$maxDescriptorSetUpdateAfterBindStorageBuffersDynamic, OFFSET$maxDescriptorSetUpdateAfterBindStorageBuffersDynamic, value);
        return this;
    }

    public @Unsigned int maxDescriptorSetUpdateAfterBindSampledImages() {
        return segment.get(LAYOUT$maxDescriptorSetUpdateAfterBindSampledImages, OFFSET$maxDescriptorSetUpdateAfterBindSampledImages);
    }

    public VkPhysicalDeviceVulkan12Properties maxDescriptorSetUpdateAfterBindSampledImages(@Unsigned int value) {
        segment.set(LAYOUT$maxDescriptorSetUpdateAfterBindSampledImages, OFFSET$maxDescriptorSetUpdateAfterBindSampledImages, value);
        return this;
    }

    public @Unsigned int maxDescriptorSetUpdateAfterBindStorageImages() {
        return segment.get(LAYOUT$maxDescriptorSetUpdateAfterBindStorageImages, OFFSET$maxDescriptorSetUpdateAfterBindStorageImages);
    }

    public VkPhysicalDeviceVulkan12Properties maxDescriptorSetUpdateAfterBindStorageImages(@Unsigned int value) {
        segment.set(LAYOUT$maxDescriptorSetUpdateAfterBindStorageImages, OFFSET$maxDescriptorSetUpdateAfterBindStorageImages, value);
        return this;
    }

    public @Unsigned int maxDescriptorSetUpdateAfterBindInputAttachments() {
        return segment.get(LAYOUT$maxDescriptorSetUpdateAfterBindInputAttachments, OFFSET$maxDescriptorSetUpdateAfterBindInputAttachments);
    }

    public VkPhysicalDeviceVulkan12Properties maxDescriptorSetUpdateAfterBindInputAttachments(@Unsigned int value) {
        segment.set(LAYOUT$maxDescriptorSetUpdateAfterBindInputAttachments, OFFSET$maxDescriptorSetUpdateAfterBindInputAttachments, value);
        return this;
    }

    public @Bitmask(VkResolveModeFlags.class) int supportedDepthResolveModes() {
        return segment.get(LAYOUT$supportedDepthResolveModes, OFFSET$supportedDepthResolveModes);
    }

    public VkPhysicalDeviceVulkan12Properties supportedDepthResolveModes(@Bitmask(VkResolveModeFlags.class) int value) {
        segment.set(LAYOUT$supportedDepthResolveModes, OFFSET$supportedDepthResolveModes, value);
        return this;
    }

    public @Bitmask(VkResolveModeFlags.class) int supportedStencilResolveModes() {
        return segment.get(LAYOUT$supportedStencilResolveModes, OFFSET$supportedStencilResolveModes);
    }

    public VkPhysicalDeviceVulkan12Properties supportedStencilResolveModes(@Bitmask(VkResolveModeFlags.class) int value) {
        segment.set(LAYOUT$supportedStencilResolveModes, OFFSET$supportedStencilResolveModes, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int independentResolveNone() {
        return segment.get(LAYOUT$independentResolveNone, OFFSET$independentResolveNone);
    }

    public VkPhysicalDeviceVulkan12Properties independentResolveNone(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$independentResolveNone, OFFSET$independentResolveNone, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int independentResolve() {
        return segment.get(LAYOUT$independentResolve, OFFSET$independentResolve);
    }

    public VkPhysicalDeviceVulkan12Properties independentResolve(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$independentResolve, OFFSET$independentResolve, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int filterMinmaxSingleComponentFormats() {
        return segment.get(LAYOUT$filterMinmaxSingleComponentFormats, OFFSET$filterMinmaxSingleComponentFormats);
    }

    public VkPhysicalDeviceVulkan12Properties filterMinmaxSingleComponentFormats(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$filterMinmaxSingleComponentFormats, OFFSET$filterMinmaxSingleComponentFormats, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int filterMinmaxImageComponentMapping() {
        return segment.get(LAYOUT$filterMinmaxImageComponentMapping, OFFSET$filterMinmaxImageComponentMapping);
    }

    public VkPhysicalDeviceVulkan12Properties filterMinmaxImageComponentMapping(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$filterMinmaxImageComponentMapping, OFFSET$filterMinmaxImageComponentMapping, value);
        return this;
    }

    public @Unsigned long maxTimelineSemaphoreValueDifference() {
        return segment.get(LAYOUT$maxTimelineSemaphoreValueDifference, OFFSET$maxTimelineSemaphoreValueDifference);
    }

    public VkPhysicalDeviceVulkan12Properties maxTimelineSemaphoreValueDifference(@Unsigned long value) {
        segment.set(LAYOUT$maxTimelineSemaphoreValueDifference, OFFSET$maxTimelineSemaphoreValueDifference, value);
        return this;
    }

    public @Bitmask(VkSampleCountFlags.class) int framebufferIntegerColorSampleCounts() {
        return segment.get(LAYOUT$framebufferIntegerColorSampleCounts, OFFSET$framebufferIntegerColorSampleCounts);
    }

    public VkPhysicalDeviceVulkan12Properties framebufferIntegerColorSampleCounts(@Bitmask(VkSampleCountFlags.class) int value) {
        segment.set(LAYOUT$framebufferIntegerColorSampleCounts, OFFSET$framebufferIntegerColorSampleCounts, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("driverID"),
        MemoryLayout.sequenceLayout(MAX_DRIVER_NAME_SIZE, ValueLayout.JAVA_BYTE).withName("driverName"),
        MemoryLayout.sequenceLayout(MAX_DRIVER_INFO_SIZE, ValueLayout.JAVA_BYTE).withName("driverInfo"),
        VkConformanceVersion.LAYOUT.withName("conformanceVersion"),
        ValueLayout.JAVA_INT.withName("denormBehaviorIndependence"),
        ValueLayout.JAVA_INT.withName("roundingModeIndependence"),
        ValueLayout.JAVA_INT.withName("shaderSignedZeroInfNanPreserveFloat16"),
        ValueLayout.JAVA_INT.withName("shaderSignedZeroInfNanPreserveFloat32"),
        ValueLayout.JAVA_INT.withName("shaderSignedZeroInfNanPreserveFloat64"),
        ValueLayout.JAVA_INT.withName("shaderDenormPreserveFloat16"),
        ValueLayout.JAVA_INT.withName("shaderDenormPreserveFloat32"),
        ValueLayout.JAVA_INT.withName("shaderDenormPreserveFloat64"),
        ValueLayout.JAVA_INT.withName("shaderDenormFlushToZeroFloat16"),
        ValueLayout.JAVA_INT.withName("shaderDenormFlushToZeroFloat32"),
        ValueLayout.JAVA_INT.withName("shaderDenormFlushToZeroFloat64"),
        ValueLayout.JAVA_INT.withName("shaderRoundingModeRTEFloat16"),
        ValueLayout.JAVA_INT.withName("shaderRoundingModeRTEFloat32"),
        ValueLayout.JAVA_INT.withName("shaderRoundingModeRTEFloat64"),
        ValueLayout.JAVA_INT.withName("shaderRoundingModeRTZFloat16"),
        ValueLayout.JAVA_INT.withName("shaderRoundingModeRTZFloat32"),
        ValueLayout.JAVA_INT.withName("shaderRoundingModeRTZFloat64"),
        ValueLayout.JAVA_INT.withName("maxUpdateAfterBindDescriptorsInAllPools"),
        ValueLayout.JAVA_INT.withName("shaderUniformBufferArrayNonUniformIndexingNative"),
        ValueLayout.JAVA_INT.withName("shaderSampledImageArrayNonUniformIndexingNative"),
        ValueLayout.JAVA_INT.withName("shaderStorageBufferArrayNonUniformIndexingNative"),
        ValueLayout.JAVA_INT.withName("shaderStorageImageArrayNonUniformIndexingNative"),
        ValueLayout.JAVA_INT.withName("shaderInputAttachmentArrayNonUniformIndexingNative"),
        ValueLayout.JAVA_INT.withName("robustBufferAccessUpdateAfterBind"),
        ValueLayout.JAVA_INT.withName("quadDivergentImplicitLod"),
        ValueLayout.JAVA_INT.withName("maxPerStageDescriptorUpdateAfterBindSamplers"),
        ValueLayout.JAVA_INT.withName("maxPerStageDescriptorUpdateAfterBindUniformBuffers"),
        ValueLayout.JAVA_INT.withName("maxPerStageDescriptorUpdateAfterBindStorageBuffers"),
        ValueLayout.JAVA_INT.withName("maxPerStageDescriptorUpdateAfterBindSampledImages"),
        ValueLayout.JAVA_INT.withName("maxPerStageDescriptorUpdateAfterBindStorageImages"),
        ValueLayout.JAVA_INT.withName("maxPerStageDescriptorUpdateAfterBindInputAttachments"),
        ValueLayout.JAVA_INT.withName("maxPerStageUpdateAfterBindResources"),
        ValueLayout.JAVA_INT.withName("maxDescriptorSetUpdateAfterBindSamplers"),
        ValueLayout.JAVA_INT.withName("maxDescriptorSetUpdateAfterBindUniformBuffers"),
        ValueLayout.JAVA_INT.withName("maxDescriptorSetUpdateAfterBindUniformBuffersDynamic"),
        ValueLayout.JAVA_INT.withName("maxDescriptorSetUpdateAfterBindStorageBuffers"),
        ValueLayout.JAVA_INT.withName("maxDescriptorSetUpdateAfterBindStorageBuffersDynamic"),
        ValueLayout.JAVA_INT.withName("maxDescriptorSetUpdateAfterBindSampledImages"),
        ValueLayout.JAVA_INT.withName("maxDescriptorSetUpdateAfterBindStorageImages"),
        ValueLayout.JAVA_INT.withName("maxDescriptorSetUpdateAfterBindInputAttachments"),
        ValueLayout.JAVA_INT.withName("supportedDepthResolveModes"),
        ValueLayout.JAVA_INT.withName("supportedStencilResolveModes"),
        ValueLayout.JAVA_INT.withName("independentResolveNone"),
        ValueLayout.JAVA_INT.withName("independentResolve"),
        ValueLayout.JAVA_INT.withName("filterMinmaxSingleComponentFormats"),
        ValueLayout.JAVA_INT.withName("filterMinmaxImageComponentMapping"),
        ValueLayout.JAVA_LONG.withName("maxTimelineSemaphoreValueDifference"),
        ValueLayout.JAVA_INT.withName("framebufferIntegerColorSampleCounts")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$driverID = PathElement.groupElement("driverID");
    public static final PathElement PATH$driverName = PathElement.groupElement("driverName");
    public static final PathElement PATH$driverInfo = PathElement.groupElement("driverInfo");
    public static final PathElement PATH$conformanceVersion = PathElement.groupElement("conformanceVersion");
    public static final PathElement PATH$denormBehaviorIndependence = PathElement.groupElement("denormBehaviorIndependence");
    public static final PathElement PATH$roundingModeIndependence = PathElement.groupElement("roundingModeIndependence");
    public static final PathElement PATH$shaderSignedZeroInfNanPreserveFloat16 = PathElement.groupElement("shaderSignedZeroInfNanPreserveFloat16");
    public static final PathElement PATH$shaderSignedZeroInfNanPreserveFloat32 = PathElement.groupElement("shaderSignedZeroInfNanPreserveFloat32");
    public static final PathElement PATH$shaderSignedZeroInfNanPreserveFloat64 = PathElement.groupElement("shaderSignedZeroInfNanPreserveFloat64");
    public static final PathElement PATH$shaderDenormPreserveFloat16 = PathElement.groupElement("shaderDenormPreserveFloat16");
    public static final PathElement PATH$shaderDenormPreserveFloat32 = PathElement.groupElement("shaderDenormPreserveFloat32");
    public static final PathElement PATH$shaderDenormPreserveFloat64 = PathElement.groupElement("shaderDenormPreserveFloat64");
    public static final PathElement PATH$shaderDenormFlushToZeroFloat16 = PathElement.groupElement("shaderDenormFlushToZeroFloat16");
    public static final PathElement PATH$shaderDenormFlushToZeroFloat32 = PathElement.groupElement("shaderDenormFlushToZeroFloat32");
    public static final PathElement PATH$shaderDenormFlushToZeroFloat64 = PathElement.groupElement("shaderDenormFlushToZeroFloat64");
    public static final PathElement PATH$shaderRoundingModeRTEFloat16 = PathElement.groupElement("shaderRoundingModeRTEFloat16");
    public static final PathElement PATH$shaderRoundingModeRTEFloat32 = PathElement.groupElement("shaderRoundingModeRTEFloat32");
    public static final PathElement PATH$shaderRoundingModeRTEFloat64 = PathElement.groupElement("shaderRoundingModeRTEFloat64");
    public static final PathElement PATH$shaderRoundingModeRTZFloat16 = PathElement.groupElement("shaderRoundingModeRTZFloat16");
    public static final PathElement PATH$shaderRoundingModeRTZFloat32 = PathElement.groupElement("shaderRoundingModeRTZFloat32");
    public static final PathElement PATH$shaderRoundingModeRTZFloat64 = PathElement.groupElement("shaderRoundingModeRTZFloat64");
    public static final PathElement PATH$maxUpdateAfterBindDescriptorsInAllPools = PathElement.groupElement("maxUpdateAfterBindDescriptorsInAllPools");
    public static final PathElement PATH$shaderUniformBufferArrayNonUniformIndexingNative = PathElement.groupElement("shaderUniformBufferArrayNonUniformIndexingNative");
    public static final PathElement PATH$shaderSampledImageArrayNonUniformIndexingNative = PathElement.groupElement("shaderSampledImageArrayNonUniformIndexingNative");
    public static final PathElement PATH$shaderStorageBufferArrayNonUniformIndexingNative = PathElement.groupElement("shaderStorageBufferArrayNonUniformIndexingNative");
    public static final PathElement PATH$shaderStorageImageArrayNonUniformIndexingNative = PathElement.groupElement("shaderStorageImageArrayNonUniformIndexingNative");
    public static final PathElement PATH$shaderInputAttachmentArrayNonUniformIndexingNative = PathElement.groupElement("shaderInputAttachmentArrayNonUniformIndexingNative");
    public static final PathElement PATH$robustBufferAccessUpdateAfterBind = PathElement.groupElement("robustBufferAccessUpdateAfterBind");
    public static final PathElement PATH$quadDivergentImplicitLod = PathElement.groupElement("quadDivergentImplicitLod");
    public static final PathElement PATH$maxPerStageDescriptorUpdateAfterBindSamplers = PathElement.groupElement("maxPerStageDescriptorUpdateAfterBindSamplers");
    public static final PathElement PATH$maxPerStageDescriptorUpdateAfterBindUniformBuffers = PathElement.groupElement("maxPerStageDescriptorUpdateAfterBindUniformBuffers");
    public static final PathElement PATH$maxPerStageDescriptorUpdateAfterBindStorageBuffers = PathElement.groupElement("maxPerStageDescriptorUpdateAfterBindStorageBuffers");
    public static final PathElement PATH$maxPerStageDescriptorUpdateAfterBindSampledImages = PathElement.groupElement("maxPerStageDescriptorUpdateAfterBindSampledImages");
    public static final PathElement PATH$maxPerStageDescriptorUpdateAfterBindStorageImages = PathElement.groupElement("maxPerStageDescriptorUpdateAfterBindStorageImages");
    public static final PathElement PATH$maxPerStageDescriptorUpdateAfterBindInputAttachments = PathElement.groupElement("maxPerStageDescriptorUpdateAfterBindInputAttachments");
    public static final PathElement PATH$maxPerStageUpdateAfterBindResources = PathElement.groupElement("maxPerStageUpdateAfterBindResources");
    public static final PathElement PATH$maxDescriptorSetUpdateAfterBindSamplers = PathElement.groupElement("maxDescriptorSetUpdateAfterBindSamplers");
    public static final PathElement PATH$maxDescriptorSetUpdateAfterBindUniformBuffers = PathElement.groupElement("maxDescriptorSetUpdateAfterBindUniformBuffers");
    public static final PathElement PATH$maxDescriptorSetUpdateAfterBindUniformBuffersDynamic = PathElement.groupElement("maxDescriptorSetUpdateAfterBindUniformBuffersDynamic");
    public static final PathElement PATH$maxDescriptorSetUpdateAfterBindStorageBuffers = PathElement.groupElement("maxDescriptorSetUpdateAfterBindStorageBuffers");
    public static final PathElement PATH$maxDescriptorSetUpdateAfterBindStorageBuffersDynamic = PathElement.groupElement("maxDescriptorSetUpdateAfterBindStorageBuffersDynamic");
    public static final PathElement PATH$maxDescriptorSetUpdateAfterBindSampledImages = PathElement.groupElement("maxDescriptorSetUpdateAfterBindSampledImages");
    public static final PathElement PATH$maxDescriptorSetUpdateAfterBindStorageImages = PathElement.groupElement("maxDescriptorSetUpdateAfterBindStorageImages");
    public static final PathElement PATH$maxDescriptorSetUpdateAfterBindInputAttachments = PathElement.groupElement("maxDescriptorSetUpdateAfterBindInputAttachments");
    public static final PathElement PATH$supportedDepthResolveModes = PathElement.groupElement("supportedDepthResolveModes");
    public static final PathElement PATH$supportedStencilResolveModes = PathElement.groupElement("supportedStencilResolveModes");
    public static final PathElement PATH$independentResolveNone = PathElement.groupElement("independentResolveNone");
    public static final PathElement PATH$independentResolve = PathElement.groupElement("independentResolve");
    public static final PathElement PATH$filterMinmaxSingleComponentFormats = PathElement.groupElement("filterMinmaxSingleComponentFormats");
    public static final PathElement PATH$filterMinmaxImageComponentMapping = PathElement.groupElement("filterMinmaxImageComponentMapping");
    public static final PathElement PATH$maxTimelineSemaphoreValueDifference = PathElement.groupElement("maxTimelineSemaphoreValueDifference");
    public static final PathElement PATH$framebufferIntegerColorSampleCounts = PathElement.groupElement("framebufferIntegerColorSampleCounts");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$driverID = (OfInt) LAYOUT.select(PATH$driverID);
    public static final SequenceLayout LAYOUT$driverName = (SequenceLayout) LAYOUT.select(PATH$driverName);
    public static final SequenceLayout LAYOUT$driverInfo = (SequenceLayout) LAYOUT.select(PATH$driverInfo);
    public static final StructLayout LAYOUT$conformanceVersion = (StructLayout) LAYOUT.select(PATH$conformanceVersion);
    public static final OfInt LAYOUT$denormBehaviorIndependence = (OfInt) LAYOUT.select(PATH$denormBehaviorIndependence);
    public static final OfInt LAYOUT$roundingModeIndependence = (OfInt) LAYOUT.select(PATH$roundingModeIndependence);
    public static final OfInt LAYOUT$shaderSignedZeroInfNanPreserveFloat16 = (OfInt) LAYOUT.select(PATH$shaderSignedZeroInfNanPreserveFloat16);
    public static final OfInt LAYOUT$shaderSignedZeroInfNanPreserveFloat32 = (OfInt) LAYOUT.select(PATH$shaderSignedZeroInfNanPreserveFloat32);
    public static final OfInt LAYOUT$shaderSignedZeroInfNanPreserveFloat64 = (OfInt) LAYOUT.select(PATH$shaderSignedZeroInfNanPreserveFloat64);
    public static final OfInt LAYOUT$shaderDenormPreserveFloat16 = (OfInt) LAYOUT.select(PATH$shaderDenormPreserveFloat16);
    public static final OfInt LAYOUT$shaderDenormPreserveFloat32 = (OfInt) LAYOUT.select(PATH$shaderDenormPreserveFloat32);
    public static final OfInt LAYOUT$shaderDenormPreserveFloat64 = (OfInt) LAYOUT.select(PATH$shaderDenormPreserveFloat64);
    public static final OfInt LAYOUT$shaderDenormFlushToZeroFloat16 = (OfInt) LAYOUT.select(PATH$shaderDenormFlushToZeroFloat16);
    public static final OfInt LAYOUT$shaderDenormFlushToZeroFloat32 = (OfInt) LAYOUT.select(PATH$shaderDenormFlushToZeroFloat32);
    public static final OfInt LAYOUT$shaderDenormFlushToZeroFloat64 = (OfInt) LAYOUT.select(PATH$shaderDenormFlushToZeroFloat64);
    public static final OfInt LAYOUT$shaderRoundingModeRTEFloat16 = (OfInt) LAYOUT.select(PATH$shaderRoundingModeRTEFloat16);
    public static final OfInt LAYOUT$shaderRoundingModeRTEFloat32 = (OfInt) LAYOUT.select(PATH$shaderRoundingModeRTEFloat32);
    public static final OfInt LAYOUT$shaderRoundingModeRTEFloat64 = (OfInt) LAYOUT.select(PATH$shaderRoundingModeRTEFloat64);
    public static final OfInt LAYOUT$shaderRoundingModeRTZFloat16 = (OfInt) LAYOUT.select(PATH$shaderRoundingModeRTZFloat16);
    public static final OfInt LAYOUT$shaderRoundingModeRTZFloat32 = (OfInt) LAYOUT.select(PATH$shaderRoundingModeRTZFloat32);
    public static final OfInt LAYOUT$shaderRoundingModeRTZFloat64 = (OfInt) LAYOUT.select(PATH$shaderRoundingModeRTZFloat64);
    public static final OfInt LAYOUT$maxUpdateAfterBindDescriptorsInAllPools = (OfInt) LAYOUT.select(PATH$maxUpdateAfterBindDescriptorsInAllPools);
    public static final OfInt LAYOUT$shaderUniformBufferArrayNonUniformIndexingNative = (OfInt) LAYOUT.select(PATH$shaderUniformBufferArrayNonUniformIndexingNative);
    public static final OfInt LAYOUT$shaderSampledImageArrayNonUniformIndexingNative = (OfInt) LAYOUT.select(PATH$shaderSampledImageArrayNonUniformIndexingNative);
    public static final OfInt LAYOUT$shaderStorageBufferArrayNonUniformIndexingNative = (OfInt) LAYOUT.select(PATH$shaderStorageBufferArrayNonUniformIndexingNative);
    public static final OfInt LAYOUT$shaderStorageImageArrayNonUniformIndexingNative = (OfInt) LAYOUT.select(PATH$shaderStorageImageArrayNonUniformIndexingNative);
    public static final OfInt LAYOUT$shaderInputAttachmentArrayNonUniformIndexingNative = (OfInt) LAYOUT.select(PATH$shaderInputAttachmentArrayNonUniformIndexingNative);
    public static final OfInt LAYOUT$robustBufferAccessUpdateAfterBind = (OfInt) LAYOUT.select(PATH$robustBufferAccessUpdateAfterBind);
    public static final OfInt LAYOUT$quadDivergentImplicitLod = (OfInt) LAYOUT.select(PATH$quadDivergentImplicitLod);
    public static final OfInt LAYOUT$maxPerStageDescriptorUpdateAfterBindSamplers = (OfInt) LAYOUT.select(PATH$maxPerStageDescriptorUpdateAfterBindSamplers);
    public static final OfInt LAYOUT$maxPerStageDescriptorUpdateAfterBindUniformBuffers = (OfInt) LAYOUT.select(PATH$maxPerStageDescriptorUpdateAfterBindUniformBuffers);
    public static final OfInt LAYOUT$maxPerStageDescriptorUpdateAfterBindStorageBuffers = (OfInt) LAYOUT.select(PATH$maxPerStageDescriptorUpdateAfterBindStorageBuffers);
    public static final OfInt LAYOUT$maxPerStageDescriptorUpdateAfterBindSampledImages = (OfInt) LAYOUT.select(PATH$maxPerStageDescriptorUpdateAfterBindSampledImages);
    public static final OfInt LAYOUT$maxPerStageDescriptorUpdateAfterBindStorageImages = (OfInt) LAYOUT.select(PATH$maxPerStageDescriptorUpdateAfterBindStorageImages);
    public static final OfInt LAYOUT$maxPerStageDescriptorUpdateAfterBindInputAttachments = (OfInt) LAYOUT.select(PATH$maxPerStageDescriptorUpdateAfterBindInputAttachments);
    public static final OfInt LAYOUT$maxPerStageUpdateAfterBindResources = (OfInt) LAYOUT.select(PATH$maxPerStageUpdateAfterBindResources);
    public static final OfInt LAYOUT$maxDescriptorSetUpdateAfterBindSamplers = (OfInt) LAYOUT.select(PATH$maxDescriptorSetUpdateAfterBindSamplers);
    public static final OfInt LAYOUT$maxDescriptorSetUpdateAfterBindUniformBuffers = (OfInt) LAYOUT.select(PATH$maxDescriptorSetUpdateAfterBindUniformBuffers);
    public static final OfInt LAYOUT$maxDescriptorSetUpdateAfterBindUniformBuffersDynamic = (OfInt) LAYOUT.select(PATH$maxDescriptorSetUpdateAfterBindUniformBuffersDynamic);
    public static final OfInt LAYOUT$maxDescriptorSetUpdateAfterBindStorageBuffers = (OfInt) LAYOUT.select(PATH$maxDescriptorSetUpdateAfterBindStorageBuffers);
    public static final OfInt LAYOUT$maxDescriptorSetUpdateAfterBindStorageBuffersDynamic = (OfInt) LAYOUT.select(PATH$maxDescriptorSetUpdateAfterBindStorageBuffersDynamic);
    public static final OfInt LAYOUT$maxDescriptorSetUpdateAfterBindSampledImages = (OfInt) LAYOUT.select(PATH$maxDescriptorSetUpdateAfterBindSampledImages);
    public static final OfInt LAYOUT$maxDescriptorSetUpdateAfterBindStorageImages = (OfInt) LAYOUT.select(PATH$maxDescriptorSetUpdateAfterBindStorageImages);
    public static final OfInt LAYOUT$maxDescriptorSetUpdateAfterBindInputAttachments = (OfInt) LAYOUT.select(PATH$maxDescriptorSetUpdateAfterBindInputAttachments);
    public static final OfInt LAYOUT$supportedDepthResolveModes = (OfInt) LAYOUT.select(PATH$supportedDepthResolveModes);
    public static final OfInt LAYOUT$supportedStencilResolveModes = (OfInt) LAYOUT.select(PATH$supportedStencilResolveModes);
    public static final OfInt LAYOUT$independentResolveNone = (OfInt) LAYOUT.select(PATH$independentResolveNone);
    public static final OfInt LAYOUT$independentResolve = (OfInt) LAYOUT.select(PATH$independentResolve);
    public static final OfInt LAYOUT$filterMinmaxSingleComponentFormats = (OfInt) LAYOUT.select(PATH$filterMinmaxSingleComponentFormats);
    public static final OfInt LAYOUT$filterMinmaxImageComponentMapping = (OfInt) LAYOUT.select(PATH$filterMinmaxImageComponentMapping);
    public static final OfLong LAYOUT$maxTimelineSemaphoreValueDifference = (OfLong) LAYOUT.select(PATH$maxTimelineSemaphoreValueDifference);
    public static final OfInt LAYOUT$framebufferIntegerColorSampleCounts = (OfInt) LAYOUT.select(PATH$framebufferIntegerColorSampleCounts);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$driverID = LAYOUT$driverID.byteSize();
    public static final long SIZE$driverName = LAYOUT$driverName.byteSize();
    public static final long SIZE$driverInfo = LAYOUT$driverInfo.byteSize();
    public static final long SIZE$conformanceVersion = LAYOUT$conformanceVersion.byteSize();
    public static final long SIZE$denormBehaviorIndependence = LAYOUT$denormBehaviorIndependence.byteSize();
    public static final long SIZE$roundingModeIndependence = LAYOUT$roundingModeIndependence.byteSize();
    public static final long SIZE$shaderSignedZeroInfNanPreserveFloat16 = LAYOUT$shaderSignedZeroInfNanPreserveFloat16.byteSize();
    public static final long SIZE$shaderSignedZeroInfNanPreserveFloat32 = LAYOUT$shaderSignedZeroInfNanPreserveFloat32.byteSize();
    public static final long SIZE$shaderSignedZeroInfNanPreserveFloat64 = LAYOUT$shaderSignedZeroInfNanPreserveFloat64.byteSize();
    public static final long SIZE$shaderDenormPreserveFloat16 = LAYOUT$shaderDenormPreserveFloat16.byteSize();
    public static final long SIZE$shaderDenormPreserveFloat32 = LAYOUT$shaderDenormPreserveFloat32.byteSize();
    public static final long SIZE$shaderDenormPreserveFloat64 = LAYOUT$shaderDenormPreserveFloat64.byteSize();
    public static final long SIZE$shaderDenormFlushToZeroFloat16 = LAYOUT$shaderDenormFlushToZeroFloat16.byteSize();
    public static final long SIZE$shaderDenormFlushToZeroFloat32 = LAYOUT$shaderDenormFlushToZeroFloat32.byteSize();
    public static final long SIZE$shaderDenormFlushToZeroFloat64 = LAYOUT$shaderDenormFlushToZeroFloat64.byteSize();
    public static final long SIZE$shaderRoundingModeRTEFloat16 = LAYOUT$shaderRoundingModeRTEFloat16.byteSize();
    public static final long SIZE$shaderRoundingModeRTEFloat32 = LAYOUT$shaderRoundingModeRTEFloat32.byteSize();
    public static final long SIZE$shaderRoundingModeRTEFloat64 = LAYOUT$shaderRoundingModeRTEFloat64.byteSize();
    public static final long SIZE$shaderRoundingModeRTZFloat16 = LAYOUT$shaderRoundingModeRTZFloat16.byteSize();
    public static final long SIZE$shaderRoundingModeRTZFloat32 = LAYOUT$shaderRoundingModeRTZFloat32.byteSize();
    public static final long SIZE$shaderRoundingModeRTZFloat64 = LAYOUT$shaderRoundingModeRTZFloat64.byteSize();
    public static final long SIZE$maxUpdateAfterBindDescriptorsInAllPools = LAYOUT$maxUpdateAfterBindDescriptorsInAllPools.byteSize();
    public static final long SIZE$shaderUniformBufferArrayNonUniformIndexingNative = LAYOUT$shaderUniformBufferArrayNonUniformIndexingNative.byteSize();
    public static final long SIZE$shaderSampledImageArrayNonUniformIndexingNative = LAYOUT$shaderSampledImageArrayNonUniformIndexingNative.byteSize();
    public static final long SIZE$shaderStorageBufferArrayNonUniformIndexingNative = LAYOUT$shaderStorageBufferArrayNonUniformIndexingNative.byteSize();
    public static final long SIZE$shaderStorageImageArrayNonUniformIndexingNative = LAYOUT$shaderStorageImageArrayNonUniformIndexingNative.byteSize();
    public static final long SIZE$shaderInputAttachmentArrayNonUniformIndexingNative = LAYOUT$shaderInputAttachmentArrayNonUniformIndexingNative.byteSize();
    public static final long SIZE$robustBufferAccessUpdateAfterBind = LAYOUT$robustBufferAccessUpdateAfterBind.byteSize();
    public static final long SIZE$quadDivergentImplicitLod = LAYOUT$quadDivergentImplicitLod.byteSize();
    public static final long SIZE$maxPerStageDescriptorUpdateAfterBindSamplers = LAYOUT$maxPerStageDescriptorUpdateAfterBindSamplers.byteSize();
    public static final long SIZE$maxPerStageDescriptorUpdateAfterBindUniformBuffers = LAYOUT$maxPerStageDescriptorUpdateAfterBindUniformBuffers.byteSize();
    public static final long SIZE$maxPerStageDescriptorUpdateAfterBindStorageBuffers = LAYOUT$maxPerStageDescriptorUpdateAfterBindStorageBuffers.byteSize();
    public static final long SIZE$maxPerStageDescriptorUpdateAfterBindSampledImages = LAYOUT$maxPerStageDescriptorUpdateAfterBindSampledImages.byteSize();
    public static final long SIZE$maxPerStageDescriptorUpdateAfterBindStorageImages = LAYOUT$maxPerStageDescriptorUpdateAfterBindStorageImages.byteSize();
    public static final long SIZE$maxPerStageDescriptorUpdateAfterBindInputAttachments = LAYOUT$maxPerStageDescriptorUpdateAfterBindInputAttachments.byteSize();
    public static final long SIZE$maxPerStageUpdateAfterBindResources = LAYOUT$maxPerStageUpdateAfterBindResources.byteSize();
    public static final long SIZE$maxDescriptorSetUpdateAfterBindSamplers = LAYOUT$maxDescriptorSetUpdateAfterBindSamplers.byteSize();
    public static final long SIZE$maxDescriptorSetUpdateAfterBindUniformBuffers = LAYOUT$maxDescriptorSetUpdateAfterBindUniformBuffers.byteSize();
    public static final long SIZE$maxDescriptorSetUpdateAfterBindUniformBuffersDynamic = LAYOUT$maxDescriptorSetUpdateAfterBindUniformBuffersDynamic.byteSize();
    public static final long SIZE$maxDescriptorSetUpdateAfterBindStorageBuffers = LAYOUT$maxDescriptorSetUpdateAfterBindStorageBuffers.byteSize();
    public static final long SIZE$maxDescriptorSetUpdateAfterBindStorageBuffersDynamic = LAYOUT$maxDescriptorSetUpdateAfterBindStorageBuffersDynamic.byteSize();
    public static final long SIZE$maxDescriptorSetUpdateAfterBindSampledImages = LAYOUT$maxDescriptorSetUpdateAfterBindSampledImages.byteSize();
    public static final long SIZE$maxDescriptorSetUpdateAfterBindStorageImages = LAYOUT$maxDescriptorSetUpdateAfterBindStorageImages.byteSize();
    public static final long SIZE$maxDescriptorSetUpdateAfterBindInputAttachments = LAYOUT$maxDescriptorSetUpdateAfterBindInputAttachments.byteSize();
    public static final long SIZE$supportedDepthResolveModes = LAYOUT$supportedDepthResolveModes.byteSize();
    public static final long SIZE$supportedStencilResolveModes = LAYOUT$supportedStencilResolveModes.byteSize();
    public static final long SIZE$independentResolveNone = LAYOUT$independentResolveNone.byteSize();
    public static final long SIZE$independentResolve = LAYOUT$independentResolve.byteSize();
    public static final long SIZE$filterMinmaxSingleComponentFormats = LAYOUT$filterMinmaxSingleComponentFormats.byteSize();
    public static final long SIZE$filterMinmaxImageComponentMapping = LAYOUT$filterMinmaxImageComponentMapping.byteSize();
    public static final long SIZE$maxTimelineSemaphoreValueDifference = LAYOUT$maxTimelineSemaphoreValueDifference.byteSize();
    public static final long SIZE$framebufferIntegerColorSampleCounts = LAYOUT$framebufferIntegerColorSampleCounts.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$driverID = LAYOUT.byteOffset(PATH$driverID);
    public static final long OFFSET$driverName = LAYOUT.byteOffset(PATH$driverName);
    public static final long OFFSET$driverInfo = LAYOUT.byteOffset(PATH$driverInfo);
    public static final long OFFSET$conformanceVersion = LAYOUT.byteOffset(PATH$conformanceVersion);
    public static final long OFFSET$denormBehaviorIndependence = LAYOUT.byteOffset(PATH$denormBehaviorIndependence);
    public static final long OFFSET$roundingModeIndependence = LAYOUT.byteOffset(PATH$roundingModeIndependence);
    public static final long OFFSET$shaderSignedZeroInfNanPreserveFloat16 = LAYOUT.byteOffset(PATH$shaderSignedZeroInfNanPreserveFloat16);
    public static final long OFFSET$shaderSignedZeroInfNanPreserveFloat32 = LAYOUT.byteOffset(PATH$shaderSignedZeroInfNanPreserveFloat32);
    public static final long OFFSET$shaderSignedZeroInfNanPreserveFloat64 = LAYOUT.byteOffset(PATH$shaderSignedZeroInfNanPreserveFloat64);
    public static final long OFFSET$shaderDenormPreserveFloat16 = LAYOUT.byteOffset(PATH$shaderDenormPreserveFloat16);
    public static final long OFFSET$shaderDenormPreserveFloat32 = LAYOUT.byteOffset(PATH$shaderDenormPreserveFloat32);
    public static final long OFFSET$shaderDenormPreserveFloat64 = LAYOUT.byteOffset(PATH$shaderDenormPreserveFloat64);
    public static final long OFFSET$shaderDenormFlushToZeroFloat16 = LAYOUT.byteOffset(PATH$shaderDenormFlushToZeroFloat16);
    public static final long OFFSET$shaderDenormFlushToZeroFloat32 = LAYOUT.byteOffset(PATH$shaderDenormFlushToZeroFloat32);
    public static final long OFFSET$shaderDenormFlushToZeroFloat64 = LAYOUT.byteOffset(PATH$shaderDenormFlushToZeroFloat64);
    public static final long OFFSET$shaderRoundingModeRTEFloat16 = LAYOUT.byteOffset(PATH$shaderRoundingModeRTEFloat16);
    public static final long OFFSET$shaderRoundingModeRTEFloat32 = LAYOUT.byteOffset(PATH$shaderRoundingModeRTEFloat32);
    public static final long OFFSET$shaderRoundingModeRTEFloat64 = LAYOUT.byteOffset(PATH$shaderRoundingModeRTEFloat64);
    public static final long OFFSET$shaderRoundingModeRTZFloat16 = LAYOUT.byteOffset(PATH$shaderRoundingModeRTZFloat16);
    public static final long OFFSET$shaderRoundingModeRTZFloat32 = LAYOUT.byteOffset(PATH$shaderRoundingModeRTZFloat32);
    public static final long OFFSET$shaderRoundingModeRTZFloat64 = LAYOUT.byteOffset(PATH$shaderRoundingModeRTZFloat64);
    public static final long OFFSET$maxUpdateAfterBindDescriptorsInAllPools = LAYOUT.byteOffset(PATH$maxUpdateAfterBindDescriptorsInAllPools);
    public static final long OFFSET$shaderUniformBufferArrayNonUniformIndexingNative = LAYOUT.byteOffset(PATH$shaderUniformBufferArrayNonUniformIndexingNative);
    public static final long OFFSET$shaderSampledImageArrayNonUniformIndexingNative = LAYOUT.byteOffset(PATH$shaderSampledImageArrayNonUniformIndexingNative);
    public static final long OFFSET$shaderStorageBufferArrayNonUniformIndexingNative = LAYOUT.byteOffset(PATH$shaderStorageBufferArrayNonUniformIndexingNative);
    public static final long OFFSET$shaderStorageImageArrayNonUniformIndexingNative = LAYOUT.byteOffset(PATH$shaderStorageImageArrayNonUniformIndexingNative);
    public static final long OFFSET$shaderInputAttachmentArrayNonUniformIndexingNative = LAYOUT.byteOffset(PATH$shaderInputAttachmentArrayNonUniformIndexingNative);
    public static final long OFFSET$robustBufferAccessUpdateAfterBind = LAYOUT.byteOffset(PATH$robustBufferAccessUpdateAfterBind);
    public static final long OFFSET$quadDivergentImplicitLod = LAYOUT.byteOffset(PATH$quadDivergentImplicitLod);
    public static final long OFFSET$maxPerStageDescriptorUpdateAfterBindSamplers = LAYOUT.byteOffset(PATH$maxPerStageDescriptorUpdateAfterBindSamplers);
    public static final long OFFSET$maxPerStageDescriptorUpdateAfterBindUniformBuffers = LAYOUT.byteOffset(PATH$maxPerStageDescriptorUpdateAfterBindUniformBuffers);
    public static final long OFFSET$maxPerStageDescriptorUpdateAfterBindStorageBuffers = LAYOUT.byteOffset(PATH$maxPerStageDescriptorUpdateAfterBindStorageBuffers);
    public static final long OFFSET$maxPerStageDescriptorUpdateAfterBindSampledImages = LAYOUT.byteOffset(PATH$maxPerStageDescriptorUpdateAfterBindSampledImages);
    public static final long OFFSET$maxPerStageDescriptorUpdateAfterBindStorageImages = LAYOUT.byteOffset(PATH$maxPerStageDescriptorUpdateAfterBindStorageImages);
    public static final long OFFSET$maxPerStageDescriptorUpdateAfterBindInputAttachments = LAYOUT.byteOffset(PATH$maxPerStageDescriptorUpdateAfterBindInputAttachments);
    public static final long OFFSET$maxPerStageUpdateAfterBindResources = LAYOUT.byteOffset(PATH$maxPerStageUpdateAfterBindResources);
    public static final long OFFSET$maxDescriptorSetUpdateAfterBindSamplers = LAYOUT.byteOffset(PATH$maxDescriptorSetUpdateAfterBindSamplers);
    public static final long OFFSET$maxDescriptorSetUpdateAfterBindUniformBuffers = LAYOUT.byteOffset(PATH$maxDescriptorSetUpdateAfterBindUniformBuffers);
    public static final long OFFSET$maxDescriptorSetUpdateAfterBindUniformBuffersDynamic = LAYOUT.byteOffset(PATH$maxDescriptorSetUpdateAfterBindUniformBuffersDynamic);
    public static final long OFFSET$maxDescriptorSetUpdateAfterBindStorageBuffers = LAYOUT.byteOffset(PATH$maxDescriptorSetUpdateAfterBindStorageBuffers);
    public static final long OFFSET$maxDescriptorSetUpdateAfterBindStorageBuffersDynamic = LAYOUT.byteOffset(PATH$maxDescriptorSetUpdateAfterBindStorageBuffersDynamic);
    public static final long OFFSET$maxDescriptorSetUpdateAfterBindSampledImages = LAYOUT.byteOffset(PATH$maxDescriptorSetUpdateAfterBindSampledImages);
    public static final long OFFSET$maxDescriptorSetUpdateAfterBindStorageImages = LAYOUT.byteOffset(PATH$maxDescriptorSetUpdateAfterBindStorageImages);
    public static final long OFFSET$maxDescriptorSetUpdateAfterBindInputAttachments = LAYOUT.byteOffset(PATH$maxDescriptorSetUpdateAfterBindInputAttachments);
    public static final long OFFSET$supportedDepthResolveModes = LAYOUT.byteOffset(PATH$supportedDepthResolveModes);
    public static final long OFFSET$supportedStencilResolveModes = LAYOUT.byteOffset(PATH$supportedStencilResolveModes);
    public static final long OFFSET$independentResolveNone = LAYOUT.byteOffset(PATH$independentResolveNone);
    public static final long OFFSET$independentResolve = LAYOUT.byteOffset(PATH$independentResolve);
    public static final long OFFSET$filterMinmaxSingleComponentFormats = LAYOUT.byteOffset(PATH$filterMinmaxSingleComponentFormats);
    public static final long OFFSET$filterMinmaxImageComponentMapping = LAYOUT.byteOffset(PATH$filterMinmaxImageComponentMapping);
    public static final long OFFSET$maxTimelineSemaphoreValueDifference = LAYOUT.byteOffset(PATH$maxTimelineSemaphoreValueDifference);
    public static final long OFFSET$framebufferIntegerColorSampleCounts = LAYOUT.byteOffset(PATH$framebufferIntegerColorSampleCounts);
}
