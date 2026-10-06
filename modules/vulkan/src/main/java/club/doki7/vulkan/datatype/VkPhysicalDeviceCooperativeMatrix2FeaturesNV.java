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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceCooperativeMatrix2FeaturesNV.html"><code>VkPhysicalDeviceCooperativeMatrix2FeaturesNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceCooperativeMatrix2FeaturesNV {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 cooperativeMatrixWorkgroupScope; // @link substring="cooperativeMatrixWorkgroupScope" target="#cooperativeMatrixWorkgroupScope"
///     VkBool32 cooperativeMatrixFlexibleDimensions; // @link substring="cooperativeMatrixFlexibleDimensions" target="#cooperativeMatrixFlexibleDimensions"
///     VkBool32 cooperativeMatrixReductions; // @link substring="cooperativeMatrixReductions" target="#cooperativeMatrixReductions"
///     VkBool32 cooperativeMatrixConversions; // @link substring="cooperativeMatrixConversions" target="#cooperativeMatrixConversions"
///     VkBool32 cooperativeMatrixPerElementOperations; // @link substring="cooperativeMatrixPerElementOperations" target="#cooperativeMatrixPerElementOperations"
///     VkBool32 cooperativeMatrixTensorAddressing; // @link substring="cooperativeMatrixTensorAddressing" target="#cooperativeMatrixTensorAddressing"
///     VkBool32 cooperativeMatrixBlockLoads; // @link substring="cooperativeMatrixBlockLoads" target="#cooperativeMatrixBlockLoads"
/// } VkPhysicalDeviceCooperativeMatrix2FeaturesNV;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_COOPERATIVE_MATRIX_2_FEATURES_NV`
///
/// The {@code allocate} ({@link VkPhysicalDeviceCooperativeMatrix2FeaturesNV#allocate(Arena)}, {@link VkPhysicalDeviceCooperativeMatrix2FeaturesNV#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceCooperativeMatrix2FeaturesNV#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceCooperativeMatrix2FeaturesNV.html"><code>VkPhysicalDeviceCooperativeMatrix2FeaturesNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceCooperativeMatrix2FeaturesNV(@NotNull MemorySegment segment) implements IVkPhysicalDeviceCooperativeMatrix2FeaturesNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceCooperativeMatrix2FeaturesNV.html"><code>VkPhysicalDeviceCooperativeMatrix2FeaturesNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceCooperativeMatrix2FeaturesNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceCooperativeMatrix2FeaturesNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceCooperativeMatrix2FeaturesNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceCooperativeMatrix2FeaturesNV, Iterable<VkPhysicalDeviceCooperativeMatrix2FeaturesNV> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceCooperativeMatrix2FeaturesNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceCooperativeMatrix2FeaturesNV at(long index) {
            return new VkPhysicalDeviceCooperativeMatrix2FeaturesNV(segment.asSlice(index * VkPhysicalDeviceCooperativeMatrix2FeaturesNV.BYTES, VkPhysicalDeviceCooperativeMatrix2FeaturesNV.BYTES));
        }

        public VkPhysicalDeviceCooperativeMatrix2FeaturesNV.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceCooperativeMatrix2FeaturesNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceCooperativeMatrix2FeaturesNV value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceCooperativeMatrix2FeaturesNV.BYTES, VkPhysicalDeviceCooperativeMatrix2FeaturesNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceCooperativeMatrix2FeaturesNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceCooperativeMatrix2FeaturesNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceCooperativeMatrix2FeaturesNV.BYTES,
                (end - start) * VkPhysicalDeviceCooperativeMatrix2FeaturesNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceCooperativeMatrix2FeaturesNV.BYTES));
        }

        public VkPhysicalDeviceCooperativeMatrix2FeaturesNV[] toArray() {
            VkPhysicalDeviceCooperativeMatrix2FeaturesNV[] ret = new VkPhysicalDeviceCooperativeMatrix2FeaturesNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceCooperativeMatrix2FeaturesNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceCooperativeMatrix2FeaturesNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceCooperativeMatrix2FeaturesNV.BYTES;
            }

            @Override
            public VkPhysicalDeviceCooperativeMatrix2FeaturesNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceCooperativeMatrix2FeaturesNV ret = new VkPhysicalDeviceCooperativeMatrix2FeaturesNV(segment.asSlice(0, VkPhysicalDeviceCooperativeMatrix2FeaturesNV.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceCooperativeMatrix2FeaturesNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceCooperativeMatrix2FeaturesNV allocate(Arena arena) {
        VkPhysicalDeviceCooperativeMatrix2FeaturesNV ret = new VkPhysicalDeviceCooperativeMatrix2FeaturesNV(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_COOPERATIVE_MATRIX_2_FEATURES_NV);
        return ret;
    }

    public static VkPhysicalDeviceCooperativeMatrix2FeaturesNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceCooperativeMatrix2FeaturesNV.Ptr ret = new VkPhysicalDeviceCooperativeMatrix2FeaturesNV.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_COOPERATIVE_MATRIX_2_FEATURES_NV);
        }
        return ret;
    }

    public static VkPhysicalDeviceCooperativeMatrix2FeaturesNV clone(Arena arena, VkPhysicalDeviceCooperativeMatrix2FeaturesNV src) {
        VkPhysicalDeviceCooperativeMatrix2FeaturesNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_COOPERATIVE_MATRIX_2_FEATURES_NV);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceCooperativeMatrix2FeaturesNV sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceCooperativeMatrix2FeaturesNV pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceCooperativeMatrix2FeaturesNV pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int cooperativeMatrixWorkgroupScope() {
        return segment.get(LAYOUT$cooperativeMatrixWorkgroupScope, OFFSET$cooperativeMatrixWorkgroupScope);
    }

    public VkPhysicalDeviceCooperativeMatrix2FeaturesNV cooperativeMatrixWorkgroupScope(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$cooperativeMatrixWorkgroupScope, OFFSET$cooperativeMatrixWorkgroupScope, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int cooperativeMatrixFlexibleDimensions() {
        return segment.get(LAYOUT$cooperativeMatrixFlexibleDimensions, OFFSET$cooperativeMatrixFlexibleDimensions);
    }

    public VkPhysicalDeviceCooperativeMatrix2FeaturesNV cooperativeMatrixFlexibleDimensions(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$cooperativeMatrixFlexibleDimensions, OFFSET$cooperativeMatrixFlexibleDimensions, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int cooperativeMatrixReductions() {
        return segment.get(LAYOUT$cooperativeMatrixReductions, OFFSET$cooperativeMatrixReductions);
    }

    public VkPhysicalDeviceCooperativeMatrix2FeaturesNV cooperativeMatrixReductions(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$cooperativeMatrixReductions, OFFSET$cooperativeMatrixReductions, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int cooperativeMatrixConversions() {
        return segment.get(LAYOUT$cooperativeMatrixConversions, OFFSET$cooperativeMatrixConversions);
    }

    public VkPhysicalDeviceCooperativeMatrix2FeaturesNV cooperativeMatrixConversions(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$cooperativeMatrixConversions, OFFSET$cooperativeMatrixConversions, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int cooperativeMatrixPerElementOperations() {
        return segment.get(LAYOUT$cooperativeMatrixPerElementOperations, OFFSET$cooperativeMatrixPerElementOperations);
    }

    public VkPhysicalDeviceCooperativeMatrix2FeaturesNV cooperativeMatrixPerElementOperations(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$cooperativeMatrixPerElementOperations, OFFSET$cooperativeMatrixPerElementOperations, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int cooperativeMatrixTensorAddressing() {
        return segment.get(LAYOUT$cooperativeMatrixTensorAddressing, OFFSET$cooperativeMatrixTensorAddressing);
    }

    public VkPhysicalDeviceCooperativeMatrix2FeaturesNV cooperativeMatrixTensorAddressing(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$cooperativeMatrixTensorAddressing, OFFSET$cooperativeMatrixTensorAddressing, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int cooperativeMatrixBlockLoads() {
        return segment.get(LAYOUT$cooperativeMatrixBlockLoads, OFFSET$cooperativeMatrixBlockLoads);
    }

    public VkPhysicalDeviceCooperativeMatrix2FeaturesNV cooperativeMatrixBlockLoads(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$cooperativeMatrixBlockLoads, OFFSET$cooperativeMatrixBlockLoads, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("cooperativeMatrixWorkgroupScope"),
        ValueLayout.JAVA_INT.withName("cooperativeMatrixFlexibleDimensions"),
        ValueLayout.JAVA_INT.withName("cooperativeMatrixReductions"),
        ValueLayout.JAVA_INT.withName("cooperativeMatrixConversions"),
        ValueLayout.JAVA_INT.withName("cooperativeMatrixPerElementOperations"),
        ValueLayout.JAVA_INT.withName("cooperativeMatrixTensorAddressing"),
        ValueLayout.JAVA_INT.withName("cooperativeMatrixBlockLoads")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$cooperativeMatrixWorkgroupScope = PathElement.groupElement("cooperativeMatrixWorkgroupScope");
    public static final PathElement PATH$cooperativeMatrixFlexibleDimensions = PathElement.groupElement("cooperativeMatrixFlexibleDimensions");
    public static final PathElement PATH$cooperativeMatrixReductions = PathElement.groupElement("cooperativeMatrixReductions");
    public static final PathElement PATH$cooperativeMatrixConversions = PathElement.groupElement("cooperativeMatrixConversions");
    public static final PathElement PATH$cooperativeMatrixPerElementOperations = PathElement.groupElement("cooperativeMatrixPerElementOperations");
    public static final PathElement PATH$cooperativeMatrixTensorAddressing = PathElement.groupElement("cooperativeMatrixTensorAddressing");
    public static final PathElement PATH$cooperativeMatrixBlockLoads = PathElement.groupElement("cooperativeMatrixBlockLoads");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$cooperativeMatrixWorkgroupScope = (OfInt) LAYOUT.select(PATH$cooperativeMatrixWorkgroupScope);
    public static final OfInt LAYOUT$cooperativeMatrixFlexibleDimensions = (OfInt) LAYOUT.select(PATH$cooperativeMatrixFlexibleDimensions);
    public static final OfInt LAYOUT$cooperativeMatrixReductions = (OfInt) LAYOUT.select(PATH$cooperativeMatrixReductions);
    public static final OfInt LAYOUT$cooperativeMatrixConversions = (OfInt) LAYOUT.select(PATH$cooperativeMatrixConversions);
    public static final OfInt LAYOUT$cooperativeMatrixPerElementOperations = (OfInt) LAYOUT.select(PATH$cooperativeMatrixPerElementOperations);
    public static final OfInt LAYOUT$cooperativeMatrixTensorAddressing = (OfInt) LAYOUT.select(PATH$cooperativeMatrixTensorAddressing);
    public static final OfInt LAYOUT$cooperativeMatrixBlockLoads = (OfInt) LAYOUT.select(PATH$cooperativeMatrixBlockLoads);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$cooperativeMatrixWorkgroupScope = LAYOUT$cooperativeMatrixWorkgroupScope.byteSize();
    public static final long SIZE$cooperativeMatrixFlexibleDimensions = LAYOUT$cooperativeMatrixFlexibleDimensions.byteSize();
    public static final long SIZE$cooperativeMatrixReductions = LAYOUT$cooperativeMatrixReductions.byteSize();
    public static final long SIZE$cooperativeMatrixConversions = LAYOUT$cooperativeMatrixConversions.byteSize();
    public static final long SIZE$cooperativeMatrixPerElementOperations = LAYOUT$cooperativeMatrixPerElementOperations.byteSize();
    public static final long SIZE$cooperativeMatrixTensorAddressing = LAYOUT$cooperativeMatrixTensorAddressing.byteSize();
    public static final long SIZE$cooperativeMatrixBlockLoads = LAYOUT$cooperativeMatrixBlockLoads.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$cooperativeMatrixWorkgroupScope = LAYOUT.byteOffset(PATH$cooperativeMatrixWorkgroupScope);
    public static final long OFFSET$cooperativeMatrixFlexibleDimensions = LAYOUT.byteOffset(PATH$cooperativeMatrixFlexibleDimensions);
    public static final long OFFSET$cooperativeMatrixReductions = LAYOUT.byteOffset(PATH$cooperativeMatrixReductions);
    public static final long OFFSET$cooperativeMatrixConversions = LAYOUT.byteOffset(PATH$cooperativeMatrixConversions);
    public static final long OFFSET$cooperativeMatrixPerElementOperations = LAYOUT.byteOffset(PATH$cooperativeMatrixPerElementOperations);
    public static final long OFFSET$cooperativeMatrixTensorAddressing = LAYOUT.byteOffset(PATH$cooperativeMatrixTensorAddressing);
    public static final long OFFSET$cooperativeMatrixBlockLoads = LAYOUT.byteOffset(PATH$cooperativeMatrixBlockLoads);
}
