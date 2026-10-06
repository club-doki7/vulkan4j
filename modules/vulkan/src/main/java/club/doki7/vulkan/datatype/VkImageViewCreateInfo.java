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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageViewCreateInfo.html"><code>VkImageViewCreateInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkImageViewCreateInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkImageViewCreateFlags flags; // optional // @link substring="VkImageViewCreateFlags" target="VkImageViewCreateFlags" @link substring="flags" target="#flags"
///     VkImage image; // @link substring="VkImage" target="VkImage" @link substring="image" target="#image"
///     VkImageViewType viewType; // @link substring="VkImageViewType" target="VkImageViewType" @link substring="viewType" target="#viewType"
///     VkFormat format; // @link substring="VkFormat" target="VkFormat" @link substring="format" target="#format"
///     VkComponentMapping components; // @link substring="VkComponentMapping" target="VkComponentMapping" @link substring="components" target="#components"
///     VkImageSubresourceRange subresourceRange; // @link substring="VkImageSubresourceRange" target="VkImageSubresourceRange" @link substring="subresourceRange" target="#subresourceRange"
/// } VkImageViewCreateInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_IMAGE_VIEW_CREATE_INFO`
///
/// The {@code allocate} ({@link VkImageViewCreateInfo#allocate(Arena)}, {@link VkImageViewCreateInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkImageViewCreateInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageViewCreateInfo.html"><code>VkImageViewCreateInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkImageViewCreateInfo(@NotNull MemorySegment segment) implements IVkImageViewCreateInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageViewCreateInfo.html"><code>VkImageViewCreateInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkImageViewCreateInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkImageViewCreateInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkImageViewCreateInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkImageViewCreateInfo, Iterable<VkImageViewCreateInfo> {
        public long size() {
            return segment.byteSize() / VkImageViewCreateInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkImageViewCreateInfo at(long index) {
            return new VkImageViewCreateInfo(segment.asSlice(index * VkImageViewCreateInfo.BYTES, VkImageViewCreateInfo.BYTES));
        }

        public VkImageViewCreateInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkImageViewCreateInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkImageViewCreateInfo value) {
            MemorySegment s = segment.asSlice(index * VkImageViewCreateInfo.BYTES, VkImageViewCreateInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkImageViewCreateInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkImageViewCreateInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkImageViewCreateInfo.BYTES,
                (end - start) * VkImageViewCreateInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkImageViewCreateInfo.BYTES));
        }

        public VkImageViewCreateInfo[] toArray() {
            VkImageViewCreateInfo[] ret = new VkImageViewCreateInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkImageViewCreateInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkImageViewCreateInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkImageViewCreateInfo.BYTES;
            }

            @Override
            public VkImageViewCreateInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkImageViewCreateInfo ret = new VkImageViewCreateInfo(segment.asSlice(0, VkImageViewCreateInfo.BYTES));
                segment = segment.asSlice(VkImageViewCreateInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkImageViewCreateInfo allocate(Arena arena) {
        VkImageViewCreateInfo ret = new VkImageViewCreateInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.IMAGE_VIEW_CREATE_INFO);
        return ret;
    }

    public static VkImageViewCreateInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkImageViewCreateInfo.Ptr ret = new VkImageViewCreateInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.IMAGE_VIEW_CREATE_INFO);
        }
        return ret;
    }

    public static VkImageViewCreateInfo clone(Arena arena, VkImageViewCreateInfo src) {
        VkImageViewCreateInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.IMAGE_VIEW_CREATE_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkImageViewCreateInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkImageViewCreateInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkImageViewCreateInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkImageViewCreateFlags.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkImageViewCreateInfo flags(@Bitmask(VkImageViewCreateFlags.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @Nullable VkImage image() {
        MemorySegment s = segment.asSlice(OFFSET$image, SIZE$image);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkImage(s);
    }

    public VkImageViewCreateInfo image(@Nullable VkImage value) {
        segment.set(LAYOUT$image, OFFSET$image, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @EnumType(VkImageViewType.class) int viewType() {
        return segment.get(LAYOUT$viewType, OFFSET$viewType);
    }

    public VkImageViewCreateInfo viewType(@EnumType(VkImageViewType.class) int value) {
        segment.set(LAYOUT$viewType, OFFSET$viewType, value);
        return this;
    }

    public @EnumType(VkFormat.class) int format() {
        return segment.get(LAYOUT$format, OFFSET$format);
    }

    public VkImageViewCreateInfo format(@EnumType(VkFormat.class) int value) {
        segment.set(LAYOUT$format, OFFSET$format, value);
        return this;
    }

    public @NotNull VkComponentMapping components() {
        return new VkComponentMapping(segment.asSlice(OFFSET$components, LAYOUT$components));
    }

    public VkImageViewCreateInfo components(@NotNull VkComponentMapping value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$components, SIZE$components);
        return this;
    }

    public VkImageViewCreateInfo components(Consumer<@NotNull VkComponentMapping> consumer) {
        consumer.accept(components());
        return this;
    }

    public @NotNull VkImageSubresourceRange subresourceRange() {
        return new VkImageSubresourceRange(segment.asSlice(OFFSET$subresourceRange, LAYOUT$subresourceRange));
    }

    public VkImageViewCreateInfo subresourceRange(@NotNull VkImageSubresourceRange value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$subresourceRange, SIZE$subresourceRange);
        return this;
    }

    public VkImageViewCreateInfo subresourceRange(Consumer<@NotNull VkImageSubresourceRange> consumer) {
        consumer.accept(subresourceRange());
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.ADDRESS.withName("image"),
        ValueLayout.JAVA_INT.withName("viewType"),
        ValueLayout.JAVA_INT.withName("format"),
        VkComponentMapping.LAYOUT.withName("components"),
        VkImageSubresourceRange.LAYOUT.withName("subresourceRange")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$image = PathElement.groupElement("image");
    public static final PathElement PATH$viewType = PathElement.groupElement("viewType");
    public static final PathElement PATH$format = PathElement.groupElement("format");
    public static final PathElement PATH$components = PathElement.groupElement("components");
    public static final PathElement PATH$subresourceRange = PathElement.groupElement("subresourceRange");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final AddressLayout LAYOUT$image = (AddressLayout) LAYOUT.select(PATH$image);
    public static final OfInt LAYOUT$viewType = (OfInt) LAYOUT.select(PATH$viewType);
    public static final OfInt LAYOUT$format = (OfInt) LAYOUT.select(PATH$format);
    public static final StructLayout LAYOUT$components = (StructLayout) LAYOUT.select(PATH$components);
    public static final StructLayout LAYOUT$subresourceRange = (StructLayout) LAYOUT.select(PATH$subresourceRange);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$image = LAYOUT$image.byteSize();
    public static final long SIZE$viewType = LAYOUT$viewType.byteSize();
    public static final long SIZE$format = LAYOUT$format.byteSize();
    public static final long SIZE$components = LAYOUT$components.byteSize();
    public static final long SIZE$subresourceRange = LAYOUT$subresourceRange.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$image = LAYOUT.byteOffset(PATH$image);
    public static final long OFFSET$viewType = LAYOUT.byteOffset(PATH$viewType);
    public static final long OFFSET$format = LAYOUT.byteOffset(PATH$format);
    public static final long OFFSET$components = LAYOUT.byteOffset(PATH$components);
    public static final long OFFSET$subresourceRange = LAYOUT.byteOffset(PATH$subresourceRange);
}
