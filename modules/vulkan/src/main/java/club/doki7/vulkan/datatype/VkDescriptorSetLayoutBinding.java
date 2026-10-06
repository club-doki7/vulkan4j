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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDescriptorSetLayoutBinding.html"><code>VkDescriptorSetLayoutBinding</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDescriptorSetLayoutBinding {
///     uint32_t binding; // @link substring="binding" target="#binding"
///     VkDescriptorType descriptorType; // @link substring="VkDescriptorType" target="VkDescriptorType" @link substring="descriptorType" target="#descriptorType"
///     uint32_t descriptorCount; // optional // @link substring="descriptorCount" target="#descriptorCount"
///     VkShaderStageFlags stageFlags; // @link substring="VkShaderStageFlags" target="VkShaderStageFlags" @link substring="stageFlags" target="#stageFlags"
///     VkSampler const* pImmutableSamplers; // optional // @link substring="VkSampler" target="VkSampler" @link substring="pImmutableSamplers" target="#pImmutableSamplers"
/// } VkDescriptorSetLayoutBinding;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDescriptorSetLayoutBinding.html"><code>VkDescriptorSetLayoutBinding</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDescriptorSetLayoutBinding(@NotNull MemorySegment segment) implements IVkDescriptorSetLayoutBinding {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDescriptorSetLayoutBinding.html"><code>VkDescriptorSetLayoutBinding</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDescriptorSetLayoutBinding}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDescriptorSetLayoutBinding to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDescriptorSetLayoutBinding.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDescriptorSetLayoutBinding, Iterable<VkDescriptorSetLayoutBinding> {
        public long size() {
            return segment.byteSize() / VkDescriptorSetLayoutBinding.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDescriptorSetLayoutBinding at(long index) {
            return new VkDescriptorSetLayoutBinding(segment.asSlice(index * VkDescriptorSetLayoutBinding.BYTES, VkDescriptorSetLayoutBinding.BYTES));
        }

        public VkDescriptorSetLayoutBinding.Ptr at(long index, @NotNull Consumer<@NotNull VkDescriptorSetLayoutBinding> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDescriptorSetLayoutBinding value) {
            MemorySegment s = segment.asSlice(index * VkDescriptorSetLayoutBinding.BYTES, VkDescriptorSetLayoutBinding.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDescriptorSetLayoutBinding.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDescriptorSetLayoutBinding.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDescriptorSetLayoutBinding.BYTES,
                (end - start) * VkDescriptorSetLayoutBinding.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDescriptorSetLayoutBinding.BYTES));
        }

        public VkDescriptorSetLayoutBinding[] toArray() {
            VkDescriptorSetLayoutBinding[] ret = new VkDescriptorSetLayoutBinding[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDescriptorSetLayoutBinding> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDescriptorSetLayoutBinding> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDescriptorSetLayoutBinding.BYTES;
            }

            @Override
            public VkDescriptorSetLayoutBinding next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDescriptorSetLayoutBinding ret = new VkDescriptorSetLayoutBinding(segment.asSlice(0, VkDescriptorSetLayoutBinding.BYTES));
                segment = segment.asSlice(VkDescriptorSetLayoutBinding.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDescriptorSetLayoutBinding allocate(Arena arena) {
        return new VkDescriptorSetLayoutBinding(arena.allocate(LAYOUT));
    }

    public static VkDescriptorSetLayoutBinding.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkDescriptorSetLayoutBinding.Ptr(segment);
    }

    public static VkDescriptorSetLayoutBinding clone(Arena arena, VkDescriptorSetLayoutBinding src) {
        VkDescriptorSetLayoutBinding ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned int binding() {
        return segment.get(LAYOUT$binding, OFFSET$binding);
    }

    public VkDescriptorSetLayoutBinding binding(@Unsigned int value) {
        segment.set(LAYOUT$binding, OFFSET$binding, value);
        return this;
    }

    public @EnumType(VkDescriptorType.class) int descriptorType() {
        return segment.get(LAYOUT$descriptorType, OFFSET$descriptorType);
    }

    public VkDescriptorSetLayoutBinding descriptorType(@EnumType(VkDescriptorType.class) int value) {
        segment.set(LAYOUT$descriptorType, OFFSET$descriptorType, value);
        return this;
    }

    public @Unsigned int descriptorCount() {
        return segment.get(LAYOUT$descriptorCount, OFFSET$descriptorCount);
    }

    public VkDescriptorSetLayoutBinding descriptorCount(@Unsigned int value) {
        segment.set(LAYOUT$descriptorCount, OFFSET$descriptorCount, value);
        return this;
    }

    public @Bitmask(VkShaderStageFlags.class) int stageFlags() {
        return segment.get(LAYOUT$stageFlags, OFFSET$stageFlags);
    }

    public VkDescriptorSetLayoutBinding stageFlags(@Bitmask(VkShaderStageFlags.class) int value) {
        segment.set(LAYOUT$stageFlags, OFFSET$stageFlags, value);
        return this;
    }

    /// Note: the returned {@link VkSampler.Ptr} does not have correct {@link VkSampler.Ptr#size}
    /// property. It's up to user to track the size of the buffer, and use
    /// {@link VkSampler.Ptr#reinterpret} to set the size before actually reading from or writing to the
    /// buffer.
    public @Nullable VkSampler.Ptr pImmutableSamplers() {
        MemorySegment s = pImmutableSamplersRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkSampler.Ptr(s);
    }

    public VkDescriptorSetLayoutBinding pImmutableSamplers(@Nullable VkSampler.Ptr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pImmutableSamplersRaw(s);
        return this;
    }

    public @Pointer(target=VkSampler.class) @NotNull MemorySegment pImmutableSamplersRaw() {
        return segment.get(LAYOUT$pImmutableSamplers, OFFSET$pImmutableSamplers);
    }

    public void pImmutableSamplersRaw(@Pointer(target=VkSampler.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pImmutableSamplers, OFFSET$pImmutableSamplers, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("binding"),
        ValueLayout.JAVA_INT.withName("descriptorType"),
        ValueLayout.JAVA_INT.withName("descriptorCount"),
        ValueLayout.JAVA_INT.withName("stageFlags"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS).withName("pImmutableSamplers")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$binding = PathElement.groupElement("binding");
    public static final PathElement PATH$descriptorType = PathElement.groupElement("descriptorType");
    public static final PathElement PATH$descriptorCount = PathElement.groupElement("descriptorCount");
    public static final PathElement PATH$stageFlags = PathElement.groupElement("stageFlags");
    public static final PathElement PATH$pImmutableSamplers = PathElement.groupElement("pImmutableSamplers");

    public static final OfInt LAYOUT$binding = (OfInt) LAYOUT.select(PATH$binding);
    public static final OfInt LAYOUT$descriptorType = (OfInt) LAYOUT.select(PATH$descriptorType);
    public static final OfInt LAYOUT$descriptorCount = (OfInt) LAYOUT.select(PATH$descriptorCount);
    public static final OfInt LAYOUT$stageFlags = (OfInt) LAYOUT.select(PATH$stageFlags);
    public static final AddressLayout LAYOUT$pImmutableSamplers = (AddressLayout) LAYOUT.select(PATH$pImmutableSamplers);

    public static final long SIZE$binding = LAYOUT$binding.byteSize();
    public static final long SIZE$descriptorType = LAYOUT$descriptorType.byteSize();
    public static final long SIZE$descriptorCount = LAYOUT$descriptorCount.byteSize();
    public static final long SIZE$stageFlags = LAYOUT$stageFlags.byteSize();
    public static final long SIZE$pImmutableSamplers = LAYOUT$pImmutableSamplers.byteSize();

    public static final long OFFSET$binding = LAYOUT.byteOffset(PATH$binding);
    public static final long OFFSET$descriptorType = LAYOUT.byteOffset(PATH$descriptorType);
    public static final long OFFSET$descriptorCount = LAYOUT.byteOffset(PATH$descriptorCount);
    public static final long OFFSET$stageFlags = LAYOUT.byteOffset(PATH$stageFlags);
    public static final long OFFSET$pImmutableSamplers = LAYOUT.byteOffset(PATH$pImmutableSamplers);
}
