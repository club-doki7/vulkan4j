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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAccelerationStructureSRTMotionInstanceNV.html"><code>VkAccelerationStructureSRTMotionInstanceNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkAccelerationStructureSRTMotionInstanceNV {
///     VkSRTDataNV transformT0; // @link substring="VkSRTDataNV" target="VkSRTDataNV" @link substring="transformT0" target="#transformT0"
///     VkSRTDataNV transformT1; // @link substring="VkSRTDataNV" target="VkSRTDataNV" @link substring="transformT1" target="#transformT1"
///     uint32_t instanceCustomIndex : 24; // @link substring="instanceCustomIndex" target="#instanceCustomIndex"
///     uint32_t mask : 8; // @link substring="mask" target="#mask"
///     uint32_t instanceShaderBindingTableRecordOffset : 24; // @link substring="instanceShaderBindingTableRecordOffset" target="#instanceShaderBindingTableRecordOffset"
///     uint32_t flags : 8; // @link substring="flags" target="#flags"
///     uint64_t accelerationStructureReference; // @link substring="accelerationStructureReference" target="#accelerationStructureReference"
/// } VkAccelerationStructureSRTMotionInstanceNV;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAccelerationStructureSRTMotionInstanceNV.html"><code>VkAccelerationStructureSRTMotionInstanceNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkAccelerationStructureSRTMotionInstanceNV(@NotNull MemorySegment segment) implements IVkAccelerationStructureSRTMotionInstanceNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAccelerationStructureSRTMotionInstanceNV.html"><code>VkAccelerationStructureSRTMotionInstanceNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkAccelerationStructureSRTMotionInstanceNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkAccelerationStructureSRTMotionInstanceNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkAccelerationStructureSRTMotionInstanceNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkAccelerationStructureSRTMotionInstanceNV, Iterable<VkAccelerationStructureSRTMotionInstanceNV> {
        public long size() {
            return segment.byteSize() / VkAccelerationStructureSRTMotionInstanceNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkAccelerationStructureSRTMotionInstanceNV at(long index) {
            return new VkAccelerationStructureSRTMotionInstanceNV(segment.asSlice(index * VkAccelerationStructureSRTMotionInstanceNV.BYTES, VkAccelerationStructureSRTMotionInstanceNV.BYTES));
        }

        public VkAccelerationStructureSRTMotionInstanceNV.Ptr at(long index, @NotNull Consumer<@NotNull VkAccelerationStructureSRTMotionInstanceNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkAccelerationStructureSRTMotionInstanceNV value) {
            MemorySegment s = segment.asSlice(index * VkAccelerationStructureSRTMotionInstanceNV.BYTES, VkAccelerationStructureSRTMotionInstanceNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkAccelerationStructureSRTMotionInstanceNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkAccelerationStructureSRTMotionInstanceNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkAccelerationStructureSRTMotionInstanceNV.BYTES,
                (end - start) * VkAccelerationStructureSRTMotionInstanceNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkAccelerationStructureSRTMotionInstanceNV.BYTES));
        }

        public VkAccelerationStructureSRTMotionInstanceNV[] toArray() {
            VkAccelerationStructureSRTMotionInstanceNV[] ret = new VkAccelerationStructureSRTMotionInstanceNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkAccelerationStructureSRTMotionInstanceNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkAccelerationStructureSRTMotionInstanceNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkAccelerationStructureSRTMotionInstanceNV.BYTES;
            }

            @Override
            public VkAccelerationStructureSRTMotionInstanceNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkAccelerationStructureSRTMotionInstanceNV ret = new VkAccelerationStructureSRTMotionInstanceNV(segment.asSlice(0, VkAccelerationStructureSRTMotionInstanceNV.BYTES));
                segment = segment.asSlice(VkAccelerationStructureSRTMotionInstanceNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkAccelerationStructureSRTMotionInstanceNV allocate(Arena arena) {
        return new VkAccelerationStructureSRTMotionInstanceNV(arena.allocate(LAYOUT));
    }

    public static VkAccelerationStructureSRTMotionInstanceNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkAccelerationStructureSRTMotionInstanceNV.Ptr(segment);
    }

    public static VkAccelerationStructureSRTMotionInstanceNV clone(Arena arena, VkAccelerationStructureSRTMotionInstanceNV src) {
        VkAccelerationStructureSRTMotionInstanceNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull VkSRTDataNV transformT0() {
        return new VkSRTDataNV(segment.asSlice(OFFSET$transformT0, LAYOUT$transformT0));
    }

    public VkAccelerationStructureSRTMotionInstanceNV transformT0(@NotNull VkSRTDataNV value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$transformT0, SIZE$transformT0);
        return this;
    }

    public VkAccelerationStructureSRTMotionInstanceNV transformT0(Consumer<@NotNull VkSRTDataNV> consumer) {
        consumer.accept(transformT0());
        return this;
    }

    public @NotNull VkSRTDataNV transformT1() {
        return new VkSRTDataNV(segment.asSlice(OFFSET$transformT1, LAYOUT$transformT1));
    }

    public VkAccelerationStructureSRTMotionInstanceNV transformT1(@NotNull VkSRTDataNV value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$transformT1, SIZE$transformT1);
        return this;
    }

    public VkAccelerationStructureSRTMotionInstanceNV transformT1(Consumer<@NotNull VkSRTDataNV> consumer) {
        consumer.accept(transformT1());
        return this;
    }

    public @Unsigned int instanceCustomIndex() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$instanceCustomIndex$mask, LAYOUT$bitfield$instanceCustomIndex$mask);
        return BitfieldUtil.readBits(s, 0, 24);
    }

    public VkAccelerationStructureSRTMotionInstanceNV instanceCustomIndex(@Unsigned int value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$instanceCustomIndex$mask, LAYOUT$bitfield$instanceCustomIndex$mask);
        BitfieldUtil.writeBits(s, 0, 24, value);
        return this;
    }

    public @Unsigned int mask() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$instanceCustomIndex$mask, LAYOUT$bitfield$instanceCustomIndex$mask);
        return BitfieldUtil.readBits(s, 24, 32);
    }

    public VkAccelerationStructureSRTMotionInstanceNV mask(@Unsigned int value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$instanceCustomIndex$mask, LAYOUT$bitfield$instanceCustomIndex$mask);
        BitfieldUtil.writeBits(s, 24, 32, value);
        return this;
    }

    public @Unsigned int instanceShaderBindingTableRecordOffset() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$instanceShaderBindingTableRecordOffset$flags, LAYOUT$bitfield$instanceShaderBindingTableRecordOffset$flags);
        return BitfieldUtil.readBits(s, 0, 24);
    }

    public VkAccelerationStructureSRTMotionInstanceNV instanceShaderBindingTableRecordOffset(@Unsigned int value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$instanceShaderBindingTableRecordOffset$flags, LAYOUT$bitfield$instanceShaderBindingTableRecordOffset$flags);
        BitfieldUtil.writeBits(s, 0, 24, value);
        return this;
    }

    public @Unsigned int flags() {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$instanceShaderBindingTableRecordOffset$flags, LAYOUT$bitfield$instanceShaderBindingTableRecordOffset$flags);
        return BitfieldUtil.readBits(s, 24, 32);
    }

    public VkAccelerationStructureSRTMotionInstanceNV flags(@Unsigned int value) {
        MemorySegment s = segment.asSlice(OFFSET$bitfield$instanceShaderBindingTableRecordOffset$flags, LAYOUT$bitfield$instanceShaderBindingTableRecordOffset$flags);
        BitfieldUtil.writeBits(s, 24, 32, value);
        return this;
    }

    public @Unsigned long accelerationStructureReference() {
        return segment.get(LAYOUT$accelerationStructureReference, OFFSET$accelerationStructureReference);
    }

    public VkAccelerationStructureSRTMotionInstanceNV accelerationStructureReference(@Unsigned long value) {
        segment.set(LAYOUT$accelerationStructureReference, OFFSET$accelerationStructureReference, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        VkSRTDataNV.LAYOUT.withName("transformT0"),
        VkSRTDataNV.LAYOUT.withName("transformT1"),
        ValueLayout.JAVA_INT.withName("bitfield$instanceCustomIndex$mask"),
        ValueLayout.JAVA_INT.withName("bitfield$instanceShaderBindingTableRecordOffset$flags"),
        ValueLayout.JAVA_LONG.withName("accelerationStructureReference")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$transformT0 = PathElement.groupElement("transformT0");
    public static final PathElement PATH$transformT1 = PathElement.groupElement("transformT1");
    public static final PathElement PATH$bitfield$instanceCustomIndex$mask = PathElement.groupElement("instanceCustomIndex$mask");
    public static final PathElement PATH$bitfield$instanceShaderBindingTableRecordOffset$flags = PathElement.groupElement("instanceShaderBindingTableRecordOffset$flags");
    public static final PathElement PATH$accelerationStructureReference = PathElement.groupElement("accelerationStructureReference");

    public static final StructLayout LAYOUT$transformT0 = (StructLayout) LAYOUT.select(PATH$transformT0);
    public static final StructLayout LAYOUT$transformT1 = (StructLayout) LAYOUT.select(PATH$transformT1);
    public static final OfInt LAYOUT$bitfield$instanceCustomIndex$mask = (OfInt) LAYOUT.select(PATH$bitfield$instanceCustomIndex$mask);
    public static final OfInt LAYOUT$bitfield$instanceShaderBindingTableRecordOffset$flags = (OfInt) LAYOUT.select(PATH$bitfield$instanceShaderBindingTableRecordOffset$flags);
    public static final OfLong LAYOUT$accelerationStructureReference = (OfLong) LAYOUT.select(PATH$accelerationStructureReference);

    public static final long SIZE$transformT0 = LAYOUT$transformT0.byteSize();
    public static final long SIZE$transformT1 = LAYOUT$transformT1.byteSize();
    public static final long SIZE$accelerationStructureReference = LAYOUT$accelerationStructureReference.byteSize();

    public static final long OFFSET$transformT0 = LAYOUT.byteOffset(PATH$transformT0);
    public static final long OFFSET$transformT1 = LAYOUT.byteOffset(PATH$transformT1);
    public static final long OFFSET$bitfield$instanceCustomIndex$mask = LAYOUT.byteOffset(PATH$bitfield$instanceCustomIndex$mask);
    public static final long OFFSET$bitfield$instanceShaderBindingTableRecordOffset$flags = LAYOUT.byteOffset(PATH$bitfield$instanceShaderBindingTableRecordOffset$flags);
    public static final long OFFSET$accelerationStructureReference = LAYOUT.byteOffset(PATH$accelerationStructureReference);
}
