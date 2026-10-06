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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoDecodeH264CapabilitiesKHR.html"><code>VkVideoDecodeH264CapabilitiesKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkVideoDecodeH264CapabilitiesKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     StdVideoH264LevelIdc maxLevelIdc; // @link substring="StdVideoH264LevelIdc" target="StdVideoH264LevelIdc" @link substring="maxLevelIdc" target="#maxLevelIdc"
///     VkOffset2D fieldOffsetGranularity; // @link substring="VkOffset2D" target="VkOffset2D" @link substring="fieldOffsetGranularity" target="#fieldOffsetGranularity"
/// } VkVideoDecodeH264CapabilitiesKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_VIDEO_DECODE_H264_CAPABILITIES_KHR`
///
/// The {@code allocate} ({@link VkVideoDecodeH264CapabilitiesKHR#allocate(Arena)}, {@link VkVideoDecodeH264CapabilitiesKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkVideoDecodeH264CapabilitiesKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoDecodeH264CapabilitiesKHR.html"><code>VkVideoDecodeH264CapabilitiesKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkVideoDecodeH264CapabilitiesKHR(@NotNull MemorySegment segment) implements IVkVideoDecodeH264CapabilitiesKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoDecodeH264CapabilitiesKHR.html"><code>VkVideoDecodeH264CapabilitiesKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkVideoDecodeH264CapabilitiesKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkVideoDecodeH264CapabilitiesKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkVideoDecodeH264CapabilitiesKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkVideoDecodeH264CapabilitiesKHR, Iterable<VkVideoDecodeH264CapabilitiesKHR> {
        public long size() {
            return segment.byteSize() / VkVideoDecodeH264CapabilitiesKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkVideoDecodeH264CapabilitiesKHR at(long index) {
            return new VkVideoDecodeH264CapabilitiesKHR(segment.asSlice(index * VkVideoDecodeH264CapabilitiesKHR.BYTES, VkVideoDecodeH264CapabilitiesKHR.BYTES));
        }

        public VkVideoDecodeH264CapabilitiesKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkVideoDecodeH264CapabilitiesKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkVideoDecodeH264CapabilitiesKHR value) {
            MemorySegment s = segment.asSlice(index * VkVideoDecodeH264CapabilitiesKHR.BYTES, VkVideoDecodeH264CapabilitiesKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkVideoDecodeH264CapabilitiesKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkVideoDecodeH264CapabilitiesKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkVideoDecodeH264CapabilitiesKHR.BYTES,
                (end - start) * VkVideoDecodeH264CapabilitiesKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkVideoDecodeH264CapabilitiesKHR.BYTES));
        }

        public VkVideoDecodeH264CapabilitiesKHR[] toArray() {
            VkVideoDecodeH264CapabilitiesKHR[] ret = new VkVideoDecodeH264CapabilitiesKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkVideoDecodeH264CapabilitiesKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkVideoDecodeH264CapabilitiesKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkVideoDecodeH264CapabilitiesKHR.BYTES;
            }

            @Override
            public VkVideoDecodeH264CapabilitiesKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkVideoDecodeH264CapabilitiesKHR ret = new VkVideoDecodeH264CapabilitiesKHR(segment.asSlice(0, VkVideoDecodeH264CapabilitiesKHR.BYTES));
                segment = segment.asSlice(VkVideoDecodeH264CapabilitiesKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkVideoDecodeH264CapabilitiesKHR allocate(Arena arena) {
        VkVideoDecodeH264CapabilitiesKHR ret = new VkVideoDecodeH264CapabilitiesKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.VIDEO_DECODE_H264_CAPABILITIES_KHR);
        return ret;
    }

    public static VkVideoDecodeH264CapabilitiesKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkVideoDecodeH264CapabilitiesKHR.Ptr ret = new VkVideoDecodeH264CapabilitiesKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.VIDEO_DECODE_H264_CAPABILITIES_KHR);
        }
        return ret;
    }

    public static VkVideoDecodeH264CapabilitiesKHR clone(Arena arena, VkVideoDecodeH264CapabilitiesKHR src) {
        VkVideoDecodeH264CapabilitiesKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.VIDEO_DECODE_H264_CAPABILITIES_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkVideoDecodeH264CapabilitiesKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkVideoDecodeH264CapabilitiesKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkVideoDecodeH264CapabilitiesKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @EnumType(StdVideoH264LevelIdc.class) int maxLevelIdc() {
        return segment.get(LAYOUT$maxLevelIdc, OFFSET$maxLevelIdc);
    }

    public VkVideoDecodeH264CapabilitiesKHR maxLevelIdc(@EnumType(StdVideoH264LevelIdc.class) int value) {
        segment.set(LAYOUT$maxLevelIdc, OFFSET$maxLevelIdc, value);
        return this;
    }

    public @NotNull VkOffset2D fieldOffsetGranularity() {
        return new VkOffset2D(segment.asSlice(OFFSET$fieldOffsetGranularity, LAYOUT$fieldOffsetGranularity));
    }

    public VkVideoDecodeH264CapabilitiesKHR fieldOffsetGranularity(@NotNull VkOffset2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$fieldOffsetGranularity, SIZE$fieldOffsetGranularity);
        return this;
    }

    public VkVideoDecodeH264CapabilitiesKHR fieldOffsetGranularity(Consumer<@NotNull VkOffset2D> consumer) {
        consumer.accept(fieldOffsetGranularity());
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("maxLevelIdc"),
        VkOffset2D.LAYOUT.withName("fieldOffsetGranularity")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$maxLevelIdc = PathElement.groupElement("maxLevelIdc");
    public static final PathElement PATH$fieldOffsetGranularity = PathElement.groupElement("fieldOffsetGranularity");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$maxLevelIdc = (OfInt) LAYOUT.select(PATH$maxLevelIdc);
    public static final StructLayout LAYOUT$fieldOffsetGranularity = (StructLayout) LAYOUT.select(PATH$fieldOffsetGranularity);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$maxLevelIdc = LAYOUT$maxLevelIdc.byteSize();
    public static final long SIZE$fieldOffsetGranularity = LAYOUT$fieldOffsetGranularity.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$maxLevelIdc = LAYOUT.byteOffset(PATH$maxLevelIdc);
    public static final long OFFSET$fieldOffsetGranularity = LAYOUT.byteOffset(PATH$fieldOffsetGranularity);
}
