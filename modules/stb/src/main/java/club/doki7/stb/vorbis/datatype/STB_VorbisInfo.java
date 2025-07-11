package club.doki7.stb.vorbis.datatype;

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
import club.doki7.stb.vorbis.handle.*;
import club.doki7.stb.vorbis.enumtype.*;

/// Represents a pointer to a {@code stb_vorbis_info} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct stb_vorbis_info {
///     int sampleRate; // @link substring="sampleRate" target="#sampleRate"
///     int channels; // @link substring="channels" target="#channels"
///     int setupMemoryRequired; // @link substring="setupMemoryRequired" target="#setupMemoryRequired"
///     int setupTempMemoryRequired; // @link substring="setupTempMemoryRequired" target="#setupTempMemoryRequired"
///     int tempMemoryRequired; // @link substring="tempMemoryRequired" target="#tempMemoryRequired"
///     int maxFrameSize; // @link substring="maxFrameSize" target="#maxFrameSize"
/// } stb_vorbis_info;
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
public record STB_VorbisInfo(@NotNull MemorySegment segment) implements ISTB_VorbisInfo {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link STB_VorbisInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// ISTB_VorbisInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code STB_VorbisInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements ISTB_VorbisInfo, Iterable<STB_VorbisInfo> {
        public long size() {
            return segment.byteSize() / STB_VorbisInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull STB_VorbisInfo at(long index) {
            return new STB_VorbisInfo(segment.asSlice(index * STB_VorbisInfo.BYTES, STB_VorbisInfo.BYTES));
        }

        public STB_VorbisInfo.Ptr at(long index, @NotNull Consumer<@NotNull STB_VorbisInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull STB_VorbisInfo value) {
            MemorySegment s = segment.asSlice(index * STB_VorbisInfo.BYTES, STB_VorbisInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * STB_VorbisInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * STB_VorbisInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * STB_VorbisInfo.BYTES,
                (end - start) * STB_VorbisInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * STB_VorbisInfo.BYTES));
        }

        public STB_VorbisInfo[] toArray() {
            STB_VorbisInfo[] ret = new STB_VorbisInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<STB_VorbisInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<STB_VorbisInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= STB_VorbisInfo.BYTES;
            }

            @Override
            public STB_VorbisInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                STB_VorbisInfo ret = new STB_VorbisInfo(segment.asSlice(0, STB_VorbisInfo.BYTES));
                segment = segment.asSlice(STB_VorbisInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static STB_VorbisInfo allocate(Arena arena) {
        return new STB_VorbisInfo(arena.allocate(LAYOUT));
    }

    public static STB_VorbisInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new STB_VorbisInfo.Ptr(segment);
    }

    public static STB_VorbisInfo clone(Arena arena, STB_VorbisInfo src) {
        STB_VorbisInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public int sampleRate() {
        return segment.get(LAYOUT$sampleRate, OFFSET$sampleRate);
    }

    public STB_VorbisInfo sampleRate(int value) {
        segment.set(LAYOUT$sampleRate, OFFSET$sampleRate, value);
        return this;
    }

    public int channels() {
        return segment.get(LAYOUT$channels, OFFSET$channels);
    }

    public STB_VorbisInfo channels(int value) {
        segment.set(LAYOUT$channels, OFFSET$channels, value);
        return this;
    }

    public int setupMemoryRequired() {
        return segment.get(LAYOUT$setupMemoryRequired, OFFSET$setupMemoryRequired);
    }

    public STB_VorbisInfo setupMemoryRequired(int value) {
        segment.set(LAYOUT$setupMemoryRequired, OFFSET$setupMemoryRequired, value);
        return this;
    }

    public int setupTempMemoryRequired() {
        return segment.get(LAYOUT$setupTempMemoryRequired, OFFSET$setupTempMemoryRequired);
    }

    public STB_VorbisInfo setupTempMemoryRequired(int value) {
        segment.set(LAYOUT$setupTempMemoryRequired, OFFSET$setupTempMemoryRequired, value);
        return this;
    }

    public int tempMemoryRequired() {
        return segment.get(LAYOUT$tempMemoryRequired, OFFSET$tempMemoryRequired);
    }

    public STB_VorbisInfo tempMemoryRequired(int value) {
        segment.set(LAYOUT$tempMemoryRequired, OFFSET$tempMemoryRequired, value);
        return this;
    }

    public int maxFrameSize() {
        return segment.get(LAYOUT$maxFrameSize, OFFSET$maxFrameSize);
    }

    public STB_VorbisInfo maxFrameSize(int value) {
        segment.set(LAYOUT$maxFrameSize, OFFSET$maxFrameSize, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sampleRate"),
        ValueLayout.JAVA_INT.withName("channels"),
        ValueLayout.JAVA_INT.withName("setupMemoryRequired"),
        ValueLayout.JAVA_INT.withName("setupTempMemoryRequired"),
        ValueLayout.JAVA_INT.withName("tempMemoryRequired"),
        ValueLayout.JAVA_INT.withName("maxFrameSize")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sampleRate = PathElement.groupElement("sampleRate");
    public static final PathElement PATH$channels = PathElement.groupElement("channels");
    public static final PathElement PATH$setupMemoryRequired = PathElement.groupElement("setupMemoryRequired");
    public static final PathElement PATH$setupTempMemoryRequired = PathElement.groupElement("setupTempMemoryRequired");
    public static final PathElement PATH$tempMemoryRequired = PathElement.groupElement("tempMemoryRequired");
    public static final PathElement PATH$maxFrameSize = PathElement.groupElement("maxFrameSize");

    public static final OfInt LAYOUT$sampleRate = (OfInt) LAYOUT.select(PATH$sampleRate);
    public static final OfInt LAYOUT$channels = (OfInt) LAYOUT.select(PATH$channels);
    public static final OfInt LAYOUT$setupMemoryRequired = (OfInt) LAYOUT.select(PATH$setupMemoryRequired);
    public static final OfInt LAYOUT$setupTempMemoryRequired = (OfInt) LAYOUT.select(PATH$setupTempMemoryRequired);
    public static final OfInt LAYOUT$tempMemoryRequired = (OfInt) LAYOUT.select(PATH$tempMemoryRequired);
    public static final OfInt LAYOUT$maxFrameSize = (OfInt) LAYOUT.select(PATH$maxFrameSize);

    public static final long SIZE$sampleRate = LAYOUT$sampleRate.byteSize();
    public static final long SIZE$channels = LAYOUT$channels.byteSize();
    public static final long SIZE$setupMemoryRequired = LAYOUT$setupMemoryRequired.byteSize();
    public static final long SIZE$setupTempMemoryRequired = LAYOUT$setupTempMemoryRequired.byteSize();
    public static final long SIZE$tempMemoryRequired = LAYOUT$tempMemoryRequired.byteSize();
    public static final long SIZE$maxFrameSize = LAYOUT$maxFrameSize.byteSize();

    public static final long OFFSET$sampleRate = LAYOUT.byteOffset(PATH$sampleRate);
    public static final long OFFSET$channels = LAYOUT.byteOffset(PATH$channels);
    public static final long OFFSET$setupMemoryRequired = LAYOUT.byteOffset(PATH$setupMemoryRequired);
    public static final long OFFSET$setupTempMemoryRequired = LAYOUT.byteOffset(PATH$setupTempMemoryRequired);
    public static final long OFFSET$tempMemoryRequired = LAYOUT.byteOffset(PATH$tempMemoryRequired);
    public static final long OFFSET$maxFrameSize = LAYOUT.byteOffset(PATH$maxFrameSize);
}
