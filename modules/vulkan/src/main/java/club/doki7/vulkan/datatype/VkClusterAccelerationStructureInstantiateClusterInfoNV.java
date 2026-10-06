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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkClusterAccelerationStructureInstantiateClusterInfoNV.html"><code>VkClusterAccelerationStructureInstantiateClusterInfoNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkClusterAccelerationStructureInstantiateClusterInfoNV {
///     uint32_t clusterIdOffset; // @link substring="clusterIdOffset" target="#clusterIdOffset"
///     uint32_t geometryIndexOffset : 24; // @link substring="geometryIndexOffset" target="#geometryIndexOffset"
///     uint32_t reserved : 8;
///     VkDeviceAddress clusterTemplateAddress; // @link substring="clusterTemplateAddress" target="#clusterTemplateAddress"
///     VkStridedDeviceAddressNV vertexBuffer; // @link substring="VkStridedDeviceAddressNV" target="VkStridedDeviceAddressNV" @link substring="vertexBuffer" target="#vertexBuffer"
/// } VkClusterAccelerationStructureInstantiateClusterInfoNV;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkClusterAccelerationStructureInstantiateClusterInfoNV.html"><code>VkClusterAccelerationStructureInstantiateClusterInfoNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkClusterAccelerationStructureInstantiateClusterInfoNV(@NotNull MemorySegment segment) implements IVkClusterAccelerationStructureInstantiateClusterInfoNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkClusterAccelerationStructureInstantiateClusterInfoNV.html"><code>VkClusterAccelerationStructureInstantiateClusterInfoNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkClusterAccelerationStructureInstantiateClusterInfoNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkClusterAccelerationStructureInstantiateClusterInfoNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkClusterAccelerationStructureInstantiateClusterInfoNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkClusterAccelerationStructureInstantiateClusterInfoNV, Iterable<VkClusterAccelerationStructureInstantiateClusterInfoNV> {
        public long size() {
            return segment.byteSize() / VkClusterAccelerationStructureInstantiateClusterInfoNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkClusterAccelerationStructureInstantiateClusterInfoNV at(long index) {
            return new VkClusterAccelerationStructureInstantiateClusterInfoNV(segment.asSlice(index * VkClusterAccelerationStructureInstantiateClusterInfoNV.BYTES, VkClusterAccelerationStructureInstantiateClusterInfoNV.BYTES));
        }

        public VkClusterAccelerationStructureInstantiateClusterInfoNV.Ptr at(long index, @NotNull Consumer<@NotNull VkClusterAccelerationStructureInstantiateClusterInfoNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkClusterAccelerationStructureInstantiateClusterInfoNV value) {
            MemorySegment s = segment.asSlice(index * VkClusterAccelerationStructureInstantiateClusterInfoNV.BYTES, VkClusterAccelerationStructureInstantiateClusterInfoNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkClusterAccelerationStructureInstantiateClusterInfoNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkClusterAccelerationStructureInstantiateClusterInfoNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkClusterAccelerationStructureInstantiateClusterInfoNV.BYTES,
                (end - start) * VkClusterAccelerationStructureInstantiateClusterInfoNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkClusterAccelerationStructureInstantiateClusterInfoNV.BYTES));
        }

        public VkClusterAccelerationStructureInstantiateClusterInfoNV[] toArray() {
            VkClusterAccelerationStructureInstantiateClusterInfoNV[] ret = new VkClusterAccelerationStructureInstantiateClusterInfoNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkClusterAccelerationStructureInstantiateClusterInfoNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkClusterAccelerationStructureInstantiateClusterInfoNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkClusterAccelerationStructureInstantiateClusterInfoNV.BYTES;
            }

            @Override
            public VkClusterAccelerationStructureInstantiateClusterInfoNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkClusterAccelerationStructureInstantiateClusterInfoNV ret = new VkClusterAccelerationStructureInstantiateClusterInfoNV(segment.asSlice(0, VkClusterAccelerationStructureInstantiateClusterInfoNV.BYTES));
                segment = segment.asSlice(VkClusterAccelerationStructureInstantiateClusterInfoNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkClusterAccelerationStructureInstantiateClusterInfoNV allocate(Arena arena) {
        return new VkClusterAccelerationStructureInstantiateClusterInfoNV(arena.allocate(LAYOUT));
    }

    public static VkClusterAccelerationStructureInstantiateClusterInfoNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkClusterAccelerationStructureInstantiateClusterInfoNV.Ptr(segment);
    }

    public static VkClusterAccelerationStructureInstantiateClusterInfoNV clone(Arena arena, VkClusterAccelerationStructureInstantiateClusterInfoNV src) {
        VkClusterAccelerationStructureInstantiateClusterInfoNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned int clusterIdOffset() {
        return segment.get(LAYOUT$clusterIdOffset, OFFSET$clusterIdOffset);
    }

    public VkClusterAccelerationStructureInstantiateClusterInfoNV clusterIdOffset(@Unsigned int value) {
        segment.set(LAYOUT$clusterIdOffset, OFFSET$clusterIdOffset, value);
        return this;
    }

    public @Unsigned int geometryIndexOffset() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$geometryIndexOffset$reserved, LAYOUT$bitfield$geometryIndexOffset$reserved);
        return BitfieldUtil.readBits(s, 0, 24);
    }

    public VkClusterAccelerationStructureInstantiateClusterInfoNV geometryIndexOffset(@Unsigned int value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$geometryIndexOffset$reserved, LAYOUT$bitfield$geometryIndexOffset$reserved);
        BitfieldUtil.writeBits(s, 0, 24, value);
        return this;
    }

    public @NativeType("VkDeviceAddress") @Unsigned long clusterTemplateAddress() {
        return segment.get(LAYOUT$clusterTemplateAddress, OFFSET$clusterTemplateAddress);
    }

    public VkClusterAccelerationStructureInstantiateClusterInfoNV clusterTemplateAddress(@NativeType("VkDeviceAddress") @Unsigned long value) {
        segment.set(LAYOUT$clusterTemplateAddress, OFFSET$clusterTemplateAddress, value);
        return this;
    }

    public @NotNull VkStridedDeviceAddressNV vertexBuffer() {
        return new VkStridedDeviceAddressNV(segment.asSlice(OFFSET$vertexBuffer, LAYOUT$vertexBuffer));
    }

    public VkClusterAccelerationStructureInstantiateClusterInfoNV vertexBuffer(@NotNull VkStridedDeviceAddressNV value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$vertexBuffer, SIZE$vertexBuffer);
        return this;
    }

    public VkClusterAccelerationStructureInstantiateClusterInfoNV vertexBuffer(Consumer<@NotNull VkStridedDeviceAddressNV> consumer) {
        consumer.accept(vertexBuffer());
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("clusterIdOffset"),
        ValueLayout.JAVA_INT.withName("bitfield$geometryIndexOffset$reserved"),
        ValueLayout.JAVA_LONG.withName("clusterTemplateAddress"),
        VkStridedDeviceAddressNV.LAYOUT.withName("vertexBuffer")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$clusterIdOffset = PathElement.groupElement("clusterIdOffset");
    public static final PathElement PATH$bitfield$geometryIndexOffset$reserved = PathElement.groupElement("geometryIndexOffset$reserved");
    public static final PathElement PATH$clusterTemplateAddress = PathElement.groupElement("clusterTemplateAddress");
    public static final PathElement PATH$vertexBuffer = PathElement.groupElement("vertexBuffer");

    public static final OfInt LAYOUT$clusterIdOffset = (OfInt) LAYOUT.select(PATH$clusterIdOffset);
    public static final OfInt LAYOUT$bitfield$geometryIndexOffset$reserved = (OfInt) LAYOUT.select(PATH$bitfield$geometryIndexOffset$reserved);
    public static final OfLong LAYOUT$clusterTemplateAddress = (OfLong) LAYOUT.select(PATH$clusterTemplateAddress);
    public static final StructLayout LAYOUT$vertexBuffer = (StructLayout) LAYOUT.select(PATH$vertexBuffer);

    public static final long SIZE$clusterIdOffset = LAYOUT$clusterIdOffset.byteSize();
    public static final long SIZE$clusterTemplateAddress = LAYOUT$clusterTemplateAddress.byteSize();
    public static final long SIZE$vertexBuffer = LAYOUT$vertexBuffer.byteSize();

    public static final long OFFSET$clusterIdOffset = LAYOUT.byteOffset(PATH$clusterIdOffset);
    public static final long OFFSET$bitfield$geometryIndexOffset$reserved = LAYOUT.byteOffset(PATH$bitfield$geometryIndexOffset$reserved);
    public static final long OFFSET$clusterTemplateAddress = LAYOUT.byteOffset(PATH$clusterTemplateAddress);
    public static final long OFFSET$vertexBuffer = LAYOUT.byteOffset(PATH$vertexBuffer);
}
