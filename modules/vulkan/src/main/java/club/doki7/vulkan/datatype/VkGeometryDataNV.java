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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGeometryDataNV.html"><code>VkGeometryDataNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkGeometryDataNV {
///     VkGeometryTrianglesNV triangles; // @link substring="VkGeometryTrianglesNV" target="VkGeometryTrianglesNV" @link substring="triangles" target="#triangles"
///     VkGeometryAABBNV aabbs; // @link substring="VkGeometryAABBNV" target="VkGeometryAABBNV" @link substring="aabbs" target="#aabbs"
/// } VkGeometryDataNV;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `triangles.autoInit()`
/// - `aabbs.autoInit()`
///
/// The {@code allocate} ({@link VkGeometryDataNV#allocate(Arena)}, {@link VkGeometryDataNV#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkGeometryDataNV#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGeometryDataNV.html"><code>VkGeometryDataNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkGeometryDataNV(@NotNull MemorySegment segment) implements IVkGeometryDataNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGeometryDataNV.html"><code>VkGeometryDataNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkGeometryDataNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkGeometryDataNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkGeometryDataNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkGeometryDataNV, Iterable<VkGeometryDataNV> {
        public long size() {
            return segment.byteSize() / VkGeometryDataNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkGeometryDataNV at(long index) {
            return new VkGeometryDataNV(segment.asSlice(index * VkGeometryDataNV.BYTES, VkGeometryDataNV.BYTES));
        }

        public VkGeometryDataNV.Ptr at(long index, @NotNull Consumer<@NotNull VkGeometryDataNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkGeometryDataNV value) {
            MemorySegment s = segment.asSlice(index * VkGeometryDataNV.BYTES, VkGeometryDataNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkGeometryDataNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkGeometryDataNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkGeometryDataNV.BYTES,
                (end - start) * VkGeometryDataNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkGeometryDataNV.BYTES));
        }

        public VkGeometryDataNV[] toArray() {
            VkGeometryDataNV[] ret = new VkGeometryDataNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkGeometryDataNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkGeometryDataNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkGeometryDataNV.BYTES;
            }

            @Override
            public VkGeometryDataNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkGeometryDataNV ret = new VkGeometryDataNV(segment.asSlice(0, VkGeometryDataNV.BYTES));
                segment = segment.asSlice(VkGeometryDataNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkGeometryDataNV allocate(Arena arena) {
        VkGeometryDataNV ret = new VkGeometryDataNV(arena.allocate(LAYOUT));
        ret.autoInit();
        return ret;
    }

    public static VkGeometryDataNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkGeometryDataNV.Ptr ret = new VkGeometryDataNV.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).autoInit();
        }
        return ret;
    }

    public static VkGeometryDataNV clone(Arena arena, VkGeometryDataNV src) {
        VkGeometryDataNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        triangles().autoInit();
        aabbs().autoInit();
    }

    public @NotNull VkGeometryTrianglesNV triangles() {
        return new VkGeometryTrianglesNV(segment.asSlice(OFFSET$triangles, LAYOUT$triangles));
    }

    public VkGeometryDataNV triangles(@NotNull VkGeometryTrianglesNV value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$triangles, SIZE$triangles);
        return this;
    }

    public VkGeometryDataNV triangles(Consumer<@NotNull VkGeometryTrianglesNV> consumer) {
        consumer.accept(triangles());
        return this;
    }

    public @NotNull VkGeometryAABBNV aabbs() {
        return new VkGeometryAABBNV(segment.asSlice(OFFSET$aabbs, LAYOUT$aabbs));
    }

    public VkGeometryDataNV aabbs(@NotNull VkGeometryAABBNV value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$aabbs, SIZE$aabbs);
        return this;
    }

    public VkGeometryDataNV aabbs(Consumer<@NotNull VkGeometryAABBNV> consumer) {
        consumer.accept(aabbs());
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        VkGeometryTrianglesNV.LAYOUT.withName("triangles"),
        VkGeometryAABBNV.LAYOUT.withName("aabbs")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$triangles = PathElement.groupElement("triangles");
    public static final PathElement PATH$aabbs = PathElement.groupElement("aabbs");

    public static final StructLayout LAYOUT$triangles = (StructLayout) LAYOUT.select(PATH$triangles);
    public static final StructLayout LAYOUT$aabbs = (StructLayout) LAYOUT.select(PATH$aabbs);

    public static final long SIZE$triangles = LAYOUT$triangles.byteSize();
    public static final long SIZE$aabbs = LAYOUT$aabbs.byteSize();

    public static final long OFFSET$triangles = LAYOUT.byteOffset(PATH$triangles);
    public static final long OFFSET$aabbs = LAYOUT.byteOffset(PATH$aabbs);
}
