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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkClusterAccelerationStructureCommandsInfoNV.html"><code>VkClusterAccelerationStructureCommandsInfoNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkClusterAccelerationStructureCommandsInfoNV {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkClusterAccelerationStructureInputInfoNV input; // @link substring="VkClusterAccelerationStructureInputInfoNV" target="VkClusterAccelerationStructureInputInfoNV" @link substring="input" target="#input"
///     VkDeviceAddress dstImplicitData; // @link substring="dstImplicitData" target="#dstImplicitData"
///     VkDeviceAddress scratchData; // @link substring="scratchData" target="#scratchData"
///     VkStridedDeviceAddressRegionKHR dstAddressesArray; // @link substring="VkStridedDeviceAddressRegionKHR" target="VkStridedDeviceAddressRegionKHR" @link substring="dstAddressesArray" target="#dstAddressesArray"
///     VkStridedDeviceAddressRegionKHR dstSizesArray; // @link substring="VkStridedDeviceAddressRegionKHR" target="VkStridedDeviceAddressRegionKHR" @link substring="dstSizesArray" target="#dstSizesArray"
///     VkStridedDeviceAddressRegionKHR srcInfosArray; // @link substring="VkStridedDeviceAddressRegionKHR" target="VkStridedDeviceAddressRegionKHR" @link substring="srcInfosArray" target="#srcInfosArray"
///     VkDeviceAddress srcInfosCount; // @link substring="srcInfosCount" target="#srcInfosCount"
///     VkClusterAccelerationStructureAddressResolutionFlagsNV addressResolutionFlags; // optional // @link substring="VkClusterAccelerationStructureAddressResolutionFlagsNV" target="VkClusterAccelerationStructureAddressResolutionFlagsNV" @link substring="addressResolutionFlags" target="#addressResolutionFlags"
/// } VkClusterAccelerationStructureCommandsInfoNV;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_CLUSTER_ACCELERATION_STRUCTURE_COMMANDS_INFO_NV`
/// - `input.autoInit()`
///
/// The {@code allocate} ({@link VkClusterAccelerationStructureCommandsInfoNV#allocate(Arena)}, {@link VkClusterAccelerationStructureCommandsInfoNV#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkClusterAccelerationStructureCommandsInfoNV#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkClusterAccelerationStructureCommandsInfoNV.html"><code>VkClusterAccelerationStructureCommandsInfoNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkClusterAccelerationStructureCommandsInfoNV(@NotNull MemorySegment segment) implements IVkClusterAccelerationStructureCommandsInfoNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkClusterAccelerationStructureCommandsInfoNV.html"><code>VkClusterAccelerationStructureCommandsInfoNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkClusterAccelerationStructureCommandsInfoNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkClusterAccelerationStructureCommandsInfoNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkClusterAccelerationStructureCommandsInfoNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkClusterAccelerationStructureCommandsInfoNV, Iterable<VkClusterAccelerationStructureCommandsInfoNV> {
        public long size() {
            return segment.byteSize() / VkClusterAccelerationStructureCommandsInfoNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkClusterAccelerationStructureCommandsInfoNV at(long index) {
            return new VkClusterAccelerationStructureCommandsInfoNV(segment.asSlice(index * VkClusterAccelerationStructureCommandsInfoNV.BYTES, VkClusterAccelerationStructureCommandsInfoNV.BYTES));
        }

        public VkClusterAccelerationStructureCommandsInfoNV.Ptr at(long index, @NotNull Consumer<@NotNull VkClusterAccelerationStructureCommandsInfoNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkClusterAccelerationStructureCommandsInfoNV value) {
            MemorySegment s = segment.asSlice(index * VkClusterAccelerationStructureCommandsInfoNV.BYTES, VkClusterAccelerationStructureCommandsInfoNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkClusterAccelerationStructureCommandsInfoNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkClusterAccelerationStructureCommandsInfoNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkClusterAccelerationStructureCommandsInfoNV.BYTES,
                (end - start) * VkClusterAccelerationStructureCommandsInfoNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkClusterAccelerationStructureCommandsInfoNV.BYTES));
        }

        public VkClusterAccelerationStructureCommandsInfoNV[] toArray() {
            VkClusterAccelerationStructureCommandsInfoNV[] ret = new VkClusterAccelerationStructureCommandsInfoNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkClusterAccelerationStructureCommandsInfoNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkClusterAccelerationStructureCommandsInfoNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkClusterAccelerationStructureCommandsInfoNV.BYTES;
            }

            @Override
            public VkClusterAccelerationStructureCommandsInfoNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkClusterAccelerationStructureCommandsInfoNV ret = new VkClusterAccelerationStructureCommandsInfoNV(segment.asSlice(0, VkClusterAccelerationStructureCommandsInfoNV.BYTES));
                segment = segment.asSlice(VkClusterAccelerationStructureCommandsInfoNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkClusterAccelerationStructureCommandsInfoNV allocate(Arena arena) {
        VkClusterAccelerationStructureCommandsInfoNV ret = new VkClusterAccelerationStructureCommandsInfoNV(arena.allocate(LAYOUT));
        ret.autoInit();
        return ret;
    }

    public static VkClusterAccelerationStructureCommandsInfoNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkClusterAccelerationStructureCommandsInfoNV.Ptr ret = new VkClusterAccelerationStructureCommandsInfoNV.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).autoInit();
        }
        return ret;
    }

    public static VkClusterAccelerationStructureCommandsInfoNV clone(Arena arena, VkClusterAccelerationStructureCommandsInfoNV src) {
        VkClusterAccelerationStructureCommandsInfoNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.CLUSTER_ACCELERATION_STRUCTURE_COMMANDS_INFO_NV);
        input().autoInit();
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkClusterAccelerationStructureCommandsInfoNV sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkClusterAccelerationStructureCommandsInfoNV pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkClusterAccelerationStructureCommandsInfoNV pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NotNull VkClusterAccelerationStructureInputInfoNV input() {
        return new VkClusterAccelerationStructureInputInfoNV(segment.asSlice(OFFSET$input, LAYOUT$input));
    }

    public VkClusterAccelerationStructureCommandsInfoNV input(@NotNull VkClusterAccelerationStructureInputInfoNV value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$input, SIZE$input);
        return this;
    }

    public VkClusterAccelerationStructureCommandsInfoNV input(Consumer<@NotNull VkClusterAccelerationStructureInputInfoNV> consumer) {
        consumer.accept(input());
        return this;
    }

    public @NativeType("VkDeviceAddress") @Unsigned long dstImplicitData() {
        return segment.get(LAYOUT$dstImplicitData, OFFSET$dstImplicitData);
    }

    public VkClusterAccelerationStructureCommandsInfoNV dstImplicitData(@NativeType("VkDeviceAddress") @Unsigned long value) {
        segment.set(LAYOUT$dstImplicitData, OFFSET$dstImplicitData, value);
        return this;
    }

    public @NativeType("VkDeviceAddress") @Unsigned long scratchData() {
        return segment.get(LAYOUT$scratchData, OFFSET$scratchData);
    }

    public VkClusterAccelerationStructureCommandsInfoNV scratchData(@NativeType("VkDeviceAddress") @Unsigned long value) {
        segment.set(LAYOUT$scratchData, OFFSET$scratchData, value);
        return this;
    }

    public @NotNull VkStridedDeviceAddressRegionKHR dstAddressesArray() {
        return new VkStridedDeviceAddressRegionKHR(segment.asSlice(OFFSET$dstAddressesArray, LAYOUT$dstAddressesArray));
    }

    public VkClusterAccelerationStructureCommandsInfoNV dstAddressesArray(@NotNull VkStridedDeviceAddressRegionKHR value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$dstAddressesArray, SIZE$dstAddressesArray);
        return this;
    }

    public VkClusterAccelerationStructureCommandsInfoNV dstAddressesArray(Consumer<@NotNull VkStridedDeviceAddressRegionKHR> consumer) {
        consumer.accept(dstAddressesArray());
        return this;
    }

    public @NotNull VkStridedDeviceAddressRegionKHR dstSizesArray() {
        return new VkStridedDeviceAddressRegionKHR(segment.asSlice(OFFSET$dstSizesArray, LAYOUT$dstSizesArray));
    }

    public VkClusterAccelerationStructureCommandsInfoNV dstSizesArray(@NotNull VkStridedDeviceAddressRegionKHR value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$dstSizesArray, SIZE$dstSizesArray);
        return this;
    }

    public VkClusterAccelerationStructureCommandsInfoNV dstSizesArray(Consumer<@NotNull VkStridedDeviceAddressRegionKHR> consumer) {
        consumer.accept(dstSizesArray());
        return this;
    }

    public @NotNull VkStridedDeviceAddressRegionKHR srcInfosArray() {
        return new VkStridedDeviceAddressRegionKHR(segment.asSlice(OFFSET$srcInfosArray, LAYOUT$srcInfosArray));
    }

    public VkClusterAccelerationStructureCommandsInfoNV srcInfosArray(@NotNull VkStridedDeviceAddressRegionKHR value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$srcInfosArray, SIZE$srcInfosArray);
        return this;
    }

    public VkClusterAccelerationStructureCommandsInfoNV srcInfosArray(Consumer<@NotNull VkStridedDeviceAddressRegionKHR> consumer) {
        consumer.accept(srcInfosArray());
        return this;
    }

    public @NativeType("VkDeviceAddress") @Unsigned long srcInfosCount() {
        return segment.get(LAYOUT$srcInfosCount, OFFSET$srcInfosCount);
    }

    public VkClusterAccelerationStructureCommandsInfoNV srcInfosCount(@NativeType("VkDeviceAddress") @Unsigned long value) {
        segment.set(LAYOUT$srcInfosCount, OFFSET$srcInfosCount, value);
        return this;
    }

    public @Bitmask(VkClusterAccelerationStructureAddressResolutionFlagsNV.class) int addressResolutionFlags() {
        return segment.get(LAYOUT$addressResolutionFlags, OFFSET$addressResolutionFlags);
    }

    public VkClusterAccelerationStructureCommandsInfoNV addressResolutionFlags(@Bitmask(VkClusterAccelerationStructureAddressResolutionFlagsNV.class) int value) {
        segment.set(LAYOUT$addressResolutionFlags, OFFSET$addressResolutionFlags, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        VkClusterAccelerationStructureInputInfoNV.LAYOUT.withName("input"),
        ValueLayout.JAVA_LONG.withName("dstImplicitData"),
        ValueLayout.JAVA_LONG.withName("scratchData"),
        VkStridedDeviceAddressRegionKHR.LAYOUT.withName("dstAddressesArray"),
        VkStridedDeviceAddressRegionKHR.LAYOUT.withName("dstSizesArray"),
        VkStridedDeviceAddressRegionKHR.LAYOUT.withName("srcInfosArray"),
        ValueLayout.JAVA_LONG.withName("srcInfosCount"),
        ValueLayout.JAVA_INT.withName("addressResolutionFlags")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$input = PathElement.groupElement("input");
    public static final PathElement PATH$dstImplicitData = PathElement.groupElement("dstImplicitData");
    public static final PathElement PATH$scratchData = PathElement.groupElement("scratchData");
    public static final PathElement PATH$dstAddressesArray = PathElement.groupElement("dstAddressesArray");
    public static final PathElement PATH$dstSizesArray = PathElement.groupElement("dstSizesArray");
    public static final PathElement PATH$srcInfosArray = PathElement.groupElement("srcInfosArray");
    public static final PathElement PATH$srcInfosCount = PathElement.groupElement("srcInfosCount");
    public static final PathElement PATH$addressResolutionFlags = PathElement.groupElement("addressResolutionFlags");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final StructLayout LAYOUT$input = (StructLayout) LAYOUT.select(PATH$input);
    public static final OfLong LAYOUT$dstImplicitData = (OfLong) LAYOUT.select(PATH$dstImplicitData);
    public static final OfLong LAYOUT$scratchData = (OfLong) LAYOUT.select(PATH$scratchData);
    public static final StructLayout LAYOUT$dstAddressesArray = (StructLayout) LAYOUT.select(PATH$dstAddressesArray);
    public static final StructLayout LAYOUT$dstSizesArray = (StructLayout) LAYOUT.select(PATH$dstSizesArray);
    public static final StructLayout LAYOUT$srcInfosArray = (StructLayout) LAYOUT.select(PATH$srcInfosArray);
    public static final OfLong LAYOUT$srcInfosCount = (OfLong) LAYOUT.select(PATH$srcInfosCount);
    public static final OfInt LAYOUT$addressResolutionFlags = (OfInt) LAYOUT.select(PATH$addressResolutionFlags);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$input = LAYOUT$input.byteSize();
    public static final long SIZE$dstImplicitData = LAYOUT$dstImplicitData.byteSize();
    public static final long SIZE$scratchData = LAYOUT$scratchData.byteSize();
    public static final long SIZE$dstAddressesArray = LAYOUT$dstAddressesArray.byteSize();
    public static final long SIZE$dstSizesArray = LAYOUT$dstSizesArray.byteSize();
    public static final long SIZE$srcInfosArray = LAYOUT$srcInfosArray.byteSize();
    public static final long SIZE$srcInfosCount = LAYOUT$srcInfosCount.byteSize();
    public static final long SIZE$addressResolutionFlags = LAYOUT$addressResolutionFlags.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$input = LAYOUT.byteOffset(PATH$input);
    public static final long OFFSET$dstImplicitData = LAYOUT.byteOffset(PATH$dstImplicitData);
    public static final long OFFSET$scratchData = LAYOUT.byteOffset(PATH$scratchData);
    public static final long OFFSET$dstAddressesArray = LAYOUT.byteOffset(PATH$dstAddressesArray);
    public static final long OFFSET$dstSizesArray = LAYOUT.byteOffset(PATH$dstSizesArray);
    public static final long OFFSET$srcInfosArray = LAYOUT.byteOffset(PATH$srcInfosArray);
    public static final long OFFSET$srcInfosCount = LAYOUT.byteOffset(PATH$srcInfosCount);
    public static final long OFFSET$addressResolutionFlags = LAYOUT.byteOffset(PATH$addressResolutionFlags);
}
