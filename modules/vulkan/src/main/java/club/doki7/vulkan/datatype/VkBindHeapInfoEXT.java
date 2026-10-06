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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBindHeapInfoEXT.html"><code>VkBindHeapInfoEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkBindHeapInfoEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkDeviceAddressRangeEXT heapRange; // @link substring="VkDeviceAddressRangeKHR" target="VkDeviceAddressRangeEXT" @link substring="heapRange" target="#heapRange"
///     VkDeviceSize reservedRangeOffset; // @link substring="reservedRangeOffset" target="#reservedRangeOffset"
///     VkDeviceSize reservedRangeSize; // @link substring="reservedRangeSize" target="#reservedRangeSize"
/// } VkBindHeapInfoEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_BIND_HEAP_INFO_EXT`
///
/// The {@code allocate} ({@link VkBindHeapInfoEXT#allocate(Arena)}, {@link VkBindHeapInfoEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkBindHeapInfoEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBindHeapInfoEXT.html"><code>VkBindHeapInfoEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkBindHeapInfoEXT(@NotNull MemorySegment segment) implements IVkBindHeapInfoEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBindHeapInfoEXT.html"><code>VkBindHeapInfoEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkBindHeapInfoEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkBindHeapInfoEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkBindHeapInfoEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkBindHeapInfoEXT, Iterable<VkBindHeapInfoEXT> {
        public long size() {
            return segment.byteSize() / VkBindHeapInfoEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkBindHeapInfoEXT at(long index) {
            return new VkBindHeapInfoEXT(segment.asSlice(index * VkBindHeapInfoEXT.BYTES, VkBindHeapInfoEXT.BYTES));
        }

        public VkBindHeapInfoEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkBindHeapInfoEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkBindHeapInfoEXT value) {
            MemorySegment s = segment.asSlice(index * VkBindHeapInfoEXT.BYTES, VkBindHeapInfoEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkBindHeapInfoEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkBindHeapInfoEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkBindHeapInfoEXT.BYTES,
                (end - start) * VkBindHeapInfoEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkBindHeapInfoEXT.BYTES));
        }

        public VkBindHeapInfoEXT[] toArray() {
            VkBindHeapInfoEXT[] ret = new VkBindHeapInfoEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkBindHeapInfoEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkBindHeapInfoEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkBindHeapInfoEXT.BYTES;
            }

            @Override
            public VkBindHeapInfoEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkBindHeapInfoEXT ret = new VkBindHeapInfoEXT(segment.asSlice(0, VkBindHeapInfoEXT.BYTES));
                segment = segment.asSlice(VkBindHeapInfoEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkBindHeapInfoEXT allocate(Arena arena) {
        VkBindHeapInfoEXT ret = new VkBindHeapInfoEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.BIND_HEAP_INFO_EXT);
        return ret;
    }

    public static VkBindHeapInfoEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkBindHeapInfoEXT.Ptr ret = new VkBindHeapInfoEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.BIND_HEAP_INFO_EXT);
        }
        return ret;
    }

    public static VkBindHeapInfoEXT clone(Arena arena, VkBindHeapInfoEXT src) {
        VkBindHeapInfoEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.BIND_HEAP_INFO_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkBindHeapInfoEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkBindHeapInfoEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkBindHeapInfoEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NotNull VkDeviceAddressRangeKHR heapRange() {
        return new VkDeviceAddressRangeKHR(segment.asSlice(OFFSET$heapRange, LAYOUT$heapRange));
    }

    public VkBindHeapInfoEXT heapRange(@NotNull VkDeviceAddressRangeKHR value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$heapRange, SIZE$heapRange);
        return this;
    }

    public VkBindHeapInfoEXT heapRange(Consumer<@NotNull VkDeviceAddressRangeKHR> consumer) {
        consumer.accept(heapRange());
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long reservedRangeOffset() {
        return segment.get(LAYOUT$reservedRangeOffset, OFFSET$reservedRangeOffset);
    }

    public VkBindHeapInfoEXT reservedRangeOffset(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$reservedRangeOffset, OFFSET$reservedRangeOffset, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long reservedRangeSize() {
        return segment.get(LAYOUT$reservedRangeSize, OFFSET$reservedRangeSize);
    }

    public VkBindHeapInfoEXT reservedRangeSize(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$reservedRangeSize, OFFSET$reservedRangeSize, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        VkDeviceAddressRangeKHR.LAYOUT.withName("heapRange"),
        ValueLayout.JAVA_LONG.withName("reservedRangeOffset"),
        ValueLayout.JAVA_LONG.withName("reservedRangeSize")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$heapRange = PathElement.groupElement("heapRange");
    public static final PathElement PATH$reservedRangeOffset = PathElement.groupElement("reservedRangeOffset");
    public static final PathElement PATH$reservedRangeSize = PathElement.groupElement("reservedRangeSize");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final StructLayout LAYOUT$heapRange = (StructLayout) LAYOUT.select(PATH$heapRange);
    public static final OfLong LAYOUT$reservedRangeOffset = (OfLong) LAYOUT.select(PATH$reservedRangeOffset);
    public static final OfLong LAYOUT$reservedRangeSize = (OfLong) LAYOUT.select(PATH$reservedRangeSize);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$heapRange = LAYOUT$heapRange.byteSize();
    public static final long SIZE$reservedRangeOffset = LAYOUT$reservedRangeOffset.byteSize();
    public static final long SIZE$reservedRangeSize = LAYOUT$reservedRangeSize.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$heapRange = LAYOUT.byteOffset(PATH$heapRange);
    public static final long OFFSET$reservedRangeOffset = LAYOUT.byteOffset(PATH$reservedRangeOffset);
    public static final long OFFSET$reservedRangeSize = LAYOUT.byteOffset(PATH$reservedRangeSize);
}
