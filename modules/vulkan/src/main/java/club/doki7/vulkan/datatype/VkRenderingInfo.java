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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRenderingInfo.html"><code>VkRenderingInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkRenderingInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkRenderingFlags flags; // optional // @link substring="VkRenderingFlags" target="VkRenderingFlags" @link substring="flags" target="#flags"
///     VkRect2D renderArea; // @link substring="VkRect2D" target="VkRect2D" @link substring="renderArea" target="#renderArea"
///     uint32_t layerCount; // @link substring="layerCount" target="#layerCount"
///     uint32_t viewMask; // @link substring="viewMask" target="#viewMask"
///     uint32_t colorAttachmentCount; // optional // @link substring="colorAttachmentCount" target="#colorAttachmentCount"
///     VkRenderingAttachmentInfo const* pColorAttachments; // optional // @link substring="VkRenderingAttachmentInfo" target="VkRenderingAttachmentInfo" @link substring="pColorAttachments" target="#pColorAttachments"
///     VkRenderingAttachmentInfo const* pDepthAttachment; // optional // @link substring="VkRenderingAttachmentInfo" target="VkRenderingAttachmentInfo" @link substring="pDepthAttachment" target="#pDepthAttachment"
///     VkRenderingAttachmentInfo const* pStencilAttachment; // optional // @link substring="VkRenderingAttachmentInfo" target="VkRenderingAttachmentInfo" @link substring="pStencilAttachment" target="#pStencilAttachment"
/// } VkRenderingInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_RENDERING_INFO`
///
/// The {@code allocate} ({@link VkRenderingInfo#allocate(Arena)}, {@link VkRenderingInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkRenderingInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRenderingInfo.html"><code>VkRenderingInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkRenderingInfo(@NotNull MemorySegment segment) implements IVkRenderingInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRenderingInfo.html"><code>VkRenderingInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkRenderingInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkRenderingInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkRenderingInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkRenderingInfo, Iterable<VkRenderingInfo> {
        public long size() {
            return segment.byteSize() / VkRenderingInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkRenderingInfo at(long index) {
            return new VkRenderingInfo(segment.asSlice(index * VkRenderingInfo.BYTES, VkRenderingInfo.BYTES));
        }

        public VkRenderingInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkRenderingInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkRenderingInfo value) {
            MemorySegment s = segment.asSlice(index * VkRenderingInfo.BYTES, VkRenderingInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkRenderingInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkRenderingInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkRenderingInfo.BYTES,
                (end - start) * VkRenderingInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkRenderingInfo.BYTES));
        }

        public VkRenderingInfo[] toArray() {
            VkRenderingInfo[] ret = new VkRenderingInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkRenderingInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkRenderingInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkRenderingInfo.BYTES;
            }

            @Override
            public VkRenderingInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkRenderingInfo ret = new VkRenderingInfo(segment.asSlice(0, VkRenderingInfo.BYTES));
                segment = segment.asSlice(VkRenderingInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkRenderingInfo allocate(Arena arena) {
        VkRenderingInfo ret = new VkRenderingInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.RENDERING_INFO);
        return ret;
    }

    public static VkRenderingInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkRenderingInfo.Ptr ret = new VkRenderingInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.RENDERING_INFO);
        }
        return ret;
    }

    public static VkRenderingInfo clone(Arena arena, VkRenderingInfo src) {
        VkRenderingInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.RENDERING_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkRenderingInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkRenderingInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkRenderingInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkRenderingFlags.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkRenderingInfo flags(@Bitmask(VkRenderingFlags.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @NotNull VkRect2D renderArea() {
        return new VkRect2D(segment.asSlice(OFFSET$renderArea, LAYOUT$renderArea));
    }

    public VkRenderingInfo renderArea(@NotNull VkRect2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$renderArea, SIZE$renderArea);
        return this;
    }

    public VkRenderingInfo renderArea(Consumer<@NotNull VkRect2D> consumer) {
        consumer.accept(renderArea());
        return this;
    }

    public @Unsigned int layerCount() {
        return segment.get(LAYOUT$layerCount, OFFSET$layerCount);
    }

    public VkRenderingInfo layerCount(@Unsigned int value) {
        segment.set(LAYOUT$layerCount, OFFSET$layerCount, value);
        return this;
    }

    public @Unsigned int viewMask() {
        return segment.get(LAYOUT$viewMask, OFFSET$viewMask);
    }

    public VkRenderingInfo viewMask(@Unsigned int value) {
        segment.set(LAYOUT$viewMask, OFFSET$viewMask, value);
        return this;
    }

    public @Unsigned int colorAttachmentCount() {
        return segment.get(LAYOUT$colorAttachmentCount, OFFSET$colorAttachmentCount);
    }

    public VkRenderingInfo colorAttachmentCount(@Unsigned int value) {
        segment.set(LAYOUT$colorAttachmentCount, OFFSET$colorAttachmentCount, value);
        return this;
    }

    public VkRenderingInfo pColorAttachments(@Nullable IVkRenderingAttachmentInfo value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pColorAttachmentsRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkRenderingAttachmentInfo.Ptr pColorAttachments(int assumedCount) {
        MemorySegment s = pColorAttachmentsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkRenderingAttachmentInfo.BYTES);
        return new VkRenderingAttachmentInfo.Ptr(s);
    }

    public @Nullable VkRenderingAttachmentInfo pColorAttachments() {
        MemorySegment s = pColorAttachmentsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkRenderingAttachmentInfo(s);
    }

    public @Pointer(target=VkRenderingAttachmentInfo.class) @NotNull MemorySegment pColorAttachmentsRaw() {
        return segment.get(LAYOUT$pColorAttachments, OFFSET$pColorAttachments);
    }

    public void pColorAttachmentsRaw(@Pointer(target=VkRenderingAttachmentInfo.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pColorAttachments, OFFSET$pColorAttachments, value);
    }

    public VkRenderingInfo pDepthAttachment(@Nullable IVkRenderingAttachmentInfo value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pDepthAttachmentRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkRenderingAttachmentInfo.Ptr pDepthAttachment(int assumedCount) {
        MemorySegment s = pDepthAttachmentRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkRenderingAttachmentInfo.BYTES);
        return new VkRenderingAttachmentInfo.Ptr(s);
    }

    public @Nullable VkRenderingAttachmentInfo pDepthAttachment() {
        MemorySegment s = pDepthAttachmentRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkRenderingAttachmentInfo(s);
    }

    public @Pointer(target=VkRenderingAttachmentInfo.class) @NotNull MemorySegment pDepthAttachmentRaw() {
        return segment.get(LAYOUT$pDepthAttachment, OFFSET$pDepthAttachment);
    }

    public void pDepthAttachmentRaw(@Pointer(target=VkRenderingAttachmentInfo.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pDepthAttachment, OFFSET$pDepthAttachment, value);
    }

    public VkRenderingInfo pStencilAttachment(@Nullable IVkRenderingAttachmentInfo value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pStencilAttachmentRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkRenderingAttachmentInfo.Ptr pStencilAttachment(int assumedCount) {
        MemorySegment s = pStencilAttachmentRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkRenderingAttachmentInfo.BYTES);
        return new VkRenderingAttachmentInfo.Ptr(s);
    }

    public @Nullable VkRenderingAttachmentInfo pStencilAttachment() {
        MemorySegment s = pStencilAttachmentRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkRenderingAttachmentInfo(s);
    }

    public @Pointer(target=VkRenderingAttachmentInfo.class) @NotNull MemorySegment pStencilAttachmentRaw() {
        return segment.get(LAYOUT$pStencilAttachment, OFFSET$pStencilAttachment);
    }

    public void pStencilAttachmentRaw(@Pointer(target=VkRenderingAttachmentInfo.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pStencilAttachment, OFFSET$pStencilAttachment, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        VkRect2D.LAYOUT.withName("renderArea"),
        ValueLayout.JAVA_INT.withName("layerCount"),
        ValueLayout.JAVA_INT.withName("viewMask"),
        ValueLayout.JAVA_INT.withName("colorAttachmentCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkRenderingAttachmentInfo.LAYOUT).withName("pColorAttachments"),
        ValueLayout.ADDRESS.withTargetLayout(VkRenderingAttachmentInfo.LAYOUT).withName("pDepthAttachment"),
        ValueLayout.ADDRESS.withTargetLayout(VkRenderingAttachmentInfo.LAYOUT).withName("pStencilAttachment")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$renderArea = PathElement.groupElement("renderArea");
    public static final PathElement PATH$layerCount = PathElement.groupElement("layerCount");
    public static final PathElement PATH$viewMask = PathElement.groupElement("viewMask");
    public static final PathElement PATH$colorAttachmentCount = PathElement.groupElement("colorAttachmentCount");
    public static final PathElement PATH$pColorAttachments = PathElement.groupElement("pColorAttachments");
    public static final PathElement PATH$pDepthAttachment = PathElement.groupElement("pDepthAttachment");
    public static final PathElement PATH$pStencilAttachment = PathElement.groupElement("pStencilAttachment");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final StructLayout LAYOUT$renderArea = (StructLayout) LAYOUT.select(PATH$renderArea);
    public static final OfInt LAYOUT$layerCount = (OfInt) LAYOUT.select(PATH$layerCount);
    public static final OfInt LAYOUT$viewMask = (OfInt) LAYOUT.select(PATH$viewMask);
    public static final OfInt LAYOUT$colorAttachmentCount = (OfInt) LAYOUT.select(PATH$colorAttachmentCount);
    public static final AddressLayout LAYOUT$pColorAttachments = (AddressLayout) LAYOUT.select(PATH$pColorAttachments);
    public static final AddressLayout LAYOUT$pDepthAttachment = (AddressLayout) LAYOUT.select(PATH$pDepthAttachment);
    public static final AddressLayout LAYOUT$pStencilAttachment = (AddressLayout) LAYOUT.select(PATH$pStencilAttachment);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$renderArea = LAYOUT$renderArea.byteSize();
    public static final long SIZE$layerCount = LAYOUT$layerCount.byteSize();
    public static final long SIZE$viewMask = LAYOUT$viewMask.byteSize();
    public static final long SIZE$colorAttachmentCount = LAYOUT$colorAttachmentCount.byteSize();
    public static final long SIZE$pColorAttachments = LAYOUT$pColorAttachments.byteSize();
    public static final long SIZE$pDepthAttachment = LAYOUT$pDepthAttachment.byteSize();
    public static final long SIZE$pStencilAttachment = LAYOUT$pStencilAttachment.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$renderArea = LAYOUT.byteOffset(PATH$renderArea);
    public static final long OFFSET$layerCount = LAYOUT.byteOffset(PATH$layerCount);
    public static final long OFFSET$viewMask = LAYOUT.byteOffset(PATH$viewMask);
    public static final long OFFSET$colorAttachmentCount = LAYOUT.byteOffset(PATH$colorAttachmentCount);
    public static final long OFFSET$pColorAttachments = LAYOUT.byteOffset(PATH$pColorAttachments);
    public static final long OFFSET$pDepthAttachment = LAYOUT.byteOffset(PATH$pDepthAttachment);
    public static final long OFFSET$pStencilAttachment = LAYOUT.byteOffset(PATH$pStencilAttachment);
}
