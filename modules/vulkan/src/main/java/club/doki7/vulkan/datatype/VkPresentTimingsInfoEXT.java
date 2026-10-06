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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPresentTimingsInfoEXT.html"><code>VkPresentTimingsInfoEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPresentTimingsInfoEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t swapchainCount; // @link substring="swapchainCount" target="#swapchainCount"
///     VkPresentTimingInfoEXT const* pTimingInfos; // @link substring="VkPresentTimingInfoEXT" target="VkPresentTimingInfoEXT" @link substring="pTimingInfos" target="#pTimingInfos"
/// } VkPresentTimingsInfoEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PRESENT_TIMINGS_INFO_EXT`
///
/// The {@code allocate} ({@link VkPresentTimingsInfoEXT#allocate(Arena)}, {@link VkPresentTimingsInfoEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPresentTimingsInfoEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPresentTimingsInfoEXT.html"><code>VkPresentTimingsInfoEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPresentTimingsInfoEXT(@NotNull MemorySegment segment) implements IVkPresentTimingsInfoEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPresentTimingsInfoEXT.html"><code>VkPresentTimingsInfoEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPresentTimingsInfoEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPresentTimingsInfoEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPresentTimingsInfoEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPresentTimingsInfoEXT, Iterable<VkPresentTimingsInfoEXT> {
        public long size() {
            return segment.byteSize() / VkPresentTimingsInfoEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPresentTimingsInfoEXT at(long index) {
            return new VkPresentTimingsInfoEXT(segment.asSlice(index * VkPresentTimingsInfoEXT.BYTES, VkPresentTimingsInfoEXT.BYTES));
        }

        public VkPresentTimingsInfoEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkPresentTimingsInfoEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPresentTimingsInfoEXT value) {
            MemorySegment s = segment.asSlice(index * VkPresentTimingsInfoEXT.BYTES, VkPresentTimingsInfoEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPresentTimingsInfoEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPresentTimingsInfoEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPresentTimingsInfoEXT.BYTES,
                (end - start) * VkPresentTimingsInfoEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPresentTimingsInfoEXT.BYTES));
        }

        public VkPresentTimingsInfoEXT[] toArray() {
            VkPresentTimingsInfoEXT[] ret = new VkPresentTimingsInfoEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPresentTimingsInfoEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPresentTimingsInfoEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPresentTimingsInfoEXT.BYTES;
            }

            @Override
            public VkPresentTimingsInfoEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPresentTimingsInfoEXT ret = new VkPresentTimingsInfoEXT(segment.asSlice(0, VkPresentTimingsInfoEXT.BYTES));
                segment = segment.asSlice(VkPresentTimingsInfoEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPresentTimingsInfoEXT allocate(Arena arena) {
        VkPresentTimingsInfoEXT ret = new VkPresentTimingsInfoEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PRESENT_TIMINGS_INFO_EXT);
        return ret;
    }

    public static VkPresentTimingsInfoEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPresentTimingsInfoEXT.Ptr ret = new VkPresentTimingsInfoEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PRESENT_TIMINGS_INFO_EXT);
        }
        return ret;
    }

    public static VkPresentTimingsInfoEXT clone(Arena arena, VkPresentTimingsInfoEXT src) {
        VkPresentTimingsInfoEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PRESENT_TIMINGS_INFO_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPresentTimingsInfoEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPresentTimingsInfoEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPresentTimingsInfoEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int swapchainCount() {
        return segment.get(LAYOUT$swapchainCount, OFFSET$swapchainCount);
    }

    public VkPresentTimingsInfoEXT swapchainCount(@Unsigned int value) {
        segment.set(LAYOUT$swapchainCount, OFFSET$swapchainCount, value);
        return this;
    }

    public VkPresentTimingsInfoEXT pTimingInfos(@Nullable IVkPresentTimingInfoEXT value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pTimingInfosRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkPresentTimingInfoEXT.Ptr pTimingInfos(int assumedCount) {
        MemorySegment s = pTimingInfosRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkPresentTimingInfoEXT.BYTES);
        return new VkPresentTimingInfoEXT.Ptr(s);
    }

    public @Nullable VkPresentTimingInfoEXT pTimingInfos() {
        MemorySegment s = pTimingInfosRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkPresentTimingInfoEXT(s);
    }

    public @Pointer(target=VkPresentTimingInfoEXT.class) @NotNull MemorySegment pTimingInfosRaw() {
        return segment.get(LAYOUT$pTimingInfos, OFFSET$pTimingInfos);
    }

    public void pTimingInfosRaw(@Pointer(target=VkPresentTimingInfoEXT.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pTimingInfos, OFFSET$pTimingInfos, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("swapchainCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkPresentTimingInfoEXT.LAYOUT).withName("pTimingInfos")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$swapchainCount = PathElement.groupElement("swapchainCount");
    public static final PathElement PATH$pTimingInfos = PathElement.groupElement("pTimingInfos");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$swapchainCount = (OfInt) LAYOUT.select(PATH$swapchainCount);
    public static final AddressLayout LAYOUT$pTimingInfos = (AddressLayout) LAYOUT.select(PATH$pTimingInfos);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$swapchainCount = LAYOUT$swapchainCount.byteSize();
    public static final long SIZE$pTimingInfos = LAYOUT$pTimingInfos.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$swapchainCount = LAYOUT.byteOffset(PATH$swapchainCount);
    public static final long OFFSET$pTimingInfos = LAYOUT.byteOffset(PATH$pTimingInfos);
}
