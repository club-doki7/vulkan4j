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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCheckpointData2NV.html"><code>VkCheckpointData2NV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkCheckpointData2NV {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkPipelineStageFlags2 stage; // @link substring="VkPipelineStageFlags2" target="VkPipelineStageFlags2" @link substring="stage" target="#stage"
///     void* pCheckpointMarker; // @link substring="pCheckpointMarker" target="#pCheckpointMarker"
/// } VkCheckpointData2NV;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_CHECKPOINT_DATA_2_NV`
///
/// The {@code allocate} ({@link VkCheckpointData2NV#allocate(Arena)}, {@link VkCheckpointData2NV#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkCheckpointData2NV#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCheckpointData2NV.html"><code>VkCheckpointData2NV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkCheckpointData2NV(@NotNull MemorySegment segment) implements IVkCheckpointData2NV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCheckpointData2NV.html"><code>VkCheckpointData2NV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkCheckpointData2NV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkCheckpointData2NV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkCheckpointData2NV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkCheckpointData2NV, Iterable<VkCheckpointData2NV> {
        public long size() {
            return segment.byteSize() / VkCheckpointData2NV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkCheckpointData2NV at(long index) {
            return new VkCheckpointData2NV(segment.asSlice(index * VkCheckpointData2NV.BYTES, VkCheckpointData2NV.BYTES));
        }

        public VkCheckpointData2NV.Ptr at(long index, @NotNull Consumer<@NotNull VkCheckpointData2NV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkCheckpointData2NV value) {
            MemorySegment s = segment.asSlice(index * VkCheckpointData2NV.BYTES, VkCheckpointData2NV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkCheckpointData2NV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkCheckpointData2NV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkCheckpointData2NV.BYTES,
                (end - start) * VkCheckpointData2NV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkCheckpointData2NV.BYTES));
        }

        public VkCheckpointData2NV[] toArray() {
            VkCheckpointData2NV[] ret = new VkCheckpointData2NV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkCheckpointData2NV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkCheckpointData2NV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkCheckpointData2NV.BYTES;
            }

            @Override
            public VkCheckpointData2NV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkCheckpointData2NV ret = new VkCheckpointData2NV(segment.asSlice(0, VkCheckpointData2NV.BYTES));
                segment = segment.asSlice(VkCheckpointData2NV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkCheckpointData2NV allocate(Arena arena) {
        VkCheckpointData2NV ret = new VkCheckpointData2NV(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.CHECKPOINT_DATA_2_NV);
        return ret;
    }

    public static VkCheckpointData2NV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkCheckpointData2NV.Ptr ret = new VkCheckpointData2NV.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.CHECKPOINT_DATA_2_NV);
        }
        return ret;
    }

    public static VkCheckpointData2NV clone(Arena arena, VkCheckpointData2NV src) {
        VkCheckpointData2NV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.CHECKPOINT_DATA_2_NV);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkCheckpointData2NV sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkCheckpointData2NV pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkCheckpointData2NV pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkPipelineStageFlags2.class) long stage() {
        return segment.get(LAYOUT$stage, OFFSET$stage);
    }

    public VkCheckpointData2NV stage(@Bitmask(VkPipelineStageFlags2.class) long value) {
        segment.set(LAYOUT$stage, OFFSET$stage, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pCheckpointMarker() {
        return segment.get(LAYOUT$pCheckpointMarker, OFFSET$pCheckpointMarker);
    }

    public VkCheckpointData2NV pCheckpointMarker(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pCheckpointMarker, OFFSET$pCheckpointMarker, value);
        return this;
    }

    public VkCheckpointData2NV pCheckpointMarker(@Nullable IPointer pointer) {
        pCheckpointMarker(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_LONG.withName("stage"),
        ValueLayout.ADDRESS.withName("pCheckpointMarker")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$stage = PathElement.groupElement("stage");
    public static final PathElement PATH$pCheckpointMarker = PathElement.groupElement("pCheckpointMarker");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfLong LAYOUT$stage = (OfLong) LAYOUT.select(PATH$stage);
    public static final AddressLayout LAYOUT$pCheckpointMarker = (AddressLayout) LAYOUT.select(PATH$pCheckpointMarker);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$stage = LAYOUT$stage.byteSize();
    public static final long SIZE$pCheckpointMarker = LAYOUT$pCheckpointMarker.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$stage = LAYOUT.byteOffset(PATH$stage);
    public static final long OFFSET$pCheckpointMarker = LAYOUT.byteOffset(PATH$pCheckpointMarker);
}
