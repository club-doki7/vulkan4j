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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeIntraRefreshCapabilitiesKHR.html"><code>VkVideoEncodeIntraRefreshCapabilitiesKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkVideoEncodeIntraRefreshCapabilitiesKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkVideoEncodeIntraRefreshModeFlagsKHR intraRefreshModes; // optional // @link substring="VkVideoEncodeIntraRefreshModeFlagsKHR" target="VkVideoEncodeIntraRefreshModeFlagsKHR" @link substring="intraRefreshModes" target="#intraRefreshModes"
///     uint32_t maxIntraRefreshCycleDuration; // @link substring="maxIntraRefreshCycleDuration" target="#maxIntraRefreshCycleDuration"
///     uint32_t maxIntraRefreshActiveReferencePictures; // @link substring="maxIntraRefreshActiveReferencePictures" target="#maxIntraRefreshActiveReferencePictures"
///     VkBool32 partitionIndependentIntraRefreshRegions; // @link substring="partitionIndependentIntraRefreshRegions" target="#partitionIndependentIntraRefreshRegions"
///     VkBool32 nonRectangularIntraRefreshRegions; // @link substring="nonRectangularIntraRefreshRegions" target="#nonRectangularIntraRefreshRegions"
/// } VkVideoEncodeIntraRefreshCapabilitiesKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_VIDEO_ENCODE_INTRA_REFRESH_CAPABILITIES_KHR`
///
/// The {@code allocate} ({@link VkVideoEncodeIntraRefreshCapabilitiesKHR#allocate(Arena)}, {@link VkVideoEncodeIntraRefreshCapabilitiesKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkVideoEncodeIntraRefreshCapabilitiesKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeIntraRefreshCapabilitiesKHR.html"><code>VkVideoEncodeIntraRefreshCapabilitiesKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkVideoEncodeIntraRefreshCapabilitiesKHR(@NotNull MemorySegment segment) implements IVkVideoEncodeIntraRefreshCapabilitiesKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeIntraRefreshCapabilitiesKHR.html"><code>VkVideoEncodeIntraRefreshCapabilitiesKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkVideoEncodeIntraRefreshCapabilitiesKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkVideoEncodeIntraRefreshCapabilitiesKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkVideoEncodeIntraRefreshCapabilitiesKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkVideoEncodeIntraRefreshCapabilitiesKHR, Iterable<VkVideoEncodeIntraRefreshCapabilitiesKHR> {
        public long size() {
            return segment.byteSize() / VkVideoEncodeIntraRefreshCapabilitiesKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkVideoEncodeIntraRefreshCapabilitiesKHR at(long index) {
            return new VkVideoEncodeIntraRefreshCapabilitiesKHR(segment.asSlice(index * VkVideoEncodeIntraRefreshCapabilitiesKHR.BYTES, VkVideoEncodeIntraRefreshCapabilitiesKHR.BYTES));
        }

        public VkVideoEncodeIntraRefreshCapabilitiesKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkVideoEncodeIntraRefreshCapabilitiesKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkVideoEncodeIntraRefreshCapabilitiesKHR value) {
            MemorySegment s = segment.asSlice(index * VkVideoEncodeIntraRefreshCapabilitiesKHR.BYTES, VkVideoEncodeIntraRefreshCapabilitiesKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkVideoEncodeIntraRefreshCapabilitiesKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkVideoEncodeIntraRefreshCapabilitiesKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkVideoEncodeIntraRefreshCapabilitiesKHR.BYTES,
                (end - start) * VkVideoEncodeIntraRefreshCapabilitiesKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkVideoEncodeIntraRefreshCapabilitiesKHR.BYTES));
        }

        public VkVideoEncodeIntraRefreshCapabilitiesKHR[] toArray() {
            VkVideoEncodeIntraRefreshCapabilitiesKHR[] ret = new VkVideoEncodeIntraRefreshCapabilitiesKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkVideoEncodeIntraRefreshCapabilitiesKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkVideoEncodeIntraRefreshCapabilitiesKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkVideoEncodeIntraRefreshCapabilitiesKHR.BYTES;
            }

            @Override
            public VkVideoEncodeIntraRefreshCapabilitiesKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkVideoEncodeIntraRefreshCapabilitiesKHR ret = new VkVideoEncodeIntraRefreshCapabilitiesKHR(segment.asSlice(0, VkVideoEncodeIntraRefreshCapabilitiesKHR.BYTES));
                segment = segment.asSlice(VkVideoEncodeIntraRefreshCapabilitiesKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkVideoEncodeIntraRefreshCapabilitiesKHR allocate(Arena arena) {
        VkVideoEncodeIntraRefreshCapabilitiesKHR ret = new VkVideoEncodeIntraRefreshCapabilitiesKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.VIDEO_ENCODE_INTRA_REFRESH_CAPABILITIES_KHR);
        return ret;
    }

    public static VkVideoEncodeIntraRefreshCapabilitiesKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkVideoEncodeIntraRefreshCapabilitiesKHR.Ptr ret = new VkVideoEncodeIntraRefreshCapabilitiesKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.VIDEO_ENCODE_INTRA_REFRESH_CAPABILITIES_KHR);
        }
        return ret;
    }

    public static VkVideoEncodeIntraRefreshCapabilitiesKHR clone(Arena arena, VkVideoEncodeIntraRefreshCapabilitiesKHR src) {
        VkVideoEncodeIntraRefreshCapabilitiesKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.VIDEO_ENCODE_INTRA_REFRESH_CAPABILITIES_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkVideoEncodeIntraRefreshCapabilitiesKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkVideoEncodeIntraRefreshCapabilitiesKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkVideoEncodeIntraRefreshCapabilitiesKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkVideoEncodeIntraRefreshModeFlagsKHR.class) int intraRefreshModes() {
        return segment.get(LAYOUT$intraRefreshModes, OFFSET$intraRefreshModes);
    }

    public VkVideoEncodeIntraRefreshCapabilitiesKHR intraRefreshModes(@Bitmask(VkVideoEncodeIntraRefreshModeFlagsKHR.class) int value) {
        segment.set(LAYOUT$intraRefreshModes, OFFSET$intraRefreshModes, value);
        return this;
    }

    public @Unsigned int maxIntraRefreshCycleDuration() {
        return segment.get(LAYOUT$maxIntraRefreshCycleDuration, OFFSET$maxIntraRefreshCycleDuration);
    }

    public VkVideoEncodeIntraRefreshCapabilitiesKHR maxIntraRefreshCycleDuration(@Unsigned int value) {
        segment.set(LAYOUT$maxIntraRefreshCycleDuration, OFFSET$maxIntraRefreshCycleDuration, value);
        return this;
    }

    public @Unsigned int maxIntraRefreshActiveReferencePictures() {
        return segment.get(LAYOUT$maxIntraRefreshActiveReferencePictures, OFFSET$maxIntraRefreshActiveReferencePictures);
    }

    public VkVideoEncodeIntraRefreshCapabilitiesKHR maxIntraRefreshActiveReferencePictures(@Unsigned int value) {
        segment.set(LAYOUT$maxIntraRefreshActiveReferencePictures, OFFSET$maxIntraRefreshActiveReferencePictures, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int partitionIndependentIntraRefreshRegions() {
        return segment.get(LAYOUT$partitionIndependentIntraRefreshRegions, OFFSET$partitionIndependentIntraRefreshRegions);
    }

    public VkVideoEncodeIntraRefreshCapabilitiesKHR partitionIndependentIntraRefreshRegions(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$partitionIndependentIntraRefreshRegions, OFFSET$partitionIndependentIntraRefreshRegions, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int nonRectangularIntraRefreshRegions() {
        return segment.get(LAYOUT$nonRectangularIntraRefreshRegions, OFFSET$nonRectangularIntraRefreshRegions);
    }

    public VkVideoEncodeIntraRefreshCapabilitiesKHR nonRectangularIntraRefreshRegions(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$nonRectangularIntraRefreshRegions, OFFSET$nonRectangularIntraRefreshRegions, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("intraRefreshModes"),
        ValueLayout.JAVA_INT.withName("maxIntraRefreshCycleDuration"),
        ValueLayout.JAVA_INT.withName("maxIntraRefreshActiveReferencePictures"),
        ValueLayout.JAVA_INT.withName("partitionIndependentIntraRefreshRegions"),
        ValueLayout.JAVA_INT.withName("nonRectangularIntraRefreshRegions")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$intraRefreshModes = PathElement.groupElement("intraRefreshModes");
    public static final PathElement PATH$maxIntraRefreshCycleDuration = PathElement.groupElement("maxIntraRefreshCycleDuration");
    public static final PathElement PATH$maxIntraRefreshActiveReferencePictures = PathElement.groupElement("maxIntraRefreshActiveReferencePictures");
    public static final PathElement PATH$partitionIndependentIntraRefreshRegions = PathElement.groupElement("partitionIndependentIntraRefreshRegions");
    public static final PathElement PATH$nonRectangularIntraRefreshRegions = PathElement.groupElement("nonRectangularIntraRefreshRegions");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$intraRefreshModes = (OfInt) LAYOUT.select(PATH$intraRefreshModes);
    public static final OfInt LAYOUT$maxIntraRefreshCycleDuration = (OfInt) LAYOUT.select(PATH$maxIntraRefreshCycleDuration);
    public static final OfInt LAYOUT$maxIntraRefreshActiveReferencePictures = (OfInt) LAYOUT.select(PATH$maxIntraRefreshActiveReferencePictures);
    public static final OfInt LAYOUT$partitionIndependentIntraRefreshRegions = (OfInt) LAYOUT.select(PATH$partitionIndependentIntraRefreshRegions);
    public static final OfInt LAYOUT$nonRectangularIntraRefreshRegions = (OfInt) LAYOUT.select(PATH$nonRectangularIntraRefreshRegions);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$intraRefreshModes = LAYOUT$intraRefreshModes.byteSize();
    public static final long SIZE$maxIntraRefreshCycleDuration = LAYOUT$maxIntraRefreshCycleDuration.byteSize();
    public static final long SIZE$maxIntraRefreshActiveReferencePictures = LAYOUT$maxIntraRefreshActiveReferencePictures.byteSize();
    public static final long SIZE$partitionIndependentIntraRefreshRegions = LAYOUT$partitionIndependentIntraRefreshRegions.byteSize();
    public static final long SIZE$nonRectangularIntraRefreshRegions = LAYOUT$nonRectangularIntraRefreshRegions.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$intraRefreshModes = LAYOUT.byteOffset(PATH$intraRefreshModes);
    public static final long OFFSET$maxIntraRefreshCycleDuration = LAYOUT.byteOffset(PATH$maxIntraRefreshCycleDuration);
    public static final long OFFSET$maxIntraRefreshActiveReferencePictures = LAYOUT.byteOffset(PATH$maxIntraRefreshActiveReferencePictures);
    public static final long OFFSET$partitionIndependentIntraRefreshRegions = LAYOUT.byteOffset(PATH$partitionIndependentIntraRefreshRegions);
    public static final long OFFSET$nonRectangularIntraRefreshRegions = LAYOUT.byteOffset(PATH$nonRectangularIntraRefreshRegions);
}
