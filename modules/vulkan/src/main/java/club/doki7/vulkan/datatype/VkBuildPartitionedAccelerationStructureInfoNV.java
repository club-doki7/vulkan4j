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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBuildPartitionedAccelerationStructureInfoNV.html"><code>VkBuildPartitionedAccelerationStructureInfoNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkBuildPartitionedAccelerationStructureInfoNV {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkPartitionedAccelerationStructureInstancesInputNV input; // @link substring="VkPartitionedAccelerationStructureInstancesInputNV" target="VkPartitionedAccelerationStructureInstancesInputNV" @link substring="input" target="#input"
///     VkDeviceAddress srcAccelerationStructureData; // @link substring="srcAccelerationStructureData" target="#srcAccelerationStructureData"
///     VkDeviceAddress dstAccelerationStructureData; // @link substring="dstAccelerationStructureData" target="#dstAccelerationStructureData"
///     VkDeviceAddress scratchData; // @link substring="scratchData" target="#scratchData"
///     VkDeviceAddress srcInfos; // @link substring="srcInfos" target="#srcInfos"
///     VkDeviceAddress srcInfosCount; // @link substring="srcInfosCount" target="#srcInfosCount"
/// } VkBuildPartitionedAccelerationStructureInfoNV;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_BUILD_PARTITIONED_ACCELERATION_STRUCTURE_INFO_NV`
/// - `input.autoInit()`
///
/// The {@code allocate} ({@link VkBuildPartitionedAccelerationStructureInfoNV#allocate(Arena)}, {@link VkBuildPartitionedAccelerationStructureInfoNV#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkBuildPartitionedAccelerationStructureInfoNV#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBuildPartitionedAccelerationStructureInfoNV.html"><code>VkBuildPartitionedAccelerationStructureInfoNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkBuildPartitionedAccelerationStructureInfoNV(@NotNull MemorySegment segment) implements IVkBuildPartitionedAccelerationStructureInfoNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBuildPartitionedAccelerationStructureInfoNV.html"><code>VkBuildPartitionedAccelerationStructureInfoNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkBuildPartitionedAccelerationStructureInfoNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkBuildPartitionedAccelerationStructureInfoNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkBuildPartitionedAccelerationStructureInfoNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkBuildPartitionedAccelerationStructureInfoNV, Iterable<VkBuildPartitionedAccelerationStructureInfoNV> {
        public long size() {
            return segment.byteSize() / VkBuildPartitionedAccelerationStructureInfoNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkBuildPartitionedAccelerationStructureInfoNV at(long index) {
            return new VkBuildPartitionedAccelerationStructureInfoNV(segment.asSlice(index * VkBuildPartitionedAccelerationStructureInfoNV.BYTES, VkBuildPartitionedAccelerationStructureInfoNV.BYTES));
        }

        public VkBuildPartitionedAccelerationStructureInfoNV.Ptr at(long index, @NotNull Consumer<@NotNull VkBuildPartitionedAccelerationStructureInfoNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkBuildPartitionedAccelerationStructureInfoNV value) {
            MemorySegment s = segment.asSlice(index * VkBuildPartitionedAccelerationStructureInfoNV.BYTES, VkBuildPartitionedAccelerationStructureInfoNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkBuildPartitionedAccelerationStructureInfoNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkBuildPartitionedAccelerationStructureInfoNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkBuildPartitionedAccelerationStructureInfoNV.BYTES,
                (end - start) * VkBuildPartitionedAccelerationStructureInfoNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkBuildPartitionedAccelerationStructureInfoNV.BYTES));
        }

        public VkBuildPartitionedAccelerationStructureInfoNV[] toArray() {
            VkBuildPartitionedAccelerationStructureInfoNV[] ret = new VkBuildPartitionedAccelerationStructureInfoNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkBuildPartitionedAccelerationStructureInfoNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkBuildPartitionedAccelerationStructureInfoNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkBuildPartitionedAccelerationStructureInfoNV.BYTES;
            }

            @Override
            public VkBuildPartitionedAccelerationStructureInfoNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkBuildPartitionedAccelerationStructureInfoNV ret = new VkBuildPartitionedAccelerationStructureInfoNV(segment.asSlice(0, VkBuildPartitionedAccelerationStructureInfoNV.BYTES));
                segment = segment.asSlice(VkBuildPartitionedAccelerationStructureInfoNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkBuildPartitionedAccelerationStructureInfoNV allocate(Arena arena) {
        VkBuildPartitionedAccelerationStructureInfoNV ret = new VkBuildPartitionedAccelerationStructureInfoNV(arena.allocate(LAYOUT));
        ret.autoInit();
        return ret;
    }

    public static VkBuildPartitionedAccelerationStructureInfoNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkBuildPartitionedAccelerationStructureInfoNV.Ptr ret = new VkBuildPartitionedAccelerationStructureInfoNV.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).autoInit();
        }
        return ret;
    }

    public static VkBuildPartitionedAccelerationStructureInfoNV clone(Arena arena, VkBuildPartitionedAccelerationStructureInfoNV src) {
        VkBuildPartitionedAccelerationStructureInfoNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.BUILD_PARTITIONED_ACCELERATION_STRUCTURE_INFO_NV);
        input().autoInit();
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkBuildPartitionedAccelerationStructureInfoNV sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkBuildPartitionedAccelerationStructureInfoNV pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkBuildPartitionedAccelerationStructureInfoNV pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NotNull VkPartitionedAccelerationStructureInstancesInputNV input() {
        return new VkPartitionedAccelerationStructureInstancesInputNV(segment.asSlice(OFFSET$input, LAYOUT$input));
    }

    public VkBuildPartitionedAccelerationStructureInfoNV input(@NotNull VkPartitionedAccelerationStructureInstancesInputNV value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$input, SIZE$input);
        return this;
    }

    public VkBuildPartitionedAccelerationStructureInfoNV input(Consumer<@NotNull VkPartitionedAccelerationStructureInstancesInputNV> consumer) {
        consumer.accept(input());
        return this;
    }

    public @NativeType("VkDeviceAddress") @Unsigned long srcAccelerationStructureData() {
        return segment.get(LAYOUT$srcAccelerationStructureData, OFFSET$srcAccelerationStructureData);
    }

    public VkBuildPartitionedAccelerationStructureInfoNV srcAccelerationStructureData(@NativeType("VkDeviceAddress") @Unsigned long value) {
        segment.set(LAYOUT$srcAccelerationStructureData, OFFSET$srcAccelerationStructureData, value);
        return this;
    }

    public @NativeType("VkDeviceAddress") @Unsigned long dstAccelerationStructureData() {
        return segment.get(LAYOUT$dstAccelerationStructureData, OFFSET$dstAccelerationStructureData);
    }

    public VkBuildPartitionedAccelerationStructureInfoNV dstAccelerationStructureData(@NativeType("VkDeviceAddress") @Unsigned long value) {
        segment.set(LAYOUT$dstAccelerationStructureData, OFFSET$dstAccelerationStructureData, value);
        return this;
    }

    public @NativeType("VkDeviceAddress") @Unsigned long scratchData() {
        return segment.get(LAYOUT$scratchData, OFFSET$scratchData);
    }

    public VkBuildPartitionedAccelerationStructureInfoNV scratchData(@NativeType("VkDeviceAddress") @Unsigned long value) {
        segment.set(LAYOUT$scratchData, OFFSET$scratchData, value);
        return this;
    }

    public @NativeType("VkDeviceAddress") @Unsigned long srcInfos() {
        return segment.get(LAYOUT$srcInfos, OFFSET$srcInfos);
    }

    public VkBuildPartitionedAccelerationStructureInfoNV srcInfos(@NativeType("VkDeviceAddress") @Unsigned long value) {
        segment.set(LAYOUT$srcInfos, OFFSET$srcInfos, value);
        return this;
    }

    public @NativeType("VkDeviceAddress") @Unsigned long srcInfosCount() {
        return segment.get(LAYOUT$srcInfosCount, OFFSET$srcInfosCount);
    }

    public VkBuildPartitionedAccelerationStructureInfoNV srcInfosCount(@NativeType("VkDeviceAddress") @Unsigned long value) {
        segment.set(LAYOUT$srcInfosCount, OFFSET$srcInfosCount, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        VkPartitionedAccelerationStructureInstancesInputNV.LAYOUT.withName("input"),
        ValueLayout.JAVA_LONG.withName("srcAccelerationStructureData"),
        ValueLayout.JAVA_LONG.withName("dstAccelerationStructureData"),
        ValueLayout.JAVA_LONG.withName("scratchData"),
        ValueLayout.JAVA_LONG.withName("srcInfos"),
        ValueLayout.JAVA_LONG.withName("srcInfosCount")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$input = PathElement.groupElement("input");
    public static final PathElement PATH$srcAccelerationStructureData = PathElement.groupElement("srcAccelerationStructureData");
    public static final PathElement PATH$dstAccelerationStructureData = PathElement.groupElement("dstAccelerationStructureData");
    public static final PathElement PATH$scratchData = PathElement.groupElement("scratchData");
    public static final PathElement PATH$srcInfos = PathElement.groupElement("srcInfos");
    public static final PathElement PATH$srcInfosCount = PathElement.groupElement("srcInfosCount");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final StructLayout LAYOUT$input = (StructLayout) LAYOUT.select(PATH$input);
    public static final OfLong LAYOUT$srcAccelerationStructureData = (OfLong) LAYOUT.select(PATH$srcAccelerationStructureData);
    public static final OfLong LAYOUT$dstAccelerationStructureData = (OfLong) LAYOUT.select(PATH$dstAccelerationStructureData);
    public static final OfLong LAYOUT$scratchData = (OfLong) LAYOUT.select(PATH$scratchData);
    public static final OfLong LAYOUT$srcInfos = (OfLong) LAYOUT.select(PATH$srcInfos);
    public static final OfLong LAYOUT$srcInfosCount = (OfLong) LAYOUT.select(PATH$srcInfosCount);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$input = LAYOUT$input.byteSize();
    public static final long SIZE$srcAccelerationStructureData = LAYOUT$srcAccelerationStructureData.byteSize();
    public static final long SIZE$dstAccelerationStructureData = LAYOUT$dstAccelerationStructureData.byteSize();
    public static final long SIZE$scratchData = LAYOUT$scratchData.byteSize();
    public static final long SIZE$srcInfos = LAYOUT$srcInfos.byteSize();
    public static final long SIZE$srcInfosCount = LAYOUT$srcInfosCount.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$input = LAYOUT.byteOffset(PATH$input);
    public static final long OFFSET$srcAccelerationStructureData = LAYOUT.byteOffset(PATH$srcAccelerationStructureData);
    public static final long OFFSET$dstAccelerationStructureData = LAYOUT.byteOffset(PATH$dstAccelerationStructureData);
    public static final long OFFSET$scratchData = LAYOUT.byteOffset(PATH$scratchData);
    public static final long OFFSET$srcInfos = LAYOUT.byteOffset(PATH$srcInfos);
    public static final long OFFSET$srcInfosCount = LAYOUT.byteOffset(PATH$srcInfosCount);
}
