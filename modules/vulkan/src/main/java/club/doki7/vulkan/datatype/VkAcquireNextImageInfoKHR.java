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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAcquireNextImageInfoKHR.html"><code>VkAcquireNextImageInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkAcquireNextImageInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkSwapchainKHR swapchain; // @link substring="VkSwapchainKHR" target="VkSwapchainKHR" @link substring="swapchain" target="#swapchain"
///     uint64_t timeout; // @link substring="timeout" target="#timeout"
///     VkSemaphore semaphore; // optional // @link substring="VkSemaphore" target="VkSemaphore" @link substring="semaphore" target="#semaphore"
///     VkFence fence; // optional // @link substring="VkFence" target="VkFence" @link substring="fence" target="#fence"
///     uint32_t deviceMask; // @link substring="deviceMask" target="#deviceMask"
/// } VkAcquireNextImageInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_ACQUIRE_NEXT_IMAGE_INFO_KHR`
///
/// The {@code allocate} ({@link VkAcquireNextImageInfoKHR#allocate(Arena)}, {@link VkAcquireNextImageInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkAcquireNextImageInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAcquireNextImageInfoKHR.html"><code>VkAcquireNextImageInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkAcquireNextImageInfoKHR(@NotNull MemorySegment segment) implements IVkAcquireNextImageInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAcquireNextImageInfoKHR.html"><code>VkAcquireNextImageInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkAcquireNextImageInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkAcquireNextImageInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkAcquireNextImageInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkAcquireNextImageInfoKHR, Iterable<VkAcquireNextImageInfoKHR> {
        public long size() {
            return segment.byteSize() / VkAcquireNextImageInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkAcquireNextImageInfoKHR at(long index) {
            return new VkAcquireNextImageInfoKHR(segment.asSlice(index * VkAcquireNextImageInfoKHR.BYTES, VkAcquireNextImageInfoKHR.BYTES));
        }

        public VkAcquireNextImageInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkAcquireNextImageInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkAcquireNextImageInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkAcquireNextImageInfoKHR.BYTES, VkAcquireNextImageInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkAcquireNextImageInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkAcquireNextImageInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkAcquireNextImageInfoKHR.BYTES,
                (end - start) * VkAcquireNextImageInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkAcquireNextImageInfoKHR.BYTES));
        }

        public VkAcquireNextImageInfoKHR[] toArray() {
            VkAcquireNextImageInfoKHR[] ret = new VkAcquireNextImageInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkAcquireNextImageInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkAcquireNextImageInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkAcquireNextImageInfoKHR.BYTES;
            }

            @Override
            public VkAcquireNextImageInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkAcquireNextImageInfoKHR ret = new VkAcquireNextImageInfoKHR(segment.asSlice(0, VkAcquireNextImageInfoKHR.BYTES));
                segment = segment.asSlice(VkAcquireNextImageInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkAcquireNextImageInfoKHR allocate(Arena arena) {
        VkAcquireNextImageInfoKHR ret = new VkAcquireNextImageInfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.ACQUIRE_NEXT_IMAGE_INFO_KHR);
        return ret;
    }

    public static VkAcquireNextImageInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkAcquireNextImageInfoKHR.Ptr ret = new VkAcquireNextImageInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.ACQUIRE_NEXT_IMAGE_INFO_KHR);
        }
        return ret;
    }

    public static VkAcquireNextImageInfoKHR clone(Arena arena, VkAcquireNextImageInfoKHR src) {
        VkAcquireNextImageInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.ACQUIRE_NEXT_IMAGE_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkAcquireNextImageInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkAcquireNextImageInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkAcquireNextImageInfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Nullable VkSwapchainKHR swapchain() {
        MemorySegment s = segment.asSlice(OFFSET$swapchain, SIZE$swapchain);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkSwapchainKHR(s);
    }

    public VkAcquireNextImageInfoKHR swapchain(@Nullable VkSwapchainKHR value) {
        segment.set(LAYOUT$swapchain, OFFSET$swapchain, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned long timeout() {
        return segment.get(LAYOUT$timeout, OFFSET$timeout);
    }

    public VkAcquireNextImageInfoKHR timeout(@Unsigned long value) {
        segment.set(LAYOUT$timeout, OFFSET$timeout, value);
        return this;
    }

    public @Nullable VkSemaphore semaphore() {
        MemorySegment s = segment.asSlice(OFFSET$semaphore, SIZE$semaphore);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkSemaphore(s);
    }

    public VkAcquireNextImageInfoKHR semaphore(@Nullable VkSemaphore value) {
        segment.set(LAYOUT$semaphore, OFFSET$semaphore, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Nullable VkFence fence() {
        MemorySegment s = segment.asSlice(OFFSET$fence, SIZE$fence);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkFence(s);
    }

    public VkAcquireNextImageInfoKHR fence(@Nullable VkFence value) {
        segment.set(LAYOUT$fence, OFFSET$fence, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int deviceMask() {
        return segment.get(LAYOUT$deviceMask, OFFSET$deviceMask);
    }

    public VkAcquireNextImageInfoKHR deviceMask(@Unsigned int value) {
        segment.set(LAYOUT$deviceMask, OFFSET$deviceMask, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withName("swapchain"),
        ValueLayout.JAVA_LONG.withName("timeout"),
        ValueLayout.ADDRESS.withName("semaphore"),
        ValueLayout.ADDRESS.withName("fence"),
        ValueLayout.JAVA_INT.withName("deviceMask")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$swapchain = PathElement.groupElement("swapchain");
    public static final PathElement PATH$timeout = PathElement.groupElement("timeout");
    public static final PathElement PATH$semaphore = PathElement.groupElement("semaphore");
    public static final PathElement PATH$fence = PathElement.groupElement("fence");
    public static final PathElement PATH$deviceMask = PathElement.groupElement("deviceMask");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$swapchain = (AddressLayout) LAYOUT.select(PATH$swapchain);
    public static final OfLong LAYOUT$timeout = (OfLong) LAYOUT.select(PATH$timeout);
    public static final AddressLayout LAYOUT$semaphore = (AddressLayout) LAYOUT.select(PATH$semaphore);
    public static final AddressLayout LAYOUT$fence = (AddressLayout) LAYOUT.select(PATH$fence);
    public static final OfInt LAYOUT$deviceMask = (OfInt) LAYOUT.select(PATH$deviceMask);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$swapchain = LAYOUT$swapchain.byteSize();
    public static final long SIZE$timeout = LAYOUT$timeout.byteSize();
    public static final long SIZE$semaphore = LAYOUT$semaphore.byteSize();
    public static final long SIZE$fence = LAYOUT$fence.byteSize();
    public static final long SIZE$deviceMask = LAYOUT$deviceMask.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$swapchain = LAYOUT.byteOffset(PATH$swapchain);
    public static final long OFFSET$timeout = LAYOUT.byteOffset(PATH$timeout);
    public static final long OFFSET$semaphore = LAYOUT.byteOffset(PATH$semaphore);
    public static final long OFFSET$fence = LAYOUT.byteOffset(PATH$fence);
    public static final long OFFSET$deviceMask = LAYOUT.byteOffset(PATH$deviceMask);
}
