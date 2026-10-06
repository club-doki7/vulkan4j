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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBindIndexBufferIndirectCommandEXT.html"><code>VkBindIndexBufferIndirectCommandEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkBindIndexBufferIndirectCommandEXT {
///     VkDeviceAddress bufferAddress; // @link substring="bufferAddress" target="#bufferAddress"
///     uint32_t size; // @link substring="size" target="#size"
///     VkIndexType indexType; // @link substring="VkIndexType" target="VkIndexType" @link substring="indexType" target="#indexType"
/// } VkBindIndexBufferIndirectCommandEXT;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBindIndexBufferIndirectCommandEXT.html"><code>VkBindIndexBufferIndirectCommandEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkBindIndexBufferIndirectCommandEXT(@NotNull MemorySegment segment) implements IVkBindIndexBufferIndirectCommandEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBindIndexBufferIndirectCommandEXT.html"><code>VkBindIndexBufferIndirectCommandEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkBindIndexBufferIndirectCommandEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkBindIndexBufferIndirectCommandEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkBindIndexBufferIndirectCommandEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkBindIndexBufferIndirectCommandEXT, Iterable<VkBindIndexBufferIndirectCommandEXT> {
        public long size() {
            return segment.byteSize() / VkBindIndexBufferIndirectCommandEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkBindIndexBufferIndirectCommandEXT at(long index) {
            return new VkBindIndexBufferIndirectCommandEXT(segment.asSlice(index * VkBindIndexBufferIndirectCommandEXT.BYTES, VkBindIndexBufferIndirectCommandEXT.BYTES));
        }

        public VkBindIndexBufferIndirectCommandEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkBindIndexBufferIndirectCommandEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkBindIndexBufferIndirectCommandEXT value) {
            MemorySegment s = segment.asSlice(index * VkBindIndexBufferIndirectCommandEXT.BYTES, VkBindIndexBufferIndirectCommandEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkBindIndexBufferIndirectCommandEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkBindIndexBufferIndirectCommandEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkBindIndexBufferIndirectCommandEXT.BYTES,
                (end - start) * VkBindIndexBufferIndirectCommandEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkBindIndexBufferIndirectCommandEXT.BYTES));
        }

        public VkBindIndexBufferIndirectCommandEXT[] toArray() {
            VkBindIndexBufferIndirectCommandEXT[] ret = new VkBindIndexBufferIndirectCommandEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkBindIndexBufferIndirectCommandEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkBindIndexBufferIndirectCommandEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkBindIndexBufferIndirectCommandEXT.BYTES;
            }

            @Override
            public VkBindIndexBufferIndirectCommandEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkBindIndexBufferIndirectCommandEXT ret = new VkBindIndexBufferIndirectCommandEXT(segment.asSlice(0, VkBindIndexBufferIndirectCommandEXT.BYTES));
                segment = segment.asSlice(VkBindIndexBufferIndirectCommandEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkBindIndexBufferIndirectCommandEXT allocate(Arena arena) {
        return new VkBindIndexBufferIndirectCommandEXT(arena.allocate(LAYOUT));
    }

    public static VkBindIndexBufferIndirectCommandEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkBindIndexBufferIndirectCommandEXT.Ptr(segment);
    }

    public static VkBindIndexBufferIndirectCommandEXT clone(Arena arena, VkBindIndexBufferIndirectCommandEXT src) {
        VkBindIndexBufferIndirectCommandEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NativeType("VkDeviceAddress") @Unsigned long bufferAddress() {
        return segment.get(LAYOUT$bufferAddress, OFFSET$bufferAddress);
    }

    public VkBindIndexBufferIndirectCommandEXT bufferAddress(@NativeType("VkDeviceAddress") @Unsigned long value) {
        segment.set(LAYOUT$bufferAddress, OFFSET$bufferAddress, value);
        return this;
    }

    public @Unsigned int size() {
        return segment.get(LAYOUT$size, OFFSET$size);
    }

    public VkBindIndexBufferIndirectCommandEXT size(@Unsigned int value) {
        segment.set(LAYOUT$size, OFFSET$size, value);
        return this;
    }

    public @EnumType(VkIndexType.class) int indexType() {
        return segment.get(LAYOUT$indexType, OFFSET$indexType);
    }

    public VkBindIndexBufferIndirectCommandEXT indexType(@EnumType(VkIndexType.class) int value) {
        segment.set(LAYOUT$indexType, OFFSET$indexType, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_LONG.withName("bufferAddress"),
        ValueLayout.JAVA_INT.withName("size"),
        ValueLayout.JAVA_INT.withName("indexType")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$bufferAddress = PathElement.groupElement("bufferAddress");
    public static final PathElement PATH$size = PathElement.groupElement("size");
    public static final PathElement PATH$indexType = PathElement.groupElement("indexType");

    public static final OfLong LAYOUT$bufferAddress = (OfLong) LAYOUT.select(PATH$bufferAddress);
    public static final OfInt LAYOUT$size = (OfInt) LAYOUT.select(PATH$size);
    public static final OfInt LAYOUT$indexType = (OfInt) LAYOUT.select(PATH$indexType);

    public static final long SIZE$bufferAddress = LAYOUT$bufferAddress.byteSize();
    public static final long SIZE$size = LAYOUT$size.byteSize();
    public static final long SIZE$indexType = LAYOUT$indexType.byteSize();

    public static final long OFFSET$bufferAddress = LAYOUT.byteOffset(PATH$bufferAddress);
    public static final long OFFSET$size = LAYOUT.byteOffset(PATH$size);
    public static final long OFFSET$indexType = LAYOUT.byteOffset(PATH$indexType);
}
