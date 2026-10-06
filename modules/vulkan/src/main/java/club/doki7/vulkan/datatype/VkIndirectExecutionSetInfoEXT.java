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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkIndirectExecutionSetInfoEXT.html"><code>VkIndirectExecutionSetInfoEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef union VkIndirectExecutionSetInfoEXT {
///     VkIndirectExecutionSetPipelineInfoEXT const* pPipelineInfo; // @link substring="VkIndirectExecutionSetPipelineInfoEXT" target="VkIndirectExecutionSetPipelineInfoEXT" @link substring="pPipelineInfo" target="#pPipelineInfo"
///     VkIndirectExecutionSetShaderInfoEXT const* pShaderInfo; // @link substring="VkIndirectExecutionSetShaderInfoEXT" target="VkIndirectExecutionSetShaderInfoEXT" @link substring="pShaderInfo" target="#pShaderInfo"
/// } VkIndirectExecutionSetInfoEXT;
/// }
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkIndirectExecutionSetInfoEXT.html"><code>VkIndirectExecutionSetInfoEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkIndirectExecutionSetInfoEXT(@NotNull MemorySegment segment) implements IVkIndirectExecutionSetInfoEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkIndirectExecutionSetInfoEXT.html"><code>VkIndirectExecutionSetInfoEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkIndirectExecutionSetInfoEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkIndirectExecutionSetInfoEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkIndirectExecutionSetInfoEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkIndirectExecutionSetInfoEXT, Iterable<VkIndirectExecutionSetInfoEXT> {
        public long size() {
            return segment.byteSize() / VkIndirectExecutionSetInfoEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkIndirectExecutionSetInfoEXT at(long index) {
            return new VkIndirectExecutionSetInfoEXT(segment.asSlice(index * VkIndirectExecutionSetInfoEXT.BYTES, VkIndirectExecutionSetInfoEXT.BYTES));
        }

        public VkIndirectExecutionSetInfoEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkIndirectExecutionSetInfoEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkIndirectExecutionSetInfoEXT value) {
            MemorySegment s = segment.asSlice(index * VkIndirectExecutionSetInfoEXT.BYTES, VkIndirectExecutionSetInfoEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkIndirectExecutionSetInfoEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkIndirectExecutionSetInfoEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkIndirectExecutionSetInfoEXT.BYTES,
                (end - start) * VkIndirectExecutionSetInfoEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkIndirectExecutionSetInfoEXT.BYTES));
        }

        public VkIndirectExecutionSetInfoEXT[] toArray() {
            VkIndirectExecutionSetInfoEXT[] ret = new VkIndirectExecutionSetInfoEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkIndirectExecutionSetInfoEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkIndirectExecutionSetInfoEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkIndirectExecutionSetInfoEXT.BYTES;
            }

            @Override
            public VkIndirectExecutionSetInfoEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkIndirectExecutionSetInfoEXT ret = new VkIndirectExecutionSetInfoEXT(segment.asSlice(0, VkIndirectExecutionSetInfoEXT.BYTES));
                segment = segment.asSlice(VkIndirectExecutionSetInfoEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkIndirectExecutionSetInfoEXT allocate(Arena arena) {
        return new VkIndirectExecutionSetInfoEXT(arena.allocate(LAYOUT));
    }

    public static VkIndirectExecutionSetInfoEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkIndirectExecutionSetInfoEXT.Ptr(segment);
    }

    public static VkIndirectExecutionSetInfoEXT clone(Arena arena, VkIndirectExecutionSetInfoEXT src) {
        VkIndirectExecutionSetInfoEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public VkIndirectExecutionSetInfoEXT pPipelineInfo(@Nullable IVkIndirectExecutionSetPipelineInfoEXT value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pPipelineInfoRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkIndirectExecutionSetPipelineInfoEXT.Ptr pPipelineInfo(int assumedCount) {
        MemorySegment s = pPipelineInfoRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkIndirectExecutionSetPipelineInfoEXT.BYTES);
        return new VkIndirectExecutionSetPipelineInfoEXT.Ptr(s);
    }

    public @Nullable VkIndirectExecutionSetPipelineInfoEXT pPipelineInfo() {
        MemorySegment s = pPipelineInfoRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkIndirectExecutionSetPipelineInfoEXT(s);
    }

    public @Pointer(target=VkIndirectExecutionSetPipelineInfoEXT.class) @NotNull MemorySegment pPipelineInfoRaw() {
        return segment.get(LAYOUT$pPipelineInfo, OFFSET$pPipelineInfo);
    }

    public void pPipelineInfoRaw(@Pointer(target=VkIndirectExecutionSetPipelineInfoEXT.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pPipelineInfo, OFFSET$pPipelineInfo, value);
    }

    public VkIndirectExecutionSetInfoEXT pShaderInfo(@Nullable IVkIndirectExecutionSetShaderInfoEXT value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pShaderInfoRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkIndirectExecutionSetShaderInfoEXT.Ptr pShaderInfo(int assumedCount) {
        MemorySegment s = pShaderInfoRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkIndirectExecutionSetShaderInfoEXT.BYTES);
        return new VkIndirectExecutionSetShaderInfoEXT.Ptr(s);
    }

    public @Nullable VkIndirectExecutionSetShaderInfoEXT pShaderInfo() {
        MemorySegment s = pShaderInfoRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkIndirectExecutionSetShaderInfoEXT(s);
    }

    public @Pointer(target=VkIndirectExecutionSetShaderInfoEXT.class) @NotNull MemorySegment pShaderInfoRaw() {
        return segment.get(LAYOUT$pShaderInfo, OFFSET$pShaderInfo);
    }

    public void pShaderInfoRaw(@Pointer(target=VkIndirectExecutionSetShaderInfoEXT.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pShaderInfo, OFFSET$pShaderInfo, value);
    }

    public static final UnionLayout LAYOUT = NativeLayout.unionLayout(
        ValueLayout.ADDRESS.withTargetLayout(VkIndirectExecutionSetPipelineInfoEXT.LAYOUT).withName("pPipelineInfo"),
        ValueLayout.ADDRESS.withTargetLayout(VkIndirectExecutionSetShaderInfoEXT.LAYOUT).withName("pShaderInfo")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$pPipelineInfo = PathElement.groupElement("pPipelineInfo");
    public static final PathElement PATH$pShaderInfo = PathElement.groupElement("pShaderInfo");

    public static final AddressLayout LAYOUT$pPipelineInfo = (AddressLayout) LAYOUT.select(PATH$pPipelineInfo);
    public static final AddressLayout LAYOUT$pShaderInfo = (AddressLayout) LAYOUT.select(PATH$pShaderInfo);

    public static final long SIZE$pPipelineInfo = LAYOUT$pPipelineInfo.byteSize();
    public static final long SIZE$pShaderInfo = LAYOUT$pShaderInfo.byteSize();

    public static final long OFFSET$pPipelineInfo = LAYOUT.byteOffset(PATH$pPipelineInfo);
    public static final long OFFSET$pShaderInfo = LAYOUT.byteOffset(PATH$pShaderInfo);
}
