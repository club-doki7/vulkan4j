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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineViewportShadingRateImageStateCreateInfoNV.html"><code>VkPipelineViewportShadingRateImageStateCreateInfoNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPipelineViewportShadingRateImageStateCreateInfoNV {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 shadingRateImageEnable; // @link substring="shadingRateImageEnable" target="#shadingRateImageEnable"
///     uint32_t viewportCount; // optional // @link substring="viewportCount" target="#viewportCount"
///     VkShadingRatePaletteNV const* pShadingRatePalettes; // optional // @link substring="VkShadingRatePaletteNV" target="VkShadingRatePaletteNV" @link substring="pShadingRatePalettes" target="#pShadingRatePalettes"
/// } VkPipelineViewportShadingRateImageStateCreateInfoNV;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PIPELINE_VIEWPORT_SHADING_RATE_IMAGE_STATE_CREATE_INFO_NV`
///
/// The {@code allocate} ({@link VkPipelineViewportShadingRateImageStateCreateInfoNV#allocate(Arena)}, {@link VkPipelineViewportShadingRateImageStateCreateInfoNV#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPipelineViewportShadingRateImageStateCreateInfoNV#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineViewportShadingRateImageStateCreateInfoNV.html"><code>VkPipelineViewportShadingRateImageStateCreateInfoNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPipelineViewportShadingRateImageStateCreateInfoNV(@NotNull MemorySegment segment) implements IVkPipelineViewportShadingRateImageStateCreateInfoNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineViewportShadingRateImageStateCreateInfoNV.html"><code>VkPipelineViewportShadingRateImageStateCreateInfoNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPipelineViewportShadingRateImageStateCreateInfoNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPipelineViewportShadingRateImageStateCreateInfoNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPipelineViewportShadingRateImageStateCreateInfoNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPipelineViewportShadingRateImageStateCreateInfoNV, Iterable<VkPipelineViewportShadingRateImageStateCreateInfoNV> {
        public long size() {
            return segment.byteSize() / VkPipelineViewportShadingRateImageStateCreateInfoNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPipelineViewportShadingRateImageStateCreateInfoNV at(long index) {
            return new VkPipelineViewportShadingRateImageStateCreateInfoNV(segment.asSlice(index * VkPipelineViewportShadingRateImageStateCreateInfoNV.BYTES, VkPipelineViewportShadingRateImageStateCreateInfoNV.BYTES));
        }

        public VkPipelineViewportShadingRateImageStateCreateInfoNV.Ptr at(long index, @NotNull Consumer<@NotNull VkPipelineViewportShadingRateImageStateCreateInfoNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPipelineViewportShadingRateImageStateCreateInfoNV value) {
            MemorySegment s = segment.asSlice(index * VkPipelineViewportShadingRateImageStateCreateInfoNV.BYTES, VkPipelineViewportShadingRateImageStateCreateInfoNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPipelineViewportShadingRateImageStateCreateInfoNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPipelineViewportShadingRateImageStateCreateInfoNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPipelineViewportShadingRateImageStateCreateInfoNV.BYTES,
                (end - start) * VkPipelineViewportShadingRateImageStateCreateInfoNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPipelineViewportShadingRateImageStateCreateInfoNV.BYTES));
        }

        public VkPipelineViewportShadingRateImageStateCreateInfoNV[] toArray() {
            VkPipelineViewportShadingRateImageStateCreateInfoNV[] ret = new VkPipelineViewportShadingRateImageStateCreateInfoNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPipelineViewportShadingRateImageStateCreateInfoNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPipelineViewportShadingRateImageStateCreateInfoNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPipelineViewportShadingRateImageStateCreateInfoNV.BYTES;
            }

            @Override
            public VkPipelineViewportShadingRateImageStateCreateInfoNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPipelineViewportShadingRateImageStateCreateInfoNV ret = new VkPipelineViewportShadingRateImageStateCreateInfoNV(segment.asSlice(0, VkPipelineViewportShadingRateImageStateCreateInfoNV.BYTES));
                segment = segment.asSlice(VkPipelineViewportShadingRateImageStateCreateInfoNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPipelineViewportShadingRateImageStateCreateInfoNV allocate(Arena arena) {
        VkPipelineViewportShadingRateImageStateCreateInfoNV ret = new VkPipelineViewportShadingRateImageStateCreateInfoNV(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PIPELINE_VIEWPORT_SHADING_RATE_IMAGE_STATE_CREATE_INFO_NV);
        return ret;
    }

    public static VkPipelineViewportShadingRateImageStateCreateInfoNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPipelineViewportShadingRateImageStateCreateInfoNV.Ptr ret = new VkPipelineViewportShadingRateImageStateCreateInfoNV.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PIPELINE_VIEWPORT_SHADING_RATE_IMAGE_STATE_CREATE_INFO_NV);
        }
        return ret;
    }

    public static VkPipelineViewportShadingRateImageStateCreateInfoNV clone(Arena arena, VkPipelineViewportShadingRateImageStateCreateInfoNV src) {
        VkPipelineViewportShadingRateImageStateCreateInfoNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PIPELINE_VIEWPORT_SHADING_RATE_IMAGE_STATE_CREATE_INFO_NV);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPipelineViewportShadingRateImageStateCreateInfoNV sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPipelineViewportShadingRateImageStateCreateInfoNV pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPipelineViewportShadingRateImageStateCreateInfoNV pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shadingRateImageEnable() {
        return segment.get(LAYOUT$shadingRateImageEnable, OFFSET$shadingRateImageEnable);
    }

    public VkPipelineViewportShadingRateImageStateCreateInfoNV shadingRateImageEnable(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shadingRateImageEnable, OFFSET$shadingRateImageEnable, value);
        return this;
    }

    public @Unsigned int viewportCount() {
        return segment.get(LAYOUT$viewportCount, OFFSET$viewportCount);
    }

    public VkPipelineViewportShadingRateImageStateCreateInfoNV viewportCount(@Unsigned int value) {
        segment.set(LAYOUT$viewportCount, OFFSET$viewportCount, value);
        return this;
    }

    public VkPipelineViewportShadingRateImageStateCreateInfoNV pShadingRatePalettes(@Nullable IVkShadingRatePaletteNV value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pShadingRatePalettesRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkShadingRatePaletteNV.Ptr pShadingRatePalettes(int assumedCount) {
        MemorySegment s = pShadingRatePalettesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkShadingRatePaletteNV.BYTES);
        return new VkShadingRatePaletteNV.Ptr(s);
    }

    public @Nullable VkShadingRatePaletteNV pShadingRatePalettes() {
        MemorySegment s = pShadingRatePalettesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkShadingRatePaletteNV(s);
    }

    public @Pointer(target=VkShadingRatePaletteNV.class) @NotNull MemorySegment pShadingRatePalettesRaw() {
        return segment.get(LAYOUT$pShadingRatePalettes, OFFSET$pShadingRatePalettes);
    }

    public void pShadingRatePalettesRaw(@Pointer(target=VkShadingRatePaletteNV.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pShadingRatePalettes, OFFSET$pShadingRatePalettes, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("shadingRateImageEnable"),
        ValueLayout.JAVA_INT.withName("viewportCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkShadingRatePaletteNV.LAYOUT).withName("pShadingRatePalettes")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$shadingRateImageEnable = PathElement.groupElement("shadingRateImageEnable");
    public static final PathElement PATH$viewportCount = PathElement.groupElement("viewportCount");
    public static final PathElement PATH$pShadingRatePalettes = PathElement.groupElement("pShadingRatePalettes");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$shadingRateImageEnable = (OfInt) LAYOUT.select(PATH$shadingRateImageEnable);
    public static final OfInt LAYOUT$viewportCount = (OfInt) LAYOUT.select(PATH$viewportCount);
    public static final AddressLayout LAYOUT$pShadingRatePalettes = (AddressLayout) LAYOUT.select(PATH$pShadingRatePalettes);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$shadingRateImageEnable = LAYOUT$shadingRateImageEnable.byteSize();
    public static final long SIZE$viewportCount = LAYOUT$viewportCount.byteSize();
    public static final long SIZE$pShadingRatePalettes = LAYOUT$pShadingRatePalettes.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$shadingRateImageEnable = LAYOUT.byteOffset(PATH$shadingRateImageEnable);
    public static final long OFFSET$viewportCount = LAYOUT.byteOffset(PATH$viewportCount);
    public static final long OFFSET$pShadingRatePalettes = LAYOUT.byteOffset(PATH$pShadingRatePalettes);
}
