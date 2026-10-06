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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAccelerationStructureBuildRangeInfoKHR.html"><code>VkAccelerationStructureBuildRangeInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkAccelerationStructureBuildRangeInfoKHR {
///     uint32_t primitiveCount; // @link substring="primitiveCount" target="#primitiveCount"
///     uint32_t primitiveOffset; // @link substring="primitiveOffset" target="#primitiveOffset"
///     uint32_t firstVertex; // @link substring="firstVertex" target="#firstVertex"
///     uint32_t transformOffset; // @link substring="transformOffset" target="#transformOffset"
/// } VkAccelerationStructureBuildRangeInfoKHR;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAccelerationStructureBuildRangeInfoKHR.html"><code>VkAccelerationStructureBuildRangeInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkAccelerationStructureBuildRangeInfoKHR(@NotNull MemorySegment segment) implements IVkAccelerationStructureBuildRangeInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAccelerationStructureBuildRangeInfoKHR.html"><code>VkAccelerationStructureBuildRangeInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkAccelerationStructureBuildRangeInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkAccelerationStructureBuildRangeInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkAccelerationStructureBuildRangeInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkAccelerationStructureBuildRangeInfoKHR, Iterable<VkAccelerationStructureBuildRangeInfoKHR> {
        public long size() {
            return segment.byteSize() / VkAccelerationStructureBuildRangeInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkAccelerationStructureBuildRangeInfoKHR at(long index) {
            return new VkAccelerationStructureBuildRangeInfoKHR(segment.asSlice(index * VkAccelerationStructureBuildRangeInfoKHR.BYTES, VkAccelerationStructureBuildRangeInfoKHR.BYTES));
        }

        public VkAccelerationStructureBuildRangeInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkAccelerationStructureBuildRangeInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkAccelerationStructureBuildRangeInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkAccelerationStructureBuildRangeInfoKHR.BYTES, VkAccelerationStructureBuildRangeInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkAccelerationStructureBuildRangeInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkAccelerationStructureBuildRangeInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkAccelerationStructureBuildRangeInfoKHR.BYTES,
                (end - start) * VkAccelerationStructureBuildRangeInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkAccelerationStructureBuildRangeInfoKHR.BYTES));
        }

        public VkAccelerationStructureBuildRangeInfoKHR[] toArray() {
            VkAccelerationStructureBuildRangeInfoKHR[] ret = new VkAccelerationStructureBuildRangeInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkAccelerationStructureBuildRangeInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkAccelerationStructureBuildRangeInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkAccelerationStructureBuildRangeInfoKHR.BYTES;
            }

            @Override
            public VkAccelerationStructureBuildRangeInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkAccelerationStructureBuildRangeInfoKHR ret = new VkAccelerationStructureBuildRangeInfoKHR(segment.asSlice(0, VkAccelerationStructureBuildRangeInfoKHR.BYTES));
                segment = segment.asSlice(VkAccelerationStructureBuildRangeInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkAccelerationStructureBuildRangeInfoKHR allocate(Arena arena) {
        return new VkAccelerationStructureBuildRangeInfoKHR(arena.allocate(LAYOUT));
    }

    public static VkAccelerationStructureBuildRangeInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkAccelerationStructureBuildRangeInfoKHR.Ptr(segment);
    }

    public static VkAccelerationStructureBuildRangeInfoKHR clone(Arena arena, VkAccelerationStructureBuildRangeInfoKHR src) {
        VkAccelerationStructureBuildRangeInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned int primitiveCount() {
        return segment.get(LAYOUT$primitiveCount, OFFSET$primitiveCount);
    }

    public VkAccelerationStructureBuildRangeInfoKHR primitiveCount(@Unsigned int value) {
        segment.set(LAYOUT$primitiveCount, OFFSET$primitiveCount, value);
        return this;
    }

    public @Unsigned int primitiveOffset() {
        return segment.get(LAYOUT$primitiveOffset, OFFSET$primitiveOffset);
    }

    public VkAccelerationStructureBuildRangeInfoKHR primitiveOffset(@Unsigned int value) {
        segment.set(LAYOUT$primitiveOffset, OFFSET$primitiveOffset, value);
        return this;
    }

    public @Unsigned int firstVertex() {
        return segment.get(LAYOUT$firstVertex, OFFSET$firstVertex);
    }

    public VkAccelerationStructureBuildRangeInfoKHR firstVertex(@Unsigned int value) {
        segment.set(LAYOUT$firstVertex, OFFSET$firstVertex, value);
        return this;
    }

    public @Unsigned int transformOffset() {
        return segment.get(LAYOUT$transformOffset, OFFSET$transformOffset);
    }

    public VkAccelerationStructureBuildRangeInfoKHR transformOffset(@Unsigned int value) {
        segment.set(LAYOUT$transformOffset, OFFSET$transformOffset, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("primitiveCount"),
        ValueLayout.JAVA_INT.withName("primitiveOffset"),
        ValueLayout.JAVA_INT.withName("firstVertex"),
        ValueLayout.JAVA_INT.withName("transformOffset")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$primitiveCount = PathElement.groupElement("primitiveCount");
    public static final PathElement PATH$primitiveOffset = PathElement.groupElement("primitiveOffset");
    public static final PathElement PATH$firstVertex = PathElement.groupElement("firstVertex");
    public static final PathElement PATH$transformOffset = PathElement.groupElement("transformOffset");

    public static final OfInt LAYOUT$primitiveCount = (OfInt) LAYOUT.select(PATH$primitiveCount);
    public static final OfInt LAYOUT$primitiveOffset = (OfInt) LAYOUT.select(PATH$primitiveOffset);
    public static final OfInt LAYOUT$firstVertex = (OfInt) LAYOUT.select(PATH$firstVertex);
    public static final OfInt LAYOUT$transformOffset = (OfInt) LAYOUT.select(PATH$transformOffset);

    public static final long SIZE$primitiveCount = LAYOUT$primitiveCount.byteSize();
    public static final long SIZE$primitiveOffset = LAYOUT$primitiveOffset.byteSize();
    public static final long SIZE$firstVertex = LAYOUT$firstVertex.byteSize();
    public static final long SIZE$transformOffset = LAYOUT$transformOffset.byteSize();

    public static final long OFFSET$primitiveCount = LAYOUT.byteOffset(PATH$primitiveCount);
    public static final long OFFSET$primitiveOffset = LAYOUT.byteOffset(PATH$primitiveOffset);
    public static final long OFFSET$firstVertex = LAYOUT.byteOffset(PATH$firstVertex);
    public static final long OFFSET$transformOffset = LAYOUT.byteOffset(PATH$transformOffset);
}
