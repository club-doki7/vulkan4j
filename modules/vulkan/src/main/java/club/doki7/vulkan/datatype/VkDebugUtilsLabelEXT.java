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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDebugUtilsLabelEXT.html"><code>VkDebugUtilsLabelEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDebugUtilsLabelEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     char const* pLabelName; // @link substring="pLabelName" target="#pLabelName"
///     float[4] color; // @link substring="color" target="#color"
/// } VkDebugUtilsLabelEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_DEBUG_UTILS_LABEL_EXT`
///
/// The {@code allocate} ({@link VkDebugUtilsLabelEXT#allocate(Arena)}, {@link VkDebugUtilsLabelEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkDebugUtilsLabelEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDebugUtilsLabelEXT.html"><code>VkDebugUtilsLabelEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDebugUtilsLabelEXT(@NotNull MemorySegment segment) implements IVkDebugUtilsLabelEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDebugUtilsLabelEXT.html"><code>VkDebugUtilsLabelEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDebugUtilsLabelEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDebugUtilsLabelEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDebugUtilsLabelEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDebugUtilsLabelEXT, Iterable<VkDebugUtilsLabelEXT> {
        public long size() {
            return segment.byteSize() / VkDebugUtilsLabelEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDebugUtilsLabelEXT at(long index) {
            return new VkDebugUtilsLabelEXT(segment.asSlice(index * VkDebugUtilsLabelEXT.BYTES, VkDebugUtilsLabelEXT.BYTES));
        }

        public VkDebugUtilsLabelEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkDebugUtilsLabelEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDebugUtilsLabelEXT value) {
            MemorySegment s = segment.asSlice(index * VkDebugUtilsLabelEXT.BYTES, VkDebugUtilsLabelEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDebugUtilsLabelEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDebugUtilsLabelEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDebugUtilsLabelEXT.BYTES,
                (end - start) * VkDebugUtilsLabelEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDebugUtilsLabelEXT.BYTES));
        }

        public VkDebugUtilsLabelEXT[] toArray() {
            VkDebugUtilsLabelEXT[] ret = new VkDebugUtilsLabelEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDebugUtilsLabelEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDebugUtilsLabelEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDebugUtilsLabelEXT.BYTES;
            }

            @Override
            public VkDebugUtilsLabelEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDebugUtilsLabelEXT ret = new VkDebugUtilsLabelEXT(segment.asSlice(0, VkDebugUtilsLabelEXT.BYTES));
                segment = segment.asSlice(VkDebugUtilsLabelEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDebugUtilsLabelEXT allocate(Arena arena) {
        VkDebugUtilsLabelEXT ret = new VkDebugUtilsLabelEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.DEBUG_UTILS_LABEL_EXT);
        return ret;
    }

    public static VkDebugUtilsLabelEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkDebugUtilsLabelEXT.Ptr ret = new VkDebugUtilsLabelEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.DEBUG_UTILS_LABEL_EXT);
        }
        return ret;
    }

    public static VkDebugUtilsLabelEXT clone(Arena arena, VkDebugUtilsLabelEXT src) {
        VkDebugUtilsLabelEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.DEBUG_UTILS_LABEL_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkDebugUtilsLabelEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkDebugUtilsLabelEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkDebugUtilsLabelEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    /// Note: the returned {@link BytePtr} does not have correct
    /// {@link BytePtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link BytePtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable BytePtr pLabelName() {
        MemorySegment s = pLabelNameRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new BytePtr(s);
    }

    public VkDebugUtilsLabelEXT pLabelName(@Nullable BytePtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pLabelNameRaw(s);
        return this;
    }

    public @Pointer(comment="int8_t*") @NotNull MemorySegment pLabelNameRaw() {
        return segment.get(LAYOUT$pLabelName, OFFSET$pLabelName);
    }

    public void pLabelNameRaw(@Pointer(comment="int8_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pLabelName, OFFSET$pLabelName, value);
    }

    public FloatPtr color() {
        return new FloatPtr(colorRaw());
    }

    public VkDebugUtilsLabelEXT color(@NotNull Consumer<FloatPtr> consumer) {
        FloatPtr ptr = color();
        consumer.accept(ptr);
        return this;
    }

    public VkDebugUtilsLabelEXT color(FloatPtr value) {
        MemorySegment s = colorRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment colorRaw() {
        return segment.asSlice(OFFSET$color, SIZE$color);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE).withName("pLabelName"),
        MemoryLayout.sequenceLayout(4, ValueLayout.JAVA_FLOAT).withName("color")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$pLabelName = PathElement.groupElement("pLabelName");
    public static final PathElement PATH$color = PathElement.groupElement("color");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$pLabelName = (AddressLayout) LAYOUT.select(PATH$pLabelName);
    public static final SequenceLayout LAYOUT$color = (SequenceLayout) LAYOUT.select(PATH$color);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$pLabelName = LAYOUT$pLabelName.byteSize();
    public static final long SIZE$color = LAYOUT$color.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$pLabelName = LAYOUT.byteOffset(PATH$pLabelName);
    public static final long OFFSET$color = LAYOUT.byteOffset(PATH$color);
}
