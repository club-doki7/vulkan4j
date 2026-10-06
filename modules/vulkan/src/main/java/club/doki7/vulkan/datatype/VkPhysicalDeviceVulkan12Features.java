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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceVulkan12Features.html"><code>VkPhysicalDeviceVulkan12Features</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceVulkan12Features {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 samplerMirrorClampToEdge; // @link substring="samplerMirrorClampToEdge" target="#samplerMirrorClampToEdge"
///     VkBool32 drawIndirectCount; // @link substring="drawIndirectCount" target="#drawIndirectCount"
///     VkBool32 storageBuffer8BitAccess; // @link substring="storageBuffer8BitAccess" target="#storageBuffer8BitAccess"
///     VkBool32 uniformAndStorageBuffer8BitAccess; // @link substring="uniformAndStorageBuffer8BitAccess" target="#uniformAndStorageBuffer8BitAccess"
///     VkBool32 storagePushConstant8; // @link substring="storagePushConstant8" target="#storagePushConstant8"
///     VkBool32 shaderBufferInt64Atomics; // @link substring="shaderBufferInt64Atomics" target="#shaderBufferInt64Atomics"
///     VkBool32 shaderSharedInt64Atomics; // @link substring="shaderSharedInt64Atomics" target="#shaderSharedInt64Atomics"
///     VkBool32 shaderFloat16; // @link substring="shaderFloat16" target="#shaderFloat16"
///     VkBool32 shaderInt8; // @link substring="shaderInt8" target="#shaderInt8"
///     VkBool32 descriptorIndexing; // @link substring="descriptorIndexing" target="#descriptorIndexing"
///     VkBool32 shaderInputAttachmentArrayDynamicIndexing; // @link substring="shaderInputAttachmentArrayDynamicIndexing" target="#shaderInputAttachmentArrayDynamicIndexing"
///     VkBool32 shaderUniformTexelBufferArrayDynamicIndexing; // @link substring="shaderUniformTexelBufferArrayDynamicIndexing" target="#shaderUniformTexelBufferArrayDynamicIndexing"
///     VkBool32 shaderStorageTexelBufferArrayDynamicIndexing; // @link substring="shaderStorageTexelBufferArrayDynamicIndexing" target="#shaderStorageTexelBufferArrayDynamicIndexing"
///     VkBool32 shaderUniformBufferArrayNonUniformIndexing; // @link substring="shaderUniformBufferArrayNonUniformIndexing" target="#shaderUniformBufferArrayNonUniformIndexing"
///     VkBool32 shaderSampledImageArrayNonUniformIndexing; // @link substring="shaderSampledImageArrayNonUniformIndexing" target="#shaderSampledImageArrayNonUniformIndexing"
///     VkBool32 shaderStorageBufferArrayNonUniformIndexing; // @link substring="shaderStorageBufferArrayNonUniformIndexing" target="#shaderStorageBufferArrayNonUniformIndexing"
///     VkBool32 shaderStorageImageArrayNonUniformIndexing; // @link substring="shaderStorageImageArrayNonUniformIndexing" target="#shaderStorageImageArrayNonUniformIndexing"
///     VkBool32 shaderInputAttachmentArrayNonUniformIndexing; // @link substring="shaderInputAttachmentArrayNonUniformIndexing" target="#shaderInputAttachmentArrayNonUniformIndexing"
///     VkBool32 shaderUniformTexelBufferArrayNonUniformIndexing; // @link substring="shaderUniformTexelBufferArrayNonUniformIndexing" target="#shaderUniformTexelBufferArrayNonUniformIndexing"
///     VkBool32 shaderStorageTexelBufferArrayNonUniformIndexing; // @link substring="shaderStorageTexelBufferArrayNonUniformIndexing" target="#shaderStorageTexelBufferArrayNonUniformIndexing"
///     VkBool32 descriptorBindingUniformBufferUpdateAfterBind; // @link substring="descriptorBindingUniformBufferUpdateAfterBind" target="#descriptorBindingUniformBufferUpdateAfterBind"
///     VkBool32 descriptorBindingSampledImageUpdateAfterBind; // @link substring="descriptorBindingSampledImageUpdateAfterBind" target="#descriptorBindingSampledImageUpdateAfterBind"
///     VkBool32 descriptorBindingStorageImageUpdateAfterBind; // @link substring="descriptorBindingStorageImageUpdateAfterBind" target="#descriptorBindingStorageImageUpdateAfterBind"
///     VkBool32 descriptorBindingStorageBufferUpdateAfterBind; // @link substring="descriptorBindingStorageBufferUpdateAfterBind" target="#descriptorBindingStorageBufferUpdateAfterBind"
///     VkBool32 descriptorBindingUniformTexelBufferUpdateAfterBind; // @link substring="descriptorBindingUniformTexelBufferUpdateAfterBind" target="#descriptorBindingUniformTexelBufferUpdateAfterBind"
///     VkBool32 descriptorBindingStorageTexelBufferUpdateAfterBind; // @link substring="descriptorBindingStorageTexelBufferUpdateAfterBind" target="#descriptorBindingStorageTexelBufferUpdateAfterBind"
///     VkBool32 descriptorBindingUpdateUnusedWhilePending; // @link substring="descriptorBindingUpdateUnusedWhilePending" target="#descriptorBindingUpdateUnusedWhilePending"
///     VkBool32 descriptorBindingPartiallyBound; // @link substring="descriptorBindingPartiallyBound" target="#descriptorBindingPartiallyBound"
///     VkBool32 descriptorBindingVariableDescriptorCount; // @link substring="descriptorBindingVariableDescriptorCount" target="#descriptorBindingVariableDescriptorCount"
///     VkBool32 runtimeDescriptorArray; // @link substring="runtimeDescriptorArray" target="#runtimeDescriptorArray"
///     VkBool32 samplerFilterMinmax; // @link substring="samplerFilterMinmax" target="#samplerFilterMinmax"
///     VkBool32 scalarBlockLayout; // @link substring="scalarBlockLayout" target="#scalarBlockLayout"
///     VkBool32 imagelessFramebuffer; // @link substring="imagelessFramebuffer" target="#imagelessFramebuffer"
///     VkBool32 uniformBufferStandardLayout; // @link substring="uniformBufferStandardLayout" target="#uniformBufferStandardLayout"
///     VkBool32 shaderSubgroupExtendedTypes; // @link substring="shaderSubgroupExtendedTypes" target="#shaderSubgroupExtendedTypes"
///     VkBool32 separateDepthStencilLayouts; // @link substring="separateDepthStencilLayouts" target="#separateDepthStencilLayouts"
///     VkBool32 hostQueryReset; // @link substring="hostQueryReset" target="#hostQueryReset"
///     VkBool32 timelineSemaphore; // @link substring="timelineSemaphore" target="#timelineSemaphore"
///     VkBool32 bufferDeviceAddress; // @link substring="bufferDeviceAddress" target="#bufferDeviceAddress"
///     VkBool32 bufferDeviceAddressCaptureReplay; // @link substring="bufferDeviceAddressCaptureReplay" target="#bufferDeviceAddressCaptureReplay"
///     VkBool32 bufferDeviceAddressMultiDevice; // @link substring="bufferDeviceAddressMultiDevice" target="#bufferDeviceAddressMultiDevice"
///     VkBool32 vulkanMemoryModel; // @link substring="vulkanMemoryModel" target="#vulkanMemoryModel"
///     VkBool32 vulkanMemoryModelDeviceScope; // @link substring="vulkanMemoryModelDeviceScope" target="#vulkanMemoryModelDeviceScope"
///     VkBool32 vulkanMemoryModelAvailabilityVisibilityChains; // @link substring="vulkanMemoryModelAvailabilityVisibilityChains" target="#vulkanMemoryModelAvailabilityVisibilityChains"
///     VkBool32 shaderOutputViewportIndex; // @link substring="shaderOutputViewportIndex" target="#shaderOutputViewportIndex"
///     VkBool32 shaderOutputLayer; // @link substring="shaderOutputLayer" target="#shaderOutputLayer"
///     VkBool32 subgroupBroadcastDynamicId; // @link substring="subgroupBroadcastDynamicId" target="#subgroupBroadcastDynamicId"
/// } VkPhysicalDeviceVulkan12Features;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_VULKAN_1_2_FEATURES`
///
/// The {@code allocate} ({@link VkPhysicalDeviceVulkan12Features#allocate(Arena)}, {@link VkPhysicalDeviceVulkan12Features#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceVulkan12Features#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceVulkan12Features.html"><code>VkPhysicalDeviceVulkan12Features</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceVulkan12Features(@NotNull MemorySegment segment) implements IVkPhysicalDeviceVulkan12Features {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceVulkan12Features.html"><code>VkPhysicalDeviceVulkan12Features</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceVulkan12Features}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceVulkan12Features to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceVulkan12Features.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceVulkan12Features, Iterable<VkPhysicalDeviceVulkan12Features> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceVulkan12Features.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceVulkan12Features at(long index) {
            return new VkPhysicalDeviceVulkan12Features(segment.asSlice(index * VkPhysicalDeviceVulkan12Features.BYTES, VkPhysicalDeviceVulkan12Features.BYTES));
        }

        public VkPhysicalDeviceVulkan12Features.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceVulkan12Features> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceVulkan12Features value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceVulkan12Features.BYTES, VkPhysicalDeviceVulkan12Features.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceVulkan12Features.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceVulkan12Features.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceVulkan12Features.BYTES,
                (end - start) * VkPhysicalDeviceVulkan12Features.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceVulkan12Features.BYTES));
        }

        public VkPhysicalDeviceVulkan12Features[] toArray() {
            VkPhysicalDeviceVulkan12Features[] ret = new VkPhysicalDeviceVulkan12Features[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceVulkan12Features> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceVulkan12Features> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceVulkan12Features.BYTES;
            }

            @Override
            public VkPhysicalDeviceVulkan12Features next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceVulkan12Features ret = new VkPhysicalDeviceVulkan12Features(segment.asSlice(0, VkPhysicalDeviceVulkan12Features.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceVulkan12Features.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceVulkan12Features allocate(Arena arena) {
        VkPhysicalDeviceVulkan12Features ret = new VkPhysicalDeviceVulkan12Features(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_VULKAN_1_2_FEATURES);
        return ret;
    }

    public static VkPhysicalDeviceVulkan12Features.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceVulkan12Features.Ptr ret = new VkPhysicalDeviceVulkan12Features.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_VULKAN_1_2_FEATURES);
        }
        return ret;
    }

    public static VkPhysicalDeviceVulkan12Features clone(Arena arena, VkPhysicalDeviceVulkan12Features src) {
        VkPhysicalDeviceVulkan12Features ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_VULKAN_1_2_FEATURES);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceVulkan12Features sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceVulkan12Features pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceVulkan12Features pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int samplerMirrorClampToEdge() {
        return segment.get(LAYOUT$samplerMirrorClampToEdge, OFFSET$samplerMirrorClampToEdge);
    }

    public VkPhysicalDeviceVulkan12Features samplerMirrorClampToEdge(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$samplerMirrorClampToEdge, OFFSET$samplerMirrorClampToEdge, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int drawIndirectCount() {
        return segment.get(LAYOUT$drawIndirectCount, OFFSET$drawIndirectCount);
    }

    public VkPhysicalDeviceVulkan12Features drawIndirectCount(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$drawIndirectCount, OFFSET$drawIndirectCount, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int storageBuffer8BitAccess() {
        return segment.get(LAYOUT$storageBuffer8BitAccess, OFFSET$storageBuffer8BitAccess);
    }

    public VkPhysicalDeviceVulkan12Features storageBuffer8BitAccess(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$storageBuffer8BitAccess, OFFSET$storageBuffer8BitAccess, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int uniformAndStorageBuffer8BitAccess() {
        return segment.get(LAYOUT$uniformAndStorageBuffer8BitAccess, OFFSET$uniformAndStorageBuffer8BitAccess);
    }

    public VkPhysicalDeviceVulkan12Features uniformAndStorageBuffer8BitAccess(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$uniformAndStorageBuffer8BitAccess, OFFSET$uniformAndStorageBuffer8BitAccess, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int storagePushConstant8() {
        return segment.get(LAYOUT$storagePushConstant8, OFFSET$storagePushConstant8);
    }

    public VkPhysicalDeviceVulkan12Features storagePushConstant8(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$storagePushConstant8, OFFSET$storagePushConstant8, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderBufferInt64Atomics() {
        return segment.get(LAYOUT$shaderBufferInt64Atomics, OFFSET$shaderBufferInt64Atomics);
    }

    public VkPhysicalDeviceVulkan12Features shaderBufferInt64Atomics(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderBufferInt64Atomics, OFFSET$shaderBufferInt64Atomics, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderSharedInt64Atomics() {
        return segment.get(LAYOUT$shaderSharedInt64Atomics, OFFSET$shaderSharedInt64Atomics);
    }

    public VkPhysicalDeviceVulkan12Features shaderSharedInt64Atomics(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderSharedInt64Atomics, OFFSET$shaderSharedInt64Atomics, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderFloat16() {
        return segment.get(LAYOUT$shaderFloat16, OFFSET$shaderFloat16);
    }

    public VkPhysicalDeviceVulkan12Features shaderFloat16(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderFloat16, OFFSET$shaderFloat16, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderInt8() {
        return segment.get(LAYOUT$shaderInt8, OFFSET$shaderInt8);
    }

    public VkPhysicalDeviceVulkan12Features shaderInt8(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderInt8, OFFSET$shaderInt8, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int descriptorIndexing() {
        return segment.get(LAYOUT$descriptorIndexing, OFFSET$descriptorIndexing);
    }

    public VkPhysicalDeviceVulkan12Features descriptorIndexing(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$descriptorIndexing, OFFSET$descriptorIndexing, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderInputAttachmentArrayDynamicIndexing() {
        return segment.get(LAYOUT$shaderInputAttachmentArrayDynamicIndexing, OFFSET$shaderInputAttachmentArrayDynamicIndexing);
    }

    public VkPhysicalDeviceVulkan12Features shaderInputAttachmentArrayDynamicIndexing(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderInputAttachmentArrayDynamicIndexing, OFFSET$shaderInputAttachmentArrayDynamicIndexing, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderUniformTexelBufferArrayDynamicIndexing() {
        return segment.get(LAYOUT$shaderUniformTexelBufferArrayDynamicIndexing, OFFSET$shaderUniformTexelBufferArrayDynamicIndexing);
    }

    public VkPhysicalDeviceVulkan12Features shaderUniformTexelBufferArrayDynamicIndexing(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderUniformTexelBufferArrayDynamicIndexing, OFFSET$shaderUniformTexelBufferArrayDynamicIndexing, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderStorageTexelBufferArrayDynamicIndexing() {
        return segment.get(LAYOUT$shaderStorageTexelBufferArrayDynamicIndexing, OFFSET$shaderStorageTexelBufferArrayDynamicIndexing);
    }

    public VkPhysicalDeviceVulkan12Features shaderStorageTexelBufferArrayDynamicIndexing(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderStorageTexelBufferArrayDynamicIndexing, OFFSET$shaderStorageTexelBufferArrayDynamicIndexing, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderUniformBufferArrayNonUniformIndexing() {
        return segment.get(LAYOUT$shaderUniformBufferArrayNonUniformIndexing, OFFSET$shaderUniformBufferArrayNonUniformIndexing);
    }

    public VkPhysicalDeviceVulkan12Features shaderUniformBufferArrayNonUniformIndexing(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderUniformBufferArrayNonUniformIndexing, OFFSET$shaderUniformBufferArrayNonUniformIndexing, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderSampledImageArrayNonUniformIndexing() {
        return segment.get(LAYOUT$shaderSampledImageArrayNonUniformIndexing, OFFSET$shaderSampledImageArrayNonUniformIndexing);
    }

    public VkPhysicalDeviceVulkan12Features shaderSampledImageArrayNonUniformIndexing(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderSampledImageArrayNonUniformIndexing, OFFSET$shaderSampledImageArrayNonUniformIndexing, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderStorageBufferArrayNonUniformIndexing() {
        return segment.get(LAYOUT$shaderStorageBufferArrayNonUniformIndexing, OFFSET$shaderStorageBufferArrayNonUniformIndexing);
    }

    public VkPhysicalDeviceVulkan12Features shaderStorageBufferArrayNonUniformIndexing(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderStorageBufferArrayNonUniformIndexing, OFFSET$shaderStorageBufferArrayNonUniformIndexing, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderStorageImageArrayNonUniformIndexing() {
        return segment.get(LAYOUT$shaderStorageImageArrayNonUniformIndexing, OFFSET$shaderStorageImageArrayNonUniformIndexing);
    }

    public VkPhysicalDeviceVulkan12Features shaderStorageImageArrayNonUniformIndexing(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderStorageImageArrayNonUniformIndexing, OFFSET$shaderStorageImageArrayNonUniformIndexing, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderInputAttachmentArrayNonUniformIndexing() {
        return segment.get(LAYOUT$shaderInputAttachmentArrayNonUniformIndexing, OFFSET$shaderInputAttachmentArrayNonUniformIndexing);
    }

    public VkPhysicalDeviceVulkan12Features shaderInputAttachmentArrayNonUniformIndexing(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderInputAttachmentArrayNonUniformIndexing, OFFSET$shaderInputAttachmentArrayNonUniformIndexing, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderUniformTexelBufferArrayNonUniformIndexing() {
        return segment.get(LAYOUT$shaderUniformTexelBufferArrayNonUniformIndexing, OFFSET$shaderUniformTexelBufferArrayNonUniformIndexing);
    }

    public VkPhysicalDeviceVulkan12Features shaderUniformTexelBufferArrayNonUniformIndexing(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderUniformTexelBufferArrayNonUniformIndexing, OFFSET$shaderUniformTexelBufferArrayNonUniformIndexing, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderStorageTexelBufferArrayNonUniformIndexing() {
        return segment.get(LAYOUT$shaderStorageTexelBufferArrayNonUniformIndexing, OFFSET$shaderStorageTexelBufferArrayNonUniformIndexing);
    }

    public VkPhysicalDeviceVulkan12Features shaderStorageTexelBufferArrayNonUniformIndexing(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderStorageTexelBufferArrayNonUniformIndexing, OFFSET$shaderStorageTexelBufferArrayNonUniformIndexing, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int descriptorBindingUniformBufferUpdateAfterBind() {
        return segment.get(LAYOUT$descriptorBindingUniformBufferUpdateAfterBind, OFFSET$descriptorBindingUniformBufferUpdateAfterBind);
    }

    public VkPhysicalDeviceVulkan12Features descriptorBindingUniformBufferUpdateAfterBind(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$descriptorBindingUniformBufferUpdateAfterBind, OFFSET$descriptorBindingUniformBufferUpdateAfterBind, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int descriptorBindingSampledImageUpdateAfterBind() {
        return segment.get(LAYOUT$descriptorBindingSampledImageUpdateAfterBind, OFFSET$descriptorBindingSampledImageUpdateAfterBind);
    }

    public VkPhysicalDeviceVulkan12Features descriptorBindingSampledImageUpdateAfterBind(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$descriptorBindingSampledImageUpdateAfterBind, OFFSET$descriptorBindingSampledImageUpdateAfterBind, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int descriptorBindingStorageImageUpdateAfterBind() {
        return segment.get(LAYOUT$descriptorBindingStorageImageUpdateAfterBind, OFFSET$descriptorBindingStorageImageUpdateAfterBind);
    }

    public VkPhysicalDeviceVulkan12Features descriptorBindingStorageImageUpdateAfterBind(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$descriptorBindingStorageImageUpdateAfterBind, OFFSET$descriptorBindingStorageImageUpdateAfterBind, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int descriptorBindingStorageBufferUpdateAfterBind() {
        return segment.get(LAYOUT$descriptorBindingStorageBufferUpdateAfterBind, OFFSET$descriptorBindingStorageBufferUpdateAfterBind);
    }

    public VkPhysicalDeviceVulkan12Features descriptorBindingStorageBufferUpdateAfterBind(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$descriptorBindingStorageBufferUpdateAfterBind, OFFSET$descriptorBindingStorageBufferUpdateAfterBind, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int descriptorBindingUniformTexelBufferUpdateAfterBind() {
        return segment.get(LAYOUT$descriptorBindingUniformTexelBufferUpdateAfterBind, OFFSET$descriptorBindingUniformTexelBufferUpdateAfterBind);
    }

    public VkPhysicalDeviceVulkan12Features descriptorBindingUniformTexelBufferUpdateAfterBind(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$descriptorBindingUniformTexelBufferUpdateAfterBind, OFFSET$descriptorBindingUniformTexelBufferUpdateAfterBind, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int descriptorBindingStorageTexelBufferUpdateAfterBind() {
        return segment.get(LAYOUT$descriptorBindingStorageTexelBufferUpdateAfterBind, OFFSET$descriptorBindingStorageTexelBufferUpdateAfterBind);
    }

    public VkPhysicalDeviceVulkan12Features descriptorBindingStorageTexelBufferUpdateAfterBind(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$descriptorBindingStorageTexelBufferUpdateAfterBind, OFFSET$descriptorBindingStorageTexelBufferUpdateAfterBind, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int descriptorBindingUpdateUnusedWhilePending() {
        return segment.get(LAYOUT$descriptorBindingUpdateUnusedWhilePending, OFFSET$descriptorBindingUpdateUnusedWhilePending);
    }

    public VkPhysicalDeviceVulkan12Features descriptorBindingUpdateUnusedWhilePending(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$descriptorBindingUpdateUnusedWhilePending, OFFSET$descriptorBindingUpdateUnusedWhilePending, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int descriptorBindingPartiallyBound() {
        return segment.get(LAYOUT$descriptorBindingPartiallyBound, OFFSET$descriptorBindingPartiallyBound);
    }

    public VkPhysicalDeviceVulkan12Features descriptorBindingPartiallyBound(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$descriptorBindingPartiallyBound, OFFSET$descriptorBindingPartiallyBound, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int descriptorBindingVariableDescriptorCount() {
        return segment.get(LAYOUT$descriptorBindingVariableDescriptorCount, OFFSET$descriptorBindingVariableDescriptorCount);
    }

    public VkPhysicalDeviceVulkan12Features descriptorBindingVariableDescriptorCount(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$descriptorBindingVariableDescriptorCount, OFFSET$descriptorBindingVariableDescriptorCount, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int runtimeDescriptorArray() {
        return segment.get(LAYOUT$runtimeDescriptorArray, OFFSET$runtimeDescriptorArray);
    }

    public VkPhysicalDeviceVulkan12Features runtimeDescriptorArray(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$runtimeDescriptorArray, OFFSET$runtimeDescriptorArray, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int samplerFilterMinmax() {
        return segment.get(LAYOUT$samplerFilterMinmax, OFFSET$samplerFilterMinmax);
    }

    public VkPhysicalDeviceVulkan12Features samplerFilterMinmax(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$samplerFilterMinmax, OFFSET$samplerFilterMinmax, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int scalarBlockLayout() {
        return segment.get(LAYOUT$scalarBlockLayout, OFFSET$scalarBlockLayout);
    }

    public VkPhysicalDeviceVulkan12Features scalarBlockLayout(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$scalarBlockLayout, OFFSET$scalarBlockLayout, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int imagelessFramebuffer() {
        return segment.get(LAYOUT$imagelessFramebuffer, OFFSET$imagelessFramebuffer);
    }

    public VkPhysicalDeviceVulkan12Features imagelessFramebuffer(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$imagelessFramebuffer, OFFSET$imagelessFramebuffer, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int uniformBufferStandardLayout() {
        return segment.get(LAYOUT$uniformBufferStandardLayout, OFFSET$uniformBufferStandardLayout);
    }

    public VkPhysicalDeviceVulkan12Features uniformBufferStandardLayout(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$uniformBufferStandardLayout, OFFSET$uniformBufferStandardLayout, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderSubgroupExtendedTypes() {
        return segment.get(LAYOUT$shaderSubgroupExtendedTypes, OFFSET$shaderSubgroupExtendedTypes);
    }

    public VkPhysicalDeviceVulkan12Features shaderSubgroupExtendedTypes(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderSubgroupExtendedTypes, OFFSET$shaderSubgroupExtendedTypes, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int separateDepthStencilLayouts() {
        return segment.get(LAYOUT$separateDepthStencilLayouts, OFFSET$separateDepthStencilLayouts);
    }

    public VkPhysicalDeviceVulkan12Features separateDepthStencilLayouts(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$separateDepthStencilLayouts, OFFSET$separateDepthStencilLayouts, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int hostQueryReset() {
        return segment.get(LAYOUT$hostQueryReset, OFFSET$hostQueryReset);
    }

    public VkPhysicalDeviceVulkan12Features hostQueryReset(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$hostQueryReset, OFFSET$hostQueryReset, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int timelineSemaphore() {
        return segment.get(LAYOUT$timelineSemaphore, OFFSET$timelineSemaphore);
    }

    public VkPhysicalDeviceVulkan12Features timelineSemaphore(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$timelineSemaphore, OFFSET$timelineSemaphore, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int bufferDeviceAddress() {
        return segment.get(LAYOUT$bufferDeviceAddress, OFFSET$bufferDeviceAddress);
    }

    public VkPhysicalDeviceVulkan12Features bufferDeviceAddress(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$bufferDeviceAddress, OFFSET$bufferDeviceAddress, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int bufferDeviceAddressCaptureReplay() {
        return segment.get(LAYOUT$bufferDeviceAddressCaptureReplay, OFFSET$bufferDeviceAddressCaptureReplay);
    }

    public VkPhysicalDeviceVulkan12Features bufferDeviceAddressCaptureReplay(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$bufferDeviceAddressCaptureReplay, OFFSET$bufferDeviceAddressCaptureReplay, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int bufferDeviceAddressMultiDevice() {
        return segment.get(LAYOUT$bufferDeviceAddressMultiDevice, OFFSET$bufferDeviceAddressMultiDevice);
    }

    public VkPhysicalDeviceVulkan12Features bufferDeviceAddressMultiDevice(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$bufferDeviceAddressMultiDevice, OFFSET$bufferDeviceAddressMultiDevice, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int vulkanMemoryModel() {
        return segment.get(LAYOUT$vulkanMemoryModel, OFFSET$vulkanMemoryModel);
    }

    public VkPhysicalDeviceVulkan12Features vulkanMemoryModel(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$vulkanMemoryModel, OFFSET$vulkanMemoryModel, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int vulkanMemoryModelDeviceScope() {
        return segment.get(LAYOUT$vulkanMemoryModelDeviceScope, OFFSET$vulkanMemoryModelDeviceScope);
    }

    public VkPhysicalDeviceVulkan12Features vulkanMemoryModelDeviceScope(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$vulkanMemoryModelDeviceScope, OFFSET$vulkanMemoryModelDeviceScope, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int vulkanMemoryModelAvailabilityVisibilityChains() {
        return segment.get(LAYOUT$vulkanMemoryModelAvailabilityVisibilityChains, OFFSET$vulkanMemoryModelAvailabilityVisibilityChains);
    }

    public VkPhysicalDeviceVulkan12Features vulkanMemoryModelAvailabilityVisibilityChains(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$vulkanMemoryModelAvailabilityVisibilityChains, OFFSET$vulkanMemoryModelAvailabilityVisibilityChains, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderOutputViewportIndex() {
        return segment.get(LAYOUT$shaderOutputViewportIndex, OFFSET$shaderOutputViewportIndex);
    }

    public VkPhysicalDeviceVulkan12Features shaderOutputViewportIndex(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderOutputViewportIndex, OFFSET$shaderOutputViewportIndex, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderOutputLayer() {
        return segment.get(LAYOUT$shaderOutputLayer, OFFSET$shaderOutputLayer);
    }

    public VkPhysicalDeviceVulkan12Features shaderOutputLayer(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderOutputLayer, OFFSET$shaderOutputLayer, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int subgroupBroadcastDynamicId() {
        return segment.get(LAYOUT$subgroupBroadcastDynamicId, OFFSET$subgroupBroadcastDynamicId);
    }

    public VkPhysicalDeviceVulkan12Features subgroupBroadcastDynamicId(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$subgroupBroadcastDynamicId, OFFSET$subgroupBroadcastDynamicId, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("samplerMirrorClampToEdge"),
        ValueLayout.JAVA_INT.withName("drawIndirectCount"),
        ValueLayout.JAVA_INT.withName("storageBuffer8BitAccess"),
        ValueLayout.JAVA_INT.withName("uniformAndStorageBuffer8BitAccess"),
        ValueLayout.JAVA_INT.withName("storagePushConstant8"),
        ValueLayout.JAVA_INT.withName("shaderBufferInt64Atomics"),
        ValueLayout.JAVA_INT.withName("shaderSharedInt64Atomics"),
        ValueLayout.JAVA_INT.withName("shaderFloat16"),
        ValueLayout.JAVA_INT.withName("shaderInt8"),
        ValueLayout.JAVA_INT.withName("descriptorIndexing"),
        ValueLayout.JAVA_INT.withName("shaderInputAttachmentArrayDynamicIndexing"),
        ValueLayout.JAVA_INT.withName("shaderUniformTexelBufferArrayDynamicIndexing"),
        ValueLayout.JAVA_INT.withName("shaderStorageTexelBufferArrayDynamicIndexing"),
        ValueLayout.JAVA_INT.withName("shaderUniformBufferArrayNonUniformIndexing"),
        ValueLayout.JAVA_INT.withName("shaderSampledImageArrayNonUniformIndexing"),
        ValueLayout.JAVA_INT.withName("shaderStorageBufferArrayNonUniformIndexing"),
        ValueLayout.JAVA_INT.withName("shaderStorageImageArrayNonUniformIndexing"),
        ValueLayout.JAVA_INT.withName("shaderInputAttachmentArrayNonUniformIndexing"),
        ValueLayout.JAVA_INT.withName("shaderUniformTexelBufferArrayNonUniformIndexing"),
        ValueLayout.JAVA_INT.withName("shaderStorageTexelBufferArrayNonUniformIndexing"),
        ValueLayout.JAVA_INT.withName("descriptorBindingUniformBufferUpdateAfterBind"),
        ValueLayout.JAVA_INT.withName("descriptorBindingSampledImageUpdateAfterBind"),
        ValueLayout.JAVA_INT.withName("descriptorBindingStorageImageUpdateAfterBind"),
        ValueLayout.JAVA_INT.withName("descriptorBindingStorageBufferUpdateAfterBind"),
        ValueLayout.JAVA_INT.withName("descriptorBindingUniformTexelBufferUpdateAfterBind"),
        ValueLayout.JAVA_INT.withName("descriptorBindingStorageTexelBufferUpdateAfterBind"),
        ValueLayout.JAVA_INT.withName("descriptorBindingUpdateUnusedWhilePending"),
        ValueLayout.JAVA_INT.withName("descriptorBindingPartiallyBound"),
        ValueLayout.JAVA_INT.withName("descriptorBindingVariableDescriptorCount"),
        ValueLayout.JAVA_INT.withName("runtimeDescriptorArray"),
        ValueLayout.JAVA_INT.withName("samplerFilterMinmax"),
        ValueLayout.JAVA_INT.withName("scalarBlockLayout"),
        ValueLayout.JAVA_INT.withName("imagelessFramebuffer"),
        ValueLayout.JAVA_INT.withName("uniformBufferStandardLayout"),
        ValueLayout.JAVA_INT.withName("shaderSubgroupExtendedTypes"),
        ValueLayout.JAVA_INT.withName("separateDepthStencilLayouts"),
        ValueLayout.JAVA_INT.withName("hostQueryReset"),
        ValueLayout.JAVA_INT.withName("timelineSemaphore"),
        ValueLayout.JAVA_INT.withName("bufferDeviceAddress"),
        ValueLayout.JAVA_INT.withName("bufferDeviceAddressCaptureReplay"),
        ValueLayout.JAVA_INT.withName("bufferDeviceAddressMultiDevice"),
        ValueLayout.JAVA_INT.withName("vulkanMemoryModel"),
        ValueLayout.JAVA_INT.withName("vulkanMemoryModelDeviceScope"),
        ValueLayout.JAVA_INT.withName("vulkanMemoryModelAvailabilityVisibilityChains"),
        ValueLayout.JAVA_INT.withName("shaderOutputViewportIndex"),
        ValueLayout.JAVA_INT.withName("shaderOutputLayer"),
        ValueLayout.JAVA_INT.withName("subgroupBroadcastDynamicId")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$samplerMirrorClampToEdge = PathElement.groupElement("samplerMirrorClampToEdge");
    public static final PathElement PATH$drawIndirectCount = PathElement.groupElement("drawIndirectCount");
    public static final PathElement PATH$storageBuffer8BitAccess = PathElement.groupElement("storageBuffer8BitAccess");
    public static final PathElement PATH$uniformAndStorageBuffer8BitAccess = PathElement.groupElement("uniformAndStorageBuffer8BitAccess");
    public static final PathElement PATH$storagePushConstant8 = PathElement.groupElement("storagePushConstant8");
    public static final PathElement PATH$shaderBufferInt64Atomics = PathElement.groupElement("shaderBufferInt64Atomics");
    public static final PathElement PATH$shaderSharedInt64Atomics = PathElement.groupElement("shaderSharedInt64Atomics");
    public static final PathElement PATH$shaderFloat16 = PathElement.groupElement("shaderFloat16");
    public static final PathElement PATH$shaderInt8 = PathElement.groupElement("shaderInt8");
    public static final PathElement PATH$descriptorIndexing = PathElement.groupElement("descriptorIndexing");
    public static final PathElement PATH$shaderInputAttachmentArrayDynamicIndexing = PathElement.groupElement("shaderInputAttachmentArrayDynamicIndexing");
    public static final PathElement PATH$shaderUniformTexelBufferArrayDynamicIndexing = PathElement.groupElement("shaderUniformTexelBufferArrayDynamicIndexing");
    public static final PathElement PATH$shaderStorageTexelBufferArrayDynamicIndexing = PathElement.groupElement("shaderStorageTexelBufferArrayDynamicIndexing");
    public static final PathElement PATH$shaderUniformBufferArrayNonUniformIndexing = PathElement.groupElement("shaderUniformBufferArrayNonUniformIndexing");
    public static final PathElement PATH$shaderSampledImageArrayNonUniformIndexing = PathElement.groupElement("shaderSampledImageArrayNonUniformIndexing");
    public static final PathElement PATH$shaderStorageBufferArrayNonUniformIndexing = PathElement.groupElement("shaderStorageBufferArrayNonUniformIndexing");
    public static final PathElement PATH$shaderStorageImageArrayNonUniformIndexing = PathElement.groupElement("shaderStorageImageArrayNonUniformIndexing");
    public static final PathElement PATH$shaderInputAttachmentArrayNonUniformIndexing = PathElement.groupElement("shaderInputAttachmentArrayNonUniformIndexing");
    public static final PathElement PATH$shaderUniformTexelBufferArrayNonUniformIndexing = PathElement.groupElement("shaderUniformTexelBufferArrayNonUniformIndexing");
    public static final PathElement PATH$shaderStorageTexelBufferArrayNonUniformIndexing = PathElement.groupElement("shaderStorageTexelBufferArrayNonUniformIndexing");
    public static final PathElement PATH$descriptorBindingUniformBufferUpdateAfterBind = PathElement.groupElement("descriptorBindingUniformBufferUpdateAfterBind");
    public static final PathElement PATH$descriptorBindingSampledImageUpdateAfterBind = PathElement.groupElement("descriptorBindingSampledImageUpdateAfterBind");
    public static final PathElement PATH$descriptorBindingStorageImageUpdateAfterBind = PathElement.groupElement("descriptorBindingStorageImageUpdateAfterBind");
    public static final PathElement PATH$descriptorBindingStorageBufferUpdateAfterBind = PathElement.groupElement("descriptorBindingStorageBufferUpdateAfterBind");
    public static final PathElement PATH$descriptorBindingUniformTexelBufferUpdateAfterBind = PathElement.groupElement("descriptorBindingUniformTexelBufferUpdateAfterBind");
    public static final PathElement PATH$descriptorBindingStorageTexelBufferUpdateAfterBind = PathElement.groupElement("descriptorBindingStorageTexelBufferUpdateAfterBind");
    public static final PathElement PATH$descriptorBindingUpdateUnusedWhilePending = PathElement.groupElement("descriptorBindingUpdateUnusedWhilePending");
    public static final PathElement PATH$descriptorBindingPartiallyBound = PathElement.groupElement("descriptorBindingPartiallyBound");
    public static final PathElement PATH$descriptorBindingVariableDescriptorCount = PathElement.groupElement("descriptorBindingVariableDescriptorCount");
    public static final PathElement PATH$runtimeDescriptorArray = PathElement.groupElement("runtimeDescriptorArray");
    public static final PathElement PATH$samplerFilterMinmax = PathElement.groupElement("samplerFilterMinmax");
    public static final PathElement PATH$scalarBlockLayout = PathElement.groupElement("scalarBlockLayout");
    public static final PathElement PATH$imagelessFramebuffer = PathElement.groupElement("imagelessFramebuffer");
    public static final PathElement PATH$uniformBufferStandardLayout = PathElement.groupElement("uniformBufferStandardLayout");
    public static final PathElement PATH$shaderSubgroupExtendedTypes = PathElement.groupElement("shaderSubgroupExtendedTypes");
    public static final PathElement PATH$separateDepthStencilLayouts = PathElement.groupElement("separateDepthStencilLayouts");
    public static final PathElement PATH$hostQueryReset = PathElement.groupElement("hostQueryReset");
    public static final PathElement PATH$timelineSemaphore = PathElement.groupElement("timelineSemaphore");
    public static final PathElement PATH$bufferDeviceAddress = PathElement.groupElement("bufferDeviceAddress");
    public static final PathElement PATH$bufferDeviceAddressCaptureReplay = PathElement.groupElement("bufferDeviceAddressCaptureReplay");
    public static final PathElement PATH$bufferDeviceAddressMultiDevice = PathElement.groupElement("bufferDeviceAddressMultiDevice");
    public static final PathElement PATH$vulkanMemoryModel = PathElement.groupElement("vulkanMemoryModel");
    public static final PathElement PATH$vulkanMemoryModelDeviceScope = PathElement.groupElement("vulkanMemoryModelDeviceScope");
    public static final PathElement PATH$vulkanMemoryModelAvailabilityVisibilityChains = PathElement.groupElement("vulkanMemoryModelAvailabilityVisibilityChains");
    public static final PathElement PATH$shaderOutputViewportIndex = PathElement.groupElement("shaderOutputViewportIndex");
    public static final PathElement PATH$shaderOutputLayer = PathElement.groupElement("shaderOutputLayer");
    public static final PathElement PATH$subgroupBroadcastDynamicId = PathElement.groupElement("subgroupBroadcastDynamicId");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$samplerMirrorClampToEdge = (OfInt) LAYOUT.select(PATH$samplerMirrorClampToEdge);
    public static final OfInt LAYOUT$drawIndirectCount = (OfInt) LAYOUT.select(PATH$drawIndirectCount);
    public static final OfInt LAYOUT$storageBuffer8BitAccess = (OfInt) LAYOUT.select(PATH$storageBuffer8BitAccess);
    public static final OfInt LAYOUT$uniformAndStorageBuffer8BitAccess = (OfInt) LAYOUT.select(PATH$uniformAndStorageBuffer8BitAccess);
    public static final OfInt LAYOUT$storagePushConstant8 = (OfInt) LAYOUT.select(PATH$storagePushConstant8);
    public static final OfInt LAYOUT$shaderBufferInt64Atomics = (OfInt) LAYOUT.select(PATH$shaderBufferInt64Atomics);
    public static final OfInt LAYOUT$shaderSharedInt64Atomics = (OfInt) LAYOUT.select(PATH$shaderSharedInt64Atomics);
    public static final OfInt LAYOUT$shaderFloat16 = (OfInt) LAYOUT.select(PATH$shaderFloat16);
    public static final OfInt LAYOUT$shaderInt8 = (OfInt) LAYOUT.select(PATH$shaderInt8);
    public static final OfInt LAYOUT$descriptorIndexing = (OfInt) LAYOUT.select(PATH$descriptorIndexing);
    public static final OfInt LAYOUT$shaderInputAttachmentArrayDynamicIndexing = (OfInt) LAYOUT.select(PATH$shaderInputAttachmentArrayDynamicIndexing);
    public static final OfInt LAYOUT$shaderUniformTexelBufferArrayDynamicIndexing = (OfInt) LAYOUT.select(PATH$shaderUniformTexelBufferArrayDynamicIndexing);
    public static final OfInt LAYOUT$shaderStorageTexelBufferArrayDynamicIndexing = (OfInt) LAYOUT.select(PATH$shaderStorageTexelBufferArrayDynamicIndexing);
    public static final OfInt LAYOUT$shaderUniformBufferArrayNonUniformIndexing = (OfInt) LAYOUT.select(PATH$shaderUniformBufferArrayNonUniformIndexing);
    public static final OfInt LAYOUT$shaderSampledImageArrayNonUniformIndexing = (OfInt) LAYOUT.select(PATH$shaderSampledImageArrayNonUniformIndexing);
    public static final OfInt LAYOUT$shaderStorageBufferArrayNonUniformIndexing = (OfInt) LAYOUT.select(PATH$shaderStorageBufferArrayNonUniformIndexing);
    public static final OfInt LAYOUT$shaderStorageImageArrayNonUniformIndexing = (OfInt) LAYOUT.select(PATH$shaderStorageImageArrayNonUniformIndexing);
    public static final OfInt LAYOUT$shaderInputAttachmentArrayNonUniformIndexing = (OfInt) LAYOUT.select(PATH$shaderInputAttachmentArrayNonUniformIndexing);
    public static final OfInt LAYOUT$shaderUniformTexelBufferArrayNonUniformIndexing = (OfInt) LAYOUT.select(PATH$shaderUniformTexelBufferArrayNonUniformIndexing);
    public static final OfInt LAYOUT$shaderStorageTexelBufferArrayNonUniformIndexing = (OfInt) LAYOUT.select(PATH$shaderStorageTexelBufferArrayNonUniformIndexing);
    public static final OfInt LAYOUT$descriptorBindingUniformBufferUpdateAfterBind = (OfInt) LAYOUT.select(PATH$descriptorBindingUniformBufferUpdateAfterBind);
    public static final OfInt LAYOUT$descriptorBindingSampledImageUpdateAfterBind = (OfInt) LAYOUT.select(PATH$descriptorBindingSampledImageUpdateAfterBind);
    public static final OfInt LAYOUT$descriptorBindingStorageImageUpdateAfterBind = (OfInt) LAYOUT.select(PATH$descriptorBindingStorageImageUpdateAfterBind);
    public static final OfInt LAYOUT$descriptorBindingStorageBufferUpdateAfterBind = (OfInt) LAYOUT.select(PATH$descriptorBindingStorageBufferUpdateAfterBind);
    public static final OfInt LAYOUT$descriptorBindingUniformTexelBufferUpdateAfterBind = (OfInt) LAYOUT.select(PATH$descriptorBindingUniformTexelBufferUpdateAfterBind);
    public static final OfInt LAYOUT$descriptorBindingStorageTexelBufferUpdateAfterBind = (OfInt) LAYOUT.select(PATH$descriptorBindingStorageTexelBufferUpdateAfterBind);
    public static final OfInt LAYOUT$descriptorBindingUpdateUnusedWhilePending = (OfInt) LAYOUT.select(PATH$descriptorBindingUpdateUnusedWhilePending);
    public static final OfInt LAYOUT$descriptorBindingPartiallyBound = (OfInt) LAYOUT.select(PATH$descriptorBindingPartiallyBound);
    public static final OfInt LAYOUT$descriptorBindingVariableDescriptorCount = (OfInt) LAYOUT.select(PATH$descriptorBindingVariableDescriptorCount);
    public static final OfInt LAYOUT$runtimeDescriptorArray = (OfInt) LAYOUT.select(PATH$runtimeDescriptorArray);
    public static final OfInt LAYOUT$samplerFilterMinmax = (OfInt) LAYOUT.select(PATH$samplerFilterMinmax);
    public static final OfInt LAYOUT$scalarBlockLayout = (OfInt) LAYOUT.select(PATH$scalarBlockLayout);
    public static final OfInt LAYOUT$imagelessFramebuffer = (OfInt) LAYOUT.select(PATH$imagelessFramebuffer);
    public static final OfInt LAYOUT$uniformBufferStandardLayout = (OfInt) LAYOUT.select(PATH$uniformBufferStandardLayout);
    public static final OfInt LAYOUT$shaderSubgroupExtendedTypes = (OfInt) LAYOUT.select(PATH$shaderSubgroupExtendedTypes);
    public static final OfInt LAYOUT$separateDepthStencilLayouts = (OfInt) LAYOUT.select(PATH$separateDepthStencilLayouts);
    public static final OfInt LAYOUT$hostQueryReset = (OfInt) LAYOUT.select(PATH$hostQueryReset);
    public static final OfInt LAYOUT$timelineSemaphore = (OfInt) LAYOUT.select(PATH$timelineSemaphore);
    public static final OfInt LAYOUT$bufferDeviceAddress = (OfInt) LAYOUT.select(PATH$bufferDeviceAddress);
    public static final OfInt LAYOUT$bufferDeviceAddressCaptureReplay = (OfInt) LAYOUT.select(PATH$bufferDeviceAddressCaptureReplay);
    public static final OfInt LAYOUT$bufferDeviceAddressMultiDevice = (OfInt) LAYOUT.select(PATH$bufferDeviceAddressMultiDevice);
    public static final OfInt LAYOUT$vulkanMemoryModel = (OfInt) LAYOUT.select(PATH$vulkanMemoryModel);
    public static final OfInt LAYOUT$vulkanMemoryModelDeviceScope = (OfInt) LAYOUT.select(PATH$vulkanMemoryModelDeviceScope);
    public static final OfInt LAYOUT$vulkanMemoryModelAvailabilityVisibilityChains = (OfInt) LAYOUT.select(PATH$vulkanMemoryModelAvailabilityVisibilityChains);
    public static final OfInt LAYOUT$shaderOutputViewportIndex = (OfInt) LAYOUT.select(PATH$shaderOutputViewportIndex);
    public static final OfInt LAYOUT$shaderOutputLayer = (OfInt) LAYOUT.select(PATH$shaderOutputLayer);
    public static final OfInt LAYOUT$subgroupBroadcastDynamicId = (OfInt) LAYOUT.select(PATH$subgroupBroadcastDynamicId);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$samplerMirrorClampToEdge = LAYOUT$samplerMirrorClampToEdge.byteSize();
    public static final long SIZE$drawIndirectCount = LAYOUT$drawIndirectCount.byteSize();
    public static final long SIZE$storageBuffer8BitAccess = LAYOUT$storageBuffer8BitAccess.byteSize();
    public static final long SIZE$uniformAndStorageBuffer8BitAccess = LAYOUT$uniformAndStorageBuffer8BitAccess.byteSize();
    public static final long SIZE$storagePushConstant8 = LAYOUT$storagePushConstant8.byteSize();
    public static final long SIZE$shaderBufferInt64Atomics = LAYOUT$shaderBufferInt64Atomics.byteSize();
    public static final long SIZE$shaderSharedInt64Atomics = LAYOUT$shaderSharedInt64Atomics.byteSize();
    public static final long SIZE$shaderFloat16 = LAYOUT$shaderFloat16.byteSize();
    public static final long SIZE$shaderInt8 = LAYOUT$shaderInt8.byteSize();
    public static final long SIZE$descriptorIndexing = LAYOUT$descriptorIndexing.byteSize();
    public static final long SIZE$shaderInputAttachmentArrayDynamicIndexing = LAYOUT$shaderInputAttachmentArrayDynamicIndexing.byteSize();
    public static final long SIZE$shaderUniformTexelBufferArrayDynamicIndexing = LAYOUT$shaderUniformTexelBufferArrayDynamicIndexing.byteSize();
    public static final long SIZE$shaderStorageTexelBufferArrayDynamicIndexing = LAYOUT$shaderStorageTexelBufferArrayDynamicIndexing.byteSize();
    public static final long SIZE$shaderUniformBufferArrayNonUniformIndexing = LAYOUT$shaderUniformBufferArrayNonUniformIndexing.byteSize();
    public static final long SIZE$shaderSampledImageArrayNonUniformIndexing = LAYOUT$shaderSampledImageArrayNonUniformIndexing.byteSize();
    public static final long SIZE$shaderStorageBufferArrayNonUniformIndexing = LAYOUT$shaderStorageBufferArrayNonUniformIndexing.byteSize();
    public static final long SIZE$shaderStorageImageArrayNonUniformIndexing = LAYOUT$shaderStorageImageArrayNonUniformIndexing.byteSize();
    public static final long SIZE$shaderInputAttachmentArrayNonUniformIndexing = LAYOUT$shaderInputAttachmentArrayNonUniformIndexing.byteSize();
    public static final long SIZE$shaderUniformTexelBufferArrayNonUniformIndexing = LAYOUT$shaderUniformTexelBufferArrayNonUniformIndexing.byteSize();
    public static final long SIZE$shaderStorageTexelBufferArrayNonUniformIndexing = LAYOUT$shaderStorageTexelBufferArrayNonUniformIndexing.byteSize();
    public static final long SIZE$descriptorBindingUniformBufferUpdateAfterBind = LAYOUT$descriptorBindingUniformBufferUpdateAfterBind.byteSize();
    public static final long SIZE$descriptorBindingSampledImageUpdateAfterBind = LAYOUT$descriptorBindingSampledImageUpdateAfterBind.byteSize();
    public static final long SIZE$descriptorBindingStorageImageUpdateAfterBind = LAYOUT$descriptorBindingStorageImageUpdateAfterBind.byteSize();
    public static final long SIZE$descriptorBindingStorageBufferUpdateAfterBind = LAYOUT$descriptorBindingStorageBufferUpdateAfterBind.byteSize();
    public static final long SIZE$descriptorBindingUniformTexelBufferUpdateAfterBind = LAYOUT$descriptorBindingUniformTexelBufferUpdateAfterBind.byteSize();
    public static final long SIZE$descriptorBindingStorageTexelBufferUpdateAfterBind = LAYOUT$descriptorBindingStorageTexelBufferUpdateAfterBind.byteSize();
    public static final long SIZE$descriptorBindingUpdateUnusedWhilePending = LAYOUT$descriptorBindingUpdateUnusedWhilePending.byteSize();
    public static final long SIZE$descriptorBindingPartiallyBound = LAYOUT$descriptorBindingPartiallyBound.byteSize();
    public static final long SIZE$descriptorBindingVariableDescriptorCount = LAYOUT$descriptorBindingVariableDescriptorCount.byteSize();
    public static final long SIZE$runtimeDescriptorArray = LAYOUT$runtimeDescriptorArray.byteSize();
    public static final long SIZE$samplerFilterMinmax = LAYOUT$samplerFilterMinmax.byteSize();
    public static final long SIZE$scalarBlockLayout = LAYOUT$scalarBlockLayout.byteSize();
    public static final long SIZE$imagelessFramebuffer = LAYOUT$imagelessFramebuffer.byteSize();
    public static final long SIZE$uniformBufferStandardLayout = LAYOUT$uniformBufferStandardLayout.byteSize();
    public static final long SIZE$shaderSubgroupExtendedTypes = LAYOUT$shaderSubgroupExtendedTypes.byteSize();
    public static final long SIZE$separateDepthStencilLayouts = LAYOUT$separateDepthStencilLayouts.byteSize();
    public static final long SIZE$hostQueryReset = LAYOUT$hostQueryReset.byteSize();
    public static final long SIZE$timelineSemaphore = LAYOUT$timelineSemaphore.byteSize();
    public static final long SIZE$bufferDeviceAddress = LAYOUT$bufferDeviceAddress.byteSize();
    public static final long SIZE$bufferDeviceAddressCaptureReplay = LAYOUT$bufferDeviceAddressCaptureReplay.byteSize();
    public static final long SIZE$bufferDeviceAddressMultiDevice = LAYOUT$bufferDeviceAddressMultiDevice.byteSize();
    public static final long SIZE$vulkanMemoryModel = LAYOUT$vulkanMemoryModel.byteSize();
    public static final long SIZE$vulkanMemoryModelDeviceScope = LAYOUT$vulkanMemoryModelDeviceScope.byteSize();
    public static final long SIZE$vulkanMemoryModelAvailabilityVisibilityChains = LAYOUT$vulkanMemoryModelAvailabilityVisibilityChains.byteSize();
    public static final long SIZE$shaderOutputViewportIndex = LAYOUT$shaderOutputViewportIndex.byteSize();
    public static final long SIZE$shaderOutputLayer = LAYOUT$shaderOutputLayer.byteSize();
    public static final long SIZE$subgroupBroadcastDynamicId = LAYOUT$subgroupBroadcastDynamicId.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$samplerMirrorClampToEdge = LAYOUT.byteOffset(PATH$samplerMirrorClampToEdge);
    public static final long OFFSET$drawIndirectCount = LAYOUT.byteOffset(PATH$drawIndirectCount);
    public static final long OFFSET$storageBuffer8BitAccess = LAYOUT.byteOffset(PATH$storageBuffer8BitAccess);
    public static final long OFFSET$uniformAndStorageBuffer8BitAccess = LAYOUT.byteOffset(PATH$uniformAndStorageBuffer8BitAccess);
    public static final long OFFSET$storagePushConstant8 = LAYOUT.byteOffset(PATH$storagePushConstant8);
    public static final long OFFSET$shaderBufferInt64Atomics = LAYOUT.byteOffset(PATH$shaderBufferInt64Atomics);
    public static final long OFFSET$shaderSharedInt64Atomics = LAYOUT.byteOffset(PATH$shaderSharedInt64Atomics);
    public static final long OFFSET$shaderFloat16 = LAYOUT.byteOffset(PATH$shaderFloat16);
    public static final long OFFSET$shaderInt8 = LAYOUT.byteOffset(PATH$shaderInt8);
    public static final long OFFSET$descriptorIndexing = LAYOUT.byteOffset(PATH$descriptorIndexing);
    public static final long OFFSET$shaderInputAttachmentArrayDynamicIndexing = LAYOUT.byteOffset(PATH$shaderInputAttachmentArrayDynamicIndexing);
    public static final long OFFSET$shaderUniformTexelBufferArrayDynamicIndexing = LAYOUT.byteOffset(PATH$shaderUniformTexelBufferArrayDynamicIndexing);
    public static final long OFFSET$shaderStorageTexelBufferArrayDynamicIndexing = LAYOUT.byteOffset(PATH$shaderStorageTexelBufferArrayDynamicIndexing);
    public static final long OFFSET$shaderUniformBufferArrayNonUniformIndexing = LAYOUT.byteOffset(PATH$shaderUniformBufferArrayNonUniformIndexing);
    public static final long OFFSET$shaderSampledImageArrayNonUniformIndexing = LAYOUT.byteOffset(PATH$shaderSampledImageArrayNonUniformIndexing);
    public static final long OFFSET$shaderStorageBufferArrayNonUniformIndexing = LAYOUT.byteOffset(PATH$shaderStorageBufferArrayNonUniformIndexing);
    public static final long OFFSET$shaderStorageImageArrayNonUniformIndexing = LAYOUT.byteOffset(PATH$shaderStorageImageArrayNonUniformIndexing);
    public static final long OFFSET$shaderInputAttachmentArrayNonUniformIndexing = LAYOUT.byteOffset(PATH$shaderInputAttachmentArrayNonUniformIndexing);
    public static final long OFFSET$shaderUniformTexelBufferArrayNonUniformIndexing = LAYOUT.byteOffset(PATH$shaderUniformTexelBufferArrayNonUniformIndexing);
    public static final long OFFSET$shaderStorageTexelBufferArrayNonUniformIndexing = LAYOUT.byteOffset(PATH$shaderStorageTexelBufferArrayNonUniformIndexing);
    public static final long OFFSET$descriptorBindingUniformBufferUpdateAfterBind = LAYOUT.byteOffset(PATH$descriptorBindingUniformBufferUpdateAfterBind);
    public static final long OFFSET$descriptorBindingSampledImageUpdateAfterBind = LAYOUT.byteOffset(PATH$descriptorBindingSampledImageUpdateAfterBind);
    public static final long OFFSET$descriptorBindingStorageImageUpdateAfterBind = LAYOUT.byteOffset(PATH$descriptorBindingStorageImageUpdateAfterBind);
    public static final long OFFSET$descriptorBindingStorageBufferUpdateAfterBind = LAYOUT.byteOffset(PATH$descriptorBindingStorageBufferUpdateAfterBind);
    public static final long OFFSET$descriptorBindingUniformTexelBufferUpdateAfterBind = LAYOUT.byteOffset(PATH$descriptorBindingUniformTexelBufferUpdateAfterBind);
    public static final long OFFSET$descriptorBindingStorageTexelBufferUpdateAfterBind = LAYOUT.byteOffset(PATH$descriptorBindingStorageTexelBufferUpdateAfterBind);
    public static final long OFFSET$descriptorBindingUpdateUnusedWhilePending = LAYOUT.byteOffset(PATH$descriptorBindingUpdateUnusedWhilePending);
    public static final long OFFSET$descriptorBindingPartiallyBound = LAYOUT.byteOffset(PATH$descriptorBindingPartiallyBound);
    public static final long OFFSET$descriptorBindingVariableDescriptorCount = LAYOUT.byteOffset(PATH$descriptorBindingVariableDescriptorCount);
    public static final long OFFSET$runtimeDescriptorArray = LAYOUT.byteOffset(PATH$runtimeDescriptorArray);
    public static final long OFFSET$samplerFilterMinmax = LAYOUT.byteOffset(PATH$samplerFilterMinmax);
    public static final long OFFSET$scalarBlockLayout = LAYOUT.byteOffset(PATH$scalarBlockLayout);
    public static final long OFFSET$imagelessFramebuffer = LAYOUT.byteOffset(PATH$imagelessFramebuffer);
    public static final long OFFSET$uniformBufferStandardLayout = LAYOUT.byteOffset(PATH$uniformBufferStandardLayout);
    public static final long OFFSET$shaderSubgroupExtendedTypes = LAYOUT.byteOffset(PATH$shaderSubgroupExtendedTypes);
    public static final long OFFSET$separateDepthStencilLayouts = LAYOUT.byteOffset(PATH$separateDepthStencilLayouts);
    public static final long OFFSET$hostQueryReset = LAYOUT.byteOffset(PATH$hostQueryReset);
    public static final long OFFSET$timelineSemaphore = LAYOUT.byteOffset(PATH$timelineSemaphore);
    public static final long OFFSET$bufferDeviceAddress = LAYOUT.byteOffset(PATH$bufferDeviceAddress);
    public static final long OFFSET$bufferDeviceAddressCaptureReplay = LAYOUT.byteOffset(PATH$bufferDeviceAddressCaptureReplay);
    public static final long OFFSET$bufferDeviceAddressMultiDevice = LAYOUT.byteOffset(PATH$bufferDeviceAddressMultiDevice);
    public static final long OFFSET$vulkanMemoryModel = LAYOUT.byteOffset(PATH$vulkanMemoryModel);
    public static final long OFFSET$vulkanMemoryModelDeviceScope = LAYOUT.byteOffset(PATH$vulkanMemoryModelDeviceScope);
    public static final long OFFSET$vulkanMemoryModelAvailabilityVisibilityChains = LAYOUT.byteOffset(PATH$vulkanMemoryModelAvailabilityVisibilityChains);
    public static final long OFFSET$shaderOutputViewportIndex = LAYOUT.byteOffset(PATH$shaderOutputViewportIndex);
    public static final long OFFSET$shaderOutputLayer = LAYOUT.byteOffset(PATH$shaderOutputLayer);
    public static final long OFFSET$subgroupBroadcastDynamicId = LAYOUT.byteOffset(PATH$subgroupBroadcastDynamicId);
}
