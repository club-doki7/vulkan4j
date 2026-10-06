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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSubmitInfo.html"><code>VkSubmitInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkSubmitInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t waitSemaphoreCount; // optional // @link substring="waitSemaphoreCount" target="#waitSemaphoreCount"
///     VkSemaphore const* pWaitSemaphores; // optional // @link substring="VkSemaphore" target="VkSemaphore" @link substring="pWaitSemaphores" target="#pWaitSemaphores"
///     VkPipelineStageFlags const* pWaitDstStageMask; // optional // @link substring="VkPipelineStageFlags" target="VkPipelineStageFlags" @link substring="pWaitDstStageMask" target="#pWaitDstStageMask"
///     uint32_t commandBufferCount; // optional // @link substring="commandBufferCount" target="#commandBufferCount"
///     VkCommandBuffer const* pCommandBuffers; // optional // @link substring="VkCommandBuffer" target="VkCommandBuffer" @link substring="pCommandBuffers" target="#pCommandBuffers"
///     uint32_t signalSemaphoreCount; // optional // @link substring="signalSemaphoreCount" target="#signalSemaphoreCount"
///     VkSemaphore const* pSignalSemaphores; // optional // @link substring="VkSemaphore" target="VkSemaphore" @link substring="pSignalSemaphores" target="#pSignalSemaphores"
/// } VkSubmitInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_SUBMIT_INFO`
///
/// The {@code allocate} ({@link VkSubmitInfo#allocate(Arena)}, {@link VkSubmitInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkSubmitInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSubmitInfo.html"><code>VkSubmitInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkSubmitInfo(@NotNull MemorySegment segment) implements IVkSubmitInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSubmitInfo.html"><code>VkSubmitInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkSubmitInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkSubmitInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkSubmitInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkSubmitInfo, Iterable<VkSubmitInfo> {
        public long size() {
            return segment.byteSize() / VkSubmitInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkSubmitInfo at(long index) {
            return new VkSubmitInfo(segment.asSlice(index * VkSubmitInfo.BYTES, VkSubmitInfo.BYTES));
        }

        public VkSubmitInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkSubmitInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkSubmitInfo value) {
            MemorySegment s = segment.asSlice(index * VkSubmitInfo.BYTES, VkSubmitInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkSubmitInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkSubmitInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkSubmitInfo.BYTES,
                (end - start) * VkSubmitInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkSubmitInfo.BYTES));
        }

        public VkSubmitInfo[] toArray() {
            VkSubmitInfo[] ret = new VkSubmitInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkSubmitInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkSubmitInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkSubmitInfo.BYTES;
            }

            @Override
            public VkSubmitInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkSubmitInfo ret = new VkSubmitInfo(segment.asSlice(0, VkSubmitInfo.BYTES));
                segment = segment.asSlice(VkSubmitInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkSubmitInfo allocate(Arena arena) {
        VkSubmitInfo ret = new VkSubmitInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.SUBMIT_INFO);
        return ret;
    }

    public static VkSubmitInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkSubmitInfo.Ptr ret = new VkSubmitInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.SUBMIT_INFO);
        }
        return ret;
    }

    public static VkSubmitInfo clone(Arena arena, VkSubmitInfo src) {
        VkSubmitInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.SUBMIT_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkSubmitInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkSubmitInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkSubmitInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int waitSemaphoreCount() {
        return segment.get(LAYOUT$waitSemaphoreCount, OFFSET$waitSemaphoreCount);
    }

    public VkSubmitInfo waitSemaphoreCount(@Unsigned int value) {
        segment.set(LAYOUT$waitSemaphoreCount, OFFSET$waitSemaphoreCount, value);
        return this;
    }

    /// Note: the returned {@link VkSemaphore.Ptr} does not have correct {@link VkSemaphore.Ptr#size}
    /// property. It's up to user to track the size of the buffer, and use
    /// {@link VkSemaphore.Ptr#reinterpret} to set the size before actually reading from or writing to the
    /// buffer.
    public @Nullable VkSemaphore.Ptr pWaitSemaphores() {
        MemorySegment s = pWaitSemaphoresRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkSemaphore.Ptr(s);
    }

    public VkSubmitInfo pWaitSemaphores(@Nullable VkSemaphore.Ptr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pWaitSemaphoresRaw(s);
        return this;
    }

    public @Pointer(target=VkSemaphore.class) @NotNull MemorySegment pWaitSemaphoresRaw() {
        return segment.get(LAYOUT$pWaitSemaphores, OFFSET$pWaitSemaphores);
    }

    public void pWaitSemaphoresRaw(@Pointer(target=VkSemaphore.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pWaitSemaphores, OFFSET$pWaitSemaphores, value);
    }


    /// Note: the returned {@link IntPtr} does not have correct
    /// {@link IntPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link IntPtr#reinterpret} to set the size before actually reading fro
    /// or writing to the buffer.
    public @Nullable @Bitmask(VkPipelineStageFlags.class) IntPtr pWaitDstStageMask() {
        MemorySegment s = pWaitDstStageMaskRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new IntPtr(s);
    }

    public VkSubmitInfo pWaitDstStageMask(@Nullable @Bitmask(VkPipelineStageFlags.class) IntPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pWaitDstStageMaskRaw(s);
        return this;
    }

    public @Pointer(target=VkPipelineStageFlags.class) @NotNull MemorySegment pWaitDstStageMaskRaw() {
        return segment.get(LAYOUT$pWaitDstStageMask, OFFSET$pWaitDstStageMask);
    }

    public void pWaitDstStageMaskRaw(@Pointer(target=VkPipelineStageFlags.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pWaitDstStageMask, OFFSET$pWaitDstStageMask, value);
    }

    public @Unsigned int commandBufferCount() {
        return segment.get(LAYOUT$commandBufferCount, OFFSET$commandBufferCount);
    }

    public VkSubmitInfo commandBufferCount(@Unsigned int value) {
        segment.set(LAYOUT$commandBufferCount, OFFSET$commandBufferCount, value);
        return this;
    }

    /// Note: the returned {@link VkCommandBuffer.Ptr} does not have correct {@link VkCommandBuffer.Ptr#size}
    /// property. It's up to user to track the size of the buffer, and use
    /// {@link VkCommandBuffer.Ptr#reinterpret} to set the size before actually reading from or writing to the
    /// buffer.
    public @Nullable VkCommandBuffer.Ptr pCommandBuffers() {
        MemorySegment s = pCommandBuffersRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkCommandBuffer.Ptr(s);
    }

    public VkSubmitInfo pCommandBuffers(@Nullable VkCommandBuffer.Ptr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pCommandBuffersRaw(s);
        return this;
    }

    public @Pointer(target=VkCommandBuffer.class) @NotNull MemorySegment pCommandBuffersRaw() {
        return segment.get(LAYOUT$pCommandBuffers, OFFSET$pCommandBuffers);
    }

    public void pCommandBuffersRaw(@Pointer(target=VkCommandBuffer.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pCommandBuffers, OFFSET$pCommandBuffers, value);
    }

    public @Unsigned int signalSemaphoreCount() {
        return segment.get(LAYOUT$signalSemaphoreCount, OFFSET$signalSemaphoreCount);
    }

    public VkSubmitInfo signalSemaphoreCount(@Unsigned int value) {
        segment.set(LAYOUT$signalSemaphoreCount, OFFSET$signalSemaphoreCount, value);
        return this;
    }

    /// Note: the returned {@link VkSemaphore.Ptr} does not have correct {@link VkSemaphore.Ptr#size}
    /// property. It's up to user to track the size of the buffer, and use
    /// {@link VkSemaphore.Ptr#reinterpret} to set the size before actually reading from or writing to the
    /// buffer.
    public @Nullable VkSemaphore.Ptr pSignalSemaphores() {
        MemorySegment s = pSignalSemaphoresRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkSemaphore.Ptr(s);
    }

    public VkSubmitInfo pSignalSemaphores(@Nullable VkSemaphore.Ptr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pSignalSemaphoresRaw(s);
        return this;
    }

    public @Pointer(target=VkSemaphore.class) @NotNull MemorySegment pSignalSemaphoresRaw() {
        return segment.get(LAYOUT$pSignalSemaphores, OFFSET$pSignalSemaphores);
    }

    public void pSignalSemaphoresRaw(@Pointer(target=VkSemaphore.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pSignalSemaphores, OFFSET$pSignalSemaphores, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("waitSemaphoreCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS).withName("pWaitSemaphores"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pWaitDstStageMask"),
        ValueLayout.JAVA_INT.withName("commandBufferCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS).withName("pCommandBuffers"),
        ValueLayout.JAVA_INT.withName("signalSemaphoreCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS).withName("pSignalSemaphores")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$waitSemaphoreCount = PathElement.groupElement("waitSemaphoreCount");
    public static final PathElement PATH$pWaitSemaphores = PathElement.groupElement("pWaitSemaphores");
    public static final PathElement PATH$pWaitDstStageMask = PathElement.groupElement("pWaitDstStageMask");
    public static final PathElement PATH$commandBufferCount = PathElement.groupElement("commandBufferCount");
    public static final PathElement PATH$pCommandBuffers = PathElement.groupElement("pCommandBuffers");
    public static final PathElement PATH$signalSemaphoreCount = PathElement.groupElement("signalSemaphoreCount");
    public static final PathElement PATH$pSignalSemaphores = PathElement.groupElement("pSignalSemaphores");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$waitSemaphoreCount = (OfInt) LAYOUT.select(PATH$waitSemaphoreCount);
    public static final AddressLayout LAYOUT$pWaitSemaphores = (AddressLayout) LAYOUT.select(PATH$pWaitSemaphores);
    public static final AddressLayout LAYOUT$pWaitDstStageMask = (AddressLayout) LAYOUT.select(PATH$pWaitDstStageMask);
    public static final OfInt LAYOUT$commandBufferCount = (OfInt) LAYOUT.select(PATH$commandBufferCount);
    public static final AddressLayout LAYOUT$pCommandBuffers = (AddressLayout) LAYOUT.select(PATH$pCommandBuffers);
    public static final OfInt LAYOUT$signalSemaphoreCount = (OfInt) LAYOUT.select(PATH$signalSemaphoreCount);
    public static final AddressLayout LAYOUT$pSignalSemaphores = (AddressLayout) LAYOUT.select(PATH$pSignalSemaphores);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$waitSemaphoreCount = LAYOUT$waitSemaphoreCount.byteSize();
    public static final long SIZE$pWaitSemaphores = LAYOUT$pWaitSemaphores.byteSize();
    public static final long SIZE$pWaitDstStageMask = LAYOUT$pWaitDstStageMask.byteSize();
    public static final long SIZE$commandBufferCount = LAYOUT$commandBufferCount.byteSize();
    public static final long SIZE$pCommandBuffers = LAYOUT$pCommandBuffers.byteSize();
    public static final long SIZE$signalSemaphoreCount = LAYOUT$signalSemaphoreCount.byteSize();
    public static final long SIZE$pSignalSemaphores = LAYOUT$pSignalSemaphores.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$waitSemaphoreCount = LAYOUT.byteOffset(PATH$waitSemaphoreCount);
    public static final long OFFSET$pWaitSemaphores = LAYOUT.byteOffset(PATH$pWaitSemaphores);
    public static final long OFFSET$pWaitDstStageMask = LAYOUT.byteOffset(PATH$pWaitDstStageMask);
    public static final long OFFSET$commandBufferCount = LAYOUT.byteOffset(PATH$commandBufferCount);
    public static final long OFFSET$pCommandBuffers = LAYOUT.byteOffset(PATH$pCommandBuffers);
    public static final long OFFSET$signalSemaphoreCount = LAYOUT.byteOffset(PATH$signalSemaphoreCount);
    public static final long OFFSET$pSignalSemaphores = LAYOUT.byteOffset(PATH$pSignalSemaphores);
}
