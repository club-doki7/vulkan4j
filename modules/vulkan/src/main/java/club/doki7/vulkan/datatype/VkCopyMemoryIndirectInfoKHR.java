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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCopyMemoryIndirectInfoKHR.html"><code>VkCopyMemoryIndirectInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkCopyMemoryIndirectInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkAddressCopyFlagsKHR srcCopyFlags; // optional // @link substring="VkAddressCopyFlagsKHR" target="VkAddressCopyFlagsKHR" @link substring="srcCopyFlags" target="#srcCopyFlags"
///     VkAddressCopyFlagsKHR dstCopyFlags; // optional // @link substring="VkAddressCopyFlagsKHR" target="VkAddressCopyFlagsKHR" @link substring="dstCopyFlags" target="#dstCopyFlags"
///     uint32_t copyCount; // @link substring="copyCount" target="#copyCount"
///     VkStridedDeviceAddressRangeKHR copyAddressRange; // @link substring="VkStridedDeviceAddressRangeKHR" target="VkStridedDeviceAddressRangeKHR" @link substring="copyAddressRange" target="#copyAddressRange"
/// } VkCopyMemoryIndirectInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_COPY_MEMORY_INDIRECT_INFO_KHR`
///
/// The {@code allocate} ({@link VkCopyMemoryIndirectInfoKHR#allocate(Arena)}, {@link VkCopyMemoryIndirectInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkCopyMemoryIndirectInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCopyMemoryIndirectInfoKHR.html"><code>VkCopyMemoryIndirectInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkCopyMemoryIndirectInfoKHR(@NotNull MemorySegment segment) implements IVkCopyMemoryIndirectInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCopyMemoryIndirectInfoKHR.html"><code>VkCopyMemoryIndirectInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkCopyMemoryIndirectInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkCopyMemoryIndirectInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkCopyMemoryIndirectInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkCopyMemoryIndirectInfoKHR, Iterable<VkCopyMemoryIndirectInfoKHR> {
        public long size() {
            return segment.byteSize() / VkCopyMemoryIndirectInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkCopyMemoryIndirectInfoKHR at(long index) {
            return new VkCopyMemoryIndirectInfoKHR(segment.asSlice(index * VkCopyMemoryIndirectInfoKHR.BYTES, VkCopyMemoryIndirectInfoKHR.BYTES));
        }

        public VkCopyMemoryIndirectInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkCopyMemoryIndirectInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkCopyMemoryIndirectInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkCopyMemoryIndirectInfoKHR.BYTES, VkCopyMemoryIndirectInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkCopyMemoryIndirectInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkCopyMemoryIndirectInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkCopyMemoryIndirectInfoKHR.BYTES,
                (end - start) * VkCopyMemoryIndirectInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkCopyMemoryIndirectInfoKHR.BYTES));
        }

        public VkCopyMemoryIndirectInfoKHR[] toArray() {
            VkCopyMemoryIndirectInfoKHR[] ret = new VkCopyMemoryIndirectInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkCopyMemoryIndirectInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkCopyMemoryIndirectInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkCopyMemoryIndirectInfoKHR.BYTES;
            }

            @Override
            public VkCopyMemoryIndirectInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkCopyMemoryIndirectInfoKHR ret = new VkCopyMemoryIndirectInfoKHR(segment.asSlice(0, VkCopyMemoryIndirectInfoKHR.BYTES));
                segment = segment.asSlice(VkCopyMemoryIndirectInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkCopyMemoryIndirectInfoKHR allocate(Arena arena) {
        VkCopyMemoryIndirectInfoKHR ret = new VkCopyMemoryIndirectInfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.COPY_MEMORY_INDIRECT_INFO_KHR);
        return ret;
    }

    public static VkCopyMemoryIndirectInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkCopyMemoryIndirectInfoKHR.Ptr ret = new VkCopyMemoryIndirectInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.COPY_MEMORY_INDIRECT_INFO_KHR);
        }
        return ret;
    }

    public static VkCopyMemoryIndirectInfoKHR clone(Arena arena, VkCopyMemoryIndirectInfoKHR src) {
        VkCopyMemoryIndirectInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.COPY_MEMORY_INDIRECT_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkCopyMemoryIndirectInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkCopyMemoryIndirectInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkCopyMemoryIndirectInfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkAddressCopyFlagsKHR.class) int srcCopyFlags() {
        return segment.get(LAYOUT$srcCopyFlags, OFFSET$srcCopyFlags);
    }

    public VkCopyMemoryIndirectInfoKHR srcCopyFlags(@Bitmask(VkAddressCopyFlagsKHR.class) int value) {
        segment.set(LAYOUT$srcCopyFlags, OFFSET$srcCopyFlags, value);
        return this;
    }

    public @Bitmask(VkAddressCopyFlagsKHR.class) int dstCopyFlags() {
        return segment.get(LAYOUT$dstCopyFlags, OFFSET$dstCopyFlags);
    }

    public VkCopyMemoryIndirectInfoKHR dstCopyFlags(@Bitmask(VkAddressCopyFlagsKHR.class) int value) {
        segment.set(LAYOUT$dstCopyFlags, OFFSET$dstCopyFlags, value);
        return this;
    }

    public @Unsigned int copyCount() {
        return segment.get(LAYOUT$copyCount, OFFSET$copyCount);
    }

    public VkCopyMemoryIndirectInfoKHR copyCount(@Unsigned int value) {
        segment.set(LAYOUT$copyCount, OFFSET$copyCount, value);
        return this;
    }

    public @NotNull VkStridedDeviceAddressRangeKHR copyAddressRange() {
        return new VkStridedDeviceAddressRangeKHR(segment.asSlice(OFFSET$copyAddressRange, LAYOUT$copyAddressRange));
    }

    public VkCopyMemoryIndirectInfoKHR copyAddressRange(@NotNull VkStridedDeviceAddressRangeKHR value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$copyAddressRange, SIZE$copyAddressRange);
        return this;
    }

    public VkCopyMemoryIndirectInfoKHR copyAddressRange(Consumer<@NotNull VkStridedDeviceAddressRangeKHR> consumer) {
        consumer.accept(copyAddressRange());
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("srcCopyFlags"),
        ValueLayout.JAVA_INT.withName("dstCopyFlags"),
        ValueLayout.JAVA_INT.withName("copyCount"),
        VkStridedDeviceAddressRangeKHR.LAYOUT.withName("copyAddressRange")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$srcCopyFlags = PathElement.groupElement("srcCopyFlags");
    public static final PathElement PATH$dstCopyFlags = PathElement.groupElement("dstCopyFlags");
    public static final PathElement PATH$copyCount = PathElement.groupElement("copyCount");
    public static final PathElement PATH$copyAddressRange = PathElement.groupElement("copyAddressRange");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$srcCopyFlags = (OfInt) LAYOUT.select(PATH$srcCopyFlags);
    public static final OfInt LAYOUT$dstCopyFlags = (OfInt) LAYOUT.select(PATH$dstCopyFlags);
    public static final OfInt LAYOUT$copyCount = (OfInt) LAYOUT.select(PATH$copyCount);
    public static final StructLayout LAYOUT$copyAddressRange = (StructLayout) LAYOUT.select(PATH$copyAddressRange);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$srcCopyFlags = LAYOUT$srcCopyFlags.byteSize();
    public static final long SIZE$dstCopyFlags = LAYOUT$dstCopyFlags.byteSize();
    public static final long SIZE$copyCount = LAYOUT$copyCount.byteSize();
    public static final long SIZE$copyAddressRange = LAYOUT$copyAddressRange.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$srcCopyFlags = LAYOUT.byteOffset(PATH$srcCopyFlags);
    public static final long OFFSET$dstCopyFlags = LAYOUT.byteOffset(PATH$dstCopyFlags);
    public static final long OFFSET$copyCount = LAYOUT.byteOffset(PATH$copyCount);
    public static final long OFFSET$copyAddressRange = LAYOUT.byteOffset(PATH$copyAddressRange);
}
