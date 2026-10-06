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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDescriptorSetVariableDescriptorCountAllocateInfo.html"><code>VkDescriptorSetVariableDescriptorCountAllocateInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDescriptorSetVariableDescriptorCountAllocateInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t descriptorSetCount; // optional // @link substring="descriptorSetCount" target="#descriptorSetCount"
///     uint32_t const* pDescriptorCounts; // optional // @link substring="pDescriptorCounts" target="#pDescriptorCounts"
/// } VkDescriptorSetVariableDescriptorCountAllocateInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_DESCRIPTOR_SET_VARIABLE_DESCRIPTOR_COUNT_ALLOCATE_INFO`
///
/// The {@code allocate} ({@link VkDescriptorSetVariableDescriptorCountAllocateInfo#allocate(Arena)}, {@link VkDescriptorSetVariableDescriptorCountAllocateInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkDescriptorSetVariableDescriptorCountAllocateInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDescriptorSetVariableDescriptorCountAllocateInfo.html"><code>VkDescriptorSetVariableDescriptorCountAllocateInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDescriptorSetVariableDescriptorCountAllocateInfo(@NotNull MemorySegment segment) implements IVkDescriptorSetVariableDescriptorCountAllocateInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDescriptorSetVariableDescriptorCountAllocateInfo.html"><code>VkDescriptorSetVariableDescriptorCountAllocateInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDescriptorSetVariableDescriptorCountAllocateInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDescriptorSetVariableDescriptorCountAllocateInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDescriptorSetVariableDescriptorCountAllocateInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDescriptorSetVariableDescriptorCountAllocateInfo, Iterable<VkDescriptorSetVariableDescriptorCountAllocateInfo> {
        public long size() {
            return segment.byteSize() / VkDescriptorSetVariableDescriptorCountAllocateInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDescriptorSetVariableDescriptorCountAllocateInfo at(long index) {
            return new VkDescriptorSetVariableDescriptorCountAllocateInfo(segment.asSlice(index * VkDescriptorSetVariableDescriptorCountAllocateInfo.BYTES, VkDescriptorSetVariableDescriptorCountAllocateInfo.BYTES));
        }

        public VkDescriptorSetVariableDescriptorCountAllocateInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkDescriptorSetVariableDescriptorCountAllocateInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDescriptorSetVariableDescriptorCountAllocateInfo value) {
            MemorySegment s = segment.asSlice(index * VkDescriptorSetVariableDescriptorCountAllocateInfo.BYTES, VkDescriptorSetVariableDescriptorCountAllocateInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDescriptorSetVariableDescriptorCountAllocateInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDescriptorSetVariableDescriptorCountAllocateInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDescriptorSetVariableDescriptorCountAllocateInfo.BYTES,
                (end - start) * VkDescriptorSetVariableDescriptorCountAllocateInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDescriptorSetVariableDescriptorCountAllocateInfo.BYTES));
        }

        public VkDescriptorSetVariableDescriptorCountAllocateInfo[] toArray() {
            VkDescriptorSetVariableDescriptorCountAllocateInfo[] ret = new VkDescriptorSetVariableDescriptorCountAllocateInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDescriptorSetVariableDescriptorCountAllocateInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDescriptorSetVariableDescriptorCountAllocateInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDescriptorSetVariableDescriptorCountAllocateInfo.BYTES;
            }

            @Override
            public VkDescriptorSetVariableDescriptorCountAllocateInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDescriptorSetVariableDescriptorCountAllocateInfo ret = new VkDescriptorSetVariableDescriptorCountAllocateInfo(segment.asSlice(0, VkDescriptorSetVariableDescriptorCountAllocateInfo.BYTES));
                segment = segment.asSlice(VkDescriptorSetVariableDescriptorCountAllocateInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDescriptorSetVariableDescriptorCountAllocateInfo allocate(Arena arena) {
        VkDescriptorSetVariableDescriptorCountAllocateInfo ret = new VkDescriptorSetVariableDescriptorCountAllocateInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.DESCRIPTOR_SET_VARIABLE_DESCRIPTOR_COUNT_ALLOCATE_INFO);
        return ret;
    }

    public static VkDescriptorSetVariableDescriptorCountAllocateInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkDescriptorSetVariableDescriptorCountAllocateInfo.Ptr ret = new VkDescriptorSetVariableDescriptorCountAllocateInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.DESCRIPTOR_SET_VARIABLE_DESCRIPTOR_COUNT_ALLOCATE_INFO);
        }
        return ret;
    }

    public static VkDescriptorSetVariableDescriptorCountAllocateInfo clone(Arena arena, VkDescriptorSetVariableDescriptorCountAllocateInfo src) {
        VkDescriptorSetVariableDescriptorCountAllocateInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.DESCRIPTOR_SET_VARIABLE_DESCRIPTOR_COUNT_ALLOCATE_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkDescriptorSetVariableDescriptorCountAllocateInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkDescriptorSetVariableDescriptorCountAllocateInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkDescriptorSetVariableDescriptorCountAllocateInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int descriptorSetCount() {
        return segment.get(LAYOUT$descriptorSetCount, OFFSET$descriptorSetCount);
    }

    public VkDescriptorSetVariableDescriptorCountAllocateInfo descriptorSetCount(@Unsigned int value) {
        segment.set(LAYOUT$descriptorSetCount, OFFSET$descriptorSetCount, value);
        return this;
    }

    /// Note: the returned {@link IntPtr} does not have correct
    /// {@link IntPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link IntPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable @Unsigned IntPtr pDescriptorCounts() {
        MemorySegment s = pDescriptorCountsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new IntPtr(s);
    }

    public VkDescriptorSetVariableDescriptorCountAllocateInfo pDescriptorCounts(@Nullable @Unsigned IntPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pDescriptorCountsRaw(s);
        return this;
    }

    public @Pointer(comment="uint32_t*") @NotNull MemorySegment pDescriptorCountsRaw() {
        return segment.get(LAYOUT$pDescriptorCounts, OFFSET$pDescriptorCounts);
    }

    public void pDescriptorCountsRaw(@Pointer(comment="uint32_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pDescriptorCounts, OFFSET$pDescriptorCounts, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("descriptorSetCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pDescriptorCounts")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$descriptorSetCount = PathElement.groupElement("descriptorSetCount");
    public static final PathElement PATH$pDescriptorCounts = PathElement.groupElement("pDescriptorCounts");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$descriptorSetCount = (OfInt) LAYOUT.select(PATH$descriptorSetCount);
    public static final AddressLayout LAYOUT$pDescriptorCounts = (AddressLayout) LAYOUT.select(PATH$pDescriptorCounts);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$descriptorSetCount = LAYOUT$descriptorSetCount.byteSize();
    public static final long SIZE$pDescriptorCounts = LAYOUT$pDescriptorCounts.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$descriptorSetCount = LAYOUT.byteOffset(PATH$descriptorSetCount);
    public static final long OFFSET$pDescriptorCounts = LAYOUT.byteOffset(PATH$pDescriptorCounts);
}
