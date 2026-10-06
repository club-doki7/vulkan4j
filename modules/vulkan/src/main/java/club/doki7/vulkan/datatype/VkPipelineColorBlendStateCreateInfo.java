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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineColorBlendStateCreateInfo.html"><code>VkPipelineColorBlendStateCreateInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPipelineColorBlendStateCreateInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkPipelineColorBlendStateCreateFlags flags; // optional // @link substring="VkPipelineColorBlendStateCreateFlags" target="VkPipelineColorBlendStateCreateFlags" @link substring="flags" target="#flags"
///     VkBool32 logicOpEnable; // @link substring="logicOpEnable" target="#logicOpEnable"
///     VkLogicOp logicOp; // @link substring="VkLogicOp" target="VkLogicOp" @link substring="logicOp" target="#logicOp"
///     uint32_t attachmentCount; // optional // @link substring="attachmentCount" target="#attachmentCount"
///     VkPipelineColorBlendAttachmentState const* pAttachments; // optional // @link substring="VkPipelineColorBlendAttachmentState" target="VkPipelineColorBlendAttachmentState" @link substring="pAttachments" target="#pAttachments"
///     float[4] blendConstants; // @link substring="blendConstants" target="#blendConstants"
/// } VkPipelineColorBlendStateCreateInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PIPELINE_COLOR_BLEND_STATE_CREATE_INFO`
///
/// The {@code allocate} ({@link VkPipelineColorBlendStateCreateInfo#allocate(Arena)}, {@link VkPipelineColorBlendStateCreateInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPipelineColorBlendStateCreateInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineColorBlendStateCreateInfo.html"><code>VkPipelineColorBlendStateCreateInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPipelineColorBlendStateCreateInfo(@NotNull MemorySegment segment) implements IVkPipelineColorBlendStateCreateInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineColorBlendStateCreateInfo.html"><code>VkPipelineColorBlendStateCreateInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPipelineColorBlendStateCreateInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPipelineColorBlendStateCreateInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPipelineColorBlendStateCreateInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPipelineColorBlendStateCreateInfo, Iterable<VkPipelineColorBlendStateCreateInfo> {
        public long size() {
            return segment.byteSize() / VkPipelineColorBlendStateCreateInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPipelineColorBlendStateCreateInfo at(long index) {
            return new VkPipelineColorBlendStateCreateInfo(segment.asSlice(index * VkPipelineColorBlendStateCreateInfo.BYTES, VkPipelineColorBlendStateCreateInfo.BYTES));
        }

        public VkPipelineColorBlendStateCreateInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkPipelineColorBlendStateCreateInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPipelineColorBlendStateCreateInfo value) {
            MemorySegment s = segment.asSlice(index * VkPipelineColorBlendStateCreateInfo.BYTES, VkPipelineColorBlendStateCreateInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPipelineColorBlendStateCreateInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPipelineColorBlendStateCreateInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPipelineColorBlendStateCreateInfo.BYTES,
                (end - start) * VkPipelineColorBlendStateCreateInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPipelineColorBlendStateCreateInfo.BYTES));
        }

        public VkPipelineColorBlendStateCreateInfo[] toArray() {
            VkPipelineColorBlendStateCreateInfo[] ret = new VkPipelineColorBlendStateCreateInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPipelineColorBlendStateCreateInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPipelineColorBlendStateCreateInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPipelineColorBlendStateCreateInfo.BYTES;
            }

            @Override
            public VkPipelineColorBlendStateCreateInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPipelineColorBlendStateCreateInfo ret = new VkPipelineColorBlendStateCreateInfo(segment.asSlice(0, VkPipelineColorBlendStateCreateInfo.BYTES));
                segment = segment.asSlice(VkPipelineColorBlendStateCreateInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPipelineColorBlendStateCreateInfo allocate(Arena arena) {
        VkPipelineColorBlendStateCreateInfo ret = new VkPipelineColorBlendStateCreateInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PIPELINE_COLOR_BLEND_STATE_CREATE_INFO);
        return ret;
    }

    public static VkPipelineColorBlendStateCreateInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPipelineColorBlendStateCreateInfo.Ptr ret = new VkPipelineColorBlendStateCreateInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PIPELINE_COLOR_BLEND_STATE_CREATE_INFO);
        }
        return ret;
    }

    public static VkPipelineColorBlendStateCreateInfo clone(Arena arena, VkPipelineColorBlendStateCreateInfo src) {
        VkPipelineColorBlendStateCreateInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PIPELINE_COLOR_BLEND_STATE_CREATE_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPipelineColorBlendStateCreateInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPipelineColorBlendStateCreateInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPipelineColorBlendStateCreateInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkPipelineColorBlendStateCreateFlags.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkPipelineColorBlendStateCreateInfo flags(@Bitmask(VkPipelineColorBlendStateCreateFlags.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int logicOpEnable() {
        return segment.get(LAYOUT$logicOpEnable, OFFSET$logicOpEnable);
    }

    public VkPipelineColorBlendStateCreateInfo logicOpEnable(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$logicOpEnable, OFFSET$logicOpEnable, value);
        return this;
    }

    public @EnumType(VkLogicOp.class) int logicOp() {
        return segment.get(LAYOUT$logicOp, OFFSET$logicOp);
    }

    public VkPipelineColorBlendStateCreateInfo logicOp(@EnumType(VkLogicOp.class) int value) {
        segment.set(LAYOUT$logicOp, OFFSET$logicOp, value);
        return this;
    }

    public @Unsigned int attachmentCount() {
        return segment.get(LAYOUT$attachmentCount, OFFSET$attachmentCount);
    }

    public VkPipelineColorBlendStateCreateInfo attachmentCount(@Unsigned int value) {
        segment.set(LAYOUT$attachmentCount, OFFSET$attachmentCount, value);
        return this;
    }

    public VkPipelineColorBlendStateCreateInfo pAttachments(@Nullable IVkPipelineColorBlendAttachmentState value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pAttachmentsRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkPipelineColorBlendAttachmentState.Ptr pAttachments(int assumedCount) {
        MemorySegment s = pAttachmentsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkPipelineColorBlendAttachmentState.BYTES);
        return new VkPipelineColorBlendAttachmentState.Ptr(s);
    }

    public @Nullable VkPipelineColorBlendAttachmentState pAttachments() {
        MemorySegment s = pAttachmentsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkPipelineColorBlendAttachmentState(s);
    }

    public @Pointer(target=VkPipelineColorBlendAttachmentState.class) @NotNull MemorySegment pAttachmentsRaw() {
        return segment.get(LAYOUT$pAttachments, OFFSET$pAttachments);
    }

    public void pAttachmentsRaw(@Pointer(target=VkPipelineColorBlendAttachmentState.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pAttachments, OFFSET$pAttachments, value);
    }

    public FloatPtr blendConstants() {
        return new FloatPtr(blendConstantsRaw());
    }

    public VkPipelineColorBlendStateCreateInfo blendConstants(@NotNull Consumer<FloatPtr> consumer) {
        FloatPtr ptr = blendConstants();
        consumer.accept(ptr);
        return this;
    }

    public VkPipelineColorBlendStateCreateInfo blendConstants(FloatPtr value) {
        MemorySegment s = blendConstantsRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment blendConstantsRaw() {
        return segment.asSlice(OFFSET$blendConstants, SIZE$blendConstants);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("logicOpEnable"),
        ValueLayout.JAVA_INT.withName("logicOp"),
        ValueLayout.JAVA_INT.withName("attachmentCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkPipelineColorBlendAttachmentState.LAYOUT).withName("pAttachments"),
        MemoryLayout.sequenceLayout(4, ValueLayout.JAVA_FLOAT).withName("blendConstants")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$logicOpEnable = PathElement.groupElement("logicOpEnable");
    public static final PathElement PATH$logicOp = PathElement.groupElement("logicOp");
    public static final PathElement PATH$attachmentCount = PathElement.groupElement("attachmentCount");
    public static final PathElement PATH$pAttachments = PathElement.groupElement("pAttachments");
    public static final PathElement PATH$blendConstants = PathElement.groupElement("blendConstants");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$logicOpEnable = (OfInt) LAYOUT.select(PATH$logicOpEnable);
    public static final OfInt LAYOUT$logicOp = (OfInt) LAYOUT.select(PATH$logicOp);
    public static final OfInt LAYOUT$attachmentCount = (OfInt) LAYOUT.select(PATH$attachmentCount);
    public static final AddressLayout LAYOUT$pAttachments = (AddressLayout) LAYOUT.select(PATH$pAttachments);
    public static final SequenceLayout LAYOUT$blendConstants = (SequenceLayout) LAYOUT.select(PATH$blendConstants);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$logicOpEnable = LAYOUT$logicOpEnable.byteSize();
    public static final long SIZE$logicOp = LAYOUT$logicOp.byteSize();
    public static final long SIZE$attachmentCount = LAYOUT$attachmentCount.byteSize();
    public static final long SIZE$pAttachments = LAYOUT$pAttachments.byteSize();
    public static final long SIZE$blendConstants = LAYOUT$blendConstants.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$logicOpEnable = LAYOUT.byteOffset(PATH$logicOpEnable);
    public static final long OFFSET$logicOp = LAYOUT.byteOffset(PATH$logicOp);
    public static final long OFFSET$attachmentCount = LAYOUT.byteOffset(PATH$attachmentCount);
    public static final long OFFSET$pAttachments = LAYOUT.byteOffset(PATH$pAttachments);
    public static final long OFFSET$blendConstants = LAYOUT.byteOffset(PATH$blendConstants);
}
