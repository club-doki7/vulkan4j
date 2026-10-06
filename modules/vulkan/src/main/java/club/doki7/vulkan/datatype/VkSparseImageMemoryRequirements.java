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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSparseImageMemoryRequirements.html"><code>VkSparseImageMemoryRequirements</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkSparseImageMemoryRequirements {
///     VkSparseImageFormatProperties formatProperties; // @link substring="VkSparseImageFormatProperties" target="VkSparseImageFormatProperties" @link substring="formatProperties" target="#formatProperties"
///     uint32_t imageMipTailFirstLod; // @link substring="imageMipTailFirstLod" target="#imageMipTailFirstLod"
///     VkDeviceSize imageMipTailSize; // @link substring="imageMipTailSize" target="#imageMipTailSize"
///     VkDeviceSize imageMipTailOffset; // @link substring="imageMipTailOffset" target="#imageMipTailOffset"
///     VkDeviceSize imageMipTailStride; // @link substring="imageMipTailStride" target="#imageMipTailStride"
/// } VkSparseImageMemoryRequirements;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSparseImageMemoryRequirements.html"><code>VkSparseImageMemoryRequirements</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkSparseImageMemoryRequirements(@NotNull MemorySegment segment) implements IVkSparseImageMemoryRequirements {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSparseImageMemoryRequirements.html"><code>VkSparseImageMemoryRequirements</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkSparseImageMemoryRequirements}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkSparseImageMemoryRequirements to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkSparseImageMemoryRequirements.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkSparseImageMemoryRequirements, Iterable<VkSparseImageMemoryRequirements> {
        public long size() {
            return segment.byteSize() / VkSparseImageMemoryRequirements.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkSparseImageMemoryRequirements at(long index) {
            return new VkSparseImageMemoryRequirements(segment.asSlice(index * VkSparseImageMemoryRequirements.BYTES, VkSparseImageMemoryRequirements.BYTES));
        }

        public VkSparseImageMemoryRequirements.Ptr at(long index, @NotNull Consumer<@NotNull VkSparseImageMemoryRequirements> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkSparseImageMemoryRequirements value) {
            MemorySegment s = segment.asSlice(index * VkSparseImageMemoryRequirements.BYTES, VkSparseImageMemoryRequirements.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkSparseImageMemoryRequirements.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkSparseImageMemoryRequirements.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkSparseImageMemoryRequirements.BYTES,
                (end - start) * VkSparseImageMemoryRequirements.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkSparseImageMemoryRequirements.BYTES));
        }

        public VkSparseImageMemoryRequirements[] toArray() {
            VkSparseImageMemoryRequirements[] ret = new VkSparseImageMemoryRequirements[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkSparseImageMemoryRequirements> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkSparseImageMemoryRequirements> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkSparseImageMemoryRequirements.BYTES;
            }

            @Override
            public VkSparseImageMemoryRequirements next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkSparseImageMemoryRequirements ret = new VkSparseImageMemoryRequirements(segment.asSlice(0, VkSparseImageMemoryRequirements.BYTES));
                segment = segment.asSlice(VkSparseImageMemoryRequirements.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkSparseImageMemoryRequirements allocate(Arena arena) {
        return new VkSparseImageMemoryRequirements(arena.allocate(LAYOUT));
    }

    public static VkSparseImageMemoryRequirements.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkSparseImageMemoryRequirements.Ptr(segment);
    }

    public static VkSparseImageMemoryRequirements clone(Arena arena, VkSparseImageMemoryRequirements src) {
        VkSparseImageMemoryRequirements ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull VkSparseImageFormatProperties formatProperties() {
        return new VkSparseImageFormatProperties(segment.asSlice(OFFSET$formatProperties, LAYOUT$formatProperties));
    }

    public VkSparseImageMemoryRequirements formatProperties(@NotNull VkSparseImageFormatProperties value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$formatProperties, SIZE$formatProperties);
        return this;
    }

    public VkSparseImageMemoryRequirements formatProperties(Consumer<@NotNull VkSparseImageFormatProperties> consumer) {
        consumer.accept(formatProperties());
        return this;
    }

    public @Unsigned int imageMipTailFirstLod() {
        return segment.get(LAYOUT$imageMipTailFirstLod, OFFSET$imageMipTailFirstLod);
    }

    public VkSparseImageMemoryRequirements imageMipTailFirstLod(@Unsigned int value) {
        segment.set(LAYOUT$imageMipTailFirstLod, OFFSET$imageMipTailFirstLod, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long imageMipTailSize() {
        return segment.get(LAYOUT$imageMipTailSize, OFFSET$imageMipTailSize);
    }

    public VkSparseImageMemoryRequirements imageMipTailSize(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$imageMipTailSize, OFFSET$imageMipTailSize, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long imageMipTailOffset() {
        return segment.get(LAYOUT$imageMipTailOffset, OFFSET$imageMipTailOffset);
    }

    public VkSparseImageMemoryRequirements imageMipTailOffset(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$imageMipTailOffset, OFFSET$imageMipTailOffset, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long imageMipTailStride() {
        return segment.get(LAYOUT$imageMipTailStride, OFFSET$imageMipTailStride);
    }

    public VkSparseImageMemoryRequirements imageMipTailStride(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$imageMipTailStride, OFFSET$imageMipTailStride, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        VkSparseImageFormatProperties.LAYOUT.withName("formatProperties"),
        ValueLayout.JAVA_INT.withName("imageMipTailFirstLod"),
        ValueLayout.JAVA_LONG.withName("imageMipTailSize"),
        ValueLayout.JAVA_LONG.withName("imageMipTailOffset"),
        ValueLayout.JAVA_LONG.withName("imageMipTailStride")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$formatProperties = PathElement.groupElement("formatProperties");
    public static final PathElement PATH$imageMipTailFirstLod = PathElement.groupElement("imageMipTailFirstLod");
    public static final PathElement PATH$imageMipTailSize = PathElement.groupElement("imageMipTailSize");
    public static final PathElement PATH$imageMipTailOffset = PathElement.groupElement("imageMipTailOffset");
    public static final PathElement PATH$imageMipTailStride = PathElement.groupElement("imageMipTailStride");

    public static final StructLayout LAYOUT$formatProperties = (StructLayout) LAYOUT.select(PATH$formatProperties);
    public static final OfInt LAYOUT$imageMipTailFirstLod = (OfInt) LAYOUT.select(PATH$imageMipTailFirstLod);
    public static final OfLong LAYOUT$imageMipTailSize = (OfLong) LAYOUT.select(PATH$imageMipTailSize);
    public static final OfLong LAYOUT$imageMipTailOffset = (OfLong) LAYOUT.select(PATH$imageMipTailOffset);
    public static final OfLong LAYOUT$imageMipTailStride = (OfLong) LAYOUT.select(PATH$imageMipTailStride);

    public static final long SIZE$formatProperties = LAYOUT$formatProperties.byteSize();
    public static final long SIZE$imageMipTailFirstLod = LAYOUT$imageMipTailFirstLod.byteSize();
    public static final long SIZE$imageMipTailSize = LAYOUT$imageMipTailSize.byteSize();
    public static final long SIZE$imageMipTailOffset = LAYOUT$imageMipTailOffset.byteSize();
    public static final long SIZE$imageMipTailStride = LAYOUT$imageMipTailStride.byteSize();

    public static final long OFFSET$formatProperties = LAYOUT.byteOffset(PATH$formatProperties);
    public static final long OFFSET$imageMipTailFirstLod = LAYOUT.byteOffset(PATH$imageMipTailFirstLod);
    public static final long OFFSET$imageMipTailSize = LAYOUT.byteOffset(PATH$imageMipTailSize);
    public static final long OFFSET$imageMipTailOffset = LAYOUT.byteOffset(PATH$imageMipTailOffset);
    public static final long OFFSET$imageMipTailStride = LAYOUT.byteOffset(PATH$imageMipTailStride);
}
