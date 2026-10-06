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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAntiLagPresentationInfoAMD.html"><code>VkAntiLagPresentationInfoAMD</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkAntiLagPresentationInfoAMD {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkAntiLagStageAMD stage; // @link substring="VkAntiLagStageAMD" target="VkAntiLagStageAMD" @link substring="stage" target="#stage"
///     uint64_t frameIndex; // @link substring="frameIndex" target="#frameIndex"
/// } VkAntiLagPresentationInfoAMD;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_ANTI_LAG_PRESENTATION_INFO_AMD`
///
/// The {@code allocate} ({@link VkAntiLagPresentationInfoAMD#allocate(Arena)}, {@link VkAntiLagPresentationInfoAMD#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkAntiLagPresentationInfoAMD#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAntiLagPresentationInfoAMD.html"><code>VkAntiLagPresentationInfoAMD</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkAntiLagPresentationInfoAMD(@NotNull MemorySegment segment) implements IVkAntiLagPresentationInfoAMD {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAntiLagPresentationInfoAMD.html"><code>VkAntiLagPresentationInfoAMD</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkAntiLagPresentationInfoAMD}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkAntiLagPresentationInfoAMD to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkAntiLagPresentationInfoAMD.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkAntiLagPresentationInfoAMD, Iterable<VkAntiLagPresentationInfoAMD> {
        public long size() {
            return segment.byteSize() / VkAntiLagPresentationInfoAMD.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkAntiLagPresentationInfoAMD at(long index) {
            return new VkAntiLagPresentationInfoAMD(segment.asSlice(index * VkAntiLagPresentationInfoAMD.BYTES, VkAntiLagPresentationInfoAMD.BYTES));
        }

        public VkAntiLagPresentationInfoAMD.Ptr at(long index, @NotNull Consumer<@NotNull VkAntiLagPresentationInfoAMD> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkAntiLagPresentationInfoAMD value) {
            MemorySegment s = segment.asSlice(index * VkAntiLagPresentationInfoAMD.BYTES, VkAntiLagPresentationInfoAMD.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkAntiLagPresentationInfoAMD.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkAntiLagPresentationInfoAMD.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkAntiLagPresentationInfoAMD.BYTES,
                (end - start) * VkAntiLagPresentationInfoAMD.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkAntiLagPresentationInfoAMD.BYTES));
        }

        public VkAntiLagPresentationInfoAMD[] toArray() {
            VkAntiLagPresentationInfoAMD[] ret = new VkAntiLagPresentationInfoAMD[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkAntiLagPresentationInfoAMD> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkAntiLagPresentationInfoAMD> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkAntiLagPresentationInfoAMD.BYTES;
            }

            @Override
            public VkAntiLagPresentationInfoAMD next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkAntiLagPresentationInfoAMD ret = new VkAntiLagPresentationInfoAMD(segment.asSlice(0, VkAntiLagPresentationInfoAMD.BYTES));
                segment = segment.asSlice(VkAntiLagPresentationInfoAMD.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkAntiLagPresentationInfoAMD allocate(Arena arena) {
        VkAntiLagPresentationInfoAMD ret = new VkAntiLagPresentationInfoAMD(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.ANTI_LAG_PRESENTATION_INFO_AMD);
        return ret;
    }

    public static VkAntiLagPresentationInfoAMD.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkAntiLagPresentationInfoAMD.Ptr ret = new VkAntiLagPresentationInfoAMD.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.ANTI_LAG_PRESENTATION_INFO_AMD);
        }
        return ret;
    }

    public static VkAntiLagPresentationInfoAMD clone(Arena arena, VkAntiLagPresentationInfoAMD src) {
        VkAntiLagPresentationInfoAMD ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.ANTI_LAG_PRESENTATION_INFO_AMD);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkAntiLagPresentationInfoAMD sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkAntiLagPresentationInfoAMD pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkAntiLagPresentationInfoAMD pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @EnumType(VkAntiLagStageAMD.class) int stage() {
        return segment.get(LAYOUT$stage, OFFSET$stage);
    }

    public VkAntiLagPresentationInfoAMD stage(@EnumType(VkAntiLagStageAMD.class) int value) {
        segment.set(LAYOUT$stage, OFFSET$stage, value);
        return this;
    }

    public @Unsigned long frameIndex() {
        return segment.get(LAYOUT$frameIndex, OFFSET$frameIndex);
    }

    public VkAntiLagPresentationInfoAMD frameIndex(@Unsigned long value) {
        segment.set(LAYOUT$frameIndex, OFFSET$frameIndex, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("stage"),
        ValueLayout.JAVA_LONG.withName("frameIndex")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$stage = PathElement.groupElement("stage");
    public static final PathElement PATH$frameIndex = PathElement.groupElement("frameIndex");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$stage = (OfInt) LAYOUT.select(PATH$stage);
    public static final OfLong LAYOUT$frameIndex = (OfLong) LAYOUT.select(PATH$frameIndex);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$stage = LAYOUT$stage.byteSize();
    public static final long SIZE$frameIndex = LAYOUT$frameIndex.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$stage = LAYOUT.byteOffset(PATH$stage);
    public static final long OFFSET$frameIndex = LAYOUT.byteOffset(PATH$frameIndex);
}
