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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceDescriptorIndexingFeatures.html"><code>VkPhysicalDeviceDescriptorIndexingFeatures</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceDescriptorIndexingFeatures {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
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
/// } VkPhysicalDeviceDescriptorIndexingFeatures;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_DESCRIPTOR_INDEXING_FEATURES`
///
/// The {@code allocate} ({@link VkPhysicalDeviceDescriptorIndexingFeatures#allocate(Arena)}, {@link VkPhysicalDeviceDescriptorIndexingFeatures#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceDescriptorIndexingFeatures#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceDescriptorIndexingFeatures.html"><code>VkPhysicalDeviceDescriptorIndexingFeatures</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceDescriptorIndexingFeatures(@NotNull MemorySegment segment) implements IVkPhysicalDeviceDescriptorIndexingFeatures {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceDescriptorIndexingFeatures.html"><code>VkPhysicalDeviceDescriptorIndexingFeatures</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceDescriptorIndexingFeatures}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceDescriptorIndexingFeatures to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceDescriptorIndexingFeatures.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceDescriptorIndexingFeatures, Iterable<VkPhysicalDeviceDescriptorIndexingFeatures> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceDescriptorIndexingFeatures.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceDescriptorIndexingFeatures at(long index) {
            return new VkPhysicalDeviceDescriptorIndexingFeatures(segment.asSlice(index * VkPhysicalDeviceDescriptorIndexingFeatures.BYTES, VkPhysicalDeviceDescriptorIndexingFeatures.BYTES));
        }

        public VkPhysicalDeviceDescriptorIndexingFeatures.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceDescriptorIndexingFeatures> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceDescriptorIndexingFeatures value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceDescriptorIndexingFeatures.BYTES, VkPhysicalDeviceDescriptorIndexingFeatures.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceDescriptorIndexingFeatures.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceDescriptorIndexingFeatures.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceDescriptorIndexingFeatures.BYTES,
                (end - start) * VkPhysicalDeviceDescriptorIndexingFeatures.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceDescriptorIndexingFeatures.BYTES));
        }

        public VkPhysicalDeviceDescriptorIndexingFeatures[] toArray() {
            VkPhysicalDeviceDescriptorIndexingFeatures[] ret = new VkPhysicalDeviceDescriptorIndexingFeatures[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceDescriptorIndexingFeatures> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceDescriptorIndexingFeatures> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceDescriptorIndexingFeatures.BYTES;
            }

            @Override
            public VkPhysicalDeviceDescriptorIndexingFeatures next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceDescriptorIndexingFeatures ret = new VkPhysicalDeviceDescriptorIndexingFeatures(segment.asSlice(0, VkPhysicalDeviceDescriptorIndexingFeatures.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceDescriptorIndexingFeatures.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceDescriptorIndexingFeatures allocate(Arena arena) {
        VkPhysicalDeviceDescriptorIndexingFeatures ret = new VkPhysicalDeviceDescriptorIndexingFeatures(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_DESCRIPTOR_INDEXING_FEATURES);
        return ret;
    }

    public static VkPhysicalDeviceDescriptorIndexingFeatures.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceDescriptorIndexingFeatures.Ptr ret = new VkPhysicalDeviceDescriptorIndexingFeatures.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_DESCRIPTOR_INDEXING_FEATURES);
        }
        return ret;
    }

    public static VkPhysicalDeviceDescriptorIndexingFeatures clone(Arena arena, VkPhysicalDeviceDescriptorIndexingFeatures src) {
        VkPhysicalDeviceDescriptorIndexingFeatures ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_DESCRIPTOR_INDEXING_FEATURES);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceDescriptorIndexingFeatures sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceDescriptorIndexingFeatures pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceDescriptorIndexingFeatures pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderInputAttachmentArrayDynamicIndexing() {
        return segment.get(LAYOUT$shaderInputAttachmentArrayDynamicIndexing, OFFSET$shaderInputAttachmentArrayDynamicIndexing);
    }

    public VkPhysicalDeviceDescriptorIndexingFeatures shaderInputAttachmentArrayDynamicIndexing(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderInputAttachmentArrayDynamicIndexing, OFFSET$shaderInputAttachmentArrayDynamicIndexing, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderUniformTexelBufferArrayDynamicIndexing() {
        return segment.get(LAYOUT$shaderUniformTexelBufferArrayDynamicIndexing, OFFSET$shaderUniformTexelBufferArrayDynamicIndexing);
    }

    public VkPhysicalDeviceDescriptorIndexingFeatures shaderUniformTexelBufferArrayDynamicIndexing(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderUniformTexelBufferArrayDynamicIndexing, OFFSET$shaderUniformTexelBufferArrayDynamicIndexing, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderStorageTexelBufferArrayDynamicIndexing() {
        return segment.get(LAYOUT$shaderStorageTexelBufferArrayDynamicIndexing, OFFSET$shaderStorageTexelBufferArrayDynamicIndexing);
    }

    public VkPhysicalDeviceDescriptorIndexingFeatures shaderStorageTexelBufferArrayDynamicIndexing(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderStorageTexelBufferArrayDynamicIndexing, OFFSET$shaderStorageTexelBufferArrayDynamicIndexing, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderUniformBufferArrayNonUniformIndexing() {
        return segment.get(LAYOUT$shaderUniformBufferArrayNonUniformIndexing, OFFSET$shaderUniformBufferArrayNonUniformIndexing);
    }

    public VkPhysicalDeviceDescriptorIndexingFeatures shaderUniformBufferArrayNonUniformIndexing(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderUniformBufferArrayNonUniformIndexing, OFFSET$shaderUniformBufferArrayNonUniformIndexing, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderSampledImageArrayNonUniformIndexing() {
        return segment.get(LAYOUT$shaderSampledImageArrayNonUniformIndexing, OFFSET$shaderSampledImageArrayNonUniformIndexing);
    }

    public VkPhysicalDeviceDescriptorIndexingFeatures shaderSampledImageArrayNonUniformIndexing(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderSampledImageArrayNonUniformIndexing, OFFSET$shaderSampledImageArrayNonUniformIndexing, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderStorageBufferArrayNonUniformIndexing() {
        return segment.get(LAYOUT$shaderStorageBufferArrayNonUniformIndexing, OFFSET$shaderStorageBufferArrayNonUniformIndexing);
    }

    public VkPhysicalDeviceDescriptorIndexingFeatures shaderStorageBufferArrayNonUniformIndexing(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderStorageBufferArrayNonUniformIndexing, OFFSET$shaderStorageBufferArrayNonUniformIndexing, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderStorageImageArrayNonUniformIndexing() {
        return segment.get(LAYOUT$shaderStorageImageArrayNonUniformIndexing, OFFSET$shaderStorageImageArrayNonUniformIndexing);
    }

    public VkPhysicalDeviceDescriptorIndexingFeatures shaderStorageImageArrayNonUniformIndexing(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderStorageImageArrayNonUniformIndexing, OFFSET$shaderStorageImageArrayNonUniformIndexing, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderInputAttachmentArrayNonUniformIndexing() {
        return segment.get(LAYOUT$shaderInputAttachmentArrayNonUniformIndexing, OFFSET$shaderInputAttachmentArrayNonUniformIndexing);
    }

    public VkPhysicalDeviceDescriptorIndexingFeatures shaderInputAttachmentArrayNonUniformIndexing(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderInputAttachmentArrayNonUniformIndexing, OFFSET$shaderInputAttachmentArrayNonUniformIndexing, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderUniformTexelBufferArrayNonUniformIndexing() {
        return segment.get(LAYOUT$shaderUniformTexelBufferArrayNonUniformIndexing, OFFSET$shaderUniformTexelBufferArrayNonUniformIndexing);
    }

    public VkPhysicalDeviceDescriptorIndexingFeatures shaderUniformTexelBufferArrayNonUniformIndexing(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderUniformTexelBufferArrayNonUniformIndexing, OFFSET$shaderUniformTexelBufferArrayNonUniformIndexing, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderStorageTexelBufferArrayNonUniformIndexing() {
        return segment.get(LAYOUT$shaderStorageTexelBufferArrayNonUniformIndexing, OFFSET$shaderStorageTexelBufferArrayNonUniformIndexing);
    }

    public VkPhysicalDeviceDescriptorIndexingFeatures shaderStorageTexelBufferArrayNonUniformIndexing(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderStorageTexelBufferArrayNonUniformIndexing, OFFSET$shaderStorageTexelBufferArrayNonUniformIndexing, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int descriptorBindingUniformBufferUpdateAfterBind() {
        return segment.get(LAYOUT$descriptorBindingUniformBufferUpdateAfterBind, OFFSET$descriptorBindingUniformBufferUpdateAfterBind);
    }

    public VkPhysicalDeviceDescriptorIndexingFeatures descriptorBindingUniformBufferUpdateAfterBind(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$descriptorBindingUniformBufferUpdateAfterBind, OFFSET$descriptorBindingUniformBufferUpdateAfterBind, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int descriptorBindingSampledImageUpdateAfterBind() {
        return segment.get(LAYOUT$descriptorBindingSampledImageUpdateAfterBind, OFFSET$descriptorBindingSampledImageUpdateAfterBind);
    }

    public VkPhysicalDeviceDescriptorIndexingFeatures descriptorBindingSampledImageUpdateAfterBind(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$descriptorBindingSampledImageUpdateAfterBind, OFFSET$descriptorBindingSampledImageUpdateAfterBind, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int descriptorBindingStorageImageUpdateAfterBind() {
        return segment.get(LAYOUT$descriptorBindingStorageImageUpdateAfterBind, OFFSET$descriptorBindingStorageImageUpdateAfterBind);
    }

    public VkPhysicalDeviceDescriptorIndexingFeatures descriptorBindingStorageImageUpdateAfterBind(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$descriptorBindingStorageImageUpdateAfterBind, OFFSET$descriptorBindingStorageImageUpdateAfterBind, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int descriptorBindingStorageBufferUpdateAfterBind() {
        return segment.get(LAYOUT$descriptorBindingStorageBufferUpdateAfterBind, OFFSET$descriptorBindingStorageBufferUpdateAfterBind);
    }

    public VkPhysicalDeviceDescriptorIndexingFeatures descriptorBindingStorageBufferUpdateAfterBind(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$descriptorBindingStorageBufferUpdateAfterBind, OFFSET$descriptorBindingStorageBufferUpdateAfterBind, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int descriptorBindingUniformTexelBufferUpdateAfterBind() {
        return segment.get(LAYOUT$descriptorBindingUniformTexelBufferUpdateAfterBind, OFFSET$descriptorBindingUniformTexelBufferUpdateAfterBind);
    }

    public VkPhysicalDeviceDescriptorIndexingFeatures descriptorBindingUniformTexelBufferUpdateAfterBind(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$descriptorBindingUniformTexelBufferUpdateAfterBind, OFFSET$descriptorBindingUniformTexelBufferUpdateAfterBind, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int descriptorBindingStorageTexelBufferUpdateAfterBind() {
        return segment.get(LAYOUT$descriptorBindingStorageTexelBufferUpdateAfterBind, OFFSET$descriptorBindingStorageTexelBufferUpdateAfterBind);
    }

    public VkPhysicalDeviceDescriptorIndexingFeatures descriptorBindingStorageTexelBufferUpdateAfterBind(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$descriptorBindingStorageTexelBufferUpdateAfterBind, OFFSET$descriptorBindingStorageTexelBufferUpdateAfterBind, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int descriptorBindingUpdateUnusedWhilePending() {
        return segment.get(LAYOUT$descriptorBindingUpdateUnusedWhilePending, OFFSET$descriptorBindingUpdateUnusedWhilePending);
    }

    public VkPhysicalDeviceDescriptorIndexingFeatures descriptorBindingUpdateUnusedWhilePending(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$descriptorBindingUpdateUnusedWhilePending, OFFSET$descriptorBindingUpdateUnusedWhilePending, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int descriptorBindingPartiallyBound() {
        return segment.get(LAYOUT$descriptorBindingPartiallyBound, OFFSET$descriptorBindingPartiallyBound);
    }

    public VkPhysicalDeviceDescriptorIndexingFeatures descriptorBindingPartiallyBound(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$descriptorBindingPartiallyBound, OFFSET$descriptorBindingPartiallyBound, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int descriptorBindingVariableDescriptorCount() {
        return segment.get(LAYOUT$descriptorBindingVariableDescriptorCount, OFFSET$descriptorBindingVariableDescriptorCount);
    }

    public VkPhysicalDeviceDescriptorIndexingFeatures descriptorBindingVariableDescriptorCount(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$descriptorBindingVariableDescriptorCount, OFFSET$descriptorBindingVariableDescriptorCount, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int runtimeDescriptorArray() {
        return segment.get(LAYOUT$runtimeDescriptorArray, OFFSET$runtimeDescriptorArray);
    }

    public VkPhysicalDeviceDescriptorIndexingFeatures runtimeDescriptorArray(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$runtimeDescriptorArray, OFFSET$runtimeDescriptorArray, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
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
        ValueLayout.JAVA_INT.withName("runtimeDescriptorArray")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
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

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
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

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
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

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
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
}
