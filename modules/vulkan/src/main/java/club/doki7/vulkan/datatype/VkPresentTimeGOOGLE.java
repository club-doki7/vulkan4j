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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPresentTimeGOOGLE.html"><code>VkPresentTimeGOOGLE</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPresentTimeGOOGLE {
///     uint32_t presentID; // @link substring="presentID" target="#presentID"
///     uint64_t desiredPresentTime; // @link substring="desiredPresentTime" target="#desiredPresentTime"
/// } VkPresentTimeGOOGLE;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPresentTimeGOOGLE.html"><code>VkPresentTimeGOOGLE</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPresentTimeGOOGLE(@NotNull MemorySegment segment) implements IVkPresentTimeGOOGLE {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPresentTimeGOOGLE.html"><code>VkPresentTimeGOOGLE</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPresentTimeGOOGLE}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPresentTimeGOOGLE to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPresentTimeGOOGLE.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPresentTimeGOOGLE, Iterable<VkPresentTimeGOOGLE> {
        public long size() {
            return segment.byteSize() / VkPresentTimeGOOGLE.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPresentTimeGOOGLE at(long index) {
            return new VkPresentTimeGOOGLE(segment.asSlice(index * VkPresentTimeGOOGLE.BYTES, VkPresentTimeGOOGLE.BYTES));
        }

        public VkPresentTimeGOOGLE.Ptr at(long index, @NotNull Consumer<@NotNull VkPresentTimeGOOGLE> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPresentTimeGOOGLE value) {
            MemorySegment s = segment.asSlice(index * VkPresentTimeGOOGLE.BYTES, VkPresentTimeGOOGLE.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPresentTimeGOOGLE.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPresentTimeGOOGLE.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPresentTimeGOOGLE.BYTES,
                (end - start) * VkPresentTimeGOOGLE.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPresentTimeGOOGLE.BYTES));
        }

        public VkPresentTimeGOOGLE[] toArray() {
            VkPresentTimeGOOGLE[] ret = new VkPresentTimeGOOGLE[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPresentTimeGOOGLE> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPresentTimeGOOGLE> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPresentTimeGOOGLE.BYTES;
            }

            @Override
            public VkPresentTimeGOOGLE next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPresentTimeGOOGLE ret = new VkPresentTimeGOOGLE(segment.asSlice(0, VkPresentTimeGOOGLE.BYTES));
                segment = segment.asSlice(VkPresentTimeGOOGLE.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPresentTimeGOOGLE allocate(Arena arena) {
        return new VkPresentTimeGOOGLE(arena.allocate(LAYOUT));
    }

    public static VkPresentTimeGOOGLE.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkPresentTimeGOOGLE.Ptr(segment);
    }

    public static VkPresentTimeGOOGLE clone(Arena arena, VkPresentTimeGOOGLE src) {
        VkPresentTimeGOOGLE ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned int presentID() {
        return segment.get(LAYOUT$presentID, OFFSET$presentID);
    }

    public VkPresentTimeGOOGLE presentID(@Unsigned int value) {
        segment.set(LAYOUT$presentID, OFFSET$presentID, value);
        return this;
    }

    public @Unsigned long desiredPresentTime() {
        return segment.get(LAYOUT$desiredPresentTime, OFFSET$desiredPresentTime);
    }

    public VkPresentTimeGOOGLE desiredPresentTime(@Unsigned long value) {
        segment.set(LAYOUT$desiredPresentTime, OFFSET$desiredPresentTime, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("presentID"),
        ValueLayout.JAVA_LONG.withName("desiredPresentTime")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$presentID = PathElement.groupElement("presentID");
    public static final PathElement PATH$desiredPresentTime = PathElement.groupElement("desiredPresentTime");

    public static final OfInt LAYOUT$presentID = (OfInt) LAYOUT.select(PATH$presentID);
    public static final OfLong LAYOUT$desiredPresentTime = (OfLong) LAYOUT.select(PATH$desiredPresentTime);

    public static final long SIZE$presentID = LAYOUT$presentID.byteSize();
    public static final long SIZE$desiredPresentTime = LAYOUT$desiredPresentTime.byteSize();

    public static final long OFFSET$presentID = LAYOUT.byteOffset(PATH$presentID);
    public static final long OFFSET$desiredPresentTime = LAYOUT.byteOffset(PATH$desiredPresentTime);
}
