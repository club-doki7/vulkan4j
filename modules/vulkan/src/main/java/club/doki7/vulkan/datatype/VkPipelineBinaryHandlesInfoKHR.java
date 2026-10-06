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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineBinaryHandlesInfoKHR.html"><code>VkPipelineBinaryHandlesInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPipelineBinaryHandlesInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t pipelineBinaryCount; // @link substring="pipelineBinaryCount" target="#pipelineBinaryCount"
///     VkPipelineBinaryKHR* pPipelineBinaries; // @link substring="VkPipelineBinaryKHR" target="VkPipelineBinaryKHR" @link substring="pPipelineBinaries" target="#pPipelineBinaries"
/// } VkPipelineBinaryHandlesInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PIPELINE_BINARY_HANDLES_INFO_KHR`
///
/// The {@code allocate} ({@link VkPipelineBinaryHandlesInfoKHR#allocate(Arena)}, {@link VkPipelineBinaryHandlesInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPipelineBinaryHandlesInfoKHR#autoInit}
/// to initialize these fields manually for non-allocated instances.
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineBinaryHandlesInfoKHR.html"><code>VkPipelineBinaryHandlesInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPipelineBinaryHandlesInfoKHR(@NotNull MemorySegment segment) implements IVkPipelineBinaryHandlesInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineBinaryHandlesInfoKHR.html"><code>VkPipelineBinaryHandlesInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPipelineBinaryHandlesInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPipelineBinaryHandlesInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPipelineBinaryHandlesInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPipelineBinaryHandlesInfoKHR, Iterable<VkPipelineBinaryHandlesInfoKHR> {
        public long size() {
            return segment.byteSize() / VkPipelineBinaryHandlesInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPipelineBinaryHandlesInfoKHR at(long index) {
            return new VkPipelineBinaryHandlesInfoKHR(segment.asSlice(index * VkPipelineBinaryHandlesInfoKHR.BYTES, VkPipelineBinaryHandlesInfoKHR.BYTES));
        }

        public VkPipelineBinaryHandlesInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkPipelineBinaryHandlesInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPipelineBinaryHandlesInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkPipelineBinaryHandlesInfoKHR.BYTES, VkPipelineBinaryHandlesInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPipelineBinaryHandlesInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPipelineBinaryHandlesInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPipelineBinaryHandlesInfoKHR.BYTES,
                (end - start) * VkPipelineBinaryHandlesInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPipelineBinaryHandlesInfoKHR.BYTES));
        }

        public VkPipelineBinaryHandlesInfoKHR[] toArray() {
            VkPipelineBinaryHandlesInfoKHR[] ret = new VkPipelineBinaryHandlesInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPipelineBinaryHandlesInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPipelineBinaryHandlesInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPipelineBinaryHandlesInfoKHR.BYTES;
            }

            @Override
            public VkPipelineBinaryHandlesInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPipelineBinaryHandlesInfoKHR ret = new VkPipelineBinaryHandlesInfoKHR(segment.asSlice(0, VkPipelineBinaryHandlesInfoKHR.BYTES));
                segment = segment.asSlice(VkPipelineBinaryHandlesInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPipelineBinaryHandlesInfoKHR allocate(Arena arena) {
        VkPipelineBinaryHandlesInfoKHR ret = new VkPipelineBinaryHandlesInfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PIPELINE_BINARY_HANDLES_INFO_KHR);
        return ret;
    }

    public static VkPipelineBinaryHandlesInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPipelineBinaryHandlesInfoKHR.Ptr ret = new VkPipelineBinaryHandlesInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PIPELINE_BINARY_HANDLES_INFO_KHR);
        }
        return ret;
    }

    public static VkPipelineBinaryHandlesInfoKHR clone(Arena arena, VkPipelineBinaryHandlesInfoKHR src) {
        VkPipelineBinaryHandlesInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PIPELINE_BINARY_HANDLES_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPipelineBinaryHandlesInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPipelineBinaryHandlesInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPipelineBinaryHandlesInfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int pipelineBinaryCount() {
        return segment.get(LAYOUT$pipelineBinaryCount, OFFSET$pipelineBinaryCount);
    }

    public VkPipelineBinaryHandlesInfoKHR pipelineBinaryCount(@Unsigned int value) {
        segment.set(LAYOUT$pipelineBinaryCount, OFFSET$pipelineBinaryCount, value);
        return this;
    }

    /// Note: the returned {@link VkPipelineBinaryKHR.Ptr} does not have correct {@link VkPipelineBinaryKHR.Ptr#size}
    /// property. It's up to user to track the size of the buffer, and use
    /// {@link VkPipelineBinaryKHR.Ptr#reinterpret} to set the size before actually reading from or writing to the
    /// buffer.
    public @Nullable VkPipelineBinaryKHR.Ptr pPipelineBinaries() {
        MemorySegment s = pPipelineBinariesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkPipelineBinaryKHR.Ptr(s);
    }

    public VkPipelineBinaryHandlesInfoKHR pPipelineBinaries(@Nullable VkPipelineBinaryKHR.Ptr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pPipelineBinariesRaw(s);
        return this;
    }

    public @Pointer(target=VkPipelineBinaryKHR.class) @NotNull MemorySegment pPipelineBinariesRaw() {
        return segment.get(LAYOUT$pPipelineBinaries, OFFSET$pPipelineBinaries);
    }

    public void pPipelineBinariesRaw(@Pointer(target=VkPipelineBinaryKHR.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pPipelineBinaries, OFFSET$pPipelineBinaries, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("pipelineBinaryCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS).withName("pPipelineBinaries")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$pipelineBinaryCount = PathElement.groupElement("pipelineBinaryCount");
    public static final PathElement PATH$pPipelineBinaries = PathElement.groupElement("pPipelineBinaries");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$pipelineBinaryCount = (OfInt) LAYOUT.select(PATH$pipelineBinaryCount);
    public static final AddressLayout LAYOUT$pPipelineBinaries = (AddressLayout) LAYOUT.select(PATH$pPipelineBinaries);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$pipelineBinaryCount = LAYOUT$pipelineBinaryCount.byteSize();
    public static final long SIZE$pPipelineBinaries = LAYOUT$pPipelineBinaries.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$pipelineBinaryCount = LAYOUT.byteOffset(PATH$pipelineBinaryCount);
    public static final long OFFSET$pPipelineBinaries = LAYOUT.byteOffset(PATH$pPipelineBinaries);
}
