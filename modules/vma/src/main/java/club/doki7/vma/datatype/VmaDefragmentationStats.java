package club.doki7.vma.datatype;

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
import club.doki7.vma.bitmask.*;
import club.doki7.vma.handle.*;
import club.doki7.vma.enumtype.*;
import club.doki7.vma.VMAFunctionTypes.*;
import club.doki7.vulkan.bitmask.*;
import club.doki7.vulkan.datatype.*;
import club.doki7.vulkan.enumtype.*;
import club.doki7.vulkan.handle.*;
import static club.doki7.vulkan.VkConstants.*;

/// Statistics returned for defragmentation process in function vmaEndDefragmentation().
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VmaDefragmentationStats {
///     VkDeviceSize bytesMoved; // @link substring="bytesMoved" target="#bytesMoved"
///     VkDeviceSize bytesFreed; // @link substring="bytesFreed" target="#bytesFreed"
///     uint32_t allocationsMoved; // @link substring="allocationsMoved" target="#allocationsMoved"
///     uint32_t deviceMemoryBlocksFreed; // @link substring="deviceMemoryBlocksFreed" target="#deviceMemoryBlocksFreed"
/// } VmaDefragmentationStats;
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
/// ## Member documentation
///
/// <ul>
/// <li>{@link #bytesMoved} Total number of bytes that have been copied while moving allocations to different places.</li>
/// <li>{@link #bytesFreed} Total number of bytes that have been released to the system by freeing empty `VkDeviceMemory` objects.</li>
/// <li>{@link #allocationsMoved} Number of allocations that have been moved to different places.</li>
/// <li>{@link #deviceMemoryBlocksFreed} Number of empty `VkDeviceMemory` objects that have been released to the system.</li>
/// </ul>
@ValueBasedCandidate
@UnsafeConstructor
public record VmaDefragmentationStats(@NotNull MemorySegment segment) implements IVmaDefragmentationStats {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VmaDefragmentationStats}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVmaDefragmentationStats to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VmaDefragmentationStats.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVmaDefragmentationStats, Iterable<VmaDefragmentationStats> {
        public long size() {
            return segment.byteSize() / VmaDefragmentationStats.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VmaDefragmentationStats at(long index) {
            return new VmaDefragmentationStats(segment.asSlice(index * VmaDefragmentationStats.BYTES, VmaDefragmentationStats.BYTES));
        }

        public VmaDefragmentationStats.Ptr at(long index, @NotNull Consumer<@NotNull VmaDefragmentationStats> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VmaDefragmentationStats value) {
            MemorySegment s = segment.asSlice(index * VmaDefragmentationStats.BYTES, VmaDefragmentationStats.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VmaDefragmentationStats.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VmaDefragmentationStats.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VmaDefragmentationStats.BYTES,
                (end - start) * VmaDefragmentationStats.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VmaDefragmentationStats.BYTES));
        }

        public VmaDefragmentationStats[] toArray() {
            VmaDefragmentationStats[] ret = new VmaDefragmentationStats[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VmaDefragmentationStats> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VmaDefragmentationStats> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VmaDefragmentationStats.BYTES;
            }

            @Override
            public VmaDefragmentationStats next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VmaDefragmentationStats ret = new VmaDefragmentationStats(segment.asSlice(0, VmaDefragmentationStats.BYTES));
                segment = segment.asSlice(VmaDefragmentationStats.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VmaDefragmentationStats allocate(Arena arena) {
        return new VmaDefragmentationStats(arena.allocate(LAYOUT));
    }

    public static VmaDefragmentationStats.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VmaDefragmentationStats.Ptr(segment);
    }

    public static VmaDefragmentationStats clone(Arena arena, VmaDefragmentationStats src) {
        VmaDefragmentationStats ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NativeType("VkDeviceSize") @Unsigned long bytesMoved() {
        return segment.get(LAYOUT$bytesMoved, OFFSET$bytesMoved);
    }

    public VmaDefragmentationStats bytesMoved(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$bytesMoved, OFFSET$bytesMoved, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long bytesFreed() {
        return segment.get(LAYOUT$bytesFreed, OFFSET$bytesFreed);
    }

    public VmaDefragmentationStats bytesFreed(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$bytesFreed, OFFSET$bytesFreed, value);
        return this;
    }

    public @Unsigned int allocationsMoved() {
        return segment.get(LAYOUT$allocationsMoved, OFFSET$allocationsMoved);
    }

    public VmaDefragmentationStats allocationsMoved(@Unsigned int value) {
        segment.set(LAYOUT$allocationsMoved, OFFSET$allocationsMoved, value);
        return this;
    }

    public @Unsigned int deviceMemoryBlocksFreed() {
        return segment.get(LAYOUT$deviceMemoryBlocksFreed, OFFSET$deviceMemoryBlocksFreed);
    }

    public VmaDefragmentationStats deviceMemoryBlocksFreed(@Unsigned int value) {
        segment.set(LAYOUT$deviceMemoryBlocksFreed, OFFSET$deviceMemoryBlocksFreed, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_LONG.withName("bytesMoved"),
        ValueLayout.JAVA_LONG.withName("bytesFreed"),
        ValueLayout.JAVA_INT.withName("allocationsMoved"),
        ValueLayout.JAVA_INT.withName("deviceMemoryBlocksFreed")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$bytesMoved = PathElement.groupElement("bytesMoved");
    public static final PathElement PATH$bytesFreed = PathElement.groupElement("bytesFreed");
    public static final PathElement PATH$allocationsMoved = PathElement.groupElement("allocationsMoved");
    public static final PathElement PATH$deviceMemoryBlocksFreed = PathElement.groupElement("deviceMemoryBlocksFreed");

    public static final OfLong LAYOUT$bytesMoved = (OfLong) LAYOUT.select(PATH$bytesMoved);
    public static final OfLong LAYOUT$bytesFreed = (OfLong) LAYOUT.select(PATH$bytesFreed);
    public static final OfInt LAYOUT$allocationsMoved = (OfInt) LAYOUT.select(PATH$allocationsMoved);
    public static final OfInt LAYOUT$deviceMemoryBlocksFreed = (OfInt) LAYOUT.select(PATH$deviceMemoryBlocksFreed);

    public static final long SIZE$bytesMoved = LAYOUT$bytesMoved.byteSize();
    public static final long SIZE$bytesFreed = LAYOUT$bytesFreed.byteSize();
    public static final long SIZE$allocationsMoved = LAYOUT$allocationsMoved.byteSize();
    public static final long SIZE$deviceMemoryBlocksFreed = LAYOUT$deviceMemoryBlocksFreed.byteSize();

    public static final long OFFSET$bytesMoved = LAYOUT.byteOffset(PATH$bytesMoved);
    public static final long OFFSET$bytesFreed = LAYOUT.byteOffset(PATH$bytesFreed);
    public static final long OFFSET$allocationsMoved = LAYOUT.byteOffset(PATH$allocationsMoved);
    public static final long OFFSET$deviceMemoryBlocksFreed = LAYOUT.byteOffset(PATH$deviceMemoryBlocksFreed);
}
