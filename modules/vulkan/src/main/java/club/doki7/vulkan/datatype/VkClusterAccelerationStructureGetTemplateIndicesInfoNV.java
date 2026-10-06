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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkClusterAccelerationStructureGetTemplateIndicesInfoNV.html"><code>VkClusterAccelerationStructureGetTemplateIndicesInfoNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkClusterAccelerationStructureGetTemplateIndicesInfoNV {
///     VkDeviceAddress clusterTemplateAddress; // @link substring="clusterTemplateAddress" target="#clusterTemplateAddress"
/// } VkClusterAccelerationStructureGetTemplateIndicesInfoNV;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkClusterAccelerationStructureGetTemplateIndicesInfoNV.html"><code>VkClusterAccelerationStructureGetTemplateIndicesInfoNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkClusterAccelerationStructureGetTemplateIndicesInfoNV(@NotNull MemorySegment segment) implements IVkClusterAccelerationStructureGetTemplateIndicesInfoNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkClusterAccelerationStructureGetTemplateIndicesInfoNV.html"><code>VkClusterAccelerationStructureGetTemplateIndicesInfoNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkClusterAccelerationStructureGetTemplateIndicesInfoNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkClusterAccelerationStructureGetTemplateIndicesInfoNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkClusterAccelerationStructureGetTemplateIndicesInfoNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkClusterAccelerationStructureGetTemplateIndicesInfoNV, Iterable<VkClusterAccelerationStructureGetTemplateIndicesInfoNV> {
        public long size() {
            return segment.byteSize() / VkClusterAccelerationStructureGetTemplateIndicesInfoNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkClusterAccelerationStructureGetTemplateIndicesInfoNV at(long index) {
            return new VkClusterAccelerationStructureGetTemplateIndicesInfoNV(segment.asSlice(index * VkClusterAccelerationStructureGetTemplateIndicesInfoNV.BYTES, VkClusterAccelerationStructureGetTemplateIndicesInfoNV.BYTES));
        }

        public VkClusterAccelerationStructureGetTemplateIndicesInfoNV.Ptr at(long index, @NotNull Consumer<@NotNull VkClusterAccelerationStructureGetTemplateIndicesInfoNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkClusterAccelerationStructureGetTemplateIndicesInfoNV value) {
            MemorySegment s = segment.asSlice(index * VkClusterAccelerationStructureGetTemplateIndicesInfoNV.BYTES, VkClusterAccelerationStructureGetTemplateIndicesInfoNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkClusterAccelerationStructureGetTemplateIndicesInfoNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkClusterAccelerationStructureGetTemplateIndicesInfoNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkClusterAccelerationStructureGetTemplateIndicesInfoNV.BYTES,
                (end - start) * VkClusterAccelerationStructureGetTemplateIndicesInfoNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkClusterAccelerationStructureGetTemplateIndicesInfoNV.BYTES));
        }

        public VkClusterAccelerationStructureGetTemplateIndicesInfoNV[] toArray() {
            VkClusterAccelerationStructureGetTemplateIndicesInfoNV[] ret = new VkClusterAccelerationStructureGetTemplateIndicesInfoNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkClusterAccelerationStructureGetTemplateIndicesInfoNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkClusterAccelerationStructureGetTemplateIndicesInfoNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkClusterAccelerationStructureGetTemplateIndicesInfoNV.BYTES;
            }

            @Override
            public VkClusterAccelerationStructureGetTemplateIndicesInfoNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkClusterAccelerationStructureGetTemplateIndicesInfoNV ret = new VkClusterAccelerationStructureGetTemplateIndicesInfoNV(segment.asSlice(0, VkClusterAccelerationStructureGetTemplateIndicesInfoNV.BYTES));
                segment = segment.asSlice(VkClusterAccelerationStructureGetTemplateIndicesInfoNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkClusterAccelerationStructureGetTemplateIndicesInfoNV allocate(Arena arena) {
        return new VkClusterAccelerationStructureGetTemplateIndicesInfoNV(arena.allocate(LAYOUT));
    }

    public static VkClusterAccelerationStructureGetTemplateIndicesInfoNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkClusterAccelerationStructureGetTemplateIndicesInfoNV.Ptr(segment);
    }

    public static VkClusterAccelerationStructureGetTemplateIndicesInfoNV clone(Arena arena, VkClusterAccelerationStructureGetTemplateIndicesInfoNV src) {
        VkClusterAccelerationStructureGetTemplateIndicesInfoNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NativeType("VkDeviceAddress") @Unsigned long clusterTemplateAddress() {
        return segment.get(LAYOUT$clusterTemplateAddress, OFFSET$clusterTemplateAddress);
    }

    public VkClusterAccelerationStructureGetTemplateIndicesInfoNV clusterTemplateAddress(@NativeType("VkDeviceAddress") @Unsigned long value) {
        segment.set(LAYOUT$clusterTemplateAddress, OFFSET$clusterTemplateAddress, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_LONG.withName("clusterTemplateAddress")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$clusterTemplateAddress = PathElement.groupElement("clusterTemplateAddress");

    public static final OfLong LAYOUT$clusterTemplateAddress = (OfLong) LAYOUT.select(PATH$clusterTemplateAddress);

    public static final long SIZE$clusterTemplateAddress = LAYOUT$clusterTemplateAddress.byteSize();

    public static final long OFFSET$clusterTemplateAddress = LAYOUT.byteOffset(PATH$clusterTemplateAddress);
}
