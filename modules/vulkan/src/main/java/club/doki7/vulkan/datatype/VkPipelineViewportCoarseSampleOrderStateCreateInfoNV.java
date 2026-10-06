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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineViewportCoarseSampleOrderStateCreateInfoNV.html"><code>VkPipelineViewportCoarseSampleOrderStateCreateInfoNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPipelineViewportCoarseSampleOrderStateCreateInfoNV {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkCoarseSampleOrderTypeNV sampleOrderType; // @link substring="VkCoarseSampleOrderTypeNV" target="VkCoarseSampleOrderTypeNV" @link substring="sampleOrderType" target="#sampleOrderType"
///     uint32_t customSampleOrderCount; // optional // @link substring="customSampleOrderCount" target="#customSampleOrderCount"
///     VkCoarseSampleOrderCustomNV const* pCustomSampleOrders; // optional // @link substring="VkCoarseSampleOrderCustomNV" target="VkCoarseSampleOrderCustomNV" @link substring="pCustomSampleOrders" target="#pCustomSampleOrders"
/// } VkPipelineViewportCoarseSampleOrderStateCreateInfoNV;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PIPELINE_VIEWPORT_COARSE_SAMPLE_ORDER_STATE_CREATE_INFO_NV`
///
/// The {@code allocate} ({@link VkPipelineViewportCoarseSampleOrderStateCreateInfoNV#allocate(Arena)}, {@link VkPipelineViewportCoarseSampleOrderStateCreateInfoNV#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPipelineViewportCoarseSampleOrderStateCreateInfoNV#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineViewportCoarseSampleOrderStateCreateInfoNV.html"><code>VkPipelineViewportCoarseSampleOrderStateCreateInfoNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPipelineViewportCoarseSampleOrderStateCreateInfoNV(@NotNull MemorySegment segment) implements IVkPipelineViewportCoarseSampleOrderStateCreateInfoNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineViewportCoarseSampleOrderStateCreateInfoNV.html"><code>VkPipelineViewportCoarseSampleOrderStateCreateInfoNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPipelineViewportCoarseSampleOrderStateCreateInfoNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPipelineViewportCoarseSampleOrderStateCreateInfoNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPipelineViewportCoarseSampleOrderStateCreateInfoNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPipelineViewportCoarseSampleOrderStateCreateInfoNV, Iterable<VkPipelineViewportCoarseSampleOrderStateCreateInfoNV> {
        public long size() {
            return segment.byteSize() / VkPipelineViewportCoarseSampleOrderStateCreateInfoNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPipelineViewportCoarseSampleOrderStateCreateInfoNV at(long index) {
            return new VkPipelineViewportCoarseSampleOrderStateCreateInfoNV(segment.asSlice(index * VkPipelineViewportCoarseSampleOrderStateCreateInfoNV.BYTES, VkPipelineViewportCoarseSampleOrderStateCreateInfoNV.BYTES));
        }

        public VkPipelineViewportCoarseSampleOrderStateCreateInfoNV.Ptr at(long index, @NotNull Consumer<@NotNull VkPipelineViewportCoarseSampleOrderStateCreateInfoNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPipelineViewportCoarseSampleOrderStateCreateInfoNV value) {
            MemorySegment s = segment.asSlice(index * VkPipelineViewportCoarseSampleOrderStateCreateInfoNV.BYTES, VkPipelineViewportCoarseSampleOrderStateCreateInfoNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPipelineViewportCoarseSampleOrderStateCreateInfoNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPipelineViewportCoarseSampleOrderStateCreateInfoNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPipelineViewportCoarseSampleOrderStateCreateInfoNV.BYTES,
                (end - start) * VkPipelineViewportCoarseSampleOrderStateCreateInfoNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPipelineViewportCoarseSampleOrderStateCreateInfoNV.BYTES));
        }

        public VkPipelineViewportCoarseSampleOrderStateCreateInfoNV[] toArray() {
            VkPipelineViewportCoarseSampleOrderStateCreateInfoNV[] ret = new VkPipelineViewportCoarseSampleOrderStateCreateInfoNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPipelineViewportCoarseSampleOrderStateCreateInfoNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPipelineViewportCoarseSampleOrderStateCreateInfoNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPipelineViewportCoarseSampleOrderStateCreateInfoNV.BYTES;
            }

            @Override
            public VkPipelineViewportCoarseSampleOrderStateCreateInfoNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPipelineViewportCoarseSampleOrderStateCreateInfoNV ret = new VkPipelineViewportCoarseSampleOrderStateCreateInfoNV(segment.asSlice(0, VkPipelineViewportCoarseSampleOrderStateCreateInfoNV.BYTES));
                segment = segment.asSlice(VkPipelineViewportCoarseSampleOrderStateCreateInfoNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPipelineViewportCoarseSampleOrderStateCreateInfoNV allocate(Arena arena) {
        VkPipelineViewportCoarseSampleOrderStateCreateInfoNV ret = new VkPipelineViewportCoarseSampleOrderStateCreateInfoNV(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PIPELINE_VIEWPORT_COARSE_SAMPLE_ORDER_STATE_CREATE_INFO_NV);
        return ret;
    }

    public static VkPipelineViewportCoarseSampleOrderStateCreateInfoNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPipelineViewportCoarseSampleOrderStateCreateInfoNV.Ptr ret = new VkPipelineViewportCoarseSampleOrderStateCreateInfoNV.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PIPELINE_VIEWPORT_COARSE_SAMPLE_ORDER_STATE_CREATE_INFO_NV);
        }
        return ret;
    }

    public static VkPipelineViewportCoarseSampleOrderStateCreateInfoNV clone(Arena arena, VkPipelineViewportCoarseSampleOrderStateCreateInfoNV src) {
        VkPipelineViewportCoarseSampleOrderStateCreateInfoNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PIPELINE_VIEWPORT_COARSE_SAMPLE_ORDER_STATE_CREATE_INFO_NV);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPipelineViewportCoarseSampleOrderStateCreateInfoNV sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPipelineViewportCoarseSampleOrderStateCreateInfoNV pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPipelineViewportCoarseSampleOrderStateCreateInfoNV pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @EnumType(VkCoarseSampleOrderTypeNV.class) int sampleOrderType() {
        return segment.get(LAYOUT$sampleOrderType, OFFSET$sampleOrderType);
    }

    public VkPipelineViewportCoarseSampleOrderStateCreateInfoNV sampleOrderType(@EnumType(VkCoarseSampleOrderTypeNV.class) int value) {
        segment.set(LAYOUT$sampleOrderType, OFFSET$sampleOrderType, value);
        return this;
    }

    public @Unsigned int customSampleOrderCount() {
        return segment.get(LAYOUT$customSampleOrderCount, OFFSET$customSampleOrderCount);
    }

    public VkPipelineViewportCoarseSampleOrderStateCreateInfoNV customSampleOrderCount(@Unsigned int value) {
        segment.set(LAYOUT$customSampleOrderCount, OFFSET$customSampleOrderCount, value);
        return this;
    }

    public VkPipelineViewportCoarseSampleOrderStateCreateInfoNV pCustomSampleOrders(@Nullable IVkCoarseSampleOrderCustomNV value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pCustomSampleOrdersRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkCoarseSampleOrderCustomNV.Ptr pCustomSampleOrders(int assumedCount) {
        MemorySegment s = pCustomSampleOrdersRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkCoarseSampleOrderCustomNV.BYTES);
        return new VkCoarseSampleOrderCustomNV.Ptr(s);
    }

    public @Nullable VkCoarseSampleOrderCustomNV pCustomSampleOrders() {
        MemorySegment s = pCustomSampleOrdersRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkCoarseSampleOrderCustomNV(s);
    }

    public @Pointer(target=VkCoarseSampleOrderCustomNV.class) @NotNull MemorySegment pCustomSampleOrdersRaw() {
        return segment.get(LAYOUT$pCustomSampleOrders, OFFSET$pCustomSampleOrders);
    }

    public void pCustomSampleOrdersRaw(@Pointer(target=VkCoarseSampleOrderCustomNV.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pCustomSampleOrders, OFFSET$pCustomSampleOrders, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("sampleOrderType"),
        ValueLayout.JAVA_INT.withName("customSampleOrderCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkCoarseSampleOrderCustomNV.LAYOUT).withName("pCustomSampleOrders")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$sampleOrderType = PathElement.groupElement("sampleOrderType");
    public static final PathElement PATH$customSampleOrderCount = PathElement.groupElement("customSampleOrderCount");
    public static final PathElement PATH$pCustomSampleOrders = PathElement.groupElement("pCustomSampleOrders");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$sampleOrderType = (OfInt) LAYOUT.select(PATH$sampleOrderType);
    public static final OfInt LAYOUT$customSampleOrderCount = (OfInt) LAYOUT.select(PATH$customSampleOrderCount);
    public static final AddressLayout LAYOUT$pCustomSampleOrders = (AddressLayout) LAYOUT.select(PATH$pCustomSampleOrders);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$sampleOrderType = LAYOUT$sampleOrderType.byteSize();
    public static final long SIZE$customSampleOrderCount = LAYOUT$customSampleOrderCount.byteSize();
    public static final long SIZE$pCustomSampleOrders = LAYOUT$pCustomSampleOrders.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$sampleOrderType = LAYOUT.byteOffset(PATH$sampleOrderType);
    public static final long OFFSET$customSampleOrderCount = LAYOUT.byteOffset(PATH$customSampleOrderCount);
    public static final long OFFSET$pCustomSampleOrders = LAYOUT.byteOffset(PATH$pCustomSampleOrders);
}
