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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMicromapBuildInfoEXT.html"><code>VkMicromapBuildInfoEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkMicromapBuildInfoEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkMicromapTypeEXT type; // @link substring="VkMicromapTypeEXT" target="VkMicromapTypeEXT" @link substring="type" target="#type"
///     VkBuildMicromapFlagsEXT flags; // optional // @link substring="VkBuildMicromapFlagsEXT" target="VkBuildMicromapFlagsEXT" @link substring="flags" target="#flags"
///     VkBuildMicromapModeEXT mode; // @link substring="VkBuildMicromapModeEXT" target="VkBuildMicromapModeEXT" @link substring="mode" target="#mode"
///     VkMicromapEXT dstMicromap; // optional // @link substring="VkMicromapEXT" target="VkMicromapEXT" @link substring="dstMicromap" target="#dstMicromap"
///     uint32_t usageCountsCount; // optional // @link substring="usageCountsCount" target="#usageCountsCount"
///     VkMicromapUsageEXT const* pUsageCounts; // optional // @link substring="VkMicromapUsageEXT" target="VkMicromapUsageEXT" @link substring="pUsageCounts" target="#pUsageCounts"
///     VkMicromapUsageEXT const* const* ppUsageCounts; // optional // @link substring="VkMicromapUsageEXT" target="VkMicromapUsageEXT" @link substring="ppUsageCounts" target="#ppUsageCounts"
///     VkDeviceOrHostAddressConstKHR data; // @link substring="VkDeviceOrHostAddressConstKHR" target="VkDeviceOrHostAddressConstKHR" @link substring="data" target="#data"
///     VkDeviceOrHostAddressKHR scratchData; // @link substring="VkDeviceOrHostAddressKHR" target="VkDeviceOrHostAddressKHR" @link substring="scratchData" target="#scratchData"
///     VkDeviceOrHostAddressConstKHR triangleArray; // @link substring="VkDeviceOrHostAddressConstKHR" target="VkDeviceOrHostAddressConstKHR" @link substring="triangleArray" target="#triangleArray"
///     VkDeviceSize triangleArrayStride; // @link substring="triangleArrayStride" target="#triangleArrayStride"
/// } VkMicromapBuildInfoEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_MICROMAP_BUILD_INFO_EXT`
///
/// The {@code allocate} ({@link VkMicromapBuildInfoEXT#allocate(Arena)}, {@link VkMicromapBuildInfoEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkMicromapBuildInfoEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMicromapBuildInfoEXT.html"><code>VkMicromapBuildInfoEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkMicromapBuildInfoEXT(@NotNull MemorySegment segment) implements IVkMicromapBuildInfoEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMicromapBuildInfoEXT.html"><code>VkMicromapBuildInfoEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkMicromapBuildInfoEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkMicromapBuildInfoEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkMicromapBuildInfoEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkMicromapBuildInfoEXT, Iterable<VkMicromapBuildInfoEXT> {
        public long size() {
            return segment.byteSize() / VkMicromapBuildInfoEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkMicromapBuildInfoEXT at(long index) {
            return new VkMicromapBuildInfoEXT(segment.asSlice(index * VkMicromapBuildInfoEXT.BYTES, VkMicromapBuildInfoEXT.BYTES));
        }

        public VkMicromapBuildInfoEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkMicromapBuildInfoEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkMicromapBuildInfoEXT value) {
            MemorySegment s = segment.asSlice(index * VkMicromapBuildInfoEXT.BYTES, VkMicromapBuildInfoEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkMicromapBuildInfoEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkMicromapBuildInfoEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkMicromapBuildInfoEXT.BYTES,
                (end - start) * VkMicromapBuildInfoEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkMicromapBuildInfoEXT.BYTES));
        }

        public VkMicromapBuildInfoEXT[] toArray() {
            VkMicromapBuildInfoEXT[] ret = new VkMicromapBuildInfoEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkMicromapBuildInfoEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkMicromapBuildInfoEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkMicromapBuildInfoEXT.BYTES;
            }

            @Override
            public VkMicromapBuildInfoEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkMicromapBuildInfoEXT ret = new VkMicromapBuildInfoEXT(segment.asSlice(0, VkMicromapBuildInfoEXT.BYTES));
                segment = segment.asSlice(VkMicromapBuildInfoEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkMicromapBuildInfoEXT allocate(Arena arena) {
        VkMicromapBuildInfoEXT ret = new VkMicromapBuildInfoEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.MICROMAP_BUILD_INFO_EXT);
        return ret;
    }

    public static VkMicromapBuildInfoEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkMicromapBuildInfoEXT.Ptr ret = new VkMicromapBuildInfoEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.MICROMAP_BUILD_INFO_EXT);
        }
        return ret;
    }

    public static VkMicromapBuildInfoEXT clone(Arena arena, VkMicromapBuildInfoEXT src) {
        VkMicromapBuildInfoEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.MICROMAP_BUILD_INFO_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkMicromapBuildInfoEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkMicromapBuildInfoEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkMicromapBuildInfoEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @EnumType(VkMicromapTypeEXT.class) int type() {
        return segment.get(LAYOUT$type, OFFSET$type);
    }

    public VkMicromapBuildInfoEXT type(@EnumType(VkMicromapTypeEXT.class) int value) {
        segment.set(LAYOUT$type, OFFSET$type, value);
        return this;
    }

    public @Bitmask(VkBuildMicromapFlagsEXT.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkMicromapBuildInfoEXT flags(@Bitmask(VkBuildMicromapFlagsEXT.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @EnumType(VkBuildMicromapModeEXT.class) int mode() {
        return segment.get(LAYOUT$mode, OFFSET$mode);
    }

    public VkMicromapBuildInfoEXT mode(@EnumType(VkBuildMicromapModeEXT.class) int value) {
        segment.set(LAYOUT$mode, OFFSET$mode, value);
        return this;
    }

    public @Nullable VkMicromapEXT dstMicromap() {
        MemorySegment s = segment.asSlice(OFFSET$dstMicromap, SIZE$dstMicromap);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkMicromapEXT(s);
    }

    public VkMicromapBuildInfoEXT dstMicromap(@Nullable VkMicromapEXT value) {
        segment.set(LAYOUT$dstMicromap, OFFSET$dstMicromap, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int usageCountsCount() {
        return segment.get(LAYOUT$usageCountsCount, OFFSET$usageCountsCount);
    }

    public VkMicromapBuildInfoEXT usageCountsCount(@Unsigned int value) {
        segment.set(LAYOUT$usageCountsCount, OFFSET$usageCountsCount, value);
        return this;
    }

    public VkMicromapBuildInfoEXT pUsageCounts(@Nullable IVkMicromapUsageEXT value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pUsageCountsRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkMicromapUsageEXT.Ptr pUsageCounts(int assumedCount) {
        MemorySegment s = pUsageCountsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkMicromapUsageEXT.BYTES);
        return new VkMicromapUsageEXT.Ptr(s);
    }

    public @Nullable VkMicromapUsageEXT pUsageCounts() {
        MemorySegment s = pUsageCountsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkMicromapUsageEXT(s);
    }

    public @Pointer(target=VkMicromapUsageEXT.class) @NotNull MemorySegment pUsageCountsRaw() {
        return segment.get(LAYOUT$pUsageCounts, OFFSET$pUsageCounts);
    }

    public void pUsageCountsRaw(@Pointer(target=VkMicromapUsageEXT.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pUsageCounts, OFFSET$pUsageCounts, value);
    }

    /// Note: the returned {@link PointerPtr} does not have correct {@link PointerPtr#size} property. It's up
    /// to user to track the size of the buffer, and use {@link PointerPtr#reinterpret} to set the size before
    /// actually reading from or writing to the buffer.
    public @Nullable PointerPtr ppUsageCounts() {
        MemorySegment s = ppUsageCountsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new PointerPtr(s);
    }

    public VkMicromapBuildInfoEXT ppUsageCounts(@Nullable PointerPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        ppUsageCountsRaw(s);
        return this;
    }

    public @Pointer(comment="void**") @NotNull MemorySegment ppUsageCountsRaw() {
        return segment.get(LAYOUT$ppUsageCounts, OFFSET$ppUsageCounts);
    }

    public void ppUsageCountsRaw(@Pointer(comment="void**") @NotNull MemorySegment value) {
        segment.set(LAYOUT$ppUsageCounts, OFFSET$ppUsageCounts, value);
    }

    public @NotNull VkDeviceOrHostAddressConstKHR data() {
        return new VkDeviceOrHostAddressConstKHR(segment.asSlice(OFFSET$data, LAYOUT$data));
    }

    public VkMicromapBuildInfoEXT data(@NotNull VkDeviceOrHostAddressConstKHR value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$data, SIZE$data);
        return this;
    }

    public VkMicromapBuildInfoEXT data(Consumer<@NotNull VkDeviceOrHostAddressConstKHR> consumer) {
        consumer.accept(data());
        return this;
    }

    public @NotNull VkDeviceOrHostAddressKHR scratchData() {
        return new VkDeviceOrHostAddressKHR(segment.asSlice(OFFSET$scratchData, LAYOUT$scratchData));
    }

    public VkMicromapBuildInfoEXT scratchData(@NotNull VkDeviceOrHostAddressKHR value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$scratchData, SIZE$scratchData);
        return this;
    }

    public VkMicromapBuildInfoEXT scratchData(Consumer<@NotNull VkDeviceOrHostAddressKHR> consumer) {
        consumer.accept(scratchData());
        return this;
    }

    public @NotNull VkDeviceOrHostAddressConstKHR triangleArray() {
        return new VkDeviceOrHostAddressConstKHR(segment.asSlice(OFFSET$triangleArray, LAYOUT$triangleArray));
    }

    public VkMicromapBuildInfoEXT triangleArray(@NotNull VkDeviceOrHostAddressConstKHR value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$triangleArray, SIZE$triangleArray);
        return this;
    }

    public VkMicromapBuildInfoEXT triangleArray(Consumer<@NotNull VkDeviceOrHostAddressConstKHR> consumer) {
        consumer.accept(triangleArray());
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long triangleArrayStride() {
        return segment.get(LAYOUT$triangleArrayStride, OFFSET$triangleArrayStride);
    }

    public VkMicromapBuildInfoEXT triangleArrayStride(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$triangleArrayStride, OFFSET$triangleArrayStride, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("type"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("mode"),
        ValueLayout.ADDRESS.withName("dstMicromap"),
        ValueLayout.JAVA_INT.withName("usageCountsCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkMicromapUsageEXT.LAYOUT).withName("pUsageCounts"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS.withTargetLayout(VkMicromapUsageEXT.LAYOUT)).withName("ppUsageCounts"),
        VkDeviceOrHostAddressConstKHR.LAYOUT.withName("data"),
        VkDeviceOrHostAddressKHR.LAYOUT.withName("scratchData"),
        VkDeviceOrHostAddressConstKHR.LAYOUT.withName("triangleArray"),
        ValueLayout.JAVA_LONG.withName("triangleArrayStride")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$type = PathElement.groupElement("type");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$mode = PathElement.groupElement("mode");
    public static final PathElement PATH$dstMicromap = PathElement.groupElement("dstMicromap");
    public static final PathElement PATH$usageCountsCount = PathElement.groupElement("usageCountsCount");
    public static final PathElement PATH$pUsageCounts = PathElement.groupElement("pUsageCounts");
    public static final PathElement PATH$ppUsageCounts = PathElement.groupElement("ppUsageCounts");
    public static final PathElement PATH$data = PathElement.groupElement("data");
    public static final PathElement PATH$scratchData = PathElement.groupElement("scratchData");
    public static final PathElement PATH$triangleArray = PathElement.groupElement("triangleArray");
    public static final PathElement PATH$triangleArrayStride = PathElement.groupElement("triangleArrayStride");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$type = (OfInt) LAYOUT.select(PATH$type);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$mode = (OfInt) LAYOUT.select(PATH$mode);
    public static final AddressLayout LAYOUT$dstMicromap = (AddressLayout) LAYOUT.select(PATH$dstMicromap);
    public static final OfInt LAYOUT$usageCountsCount = (OfInt) LAYOUT.select(PATH$usageCountsCount);
    public static final AddressLayout LAYOUT$pUsageCounts = (AddressLayout) LAYOUT.select(PATH$pUsageCounts);
    public static final AddressLayout LAYOUT$ppUsageCounts = (AddressLayout) LAYOUT.select(PATH$ppUsageCounts);
    public static final UnionLayout LAYOUT$data = (UnionLayout) LAYOUT.select(PATH$data);
    public static final UnionLayout LAYOUT$scratchData = (UnionLayout) LAYOUT.select(PATH$scratchData);
    public static final UnionLayout LAYOUT$triangleArray = (UnionLayout) LAYOUT.select(PATH$triangleArray);
    public static final OfLong LAYOUT$triangleArrayStride = (OfLong) LAYOUT.select(PATH$triangleArrayStride);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$type = LAYOUT$type.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$mode = LAYOUT$mode.byteSize();
    public static final long SIZE$dstMicromap = LAYOUT$dstMicromap.byteSize();
    public static final long SIZE$usageCountsCount = LAYOUT$usageCountsCount.byteSize();
    public static final long SIZE$pUsageCounts = LAYOUT$pUsageCounts.byteSize();
    public static final long SIZE$ppUsageCounts = LAYOUT$ppUsageCounts.byteSize();
    public static final long SIZE$data = LAYOUT$data.byteSize();
    public static final long SIZE$scratchData = LAYOUT$scratchData.byteSize();
    public static final long SIZE$triangleArray = LAYOUT$triangleArray.byteSize();
    public static final long SIZE$triangleArrayStride = LAYOUT$triangleArrayStride.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$type = LAYOUT.byteOffset(PATH$type);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$mode = LAYOUT.byteOffset(PATH$mode);
    public static final long OFFSET$dstMicromap = LAYOUT.byteOffset(PATH$dstMicromap);
    public static final long OFFSET$usageCountsCount = LAYOUT.byteOffset(PATH$usageCountsCount);
    public static final long OFFSET$pUsageCounts = LAYOUT.byteOffset(PATH$pUsageCounts);
    public static final long OFFSET$ppUsageCounts = LAYOUT.byteOffset(PATH$ppUsageCounts);
    public static final long OFFSET$data = LAYOUT.byteOffset(PATH$data);
    public static final long OFFSET$scratchData = LAYOUT.byteOffset(PATH$scratchData);
    public static final long OFFSET$triangleArray = LAYOUT.byteOffset(PATH$triangleArray);
    public static final long OFFSET$triangleArrayStride = LAYOUT.byteOffset(PATH$triangleArrayStride);
}
