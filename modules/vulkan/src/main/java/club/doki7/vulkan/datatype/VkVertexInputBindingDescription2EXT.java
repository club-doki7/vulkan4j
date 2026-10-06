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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVertexInputBindingDescription2EXT.html"><code>VkVertexInputBindingDescription2EXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkVertexInputBindingDescription2EXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t binding; // @link substring="binding" target="#binding"
///     uint32_t stride; // @link substring="stride" target="#stride"
///     VkVertexInputRate inputRate; // @link substring="VkVertexInputRate" target="VkVertexInputRate" @link substring="inputRate" target="#inputRate"
///     uint32_t divisor; // @link substring="divisor" target="#divisor"
/// } VkVertexInputBindingDescription2EXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_VERTEX_INPUT_BINDING_DESCRIPTION_2_EXT`
///
/// The {@code allocate} ({@link VkVertexInputBindingDescription2EXT#allocate(Arena)}, {@link VkVertexInputBindingDescription2EXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkVertexInputBindingDescription2EXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVertexInputBindingDescription2EXT.html"><code>VkVertexInputBindingDescription2EXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkVertexInputBindingDescription2EXT(@NotNull MemorySegment segment) implements IVkVertexInputBindingDescription2EXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVertexInputBindingDescription2EXT.html"><code>VkVertexInputBindingDescription2EXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkVertexInputBindingDescription2EXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkVertexInputBindingDescription2EXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkVertexInputBindingDescription2EXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkVertexInputBindingDescription2EXT, Iterable<VkVertexInputBindingDescription2EXT> {
        public long size() {
            return segment.byteSize() / VkVertexInputBindingDescription2EXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkVertexInputBindingDescription2EXT at(long index) {
            return new VkVertexInputBindingDescription2EXT(segment.asSlice(index * VkVertexInputBindingDescription2EXT.BYTES, VkVertexInputBindingDescription2EXT.BYTES));
        }

        public VkVertexInputBindingDescription2EXT.Ptr at(long index, @NotNull Consumer<@NotNull VkVertexInputBindingDescription2EXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkVertexInputBindingDescription2EXT value) {
            MemorySegment s = segment.asSlice(index * VkVertexInputBindingDescription2EXT.BYTES, VkVertexInputBindingDescription2EXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkVertexInputBindingDescription2EXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkVertexInputBindingDescription2EXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkVertexInputBindingDescription2EXT.BYTES,
                (end - start) * VkVertexInputBindingDescription2EXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkVertexInputBindingDescription2EXT.BYTES));
        }

        public VkVertexInputBindingDescription2EXT[] toArray() {
            VkVertexInputBindingDescription2EXT[] ret = new VkVertexInputBindingDescription2EXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkVertexInputBindingDescription2EXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkVertexInputBindingDescription2EXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkVertexInputBindingDescription2EXT.BYTES;
            }

            @Override
            public VkVertexInputBindingDescription2EXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkVertexInputBindingDescription2EXT ret = new VkVertexInputBindingDescription2EXT(segment.asSlice(0, VkVertexInputBindingDescription2EXT.BYTES));
                segment = segment.asSlice(VkVertexInputBindingDescription2EXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkVertexInputBindingDescription2EXT allocate(Arena arena) {
        VkVertexInputBindingDescription2EXT ret = new VkVertexInputBindingDescription2EXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.VERTEX_INPUT_BINDING_DESCRIPTION_2_EXT);
        return ret;
    }

    public static VkVertexInputBindingDescription2EXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkVertexInputBindingDescription2EXT.Ptr ret = new VkVertexInputBindingDescription2EXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.VERTEX_INPUT_BINDING_DESCRIPTION_2_EXT);
        }
        return ret;
    }

    public static VkVertexInputBindingDescription2EXT clone(Arena arena, VkVertexInputBindingDescription2EXT src) {
        VkVertexInputBindingDescription2EXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.VERTEX_INPUT_BINDING_DESCRIPTION_2_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkVertexInputBindingDescription2EXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkVertexInputBindingDescription2EXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkVertexInputBindingDescription2EXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int binding() {
        return segment.get(LAYOUT$binding, OFFSET$binding);
    }

    public VkVertexInputBindingDescription2EXT binding(@Unsigned int value) {
        segment.set(LAYOUT$binding, OFFSET$binding, value);
        return this;
    }

    public @Unsigned int stride() {
        return segment.get(LAYOUT$stride, OFFSET$stride);
    }

    public VkVertexInputBindingDescription2EXT stride(@Unsigned int value) {
        segment.set(LAYOUT$stride, OFFSET$stride, value);
        return this;
    }

    public @EnumType(VkVertexInputRate.class) int inputRate() {
        return segment.get(LAYOUT$inputRate, OFFSET$inputRate);
    }

    public VkVertexInputBindingDescription2EXT inputRate(@EnumType(VkVertexInputRate.class) int value) {
        segment.set(LAYOUT$inputRate, OFFSET$inputRate, value);
        return this;
    }

    public @Unsigned int divisor() {
        return segment.get(LAYOUT$divisor, OFFSET$divisor);
    }

    public VkVertexInputBindingDescription2EXT divisor(@Unsigned int value) {
        segment.set(LAYOUT$divisor, OFFSET$divisor, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("binding"),
        ValueLayout.JAVA_INT.withName("stride"),
        ValueLayout.JAVA_INT.withName("inputRate"),
        ValueLayout.JAVA_INT.withName("divisor")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$binding = PathElement.groupElement("binding");
    public static final PathElement PATH$stride = PathElement.groupElement("stride");
    public static final PathElement PATH$inputRate = PathElement.groupElement("inputRate");
    public static final PathElement PATH$divisor = PathElement.groupElement("divisor");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$binding = (OfInt) LAYOUT.select(PATH$binding);
    public static final OfInt LAYOUT$stride = (OfInt) LAYOUT.select(PATH$stride);
    public static final OfInt LAYOUT$inputRate = (OfInt) LAYOUT.select(PATH$inputRate);
    public static final OfInt LAYOUT$divisor = (OfInt) LAYOUT.select(PATH$divisor);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$binding = LAYOUT$binding.byteSize();
    public static final long SIZE$stride = LAYOUT$stride.byteSize();
    public static final long SIZE$inputRate = LAYOUT$inputRate.byteSize();
    public static final long SIZE$divisor = LAYOUT$divisor.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$binding = LAYOUT.byteOffset(PATH$binding);
    public static final long OFFSET$stride = LAYOUT.byteOffset(PATH$stride);
    public static final long OFFSET$inputRate = LAYOUT.byteOffset(PATH$inputRate);
    public static final long OFFSET$divisor = LAYOUT.byteOffset(PATH$divisor);
}
