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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkQueueFamilyProperties.html"><code>VkQueueFamilyProperties</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkQueueFamilyProperties {
///     VkQueueFlags queueFlags; // optional // @link substring="VkQueueFlags" target="VkQueueFlags" @link substring="queueFlags" target="#queueFlags"
///     uint32_t queueCount; // @link substring="queueCount" target="#queueCount"
///     uint32_t timestampValidBits; // @link substring="timestampValidBits" target="#timestampValidBits"
///     VkExtent3D minImageTransferGranularity; // @link substring="VkExtent3D" target="VkExtent3D" @link substring="minImageTransferGranularity" target="#minImageTransferGranularity"
/// } VkQueueFamilyProperties;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkQueueFamilyProperties.html"><code>VkQueueFamilyProperties</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkQueueFamilyProperties(@NotNull MemorySegment segment) implements IVkQueueFamilyProperties {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkQueueFamilyProperties.html"><code>VkQueueFamilyProperties</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkQueueFamilyProperties}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkQueueFamilyProperties to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkQueueFamilyProperties.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkQueueFamilyProperties, Iterable<VkQueueFamilyProperties> {
        public long size() {
            return segment.byteSize() / VkQueueFamilyProperties.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkQueueFamilyProperties at(long index) {
            return new VkQueueFamilyProperties(segment.asSlice(index * VkQueueFamilyProperties.BYTES, VkQueueFamilyProperties.BYTES));
        }

        public VkQueueFamilyProperties.Ptr at(long index, @NotNull Consumer<@NotNull VkQueueFamilyProperties> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkQueueFamilyProperties value) {
            MemorySegment s = segment.asSlice(index * VkQueueFamilyProperties.BYTES, VkQueueFamilyProperties.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkQueueFamilyProperties.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkQueueFamilyProperties.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkQueueFamilyProperties.BYTES,
                (end - start) * VkQueueFamilyProperties.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkQueueFamilyProperties.BYTES));
        }

        public VkQueueFamilyProperties[] toArray() {
            VkQueueFamilyProperties[] ret = new VkQueueFamilyProperties[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkQueueFamilyProperties> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkQueueFamilyProperties> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkQueueFamilyProperties.BYTES;
            }

            @Override
            public VkQueueFamilyProperties next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkQueueFamilyProperties ret = new VkQueueFamilyProperties(segment.asSlice(0, VkQueueFamilyProperties.BYTES));
                segment = segment.asSlice(VkQueueFamilyProperties.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkQueueFamilyProperties allocate(Arena arena) {
        return new VkQueueFamilyProperties(arena.allocate(LAYOUT));
    }

    public static VkQueueFamilyProperties.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkQueueFamilyProperties.Ptr(segment);
    }

    public static VkQueueFamilyProperties clone(Arena arena, VkQueueFamilyProperties src) {
        VkQueueFamilyProperties ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Bitmask(VkQueueFlags.class) int queueFlags() {
        return segment.get(LAYOUT$queueFlags, OFFSET$queueFlags);
    }

    public VkQueueFamilyProperties queueFlags(@Bitmask(VkQueueFlags.class) int value) {
        segment.set(LAYOUT$queueFlags, OFFSET$queueFlags, value);
        return this;
    }

    public @Unsigned int queueCount() {
        return segment.get(LAYOUT$queueCount, OFFSET$queueCount);
    }

    public VkQueueFamilyProperties queueCount(@Unsigned int value) {
        segment.set(LAYOUT$queueCount, OFFSET$queueCount, value);
        return this;
    }

    public @Unsigned int timestampValidBits() {
        return segment.get(LAYOUT$timestampValidBits, OFFSET$timestampValidBits);
    }

    public VkQueueFamilyProperties timestampValidBits(@Unsigned int value) {
        segment.set(LAYOUT$timestampValidBits, OFFSET$timestampValidBits, value);
        return this;
    }

    public @NotNull VkExtent3D minImageTransferGranularity() {
        return new VkExtent3D(segment.asSlice(OFFSET$minImageTransferGranularity, LAYOUT$minImageTransferGranularity));
    }

    public VkQueueFamilyProperties minImageTransferGranularity(@NotNull VkExtent3D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$minImageTransferGranularity, SIZE$minImageTransferGranularity);
        return this;
    }

    public VkQueueFamilyProperties minImageTransferGranularity(Consumer<@NotNull VkExtent3D> consumer) {
        consumer.accept(minImageTransferGranularity());
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("queueFlags"),
        ValueLayout.JAVA_INT.withName("queueCount"),
        ValueLayout.JAVA_INT.withName("timestampValidBits"),
        VkExtent3D.LAYOUT.withName("minImageTransferGranularity")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$queueFlags = PathElement.groupElement("queueFlags");
    public static final PathElement PATH$queueCount = PathElement.groupElement("queueCount");
    public static final PathElement PATH$timestampValidBits = PathElement.groupElement("timestampValidBits");
    public static final PathElement PATH$minImageTransferGranularity = PathElement.groupElement("minImageTransferGranularity");

    public static final OfInt LAYOUT$queueFlags = (OfInt) LAYOUT.select(PATH$queueFlags);
    public static final OfInt LAYOUT$queueCount = (OfInt) LAYOUT.select(PATH$queueCount);
    public static final OfInt LAYOUT$timestampValidBits = (OfInt) LAYOUT.select(PATH$timestampValidBits);
    public static final StructLayout LAYOUT$minImageTransferGranularity = (StructLayout) LAYOUT.select(PATH$minImageTransferGranularity);

    public static final long SIZE$queueFlags = LAYOUT$queueFlags.byteSize();
    public static final long SIZE$queueCount = LAYOUT$queueCount.byteSize();
    public static final long SIZE$timestampValidBits = LAYOUT$timestampValidBits.byteSize();
    public static final long SIZE$minImageTransferGranularity = LAYOUT$minImageTransferGranularity.byteSize();

    public static final long OFFSET$queueFlags = LAYOUT.byteOffset(PATH$queueFlags);
    public static final long OFFSET$queueCount = LAYOUT.byteOffset(PATH$queueCount);
    public static final long OFFSET$timestampValidBits = LAYOUT.byteOffset(PATH$timestampValidBits);
    public static final long OFFSET$minImageTransferGranularity = LAYOUT.byteOffset(PATH$minImageTransferGranularity);
}
