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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPartitionedAccelerationStructureWritePartitionTranslationDataNV.html"><code>VkPartitionedAccelerationStructureWritePartitionTranslationDataNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPartitionedAccelerationStructureWritePartitionTranslationDataNV {
///     uint32_t partitionIndex; // @link substring="partitionIndex" target="#partitionIndex"
///     float[3] partitionTranslation; // @link substring="partitionTranslation" target="#partitionTranslation"
/// } VkPartitionedAccelerationStructureWritePartitionTranslationDataNV;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPartitionedAccelerationStructureWritePartitionTranslationDataNV.html"><code>VkPartitionedAccelerationStructureWritePartitionTranslationDataNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPartitionedAccelerationStructureWritePartitionTranslationDataNV(@NotNull MemorySegment segment) implements IVkPartitionedAccelerationStructureWritePartitionTranslationDataNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPartitionedAccelerationStructureWritePartitionTranslationDataNV.html"><code>VkPartitionedAccelerationStructureWritePartitionTranslationDataNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPartitionedAccelerationStructureWritePartitionTranslationDataNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPartitionedAccelerationStructureWritePartitionTranslationDataNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPartitionedAccelerationStructureWritePartitionTranslationDataNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPartitionedAccelerationStructureWritePartitionTranslationDataNV, Iterable<VkPartitionedAccelerationStructureWritePartitionTranslationDataNV> {
        public long size() {
            return segment.byteSize() / VkPartitionedAccelerationStructureWritePartitionTranslationDataNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPartitionedAccelerationStructureWritePartitionTranslationDataNV at(long index) {
            return new VkPartitionedAccelerationStructureWritePartitionTranslationDataNV(segment.asSlice(index * VkPartitionedAccelerationStructureWritePartitionTranslationDataNV.BYTES, VkPartitionedAccelerationStructureWritePartitionTranslationDataNV.BYTES));
        }

        public VkPartitionedAccelerationStructureWritePartitionTranslationDataNV.Ptr at(long index, @NotNull Consumer<@NotNull VkPartitionedAccelerationStructureWritePartitionTranslationDataNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPartitionedAccelerationStructureWritePartitionTranslationDataNV value) {
            MemorySegment s = segment.asSlice(index * VkPartitionedAccelerationStructureWritePartitionTranslationDataNV.BYTES, VkPartitionedAccelerationStructureWritePartitionTranslationDataNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPartitionedAccelerationStructureWritePartitionTranslationDataNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPartitionedAccelerationStructureWritePartitionTranslationDataNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPartitionedAccelerationStructureWritePartitionTranslationDataNV.BYTES,
                (end - start) * VkPartitionedAccelerationStructureWritePartitionTranslationDataNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPartitionedAccelerationStructureWritePartitionTranslationDataNV.BYTES));
        }

        public VkPartitionedAccelerationStructureWritePartitionTranslationDataNV[] toArray() {
            VkPartitionedAccelerationStructureWritePartitionTranslationDataNV[] ret = new VkPartitionedAccelerationStructureWritePartitionTranslationDataNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPartitionedAccelerationStructureWritePartitionTranslationDataNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPartitionedAccelerationStructureWritePartitionTranslationDataNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPartitionedAccelerationStructureWritePartitionTranslationDataNV.BYTES;
            }

            @Override
            public VkPartitionedAccelerationStructureWritePartitionTranslationDataNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPartitionedAccelerationStructureWritePartitionTranslationDataNV ret = new VkPartitionedAccelerationStructureWritePartitionTranslationDataNV(segment.asSlice(0, VkPartitionedAccelerationStructureWritePartitionTranslationDataNV.BYTES));
                segment = segment.asSlice(VkPartitionedAccelerationStructureWritePartitionTranslationDataNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPartitionedAccelerationStructureWritePartitionTranslationDataNV allocate(Arena arena) {
        return new VkPartitionedAccelerationStructureWritePartitionTranslationDataNV(arena.allocate(LAYOUT));
    }

    public static VkPartitionedAccelerationStructureWritePartitionTranslationDataNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkPartitionedAccelerationStructureWritePartitionTranslationDataNV.Ptr(segment);
    }

    public static VkPartitionedAccelerationStructureWritePartitionTranslationDataNV clone(Arena arena, VkPartitionedAccelerationStructureWritePartitionTranslationDataNV src) {
        VkPartitionedAccelerationStructureWritePartitionTranslationDataNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned int partitionIndex() {
        return segment.get(LAYOUT$partitionIndex, OFFSET$partitionIndex);
    }

    public VkPartitionedAccelerationStructureWritePartitionTranslationDataNV partitionIndex(@Unsigned int value) {
        segment.set(LAYOUT$partitionIndex, OFFSET$partitionIndex, value);
        return this;
    }

    public FloatPtr partitionTranslation() {
        return new FloatPtr(partitionTranslationRaw());
    }

    public VkPartitionedAccelerationStructureWritePartitionTranslationDataNV partitionTranslation(@NotNull Consumer<FloatPtr> consumer) {
        FloatPtr ptr = partitionTranslation();
        consumer.accept(ptr);
        return this;
    }

    public VkPartitionedAccelerationStructureWritePartitionTranslationDataNV partitionTranslation(FloatPtr value) {
        MemorySegment s = partitionTranslationRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment partitionTranslationRaw() {
        return segment.asSlice(OFFSET$partitionTranslation, SIZE$partitionTranslation);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("partitionIndex"),
        MemoryLayout.sequenceLayout(3, ValueLayout.JAVA_FLOAT).withName("partitionTranslation")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$partitionIndex = PathElement.groupElement("partitionIndex");
    public static final PathElement PATH$partitionTranslation = PathElement.groupElement("partitionTranslation");

    public static final OfInt LAYOUT$partitionIndex = (OfInt) LAYOUT.select(PATH$partitionIndex);
    public static final SequenceLayout LAYOUT$partitionTranslation = (SequenceLayout) LAYOUT.select(PATH$partitionTranslation);

    public static final long SIZE$partitionIndex = LAYOUT$partitionIndex.byteSize();
    public static final long SIZE$partitionTranslation = LAYOUT$partitionTranslation.byteSize();

    public static final long OFFSET$partitionIndex = LAYOUT.byteOffset(PATH$partitionIndex);
    public static final long OFFSET$partitionTranslation = LAYOUT.byteOffset(PATH$partitionTranslation);
}
