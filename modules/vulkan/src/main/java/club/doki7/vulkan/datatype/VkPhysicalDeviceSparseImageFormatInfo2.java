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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceSparseImageFormatInfo2.html"><code>VkPhysicalDeviceSparseImageFormatInfo2</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceSparseImageFormatInfo2 {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkFormat format; // @link substring="VkFormat" target="VkFormat" @link substring="format" target="#format"
///     VkImageType type; // @link substring="VkImageType" target="VkImageType" @link substring="type" target="#type"
///     VkSampleCountFlags samples; // @link substring="VkSampleCountFlags" target="VkSampleCountFlags" @link substring="samples" target="#samples"
///     VkImageUsageFlags usage; // @link substring="VkImageUsageFlags" target="VkImageUsageFlags" @link substring="usage" target="#usage"
///     VkImageTiling tiling; // @link substring="VkImageTiling" target="VkImageTiling" @link substring="tiling" target="#tiling"
/// } VkPhysicalDeviceSparseImageFormatInfo2;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SPARSE_IMAGE_FORMAT_INFO_2`
///
/// The {@code allocate} ({@link VkPhysicalDeviceSparseImageFormatInfo2#allocate(Arena)}, {@link VkPhysicalDeviceSparseImageFormatInfo2#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceSparseImageFormatInfo2#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceSparseImageFormatInfo2.html"><code>VkPhysicalDeviceSparseImageFormatInfo2</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceSparseImageFormatInfo2(@NotNull MemorySegment segment) implements IVkPhysicalDeviceSparseImageFormatInfo2 {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceSparseImageFormatInfo2.html"><code>VkPhysicalDeviceSparseImageFormatInfo2</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceSparseImageFormatInfo2}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceSparseImageFormatInfo2 to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceSparseImageFormatInfo2.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceSparseImageFormatInfo2, Iterable<VkPhysicalDeviceSparseImageFormatInfo2> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceSparseImageFormatInfo2.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceSparseImageFormatInfo2 at(long index) {
            return new VkPhysicalDeviceSparseImageFormatInfo2(segment.asSlice(index * VkPhysicalDeviceSparseImageFormatInfo2.BYTES, VkPhysicalDeviceSparseImageFormatInfo2.BYTES));
        }

        public VkPhysicalDeviceSparseImageFormatInfo2.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceSparseImageFormatInfo2> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceSparseImageFormatInfo2 value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceSparseImageFormatInfo2.BYTES, VkPhysicalDeviceSparseImageFormatInfo2.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceSparseImageFormatInfo2.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceSparseImageFormatInfo2.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceSparseImageFormatInfo2.BYTES,
                (end - start) * VkPhysicalDeviceSparseImageFormatInfo2.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceSparseImageFormatInfo2.BYTES));
        }

        public VkPhysicalDeviceSparseImageFormatInfo2[] toArray() {
            VkPhysicalDeviceSparseImageFormatInfo2[] ret = new VkPhysicalDeviceSparseImageFormatInfo2[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceSparseImageFormatInfo2> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceSparseImageFormatInfo2> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceSparseImageFormatInfo2.BYTES;
            }

            @Override
            public VkPhysicalDeviceSparseImageFormatInfo2 next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceSparseImageFormatInfo2 ret = new VkPhysicalDeviceSparseImageFormatInfo2(segment.asSlice(0, VkPhysicalDeviceSparseImageFormatInfo2.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceSparseImageFormatInfo2.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceSparseImageFormatInfo2 allocate(Arena arena) {
        VkPhysicalDeviceSparseImageFormatInfo2 ret = new VkPhysicalDeviceSparseImageFormatInfo2(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_SPARSE_IMAGE_FORMAT_INFO_2);
        return ret;
    }

    public static VkPhysicalDeviceSparseImageFormatInfo2.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceSparseImageFormatInfo2.Ptr ret = new VkPhysicalDeviceSparseImageFormatInfo2.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_SPARSE_IMAGE_FORMAT_INFO_2);
        }
        return ret;
    }

    public static VkPhysicalDeviceSparseImageFormatInfo2 clone(Arena arena, VkPhysicalDeviceSparseImageFormatInfo2 src) {
        VkPhysicalDeviceSparseImageFormatInfo2 ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_SPARSE_IMAGE_FORMAT_INFO_2);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceSparseImageFormatInfo2 sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceSparseImageFormatInfo2 pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceSparseImageFormatInfo2 pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @EnumType(VkFormat.class) int format() {
        return segment.get(LAYOUT$format, OFFSET$format);
    }

    public VkPhysicalDeviceSparseImageFormatInfo2 format(@EnumType(VkFormat.class) int value) {
        segment.set(LAYOUT$format, OFFSET$format, value);
        return this;
    }

    public @EnumType(VkImageType.class) int type() {
        return segment.get(LAYOUT$type, OFFSET$type);
    }

    public VkPhysicalDeviceSparseImageFormatInfo2 type(@EnumType(VkImageType.class) int value) {
        segment.set(LAYOUT$type, OFFSET$type, value);
        return this;
    }

    public @Bitmask(VkSampleCountFlags.class) int samples() {
        return segment.get(LAYOUT$samples, OFFSET$samples);
    }

    public VkPhysicalDeviceSparseImageFormatInfo2 samples(@Bitmask(VkSampleCountFlags.class) int value) {
        segment.set(LAYOUT$samples, OFFSET$samples, value);
        return this;
    }

    public @Bitmask(VkImageUsageFlags.class) int usage() {
        return segment.get(LAYOUT$usage, OFFSET$usage);
    }

    public VkPhysicalDeviceSparseImageFormatInfo2 usage(@Bitmask(VkImageUsageFlags.class) int value) {
        segment.set(LAYOUT$usage, OFFSET$usage, value);
        return this;
    }

    public @EnumType(VkImageTiling.class) int tiling() {
        return segment.get(LAYOUT$tiling, OFFSET$tiling);
    }

    public VkPhysicalDeviceSparseImageFormatInfo2 tiling(@EnumType(VkImageTiling.class) int value) {
        segment.set(LAYOUT$tiling, OFFSET$tiling, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("format"),
        ValueLayout.JAVA_INT.withName("type"),
        ValueLayout.JAVA_INT.withName("samples"),
        ValueLayout.JAVA_INT.withName("usage"),
        ValueLayout.JAVA_INT.withName("tiling")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$format = PathElement.groupElement("format");
    public static final PathElement PATH$type = PathElement.groupElement("type");
    public static final PathElement PATH$samples = PathElement.groupElement("samples");
    public static final PathElement PATH$usage = PathElement.groupElement("usage");
    public static final PathElement PATH$tiling = PathElement.groupElement("tiling");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$format = (OfInt) LAYOUT.select(PATH$format);
    public static final OfInt LAYOUT$type = (OfInt) LAYOUT.select(PATH$type);
    public static final OfInt LAYOUT$samples = (OfInt) LAYOUT.select(PATH$samples);
    public static final OfInt LAYOUT$usage = (OfInt) LAYOUT.select(PATH$usage);
    public static final OfInt LAYOUT$tiling = (OfInt) LAYOUT.select(PATH$tiling);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$format = LAYOUT$format.byteSize();
    public static final long SIZE$type = LAYOUT$type.byteSize();
    public static final long SIZE$samples = LAYOUT$samples.byteSize();
    public static final long SIZE$usage = LAYOUT$usage.byteSize();
    public static final long SIZE$tiling = LAYOUT$tiling.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$format = LAYOUT.byteOffset(PATH$format);
    public static final long OFFSET$type = LAYOUT.byteOffset(PATH$type);
    public static final long OFFSET$samples = LAYOUT.byteOffset(PATH$samples);
    public static final long OFFSET$usage = LAYOUT.byteOffset(PATH$usage);
    public static final long OFFSET$tiling = LAYOUT.byteOffset(PATH$tiling);
}
