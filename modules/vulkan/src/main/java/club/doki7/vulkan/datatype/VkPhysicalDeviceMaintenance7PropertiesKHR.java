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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceMaintenance7PropertiesKHR.html"><code>VkPhysicalDeviceMaintenance7PropertiesKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceMaintenance7PropertiesKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 robustFragmentShadingRateAttachmentAccess; // @link substring="robustFragmentShadingRateAttachmentAccess" target="#robustFragmentShadingRateAttachmentAccess"
///     VkBool32 separateDepthStencilAttachmentAccess; // @link substring="separateDepthStencilAttachmentAccess" target="#separateDepthStencilAttachmentAccess"
///     uint32_t maxDescriptorSetTotalUniformBuffersDynamic; // @link substring="maxDescriptorSetTotalUniformBuffersDynamic" target="#maxDescriptorSetTotalUniformBuffersDynamic"
///     uint32_t maxDescriptorSetTotalStorageBuffersDynamic; // @link substring="maxDescriptorSetTotalStorageBuffersDynamic" target="#maxDescriptorSetTotalStorageBuffersDynamic"
///     uint32_t maxDescriptorSetTotalBuffersDynamic; // @link substring="maxDescriptorSetTotalBuffersDynamic" target="#maxDescriptorSetTotalBuffersDynamic"
///     uint32_t maxDescriptorSetUpdateAfterBindTotalUniformBuffersDynamic; // @link substring="maxDescriptorSetUpdateAfterBindTotalUniformBuffersDynamic" target="#maxDescriptorSetUpdateAfterBindTotalUniformBuffersDynamic"
///     uint32_t maxDescriptorSetUpdateAfterBindTotalStorageBuffersDynamic; // @link substring="maxDescriptorSetUpdateAfterBindTotalStorageBuffersDynamic" target="#maxDescriptorSetUpdateAfterBindTotalStorageBuffersDynamic"
///     uint32_t maxDescriptorSetUpdateAfterBindTotalBuffersDynamic; // @link substring="maxDescriptorSetUpdateAfterBindTotalBuffersDynamic" target="#maxDescriptorSetUpdateAfterBindTotalBuffersDynamic"
/// } VkPhysicalDeviceMaintenance7PropertiesKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_MAINTENANCE_7_PROPERTIES_KHR`
///
/// The {@code allocate} ({@link VkPhysicalDeviceMaintenance7PropertiesKHR#allocate(Arena)}, {@link VkPhysicalDeviceMaintenance7PropertiesKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceMaintenance7PropertiesKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceMaintenance7PropertiesKHR.html"><code>VkPhysicalDeviceMaintenance7PropertiesKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceMaintenance7PropertiesKHR(@NotNull MemorySegment segment) implements IVkPhysicalDeviceMaintenance7PropertiesKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceMaintenance7PropertiesKHR.html"><code>VkPhysicalDeviceMaintenance7PropertiesKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceMaintenance7PropertiesKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceMaintenance7PropertiesKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceMaintenance7PropertiesKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceMaintenance7PropertiesKHR, Iterable<VkPhysicalDeviceMaintenance7PropertiesKHR> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceMaintenance7PropertiesKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceMaintenance7PropertiesKHR at(long index) {
            return new VkPhysicalDeviceMaintenance7PropertiesKHR(segment.asSlice(index * VkPhysicalDeviceMaintenance7PropertiesKHR.BYTES, VkPhysicalDeviceMaintenance7PropertiesKHR.BYTES));
        }

        public VkPhysicalDeviceMaintenance7PropertiesKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceMaintenance7PropertiesKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceMaintenance7PropertiesKHR value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceMaintenance7PropertiesKHR.BYTES, VkPhysicalDeviceMaintenance7PropertiesKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceMaintenance7PropertiesKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceMaintenance7PropertiesKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceMaintenance7PropertiesKHR.BYTES,
                (end - start) * VkPhysicalDeviceMaintenance7PropertiesKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceMaintenance7PropertiesKHR.BYTES));
        }

        public VkPhysicalDeviceMaintenance7PropertiesKHR[] toArray() {
            VkPhysicalDeviceMaintenance7PropertiesKHR[] ret = new VkPhysicalDeviceMaintenance7PropertiesKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceMaintenance7PropertiesKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceMaintenance7PropertiesKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceMaintenance7PropertiesKHR.BYTES;
            }

            @Override
            public VkPhysicalDeviceMaintenance7PropertiesKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceMaintenance7PropertiesKHR ret = new VkPhysicalDeviceMaintenance7PropertiesKHR(segment.asSlice(0, VkPhysicalDeviceMaintenance7PropertiesKHR.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceMaintenance7PropertiesKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceMaintenance7PropertiesKHR allocate(Arena arena) {
        VkPhysicalDeviceMaintenance7PropertiesKHR ret = new VkPhysicalDeviceMaintenance7PropertiesKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_MAINTENANCE_7_PROPERTIES_KHR);
        return ret;
    }

    public static VkPhysicalDeviceMaintenance7PropertiesKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceMaintenance7PropertiesKHR.Ptr ret = new VkPhysicalDeviceMaintenance7PropertiesKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_MAINTENANCE_7_PROPERTIES_KHR);
        }
        return ret;
    }

    public static VkPhysicalDeviceMaintenance7PropertiesKHR clone(Arena arena, VkPhysicalDeviceMaintenance7PropertiesKHR src) {
        VkPhysicalDeviceMaintenance7PropertiesKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_MAINTENANCE_7_PROPERTIES_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceMaintenance7PropertiesKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceMaintenance7PropertiesKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceMaintenance7PropertiesKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int robustFragmentShadingRateAttachmentAccess() {
        return segment.get(LAYOUT$robustFragmentShadingRateAttachmentAccess, OFFSET$robustFragmentShadingRateAttachmentAccess);
    }

    public VkPhysicalDeviceMaintenance7PropertiesKHR robustFragmentShadingRateAttachmentAccess(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$robustFragmentShadingRateAttachmentAccess, OFFSET$robustFragmentShadingRateAttachmentAccess, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int separateDepthStencilAttachmentAccess() {
        return segment.get(LAYOUT$separateDepthStencilAttachmentAccess, OFFSET$separateDepthStencilAttachmentAccess);
    }

    public VkPhysicalDeviceMaintenance7PropertiesKHR separateDepthStencilAttachmentAccess(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$separateDepthStencilAttachmentAccess, OFFSET$separateDepthStencilAttachmentAccess, value);
        return this;
    }

    public @Unsigned int maxDescriptorSetTotalUniformBuffersDynamic() {
        return segment.get(LAYOUT$maxDescriptorSetTotalUniformBuffersDynamic, OFFSET$maxDescriptorSetTotalUniformBuffersDynamic);
    }

    public VkPhysicalDeviceMaintenance7PropertiesKHR maxDescriptorSetTotalUniformBuffersDynamic(@Unsigned int value) {
        segment.set(LAYOUT$maxDescriptorSetTotalUniformBuffersDynamic, OFFSET$maxDescriptorSetTotalUniformBuffersDynamic, value);
        return this;
    }

    public @Unsigned int maxDescriptorSetTotalStorageBuffersDynamic() {
        return segment.get(LAYOUT$maxDescriptorSetTotalStorageBuffersDynamic, OFFSET$maxDescriptorSetTotalStorageBuffersDynamic);
    }

    public VkPhysicalDeviceMaintenance7PropertiesKHR maxDescriptorSetTotalStorageBuffersDynamic(@Unsigned int value) {
        segment.set(LAYOUT$maxDescriptorSetTotalStorageBuffersDynamic, OFFSET$maxDescriptorSetTotalStorageBuffersDynamic, value);
        return this;
    }

    public @Unsigned int maxDescriptorSetTotalBuffersDynamic() {
        return segment.get(LAYOUT$maxDescriptorSetTotalBuffersDynamic, OFFSET$maxDescriptorSetTotalBuffersDynamic);
    }

    public VkPhysicalDeviceMaintenance7PropertiesKHR maxDescriptorSetTotalBuffersDynamic(@Unsigned int value) {
        segment.set(LAYOUT$maxDescriptorSetTotalBuffersDynamic, OFFSET$maxDescriptorSetTotalBuffersDynamic, value);
        return this;
    }

    public @Unsigned int maxDescriptorSetUpdateAfterBindTotalUniformBuffersDynamic() {
        return segment.get(LAYOUT$maxDescriptorSetUpdateAfterBindTotalUniformBuffersDynamic, OFFSET$maxDescriptorSetUpdateAfterBindTotalUniformBuffersDynamic);
    }

    public VkPhysicalDeviceMaintenance7PropertiesKHR maxDescriptorSetUpdateAfterBindTotalUniformBuffersDynamic(@Unsigned int value) {
        segment.set(LAYOUT$maxDescriptorSetUpdateAfterBindTotalUniformBuffersDynamic, OFFSET$maxDescriptorSetUpdateAfterBindTotalUniformBuffersDynamic, value);
        return this;
    }

    public @Unsigned int maxDescriptorSetUpdateAfterBindTotalStorageBuffersDynamic() {
        return segment.get(LAYOUT$maxDescriptorSetUpdateAfterBindTotalStorageBuffersDynamic, OFFSET$maxDescriptorSetUpdateAfterBindTotalStorageBuffersDynamic);
    }

    public VkPhysicalDeviceMaintenance7PropertiesKHR maxDescriptorSetUpdateAfterBindTotalStorageBuffersDynamic(@Unsigned int value) {
        segment.set(LAYOUT$maxDescriptorSetUpdateAfterBindTotalStorageBuffersDynamic, OFFSET$maxDescriptorSetUpdateAfterBindTotalStorageBuffersDynamic, value);
        return this;
    }

    public @Unsigned int maxDescriptorSetUpdateAfterBindTotalBuffersDynamic() {
        return segment.get(LAYOUT$maxDescriptorSetUpdateAfterBindTotalBuffersDynamic, OFFSET$maxDescriptorSetUpdateAfterBindTotalBuffersDynamic);
    }

    public VkPhysicalDeviceMaintenance7PropertiesKHR maxDescriptorSetUpdateAfterBindTotalBuffersDynamic(@Unsigned int value) {
        segment.set(LAYOUT$maxDescriptorSetUpdateAfterBindTotalBuffersDynamic, OFFSET$maxDescriptorSetUpdateAfterBindTotalBuffersDynamic, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("robustFragmentShadingRateAttachmentAccess"),
        ValueLayout.JAVA_INT.withName("separateDepthStencilAttachmentAccess"),
        ValueLayout.JAVA_INT.withName("maxDescriptorSetTotalUniformBuffersDynamic"),
        ValueLayout.JAVA_INT.withName("maxDescriptorSetTotalStorageBuffersDynamic"),
        ValueLayout.JAVA_INT.withName("maxDescriptorSetTotalBuffersDynamic"),
        ValueLayout.JAVA_INT.withName("maxDescriptorSetUpdateAfterBindTotalUniformBuffersDynamic"),
        ValueLayout.JAVA_INT.withName("maxDescriptorSetUpdateAfterBindTotalStorageBuffersDynamic"),
        ValueLayout.JAVA_INT.withName("maxDescriptorSetUpdateAfterBindTotalBuffersDynamic")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$robustFragmentShadingRateAttachmentAccess = PathElement.groupElement("robustFragmentShadingRateAttachmentAccess");
    public static final PathElement PATH$separateDepthStencilAttachmentAccess = PathElement.groupElement("separateDepthStencilAttachmentAccess");
    public static final PathElement PATH$maxDescriptorSetTotalUniformBuffersDynamic = PathElement.groupElement("maxDescriptorSetTotalUniformBuffersDynamic");
    public static final PathElement PATH$maxDescriptorSetTotalStorageBuffersDynamic = PathElement.groupElement("maxDescriptorSetTotalStorageBuffersDynamic");
    public static final PathElement PATH$maxDescriptorSetTotalBuffersDynamic = PathElement.groupElement("maxDescriptorSetTotalBuffersDynamic");
    public static final PathElement PATH$maxDescriptorSetUpdateAfterBindTotalUniformBuffersDynamic = PathElement.groupElement("maxDescriptorSetUpdateAfterBindTotalUniformBuffersDynamic");
    public static final PathElement PATH$maxDescriptorSetUpdateAfterBindTotalStorageBuffersDynamic = PathElement.groupElement("maxDescriptorSetUpdateAfterBindTotalStorageBuffersDynamic");
    public static final PathElement PATH$maxDescriptorSetUpdateAfterBindTotalBuffersDynamic = PathElement.groupElement("maxDescriptorSetUpdateAfterBindTotalBuffersDynamic");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$robustFragmentShadingRateAttachmentAccess = (OfInt) LAYOUT.select(PATH$robustFragmentShadingRateAttachmentAccess);
    public static final OfInt LAYOUT$separateDepthStencilAttachmentAccess = (OfInt) LAYOUT.select(PATH$separateDepthStencilAttachmentAccess);
    public static final OfInt LAYOUT$maxDescriptorSetTotalUniformBuffersDynamic = (OfInt) LAYOUT.select(PATH$maxDescriptorSetTotalUniformBuffersDynamic);
    public static final OfInt LAYOUT$maxDescriptorSetTotalStorageBuffersDynamic = (OfInt) LAYOUT.select(PATH$maxDescriptorSetTotalStorageBuffersDynamic);
    public static final OfInt LAYOUT$maxDescriptorSetTotalBuffersDynamic = (OfInt) LAYOUT.select(PATH$maxDescriptorSetTotalBuffersDynamic);
    public static final OfInt LAYOUT$maxDescriptorSetUpdateAfterBindTotalUniformBuffersDynamic = (OfInt) LAYOUT.select(PATH$maxDescriptorSetUpdateAfterBindTotalUniformBuffersDynamic);
    public static final OfInt LAYOUT$maxDescriptorSetUpdateAfterBindTotalStorageBuffersDynamic = (OfInt) LAYOUT.select(PATH$maxDescriptorSetUpdateAfterBindTotalStorageBuffersDynamic);
    public static final OfInt LAYOUT$maxDescriptorSetUpdateAfterBindTotalBuffersDynamic = (OfInt) LAYOUT.select(PATH$maxDescriptorSetUpdateAfterBindTotalBuffersDynamic);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$robustFragmentShadingRateAttachmentAccess = LAYOUT$robustFragmentShadingRateAttachmentAccess.byteSize();
    public static final long SIZE$separateDepthStencilAttachmentAccess = LAYOUT$separateDepthStencilAttachmentAccess.byteSize();
    public static final long SIZE$maxDescriptorSetTotalUniformBuffersDynamic = LAYOUT$maxDescriptorSetTotalUniformBuffersDynamic.byteSize();
    public static final long SIZE$maxDescriptorSetTotalStorageBuffersDynamic = LAYOUT$maxDescriptorSetTotalStorageBuffersDynamic.byteSize();
    public static final long SIZE$maxDescriptorSetTotalBuffersDynamic = LAYOUT$maxDescriptorSetTotalBuffersDynamic.byteSize();
    public static final long SIZE$maxDescriptorSetUpdateAfterBindTotalUniformBuffersDynamic = LAYOUT$maxDescriptorSetUpdateAfterBindTotalUniformBuffersDynamic.byteSize();
    public static final long SIZE$maxDescriptorSetUpdateAfterBindTotalStorageBuffersDynamic = LAYOUT$maxDescriptorSetUpdateAfterBindTotalStorageBuffersDynamic.byteSize();
    public static final long SIZE$maxDescriptorSetUpdateAfterBindTotalBuffersDynamic = LAYOUT$maxDescriptorSetUpdateAfterBindTotalBuffersDynamic.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$robustFragmentShadingRateAttachmentAccess = LAYOUT.byteOffset(PATH$robustFragmentShadingRateAttachmentAccess);
    public static final long OFFSET$separateDepthStencilAttachmentAccess = LAYOUT.byteOffset(PATH$separateDepthStencilAttachmentAccess);
    public static final long OFFSET$maxDescriptorSetTotalUniformBuffersDynamic = LAYOUT.byteOffset(PATH$maxDescriptorSetTotalUniformBuffersDynamic);
    public static final long OFFSET$maxDescriptorSetTotalStorageBuffersDynamic = LAYOUT.byteOffset(PATH$maxDescriptorSetTotalStorageBuffersDynamic);
    public static final long OFFSET$maxDescriptorSetTotalBuffersDynamic = LAYOUT.byteOffset(PATH$maxDescriptorSetTotalBuffersDynamic);
    public static final long OFFSET$maxDescriptorSetUpdateAfterBindTotalUniformBuffersDynamic = LAYOUT.byteOffset(PATH$maxDescriptorSetUpdateAfterBindTotalUniformBuffersDynamic);
    public static final long OFFSET$maxDescriptorSetUpdateAfterBindTotalStorageBuffersDynamic = LAYOUT.byteOffset(PATH$maxDescriptorSetUpdateAfterBindTotalStorageBuffersDynamic);
    public static final long OFFSET$maxDescriptorSetUpdateAfterBindTotalBuffersDynamic = LAYOUT.byteOffset(PATH$maxDescriptorSetUpdateAfterBindTotalBuffersDynamic);
}
