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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDrawIndirectCount2InfoKHR.html"><code>VkDrawIndirectCount2InfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDrawIndirectCount2InfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkStridedDeviceAddressRangeKHR addressRange; // @link substring="VkStridedDeviceAddressRangeKHR" target="VkStridedDeviceAddressRangeKHR" @link substring="addressRange" target="#addressRange"
///     VkAddressCommandFlagsKHR addressFlags; // optional // @link substring="VkAddressCommandFlagsKHR" target="VkAddressCommandFlagsKHR" @link substring="addressFlags" target="#addressFlags"
///     VkDeviceAddressRangeKHR countAddressRange; // @link substring="VkDeviceAddressRangeKHR" target="VkDeviceAddressRangeKHR" @link substring="countAddressRange" target="#countAddressRange"
///     VkAddressCommandFlagsKHR countAddressFlags; // optional // @link substring="VkAddressCommandFlagsKHR" target="VkAddressCommandFlagsKHR" @link substring="countAddressFlags" target="#countAddressFlags"
///     uint32_t maxDrawCount; // @link substring="maxDrawCount" target="#maxDrawCount"
/// } VkDrawIndirectCount2InfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_DRAW_INDIRECT_COUNT_2_INFO_KHR`
///
/// The {@code allocate} ({@link VkDrawIndirectCount2InfoKHR#allocate(Arena)}, {@link VkDrawIndirectCount2InfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkDrawIndirectCount2InfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDrawIndirectCount2InfoKHR.html"><code>VkDrawIndirectCount2InfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDrawIndirectCount2InfoKHR(@NotNull MemorySegment segment) implements IVkDrawIndirectCount2InfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDrawIndirectCount2InfoKHR.html"><code>VkDrawIndirectCount2InfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDrawIndirectCount2InfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDrawIndirectCount2InfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDrawIndirectCount2InfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDrawIndirectCount2InfoKHR, Iterable<VkDrawIndirectCount2InfoKHR> {
        public long size() {
            return segment.byteSize() / VkDrawIndirectCount2InfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDrawIndirectCount2InfoKHR at(long index) {
            return new VkDrawIndirectCount2InfoKHR(segment.asSlice(index * VkDrawIndirectCount2InfoKHR.BYTES, VkDrawIndirectCount2InfoKHR.BYTES));
        }

        public VkDrawIndirectCount2InfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkDrawIndirectCount2InfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDrawIndirectCount2InfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkDrawIndirectCount2InfoKHR.BYTES, VkDrawIndirectCount2InfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDrawIndirectCount2InfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDrawIndirectCount2InfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDrawIndirectCount2InfoKHR.BYTES,
                (end - start) * VkDrawIndirectCount2InfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDrawIndirectCount2InfoKHR.BYTES));
        }

        public VkDrawIndirectCount2InfoKHR[] toArray() {
            VkDrawIndirectCount2InfoKHR[] ret = new VkDrawIndirectCount2InfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDrawIndirectCount2InfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDrawIndirectCount2InfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDrawIndirectCount2InfoKHR.BYTES;
            }

            @Override
            public VkDrawIndirectCount2InfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDrawIndirectCount2InfoKHR ret = new VkDrawIndirectCount2InfoKHR(segment.asSlice(0, VkDrawIndirectCount2InfoKHR.BYTES));
                segment = segment.asSlice(VkDrawIndirectCount2InfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDrawIndirectCount2InfoKHR allocate(Arena arena) {
        VkDrawIndirectCount2InfoKHR ret = new VkDrawIndirectCount2InfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.DRAW_INDIRECT_COUNT_2_INFO_KHR);
        return ret;
    }

    public static VkDrawIndirectCount2InfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkDrawIndirectCount2InfoKHR.Ptr ret = new VkDrawIndirectCount2InfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.DRAW_INDIRECT_COUNT_2_INFO_KHR);
        }
        return ret;
    }

    public static VkDrawIndirectCount2InfoKHR clone(Arena arena, VkDrawIndirectCount2InfoKHR src) {
        VkDrawIndirectCount2InfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.DRAW_INDIRECT_COUNT_2_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkDrawIndirectCount2InfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkDrawIndirectCount2InfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkDrawIndirectCount2InfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NotNull VkStridedDeviceAddressRangeKHR addressRange() {
        return new VkStridedDeviceAddressRangeKHR(segment.asSlice(OFFSET$addressRange, LAYOUT$addressRange));
    }

    public VkDrawIndirectCount2InfoKHR addressRange(@NotNull VkStridedDeviceAddressRangeKHR value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$addressRange, SIZE$addressRange);
        return this;
    }

    public VkDrawIndirectCount2InfoKHR addressRange(Consumer<@NotNull VkStridedDeviceAddressRangeKHR> consumer) {
        consumer.accept(addressRange());
        return this;
    }

    public @Bitmask(VkAddressCommandFlagsKHR.class) int addressFlags() {
        return segment.get(LAYOUT$addressFlags, OFFSET$addressFlags);
    }

    public VkDrawIndirectCount2InfoKHR addressFlags(@Bitmask(VkAddressCommandFlagsKHR.class) int value) {
        segment.set(LAYOUT$addressFlags, OFFSET$addressFlags, value);
        return this;
    }

    public @NotNull VkDeviceAddressRangeKHR countAddressRange() {
        return new VkDeviceAddressRangeKHR(segment.asSlice(OFFSET$countAddressRange, LAYOUT$countAddressRange));
    }

    public VkDrawIndirectCount2InfoKHR countAddressRange(@NotNull VkDeviceAddressRangeKHR value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$countAddressRange, SIZE$countAddressRange);
        return this;
    }

    public VkDrawIndirectCount2InfoKHR countAddressRange(Consumer<@NotNull VkDeviceAddressRangeKHR> consumer) {
        consumer.accept(countAddressRange());
        return this;
    }

    public @Bitmask(VkAddressCommandFlagsKHR.class) int countAddressFlags() {
        return segment.get(LAYOUT$countAddressFlags, OFFSET$countAddressFlags);
    }

    public VkDrawIndirectCount2InfoKHR countAddressFlags(@Bitmask(VkAddressCommandFlagsKHR.class) int value) {
        segment.set(LAYOUT$countAddressFlags, OFFSET$countAddressFlags, value);
        return this;
    }

    public @Unsigned int maxDrawCount() {
        return segment.get(LAYOUT$maxDrawCount, OFFSET$maxDrawCount);
    }

    public VkDrawIndirectCount2InfoKHR maxDrawCount(@Unsigned int value) {
        segment.set(LAYOUT$maxDrawCount, OFFSET$maxDrawCount, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        VkStridedDeviceAddressRangeKHR.LAYOUT.withName("addressRange"),
        ValueLayout.JAVA_INT.withName("addressFlags"),
        VkDeviceAddressRangeKHR.LAYOUT.withName("countAddressRange"),
        ValueLayout.JAVA_INT.withName("countAddressFlags"),
        ValueLayout.JAVA_INT.withName("maxDrawCount")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$addressRange = PathElement.groupElement("addressRange");
    public static final PathElement PATH$addressFlags = PathElement.groupElement("addressFlags");
    public static final PathElement PATH$countAddressRange = PathElement.groupElement("countAddressRange");
    public static final PathElement PATH$countAddressFlags = PathElement.groupElement("countAddressFlags");
    public static final PathElement PATH$maxDrawCount = PathElement.groupElement("maxDrawCount");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final StructLayout LAYOUT$addressRange = (StructLayout) LAYOUT.select(PATH$addressRange);
    public static final OfInt LAYOUT$addressFlags = (OfInt) LAYOUT.select(PATH$addressFlags);
    public static final StructLayout LAYOUT$countAddressRange = (StructLayout) LAYOUT.select(PATH$countAddressRange);
    public static final OfInt LAYOUT$countAddressFlags = (OfInt) LAYOUT.select(PATH$countAddressFlags);
    public static final OfInt LAYOUT$maxDrawCount = (OfInt) LAYOUT.select(PATH$maxDrawCount);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$addressRange = LAYOUT$addressRange.byteSize();
    public static final long SIZE$addressFlags = LAYOUT$addressFlags.byteSize();
    public static final long SIZE$countAddressRange = LAYOUT$countAddressRange.byteSize();
    public static final long SIZE$countAddressFlags = LAYOUT$countAddressFlags.byteSize();
    public static final long SIZE$maxDrawCount = LAYOUT$maxDrawCount.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$addressRange = LAYOUT.byteOffset(PATH$addressRange);
    public static final long OFFSET$addressFlags = LAYOUT.byteOffset(PATH$addressFlags);
    public static final long OFFSET$countAddressRange = LAYOUT.byteOffset(PATH$countAddressRange);
    public static final long OFFSET$countAddressFlags = LAYOUT.byteOffset(PATH$countAddressFlags);
    public static final long OFFSET$maxDrawCount = LAYOUT.byteOffset(PATH$maxDrawCount);
}
