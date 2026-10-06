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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineViewportDepthClampControlCreateInfoEXT.html"><code>VkPipelineViewportDepthClampControlCreateInfoEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPipelineViewportDepthClampControlCreateInfoEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkDepthClampModeEXT depthClampMode; // @link substring="VkDepthClampModeEXT" target="VkDepthClampModeEXT" @link substring="depthClampMode" target="#depthClampMode"
///     VkDepthClampRangeEXT const* pDepthClampRange; // optional // @link substring="VkDepthClampRangeEXT" target="VkDepthClampRangeEXT" @link substring="pDepthClampRange" target="#pDepthClampRange"
/// } VkPipelineViewportDepthClampControlCreateInfoEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PIPELINE_VIEWPORT_DEPTH_CLAMP_CONTROL_CREATE_INFO_EXT`
///
/// The {@code allocate} ({@link VkPipelineViewportDepthClampControlCreateInfoEXT#allocate(Arena)}, {@link VkPipelineViewportDepthClampControlCreateInfoEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPipelineViewportDepthClampControlCreateInfoEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineViewportDepthClampControlCreateInfoEXT.html"><code>VkPipelineViewportDepthClampControlCreateInfoEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPipelineViewportDepthClampControlCreateInfoEXT(@NotNull MemorySegment segment) implements IVkPipelineViewportDepthClampControlCreateInfoEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineViewportDepthClampControlCreateInfoEXT.html"><code>VkPipelineViewportDepthClampControlCreateInfoEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPipelineViewportDepthClampControlCreateInfoEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPipelineViewportDepthClampControlCreateInfoEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPipelineViewportDepthClampControlCreateInfoEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPipelineViewportDepthClampControlCreateInfoEXT, Iterable<VkPipelineViewportDepthClampControlCreateInfoEXT> {
        public long size() {
            return segment.byteSize() / VkPipelineViewportDepthClampControlCreateInfoEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPipelineViewportDepthClampControlCreateInfoEXT at(long index) {
            return new VkPipelineViewportDepthClampControlCreateInfoEXT(segment.asSlice(index * VkPipelineViewportDepthClampControlCreateInfoEXT.BYTES, VkPipelineViewportDepthClampControlCreateInfoEXT.BYTES));
        }

        public VkPipelineViewportDepthClampControlCreateInfoEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkPipelineViewportDepthClampControlCreateInfoEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPipelineViewportDepthClampControlCreateInfoEXT value) {
            MemorySegment s = segment.asSlice(index * VkPipelineViewportDepthClampControlCreateInfoEXT.BYTES, VkPipelineViewportDepthClampControlCreateInfoEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPipelineViewportDepthClampControlCreateInfoEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPipelineViewportDepthClampControlCreateInfoEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPipelineViewportDepthClampControlCreateInfoEXT.BYTES,
                (end - start) * VkPipelineViewportDepthClampControlCreateInfoEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPipelineViewportDepthClampControlCreateInfoEXT.BYTES));
        }

        public VkPipelineViewportDepthClampControlCreateInfoEXT[] toArray() {
            VkPipelineViewportDepthClampControlCreateInfoEXT[] ret = new VkPipelineViewportDepthClampControlCreateInfoEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPipelineViewportDepthClampControlCreateInfoEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPipelineViewportDepthClampControlCreateInfoEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPipelineViewportDepthClampControlCreateInfoEXT.BYTES;
            }

            @Override
            public VkPipelineViewportDepthClampControlCreateInfoEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPipelineViewportDepthClampControlCreateInfoEXT ret = new VkPipelineViewportDepthClampControlCreateInfoEXT(segment.asSlice(0, VkPipelineViewportDepthClampControlCreateInfoEXT.BYTES));
                segment = segment.asSlice(VkPipelineViewportDepthClampControlCreateInfoEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPipelineViewportDepthClampControlCreateInfoEXT allocate(Arena arena) {
        VkPipelineViewportDepthClampControlCreateInfoEXT ret = new VkPipelineViewportDepthClampControlCreateInfoEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PIPELINE_VIEWPORT_DEPTH_CLAMP_CONTROL_CREATE_INFO_EXT);
        return ret;
    }

    public static VkPipelineViewportDepthClampControlCreateInfoEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPipelineViewportDepthClampControlCreateInfoEXT.Ptr ret = new VkPipelineViewportDepthClampControlCreateInfoEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PIPELINE_VIEWPORT_DEPTH_CLAMP_CONTROL_CREATE_INFO_EXT);
        }
        return ret;
    }

    public static VkPipelineViewportDepthClampControlCreateInfoEXT clone(Arena arena, VkPipelineViewportDepthClampControlCreateInfoEXT src) {
        VkPipelineViewportDepthClampControlCreateInfoEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PIPELINE_VIEWPORT_DEPTH_CLAMP_CONTROL_CREATE_INFO_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPipelineViewportDepthClampControlCreateInfoEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPipelineViewportDepthClampControlCreateInfoEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPipelineViewportDepthClampControlCreateInfoEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @EnumType(VkDepthClampModeEXT.class) int depthClampMode() {
        return segment.get(LAYOUT$depthClampMode, OFFSET$depthClampMode);
    }

    public VkPipelineViewportDepthClampControlCreateInfoEXT depthClampMode(@EnumType(VkDepthClampModeEXT.class) int value) {
        segment.set(LAYOUT$depthClampMode, OFFSET$depthClampMode, value);
        return this;
    }

    public VkPipelineViewportDepthClampControlCreateInfoEXT pDepthClampRange(@Nullable IVkDepthClampRangeEXT value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pDepthClampRangeRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkDepthClampRangeEXT.Ptr pDepthClampRange(int assumedCount) {
        MemorySegment s = pDepthClampRangeRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkDepthClampRangeEXT.BYTES);
        return new VkDepthClampRangeEXT.Ptr(s);
    }

    public @Nullable VkDepthClampRangeEXT pDepthClampRange() {
        MemorySegment s = pDepthClampRangeRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkDepthClampRangeEXT(s);
    }

    public @Pointer(target=VkDepthClampRangeEXT.class) @NotNull MemorySegment pDepthClampRangeRaw() {
        return segment.get(LAYOUT$pDepthClampRange, OFFSET$pDepthClampRange);
    }

    public void pDepthClampRangeRaw(@Pointer(target=VkDepthClampRangeEXT.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pDepthClampRange, OFFSET$pDepthClampRange, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("depthClampMode"),
        ValueLayout.ADDRESS.withTargetLayout(VkDepthClampRangeEXT.LAYOUT).withName("pDepthClampRange")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$depthClampMode = PathElement.groupElement("depthClampMode");
    public static final PathElement PATH$pDepthClampRange = PathElement.groupElement("pDepthClampRange");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$depthClampMode = (OfInt) LAYOUT.select(PATH$depthClampMode);
    public static final AddressLayout LAYOUT$pDepthClampRange = (AddressLayout) LAYOUT.select(PATH$pDepthClampRange);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$depthClampMode = LAYOUT$depthClampMode.byteSize();
    public static final long SIZE$pDepthClampRange = LAYOUT$pDepthClampRange.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$depthClampMode = LAYOUT.byteOffset(PATH$depthClampMode);
    public static final long OFFSET$pDepthClampRange = LAYOUT.byteOffset(PATH$pDepthClampRange);
}
