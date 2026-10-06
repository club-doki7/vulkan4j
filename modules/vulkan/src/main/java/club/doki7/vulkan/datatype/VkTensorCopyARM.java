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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkTensorCopyARM.html"><code>VkTensorCopyARM</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkTensorCopyARM {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t dimensionCount; // optional // @link substring="dimensionCount" target="#dimensionCount"
///     uint64_t const* pSrcOffset; // optional // @link substring="pSrcOffset" target="#pSrcOffset"
///     uint64_t const* pDstOffset; // optional // @link substring="pDstOffset" target="#pDstOffset"
///     uint64_t const* pExtent; // optional // @link substring="pExtent" target="#pExtent"
/// } VkTensorCopyARM;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_TENSOR_COPY_ARM`
///
/// The {@code allocate} ({@link VkTensorCopyARM#allocate(Arena)}, {@link VkTensorCopyARM#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkTensorCopyARM#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkTensorCopyARM.html"><code>VkTensorCopyARM</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkTensorCopyARM(@NotNull MemorySegment segment) implements IVkTensorCopyARM {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkTensorCopyARM.html"><code>VkTensorCopyARM</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkTensorCopyARM}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkTensorCopyARM to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkTensorCopyARM.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkTensorCopyARM, Iterable<VkTensorCopyARM> {
        public long size() {
            return segment.byteSize() / VkTensorCopyARM.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkTensorCopyARM at(long index) {
            return new VkTensorCopyARM(segment.asSlice(index * VkTensorCopyARM.BYTES, VkTensorCopyARM.BYTES));
        }

        public VkTensorCopyARM.Ptr at(long index, @NotNull Consumer<@NotNull VkTensorCopyARM> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkTensorCopyARM value) {
            MemorySegment s = segment.asSlice(index * VkTensorCopyARM.BYTES, VkTensorCopyARM.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkTensorCopyARM.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkTensorCopyARM.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkTensorCopyARM.BYTES,
                (end - start) * VkTensorCopyARM.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkTensorCopyARM.BYTES));
        }

        public VkTensorCopyARM[] toArray() {
            VkTensorCopyARM[] ret = new VkTensorCopyARM[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkTensorCopyARM> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkTensorCopyARM> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkTensorCopyARM.BYTES;
            }

            @Override
            public VkTensorCopyARM next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkTensorCopyARM ret = new VkTensorCopyARM(segment.asSlice(0, VkTensorCopyARM.BYTES));
                segment = segment.asSlice(VkTensorCopyARM.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkTensorCopyARM allocate(Arena arena) {
        VkTensorCopyARM ret = new VkTensorCopyARM(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.TENSOR_COPY_ARM);
        return ret;
    }

    public static VkTensorCopyARM.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkTensorCopyARM.Ptr ret = new VkTensorCopyARM.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.TENSOR_COPY_ARM);
        }
        return ret;
    }

    public static VkTensorCopyARM clone(Arena arena, VkTensorCopyARM src) {
        VkTensorCopyARM ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.TENSOR_COPY_ARM);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkTensorCopyARM sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkTensorCopyARM pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkTensorCopyARM pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int dimensionCount() {
        return segment.get(LAYOUT$dimensionCount, OFFSET$dimensionCount);
    }

    public VkTensorCopyARM dimensionCount(@Unsigned int value) {
        segment.set(LAYOUT$dimensionCount, OFFSET$dimensionCount, value);
        return this;
    }

    /// Note: the returned {@link LongPtr} does not have correct
    /// {@link LongPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link LongPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable @Unsigned LongPtr pSrcOffset() {
        MemorySegment s = pSrcOffsetRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new LongPtr(s);
    }

    public VkTensorCopyARM pSrcOffset(@Nullable @Unsigned LongPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pSrcOffsetRaw(s);
        return this;
    }

    public @Pointer(comment="uint64_t*") @NotNull MemorySegment pSrcOffsetRaw() {
        return segment.get(LAYOUT$pSrcOffset, OFFSET$pSrcOffset);
    }

    public void pSrcOffsetRaw(@Pointer(comment="uint64_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pSrcOffset, OFFSET$pSrcOffset, value);
    }

    /// Note: the returned {@link LongPtr} does not have correct
    /// {@link LongPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link LongPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable @Unsigned LongPtr pDstOffset() {
        MemorySegment s = pDstOffsetRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new LongPtr(s);
    }

    public VkTensorCopyARM pDstOffset(@Nullable @Unsigned LongPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pDstOffsetRaw(s);
        return this;
    }

    public @Pointer(comment="uint64_t*") @NotNull MemorySegment pDstOffsetRaw() {
        return segment.get(LAYOUT$pDstOffset, OFFSET$pDstOffset);
    }

    public void pDstOffsetRaw(@Pointer(comment="uint64_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pDstOffset, OFFSET$pDstOffset, value);
    }

    /// Note: the returned {@link LongPtr} does not have correct
    /// {@link LongPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link LongPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable @Unsigned LongPtr pExtent() {
        MemorySegment s = pExtentRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new LongPtr(s);
    }

    public VkTensorCopyARM pExtent(@Nullable @Unsigned LongPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pExtentRaw(s);
        return this;
    }

    public @Pointer(comment="uint64_t*") @NotNull MemorySegment pExtentRaw() {
        return segment.get(LAYOUT$pExtent, OFFSET$pExtent);
    }

    public void pExtentRaw(@Pointer(comment="uint64_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pExtent, OFFSET$pExtent, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("dimensionCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG).withName("pSrcOffset"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG).withName("pDstOffset"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG).withName("pExtent")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$dimensionCount = PathElement.groupElement("dimensionCount");
    public static final PathElement PATH$pSrcOffset = PathElement.groupElement("pSrcOffset");
    public static final PathElement PATH$pDstOffset = PathElement.groupElement("pDstOffset");
    public static final PathElement PATH$pExtent = PathElement.groupElement("pExtent");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$dimensionCount = (OfInt) LAYOUT.select(PATH$dimensionCount);
    public static final AddressLayout LAYOUT$pSrcOffset = (AddressLayout) LAYOUT.select(PATH$pSrcOffset);
    public static final AddressLayout LAYOUT$pDstOffset = (AddressLayout) LAYOUT.select(PATH$pDstOffset);
    public static final AddressLayout LAYOUT$pExtent = (AddressLayout) LAYOUT.select(PATH$pExtent);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$dimensionCount = LAYOUT$dimensionCount.byteSize();
    public static final long SIZE$pSrcOffset = LAYOUT$pSrcOffset.byteSize();
    public static final long SIZE$pDstOffset = LAYOUT$pDstOffset.byteSize();
    public static final long SIZE$pExtent = LAYOUT$pExtent.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$dimensionCount = LAYOUT.byteOffset(PATH$dimensionCount);
    public static final long OFFSET$pSrcOffset = LAYOUT.byteOffset(PATH$pSrcOffset);
    public static final long OFFSET$pDstOffset = LAYOUT.byteOffset(PATH$pDstOffset);
    public static final long OFFSET$pExtent = LAYOUT.byteOffset(PATH$pExtent);
}
