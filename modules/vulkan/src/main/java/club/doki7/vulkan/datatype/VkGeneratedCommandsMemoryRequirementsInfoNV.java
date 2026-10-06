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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGeneratedCommandsMemoryRequirementsInfoNV.html"><code>VkGeneratedCommandsMemoryRequirementsInfoNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkGeneratedCommandsMemoryRequirementsInfoNV {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkPipelineBindPoint pipelineBindPoint; // @link substring="VkPipelineBindPoint" target="VkPipelineBindPoint" @link substring="pipelineBindPoint" target="#pipelineBindPoint"
///     VkPipeline pipeline; // optional // @link substring="VkPipeline" target="VkPipeline" @link substring="pipeline" target="#pipeline"
///     VkIndirectCommandsLayoutNV indirectCommandsLayout; // @link substring="VkIndirectCommandsLayoutNV" target="VkIndirectCommandsLayoutNV" @link substring="indirectCommandsLayout" target="#indirectCommandsLayout"
///     uint32_t maxSequencesCount; // @link substring="maxSequencesCount" target="#maxSequencesCount"
/// } VkGeneratedCommandsMemoryRequirementsInfoNV;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_GENERATED_COMMANDS_MEMORY_REQUIREMENTS_INFO_NV`
///
/// The {@code allocate} ({@link VkGeneratedCommandsMemoryRequirementsInfoNV#allocate(Arena)}, {@link VkGeneratedCommandsMemoryRequirementsInfoNV#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkGeneratedCommandsMemoryRequirementsInfoNV#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGeneratedCommandsMemoryRequirementsInfoNV.html"><code>VkGeneratedCommandsMemoryRequirementsInfoNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkGeneratedCommandsMemoryRequirementsInfoNV(@NotNull MemorySegment segment) implements IVkGeneratedCommandsMemoryRequirementsInfoNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGeneratedCommandsMemoryRequirementsInfoNV.html"><code>VkGeneratedCommandsMemoryRequirementsInfoNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkGeneratedCommandsMemoryRequirementsInfoNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkGeneratedCommandsMemoryRequirementsInfoNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkGeneratedCommandsMemoryRequirementsInfoNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkGeneratedCommandsMemoryRequirementsInfoNV, Iterable<VkGeneratedCommandsMemoryRequirementsInfoNV> {
        public long size() {
            return segment.byteSize() / VkGeneratedCommandsMemoryRequirementsInfoNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkGeneratedCommandsMemoryRequirementsInfoNV at(long index) {
            return new VkGeneratedCommandsMemoryRequirementsInfoNV(segment.asSlice(index * VkGeneratedCommandsMemoryRequirementsInfoNV.BYTES, VkGeneratedCommandsMemoryRequirementsInfoNV.BYTES));
        }

        public VkGeneratedCommandsMemoryRequirementsInfoNV.Ptr at(long index, @NotNull Consumer<@NotNull VkGeneratedCommandsMemoryRequirementsInfoNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkGeneratedCommandsMemoryRequirementsInfoNV value) {
            MemorySegment s = segment.asSlice(index * VkGeneratedCommandsMemoryRequirementsInfoNV.BYTES, VkGeneratedCommandsMemoryRequirementsInfoNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkGeneratedCommandsMemoryRequirementsInfoNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkGeneratedCommandsMemoryRequirementsInfoNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkGeneratedCommandsMemoryRequirementsInfoNV.BYTES,
                (end - start) * VkGeneratedCommandsMemoryRequirementsInfoNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkGeneratedCommandsMemoryRequirementsInfoNV.BYTES));
        }

        public VkGeneratedCommandsMemoryRequirementsInfoNV[] toArray() {
            VkGeneratedCommandsMemoryRequirementsInfoNV[] ret = new VkGeneratedCommandsMemoryRequirementsInfoNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkGeneratedCommandsMemoryRequirementsInfoNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkGeneratedCommandsMemoryRequirementsInfoNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkGeneratedCommandsMemoryRequirementsInfoNV.BYTES;
            }

            @Override
            public VkGeneratedCommandsMemoryRequirementsInfoNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkGeneratedCommandsMemoryRequirementsInfoNV ret = new VkGeneratedCommandsMemoryRequirementsInfoNV(segment.asSlice(0, VkGeneratedCommandsMemoryRequirementsInfoNV.BYTES));
                segment = segment.asSlice(VkGeneratedCommandsMemoryRequirementsInfoNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkGeneratedCommandsMemoryRequirementsInfoNV allocate(Arena arena) {
        VkGeneratedCommandsMemoryRequirementsInfoNV ret = new VkGeneratedCommandsMemoryRequirementsInfoNV(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.GENERATED_COMMANDS_MEMORY_REQUIREMENTS_INFO_NV);
        return ret;
    }

    public static VkGeneratedCommandsMemoryRequirementsInfoNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkGeneratedCommandsMemoryRequirementsInfoNV.Ptr ret = new VkGeneratedCommandsMemoryRequirementsInfoNV.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.GENERATED_COMMANDS_MEMORY_REQUIREMENTS_INFO_NV);
        }
        return ret;
    }

    public static VkGeneratedCommandsMemoryRequirementsInfoNV clone(Arena arena, VkGeneratedCommandsMemoryRequirementsInfoNV src) {
        VkGeneratedCommandsMemoryRequirementsInfoNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.GENERATED_COMMANDS_MEMORY_REQUIREMENTS_INFO_NV);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkGeneratedCommandsMemoryRequirementsInfoNV sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkGeneratedCommandsMemoryRequirementsInfoNV pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkGeneratedCommandsMemoryRequirementsInfoNV pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @EnumType(VkPipelineBindPoint.class) int pipelineBindPoint() {
        return segment.get(LAYOUT$pipelineBindPoint, OFFSET$pipelineBindPoint);
    }

    public VkGeneratedCommandsMemoryRequirementsInfoNV pipelineBindPoint(@EnumType(VkPipelineBindPoint.class) int value) {
        segment.set(LAYOUT$pipelineBindPoint, OFFSET$pipelineBindPoint, value);
        return this;
    }

    public @Nullable VkPipeline pipeline() {
        MemorySegment s = segment.asSlice(OFFSET$pipeline, SIZE$pipeline);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkPipeline(s);
    }

    public VkGeneratedCommandsMemoryRequirementsInfoNV pipeline(@Nullable VkPipeline value) {
        segment.set(LAYOUT$pipeline, OFFSET$pipeline, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Nullable VkIndirectCommandsLayoutNV indirectCommandsLayout() {
        MemorySegment s = segment.asSlice(OFFSET$indirectCommandsLayout, SIZE$indirectCommandsLayout);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkIndirectCommandsLayoutNV(s);
    }

    public VkGeneratedCommandsMemoryRequirementsInfoNV indirectCommandsLayout(@Nullable VkIndirectCommandsLayoutNV value) {
        segment.set(LAYOUT$indirectCommandsLayout, OFFSET$indirectCommandsLayout, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int maxSequencesCount() {
        return segment.get(LAYOUT$maxSequencesCount, OFFSET$maxSequencesCount);
    }

    public VkGeneratedCommandsMemoryRequirementsInfoNV maxSequencesCount(@Unsigned int value) {
        segment.set(LAYOUT$maxSequencesCount, OFFSET$maxSequencesCount, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("pipelineBindPoint"),
        ValueLayout.ADDRESS.withName("pipeline"),
        ValueLayout.ADDRESS.withName("indirectCommandsLayout"),
        ValueLayout.JAVA_INT.withName("maxSequencesCount")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$pipelineBindPoint = PathElement.groupElement("pipelineBindPoint");
    public static final PathElement PATH$pipeline = PathElement.groupElement("pipeline");
    public static final PathElement PATH$indirectCommandsLayout = PathElement.groupElement("indirectCommandsLayout");
    public static final PathElement PATH$maxSequencesCount = PathElement.groupElement("maxSequencesCount");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$pipelineBindPoint = (OfInt) LAYOUT.select(PATH$pipelineBindPoint);
    public static final AddressLayout LAYOUT$pipeline = (AddressLayout) LAYOUT.select(PATH$pipeline);
    public static final AddressLayout LAYOUT$indirectCommandsLayout = (AddressLayout) LAYOUT.select(PATH$indirectCommandsLayout);
    public static final OfInt LAYOUT$maxSequencesCount = (OfInt) LAYOUT.select(PATH$maxSequencesCount);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$pipelineBindPoint = LAYOUT$pipelineBindPoint.byteSize();
    public static final long SIZE$pipeline = LAYOUT$pipeline.byteSize();
    public static final long SIZE$indirectCommandsLayout = LAYOUT$indirectCommandsLayout.byteSize();
    public static final long SIZE$maxSequencesCount = LAYOUT$maxSequencesCount.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$pipelineBindPoint = LAYOUT.byteOffset(PATH$pipelineBindPoint);
    public static final long OFFSET$pipeline = LAYOUT.byteOffset(PATH$pipeline);
    public static final long OFFSET$indirectCommandsLayout = LAYOUT.byteOffset(PATH$indirectCommandsLayout);
    public static final long OFFSET$maxSequencesCount = LAYOUT.byteOffset(PATH$maxSequencesCount);
}
