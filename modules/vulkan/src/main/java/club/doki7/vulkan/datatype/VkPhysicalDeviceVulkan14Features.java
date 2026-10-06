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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceVulkan14Features.html"><code>VkPhysicalDeviceVulkan14Features</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceVulkan14Features {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 globalPriorityQuery; // @link substring="globalPriorityQuery" target="#globalPriorityQuery"
///     VkBool32 shaderSubgroupRotate; // @link substring="shaderSubgroupRotate" target="#shaderSubgroupRotate"
///     VkBool32 shaderSubgroupRotateClustered; // @link substring="shaderSubgroupRotateClustered" target="#shaderSubgroupRotateClustered"
///     VkBool32 shaderFloatControls2; // @link substring="shaderFloatControls2" target="#shaderFloatControls2"
///     VkBool32 shaderExpectAssume; // @link substring="shaderExpectAssume" target="#shaderExpectAssume"
///     VkBool32 rectangularLines; // @link substring="rectangularLines" target="#rectangularLines"
///     VkBool32 bresenhamLines; // @link substring="bresenhamLines" target="#bresenhamLines"
///     VkBool32 smoothLines; // @link substring="smoothLines" target="#smoothLines"
///     VkBool32 stippledRectangularLines; // @link substring="stippledRectangularLines" target="#stippledRectangularLines"
///     VkBool32 stippledBresenhamLines; // @link substring="stippledBresenhamLines" target="#stippledBresenhamLines"
///     VkBool32 stippledSmoothLines; // @link substring="stippledSmoothLines" target="#stippledSmoothLines"
///     VkBool32 vertexAttributeInstanceRateDivisor; // @link substring="vertexAttributeInstanceRateDivisor" target="#vertexAttributeInstanceRateDivisor"
///     VkBool32 vertexAttributeInstanceRateZeroDivisor; // @link substring="vertexAttributeInstanceRateZeroDivisor" target="#vertexAttributeInstanceRateZeroDivisor"
///     VkBool32 indexTypeUint8; // @link substring="indexTypeUint8" target="#indexTypeUint8"
///     VkBool32 dynamicRenderingLocalRead; // @link substring="dynamicRenderingLocalRead" target="#dynamicRenderingLocalRead"
///     VkBool32 maintenance5; // @link substring="maintenance5" target="#maintenance5"
///     VkBool32 maintenance6; // @link substring="maintenance6" target="#maintenance6"
///     VkBool32 pipelineProtectedAccess; // @link substring="pipelineProtectedAccess" target="#pipelineProtectedAccess"
///     VkBool32 pipelineRobustness; // @link substring="pipelineRobustness" target="#pipelineRobustness"
///     VkBool32 hostImageCopy; // @link substring="hostImageCopy" target="#hostImageCopy"
///     VkBool32 pushDescriptor; // @link substring="pushDescriptor" target="#pushDescriptor"
/// } VkPhysicalDeviceVulkan14Features;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_VULKAN_1_4_FEATURES`
///
/// The {@code allocate} ({@link VkPhysicalDeviceVulkan14Features#allocate(Arena)}, {@link VkPhysicalDeviceVulkan14Features#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceVulkan14Features#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceVulkan14Features.html"><code>VkPhysicalDeviceVulkan14Features</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceVulkan14Features(@NotNull MemorySegment segment) implements IVkPhysicalDeviceVulkan14Features {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceVulkan14Features.html"><code>VkPhysicalDeviceVulkan14Features</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceVulkan14Features}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceVulkan14Features to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceVulkan14Features.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceVulkan14Features, Iterable<VkPhysicalDeviceVulkan14Features> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceVulkan14Features.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceVulkan14Features at(long index) {
            return new VkPhysicalDeviceVulkan14Features(segment.asSlice(index * VkPhysicalDeviceVulkan14Features.BYTES, VkPhysicalDeviceVulkan14Features.BYTES));
        }

        public VkPhysicalDeviceVulkan14Features.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceVulkan14Features> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceVulkan14Features value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceVulkan14Features.BYTES, VkPhysicalDeviceVulkan14Features.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceVulkan14Features.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceVulkan14Features.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceVulkan14Features.BYTES,
                (end - start) * VkPhysicalDeviceVulkan14Features.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceVulkan14Features.BYTES));
        }

        public VkPhysicalDeviceVulkan14Features[] toArray() {
            VkPhysicalDeviceVulkan14Features[] ret = new VkPhysicalDeviceVulkan14Features[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceVulkan14Features> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceVulkan14Features> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceVulkan14Features.BYTES;
            }

            @Override
            public VkPhysicalDeviceVulkan14Features next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceVulkan14Features ret = new VkPhysicalDeviceVulkan14Features(segment.asSlice(0, VkPhysicalDeviceVulkan14Features.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceVulkan14Features.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceVulkan14Features allocate(Arena arena) {
        VkPhysicalDeviceVulkan14Features ret = new VkPhysicalDeviceVulkan14Features(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_VULKAN_1_4_FEATURES);
        return ret;
    }

    public static VkPhysicalDeviceVulkan14Features.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceVulkan14Features.Ptr ret = new VkPhysicalDeviceVulkan14Features.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_VULKAN_1_4_FEATURES);
        }
        return ret;
    }

    public static VkPhysicalDeviceVulkan14Features clone(Arena arena, VkPhysicalDeviceVulkan14Features src) {
        VkPhysicalDeviceVulkan14Features ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_VULKAN_1_4_FEATURES);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceVulkan14Features sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceVulkan14Features pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceVulkan14Features pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int globalPriorityQuery() {
        return segment.get(LAYOUT$globalPriorityQuery, OFFSET$globalPriorityQuery);
    }

    public VkPhysicalDeviceVulkan14Features globalPriorityQuery(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$globalPriorityQuery, OFFSET$globalPriorityQuery, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderSubgroupRotate() {
        return segment.get(LAYOUT$shaderSubgroupRotate, OFFSET$shaderSubgroupRotate);
    }

    public VkPhysicalDeviceVulkan14Features shaderSubgroupRotate(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderSubgroupRotate, OFFSET$shaderSubgroupRotate, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderSubgroupRotateClustered() {
        return segment.get(LAYOUT$shaderSubgroupRotateClustered, OFFSET$shaderSubgroupRotateClustered);
    }

    public VkPhysicalDeviceVulkan14Features shaderSubgroupRotateClustered(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderSubgroupRotateClustered, OFFSET$shaderSubgroupRotateClustered, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderFloatControls2() {
        return segment.get(LAYOUT$shaderFloatControls2, OFFSET$shaderFloatControls2);
    }

    public VkPhysicalDeviceVulkan14Features shaderFloatControls2(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderFloatControls2, OFFSET$shaderFloatControls2, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderExpectAssume() {
        return segment.get(LAYOUT$shaderExpectAssume, OFFSET$shaderExpectAssume);
    }

    public VkPhysicalDeviceVulkan14Features shaderExpectAssume(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderExpectAssume, OFFSET$shaderExpectAssume, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int rectangularLines() {
        return segment.get(LAYOUT$rectangularLines, OFFSET$rectangularLines);
    }

    public VkPhysicalDeviceVulkan14Features rectangularLines(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$rectangularLines, OFFSET$rectangularLines, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int bresenhamLines() {
        return segment.get(LAYOUT$bresenhamLines, OFFSET$bresenhamLines);
    }

    public VkPhysicalDeviceVulkan14Features bresenhamLines(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$bresenhamLines, OFFSET$bresenhamLines, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int smoothLines() {
        return segment.get(LAYOUT$smoothLines, OFFSET$smoothLines);
    }

    public VkPhysicalDeviceVulkan14Features smoothLines(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$smoothLines, OFFSET$smoothLines, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int stippledRectangularLines() {
        return segment.get(LAYOUT$stippledRectangularLines, OFFSET$stippledRectangularLines);
    }

    public VkPhysicalDeviceVulkan14Features stippledRectangularLines(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$stippledRectangularLines, OFFSET$stippledRectangularLines, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int stippledBresenhamLines() {
        return segment.get(LAYOUT$stippledBresenhamLines, OFFSET$stippledBresenhamLines);
    }

    public VkPhysicalDeviceVulkan14Features stippledBresenhamLines(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$stippledBresenhamLines, OFFSET$stippledBresenhamLines, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int stippledSmoothLines() {
        return segment.get(LAYOUT$stippledSmoothLines, OFFSET$stippledSmoothLines);
    }

    public VkPhysicalDeviceVulkan14Features stippledSmoothLines(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$stippledSmoothLines, OFFSET$stippledSmoothLines, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int vertexAttributeInstanceRateDivisor() {
        return segment.get(LAYOUT$vertexAttributeInstanceRateDivisor, OFFSET$vertexAttributeInstanceRateDivisor);
    }

    public VkPhysicalDeviceVulkan14Features vertexAttributeInstanceRateDivisor(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$vertexAttributeInstanceRateDivisor, OFFSET$vertexAttributeInstanceRateDivisor, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int vertexAttributeInstanceRateZeroDivisor() {
        return segment.get(LAYOUT$vertexAttributeInstanceRateZeroDivisor, OFFSET$vertexAttributeInstanceRateZeroDivisor);
    }

    public VkPhysicalDeviceVulkan14Features vertexAttributeInstanceRateZeroDivisor(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$vertexAttributeInstanceRateZeroDivisor, OFFSET$vertexAttributeInstanceRateZeroDivisor, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int indexTypeUint8() {
        return segment.get(LAYOUT$indexTypeUint8, OFFSET$indexTypeUint8);
    }

    public VkPhysicalDeviceVulkan14Features indexTypeUint8(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$indexTypeUint8, OFFSET$indexTypeUint8, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int dynamicRenderingLocalRead() {
        return segment.get(LAYOUT$dynamicRenderingLocalRead, OFFSET$dynamicRenderingLocalRead);
    }

    public VkPhysicalDeviceVulkan14Features dynamicRenderingLocalRead(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$dynamicRenderingLocalRead, OFFSET$dynamicRenderingLocalRead, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int maintenance5() {
        return segment.get(LAYOUT$maintenance5, OFFSET$maintenance5);
    }

    public VkPhysicalDeviceVulkan14Features maintenance5(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$maintenance5, OFFSET$maintenance5, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int maintenance6() {
        return segment.get(LAYOUT$maintenance6, OFFSET$maintenance6);
    }

    public VkPhysicalDeviceVulkan14Features maintenance6(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$maintenance6, OFFSET$maintenance6, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int pipelineProtectedAccess() {
        return segment.get(LAYOUT$pipelineProtectedAccess, OFFSET$pipelineProtectedAccess);
    }

    public VkPhysicalDeviceVulkan14Features pipelineProtectedAccess(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$pipelineProtectedAccess, OFFSET$pipelineProtectedAccess, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int pipelineRobustness() {
        return segment.get(LAYOUT$pipelineRobustness, OFFSET$pipelineRobustness);
    }

    public VkPhysicalDeviceVulkan14Features pipelineRobustness(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$pipelineRobustness, OFFSET$pipelineRobustness, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int hostImageCopy() {
        return segment.get(LAYOUT$hostImageCopy, OFFSET$hostImageCopy);
    }

    public VkPhysicalDeviceVulkan14Features hostImageCopy(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$hostImageCopy, OFFSET$hostImageCopy, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int pushDescriptor() {
        return segment.get(LAYOUT$pushDescriptor, OFFSET$pushDescriptor);
    }

    public VkPhysicalDeviceVulkan14Features pushDescriptor(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$pushDescriptor, OFFSET$pushDescriptor, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("globalPriorityQuery"),
        ValueLayout.JAVA_INT.withName("shaderSubgroupRotate"),
        ValueLayout.JAVA_INT.withName("shaderSubgroupRotateClustered"),
        ValueLayout.JAVA_INT.withName("shaderFloatControls2"),
        ValueLayout.JAVA_INT.withName("shaderExpectAssume"),
        ValueLayout.JAVA_INT.withName("rectangularLines"),
        ValueLayout.JAVA_INT.withName("bresenhamLines"),
        ValueLayout.JAVA_INT.withName("smoothLines"),
        ValueLayout.JAVA_INT.withName("stippledRectangularLines"),
        ValueLayout.JAVA_INT.withName("stippledBresenhamLines"),
        ValueLayout.JAVA_INT.withName("stippledSmoothLines"),
        ValueLayout.JAVA_INT.withName("vertexAttributeInstanceRateDivisor"),
        ValueLayout.JAVA_INT.withName("vertexAttributeInstanceRateZeroDivisor"),
        ValueLayout.JAVA_INT.withName("indexTypeUint8"),
        ValueLayout.JAVA_INT.withName("dynamicRenderingLocalRead"),
        ValueLayout.JAVA_INT.withName("maintenance5"),
        ValueLayout.JAVA_INT.withName("maintenance6"),
        ValueLayout.JAVA_INT.withName("pipelineProtectedAccess"),
        ValueLayout.JAVA_INT.withName("pipelineRobustness"),
        ValueLayout.JAVA_INT.withName("hostImageCopy"),
        ValueLayout.JAVA_INT.withName("pushDescriptor")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$globalPriorityQuery = PathElement.groupElement("globalPriorityQuery");
    public static final PathElement PATH$shaderSubgroupRotate = PathElement.groupElement("shaderSubgroupRotate");
    public static final PathElement PATH$shaderSubgroupRotateClustered = PathElement.groupElement("shaderSubgroupRotateClustered");
    public static final PathElement PATH$shaderFloatControls2 = PathElement.groupElement("shaderFloatControls2");
    public static final PathElement PATH$shaderExpectAssume = PathElement.groupElement("shaderExpectAssume");
    public static final PathElement PATH$rectangularLines = PathElement.groupElement("rectangularLines");
    public static final PathElement PATH$bresenhamLines = PathElement.groupElement("bresenhamLines");
    public static final PathElement PATH$smoothLines = PathElement.groupElement("smoothLines");
    public static final PathElement PATH$stippledRectangularLines = PathElement.groupElement("stippledRectangularLines");
    public static final PathElement PATH$stippledBresenhamLines = PathElement.groupElement("stippledBresenhamLines");
    public static final PathElement PATH$stippledSmoothLines = PathElement.groupElement("stippledSmoothLines");
    public static final PathElement PATH$vertexAttributeInstanceRateDivisor = PathElement.groupElement("vertexAttributeInstanceRateDivisor");
    public static final PathElement PATH$vertexAttributeInstanceRateZeroDivisor = PathElement.groupElement("vertexAttributeInstanceRateZeroDivisor");
    public static final PathElement PATH$indexTypeUint8 = PathElement.groupElement("indexTypeUint8");
    public static final PathElement PATH$dynamicRenderingLocalRead = PathElement.groupElement("dynamicRenderingLocalRead");
    public static final PathElement PATH$maintenance5 = PathElement.groupElement("maintenance5");
    public static final PathElement PATH$maintenance6 = PathElement.groupElement("maintenance6");
    public static final PathElement PATH$pipelineProtectedAccess = PathElement.groupElement("pipelineProtectedAccess");
    public static final PathElement PATH$pipelineRobustness = PathElement.groupElement("pipelineRobustness");
    public static final PathElement PATH$hostImageCopy = PathElement.groupElement("hostImageCopy");
    public static final PathElement PATH$pushDescriptor = PathElement.groupElement("pushDescriptor");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$globalPriorityQuery = (OfInt) LAYOUT.select(PATH$globalPriorityQuery);
    public static final OfInt LAYOUT$shaderSubgroupRotate = (OfInt) LAYOUT.select(PATH$shaderSubgroupRotate);
    public static final OfInt LAYOUT$shaderSubgroupRotateClustered = (OfInt) LAYOUT.select(PATH$shaderSubgroupRotateClustered);
    public static final OfInt LAYOUT$shaderFloatControls2 = (OfInt) LAYOUT.select(PATH$shaderFloatControls2);
    public static final OfInt LAYOUT$shaderExpectAssume = (OfInt) LAYOUT.select(PATH$shaderExpectAssume);
    public static final OfInt LAYOUT$rectangularLines = (OfInt) LAYOUT.select(PATH$rectangularLines);
    public static final OfInt LAYOUT$bresenhamLines = (OfInt) LAYOUT.select(PATH$bresenhamLines);
    public static final OfInt LAYOUT$smoothLines = (OfInt) LAYOUT.select(PATH$smoothLines);
    public static final OfInt LAYOUT$stippledRectangularLines = (OfInt) LAYOUT.select(PATH$stippledRectangularLines);
    public static final OfInt LAYOUT$stippledBresenhamLines = (OfInt) LAYOUT.select(PATH$stippledBresenhamLines);
    public static final OfInt LAYOUT$stippledSmoothLines = (OfInt) LAYOUT.select(PATH$stippledSmoothLines);
    public static final OfInt LAYOUT$vertexAttributeInstanceRateDivisor = (OfInt) LAYOUT.select(PATH$vertexAttributeInstanceRateDivisor);
    public static final OfInt LAYOUT$vertexAttributeInstanceRateZeroDivisor = (OfInt) LAYOUT.select(PATH$vertexAttributeInstanceRateZeroDivisor);
    public static final OfInt LAYOUT$indexTypeUint8 = (OfInt) LAYOUT.select(PATH$indexTypeUint8);
    public static final OfInt LAYOUT$dynamicRenderingLocalRead = (OfInt) LAYOUT.select(PATH$dynamicRenderingLocalRead);
    public static final OfInt LAYOUT$maintenance5 = (OfInt) LAYOUT.select(PATH$maintenance5);
    public static final OfInt LAYOUT$maintenance6 = (OfInt) LAYOUT.select(PATH$maintenance6);
    public static final OfInt LAYOUT$pipelineProtectedAccess = (OfInt) LAYOUT.select(PATH$pipelineProtectedAccess);
    public static final OfInt LAYOUT$pipelineRobustness = (OfInt) LAYOUT.select(PATH$pipelineRobustness);
    public static final OfInt LAYOUT$hostImageCopy = (OfInt) LAYOUT.select(PATH$hostImageCopy);
    public static final OfInt LAYOUT$pushDescriptor = (OfInt) LAYOUT.select(PATH$pushDescriptor);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$globalPriorityQuery = LAYOUT$globalPriorityQuery.byteSize();
    public static final long SIZE$shaderSubgroupRotate = LAYOUT$shaderSubgroupRotate.byteSize();
    public static final long SIZE$shaderSubgroupRotateClustered = LAYOUT$shaderSubgroupRotateClustered.byteSize();
    public static final long SIZE$shaderFloatControls2 = LAYOUT$shaderFloatControls2.byteSize();
    public static final long SIZE$shaderExpectAssume = LAYOUT$shaderExpectAssume.byteSize();
    public static final long SIZE$rectangularLines = LAYOUT$rectangularLines.byteSize();
    public static final long SIZE$bresenhamLines = LAYOUT$bresenhamLines.byteSize();
    public static final long SIZE$smoothLines = LAYOUT$smoothLines.byteSize();
    public static final long SIZE$stippledRectangularLines = LAYOUT$stippledRectangularLines.byteSize();
    public static final long SIZE$stippledBresenhamLines = LAYOUT$stippledBresenhamLines.byteSize();
    public static final long SIZE$stippledSmoothLines = LAYOUT$stippledSmoothLines.byteSize();
    public static final long SIZE$vertexAttributeInstanceRateDivisor = LAYOUT$vertexAttributeInstanceRateDivisor.byteSize();
    public static final long SIZE$vertexAttributeInstanceRateZeroDivisor = LAYOUT$vertexAttributeInstanceRateZeroDivisor.byteSize();
    public static final long SIZE$indexTypeUint8 = LAYOUT$indexTypeUint8.byteSize();
    public static final long SIZE$dynamicRenderingLocalRead = LAYOUT$dynamicRenderingLocalRead.byteSize();
    public static final long SIZE$maintenance5 = LAYOUT$maintenance5.byteSize();
    public static final long SIZE$maintenance6 = LAYOUT$maintenance6.byteSize();
    public static final long SIZE$pipelineProtectedAccess = LAYOUT$pipelineProtectedAccess.byteSize();
    public static final long SIZE$pipelineRobustness = LAYOUT$pipelineRobustness.byteSize();
    public static final long SIZE$hostImageCopy = LAYOUT$hostImageCopy.byteSize();
    public static final long SIZE$pushDescriptor = LAYOUT$pushDescriptor.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$globalPriorityQuery = LAYOUT.byteOffset(PATH$globalPriorityQuery);
    public static final long OFFSET$shaderSubgroupRotate = LAYOUT.byteOffset(PATH$shaderSubgroupRotate);
    public static final long OFFSET$shaderSubgroupRotateClustered = LAYOUT.byteOffset(PATH$shaderSubgroupRotateClustered);
    public static final long OFFSET$shaderFloatControls2 = LAYOUT.byteOffset(PATH$shaderFloatControls2);
    public static final long OFFSET$shaderExpectAssume = LAYOUT.byteOffset(PATH$shaderExpectAssume);
    public static final long OFFSET$rectangularLines = LAYOUT.byteOffset(PATH$rectangularLines);
    public static final long OFFSET$bresenhamLines = LAYOUT.byteOffset(PATH$bresenhamLines);
    public static final long OFFSET$smoothLines = LAYOUT.byteOffset(PATH$smoothLines);
    public static final long OFFSET$stippledRectangularLines = LAYOUT.byteOffset(PATH$stippledRectangularLines);
    public static final long OFFSET$stippledBresenhamLines = LAYOUT.byteOffset(PATH$stippledBresenhamLines);
    public static final long OFFSET$stippledSmoothLines = LAYOUT.byteOffset(PATH$stippledSmoothLines);
    public static final long OFFSET$vertexAttributeInstanceRateDivisor = LAYOUT.byteOffset(PATH$vertexAttributeInstanceRateDivisor);
    public static final long OFFSET$vertexAttributeInstanceRateZeroDivisor = LAYOUT.byteOffset(PATH$vertexAttributeInstanceRateZeroDivisor);
    public static final long OFFSET$indexTypeUint8 = LAYOUT.byteOffset(PATH$indexTypeUint8);
    public static final long OFFSET$dynamicRenderingLocalRead = LAYOUT.byteOffset(PATH$dynamicRenderingLocalRead);
    public static final long OFFSET$maintenance5 = LAYOUT.byteOffset(PATH$maintenance5);
    public static final long OFFSET$maintenance6 = LAYOUT.byteOffset(PATH$maintenance6);
    public static final long OFFSET$pipelineProtectedAccess = LAYOUT.byteOffset(PATH$pipelineProtectedAccess);
    public static final long OFFSET$pipelineRobustness = LAYOUT.byteOffset(PATH$pipelineRobustness);
    public static final long OFFSET$hostImageCopy = LAYOUT.byteOffset(PATH$hostImageCopy);
    public static final long OFFSET$pushDescriptor = LAYOUT.byteOffset(PATH$pushDescriptor);
}
