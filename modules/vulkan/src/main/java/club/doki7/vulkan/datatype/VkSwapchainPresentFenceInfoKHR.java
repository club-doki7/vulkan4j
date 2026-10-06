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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSwapchainPresentFenceInfoKHR.html"><code>VkSwapchainPresentFenceInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkSwapchainPresentFenceInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t swapchainCount; // @link substring="swapchainCount" target="#swapchainCount"
///     VkFence const* pFences; // @link substring="VkFence" target="VkFence" @link substring="pFences" target="#pFences"
/// } VkSwapchainPresentFenceInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_SWAPCHAIN_PRESENT_FENCE_INFO_KHR`
///
/// The {@code allocate} ({@link VkSwapchainPresentFenceInfoKHR#allocate(Arena)}, {@link VkSwapchainPresentFenceInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkSwapchainPresentFenceInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSwapchainPresentFenceInfoKHR.html"><code>VkSwapchainPresentFenceInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkSwapchainPresentFenceInfoKHR(@NotNull MemorySegment segment) implements IVkSwapchainPresentFenceInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSwapchainPresentFenceInfoKHR.html"><code>VkSwapchainPresentFenceInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkSwapchainPresentFenceInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkSwapchainPresentFenceInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkSwapchainPresentFenceInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkSwapchainPresentFenceInfoKHR, Iterable<VkSwapchainPresentFenceInfoKHR> {
        public long size() {
            return segment.byteSize() / VkSwapchainPresentFenceInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkSwapchainPresentFenceInfoKHR at(long index) {
            return new VkSwapchainPresentFenceInfoKHR(segment.asSlice(index * VkSwapchainPresentFenceInfoKHR.BYTES, VkSwapchainPresentFenceInfoKHR.BYTES));
        }

        public VkSwapchainPresentFenceInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkSwapchainPresentFenceInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkSwapchainPresentFenceInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkSwapchainPresentFenceInfoKHR.BYTES, VkSwapchainPresentFenceInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkSwapchainPresentFenceInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkSwapchainPresentFenceInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkSwapchainPresentFenceInfoKHR.BYTES,
                (end - start) * VkSwapchainPresentFenceInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkSwapchainPresentFenceInfoKHR.BYTES));
        }

        public VkSwapchainPresentFenceInfoKHR[] toArray() {
            VkSwapchainPresentFenceInfoKHR[] ret = new VkSwapchainPresentFenceInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkSwapchainPresentFenceInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkSwapchainPresentFenceInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkSwapchainPresentFenceInfoKHR.BYTES;
            }

            @Override
            public VkSwapchainPresentFenceInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkSwapchainPresentFenceInfoKHR ret = new VkSwapchainPresentFenceInfoKHR(segment.asSlice(0, VkSwapchainPresentFenceInfoKHR.BYTES));
                segment = segment.asSlice(VkSwapchainPresentFenceInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkSwapchainPresentFenceInfoKHR allocate(Arena arena) {
        VkSwapchainPresentFenceInfoKHR ret = new VkSwapchainPresentFenceInfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.SWAPCHAIN_PRESENT_FENCE_INFO_KHR);
        return ret;
    }

    public static VkSwapchainPresentFenceInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkSwapchainPresentFenceInfoKHR.Ptr ret = new VkSwapchainPresentFenceInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.SWAPCHAIN_PRESENT_FENCE_INFO_KHR);
        }
        return ret;
    }

    public static VkSwapchainPresentFenceInfoKHR clone(Arena arena, VkSwapchainPresentFenceInfoKHR src) {
        VkSwapchainPresentFenceInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.SWAPCHAIN_PRESENT_FENCE_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkSwapchainPresentFenceInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkSwapchainPresentFenceInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkSwapchainPresentFenceInfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int swapchainCount() {
        return segment.get(LAYOUT$swapchainCount, OFFSET$swapchainCount);
    }

    public VkSwapchainPresentFenceInfoKHR swapchainCount(@Unsigned int value) {
        segment.set(LAYOUT$swapchainCount, OFFSET$swapchainCount, value);
        return this;
    }

    /// Note: the returned {@link VkFence.Ptr} does not have correct {@link VkFence.Ptr#size}
    /// property. It's up to user to track the size of the buffer, and use
    /// {@link VkFence.Ptr#reinterpret} to set the size before actually reading from or writing to the
    /// buffer.
    public @Nullable VkFence.Ptr pFences() {
        MemorySegment s = pFencesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkFence.Ptr(s);
    }

    public VkSwapchainPresentFenceInfoKHR pFences(@Nullable VkFence.Ptr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pFencesRaw(s);
        return this;
    }

    public @Pointer(target=VkFence.class) @NotNull MemorySegment pFencesRaw() {
        return segment.get(LAYOUT$pFences, OFFSET$pFences);
    }

    public void pFencesRaw(@Pointer(target=VkFence.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pFences, OFFSET$pFences, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("swapchainCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS).withName("pFences")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$swapchainCount = PathElement.groupElement("swapchainCount");
    public static final PathElement PATH$pFences = PathElement.groupElement("pFences");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$swapchainCount = (OfInt) LAYOUT.select(PATH$swapchainCount);
    public static final AddressLayout LAYOUT$pFences = (AddressLayout) LAYOUT.select(PATH$pFences);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$swapchainCount = LAYOUT$swapchainCount.byteSize();
    public static final long SIZE$pFences = LAYOUT$pFences.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$swapchainCount = LAYOUT.byteOffset(PATH$swapchainCount);
    public static final long OFFSET$pFences = LAYOUT.byteOffset(PATH$pFences);
}
