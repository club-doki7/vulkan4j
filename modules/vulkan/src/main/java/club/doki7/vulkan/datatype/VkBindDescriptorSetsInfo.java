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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBindDescriptorSetsInfo.html"><code>VkBindDescriptorSetsInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkBindDescriptorSetsInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkShaderStageFlags stageFlags; // @link substring="VkShaderStageFlags" target="VkShaderStageFlags" @link substring="stageFlags" target="#stageFlags"
///     VkPipelineLayout layout; // optional // @link substring="VkPipelineLayout" target="VkPipelineLayout" @link substring="layout" target="#layout"
///     uint32_t firstSet; // optional // @link substring="firstSet" target="#firstSet"
///     uint32_t descriptorSetCount; // @link substring="descriptorSetCount" target="#descriptorSetCount"
///     VkDescriptorSet const* pDescriptorSets; // @link substring="VkDescriptorSet" target="VkDescriptorSet" @link substring="pDescriptorSets" target="#pDescriptorSets"
///     uint32_t dynamicOffsetCount; // optional // @link substring="dynamicOffsetCount" target="#dynamicOffsetCount"
///     uint32_t const* pDynamicOffsets; // optional // @link substring="pDynamicOffsets" target="#pDynamicOffsets"
/// } VkBindDescriptorSetsInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_BIND_DESCRIPTOR_SETS_INFO`
///
/// The {@code allocate} ({@link VkBindDescriptorSetsInfo#allocate(Arena)}, {@link VkBindDescriptorSetsInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkBindDescriptorSetsInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBindDescriptorSetsInfo.html"><code>VkBindDescriptorSetsInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkBindDescriptorSetsInfo(@NotNull MemorySegment segment) implements IVkBindDescriptorSetsInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBindDescriptorSetsInfo.html"><code>VkBindDescriptorSetsInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkBindDescriptorSetsInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkBindDescriptorSetsInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkBindDescriptorSetsInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkBindDescriptorSetsInfo, Iterable<VkBindDescriptorSetsInfo> {
        public long size() {
            return segment.byteSize() / VkBindDescriptorSetsInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkBindDescriptorSetsInfo at(long index) {
            return new VkBindDescriptorSetsInfo(segment.asSlice(index * VkBindDescriptorSetsInfo.BYTES, VkBindDescriptorSetsInfo.BYTES));
        }

        public VkBindDescriptorSetsInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkBindDescriptorSetsInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkBindDescriptorSetsInfo value) {
            MemorySegment s = segment.asSlice(index * VkBindDescriptorSetsInfo.BYTES, VkBindDescriptorSetsInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkBindDescriptorSetsInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkBindDescriptorSetsInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkBindDescriptorSetsInfo.BYTES,
                (end - start) * VkBindDescriptorSetsInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkBindDescriptorSetsInfo.BYTES));
        }

        public VkBindDescriptorSetsInfo[] toArray() {
            VkBindDescriptorSetsInfo[] ret = new VkBindDescriptorSetsInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkBindDescriptorSetsInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkBindDescriptorSetsInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkBindDescriptorSetsInfo.BYTES;
            }

            @Override
            public VkBindDescriptorSetsInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkBindDescriptorSetsInfo ret = new VkBindDescriptorSetsInfo(segment.asSlice(0, VkBindDescriptorSetsInfo.BYTES));
                segment = segment.asSlice(VkBindDescriptorSetsInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkBindDescriptorSetsInfo allocate(Arena arena) {
        VkBindDescriptorSetsInfo ret = new VkBindDescriptorSetsInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.BIND_DESCRIPTOR_SETS_INFO);
        return ret;
    }

    public static VkBindDescriptorSetsInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkBindDescriptorSetsInfo.Ptr ret = new VkBindDescriptorSetsInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.BIND_DESCRIPTOR_SETS_INFO);
        }
        return ret;
    }

    public static VkBindDescriptorSetsInfo clone(Arena arena, VkBindDescriptorSetsInfo src) {
        VkBindDescriptorSetsInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.BIND_DESCRIPTOR_SETS_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkBindDescriptorSetsInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkBindDescriptorSetsInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkBindDescriptorSetsInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkShaderStageFlags.class) int stageFlags() {
        return segment.get(LAYOUT$stageFlags, OFFSET$stageFlags);
    }

    public VkBindDescriptorSetsInfo stageFlags(@Bitmask(VkShaderStageFlags.class) int value) {
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

    public VkBindDescriptorSetsInfo layout(@Nullable VkPipelineLayout value) {
        segment.set(LAYOUT$layout, OFFSET$layout, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int firstSet() {
        return segment.get(LAYOUT$firstSet, OFFSET$firstSet);
    }

    public VkBindDescriptorSetsInfo firstSet(@Unsigned int value) {
        segment.set(LAYOUT$firstSet, OFFSET$firstSet, value);
        return this;
    }

    public @Unsigned int descriptorSetCount() {
        return segment.get(LAYOUT$descriptorSetCount, OFFSET$descriptorSetCount);
    }

    public VkBindDescriptorSetsInfo descriptorSetCount(@Unsigned int value) {
        segment.set(LAYOUT$descriptorSetCount, OFFSET$descriptorSetCount, value);
        return this;
    }

    /// Note: the returned {@link VkDescriptorSet.Ptr} does not have correct {@link VkDescriptorSet.Ptr#size}
    /// property. It's up to user to track the size of the buffer, and use
    /// {@link VkDescriptorSet.Ptr#reinterpret} to set the size before actually reading from or writing to the
    /// buffer.
    public @Nullable VkDescriptorSet.Ptr pDescriptorSets() {
        MemorySegment s = pDescriptorSetsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkDescriptorSet.Ptr(s);
    }

    public VkBindDescriptorSetsInfo pDescriptorSets(@Nullable VkDescriptorSet.Ptr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pDescriptorSetsRaw(s);
        return this;
    }

    public @Pointer(target=VkDescriptorSet.class) @NotNull MemorySegment pDescriptorSetsRaw() {
        return segment.get(LAYOUT$pDescriptorSets, OFFSET$pDescriptorSets);
    }

    public void pDescriptorSetsRaw(@Pointer(target=VkDescriptorSet.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pDescriptorSets, OFFSET$pDescriptorSets, value);
    }

    public @Unsigned int dynamicOffsetCount() {
        return segment.get(LAYOUT$dynamicOffsetCount, OFFSET$dynamicOffsetCount);
    }

    public VkBindDescriptorSetsInfo dynamicOffsetCount(@Unsigned int value) {
        segment.set(LAYOUT$dynamicOffsetCount, OFFSET$dynamicOffsetCount, value);
        return this;
    }

    /// Note: the returned {@link IntPtr} does not have correct
    /// {@link IntPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link IntPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable @Unsigned IntPtr pDynamicOffsets() {
        MemorySegment s = pDynamicOffsetsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new IntPtr(s);
    }

    public VkBindDescriptorSetsInfo pDynamicOffsets(@Nullable @Unsigned IntPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pDynamicOffsetsRaw(s);
        return this;
    }

    public @Pointer(comment="uint32_t*") @NotNull MemorySegment pDynamicOffsetsRaw() {
        return segment.get(LAYOUT$pDynamicOffsets, OFFSET$pDynamicOffsets);
    }

    public void pDynamicOffsetsRaw(@Pointer(comment="uint32_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pDynamicOffsets, OFFSET$pDynamicOffsets, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("stageFlags"),
        ValueLayout.ADDRESS.withName("layout"),
        ValueLayout.JAVA_INT.withName("firstSet"),
        ValueLayout.JAVA_INT.withName("descriptorSetCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS).withName("pDescriptorSets"),
        ValueLayout.JAVA_INT.withName("dynamicOffsetCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pDynamicOffsets")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$stageFlags = PathElement.groupElement("stageFlags");
    public static final PathElement PATH$layout = PathElement.groupElement("layout");
    public static final PathElement PATH$firstSet = PathElement.groupElement("firstSet");
    public static final PathElement PATH$descriptorSetCount = PathElement.groupElement("descriptorSetCount");
    public static final PathElement PATH$pDescriptorSets = PathElement.groupElement("pDescriptorSets");
    public static final PathElement PATH$dynamicOffsetCount = PathElement.groupElement("dynamicOffsetCount");
    public static final PathElement PATH$pDynamicOffsets = PathElement.groupElement("pDynamicOffsets");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$stageFlags = (OfInt) LAYOUT.select(PATH$stageFlags);
    public static final AddressLayout LAYOUT$layout = (AddressLayout) LAYOUT.select(PATH$layout);
    public static final OfInt LAYOUT$firstSet = (OfInt) LAYOUT.select(PATH$firstSet);
    public static final OfInt LAYOUT$descriptorSetCount = (OfInt) LAYOUT.select(PATH$descriptorSetCount);
    public static final AddressLayout LAYOUT$pDescriptorSets = (AddressLayout) LAYOUT.select(PATH$pDescriptorSets);
    public static final OfInt LAYOUT$dynamicOffsetCount = (OfInt) LAYOUT.select(PATH$dynamicOffsetCount);
    public static final AddressLayout LAYOUT$pDynamicOffsets = (AddressLayout) LAYOUT.select(PATH$pDynamicOffsets);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$stageFlags = LAYOUT$stageFlags.byteSize();
    public static final long SIZE$layout = LAYOUT$layout.byteSize();
    public static final long SIZE$firstSet = LAYOUT$firstSet.byteSize();
    public static final long SIZE$descriptorSetCount = LAYOUT$descriptorSetCount.byteSize();
    public static final long SIZE$pDescriptorSets = LAYOUT$pDescriptorSets.byteSize();
    public static final long SIZE$dynamicOffsetCount = LAYOUT$dynamicOffsetCount.byteSize();
    public static final long SIZE$pDynamicOffsets = LAYOUT$pDynamicOffsets.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$stageFlags = LAYOUT.byteOffset(PATH$stageFlags);
    public static final long OFFSET$layout = LAYOUT.byteOffset(PATH$layout);
    public static final long OFFSET$firstSet = LAYOUT.byteOffset(PATH$firstSet);
    public static final long OFFSET$descriptorSetCount = LAYOUT.byteOffset(PATH$descriptorSetCount);
    public static final long OFFSET$pDescriptorSets = LAYOUT.byteOffset(PATH$pDescriptorSets);
    public static final long OFFSET$dynamicOffsetCount = LAYOUT.byteOffset(PATH$dynamicOffsetCount);
    public static final long OFFSET$pDynamicOffsets = LAYOUT.byteOffset(PATH$pDynamicOffsets);
}
