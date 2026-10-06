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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSubpassDescriptionDepthStencilResolve.html"><code>VkSubpassDescriptionDepthStencilResolve</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkSubpassDescriptionDepthStencilResolve {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkResolveModeFlags depthResolveMode; // @link substring="VkResolveModeFlags" target="VkResolveModeFlags" @link substring="depthResolveMode" target="#depthResolveMode"
///     VkResolveModeFlags stencilResolveMode; // @link substring="VkResolveModeFlags" target="VkResolveModeFlags" @link substring="stencilResolveMode" target="#stencilResolveMode"
///     VkAttachmentReference2 const* pDepthStencilResolveAttachment; // optional // @link substring="VkAttachmentReference2" target="VkAttachmentReference2" @link substring="pDepthStencilResolveAttachment" target="#pDepthStencilResolveAttachment"
/// } VkSubpassDescriptionDepthStencilResolve;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_SUBPASS_DESCRIPTION_DEPTH_STENCIL_RESOLVE`
///
/// The {@code allocate} ({@link VkSubpassDescriptionDepthStencilResolve#allocate(Arena)}, {@link VkSubpassDescriptionDepthStencilResolve#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkSubpassDescriptionDepthStencilResolve#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSubpassDescriptionDepthStencilResolve.html"><code>VkSubpassDescriptionDepthStencilResolve</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkSubpassDescriptionDepthStencilResolve(@NotNull MemorySegment segment) implements IVkSubpassDescriptionDepthStencilResolve {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSubpassDescriptionDepthStencilResolve.html"><code>VkSubpassDescriptionDepthStencilResolve</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkSubpassDescriptionDepthStencilResolve}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkSubpassDescriptionDepthStencilResolve to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkSubpassDescriptionDepthStencilResolve.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkSubpassDescriptionDepthStencilResolve, Iterable<VkSubpassDescriptionDepthStencilResolve> {
        public long size() {
            return segment.byteSize() / VkSubpassDescriptionDepthStencilResolve.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkSubpassDescriptionDepthStencilResolve at(long index) {
            return new VkSubpassDescriptionDepthStencilResolve(segment.asSlice(index * VkSubpassDescriptionDepthStencilResolve.BYTES, VkSubpassDescriptionDepthStencilResolve.BYTES));
        }

        public VkSubpassDescriptionDepthStencilResolve.Ptr at(long index, @NotNull Consumer<@NotNull VkSubpassDescriptionDepthStencilResolve> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkSubpassDescriptionDepthStencilResolve value) {
            MemorySegment s = segment.asSlice(index * VkSubpassDescriptionDepthStencilResolve.BYTES, VkSubpassDescriptionDepthStencilResolve.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkSubpassDescriptionDepthStencilResolve.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkSubpassDescriptionDepthStencilResolve.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkSubpassDescriptionDepthStencilResolve.BYTES,
                (end - start) * VkSubpassDescriptionDepthStencilResolve.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkSubpassDescriptionDepthStencilResolve.BYTES));
        }

        public VkSubpassDescriptionDepthStencilResolve[] toArray() {
            VkSubpassDescriptionDepthStencilResolve[] ret = new VkSubpassDescriptionDepthStencilResolve[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkSubpassDescriptionDepthStencilResolve> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkSubpassDescriptionDepthStencilResolve> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkSubpassDescriptionDepthStencilResolve.BYTES;
            }

            @Override
            public VkSubpassDescriptionDepthStencilResolve next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkSubpassDescriptionDepthStencilResolve ret = new VkSubpassDescriptionDepthStencilResolve(segment.asSlice(0, VkSubpassDescriptionDepthStencilResolve.BYTES));
                segment = segment.asSlice(VkSubpassDescriptionDepthStencilResolve.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkSubpassDescriptionDepthStencilResolve allocate(Arena arena) {
        VkSubpassDescriptionDepthStencilResolve ret = new VkSubpassDescriptionDepthStencilResolve(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.SUBPASS_DESCRIPTION_DEPTH_STENCIL_RESOLVE);
        return ret;
    }

    public static VkSubpassDescriptionDepthStencilResolve.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkSubpassDescriptionDepthStencilResolve.Ptr ret = new VkSubpassDescriptionDepthStencilResolve.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.SUBPASS_DESCRIPTION_DEPTH_STENCIL_RESOLVE);
        }
        return ret;
    }

    public static VkSubpassDescriptionDepthStencilResolve clone(Arena arena, VkSubpassDescriptionDepthStencilResolve src) {
        VkSubpassDescriptionDepthStencilResolve ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.SUBPASS_DESCRIPTION_DEPTH_STENCIL_RESOLVE);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkSubpassDescriptionDepthStencilResolve sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkSubpassDescriptionDepthStencilResolve pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkSubpassDescriptionDepthStencilResolve pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkResolveModeFlags.class) int depthResolveMode() {
        return segment.get(LAYOUT$depthResolveMode, OFFSET$depthResolveMode);
    }

    public VkSubpassDescriptionDepthStencilResolve depthResolveMode(@Bitmask(VkResolveModeFlags.class) int value) {
        segment.set(LAYOUT$depthResolveMode, OFFSET$depthResolveMode, value);
        return this;
    }

    public @Bitmask(VkResolveModeFlags.class) int stencilResolveMode() {
        return segment.get(LAYOUT$stencilResolveMode, OFFSET$stencilResolveMode);
    }

    public VkSubpassDescriptionDepthStencilResolve stencilResolveMode(@Bitmask(VkResolveModeFlags.class) int value) {
        segment.set(LAYOUT$stencilResolveMode, OFFSET$stencilResolveMode, value);
        return this;
    }

    public VkSubpassDescriptionDepthStencilResolve pDepthStencilResolveAttachment(@Nullable IVkAttachmentReference2 value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pDepthStencilResolveAttachmentRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkAttachmentReference2.Ptr pDepthStencilResolveAttachment(int assumedCount) {
        MemorySegment s = pDepthStencilResolveAttachmentRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkAttachmentReference2.BYTES);
        return new VkAttachmentReference2.Ptr(s);
    }

    public @Nullable VkAttachmentReference2 pDepthStencilResolveAttachment() {
        MemorySegment s = pDepthStencilResolveAttachmentRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkAttachmentReference2(s);
    }

    public @Pointer(target=VkAttachmentReference2.class) @NotNull MemorySegment pDepthStencilResolveAttachmentRaw() {
        return segment.get(LAYOUT$pDepthStencilResolveAttachment, OFFSET$pDepthStencilResolveAttachment);
    }

    public void pDepthStencilResolveAttachmentRaw(@Pointer(target=VkAttachmentReference2.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pDepthStencilResolveAttachment, OFFSET$pDepthStencilResolveAttachment, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("depthResolveMode"),
        ValueLayout.JAVA_INT.withName("stencilResolveMode"),
        ValueLayout.ADDRESS.withTargetLayout(VkAttachmentReference2.LAYOUT).withName("pDepthStencilResolveAttachment")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$depthResolveMode = PathElement.groupElement("depthResolveMode");
    public static final PathElement PATH$stencilResolveMode = PathElement.groupElement("stencilResolveMode");
    public static final PathElement PATH$pDepthStencilResolveAttachment = PathElement.groupElement("pDepthStencilResolveAttachment");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$depthResolveMode = (OfInt) LAYOUT.select(PATH$depthResolveMode);
    public static final OfInt LAYOUT$stencilResolveMode = (OfInt) LAYOUT.select(PATH$stencilResolveMode);
    public static final AddressLayout LAYOUT$pDepthStencilResolveAttachment = (AddressLayout) LAYOUT.select(PATH$pDepthStencilResolveAttachment);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$depthResolveMode = LAYOUT$depthResolveMode.byteSize();
    public static final long SIZE$stencilResolveMode = LAYOUT$stencilResolveMode.byteSize();
    public static final long SIZE$pDepthStencilResolveAttachment = LAYOUT$pDepthStencilResolveAttachment.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$depthResolveMode = LAYOUT.byteOffset(PATH$depthResolveMode);
    public static final long OFFSET$stencilResolveMode = LAYOUT.byteOffset(PATH$stencilResolveMode);
    public static final long OFFSET$pDepthStencilResolveAttachment = LAYOUT.byteOffset(PATH$pDepthStencilResolveAttachment);
}
