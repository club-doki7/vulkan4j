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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceVulkan13Features.html"><code>VkPhysicalDeviceVulkan13Features</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceVulkan13Features {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 robustImageAccess; // @link substring="robustImageAccess" target="#robustImageAccess"
///     VkBool32 inlineUniformBlock; // @link substring="inlineUniformBlock" target="#inlineUniformBlock"
///     VkBool32 descriptorBindingInlineUniformBlockUpdateAfterBind; // @link substring="descriptorBindingInlineUniformBlockUpdateAfterBind" target="#descriptorBindingInlineUniformBlockUpdateAfterBind"
///     VkBool32 pipelineCreationCacheControl; // @link substring="pipelineCreationCacheControl" target="#pipelineCreationCacheControl"
///     VkBool32 privateData; // @link substring="privateData" target="#privateData"
///     VkBool32 shaderDemoteToHelperInvocation; // @link substring="shaderDemoteToHelperInvocation" target="#shaderDemoteToHelperInvocation"
///     VkBool32 shaderTerminateInvocation; // @link substring="shaderTerminateInvocation" target="#shaderTerminateInvocation"
///     VkBool32 subgroupSizeControl; // @link substring="subgroupSizeControl" target="#subgroupSizeControl"
///     VkBool32 computeFullSubgroups; // @link substring="computeFullSubgroups" target="#computeFullSubgroups"
///     VkBool32 synchronization2; // @link substring="synchronization2" target="#synchronization2"
///     VkBool32 textureCompressionASTC_HDR; // @link substring="textureCompressionASTC_HDR" target="#textureCompressionASTC_HDR"
///     VkBool32 shaderZeroInitializeWorkgroupMemory; // @link substring="shaderZeroInitializeWorkgroupMemory" target="#shaderZeroInitializeWorkgroupMemory"
///     VkBool32 dynamicRendering; // @link substring="dynamicRendering" target="#dynamicRendering"
///     VkBool32 shaderIntegerDotProduct; // @link substring="shaderIntegerDotProduct" target="#shaderIntegerDotProduct"
///     VkBool32 maintenance4; // @link substring="maintenance4" target="#maintenance4"
/// } VkPhysicalDeviceVulkan13Features;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_VULKAN_1_3_FEATURES`
///
/// The {@code allocate} ({@link VkPhysicalDeviceVulkan13Features#allocate(Arena)}, {@link VkPhysicalDeviceVulkan13Features#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceVulkan13Features#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceVulkan13Features.html"><code>VkPhysicalDeviceVulkan13Features</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceVulkan13Features(@NotNull MemorySegment segment) implements IVkPhysicalDeviceVulkan13Features {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceVulkan13Features.html"><code>VkPhysicalDeviceVulkan13Features</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceVulkan13Features}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceVulkan13Features to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceVulkan13Features.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceVulkan13Features, Iterable<VkPhysicalDeviceVulkan13Features> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceVulkan13Features.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceVulkan13Features at(long index) {
            return new VkPhysicalDeviceVulkan13Features(segment.asSlice(index * VkPhysicalDeviceVulkan13Features.BYTES, VkPhysicalDeviceVulkan13Features.BYTES));
        }

        public VkPhysicalDeviceVulkan13Features.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceVulkan13Features> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceVulkan13Features value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceVulkan13Features.BYTES, VkPhysicalDeviceVulkan13Features.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceVulkan13Features.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceVulkan13Features.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceVulkan13Features.BYTES,
                (end - start) * VkPhysicalDeviceVulkan13Features.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceVulkan13Features.BYTES));
        }

        public VkPhysicalDeviceVulkan13Features[] toArray() {
            VkPhysicalDeviceVulkan13Features[] ret = new VkPhysicalDeviceVulkan13Features[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceVulkan13Features> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceVulkan13Features> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceVulkan13Features.BYTES;
            }

            @Override
            public VkPhysicalDeviceVulkan13Features next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceVulkan13Features ret = new VkPhysicalDeviceVulkan13Features(segment.asSlice(0, VkPhysicalDeviceVulkan13Features.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceVulkan13Features.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceVulkan13Features allocate(Arena arena) {
        VkPhysicalDeviceVulkan13Features ret = new VkPhysicalDeviceVulkan13Features(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_VULKAN_1_3_FEATURES);
        return ret;
    }

    public static VkPhysicalDeviceVulkan13Features.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceVulkan13Features.Ptr ret = new VkPhysicalDeviceVulkan13Features.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_VULKAN_1_3_FEATURES);
        }
        return ret;
    }

    public static VkPhysicalDeviceVulkan13Features clone(Arena arena, VkPhysicalDeviceVulkan13Features src) {
        VkPhysicalDeviceVulkan13Features ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_VULKAN_1_3_FEATURES);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceVulkan13Features sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceVulkan13Features pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceVulkan13Features pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int robustImageAccess() {
        return segment.get(LAYOUT$robustImageAccess, OFFSET$robustImageAccess);
    }

    public VkPhysicalDeviceVulkan13Features robustImageAccess(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$robustImageAccess, OFFSET$robustImageAccess, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int inlineUniformBlock() {
        return segment.get(LAYOUT$inlineUniformBlock, OFFSET$inlineUniformBlock);
    }

    public VkPhysicalDeviceVulkan13Features inlineUniformBlock(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$inlineUniformBlock, OFFSET$inlineUniformBlock, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int descriptorBindingInlineUniformBlockUpdateAfterBind() {
        return segment.get(LAYOUT$descriptorBindingInlineUniformBlockUpdateAfterBind, OFFSET$descriptorBindingInlineUniformBlockUpdateAfterBind);
    }

    public VkPhysicalDeviceVulkan13Features descriptorBindingInlineUniformBlockUpdateAfterBind(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$descriptorBindingInlineUniformBlockUpdateAfterBind, OFFSET$descriptorBindingInlineUniformBlockUpdateAfterBind, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int pipelineCreationCacheControl() {
        return segment.get(LAYOUT$pipelineCreationCacheControl, OFFSET$pipelineCreationCacheControl);
    }

    public VkPhysicalDeviceVulkan13Features pipelineCreationCacheControl(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$pipelineCreationCacheControl, OFFSET$pipelineCreationCacheControl, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int privateData() {
        return segment.get(LAYOUT$privateData, OFFSET$privateData);
    }

    public VkPhysicalDeviceVulkan13Features privateData(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$privateData, OFFSET$privateData, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderDemoteToHelperInvocation() {
        return segment.get(LAYOUT$shaderDemoteToHelperInvocation, OFFSET$shaderDemoteToHelperInvocation);
    }

    public VkPhysicalDeviceVulkan13Features shaderDemoteToHelperInvocation(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderDemoteToHelperInvocation, OFFSET$shaderDemoteToHelperInvocation, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderTerminateInvocation() {
        return segment.get(LAYOUT$shaderTerminateInvocation, OFFSET$shaderTerminateInvocation);
    }

    public VkPhysicalDeviceVulkan13Features shaderTerminateInvocation(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderTerminateInvocation, OFFSET$shaderTerminateInvocation, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int subgroupSizeControl() {
        return segment.get(LAYOUT$subgroupSizeControl, OFFSET$subgroupSizeControl);
    }

    public VkPhysicalDeviceVulkan13Features subgroupSizeControl(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$subgroupSizeControl, OFFSET$subgroupSizeControl, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int computeFullSubgroups() {
        return segment.get(LAYOUT$computeFullSubgroups, OFFSET$computeFullSubgroups);
    }

    public VkPhysicalDeviceVulkan13Features computeFullSubgroups(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$computeFullSubgroups, OFFSET$computeFullSubgroups, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int synchronization2() {
        return segment.get(LAYOUT$synchronization2, OFFSET$synchronization2);
    }

    public VkPhysicalDeviceVulkan13Features synchronization2(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$synchronization2, OFFSET$synchronization2, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int textureCompressionASTC_HDR() {
        return segment.get(LAYOUT$textureCompressionASTC_HDR, OFFSET$textureCompressionASTC_HDR);
    }

    public VkPhysicalDeviceVulkan13Features textureCompressionASTC_HDR(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$textureCompressionASTC_HDR, OFFSET$textureCompressionASTC_HDR, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderZeroInitializeWorkgroupMemory() {
        return segment.get(LAYOUT$shaderZeroInitializeWorkgroupMemory, OFFSET$shaderZeroInitializeWorkgroupMemory);
    }

    public VkPhysicalDeviceVulkan13Features shaderZeroInitializeWorkgroupMemory(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderZeroInitializeWorkgroupMemory, OFFSET$shaderZeroInitializeWorkgroupMemory, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int dynamicRendering() {
        return segment.get(LAYOUT$dynamicRendering, OFFSET$dynamicRendering);
    }

    public VkPhysicalDeviceVulkan13Features dynamicRendering(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$dynamicRendering, OFFSET$dynamicRendering, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderIntegerDotProduct() {
        return segment.get(LAYOUT$shaderIntegerDotProduct, OFFSET$shaderIntegerDotProduct);
    }

    public VkPhysicalDeviceVulkan13Features shaderIntegerDotProduct(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderIntegerDotProduct, OFFSET$shaderIntegerDotProduct, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int maintenance4() {
        return segment.get(LAYOUT$maintenance4, OFFSET$maintenance4);
    }

    public VkPhysicalDeviceVulkan13Features maintenance4(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$maintenance4, OFFSET$maintenance4, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("robustImageAccess"),
        ValueLayout.JAVA_INT.withName("inlineUniformBlock"),
        ValueLayout.JAVA_INT.withName("descriptorBindingInlineUniformBlockUpdateAfterBind"),
        ValueLayout.JAVA_INT.withName("pipelineCreationCacheControl"),
        ValueLayout.JAVA_INT.withName("privateData"),
        ValueLayout.JAVA_INT.withName("shaderDemoteToHelperInvocation"),
        ValueLayout.JAVA_INT.withName("shaderTerminateInvocation"),
        ValueLayout.JAVA_INT.withName("subgroupSizeControl"),
        ValueLayout.JAVA_INT.withName("computeFullSubgroups"),
        ValueLayout.JAVA_INT.withName("synchronization2"),
        ValueLayout.JAVA_INT.withName("textureCompressionASTC_HDR"),
        ValueLayout.JAVA_INT.withName("shaderZeroInitializeWorkgroupMemory"),
        ValueLayout.JAVA_INT.withName("dynamicRendering"),
        ValueLayout.JAVA_INT.withName("shaderIntegerDotProduct"),
        ValueLayout.JAVA_INT.withName("maintenance4")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$robustImageAccess = PathElement.groupElement("robustImageAccess");
    public static final PathElement PATH$inlineUniformBlock = PathElement.groupElement("inlineUniformBlock");
    public static final PathElement PATH$descriptorBindingInlineUniformBlockUpdateAfterBind = PathElement.groupElement("descriptorBindingInlineUniformBlockUpdateAfterBind");
    public static final PathElement PATH$pipelineCreationCacheControl = PathElement.groupElement("pipelineCreationCacheControl");
    public static final PathElement PATH$privateData = PathElement.groupElement("privateData");
    public static final PathElement PATH$shaderDemoteToHelperInvocation = PathElement.groupElement("shaderDemoteToHelperInvocation");
    public static final PathElement PATH$shaderTerminateInvocation = PathElement.groupElement("shaderTerminateInvocation");
    public static final PathElement PATH$subgroupSizeControl = PathElement.groupElement("subgroupSizeControl");
    public static final PathElement PATH$computeFullSubgroups = PathElement.groupElement("computeFullSubgroups");
    public static final PathElement PATH$synchronization2 = PathElement.groupElement("synchronization2");
    public static final PathElement PATH$textureCompressionASTC_HDR = PathElement.groupElement("textureCompressionASTC_HDR");
    public static final PathElement PATH$shaderZeroInitializeWorkgroupMemory = PathElement.groupElement("shaderZeroInitializeWorkgroupMemory");
    public static final PathElement PATH$dynamicRendering = PathElement.groupElement("dynamicRendering");
    public static final PathElement PATH$shaderIntegerDotProduct = PathElement.groupElement("shaderIntegerDotProduct");
    public static final PathElement PATH$maintenance4 = PathElement.groupElement("maintenance4");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$robustImageAccess = (OfInt) LAYOUT.select(PATH$robustImageAccess);
    public static final OfInt LAYOUT$inlineUniformBlock = (OfInt) LAYOUT.select(PATH$inlineUniformBlock);
    public static final OfInt LAYOUT$descriptorBindingInlineUniformBlockUpdateAfterBind = (OfInt) LAYOUT.select(PATH$descriptorBindingInlineUniformBlockUpdateAfterBind);
    public static final OfInt LAYOUT$pipelineCreationCacheControl = (OfInt) LAYOUT.select(PATH$pipelineCreationCacheControl);
    public static final OfInt LAYOUT$privateData = (OfInt) LAYOUT.select(PATH$privateData);
    public static final OfInt LAYOUT$shaderDemoteToHelperInvocation = (OfInt) LAYOUT.select(PATH$shaderDemoteToHelperInvocation);
    public static final OfInt LAYOUT$shaderTerminateInvocation = (OfInt) LAYOUT.select(PATH$shaderTerminateInvocation);
    public static final OfInt LAYOUT$subgroupSizeControl = (OfInt) LAYOUT.select(PATH$subgroupSizeControl);
    public static final OfInt LAYOUT$computeFullSubgroups = (OfInt) LAYOUT.select(PATH$computeFullSubgroups);
    public static final OfInt LAYOUT$synchronization2 = (OfInt) LAYOUT.select(PATH$synchronization2);
    public static final OfInt LAYOUT$textureCompressionASTC_HDR = (OfInt) LAYOUT.select(PATH$textureCompressionASTC_HDR);
    public static final OfInt LAYOUT$shaderZeroInitializeWorkgroupMemory = (OfInt) LAYOUT.select(PATH$shaderZeroInitializeWorkgroupMemory);
    public static final OfInt LAYOUT$dynamicRendering = (OfInt) LAYOUT.select(PATH$dynamicRendering);
    public static final OfInt LAYOUT$shaderIntegerDotProduct = (OfInt) LAYOUT.select(PATH$shaderIntegerDotProduct);
    public static final OfInt LAYOUT$maintenance4 = (OfInt) LAYOUT.select(PATH$maintenance4);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$robustImageAccess = LAYOUT$robustImageAccess.byteSize();
    public static final long SIZE$inlineUniformBlock = LAYOUT$inlineUniformBlock.byteSize();
    public static final long SIZE$descriptorBindingInlineUniformBlockUpdateAfterBind = LAYOUT$descriptorBindingInlineUniformBlockUpdateAfterBind.byteSize();
    public static final long SIZE$pipelineCreationCacheControl = LAYOUT$pipelineCreationCacheControl.byteSize();
    public static final long SIZE$privateData = LAYOUT$privateData.byteSize();
    public static final long SIZE$shaderDemoteToHelperInvocation = LAYOUT$shaderDemoteToHelperInvocation.byteSize();
    public static final long SIZE$shaderTerminateInvocation = LAYOUT$shaderTerminateInvocation.byteSize();
    public static final long SIZE$subgroupSizeControl = LAYOUT$subgroupSizeControl.byteSize();
    public static final long SIZE$computeFullSubgroups = LAYOUT$computeFullSubgroups.byteSize();
    public static final long SIZE$synchronization2 = LAYOUT$synchronization2.byteSize();
    public static final long SIZE$textureCompressionASTC_HDR = LAYOUT$textureCompressionASTC_HDR.byteSize();
    public static final long SIZE$shaderZeroInitializeWorkgroupMemory = LAYOUT$shaderZeroInitializeWorkgroupMemory.byteSize();
    public static final long SIZE$dynamicRendering = LAYOUT$dynamicRendering.byteSize();
    public static final long SIZE$shaderIntegerDotProduct = LAYOUT$shaderIntegerDotProduct.byteSize();
    public static final long SIZE$maintenance4 = LAYOUT$maintenance4.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$robustImageAccess = LAYOUT.byteOffset(PATH$robustImageAccess);
    public static final long OFFSET$inlineUniformBlock = LAYOUT.byteOffset(PATH$inlineUniformBlock);
    public static final long OFFSET$descriptorBindingInlineUniformBlockUpdateAfterBind = LAYOUT.byteOffset(PATH$descriptorBindingInlineUniformBlockUpdateAfterBind);
    public static final long OFFSET$pipelineCreationCacheControl = LAYOUT.byteOffset(PATH$pipelineCreationCacheControl);
    public static final long OFFSET$privateData = LAYOUT.byteOffset(PATH$privateData);
    public static final long OFFSET$shaderDemoteToHelperInvocation = LAYOUT.byteOffset(PATH$shaderDemoteToHelperInvocation);
    public static final long OFFSET$shaderTerminateInvocation = LAYOUT.byteOffset(PATH$shaderTerminateInvocation);
    public static final long OFFSET$subgroupSizeControl = LAYOUT.byteOffset(PATH$subgroupSizeControl);
    public static final long OFFSET$computeFullSubgroups = LAYOUT.byteOffset(PATH$computeFullSubgroups);
    public static final long OFFSET$synchronization2 = LAYOUT.byteOffset(PATH$synchronization2);
    public static final long OFFSET$textureCompressionASTC_HDR = LAYOUT.byteOffset(PATH$textureCompressionASTC_HDR);
    public static final long OFFSET$shaderZeroInitializeWorkgroupMemory = LAYOUT.byteOffset(PATH$shaderZeroInitializeWorkgroupMemory);
    public static final long OFFSET$dynamicRendering = LAYOUT.byteOffset(PATH$dynamicRendering);
    public static final long OFFSET$shaderIntegerDotProduct = LAYOUT.byteOffset(PATH$shaderIntegerDotProduct);
    public static final long OFFSET$maintenance4 = LAYOUT.byteOffset(PATH$maintenance4);
}
