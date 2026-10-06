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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBufferCopy.html"><code>VkBufferCopy</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkBufferCopy {
///     VkDeviceSize srcOffset; // @link substring="srcOffset" target="#srcOffset"
///     VkDeviceSize dstOffset; // @link substring="dstOffset" target="#dstOffset"
///     VkDeviceSize size; // @link substring="size" target="#size"
/// } VkBufferCopy;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBufferCopy.html"><code>VkBufferCopy</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkBufferCopy(@NotNull MemorySegment segment) implements IVkBufferCopy {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBufferCopy.html"><code>VkBufferCopy</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkBufferCopy}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkBufferCopy to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkBufferCopy.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkBufferCopy, Iterable<VkBufferCopy> {
        public long size() {
            return segment.byteSize() / VkBufferCopy.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkBufferCopy at(long index) {
            return new VkBufferCopy(segment.asSlice(index * VkBufferCopy.BYTES, VkBufferCopy.BYTES));
        }

        public VkBufferCopy.Ptr at(long index, @NotNull Consumer<@NotNull VkBufferCopy> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkBufferCopy value) {
            MemorySegment s = segment.asSlice(index * VkBufferCopy.BYTES, VkBufferCopy.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkBufferCopy.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkBufferCopy.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkBufferCopy.BYTES,
                (end - start) * VkBufferCopy.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkBufferCopy.BYTES));
        }

        public VkBufferCopy[] toArray() {
            VkBufferCopy[] ret = new VkBufferCopy[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkBufferCopy> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkBufferCopy> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkBufferCopy.BYTES;
            }

            @Override
            public VkBufferCopy next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkBufferCopy ret = new VkBufferCopy(segment.asSlice(0, VkBufferCopy.BYTES));
                segment = segment.asSlice(VkBufferCopy.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkBufferCopy allocate(Arena arena) {
        return new VkBufferCopy(arena.allocate(LAYOUT));
    }

    public static VkBufferCopy.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkBufferCopy.Ptr(segment);
    }

    public static VkBufferCopy clone(Arena arena, VkBufferCopy src) {
        VkBufferCopy ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NativeType("VkDeviceSize") @Unsigned long srcOffset() {
        return segment.get(LAYOUT$srcOffset, OFFSET$srcOffset);
    }

    public VkBufferCopy srcOffset(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$srcOffset, OFFSET$srcOffset, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long dstOffset() {
        return segment.get(LAYOUT$dstOffset, OFFSET$dstOffset);
    }

    public VkBufferCopy dstOffset(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$dstOffset, OFFSET$dstOffset, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long size() {
        return segment.get(LAYOUT$size, OFFSET$size);
    }

    public VkBufferCopy size(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$size, OFFSET$size, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_LONG.withName("srcOffset"),
        ValueLayout.JAVA_LONG.withName("dstOffset"),
        ValueLayout.JAVA_LONG.withName("size")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$srcOffset = PathElement.groupElement("srcOffset");
    public static final PathElement PATH$dstOffset = PathElement.groupElement("dstOffset");
    public static final PathElement PATH$size = PathElement.groupElement("size");

    public static final OfLong LAYOUT$srcOffset = (OfLong) LAYOUT.select(PATH$srcOffset);
    public static final OfLong LAYOUT$dstOffset = (OfLong) LAYOUT.select(PATH$dstOffset);
    public static final OfLong LAYOUT$size = (OfLong) LAYOUT.select(PATH$size);

    public static final long SIZE$srcOffset = LAYOUT$srcOffset.byteSize();
    public static final long SIZE$dstOffset = LAYOUT$dstOffset.byteSize();
    public static final long SIZE$size = LAYOUT$size.byteSize();

    public static final long OFFSET$srcOffset = LAYOUT.byteOffset(PATH$srcOffset);
    public static final long OFFSET$dstOffset = LAYOUT.byteOffset(PATH$dstOffset);
    public static final long OFFSET$size = LAYOUT.byteOffset(PATH$size);
}
