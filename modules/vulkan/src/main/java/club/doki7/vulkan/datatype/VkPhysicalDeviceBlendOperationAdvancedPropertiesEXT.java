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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.html"><code>VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t advancedBlendMaxColorAttachments; // @link substring="advancedBlendMaxColorAttachments" target="#advancedBlendMaxColorAttachments"
///     VkBool32 advancedBlendIndependentBlend; // @link substring="advancedBlendIndependentBlend" target="#advancedBlendIndependentBlend"
///     VkBool32 advancedBlendNonPremultipliedSrcColor; // @link substring="advancedBlendNonPremultipliedSrcColor" target="#advancedBlendNonPremultipliedSrcColor"
///     VkBool32 advancedBlendNonPremultipliedDstColor; // @link substring="advancedBlendNonPremultipliedDstColor" target="#advancedBlendNonPremultipliedDstColor"
///     VkBool32 advancedBlendCorrelatedOverlap; // @link substring="advancedBlendCorrelatedOverlap" target="#advancedBlendCorrelatedOverlap"
///     VkBool32 advancedBlendAllOperations; // @link substring="advancedBlendAllOperations" target="#advancedBlendAllOperations"
/// } VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_BLEND_OPERATION_ADVANCED_PROPERTIES_EXT`
///
/// The {@code allocate} ({@link VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT#allocate(Arena)}, {@link VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.html"><code>VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT(@NotNull MemorySegment segment) implements IVkPhysicalDeviceBlendOperationAdvancedPropertiesEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.html"><code>VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceBlendOperationAdvancedPropertiesEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceBlendOperationAdvancedPropertiesEXT, Iterable<VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT at(long index) {
            return new VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT(segment.asSlice(index * VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.BYTES, VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.BYTES));
        }

        public VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.BYTES, VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.BYTES,
                (end - start) * VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.BYTES));
        }

        public VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT[] toArray() {
            VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT[] ret = new VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.BYTES;
            }

            @Override
            public VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT ret = new VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT(segment.asSlice(0, VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT allocate(Arena arena) {
        VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT ret = new VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_BLEND_OPERATION_ADVANCED_PROPERTIES_EXT);
        return ret;
    }

    public static VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.Ptr ret = new VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_BLEND_OPERATION_ADVANCED_PROPERTIES_EXT);
        }
        return ret;
    }

    public static VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT clone(Arena arena, VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT src) {
        VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_BLEND_OPERATION_ADVANCED_PROPERTIES_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int advancedBlendMaxColorAttachments() {
        return segment.get(LAYOUT$advancedBlendMaxColorAttachments, OFFSET$advancedBlendMaxColorAttachments);
    }

    public VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT advancedBlendMaxColorAttachments(@Unsigned int value) {
        segment.set(LAYOUT$advancedBlendMaxColorAttachments, OFFSET$advancedBlendMaxColorAttachments, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int advancedBlendIndependentBlend() {
        return segment.get(LAYOUT$advancedBlendIndependentBlend, OFFSET$advancedBlendIndependentBlend);
    }

    public VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT advancedBlendIndependentBlend(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$advancedBlendIndependentBlend, OFFSET$advancedBlendIndependentBlend, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int advancedBlendNonPremultipliedSrcColor() {
        return segment.get(LAYOUT$advancedBlendNonPremultipliedSrcColor, OFFSET$advancedBlendNonPremultipliedSrcColor);
    }

    public VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT advancedBlendNonPremultipliedSrcColor(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$advancedBlendNonPremultipliedSrcColor, OFFSET$advancedBlendNonPremultipliedSrcColor, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int advancedBlendNonPremultipliedDstColor() {
        return segment.get(LAYOUT$advancedBlendNonPremultipliedDstColor, OFFSET$advancedBlendNonPremultipliedDstColor);
    }

    public VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT advancedBlendNonPremultipliedDstColor(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$advancedBlendNonPremultipliedDstColor, OFFSET$advancedBlendNonPremultipliedDstColor, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int advancedBlendCorrelatedOverlap() {
        return segment.get(LAYOUT$advancedBlendCorrelatedOverlap, OFFSET$advancedBlendCorrelatedOverlap);
    }

    public VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT advancedBlendCorrelatedOverlap(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$advancedBlendCorrelatedOverlap, OFFSET$advancedBlendCorrelatedOverlap, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int advancedBlendAllOperations() {
        return segment.get(LAYOUT$advancedBlendAllOperations, OFFSET$advancedBlendAllOperations);
    }

    public VkPhysicalDeviceBlendOperationAdvancedPropertiesEXT advancedBlendAllOperations(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$advancedBlendAllOperations, OFFSET$advancedBlendAllOperations, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("advancedBlendMaxColorAttachments"),
        ValueLayout.JAVA_INT.withName("advancedBlendIndependentBlend"),
        ValueLayout.JAVA_INT.withName("advancedBlendNonPremultipliedSrcColor"),
        ValueLayout.JAVA_INT.withName("advancedBlendNonPremultipliedDstColor"),
        ValueLayout.JAVA_INT.withName("advancedBlendCorrelatedOverlap"),
        ValueLayout.JAVA_INT.withName("advancedBlendAllOperations")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$advancedBlendMaxColorAttachments = PathElement.groupElement("advancedBlendMaxColorAttachments");
    public static final PathElement PATH$advancedBlendIndependentBlend = PathElement.groupElement("advancedBlendIndependentBlend");
    public static final PathElement PATH$advancedBlendNonPremultipliedSrcColor = PathElement.groupElement("advancedBlendNonPremultipliedSrcColor");
    public static final PathElement PATH$advancedBlendNonPremultipliedDstColor = PathElement.groupElement("advancedBlendNonPremultipliedDstColor");
    public static final PathElement PATH$advancedBlendCorrelatedOverlap = PathElement.groupElement("advancedBlendCorrelatedOverlap");
    public static final PathElement PATH$advancedBlendAllOperations = PathElement.groupElement("advancedBlendAllOperations");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$advancedBlendMaxColorAttachments = (OfInt) LAYOUT.select(PATH$advancedBlendMaxColorAttachments);
    public static final OfInt LAYOUT$advancedBlendIndependentBlend = (OfInt) LAYOUT.select(PATH$advancedBlendIndependentBlend);
    public static final OfInt LAYOUT$advancedBlendNonPremultipliedSrcColor = (OfInt) LAYOUT.select(PATH$advancedBlendNonPremultipliedSrcColor);
    public static final OfInt LAYOUT$advancedBlendNonPremultipliedDstColor = (OfInt) LAYOUT.select(PATH$advancedBlendNonPremultipliedDstColor);
    public static final OfInt LAYOUT$advancedBlendCorrelatedOverlap = (OfInt) LAYOUT.select(PATH$advancedBlendCorrelatedOverlap);
    public static final OfInt LAYOUT$advancedBlendAllOperations = (OfInt) LAYOUT.select(PATH$advancedBlendAllOperations);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$advancedBlendMaxColorAttachments = LAYOUT$advancedBlendMaxColorAttachments.byteSize();
    public static final long SIZE$advancedBlendIndependentBlend = LAYOUT$advancedBlendIndependentBlend.byteSize();
    public static final long SIZE$advancedBlendNonPremultipliedSrcColor = LAYOUT$advancedBlendNonPremultipliedSrcColor.byteSize();
    public static final long SIZE$advancedBlendNonPremultipliedDstColor = LAYOUT$advancedBlendNonPremultipliedDstColor.byteSize();
    public static final long SIZE$advancedBlendCorrelatedOverlap = LAYOUT$advancedBlendCorrelatedOverlap.byteSize();
    public static final long SIZE$advancedBlendAllOperations = LAYOUT$advancedBlendAllOperations.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$advancedBlendMaxColorAttachments = LAYOUT.byteOffset(PATH$advancedBlendMaxColorAttachments);
    public static final long OFFSET$advancedBlendIndependentBlend = LAYOUT.byteOffset(PATH$advancedBlendIndependentBlend);
    public static final long OFFSET$advancedBlendNonPremultipliedSrcColor = LAYOUT.byteOffset(PATH$advancedBlendNonPremultipliedSrcColor);
    public static final long OFFSET$advancedBlendNonPremultipliedDstColor = LAYOUT.byteOffset(PATH$advancedBlendNonPremultipliedDstColor);
    public static final long OFFSET$advancedBlendCorrelatedOverlap = LAYOUT.byteOffset(PATH$advancedBlendCorrelatedOverlap);
    public static final long OFFSET$advancedBlendAllOperations = LAYOUT.byteOffset(PATH$advancedBlendAllOperations);
}
