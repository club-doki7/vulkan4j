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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceDescriptorBufferPropertiesEXT.html"><code>VkPhysicalDeviceDescriptorBufferPropertiesEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceDescriptorBufferPropertiesEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 combinedImageSamplerDescriptorSingleArray; // @link substring="combinedImageSamplerDescriptorSingleArray" target="#combinedImageSamplerDescriptorSingleArray"
///     VkBool32 bufferlessPushDescriptors; // @link substring="bufferlessPushDescriptors" target="#bufferlessPushDescriptors"
///     VkBool32 allowSamplerImageViewPostSubmitCreation; // @link substring="allowSamplerImageViewPostSubmitCreation" target="#allowSamplerImageViewPostSubmitCreation"
///     VkDeviceSize descriptorBufferOffsetAlignment; // @link substring="descriptorBufferOffsetAlignment" target="#descriptorBufferOffsetAlignment"
///     uint32_t maxDescriptorBufferBindings; // @link substring="maxDescriptorBufferBindings" target="#maxDescriptorBufferBindings"
///     uint32_t maxResourceDescriptorBufferBindings; // @link substring="maxResourceDescriptorBufferBindings" target="#maxResourceDescriptorBufferBindings"
///     uint32_t maxSamplerDescriptorBufferBindings; // @link substring="maxSamplerDescriptorBufferBindings" target="#maxSamplerDescriptorBufferBindings"
///     uint32_t maxEmbeddedImmutableSamplerBindings; // @link substring="maxEmbeddedImmutableSamplerBindings" target="#maxEmbeddedImmutableSamplerBindings"
///     uint32_t maxEmbeddedImmutableSamplers; // @link substring="maxEmbeddedImmutableSamplers" target="#maxEmbeddedImmutableSamplers"
///     size_t bufferCaptureReplayDescriptorDataSize; // @link substring="bufferCaptureReplayDescriptorDataSize" target="#bufferCaptureReplayDescriptorDataSize"
///     size_t imageCaptureReplayDescriptorDataSize; // @link substring="imageCaptureReplayDescriptorDataSize" target="#imageCaptureReplayDescriptorDataSize"
///     size_t imageViewCaptureReplayDescriptorDataSize; // @link substring="imageViewCaptureReplayDescriptorDataSize" target="#imageViewCaptureReplayDescriptorDataSize"
///     size_t samplerCaptureReplayDescriptorDataSize; // @link substring="samplerCaptureReplayDescriptorDataSize" target="#samplerCaptureReplayDescriptorDataSize"
///     size_t accelerationStructureCaptureReplayDescriptorDataSize; // @link substring="accelerationStructureCaptureReplayDescriptorDataSize" target="#accelerationStructureCaptureReplayDescriptorDataSize"
///     size_t samplerDescriptorSize; // @link substring="samplerDescriptorSize" target="#samplerDescriptorSize"
///     size_t combinedImageSamplerDescriptorSize; // @link substring="combinedImageSamplerDescriptorSize" target="#combinedImageSamplerDescriptorSize"
///     size_t sampledImageDescriptorSize; // @link substring="sampledImageDescriptorSize" target="#sampledImageDescriptorSize"
///     size_t storageImageDescriptorSize; // @link substring="storageImageDescriptorSize" target="#storageImageDescriptorSize"
///     size_t uniformTexelBufferDescriptorSize; // @link substring="uniformTexelBufferDescriptorSize" target="#uniformTexelBufferDescriptorSize"
///     size_t robustUniformTexelBufferDescriptorSize; // @link substring="robustUniformTexelBufferDescriptorSize" target="#robustUniformTexelBufferDescriptorSize"
///     size_t storageTexelBufferDescriptorSize; // @link substring="storageTexelBufferDescriptorSize" target="#storageTexelBufferDescriptorSize"
///     size_t robustStorageTexelBufferDescriptorSize; // @link substring="robustStorageTexelBufferDescriptorSize" target="#robustStorageTexelBufferDescriptorSize"
///     size_t uniformBufferDescriptorSize; // @link substring="uniformBufferDescriptorSize" target="#uniformBufferDescriptorSize"
///     size_t robustUniformBufferDescriptorSize; // @link substring="robustUniformBufferDescriptorSize" target="#robustUniformBufferDescriptorSize"
///     size_t storageBufferDescriptorSize; // @link substring="storageBufferDescriptorSize" target="#storageBufferDescriptorSize"
///     size_t robustStorageBufferDescriptorSize; // @link substring="robustStorageBufferDescriptorSize" target="#robustStorageBufferDescriptorSize"
///     size_t inputAttachmentDescriptorSize; // @link substring="inputAttachmentDescriptorSize" target="#inputAttachmentDescriptorSize"
///     size_t accelerationStructureDescriptorSize; // @link substring="accelerationStructureDescriptorSize" target="#accelerationStructureDescriptorSize"
///     VkDeviceSize maxSamplerDescriptorBufferRange; // @link substring="maxSamplerDescriptorBufferRange" target="#maxSamplerDescriptorBufferRange"
///     VkDeviceSize maxResourceDescriptorBufferRange; // @link substring="maxResourceDescriptorBufferRange" target="#maxResourceDescriptorBufferRange"
///     VkDeviceSize samplerDescriptorBufferAddressSpaceSize; // @link substring="samplerDescriptorBufferAddressSpaceSize" target="#samplerDescriptorBufferAddressSpaceSize"
///     VkDeviceSize resourceDescriptorBufferAddressSpaceSize; // @link substring="resourceDescriptorBufferAddressSpaceSize" target="#resourceDescriptorBufferAddressSpaceSize"
///     VkDeviceSize descriptorBufferAddressSpaceSize; // @link substring="descriptorBufferAddressSpaceSize" target="#descriptorBufferAddressSpaceSize"
/// } VkPhysicalDeviceDescriptorBufferPropertiesEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_DESCRIPTOR_BUFFER_PROPERTIES_EXT`
///
/// The {@code allocate} ({@link VkPhysicalDeviceDescriptorBufferPropertiesEXT#allocate(Arena)}, {@link VkPhysicalDeviceDescriptorBufferPropertiesEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceDescriptorBufferPropertiesEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceDescriptorBufferPropertiesEXT.html"><code>VkPhysicalDeviceDescriptorBufferPropertiesEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceDescriptorBufferPropertiesEXT(@NotNull MemorySegment segment) implements IVkPhysicalDeviceDescriptorBufferPropertiesEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceDescriptorBufferPropertiesEXT.html"><code>VkPhysicalDeviceDescriptorBufferPropertiesEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceDescriptorBufferPropertiesEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceDescriptorBufferPropertiesEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceDescriptorBufferPropertiesEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceDescriptorBufferPropertiesEXT, Iterable<VkPhysicalDeviceDescriptorBufferPropertiesEXT> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceDescriptorBufferPropertiesEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceDescriptorBufferPropertiesEXT at(long index) {
            return new VkPhysicalDeviceDescriptorBufferPropertiesEXT(segment.asSlice(index * VkPhysicalDeviceDescriptorBufferPropertiesEXT.BYTES, VkPhysicalDeviceDescriptorBufferPropertiesEXT.BYTES));
        }

        public VkPhysicalDeviceDescriptorBufferPropertiesEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceDescriptorBufferPropertiesEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceDescriptorBufferPropertiesEXT value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceDescriptorBufferPropertiesEXT.BYTES, VkPhysicalDeviceDescriptorBufferPropertiesEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceDescriptorBufferPropertiesEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceDescriptorBufferPropertiesEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceDescriptorBufferPropertiesEXT.BYTES,
                (end - start) * VkPhysicalDeviceDescriptorBufferPropertiesEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceDescriptorBufferPropertiesEXT.BYTES));
        }

        public VkPhysicalDeviceDescriptorBufferPropertiesEXT[] toArray() {
            VkPhysicalDeviceDescriptorBufferPropertiesEXT[] ret = new VkPhysicalDeviceDescriptorBufferPropertiesEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceDescriptorBufferPropertiesEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceDescriptorBufferPropertiesEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceDescriptorBufferPropertiesEXT.BYTES;
            }

            @Override
            public VkPhysicalDeviceDescriptorBufferPropertiesEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceDescriptorBufferPropertiesEXT ret = new VkPhysicalDeviceDescriptorBufferPropertiesEXT(segment.asSlice(0, VkPhysicalDeviceDescriptorBufferPropertiesEXT.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceDescriptorBufferPropertiesEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceDescriptorBufferPropertiesEXT allocate(Arena arena) {
        VkPhysicalDeviceDescriptorBufferPropertiesEXT ret = new VkPhysicalDeviceDescriptorBufferPropertiesEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_DESCRIPTOR_BUFFER_PROPERTIES_EXT);
        return ret;
    }

    public static VkPhysicalDeviceDescriptorBufferPropertiesEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceDescriptorBufferPropertiesEXT.Ptr ret = new VkPhysicalDeviceDescriptorBufferPropertiesEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_DESCRIPTOR_BUFFER_PROPERTIES_EXT);
        }
        return ret;
    }

    public static VkPhysicalDeviceDescriptorBufferPropertiesEXT clone(Arena arena, VkPhysicalDeviceDescriptorBufferPropertiesEXT src) {
        VkPhysicalDeviceDescriptorBufferPropertiesEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_DESCRIPTOR_BUFFER_PROPERTIES_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceDescriptorBufferPropertiesEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceDescriptorBufferPropertiesEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceDescriptorBufferPropertiesEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int combinedImageSamplerDescriptorSingleArray() {
        return segment.get(LAYOUT$combinedImageSamplerDescriptorSingleArray, OFFSET$combinedImageSamplerDescriptorSingleArray);
    }

    public VkPhysicalDeviceDescriptorBufferPropertiesEXT combinedImageSamplerDescriptorSingleArray(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$combinedImageSamplerDescriptorSingleArray, OFFSET$combinedImageSamplerDescriptorSingleArray, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int bufferlessPushDescriptors() {
        return segment.get(LAYOUT$bufferlessPushDescriptors, OFFSET$bufferlessPushDescriptors);
    }

    public VkPhysicalDeviceDescriptorBufferPropertiesEXT bufferlessPushDescriptors(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$bufferlessPushDescriptors, OFFSET$bufferlessPushDescriptors, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int allowSamplerImageViewPostSubmitCreation() {
        return segment.get(LAYOUT$allowSamplerImageViewPostSubmitCreation, OFFSET$allowSamplerImageViewPostSubmitCreation);
    }

    public VkPhysicalDeviceDescriptorBufferPropertiesEXT allowSamplerImageViewPostSubmitCreation(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$allowSamplerImageViewPostSubmitCreation, OFFSET$allowSamplerImageViewPostSubmitCreation, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long descriptorBufferOffsetAlignment() {
        return segment.get(LAYOUT$descriptorBufferOffsetAlignment, OFFSET$descriptorBufferOffsetAlignment);
    }

    public VkPhysicalDeviceDescriptorBufferPropertiesEXT descriptorBufferOffsetAlignment(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$descriptorBufferOffsetAlignment, OFFSET$descriptorBufferOffsetAlignment, value);
        return this;
    }

    public @Unsigned int maxDescriptorBufferBindings() {
        return segment.get(LAYOUT$maxDescriptorBufferBindings, OFFSET$maxDescriptorBufferBindings);
    }

    public VkPhysicalDeviceDescriptorBufferPropertiesEXT maxDescriptorBufferBindings(@Unsigned int value) {
        segment.set(LAYOUT$maxDescriptorBufferBindings, OFFSET$maxDescriptorBufferBindings, value);
        return this;
    }

    public @Unsigned int maxResourceDescriptorBufferBindings() {
        return segment.get(LAYOUT$maxResourceDescriptorBufferBindings, OFFSET$maxResourceDescriptorBufferBindings);
    }

    public VkPhysicalDeviceDescriptorBufferPropertiesEXT maxResourceDescriptorBufferBindings(@Unsigned int value) {
        segment.set(LAYOUT$maxResourceDescriptorBufferBindings, OFFSET$maxResourceDescriptorBufferBindings, value);
        return this;
    }

    public @Unsigned int maxSamplerDescriptorBufferBindings() {
        return segment.get(LAYOUT$maxSamplerDescriptorBufferBindings, OFFSET$maxSamplerDescriptorBufferBindings);
    }

    public VkPhysicalDeviceDescriptorBufferPropertiesEXT maxSamplerDescriptorBufferBindings(@Unsigned int value) {
        segment.set(LAYOUT$maxSamplerDescriptorBufferBindings, OFFSET$maxSamplerDescriptorBufferBindings, value);
        return this;
    }

    public @Unsigned int maxEmbeddedImmutableSamplerBindings() {
        return segment.get(LAYOUT$maxEmbeddedImmutableSamplerBindings, OFFSET$maxEmbeddedImmutableSamplerBindings);
    }

    public VkPhysicalDeviceDescriptorBufferPropertiesEXT maxEmbeddedImmutableSamplerBindings(@Unsigned int value) {
        segment.set(LAYOUT$maxEmbeddedImmutableSamplerBindings, OFFSET$maxEmbeddedImmutableSamplerBindings, value);
        return this;
    }

    public @Unsigned int maxEmbeddedImmutableSamplers() {
        return segment.get(LAYOUT$maxEmbeddedImmutableSamplers, OFFSET$maxEmbeddedImmutableSamplers);
    }

    public VkPhysicalDeviceDescriptorBufferPropertiesEXT maxEmbeddedImmutableSamplers(@Unsigned int value) {
        segment.set(LAYOUT$maxEmbeddedImmutableSamplers, OFFSET$maxEmbeddedImmutableSamplers, value);
        return this;
    }

    public @Unsigned long bufferCaptureReplayDescriptorDataSize() {
        return NativeLayout.readCSizeT(segment, OFFSET$bufferCaptureReplayDescriptorDataSize);
    }

    public VkPhysicalDeviceDescriptorBufferPropertiesEXT bufferCaptureReplayDescriptorDataSize(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$bufferCaptureReplayDescriptorDataSize, value);
        return this;
    }

    public @Unsigned long imageCaptureReplayDescriptorDataSize() {
        return NativeLayout.readCSizeT(segment, OFFSET$imageCaptureReplayDescriptorDataSize);
    }

    public VkPhysicalDeviceDescriptorBufferPropertiesEXT imageCaptureReplayDescriptorDataSize(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$imageCaptureReplayDescriptorDataSize, value);
        return this;
    }

    public @Unsigned long imageViewCaptureReplayDescriptorDataSize() {
        return NativeLayout.readCSizeT(segment, OFFSET$imageViewCaptureReplayDescriptorDataSize);
    }

    public VkPhysicalDeviceDescriptorBufferPropertiesEXT imageViewCaptureReplayDescriptorDataSize(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$imageViewCaptureReplayDescriptorDataSize, value);
        return this;
    }

    public @Unsigned long samplerCaptureReplayDescriptorDataSize() {
        return NativeLayout.readCSizeT(segment, OFFSET$samplerCaptureReplayDescriptorDataSize);
    }

    public VkPhysicalDeviceDescriptorBufferPropertiesEXT samplerCaptureReplayDescriptorDataSize(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$samplerCaptureReplayDescriptorDataSize, value);
        return this;
    }

    public @Unsigned long accelerationStructureCaptureReplayDescriptorDataSize() {
        return NativeLayout.readCSizeT(segment, OFFSET$accelerationStructureCaptureReplayDescriptorDataSize);
    }

    public VkPhysicalDeviceDescriptorBufferPropertiesEXT accelerationStructureCaptureReplayDescriptorDataSize(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$accelerationStructureCaptureReplayDescriptorDataSize, value);
        return this;
    }

    public @Unsigned long samplerDescriptorSize() {
        return NativeLayout.readCSizeT(segment, OFFSET$samplerDescriptorSize);
    }

    public VkPhysicalDeviceDescriptorBufferPropertiesEXT samplerDescriptorSize(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$samplerDescriptorSize, value);
        return this;
    }

    public @Unsigned long combinedImageSamplerDescriptorSize() {
        return NativeLayout.readCSizeT(segment, OFFSET$combinedImageSamplerDescriptorSize);
    }

    public VkPhysicalDeviceDescriptorBufferPropertiesEXT combinedImageSamplerDescriptorSize(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$combinedImageSamplerDescriptorSize, value);
        return this;
    }

    public @Unsigned long sampledImageDescriptorSize() {
        return NativeLayout.readCSizeT(segment, OFFSET$sampledImageDescriptorSize);
    }

    public VkPhysicalDeviceDescriptorBufferPropertiesEXT sampledImageDescriptorSize(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$sampledImageDescriptorSize, value);
        return this;
    }

    public @Unsigned long storageImageDescriptorSize() {
        return NativeLayout.readCSizeT(segment, OFFSET$storageImageDescriptorSize);
    }

    public VkPhysicalDeviceDescriptorBufferPropertiesEXT storageImageDescriptorSize(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$storageImageDescriptorSize, value);
        return this;
    }

    public @Unsigned long uniformTexelBufferDescriptorSize() {
        return NativeLayout.readCSizeT(segment, OFFSET$uniformTexelBufferDescriptorSize);
    }

    public VkPhysicalDeviceDescriptorBufferPropertiesEXT uniformTexelBufferDescriptorSize(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$uniformTexelBufferDescriptorSize, value);
        return this;
    }

    public @Unsigned long robustUniformTexelBufferDescriptorSize() {
        return NativeLayout.readCSizeT(segment, OFFSET$robustUniformTexelBufferDescriptorSize);
    }

    public VkPhysicalDeviceDescriptorBufferPropertiesEXT robustUniformTexelBufferDescriptorSize(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$robustUniformTexelBufferDescriptorSize, value);
        return this;
    }

    public @Unsigned long storageTexelBufferDescriptorSize() {
        return NativeLayout.readCSizeT(segment, OFFSET$storageTexelBufferDescriptorSize);
    }

    public VkPhysicalDeviceDescriptorBufferPropertiesEXT storageTexelBufferDescriptorSize(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$storageTexelBufferDescriptorSize, value);
        return this;
    }

    public @Unsigned long robustStorageTexelBufferDescriptorSize() {
        return NativeLayout.readCSizeT(segment, OFFSET$robustStorageTexelBufferDescriptorSize);
    }

    public VkPhysicalDeviceDescriptorBufferPropertiesEXT robustStorageTexelBufferDescriptorSize(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$robustStorageTexelBufferDescriptorSize, value);
        return this;
    }

    public @Unsigned long uniformBufferDescriptorSize() {
        return NativeLayout.readCSizeT(segment, OFFSET$uniformBufferDescriptorSize);
    }

    public VkPhysicalDeviceDescriptorBufferPropertiesEXT uniformBufferDescriptorSize(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$uniformBufferDescriptorSize, value);
        return this;
    }

    public @Unsigned long robustUniformBufferDescriptorSize() {
        return NativeLayout.readCSizeT(segment, OFFSET$robustUniformBufferDescriptorSize);
    }

    public VkPhysicalDeviceDescriptorBufferPropertiesEXT robustUniformBufferDescriptorSize(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$robustUniformBufferDescriptorSize, value);
        return this;
    }

    public @Unsigned long storageBufferDescriptorSize() {
        return NativeLayout.readCSizeT(segment, OFFSET$storageBufferDescriptorSize);
    }

    public VkPhysicalDeviceDescriptorBufferPropertiesEXT storageBufferDescriptorSize(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$storageBufferDescriptorSize, value);
        return this;
    }

    public @Unsigned long robustStorageBufferDescriptorSize() {
        return NativeLayout.readCSizeT(segment, OFFSET$robustStorageBufferDescriptorSize);
    }

    public VkPhysicalDeviceDescriptorBufferPropertiesEXT robustStorageBufferDescriptorSize(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$robustStorageBufferDescriptorSize, value);
        return this;
    }

    public @Unsigned long inputAttachmentDescriptorSize() {
        return NativeLayout.readCSizeT(segment, OFFSET$inputAttachmentDescriptorSize);
    }

    public VkPhysicalDeviceDescriptorBufferPropertiesEXT inputAttachmentDescriptorSize(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$inputAttachmentDescriptorSize, value);
        return this;
    }

    public @Unsigned long accelerationStructureDescriptorSize() {
        return NativeLayout.readCSizeT(segment, OFFSET$accelerationStructureDescriptorSize);
    }

    public VkPhysicalDeviceDescriptorBufferPropertiesEXT accelerationStructureDescriptorSize(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$accelerationStructureDescriptorSize, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long maxSamplerDescriptorBufferRange() {
        return segment.get(LAYOUT$maxSamplerDescriptorBufferRange, OFFSET$maxSamplerDescriptorBufferRange);
    }

    public VkPhysicalDeviceDescriptorBufferPropertiesEXT maxSamplerDescriptorBufferRange(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$maxSamplerDescriptorBufferRange, OFFSET$maxSamplerDescriptorBufferRange, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long maxResourceDescriptorBufferRange() {
        return segment.get(LAYOUT$maxResourceDescriptorBufferRange, OFFSET$maxResourceDescriptorBufferRange);
    }

    public VkPhysicalDeviceDescriptorBufferPropertiesEXT maxResourceDescriptorBufferRange(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$maxResourceDescriptorBufferRange, OFFSET$maxResourceDescriptorBufferRange, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long samplerDescriptorBufferAddressSpaceSize() {
        return segment.get(LAYOUT$samplerDescriptorBufferAddressSpaceSize, OFFSET$samplerDescriptorBufferAddressSpaceSize);
    }

    public VkPhysicalDeviceDescriptorBufferPropertiesEXT samplerDescriptorBufferAddressSpaceSize(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$samplerDescriptorBufferAddressSpaceSize, OFFSET$samplerDescriptorBufferAddressSpaceSize, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long resourceDescriptorBufferAddressSpaceSize() {
        return segment.get(LAYOUT$resourceDescriptorBufferAddressSpaceSize, OFFSET$resourceDescriptorBufferAddressSpaceSize);
    }

    public VkPhysicalDeviceDescriptorBufferPropertiesEXT resourceDescriptorBufferAddressSpaceSize(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$resourceDescriptorBufferAddressSpaceSize, OFFSET$resourceDescriptorBufferAddressSpaceSize, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long descriptorBufferAddressSpaceSize() {
        return segment.get(LAYOUT$descriptorBufferAddressSpaceSize, OFFSET$descriptorBufferAddressSpaceSize);
    }

    public VkPhysicalDeviceDescriptorBufferPropertiesEXT descriptorBufferAddressSpaceSize(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$descriptorBufferAddressSpaceSize, OFFSET$descriptorBufferAddressSpaceSize, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("combinedImageSamplerDescriptorSingleArray"),
        ValueLayout.JAVA_INT.withName("bufferlessPushDescriptors"),
        ValueLayout.JAVA_INT.withName("allowSamplerImageViewPostSubmitCreation"),
        ValueLayout.JAVA_LONG.withName("descriptorBufferOffsetAlignment"),
        ValueLayout.JAVA_INT.withName("maxDescriptorBufferBindings"),
        ValueLayout.JAVA_INT.withName("maxResourceDescriptorBufferBindings"),
        ValueLayout.JAVA_INT.withName("maxSamplerDescriptorBufferBindings"),
        ValueLayout.JAVA_INT.withName("maxEmbeddedImmutableSamplerBindings"),
        ValueLayout.JAVA_INT.withName("maxEmbeddedImmutableSamplers"),
        NativeLayout.C_SIZE_T.withName("bufferCaptureReplayDescriptorDataSize"),
        NativeLayout.C_SIZE_T.withName("imageCaptureReplayDescriptorDataSize"),
        NativeLayout.C_SIZE_T.withName("imageViewCaptureReplayDescriptorDataSize"),
        NativeLayout.C_SIZE_T.withName("samplerCaptureReplayDescriptorDataSize"),
        NativeLayout.C_SIZE_T.withName("accelerationStructureCaptureReplayDescriptorDataSize"),
        NativeLayout.C_SIZE_T.withName("samplerDescriptorSize"),
        NativeLayout.C_SIZE_T.withName("combinedImageSamplerDescriptorSize"),
        NativeLayout.C_SIZE_T.withName("sampledImageDescriptorSize"),
        NativeLayout.C_SIZE_T.withName("storageImageDescriptorSize"),
        NativeLayout.C_SIZE_T.withName("uniformTexelBufferDescriptorSize"),
        NativeLayout.C_SIZE_T.withName("robustUniformTexelBufferDescriptorSize"),
        NativeLayout.C_SIZE_T.withName("storageTexelBufferDescriptorSize"),
        NativeLayout.C_SIZE_T.withName("robustStorageTexelBufferDescriptorSize"),
        NativeLayout.C_SIZE_T.withName("uniformBufferDescriptorSize"),
        NativeLayout.C_SIZE_T.withName("robustUniformBufferDescriptorSize"),
        NativeLayout.C_SIZE_T.withName("storageBufferDescriptorSize"),
        NativeLayout.C_SIZE_T.withName("robustStorageBufferDescriptorSize"),
        NativeLayout.C_SIZE_T.withName("inputAttachmentDescriptorSize"),
        NativeLayout.C_SIZE_T.withName("accelerationStructureDescriptorSize"),
        ValueLayout.JAVA_LONG.withName("maxSamplerDescriptorBufferRange"),
        ValueLayout.JAVA_LONG.withName("maxResourceDescriptorBufferRange"),
        ValueLayout.JAVA_LONG.withName("samplerDescriptorBufferAddressSpaceSize"),
        ValueLayout.JAVA_LONG.withName("resourceDescriptorBufferAddressSpaceSize"),
        ValueLayout.JAVA_LONG.withName("descriptorBufferAddressSpaceSize")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$combinedImageSamplerDescriptorSingleArray = PathElement.groupElement("combinedImageSamplerDescriptorSingleArray");
    public static final PathElement PATH$bufferlessPushDescriptors = PathElement.groupElement("bufferlessPushDescriptors");
    public static final PathElement PATH$allowSamplerImageViewPostSubmitCreation = PathElement.groupElement("allowSamplerImageViewPostSubmitCreation");
    public static final PathElement PATH$descriptorBufferOffsetAlignment = PathElement.groupElement("descriptorBufferOffsetAlignment");
    public static final PathElement PATH$maxDescriptorBufferBindings = PathElement.groupElement("maxDescriptorBufferBindings");
    public static final PathElement PATH$maxResourceDescriptorBufferBindings = PathElement.groupElement("maxResourceDescriptorBufferBindings");
    public static final PathElement PATH$maxSamplerDescriptorBufferBindings = PathElement.groupElement("maxSamplerDescriptorBufferBindings");
    public static final PathElement PATH$maxEmbeddedImmutableSamplerBindings = PathElement.groupElement("maxEmbeddedImmutableSamplerBindings");
    public static final PathElement PATH$maxEmbeddedImmutableSamplers = PathElement.groupElement("maxEmbeddedImmutableSamplers");
    public static final PathElement PATH$bufferCaptureReplayDescriptorDataSize = PathElement.groupElement("bufferCaptureReplayDescriptorDataSize");
    public static final PathElement PATH$imageCaptureReplayDescriptorDataSize = PathElement.groupElement("imageCaptureReplayDescriptorDataSize");
    public static final PathElement PATH$imageViewCaptureReplayDescriptorDataSize = PathElement.groupElement("imageViewCaptureReplayDescriptorDataSize");
    public static final PathElement PATH$samplerCaptureReplayDescriptorDataSize = PathElement.groupElement("samplerCaptureReplayDescriptorDataSize");
    public static final PathElement PATH$accelerationStructureCaptureReplayDescriptorDataSize = PathElement.groupElement("accelerationStructureCaptureReplayDescriptorDataSize");
    public static final PathElement PATH$samplerDescriptorSize = PathElement.groupElement("samplerDescriptorSize");
    public static final PathElement PATH$combinedImageSamplerDescriptorSize = PathElement.groupElement("combinedImageSamplerDescriptorSize");
    public static final PathElement PATH$sampledImageDescriptorSize = PathElement.groupElement("sampledImageDescriptorSize");
    public static final PathElement PATH$storageImageDescriptorSize = PathElement.groupElement("storageImageDescriptorSize");
    public static final PathElement PATH$uniformTexelBufferDescriptorSize = PathElement.groupElement("uniformTexelBufferDescriptorSize");
    public static final PathElement PATH$robustUniformTexelBufferDescriptorSize = PathElement.groupElement("robustUniformTexelBufferDescriptorSize");
    public static final PathElement PATH$storageTexelBufferDescriptorSize = PathElement.groupElement("storageTexelBufferDescriptorSize");
    public static final PathElement PATH$robustStorageTexelBufferDescriptorSize = PathElement.groupElement("robustStorageTexelBufferDescriptorSize");
    public static final PathElement PATH$uniformBufferDescriptorSize = PathElement.groupElement("uniformBufferDescriptorSize");
    public static final PathElement PATH$robustUniformBufferDescriptorSize = PathElement.groupElement("robustUniformBufferDescriptorSize");
    public static final PathElement PATH$storageBufferDescriptorSize = PathElement.groupElement("storageBufferDescriptorSize");
    public static final PathElement PATH$robustStorageBufferDescriptorSize = PathElement.groupElement("robustStorageBufferDescriptorSize");
    public static final PathElement PATH$inputAttachmentDescriptorSize = PathElement.groupElement("inputAttachmentDescriptorSize");
    public static final PathElement PATH$accelerationStructureDescriptorSize = PathElement.groupElement("accelerationStructureDescriptorSize");
    public static final PathElement PATH$maxSamplerDescriptorBufferRange = PathElement.groupElement("maxSamplerDescriptorBufferRange");
    public static final PathElement PATH$maxResourceDescriptorBufferRange = PathElement.groupElement("maxResourceDescriptorBufferRange");
    public static final PathElement PATH$samplerDescriptorBufferAddressSpaceSize = PathElement.groupElement("samplerDescriptorBufferAddressSpaceSize");
    public static final PathElement PATH$resourceDescriptorBufferAddressSpaceSize = PathElement.groupElement("resourceDescriptorBufferAddressSpaceSize");
    public static final PathElement PATH$descriptorBufferAddressSpaceSize = PathElement.groupElement("descriptorBufferAddressSpaceSize");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$combinedImageSamplerDescriptorSingleArray = (OfInt) LAYOUT.select(PATH$combinedImageSamplerDescriptorSingleArray);
    public static final OfInt LAYOUT$bufferlessPushDescriptors = (OfInt) LAYOUT.select(PATH$bufferlessPushDescriptors);
    public static final OfInt LAYOUT$allowSamplerImageViewPostSubmitCreation = (OfInt) LAYOUT.select(PATH$allowSamplerImageViewPostSubmitCreation);
    public static final OfLong LAYOUT$descriptorBufferOffsetAlignment = (OfLong) LAYOUT.select(PATH$descriptorBufferOffsetAlignment);
    public static final OfInt LAYOUT$maxDescriptorBufferBindings = (OfInt) LAYOUT.select(PATH$maxDescriptorBufferBindings);
    public static final OfInt LAYOUT$maxResourceDescriptorBufferBindings = (OfInt) LAYOUT.select(PATH$maxResourceDescriptorBufferBindings);
    public static final OfInt LAYOUT$maxSamplerDescriptorBufferBindings = (OfInt) LAYOUT.select(PATH$maxSamplerDescriptorBufferBindings);
    public static final OfInt LAYOUT$maxEmbeddedImmutableSamplerBindings = (OfInt) LAYOUT.select(PATH$maxEmbeddedImmutableSamplerBindings);
    public static final OfInt LAYOUT$maxEmbeddedImmutableSamplers = (OfInt) LAYOUT.select(PATH$maxEmbeddedImmutableSamplers);
    public static final OfLong LAYOUT$maxSamplerDescriptorBufferRange = (OfLong) LAYOUT.select(PATH$maxSamplerDescriptorBufferRange);
    public static final OfLong LAYOUT$maxResourceDescriptorBufferRange = (OfLong) LAYOUT.select(PATH$maxResourceDescriptorBufferRange);
    public static final OfLong LAYOUT$samplerDescriptorBufferAddressSpaceSize = (OfLong) LAYOUT.select(PATH$samplerDescriptorBufferAddressSpaceSize);
    public static final OfLong LAYOUT$resourceDescriptorBufferAddressSpaceSize = (OfLong) LAYOUT.select(PATH$resourceDescriptorBufferAddressSpaceSize);
    public static final OfLong LAYOUT$descriptorBufferAddressSpaceSize = (OfLong) LAYOUT.select(PATH$descriptorBufferAddressSpaceSize);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$combinedImageSamplerDescriptorSingleArray = LAYOUT$combinedImageSamplerDescriptorSingleArray.byteSize();
    public static final long SIZE$bufferlessPushDescriptors = LAYOUT$bufferlessPushDescriptors.byteSize();
    public static final long SIZE$allowSamplerImageViewPostSubmitCreation = LAYOUT$allowSamplerImageViewPostSubmitCreation.byteSize();
    public static final long SIZE$descriptorBufferOffsetAlignment = LAYOUT$descriptorBufferOffsetAlignment.byteSize();
    public static final long SIZE$maxDescriptorBufferBindings = LAYOUT$maxDescriptorBufferBindings.byteSize();
    public static final long SIZE$maxResourceDescriptorBufferBindings = LAYOUT$maxResourceDescriptorBufferBindings.byteSize();
    public static final long SIZE$maxSamplerDescriptorBufferBindings = LAYOUT$maxSamplerDescriptorBufferBindings.byteSize();
    public static final long SIZE$maxEmbeddedImmutableSamplerBindings = LAYOUT$maxEmbeddedImmutableSamplerBindings.byteSize();
    public static final long SIZE$maxEmbeddedImmutableSamplers = LAYOUT$maxEmbeddedImmutableSamplers.byteSize();
    public static final long SIZE$bufferCaptureReplayDescriptorDataSize = NativeLayout.C_SIZE_T.byteSize();
    public static final long SIZE$imageCaptureReplayDescriptorDataSize = NativeLayout.C_SIZE_T.byteSize();
    public static final long SIZE$imageViewCaptureReplayDescriptorDataSize = NativeLayout.C_SIZE_T.byteSize();
    public static final long SIZE$samplerCaptureReplayDescriptorDataSize = NativeLayout.C_SIZE_T.byteSize();
    public static final long SIZE$accelerationStructureCaptureReplayDescriptorDataSize = NativeLayout.C_SIZE_T.byteSize();
    public static final long SIZE$samplerDescriptorSize = NativeLayout.C_SIZE_T.byteSize();
    public static final long SIZE$combinedImageSamplerDescriptorSize = NativeLayout.C_SIZE_T.byteSize();
    public static final long SIZE$sampledImageDescriptorSize = NativeLayout.C_SIZE_T.byteSize();
    public static final long SIZE$storageImageDescriptorSize = NativeLayout.C_SIZE_T.byteSize();
    public static final long SIZE$uniformTexelBufferDescriptorSize = NativeLayout.C_SIZE_T.byteSize();
    public static final long SIZE$robustUniformTexelBufferDescriptorSize = NativeLayout.C_SIZE_T.byteSize();
    public static final long SIZE$storageTexelBufferDescriptorSize = NativeLayout.C_SIZE_T.byteSize();
    public static final long SIZE$robustStorageTexelBufferDescriptorSize = NativeLayout.C_SIZE_T.byteSize();
    public static final long SIZE$uniformBufferDescriptorSize = NativeLayout.C_SIZE_T.byteSize();
    public static final long SIZE$robustUniformBufferDescriptorSize = NativeLayout.C_SIZE_T.byteSize();
    public static final long SIZE$storageBufferDescriptorSize = NativeLayout.C_SIZE_T.byteSize();
    public static final long SIZE$robustStorageBufferDescriptorSize = NativeLayout.C_SIZE_T.byteSize();
    public static final long SIZE$inputAttachmentDescriptorSize = NativeLayout.C_SIZE_T.byteSize();
    public static final long SIZE$accelerationStructureDescriptorSize = NativeLayout.C_SIZE_T.byteSize();
    public static final long SIZE$maxSamplerDescriptorBufferRange = LAYOUT$maxSamplerDescriptorBufferRange.byteSize();
    public static final long SIZE$maxResourceDescriptorBufferRange = LAYOUT$maxResourceDescriptorBufferRange.byteSize();
    public static final long SIZE$samplerDescriptorBufferAddressSpaceSize = LAYOUT$samplerDescriptorBufferAddressSpaceSize.byteSize();
    public static final long SIZE$resourceDescriptorBufferAddressSpaceSize = LAYOUT$resourceDescriptorBufferAddressSpaceSize.byteSize();
    public static final long SIZE$descriptorBufferAddressSpaceSize = LAYOUT$descriptorBufferAddressSpaceSize.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$combinedImageSamplerDescriptorSingleArray = LAYOUT.byteOffset(PATH$combinedImageSamplerDescriptorSingleArray);
    public static final long OFFSET$bufferlessPushDescriptors = LAYOUT.byteOffset(PATH$bufferlessPushDescriptors);
    public static final long OFFSET$allowSamplerImageViewPostSubmitCreation = LAYOUT.byteOffset(PATH$allowSamplerImageViewPostSubmitCreation);
    public static final long OFFSET$descriptorBufferOffsetAlignment = LAYOUT.byteOffset(PATH$descriptorBufferOffsetAlignment);
    public static final long OFFSET$maxDescriptorBufferBindings = LAYOUT.byteOffset(PATH$maxDescriptorBufferBindings);
    public static final long OFFSET$maxResourceDescriptorBufferBindings = LAYOUT.byteOffset(PATH$maxResourceDescriptorBufferBindings);
    public static final long OFFSET$maxSamplerDescriptorBufferBindings = LAYOUT.byteOffset(PATH$maxSamplerDescriptorBufferBindings);
    public static final long OFFSET$maxEmbeddedImmutableSamplerBindings = LAYOUT.byteOffset(PATH$maxEmbeddedImmutableSamplerBindings);
    public static final long OFFSET$maxEmbeddedImmutableSamplers = LAYOUT.byteOffset(PATH$maxEmbeddedImmutableSamplers);
    public static final long OFFSET$bufferCaptureReplayDescriptorDataSize = LAYOUT.byteOffset(PATH$bufferCaptureReplayDescriptorDataSize);
    public static final long OFFSET$imageCaptureReplayDescriptorDataSize = LAYOUT.byteOffset(PATH$imageCaptureReplayDescriptorDataSize);
    public static final long OFFSET$imageViewCaptureReplayDescriptorDataSize = LAYOUT.byteOffset(PATH$imageViewCaptureReplayDescriptorDataSize);
    public static final long OFFSET$samplerCaptureReplayDescriptorDataSize = LAYOUT.byteOffset(PATH$samplerCaptureReplayDescriptorDataSize);
    public static final long OFFSET$accelerationStructureCaptureReplayDescriptorDataSize = LAYOUT.byteOffset(PATH$accelerationStructureCaptureReplayDescriptorDataSize);
    public static final long OFFSET$samplerDescriptorSize = LAYOUT.byteOffset(PATH$samplerDescriptorSize);
    public static final long OFFSET$combinedImageSamplerDescriptorSize = LAYOUT.byteOffset(PATH$combinedImageSamplerDescriptorSize);
    public static final long OFFSET$sampledImageDescriptorSize = LAYOUT.byteOffset(PATH$sampledImageDescriptorSize);
    public static final long OFFSET$storageImageDescriptorSize = LAYOUT.byteOffset(PATH$storageImageDescriptorSize);
    public static final long OFFSET$uniformTexelBufferDescriptorSize = LAYOUT.byteOffset(PATH$uniformTexelBufferDescriptorSize);
    public static final long OFFSET$robustUniformTexelBufferDescriptorSize = LAYOUT.byteOffset(PATH$robustUniformTexelBufferDescriptorSize);
    public static final long OFFSET$storageTexelBufferDescriptorSize = LAYOUT.byteOffset(PATH$storageTexelBufferDescriptorSize);
    public static final long OFFSET$robustStorageTexelBufferDescriptorSize = LAYOUT.byteOffset(PATH$robustStorageTexelBufferDescriptorSize);
    public static final long OFFSET$uniformBufferDescriptorSize = LAYOUT.byteOffset(PATH$uniformBufferDescriptorSize);
    public static final long OFFSET$robustUniformBufferDescriptorSize = LAYOUT.byteOffset(PATH$robustUniformBufferDescriptorSize);
    public static final long OFFSET$storageBufferDescriptorSize = LAYOUT.byteOffset(PATH$storageBufferDescriptorSize);
    public static final long OFFSET$robustStorageBufferDescriptorSize = LAYOUT.byteOffset(PATH$robustStorageBufferDescriptorSize);
    public static final long OFFSET$inputAttachmentDescriptorSize = LAYOUT.byteOffset(PATH$inputAttachmentDescriptorSize);
    public static final long OFFSET$accelerationStructureDescriptorSize = LAYOUT.byteOffset(PATH$accelerationStructureDescriptorSize);
    public static final long OFFSET$maxSamplerDescriptorBufferRange = LAYOUT.byteOffset(PATH$maxSamplerDescriptorBufferRange);
    public static final long OFFSET$maxResourceDescriptorBufferRange = LAYOUT.byteOffset(PATH$maxResourceDescriptorBufferRange);
    public static final long OFFSET$samplerDescriptorBufferAddressSpaceSize = LAYOUT.byteOffset(PATH$samplerDescriptorBufferAddressSpaceSize);
    public static final long OFFSET$resourceDescriptorBufferAddressSpaceSize = LAYOUT.byteOffset(PATH$resourceDescriptorBufferAddressSpaceSize);
    public static final long OFFSET$descriptorBufferAddressSpaceSize = LAYOUT.byteOffset(PATH$descriptorBufferAddressSpaceSize);
}
