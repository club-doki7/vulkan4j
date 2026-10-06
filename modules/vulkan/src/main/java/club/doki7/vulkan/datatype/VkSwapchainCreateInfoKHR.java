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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSwapchainCreateInfoKHR.html"><code>VkSwapchainCreateInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkSwapchainCreateInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkSwapchainCreateFlagsKHR flags; // optional // @link substring="VkSwapchainCreateFlagsKHR" target="VkSwapchainCreateFlagsKHR" @link substring="flags" target="#flags"
///     VkSurfaceKHR surface; // @link substring="VkSurfaceKHR" target="VkSurfaceKHR" @link substring="surface" target="#surface"
///     uint32_t minImageCount; // @link substring="minImageCount" target="#minImageCount"
///     VkFormat imageFormat; // @link substring="VkFormat" target="VkFormat" @link substring="imageFormat" target="#imageFormat"
///     VkColorSpaceKHR imageColorSpace; // @link substring="VkColorSpaceKHR" target="VkColorSpaceKHR" @link substring="imageColorSpace" target="#imageColorSpace"
///     VkExtent2D imageExtent; // @link substring="VkExtent2D" target="VkExtent2D" @link substring="imageExtent" target="#imageExtent"
///     uint32_t imageArrayLayers; // @link substring="imageArrayLayers" target="#imageArrayLayers"
///     VkImageUsageFlags imageUsage; // @link substring="VkImageUsageFlags" target="VkImageUsageFlags" @link substring="imageUsage" target="#imageUsage"
///     VkSharingMode imageSharingMode; // @link substring="VkSharingMode" target="VkSharingMode" @link substring="imageSharingMode" target="#imageSharingMode"
///     uint32_t queueFamilyIndexCount; // optional // @link substring="queueFamilyIndexCount" target="#queueFamilyIndexCount"
///     uint32_t const* pQueueFamilyIndices; // optional // @link substring="pQueueFamilyIndices" target="#pQueueFamilyIndices"
///     VkSurfaceTransformFlagsKHR preTransform; // @link substring="VkSurfaceTransformFlagsKHR" target="VkSurfaceTransformFlagsKHR" @link substring="preTransform" target="#preTransform"
///     VkCompositeAlphaFlagsKHR compositeAlpha; // @link substring="VkCompositeAlphaFlagsKHR" target="VkCompositeAlphaFlagsKHR" @link substring="compositeAlpha" target="#compositeAlpha"
///     VkPresentModeKHR presentMode; // @link substring="VkPresentModeKHR" target="VkPresentModeKHR" @link substring="presentMode" target="#presentMode"
///     VkBool32 clipped; // @link substring="clipped" target="#clipped"
///     VkSwapchainKHR oldSwapchain; // optional // @link substring="VkSwapchainKHR" target="VkSwapchainKHR" @link substring="oldSwapchain" target="#oldSwapchain"
/// } VkSwapchainCreateInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_SWAPCHAIN_CREATE_INFO_KHR`
///
/// The {@code allocate} ({@link VkSwapchainCreateInfoKHR#allocate(Arena)}, {@link VkSwapchainCreateInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkSwapchainCreateInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSwapchainCreateInfoKHR.html"><code>VkSwapchainCreateInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkSwapchainCreateInfoKHR(@NotNull MemorySegment segment) implements IVkSwapchainCreateInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSwapchainCreateInfoKHR.html"><code>VkSwapchainCreateInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkSwapchainCreateInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkSwapchainCreateInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkSwapchainCreateInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkSwapchainCreateInfoKHR, Iterable<VkSwapchainCreateInfoKHR> {
        public long size() {
            return segment.byteSize() / VkSwapchainCreateInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkSwapchainCreateInfoKHR at(long index) {
            return new VkSwapchainCreateInfoKHR(segment.asSlice(index * VkSwapchainCreateInfoKHR.BYTES, VkSwapchainCreateInfoKHR.BYTES));
        }

        public VkSwapchainCreateInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkSwapchainCreateInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkSwapchainCreateInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkSwapchainCreateInfoKHR.BYTES, VkSwapchainCreateInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkSwapchainCreateInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkSwapchainCreateInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkSwapchainCreateInfoKHR.BYTES,
                (end - start) * VkSwapchainCreateInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkSwapchainCreateInfoKHR.BYTES));
        }

        public VkSwapchainCreateInfoKHR[] toArray() {
            VkSwapchainCreateInfoKHR[] ret = new VkSwapchainCreateInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkSwapchainCreateInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkSwapchainCreateInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkSwapchainCreateInfoKHR.BYTES;
            }

            @Override
            public VkSwapchainCreateInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkSwapchainCreateInfoKHR ret = new VkSwapchainCreateInfoKHR(segment.asSlice(0, VkSwapchainCreateInfoKHR.BYTES));
                segment = segment.asSlice(VkSwapchainCreateInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkSwapchainCreateInfoKHR allocate(Arena arena) {
        VkSwapchainCreateInfoKHR ret = new VkSwapchainCreateInfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.SWAPCHAIN_CREATE_INFO_KHR);
        return ret;
    }

    public static VkSwapchainCreateInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkSwapchainCreateInfoKHR.Ptr ret = new VkSwapchainCreateInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.SWAPCHAIN_CREATE_INFO_KHR);
        }
        return ret;
    }

    public static VkSwapchainCreateInfoKHR clone(Arena arena, VkSwapchainCreateInfoKHR src) {
        VkSwapchainCreateInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.SWAPCHAIN_CREATE_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkSwapchainCreateInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkSwapchainCreateInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkSwapchainCreateInfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkSwapchainCreateFlagsKHR.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkSwapchainCreateInfoKHR flags(@Bitmask(VkSwapchainCreateFlagsKHR.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @Nullable VkSurfaceKHR surface() {
        MemorySegment s = segment.asSlice(OFFSET$surface, SIZE$surface);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkSurfaceKHR(s);
    }

    public VkSwapchainCreateInfoKHR surface(@Nullable VkSurfaceKHR value) {
        segment.set(LAYOUT$surface, OFFSET$surface, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int minImageCount() {
        return segment.get(LAYOUT$minImageCount, OFFSET$minImageCount);
    }

    public VkSwapchainCreateInfoKHR minImageCount(@Unsigned int value) {
        segment.set(LAYOUT$minImageCount, OFFSET$minImageCount, value);
        return this;
    }

    public @EnumType(VkFormat.class) int imageFormat() {
        return segment.get(LAYOUT$imageFormat, OFFSET$imageFormat);
    }

    public VkSwapchainCreateInfoKHR imageFormat(@EnumType(VkFormat.class) int value) {
        segment.set(LAYOUT$imageFormat, OFFSET$imageFormat, value);
        return this;
    }

    public @EnumType(VkColorSpaceKHR.class) int imageColorSpace() {
        return segment.get(LAYOUT$imageColorSpace, OFFSET$imageColorSpace);
    }

    public VkSwapchainCreateInfoKHR imageColorSpace(@EnumType(VkColorSpaceKHR.class) int value) {
        segment.set(LAYOUT$imageColorSpace, OFFSET$imageColorSpace, value);
        return this;
    }

    public @NotNull VkExtent2D imageExtent() {
        return new VkExtent2D(segment.asSlice(OFFSET$imageExtent, LAYOUT$imageExtent));
    }

    public VkSwapchainCreateInfoKHR imageExtent(@NotNull VkExtent2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$imageExtent, SIZE$imageExtent);
        return this;
    }

    public VkSwapchainCreateInfoKHR imageExtent(Consumer<@NotNull VkExtent2D> consumer) {
        consumer.accept(imageExtent());
        return this;
    }

    public @Unsigned int imageArrayLayers() {
        return segment.get(LAYOUT$imageArrayLayers, OFFSET$imageArrayLayers);
    }

    public VkSwapchainCreateInfoKHR imageArrayLayers(@Unsigned int value) {
        segment.set(LAYOUT$imageArrayLayers, OFFSET$imageArrayLayers, value);
        return this;
    }

    public @Bitmask(VkImageUsageFlags.class) int imageUsage() {
        return segment.get(LAYOUT$imageUsage, OFFSET$imageUsage);
    }

    public VkSwapchainCreateInfoKHR imageUsage(@Bitmask(VkImageUsageFlags.class) int value) {
        segment.set(LAYOUT$imageUsage, OFFSET$imageUsage, value);
        return this;
    }

    public @EnumType(VkSharingMode.class) int imageSharingMode() {
        return segment.get(LAYOUT$imageSharingMode, OFFSET$imageSharingMode);
    }

    public VkSwapchainCreateInfoKHR imageSharingMode(@EnumType(VkSharingMode.class) int value) {
        segment.set(LAYOUT$imageSharingMode, OFFSET$imageSharingMode, value);
        return this;
    }

    public @Unsigned int queueFamilyIndexCount() {
        return segment.get(LAYOUT$queueFamilyIndexCount, OFFSET$queueFamilyIndexCount);
    }

    public VkSwapchainCreateInfoKHR queueFamilyIndexCount(@Unsigned int value) {
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

    public VkSwapchainCreateInfoKHR pQueueFamilyIndices(@Nullable @Unsigned IntPtr value) {
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

    public @Bitmask(VkSurfaceTransformFlagsKHR.class) int preTransform() {
        return segment.get(LAYOUT$preTransform, OFFSET$preTransform);
    }

    public VkSwapchainCreateInfoKHR preTransform(@Bitmask(VkSurfaceTransformFlagsKHR.class) int value) {
        segment.set(LAYOUT$preTransform, OFFSET$preTransform, value);
        return this;
    }

    public @Bitmask(VkCompositeAlphaFlagsKHR.class) int compositeAlpha() {
        return segment.get(LAYOUT$compositeAlpha, OFFSET$compositeAlpha);
    }

    public VkSwapchainCreateInfoKHR compositeAlpha(@Bitmask(VkCompositeAlphaFlagsKHR.class) int value) {
        segment.set(LAYOUT$compositeAlpha, OFFSET$compositeAlpha, value);
        return this;
    }

    public @EnumType(VkPresentModeKHR.class) int presentMode() {
        return segment.get(LAYOUT$presentMode, OFFSET$presentMode);
    }

    public VkSwapchainCreateInfoKHR presentMode(@EnumType(VkPresentModeKHR.class) int value) {
        segment.set(LAYOUT$presentMode, OFFSET$presentMode, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int clipped() {
        return segment.get(LAYOUT$clipped, OFFSET$clipped);
    }

    public VkSwapchainCreateInfoKHR clipped(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$clipped, OFFSET$clipped, value);
        return this;
    }

    public @Nullable VkSwapchainKHR oldSwapchain() {
        MemorySegment s = segment.asSlice(OFFSET$oldSwapchain, SIZE$oldSwapchain);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkSwapchainKHR(s);
    }

    public VkSwapchainCreateInfoKHR oldSwapchain(@Nullable VkSwapchainKHR value) {
        segment.set(LAYOUT$oldSwapchain, OFFSET$oldSwapchain, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.ADDRESS.withName("surface"),
        ValueLayout.JAVA_INT.withName("minImageCount"),
        ValueLayout.JAVA_INT.withName("imageFormat"),
        ValueLayout.JAVA_INT.withName("imageColorSpace"),
        VkExtent2D.LAYOUT.withName("imageExtent"),
        ValueLayout.JAVA_INT.withName("imageArrayLayers"),
        ValueLayout.JAVA_INT.withName("imageUsage"),
        ValueLayout.JAVA_INT.withName("imageSharingMode"),
        ValueLayout.JAVA_INT.withName("queueFamilyIndexCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pQueueFamilyIndices"),
        ValueLayout.JAVA_INT.withName("preTransform"),
        ValueLayout.JAVA_INT.withName("compositeAlpha"),
        ValueLayout.JAVA_INT.withName("presentMode"),
        ValueLayout.JAVA_INT.withName("clipped"),
        ValueLayout.ADDRESS.withName("oldSwapchain")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$surface = PathElement.groupElement("surface");
    public static final PathElement PATH$minImageCount = PathElement.groupElement("minImageCount");
    public static final PathElement PATH$imageFormat = PathElement.groupElement("imageFormat");
    public static final PathElement PATH$imageColorSpace = PathElement.groupElement("imageColorSpace");
    public static final PathElement PATH$imageExtent = PathElement.groupElement("imageExtent");
    public static final PathElement PATH$imageArrayLayers = PathElement.groupElement("imageArrayLayers");
    public static final PathElement PATH$imageUsage = PathElement.groupElement("imageUsage");
    public static final PathElement PATH$imageSharingMode = PathElement.groupElement("imageSharingMode");
    public static final PathElement PATH$queueFamilyIndexCount = PathElement.groupElement("queueFamilyIndexCount");
    public static final PathElement PATH$pQueueFamilyIndices = PathElement.groupElement("pQueueFamilyIndices");
    public static final PathElement PATH$preTransform = PathElement.groupElement("preTransform");
    public static final PathElement PATH$compositeAlpha = PathElement.groupElement("compositeAlpha");
    public static final PathElement PATH$presentMode = PathElement.groupElement("presentMode");
    public static final PathElement PATH$clipped = PathElement.groupElement("clipped");
    public static final PathElement PATH$oldSwapchain = PathElement.groupElement("oldSwapchain");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final AddressLayout LAYOUT$surface = (AddressLayout) LAYOUT.select(PATH$surface);
    public static final OfInt LAYOUT$minImageCount = (OfInt) LAYOUT.select(PATH$minImageCount);
    public static final OfInt LAYOUT$imageFormat = (OfInt) LAYOUT.select(PATH$imageFormat);
    public static final OfInt LAYOUT$imageColorSpace = (OfInt) LAYOUT.select(PATH$imageColorSpace);
    public static final StructLayout LAYOUT$imageExtent = (StructLayout) LAYOUT.select(PATH$imageExtent);
    public static final OfInt LAYOUT$imageArrayLayers = (OfInt) LAYOUT.select(PATH$imageArrayLayers);
    public static final OfInt LAYOUT$imageUsage = (OfInt) LAYOUT.select(PATH$imageUsage);
    public static final OfInt LAYOUT$imageSharingMode = (OfInt) LAYOUT.select(PATH$imageSharingMode);
    public static final OfInt LAYOUT$queueFamilyIndexCount = (OfInt) LAYOUT.select(PATH$queueFamilyIndexCount);
    public static final AddressLayout LAYOUT$pQueueFamilyIndices = (AddressLayout) LAYOUT.select(PATH$pQueueFamilyIndices);
    public static final OfInt LAYOUT$preTransform = (OfInt) LAYOUT.select(PATH$preTransform);
    public static final OfInt LAYOUT$compositeAlpha = (OfInt) LAYOUT.select(PATH$compositeAlpha);
    public static final OfInt LAYOUT$presentMode = (OfInt) LAYOUT.select(PATH$presentMode);
    public static final OfInt LAYOUT$clipped = (OfInt) LAYOUT.select(PATH$clipped);
    public static final AddressLayout LAYOUT$oldSwapchain = (AddressLayout) LAYOUT.select(PATH$oldSwapchain);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$surface = LAYOUT$surface.byteSize();
    public static final long SIZE$minImageCount = LAYOUT$minImageCount.byteSize();
    public static final long SIZE$imageFormat = LAYOUT$imageFormat.byteSize();
    public static final long SIZE$imageColorSpace = LAYOUT$imageColorSpace.byteSize();
    public static final long SIZE$imageExtent = LAYOUT$imageExtent.byteSize();
    public static final long SIZE$imageArrayLayers = LAYOUT$imageArrayLayers.byteSize();
    public static final long SIZE$imageUsage = LAYOUT$imageUsage.byteSize();
    public static final long SIZE$imageSharingMode = LAYOUT$imageSharingMode.byteSize();
    public static final long SIZE$queueFamilyIndexCount = LAYOUT$queueFamilyIndexCount.byteSize();
    public static final long SIZE$pQueueFamilyIndices = LAYOUT$pQueueFamilyIndices.byteSize();
    public static final long SIZE$preTransform = LAYOUT$preTransform.byteSize();
    public static final long SIZE$compositeAlpha = LAYOUT$compositeAlpha.byteSize();
    public static final long SIZE$presentMode = LAYOUT$presentMode.byteSize();
    public static final long SIZE$clipped = LAYOUT$clipped.byteSize();
    public static final long SIZE$oldSwapchain = LAYOUT$oldSwapchain.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$surface = LAYOUT.byteOffset(PATH$surface);
    public static final long OFFSET$minImageCount = LAYOUT.byteOffset(PATH$minImageCount);
    public static final long OFFSET$imageFormat = LAYOUT.byteOffset(PATH$imageFormat);
    public static final long OFFSET$imageColorSpace = LAYOUT.byteOffset(PATH$imageColorSpace);
    public static final long OFFSET$imageExtent = LAYOUT.byteOffset(PATH$imageExtent);
    public static final long OFFSET$imageArrayLayers = LAYOUT.byteOffset(PATH$imageArrayLayers);
    public static final long OFFSET$imageUsage = LAYOUT.byteOffset(PATH$imageUsage);
    public static final long OFFSET$imageSharingMode = LAYOUT.byteOffset(PATH$imageSharingMode);
    public static final long OFFSET$queueFamilyIndexCount = LAYOUT.byteOffset(PATH$queueFamilyIndexCount);
    public static final long OFFSET$pQueueFamilyIndices = LAYOUT.byteOffset(PATH$pQueueFamilyIndices);
    public static final long OFFSET$preTransform = LAYOUT.byteOffset(PATH$preTransform);
    public static final long OFFSET$compositeAlpha = LAYOUT.byteOffset(PATH$compositeAlpha);
    public static final long OFFSET$presentMode = LAYOUT.byteOffset(PATH$presentMode);
    public static final long OFFSET$clipped = LAYOUT.byteOffset(PATH$clipped);
    public static final long OFFSET$oldSwapchain = LAYOUT.byteOffset(PATH$oldSwapchain);
}
