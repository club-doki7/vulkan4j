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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCoarseSampleOrderCustomNV.html"><code>VkCoarseSampleOrderCustomNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkCoarseSampleOrderCustomNV {
///     VkShadingRatePaletteEntryNV shadingRate; // @link substring="VkShadingRatePaletteEntryNV" target="VkShadingRatePaletteEntryNV" @link substring="shadingRate" target="#shadingRate"
///     uint32_t sampleCount; // @link substring="sampleCount" target="#sampleCount"
///     uint32_t sampleLocationCount; // @link substring="sampleLocationCount" target="#sampleLocationCount"
///     VkCoarseSampleLocationNV const* pSampleLocations; // @link substring="VkCoarseSampleLocationNV" target="VkCoarseSampleLocationNV" @link substring="pSampleLocations" target="#pSampleLocations"
/// } VkCoarseSampleOrderCustomNV;
/// }
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCoarseSampleOrderCustomNV.html"><code>VkCoarseSampleOrderCustomNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkCoarseSampleOrderCustomNV(@NotNull MemorySegment segment) implements IVkCoarseSampleOrderCustomNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCoarseSampleOrderCustomNV.html"><code>VkCoarseSampleOrderCustomNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkCoarseSampleOrderCustomNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkCoarseSampleOrderCustomNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkCoarseSampleOrderCustomNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkCoarseSampleOrderCustomNV, Iterable<VkCoarseSampleOrderCustomNV> {
        public long size() {
            return segment.byteSize() / VkCoarseSampleOrderCustomNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkCoarseSampleOrderCustomNV at(long index) {
            return new VkCoarseSampleOrderCustomNV(segment.asSlice(index * VkCoarseSampleOrderCustomNV.BYTES, VkCoarseSampleOrderCustomNV.BYTES));
        }

        public VkCoarseSampleOrderCustomNV.Ptr at(long index, @NotNull Consumer<@NotNull VkCoarseSampleOrderCustomNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkCoarseSampleOrderCustomNV value) {
            MemorySegment s = segment.asSlice(index * VkCoarseSampleOrderCustomNV.BYTES, VkCoarseSampleOrderCustomNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkCoarseSampleOrderCustomNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkCoarseSampleOrderCustomNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkCoarseSampleOrderCustomNV.BYTES,
                (end - start) * VkCoarseSampleOrderCustomNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkCoarseSampleOrderCustomNV.BYTES));
        }

        public VkCoarseSampleOrderCustomNV[] toArray() {
            VkCoarseSampleOrderCustomNV[] ret = new VkCoarseSampleOrderCustomNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkCoarseSampleOrderCustomNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkCoarseSampleOrderCustomNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkCoarseSampleOrderCustomNV.BYTES;
            }

            @Override
            public VkCoarseSampleOrderCustomNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkCoarseSampleOrderCustomNV ret = new VkCoarseSampleOrderCustomNV(segment.asSlice(0, VkCoarseSampleOrderCustomNV.BYTES));
                segment = segment.asSlice(VkCoarseSampleOrderCustomNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkCoarseSampleOrderCustomNV allocate(Arena arena) {
        return new VkCoarseSampleOrderCustomNV(arena.allocate(LAYOUT));
    }

    public static VkCoarseSampleOrderCustomNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkCoarseSampleOrderCustomNV.Ptr(segment);
    }

    public static VkCoarseSampleOrderCustomNV clone(Arena arena, VkCoarseSampleOrderCustomNV src) {
        VkCoarseSampleOrderCustomNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @EnumType(VkShadingRatePaletteEntryNV.class) int shadingRate() {
        return segment.get(LAYOUT$shadingRate, OFFSET$shadingRate);
    }

    public VkCoarseSampleOrderCustomNV shadingRate(@EnumType(VkShadingRatePaletteEntryNV.class) int value) {
        segment.set(LAYOUT$shadingRate, OFFSET$shadingRate, value);
        return this;
    }

    public @Unsigned int sampleCount() {
        return segment.get(LAYOUT$sampleCount, OFFSET$sampleCount);
    }

    public VkCoarseSampleOrderCustomNV sampleCount(@Unsigned int value) {
        segment.set(LAYOUT$sampleCount, OFFSET$sampleCount, value);
        return this;
    }

    public @Unsigned int sampleLocationCount() {
        return segment.get(LAYOUT$sampleLocationCount, OFFSET$sampleLocationCount);
    }

    public VkCoarseSampleOrderCustomNV sampleLocationCount(@Unsigned int value) {
        segment.set(LAYOUT$sampleLocationCount, OFFSET$sampleLocationCount, value);
        return this;
    }

    public VkCoarseSampleOrderCustomNV pSampleLocations(@Nullable IVkCoarseSampleLocationNV value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pSampleLocationsRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkCoarseSampleLocationNV.Ptr pSampleLocations(int assumedCount) {
        MemorySegment s = pSampleLocationsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkCoarseSampleLocationNV.BYTES);
        return new VkCoarseSampleLocationNV.Ptr(s);
    }

    public @Nullable VkCoarseSampleLocationNV pSampleLocations() {
        MemorySegment s = pSampleLocationsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkCoarseSampleLocationNV(s);
    }

    public @Pointer(target=VkCoarseSampleLocationNV.class) @NotNull MemorySegment pSampleLocationsRaw() {
        return segment.get(LAYOUT$pSampleLocations, OFFSET$pSampleLocations);
    }

    public void pSampleLocationsRaw(@Pointer(target=VkCoarseSampleLocationNV.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pSampleLocations, OFFSET$pSampleLocations, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("shadingRate"),
        ValueLayout.JAVA_INT.withName("sampleCount"),
        ValueLayout.JAVA_INT.withName("sampleLocationCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkCoarseSampleLocationNV.LAYOUT).withName("pSampleLocations")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$shadingRate = PathElement.groupElement("shadingRate");
    public static final PathElement PATH$sampleCount = PathElement.groupElement("sampleCount");
    public static final PathElement PATH$sampleLocationCount = PathElement.groupElement("sampleLocationCount");
    public static final PathElement PATH$pSampleLocations = PathElement.groupElement("pSampleLocations");

    public static final OfInt LAYOUT$shadingRate = (OfInt) LAYOUT.select(PATH$shadingRate);
    public static final OfInt LAYOUT$sampleCount = (OfInt) LAYOUT.select(PATH$sampleCount);
    public static final OfInt LAYOUT$sampleLocationCount = (OfInt) LAYOUT.select(PATH$sampleLocationCount);
    public static final AddressLayout LAYOUT$pSampleLocations = (AddressLayout) LAYOUT.select(PATH$pSampleLocations);

    public static final long SIZE$shadingRate = LAYOUT$shadingRate.byteSize();
    public static final long SIZE$sampleCount = LAYOUT$sampleCount.byteSize();
    public static final long SIZE$sampleLocationCount = LAYOUT$sampleLocationCount.byteSize();
    public static final long SIZE$pSampleLocations = LAYOUT$pSampleLocations.byteSize();

    public static final long OFFSET$shadingRate = LAYOUT.byteOffset(PATH$shadingRate);
    public static final long OFFSET$sampleCount = LAYOUT.byteOffset(PATH$sampleCount);
    public static final long OFFSET$sampleLocationCount = LAYOUT.byteOffset(PATH$sampleLocationCount);
    public static final long OFFSET$pSampleLocations = LAYOUT.byteOffset(PATH$pSampleLocations);
}
