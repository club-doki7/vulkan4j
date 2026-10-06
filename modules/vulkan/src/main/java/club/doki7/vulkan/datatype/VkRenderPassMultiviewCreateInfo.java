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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRenderPassMultiviewCreateInfo.html"><code>VkRenderPassMultiviewCreateInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkRenderPassMultiviewCreateInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t subpassCount; // optional // @link substring="subpassCount" target="#subpassCount"
///     uint32_t const* pViewMasks; // optional // @link substring="pViewMasks" target="#pViewMasks"
///     uint32_t dependencyCount; // optional // @link substring="dependencyCount" target="#dependencyCount"
///     int32_t const* pViewOffsets; // optional // @link substring="pViewOffsets" target="#pViewOffsets"
///     uint32_t correlationMaskCount; // optional // @link substring="correlationMaskCount" target="#correlationMaskCount"
///     uint32_t const* pCorrelationMasks; // optional // @link substring="pCorrelationMasks" target="#pCorrelationMasks"
/// } VkRenderPassMultiviewCreateInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_RENDER_PASS_MULTIVIEW_CREATE_INFO`
///
/// The {@code allocate} ({@link VkRenderPassMultiviewCreateInfo#allocate(Arena)}, {@link VkRenderPassMultiviewCreateInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkRenderPassMultiviewCreateInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRenderPassMultiviewCreateInfo.html"><code>VkRenderPassMultiviewCreateInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkRenderPassMultiviewCreateInfo(@NotNull MemorySegment segment) implements IVkRenderPassMultiviewCreateInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRenderPassMultiviewCreateInfo.html"><code>VkRenderPassMultiviewCreateInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkRenderPassMultiviewCreateInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkRenderPassMultiviewCreateInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkRenderPassMultiviewCreateInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkRenderPassMultiviewCreateInfo, Iterable<VkRenderPassMultiviewCreateInfo> {
        public long size() {
            return segment.byteSize() / VkRenderPassMultiviewCreateInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkRenderPassMultiviewCreateInfo at(long index) {
            return new VkRenderPassMultiviewCreateInfo(segment.asSlice(index * VkRenderPassMultiviewCreateInfo.BYTES, VkRenderPassMultiviewCreateInfo.BYTES));
        }

        public VkRenderPassMultiviewCreateInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkRenderPassMultiviewCreateInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkRenderPassMultiviewCreateInfo value) {
            MemorySegment s = segment.asSlice(index * VkRenderPassMultiviewCreateInfo.BYTES, VkRenderPassMultiviewCreateInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkRenderPassMultiviewCreateInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkRenderPassMultiviewCreateInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkRenderPassMultiviewCreateInfo.BYTES,
                (end - start) * VkRenderPassMultiviewCreateInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkRenderPassMultiviewCreateInfo.BYTES));
        }

        public VkRenderPassMultiviewCreateInfo[] toArray() {
            VkRenderPassMultiviewCreateInfo[] ret = new VkRenderPassMultiviewCreateInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkRenderPassMultiviewCreateInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkRenderPassMultiviewCreateInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkRenderPassMultiviewCreateInfo.BYTES;
            }

            @Override
            public VkRenderPassMultiviewCreateInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkRenderPassMultiviewCreateInfo ret = new VkRenderPassMultiviewCreateInfo(segment.asSlice(0, VkRenderPassMultiviewCreateInfo.BYTES));
                segment = segment.asSlice(VkRenderPassMultiviewCreateInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkRenderPassMultiviewCreateInfo allocate(Arena arena) {
        VkRenderPassMultiviewCreateInfo ret = new VkRenderPassMultiviewCreateInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.RENDER_PASS_MULTIVIEW_CREATE_INFO);
        return ret;
    }

    public static VkRenderPassMultiviewCreateInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkRenderPassMultiviewCreateInfo.Ptr ret = new VkRenderPassMultiviewCreateInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.RENDER_PASS_MULTIVIEW_CREATE_INFO);
        }
        return ret;
    }

    public static VkRenderPassMultiviewCreateInfo clone(Arena arena, VkRenderPassMultiviewCreateInfo src) {
        VkRenderPassMultiviewCreateInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.RENDER_PASS_MULTIVIEW_CREATE_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkRenderPassMultiviewCreateInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkRenderPassMultiviewCreateInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkRenderPassMultiviewCreateInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int subpassCount() {
        return segment.get(LAYOUT$subpassCount, OFFSET$subpassCount);
    }

    public VkRenderPassMultiviewCreateInfo subpassCount(@Unsigned int value) {
        segment.set(LAYOUT$subpassCount, OFFSET$subpassCount, value);
        return this;
    }

    /// Note: the returned {@link IntPtr} does not have correct
    /// {@link IntPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link IntPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable @Unsigned IntPtr pViewMasks() {
        MemorySegment s = pViewMasksRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new IntPtr(s);
    }

    public VkRenderPassMultiviewCreateInfo pViewMasks(@Nullable @Unsigned IntPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pViewMasksRaw(s);
        return this;
    }

    public @Pointer(comment="uint32_t*") @NotNull MemorySegment pViewMasksRaw() {
        return segment.get(LAYOUT$pViewMasks, OFFSET$pViewMasks);
    }

    public void pViewMasksRaw(@Pointer(comment="uint32_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pViewMasks, OFFSET$pViewMasks, value);
    }

    public @Unsigned int dependencyCount() {
        return segment.get(LAYOUT$dependencyCount, OFFSET$dependencyCount);
    }

    public VkRenderPassMultiviewCreateInfo dependencyCount(@Unsigned int value) {
        segment.set(LAYOUT$dependencyCount, OFFSET$dependencyCount, value);
        return this;
    }

    /// Note: the returned {@link IntPtr} does not have correct
    /// {@link IntPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link IntPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable IntPtr pViewOffsets() {
        MemorySegment s = pViewOffsetsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new IntPtr(s);
    }

    public VkRenderPassMultiviewCreateInfo pViewOffsets(@Nullable IntPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pViewOffsetsRaw(s);
        return this;
    }

    public @Pointer(comment="int32_t*") @NotNull MemorySegment pViewOffsetsRaw() {
        return segment.get(LAYOUT$pViewOffsets, OFFSET$pViewOffsets);
    }

    public void pViewOffsetsRaw(@Pointer(comment="int32_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pViewOffsets, OFFSET$pViewOffsets, value);
    }

    public @Unsigned int correlationMaskCount() {
        return segment.get(LAYOUT$correlationMaskCount, OFFSET$correlationMaskCount);
    }

    public VkRenderPassMultiviewCreateInfo correlationMaskCount(@Unsigned int value) {
        segment.set(LAYOUT$correlationMaskCount, OFFSET$correlationMaskCount, value);
        return this;
    }

    /// Note: the returned {@link IntPtr} does not have correct
    /// {@link IntPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link IntPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable @Unsigned IntPtr pCorrelationMasks() {
        MemorySegment s = pCorrelationMasksRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new IntPtr(s);
    }

    public VkRenderPassMultiviewCreateInfo pCorrelationMasks(@Nullable @Unsigned IntPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pCorrelationMasksRaw(s);
        return this;
    }

    public @Pointer(comment="uint32_t*") @NotNull MemorySegment pCorrelationMasksRaw() {
        return segment.get(LAYOUT$pCorrelationMasks, OFFSET$pCorrelationMasks);
    }

    public void pCorrelationMasksRaw(@Pointer(comment="uint32_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pCorrelationMasks, OFFSET$pCorrelationMasks, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("subpassCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pViewMasks"),
        ValueLayout.JAVA_INT.withName("dependencyCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pViewOffsets"),
        ValueLayout.JAVA_INT.withName("correlationMaskCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pCorrelationMasks")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$subpassCount = PathElement.groupElement("subpassCount");
    public static final PathElement PATH$pViewMasks = PathElement.groupElement("pViewMasks");
    public static final PathElement PATH$dependencyCount = PathElement.groupElement("dependencyCount");
    public static final PathElement PATH$pViewOffsets = PathElement.groupElement("pViewOffsets");
    public static final PathElement PATH$correlationMaskCount = PathElement.groupElement("correlationMaskCount");
    public static final PathElement PATH$pCorrelationMasks = PathElement.groupElement("pCorrelationMasks");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$subpassCount = (OfInt) LAYOUT.select(PATH$subpassCount);
    public static final AddressLayout LAYOUT$pViewMasks = (AddressLayout) LAYOUT.select(PATH$pViewMasks);
    public static final OfInt LAYOUT$dependencyCount = (OfInt) LAYOUT.select(PATH$dependencyCount);
    public static final AddressLayout LAYOUT$pViewOffsets = (AddressLayout) LAYOUT.select(PATH$pViewOffsets);
    public static final OfInt LAYOUT$correlationMaskCount = (OfInt) LAYOUT.select(PATH$correlationMaskCount);
    public static final AddressLayout LAYOUT$pCorrelationMasks = (AddressLayout) LAYOUT.select(PATH$pCorrelationMasks);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$subpassCount = LAYOUT$subpassCount.byteSize();
    public static final long SIZE$pViewMasks = LAYOUT$pViewMasks.byteSize();
    public static final long SIZE$dependencyCount = LAYOUT$dependencyCount.byteSize();
    public static final long SIZE$pViewOffsets = LAYOUT$pViewOffsets.byteSize();
    public static final long SIZE$correlationMaskCount = LAYOUT$correlationMaskCount.byteSize();
    public static final long SIZE$pCorrelationMasks = LAYOUT$pCorrelationMasks.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$subpassCount = LAYOUT.byteOffset(PATH$subpassCount);
    public static final long OFFSET$pViewMasks = LAYOUT.byteOffset(PATH$pViewMasks);
    public static final long OFFSET$dependencyCount = LAYOUT.byteOffset(PATH$dependencyCount);
    public static final long OFFSET$pViewOffsets = LAYOUT.byteOffset(PATH$pViewOffsets);
    public static final long OFFSET$correlationMaskCount = LAYOUT.byteOffset(PATH$correlationMaskCount);
    public static final long OFFSET$pCorrelationMasks = LAYOUT.byteOffset(PATH$pCorrelationMasks);
}
