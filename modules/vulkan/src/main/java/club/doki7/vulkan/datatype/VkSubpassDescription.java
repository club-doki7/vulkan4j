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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSubpassDescription.html"><code>VkSubpassDescription</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkSubpassDescription {
///     VkSubpassDescriptionFlags flags; // optional // @link substring="VkSubpassDescriptionFlags" target="VkSubpassDescriptionFlags" @link substring="flags" target="#flags"
///     VkPipelineBindPoint pipelineBindPoint; // @link substring="VkPipelineBindPoint" target="VkPipelineBindPoint" @link substring="pipelineBindPoint" target="#pipelineBindPoint"
///     uint32_t inputAttachmentCount; // optional // @link substring="inputAttachmentCount" target="#inputAttachmentCount"
///     VkAttachmentReference const* pInputAttachments; // optional // @link substring="VkAttachmentReference" target="VkAttachmentReference" @link substring="pInputAttachments" target="#pInputAttachments"
///     uint32_t colorAttachmentCount; // optional // @link substring="colorAttachmentCount" target="#colorAttachmentCount"
///     VkAttachmentReference const* pColorAttachments; // optional // @link substring="VkAttachmentReference" target="VkAttachmentReference" @link substring="pColorAttachments" target="#pColorAttachments"
///     VkAttachmentReference const* pResolveAttachments; // optional // @link substring="VkAttachmentReference" target="VkAttachmentReference" @link substring="pResolveAttachments" target="#pResolveAttachments"
///     VkAttachmentReference const* pDepthStencilAttachment; // optional // @link substring="VkAttachmentReference" target="VkAttachmentReference" @link substring="pDepthStencilAttachment" target="#pDepthStencilAttachment"
///     uint32_t preserveAttachmentCount; // optional // @link substring="preserveAttachmentCount" target="#preserveAttachmentCount"
///     uint32_t const* pPreserveAttachments; // optional // @link substring="pPreserveAttachments" target="#pPreserveAttachments"
/// } VkSubpassDescription;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSubpassDescription.html"><code>VkSubpassDescription</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkSubpassDescription(@NotNull MemorySegment segment) implements IVkSubpassDescription {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSubpassDescription.html"><code>VkSubpassDescription</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkSubpassDescription}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkSubpassDescription to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkSubpassDescription.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkSubpassDescription, Iterable<VkSubpassDescription> {
        public long size() {
            return segment.byteSize() / VkSubpassDescription.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkSubpassDescription at(long index) {
            return new VkSubpassDescription(segment.asSlice(index * VkSubpassDescription.BYTES, VkSubpassDescription.BYTES));
        }

        public VkSubpassDescription.Ptr at(long index, @NotNull Consumer<@NotNull VkSubpassDescription> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkSubpassDescription value) {
            MemorySegment s = segment.asSlice(index * VkSubpassDescription.BYTES, VkSubpassDescription.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkSubpassDescription.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkSubpassDescription.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkSubpassDescription.BYTES,
                (end - start) * VkSubpassDescription.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkSubpassDescription.BYTES));
        }

        public VkSubpassDescription[] toArray() {
            VkSubpassDescription[] ret = new VkSubpassDescription[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkSubpassDescription> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkSubpassDescription> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkSubpassDescription.BYTES;
            }

            @Override
            public VkSubpassDescription next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkSubpassDescription ret = new VkSubpassDescription(segment.asSlice(0, VkSubpassDescription.BYTES));
                segment = segment.asSlice(VkSubpassDescription.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkSubpassDescription allocate(Arena arena) {
        return new VkSubpassDescription(arena.allocate(LAYOUT));
    }

    public static VkSubpassDescription.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkSubpassDescription.Ptr(segment);
    }

    public static VkSubpassDescription clone(Arena arena, VkSubpassDescription src) {
        VkSubpassDescription ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Bitmask(VkSubpassDescriptionFlags.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkSubpassDescription flags(@Bitmask(VkSubpassDescriptionFlags.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @EnumType(VkPipelineBindPoint.class) int pipelineBindPoint() {
        return segment.get(LAYOUT$pipelineBindPoint, OFFSET$pipelineBindPoint);
    }

    public VkSubpassDescription pipelineBindPoint(@EnumType(VkPipelineBindPoint.class) int value) {
        segment.set(LAYOUT$pipelineBindPoint, OFFSET$pipelineBindPoint, value);
        return this;
    }

    public @Unsigned int inputAttachmentCount() {
        return segment.get(LAYOUT$inputAttachmentCount, OFFSET$inputAttachmentCount);
    }

    public VkSubpassDescription inputAttachmentCount(@Unsigned int value) {
        segment.set(LAYOUT$inputAttachmentCount, OFFSET$inputAttachmentCount, value);
        return this;
    }

    public VkSubpassDescription pInputAttachments(@Nullable IVkAttachmentReference value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pInputAttachmentsRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkAttachmentReference.Ptr pInputAttachments(int assumedCount) {
        MemorySegment s = pInputAttachmentsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkAttachmentReference.BYTES);
        return new VkAttachmentReference.Ptr(s);
    }

    public @Nullable VkAttachmentReference pInputAttachments() {
        MemorySegment s = pInputAttachmentsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkAttachmentReference(s);
    }

    public @Pointer(target=VkAttachmentReference.class) @NotNull MemorySegment pInputAttachmentsRaw() {
        return segment.get(LAYOUT$pInputAttachments, OFFSET$pInputAttachments);
    }

    public void pInputAttachmentsRaw(@Pointer(target=VkAttachmentReference.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pInputAttachments, OFFSET$pInputAttachments, value);
    }

    public @Unsigned int colorAttachmentCount() {
        return segment.get(LAYOUT$colorAttachmentCount, OFFSET$colorAttachmentCount);
    }

    public VkSubpassDescription colorAttachmentCount(@Unsigned int value) {
        segment.set(LAYOUT$colorAttachmentCount, OFFSET$colorAttachmentCount, value);
        return this;
    }

    public VkSubpassDescription pColorAttachments(@Nullable IVkAttachmentReference value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pColorAttachmentsRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkAttachmentReference.Ptr pColorAttachments(int assumedCount) {
        MemorySegment s = pColorAttachmentsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkAttachmentReference.BYTES);
        return new VkAttachmentReference.Ptr(s);
    }

    public @Nullable VkAttachmentReference pColorAttachments() {
        MemorySegment s = pColorAttachmentsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkAttachmentReference(s);
    }

    public @Pointer(target=VkAttachmentReference.class) @NotNull MemorySegment pColorAttachmentsRaw() {
        return segment.get(LAYOUT$pColorAttachments, OFFSET$pColorAttachments);
    }

    public void pColorAttachmentsRaw(@Pointer(target=VkAttachmentReference.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pColorAttachments, OFFSET$pColorAttachments, value);
    }

    public VkSubpassDescription pResolveAttachments(@Nullable IVkAttachmentReference value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pResolveAttachmentsRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkAttachmentReference.Ptr pResolveAttachments(int assumedCount) {
        MemorySegment s = pResolveAttachmentsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkAttachmentReference.BYTES);
        return new VkAttachmentReference.Ptr(s);
    }

    public @Nullable VkAttachmentReference pResolveAttachments() {
        MemorySegment s = pResolveAttachmentsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkAttachmentReference(s);
    }

    public @Pointer(target=VkAttachmentReference.class) @NotNull MemorySegment pResolveAttachmentsRaw() {
        return segment.get(LAYOUT$pResolveAttachments, OFFSET$pResolveAttachments);
    }

    public void pResolveAttachmentsRaw(@Pointer(target=VkAttachmentReference.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pResolveAttachments, OFFSET$pResolveAttachments, value);
    }

    public VkSubpassDescription pDepthStencilAttachment(@Nullable IVkAttachmentReference value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pDepthStencilAttachmentRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkAttachmentReference.Ptr pDepthStencilAttachment(int assumedCount) {
        MemorySegment s = pDepthStencilAttachmentRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkAttachmentReference.BYTES);
        return new VkAttachmentReference.Ptr(s);
    }

    public @Nullable VkAttachmentReference pDepthStencilAttachment() {
        MemorySegment s = pDepthStencilAttachmentRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkAttachmentReference(s);
    }

    public @Pointer(target=VkAttachmentReference.class) @NotNull MemorySegment pDepthStencilAttachmentRaw() {
        return segment.get(LAYOUT$pDepthStencilAttachment, OFFSET$pDepthStencilAttachment);
    }

    public void pDepthStencilAttachmentRaw(@Pointer(target=VkAttachmentReference.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pDepthStencilAttachment, OFFSET$pDepthStencilAttachment, value);
    }

    public @Unsigned int preserveAttachmentCount() {
        return segment.get(LAYOUT$preserveAttachmentCount, OFFSET$preserveAttachmentCount);
    }

    public VkSubpassDescription preserveAttachmentCount(@Unsigned int value) {
        segment.set(LAYOUT$preserveAttachmentCount, OFFSET$preserveAttachmentCount, value);
        return this;
    }

    /// Note: the returned {@link IntPtr} does not have correct
    /// {@link IntPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link IntPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable @Unsigned IntPtr pPreserveAttachments() {
        MemorySegment s = pPreserveAttachmentsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new IntPtr(s);
    }

    public VkSubpassDescription pPreserveAttachments(@Nullable @Unsigned IntPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pPreserveAttachmentsRaw(s);
        return this;
    }

    public @Pointer(comment="uint32_t*") @NotNull MemorySegment pPreserveAttachmentsRaw() {
        return segment.get(LAYOUT$pPreserveAttachments, OFFSET$pPreserveAttachments);
    }

    public void pPreserveAttachmentsRaw(@Pointer(comment="uint32_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pPreserveAttachments, OFFSET$pPreserveAttachments, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("pipelineBindPoint"),
        ValueLayout.JAVA_INT.withName("inputAttachmentCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkAttachmentReference.LAYOUT).withName("pInputAttachments"),
        ValueLayout.JAVA_INT.withName("colorAttachmentCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkAttachmentReference.LAYOUT).withName("pColorAttachments"),
        ValueLayout.ADDRESS.withTargetLayout(VkAttachmentReference.LAYOUT).withName("pResolveAttachments"),
        ValueLayout.ADDRESS.withTargetLayout(VkAttachmentReference.LAYOUT).withName("pDepthStencilAttachment"),
        ValueLayout.JAVA_INT.withName("preserveAttachmentCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pPreserveAttachments")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$pipelineBindPoint = PathElement.groupElement("pipelineBindPoint");
    public static final PathElement PATH$inputAttachmentCount = PathElement.groupElement("inputAttachmentCount");
    public static final PathElement PATH$pInputAttachments = PathElement.groupElement("pInputAttachments");
    public static final PathElement PATH$colorAttachmentCount = PathElement.groupElement("colorAttachmentCount");
    public static final PathElement PATH$pColorAttachments = PathElement.groupElement("pColorAttachments");
    public static final PathElement PATH$pResolveAttachments = PathElement.groupElement("pResolveAttachments");
    public static final PathElement PATH$pDepthStencilAttachment = PathElement.groupElement("pDepthStencilAttachment");
    public static final PathElement PATH$preserveAttachmentCount = PathElement.groupElement("preserveAttachmentCount");
    public static final PathElement PATH$pPreserveAttachments = PathElement.groupElement("pPreserveAttachments");

    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$pipelineBindPoint = (OfInt) LAYOUT.select(PATH$pipelineBindPoint);
    public static final OfInt LAYOUT$inputAttachmentCount = (OfInt) LAYOUT.select(PATH$inputAttachmentCount);
    public static final AddressLayout LAYOUT$pInputAttachments = (AddressLayout) LAYOUT.select(PATH$pInputAttachments);
    public static final OfInt LAYOUT$colorAttachmentCount = (OfInt) LAYOUT.select(PATH$colorAttachmentCount);
    public static final AddressLayout LAYOUT$pColorAttachments = (AddressLayout) LAYOUT.select(PATH$pColorAttachments);
    public static final AddressLayout LAYOUT$pResolveAttachments = (AddressLayout) LAYOUT.select(PATH$pResolveAttachments);
    public static final AddressLayout LAYOUT$pDepthStencilAttachment = (AddressLayout) LAYOUT.select(PATH$pDepthStencilAttachment);
    public static final OfInt LAYOUT$preserveAttachmentCount = (OfInt) LAYOUT.select(PATH$preserveAttachmentCount);
    public static final AddressLayout LAYOUT$pPreserveAttachments = (AddressLayout) LAYOUT.select(PATH$pPreserveAttachments);

    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$pipelineBindPoint = LAYOUT$pipelineBindPoint.byteSize();
    public static final long SIZE$inputAttachmentCount = LAYOUT$inputAttachmentCount.byteSize();
    public static final long SIZE$pInputAttachments = LAYOUT$pInputAttachments.byteSize();
    public static final long SIZE$colorAttachmentCount = LAYOUT$colorAttachmentCount.byteSize();
    public static final long SIZE$pColorAttachments = LAYOUT$pColorAttachments.byteSize();
    public static final long SIZE$pResolveAttachments = LAYOUT$pResolveAttachments.byteSize();
    public static final long SIZE$pDepthStencilAttachment = LAYOUT$pDepthStencilAttachment.byteSize();
    public static final long SIZE$preserveAttachmentCount = LAYOUT$preserveAttachmentCount.byteSize();
    public static final long SIZE$pPreserveAttachments = LAYOUT$pPreserveAttachments.byteSize();

    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$pipelineBindPoint = LAYOUT.byteOffset(PATH$pipelineBindPoint);
    public static final long OFFSET$inputAttachmentCount = LAYOUT.byteOffset(PATH$inputAttachmentCount);
    public static final long OFFSET$pInputAttachments = LAYOUT.byteOffset(PATH$pInputAttachments);
    public static final long OFFSET$colorAttachmentCount = LAYOUT.byteOffset(PATH$colorAttachmentCount);
    public static final long OFFSET$pColorAttachments = LAYOUT.byteOffset(PATH$pColorAttachments);
    public static final long OFFSET$pResolveAttachments = LAYOUT.byteOffset(PATH$pResolveAttachments);
    public static final long OFFSET$pDepthStencilAttachment = LAYOUT.byteOffset(PATH$pDepthStencilAttachment);
    public static final long OFFSET$preserveAttachmentCount = LAYOUT.byteOffset(PATH$preserveAttachmentCount);
    public static final long OFFSET$pPreserveAttachments = LAYOUT.byteOffset(PATH$pPreserveAttachments);
}
