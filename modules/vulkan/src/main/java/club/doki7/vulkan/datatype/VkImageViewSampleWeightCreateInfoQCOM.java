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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageViewSampleWeightCreateInfoQCOM.html"><code>VkImageViewSampleWeightCreateInfoQCOM</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkImageViewSampleWeightCreateInfoQCOM {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkOffset2D filterCenter; // @link substring="VkOffset2D" target="VkOffset2D" @link substring="filterCenter" target="#filterCenter"
///     VkExtent2D filterSize; // @link substring="VkExtent2D" target="VkExtent2D" @link substring="filterSize" target="#filterSize"
///     uint32_t numPhases; // @link substring="numPhases" target="#numPhases"
/// } VkImageViewSampleWeightCreateInfoQCOM;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_IMAGE_VIEW_SAMPLE_WEIGHT_CREATE_INFO_QCOM`
///
/// The {@code allocate} ({@link VkImageViewSampleWeightCreateInfoQCOM#allocate(Arena)}, {@link VkImageViewSampleWeightCreateInfoQCOM#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkImageViewSampleWeightCreateInfoQCOM#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageViewSampleWeightCreateInfoQCOM.html"><code>VkImageViewSampleWeightCreateInfoQCOM</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkImageViewSampleWeightCreateInfoQCOM(@NotNull MemorySegment segment) implements IVkImageViewSampleWeightCreateInfoQCOM {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageViewSampleWeightCreateInfoQCOM.html"><code>VkImageViewSampleWeightCreateInfoQCOM</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkImageViewSampleWeightCreateInfoQCOM}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkImageViewSampleWeightCreateInfoQCOM to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkImageViewSampleWeightCreateInfoQCOM.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkImageViewSampleWeightCreateInfoQCOM, Iterable<VkImageViewSampleWeightCreateInfoQCOM> {
        public long size() {
            return segment.byteSize() / VkImageViewSampleWeightCreateInfoQCOM.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkImageViewSampleWeightCreateInfoQCOM at(long index) {
            return new VkImageViewSampleWeightCreateInfoQCOM(segment.asSlice(index * VkImageViewSampleWeightCreateInfoQCOM.BYTES, VkImageViewSampleWeightCreateInfoQCOM.BYTES));
        }

        public VkImageViewSampleWeightCreateInfoQCOM.Ptr at(long index, @NotNull Consumer<@NotNull VkImageViewSampleWeightCreateInfoQCOM> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkImageViewSampleWeightCreateInfoQCOM value) {
            MemorySegment s = segment.asSlice(index * VkImageViewSampleWeightCreateInfoQCOM.BYTES, VkImageViewSampleWeightCreateInfoQCOM.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkImageViewSampleWeightCreateInfoQCOM.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkImageViewSampleWeightCreateInfoQCOM.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkImageViewSampleWeightCreateInfoQCOM.BYTES,
                (end - start) * VkImageViewSampleWeightCreateInfoQCOM.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkImageViewSampleWeightCreateInfoQCOM.BYTES));
        }

        public VkImageViewSampleWeightCreateInfoQCOM[] toArray() {
            VkImageViewSampleWeightCreateInfoQCOM[] ret = new VkImageViewSampleWeightCreateInfoQCOM[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkImageViewSampleWeightCreateInfoQCOM> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkImageViewSampleWeightCreateInfoQCOM> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkImageViewSampleWeightCreateInfoQCOM.BYTES;
            }

            @Override
            public VkImageViewSampleWeightCreateInfoQCOM next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkImageViewSampleWeightCreateInfoQCOM ret = new VkImageViewSampleWeightCreateInfoQCOM(segment.asSlice(0, VkImageViewSampleWeightCreateInfoQCOM.BYTES));
                segment = segment.asSlice(VkImageViewSampleWeightCreateInfoQCOM.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkImageViewSampleWeightCreateInfoQCOM allocate(Arena arena) {
        VkImageViewSampleWeightCreateInfoQCOM ret = new VkImageViewSampleWeightCreateInfoQCOM(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.IMAGE_VIEW_SAMPLE_WEIGHT_CREATE_INFO_QCOM);
        return ret;
    }

    public static VkImageViewSampleWeightCreateInfoQCOM.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkImageViewSampleWeightCreateInfoQCOM.Ptr ret = new VkImageViewSampleWeightCreateInfoQCOM.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.IMAGE_VIEW_SAMPLE_WEIGHT_CREATE_INFO_QCOM);
        }
        return ret;
    }

    public static VkImageViewSampleWeightCreateInfoQCOM clone(Arena arena, VkImageViewSampleWeightCreateInfoQCOM src) {
        VkImageViewSampleWeightCreateInfoQCOM ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.IMAGE_VIEW_SAMPLE_WEIGHT_CREATE_INFO_QCOM);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkImageViewSampleWeightCreateInfoQCOM sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkImageViewSampleWeightCreateInfoQCOM pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkImageViewSampleWeightCreateInfoQCOM pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NotNull VkOffset2D filterCenter() {
        return new VkOffset2D(segment.asSlice(OFFSET$filterCenter, LAYOUT$filterCenter));
    }

    public VkImageViewSampleWeightCreateInfoQCOM filterCenter(@NotNull VkOffset2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$filterCenter, SIZE$filterCenter);
        return this;
    }

    public VkImageViewSampleWeightCreateInfoQCOM filterCenter(Consumer<@NotNull VkOffset2D> consumer) {
        consumer.accept(filterCenter());
        return this;
    }

    public @NotNull VkExtent2D filterSize() {
        return new VkExtent2D(segment.asSlice(OFFSET$filterSize, LAYOUT$filterSize));
    }

    public VkImageViewSampleWeightCreateInfoQCOM filterSize(@NotNull VkExtent2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$filterSize, SIZE$filterSize);
        return this;
    }

    public VkImageViewSampleWeightCreateInfoQCOM filterSize(Consumer<@NotNull VkExtent2D> consumer) {
        consumer.accept(filterSize());
        return this;
    }

    public @Unsigned int numPhases() {
        return segment.get(LAYOUT$numPhases, OFFSET$numPhases);
    }

    public VkImageViewSampleWeightCreateInfoQCOM numPhases(@Unsigned int value) {
        segment.set(LAYOUT$numPhases, OFFSET$numPhases, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        VkOffset2D.LAYOUT.withName("filterCenter"),
        VkExtent2D.LAYOUT.withName("filterSize"),
        ValueLayout.JAVA_INT.withName("numPhases")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$filterCenter = PathElement.groupElement("filterCenter");
    public static final PathElement PATH$filterSize = PathElement.groupElement("filterSize");
    public static final PathElement PATH$numPhases = PathElement.groupElement("numPhases");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final StructLayout LAYOUT$filterCenter = (StructLayout) LAYOUT.select(PATH$filterCenter);
    public static final StructLayout LAYOUT$filterSize = (StructLayout) LAYOUT.select(PATH$filterSize);
    public static final OfInt LAYOUT$numPhases = (OfInt) LAYOUT.select(PATH$numPhases);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$filterCenter = LAYOUT$filterCenter.byteSize();
    public static final long SIZE$filterSize = LAYOUT$filterSize.byteSize();
    public static final long SIZE$numPhases = LAYOUT$numPhases.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$filterCenter = LAYOUT.byteOffset(PATH$filterCenter);
    public static final long OFFSET$filterSize = LAYOUT.byteOffset(PATH$filterSize);
    public static final long OFFSET$numPhases = LAYOUT.byteOffset(PATH$numPhases);
}
