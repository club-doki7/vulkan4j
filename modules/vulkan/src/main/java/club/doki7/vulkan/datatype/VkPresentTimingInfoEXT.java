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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPresentTimingInfoEXT.html"><code>VkPresentTimingInfoEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPresentTimingInfoEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkPresentTimingInfoFlagsEXT flags; // optional // @link substring="VkPresentTimingInfoFlagsEXT" target="VkPresentTimingInfoFlagsEXT" @link substring="flags" target="#flags"
///     uint64_t targetTime; // @link substring="targetTime" target="#targetTime"
///     uint64_t timeDomainId; // @link substring="timeDomainId" target="#timeDomainId"
///     VkPresentStageFlagsEXT presentStageQueries; // optional // @link substring="VkPresentStageFlagsEXT" target="VkPresentStageFlagsEXT" @link substring="presentStageQueries" target="#presentStageQueries"
///     VkPresentStageFlagsEXT targetTimeDomainPresentStage; // optional // @link substring="VkPresentStageFlagsEXT" target="VkPresentStageFlagsEXT" @link substring="targetTimeDomainPresentStage" target="#targetTimeDomainPresentStage"
/// } VkPresentTimingInfoEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PRESENT_TIMING_INFO_EXT`
///
/// The {@code allocate} ({@link VkPresentTimingInfoEXT#allocate(Arena)}, {@link VkPresentTimingInfoEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPresentTimingInfoEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPresentTimingInfoEXT.html"><code>VkPresentTimingInfoEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPresentTimingInfoEXT(@NotNull MemorySegment segment) implements IVkPresentTimingInfoEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPresentTimingInfoEXT.html"><code>VkPresentTimingInfoEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPresentTimingInfoEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPresentTimingInfoEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPresentTimingInfoEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPresentTimingInfoEXT, Iterable<VkPresentTimingInfoEXT> {
        public long size() {
            return segment.byteSize() / VkPresentTimingInfoEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPresentTimingInfoEXT at(long index) {
            return new VkPresentTimingInfoEXT(segment.asSlice(index * VkPresentTimingInfoEXT.BYTES, VkPresentTimingInfoEXT.BYTES));
        }

        public VkPresentTimingInfoEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkPresentTimingInfoEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPresentTimingInfoEXT value) {
            MemorySegment s = segment.asSlice(index * VkPresentTimingInfoEXT.BYTES, VkPresentTimingInfoEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPresentTimingInfoEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPresentTimingInfoEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPresentTimingInfoEXT.BYTES,
                (end - start) * VkPresentTimingInfoEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPresentTimingInfoEXT.BYTES));
        }

        public VkPresentTimingInfoEXT[] toArray() {
            VkPresentTimingInfoEXT[] ret = new VkPresentTimingInfoEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPresentTimingInfoEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPresentTimingInfoEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPresentTimingInfoEXT.BYTES;
            }

            @Override
            public VkPresentTimingInfoEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPresentTimingInfoEXT ret = new VkPresentTimingInfoEXT(segment.asSlice(0, VkPresentTimingInfoEXT.BYTES));
                segment = segment.asSlice(VkPresentTimingInfoEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPresentTimingInfoEXT allocate(Arena arena) {
        VkPresentTimingInfoEXT ret = new VkPresentTimingInfoEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PRESENT_TIMING_INFO_EXT);
        return ret;
    }

    public static VkPresentTimingInfoEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPresentTimingInfoEXT.Ptr ret = new VkPresentTimingInfoEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PRESENT_TIMING_INFO_EXT);
        }
        return ret;
    }

    public static VkPresentTimingInfoEXT clone(Arena arena, VkPresentTimingInfoEXT src) {
        VkPresentTimingInfoEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PRESENT_TIMING_INFO_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPresentTimingInfoEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPresentTimingInfoEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPresentTimingInfoEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkPresentTimingInfoFlagsEXT.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkPresentTimingInfoEXT flags(@Bitmask(VkPresentTimingInfoFlagsEXT.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @Unsigned long targetTime() {
        return segment.get(LAYOUT$targetTime, OFFSET$targetTime);
    }

    public VkPresentTimingInfoEXT targetTime(@Unsigned long value) {
        segment.set(LAYOUT$targetTime, OFFSET$targetTime, value);
        return this;
    }

    public @Unsigned long timeDomainId() {
        return segment.get(LAYOUT$timeDomainId, OFFSET$timeDomainId);
    }

    public VkPresentTimingInfoEXT timeDomainId(@Unsigned long value) {
        segment.set(LAYOUT$timeDomainId, OFFSET$timeDomainId, value);
        return this;
    }

    public @Bitmask(VkPresentStageFlagsEXT.class) int presentStageQueries() {
        return segment.get(LAYOUT$presentStageQueries, OFFSET$presentStageQueries);
    }

    public VkPresentTimingInfoEXT presentStageQueries(@Bitmask(VkPresentStageFlagsEXT.class) int value) {
        segment.set(LAYOUT$presentStageQueries, OFFSET$presentStageQueries, value);
        return this;
    }

    public @Bitmask(VkPresentStageFlagsEXT.class) int targetTimeDomainPresentStage() {
        return segment.get(LAYOUT$targetTimeDomainPresentStage, OFFSET$targetTimeDomainPresentStage);
    }

    public VkPresentTimingInfoEXT targetTimeDomainPresentStage(@Bitmask(VkPresentStageFlagsEXT.class) int value) {
        segment.set(LAYOUT$targetTimeDomainPresentStage, OFFSET$targetTimeDomainPresentStage, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_LONG.withName("targetTime"),
        ValueLayout.JAVA_LONG.withName("timeDomainId"),
        ValueLayout.JAVA_INT.withName("presentStageQueries"),
        ValueLayout.JAVA_INT.withName("targetTimeDomainPresentStage")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$targetTime = PathElement.groupElement("targetTime");
    public static final PathElement PATH$timeDomainId = PathElement.groupElement("timeDomainId");
    public static final PathElement PATH$presentStageQueries = PathElement.groupElement("presentStageQueries");
    public static final PathElement PATH$targetTimeDomainPresentStage = PathElement.groupElement("targetTimeDomainPresentStage");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfLong LAYOUT$targetTime = (OfLong) LAYOUT.select(PATH$targetTime);
    public static final OfLong LAYOUT$timeDomainId = (OfLong) LAYOUT.select(PATH$timeDomainId);
    public static final OfInt LAYOUT$presentStageQueries = (OfInt) LAYOUT.select(PATH$presentStageQueries);
    public static final OfInt LAYOUT$targetTimeDomainPresentStage = (OfInt) LAYOUT.select(PATH$targetTimeDomainPresentStage);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$targetTime = LAYOUT$targetTime.byteSize();
    public static final long SIZE$timeDomainId = LAYOUT$timeDomainId.byteSize();
    public static final long SIZE$presentStageQueries = LAYOUT$presentStageQueries.byteSize();
    public static final long SIZE$targetTimeDomainPresentStage = LAYOUT$targetTimeDomainPresentStage.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$targetTime = LAYOUT.byteOffset(PATH$targetTime);
    public static final long OFFSET$timeDomainId = LAYOUT.byteOffset(PATH$timeDomainId);
    public static final long OFFSET$presentStageQueries = LAYOUT.byteOffset(PATH$presentStageQueries);
    public static final long OFFSET$targetTimeDomainPresentStage = LAYOUT.byteOffset(PATH$targetTimeDomainPresentStage);
}
