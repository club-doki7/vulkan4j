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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBufferMemoryBarrier.html"><code>VkBufferMemoryBarrier</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkBufferMemoryBarrier {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkAccessFlags srcAccessMask; // @link substring="VkAccessFlags" target="VkAccessFlags" @link substring="srcAccessMask" target="#srcAccessMask"
///     VkAccessFlags dstAccessMask; // @link substring="VkAccessFlags" target="VkAccessFlags" @link substring="dstAccessMask" target="#dstAccessMask"
///     uint32_t srcQueueFamilyIndex; // @link substring="srcQueueFamilyIndex" target="#srcQueueFamilyIndex"
///     uint32_t dstQueueFamilyIndex; // @link substring="dstQueueFamilyIndex" target="#dstQueueFamilyIndex"
///     VkBuffer buffer; // @link substring="VkBuffer" target="VkBuffer" @link substring="buffer" target="#buffer"
///     VkDeviceSize offset; // @link substring="offset" target="#offset"
///     VkDeviceSize size; // @link substring="size" target="#size"
/// } VkBufferMemoryBarrier;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_BUFFER_MEMORY_BARRIER`
///
/// The {@code allocate} ({@link VkBufferMemoryBarrier#allocate(Arena)}, {@link VkBufferMemoryBarrier#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkBufferMemoryBarrier#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBufferMemoryBarrier.html"><code>VkBufferMemoryBarrier</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkBufferMemoryBarrier(@NotNull MemorySegment segment) implements IVkBufferMemoryBarrier {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBufferMemoryBarrier.html"><code>VkBufferMemoryBarrier</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkBufferMemoryBarrier}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkBufferMemoryBarrier to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkBufferMemoryBarrier.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkBufferMemoryBarrier, Iterable<VkBufferMemoryBarrier> {
        public long size() {
            return segment.byteSize() / VkBufferMemoryBarrier.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkBufferMemoryBarrier at(long index) {
            return new VkBufferMemoryBarrier(segment.asSlice(index * VkBufferMemoryBarrier.BYTES, VkBufferMemoryBarrier.BYTES));
        }

        public VkBufferMemoryBarrier.Ptr at(long index, @NotNull Consumer<@NotNull VkBufferMemoryBarrier> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkBufferMemoryBarrier value) {
            MemorySegment s = segment.asSlice(index * VkBufferMemoryBarrier.BYTES, VkBufferMemoryBarrier.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkBufferMemoryBarrier.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkBufferMemoryBarrier.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkBufferMemoryBarrier.BYTES,
                (end - start) * VkBufferMemoryBarrier.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkBufferMemoryBarrier.BYTES));
        }

        public VkBufferMemoryBarrier[] toArray() {
            VkBufferMemoryBarrier[] ret = new VkBufferMemoryBarrier[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkBufferMemoryBarrier> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkBufferMemoryBarrier> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkBufferMemoryBarrier.BYTES;
            }

            @Override
            public VkBufferMemoryBarrier next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkBufferMemoryBarrier ret = new VkBufferMemoryBarrier(segment.asSlice(0, VkBufferMemoryBarrier.BYTES));
                segment = segment.asSlice(VkBufferMemoryBarrier.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkBufferMemoryBarrier allocate(Arena arena) {
        VkBufferMemoryBarrier ret = new VkBufferMemoryBarrier(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.BUFFER_MEMORY_BARRIER);
        return ret;
    }

    public static VkBufferMemoryBarrier.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkBufferMemoryBarrier.Ptr ret = new VkBufferMemoryBarrier.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.BUFFER_MEMORY_BARRIER);
        }
        return ret;
    }

    public static VkBufferMemoryBarrier clone(Arena arena, VkBufferMemoryBarrier src) {
        VkBufferMemoryBarrier ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.BUFFER_MEMORY_BARRIER);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkBufferMemoryBarrier sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkBufferMemoryBarrier pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkBufferMemoryBarrier pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkAccessFlags.class) int srcAccessMask() {
        return segment.get(LAYOUT$srcAccessMask, OFFSET$srcAccessMask);
    }

    public VkBufferMemoryBarrier srcAccessMask(@Bitmask(VkAccessFlags.class) int value) {
        segment.set(LAYOUT$srcAccessMask, OFFSET$srcAccessMask, value);
        return this;
    }

    public @Bitmask(VkAccessFlags.class) int dstAccessMask() {
        return segment.get(LAYOUT$dstAccessMask, OFFSET$dstAccessMask);
    }

    public VkBufferMemoryBarrier dstAccessMask(@Bitmask(VkAccessFlags.class) int value) {
        segment.set(LAYOUT$dstAccessMask, OFFSET$dstAccessMask, value);
        return this;
    }

    public @Unsigned int srcQueueFamilyIndex() {
        return segment.get(LAYOUT$srcQueueFamilyIndex, OFFSET$srcQueueFamilyIndex);
    }

    public VkBufferMemoryBarrier srcQueueFamilyIndex(@Unsigned int value) {
        segment.set(LAYOUT$srcQueueFamilyIndex, OFFSET$srcQueueFamilyIndex, value);
        return this;
    }

    public @Unsigned int dstQueueFamilyIndex() {
        return segment.get(LAYOUT$dstQueueFamilyIndex, OFFSET$dstQueueFamilyIndex);
    }

    public VkBufferMemoryBarrier dstQueueFamilyIndex(@Unsigned int value) {
        segment.set(LAYOUT$dstQueueFamilyIndex, OFFSET$dstQueueFamilyIndex, value);
        return this;
    }

    public @Nullable VkBuffer buffer() {
        MemorySegment s = segment.asSlice(OFFSET$buffer, SIZE$buffer);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkBuffer(s);
    }

    public VkBufferMemoryBarrier buffer(@Nullable VkBuffer value) {
        segment.set(LAYOUT$buffer, OFFSET$buffer, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long offset() {
        return segment.get(LAYOUT$offset, OFFSET$offset);
    }

    public VkBufferMemoryBarrier offset(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$offset, OFFSET$offset, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long size() {
        return segment.get(LAYOUT$size, OFFSET$size);
    }

    public VkBufferMemoryBarrier size(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$size, OFFSET$size, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("srcAccessMask"),
        ValueLayout.JAVA_INT.withName("dstAccessMask"),
        ValueLayout.JAVA_INT.withName("srcQueueFamilyIndex"),
        ValueLayout.JAVA_INT.withName("dstQueueFamilyIndex"),
        ValueLayout.ADDRESS.withName("buffer"),
        ValueLayout.JAVA_LONG.withName("offset"),
        ValueLayout.JAVA_LONG.withName("size")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$srcAccessMask = PathElement.groupElement("srcAccessMask");
    public static final PathElement PATH$dstAccessMask = PathElement.groupElement("dstAccessMask");
    public static final PathElement PATH$srcQueueFamilyIndex = PathElement.groupElement("srcQueueFamilyIndex");
    public static final PathElement PATH$dstQueueFamilyIndex = PathElement.groupElement("dstQueueFamilyIndex");
    public static final PathElement PATH$buffer = PathElement.groupElement("buffer");
    public static final PathElement PATH$offset = PathElement.groupElement("offset");
    public static final PathElement PATH$size = PathElement.groupElement("size");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$srcAccessMask = (OfInt) LAYOUT.select(PATH$srcAccessMask);
    public static final OfInt LAYOUT$dstAccessMask = (OfInt) LAYOUT.select(PATH$dstAccessMask);
    public static final OfInt LAYOUT$srcQueueFamilyIndex = (OfInt) LAYOUT.select(PATH$srcQueueFamilyIndex);
    public static final OfInt LAYOUT$dstQueueFamilyIndex = (OfInt) LAYOUT.select(PATH$dstQueueFamilyIndex);
    public static final AddressLayout LAYOUT$buffer = (AddressLayout) LAYOUT.select(PATH$buffer);
    public static final OfLong LAYOUT$offset = (OfLong) LAYOUT.select(PATH$offset);
    public static final OfLong LAYOUT$size = (OfLong) LAYOUT.select(PATH$size);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$srcAccessMask = LAYOUT$srcAccessMask.byteSize();
    public static final long SIZE$dstAccessMask = LAYOUT$dstAccessMask.byteSize();
    public static final long SIZE$srcQueueFamilyIndex = LAYOUT$srcQueueFamilyIndex.byteSize();
    public static final long SIZE$dstQueueFamilyIndex = LAYOUT$dstQueueFamilyIndex.byteSize();
    public static final long SIZE$buffer = LAYOUT$buffer.byteSize();
    public static final long SIZE$offset = LAYOUT$offset.byteSize();
    public static final long SIZE$size = LAYOUT$size.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$srcAccessMask = LAYOUT.byteOffset(PATH$srcAccessMask);
    public static final long OFFSET$dstAccessMask = LAYOUT.byteOffset(PATH$dstAccessMask);
    public static final long OFFSET$srcQueueFamilyIndex = LAYOUT.byteOffset(PATH$srcQueueFamilyIndex);
    public static final long OFFSET$dstQueueFamilyIndex = LAYOUT.byteOffset(PATH$dstQueueFamilyIndex);
    public static final long OFFSET$buffer = LAYOUT.byteOffset(PATH$buffer);
    public static final long OFFSET$offset = LAYOUT.byteOffset(PATH$offset);
    public static final long OFFSET$size = LAYOUT.byteOffset(PATH$size);
}
