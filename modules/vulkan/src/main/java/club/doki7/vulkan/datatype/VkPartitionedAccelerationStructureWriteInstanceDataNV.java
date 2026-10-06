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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPartitionedAccelerationStructureWriteInstanceDataNV.html"><code>VkPartitionedAccelerationStructureWriteInstanceDataNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPartitionedAccelerationStructureWriteInstanceDataNV {
///     VkTransformMatrixKHR transform; // @link substring="VkTransformMatrixKHR" target="VkTransformMatrixKHR" @link substring="transform" target="#transform"
///     float[6] explicitAABB; // @link substring="explicitAABB" target="#explicitAABB"
///     uint32_t instanceID; // @link substring="instanceID" target="#instanceID"
///     uint32_t instanceMask; // @link substring="instanceMask" target="#instanceMask"
///     uint32_t instanceContributionToHitGroupIndex; // @link substring="instanceContributionToHitGroupIndex" target="#instanceContributionToHitGroupIndex"
///     VkPartitionedAccelerationStructureInstanceFlagsNV instanceFlags; // optional // @link substring="VkPartitionedAccelerationStructureInstanceFlagsNV" target="VkPartitionedAccelerationStructureInstanceFlagsNV" @link substring="instanceFlags" target="#instanceFlags"
///     uint32_t instanceIndex; // @link substring="instanceIndex" target="#instanceIndex"
///     uint32_t partitionIndex; // @link substring="partitionIndex" target="#partitionIndex"
///     VkDeviceAddress accelerationStructure; // @link substring="accelerationStructure" target="#accelerationStructure"
/// } VkPartitionedAccelerationStructureWriteInstanceDataNV;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPartitionedAccelerationStructureWriteInstanceDataNV.html"><code>VkPartitionedAccelerationStructureWriteInstanceDataNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPartitionedAccelerationStructureWriteInstanceDataNV(@NotNull MemorySegment segment) implements IVkPartitionedAccelerationStructureWriteInstanceDataNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPartitionedAccelerationStructureWriteInstanceDataNV.html"><code>VkPartitionedAccelerationStructureWriteInstanceDataNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPartitionedAccelerationStructureWriteInstanceDataNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPartitionedAccelerationStructureWriteInstanceDataNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPartitionedAccelerationStructureWriteInstanceDataNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPartitionedAccelerationStructureWriteInstanceDataNV, Iterable<VkPartitionedAccelerationStructureWriteInstanceDataNV> {
        public long size() {
            return segment.byteSize() / VkPartitionedAccelerationStructureWriteInstanceDataNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPartitionedAccelerationStructureWriteInstanceDataNV at(long index) {
            return new VkPartitionedAccelerationStructureWriteInstanceDataNV(segment.asSlice(index * VkPartitionedAccelerationStructureWriteInstanceDataNV.BYTES, VkPartitionedAccelerationStructureWriteInstanceDataNV.BYTES));
        }

        public VkPartitionedAccelerationStructureWriteInstanceDataNV.Ptr at(long index, @NotNull Consumer<@NotNull VkPartitionedAccelerationStructureWriteInstanceDataNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPartitionedAccelerationStructureWriteInstanceDataNV value) {
            MemorySegment s = segment.asSlice(index * VkPartitionedAccelerationStructureWriteInstanceDataNV.BYTES, VkPartitionedAccelerationStructureWriteInstanceDataNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPartitionedAccelerationStructureWriteInstanceDataNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPartitionedAccelerationStructureWriteInstanceDataNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPartitionedAccelerationStructureWriteInstanceDataNV.BYTES,
                (end - start) * VkPartitionedAccelerationStructureWriteInstanceDataNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPartitionedAccelerationStructureWriteInstanceDataNV.BYTES));
        }

        public VkPartitionedAccelerationStructureWriteInstanceDataNV[] toArray() {
            VkPartitionedAccelerationStructureWriteInstanceDataNV[] ret = new VkPartitionedAccelerationStructureWriteInstanceDataNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPartitionedAccelerationStructureWriteInstanceDataNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPartitionedAccelerationStructureWriteInstanceDataNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPartitionedAccelerationStructureWriteInstanceDataNV.BYTES;
            }

            @Override
            public VkPartitionedAccelerationStructureWriteInstanceDataNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPartitionedAccelerationStructureWriteInstanceDataNV ret = new VkPartitionedAccelerationStructureWriteInstanceDataNV(segment.asSlice(0, VkPartitionedAccelerationStructureWriteInstanceDataNV.BYTES));
                segment = segment.asSlice(VkPartitionedAccelerationStructureWriteInstanceDataNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPartitionedAccelerationStructureWriteInstanceDataNV allocate(Arena arena) {
        return new VkPartitionedAccelerationStructureWriteInstanceDataNV(arena.allocate(LAYOUT));
    }

    public static VkPartitionedAccelerationStructureWriteInstanceDataNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkPartitionedAccelerationStructureWriteInstanceDataNV.Ptr(segment);
    }

    public static VkPartitionedAccelerationStructureWriteInstanceDataNV clone(Arena arena, VkPartitionedAccelerationStructureWriteInstanceDataNV src) {
        VkPartitionedAccelerationStructureWriteInstanceDataNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull VkTransformMatrixKHR transform() {
        return new VkTransformMatrixKHR(segment.asSlice(OFFSET$transform, LAYOUT$transform));
    }

    public VkPartitionedAccelerationStructureWriteInstanceDataNV transform(@NotNull VkTransformMatrixKHR value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$transform, SIZE$transform);
        return this;
    }

    public VkPartitionedAccelerationStructureWriteInstanceDataNV transform(Consumer<@NotNull VkTransformMatrixKHR> consumer) {
        consumer.accept(transform());
        return this;
    }

    public FloatPtr explicitAABB() {
        return new FloatPtr(explicitAABBRaw());
    }

    public VkPartitionedAccelerationStructureWriteInstanceDataNV explicitAABB(@NotNull Consumer<FloatPtr> consumer) {
        FloatPtr ptr = explicitAABB();
        consumer.accept(ptr);
        return this;
    }

    public VkPartitionedAccelerationStructureWriteInstanceDataNV explicitAABB(FloatPtr value) {
        MemorySegment s = explicitAABBRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment explicitAABBRaw() {
        return segment.asSlice(OFFSET$explicitAABB, SIZE$explicitAABB);
    }

    public @Unsigned int instanceID() {
        return segment.get(LAYOUT$instanceID, OFFSET$instanceID);
    }

    public VkPartitionedAccelerationStructureWriteInstanceDataNV instanceID(@Unsigned int value) {
        segment.set(LAYOUT$instanceID, OFFSET$instanceID, value);
        return this;
    }

    public @Unsigned int instanceMask() {
        return segment.get(LAYOUT$instanceMask, OFFSET$instanceMask);
    }

    public VkPartitionedAccelerationStructureWriteInstanceDataNV instanceMask(@Unsigned int value) {
        segment.set(LAYOUT$instanceMask, OFFSET$instanceMask, value);
        return this;
    }

    public @Unsigned int instanceContributionToHitGroupIndex() {
        return segment.get(LAYOUT$instanceContributionToHitGroupIndex, OFFSET$instanceContributionToHitGroupIndex);
    }

    public VkPartitionedAccelerationStructureWriteInstanceDataNV instanceContributionToHitGroupIndex(@Unsigned int value) {
        segment.set(LAYOUT$instanceContributionToHitGroupIndex, OFFSET$instanceContributionToHitGroupIndex, value);
        return this;
    }

    public @Bitmask(VkPartitionedAccelerationStructureInstanceFlagsNV.class) int instanceFlags() {
        return segment.get(LAYOUT$instanceFlags, OFFSET$instanceFlags);
    }

    public VkPartitionedAccelerationStructureWriteInstanceDataNV instanceFlags(@Bitmask(VkPartitionedAccelerationStructureInstanceFlagsNV.class) int value) {
        segment.set(LAYOUT$instanceFlags, OFFSET$instanceFlags, value);
        return this;
    }

    public @Unsigned int instanceIndex() {
        return segment.get(LAYOUT$instanceIndex, OFFSET$instanceIndex);
    }

    public VkPartitionedAccelerationStructureWriteInstanceDataNV instanceIndex(@Unsigned int value) {
        segment.set(LAYOUT$instanceIndex, OFFSET$instanceIndex, value);
        return this;
    }

    public @Unsigned int partitionIndex() {
        return segment.get(LAYOUT$partitionIndex, OFFSET$partitionIndex);
    }

    public VkPartitionedAccelerationStructureWriteInstanceDataNV partitionIndex(@Unsigned int value) {
        segment.set(LAYOUT$partitionIndex, OFFSET$partitionIndex, value);
        return this;
    }

    public @NativeType("VkDeviceAddress") @Unsigned long accelerationStructure() {
        return segment.get(LAYOUT$accelerationStructure, OFFSET$accelerationStructure);
    }

    public VkPartitionedAccelerationStructureWriteInstanceDataNV accelerationStructure(@NativeType("VkDeviceAddress") @Unsigned long value) {
        segment.set(LAYOUT$accelerationStructure, OFFSET$accelerationStructure, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        VkTransformMatrixKHR.LAYOUT.withName("transform"),
        MemoryLayout.sequenceLayout(6, ValueLayout.JAVA_FLOAT).withName("explicitAABB"),
        ValueLayout.JAVA_INT.withName("instanceID"),
        ValueLayout.JAVA_INT.withName("instanceMask"),
        ValueLayout.JAVA_INT.withName("instanceContributionToHitGroupIndex"),
        ValueLayout.JAVA_INT.withName("instanceFlags"),
        ValueLayout.JAVA_INT.withName("instanceIndex"),
        ValueLayout.JAVA_INT.withName("partitionIndex"),
        ValueLayout.JAVA_LONG.withName("accelerationStructure")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$transform = PathElement.groupElement("transform");
    public static final PathElement PATH$explicitAABB = PathElement.groupElement("explicitAABB");
    public static final PathElement PATH$instanceID = PathElement.groupElement("instanceID");
    public static final PathElement PATH$instanceMask = PathElement.groupElement("instanceMask");
    public static final PathElement PATH$instanceContributionToHitGroupIndex = PathElement.groupElement("instanceContributionToHitGroupIndex");
    public static final PathElement PATH$instanceFlags = PathElement.groupElement("instanceFlags");
    public static final PathElement PATH$instanceIndex = PathElement.groupElement("instanceIndex");
    public static final PathElement PATH$partitionIndex = PathElement.groupElement("partitionIndex");
    public static final PathElement PATH$accelerationStructure = PathElement.groupElement("accelerationStructure");

    public static final StructLayout LAYOUT$transform = (StructLayout) LAYOUT.select(PATH$transform);
    public static final SequenceLayout LAYOUT$explicitAABB = (SequenceLayout) LAYOUT.select(PATH$explicitAABB);
    public static final OfInt LAYOUT$instanceID = (OfInt) LAYOUT.select(PATH$instanceID);
    public static final OfInt LAYOUT$instanceMask = (OfInt) LAYOUT.select(PATH$instanceMask);
    public static final OfInt LAYOUT$instanceContributionToHitGroupIndex = (OfInt) LAYOUT.select(PATH$instanceContributionToHitGroupIndex);
    public static final OfInt LAYOUT$instanceFlags = (OfInt) LAYOUT.select(PATH$instanceFlags);
    public static final OfInt LAYOUT$instanceIndex = (OfInt) LAYOUT.select(PATH$instanceIndex);
    public static final OfInt LAYOUT$partitionIndex = (OfInt) LAYOUT.select(PATH$partitionIndex);
    public static final OfLong LAYOUT$accelerationStructure = (OfLong) LAYOUT.select(PATH$accelerationStructure);

    public static final long SIZE$transform = LAYOUT$transform.byteSize();
    public static final long SIZE$explicitAABB = LAYOUT$explicitAABB.byteSize();
    public static final long SIZE$instanceID = LAYOUT$instanceID.byteSize();
    public static final long SIZE$instanceMask = LAYOUT$instanceMask.byteSize();
    public static final long SIZE$instanceContributionToHitGroupIndex = LAYOUT$instanceContributionToHitGroupIndex.byteSize();
    public static final long SIZE$instanceFlags = LAYOUT$instanceFlags.byteSize();
    public static final long SIZE$instanceIndex = LAYOUT$instanceIndex.byteSize();
    public static final long SIZE$partitionIndex = LAYOUT$partitionIndex.byteSize();
    public static final long SIZE$accelerationStructure = LAYOUT$accelerationStructure.byteSize();

    public static final long OFFSET$transform = LAYOUT.byteOffset(PATH$transform);
    public static final long OFFSET$explicitAABB = LAYOUT.byteOffset(PATH$explicitAABB);
    public static final long OFFSET$instanceID = LAYOUT.byteOffset(PATH$instanceID);
    public static final long OFFSET$instanceMask = LAYOUT.byteOffset(PATH$instanceMask);
    public static final long OFFSET$instanceContributionToHitGroupIndex = LAYOUT.byteOffset(PATH$instanceContributionToHitGroupIndex);
    public static final long OFFSET$instanceFlags = LAYOUT.byteOffset(PATH$instanceFlags);
    public static final long OFFSET$instanceIndex = LAYOUT.byteOffset(PATH$instanceIndex);
    public static final long OFFSET$partitionIndex = LAYOUT.byteOffset(PATH$partitionIndex);
    public static final long OFFSET$accelerationStructure = LAYOUT.byteOffset(PATH$accelerationStructure);
}
