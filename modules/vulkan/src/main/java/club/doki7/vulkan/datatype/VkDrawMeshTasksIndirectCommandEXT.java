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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDrawMeshTasksIndirectCommandEXT.html"><code>VkDrawMeshTasksIndirectCommandEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDrawMeshTasksIndirectCommandEXT {
///     uint32_t groupCountX; // @link substring="groupCountX" target="#groupCountX"
///     uint32_t groupCountY; // @link substring="groupCountY" target="#groupCountY"
///     uint32_t groupCountZ; // @link substring="groupCountZ" target="#groupCountZ"
/// } VkDrawMeshTasksIndirectCommandEXT;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDrawMeshTasksIndirectCommandEXT.html"><code>VkDrawMeshTasksIndirectCommandEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDrawMeshTasksIndirectCommandEXT(@NotNull MemorySegment segment) implements IVkDrawMeshTasksIndirectCommandEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDrawMeshTasksIndirectCommandEXT.html"><code>VkDrawMeshTasksIndirectCommandEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDrawMeshTasksIndirectCommandEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDrawMeshTasksIndirectCommandEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDrawMeshTasksIndirectCommandEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDrawMeshTasksIndirectCommandEXT, Iterable<VkDrawMeshTasksIndirectCommandEXT> {
        public long size() {
            return segment.byteSize() / VkDrawMeshTasksIndirectCommandEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDrawMeshTasksIndirectCommandEXT at(long index) {
            return new VkDrawMeshTasksIndirectCommandEXT(segment.asSlice(index * VkDrawMeshTasksIndirectCommandEXT.BYTES, VkDrawMeshTasksIndirectCommandEXT.BYTES));
        }

        public VkDrawMeshTasksIndirectCommandEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkDrawMeshTasksIndirectCommandEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDrawMeshTasksIndirectCommandEXT value) {
            MemorySegment s = segment.asSlice(index * VkDrawMeshTasksIndirectCommandEXT.BYTES, VkDrawMeshTasksIndirectCommandEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDrawMeshTasksIndirectCommandEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDrawMeshTasksIndirectCommandEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDrawMeshTasksIndirectCommandEXT.BYTES,
                (end - start) * VkDrawMeshTasksIndirectCommandEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDrawMeshTasksIndirectCommandEXT.BYTES));
        }

        public VkDrawMeshTasksIndirectCommandEXT[] toArray() {
            VkDrawMeshTasksIndirectCommandEXT[] ret = new VkDrawMeshTasksIndirectCommandEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDrawMeshTasksIndirectCommandEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDrawMeshTasksIndirectCommandEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDrawMeshTasksIndirectCommandEXT.BYTES;
            }

            @Override
            public VkDrawMeshTasksIndirectCommandEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDrawMeshTasksIndirectCommandEXT ret = new VkDrawMeshTasksIndirectCommandEXT(segment.asSlice(0, VkDrawMeshTasksIndirectCommandEXT.BYTES));
                segment = segment.asSlice(VkDrawMeshTasksIndirectCommandEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDrawMeshTasksIndirectCommandEXT allocate(Arena arena) {
        return new VkDrawMeshTasksIndirectCommandEXT(arena.allocate(LAYOUT));
    }

    public static VkDrawMeshTasksIndirectCommandEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkDrawMeshTasksIndirectCommandEXT.Ptr(segment);
    }

    public static VkDrawMeshTasksIndirectCommandEXT clone(Arena arena, VkDrawMeshTasksIndirectCommandEXT src) {
        VkDrawMeshTasksIndirectCommandEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned int groupCountX() {
        return segment.get(LAYOUT$groupCountX, OFFSET$groupCountX);
    }

    public VkDrawMeshTasksIndirectCommandEXT groupCountX(@Unsigned int value) {
        segment.set(LAYOUT$groupCountX, OFFSET$groupCountX, value);
        return this;
    }

    public @Unsigned int groupCountY() {
        return segment.get(LAYOUT$groupCountY, OFFSET$groupCountY);
    }

    public VkDrawMeshTasksIndirectCommandEXT groupCountY(@Unsigned int value) {
        segment.set(LAYOUT$groupCountY, OFFSET$groupCountY, value);
        return this;
    }

    public @Unsigned int groupCountZ() {
        return segment.get(LAYOUT$groupCountZ, OFFSET$groupCountZ);
    }

    public VkDrawMeshTasksIndirectCommandEXT groupCountZ(@Unsigned int value) {
        segment.set(LAYOUT$groupCountZ, OFFSET$groupCountZ, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("groupCountX"),
        ValueLayout.JAVA_INT.withName("groupCountY"),
        ValueLayout.JAVA_INT.withName("groupCountZ")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$groupCountX = PathElement.groupElement("groupCountX");
    public static final PathElement PATH$groupCountY = PathElement.groupElement("groupCountY");
    public static final PathElement PATH$groupCountZ = PathElement.groupElement("groupCountZ");

    public static final OfInt LAYOUT$groupCountX = (OfInt) LAYOUT.select(PATH$groupCountX);
    public static final OfInt LAYOUT$groupCountY = (OfInt) LAYOUT.select(PATH$groupCountY);
    public static final OfInt LAYOUT$groupCountZ = (OfInt) LAYOUT.select(PATH$groupCountZ);

    public static final long SIZE$groupCountX = LAYOUT$groupCountX.byteSize();
    public static final long SIZE$groupCountY = LAYOUT$groupCountY.byteSize();
    public static final long SIZE$groupCountZ = LAYOUT$groupCountZ.byteSize();

    public static final long OFFSET$groupCountX = LAYOUT.byteOffset(PATH$groupCountX);
    public static final long OFFSET$groupCountY = LAYOUT.byteOffset(PATH$groupCountY);
    public static final long OFFSET$groupCountZ = LAYOUT.byteOffset(PATH$groupCountZ);
}
