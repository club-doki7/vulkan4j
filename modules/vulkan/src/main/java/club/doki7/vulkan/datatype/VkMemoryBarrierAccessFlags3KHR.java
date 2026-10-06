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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMemoryBarrierAccessFlags3KHR.html"><code>VkMemoryBarrierAccessFlags3KHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkMemoryBarrierAccessFlags3KHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkAccessFlags3KHR srcAccessMask3; // optional // @link substring="VkAccessFlags3KHR" target="VkAccessFlags3KHR" @link substring="srcAccessMask3" target="#srcAccessMask3"
///     VkAccessFlags3KHR dstAccessMask3; // optional // @link substring="VkAccessFlags3KHR" target="VkAccessFlags3KHR" @link substring="dstAccessMask3" target="#dstAccessMask3"
/// } VkMemoryBarrierAccessFlags3KHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_MEMORY_BARRIER_ACCESS_FLAGS_3_KHR`
///
/// The {@code allocate} ({@link VkMemoryBarrierAccessFlags3KHR#allocate(Arena)}, {@link VkMemoryBarrierAccessFlags3KHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkMemoryBarrierAccessFlags3KHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMemoryBarrierAccessFlags3KHR.html"><code>VkMemoryBarrierAccessFlags3KHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkMemoryBarrierAccessFlags3KHR(@NotNull MemorySegment segment) implements IVkMemoryBarrierAccessFlags3KHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMemoryBarrierAccessFlags3KHR.html"><code>VkMemoryBarrierAccessFlags3KHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkMemoryBarrierAccessFlags3KHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkMemoryBarrierAccessFlags3KHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkMemoryBarrierAccessFlags3KHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkMemoryBarrierAccessFlags3KHR, Iterable<VkMemoryBarrierAccessFlags3KHR> {
        public long size() {
            return segment.byteSize() / VkMemoryBarrierAccessFlags3KHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkMemoryBarrierAccessFlags3KHR at(long index) {
            return new VkMemoryBarrierAccessFlags3KHR(segment.asSlice(index * VkMemoryBarrierAccessFlags3KHR.BYTES, VkMemoryBarrierAccessFlags3KHR.BYTES));
        }

        public VkMemoryBarrierAccessFlags3KHR.Ptr at(long index, @NotNull Consumer<@NotNull VkMemoryBarrierAccessFlags3KHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkMemoryBarrierAccessFlags3KHR value) {
            MemorySegment s = segment.asSlice(index * VkMemoryBarrierAccessFlags3KHR.BYTES, VkMemoryBarrierAccessFlags3KHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkMemoryBarrierAccessFlags3KHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkMemoryBarrierAccessFlags3KHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkMemoryBarrierAccessFlags3KHR.BYTES,
                (end - start) * VkMemoryBarrierAccessFlags3KHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkMemoryBarrierAccessFlags3KHR.BYTES));
        }

        public VkMemoryBarrierAccessFlags3KHR[] toArray() {
            VkMemoryBarrierAccessFlags3KHR[] ret = new VkMemoryBarrierAccessFlags3KHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkMemoryBarrierAccessFlags3KHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkMemoryBarrierAccessFlags3KHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkMemoryBarrierAccessFlags3KHR.BYTES;
            }

            @Override
            public VkMemoryBarrierAccessFlags3KHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkMemoryBarrierAccessFlags3KHR ret = new VkMemoryBarrierAccessFlags3KHR(segment.asSlice(0, VkMemoryBarrierAccessFlags3KHR.BYTES));
                segment = segment.asSlice(VkMemoryBarrierAccessFlags3KHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkMemoryBarrierAccessFlags3KHR allocate(Arena arena) {
        VkMemoryBarrierAccessFlags3KHR ret = new VkMemoryBarrierAccessFlags3KHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.MEMORY_BARRIER_ACCESS_FLAGS_3_KHR);
        return ret;
    }

    public static VkMemoryBarrierAccessFlags3KHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkMemoryBarrierAccessFlags3KHR.Ptr ret = new VkMemoryBarrierAccessFlags3KHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.MEMORY_BARRIER_ACCESS_FLAGS_3_KHR);
        }
        return ret;
    }

    public static VkMemoryBarrierAccessFlags3KHR clone(Arena arena, VkMemoryBarrierAccessFlags3KHR src) {
        VkMemoryBarrierAccessFlags3KHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.MEMORY_BARRIER_ACCESS_FLAGS_3_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkMemoryBarrierAccessFlags3KHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkMemoryBarrierAccessFlags3KHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkMemoryBarrierAccessFlags3KHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkAccessFlags3KHR.class) long srcAccessMask3() {
        return segment.get(LAYOUT$srcAccessMask3, OFFSET$srcAccessMask3);
    }

    public VkMemoryBarrierAccessFlags3KHR srcAccessMask3(@Bitmask(VkAccessFlags3KHR.class) long value) {
        segment.set(LAYOUT$srcAccessMask3, OFFSET$srcAccessMask3, value);
        return this;
    }

    public @Bitmask(VkAccessFlags3KHR.class) long dstAccessMask3() {
        return segment.get(LAYOUT$dstAccessMask3, OFFSET$dstAccessMask3);
    }

    public VkMemoryBarrierAccessFlags3KHR dstAccessMask3(@Bitmask(VkAccessFlags3KHR.class) long value) {
        segment.set(LAYOUT$dstAccessMask3, OFFSET$dstAccessMask3, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_LONG.withName("srcAccessMask3"),
        ValueLayout.JAVA_LONG.withName("dstAccessMask3")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$srcAccessMask3 = PathElement.groupElement("srcAccessMask3");
    public static final PathElement PATH$dstAccessMask3 = PathElement.groupElement("dstAccessMask3");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfLong LAYOUT$srcAccessMask3 = (OfLong) LAYOUT.select(PATH$srcAccessMask3);
    public static final OfLong LAYOUT$dstAccessMask3 = (OfLong) LAYOUT.select(PATH$dstAccessMask3);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$srcAccessMask3 = LAYOUT$srcAccessMask3.byteSize();
    public static final long SIZE$dstAccessMask3 = LAYOUT$dstAccessMask3.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$srcAccessMask3 = LAYOUT.byteOffset(PATH$srcAccessMask3);
    public static final long OFFSET$dstAccessMask3 = LAYOUT.byteOffset(PATH$dstAccessMask3);
}
