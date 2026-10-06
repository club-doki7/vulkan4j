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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBlitImageInfo2.html"><code>VkBlitImageInfo2</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkBlitImageInfo2 {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkImage srcImage; // @link substring="VkImage" target="VkImage" @link substring="srcImage" target="#srcImage"
///     VkImageLayout srcImageLayout; // @link substring="VkImageLayout" target="VkImageLayout" @link substring="srcImageLayout" target="#srcImageLayout"
///     VkImage dstImage; // @link substring="VkImage" target="VkImage" @link substring="dstImage" target="#dstImage"
///     VkImageLayout dstImageLayout; // @link substring="VkImageLayout" target="VkImageLayout" @link substring="dstImageLayout" target="#dstImageLayout"
///     uint32_t regionCount; // @link substring="regionCount" target="#regionCount"
///     VkImageBlit2 const* pRegions; // @link substring="VkImageBlit2" target="VkImageBlit2" @link substring="pRegions" target="#pRegions"
///     VkFilter filter; // @link substring="VkFilter" target="VkFilter" @link substring="filter" target="#filter"
/// } VkBlitImageInfo2;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_BLIT_IMAGE_INFO_2`
///
/// The {@code allocate} ({@link VkBlitImageInfo2#allocate(Arena)}, {@link VkBlitImageInfo2#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkBlitImageInfo2#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBlitImageInfo2.html"><code>VkBlitImageInfo2</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkBlitImageInfo2(@NotNull MemorySegment segment) implements IVkBlitImageInfo2 {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBlitImageInfo2.html"><code>VkBlitImageInfo2</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkBlitImageInfo2}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkBlitImageInfo2 to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkBlitImageInfo2.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkBlitImageInfo2, Iterable<VkBlitImageInfo2> {
        public long size() {
            return segment.byteSize() / VkBlitImageInfo2.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkBlitImageInfo2 at(long index) {
            return new VkBlitImageInfo2(segment.asSlice(index * VkBlitImageInfo2.BYTES, VkBlitImageInfo2.BYTES));
        }

        public VkBlitImageInfo2.Ptr at(long index, @NotNull Consumer<@NotNull VkBlitImageInfo2> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkBlitImageInfo2 value) {
            MemorySegment s = segment.asSlice(index * VkBlitImageInfo2.BYTES, VkBlitImageInfo2.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkBlitImageInfo2.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkBlitImageInfo2.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkBlitImageInfo2.BYTES,
                (end - start) * VkBlitImageInfo2.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkBlitImageInfo2.BYTES));
        }

        public VkBlitImageInfo2[] toArray() {
            VkBlitImageInfo2[] ret = new VkBlitImageInfo2[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkBlitImageInfo2> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkBlitImageInfo2> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkBlitImageInfo2.BYTES;
            }

            @Override
            public VkBlitImageInfo2 next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkBlitImageInfo2 ret = new VkBlitImageInfo2(segment.asSlice(0, VkBlitImageInfo2.BYTES));
                segment = segment.asSlice(VkBlitImageInfo2.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkBlitImageInfo2 allocate(Arena arena) {
        VkBlitImageInfo2 ret = new VkBlitImageInfo2(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.BLIT_IMAGE_INFO_2);
        return ret;
    }

    public static VkBlitImageInfo2.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkBlitImageInfo2.Ptr ret = new VkBlitImageInfo2.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.BLIT_IMAGE_INFO_2);
        }
        return ret;
    }

    public static VkBlitImageInfo2 clone(Arena arena, VkBlitImageInfo2 src) {
        VkBlitImageInfo2 ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.BLIT_IMAGE_INFO_2);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkBlitImageInfo2 sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkBlitImageInfo2 pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkBlitImageInfo2 pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Nullable VkImage srcImage() {
        MemorySegment s = segment.asSlice(OFFSET$srcImage, SIZE$srcImage);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkImage(s);
    }

    public VkBlitImageInfo2 srcImage(@Nullable VkImage value) {
        segment.set(LAYOUT$srcImage, OFFSET$srcImage, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @EnumType(VkImageLayout.class) int srcImageLayout() {
        return segment.get(LAYOUT$srcImageLayout, OFFSET$srcImageLayout);
    }

    public VkBlitImageInfo2 srcImageLayout(@EnumType(VkImageLayout.class) int value) {
        segment.set(LAYOUT$srcImageLayout, OFFSET$srcImageLayout, value);
        return this;
    }

    public @Nullable VkImage dstImage() {
        MemorySegment s = segment.asSlice(OFFSET$dstImage, SIZE$dstImage);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkImage(s);
    }

    public VkBlitImageInfo2 dstImage(@Nullable VkImage value) {
        segment.set(LAYOUT$dstImage, OFFSET$dstImage, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @EnumType(VkImageLayout.class) int dstImageLayout() {
        return segment.get(LAYOUT$dstImageLayout, OFFSET$dstImageLayout);
    }

    public VkBlitImageInfo2 dstImageLayout(@EnumType(VkImageLayout.class) int value) {
        segment.set(LAYOUT$dstImageLayout, OFFSET$dstImageLayout, value);
        return this;
    }

    public @Unsigned int regionCount() {
        return segment.get(LAYOUT$regionCount, OFFSET$regionCount);
    }

    public VkBlitImageInfo2 regionCount(@Unsigned int value) {
        segment.set(LAYOUT$regionCount, OFFSET$regionCount, value);
        return this;
    }

    public VkBlitImageInfo2 pRegions(@Nullable IVkImageBlit2 value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pRegionsRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkImageBlit2.Ptr pRegions(int assumedCount) {
        MemorySegment s = pRegionsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkImageBlit2.BYTES);
        return new VkImageBlit2.Ptr(s);
    }

    public @Nullable VkImageBlit2 pRegions() {
        MemorySegment s = pRegionsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkImageBlit2(s);
    }

    public @Pointer(target=VkImageBlit2.class) @NotNull MemorySegment pRegionsRaw() {
        return segment.get(LAYOUT$pRegions, OFFSET$pRegions);
    }

    public void pRegionsRaw(@Pointer(target=VkImageBlit2.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pRegions, OFFSET$pRegions, value);
    }

    public @EnumType(VkFilter.class) int filter() {
        return segment.get(LAYOUT$filter, OFFSET$filter);
    }

    public VkBlitImageInfo2 filter(@EnumType(VkFilter.class) int value) {
        segment.set(LAYOUT$filter, OFFSET$filter, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withName("srcImage"),
        ValueLayout.JAVA_INT.withName("srcImageLayout"),
        ValueLayout.ADDRESS.withName("dstImage"),
        ValueLayout.JAVA_INT.withName("dstImageLayout"),
        ValueLayout.JAVA_INT.withName("regionCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkImageBlit2.LAYOUT).withName("pRegions"),
        ValueLayout.JAVA_INT.withName("filter")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$srcImage = PathElement.groupElement("srcImage");
    public static final PathElement PATH$srcImageLayout = PathElement.groupElement("srcImageLayout");
    public static final PathElement PATH$dstImage = PathElement.groupElement("dstImage");
    public static final PathElement PATH$dstImageLayout = PathElement.groupElement("dstImageLayout");
    public static final PathElement PATH$regionCount = PathElement.groupElement("regionCount");
    public static final PathElement PATH$pRegions = PathElement.groupElement("pRegions");
    public static final PathElement PATH$filter = PathElement.groupElement("filter");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$srcImage = (AddressLayout) LAYOUT.select(PATH$srcImage);
    public static final OfInt LAYOUT$srcImageLayout = (OfInt) LAYOUT.select(PATH$srcImageLayout);
    public static final AddressLayout LAYOUT$dstImage = (AddressLayout) LAYOUT.select(PATH$dstImage);
    public static final OfInt LAYOUT$dstImageLayout = (OfInt) LAYOUT.select(PATH$dstImageLayout);
    public static final OfInt LAYOUT$regionCount = (OfInt) LAYOUT.select(PATH$regionCount);
    public static final AddressLayout LAYOUT$pRegions = (AddressLayout) LAYOUT.select(PATH$pRegions);
    public static final OfInt LAYOUT$filter = (OfInt) LAYOUT.select(PATH$filter);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$srcImage = LAYOUT$srcImage.byteSize();
    public static final long SIZE$srcImageLayout = LAYOUT$srcImageLayout.byteSize();
    public static final long SIZE$dstImage = LAYOUT$dstImage.byteSize();
    public static final long SIZE$dstImageLayout = LAYOUT$dstImageLayout.byteSize();
    public static final long SIZE$regionCount = LAYOUT$regionCount.byteSize();
    public static final long SIZE$pRegions = LAYOUT$pRegions.byteSize();
    public static final long SIZE$filter = LAYOUT$filter.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$srcImage = LAYOUT.byteOffset(PATH$srcImage);
    public static final long OFFSET$srcImageLayout = LAYOUT.byteOffset(PATH$srcImageLayout);
    public static final long OFFSET$dstImage = LAYOUT.byteOffset(PATH$dstImage);
    public static final long OFFSET$dstImageLayout = LAYOUT.byteOffset(PATH$dstImageLayout);
    public static final long OFFSET$regionCount = LAYOUT.byteOffset(PATH$regionCount);
    public static final long OFFSET$pRegions = LAYOUT.byteOffset(PATH$pRegions);
    public static final long OFFSET$filter = LAYOUT.byteOffset(PATH$filter);
}
