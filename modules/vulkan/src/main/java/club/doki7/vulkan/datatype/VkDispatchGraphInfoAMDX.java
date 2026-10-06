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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDispatchGraphInfoAMDX.html"><code>VkDispatchGraphInfoAMDX</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDispatchGraphInfoAMDX {
///     uint32_t nodeIndex; // @link substring="nodeIndex" target="#nodeIndex"
///     uint32_t payloadCount; // optional // @link substring="payloadCount" target="#payloadCount"
///     VkDeviceOrHostAddressConstAMDX payloads; // @link substring="VkDeviceOrHostAddressConstAMDX" target="VkDeviceOrHostAddressConstAMDX" @link substring="payloads" target="#payloads"
///     uint64_t payloadStride; // @link substring="payloadStride" target="#payloadStride"
/// } VkDispatchGraphInfoAMDX;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDispatchGraphInfoAMDX.html"><code>VkDispatchGraphInfoAMDX</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDispatchGraphInfoAMDX(@NotNull MemorySegment segment) implements IVkDispatchGraphInfoAMDX {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDispatchGraphInfoAMDX.html"><code>VkDispatchGraphInfoAMDX</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDispatchGraphInfoAMDX}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDispatchGraphInfoAMDX to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDispatchGraphInfoAMDX.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDispatchGraphInfoAMDX, Iterable<VkDispatchGraphInfoAMDX> {
        public long size() {
            return segment.byteSize() / VkDispatchGraphInfoAMDX.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDispatchGraphInfoAMDX at(long index) {
            return new VkDispatchGraphInfoAMDX(segment.asSlice(index * VkDispatchGraphInfoAMDX.BYTES, VkDispatchGraphInfoAMDX.BYTES));
        }

        public VkDispatchGraphInfoAMDX.Ptr at(long index, @NotNull Consumer<@NotNull VkDispatchGraphInfoAMDX> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDispatchGraphInfoAMDX value) {
            MemorySegment s = segment.asSlice(index * VkDispatchGraphInfoAMDX.BYTES, VkDispatchGraphInfoAMDX.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDispatchGraphInfoAMDX.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDispatchGraphInfoAMDX.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDispatchGraphInfoAMDX.BYTES,
                (end - start) * VkDispatchGraphInfoAMDX.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDispatchGraphInfoAMDX.BYTES));
        }

        public VkDispatchGraphInfoAMDX[] toArray() {
            VkDispatchGraphInfoAMDX[] ret = new VkDispatchGraphInfoAMDX[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDispatchGraphInfoAMDX> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDispatchGraphInfoAMDX> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDispatchGraphInfoAMDX.BYTES;
            }

            @Override
            public VkDispatchGraphInfoAMDX next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDispatchGraphInfoAMDX ret = new VkDispatchGraphInfoAMDX(segment.asSlice(0, VkDispatchGraphInfoAMDX.BYTES));
                segment = segment.asSlice(VkDispatchGraphInfoAMDX.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDispatchGraphInfoAMDX allocate(Arena arena) {
        return new VkDispatchGraphInfoAMDX(arena.allocate(LAYOUT));
    }

    public static VkDispatchGraphInfoAMDX.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkDispatchGraphInfoAMDX.Ptr(segment);
    }

    public static VkDispatchGraphInfoAMDX clone(Arena arena, VkDispatchGraphInfoAMDX src) {
        VkDispatchGraphInfoAMDX ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned int nodeIndex() {
        return segment.get(LAYOUT$nodeIndex, OFFSET$nodeIndex);
    }

    public VkDispatchGraphInfoAMDX nodeIndex(@Unsigned int value) {
        segment.set(LAYOUT$nodeIndex, OFFSET$nodeIndex, value);
        return this;
    }

    public @Unsigned int payloadCount() {
        return segment.get(LAYOUT$payloadCount, OFFSET$payloadCount);
    }

    public VkDispatchGraphInfoAMDX payloadCount(@Unsigned int value) {
        segment.set(LAYOUT$payloadCount, OFFSET$payloadCount, value);
        return this;
    }

    public @NotNull VkDeviceOrHostAddressConstAMDX payloads() {
        return new VkDeviceOrHostAddressConstAMDX(segment.asSlice(OFFSET$payloads, LAYOUT$payloads));
    }

    public VkDispatchGraphInfoAMDX payloads(@NotNull VkDeviceOrHostAddressConstAMDX value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$payloads, SIZE$payloads);
        return this;
    }

    public VkDispatchGraphInfoAMDX payloads(Consumer<@NotNull VkDeviceOrHostAddressConstAMDX> consumer) {
        consumer.accept(payloads());
        return this;
    }

    public @Unsigned long payloadStride() {
        return segment.get(LAYOUT$payloadStride, OFFSET$payloadStride);
    }

    public VkDispatchGraphInfoAMDX payloadStride(@Unsigned long value) {
        segment.set(LAYOUT$payloadStride, OFFSET$payloadStride, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("nodeIndex"),
        ValueLayout.JAVA_INT.withName("payloadCount"),
        VkDeviceOrHostAddressConstAMDX.LAYOUT.withName("payloads"),
        ValueLayout.JAVA_LONG.withName("payloadStride")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$nodeIndex = PathElement.groupElement("nodeIndex");
    public static final PathElement PATH$payloadCount = PathElement.groupElement("payloadCount");
    public static final PathElement PATH$payloads = PathElement.groupElement("payloads");
    public static final PathElement PATH$payloadStride = PathElement.groupElement("payloadStride");

    public static final OfInt LAYOUT$nodeIndex = (OfInt) LAYOUT.select(PATH$nodeIndex);
    public static final OfInt LAYOUT$payloadCount = (OfInt) LAYOUT.select(PATH$payloadCount);
    public static final UnionLayout LAYOUT$payloads = (UnionLayout) LAYOUT.select(PATH$payloads);
    public static final OfLong LAYOUT$payloadStride = (OfLong) LAYOUT.select(PATH$payloadStride);

    public static final long SIZE$nodeIndex = LAYOUT$nodeIndex.byteSize();
    public static final long SIZE$payloadCount = LAYOUT$payloadCount.byteSize();
    public static final long SIZE$payloads = LAYOUT$payloads.byteSize();
    public static final long SIZE$payloadStride = LAYOUT$payloadStride.byteSize();

    public static final long OFFSET$nodeIndex = LAYOUT.byteOffset(PATH$nodeIndex);
    public static final long OFFSET$payloadCount = LAYOUT.byteOffset(PATH$payloadCount);
    public static final long OFFSET$payloads = LAYOUT.byteOffset(PATH$payloads);
    public static final long OFFSET$payloadStride = LAYOUT.byteOffset(PATH$payloadStride);
}
