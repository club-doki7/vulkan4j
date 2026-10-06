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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPresentRegionKHR.html"><code>VkPresentRegionKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPresentRegionKHR {
///     uint32_t rectangleCount; // optional // @link substring="rectangleCount" target="#rectangleCount"
///     VkRectLayerKHR const* pRectangles; // optional // @link substring="VkRectLayerKHR" target="VkRectLayerKHR" @link substring="pRectangles" target="#pRectangles"
/// } VkPresentRegionKHR;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPresentRegionKHR.html"><code>VkPresentRegionKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPresentRegionKHR(@NotNull MemorySegment segment) implements IVkPresentRegionKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPresentRegionKHR.html"><code>VkPresentRegionKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPresentRegionKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPresentRegionKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPresentRegionKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPresentRegionKHR, Iterable<VkPresentRegionKHR> {
        public long size() {
            return segment.byteSize() / VkPresentRegionKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPresentRegionKHR at(long index) {
            return new VkPresentRegionKHR(segment.asSlice(index * VkPresentRegionKHR.BYTES, VkPresentRegionKHR.BYTES));
        }

        public VkPresentRegionKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkPresentRegionKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPresentRegionKHR value) {
            MemorySegment s = segment.asSlice(index * VkPresentRegionKHR.BYTES, VkPresentRegionKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPresentRegionKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPresentRegionKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPresentRegionKHR.BYTES,
                (end - start) * VkPresentRegionKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPresentRegionKHR.BYTES));
        }

        public VkPresentRegionKHR[] toArray() {
            VkPresentRegionKHR[] ret = new VkPresentRegionKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPresentRegionKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPresentRegionKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPresentRegionKHR.BYTES;
            }

            @Override
            public VkPresentRegionKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPresentRegionKHR ret = new VkPresentRegionKHR(segment.asSlice(0, VkPresentRegionKHR.BYTES));
                segment = segment.asSlice(VkPresentRegionKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPresentRegionKHR allocate(Arena arena) {
        return new VkPresentRegionKHR(arena.allocate(LAYOUT));
    }

    public static VkPresentRegionKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkPresentRegionKHR.Ptr(segment);
    }

    public static VkPresentRegionKHR clone(Arena arena, VkPresentRegionKHR src) {
        VkPresentRegionKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned int rectangleCount() {
        return segment.get(LAYOUT$rectangleCount, OFFSET$rectangleCount);
    }

    public VkPresentRegionKHR rectangleCount(@Unsigned int value) {
        segment.set(LAYOUT$rectangleCount, OFFSET$rectangleCount, value);
        return this;
    }

    public VkPresentRegionKHR pRectangles(@Nullable IVkRectLayerKHR value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pRectanglesRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkRectLayerKHR.Ptr pRectangles(int assumedCount) {
        MemorySegment s = pRectanglesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkRectLayerKHR.BYTES);
        return new VkRectLayerKHR.Ptr(s);
    }

    public @Nullable VkRectLayerKHR pRectangles() {
        MemorySegment s = pRectanglesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkRectLayerKHR(s);
    }

    public @Pointer(target=VkRectLayerKHR.class) @NotNull MemorySegment pRectanglesRaw() {
        return segment.get(LAYOUT$pRectangles, OFFSET$pRectangles);
    }

    public void pRectanglesRaw(@Pointer(target=VkRectLayerKHR.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pRectangles, OFFSET$pRectangles, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("rectangleCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkRectLayerKHR.LAYOUT).withName("pRectangles")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$rectangleCount = PathElement.groupElement("rectangleCount");
    public static final PathElement PATH$pRectangles = PathElement.groupElement("pRectangles");

    public static final OfInt LAYOUT$rectangleCount = (OfInt) LAYOUT.select(PATH$rectangleCount);
    public static final AddressLayout LAYOUT$pRectangles = (AddressLayout) LAYOUT.select(PATH$pRectangles);

    public static final long SIZE$rectangleCount = LAYOUT$rectangleCount.byteSize();
    public static final long SIZE$pRectangles = LAYOUT$pRectangles.byteSize();

    public static final long OFFSET$rectangleCount = LAYOUT.byteOffset(PATH$rectangleCount);
    public static final long OFFSET$pRectangles = LAYOUT.byteOffset(PATH$pRectangles);
}
