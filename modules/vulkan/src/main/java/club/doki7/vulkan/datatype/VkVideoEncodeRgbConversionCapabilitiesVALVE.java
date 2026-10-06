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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeRgbConversionCapabilitiesVALVE.html"><code>VkVideoEncodeRgbConversionCapabilitiesVALVE</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkVideoEncodeRgbConversionCapabilitiesVALVE {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkVideoEncodeRgbModelConversionFlagsVALVE rgbModels; // @link substring="VkVideoEncodeRgbModelConversionFlagsVALVE" target="VkVideoEncodeRgbModelConversionFlagsVALVE" @link substring="rgbModels" target="#rgbModels"
///     VkVideoEncodeRgbRangeCompressionFlagsVALVE rgbRanges; // @link substring="VkVideoEncodeRgbRangeCompressionFlagsVALVE" target="VkVideoEncodeRgbRangeCompressionFlagsVALVE" @link substring="rgbRanges" target="#rgbRanges"
///     VkVideoEncodeRgbChromaOffsetFlagsVALVE xChromaOffsets; // @link substring="VkVideoEncodeRgbChromaOffsetFlagsVALVE" target="VkVideoEncodeRgbChromaOffsetFlagsVALVE" @link substring="xChromaOffsets" target="#xChromaOffsets"
///     VkVideoEncodeRgbChromaOffsetFlagsVALVE yChromaOffsets; // @link substring="VkVideoEncodeRgbChromaOffsetFlagsVALVE" target="VkVideoEncodeRgbChromaOffsetFlagsVALVE" @link substring="yChromaOffsets" target="#yChromaOffsets"
/// } VkVideoEncodeRgbConversionCapabilitiesVALVE;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_VIDEO_ENCODE_RGB_CONVERSION_CAPABILITIES_VALVE`
///
/// The {@code allocate} ({@link VkVideoEncodeRgbConversionCapabilitiesVALVE#allocate(Arena)}, {@link VkVideoEncodeRgbConversionCapabilitiesVALVE#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkVideoEncodeRgbConversionCapabilitiesVALVE#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeRgbConversionCapabilitiesVALVE.html"><code>VkVideoEncodeRgbConversionCapabilitiesVALVE</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkVideoEncodeRgbConversionCapabilitiesVALVE(@NotNull MemorySegment segment) implements IVkVideoEncodeRgbConversionCapabilitiesVALVE {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeRgbConversionCapabilitiesVALVE.html"><code>VkVideoEncodeRgbConversionCapabilitiesVALVE</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkVideoEncodeRgbConversionCapabilitiesVALVE}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkVideoEncodeRgbConversionCapabilitiesVALVE to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkVideoEncodeRgbConversionCapabilitiesVALVE.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkVideoEncodeRgbConversionCapabilitiesVALVE, Iterable<VkVideoEncodeRgbConversionCapabilitiesVALVE> {
        public long size() {
            return segment.byteSize() / VkVideoEncodeRgbConversionCapabilitiesVALVE.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkVideoEncodeRgbConversionCapabilitiesVALVE at(long index) {
            return new VkVideoEncodeRgbConversionCapabilitiesVALVE(segment.asSlice(index * VkVideoEncodeRgbConversionCapabilitiesVALVE.BYTES, VkVideoEncodeRgbConversionCapabilitiesVALVE.BYTES));
        }

        public VkVideoEncodeRgbConversionCapabilitiesVALVE.Ptr at(long index, @NotNull Consumer<@NotNull VkVideoEncodeRgbConversionCapabilitiesVALVE> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkVideoEncodeRgbConversionCapabilitiesVALVE value) {
            MemorySegment s = segment.asSlice(index * VkVideoEncodeRgbConversionCapabilitiesVALVE.BYTES, VkVideoEncodeRgbConversionCapabilitiesVALVE.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkVideoEncodeRgbConversionCapabilitiesVALVE.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkVideoEncodeRgbConversionCapabilitiesVALVE.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkVideoEncodeRgbConversionCapabilitiesVALVE.BYTES,
                (end - start) * VkVideoEncodeRgbConversionCapabilitiesVALVE.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkVideoEncodeRgbConversionCapabilitiesVALVE.BYTES));
        }

        public VkVideoEncodeRgbConversionCapabilitiesVALVE[] toArray() {
            VkVideoEncodeRgbConversionCapabilitiesVALVE[] ret = new VkVideoEncodeRgbConversionCapabilitiesVALVE[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkVideoEncodeRgbConversionCapabilitiesVALVE> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkVideoEncodeRgbConversionCapabilitiesVALVE> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkVideoEncodeRgbConversionCapabilitiesVALVE.BYTES;
            }

            @Override
            public VkVideoEncodeRgbConversionCapabilitiesVALVE next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkVideoEncodeRgbConversionCapabilitiesVALVE ret = new VkVideoEncodeRgbConversionCapabilitiesVALVE(segment.asSlice(0, VkVideoEncodeRgbConversionCapabilitiesVALVE.BYTES));
                segment = segment.asSlice(VkVideoEncodeRgbConversionCapabilitiesVALVE.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkVideoEncodeRgbConversionCapabilitiesVALVE allocate(Arena arena) {
        VkVideoEncodeRgbConversionCapabilitiesVALVE ret = new VkVideoEncodeRgbConversionCapabilitiesVALVE(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.VIDEO_ENCODE_RGB_CONVERSION_CAPABILITIES_VALVE);
        return ret;
    }

    public static VkVideoEncodeRgbConversionCapabilitiesVALVE.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkVideoEncodeRgbConversionCapabilitiesVALVE.Ptr ret = new VkVideoEncodeRgbConversionCapabilitiesVALVE.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.VIDEO_ENCODE_RGB_CONVERSION_CAPABILITIES_VALVE);
        }
        return ret;
    }

    public static VkVideoEncodeRgbConversionCapabilitiesVALVE clone(Arena arena, VkVideoEncodeRgbConversionCapabilitiesVALVE src) {
        VkVideoEncodeRgbConversionCapabilitiesVALVE ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.VIDEO_ENCODE_RGB_CONVERSION_CAPABILITIES_VALVE);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkVideoEncodeRgbConversionCapabilitiesVALVE sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkVideoEncodeRgbConversionCapabilitiesVALVE pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkVideoEncodeRgbConversionCapabilitiesVALVE pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkVideoEncodeRgbModelConversionFlagsVALVE.class) int rgbModels() {
        return segment.get(LAYOUT$rgbModels, OFFSET$rgbModels);
    }

    public VkVideoEncodeRgbConversionCapabilitiesVALVE rgbModels(@Bitmask(VkVideoEncodeRgbModelConversionFlagsVALVE.class) int value) {
        segment.set(LAYOUT$rgbModels, OFFSET$rgbModels, value);
        return this;
    }

    public @Bitmask(VkVideoEncodeRgbRangeCompressionFlagsVALVE.class) int rgbRanges() {
        return segment.get(LAYOUT$rgbRanges, OFFSET$rgbRanges);
    }

    public VkVideoEncodeRgbConversionCapabilitiesVALVE rgbRanges(@Bitmask(VkVideoEncodeRgbRangeCompressionFlagsVALVE.class) int value) {
        segment.set(LAYOUT$rgbRanges, OFFSET$rgbRanges, value);
        return this;
    }

    public @Bitmask(VkVideoEncodeRgbChromaOffsetFlagsVALVE.class) int xChromaOffsets() {
        return segment.get(LAYOUT$xChromaOffsets, OFFSET$xChromaOffsets);
    }

    public VkVideoEncodeRgbConversionCapabilitiesVALVE xChromaOffsets(@Bitmask(VkVideoEncodeRgbChromaOffsetFlagsVALVE.class) int value) {
        segment.set(LAYOUT$xChromaOffsets, OFFSET$xChromaOffsets, value);
        return this;
    }

    public @Bitmask(VkVideoEncodeRgbChromaOffsetFlagsVALVE.class) int yChromaOffsets() {
        return segment.get(LAYOUT$yChromaOffsets, OFFSET$yChromaOffsets);
    }

    public VkVideoEncodeRgbConversionCapabilitiesVALVE yChromaOffsets(@Bitmask(VkVideoEncodeRgbChromaOffsetFlagsVALVE.class) int value) {
        segment.set(LAYOUT$yChromaOffsets, OFFSET$yChromaOffsets, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("rgbModels"),
        ValueLayout.JAVA_INT.withName("rgbRanges"),
        ValueLayout.JAVA_INT.withName("xChromaOffsets"),
        ValueLayout.JAVA_INT.withName("yChromaOffsets")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$rgbModels = PathElement.groupElement("rgbModels");
    public static final PathElement PATH$rgbRanges = PathElement.groupElement("rgbRanges");
    public static final PathElement PATH$xChromaOffsets = PathElement.groupElement("xChromaOffsets");
    public static final PathElement PATH$yChromaOffsets = PathElement.groupElement("yChromaOffsets");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$rgbModels = (OfInt) LAYOUT.select(PATH$rgbModels);
    public static final OfInt LAYOUT$rgbRanges = (OfInt) LAYOUT.select(PATH$rgbRanges);
    public static final OfInt LAYOUT$xChromaOffsets = (OfInt) LAYOUT.select(PATH$xChromaOffsets);
    public static final OfInt LAYOUT$yChromaOffsets = (OfInt) LAYOUT.select(PATH$yChromaOffsets);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$rgbModels = LAYOUT$rgbModels.byteSize();
    public static final long SIZE$rgbRanges = LAYOUT$rgbRanges.byteSize();
    public static final long SIZE$xChromaOffsets = LAYOUT$xChromaOffsets.byteSize();
    public static final long SIZE$yChromaOffsets = LAYOUT$yChromaOffsets.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$rgbModels = LAYOUT.byteOffset(PATH$rgbModels);
    public static final long OFFSET$rgbRanges = LAYOUT.byteOffset(PATH$rgbRanges);
    public static final long OFFSET$xChromaOffsets = LAYOUT.byteOffset(PATH$xChromaOffsets);
    public static final long OFFSET$yChromaOffsets = LAYOUT.byteOffset(PATH$yChromaOffsets);
}
