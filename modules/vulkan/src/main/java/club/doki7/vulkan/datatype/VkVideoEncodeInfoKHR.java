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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeInfoKHR.html"><code>VkVideoEncodeInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkVideoEncodeInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkVideoEncodeFlagsKHR flags; // optional // @link substring="VkVideoEncodeFlagsKHR" target="VkVideoEncodeFlagsKHR" @link substring="flags" target="#flags"
///     VkBuffer dstBuffer; // @link substring="VkBuffer" target="VkBuffer" @link substring="dstBuffer" target="#dstBuffer"
///     VkDeviceSize dstBufferOffset; // @link substring="dstBufferOffset" target="#dstBufferOffset"
///     VkDeviceSize dstBufferRange; // @link substring="dstBufferRange" target="#dstBufferRange"
///     VkVideoPictureResourceInfoKHR srcPictureResource; // @link substring="VkVideoPictureResourceInfoKHR" target="VkVideoPictureResourceInfoKHR" @link substring="srcPictureResource" target="#srcPictureResource"
///     VkVideoReferenceSlotInfoKHR const* pSetupReferenceSlot; // optional // @link substring="VkVideoReferenceSlotInfoKHR" target="VkVideoReferenceSlotInfoKHR" @link substring="pSetupReferenceSlot" target="#pSetupReferenceSlot"
///     uint32_t referenceSlotCount; // optional // @link substring="referenceSlotCount" target="#referenceSlotCount"
///     VkVideoReferenceSlotInfoKHR const* pReferenceSlots; // optional // @link substring="VkVideoReferenceSlotInfoKHR" target="VkVideoReferenceSlotInfoKHR" @link substring="pReferenceSlots" target="#pReferenceSlots"
///     uint32_t precedingExternallyEncodedBytes; // @link substring="precedingExternallyEncodedBytes" target="#precedingExternallyEncodedBytes"
/// } VkVideoEncodeInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_VIDEO_ENCODE_INFO_KHR`
/// - `srcPictureResource.autoInit()`
///
/// The {@code allocate} ({@link VkVideoEncodeInfoKHR#allocate(Arena)}, {@link VkVideoEncodeInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkVideoEncodeInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeInfoKHR.html"><code>VkVideoEncodeInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkVideoEncodeInfoKHR(@NotNull MemorySegment segment) implements IVkVideoEncodeInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeInfoKHR.html"><code>VkVideoEncodeInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkVideoEncodeInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkVideoEncodeInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkVideoEncodeInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkVideoEncodeInfoKHR, Iterable<VkVideoEncodeInfoKHR> {
        public long size() {
            return segment.byteSize() / VkVideoEncodeInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkVideoEncodeInfoKHR at(long index) {
            return new VkVideoEncodeInfoKHR(segment.asSlice(index * VkVideoEncodeInfoKHR.BYTES, VkVideoEncodeInfoKHR.BYTES));
        }

        public VkVideoEncodeInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkVideoEncodeInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkVideoEncodeInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkVideoEncodeInfoKHR.BYTES, VkVideoEncodeInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkVideoEncodeInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkVideoEncodeInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkVideoEncodeInfoKHR.BYTES,
                (end - start) * VkVideoEncodeInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkVideoEncodeInfoKHR.BYTES));
        }

        public VkVideoEncodeInfoKHR[] toArray() {
            VkVideoEncodeInfoKHR[] ret = new VkVideoEncodeInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkVideoEncodeInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkVideoEncodeInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkVideoEncodeInfoKHR.BYTES;
            }

            @Override
            public VkVideoEncodeInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkVideoEncodeInfoKHR ret = new VkVideoEncodeInfoKHR(segment.asSlice(0, VkVideoEncodeInfoKHR.BYTES));
                segment = segment.asSlice(VkVideoEncodeInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkVideoEncodeInfoKHR allocate(Arena arena) {
        VkVideoEncodeInfoKHR ret = new VkVideoEncodeInfoKHR(arena.allocate(LAYOUT));
        ret.autoInit();
        return ret;
    }

    public static VkVideoEncodeInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkVideoEncodeInfoKHR.Ptr ret = new VkVideoEncodeInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).autoInit();
        }
        return ret;
    }

    public static VkVideoEncodeInfoKHR clone(Arena arena, VkVideoEncodeInfoKHR src) {
        VkVideoEncodeInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.VIDEO_ENCODE_INFO_KHR);
        srcPictureResource().autoInit();
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkVideoEncodeInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkVideoEncodeInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkVideoEncodeInfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkVideoEncodeFlagsKHR.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkVideoEncodeInfoKHR flags(@Bitmask(VkVideoEncodeFlagsKHR.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @Nullable VkBuffer dstBuffer() {
        MemorySegment s = segment.asSlice(OFFSET$dstBuffer, SIZE$dstBuffer);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkBuffer(s);
    }

    public VkVideoEncodeInfoKHR dstBuffer(@Nullable VkBuffer value) {
        segment.set(LAYOUT$dstBuffer, OFFSET$dstBuffer, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long dstBufferOffset() {
        return segment.get(LAYOUT$dstBufferOffset, OFFSET$dstBufferOffset);
    }

    public VkVideoEncodeInfoKHR dstBufferOffset(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$dstBufferOffset, OFFSET$dstBufferOffset, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long dstBufferRange() {
        return segment.get(LAYOUT$dstBufferRange, OFFSET$dstBufferRange);
    }

    public VkVideoEncodeInfoKHR dstBufferRange(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$dstBufferRange, OFFSET$dstBufferRange, value);
        return this;
    }

    public @NotNull VkVideoPictureResourceInfoKHR srcPictureResource() {
        return new VkVideoPictureResourceInfoKHR(segment.asSlice(OFFSET$srcPictureResource, LAYOUT$srcPictureResource));
    }

    public VkVideoEncodeInfoKHR srcPictureResource(@NotNull VkVideoPictureResourceInfoKHR value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$srcPictureResource, SIZE$srcPictureResource);
        return this;
    }

    public VkVideoEncodeInfoKHR srcPictureResource(Consumer<@NotNull VkVideoPictureResourceInfoKHR> consumer) {
        consumer.accept(srcPictureResource());
        return this;
    }

    public VkVideoEncodeInfoKHR pSetupReferenceSlot(@Nullable IVkVideoReferenceSlotInfoKHR value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pSetupReferenceSlotRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkVideoReferenceSlotInfoKHR.Ptr pSetupReferenceSlot(int assumedCount) {
        MemorySegment s = pSetupReferenceSlotRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkVideoReferenceSlotInfoKHR.BYTES);
        return new VkVideoReferenceSlotInfoKHR.Ptr(s);
    }

    public @Nullable VkVideoReferenceSlotInfoKHR pSetupReferenceSlot() {
        MemorySegment s = pSetupReferenceSlotRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkVideoReferenceSlotInfoKHR(s);
    }

    public @Pointer(target=VkVideoReferenceSlotInfoKHR.class) @NotNull MemorySegment pSetupReferenceSlotRaw() {
        return segment.get(LAYOUT$pSetupReferenceSlot, OFFSET$pSetupReferenceSlot);
    }

    public void pSetupReferenceSlotRaw(@Pointer(target=VkVideoReferenceSlotInfoKHR.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pSetupReferenceSlot, OFFSET$pSetupReferenceSlot, value);
    }

    public @Unsigned int referenceSlotCount() {
        return segment.get(LAYOUT$referenceSlotCount, OFFSET$referenceSlotCount);
    }

    public VkVideoEncodeInfoKHR referenceSlotCount(@Unsigned int value) {
        segment.set(LAYOUT$referenceSlotCount, OFFSET$referenceSlotCount, value);
        return this;
    }

    public VkVideoEncodeInfoKHR pReferenceSlots(@Nullable IVkVideoReferenceSlotInfoKHR value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pReferenceSlotsRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkVideoReferenceSlotInfoKHR.Ptr pReferenceSlots(int assumedCount) {
        MemorySegment s = pReferenceSlotsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkVideoReferenceSlotInfoKHR.BYTES);
        return new VkVideoReferenceSlotInfoKHR.Ptr(s);
    }

    public @Nullable VkVideoReferenceSlotInfoKHR pReferenceSlots() {
        MemorySegment s = pReferenceSlotsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkVideoReferenceSlotInfoKHR(s);
    }

    public @Pointer(target=VkVideoReferenceSlotInfoKHR.class) @NotNull MemorySegment pReferenceSlotsRaw() {
        return segment.get(LAYOUT$pReferenceSlots, OFFSET$pReferenceSlots);
    }

    public void pReferenceSlotsRaw(@Pointer(target=VkVideoReferenceSlotInfoKHR.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pReferenceSlots, OFFSET$pReferenceSlots, value);
    }

    public @Unsigned int precedingExternallyEncodedBytes() {
        return segment.get(LAYOUT$precedingExternallyEncodedBytes, OFFSET$precedingExternallyEncodedBytes);
    }

    public VkVideoEncodeInfoKHR precedingExternallyEncodedBytes(@Unsigned int value) {
        segment.set(LAYOUT$precedingExternallyEncodedBytes, OFFSET$precedingExternallyEncodedBytes, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.ADDRESS.withName("dstBuffer"),
        ValueLayout.JAVA_LONG.withName("dstBufferOffset"),
        ValueLayout.JAVA_LONG.withName("dstBufferRange"),
        VkVideoPictureResourceInfoKHR.LAYOUT.withName("srcPictureResource"),
        ValueLayout.ADDRESS.withTargetLayout(VkVideoReferenceSlotInfoKHR.LAYOUT).withName("pSetupReferenceSlot"),
        ValueLayout.JAVA_INT.withName("referenceSlotCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkVideoReferenceSlotInfoKHR.LAYOUT).withName("pReferenceSlots"),
        ValueLayout.JAVA_INT.withName("precedingExternallyEncodedBytes")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$dstBuffer = PathElement.groupElement("dstBuffer");
    public static final PathElement PATH$dstBufferOffset = PathElement.groupElement("dstBufferOffset");
    public static final PathElement PATH$dstBufferRange = PathElement.groupElement("dstBufferRange");
    public static final PathElement PATH$srcPictureResource = PathElement.groupElement("srcPictureResource");
    public static final PathElement PATH$pSetupReferenceSlot = PathElement.groupElement("pSetupReferenceSlot");
    public static final PathElement PATH$referenceSlotCount = PathElement.groupElement("referenceSlotCount");
    public static final PathElement PATH$pReferenceSlots = PathElement.groupElement("pReferenceSlots");
    public static final PathElement PATH$precedingExternallyEncodedBytes = PathElement.groupElement("precedingExternallyEncodedBytes");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final AddressLayout LAYOUT$dstBuffer = (AddressLayout) LAYOUT.select(PATH$dstBuffer);
    public static final OfLong LAYOUT$dstBufferOffset = (OfLong) LAYOUT.select(PATH$dstBufferOffset);
    public static final OfLong LAYOUT$dstBufferRange = (OfLong) LAYOUT.select(PATH$dstBufferRange);
    public static final StructLayout LAYOUT$srcPictureResource = (StructLayout) LAYOUT.select(PATH$srcPictureResource);
    public static final AddressLayout LAYOUT$pSetupReferenceSlot = (AddressLayout) LAYOUT.select(PATH$pSetupReferenceSlot);
    public static final OfInt LAYOUT$referenceSlotCount = (OfInt) LAYOUT.select(PATH$referenceSlotCount);
    public static final AddressLayout LAYOUT$pReferenceSlots = (AddressLayout) LAYOUT.select(PATH$pReferenceSlots);
    public static final OfInt LAYOUT$precedingExternallyEncodedBytes = (OfInt) LAYOUT.select(PATH$precedingExternallyEncodedBytes);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$dstBuffer = LAYOUT$dstBuffer.byteSize();
    public static final long SIZE$dstBufferOffset = LAYOUT$dstBufferOffset.byteSize();
    public static final long SIZE$dstBufferRange = LAYOUT$dstBufferRange.byteSize();
    public static final long SIZE$srcPictureResource = LAYOUT$srcPictureResource.byteSize();
    public static final long SIZE$pSetupReferenceSlot = LAYOUT$pSetupReferenceSlot.byteSize();
    public static final long SIZE$referenceSlotCount = LAYOUT$referenceSlotCount.byteSize();
    public static final long SIZE$pReferenceSlots = LAYOUT$pReferenceSlots.byteSize();
    public static final long SIZE$precedingExternallyEncodedBytes = LAYOUT$precedingExternallyEncodedBytes.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$dstBuffer = LAYOUT.byteOffset(PATH$dstBuffer);
    public static final long OFFSET$dstBufferOffset = LAYOUT.byteOffset(PATH$dstBufferOffset);
    public static final long OFFSET$dstBufferRange = LAYOUT.byteOffset(PATH$dstBufferRange);
    public static final long OFFSET$srcPictureResource = LAYOUT.byteOffset(PATH$srcPictureResource);
    public static final long OFFSET$pSetupReferenceSlot = LAYOUT.byteOffset(PATH$pSetupReferenceSlot);
    public static final long OFFSET$referenceSlotCount = LAYOUT.byteOffset(PATH$referenceSlotCount);
    public static final long OFFSET$pReferenceSlots = LAYOUT.byteOffset(PATH$pReferenceSlots);
    public static final long OFFSET$precedingExternallyEncodedBytes = LAYOUT.byteOffset(PATH$precedingExternallyEncodedBytes);
}
