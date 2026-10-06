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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT.html"><code>VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t maxIndirectPipelineCount; // @link substring="maxIndirectPipelineCount" target="#maxIndirectPipelineCount"
///     uint32_t maxIndirectShaderObjectCount; // @link substring="maxIndirectShaderObjectCount" target="#maxIndirectShaderObjectCount"
///     uint32_t maxIndirectSequenceCount; // @link substring="maxIndirectSequenceCount" target="#maxIndirectSequenceCount"
///     uint32_t maxIndirectCommandsTokenCount; // @link substring="maxIndirectCommandsTokenCount" target="#maxIndirectCommandsTokenCount"
///     uint32_t maxIndirectCommandsTokenOffset; // @link substring="maxIndirectCommandsTokenOffset" target="#maxIndirectCommandsTokenOffset"
///     uint32_t maxIndirectCommandsIndirectStride; // @link substring="maxIndirectCommandsIndirectStride" target="#maxIndirectCommandsIndirectStride"
///     VkIndirectCommandsInputModeFlagsEXT supportedIndirectCommandsInputModes; // @link substring="VkIndirectCommandsInputModeFlagsEXT" target="VkIndirectCommandsInputModeFlagsEXT" @link substring="supportedIndirectCommandsInputModes" target="#supportedIndirectCommandsInputModes"
///     VkShaderStageFlags supportedIndirectCommandsShaderStages; // @link substring="VkShaderStageFlags" target="VkShaderStageFlags" @link substring="supportedIndirectCommandsShaderStages" target="#supportedIndirectCommandsShaderStages"
///     VkShaderStageFlags supportedIndirectCommandsShaderStagesPipelineBinding; // @link substring="VkShaderStageFlags" target="VkShaderStageFlags" @link substring="supportedIndirectCommandsShaderStagesPipelineBinding" target="#supportedIndirectCommandsShaderStagesPipelineBinding"
///     VkShaderStageFlags supportedIndirectCommandsShaderStagesShaderBinding; // @link substring="VkShaderStageFlags" target="VkShaderStageFlags" @link substring="supportedIndirectCommandsShaderStagesShaderBinding" target="#supportedIndirectCommandsShaderStagesShaderBinding"
///     VkBool32 deviceGeneratedCommandsTransformFeedback; // @link substring="deviceGeneratedCommandsTransformFeedback" target="#deviceGeneratedCommandsTransformFeedback"
///     VkBool32 deviceGeneratedCommandsMultiDrawIndirectCount; // @link substring="deviceGeneratedCommandsMultiDrawIndirectCount" target="#deviceGeneratedCommandsMultiDrawIndirectCount"
/// } VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_DEVICE_GENERATED_COMMANDS_PROPERTIES_EXT`
///
/// The {@code allocate} ({@link VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT#allocate(Arena)}, {@link VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT.html"><code>VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT(@NotNull MemorySegment segment) implements IVkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT.html"><code>VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT, Iterable<VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT at(long index) {
            return new VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT(segment.asSlice(index * VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT.BYTES, VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT.BYTES));
        }

        public VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT.BYTES, VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT.BYTES,
                (end - start) * VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT.BYTES));
        }

        public VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT[] toArray() {
            VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT[] ret = new VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT.BYTES;
            }

            @Override
            public VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT ret = new VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT(segment.asSlice(0, VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT allocate(Arena arena) {
        VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT ret = new VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_DEVICE_GENERATED_COMMANDS_PROPERTIES_EXT);
        return ret;
    }

    public static VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT.Ptr ret = new VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_DEVICE_GENERATED_COMMANDS_PROPERTIES_EXT);
        }
        return ret;
    }

    public static VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT clone(Arena arena, VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT src) {
        VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_DEVICE_GENERATED_COMMANDS_PROPERTIES_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int maxIndirectPipelineCount() {
        return segment.get(LAYOUT$maxIndirectPipelineCount, OFFSET$maxIndirectPipelineCount);
    }

    public VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT maxIndirectPipelineCount(@Unsigned int value) {
        segment.set(LAYOUT$maxIndirectPipelineCount, OFFSET$maxIndirectPipelineCount, value);
        return this;
    }

    public @Unsigned int maxIndirectShaderObjectCount() {
        return segment.get(LAYOUT$maxIndirectShaderObjectCount, OFFSET$maxIndirectShaderObjectCount);
    }

    public VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT maxIndirectShaderObjectCount(@Unsigned int value) {
        segment.set(LAYOUT$maxIndirectShaderObjectCount, OFFSET$maxIndirectShaderObjectCount, value);
        return this;
    }

    public @Unsigned int maxIndirectSequenceCount() {
        return segment.get(LAYOUT$maxIndirectSequenceCount, OFFSET$maxIndirectSequenceCount);
    }

    public VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT maxIndirectSequenceCount(@Unsigned int value) {
        segment.set(LAYOUT$maxIndirectSequenceCount, OFFSET$maxIndirectSequenceCount, value);
        return this;
    }

    public @Unsigned int maxIndirectCommandsTokenCount() {
        return segment.get(LAYOUT$maxIndirectCommandsTokenCount, OFFSET$maxIndirectCommandsTokenCount);
    }

    public VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT maxIndirectCommandsTokenCount(@Unsigned int value) {
        segment.set(LAYOUT$maxIndirectCommandsTokenCount, OFFSET$maxIndirectCommandsTokenCount, value);
        return this;
    }

    public @Unsigned int maxIndirectCommandsTokenOffset() {
        return segment.get(LAYOUT$maxIndirectCommandsTokenOffset, OFFSET$maxIndirectCommandsTokenOffset);
    }

    public VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT maxIndirectCommandsTokenOffset(@Unsigned int value) {
        segment.set(LAYOUT$maxIndirectCommandsTokenOffset, OFFSET$maxIndirectCommandsTokenOffset, value);
        return this;
    }

    public @Unsigned int maxIndirectCommandsIndirectStride() {
        return segment.get(LAYOUT$maxIndirectCommandsIndirectStride, OFFSET$maxIndirectCommandsIndirectStride);
    }

    public VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT maxIndirectCommandsIndirectStride(@Unsigned int value) {
        segment.set(LAYOUT$maxIndirectCommandsIndirectStride, OFFSET$maxIndirectCommandsIndirectStride, value);
        return this;
    }

    public @Bitmask(VkIndirectCommandsInputModeFlagsEXT.class) int supportedIndirectCommandsInputModes() {
        return segment.get(LAYOUT$supportedIndirectCommandsInputModes, OFFSET$supportedIndirectCommandsInputModes);
    }

    public VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT supportedIndirectCommandsInputModes(@Bitmask(VkIndirectCommandsInputModeFlagsEXT.class) int value) {
        segment.set(LAYOUT$supportedIndirectCommandsInputModes, OFFSET$supportedIndirectCommandsInputModes, value);
        return this;
    }

    public @Bitmask(VkShaderStageFlags.class) int supportedIndirectCommandsShaderStages() {
        return segment.get(LAYOUT$supportedIndirectCommandsShaderStages, OFFSET$supportedIndirectCommandsShaderStages);
    }

    public VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT supportedIndirectCommandsShaderStages(@Bitmask(VkShaderStageFlags.class) int value) {
        segment.set(LAYOUT$supportedIndirectCommandsShaderStages, OFFSET$supportedIndirectCommandsShaderStages, value);
        return this;
    }

    public @Bitmask(VkShaderStageFlags.class) int supportedIndirectCommandsShaderStagesPipelineBinding() {
        return segment.get(LAYOUT$supportedIndirectCommandsShaderStagesPipelineBinding, OFFSET$supportedIndirectCommandsShaderStagesPipelineBinding);
    }

    public VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT supportedIndirectCommandsShaderStagesPipelineBinding(@Bitmask(VkShaderStageFlags.class) int value) {
        segment.set(LAYOUT$supportedIndirectCommandsShaderStagesPipelineBinding, OFFSET$supportedIndirectCommandsShaderStagesPipelineBinding, value);
        return this;
    }

    public @Bitmask(VkShaderStageFlags.class) int supportedIndirectCommandsShaderStagesShaderBinding() {
        return segment.get(LAYOUT$supportedIndirectCommandsShaderStagesShaderBinding, OFFSET$supportedIndirectCommandsShaderStagesShaderBinding);
    }

    public VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT supportedIndirectCommandsShaderStagesShaderBinding(@Bitmask(VkShaderStageFlags.class) int value) {
        segment.set(LAYOUT$supportedIndirectCommandsShaderStagesShaderBinding, OFFSET$supportedIndirectCommandsShaderStagesShaderBinding, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int deviceGeneratedCommandsTransformFeedback() {
        return segment.get(LAYOUT$deviceGeneratedCommandsTransformFeedback, OFFSET$deviceGeneratedCommandsTransformFeedback);
    }

    public VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT deviceGeneratedCommandsTransformFeedback(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$deviceGeneratedCommandsTransformFeedback, OFFSET$deviceGeneratedCommandsTransformFeedback, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int deviceGeneratedCommandsMultiDrawIndirectCount() {
        return segment.get(LAYOUT$deviceGeneratedCommandsMultiDrawIndirectCount, OFFSET$deviceGeneratedCommandsMultiDrawIndirectCount);
    }

    public VkPhysicalDeviceDeviceGeneratedCommandsPropertiesEXT deviceGeneratedCommandsMultiDrawIndirectCount(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$deviceGeneratedCommandsMultiDrawIndirectCount, OFFSET$deviceGeneratedCommandsMultiDrawIndirectCount, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("maxIndirectPipelineCount"),
        ValueLayout.JAVA_INT.withName("maxIndirectShaderObjectCount"),
        ValueLayout.JAVA_INT.withName("maxIndirectSequenceCount"),
        ValueLayout.JAVA_INT.withName("maxIndirectCommandsTokenCount"),
        ValueLayout.JAVA_INT.withName("maxIndirectCommandsTokenOffset"),
        ValueLayout.JAVA_INT.withName("maxIndirectCommandsIndirectStride"),
        ValueLayout.JAVA_INT.withName("supportedIndirectCommandsInputModes"),
        ValueLayout.JAVA_INT.withName("supportedIndirectCommandsShaderStages"),
        ValueLayout.JAVA_INT.withName("supportedIndirectCommandsShaderStagesPipelineBinding"),
        ValueLayout.JAVA_INT.withName("supportedIndirectCommandsShaderStagesShaderBinding"),
        ValueLayout.JAVA_INT.withName("deviceGeneratedCommandsTransformFeedback"),
        ValueLayout.JAVA_INT.withName("deviceGeneratedCommandsMultiDrawIndirectCount")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$maxIndirectPipelineCount = PathElement.groupElement("maxIndirectPipelineCount");
    public static final PathElement PATH$maxIndirectShaderObjectCount = PathElement.groupElement("maxIndirectShaderObjectCount");
    public static final PathElement PATH$maxIndirectSequenceCount = PathElement.groupElement("maxIndirectSequenceCount");
    public static final PathElement PATH$maxIndirectCommandsTokenCount = PathElement.groupElement("maxIndirectCommandsTokenCount");
    public static final PathElement PATH$maxIndirectCommandsTokenOffset = PathElement.groupElement("maxIndirectCommandsTokenOffset");
    public static final PathElement PATH$maxIndirectCommandsIndirectStride = PathElement.groupElement("maxIndirectCommandsIndirectStride");
    public static final PathElement PATH$supportedIndirectCommandsInputModes = PathElement.groupElement("supportedIndirectCommandsInputModes");
    public static final PathElement PATH$supportedIndirectCommandsShaderStages = PathElement.groupElement("supportedIndirectCommandsShaderStages");
    public static final PathElement PATH$supportedIndirectCommandsShaderStagesPipelineBinding = PathElement.groupElement("supportedIndirectCommandsShaderStagesPipelineBinding");
    public static final PathElement PATH$supportedIndirectCommandsShaderStagesShaderBinding = PathElement.groupElement("supportedIndirectCommandsShaderStagesShaderBinding");
    public static final PathElement PATH$deviceGeneratedCommandsTransformFeedback = PathElement.groupElement("deviceGeneratedCommandsTransformFeedback");
    public static final PathElement PATH$deviceGeneratedCommandsMultiDrawIndirectCount = PathElement.groupElement("deviceGeneratedCommandsMultiDrawIndirectCount");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$maxIndirectPipelineCount = (OfInt) LAYOUT.select(PATH$maxIndirectPipelineCount);
    public static final OfInt LAYOUT$maxIndirectShaderObjectCount = (OfInt) LAYOUT.select(PATH$maxIndirectShaderObjectCount);
    public static final OfInt LAYOUT$maxIndirectSequenceCount = (OfInt) LAYOUT.select(PATH$maxIndirectSequenceCount);
    public static final OfInt LAYOUT$maxIndirectCommandsTokenCount = (OfInt) LAYOUT.select(PATH$maxIndirectCommandsTokenCount);
    public static final OfInt LAYOUT$maxIndirectCommandsTokenOffset = (OfInt) LAYOUT.select(PATH$maxIndirectCommandsTokenOffset);
    public static final OfInt LAYOUT$maxIndirectCommandsIndirectStride = (OfInt) LAYOUT.select(PATH$maxIndirectCommandsIndirectStride);
    public static final OfInt LAYOUT$supportedIndirectCommandsInputModes = (OfInt) LAYOUT.select(PATH$supportedIndirectCommandsInputModes);
    public static final OfInt LAYOUT$supportedIndirectCommandsShaderStages = (OfInt) LAYOUT.select(PATH$supportedIndirectCommandsShaderStages);
    public static final OfInt LAYOUT$supportedIndirectCommandsShaderStagesPipelineBinding = (OfInt) LAYOUT.select(PATH$supportedIndirectCommandsShaderStagesPipelineBinding);
    public static final OfInt LAYOUT$supportedIndirectCommandsShaderStagesShaderBinding = (OfInt) LAYOUT.select(PATH$supportedIndirectCommandsShaderStagesShaderBinding);
    public static final OfInt LAYOUT$deviceGeneratedCommandsTransformFeedback = (OfInt) LAYOUT.select(PATH$deviceGeneratedCommandsTransformFeedback);
    public static final OfInt LAYOUT$deviceGeneratedCommandsMultiDrawIndirectCount = (OfInt) LAYOUT.select(PATH$deviceGeneratedCommandsMultiDrawIndirectCount);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$maxIndirectPipelineCount = LAYOUT$maxIndirectPipelineCount.byteSize();
    public static final long SIZE$maxIndirectShaderObjectCount = LAYOUT$maxIndirectShaderObjectCount.byteSize();
    public static final long SIZE$maxIndirectSequenceCount = LAYOUT$maxIndirectSequenceCount.byteSize();
    public static final long SIZE$maxIndirectCommandsTokenCount = LAYOUT$maxIndirectCommandsTokenCount.byteSize();
    public static final long SIZE$maxIndirectCommandsTokenOffset = LAYOUT$maxIndirectCommandsTokenOffset.byteSize();
    public static final long SIZE$maxIndirectCommandsIndirectStride = LAYOUT$maxIndirectCommandsIndirectStride.byteSize();
    public static final long SIZE$supportedIndirectCommandsInputModes = LAYOUT$supportedIndirectCommandsInputModes.byteSize();
    public static final long SIZE$supportedIndirectCommandsShaderStages = LAYOUT$supportedIndirectCommandsShaderStages.byteSize();
    public static final long SIZE$supportedIndirectCommandsShaderStagesPipelineBinding = LAYOUT$supportedIndirectCommandsShaderStagesPipelineBinding.byteSize();
    public static final long SIZE$supportedIndirectCommandsShaderStagesShaderBinding = LAYOUT$supportedIndirectCommandsShaderStagesShaderBinding.byteSize();
    public static final long SIZE$deviceGeneratedCommandsTransformFeedback = LAYOUT$deviceGeneratedCommandsTransformFeedback.byteSize();
    public static final long SIZE$deviceGeneratedCommandsMultiDrawIndirectCount = LAYOUT$deviceGeneratedCommandsMultiDrawIndirectCount.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$maxIndirectPipelineCount = LAYOUT.byteOffset(PATH$maxIndirectPipelineCount);
    public static final long OFFSET$maxIndirectShaderObjectCount = LAYOUT.byteOffset(PATH$maxIndirectShaderObjectCount);
    public static final long OFFSET$maxIndirectSequenceCount = LAYOUT.byteOffset(PATH$maxIndirectSequenceCount);
    public static final long OFFSET$maxIndirectCommandsTokenCount = LAYOUT.byteOffset(PATH$maxIndirectCommandsTokenCount);
    public static final long OFFSET$maxIndirectCommandsTokenOffset = LAYOUT.byteOffset(PATH$maxIndirectCommandsTokenOffset);
    public static final long OFFSET$maxIndirectCommandsIndirectStride = LAYOUT.byteOffset(PATH$maxIndirectCommandsIndirectStride);
    public static final long OFFSET$supportedIndirectCommandsInputModes = LAYOUT.byteOffset(PATH$supportedIndirectCommandsInputModes);
    public static final long OFFSET$supportedIndirectCommandsShaderStages = LAYOUT.byteOffset(PATH$supportedIndirectCommandsShaderStages);
    public static final long OFFSET$supportedIndirectCommandsShaderStagesPipelineBinding = LAYOUT.byteOffset(PATH$supportedIndirectCommandsShaderStagesPipelineBinding);
    public static final long OFFSET$supportedIndirectCommandsShaderStagesShaderBinding = LAYOUT.byteOffset(PATH$supportedIndirectCommandsShaderStagesShaderBinding);
    public static final long OFFSET$deviceGeneratedCommandsTransformFeedback = LAYOUT.byteOffset(PATH$deviceGeneratedCommandsTransformFeedback);
    public static final long OFFSET$deviceGeneratedCommandsMultiDrawIndirectCount = LAYOUT.byteOffset(PATH$deviceGeneratedCommandsMultiDrawIndirectCount);
}
