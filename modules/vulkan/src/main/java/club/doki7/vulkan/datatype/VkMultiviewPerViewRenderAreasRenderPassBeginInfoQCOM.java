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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM.html"><code>VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t perViewRenderAreaCount; // optional // @link substring="perViewRenderAreaCount" target="#perViewRenderAreaCount"
///     VkRect2D const* pPerViewRenderAreas; // optional // @link substring="VkRect2D" target="VkRect2D" @link substring="pPerViewRenderAreas" target="#pPerViewRenderAreas"
/// } VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_MULTIVIEW_PER_VIEW_RENDER_AREAS_RENDER_PASS_BEGIN_INFO_QCOM`
///
/// The {@code allocate} ({@link VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM#allocate(Arena)}, {@link VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM.html"><code>VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM(@NotNull MemorySegment segment) implements IVkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM.html"><code>VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM, Iterable<VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM> {
        public long size() {
            return segment.byteSize() / VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM at(long index) {
            return new VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM(segment.asSlice(index * VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM.BYTES, VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM.BYTES));
        }

        public VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM.Ptr at(long index, @NotNull Consumer<@NotNull VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM value) {
            MemorySegment s = segment.asSlice(index * VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM.BYTES, VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM.BYTES,
                (end - start) * VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM.BYTES));
        }

        public VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM[] toArray() {
            VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM[] ret = new VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM.BYTES;
            }

            @Override
            public VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM ret = new VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM(segment.asSlice(0, VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM.BYTES));
                segment = segment.asSlice(VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM allocate(Arena arena) {
        VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM ret = new VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.MULTIVIEW_PER_VIEW_RENDER_AREAS_RENDER_PASS_BEGIN_INFO_QCOM);
        return ret;
    }

    public static VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM.Ptr ret = new VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.MULTIVIEW_PER_VIEW_RENDER_AREAS_RENDER_PASS_BEGIN_INFO_QCOM);
        }
        return ret;
    }

    public static VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM clone(Arena arena, VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM src) {
        VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.MULTIVIEW_PER_VIEW_RENDER_AREAS_RENDER_PASS_BEGIN_INFO_QCOM);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int perViewRenderAreaCount() {
        return segment.get(LAYOUT$perViewRenderAreaCount, OFFSET$perViewRenderAreaCount);
    }

    public VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM perViewRenderAreaCount(@Unsigned int value) {
        segment.set(LAYOUT$perViewRenderAreaCount, OFFSET$perViewRenderAreaCount, value);
        return this;
    }

    public VkMultiviewPerViewRenderAreasRenderPassBeginInfoQCOM pPerViewRenderAreas(@Nullable IVkRect2D value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pPerViewRenderAreasRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkRect2D.Ptr pPerViewRenderAreas(int assumedCount) {
        MemorySegment s = pPerViewRenderAreasRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkRect2D.BYTES);
        return new VkRect2D.Ptr(s);
    }

    public @Nullable VkRect2D pPerViewRenderAreas() {
        MemorySegment s = pPerViewRenderAreasRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkRect2D(s);
    }

    public @Pointer(target=VkRect2D.class) @NotNull MemorySegment pPerViewRenderAreasRaw() {
        return segment.get(LAYOUT$pPerViewRenderAreas, OFFSET$pPerViewRenderAreas);
    }

    public void pPerViewRenderAreasRaw(@Pointer(target=VkRect2D.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pPerViewRenderAreas, OFFSET$pPerViewRenderAreas, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("perViewRenderAreaCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkRect2D.LAYOUT).withName("pPerViewRenderAreas")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$perViewRenderAreaCount = PathElement.groupElement("perViewRenderAreaCount");
    public static final PathElement PATH$pPerViewRenderAreas = PathElement.groupElement("pPerViewRenderAreas");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$perViewRenderAreaCount = (OfInt) LAYOUT.select(PATH$perViewRenderAreaCount);
    public static final AddressLayout LAYOUT$pPerViewRenderAreas = (AddressLayout) LAYOUT.select(PATH$pPerViewRenderAreas);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$perViewRenderAreaCount = LAYOUT$perViewRenderAreaCount.byteSize();
    public static final long SIZE$pPerViewRenderAreas = LAYOUT$pPerViewRenderAreas.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$perViewRenderAreaCount = LAYOUT.byteOffset(PATH$perViewRenderAreaCount);
    public static final long OFFSET$pPerViewRenderAreas = LAYOUT.byteOffset(PATH$pPerViewRenderAreas);
}
