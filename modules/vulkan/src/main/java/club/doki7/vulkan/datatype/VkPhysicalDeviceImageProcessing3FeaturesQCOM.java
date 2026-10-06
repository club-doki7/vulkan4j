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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceImageProcessing3FeaturesQCOM.html"><code>VkPhysicalDeviceImageProcessing3FeaturesQCOM</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceImageProcessing3FeaturesQCOM {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 imageGatherLinear; // @link substring="imageGatherLinear" target="#imageGatherLinear"
///     VkBool32 imageGatherExtendedModes; // @link substring="imageGatherExtendedModes" target="#imageGatherExtendedModes"
///     VkBool32 blockMatchExtendedClampToEdge; // @link substring="blockMatchExtendedClampToEdge" target="#blockMatchExtendedClampToEdge"
/// } VkPhysicalDeviceImageProcessing3FeaturesQCOM;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_IMAGE_PROCESSING_3_FEATURES_QCOM`
///
/// The {@code allocate} ({@link VkPhysicalDeviceImageProcessing3FeaturesQCOM#allocate(Arena)}, {@link VkPhysicalDeviceImageProcessing3FeaturesQCOM#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceImageProcessing3FeaturesQCOM#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceImageProcessing3FeaturesQCOM.html"><code>VkPhysicalDeviceImageProcessing3FeaturesQCOM</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceImageProcessing3FeaturesQCOM(@NotNull MemorySegment segment) implements IVkPhysicalDeviceImageProcessing3FeaturesQCOM {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceImageProcessing3FeaturesQCOM.html"><code>VkPhysicalDeviceImageProcessing3FeaturesQCOM</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceImageProcessing3FeaturesQCOM}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceImageProcessing3FeaturesQCOM to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceImageProcessing3FeaturesQCOM.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceImageProcessing3FeaturesQCOM, Iterable<VkPhysicalDeviceImageProcessing3FeaturesQCOM> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceImageProcessing3FeaturesQCOM.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceImageProcessing3FeaturesQCOM at(long index) {
            return new VkPhysicalDeviceImageProcessing3FeaturesQCOM(segment.asSlice(index * VkPhysicalDeviceImageProcessing3FeaturesQCOM.BYTES, VkPhysicalDeviceImageProcessing3FeaturesQCOM.BYTES));
        }

        public VkPhysicalDeviceImageProcessing3FeaturesQCOM.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceImageProcessing3FeaturesQCOM> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceImageProcessing3FeaturesQCOM value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceImageProcessing3FeaturesQCOM.BYTES, VkPhysicalDeviceImageProcessing3FeaturesQCOM.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceImageProcessing3FeaturesQCOM.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceImageProcessing3FeaturesQCOM.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceImageProcessing3FeaturesQCOM.BYTES,
                (end - start) * VkPhysicalDeviceImageProcessing3FeaturesQCOM.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceImageProcessing3FeaturesQCOM.BYTES));
        }

        public VkPhysicalDeviceImageProcessing3FeaturesQCOM[] toArray() {
            VkPhysicalDeviceImageProcessing3FeaturesQCOM[] ret = new VkPhysicalDeviceImageProcessing3FeaturesQCOM[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceImageProcessing3FeaturesQCOM> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceImageProcessing3FeaturesQCOM> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceImageProcessing3FeaturesQCOM.BYTES;
            }

            @Override
            public VkPhysicalDeviceImageProcessing3FeaturesQCOM next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceImageProcessing3FeaturesQCOM ret = new VkPhysicalDeviceImageProcessing3FeaturesQCOM(segment.asSlice(0, VkPhysicalDeviceImageProcessing3FeaturesQCOM.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceImageProcessing3FeaturesQCOM.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceImageProcessing3FeaturesQCOM allocate(Arena arena) {
        VkPhysicalDeviceImageProcessing3FeaturesQCOM ret = new VkPhysicalDeviceImageProcessing3FeaturesQCOM(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_IMAGE_PROCESSING_3_FEATURES_QCOM);
        return ret;
    }

    public static VkPhysicalDeviceImageProcessing3FeaturesQCOM.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceImageProcessing3FeaturesQCOM.Ptr ret = new VkPhysicalDeviceImageProcessing3FeaturesQCOM.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_IMAGE_PROCESSING_3_FEATURES_QCOM);
        }
        return ret;
    }

    public static VkPhysicalDeviceImageProcessing3FeaturesQCOM clone(Arena arena, VkPhysicalDeviceImageProcessing3FeaturesQCOM src) {
        VkPhysicalDeviceImageProcessing3FeaturesQCOM ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_IMAGE_PROCESSING_3_FEATURES_QCOM);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceImageProcessing3FeaturesQCOM sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceImageProcessing3FeaturesQCOM pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceImageProcessing3FeaturesQCOM pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int imageGatherLinear() {
        return segment.get(LAYOUT$imageGatherLinear, OFFSET$imageGatherLinear);
    }

    public VkPhysicalDeviceImageProcessing3FeaturesQCOM imageGatherLinear(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$imageGatherLinear, OFFSET$imageGatherLinear, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int imageGatherExtendedModes() {
        return segment.get(LAYOUT$imageGatherExtendedModes, OFFSET$imageGatherExtendedModes);
    }

    public VkPhysicalDeviceImageProcessing3FeaturesQCOM imageGatherExtendedModes(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$imageGatherExtendedModes, OFFSET$imageGatherExtendedModes, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int blockMatchExtendedClampToEdge() {
        return segment.get(LAYOUT$blockMatchExtendedClampToEdge, OFFSET$blockMatchExtendedClampToEdge);
    }

    public VkPhysicalDeviceImageProcessing3FeaturesQCOM blockMatchExtendedClampToEdge(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$blockMatchExtendedClampToEdge, OFFSET$blockMatchExtendedClampToEdge, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("imageGatherLinear"),
        ValueLayout.JAVA_INT.withName("imageGatherExtendedModes"),
        ValueLayout.JAVA_INT.withName("blockMatchExtendedClampToEdge")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$imageGatherLinear = PathElement.groupElement("imageGatherLinear");
    public static final PathElement PATH$imageGatherExtendedModes = PathElement.groupElement("imageGatherExtendedModes");
    public static final PathElement PATH$blockMatchExtendedClampToEdge = PathElement.groupElement("blockMatchExtendedClampToEdge");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$imageGatherLinear = (OfInt) LAYOUT.select(PATH$imageGatherLinear);
    public static final OfInt LAYOUT$imageGatherExtendedModes = (OfInt) LAYOUT.select(PATH$imageGatherExtendedModes);
    public static final OfInt LAYOUT$blockMatchExtendedClampToEdge = (OfInt) LAYOUT.select(PATH$blockMatchExtendedClampToEdge);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$imageGatherLinear = LAYOUT$imageGatherLinear.byteSize();
    public static final long SIZE$imageGatherExtendedModes = LAYOUT$imageGatherExtendedModes.byteSize();
    public static final long SIZE$blockMatchExtendedClampToEdge = LAYOUT$blockMatchExtendedClampToEdge.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$imageGatherLinear = LAYOUT.byteOffset(PATH$imageGatherLinear);
    public static final long OFFSET$imageGatherExtendedModes = LAYOUT.byteOffset(PATH$imageGatherExtendedModes);
    public static final long OFFSET$blockMatchExtendedClampToEdge = LAYOUT.byteOffset(PATH$blockMatchExtendedClampToEdge);
}
