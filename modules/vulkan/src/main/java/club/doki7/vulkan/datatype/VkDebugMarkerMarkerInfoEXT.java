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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDebugMarkerMarkerInfoEXT.html"><code>VkDebugMarkerMarkerInfoEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDebugMarkerMarkerInfoEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     char const* pMarkerName; // @link substring="pMarkerName" target="#pMarkerName"
///     float[4] color; // @link substring="color" target="#color"
/// } VkDebugMarkerMarkerInfoEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_DEBUG_MARKER_MARKER_INFO_EXT`
///
/// The {@code allocate} ({@link VkDebugMarkerMarkerInfoEXT#allocate(Arena)}, {@link VkDebugMarkerMarkerInfoEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkDebugMarkerMarkerInfoEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDebugMarkerMarkerInfoEXT.html"><code>VkDebugMarkerMarkerInfoEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDebugMarkerMarkerInfoEXT(@NotNull MemorySegment segment) implements IVkDebugMarkerMarkerInfoEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDebugMarkerMarkerInfoEXT.html"><code>VkDebugMarkerMarkerInfoEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDebugMarkerMarkerInfoEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDebugMarkerMarkerInfoEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDebugMarkerMarkerInfoEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDebugMarkerMarkerInfoEXT, Iterable<VkDebugMarkerMarkerInfoEXT> {
        public long size() {
            return segment.byteSize() / VkDebugMarkerMarkerInfoEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDebugMarkerMarkerInfoEXT at(long index) {
            return new VkDebugMarkerMarkerInfoEXT(segment.asSlice(index * VkDebugMarkerMarkerInfoEXT.BYTES, VkDebugMarkerMarkerInfoEXT.BYTES));
        }

        public VkDebugMarkerMarkerInfoEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkDebugMarkerMarkerInfoEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDebugMarkerMarkerInfoEXT value) {
            MemorySegment s = segment.asSlice(index * VkDebugMarkerMarkerInfoEXT.BYTES, VkDebugMarkerMarkerInfoEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDebugMarkerMarkerInfoEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDebugMarkerMarkerInfoEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDebugMarkerMarkerInfoEXT.BYTES,
                (end - start) * VkDebugMarkerMarkerInfoEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDebugMarkerMarkerInfoEXT.BYTES));
        }

        public VkDebugMarkerMarkerInfoEXT[] toArray() {
            VkDebugMarkerMarkerInfoEXT[] ret = new VkDebugMarkerMarkerInfoEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDebugMarkerMarkerInfoEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDebugMarkerMarkerInfoEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDebugMarkerMarkerInfoEXT.BYTES;
            }

            @Override
            public VkDebugMarkerMarkerInfoEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDebugMarkerMarkerInfoEXT ret = new VkDebugMarkerMarkerInfoEXT(segment.asSlice(0, VkDebugMarkerMarkerInfoEXT.BYTES));
                segment = segment.asSlice(VkDebugMarkerMarkerInfoEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDebugMarkerMarkerInfoEXT allocate(Arena arena) {
        VkDebugMarkerMarkerInfoEXT ret = new VkDebugMarkerMarkerInfoEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.DEBUG_MARKER_MARKER_INFO_EXT);
        return ret;
    }

    public static VkDebugMarkerMarkerInfoEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkDebugMarkerMarkerInfoEXT.Ptr ret = new VkDebugMarkerMarkerInfoEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.DEBUG_MARKER_MARKER_INFO_EXT);
        }
        return ret;
    }

    public static VkDebugMarkerMarkerInfoEXT clone(Arena arena, VkDebugMarkerMarkerInfoEXT src) {
        VkDebugMarkerMarkerInfoEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.DEBUG_MARKER_MARKER_INFO_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkDebugMarkerMarkerInfoEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkDebugMarkerMarkerInfoEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkDebugMarkerMarkerInfoEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    /// Note: the returned {@link BytePtr} does not have correct
    /// {@link BytePtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link BytePtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable BytePtr pMarkerName() {
        MemorySegment s = pMarkerNameRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new BytePtr(s);
    }

    public VkDebugMarkerMarkerInfoEXT pMarkerName(@Nullable BytePtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pMarkerNameRaw(s);
        return this;
    }

    public @Pointer(comment="int8_t*") @NotNull MemorySegment pMarkerNameRaw() {
        return segment.get(LAYOUT$pMarkerName, OFFSET$pMarkerName);
    }

    public void pMarkerNameRaw(@Pointer(comment="int8_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pMarkerName, OFFSET$pMarkerName, value);
    }

    public FloatPtr color() {
        return new FloatPtr(colorRaw());
    }

    public VkDebugMarkerMarkerInfoEXT color(@NotNull Consumer<FloatPtr> consumer) {
        FloatPtr ptr = color();
        consumer.accept(ptr);
        return this;
    }

    public VkDebugMarkerMarkerInfoEXT color(FloatPtr value) {
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
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE).withName("pMarkerName"),
        MemoryLayout.sequenceLayout(4, ValueLayout.JAVA_FLOAT).withName("color")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$pMarkerName = PathElement.groupElement("pMarkerName");
    public static final PathElement PATH$color = PathElement.groupElement("color");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$pMarkerName = (AddressLayout) LAYOUT.select(PATH$pMarkerName);
    public static final SequenceLayout LAYOUT$color = (SequenceLayout) LAYOUT.select(PATH$color);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$pMarkerName = LAYOUT$pMarkerName.byteSize();
    public static final long SIZE$color = LAYOUT$color.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$pMarkerName = LAYOUT.byteOffset(PATH$pMarkerName);
    public static final long OFFSET$color = LAYOUT.byteOffset(PATH$color);
}
