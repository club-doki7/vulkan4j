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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRenderPassCreateInfo2.html"><code>VkRenderPassCreateInfo2</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkRenderPassCreateInfo2 {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkRenderPassCreateFlags flags; // optional // @link substring="VkRenderPassCreateFlags" target="VkRenderPassCreateFlags" @link substring="flags" target="#flags"
///     uint32_t attachmentCount; // optional // @link substring="attachmentCount" target="#attachmentCount"
///     VkAttachmentDescription2 const* pAttachments; // optional // @link substring="VkAttachmentDescription2" target="VkAttachmentDescription2" @link substring="pAttachments" target="#pAttachments"
///     uint32_t subpassCount; // @link substring="subpassCount" target="#subpassCount"
///     VkSubpassDescription2 const* pSubpasses; // @link substring="VkSubpassDescription2" target="VkSubpassDescription2" @link substring="pSubpasses" target="#pSubpasses"
///     uint32_t dependencyCount; // optional // @link substring="dependencyCount" target="#dependencyCount"
///     VkSubpassDependency2 const* pDependencies; // optional // @link substring="VkSubpassDependency2" target="VkSubpassDependency2" @link substring="pDependencies" target="#pDependencies"
///     uint32_t correlatedViewMaskCount; // optional // @link substring="correlatedViewMaskCount" target="#correlatedViewMaskCount"
///     uint32_t const* pCorrelatedViewMasks; // optional // @link substring="pCorrelatedViewMasks" target="#pCorrelatedViewMasks"
/// } VkRenderPassCreateInfo2;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_RENDER_PASS_CREATE_INFO_2`
///
/// The {@code allocate} ({@link VkRenderPassCreateInfo2#allocate(Arena)}, {@link VkRenderPassCreateInfo2#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkRenderPassCreateInfo2#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRenderPassCreateInfo2.html"><code>VkRenderPassCreateInfo2</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkRenderPassCreateInfo2(@NotNull MemorySegment segment) implements IVkRenderPassCreateInfo2 {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRenderPassCreateInfo2.html"><code>VkRenderPassCreateInfo2</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkRenderPassCreateInfo2}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkRenderPassCreateInfo2 to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkRenderPassCreateInfo2.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkRenderPassCreateInfo2, Iterable<VkRenderPassCreateInfo2> {
        public long size() {
            return segment.byteSize() / VkRenderPassCreateInfo2.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkRenderPassCreateInfo2 at(long index) {
            return new VkRenderPassCreateInfo2(segment.asSlice(index * VkRenderPassCreateInfo2.BYTES, VkRenderPassCreateInfo2.BYTES));
        }

        public VkRenderPassCreateInfo2.Ptr at(long index, @NotNull Consumer<@NotNull VkRenderPassCreateInfo2> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkRenderPassCreateInfo2 value) {
            MemorySegment s = segment.asSlice(index * VkRenderPassCreateInfo2.BYTES, VkRenderPassCreateInfo2.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkRenderPassCreateInfo2.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkRenderPassCreateInfo2.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkRenderPassCreateInfo2.BYTES,
                (end - start) * VkRenderPassCreateInfo2.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkRenderPassCreateInfo2.BYTES));
        }

        public VkRenderPassCreateInfo2[] toArray() {
            VkRenderPassCreateInfo2[] ret = new VkRenderPassCreateInfo2[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkRenderPassCreateInfo2> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkRenderPassCreateInfo2> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkRenderPassCreateInfo2.BYTES;
            }

            @Override
            public VkRenderPassCreateInfo2 next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkRenderPassCreateInfo2 ret = new VkRenderPassCreateInfo2(segment.asSlice(0, VkRenderPassCreateInfo2.BYTES));
                segment = segment.asSlice(VkRenderPassCreateInfo2.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkRenderPassCreateInfo2 allocate(Arena arena) {
        VkRenderPassCreateInfo2 ret = new VkRenderPassCreateInfo2(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.RENDER_PASS_CREATE_INFO_2);
        return ret;
    }

    public static VkRenderPassCreateInfo2.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkRenderPassCreateInfo2.Ptr ret = new VkRenderPassCreateInfo2.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.RENDER_PASS_CREATE_INFO_2);
        }
        return ret;
    }

    public static VkRenderPassCreateInfo2 clone(Arena arena, VkRenderPassCreateInfo2 src) {
        VkRenderPassCreateInfo2 ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.RENDER_PASS_CREATE_INFO_2);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkRenderPassCreateInfo2 sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkRenderPassCreateInfo2 pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkRenderPassCreateInfo2 pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkRenderPassCreateFlags.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkRenderPassCreateInfo2 flags(@Bitmask(VkRenderPassCreateFlags.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @Unsigned int attachmentCount() {
        return segment.get(LAYOUT$attachmentCount, OFFSET$attachmentCount);
    }

    public VkRenderPassCreateInfo2 attachmentCount(@Unsigned int value) {
        segment.set(LAYOUT$attachmentCount, OFFSET$attachmentCount, value);
        return this;
    }

    public VkRenderPassCreateInfo2 pAttachments(@Nullable IVkAttachmentDescription2 value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pAttachmentsRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkAttachmentDescription2.Ptr pAttachments(int assumedCount) {
        MemorySegment s = pAttachmentsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkAttachmentDescription2.BYTES);
        return new VkAttachmentDescription2.Ptr(s);
    }

    public @Nullable VkAttachmentDescription2 pAttachments() {
        MemorySegment s = pAttachmentsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkAttachmentDescription2(s);
    }

    public @Pointer(target=VkAttachmentDescription2.class) @NotNull MemorySegment pAttachmentsRaw() {
        return segment.get(LAYOUT$pAttachments, OFFSET$pAttachments);
    }

    public void pAttachmentsRaw(@Pointer(target=VkAttachmentDescription2.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pAttachments, OFFSET$pAttachments, value);
    }

    public @Unsigned int subpassCount() {
        return segment.get(LAYOUT$subpassCount, OFFSET$subpassCount);
    }

    public VkRenderPassCreateInfo2 subpassCount(@Unsigned int value) {
        segment.set(LAYOUT$subpassCount, OFFSET$subpassCount, value);
        return this;
    }

    public VkRenderPassCreateInfo2 pSubpasses(@Nullable IVkSubpassDescription2 value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pSubpassesRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkSubpassDescription2.Ptr pSubpasses(int assumedCount) {
        MemorySegment s = pSubpassesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkSubpassDescription2.BYTES);
        return new VkSubpassDescription2.Ptr(s);
    }

    public @Nullable VkSubpassDescription2 pSubpasses() {
        MemorySegment s = pSubpassesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkSubpassDescription2(s);
    }

    public @Pointer(target=VkSubpassDescription2.class) @NotNull MemorySegment pSubpassesRaw() {
        return segment.get(LAYOUT$pSubpasses, OFFSET$pSubpasses);
    }

    public void pSubpassesRaw(@Pointer(target=VkSubpassDescription2.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pSubpasses, OFFSET$pSubpasses, value);
    }

    public @Unsigned int dependencyCount() {
        return segment.get(LAYOUT$dependencyCount, OFFSET$dependencyCount);
    }

    public VkRenderPassCreateInfo2 dependencyCount(@Unsigned int value) {
        segment.set(LAYOUT$dependencyCount, OFFSET$dependencyCount, value);
        return this;
    }

    public VkRenderPassCreateInfo2 pDependencies(@Nullable IVkSubpassDependency2 value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pDependenciesRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkSubpassDependency2.Ptr pDependencies(int assumedCount) {
        MemorySegment s = pDependenciesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkSubpassDependency2.BYTES);
        return new VkSubpassDependency2.Ptr(s);
    }

    public @Nullable VkSubpassDependency2 pDependencies() {
        MemorySegment s = pDependenciesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkSubpassDependency2(s);
    }

    public @Pointer(target=VkSubpassDependency2.class) @NotNull MemorySegment pDependenciesRaw() {
        return segment.get(LAYOUT$pDependencies, OFFSET$pDependencies);
    }

    public void pDependenciesRaw(@Pointer(target=VkSubpassDependency2.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pDependencies, OFFSET$pDependencies, value);
    }

    public @Unsigned int correlatedViewMaskCount() {
        return segment.get(LAYOUT$correlatedViewMaskCount, OFFSET$correlatedViewMaskCount);
    }

    public VkRenderPassCreateInfo2 correlatedViewMaskCount(@Unsigned int value) {
        segment.set(LAYOUT$correlatedViewMaskCount, OFFSET$correlatedViewMaskCount, value);
        return this;
    }

    /// Note: the returned {@link IntPtr} does not have correct
    /// {@link IntPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link IntPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable @Unsigned IntPtr pCorrelatedViewMasks() {
        MemorySegment s = pCorrelatedViewMasksRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new IntPtr(s);
    }

    public VkRenderPassCreateInfo2 pCorrelatedViewMasks(@Nullable @Unsigned IntPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pCorrelatedViewMasksRaw(s);
        return this;
    }

    public @Pointer(comment="uint32_t*") @NotNull MemorySegment pCorrelatedViewMasksRaw() {
        return segment.get(LAYOUT$pCorrelatedViewMasks, OFFSET$pCorrelatedViewMasks);
    }

    public void pCorrelatedViewMasksRaw(@Pointer(comment="uint32_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pCorrelatedViewMasks, OFFSET$pCorrelatedViewMasks, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("attachmentCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkAttachmentDescription2.LAYOUT).withName("pAttachments"),
        ValueLayout.JAVA_INT.withName("subpassCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkSubpassDescription2.LAYOUT).withName("pSubpasses"),
        ValueLayout.JAVA_INT.withName("dependencyCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkSubpassDependency2.LAYOUT).withName("pDependencies"),
        ValueLayout.JAVA_INT.withName("correlatedViewMaskCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pCorrelatedViewMasks")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$attachmentCount = PathElement.groupElement("attachmentCount");
    public static final PathElement PATH$pAttachments = PathElement.groupElement("pAttachments");
    public static final PathElement PATH$subpassCount = PathElement.groupElement("subpassCount");
    public static final PathElement PATH$pSubpasses = PathElement.groupElement("pSubpasses");
    public static final PathElement PATH$dependencyCount = PathElement.groupElement("dependencyCount");
    public static final PathElement PATH$pDependencies = PathElement.groupElement("pDependencies");
    public static final PathElement PATH$correlatedViewMaskCount = PathElement.groupElement("correlatedViewMaskCount");
    public static final PathElement PATH$pCorrelatedViewMasks = PathElement.groupElement("pCorrelatedViewMasks");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$attachmentCount = (OfInt) LAYOUT.select(PATH$attachmentCount);
    public static final AddressLayout LAYOUT$pAttachments = (AddressLayout) LAYOUT.select(PATH$pAttachments);
    public static final OfInt LAYOUT$subpassCount = (OfInt) LAYOUT.select(PATH$subpassCount);
    public static final AddressLayout LAYOUT$pSubpasses = (AddressLayout) LAYOUT.select(PATH$pSubpasses);
    public static final OfInt LAYOUT$dependencyCount = (OfInt) LAYOUT.select(PATH$dependencyCount);
    public static final AddressLayout LAYOUT$pDependencies = (AddressLayout) LAYOUT.select(PATH$pDependencies);
    public static final OfInt LAYOUT$correlatedViewMaskCount = (OfInt) LAYOUT.select(PATH$correlatedViewMaskCount);
    public static final AddressLayout LAYOUT$pCorrelatedViewMasks = (AddressLayout) LAYOUT.select(PATH$pCorrelatedViewMasks);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$attachmentCount = LAYOUT$attachmentCount.byteSize();
    public static final long SIZE$pAttachments = LAYOUT$pAttachments.byteSize();
    public static final long SIZE$subpassCount = LAYOUT$subpassCount.byteSize();
    public static final long SIZE$pSubpasses = LAYOUT$pSubpasses.byteSize();
    public static final long SIZE$dependencyCount = LAYOUT$dependencyCount.byteSize();
    public static final long SIZE$pDependencies = LAYOUT$pDependencies.byteSize();
    public static final long SIZE$correlatedViewMaskCount = LAYOUT$correlatedViewMaskCount.byteSize();
    public static final long SIZE$pCorrelatedViewMasks = LAYOUT$pCorrelatedViewMasks.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$attachmentCount = LAYOUT.byteOffset(PATH$attachmentCount);
    public static final long OFFSET$pAttachments = LAYOUT.byteOffset(PATH$pAttachments);
    public static final long OFFSET$subpassCount = LAYOUT.byteOffset(PATH$subpassCount);
    public static final long OFFSET$pSubpasses = LAYOUT.byteOffset(PATH$pSubpasses);
    public static final long OFFSET$dependencyCount = LAYOUT.byteOffset(PATH$dependencyCount);
    public static final long OFFSET$pDependencies = LAYOUT.byteOffset(PATH$pDependencies);
    public static final long OFFSET$correlatedViewMaskCount = LAYOUT.byteOffset(PATH$correlatedViewMaskCount);
    public static final long OFFSET$pCorrelatedViewMasks = LAYOUT.byteOffset(PATH$pCorrelatedViewMasks);
}
