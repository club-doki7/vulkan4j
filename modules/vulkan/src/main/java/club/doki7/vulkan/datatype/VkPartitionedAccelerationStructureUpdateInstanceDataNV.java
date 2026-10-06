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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPartitionedAccelerationStructureUpdateInstanceDataNV.html"><code>VkPartitionedAccelerationStructureUpdateInstanceDataNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPartitionedAccelerationStructureUpdateInstanceDataNV {
///     uint32_t instanceIndex; // @link substring="instanceIndex" target="#instanceIndex"
///     uint32_t instanceContributionToHitGroupIndex; // @link substring="instanceContributionToHitGroupIndex" target="#instanceContributionToHitGroupIndex"
///     VkDeviceAddress accelerationStructure; // @link substring="accelerationStructure" target="#accelerationStructure"
/// } VkPartitionedAccelerationStructureUpdateInstanceDataNV;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPartitionedAccelerationStructureUpdateInstanceDataNV.html"><code>VkPartitionedAccelerationStructureUpdateInstanceDataNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPartitionedAccelerationStructureUpdateInstanceDataNV(@NotNull MemorySegment segment) implements IVkPartitionedAccelerationStructureUpdateInstanceDataNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPartitionedAccelerationStructureUpdateInstanceDataNV.html"><code>VkPartitionedAccelerationStructureUpdateInstanceDataNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPartitionedAccelerationStructureUpdateInstanceDataNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPartitionedAccelerationStructureUpdateInstanceDataNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPartitionedAccelerationStructureUpdateInstanceDataNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPartitionedAccelerationStructureUpdateInstanceDataNV, Iterable<VkPartitionedAccelerationStructureUpdateInstanceDataNV> {
        public long size() {
            return segment.byteSize() / VkPartitionedAccelerationStructureUpdateInstanceDataNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPartitionedAccelerationStructureUpdateInstanceDataNV at(long index) {
            return new VkPartitionedAccelerationStructureUpdateInstanceDataNV(segment.asSlice(index * VkPartitionedAccelerationStructureUpdateInstanceDataNV.BYTES, VkPartitionedAccelerationStructureUpdateInstanceDataNV.BYTES));
        }

        public VkPartitionedAccelerationStructureUpdateInstanceDataNV.Ptr at(long index, @NotNull Consumer<@NotNull VkPartitionedAccelerationStructureUpdateInstanceDataNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPartitionedAccelerationStructureUpdateInstanceDataNV value) {
            MemorySegment s = segment.asSlice(index * VkPartitionedAccelerationStructureUpdateInstanceDataNV.BYTES, VkPartitionedAccelerationStructureUpdateInstanceDataNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPartitionedAccelerationStructureUpdateInstanceDataNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPartitionedAccelerationStructureUpdateInstanceDataNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPartitionedAccelerationStructureUpdateInstanceDataNV.BYTES,
                (end - start) * VkPartitionedAccelerationStructureUpdateInstanceDataNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPartitionedAccelerationStructureUpdateInstanceDataNV.BYTES));
        }

        public VkPartitionedAccelerationStructureUpdateInstanceDataNV[] toArray() {
            VkPartitionedAccelerationStructureUpdateInstanceDataNV[] ret = new VkPartitionedAccelerationStructureUpdateInstanceDataNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPartitionedAccelerationStructureUpdateInstanceDataNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPartitionedAccelerationStructureUpdateInstanceDataNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPartitionedAccelerationStructureUpdateInstanceDataNV.BYTES;
            }

            @Override
            public VkPartitionedAccelerationStructureUpdateInstanceDataNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPartitionedAccelerationStructureUpdateInstanceDataNV ret = new VkPartitionedAccelerationStructureUpdateInstanceDataNV(segment.asSlice(0, VkPartitionedAccelerationStructureUpdateInstanceDataNV.BYTES));
                segment = segment.asSlice(VkPartitionedAccelerationStructureUpdateInstanceDataNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPartitionedAccelerationStructureUpdateInstanceDataNV allocate(Arena arena) {
        return new VkPartitionedAccelerationStructureUpdateInstanceDataNV(arena.allocate(LAYOUT));
    }

    public static VkPartitionedAccelerationStructureUpdateInstanceDataNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkPartitionedAccelerationStructureUpdateInstanceDataNV.Ptr(segment);
    }

    public static VkPartitionedAccelerationStructureUpdateInstanceDataNV clone(Arena arena, VkPartitionedAccelerationStructureUpdateInstanceDataNV src) {
        VkPartitionedAccelerationStructureUpdateInstanceDataNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned int instanceIndex() {
        return segment.get(LAYOUT$instanceIndex, OFFSET$instanceIndex);
    }

    public VkPartitionedAccelerationStructureUpdateInstanceDataNV instanceIndex(@Unsigned int value) {
        segment.set(LAYOUT$instanceIndex, OFFSET$instanceIndex, value);
        return this;
    }

    public @Unsigned int instanceContributionToHitGroupIndex() {
        return segment.get(LAYOUT$instanceContributionToHitGroupIndex, OFFSET$instanceContributionToHitGroupIndex);
    }

    public VkPartitionedAccelerationStructureUpdateInstanceDataNV instanceContributionToHitGroupIndex(@Unsigned int value) {
        segment.set(LAYOUT$instanceContributionToHitGroupIndex, OFFSET$instanceContributionToHitGroupIndex, value);
        return this;
    }

    public @NativeType("VkDeviceAddress") @Unsigned long accelerationStructure() {
        return segment.get(LAYOUT$accelerationStructure, OFFSET$accelerationStructure);
    }

    public VkPartitionedAccelerationStructureUpdateInstanceDataNV accelerationStructure(@NativeType("VkDeviceAddress") @Unsigned long value) {
        segment.set(LAYOUT$accelerationStructure, OFFSET$accelerationStructure, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("instanceIndex"),
        ValueLayout.JAVA_INT.withName("instanceContributionToHitGroupIndex"),
        ValueLayout.JAVA_LONG.withName("accelerationStructure")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$instanceIndex = PathElement.groupElement("instanceIndex");
    public static final PathElement PATH$instanceContributionToHitGroupIndex = PathElement.groupElement("instanceContributionToHitGroupIndex");
    public static final PathElement PATH$accelerationStructure = PathElement.groupElement("accelerationStructure");

    public static final OfInt LAYOUT$instanceIndex = (OfInt) LAYOUT.select(PATH$instanceIndex);
    public static final OfInt LAYOUT$instanceContributionToHitGroupIndex = (OfInt) LAYOUT.select(PATH$instanceContributionToHitGroupIndex);
    public static final OfLong LAYOUT$accelerationStructure = (OfLong) LAYOUT.select(PATH$accelerationStructure);

    public static final long SIZE$instanceIndex = LAYOUT$instanceIndex.byteSize();
    public static final long SIZE$instanceContributionToHitGroupIndex = LAYOUT$instanceContributionToHitGroupIndex.byteSize();
    public static final long SIZE$accelerationStructure = LAYOUT$accelerationStructure.byteSize();

    public static final long OFFSET$instanceIndex = LAYOUT.byteOffset(PATH$instanceIndex);
    public static final long OFFSET$instanceContributionToHitGroupIndex = LAYOUT.byteOffset(PATH$instanceContributionToHitGroupIndex);
    public static final long OFFSET$accelerationStructure = LAYOUT.byteOffset(PATH$accelerationStructure);
}
