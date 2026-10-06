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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSetDescriptorBufferOffsetsInfoEXT.html"><code>VkSetDescriptorBufferOffsetsInfoEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkSetDescriptorBufferOffsetsInfoEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkShaderStageFlags stageFlags; // @link substring="VkShaderStageFlags" target="VkShaderStageFlags" @link substring="stageFlags" target="#stageFlags"
///     VkPipelineLayout layout; // optional // @link substring="VkPipelineLayout" target="VkPipelineLayout" @link substring="layout" target="#layout"
///     uint32_t firstSet; // optional // @link substring="firstSet" target="#firstSet"
///     uint32_t setCount; // @link substring="setCount" target="#setCount"
///     uint32_t const* pBufferIndices; // @link substring="pBufferIndices" target="#pBufferIndices"
///     VkDeviceSize const* pOffsets; // @link substring="pOffsets" target="#pOffsets"
/// } VkSetDescriptorBufferOffsetsInfoEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_SET_DESCRIPTOR_BUFFER_OFFSETS_INFO_EXT`
///
/// The {@code allocate} ({@link VkSetDescriptorBufferOffsetsInfoEXT#allocate(Arena)}, {@link VkSetDescriptorBufferOffsetsInfoEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkSetDescriptorBufferOffsetsInfoEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSetDescriptorBufferOffsetsInfoEXT.html"><code>VkSetDescriptorBufferOffsetsInfoEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkSetDescriptorBufferOffsetsInfoEXT(@NotNull MemorySegment segment) implements IVkSetDescriptorBufferOffsetsInfoEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSetDescriptorBufferOffsetsInfoEXT.html"><code>VkSetDescriptorBufferOffsetsInfoEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkSetDescriptorBufferOffsetsInfoEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkSetDescriptorBufferOffsetsInfoEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkSetDescriptorBufferOffsetsInfoEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkSetDescriptorBufferOffsetsInfoEXT, Iterable<VkSetDescriptorBufferOffsetsInfoEXT> {
        public long size() {
            return segment.byteSize() / VkSetDescriptorBufferOffsetsInfoEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkSetDescriptorBufferOffsetsInfoEXT at(long index) {
            return new VkSetDescriptorBufferOffsetsInfoEXT(segment.asSlice(index * VkSetDescriptorBufferOffsetsInfoEXT.BYTES, VkSetDescriptorBufferOffsetsInfoEXT.BYTES));
        }

        public VkSetDescriptorBufferOffsetsInfoEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkSetDescriptorBufferOffsetsInfoEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkSetDescriptorBufferOffsetsInfoEXT value) {
            MemorySegment s = segment.asSlice(index * VkSetDescriptorBufferOffsetsInfoEXT.BYTES, VkSetDescriptorBufferOffsetsInfoEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkSetDescriptorBufferOffsetsInfoEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkSetDescriptorBufferOffsetsInfoEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkSetDescriptorBufferOffsetsInfoEXT.BYTES,
                (end - start) * VkSetDescriptorBufferOffsetsInfoEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkSetDescriptorBufferOffsetsInfoEXT.BYTES));
        }

        public VkSetDescriptorBufferOffsetsInfoEXT[] toArray() {
            VkSetDescriptorBufferOffsetsInfoEXT[] ret = new VkSetDescriptorBufferOffsetsInfoEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkSetDescriptorBufferOffsetsInfoEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkSetDescriptorBufferOffsetsInfoEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkSetDescriptorBufferOffsetsInfoEXT.BYTES;
            }

            @Override
            public VkSetDescriptorBufferOffsetsInfoEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkSetDescriptorBufferOffsetsInfoEXT ret = new VkSetDescriptorBufferOffsetsInfoEXT(segment.asSlice(0, VkSetDescriptorBufferOffsetsInfoEXT.BYTES));
                segment = segment.asSlice(VkSetDescriptorBufferOffsetsInfoEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkSetDescriptorBufferOffsetsInfoEXT allocate(Arena arena) {
        VkSetDescriptorBufferOffsetsInfoEXT ret = new VkSetDescriptorBufferOffsetsInfoEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.SET_DESCRIPTOR_BUFFER_OFFSETS_INFO_EXT);
        return ret;
    }

    public static VkSetDescriptorBufferOffsetsInfoEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkSetDescriptorBufferOffsetsInfoEXT.Ptr ret = new VkSetDescriptorBufferOffsetsInfoEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.SET_DESCRIPTOR_BUFFER_OFFSETS_INFO_EXT);
        }
        return ret;
    }

    public static VkSetDescriptorBufferOffsetsInfoEXT clone(Arena arena, VkSetDescriptorBufferOffsetsInfoEXT src) {
        VkSetDescriptorBufferOffsetsInfoEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.SET_DESCRIPTOR_BUFFER_OFFSETS_INFO_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkSetDescriptorBufferOffsetsInfoEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkSetDescriptorBufferOffsetsInfoEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkSetDescriptorBufferOffsetsInfoEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkShaderStageFlags.class) int stageFlags() {
        return segment.get(LAYOUT$stageFlags, OFFSET$stageFlags);
    }

    public VkSetDescriptorBufferOffsetsInfoEXT stageFlags(@Bitmask(VkShaderStageFlags.class) int value) {
        segment.set(LAYOUT$stageFlags, OFFSET$stageFlags, value);
        return this;
    }

    public @Nullable VkPipelineLayout layout() {
        MemorySegment s = segment.asSlice(OFFSET$layout, SIZE$layout);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkPipelineLayout(s);
    }

    public VkSetDescriptorBufferOffsetsInfoEXT layout(@Nullable VkPipelineLayout value) {
        segment.set(LAYOUT$layout, OFFSET$layout, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int firstSet() {
        return segment.get(LAYOUT$firstSet, OFFSET$firstSet);
    }

    public VkSetDescriptorBufferOffsetsInfoEXT firstSet(@Unsigned int value) {
        segment.set(LAYOUT$firstSet, OFFSET$firstSet, value);
        return this;
    }

    public @Unsigned int setCount() {
        return segment.get(LAYOUT$setCount, OFFSET$setCount);
    }

    public VkSetDescriptorBufferOffsetsInfoEXT setCount(@Unsigned int value) {
        segment.set(LAYOUT$setCount, OFFSET$setCount, value);
        return this;
    }

    /// Note: the returned {@link IntPtr} does not have correct
    /// {@link IntPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link IntPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable @Unsigned IntPtr pBufferIndices() {
        MemorySegment s = pBufferIndicesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new IntPtr(s);
    }

    public VkSetDescriptorBufferOffsetsInfoEXT pBufferIndices(@Nullable @Unsigned IntPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pBufferIndicesRaw(s);
        return this;
    }

    public @Pointer(comment="uint32_t*") @NotNull MemorySegment pBufferIndicesRaw() {
        return segment.get(LAYOUT$pBufferIndices, OFFSET$pBufferIndices);
    }

    public void pBufferIndicesRaw(@Pointer(comment="uint32_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pBufferIndices, OFFSET$pBufferIndices, value);
    }

    /// Note: the returned {@link LongPtr} does not have correct
    /// {@link LongPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link LongPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable @Pointer(comment="VkDeviceSize") @Unsigned LongPtr pOffsets() {
        MemorySegment s = pOffsetsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new LongPtr(s);
    }

    public VkSetDescriptorBufferOffsetsInfoEXT pOffsets(@Nullable @Pointer(comment="VkDeviceSize") @Unsigned LongPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pOffsetsRaw(s);
        return this;
    }

    public @Pointer(comment="uint64_t*") @NotNull MemorySegment pOffsetsRaw() {
        return segment.get(LAYOUT$pOffsets, OFFSET$pOffsets);
    }

    public void pOffsetsRaw(@Pointer(comment="uint64_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pOffsets, OFFSET$pOffsets, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("stageFlags"),
        ValueLayout.ADDRESS.withName("layout"),
        ValueLayout.JAVA_INT.withName("firstSet"),
        ValueLayout.JAVA_INT.withName("setCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pBufferIndices"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG).withName("pOffsets")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$stageFlags = PathElement.groupElement("stageFlags");
    public static final PathElement PATH$layout = PathElement.groupElement("layout");
    public static final PathElement PATH$firstSet = PathElement.groupElement("firstSet");
    public static final PathElement PATH$setCount = PathElement.groupElement("setCount");
    public static final PathElement PATH$pBufferIndices = PathElement.groupElement("pBufferIndices");
    public static final PathElement PATH$pOffsets = PathElement.groupElement("pOffsets");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$stageFlags = (OfInt) LAYOUT.select(PATH$stageFlags);
    public static final AddressLayout LAYOUT$layout = (AddressLayout) LAYOUT.select(PATH$layout);
    public static final OfInt LAYOUT$firstSet = (OfInt) LAYOUT.select(PATH$firstSet);
    public static final OfInt LAYOUT$setCount = (OfInt) LAYOUT.select(PATH$setCount);
    public static final AddressLayout LAYOUT$pBufferIndices = (AddressLayout) LAYOUT.select(PATH$pBufferIndices);
    public static final AddressLayout LAYOUT$pOffsets = (AddressLayout) LAYOUT.select(PATH$pOffsets);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$stageFlags = LAYOUT$stageFlags.byteSize();
    public static final long SIZE$layout = LAYOUT$layout.byteSize();
    public static final long SIZE$firstSet = LAYOUT$firstSet.byteSize();
    public static final long SIZE$setCount = LAYOUT$setCount.byteSize();
    public static final long SIZE$pBufferIndices = LAYOUT$pBufferIndices.byteSize();
    public static final long SIZE$pOffsets = LAYOUT$pOffsets.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$stageFlags = LAYOUT.byteOffset(PATH$stageFlags);
    public static final long OFFSET$layout = LAYOUT.byteOffset(PATH$layout);
    public static final long OFFSET$firstSet = LAYOUT.byteOffset(PATH$firstSet);
    public static final long OFFSET$setCount = LAYOUT.byteOffset(PATH$setCount);
    public static final long OFFSET$pBufferIndices = LAYOUT.byteOffset(PATH$pBufferIndices);
    public static final long OFFSET$pOffsets = LAYOUT.byteOffset(PATH$pOffsets);
}
