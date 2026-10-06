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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineFragmentShadingRateEnumStateCreateInfoNV.html"><code>VkPipelineFragmentShadingRateEnumStateCreateInfoNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPipelineFragmentShadingRateEnumStateCreateInfoNV {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkFragmentShadingRateTypeNV shadingRateType; // @link substring="VkFragmentShadingRateTypeNV" target="VkFragmentShadingRateTypeNV" @link substring="shadingRateType" target="#shadingRateType"
///     VkFragmentShadingRateNV shadingRate; // @link substring="VkFragmentShadingRateNV" target="VkFragmentShadingRateNV" @link substring="shadingRate" target="#shadingRate"
///     VkFragmentShadingRateCombinerOpKHR[2] combinerOps; // @link substring="VkFragmentShadingRateCombinerOpKHR" target="VkFragmentShadingRateCombinerOpKHR" @link substring="combinerOps" target="#combinerOps"
/// } VkPipelineFragmentShadingRateEnumStateCreateInfoNV;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PIPELINE_FRAGMENT_SHADING_RATE_ENUM_STATE_CREATE_INFO_NV`
///
/// The {@code allocate} ({@link VkPipelineFragmentShadingRateEnumStateCreateInfoNV#allocate(Arena)}, {@link VkPipelineFragmentShadingRateEnumStateCreateInfoNV#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPipelineFragmentShadingRateEnumStateCreateInfoNV#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineFragmentShadingRateEnumStateCreateInfoNV.html"><code>VkPipelineFragmentShadingRateEnumStateCreateInfoNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPipelineFragmentShadingRateEnumStateCreateInfoNV(@NotNull MemorySegment segment) implements IVkPipelineFragmentShadingRateEnumStateCreateInfoNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineFragmentShadingRateEnumStateCreateInfoNV.html"><code>VkPipelineFragmentShadingRateEnumStateCreateInfoNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPipelineFragmentShadingRateEnumStateCreateInfoNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPipelineFragmentShadingRateEnumStateCreateInfoNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPipelineFragmentShadingRateEnumStateCreateInfoNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPipelineFragmentShadingRateEnumStateCreateInfoNV, Iterable<VkPipelineFragmentShadingRateEnumStateCreateInfoNV> {
        public long size() {
            return segment.byteSize() / VkPipelineFragmentShadingRateEnumStateCreateInfoNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPipelineFragmentShadingRateEnumStateCreateInfoNV at(long index) {
            return new VkPipelineFragmentShadingRateEnumStateCreateInfoNV(segment.asSlice(index * VkPipelineFragmentShadingRateEnumStateCreateInfoNV.BYTES, VkPipelineFragmentShadingRateEnumStateCreateInfoNV.BYTES));
        }

        public VkPipelineFragmentShadingRateEnumStateCreateInfoNV.Ptr at(long index, @NotNull Consumer<@NotNull VkPipelineFragmentShadingRateEnumStateCreateInfoNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPipelineFragmentShadingRateEnumStateCreateInfoNV value) {
            MemorySegment s = segment.asSlice(index * VkPipelineFragmentShadingRateEnumStateCreateInfoNV.BYTES, VkPipelineFragmentShadingRateEnumStateCreateInfoNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPipelineFragmentShadingRateEnumStateCreateInfoNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPipelineFragmentShadingRateEnumStateCreateInfoNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPipelineFragmentShadingRateEnumStateCreateInfoNV.BYTES,
                (end - start) * VkPipelineFragmentShadingRateEnumStateCreateInfoNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPipelineFragmentShadingRateEnumStateCreateInfoNV.BYTES));
        }

        public VkPipelineFragmentShadingRateEnumStateCreateInfoNV[] toArray() {
            VkPipelineFragmentShadingRateEnumStateCreateInfoNV[] ret = new VkPipelineFragmentShadingRateEnumStateCreateInfoNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPipelineFragmentShadingRateEnumStateCreateInfoNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPipelineFragmentShadingRateEnumStateCreateInfoNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPipelineFragmentShadingRateEnumStateCreateInfoNV.BYTES;
            }

            @Override
            public VkPipelineFragmentShadingRateEnumStateCreateInfoNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPipelineFragmentShadingRateEnumStateCreateInfoNV ret = new VkPipelineFragmentShadingRateEnumStateCreateInfoNV(segment.asSlice(0, VkPipelineFragmentShadingRateEnumStateCreateInfoNV.BYTES));
                segment = segment.asSlice(VkPipelineFragmentShadingRateEnumStateCreateInfoNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPipelineFragmentShadingRateEnumStateCreateInfoNV allocate(Arena arena) {
        VkPipelineFragmentShadingRateEnumStateCreateInfoNV ret = new VkPipelineFragmentShadingRateEnumStateCreateInfoNV(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PIPELINE_FRAGMENT_SHADING_RATE_ENUM_STATE_CREATE_INFO_NV);
        return ret;
    }

    public static VkPipelineFragmentShadingRateEnumStateCreateInfoNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPipelineFragmentShadingRateEnumStateCreateInfoNV.Ptr ret = new VkPipelineFragmentShadingRateEnumStateCreateInfoNV.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PIPELINE_FRAGMENT_SHADING_RATE_ENUM_STATE_CREATE_INFO_NV);
        }
        return ret;
    }

    public static VkPipelineFragmentShadingRateEnumStateCreateInfoNV clone(Arena arena, VkPipelineFragmentShadingRateEnumStateCreateInfoNV src) {
        VkPipelineFragmentShadingRateEnumStateCreateInfoNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PIPELINE_FRAGMENT_SHADING_RATE_ENUM_STATE_CREATE_INFO_NV);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPipelineFragmentShadingRateEnumStateCreateInfoNV sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPipelineFragmentShadingRateEnumStateCreateInfoNV pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPipelineFragmentShadingRateEnumStateCreateInfoNV pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @EnumType(VkFragmentShadingRateTypeNV.class) int shadingRateType() {
        return segment.get(LAYOUT$shadingRateType, OFFSET$shadingRateType);
    }

    public VkPipelineFragmentShadingRateEnumStateCreateInfoNV shadingRateType(@EnumType(VkFragmentShadingRateTypeNV.class) int value) {
        segment.set(LAYOUT$shadingRateType, OFFSET$shadingRateType, value);
        return this;
    }

    public @EnumType(VkFragmentShadingRateNV.class) int shadingRate() {
        return segment.get(LAYOUT$shadingRate, OFFSET$shadingRate);
    }

    public VkPipelineFragmentShadingRateEnumStateCreateInfoNV shadingRate(@EnumType(VkFragmentShadingRateNV.class) int value) {
        segment.set(LAYOUT$shadingRate, OFFSET$shadingRate, value);
        return this;
    }

    public @EnumType(VkFragmentShadingRateCombinerOpKHR.class) IntPtr combinerOps() {
        return new IntPtr(combinerOpsRaw());
    }

    public VkPipelineFragmentShadingRateEnumStateCreateInfoNV combinerOps(@NotNull Consumer<IntPtr> consumer) {
        @EnumType(VkFragmentShadingRateCombinerOpKHR.class) IntPtr ptr = combinerOps();
        consumer.accept(ptr);
        return this;
    }

    public VkPipelineFragmentShadingRateEnumStateCreateInfoNV combinerOps(@EnumType(VkFragmentShadingRateCombinerOpKHR.class) IntPtr value) {
        MemorySegment s = combinerOpsRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment combinerOpsRaw() {
        return segment.asSlice(OFFSET$combinerOps, SIZE$combinerOps);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("shadingRateType"),
        ValueLayout.JAVA_INT.withName("shadingRate"),
        MemoryLayout.sequenceLayout(2, ValueLayout.JAVA_INT).withName("combinerOps")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$shadingRateType = PathElement.groupElement("shadingRateType");
    public static final PathElement PATH$shadingRate = PathElement.groupElement("shadingRate");
    public static final PathElement PATH$combinerOps = PathElement.groupElement("combinerOps");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$shadingRateType = (OfInt) LAYOUT.select(PATH$shadingRateType);
    public static final OfInt LAYOUT$shadingRate = (OfInt) LAYOUT.select(PATH$shadingRate);
    public static final SequenceLayout LAYOUT$combinerOps = (SequenceLayout) LAYOUT.select(PATH$combinerOps);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$shadingRateType = LAYOUT$shadingRateType.byteSize();
    public static final long SIZE$shadingRate = LAYOUT$shadingRate.byteSize();
    public static final long SIZE$combinerOps = LAYOUT$combinerOps.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$shadingRateType = LAYOUT.byteOffset(PATH$shadingRateType);
    public static final long OFFSET$shadingRate = LAYOUT.byteOffset(PATH$shadingRate);
    public static final long OFFSET$combinerOps = LAYOUT.byteOffset(PATH$combinerOps);
}
