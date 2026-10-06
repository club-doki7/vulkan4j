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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceImageProcessingPropertiesQCOM.html"><code>VkPhysicalDeviceImageProcessingPropertiesQCOM</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceImageProcessingPropertiesQCOM {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t maxWeightFilterPhases; // optional // @link substring="maxWeightFilterPhases" target="#maxWeightFilterPhases"
///     VkExtent2D maxWeightFilterDimension; // optional // @link substring="VkExtent2D" target="VkExtent2D" @link substring="maxWeightFilterDimension" target="#maxWeightFilterDimension"
///     VkExtent2D maxBlockMatchRegion; // optional // @link substring="VkExtent2D" target="VkExtent2D" @link substring="maxBlockMatchRegion" target="#maxBlockMatchRegion"
///     VkExtent2D maxBoxFilterBlockSize; // optional // @link substring="VkExtent2D" target="VkExtent2D" @link substring="maxBoxFilterBlockSize" target="#maxBoxFilterBlockSize"
/// } VkPhysicalDeviceImageProcessingPropertiesQCOM;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_IMAGE_PROCESSING_PROPERTIES_QCOM`
///
/// The {@code allocate} ({@link VkPhysicalDeviceImageProcessingPropertiesQCOM#allocate(Arena)}, {@link VkPhysicalDeviceImageProcessingPropertiesQCOM#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceImageProcessingPropertiesQCOM#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceImageProcessingPropertiesQCOM.html"><code>VkPhysicalDeviceImageProcessingPropertiesQCOM</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceImageProcessingPropertiesQCOM(@NotNull MemorySegment segment) implements IVkPhysicalDeviceImageProcessingPropertiesQCOM {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceImageProcessingPropertiesQCOM.html"><code>VkPhysicalDeviceImageProcessingPropertiesQCOM</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceImageProcessingPropertiesQCOM}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceImageProcessingPropertiesQCOM to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceImageProcessingPropertiesQCOM.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceImageProcessingPropertiesQCOM, Iterable<VkPhysicalDeviceImageProcessingPropertiesQCOM> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceImageProcessingPropertiesQCOM.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceImageProcessingPropertiesQCOM at(long index) {
            return new VkPhysicalDeviceImageProcessingPropertiesQCOM(segment.asSlice(index * VkPhysicalDeviceImageProcessingPropertiesQCOM.BYTES, VkPhysicalDeviceImageProcessingPropertiesQCOM.BYTES));
        }

        public VkPhysicalDeviceImageProcessingPropertiesQCOM.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceImageProcessingPropertiesQCOM> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceImageProcessingPropertiesQCOM value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceImageProcessingPropertiesQCOM.BYTES, VkPhysicalDeviceImageProcessingPropertiesQCOM.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceImageProcessingPropertiesQCOM.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceImageProcessingPropertiesQCOM.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceImageProcessingPropertiesQCOM.BYTES,
                (end - start) * VkPhysicalDeviceImageProcessingPropertiesQCOM.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceImageProcessingPropertiesQCOM.BYTES));
        }

        public VkPhysicalDeviceImageProcessingPropertiesQCOM[] toArray() {
            VkPhysicalDeviceImageProcessingPropertiesQCOM[] ret = new VkPhysicalDeviceImageProcessingPropertiesQCOM[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceImageProcessingPropertiesQCOM> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceImageProcessingPropertiesQCOM> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceImageProcessingPropertiesQCOM.BYTES;
            }

            @Override
            public VkPhysicalDeviceImageProcessingPropertiesQCOM next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceImageProcessingPropertiesQCOM ret = new VkPhysicalDeviceImageProcessingPropertiesQCOM(segment.asSlice(0, VkPhysicalDeviceImageProcessingPropertiesQCOM.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceImageProcessingPropertiesQCOM.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceImageProcessingPropertiesQCOM allocate(Arena arena) {
        VkPhysicalDeviceImageProcessingPropertiesQCOM ret = new VkPhysicalDeviceImageProcessingPropertiesQCOM(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_IMAGE_PROCESSING_PROPERTIES_QCOM);
        return ret;
    }

    public static VkPhysicalDeviceImageProcessingPropertiesQCOM.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceImageProcessingPropertiesQCOM.Ptr ret = new VkPhysicalDeviceImageProcessingPropertiesQCOM.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_IMAGE_PROCESSING_PROPERTIES_QCOM);
        }
        return ret;
    }

    public static VkPhysicalDeviceImageProcessingPropertiesQCOM clone(Arena arena, VkPhysicalDeviceImageProcessingPropertiesQCOM src) {
        VkPhysicalDeviceImageProcessingPropertiesQCOM ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_IMAGE_PROCESSING_PROPERTIES_QCOM);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceImageProcessingPropertiesQCOM sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceImageProcessingPropertiesQCOM pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceImageProcessingPropertiesQCOM pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int maxWeightFilterPhases() {
        return segment.get(LAYOUT$maxWeightFilterPhases, OFFSET$maxWeightFilterPhases);
    }

    public VkPhysicalDeviceImageProcessingPropertiesQCOM maxWeightFilterPhases(@Unsigned int value) {
        segment.set(LAYOUT$maxWeightFilterPhases, OFFSET$maxWeightFilterPhases, value);
        return this;
    }

    public @NotNull VkExtent2D maxWeightFilterDimension() {
        return new VkExtent2D(segment.asSlice(OFFSET$maxWeightFilterDimension, LAYOUT$maxWeightFilterDimension));
    }

    public VkPhysicalDeviceImageProcessingPropertiesQCOM maxWeightFilterDimension(@NotNull VkExtent2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$maxWeightFilterDimension, SIZE$maxWeightFilterDimension);
        return this;
    }

    public VkPhysicalDeviceImageProcessingPropertiesQCOM maxWeightFilterDimension(Consumer<@NotNull VkExtent2D> consumer) {
        consumer.accept(maxWeightFilterDimension());
        return this;
    }

    public @NotNull VkExtent2D maxBlockMatchRegion() {
        return new VkExtent2D(segment.asSlice(OFFSET$maxBlockMatchRegion, LAYOUT$maxBlockMatchRegion));
    }

    public VkPhysicalDeviceImageProcessingPropertiesQCOM maxBlockMatchRegion(@NotNull VkExtent2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$maxBlockMatchRegion, SIZE$maxBlockMatchRegion);
        return this;
    }

    public VkPhysicalDeviceImageProcessingPropertiesQCOM maxBlockMatchRegion(Consumer<@NotNull VkExtent2D> consumer) {
        consumer.accept(maxBlockMatchRegion());
        return this;
    }

    public @NotNull VkExtent2D maxBoxFilterBlockSize() {
        return new VkExtent2D(segment.asSlice(OFFSET$maxBoxFilterBlockSize, LAYOUT$maxBoxFilterBlockSize));
    }

    public VkPhysicalDeviceImageProcessingPropertiesQCOM maxBoxFilterBlockSize(@NotNull VkExtent2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$maxBoxFilterBlockSize, SIZE$maxBoxFilterBlockSize);
        return this;
    }

    public VkPhysicalDeviceImageProcessingPropertiesQCOM maxBoxFilterBlockSize(Consumer<@NotNull VkExtent2D> consumer) {
        consumer.accept(maxBoxFilterBlockSize());
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("maxWeightFilterPhases"),
        VkExtent2D.LAYOUT.withName("maxWeightFilterDimension"),
        VkExtent2D.LAYOUT.withName("maxBlockMatchRegion"),
        VkExtent2D.LAYOUT.withName("maxBoxFilterBlockSize")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$maxWeightFilterPhases = PathElement.groupElement("maxWeightFilterPhases");
    public static final PathElement PATH$maxWeightFilterDimension = PathElement.groupElement("maxWeightFilterDimension");
    public static final PathElement PATH$maxBlockMatchRegion = PathElement.groupElement("maxBlockMatchRegion");
    public static final PathElement PATH$maxBoxFilterBlockSize = PathElement.groupElement("maxBoxFilterBlockSize");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$maxWeightFilterPhases = (OfInt) LAYOUT.select(PATH$maxWeightFilterPhases);
    public static final StructLayout LAYOUT$maxWeightFilterDimension = (StructLayout) LAYOUT.select(PATH$maxWeightFilterDimension);
    public static final StructLayout LAYOUT$maxBlockMatchRegion = (StructLayout) LAYOUT.select(PATH$maxBlockMatchRegion);
    public static final StructLayout LAYOUT$maxBoxFilterBlockSize = (StructLayout) LAYOUT.select(PATH$maxBoxFilterBlockSize);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$maxWeightFilterPhases = LAYOUT$maxWeightFilterPhases.byteSize();
    public static final long SIZE$maxWeightFilterDimension = LAYOUT$maxWeightFilterDimension.byteSize();
    public static final long SIZE$maxBlockMatchRegion = LAYOUT$maxBlockMatchRegion.byteSize();
    public static final long SIZE$maxBoxFilterBlockSize = LAYOUT$maxBoxFilterBlockSize.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$maxWeightFilterPhases = LAYOUT.byteOffset(PATH$maxWeightFilterPhases);
    public static final long OFFSET$maxWeightFilterDimension = LAYOUT.byteOffset(PATH$maxWeightFilterDimension);
    public static final long OFFSET$maxBlockMatchRegion = LAYOUT.byteOffset(PATH$maxBlockMatchRegion);
    public static final long OFFSET$maxBoxFilterBlockSize = LAYOUT.byteOffset(PATH$maxBoxFilterBlockSize);
}
