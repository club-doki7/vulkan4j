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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDispatchGraphCountInfoAMDX.html"><code>VkDispatchGraphCountInfoAMDX</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDispatchGraphCountInfoAMDX {
///     uint32_t count; // optional // @link substring="count" target="#count"
///     VkDeviceOrHostAddressConstAMDX infos; // @link substring="VkDeviceOrHostAddressConstAMDX" target="VkDeviceOrHostAddressConstAMDX" @link substring="infos" target="#infos"
///     uint64_t stride; // @link substring="stride" target="#stride"
/// } VkDispatchGraphCountInfoAMDX;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDispatchGraphCountInfoAMDX.html"><code>VkDispatchGraphCountInfoAMDX</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDispatchGraphCountInfoAMDX(@NotNull MemorySegment segment) implements IVkDispatchGraphCountInfoAMDX {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDispatchGraphCountInfoAMDX.html"><code>VkDispatchGraphCountInfoAMDX</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDispatchGraphCountInfoAMDX}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDispatchGraphCountInfoAMDX to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDispatchGraphCountInfoAMDX.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDispatchGraphCountInfoAMDX, Iterable<VkDispatchGraphCountInfoAMDX> {
        public long size() {
            return segment.byteSize() / VkDispatchGraphCountInfoAMDX.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDispatchGraphCountInfoAMDX at(long index) {
            return new VkDispatchGraphCountInfoAMDX(segment.asSlice(index * VkDispatchGraphCountInfoAMDX.BYTES, VkDispatchGraphCountInfoAMDX.BYTES));
        }

        public VkDispatchGraphCountInfoAMDX.Ptr at(long index, @NotNull Consumer<@NotNull VkDispatchGraphCountInfoAMDX> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDispatchGraphCountInfoAMDX value) {
            MemorySegment s = segment.asSlice(index * VkDispatchGraphCountInfoAMDX.BYTES, VkDispatchGraphCountInfoAMDX.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDispatchGraphCountInfoAMDX.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDispatchGraphCountInfoAMDX.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDispatchGraphCountInfoAMDX.BYTES,
                (end - start) * VkDispatchGraphCountInfoAMDX.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDispatchGraphCountInfoAMDX.BYTES));
        }

        public VkDispatchGraphCountInfoAMDX[] toArray() {
            VkDispatchGraphCountInfoAMDX[] ret = new VkDispatchGraphCountInfoAMDX[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDispatchGraphCountInfoAMDX> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDispatchGraphCountInfoAMDX> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDispatchGraphCountInfoAMDX.BYTES;
            }

            @Override
            public VkDispatchGraphCountInfoAMDX next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDispatchGraphCountInfoAMDX ret = new VkDispatchGraphCountInfoAMDX(segment.asSlice(0, VkDispatchGraphCountInfoAMDX.BYTES));
                segment = segment.asSlice(VkDispatchGraphCountInfoAMDX.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDispatchGraphCountInfoAMDX allocate(Arena arena) {
        return new VkDispatchGraphCountInfoAMDX(arena.allocate(LAYOUT));
    }

    public static VkDispatchGraphCountInfoAMDX.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkDispatchGraphCountInfoAMDX.Ptr(segment);
    }

    public static VkDispatchGraphCountInfoAMDX clone(Arena arena, VkDispatchGraphCountInfoAMDX src) {
        VkDispatchGraphCountInfoAMDX ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned int count() {
        return segment.get(LAYOUT$count, OFFSET$count);
    }

    public VkDispatchGraphCountInfoAMDX count(@Unsigned int value) {
        segment.set(LAYOUT$count, OFFSET$count, value);
        return this;
    }

    public @NotNull VkDeviceOrHostAddressConstAMDX infos() {
        return new VkDeviceOrHostAddressConstAMDX(segment.asSlice(OFFSET$infos, LAYOUT$infos));
    }

    public VkDispatchGraphCountInfoAMDX infos(@NotNull VkDeviceOrHostAddressConstAMDX value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$infos, SIZE$infos);
        return this;
    }

    public VkDispatchGraphCountInfoAMDX infos(Consumer<@NotNull VkDeviceOrHostAddressConstAMDX> consumer) {
        consumer.accept(infos());
        return this;
    }

    public @Unsigned long stride() {
        return segment.get(LAYOUT$stride, OFFSET$stride);
    }

    public VkDispatchGraphCountInfoAMDX stride(@Unsigned long value) {
        segment.set(LAYOUT$stride, OFFSET$stride, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("count"),
        VkDeviceOrHostAddressConstAMDX.LAYOUT.withName("infos"),
        ValueLayout.JAVA_LONG.withName("stride")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$count = PathElement.groupElement("count");
    public static final PathElement PATH$infos = PathElement.groupElement("infos");
    public static final PathElement PATH$stride = PathElement.groupElement("stride");

    public static final OfInt LAYOUT$count = (OfInt) LAYOUT.select(PATH$count);
    public static final UnionLayout LAYOUT$infos = (UnionLayout) LAYOUT.select(PATH$infos);
    public static final OfLong LAYOUT$stride = (OfLong) LAYOUT.select(PATH$stride);

    public static final long SIZE$count = LAYOUT$count.byteSize();
    public static final long SIZE$infos = LAYOUT$infos.byteSize();
    public static final long SIZE$stride = LAYOUT$stride.byteSize();

    public static final long OFFSET$count = LAYOUT.byteOffset(PATH$count);
    public static final long OFFSET$infos = LAYOUT.byteOffset(PATH$infos);
    public static final long OFFSET$stride = LAYOUT.byteOffset(PATH$stride);
}
