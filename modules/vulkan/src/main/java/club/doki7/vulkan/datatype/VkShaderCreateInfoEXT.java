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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkShaderCreateInfoEXT.html"><code>VkShaderCreateInfoEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkShaderCreateInfoEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkShaderCreateFlagsEXT flags; // optional // @link substring="VkShaderCreateFlagsEXT" target="VkShaderCreateFlagsEXT" @link substring="flags" target="#flags"
///     VkShaderStageFlags stage; // @link substring="VkShaderStageFlags" target="VkShaderStageFlags" @link substring="stage" target="#stage"
///     VkShaderStageFlags nextStage; // optional // @link substring="VkShaderStageFlags" target="VkShaderStageFlags" @link substring="nextStage" target="#nextStage"
///     VkShaderCodeTypeEXT codeType; // @link substring="VkShaderCodeTypeEXT" target="VkShaderCodeTypeEXT" @link substring="codeType" target="#codeType"
///     size_t codeSize; // @link substring="codeSize" target="#codeSize"
///     void const* pCode; // @link substring="pCode" target="#pCode"
///     char const* pName; // optional // @link substring="pName" target="#pName"
///     uint32_t setLayoutCount; // optional // @link substring="setLayoutCount" target="#setLayoutCount"
///     VkDescriptorSetLayout const* pSetLayouts; // optional // @link substring="VkDescriptorSetLayout" target="VkDescriptorSetLayout" @link substring="pSetLayouts" target="#pSetLayouts"
///     uint32_t pushConstantRangeCount; // optional // @link substring="pushConstantRangeCount" target="#pushConstantRangeCount"
///     VkPushConstantRange const* pPushConstantRanges; // optional // @link substring="VkPushConstantRange" target="VkPushConstantRange" @link substring="pPushConstantRanges" target="#pPushConstantRanges"
///     VkSpecializationInfo const* pSpecializationInfo; // optional // @link substring="VkSpecializationInfo" target="VkSpecializationInfo" @link substring="pSpecializationInfo" target="#pSpecializationInfo"
/// } VkShaderCreateInfoEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_SHADER_CREATE_INFO_EXT`
///
/// The {@code allocate} ({@link VkShaderCreateInfoEXT#allocate(Arena)}, {@link VkShaderCreateInfoEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkShaderCreateInfoEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkShaderCreateInfoEXT.html"><code>VkShaderCreateInfoEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkShaderCreateInfoEXT(@NotNull MemorySegment segment) implements IVkShaderCreateInfoEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkShaderCreateInfoEXT.html"><code>VkShaderCreateInfoEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkShaderCreateInfoEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkShaderCreateInfoEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkShaderCreateInfoEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkShaderCreateInfoEXT, Iterable<VkShaderCreateInfoEXT> {
        public long size() {
            return segment.byteSize() / VkShaderCreateInfoEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkShaderCreateInfoEXT at(long index) {
            return new VkShaderCreateInfoEXT(segment.asSlice(index * VkShaderCreateInfoEXT.BYTES, VkShaderCreateInfoEXT.BYTES));
        }

        public VkShaderCreateInfoEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkShaderCreateInfoEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkShaderCreateInfoEXT value) {
            MemorySegment s = segment.asSlice(index * VkShaderCreateInfoEXT.BYTES, VkShaderCreateInfoEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkShaderCreateInfoEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkShaderCreateInfoEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkShaderCreateInfoEXT.BYTES,
                (end - start) * VkShaderCreateInfoEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkShaderCreateInfoEXT.BYTES));
        }

        public VkShaderCreateInfoEXT[] toArray() {
            VkShaderCreateInfoEXT[] ret = new VkShaderCreateInfoEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkShaderCreateInfoEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkShaderCreateInfoEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkShaderCreateInfoEXT.BYTES;
            }

            @Override
            public VkShaderCreateInfoEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkShaderCreateInfoEXT ret = new VkShaderCreateInfoEXT(segment.asSlice(0, VkShaderCreateInfoEXT.BYTES));
                segment = segment.asSlice(VkShaderCreateInfoEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkShaderCreateInfoEXT allocate(Arena arena) {
        VkShaderCreateInfoEXT ret = new VkShaderCreateInfoEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.SHADER_CREATE_INFO_EXT);
        return ret;
    }

    public static VkShaderCreateInfoEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkShaderCreateInfoEXT.Ptr ret = new VkShaderCreateInfoEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.SHADER_CREATE_INFO_EXT);
        }
        return ret;
    }

    public static VkShaderCreateInfoEXT clone(Arena arena, VkShaderCreateInfoEXT src) {
        VkShaderCreateInfoEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.SHADER_CREATE_INFO_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkShaderCreateInfoEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkShaderCreateInfoEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkShaderCreateInfoEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkShaderCreateFlagsEXT.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkShaderCreateInfoEXT flags(@Bitmask(VkShaderCreateFlagsEXT.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @Bitmask(VkShaderStageFlags.class) int stage() {
        return segment.get(LAYOUT$stage, OFFSET$stage);
    }

    public VkShaderCreateInfoEXT stage(@Bitmask(VkShaderStageFlags.class) int value) {
        segment.set(LAYOUT$stage, OFFSET$stage, value);
        return this;
    }

    public @Bitmask(VkShaderStageFlags.class) int nextStage() {
        return segment.get(LAYOUT$nextStage, OFFSET$nextStage);
    }

    public VkShaderCreateInfoEXT nextStage(@Bitmask(VkShaderStageFlags.class) int value) {
        segment.set(LAYOUT$nextStage, OFFSET$nextStage, value);
        return this;
    }

    public @EnumType(VkShaderCodeTypeEXT.class) int codeType() {
        return segment.get(LAYOUT$codeType, OFFSET$codeType);
    }

    public VkShaderCreateInfoEXT codeType(@EnumType(VkShaderCodeTypeEXT.class) int value) {
        segment.set(LAYOUT$codeType, OFFSET$codeType, value);
        return this;
    }

    public @Unsigned long codeSize() {
        return NativeLayout.readCSizeT(segment, OFFSET$codeSize);
    }

    public VkShaderCreateInfoEXT codeSize(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$codeSize, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pCode() {
        return segment.get(LAYOUT$pCode, OFFSET$pCode);
    }

    public VkShaderCreateInfoEXT pCode(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pCode, OFFSET$pCode, value);
        return this;
    }

    public VkShaderCreateInfoEXT pCode(@Nullable IPointer pointer) {
        pCode(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    /// Note: the returned {@link BytePtr} does not have correct
    /// {@link BytePtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link BytePtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable BytePtr pName() {
        MemorySegment s = pNameRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new BytePtr(s);
    }

    public VkShaderCreateInfoEXT pName(@Nullable BytePtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pNameRaw(s);
        return this;
    }

    public @Pointer(comment="int8_t*") @NotNull MemorySegment pNameRaw() {
        return segment.get(LAYOUT$pName, OFFSET$pName);
    }

    public void pNameRaw(@Pointer(comment="int8_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pName, OFFSET$pName, value);
    }

    public @Unsigned int setLayoutCount() {
        return segment.get(LAYOUT$setLayoutCount, OFFSET$setLayoutCount);
    }

    public VkShaderCreateInfoEXT setLayoutCount(@Unsigned int value) {
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

    public VkShaderCreateInfoEXT pSetLayouts(@Nullable VkDescriptorSetLayout.Ptr value) {
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

    public VkShaderCreateInfoEXT pushConstantRangeCount(@Unsigned int value) {
        segment.set(LAYOUT$pushConstantRangeCount, OFFSET$pushConstantRangeCount, value);
        return this;
    }

    public VkShaderCreateInfoEXT pPushConstantRanges(@Nullable IVkPushConstantRange value) {
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

    public VkShaderCreateInfoEXT pSpecializationInfo(@Nullable IVkSpecializationInfo value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pSpecializationInfoRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkSpecializationInfo.Ptr pSpecializationInfo(int assumedCount) {
        MemorySegment s = pSpecializationInfoRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkSpecializationInfo.BYTES);
        return new VkSpecializationInfo.Ptr(s);
    }

    public @Nullable VkSpecializationInfo pSpecializationInfo() {
        MemorySegment s = pSpecializationInfoRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkSpecializationInfo(s);
    }

    public @Pointer(target=VkSpecializationInfo.class) @NotNull MemorySegment pSpecializationInfoRaw() {
        return segment.get(LAYOUT$pSpecializationInfo, OFFSET$pSpecializationInfo);
    }

    public void pSpecializationInfoRaw(@Pointer(target=VkSpecializationInfo.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pSpecializationInfo, OFFSET$pSpecializationInfo, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("stage"),
        ValueLayout.JAVA_INT.withName("nextStage"),
        ValueLayout.JAVA_INT.withName("codeType"),
        NativeLayout.C_SIZE_T.withName("codeSize"),
        ValueLayout.ADDRESS.withName("pCode"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE).withName("pName"),
        ValueLayout.JAVA_INT.withName("setLayoutCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS).withName("pSetLayouts"),
        ValueLayout.JAVA_INT.withName("pushConstantRangeCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkPushConstantRange.LAYOUT).withName("pPushConstantRanges"),
        ValueLayout.ADDRESS.withTargetLayout(VkSpecializationInfo.LAYOUT).withName("pSpecializationInfo")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$stage = PathElement.groupElement("stage");
    public static final PathElement PATH$nextStage = PathElement.groupElement("nextStage");
    public static final PathElement PATH$codeType = PathElement.groupElement("codeType");
    public static final PathElement PATH$codeSize = PathElement.groupElement("codeSize");
    public static final PathElement PATH$pCode = PathElement.groupElement("pCode");
    public static final PathElement PATH$pName = PathElement.groupElement("pName");
    public static final PathElement PATH$setLayoutCount = PathElement.groupElement("setLayoutCount");
    public static final PathElement PATH$pSetLayouts = PathElement.groupElement("pSetLayouts");
    public static final PathElement PATH$pushConstantRangeCount = PathElement.groupElement("pushConstantRangeCount");
    public static final PathElement PATH$pPushConstantRanges = PathElement.groupElement("pPushConstantRanges");
    public static final PathElement PATH$pSpecializationInfo = PathElement.groupElement("pSpecializationInfo");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$stage = (OfInt) LAYOUT.select(PATH$stage);
    public static final OfInt LAYOUT$nextStage = (OfInt) LAYOUT.select(PATH$nextStage);
    public static final OfInt LAYOUT$codeType = (OfInt) LAYOUT.select(PATH$codeType);
    public static final AddressLayout LAYOUT$pCode = (AddressLayout) LAYOUT.select(PATH$pCode);
    public static final AddressLayout LAYOUT$pName = (AddressLayout) LAYOUT.select(PATH$pName);
    public static final OfInt LAYOUT$setLayoutCount = (OfInt) LAYOUT.select(PATH$setLayoutCount);
    public static final AddressLayout LAYOUT$pSetLayouts = (AddressLayout) LAYOUT.select(PATH$pSetLayouts);
    public static final OfInt LAYOUT$pushConstantRangeCount = (OfInt) LAYOUT.select(PATH$pushConstantRangeCount);
    public static final AddressLayout LAYOUT$pPushConstantRanges = (AddressLayout) LAYOUT.select(PATH$pPushConstantRanges);
    public static final AddressLayout LAYOUT$pSpecializationInfo = (AddressLayout) LAYOUT.select(PATH$pSpecializationInfo);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$stage = LAYOUT$stage.byteSize();
    public static final long SIZE$nextStage = LAYOUT$nextStage.byteSize();
    public static final long SIZE$codeType = LAYOUT$codeType.byteSize();
    public static final long SIZE$codeSize = NativeLayout.C_SIZE_T.byteSize();
    public static final long SIZE$pCode = LAYOUT$pCode.byteSize();
    public static final long SIZE$pName = LAYOUT$pName.byteSize();
    public static final long SIZE$setLayoutCount = LAYOUT$setLayoutCount.byteSize();
    public static final long SIZE$pSetLayouts = LAYOUT$pSetLayouts.byteSize();
    public static final long SIZE$pushConstantRangeCount = LAYOUT$pushConstantRangeCount.byteSize();
    public static final long SIZE$pPushConstantRanges = LAYOUT$pPushConstantRanges.byteSize();
    public static final long SIZE$pSpecializationInfo = LAYOUT$pSpecializationInfo.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$stage = LAYOUT.byteOffset(PATH$stage);
    public static final long OFFSET$nextStage = LAYOUT.byteOffset(PATH$nextStage);
    public static final long OFFSET$codeType = LAYOUT.byteOffset(PATH$codeType);
    public static final long OFFSET$codeSize = LAYOUT.byteOffset(PATH$codeSize);
    public static final long OFFSET$pCode = LAYOUT.byteOffset(PATH$pCode);
    public static final long OFFSET$pName = LAYOUT.byteOffset(PATH$pName);
    public static final long OFFSET$setLayoutCount = LAYOUT.byteOffset(PATH$setLayoutCount);
    public static final long OFFSET$pSetLayouts = LAYOUT.byteOffset(PATH$pSetLayouts);
    public static final long OFFSET$pushConstantRangeCount = LAYOUT.byteOffset(PATH$pushConstantRangeCount);
    public static final long OFFSET$pPushConstantRanges = LAYOUT.byteOffset(PATH$pPushConstantRanges);
    public static final long OFFSET$pSpecializationInfo = LAYOUT.byteOffset(PATH$pSpecializationInfo);
}
