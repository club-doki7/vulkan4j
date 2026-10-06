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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAttachmentDescription2.html"><code>VkAttachmentDescription2</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkAttachmentDescription2 {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkAttachmentDescriptionFlags flags; // optional // @link substring="VkAttachmentDescriptionFlags" target="VkAttachmentDescriptionFlags" @link substring="flags" target="#flags"
///     VkFormat format; // @link substring="VkFormat" target="VkFormat" @link substring="format" target="#format"
///     VkSampleCountFlags samples; // @link substring="VkSampleCountFlags" target="VkSampleCountFlags" @link substring="samples" target="#samples"
///     VkAttachmentLoadOp loadOp; // @link substring="VkAttachmentLoadOp" target="VkAttachmentLoadOp" @link substring="loadOp" target="#loadOp"
///     VkAttachmentStoreOp storeOp; // @link substring="VkAttachmentStoreOp" target="VkAttachmentStoreOp" @link substring="storeOp" target="#storeOp"
///     VkAttachmentLoadOp stencilLoadOp; // @link substring="VkAttachmentLoadOp" target="VkAttachmentLoadOp" @link substring="stencilLoadOp" target="#stencilLoadOp"
///     VkAttachmentStoreOp stencilStoreOp; // @link substring="VkAttachmentStoreOp" target="VkAttachmentStoreOp" @link substring="stencilStoreOp" target="#stencilStoreOp"
///     VkImageLayout initialLayout; // @link substring="VkImageLayout" target="VkImageLayout" @link substring="initialLayout" target="#initialLayout"
///     VkImageLayout finalLayout; // @link substring="VkImageLayout" target="VkImageLayout" @link substring="finalLayout" target="#finalLayout"
/// } VkAttachmentDescription2;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_ATTACHMENT_DESCRIPTION_2`
///
/// The {@code allocate} ({@link VkAttachmentDescription2#allocate(Arena)}, {@link VkAttachmentDescription2#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkAttachmentDescription2#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAttachmentDescription2.html"><code>VkAttachmentDescription2</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkAttachmentDescription2(@NotNull MemorySegment segment) implements IVkAttachmentDescription2 {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAttachmentDescription2.html"><code>VkAttachmentDescription2</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkAttachmentDescription2}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkAttachmentDescription2 to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkAttachmentDescription2.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkAttachmentDescription2, Iterable<VkAttachmentDescription2> {
        public long size() {
            return segment.byteSize() / VkAttachmentDescription2.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkAttachmentDescription2 at(long index) {
            return new VkAttachmentDescription2(segment.asSlice(index * VkAttachmentDescription2.BYTES, VkAttachmentDescription2.BYTES));
        }

        public VkAttachmentDescription2.Ptr at(long index, @NotNull Consumer<@NotNull VkAttachmentDescription2> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkAttachmentDescription2 value) {
            MemorySegment s = segment.asSlice(index * VkAttachmentDescription2.BYTES, VkAttachmentDescription2.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkAttachmentDescription2.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkAttachmentDescription2.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkAttachmentDescription2.BYTES,
                (end - start) * VkAttachmentDescription2.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkAttachmentDescription2.BYTES));
        }

        public VkAttachmentDescription2[] toArray() {
            VkAttachmentDescription2[] ret = new VkAttachmentDescription2[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkAttachmentDescription2> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkAttachmentDescription2> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkAttachmentDescription2.BYTES;
            }

            @Override
            public VkAttachmentDescription2 next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkAttachmentDescription2 ret = new VkAttachmentDescription2(segment.asSlice(0, VkAttachmentDescription2.BYTES));
                segment = segment.asSlice(VkAttachmentDescription2.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkAttachmentDescription2 allocate(Arena arena) {
        VkAttachmentDescription2 ret = new VkAttachmentDescription2(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.ATTACHMENT_DESCRIPTION_2);
        return ret;
    }

    public static VkAttachmentDescription2.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkAttachmentDescription2.Ptr ret = new VkAttachmentDescription2.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.ATTACHMENT_DESCRIPTION_2);
        }
        return ret;
    }

    public static VkAttachmentDescription2 clone(Arena arena, VkAttachmentDescription2 src) {
        VkAttachmentDescription2 ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.ATTACHMENT_DESCRIPTION_2);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkAttachmentDescription2 sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkAttachmentDescription2 pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkAttachmentDescription2 pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkAttachmentDescriptionFlags.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkAttachmentDescription2 flags(@Bitmask(VkAttachmentDescriptionFlags.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @EnumType(VkFormat.class) int format() {
        return segment.get(LAYOUT$format, OFFSET$format);
    }

    public VkAttachmentDescription2 format(@EnumType(VkFormat.class) int value) {
        segment.set(LAYOUT$format, OFFSET$format, value);
        return this;
    }

    public @Bitmask(VkSampleCountFlags.class) int samples() {
        return segment.get(LAYOUT$samples, OFFSET$samples);
    }

    public VkAttachmentDescription2 samples(@Bitmask(VkSampleCountFlags.class) int value) {
        segment.set(LAYOUT$samples, OFFSET$samples, value);
        return this;
    }

    public @EnumType(VkAttachmentLoadOp.class) int loadOp() {
        return segment.get(LAYOUT$loadOp, OFFSET$loadOp);
    }

    public VkAttachmentDescription2 loadOp(@EnumType(VkAttachmentLoadOp.class) int value) {
        segment.set(LAYOUT$loadOp, OFFSET$loadOp, value);
        return this;
    }

    public @EnumType(VkAttachmentStoreOp.class) int storeOp() {
        return segment.get(LAYOUT$storeOp, OFFSET$storeOp);
    }

    public VkAttachmentDescription2 storeOp(@EnumType(VkAttachmentStoreOp.class) int value) {
        segment.set(LAYOUT$storeOp, OFFSET$storeOp, value);
        return this;
    }

    public @EnumType(VkAttachmentLoadOp.class) int stencilLoadOp() {
        return segment.get(LAYOUT$stencilLoadOp, OFFSET$stencilLoadOp);
    }

    public VkAttachmentDescription2 stencilLoadOp(@EnumType(VkAttachmentLoadOp.class) int value) {
        segment.set(LAYOUT$stencilLoadOp, OFFSET$stencilLoadOp, value);
        return this;
    }

    public @EnumType(VkAttachmentStoreOp.class) int stencilStoreOp() {
        return segment.get(LAYOUT$stencilStoreOp, OFFSET$stencilStoreOp);
    }

    public VkAttachmentDescription2 stencilStoreOp(@EnumType(VkAttachmentStoreOp.class) int value) {
        segment.set(LAYOUT$stencilStoreOp, OFFSET$stencilStoreOp, value);
        return this;
    }

    public @EnumType(VkImageLayout.class) int initialLayout() {
        return segment.get(LAYOUT$initialLayout, OFFSET$initialLayout);
    }

    public VkAttachmentDescription2 initialLayout(@EnumType(VkImageLayout.class) int value) {
        segment.set(LAYOUT$initialLayout, OFFSET$initialLayout, value);
        return this;
    }

    public @EnumType(VkImageLayout.class) int finalLayout() {
        return segment.get(LAYOUT$finalLayout, OFFSET$finalLayout);
    }

    public VkAttachmentDescription2 finalLayout(@EnumType(VkImageLayout.class) int value) {
        segment.set(LAYOUT$finalLayout, OFFSET$finalLayout, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("format"),
        ValueLayout.JAVA_INT.withName("samples"),
        ValueLayout.JAVA_INT.withName("loadOp"),
        ValueLayout.JAVA_INT.withName("storeOp"),
        ValueLayout.JAVA_INT.withName("stencilLoadOp"),
        ValueLayout.JAVA_INT.withName("stencilStoreOp"),
        ValueLayout.JAVA_INT.withName("initialLayout"),
        ValueLayout.JAVA_INT.withName("finalLayout")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$format = PathElement.groupElement("format");
    public static final PathElement PATH$samples = PathElement.groupElement("samples");
    public static final PathElement PATH$loadOp = PathElement.groupElement("loadOp");
    public static final PathElement PATH$storeOp = PathElement.groupElement("storeOp");
    public static final PathElement PATH$stencilLoadOp = PathElement.groupElement("stencilLoadOp");
    public static final PathElement PATH$stencilStoreOp = PathElement.groupElement("stencilStoreOp");
    public static final PathElement PATH$initialLayout = PathElement.groupElement("initialLayout");
    public static final PathElement PATH$finalLayout = PathElement.groupElement("finalLayout");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$format = (OfInt) LAYOUT.select(PATH$format);
    public static final OfInt LAYOUT$samples = (OfInt) LAYOUT.select(PATH$samples);
    public static final OfInt LAYOUT$loadOp = (OfInt) LAYOUT.select(PATH$loadOp);
    public static final OfInt LAYOUT$storeOp = (OfInt) LAYOUT.select(PATH$storeOp);
    public static final OfInt LAYOUT$stencilLoadOp = (OfInt) LAYOUT.select(PATH$stencilLoadOp);
    public static final OfInt LAYOUT$stencilStoreOp = (OfInt) LAYOUT.select(PATH$stencilStoreOp);
    public static final OfInt LAYOUT$initialLayout = (OfInt) LAYOUT.select(PATH$initialLayout);
    public static final OfInt LAYOUT$finalLayout = (OfInt) LAYOUT.select(PATH$finalLayout);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$format = LAYOUT$format.byteSize();
    public static final long SIZE$samples = LAYOUT$samples.byteSize();
    public static final long SIZE$loadOp = LAYOUT$loadOp.byteSize();
    public static final long SIZE$storeOp = LAYOUT$storeOp.byteSize();
    public static final long SIZE$stencilLoadOp = LAYOUT$stencilLoadOp.byteSize();
    public static final long SIZE$stencilStoreOp = LAYOUT$stencilStoreOp.byteSize();
    public static final long SIZE$initialLayout = LAYOUT$initialLayout.byteSize();
    public static final long SIZE$finalLayout = LAYOUT$finalLayout.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$format = LAYOUT.byteOffset(PATH$format);
    public static final long OFFSET$samples = LAYOUT.byteOffset(PATH$samples);
    public static final long OFFSET$loadOp = LAYOUT.byteOffset(PATH$loadOp);
    public static final long OFFSET$storeOp = LAYOUT.byteOffset(PATH$storeOp);
    public static final long OFFSET$stencilLoadOp = LAYOUT.byteOffset(PATH$stencilLoadOp);
    public static final long OFFSET$stencilStoreOp = LAYOUT.byteOffset(PATH$stencilStoreOp);
    public static final long OFFSET$initialLayout = LAYOUT.byteOffset(PATH$initialLayout);
    public static final long OFFSET$finalLayout = LAYOUT.byteOffset(PATH$finalLayout);
}
