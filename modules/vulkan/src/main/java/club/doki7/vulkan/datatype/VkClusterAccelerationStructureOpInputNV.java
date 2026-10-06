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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkClusterAccelerationStructureOpInputNV.html"><code>VkClusterAccelerationStructureOpInputNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef union VkClusterAccelerationStructureOpInputNV {
///     VkClusterAccelerationStructureClustersBottomLevelInputNV* pClustersBottomLevel; // @link substring="VkClusterAccelerationStructureClustersBottomLevelInputNV" target="VkClusterAccelerationStructureClustersBottomLevelInputNV" @link substring="pClustersBottomLevel" target="#pClustersBottomLevel"
///     VkClusterAccelerationStructureTriangleClusterInputNV* pTriangleClusters; // @link substring="VkClusterAccelerationStructureTriangleClusterInputNV" target="VkClusterAccelerationStructureTriangleClusterInputNV" @link substring="pTriangleClusters" target="#pTriangleClusters"
///     VkClusterAccelerationStructureMoveObjectsInputNV* pMoveObjects; // @link substring="VkClusterAccelerationStructureMoveObjectsInputNV" target="VkClusterAccelerationStructureMoveObjectsInputNV" @link substring="pMoveObjects" target="#pMoveObjects"
/// } VkClusterAccelerationStructureOpInputNV;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkClusterAccelerationStructureOpInputNV.html"><code>VkClusterAccelerationStructureOpInputNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkClusterAccelerationStructureOpInputNV(@NotNull MemorySegment segment) implements IVkClusterAccelerationStructureOpInputNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkClusterAccelerationStructureOpInputNV.html"><code>VkClusterAccelerationStructureOpInputNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkClusterAccelerationStructureOpInputNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkClusterAccelerationStructureOpInputNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkClusterAccelerationStructureOpInputNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkClusterAccelerationStructureOpInputNV, Iterable<VkClusterAccelerationStructureOpInputNV> {
        public long size() {
            return segment.byteSize() / VkClusterAccelerationStructureOpInputNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkClusterAccelerationStructureOpInputNV at(long index) {
            return new VkClusterAccelerationStructureOpInputNV(segment.asSlice(index * VkClusterAccelerationStructureOpInputNV.BYTES, VkClusterAccelerationStructureOpInputNV.BYTES));
        }

        public VkClusterAccelerationStructureOpInputNV.Ptr at(long index, @NotNull Consumer<@NotNull VkClusterAccelerationStructureOpInputNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkClusterAccelerationStructureOpInputNV value) {
            MemorySegment s = segment.asSlice(index * VkClusterAccelerationStructureOpInputNV.BYTES, VkClusterAccelerationStructureOpInputNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkClusterAccelerationStructureOpInputNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkClusterAccelerationStructureOpInputNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkClusterAccelerationStructureOpInputNV.BYTES,
                (end - start) * VkClusterAccelerationStructureOpInputNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkClusterAccelerationStructureOpInputNV.BYTES));
        }

        public VkClusterAccelerationStructureOpInputNV[] toArray() {
            VkClusterAccelerationStructureOpInputNV[] ret = new VkClusterAccelerationStructureOpInputNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkClusterAccelerationStructureOpInputNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkClusterAccelerationStructureOpInputNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkClusterAccelerationStructureOpInputNV.BYTES;
            }

            @Override
            public VkClusterAccelerationStructureOpInputNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkClusterAccelerationStructureOpInputNV ret = new VkClusterAccelerationStructureOpInputNV(segment.asSlice(0, VkClusterAccelerationStructureOpInputNV.BYTES));
                segment = segment.asSlice(VkClusterAccelerationStructureOpInputNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkClusterAccelerationStructureOpInputNV allocate(Arena arena) {
        return new VkClusterAccelerationStructureOpInputNV(arena.allocate(LAYOUT));
    }

    public static VkClusterAccelerationStructureOpInputNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkClusterAccelerationStructureOpInputNV.Ptr(segment);
    }

    public static VkClusterAccelerationStructureOpInputNV clone(Arena arena, VkClusterAccelerationStructureOpInputNV src) {
        VkClusterAccelerationStructureOpInputNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public VkClusterAccelerationStructureOpInputNV pClustersBottomLevel(@Nullable IVkClusterAccelerationStructureClustersBottomLevelInputNV value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pClustersBottomLevelRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkClusterAccelerationStructureClustersBottomLevelInputNV.Ptr pClustersBottomLevel(int assumedCount) {
        MemorySegment s = pClustersBottomLevelRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkClusterAccelerationStructureClustersBottomLevelInputNV.BYTES);
        return new VkClusterAccelerationStructureClustersBottomLevelInputNV.Ptr(s);
    }

    public @Nullable VkClusterAccelerationStructureClustersBottomLevelInputNV pClustersBottomLevel() {
        MemorySegment s = pClustersBottomLevelRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkClusterAccelerationStructureClustersBottomLevelInputNV(s);
    }

    public @Pointer(target=VkClusterAccelerationStructureClustersBottomLevelInputNV.class) @NotNull MemorySegment pClustersBottomLevelRaw() {
        return segment.get(LAYOUT$pClustersBottomLevel, OFFSET$pClustersBottomLevel);
    }

    public void pClustersBottomLevelRaw(@Pointer(target=VkClusterAccelerationStructureClustersBottomLevelInputNV.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pClustersBottomLevel, OFFSET$pClustersBottomLevel, value);
    }

    public VkClusterAccelerationStructureOpInputNV pTriangleClusters(@Nullable IVkClusterAccelerationStructureTriangleClusterInputNV value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pTriangleClustersRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkClusterAccelerationStructureTriangleClusterInputNV.Ptr pTriangleClusters(int assumedCount) {
        MemorySegment s = pTriangleClustersRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkClusterAccelerationStructureTriangleClusterInputNV.BYTES);
        return new VkClusterAccelerationStructureTriangleClusterInputNV.Ptr(s);
    }

    public @Nullable VkClusterAccelerationStructureTriangleClusterInputNV pTriangleClusters() {
        MemorySegment s = pTriangleClustersRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkClusterAccelerationStructureTriangleClusterInputNV(s);
    }

    public @Pointer(target=VkClusterAccelerationStructureTriangleClusterInputNV.class) @NotNull MemorySegment pTriangleClustersRaw() {
        return segment.get(LAYOUT$pTriangleClusters, OFFSET$pTriangleClusters);
    }

    public void pTriangleClustersRaw(@Pointer(target=VkClusterAccelerationStructureTriangleClusterInputNV.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pTriangleClusters, OFFSET$pTriangleClusters, value);
    }

    public VkClusterAccelerationStructureOpInputNV pMoveObjects(@Nullable IVkClusterAccelerationStructureMoveObjectsInputNV value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pMoveObjectsRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkClusterAccelerationStructureMoveObjectsInputNV.Ptr pMoveObjects(int assumedCount) {
        MemorySegment s = pMoveObjectsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkClusterAccelerationStructureMoveObjectsInputNV.BYTES);
        return new VkClusterAccelerationStructureMoveObjectsInputNV.Ptr(s);
    }

    public @Nullable VkClusterAccelerationStructureMoveObjectsInputNV pMoveObjects() {
        MemorySegment s = pMoveObjectsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkClusterAccelerationStructureMoveObjectsInputNV(s);
    }

    public @Pointer(target=VkClusterAccelerationStructureMoveObjectsInputNV.class) @NotNull MemorySegment pMoveObjectsRaw() {
        return segment.get(LAYOUT$pMoveObjects, OFFSET$pMoveObjects);
    }

    public void pMoveObjectsRaw(@Pointer(target=VkClusterAccelerationStructureMoveObjectsInputNV.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pMoveObjects, OFFSET$pMoveObjects, value);
    }

    public static final UnionLayout LAYOUT = NativeLayout.unionLayout(
        ValueLayout.ADDRESS.withTargetLayout(VkClusterAccelerationStructureClustersBottomLevelInputNV.LAYOUT).withName("pClustersBottomLevel"),
        ValueLayout.ADDRESS.withTargetLayout(VkClusterAccelerationStructureTriangleClusterInputNV.LAYOUT).withName("pTriangleClusters"),
        ValueLayout.ADDRESS.withTargetLayout(VkClusterAccelerationStructureMoveObjectsInputNV.LAYOUT).withName("pMoveObjects")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$pClustersBottomLevel = PathElement.groupElement("pClustersBottomLevel");
    public static final PathElement PATH$pTriangleClusters = PathElement.groupElement("pTriangleClusters");
    public static final PathElement PATH$pMoveObjects = PathElement.groupElement("pMoveObjects");

    public static final AddressLayout LAYOUT$pClustersBottomLevel = (AddressLayout) LAYOUT.select(PATH$pClustersBottomLevel);
    public static final AddressLayout LAYOUT$pTriangleClusters = (AddressLayout) LAYOUT.select(PATH$pTriangleClusters);
    public static final AddressLayout LAYOUT$pMoveObjects = (AddressLayout) LAYOUT.select(PATH$pMoveObjects);

    public static final long SIZE$pClustersBottomLevel = LAYOUT$pClustersBottomLevel.byteSize();
    public static final long SIZE$pTriangleClusters = LAYOUT$pTriangleClusters.byteSize();
    public static final long SIZE$pMoveObjects = LAYOUT$pMoveObjects.byteSize();

    public static final long OFFSET$pClustersBottomLevel = LAYOUT.byteOffset(PATH$pClustersBottomLevel);
    public static final long OFFSET$pTriangleClusters = LAYOUT.byteOffset(PATH$pTriangleClusters);
    public static final long OFFSET$pMoveObjects = LAYOUT.byteOffset(PATH$pMoveObjects);
}
