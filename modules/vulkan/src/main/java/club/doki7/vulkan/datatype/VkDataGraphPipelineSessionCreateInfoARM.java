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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDataGraphPipelineSessionCreateInfoARM.html"><code>VkDataGraphPipelineSessionCreateInfoARM</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDataGraphPipelineSessionCreateInfoARM {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkDataGraphPipelineSessionCreateFlagsARM flags; // optional // @link substring="VkDataGraphPipelineSessionCreateFlagsARM" target="VkDataGraphPipelineSessionCreateFlagsARM" @link substring="flags" target="#flags"
///     VkPipeline dataGraphPipeline; // @link substring="VkPipeline" target="VkPipeline" @link substring="dataGraphPipeline" target="#dataGraphPipeline"
/// } VkDataGraphPipelineSessionCreateInfoARM;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_DATA_GRAPH_PIPELINE_SESSION_CREATE_INFO_ARM`
///
/// The {@code allocate} ({@link VkDataGraphPipelineSessionCreateInfoARM#allocate(Arena)}, {@link VkDataGraphPipelineSessionCreateInfoARM#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkDataGraphPipelineSessionCreateInfoARM#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDataGraphPipelineSessionCreateInfoARM.html"><code>VkDataGraphPipelineSessionCreateInfoARM</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDataGraphPipelineSessionCreateInfoARM(@NotNull MemorySegment segment) implements IVkDataGraphPipelineSessionCreateInfoARM {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDataGraphPipelineSessionCreateInfoARM.html"><code>VkDataGraphPipelineSessionCreateInfoARM</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDataGraphPipelineSessionCreateInfoARM}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDataGraphPipelineSessionCreateInfoARM to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDataGraphPipelineSessionCreateInfoARM.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDataGraphPipelineSessionCreateInfoARM, Iterable<VkDataGraphPipelineSessionCreateInfoARM> {
        public long size() {
            return segment.byteSize() / VkDataGraphPipelineSessionCreateInfoARM.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDataGraphPipelineSessionCreateInfoARM at(long index) {
            return new VkDataGraphPipelineSessionCreateInfoARM(segment.asSlice(index * VkDataGraphPipelineSessionCreateInfoARM.BYTES, VkDataGraphPipelineSessionCreateInfoARM.BYTES));
        }

        public VkDataGraphPipelineSessionCreateInfoARM.Ptr at(long index, @NotNull Consumer<@NotNull VkDataGraphPipelineSessionCreateInfoARM> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDataGraphPipelineSessionCreateInfoARM value) {
            MemorySegment s = segment.asSlice(index * VkDataGraphPipelineSessionCreateInfoARM.BYTES, VkDataGraphPipelineSessionCreateInfoARM.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDataGraphPipelineSessionCreateInfoARM.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDataGraphPipelineSessionCreateInfoARM.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDataGraphPipelineSessionCreateInfoARM.BYTES,
                (end - start) * VkDataGraphPipelineSessionCreateInfoARM.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDataGraphPipelineSessionCreateInfoARM.BYTES));
        }

        public VkDataGraphPipelineSessionCreateInfoARM[] toArray() {
            VkDataGraphPipelineSessionCreateInfoARM[] ret = new VkDataGraphPipelineSessionCreateInfoARM[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDataGraphPipelineSessionCreateInfoARM> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDataGraphPipelineSessionCreateInfoARM> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDataGraphPipelineSessionCreateInfoARM.BYTES;
            }

            @Override
            public VkDataGraphPipelineSessionCreateInfoARM next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDataGraphPipelineSessionCreateInfoARM ret = new VkDataGraphPipelineSessionCreateInfoARM(segment.asSlice(0, VkDataGraphPipelineSessionCreateInfoARM.BYTES));
                segment = segment.asSlice(VkDataGraphPipelineSessionCreateInfoARM.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDataGraphPipelineSessionCreateInfoARM allocate(Arena arena) {
        VkDataGraphPipelineSessionCreateInfoARM ret = new VkDataGraphPipelineSessionCreateInfoARM(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.DATA_GRAPH_PIPELINE_SESSION_CREATE_INFO_ARM);
        return ret;
    }

    public static VkDataGraphPipelineSessionCreateInfoARM.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkDataGraphPipelineSessionCreateInfoARM.Ptr ret = new VkDataGraphPipelineSessionCreateInfoARM.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.DATA_GRAPH_PIPELINE_SESSION_CREATE_INFO_ARM);
        }
        return ret;
    }

    public static VkDataGraphPipelineSessionCreateInfoARM clone(Arena arena, VkDataGraphPipelineSessionCreateInfoARM src) {
        VkDataGraphPipelineSessionCreateInfoARM ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.DATA_GRAPH_PIPELINE_SESSION_CREATE_INFO_ARM);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkDataGraphPipelineSessionCreateInfoARM sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkDataGraphPipelineSessionCreateInfoARM pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkDataGraphPipelineSessionCreateInfoARM pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkDataGraphPipelineSessionCreateFlagsARM.class) long flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkDataGraphPipelineSessionCreateInfoARM flags(@Bitmask(VkDataGraphPipelineSessionCreateFlagsARM.class) long value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @Nullable VkPipeline dataGraphPipeline() {
        MemorySegment s = segment.asSlice(OFFSET$dataGraphPipeline, SIZE$dataGraphPipeline);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkPipeline(s);
    }

    public VkDataGraphPipelineSessionCreateInfoARM dataGraphPipeline(@Nullable VkPipeline value) {
        segment.set(LAYOUT$dataGraphPipeline, OFFSET$dataGraphPipeline, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_LONG.withName("flags"),
        ValueLayout.ADDRESS.withName("dataGraphPipeline")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$dataGraphPipeline = PathElement.groupElement("dataGraphPipeline");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfLong LAYOUT$flags = (OfLong) LAYOUT.select(PATH$flags);
    public static final AddressLayout LAYOUT$dataGraphPipeline = (AddressLayout) LAYOUT.select(PATH$dataGraphPipeline);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$dataGraphPipeline = LAYOUT$dataGraphPipeline.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$dataGraphPipeline = LAYOUT.byteOffset(PATH$dataGraphPipeline);
}
