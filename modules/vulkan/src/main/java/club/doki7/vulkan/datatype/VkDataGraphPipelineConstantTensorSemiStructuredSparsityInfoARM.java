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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM.html"><code>VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t dimension; // @link substring="dimension" target="#dimension"
///     uint32_t zeroCount; // @link substring="zeroCount" target="#zeroCount"
///     uint32_t groupSize; // @link substring="groupSize" target="#groupSize"
/// } VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_DATA_GRAPH_PIPELINE_CONSTANT_TENSOR_SEMI_STRUCTURED_SPARSITY_INFO_ARM`
///
/// The {@code allocate} ({@link VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM#allocate(Arena)}, {@link VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM.html"><code>VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM(@NotNull MemorySegment segment) implements IVkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM.html"><code>VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM, Iterable<VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM> {
        public long size() {
            return segment.byteSize() / VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM at(long index) {
            return new VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM(segment.asSlice(index * VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM.BYTES, VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM.BYTES));
        }

        public VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM.Ptr at(long index, @NotNull Consumer<@NotNull VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM value) {
            MemorySegment s = segment.asSlice(index * VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM.BYTES, VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM.BYTES,
                (end - start) * VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM.BYTES));
        }

        public VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM[] toArray() {
            VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM[] ret = new VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM.BYTES;
            }

            @Override
            public VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM ret = new VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM(segment.asSlice(0, VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM.BYTES));
                segment = segment.asSlice(VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM allocate(Arena arena) {
        VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM ret = new VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.DATA_GRAPH_PIPELINE_CONSTANT_TENSOR_SEMI_STRUCTURED_SPARSITY_INFO_ARM);
        return ret;
    }

    public static VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM.Ptr ret = new VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.DATA_GRAPH_PIPELINE_CONSTANT_TENSOR_SEMI_STRUCTURED_SPARSITY_INFO_ARM);
        }
        return ret;
    }

    public static VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM clone(Arena arena, VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM src) {
        VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.DATA_GRAPH_PIPELINE_CONSTANT_TENSOR_SEMI_STRUCTURED_SPARSITY_INFO_ARM);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int dimension() {
        return segment.get(LAYOUT$dimension, OFFSET$dimension);
    }

    public VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM dimension(@Unsigned int value) {
        segment.set(LAYOUT$dimension, OFFSET$dimension, value);
        return this;
    }

    public @Unsigned int zeroCount() {
        return segment.get(LAYOUT$zeroCount, OFFSET$zeroCount);
    }

    public VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM zeroCount(@Unsigned int value) {
        segment.set(LAYOUT$zeroCount, OFFSET$zeroCount, value);
        return this;
    }

    public @Unsigned int groupSize() {
        return segment.get(LAYOUT$groupSize, OFFSET$groupSize);
    }

    public VkDataGraphPipelineConstantTensorSemiStructuredSparsityInfoARM groupSize(@Unsigned int value) {
        segment.set(LAYOUT$groupSize, OFFSET$groupSize, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("dimension"),
        ValueLayout.JAVA_INT.withName("zeroCount"),
        ValueLayout.JAVA_INT.withName("groupSize")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$dimension = PathElement.groupElement("dimension");
    public static final PathElement PATH$zeroCount = PathElement.groupElement("zeroCount");
    public static final PathElement PATH$groupSize = PathElement.groupElement("groupSize");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$dimension = (OfInt) LAYOUT.select(PATH$dimension);
    public static final OfInt LAYOUT$zeroCount = (OfInt) LAYOUT.select(PATH$zeroCount);
    public static final OfInt LAYOUT$groupSize = (OfInt) LAYOUT.select(PATH$groupSize);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$dimension = LAYOUT$dimension.byteSize();
    public static final long SIZE$zeroCount = LAYOUT$zeroCount.byteSize();
    public static final long SIZE$groupSize = LAYOUT$groupSize.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$dimension = LAYOUT.byteOffset(PATH$dimension);
    public static final long OFFSET$zeroCount = LAYOUT.byteOffset(PATH$zeroCount);
    public static final long OFFSET$groupSize = LAYOUT.byteOffset(PATH$groupSize);
}
