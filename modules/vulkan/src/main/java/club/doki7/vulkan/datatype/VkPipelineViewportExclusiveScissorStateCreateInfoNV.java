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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineViewportExclusiveScissorStateCreateInfoNV.html"><code>VkPipelineViewportExclusiveScissorStateCreateInfoNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPipelineViewportExclusiveScissorStateCreateInfoNV {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t exclusiveScissorCount; // optional // @link substring="exclusiveScissorCount" target="#exclusiveScissorCount"
///     VkRect2D const* pExclusiveScissors; // optional // @link substring="VkRect2D" target="VkRect2D" @link substring="pExclusiveScissors" target="#pExclusiveScissors"
/// } VkPipelineViewportExclusiveScissorStateCreateInfoNV;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PIPELINE_VIEWPORT_EXCLUSIVE_SCISSOR_STATE_CREATE_INFO_NV`
///
/// The {@code allocate} ({@link VkPipelineViewportExclusiveScissorStateCreateInfoNV#allocate(Arena)}, {@link VkPipelineViewportExclusiveScissorStateCreateInfoNV#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPipelineViewportExclusiveScissorStateCreateInfoNV#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineViewportExclusiveScissorStateCreateInfoNV.html"><code>VkPipelineViewportExclusiveScissorStateCreateInfoNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPipelineViewportExclusiveScissorStateCreateInfoNV(@NotNull MemorySegment segment) implements IVkPipelineViewportExclusiveScissorStateCreateInfoNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineViewportExclusiveScissorStateCreateInfoNV.html"><code>VkPipelineViewportExclusiveScissorStateCreateInfoNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPipelineViewportExclusiveScissorStateCreateInfoNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPipelineViewportExclusiveScissorStateCreateInfoNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPipelineViewportExclusiveScissorStateCreateInfoNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPipelineViewportExclusiveScissorStateCreateInfoNV, Iterable<VkPipelineViewportExclusiveScissorStateCreateInfoNV> {
        public long size() {
            return segment.byteSize() / VkPipelineViewportExclusiveScissorStateCreateInfoNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPipelineViewportExclusiveScissorStateCreateInfoNV at(long index) {
            return new VkPipelineViewportExclusiveScissorStateCreateInfoNV(segment.asSlice(index * VkPipelineViewportExclusiveScissorStateCreateInfoNV.BYTES, VkPipelineViewportExclusiveScissorStateCreateInfoNV.BYTES));
        }

        public VkPipelineViewportExclusiveScissorStateCreateInfoNV.Ptr at(long index, @NotNull Consumer<@NotNull VkPipelineViewportExclusiveScissorStateCreateInfoNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPipelineViewportExclusiveScissorStateCreateInfoNV value) {
            MemorySegment s = segment.asSlice(index * VkPipelineViewportExclusiveScissorStateCreateInfoNV.BYTES, VkPipelineViewportExclusiveScissorStateCreateInfoNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPipelineViewportExclusiveScissorStateCreateInfoNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPipelineViewportExclusiveScissorStateCreateInfoNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPipelineViewportExclusiveScissorStateCreateInfoNV.BYTES,
                (end - start) * VkPipelineViewportExclusiveScissorStateCreateInfoNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPipelineViewportExclusiveScissorStateCreateInfoNV.BYTES));
        }

        public VkPipelineViewportExclusiveScissorStateCreateInfoNV[] toArray() {
            VkPipelineViewportExclusiveScissorStateCreateInfoNV[] ret = new VkPipelineViewportExclusiveScissorStateCreateInfoNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPipelineViewportExclusiveScissorStateCreateInfoNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPipelineViewportExclusiveScissorStateCreateInfoNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPipelineViewportExclusiveScissorStateCreateInfoNV.BYTES;
            }

            @Override
            public VkPipelineViewportExclusiveScissorStateCreateInfoNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPipelineViewportExclusiveScissorStateCreateInfoNV ret = new VkPipelineViewportExclusiveScissorStateCreateInfoNV(segment.asSlice(0, VkPipelineViewportExclusiveScissorStateCreateInfoNV.BYTES));
                segment = segment.asSlice(VkPipelineViewportExclusiveScissorStateCreateInfoNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPipelineViewportExclusiveScissorStateCreateInfoNV allocate(Arena arena) {
        VkPipelineViewportExclusiveScissorStateCreateInfoNV ret = new VkPipelineViewportExclusiveScissorStateCreateInfoNV(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PIPELINE_VIEWPORT_EXCLUSIVE_SCISSOR_STATE_CREATE_INFO_NV);
        return ret;
    }

    public static VkPipelineViewportExclusiveScissorStateCreateInfoNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPipelineViewportExclusiveScissorStateCreateInfoNV.Ptr ret = new VkPipelineViewportExclusiveScissorStateCreateInfoNV.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PIPELINE_VIEWPORT_EXCLUSIVE_SCISSOR_STATE_CREATE_INFO_NV);
        }
        return ret;
    }

    public static VkPipelineViewportExclusiveScissorStateCreateInfoNV clone(Arena arena, VkPipelineViewportExclusiveScissorStateCreateInfoNV src) {
        VkPipelineViewportExclusiveScissorStateCreateInfoNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PIPELINE_VIEWPORT_EXCLUSIVE_SCISSOR_STATE_CREATE_INFO_NV);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPipelineViewportExclusiveScissorStateCreateInfoNV sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPipelineViewportExclusiveScissorStateCreateInfoNV pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPipelineViewportExclusiveScissorStateCreateInfoNV pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int exclusiveScissorCount() {
        return segment.get(LAYOUT$exclusiveScissorCount, OFFSET$exclusiveScissorCount);
    }

    public VkPipelineViewportExclusiveScissorStateCreateInfoNV exclusiveScissorCount(@Unsigned int value) {
        segment.set(LAYOUT$exclusiveScissorCount, OFFSET$exclusiveScissorCount, value);
        return this;
    }

    public VkPipelineViewportExclusiveScissorStateCreateInfoNV pExclusiveScissors(@Nullable IVkRect2D value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pExclusiveScissorsRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkRect2D.Ptr pExclusiveScissors(int assumedCount) {
        MemorySegment s = pExclusiveScissorsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkRect2D.BYTES);
        return new VkRect2D.Ptr(s);
    }

    public @Nullable VkRect2D pExclusiveScissors() {
        MemorySegment s = pExclusiveScissorsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkRect2D(s);
    }

    public @Pointer(target=VkRect2D.class) @NotNull MemorySegment pExclusiveScissorsRaw() {
        return segment.get(LAYOUT$pExclusiveScissors, OFFSET$pExclusiveScissors);
    }

    public void pExclusiveScissorsRaw(@Pointer(target=VkRect2D.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pExclusiveScissors, OFFSET$pExclusiveScissors, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("exclusiveScissorCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkRect2D.LAYOUT).withName("pExclusiveScissors")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$exclusiveScissorCount = PathElement.groupElement("exclusiveScissorCount");
    public static final PathElement PATH$pExclusiveScissors = PathElement.groupElement("pExclusiveScissors");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$exclusiveScissorCount = (OfInt) LAYOUT.select(PATH$exclusiveScissorCount);
    public static final AddressLayout LAYOUT$pExclusiveScissors = (AddressLayout) LAYOUT.select(PATH$pExclusiveScissors);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$exclusiveScissorCount = LAYOUT$exclusiveScissorCount.byteSize();
    public static final long SIZE$pExclusiveScissors = LAYOUT$pExclusiveScissors.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$exclusiveScissorCount = LAYOUT.byteOffset(PATH$exclusiveScissorCount);
    public static final long OFFSET$pExclusiveScissors = LAYOUT.byteOffset(PATH$pExclusiveScissors);
}
