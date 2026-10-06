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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceTransformFeedbackPropertiesEXT.html"><code>VkPhysicalDeviceTransformFeedbackPropertiesEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceTransformFeedbackPropertiesEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t maxTransformFeedbackStreams; // @link substring="maxTransformFeedbackStreams" target="#maxTransformFeedbackStreams"
///     uint32_t maxTransformFeedbackBuffers; // @link substring="maxTransformFeedbackBuffers" target="#maxTransformFeedbackBuffers"
///     VkDeviceSize maxTransformFeedbackBufferSize; // @link substring="maxTransformFeedbackBufferSize" target="#maxTransformFeedbackBufferSize"
///     uint32_t maxTransformFeedbackStreamDataSize; // @link substring="maxTransformFeedbackStreamDataSize" target="#maxTransformFeedbackStreamDataSize"
///     uint32_t maxTransformFeedbackBufferDataSize; // @link substring="maxTransformFeedbackBufferDataSize" target="#maxTransformFeedbackBufferDataSize"
///     uint32_t maxTransformFeedbackBufferDataStride; // @link substring="maxTransformFeedbackBufferDataStride" target="#maxTransformFeedbackBufferDataStride"
///     VkBool32 transformFeedbackQueries; // @link substring="transformFeedbackQueries" target="#transformFeedbackQueries"
///     VkBool32 transformFeedbackStreamsLinesTriangles; // @link substring="transformFeedbackStreamsLinesTriangles" target="#transformFeedbackStreamsLinesTriangles"
///     VkBool32 transformFeedbackRasterizationStreamSelect; // @link substring="transformFeedbackRasterizationStreamSelect" target="#transformFeedbackRasterizationStreamSelect"
///     VkBool32 transformFeedbackDraw; // @link substring="transformFeedbackDraw" target="#transformFeedbackDraw"
/// } VkPhysicalDeviceTransformFeedbackPropertiesEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_TRANSFORM_FEEDBACK_PROPERTIES_EXT`
///
/// The {@code allocate} ({@link VkPhysicalDeviceTransformFeedbackPropertiesEXT#allocate(Arena)}, {@link VkPhysicalDeviceTransformFeedbackPropertiesEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceTransformFeedbackPropertiesEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceTransformFeedbackPropertiesEXT.html"><code>VkPhysicalDeviceTransformFeedbackPropertiesEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceTransformFeedbackPropertiesEXT(@NotNull MemorySegment segment) implements IVkPhysicalDeviceTransformFeedbackPropertiesEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceTransformFeedbackPropertiesEXT.html"><code>VkPhysicalDeviceTransformFeedbackPropertiesEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceTransformFeedbackPropertiesEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceTransformFeedbackPropertiesEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceTransformFeedbackPropertiesEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceTransformFeedbackPropertiesEXT, Iterable<VkPhysicalDeviceTransformFeedbackPropertiesEXT> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceTransformFeedbackPropertiesEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceTransformFeedbackPropertiesEXT at(long index) {
            return new VkPhysicalDeviceTransformFeedbackPropertiesEXT(segment.asSlice(index * VkPhysicalDeviceTransformFeedbackPropertiesEXT.BYTES, VkPhysicalDeviceTransformFeedbackPropertiesEXT.BYTES));
        }

        public VkPhysicalDeviceTransformFeedbackPropertiesEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceTransformFeedbackPropertiesEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceTransformFeedbackPropertiesEXT value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceTransformFeedbackPropertiesEXT.BYTES, VkPhysicalDeviceTransformFeedbackPropertiesEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceTransformFeedbackPropertiesEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceTransformFeedbackPropertiesEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceTransformFeedbackPropertiesEXT.BYTES,
                (end - start) * VkPhysicalDeviceTransformFeedbackPropertiesEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceTransformFeedbackPropertiesEXT.BYTES));
        }

        public VkPhysicalDeviceTransformFeedbackPropertiesEXT[] toArray() {
            VkPhysicalDeviceTransformFeedbackPropertiesEXT[] ret = new VkPhysicalDeviceTransformFeedbackPropertiesEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceTransformFeedbackPropertiesEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceTransformFeedbackPropertiesEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceTransformFeedbackPropertiesEXT.BYTES;
            }

            @Override
            public VkPhysicalDeviceTransformFeedbackPropertiesEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceTransformFeedbackPropertiesEXT ret = new VkPhysicalDeviceTransformFeedbackPropertiesEXT(segment.asSlice(0, VkPhysicalDeviceTransformFeedbackPropertiesEXT.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceTransformFeedbackPropertiesEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceTransformFeedbackPropertiesEXT allocate(Arena arena) {
        VkPhysicalDeviceTransformFeedbackPropertiesEXT ret = new VkPhysicalDeviceTransformFeedbackPropertiesEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_TRANSFORM_FEEDBACK_PROPERTIES_EXT);
        return ret;
    }

    public static VkPhysicalDeviceTransformFeedbackPropertiesEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceTransformFeedbackPropertiesEXT.Ptr ret = new VkPhysicalDeviceTransformFeedbackPropertiesEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_TRANSFORM_FEEDBACK_PROPERTIES_EXT);
        }
        return ret;
    }

    public static VkPhysicalDeviceTransformFeedbackPropertiesEXT clone(Arena arena, VkPhysicalDeviceTransformFeedbackPropertiesEXT src) {
        VkPhysicalDeviceTransformFeedbackPropertiesEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_TRANSFORM_FEEDBACK_PROPERTIES_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceTransformFeedbackPropertiesEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceTransformFeedbackPropertiesEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceTransformFeedbackPropertiesEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int maxTransformFeedbackStreams() {
        return segment.get(LAYOUT$maxTransformFeedbackStreams, OFFSET$maxTransformFeedbackStreams);
    }

    public VkPhysicalDeviceTransformFeedbackPropertiesEXT maxTransformFeedbackStreams(@Unsigned int value) {
        segment.set(LAYOUT$maxTransformFeedbackStreams, OFFSET$maxTransformFeedbackStreams, value);
        return this;
    }

    public @Unsigned int maxTransformFeedbackBuffers() {
        return segment.get(LAYOUT$maxTransformFeedbackBuffers, OFFSET$maxTransformFeedbackBuffers);
    }

    public VkPhysicalDeviceTransformFeedbackPropertiesEXT maxTransformFeedbackBuffers(@Unsigned int value) {
        segment.set(LAYOUT$maxTransformFeedbackBuffers, OFFSET$maxTransformFeedbackBuffers, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long maxTransformFeedbackBufferSize() {
        return segment.get(LAYOUT$maxTransformFeedbackBufferSize, OFFSET$maxTransformFeedbackBufferSize);
    }

    public VkPhysicalDeviceTransformFeedbackPropertiesEXT maxTransformFeedbackBufferSize(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$maxTransformFeedbackBufferSize, OFFSET$maxTransformFeedbackBufferSize, value);
        return this;
    }

    public @Unsigned int maxTransformFeedbackStreamDataSize() {
        return segment.get(LAYOUT$maxTransformFeedbackStreamDataSize, OFFSET$maxTransformFeedbackStreamDataSize);
    }

    public VkPhysicalDeviceTransformFeedbackPropertiesEXT maxTransformFeedbackStreamDataSize(@Unsigned int value) {
        segment.set(LAYOUT$maxTransformFeedbackStreamDataSize, OFFSET$maxTransformFeedbackStreamDataSize, value);
        return this;
    }

    public @Unsigned int maxTransformFeedbackBufferDataSize() {
        return segment.get(LAYOUT$maxTransformFeedbackBufferDataSize, OFFSET$maxTransformFeedbackBufferDataSize);
    }

    public VkPhysicalDeviceTransformFeedbackPropertiesEXT maxTransformFeedbackBufferDataSize(@Unsigned int value) {
        segment.set(LAYOUT$maxTransformFeedbackBufferDataSize, OFFSET$maxTransformFeedbackBufferDataSize, value);
        return this;
    }

    public @Unsigned int maxTransformFeedbackBufferDataStride() {
        return segment.get(LAYOUT$maxTransformFeedbackBufferDataStride, OFFSET$maxTransformFeedbackBufferDataStride);
    }

    public VkPhysicalDeviceTransformFeedbackPropertiesEXT maxTransformFeedbackBufferDataStride(@Unsigned int value) {
        segment.set(LAYOUT$maxTransformFeedbackBufferDataStride, OFFSET$maxTransformFeedbackBufferDataStride, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int transformFeedbackQueries() {
        return segment.get(LAYOUT$transformFeedbackQueries, OFFSET$transformFeedbackQueries);
    }

    public VkPhysicalDeviceTransformFeedbackPropertiesEXT transformFeedbackQueries(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$transformFeedbackQueries, OFFSET$transformFeedbackQueries, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int transformFeedbackStreamsLinesTriangles() {
        return segment.get(LAYOUT$transformFeedbackStreamsLinesTriangles, OFFSET$transformFeedbackStreamsLinesTriangles);
    }

    public VkPhysicalDeviceTransformFeedbackPropertiesEXT transformFeedbackStreamsLinesTriangles(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$transformFeedbackStreamsLinesTriangles, OFFSET$transformFeedbackStreamsLinesTriangles, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int transformFeedbackRasterizationStreamSelect() {
        return segment.get(LAYOUT$transformFeedbackRasterizationStreamSelect, OFFSET$transformFeedbackRasterizationStreamSelect);
    }

    public VkPhysicalDeviceTransformFeedbackPropertiesEXT transformFeedbackRasterizationStreamSelect(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$transformFeedbackRasterizationStreamSelect, OFFSET$transformFeedbackRasterizationStreamSelect, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int transformFeedbackDraw() {
        return segment.get(LAYOUT$transformFeedbackDraw, OFFSET$transformFeedbackDraw);
    }

    public VkPhysicalDeviceTransformFeedbackPropertiesEXT transformFeedbackDraw(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$transformFeedbackDraw, OFFSET$transformFeedbackDraw, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("maxTransformFeedbackStreams"),
        ValueLayout.JAVA_INT.withName("maxTransformFeedbackBuffers"),
        ValueLayout.JAVA_LONG.withName("maxTransformFeedbackBufferSize"),
        ValueLayout.JAVA_INT.withName("maxTransformFeedbackStreamDataSize"),
        ValueLayout.JAVA_INT.withName("maxTransformFeedbackBufferDataSize"),
        ValueLayout.JAVA_INT.withName("maxTransformFeedbackBufferDataStride"),
        ValueLayout.JAVA_INT.withName("transformFeedbackQueries"),
        ValueLayout.JAVA_INT.withName("transformFeedbackStreamsLinesTriangles"),
        ValueLayout.JAVA_INT.withName("transformFeedbackRasterizationStreamSelect"),
        ValueLayout.JAVA_INT.withName("transformFeedbackDraw")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$maxTransformFeedbackStreams = PathElement.groupElement("maxTransformFeedbackStreams");
    public static final PathElement PATH$maxTransformFeedbackBuffers = PathElement.groupElement("maxTransformFeedbackBuffers");
    public static final PathElement PATH$maxTransformFeedbackBufferSize = PathElement.groupElement("maxTransformFeedbackBufferSize");
    public static final PathElement PATH$maxTransformFeedbackStreamDataSize = PathElement.groupElement("maxTransformFeedbackStreamDataSize");
    public static final PathElement PATH$maxTransformFeedbackBufferDataSize = PathElement.groupElement("maxTransformFeedbackBufferDataSize");
    public static final PathElement PATH$maxTransformFeedbackBufferDataStride = PathElement.groupElement("maxTransformFeedbackBufferDataStride");
    public static final PathElement PATH$transformFeedbackQueries = PathElement.groupElement("transformFeedbackQueries");
    public static final PathElement PATH$transformFeedbackStreamsLinesTriangles = PathElement.groupElement("transformFeedbackStreamsLinesTriangles");
    public static final PathElement PATH$transformFeedbackRasterizationStreamSelect = PathElement.groupElement("transformFeedbackRasterizationStreamSelect");
    public static final PathElement PATH$transformFeedbackDraw = PathElement.groupElement("transformFeedbackDraw");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$maxTransformFeedbackStreams = (OfInt) LAYOUT.select(PATH$maxTransformFeedbackStreams);
    public static final OfInt LAYOUT$maxTransformFeedbackBuffers = (OfInt) LAYOUT.select(PATH$maxTransformFeedbackBuffers);
    public static final OfLong LAYOUT$maxTransformFeedbackBufferSize = (OfLong) LAYOUT.select(PATH$maxTransformFeedbackBufferSize);
    public static final OfInt LAYOUT$maxTransformFeedbackStreamDataSize = (OfInt) LAYOUT.select(PATH$maxTransformFeedbackStreamDataSize);
    public static final OfInt LAYOUT$maxTransformFeedbackBufferDataSize = (OfInt) LAYOUT.select(PATH$maxTransformFeedbackBufferDataSize);
    public static final OfInt LAYOUT$maxTransformFeedbackBufferDataStride = (OfInt) LAYOUT.select(PATH$maxTransformFeedbackBufferDataStride);
    public static final OfInt LAYOUT$transformFeedbackQueries = (OfInt) LAYOUT.select(PATH$transformFeedbackQueries);
    public static final OfInt LAYOUT$transformFeedbackStreamsLinesTriangles = (OfInt) LAYOUT.select(PATH$transformFeedbackStreamsLinesTriangles);
    public static final OfInt LAYOUT$transformFeedbackRasterizationStreamSelect = (OfInt) LAYOUT.select(PATH$transformFeedbackRasterizationStreamSelect);
    public static final OfInt LAYOUT$transformFeedbackDraw = (OfInt) LAYOUT.select(PATH$transformFeedbackDraw);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$maxTransformFeedbackStreams = LAYOUT$maxTransformFeedbackStreams.byteSize();
    public static final long SIZE$maxTransformFeedbackBuffers = LAYOUT$maxTransformFeedbackBuffers.byteSize();
    public static final long SIZE$maxTransformFeedbackBufferSize = LAYOUT$maxTransformFeedbackBufferSize.byteSize();
    public static final long SIZE$maxTransformFeedbackStreamDataSize = LAYOUT$maxTransformFeedbackStreamDataSize.byteSize();
    public static final long SIZE$maxTransformFeedbackBufferDataSize = LAYOUT$maxTransformFeedbackBufferDataSize.byteSize();
    public static final long SIZE$maxTransformFeedbackBufferDataStride = LAYOUT$maxTransformFeedbackBufferDataStride.byteSize();
    public static final long SIZE$transformFeedbackQueries = LAYOUT$transformFeedbackQueries.byteSize();
    public static final long SIZE$transformFeedbackStreamsLinesTriangles = LAYOUT$transformFeedbackStreamsLinesTriangles.byteSize();
    public static final long SIZE$transformFeedbackRasterizationStreamSelect = LAYOUT$transformFeedbackRasterizationStreamSelect.byteSize();
    public static final long SIZE$transformFeedbackDraw = LAYOUT$transformFeedbackDraw.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$maxTransformFeedbackStreams = LAYOUT.byteOffset(PATH$maxTransformFeedbackStreams);
    public static final long OFFSET$maxTransformFeedbackBuffers = LAYOUT.byteOffset(PATH$maxTransformFeedbackBuffers);
    public static final long OFFSET$maxTransformFeedbackBufferSize = LAYOUT.byteOffset(PATH$maxTransformFeedbackBufferSize);
    public static final long OFFSET$maxTransformFeedbackStreamDataSize = LAYOUT.byteOffset(PATH$maxTransformFeedbackStreamDataSize);
    public static final long OFFSET$maxTransformFeedbackBufferDataSize = LAYOUT.byteOffset(PATH$maxTransformFeedbackBufferDataSize);
    public static final long OFFSET$maxTransformFeedbackBufferDataStride = LAYOUT.byteOffset(PATH$maxTransformFeedbackBufferDataStride);
    public static final long OFFSET$transformFeedbackQueries = LAYOUT.byteOffset(PATH$transformFeedbackQueries);
    public static final long OFFSET$transformFeedbackStreamsLinesTriangles = LAYOUT.byteOffset(PATH$transformFeedbackStreamsLinesTriangles);
    public static final long OFFSET$transformFeedbackRasterizationStreamSelect = LAYOUT.byteOffset(PATH$transformFeedbackRasterizationStreamSelect);
    public static final long OFFSET$transformFeedbackDraw = LAYOUT.byteOffset(PATH$transformFeedbackDraw);
}
