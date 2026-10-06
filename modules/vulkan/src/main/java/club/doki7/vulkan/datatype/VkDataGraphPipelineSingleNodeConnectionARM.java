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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDataGraphPipelineSingleNodeConnectionARM.html"><code>VkDataGraphPipelineSingleNodeConnectionARM</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDataGraphPipelineSingleNodeConnectionARM {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t set; // @link substring="set" target="#set"
///     uint32_t binding; // @link substring="binding" target="#binding"
///     VkDataGraphPipelineNodeConnectionTypeARM connection; // @link substring="VkDataGraphPipelineNodeConnectionTypeARM" target="VkDataGraphPipelineNodeConnectionTypeARM" @link substring="connection" target="#connection"
/// } VkDataGraphPipelineSingleNodeConnectionARM;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_DATA_GRAPH_PIPELINE_SINGLE_NODE_CONNECTION_ARM`
///
/// The {@code allocate} ({@link VkDataGraphPipelineSingleNodeConnectionARM#allocate(Arena)}, {@link VkDataGraphPipelineSingleNodeConnectionARM#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkDataGraphPipelineSingleNodeConnectionARM#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDataGraphPipelineSingleNodeConnectionARM.html"><code>VkDataGraphPipelineSingleNodeConnectionARM</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDataGraphPipelineSingleNodeConnectionARM(@NotNull MemorySegment segment) implements IVkDataGraphPipelineSingleNodeConnectionARM {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDataGraphPipelineSingleNodeConnectionARM.html"><code>VkDataGraphPipelineSingleNodeConnectionARM</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDataGraphPipelineSingleNodeConnectionARM}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDataGraphPipelineSingleNodeConnectionARM to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDataGraphPipelineSingleNodeConnectionARM.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDataGraphPipelineSingleNodeConnectionARM, Iterable<VkDataGraphPipelineSingleNodeConnectionARM> {
        public long size() {
            return segment.byteSize() / VkDataGraphPipelineSingleNodeConnectionARM.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDataGraphPipelineSingleNodeConnectionARM at(long index) {
            return new VkDataGraphPipelineSingleNodeConnectionARM(segment.asSlice(index * VkDataGraphPipelineSingleNodeConnectionARM.BYTES, VkDataGraphPipelineSingleNodeConnectionARM.BYTES));
        }

        public VkDataGraphPipelineSingleNodeConnectionARM.Ptr at(long index, @NotNull Consumer<@NotNull VkDataGraphPipelineSingleNodeConnectionARM> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDataGraphPipelineSingleNodeConnectionARM value) {
            MemorySegment s = segment.asSlice(index * VkDataGraphPipelineSingleNodeConnectionARM.BYTES, VkDataGraphPipelineSingleNodeConnectionARM.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDataGraphPipelineSingleNodeConnectionARM.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDataGraphPipelineSingleNodeConnectionARM.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDataGraphPipelineSingleNodeConnectionARM.BYTES,
                (end - start) * VkDataGraphPipelineSingleNodeConnectionARM.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDataGraphPipelineSingleNodeConnectionARM.BYTES));
        }

        public VkDataGraphPipelineSingleNodeConnectionARM[] toArray() {
            VkDataGraphPipelineSingleNodeConnectionARM[] ret = new VkDataGraphPipelineSingleNodeConnectionARM[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDataGraphPipelineSingleNodeConnectionARM> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDataGraphPipelineSingleNodeConnectionARM> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDataGraphPipelineSingleNodeConnectionARM.BYTES;
            }

            @Override
            public VkDataGraphPipelineSingleNodeConnectionARM next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDataGraphPipelineSingleNodeConnectionARM ret = new VkDataGraphPipelineSingleNodeConnectionARM(segment.asSlice(0, VkDataGraphPipelineSingleNodeConnectionARM.BYTES));
                segment = segment.asSlice(VkDataGraphPipelineSingleNodeConnectionARM.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDataGraphPipelineSingleNodeConnectionARM allocate(Arena arena) {
        VkDataGraphPipelineSingleNodeConnectionARM ret = new VkDataGraphPipelineSingleNodeConnectionARM(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.DATA_GRAPH_PIPELINE_SINGLE_NODE_CONNECTION_ARM);
        return ret;
    }

    public static VkDataGraphPipelineSingleNodeConnectionARM.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkDataGraphPipelineSingleNodeConnectionARM.Ptr ret = new VkDataGraphPipelineSingleNodeConnectionARM.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.DATA_GRAPH_PIPELINE_SINGLE_NODE_CONNECTION_ARM);
        }
        return ret;
    }

    public static VkDataGraphPipelineSingleNodeConnectionARM clone(Arena arena, VkDataGraphPipelineSingleNodeConnectionARM src) {
        VkDataGraphPipelineSingleNodeConnectionARM ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.DATA_GRAPH_PIPELINE_SINGLE_NODE_CONNECTION_ARM);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkDataGraphPipelineSingleNodeConnectionARM sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkDataGraphPipelineSingleNodeConnectionARM pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkDataGraphPipelineSingleNodeConnectionARM pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int set() {
        return segment.get(LAYOUT$set, OFFSET$set);
    }

    public VkDataGraphPipelineSingleNodeConnectionARM set(@Unsigned int value) {
        segment.set(LAYOUT$set, OFFSET$set, value);
        return this;
    }

    public @Unsigned int binding() {
        return segment.get(LAYOUT$binding, OFFSET$binding);
    }

    public VkDataGraphPipelineSingleNodeConnectionARM binding(@Unsigned int value) {
        segment.set(LAYOUT$binding, OFFSET$binding, value);
        return this;
    }

    public @EnumType(VkDataGraphPipelineNodeConnectionTypeARM.class) int connection() {
        return segment.get(LAYOUT$connection, OFFSET$connection);
    }

    public VkDataGraphPipelineSingleNodeConnectionARM connection(@EnumType(VkDataGraphPipelineNodeConnectionTypeARM.class) int value) {
        segment.set(LAYOUT$connection, OFFSET$connection, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("set"),
        ValueLayout.JAVA_INT.withName("binding"),
        ValueLayout.JAVA_INT.withName("connection")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$set = PathElement.groupElement("set");
    public static final PathElement PATH$binding = PathElement.groupElement("binding");
    public static final PathElement PATH$connection = PathElement.groupElement("connection");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$set = (OfInt) LAYOUT.select(PATH$set);
    public static final OfInt LAYOUT$binding = (OfInt) LAYOUT.select(PATH$binding);
    public static final OfInt LAYOUT$connection = (OfInt) LAYOUT.select(PATH$connection);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$set = LAYOUT$set.byteSize();
    public static final long SIZE$binding = LAYOUT$binding.byteSize();
    public static final long SIZE$connection = LAYOUT$connection.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$set = LAYOUT.byteOffset(PATH$set);
    public static final long OFFSET$binding = LAYOUT.byteOffset(PATH$binding);
    public static final long OFFSET$connection = LAYOUT.byteOffset(PATH$connection);
}
