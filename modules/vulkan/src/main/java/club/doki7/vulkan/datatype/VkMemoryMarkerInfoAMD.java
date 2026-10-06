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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMemoryMarkerInfoAMD.html"><code>VkMemoryMarkerInfoAMD</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkMemoryMarkerInfoAMD {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkPipelineStageFlags2KHR stage; // @link substring="VkPipelineStageFlags2" target="VkPipelineStageFlags2KHR" @link substring="stage" target="#stage"
///     VkDeviceAddressRangeKHR dstRange; // @link substring="VkDeviceAddressRangeKHR" target="VkDeviceAddressRangeKHR" @link substring="dstRange" target="#dstRange"
///     VkAddressCommandFlagsKHR dstFlags; // optional // @link substring="VkAddressCommandFlagsKHR" target="VkAddressCommandFlagsKHR" @link substring="dstFlags" target="#dstFlags"
///     uint32_t marker; // @link substring="marker" target="#marker"
/// } VkMemoryMarkerInfoAMD;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_MEMORY_MARKER_INFO_AMD`
///
/// The {@code allocate} ({@link VkMemoryMarkerInfoAMD#allocate(Arena)}, {@link VkMemoryMarkerInfoAMD#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkMemoryMarkerInfoAMD#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMemoryMarkerInfoAMD.html"><code>VkMemoryMarkerInfoAMD</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkMemoryMarkerInfoAMD(@NotNull MemorySegment segment) implements IVkMemoryMarkerInfoAMD {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMemoryMarkerInfoAMD.html"><code>VkMemoryMarkerInfoAMD</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkMemoryMarkerInfoAMD}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkMemoryMarkerInfoAMD to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkMemoryMarkerInfoAMD.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkMemoryMarkerInfoAMD, Iterable<VkMemoryMarkerInfoAMD> {
        public long size() {
            return segment.byteSize() / VkMemoryMarkerInfoAMD.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkMemoryMarkerInfoAMD at(long index) {
            return new VkMemoryMarkerInfoAMD(segment.asSlice(index * VkMemoryMarkerInfoAMD.BYTES, VkMemoryMarkerInfoAMD.BYTES));
        }

        public VkMemoryMarkerInfoAMD.Ptr at(long index, @NotNull Consumer<@NotNull VkMemoryMarkerInfoAMD> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkMemoryMarkerInfoAMD value) {
            MemorySegment s = segment.asSlice(index * VkMemoryMarkerInfoAMD.BYTES, VkMemoryMarkerInfoAMD.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkMemoryMarkerInfoAMD.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkMemoryMarkerInfoAMD.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkMemoryMarkerInfoAMD.BYTES,
                (end - start) * VkMemoryMarkerInfoAMD.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkMemoryMarkerInfoAMD.BYTES));
        }

        public VkMemoryMarkerInfoAMD[] toArray() {
            VkMemoryMarkerInfoAMD[] ret = new VkMemoryMarkerInfoAMD[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkMemoryMarkerInfoAMD> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkMemoryMarkerInfoAMD> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkMemoryMarkerInfoAMD.BYTES;
            }

            @Override
            public VkMemoryMarkerInfoAMD next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkMemoryMarkerInfoAMD ret = new VkMemoryMarkerInfoAMD(segment.asSlice(0, VkMemoryMarkerInfoAMD.BYTES));
                segment = segment.asSlice(VkMemoryMarkerInfoAMD.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkMemoryMarkerInfoAMD allocate(Arena arena) {
        VkMemoryMarkerInfoAMD ret = new VkMemoryMarkerInfoAMD(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.MEMORY_MARKER_INFO_AMD);
        return ret;
    }

    public static VkMemoryMarkerInfoAMD.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkMemoryMarkerInfoAMD.Ptr ret = new VkMemoryMarkerInfoAMD.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.MEMORY_MARKER_INFO_AMD);
        }
        return ret;
    }

    public static VkMemoryMarkerInfoAMD clone(Arena arena, VkMemoryMarkerInfoAMD src) {
        VkMemoryMarkerInfoAMD ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.MEMORY_MARKER_INFO_AMD);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkMemoryMarkerInfoAMD sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkMemoryMarkerInfoAMD pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkMemoryMarkerInfoAMD pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkPipelineStageFlags2.class) long stage() {
        return segment.get(LAYOUT$stage, OFFSET$stage);
    }

    public VkMemoryMarkerInfoAMD stage(@Bitmask(VkPipelineStageFlags2.class) long value) {
        segment.set(LAYOUT$stage, OFFSET$stage, value);
        return this;
    }

    public @NotNull VkDeviceAddressRangeKHR dstRange() {
        return new VkDeviceAddressRangeKHR(segment.asSlice(OFFSET$dstRange, LAYOUT$dstRange));
    }

    public VkMemoryMarkerInfoAMD dstRange(@NotNull VkDeviceAddressRangeKHR value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$dstRange, SIZE$dstRange);
        return this;
    }

    public VkMemoryMarkerInfoAMD dstRange(Consumer<@NotNull VkDeviceAddressRangeKHR> consumer) {
        consumer.accept(dstRange());
        return this;
    }

    public @Bitmask(VkAddressCommandFlagsKHR.class) int dstFlags() {
        return segment.get(LAYOUT$dstFlags, OFFSET$dstFlags);
    }

    public VkMemoryMarkerInfoAMD dstFlags(@Bitmask(VkAddressCommandFlagsKHR.class) int value) {
        segment.set(LAYOUT$dstFlags, OFFSET$dstFlags, value);
        return this;
    }

    public @Unsigned int marker() {
        return segment.get(LAYOUT$marker, OFFSET$marker);
    }

    public VkMemoryMarkerInfoAMD marker(@Unsigned int value) {
        segment.set(LAYOUT$marker, OFFSET$marker, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_LONG.withName("stage"),
        VkDeviceAddressRangeKHR.LAYOUT.withName("dstRange"),
        ValueLayout.JAVA_INT.withName("dstFlags"),
        ValueLayout.JAVA_INT.withName("marker")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$stage = PathElement.groupElement("stage");
    public static final PathElement PATH$dstRange = PathElement.groupElement("dstRange");
    public static final PathElement PATH$dstFlags = PathElement.groupElement("dstFlags");
    public static final PathElement PATH$marker = PathElement.groupElement("marker");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfLong LAYOUT$stage = (OfLong) LAYOUT.select(PATH$stage);
    public static final StructLayout LAYOUT$dstRange = (StructLayout) LAYOUT.select(PATH$dstRange);
    public static final OfInt LAYOUT$dstFlags = (OfInt) LAYOUT.select(PATH$dstFlags);
    public static final OfInt LAYOUT$marker = (OfInt) LAYOUT.select(PATH$marker);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$stage = LAYOUT$stage.byteSize();
    public static final long SIZE$dstRange = LAYOUT$dstRange.byteSize();
    public static final long SIZE$dstFlags = LAYOUT$dstFlags.byteSize();
    public static final long SIZE$marker = LAYOUT$marker.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$stage = LAYOUT.byteOffset(PATH$stage);
    public static final long OFFSET$dstRange = LAYOUT.byteOffset(PATH$dstRange);
    public static final long OFFSET$dstFlags = LAYOUT.byteOffset(PATH$dstFlags);
    public static final long OFFSET$marker = LAYOUT.byteOffset(PATH$marker);
}
