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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDependencyInfo.html"><code>VkDependencyInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDependencyInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkDependencyFlags dependencyFlags; // optional // @link substring="VkDependencyFlags" target="VkDependencyFlags" @link substring="dependencyFlags" target="#dependencyFlags"
///     uint32_t memoryBarrierCount; // optional // @link substring="memoryBarrierCount" target="#memoryBarrierCount"
///     VkMemoryBarrier2 const* pMemoryBarriers; // optional // @link substring="VkMemoryBarrier2" target="VkMemoryBarrier2" @link substring="pMemoryBarriers" target="#pMemoryBarriers"
///     uint32_t bufferMemoryBarrierCount; // optional // @link substring="bufferMemoryBarrierCount" target="#bufferMemoryBarrierCount"
///     VkBufferMemoryBarrier2 const* pBufferMemoryBarriers; // optional // @link substring="VkBufferMemoryBarrier2" target="VkBufferMemoryBarrier2" @link substring="pBufferMemoryBarriers" target="#pBufferMemoryBarriers"
///     uint32_t imageMemoryBarrierCount; // optional // @link substring="imageMemoryBarrierCount" target="#imageMemoryBarrierCount"
///     VkImageMemoryBarrier2 const* pImageMemoryBarriers; // optional // @link substring="VkImageMemoryBarrier2" target="VkImageMemoryBarrier2" @link substring="pImageMemoryBarriers" target="#pImageMemoryBarriers"
/// } VkDependencyInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_DEPENDENCY_INFO`
///
/// The {@code allocate} ({@link VkDependencyInfo#allocate(Arena)}, {@link VkDependencyInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkDependencyInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDependencyInfo.html"><code>VkDependencyInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDependencyInfo(@NotNull MemorySegment segment) implements IVkDependencyInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDependencyInfo.html"><code>VkDependencyInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDependencyInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDependencyInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDependencyInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDependencyInfo, Iterable<VkDependencyInfo> {
        public long size() {
            return segment.byteSize() / VkDependencyInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDependencyInfo at(long index) {
            return new VkDependencyInfo(segment.asSlice(index * VkDependencyInfo.BYTES, VkDependencyInfo.BYTES));
        }

        public VkDependencyInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkDependencyInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDependencyInfo value) {
            MemorySegment s = segment.asSlice(index * VkDependencyInfo.BYTES, VkDependencyInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDependencyInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDependencyInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDependencyInfo.BYTES,
                (end - start) * VkDependencyInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDependencyInfo.BYTES));
        }

        public VkDependencyInfo[] toArray() {
            VkDependencyInfo[] ret = new VkDependencyInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDependencyInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDependencyInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDependencyInfo.BYTES;
            }

            @Override
            public VkDependencyInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDependencyInfo ret = new VkDependencyInfo(segment.asSlice(0, VkDependencyInfo.BYTES));
                segment = segment.asSlice(VkDependencyInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDependencyInfo allocate(Arena arena) {
        VkDependencyInfo ret = new VkDependencyInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.DEPENDENCY_INFO);
        return ret;
    }

    public static VkDependencyInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkDependencyInfo.Ptr ret = new VkDependencyInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.DEPENDENCY_INFO);
        }
        return ret;
    }

    public static VkDependencyInfo clone(Arena arena, VkDependencyInfo src) {
        VkDependencyInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.DEPENDENCY_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkDependencyInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkDependencyInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkDependencyInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkDependencyFlags.class) int dependencyFlags() {
        return segment.get(LAYOUT$dependencyFlags, OFFSET$dependencyFlags);
    }

    public VkDependencyInfo dependencyFlags(@Bitmask(VkDependencyFlags.class) int value) {
        segment.set(LAYOUT$dependencyFlags, OFFSET$dependencyFlags, value);
        return this;
    }

    public @Unsigned int memoryBarrierCount() {
        return segment.get(LAYOUT$memoryBarrierCount, OFFSET$memoryBarrierCount);
    }

    public VkDependencyInfo memoryBarrierCount(@Unsigned int value) {
        segment.set(LAYOUT$memoryBarrierCount, OFFSET$memoryBarrierCount, value);
        return this;
    }

    public VkDependencyInfo pMemoryBarriers(@Nullable IVkMemoryBarrier2 value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pMemoryBarriersRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkMemoryBarrier2.Ptr pMemoryBarriers(int assumedCount) {
        MemorySegment s = pMemoryBarriersRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkMemoryBarrier2.BYTES);
        return new VkMemoryBarrier2.Ptr(s);
    }

    public @Nullable VkMemoryBarrier2 pMemoryBarriers() {
        MemorySegment s = pMemoryBarriersRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkMemoryBarrier2(s);
    }

    public @Pointer(target=VkMemoryBarrier2.class) @NotNull MemorySegment pMemoryBarriersRaw() {
        return segment.get(LAYOUT$pMemoryBarriers, OFFSET$pMemoryBarriers);
    }

    public void pMemoryBarriersRaw(@Pointer(target=VkMemoryBarrier2.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pMemoryBarriers, OFFSET$pMemoryBarriers, value);
    }

    public @Unsigned int bufferMemoryBarrierCount() {
        return segment.get(LAYOUT$bufferMemoryBarrierCount, OFFSET$bufferMemoryBarrierCount);
    }

    public VkDependencyInfo bufferMemoryBarrierCount(@Unsigned int value) {
        segment.set(LAYOUT$bufferMemoryBarrierCount, OFFSET$bufferMemoryBarrierCount, value);
        return this;
    }

    public VkDependencyInfo pBufferMemoryBarriers(@Nullable IVkBufferMemoryBarrier2 value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pBufferMemoryBarriersRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkBufferMemoryBarrier2.Ptr pBufferMemoryBarriers(int assumedCount) {
        MemorySegment s = pBufferMemoryBarriersRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkBufferMemoryBarrier2.BYTES);
        return new VkBufferMemoryBarrier2.Ptr(s);
    }

    public @Nullable VkBufferMemoryBarrier2 pBufferMemoryBarriers() {
        MemorySegment s = pBufferMemoryBarriersRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkBufferMemoryBarrier2(s);
    }

    public @Pointer(target=VkBufferMemoryBarrier2.class) @NotNull MemorySegment pBufferMemoryBarriersRaw() {
        return segment.get(LAYOUT$pBufferMemoryBarriers, OFFSET$pBufferMemoryBarriers);
    }

    public void pBufferMemoryBarriersRaw(@Pointer(target=VkBufferMemoryBarrier2.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pBufferMemoryBarriers, OFFSET$pBufferMemoryBarriers, value);
    }

    public @Unsigned int imageMemoryBarrierCount() {
        return segment.get(LAYOUT$imageMemoryBarrierCount, OFFSET$imageMemoryBarrierCount);
    }

    public VkDependencyInfo imageMemoryBarrierCount(@Unsigned int value) {
        segment.set(LAYOUT$imageMemoryBarrierCount, OFFSET$imageMemoryBarrierCount, value);
        return this;
    }

    public VkDependencyInfo pImageMemoryBarriers(@Nullable IVkImageMemoryBarrier2 value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pImageMemoryBarriersRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkImageMemoryBarrier2.Ptr pImageMemoryBarriers(int assumedCount) {
        MemorySegment s = pImageMemoryBarriersRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkImageMemoryBarrier2.BYTES);
        return new VkImageMemoryBarrier2.Ptr(s);
    }

    public @Nullable VkImageMemoryBarrier2 pImageMemoryBarriers() {
        MemorySegment s = pImageMemoryBarriersRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkImageMemoryBarrier2(s);
    }

    public @Pointer(target=VkImageMemoryBarrier2.class) @NotNull MemorySegment pImageMemoryBarriersRaw() {
        return segment.get(LAYOUT$pImageMemoryBarriers, OFFSET$pImageMemoryBarriers);
    }

    public void pImageMemoryBarriersRaw(@Pointer(target=VkImageMemoryBarrier2.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pImageMemoryBarriers, OFFSET$pImageMemoryBarriers, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("dependencyFlags"),
        ValueLayout.JAVA_INT.withName("memoryBarrierCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkMemoryBarrier2.LAYOUT).withName("pMemoryBarriers"),
        ValueLayout.JAVA_INT.withName("bufferMemoryBarrierCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkBufferMemoryBarrier2.LAYOUT).withName("pBufferMemoryBarriers"),
        ValueLayout.JAVA_INT.withName("imageMemoryBarrierCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkImageMemoryBarrier2.LAYOUT).withName("pImageMemoryBarriers")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$dependencyFlags = PathElement.groupElement("dependencyFlags");
    public static final PathElement PATH$memoryBarrierCount = PathElement.groupElement("memoryBarrierCount");
    public static final PathElement PATH$pMemoryBarriers = PathElement.groupElement("pMemoryBarriers");
    public static final PathElement PATH$bufferMemoryBarrierCount = PathElement.groupElement("bufferMemoryBarrierCount");
    public static final PathElement PATH$pBufferMemoryBarriers = PathElement.groupElement("pBufferMemoryBarriers");
    public static final PathElement PATH$imageMemoryBarrierCount = PathElement.groupElement("imageMemoryBarrierCount");
    public static final PathElement PATH$pImageMemoryBarriers = PathElement.groupElement("pImageMemoryBarriers");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$dependencyFlags = (OfInt) LAYOUT.select(PATH$dependencyFlags);
    public static final OfInt LAYOUT$memoryBarrierCount = (OfInt) LAYOUT.select(PATH$memoryBarrierCount);
    public static final AddressLayout LAYOUT$pMemoryBarriers = (AddressLayout) LAYOUT.select(PATH$pMemoryBarriers);
    public static final OfInt LAYOUT$bufferMemoryBarrierCount = (OfInt) LAYOUT.select(PATH$bufferMemoryBarrierCount);
    public static final AddressLayout LAYOUT$pBufferMemoryBarriers = (AddressLayout) LAYOUT.select(PATH$pBufferMemoryBarriers);
    public static final OfInt LAYOUT$imageMemoryBarrierCount = (OfInt) LAYOUT.select(PATH$imageMemoryBarrierCount);
    public static final AddressLayout LAYOUT$pImageMemoryBarriers = (AddressLayout) LAYOUT.select(PATH$pImageMemoryBarriers);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$dependencyFlags = LAYOUT$dependencyFlags.byteSize();
    public static final long SIZE$memoryBarrierCount = LAYOUT$memoryBarrierCount.byteSize();
    public static final long SIZE$pMemoryBarriers = LAYOUT$pMemoryBarriers.byteSize();
    public static final long SIZE$bufferMemoryBarrierCount = LAYOUT$bufferMemoryBarrierCount.byteSize();
    public static final long SIZE$pBufferMemoryBarriers = LAYOUT$pBufferMemoryBarriers.byteSize();
    public static final long SIZE$imageMemoryBarrierCount = LAYOUT$imageMemoryBarrierCount.byteSize();
    public static final long SIZE$pImageMemoryBarriers = LAYOUT$pImageMemoryBarriers.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$dependencyFlags = LAYOUT.byteOffset(PATH$dependencyFlags);
    public static final long OFFSET$memoryBarrierCount = LAYOUT.byteOffset(PATH$memoryBarrierCount);
    public static final long OFFSET$pMemoryBarriers = LAYOUT.byteOffset(PATH$pMemoryBarriers);
    public static final long OFFSET$bufferMemoryBarrierCount = LAYOUT.byteOffset(PATH$bufferMemoryBarrierCount);
    public static final long OFFSET$pBufferMemoryBarriers = LAYOUT.byteOffset(PATH$pBufferMemoryBarriers);
    public static final long OFFSET$imageMemoryBarrierCount = LAYOUT.byteOffset(PATH$imageMemoryBarrierCount);
    public static final long OFFSET$pImageMemoryBarriers = LAYOUT.byteOffset(PATH$pImageMemoryBarriers);
}
