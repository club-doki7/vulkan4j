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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageFormatProperties.html"><code>VkImageFormatProperties</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkImageFormatProperties {
///     VkExtent3D maxExtent; // @link substring="VkExtent3D" target="VkExtent3D" @link substring="maxExtent" target="#maxExtent"
///     uint32_t maxMipLevels; // @link substring="maxMipLevels" target="#maxMipLevels"
///     uint32_t maxArrayLayers; // @link substring="maxArrayLayers" target="#maxArrayLayers"
///     VkSampleCountFlags sampleCounts; // optional // @link substring="VkSampleCountFlags" target="VkSampleCountFlags" @link substring="sampleCounts" target="#sampleCounts"
///     VkDeviceSize maxResourceSize; // @link substring="maxResourceSize" target="#maxResourceSize"
/// } VkImageFormatProperties;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageFormatProperties.html"><code>VkImageFormatProperties</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkImageFormatProperties(@NotNull MemorySegment segment) implements IVkImageFormatProperties {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageFormatProperties.html"><code>VkImageFormatProperties</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkImageFormatProperties}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkImageFormatProperties to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkImageFormatProperties.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkImageFormatProperties, Iterable<VkImageFormatProperties> {
        public long size() {
            return segment.byteSize() / VkImageFormatProperties.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkImageFormatProperties at(long index) {
            return new VkImageFormatProperties(segment.asSlice(index * VkImageFormatProperties.BYTES, VkImageFormatProperties.BYTES));
        }

        public VkImageFormatProperties.Ptr at(long index, @NotNull Consumer<@NotNull VkImageFormatProperties> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkImageFormatProperties value) {
            MemorySegment s = segment.asSlice(index * VkImageFormatProperties.BYTES, VkImageFormatProperties.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkImageFormatProperties.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkImageFormatProperties.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkImageFormatProperties.BYTES,
                (end - start) * VkImageFormatProperties.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkImageFormatProperties.BYTES));
        }

        public VkImageFormatProperties[] toArray() {
            VkImageFormatProperties[] ret = new VkImageFormatProperties[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkImageFormatProperties> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkImageFormatProperties> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkImageFormatProperties.BYTES;
            }

            @Override
            public VkImageFormatProperties next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkImageFormatProperties ret = new VkImageFormatProperties(segment.asSlice(0, VkImageFormatProperties.BYTES));
                segment = segment.asSlice(VkImageFormatProperties.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkImageFormatProperties allocate(Arena arena) {
        return new VkImageFormatProperties(arena.allocate(LAYOUT));
    }

    public static VkImageFormatProperties.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkImageFormatProperties.Ptr(segment);
    }

    public static VkImageFormatProperties clone(Arena arena, VkImageFormatProperties src) {
        VkImageFormatProperties ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull VkExtent3D maxExtent() {
        return new VkExtent3D(segment.asSlice(OFFSET$maxExtent, LAYOUT$maxExtent));
    }

    public VkImageFormatProperties maxExtent(@NotNull VkExtent3D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$maxExtent, SIZE$maxExtent);
        return this;
    }

    public VkImageFormatProperties maxExtent(Consumer<@NotNull VkExtent3D> consumer) {
        consumer.accept(maxExtent());
        return this;
    }

    public @Unsigned int maxMipLevels() {
        return segment.get(LAYOUT$maxMipLevels, OFFSET$maxMipLevels);
    }

    public VkImageFormatProperties maxMipLevels(@Unsigned int value) {
        segment.set(LAYOUT$maxMipLevels, OFFSET$maxMipLevels, value);
        return this;
    }

    public @Unsigned int maxArrayLayers() {
        return segment.get(LAYOUT$maxArrayLayers, OFFSET$maxArrayLayers);
    }

    public VkImageFormatProperties maxArrayLayers(@Unsigned int value) {
        segment.set(LAYOUT$maxArrayLayers, OFFSET$maxArrayLayers, value);
        return this;
    }

    public @Bitmask(VkSampleCountFlags.class) int sampleCounts() {
        return segment.get(LAYOUT$sampleCounts, OFFSET$sampleCounts);
    }

    public VkImageFormatProperties sampleCounts(@Bitmask(VkSampleCountFlags.class) int value) {
        segment.set(LAYOUT$sampleCounts, OFFSET$sampleCounts, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long maxResourceSize() {
        return segment.get(LAYOUT$maxResourceSize, OFFSET$maxResourceSize);
    }

    public VkImageFormatProperties maxResourceSize(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$maxResourceSize, OFFSET$maxResourceSize, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        VkExtent3D.LAYOUT.withName("maxExtent"),
        ValueLayout.JAVA_INT.withName("maxMipLevels"),
        ValueLayout.JAVA_INT.withName("maxArrayLayers"),
        ValueLayout.JAVA_INT.withName("sampleCounts"),
        ValueLayout.JAVA_LONG.withName("maxResourceSize")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$maxExtent = PathElement.groupElement("maxExtent");
    public static final PathElement PATH$maxMipLevels = PathElement.groupElement("maxMipLevels");
    public static final PathElement PATH$maxArrayLayers = PathElement.groupElement("maxArrayLayers");
    public static final PathElement PATH$sampleCounts = PathElement.groupElement("sampleCounts");
    public static final PathElement PATH$maxResourceSize = PathElement.groupElement("maxResourceSize");

    public static final StructLayout LAYOUT$maxExtent = (StructLayout) LAYOUT.select(PATH$maxExtent);
    public static final OfInt LAYOUT$maxMipLevels = (OfInt) LAYOUT.select(PATH$maxMipLevels);
    public static final OfInt LAYOUT$maxArrayLayers = (OfInt) LAYOUT.select(PATH$maxArrayLayers);
    public static final OfInt LAYOUT$sampleCounts = (OfInt) LAYOUT.select(PATH$sampleCounts);
    public static final OfLong LAYOUT$maxResourceSize = (OfLong) LAYOUT.select(PATH$maxResourceSize);

    public static final long SIZE$maxExtent = LAYOUT$maxExtent.byteSize();
    public static final long SIZE$maxMipLevels = LAYOUT$maxMipLevels.byteSize();
    public static final long SIZE$maxArrayLayers = LAYOUT$maxArrayLayers.byteSize();
    public static final long SIZE$sampleCounts = LAYOUT$sampleCounts.byteSize();
    public static final long SIZE$maxResourceSize = LAYOUT$maxResourceSize.byteSize();

    public static final long OFFSET$maxExtent = LAYOUT.byteOffset(PATH$maxExtent);
    public static final long OFFSET$maxMipLevels = LAYOUT.byteOffset(PATH$maxMipLevels);
    public static final long OFFSET$maxArrayLayers = LAYOUT.byteOffset(PATH$maxArrayLayers);
    public static final long OFFSET$sampleCounts = LAYOUT.byteOffset(PATH$sampleCounts);
    public static final long OFFSET$maxResourceSize = LAYOUT.byteOffset(PATH$maxResourceSize);
}
