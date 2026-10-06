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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCopyMemoryToImageIndirectInfoKHR.html"><code>VkCopyMemoryToImageIndirectInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkCopyMemoryToImageIndirectInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkAddressCopyFlagsKHR srcCopyFlags; // optional // @link substring="VkAddressCopyFlagsKHR" target="VkAddressCopyFlagsKHR" @link substring="srcCopyFlags" target="#srcCopyFlags"
///     uint32_t copyCount; // @link substring="copyCount" target="#copyCount"
///     VkStridedDeviceAddressRangeKHR copyAddressRange; // @link substring="VkStridedDeviceAddressRangeKHR" target="VkStridedDeviceAddressRangeKHR" @link substring="copyAddressRange" target="#copyAddressRange"
///     VkImage dstImage; // @link substring="VkImage" target="VkImage" @link substring="dstImage" target="#dstImage"
///     VkImageLayout dstImageLayout; // @link substring="VkImageLayout" target="VkImageLayout" @link substring="dstImageLayout" target="#dstImageLayout"
///     VkImageSubresourceLayers const* pImageSubresources; // @link substring="VkImageSubresourceLayers" target="VkImageSubresourceLayers" @link substring="pImageSubresources" target="#pImageSubresources"
/// } VkCopyMemoryToImageIndirectInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_COPY_MEMORY_TO_IMAGE_INDIRECT_INFO_KHR`
///
/// The {@code allocate} ({@link VkCopyMemoryToImageIndirectInfoKHR#allocate(Arena)}, {@link VkCopyMemoryToImageIndirectInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkCopyMemoryToImageIndirectInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCopyMemoryToImageIndirectInfoKHR.html"><code>VkCopyMemoryToImageIndirectInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkCopyMemoryToImageIndirectInfoKHR(@NotNull MemorySegment segment) implements IVkCopyMemoryToImageIndirectInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCopyMemoryToImageIndirectInfoKHR.html"><code>VkCopyMemoryToImageIndirectInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkCopyMemoryToImageIndirectInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkCopyMemoryToImageIndirectInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkCopyMemoryToImageIndirectInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkCopyMemoryToImageIndirectInfoKHR, Iterable<VkCopyMemoryToImageIndirectInfoKHR> {
        public long size() {
            return segment.byteSize() / VkCopyMemoryToImageIndirectInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkCopyMemoryToImageIndirectInfoKHR at(long index) {
            return new VkCopyMemoryToImageIndirectInfoKHR(segment.asSlice(index * VkCopyMemoryToImageIndirectInfoKHR.BYTES, VkCopyMemoryToImageIndirectInfoKHR.BYTES));
        }

        public VkCopyMemoryToImageIndirectInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkCopyMemoryToImageIndirectInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkCopyMemoryToImageIndirectInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkCopyMemoryToImageIndirectInfoKHR.BYTES, VkCopyMemoryToImageIndirectInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkCopyMemoryToImageIndirectInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkCopyMemoryToImageIndirectInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkCopyMemoryToImageIndirectInfoKHR.BYTES,
                (end - start) * VkCopyMemoryToImageIndirectInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkCopyMemoryToImageIndirectInfoKHR.BYTES));
        }

        public VkCopyMemoryToImageIndirectInfoKHR[] toArray() {
            VkCopyMemoryToImageIndirectInfoKHR[] ret = new VkCopyMemoryToImageIndirectInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkCopyMemoryToImageIndirectInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkCopyMemoryToImageIndirectInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkCopyMemoryToImageIndirectInfoKHR.BYTES;
            }

            @Override
            public VkCopyMemoryToImageIndirectInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkCopyMemoryToImageIndirectInfoKHR ret = new VkCopyMemoryToImageIndirectInfoKHR(segment.asSlice(0, VkCopyMemoryToImageIndirectInfoKHR.BYTES));
                segment = segment.asSlice(VkCopyMemoryToImageIndirectInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkCopyMemoryToImageIndirectInfoKHR allocate(Arena arena) {
        VkCopyMemoryToImageIndirectInfoKHR ret = new VkCopyMemoryToImageIndirectInfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.COPY_MEMORY_TO_IMAGE_INDIRECT_INFO_KHR);
        return ret;
    }

    public static VkCopyMemoryToImageIndirectInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkCopyMemoryToImageIndirectInfoKHR.Ptr ret = new VkCopyMemoryToImageIndirectInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.COPY_MEMORY_TO_IMAGE_INDIRECT_INFO_KHR);
        }
        return ret;
    }

    public static VkCopyMemoryToImageIndirectInfoKHR clone(Arena arena, VkCopyMemoryToImageIndirectInfoKHR src) {
        VkCopyMemoryToImageIndirectInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.COPY_MEMORY_TO_IMAGE_INDIRECT_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkCopyMemoryToImageIndirectInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkCopyMemoryToImageIndirectInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkCopyMemoryToImageIndirectInfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkAddressCopyFlagsKHR.class) int srcCopyFlags() {
        return segment.get(LAYOUT$srcCopyFlags, OFFSET$srcCopyFlags);
    }

    public VkCopyMemoryToImageIndirectInfoKHR srcCopyFlags(@Bitmask(VkAddressCopyFlagsKHR.class) int value) {
        segment.set(LAYOUT$srcCopyFlags, OFFSET$srcCopyFlags, value);
        return this;
    }

    public @Unsigned int copyCount() {
        return segment.get(LAYOUT$copyCount, OFFSET$copyCount);
    }

    public VkCopyMemoryToImageIndirectInfoKHR copyCount(@Unsigned int value) {
        segment.set(LAYOUT$copyCount, OFFSET$copyCount, value);
        return this;
    }

    public @NotNull VkStridedDeviceAddressRangeKHR copyAddressRange() {
        return new VkStridedDeviceAddressRangeKHR(segment.asSlice(OFFSET$copyAddressRange, LAYOUT$copyAddressRange));
    }

    public VkCopyMemoryToImageIndirectInfoKHR copyAddressRange(@NotNull VkStridedDeviceAddressRangeKHR value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$copyAddressRange, SIZE$copyAddressRange);
        return this;
    }

    public VkCopyMemoryToImageIndirectInfoKHR copyAddressRange(Consumer<@NotNull VkStridedDeviceAddressRangeKHR> consumer) {
        consumer.accept(copyAddressRange());
        return this;
    }

    public @Nullable VkImage dstImage() {
        MemorySegment s = segment.asSlice(OFFSET$dstImage, SIZE$dstImage);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkImage(s);
    }

    public VkCopyMemoryToImageIndirectInfoKHR dstImage(@Nullable VkImage value) {
        segment.set(LAYOUT$dstImage, OFFSET$dstImage, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @EnumType(VkImageLayout.class) int dstImageLayout() {
        return segment.get(LAYOUT$dstImageLayout, OFFSET$dstImageLayout);
    }

    public VkCopyMemoryToImageIndirectInfoKHR dstImageLayout(@EnumType(VkImageLayout.class) int value) {
        segment.set(LAYOUT$dstImageLayout, OFFSET$dstImageLayout, value);
        return this;
    }

    public VkCopyMemoryToImageIndirectInfoKHR pImageSubresources(@Nullable IVkImageSubresourceLayers value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pImageSubresourcesRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkImageSubresourceLayers.Ptr pImageSubresources(int assumedCount) {
        MemorySegment s = pImageSubresourcesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkImageSubresourceLayers.BYTES);
        return new VkImageSubresourceLayers.Ptr(s);
    }

    public @Nullable VkImageSubresourceLayers pImageSubresources() {
        MemorySegment s = pImageSubresourcesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkImageSubresourceLayers(s);
    }

    public @Pointer(target=VkImageSubresourceLayers.class) @NotNull MemorySegment pImageSubresourcesRaw() {
        return segment.get(LAYOUT$pImageSubresources, OFFSET$pImageSubresources);
    }

    public void pImageSubresourcesRaw(@Pointer(target=VkImageSubresourceLayers.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pImageSubresources, OFFSET$pImageSubresources, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("srcCopyFlags"),
        ValueLayout.JAVA_INT.withName("copyCount"),
        VkStridedDeviceAddressRangeKHR.LAYOUT.withName("copyAddressRange"),
        ValueLayout.ADDRESS.withName("dstImage"),
        ValueLayout.JAVA_INT.withName("dstImageLayout"),
        ValueLayout.ADDRESS.withTargetLayout(VkImageSubresourceLayers.LAYOUT).withName("pImageSubresources")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$srcCopyFlags = PathElement.groupElement("srcCopyFlags");
    public static final PathElement PATH$copyCount = PathElement.groupElement("copyCount");
    public static final PathElement PATH$copyAddressRange = PathElement.groupElement("copyAddressRange");
    public static final PathElement PATH$dstImage = PathElement.groupElement("dstImage");
    public static final PathElement PATH$dstImageLayout = PathElement.groupElement("dstImageLayout");
    public static final PathElement PATH$pImageSubresources = PathElement.groupElement("pImageSubresources");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$srcCopyFlags = (OfInt) LAYOUT.select(PATH$srcCopyFlags);
    public static final OfInt LAYOUT$copyCount = (OfInt) LAYOUT.select(PATH$copyCount);
    public static final StructLayout LAYOUT$copyAddressRange = (StructLayout) LAYOUT.select(PATH$copyAddressRange);
    public static final AddressLayout LAYOUT$dstImage = (AddressLayout) LAYOUT.select(PATH$dstImage);
    public static final OfInt LAYOUT$dstImageLayout = (OfInt) LAYOUT.select(PATH$dstImageLayout);
    public static final AddressLayout LAYOUT$pImageSubresources = (AddressLayout) LAYOUT.select(PATH$pImageSubresources);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$srcCopyFlags = LAYOUT$srcCopyFlags.byteSize();
    public static final long SIZE$copyCount = LAYOUT$copyCount.byteSize();
    public static final long SIZE$copyAddressRange = LAYOUT$copyAddressRange.byteSize();
    public static final long SIZE$dstImage = LAYOUT$dstImage.byteSize();
    public static final long SIZE$dstImageLayout = LAYOUT$dstImageLayout.byteSize();
    public static final long SIZE$pImageSubresources = LAYOUT$pImageSubresources.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$srcCopyFlags = LAYOUT.byteOffset(PATH$srcCopyFlags);
    public static final long OFFSET$copyCount = LAYOUT.byteOffset(PATH$copyCount);
    public static final long OFFSET$copyAddressRange = LAYOUT.byteOffset(PATH$copyAddressRange);
    public static final long OFFSET$dstImage = LAYOUT.byteOffset(PATH$dstImage);
    public static final long OFFSET$dstImageLayout = LAYOUT.byteOffset(PATH$dstImageLayout);
    public static final long OFFSET$pImageSubresources = LAYOUT.byteOffset(PATH$pImageSubresources);
}
