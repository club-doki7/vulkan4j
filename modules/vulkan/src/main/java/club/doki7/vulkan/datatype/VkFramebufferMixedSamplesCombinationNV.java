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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkFramebufferMixedSamplesCombinationNV.html"><code>VkFramebufferMixedSamplesCombinationNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkFramebufferMixedSamplesCombinationNV {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkCoverageReductionModeNV coverageReductionMode; // @link substring="VkCoverageReductionModeNV" target="VkCoverageReductionModeNV" @link substring="coverageReductionMode" target="#coverageReductionMode"
///     VkSampleCountFlags rasterizationSamples; // @link substring="VkSampleCountFlags" target="VkSampleCountFlags" @link substring="rasterizationSamples" target="#rasterizationSamples"
///     VkSampleCountFlags depthStencilSamples; // @link substring="VkSampleCountFlags" target="VkSampleCountFlags" @link substring="depthStencilSamples" target="#depthStencilSamples"
///     VkSampleCountFlags colorSamples; // @link substring="VkSampleCountFlags" target="VkSampleCountFlags" @link substring="colorSamples" target="#colorSamples"
/// } VkFramebufferMixedSamplesCombinationNV;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_FRAMEBUFFER_MIXED_SAMPLES_COMBINATION_NV`
///
/// The {@code allocate} ({@link VkFramebufferMixedSamplesCombinationNV#allocate(Arena)}, {@link VkFramebufferMixedSamplesCombinationNV#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkFramebufferMixedSamplesCombinationNV#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkFramebufferMixedSamplesCombinationNV.html"><code>VkFramebufferMixedSamplesCombinationNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkFramebufferMixedSamplesCombinationNV(@NotNull MemorySegment segment) implements IVkFramebufferMixedSamplesCombinationNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkFramebufferMixedSamplesCombinationNV.html"><code>VkFramebufferMixedSamplesCombinationNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkFramebufferMixedSamplesCombinationNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkFramebufferMixedSamplesCombinationNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkFramebufferMixedSamplesCombinationNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkFramebufferMixedSamplesCombinationNV, Iterable<VkFramebufferMixedSamplesCombinationNV> {
        public long size() {
            return segment.byteSize() / VkFramebufferMixedSamplesCombinationNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkFramebufferMixedSamplesCombinationNV at(long index) {
            return new VkFramebufferMixedSamplesCombinationNV(segment.asSlice(index * VkFramebufferMixedSamplesCombinationNV.BYTES, VkFramebufferMixedSamplesCombinationNV.BYTES));
        }

        public VkFramebufferMixedSamplesCombinationNV.Ptr at(long index, @NotNull Consumer<@NotNull VkFramebufferMixedSamplesCombinationNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkFramebufferMixedSamplesCombinationNV value) {
            MemorySegment s = segment.asSlice(index * VkFramebufferMixedSamplesCombinationNV.BYTES, VkFramebufferMixedSamplesCombinationNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkFramebufferMixedSamplesCombinationNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkFramebufferMixedSamplesCombinationNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkFramebufferMixedSamplesCombinationNV.BYTES,
                (end - start) * VkFramebufferMixedSamplesCombinationNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkFramebufferMixedSamplesCombinationNV.BYTES));
        }

        public VkFramebufferMixedSamplesCombinationNV[] toArray() {
            VkFramebufferMixedSamplesCombinationNV[] ret = new VkFramebufferMixedSamplesCombinationNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkFramebufferMixedSamplesCombinationNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkFramebufferMixedSamplesCombinationNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkFramebufferMixedSamplesCombinationNV.BYTES;
            }

            @Override
            public VkFramebufferMixedSamplesCombinationNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkFramebufferMixedSamplesCombinationNV ret = new VkFramebufferMixedSamplesCombinationNV(segment.asSlice(0, VkFramebufferMixedSamplesCombinationNV.BYTES));
                segment = segment.asSlice(VkFramebufferMixedSamplesCombinationNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkFramebufferMixedSamplesCombinationNV allocate(Arena arena) {
        VkFramebufferMixedSamplesCombinationNV ret = new VkFramebufferMixedSamplesCombinationNV(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.FRAMEBUFFER_MIXED_SAMPLES_COMBINATION_NV);
        return ret;
    }

    public static VkFramebufferMixedSamplesCombinationNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkFramebufferMixedSamplesCombinationNV.Ptr ret = new VkFramebufferMixedSamplesCombinationNV.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.FRAMEBUFFER_MIXED_SAMPLES_COMBINATION_NV);
        }
        return ret;
    }

    public static VkFramebufferMixedSamplesCombinationNV clone(Arena arena, VkFramebufferMixedSamplesCombinationNV src) {
        VkFramebufferMixedSamplesCombinationNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.FRAMEBUFFER_MIXED_SAMPLES_COMBINATION_NV);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkFramebufferMixedSamplesCombinationNV sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkFramebufferMixedSamplesCombinationNV pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkFramebufferMixedSamplesCombinationNV pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @EnumType(VkCoverageReductionModeNV.class) int coverageReductionMode() {
        return segment.get(LAYOUT$coverageReductionMode, OFFSET$coverageReductionMode);
    }

    public VkFramebufferMixedSamplesCombinationNV coverageReductionMode(@EnumType(VkCoverageReductionModeNV.class) int value) {
        segment.set(LAYOUT$coverageReductionMode, OFFSET$coverageReductionMode, value);
        return this;
    }

    public @Bitmask(VkSampleCountFlags.class) int rasterizationSamples() {
        return segment.get(LAYOUT$rasterizationSamples, OFFSET$rasterizationSamples);
    }

    public VkFramebufferMixedSamplesCombinationNV rasterizationSamples(@Bitmask(VkSampleCountFlags.class) int value) {
        segment.set(LAYOUT$rasterizationSamples, OFFSET$rasterizationSamples, value);
        return this;
    }

    public @Bitmask(VkSampleCountFlags.class) int depthStencilSamples() {
        return segment.get(LAYOUT$depthStencilSamples, OFFSET$depthStencilSamples);
    }

    public VkFramebufferMixedSamplesCombinationNV depthStencilSamples(@Bitmask(VkSampleCountFlags.class) int value) {
        segment.set(LAYOUT$depthStencilSamples, OFFSET$depthStencilSamples, value);
        return this;
    }

    public @Bitmask(VkSampleCountFlags.class) int colorSamples() {
        return segment.get(LAYOUT$colorSamples, OFFSET$colorSamples);
    }

    public VkFramebufferMixedSamplesCombinationNV colorSamples(@Bitmask(VkSampleCountFlags.class) int value) {
        segment.set(LAYOUT$colorSamples, OFFSET$colorSamples, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("coverageReductionMode"),
        ValueLayout.JAVA_INT.withName("rasterizationSamples"),
        ValueLayout.JAVA_INT.withName("depthStencilSamples"),
        ValueLayout.JAVA_INT.withName("colorSamples")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$coverageReductionMode = PathElement.groupElement("coverageReductionMode");
    public static final PathElement PATH$rasterizationSamples = PathElement.groupElement("rasterizationSamples");
    public static final PathElement PATH$depthStencilSamples = PathElement.groupElement("depthStencilSamples");
    public static final PathElement PATH$colorSamples = PathElement.groupElement("colorSamples");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$coverageReductionMode = (OfInt) LAYOUT.select(PATH$coverageReductionMode);
    public static final OfInt LAYOUT$rasterizationSamples = (OfInt) LAYOUT.select(PATH$rasterizationSamples);
    public static final OfInt LAYOUT$depthStencilSamples = (OfInt) LAYOUT.select(PATH$depthStencilSamples);
    public static final OfInt LAYOUT$colorSamples = (OfInt) LAYOUT.select(PATH$colorSamples);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$coverageReductionMode = LAYOUT$coverageReductionMode.byteSize();
    public static final long SIZE$rasterizationSamples = LAYOUT$rasterizationSamples.byteSize();
    public static final long SIZE$depthStencilSamples = LAYOUT$depthStencilSamples.byteSize();
    public static final long SIZE$colorSamples = LAYOUT$colorSamples.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$coverageReductionMode = LAYOUT.byteOffset(PATH$coverageReductionMode);
    public static final long OFFSET$rasterizationSamples = LAYOUT.byteOffset(PATH$rasterizationSamples);
    public static final long OFFSET$depthStencilSamples = LAYOUT.byteOffset(PATH$depthStencilSamples);
    public static final long OFFSET$colorSamples = LAYOUT.byteOffset(PATH$colorSamples);
}
