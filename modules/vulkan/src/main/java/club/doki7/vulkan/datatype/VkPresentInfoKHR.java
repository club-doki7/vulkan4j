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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPresentInfoKHR.html"><code>VkPresentInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPresentInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t waitSemaphoreCount; // optional // @link substring="waitSemaphoreCount" target="#waitSemaphoreCount"
///     VkSemaphore const* pWaitSemaphores; // optional // @link substring="VkSemaphore" target="VkSemaphore" @link substring="pWaitSemaphores" target="#pWaitSemaphores"
///     uint32_t swapchainCount; // @link substring="swapchainCount" target="#swapchainCount"
///     VkSwapchainKHR const* pSwapchains; // @link substring="VkSwapchainKHR" target="VkSwapchainKHR" @link substring="pSwapchains" target="#pSwapchains"
///     uint32_t const* pImageIndices; // @link substring="pImageIndices" target="#pImageIndices"
///     VkResult* pResults; // @link substring="VkResult" target="VkResult" @link substring="pResults" target="#pResults"
/// } VkPresentInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PRESENT_INFO_KHR`
///
/// The {@code allocate} ({@link VkPresentInfoKHR#allocate(Arena)}, {@link VkPresentInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPresentInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPresentInfoKHR.html"><code>VkPresentInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPresentInfoKHR(@NotNull MemorySegment segment) implements IVkPresentInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPresentInfoKHR.html"><code>VkPresentInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPresentInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPresentInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPresentInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPresentInfoKHR, Iterable<VkPresentInfoKHR> {
        public long size() {
            return segment.byteSize() / VkPresentInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPresentInfoKHR at(long index) {
            return new VkPresentInfoKHR(segment.asSlice(index * VkPresentInfoKHR.BYTES, VkPresentInfoKHR.BYTES));
        }

        public VkPresentInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkPresentInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPresentInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkPresentInfoKHR.BYTES, VkPresentInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPresentInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPresentInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPresentInfoKHR.BYTES,
                (end - start) * VkPresentInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPresentInfoKHR.BYTES));
        }

        public VkPresentInfoKHR[] toArray() {
            VkPresentInfoKHR[] ret = new VkPresentInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPresentInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPresentInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPresentInfoKHR.BYTES;
            }

            @Override
            public VkPresentInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPresentInfoKHR ret = new VkPresentInfoKHR(segment.asSlice(0, VkPresentInfoKHR.BYTES));
                segment = segment.asSlice(VkPresentInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPresentInfoKHR allocate(Arena arena) {
        VkPresentInfoKHR ret = new VkPresentInfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PRESENT_INFO_KHR);
        return ret;
    }

    public static VkPresentInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPresentInfoKHR.Ptr ret = new VkPresentInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PRESENT_INFO_KHR);
        }
        return ret;
    }

    public static VkPresentInfoKHR clone(Arena arena, VkPresentInfoKHR src) {
        VkPresentInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PRESENT_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPresentInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPresentInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPresentInfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int waitSemaphoreCount() {
        return segment.get(LAYOUT$waitSemaphoreCount, OFFSET$waitSemaphoreCount);
    }

    public VkPresentInfoKHR waitSemaphoreCount(@Unsigned int value) {
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

    public VkPresentInfoKHR pWaitSemaphores(@Nullable VkSemaphore.Ptr value) {
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

    public @Unsigned int swapchainCount() {
        return segment.get(LAYOUT$swapchainCount, OFFSET$swapchainCount);
    }

    public VkPresentInfoKHR swapchainCount(@Unsigned int value) {
        segment.set(LAYOUT$swapchainCount, OFFSET$swapchainCount, value);
        return this;
    }

    /// Note: the returned {@link VkSwapchainKHR.Ptr} does not have correct {@link VkSwapchainKHR.Ptr#size}
    /// property. It's up to user to track the size of the buffer, and use
    /// {@link VkSwapchainKHR.Ptr#reinterpret} to set the size before actually reading from or writing to the
    /// buffer.
    public @Nullable VkSwapchainKHR.Ptr pSwapchains() {
        MemorySegment s = pSwapchainsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkSwapchainKHR.Ptr(s);
    }

    public VkPresentInfoKHR pSwapchains(@Nullable VkSwapchainKHR.Ptr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pSwapchainsRaw(s);
        return this;
    }

    public @Pointer(target=VkSwapchainKHR.class) @NotNull MemorySegment pSwapchainsRaw() {
        return segment.get(LAYOUT$pSwapchains, OFFSET$pSwapchains);
    }

    public void pSwapchainsRaw(@Pointer(target=VkSwapchainKHR.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pSwapchains, OFFSET$pSwapchains, value);
    }

    /// Note: the returned {@link IntPtr} does not have correct
    /// {@link IntPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link IntPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable @Unsigned IntPtr pImageIndices() {
        MemorySegment s = pImageIndicesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new IntPtr(s);
    }

    public VkPresentInfoKHR pImageIndices(@Nullable @Unsigned IntPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pImageIndicesRaw(s);
        return this;
    }

    public @Pointer(comment="uint32_t*") @NotNull MemorySegment pImageIndicesRaw() {
        return segment.get(LAYOUT$pImageIndices, OFFSET$pImageIndices);
    }

    public void pImageIndicesRaw(@Pointer(comment="uint32_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pImageIndices, OFFSET$pImageIndices, value);
    }


    /// Note: the returned {@link IntPtr} does not have correct
    /// {@link IntPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link IntPtr#reinterpret} to set the size before actually reading fro
    /// or writing to the buffer.
    public @Nullable @EnumType(VkResult.class) IntPtr pResults() {
        MemorySegment s = pResultsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new IntPtr(s);
    }

    public VkPresentInfoKHR pResults(@Nullable @EnumType(VkResult.class) IntPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pResultsRaw(s);
        return this;
    }

    public @Pointer(target=VkResult.class) @NotNull MemorySegment pResultsRaw() {
        return segment.get(LAYOUT$pResults, OFFSET$pResults);
    }

    public void pResultsRaw(@Pointer(target=VkResult.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pResults, OFFSET$pResults, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("waitSemaphoreCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS).withName("pWaitSemaphores"),
        ValueLayout.JAVA_INT.withName("swapchainCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS).withName("pSwapchains"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pImageIndices"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pResults")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$waitSemaphoreCount = PathElement.groupElement("waitSemaphoreCount");
    public static final PathElement PATH$pWaitSemaphores = PathElement.groupElement("pWaitSemaphores");
    public static final PathElement PATH$swapchainCount = PathElement.groupElement("swapchainCount");
    public static final PathElement PATH$pSwapchains = PathElement.groupElement("pSwapchains");
    public static final PathElement PATH$pImageIndices = PathElement.groupElement("pImageIndices");
    public static final PathElement PATH$pResults = PathElement.groupElement("pResults");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$waitSemaphoreCount = (OfInt) LAYOUT.select(PATH$waitSemaphoreCount);
    public static final AddressLayout LAYOUT$pWaitSemaphores = (AddressLayout) LAYOUT.select(PATH$pWaitSemaphores);
    public static final OfInt LAYOUT$swapchainCount = (OfInt) LAYOUT.select(PATH$swapchainCount);
    public static final AddressLayout LAYOUT$pSwapchains = (AddressLayout) LAYOUT.select(PATH$pSwapchains);
    public static final AddressLayout LAYOUT$pImageIndices = (AddressLayout) LAYOUT.select(PATH$pImageIndices);
    public static final AddressLayout LAYOUT$pResults = (AddressLayout) LAYOUT.select(PATH$pResults);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$waitSemaphoreCount = LAYOUT$waitSemaphoreCount.byteSize();
    public static final long SIZE$pWaitSemaphores = LAYOUT$pWaitSemaphores.byteSize();
    public static final long SIZE$swapchainCount = LAYOUT$swapchainCount.byteSize();
    public static final long SIZE$pSwapchains = LAYOUT$pSwapchains.byteSize();
    public static final long SIZE$pImageIndices = LAYOUT$pImageIndices.byteSize();
    public static final long SIZE$pResults = LAYOUT$pResults.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$waitSemaphoreCount = LAYOUT.byteOffset(PATH$waitSemaphoreCount);
    public static final long OFFSET$pWaitSemaphores = LAYOUT.byteOffset(PATH$pWaitSemaphores);
    public static final long OFFSET$swapchainCount = LAYOUT.byteOffset(PATH$swapchainCount);
    public static final long OFFSET$pSwapchains = LAYOUT.byteOffset(PATH$pSwapchains);
    public static final long OFFSET$pImageIndices = LAYOUT.byteOffset(PATH$pImageIndices);
    public static final long OFFSET$pResults = LAYOUT.byteOffset(PATH$pResults);
}
