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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAccelerationStructureMotionInstanceDataNV.html"><code>VkAccelerationStructureMotionInstanceDataNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef union VkAccelerationStructureMotionInstanceDataNV {
///     VkAccelerationStructureInstanceKHR staticInstance; // @link substring="VkAccelerationStructureInstanceKHR" target="VkAccelerationStructureInstanceKHR" @link substring="staticInstance" target="#staticInstance"
///     VkAccelerationStructureMatrixMotionInstanceNV matrixMotionInstance; // @link substring="VkAccelerationStructureMatrixMotionInstanceNV" target="VkAccelerationStructureMatrixMotionInstanceNV" @link substring="matrixMotionInstance" target="#matrixMotionInstance"
///     VkAccelerationStructureSRTMotionInstanceNV srtMotionInstance; // @link substring="VkAccelerationStructureSRTMotionInstanceNV" target="VkAccelerationStructureSRTMotionInstanceNV" @link substring="srtMotionInstance" target="#srtMotionInstance"
/// } VkAccelerationStructureMotionInstanceDataNV;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAccelerationStructureMotionInstanceDataNV.html"><code>VkAccelerationStructureMotionInstanceDataNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkAccelerationStructureMotionInstanceDataNV(@NotNull MemorySegment segment) implements IVkAccelerationStructureMotionInstanceDataNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAccelerationStructureMotionInstanceDataNV.html"><code>VkAccelerationStructureMotionInstanceDataNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkAccelerationStructureMotionInstanceDataNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkAccelerationStructureMotionInstanceDataNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkAccelerationStructureMotionInstanceDataNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkAccelerationStructureMotionInstanceDataNV, Iterable<VkAccelerationStructureMotionInstanceDataNV> {
        public long size() {
            return segment.byteSize() / VkAccelerationStructureMotionInstanceDataNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkAccelerationStructureMotionInstanceDataNV at(long index) {
            return new VkAccelerationStructureMotionInstanceDataNV(segment.asSlice(index * VkAccelerationStructureMotionInstanceDataNV.BYTES, VkAccelerationStructureMotionInstanceDataNV.BYTES));
        }

        public VkAccelerationStructureMotionInstanceDataNV.Ptr at(long index, @NotNull Consumer<@NotNull VkAccelerationStructureMotionInstanceDataNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkAccelerationStructureMotionInstanceDataNV value) {
            MemorySegment s = segment.asSlice(index * VkAccelerationStructureMotionInstanceDataNV.BYTES, VkAccelerationStructureMotionInstanceDataNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkAccelerationStructureMotionInstanceDataNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkAccelerationStructureMotionInstanceDataNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkAccelerationStructureMotionInstanceDataNV.BYTES,
                (end - start) * VkAccelerationStructureMotionInstanceDataNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkAccelerationStructureMotionInstanceDataNV.BYTES));
        }

        public VkAccelerationStructureMotionInstanceDataNV[] toArray() {
            VkAccelerationStructureMotionInstanceDataNV[] ret = new VkAccelerationStructureMotionInstanceDataNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkAccelerationStructureMotionInstanceDataNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkAccelerationStructureMotionInstanceDataNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkAccelerationStructureMotionInstanceDataNV.BYTES;
            }

            @Override
            public VkAccelerationStructureMotionInstanceDataNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkAccelerationStructureMotionInstanceDataNV ret = new VkAccelerationStructureMotionInstanceDataNV(segment.asSlice(0, VkAccelerationStructureMotionInstanceDataNV.BYTES));
                segment = segment.asSlice(VkAccelerationStructureMotionInstanceDataNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkAccelerationStructureMotionInstanceDataNV allocate(Arena arena) {
        return new VkAccelerationStructureMotionInstanceDataNV(arena.allocate(LAYOUT));
    }

    public static VkAccelerationStructureMotionInstanceDataNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkAccelerationStructureMotionInstanceDataNV.Ptr(segment);
    }

    public static VkAccelerationStructureMotionInstanceDataNV clone(Arena arena, VkAccelerationStructureMotionInstanceDataNV src) {
        VkAccelerationStructureMotionInstanceDataNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull VkAccelerationStructureInstanceKHR staticInstance() {
        return new VkAccelerationStructureInstanceKHR(segment.asSlice(OFFSET$staticInstance, LAYOUT$staticInstance));
    }

    public VkAccelerationStructureMotionInstanceDataNV staticInstance(@NotNull VkAccelerationStructureInstanceKHR value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$staticInstance, SIZE$staticInstance);
        return this;
    }

    public VkAccelerationStructureMotionInstanceDataNV staticInstance(Consumer<@NotNull VkAccelerationStructureInstanceKHR> consumer) {
        consumer.accept(staticInstance());
        return this;
    }

    public @NotNull VkAccelerationStructureMatrixMotionInstanceNV matrixMotionInstance() {
        return new VkAccelerationStructureMatrixMotionInstanceNV(segment.asSlice(OFFSET$matrixMotionInstance, LAYOUT$matrixMotionInstance));
    }

    public VkAccelerationStructureMotionInstanceDataNV matrixMotionInstance(@NotNull VkAccelerationStructureMatrixMotionInstanceNV value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$matrixMotionInstance, SIZE$matrixMotionInstance);
        return this;
    }

    public VkAccelerationStructureMotionInstanceDataNV matrixMotionInstance(Consumer<@NotNull VkAccelerationStructureMatrixMotionInstanceNV> consumer) {
        consumer.accept(matrixMotionInstance());
        return this;
    }

    public @NotNull VkAccelerationStructureSRTMotionInstanceNV srtMotionInstance() {
        return new VkAccelerationStructureSRTMotionInstanceNV(segment.asSlice(OFFSET$srtMotionInstance, LAYOUT$srtMotionInstance));
    }

    public VkAccelerationStructureMotionInstanceDataNV srtMotionInstance(@NotNull VkAccelerationStructureSRTMotionInstanceNV value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$srtMotionInstance, SIZE$srtMotionInstance);
        return this;
    }

    public VkAccelerationStructureMotionInstanceDataNV srtMotionInstance(Consumer<@NotNull VkAccelerationStructureSRTMotionInstanceNV> consumer) {
        consumer.accept(srtMotionInstance());
        return this;
    }

    public static final UnionLayout LAYOUT = NativeLayout.unionLayout(
        VkAccelerationStructureInstanceKHR.LAYOUT.withName("staticInstance"),
        VkAccelerationStructureMatrixMotionInstanceNV.LAYOUT.withName("matrixMotionInstance"),
        VkAccelerationStructureSRTMotionInstanceNV.LAYOUT.withName("srtMotionInstance")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$staticInstance = PathElement.groupElement("staticInstance");
    public static final PathElement PATH$matrixMotionInstance = PathElement.groupElement("matrixMotionInstance");
    public static final PathElement PATH$srtMotionInstance = PathElement.groupElement("srtMotionInstance");

    public static final StructLayout LAYOUT$staticInstance = (StructLayout) LAYOUT.select(PATH$staticInstance);
    public static final StructLayout LAYOUT$matrixMotionInstance = (StructLayout) LAYOUT.select(PATH$matrixMotionInstance);
    public static final StructLayout LAYOUT$srtMotionInstance = (StructLayout) LAYOUT.select(PATH$srtMotionInstance);

    public static final long SIZE$staticInstance = LAYOUT$staticInstance.byteSize();
    public static final long SIZE$matrixMotionInstance = LAYOUT$matrixMotionInstance.byteSize();
    public static final long SIZE$srtMotionInstance = LAYOUT$srtMotionInstance.byteSize();

    public static final long OFFSET$staticInstance = LAYOUT.byteOffset(PATH$staticInstance);
    public static final long OFFSET$matrixMotionInstance = LAYOUT.byteOffset(PATH$matrixMotionInstance);
    public static final long OFFSET$srtMotionInstance = LAYOUT.byteOffset(PATH$srtMotionInstance);
}
