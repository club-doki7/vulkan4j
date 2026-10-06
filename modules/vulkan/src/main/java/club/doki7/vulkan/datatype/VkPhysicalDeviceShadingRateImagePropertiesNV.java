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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceShadingRateImagePropertiesNV.html"><code>VkPhysicalDeviceShadingRateImagePropertiesNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceShadingRateImagePropertiesNV {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkExtent2D shadingRateTexelSize; // @link substring="VkExtent2D" target="VkExtent2D" @link substring="shadingRateTexelSize" target="#shadingRateTexelSize"
///     uint32_t shadingRatePaletteSize; // @link substring="shadingRatePaletteSize" target="#shadingRatePaletteSize"
///     uint32_t shadingRateMaxCoarseSamples; // @link substring="shadingRateMaxCoarseSamples" target="#shadingRateMaxCoarseSamples"
/// } VkPhysicalDeviceShadingRateImagePropertiesNV;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SHADING_RATE_IMAGE_PROPERTIES_NV`
///
/// The {@code allocate} ({@link VkPhysicalDeviceShadingRateImagePropertiesNV#allocate(Arena)}, {@link VkPhysicalDeviceShadingRateImagePropertiesNV#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceShadingRateImagePropertiesNV#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceShadingRateImagePropertiesNV.html"><code>VkPhysicalDeviceShadingRateImagePropertiesNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceShadingRateImagePropertiesNV(@NotNull MemorySegment segment) implements IVkPhysicalDeviceShadingRateImagePropertiesNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceShadingRateImagePropertiesNV.html"><code>VkPhysicalDeviceShadingRateImagePropertiesNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceShadingRateImagePropertiesNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceShadingRateImagePropertiesNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceShadingRateImagePropertiesNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceShadingRateImagePropertiesNV, Iterable<VkPhysicalDeviceShadingRateImagePropertiesNV> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceShadingRateImagePropertiesNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceShadingRateImagePropertiesNV at(long index) {
            return new VkPhysicalDeviceShadingRateImagePropertiesNV(segment.asSlice(index * VkPhysicalDeviceShadingRateImagePropertiesNV.BYTES, VkPhysicalDeviceShadingRateImagePropertiesNV.BYTES));
        }

        public VkPhysicalDeviceShadingRateImagePropertiesNV.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceShadingRateImagePropertiesNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceShadingRateImagePropertiesNV value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceShadingRateImagePropertiesNV.BYTES, VkPhysicalDeviceShadingRateImagePropertiesNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceShadingRateImagePropertiesNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceShadingRateImagePropertiesNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceShadingRateImagePropertiesNV.BYTES,
                (end - start) * VkPhysicalDeviceShadingRateImagePropertiesNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceShadingRateImagePropertiesNV.BYTES));
        }

        public VkPhysicalDeviceShadingRateImagePropertiesNV[] toArray() {
            VkPhysicalDeviceShadingRateImagePropertiesNV[] ret = new VkPhysicalDeviceShadingRateImagePropertiesNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceShadingRateImagePropertiesNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceShadingRateImagePropertiesNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceShadingRateImagePropertiesNV.BYTES;
            }

            @Override
            public VkPhysicalDeviceShadingRateImagePropertiesNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceShadingRateImagePropertiesNV ret = new VkPhysicalDeviceShadingRateImagePropertiesNV(segment.asSlice(0, VkPhysicalDeviceShadingRateImagePropertiesNV.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceShadingRateImagePropertiesNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceShadingRateImagePropertiesNV allocate(Arena arena) {
        VkPhysicalDeviceShadingRateImagePropertiesNV ret = new VkPhysicalDeviceShadingRateImagePropertiesNV(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_SHADING_RATE_IMAGE_PROPERTIES_NV);
        return ret;
    }

    public static VkPhysicalDeviceShadingRateImagePropertiesNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceShadingRateImagePropertiesNV.Ptr ret = new VkPhysicalDeviceShadingRateImagePropertiesNV.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_SHADING_RATE_IMAGE_PROPERTIES_NV);
        }
        return ret;
    }

    public static VkPhysicalDeviceShadingRateImagePropertiesNV clone(Arena arena, VkPhysicalDeviceShadingRateImagePropertiesNV src) {
        VkPhysicalDeviceShadingRateImagePropertiesNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_SHADING_RATE_IMAGE_PROPERTIES_NV);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceShadingRateImagePropertiesNV sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceShadingRateImagePropertiesNV pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceShadingRateImagePropertiesNV pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NotNull VkExtent2D shadingRateTexelSize() {
        return new VkExtent2D(segment.asSlice(OFFSET$shadingRateTexelSize, LAYOUT$shadingRateTexelSize));
    }

    public VkPhysicalDeviceShadingRateImagePropertiesNV shadingRateTexelSize(@NotNull VkExtent2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$shadingRateTexelSize, SIZE$shadingRateTexelSize);
        return this;
    }

    public VkPhysicalDeviceShadingRateImagePropertiesNV shadingRateTexelSize(Consumer<@NotNull VkExtent2D> consumer) {
        consumer.accept(shadingRateTexelSize());
        return this;
    }

    public @Unsigned int shadingRatePaletteSize() {
        return segment.get(LAYOUT$shadingRatePaletteSize, OFFSET$shadingRatePaletteSize);
    }

    public VkPhysicalDeviceShadingRateImagePropertiesNV shadingRatePaletteSize(@Unsigned int value) {
        segment.set(LAYOUT$shadingRatePaletteSize, OFFSET$shadingRatePaletteSize, value);
        return this;
    }

    public @Unsigned int shadingRateMaxCoarseSamples() {
        return segment.get(LAYOUT$shadingRateMaxCoarseSamples, OFFSET$shadingRateMaxCoarseSamples);
    }

    public VkPhysicalDeviceShadingRateImagePropertiesNV shadingRateMaxCoarseSamples(@Unsigned int value) {
        segment.set(LAYOUT$shadingRateMaxCoarseSamples, OFFSET$shadingRateMaxCoarseSamples, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        VkExtent2D.LAYOUT.withName("shadingRateTexelSize"),
        ValueLayout.JAVA_INT.withName("shadingRatePaletteSize"),
        ValueLayout.JAVA_INT.withName("shadingRateMaxCoarseSamples")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$shadingRateTexelSize = PathElement.groupElement("shadingRateTexelSize");
    public static final PathElement PATH$shadingRatePaletteSize = PathElement.groupElement("shadingRatePaletteSize");
    public static final PathElement PATH$shadingRateMaxCoarseSamples = PathElement.groupElement("shadingRateMaxCoarseSamples");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final StructLayout LAYOUT$shadingRateTexelSize = (StructLayout) LAYOUT.select(PATH$shadingRateTexelSize);
    public static final OfInt LAYOUT$shadingRatePaletteSize = (OfInt) LAYOUT.select(PATH$shadingRatePaletteSize);
    public static final OfInt LAYOUT$shadingRateMaxCoarseSamples = (OfInt) LAYOUT.select(PATH$shadingRateMaxCoarseSamples);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$shadingRateTexelSize = LAYOUT$shadingRateTexelSize.byteSize();
    public static final long SIZE$shadingRatePaletteSize = LAYOUT$shadingRatePaletteSize.byteSize();
    public static final long SIZE$shadingRateMaxCoarseSamples = LAYOUT$shadingRateMaxCoarseSamples.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$shadingRateTexelSize = LAYOUT.byteOffset(PATH$shadingRateTexelSize);
    public static final long OFFSET$shadingRatePaletteSize = LAYOUT.byteOffset(PATH$shadingRatePaletteSize);
    public static final long OFFSET$shadingRateMaxCoarseSamples = LAYOUT.byteOffset(PATH$shadingRateMaxCoarseSamples);
}
