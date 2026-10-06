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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDevicePortabilitySubsetFeaturesKHR.html"><code>VkPhysicalDevicePortabilitySubsetFeaturesKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDevicePortabilitySubsetFeaturesKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 constantAlphaColorBlendFactors; // @link substring="constantAlphaColorBlendFactors" target="#constantAlphaColorBlendFactors"
///     VkBool32 events; // @link substring="events" target="#events"
///     VkBool32 imageViewFormatReinterpretation; // @link substring="imageViewFormatReinterpretation" target="#imageViewFormatReinterpretation"
///     VkBool32 imageViewFormatSwizzle; // @link substring="imageViewFormatSwizzle" target="#imageViewFormatSwizzle"
///     VkBool32 imageView2DOn3DImage; // @link substring="imageView2DOn3DImage" target="#imageView2DOn3DImage"
///     VkBool32 multisampleArrayImage; // @link substring="multisampleArrayImage" target="#multisampleArrayImage"
///     VkBool32 mutableComparisonSamplers; // @link substring="mutableComparisonSamplers" target="#mutableComparisonSamplers"
///     VkBool32 pointPolygons; // @link substring="pointPolygons" target="#pointPolygons"
///     VkBool32 samplerMipLodBias; // @link substring="samplerMipLodBias" target="#samplerMipLodBias"
///     VkBool32 separateStencilMaskRef; // @link substring="separateStencilMaskRef" target="#separateStencilMaskRef"
///     VkBool32 shaderSampleRateInterpolationFunctions; // @link substring="shaderSampleRateInterpolationFunctions" target="#shaderSampleRateInterpolationFunctions"
///     VkBool32 tessellationIsolines; // @link substring="tessellationIsolines" target="#tessellationIsolines"
///     VkBool32 tessellationPointMode; // @link substring="tessellationPointMode" target="#tessellationPointMode"
///     VkBool32 triangleFans; // @link substring="triangleFans" target="#triangleFans"
///     VkBool32 vertexAttributeAccessBeyondStride; // @link substring="vertexAttributeAccessBeyondStride" target="#vertexAttributeAccessBeyondStride"
/// } VkPhysicalDevicePortabilitySubsetFeaturesKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_PORTABILITY_SUBSET_FEATURES_KHR`
///
/// The {@code allocate} ({@link VkPhysicalDevicePortabilitySubsetFeaturesKHR#allocate(Arena)}, {@link VkPhysicalDevicePortabilitySubsetFeaturesKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDevicePortabilitySubsetFeaturesKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDevicePortabilitySubsetFeaturesKHR.html"><code>VkPhysicalDevicePortabilitySubsetFeaturesKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDevicePortabilitySubsetFeaturesKHR(@NotNull MemorySegment segment) implements IVkPhysicalDevicePortabilitySubsetFeaturesKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDevicePortabilitySubsetFeaturesKHR.html"><code>VkPhysicalDevicePortabilitySubsetFeaturesKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDevicePortabilitySubsetFeaturesKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDevicePortabilitySubsetFeaturesKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDevicePortabilitySubsetFeaturesKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDevicePortabilitySubsetFeaturesKHR, Iterable<VkPhysicalDevicePortabilitySubsetFeaturesKHR> {
        public long size() {
            return segment.byteSize() / VkPhysicalDevicePortabilitySubsetFeaturesKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDevicePortabilitySubsetFeaturesKHR at(long index) {
            return new VkPhysicalDevicePortabilitySubsetFeaturesKHR(segment.asSlice(index * VkPhysicalDevicePortabilitySubsetFeaturesKHR.BYTES, VkPhysicalDevicePortabilitySubsetFeaturesKHR.BYTES));
        }

        public VkPhysicalDevicePortabilitySubsetFeaturesKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDevicePortabilitySubsetFeaturesKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDevicePortabilitySubsetFeaturesKHR value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDevicePortabilitySubsetFeaturesKHR.BYTES, VkPhysicalDevicePortabilitySubsetFeaturesKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDevicePortabilitySubsetFeaturesKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDevicePortabilitySubsetFeaturesKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDevicePortabilitySubsetFeaturesKHR.BYTES,
                (end - start) * VkPhysicalDevicePortabilitySubsetFeaturesKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDevicePortabilitySubsetFeaturesKHR.BYTES));
        }

        public VkPhysicalDevicePortabilitySubsetFeaturesKHR[] toArray() {
            VkPhysicalDevicePortabilitySubsetFeaturesKHR[] ret = new VkPhysicalDevicePortabilitySubsetFeaturesKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDevicePortabilitySubsetFeaturesKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDevicePortabilitySubsetFeaturesKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDevicePortabilitySubsetFeaturesKHR.BYTES;
            }

            @Override
            public VkPhysicalDevicePortabilitySubsetFeaturesKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDevicePortabilitySubsetFeaturesKHR ret = new VkPhysicalDevicePortabilitySubsetFeaturesKHR(segment.asSlice(0, VkPhysicalDevicePortabilitySubsetFeaturesKHR.BYTES));
                segment = segment.asSlice(VkPhysicalDevicePortabilitySubsetFeaturesKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDevicePortabilitySubsetFeaturesKHR allocate(Arena arena) {
        VkPhysicalDevicePortabilitySubsetFeaturesKHR ret = new VkPhysicalDevicePortabilitySubsetFeaturesKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_PORTABILITY_SUBSET_FEATURES_KHR);
        return ret;
    }

    public static VkPhysicalDevicePortabilitySubsetFeaturesKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDevicePortabilitySubsetFeaturesKHR.Ptr ret = new VkPhysicalDevicePortabilitySubsetFeaturesKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_PORTABILITY_SUBSET_FEATURES_KHR);
        }
        return ret;
    }

    public static VkPhysicalDevicePortabilitySubsetFeaturesKHR clone(Arena arena, VkPhysicalDevicePortabilitySubsetFeaturesKHR src) {
        VkPhysicalDevicePortabilitySubsetFeaturesKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_PORTABILITY_SUBSET_FEATURES_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDevicePortabilitySubsetFeaturesKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDevicePortabilitySubsetFeaturesKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDevicePortabilitySubsetFeaturesKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int constantAlphaColorBlendFactors() {
        return segment.get(LAYOUT$constantAlphaColorBlendFactors, OFFSET$constantAlphaColorBlendFactors);
    }

    public VkPhysicalDevicePortabilitySubsetFeaturesKHR constantAlphaColorBlendFactors(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$constantAlphaColorBlendFactors, OFFSET$constantAlphaColorBlendFactors, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int events() {
        return segment.get(LAYOUT$events, OFFSET$events);
    }

    public VkPhysicalDevicePortabilitySubsetFeaturesKHR events(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$events, OFFSET$events, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int imageViewFormatReinterpretation() {
        return segment.get(LAYOUT$imageViewFormatReinterpretation, OFFSET$imageViewFormatReinterpretation);
    }

    public VkPhysicalDevicePortabilitySubsetFeaturesKHR imageViewFormatReinterpretation(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$imageViewFormatReinterpretation, OFFSET$imageViewFormatReinterpretation, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int imageViewFormatSwizzle() {
        return segment.get(LAYOUT$imageViewFormatSwizzle, OFFSET$imageViewFormatSwizzle);
    }

    public VkPhysicalDevicePortabilitySubsetFeaturesKHR imageViewFormatSwizzle(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$imageViewFormatSwizzle, OFFSET$imageViewFormatSwizzle, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int imageView2DOn3DImage() {
        return segment.get(LAYOUT$imageView2DOn3DImage, OFFSET$imageView2DOn3DImage);
    }

    public VkPhysicalDevicePortabilitySubsetFeaturesKHR imageView2DOn3DImage(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$imageView2DOn3DImage, OFFSET$imageView2DOn3DImage, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int multisampleArrayImage() {
        return segment.get(LAYOUT$multisampleArrayImage, OFFSET$multisampleArrayImage);
    }

    public VkPhysicalDevicePortabilitySubsetFeaturesKHR multisampleArrayImage(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$multisampleArrayImage, OFFSET$multisampleArrayImage, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int mutableComparisonSamplers() {
        return segment.get(LAYOUT$mutableComparisonSamplers, OFFSET$mutableComparisonSamplers);
    }

    public VkPhysicalDevicePortabilitySubsetFeaturesKHR mutableComparisonSamplers(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$mutableComparisonSamplers, OFFSET$mutableComparisonSamplers, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int pointPolygons() {
        return segment.get(LAYOUT$pointPolygons, OFFSET$pointPolygons);
    }

    public VkPhysicalDevicePortabilitySubsetFeaturesKHR pointPolygons(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$pointPolygons, OFFSET$pointPolygons, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int samplerMipLodBias() {
        return segment.get(LAYOUT$samplerMipLodBias, OFFSET$samplerMipLodBias);
    }

    public VkPhysicalDevicePortabilitySubsetFeaturesKHR samplerMipLodBias(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$samplerMipLodBias, OFFSET$samplerMipLodBias, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int separateStencilMaskRef() {
        return segment.get(LAYOUT$separateStencilMaskRef, OFFSET$separateStencilMaskRef);
    }

    public VkPhysicalDevicePortabilitySubsetFeaturesKHR separateStencilMaskRef(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$separateStencilMaskRef, OFFSET$separateStencilMaskRef, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderSampleRateInterpolationFunctions() {
        return segment.get(LAYOUT$shaderSampleRateInterpolationFunctions, OFFSET$shaderSampleRateInterpolationFunctions);
    }

    public VkPhysicalDevicePortabilitySubsetFeaturesKHR shaderSampleRateInterpolationFunctions(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderSampleRateInterpolationFunctions, OFFSET$shaderSampleRateInterpolationFunctions, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int tessellationIsolines() {
        return segment.get(LAYOUT$tessellationIsolines, OFFSET$tessellationIsolines);
    }

    public VkPhysicalDevicePortabilitySubsetFeaturesKHR tessellationIsolines(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$tessellationIsolines, OFFSET$tessellationIsolines, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int tessellationPointMode() {
        return segment.get(LAYOUT$tessellationPointMode, OFFSET$tessellationPointMode);
    }

    public VkPhysicalDevicePortabilitySubsetFeaturesKHR tessellationPointMode(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$tessellationPointMode, OFFSET$tessellationPointMode, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int triangleFans() {
        return segment.get(LAYOUT$triangleFans, OFFSET$triangleFans);
    }

    public VkPhysicalDevicePortabilitySubsetFeaturesKHR triangleFans(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$triangleFans, OFFSET$triangleFans, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int vertexAttributeAccessBeyondStride() {
        return segment.get(LAYOUT$vertexAttributeAccessBeyondStride, OFFSET$vertexAttributeAccessBeyondStride);
    }

    public VkPhysicalDevicePortabilitySubsetFeaturesKHR vertexAttributeAccessBeyondStride(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$vertexAttributeAccessBeyondStride, OFFSET$vertexAttributeAccessBeyondStride, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("constantAlphaColorBlendFactors"),
        ValueLayout.JAVA_INT.withName("events"),
        ValueLayout.JAVA_INT.withName("imageViewFormatReinterpretation"),
        ValueLayout.JAVA_INT.withName("imageViewFormatSwizzle"),
        ValueLayout.JAVA_INT.withName("imageView2DOn3DImage"),
        ValueLayout.JAVA_INT.withName("multisampleArrayImage"),
        ValueLayout.JAVA_INT.withName("mutableComparisonSamplers"),
        ValueLayout.JAVA_INT.withName("pointPolygons"),
        ValueLayout.JAVA_INT.withName("samplerMipLodBias"),
        ValueLayout.JAVA_INT.withName("separateStencilMaskRef"),
        ValueLayout.JAVA_INT.withName("shaderSampleRateInterpolationFunctions"),
        ValueLayout.JAVA_INT.withName("tessellationIsolines"),
        ValueLayout.JAVA_INT.withName("tessellationPointMode"),
        ValueLayout.JAVA_INT.withName("triangleFans"),
        ValueLayout.JAVA_INT.withName("vertexAttributeAccessBeyondStride")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$constantAlphaColorBlendFactors = PathElement.groupElement("constantAlphaColorBlendFactors");
    public static final PathElement PATH$events = PathElement.groupElement("events");
    public static final PathElement PATH$imageViewFormatReinterpretation = PathElement.groupElement("imageViewFormatReinterpretation");
    public static final PathElement PATH$imageViewFormatSwizzle = PathElement.groupElement("imageViewFormatSwizzle");
    public static final PathElement PATH$imageView2DOn3DImage = PathElement.groupElement("imageView2DOn3DImage");
    public static final PathElement PATH$multisampleArrayImage = PathElement.groupElement("multisampleArrayImage");
    public static final PathElement PATH$mutableComparisonSamplers = PathElement.groupElement("mutableComparisonSamplers");
    public static final PathElement PATH$pointPolygons = PathElement.groupElement("pointPolygons");
    public static final PathElement PATH$samplerMipLodBias = PathElement.groupElement("samplerMipLodBias");
    public static final PathElement PATH$separateStencilMaskRef = PathElement.groupElement("separateStencilMaskRef");
    public static final PathElement PATH$shaderSampleRateInterpolationFunctions = PathElement.groupElement("shaderSampleRateInterpolationFunctions");
    public static final PathElement PATH$tessellationIsolines = PathElement.groupElement("tessellationIsolines");
    public static final PathElement PATH$tessellationPointMode = PathElement.groupElement("tessellationPointMode");
    public static final PathElement PATH$triangleFans = PathElement.groupElement("triangleFans");
    public static final PathElement PATH$vertexAttributeAccessBeyondStride = PathElement.groupElement("vertexAttributeAccessBeyondStride");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$constantAlphaColorBlendFactors = (OfInt) LAYOUT.select(PATH$constantAlphaColorBlendFactors);
    public static final OfInt LAYOUT$events = (OfInt) LAYOUT.select(PATH$events);
    public static final OfInt LAYOUT$imageViewFormatReinterpretation = (OfInt) LAYOUT.select(PATH$imageViewFormatReinterpretation);
    public static final OfInt LAYOUT$imageViewFormatSwizzle = (OfInt) LAYOUT.select(PATH$imageViewFormatSwizzle);
    public static final OfInt LAYOUT$imageView2DOn3DImage = (OfInt) LAYOUT.select(PATH$imageView2DOn3DImage);
    public static final OfInt LAYOUT$multisampleArrayImage = (OfInt) LAYOUT.select(PATH$multisampleArrayImage);
    public static final OfInt LAYOUT$mutableComparisonSamplers = (OfInt) LAYOUT.select(PATH$mutableComparisonSamplers);
    public static final OfInt LAYOUT$pointPolygons = (OfInt) LAYOUT.select(PATH$pointPolygons);
    public static final OfInt LAYOUT$samplerMipLodBias = (OfInt) LAYOUT.select(PATH$samplerMipLodBias);
    public static final OfInt LAYOUT$separateStencilMaskRef = (OfInt) LAYOUT.select(PATH$separateStencilMaskRef);
    public static final OfInt LAYOUT$shaderSampleRateInterpolationFunctions = (OfInt) LAYOUT.select(PATH$shaderSampleRateInterpolationFunctions);
    public static final OfInt LAYOUT$tessellationIsolines = (OfInt) LAYOUT.select(PATH$tessellationIsolines);
    public static final OfInt LAYOUT$tessellationPointMode = (OfInt) LAYOUT.select(PATH$tessellationPointMode);
    public static final OfInt LAYOUT$triangleFans = (OfInt) LAYOUT.select(PATH$triangleFans);
    public static final OfInt LAYOUT$vertexAttributeAccessBeyondStride = (OfInt) LAYOUT.select(PATH$vertexAttributeAccessBeyondStride);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$constantAlphaColorBlendFactors = LAYOUT$constantAlphaColorBlendFactors.byteSize();
    public static final long SIZE$events = LAYOUT$events.byteSize();
    public static final long SIZE$imageViewFormatReinterpretation = LAYOUT$imageViewFormatReinterpretation.byteSize();
    public static final long SIZE$imageViewFormatSwizzle = LAYOUT$imageViewFormatSwizzle.byteSize();
    public static final long SIZE$imageView2DOn3DImage = LAYOUT$imageView2DOn3DImage.byteSize();
    public static final long SIZE$multisampleArrayImage = LAYOUT$multisampleArrayImage.byteSize();
    public static final long SIZE$mutableComparisonSamplers = LAYOUT$mutableComparisonSamplers.byteSize();
    public static final long SIZE$pointPolygons = LAYOUT$pointPolygons.byteSize();
    public static final long SIZE$samplerMipLodBias = LAYOUT$samplerMipLodBias.byteSize();
    public static final long SIZE$separateStencilMaskRef = LAYOUT$separateStencilMaskRef.byteSize();
    public static final long SIZE$shaderSampleRateInterpolationFunctions = LAYOUT$shaderSampleRateInterpolationFunctions.byteSize();
    public static final long SIZE$tessellationIsolines = LAYOUT$tessellationIsolines.byteSize();
    public static final long SIZE$tessellationPointMode = LAYOUT$tessellationPointMode.byteSize();
    public static final long SIZE$triangleFans = LAYOUT$triangleFans.byteSize();
    public static final long SIZE$vertexAttributeAccessBeyondStride = LAYOUT$vertexAttributeAccessBeyondStride.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$constantAlphaColorBlendFactors = LAYOUT.byteOffset(PATH$constantAlphaColorBlendFactors);
    public static final long OFFSET$events = LAYOUT.byteOffset(PATH$events);
    public static final long OFFSET$imageViewFormatReinterpretation = LAYOUT.byteOffset(PATH$imageViewFormatReinterpretation);
    public static final long OFFSET$imageViewFormatSwizzle = LAYOUT.byteOffset(PATH$imageViewFormatSwizzle);
    public static final long OFFSET$imageView2DOn3DImage = LAYOUT.byteOffset(PATH$imageView2DOn3DImage);
    public static final long OFFSET$multisampleArrayImage = LAYOUT.byteOffset(PATH$multisampleArrayImage);
    public static final long OFFSET$mutableComparisonSamplers = LAYOUT.byteOffset(PATH$mutableComparisonSamplers);
    public static final long OFFSET$pointPolygons = LAYOUT.byteOffset(PATH$pointPolygons);
    public static final long OFFSET$samplerMipLodBias = LAYOUT.byteOffset(PATH$samplerMipLodBias);
    public static final long OFFSET$separateStencilMaskRef = LAYOUT.byteOffset(PATH$separateStencilMaskRef);
    public static final long OFFSET$shaderSampleRateInterpolationFunctions = LAYOUT.byteOffset(PATH$shaderSampleRateInterpolationFunctions);
    public static final long OFFSET$tessellationIsolines = LAYOUT.byteOffset(PATH$tessellationIsolines);
    public static final long OFFSET$tessellationPointMode = LAYOUT.byteOffset(PATH$tessellationPointMode);
    public static final long OFFSET$triangleFans = LAYOUT.byteOffset(PATH$triangleFans);
    public static final long OFFSET$vertexAttributeAccessBeyondStride = LAYOUT.byteOffset(PATH$vertexAttributeAccessBeyondStride);
}
