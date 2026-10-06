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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceDescriptorHeapPropertiesEXT.html"><code>VkPhysicalDeviceDescriptorHeapPropertiesEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceDescriptorHeapPropertiesEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkDeviceSize samplerHeapAlignment; // @link substring="samplerHeapAlignment" target="#samplerHeapAlignment"
///     VkDeviceSize resourceHeapAlignment; // @link substring="resourceHeapAlignment" target="#resourceHeapAlignment"
///     VkDeviceSize maxSamplerHeapSize; // @link substring="maxSamplerHeapSize" target="#maxSamplerHeapSize"
///     VkDeviceSize maxResourceHeapSize; // @link substring="maxResourceHeapSize" target="#maxResourceHeapSize"
///     VkDeviceSize minSamplerHeapReservedRange; // @link substring="minSamplerHeapReservedRange" target="#minSamplerHeapReservedRange"
///     VkDeviceSize minSamplerHeapReservedRangeWithEmbedded; // @link substring="minSamplerHeapReservedRangeWithEmbedded" target="#minSamplerHeapReservedRangeWithEmbedded"
///     VkDeviceSize minResourceHeapReservedRange; // @link substring="minResourceHeapReservedRange" target="#minResourceHeapReservedRange"
///     VkDeviceSize samplerDescriptorSize; // @link substring="samplerDescriptorSize" target="#samplerDescriptorSize"
///     VkDeviceSize imageDescriptorSize; // @link substring="imageDescriptorSize" target="#imageDescriptorSize"
///     VkDeviceSize bufferDescriptorSize; // @link substring="bufferDescriptorSize" target="#bufferDescriptorSize"
///     VkDeviceSize samplerDescriptorAlignment; // @link substring="samplerDescriptorAlignment" target="#samplerDescriptorAlignment"
///     VkDeviceSize imageDescriptorAlignment; // @link substring="imageDescriptorAlignment" target="#imageDescriptorAlignment"
///     VkDeviceSize bufferDescriptorAlignment; // @link substring="bufferDescriptorAlignment" target="#bufferDescriptorAlignment"
///     VkDeviceSize maxPushDataSize; // @link substring="maxPushDataSize" target="#maxPushDataSize"
///     size_t imageCaptureReplayOpaqueDataSize; // @link substring="imageCaptureReplayOpaqueDataSize" target="#imageCaptureReplayOpaqueDataSize"
///     uint32_t maxDescriptorHeapEmbeddedSamplers; // @link substring="maxDescriptorHeapEmbeddedSamplers" target="#maxDescriptorHeapEmbeddedSamplers"
///     uint32_t samplerYcbcrConversionCount; // @link substring="samplerYcbcrConversionCount" target="#samplerYcbcrConversionCount"
///     VkBool32 sparseDescriptorHeaps; // @link substring="sparseDescriptorHeaps" target="#sparseDescriptorHeaps"
///     VkBool32 protectedDescriptorHeaps; // @link substring="protectedDescriptorHeaps" target="#protectedDescriptorHeaps"
/// } VkPhysicalDeviceDescriptorHeapPropertiesEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_DESCRIPTOR_HEAP_PROPERTIES_EXT`
///
/// The {@code allocate} ({@link VkPhysicalDeviceDescriptorHeapPropertiesEXT#allocate(Arena)}, {@link VkPhysicalDeviceDescriptorHeapPropertiesEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceDescriptorHeapPropertiesEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceDescriptorHeapPropertiesEXT.html"><code>VkPhysicalDeviceDescriptorHeapPropertiesEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceDescriptorHeapPropertiesEXT(@NotNull MemorySegment segment) implements IVkPhysicalDeviceDescriptorHeapPropertiesEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceDescriptorHeapPropertiesEXT.html"><code>VkPhysicalDeviceDescriptorHeapPropertiesEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceDescriptorHeapPropertiesEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceDescriptorHeapPropertiesEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceDescriptorHeapPropertiesEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceDescriptorHeapPropertiesEXT, Iterable<VkPhysicalDeviceDescriptorHeapPropertiesEXT> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceDescriptorHeapPropertiesEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceDescriptorHeapPropertiesEXT at(long index) {
            return new VkPhysicalDeviceDescriptorHeapPropertiesEXT(segment.asSlice(index * VkPhysicalDeviceDescriptorHeapPropertiesEXT.BYTES, VkPhysicalDeviceDescriptorHeapPropertiesEXT.BYTES));
        }

        public VkPhysicalDeviceDescriptorHeapPropertiesEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceDescriptorHeapPropertiesEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceDescriptorHeapPropertiesEXT value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceDescriptorHeapPropertiesEXT.BYTES, VkPhysicalDeviceDescriptorHeapPropertiesEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceDescriptorHeapPropertiesEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceDescriptorHeapPropertiesEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceDescriptorHeapPropertiesEXT.BYTES,
                (end - start) * VkPhysicalDeviceDescriptorHeapPropertiesEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceDescriptorHeapPropertiesEXT.BYTES));
        }

        public VkPhysicalDeviceDescriptorHeapPropertiesEXT[] toArray() {
            VkPhysicalDeviceDescriptorHeapPropertiesEXT[] ret = new VkPhysicalDeviceDescriptorHeapPropertiesEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceDescriptorHeapPropertiesEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceDescriptorHeapPropertiesEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceDescriptorHeapPropertiesEXT.BYTES;
            }

            @Override
            public VkPhysicalDeviceDescriptorHeapPropertiesEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceDescriptorHeapPropertiesEXT ret = new VkPhysicalDeviceDescriptorHeapPropertiesEXT(segment.asSlice(0, VkPhysicalDeviceDescriptorHeapPropertiesEXT.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceDescriptorHeapPropertiesEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceDescriptorHeapPropertiesEXT allocate(Arena arena) {
        VkPhysicalDeviceDescriptorHeapPropertiesEXT ret = new VkPhysicalDeviceDescriptorHeapPropertiesEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_DESCRIPTOR_HEAP_PROPERTIES_EXT);
        return ret;
    }

    public static VkPhysicalDeviceDescriptorHeapPropertiesEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceDescriptorHeapPropertiesEXT.Ptr ret = new VkPhysicalDeviceDescriptorHeapPropertiesEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_DESCRIPTOR_HEAP_PROPERTIES_EXT);
        }
        return ret;
    }

    public static VkPhysicalDeviceDescriptorHeapPropertiesEXT clone(Arena arena, VkPhysicalDeviceDescriptorHeapPropertiesEXT src) {
        VkPhysicalDeviceDescriptorHeapPropertiesEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_DESCRIPTOR_HEAP_PROPERTIES_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceDescriptorHeapPropertiesEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceDescriptorHeapPropertiesEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceDescriptorHeapPropertiesEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long samplerHeapAlignment() {
        return segment.get(LAYOUT$samplerHeapAlignment, OFFSET$samplerHeapAlignment);
    }

    public VkPhysicalDeviceDescriptorHeapPropertiesEXT samplerHeapAlignment(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$samplerHeapAlignment, OFFSET$samplerHeapAlignment, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long resourceHeapAlignment() {
        return segment.get(LAYOUT$resourceHeapAlignment, OFFSET$resourceHeapAlignment);
    }

    public VkPhysicalDeviceDescriptorHeapPropertiesEXT resourceHeapAlignment(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$resourceHeapAlignment, OFFSET$resourceHeapAlignment, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long maxSamplerHeapSize() {
        return segment.get(LAYOUT$maxSamplerHeapSize, OFFSET$maxSamplerHeapSize);
    }

    public VkPhysicalDeviceDescriptorHeapPropertiesEXT maxSamplerHeapSize(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$maxSamplerHeapSize, OFFSET$maxSamplerHeapSize, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long maxResourceHeapSize() {
        return segment.get(LAYOUT$maxResourceHeapSize, OFFSET$maxResourceHeapSize);
    }

    public VkPhysicalDeviceDescriptorHeapPropertiesEXT maxResourceHeapSize(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$maxResourceHeapSize, OFFSET$maxResourceHeapSize, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long minSamplerHeapReservedRange() {
        return segment.get(LAYOUT$minSamplerHeapReservedRange, OFFSET$minSamplerHeapReservedRange);
    }

    public VkPhysicalDeviceDescriptorHeapPropertiesEXT minSamplerHeapReservedRange(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$minSamplerHeapReservedRange, OFFSET$minSamplerHeapReservedRange, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long minSamplerHeapReservedRangeWithEmbedded() {
        return segment.get(LAYOUT$minSamplerHeapReservedRangeWithEmbedded, OFFSET$minSamplerHeapReservedRangeWithEmbedded);
    }

    public VkPhysicalDeviceDescriptorHeapPropertiesEXT minSamplerHeapReservedRangeWithEmbedded(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$minSamplerHeapReservedRangeWithEmbedded, OFFSET$minSamplerHeapReservedRangeWithEmbedded, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long minResourceHeapReservedRange() {
        return segment.get(LAYOUT$minResourceHeapReservedRange, OFFSET$minResourceHeapReservedRange);
    }

    public VkPhysicalDeviceDescriptorHeapPropertiesEXT minResourceHeapReservedRange(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$minResourceHeapReservedRange, OFFSET$minResourceHeapReservedRange, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long samplerDescriptorSize() {
        return segment.get(LAYOUT$samplerDescriptorSize, OFFSET$samplerDescriptorSize);
    }

    public VkPhysicalDeviceDescriptorHeapPropertiesEXT samplerDescriptorSize(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$samplerDescriptorSize, OFFSET$samplerDescriptorSize, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long imageDescriptorSize() {
        return segment.get(LAYOUT$imageDescriptorSize, OFFSET$imageDescriptorSize);
    }

    public VkPhysicalDeviceDescriptorHeapPropertiesEXT imageDescriptorSize(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$imageDescriptorSize, OFFSET$imageDescriptorSize, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long bufferDescriptorSize() {
        return segment.get(LAYOUT$bufferDescriptorSize, OFFSET$bufferDescriptorSize);
    }

    public VkPhysicalDeviceDescriptorHeapPropertiesEXT bufferDescriptorSize(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$bufferDescriptorSize, OFFSET$bufferDescriptorSize, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long samplerDescriptorAlignment() {
        return segment.get(LAYOUT$samplerDescriptorAlignment, OFFSET$samplerDescriptorAlignment);
    }

    public VkPhysicalDeviceDescriptorHeapPropertiesEXT samplerDescriptorAlignment(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$samplerDescriptorAlignment, OFFSET$samplerDescriptorAlignment, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long imageDescriptorAlignment() {
        return segment.get(LAYOUT$imageDescriptorAlignment, OFFSET$imageDescriptorAlignment);
    }

    public VkPhysicalDeviceDescriptorHeapPropertiesEXT imageDescriptorAlignment(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$imageDescriptorAlignment, OFFSET$imageDescriptorAlignment, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long bufferDescriptorAlignment() {
        return segment.get(LAYOUT$bufferDescriptorAlignment, OFFSET$bufferDescriptorAlignment);
    }

    public VkPhysicalDeviceDescriptorHeapPropertiesEXT bufferDescriptorAlignment(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$bufferDescriptorAlignment, OFFSET$bufferDescriptorAlignment, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long maxPushDataSize() {
        return segment.get(LAYOUT$maxPushDataSize, OFFSET$maxPushDataSize);
    }

    public VkPhysicalDeviceDescriptorHeapPropertiesEXT maxPushDataSize(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$maxPushDataSize, OFFSET$maxPushDataSize, value);
        return this;
    }

    public @Unsigned long imageCaptureReplayOpaqueDataSize() {
        return NativeLayout.readCSizeT(segment, OFFSET$imageCaptureReplayOpaqueDataSize);
    }

    public VkPhysicalDeviceDescriptorHeapPropertiesEXT imageCaptureReplayOpaqueDataSize(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$imageCaptureReplayOpaqueDataSize, value);
        return this;
    }

    public @Unsigned int maxDescriptorHeapEmbeddedSamplers() {
        return segment.get(LAYOUT$maxDescriptorHeapEmbeddedSamplers, OFFSET$maxDescriptorHeapEmbeddedSamplers);
    }

    public VkPhysicalDeviceDescriptorHeapPropertiesEXT maxDescriptorHeapEmbeddedSamplers(@Unsigned int value) {
        segment.set(LAYOUT$maxDescriptorHeapEmbeddedSamplers, OFFSET$maxDescriptorHeapEmbeddedSamplers, value);
        return this;
    }

    public @Unsigned int samplerYcbcrConversionCount() {
        return segment.get(LAYOUT$samplerYcbcrConversionCount, OFFSET$samplerYcbcrConversionCount);
    }

    public VkPhysicalDeviceDescriptorHeapPropertiesEXT samplerYcbcrConversionCount(@Unsigned int value) {
        segment.set(LAYOUT$samplerYcbcrConversionCount, OFFSET$samplerYcbcrConversionCount, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int sparseDescriptorHeaps() {
        return segment.get(LAYOUT$sparseDescriptorHeaps, OFFSET$sparseDescriptorHeaps);
    }

    public VkPhysicalDeviceDescriptorHeapPropertiesEXT sparseDescriptorHeaps(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$sparseDescriptorHeaps, OFFSET$sparseDescriptorHeaps, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int protectedDescriptorHeaps() {
        return segment.get(LAYOUT$protectedDescriptorHeaps, OFFSET$protectedDescriptorHeaps);
    }

    public VkPhysicalDeviceDescriptorHeapPropertiesEXT protectedDescriptorHeaps(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$protectedDescriptorHeaps, OFFSET$protectedDescriptorHeaps, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_LONG.withName("samplerHeapAlignment"),
        ValueLayout.JAVA_LONG.withName("resourceHeapAlignment"),
        ValueLayout.JAVA_LONG.withName("maxSamplerHeapSize"),
        ValueLayout.JAVA_LONG.withName("maxResourceHeapSize"),
        ValueLayout.JAVA_LONG.withName("minSamplerHeapReservedRange"),
        ValueLayout.JAVA_LONG.withName("minSamplerHeapReservedRangeWithEmbedded"),
        ValueLayout.JAVA_LONG.withName("minResourceHeapReservedRange"),
        ValueLayout.JAVA_LONG.withName("samplerDescriptorSize"),
        ValueLayout.JAVA_LONG.withName("imageDescriptorSize"),
        ValueLayout.JAVA_LONG.withName("bufferDescriptorSize"),
        ValueLayout.JAVA_LONG.withName("samplerDescriptorAlignment"),
        ValueLayout.JAVA_LONG.withName("imageDescriptorAlignment"),
        ValueLayout.JAVA_LONG.withName("bufferDescriptorAlignment"),
        ValueLayout.JAVA_LONG.withName("maxPushDataSize"),
        NativeLayout.C_SIZE_T.withName("imageCaptureReplayOpaqueDataSize"),
        ValueLayout.JAVA_INT.withName("maxDescriptorHeapEmbeddedSamplers"),
        ValueLayout.JAVA_INT.withName("samplerYcbcrConversionCount"),
        ValueLayout.JAVA_INT.withName("sparseDescriptorHeaps"),
        ValueLayout.JAVA_INT.withName("protectedDescriptorHeaps")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$samplerHeapAlignment = PathElement.groupElement("samplerHeapAlignment");
    public static final PathElement PATH$resourceHeapAlignment = PathElement.groupElement("resourceHeapAlignment");
    public static final PathElement PATH$maxSamplerHeapSize = PathElement.groupElement("maxSamplerHeapSize");
    public static final PathElement PATH$maxResourceHeapSize = PathElement.groupElement("maxResourceHeapSize");
    public static final PathElement PATH$minSamplerHeapReservedRange = PathElement.groupElement("minSamplerHeapReservedRange");
    public static final PathElement PATH$minSamplerHeapReservedRangeWithEmbedded = PathElement.groupElement("minSamplerHeapReservedRangeWithEmbedded");
    public static final PathElement PATH$minResourceHeapReservedRange = PathElement.groupElement("minResourceHeapReservedRange");
    public static final PathElement PATH$samplerDescriptorSize = PathElement.groupElement("samplerDescriptorSize");
    public static final PathElement PATH$imageDescriptorSize = PathElement.groupElement("imageDescriptorSize");
    public static final PathElement PATH$bufferDescriptorSize = PathElement.groupElement("bufferDescriptorSize");
    public static final PathElement PATH$samplerDescriptorAlignment = PathElement.groupElement("samplerDescriptorAlignment");
    public static final PathElement PATH$imageDescriptorAlignment = PathElement.groupElement("imageDescriptorAlignment");
    public static final PathElement PATH$bufferDescriptorAlignment = PathElement.groupElement("bufferDescriptorAlignment");
    public static final PathElement PATH$maxPushDataSize = PathElement.groupElement("maxPushDataSize");
    public static final PathElement PATH$imageCaptureReplayOpaqueDataSize = PathElement.groupElement("imageCaptureReplayOpaqueDataSize");
    public static final PathElement PATH$maxDescriptorHeapEmbeddedSamplers = PathElement.groupElement("maxDescriptorHeapEmbeddedSamplers");
    public static final PathElement PATH$samplerYcbcrConversionCount = PathElement.groupElement("samplerYcbcrConversionCount");
    public static final PathElement PATH$sparseDescriptorHeaps = PathElement.groupElement("sparseDescriptorHeaps");
    public static final PathElement PATH$protectedDescriptorHeaps = PathElement.groupElement("protectedDescriptorHeaps");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfLong LAYOUT$samplerHeapAlignment = (OfLong) LAYOUT.select(PATH$samplerHeapAlignment);
    public static final OfLong LAYOUT$resourceHeapAlignment = (OfLong) LAYOUT.select(PATH$resourceHeapAlignment);
    public static final OfLong LAYOUT$maxSamplerHeapSize = (OfLong) LAYOUT.select(PATH$maxSamplerHeapSize);
    public static final OfLong LAYOUT$maxResourceHeapSize = (OfLong) LAYOUT.select(PATH$maxResourceHeapSize);
    public static final OfLong LAYOUT$minSamplerHeapReservedRange = (OfLong) LAYOUT.select(PATH$minSamplerHeapReservedRange);
    public static final OfLong LAYOUT$minSamplerHeapReservedRangeWithEmbedded = (OfLong) LAYOUT.select(PATH$minSamplerHeapReservedRangeWithEmbedded);
    public static final OfLong LAYOUT$minResourceHeapReservedRange = (OfLong) LAYOUT.select(PATH$minResourceHeapReservedRange);
    public static final OfLong LAYOUT$samplerDescriptorSize = (OfLong) LAYOUT.select(PATH$samplerDescriptorSize);
    public static final OfLong LAYOUT$imageDescriptorSize = (OfLong) LAYOUT.select(PATH$imageDescriptorSize);
    public static final OfLong LAYOUT$bufferDescriptorSize = (OfLong) LAYOUT.select(PATH$bufferDescriptorSize);
    public static final OfLong LAYOUT$samplerDescriptorAlignment = (OfLong) LAYOUT.select(PATH$samplerDescriptorAlignment);
    public static final OfLong LAYOUT$imageDescriptorAlignment = (OfLong) LAYOUT.select(PATH$imageDescriptorAlignment);
    public static final OfLong LAYOUT$bufferDescriptorAlignment = (OfLong) LAYOUT.select(PATH$bufferDescriptorAlignment);
    public static final OfLong LAYOUT$maxPushDataSize = (OfLong) LAYOUT.select(PATH$maxPushDataSize);
    public static final OfInt LAYOUT$maxDescriptorHeapEmbeddedSamplers = (OfInt) LAYOUT.select(PATH$maxDescriptorHeapEmbeddedSamplers);
    public static final OfInt LAYOUT$samplerYcbcrConversionCount = (OfInt) LAYOUT.select(PATH$samplerYcbcrConversionCount);
    public static final OfInt LAYOUT$sparseDescriptorHeaps = (OfInt) LAYOUT.select(PATH$sparseDescriptorHeaps);
    public static final OfInt LAYOUT$protectedDescriptorHeaps = (OfInt) LAYOUT.select(PATH$protectedDescriptorHeaps);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$samplerHeapAlignment = LAYOUT$samplerHeapAlignment.byteSize();
    public static final long SIZE$resourceHeapAlignment = LAYOUT$resourceHeapAlignment.byteSize();
    public static final long SIZE$maxSamplerHeapSize = LAYOUT$maxSamplerHeapSize.byteSize();
    public static final long SIZE$maxResourceHeapSize = LAYOUT$maxResourceHeapSize.byteSize();
    public static final long SIZE$minSamplerHeapReservedRange = LAYOUT$minSamplerHeapReservedRange.byteSize();
    public static final long SIZE$minSamplerHeapReservedRangeWithEmbedded = LAYOUT$minSamplerHeapReservedRangeWithEmbedded.byteSize();
    public static final long SIZE$minResourceHeapReservedRange = LAYOUT$minResourceHeapReservedRange.byteSize();
    public static final long SIZE$samplerDescriptorSize = LAYOUT$samplerDescriptorSize.byteSize();
    public static final long SIZE$imageDescriptorSize = LAYOUT$imageDescriptorSize.byteSize();
    public static final long SIZE$bufferDescriptorSize = LAYOUT$bufferDescriptorSize.byteSize();
    public static final long SIZE$samplerDescriptorAlignment = LAYOUT$samplerDescriptorAlignment.byteSize();
    public static final long SIZE$imageDescriptorAlignment = LAYOUT$imageDescriptorAlignment.byteSize();
    public static final long SIZE$bufferDescriptorAlignment = LAYOUT$bufferDescriptorAlignment.byteSize();
    public static final long SIZE$maxPushDataSize = LAYOUT$maxPushDataSize.byteSize();
    public static final long SIZE$imageCaptureReplayOpaqueDataSize = NativeLayout.C_SIZE_T.byteSize();
    public static final long SIZE$maxDescriptorHeapEmbeddedSamplers = LAYOUT$maxDescriptorHeapEmbeddedSamplers.byteSize();
    public static final long SIZE$samplerYcbcrConversionCount = LAYOUT$samplerYcbcrConversionCount.byteSize();
    public static final long SIZE$sparseDescriptorHeaps = LAYOUT$sparseDescriptorHeaps.byteSize();
    public static final long SIZE$protectedDescriptorHeaps = LAYOUT$protectedDescriptorHeaps.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$samplerHeapAlignment = LAYOUT.byteOffset(PATH$samplerHeapAlignment);
    public static final long OFFSET$resourceHeapAlignment = LAYOUT.byteOffset(PATH$resourceHeapAlignment);
    public static final long OFFSET$maxSamplerHeapSize = LAYOUT.byteOffset(PATH$maxSamplerHeapSize);
    public static final long OFFSET$maxResourceHeapSize = LAYOUT.byteOffset(PATH$maxResourceHeapSize);
    public static final long OFFSET$minSamplerHeapReservedRange = LAYOUT.byteOffset(PATH$minSamplerHeapReservedRange);
    public static final long OFFSET$minSamplerHeapReservedRangeWithEmbedded = LAYOUT.byteOffset(PATH$minSamplerHeapReservedRangeWithEmbedded);
    public static final long OFFSET$minResourceHeapReservedRange = LAYOUT.byteOffset(PATH$minResourceHeapReservedRange);
    public static final long OFFSET$samplerDescriptorSize = LAYOUT.byteOffset(PATH$samplerDescriptorSize);
    public static final long OFFSET$imageDescriptorSize = LAYOUT.byteOffset(PATH$imageDescriptorSize);
    public static final long OFFSET$bufferDescriptorSize = LAYOUT.byteOffset(PATH$bufferDescriptorSize);
    public static final long OFFSET$samplerDescriptorAlignment = LAYOUT.byteOffset(PATH$samplerDescriptorAlignment);
    public static final long OFFSET$imageDescriptorAlignment = LAYOUT.byteOffset(PATH$imageDescriptorAlignment);
    public static final long OFFSET$bufferDescriptorAlignment = LAYOUT.byteOffset(PATH$bufferDescriptorAlignment);
    public static final long OFFSET$maxPushDataSize = LAYOUT.byteOffset(PATH$maxPushDataSize);
    public static final long OFFSET$imageCaptureReplayOpaqueDataSize = LAYOUT.byteOffset(PATH$imageCaptureReplayOpaqueDataSize);
    public static final long OFFSET$maxDescriptorHeapEmbeddedSamplers = LAYOUT.byteOffset(PATH$maxDescriptorHeapEmbeddedSamplers);
    public static final long OFFSET$samplerYcbcrConversionCount = LAYOUT.byteOffset(PATH$samplerYcbcrConversionCount);
    public static final long OFFSET$sparseDescriptorHeaps = LAYOUT.byteOffset(PATH$sparseDescriptorHeaps);
    public static final long OFFSET$protectedDescriptorHeaps = LAYOUT.byteOffset(PATH$protectedDescriptorHeaps);
}
