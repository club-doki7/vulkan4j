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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSamplerYcbcrConversionCreateInfo.html"><code>VkSamplerYcbcrConversionCreateInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkSamplerYcbcrConversionCreateInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkFormat format; // @link substring="VkFormat" target="VkFormat" @link substring="format" target="#format"
///     VkSamplerYcbcrModelConversion ycbcrModel; // @link substring="VkSamplerYcbcrModelConversion" target="VkSamplerYcbcrModelConversion" @link substring="ycbcrModel" target="#ycbcrModel"
///     VkSamplerYcbcrRange ycbcrRange; // @link substring="VkSamplerYcbcrRange" target="VkSamplerYcbcrRange" @link substring="ycbcrRange" target="#ycbcrRange"
///     VkComponentMapping components; // @link substring="VkComponentMapping" target="VkComponentMapping" @link substring="components" target="#components"
///     VkChromaLocation xChromaOffset; // @link substring="VkChromaLocation" target="VkChromaLocation" @link substring="xChromaOffset" target="#xChromaOffset"
///     VkChromaLocation yChromaOffset; // @link substring="VkChromaLocation" target="VkChromaLocation" @link substring="yChromaOffset" target="#yChromaOffset"
///     VkFilter chromaFilter; // @link substring="VkFilter" target="VkFilter" @link substring="chromaFilter" target="#chromaFilter"
///     VkBool32 forceExplicitReconstruction; // @link substring="forceExplicitReconstruction" target="#forceExplicitReconstruction"
/// } VkSamplerYcbcrConversionCreateInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_SAMPLER_YCBCR_CONVERSION_CREATE_INFO`
///
/// The {@code allocate} ({@link VkSamplerYcbcrConversionCreateInfo#allocate(Arena)}, {@link VkSamplerYcbcrConversionCreateInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkSamplerYcbcrConversionCreateInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSamplerYcbcrConversionCreateInfo.html"><code>VkSamplerYcbcrConversionCreateInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkSamplerYcbcrConversionCreateInfo(@NotNull MemorySegment segment) implements IVkSamplerYcbcrConversionCreateInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSamplerYcbcrConversionCreateInfo.html"><code>VkSamplerYcbcrConversionCreateInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkSamplerYcbcrConversionCreateInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkSamplerYcbcrConversionCreateInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkSamplerYcbcrConversionCreateInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkSamplerYcbcrConversionCreateInfo, Iterable<VkSamplerYcbcrConversionCreateInfo> {
        public long size() {
            return segment.byteSize() / VkSamplerYcbcrConversionCreateInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkSamplerYcbcrConversionCreateInfo at(long index) {
            return new VkSamplerYcbcrConversionCreateInfo(segment.asSlice(index * VkSamplerYcbcrConversionCreateInfo.BYTES, VkSamplerYcbcrConversionCreateInfo.BYTES));
        }

        public VkSamplerYcbcrConversionCreateInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkSamplerYcbcrConversionCreateInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkSamplerYcbcrConversionCreateInfo value) {
            MemorySegment s = segment.asSlice(index * VkSamplerYcbcrConversionCreateInfo.BYTES, VkSamplerYcbcrConversionCreateInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkSamplerYcbcrConversionCreateInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkSamplerYcbcrConversionCreateInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkSamplerYcbcrConversionCreateInfo.BYTES,
                (end - start) * VkSamplerYcbcrConversionCreateInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkSamplerYcbcrConversionCreateInfo.BYTES));
        }

        public VkSamplerYcbcrConversionCreateInfo[] toArray() {
            VkSamplerYcbcrConversionCreateInfo[] ret = new VkSamplerYcbcrConversionCreateInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkSamplerYcbcrConversionCreateInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkSamplerYcbcrConversionCreateInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkSamplerYcbcrConversionCreateInfo.BYTES;
            }

            @Override
            public VkSamplerYcbcrConversionCreateInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkSamplerYcbcrConversionCreateInfo ret = new VkSamplerYcbcrConversionCreateInfo(segment.asSlice(0, VkSamplerYcbcrConversionCreateInfo.BYTES));
                segment = segment.asSlice(VkSamplerYcbcrConversionCreateInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkSamplerYcbcrConversionCreateInfo allocate(Arena arena) {
        VkSamplerYcbcrConversionCreateInfo ret = new VkSamplerYcbcrConversionCreateInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.SAMPLER_YCBCR_CONVERSION_CREATE_INFO);
        return ret;
    }

    public static VkSamplerYcbcrConversionCreateInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkSamplerYcbcrConversionCreateInfo.Ptr ret = new VkSamplerYcbcrConversionCreateInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.SAMPLER_YCBCR_CONVERSION_CREATE_INFO);
        }
        return ret;
    }

    public static VkSamplerYcbcrConversionCreateInfo clone(Arena arena, VkSamplerYcbcrConversionCreateInfo src) {
        VkSamplerYcbcrConversionCreateInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.SAMPLER_YCBCR_CONVERSION_CREATE_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkSamplerYcbcrConversionCreateInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkSamplerYcbcrConversionCreateInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkSamplerYcbcrConversionCreateInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @EnumType(VkFormat.class) int format() {
        return segment.get(LAYOUT$format, OFFSET$format);
    }

    public VkSamplerYcbcrConversionCreateInfo format(@EnumType(VkFormat.class) int value) {
        segment.set(LAYOUT$format, OFFSET$format, value);
        return this;
    }

    public @EnumType(VkSamplerYcbcrModelConversion.class) int ycbcrModel() {
        return segment.get(LAYOUT$ycbcrModel, OFFSET$ycbcrModel);
    }

    public VkSamplerYcbcrConversionCreateInfo ycbcrModel(@EnumType(VkSamplerYcbcrModelConversion.class) int value) {
        segment.set(LAYOUT$ycbcrModel, OFFSET$ycbcrModel, value);
        return this;
    }

    public @EnumType(VkSamplerYcbcrRange.class) int ycbcrRange() {
        return segment.get(LAYOUT$ycbcrRange, OFFSET$ycbcrRange);
    }

    public VkSamplerYcbcrConversionCreateInfo ycbcrRange(@EnumType(VkSamplerYcbcrRange.class) int value) {
        segment.set(LAYOUT$ycbcrRange, OFFSET$ycbcrRange, value);
        return this;
    }

    public @NotNull VkComponentMapping components() {
        return new VkComponentMapping(segment.asSlice(OFFSET$components, LAYOUT$components));
    }

    public VkSamplerYcbcrConversionCreateInfo components(@NotNull VkComponentMapping value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$components, SIZE$components);
        return this;
    }

    public VkSamplerYcbcrConversionCreateInfo components(Consumer<@NotNull VkComponentMapping> consumer) {
        consumer.accept(components());
        return this;
    }

    public @EnumType(VkChromaLocation.class) int xChromaOffset() {
        return segment.get(LAYOUT$xChromaOffset, OFFSET$xChromaOffset);
    }

    public VkSamplerYcbcrConversionCreateInfo xChromaOffset(@EnumType(VkChromaLocation.class) int value) {
        segment.set(LAYOUT$xChromaOffset, OFFSET$xChromaOffset, value);
        return this;
    }

    public @EnumType(VkChromaLocation.class) int yChromaOffset() {
        return segment.get(LAYOUT$yChromaOffset, OFFSET$yChromaOffset);
    }

    public VkSamplerYcbcrConversionCreateInfo yChromaOffset(@EnumType(VkChromaLocation.class) int value) {
        segment.set(LAYOUT$yChromaOffset, OFFSET$yChromaOffset, value);
        return this;
    }

    public @EnumType(VkFilter.class) int chromaFilter() {
        return segment.get(LAYOUT$chromaFilter, OFFSET$chromaFilter);
    }

    public VkSamplerYcbcrConversionCreateInfo chromaFilter(@EnumType(VkFilter.class) int value) {
        segment.set(LAYOUT$chromaFilter, OFFSET$chromaFilter, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int forceExplicitReconstruction() {
        return segment.get(LAYOUT$forceExplicitReconstruction, OFFSET$forceExplicitReconstruction);
    }

    public VkSamplerYcbcrConversionCreateInfo forceExplicitReconstruction(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$forceExplicitReconstruction, OFFSET$forceExplicitReconstruction, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("format"),
        ValueLayout.JAVA_INT.withName("ycbcrModel"),
        ValueLayout.JAVA_INT.withName("ycbcrRange"),
        VkComponentMapping.LAYOUT.withName("components"),
        ValueLayout.JAVA_INT.withName("xChromaOffset"),
        ValueLayout.JAVA_INT.withName("yChromaOffset"),
        ValueLayout.JAVA_INT.withName("chromaFilter"),
        ValueLayout.JAVA_INT.withName("forceExplicitReconstruction")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$format = PathElement.groupElement("format");
    public static final PathElement PATH$ycbcrModel = PathElement.groupElement("ycbcrModel");
    public static final PathElement PATH$ycbcrRange = PathElement.groupElement("ycbcrRange");
    public static final PathElement PATH$components = PathElement.groupElement("components");
    public static final PathElement PATH$xChromaOffset = PathElement.groupElement("xChromaOffset");
    public static final PathElement PATH$yChromaOffset = PathElement.groupElement("yChromaOffset");
    public static final PathElement PATH$chromaFilter = PathElement.groupElement("chromaFilter");
    public static final PathElement PATH$forceExplicitReconstruction = PathElement.groupElement("forceExplicitReconstruction");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$format = (OfInt) LAYOUT.select(PATH$format);
    public static final OfInt LAYOUT$ycbcrModel = (OfInt) LAYOUT.select(PATH$ycbcrModel);
    public static final OfInt LAYOUT$ycbcrRange = (OfInt) LAYOUT.select(PATH$ycbcrRange);
    public static final StructLayout LAYOUT$components = (StructLayout) LAYOUT.select(PATH$components);
    public static final OfInt LAYOUT$xChromaOffset = (OfInt) LAYOUT.select(PATH$xChromaOffset);
    public static final OfInt LAYOUT$yChromaOffset = (OfInt) LAYOUT.select(PATH$yChromaOffset);
    public static final OfInt LAYOUT$chromaFilter = (OfInt) LAYOUT.select(PATH$chromaFilter);
    public static final OfInt LAYOUT$forceExplicitReconstruction = (OfInt) LAYOUT.select(PATH$forceExplicitReconstruction);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$format = LAYOUT$format.byteSize();
    public static final long SIZE$ycbcrModel = LAYOUT$ycbcrModel.byteSize();
    public static final long SIZE$ycbcrRange = LAYOUT$ycbcrRange.byteSize();
    public static final long SIZE$components = LAYOUT$components.byteSize();
    public static final long SIZE$xChromaOffset = LAYOUT$xChromaOffset.byteSize();
    public static final long SIZE$yChromaOffset = LAYOUT$yChromaOffset.byteSize();
    public static final long SIZE$chromaFilter = LAYOUT$chromaFilter.byteSize();
    public static final long SIZE$forceExplicitReconstruction = LAYOUT$forceExplicitReconstruction.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$format = LAYOUT.byteOffset(PATH$format);
    public static final long OFFSET$ycbcrModel = LAYOUT.byteOffset(PATH$ycbcrModel);
    public static final long OFFSET$ycbcrRange = LAYOUT.byteOffset(PATH$ycbcrRange);
    public static final long OFFSET$components = LAYOUT.byteOffset(PATH$components);
    public static final long OFFSET$xChromaOffset = LAYOUT.byteOffset(PATH$xChromaOffset);
    public static final long OFFSET$yChromaOffset = LAYOUT.byteOffset(PATH$yChromaOffset);
    public static final long OFFSET$chromaFilter = LAYOUT.byteOffset(PATH$chromaFilter);
    public static final long OFFSET$forceExplicitReconstruction = LAYOUT.byteOffset(PATH$forceExplicitReconstruction);
}
