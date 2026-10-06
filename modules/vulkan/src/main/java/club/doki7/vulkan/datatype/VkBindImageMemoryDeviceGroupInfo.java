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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBindImageMemoryDeviceGroupInfo.html"><code>VkBindImageMemoryDeviceGroupInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkBindImageMemoryDeviceGroupInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t deviceIndexCount; // optional // @link substring="deviceIndexCount" target="#deviceIndexCount"
///     uint32_t const* pDeviceIndices; // optional // @link substring="pDeviceIndices" target="#pDeviceIndices"
///     uint32_t splitInstanceBindRegionCount; // optional // @link substring="splitInstanceBindRegionCount" target="#splitInstanceBindRegionCount"
///     VkRect2D const* pSplitInstanceBindRegions; // optional // @link substring="VkRect2D" target="VkRect2D" @link substring="pSplitInstanceBindRegions" target="#pSplitInstanceBindRegions"
/// } VkBindImageMemoryDeviceGroupInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_BIND_IMAGE_MEMORY_DEVICE_GROUP_INFO`
///
/// The {@code allocate} ({@link VkBindImageMemoryDeviceGroupInfo#allocate(Arena)}, {@link VkBindImageMemoryDeviceGroupInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkBindImageMemoryDeviceGroupInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBindImageMemoryDeviceGroupInfo.html"><code>VkBindImageMemoryDeviceGroupInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkBindImageMemoryDeviceGroupInfo(@NotNull MemorySegment segment) implements IVkBindImageMemoryDeviceGroupInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBindImageMemoryDeviceGroupInfo.html"><code>VkBindImageMemoryDeviceGroupInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkBindImageMemoryDeviceGroupInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkBindImageMemoryDeviceGroupInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkBindImageMemoryDeviceGroupInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkBindImageMemoryDeviceGroupInfo, Iterable<VkBindImageMemoryDeviceGroupInfo> {
        public long size() {
            return segment.byteSize() / VkBindImageMemoryDeviceGroupInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkBindImageMemoryDeviceGroupInfo at(long index) {
            return new VkBindImageMemoryDeviceGroupInfo(segment.asSlice(index * VkBindImageMemoryDeviceGroupInfo.BYTES, VkBindImageMemoryDeviceGroupInfo.BYTES));
        }

        public VkBindImageMemoryDeviceGroupInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkBindImageMemoryDeviceGroupInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkBindImageMemoryDeviceGroupInfo value) {
            MemorySegment s = segment.asSlice(index * VkBindImageMemoryDeviceGroupInfo.BYTES, VkBindImageMemoryDeviceGroupInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkBindImageMemoryDeviceGroupInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkBindImageMemoryDeviceGroupInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkBindImageMemoryDeviceGroupInfo.BYTES,
                (end - start) * VkBindImageMemoryDeviceGroupInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkBindImageMemoryDeviceGroupInfo.BYTES));
        }

        public VkBindImageMemoryDeviceGroupInfo[] toArray() {
            VkBindImageMemoryDeviceGroupInfo[] ret = new VkBindImageMemoryDeviceGroupInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkBindImageMemoryDeviceGroupInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkBindImageMemoryDeviceGroupInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkBindImageMemoryDeviceGroupInfo.BYTES;
            }

            @Override
            public VkBindImageMemoryDeviceGroupInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkBindImageMemoryDeviceGroupInfo ret = new VkBindImageMemoryDeviceGroupInfo(segment.asSlice(0, VkBindImageMemoryDeviceGroupInfo.BYTES));
                segment = segment.asSlice(VkBindImageMemoryDeviceGroupInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkBindImageMemoryDeviceGroupInfo allocate(Arena arena) {
        VkBindImageMemoryDeviceGroupInfo ret = new VkBindImageMemoryDeviceGroupInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.BIND_IMAGE_MEMORY_DEVICE_GROUP_INFO);
        return ret;
    }

    public static VkBindImageMemoryDeviceGroupInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkBindImageMemoryDeviceGroupInfo.Ptr ret = new VkBindImageMemoryDeviceGroupInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.BIND_IMAGE_MEMORY_DEVICE_GROUP_INFO);
        }
        return ret;
    }

    public static VkBindImageMemoryDeviceGroupInfo clone(Arena arena, VkBindImageMemoryDeviceGroupInfo src) {
        VkBindImageMemoryDeviceGroupInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.BIND_IMAGE_MEMORY_DEVICE_GROUP_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkBindImageMemoryDeviceGroupInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkBindImageMemoryDeviceGroupInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkBindImageMemoryDeviceGroupInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int deviceIndexCount() {
        return segment.get(LAYOUT$deviceIndexCount, OFFSET$deviceIndexCount);
    }

    public VkBindImageMemoryDeviceGroupInfo deviceIndexCount(@Unsigned int value) {
        segment.set(LAYOUT$deviceIndexCount, OFFSET$deviceIndexCount, value);
        return this;
    }

    /// Note: the returned {@link IntPtr} does not have correct
    /// {@link IntPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link IntPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable @Unsigned IntPtr pDeviceIndices() {
        MemorySegment s = pDeviceIndicesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new IntPtr(s);
    }

    public VkBindImageMemoryDeviceGroupInfo pDeviceIndices(@Nullable @Unsigned IntPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pDeviceIndicesRaw(s);
        return this;
    }

    public @Pointer(comment="uint32_t*") @NotNull MemorySegment pDeviceIndicesRaw() {
        return segment.get(LAYOUT$pDeviceIndices, OFFSET$pDeviceIndices);
    }

    public void pDeviceIndicesRaw(@Pointer(comment="uint32_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pDeviceIndices, OFFSET$pDeviceIndices, value);
    }

    public @Unsigned int splitInstanceBindRegionCount() {
        return segment.get(LAYOUT$splitInstanceBindRegionCount, OFFSET$splitInstanceBindRegionCount);
    }

    public VkBindImageMemoryDeviceGroupInfo splitInstanceBindRegionCount(@Unsigned int value) {
        segment.set(LAYOUT$splitInstanceBindRegionCount, OFFSET$splitInstanceBindRegionCount, value);
        return this;
    }

    public VkBindImageMemoryDeviceGroupInfo pSplitInstanceBindRegions(@Nullable IVkRect2D value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pSplitInstanceBindRegionsRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkRect2D.Ptr pSplitInstanceBindRegions(int assumedCount) {
        MemorySegment s = pSplitInstanceBindRegionsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkRect2D.BYTES);
        return new VkRect2D.Ptr(s);
    }

    public @Nullable VkRect2D pSplitInstanceBindRegions() {
        MemorySegment s = pSplitInstanceBindRegionsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkRect2D(s);
    }

    public @Pointer(target=VkRect2D.class) @NotNull MemorySegment pSplitInstanceBindRegionsRaw() {
        return segment.get(LAYOUT$pSplitInstanceBindRegions, OFFSET$pSplitInstanceBindRegions);
    }

    public void pSplitInstanceBindRegionsRaw(@Pointer(target=VkRect2D.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pSplitInstanceBindRegions, OFFSET$pSplitInstanceBindRegions, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("deviceIndexCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pDeviceIndices"),
        ValueLayout.JAVA_INT.withName("splitInstanceBindRegionCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkRect2D.LAYOUT).withName("pSplitInstanceBindRegions")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$deviceIndexCount = PathElement.groupElement("deviceIndexCount");
    public static final PathElement PATH$pDeviceIndices = PathElement.groupElement("pDeviceIndices");
    public static final PathElement PATH$splitInstanceBindRegionCount = PathElement.groupElement("splitInstanceBindRegionCount");
    public static final PathElement PATH$pSplitInstanceBindRegions = PathElement.groupElement("pSplitInstanceBindRegions");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$deviceIndexCount = (OfInt) LAYOUT.select(PATH$deviceIndexCount);
    public static final AddressLayout LAYOUT$pDeviceIndices = (AddressLayout) LAYOUT.select(PATH$pDeviceIndices);
    public static final OfInt LAYOUT$splitInstanceBindRegionCount = (OfInt) LAYOUT.select(PATH$splitInstanceBindRegionCount);
    public static final AddressLayout LAYOUT$pSplitInstanceBindRegions = (AddressLayout) LAYOUT.select(PATH$pSplitInstanceBindRegions);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$deviceIndexCount = LAYOUT$deviceIndexCount.byteSize();
    public static final long SIZE$pDeviceIndices = LAYOUT$pDeviceIndices.byteSize();
    public static final long SIZE$splitInstanceBindRegionCount = LAYOUT$splitInstanceBindRegionCount.byteSize();
    public static final long SIZE$pSplitInstanceBindRegions = LAYOUT$pSplitInstanceBindRegions.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$deviceIndexCount = LAYOUT.byteOffset(PATH$deviceIndexCount);
    public static final long OFFSET$pDeviceIndices = LAYOUT.byteOffset(PATH$pDeviceIndices);
    public static final long OFFSET$splitInstanceBindRegionCount = LAYOUT.byteOffset(PATH$splitInstanceBindRegionCount);
    public static final long OFFSET$pSplitInstanceBindRegions = LAYOUT.byteOffset(PATH$pSplitInstanceBindRegions);
}
