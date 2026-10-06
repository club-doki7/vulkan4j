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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV.html"><code>VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV {
///     uint32_t clusterReferencesCount; // @link substring="clusterReferencesCount" target="#clusterReferencesCount"
///     uint32_t clusterReferencesStride; // @link substring="clusterReferencesStride" target="#clusterReferencesStride"
///     VkDeviceAddress clusterReferences; // @link substring="clusterReferences" target="#clusterReferences"
/// } VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV.html"><code>VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV(@NotNull MemorySegment segment) implements IVkClusterAccelerationStructureBuildClustersBottomLevelInfoNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV.html"><code>VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkClusterAccelerationStructureBuildClustersBottomLevelInfoNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkClusterAccelerationStructureBuildClustersBottomLevelInfoNV, Iterable<VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV> {
        public long size() {
            return segment.byteSize() / VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV at(long index) {
            return new VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV(segment.asSlice(index * VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV.BYTES, VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV.BYTES));
        }

        public VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV.Ptr at(long index, @NotNull Consumer<@NotNull VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV value) {
            MemorySegment s = segment.asSlice(index * VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV.BYTES, VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV.BYTES,
                (end - start) * VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV.BYTES));
        }

        public VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV[] toArray() {
            VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV[] ret = new VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV.BYTES;
            }

            @Override
            public VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV ret = new VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV(segment.asSlice(0, VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV.BYTES));
                segment = segment.asSlice(VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV allocate(Arena arena) {
        return new VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV(arena.allocate(LAYOUT));
    }

    public static VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV.Ptr(segment);
    }

    public static VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV clone(Arena arena, VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV src) {
        VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned int clusterReferencesCount() {
        return segment.get(LAYOUT$clusterReferencesCount, OFFSET$clusterReferencesCount);
    }

    public VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV clusterReferencesCount(@Unsigned int value) {
        segment.set(LAYOUT$clusterReferencesCount, OFFSET$clusterReferencesCount, value);
        return this;
    }

    public @Unsigned int clusterReferencesStride() {
        return segment.get(LAYOUT$clusterReferencesStride, OFFSET$clusterReferencesStride);
    }

    public VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV clusterReferencesStride(@Unsigned int value) {
        segment.set(LAYOUT$clusterReferencesStride, OFFSET$clusterReferencesStride, value);
        return this;
    }

    public @NativeType("VkDeviceAddress") @Unsigned long clusterReferences() {
        return segment.get(LAYOUT$clusterReferences, OFFSET$clusterReferences);
    }

    public VkClusterAccelerationStructureBuildClustersBottomLevelInfoNV clusterReferences(@NativeType("VkDeviceAddress") @Unsigned long value) {
        segment.set(LAYOUT$clusterReferences, OFFSET$clusterReferences, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("clusterReferencesCount"),
        ValueLayout.JAVA_INT.withName("clusterReferencesStride"),
        ValueLayout.JAVA_LONG.withName("clusterReferences")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$clusterReferencesCount = PathElement.groupElement("clusterReferencesCount");
    public static final PathElement PATH$clusterReferencesStride = PathElement.groupElement("clusterReferencesStride");
    public static final PathElement PATH$clusterReferences = PathElement.groupElement("clusterReferences");

    public static final OfInt LAYOUT$clusterReferencesCount = (OfInt) LAYOUT.select(PATH$clusterReferencesCount);
    public static final OfInt LAYOUT$clusterReferencesStride = (OfInt) LAYOUT.select(PATH$clusterReferencesStride);
    public static final OfLong LAYOUT$clusterReferences = (OfLong) LAYOUT.select(PATH$clusterReferences);

    public static final long SIZE$clusterReferencesCount = LAYOUT$clusterReferencesCount.byteSize();
    public static final long SIZE$clusterReferencesStride = LAYOUT$clusterReferencesStride.byteSize();
    public static final long SIZE$clusterReferences = LAYOUT$clusterReferences.byteSize();

    public static final long OFFSET$clusterReferencesCount = LAYOUT.byteOffset(PATH$clusterReferencesCount);
    public static final long OFFSET$clusterReferencesStride = LAYOUT.byteOffset(PATH$clusterReferencesStride);
    public static final long OFFSET$clusterReferences = LAYOUT.byteOffset(PATH$clusterReferences);
}
