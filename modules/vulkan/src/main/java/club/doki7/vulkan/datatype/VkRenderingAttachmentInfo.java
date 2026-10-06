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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRenderingAttachmentInfo.html"><code>VkRenderingAttachmentInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkRenderingAttachmentInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkImageView imageView; // optional // @link substring="VkImageView" target="VkImageView" @link substring="imageView" target="#imageView"
///     VkImageLayout imageLayout; // @link substring="VkImageLayout" target="VkImageLayout" @link substring="imageLayout" target="#imageLayout"
///     VkResolveModeFlags resolveMode; // optional // @link substring="VkResolveModeFlags" target="VkResolveModeFlags" @link substring="resolveMode" target="#resolveMode"
///     VkImageView resolveImageView; // optional // @link substring="VkImageView" target="VkImageView" @link substring="resolveImageView" target="#resolveImageView"
///     VkImageLayout resolveImageLayout; // @link substring="VkImageLayout" target="VkImageLayout" @link substring="resolveImageLayout" target="#resolveImageLayout"
///     VkAttachmentLoadOp loadOp; // @link substring="VkAttachmentLoadOp" target="VkAttachmentLoadOp" @link substring="loadOp" target="#loadOp"
///     VkAttachmentStoreOp storeOp; // @link substring="VkAttachmentStoreOp" target="VkAttachmentStoreOp" @link substring="storeOp" target="#storeOp"
///     VkClearValue clearValue; // @link substring="VkClearValue" target="VkClearValue" @link substring="clearValue" target="#clearValue"
/// } VkRenderingAttachmentInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_RENDERING_ATTACHMENT_INFO`
///
/// The {@code allocate} ({@link VkRenderingAttachmentInfo#allocate(Arena)}, {@link VkRenderingAttachmentInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkRenderingAttachmentInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRenderingAttachmentInfo.html"><code>VkRenderingAttachmentInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkRenderingAttachmentInfo(@NotNull MemorySegment segment) implements IVkRenderingAttachmentInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRenderingAttachmentInfo.html"><code>VkRenderingAttachmentInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkRenderingAttachmentInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkRenderingAttachmentInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkRenderingAttachmentInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkRenderingAttachmentInfo, Iterable<VkRenderingAttachmentInfo> {
        public long size() {
            return segment.byteSize() / VkRenderingAttachmentInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkRenderingAttachmentInfo at(long index) {
            return new VkRenderingAttachmentInfo(segment.asSlice(index * VkRenderingAttachmentInfo.BYTES, VkRenderingAttachmentInfo.BYTES));
        }

        public VkRenderingAttachmentInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkRenderingAttachmentInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkRenderingAttachmentInfo value) {
            MemorySegment s = segment.asSlice(index * VkRenderingAttachmentInfo.BYTES, VkRenderingAttachmentInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkRenderingAttachmentInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkRenderingAttachmentInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkRenderingAttachmentInfo.BYTES,
                (end - start) * VkRenderingAttachmentInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkRenderingAttachmentInfo.BYTES));
        }

        public VkRenderingAttachmentInfo[] toArray() {
            VkRenderingAttachmentInfo[] ret = new VkRenderingAttachmentInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkRenderingAttachmentInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkRenderingAttachmentInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkRenderingAttachmentInfo.BYTES;
            }

            @Override
            public VkRenderingAttachmentInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkRenderingAttachmentInfo ret = new VkRenderingAttachmentInfo(segment.asSlice(0, VkRenderingAttachmentInfo.BYTES));
                segment = segment.asSlice(VkRenderingAttachmentInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkRenderingAttachmentInfo allocate(Arena arena) {
        VkRenderingAttachmentInfo ret = new VkRenderingAttachmentInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.RENDERING_ATTACHMENT_INFO);
        return ret;
    }

    public static VkRenderingAttachmentInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkRenderingAttachmentInfo.Ptr ret = new VkRenderingAttachmentInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.RENDERING_ATTACHMENT_INFO);
        }
        return ret;
    }

    public static VkRenderingAttachmentInfo clone(Arena arena, VkRenderingAttachmentInfo src) {
        VkRenderingAttachmentInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.RENDERING_ATTACHMENT_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkRenderingAttachmentInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkRenderingAttachmentInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkRenderingAttachmentInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Nullable VkImageView imageView() {
        MemorySegment s = segment.asSlice(OFFSET$imageView, SIZE$imageView);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkImageView(s);
    }

    public VkRenderingAttachmentInfo imageView(@Nullable VkImageView value) {
        segment.set(LAYOUT$imageView, OFFSET$imageView, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @EnumType(VkImageLayout.class) int imageLayout() {
        return segment.get(LAYOUT$imageLayout, OFFSET$imageLayout);
    }

    public VkRenderingAttachmentInfo imageLayout(@EnumType(VkImageLayout.class) int value) {
        segment.set(LAYOUT$imageLayout, OFFSET$imageLayout, value);
        return this;
    }

    public @Bitmask(VkResolveModeFlags.class) int resolveMode() {
        return segment.get(LAYOUT$resolveMode, OFFSET$resolveMode);
    }

    public VkRenderingAttachmentInfo resolveMode(@Bitmask(VkResolveModeFlags.class) int value) {
        segment.set(LAYOUT$resolveMode, OFFSET$resolveMode, value);
        return this;
    }

    public @Nullable VkImageView resolveImageView() {
        MemorySegment s = segment.asSlice(OFFSET$resolveImageView, SIZE$resolveImageView);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkImageView(s);
    }

    public VkRenderingAttachmentInfo resolveImageView(@Nullable VkImageView value) {
        segment.set(LAYOUT$resolveImageView, OFFSET$resolveImageView, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @EnumType(VkImageLayout.class) int resolveImageLayout() {
        return segment.get(LAYOUT$resolveImageLayout, OFFSET$resolveImageLayout);
    }

    public VkRenderingAttachmentInfo resolveImageLayout(@EnumType(VkImageLayout.class) int value) {
        segment.set(LAYOUT$resolveImageLayout, OFFSET$resolveImageLayout, value);
        return this;
    }

    public @EnumType(VkAttachmentLoadOp.class) int loadOp() {
        return segment.get(LAYOUT$loadOp, OFFSET$loadOp);
    }

    public VkRenderingAttachmentInfo loadOp(@EnumType(VkAttachmentLoadOp.class) int value) {
        segment.set(LAYOUT$loadOp, OFFSET$loadOp, value);
        return this;
    }

    public @EnumType(VkAttachmentStoreOp.class) int storeOp() {
        return segment.get(LAYOUT$storeOp, OFFSET$storeOp);
    }

    public VkRenderingAttachmentInfo storeOp(@EnumType(VkAttachmentStoreOp.class) int value) {
        segment.set(LAYOUT$storeOp, OFFSET$storeOp, value);
        return this;
    }

    public @NotNull VkClearValue clearValue() {
        return new VkClearValue(segment.asSlice(OFFSET$clearValue, LAYOUT$clearValue));
    }

    public VkRenderingAttachmentInfo clearValue(@NotNull VkClearValue value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$clearValue, SIZE$clearValue);
        return this;
    }

    public VkRenderingAttachmentInfo clearValue(Consumer<@NotNull VkClearValue> consumer) {
        consumer.accept(clearValue());
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withName("imageView"),
        ValueLayout.JAVA_INT.withName("imageLayout"),
        ValueLayout.JAVA_INT.withName("resolveMode"),
        ValueLayout.ADDRESS.withName("resolveImageView"),
        ValueLayout.JAVA_INT.withName("resolveImageLayout"),
        ValueLayout.JAVA_INT.withName("loadOp"),
        ValueLayout.JAVA_INT.withName("storeOp"),
        VkClearValue.LAYOUT.withName("clearValue")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$imageView = PathElement.groupElement("imageView");
    public static final PathElement PATH$imageLayout = PathElement.groupElement("imageLayout");
    public static final PathElement PATH$resolveMode = PathElement.groupElement("resolveMode");
    public static final PathElement PATH$resolveImageView = PathElement.groupElement("resolveImageView");
    public static final PathElement PATH$resolveImageLayout = PathElement.groupElement("resolveImageLayout");
    public static final PathElement PATH$loadOp = PathElement.groupElement("loadOp");
    public static final PathElement PATH$storeOp = PathElement.groupElement("storeOp");
    public static final PathElement PATH$clearValue = PathElement.groupElement("clearValue");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$imageView = (AddressLayout) LAYOUT.select(PATH$imageView);
    public static final OfInt LAYOUT$imageLayout = (OfInt) LAYOUT.select(PATH$imageLayout);
    public static final OfInt LAYOUT$resolveMode = (OfInt) LAYOUT.select(PATH$resolveMode);
    public static final AddressLayout LAYOUT$resolveImageView = (AddressLayout) LAYOUT.select(PATH$resolveImageView);
    public static final OfInt LAYOUT$resolveImageLayout = (OfInt) LAYOUT.select(PATH$resolveImageLayout);
    public static final OfInt LAYOUT$loadOp = (OfInt) LAYOUT.select(PATH$loadOp);
    public static final OfInt LAYOUT$storeOp = (OfInt) LAYOUT.select(PATH$storeOp);
    public static final UnionLayout LAYOUT$clearValue = (UnionLayout) LAYOUT.select(PATH$clearValue);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$imageView = LAYOUT$imageView.byteSize();
    public static final long SIZE$imageLayout = LAYOUT$imageLayout.byteSize();
    public static final long SIZE$resolveMode = LAYOUT$resolveMode.byteSize();
    public static final long SIZE$resolveImageView = LAYOUT$resolveImageView.byteSize();
    public static final long SIZE$resolveImageLayout = LAYOUT$resolveImageLayout.byteSize();
    public static final long SIZE$loadOp = LAYOUT$loadOp.byteSize();
    public static final long SIZE$storeOp = LAYOUT$storeOp.byteSize();
    public static final long SIZE$clearValue = LAYOUT$clearValue.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$imageView = LAYOUT.byteOffset(PATH$imageView);
    public static final long OFFSET$imageLayout = LAYOUT.byteOffset(PATH$imageLayout);
    public static final long OFFSET$resolveMode = LAYOUT.byteOffset(PATH$resolveMode);
    public static final long OFFSET$resolveImageView = LAYOUT.byteOffset(PATH$resolveImageView);
    public static final long OFFSET$resolveImageLayout = LAYOUT.byteOffset(PATH$resolveImageLayout);
    public static final long OFFSET$loadOp = LAYOUT.byteOffset(PATH$loadOp);
    public static final long OFFSET$storeOp = LAYOUT.byteOffset(PATH$storeOp);
    public static final long OFFSET$clearValue = LAYOUT.byteOffset(PATH$clearValue);
}
