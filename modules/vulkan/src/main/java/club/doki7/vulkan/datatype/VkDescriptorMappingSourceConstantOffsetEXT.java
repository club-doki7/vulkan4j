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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDescriptorMappingSourceConstantOffsetEXT.html"><code>VkDescriptorMappingSourceConstantOffsetEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDescriptorMappingSourceConstantOffsetEXT {
///     uint32_t heapOffset; // @link substring="heapOffset" target="#heapOffset"
///     uint32_t heapArrayStride; // @link substring="heapArrayStride" target="#heapArrayStride"
///     VkSamplerCreateInfo const* pEmbeddedSampler; // optional // @link substring="VkSamplerCreateInfo" target="VkSamplerCreateInfo" @link substring="pEmbeddedSampler" target="#pEmbeddedSampler"
///     uint32_t samplerHeapOffset; // @link substring="samplerHeapOffset" target="#samplerHeapOffset"
///     uint32_t samplerHeapArrayStride; // @link substring="samplerHeapArrayStride" target="#samplerHeapArrayStride"
/// } VkDescriptorMappingSourceConstantOffsetEXT;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDescriptorMappingSourceConstantOffsetEXT.html"><code>VkDescriptorMappingSourceConstantOffsetEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDescriptorMappingSourceConstantOffsetEXT(@NotNull MemorySegment segment) implements IVkDescriptorMappingSourceConstantOffsetEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDescriptorMappingSourceConstantOffsetEXT.html"><code>VkDescriptorMappingSourceConstantOffsetEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDescriptorMappingSourceConstantOffsetEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDescriptorMappingSourceConstantOffsetEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDescriptorMappingSourceConstantOffsetEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDescriptorMappingSourceConstantOffsetEXT, Iterable<VkDescriptorMappingSourceConstantOffsetEXT> {
        public long size() {
            return segment.byteSize() / VkDescriptorMappingSourceConstantOffsetEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDescriptorMappingSourceConstantOffsetEXT at(long index) {
            return new VkDescriptorMappingSourceConstantOffsetEXT(segment.asSlice(index * VkDescriptorMappingSourceConstantOffsetEXT.BYTES, VkDescriptorMappingSourceConstantOffsetEXT.BYTES));
        }

        public VkDescriptorMappingSourceConstantOffsetEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkDescriptorMappingSourceConstantOffsetEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDescriptorMappingSourceConstantOffsetEXT value) {
            MemorySegment s = segment.asSlice(index * VkDescriptorMappingSourceConstantOffsetEXT.BYTES, VkDescriptorMappingSourceConstantOffsetEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDescriptorMappingSourceConstantOffsetEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDescriptorMappingSourceConstantOffsetEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDescriptorMappingSourceConstantOffsetEXT.BYTES,
                (end - start) * VkDescriptorMappingSourceConstantOffsetEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDescriptorMappingSourceConstantOffsetEXT.BYTES));
        }

        public VkDescriptorMappingSourceConstantOffsetEXT[] toArray() {
            VkDescriptorMappingSourceConstantOffsetEXT[] ret = new VkDescriptorMappingSourceConstantOffsetEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDescriptorMappingSourceConstantOffsetEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDescriptorMappingSourceConstantOffsetEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDescriptorMappingSourceConstantOffsetEXT.BYTES;
            }

            @Override
            public VkDescriptorMappingSourceConstantOffsetEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDescriptorMappingSourceConstantOffsetEXT ret = new VkDescriptorMappingSourceConstantOffsetEXT(segment.asSlice(0, VkDescriptorMappingSourceConstantOffsetEXT.BYTES));
                segment = segment.asSlice(VkDescriptorMappingSourceConstantOffsetEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDescriptorMappingSourceConstantOffsetEXT allocate(Arena arena) {
        return new VkDescriptorMappingSourceConstantOffsetEXT(arena.allocate(LAYOUT));
    }

    public static VkDescriptorMappingSourceConstantOffsetEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkDescriptorMappingSourceConstantOffsetEXT.Ptr(segment);
    }

    public static VkDescriptorMappingSourceConstantOffsetEXT clone(Arena arena, VkDescriptorMappingSourceConstantOffsetEXT src) {
        VkDescriptorMappingSourceConstantOffsetEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned int heapOffset() {
        return segment.get(LAYOUT$heapOffset, OFFSET$heapOffset);
    }

    public VkDescriptorMappingSourceConstantOffsetEXT heapOffset(@Unsigned int value) {
        segment.set(LAYOUT$heapOffset, OFFSET$heapOffset, value);
        return this;
    }

    public @Unsigned int heapArrayStride() {
        return segment.get(LAYOUT$heapArrayStride, OFFSET$heapArrayStride);
    }

    public VkDescriptorMappingSourceConstantOffsetEXT heapArrayStride(@Unsigned int value) {
        segment.set(LAYOUT$heapArrayStride, OFFSET$heapArrayStride, value);
        return this;
    }

    public VkDescriptorMappingSourceConstantOffsetEXT pEmbeddedSampler(@Nullable IVkSamplerCreateInfo value) {
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

    public @Unsigned int samplerHeapOffset() {
        return segment.get(LAYOUT$samplerHeapOffset, OFFSET$samplerHeapOffset);
    }

    public VkDescriptorMappingSourceConstantOffsetEXT samplerHeapOffset(@Unsigned int value) {
        segment.set(LAYOUT$samplerHeapOffset, OFFSET$samplerHeapOffset, value);
        return this;
    }

    public @Unsigned int samplerHeapArrayStride() {
        return segment.get(LAYOUT$samplerHeapArrayStride, OFFSET$samplerHeapArrayStride);
    }

    public VkDescriptorMappingSourceConstantOffsetEXT samplerHeapArrayStride(@Unsigned int value) {
        segment.set(LAYOUT$samplerHeapArrayStride, OFFSET$samplerHeapArrayStride, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("heapOffset"),
        ValueLayout.JAVA_INT.withName("heapArrayStride"),
        ValueLayout.ADDRESS.withTargetLayout(VkSamplerCreateInfo.LAYOUT).withName("pEmbeddedSampler"),
        ValueLayout.JAVA_INT.withName("samplerHeapOffset"),
        ValueLayout.JAVA_INT.withName("samplerHeapArrayStride")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$heapOffset = PathElement.groupElement("heapOffset");
    public static final PathElement PATH$heapArrayStride = PathElement.groupElement("heapArrayStride");
    public static final PathElement PATH$pEmbeddedSampler = PathElement.groupElement("pEmbeddedSampler");
    public static final PathElement PATH$samplerHeapOffset = PathElement.groupElement("samplerHeapOffset");
    public static final PathElement PATH$samplerHeapArrayStride = PathElement.groupElement("samplerHeapArrayStride");

    public static final OfInt LAYOUT$heapOffset = (OfInt) LAYOUT.select(PATH$heapOffset);
    public static final OfInt LAYOUT$heapArrayStride = (OfInt) LAYOUT.select(PATH$heapArrayStride);
    public static final AddressLayout LAYOUT$pEmbeddedSampler = (AddressLayout) LAYOUT.select(PATH$pEmbeddedSampler);
    public static final OfInt LAYOUT$samplerHeapOffset = (OfInt) LAYOUT.select(PATH$samplerHeapOffset);
    public static final OfInt LAYOUT$samplerHeapArrayStride = (OfInt) LAYOUT.select(PATH$samplerHeapArrayStride);

    public static final long SIZE$heapOffset = LAYOUT$heapOffset.byteSize();
    public static final long SIZE$heapArrayStride = LAYOUT$heapArrayStride.byteSize();
    public static final long SIZE$pEmbeddedSampler = LAYOUT$pEmbeddedSampler.byteSize();
    public static final long SIZE$samplerHeapOffset = LAYOUT$samplerHeapOffset.byteSize();
    public static final long SIZE$samplerHeapArrayStride = LAYOUT$samplerHeapArrayStride.byteSize();

    public static final long OFFSET$heapOffset = LAYOUT.byteOffset(PATH$heapOffset);
    public static final long OFFSET$heapArrayStride = LAYOUT.byteOffset(PATH$heapArrayStride);
    public static final long OFFSET$pEmbeddedSampler = LAYOUT.byteOffset(PATH$pEmbeddedSampler);
    public static final long OFFSET$samplerHeapOffset = LAYOUT.byteOffset(PATH$samplerHeapOffset);
    public static final long OFFSET$samplerHeapArrayStride = LAYOUT.byteOffset(PATH$samplerHeapArrayStride);
}
