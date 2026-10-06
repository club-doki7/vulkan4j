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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoDecodeH265SessionParametersCreateInfoKHR.html"><code>VkVideoDecodeH265SessionParametersCreateInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkVideoDecodeH265SessionParametersCreateInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t maxStdVPSCount; // @link substring="maxStdVPSCount" target="#maxStdVPSCount"
///     uint32_t maxStdSPSCount; // @link substring="maxStdSPSCount" target="#maxStdSPSCount"
///     uint32_t maxStdPPSCount; // @link substring="maxStdPPSCount" target="#maxStdPPSCount"
///     VkVideoDecodeH265SessionParametersAddInfoKHR const* pParametersAddInfo; // optional // @link substring="VkVideoDecodeH265SessionParametersAddInfoKHR" target="VkVideoDecodeH265SessionParametersAddInfoKHR" @link substring="pParametersAddInfo" target="#pParametersAddInfo"
/// } VkVideoDecodeH265SessionParametersCreateInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_VIDEO_DECODE_H265_SESSION_PARAMETERS_CREATE_INFO_KHR`
///
/// The {@code allocate} ({@link VkVideoDecodeH265SessionParametersCreateInfoKHR#allocate(Arena)}, {@link VkVideoDecodeH265SessionParametersCreateInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkVideoDecodeH265SessionParametersCreateInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoDecodeH265SessionParametersCreateInfoKHR.html"><code>VkVideoDecodeH265SessionParametersCreateInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkVideoDecodeH265SessionParametersCreateInfoKHR(@NotNull MemorySegment segment) implements IVkVideoDecodeH265SessionParametersCreateInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoDecodeH265SessionParametersCreateInfoKHR.html"><code>VkVideoDecodeH265SessionParametersCreateInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkVideoDecodeH265SessionParametersCreateInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkVideoDecodeH265SessionParametersCreateInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkVideoDecodeH265SessionParametersCreateInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkVideoDecodeH265SessionParametersCreateInfoKHR, Iterable<VkVideoDecodeH265SessionParametersCreateInfoKHR> {
        public long size() {
            return segment.byteSize() / VkVideoDecodeH265SessionParametersCreateInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkVideoDecodeH265SessionParametersCreateInfoKHR at(long index) {
            return new VkVideoDecodeH265SessionParametersCreateInfoKHR(segment.asSlice(index * VkVideoDecodeH265SessionParametersCreateInfoKHR.BYTES, VkVideoDecodeH265SessionParametersCreateInfoKHR.BYTES));
        }

        public VkVideoDecodeH265SessionParametersCreateInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkVideoDecodeH265SessionParametersCreateInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkVideoDecodeH265SessionParametersCreateInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkVideoDecodeH265SessionParametersCreateInfoKHR.BYTES, VkVideoDecodeH265SessionParametersCreateInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkVideoDecodeH265SessionParametersCreateInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkVideoDecodeH265SessionParametersCreateInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkVideoDecodeH265SessionParametersCreateInfoKHR.BYTES,
                (end - start) * VkVideoDecodeH265SessionParametersCreateInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkVideoDecodeH265SessionParametersCreateInfoKHR.BYTES));
        }

        public VkVideoDecodeH265SessionParametersCreateInfoKHR[] toArray() {
            VkVideoDecodeH265SessionParametersCreateInfoKHR[] ret = new VkVideoDecodeH265SessionParametersCreateInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkVideoDecodeH265SessionParametersCreateInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkVideoDecodeH265SessionParametersCreateInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkVideoDecodeH265SessionParametersCreateInfoKHR.BYTES;
            }

            @Override
            public VkVideoDecodeH265SessionParametersCreateInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkVideoDecodeH265SessionParametersCreateInfoKHR ret = new VkVideoDecodeH265SessionParametersCreateInfoKHR(segment.asSlice(0, VkVideoDecodeH265SessionParametersCreateInfoKHR.BYTES));
                segment = segment.asSlice(VkVideoDecodeH265SessionParametersCreateInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkVideoDecodeH265SessionParametersCreateInfoKHR allocate(Arena arena) {
        VkVideoDecodeH265SessionParametersCreateInfoKHR ret = new VkVideoDecodeH265SessionParametersCreateInfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.VIDEO_DECODE_H265_SESSION_PARAMETERS_CREATE_INFO_KHR);
        return ret;
    }

    public static VkVideoDecodeH265SessionParametersCreateInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkVideoDecodeH265SessionParametersCreateInfoKHR.Ptr ret = new VkVideoDecodeH265SessionParametersCreateInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.VIDEO_DECODE_H265_SESSION_PARAMETERS_CREATE_INFO_KHR);
        }
        return ret;
    }

    public static VkVideoDecodeH265SessionParametersCreateInfoKHR clone(Arena arena, VkVideoDecodeH265SessionParametersCreateInfoKHR src) {
        VkVideoDecodeH265SessionParametersCreateInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.VIDEO_DECODE_H265_SESSION_PARAMETERS_CREATE_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkVideoDecodeH265SessionParametersCreateInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkVideoDecodeH265SessionParametersCreateInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkVideoDecodeH265SessionParametersCreateInfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int maxStdVPSCount() {
        return segment.get(LAYOUT$maxStdVPSCount, OFFSET$maxStdVPSCount);
    }

    public VkVideoDecodeH265SessionParametersCreateInfoKHR maxStdVPSCount(@Unsigned int value) {
        segment.set(LAYOUT$maxStdVPSCount, OFFSET$maxStdVPSCount, value);
        return this;
    }

    public @Unsigned int maxStdSPSCount() {
        return segment.get(LAYOUT$maxStdSPSCount, OFFSET$maxStdSPSCount);
    }

    public VkVideoDecodeH265SessionParametersCreateInfoKHR maxStdSPSCount(@Unsigned int value) {
        segment.set(LAYOUT$maxStdSPSCount, OFFSET$maxStdSPSCount, value);
        return this;
    }

    public @Unsigned int maxStdPPSCount() {
        return segment.get(LAYOUT$maxStdPPSCount, OFFSET$maxStdPPSCount);
    }

    public VkVideoDecodeH265SessionParametersCreateInfoKHR maxStdPPSCount(@Unsigned int value) {
        segment.set(LAYOUT$maxStdPPSCount, OFFSET$maxStdPPSCount, value);
        return this;
    }

    public VkVideoDecodeH265SessionParametersCreateInfoKHR pParametersAddInfo(@Nullable IVkVideoDecodeH265SessionParametersAddInfoKHR value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pParametersAddInfoRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkVideoDecodeH265SessionParametersAddInfoKHR.Ptr pParametersAddInfo(int assumedCount) {
        MemorySegment s = pParametersAddInfoRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkVideoDecodeH265SessionParametersAddInfoKHR.BYTES);
        return new VkVideoDecodeH265SessionParametersAddInfoKHR.Ptr(s);
    }

    public @Nullable VkVideoDecodeH265SessionParametersAddInfoKHR pParametersAddInfo() {
        MemorySegment s = pParametersAddInfoRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkVideoDecodeH265SessionParametersAddInfoKHR(s);
    }

    public @Pointer(target=VkVideoDecodeH265SessionParametersAddInfoKHR.class) @NotNull MemorySegment pParametersAddInfoRaw() {
        return segment.get(LAYOUT$pParametersAddInfo, OFFSET$pParametersAddInfo);
    }

    public void pParametersAddInfoRaw(@Pointer(target=VkVideoDecodeH265SessionParametersAddInfoKHR.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pParametersAddInfo, OFFSET$pParametersAddInfo, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("maxStdVPSCount"),
        ValueLayout.JAVA_INT.withName("maxStdSPSCount"),
        ValueLayout.JAVA_INT.withName("maxStdPPSCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkVideoDecodeH265SessionParametersAddInfoKHR.LAYOUT).withName("pParametersAddInfo")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$maxStdVPSCount = PathElement.groupElement("maxStdVPSCount");
    public static final PathElement PATH$maxStdSPSCount = PathElement.groupElement("maxStdSPSCount");
    public static final PathElement PATH$maxStdPPSCount = PathElement.groupElement("maxStdPPSCount");
    public static final PathElement PATH$pParametersAddInfo = PathElement.groupElement("pParametersAddInfo");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$maxStdVPSCount = (OfInt) LAYOUT.select(PATH$maxStdVPSCount);
    public static final OfInt LAYOUT$maxStdSPSCount = (OfInt) LAYOUT.select(PATH$maxStdSPSCount);
    public static final OfInt LAYOUT$maxStdPPSCount = (OfInt) LAYOUT.select(PATH$maxStdPPSCount);
    public static final AddressLayout LAYOUT$pParametersAddInfo = (AddressLayout) LAYOUT.select(PATH$pParametersAddInfo);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$maxStdVPSCount = LAYOUT$maxStdVPSCount.byteSize();
    public static final long SIZE$maxStdSPSCount = LAYOUT$maxStdSPSCount.byteSize();
    public static final long SIZE$maxStdPPSCount = LAYOUT$maxStdPPSCount.byteSize();
    public static final long SIZE$pParametersAddInfo = LAYOUT$pParametersAddInfo.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$maxStdVPSCount = LAYOUT.byteOffset(PATH$maxStdVPSCount);
    public static final long OFFSET$maxStdSPSCount = LAYOUT.byteOffset(PATH$maxStdSPSCount);
    public static final long OFFSET$maxStdPPSCount = LAYOUT.byteOffset(PATH$maxStdPPSCount);
    public static final long OFFSET$pParametersAddInfo = LAYOUT.byteOffset(PATH$pParametersAddInfo);
}
