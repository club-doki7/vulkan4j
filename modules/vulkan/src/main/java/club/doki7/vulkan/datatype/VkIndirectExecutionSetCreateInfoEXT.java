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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkIndirectExecutionSetCreateInfoEXT.html"><code>VkIndirectExecutionSetCreateInfoEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkIndirectExecutionSetCreateInfoEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkIndirectExecutionSetInfoTypeEXT type; // @link substring="VkIndirectExecutionSetInfoTypeEXT" target="VkIndirectExecutionSetInfoTypeEXT" @link substring="type" target="#type"
///     VkIndirectExecutionSetInfoEXT info; // @link substring="VkIndirectExecutionSetInfoEXT" target="VkIndirectExecutionSetInfoEXT" @link substring="info" target="#info"
/// } VkIndirectExecutionSetCreateInfoEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_INDIRECT_EXECUTION_SET_CREATE_INFO_EXT`
///
/// The {@code allocate} ({@link VkIndirectExecutionSetCreateInfoEXT#allocate(Arena)}, {@link VkIndirectExecutionSetCreateInfoEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkIndirectExecutionSetCreateInfoEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkIndirectExecutionSetCreateInfoEXT.html"><code>VkIndirectExecutionSetCreateInfoEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkIndirectExecutionSetCreateInfoEXT(@NotNull MemorySegment segment) implements IVkIndirectExecutionSetCreateInfoEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkIndirectExecutionSetCreateInfoEXT.html"><code>VkIndirectExecutionSetCreateInfoEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkIndirectExecutionSetCreateInfoEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkIndirectExecutionSetCreateInfoEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkIndirectExecutionSetCreateInfoEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkIndirectExecutionSetCreateInfoEXT, Iterable<VkIndirectExecutionSetCreateInfoEXT> {
        public long size() {
            return segment.byteSize() / VkIndirectExecutionSetCreateInfoEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkIndirectExecutionSetCreateInfoEXT at(long index) {
            return new VkIndirectExecutionSetCreateInfoEXT(segment.asSlice(index * VkIndirectExecutionSetCreateInfoEXT.BYTES, VkIndirectExecutionSetCreateInfoEXT.BYTES));
        }

        public VkIndirectExecutionSetCreateInfoEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkIndirectExecutionSetCreateInfoEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkIndirectExecutionSetCreateInfoEXT value) {
            MemorySegment s = segment.asSlice(index * VkIndirectExecutionSetCreateInfoEXT.BYTES, VkIndirectExecutionSetCreateInfoEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkIndirectExecutionSetCreateInfoEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkIndirectExecutionSetCreateInfoEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkIndirectExecutionSetCreateInfoEXT.BYTES,
                (end - start) * VkIndirectExecutionSetCreateInfoEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkIndirectExecutionSetCreateInfoEXT.BYTES));
        }

        public VkIndirectExecutionSetCreateInfoEXT[] toArray() {
            VkIndirectExecutionSetCreateInfoEXT[] ret = new VkIndirectExecutionSetCreateInfoEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkIndirectExecutionSetCreateInfoEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkIndirectExecutionSetCreateInfoEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkIndirectExecutionSetCreateInfoEXT.BYTES;
            }

            @Override
            public VkIndirectExecutionSetCreateInfoEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkIndirectExecutionSetCreateInfoEXT ret = new VkIndirectExecutionSetCreateInfoEXT(segment.asSlice(0, VkIndirectExecutionSetCreateInfoEXT.BYTES));
                segment = segment.asSlice(VkIndirectExecutionSetCreateInfoEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkIndirectExecutionSetCreateInfoEXT allocate(Arena arena) {
        VkIndirectExecutionSetCreateInfoEXT ret = new VkIndirectExecutionSetCreateInfoEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.INDIRECT_EXECUTION_SET_CREATE_INFO_EXT);
        return ret;
    }

    public static VkIndirectExecutionSetCreateInfoEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkIndirectExecutionSetCreateInfoEXT.Ptr ret = new VkIndirectExecutionSetCreateInfoEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.INDIRECT_EXECUTION_SET_CREATE_INFO_EXT);
        }
        return ret;
    }

    public static VkIndirectExecutionSetCreateInfoEXT clone(Arena arena, VkIndirectExecutionSetCreateInfoEXT src) {
        VkIndirectExecutionSetCreateInfoEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.INDIRECT_EXECUTION_SET_CREATE_INFO_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkIndirectExecutionSetCreateInfoEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkIndirectExecutionSetCreateInfoEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkIndirectExecutionSetCreateInfoEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @EnumType(VkIndirectExecutionSetInfoTypeEXT.class) int type() {
        return segment.get(LAYOUT$type, OFFSET$type);
    }

    public VkIndirectExecutionSetCreateInfoEXT type(@EnumType(VkIndirectExecutionSetInfoTypeEXT.class) int value) {
        segment.set(LAYOUT$type, OFFSET$type, value);
        return this;
    }

    public @NotNull VkIndirectExecutionSetInfoEXT info() {
        return new VkIndirectExecutionSetInfoEXT(segment.asSlice(OFFSET$info, LAYOUT$info));
    }

    public VkIndirectExecutionSetCreateInfoEXT info(@NotNull VkIndirectExecutionSetInfoEXT value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$info, SIZE$info);
        return this;
    }

    public VkIndirectExecutionSetCreateInfoEXT info(Consumer<@NotNull VkIndirectExecutionSetInfoEXT> consumer) {
        consumer.accept(info());
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("type"),
        VkIndirectExecutionSetInfoEXT.LAYOUT.withName("info")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$type = PathElement.groupElement("type");
    public static final PathElement PATH$info = PathElement.groupElement("info");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$type = (OfInt) LAYOUT.select(PATH$type);
    public static final UnionLayout LAYOUT$info = (UnionLayout) LAYOUT.select(PATH$info);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$type = LAYOUT$type.byteSize();
    public static final long SIZE$info = LAYOUT$info.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$type = LAYOUT.byteOffset(PATH$type);
    public static final long OFFSET$info = LAYOUT.byteOffset(PATH$info);
}
