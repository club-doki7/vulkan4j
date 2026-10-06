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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDepthClampRangeEXT.html"><code>VkDepthClampRangeEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDepthClampRangeEXT {
///     float minDepthClamp; // @link substring="minDepthClamp" target="#minDepthClamp"
///     float maxDepthClamp; // @link substring="maxDepthClamp" target="#maxDepthClamp"
/// } VkDepthClampRangeEXT;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDepthClampRangeEXT.html"><code>VkDepthClampRangeEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDepthClampRangeEXT(@NotNull MemorySegment segment) implements IVkDepthClampRangeEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDepthClampRangeEXT.html"><code>VkDepthClampRangeEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDepthClampRangeEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDepthClampRangeEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDepthClampRangeEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDepthClampRangeEXT, Iterable<VkDepthClampRangeEXT> {
        public long size() {
            return segment.byteSize() / VkDepthClampRangeEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDepthClampRangeEXT at(long index) {
            return new VkDepthClampRangeEXT(segment.asSlice(index * VkDepthClampRangeEXT.BYTES, VkDepthClampRangeEXT.BYTES));
        }

        public VkDepthClampRangeEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkDepthClampRangeEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDepthClampRangeEXT value) {
            MemorySegment s = segment.asSlice(index * VkDepthClampRangeEXT.BYTES, VkDepthClampRangeEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDepthClampRangeEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDepthClampRangeEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDepthClampRangeEXT.BYTES,
                (end - start) * VkDepthClampRangeEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDepthClampRangeEXT.BYTES));
        }

        public VkDepthClampRangeEXT[] toArray() {
            VkDepthClampRangeEXT[] ret = new VkDepthClampRangeEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDepthClampRangeEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDepthClampRangeEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDepthClampRangeEXT.BYTES;
            }

            @Override
            public VkDepthClampRangeEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDepthClampRangeEXT ret = new VkDepthClampRangeEXT(segment.asSlice(0, VkDepthClampRangeEXT.BYTES));
                segment = segment.asSlice(VkDepthClampRangeEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDepthClampRangeEXT allocate(Arena arena) {
        return new VkDepthClampRangeEXT(arena.allocate(LAYOUT));
    }

    public static VkDepthClampRangeEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkDepthClampRangeEXT.Ptr(segment);
    }

    public static VkDepthClampRangeEXT clone(Arena arena, VkDepthClampRangeEXT src) {
        VkDepthClampRangeEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public float minDepthClamp() {
        return segment.get(LAYOUT$minDepthClamp, OFFSET$minDepthClamp);
    }

    public VkDepthClampRangeEXT minDepthClamp(float value) {
        segment.set(LAYOUT$minDepthClamp, OFFSET$minDepthClamp, value);
        return this;
    }

    public float maxDepthClamp() {
        return segment.get(LAYOUT$maxDepthClamp, OFFSET$maxDepthClamp);
    }

    public VkDepthClampRangeEXT maxDepthClamp(float value) {
        segment.set(LAYOUT$maxDepthClamp, OFFSET$maxDepthClamp, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_FLOAT.withName("minDepthClamp"),
        ValueLayout.JAVA_FLOAT.withName("maxDepthClamp")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$minDepthClamp = PathElement.groupElement("minDepthClamp");
    public static final PathElement PATH$maxDepthClamp = PathElement.groupElement("maxDepthClamp");

    public static final OfFloat LAYOUT$minDepthClamp = (OfFloat) LAYOUT.select(PATH$minDepthClamp);
    public static final OfFloat LAYOUT$maxDepthClamp = (OfFloat) LAYOUT.select(PATH$maxDepthClamp);

    public static final long SIZE$minDepthClamp = LAYOUT$minDepthClamp.byteSize();
    public static final long SIZE$maxDepthClamp = LAYOUT$maxDepthClamp.byteSize();

    public static final long OFFSET$minDepthClamp = LAYOUT.byteOffset(PATH$minDepthClamp);
    public static final long OFFSET$maxDepthClamp = LAYOUT.byteOffset(PATH$maxDepthClamp);
}
