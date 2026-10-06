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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCopyBufferInfo2.html"><code>VkCopyBufferInfo2</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkCopyBufferInfo2 {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBuffer srcBuffer; // @link substring="VkBuffer" target="VkBuffer" @link substring="srcBuffer" target="#srcBuffer"
///     VkBuffer dstBuffer; // @link substring="VkBuffer" target="VkBuffer" @link substring="dstBuffer" target="#dstBuffer"
///     uint32_t regionCount; // @link substring="regionCount" target="#regionCount"
///     VkBufferCopy2 const* pRegions; // @link substring="VkBufferCopy2" target="VkBufferCopy2" @link substring="pRegions" target="#pRegions"
/// } VkCopyBufferInfo2;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_COPY_BUFFER_INFO_2`
///
/// The {@code allocate} ({@link VkCopyBufferInfo2#allocate(Arena)}, {@link VkCopyBufferInfo2#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkCopyBufferInfo2#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCopyBufferInfo2.html"><code>VkCopyBufferInfo2</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkCopyBufferInfo2(@NotNull MemorySegment segment) implements IVkCopyBufferInfo2 {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCopyBufferInfo2.html"><code>VkCopyBufferInfo2</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkCopyBufferInfo2}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkCopyBufferInfo2 to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkCopyBufferInfo2.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkCopyBufferInfo2, Iterable<VkCopyBufferInfo2> {
        public long size() {
            return segment.byteSize() / VkCopyBufferInfo2.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkCopyBufferInfo2 at(long index) {
            return new VkCopyBufferInfo2(segment.asSlice(index * VkCopyBufferInfo2.BYTES, VkCopyBufferInfo2.BYTES));
        }

        public VkCopyBufferInfo2.Ptr at(long index, @NotNull Consumer<@NotNull VkCopyBufferInfo2> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkCopyBufferInfo2 value) {
            MemorySegment s = segment.asSlice(index * VkCopyBufferInfo2.BYTES, VkCopyBufferInfo2.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkCopyBufferInfo2.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkCopyBufferInfo2.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkCopyBufferInfo2.BYTES,
                (end - start) * VkCopyBufferInfo2.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkCopyBufferInfo2.BYTES));
        }

        public VkCopyBufferInfo2[] toArray() {
            VkCopyBufferInfo2[] ret = new VkCopyBufferInfo2[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkCopyBufferInfo2> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkCopyBufferInfo2> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkCopyBufferInfo2.BYTES;
            }

            @Override
            public VkCopyBufferInfo2 next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkCopyBufferInfo2 ret = new VkCopyBufferInfo2(segment.asSlice(0, VkCopyBufferInfo2.BYTES));
                segment = segment.asSlice(VkCopyBufferInfo2.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkCopyBufferInfo2 allocate(Arena arena) {
        VkCopyBufferInfo2 ret = new VkCopyBufferInfo2(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.COPY_BUFFER_INFO_2);
        return ret;
    }

    public static VkCopyBufferInfo2.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkCopyBufferInfo2.Ptr ret = new VkCopyBufferInfo2.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.COPY_BUFFER_INFO_2);
        }
        return ret;
    }

    public static VkCopyBufferInfo2 clone(Arena arena, VkCopyBufferInfo2 src) {
        VkCopyBufferInfo2 ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.COPY_BUFFER_INFO_2);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkCopyBufferInfo2 sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkCopyBufferInfo2 pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkCopyBufferInfo2 pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Nullable VkBuffer srcBuffer() {
        MemorySegment s = segment.asSlice(OFFSET$srcBuffer, SIZE$srcBuffer);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkBuffer(s);
    }

    public VkCopyBufferInfo2 srcBuffer(@Nullable VkBuffer value) {
        segment.set(LAYOUT$srcBuffer, OFFSET$srcBuffer, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Nullable VkBuffer dstBuffer() {
        MemorySegment s = segment.asSlice(OFFSET$dstBuffer, SIZE$dstBuffer);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkBuffer(s);
    }

    public VkCopyBufferInfo2 dstBuffer(@Nullable VkBuffer value) {
        segment.set(LAYOUT$dstBuffer, OFFSET$dstBuffer, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int regionCount() {
        return segment.get(LAYOUT$regionCount, OFFSET$regionCount);
    }

    public VkCopyBufferInfo2 regionCount(@Unsigned int value) {
        segment.set(LAYOUT$regionCount, OFFSET$regionCount, value);
        return this;
    }

    public VkCopyBufferInfo2 pRegions(@Nullable IVkBufferCopy2 value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pRegionsRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkBufferCopy2.Ptr pRegions(int assumedCount) {
        MemorySegment s = pRegionsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkBufferCopy2.BYTES);
        return new VkBufferCopy2.Ptr(s);
    }

    public @Nullable VkBufferCopy2 pRegions() {
        MemorySegment s = pRegionsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkBufferCopy2(s);
    }

    public @Pointer(target=VkBufferCopy2.class) @NotNull MemorySegment pRegionsRaw() {
        return segment.get(LAYOUT$pRegions, OFFSET$pRegions);
    }

    public void pRegionsRaw(@Pointer(target=VkBufferCopy2.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pRegions, OFFSET$pRegions, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withName("srcBuffer"),
        ValueLayout.ADDRESS.withName("dstBuffer"),
        ValueLayout.JAVA_INT.withName("regionCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkBufferCopy2.LAYOUT).withName("pRegions")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$srcBuffer = PathElement.groupElement("srcBuffer");
    public static final PathElement PATH$dstBuffer = PathElement.groupElement("dstBuffer");
    public static final PathElement PATH$regionCount = PathElement.groupElement("regionCount");
    public static final PathElement PATH$pRegions = PathElement.groupElement("pRegions");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$srcBuffer = (AddressLayout) LAYOUT.select(PATH$srcBuffer);
    public static final AddressLayout LAYOUT$dstBuffer = (AddressLayout) LAYOUT.select(PATH$dstBuffer);
    public static final OfInt LAYOUT$regionCount = (OfInt) LAYOUT.select(PATH$regionCount);
    public static final AddressLayout LAYOUT$pRegions = (AddressLayout) LAYOUT.select(PATH$pRegions);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$srcBuffer = LAYOUT$srcBuffer.byteSize();
    public static final long SIZE$dstBuffer = LAYOUT$dstBuffer.byteSize();
    public static final long SIZE$regionCount = LAYOUT$regionCount.byteSize();
    public static final long SIZE$pRegions = LAYOUT$pRegions.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$srcBuffer = LAYOUT.byteOffset(PATH$srcBuffer);
    public static final long OFFSET$dstBuffer = LAYOUT.byteOffset(PATH$dstBuffer);
    public static final long OFFSET$regionCount = LAYOUT.byteOffset(PATH$regionCount);
    public static final long OFFSET$pRegions = LAYOUT.byteOffset(PATH$pRegions);
}
