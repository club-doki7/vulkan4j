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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageBlit2.html"><code>VkImageBlit2</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkImageBlit2 {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkImageSubresourceLayers srcSubresource; // @link substring="VkImageSubresourceLayers" target="VkImageSubresourceLayers" @link substring="srcSubresource" target="#srcSubresource"
///     VkOffset3D[2] srcOffsets; // @link substring="VkOffset3D" target="VkOffset3D" @link substring="srcOffsets" target="#srcOffsets"
///     VkImageSubresourceLayers dstSubresource; // @link substring="VkImageSubresourceLayers" target="VkImageSubresourceLayers" @link substring="dstSubresource" target="#dstSubresource"
///     VkOffset3D[2] dstOffsets; // @link substring="VkOffset3D" target="VkOffset3D" @link substring="dstOffsets" target="#dstOffsets"
/// } VkImageBlit2;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_IMAGE_BLIT_2`
///
/// The {@code allocate} ({@link VkImageBlit2#allocate(Arena)}, {@link VkImageBlit2#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkImageBlit2#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageBlit2.html"><code>VkImageBlit2</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkImageBlit2(@NotNull MemorySegment segment) implements IVkImageBlit2 {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageBlit2.html"><code>VkImageBlit2</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkImageBlit2}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkImageBlit2 to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkImageBlit2.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkImageBlit2, Iterable<VkImageBlit2> {
        public long size() {
            return segment.byteSize() / VkImageBlit2.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkImageBlit2 at(long index) {
            return new VkImageBlit2(segment.asSlice(index * VkImageBlit2.BYTES, VkImageBlit2.BYTES));
        }

        public VkImageBlit2.Ptr at(long index, @NotNull Consumer<@NotNull VkImageBlit2> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkImageBlit2 value) {
            MemorySegment s = segment.asSlice(index * VkImageBlit2.BYTES, VkImageBlit2.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkImageBlit2.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkImageBlit2.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkImageBlit2.BYTES,
                (end - start) * VkImageBlit2.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkImageBlit2.BYTES));
        }

        public VkImageBlit2[] toArray() {
            VkImageBlit2[] ret = new VkImageBlit2[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkImageBlit2> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkImageBlit2> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkImageBlit2.BYTES;
            }

            @Override
            public VkImageBlit2 next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkImageBlit2 ret = new VkImageBlit2(segment.asSlice(0, VkImageBlit2.BYTES));
                segment = segment.asSlice(VkImageBlit2.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkImageBlit2 allocate(Arena arena) {
        VkImageBlit2 ret = new VkImageBlit2(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.IMAGE_BLIT_2);
        return ret;
    }

    public static VkImageBlit2.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkImageBlit2.Ptr ret = new VkImageBlit2.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.IMAGE_BLIT_2);
        }
        return ret;
    }

    public static VkImageBlit2 clone(Arena arena, VkImageBlit2 src) {
        VkImageBlit2 ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.IMAGE_BLIT_2);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkImageBlit2 sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkImageBlit2 pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkImageBlit2 pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NotNull VkImageSubresourceLayers srcSubresource() {
        return new VkImageSubresourceLayers(segment.asSlice(OFFSET$srcSubresource, LAYOUT$srcSubresource));
    }

    public VkImageBlit2 srcSubresource(@NotNull VkImageSubresourceLayers value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$srcSubresource, SIZE$srcSubresource);
        return this;
    }

    public VkImageBlit2 srcSubresource(Consumer<@NotNull VkImageSubresourceLayers> consumer) {
        consumer.accept(srcSubresource());
        return this;
    }

    public VkOffset3D.Ptr srcOffsets() {
        return new VkOffset3D.Ptr(srcOffsetsRaw());
    }

    public VkImageBlit2 srcOffsets(@NotNull Consumer<VkOffset3D.Ptr> consumer) {
        VkOffset3D.Ptr ptr = srcOffsets();
        consumer.accept(ptr);
        return this;
    }

    public VkImageBlit2 srcOffsets(VkOffset3D.Ptr value) {
        MemorySegment s = srcOffsetsRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public VkOffset3D srcOffsetsAt(int index) {
        MemorySegment s = srcOffsetsRaw();
        return new VkOffset3D(s.asSlice(index * VkOffset3D.BYTES, VkOffset3D.BYTES));
    }

    public void srcOffsetsAt(int index, VkOffset3D value) {
        MemorySegment s = srcOffsetsRaw();
        MemorySegment.copy(value.segment(), 0, s, index * VkOffset3D.BYTES, VkOffset3D.BYTES);
    }

    public @NotNull MemorySegment srcOffsetsRaw() {
        return segment.asSlice(OFFSET$srcOffsets, SIZE$srcOffsets);
    }

    public @NotNull VkImageSubresourceLayers dstSubresource() {
        return new VkImageSubresourceLayers(segment.asSlice(OFFSET$dstSubresource, LAYOUT$dstSubresource));
    }

    public VkImageBlit2 dstSubresource(@NotNull VkImageSubresourceLayers value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$dstSubresource, SIZE$dstSubresource);
        return this;
    }

    public VkImageBlit2 dstSubresource(Consumer<@NotNull VkImageSubresourceLayers> consumer) {
        consumer.accept(dstSubresource());
        return this;
    }

    public VkOffset3D.Ptr dstOffsets() {
        return new VkOffset3D.Ptr(dstOffsetsRaw());
    }

    public VkImageBlit2 dstOffsets(@NotNull Consumer<VkOffset3D.Ptr> consumer) {
        VkOffset3D.Ptr ptr = dstOffsets();
        consumer.accept(ptr);
        return this;
    }

    public VkImageBlit2 dstOffsets(VkOffset3D.Ptr value) {
        MemorySegment s = dstOffsetsRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public VkOffset3D dstOffsetsAt(int index) {
        MemorySegment s = dstOffsetsRaw();
        return new VkOffset3D(s.asSlice(index * VkOffset3D.BYTES, VkOffset3D.BYTES));
    }

    public void dstOffsetsAt(int index, VkOffset3D value) {
        MemorySegment s = dstOffsetsRaw();
        MemorySegment.copy(value.segment(), 0, s, index * VkOffset3D.BYTES, VkOffset3D.BYTES);
    }

    public @NotNull MemorySegment dstOffsetsRaw() {
        return segment.asSlice(OFFSET$dstOffsets, SIZE$dstOffsets);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        VkImageSubresourceLayers.LAYOUT.withName("srcSubresource"),
        MemoryLayout.sequenceLayout(2, VkOffset3D.LAYOUT).withName("srcOffsets"),
        VkImageSubresourceLayers.LAYOUT.withName("dstSubresource"),
        MemoryLayout.sequenceLayout(2, VkOffset3D.LAYOUT).withName("dstOffsets")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$srcSubresource = PathElement.groupElement("srcSubresource");
    public static final PathElement PATH$srcOffsets = PathElement.groupElement("srcOffsets");
    public static final PathElement PATH$dstSubresource = PathElement.groupElement("dstSubresource");
    public static final PathElement PATH$dstOffsets = PathElement.groupElement("dstOffsets");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final StructLayout LAYOUT$srcSubresource = (StructLayout) LAYOUT.select(PATH$srcSubresource);
    public static final SequenceLayout LAYOUT$srcOffsets = (SequenceLayout) LAYOUT.select(PATH$srcOffsets);
    public static final StructLayout LAYOUT$dstSubresource = (StructLayout) LAYOUT.select(PATH$dstSubresource);
    public static final SequenceLayout LAYOUT$dstOffsets = (SequenceLayout) LAYOUT.select(PATH$dstOffsets);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$srcSubresource = LAYOUT$srcSubresource.byteSize();
    public static final long SIZE$srcOffsets = LAYOUT$srcOffsets.byteSize();
    public static final long SIZE$dstSubresource = LAYOUT$dstSubresource.byteSize();
    public static final long SIZE$dstOffsets = LAYOUT$dstOffsets.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$srcSubresource = LAYOUT.byteOffset(PATH$srcSubresource);
    public static final long OFFSET$srcOffsets = LAYOUT.byteOffset(PATH$srcOffsets);
    public static final long OFFSET$dstSubresource = LAYOUT.byteOffset(PATH$dstSubresource);
    public static final long OFFSET$dstOffsets = LAYOUT.byteOffset(PATH$dstOffsets);
}
