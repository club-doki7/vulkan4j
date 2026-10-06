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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDrawIndexedIndirectCommand.html"><code>VkDrawIndexedIndirectCommand</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDrawIndexedIndirectCommand {
///     uint32_t indexCount; // @link substring="indexCount" target="#indexCount"
///     uint32_t instanceCount; // @link substring="instanceCount" target="#instanceCount"
///     uint32_t firstIndex; // @link substring="firstIndex" target="#firstIndex"
///     int32_t vertexOffset; // @link substring="vertexOffset" target="#vertexOffset"
///     uint32_t firstInstance; // @link substring="firstInstance" target="#firstInstance"
/// } VkDrawIndexedIndirectCommand;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDrawIndexedIndirectCommand.html"><code>VkDrawIndexedIndirectCommand</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDrawIndexedIndirectCommand(@NotNull MemorySegment segment) implements IVkDrawIndexedIndirectCommand {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDrawIndexedIndirectCommand.html"><code>VkDrawIndexedIndirectCommand</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDrawIndexedIndirectCommand}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDrawIndexedIndirectCommand to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDrawIndexedIndirectCommand.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDrawIndexedIndirectCommand, Iterable<VkDrawIndexedIndirectCommand> {
        public long size() {
            return segment.byteSize() / VkDrawIndexedIndirectCommand.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDrawIndexedIndirectCommand at(long index) {
            return new VkDrawIndexedIndirectCommand(segment.asSlice(index * VkDrawIndexedIndirectCommand.BYTES, VkDrawIndexedIndirectCommand.BYTES));
        }

        public VkDrawIndexedIndirectCommand.Ptr at(long index, @NotNull Consumer<@NotNull VkDrawIndexedIndirectCommand> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDrawIndexedIndirectCommand value) {
            MemorySegment s = segment.asSlice(index * VkDrawIndexedIndirectCommand.BYTES, VkDrawIndexedIndirectCommand.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDrawIndexedIndirectCommand.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDrawIndexedIndirectCommand.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDrawIndexedIndirectCommand.BYTES,
                (end - start) * VkDrawIndexedIndirectCommand.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDrawIndexedIndirectCommand.BYTES));
        }

        public VkDrawIndexedIndirectCommand[] toArray() {
            VkDrawIndexedIndirectCommand[] ret = new VkDrawIndexedIndirectCommand[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDrawIndexedIndirectCommand> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDrawIndexedIndirectCommand> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDrawIndexedIndirectCommand.BYTES;
            }

            @Override
            public VkDrawIndexedIndirectCommand next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDrawIndexedIndirectCommand ret = new VkDrawIndexedIndirectCommand(segment.asSlice(0, VkDrawIndexedIndirectCommand.BYTES));
                segment = segment.asSlice(VkDrawIndexedIndirectCommand.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDrawIndexedIndirectCommand allocate(Arena arena) {
        return new VkDrawIndexedIndirectCommand(arena.allocate(LAYOUT));
    }

    public static VkDrawIndexedIndirectCommand.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkDrawIndexedIndirectCommand.Ptr(segment);
    }

    public static VkDrawIndexedIndirectCommand clone(Arena arena, VkDrawIndexedIndirectCommand src) {
        VkDrawIndexedIndirectCommand ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned int indexCount() {
        return segment.get(LAYOUT$indexCount, OFFSET$indexCount);
    }

    public VkDrawIndexedIndirectCommand indexCount(@Unsigned int value) {
        segment.set(LAYOUT$indexCount, OFFSET$indexCount, value);
        return this;
    }

    public @Unsigned int instanceCount() {
        return segment.get(LAYOUT$instanceCount, OFFSET$instanceCount);
    }

    public VkDrawIndexedIndirectCommand instanceCount(@Unsigned int value) {
        segment.set(LAYOUT$instanceCount, OFFSET$instanceCount, value);
        return this;
    }

    public @Unsigned int firstIndex() {
        return segment.get(LAYOUT$firstIndex, OFFSET$firstIndex);
    }

    public VkDrawIndexedIndirectCommand firstIndex(@Unsigned int value) {
        segment.set(LAYOUT$firstIndex, OFFSET$firstIndex, value);
        return this;
    }

    public int vertexOffset() {
        return segment.get(LAYOUT$vertexOffset, OFFSET$vertexOffset);
    }

    public VkDrawIndexedIndirectCommand vertexOffset(int value) {
        segment.set(LAYOUT$vertexOffset, OFFSET$vertexOffset, value);
        return this;
    }

    public @Unsigned int firstInstance() {
        return segment.get(LAYOUT$firstInstance, OFFSET$firstInstance);
    }

    public VkDrawIndexedIndirectCommand firstInstance(@Unsigned int value) {
        segment.set(LAYOUT$firstInstance, OFFSET$firstInstance, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("indexCount"),
        ValueLayout.JAVA_INT.withName("instanceCount"),
        ValueLayout.JAVA_INT.withName("firstIndex"),
        ValueLayout.JAVA_INT.withName("vertexOffset"),
        ValueLayout.JAVA_INT.withName("firstInstance")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$indexCount = PathElement.groupElement("indexCount");
    public static final PathElement PATH$instanceCount = PathElement.groupElement("instanceCount");
    public static final PathElement PATH$firstIndex = PathElement.groupElement("firstIndex");
    public static final PathElement PATH$vertexOffset = PathElement.groupElement("vertexOffset");
    public static final PathElement PATH$firstInstance = PathElement.groupElement("firstInstance");

    public static final OfInt LAYOUT$indexCount = (OfInt) LAYOUT.select(PATH$indexCount);
    public static final OfInt LAYOUT$instanceCount = (OfInt) LAYOUT.select(PATH$instanceCount);
    public static final OfInt LAYOUT$firstIndex = (OfInt) LAYOUT.select(PATH$firstIndex);
    public static final OfInt LAYOUT$vertexOffset = (OfInt) LAYOUT.select(PATH$vertexOffset);
    public static final OfInt LAYOUT$firstInstance = (OfInt) LAYOUT.select(PATH$firstInstance);

    public static final long SIZE$indexCount = LAYOUT$indexCount.byteSize();
    public static final long SIZE$instanceCount = LAYOUT$instanceCount.byteSize();
    public static final long SIZE$firstIndex = LAYOUT$firstIndex.byteSize();
    public static final long SIZE$vertexOffset = LAYOUT$vertexOffset.byteSize();
    public static final long SIZE$firstInstance = LAYOUT$firstInstance.byteSize();

    public static final long OFFSET$indexCount = LAYOUT.byteOffset(PATH$indexCount);
    public static final long OFFSET$instanceCount = LAYOUT.byteOffset(PATH$instanceCount);
    public static final long OFFSET$firstIndex = LAYOUT.byteOffset(PATH$firstIndex);
    public static final long OFFSET$vertexOffset = LAYOUT.byteOffset(PATH$vertexOffset);
    public static final long OFFSET$firstInstance = LAYOUT.byteOffset(PATH$firstInstance);
}
