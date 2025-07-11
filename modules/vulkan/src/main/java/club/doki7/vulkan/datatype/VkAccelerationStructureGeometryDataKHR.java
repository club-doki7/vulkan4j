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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAccelerationStructureGeometryDataKHR.html"><code>VkAccelerationStructureGeometryDataKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef union VkAccelerationStructureGeometryDataKHR {
///     VkAccelerationStructureGeometryTrianglesDataKHR triangles; // @link substring="VkAccelerationStructureGeometryTrianglesDataKHR" target="VkAccelerationStructureGeometryTrianglesDataKHR" @link substring="triangles" target="#triangles"
///     VkAccelerationStructureGeometryAabbsDataKHR aabbs; // @link substring="VkAccelerationStructureGeometryAabbsDataKHR" target="VkAccelerationStructureGeometryAabbsDataKHR" @link substring="aabbs" target="#aabbs"
///     VkAccelerationStructureGeometryInstancesDataKHR instances; // @link substring="VkAccelerationStructureGeometryInstancesDataKHR" target="VkAccelerationStructureGeometryInstancesDataKHR" @link substring="instances" target="#instances"
/// } VkAccelerationStructureGeometryDataKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `triangles.autoInit()`
/// - `aabbs.autoInit()`
/// - `instances.autoInit()`
///
/// The {@code allocate} ({@link VkAccelerationStructureGeometryDataKHR#allocate(Arena)}, {@link VkAccelerationStructureGeometryDataKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkAccelerationStructureGeometryDataKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAccelerationStructureGeometryDataKHR.html"><code>VkAccelerationStructureGeometryDataKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkAccelerationStructureGeometryDataKHR(@NotNull MemorySegment segment) implements IVkAccelerationStructureGeometryDataKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAccelerationStructureGeometryDataKHR.html"><code>VkAccelerationStructureGeometryDataKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkAccelerationStructureGeometryDataKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkAccelerationStructureGeometryDataKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkAccelerationStructureGeometryDataKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkAccelerationStructureGeometryDataKHR, Iterable<VkAccelerationStructureGeometryDataKHR> {
        public long size() {
            return segment.byteSize() / VkAccelerationStructureGeometryDataKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkAccelerationStructureGeometryDataKHR at(long index) {
            return new VkAccelerationStructureGeometryDataKHR(segment.asSlice(index * VkAccelerationStructureGeometryDataKHR.BYTES, VkAccelerationStructureGeometryDataKHR.BYTES));
        }

        public VkAccelerationStructureGeometryDataKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkAccelerationStructureGeometryDataKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkAccelerationStructureGeometryDataKHR value) {
            MemorySegment s = segment.asSlice(index * VkAccelerationStructureGeometryDataKHR.BYTES, VkAccelerationStructureGeometryDataKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkAccelerationStructureGeometryDataKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkAccelerationStructureGeometryDataKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkAccelerationStructureGeometryDataKHR.BYTES,
                (end - start) * VkAccelerationStructureGeometryDataKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkAccelerationStructureGeometryDataKHR.BYTES));
        }

        public VkAccelerationStructureGeometryDataKHR[] toArray() {
            VkAccelerationStructureGeometryDataKHR[] ret = new VkAccelerationStructureGeometryDataKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkAccelerationStructureGeometryDataKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkAccelerationStructureGeometryDataKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkAccelerationStructureGeometryDataKHR.BYTES;
            }

            @Override
            public VkAccelerationStructureGeometryDataKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkAccelerationStructureGeometryDataKHR ret = new VkAccelerationStructureGeometryDataKHR(segment.asSlice(0, VkAccelerationStructureGeometryDataKHR.BYTES));
                segment = segment.asSlice(VkAccelerationStructureGeometryDataKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkAccelerationStructureGeometryDataKHR allocate(Arena arena) {
        VkAccelerationStructureGeometryDataKHR ret = new VkAccelerationStructureGeometryDataKHR(arena.allocate(LAYOUT));
        ret.autoInit();
        return ret;
    }

    public static VkAccelerationStructureGeometryDataKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkAccelerationStructureGeometryDataKHR.Ptr ret = new VkAccelerationStructureGeometryDataKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).autoInit();
        }
        return ret;
    }

    public static VkAccelerationStructureGeometryDataKHR clone(Arena arena, VkAccelerationStructureGeometryDataKHR src) {
        VkAccelerationStructureGeometryDataKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        triangles().autoInit();
        aabbs().autoInit();
        instances().autoInit();
    }

    public @NotNull VkAccelerationStructureGeometryTrianglesDataKHR triangles() {
        return new VkAccelerationStructureGeometryTrianglesDataKHR(segment.asSlice(OFFSET$triangles, LAYOUT$triangles));
    }

    public VkAccelerationStructureGeometryDataKHR triangles(@NotNull VkAccelerationStructureGeometryTrianglesDataKHR value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$triangles, SIZE$triangles);
        return this;
    }

    public VkAccelerationStructureGeometryDataKHR triangles(Consumer<@NotNull VkAccelerationStructureGeometryTrianglesDataKHR> consumer) {
        consumer.accept(triangles());
        return this;
    }

    public @NotNull VkAccelerationStructureGeometryAabbsDataKHR aabbs() {
        return new VkAccelerationStructureGeometryAabbsDataKHR(segment.asSlice(OFFSET$aabbs, LAYOUT$aabbs));
    }

    public VkAccelerationStructureGeometryDataKHR aabbs(@NotNull VkAccelerationStructureGeometryAabbsDataKHR value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$aabbs, SIZE$aabbs);
        return this;
    }

    public VkAccelerationStructureGeometryDataKHR aabbs(Consumer<@NotNull VkAccelerationStructureGeometryAabbsDataKHR> consumer) {
        consumer.accept(aabbs());
        return this;
    }

    public @NotNull VkAccelerationStructureGeometryInstancesDataKHR instances() {
        return new VkAccelerationStructureGeometryInstancesDataKHR(segment.asSlice(OFFSET$instances, LAYOUT$instances));
    }

    public VkAccelerationStructureGeometryDataKHR instances(@NotNull VkAccelerationStructureGeometryInstancesDataKHR value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$instances, SIZE$instances);
        return this;
    }

    public VkAccelerationStructureGeometryDataKHR instances(Consumer<@NotNull VkAccelerationStructureGeometryInstancesDataKHR> consumer) {
        consumer.accept(instances());
        return this;
    }

    public static final UnionLayout LAYOUT = NativeLayout.unionLayout(
        VkAccelerationStructureGeometryTrianglesDataKHR.LAYOUT.withName("triangles"),
        VkAccelerationStructureGeometryAabbsDataKHR.LAYOUT.withName("aabbs"),
        VkAccelerationStructureGeometryInstancesDataKHR.LAYOUT.withName("instances")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$triangles = PathElement.groupElement("triangles");
    public static final PathElement PATH$aabbs = PathElement.groupElement("aabbs");
    public static final PathElement PATH$instances = PathElement.groupElement("instances");

    public static final StructLayout LAYOUT$triangles = (StructLayout) LAYOUT.select(PATH$triangles);
    public static final StructLayout LAYOUT$aabbs = (StructLayout) LAYOUT.select(PATH$aabbs);
    public static final StructLayout LAYOUT$instances = (StructLayout) LAYOUT.select(PATH$instances);

    public static final long SIZE$triangles = LAYOUT$triangles.byteSize();
    public static final long SIZE$aabbs = LAYOUT$aabbs.byteSize();
    public static final long SIZE$instances = LAYOUT$instances.byteSize();

    public static final long OFFSET$triangles = LAYOUT.byteOffset(PATH$triangles);
    public static final long OFFSET$aabbs = LAYOUT.byteOffset(PATH$aabbs);
    public static final long OFFSET$instances = LAYOUT.byteOffset(PATH$instances);
}
