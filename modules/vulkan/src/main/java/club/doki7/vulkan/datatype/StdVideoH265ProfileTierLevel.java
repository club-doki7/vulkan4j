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

/// Represents a pointer to a {@code StdVideoH265ProfileTierLevel} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct StdVideoH265ProfileTierLevel {
///     StdVideoH265ProfileTierLevelFlags flags; // @link substring="StdVideoH265ProfileTierLevelFlags" target="StdVideoH265ProfileTierLevelFlags" @link substring="flags" target="#flags"
///     StdVideoH265ProfileIdc general_profile_idc; // @link substring="StdVideoH265ProfileIdc" target="StdVideoH265ProfileIdc" @link substring="general_profile_idc" target="#general_profile_idc"
///     StdVideoH265LevelIdc general_level_idc; // @link substring="StdVideoH265LevelIdc" target="StdVideoH265LevelIdc" @link substring="general_level_idc" target="#general_level_idc"
/// } StdVideoH265ProfileTierLevel;
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
@ValueBasedCandidate
@UnsafeConstructor
public record StdVideoH265ProfileTierLevel(@NotNull MemorySegment segment) implements IStdVideoH265ProfileTierLevel {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link StdVideoH265ProfileTierLevel}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IStdVideoH265ProfileTierLevel to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code StdVideoH265ProfileTierLevel.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IStdVideoH265ProfileTierLevel, Iterable<StdVideoH265ProfileTierLevel> {
        public long size() {
            return segment.byteSize() / StdVideoH265ProfileTierLevel.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull StdVideoH265ProfileTierLevel at(long index) {
            return new StdVideoH265ProfileTierLevel(segment.asSlice(index * StdVideoH265ProfileTierLevel.BYTES, StdVideoH265ProfileTierLevel.BYTES));
        }

        public StdVideoH265ProfileTierLevel.Ptr at(long index, @NotNull Consumer<@NotNull StdVideoH265ProfileTierLevel> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull StdVideoH265ProfileTierLevel value) {
            MemorySegment s = segment.asSlice(index * StdVideoH265ProfileTierLevel.BYTES, StdVideoH265ProfileTierLevel.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * StdVideoH265ProfileTierLevel.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * StdVideoH265ProfileTierLevel.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * StdVideoH265ProfileTierLevel.BYTES,
                (end - start) * StdVideoH265ProfileTierLevel.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * StdVideoH265ProfileTierLevel.BYTES));
        }

        public StdVideoH265ProfileTierLevel[] toArray() {
            StdVideoH265ProfileTierLevel[] ret = new StdVideoH265ProfileTierLevel[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<StdVideoH265ProfileTierLevel> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<StdVideoH265ProfileTierLevel> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= StdVideoH265ProfileTierLevel.BYTES;
            }

            @Override
            public StdVideoH265ProfileTierLevel next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                StdVideoH265ProfileTierLevel ret = new StdVideoH265ProfileTierLevel(segment.asSlice(0, StdVideoH265ProfileTierLevel.BYTES));
                segment = segment.asSlice(StdVideoH265ProfileTierLevel.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static StdVideoH265ProfileTierLevel allocate(Arena arena) {
        return new StdVideoH265ProfileTierLevel(arena.allocate(LAYOUT));
    }

    public static StdVideoH265ProfileTierLevel.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new StdVideoH265ProfileTierLevel.Ptr(segment);
    }

    public static StdVideoH265ProfileTierLevel clone(Arena arena, StdVideoH265ProfileTierLevel src) {
        StdVideoH265ProfileTierLevel ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull StdVideoH265ProfileTierLevelFlags flags() {
        return new StdVideoH265ProfileTierLevelFlags(segment.asSlice(OFFSET$flags, LAYOUT$flags));
    }

    public StdVideoH265ProfileTierLevel flags(@NotNull StdVideoH265ProfileTierLevelFlags value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$flags, SIZE$flags);
        return this;
    }

    public StdVideoH265ProfileTierLevel flags(Consumer<@NotNull StdVideoH265ProfileTierLevelFlags> consumer) {
        consumer.accept(flags());
        return this;
    }

    public @EnumType(StdVideoH265ProfileIdc.class) int general_profile_idc() {
        return segment.get(LAYOUT$general_profile_idc, OFFSET$general_profile_idc);
    }

    public StdVideoH265ProfileTierLevel general_profile_idc(@EnumType(StdVideoH265ProfileIdc.class) int value) {
        segment.set(LAYOUT$general_profile_idc, OFFSET$general_profile_idc, value);
        return this;
    }

    public @EnumType(StdVideoH265LevelIdc.class) int general_level_idc() {
        return segment.get(LAYOUT$general_level_idc, OFFSET$general_level_idc);
    }

    public StdVideoH265ProfileTierLevel general_level_idc(@EnumType(StdVideoH265LevelIdc.class) int value) {
        segment.set(LAYOUT$general_level_idc, OFFSET$general_level_idc, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        StdVideoH265ProfileTierLevelFlags.LAYOUT.withName("flags"),
        ValueLayout.JAVA_INT.withName("general_profile_idc"),
        ValueLayout.JAVA_INT.withName("general_level_idc")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$general_profile_idc = PathElement.groupElement("general_profile_idc");
    public static final PathElement PATH$general_level_idc = PathElement.groupElement("general_level_idc");

    public static final StructLayout LAYOUT$flags = (StructLayout) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$general_profile_idc = (OfInt) LAYOUT.select(PATH$general_profile_idc);
    public static final OfInt LAYOUT$general_level_idc = (OfInt) LAYOUT.select(PATH$general_level_idc);

    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$general_profile_idc = LAYOUT$general_profile_idc.byteSize();
    public static final long SIZE$general_level_idc = LAYOUT$general_level_idc.byteSize();

    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$general_profile_idc = LAYOUT.byteOffset(PATH$general_profile_idc);
    public static final long OFFSET$general_level_idc = LAYOUT.byteOffset(PATH$general_level_idc);
}
