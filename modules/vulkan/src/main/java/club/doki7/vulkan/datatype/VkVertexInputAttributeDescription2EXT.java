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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVertexInputAttributeDescription2EXT.html"><code>VkVertexInputAttributeDescription2EXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkVertexInputAttributeDescription2EXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t location; // @link substring="location" target="#location"
///     uint32_t binding; // @link substring="binding" target="#binding"
///     VkFormat format; // @link substring="VkFormat" target="VkFormat" @link substring="format" target="#format"
///     uint32_t offset; // @link substring="offset" target="#offset"
/// } VkVertexInputAttributeDescription2EXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_VERTEX_INPUT_ATTRIBUTE_DESCRIPTION_2_EXT`
///
/// The {@code allocate} ({@link VkVertexInputAttributeDescription2EXT#allocate(Arena)}, {@link VkVertexInputAttributeDescription2EXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkVertexInputAttributeDescription2EXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVertexInputAttributeDescription2EXT.html"><code>VkVertexInputAttributeDescription2EXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkVertexInputAttributeDescription2EXT(@NotNull MemorySegment segment) implements IVkVertexInputAttributeDescription2EXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVertexInputAttributeDescription2EXT.html"><code>VkVertexInputAttributeDescription2EXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkVertexInputAttributeDescription2EXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkVertexInputAttributeDescription2EXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkVertexInputAttributeDescription2EXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkVertexInputAttributeDescription2EXT, Iterable<VkVertexInputAttributeDescription2EXT> {
        public long size() {
            return segment.byteSize() / VkVertexInputAttributeDescription2EXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkVertexInputAttributeDescription2EXT at(long index) {
            return new VkVertexInputAttributeDescription2EXT(segment.asSlice(index * VkVertexInputAttributeDescription2EXT.BYTES, VkVertexInputAttributeDescription2EXT.BYTES));
        }

        public VkVertexInputAttributeDescription2EXT.Ptr at(long index, @NotNull Consumer<@NotNull VkVertexInputAttributeDescription2EXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkVertexInputAttributeDescription2EXT value) {
            MemorySegment s = segment.asSlice(index * VkVertexInputAttributeDescription2EXT.BYTES, VkVertexInputAttributeDescription2EXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkVertexInputAttributeDescription2EXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkVertexInputAttributeDescription2EXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkVertexInputAttributeDescription2EXT.BYTES,
                (end - start) * VkVertexInputAttributeDescription2EXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkVertexInputAttributeDescription2EXT.BYTES));
        }

        public VkVertexInputAttributeDescription2EXT[] toArray() {
            VkVertexInputAttributeDescription2EXT[] ret = new VkVertexInputAttributeDescription2EXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkVertexInputAttributeDescription2EXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkVertexInputAttributeDescription2EXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkVertexInputAttributeDescription2EXT.BYTES;
            }

            @Override
            public VkVertexInputAttributeDescription2EXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkVertexInputAttributeDescription2EXT ret = new VkVertexInputAttributeDescription2EXT(segment.asSlice(0, VkVertexInputAttributeDescription2EXT.BYTES));
                segment = segment.asSlice(VkVertexInputAttributeDescription2EXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkVertexInputAttributeDescription2EXT allocate(Arena arena) {
        VkVertexInputAttributeDescription2EXT ret = new VkVertexInputAttributeDescription2EXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.VERTEX_INPUT_ATTRIBUTE_DESCRIPTION_2_EXT);
        return ret;
    }

    public static VkVertexInputAttributeDescription2EXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkVertexInputAttributeDescription2EXT.Ptr ret = new VkVertexInputAttributeDescription2EXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.VERTEX_INPUT_ATTRIBUTE_DESCRIPTION_2_EXT);
        }
        return ret;
    }

    public static VkVertexInputAttributeDescription2EXT clone(Arena arena, VkVertexInputAttributeDescription2EXT src) {
        VkVertexInputAttributeDescription2EXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.VERTEX_INPUT_ATTRIBUTE_DESCRIPTION_2_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkVertexInputAttributeDescription2EXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkVertexInputAttributeDescription2EXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkVertexInputAttributeDescription2EXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int location() {
        return segment.get(LAYOUT$location, OFFSET$location);
    }

    public VkVertexInputAttributeDescription2EXT location(@Unsigned int value) {
        segment.set(LAYOUT$location, OFFSET$location, value);
        return this;
    }

    public @Unsigned int binding() {
        return segment.get(LAYOUT$binding, OFFSET$binding);
    }

    public VkVertexInputAttributeDescription2EXT binding(@Unsigned int value) {
        segment.set(LAYOUT$binding, OFFSET$binding, value);
        return this;
    }

    public @EnumType(VkFormat.class) int format() {
        return segment.get(LAYOUT$format, OFFSET$format);
    }

    public VkVertexInputAttributeDescription2EXT format(@EnumType(VkFormat.class) int value) {
        segment.set(LAYOUT$format, OFFSET$format, value);
        return this;
    }

    public @Unsigned int offset() {
        return segment.get(LAYOUT$offset, OFFSET$offset);
    }

    public VkVertexInputAttributeDescription2EXT offset(@Unsigned int value) {
        segment.set(LAYOUT$offset, OFFSET$offset, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("location"),
        ValueLayout.JAVA_INT.withName("binding"),
        ValueLayout.JAVA_INT.withName("format"),
        ValueLayout.JAVA_INT.withName("offset")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$location = PathElement.groupElement("location");
    public static final PathElement PATH$binding = PathElement.groupElement("binding");
    public static final PathElement PATH$format = PathElement.groupElement("format");
    public static final PathElement PATH$offset = PathElement.groupElement("offset");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$location = (OfInt) LAYOUT.select(PATH$location);
    public static final OfInt LAYOUT$binding = (OfInt) LAYOUT.select(PATH$binding);
    public static final OfInt LAYOUT$format = (OfInt) LAYOUT.select(PATH$format);
    public static final OfInt LAYOUT$offset = (OfInt) LAYOUT.select(PATH$offset);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$location = LAYOUT$location.byteSize();
    public static final long SIZE$binding = LAYOUT$binding.byteSize();
    public static final long SIZE$format = LAYOUT$format.byteSize();
    public static final long SIZE$offset = LAYOUT$offset.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$location = LAYOUT.byteOffset(PATH$location);
    public static final long OFFSET$binding = LAYOUT.byteOffset(PATH$binding);
    public static final long OFFSET$format = LAYOUT.byteOffset(PATH$format);
    public static final long OFFSET$offset = LAYOUT.byteOffset(PATH$offset);
}
