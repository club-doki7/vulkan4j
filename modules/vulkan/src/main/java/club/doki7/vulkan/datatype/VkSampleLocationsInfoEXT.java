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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSampleLocationsInfoEXT.html"><code>VkSampleLocationsInfoEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkSampleLocationsInfoEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkSampleCountFlags sampleLocationsPerPixel; // @link substring="VkSampleCountFlags" target="VkSampleCountFlags" @link substring="sampleLocationsPerPixel" target="#sampleLocationsPerPixel"
///     VkExtent2D sampleLocationGridSize; // @link substring="VkExtent2D" target="VkExtent2D" @link substring="sampleLocationGridSize" target="#sampleLocationGridSize"
///     uint32_t sampleLocationsCount; // optional // @link substring="sampleLocationsCount" target="#sampleLocationsCount"
///     VkSampleLocationEXT const* pSampleLocations; // optional // @link substring="VkSampleLocationEXT" target="VkSampleLocationEXT" @link substring="pSampleLocations" target="#pSampleLocations"
/// } VkSampleLocationsInfoEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_SAMPLE_LOCATIONS_INFO_EXT`
///
/// The {@code allocate} ({@link VkSampleLocationsInfoEXT#allocate(Arena)}, {@link VkSampleLocationsInfoEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkSampleLocationsInfoEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSampleLocationsInfoEXT.html"><code>VkSampleLocationsInfoEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkSampleLocationsInfoEXT(@NotNull MemorySegment segment) implements IVkSampleLocationsInfoEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSampleLocationsInfoEXT.html"><code>VkSampleLocationsInfoEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkSampleLocationsInfoEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkSampleLocationsInfoEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkSampleLocationsInfoEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkSampleLocationsInfoEXT, Iterable<VkSampleLocationsInfoEXT> {
        public long size() {
            return segment.byteSize() / VkSampleLocationsInfoEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkSampleLocationsInfoEXT at(long index) {
            return new VkSampleLocationsInfoEXT(segment.asSlice(index * VkSampleLocationsInfoEXT.BYTES, VkSampleLocationsInfoEXT.BYTES));
        }

        public VkSampleLocationsInfoEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkSampleLocationsInfoEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkSampleLocationsInfoEXT value) {
            MemorySegment s = segment.asSlice(index * VkSampleLocationsInfoEXT.BYTES, VkSampleLocationsInfoEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkSampleLocationsInfoEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkSampleLocationsInfoEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkSampleLocationsInfoEXT.BYTES,
                (end - start) * VkSampleLocationsInfoEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkSampleLocationsInfoEXT.BYTES));
        }

        public VkSampleLocationsInfoEXT[] toArray() {
            VkSampleLocationsInfoEXT[] ret = new VkSampleLocationsInfoEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkSampleLocationsInfoEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkSampleLocationsInfoEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkSampleLocationsInfoEXT.BYTES;
            }

            @Override
            public VkSampleLocationsInfoEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkSampleLocationsInfoEXT ret = new VkSampleLocationsInfoEXT(segment.asSlice(0, VkSampleLocationsInfoEXT.BYTES));
                segment = segment.asSlice(VkSampleLocationsInfoEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkSampleLocationsInfoEXT allocate(Arena arena) {
        VkSampleLocationsInfoEXT ret = new VkSampleLocationsInfoEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.SAMPLE_LOCATIONS_INFO_EXT);
        return ret;
    }

    public static VkSampleLocationsInfoEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkSampleLocationsInfoEXT.Ptr ret = new VkSampleLocationsInfoEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.SAMPLE_LOCATIONS_INFO_EXT);
        }
        return ret;
    }

    public static VkSampleLocationsInfoEXT clone(Arena arena, VkSampleLocationsInfoEXT src) {
        VkSampleLocationsInfoEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.SAMPLE_LOCATIONS_INFO_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkSampleLocationsInfoEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkSampleLocationsInfoEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkSampleLocationsInfoEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkSampleCountFlags.class) int sampleLocationsPerPixel() {
        return segment.get(LAYOUT$sampleLocationsPerPixel, OFFSET$sampleLocationsPerPixel);
    }

    public VkSampleLocationsInfoEXT sampleLocationsPerPixel(@Bitmask(VkSampleCountFlags.class) int value) {
        segment.set(LAYOUT$sampleLocationsPerPixel, OFFSET$sampleLocationsPerPixel, value);
        return this;
    }

    public @NotNull VkExtent2D sampleLocationGridSize() {
        return new VkExtent2D(segment.asSlice(OFFSET$sampleLocationGridSize, LAYOUT$sampleLocationGridSize));
    }

    public VkSampleLocationsInfoEXT sampleLocationGridSize(@NotNull VkExtent2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$sampleLocationGridSize, SIZE$sampleLocationGridSize);
        return this;
    }

    public VkSampleLocationsInfoEXT sampleLocationGridSize(Consumer<@NotNull VkExtent2D> consumer) {
        consumer.accept(sampleLocationGridSize());
        return this;
    }

    public @Unsigned int sampleLocationsCount() {
        return segment.get(LAYOUT$sampleLocationsCount, OFFSET$sampleLocationsCount);
    }

    public VkSampleLocationsInfoEXT sampleLocationsCount(@Unsigned int value) {
        segment.set(LAYOUT$sampleLocationsCount, OFFSET$sampleLocationsCount, value);
        return this;
    }

    public VkSampleLocationsInfoEXT pSampleLocations(@Nullable IVkSampleLocationEXT value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pSampleLocationsRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkSampleLocationEXT.Ptr pSampleLocations(int assumedCount) {
        MemorySegment s = pSampleLocationsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkSampleLocationEXT.BYTES);
        return new VkSampleLocationEXT.Ptr(s);
    }

    public @Nullable VkSampleLocationEXT pSampleLocations() {
        MemorySegment s = pSampleLocationsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkSampleLocationEXT(s);
    }

    public @Pointer(target=VkSampleLocationEXT.class) @NotNull MemorySegment pSampleLocationsRaw() {
        return segment.get(LAYOUT$pSampleLocations, OFFSET$pSampleLocations);
    }

    public void pSampleLocationsRaw(@Pointer(target=VkSampleLocationEXT.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pSampleLocations, OFFSET$pSampleLocations, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("sampleLocationsPerPixel"),
        VkExtent2D.LAYOUT.withName("sampleLocationGridSize"),
        ValueLayout.JAVA_INT.withName("sampleLocationsCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkSampleLocationEXT.LAYOUT).withName("pSampleLocations")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$sampleLocationsPerPixel = PathElement.groupElement("sampleLocationsPerPixel");
    public static final PathElement PATH$sampleLocationGridSize = PathElement.groupElement("sampleLocationGridSize");
    public static final PathElement PATH$sampleLocationsCount = PathElement.groupElement("sampleLocationsCount");
    public static final PathElement PATH$pSampleLocations = PathElement.groupElement("pSampleLocations");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$sampleLocationsPerPixel = (OfInt) LAYOUT.select(PATH$sampleLocationsPerPixel);
    public static final StructLayout LAYOUT$sampleLocationGridSize = (StructLayout) LAYOUT.select(PATH$sampleLocationGridSize);
    public static final OfInt LAYOUT$sampleLocationsCount = (OfInt) LAYOUT.select(PATH$sampleLocationsCount);
    public static final AddressLayout LAYOUT$pSampleLocations = (AddressLayout) LAYOUT.select(PATH$pSampleLocations);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$sampleLocationsPerPixel = LAYOUT$sampleLocationsPerPixel.byteSize();
    public static final long SIZE$sampleLocationGridSize = LAYOUT$sampleLocationGridSize.byteSize();
    public static final long SIZE$sampleLocationsCount = LAYOUT$sampleLocationsCount.byteSize();
    public static final long SIZE$pSampleLocations = LAYOUT$pSampleLocations.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$sampleLocationsPerPixel = LAYOUT.byteOffset(PATH$sampleLocationsPerPixel);
    public static final long OFFSET$sampleLocationGridSize = LAYOUT.byteOffset(PATH$sampleLocationGridSize);
    public static final long OFFSET$sampleLocationsCount = LAYOUT.byteOffset(PATH$sampleLocationsCount);
    public static final long OFFSET$pSampleLocations = LAYOUT.byteOffset(PATH$pSampleLocations);
}
