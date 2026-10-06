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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineCreationFeedbackCreateInfo.html"><code>VkPipelineCreationFeedbackCreateInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPipelineCreationFeedbackCreateInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkPipelineCreationFeedback* pPipelineCreationFeedback; // @link substring="VkPipelineCreationFeedback" target="VkPipelineCreationFeedback" @link substring="pPipelineCreationFeedback" target="#pPipelineCreationFeedback"
///     uint32_t pipelineStageCreationFeedbackCount; // optional // @link substring="pipelineStageCreationFeedbackCount" target="#pipelineStageCreationFeedbackCount"
///     VkPipelineCreationFeedback* pPipelineStageCreationFeedbacks; // optional // @link substring="VkPipelineCreationFeedback" target="VkPipelineCreationFeedback" @link substring="pPipelineStageCreationFeedbacks" target="#pPipelineStageCreationFeedbacks"
/// } VkPipelineCreationFeedbackCreateInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PIPELINE_CREATION_FEEDBACK_CREATE_INFO`
///
/// The {@code allocate} ({@link VkPipelineCreationFeedbackCreateInfo#allocate(Arena)}, {@link VkPipelineCreationFeedbackCreateInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPipelineCreationFeedbackCreateInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineCreationFeedbackCreateInfo.html"><code>VkPipelineCreationFeedbackCreateInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPipelineCreationFeedbackCreateInfo(@NotNull MemorySegment segment) implements IVkPipelineCreationFeedbackCreateInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineCreationFeedbackCreateInfo.html"><code>VkPipelineCreationFeedbackCreateInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPipelineCreationFeedbackCreateInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPipelineCreationFeedbackCreateInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPipelineCreationFeedbackCreateInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPipelineCreationFeedbackCreateInfo, Iterable<VkPipelineCreationFeedbackCreateInfo> {
        public long size() {
            return segment.byteSize() / VkPipelineCreationFeedbackCreateInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPipelineCreationFeedbackCreateInfo at(long index) {
            return new VkPipelineCreationFeedbackCreateInfo(segment.asSlice(index * VkPipelineCreationFeedbackCreateInfo.BYTES, VkPipelineCreationFeedbackCreateInfo.BYTES));
        }

        public VkPipelineCreationFeedbackCreateInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkPipelineCreationFeedbackCreateInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPipelineCreationFeedbackCreateInfo value) {
            MemorySegment s = segment.asSlice(index * VkPipelineCreationFeedbackCreateInfo.BYTES, VkPipelineCreationFeedbackCreateInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPipelineCreationFeedbackCreateInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPipelineCreationFeedbackCreateInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPipelineCreationFeedbackCreateInfo.BYTES,
                (end - start) * VkPipelineCreationFeedbackCreateInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPipelineCreationFeedbackCreateInfo.BYTES));
        }

        public VkPipelineCreationFeedbackCreateInfo[] toArray() {
            VkPipelineCreationFeedbackCreateInfo[] ret = new VkPipelineCreationFeedbackCreateInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPipelineCreationFeedbackCreateInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPipelineCreationFeedbackCreateInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPipelineCreationFeedbackCreateInfo.BYTES;
            }

            @Override
            public VkPipelineCreationFeedbackCreateInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPipelineCreationFeedbackCreateInfo ret = new VkPipelineCreationFeedbackCreateInfo(segment.asSlice(0, VkPipelineCreationFeedbackCreateInfo.BYTES));
                segment = segment.asSlice(VkPipelineCreationFeedbackCreateInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPipelineCreationFeedbackCreateInfo allocate(Arena arena) {
        VkPipelineCreationFeedbackCreateInfo ret = new VkPipelineCreationFeedbackCreateInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PIPELINE_CREATION_FEEDBACK_CREATE_INFO);
        return ret;
    }

    public static VkPipelineCreationFeedbackCreateInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPipelineCreationFeedbackCreateInfo.Ptr ret = new VkPipelineCreationFeedbackCreateInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PIPELINE_CREATION_FEEDBACK_CREATE_INFO);
        }
        return ret;
    }

    public static VkPipelineCreationFeedbackCreateInfo clone(Arena arena, VkPipelineCreationFeedbackCreateInfo src) {
        VkPipelineCreationFeedbackCreateInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PIPELINE_CREATION_FEEDBACK_CREATE_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPipelineCreationFeedbackCreateInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPipelineCreationFeedbackCreateInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPipelineCreationFeedbackCreateInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public VkPipelineCreationFeedbackCreateInfo pPipelineCreationFeedback(@Nullable IVkPipelineCreationFeedback value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pPipelineCreationFeedbackRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkPipelineCreationFeedback.Ptr pPipelineCreationFeedback(int assumedCount) {
        MemorySegment s = pPipelineCreationFeedbackRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkPipelineCreationFeedback.BYTES);
        return new VkPipelineCreationFeedback.Ptr(s);
    }

    public @Nullable VkPipelineCreationFeedback pPipelineCreationFeedback() {
        MemorySegment s = pPipelineCreationFeedbackRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkPipelineCreationFeedback(s);
    }

    public @Pointer(target=VkPipelineCreationFeedback.class) @NotNull MemorySegment pPipelineCreationFeedbackRaw() {
        return segment.get(LAYOUT$pPipelineCreationFeedback, OFFSET$pPipelineCreationFeedback);
    }

    public void pPipelineCreationFeedbackRaw(@Pointer(target=VkPipelineCreationFeedback.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pPipelineCreationFeedback, OFFSET$pPipelineCreationFeedback, value);
    }

    public @Unsigned int pipelineStageCreationFeedbackCount() {
        return segment.get(LAYOUT$pipelineStageCreationFeedbackCount, OFFSET$pipelineStageCreationFeedbackCount);
    }

    public VkPipelineCreationFeedbackCreateInfo pipelineStageCreationFeedbackCount(@Unsigned int value) {
        segment.set(LAYOUT$pipelineStageCreationFeedbackCount, OFFSET$pipelineStageCreationFeedbackCount, value);
        return this;
    }

    public VkPipelineCreationFeedbackCreateInfo pPipelineStageCreationFeedbacks(@Nullable IVkPipelineCreationFeedback value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pPipelineStageCreationFeedbacksRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkPipelineCreationFeedback.Ptr pPipelineStageCreationFeedbacks(int assumedCount) {
        MemorySegment s = pPipelineStageCreationFeedbacksRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkPipelineCreationFeedback.BYTES);
        return new VkPipelineCreationFeedback.Ptr(s);
    }

    public @Nullable VkPipelineCreationFeedback pPipelineStageCreationFeedbacks() {
        MemorySegment s = pPipelineStageCreationFeedbacksRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkPipelineCreationFeedback(s);
    }

    public @Pointer(target=VkPipelineCreationFeedback.class) @NotNull MemorySegment pPipelineStageCreationFeedbacksRaw() {
        return segment.get(LAYOUT$pPipelineStageCreationFeedbacks, OFFSET$pPipelineStageCreationFeedbacks);
    }

    public void pPipelineStageCreationFeedbacksRaw(@Pointer(target=VkPipelineCreationFeedback.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pPipelineStageCreationFeedbacks, OFFSET$pPipelineStageCreationFeedbacks, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withTargetLayout(VkPipelineCreationFeedback.LAYOUT).withName("pPipelineCreationFeedback"),
        ValueLayout.JAVA_INT.withName("pipelineStageCreationFeedbackCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkPipelineCreationFeedback.LAYOUT).withName("pPipelineStageCreationFeedbacks")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$pPipelineCreationFeedback = PathElement.groupElement("pPipelineCreationFeedback");
    public static final PathElement PATH$pipelineStageCreationFeedbackCount = PathElement.groupElement("pipelineStageCreationFeedbackCount");
    public static final PathElement PATH$pPipelineStageCreationFeedbacks = PathElement.groupElement("pPipelineStageCreationFeedbacks");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$pPipelineCreationFeedback = (AddressLayout) LAYOUT.select(PATH$pPipelineCreationFeedback);
    public static final OfInt LAYOUT$pipelineStageCreationFeedbackCount = (OfInt) LAYOUT.select(PATH$pipelineStageCreationFeedbackCount);
    public static final AddressLayout LAYOUT$pPipelineStageCreationFeedbacks = (AddressLayout) LAYOUT.select(PATH$pPipelineStageCreationFeedbacks);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$pPipelineCreationFeedback = LAYOUT$pPipelineCreationFeedback.byteSize();
    public static final long SIZE$pipelineStageCreationFeedbackCount = LAYOUT$pipelineStageCreationFeedbackCount.byteSize();
    public static final long SIZE$pPipelineStageCreationFeedbacks = LAYOUT$pPipelineStageCreationFeedbacks.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$pPipelineCreationFeedback = LAYOUT.byteOffset(PATH$pPipelineCreationFeedback);
    public static final long OFFSET$pipelineStageCreationFeedbackCount = LAYOUT.byteOffset(PATH$pipelineStageCreationFeedbackCount);
    public static final long OFFSET$pPipelineStageCreationFeedbacks = LAYOUT.byteOffset(PATH$pPipelineStageCreationFeedbacks);
}
