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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkQueryPoolPerformanceCreateInfoKHR.html"><code>VkQueryPoolPerformanceCreateInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkQueryPoolPerformanceCreateInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t queueFamilyIndex; // @link substring="queueFamilyIndex" target="#queueFamilyIndex"
///     uint32_t counterIndexCount; // @link substring="counterIndexCount" target="#counterIndexCount"
///     uint32_t const* pCounterIndices; // @link substring="pCounterIndices" target="#pCounterIndices"
/// } VkQueryPoolPerformanceCreateInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_QUERY_POOL_PERFORMANCE_CREATE_INFO_KHR`
///
/// The {@code allocate} ({@link VkQueryPoolPerformanceCreateInfoKHR#allocate(Arena)}, {@link VkQueryPoolPerformanceCreateInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkQueryPoolPerformanceCreateInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkQueryPoolPerformanceCreateInfoKHR.html"><code>VkQueryPoolPerformanceCreateInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkQueryPoolPerformanceCreateInfoKHR(@NotNull MemorySegment segment) implements IVkQueryPoolPerformanceCreateInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkQueryPoolPerformanceCreateInfoKHR.html"><code>VkQueryPoolPerformanceCreateInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkQueryPoolPerformanceCreateInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkQueryPoolPerformanceCreateInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkQueryPoolPerformanceCreateInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkQueryPoolPerformanceCreateInfoKHR, Iterable<VkQueryPoolPerformanceCreateInfoKHR> {
        public long size() {
            return segment.byteSize() / VkQueryPoolPerformanceCreateInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkQueryPoolPerformanceCreateInfoKHR at(long index) {
            return new VkQueryPoolPerformanceCreateInfoKHR(segment.asSlice(index * VkQueryPoolPerformanceCreateInfoKHR.BYTES, VkQueryPoolPerformanceCreateInfoKHR.BYTES));
        }

        public VkQueryPoolPerformanceCreateInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkQueryPoolPerformanceCreateInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkQueryPoolPerformanceCreateInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkQueryPoolPerformanceCreateInfoKHR.BYTES, VkQueryPoolPerformanceCreateInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkQueryPoolPerformanceCreateInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkQueryPoolPerformanceCreateInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkQueryPoolPerformanceCreateInfoKHR.BYTES,
                (end - start) * VkQueryPoolPerformanceCreateInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkQueryPoolPerformanceCreateInfoKHR.BYTES));
        }

        public VkQueryPoolPerformanceCreateInfoKHR[] toArray() {
            VkQueryPoolPerformanceCreateInfoKHR[] ret = new VkQueryPoolPerformanceCreateInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkQueryPoolPerformanceCreateInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkQueryPoolPerformanceCreateInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkQueryPoolPerformanceCreateInfoKHR.BYTES;
            }

            @Override
            public VkQueryPoolPerformanceCreateInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkQueryPoolPerformanceCreateInfoKHR ret = new VkQueryPoolPerformanceCreateInfoKHR(segment.asSlice(0, VkQueryPoolPerformanceCreateInfoKHR.BYTES));
                segment = segment.asSlice(VkQueryPoolPerformanceCreateInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkQueryPoolPerformanceCreateInfoKHR allocate(Arena arena) {
        VkQueryPoolPerformanceCreateInfoKHR ret = new VkQueryPoolPerformanceCreateInfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.QUERY_POOL_PERFORMANCE_CREATE_INFO_KHR);
        return ret;
    }

    public static VkQueryPoolPerformanceCreateInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkQueryPoolPerformanceCreateInfoKHR.Ptr ret = new VkQueryPoolPerformanceCreateInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.QUERY_POOL_PERFORMANCE_CREATE_INFO_KHR);
        }
        return ret;
    }

    public static VkQueryPoolPerformanceCreateInfoKHR clone(Arena arena, VkQueryPoolPerformanceCreateInfoKHR src) {
        VkQueryPoolPerformanceCreateInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.QUERY_POOL_PERFORMANCE_CREATE_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkQueryPoolPerformanceCreateInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkQueryPoolPerformanceCreateInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkQueryPoolPerformanceCreateInfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int queueFamilyIndex() {
        return segment.get(LAYOUT$queueFamilyIndex, OFFSET$queueFamilyIndex);
    }

    public VkQueryPoolPerformanceCreateInfoKHR queueFamilyIndex(@Unsigned int value) {
        segment.set(LAYOUT$queueFamilyIndex, OFFSET$queueFamilyIndex, value);
        return this;
    }

    public @Unsigned int counterIndexCount() {
        return segment.get(LAYOUT$counterIndexCount, OFFSET$counterIndexCount);
    }

    public VkQueryPoolPerformanceCreateInfoKHR counterIndexCount(@Unsigned int value) {
        segment.set(LAYOUT$counterIndexCount, OFFSET$counterIndexCount, value);
        return this;
    }

    /// Note: the returned {@link IntPtr} does not have correct
    /// {@link IntPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link IntPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable @Unsigned IntPtr pCounterIndices() {
        MemorySegment s = pCounterIndicesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new IntPtr(s);
    }

    public VkQueryPoolPerformanceCreateInfoKHR pCounterIndices(@Nullable @Unsigned IntPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pCounterIndicesRaw(s);
        return this;
    }

    public @Pointer(comment="uint32_t*") @NotNull MemorySegment pCounterIndicesRaw() {
        return segment.get(LAYOUT$pCounterIndices, OFFSET$pCounterIndices);
    }

    public void pCounterIndicesRaw(@Pointer(comment="uint32_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pCounterIndices, OFFSET$pCounterIndices, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("queueFamilyIndex"),
        ValueLayout.JAVA_INT.withName("counterIndexCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pCounterIndices")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$queueFamilyIndex = PathElement.groupElement("queueFamilyIndex");
    public static final PathElement PATH$counterIndexCount = PathElement.groupElement("counterIndexCount");
    public static final PathElement PATH$pCounterIndices = PathElement.groupElement("pCounterIndices");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$queueFamilyIndex = (OfInt) LAYOUT.select(PATH$queueFamilyIndex);
    public static final OfInt LAYOUT$counterIndexCount = (OfInt) LAYOUT.select(PATH$counterIndexCount);
    public static final AddressLayout LAYOUT$pCounterIndices = (AddressLayout) LAYOUT.select(PATH$pCounterIndices);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$queueFamilyIndex = LAYOUT$queueFamilyIndex.byteSize();
    public static final long SIZE$counterIndexCount = LAYOUT$counterIndexCount.byteSize();
    public static final long SIZE$pCounterIndices = LAYOUT$pCounterIndices.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$queueFamilyIndex = LAYOUT.byteOffset(PATH$queueFamilyIndex);
    public static final long OFFSET$counterIndexCount = LAYOUT.byteOffset(PATH$counterIndexCount);
    public static final long OFFSET$pCounterIndices = LAYOUT.byteOffset(PATH$pCounterIndices);
}
