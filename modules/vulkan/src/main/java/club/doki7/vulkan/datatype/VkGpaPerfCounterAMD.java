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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGpaPerfCounterAMD.html"><code>VkGpaPerfCounterAMD</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkGpaPerfCounterAMD {
///     VkGpaPerfBlockAMD blockType; // @link substring="VkGpaPerfBlockAMD" target="VkGpaPerfBlockAMD" @link substring="blockType" target="#blockType"
///     uint32_t blockInstance; // @link substring="blockInstance" target="#blockInstance"
///     uint32_t eventID; // @link substring="eventID" target="#eventID"
/// } VkGpaPerfCounterAMD;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGpaPerfCounterAMD.html"><code>VkGpaPerfCounterAMD</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkGpaPerfCounterAMD(@NotNull MemorySegment segment) implements IVkGpaPerfCounterAMD {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGpaPerfCounterAMD.html"><code>VkGpaPerfCounterAMD</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkGpaPerfCounterAMD}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkGpaPerfCounterAMD to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkGpaPerfCounterAMD.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkGpaPerfCounterAMD, Iterable<VkGpaPerfCounterAMD> {
        public long size() {
            return segment.byteSize() / VkGpaPerfCounterAMD.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkGpaPerfCounterAMD at(long index) {
            return new VkGpaPerfCounterAMD(segment.asSlice(index * VkGpaPerfCounterAMD.BYTES, VkGpaPerfCounterAMD.BYTES));
        }

        public VkGpaPerfCounterAMD.Ptr at(long index, @NotNull Consumer<@NotNull VkGpaPerfCounterAMD> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkGpaPerfCounterAMD value) {
            MemorySegment s = segment.asSlice(index * VkGpaPerfCounterAMD.BYTES, VkGpaPerfCounterAMD.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkGpaPerfCounterAMD.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkGpaPerfCounterAMD.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkGpaPerfCounterAMD.BYTES,
                (end - start) * VkGpaPerfCounterAMD.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkGpaPerfCounterAMD.BYTES));
        }

        public VkGpaPerfCounterAMD[] toArray() {
            VkGpaPerfCounterAMD[] ret = new VkGpaPerfCounterAMD[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkGpaPerfCounterAMD> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkGpaPerfCounterAMD> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkGpaPerfCounterAMD.BYTES;
            }

            @Override
            public VkGpaPerfCounterAMD next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkGpaPerfCounterAMD ret = new VkGpaPerfCounterAMD(segment.asSlice(0, VkGpaPerfCounterAMD.BYTES));
                segment = segment.asSlice(VkGpaPerfCounterAMD.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkGpaPerfCounterAMD allocate(Arena arena) {
        return new VkGpaPerfCounterAMD(arena.allocate(LAYOUT));
    }

    public static VkGpaPerfCounterAMD.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkGpaPerfCounterAMD.Ptr(segment);
    }

    public static VkGpaPerfCounterAMD clone(Arena arena, VkGpaPerfCounterAMD src) {
        VkGpaPerfCounterAMD ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @EnumType(VkGpaPerfBlockAMD.class) int blockType() {
        return segment.get(LAYOUT$blockType, OFFSET$blockType);
    }

    public VkGpaPerfCounterAMD blockType(@EnumType(VkGpaPerfBlockAMD.class) int value) {
        segment.set(LAYOUT$blockType, OFFSET$blockType, value);
        return this;
    }

    public @Unsigned int blockInstance() {
        return segment.get(LAYOUT$blockInstance, OFFSET$blockInstance);
    }

    public VkGpaPerfCounterAMD blockInstance(@Unsigned int value) {
        segment.set(LAYOUT$blockInstance, OFFSET$blockInstance, value);
        return this;
    }

    public @Unsigned int eventID() {
        return segment.get(LAYOUT$eventID, OFFSET$eventID);
    }

    public VkGpaPerfCounterAMD eventID(@Unsigned int value) {
        segment.set(LAYOUT$eventID, OFFSET$eventID, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("blockType"),
        ValueLayout.JAVA_INT.withName("blockInstance"),
        ValueLayout.JAVA_INT.withName("eventID")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$blockType = PathElement.groupElement("blockType");
    public static final PathElement PATH$blockInstance = PathElement.groupElement("blockInstance");
    public static final PathElement PATH$eventID = PathElement.groupElement("eventID");

    public static final OfInt LAYOUT$blockType = (OfInt) LAYOUT.select(PATH$blockType);
    public static final OfInt LAYOUT$blockInstance = (OfInt) LAYOUT.select(PATH$blockInstance);
    public static final OfInt LAYOUT$eventID = (OfInt) LAYOUT.select(PATH$eventID);

    public static final long SIZE$blockType = LAYOUT$blockType.byteSize();
    public static final long SIZE$blockInstance = LAYOUT$blockInstance.byteSize();
    public static final long SIZE$eventID = LAYOUT$eventID.byteSize();

    public static final long OFFSET$blockType = LAYOUT.byteOffset(PATH$blockType);
    public static final long OFFSET$blockInstance = LAYOUT.byteOffset(PATH$blockInstance);
    public static final long OFFSET$eventID = LAYOUT.byteOffset(PATH$eventID);
}
