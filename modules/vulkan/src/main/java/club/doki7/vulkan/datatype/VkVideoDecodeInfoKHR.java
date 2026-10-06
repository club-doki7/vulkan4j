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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoDecodeInfoKHR.html"><code>VkVideoDecodeInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkVideoDecodeInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkVideoDecodeFlagsKHR flags; // optional // @link substring="VkVideoDecodeFlagsKHR" target="VkVideoDecodeFlagsKHR" @link substring="flags" target="#flags"
///     VkBuffer srcBuffer; // @link substring="VkBuffer" target="VkBuffer" @link substring="srcBuffer" target="#srcBuffer"
///     VkDeviceSize srcBufferOffset; // @link substring="srcBufferOffset" target="#srcBufferOffset"
///     VkDeviceSize srcBufferRange; // @link substring="srcBufferRange" target="#srcBufferRange"
///     VkVideoPictureResourceInfoKHR dstPictureResource; // @link substring="VkVideoPictureResourceInfoKHR" target="VkVideoPictureResourceInfoKHR" @link substring="dstPictureResource" target="#dstPictureResource"
///     VkVideoReferenceSlotInfoKHR const* pSetupReferenceSlot; // optional // @link substring="VkVideoReferenceSlotInfoKHR" target="VkVideoReferenceSlotInfoKHR" @link substring="pSetupReferenceSlot" target="#pSetupReferenceSlot"
///     uint32_t referenceSlotCount; // optional // @link substring="referenceSlotCount" target="#referenceSlotCount"
///     VkVideoReferenceSlotInfoKHR const* pReferenceSlots; // optional // @link substring="VkVideoReferenceSlotInfoKHR" target="VkVideoReferenceSlotInfoKHR" @link substring="pReferenceSlots" target="#pReferenceSlots"
/// } VkVideoDecodeInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_VIDEO_DECODE_INFO_KHR`
/// - `dstPictureResource.autoInit()`
///
/// The {@code allocate} ({@link VkVideoDecodeInfoKHR#allocate(Arena)}, {@link VkVideoDecodeInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkVideoDecodeInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoDecodeInfoKHR.html"><code>VkVideoDecodeInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkVideoDecodeInfoKHR(@NotNull MemorySegment segment) implements IVkVideoDecodeInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoDecodeInfoKHR.html"><code>VkVideoDecodeInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkVideoDecodeInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkVideoDecodeInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkVideoDecodeInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkVideoDecodeInfoKHR, Iterable<VkVideoDecodeInfoKHR> {
        public long size() {
            return segment.byteSize() / VkVideoDecodeInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkVideoDecodeInfoKHR at(long index) {
            return new VkVideoDecodeInfoKHR(segment.asSlice(index * VkVideoDecodeInfoKHR.BYTES, VkVideoDecodeInfoKHR.BYTES));
        }

        public VkVideoDecodeInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkVideoDecodeInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkVideoDecodeInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkVideoDecodeInfoKHR.BYTES, VkVideoDecodeInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkVideoDecodeInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkVideoDecodeInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkVideoDecodeInfoKHR.BYTES,
                (end - start) * VkVideoDecodeInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkVideoDecodeInfoKHR.BYTES));
        }

        public VkVideoDecodeInfoKHR[] toArray() {
            VkVideoDecodeInfoKHR[] ret = new VkVideoDecodeInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkVideoDecodeInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkVideoDecodeInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkVideoDecodeInfoKHR.BYTES;
            }

            @Override
            public VkVideoDecodeInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkVideoDecodeInfoKHR ret = new VkVideoDecodeInfoKHR(segment.asSlice(0, VkVideoDecodeInfoKHR.BYTES));
                segment = segment.asSlice(VkVideoDecodeInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkVideoDecodeInfoKHR allocate(Arena arena) {
        VkVideoDecodeInfoKHR ret = new VkVideoDecodeInfoKHR(arena.allocate(LAYOUT));
        ret.autoInit();
        return ret;
    }

    public static VkVideoDecodeInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkVideoDecodeInfoKHR.Ptr ret = new VkVideoDecodeInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).autoInit();
        }
        return ret;
    }

    public static VkVideoDecodeInfoKHR clone(Arena arena, VkVideoDecodeInfoKHR src) {
        VkVideoDecodeInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.VIDEO_DECODE_INFO_KHR);
        dstPictureResource().autoInit();
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkVideoDecodeInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkVideoDecodeInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkVideoDecodeInfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkVideoDecodeFlagsKHR.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkVideoDecodeInfoKHR flags(@Bitmask(VkVideoDecodeFlagsKHR.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @Nullable VkBuffer srcBuffer() {
        MemorySegment s = segment.asSlice(OFFSET$srcBuffer, SIZE$srcBuffer);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkBuffer(s);
    }

    public VkVideoDecodeInfoKHR srcBuffer(@Nullable VkBuffer value) {
        segment.set(LAYOUT$srcBuffer, OFFSET$srcBuffer, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long srcBufferOffset() {
        return segment.get(LAYOUT$srcBufferOffset, OFFSET$srcBufferOffset);
    }

    public VkVideoDecodeInfoKHR srcBufferOffset(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$srcBufferOffset, OFFSET$srcBufferOffset, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long srcBufferRange() {
        return segment.get(LAYOUT$srcBufferRange, OFFSET$srcBufferRange);
    }

    public VkVideoDecodeInfoKHR srcBufferRange(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$srcBufferRange, OFFSET$srcBufferRange, value);
        return this;
    }

    public @NotNull VkVideoPictureResourceInfoKHR dstPictureResource() {
        return new VkVideoPictureResourceInfoKHR(segment.asSlice(OFFSET$dstPictureResource, LAYOUT$dstPictureResource));
    }

    public VkVideoDecodeInfoKHR dstPictureResource(@NotNull VkVideoPictureResourceInfoKHR value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$dstPictureResource, SIZE$dstPictureResource);
        return this;
    }

    public VkVideoDecodeInfoKHR dstPictureResource(Consumer<@NotNull VkVideoPictureResourceInfoKHR> consumer) {
        consumer.accept(dstPictureResource());
        return this;
    }

    public VkVideoDecodeInfoKHR pSetupReferenceSlot(@Nullable IVkVideoReferenceSlotInfoKHR value) {
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

    public VkVideoDecodeInfoKHR referenceSlotCount(@Unsigned int value) {
        segment.set(LAYOUT$referenceSlotCount, OFFSET$referenceSlotCount, value);
        return this;
    }

    public VkVideoDecodeInfoKHR pReferenceSlots(@Nullable IVkVideoReferenceSlotInfoKHR value) {
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

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.ADDRESS.withName("srcBuffer"),
        ValueLayout.JAVA_LONG.withName("srcBufferOffset"),
        ValueLayout.JAVA_LONG.withName("srcBufferRange"),
        VkVideoPictureResourceInfoKHR.LAYOUT.withName("dstPictureResource"),
        ValueLayout.ADDRESS.withTargetLayout(VkVideoReferenceSlotInfoKHR.LAYOUT).withName("pSetupReferenceSlot"),
        ValueLayout.JAVA_INT.withName("referenceSlotCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkVideoReferenceSlotInfoKHR.LAYOUT).withName("pReferenceSlots")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$srcBuffer = PathElement.groupElement("srcBuffer");
    public static final PathElement PATH$srcBufferOffset = PathElement.groupElement("srcBufferOffset");
    public static final PathElement PATH$srcBufferRange = PathElement.groupElement("srcBufferRange");
    public static final PathElement PATH$dstPictureResource = PathElement.groupElement("dstPictureResource");
    public static final PathElement PATH$pSetupReferenceSlot = PathElement.groupElement("pSetupReferenceSlot");
    public static final PathElement PATH$referenceSlotCount = PathElement.groupElement("referenceSlotCount");
    public static final PathElement PATH$pReferenceSlots = PathElement.groupElement("pReferenceSlots");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final AddressLayout LAYOUT$srcBuffer = (AddressLayout) LAYOUT.select(PATH$srcBuffer);
    public static final OfLong LAYOUT$srcBufferOffset = (OfLong) LAYOUT.select(PATH$srcBufferOffset);
    public static final OfLong LAYOUT$srcBufferRange = (OfLong) LAYOUT.select(PATH$srcBufferRange);
    public static final StructLayout LAYOUT$dstPictureResource = (StructLayout) LAYOUT.select(PATH$dstPictureResource);
    public static final AddressLayout LAYOUT$pSetupReferenceSlot = (AddressLayout) LAYOUT.select(PATH$pSetupReferenceSlot);
    public static final OfInt LAYOUT$referenceSlotCount = (OfInt) LAYOUT.select(PATH$referenceSlotCount);
    public static final AddressLayout LAYOUT$pReferenceSlots = (AddressLayout) LAYOUT.select(PATH$pReferenceSlots);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$srcBuffer = LAYOUT$srcBuffer.byteSize();
    public static final long SIZE$srcBufferOffset = LAYOUT$srcBufferOffset.byteSize();
    public static final long SIZE$srcBufferRange = LAYOUT$srcBufferRange.byteSize();
    public static final long SIZE$dstPictureResource = LAYOUT$dstPictureResource.byteSize();
    public static final long SIZE$pSetupReferenceSlot = LAYOUT$pSetupReferenceSlot.byteSize();
    public static final long SIZE$referenceSlotCount = LAYOUT$referenceSlotCount.byteSize();
    public static final long SIZE$pReferenceSlots = LAYOUT$pReferenceSlots.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$srcBuffer = LAYOUT.byteOffset(PATH$srcBuffer);
    public static final long OFFSET$srcBufferOffset = LAYOUT.byteOffset(PATH$srcBufferOffset);
    public static final long OFFSET$srcBufferRange = LAYOUT.byteOffset(PATH$srcBufferRange);
    public static final long OFFSET$dstPictureResource = LAYOUT.byteOffset(PATH$dstPictureResource);
    public static final long OFFSET$pSetupReferenceSlot = LAYOUT.byteOffset(PATH$pSetupReferenceSlot);
    public static final long OFFSET$referenceSlotCount = LAYOUT.byteOffset(PATH$referenceSlotCount);
    public static final long OFFSET$pReferenceSlots = LAYOUT.byteOffset(PATH$pReferenceSlots);
}
