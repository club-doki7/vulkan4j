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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeH265QualityLevelPropertiesKHR.html"><code>VkVideoEncodeH265QualityLevelPropertiesKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkVideoEncodeH265QualityLevelPropertiesKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkVideoEncodeH265RateControlFlagsKHR preferredRateControlFlags; // @link substring="VkVideoEncodeH265RateControlFlagsKHR" target="VkVideoEncodeH265RateControlFlagsKHR" @link substring="preferredRateControlFlags" target="#preferredRateControlFlags"
///     uint32_t preferredGopFrameCount; // @link substring="preferredGopFrameCount" target="#preferredGopFrameCount"
///     uint32_t preferredIdrPeriod; // @link substring="preferredIdrPeriod" target="#preferredIdrPeriod"
///     uint32_t preferredConsecutiveBFrameCount; // @link substring="preferredConsecutiveBFrameCount" target="#preferredConsecutiveBFrameCount"
///     uint32_t preferredSubLayerCount; // @link substring="preferredSubLayerCount" target="#preferredSubLayerCount"
///     VkVideoEncodeH265QpKHR preferredConstantQp; // @link substring="VkVideoEncodeH265QpKHR" target="VkVideoEncodeH265QpKHR" @link substring="preferredConstantQp" target="#preferredConstantQp"
///     uint32_t preferredMaxL0ReferenceCount; // @link substring="preferredMaxL0ReferenceCount" target="#preferredMaxL0ReferenceCount"
///     uint32_t preferredMaxL1ReferenceCount; // @link substring="preferredMaxL1ReferenceCount" target="#preferredMaxL1ReferenceCount"
/// } VkVideoEncodeH265QualityLevelPropertiesKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_VIDEO_ENCODE_H265_QUALITY_LEVEL_PROPERTIES_KHR`
///
/// The {@code allocate} ({@link VkVideoEncodeH265QualityLevelPropertiesKHR#allocate(Arena)}, {@link VkVideoEncodeH265QualityLevelPropertiesKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkVideoEncodeH265QualityLevelPropertiesKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeH265QualityLevelPropertiesKHR.html"><code>VkVideoEncodeH265QualityLevelPropertiesKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkVideoEncodeH265QualityLevelPropertiesKHR(@NotNull MemorySegment segment) implements IVkVideoEncodeH265QualityLevelPropertiesKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeH265QualityLevelPropertiesKHR.html"><code>VkVideoEncodeH265QualityLevelPropertiesKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkVideoEncodeH265QualityLevelPropertiesKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkVideoEncodeH265QualityLevelPropertiesKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkVideoEncodeH265QualityLevelPropertiesKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkVideoEncodeH265QualityLevelPropertiesKHR, Iterable<VkVideoEncodeH265QualityLevelPropertiesKHR> {
        public long size() {
            return segment.byteSize() / VkVideoEncodeH265QualityLevelPropertiesKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkVideoEncodeH265QualityLevelPropertiesKHR at(long index) {
            return new VkVideoEncodeH265QualityLevelPropertiesKHR(segment.asSlice(index * VkVideoEncodeH265QualityLevelPropertiesKHR.BYTES, VkVideoEncodeH265QualityLevelPropertiesKHR.BYTES));
        }

        public VkVideoEncodeH265QualityLevelPropertiesKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkVideoEncodeH265QualityLevelPropertiesKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkVideoEncodeH265QualityLevelPropertiesKHR value) {
            MemorySegment s = segment.asSlice(index * VkVideoEncodeH265QualityLevelPropertiesKHR.BYTES, VkVideoEncodeH265QualityLevelPropertiesKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkVideoEncodeH265QualityLevelPropertiesKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkVideoEncodeH265QualityLevelPropertiesKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkVideoEncodeH265QualityLevelPropertiesKHR.BYTES,
                (end - start) * VkVideoEncodeH265QualityLevelPropertiesKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkVideoEncodeH265QualityLevelPropertiesKHR.BYTES));
        }

        public VkVideoEncodeH265QualityLevelPropertiesKHR[] toArray() {
            VkVideoEncodeH265QualityLevelPropertiesKHR[] ret = new VkVideoEncodeH265QualityLevelPropertiesKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkVideoEncodeH265QualityLevelPropertiesKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkVideoEncodeH265QualityLevelPropertiesKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkVideoEncodeH265QualityLevelPropertiesKHR.BYTES;
            }

            @Override
            public VkVideoEncodeH265QualityLevelPropertiesKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkVideoEncodeH265QualityLevelPropertiesKHR ret = new VkVideoEncodeH265QualityLevelPropertiesKHR(segment.asSlice(0, VkVideoEncodeH265QualityLevelPropertiesKHR.BYTES));
                segment = segment.asSlice(VkVideoEncodeH265QualityLevelPropertiesKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkVideoEncodeH265QualityLevelPropertiesKHR allocate(Arena arena) {
        VkVideoEncodeH265QualityLevelPropertiesKHR ret = new VkVideoEncodeH265QualityLevelPropertiesKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.VIDEO_ENCODE_H265_QUALITY_LEVEL_PROPERTIES_KHR);
        return ret;
    }

    public static VkVideoEncodeH265QualityLevelPropertiesKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkVideoEncodeH265QualityLevelPropertiesKHR.Ptr ret = new VkVideoEncodeH265QualityLevelPropertiesKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.VIDEO_ENCODE_H265_QUALITY_LEVEL_PROPERTIES_KHR);
        }
        return ret;
    }

    public static VkVideoEncodeH265QualityLevelPropertiesKHR clone(Arena arena, VkVideoEncodeH265QualityLevelPropertiesKHR src) {
        VkVideoEncodeH265QualityLevelPropertiesKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.VIDEO_ENCODE_H265_QUALITY_LEVEL_PROPERTIES_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkVideoEncodeH265QualityLevelPropertiesKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkVideoEncodeH265QualityLevelPropertiesKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkVideoEncodeH265QualityLevelPropertiesKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkVideoEncodeH265RateControlFlagsKHR.class) int preferredRateControlFlags() {
        return segment.get(LAYOUT$preferredRateControlFlags, OFFSET$preferredRateControlFlags);
    }

    public VkVideoEncodeH265QualityLevelPropertiesKHR preferredRateControlFlags(@Bitmask(VkVideoEncodeH265RateControlFlagsKHR.class) int value) {
        segment.set(LAYOUT$preferredRateControlFlags, OFFSET$preferredRateControlFlags, value);
        return this;
    }

    public @Unsigned int preferredGopFrameCount() {
        return segment.get(LAYOUT$preferredGopFrameCount, OFFSET$preferredGopFrameCount);
    }

    public VkVideoEncodeH265QualityLevelPropertiesKHR preferredGopFrameCount(@Unsigned int value) {
        segment.set(LAYOUT$preferredGopFrameCount, OFFSET$preferredGopFrameCount, value);
        return this;
    }

    public @Unsigned int preferredIdrPeriod() {
        return segment.get(LAYOUT$preferredIdrPeriod, OFFSET$preferredIdrPeriod);
    }

    public VkVideoEncodeH265QualityLevelPropertiesKHR preferredIdrPeriod(@Unsigned int value) {
        segment.set(LAYOUT$preferredIdrPeriod, OFFSET$preferredIdrPeriod, value);
        return this;
    }

    public @Unsigned int preferredConsecutiveBFrameCount() {
        return segment.get(LAYOUT$preferredConsecutiveBFrameCount, OFFSET$preferredConsecutiveBFrameCount);
    }

    public VkVideoEncodeH265QualityLevelPropertiesKHR preferredConsecutiveBFrameCount(@Unsigned int value) {
        segment.set(LAYOUT$preferredConsecutiveBFrameCount, OFFSET$preferredConsecutiveBFrameCount, value);
        return this;
    }

    public @Unsigned int preferredSubLayerCount() {
        return segment.get(LAYOUT$preferredSubLayerCount, OFFSET$preferredSubLayerCount);
    }

    public VkVideoEncodeH265QualityLevelPropertiesKHR preferredSubLayerCount(@Unsigned int value) {
        segment.set(LAYOUT$preferredSubLayerCount, OFFSET$preferredSubLayerCount, value);
        return this;
    }

    public @NotNull VkVideoEncodeH265QpKHR preferredConstantQp() {
        return new VkVideoEncodeH265QpKHR(segment.asSlice(OFFSET$preferredConstantQp, LAYOUT$preferredConstantQp));
    }

    public VkVideoEncodeH265QualityLevelPropertiesKHR preferredConstantQp(@NotNull VkVideoEncodeH265QpKHR value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$preferredConstantQp, SIZE$preferredConstantQp);
        return this;
    }

    public VkVideoEncodeH265QualityLevelPropertiesKHR preferredConstantQp(Consumer<@NotNull VkVideoEncodeH265QpKHR> consumer) {
        consumer.accept(preferredConstantQp());
        return this;
    }

    public @Unsigned int preferredMaxL0ReferenceCount() {
        return segment.get(LAYOUT$preferredMaxL0ReferenceCount, OFFSET$preferredMaxL0ReferenceCount);
    }

    public VkVideoEncodeH265QualityLevelPropertiesKHR preferredMaxL0ReferenceCount(@Unsigned int value) {
        segment.set(LAYOUT$preferredMaxL0ReferenceCount, OFFSET$preferredMaxL0ReferenceCount, value);
        return this;
    }

    public @Unsigned int preferredMaxL1ReferenceCount() {
        return segment.get(LAYOUT$preferredMaxL1ReferenceCount, OFFSET$preferredMaxL1ReferenceCount);
    }

    public VkVideoEncodeH265QualityLevelPropertiesKHR preferredMaxL1ReferenceCount(@Unsigned int value) {
        segment.set(LAYOUT$preferredMaxL1ReferenceCount, OFFSET$preferredMaxL1ReferenceCount, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("preferredRateControlFlags"),
        ValueLayout.JAVA_INT.withName("preferredGopFrameCount"),
        ValueLayout.JAVA_INT.withName("preferredIdrPeriod"),
        ValueLayout.JAVA_INT.withName("preferredConsecutiveBFrameCount"),
        ValueLayout.JAVA_INT.withName("preferredSubLayerCount"),
        VkVideoEncodeH265QpKHR.LAYOUT.withName("preferredConstantQp"),
        ValueLayout.JAVA_INT.withName("preferredMaxL0ReferenceCount"),
        ValueLayout.JAVA_INT.withName("preferredMaxL1ReferenceCount")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$preferredRateControlFlags = PathElement.groupElement("preferredRateControlFlags");
    public static final PathElement PATH$preferredGopFrameCount = PathElement.groupElement("preferredGopFrameCount");
    public static final PathElement PATH$preferredIdrPeriod = PathElement.groupElement("preferredIdrPeriod");
    public static final PathElement PATH$preferredConsecutiveBFrameCount = PathElement.groupElement("preferredConsecutiveBFrameCount");
    public static final PathElement PATH$preferredSubLayerCount = PathElement.groupElement("preferredSubLayerCount");
    public static final PathElement PATH$preferredConstantQp = PathElement.groupElement("preferredConstantQp");
    public static final PathElement PATH$preferredMaxL0ReferenceCount = PathElement.groupElement("preferredMaxL0ReferenceCount");
    public static final PathElement PATH$preferredMaxL1ReferenceCount = PathElement.groupElement("preferredMaxL1ReferenceCount");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$preferredRateControlFlags = (OfInt) LAYOUT.select(PATH$preferredRateControlFlags);
    public static final OfInt LAYOUT$preferredGopFrameCount = (OfInt) LAYOUT.select(PATH$preferredGopFrameCount);
    public static final OfInt LAYOUT$preferredIdrPeriod = (OfInt) LAYOUT.select(PATH$preferredIdrPeriod);
    public static final OfInt LAYOUT$preferredConsecutiveBFrameCount = (OfInt) LAYOUT.select(PATH$preferredConsecutiveBFrameCount);
    public static final OfInt LAYOUT$preferredSubLayerCount = (OfInt) LAYOUT.select(PATH$preferredSubLayerCount);
    public static final StructLayout LAYOUT$preferredConstantQp = (StructLayout) LAYOUT.select(PATH$preferredConstantQp);
    public static final OfInt LAYOUT$preferredMaxL0ReferenceCount = (OfInt) LAYOUT.select(PATH$preferredMaxL0ReferenceCount);
    public static final OfInt LAYOUT$preferredMaxL1ReferenceCount = (OfInt) LAYOUT.select(PATH$preferredMaxL1ReferenceCount);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$preferredRateControlFlags = LAYOUT$preferredRateControlFlags.byteSize();
    public static final long SIZE$preferredGopFrameCount = LAYOUT$preferredGopFrameCount.byteSize();
    public static final long SIZE$preferredIdrPeriod = LAYOUT$preferredIdrPeriod.byteSize();
    public static final long SIZE$preferredConsecutiveBFrameCount = LAYOUT$preferredConsecutiveBFrameCount.byteSize();
    public static final long SIZE$preferredSubLayerCount = LAYOUT$preferredSubLayerCount.byteSize();
    public static final long SIZE$preferredConstantQp = LAYOUT$preferredConstantQp.byteSize();
    public static final long SIZE$preferredMaxL0ReferenceCount = LAYOUT$preferredMaxL0ReferenceCount.byteSize();
    public static final long SIZE$preferredMaxL1ReferenceCount = LAYOUT$preferredMaxL1ReferenceCount.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$preferredRateControlFlags = LAYOUT.byteOffset(PATH$preferredRateControlFlags);
    public static final long OFFSET$preferredGopFrameCount = LAYOUT.byteOffset(PATH$preferredGopFrameCount);
    public static final long OFFSET$preferredIdrPeriod = LAYOUT.byteOffset(PATH$preferredIdrPeriod);
    public static final long OFFSET$preferredConsecutiveBFrameCount = LAYOUT.byteOffset(PATH$preferredConsecutiveBFrameCount);
    public static final long OFFSET$preferredSubLayerCount = LAYOUT.byteOffset(PATH$preferredSubLayerCount);
    public static final long OFFSET$preferredConstantQp = LAYOUT.byteOffset(PATH$preferredConstantQp);
    public static final long OFFSET$preferredMaxL0ReferenceCount = LAYOUT.byteOffset(PATH$preferredMaxL0ReferenceCount);
    public static final long OFFSET$preferredMaxL1ReferenceCount = LAYOUT.byteOffset(PATH$preferredMaxL1ReferenceCount);
}
