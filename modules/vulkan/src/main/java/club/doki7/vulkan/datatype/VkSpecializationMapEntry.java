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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSpecializationMapEntry.html"><code>VkSpecializationMapEntry</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkSpecializationMapEntry {
///     uint32_t constantID; // @link substring="constantID" target="#constantID"
///     uint32_t offset; // @link substring="offset" target="#offset"
///     size_t size; // @link substring="size" target="#size"
/// } VkSpecializationMapEntry;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSpecializationMapEntry.html"><code>VkSpecializationMapEntry</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkSpecializationMapEntry(@NotNull MemorySegment segment) implements IVkSpecializationMapEntry {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSpecializationMapEntry.html"><code>VkSpecializationMapEntry</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkSpecializationMapEntry}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkSpecializationMapEntry to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkSpecializationMapEntry.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkSpecializationMapEntry, Iterable<VkSpecializationMapEntry> {
        public long size() {
            return segment.byteSize() / VkSpecializationMapEntry.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkSpecializationMapEntry at(long index) {
            return new VkSpecializationMapEntry(segment.asSlice(index * VkSpecializationMapEntry.BYTES, VkSpecializationMapEntry.BYTES));
        }

        public VkSpecializationMapEntry.Ptr at(long index, @NotNull Consumer<@NotNull VkSpecializationMapEntry> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkSpecializationMapEntry value) {
            MemorySegment s = segment.asSlice(index * VkSpecializationMapEntry.BYTES, VkSpecializationMapEntry.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkSpecializationMapEntry.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkSpecializationMapEntry.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkSpecializationMapEntry.BYTES,
                (end - start) * VkSpecializationMapEntry.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkSpecializationMapEntry.BYTES));
        }

        public VkSpecializationMapEntry[] toArray() {
            VkSpecializationMapEntry[] ret = new VkSpecializationMapEntry[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkSpecializationMapEntry> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkSpecializationMapEntry> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkSpecializationMapEntry.BYTES;
            }

            @Override
            public VkSpecializationMapEntry next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkSpecializationMapEntry ret = new VkSpecializationMapEntry(segment.asSlice(0, VkSpecializationMapEntry.BYTES));
                segment = segment.asSlice(VkSpecializationMapEntry.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkSpecializationMapEntry allocate(Arena arena) {
        return new VkSpecializationMapEntry(arena.allocate(LAYOUT));
    }

    public static VkSpecializationMapEntry.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkSpecializationMapEntry.Ptr(segment);
    }

    public static VkSpecializationMapEntry clone(Arena arena, VkSpecializationMapEntry src) {
        VkSpecializationMapEntry ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned int constantID() {
        return segment.get(LAYOUT$constantID, OFFSET$constantID);
    }

    public VkSpecializationMapEntry constantID(@Unsigned int value) {
        segment.set(LAYOUT$constantID, OFFSET$constantID, value);
        return this;
    }

    public @Unsigned int offset() {
        return segment.get(LAYOUT$offset, OFFSET$offset);
    }

    public VkSpecializationMapEntry offset(@Unsigned int value) {
        segment.set(LAYOUT$offset, OFFSET$offset, value);
        return this;
    }

    public @Unsigned long size() {
        return NativeLayout.readCSizeT(segment, OFFSET$size);
    }

    public VkSpecializationMapEntry size(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$size, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("constantID"),
        ValueLayout.JAVA_INT.withName("offset"),
        NativeLayout.C_SIZE_T.withName("size")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$constantID = PathElement.groupElement("constantID");
    public static final PathElement PATH$offset = PathElement.groupElement("offset");
    public static final PathElement PATH$size = PathElement.groupElement("size");

    public static final OfInt LAYOUT$constantID = (OfInt) LAYOUT.select(PATH$constantID);
    public static final OfInt LAYOUT$offset = (OfInt) LAYOUT.select(PATH$offset);

    public static final long SIZE$constantID = LAYOUT$constantID.byteSize();
    public static final long SIZE$offset = LAYOUT$offset.byteSize();
    public static final long SIZE$size = NativeLayout.C_SIZE_T.byteSize();

    public static final long OFFSET$constantID = LAYOUT.byteOffset(PATH$constantID);
    public static final long OFFSET$offset = LAYOUT.byteOffset(PATH$offset);
    public static final long OFFSET$size = LAYOUT.byteOffset(PATH$size);
}
