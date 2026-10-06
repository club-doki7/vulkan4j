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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAndroidHardwareBufferFormatPropertiesANDROID.html"><code>VkAndroidHardwareBufferFormatPropertiesANDROID</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkAndroidHardwareBufferFormatPropertiesANDROID {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkFormat format; // @link substring="VkFormat" target="VkFormat" @link substring="format" target="#format"
///     uint64_t externalFormat; // @link substring="externalFormat" target="#externalFormat"
///     VkFormatFeatureFlags formatFeatures; // @link substring="VkFormatFeatureFlags" target="VkFormatFeatureFlags" @link substring="formatFeatures" target="#formatFeatures"
///     VkComponentMapping samplerYcbcrConversionComponents; // @link substring="VkComponentMapping" target="VkComponentMapping" @link substring="samplerYcbcrConversionComponents" target="#samplerYcbcrConversionComponents"
///     VkSamplerYcbcrModelConversion suggestedYcbcrModel; // @link substring="VkSamplerYcbcrModelConversion" target="VkSamplerYcbcrModelConversion" @link substring="suggestedYcbcrModel" target="#suggestedYcbcrModel"
///     VkSamplerYcbcrRange suggestedYcbcrRange; // @link substring="VkSamplerYcbcrRange" target="VkSamplerYcbcrRange" @link substring="suggestedYcbcrRange" target="#suggestedYcbcrRange"
///     VkChromaLocation suggestedXChromaOffset; // @link substring="VkChromaLocation" target="VkChromaLocation" @link substring="suggestedXChromaOffset" target="#suggestedXChromaOffset"
///     VkChromaLocation suggestedYChromaOffset; // @link substring="VkChromaLocation" target="VkChromaLocation" @link substring="suggestedYChromaOffset" target="#suggestedYChromaOffset"
/// } VkAndroidHardwareBufferFormatPropertiesANDROID;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_ANDROID_HARDWARE_BUFFER_FORMAT_PROPERTIES_ANDROID`
///
/// The {@code allocate} ({@link VkAndroidHardwareBufferFormatPropertiesANDROID#allocate(Arena)}, {@link VkAndroidHardwareBufferFormatPropertiesANDROID#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkAndroidHardwareBufferFormatPropertiesANDROID#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAndroidHardwareBufferFormatPropertiesANDROID.html"><code>VkAndroidHardwareBufferFormatPropertiesANDROID</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkAndroidHardwareBufferFormatPropertiesANDROID(@NotNull MemorySegment segment) implements IVkAndroidHardwareBufferFormatPropertiesANDROID {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAndroidHardwareBufferFormatPropertiesANDROID.html"><code>VkAndroidHardwareBufferFormatPropertiesANDROID</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkAndroidHardwareBufferFormatPropertiesANDROID}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkAndroidHardwareBufferFormatPropertiesANDROID to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkAndroidHardwareBufferFormatPropertiesANDROID.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkAndroidHardwareBufferFormatPropertiesANDROID, Iterable<VkAndroidHardwareBufferFormatPropertiesANDROID> {
        public long size() {
            return segment.byteSize() / VkAndroidHardwareBufferFormatPropertiesANDROID.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkAndroidHardwareBufferFormatPropertiesANDROID at(long index) {
            return new VkAndroidHardwareBufferFormatPropertiesANDROID(segment.asSlice(index * VkAndroidHardwareBufferFormatPropertiesANDROID.BYTES, VkAndroidHardwareBufferFormatPropertiesANDROID.BYTES));
        }

        public VkAndroidHardwareBufferFormatPropertiesANDROID.Ptr at(long index, @NotNull Consumer<@NotNull VkAndroidHardwareBufferFormatPropertiesANDROID> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkAndroidHardwareBufferFormatPropertiesANDROID value) {
            MemorySegment s = segment.asSlice(index * VkAndroidHardwareBufferFormatPropertiesANDROID.BYTES, VkAndroidHardwareBufferFormatPropertiesANDROID.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkAndroidHardwareBufferFormatPropertiesANDROID.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkAndroidHardwareBufferFormatPropertiesANDROID.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkAndroidHardwareBufferFormatPropertiesANDROID.BYTES,
                (end - start) * VkAndroidHardwareBufferFormatPropertiesANDROID.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkAndroidHardwareBufferFormatPropertiesANDROID.BYTES));
        }

        public VkAndroidHardwareBufferFormatPropertiesANDROID[] toArray() {
            VkAndroidHardwareBufferFormatPropertiesANDROID[] ret = new VkAndroidHardwareBufferFormatPropertiesANDROID[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkAndroidHardwareBufferFormatPropertiesANDROID> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkAndroidHardwareBufferFormatPropertiesANDROID> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkAndroidHardwareBufferFormatPropertiesANDROID.BYTES;
            }

            @Override
            public VkAndroidHardwareBufferFormatPropertiesANDROID next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkAndroidHardwareBufferFormatPropertiesANDROID ret = new VkAndroidHardwareBufferFormatPropertiesANDROID(segment.asSlice(0, VkAndroidHardwareBufferFormatPropertiesANDROID.BYTES));
                segment = segment.asSlice(VkAndroidHardwareBufferFormatPropertiesANDROID.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkAndroidHardwareBufferFormatPropertiesANDROID allocate(Arena arena) {
        VkAndroidHardwareBufferFormatPropertiesANDROID ret = new VkAndroidHardwareBufferFormatPropertiesANDROID(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.ANDROID_HARDWARE_BUFFER_FORMAT_PROPERTIES_ANDROID);
        return ret;
    }

    public static VkAndroidHardwareBufferFormatPropertiesANDROID.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkAndroidHardwareBufferFormatPropertiesANDROID.Ptr ret = new VkAndroidHardwareBufferFormatPropertiesANDROID.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.ANDROID_HARDWARE_BUFFER_FORMAT_PROPERTIES_ANDROID);
        }
        return ret;
    }

    public static VkAndroidHardwareBufferFormatPropertiesANDROID clone(Arena arena, VkAndroidHardwareBufferFormatPropertiesANDROID src) {
        VkAndroidHardwareBufferFormatPropertiesANDROID ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.ANDROID_HARDWARE_BUFFER_FORMAT_PROPERTIES_ANDROID);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkAndroidHardwareBufferFormatPropertiesANDROID sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkAndroidHardwareBufferFormatPropertiesANDROID pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkAndroidHardwareBufferFormatPropertiesANDROID pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @EnumType(VkFormat.class) int format() {
        return segment.get(LAYOUT$format, OFFSET$format);
    }

    public VkAndroidHardwareBufferFormatPropertiesANDROID format(@EnumType(VkFormat.class) int value) {
        segment.set(LAYOUT$format, OFFSET$format, value);
        return this;
    }

    public @Unsigned long externalFormat() {
        return segment.get(LAYOUT$externalFormat, OFFSET$externalFormat);
    }

    public VkAndroidHardwareBufferFormatPropertiesANDROID externalFormat(@Unsigned long value) {
        segment.set(LAYOUT$externalFormat, OFFSET$externalFormat, value);
        return this;
    }

    public @Bitmask(VkFormatFeatureFlags.class) int formatFeatures() {
        return segment.get(LAYOUT$formatFeatures, OFFSET$formatFeatures);
    }

    public VkAndroidHardwareBufferFormatPropertiesANDROID formatFeatures(@Bitmask(VkFormatFeatureFlags.class) int value) {
        segment.set(LAYOUT$formatFeatures, OFFSET$formatFeatures, value);
        return this;
    }

    public @NotNull VkComponentMapping samplerYcbcrConversionComponents() {
        return new VkComponentMapping(segment.asSlice(OFFSET$samplerYcbcrConversionComponents, LAYOUT$samplerYcbcrConversionComponents));
    }

    public VkAndroidHardwareBufferFormatPropertiesANDROID samplerYcbcrConversionComponents(@NotNull VkComponentMapping value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$samplerYcbcrConversionComponents, SIZE$samplerYcbcrConversionComponents);
        return this;
    }

    public VkAndroidHardwareBufferFormatPropertiesANDROID samplerYcbcrConversionComponents(Consumer<@NotNull VkComponentMapping> consumer) {
        consumer.accept(samplerYcbcrConversionComponents());
        return this;
    }

    public @EnumType(VkSamplerYcbcrModelConversion.class) int suggestedYcbcrModel() {
        return segment.get(LAYOUT$suggestedYcbcrModel, OFFSET$suggestedYcbcrModel);
    }

    public VkAndroidHardwareBufferFormatPropertiesANDROID suggestedYcbcrModel(@EnumType(VkSamplerYcbcrModelConversion.class) int value) {
        segment.set(LAYOUT$suggestedYcbcrModel, OFFSET$suggestedYcbcrModel, value);
        return this;
    }

    public @EnumType(VkSamplerYcbcrRange.class) int suggestedYcbcrRange() {
        return segment.get(LAYOUT$suggestedYcbcrRange, OFFSET$suggestedYcbcrRange);
    }

    public VkAndroidHardwareBufferFormatPropertiesANDROID suggestedYcbcrRange(@EnumType(VkSamplerYcbcrRange.class) int value) {
        segment.set(LAYOUT$suggestedYcbcrRange, OFFSET$suggestedYcbcrRange, value);
        return this;
    }

    public @EnumType(VkChromaLocation.class) int suggestedXChromaOffset() {
        return segment.get(LAYOUT$suggestedXChromaOffset, OFFSET$suggestedXChromaOffset);
    }

    public VkAndroidHardwareBufferFormatPropertiesANDROID suggestedXChromaOffset(@EnumType(VkChromaLocation.class) int value) {
        segment.set(LAYOUT$suggestedXChromaOffset, OFFSET$suggestedXChromaOffset, value);
        return this;
    }

    public @EnumType(VkChromaLocation.class) int suggestedYChromaOffset() {
        return segment.get(LAYOUT$suggestedYChromaOffset, OFFSET$suggestedYChromaOffset);
    }

    public VkAndroidHardwareBufferFormatPropertiesANDROID suggestedYChromaOffset(@EnumType(VkChromaLocation.class) int value) {
        segment.set(LAYOUT$suggestedYChromaOffset, OFFSET$suggestedYChromaOffset, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("format"),
        ValueLayout.JAVA_LONG.withName("externalFormat"),
        ValueLayout.JAVA_INT.withName("formatFeatures"),
        VkComponentMapping.LAYOUT.withName("samplerYcbcrConversionComponents"),
        ValueLayout.JAVA_INT.withName("suggestedYcbcrModel"),
        ValueLayout.JAVA_INT.withName("suggestedYcbcrRange"),
        ValueLayout.JAVA_INT.withName("suggestedXChromaOffset"),
        ValueLayout.JAVA_INT.withName("suggestedYChromaOffset")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$format = PathElement.groupElement("format");
    public static final PathElement PATH$externalFormat = PathElement.groupElement("externalFormat");
    public static final PathElement PATH$formatFeatures = PathElement.groupElement("formatFeatures");
    public static final PathElement PATH$samplerYcbcrConversionComponents = PathElement.groupElement("samplerYcbcrConversionComponents");
    public static final PathElement PATH$suggestedYcbcrModel = PathElement.groupElement("suggestedYcbcrModel");
    public static final PathElement PATH$suggestedYcbcrRange = PathElement.groupElement("suggestedYcbcrRange");
    public static final PathElement PATH$suggestedXChromaOffset = PathElement.groupElement("suggestedXChromaOffset");
    public static final PathElement PATH$suggestedYChromaOffset = PathElement.groupElement("suggestedYChromaOffset");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$format = (OfInt) LAYOUT.select(PATH$format);
    public static final OfLong LAYOUT$externalFormat = (OfLong) LAYOUT.select(PATH$externalFormat);
    public static final OfInt LAYOUT$formatFeatures = (OfInt) LAYOUT.select(PATH$formatFeatures);
    public static final StructLayout LAYOUT$samplerYcbcrConversionComponents = (StructLayout) LAYOUT.select(PATH$samplerYcbcrConversionComponents);
    public static final OfInt LAYOUT$suggestedYcbcrModel = (OfInt) LAYOUT.select(PATH$suggestedYcbcrModel);
    public static final OfInt LAYOUT$suggestedYcbcrRange = (OfInt) LAYOUT.select(PATH$suggestedYcbcrRange);
    public static final OfInt LAYOUT$suggestedXChromaOffset = (OfInt) LAYOUT.select(PATH$suggestedXChromaOffset);
    public static final OfInt LAYOUT$suggestedYChromaOffset = (OfInt) LAYOUT.select(PATH$suggestedYChromaOffset);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$format = LAYOUT$format.byteSize();
    public static final long SIZE$externalFormat = LAYOUT$externalFormat.byteSize();
    public static final long SIZE$formatFeatures = LAYOUT$formatFeatures.byteSize();
    public static final long SIZE$samplerYcbcrConversionComponents = LAYOUT$samplerYcbcrConversionComponents.byteSize();
    public static final long SIZE$suggestedYcbcrModel = LAYOUT$suggestedYcbcrModel.byteSize();
    public static final long SIZE$suggestedYcbcrRange = LAYOUT$suggestedYcbcrRange.byteSize();
    public static final long SIZE$suggestedXChromaOffset = LAYOUT$suggestedXChromaOffset.byteSize();
    public static final long SIZE$suggestedYChromaOffset = LAYOUT$suggestedYChromaOffset.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$format = LAYOUT.byteOffset(PATH$format);
    public static final long OFFSET$externalFormat = LAYOUT.byteOffset(PATH$externalFormat);
    public static final long OFFSET$formatFeatures = LAYOUT.byteOffset(PATH$formatFeatures);
    public static final long OFFSET$samplerYcbcrConversionComponents = LAYOUT.byteOffset(PATH$samplerYcbcrConversionComponents);
    public static final long OFFSET$suggestedYcbcrModel = LAYOUT.byteOffset(PATH$suggestedYcbcrModel);
    public static final long OFFSET$suggestedYcbcrRange = LAYOUT.byteOffset(PATH$suggestedYcbcrRange);
    public static final long OFFSET$suggestedXChromaOffset = LAYOUT.byteOffset(PATH$suggestedXChromaOffset);
    public static final long OFFSET$suggestedYChromaOffset = LAYOUT.byteOffset(PATH$suggestedYChromaOffset);
}
