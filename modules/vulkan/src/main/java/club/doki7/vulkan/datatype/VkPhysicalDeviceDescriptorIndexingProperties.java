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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceDescriptorIndexingProperties.html"><code>VkPhysicalDeviceDescriptorIndexingProperties</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceDescriptorIndexingProperties {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
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
/// } VkPhysicalDeviceDescriptorIndexingProperties;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_DESCRIPTOR_INDEXING_PROPERTIES`
///
/// The {@code allocate} ({@link VkPhysicalDeviceDescriptorIndexingProperties#allocate(Arena)}, {@link VkPhysicalDeviceDescriptorIndexingProperties#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceDescriptorIndexingProperties#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceDescriptorIndexingProperties.html"><code>VkPhysicalDeviceDescriptorIndexingProperties</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceDescriptorIndexingProperties(@NotNull MemorySegment segment) implements IVkPhysicalDeviceDescriptorIndexingProperties {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceDescriptorIndexingProperties.html"><code>VkPhysicalDeviceDescriptorIndexingProperties</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceDescriptorIndexingProperties}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceDescriptorIndexingProperties to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceDescriptorIndexingProperties.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceDescriptorIndexingProperties, Iterable<VkPhysicalDeviceDescriptorIndexingProperties> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceDescriptorIndexingProperties.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceDescriptorIndexingProperties at(long index) {
            return new VkPhysicalDeviceDescriptorIndexingProperties(segment.asSlice(index * VkPhysicalDeviceDescriptorIndexingProperties.BYTES, VkPhysicalDeviceDescriptorIndexingProperties.BYTES));
        }

        public VkPhysicalDeviceDescriptorIndexingProperties.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceDescriptorIndexingProperties> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceDescriptorIndexingProperties value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceDescriptorIndexingProperties.BYTES, VkPhysicalDeviceDescriptorIndexingProperties.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceDescriptorIndexingProperties.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceDescriptorIndexingProperties.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceDescriptorIndexingProperties.BYTES,
                (end - start) * VkPhysicalDeviceDescriptorIndexingProperties.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceDescriptorIndexingProperties.BYTES));
        }

        public VkPhysicalDeviceDescriptorIndexingProperties[] toArray() {
            VkPhysicalDeviceDescriptorIndexingProperties[] ret = new VkPhysicalDeviceDescriptorIndexingProperties[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceDescriptorIndexingProperties> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceDescriptorIndexingProperties> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceDescriptorIndexingProperties.BYTES;
            }

            @Override
            public VkPhysicalDeviceDescriptorIndexingProperties next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceDescriptorIndexingProperties ret = new VkPhysicalDeviceDescriptorIndexingProperties(segment.asSlice(0, VkPhysicalDeviceDescriptorIndexingProperties.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceDescriptorIndexingProperties.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceDescriptorIndexingProperties allocate(Arena arena) {
        VkPhysicalDeviceDescriptorIndexingProperties ret = new VkPhysicalDeviceDescriptorIndexingProperties(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_DESCRIPTOR_INDEXING_PROPERTIES);
        return ret;
    }

    public static VkPhysicalDeviceDescriptorIndexingProperties.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceDescriptorIndexingProperties.Ptr ret = new VkPhysicalDeviceDescriptorIndexingProperties.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_DESCRIPTOR_INDEXING_PROPERTIES);
        }
        return ret;
    }

    public static VkPhysicalDeviceDescriptorIndexingProperties clone(Arena arena, VkPhysicalDeviceDescriptorIndexingProperties src) {
        VkPhysicalDeviceDescriptorIndexingProperties ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_DESCRIPTOR_INDEXING_PROPERTIES);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceDescriptorIndexingProperties sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceDescriptorIndexingProperties pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceDescriptorIndexingProperties pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int maxUpdateAfterBindDescriptorsInAllPools() {
        return segment.get(LAYOUT$maxUpdateAfterBindDescriptorsInAllPools, OFFSET$maxUpdateAfterBindDescriptorsInAllPools);
    }

    public VkPhysicalDeviceDescriptorIndexingProperties maxUpdateAfterBindDescriptorsInAllPools(@Unsigned int value) {
        segment.set(LAYOUT$maxUpdateAfterBindDescriptorsInAllPools, OFFSET$maxUpdateAfterBindDescriptorsInAllPools, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderUniformBufferArrayNonUniformIndexingNative() {
        return segment.get(LAYOUT$shaderUniformBufferArrayNonUniformIndexingNative, OFFSET$shaderUniformBufferArrayNonUniformIndexingNative);
    }

    public VkPhysicalDeviceDescriptorIndexingProperties shaderUniformBufferArrayNonUniformIndexingNative(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderUniformBufferArrayNonUniformIndexingNative, OFFSET$shaderUniformBufferArrayNonUniformIndexingNative, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderSampledImageArrayNonUniformIndexingNative() {
        return segment.get(LAYOUT$shaderSampledImageArrayNonUniformIndexingNative, OFFSET$shaderSampledImageArrayNonUniformIndexingNative);
    }

    public VkPhysicalDeviceDescriptorIndexingProperties shaderSampledImageArrayNonUniformIndexingNative(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderSampledImageArrayNonUniformIndexingNative, OFFSET$shaderSampledImageArrayNonUniformIndexingNative, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderStorageBufferArrayNonUniformIndexingNative() {
        return segment.get(LAYOUT$shaderStorageBufferArrayNonUniformIndexingNative, OFFSET$shaderStorageBufferArrayNonUniformIndexingNative);
    }

    public VkPhysicalDeviceDescriptorIndexingProperties shaderStorageBufferArrayNonUniformIndexingNative(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderStorageBufferArrayNonUniformIndexingNative, OFFSET$shaderStorageBufferArrayNonUniformIndexingNative, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderStorageImageArrayNonUniformIndexingNative() {
        return segment.get(LAYOUT$shaderStorageImageArrayNonUniformIndexingNative, OFFSET$shaderStorageImageArrayNonUniformIndexingNative);
    }

    public VkPhysicalDeviceDescriptorIndexingProperties shaderStorageImageArrayNonUniformIndexingNative(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderStorageImageArrayNonUniformIndexingNative, OFFSET$shaderStorageImageArrayNonUniformIndexingNative, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderInputAttachmentArrayNonUniformIndexingNative() {
        return segment.get(LAYOUT$shaderInputAttachmentArrayNonUniformIndexingNative, OFFSET$shaderInputAttachmentArrayNonUniformIndexingNative);
    }

    public VkPhysicalDeviceDescriptorIndexingProperties shaderInputAttachmentArrayNonUniformIndexingNative(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderInputAttachmentArrayNonUniformIndexingNative, OFFSET$shaderInputAttachmentArrayNonUniformIndexingNative, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int robustBufferAccessUpdateAfterBind() {
        return segment.get(LAYOUT$robustBufferAccessUpdateAfterBind, OFFSET$robustBufferAccessUpdateAfterBind);
    }

    public VkPhysicalDeviceDescriptorIndexingProperties robustBufferAccessUpdateAfterBind(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$robustBufferAccessUpdateAfterBind, OFFSET$robustBufferAccessUpdateAfterBind, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int quadDivergentImplicitLod() {
        return segment.get(LAYOUT$quadDivergentImplicitLod, OFFSET$quadDivergentImplicitLod);
    }

    public VkPhysicalDeviceDescriptorIndexingProperties quadDivergentImplicitLod(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$quadDivergentImplicitLod, OFFSET$quadDivergentImplicitLod, value);
        return this;
    }

    public @Unsigned int maxPerStageDescriptorUpdateAfterBindSamplers() {
        return segment.get(LAYOUT$maxPerStageDescriptorUpdateAfterBindSamplers, OFFSET$maxPerStageDescriptorUpdateAfterBindSamplers);
    }

    public VkPhysicalDeviceDescriptorIndexingProperties maxPerStageDescriptorUpdateAfterBindSamplers(@Unsigned int value) {
        segment.set(LAYOUT$maxPerStageDescriptorUpdateAfterBindSamplers, OFFSET$maxPerStageDescriptorUpdateAfterBindSamplers, value);
        return this;
    }

    public @Unsigned int maxPerStageDescriptorUpdateAfterBindUniformBuffers() {
        return segment.get(LAYOUT$maxPerStageDescriptorUpdateAfterBindUniformBuffers, OFFSET$maxPerStageDescriptorUpdateAfterBindUniformBuffers);
    }

    public VkPhysicalDeviceDescriptorIndexingProperties maxPerStageDescriptorUpdateAfterBindUniformBuffers(@Unsigned int value) {
        segment.set(LAYOUT$maxPerStageDescriptorUpdateAfterBindUniformBuffers, OFFSET$maxPerStageDescriptorUpdateAfterBindUniformBuffers, value);
        return this;
    }

    public @Unsigned int maxPerStageDescriptorUpdateAfterBindStorageBuffers() {
        return segment.get(LAYOUT$maxPerStageDescriptorUpdateAfterBindStorageBuffers, OFFSET$maxPerStageDescriptorUpdateAfterBindStorageBuffers);
    }

    public VkPhysicalDeviceDescriptorIndexingProperties maxPerStageDescriptorUpdateAfterBindStorageBuffers(@Unsigned int value) {
        segment.set(LAYOUT$maxPerStageDescriptorUpdateAfterBindStorageBuffers, OFFSET$maxPerStageDescriptorUpdateAfterBindStorageBuffers, value);
        return this;
    }

    public @Unsigned int maxPerStageDescriptorUpdateAfterBindSampledImages() {
        return segment.get(LAYOUT$maxPerStageDescriptorUpdateAfterBindSampledImages, OFFSET$maxPerStageDescriptorUpdateAfterBindSampledImages);
    }

    public VkPhysicalDeviceDescriptorIndexingProperties maxPerStageDescriptorUpdateAfterBindSampledImages(@Unsigned int value) {
        segment.set(LAYOUT$maxPerStageDescriptorUpdateAfterBindSampledImages, OFFSET$maxPerStageDescriptorUpdateAfterBindSampledImages, value);
        return this;
    }

    public @Unsigned int maxPerStageDescriptorUpdateAfterBindStorageImages() {
        return segment.get(LAYOUT$maxPerStageDescriptorUpdateAfterBindStorageImages, OFFSET$maxPerStageDescriptorUpdateAfterBindStorageImages);
    }

    public VkPhysicalDeviceDescriptorIndexingProperties maxPerStageDescriptorUpdateAfterBindStorageImages(@Unsigned int value) {
        segment.set(LAYOUT$maxPerStageDescriptorUpdateAfterBindStorageImages, OFFSET$maxPerStageDescriptorUpdateAfterBindStorageImages, value);
        return this;
    }

    public @Unsigned int maxPerStageDescriptorUpdateAfterBindInputAttachments() {
        return segment.get(LAYOUT$maxPerStageDescriptorUpdateAfterBindInputAttachments, OFFSET$maxPerStageDescriptorUpdateAfterBindInputAttachments);
    }

    public VkPhysicalDeviceDescriptorIndexingProperties maxPerStageDescriptorUpdateAfterBindInputAttachments(@Unsigned int value) {
        segment.set(LAYOUT$maxPerStageDescriptorUpdateAfterBindInputAttachments, OFFSET$maxPerStageDescriptorUpdateAfterBindInputAttachments, value);
        return this;
    }

    public @Unsigned int maxPerStageUpdateAfterBindResources() {
        return segment.get(LAYOUT$maxPerStageUpdateAfterBindResources, OFFSET$maxPerStageUpdateAfterBindResources);
    }

    public VkPhysicalDeviceDescriptorIndexingProperties maxPerStageUpdateAfterBindResources(@Unsigned int value) {
        segment.set(LAYOUT$maxPerStageUpdateAfterBindResources, OFFSET$maxPerStageUpdateAfterBindResources, value);
        return this;
    }

    public @Unsigned int maxDescriptorSetUpdateAfterBindSamplers() {
        return segment.get(LAYOUT$maxDescriptorSetUpdateAfterBindSamplers, OFFSET$maxDescriptorSetUpdateAfterBindSamplers);
    }

    public VkPhysicalDeviceDescriptorIndexingProperties maxDescriptorSetUpdateAfterBindSamplers(@Unsigned int value) {
        segment.set(LAYOUT$maxDescriptorSetUpdateAfterBindSamplers, OFFSET$maxDescriptorSetUpdateAfterBindSamplers, value);
        return this;
    }

    public @Unsigned int maxDescriptorSetUpdateAfterBindUniformBuffers() {
        return segment.get(LAYOUT$maxDescriptorSetUpdateAfterBindUniformBuffers, OFFSET$maxDescriptorSetUpdateAfterBindUniformBuffers);
    }

    public VkPhysicalDeviceDescriptorIndexingProperties maxDescriptorSetUpdateAfterBindUniformBuffers(@Unsigned int value) {
        segment.set(LAYOUT$maxDescriptorSetUpdateAfterBindUniformBuffers, OFFSET$maxDescriptorSetUpdateAfterBindUniformBuffers, value);
        return this;
    }

    public @Unsigned int maxDescriptorSetUpdateAfterBindUniformBuffersDynamic() {
        return segment.get(LAYOUT$maxDescriptorSetUpdateAfterBindUniformBuffersDynamic, OFFSET$maxDescriptorSetUpdateAfterBindUniformBuffersDynamic);
    }

    public VkPhysicalDeviceDescriptorIndexingProperties maxDescriptorSetUpdateAfterBindUniformBuffersDynamic(@Unsigned int value) {
        segment.set(LAYOUT$maxDescriptorSetUpdateAfterBindUniformBuffersDynamic, OFFSET$maxDescriptorSetUpdateAfterBindUniformBuffersDynamic, value);
        return this;
    }

    public @Unsigned int maxDescriptorSetUpdateAfterBindStorageBuffers() {
        return segment.get(LAYOUT$maxDescriptorSetUpdateAfterBindStorageBuffers, OFFSET$maxDescriptorSetUpdateAfterBindStorageBuffers);
    }

    public VkPhysicalDeviceDescriptorIndexingProperties maxDescriptorSetUpdateAfterBindStorageBuffers(@Unsigned int value) {
        segment.set(LAYOUT$maxDescriptorSetUpdateAfterBindStorageBuffers, OFFSET$maxDescriptorSetUpdateAfterBindStorageBuffers, value);
        return this;
    }

    public @Unsigned int maxDescriptorSetUpdateAfterBindStorageBuffersDynamic() {
        return segment.get(LAYOUT$maxDescriptorSetUpdateAfterBindStorageBuffersDynamic, OFFSET$maxDescriptorSetUpdateAfterBindStorageBuffersDynamic);
    }

    public VkPhysicalDeviceDescriptorIndexingProperties maxDescriptorSetUpdateAfterBindStorageBuffersDynamic(@Unsigned int value) {
        segment.set(LAYOUT$maxDescriptorSetUpdateAfterBindStorageBuffersDynamic, OFFSET$maxDescriptorSetUpdateAfterBindStorageBuffersDynamic, value);
        return this;
    }

    public @Unsigned int maxDescriptorSetUpdateAfterBindSampledImages() {
        return segment.get(LAYOUT$maxDescriptorSetUpdateAfterBindSampledImages, OFFSET$maxDescriptorSetUpdateAfterBindSampledImages);
    }

    public VkPhysicalDeviceDescriptorIndexingProperties maxDescriptorSetUpdateAfterBindSampledImages(@Unsigned int value) {
        segment.set(LAYOUT$maxDescriptorSetUpdateAfterBindSampledImages, OFFSET$maxDescriptorSetUpdateAfterBindSampledImages, value);
        return this;
    }

    public @Unsigned int maxDescriptorSetUpdateAfterBindStorageImages() {
        return segment.get(LAYOUT$maxDescriptorSetUpdateAfterBindStorageImages, OFFSET$maxDescriptorSetUpdateAfterBindStorageImages);
    }

    public VkPhysicalDeviceDescriptorIndexingProperties maxDescriptorSetUpdateAfterBindStorageImages(@Unsigned int value) {
        segment.set(LAYOUT$maxDescriptorSetUpdateAfterBindStorageImages, OFFSET$maxDescriptorSetUpdateAfterBindStorageImages, value);
        return this;
    }

    public @Unsigned int maxDescriptorSetUpdateAfterBindInputAttachments() {
        return segment.get(LAYOUT$maxDescriptorSetUpdateAfterBindInputAttachments, OFFSET$maxDescriptorSetUpdateAfterBindInputAttachments);
    }

    public VkPhysicalDeviceDescriptorIndexingProperties maxDescriptorSetUpdateAfterBindInputAttachments(@Unsigned int value) {
        segment.set(LAYOUT$maxDescriptorSetUpdateAfterBindInputAttachments, OFFSET$maxDescriptorSetUpdateAfterBindInputAttachments, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
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
        ValueLayout.JAVA_INT.withName("maxDescriptorSetUpdateAfterBindInputAttachments")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
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

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
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

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
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

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
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
}
