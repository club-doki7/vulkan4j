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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkQueueFamilyDataGraphOpticalFlowPropertiesARM.html"><code>VkQueueFamilyDataGraphOpticalFlowPropertiesARM</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkQueueFamilyDataGraphOpticalFlowPropertiesARM {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkDataGraphOpticalFlowGridSizeFlagsARM supportedOutputGridSizes; // @link substring="VkDataGraphOpticalFlowGridSizeFlagsARM" target="VkDataGraphOpticalFlowGridSizeFlagsARM" @link substring="supportedOutputGridSizes" target="#supportedOutputGridSizes"
///     VkDataGraphOpticalFlowGridSizeFlagsARM supportedHintGridSizes; // @link substring="VkDataGraphOpticalFlowGridSizeFlagsARM" target="VkDataGraphOpticalFlowGridSizeFlagsARM" @link substring="supportedHintGridSizes" target="#supportedHintGridSizes"
///     VkBool32 hintSupported; // @link substring="hintSupported" target="#hintSupported"
///     VkBool32 costSupported; // @link substring="costSupported" target="#costSupported"
///     uint32_t minWidth; // @link substring="minWidth" target="#minWidth"
///     uint32_t minHeight; // @link substring="minHeight" target="#minHeight"
///     uint32_t maxWidth; // @link substring="maxWidth" target="#maxWidth"
///     uint32_t maxHeight; // @link substring="maxHeight" target="#maxHeight"
/// } VkQueueFamilyDataGraphOpticalFlowPropertiesARM;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_QUEUE_FAMILY_DATA_GRAPH_OPTICAL_FLOW_PROPERTIES_ARM`
///
/// The {@code allocate} ({@link VkQueueFamilyDataGraphOpticalFlowPropertiesARM#allocate(Arena)}, {@link VkQueueFamilyDataGraphOpticalFlowPropertiesARM#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkQueueFamilyDataGraphOpticalFlowPropertiesARM#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkQueueFamilyDataGraphOpticalFlowPropertiesARM.html"><code>VkQueueFamilyDataGraphOpticalFlowPropertiesARM</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkQueueFamilyDataGraphOpticalFlowPropertiesARM(@NotNull MemorySegment segment) implements IVkQueueFamilyDataGraphOpticalFlowPropertiesARM {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkQueueFamilyDataGraphOpticalFlowPropertiesARM.html"><code>VkQueueFamilyDataGraphOpticalFlowPropertiesARM</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkQueueFamilyDataGraphOpticalFlowPropertiesARM}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkQueueFamilyDataGraphOpticalFlowPropertiesARM to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkQueueFamilyDataGraphOpticalFlowPropertiesARM.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkQueueFamilyDataGraphOpticalFlowPropertiesARM, Iterable<VkQueueFamilyDataGraphOpticalFlowPropertiesARM> {
        public long size() {
            return segment.byteSize() / VkQueueFamilyDataGraphOpticalFlowPropertiesARM.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkQueueFamilyDataGraphOpticalFlowPropertiesARM at(long index) {
            return new VkQueueFamilyDataGraphOpticalFlowPropertiesARM(segment.asSlice(index * VkQueueFamilyDataGraphOpticalFlowPropertiesARM.BYTES, VkQueueFamilyDataGraphOpticalFlowPropertiesARM.BYTES));
        }

        public VkQueueFamilyDataGraphOpticalFlowPropertiesARM.Ptr at(long index, @NotNull Consumer<@NotNull VkQueueFamilyDataGraphOpticalFlowPropertiesARM> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkQueueFamilyDataGraphOpticalFlowPropertiesARM value) {
            MemorySegment s = segment.asSlice(index * VkQueueFamilyDataGraphOpticalFlowPropertiesARM.BYTES, VkQueueFamilyDataGraphOpticalFlowPropertiesARM.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkQueueFamilyDataGraphOpticalFlowPropertiesARM.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkQueueFamilyDataGraphOpticalFlowPropertiesARM.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkQueueFamilyDataGraphOpticalFlowPropertiesARM.BYTES,
                (end - start) * VkQueueFamilyDataGraphOpticalFlowPropertiesARM.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkQueueFamilyDataGraphOpticalFlowPropertiesARM.BYTES));
        }

        public VkQueueFamilyDataGraphOpticalFlowPropertiesARM[] toArray() {
            VkQueueFamilyDataGraphOpticalFlowPropertiesARM[] ret = new VkQueueFamilyDataGraphOpticalFlowPropertiesARM[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkQueueFamilyDataGraphOpticalFlowPropertiesARM> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkQueueFamilyDataGraphOpticalFlowPropertiesARM> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkQueueFamilyDataGraphOpticalFlowPropertiesARM.BYTES;
            }

            @Override
            public VkQueueFamilyDataGraphOpticalFlowPropertiesARM next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkQueueFamilyDataGraphOpticalFlowPropertiesARM ret = new VkQueueFamilyDataGraphOpticalFlowPropertiesARM(segment.asSlice(0, VkQueueFamilyDataGraphOpticalFlowPropertiesARM.BYTES));
                segment = segment.asSlice(VkQueueFamilyDataGraphOpticalFlowPropertiesARM.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkQueueFamilyDataGraphOpticalFlowPropertiesARM allocate(Arena arena) {
        VkQueueFamilyDataGraphOpticalFlowPropertiesARM ret = new VkQueueFamilyDataGraphOpticalFlowPropertiesARM(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.QUEUE_FAMILY_DATA_GRAPH_OPTICAL_FLOW_PROPERTIES_ARM);
        return ret;
    }

    public static VkQueueFamilyDataGraphOpticalFlowPropertiesARM.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkQueueFamilyDataGraphOpticalFlowPropertiesARM.Ptr ret = new VkQueueFamilyDataGraphOpticalFlowPropertiesARM.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.QUEUE_FAMILY_DATA_GRAPH_OPTICAL_FLOW_PROPERTIES_ARM);
        }
        return ret;
    }

    public static VkQueueFamilyDataGraphOpticalFlowPropertiesARM clone(Arena arena, VkQueueFamilyDataGraphOpticalFlowPropertiesARM src) {
        VkQueueFamilyDataGraphOpticalFlowPropertiesARM ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.QUEUE_FAMILY_DATA_GRAPH_OPTICAL_FLOW_PROPERTIES_ARM);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkQueueFamilyDataGraphOpticalFlowPropertiesARM sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkQueueFamilyDataGraphOpticalFlowPropertiesARM pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkQueueFamilyDataGraphOpticalFlowPropertiesARM pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkDataGraphOpticalFlowGridSizeFlagsARM.class) int supportedOutputGridSizes() {
        return segment.get(LAYOUT$supportedOutputGridSizes, OFFSET$supportedOutputGridSizes);
    }

    public VkQueueFamilyDataGraphOpticalFlowPropertiesARM supportedOutputGridSizes(@Bitmask(VkDataGraphOpticalFlowGridSizeFlagsARM.class) int value) {
        segment.set(LAYOUT$supportedOutputGridSizes, OFFSET$supportedOutputGridSizes, value);
        return this;
    }

    public @Bitmask(VkDataGraphOpticalFlowGridSizeFlagsARM.class) int supportedHintGridSizes() {
        return segment.get(LAYOUT$supportedHintGridSizes, OFFSET$supportedHintGridSizes);
    }

    public VkQueueFamilyDataGraphOpticalFlowPropertiesARM supportedHintGridSizes(@Bitmask(VkDataGraphOpticalFlowGridSizeFlagsARM.class) int value) {
        segment.set(LAYOUT$supportedHintGridSizes, OFFSET$supportedHintGridSizes, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int hintSupported() {
        return segment.get(LAYOUT$hintSupported, OFFSET$hintSupported);
    }

    public VkQueueFamilyDataGraphOpticalFlowPropertiesARM hintSupported(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$hintSupported, OFFSET$hintSupported, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int costSupported() {
        return segment.get(LAYOUT$costSupported, OFFSET$costSupported);
    }

    public VkQueueFamilyDataGraphOpticalFlowPropertiesARM costSupported(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$costSupported, OFFSET$costSupported, value);
        return this;
    }

    public @Unsigned int minWidth() {
        return segment.get(LAYOUT$minWidth, OFFSET$minWidth);
    }

    public VkQueueFamilyDataGraphOpticalFlowPropertiesARM minWidth(@Unsigned int value) {
        segment.set(LAYOUT$minWidth, OFFSET$minWidth, value);
        return this;
    }

    public @Unsigned int minHeight() {
        return segment.get(LAYOUT$minHeight, OFFSET$minHeight);
    }

    public VkQueueFamilyDataGraphOpticalFlowPropertiesARM minHeight(@Unsigned int value) {
        segment.set(LAYOUT$minHeight, OFFSET$minHeight, value);
        return this;
    }

    public @Unsigned int maxWidth() {
        return segment.get(LAYOUT$maxWidth, OFFSET$maxWidth);
    }

    public VkQueueFamilyDataGraphOpticalFlowPropertiesARM maxWidth(@Unsigned int value) {
        segment.set(LAYOUT$maxWidth, OFFSET$maxWidth, value);
        return this;
    }

    public @Unsigned int maxHeight() {
        return segment.get(LAYOUT$maxHeight, OFFSET$maxHeight);
    }

    public VkQueueFamilyDataGraphOpticalFlowPropertiesARM maxHeight(@Unsigned int value) {
        segment.set(LAYOUT$maxHeight, OFFSET$maxHeight, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("supportedOutputGridSizes"),
        ValueLayout.JAVA_INT.withName("supportedHintGridSizes"),
        ValueLayout.JAVA_INT.withName("hintSupported"),
        ValueLayout.JAVA_INT.withName("costSupported"),
        ValueLayout.JAVA_INT.withName("minWidth"),
        ValueLayout.JAVA_INT.withName("minHeight"),
        ValueLayout.JAVA_INT.withName("maxWidth"),
        ValueLayout.JAVA_INT.withName("maxHeight")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$supportedOutputGridSizes = PathElement.groupElement("supportedOutputGridSizes");
    public static final PathElement PATH$supportedHintGridSizes = PathElement.groupElement("supportedHintGridSizes");
    public static final PathElement PATH$hintSupported = PathElement.groupElement("hintSupported");
    public static final PathElement PATH$costSupported = PathElement.groupElement("costSupported");
    public static final PathElement PATH$minWidth = PathElement.groupElement("minWidth");
    public static final PathElement PATH$minHeight = PathElement.groupElement("minHeight");
    public static final PathElement PATH$maxWidth = PathElement.groupElement("maxWidth");
    public static final PathElement PATH$maxHeight = PathElement.groupElement("maxHeight");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$supportedOutputGridSizes = (OfInt) LAYOUT.select(PATH$supportedOutputGridSizes);
    public static final OfInt LAYOUT$supportedHintGridSizes = (OfInt) LAYOUT.select(PATH$supportedHintGridSizes);
    public static final OfInt LAYOUT$hintSupported = (OfInt) LAYOUT.select(PATH$hintSupported);
    public static final OfInt LAYOUT$costSupported = (OfInt) LAYOUT.select(PATH$costSupported);
    public static final OfInt LAYOUT$minWidth = (OfInt) LAYOUT.select(PATH$minWidth);
    public static final OfInt LAYOUT$minHeight = (OfInt) LAYOUT.select(PATH$minHeight);
    public static final OfInt LAYOUT$maxWidth = (OfInt) LAYOUT.select(PATH$maxWidth);
    public static final OfInt LAYOUT$maxHeight = (OfInt) LAYOUT.select(PATH$maxHeight);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$supportedOutputGridSizes = LAYOUT$supportedOutputGridSizes.byteSize();
    public static final long SIZE$supportedHintGridSizes = LAYOUT$supportedHintGridSizes.byteSize();
    public static final long SIZE$hintSupported = LAYOUT$hintSupported.byteSize();
    public static final long SIZE$costSupported = LAYOUT$costSupported.byteSize();
    public static final long SIZE$minWidth = LAYOUT$minWidth.byteSize();
    public static final long SIZE$minHeight = LAYOUT$minHeight.byteSize();
    public static final long SIZE$maxWidth = LAYOUT$maxWidth.byteSize();
    public static final long SIZE$maxHeight = LAYOUT$maxHeight.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$supportedOutputGridSizes = LAYOUT.byteOffset(PATH$supportedOutputGridSizes);
    public static final long OFFSET$supportedHintGridSizes = LAYOUT.byteOffset(PATH$supportedHintGridSizes);
    public static final long OFFSET$hintSupported = LAYOUT.byteOffset(PATH$hintSupported);
    public static final long OFFSET$costSupported = LAYOUT.byteOffset(PATH$costSupported);
    public static final long OFFSET$minWidth = LAYOUT.byteOffset(PATH$minWidth);
    public static final long OFFSET$minHeight = LAYOUT.byteOffset(PATH$minHeight);
    public static final long OFFSET$maxWidth = LAYOUT.byteOffset(PATH$maxWidth);
    public static final long OFFSET$maxHeight = LAYOUT.byteOffset(PATH$maxHeight);
}
