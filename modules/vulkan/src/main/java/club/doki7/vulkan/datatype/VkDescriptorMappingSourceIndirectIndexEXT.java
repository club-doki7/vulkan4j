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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDescriptorMappingSourceIndirectIndexEXT.html"><code>VkDescriptorMappingSourceIndirectIndexEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDescriptorMappingSourceIndirectIndexEXT {
///     uint32_t heapOffset; // @link substring="heapOffset" target="#heapOffset"
///     uint32_t pushOffset; // @link substring="pushOffset" target="#pushOffset"
///     uint32_t addressOffset; // @link substring="addressOffset" target="#addressOffset"
///     uint32_t heapIndexStride; // @link substring="heapIndexStride" target="#heapIndexStride"
///     uint32_t heapArrayStride; // @link substring="heapArrayStride" target="#heapArrayStride"
///     VkSamplerCreateInfo const* pEmbeddedSampler; // optional // @link substring="VkSamplerCreateInfo" target="VkSamplerCreateInfo" @link substring="pEmbeddedSampler" target="#pEmbeddedSampler"
///     VkBool32 useCombinedImageSamplerIndex; // @link substring="useCombinedImageSamplerIndex" target="#useCombinedImageSamplerIndex"
///     uint32_t samplerHeapOffset; // @link substring="samplerHeapOffset" target="#samplerHeapOffset"
///     uint32_t samplerPushOffset; // @link substring="samplerPushOffset" target="#samplerPushOffset"
///     uint32_t samplerAddressOffset; // @link substring="samplerAddressOffset" target="#samplerAddressOffset"
///     uint32_t samplerHeapIndexStride; // @link substring="samplerHeapIndexStride" target="#samplerHeapIndexStride"
///     uint32_t samplerHeapArrayStride; // @link substring="samplerHeapArrayStride" target="#samplerHeapArrayStride"
/// } VkDescriptorMappingSourceIndirectIndexEXT;
/// }
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDescriptorMappingSourceIndirectIndexEXT.html"><code>VkDescriptorMappingSourceIndirectIndexEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDescriptorMappingSourceIndirectIndexEXT(@NotNull MemorySegment segment) implements IVkDescriptorMappingSourceIndirectIndexEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDescriptorMappingSourceIndirectIndexEXT.html"><code>VkDescriptorMappingSourceIndirectIndexEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDescriptorMappingSourceIndirectIndexEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDescriptorMappingSourceIndirectIndexEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDescriptorMappingSourceIndirectIndexEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDescriptorMappingSourceIndirectIndexEXT, Iterable<VkDescriptorMappingSourceIndirectIndexEXT> {
        public long size() {
            return segment.byteSize() / VkDescriptorMappingSourceIndirectIndexEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDescriptorMappingSourceIndirectIndexEXT at(long index) {
            return new VkDescriptorMappingSourceIndirectIndexEXT(segment.asSlice(index * VkDescriptorMappingSourceIndirectIndexEXT.BYTES, VkDescriptorMappingSourceIndirectIndexEXT.BYTES));
        }

        public VkDescriptorMappingSourceIndirectIndexEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkDescriptorMappingSourceIndirectIndexEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDescriptorMappingSourceIndirectIndexEXT value) {
            MemorySegment s = segment.asSlice(index * VkDescriptorMappingSourceIndirectIndexEXT.BYTES, VkDescriptorMappingSourceIndirectIndexEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDescriptorMappingSourceIndirectIndexEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDescriptorMappingSourceIndirectIndexEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDescriptorMappingSourceIndirectIndexEXT.BYTES,
                (end - start) * VkDescriptorMappingSourceIndirectIndexEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDescriptorMappingSourceIndirectIndexEXT.BYTES));
        }

        public VkDescriptorMappingSourceIndirectIndexEXT[] toArray() {
            VkDescriptorMappingSourceIndirectIndexEXT[] ret = new VkDescriptorMappingSourceIndirectIndexEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDescriptorMappingSourceIndirectIndexEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDescriptorMappingSourceIndirectIndexEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDescriptorMappingSourceIndirectIndexEXT.BYTES;
            }

            @Override
            public VkDescriptorMappingSourceIndirectIndexEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDescriptorMappingSourceIndirectIndexEXT ret = new VkDescriptorMappingSourceIndirectIndexEXT(segment.asSlice(0, VkDescriptorMappingSourceIndirectIndexEXT.BYTES));
                segment = segment.asSlice(VkDescriptorMappingSourceIndirectIndexEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDescriptorMappingSourceIndirectIndexEXT allocate(Arena arena) {
        return new VkDescriptorMappingSourceIndirectIndexEXT(arena.allocate(LAYOUT));
    }

    public static VkDescriptorMappingSourceIndirectIndexEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkDescriptorMappingSourceIndirectIndexEXT.Ptr(segment);
    }

    public static VkDescriptorMappingSourceIndirectIndexEXT clone(Arena arena, VkDescriptorMappingSourceIndirectIndexEXT src) {
        VkDescriptorMappingSourceIndirectIndexEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned int heapOffset() {
        return segment.get(LAYOUT$heapOffset, OFFSET$heapOffset);
    }

    public VkDescriptorMappingSourceIndirectIndexEXT heapOffset(@Unsigned int value) {
        segment.set(LAYOUT$heapOffset, OFFSET$heapOffset, value);
        return this;
    }

    public @Unsigned int pushOffset() {
        return segment.get(LAYOUT$pushOffset, OFFSET$pushOffset);
    }

    public VkDescriptorMappingSourceIndirectIndexEXT pushOffset(@Unsigned int value) {
        segment.set(LAYOUT$pushOffset, OFFSET$pushOffset, value);
        return this;
    }

    public @Unsigned int addressOffset() {
        return segment.get(LAYOUT$addressOffset, OFFSET$addressOffset);
    }

    public VkDescriptorMappingSourceIndirectIndexEXT addressOffset(@Unsigned int value) {
        segment.set(LAYOUT$addressOffset, OFFSET$addressOffset, value);
        return this;
    }

    public @Unsigned int heapIndexStride() {
        return segment.get(LAYOUT$heapIndexStride, OFFSET$heapIndexStride);
    }

    public VkDescriptorMappingSourceIndirectIndexEXT heapIndexStride(@Unsigned int value) {
        segment.set(LAYOUT$heapIndexStride, OFFSET$heapIndexStride, value);
        return this;
    }

    public @Unsigned int heapArrayStride() {
        return segment.get(LAYOUT$heapArrayStride, OFFSET$heapArrayStride);
    }

    public VkDescriptorMappingSourceIndirectIndexEXT heapArrayStride(@Unsigned int value) {
        segment.set(LAYOUT$heapArrayStride, OFFSET$heapArrayStride, value);
        return this;
    }

    public VkDescriptorMappingSourceIndirectIndexEXT pEmbeddedSampler(@Nullable IVkSamplerCreateInfo value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pEmbeddedSamplerRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkSamplerCreateInfo.Ptr pEmbeddedSampler(int assumedCount) {
        MemorySegment s = pEmbeddedSamplerRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkSamplerCreateInfo.BYTES);
        return new VkSamplerCreateInfo.Ptr(s);
    }

    public @Nullable VkSamplerCreateInfo pEmbeddedSampler() {
        MemorySegment s = pEmbeddedSamplerRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkSamplerCreateInfo(s);
    }

    public @Pointer(target=VkSamplerCreateInfo.class) @NotNull MemorySegment pEmbeddedSamplerRaw() {
        return segment.get(LAYOUT$pEmbeddedSampler, OFFSET$pEmbeddedSampler);
    }

    public void pEmbeddedSamplerRaw(@Pointer(target=VkSamplerCreateInfo.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pEmbeddedSampler, OFFSET$pEmbeddedSampler, value);
    }

    public @NativeType("VkBool32") @Unsigned int useCombinedImageSamplerIndex() {
        return segment.get(LAYOUT$useCombinedImageSamplerIndex, OFFSET$useCombinedImageSamplerIndex);
    }

    public VkDescriptorMappingSourceIndirectIndexEXT useCombinedImageSamplerIndex(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$useCombinedImageSamplerIndex, OFFSET$useCombinedImageSamplerIndex, value);
        return this;
    }

    public @Unsigned int samplerHeapOffset() {
        return segment.get(LAYOUT$samplerHeapOffset, OFFSET$samplerHeapOffset);
    }

    public VkDescriptorMappingSourceIndirectIndexEXT samplerHeapOffset(@Unsigned int value) {
        segment.set(LAYOUT$samplerHeapOffset, OFFSET$samplerHeapOffset, value);
        return this;
    }

    public @Unsigned int samplerPushOffset() {
        return segment.get(LAYOUT$samplerPushOffset, OFFSET$samplerPushOffset);
    }

    public VkDescriptorMappingSourceIndirectIndexEXT samplerPushOffset(@Unsigned int value) {
        segment.set(LAYOUT$samplerPushOffset, OFFSET$samplerPushOffset, value);
        return this;
    }

    public @Unsigned int samplerAddressOffset() {
        return segment.get(LAYOUT$samplerAddressOffset, OFFSET$samplerAddressOffset);
    }

    public VkDescriptorMappingSourceIndirectIndexEXT samplerAddressOffset(@Unsigned int value) {
        segment.set(LAYOUT$samplerAddressOffset, OFFSET$samplerAddressOffset, value);
        return this;
    }

    public @Unsigned int samplerHeapIndexStride() {
        return segment.get(LAYOUT$samplerHeapIndexStride, OFFSET$samplerHeapIndexStride);
    }

    public VkDescriptorMappingSourceIndirectIndexEXT samplerHeapIndexStride(@Unsigned int value) {
        segment.set(LAYOUT$samplerHeapIndexStride, OFFSET$samplerHeapIndexStride, value);
        return this;
    }

    public @Unsigned int samplerHeapArrayStride() {
        return segment.get(LAYOUT$samplerHeapArrayStride, OFFSET$samplerHeapArrayStride);
    }

    public VkDescriptorMappingSourceIndirectIndexEXT samplerHeapArrayStride(@Unsigned int value) {
        segment.set(LAYOUT$samplerHeapArrayStride, OFFSET$samplerHeapArrayStride, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("heapOffset"),
        ValueLayout.JAVA_INT.withName("pushOffset"),
        ValueLayout.JAVA_INT.withName("addressOffset"),
        ValueLayout.JAVA_INT.withName("heapIndexStride"),
        ValueLayout.JAVA_INT.withName("heapArrayStride"),
        ValueLayout.ADDRESS.withTargetLayout(VkSamplerCreateInfo.LAYOUT).withName("pEmbeddedSampler"),
        ValueLayout.JAVA_INT.withName("useCombinedImageSamplerIndex"),
        ValueLayout.JAVA_INT.withName("samplerHeapOffset"),
        ValueLayout.JAVA_INT.withName("samplerPushOffset"),
        ValueLayout.JAVA_INT.withName("samplerAddressOffset"),
        ValueLayout.JAVA_INT.withName("samplerHeapIndexStride"),
        ValueLayout.JAVA_INT.withName("samplerHeapArrayStride")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$heapOffset = PathElement.groupElement("heapOffset");
    public static final PathElement PATH$pushOffset = PathElement.groupElement("pushOffset");
    public static final PathElement PATH$addressOffset = PathElement.groupElement("addressOffset");
    public static final PathElement PATH$heapIndexStride = PathElement.groupElement("heapIndexStride");
    public static final PathElement PATH$heapArrayStride = PathElement.groupElement("heapArrayStride");
    public static final PathElement PATH$pEmbeddedSampler = PathElement.groupElement("pEmbeddedSampler");
    public static final PathElement PATH$useCombinedImageSamplerIndex = PathElement.groupElement("useCombinedImageSamplerIndex");
    public static final PathElement PATH$samplerHeapOffset = PathElement.groupElement("samplerHeapOffset");
    public static final PathElement PATH$samplerPushOffset = PathElement.groupElement("samplerPushOffset");
    public static final PathElement PATH$samplerAddressOffset = PathElement.groupElement("samplerAddressOffset");
    public static final PathElement PATH$samplerHeapIndexStride = PathElement.groupElement("samplerHeapIndexStride");
    public static final PathElement PATH$samplerHeapArrayStride = PathElement.groupElement("samplerHeapArrayStride");

    public static final OfInt LAYOUT$heapOffset = (OfInt) LAYOUT.select(PATH$heapOffset);
    public static final OfInt LAYOUT$pushOffset = (OfInt) LAYOUT.select(PATH$pushOffset);
    public static final OfInt LAYOUT$addressOffset = (OfInt) LAYOUT.select(PATH$addressOffset);
    public static final OfInt LAYOUT$heapIndexStride = (OfInt) LAYOUT.select(PATH$heapIndexStride);
    public static final OfInt LAYOUT$heapArrayStride = (OfInt) LAYOUT.select(PATH$heapArrayStride);
    public static final AddressLayout LAYOUT$pEmbeddedSampler = (AddressLayout) LAYOUT.select(PATH$pEmbeddedSampler);
    public static final OfInt LAYOUT$useCombinedImageSamplerIndex = (OfInt) LAYOUT.select(PATH$useCombinedImageSamplerIndex);
    public static final OfInt LAYOUT$samplerHeapOffset = (OfInt) LAYOUT.select(PATH$samplerHeapOffset);
    public static final OfInt LAYOUT$samplerPushOffset = (OfInt) LAYOUT.select(PATH$samplerPushOffset);
    public static final OfInt LAYOUT$samplerAddressOffset = (OfInt) LAYOUT.select(PATH$samplerAddressOffset);
    public static final OfInt LAYOUT$samplerHeapIndexStride = (OfInt) LAYOUT.select(PATH$samplerHeapIndexStride);
    public static final OfInt LAYOUT$samplerHeapArrayStride = (OfInt) LAYOUT.select(PATH$samplerHeapArrayStride);

    public static final long SIZE$heapOffset = LAYOUT$heapOffset.byteSize();
    public static final long SIZE$pushOffset = LAYOUT$pushOffset.byteSize();
    public static final long SIZE$addressOffset = LAYOUT$addressOffset.byteSize();
    public static final long SIZE$heapIndexStride = LAYOUT$heapIndexStride.byteSize();
    public static final long SIZE$heapArrayStride = LAYOUT$heapArrayStride.byteSize();
    public static final long SIZE$pEmbeddedSampler = LAYOUT$pEmbeddedSampler.byteSize();
    public static final long SIZE$useCombinedImageSamplerIndex = LAYOUT$useCombinedImageSamplerIndex.byteSize();
    public static final long SIZE$samplerHeapOffset = LAYOUT$samplerHeapOffset.byteSize();
    public static final long SIZE$samplerPushOffset = LAYOUT$samplerPushOffset.byteSize();
    public static final long SIZE$samplerAddressOffset = LAYOUT$samplerAddressOffset.byteSize();
    public static final long SIZE$samplerHeapIndexStride = LAYOUT$samplerHeapIndexStride.byteSize();
    public static final long SIZE$samplerHeapArrayStride = LAYOUT$samplerHeapArrayStride.byteSize();

    public static final long OFFSET$heapOffset = LAYOUT.byteOffset(PATH$heapOffset);
    public static final long OFFSET$pushOffset = LAYOUT.byteOffset(PATH$pushOffset);
    public static final long OFFSET$addressOffset = LAYOUT.byteOffset(PATH$addressOffset);
    public static final long OFFSET$heapIndexStride = LAYOUT.byteOffset(PATH$heapIndexStride);
    public static final long OFFSET$heapArrayStride = LAYOUT.byteOffset(PATH$heapArrayStride);
    public static final long OFFSET$pEmbeddedSampler = LAYOUT.byteOffset(PATH$pEmbeddedSampler);
    public static final long OFFSET$useCombinedImageSamplerIndex = LAYOUT.byteOffset(PATH$useCombinedImageSamplerIndex);
    public static final long OFFSET$samplerHeapOffset = LAYOUT.byteOffset(PATH$samplerHeapOffset);
    public static final long OFFSET$samplerPushOffset = LAYOUT.byteOffset(PATH$samplerPushOffset);
    public static final long OFFSET$samplerAddressOffset = LAYOUT.byteOffset(PATH$samplerAddressOffset);
    public static final long OFFSET$samplerHeapIndexStride = LAYOUT.byteOffset(PATH$samplerHeapIndexStride);
    public static final long OFFSET$samplerHeapArrayStride = LAYOUT.byteOffset(PATH$samplerHeapArrayStride);
}
