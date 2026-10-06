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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkFramebufferAttachmentsCreateInfo.html"><code>VkFramebufferAttachmentsCreateInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkFramebufferAttachmentsCreateInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t attachmentImageInfoCount; // optional // @link substring="attachmentImageInfoCount" target="#attachmentImageInfoCount"
///     VkFramebufferAttachmentImageInfo const* pAttachmentImageInfos; // optional // @link substring="VkFramebufferAttachmentImageInfo" target="VkFramebufferAttachmentImageInfo" @link substring="pAttachmentImageInfos" target="#pAttachmentImageInfos"
/// } VkFramebufferAttachmentsCreateInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_FRAMEBUFFER_ATTACHMENTS_CREATE_INFO`
///
/// The {@code allocate} ({@link VkFramebufferAttachmentsCreateInfo#allocate(Arena)}, {@link VkFramebufferAttachmentsCreateInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkFramebufferAttachmentsCreateInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkFramebufferAttachmentsCreateInfo.html"><code>VkFramebufferAttachmentsCreateInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkFramebufferAttachmentsCreateInfo(@NotNull MemorySegment segment) implements IVkFramebufferAttachmentsCreateInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkFramebufferAttachmentsCreateInfo.html"><code>VkFramebufferAttachmentsCreateInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkFramebufferAttachmentsCreateInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkFramebufferAttachmentsCreateInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkFramebufferAttachmentsCreateInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkFramebufferAttachmentsCreateInfo, Iterable<VkFramebufferAttachmentsCreateInfo> {
        public long size() {
            return segment.byteSize() / VkFramebufferAttachmentsCreateInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkFramebufferAttachmentsCreateInfo at(long index) {
            return new VkFramebufferAttachmentsCreateInfo(segment.asSlice(index * VkFramebufferAttachmentsCreateInfo.BYTES, VkFramebufferAttachmentsCreateInfo.BYTES));
        }

        public VkFramebufferAttachmentsCreateInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkFramebufferAttachmentsCreateInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkFramebufferAttachmentsCreateInfo value) {
            MemorySegment s = segment.asSlice(index * VkFramebufferAttachmentsCreateInfo.BYTES, VkFramebufferAttachmentsCreateInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkFramebufferAttachmentsCreateInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkFramebufferAttachmentsCreateInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkFramebufferAttachmentsCreateInfo.BYTES,
                (end - start) * VkFramebufferAttachmentsCreateInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkFramebufferAttachmentsCreateInfo.BYTES));
        }

        public VkFramebufferAttachmentsCreateInfo[] toArray() {
            VkFramebufferAttachmentsCreateInfo[] ret = new VkFramebufferAttachmentsCreateInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkFramebufferAttachmentsCreateInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkFramebufferAttachmentsCreateInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkFramebufferAttachmentsCreateInfo.BYTES;
            }

            @Override
            public VkFramebufferAttachmentsCreateInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkFramebufferAttachmentsCreateInfo ret = new VkFramebufferAttachmentsCreateInfo(segment.asSlice(0, VkFramebufferAttachmentsCreateInfo.BYTES));
                segment = segment.asSlice(VkFramebufferAttachmentsCreateInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkFramebufferAttachmentsCreateInfo allocate(Arena arena) {
        VkFramebufferAttachmentsCreateInfo ret = new VkFramebufferAttachmentsCreateInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.FRAMEBUFFER_ATTACHMENTS_CREATE_INFO);
        return ret;
    }

    public static VkFramebufferAttachmentsCreateInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkFramebufferAttachmentsCreateInfo.Ptr ret = new VkFramebufferAttachmentsCreateInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.FRAMEBUFFER_ATTACHMENTS_CREATE_INFO);
        }
        return ret;
    }

    public static VkFramebufferAttachmentsCreateInfo clone(Arena arena, VkFramebufferAttachmentsCreateInfo src) {
        VkFramebufferAttachmentsCreateInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.FRAMEBUFFER_ATTACHMENTS_CREATE_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkFramebufferAttachmentsCreateInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkFramebufferAttachmentsCreateInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkFramebufferAttachmentsCreateInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int attachmentImageInfoCount() {
        return segment.get(LAYOUT$attachmentImageInfoCount, OFFSET$attachmentImageInfoCount);
    }

    public VkFramebufferAttachmentsCreateInfo attachmentImageInfoCount(@Unsigned int value) {
        segment.set(LAYOUT$attachmentImageInfoCount, OFFSET$attachmentImageInfoCount, value);
        return this;
    }

    public VkFramebufferAttachmentsCreateInfo pAttachmentImageInfos(@Nullable IVkFramebufferAttachmentImageInfo value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pAttachmentImageInfosRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkFramebufferAttachmentImageInfo.Ptr pAttachmentImageInfos(int assumedCount) {
        MemorySegment s = pAttachmentImageInfosRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkFramebufferAttachmentImageInfo.BYTES);
        return new VkFramebufferAttachmentImageInfo.Ptr(s);
    }

    public @Nullable VkFramebufferAttachmentImageInfo pAttachmentImageInfos() {
        MemorySegment s = pAttachmentImageInfosRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkFramebufferAttachmentImageInfo(s);
    }

    public @Pointer(target=VkFramebufferAttachmentImageInfo.class) @NotNull MemorySegment pAttachmentImageInfosRaw() {
        return segment.get(LAYOUT$pAttachmentImageInfos, OFFSET$pAttachmentImageInfos);
    }

    public void pAttachmentImageInfosRaw(@Pointer(target=VkFramebufferAttachmentImageInfo.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pAttachmentImageInfos, OFFSET$pAttachmentImageInfos, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("attachmentImageInfoCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkFramebufferAttachmentImageInfo.LAYOUT).withName("pAttachmentImageInfos")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$attachmentImageInfoCount = PathElement.groupElement("attachmentImageInfoCount");
    public static final PathElement PATH$pAttachmentImageInfos = PathElement.groupElement("pAttachmentImageInfos");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$attachmentImageInfoCount = (OfInt) LAYOUT.select(PATH$attachmentImageInfoCount);
    public static final AddressLayout LAYOUT$pAttachmentImageInfos = (AddressLayout) LAYOUT.select(PATH$pAttachmentImageInfos);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$attachmentImageInfoCount = LAYOUT$attachmentImageInfoCount.byteSize();
    public static final long SIZE$pAttachmentImageInfos = LAYOUT$pAttachmentImageInfos.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$attachmentImageInfoCount = LAYOUT.byteOffset(PATH$attachmentImageInfoCount);
    public static final long OFFSET$pAttachmentImageInfos = LAYOUT.byteOffset(PATH$pAttachmentImageInfos);
}
