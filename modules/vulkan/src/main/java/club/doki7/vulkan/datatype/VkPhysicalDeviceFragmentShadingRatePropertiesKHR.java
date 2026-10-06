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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceFragmentShadingRatePropertiesKHR.html"><code>VkPhysicalDeviceFragmentShadingRatePropertiesKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceFragmentShadingRatePropertiesKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkExtent2D minFragmentShadingRateAttachmentTexelSize; // @link substring="VkExtent2D" target="VkExtent2D" @link substring="minFragmentShadingRateAttachmentTexelSize" target="#minFragmentShadingRateAttachmentTexelSize"
///     VkExtent2D maxFragmentShadingRateAttachmentTexelSize; // @link substring="VkExtent2D" target="VkExtent2D" @link substring="maxFragmentShadingRateAttachmentTexelSize" target="#maxFragmentShadingRateAttachmentTexelSize"
///     uint32_t maxFragmentShadingRateAttachmentTexelSizeAspectRatio; // @link substring="maxFragmentShadingRateAttachmentTexelSizeAspectRatio" target="#maxFragmentShadingRateAttachmentTexelSizeAspectRatio"
///     VkBool32 primitiveFragmentShadingRateWithMultipleViewports; // @link substring="primitiveFragmentShadingRateWithMultipleViewports" target="#primitiveFragmentShadingRateWithMultipleViewports"
///     VkBool32 layeredShadingRateAttachments; // @link substring="layeredShadingRateAttachments" target="#layeredShadingRateAttachments"
///     VkBool32 fragmentShadingRateNonTrivialCombinerOps; // @link substring="fragmentShadingRateNonTrivialCombinerOps" target="#fragmentShadingRateNonTrivialCombinerOps"
///     VkExtent2D maxFragmentSize; // @link substring="VkExtent2D" target="VkExtent2D" @link substring="maxFragmentSize" target="#maxFragmentSize"
///     uint32_t maxFragmentSizeAspectRatio; // @link substring="maxFragmentSizeAspectRatio" target="#maxFragmentSizeAspectRatio"
///     uint32_t maxFragmentShadingRateCoverageSamples; // @link substring="maxFragmentShadingRateCoverageSamples" target="#maxFragmentShadingRateCoverageSamples"
///     VkSampleCountFlags maxFragmentShadingRateRasterizationSamples; // @link substring="VkSampleCountFlags" target="VkSampleCountFlags" @link substring="maxFragmentShadingRateRasterizationSamples" target="#maxFragmentShadingRateRasterizationSamples"
///     VkBool32 fragmentShadingRateWithShaderDepthStencilWrites; // @link substring="fragmentShadingRateWithShaderDepthStencilWrites" target="#fragmentShadingRateWithShaderDepthStencilWrites"
///     VkBool32 fragmentShadingRateWithSampleMask; // @link substring="fragmentShadingRateWithSampleMask" target="#fragmentShadingRateWithSampleMask"
///     VkBool32 fragmentShadingRateWithShaderSampleMask; // @link substring="fragmentShadingRateWithShaderSampleMask" target="#fragmentShadingRateWithShaderSampleMask"
///     VkBool32 fragmentShadingRateWithConservativeRasterization; // @link substring="fragmentShadingRateWithConservativeRasterization" target="#fragmentShadingRateWithConservativeRasterization"
///     VkBool32 fragmentShadingRateWithFragmentShaderInterlock; // @link substring="fragmentShadingRateWithFragmentShaderInterlock" target="#fragmentShadingRateWithFragmentShaderInterlock"
///     VkBool32 fragmentShadingRateWithCustomSampleLocations; // @link substring="fragmentShadingRateWithCustomSampleLocations" target="#fragmentShadingRateWithCustomSampleLocations"
///     VkBool32 fragmentShadingRateStrictMultiplyCombiner; // @link substring="fragmentShadingRateStrictMultiplyCombiner" target="#fragmentShadingRateStrictMultiplyCombiner"
/// } VkPhysicalDeviceFragmentShadingRatePropertiesKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_FRAGMENT_SHADING_RATE_PROPERTIES_KHR`
///
/// The {@code allocate} ({@link VkPhysicalDeviceFragmentShadingRatePropertiesKHR#allocate(Arena)}, {@link VkPhysicalDeviceFragmentShadingRatePropertiesKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceFragmentShadingRatePropertiesKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceFragmentShadingRatePropertiesKHR.html"><code>VkPhysicalDeviceFragmentShadingRatePropertiesKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceFragmentShadingRatePropertiesKHR(@NotNull MemorySegment segment) implements IVkPhysicalDeviceFragmentShadingRatePropertiesKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceFragmentShadingRatePropertiesKHR.html"><code>VkPhysicalDeviceFragmentShadingRatePropertiesKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceFragmentShadingRatePropertiesKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceFragmentShadingRatePropertiesKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceFragmentShadingRatePropertiesKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceFragmentShadingRatePropertiesKHR, Iterable<VkPhysicalDeviceFragmentShadingRatePropertiesKHR> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceFragmentShadingRatePropertiesKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceFragmentShadingRatePropertiesKHR at(long index) {
            return new VkPhysicalDeviceFragmentShadingRatePropertiesKHR(segment.asSlice(index * VkPhysicalDeviceFragmentShadingRatePropertiesKHR.BYTES, VkPhysicalDeviceFragmentShadingRatePropertiesKHR.BYTES));
        }

        public VkPhysicalDeviceFragmentShadingRatePropertiesKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceFragmentShadingRatePropertiesKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceFragmentShadingRatePropertiesKHR value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceFragmentShadingRatePropertiesKHR.BYTES, VkPhysicalDeviceFragmentShadingRatePropertiesKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceFragmentShadingRatePropertiesKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceFragmentShadingRatePropertiesKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceFragmentShadingRatePropertiesKHR.BYTES,
                (end - start) * VkPhysicalDeviceFragmentShadingRatePropertiesKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceFragmentShadingRatePropertiesKHR.BYTES));
        }

        public VkPhysicalDeviceFragmentShadingRatePropertiesKHR[] toArray() {
            VkPhysicalDeviceFragmentShadingRatePropertiesKHR[] ret = new VkPhysicalDeviceFragmentShadingRatePropertiesKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceFragmentShadingRatePropertiesKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceFragmentShadingRatePropertiesKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceFragmentShadingRatePropertiesKHR.BYTES;
            }

            @Override
            public VkPhysicalDeviceFragmentShadingRatePropertiesKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceFragmentShadingRatePropertiesKHR ret = new VkPhysicalDeviceFragmentShadingRatePropertiesKHR(segment.asSlice(0, VkPhysicalDeviceFragmentShadingRatePropertiesKHR.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceFragmentShadingRatePropertiesKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceFragmentShadingRatePropertiesKHR allocate(Arena arena) {
        VkPhysicalDeviceFragmentShadingRatePropertiesKHR ret = new VkPhysicalDeviceFragmentShadingRatePropertiesKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_FRAGMENT_SHADING_RATE_PROPERTIES_KHR);
        return ret;
    }

    public static VkPhysicalDeviceFragmentShadingRatePropertiesKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceFragmentShadingRatePropertiesKHR.Ptr ret = new VkPhysicalDeviceFragmentShadingRatePropertiesKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_FRAGMENT_SHADING_RATE_PROPERTIES_KHR);
        }
        return ret;
    }

    public static VkPhysicalDeviceFragmentShadingRatePropertiesKHR clone(Arena arena, VkPhysicalDeviceFragmentShadingRatePropertiesKHR src) {
        VkPhysicalDeviceFragmentShadingRatePropertiesKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_FRAGMENT_SHADING_RATE_PROPERTIES_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceFragmentShadingRatePropertiesKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceFragmentShadingRatePropertiesKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceFragmentShadingRatePropertiesKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NotNull VkExtent2D minFragmentShadingRateAttachmentTexelSize() {
        return new VkExtent2D(segment.asSlice(OFFSET$minFragmentShadingRateAttachmentTexelSize, LAYOUT$minFragmentShadingRateAttachmentTexelSize));
    }

    public VkPhysicalDeviceFragmentShadingRatePropertiesKHR minFragmentShadingRateAttachmentTexelSize(@NotNull VkExtent2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$minFragmentShadingRateAttachmentTexelSize, SIZE$minFragmentShadingRateAttachmentTexelSize);
        return this;
    }

    public VkPhysicalDeviceFragmentShadingRatePropertiesKHR minFragmentShadingRateAttachmentTexelSize(Consumer<@NotNull VkExtent2D> consumer) {
        consumer.accept(minFragmentShadingRateAttachmentTexelSize());
        return this;
    }

    public @NotNull VkExtent2D maxFragmentShadingRateAttachmentTexelSize() {
        return new VkExtent2D(segment.asSlice(OFFSET$maxFragmentShadingRateAttachmentTexelSize, LAYOUT$maxFragmentShadingRateAttachmentTexelSize));
    }

    public VkPhysicalDeviceFragmentShadingRatePropertiesKHR maxFragmentShadingRateAttachmentTexelSize(@NotNull VkExtent2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$maxFragmentShadingRateAttachmentTexelSize, SIZE$maxFragmentShadingRateAttachmentTexelSize);
        return this;
    }

    public VkPhysicalDeviceFragmentShadingRatePropertiesKHR maxFragmentShadingRateAttachmentTexelSize(Consumer<@NotNull VkExtent2D> consumer) {
        consumer.accept(maxFragmentShadingRateAttachmentTexelSize());
        return this;
    }

    public @Unsigned int maxFragmentShadingRateAttachmentTexelSizeAspectRatio() {
        return segment.get(LAYOUT$maxFragmentShadingRateAttachmentTexelSizeAspectRatio, OFFSET$maxFragmentShadingRateAttachmentTexelSizeAspectRatio);
    }

    public VkPhysicalDeviceFragmentShadingRatePropertiesKHR maxFragmentShadingRateAttachmentTexelSizeAspectRatio(@Unsigned int value) {
        segment.set(LAYOUT$maxFragmentShadingRateAttachmentTexelSizeAspectRatio, OFFSET$maxFragmentShadingRateAttachmentTexelSizeAspectRatio, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int primitiveFragmentShadingRateWithMultipleViewports() {
        return segment.get(LAYOUT$primitiveFragmentShadingRateWithMultipleViewports, OFFSET$primitiveFragmentShadingRateWithMultipleViewports);
    }

    public VkPhysicalDeviceFragmentShadingRatePropertiesKHR primitiveFragmentShadingRateWithMultipleViewports(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$primitiveFragmentShadingRateWithMultipleViewports, OFFSET$primitiveFragmentShadingRateWithMultipleViewports, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int layeredShadingRateAttachments() {
        return segment.get(LAYOUT$layeredShadingRateAttachments, OFFSET$layeredShadingRateAttachments);
    }

    public VkPhysicalDeviceFragmentShadingRatePropertiesKHR layeredShadingRateAttachments(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$layeredShadingRateAttachments, OFFSET$layeredShadingRateAttachments, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int fragmentShadingRateNonTrivialCombinerOps() {
        return segment.get(LAYOUT$fragmentShadingRateNonTrivialCombinerOps, OFFSET$fragmentShadingRateNonTrivialCombinerOps);
    }

    public VkPhysicalDeviceFragmentShadingRatePropertiesKHR fragmentShadingRateNonTrivialCombinerOps(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$fragmentShadingRateNonTrivialCombinerOps, OFFSET$fragmentShadingRateNonTrivialCombinerOps, value);
        return this;
    }

    public @NotNull VkExtent2D maxFragmentSize() {
        return new VkExtent2D(segment.asSlice(OFFSET$maxFragmentSize, LAYOUT$maxFragmentSize));
    }

    public VkPhysicalDeviceFragmentShadingRatePropertiesKHR maxFragmentSize(@NotNull VkExtent2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$maxFragmentSize, SIZE$maxFragmentSize);
        return this;
    }

    public VkPhysicalDeviceFragmentShadingRatePropertiesKHR maxFragmentSize(Consumer<@NotNull VkExtent2D> consumer) {
        consumer.accept(maxFragmentSize());
        return this;
    }

    public @Unsigned int maxFragmentSizeAspectRatio() {
        return segment.get(LAYOUT$maxFragmentSizeAspectRatio, OFFSET$maxFragmentSizeAspectRatio);
    }

    public VkPhysicalDeviceFragmentShadingRatePropertiesKHR maxFragmentSizeAspectRatio(@Unsigned int value) {
        segment.set(LAYOUT$maxFragmentSizeAspectRatio, OFFSET$maxFragmentSizeAspectRatio, value);
        return this;
    }

    public @Unsigned int maxFragmentShadingRateCoverageSamples() {
        return segment.get(LAYOUT$maxFragmentShadingRateCoverageSamples, OFFSET$maxFragmentShadingRateCoverageSamples);
    }

    public VkPhysicalDeviceFragmentShadingRatePropertiesKHR maxFragmentShadingRateCoverageSamples(@Unsigned int value) {
        segment.set(LAYOUT$maxFragmentShadingRateCoverageSamples, OFFSET$maxFragmentShadingRateCoverageSamples, value);
        return this;
    }

    public @Bitmask(VkSampleCountFlags.class) int maxFragmentShadingRateRasterizationSamples() {
        return segment.get(LAYOUT$maxFragmentShadingRateRasterizationSamples, OFFSET$maxFragmentShadingRateRasterizationSamples);
    }

    public VkPhysicalDeviceFragmentShadingRatePropertiesKHR maxFragmentShadingRateRasterizationSamples(@Bitmask(VkSampleCountFlags.class) int value) {
        segment.set(LAYOUT$maxFragmentShadingRateRasterizationSamples, OFFSET$maxFragmentShadingRateRasterizationSamples, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int fragmentShadingRateWithShaderDepthStencilWrites() {
        return segment.get(LAYOUT$fragmentShadingRateWithShaderDepthStencilWrites, OFFSET$fragmentShadingRateWithShaderDepthStencilWrites);
    }

    public VkPhysicalDeviceFragmentShadingRatePropertiesKHR fragmentShadingRateWithShaderDepthStencilWrites(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$fragmentShadingRateWithShaderDepthStencilWrites, OFFSET$fragmentShadingRateWithShaderDepthStencilWrites, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int fragmentShadingRateWithSampleMask() {
        return segment.get(LAYOUT$fragmentShadingRateWithSampleMask, OFFSET$fragmentShadingRateWithSampleMask);
    }

    public VkPhysicalDeviceFragmentShadingRatePropertiesKHR fragmentShadingRateWithSampleMask(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$fragmentShadingRateWithSampleMask, OFFSET$fragmentShadingRateWithSampleMask, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int fragmentShadingRateWithShaderSampleMask() {
        return segment.get(LAYOUT$fragmentShadingRateWithShaderSampleMask, OFFSET$fragmentShadingRateWithShaderSampleMask);
    }

    public VkPhysicalDeviceFragmentShadingRatePropertiesKHR fragmentShadingRateWithShaderSampleMask(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$fragmentShadingRateWithShaderSampleMask, OFFSET$fragmentShadingRateWithShaderSampleMask, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int fragmentShadingRateWithConservativeRasterization() {
        return segment.get(LAYOUT$fragmentShadingRateWithConservativeRasterization, OFFSET$fragmentShadingRateWithConservativeRasterization);
    }

    public VkPhysicalDeviceFragmentShadingRatePropertiesKHR fragmentShadingRateWithConservativeRasterization(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$fragmentShadingRateWithConservativeRasterization, OFFSET$fragmentShadingRateWithConservativeRasterization, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int fragmentShadingRateWithFragmentShaderInterlock() {
        return segment.get(LAYOUT$fragmentShadingRateWithFragmentShaderInterlock, OFFSET$fragmentShadingRateWithFragmentShaderInterlock);
    }

    public VkPhysicalDeviceFragmentShadingRatePropertiesKHR fragmentShadingRateWithFragmentShaderInterlock(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$fragmentShadingRateWithFragmentShaderInterlock, OFFSET$fragmentShadingRateWithFragmentShaderInterlock, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int fragmentShadingRateWithCustomSampleLocations() {
        return segment.get(LAYOUT$fragmentShadingRateWithCustomSampleLocations, OFFSET$fragmentShadingRateWithCustomSampleLocations);
    }

    public VkPhysicalDeviceFragmentShadingRatePropertiesKHR fragmentShadingRateWithCustomSampleLocations(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$fragmentShadingRateWithCustomSampleLocations, OFFSET$fragmentShadingRateWithCustomSampleLocations, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int fragmentShadingRateStrictMultiplyCombiner() {
        return segment.get(LAYOUT$fragmentShadingRateStrictMultiplyCombiner, OFFSET$fragmentShadingRateStrictMultiplyCombiner);
    }

    public VkPhysicalDeviceFragmentShadingRatePropertiesKHR fragmentShadingRateStrictMultiplyCombiner(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$fragmentShadingRateStrictMultiplyCombiner, OFFSET$fragmentShadingRateStrictMultiplyCombiner, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        VkExtent2D.LAYOUT.withName("minFragmentShadingRateAttachmentTexelSize"),
        VkExtent2D.LAYOUT.withName("maxFragmentShadingRateAttachmentTexelSize"),
        ValueLayout.JAVA_INT.withName("maxFragmentShadingRateAttachmentTexelSizeAspectRatio"),
        ValueLayout.JAVA_INT.withName("primitiveFragmentShadingRateWithMultipleViewports"),
        ValueLayout.JAVA_INT.withName("layeredShadingRateAttachments"),
        ValueLayout.JAVA_INT.withName("fragmentShadingRateNonTrivialCombinerOps"),
        VkExtent2D.LAYOUT.withName("maxFragmentSize"),
        ValueLayout.JAVA_INT.withName("maxFragmentSizeAspectRatio"),
        ValueLayout.JAVA_INT.withName("maxFragmentShadingRateCoverageSamples"),
        ValueLayout.JAVA_INT.withName("maxFragmentShadingRateRasterizationSamples"),
        ValueLayout.JAVA_INT.withName("fragmentShadingRateWithShaderDepthStencilWrites"),
        ValueLayout.JAVA_INT.withName("fragmentShadingRateWithSampleMask"),
        ValueLayout.JAVA_INT.withName("fragmentShadingRateWithShaderSampleMask"),
        ValueLayout.JAVA_INT.withName("fragmentShadingRateWithConservativeRasterization"),
        ValueLayout.JAVA_INT.withName("fragmentShadingRateWithFragmentShaderInterlock"),
        ValueLayout.JAVA_INT.withName("fragmentShadingRateWithCustomSampleLocations"),
        ValueLayout.JAVA_INT.withName("fragmentShadingRateStrictMultiplyCombiner")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$minFragmentShadingRateAttachmentTexelSize = PathElement.groupElement("minFragmentShadingRateAttachmentTexelSize");
    public static final PathElement PATH$maxFragmentShadingRateAttachmentTexelSize = PathElement.groupElement("maxFragmentShadingRateAttachmentTexelSize");
    public static final PathElement PATH$maxFragmentShadingRateAttachmentTexelSizeAspectRatio = PathElement.groupElement("maxFragmentShadingRateAttachmentTexelSizeAspectRatio");
    public static final PathElement PATH$primitiveFragmentShadingRateWithMultipleViewports = PathElement.groupElement("primitiveFragmentShadingRateWithMultipleViewports");
    public static final PathElement PATH$layeredShadingRateAttachments = PathElement.groupElement("layeredShadingRateAttachments");
    public static final PathElement PATH$fragmentShadingRateNonTrivialCombinerOps = PathElement.groupElement("fragmentShadingRateNonTrivialCombinerOps");
    public static final PathElement PATH$maxFragmentSize = PathElement.groupElement("maxFragmentSize");
    public static final PathElement PATH$maxFragmentSizeAspectRatio = PathElement.groupElement("maxFragmentSizeAspectRatio");
    public static final PathElement PATH$maxFragmentShadingRateCoverageSamples = PathElement.groupElement("maxFragmentShadingRateCoverageSamples");
    public static final PathElement PATH$maxFragmentShadingRateRasterizationSamples = PathElement.groupElement("maxFragmentShadingRateRasterizationSamples");
    public static final PathElement PATH$fragmentShadingRateWithShaderDepthStencilWrites = PathElement.groupElement("fragmentShadingRateWithShaderDepthStencilWrites");
    public static final PathElement PATH$fragmentShadingRateWithSampleMask = PathElement.groupElement("fragmentShadingRateWithSampleMask");
    public static final PathElement PATH$fragmentShadingRateWithShaderSampleMask = PathElement.groupElement("fragmentShadingRateWithShaderSampleMask");
    public static final PathElement PATH$fragmentShadingRateWithConservativeRasterization = PathElement.groupElement("fragmentShadingRateWithConservativeRasterization");
    public static final PathElement PATH$fragmentShadingRateWithFragmentShaderInterlock = PathElement.groupElement("fragmentShadingRateWithFragmentShaderInterlock");
    public static final PathElement PATH$fragmentShadingRateWithCustomSampleLocations = PathElement.groupElement("fragmentShadingRateWithCustomSampleLocations");
    public static final PathElement PATH$fragmentShadingRateStrictMultiplyCombiner = PathElement.groupElement("fragmentShadingRateStrictMultiplyCombiner");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final StructLayout LAYOUT$minFragmentShadingRateAttachmentTexelSize = (StructLayout) LAYOUT.select(PATH$minFragmentShadingRateAttachmentTexelSize);
    public static final StructLayout LAYOUT$maxFragmentShadingRateAttachmentTexelSize = (StructLayout) LAYOUT.select(PATH$maxFragmentShadingRateAttachmentTexelSize);
    public static final OfInt LAYOUT$maxFragmentShadingRateAttachmentTexelSizeAspectRatio = (OfInt) LAYOUT.select(PATH$maxFragmentShadingRateAttachmentTexelSizeAspectRatio);
    public static final OfInt LAYOUT$primitiveFragmentShadingRateWithMultipleViewports = (OfInt) LAYOUT.select(PATH$primitiveFragmentShadingRateWithMultipleViewports);
    public static final OfInt LAYOUT$layeredShadingRateAttachments = (OfInt) LAYOUT.select(PATH$layeredShadingRateAttachments);
    public static final OfInt LAYOUT$fragmentShadingRateNonTrivialCombinerOps = (OfInt) LAYOUT.select(PATH$fragmentShadingRateNonTrivialCombinerOps);
    public static final StructLayout LAYOUT$maxFragmentSize = (StructLayout) LAYOUT.select(PATH$maxFragmentSize);
    public static final OfInt LAYOUT$maxFragmentSizeAspectRatio = (OfInt) LAYOUT.select(PATH$maxFragmentSizeAspectRatio);
    public static final OfInt LAYOUT$maxFragmentShadingRateCoverageSamples = (OfInt) LAYOUT.select(PATH$maxFragmentShadingRateCoverageSamples);
    public static final OfInt LAYOUT$maxFragmentShadingRateRasterizationSamples = (OfInt) LAYOUT.select(PATH$maxFragmentShadingRateRasterizationSamples);
    public static final OfInt LAYOUT$fragmentShadingRateWithShaderDepthStencilWrites = (OfInt) LAYOUT.select(PATH$fragmentShadingRateWithShaderDepthStencilWrites);
    public static final OfInt LAYOUT$fragmentShadingRateWithSampleMask = (OfInt) LAYOUT.select(PATH$fragmentShadingRateWithSampleMask);
    public static final OfInt LAYOUT$fragmentShadingRateWithShaderSampleMask = (OfInt) LAYOUT.select(PATH$fragmentShadingRateWithShaderSampleMask);
    public static final OfInt LAYOUT$fragmentShadingRateWithConservativeRasterization = (OfInt) LAYOUT.select(PATH$fragmentShadingRateWithConservativeRasterization);
    public static final OfInt LAYOUT$fragmentShadingRateWithFragmentShaderInterlock = (OfInt) LAYOUT.select(PATH$fragmentShadingRateWithFragmentShaderInterlock);
    public static final OfInt LAYOUT$fragmentShadingRateWithCustomSampleLocations = (OfInt) LAYOUT.select(PATH$fragmentShadingRateWithCustomSampleLocations);
    public static final OfInt LAYOUT$fragmentShadingRateStrictMultiplyCombiner = (OfInt) LAYOUT.select(PATH$fragmentShadingRateStrictMultiplyCombiner);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$minFragmentShadingRateAttachmentTexelSize = LAYOUT$minFragmentShadingRateAttachmentTexelSize.byteSize();
    public static final long SIZE$maxFragmentShadingRateAttachmentTexelSize = LAYOUT$maxFragmentShadingRateAttachmentTexelSize.byteSize();
    public static final long SIZE$maxFragmentShadingRateAttachmentTexelSizeAspectRatio = LAYOUT$maxFragmentShadingRateAttachmentTexelSizeAspectRatio.byteSize();
    public static final long SIZE$primitiveFragmentShadingRateWithMultipleViewports = LAYOUT$primitiveFragmentShadingRateWithMultipleViewports.byteSize();
    public static final long SIZE$layeredShadingRateAttachments = LAYOUT$layeredShadingRateAttachments.byteSize();
    public static final long SIZE$fragmentShadingRateNonTrivialCombinerOps = LAYOUT$fragmentShadingRateNonTrivialCombinerOps.byteSize();
    public static final long SIZE$maxFragmentSize = LAYOUT$maxFragmentSize.byteSize();
    public static final long SIZE$maxFragmentSizeAspectRatio = LAYOUT$maxFragmentSizeAspectRatio.byteSize();
    public static final long SIZE$maxFragmentShadingRateCoverageSamples = LAYOUT$maxFragmentShadingRateCoverageSamples.byteSize();
    public static final long SIZE$maxFragmentShadingRateRasterizationSamples = LAYOUT$maxFragmentShadingRateRasterizationSamples.byteSize();
    public static final long SIZE$fragmentShadingRateWithShaderDepthStencilWrites = LAYOUT$fragmentShadingRateWithShaderDepthStencilWrites.byteSize();
    public static final long SIZE$fragmentShadingRateWithSampleMask = LAYOUT$fragmentShadingRateWithSampleMask.byteSize();
    public static final long SIZE$fragmentShadingRateWithShaderSampleMask = LAYOUT$fragmentShadingRateWithShaderSampleMask.byteSize();
    public static final long SIZE$fragmentShadingRateWithConservativeRasterization = LAYOUT$fragmentShadingRateWithConservativeRasterization.byteSize();
    public static final long SIZE$fragmentShadingRateWithFragmentShaderInterlock = LAYOUT$fragmentShadingRateWithFragmentShaderInterlock.byteSize();
    public static final long SIZE$fragmentShadingRateWithCustomSampleLocations = LAYOUT$fragmentShadingRateWithCustomSampleLocations.byteSize();
    public static final long SIZE$fragmentShadingRateStrictMultiplyCombiner = LAYOUT$fragmentShadingRateStrictMultiplyCombiner.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$minFragmentShadingRateAttachmentTexelSize = LAYOUT.byteOffset(PATH$minFragmentShadingRateAttachmentTexelSize);
    public static final long OFFSET$maxFragmentShadingRateAttachmentTexelSize = LAYOUT.byteOffset(PATH$maxFragmentShadingRateAttachmentTexelSize);
    public static final long OFFSET$maxFragmentShadingRateAttachmentTexelSizeAspectRatio = LAYOUT.byteOffset(PATH$maxFragmentShadingRateAttachmentTexelSizeAspectRatio);
    public static final long OFFSET$primitiveFragmentShadingRateWithMultipleViewports = LAYOUT.byteOffset(PATH$primitiveFragmentShadingRateWithMultipleViewports);
    public static final long OFFSET$layeredShadingRateAttachments = LAYOUT.byteOffset(PATH$layeredShadingRateAttachments);
    public static final long OFFSET$fragmentShadingRateNonTrivialCombinerOps = LAYOUT.byteOffset(PATH$fragmentShadingRateNonTrivialCombinerOps);
    public static final long OFFSET$maxFragmentSize = LAYOUT.byteOffset(PATH$maxFragmentSize);
    public static final long OFFSET$maxFragmentSizeAspectRatio = LAYOUT.byteOffset(PATH$maxFragmentSizeAspectRatio);
    public static final long OFFSET$maxFragmentShadingRateCoverageSamples = LAYOUT.byteOffset(PATH$maxFragmentShadingRateCoverageSamples);
    public static final long OFFSET$maxFragmentShadingRateRasterizationSamples = LAYOUT.byteOffset(PATH$maxFragmentShadingRateRasterizationSamples);
    public static final long OFFSET$fragmentShadingRateWithShaderDepthStencilWrites = LAYOUT.byteOffset(PATH$fragmentShadingRateWithShaderDepthStencilWrites);
    public static final long OFFSET$fragmentShadingRateWithSampleMask = LAYOUT.byteOffset(PATH$fragmentShadingRateWithSampleMask);
    public static final long OFFSET$fragmentShadingRateWithShaderSampleMask = LAYOUT.byteOffset(PATH$fragmentShadingRateWithShaderSampleMask);
    public static final long OFFSET$fragmentShadingRateWithConservativeRasterization = LAYOUT.byteOffset(PATH$fragmentShadingRateWithConservativeRasterization);
    public static final long OFFSET$fragmentShadingRateWithFragmentShaderInterlock = LAYOUT.byteOffset(PATH$fragmentShadingRateWithFragmentShaderInterlock);
    public static final long OFFSET$fragmentShadingRateWithCustomSampleLocations = LAYOUT.byteOffset(PATH$fragmentShadingRateWithCustomSampleLocations);
    public static final long OFFSET$fragmentShadingRateStrictMultiplyCombiner = LAYOUT.byteOffset(PATH$fragmentShadingRateStrictMultiplyCombiner);
}
