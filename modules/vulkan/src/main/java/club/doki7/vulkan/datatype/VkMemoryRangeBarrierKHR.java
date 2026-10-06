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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMemoryRangeBarrierKHR.html"><code>VkMemoryRangeBarrierKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkMemoryRangeBarrierKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkPipelineStageFlags2 srcStageMask; // optional // @link substring="VkPipelineStageFlags2" target="VkPipelineStageFlags2" @link substring="srcStageMask" target="#srcStageMask"
///     VkAccessFlags2 srcAccessMask; // optional // @link substring="VkAccessFlags2" target="VkAccessFlags2" @link substring="srcAccessMask" target="#srcAccessMask"
///     VkPipelineStageFlags2 dstStageMask; // optional // @link substring="VkPipelineStageFlags2" target="VkPipelineStageFlags2" @link substring="dstStageMask" target="#dstStageMask"
///     VkAccessFlags2 dstAccessMask; // optional // @link substring="VkAccessFlags2" target="VkAccessFlags2" @link substring="dstAccessMask" target="#dstAccessMask"
///     uint32_t srcQueueFamilyIndex; // @link substring="srcQueueFamilyIndex" target="#srcQueueFamilyIndex"
///     uint32_t dstQueueFamilyIndex; // @link substring="dstQueueFamilyIndex" target="#dstQueueFamilyIndex"
///     VkDeviceAddressRangeKHR addressRange; // @link substring="VkDeviceAddressRangeKHR" target="VkDeviceAddressRangeKHR" @link substring="addressRange" target="#addressRange"
///     VkAddressCommandFlagsKHR addressFlags; // optional // @link substring="VkAddressCommandFlagsKHR" target="VkAddressCommandFlagsKHR" @link substring="addressFlags" target="#addressFlags"
/// } VkMemoryRangeBarrierKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_MEMORY_RANGE_BARRIER_KHR`
///
/// The {@code allocate} ({@link VkMemoryRangeBarrierKHR#allocate(Arena)}, {@link VkMemoryRangeBarrierKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkMemoryRangeBarrierKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMemoryRangeBarrierKHR.html"><code>VkMemoryRangeBarrierKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkMemoryRangeBarrierKHR(@NotNull MemorySegment segment) implements IVkMemoryRangeBarrierKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMemoryRangeBarrierKHR.html"><code>VkMemoryRangeBarrierKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkMemoryRangeBarrierKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkMemoryRangeBarrierKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkMemoryRangeBarrierKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkMemoryRangeBarrierKHR, Iterable<VkMemoryRangeBarrierKHR> {
        public long size() {
            return segment.byteSize() / VkMemoryRangeBarrierKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkMemoryRangeBarrierKHR at(long index) {
            return new VkMemoryRangeBarrierKHR(segment.asSlice(index * VkMemoryRangeBarrierKHR.BYTES, VkMemoryRangeBarrierKHR.BYTES));
        }

        public VkMemoryRangeBarrierKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkMemoryRangeBarrierKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkMemoryRangeBarrierKHR value) {
            MemorySegment s = segment.asSlice(index * VkMemoryRangeBarrierKHR.BYTES, VkMemoryRangeBarrierKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkMemoryRangeBarrierKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkMemoryRangeBarrierKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkMemoryRangeBarrierKHR.BYTES,
                (end - start) * VkMemoryRangeBarrierKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkMemoryRangeBarrierKHR.BYTES));
        }

        public VkMemoryRangeBarrierKHR[] toArray() {
            VkMemoryRangeBarrierKHR[] ret = new VkMemoryRangeBarrierKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkMemoryRangeBarrierKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkMemoryRangeBarrierKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkMemoryRangeBarrierKHR.BYTES;
            }

            @Override
            public VkMemoryRangeBarrierKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkMemoryRangeBarrierKHR ret = new VkMemoryRangeBarrierKHR(segment.asSlice(0, VkMemoryRangeBarrierKHR.BYTES));
                segment = segment.asSlice(VkMemoryRangeBarrierKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkMemoryRangeBarrierKHR allocate(Arena arena) {
        VkMemoryRangeBarrierKHR ret = new VkMemoryRangeBarrierKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.MEMORY_RANGE_BARRIER_KHR);
        return ret;
    }

    public static VkMemoryRangeBarrierKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkMemoryRangeBarrierKHR.Ptr ret = new VkMemoryRangeBarrierKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.MEMORY_RANGE_BARRIER_KHR);
        }
        return ret;
    }

    public static VkMemoryRangeBarrierKHR clone(Arena arena, VkMemoryRangeBarrierKHR src) {
        VkMemoryRangeBarrierKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.MEMORY_RANGE_BARRIER_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkMemoryRangeBarrierKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkMemoryRangeBarrierKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkMemoryRangeBarrierKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkPipelineStageFlags2.class) long srcStageMask() {
        return segment.get(LAYOUT$srcStageMask, OFFSET$srcStageMask);
    }

    public VkMemoryRangeBarrierKHR srcStageMask(@Bitmask(VkPipelineStageFlags2.class) long value) {
        segment.set(LAYOUT$srcStageMask, OFFSET$srcStageMask, value);
        return this;
    }

    public @Bitmask(VkAccessFlags2.class) long srcAccessMask() {
        return segment.get(LAYOUT$srcAccessMask, OFFSET$srcAccessMask);
    }

    public VkMemoryRangeBarrierKHR srcAccessMask(@Bitmask(VkAccessFlags2.class) long value) {
        segment.set(LAYOUT$srcAccessMask, OFFSET$srcAccessMask, value);
        return this;
    }

    public @Bitmask(VkPipelineStageFlags2.class) long dstStageMask() {
        return segment.get(LAYOUT$dstStageMask, OFFSET$dstStageMask);
    }

    public VkMemoryRangeBarrierKHR dstStageMask(@Bitmask(VkPipelineStageFlags2.class) long value) {
        segment.set(LAYOUT$dstStageMask, OFFSET$dstStageMask, value);
        return this;
    }

    public @Bitmask(VkAccessFlags2.class) long dstAccessMask() {
        return segment.get(LAYOUT$dstAccessMask, OFFSET$dstAccessMask);
    }

    public VkMemoryRangeBarrierKHR dstAccessMask(@Bitmask(VkAccessFlags2.class) long value) {
        segment.set(LAYOUT$dstAccessMask, OFFSET$dstAccessMask, value);
        return this;
    }

    public @Unsigned int srcQueueFamilyIndex() {
        return segment.get(LAYOUT$srcQueueFamilyIndex, OFFSET$srcQueueFamilyIndex);
    }

    public VkMemoryRangeBarrierKHR srcQueueFamilyIndex(@Unsigned int value) {
        segment.set(LAYOUT$srcQueueFamilyIndex, OFFSET$srcQueueFamilyIndex, value);
        return this;
    }

    public @Unsigned int dstQueueFamilyIndex() {
        return segment.get(LAYOUT$dstQueueFamilyIndex, OFFSET$dstQueueFamilyIndex);
    }

    public VkMemoryRangeBarrierKHR dstQueueFamilyIndex(@Unsigned int value) {
        segment.set(LAYOUT$dstQueueFamilyIndex, OFFSET$dstQueueFamilyIndex, value);
        return this;
    }

    public @NotNull VkDeviceAddressRangeKHR addressRange() {
        return new VkDeviceAddressRangeKHR(segment.asSlice(OFFSET$addressRange, LAYOUT$addressRange));
    }

    public VkMemoryRangeBarrierKHR addressRange(@NotNull VkDeviceAddressRangeKHR value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$addressRange, SIZE$addressRange);
        return this;
    }

    public VkMemoryRangeBarrierKHR addressRange(Consumer<@NotNull VkDeviceAddressRangeKHR> consumer) {
        consumer.accept(addressRange());
        return this;
    }

    public @Bitmask(VkAddressCommandFlagsKHR.class) int addressFlags() {
        return segment.get(LAYOUT$addressFlags, OFFSET$addressFlags);
    }

    public VkMemoryRangeBarrierKHR addressFlags(@Bitmask(VkAddressCommandFlagsKHR.class) int value) {
        segment.set(LAYOUT$addressFlags, OFFSET$addressFlags, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_LONG.withName("srcStageMask"),
        ValueLayout.JAVA_LONG.withName("srcAccessMask"),
        ValueLayout.JAVA_LONG.withName("dstStageMask"),
        ValueLayout.JAVA_LONG.withName("dstAccessMask"),
        ValueLayout.JAVA_INT.withName("srcQueueFamilyIndex"),
        ValueLayout.JAVA_INT.withName("dstQueueFamilyIndex"),
        VkDeviceAddressRangeKHR.LAYOUT.withName("addressRange"),
        ValueLayout.JAVA_INT.withName("addressFlags")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$srcStageMask = PathElement.groupElement("srcStageMask");
    public static final PathElement PATH$srcAccessMask = PathElement.groupElement("srcAccessMask");
    public static final PathElement PATH$dstStageMask = PathElement.groupElement("dstStageMask");
    public static final PathElement PATH$dstAccessMask = PathElement.groupElement("dstAccessMask");
    public static final PathElement PATH$srcQueueFamilyIndex = PathElement.groupElement("srcQueueFamilyIndex");
    public static final PathElement PATH$dstQueueFamilyIndex = PathElement.groupElement("dstQueueFamilyIndex");
    public static final PathElement PATH$addressRange = PathElement.groupElement("addressRange");
    public static final PathElement PATH$addressFlags = PathElement.groupElement("addressFlags");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfLong LAYOUT$srcStageMask = (OfLong) LAYOUT.select(PATH$srcStageMask);
    public static final OfLong LAYOUT$srcAccessMask = (OfLong) LAYOUT.select(PATH$srcAccessMask);
    public static final OfLong LAYOUT$dstStageMask = (OfLong) LAYOUT.select(PATH$dstStageMask);
    public static final OfLong LAYOUT$dstAccessMask = (OfLong) LAYOUT.select(PATH$dstAccessMask);
    public static final OfInt LAYOUT$srcQueueFamilyIndex = (OfInt) LAYOUT.select(PATH$srcQueueFamilyIndex);
    public static final OfInt LAYOUT$dstQueueFamilyIndex = (OfInt) LAYOUT.select(PATH$dstQueueFamilyIndex);
    public static final StructLayout LAYOUT$addressRange = (StructLayout) LAYOUT.select(PATH$addressRange);
    public static final OfInt LAYOUT$addressFlags = (OfInt) LAYOUT.select(PATH$addressFlags);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$srcStageMask = LAYOUT$srcStageMask.byteSize();
    public static final long SIZE$srcAccessMask = LAYOUT$srcAccessMask.byteSize();
    public static final long SIZE$dstStageMask = LAYOUT$dstStageMask.byteSize();
    public static final long SIZE$dstAccessMask = LAYOUT$dstAccessMask.byteSize();
    public static final long SIZE$srcQueueFamilyIndex = LAYOUT$srcQueueFamilyIndex.byteSize();
    public static final long SIZE$dstQueueFamilyIndex = LAYOUT$dstQueueFamilyIndex.byteSize();
    public static final long SIZE$addressRange = LAYOUT$addressRange.byteSize();
    public static final long SIZE$addressFlags = LAYOUT$addressFlags.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$srcStageMask = LAYOUT.byteOffset(PATH$srcStageMask);
    public static final long OFFSET$srcAccessMask = LAYOUT.byteOffset(PATH$srcAccessMask);
    public static final long OFFSET$dstStageMask = LAYOUT.byteOffset(PATH$dstStageMask);
    public static final long OFFSET$dstAccessMask = LAYOUT.byteOffset(PATH$dstAccessMask);
    public static final long OFFSET$srcQueueFamilyIndex = LAYOUT.byteOffset(PATH$srcQueueFamilyIndex);
    public static final long OFFSET$dstQueueFamilyIndex = LAYOUT.byteOffset(PATH$dstQueueFamilyIndex);
    public static final long OFFSET$addressRange = LAYOUT.byteOffset(PATH$addressRange);
    public static final long OFFSET$addressFlags = LAYOUT.byteOffset(PATH$addressFlags);
}
