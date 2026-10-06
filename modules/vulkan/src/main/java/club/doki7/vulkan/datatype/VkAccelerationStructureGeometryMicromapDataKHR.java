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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAccelerationStructureGeometryMicromapDataKHR.html"><code>VkAccelerationStructureGeometryMicromapDataKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkAccelerationStructureGeometryMicromapDataKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t usageCountsCount; // optional // @link substring="usageCountsCount" target="#usageCountsCount"
///     VkMicromapUsageKHR const* pUsageCounts; // optional // @link substring="VkMicromapUsageKHR" target="VkMicromapUsageKHR" @link substring="pUsageCounts" target="#pUsageCounts"
///     VkMicromapUsageKHR const* const* ppUsageCounts; // optional // @link substring="VkMicromapUsageKHR" target="VkMicromapUsageKHR" @link substring="ppUsageCounts" target="#ppUsageCounts"
///     VkDeviceAddress data; // @link substring="data" target="#data"
///     VkDeviceAddress triangleArray; // @link substring="triangleArray" target="#triangleArray"
///     VkDeviceSize triangleArrayStride; // @link substring="triangleArrayStride" target="#triangleArrayStride"
/// } VkAccelerationStructureGeometryMicromapDataKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_ACCELERATION_STRUCTURE_GEOMETRY_MICROMAP_DATA_KHR`
///
/// The {@code allocate} ({@link VkAccelerationStructureGeometryMicromapDataKHR#allocate(Arena)}, {@link VkAccelerationStructureGeometryMicromapDataKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkAccelerationStructureGeometryMicromapDataKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAccelerationStructureGeometryMicromapDataKHR.html"><code>VkAccelerationStructureGeometryMicromapDataKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkAccelerationStructureGeometryMicromapDataKHR(@NotNull MemorySegment segment) implements IVkAccelerationStructureGeometryMicromapDataKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAccelerationStructureGeometryMicromapDataKHR.html"><code>VkAccelerationStructureGeometryMicromapDataKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkAccelerationStructureGeometryMicromapDataKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkAccelerationStructureGeometryMicromapDataKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkAccelerationStructureGeometryMicromapDataKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkAccelerationStructureGeometryMicromapDataKHR, Iterable<VkAccelerationStructureGeometryMicromapDataKHR> {
        public long size() {
            return segment.byteSize() / VkAccelerationStructureGeometryMicromapDataKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkAccelerationStructureGeometryMicromapDataKHR at(long index) {
            return new VkAccelerationStructureGeometryMicromapDataKHR(segment.asSlice(index * VkAccelerationStructureGeometryMicromapDataKHR.BYTES, VkAccelerationStructureGeometryMicromapDataKHR.BYTES));
        }

        public VkAccelerationStructureGeometryMicromapDataKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkAccelerationStructureGeometryMicromapDataKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkAccelerationStructureGeometryMicromapDataKHR value) {
            MemorySegment s = segment.asSlice(index * VkAccelerationStructureGeometryMicromapDataKHR.BYTES, VkAccelerationStructureGeometryMicromapDataKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkAccelerationStructureGeometryMicromapDataKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkAccelerationStructureGeometryMicromapDataKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkAccelerationStructureGeometryMicromapDataKHR.BYTES,
                (end - start) * VkAccelerationStructureGeometryMicromapDataKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkAccelerationStructureGeometryMicromapDataKHR.BYTES));
        }

        public VkAccelerationStructureGeometryMicromapDataKHR[] toArray() {
            VkAccelerationStructureGeometryMicromapDataKHR[] ret = new VkAccelerationStructureGeometryMicromapDataKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkAccelerationStructureGeometryMicromapDataKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkAccelerationStructureGeometryMicromapDataKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkAccelerationStructureGeometryMicromapDataKHR.BYTES;
            }

            @Override
            public VkAccelerationStructureGeometryMicromapDataKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkAccelerationStructureGeometryMicromapDataKHR ret = new VkAccelerationStructureGeometryMicromapDataKHR(segment.asSlice(0, VkAccelerationStructureGeometryMicromapDataKHR.BYTES));
                segment = segment.asSlice(VkAccelerationStructureGeometryMicromapDataKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkAccelerationStructureGeometryMicromapDataKHR allocate(Arena arena) {
        VkAccelerationStructureGeometryMicromapDataKHR ret = new VkAccelerationStructureGeometryMicromapDataKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.ACCELERATION_STRUCTURE_GEOMETRY_MICROMAP_DATA_KHR);
        return ret;
    }

    public static VkAccelerationStructureGeometryMicromapDataKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkAccelerationStructureGeometryMicromapDataKHR.Ptr ret = new VkAccelerationStructureGeometryMicromapDataKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.ACCELERATION_STRUCTURE_GEOMETRY_MICROMAP_DATA_KHR);
        }
        return ret;
    }

    public static VkAccelerationStructureGeometryMicromapDataKHR clone(Arena arena, VkAccelerationStructureGeometryMicromapDataKHR src) {
        VkAccelerationStructureGeometryMicromapDataKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.ACCELERATION_STRUCTURE_GEOMETRY_MICROMAP_DATA_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkAccelerationStructureGeometryMicromapDataKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkAccelerationStructureGeometryMicromapDataKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkAccelerationStructureGeometryMicromapDataKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int usageCountsCount() {
        return segment.get(LAYOUT$usageCountsCount, OFFSET$usageCountsCount);
    }

    public VkAccelerationStructureGeometryMicromapDataKHR usageCountsCount(@Unsigned int value) {
        segment.set(LAYOUT$usageCountsCount, OFFSET$usageCountsCount, value);
        return this;
    }

    public VkAccelerationStructureGeometryMicromapDataKHR pUsageCounts(@Nullable IVkMicromapUsageKHR value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pUsageCountsRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkMicromapUsageKHR.Ptr pUsageCounts(int assumedCount) {
        MemorySegment s = pUsageCountsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkMicromapUsageKHR.BYTES);
        return new VkMicromapUsageKHR.Ptr(s);
    }

    public @Nullable VkMicromapUsageKHR pUsageCounts() {
        MemorySegment s = pUsageCountsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkMicromapUsageKHR(s);
    }

    public @Pointer(target=VkMicromapUsageKHR.class) @NotNull MemorySegment pUsageCountsRaw() {
        return segment.get(LAYOUT$pUsageCounts, OFFSET$pUsageCounts);
    }

    public void pUsageCountsRaw(@Pointer(target=VkMicromapUsageKHR.class) @NotNull MemorySegment value) {
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

    public VkAccelerationStructureGeometryMicromapDataKHR ppUsageCounts(@Nullable PointerPtr value) {
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

    public @NativeType("VkDeviceAddress") @Unsigned long data() {
        return segment.get(LAYOUT$data, OFFSET$data);
    }

    public VkAccelerationStructureGeometryMicromapDataKHR data(@NativeType("VkDeviceAddress") @Unsigned long value) {
        segment.set(LAYOUT$data, OFFSET$data, value);
        return this;
    }

    public @NativeType("VkDeviceAddress") @Unsigned long triangleArray() {
        return segment.get(LAYOUT$triangleArray, OFFSET$triangleArray);
    }

    public VkAccelerationStructureGeometryMicromapDataKHR triangleArray(@NativeType("VkDeviceAddress") @Unsigned long value) {
        segment.set(LAYOUT$triangleArray, OFFSET$triangleArray, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long triangleArrayStride() {
        return segment.get(LAYOUT$triangleArrayStride, OFFSET$triangleArrayStride);
    }

    public VkAccelerationStructureGeometryMicromapDataKHR triangleArrayStride(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$triangleArrayStride, OFFSET$triangleArrayStride, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("usageCountsCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkMicromapUsageKHR.LAYOUT).withName("pUsageCounts"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS.withTargetLayout(VkMicromapUsageKHR.LAYOUT)).withName("ppUsageCounts"),
        ValueLayout.JAVA_LONG.withName("data"),
        ValueLayout.JAVA_LONG.withName("triangleArray"),
        ValueLayout.JAVA_LONG.withName("triangleArrayStride")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$usageCountsCount = PathElement.groupElement("usageCountsCount");
    public static final PathElement PATH$pUsageCounts = PathElement.groupElement("pUsageCounts");
    public static final PathElement PATH$ppUsageCounts = PathElement.groupElement("ppUsageCounts");
    public static final PathElement PATH$data = PathElement.groupElement("data");
    public static final PathElement PATH$triangleArray = PathElement.groupElement("triangleArray");
    public static final PathElement PATH$triangleArrayStride = PathElement.groupElement("triangleArrayStride");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$usageCountsCount = (OfInt) LAYOUT.select(PATH$usageCountsCount);
    public static final AddressLayout LAYOUT$pUsageCounts = (AddressLayout) LAYOUT.select(PATH$pUsageCounts);
    public static final AddressLayout LAYOUT$ppUsageCounts = (AddressLayout) LAYOUT.select(PATH$ppUsageCounts);
    public static final OfLong LAYOUT$data = (OfLong) LAYOUT.select(PATH$data);
    public static final OfLong LAYOUT$triangleArray = (OfLong) LAYOUT.select(PATH$triangleArray);
    public static final OfLong LAYOUT$triangleArrayStride = (OfLong) LAYOUT.select(PATH$triangleArrayStride);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$usageCountsCount = LAYOUT$usageCountsCount.byteSize();
    public static final long SIZE$pUsageCounts = LAYOUT$pUsageCounts.byteSize();
    public static final long SIZE$ppUsageCounts = LAYOUT$ppUsageCounts.byteSize();
    public static final long SIZE$data = LAYOUT$data.byteSize();
    public static final long SIZE$triangleArray = LAYOUT$triangleArray.byteSize();
    public static final long SIZE$triangleArrayStride = LAYOUT$triangleArrayStride.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$usageCountsCount = LAYOUT.byteOffset(PATH$usageCountsCount);
    public static final long OFFSET$pUsageCounts = LAYOUT.byteOffset(PATH$pUsageCounts);
    public static final long OFFSET$ppUsageCounts = LAYOUT.byteOffset(PATH$ppUsageCounts);
    public static final long OFFSET$data = LAYOUT.byteOffset(PATH$data);
    public static final long OFFSET$triangleArray = LAYOUT.byteOffset(PATH$triangleArray);
    public static final long OFFSET$triangleArrayStride = LAYOUT.byteOffset(PATH$triangleArrayStride);
}
