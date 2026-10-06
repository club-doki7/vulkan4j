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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRefreshObjectKHR.html"><code>VkRefreshObjectKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkRefreshObjectKHR {
///     VkObjectType objectType; // @link substring="VkObjectType" target="VkObjectType" @link substring="objectType" target="#objectType"
///     uint64_t objectHandle; // @link substring="objectHandle" target="#objectHandle"
///     VkRefreshObjectFlagsKHR flags; // optional // @link substring="VkRefreshObjectFlagsKHR" target="VkRefreshObjectFlagsKHR" @link substring="flags" target="#flags"
/// } VkRefreshObjectKHR;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRefreshObjectKHR.html"><code>VkRefreshObjectKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkRefreshObjectKHR(@NotNull MemorySegment segment) implements IVkRefreshObjectKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRefreshObjectKHR.html"><code>VkRefreshObjectKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkRefreshObjectKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkRefreshObjectKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkRefreshObjectKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkRefreshObjectKHR, Iterable<VkRefreshObjectKHR> {
        public long size() {
            return segment.byteSize() / VkRefreshObjectKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkRefreshObjectKHR at(long index) {
            return new VkRefreshObjectKHR(segment.asSlice(index * VkRefreshObjectKHR.BYTES, VkRefreshObjectKHR.BYTES));
        }

        public VkRefreshObjectKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkRefreshObjectKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkRefreshObjectKHR value) {
            MemorySegment s = segment.asSlice(index * VkRefreshObjectKHR.BYTES, VkRefreshObjectKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkRefreshObjectKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkRefreshObjectKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkRefreshObjectKHR.BYTES,
                (end - start) * VkRefreshObjectKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkRefreshObjectKHR.BYTES));
        }

        public VkRefreshObjectKHR[] toArray() {
            VkRefreshObjectKHR[] ret = new VkRefreshObjectKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkRefreshObjectKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkRefreshObjectKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkRefreshObjectKHR.BYTES;
            }

            @Override
            public VkRefreshObjectKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkRefreshObjectKHR ret = new VkRefreshObjectKHR(segment.asSlice(0, VkRefreshObjectKHR.BYTES));
                segment = segment.asSlice(VkRefreshObjectKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkRefreshObjectKHR allocate(Arena arena) {
        return new VkRefreshObjectKHR(arena.allocate(LAYOUT));
    }

    public static VkRefreshObjectKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkRefreshObjectKHR.Ptr(segment);
    }

    public static VkRefreshObjectKHR clone(Arena arena, VkRefreshObjectKHR src) {
        VkRefreshObjectKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @EnumType(VkObjectType.class) int objectType() {
        return segment.get(LAYOUT$objectType, OFFSET$objectType);
    }

    public VkRefreshObjectKHR objectType(@EnumType(VkObjectType.class) int value) {
        segment.set(LAYOUT$objectType, OFFSET$objectType, value);
        return this;
    }

    public @Unsigned long objectHandle() {
        return segment.get(LAYOUT$objectHandle, OFFSET$objectHandle);
    }

    public VkRefreshObjectKHR objectHandle(@Unsigned long value) {
        segment.set(LAYOUT$objectHandle, OFFSET$objectHandle, value);
        return this;
    }

    public @Bitmask(VkRefreshObjectFlagsKHR.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkRefreshObjectKHR flags(@Bitmask(VkRefreshObjectFlagsKHR.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("objectType"),
        ValueLayout.JAVA_LONG.withName("objectHandle"),
        ValueLayout.JAVA_INT.withName("flags")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$objectType = PathElement.groupElement("objectType");
    public static final PathElement PATH$objectHandle = PathElement.groupElement("objectHandle");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");

    public static final OfInt LAYOUT$objectType = (OfInt) LAYOUT.select(PATH$objectType);
    public static final OfLong LAYOUT$objectHandle = (OfLong) LAYOUT.select(PATH$objectHandle);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);

    public static final long SIZE$objectType = LAYOUT$objectType.byteSize();
    public static final long SIZE$objectHandle = LAYOUT$objectHandle.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();

    public static final long OFFSET$objectType = LAYOUT.byteOffset(PATH$objectType);
    public static final long OFFSET$objectHandle = LAYOUT.byteOffset(PATH$objectHandle);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
}
