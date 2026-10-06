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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageCreateInfo.html"><code>VkImageCreateInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkImageCreateInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkImageCreateFlags flags; // optional // @link substring="VkImageCreateFlags" target="VkImageCreateFlags" @link substring="flags" target="#flags"
///     VkImageType imageType; // @link substring="VkImageType" target="VkImageType" @link substring="imageType" target="#imageType"
///     VkFormat format; // @link substring="VkFormat" target="VkFormat" @link substring="format" target="#format"
///     VkExtent3D extent; // @link substring="VkExtent3D" target="VkExtent3D" @link substring="extent" target="#extent"
///     uint32_t mipLevels; // @link substring="mipLevels" target="#mipLevels"
///     uint32_t arrayLayers; // @link substring="arrayLayers" target="#arrayLayers"
///     VkSampleCountFlags samples; // @link substring="VkSampleCountFlags" target="VkSampleCountFlags" @link substring="samples" target="#samples"
///     VkImageTiling tiling; // @link substring="VkImageTiling" target="VkImageTiling" @link substring="tiling" target="#tiling"
///     VkImageUsageFlags usage; // @link substring="VkImageUsageFlags" target="VkImageUsageFlags" @link substring="usage" target="#usage"
///     VkSharingMode sharingMode; // @link substring="VkSharingMode" target="VkSharingMode" @link substring="sharingMode" target="#sharingMode"
///     uint32_t queueFamilyIndexCount; // optional // @link substring="queueFamilyIndexCount" target="#queueFamilyIndexCount"
///     uint32_t const* pQueueFamilyIndices; // optional // @link substring="pQueueFamilyIndices" target="#pQueueFamilyIndices"
///     VkImageLayout initialLayout; // @link substring="VkImageLayout" target="VkImageLayout" @link substring="initialLayout" target="#initialLayout"
/// } VkImageCreateInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_IMAGE_CREATE_INFO`
///
/// The {@code allocate} ({@link VkImageCreateInfo#allocate(Arena)}, {@link VkImageCreateInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkImageCreateInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageCreateInfo.html"><code>VkImageCreateInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkImageCreateInfo(@NotNull MemorySegment segment) implements IVkImageCreateInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageCreateInfo.html"><code>VkImageCreateInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkImageCreateInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkImageCreateInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkImageCreateInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkImageCreateInfo, Iterable<VkImageCreateInfo> {
        public long size() {
            return segment.byteSize() / VkImageCreateInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkImageCreateInfo at(long index) {
            return new VkImageCreateInfo(segment.asSlice(index * VkImageCreateInfo.BYTES, VkImageCreateInfo.BYTES));
        }

        public VkImageCreateInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkImageCreateInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkImageCreateInfo value) {
            MemorySegment s = segment.asSlice(index * VkImageCreateInfo.BYTES, VkImageCreateInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkImageCreateInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkImageCreateInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkImageCreateInfo.BYTES,
                (end - start) * VkImageCreateInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkImageCreateInfo.BYTES));
        }

        public VkImageCreateInfo[] toArray() {
            VkImageCreateInfo[] ret = new VkImageCreateInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkImageCreateInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkImageCreateInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkImageCreateInfo.BYTES;
            }

            @Override
            public VkImageCreateInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkImageCreateInfo ret = new VkImageCreateInfo(segment.asSlice(0, VkImageCreateInfo.BYTES));
                segment = segment.asSlice(VkImageCreateInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkImageCreateInfo allocate(Arena arena) {
        VkImageCreateInfo ret = new VkImageCreateInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.IMAGE_CREATE_INFO);
        return ret;
    }

    public static VkImageCreateInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkImageCreateInfo.Ptr ret = new VkImageCreateInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.IMAGE_CREATE_INFO);
        }
        return ret;
    }

    public static VkImageCreateInfo clone(Arena arena, VkImageCreateInfo src) {
        VkImageCreateInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.IMAGE_CREATE_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkImageCreateInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkImageCreateInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkImageCreateInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkImageCreateFlags.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkImageCreateInfo flags(@Bitmask(VkImageCreateFlags.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @EnumType(VkImageType.class) int imageType() {
        return segment.get(LAYOUT$imageType, OFFSET$imageType);
    }

    public VkImageCreateInfo imageType(@EnumType(VkImageType.class) int value) {
        segment.set(LAYOUT$imageType, OFFSET$imageType, value);
        return this;
    }

    public @EnumType(VkFormat.class) int format() {
        return segment.get(LAYOUT$format, OFFSET$format);
    }

    public VkImageCreateInfo format(@EnumType(VkFormat.class) int value) {
        segment.set(LAYOUT$format, OFFSET$format, value);
        return this;
    }

    public @NotNull VkExtent3D extent() {
        return new VkExtent3D(segment.asSlice(OFFSET$extent, LAYOUT$extent));
    }

    public VkImageCreateInfo extent(@NotNull VkExtent3D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$extent, SIZE$extent);
        return this;
    }

    public VkImageCreateInfo extent(Consumer<@NotNull VkExtent3D> consumer) {
        consumer.accept(extent());
        return this;
    }

    public @Unsigned int mipLevels() {
        return segment.get(LAYOUT$mipLevels, OFFSET$mipLevels);
    }

    public VkImageCreateInfo mipLevels(@Unsigned int value) {
        segment.set(LAYOUT$mipLevels, OFFSET$mipLevels, value);
        return this;
    }

    public @Unsigned int arrayLayers() {
        return segment.get(LAYOUT$arrayLayers, OFFSET$arrayLayers);
    }

    public VkImageCreateInfo arrayLayers(@Unsigned int value) {
        segment.set(LAYOUT$arrayLayers, OFFSET$arrayLayers, value);
        return this;
    }

    public @Bitmask(VkSampleCountFlags.class) int samples() {
        return segment.get(LAYOUT$samples, OFFSET$samples);
    }

    public VkImageCreateInfo samples(@Bitmask(VkSampleCountFlags.class) int value) {
        segment.set(LAYOUT$samples, OFFSET$samples, value);
        return this;
    }

    public @EnumType(VkImageTiling.class) int tiling() {
        return segment.get(LAYOUT$tiling, OFFSET$tiling);
    }

    public VkImageCreateInfo tiling(@EnumType(VkImageTiling.class) int value) {
        segment.set(LAYOUT$tiling, OFFSET$tiling, value);
        return this;
    }

    public @Bitmask(VkImageUsageFlags.class) int usage() {
        return segment.get(LAYOUT$usage, OFFSET$usage);
    }

    public VkImageCreateInfo usage(@Bitmask(VkImageUsageFlags.class) int value) {
        segment.set(LAYOUT$usage, OFFSET$usage, value);
        return this;
    }

    public @EnumType(VkSharingMode.class) int sharingMode() {
        return segment.get(LAYOUT$sharingMode, OFFSET$sharingMode);
    }

    public VkImageCreateInfo sharingMode(@EnumType(VkSharingMode.class) int value) {
        segment.set(LAYOUT$sharingMode, OFFSET$sharingMode, value);
        return this;
    }

    public @Unsigned int queueFamilyIndexCount() {
        return segment.get(LAYOUT$queueFamilyIndexCount, OFFSET$queueFamilyIndexCount);
    }

    public VkImageCreateInfo queueFamilyIndexCount(@Unsigned int value) {
        segment.set(LAYOUT$queueFamilyIndexCount, OFFSET$queueFamilyIndexCount, value);
        return this;
    }

    /// Note: the returned {@link IntPtr} does not have correct
    /// {@link IntPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link IntPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable @Unsigned IntPtr pQueueFamilyIndices() {
        MemorySegment s = pQueueFamilyIndicesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new IntPtr(s);
    }

    public VkImageCreateInfo pQueueFamilyIndices(@Nullable @Unsigned IntPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pQueueFamilyIndicesRaw(s);
        return this;
    }

    public @Pointer(comment="uint32_t*") @NotNull MemorySegment pQueueFamilyIndicesRaw() {
        return segment.get(LAYOUT$pQueueFamilyIndices, OFFSET$pQueueFamilyIndices);
    }

    public void pQueueFamilyIndicesRaw(@Pointer(comment="uint32_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pQueueFamilyIndices, OFFSET$pQueueFamilyIndices, value);
    }

    public @EnumType(VkImageLayout.class) int initialLayout() {
        return segment.get(LAYOUT$initialLayout, OFFSET$initialLayout);
    }

    public VkImageCreateInfo initialLayout(@EnumType(VkImageLayout.class) int value) {
        segment.set(LAYOUT$initialLayout, OFFSET$initialLayout, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("imageType"),
        ValueLayout.JAVA_INT.withName("format"),
        VkExtent3D.LAYOUT.withName("extent"),
        ValueLayout.JAVA_INT.withName("mipLevels"),
        ValueLayout.JAVA_INT.withName("arrayLayers"),
        ValueLayout.JAVA_INT.withName("samples"),
        ValueLayout.JAVA_INT.withName("tiling"),
        ValueLayout.JAVA_INT.withName("usage"),
        ValueLayout.JAVA_INT.withName("sharingMode"),
        ValueLayout.JAVA_INT.withName("queueFamilyIndexCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pQueueFamilyIndices"),
        ValueLayout.JAVA_INT.withName("initialLayout")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$imageType = PathElement.groupElement("imageType");
    public static final PathElement PATH$format = PathElement.groupElement("format");
    public static final PathElement PATH$extent = PathElement.groupElement("extent");
    public static final PathElement PATH$mipLevels = PathElement.groupElement("mipLevels");
    public static final PathElement PATH$arrayLayers = PathElement.groupElement("arrayLayers");
    public static final PathElement PATH$samples = PathElement.groupElement("samples");
    public static final PathElement PATH$tiling = PathElement.groupElement("tiling");
    public static final PathElement PATH$usage = PathElement.groupElement("usage");
    public static final PathElement PATH$sharingMode = PathElement.groupElement("sharingMode");
    public static final PathElement PATH$queueFamilyIndexCount = PathElement.groupElement("queueFamilyIndexCount");
    public static final PathElement PATH$pQueueFamilyIndices = PathElement.groupElement("pQueueFamilyIndices");
    public static final PathElement PATH$initialLayout = PathElement.groupElement("initialLayout");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$imageType = (OfInt) LAYOUT.select(PATH$imageType);
    public static final OfInt LAYOUT$format = (OfInt) LAYOUT.select(PATH$format);
    public static final StructLayout LAYOUT$extent = (StructLayout) LAYOUT.select(PATH$extent);
    public static final OfInt LAYOUT$mipLevels = (OfInt) LAYOUT.select(PATH$mipLevels);
    public static final OfInt LAYOUT$arrayLayers = (OfInt) LAYOUT.select(PATH$arrayLayers);
    public static final OfInt LAYOUT$samples = (OfInt) LAYOUT.select(PATH$samples);
    public static final OfInt LAYOUT$tiling = (OfInt) LAYOUT.select(PATH$tiling);
    public static final OfInt LAYOUT$usage = (OfInt) LAYOUT.select(PATH$usage);
    public static final OfInt LAYOUT$sharingMode = (OfInt) LAYOUT.select(PATH$sharingMode);
    public static final OfInt LAYOUT$queueFamilyIndexCount = (OfInt) LAYOUT.select(PATH$queueFamilyIndexCount);
    public static final AddressLayout LAYOUT$pQueueFamilyIndices = (AddressLayout) LAYOUT.select(PATH$pQueueFamilyIndices);
    public static final OfInt LAYOUT$initialLayout = (OfInt) LAYOUT.select(PATH$initialLayout);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$imageType = LAYOUT$imageType.byteSize();
    public static final long SIZE$format = LAYOUT$format.byteSize();
    public static final long SIZE$extent = LAYOUT$extent.byteSize();
    public static final long SIZE$mipLevels = LAYOUT$mipLevels.byteSize();
    public static final long SIZE$arrayLayers = LAYOUT$arrayLayers.byteSize();
    public static final long SIZE$samples = LAYOUT$samples.byteSize();
    public static final long SIZE$tiling = LAYOUT$tiling.byteSize();
    public static final long SIZE$usage = LAYOUT$usage.byteSize();
    public static final long SIZE$sharingMode = LAYOUT$sharingMode.byteSize();
    public static final long SIZE$queueFamilyIndexCount = LAYOUT$queueFamilyIndexCount.byteSize();
    public static final long SIZE$pQueueFamilyIndices = LAYOUT$pQueueFamilyIndices.byteSize();
    public static final long SIZE$initialLayout = LAYOUT$initialLayout.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$imageType = LAYOUT.byteOffset(PATH$imageType);
    public static final long OFFSET$format = LAYOUT.byteOffset(PATH$format);
    public static final long OFFSET$extent = LAYOUT.byteOffset(PATH$extent);
    public static final long OFFSET$mipLevels = LAYOUT.byteOffset(PATH$mipLevels);
    public static final long OFFSET$arrayLayers = LAYOUT.byteOffset(PATH$arrayLayers);
    public static final long OFFSET$samples = LAYOUT.byteOffset(PATH$samples);
    public static final long OFFSET$tiling = LAYOUT.byteOffset(PATH$tiling);
    public static final long OFFSET$usage = LAYOUT.byteOffset(PATH$usage);
    public static final long OFFSET$sharingMode = LAYOUT.byteOffset(PATH$sharingMode);
    public static final long OFFSET$queueFamilyIndexCount = LAYOUT.byteOffset(PATH$queueFamilyIndexCount);
    public static final long OFFSET$pQueueFamilyIndices = LAYOUT.byteOffset(PATH$pQueueFamilyIndices);
    public static final long OFFSET$initialLayout = LAYOUT.byteOffset(PATH$initialLayout);
}
