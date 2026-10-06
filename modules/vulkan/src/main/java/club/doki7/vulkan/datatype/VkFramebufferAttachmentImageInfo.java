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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkFramebufferAttachmentImageInfo.html"><code>VkFramebufferAttachmentImageInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkFramebufferAttachmentImageInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkImageCreateFlags flags; // optional // @link substring="VkImageCreateFlags" target="VkImageCreateFlags" @link substring="flags" target="#flags"
///     VkImageUsageFlags usage; // @link substring="VkImageUsageFlags" target="VkImageUsageFlags" @link substring="usage" target="#usage"
///     uint32_t width; // @link substring="width" target="#width"
///     uint32_t height; // @link substring="height" target="#height"
///     uint32_t layerCount; // @link substring="layerCount" target="#layerCount"
///     uint32_t viewFormatCount; // optional // @link substring="viewFormatCount" target="#viewFormatCount"
///     VkFormat const* pViewFormats; // optional // @link substring="VkFormat" target="VkFormat" @link substring="pViewFormats" target="#pViewFormats"
/// } VkFramebufferAttachmentImageInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_FRAMEBUFFER_ATTACHMENT_IMAGE_INFO`
///
/// The {@code allocate} ({@link VkFramebufferAttachmentImageInfo#allocate(Arena)}, {@link VkFramebufferAttachmentImageInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkFramebufferAttachmentImageInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkFramebufferAttachmentImageInfo.html"><code>VkFramebufferAttachmentImageInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkFramebufferAttachmentImageInfo(@NotNull MemorySegment segment) implements IVkFramebufferAttachmentImageInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkFramebufferAttachmentImageInfo.html"><code>VkFramebufferAttachmentImageInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkFramebufferAttachmentImageInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkFramebufferAttachmentImageInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkFramebufferAttachmentImageInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkFramebufferAttachmentImageInfo, Iterable<VkFramebufferAttachmentImageInfo> {
        public long size() {
            return segment.byteSize() / VkFramebufferAttachmentImageInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkFramebufferAttachmentImageInfo at(long index) {
            return new VkFramebufferAttachmentImageInfo(segment.asSlice(index * VkFramebufferAttachmentImageInfo.BYTES, VkFramebufferAttachmentImageInfo.BYTES));
        }

        public VkFramebufferAttachmentImageInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkFramebufferAttachmentImageInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkFramebufferAttachmentImageInfo value) {
            MemorySegment s = segment.asSlice(index * VkFramebufferAttachmentImageInfo.BYTES, VkFramebufferAttachmentImageInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkFramebufferAttachmentImageInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkFramebufferAttachmentImageInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkFramebufferAttachmentImageInfo.BYTES,
                (end - start) * VkFramebufferAttachmentImageInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkFramebufferAttachmentImageInfo.BYTES));
        }

        public VkFramebufferAttachmentImageInfo[] toArray() {
            VkFramebufferAttachmentImageInfo[] ret = new VkFramebufferAttachmentImageInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkFramebufferAttachmentImageInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkFramebufferAttachmentImageInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkFramebufferAttachmentImageInfo.BYTES;
            }

            @Override
            public VkFramebufferAttachmentImageInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkFramebufferAttachmentImageInfo ret = new VkFramebufferAttachmentImageInfo(segment.asSlice(0, VkFramebufferAttachmentImageInfo.BYTES));
                segment = segment.asSlice(VkFramebufferAttachmentImageInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkFramebufferAttachmentImageInfo allocate(Arena arena) {
        VkFramebufferAttachmentImageInfo ret = new VkFramebufferAttachmentImageInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.FRAMEBUFFER_ATTACHMENT_IMAGE_INFO);
        return ret;
    }

    public static VkFramebufferAttachmentImageInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkFramebufferAttachmentImageInfo.Ptr ret = new VkFramebufferAttachmentImageInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.FRAMEBUFFER_ATTACHMENT_IMAGE_INFO);
        }
        return ret;
    }

    public static VkFramebufferAttachmentImageInfo clone(Arena arena, VkFramebufferAttachmentImageInfo src) {
        VkFramebufferAttachmentImageInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.FRAMEBUFFER_ATTACHMENT_IMAGE_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkFramebufferAttachmentImageInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkFramebufferAttachmentImageInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkFramebufferAttachmentImageInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkImageCreateFlags.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkFramebufferAttachmentImageInfo flags(@Bitmask(VkImageCreateFlags.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @Bitmask(VkImageUsageFlags.class) int usage() {
        return segment.get(LAYOUT$usage, OFFSET$usage);
    }

    public VkFramebufferAttachmentImageInfo usage(@Bitmask(VkImageUsageFlags.class) int value) {
        segment.set(LAYOUT$usage, OFFSET$usage, value);
        return this;
    }

    public @Unsigned int width() {
        return segment.get(LAYOUT$width, OFFSET$width);
    }

    public VkFramebufferAttachmentImageInfo width(@Unsigned int value) {
        segment.set(LAYOUT$width, OFFSET$width, value);
        return this;
    }

    public @Unsigned int height() {
        return segment.get(LAYOUT$height, OFFSET$height);
    }

    public VkFramebufferAttachmentImageInfo height(@Unsigned int value) {
        segment.set(LAYOUT$height, OFFSET$height, value);
        return this;
    }

    public @Unsigned int layerCount() {
        return segment.get(LAYOUT$layerCount, OFFSET$layerCount);
    }

    public VkFramebufferAttachmentImageInfo layerCount(@Unsigned int value) {
        segment.set(LAYOUT$layerCount, OFFSET$layerCount, value);
        return this;
    }

    public @Unsigned int viewFormatCount() {
        return segment.get(LAYOUT$viewFormatCount, OFFSET$viewFormatCount);
    }

    public VkFramebufferAttachmentImageInfo viewFormatCount(@Unsigned int value) {
        segment.set(LAYOUT$viewFormatCount, OFFSET$viewFormatCount, value);
        return this;
    }


    /// Note: the returned {@link IntPtr} does not have correct
    /// {@link IntPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link IntPtr#reinterpret} to set the size before actually reading fro
    /// or writing to the buffer.
    public @Nullable @EnumType(VkFormat.class) IntPtr pViewFormats() {
        MemorySegment s = pViewFormatsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new IntPtr(s);
    }

    public VkFramebufferAttachmentImageInfo pViewFormats(@Nullable @EnumType(VkFormat.class) IntPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pViewFormatsRaw(s);
        return this;
    }

    public @Pointer(target=VkFormat.class) @NotNull MemorySegment pViewFormatsRaw() {
        return segment.get(LAYOUT$pViewFormats, OFFSET$pViewFormats);
    }

    public void pViewFormatsRaw(@Pointer(target=VkFormat.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pViewFormats, OFFSET$pViewFormats, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("usage"),
        ValueLayout.JAVA_INT.withName("width"),
        ValueLayout.JAVA_INT.withName("height"),
        ValueLayout.JAVA_INT.withName("layerCount"),
        ValueLayout.JAVA_INT.withName("viewFormatCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pViewFormats")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$usage = PathElement.groupElement("usage");
    public static final PathElement PATH$width = PathElement.groupElement("width");
    public static final PathElement PATH$height = PathElement.groupElement("height");
    public static final PathElement PATH$layerCount = PathElement.groupElement("layerCount");
    public static final PathElement PATH$viewFormatCount = PathElement.groupElement("viewFormatCount");
    public static final PathElement PATH$pViewFormats = PathElement.groupElement("pViewFormats");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$usage = (OfInt) LAYOUT.select(PATH$usage);
    public static final OfInt LAYOUT$width = (OfInt) LAYOUT.select(PATH$width);
    public static final OfInt LAYOUT$height = (OfInt) LAYOUT.select(PATH$height);
    public static final OfInt LAYOUT$layerCount = (OfInt) LAYOUT.select(PATH$layerCount);
    public static final OfInt LAYOUT$viewFormatCount = (OfInt) LAYOUT.select(PATH$viewFormatCount);
    public static final AddressLayout LAYOUT$pViewFormats = (AddressLayout) LAYOUT.select(PATH$pViewFormats);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$usage = LAYOUT$usage.byteSize();
    public static final long SIZE$width = LAYOUT$width.byteSize();
    public static final long SIZE$height = LAYOUT$height.byteSize();
    public static final long SIZE$layerCount = LAYOUT$layerCount.byteSize();
    public static final long SIZE$viewFormatCount = LAYOUT$viewFormatCount.byteSize();
    public static final long SIZE$pViewFormats = LAYOUT$pViewFormats.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$usage = LAYOUT.byteOffset(PATH$usage);
    public static final long OFFSET$width = LAYOUT.byteOffset(PATH$width);
    public static final long OFFSET$height = LAYOUT.byteOffset(PATH$height);
    public static final long OFFSET$layerCount = LAYOUT.byteOffset(PATH$layerCount);
    public static final long OFFSET$viewFormatCount = LAYOUT.byteOffset(PATH$viewFormatCount);
    public static final long OFFSET$pViewFormats = LAYOUT.byteOffset(PATH$pViewFormats);
}
