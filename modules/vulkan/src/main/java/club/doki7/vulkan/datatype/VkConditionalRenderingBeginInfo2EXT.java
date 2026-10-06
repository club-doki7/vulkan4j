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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkConditionalRenderingBeginInfo2EXT.html"><code>VkConditionalRenderingBeginInfo2EXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkConditionalRenderingBeginInfo2EXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkDeviceAddressRangeKHR addressRange; // @link substring="VkDeviceAddressRangeKHR" target="VkDeviceAddressRangeKHR" @link substring="addressRange" target="#addressRange"
///     VkAddressCommandFlagsKHR addressFlags; // optional // @link substring="VkAddressCommandFlagsKHR" target="VkAddressCommandFlagsKHR" @link substring="addressFlags" target="#addressFlags"
///     VkConditionalRenderingFlagsEXT flags; // optional // @link substring="VkConditionalRenderingFlagsEXT" target="VkConditionalRenderingFlagsEXT" @link substring="flags" target="#flags"
/// } VkConditionalRenderingBeginInfo2EXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_CONDITIONAL_RENDERING_BEGIN_INFO_2_EXT`
///
/// The {@code allocate} ({@link VkConditionalRenderingBeginInfo2EXT#allocate(Arena)}, {@link VkConditionalRenderingBeginInfo2EXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkConditionalRenderingBeginInfo2EXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkConditionalRenderingBeginInfo2EXT.html"><code>VkConditionalRenderingBeginInfo2EXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkConditionalRenderingBeginInfo2EXT(@NotNull MemorySegment segment) implements IVkConditionalRenderingBeginInfo2EXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkConditionalRenderingBeginInfo2EXT.html"><code>VkConditionalRenderingBeginInfo2EXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkConditionalRenderingBeginInfo2EXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkConditionalRenderingBeginInfo2EXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkConditionalRenderingBeginInfo2EXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkConditionalRenderingBeginInfo2EXT, Iterable<VkConditionalRenderingBeginInfo2EXT> {
        public long size() {
            return segment.byteSize() / VkConditionalRenderingBeginInfo2EXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkConditionalRenderingBeginInfo2EXT at(long index) {
            return new VkConditionalRenderingBeginInfo2EXT(segment.asSlice(index * VkConditionalRenderingBeginInfo2EXT.BYTES, VkConditionalRenderingBeginInfo2EXT.BYTES));
        }

        public VkConditionalRenderingBeginInfo2EXT.Ptr at(long index, @NotNull Consumer<@NotNull VkConditionalRenderingBeginInfo2EXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkConditionalRenderingBeginInfo2EXT value) {
            MemorySegment s = segment.asSlice(index * VkConditionalRenderingBeginInfo2EXT.BYTES, VkConditionalRenderingBeginInfo2EXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkConditionalRenderingBeginInfo2EXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkConditionalRenderingBeginInfo2EXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkConditionalRenderingBeginInfo2EXT.BYTES,
                (end - start) * VkConditionalRenderingBeginInfo2EXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkConditionalRenderingBeginInfo2EXT.BYTES));
        }

        public VkConditionalRenderingBeginInfo2EXT[] toArray() {
            VkConditionalRenderingBeginInfo2EXT[] ret = new VkConditionalRenderingBeginInfo2EXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkConditionalRenderingBeginInfo2EXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkConditionalRenderingBeginInfo2EXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkConditionalRenderingBeginInfo2EXT.BYTES;
            }

            @Override
            public VkConditionalRenderingBeginInfo2EXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkConditionalRenderingBeginInfo2EXT ret = new VkConditionalRenderingBeginInfo2EXT(segment.asSlice(0, VkConditionalRenderingBeginInfo2EXT.BYTES));
                segment = segment.asSlice(VkConditionalRenderingBeginInfo2EXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkConditionalRenderingBeginInfo2EXT allocate(Arena arena) {
        VkConditionalRenderingBeginInfo2EXT ret = new VkConditionalRenderingBeginInfo2EXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.CONDITIONAL_RENDERING_BEGIN_INFO_2_EXT);
        return ret;
    }

    public static VkConditionalRenderingBeginInfo2EXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkConditionalRenderingBeginInfo2EXT.Ptr ret = new VkConditionalRenderingBeginInfo2EXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.CONDITIONAL_RENDERING_BEGIN_INFO_2_EXT);
        }
        return ret;
    }

    public static VkConditionalRenderingBeginInfo2EXT clone(Arena arena, VkConditionalRenderingBeginInfo2EXT src) {
        VkConditionalRenderingBeginInfo2EXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.CONDITIONAL_RENDERING_BEGIN_INFO_2_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkConditionalRenderingBeginInfo2EXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkConditionalRenderingBeginInfo2EXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkConditionalRenderingBeginInfo2EXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NotNull VkDeviceAddressRangeKHR addressRange() {
        return new VkDeviceAddressRangeKHR(segment.asSlice(OFFSET$addressRange, LAYOUT$addressRange));
    }

    public VkConditionalRenderingBeginInfo2EXT addressRange(@NotNull VkDeviceAddressRangeKHR value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$addressRange, SIZE$addressRange);
        return this;
    }

    public VkConditionalRenderingBeginInfo2EXT addressRange(Consumer<@NotNull VkDeviceAddressRangeKHR> consumer) {
        consumer.accept(addressRange());
        return this;
    }

    public @Bitmask(VkAddressCommandFlagsKHR.class) int addressFlags() {
        return segment.get(LAYOUT$addressFlags, OFFSET$addressFlags);
    }

    public VkConditionalRenderingBeginInfo2EXT addressFlags(@Bitmask(VkAddressCommandFlagsKHR.class) int value) {
        segment.set(LAYOUT$addressFlags, OFFSET$addressFlags, value);
        return this;
    }

    public @Bitmask(VkConditionalRenderingFlagsEXT.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkConditionalRenderingBeginInfo2EXT flags(@Bitmask(VkConditionalRenderingFlagsEXT.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        VkDeviceAddressRangeKHR.LAYOUT.withName("addressRange"),
        ValueLayout.JAVA_INT.withName("addressFlags"),
        ValueLayout.JAVA_INT.withName("flags")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$addressRange = PathElement.groupElement("addressRange");
    public static final PathElement PATH$addressFlags = PathElement.groupElement("addressFlags");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final StructLayout LAYOUT$addressRange = (StructLayout) LAYOUT.select(PATH$addressRange);
    public static final OfInt LAYOUT$addressFlags = (OfInt) LAYOUT.select(PATH$addressFlags);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$addressRange = LAYOUT$addressRange.byteSize();
    public static final long SIZE$addressFlags = LAYOUT$addressFlags.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$addressRange = LAYOUT.byteOffset(PATH$addressRange);
    public static final long OFFSET$addressFlags = LAYOUT.byteOffset(PATH$addressFlags);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
}
