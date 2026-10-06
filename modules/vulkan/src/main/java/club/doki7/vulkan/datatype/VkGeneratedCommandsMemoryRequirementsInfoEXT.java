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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGeneratedCommandsMemoryRequirementsInfoEXT.html"><code>VkGeneratedCommandsMemoryRequirementsInfoEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkGeneratedCommandsMemoryRequirementsInfoEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkIndirectExecutionSetEXT indirectExecutionSet; // optional // @link substring="VkIndirectExecutionSetEXT" target="VkIndirectExecutionSetEXT" @link substring="indirectExecutionSet" target="#indirectExecutionSet"
///     VkIndirectCommandsLayoutEXT indirectCommandsLayout; // @link substring="VkIndirectCommandsLayoutEXT" target="VkIndirectCommandsLayoutEXT" @link substring="indirectCommandsLayout" target="#indirectCommandsLayout"
///     uint32_t maxSequenceCount; // @link substring="maxSequenceCount" target="#maxSequenceCount"
///     uint32_t maxDrawCount; // @link substring="maxDrawCount" target="#maxDrawCount"
/// } VkGeneratedCommandsMemoryRequirementsInfoEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_GENERATED_COMMANDS_MEMORY_REQUIREMENTS_INFO_EXT`
///
/// The {@code allocate} ({@link VkGeneratedCommandsMemoryRequirementsInfoEXT#allocate(Arena)}, {@link VkGeneratedCommandsMemoryRequirementsInfoEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkGeneratedCommandsMemoryRequirementsInfoEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGeneratedCommandsMemoryRequirementsInfoEXT.html"><code>VkGeneratedCommandsMemoryRequirementsInfoEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkGeneratedCommandsMemoryRequirementsInfoEXT(@NotNull MemorySegment segment) implements IVkGeneratedCommandsMemoryRequirementsInfoEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGeneratedCommandsMemoryRequirementsInfoEXT.html"><code>VkGeneratedCommandsMemoryRequirementsInfoEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkGeneratedCommandsMemoryRequirementsInfoEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkGeneratedCommandsMemoryRequirementsInfoEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkGeneratedCommandsMemoryRequirementsInfoEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkGeneratedCommandsMemoryRequirementsInfoEXT, Iterable<VkGeneratedCommandsMemoryRequirementsInfoEXT> {
        public long size() {
            return segment.byteSize() / VkGeneratedCommandsMemoryRequirementsInfoEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkGeneratedCommandsMemoryRequirementsInfoEXT at(long index) {
            return new VkGeneratedCommandsMemoryRequirementsInfoEXT(segment.asSlice(index * VkGeneratedCommandsMemoryRequirementsInfoEXT.BYTES, VkGeneratedCommandsMemoryRequirementsInfoEXT.BYTES));
        }

        public VkGeneratedCommandsMemoryRequirementsInfoEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkGeneratedCommandsMemoryRequirementsInfoEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkGeneratedCommandsMemoryRequirementsInfoEXT value) {
            MemorySegment s = segment.asSlice(index * VkGeneratedCommandsMemoryRequirementsInfoEXT.BYTES, VkGeneratedCommandsMemoryRequirementsInfoEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkGeneratedCommandsMemoryRequirementsInfoEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkGeneratedCommandsMemoryRequirementsInfoEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkGeneratedCommandsMemoryRequirementsInfoEXT.BYTES,
                (end - start) * VkGeneratedCommandsMemoryRequirementsInfoEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkGeneratedCommandsMemoryRequirementsInfoEXT.BYTES));
        }

        public VkGeneratedCommandsMemoryRequirementsInfoEXT[] toArray() {
            VkGeneratedCommandsMemoryRequirementsInfoEXT[] ret = new VkGeneratedCommandsMemoryRequirementsInfoEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkGeneratedCommandsMemoryRequirementsInfoEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkGeneratedCommandsMemoryRequirementsInfoEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkGeneratedCommandsMemoryRequirementsInfoEXT.BYTES;
            }

            @Override
            public VkGeneratedCommandsMemoryRequirementsInfoEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkGeneratedCommandsMemoryRequirementsInfoEXT ret = new VkGeneratedCommandsMemoryRequirementsInfoEXT(segment.asSlice(0, VkGeneratedCommandsMemoryRequirementsInfoEXT.BYTES));
                segment = segment.asSlice(VkGeneratedCommandsMemoryRequirementsInfoEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkGeneratedCommandsMemoryRequirementsInfoEXT allocate(Arena arena) {
        VkGeneratedCommandsMemoryRequirementsInfoEXT ret = new VkGeneratedCommandsMemoryRequirementsInfoEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.GENERATED_COMMANDS_MEMORY_REQUIREMENTS_INFO_EXT);
        return ret;
    }

    public static VkGeneratedCommandsMemoryRequirementsInfoEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkGeneratedCommandsMemoryRequirementsInfoEXT.Ptr ret = new VkGeneratedCommandsMemoryRequirementsInfoEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.GENERATED_COMMANDS_MEMORY_REQUIREMENTS_INFO_EXT);
        }
        return ret;
    }

    public static VkGeneratedCommandsMemoryRequirementsInfoEXT clone(Arena arena, VkGeneratedCommandsMemoryRequirementsInfoEXT src) {
        VkGeneratedCommandsMemoryRequirementsInfoEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.GENERATED_COMMANDS_MEMORY_REQUIREMENTS_INFO_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkGeneratedCommandsMemoryRequirementsInfoEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkGeneratedCommandsMemoryRequirementsInfoEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkGeneratedCommandsMemoryRequirementsInfoEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Nullable VkIndirectExecutionSetEXT indirectExecutionSet() {
        MemorySegment s = segment.asSlice(OFFSET$indirectExecutionSet, SIZE$indirectExecutionSet);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkIndirectExecutionSetEXT(s);
    }

    public VkGeneratedCommandsMemoryRequirementsInfoEXT indirectExecutionSet(@Nullable VkIndirectExecutionSetEXT value) {
        segment.set(LAYOUT$indirectExecutionSet, OFFSET$indirectExecutionSet, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Nullable VkIndirectCommandsLayoutEXT indirectCommandsLayout() {
        MemorySegment s = segment.asSlice(OFFSET$indirectCommandsLayout, SIZE$indirectCommandsLayout);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkIndirectCommandsLayoutEXT(s);
    }

    public VkGeneratedCommandsMemoryRequirementsInfoEXT indirectCommandsLayout(@Nullable VkIndirectCommandsLayoutEXT value) {
        segment.set(LAYOUT$indirectCommandsLayout, OFFSET$indirectCommandsLayout, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int maxSequenceCount() {
        return segment.get(LAYOUT$maxSequenceCount, OFFSET$maxSequenceCount);
    }

    public VkGeneratedCommandsMemoryRequirementsInfoEXT maxSequenceCount(@Unsigned int value) {
        segment.set(LAYOUT$maxSequenceCount, OFFSET$maxSequenceCount, value);
        return this;
    }

    public @Unsigned int maxDrawCount() {
        return segment.get(LAYOUT$maxDrawCount, OFFSET$maxDrawCount);
    }

    public VkGeneratedCommandsMemoryRequirementsInfoEXT maxDrawCount(@Unsigned int value) {
        segment.set(LAYOUT$maxDrawCount, OFFSET$maxDrawCount, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withName("indirectExecutionSet"),
        ValueLayout.ADDRESS.withName("indirectCommandsLayout"),
        ValueLayout.JAVA_INT.withName("maxSequenceCount"),
        ValueLayout.JAVA_INT.withName("maxDrawCount")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$indirectExecutionSet = PathElement.groupElement("indirectExecutionSet");
    public static final PathElement PATH$indirectCommandsLayout = PathElement.groupElement("indirectCommandsLayout");
    public static final PathElement PATH$maxSequenceCount = PathElement.groupElement("maxSequenceCount");
    public static final PathElement PATH$maxDrawCount = PathElement.groupElement("maxDrawCount");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$indirectExecutionSet = (AddressLayout) LAYOUT.select(PATH$indirectExecutionSet);
    public static final AddressLayout LAYOUT$indirectCommandsLayout = (AddressLayout) LAYOUT.select(PATH$indirectCommandsLayout);
    public static final OfInt LAYOUT$maxSequenceCount = (OfInt) LAYOUT.select(PATH$maxSequenceCount);
    public static final OfInt LAYOUT$maxDrawCount = (OfInt) LAYOUT.select(PATH$maxDrawCount);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$indirectExecutionSet = LAYOUT$indirectExecutionSet.byteSize();
    public static final long SIZE$indirectCommandsLayout = LAYOUT$indirectCommandsLayout.byteSize();
    public static final long SIZE$maxSequenceCount = LAYOUT$maxSequenceCount.byteSize();
    public static final long SIZE$maxDrawCount = LAYOUT$maxDrawCount.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$indirectExecutionSet = LAYOUT.byteOffset(PATH$indirectExecutionSet);
    public static final long OFFSET$indirectCommandsLayout = LAYOUT.byteOffset(PATH$indirectCommandsLayout);
    public static final long OFFSET$maxSequenceCount = LAYOUT.byteOffset(PATH$maxSequenceCount);
    public static final long OFFSET$maxDrawCount = LAYOUT.byteOffset(PATH$maxDrawCount);
}
