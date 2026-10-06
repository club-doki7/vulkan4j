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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCopyMemoryToImageInfo.html"><code>VkCopyMemoryToImageInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkCopyMemoryToImageInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkHostImageCopyFlags flags; // optional // @link substring="VkHostImageCopyFlags" target="VkHostImageCopyFlags" @link substring="flags" target="#flags"
///     VkImage dstImage; // @link substring="VkImage" target="VkImage" @link substring="dstImage" target="#dstImage"
///     VkImageLayout dstImageLayout; // @link substring="VkImageLayout" target="VkImageLayout" @link substring="dstImageLayout" target="#dstImageLayout"
///     uint32_t regionCount; // @link substring="regionCount" target="#regionCount"
///     VkMemoryToImageCopy const* pRegions; // @link substring="VkMemoryToImageCopy" target="VkMemoryToImageCopy" @link substring="pRegions" target="#pRegions"
/// } VkCopyMemoryToImageInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_COPY_MEMORY_TO_IMAGE_INFO`
///
/// The {@code allocate} ({@link VkCopyMemoryToImageInfo#allocate(Arena)}, {@link VkCopyMemoryToImageInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkCopyMemoryToImageInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCopyMemoryToImageInfo.html"><code>VkCopyMemoryToImageInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkCopyMemoryToImageInfo(@NotNull MemorySegment segment) implements IVkCopyMemoryToImageInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCopyMemoryToImageInfo.html"><code>VkCopyMemoryToImageInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkCopyMemoryToImageInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkCopyMemoryToImageInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkCopyMemoryToImageInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkCopyMemoryToImageInfo, Iterable<VkCopyMemoryToImageInfo> {
        public long size() {
            return segment.byteSize() / VkCopyMemoryToImageInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkCopyMemoryToImageInfo at(long index) {
            return new VkCopyMemoryToImageInfo(segment.asSlice(index * VkCopyMemoryToImageInfo.BYTES, VkCopyMemoryToImageInfo.BYTES));
        }

        public VkCopyMemoryToImageInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkCopyMemoryToImageInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkCopyMemoryToImageInfo value) {
            MemorySegment s = segment.asSlice(index * VkCopyMemoryToImageInfo.BYTES, VkCopyMemoryToImageInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkCopyMemoryToImageInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkCopyMemoryToImageInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkCopyMemoryToImageInfo.BYTES,
                (end - start) * VkCopyMemoryToImageInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkCopyMemoryToImageInfo.BYTES));
        }

        public VkCopyMemoryToImageInfo[] toArray() {
            VkCopyMemoryToImageInfo[] ret = new VkCopyMemoryToImageInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkCopyMemoryToImageInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkCopyMemoryToImageInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkCopyMemoryToImageInfo.BYTES;
            }

            @Override
            public VkCopyMemoryToImageInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkCopyMemoryToImageInfo ret = new VkCopyMemoryToImageInfo(segment.asSlice(0, VkCopyMemoryToImageInfo.BYTES));
                segment = segment.asSlice(VkCopyMemoryToImageInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkCopyMemoryToImageInfo allocate(Arena arena) {
        VkCopyMemoryToImageInfo ret = new VkCopyMemoryToImageInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.COPY_MEMORY_TO_IMAGE_INFO);
        return ret;
    }

    public static VkCopyMemoryToImageInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkCopyMemoryToImageInfo.Ptr ret = new VkCopyMemoryToImageInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.COPY_MEMORY_TO_IMAGE_INFO);
        }
        return ret;
    }

    public static VkCopyMemoryToImageInfo clone(Arena arena, VkCopyMemoryToImageInfo src) {
        VkCopyMemoryToImageInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.COPY_MEMORY_TO_IMAGE_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkCopyMemoryToImageInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkCopyMemoryToImageInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkCopyMemoryToImageInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkHostImageCopyFlags.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkCopyMemoryToImageInfo flags(@Bitmask(VkHostImageCopyFlags.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @Nullable VkImage dstImage() {
        MemorySegment s = segment.asSlice(OFFSET$dstImage, SIZE$dstImage);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkImage(s);
    }

    public VkCopyMemoryToImageInfo dstImage(@Nullable VkImage value) {
        segment.set(LAYOUT$dstImage, OFFSET$dstImage, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @EnumType(VkImageLayout.class) int dstImageLayout() {
        return segment.get(LAYOUT$dstImageLayout, OFFSET$dstImageLayout);
    }

    public VkCopyMemoryToImageInfo dstImageLayout(@EnumType(VkImageLayout.class) int value) {
        segment.set(LAYOUT$dstImageLayout, OFFSET$dstImageLayout, value);
        return this;
    }

    public @Unsigned int regionCount() {
        return segment.get(LAYOUT$regionCount, OFFSET$regionCount);
    }

    public VkCopyMemoryToImageInfo regionCount(@Unsigned int value) {
        segment.set(LAYOUT$regionCount, OFFSET$regionCount, value);
        return this;
    }

    public VkCopyMemoryToImageInfo pRegions(@Nullable IVkMemoryToImageCopy value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pRegionsRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkMemoryToImageCopy.Ptr pRegions(int assumedCount) {
        MemorySegment s = pRegionsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkMemoryToImageCopy.BYTES);
        return new VkMemoryToImageCopy.Ptr(s);
    }

    public @Nullable VkMemoryToImageCopy pRegions() {
        MemorySegment s = pRegionsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkMemoryToImageCopy(s);
    }

    public @Pointer(target=VkMemoryToImageCopy.class) @NotNull MemorySegment pRegionsRaw() {
        return segment.get(LAYOUT$pRegions, OFFSET$pRegions);
    }

    public void pRegionsRaw(@Pointer(target=VkMemoryToImageCopy.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pRegions, OFFSET$pRegions, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.ADDRESS.withName("dstImage"),
        ValueLayout.JAVA_INT.withName("dstImageLayout"),
        ValueLayout.JAVA_INT.withName("regionCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkMemoryToImageCopy.LAYOUT).withName("pRegions")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$dstImage = PathElement.groupElement("dstImage");
    public static final PathElement PATH$dstImageLayout = PathElement.groupElement("dstImageLayout");
    public static final PathElement PATH$regionCount = PathElement.groupElement("regionCount");
    public static final PathElement PATH$pRegions = PathElement.groupElement("pRegions");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final AddressLayout LAYOUT$dstImage = (AddressLayout) LAYOUT.select(PATH$dstImage);
    public static final OfInt LAYOUT$dstImageLayout = (OfInt) LAYOUT.select(PATH$dstImageLayout);
    public static final OfInt LAYOUT$regionCount = (OfInt) LAYOUT.select(PATH$regionCount);
    public static final AddressLayout LAYOUT$pRegions = (AddressLayout) LAYOUT.select(PATH$pRegions);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$dstImage = LAYOUT$dstImage.byteSize();
    public static final long SIZE$dstImageLayout = LAYOUT$dstImageLayout.byteSize();
    public static final long SIZE$regionCount = LAYOUT$regionCount.byteSize();
    public static final long SIZE$pRegions = LAYOUT$pRegions.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$dstImage = LAYOUT.byteOffset(PATH$dstImage);
    public static final long OFFSET$dstImageLayout = LAYOUT.byteOffset(PATH$dstImageLayout);
    public static final long OFFSET$regionCount = LAYOUT.byteOffset(PATH$regionCount);
    public static final long OFFSET$pRegions = LAYOUT.byteOffset(PATH$pRegions);
}
