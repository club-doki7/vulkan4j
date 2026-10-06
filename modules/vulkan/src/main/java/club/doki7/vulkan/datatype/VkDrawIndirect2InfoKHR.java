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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDrawIndirect2InfoKHR.html"><code>VkDrawIndirect2InfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDrawIndirect2InfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkStridedDeviceAddressRangeKHR addressRange; // @link substring="VkStridedDeviceAddressRangeKHR" target="VkStridedDeviceAddressRangeKHR" @link substring="addressRange" target="#addressRange"
///     VkAddressCommandFlagsKHR addressFlags; // optional // @link substring="VkAddressCommandFlagsKHR" target="VkAddressCommandFlagsKHR" @link substring="addressFlags" target="#addressFlags"
///     uint32_t drawCount; // @link substring="drawCount" target="#drawCount"
/// } VkDrawIndirect2InfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_DRAW_INDIRECT_2_INFO_KHR`
///
/// The {@code allocate} ({@link VkDrawIndirect2InfoKHR#allocate(Arena)}, {@link VkDrawIndirect2InfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkDrawIndirect2InfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDrawIndirect2InfoKHR.html"><code>VkDrawIndirect2InfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDrawIndirect2InfoKHR(@NotNull MemorySegment segment) implements IVkDrawIndirect2InfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDrawIndirect2InfoKHR.html"><code>VkDrawIndirect2InfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDrawIndirect2InfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDrawIndirect2InfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDrawIndirect2InfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDrawIndirect2InfoKHR, Iterable<VkDrawIndirect2InfoKHR> {
        public long size() {
            return segment.byteSize() / VkDrawIndirect2InfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDrawIndirect2InfoKHR at(long index) {
            return new VkDrawIndirect2InfoKHR(segment.asSlice(index * VkDrawIndirect2InfoKHR.BYTES, VkDrawIndirect2InfoKHR.BYTES));
        }

        public VkDrawIndirect2InfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkDrawIndirect2InfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDrawIndirect2InfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkDrawIndirect2InfoKHR.BYTES, VkDrawIndirect2InfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDrawIndirect2InfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDrawIndirect2InfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDrawIndirect2InfoKHR.BYTES,
                (end - start) * VkDrawIndirect2InfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDrawIndirect2InfoKHR.BYTES));
        }

        public VkDrawIndirect2InfoKHR[] toArray() {
            VkDrawIndirect2InfoKHR[] ret = new VkDrawIndirect2InfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDrawIndirect2InfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDrawIndirect2InfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDrawIndirect2InfoKHR.BYTES;
            }

            @Override
            public VkDrawIndirect2InfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDrawIndirect2InfoKHR ret = new VkDrawIndirect2InfoKHR(segment.asSlice(0, VkDrawIndirect2InfoKHR.BYTES));
                segment = segment.asSlice(VkDrawIndirect2InfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDrawIndirect2InfoKHR allocate(Arena arena) {
        VkDrawIndirect2InfoKHR ret = new VkDrawIndirect2InfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.DRAW_INDIRECT_2_INFO_KHR);
        return ret;
    }

    public static VkDrawIndirect2InfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkDrawIndirect2InfoKHR.Ptr ret = new VkDrawIndirect2InfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.DRAW_INDIRECT_2_INFO_KHR);
        }
        return ret;
    }

    public static VkDrawIndirect2InfoKHR clone(Arena arena, VkDrawIndirect2InfoKHR src) {
        VkDrawIndirect2InfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.DRAW_INDIRECT_2_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkDrawIndirect2InfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkDrawIndirect2InfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkDrawIndirect2InfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NotNull VkStridedDeviceAddressRangeKHR addressRange() {
        return new VkStridedDeviceAddressRangeKHR(segment.asSlice(OFFSET$addressRange, LAYOUT$addressRange));
    }

    public VkDrawIndirect2InfoKHR addressRange(@NotNull VkStridedDeviceAddressRangeKHR value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$addressRange, SIZE$addressRange);
        return this;
    }

    public VkDrawIndirect2InfoKHR addressRange(Consumer<@NotNull VkStridedDeviceAddressRangeKHR> consumer) {
        consumer.accept(addressRange());
        return this;
    }

    public @Bitmask(VkAddressCommandFlagsKHR.class) int addressFlags() {
        return segment.get(LAYOUT$addressFlags, OFFSET$addressFlags);
    }

    public VkDrawIndirect2InfoKHR addressFlags(@Bitmask(VkAddressCommandFlagsKHR.class) int value) {
        segment.set(LAYOUT$addressFlags, OFFSET$addressFlags, value);
        return this;
    }

    public @Unsigned int drawCount() {
        return segment.get(LAYOUT$drawCount, OFFSET$drawCount);
    }

    public VkDrawIndirect2InfoKHR drawCount(@Unsigned int value) {
        segment.set(LAYOUT$drawCount, OFFSET$drawCount, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        VkStridedDeviceAddressRangeKHR.LAYOUT.withName("addressRange"),
        ValueLayout.JAVA_INT.withName("addressFlags"),
        ValueLayout.JAVA_INT.withName("drawCount")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$addressRange = PathElement.groupElement("addressRange");
    public static final PathElement PATH$addressFlags = PathElement.groupElement("addressFlags");
    public static final PathElement PATH$drawCount = PathElement.groupElement("drawCount");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final StructLayout LAYOUT$addressRange = (StructLayout) LAYOUT.select(PATH$addressRange);
    public static final OfInt LAYOUT$addressFlags = (OfInt) LAYOUT.select(PATH$addressFlags);
    public static final OfInt LAYOUT$drawCount = (OfInt) LAYOUT.select(PATH$drawCount);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$addressRange = LAYOUT$addressRange.byteSize();
    public static final long SIZE$addressFlags = LAYOUT$addressFlags.byteSize();
    public static final long SIZE$drawCount = LAYOUT$drawCount.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$addressRange = LAYOUT.byteOffset(PATH$addressRange);
    public static final long OFFSET$addressFlags = LAYOUT.byteOffset(PATH$addressFlags);
    public static final long OFFSET$drawCount = LAYOUT.byteOffset(PATH$drawCount);
}
