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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDataGraphTOSANameQualityARM.html"><code>VkDataGraphTOSANameQualityARM</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDataGraphTOSANameQualityARM {
///     char[VK_MAX_DATA_GRAPH_TOSA_NAME_SIZE_ARM] name; // @link substring="name" target="#name"
///     VkDataGraphTOSAQualityFlagsARM qualityFlags; // @link substring="VkDataGraphTOSAQualityFlagsARM" target="VkDataGraphTOSAQualityFlagsARM" @link substring="qualityFlags" target="#qualityFlags"
/// } VkDataGraphTOSANameQualityARM;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDataGraphTOSANameQualityARM.html"><code>VkDataGraphTOSANameQualityARM</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDataGraphTOSANameQualityARM(@NotNull MemorySegment segment) implements IVkDataGraphTOSANameQualityARM {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDataGraphTOSANameQualityARM.html"><code>VkDataGraphTOSANameQualityARM</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDataGraphTOSANameQualityARM}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDataGraphTOSANameQualityARM to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDataGraphTOSANameQualityARM.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDataGraphTOSANameQualityARM, Iterable<VkDataGraphTOSANameQualityARM> {
        public long size() {
            return segment.byteSize() / VkDataGraphTOSANameQualityARM.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDataGraphTOSANameQualityARM at(long index) {
            return new VkDataGraphTOSANameQualityARM(segment.asSlice(index * VkDataGraphTOSANameQualityARM.BYTES, VkDataGraphTOSANameQualityARM.BYTES));
        }

        public VkDataGraphTOSANameQualityARM.Ptr at(long index, @NotNull Consumer<@NotNull VkDataGraphTOSANameQualityARM> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDataGraphTOSANameQualityARM value) {
            MemorySegment s = segment.asSlice(index * VkDataGraphTOSANameQualityARM.BYTES, VkDataGraphTOSANameQualityARM.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDataGraphTOSANameQualityARM.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDataGraphTOSANameQualityARM.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDataGraphTOSANameQualityARM.BYTES,
                (end - start) * VkDataGraphTOSANameQualityARM.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDataGraphTOSANameQualityARM.BYTES));
        }

        public VkDataGraphTOSANameQualityARM[] toArray() {
            VkDataGraphTOSANameQualityARM[] ret = new VkDataGraphTOSANameQualityARM[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDataGraphTOSANameQualityARM> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDataGraphTOSANameQualityARM> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDataGraphTOSANameQualityARM.BYTES;
            }

            @Override
            public VkDataGraphTOSANameQualityARM next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDataGraphTOSANameQualityARM ret = new VkDataGraphTOSANameQualityARM(segment.asSlice(0, VkDataGraphTOSANameQualityARM.BYTES));
                segment = segment.asSlice(VkDataGraphTOSANameQualityARM.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDataGraphTOSANameQualityARM allocate(Arena arena) {
        return new VkDataGraphTOSANameQualityARM(arena.allocate(LAYOUT));
    }

    public static VkDataGraphTOSANameQualityARM.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkDataGraphTOSANameQualityARM.Ptr(segment);
    }

    public static VkDataGraphTOSANameQualityARM clone(Arena arena, VkDataGraphTOSANameQualityARM src) {
        VkDataGraphTOSANameQualityARM ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public BytePtr name() {
        return new BytePtr(nameRaw());
    }

    public VkDataGraphTOSANameQualityARM name(@NotNull Consumer<BytePtr> consumer) {
        BytePtr ptr = name();
        consumer.accept(ptr);
        return this;
    }

    public VkDataGraphTOSANameQualityARM name(BytePtr value) {
        MemorySegment s = nameRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment nameRaw() {
        return segment.asSlice(OFFSET$name, SIZE$name);
    }

    public @Bitmask(VkDataGraphTOSAQualityFlagsARM.class) int qualityFlags() {
        return segment.get(LAYOUT$qualityFlags, OFFSET$qualityFlags);
    }

    public VkDataGraphTOSANameQualityARM qualityFlags(@Bitmask(VkDataGraphTOSAQualityFlagsARM.class) int value) {
        segment.set(LAYOUT$qualityFlags, OFFSET$qualityFlags, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        MemoryLayout.sequenceLayout(MAX_DATA_GRAPH_TOSA_NAME_SIZE_ARM, ValueLayout.JAVA_BYTE).withName("name"),
        ValueLayout.JAVA_INT.withName("qualityFlags")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$name = PathElement.groupElement("name");
    public static final PathElement PATH$qualityFlags = PathElement.groupElement("qualityFlags");

    public static final SequenceLayout LAYOUT$name = (SequenceLayout) LAYOUT.select(PATH$name);
    public static final OfInt LAYOUT$qualityFlags = (OfInt) LAYOUT.select(PATH$qualityFlags);

    public static final long SIZE$name = LAYOUT$name.byteSize();
    public static final long SIZE$qualityFlags = LAYOUT$qualityFlags.byteSize();

    public static final long OFFSET$name = LAYOUT.byteOffset(PATH$name);
    public static final long OFFSET$qualityFlags = LAYOUT.byteOffset(PATH$qualityFlags);
}
