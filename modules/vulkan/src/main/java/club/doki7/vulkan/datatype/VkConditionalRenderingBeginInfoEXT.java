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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkConditionalRenderingBeginInfoEXT.html"><code>VkConditionalRenderingBeginInfoEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkConditionalRenderingBeginInfoEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBuffer buffer; // @link substring="VkBuffer" target="VkBuffer" @link substring="buffer" target="#buffer"
///     VkDeviceSize offset; // @link substring="offset" target="#offset"
///     VkConditionalRenderingFlagsEXT flags; // optional // @link substring="VkConditionalRenderingFlagsEXT" target="VkConditionalRenderingFlagsEXT" @link substring="flags" target="#flags"
/// } VkConditionalRenderingBeginInfoEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_CONDITIONAL_RENDERING_BEGIN_INFO_EXT`
///
/// The {@code allocate} ({@link VkConditionalRenderingBeginInfoEXT#allocate(Arena)}, {@link VkConditionalRenderingBeginInfoEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkConditionalRenderingBeginInfoEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkConditionalRenderingBeginInfoEXT.html"><code>VkConditionalRenderingBeginInfoEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkConditionalRenderingBeginInfoEXT(@NotNull MemorySegment segment) implements IVkConditionalRenderingBeginInfoEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkConditionalRenderingBeginInfoEXT.html"><code>VkConditionalRenderingBeginInfoEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkConditionalRenderingBeginInfoEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkConditionalRenderingBeginInfoEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkConditionalRenderingBeginInfoEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkConditionalRenderingBeginInfoEXT, Iterable<VkConditionalRenderingBeginInfoEXT> {
        public long size() {
            return segment.byteSize() / VkConditionalRenderingBeginInfoEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkConditionalRenderingBeginInfoEXT at(long index) {
            return new VkConditionalRenderingBeginInfoEXT(segment.asSlice(index * VkConditionalRenderingBeginInfoEXT.BYTES, VkConditionalRenderingBeginInfoEXT.BYTES));
        }

        public VkConditionalRenderingBeginInfoEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkConditionalRenderingBeginInfoEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkConditionalRenderingBeginInfoEXT value) {
            MemorySegment s = segment.asSlice(index * VkConditionalRenderingBeginInfoEXT.BYTES, VkConditionalRenderingBeginInfoEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkConditionalRenderingBeginInfoEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkConditionalRenderingBeginInfoEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkConditionalRenderingBeginInfoEXT.BYTES,
                (end - start) * VkConditionalRenderingBeginInfoEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkConditionalRenderingBeginInfoEXT.BYTES));
        }

        public VkConditionalRenderingBeginInfoEXT[] toArray() {
            VkConditionalRenderingBeginInfoEXT[] ret = new VkConditionalRenderingBeginInfoEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkConditionalRenderingBeginInfoEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkConditionalRenderingBeginInfoEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkConditionalRenderingBeginInfoEXT.BYTES;
            }

            @Override
            public VkConditionalRenderingBeginInfoEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkConditionalRenderingBeginInfoEXT ret = new VkConditionalRenderingBeginInfoEXT(segment.asSlice(0, VkConditionalRenderingBeginInfoEXT.BYTES));
                segment = segment.asSlice(VkConditionalRenderingBeginInfoEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkConditionalRenderingBeginInfoEXT allocate(Arena arena) {
        VkConditionalRenderingBeginInfoEXT ret = new VkConditionalRenderingBeginInfoEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.CONDITIONAL_RENDERING_BEGIN_INFO_EXT);
        return ret;
    }

    public static VkConditionalRenderingBeginInfoEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkConditionalRenderingBeginInfoEXT.Ptr ret = new VkConditionalRenderingBeginInfoEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.CONDITIONAL_RENDERING_BEGIN_INFO_EXT);
        }
        return ret;
    }

    public static VkConditionalRenderingBeginInfoEXT clone(Arena arena, VkConditionalRenderingBeginInfoEXT src) {
        VkConditionalRenderingBeginInfoEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.CONDITIONAL_RENDERING_BEGIN_INFO_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkConditionalRenderingBeginInfoEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkConditionalRenderingBeginInfoEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkConditionalRenderingBeginInfoEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Nullable VkBuffer buffer() {
        MemorySegment s = segment.asSlice(OFFSET$buffer, SIZE$buffer);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkBuffer(s);
    }

    public VkConditionalRenderingBeginInfoEXT buffer(@Nullable VkBuffer value) {
        segment.set(LAYOUT$buffer, OFFSET$buffer, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long offset() {
        return segment.get(LAYOUT$offset, OFFSET$offset);
    }

    public VkConditionalRenderingBeginInfoEXT offset(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$offset, OFFSET$offset, value);
        return this;
    }

    public @Bitmask(VkConditionalRenderingFlagsEXT.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkConditionalRenderingBeginInfoEXT flags(@Bitmask(VkConditionalRenderingFlagsEXT.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withName("buffer"),
        ValueLayout.JAVA_LONG.withName("offset"),
        ValueLayout.JAVA_INT.withName("flags")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$buffer = PathElement.groupElement("buffer");
    public static final PathElement PATH$offset = PathElement.groupElement("offset");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$buffer = (AddressLayout) LAYOUT.select(PATH$buffer);
    public static final OfLong LAYOUT$offset = (OfLong) LAYOUT.select(PATH$offset);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$buffer = LAYOUT$buffer.byteSize();
    public static final long SIZE$offset = LAYOUT$offset.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$buffer = LAYOUT.byteOffset(PATH$buffer);
    public static final long OFFSET$offset = LAYOUT.byteOffset(PATH$offset);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
}
