package club.doki7.ffm.ptr;

import club.doki7.ffm.IPointer;
import club.doki7.ffm.annotation.Unsafe;
import club.doki7.ffm.annotation.UnsafeConstructor;
import club.doki7.ffm.annotation.ValueBasedCandidate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/// Represents a pointer to 32-bit float(s) in native memory
///
/// The property {@link #segment()} should always be not-null
/// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
/// {@link ValueLayout.OfFloat#byteAlignment()} bytes. To represent null pointer, you may use a Java
/// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
///
/// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
/// perform any runtime check. The constructor can be useful for automatic code generators. For
/// normal users, {@link #checked(MemorySegment)} is a good safe alternative.
@ValueBasedCandidate
@UnsafeConstructor
public record FloatPtr(@NotNull MemorySegment segment) implements IPointer, Iterable<Float> {
    public long size() {
        return segment.byteSize() / Float.BYTES;
    }

    public float read() {
        return segment.get(ValueLayout.JAVA_FLOAT, 0);
    }

    public void write(float value) {
        segment.set(ValueLayout.JAVA_FLOAT, 0, value);
    }

    public float read(long index) {
        return segment.get(ValueLayout.JAVA_FLOAT, index * Float.BYTES);
    }

    public void write(long index, float value) {
        segment.set(ValueLayout.JAVA_FLOAT, index * Float.BYTES, value);
    }

    public void write(float @NotNull [] array) {
        segment.copyFrom(MemorySegment.ofArray(array));
    }

    public void writeV(float value0, float @NotNull ...values) {
        write(value0);
        offset(1).write(values);
    }

    /// Assume the {@link FloatPtr} is capable of holding at least {@code newSize} floats, create
    /// a new view {@link FloatPtr} that uses the same backing storage as this {@link FloatPtr}, but
    /// with the new size. Since there is actually no way to really check whether the new size is
    /// valid, while buffer overflow is undefined behavior, this method is marked as {@link Unsafe}.
    ///
    /// This method could be useful when handling data returned from some C API, where the size of
    /// the data is not known in advance.
    ///
    /// If the size of the underlying segment is actually known in advance and correctly set, and
    /// you want to create a shrunk view, you may use {@link #slice(long)} (with validation)
    /// instead.
    @Unsafe
    public @NotNull FloatPtr reinterpret(long newSize) {
        return new FloatPtr(segment.reinterpret(newSize * Float.BYTES));
    }

    public @NotNull FloatPtr offset(long offset) {
        return new FloatPtr(segment.asSlice(offset * Float.BYTES));
    }

    /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
    /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
    /// (offset + newSize). Be careful with the difference.
    public @NotNull FloatPtr slice(long start, long end) {
        return new FloatPtr(segment.asSlice(start * Float.BYTES, (end - start) * Float.BYTES));
    }

    public @NotNull FloatPtr slice(long end) {
        return new FloatPtr(segment.asSlice(0, end * Float.BYTES));
    }

    @Override
    public @NotNull Iterator<Float> iterator() {
        return new Iter(segment);
    }

    /// Create a new {@link FloatPtr} using {@code segment} as backing storage, with argument
    /// validation.
    ///
    /// This function does not ensure {@code segment}'s size to be a multiple of
    /// {@link Float#BYTES}, since that several trailing bytes could be automatically ignored by
    /// {@link #size()} method, and usually these bytes does not interfere with FFI operations. If
    /// {@code segment} is not big enough to hold at least one float, that segment is simply
    /// considered "empty". See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// @param segment the {@link MemorySegment} to use as the backing storage
    /// @return {@code null} if {@code segment} is {@link MemorySegment#NULL},
    /// otherwise a new {@link FloatPtr} that uses {@code segment} as backing storage
    /// @throws IllegalArgumentException if {@code segment} is not native or not properly aligned
    public static @Nullable FloatPtr checked(@NotNull MemorySegment segment) {
        if (segment.equals(MemorySegment.NULL)) {
            return null;
        }

        if (!segment.isNative()) {
            throw new IllegalArgumentException("Segment must be native");
        }

        if (segment.address() % ValueLayout.JAVA_FLOAT.byteAlignment() != 0) {
            throw new IllegalArgumentException("Segment address must be aligned to " + ValueLayout.JAVA_FLOAT.byteAlignment() + " bytes");
        }

        return new FloatPtr(segment);
    }

    /// Create a new {@link FloatPtr} using the same backing storage as {@code buffer}, with
    /// argument validation.
    ///
    /// The main difference between this static method and the {@link #allocate(Arena, FloatBuffer)}
    /// method is that this method does not copy the contents of the {@code buffer} into a newly
    /// allocated {@link MemorySegment}. Instead, the newly created {@link FloatPtr} will use the
    /// same backing storage as {@code buffer}. Thus, modification from one side will be visible on
    /// the other side.
    ///
    /// Be careful with {@link java.nio} buffer types' {@link Buffer#position()} property: only the
    /// "remaining" (from {@link Buffer#position()} to {@link Buffer#limit()}) part of
    /// {@code buffer} will be referred. If you have ever read from {@code buffer}, and you want all
    /// the contents of {@code buffer} to be referred, you may want to call {@link Buffer#rewind()}.
    ///
    /// When handling data types consisting of multiple bytes, also be careful with endianness and
    /// {@link FloatBuffer#order()} property. {@link FloatPtr} always uses the native endianness. So
    /// if {@code buffer} uses a different endianness, you may want to convert it to the native
    /// endianness first.
    ///
    /// @param buffer the {@link FloatBuffer} to use as the backing storage
    /// @return a new {@link FloatPtr} that uses {@code buffer} as its backing storage
    /// @throws IllegalArgumentException if {@code buffer} is not direct, or its backing storage is
    /// not properly aligned
    public static @NotNull FloatPtr checked(@NotNull FloatBuffer buffer) {
        if (!buffer.isDirect()) {
            throw new IllegalArgumentException("Buffer must be direct");
        }

        MemorySegment segment = MemorySegment.ofBuffer(buffer);
        if (segment.address() % ValueLayout.JAVA_FLOAT.byteAlignment() != 0) {
            throw new IllegalArgumentException("Buffer address must be aligned to " + ValueLayout.JAVA_FLOAT.byteAlignment() + " bytes");
        }

        return new FloatPtr(segment);
    }

    public static @NotNull FloatPtr allocate(@NotNull Arena arena) {
        return new FloatPtr(arena.allocate(ValueLayout.JAVA_FLOAT));
    }

    public static @NotNull FloatPtr allocate(@NotNull Arena arena, long size) {
        return new FloatPtr(arena.allocate(ValueLayout.JAVA_FLOAT, size));
    }

    public static @NotNull FloatPtr allocate(@NotNull Arena arena, float @NotNull [] array) {
        return new FloatPtr(arena.allocateFrom(ValueLayout.JAVA_FLOAT, array));
    }

    public static @NotNull FloatPtr allocate(@NotNull Arena arena, Collection<Float> floats) {
        FloatPtr ret = allocate(arena, floats.size());
        int i = 0;
        for (Float f : floats) {
            ret.write(i, f);
            i += 1;
        }
        return ret;
    }

    public static @NotNull FloatPtr allocateV(@NotNull Arena arena, float value0, float ...values) {
        FloatPtr ret = allocate(arena, values.length + 1);
        ret.write(value0);
        ret.offset(1).segment.copyFrom(MemorySegment.ofArray(values));
        return ret;
    }

    /// Allocate a new {@link FloatPtr} in {@code arena} and copy the contents of {@code buffer} into
    /// the newly allocated {@link FloatPtr}.
    ///
    /// Be careful with {@link java.nio} buffer types' {@link Buffer#position()} property: only the
    /// "remaining" (from {@link Buffer#position()} to {@link Buffer#limit()}) part of
    /// {@code buffer} will be copied. If you have ever read from {@code buffer}, and you want all
    /// the contents of {@code buffer} to be copied, you may want to call {@link Buffer#rewind()}.
    ///
    /// When handling data types consisting of multiple bytes, also be careful with endianness and
    /// {@link FloatBuffer#order()} property. {@link FloatPtr} always uses the native endianness. So
    /// if {@code buffer} uses a different endianness, you may want to convert it to the native
    /// endianness first.
    ///
    /// @param arena the {@link Arena} to allocate the new {@link FloatPtr} in
    /// @param buffer the {@link FloatBuffer} to copy the contents from
    /// @return a new {@link FloatPtr} that contains the contents of {@code buffer}
    public static @NotNull FloatPtr allocate(@NotNull Arena arena, @NotNull FloatBuffer buffer) {
        var s = arena.allocate(ValueLayout.JAVA_FLOAT, buffer.remaining());
        s.copyFrom(MemorySegment.ofBuffer(buffer));
        return new FloatPtr(s);
    }

    /// An iterator over the float numbers.
    private static final class Iter implements Iterator<Float> {
        Iter(@NotNull MemorySegment segment) {
            this.segment = segment;
        }

        @Override
        public boolean hasNext() {
            return segment.byteSize() >= Float.BYTES;
        }

        @Override
        public Float next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more floats to read");
            }
            float value = segment.get(ValueLayout.JAVA_FLOAT, 0);
            segment = segment.asSlice(Float.BYTES);
            return value;
        }

        private @NotNull MemorySegment segment;
    }
}
