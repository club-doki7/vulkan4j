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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkIndirectCommandsTokenDataEXT.html"><code>VkIndirectCommandsTokenDataEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef union VkIndirectCommandsTokenDataEXT {
///     VkIndirectCommandsPushConstantTokenEXT const* pPushConstant; // @link substring="VkIndirectCommandsPushConstantTokenEXT" target="VkIndirectCommandsPushConstantTokenEXT" @link substring="pPushConstant" target="#pPushConstant"
///     VkIndirectCommandsVertexBufferTokenEXT const* pVertexBuffer; // @link substring="VkIndirectCommandsVertexBufferTokenEXT" target="VkIndirectCommandsVertexBufferTokenEXT" @link substring="pVertexBuffer" target="#pVertexBuffer"
///     VkIndirectCommandsIndexBufferTokenEXT const* pIndexBuffer; // @link substring="VkIndirectCommandsIndexBufferTokenEXT" target="VkIndirectCommandsIndexBufferTokenEXT" @link substring="pIndexBuffer" target="#pIndexBuffer"
///     VkIndirectCommandsExecutionSetTokenEXT const* pExecutionSet; // @link substring="VkIndirectCommandsExecutionSetTokenEXT" target="VkIndirectCommandsExecutionSetTokenEXT" @link substring="pExecutionSet" target="#pExecutionSet"
/// } VkIndirectCommandsTokenDataEXT;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkIndirectCommandsTokenDataEXT.html"><code>VkIndirectCommandsTokenDataEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkIndirectCommandsTokenDataEXT(@NotNull MemorySegment segment) implements IVkIndirectCommandsTokenDataEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkIndirectCommandsTokenDataEXT.html"><code>VkIndirectCommandsTokenDataEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkIndirectCommandsTokenDataEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkIndirectCommandsTokenDataEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkIndirectCommandsTokenDataEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkIndirectCommandsTokenDataEXT, Iterable<VkIndirectCommandsTokenDataEXT> {
        public long size() {
            return segment.byteSize() / VkIndirectCommandsTokenDataEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkIndirectCommandsTokenDataEXT at(long index) {
            return new VkIndirectCommandsTokenDataEXT(segment.asSlice(index * VkIndirectCommandsTokenDataEXT.BYTES, VkIndirectCommandsTokenDataEXT.BYTES));
        }

        public VkIndirectCommandsTokenDataEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkIndirectCommandsTokenDataEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkIndirectCommandsTokenDataEXT value) {
            MemorySegment s = segment.asSlice(index * VkIndirectCommandsTokenDataEXT.BYTES, VkIndirectCommandsTokenDataEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkIndirectCommandsTokenDataEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkIndirectCommandsTokenDataEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkIndirectCommandsTokenDataEXT.BYTES,
                (end - start) * VkIndirectCommandsTokenDataEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkIndirectCommandsTokenDataEXT.BYTES));
        }

        public VkIndirectCommandsTokenDataEXT[] toArray() {
            VkIndirectCommandsTokenDataEXT[] ret = new VkIndirectCommandsTokenDataEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkIndirectCommandsTokenDataEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkIndirectCommandsTokenDataEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkIndirectCommandsTokenDataEXT.BYTES;
            }

            @Override
            public VkIndirectCommandsTokenDataEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkIndirectCommandsTokenDataEXT ret = new VkIndirectCommandsTokenDataEXT(segment.asSlice(0, VkIndirectCommandsTokenDataEXT.BYTES));
                segment = segment.asSlice(VkIndirectCommandsTokenDataEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkIndirectCommandsTokenDataEXT allocate(Arena arena) {
        return new VkIndirectCommandsTokenDataEXT(arena.allocate(LAYOUT));
    }

    public static VkIndirectCommandsTokenDataEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkIndirectCommandsTokenDataEXT.Ptr(segment);
    }

    public static VkIndirectCommandsTokenDataEXT clone(Arena arena, VkIndirectCommandsTokenDataEXT src) {
        VkIndirectCommandsTokenDataEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public VkIndirectCommandsTokenDataEXT pPushConstant(@Nullable IVkIndirectCommandsPushConstantTokenEXT value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pPushConstantRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkIndirectCommandsPushConstantTokenEXT.Ptr pPushConstant(int assumedCount) {
        MemorySegment s = pPushConstantRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkIndirectCommandsPushConstantTokenEXT.BYTES);
        return new VkIndirectCommandsPushConstantTokenEXT.Ptr(s);
    }

    public @Nullable VkIndirectCommandsPushConstantTokenEXT pPushConstant() {
        MemorySegment s = pPushConstantRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkIndirectCommandsPushConstantTokenEXT(s);
    }

    public @Pointer(target=VkIndirectCommandsPushConstantTokenEXT.class) @NotNull MemorySegment pPushConstantRaw() {
        return segment.get(LAYOUT$pPushConstant, OFFSET$pPushConstant);
    }

    public void pPushConstantRaw(@Pointer(target=VkIndirectCommandsPushConstantTokenEXT.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pPushConstant, OFFSET$pPushConstant, value);
    }

    public VkIndirectCommandsTokenDataEXT pVertexBuffer(@Nullable IVkIndirectCommandsVertexBufferTokenEXT value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pVertexBufferRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkIndirectCommandsVertexBufferTokenEXT.Ptr pVertexBuffer(int assumedCount) {
        MemorySegment s = pVertexBufferRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkIndirectCommandsVertexBufferTokenEXT.BYTES);
        return new VkIndirectCommandsVertexBufferTokenEXT.Ptr(s);
    }

    public @Nullable VkIndirectCommandsVertexBufferTokenEXT pVertexBuffer() {
        MemorySegment s = pVertexBufferRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkIndirectCommandsVertexBufferTokenEXT(s);
    }

    public @Pointer(target=VkIndirectCommandsVertexBufferTokenEXT.class) @NotNull MemorySegment pVertexBufferRaw() {
        return segment.get(LAYOUT$pVertexBuffer, OFFSET$pVertexBuffer);
    }

    public void pVertexBufferRaw(@Pointer(target=VkIndirectCommandsVertexBufferTokenEXT.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pVertexBuffer, OFFSET$pVertexBuffer, value);
    }

    public VkIndirectCommandsTokenDataEXT pIndexBuffer(@Nullable IVkIndirectCommandsIndexBufferTokenEXT value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pIndexBufferRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkIndirectCommandsIndexBufferTokenEXT.Ptr pIndexBuffer(int assumedCount) {
        MemorySegment s = pIndexBufferRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkIndirectCommandsIndexBufferTokenEXT.BYTES);
        return new VkIndirectCommandsIndexBufferTokenEXT.Ptr(s);
    }

    public @Nullable VkIndirectCommandsIndexBufferTokenEXT pIndexBuffer() {
        MemorySegment s = pIndexBufferRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkIndirectCommandsIndexBufferTokenEXT(s);
    }

    public @Pointer(target=VkIndirectCommandsIndexBufferTokenEXT.class) @NotNull MemorySegment pIndexBufferRaw() {
        return segment.get(LAYOUT$pIndexBuffer, OFFSET$pIndexBuffer);
    }

    public void pIndexBufferRaw(@Pointer(target=VkIndirectCommandsIndexBufferTokenEXT.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pIndexBuffer, OFFSET$pIndexBuffer, value);
    }

    public VkIndirectCommandsTokenDataEXT pExecutionSet(@Nullable IVkIndirectCommandsExecutionSetTokenEXT value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pExecutionSetRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkIndirectCommandsExecutionSetTokenEXT.Ptr pExecutionSet(int assumedCount) {
        MemorySegment s = pExecutionSetRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkIndirectCommandsExecutionSetTokenEXT.BYTES);
        return new VkIndirectCommandsExecutionSetTokenEXT.Ptr(s);
    }

    public @Nullable VkIndirectCommandsExecutionSetTokenEXT pExecutionSet() {
        MemorySegment s = pExecutionSetRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkIndirectCommandsExecutionSetTokenEXT(s);
    }

    public @Pointer(target=VkIndirectCommandsExecutionSetTokenEXT.class) @NotNull MemorySegment pExecutionSetRaw() {
        return segment.get(LAYOUT$pExecutionSet, OFFSET$pExecutionSet);
    }

    public void pExecutionSetRaw(@Pointer(target=VkIndirectCommandsExecutionSetTokenEXT.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pExecutionSet, OFFSET$pExecutionSet, value);
    }

    public static final UnionLayout LAYOUT = NativeLayout.unionLayout(
        ValueLayout.ADDRESS.withTargetLayout(VkIndirectCommandsPushConstantTokenEXT.LAYOUT).withName("pPushConstant"),
        ValueLayout.ADDRESS.withTargetLayout(VkIndirectCommandsVertexBufferTokenEXT.LAYOUT).withName("pVertexBuffer"),
        ValueLayout.ADDRESS.withTargetLayout(VkIndirectCommandsIndexBufferTokenEXT.LAYOUT).withName("pIndexBuffer"),
        ValueLayout.ADDRESS.withTargetLayout(VkIndirectCommandsExecutionSetTokenEXT.LAYOUT).withName("pExecutionSet")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$pPushConstant = PathElement.groupElement("pPushConstant");
    public static final PathElement PATH$pVertexBuffer = PathElement.groupElement("pVertexBuffer");
    public static final PathElement PATH$pIndexBuffer = PathElement.groupElement("pIndexBuffer");
    public static final PathElement PATH$pExecutionSet = PathElement.groupElement("pExecutionSet");

    public static final AddressLayout LAYOUT$pPushConstant = (AddressLayout) LAYOUT.select(PATH$pPushConstant);
    public static final AddressLayout LAYOUT$pVertexBuffer = (AddressLayout) LAYOUT.select(PATH$pVertexBuffer);
    public static final AddressLayout LAYOUT$pIndexBuffer = (AddressLayout) LAYOUT.select(PATH$pIndexBuffer);
    public static final AddressLayout LAYOUT$pExecutionSet = (AddressLayout) LAYOUT.select(PATH$pExecutionSet);

    public static final long SIZE$pPushConstant = LAYOUT$pPushConstant.byteSize();
    public static final long SIZE$pVertexBuffer = LAYOUT$pVertexBuffer.byteSize();
    public static final long SIZE$pIndexBuffer = LAYOUT$pIndexBuffer.byteSize();
    public static final long SIZE$pExecutionSet = LAYOUT$pExecutionSet.byteSize();

    public static final long OFFSET$pPushConstant = LAYOUT.byteOffset(PATH$pPushConstant);
    public static final long OFFSET$pVertexBuffer = LAYOUT.byteOffset(PATH$pVertexBuffer);
    public static final long OFFSET$pIndexBuffer = LAYOUT.byteOffset(PATH$pIndexBuffer);
    public static final long OFFSET$pExecutionSet = LAYOUT.byteOffset(PATH$pExecutionSet);
}
