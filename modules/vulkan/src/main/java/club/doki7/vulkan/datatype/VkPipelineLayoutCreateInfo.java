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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineLayoutCreateInfo.html"><code>VkPipelineLayoutCreateInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPipelineLayoutCreateInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkPipelineLayoutCreateFlags flags; // optional // @link substring="VkPipelineLayoutCreateFlags" target="VkPipelineLayoutCreateFlags" @link substring="flags" target="#flags"
///     uint32_t setLayoutCount; // optional // @link substring="setLayoutCount" target="#setLayoutCount"
///     VkDescriptorSetLayout const* pSetLayouts; // optional // @link substring="VkDescriptorSetLayout" target="VkDescriptorSetLayout" @link substring="pSetLayouts" target="#pSetLayouts"
///     uint32_t pushConstantRangeCount; // optional // @link substring="pushConstantRangeCount" target="#pushConstantRangeCount"
///     VkPushConstantRange const* pPushConstantRanges; // optional // @link substring="VkPushConstantRange" target="VkPushConstantRange" @link substring="pPushConstantRanges" target="#pPushConstantRanges"
/// } VkPipelineLayoutCreateInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PIPELINE_LAYOUT_CREATE_INFO`
///
/// The {@code allocate} ({@link VkPipelineLayoutCreateInfo#allocate(Arena)}, {@link VkPipelineLayoutCreateInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPipelineLayoutCreateInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineLayoutCreateInfo.html"><code>VkPipelineLayoutCreateInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPipelineLayoutCreateInfo(@NotNull MemorySegment segment) implements IVkPipelineLayoutCreateInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineLayoutCreateInfo.html"><code>VkPipelineLayoutCreateInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPipelineLayoutCreateInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPipelineLayoutCreateInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPipelineLayoutCreateInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPipelineLayoutCreateInfo, Iterable<VkPipelineLayoutCreateInfo> {
        public long size() {
            return segment.byteSize() / VkPipelineLayoutCreateInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPipelineLayoutCreateInfo at(long index) {
            return new VkPipelineLayoutCreateInfo(segment.asSlice(index * VkPipelineLayoutCreateInfo.BYTES, VkPipelineLayoutCreateInfo.BYTES));
        }

        public VkPipelineLayoutCreateInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkPipelineLayoutCreateInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPipelineLayoutCreateInfo value) {
            MemorySegment s = segment.asSlice(index * VkPipelineLayoutCreateInfo.BYTES, VkPipelineLayoutCreateInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPipelineLayoutCreateInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPipelineLayoutCreateInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPipelineLayoutCreateInfo.BYTES,
                (end - start) * VkPipelineLayoutCreateInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPipelineLayoutCreateInfo.BYTES));
        }

        public VkPipelineLayoutCreateInfo[] toArray() {
            VkPipelineLayoutCreateInfo[] ret = new VkPipelineLayoutCreateInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPipelineLayoutCreateInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPipelineLayoutCreateInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPipelineLayoutCreateInfo.BYTES;
            }

            @Override
            public VkPipelineLayoutCreateInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPipelineLayoutCreateInfo ret = new VkPipelineLayoutCreateInfo(segment.asSlice(0, VkPipelineLayoutCreateInfo.BYTES));
                segment = segment.asSlice(VkPipelineLayoutCreateInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPipelineLayoutCreateInfo allocate(Arena arena) {
        VkPipelineLayoutCreateInfo ret = new VkPipelineLayoutCreateInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PIPELINE_LAYOUT_CREATE_INFO);
        return ret;
    }

    public static VkPipelineLayoutCreateInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPipelineLayoutCreateInfo.Ptr ret = new VkPipelineLayoutCreateInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PIPELINE_LAYOUT_CREATE_INFO);
        }
        return ret;
    }

    public static VkPipelineLayoutCreateInfo clone(Arena arena, VkPipelineLayoutCreateInfo src) {
        VkPipelineLayoutCreateInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PIPELINE_LAYOUT_CREATE_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPipelineLayoutCreateInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPipelineLayoutCreateInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPipelineLayoutCreateInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkPipelineLayoutCreateFlags.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkPipelineLayoutCreateInfo flags(@Bitmask(VkPipelineLayoutCreateFlags.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @Unsigned int setLayoutCount() {
        return segment.get(LAYOUT$setLayoutCount, OFFSET$setLayoutCount);
    }

    public VkPipelineLayoutCreateInfo setLayoutCount(@Unsigned int value) {
        segment.set(LAYOUT$setLayoutCount, OFFSET$setLayoutCount, value);
        return this;
    }

    /// Note: the returned {@link VkDescriptorSetLayout.Ptr} does not have correct {@link VkDescriptorSetLayout.Ptr#size}
    /// property. It's up to user to track the size of the buffer, and use
    /// {@link VkDescriptorSetLayout.Ptr#reinterpret} to set the size before actually reading from or writing to the
    /// buffer.
    public @Nullable VkDescriptorSetLayout.Ptr pSetLayouts() {
        MemorySegment s = pSetLayoutsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkDescriptorSetLayout.Ptr(s);
    }

    public VkPipelineLayoutCreateInfo pSetLayouts(@Nullable VkDescriptorSetLayout.Ptr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pSetLayoutsRaw(s);
        return this;
    }

    public @Pointer(target=VkDescriptorSetLayout.class) @NotNull MemorySegment pSetLayoutsRaw() {
        return segment.get(LAYOUT$pSetLayouts, OFFSET$pSetLayouts);
    }

    public void pSetLayoutsRaw(@Pointer(target=VkDescriptorSetLayout.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pSetLayouts, OFFSET$pSetLayouts, value);
    }

    public @Unsigned int pushConstantRangeCount() {
        return segment.get(LAYOUT$pushConstantRangeCount, OFFSET$pushConstantRangeCount);
    }

    public VkPipelineLayoutCreateInfo pushConstantRangeCount(@Unsigned int value) {
        segment.set(LAYOUT$pushConstantRangeCount, OFFSET$pushConstantRangeCount, value);
        return this;
    }

    public VkPipelineLayoutCreateInfo pPushConstantRanges(@Nullable IVkPushConstantRange value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pPushConstantRangesRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkPushConstantRange.Ptr pPushConstantRanges(int assumedCount) {
        MemorySegment s = pPushConstantRangesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkPushConstantRange.BYTES);
        return new VkPushConstantRange.Ptr(s);
    }

    public @Nullable VkPushConstantRange pPushConstantRanges() {
        MemorySegment s = pPushConstantRangesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkPushConstantRange(s);
    }

    public @Pointer(target=VkPushConstantRange.class) @NotNull MemorySegment pPushConstantRangesRaw() {
        return segment.get(LAYOUT$pPushConstantRanges, OFFSET$pPushConstantRanges);
    }

    public void pPushConstantRangesRaw(@Pointer(target=VkPushConstantRange.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pPushConstantRanges, OFFSET$pPushConstantRanges, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("setLayoutCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS).withName("pSetLayouts"),
        ValueLayout.JAVA_INT.withName("pushConstantRangeCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkPushConstantRange.LAYOUT).withName("pPushConstantRanges")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$setLayoutCount = PathElement.groupElement("setLayoutCount");
    public static final PathElement PATH$pSetLayouts = PathElement.groupElement("pSetLayouts");
    public static final PathElement PATH$pushConstantRangeCount = PathElement.groupElement("pushConstantRangeCount");
    public static final PathElement PATH$pPushConstantRanges = PathElement.groupElement("pPushConstantRanges");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$setLayoutCount = (OfInt) LAYOUT.select(PATH$setLayoutCount);
    public static final AddressLayout LAYOUT$pSetLayouts = (AddressLayout) LAYOUT.select(PATH$pSetLayouts);
    public static final OfInt LAYOUT$pushConstantRangeCount = (OfInt) LAYOUT.select(PATH$pushConstantRangeCount);
    public static final AddressLayout LAYOUT$pPushConstantRanges = (AddressLayout) LAYOUT.select(PATH$pPushConstantRanges);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$setLayoutCount = LAYOUT$setLayoutCount.byteSize();
    public static final long SIZE$pSetLayouts = LAYOUT$pSetLayouts.byteSize();
    public static final long SIZE$pushConstantRangeCount = LAYOUT$pushConstantRangeCount.byteSize();
    public static final long SIZE$pPushConstantRanges = LAYOUT$pPushConstantRanges.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$setLayoutCount = LAYOUT.byteOffset(PATH$setLayoutCount);
    public static final long OFFSET$pSetLayouts = LAYOUT.byteOffset(PATH$pSetLayouts);
    public static final long OFFSET$pushConstantRangeCount = LAYOUT.byteOffset(PATH$pushConstantRangeCount);
    public static final long OFFSET$pPushConstantRanges = LAYOUT.byteOffset(PATH$pPushConstantRanges);
}
