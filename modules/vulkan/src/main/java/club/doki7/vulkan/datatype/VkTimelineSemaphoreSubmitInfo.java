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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkTimelineSemaphoreSubmitInfo.html"><code>VkTimelineSemaphoreSubmitInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkTimelineSemaphoreSubmitInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t waitSemaphoreValueCount; // optional // @link substring="waitSemaphoreValueCount" target="#waitSemaphoreValueCount"
///     uint64_t const* pWaitSemaphoreValues; // optional // @link substring="pWaitSemaphoreValues" target="#pWaitSemaphoreValues"
///     uint32_t signalSemaphoreValueCount; // optional // @link substring="signalSemaphoreValueCount" target="#signalSemaphoreValueCount"
///     uint64_t const* pSignalSemaphoreValues; // optional // @link substring="pSignalSemaphoreValues" target="#pSignalSemaphoreValues"
/// } VkTimelineSemaphoreSubmitInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_TIMELINE_SEMAPHORE_SUBMIT_INFO`
///
/// The {@code allocate} ({@link VkTimelineSemaphoreSubmitInfo#allocate(Arena)}, {@link VkTimelineSemaphoreSubmitInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkTimelineSemaphoreSubmitInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkTimelineSemaphoreSubmitInfo.html"><code>VkTimelineSemaphoreSubmitInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkTimelineSemaphoreSubmitInfo(@NotNull MemorySegment segment) implements IVkTimelineSemaphoreSubmitInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkTimelineSemaphoreSubmitInfo.html"><code>VkTimelineSemaphoreSubmitInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkTimelineSemaphoreSubmitInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkTimelineSemaphoreSubmitInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkTimelineSemaphoreSubmitInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkTimelineSemaphoreSubmitInfo, Iterable<VkTimelineSemaphoreSubmitInfo> {
        public long size() {
            return segment.byteSize() / VkTimelineSemaphoreSubmitInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkTimelineSemaphoreSubmitInfo at(long index) {
            return new VkTimelineSemaphoreSubmitInfo(segment.asSlice(index * VkTimelineSemaphoreSubmitInfo.BYTES, VkTimelineSemaphoreSubmitInfo.BYTES));
        }

        public VkTimelineSemaphoreSubmitInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkTimelineSemaphoreSubmitInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkTimelineSemaphoreSubmitInfo value) {
            MemorySegment s = segment.asSlice(index * VkTimelineSemaphoreSubmitInfo.BYTES, VkTimelineSemaphoreSubmitInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkTimelineSemaphoreSubmitInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkTimelineSemaphoreSubmitInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkTimelineSemaphoreSubmitInfo.BYTES,
                (end - start) * VkTimelineSemaphoreSubmitInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkTimelineSemaphoreSubmitInfo.BYTES));
        }

        public VkTimelineSemaphoreSubmitInfo[] toArray() {
            VkTimelineSemaphoreSubmitInfo[] ret = new VkTimelineSemaphoreSubmitInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkTimelineSemaphoreSubmitInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkTimelineSemaphoreSubmitInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkTimelineSemaphoreSubmitInfo.BYTES;
            }

            @Override
            public VkTimelineSemaphoreSubmitInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkTimelineSemaphoreSubmitInfo ret = new VkTimelineSemaphoreSubmitInfo(segment.asSlice(0, VkTimelineSemaphoreSubmitInfo.BYTES));
                segment = segment.asSlice(VkTimelineSemaphoreSubmitInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkTimelineSemaphoreSubmitInfo allocate(Arena arena) {
        VkTimelineSemaphoreSubmitInfo ret = new VkTimelineSemaphoreSubmitInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.TIMELINE_SEMAPHORE_SUBMIT_INFO);
        return ret;
    }

    public static VkTimelineSemaphoreSubmitInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkTimelineSemaphoreSubmitInfo.Ptr ret = new VkTimelineSemaphoreSubmitInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.TIMELINE_SEMAPHORE_SUBMIT_INFO);
        }
        return ret;
    }

    public static VkTimelineSemaphoreSubmitInfo clone(Arena arena, VkTimelineSemaphoreSubmitInfo src) {
        VkTimelineSemaphoreSubmitInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.TIMELINE_SEMAPHORE_SUBMIT_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkTimelineSemaphoreSubmitInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkTimelineSemaphoreSubmitInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkTimelineSemaphoreSubmitInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int waitSemaphoreValueCount() {
        return segment.get(LAYOUT$waitSemaphoreValueCount, OFFSET$waitSemaphoreValueCount);
    }

    public VkTimelineSemaphoreSubmitInfo waitSemaphoreValueCount(@Unsigned int value) {
        segment.set(LAYOUT$waitSemaphoreValueCount, OFFSET$waitSemaphoreValueCount, value);
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

    public VkTimelineSemaphoreSubmitInfo pWaitSemaphoreValues(@Nullable @Unsigned LongPtr value) {
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

    public @Unsigned int signalSemaphoreValueCount() {
        return segment.get(LAYOUT$signalSemaphoreValueCount, OFFSET$signalSemaphoreValueCount);
    }

    public VkTimelineSemaphoreSubmitInfo signalSemaphoreValueCount(@Unsigned int value) {
        segment.set(LAYOUT$signalSemaphoreValueCount, OFFSET$signalSemaphoreValueCount, value);
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

    public VkTimelineSemaphoreSubmitInfo pSignalSemaphoreValues(@Nullable @Unsigned LongPtr value) {
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
        ValueLayout.JAVA_INT.withName("waitSemaphoreValueCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG).withName("pWaitSemaphoreValues"),
        ValueLayout.JAVA_INT.withName("signalSemaphoreValueCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG).withName("pSignalSemaphoreValues")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$waitSemaphoreValueCount = PathElement.groupElement("waitSemaphoreValueCount");
    public static final PathElement PATH$pWaitSemaphoreValues = PathElement.groupElement("pWaitSemaphoreValues");
    public static final PathElement PATH$signalSemaphoreValueCount = PathElement.groupElement("signalSemaphoreValueCount");
    public static final PathElement PATH$pSignalSemaphoreValues = PathElement.groupElement("pSignalSemaphoreValues");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$waitSemaphoreValueCount = (OfInt) LAYOUT.select(PATH$waitSemaphoreValueCount);
    public static final AddressLayout LAYOUT$pWaitSemaphoreValues = (AddressLayout) LAYOUT.select(PATH$pWaitSemaphoreValues);
    public static final OfInt LAYOUT$signalSemaphoreValueCount = (OfInt) LAYOUT.select(PATH$signalSemaphoreValueCount);
    public static final AddressLayout LAYOUT$pSignalSemaphoreValues = (AddressLayout) LAYOUT.select(PATH$pSignalSemaphoreValues);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$waitSemaphoreValueCount = LAYOUT$waitSemaphoreValueCount.byteSize();
    public static final long SIZE$pWaitSemaphoreValues = LAYOUT$pWaitSemaphoreValues.byteSize();
    public static final long SIZE$signalSemaphoreValueCount = LAYOUT$signalSemaphoreValueCount.byteSize();
    public static final long SIZE$pSignalSemaphoreValues = LAYOUT$pSignalSemaphoreValues.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$waitSemaphoreValueCount = LAYOUT.byteOffset(PATH$waitSemaphoreValueCount);
    public static final long OFFSET$pWaitSemaphoreValues = LAYOUT.byteOffset(PATH$pWaitSemaphoreValues);
    public static final long OFFSET$signalSemaphoreValueCount = LAYOUT.byteOffset(PATH$signalSemaphoreValueCount);
    public static final long OFFSET$pSignalSemaphoreValues = LAYOUT.byteOffset(PATH$pSignalSemaphoreValues);
}
