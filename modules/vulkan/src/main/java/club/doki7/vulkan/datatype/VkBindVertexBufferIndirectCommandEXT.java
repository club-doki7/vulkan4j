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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBindVertexBufferIndirectCommandEXT.html"><code>VkBindVertexBufferIndirectCommandEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkBindVertexBufferIndirectCommandEXT {
///     VkDeviceAddress bufferAddress; // @link substring="bufferAddress" target="#bufferAddress"
///     uint32_t size; // @link substring="size" target="#size"
///     uint32_t stride; // @link substring="stride" target="#stride"
/// } VkBindVertexBufferIndirectCommandEXT;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBindVertexBufferIndirectCommandEXT.html"><code>VkBindVertexBufferIndirectCommandEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkBindVertexBufferIndirectCommandEXT(@NotNull MemorySegment segment) implements IVkBindVertexBufferIndirectCommandEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBindVertexBufferIndirectCommandEXT.html"><code>VkBindVertexBufferIndirectCommandEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkBindVertexBufferIndirectCommandEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkBindVertexBufferIndirectCommandEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkBindVertexBufferIndirectCommandEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkBindVertexBufferIndirectCommandEXT, Iterable<VkBindVertexBufferIndirectCommandEXT> {
        public long size() {
            return segment.byteSize() / VkBindVertexBufferIndirectCommandEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkBindVertexBufferIndirectCommandEXT at(long index) {
            return new VkBindVertexBufferIndirectCommandEXT(segment.asSlice(index * VkBindVertexBufferIndirectCommandEXT.BYTES, VkBindVertexBufferIndirectCommandEXT.BYTES));
        }

        public VkBindVertexBufferIndirectCommandEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkBindVertexBufferIndirectCommandEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkBindVertexBufferIndirectCommandEXT value) {
            MemorySegment s = segment.asSlice(index * VkBindVertexBufferIndirectCommandEXT.BYTES, VkBindVertexBufferIndirectCommandEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkBindVertexBufferIndirectCommandEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkBindVertexBufferIndirectCommandEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkBindVertexBufferIndirectCommandEXT.BYTES,
                (end - start) * VkBindVertexBufferIndirectCommandEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkBindVertexBufferIndirectCommandEXT.BYTES));
        }

        public VkBindVertexBufferIndirectCommandEXT[] toArray() {
            VkBindVertexBufferIndirectCommandEXT[] ret = new VkBindVertexBufferIndirectCommandEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkBindVertexBufferIndirectCommandEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkBindVertexBufferIndirectCommandEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkBindVertexBufferIndirectCommandEXT.BYTES;
            }

            @Override
            public VkBindVertexBufferIndirectCommandEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkBindVertexBufferIndirectCommandEXT ret = new VkBindVertexBufferIndirectCommandEXT(segment.asSlice(0, VkBindVertexBufferIndirectCommandEXT.BYTES));
                segment = segment.asSlice(VkBindVertexBufferIndirectCommandEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkBindVertexBufferIndirectCommandEXT allocate(Arena arena) {
        return new VkBindVertexBufferIndirectCommandEXT(arena.allocate(LAYOUT));
    }

    public static VkBindVertexBufferIndirectCommandEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkBindVertexBufferIndirectCommandEXT.Ptr(segment);
    }

    public static VkBindVertexBufferIndirectCommandEXT clone(Arena arena, VkBindVertexBufferIndirectCommandEXT src) {
        VkBindVertexBufferIndirectCommandEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NativeType("VkDeviceAddress") @Unsigned long bufferAddress() {
        return segment.get(LAYOUT$bufferAddress, OFFSET$bufferAddress);
    }

    public VkBindVertexBufferIndirectCommandEXT bufferAddress(@NativeType("VkDeviceAddress") @Unsigned long value) {
        segment.set(LAYOUT$bufferAddress, OFFSET$bufferAddress, value);
        return this;
    }

    public @Unsigned int size() {
        return segment.get(LAYOUT$size, OFFSET$size);
    }

    public VkBindVertexBufferIndirectCommandEXT size(@Unsigned int value) {
        segment.set(LAYOUT$size, OFFSET$size, value);
        return this;
    }

    public @Unsigned int stride() {
        return segment.get(LAYOUT$stride, OFFSET$stride);
    }

    public VkBindVertexBufferIndirectCommandEXT stride(@Unsigned int value) {
        segment.set(LAYOUT$stride, OFFSET$stride, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_LONG.withName("bufferAddress"),
        ValueLayout.JAVA_INT.withName("size"),
        ValueLayout.JAVA_INT.withName("stride")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$bufferAddress = PathElement.groupElement("bufferAddress");
    public static final PathElement PATH$size = PathElement.groupElement("size");
    public static final PathElement PATH$stride = PathElement.groupElement("stride");

    public static final OfLong LAYOUT$bufferAddress = (OfLong) LAYOUT.select(PATH$bufferAddress);
    public static final OfInt LAYOUT$size = (OfInt) LAYOUT.select(PATH$size);
    public static final OfInt LAYOUT$stride = (OfInt) LAYOUT.select(PATH$stride);

    public static final long SIZE$bufferAddress = LAYOUT$bufferAddress.byteSize();
    public static final long SIZE$size = LAYOUT$size.byteSize();
    public static final long SIZE$stride = LAYOUT$stride.byteSize();

    public static final long OFFSET$bufferAddress = LAYOUT.byteOffset(PATH$bufferAddress);
    public static final long OFFSET$size = LAYOUT.byteOffset(PATH$size);
    public static final long OFFSET$stride = LAYOUT.byteOffset(PATH$stride);
}
