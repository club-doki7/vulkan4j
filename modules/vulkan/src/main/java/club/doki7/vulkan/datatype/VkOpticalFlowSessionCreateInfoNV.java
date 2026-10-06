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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkOpticalFlowSessionCreateInfoNV.html"><code>VkOpticalFlowSessionCreateInfoNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkOpticalFlowSessionCreateInfoNV {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t width; // @link substring="width" target="#width"
///     uint32_t height; // @link substring="height" target="#height"
///     VkFormat imageFormat; // @link substring="VkFormat" target="VkFormat" @link substring="imageFormat" target="#imageFormat"
///     VkFormat flowVectorFormat; // @link substring="VkFormat" target="VkFormat" @link substring="flowVectorFormat" target="#flowVectorFormat"
///     VkFormat costFormat; // optional // @link substring="VkFormat" target="VkFormat" @link substring="costFormat" target="#costFormat"
///     VkOpticalFlowGridSizeFlagsNV outputGridSize; // @link substring="VkOpticalFlowGridSizeFlagsNV" target="VkOpticalFlowGridSizeFlagsNV" @link substring="outputGridSize" target="#outputGridSize"
///     VkOpticalFlowGridSizeFlagsNV hintGridSize; // optional // @link substring="VkOpticalFlowGridSizeFlagsNV" target="VkOpticalFlowGridSizeFlagsNV" @link substring="hintGridSize" target="#hintGridSize"
///     VkOpticalFlowPerformanceLevelNV performanceLevel; // optional // @link substring="VkOpticalFlowPerformanceLevelNV" target="VkOpticalFlowPerformanceLevelNV" @link substring="performanceLevel" target="#performanceLevel"
///     VkOpticalFlowSessionCreateFlagsNV flags; // optional // @link substring="VkOpticalFlowSessionCreateFlagsNV" target="VkOpticalFlowSessionCreateFlagsNV" @link substring="flags" target="#flags"
/// } VkOpticalFlowSessionCreateInfoNV;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_OPTICAL_FLOW_SESSION_CREATE_INFO_NV`
///
/// The {@code allocate} ({@link VkOpticalFlowSessionCreateInfoNV#allocate(Arena)}, {@link VkOpticalFlowSessionCreateInfoNV#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkOpticalFlowSessionCreateInfoNV#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkOpticalFlowSessionCreateInfoNV.html"><code>VkOpticalFlowSessionCreateInfoNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkOpticalFlowSessionCreateInfoNV(@NotNull MemorySegment segment) implements IVkOpticalFlowSessionCreateInfoNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkOpticalFlowSessionCreateInfoNV.html"><code>VkOpticalFlowSessionCreateInfoNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkOpticalFlowSessionCreateInfoNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkOpticalFlowSessionCreateInfoNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkOpticalFlowSessionCreateInfoNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkOpticalFlowSessionCreateInfoNV, Iterable<VkOpticalFlowSessionCreateInfoNV> {
        public long size() {
            return segment.byteSize() / VkOpticalFlowSessionCreateInfoNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkOpticalFlowSessionCreateInfoNV at(long index) {
            return new VkOpticalFlowSessionCreateInfoNV(segment.asSlice(index * VkOpticalFlowSessionCreateInfoNV.BYTES, VkOpticalFlowSessionCreateInfoNV.BYTES));
        }

        public VkOpticalFlowSessionCreateInfoNV.Ptr at(long index, @NotNull Consumer<@NotNull VkOpticalFlowSessionCreateInfoNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkOpticalFlowSessionCreateInfoNV value) {
            MemorySegment s = segment.asSlice(index * VkOpticalFlowSessionCreateInfoNV.BYTES, VkOpticalFlowSessionCreateInfoNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkOpticalFlowSessionCreateInfoNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkOpticalFlowSessionCreateInfoNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkOpticalFlowSessionCreateInfoNV.BYTES,
                (end - start) * VkOpticalFlowSessionCreateInfoNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkOpticalFlowSessionCreateInfoNV.BYTES));
        }

        public VkOpticalFlowSessionCreateInfoNV[] toArray() {
            VkOpticalFlowSessionCreateInfoNV[] ret = new VkOpticalFlowSessionCreateInfoNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkOpticalFlowSessionCreateInfoNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkOpticalFlowSessionCreateInfoNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkOpticalFlowSessionCreateInfoNV.BYTES;
            }

            @Override
            public VkOpticalFlowSessionCreateInfoNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkOpticalFlowSessionCreateInfoNV ret = new VkOpticalFlowSessionCreateInfoNV(segment.asSlice(0, VkOpticalFlowSessionCreateInfoNV.BYTES));
                segment = segment.asSlice(VkOpticalFlowSessionCreateInfoNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkOpticalFlowSessionCreateInfoNV allocate(Arena arena) {
        VkOpticalFlowSessionCreateInfoNV ret = new VkOpticalFlowSessionCreateInfoNV(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.OPTICAL_FLOW_SESSION_CREATE_INFO_NV);
        return ret;
    }

    public static VkOpticalFlowSessionCreateInfoNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkOpticalFlowSessionCreateInfoNV.Ptr ret = new VkOpticalFlowSessionCreateInfoNV.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.OPTICAL_FLOW_SESSION_CREATE_INFO_NV);
        }
        return ret;
    }

    public static VkOpticalFlowSessionCreateInfoNV clone(Arena arena, VkOpticalFlowSessionCreateInfoNV src) {
        VkOpticalFlowSessionCreateInfoNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.OPTICAL_FLOW_SESSION_CREATE_INFO_NV);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkOpticalFlowSessionCreateInfoNV sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkOpticalFlowSessionCreateInfoNV pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkOpticalFlowSessionCreateInfoNV pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int width() {
        return segment.get(LAYOUT$width, OFFSET$width);
    }

    public VkOpticalFlowSessionCreateInfoNV width(@Unsigned int value) {
        segment.set(LAYOUT$width, OFFSET$width, value);
        return this;
    }

    public @Unsigned int height() {
        return segment.get(LAYOUT$height, OFFSET$height);
    }

    public VkOpticalFlowSessionCreateInfoNV height(@Unsigned int value) {
        segment.set(LAYOUT$height, OFFSET$height, value);
        return this;
    }

    public @EnumType(VkFormat.class) int imageFormat() {
        return segment.get(LAYOUT$imageFormat, OFFSET$imageFormat);
    }

    public VkOpticalFlowSessionCreateInfoNV imageFormat(@EnumType(VkFormat.class) int value) {
        segment.set(LAYOUT$imageFormat, OFFSET$imageFormat, value);
        return this;
    }

    public @EnumType(VkFormat.class) int flowVectorFormat() {
        return segment.get(LAYOUT$flowVectorFormat, OFFSET$flowVectorFormat);
    }

    public VkOpticalFlowSessionCreateInfoNV flowVectorFormat(@EnumType(VkFormat.class) int value) {
        segment.set(LAYOUT$flowVectorFormat, OFFSET$flowVectorFormat, value);
        return this;
    }

    public @EnumType(VkFormat.class) int costFormat() {
        return segment.get(LAYOUT$costFormat, OFFSET$costFormat);
    }

    public VkOpticalFlowSessionCreateInfoNV costFormat(@EnumType(VkFormat.class) int value) {
        segment.set(LAYOUT$costFormat, OFFSET$costFormat, value);
        return this;
    }

    public @Bitmask(VkOpticalFlowGridSizeFlagsNV.class) int outputGridSize() {
        return segment.get(LAYOUT$outputGridSize, OFFSET$outputGridSize);
    }

    public VkOpticalFlowSessionCreateInfoNV outputGridSize(@Bitmask(VkOpticalFlowGridSizeFlagsNV.class) int value) {
        segment.set(LAYOUT$outputGridSize, OFFSET$outputGridSize, value);
        return this;
    }

    public @Bitmask(VkOpticalFlowGridSizeFlagsNV.class) int hintGridSize() {
        return segment.get(LAYOUT$hintGridSize, OFFSET$hintGridSize);
    }

    public VkOpticalFlowSessionCreateInfoNV hintGridSize(@Bitmask(VkOpticalFlowGridSizeFlagsNV.class) int value) {
        segment.set(LAYOUT$hintGridSize, OFFSET$hintGridSize, value);
        return this;
    }

    public @EnumType(VkOpticalFlowPerformanceLevelNV.class) int performanceLevel() {
        return segment.get(LAYOUT$performanceLevel, OFFSET$performanceLevel);
    }

    public VkOpticalFlowSessionCreateInfoNV performanceLevel(@EnumType(VkOpticalFlowPerformanceLevelNV.class) int value) {
        segment.set(LAYOUT$performanceLevel, OFFSET$performanceLevel, value);
        return this;
    }

    public @Bitmask(VkOpticalFlowSessionCreateFlagsNV.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkOpticalFlowSessionCreateInfoNV flags(@Bitmask(VkOpticalFlowSessionCreateFlagsNV.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("width"),
        ValueLayout.JAVA_INT.withName("height"),
        ValueLayout.JAVA_INT.withName("imageFormat"),
        ValueLayout.JAVA_INT.withName("flowVectorFormat"),
        ValueLayout.JAVA_INT.withName("costFormat"),
        ValueLayout.JAVA_INT.withName("outputGridSize"),
        ValueLayout.JAVA_INT.withName("hintGridSize"),
        ValueLayout.JAVA_INT.withName("performanceLevel"),
        ValueLayout.JAVA_INT.withName("flags")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$width = PathElement.groupElement("width");
    public static final PathElement PATH$height = PathElement.groupElement("height");
    public static final PathElement PATH$imageFormat = PathElement.groupElement("imageFormat");
    public static final PathElement PATH$flowVectorFormat = PathElement.groupElement("flowVectorFormat");
    public static final PathElement PATH$costFormat = PathElement.groupElement("costFormat");
    public static final PathElement PATH$outputGridSize = PathElement.groupElement("outputGridSize");
    public static final PathElement PATH$hintGridSize = PathElement.groupElement("hintGridSize");
    public static final PathElement PATH$performanceLevel = PathElement.groupElement("performanceLevel");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$width = (OfInt) LAYOUT.select(PATH$width);
    public static final OfInt LAYOUT$height = (OfInt) LAYOUT.select(PATH$height);
    public static final OfInt LAYOUT$imageFormat = (OfInt) LAYOUT.select(PATH$imageFormat);
    public static final OfInt LAYOUT$flowVectorFormat = (OfInt) LAYOUT.select(PATH$flowVectorFormat);
    public static final OfInt LAYOUT$costFormat = (OfInt) LAYOUT.select(PATH$costFormat);
    public static final OfInt LAYOUT$outputGridSize = (OfInt) LAYOUT.select(PATH$outputGridSize);
    public static final OfInt LAYOUT$hintGridSize = (OfInt) LAYOUT.select(PATH$hintGridSize);
    public static final OfInt LAYOUT$performanceLevel = (OfInt) LAYOUT.select(PATH$performanceLevel);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$width = LAYOUT$width.byteSize();
    public static final long SIZE$height = LAYOUT$height.byteSize();
    public static final long SIZE$imageFormat = LAYOUT$imageFormat.byteSize();
    public static final long SIZE$flowVectorFormat = LAYOUT$flowVectorFormat.byteSize();
    public static final long SIZE$costFormat = LAYOUT$costFormat.byteSize();
    public static final long SIZE$outputGridSize = LAYOUT$outputGridSize.byteSize();
    public static final long SIZE$hintGridSize = LAYOUT$hintGridSize.byteSize();
    public static final long SIZE$performanceLevel = LAYOUT$performanceLevel.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$width = LAYOUT.byteOffset(PATH$width);
    public static final long OFFSET$height = LAYOUT.byteOffset(PATH$height);
    public static final long OFFSET$imageFormat = LAYOUT.byteOffset(PATH$imageFormat);
    public static final long OFFSET$flowVectorFormat = LAYOUT.byteOffset(PATH$flowVectorFormat);
    public static final long OFFSET$costFormat = LAYOUT.byteOffset(PATH$costFormat);
    public static final long OFFSET$outputGridSize = LAYOUT.byteOffset(PATH$outputGridSize);
    public static final long OFFSET$hintGridSize = LAYOUT.byteOffset(PATH$hintGridSize);
    public static final long OFFSET$performanceLevel = LAYOUT.byteOffset(PATH$performanceLevel);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
}
