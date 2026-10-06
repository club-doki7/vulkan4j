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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeAV1QuantizationMapCapabilitiesKHR.html"><code>VkVideoEncodeAV1QuantizationMapCapabilitiesKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkVideoEncodeAV1QuantizationMapCapabilitiesKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     int32_t minQIndexDelta; // @link substring="minQIndexDelta" target="#minQIndexDelta"
///     int32_t maxQIndexDelta; // @link substring="maxQIndexDelta" target="#maxQIndexDelta"
/// } VkVideoEncodeAV1QuantizationMapCapabilitiesKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_VIDEO_ENCODE_AV1_QUANTIZATION_MAP_CAPABILITIES_KHR`
///
/// The {@code allocate} ({@link VkVideoEncodeAV1QuantizationMapCapabilitiesKHR#allocate(Arena)}, {@link VkVideoEncodeAV1QuantizationMapCapabilitiesKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkVideoEncodeAV1QuantizationMapCapabilitiesKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeAV1QuantizationMapCapabilitiesKHR.html"><code>VkVideoEncodeAV1QuantizationMapCapabilitiesKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkVideoEncodeAV1QuantizationMapCapabilitiesKHR(@NotNull MemorySegment segment) implements IVkVideoEncodeAV1QuantizationMapCapabilitiesKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeAV1QuantizationMapCapabilitiesKHR.html"><code>VkVideoEncodeAV1QuantizationMapCapabilitiesKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkVideoEncodeAV1QuantizationMapCapabilitiesKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkVideoEncodeAV1QuantizationMapCapabilitiesKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkVideoEncodeAV1QuantizationMapCapabilitiesKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkVideoEncodeAV1QuantizationMapCapabilitiesKHR, Iterable<VkVideoEncodeAV1QuantizationMapCapabilitiesKHR> {
        public long size() {
            return segment.byteSize() / VkVideoEncodeAV1QuantizationMapCapabilitiesKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkVideoEncodeAV1QuantizationMapCapabilitiesKHR at(long index) {
            return new VkVideoEncodeAV1QuantizationMapCapabilitiesKHR(segment.asSlice(index * VkVideoEncodeAV1QuantizationMapCapabilitiesKHR.BYTES, VkVideoEncodeAV1QuantizationMapCapabilitiesKHR.BYTES));
        }

        public VkVideoEncodeAV1QuantizationMapCapabilitiesKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkVideoEncodeAV1QuantizationMapCapabilitiesKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkVideoEncodeAV1QuantizationMapCapabilitiesKHR value) {
            MemorySegment s = segment.asSlice(index * VkVideoEncodeAV1QuantizationMapCapabilitiesKHR.BYTES, VkVideoEncodeAV1QuantizationMapCapabilitiesKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkVideoEncodeAV1QuantizationMapCapabilitiesKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkVideoEncodeAV1QuantizationMapCapabilitiesKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkVideoEncodeAV1QuantizationMapCapabilitiesKHR.BYTES,
                (end - start) * VkVideoEncodeAV1QuantizationMapCapabilitiesKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkVideoEncodeAV1QuantizationMapCapabilitiesKHR.BYTES));
        }

        public VkVideoEncodeAV1QuantizationMapCapabilitiesKHR[] toArray() {
            VkVideoEncodeAV1QuantizationMapCapabilitiesKHR[] ret = new VkVideoEncodeAV1QuantizationMapCapabilitiesKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkVideoEncodeAV1QuantizationMapCapabilitiesKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkVideoEncodeAV1QuantizationMapCapabilitiesKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkVideoEncodeAV1QuantizationMapCapabilitiesKHR.BYTES;
            }

            @Override
            public VkVideoEncodeAV1QuantizationMapCapabilitiesKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkVideoEncodeAV1QuantizationMapCapabilitiesKHR ret = new VkVideoEncodeAV1QuantizationMapCapabilitiesKHR(segment.asSlice(0, VkVideoEncodeAV1QuantizationMapCapabilitiesKHR.BYTES));
                segment = segment.asSlice(VkVideoEncodeAV1QuantizationMapCapabilitiesKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkVideoEncodeAV1QuantizationMapCapabilitiesKHR allocate(Arena arena) {
        VkVideoEncodeAV1QuantizationMapCapabilitiesKHR ret = new VkVideoEncodeAV1QuantizationMapCapabilitiesKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.VIDEO_ENCODE_AV1_QUANTIZATION_MAP_CAPABILITIES_KHR);
        return ret;
    }

    public static VkVideoEncodeAV1QuantizationMapCapabilitiesKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkVideoEncodeAV1QuantizationMapCapabilitiesKHR.Ptr ret = new VkVideoEncodeAV1QuantizationMapCapabilitiesKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.VIDEO_ENCODE_AV1_QUANTIZATION_MAP_CAPABILITIES_KHR);
        }
        return ret;
    }

    public static VkVideoEncodeAV1QuantizationMapCapabilitiesKHR clone(Arena arena, VkVideoEncodeAV1QuantizationMapCapabilitiesKHR src) {
        VkVideoEncodeAV1QuantizationMapCapabilitiesKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.VIDEO_ENCODE_AV1_QUANTIZATION_MAP_CAPABILITIES_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkVideoEncodeAV1QuantizationMapCapabilitiesKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkVideoEncodeAV1QuantizationMapCapabilitiesKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkVideoEncodeAV1QuantizationMapCapabilitiesKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public int minQIndexDelta() {
        return segment.get(LAYOUT$minQIndexDelta, OFFSET$minQIndexDelta);
    }

    public VkVideoEncodeAV1QuantizationMapCapabilitiesKHR minQIndexDelta(int value) {
        segment.set(LAYOUT$minQIndexDelta, OFFSET$minQIndexDelta, value);
        return this;
    }

    public int maxQIndexDelta() {
        return segment.get(LAYOUT$maxQIndexDelta, OFFSET$maxQIndexDelta);
    }

    public VkVideoEncodeAV1QuantizationMapCapabilitiesKHR maxQIndexDelta(int value) {
        segment.set(LAYOUT$maxQIndexDelta, OFFSET$maxQIndexDelta, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("minQIndexDelta"),
        ValueLayout.JAVA_INT.withName("maxQIndexDelta")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$minQIndexDelta = PathElement.groupElement("minQIndexDelta");
    public static final PathElement PATH$maxQIndexDelta = PathElement.groupElement("maxQIndexDelta");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$minQIndexDelta = (OfInt) LAYOUT.select(PATH$minQIndexDelta);
    public static final OfInt LAYOUT$maxQIndexDelta = (OfInt) LAYOUT.select(PATH$maxQIndexDelta);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$minQIndexDelta = LAYOUT$minQIndexDelta.byteSize();
    public static final long SIZE$maxQIndexDelta = LAYOUT$maxQIndexDelta.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$minQIndexDelta = LAYOUT.byteOffset(PATH$minQIndexDelta);
    public static final long OFFSET$maxQIndexDelta = LAYOUT.byteOffset(PATH$maxQIndexDelta);
}
