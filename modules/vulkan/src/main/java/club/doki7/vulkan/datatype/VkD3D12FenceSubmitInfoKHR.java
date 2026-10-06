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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkD3D12FenceSubmitInfoKHR.html"><code>VkD3D12FenceSubmitInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkD3D12FenceSubmitInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t waitSemaphoreValuesCount; // optional // @link substring="waitSemaphoreValuesCount" target="#waitSemaphoreValuesCount"
///     uint64_t const* pWaitSemaphoreValues; // optional // @link substring="pWaitSemaphoreValues" target="#pWaitSemaphoreValues"
///     uint32_t signalSemaphoreValuesCount; // optional // @link substring="signalSemaphoreValuesCount" target="#signalSemaphoreValuesCount"
///     uint64_t const* pSignalSemaphoreValues; // optional // @link substring="pSignalSemaphoreValues" target="#pSignalSemaphoreValues"
/// } VkD3D12FenceSubmitInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_D3D12_FENCE_SUBMIT_INFO_KHR`
///
/// The {@code allocate} ({@link VkD3D12FenceSubmitInfoKHR#allocate(Arena)}, {@link VkD3D12FenceSubmitInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkD3D12FenceSubmitInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkD3D12FenceSubmitInfoKHR.html"><code>VkD3D12FenceSubmitInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkD3D12FenceSubmitInfoKHR(@NotNull MemorySegment segment) implements IVkD3D12FenceSubmitInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkD3D12FenceSubmitInfoKHR.html"><code>VkD3D12FenceSubmitInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkD3D12FenceSubmitInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkD3D12FenceSubmitInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkD3D12FenceSubmitInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkD3D12FenceSubmitInfoKHR, Iterable<VkD3D12FenceSubmitInfoKHR> {
        public long size() {
            return segment.byteSize() / VkD3D12FenceSubmitInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkD3D12FenceSubmitInfoKHR at(long index) {
            return new VkD3D12FenceSubmitInfoKHR(segment.asSlice(index * VkD3D12FenceSubmitInfoKHR.BYTES, VkD3D12FenceSubmitInfoKHR.BYTES));
        }

        public VkD3D12FenceSubmitInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkD3D12FenceSubmitInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkD3D12FenceSubmitInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkD3D12FenceSubmitInfoKHR.BYTES, VkD3D12FenceSubmitInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkD3D12FenceSubmitInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkD3D12FenceSubmitInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkD3D12FenceSubmitInfoKHR.BYTES,
                (end - start) * VkD3D12FenceSubmitInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkD3D12FenceSubmitInfoKHR.BYTES));
        }

        public VkD3D12FenceSubmitInfoKHR[] toArray() {
            VkD3D12FenceSubmitInfoKHR[] ret = new VkD3D12FenceSubmitInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkD3D12FenceSubmitInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkD3D12FenceSubmitInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkD3D12FenceSubmitInfoKHR.BYTES;
            }

            @Override
            public VkD3D12FenceSubmitInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkD3D12FenceSubmitInfoKHR ret = new VkD3D12FenceSubmitInfoKHR(segment.asSlice(0, VkD3D12FenceSubmitInfoKHR.BYTES));
                segment = segment.asSlice(VkD3D12FenceSubmitInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkD3D12FenceSubmitInfoKHR allocate(Arena arena) {
        VkD3D12FenceSubmitInfoKHR ret = new VkD3D12FenceSubmitInfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.D3D12_FENCE_SUBMIT_INFO_KHR);
        return ret;
    }

    public static VkD3D12FenceSubmitInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkD3D12FenceSubmitInfoKHR.Ptr ret = new VkD3D12FenceSubmitInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.D3D12_FENCE_SUBMIT_INFO_KHR);
        }
        return ret;
    }

    public static VkD3D12FenceSubmitInfoKHR clone(Arena arena, VkD3D12FenceSubmitInfoKHR src) {
        VkD3D12FenceSubmitInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.D3D12_FENCE_SUBMIT_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkD3D12FenceSubmitInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkD3D12FenceSubmitInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkD3D12FenceSubmitInfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int waitSemaphoreValuesCount() {
        return segment.get(LAYOUT$waitSemaphoreValuesCount, OFFSET$waitSemaphoreValuesCount);
    }

    public VkD3D12FenceSubmitInfoKHR waitSemaphoreValuesCount(@Unsigned int value) {
        segment.set(LAYOUT$waitSemaphoreValuesCount, OFFSET$waitSemaphoreValuesCount, value);
        return this;
    }

    /// Note: the returned {@link LongPtr} does not have correct
    /// {@link LongPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link LongPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable @Unsigned LongPtr pWaitSemaphoreValues() {
        MemorySegment s = pWaitSemaphoreValuesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new LongPtr(s);
    }

    public VkD3D12FenceSubmitInfoKHR pWaitSemaphoreValues(@Nullable @Unsigned LongPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pWaitSemaphoreValuesRaw(s);
        return this;
    }

    public @Pointer(comment="uint64_t*") @NotNull MemorySegment pWaitSemaphoreValuesRaw() {
        return segment.get(LAYOUT$pWaitSemaphoreValues, OFFSET$pWaitSemaphoreValues);
    }

    public void pWaitSemaphoreValuesRaw(@Pointer(comment="uint64_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pWaitSemaphoreValues, OFFSET$pWaitSemaphoreValues, value);
    }

    public @Unsigned int signalSemaphoreValuesCount() {
        return segment.get(LAYOUT$signalSemaphoreValuesCount, OFFSET$signalSemaphoreValuesCount);
    }

    public VkD3D12FenceSubmitInfoKHR signalSemaphoreValuesCount(@Unsigned int value) {
        segment.set(LAYOUT$signalSemaphoreValuesCount, OFFSET$signalSemaphoreValuesCount, value);
        return this;
    }

    /// Note: the returned {@link LongPtr} does not have correct
    /// {@link LongPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link LongPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable @Unsigned LongPtr pSignalSemaphoreValues() {
        MemorySegment s = pSignalSemaphoreValuesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new LongPtr(s);
    }

    public VkD3D12FenceSubmitInfoKHR pSignalSemaphoreValues(@Nullable @Unsigned LongPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pSignalSemaphoreValuesRaw(s);
        return this;
    }

    public @Pointer(comment="uint64_t*") @NotNull MemorySegment pSignalSemaphoreValuesRaw() {
        return segment.get(LAYOUT$pSignalSemaphoreValues, OFFSET$pSignalSemaphoreValues);
    }

    public void pSignalSemaphoreValuesRaw(@Pointer(comment="uint64_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pSignalSemaphoreValues, OFFSET$pSignalSemaphoreValues, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("waitSemaphoreValuesCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG).withName("pWaitSemaphoreValues"),
        ValueLayout.JAVA_INT.withName("signalSemaphoreValuesCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG).withName("pSignalSemaphoreValues")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$waitSemaphoreValuesCount = PathElement.groupElement("waitSemaphoreValuesCount");
    public static final PathElement PATH$pWaitSemaphoreValues = PathElement.groupElement("pWaitSemaphoreValues");
    public static final PathElement PATH$signalSemaphoreValuesCount = PathElement.groupElement("signalSemaphoreValuesCount");
    public static final PathElement PATH$pSignalSemaphoreValues = PathElement.groupElement("pSignalSemaphoreValues");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$waitSemaphoreValuesCount = (OfInt) LAYOUT.select(PATH$waitSemaphoreValuesCount);
    public static final AddressLayout LAYOUT$pWaitSemaphoreValues = (AddressLayout) LAYOUT.select(PATH$pWaitSemaphoreValues);
    public static final OfInt LAYOUT$signalSemaphoreValuesCount = (OfInt) LAYOUT.select(PATH$signalSemaphoreValuesCount);
    public static final AddressLayout LAYOUT$pSignalSemaphoreValues = (AddressLayout) LAYOUT.select(PATH$pSignalSemaphoreValues);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$waitSemaphoreValuesCount = LAYOUT$waitSemaphoreValuesCount.byteSize();
    public static final long SIZE$pWaitSemaphoreValues = LAYOUT$pWaitSemaphoreValues.byteSize();
    public static final long SIZE$signalSemaphoreValuesCount = LAYOUT$signalSemaphoreValuesCount.byteSize();
    public static final long SIZE$pSignalSemaphoreValues = LAYOUT$pSignalSemaphoreValues.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$waitSemaphoreValuesCount = LAYOUT.byteOffset(PATH$waitSemaphoreValuesCount);
    public static final long OFFSET$pWaitSemaphoreValues = LAYOUT.byteOffset(PATH$pWaitSemaphoreValues);
    public static final long OFFSET$signalSemaphoreValuesCount = LAYOUT.byteOffset(PATH$signalSemaphoreValuesCount);
    public static final long OFFSET$pSignalSemaphoreValues = LAYOUT.byteOffset(PATH$pSignalSemaphoreValues);
}
