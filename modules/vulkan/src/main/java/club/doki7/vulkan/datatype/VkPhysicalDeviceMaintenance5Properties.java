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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceMaintenance5Properties.html"><code>VkPhysicalDeviceMaintenance5Properties</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceMaintenance5Properties {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 earlyFragmentMultisampleCoverageAfterSampleCounting; // @link substring="earlyFragmentMultisampleCoverageAfterSampleCounting" target="#earlyFragmentMultisampleCoverageAfterSampleCounting"
///     VkBool32 earlyFragmentSampleMaskTestBeforeSampleCounting; // @link substring="earlyFragmentSampleMaskTestBeforeSampleCounting" target="#earlyFragmentSampleMaskTestBeforeSampleCounting"
///     VkBool32 depthStencilSwizzleOneSupport; // @link substring="depthStencilSwizzleOneSupport" target="#depthStencilSwizzleOneSupport"
///     VkBool32 polygonModePointSize; // @link substring="polygonModePointSize" target="#polygonModePointSize"
///     VkBool32 nonStrictSinglePixelWideLinesUseParallelogram; // @link substring="nonStrictSinglePixelWideLinesUseParallelogram" target="#nonStrictSinglePixelWideLinesUseParallelogram"
///     VkBool32 nonStrictWideLinesUseParallelogram; // @link substring="nonStrictWideLinesUseParallelogram" target="#nonStrictWideLinesUseParallelogram"
/// } VkPhysicalDeviceMaintenance5Properties;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_MAINTENANCE_5_PROPERTIES`
///
/// The {@code allocate} ({@link VkPhysicalDeviceMaintenance5Properties#allocate(Arena)}, {@link VkPhysicalDeviceMaintenance5Properties#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceMaintenance5Properties#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceMaintenance5Properties.html"><code>VkPhysicalDeviceMaintenance5Properties</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceMaintenance5Properties(@NotNull MemorySegment segment) implements IVkPhysicalDeviceMaintenance5Properties {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceMaintenance5Properties.html"><code>VkPhysicalDeviceMaintenance5Properties</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceMaintenance5Properties}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceMaintenance5Properties to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceMaintenance5Properties.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceMaintenance5Properties, Iterable<VkPhysicalDeviceMaintenance5Properties> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceMaintenance5Properties.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceMaintenance5Properties at(long index) {
            return new VkPhysicalDeviceMaintenance5Properties(segment.asSlice(index * VkPhysicalDeviceMaintenance5Properties.BYTES, VkPhysicalDeviceMaintenance5Properties.BYTES));
        }

        public VkPhysicalDeviceMaintenance5Properties.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceMaintenance5Properties> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceMaintenance5Properties value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceMaintenance5Properties.BYTES, VkPhysicalDeviceMaintenance5Properties.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceMaintenance5Properties.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceMaintenance5Properties.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceMaintenance5Properties.BYTES,
                (end - start) * VkPhysicalDeviceMaintenance5Properties.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceMaintenance5Properties.BYTES));
        }

        public VkPhysicalDeviceMaintenance5Properties[] toArray() {
            VkPhysicalDeviceMaintenance5Properties[] ret = new VkPhysicalDeviceMaintenance5Properties[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceMaintenance5Properties> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceMaintenance5Properties> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceMaintenance5Properties.BYTES;
            }

            @Override
            public VkPhysicalDeviceMaintenance5Properties next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceMaintenance5Properties ret = new VkPhysicalDeviceMaintenance5Properties(segment.asSlice(0, VkPhysicalDeviceMaintenance5Properties.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceMaintenance5Properties.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceMaintenance5Properties allocate(Arena arena) {
        VkPhysicalDeviceMaintenance5Properties ret = new VkPhysicalDeviceMaintenance5Properties(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_MAINTENANCE_5_PROPERTIES);
        return ret;
    }

    public static VkPhysicalDeviceMaintenance5Properties.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceMaintenance5Properties.Ptr ret = new VkPhysicalDeviceMaintenance5Properties.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_MAINTENANCE_5_PROPERTIES);
        }
        return ret;
    }

    public static VkPhysicalDeviceMaintenance5Properties clone(Arena arena, VkPhysicalDeviceMaintenance5Properties src) {
        VkPhysicalDeviceMaintenance5Properties ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_MAINTENANCE_5_PROPERTIES);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceMaintenance5Properties sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceMaintenance5Properties pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceMaintenance5Properties pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int earlyFragmentMultisampleCoverageAfterSampleCounting() {
        return segment.get(LAYOUT$earlyFragmentMultisampleCoverageAfterSampleCounting, OFFSET$earlyFragmentMultisampleCoverageAfterSampleCounting);
    }

    public VkPhysicalDeviceMaintenance5Properties earlyFragmentMultisampleCoverageAfterSampleCounting(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$earlyFragmentMultisampleCoverageAfterSampleCounting, OFFSET$earlyFragmentMultisampleCoverageAfterSampleCounting, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int earlyFragmentSampleMaskTestBeforeSampleCounting() {
        return segment.get(LAYOUT$earlyFragmentSampleMaskTestBeforeSampleCounting, OFFSET$earlyFragmentSampleMaskTestBeforeSampleCounting);
    }

    public VkPhysicalDeviceMaintenance5Properties earlyFragmentSampleMaskTestBeforeSampleCounting(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$earlyFragmentSampleMaskTestBeforeSampleCounting, OFFSET$earlyFragmentSampleMaskTestBeforeSampleCounting, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int depthStencilSwizzleOneSupport() {
        return segment.get(LAYOUT$depthStencilSwizzleOneSupport, OFFSET$depthStencilSwizzleOneSupport);
    }

    public VkPhysicalDeviceMaintenance5Properties depthStencilSwizzleOneSupport(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$depthStencilSwizzleOneSupport, OFFSET$depthStencilSwizzleOneSupport, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int polygonModePointSize() {
        return segment.get(LAYOUT$polygonModePointSize, OFFSET$polygonModePointSize);
    }

    public VkPhysicalDeviceMaintenance5Properties polygonModePointSize(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$polygonModePointSize, OFFSET$polygonModePointSize, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int nonStrictSinglePixelWideLinesUseParallelogram() {
        return segment.get(LAYOUT$nonStrictSinglePixelWideLinesUseParallelogram, OFFSET$nonStrictSinglePixelWideLinesUseParallelogram);
    }

    public VkPhysicalDeviceMaintenance5Properties nonStrictSinglePixelWideLinesUseParallelogram(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$nonStrictSinglePixelWideLinesUseParallelogram, OFFSET$nonStrictSinglePixelWideLinesUseParallelogram, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int nonStrictWideLinesUseParallelogram() {
        return segment.get(LAYOUT$nonStrictWideLinesUseParallelogram, OFFSET$nonStrictWideLinesUseParallelogram);
    }

    public VkPhysicalDeviceMaintenance5Properties nonStrictWideLinesUseParallelogram(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$nonStrictWideLinesUseParallelogram, OFFSET$nonStrictWideLinesUseParallelogram, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("earlyFragmentMultisampleCoverageAfterSampleCounting"),
        ValueLayout.JAVA_INT.withName("earlyFragmentSampleMaskTestBeforeSampleCounting"),
        ValueLayout.JAVA_INT.withName("depthStencilSwizzleOneSupport"),
        ValueLayout.JAVA_INT.withName("polygonModePointSize"),
        ValueLayout.JAVA_INT.withName("nonStrictSinglePixelWideLinesUseParallelogram"),
        ValueLayout.JAVA_INT.withName("nonStrictWideLinesUseParallelogram")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$earlyFragmentMultisampleCoverageAfterSampleCounting = PathElement.groupElement("earlyFragmentMultisampleCoverageAfterSampleCounting");
    public static final PathElement PATH$earlyFragmentSampleMaskTestBeforeSampleCounting = PathElement.groupElement("earlyFragmentSampleMaskTestBeforeSampleCounting");
    public static final PathElement PATH$depthStencilSwizzleOneSupport = PathElement.groupElement("depthStencilSwizzleOneSupport");
    public static final PathElement PATH$polygonModePointSize = PathElement.groupElement("polygonModePointSize");
    public static final PathElement PATH$nonStrictSinglePixelWideLinesUseParallelogram = PathElement.groupElement("nonStrictSinglePixelWideLinesUseParallelogram");
    public static final PathElement PATH$nonStrictWideLinesUseParallelogram = PathElement.groupElement("nonStrictWideLinesUseParallelogram");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$earlyFragmentMultisampleCoverageAfterSampleCounting = (OfInt) LAYOUT.select(PATH$earlyFragmentMultisampleCoverageAfterSampleCounting);
    public static final OfInt LAYOUT$earlyFragmentSampleMaskTestBeforeSampleCounting = (OfInt) LAYOUT.select(PATH$earlyFragmentSampleMaskTestBeforeSampleCounting);
    public static final OfInt LAYOUT$depthStencilSwizzleOneSupport = (OfInt) LAYOUT.select(PATH$depthStencilSwizzleOneSupport);
    public static final OfInt LAYOUT$polygonModePointSize = (OfInt) LAYOUT.select(PATH$polygonModePointSize);
    public static final OfInt LAYOUT$nonStrictSinglePixelWideLinesUseParallelogram = (OfInt) LAYOUT.select(PATH$nonStrictSinglePixelWideLinesUseParallelogram);
    public static final OfInt LAYOUT$nonStrictWideLinesUseParallelogram = (OfInt) LAYOUT.select(PATH$nonStrictWideLinesUseParallelogram);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$earlyFragmentMultisampleCoverageAfterSampleCounting = LAYOUT$earlyFragmentMultisampleCoverageAfterSampleCounting.byteSize();
    public static final long SIZE$earlyFragmentSampleMaskTestBeforeSampleCounting = LAYOUT$earlyFragmentSampleMaskTestBeforeSampleCounting.byteSize();
    public static final long SIZE$depthStencilSwizzleOneSupport = LAYOUT$depthStencilSwizzleOneSupport.byteSize();
    public static final long SIZE$polygonModePointSize = LAYOUT$polygonModePointSize.byteSize();
    public static final long SIZE$nonStrictSinglePixelWideLinesUseParallelogram = LAYOUT$nonStrictSinglePixelWideLinesUseParallelogram.byteSize();
    public static final long SIZE$nonStrictWideLinesUseParallelogram = LAYOUT$nonStrictWideLinesUseParallelogram.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$earlyFragmentMultisampleCoverageAfterSampleCounting = LAYOUT.byteOffset(PATH$earlyFragmentMultisampleCoverageAfterSampleCounting);
    public static final long OFFSET$earlyFragmentSampleMaskTestBeforeSampleCounting = LAYOUT.byteOffset(PATH$earlyFragmentSampleMaskTestBeforeSampleCounting);
    public static final long OFFSET$depthStencilSwizzleOneSupport = LAYOUT.byteOffset(PATH$depthStencilSwizzleOneSupport);
    public static final long OFFSET$polygonModePointSize = LAYOUT.byteOffset(PATH$polygonModePointSize);
    public static final long OFFSET$nonStrictSinglePixelWideLinesUseParallelogram = LAYOUT.byteOffset(PATH$nonStrictSinglePixelWideLinesUseParallelogram);
    public static final long OFFSET$nonStrictWideLinesUseParallelogram = LAYOUT.byteOffset(PATH$nonStrictWideLinesUseParallelogram);
}
