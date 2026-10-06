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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceTileShadingPropertiesQCOM.html"><code>VkPhysicalDeviceTileShadingPropertiesQCOM</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceTileShadingPropertiesQCOM {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t maxApronSize; // @link substring="maxApronSize" target="#maxApronSize"
///     VkBool32 preferNonCoherent; // @link substring="preferNonCoherent" target="#preferNonCoherent"
///     VkExtent2D tileGranularity; // @link substring="VkExtent2D" target="VkExtent2D" @link substring="tileGranularity" target="#tileGranularity"
///     VkExtent2D maxTileShadingRate; // @link substring="VkExtent2D" target="VkExtent2D" @link substring="maxTileShadingRate" target="#maxTileShadingRate"
/// } VkPhysicalDeviceTileShadingPropertiesQCOM;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_TILE_SHADING_PROPERTIES_QCOM`
///
/// The {@code allocate} ({@link VkPhysicalDeviceTileShadingPropertiesQCOM#allocate(Arena)}, {@link VkPhysicalDeviceTileShadingPropertiesQCOM#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceTileShadingPropertiesQCOM#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceTileShadingPropertiesQCOM.html"><code>VkPhysicalDeviceTileShadingPropertiesQCOM</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceTileShadingPropertiesQCOM(@NotNull MemorySegment segment) implements IVkPhysicalDeviceTileShadingPropertiesQCOM {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceTileShadingPropertiesQCOM.html"><code>VkPhysicalDeviceTileShadingPropertiesQCOM</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceTileShadingPropertiesQCOM}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceTileShadingPropertiesQCOM to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceTileShadingPropertiesQCOM.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceTileShadingPropertiesQCOM, Iterable<VkPhysicalDeviceTileShadingPropertiesQCOM> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceTileShadingPropertiesQCOM.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceTileShadingPropertiesQCOM at(long index) {
            return new VkPhysicalDeviceTileShadingPropertiesQCOM(segment.asSlice(index * VkPhysicalDeviceTileShadingPropertiesQCOM.BYTES, VkPhysicalDeviceTileShadingPropertiesQCOM.BYTES));
        }

        public VkPhysicalDeviceTileShadingPropertiesQCOM.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceTileShadingPropertiesQCOM> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceTileShadingPropertiesQCOM value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceTileShadingPropertiesQCOM.BYTES, VkPhysicalDeviceTileShadingPropertiesQCOM.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceTileShadingPropertiesQCOM.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceTileShadingPropertiesQCOM.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceTileShadingPropertiesQCOM.BYTES,
                (end - start) * VkPhysicalDeviceTileShadingPropertiesQCOM.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceTileShadingPropertiesQCOM.BYTES));
        }

        public VkPhysicalDeviceTileShadingPropertiesQCOM[] toArray() {
            VkPhysicalDeviceTileShadingPropertiesQCOM[] ret = new VkPhysicalDeviceTileShadingPropertiesQCOM[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceTileShadingPropertiesQCOM> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceTileShadingPropertiesQCOM> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceTileShadingPropertiesQCOM.BYTES;
            }

            @Override
            public VkPhysicalDeviceTileShadingPropertiesQCOM next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceTileShadingPropertiesQCOM ret = new VkPhysicalDeviceTileShadingPropertiesQCOM(segment.asSlice(0, VkPhysicalDeviceTileShadingPropertiesQCOM.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceTileShadingPropertiesQCOM.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceTileShadingPropertiesQCOM allocate(Arena arena) {
        VkPhysicalDeviceTileShadingPropertiesQCOM ret = new VkPhysicalDeviceTileShadingPropertiesQCOM(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_TILE_SHADING_PROPERTIES_QCOM);
        return ret;
    }

    public static VkPhysicalDeviceTileShadingPropertiesQCOM.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceTileShadingPropertiesQCOM.Ptr ret = new VkPhysicalDeviceTileShadingPropertiesQCOM.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_TILE_SHADING_PROPERTIES_QCOM);
        }
        return ret;
    }

    public static VkPhysicalDeviceTileShadingPropertiesQCOM clone(Arena arena, VkPhysicalDeviceTileShadingPropertiesQCOM src) {
        VkPhysicalDeviceTileShadingPropertiesQCOM ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_TILE_SHADING_PROPERTIES_QCOM);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceTileShadingPropertiesQCOM sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceTileShadingPropertiesQCOM pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceTileShadingPropertiesQCOM pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int maxApronSize() {
        return segment.get(LAYOUT$maxApronSize, OFFSET$maxApronSize);
    }

    public VkPhysicalDeviceTileShadingPropertiesQCOM maxApronSize(@Unsigned int value) {
        segment.set(LAYOUT$maxApronSize, OFFSET$maxApronSize, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int preferNonCoherent() {
        return segment.get(LAYOUT$preferNonCoherent, OFFSET$preferNonCoherent);
    }

    public VkPhysicalDeviceTileShadingPropertiesQCOM preferNonCoherent(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$preferNonCoherent, OFFSET$preferNonCoherent, value);
        return this;
    }

    public @NotNull VkExtent2D tileGranularity() {
        return new VkExtent2D(segment.asSlice(OFFSET$tileGranularity, LAYOUT$tileGranularity));
    }

    public VkPhysicalDeviceTileShadingPropertiesQCOM tileGranularity(@NotNull VkExtent2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$tileGranularity, SIZE$tileGranularity);
        return this;
    }

    public VkPhysicalDeviceTileShadingPropertiesQCOM tileGranularity(Consumer<@NotNull VkExtent2D> consumer) {
        consumer.accept(tileGranularity());
        return this;
    }

    public @NotNull VkExtent2D maxTileShadingRate() {
        return new VkExtent2D(segment.asSlice(OFFSET$maxTileShadingRate, LAYOUT$maxTileShadingRate));
    }

    public VkPhysicalDeviceTileShadingPropertiesQCOM maxTileShadingRate(@NotNull VkExtent2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$maxTileShadingRate, SIZE$maxTileShadingRate);
        return this;
    }

    public VkPhysicalDeviceTileShadingPropertiesQCOM maxTileShadingRate(Consumer<@NotNull VkExtent2D> consumer) {
        consumer.accept(maxTileShadingRate());
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("maxApronSize"),
        ValueLayout.JAVA_INT.withName("preferNonCoherent"),
        VkExtent2D.LAYOUT.withName("tileGranularity"),
        VkExtent2D.LAYOUT.withName("maxTileShadingRate")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$maxApronSize = PathElement.groupElement("maxApronSize");
    public static final PathElement PATH$preferNonCoherent = PathElement.groupElement("preferNonCoherent");
    public static final PathElement PATH$tileGranularity = PathElement.groupElement("tileGranularity");
    public static final PathElement PATH$maxTileShadingRate = PathElement.groupElement("maxTileShadingRate");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$maxApronSize = (OfInt) LAYOUT.select(PATH$maxApronSize);
    public static final OfInt LAYOUT$preferNonCoherent = (OfInt) LAYOUT.select(PATH$preferNonCoherent);
    public static final StructLayout LAYOUT$tileGranularity = (StructLayout) LAYOUT.select(PATH$tileGranularity);
    public static final StructLayout LAYOUT$maxTileShadingRate = (StructLayout) LAYOUT.select(PATH$maxTileShadingRate);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$maxApronSize = LAYOUT$maxApronSize.byteSize();
    public static final long SIZE$preferNonCoherent = LAYOUT$preferNonCoherent.byteSize();
    public static final long SIZE$tileGranularity = LAYOUT$tileGranularity.byteSize();
    public static final long SIZE$maxTileShadingRate = LAYOUT$maxTileShadingRate.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$maxApronSize = LAYOUT.byteOffset(PATH$maxApronSize);
    public static final long OFFSET$preferNonCoherent = LAYOUT.byteOffset(PATH$preferNonCoherent);
    public static final long OFFSET$tileGranularity = LAYOUT.byteOffset(PATH$tileGranularity);
    public static final long OFFSET$maxTileShadingRate = LAYOUT.byteOffset(PATH$maxTileShadingRate);
}
