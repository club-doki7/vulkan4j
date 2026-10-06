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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineDiscardRectangleStateCreateInfoEXT.html"><code>VkPipelineDiscardRectangleStateCreateInfoEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPipelineDiscardRectangleStateCreateInfoEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkPipelineDiscardRectangleStateCreateFlagsEXT flags; // optional // @link substring="VkPipelineDiscardRectangleStateCreateFlagsEXT" target="VkPipelineDiscardRectangleStateCreateFlagsEXT" @link substring="flags" target="#flags"
///     VkDiscardRectangleModeEXT discardRectangleMode; // @link substring="VkDiscardRectangleModeEXT" target="VkDiscardRectangleModeEXT" @link substring="discardRectangleMode" target="#discardRectangleMode"
///     uint32_t discardRectangleCount; // optional // @link substring="discardRectangleCount" target="#discardRectangleCount"
///     VkRect2D const* pDiscardRectangles; // optional // @link substring="VkRect2D" target="VkRect2D" @link substring="pDiscardRectangles" target="#pDiscardRectangles"
/// } VkPipelineDiscardRectangleStateCreateInfoEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PIPELINE_DISCARD_RECTANGLE_STATE_CREATE_INFO_EXT`
///
/// The {@code allocate} ({@link VkPipelineDiscardRectangleStateCreateInfoEXT#allocate(Arena)}, {@link VkPipelineDiscardRectangleStateCreateInfoEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPipelineDiscardRectangleStateCreateInfoEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineDiscardRectangleStateCreateInfoEXT.html"><code>VkPipelineDiscardRectangleStateCreateInfoEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPipelineDiscardRectangleStateCreateInfoEXT(@NotNull MemorySegment segment) implements IVkPipelineDiscardRectangleStateCreateInfoEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineDiscardRectangleStateCreateInfoEXT.html"><code>VkPipelineDiscardRectangleStateCreateInfoEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPipelineDiscardRectangleStateCreateInfoEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPipelineDiscardRectangleStateCreateInfoEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPipelineDiscardRectangleStateCreateInfoEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPipelineDiscardRectangleStateCreateInfoEXT, Iterable<VkPipelineDiscardRectangleStateCreateInfoEXT> {
        public long size() {
            return segment.byteSize() / VkPipelineDiscardRectangleStateCreateInfoEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPipelineDiscardRectangleStateCreateInfoEXT at(long index) {
            return new VkPipelineDiscardRectangleStateCreateInfoEXT(segment.asSlice(index * VkPipelineDiscardRectangleStateCreateInfoEXT.BYTES, VkPipelineDiscardRectangleStateCreateInfoEXT.BYTES));
        }

        public VkPipelineDiscardRectangleStateCreateInfoEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkPipelineDiscardRectangleStateCreateInfoEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPipelineDiscardRectangleStateCreateInfoEXT value) {
            MemorySegment s = segment.asSlice(index * VkPipelineDiscardRectangleStateCreateInfoEXT.BYTES, VkPipelineDiscardRectangleStateCreateInfoEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPipelineDiscardRectangleStateCreateInfoEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPipelineDiscardRectangleStateCreateInfoEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPipelineDiscardRectangleStateCreateInfoEXT.BYTES,
                (end - start) * VkPipelineDiscardRectangleStateCreateInfoEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPipelineDiscardRectangleStateCreateInfoEXT.BYTES));
        }

        public VkPipelineDiscardRectangleStateCreateInfoEXT[] toArray() {
            VkPipelineDiscardRectangleStateCreateInfoEXT[] ret = new VkPipelineDiscardRectangleStateCreateInfoEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPipelineDiscardRectangleStateCreateInfoEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPipelineDiscardRectangleStateCreateInfoEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPipelineDiscardRectangleStateCreateInfoEXT.BYTES;
            }

            @Override
            public VkPipelineDiscardRectangleStateCreateInfoEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPipelineDiscardRectangleStateCreateInfoEXT ret = new VkPipelineDiscardRectangleStateCreateInfoEXT(segment.asSlice(0, VkPipelineDiscardRectangleStateCreateInfoEXT.BYTES));
                segment = segment.asSlice(VkPipelineDiscardRectangleStateCreateInfoEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPipelineDiscardRectangleStateCreateInfoEXT allocate(Arena arena) {
        VkPipelineDiscardRectangleStateCreateInfoEXT ret = new VkPipelineDiscardRectangleStateCreateInfoEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PIPELINE_DISCARD_RECTANGLE_STATE_CREATE_INFO_EXT);
        return ret;
    }

    public static VkPipelineDiscardRectangleStateCreateInfoEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPipelineDiscardRectangleStateCreateInfoEXT.Ptr ret = new VkPipelineDiscardRectangleStateCreateInfoEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PIPELINE_DISCARD_RECTANGLE_STATE_CREATE_INFO_EXT);
        }
        return ret;
    }

    public static VkPipelineDiscardRectangleStateCreateInfoEXT clone(Arena arena, VkPipelineDiscardRectangleStateCreateInfoEXT src) {
        VkPipelineDiscardRectangleStateCreateInfoEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PIPELINE_DISCARD_RECTANGLE_STATE_CREATE_INFO_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPipelineDiscardRectangleStateCreateInfoEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPipelineDiscardRectangleStateCreateInfoEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPipelineDiscardRectangleStateCreateInfoEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkPipelineDiscardRectangleStateCreateFlagsEXT.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkPipelineDiscardRectangleStateCreateInfoEXT flags(@Bitmask(VkPipelineDiscardRectangleStateCreateFlagsEXT.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @EnumType(VkDiscardRectangleModeEXT.class) int discardRectangleMode() {
        return segment.get(LAYOUT$discardRectangleMode, OFFSET$discardRectangleMode);
    }

    public VkPipelineDiscardRectangleStateCreateInfoEXT discardRectangleMode(@EnumType(VkDiscardRectangleModeEXT.class) int value) {
        segment.set(LAYOUT$discardRectangleMode, OFFSET$discardRectangleMode, value);
        return this;
    }

    public @Unsigned int discardRectangleCount() {
        return segment.get(LAYOUT$discardRectangleCount, OFFSET$discardRectangleCount);
    }

    public VkPipelineDiscardRectangleStateCreateInfoEXT discardRectangleCount(@Unsigned int value) {
        segment.set(LAYOUT$discardRectangleCount, OFFSET$discardRectangleCount, value);
        return this;
    }

    public VkPipelineDiscardRectangleStateCreateInfoEXT pDiscardRectangles(@Nullable IVkRect2D value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pDiscardRectanglesRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkRect2D.Ptr pDiscardRectangles(int assumedCount) {
        MemorySegment s = pDiscardRectanglesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkRect2D.BYTES);
        return new VkRect2D.Ptr(s);
    }

    public @Nullable VkRect2D pDiscardRectangles() {
        MemorySegment s = pDiscardRectanglesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkRect2D(s);
    }

    public @Pointer(target=VkRect2D.class) @NotNull MemorySegment pDiscardRectanglesRaw() {
        return segment.get(LAYOUT$pDiscardRectangles, OFFSET$pDiscardRectangles);
    }

    public void pDiscardRectanglesRaw(@Pointer(target=VkRect2D.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pDiscardRectangles, OFFSET$pDiscardRectangles, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("discardRectangleMode"),
        ValueLayout.JAVA_INT.withName("discardRectangleCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkRect2D.LAYOUT).withName("pDiscardRectangles")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$discardRectangleMode = PathElement.groupElement("discardRectangleMode");
    public static final PathElement PATH$discardRectangleCount = PathElement.groupElement("discardRectangleCount");
    public static final PathElement PATH$pDiscardRectangles = PathElement.groupElement("pDiscardRectangles");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$discardRectangleMode = (OfInt) LAYOUT.select(PATH$discardRectangleMode);
    public static final OfInt LAYOUT$discardRectangleCount = (OfInt) LAYOUT.select(PATH$discardRectangleCount);
    public static final AddressLayout LAYOUT$pDiscardRectangles = (AddressLayout) LAYOUT.select(PATH$pDiscardRectangles);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$discardRectangleMode = LAYOUT$discardRectangleMode.byteSize();
    public static final long SIZE$discardRectangleCount = LAYOUT$discardRectangleCount.byteSize();
    public static final long SIZE$pDiscardRectangles = LAYOUT$pDiscardRectangles.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$discardRectangleMode = LAYOUT.byteOffset(PATH$discardRectangleMode);
    public static final long OFFSET$discardRectangleCount = LAYOUT.byteOffset(PATH$discardRectangleCount);
    public static final long OFFSET$pDiscardRectangles = LAYOUT.byteOffset(PATH$pDiscardRectangles);
}
