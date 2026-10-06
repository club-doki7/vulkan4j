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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineBinaryDataKHR.html"><code>VkPipelineBinaryDataKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPipelineBinaryDataKHR {
///     size_t dataSize; // @link substring="dataSize" target="#dataSize"
///     void* pData; // @link substring="pData" target="#pData"
/// } VkPipelineBinaryDataKHR;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineBinaryDataKHR.html"><code>VkPipelineBinaryDataKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPipelineBinaryDataKHR(@NotNull MemorySegment segment) implements IVkPipelineBinaryDataKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineBinaryDataKHR.html"><code>VkPipelineBinaryDataKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPipelineBinaryDataKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPipelineBinaryDataKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPipelineBinaryDataKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPipelineBinaryDataKHR, Iterable<VkPipelineBinaryDataKHR> {
        public long size() {
            return segment.byteSize() / VkPipelineBinaryDataKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPipelineBinaryDataKHR at(long index) {
            return new VkPipelineBinaryDataKHR(segment.asSlice(index * VkPipelineBinaryDataKHR.BYTES, VkPipelineBinaryDataKHR.BYTES));
        }

        public VkPipelineBinaryDataKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkPipelineBinaryDataKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPipelineBinaryDataKHR value) {
            MemorySegment s = segment.asSlice(index * VkPipelineBinaryDataKHR.BYTES, VkPipelineBinaryDataKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPipelineBinaryDataKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPipelineBinaryDataKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPipelineBinaryDataKHR.BYTES,
                (end - start) * VkPipelineBinaryDataKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPipelineBinaryDataKHR.BYTES));
        }

        public VkPipelineBinaryDataKHR[] toArray() {
            VkPipelineBinaryDataKHR[] ret = new VkPipelineBinaryDataKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPipelineBinaryDataKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPipelineBinaryDataKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPipelineBinaryDataKHR.BYTES;
            }

            @Override
            public VkPipelineBinaryDataKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPipelineBinaryDataKHR ret = new VkPipelineBinaryDataKHR(segment.asSlice(0, VkPipelineBinaryDataKHR.BYTES));
                segment = segment.asSlice(VkPipelineBinaryDataKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPipelineBinaryDataKHR allocate(Arena arena) {
        return new VkPipelineBinaryDataKHR(arena.allocate(LAYOUT));
    }

    public static VkPipelineBinaryDataKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkPipelineBinaryDataKHR.Ptr(segment);
    }

    public static VkPipelineBinaryDataKHR clone(Arena arena, VkPipelineBinaryDataKHR src) {
        VkPipelineBinaryDataKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned long dataSize() {
        return NativeLayout.readCSizeT(segment, OFFSET$dataSize);
    }

    public VkPipelineBinaryDataKHR dataSize(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$dataSize, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pData() {
        return segment.get(LAYOUT$pData, OFFSET$pData);
    }

    public VkPipelineBinaryDataKHR pData(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pData, OFFSET$pData, value);
        return this;
    }

    public VkPipelineBinaryDataKHR pData(@Nullable IPointer pointer) {
        pData(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        NativeLayout.C_SIZE_T.withName("dataSize"),
        ValueLayout.ADDRESS.withName("pData")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$dataSize = PathElement.groupElement("dataSize");
    public static final PathElement PATH$pData = PathElement.groupElement("pData");

    public static final AddressLayout LAYOUT$pData = (AddressLayout) LAYOUT.select(PATH$pData);

    public static final long SIZE$dataSize = NativeLayout.C_SIZE_T.byteSize();
    public static final long SIZE$pData = LAYOUT$pData.byteSize();

    public static final long OFFSET$dataSize = LAYOUT.byteOffset(PATH$dataSize);
    public static final long OFFSET$pData = LAYOUT.byteOffset(PATH$pData);
}
