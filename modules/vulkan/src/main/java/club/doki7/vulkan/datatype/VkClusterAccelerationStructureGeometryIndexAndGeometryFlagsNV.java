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
import club.doki7.ffm.bits.BitfieldUtil;
import club.doki7.ffm.annotation.*;
import club.doki7.ffm.ptr.*;
import club.doki7.vulkan.bitmask.*;
import club.doki7.vulkan.handle.*;
import club.doki7.vulkan.enumtype.*;
import static club.doki7.vulkan.VkConstants.*;
import club.doki7.vulkan.VkFunctionTypes.*;

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV.html"><code>VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV {
///     uint32_t geometryIndex : 24; // @link substring="geometryIndex" target="#geometryIndex"
///     uint32_t reserved : 5;
///     uint32_t geometryFlags : 3; // @link substring="geometryFlags" target="#geometryFlags"
/// } VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV.html"><code>VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV(@NotNull MemorySegment segment) implements IVkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV.html"><code>VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV, Iterable<VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV> {
        public long size() {
            return segment.byteSize() / VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV at(long index) {
            return new VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV(segment.asSlice(index * VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV.BYTES, VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV.BYTES));
        }

        public VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV.Ptr at(long index, @NotNull Consumer<@NotNull VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV value) {
            MemorySegment s = segment.asSlice(index * VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV.BYTES, VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV.BYTES,
                (end - start) * VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV.BYTES));
        }

        public VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV[] toArray() {
            VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV[] ret = new VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV.BYTES;
            }

            @Override
            public VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV ret = new VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV(segment.asSlice(0, VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV.BYTES));
                segment = segment.asSlice(VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV allocate(Arena arena) {
        return new VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV(arena.allocate(LAYOUT));
    }

    public static VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV.Ptr(segment);
    }

    public static VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV clone(Arena arena, VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV src) {
        VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned int geometryIndex() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$geometryIndex$geometryFlags, LAYOUT$bitfield$geometryIndex$geometryFlags);
        return BitfieldUtil.readBits(s, 0, 24);
    }

    public VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV geometryIndex(@Unsigned int value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$geometryIndex$geometryFlags, LAYOUT$bitfield$geometryIndex$geometryFlags);
        BitfieldUtil.writeBits(s, 0, 24, value);
        return this;
    }
    public @Unsigned int geometryFlags() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$geometryIndex$geometryFlags, LAYOUT$bitfield$geometryIndex$geometryFlags);
        return BitfieldUtil.readBits(s, 29, 32);
    }

    public VkClusterAccelerationStructureGeometryIndexAndGeometryFlagsNV geometryFlags(@Unsigned int value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$geometryIndex$geometryFlags, LAYOUT$bitfield$geometryIndex$geometryFlags);
        BitfieldUtil.writeBits(s, 29, 32, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("bitfield$geometryIndex$geometryFlags")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$bitfield$geometryIndex$geometryFlags = PathElement.groupElement("geometryIndex$geometryFlags");

    public static final OfInt LAYOUT$bitfield$geometryIndex$geometryFlags = (OfInt) LAYOUT.select(PATH$bitfield$geometryIndex$geometryFlags);


    public static final long OFFSET$bitfield$geometryIndex$geometryFlags = LAYOUT.byteOffset(PATH$bitfield$geometryIndex$geometryFlags);
}
