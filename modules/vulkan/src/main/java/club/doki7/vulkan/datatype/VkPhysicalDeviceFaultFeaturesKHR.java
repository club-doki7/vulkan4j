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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceFaultFeaturesKHR.html"><code>VkPhysicalDeviceFaultFeaturesKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceFaultFeaturesKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 deviceFault; // @link substring="deviceFault" target="#deviceFault"
///     VkBool32 deviceFaultVendorBinary; // @link substring="deviceFaultVendorBinary" target="#deviceFaultVendorBinary"
///     VkBool32 deviceFaultReportMasked; // @link substring="deviceFaultReportMasked" target="#deviceFaultReportMasked"
///     VkBool32 deviceFaultDeviceLostOnMasked; // @link substring="deviceFaultDeviceLostOnMasked" target="#deviceFaultDeviceLostOnMasked"
/// } VkPhysicalDeviceFaultFeaturesKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_FAULT_FEATURES_KHR`
///
/// The {@code allocate} ({@link VkPhysicalDeviceFaultFeaturesKHR#allocate(Arena)}, {@link VkPhysicalDeviceFaultFeaturesKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceFaultFeaturesKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceFaultFeaturesKHR.html"><code>VkPhysicalDeviceFaultFeaturesKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceFaultFeaturesKHR(@NotNull MemorySegment segment) implements IVkPhysicalDeviceFaultFeaturesKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceFaultFeaturesKHR.html"><code>VkPhysicalDeviceFaultFeaturesKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceFaultFeaturesKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceFaultFeaturesKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceFaultFeaturesKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceFaultFeaturesKHR, Iterable<VkPhysicalDeviceFaultFeaturesKHR> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceFaultFeaturesKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceFaultFeaturesKHR at(long index) {
            return new VkPhysicalDeviceFaultFeaturesKHR(segment.asSlice(index * VkPhysicalDeviceFaultFeaturesKHR.BYTES, VkPhysicalDeviceFaultFeaturesKHR.BYTES));
        }

        public VkPhysicalDeviceFaultFeaturesKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceFaultFeaturesKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceFaultFeaturesKHR value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceFaultFeaturesKHR.BYTES, VkPhysicalDeviceFaultFeaturesKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceFaultFeaturesKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceFaultFeaturesKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceFaultFeaturesKHR.BYTES,
                (end - start) * VkPhysicalDeviceFaultFeaturesKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceFaultFeaturesKHR.BYTES));
        }

        public VkPhysicalDeviceFaultFeaturesKHR[] toArray() {
            VkPhysicalDeviceFaultFeaturesKHR[] ret = new VkPhysicalDeviceFaultFeaturesKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceFaultFeaturesKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceFaultFeaturesKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceFaultFeaturesKHR.BYTES;
            }

            @Override
            public VkPhysicalDeviceFaultFeaturesKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceFaultFeaturesKHR ret = new VkPhysicalDeviceFaultFeaturesKHR(segment.asSlice(0, VkPhysicalDeviceFaultFeaturesKHR.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceFaultFeaturesKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceFaultFeaturesKHR allocate(Arena arena) {
        VkPhysicalDeviceFaultFeaturesKHR ret = new VkPhysicalDeviceFaultFeaturesKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_FAULT_FEATURES_KHR);
        return ret;
    }

    public static VkPhysicalDeviceFaultFeaturesKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceFaultFeaturesKHR.Ptr ret = new VkPhysicalDeviceFaultFeaturesKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_FAULT_FEATURES_KHR);
        }
        return ret;
    }

    public static VkPhysicalDeviceFaultFeaturesKHR clone(Arena arena, VkPhysicalDeviceFaultFeaturesKHR src) {
        VkPhysicalDeviceFaultFeaturesKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_FAULT_FEATURES_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceFaultFeaturesKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceFaultFeaturesKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceFaultFeaturesKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int deviceFault() {
        return segment.get(LAYOUT$deviceFault, OFFSET$deviceFault);
    }

    public VkPhysicalDeviceFaultFeaturesKHR deviceFault(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$deviceFault, OFFSET$deviceFault, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int deviceFaultVendorBinary() {
        return segment.get(LAYOUT$deviceFaultVendorBinary, OFFSET$deviceFaultVendorBinary);
    }

    public VkPhysicalDeviceFaultFeaturesKHR deviceFaultVendorBinary(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$deviceFaultVendorBinary, OFFSET$deviceFaultVendorBinary, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int deviceFaultReportMasked() {
        return segment.get(LAYOUT$deviceFaultReportMasked, OFFSET$deviceFaultReportMasked);
    }

    public VkPhysicalDeviceFaultFeaturesKHR deviceFaultReportMasked(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$deviceFaultReportMasked, OFFSET$deviceFaultReportMasked, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int deviceFaultDeviceLostOnMasked() {
        return segment.get(LAYOUT$deviceFaultDeviceLostOnMasked, OFFSET$deviceFaultDeviceLostOnMasked);
    }

    public VkPhysicalDeviceFaultFeaturesKHR deviceFaultDeviceLostOnMasked(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$deviceFaultDeviceLostOnMasked, OFFSET$deviceFaultDeviceLostOnMasked, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("deviceFault"),
        ValueLayout.JAVA_INT.withName("deviceFaultVendorBinary"),
        ValueLayout.JAVA_INT.withName("deviceFaultReportMasked"),
        ValueLayout.JAVA_INT.withName("deviceFaultDeviceLostOnMasked")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$deviceFault = PathElement.groupElement("deviceFault");
    public static final PathElement PATH$deviceFaultVendorBinary = PathElement.groupElement("deviceFaultVendorBinary");
    public static final PathElement PATH$deviceFaultReportMasked = PathElement.groupElement("deviceFaultReportMasked");
    public static final PathElement PATH$deviceFaultDeviceLostOnMasked = PathElement.groupElement("deviceFaultDeviceLostOnMasked");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$deviceFault = (OfInt) LAYOUT.select(PATH$deviceFault);
    public static final OfInt LAYOUT$deviceFaultVendorBinary = (OfInt) LAYOUT.select(PATH$deviceFaultVendorBinary);
    public static final OfInt LAYOUT$deviceFaultReportMasked = (OfInt) LAYOUT.select(PATH$deviceFaultReportMasked);
    public static final OfInt LAYOUT$deviceFaultDeviceLostOnMasked = (OfInt) LAYOUT.select(PATH$deviceFaultDeviceLostOnMasked);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$deviceFault = LAYOUT$deviceFault.byteSize();
    public static final long SIZE$deviceFaultVendorBinary = LAYOUT$deviceFaultVendorBinary.byteSize();
    public static final long SIZE$deviceFaultReportMasked = LAYOUT$deviceFaultReportMasked.byteSize();
    public static final long SIZE$deviceFaultDeviceLostOnMasked = LAYOUT$deviceFaultDeviceLostOnMasked.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$deviceFault = LAYOUT.byteOffset(PATH$deviceFault);
    public static final long OFFSET$deviceFaultVendorBinary = LAYOUT.byteOffset(PATH$deviceFaultVendorBinary);
    public static final long OFFSET$deviceFaultReportMasked = LAYOUT.byteOffset(PATH$deviceFaultReportMasked);
    public static final long OFFSET$deviceFaultDeviceLostOnMasked = LAYOUT.byteOffset(PATH$deviceFaultDeviceLostOnMasked);
}
