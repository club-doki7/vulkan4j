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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineBinaryKeysAndDataKHR.html"><code>VkPipelineBinaryKeysAndDataKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPipelineBinaryKeysAndDataKHR {
///     uint32_t binaryCount; // @link substring="binaryCount" target="#binaryCount"
///     VkPipelineBinaryKeyKHR const* pPipelineBinaryKeys; // @link substring="VkPipelineBinaryKeyKHR" target="VkPipelineBinaryKeyKHR" @link substring="pPipelineBinaryKeys" target="#pPipelineBinaryKeys"
///     VkPipelineBinaryDataKHR const* pPipelineBinaryData; // @link substring="VkPipelineBinaryDataKHR" target="VkPipelineBinaryDataKHR" @link substring="pPipelineBinaryData" target="#pPipelineBinaryData"
/// } VkPipelineBinaryKeysAndDataKHR;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineBinaryKeysAndDataKHR.html"><code>VkPipelineBinaryKeysAndDataKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPipelineBinaryKeysAndDataKHR(@NotNull MemorySegment segment) implements IVkPipelineBinaryKeysAndDataKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineBinaryKeysAndDataKHR.html"><code>VkPipelineBinaryKeysAndDataKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPipelineBinaryKeysAndDataKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPipelineBinaryKeysAndDataKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPipelineBinaryKeysAndDataKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPipelineBinaryKeysAndDataKHR, Iterable<VkPipelineBinaryKeysAndDataKHR> {
        public long size() {
            return segment.byteSize() / VkPipelineBinaryKeysAndDataKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPipelineBinaryKeysAndDataKHR at(long index) {
            return new VkPipelineBinaryKeysAndDataKHR(segment.asSlice(index * VkPipelineBinaryKeysAndDataKHR.BYTES, VkPipelineBinaryKeysAndDataKHR.BYTES));
        }

        public VkPipelineBinaryKeysAndDataKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkPipelineBinaryKeysAndDataKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPipelineBinaryKeysAndDataKHR value) {
            MemorySegment s = segment.asSlice(index * VkPipelineBinaryKeysAndDataKHR.BYTES, VkPipelineBinaryKeysAndDataKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPipelineBinaryKeysAndDataKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPipelineBinaryKeysAndDataKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPipelineBinaryKeysAndDataKHR.BYTES,
                (end - start) * VkPipelineBinaryKeysAndDataKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPipelineBinaryKeysAndDataKHR.BYTES));
        }

        public VkPipelineBinaryKeysAndDataKHR[] toArray() {
            VkPipelineBinaryKeysAndDataKHR[] ret = new VkPipelineBinaryKeysAndDataKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPipelineBinaryKeysAndDataKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPipelineBinaryKeysAndDataKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPipelineBinaryKeysAndDataKHR.BYTES;
            }

            @Override
            public VkPipelineBinaryKeysAndDataKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPipelineBinaryKeysAndDataKHR ret = new VkPipelineBinaryKeysAndDataKHR(segment.asSlice(0, VkPipelineBinaryKeysAndDataKHR.BYTES));
                segment = segment.asSlice(VkPipelineBinaryKeysAndDataKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPipelineBinaryKeysAndDataKHR allocate(Arena arena) {
        return new VkPipelineBinaryKeysAndDataKHR(arena.allocate(LAYOUT));
    }

    public static VkPipelineBinaryKeysAndDataKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkPipelineBinaryKeysAndDataKHR.Ptr(segment);
    }

    public static VkPipelineBinaryKeysAndDataKHR clone(Arena arena, VkPipelineBinaryKeysAndDataKHR src) {
        VkPipelineBinaryKeysAndDataKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned int binaryCount() {
        return segment.get(LAYOUT$binaryCount, OFFSET$binaryCount);
    }

    public VkPipelineBinaryKeysAndDataKHR binaryCount(@Unsigned int value) {
        segment.set(LAYOUT$binaryCount, OFFSET$binaryCount, value);
        return this;
    }

    public VkPipelineBinaryKeysAndDataKHR pPipelineBinaryKeys(@Nullable IVkPipelineBinaryKeyKHR value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pPipelineBinaryKeysRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkPipelineBinaryKeyKHR.Ptr pPipelineBinaryKeys(int assumedCount) {
        MemorySegment s = pPipelineBinaryKeysRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkPipelineBinaryKeyKHR.BYTES);
        return new VkPipelineBinaryKeyKHR.Ptr(s);
    }

    public @Nullable VkPipelineBinaryKeyKHR pPipelineBinaryKeys() {
        MemorySegment s = pPipelineBinaryKeysRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkPipelineBinaryKeyKHR(s);
    }

    public @Pointer(target=VkPipelineBinaryKeyKHR.class) @NotNull MemorySegment pPipelineBinaryKeysRaw() {
        return segment.get(LAYOUT$pPipelineBinaryKeys, OFFSET$pPipelineBinaryKeys);
    }

    public void pPipelineBinaryKeysRaw(@Pointer(target=VkPipelineBinaryKeyKHR.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pPipelineBinaryKeys, OFFSET$pPipelineBinaryKeys, value);
    }

    public VkPipelineBinaryKeysAndDataKHR pPipelineBinaryData(@Nullable IVkPipelineBinaryDataKHR value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pPipelineBinaryDataRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkPipelineBinaryDataKHR.Ptr pPipelineBinaryData(int assumedCount) {
        MemorySegment s = pPipelineBinaryDataRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkPipelineBinaryDataKHR.BYTES);
        return new VkPipelineBinaryDataKHR.Ptr(s);
    }

    public @Nullable VkPipelineBinaryDataKHR pPipelineBinaryData() {
        MemorySegment s = pPipelineBinaryDataRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkPipelineBinaryDataKHR(s);
    }

    public @Pointer(target=VkPipelineBinaryDataKHR.class) @NotNull MemorySegment pPipelineBinaryDataRaw() {
        return segment.get(LAYOUT$pPipelineBinaryData, OFFSET$pPipelineBinaryData);
    }

    public void pPipelineBinaryDataRaw(@Pointer(target=VkPipelineBinaryDataKHR.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pPipelineBinaryData, OFFSET$pPipelineBinaryData, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("binaryCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkPipelineBinaryKeyKHR.LAYOUT).withName("pPipelineBinaryKeys"),
        ValueLayout.ADDRESS.withTargetLayout(VkPipelineBinaryDataKHR.LAYOUT).withName("pPipelineBinaryData")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$binaryCount = PathElement.groupElement("binaryCount");
    public static final PathElement PATH$pPipelineBinaryKeys = PathElement.groupElement("pPipelineBinaryKeys");
    public static final PathElement PATH$pPipelineBinaryData = PathElement.groupElement("pPipelineBinaryData");

    public static final OfInt LAYOUT$binaryCount = (OfInt) LAYOUT.select(PATH$binaryCount);
    public static final AddressLayout LAYOUT$pPipelineBinaryKeys = (AddressLayout) LAYOUT.select(PATH$pPipelineBinaryKeys);
    public static final AddressLayout LAYOUT$pPipelineBinaryData = (AddressLayout) LAYOUT.select(PATH$pPipelineBinaryData);

    public static final long SIZE$binaryCount = LAYOUT$binaryCount.byteSize();
    public static final long SIZE$pPipelineBinaryKeys = LAYOUT$pPipelineBinaryKeys.byteSize();
    public static final long SIZE$pPipelineBinaryData = LAYOUT$pPipelineBinaryData.byteSize();

    public static final long OFFSET$binaryCount = LAYOUT.byteOffset(PATH$binaryCount);
    public static final long OFFSET$pPipelineBinaryKeys = LAYOUT.byteOffset(PATH$pPipelineBinaryKeys);
    public static final long OFFSET$pPipelineBinaryData = LAYOUT.byteOffset(PATH$pPipelineBinaryData);
}
