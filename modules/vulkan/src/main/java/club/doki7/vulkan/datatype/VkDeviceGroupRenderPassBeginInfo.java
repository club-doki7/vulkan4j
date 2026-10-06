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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDeviceGroupRenderPassBeginInfo.html"><code>VkDeviceGroupRenderPassBeginInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDeviceGroupRenderPassBeginInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t deviceMask; // @link substring="deviceMask" target="#deviceMask"
///     uint32_t deviceRenderAreaCount; // optional // @link substring="deviceRenderAreaCount" target="#deviceRenderAreaCount"
///     VkRect2D const* pDeviceRenderAreas; // optional // @link substring="VkRect2D" target="VkRect2D" @link substring="pDeviceRenderAreas" target="#pDeviceRenderAreas"
/// } VkDeviceGroupRenderPassBeginInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_DEVICE_GROUP_RENDER_PASS_BEGIN_INFO`
///
/// The {@code allocate} ({@link VkDeviceGroupRenderPassBeginInfo#allocate(Arena)}, {@link VkDeviceGroupRenderPassBeginInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkDeviceGroupRenderPassBeginInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDeviceGroupRenderPassBeginInfo.html"><code>VkDeviceGroupRenderPassBeginInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDeviceGroupRenderPassBeginInfo(@NotNull MemorySegment segment) implements IVkDeviceGroupRenderPassBeginInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDeviceGroupRenderPassBeginInfo.html"><code>VkDeviceGroupRenderPassBeginInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDeviceGroupRenderPassBeginInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDeviceGroupRenderPassBeginInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDeviceGroupRenderPassBeginInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDeviceGroupRenderPassBeginInfo, Iterable<VkDeviceGroupRenderPassBeginInfo> {
        public long size() {
            return segment.byteSize() / VkDeviceGroupRenderPassBeginInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDeviceGroupRenderPassBeginInfo at(long index) {
            return new VkDeviceGroupRenderPassBeginInfo(segment.asSlice(index * VkDeviceGroupRenderPassBeginInfo.BYTES, VkDeviceGroupRenderPassBeginInfo.BYTES));
        }

        public VkDeviceGroupRenderPassBeginInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkDeviceGroupRenderPassBeginInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDeviceGroupRenderPassBeginInfo value) {
            MemorySegment s = segment.asSlice(index * VkDeviceGroupRenderPassBeginInfo.BYTES, VkDeviceGroupRenderPassBeginInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDeviceGroupRenderPassBeginInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDeviceGroupRenderPassBeginInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDeviceGroupRenderPassBeginInfo.BYTES,
                (end - start) * VkDeviceGroupRenderPassBeginInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDeviceGroupRenderPassBeginInfo.BYTES));
        }

        public VkDeviceGroupRenderPassBeginInfo[] toArray() {
            VkDeviceGroupRenderPassBeginInfo[] ret = new VkDeviceGroupRenderPassBeginInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDeviceGroupRenderPassBeginInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDeviceGroupRenderPassBeginInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDeviceGroupRenderPassBeginInfo.BYTES;
            }

            @Override
            public VkDeviceGroupRenderPassBeginInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDeviceGroupRenderPassBeginInfo ret = new VkDeviceGroupRenderPassBeginInfo(segment.asSlice(0, VkDeviceGroupRenderPassBeginInfo.BYTES));
                segment = segment.asSlice(VkDeviceGroupRenderPassBeginInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDeviceGroupRenderPassBeginInfo allocate(Arena arena) {
        VkDeviceGroupRenderPassBeginInfo ret = new VkDeviceGroupRenderPassBeginInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.DEVICE_GROUP_RENDER_PASS_BEGIN_INFO);
        return ret;
    }

    public static VkDeviceGroupRenderPassBeginInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkDeviceGroupRenderPassBeginInfo.Ptr ret = new VkDeviceGroupRenderPassBeginInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.DEVICE_GROUP_RENDER_PASS_BEGIN_INFO);
        }
        return ret;
    }

    public static VkDeviceGroupRenderPassBeginInfo clone(Arena arena, VkDeviceGroupRenderPassBeginInfo src) {
        VkDeviceGroupRenderPassBeginInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.DEVICE_GROUP_RENDER_PASS_BEGIN_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkDeviceGroupRenderPassBeginInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkDeviceGroupRenderPassBeginInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkDeviceGroupRenderPassBeginInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int deviceMask() {
        return segment.get(LAYOUT$deviceMask, OFFSET$deviceMask);
    }

    public VkDeviceGroupRenderPassBeginInfo deviceMask(@Unsigned int value) {
        segment.set(LAYOUT$deviceMask, OFFSET$deviceMask, value);
        return this;
    }

    public @Unsigned int deviceRenderAreaCount() {
        return segment.get(LAYOUT$deviceRenderAreaCount, OFFSET$deviceRenderAreaCount);
    }

    public VkDeviceGroupRenderPassBeginInfo deviceRenderAreaCount(@Unsigned int value) {
        segment.set(LAYOUT$deviceRenderAreaCount, OFFSET$deviceRenderAreaCount, value);
        return this;
    }

    public VkDeviceGroupRenderPassBeginInfo pDeviceRenderAreas(@Nullable IVkRect2D value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pDeviceRenderAreasRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkRect2D.Ptr pDeviceRenderAreas(int assumedCount) {
        MemorySegment s = pDeviceRenderAreasRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkRect2D.BYTES);
        return new VkRect2D.Ptr(s);
    }

    public @Nullable VkRect2D pDeviceRenderAreas() {
        MemorySegment s = pDeviceRenderAreasRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkRect2D(s);
    }

    public @Pointer(target=VkRect2D.class) @NotNull MemorySegment pDeviceRenderAreasRaw() {
        return segment.get(LAYOUT$pDeviceRenderAreas, OFFSET$pDeviceRenderAreas);
    }

    public void pDeviceRenderAreasRaw(@Pointer(target=VkRect2D.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pDeviceRenderAreas, OFFSET$pDeviceRenderAreas, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("deviceMask"),
        ValueLayout.JAVA_INT.withName("deviceRenderAreaCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkRect2D.LAYOUT).withName("pDeviceRenderAreas")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$deviceMask = PathElement.groupElement("deviceMask");
    public static final PathElement PATH$deviceRenderAreaCount = PathElement.groupElement("deviceRenderAreaCount");
    public static final PathElement PATH$pDeviceRenderAreas = PathElement.groupElement("pDeviceRenderAreas");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$deviceMask = (OfInt) LAYOUT.select(PATH$deviceMask);
    public static final OfInt LAYOUT$deviceRenderAreaCount = (OfInt) LAYOUT.select(PATH$deviceRenderAreaCount);
    public static final AddressLayout LAYOUT$pDeviceRenderAreas = (AddressLayout) LAYOUT.select(PATH$pDeviceRenderAreas);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$deviceMask = LAYOUT$deviceMask.byteSize();
    public static final long SIZE$deviceRenderAreaCount = LAYOUT$deviceRenderAreaCount.byteSize();
    public static final long SIZE$pDeviceRenderAreas = LAYOUT$pDeviceRenderAreas.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$deviceMask = LAYOUT.byteOffset(PATH$deviceMask);
    public static final long OFFSET$deviceRenderAreaCount = LAYOUT.byteOffset(PATH$deviceRenderAreaCount);
    public static final long OFFSET$pDeviceRenderAreas = LAYOUT.byteOffset(PATH$pDeviceRenderAreas);
}
