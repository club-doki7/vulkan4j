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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkViewportWScalingNV.html"><code>VkViewportWScalingNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkViewportWScalingNV {
///     float xcoeff; // @link substring="xcoeff" target="#xcoeff"
///     float ycoeff; // @link substring="ycoeff" target="#ycoeff"
/// } VkViewportWScalingNV;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkViewportWScalingNV.html"><code>VkViewportWScalingNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkViewportWScalingNV(@NotNull MemorySegment segment) implements IVkViewportWScalingNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkViewportWScalingNV.html"><code>VkViewportWScalingNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkViewportWScalingNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkViewportWScalingNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkViewportWScalingNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkViewportWScalingNV, Iterable<VkViewportWScalingNV> {
        public long size() {
            return segment.byteSize() / VkViewportWScalingNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkViewportWScalingNV at(long index) {
            return new VkViewportWScalingNV(segment.asSlice(index * VkViewportWScalingNV.BYTES, VkViewportWScalingNV.BYTES));
        }

        public VkViewportWScalingNV.Ptr at(long index, @NotNull Consumer<@NotNull VkViewportWScalingNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkViewportWScalingNV value) {
            MemorySegment s = segment.asSlice(index * VkViewportWScalingNV.BYTES, VkViewportWScalingNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkViewportWScalingNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkViewportWScalingNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkViewportWScalingNV.BYTES,
                (end - start) * VkViewportWScalingNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkViewportWScalingNV.BYTES));
        }

        public VkViewportWScalingNV[] toArray() {
            VkViewportWScalingNV[] ret = new VkViewportWScalingNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkViewportWScalingNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkViewportWScalingNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkViewportWScalingNV.BYTES;
            }

            @Override
            public VkViewportWScalingNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkViewportWScalingNV ret = new VkViewportWScalingNV(segment.asSlice(0, VkViewportWScalingNV.BYTES));
                segment = segment.asSlice(VkViewportWScalingNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkViewportWScalingNV allocate(Arena arena) {
        return new VkViewportWScalingNV(arena.allocate(LAYOUT));
    }

    public static VkViewportWScalingNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkViewportWScalingNV.Ptr(segment);
    }

    public static VkViewportWScalingNV clone(Arena arena, VkViewportWScalingNV src) {
        VkViewportWScalingNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public float xcoeff() {
        return segment.get(LAYOUT$xcoeff, OFFSET$xcoeff);
    }

    public VkViewportWScalingNV xcoeff(float value) {
        segment.set(LAYOUT$xcoeff, OFFSET$xcoeff, value);
        return this;
    }

    public float ycoeff() {
        return segment.get(LAYOUT$ycoeff, OFFSET$ycoeff);
    }

    public VkViewportWScalingNV ycoeff(float value) {
        segment.set(LAYOUT$ycoeff, OFFSET$ycoeff, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_FLOAT.withName("xcoeff"),
        ValueLayout.JAVA_FLOAT.withName("ycoeff")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$xcoeff = PathElement.groupElement("xcoeff");
    public static final PathElement PATH$ycoeff = PathElement.groupElement("ycoeff");

    public static final OfFloat LAYOUT$xcoeff = (OfFloat) LAYOUT.select(PATH$xcoeff);
    public static final OfFloat LAYOUT$ycoeff = (OfFloat) LAYOUT.select(PATH$ycoeff);

    public static final long SIZE$xcoeff = LAYOUT$xcoeff.byteSize();
    public static final long SIZE$ycoeff = LAYOUT$ycoeff.byteSize();

    public static final long OFFSET$xcoeff = LAYOUT.byteOffset(PATH$xcoeff);
    public static final long OFFSET$ycoeff = LAYOUT.byteOffset(PATH$ycoeff);
}
