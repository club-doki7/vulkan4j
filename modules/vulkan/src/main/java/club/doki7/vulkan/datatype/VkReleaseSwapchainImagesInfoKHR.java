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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkReleaseSwapchainImagesInfoKHR.html"><code>VkReleaseSwapchainImagesInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkReleaseSwapchainImagesInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkSwapchainKHR swapchain; // @link substring="VkSwapchainKHR" target="VkSwapchainKHR" @link substring="swapchain" target="#swapchain"
///     uint32_t imageIndexCount; // @link substring="imageIndexCount" target="#imageIndexCount"
///     uint32_t const* pImageIndices; // @link substring="pImageIndices" target="#pImageIndices"
/// } VkReleaseSwapchainImagesInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_RELEASE_SWAPCHAIN_IMAGES_INFO_KHR`
///
/// The {@code allocate} ({@link VkReleaseSwapchainImagesInfoKHR#allocate(Arena)}, {@link VkReleaseSwapchainImagesInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkReleaseSwapchainImagesInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkReleaseSwapchainImagesInfoKHR.html"><code>VkReleaseSwapchainImagesInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkReleaseSwapchainImagesInfoKHR(@NotNull MemorySegment segment) implements IVkReleaseSwapchainImagesInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkReleaseSwapchainImagesInfoKHR.html"><code>VkReleaseSwapchainImagesInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkReleaseSwapchainImagesInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkReleaseSwapchainImagesInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkReleaseSwapchainImagesInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkReleaseSwapchainImagesInfoKHR, Iterable<VkReleaseSwapchainImagesInfoKHR> {
        public long size() {
            return segment.byteSize() / VkReleaseSwapchainImagesInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkReleaseSwapchainImagesInfoKHR at(long index) {
            return new VkReleaseSwapchainImagesInfoKHR(segment.asSlice(index * VkReleaseSwapchainImagesInfoKHR.BYTES, VkReleaseSwapchainImagesInfoKHR.BYTES));
        }

        public VkReleaseSwapchainImagesInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkReleaseSwapchainImagesInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkReleaseSwapchainImagesInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkReleaseSwapchainImagesInfoKHR.BYTES, VkReleaseSwapchainImagesInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkReleaseSwapchainImagesInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkReleaseSwapchainImagesInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkReleaseSwapchainImagesInfoKHR.BYTES,
                (end - start) * VkReleaseSwapchainImagesInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkReleaseSwapchainImagesInfoKHR.BYTES));
        }

        public VkReleaseSwapchainImagesInfoKHR[] toArray() {
            VkReleaseSwapchainImagesInfoKHR[] ret = new VkReleaseSwapchainImagesInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkReleaseSwapchainImagesInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkReleaseSwapchainImagesInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkReleaseSwapchainImagesInfoKHR.BYTES;
            }

            @Override
            public VkReleaseSwapchainImagesInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkReleaseSwapchainImagesInfoKHR ret = new VkReleaseSwapchainImagesInfoKHR(segment.asSlice(0, VkReleaseSwapchainImagesInfoKHR.BYTES));
                segment = segment.asSlice(VkReleaseSwapchainImagesInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkReleaseSwapchainImagesInfoKHR allocate(Arena arena) {
        VkReleaseSwapchainImagesInfoKHR ret = new VkReleaseSwapchainImagesInfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.RELEASE_SWAPCHAIN_IMAGES_INFO_KHR);
        return ret;
    }

    public static VkReleaseSwapchainImagesInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkReleaseSwapchainImagesInfoKHR.Ptr ret = new VkReleaseSwapchainImagesInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.RELEASE_SWAPCHAIN_IMAGES_INFO_KHR);
        }
        return ret;
    }

    public static VkReleaseSwapchainImagesInfoKHR clone(Arena arena, VkReleaseSwapchainImagesInfoKHR src) {
        VkReleaseSwapchainImagesInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.RELEASE_SWAPCHAIN_IMAGES_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkReleaseSwapchainImagesInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkReleaseSwapchainImagesInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkReleaseSwapchainImagesInfoKHR pNext(@Nullable IPointer pointer) {
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

    public VkReleaseSwapchainImagesInfoKHR swapchain(@Nullable VkSwapchainKHR value) {
        segment.set(LAYOUT$swapchain, OFFSET$swapchain, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int imageIndexCount() {
        return segment.get(LAYOUT$imageIndexCount, OFFSET$imageIndexCount);
    }

    public VkReleaseSwapchainImagesInfoKHR imageIndexCount(@Unsigned int value) {
        segment.set(LAYOUT$imageIndexCount, OFFSET$imageIndexCount, value);
        return this;
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

    public VkReleaseSwapchainImagesInfoKHR pImageIndices(@Nullable @Unsigned IntPtr value) {
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

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withName("swapchain"),
        ValueLayout.JAVA_INT.withName("imageIndexCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pImageIndices")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$swapchain = PathElement.groupElement("swapchain");
    public static final PathElement PATH$imageIndexCount = PathElement.groupElement("imageIndexCount");
    public static final PathElement PATH$pImageIndices = PathElement.groupElement("pImageIndices");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$swapchain = (AddressLayout) LAYOUT.select(PATH$swapchain);
    public static final OfInt LAYOUT$imageIndexCount = (OfInt) LAYOUT.select(PATH$imageIndexCount);
    public static final AddressLayout LAYOUT$pImageIndices = (AddressLayout) LAYOUT.select(PATH$pImageIndices);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$swapchain = LAYOUT$swapchain.byteSize();
    public static final long SIZE$imageIndexCount = LAYOUT$imageIndexCount.byteSize();
    public static final long SIZE$pImageIndices = LAYOUT$pImageIndices.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$swapchain = LAYOUT.byteOffset(PATH$swapchain);
    public static final long OFFSET$imageIndexCount = LAYOUT.byteOffset(PATH$imageIndexCount);
    public static final long OFFSET$pImageIndices = LAYOUT.byteOffset(PATH$pImageIndices);
}
