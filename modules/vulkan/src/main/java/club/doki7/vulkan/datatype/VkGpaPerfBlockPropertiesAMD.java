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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGpaPerfBlockPropertiesAMD.html"><code>VkGpaPerfBlockPropertiesAMD</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkGpaPerfBlockPropertiesAMD {
///     VkGpaPerfBlockAMD blockType; // @link substring="VkGpaPerfBlockAMD" target="VkGpaPerfBlockAMD" @link substring="blockType" target="#blockType"
///     VkGpaPerfBlockPropertiesFlagsAMD flags; // @link substring="VkGpaPerfBlockPropertiesFlagsAMD" target="VkGpaPerfBlockPropertiesFlagsAMD" @link substring="flags" target="#flags"
///     uint32_t instanceCount; // @link substring="instanceCount" target="#instanceCount"
///     uint32_t maxEventID; // @link substring="maxEventID" target="#maxEventID"
///     uint32_t maxGlobalOnlyCounters; // @link substring="maxGlobalOnlyCounters" target="#maxGlobalOnlyCounters"
///     uint32_t maxGlobalSharedCounters; // @link substring="maxGlobalSharedCounters" target="#maxGlobalSharedCounters"
///     uint32_t maxStreamingCounters; // @link substring="maxStreamingCounters" target="#maxStreamingCounters"
/// } VkGpaPerfBlockPropertiesAMD;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGpaPerfBlockPropertiesAMD.html"><code>VkGpaPerfBlockPropertiesAMD</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkGpaPerfBlockPropertiesAMD(@NotNull MemorySegment segment) implements IVkGpaPerfBlockPropertiesAMD {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGpaPerfBlockPropertiesAMD.html"><code>VkGpaPerfBlockPropertiesAMD</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkGpaPerfBlockPropertiesAMD}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkGpaPerfBlockPropertiesAMD to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkGpaPerfBlockPropertiesAMD.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkGpaPerfBlockPropertiesAMD, Iterable<VkGpaPerfBlockPropertiesAMD> {
        public long size() {
            return segment.byteSize() / VkGpaPerfBlockPropertiesAMD.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkGpaPerfBlockPropertiesAMD at(long index) {
            return new VkGpaPerfBlockPropertiesAMD(segment.asSlice(index * VkGpaPerfBlockPropertiesAMD.BYTES, VkGpaPerfBlockPropertiesAMD.BYTES));
        }

        public VkGpaPerfBlockPropertiesAMD.Ptr at(long index, @NotNull Consumer<@NotNull VkGpaPerfBlockPropertiesAMD> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkGpaPerfBlockPropertiesAMD value) {
            MemorySegment s = segment.asSlice(index * VkGpaPerfBlockPropertiesAMD.BYTES, VkGpaPerfBlockPropertiesAMD.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkGpaPerfBlockPropertiesAMD.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkGpaPerfBlockPropertiesAMD.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkGpaPerfBlockPropertiesAMD.BYTES,
                (end - start) * VkGpaPerfBlockPropertiesAMD.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkGpaPerfBlockPropertiesAMD.BYTES));
        }

        public VkGpaPerfBlockPropertiesAMD[] toArray() {
            VkGpaPerfBlockPropertiesAMD[] ret = new VkGpaPerfBlockPropertiesAMD[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkGpaPerfBlockPropertiesAMD> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkGpaPerfBlockPropertiesAMD> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkGpaPerfBlockPropertiesAMD.BYTES;
            }

            @Override
            public VkGpaPerfBlockPropertiesAMD next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkGpaPerfBlockPropertiesAMD ret = new VkGpaPerfBlockPropertiesAMD(segment.asSlice(0, VkGpaPerfBlockPropertiesAMD.BYTES));
                segment = segment.asSlice(VkGpaPerfBlockPropertiesAMD.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkGpaPerfBlockPropertiesAMD allocate(Arena arena) {
        return new VkGpaPerfBlockPropertiesAMD(arena.allocate(LAYOUT));
    }

    public static VkGpaPerfBlockPropertiesAMD.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkGpaPerfBlockPropertiesAMD.Ptr(segment);
    }

    public static VkGpaPerfBlockPropertiesAMD clone(Arena arena, VkGpaPerfBlockPropertiesAMD src) {
        VkGpaPerfBlockPropertiesAMD ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @EnumType(VkGpaPerfBlockAMD.class) int blockType() {
        return segment.get(LAYOUT$blockType, OFFSET$blockType);
    }

    public VkGpaPerfBlockPropertiesAMD blockType(@EnumType(VkGpaPerfBlockAMD.class) int value) {
        segment.set(LAYOUT$blockType, OFFSET$blockType, value);
        return this;
    }

    public @Bitmask(VkGpaPerfBlockPropertiesFlagsAMD.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkGpaPerfBlockPropertiesAMD flags(@Bitmask(VkGpaPerfBlockPropertiesFlagsAMD.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @Unsigned int instanceCount() {
        return segment.get(LAYOUT$instanceCount, OFFSET$instanceCount);
    }

    public VkGpaPerfBlockPropertiesAMD instanceCount(@Unsigned int value) {
        segment.set(LAYOUT$instanceCount, OFFSET$instanceCount, value);
        return this;
    }

    public @Unsigned int maxEventID() {
        return segment.get(LAYOUT$maxEventID, OFFSET$maxEventID);
    }

    public VkGpaPerfBlockPropertiesAMD maxEventID(@Unsigned int value) {
        segment.set(LAYOUT$maxEventID, OFFSET$maxEventID, value);
        return this;
    }

    public @Unsigned int maxGlobalOnlyCounters() {
        return segment.get(LAYOUT$maxGlobalOnlyCounters, OFFSET$maxGlobalOnlyCounters);
    }

    public VkGpaPerfBlockPropertiesAMD maxGlobalOnlyCounters(@Unsigned int value) {
        segment.set(LAYOUT$maxGlobalOnlyCounters, OFFSET$maxGlobalOnlyCounters, value);
        return this;
    }

    public @Unsigned int maxGlobalSharedCounters() {
        return segment.get(LAYOUT$maxGlobalSharedCounters, OFFSET$maxGlobalSharedCounters);
    }

    public VkGpaPerfBlockPropertiesAMD maxGlobalSharedCounters(@Unsigned int value) {
        segment.set(LAYOUT$maxGlobalSharedCounters, OFFSET$maxGlobalSharedCounters, value);
        return this;
    }

    public @Unsigned int maxStreamingCounters() {
        return segment.get(LAYOUT$maxStreamingCounters, OFFSET$maxStreamingCounters);
    }

    public VkGpaPerfBlockPropertiesAMD maxStreamingCounters(@Unsigned int value) {
        segment.set(LAYOUT$maxStreamingCounters, OFFSET$maxStreamingCounters, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("blockType"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("instanceCount"),
        ValueLayout.JAVA_INT.withName("maxEventID"),
        ValueLayout.JAVA_INT.withName("maxGlobalOnlyCounters"),
        ValueLayout.JAVA_INT.withName("maxGlobalSharedCounters"),
        ValueLayout.JAVA_INT.withName("maxStreamingCounters")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$blockType = PathElement.groupElement("blockType");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$instanceCount = PathElement.groupElement("instanceCount");
    public static final PathElement PATH$maxEventID = PathElement.groupElement("maxEventID");
    public static final PathElement PATH$maxGlobalOnlyCounters = PathElement.groupElement("maxGlobalOnlyCounters");
    public static final PathElement PATH$maxGlobalSharedCounters = PathElement.groupElement("maxGlobalSharedCounters");
    public static final PathElement PATH$maxStreamingCounters = PathElement.groupElement("maxStreamingCounters");

    public static final OfInt LAYOUT$blockType = (OfInt) LAYOUT.select(PATH$blockType);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$instanceCount = (OfInt) LAYOUT.select(PATH$instanceCount);
    public static final OfInt LAYOUT$maxEventID = (OfInt) LAYOUT.select(PATH$maxEventID);
    public static final OfInt LAYOUT$maxGlobalOnlyCounters = (OfInt) LAYOUT.select(PATH$maxGlobalOnlyCounters);
    public static final OfInt LAYOUT$maxGlobalSharedCounters = (OfInt) LAYOUT.select(PATH$maxGlobalSharedCounters);
    public static final OfInt LAYOUT$maxStreamingCounters = (OfInt) LAYOUT.select(PATH$maxStreamingCounters);

    public static final long SIZE$blockType = LAYOUT$blockType.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$instanceCount = LAYOUT$instanceCount.byteSize();
    public static final long SIZE$maxEventID = LAYOUT$maxEventID.byteSize();
    public static final long SIZE$maxGlobalOnlyCounters = LAYOUT$maxGlobalOnlyCounters.byteSize();
    public static final long SIZE$maxGlobalSharedCounters = LAYOUT$maxGlobalSharedCounters.byteSize();
    public static final long SIZE$maxStreamingCounters = LAYOUT$maxStreamingCounters.byteSize();

    public static final long OFFSET$blockType = LAYOUT.byteOffset(PATH$blockType);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$instanceCount = LAYOUT.byteOffset(PATH$instanceCount);
    public static final long OFFSET$maxEventID = LAYOUT.byteOffset(PATH$maxEventID);
    public static final long OFFSET$maxGlobalOnlyCounters = LAYOUT.byteOffset(PATH$maxGlobalOnlyCounters);
    public static final long OFFSET$maxGlobalSharedCounters = LAYOUT.byteOffset(PATH$maxGlobalSharedCounters);
    public static final long OFFSET$maxStreamingCounters = LAYOUT.byteOffset(PATH$maxStreamingCounters);
}
