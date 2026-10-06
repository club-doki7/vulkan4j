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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAabbPositionsKHR.html"><code>VkAabbPositionsKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkAabbPositionsKHR {
///     float minX; // @link substring="minX" target="#minX"
///     float minY; // @link substring="minY" target="#minY"
///     float minZ; // @link substring="minZ" target="#minZ"
///     float maxX; // @link substring="maxX" target="#maxX"
///     float maxY; // @link substring="maxY" target="#maxY"
///     float maxZ; // @link substring="maxZ" target="#maxZ"
/// } VkAabbPositionsKHR;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAabbPositionsKHR.html"><code>VkAabbPositionsKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkAabbPositionsKHR(@NotNull MemorySegment segment) implements IVkAabbPositionsKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAabbPositionsKHR.html"><code>VkAabbPositionsKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkAabbPositionsKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkAabbPositionsKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkAabbPositionsKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkAabbPositionsKHR, Iterable<VkAabbPositionsKHR> {
        public long size() {
            return segment.byteSize() / VkAabbPositionsKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkAabbPositionsKHR at(long index) {
            return new VkAabbPositionsKHR(segment.asSlice(index * VkAabbPositionsKHR.BYTES, VkAabbPositionsKHR.BYTES));
        }

        public VkAabbPositionsKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkAabbPositionsKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkAabbPositionsKHR value) {
            MemorySegment s = segment.asSlice(index * VkAabbPositionsKHR.BYTES, VkAabbPositionsKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkAabbPositionsKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkAabbPositionsKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkAabbPositionsKHR.BYTES,
                (end - start) * VkAabbPositionsKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkAabbPositionsKHR.BYTES));
        }

        public VkAabbPositionsKHR[] toArray() {
            VkAabbPositionsKHR[] ret = new VkAabbPositionsKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkAabbPositionsKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkAabbPositionsKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkAabbPositionsKHR.BYTES;
            }

            @Override
            public VkAabbPositionsKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkAabbPositionsKHR ret = new VkAabbPositionsKHR(segment.asSlice(0, VkAabbPositionsKHR.BYTES));
                segment = segment.asSlice(VkAabbPositionsKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkAabbPositionsKHR allocate(Arena arena) {
        return new VkAabbPositionsKHR(arena.allocate(LAYOUT));
    }

    public static VkAabbPositionsKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkAabbPositionsKHR.Ptr(segment);
    }

    public static VkAabbPositionsKHR clone(Arena arena, VkAabbPositionsKHR src) {
        VkAabbPositionsKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public float minX() {
        return segment.get(LAYOUT$minX, OFFSET$minX);
    }

    public VkAabbPositionsKHR minX(float value) {
        segment.set(LAYOUT$minX, OFFSET$minX, value);
        return this;
    }

    public float minY() {
        return segment.get(LAYOUT$minY, OFFSET$minY);
    }

    public VkAabbPositionsKHR minY(float value) {
        segment.set(LAYOUT$minY, OFFSET$minY, value);
        return this;
    }

    public float minZ() {
        return segment.get(LAYOUT$minZ, OFFSET$minZ);
    }

    public VkAabbPositionsKHR minZ(float value) {
        segment.set(LAYOUT$minZ, OFFSET$minZ, value);
        return this;
    }

    public float maxX() {
        return segment.get(LAYOUT$maxX, OFFSET$maxX);
    }

    public VkAabbPositionsKHR maxX(float value) {
        segment.set(LAYOUT$maxX, OFFSET$maxX, value);
        return this;
    }

    public float maxY() {
        return segment.get(LAYOUT$maxY, OFFSET$maxY);
    }

    public VkAabbPositionsKHR maxY(float value) {
        segment.set(LAYOUT$maxY, OFFSET$maxY, value);
        return this;
    }

    public float maxZ() {
        return segment.get(LAYOUT$maxZ, OFFSET$maxZ);
    }

    public VkAabbPositionsKHR maxZ(float value) {
        segment.set(LAYOUT$maxZ, OFFSET$maxZ, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_FLOAT.withName("minX"),
        ValueLayout.JAVA_FLOAT.withName("minY"),
        ValueLayout.JAVA_FLOAT.withName("minZ"),
        ValueLayout.JAVA_FLOAT.withName("maxX"),
        ValueLayout.JAVA_FLOAT.withName("maxY"),
        ValueLayout.JAVA_FLOAT.withName("maxZ")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$minX = PathElement.groupElement("minX");
    public static final PathElement PATH$minY = PathElement.groupElement("minY");
    public static final PathElement PATH$minZ = PathElement.groupElement("minZ");
    public static final PathElement PATH$maxX = PathElement.groupElement("maxX");
    public static final PathElement PATH$maxY = PathElement.groupElement("maxY");
    public static final PathElement PATH$maxZ = PathElement.groupElement("maxZ");

    public static final OfFloat LAYOUT$minX = (OfFloat) LAYOUT.select(PATH$minX);
    public static final OfFloat LAYOUT$minY = (OfFloat) LAYOUT.select(PATH$minY);
    public static final OfFloat LAYOUT$minZ = (OfFloat) LAYOUT.select(PATH$minZ);
    public static final OfFloat LAYOUT$maxX = (OfFloat) LAYOUT.select(PATH$maxX);
    public static final OfFloat LAYOUT$maxY = (OfFloat) LAYOUT.select(PATH$maxY);
    public static final OfFloat LAYOUT$maxZ = (OfFloat) LAYOUT.select(PATH$maxZ);

    public static final long SIZE$minX = LAYOUT$minX.byteSize();
    public static final long SIZE$minY = LAYOUT$minY.byteSize();
    public static final long SIZE$minZ = LAYOUT$minZ.byteSize();
    public static final long SIZE$maxX = LAYOUT$maxX.byteSize();
    public static final long SIZE$maxY = LAYOUT$maxY.byteSize();
    public static final long SIZE$maxZ = LAYOUT$maxZ.byteSize();

    public static final long OFFSET$minX = LAYOUT.byteOffset(PATH$minX);
    public static final long OFFSET$minY = LAYOUT.byteOffset(PATH$minY);
    public static final long OFFSET$minZ = LAYOUT.byteOffset(PATH$minZ);
    public static final long OFFSET$maxX = LAYOUT.byteOffset(PATH$maxX);
    public static final long OFFSET$maxY = LAYOUT.byteOffset(PATH$maxY);
    public static final long OFFSET$maxZ = LAYOUT.byteOffset(PATH$maxZ);
}
