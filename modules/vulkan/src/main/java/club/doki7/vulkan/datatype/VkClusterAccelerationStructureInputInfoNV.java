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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkClusterAccelerationStructureInputInfoNV.html"><code>VkClusterAccelerationStructureInputInfoNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkClusterAccelerationStructureInputInfoNV {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t maxAccelerationStructureCount; // @link substring="maxAccelerationStructureCount" target="#maxAccelerationStructureCount"
///     VkBuildAccelerationStructureFlagsKHR flags; // optional // @link substring="VkBuildAccelerationStructureFlagsKHR" target="VkBuildAccelerationStructureFlagsKHR" @link substring="flags" target="#flags"
///     VkClusterAccelerationStructureOpTypeNV opType; // @link substring="VkClusterAccelerationStructureOpTypeNV" target="VkClusterAccelerationStructureOpTypeNV" @link substring="opType" target="#opType"
///     VkClusterAccelerationStructureOpModeNV opMode; // @link substring="VkClusterAccelerationStructureOpModeNV" target="VkClusterAccelerationStructureOpModeNV" @link substring="opMode" target="#opMode"
///     VkClusterAccelerationStructureOpInputNV opInput; // @link substring="VkClusterAccelerationStructureOpInputNV" target="VkClusterAccelerationStructureOpInputNV" @link substring="opInput" target="#opInput"
/// } VkClusterAccelerationStructureInputInfoNV;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_CLUSTER_ACCELERATION_STRUCTURE_INPUT_INFO_NV`
///
/// The {@code allocate} ({@link VkClusterAccelerationStructureInputInfoNV#allocate(Arena)}, {@link VkClusterAccelerationStructureInputInfoNV#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkClusterAccelerationStructureInputInfoNV#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkClusterAccelerationStructureInputInfoNV.html"><code>VkClusterAccelerationStructureInputInfoNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkClusterAccelerationStructureInputInfoNV(@NotNull MemorySegment segment) implements IVkClusterAccelerationStructureInputInfoNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkClusterAccelerationStructureInputInfoNV.html"><code>VkClusterAccelerationStructureInputInfoNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkClusterAccelerationStructureInputInfoNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkClusterAccelerationStructureInputInfoNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkClusterAccelerationStructureInputInfoNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkClusterAccelerationStructureInputInfoNV, Iterable<VkClusterAccelerationStructureInputInfoNV> {
        public long size() {
            return segment.byteSize() / VkClusterAccelerationStructureInputInfoNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkClusterAccelerationStructureInputInfoNV at(long index) {
            return new VkClusterAccelerationStructureInputInfoNV(segment.asSlice(index * VkClusterAccelerationStructureInputInfoNV.BYTES, VkClusterAccelerationStructureInputInfoNV.BYTES));
        }

        public VkClusterAccelerationStructureInputInfoNV.Ptr at(long index, @NotNull Consumer<@NotNull VkClusterAccelerationStructureInputInfoNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkClusterAccelerationStructureInputInfoNV value) {
            MemorySegment s = segment.asSlice(index * VkClusterAccelerationStructureInputInfoNV.BYTES, VkClusterAccelerationStructureInputInfoNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkClusterAccelerationStructureInputInfoNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkClusterAccelerationStructureInputInfoNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkClusterAccelerationStructureInputInfoNV.BYTES,
                (end - start) * VkClusterAccelerationStructureInputInfoNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkClusterAccelerationStructureInputInfoNV.BYTES));
        }

        public VkClusterAccelerationStructureInputInfoNV[] toArray() {
            VkClusterAccelerationStructureInputInfoNV[] ret = new VkClusterAccelerationStructureInputInfoNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkClusterAccelerationStructureInputInfoNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkClusterAccelerationStructureInputInfoNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkClusterAccelerationStructureInputInfoNV.BYTES;
            }

            @Override
            public VkClusterAccelerationStructureInputInfoNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkClusterAccelerationStructureInputInfoNV ret = new VkClusterAccelerationStructureInputInfoNV(segment.asSlice(0, VkClusterAccelerationStructureInputInfoNV.BYTES));
                segment = segment.asSlice(VkClusterAccelerationStructureInputInfoNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkClusterAccelerationStructureInputInfoNV allocate(Arena arena) {
        VkClusterAccelerationStructureInputInfoNV ret = new VkClusterAccelerationStructureInputInfoNV(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.CLUSTER_ACCELERATION_STRUCTURE_INPUT_INFO_NV);
        return ret;
    }

    public static VkClusterAccelerationStructureInputInfoNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkClusterAccelerationStructureInputInfoNV.Ptr ret = new VkClusterAccelerationStructureInputInfoNV.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.CLUSTER_ACCELERATION_STRUCTURE_INPUT_INFO_NV);
        }
        return ret;
    }

    public static VkClusterAccelerationStructureInputInfoNV clone(Arena arena, VkClusterAccelerationStructureInputInfoNV src) {
        VkClusterAccelerationStructureInputInfoNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.CLUSTER_ACCELERATION_STRUCTURE_INPUT_INFO_NV);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkClusterAccelerationStructureInputInfoNV sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkClusterAccelerationStructureInputInfoNV pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkClusterAccelerationStructureInputInfoNV pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int maxAccelerationStructureCount() {
        return segment.get(LAYOUT$maxAccelerationStructureCount, OFFSET$maxAccelerationStructureCount);
    }

    public VkClusterAccelerationStructureInputInfoNV maxAccelerationStructureCount(@Unsigned int value) {
        segment.set(LAYOUT$maxAccelerationStructureCount, OFFSET$maxAccelerationStructureCount, value);
        return this;
    }

    public @Bitmask(VkBuildAccelerationStructureFlagsKHR.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkClusterAccelerationStructureInputInfoNV flags(@Bitmask(VkBuildAccelerationStructureFlagsKHR.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @EnumType(VkClusterAccelerationStructureOpTypeNV.class) int opType() {
        return segment.get(LAYOUT$opType, OFFSET$opType);
    }

    public VkClusterAccelerationStructureInputInfoNV opType(@EnumType(VkClusterAccelerationStructureOpTypeNV.class) int value) {
        segment.set(LAYOUT$opType, OFFSET$opType, value);
        return this;
    }

    public @EnumType(VkClusterAccelerationStructureOpModeNV.class) int opMode() {
        return segment.get(LAYOUT$opMode, OFFSET$opMode);
    }

    public VkClusterAccelerationStructureInputInfoNV opMode(@EnumType(VkClusterAccelerationStructureOpModeNV.class) int value) {
        segment.set(LAYOUT$opMode, OFFSET$opMode, value);
        return this;
    }

    public @NotNull VkClusterAccelerationStructureOpInputNV opInput() {
        return new VkClusterAccelerationStructureOpInputNV(segment.asSlice(OFFSET$opInput, LAYOUT$opInput));
    }

    public VkClusterAccelerationStructureInputInfoNV opInput(@NotNull VkClusterAccelerationStructureOpInputNV value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$opInput, SIZE$opInput);
        return this;
    }

    public VkClusterAccelerationStructureInputInfoNV opInput(Consumer<@NotNull VkClusterAccelerationStructureOpInputNV> consumer) {
        consumer.accept(opInput());
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("maxAccelerationStructureCount"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("opType"),
        ValueLayout.JAVA_INT.withName("opMode"),
        VkClusterAccelerationStructureOpInputNV.LAYOUT.withName("opInput")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$maxAccelerationStructureCount = PathElement.groupElement("maxAccelerationStructureCount");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$opType = PathElement.groupElement("opType");
    public static final PathElement PATH$opMode = PathElement.groupElement("opMode");
    public static final PathElement PATH$opInput = PathElement.groupElement("opInput");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$maxAccelerationStructureCount = (OfInt) LAYOUT.select(PATH$maxAccelerationStructureCount);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$opType = (OfInt) LAYOUT.select(PATH$opType);
    public static final OfInt LAYOUT$opMode = (OfInt) LAYOUT.select(PATH$opMode);
    public static final UnionLayout LAYOUT$opInput = (UnionLayout) LAYOUT.select(PATH$opInput);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$maxAccelerationStructureCount = LAYOUT$maxAccelerationStructureCount.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$opType = LAYOUT$opType.byteSize();
    public static final long SIZE$opMode = LAYOUT$opMode.byteSize();
    public static final long SIZE$opInput = LAYOUT$opInput.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$maxAccelerationStructureCount = LAYOUT.byteOffset(PATH$maxAccelerationStructureCount);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$opType = LAYOUT.byteOffset(PATH$opType);
    public static final long OFFSET$opMode = LAYOUT.byteOffset(PATH$opMode);
    public static final long OFFSET$opInput = LAYOUT.byteOffset(PATH$opInput);
}
