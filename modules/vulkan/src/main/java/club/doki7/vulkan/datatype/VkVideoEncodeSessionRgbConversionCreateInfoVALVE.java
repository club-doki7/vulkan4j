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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeSessionRgbConversionCreateInfoVALVE.html"><code>VkVideoEncodeSessionRgbConversionCreateInfoVALVE</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkVideoEncodeSessionRgbConversionCreateInfoVALVE {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkVideoEncodeRgbModelConversionFlagsVALVE rgbModel; // @link substring="VkVideoEncodeRgbModelConversionFlagsVALVE" target="VkVideoEncodeRgbModelConversionFlagsVALVE" @link substring="rgbModel" target="#rgbModel"
///     VkVideoEncodeRgbRangeCompressionFlagsVALVE rgbRange; // @link substring="VkVideoEncodeRgbRangeCompressionFlagsVALVE" target="VkVideoEncodeRgbRangeCompressionFlagsVALVE" @link substring="rgbRange" target="#rgbRange"
///     VkVideoEncodeRgbChromaOffsetFlagsVALVE xChromaOffset; // @link substring="VkVideoEncodeRgbChromaOffsetFlagsVALVE" target="VkVideoEncodeRgbChromaOffsetFlagsVALVE" @link substring="xChromaOffset" target="#xChromaOffset"
///     VkVideoEncodeRgbChromaOffsetFlagsVALVE yChromaOffset; // @link substring="VkVideoEncodeRgbChromaOffsetFlagsVALVE" target="VkVideoEncodeRgbChromaOffsetFlagsVALVE" @link substring="yChromaOffset" target="#yChromaOffset"
/// } VkVideoEncodeSessionRgbConversionCreateInfoVALVE;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_VIDEO_ENCODE_SESSION_RGB_CONVERSION_CREATE_INFO_VALVE`
///
/// The {@code allocate} ({@link VkVideoEncodeSessionRgbConversionCreateInfoVALVE#allocate(Arena)}, {@link VkVideoEncodeSessionRgbConversionCreateInfoVALVE#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkVideoEncodeSessionRgbConversionCreateInfoVALVE#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeSessionRgbConversionCreateInfoVALVE.html"><code>VkVideoEncodeSessionRgbConversionCreateInfoVALVE</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkVideoEncodeSessionRgbConversionCreateInfoVALVE(@NotNull MemorySegment segment) implements IVkVideoEncodeSessionRgbConversionCreateInfoVALVE {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeSessionRgbConversionCreateInfoVALVE.html"><code>VkVideoEncodeSessionRgbConversionCreateInfoVALVE</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkVideoEncodeSessionRgbConversionCreateInfoVALVE}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkVideoEncodeSessionRgbConversionCreateInfoVALVE to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkVideoEncodeSessionRgbConversionCreateInfoVALVE.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkVideoEncodeSessionRgbConversionCreateInfoVALVE, Iterable<VkVideoEncodeSessionRgbConversionCreateInfoVALVE> {
        public long size() {
            return segment.byteSize() / VkVideoEncodeSessionRgbConversionCreateInfoVALVE.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkVideoEncodeSessionRgbConversionCreateInfoVALVE at(long index) {
            return new VkVideoEncodeSessionRgbConversionCreateInfoVALVE(segment.asSlice(index * VkVideoEncodeSessionRgbConversionCreateInfoVALVE.BYTES, VkVideoEncodeSessionRgbConversionCreateInfoVALVE.BYTES));
        }

        public VkVideoEncodeSessionRgbConversionCreateInfoVALVE.Ptr at(long index, @NotNull Consumer<@NotNull VkVideoEncodeSessionRgbConversionCreateInfoVALVE> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkVideoEncodeSessionRgbConversionCreateInfoVALVE value) {
            MemorySegment s = segment.asSlice(index * VkVideoEncodeSessionRgbConversionCreateInfoVALVE.BYTES, VkVideoEncodeSessionRgbConversionCreateInfoVALVE.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkVideoEncodeSessionRgbConversionCreateInfoVALVE.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkVideoEncodeSessionRgbConversionCreateInfoVALVE.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkVideoEncodeSessionRgbConversionCreateInfoVALVE.BYTES,
                (end - start) * VkVideoEncodeSessionRgbConversionCreateInfoVALVE.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkVideoEncodeSessionRgbConversionCreateInfoVALVE.BYTES));
        }

        public VkVideoEncodeSessionRgbConversionCreateInfoVALVE[] toArray() {
            VkVideoEncodeSessionRgbConversionCreateInfoVALVE[] ret = new VkVideoEncodeSessionRgbConversionCreateInfoVALVE[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkVideoEncodeSessionRgbConversionCreateInfoVALVE> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkVideoEncodeSessionRgbConversionCreateInfoVALVE> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkVideoEncodeSessionRgbConversionCreateInfoVALVE.BYTES;
            }

            @Override
            public VkVideoEncodeSessionRgbConversionCreateInfoVALVE next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkVideoEncodeSessionRgbConversionCreateInfoVALVE ret = new VkVideoEncodeSessionRgbConversionCreateInfoVALVE(segment.asSlice(0, VkVideoEncodeSessionRgbConversionCreateInfoVALVE.BYTES));
                segment = segment.asSlice(VkVideoEncodeSessionRgbConversionCreateInfoVALVE.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkVideoEncodeSessionRgbConversionCreateInfoVALVE allocate(Arena arena) {
        VkVideoEncodeSessionRgbConversionCreateInfoVALVE ret = new VkVideoEncodeSessionRgbConversionCreateInfoVALVE(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.VIDEO_ENCODE_SESSION_RGB_CONVERSION_CREATE_INFO_VALVE);
        return ret;
    }

    public static VkVideoEncodeSessionRgbConversionCreateInfoVALVE.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkVideoEncodeSessionRgbConversionCreateInfoVALVE.Ptr ret = new VkVideoEncodeSessionRgbConversionCreateInfoVALVE.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.VIDEO_ENCODE_SESSION_RGB_CONVERSION_CREATE_INFO_VALVE);
        }
        return ret;
    }

    public static VkVideoEncodeSessionRgbConversionCreateInfoVALVE clone(Arena arena, VkVideoEncodeSessionRgbConversionCreateInfoVALVE src) {
        VkVideoEncodeSessionRgbConversionCreateInfoVALVE ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.VIDEO_ENCODE_SESSION_RGB_CONVERSION_CREATE_INFO_VALVE);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkVideoEncodeSessionRgbConversionCreateInfoVALVE sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkVideoEncodeSessionRgbConversionCreateInfoVALVE pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkVideoEncodeSessionRgbConversionCreateInfoVALVE pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkVideoEncodeRgbModelConversionFlagsVALVE.class) int rgbModel() {
        return segment.get(LAYOUT$rgbModel, OFFSET$rgbModel);
    }

    public VkVideoEncodeSessionRgbConversionCreateInfoVALVE rgbModel(@Bitmask(VkVideoEncodeRgbModelConversionFlagsVALVE.class) int value) {
        segment.set(LAYOUT$rgbModel, OFFSET$rgbModel, value);
        return this;
    }

    public @Bitmask(VkVideoEncodeRgbRangeCompressionFlagsVALVE.class) int rgbRange() {
        return segment.get(LAYOUT$rgbRange, OFFSET$rgbRange);
    }

    public VkVideoEncodeSessionRgbConversionCreateInfoVALVE rgbRange(@Bitmask(VkVideoEncodeRgbRangeCompressionFlagsVALVE.class) int value) {
        segment.set(LAYOUT$rgbRange, OFFSET$rgbRange, value);
        return this;
    }

    public @Bitmask(VkVideoEncodeRgbChromaOffsetFlagsVALVE.class) int xChromaOffset() {
        return segment.get(LAYOUT$xChromaOffset, OFFSET$xChromaOffset);
    }

    public VkVideoEncodeSessionRgbConversionCreateInfoVALVE xChromaOffset(@Bitmask(VkVideoEncodeRgbChromaOffsetFlagsVALVE.class) int value) {
        segment.set(LAYOUT$xChromaOffset, OFFSET$xChromaOffset, value);
        return this;
    }

    public @Bitmask(VkVideoEncodeRgbChromaOffsetFlagsVALVE.class) int yChromaOffset() {
        return segment.get(LAYOUT$yChromaOffset, OFFSET$yChromaOffset);
    }

    public VkVideoEncodeSessionRgbConversionCreateInfoVALVE yChromaOffset(@Bitmask(VkVideoEncodeRgbChromaOffsetFlagsVALVE.class) int value) {
        segment.set(LAYOUT$yChromaOffset, OFFSET$yChromaOffset, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("rgbModel"),
        ValueLayout.JAVA_INT.withName("rgbRange"),
        ValueLayout.JAVA_INT.withName("xChromaOffset"),
        ValueLayout.JAVA_INT.withName("yChromaOffset")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$rgbModel = PathElement.groupElement("rgbModel");
    public static final PathElement PATH$rgbRange = PathElement.groupElement("rgbRange");
    public static final PathElement PATH$xChromaOffset = PathElement.groupElement("xChromaOffset");
    public static final PathElement PATH$yChromaOffset = PathElement.groupElement("yChromaOffset");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$rgbModel = (OfInt) LAYOUT.select(PATH$rgbModel);
    public static final OfInt LAYOUT$rgbRange = (OfInt) LAYOUT.select(PATH$rgbRange);
    public static final OfInt LAYOUT$xChromaOffset = (OfInt) LAYOUT.select(PATH$xChromaOffset);
    public static final OfInt LAYOUT$yChromaOffset = (OfInt) LAYOUT.select(PATH$yChromaOffset);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$rgbModel = LAYOUT$rgbModel.byteSize();
    public static final long SIZE$rgbRange = LAYOUT$rgbRange.byteSize();
    public static final long SIZE$xChromaOffset = LAYOUT$xChromaOffset.byteSize();
    public static final long SIZE$yChromaOffset = LAYOUT$yChromaOffset.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$rgbModel = LAYOUT.byteOffset(PATH$rgbModel);
    public static final long OFFSET$rgbRange = LAYOUT.byteOffset(PATH$rgbRange);
    public static final long OFFSET$xChromaOffset = LAYOUT.byteOffset(PATH$xChromaOffset);
    public static final long OFFSET$yChromaOffset = LAYOUT.byteOffset(PATH$yChromaOffset);
}
