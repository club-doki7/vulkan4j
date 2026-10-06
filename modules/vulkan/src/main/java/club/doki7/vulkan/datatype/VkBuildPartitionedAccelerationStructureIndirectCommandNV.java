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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBuildPartitionedAccelerationStructureIndirectCommandNV.html"><code>VkBuildPartitionedAccelerationStructureIndirectCommandNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkBuildPartitionedAccelerationStructureIndirectCommandNV {
///     VkPartitionedAccelerationStructureOpTypeNV opType; // @link substring="VkPartitionedAccelerationStructureOpTypeNV" target="VkPartitionedAccelerationStructureOpTypeNV" @link substring="opType" target="#opType"
///     uint32_t argCount; // @link substring="argCount" target="#argCount"
///     VkStridedDeviceAddressNV argData; // @link substring="VkStridedDeviceAddressNV" target="VkStridedDeviceAddressNV" @link substring="argData" target="#argData"
/// } VkBuildPartitionedAccelerationStructureIndirectCommandNV;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBuildPartitionedAccelerationStructureIndirectCommandNV.html"><code>VkBuildPartitionedAccelerationStructureIndirectCommandNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkBuildPartitionedAccelerationStructureIndirectCommandNV(@NotNull MemorySegment segment) implements IVkBuildPartitionedAccelerationStructureIndirectCommandNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBuildPartitionedAccelerationStructureIndirectCommandNV.html"><code>VkBuildPartitionedAccelerationStructureIndirectCommandNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkBuildPartitionedAccelerationStructureIndirectCommandNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkBuildPartitionedAccelerationStructureIndirectCommandNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkBuildPartitionedAccelerationStructureIndirectCommandNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkBuildPartitionedAccelerationStructureIndirectCommandNV, Iterable<VkBuildPartitionedAccelerationStructureIndirectCommandNV> {
        public long size() {
            return segment.byteSize() / VkBuildPartitionedAccelerationStructureIndirectCommandNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkBuildPartitionedAccelerationStructureIndirectCommandNV at(long index) {
            return new VkBuildPartitionedAccelerationStructureIndirectCommandNV(segment.asSlice(index * VkBuildPartitionedAccelerationStructureIndirectCommandNV.BYTES, VkBuildPartitionedAccelerationStructureIndirectCommandNV.BYTES));
        }

        public VkBuildPartitionedAccelerationStructureIndirectCommandNV.Ptr at(long index, @NotNull Consumer<@NotNull VkBuildPartitionedAccelerationStructureIndirectCommandNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkBuildPartitionedAccelerationStructureIndirectCommandNV value) {
            MemorySegment s = segment.asSlice(index * VkBuildPartitionedAccelerationStructureIndirectCommandNV.BYTES, VkBuildPartitionedAccelerationStructureIndirectCommandNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkBuildPartitionedAccelerationStructureIndirectCommandNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkBuildPartitionedAccelerationStructureIndirectCommandNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkBuildPartitionedAccelerationStructureIndirectCommandNV.BYTES,
                (end - start) * VkBuildPartitionedAccelerationStructureIndirectCommandNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkBuildPartitionedAccelerationStructureIndirectCommandNV.BYTES));
        }

        public VkBuildPartitionedAccelerationStructureIndirectCommandNV[] toArray() {
            VkBuildPartitionedAccelerationStructureIndirectCommandNV[] ret = new VkBuildPartitionedAccelerationStructureIndirectCommandNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkBuildPartitionedAccelerationStructureIndirectCommandNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkBuildPartitionedAccelerationStructureIndirectCommandNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkBuildPartitionedAccelerationStructureIndirectCommandNV.BYTES;
            }

            @Override
            public VkBuildPartitionedAccelerationStructureIndirectCommandNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkBuildPartitionedAccelerationStructureIndirectCommandNV ret = new VkBuildPartitionedAccelerationStructureIndirectCommandNV(segment.asSlice(0, VkBuildPartitionedAccelerationStructureIndirectCommandNV.BYTES));
                segment = segment.asSlice(VkBuildPartitionedAccelerationStructureIndirectCommandNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkBuildPartitionedAccelerationStructureIndirectCommandNV allocate(Arena arena) {
        return new VkBuildPartitionedAccelerationStructureIndirectCommandNV(arena.allocate(LAYOUT));
    }

    public static VkBuildPartitionedAccelerationStructureIndirectCommandNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkBuildPartitionedAccelerationStructureIndirectCommandNV.Ptr(segment);
    }

    public static VkBuildPartitionedAccelerationStructureIndirectCommandNV clone(Arena arena, VkBuildPartitionedAccelerationStructureIndirectCommandNV src) {
        VkBuildPartitionedAccelerationStructureIndirectCommandNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @EnumType(VkPartitionedAccelerationStructureOpTypeNV.class) int opType() {
        return segment.get(LAYOUT$opType, OFFSET$opType);
    }

    public VkBuildPartitionedAccelerationStructureIndirectCommandNV opType(@EnumType(VkPartitionedAccelerationStructureOpTypeNV.class) int value) {
        segment.set(LAYOUT$opType, OFFSET$opType, value);
        return this;
    }

    public @Unsigned int argCount() {
        return segment.get(LAYOUT$argCount, OFFSET$argCount);
    }

    public VkBuildPartitionedAccelerationStructureIndirectCommandNV argCount(@Unsigned int value) {
        segment.set(LAYOUT$argCount, OFFSET$argCount, value);
        return this;
    }

    public @NotNull VkStridedDeviceAddressNV argData() {
        return new VkStridedDeviceAddressNV(segment.asSlice(OFFSET$argData, LAYOUT$argData));
    }

    public VkBuildPartitionedAccelerationStructureIndirectCommandNV argData(@NotNull VkStridedDeviceAddressNV value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$argData, SIZE$argData);
        return this;
    }

    public VkBuildPartitionedAccelerationStructureIndirectCommandNV argData(Consumer<@NotNull VkStridedDeviceAddressNV> consumer) {
        consumer.accept(argData());
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("opType"),
        ValueLayout.JAVA_INT.withName("argCount"),
        VkStridedDeviceAddressNV.LAYOUT.withName("argData")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$opType = PathElement.groupElement("opType");
    public static final PathElement PATH$argCount = PathElement.groupElement("argCount");
    public static final PathElement PATH$argData = PathElement.groupElement("argData");

    public static final OfInt LAYOUT$opType = (OfInt) LAYOUT.select(PATH$opType);
    public static final OfInt LAYOUT$argCount = (OfInt) LAYOUT.select(PATH$argCount);
    public static final StructLayout LAYOUT$argData = (StructLayout) LAYOUT.select(PATH$argData);

    public static final long SIZE$opType = LAYOUT$opType.byteSize();
    public static final long SIZE$argCount = LAYOUT$argCount.byteSize();
    public static final long SIZE$argData = LAYOUT$argData.byteSize();

    public static final long OFFSET$opType = LAYOUT.byteOffset(PATH$opType);
    public static final long OFFSET$argCount = LAYOUT.byteOffset(PATH$argCount);
    public static final long OFFSET$argData = LAYOUT.byteOffset(PATH$argData);
}
