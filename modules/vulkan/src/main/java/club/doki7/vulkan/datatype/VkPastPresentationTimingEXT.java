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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPastPresentationTimingEXT.html"><code>VkPastPresentationTimingEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPastPresentationTimingEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint64_t presentId; // @link substring="presentId" target="#presentId"
///     uint64_t targetTime; // @link substring="targetTime" target="#targetTime"
///     uint32_t presentStageCount; // @link substring="presentStageCount" target="#presentStageCount"
///     VkPresentStageTimeEXT* pPresentStages; // @link substring="VkPresentStageTimeEXT" target="VkPresentStageTimeEXT" @link substring="pPresentStages" target="#pPresentStages"
///     VkTimeDomainKHR timeDomain; // @link substring="VkTimeDomainKHR" target="VkTimeDomainKHR" @link substring="timeDomain" target="#timeDomain"
///     uint64_t timeDomainId; // @link substring="timeDomainId" target="#timeDomainId"
///     VkBool32 reportComplete; // @link substring="reportComplete" target="#reportComplete"
/// } VkPastPresentationTimingEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PAST_PRESENTATION_TIMING_EXT`
///
/// The {@code allocate} ({@link VkPastPresentationTimingEXT#allocate(Arena)}, {@link VkPastPresentationTimingEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPastPresentationTimingEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPastPresentationTimingEXT.html"><code>VkPastPresentationTimingEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPastPresentationTimingEXT(@NotNull MemorySegment segment) implements IVkPastPresentationTimingEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPastPresentationTimingEXT.html"><code>VkPastPresentationTimingEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPastPresentationTimingEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPastPresentationTimingEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPastPresentationTimingEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPastPresentationTimingEXT, Iterable<VkPastPresentationTimingEXT> {
        public long size() {
            return segment.byteSize() / VkPastPresentationTimingEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPastPresentationTimingEXT at(long index) {
            return new VkPastPresentationTimingEXT(segment.asSlice(index * VkPastPresentationTimingEXT.BYTES, VkPastPresentationTimingEXT.BYTES));
        }

        public VkPastPresentationTimingEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkPastPresentationTimingEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPastPresentationTimingEXT value) {
            MemorySegment s = segment.asSlice(index * VkPastPresentationTimingEXT.BYTES, VkPastPresentationTimingEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPastPresentationTimingEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPastPresentationTimingEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPastPresentationTimingEXT.BYTES,
                (end - start) * VkPastPresentationTimingEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPastPresentationTimingEXT.BYTES));
        }

        public VkPastPresentationTimingEXT[] toArray() {
            VkPastPresentationTimingEXT[] ret = new VkPastPresentationTimingEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPastPresentationTimingEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPastPresentationTimingEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPastPresentationTimingEXT.BYTES;
            }

            @Override
            public VkPastPresentationTimingEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPastPresentationTimingEXT ret = new VkPastPresentationTimingEXT(segment.asSlice(0, VkPastPresentationTimingEXT.BYTES));
                segment = segment.asSlice(VkPastPresentationTimingEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPastPresentationTimingEXT allocate(Arena arena) {
        VkPastPresentationTimingEXT ret = new VkPastPresentationTimingEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PAST_PRESENTATION_TIMING_EXT);
        return ret;
    }

    public static VkPastPresentationTimingEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPastPresentationTimingEXT.Ptr ret = new VkPastPresentationTimingEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PAST_PRESENTATION_TIMING_EXT);
        }
        return ret;
    }

    public static VkPastPresentationTimingEXT clone(Arena arena, VkPastPresentationTimingEXT src) {
        VkPastPresentationTimingEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PAST_PRESENTATION_TIMING_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPastPresentationTimingEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPastPresentationTimingEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPastPresentationTimingEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned long presentId() {
        return segment.get(LAYOUT$presentId, OFFSET$presentId);
    }

    public VkPastPresentationTimingEXT presentId(@Unsigned long value) {
        segment.set(LAYOUT$presentId, OFFSET$presentId, value);
        return this;
    }

    public @Unsigned long targetTime() {
        return segment.get(LAYOUT$targetTime, OFFSET$targetTime);
    }

    public VkPastPresentationTimingEXT targetTime(@Unsigned long value) {
        segment.set(LAYOUT$targetTime, OFFSET$targetTime, value);
        return this;
    }

    public @Unsigned int presentStageCount() {
        return segment.get(LAYOUT$presentStageCount, OFFSET$presentStageCount);
    }

    public VkPastPresentationTimingEXT presentStageCount(@Unsigned int value) {
        segment.set(LAYOUT$presentStageCount, OFFSET$presentStageCount, value);
        return this;
    }

    public VkPastPresentationTimingEXT pPresentStages(@Nullable IVkPresentStageTimeEXT value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pPresentStagesRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkPresentStageTimeEXT.Ptr pPresentStages(int assumedCount) {
        MemorySegment s = pPresentStagesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkPresentStageTimeEXT.BYTES);
        return new VkPresentStageTimeEXT.Ptr(s);
    }

    public @Nullable VkPresentStageTimeEXT pPresentStages() {
        MemorySegment s = pPresentStagesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkPresentStageTimeEXT(s);
    }

    public @Pointer(target=VkPresentStageTimeEXT.class) @NotNull MemorySegment pPresentStagesRaw() {
        return segment.get(LAYOUT$pPresentStages, OFFSET$pPresentStages);
    }

    public void pPresentStagesRaw(@Pointer(target=VkPresentStageTimeEXT.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pPresentStages, OFFSET$pPresentStages, value);
    }

    public @EnumType(VkTimeDomainKHR.class) int timeDomain() {
        return segment.get(LAYOUT$timeDomain, OFFSET$timeDomain);
    }

    public VkPastPresentationTimingEXT timeDomain(@EnumType(VkTimeDomainKHR.class) int value) {
        segment.set(LAYOUT$timeDomain, OFFSET$timeDomain, value);
        return this;
    }

    public @Unsigned long timeDomainId() {
        return segment.get(LAYOUT$timeDomainId, OFFSET$timeDomainId);
    }

    public VkPastPresentationTimingEXT timeDomainId(@Unsigned long value) {
        segment.set(LAYOUT$timeDomainId, OFFSET$timeDomainId, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int reportComplete() {
        return segment.get(LAYOUT$reportComplete, OFFSET$reportComplete);
    }

    public VkPastPresentationTimingEXT reportComplete(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$reportComplete, OFFSET$reportComplete, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_LONG.withName("presentId"),
        ValueLayout.JAVA_LONG.withName("targetTime"),
        ValueLayout.JAVA_INT.withName("presentStageCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkPresentStageTimeEXT.LAYOUT).withName("pPresentStages"),
        ValueLayout.JAVA_INT.withName("timeDomain"),
        ValueLayout.JAVA_LONG.withName("timeDomainId"),
        ValueLayout.JAVA_INT.withName("reportComplete")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$presentId = PathElement.groupElement("presentId");
    public static final PathElement PATH$targetTime = PathElement.groupElement("targetTime");
    public static final PathElement PATH$presentStageCount = PathElement.groupElement("presentStageCount");
    public static final PathElement PATH$pPresentStages = PathElement.groupElement("pPresentStages");
    public static final PathElement PATH$timeDomain = PathElement.groupElement("timeDomain");
    public static final PathElement PATH$timeDomainId = PathElement.groupElement("timeDomainId");
    public static final PathElement PATH$reportComplete = PathElement.groupElement("reportComplete");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfLong LAYOUT$presentId = (OfLong) LAYOUT.select(PATH$presentId);
    public static final OfLong LAYOUT$targetTime = (OfLong) LAYOUT.select(PATH$targetTime);
    public static final OfInt LAYOUT$presentStageCount = (OfInt) LAYOUT.select(PATH$presentStageCount);
    public static final AddressLayout LAYOUT$pPresentStages = (AddressLayout) LAYOUT.select(PATH$pPresentStages);
    public static final OfInt LAYOUT$timeDomain = (OfInt) LAYOUT.select(PATH$timeDomain);
    public static final OfLong LAYOUT$timeDomainId = (OfLong) LAYOUT.select(PATH$timeDomainId);
    public static final OfInt LAYOUT$reportComplete = (OfInt) LAYOUT.select(PATH$reportComplete);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$presentId = LAYOUT$presentId.byteSize();
    public static final long SIZE$targetTime = LAYOUT$targetTime.byteSize();
    public static final long SIZE$presentStageCount = LAYOUT$presentStageCount.byteSize();
    public static final long SIZE$pPresentStages = LAYOUT$pPresentStages.byteSize();
    public static final long SIZE$timeDomain = LAYOUT$timeDomain.byteSize();
    public static final long SIZE$timeDomainId = LAYOUT$timeDomainId.byteSize();
    public static final long SIZE$reportComplete = LAYOUT$reportComplete.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$presentId = LAYOUT.byteOffset(PATH$presentId);
    public static final long OFFSET$targetTime = LAYOUT.byteOffset(PATH$targetTime);
    public static final long OFFSET$presentStageCount = LAYOUT.byteOffset(PATH$presentStageCount);
    public static final long OFFSET$pPresentStages = LAYOUT.byteOffset(PATH$pPresentStages);
    public static final long OFFSET$timeDomain = LAYOUT.byteOffset(PATH$timeDomain);
    public static final long OFFSET$timeDomainId = LAYOUT.byteOffset(PATH$timeDomainId);
    public static final long OFFSET$reportComplete = LAYOUT.byteOffset(PATH$reportComplete);
}
