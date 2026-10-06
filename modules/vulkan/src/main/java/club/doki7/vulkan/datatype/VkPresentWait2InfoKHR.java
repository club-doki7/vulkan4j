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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPresentWait2InfoKHR.html"><code>VkPresentWait2InfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPresentWait2InfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint64_t presentId; // @link substring="presentId" target="#presentId"
///     uint64_t timeout; // @link substring="timeout" target="#timeout"
/// } VkPresentWait2InfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PRESENT_WAIT_2_INFO_KHR`
///
/// The {@code allocate} ({@link VkPresentWait2InfoKHR#allocate(Arena)}, {@link VkPresentWait2InfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPresentWait2InfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPresentWait2InfoKHR.html"><code>VkPresentWait2InfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPresentWait2InfoKHR(@NotNull MemorySegment segment) implements IVkPresentWait2InfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPresentWait2InfoKHR.html"><code>VkPresentWait2InfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPresentWait2InfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPresentWait2InfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPresentWait2InfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPresentWait2InfoKHR, Iterable<VkPresentWait2InfoKHR> {
        public long size() {
            return segment.byteSize() / VkPresentWait2InfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPresentWait2InfoKHR at(long index) {
            return new VkPresentWait2InfoKHR(segment.asSlice(index * VkPresentWait2InfoKHR.BYTES, VkPresentWait2InfoKHR.BYTES));
        }

        public VkPresentWait2InfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkPresentWait2InfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPresentWait2InfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkPresentWait2InfoKHR.BYTES, VkPresentWait2InfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPresentWait2InfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPresentWait2InfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPresentWait2InfoKHR.BYTES,
                (end - start) * VkPresentWait2InfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPresentWait2InfoKHR.BYTES));
        }

        public VkPresentWait2InfoKHR[] toArray() {
            VkPresentWait2InfoKHR[] ret = new VkPresentWait2InfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPresentWait2InfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPresentWait2InfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPresentWait2InfoKHR.BYTES;
            }

            @Override
            public VkPresentWait2InfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPresentWait2InfoKHR ret = new VkPresentWait2InfoKHR(segment.asSlice(0, VkPresentWait2InfoKHR.BYTES));
                segment = segment.asSlice(VkPresentWait2InfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPresentWait2InfoKHR allocate(Arena arena) {
        VkPresentWait2InfoKHR ret = new VkPresentWait2InfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PRESENT_WAIT_2_INFO_KHR);
        return ret;
    }

    public static VkPresentWait2InfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPresentWait2InfoKHR.Ptr ret = new VkPresentWait2InfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PRESENT_WAIT_2_INFO_KHR);
        }
        return ret;
    }

    public static VkPresentWait2InfoKHR clone(Arena arena, VkPresentWait2InfoKHR src) {
        VkPresentWait2InfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PRESENT_WAIT_2_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPresentWait2InfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPresentWait2InfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPresentWait2InfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned long presentId() {
        return segment.get(LAYOUT$presentId, OFFSET$presentId);
    }

    public VkPresentWait2InfoKHR presentId(@Unsigned long value) {
        segment.set(LAYOUT$presentId, OFFSET$presentId, value);
        return this;
    }

    public @Unsigned long timeout() {
        return segment.get(LAYOUT$timeout, OFFSET$timeout);
    }

    public VkPresentWait2InfoKHR timeout(@Unsigned long value) {
        segment.set(LAYOUT$timeout, OFFSET$timeout, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_LONG.withName("presentId"),
        ValueLayout.JAVA_LONG.withName("timeout")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$presentId = PathElement.groupElement("presentId");
    public static final PathElement PATH$timeout = PathElement.groupElement("timeout");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfLong LAYOUT$presentId = (OfLong) LAYOUT.select(PATH$presentId);
    public static final OfLong LAYOUT$timeout = (OfLong) LAYOUT.select(PATH$timeout);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$presentId = LAYOUT$presentId.byteSize();
    public static final long SIZE$timeout = LAYOUT$timeout.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$presentId = LAYOUT.byteOffset(PATH$presentId);
    public static final long OFFSET$timeout = LAYOUT.byteOffset(PATH$timeout);
}
