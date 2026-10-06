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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoFormatH265QuantizationMapPropertiesKHR.html"><code>VkVideoFormatH265QuantizationMapPropertiesKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkVideoFormatH265QuantizationMapPropertiesKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkVideoEncodeH265CtbSizeFlagsKHR compatibleCtbSizes; // @link substring="VkVideoEncodeH265CtbSizeFlagsKHR" target="VkVideoEncodeH265CtbSizeFlagsKHR" @link substring="compatibleCtbSizes" target="#compatibleCtbSizes"
/// } VkVideoFormatH265QuantizationMapPropertiesKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_VIDEO_FORMAT_H265_QUANTIZATION_MAP_PROPERTIES_KHR`
///
/// The {@code allocate} ({@link VkVideoFormatH265QuantizationMapPropertiesKHR#allocate(Arena)}, {@link VkVideoFormatH265QuantizationMapPropertiesKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkVideoFormatH265QuantizationMapPropertiesKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoFormatH265QuantizationMapPropertiesKHR.html"><code>VkVideoFormatH265QuantizationMapPropertiesKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkVideoFormatH265QuantizationMapPropertiesKHR(@NotNull MemorySegment segment) implements IVkVideoFormatH265QuantizationMapPropertiesKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoFormatH265QuantizationMapPropertiesKHR.html"><code>VkVideoFormatH265QuantizationMapPropertiesKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkVideoFormatH265QuantizationMapPropertiesKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkVideoFormatH265QuantizationMapPropertiesKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkVideoFormatH265QuantizationMapPropertiesKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkVideoFormatH265QuantizationMapPropertiesKHR, Iterable<VkVideoFormatH265QuantizationMapPropertiesKHR> {
        public long size() {
            return segment.byteSize() / VkVideoFormatH265QuantizationMapPropertiesKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkVideoFormatH265QuantizationMapPropertiesKHR at(long index) {
            return new VkVideoFormatH265QuantizationMapPropertiesKHR(segment.asSlice(index * VkVideoFormatH265QuantizationMapPropertiesKHR.BYTES, VkVideoFormatH265QuantizationMapPropertiesKHR.BYTES));
        }

        public VkVideoFormatH265QuantizationMapPropertiesKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkVideoFormatH265QuantizationMapPropertiesKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkVideoFormatH265QuantizationMapPropertiesKHR value) {
            MemorySegment s = segment.asSlice(index * VkVideoFormatH265QuantizationMapPropertiesKHR.BYTES, VkVideoFormatH265QuantizationMapPropertiesKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkVideoFormatH265QuantizationMapPropertiesKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkVideoFormatH265QuantizationMapPropertiesKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkVideoFormatH265QuantizationMapPropertiesKHR.BYTES,
                (end - start) * VkVideoFormatH265QuantizationMapPropertiesKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkVideoFormatH265QuantizationMapPropertiesKHR.BYTES));
        }

        public VkVideoFormatH265QuantizationMapPropertiesKHR[] toArray() {
            VkVideoFormatH265QuantizationMapPropertiesKHR[] ret = new VkVideoFormatH265QuantizationMapPropertiesKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkVideoFormatH265QuantizationMapPropertiesKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkVideoFormatH265QuantizationMapPropertiesKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkVideoFormatH265QuantizationMapPropertiesKHR.BYTES;
            }

            @Override
            public VkVideoFormatH265QuantizationMapPropertiesKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkVideoFormatH265QuantizationMapPropertiesKHR ret = new VkVideoFormatH265QuantizationMapPropertiesKHR(segment.asSlice(0, VkVideoFormatH265QuantizationMapPropertiesKHR.BYTES));
                segment = segment.asSlice(VkVideoFormatH265QuantizationMapPropertiesKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkVideoFormatH265QuantizationMapPropertiesKHR allocate(Arena arena) {
        VkVideoFormatH265QuantizationMapPropertiesKHR ret = new VkVideoFormatH265QuantizationMapPropertiesKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.VIDEO_FORMAT_H265_QUANTIZATION_MAP_PROPERTIES_KHR);
        return ret;
    }

    public static VkVideoFormatH265QuantizationMapPropertiesKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkVideoFormatH265QuantizationMapPropertiesKHR.Ptr ret = new VkVideoFormatH265QuantizationMapPropertiesKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.VIDEO_FORMAT_H265_QUANTIZATION_MAP_PROPERTIES_KHR);
        }
        return ret;
    }

    public static VkVideoFormatH265QuantizationMapPropertiesKHR clone(Arena arena, VkVideoFormatH265QuantizationMapPropertiesKHR src) {
        VkVideoFormatH265QuantizationMapPropertiesKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.VIDEO_FORMAT_H265_QUANTIZATION_MAP_PROPERTIES_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkVideoFormatH265QuantizationMapPropertiesKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkVideoFormatH265QuantizationMapPropertiesKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkVideoFormatH265QuantizationMapPropertiesKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkVideoEncodeH265CtbSizeFlagsKHR.class) int compatibleCtbSizes() {
        return segment.get(LAYOUT$compatibleCtbSizes, OFFSET$compatibleCtbSizes);
    }

    public VkVideoFormatH265QuantizationMapPropertiesKHR compatibleCtbSizes(@Bitmask(VkVideoEncodeH265CtbSizeFlagsKHR.class) int value) {
        segment.set(LAYOUT$compatibleCtbSizes, OFFSET$compatibleCtbSizes, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("compatibleCtbSizes")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$compatibleCtbSizes = PathElement.groupElement("compatibleCtbSizes");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$compatibleCtbSizes = (OfInt) LAYOUT.select(PATH$compatibleCtbSizes);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$compatibleCtbSizes = LAYOUT$compatibleCtbSizes.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$compatibleCtbSizes = LAYOUT.byteOffset(PATH$compatibleCtbSizes);
}
