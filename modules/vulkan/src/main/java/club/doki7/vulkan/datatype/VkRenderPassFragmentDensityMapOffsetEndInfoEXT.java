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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRenderPassFragmentDensityMapOffsetEndInfoEXT.html"><code>VkRenderPassFragmentDensityMapOffsetEndInfoEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkRenderPassFragmentDensityMapOffsetEndInfoEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t fragmentDensityOffsetCount; // optional // @link substring="fragmentDensityOffsetCount" target="#fragmentDensityOffsetCount"
///     VkOffset2D const* pFragmentDensityOffsets; // optional // @link substring="VkOffset2D" target="VkOffset2D" @link substring="pFragmentDensityOffsets" target="#pFragmentDensityOffsets"
/// } VkRenderPassFragmentDensityMapOffsetEndInfoEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_RENDER_PASS_FRAGMENT_DENSITY_MAP_OFFSET_END_INFO_EXT`
///
/// The {@code allocate} ({@link VkRenderPassFragmentDensityMapOffsetEndInfoEXT#allocate(Arena)}, {@link VkRenderPassFragmentDensityMapOffsetEndInfoEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkRenderPassFragmentDensityMapOffsetEndInfoEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRenderPassFragmentDensityMapOffsetEndInfoEXT.html"><code>VkRenderPassFragmentDensityMapOffsetEndInfoEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkRenderPassFragmentDensityMapOffsetEndInfoEXT(@NotNull MemorySegment segment) implements IVkRenderPassFragmentDensityMapOffsetEndInfoEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRenderPassFragmentDensityMapOffsetEndInfoEXT.html"><code>VkRenderPassFragmentDensityMapOffsetEndInfoEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkRenderPassFragmentDensityMapOffsetEndInfoEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkRenderPassFragmentDensityMapOffsetEndInfoEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkRenderPassFragmentDensityMapOffsetEndInfoEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkRenderPassFragmentDensityMapOffsetEndInfoEXT, Iterable<VkRenderPassFragmentDensityMapOffsetEndInfoEXT> {
        public long size() {
            return segment.byteSize() / VkRenderPassFragmentDensityMapOffsetEndInfoEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkRenderPassFragmentDensityMapOffsetEndInfoEXT at(long index) {
            return new VkRenderPassFragmentDensityMapOffsetEndInfoEXT(segment.asSlice(index * VkRenderPassFragmentDensityMapOffsetEndInfoEXT.BYTES, VkRenderPassFragmentDensityMapOffsetEndInfoEXT.BYTES));
        }

        public VkRenderPassFragmentDensityMapOffsetEndInfoEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkRenderPassFragmentDensityMapOffsetEndInfoEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkRenderPassFragmentDensityMapOffsetEndInfoEXT value) {
            MemorySegment s = segment.asSlice(index * VkRenderPassFragmentDensityMapOffsetEndInfoEXT.BYTES, VkRenderPassFragmentDensityMapOffsetEndInfoEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkRenderPassFragmentDensityMapOffsetEndInfoEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkRenderPassFragmentDensityMapOffsetEndInfoEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkRenderPassFragmentDensityMapOffsetEndInfoEXT.BYTES,
                (end - start) * VkRenderPassFragmentDensityMapOffsetEndInfoEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkRenderPassFragmentDensityMapOffsetEndInfoEXT.BYTES));
        }

        public VkRenderPassFragmentDensityMapOffsetEndInfoEXT[] toArray() {
            VkRenderPassFragmentDensityMapOffsetEndInfoEXT[] ret = new VkRenderPassFragmentDensityMapOffsetEndInfoEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkRenderPassFragmentDensityMapOffsetEndInfoEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkRenderPassFragmentDensityMapOffsetEndInfoEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkRenderPassFragmentDensityMapOffsetEndInfoEXT.BYTES;
            }

            @Override
            public VkRenderPassFragmentDensityMapOffsetEndInfoEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkRenderPassFragmentDensityMapOffsetEndInfoEXT ret = new VkRenderPassFragmentDensityMapOffsetEndInfoEXT(segment.asSlice(0, VkRenderPassFragmentDensityMapOffsetEndInfoEXT.BYTES));
                segment = segment.asSlice(VkRenderPassFragmentDensityMapOffsetEndInfoEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkRenderPassFragmentDensityMapOffsetEndInfoEXT allocate(Arena arena) {
        VkRenderPassFragmentDensityMapOffsetEndInfoEXT ret = new VkRenderPassFragmentDensityMapOffsetEndInfoEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.RENDER_PASS_FRAGMENT_DENSITY_MAP_OFFSET_END_INFO_EXT);
        return ret;
    }

    public static VkRenderPassFragmentDensityMapOffsetEndInfoEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkRenderPassFragmentDensityMapOffsetEndInfoEXT.Ptr ret = new VkRenderPassFragmentDensityMapOffsetEndInfoEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.RENDER_PASS_FRAGMENT_DENSITY_MAP_OFFSET_END_INFO_EXT);
        }
        return ret;
    }

    public static VkRenderPassFragmentDensityMapOffsetEndInfoEXT clone(Arena arena, VkRenderPassFragmentDensityMapOffsetEndInfoEXT src) {
        VkRenderPassFragmentDensityMapOffsetEndInfoEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.RENDER_PASS_FRAGMENT_DENSITY_MAP_OFFSET_END_INFO_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkRenderPassFragmentDensityMapOffsetEndInfoEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkRenderPassFragmentDensityMapOffsetEndInfoEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkRenderPassFragmentDensityMapOffsetEndInfoEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int fragmentDensityOffsetCount() {
        return segment.get(LAYOUT$fragmentDensityOffsetCount, OFFSET$fragmentDensityOffsetCount);
    }

    public VkRenderPassFragmentDensityMapOffsetEndInfoEXT fragmentDensityOffsetCount(@Unsigned int value) {
        segment.set(LAYOUT$fragmentDensityOffsetCount, OFFSET$fragmentDensityOffsetCount, value);
        return this;
    }

    public VkRenderPassFragmentDensityMapOffsetEndInfoEXT pFragmentDensityOffsets(@Nullable IVkOffset2D value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pFragmentDensityOffsetsRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkOffset2D.Ptr pFragmentDensityOffsets(int assumedCount) {
        MemorySegment s = pFragmentDensityOffsetsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkOffset2D.BYTES);
        return new VkOffset2D.Ptr(s);
    }

    public @Nullable VkOffset2D pFragmentDensityOffsets() {
        MemorySegment s = pFragmentDensityOffsetsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkOffset2D(s);
    }

    public @Pointer(target=VkOffset2D.class) @NotNull MemorySegment pFragmentDensityOffsetsRaw() {
        return segment.get(LAYOUT$pFragmentDensityOffsets, OFFSET$pFragmentDensityOffsets);
    }

    public void pFragmentDensityOffsetsRaw(@Pointer(target=VkOffset2D.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pFragmentDensityOffsets, OFFSET$pFragmentDensityOffsets, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("fragmentDensityOffsetCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkOffset2D.LAYOUT).withName("pFragmentDensityOffsets")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$fragmentDensityOffsetCount = PathElement.groupElement("fragmentDensityOffsetCount");
    public static final PathElement PATH$pFragmentDensityOffsets = PathElement.groupElement("pFragmentDensityOffsets");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$fragmentDensityOffsetCount = (OfInt) LAYOUT.select(PATH$fragmentDensityOffsetCount);
    public static final AddressLayout LAYOUT$pFragmentDensityOffsets = (AddressLayout) LAYOUT.select(PATH$pFragmentDensityOffsets);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$fragmentDensityOffsetCount = LAYOUT$fragmentDensityOffsetCount.byteSize();
    public static final long SIZE$pFragmentDensityOffsets = LAYOUT$pFragmentDensityOffsets.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$fragmentDensityOffsetCount = LAYOUT.byteOffset(PATH$fragmentDensityOffsetCount);
    public static final long OFFSET$pFragmentDensityOffsets = LAYOUT.byteOffset(PATH$pFragmentDensityOffsets);
}
