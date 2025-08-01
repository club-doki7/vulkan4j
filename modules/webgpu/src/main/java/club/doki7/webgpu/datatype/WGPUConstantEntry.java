package club.doki7.webgpu.datatype;

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
import club.doki7.webgpu.bitmask.*;
import club.doki7.webgpu.handle.*;
import club.doki7.webgpu.enumtype.*;
import static club.doki7.webgpu.WGPUConstants.*;
import club.doki7.webgpu.WGPUFunctionTypes.*;

/// Represents a pointer to a {@code WGPUConstantEntry} structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct WGPUConstantEntry {
///     WGPUChainedStruct const* nextInChain; // optional // @link substring="WGPUChainedStruct" target="WGPUChainedStruct" @link substring="nextInChain" target="#nextInChain"
///     WGPUStringView key; // @link substring="WGPUStringView" target="WGPUStringView" @link substring="key" target="#key"
///     double value; // @link substring="value" target="#value"
/// } WGPUConstantEntry;
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
public record WGPUConstantEntry(@NotNull MemorySegment segment) implements IWGPUConstantEntry {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link WGPUConstantEntry}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IWGPUConstantEntry to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code WGPUConstantEntry.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IWGPUConstantEntry, Iterable<WGPUConstantEntry> {
        public long size() {
            return segment.byteSize() / WGPUConstantEntry.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull WGPUConstantEntry at(long index) {
            return new WGPUConstantEntry(segment.asSlice(index * WGPUConstantEntry.BYTES, WGPUConstantEntry.BYTES));
        }

        public WGPUConstantEntry.Ptr at(long index, @NotNull Consumer<@NotNull WGPUConstantEntry> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull WGPUConstantEntry value) {
            MemorySegment s = segment.asSlice(index * WGPUConstantEntry.BYTES, WGPUConstantEntry.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * WGPUConstantEntry.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * WGPUConstantEntry.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * WGPUConstantEntry.BYTES,
                (end - start) * WGPUConstantEntry.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * WGPUConstantEntry.BYTES));
        }

        public WGPUConstantEntry[] toArray() {
            WGPUConstantEntry[] ret = new WGPUConstantEntry[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<WGPUConstantEntry> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<WGPUConstantEntry> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= WGPUConstantEntry.BYTES;
            }

            @Override
            public WGPUConstantEntry next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                WGPUConstantEntry ret = new WGPUConstantEntry(segment.asSlice(0, WGPUConstantEntry.BYTES));
                segment = segment.asSlice(WGPUConstantEntry.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static WGPUConstantEntry allocate(Arena arena) {
        return new WGPUConstantEntry(arena.allocate(LAYOUT));
    }

    public static WGPUConstantEntry.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new WGPUConstantEntry.Ptr(segment);
    }

    public static WGPUConstantEntry clone(Arena arena, WGPUConstantEntry src) {
        WGPUConstantEntry ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public WGPUConstantEntry nextInChain(@Nullable IWGPUChainedStruct value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        nextInChainRaw(s);
        return this;
    }

    @Unsafe public @Nullable WGPUChainedStruct.Ptr nextInChain(int assumedCount) {
        MemorySegment s = nextInChainRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * WGPUChainedStruct.BYTES);
        return new WGPUChainedStruct.Ptr(s);
    }

    public @Nullable WGPUChainedStruct nextInChain() {
        MemorySegment s = nextInChainRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new WGPUChainedStruct(s);
    }

    public @Pointer(target=WGPUChainedStruct.class) @NotNull MemorySegment nextInChainRaw() {
        return segment.get(LAYOUT$nextInChain, OFFSET$nextInChain);
    }

    public void nextInChainRaw(@Pointer(target=WGPUChainedStruct.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$nextInChain, OFFSET$nextInChain, value);
    }

    public @NotNull WGPUStringView key() {
        return new WGPUStringView(segment.asSlice(OFFSET$key, LAYOUT$key));
    }

    public WGPUConstantEntry key(@NotNull WGPUStringView value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$key, SIZE$key);
        return this;
    }

    public WGPUConstantEntry key(Consumer<@NotNull WGPUStringView> consumer) {
        consumer.accept(key());
        return this;
    }

    public double value() {
        return segment.get(LAYOUT$value, OFFSET$value);
    }

    public WGPUConstantEntry value(double value) {
        segment.set(LAYOUT$value, OFFSET$value, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.ADDRESS.withTargetLayout(WGPUChainedStruct.LAYOUT).withName("nextInChain"),
        WGPUStringView.LAYOUT.withName("key"),
        ValueLayout.JAVA_DOUBLE.withName("value")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$nextInChain = PathElement.groupElement("nextInChain");
    public static final PathElement PATH$key = PathElement.groupElement("key");
    public static final PathElement PATH$value = PathElement.groupElement("value");

    public static final AddressLayout LAYOUT$nextInChain = (AddressLayout) LAYOUT.select(PATH$nextInChain);
    public static final StructLayout LAYOUT$key = (StructLayout) LAYOUT.select(PATH$key);
    public static final OfDouble LAYOUT$value = (OfDouble) LAYOUT.select(PATH$value);

    public static final long SIZE$nextInChain = LAYOUT$nextInChain.byteSize();
    public static final long SIZE$key = LAYOUT$key.byteSize();
    public static final long SIZE$value = LAYOUT$value.byteSize();

    public static final long OFFSET$nextInChain = LAYOUT.byteOffset(PATH$nextInChain);
    public static final long OFFSET$key = LAYOUT.byteOffset(PATH$key);
    public static final long OFFSET$value = LAYOUT.byteOffset(PATH$value);
}
