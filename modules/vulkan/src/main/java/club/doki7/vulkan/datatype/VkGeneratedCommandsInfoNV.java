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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGeneratedCommandsInfoNV.html"><code>VkGeneratedCommandsInfoNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkGeneratedCommandsInfoNV {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkPipelineBindPoint pipelineBindPoint; // @link substring="VkPipelineBindPoint" target="VkPipelineBindPoint" @link substring="pipelineBindPoint" target="#pipelineBindPoint"
///     VkPipeline pipeline; // optional // @link substring="VkPipeline" target="VkPipeline" @link substring="pipeline" target="#pipeline"
///     VkIndirectCommandsLayoutNV indirectCommandsLayout; // @link substring="VkIndirectCommandsLayoutNV" target="VkIndirectCommandsLayoutNV" @link substring="indirectCommandsLayout" target="#indirectCommandsLayout"
///     uint32_t streamCount; // @link substring="streamCount" target="#streamCount"
///     VkIndirectCommandsStreamNV const* pStreams; // @link substring="VkIndirectCommandsStreamNV" target="VkIndirectCommandsStreamNV" @link substring="pStreams" target="#pStreams"
///     uint32_t sequencesCount; // @link substring="sequencesCount" target="#sequencesCount"
///     VkBuffer preprocessBuffer; // @link substring="VkBuffer" target="VkBuffer" @link substring="preprocessBuffer" target="#preprocessBuffer"
///     VkDeviceSize preprocessOffset; // @link substring="preprocessOffset" target="#preprocessOffset"
///     VkDeviceSize preprocessSize; // @link substring="preprocessSize" target="#preprocessSize"
///     VkBuffer sequencesCountBuffer; // optional // @link substring="VkBuffer" target="VkBuffer" @link substring="sequencesCountBuffer" target="#sequencesCountBuffer"
///     VkDeviceSize sequencesCountOffset; // @link substring="sequencesCountOffset" target="#sequencesCountOffset"
///     VkBuffer sequencesIndexBuffer; // optional // @link substring="VkBuffer" target="VkBuffer" @link substring="sequencesIndexBuffer" target="#sequencesIndexBuffer"
///     VkDeviceSize sequencesIndexOffset; // @link substring="sequencesIndexOffset" target="#sequencesIndexOffset"
/// } VkGeneratedCommandsInfoNV;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_GENERATED_COMMANDS_INFO_NV`
///
/// The {@code allocate} ({@link VkGeneratedCommandsInfoNV#allocate(Arena)}, {@link VkGeneratedCommandsInfoNV#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkGeneratedCommandsInfoNV#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGeneratedCommandsInfoNV.html"><code>VkGeneratedCommandsInfoNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkGeneratedCommandsInfoNV(@NotNull MemorySegment segment) implements IVkGeneratedCommandsInfoNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGeneratedCommandsInfoNV.html"><code>VkGeneratedCommandsInfoNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkGeneratedCommandsInfoNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkGeneratedCommandsInfoNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkGeneratedCommandsInfoNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkGeneratedCommandsInfoNV, Iterable<VkGeneratedCommandsInfoNV> {
        public long size() {
            return segment.byteSize() / VkGeneratedCommandsInfoNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkGeneratedCommandsInfoNV at(long index) {
            return new VkGeneratedCommandsInfoNV(segment.asSlice(index * VkGeneratedCommandsInfoNV.BYTES, VkGeneratedCommandsInfoNV.BYTES));
        }

        public VkGeneratedCommandsInfoNV.Ptr at(long index, @NotNull Consumer<@NotNull VkGeneratedCommandsInfoNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkGeneratedCommandsInfoNV value) {
            MemorySegment s = segment.asSlice(index * VkGeneratedCommandsInfoNV.BYTES, VkGeneratedCommandsInfoNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkGeneratedCommandsInfoNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkGeneratedCommandsInfoNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkGeneratedCommandsInfoNV.BYTES,
                (end - start) * VkGeneratedCommandsInfoNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkGeneratedCommandsInfoNV.BYTES));
        }

        public VkGeneratedCommandsInfoNV[] toArray() {
            VkGeneratedCommandsInfoNV[] ret = new VkGeneratedCommandsInfoNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkGeneratedCommandsInfoNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkGeneratedCommandsInfoNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkGeneratedCommandsInfoNV.BYTES;
            }

            @Override
            public VkGeneratedCommandsInfoNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkGeneratedCommandsInfoNV ret = new VkGeneratedCommandsInfoNV(segment.asSlice(0, VkGeneratedCommandsInfoNV.BYTES));
                segment = segment.asSlice(VkGeneratedCommandsInfoNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkGeneratedCommandsInfoNV allocate(Arena arena) {
        VkGeneratedCommandsInfoNV ret = new VkGeneratedCommandsInfoNV(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.GENERATED_COMMANDS_INFO_NV);
        return ret;
    }

    public static VkGeneratedCommandsInfoNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkGeneratedCommandsInfoNV.Ptr ret = new VkGeneratedCommandsInfoNV.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.GENERATED_COMMANDS_INFO_NV);
        }
        return ret;
    }

    public static VkGeneratedCommandsInfoNV clone(Arena arena, VkGeneratedCommandsInfoNV src) {
        VkGeneratedCommandsInfoNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.GENERATED_COMMANDS_INFO_NV);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkGeneratedCommandsInfoNV sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkGeneratedCommandsInfoNV pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkGeneratedCommandsInfoNV pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @EnumType(VkPipelineBindPoint.class) int pipelineBindPoint() {
        return segment.get(LAYOUT$pipelineBindPoint, OFFSET$pipelineBindPoint);
    }

    public VkGeneratedCommandsInfoNV pipelineBindPoint(@EnumType(VkPipelineBindPoint.class) int value) {
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

    public VkGeneratedCommandsInfoNV pipeline(@Nullable VkPipeline value) {
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

    public VkGeneratedCommandsInfoNV indirectCommandsLayout(@Nullable VkIndirectCommandsLayoutNV value) {
        segment.set(LAYOUT$indirectCommandsLayout, OFFSET$indirectCommandsLayout, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int streamCount() {
        return segment.get(LAYOUT$streamCount, OFFSET$streamCount);
    }

    public VkGeneratedCommandsInfoNV streamCount(@Unsigned int value) {
        segment.set(LAYOUT$streamCount, OFFSET$streamCount, value);
        return this;
    }

    public VkGeneratedCommandsInfoNV pStreams(@Nullable IVkIndirectCommandsStreamNV value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pStreamsRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkIndirectCommandsStreamNV.Ptr pStreams(int assumedCount) {
        MemorySegment s = pStreamsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkIndirectCommandsStreamNV.BYTES);
        return new VkIndirectCommandsStreamNV.Ptr(s);
    }

    public @Nullable VkIndirectCommandsStreamNV pStreams() {
        MemorySegment s = pStreamsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkIndirectCommandsStreamNV(s);
    }

    public @Pointer(target=VkIndirectCommandsStreamNV.class) @NotNull MemorySegment pStreamsRaw() {
        return segment.get(LAYOUT$pStreams, OFFSET$pStreams);
    }

    public void pStreamsRaw(@Pointer(target=VkIndirectCommandsStreamNV.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pStreams, OFFSET$pStreams, value);
    }

    public @Unsigned int sequencesCount() {
        return segment.get(LAYOUT$sequencesCount, OFFSET$sequencesCount);
    }

    public VkGeneratedCommandsInfoNV sequencesCount(@Unsigned int value) {
        segment.set(LAYOUT$sequencesCount, OFFSET$sequencesCount, value);
        return this;
    }

    public @Nullable VkBuffer preprocessBuffer() {
        MemorySegment s = segment.asSlice(OFFSET$preprocessBuffer, SIZE$preprocessBuffer);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkBuffer(s);
    }

    public VkGeneratedCommandsInfoNV preprocessBuffer(@Nullable VkBuffer value) {
        segment.set(LAYOUT$preprocessBuffer, OFFSET$preprocessBuffer, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long preprocessOffset() {
        return segment.get(LAYOUT$preprocessOffset, OFFSET$preprocessOffset);
    }

    public VkGeneratedCommandsInfoNV preprocessOffset(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$preprocessOffset, OFFSET$preprocessOffset, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long preprocessSize() {
        return segment.get(LAYOUT$preprocessSize, OFFSET$preprocessSize);
    }

    public VkGeneratedCommandsInfoNV preprocessSize(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$preprocessSize, OFFSET$preprocessSize, value);
        return this;
    }

    public @Nullable VkBuffer sequencesCountBuffer() {
        MemorySegment s = segment.asSlice(OFFSET$sequencesCountBuffer, SIZE$sequencesCountBuffer);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkBuffer(s);
    }

    public VkGeneratedCommandsInfoNV sequencesCountBuffer(@Nullable VkBuffer value) {
        segment.set(LAYOUT$sequencesCountBuffer, OFFSET$sequencesCountBuffer, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long sequencesCountOffset() {
        return segment.get(LAYOUT$sequencesCountOffset, OFFSET$sequencesCountOffset);
    }

    public VkGeneratedCommandsInfoNV sequencesCountOffset(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$sequencesCountOffset, OFFSET$sequencesCountOffset, value);
        return this;
    }

    public @Nullable VkBuffer sequencesIndexBuffer() {
        MemorySegment s = segment.asSlice(OFFSET$sequencesIndexBuffer, SIZE$sequencesIndexBuffer);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkBuffer(s);
    }

    public VkGeneratedCommandsInfoNV sequencesIndexBuffer(@Nullable VkBuffer value) {
        segment.set(LAYOUT$sequencesIndexBuffer, OFFSET$sequencesIndexBuffer, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long sequencesIndexOffset() {
        return segment.get(LAYOUT$sequencesIndexOffset, OFFSET$sequencesIndexOffset);
    }

    public VkGeneratedCommandsInfoNV sequencesIndexOffset(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$sequencesIndexOffset, OFFSET$sequencesIndexOffset, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("pipelineBindPoint"),
        ValueLayout.ADDRESS.withName("pipeline"),
        ValueLayout.ADDRESS.withName("indirectCommandsLayout"),
        ValueLayout.JAVA_INT.withName("streamCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkIndirectCommandsStreamNV.LAYOUT).withName("pStreams"),
        ValueLayout.JAVA_INT.withName("sequencesCount"),
        ValueLayout.ADDRESS.withName("preprocessBuffer"),
        ValueLayout.JAVA_LONG.withName("preprocessOffset"),
        ValueLayout.JAVA_LONG.withName("preprocessSize"),
        ValueLayout.ADDRESS.withName("sequencesCountBuffer"),
        ValueLayout.JAVA_LONG.withName("sequencesCountOffset"),
        ValueLayout.ADDRESS.withName("sequencesIndexBuffer"),
        ValueLayout.JAVA_LONG.withName("sequencesIndexOffset")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$pipelineBindPoint = PathElement.groupElement("pipelineBindPoint");
    public static final PathElement PATH$pipeline = PathElement.groupElement("pipeline");
    public static final PathElement PATH$indirectCommandsLayout = PathElement.groupElement("indirectCommandsLayout");
    public static final PathElement PATH$streamCount = PathElement.groupElement("streamCount");
    public static final PathElement PATH$pStreams = PathElement.groupElement("pStreams");
    public static final PathElement PATH$sequencesCount = PathElement.groupElement("sequencesCount");
    public static final PathElement PATH$preprocessBuffer = PathElement.groupElement("preprocessBuffer");
    public static final PathElement PATH$preprocessOffset = PathElement.groupElement("preprocessOffset");
    public static final PathElement PATH$preprocessSize = PathElement.groupElement("preprocessSize");
    public static final PathElement PATH$sequencesCountBuffer = PathElement.groupElement("sequencesCountBuffer");
    public static final PathElement PATH$sequencesCountOffset = PathElement.groupElement("sequencesCountOffset");
    public static final PathElement PATH$sequencesIndexBuffer = PathElement.groupElement("sequencesIndexBuffer");
    public static final PathElement PATH$sequencesIndexOffset = PathElement.groupElement("sequencesIndexOffset");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$pipelineBindPoint = (OfInt) LAYOUT.select(PATH$pipelineBindPoint);
    public static final AddressLayout LAYOUT$pipeline = (AddressLayout) LAYOUT.select(PATH$pipeline);
    public static final AddressLayout LAYOUT$indirectCommandsLayout = (AddressLayout) LAYOUT.select(PATH$indirectCommandsLayout);
    public static final OfInt LAYOUT$streamCount = (OfInt) LAYOUT.select(PATH$streamCount);
    public static final AddressLayout LAYOUT$pStreams = (AddressLayout) LAYOUT.select(PATH$pStreams);
    public static final OfInt LAYOUT$sequencesCount = (OfInt) LAYOUT.select(PATH$sequencesCount);
    public static final AddressLayout LAYOUT$preprocessBuffer = (AddressLayout) LAYOUT.select(PATH$preprocessBuffer);
    public static final OfLong LAYOUT$preprocessOffset = (OfLong) LAYOUT.select(PATH$preprocessOffset);
    public static final OfLong LAYOUT$preprocessSize = (OfLong) LAYOUT.select(PATH$preprocessSize);
    public static final AddressLayout LAYOUT$sequencesCountBuffer = (AddressLayout) LAYOUT.select(PATH$sequencesCountBuffer);
    public static final OfLong LAYOUT$sequencesCountOffset = (OfLong) LAYOUT.select(PATH$sequencesCountOffset);
    public static final AddressLayout LAYOUT$sequencesIndexBuffer = (AddressLayout) LAYOUT.select(PATH$sequencesIndexBuffer);
    public static final OfLong LAYOUT$sequencesIndexOffset = (OfLong) LAYOUT.select(PATH$sequencesIndexOffset);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$pipelineBindPoint = LAYOUT$pipelineBindPoint.byteSize();
    public static final long SIZE$pipeline = LAYOUT$pipeline.byteSize();
    public static final long SIZE$indirectCommandsLayout = LAYOUT$indirectCommandsLayout.byteSize();
    public static final long SIZE$streamCount = LAYOUT$streamCount.byteSize();
    public static final long SIZE$pStreams = LAYOUT$pStreams.byteSize();
    public static final long SIZE$sequencesCount = LAYOUT$sequencesCount.byteSize();
    public static final long SIZE$preprocessBuffer = LAYOUT$preprocessBuffer.byteSize();
    public static final long SIZE$preprocessOffset = LAYOUT$preprocessOffset.byteSize();
    public static final long SIZE$preprocessSize = LAYOUT$preprocessSize.byteSize();
    public static final long SIZE$sequencesCountBuffer = LAYOUT$sequencesCountBuffer.byteSize();
    public static final long SIZE$sequencesCountOffset = LAYOUT$sequencesCountOffset.byteSize();
    public static final long SIZE$sequencesIndexBuffer = LAYOUT$sequencesIndexBuffer.byteSize();
    public static final long SIZE$sequencesIndexOffset = LAYOUT$sequencesIndexOffset.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$pipelineBindPoint = LAYOUT.byteOffset(PATH$pipelineBindPoint);
    public static final long OFFSET$pipeline = LAYOUT.byteOffset(PATH$pipeline);
    public static final long OFFSET$indirectCommandsLayout = LAYOUT.byteOffset(PATH$indirectCommandsLayout);
    public static final long OFFSET$streamCount = LAYOUT.byteOffset(PATH$streamCount);
    public static final long OFFSET$pStreams = LAYOUT.byteOffset(PATH$pStreams);
    public static final long OFFSET$sequencesCount = LAYOUT.byteOffset(PATH$sequencesCount);
    public static final long OFFSET$preprocessBuffer = LAYOUT.byteOffset(PATH$preprocessBuffer);
    public static final long OFFSET$preprocessOffset = LAYOUT.byteOffset(PATH$preprocessOffset);
    public static final long OFFSET$preprocessSize = LAYOUT.byteOffset(PATH$preprocessSize);
    public static final long OFFSET$sequencesCountBuffer = LAYOUT.byteOffset(PATH$sequencesCountBuffer);
    public static final long OFFSET$sequencesCountOffset = LAYOUT.byteOffset(PATH$sequencesCountOffset);
    public static final long OFFSET$sequencesIndexBuffer = LAYOUT.byteOffset(PATH$sequencesIndexBuffer);
    public static final long OFFSET$sequencesIndexOffset = LAYOUT.byteOffset(PATH$sequencesIndexOffset);
}
