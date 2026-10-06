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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSurfaceCapabilities2EXT.html"><code>VkSurfaceCapabilities2EXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkSurfaceCapabilities2EXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t minImageCount; // @link substring="minImageCount" target="#minImageCount"
///     uint32_t maxImageCount; // @link substring="maxImageCount" target="#maxImageCount"
///     VkExtent2D currentExtent; // @link substring="VkExtent2D" target="VkExtent2D" @link substring="currentExtent" target="#currentExtent"
///     VkExtent2D minImageExtent; // @link substring="VkExtent2D" target="VkExtent2D" @link substring="minImageExtent" target="#minImageExtent"
///     VkExtent2D maxImageExtent; // @link substring="VkExtent2D" target="VkExtent2D" @link substring="maxImageExtent" target="#maxImageExtent"
///     uint32_t maxImageArrayLayers; // @link substring="maxImageArrayLayers" target="#maxImageArrayLayers"
///     VkSurfaceTransformFlagsKHR supportedTransforms; // @link substring="VkSurfaceTransformFlagsKHR" target="VkSurfaceTransformFlagsKHR" @link substring="supportedTransforms" target="#supportedTransforms"
///     VkSurfaceTransformFlagsKHR currentTransform; // @link substring="VkSurfaceTransformFlagsKHR" target="VkSurfaceTransformFlagsKHR" @link substring="currentTransform" target="#currentTransform"
///     VkCompositeAlphaFlagsKHR supportedCompositeAlpha; // @link substring="VkCompositeAlphaFlagsKHR" target="VkCompositeAlphaFlagsKHR" @link substring="supportedCompositeAlpha" target="#supportedCompositeAlpha"
///     VkImageUsageFlags supportedUsageFlags; // @link substring="VkImageUsageFlags" target="VkImageUsageFlags" @link substring="supportedUsageFlags" target="#supportedUsageFlags"
///     VkSurfaceCounterFlagsEXT supportedSurfaceCounters; // optional // @link substring="VkSurfaceCounterFlagsEXT" target="VkSurfaceCounterFlagsEXT" @link substring="supportedSurfaceCounters" target="#supportedSurfaceCounters"
/// } VkSurfaceCapabilities2EXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_SURFACE_CAPABILITIES_2_EXT`
///
/// The {@code allocate} ({@link VkSurfaceCapabilities2EXT#allocate(Arena)}, {@link VkSurfaceCapabilities2EXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkSurfaceCapabilities2EXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSurfaceCapabilities2EXT.html"><code>VkSurfaceCapabilities2EXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkSurfaceCapabilities2EXT(@NotNull MemorySegment segment) implements IVkSurfaceCapabilities2EXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSurfaceCapabilities2EXT.html"><code>VkSurfaceCapabilities2EXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkSurfaceCapabilities2EXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkSurfaceCapabilities2EXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkSurfaceCapabilities2EXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkSurfaceCapabilities2EXT, Iterable<VkSurfaceCapabilities2EXT> {
        public long size() {
            return segment.byteSize() / VkSurfaceCapabilities2EXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkSurfaceCapabilities2EXT at(long index) {
            return new VkSurfaceCapabilities2EXT(segment.asSlice(index * VkSurfaceCapabilities2EXT.BYTES, VkSurfaceCapabilities2EXT.BYTES));
        }

        public VkSurfaceCapabilities2EXT.Ptr at(long index, @NotNull Consumer<@NotNull VkSurfaceCapabilities2EXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkSurfaceCapabilities2EXT value) {
            MemorySegment s = segment.asSlice(index * VkSurfaceCapabilities2EXT.BYTES, VkSurfaceCapabilities2EXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkSurfaceCapabilities2EXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkSurfaceCapabilities2EXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkSurfaceCapabilities2EXT.BYTES,
                (end - start) * VkSurfaceCapabilities2EXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkSurfaceCapabilities2EXT.BYTES));
        }

        public VkSurfaceCapabilities2EXT[] toArray() {
            VkSurfaceCapabilities2EXT[] ret = new VkSurfaceCapabilities2EXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkSurfaceCapabilities2EXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkSurfaceCapabilities2EXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkSurfaceCapabilities2EXT.BYTES;
            }

            @Override
            public VkSurfaceCapabilities2EXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkSurfaceCapabilities2EXT ret = new VkSurfaceCapabilities2EXT(segment.asSlice(0, VkSurfaceCapabilities2EXT.BYTES));
                segment = segment.asSlice(VkSurfaceCapabilities2EXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkSurfaceCapabilities2EXT allocate(Arena arena) {
        VkSurfaceCapabilities2EXT ret = new VkSurfaceCapabilities2EXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.SURFACE_CAPABILITIES_2_EXT);
        return ret;
    }

    public static VkSurfaceCapabilities2EXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkSurfaceCapabilities2EXT.Ptr ret = new VkSurfaceCapabilities2EXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.SURFACE_CAPABILITIES_2_EXT);
        }
        return ret;
    }

    public static VkSurfaceCapabilities2EXT clone(Arena arena, VkSurfaceCapabilities2EXT src) {
        VkSurfaceCapabilities2EXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.SURFACE_CAPABILITIES_2_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkSurfaceCapabilities2EXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkSurfaceCapabilities2EXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkSurfaceCapabilities2EXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int minImageCount() {
        return segment.get(LAYOUT$minImageCount, OFFSET$minImageCount);
    }

    public VkSurfaceCapabilities2EXT minImageCount(@Unsigned int value) {
        segment.set(LAYOUT$minImageCount, OFFSET$minImageCount, value);
        return this;
    }

    public @Unsigned int maxImageCount() {
        return segment.get(LAYOUT$maxImageCount, OFFSET$maxImageCount);
    }

    public VkSurfaceCapabilities2EXT maxImageCount(@Unsigned int value) {
        segment.set(LAYOUT$maxImageCount, OFFSET$maxImageCount, value);
        return this;
    }

    public @NotNull VkExtent2D currentExtent() {
        return new VkExtent2D(segment.asSlice(OFFSET$currentExtent, LAYOUT$currentExtent));
    }

    public VkSurfaceCapabilities2EXT currentExtent(@NotNull VkExtent2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$currentExtent, SIZE$currentExtent);
        return this;
    }

    public VkSurfaceCapabilities2EXT currentExtent(Consumer<@NotNull VkExtent2D> consumer) {
        consumer.accept(currentExtent());
        return this;
    }

    public @NotNull VkExtent2D minImageExtent() {
        return new VkExtent2D(segment.asSlice(OFFSET$minImageExtent, LAYOUT$minImageExtent));
    }

    public VkSurfaceCapabilities2EXT minImageExtent(@NotNull VkExtent2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$minImageExtent, SIZE$minImageExtent);
        return this;
    }

    public VkSurfaceCapabilities2EXT minImageExtent(Consumer<@NotNull VkExtent2D> consumer) {
        consumer.accept(minImageExtent());
        return this;
    }

    public @NotNull VkExtent2D maxImageExtent() {
        return new VkExtent2D(segment.asSlice(OFFSET$maxImageExtent, LAYOUT$maxImageExtent));
    }

    public VkSurfaceCapabilities2EXT maxImageExtent(@NotNull VkExtent2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$maxImageExtent, SIZE$maxImageExtent);
        return this;
    }

    public VkSurfaceCapabilities2EXT maxImageExtent(Consumer<@NotNull VkExtent2D> consumer) {
        consumer.accept(maxImageExtent());
        return this;
    }

    public @Unsigned int maxImageArrayLayers() {
        return segment.get(LAYOUT$maxImageArrayLayers, OFFSET$maxImageArrayLayers);
    }

    public VkSurfaceCapabilities2EXT maxImageArrayLayers(@Unsigned int value) {
        segment.set(LAYOUT$maxImageArrayLayers, OFFSET$maxImageArrayLayers, value);
        return this;
    }

    public @Bitmask(VkSurfaceTransformFlagsKHR.class) int supportedTransforms() {
        return segment.get(LAYOUT$supportedTransforms, OFFSET$supportedTransforms);
    }

    public VkSurfaceCapabilities2EXT supportedTransforms(@Bitmask(VkSurfaceTransformFlagsKHR.class) int value) {
        segment.set(LAYOUT$supportedTransforms, OFFSET$supportedTransforms, value);
        return this;
    }

    public @Bitmask(VkSurfaceTransformFlagsKHR.class) int currentTransform() {
        return segment.get(LAYOUT$currentTransform, OFFSET$currentTransform);
    }

    public VkSurfaceCapabilities2EXT currentTransform(@Bitmask(VkSurfaceTransformFlagsKHR.class) int value) {
        segment.set(LAYOUT$currentTransform, OFFSET$currentTransform, value);
        return this;
    }

    public @Bitmask(VkCompositeAlphaFlagsKHR.class) int supportedCompositeAlpha() {
        return segment.get(LAYOUT$supportedCompositeAlpha, OFFSET$supportedCompositeAlpha);
    }

    public VkSurfaceCapabilities2EXT supportedCompositeAlpha(@Bitmask(VkCompositeAlphaFlagsKHR.class) int value) {
        segment.set(LAYOUT$supportedCompositeAlpha, OFFSET$supportedCompositeAlpha, value);
        return this;
    }

    public @Bitmask(VkImageUsageFlags.class) int supportedUsageFlags() {
        return segment.get(LAYOUT$supportedUsageFlags, OFFSET$supportedUsageFlags);
    }

    public VkSurfaceCapabilities2EXT supportedUsageFlags(@Bitmask(VkImageUsageFlags.class) int value) {
        segment.set(LAYOUT$supportedUsageFlags, OFFSET$supportedUsageFlags, value);
        return this;
    }

    public @Bitmask(VkSurfaceCounterFlagsEXT.class) int supportedSurfaceCounters() {
        return segment.get(LAYOUT$supportedSurfaceCounters, OFFSET$supportedSurfaceCounters);
    }

    public VkSurfaceCapabilities2EXT supportedSurfaceCounters(@Bitmask(VkSurfaceCounterFlagsEXT.class) int value) {
        segment.set(LAYOUT$supportedSurfaceCounters, OFFSET$supportedSurfaceCounters, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("minImageCount"),
        ValueLayout.JAVA_INT.withName("maxImageCount"),
        VkExtent2D.LAYOUT.withName("currentExtent"),
        VkExtent2D.LAYOUT.withName("minImageExtent"),
        VkExtent2D.LAYOUT.withName("maxImageExtent"),
        ValueLayout.JAVA_INT.withName("maxImageArrayLayers"),
        ValueLayout.JAVA_INT.withName("supportedTransforms"),
        ValueLayout.JAVA_INT.withName("currentTransform"),
        ValueLayout.JAVA_INT.withName("supportedCompositeAlpha"),
        ValueLayout.JAVA_INT.withName("supportedUsageFlags"),
        ValueLayout.JAVA_INT.withName("supportedSurfaceCounters")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$minImageCount = PathElement.groupElement("minImageCount");
    public static final PathElement PATH$maxImageCount = PathElement.groupElement("maxImageCount");
    public static final PathElement PATH$currentExtent = PathElement.groupElement("currentExtent");
    public static final PathElement PATH$minImageExtent = PathElement.groupElement("minImageExtent");
    public static final PathElement PATH$maxImageExtent = PathElement.groupElement("maxImageExtent");
    public static final PathElement PATH$maxImageArrayLayers = PathElement.groupElement("maxImageArrayLayers");
    public static final PathElement PATH$supportedTransforms = PathElement.groupElement("supportedTransforms");
    public static final PathElement PATH$currentTransform = PathElement.groupElement("currentTransform");
    public static final PathElement PATH$supportedCompositeAlpha = PathElement.groupElement("supportedCompositeAlpha");
    public static final PathElement PATH$supportedUsageFlags = PathElement.groupElement("supportedUsageFlags");
    public static final PathElement PATH$supportedSurfaceCounters = PathElement.groupElement("supportedSurfaceCounters");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$minImageCount = (OfInt) LAYOUT.select(PATH$minImageCount);
    public static final OfInt LAYOUT$maxImageCount = (OfInt) LAYOUT.select(PATH$maxImageCount);
    public static final StructLayout LAYOUT$currentExtent = (StructLayout) LAYOUT.select(PATH$currentExtent);
    public static final StructLayout LAYOUT$minImageExtent = (StructLayout) LAYOUT.select(PATH$minImageExtent);
    public static final StructLayout LAYOUT$maxImageExtent = (StructLayout) LAYOUT.select(PATH$maxImageExtent);
    public static final OfInt LAYOUT$maxImageArrayLayers = (OfInt) LAYOUT.select(PATH$maxImageArrayLayers);
    public static final OfInt LAYOUT$supportedTransforms = (OfInt) LAYOUT.select(PATH$supportedTransforms);
    public static final OfInt LAYOUT$currentTransform = (OfInt) LAYOUT.select(PATH$currentTransform);
    public static final OfInt LAYOUT$supportedCompositeAlpha = (OfInt) LAYOUT.select(PATH$supportedCompositeAlpha);
    public static final OfInt LAYOUT$supportedUsageFlags = (OfInt) LAYOUT.select(PATH$supportedUsageFlags);
    public static final OfInt LAYOUT$supportedSurfaceCounters = (OfInt) LAYOUT.select(PATH$supportedSurfaceCounters);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$minImageCount = LAYOUT$minImageCount.byteSize();
    public static final long SIZE$maxImageCount = LAYOUT$maxImageCount.byteSize();
    public static final long SIZE$currentExtent = LAYOUT$currentExtent.byteSize();
    public static final long SIZE$minImageExtent = LAYOUT$minImageExtent.byteSize();
    public static final long SIZE$maxImageExtent = LAYOUT$maxImageExtent.byteSize();
    public static final long SIZE$maxImageArrayLayers = LAYOUT$maxImageArrayLayers.byteSize();
    public static final long SIZE$supportedTransforms = LAYOUT$supportedTransforms.byteSize();
    public static final long SIZE$currentTransform = LAYOUT$currentTransform.byteSize();
    public static final long SIZE$supportedCompositeAlpha = LAYOUT$supportedCompositeAlpha.byteSize();
    public static final long SIZE$supportedUsageFlags = LAYOUT$supportedUsageFlags.byteSize();
    public static final long SIZE$supportedSurfaceCounters = LAYOUT$supportedSurfaceCounters.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$minImageCount = LAYOUT.byteOffset(PATH$minImageCount);
    public static final long OFFSET$maxImageCount = LAYOUT.byteOffset(PATH$maxImageCount);
    public static final long OFFSET$currentExtent = LAYOUT.byteOffset(PATH$currentExtent);
    public static final long OFFSET$minImageExtent = LAYOUT.byteOffset(PATH$minImageExtent);
    public static final long OFFSET$maxImageExtent = LAYOUT.byteOffset(PATH$maxImageExtent);
    public static final long OFFSET$maxImageArrayLayers = LAYOUT.byteOffset(PATH$maxImageArrayLayers);
    public static final long OFFSET$supportedTransforms = LAYOUT.byteOffset(PATH$supportedTransforms);
    public static final long OFFSET$currentTransform = LAYOUT.byteOffset(PATH$currentTransform);
    public static final long OFFSET$supportedCompositeAlpha = LAYOUT.byteOffset(PATH$supportedCompositeAlpha);
    public static final long OFFSET$supportedUsageFlags = LAYOUT.byteOffset(PATH$supportedUsageFlags);
    public static final long OFFSET$supportedSurfaceCounters = LAYOUT.byteOffset(PATH$supportedSurfaceCounters);
}
