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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeRateControlInfoKHR.html"><code>VkVideoEncodeRateControlInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkVideoEncodeRateControlInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkVideoEncodeRateControlFlagsKHR flags; // optional // @link substring="VkVideoEncodeRateControlFlagsKHR" target="VkVideoEncodeRateControlFlagsKHR" @link substring="flags" target="#flags"
///     VkVideoEncodeRateControlModeFlagsKHR rateControlMode; // optional // @link substring="VkVideoEncodeRateControlModeFlagsKHR" target="VkVideoEncodeRateControlModeFlagsKHR" @link substring="rateControlMode" target="#rateControlMode"
///     uint32_t layerCount; // optional // @link substring="layerCount" target="#layerCount"
///     VkVideoEncodeRateControlLayerInfoKHR const* pLayers; // optional // @link substring="VkVideoEncodeRateControlLayerInfoKHR" target="VkVideoEncodeRateControlLayerInfoKHR" @link substring="pLayers" target="#pLayers"
///     uint32_t virtualBufferSizeInMs; // @link substring="virtualBufferSizeInMs" target="#virtualBufferSizeInMs"
///     uint32_t initialVirtualBufferSizeInMs; // @link substring="initialVirtualBufferSizeInMs" target="#initialVirtualBufferSizeInMs"
/// } VkVideoEncodeRateControlInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_VIDEO_ENCODE_RATE_CONTROL_INFO_KHR`
///
/// The {@code allocate} ({@link VkVideoEncodeRateControlInfoKHR#allocate(Arena)}, {@link VkVideoEncodeRateControlInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkVideoEncodeRateControlInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeRateControlInfoKHR.html"><code>VkVideoEncodeRateControlInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkVideoEncodeRateControlInfoKHR(@NotNull MemorySegment segment) implements IVkVideoEncodeRateControlInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeRateControlInfoKHR.html"><code>VkVideoEncodeRateControlInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkVideoEncodeRateControlInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkVideoEncodeRateControlInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkVideoEncodeRateControlInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkVideoEncodeRateControlInfoKHR, Iterable<VkVideoEncodeRateControlInfoKHR> {
        public long size() {
            return segment.byteSize() / VkVideoEncodeRateControlInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkVideoEncodeRateControlInfoKHR at(long index) {
            return new VkVideoEncodeRateControlInfoKHR(segment.asSlice(index * VkVideoEncodeRateControlInfoKHR.BYTES, VkVideoEncodeRateControlInfoKHR.BYTES));
        }

        public VkVideoEncodeRateControlInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkVideoEncodeRateControlInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkVideoEncodeRateControlInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkVideoEncodeRateControlInfoKHR.BYTES, VkVideoEncodeRateControlInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkVideoEncodeRateControlInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkVideoEncodeRateControlInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkVideoEncodeRateControlInfoKHR.BYTES,
                (end - start) * VkVideoEncodeRateControlInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkVideoEncodeRateControlInfoKHR.BYTES));
        }

        public VkVideoEncodeRateControlInfoKHR[] toArray() {
            VkVideoEncodeRateControlInfoKHR[] ret = new VkVideoEncodeRateControlInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkVideoEncodeRateControlInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkVideoEncodeRateControlInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkVideoEncodeRateControlInfoKHR.BYTES;
            }

            @Override
            public VkVideoEncodeRateControlInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkVideoEncodeRateControlInfoKHR ret = new VkVideoEncodeRateControlInfoKHR(segment.asSlice(0, VkVideoEncodeRateControlInfoKHR.BYTES));
                segment = segment.asSlice(VkVideoEncodeRateControlInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkVideoEncodeRateControlInfoKHR allocate(Arena arena) {
        VkVideoEncodeRateControlInfoKHR ret = new VkVideoEncodeRateControlInfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.VIDEO_ENCODE_RATE_CONTROL_INFO_KHR);
        return ret;
    }

    public static VkVideoEncodeRateControlInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkVideoEncodeRateControlInfoKHR.Ptr ret = new VkVideoEncodeRateControlInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.VIDEO_ENCODE_RATE_CONTROL_INFO_KHR);
        }
        return ret;
    }

    public static VkVideoEncodeRateControlInfoKHR clone(Arena arena, VkVideoEncodeRateControlInfoKHR src) {
        VkVideoEncodeRateControlInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.VIDEO_ENCODE_RATE_CONTROL_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkVideoEncodeRateControlInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkVideoEncodeRateControlInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkVideoEncodeRateControlInfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkVideoEncodeRateControlFlagsKHR.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkVideoEncodeRateControlInfoKHR flags(@Bitmask(VkVideoEncodeRateControlFlagsKHR.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @Bitmask(VkVideoEncodeRateControlModeFlagsKHR.class) int rateControlMode() {
        return segment.get(LAYOUT$rateControlMode, OFFSET$rateControlMode);
    }

    public VkVideoEncodeRateControlInfoKHR rateControlMode(@Bitmask(VkVideoEncodeRateControlModeFlagsKHR.class) int value) {
        segment.set(LAYOUT$rateControlMode, OFFSET$rateControlMode, value);
        return this;
    }

    public @Unsigned int layerCount() {
        return segment.get(LAYOUT$layerCount, OFFSET$layerCount);
    }

    public VkVideoEncodeRateControlInfoKHR layerCount(@Unsigned int value) {
        segment.set(LAYOUT$layerCount, OFFSET$layerCount, value);
        return this;
    }

    public VkVideoEncodeRateControlInfoKHR pLayers(@Nullable IVkVideoEncodeRateControlLayerInfoKHR value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pLayersRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkVideoEncodeRateControlLayerInfoKHR.Ptr pLayers(int assumedCount) {
        MemorySegment s = pLayersRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkVideoEncodeRateControlLayerInfoKHR.BYTES);
        return new VkVideoEncodeRateControlLayerInfoKHR.Ptr(s);
    }

    public @Nullable VkVideoEncodeRateControlLayerInfoKHR pLayers() {
        MemorySegment s = pLayersRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkVideoEncodeRateControlLayerInfoKHR(s);
    }

    public @Pointer(target=VkVideoEncodeRateControlLayerInfoKHR.class) @NotNull MemorySegment pLayersRaw() {
        return segment.get(LAYOUT$pLayers, OFFSET$pLayers);
    }

    public void pLayersRaw(@Pointer(target=VkVideoEncodeRateControlLayerInfoKHR.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pLayers, OFFSET$pLayers, value);
    }

    public @Unsigned int virtualBufferSizeInMs() {
        return segment.get(LAYOUT$virtualBufferSizeInMs, OFFSET$virtualBufferSizeInMs);
    }

    public VkVideoEncodeRateControlInfoKHR virtualBufferSizeInMs(@Unsigned int value) {
        segment.set(LAYOUT$virtualBufferSizeInMs, OFFSET$virtualBufferSizeInMs, value);
        return this;
    }

    public @Unsigned int initialVirtualBufferSizeInMs() {
        return segment.get(LAYOUT$initialVirtualBufferSizeInMs, OFFSET$initialVirtualBufferSizeInMs);
    }

    public VkVideoEncodeRateControlInfoKHR initialVirtualBufferSizeInMs(@Unsigned int value) {
        segment.set(LAYOUT$initialVirtualBufferSizeInMs, OFFSET$initialVirtualBufferSizeInMs, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("rateControlMode"),
        ValueLayout.JAVA_INT.withName("layerCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkVideoEncodeRateControlLayerInfoKHR.LAYOUT).withName("pLayers"),
        ValueLayout.JAVA_INT.withName("virtualBufferSizeInMs"),
        ValueLayout.JAVA_INT.withName("initialVirtualBufferSizeInMs")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$rateControlMode = PathElement.groupElement("rateControlMode");
    public static final PathElement PATH$layerCount = PathElement.groupElement("layerCount");
    public static final PathElement PATH$pLayers = PathElement.groupElement("pLayers");
    public static final PathElement PATH$virtualBufferSizeInMs = PathElement.groupElement("virtualBufferSizeInMs");
    public static final PathElement PATH$initialVirtualBufferSizeInMs = PathElement.groupElement("initialVirtualBufferSizeInMs");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$rateControlMode = (OfInt) LAYOUT.select(PATH$rateControlMode);
    public static final OfInt LAYOUT$layerCount = (OfInt) LAYOUT.select(PATH$layerCount);
    public static final AddressLayout LAYOUT$pLayers = (AddressLayout) LAYOUT.select(PATH$pLayers);
    public static final OfInt LAYOUT$virtualBufferSizeInMs = (OfInt) LAYOUT.select(PATH$virtualBufferSizeInMs);
    public static final OfInt LAYOUT$initialVirtualBufferSizeInMs = (OfInt) LAYOUT.select(PATH$initialVirtualBufferSizeInMs);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$rateControlMode = LAYOUT$rateControlMode.byteSize();
    public static final long SIZE$layerCount = LAYOUT$layerCount.byteSize();
    public static final long SIZE$pLayers = LAYOUT$pLayers.byteSize();
    public static final long SIZE$virtualBufferSizeInMs = LAYOUT$virtualBufferSizeInMs.byteSize();
    public static final long SIZE$initialVirtualBufferSizeInMs = LAYOUT$initialVirtualBufferSizeInMs.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$rateControlMode = LAYOUT.byteOffset(PATH$rateControlMode);
    public static final long OFFSET$layerCount = LAYOUT.byteOffset(PATH$layerCount);
    public static final long OFFSET$pLayers = LAYOUT.byteOffset(PATH$pLayers);
    public static final long OFFSET$virtualBufferSizeInMs = LAYOUT.byteOffset(PATH$virtualBufferSizeInMs);
    public static final long OFFSET$initialVirtualBufferSizeInMs = LAYOUT.byteOffset(PATH$initialVirtualBufferSizeInMs);
}
