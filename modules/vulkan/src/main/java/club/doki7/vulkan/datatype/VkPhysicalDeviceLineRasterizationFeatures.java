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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceLineRasterizationFeatures.html"><code>VkPhysicalDeviceLineRasterizationFeatures</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceLineRasterizationFeatures {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 rectangularLines; // @link substring="rectangularLines" target="#rectangularLines"
///     VkBool32 bresenhamLines; // @link substring="bresenhamLines" target="#bresenhamLines"
///     VkBool32 smoothLines; // @link substring="smoothLines" target="#smoothLines"
///     VkBool32 stippledRectangularLines; // @link substring="stippledRectangularLines" target="#stippledRectangularLines"
///     VkBool32 stippledBresenhamLines; // @link substring="stippledBresenhamLines" target="#stippledBresenhamLines"
///     VkBool32 stippledSmoothLines; // @link substring="stippledSmoothLines" target="#stippledSmoothLines"
/// } VkPhysicalDeviceLineRasterizationFeatures;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_LINE_RASTERIZATION_FEATURES`
///
/// The {@code allocate} ({@link VkPhysicalDeviceLineRasterizationFeatures#allocate(Arena)}, {@link VkPhysicalDeviceLineRasterizationFeatures#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceLineRasterizationFeatures#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceLineRasterizationFeatures.html"><code>VkPhysicalDeviceLineRasterizationFeatures</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceLineRasterizationFeatures(@NotNull MemorySegment segment) implements IVkPhysicalDeviceLineRasterizationFeatures {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceLineRasterizationFeatures.html"><code>VkPhysicalDeviceLineRasterizationFeatures</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceLineRasterizationFeatures}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceLineRasterizationFeatures to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceLineRasterizationFeatures.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceLineRasterizationFeatures, Iterable<VkPhysicalDeviceLineRasterizationFeatures> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceLineRasterizationFeatures.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceLineRasterizationFeatures at(long index) {
            return new VkPhysicalDeviceLineRasterizationFeatures(segment.asSlice(index * VkPhysicalDeviceLineRasterizationFeatures.BYTES, VkPhysicalDeviceLineRasterizationFeatures.BYTES));
        }

        public VkPhysicalDeviceLineRasterizationFeatures.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceLineRasterizationFeatures> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceLineRasterizationFeatures value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceLineRasterizationFeatures.BYTES, VkPhysicalDeviceLineRasterizationFeatures.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceLineRasterizationFeatures.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceLineRasterizationFeatures.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceLineRasterizationFeatures.BYTES,
                (end - start) * VkPhysicalDeviceLineRasterizationFeatures.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceLineRasterizationFeatures.BYTES));
        }

        public VkPhysicalDeviceLineRasterizationFeatures[] toArray() {
            VkPhysicalDeviceLineRasterizationFeatures[] ret = new VkPhysicalDeviceLineRasterizationFeatures[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceLineRasterizationFeatures> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceLineRasterizationFeatures> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceLineRasterizationFeatures.BYTES;
            }

            @Override
            public VkPhysicalDeviceLineRasterizationFeatures next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceLineRasterizationFeatures ret = new VkPhysicalDeviceLineRasterizationFeatures(segment.asSlice(0, VkPhysicalDeviceLineRasterizationFeatures.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceLineRasterizationFeatures.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceLineRasterizationFeatures allocate(Arena arena) {
        VkPhysicalDeviceLineRasterizationFeatures ret = new VkPhysicalDeviceLineRasterizationFeatures(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_LINE_RASTERIZATION_FEATURES);
        return ret;
    }

    public static VkPhysicalDeviceLineRasterizationFeatures.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceLineRasterizationFeatures.Ptr ret = new VkPhysicalDeviceLineRasterizationFeatures.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_LINE_RASTERIZATION_FEATURES);
        }
        return ret;
    }

    public static VkPhysicalDeviceLineRasterizationFeatures clone(Arena arena, VkPhysicalDeviceLineRasterizationFeatures src) {
        VkPhysicalDeviceLineRasterizationFeatures ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_LINE_RASTERIZATION_FEATURES);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceLineRasterizationFeatures sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceLineRasterizationFeatures pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceLineRasterizationFeatures pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int rectangularLines() {
        return segment.get(LAYOUT$rectangularLines, OFFSET$rectangularLines);
    }

    public VkPhysicalDeviceLineRasterizationFeatures rectangularLines(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$rectangularLines, OFFSET$rectangularLines, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int bresenhamLines() {
        return segment.get(LAYOUT$bresenhamLines, OFFSET$bresenhamLines);
    }

    public VkPhysicalDeviceLineRasterizationFeatures bresenhamLines(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$bresenhamLines, OFFSET$bresenhamLines, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int smoothLines() {
        return segment.get(LAYOUT$smoothLines, OFFSET$smoothLines);
    }

    public VkPhysicalDeviceLineRasterizationFeatures smoothLines(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$smoothLines, OFFSET$smoothLines, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int stippledRectangularLines() {
        return segment.get(LAYOUT$stippledRectangularLines, OFFSET$stippledRectangularLines);
    }

    public VkPhysicalDeviceLineRasterizationFeatures stippledRectangularLines(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$stippledRectangularLines, OFFSET$stippledRectangularLines, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int stippledBresenhamLines() {
        return segment.get(LAYOUT$stippledBresenhamLines, OFFSET$stippledBresenhamLines);
    }

    public VkPhysicalDeviceLineRasterizationFeatures stippledBresenhamLines(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$stippledBresenhamLines, OFFSET$stippledBresenhamLines, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int stippledSmoothLines() {
        return segment.get(LAYOUT$stippledSmoothLines, OFFSET$stippledSmoothLines);
    }

    public VkPhysicalDeviceLineRasterizationFeatures stippledSmoothLines(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$stippledSmoothLines, OFFSET$stippledSmoothLines, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("rectangularLines"),
        ValueLayout.JAVA_INT.withName("bresenhamLines"),
        ValueLayout.JAVA_INT.withName("smoothLines"),
        ValueLayout.JAVA_INT.withName("stippledRectangularLines"),
        ValueLayout.JAVA_INT.withName("stippledBresenhamLines"),
        ValueLayout.JAVA_INT.withName("stippledSmoothLines")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$rectangularLines = PathElement.groupElement("rectangularLines");
    public static final PathElement PATH$bresenhamLines = PathElement.groupElement("bresenhamLines");
    public static final PathElement PATH$smoothLines = PathElement.groupElement("smoothLines");
    public static final PathElement PATH$stippledRectangularLines = PathElement.groupElement("stippledRectangularLines");
    public static final PathElement PATH$stippledBresenhamLines = PathElement.groupElement("stippledBresenhamLines");
    public static final PathElement PATH$stippledSmoothLines = PathElement.groupElement("stippledSmoothLines");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$rectangularLines = (OfInt) LAYOUT.select(PATH$rectangularLines);
    public static final OfInt LAYOUT$bresenhamLines = (OfInt) LAYOUT.select(PATH$bresenhamLines);
    public static final OfInt LAYOUT$smoothLines = (OfInt) LAYOUT.select(PATH$smoothLines);
    public static final OfInt LAYOUT$stippledRectangularLines = (OfInt) LAYOUT.select(PATH$stippledRectangularLines);
    public static final OfInt LAYOUT$stippledBresenhamLines = (OfInt) LAYOUT.select(PATH$stippledBresenhamLines);
    public static final OfInt LAYOUT$stippledSmoothLines = (OfInt) LAYOUT.select(PATH$stippledSmoothLines);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$rectangularLines = LAYOUT$rectangularLines.byteSize();
    public static final long SIZE$bresenhamLines = LAYOUT$bresenhamLines.byteSize();
    public static final long SIZE$smoothLines = LAYOUT$smoothLines.byteSize();
    public static final long SIZE$stippledRectangularLines = LAYOUT$stippledRectangularLines.byteSize();
    public static final long SIZE$stippledBresenhamLines = LAYOUT$stippledBresenhamLines.byteSize();
    public static final long SIZE$stippledSmoothLines = LAYOUT$stippledSmoothLines.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$rectangularLines = LAYOUT.byteOffset(PATH$rectangularLines);
    public static final long OFFSET$bresenhamLines = LAYOUT.byteOffset(PATH$bresenhamLines);
    public static final long OFFSET$smoothLines = LAYOUT.byteOffset(PATH$smoothLines);
    public static final long OFFSET$stippledRectangularLines = LAYOUT.byteOffset(PATH$stippledRectangularLines);
    public static final long OFFSET$stippledBresenhamLines = LAYOUT.byteOffset(PATH$stippledBresenhamLines);
    public static final long OFFSET$stippledSmoothLines = LAYOUT.byteOffset(PATH$stippledSmoothLines);
}
