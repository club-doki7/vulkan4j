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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkIndirectCommandsLayoutCreateInfoEXT.html"><code>VkIndirectCommandsLayoutCreateInfoEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkIndirectCommandsLayoutCreateInfoEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkIndirectCommandsLayoutUsageFlagsEXT flags; // optional // @link substring="VkIndirectCommandsLayoutUsageFlagsEXT" target="VkIndirectCommandsLayoutUsageFlagsEXT" @link substring="flags" target="#flags"
///     VkShaderStageFlags shaderStages; // @link substring="VkShaderStageFlags" target="VkShaderStageFlags" @link substring="shaderStages" target="#shaderStages"
///     uint32_t indirectStride; // @link substring="indirectStride" target="#indirectStride"
///     VkPipelineLayout pipelineLayout; // optional // @link substring="VkPipelineLayout" target="VkPipelineLayout" @link substring="pipelineLayout" target="#pipelineLayout"
///     uint32_t tokenCount; // @link substring="tokenCount" target="#tokenCount"
///     VkIndirectCommandsLayoutTokenEXT const* pTokens; // @link substring="VkIndirectCommandsLayoutTokenEXT" target="VkIndirectCommandsLayoutTokenEXT" @link substring="pTokens" target="#pTokens"
/// } VkIndirectCommandsLayoutCreateInfoEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_INDIRECT_COMMANDS_LAYOUT_CREATE_INFO_EXT`
///
/// The {@code allocate} ({@link VkIndirectCommandsLayoutCreateInfoEXT#allocate(Arena)}, {@link VkIndirectCommandsLayoutCreateInfoEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkIndirectCommandsLayoutCreateInfoEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkIndirectCommandsLayoutCreateInfoEXT.html"><code>VkIndirectCommandsLayoutCreateInfoEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkIndirectCommandsLayoutCreateInfoEXT(@NotNull MemorySegment segment) implements IVkIndirectCommandsLayoutCreateInfoEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkIndirectCommandsLayoutCreateInfoEXT.html"><code>VkIndirectCommandsLayoutCreateInfoEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkIndirectCommandsLayoutCreateInfoEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkIndirectCommandsLayoutCreateInfoEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkIndirectCommandsLayoutCreateInfoEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkIndirectCommandsLayoutCreateInfoEXT, Iterable<VkIndirectCommandsLayoutCreateInfoEXT> {
        public long size() {
            return segment.byteSize() / VkIndirectCommandsLayoutCreateInfoEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkIndirectCommandsLayoutCreateInfoEXT at(long index) {
            return new VkIndirectCommandsLayoutCreateInfoEXT(segment.asSlice(index * VkIndirectCommandsLayoutCreateInfoEXT.BYTES, VkIndirectCommandsLayoutCreateInfoEXT.BYTES));
        }

        public VkIndirectCommandsLayoutCreateInfoEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkIndirectCommandsLayoutCreateInfoEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkIndirectCommandsLayoutCreateInfoEXT value) {
            MemorySegment s = segment.asSlice(index * VkIndirectCommandsLayoutCreateInfoEXT.BYTES, VkIndirectCommandsLayoutCreateInfoEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkIndirectCommandsLayoutCreateInfoEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkIndirectCommandsLayoutCreateInfoEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkIndirectCommandsLayoutCreateInfoEXT.BYTES,
                (end - start) * VkIndirectCommandsLayoutCreateInfoEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkIndirectCommandsLayoutCreateInfoEXT.BYTES));
        }

        public VkIndirectCommandsLayoutCreateInfoEXT[] toArray() {
            VkIndirectCommandsLayoutCreateInfoEXT[] ret = new VkIndirectCommandsLayoutCreateInfoEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkIndirectCommandsLayoutCreateInfoEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkIndirectCommandsLayoutCreateInfoEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkIndirectCommandsLayoutCreateInfoEXT.BYTES;
            }

            @Override
            public VkIndirectCommandsLayoutCreateInfoEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkIndirectCommandsLayoutCreateInfoEXT ret = new VkIndirectCommandsLayoutCreateInfoEXT(segment.asSlice(0, VkIndirectCommandsLayoutCreateInfoEXT.BYTES));
                segment = segment.asSlice(VkIndirectCommandsLayoutCreateInfoEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkIndirectCommandsLayoutCreateInfoEXT allocate(Arena arena) {
        VkIndirectCommandsLayoutCreateInfoEXT ret = new VkIndirectCommandsLayoutCreateInfoEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.INDIRECT_COMMANDS_LAYOUT_CREATE_INFO_EXT);
        return ret;
    }

    public static VkIndirectCommandsLayoutCreateInfoEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkIndirectCommandsLayoutCreateInfoEXT.Ptr ret = new VkIndirectCommandsLayoutCreateInfoEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.INDIRECT_COMMANDS_LAYOUT_CREATE_INFO_EXT);
        }
        return ret;
    }

    public static VkIndirectCommandsLayoutCreateInfoEXT clone(Arena arena, VkIndirectCommandsLayoutCreateInfoEXT src) {
        VkIndirectCommandsLayoutCreateInfoEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.INDIRECT_COMMANDS_LAYOUT_CREATE_INFO_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkIndirectCommandsLayoutCreateInfoEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkIndirectCommandsLayoutCreateInfoEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkIndirectCommandsLayoutCreateInfoEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkIndirectCommandsLayoutUsageFlagsEXT.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkIndirectCommandsLayoutCreateInfoEXT flags(@Bitmask(VkIndirectCommandsLayoutUsageFlagsEXT.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @Bitmask(VkShaderStageFlags.class) int shaderStages() {
        return segment.get(LAYOUT$shaderStages, OFFSET$shaderStages);
    }

    public VkIndirectCommandsLayoutCreateInfoEXT shaderStages(@Bitmask(VkShaderStageFlags.class) int value) {
        segment.set(LAYOUT$shaderStages, OFFSET$shaderStages, value);
        return this;
    }

    public @Unsigned int indirectStride() {
        return segment.get(LAYOUT$indirectStride, OFFSET$indirectStride);
    }

    public VkIndirectCommandsLayoutCreateInfoEXT indirectStride(@Unsigned int value) {
        segment.set(LAYOUT$indirectStride, OFFSET$indirectStride, value);
        return this;
    }

    public @Nullable VkPipelineLayout pipelineLayout() {
        MemorySegment s = segment.asSlice(OFFSET$pipelineLayout, SIZE$pipelineLayout);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkPipelineLayout(s);
    }

    public VkIndirectCommandsLayoutCreateInfoEXT pipelineLayout(@Nullable VkPipelineLayout value) {
        segment.set(LAYOUT$pipelineLayout, OFFSET$pipelineLayout, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int tokenCount() {
        return segment.get(LAYOUT$tokenCount, OFFSET$tokenCount);
    }

    public VkIndirectCommandsLayoutCreateInfoEXT tokenCount(@Unsigned int value) {
        segment.set(LAYOUT$tokenCount, OFFSET$tokenCount, value);
        return this;
    }

    public VkIndirectCommandsLayoutCreateInfoEXT pTokens(@Nullable IVkIndirectCommandsLayoutTokenEXT value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pTokensRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkIndirectCommandsLayoutTokenEXT.Ptr pTokens(int assumedCount) {
        MemorySegment s = pTokensRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkIndirectCommandsLayoutTokenEXT.BYTES);
        return new VkIndirectCommandsLayoutTokenEXT.Ptr(s);
    }

    public @Nullable VkIndirectCommandsLayoutTokenEXT pTokens() {
        MemorySegment s = pTokensRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkIndirectCommandsLayoutTokenEXT(s);
    }

    public @Pointer(target=VkIndirectCommandsLayoutTokenEXT.class) @NotNull MemorySegment pTokensRaw() {
        return segment.get(LAYOUT$pTokens, OFFSET$pTokens);
    }

    public void pTokensRaw(@Pointer(target=VkIndirectCommandsLayoutTokenEXT.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pTokens, OFFSET$pTokens, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("shaderStages"),
        ValueLayout.JAVA_INT.withName("indirectStride"),
        ValueLayout.ADDRESS.withName("pipelineLayout"),
        ValueLayout.JAVA_INT.withName("tokenCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkIndirectCommandsLayoutTokenEXT.LAYOUT).withName("pTokens")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$shaderStages = PathElement.groupElement("shaderStages");
    public static final PathElement PATH$indirectStride = PathElement.groupElement("indirectStride");
    public static final PathElement PATH$pipelineLayout = PathElement.groupElement("pipelineLayout");
    public static final PathElement PATH$tokenCount = PathElement.groupElement("tokenCount");
    public static final PathElement PATH$pTokens = PathElement.groupElement("pTokens");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$shaderStages = (OfInt) LAYOUT.select(PATH$shaderStages);
    public static final OfInt LAYOUT$indirectStride = (OfInt) LAYOUT.select(PATH$indirectStride);
    public static final AddressLayout LAYOUT$pipelineLayout = (AddressLayout) LAYOUT.select(PATH$pipelineLayout);
    public static final OfInt LAYOUT$tokenCount = (OfInt) LAYOUT.select(PATH$tokenCount);
    public static final AddressLayout LAYOUT$pTokens = (AddressLayout) LAYOUT.select(PATH$pTokens);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$shaderStages = LAYOUT$shaderStages.byteSize();
    public static final long SIZE$indirectStride = LAYOUT$indirectStride.byteSize();
    public static final long SIZE$pipelineLayout = LAYOUT$pipelineLayout.byteSize();
    public static final long SIZE$tokenCount = LAYOUT$tokenCount.byteSize();
    public static final long SIZE$pTokens = LAYOUT$pTokens.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$shaderStages = LAYOUT.byteOffset(PATH$shaderStages);
    public static final long OFFSET$indirectStride = LAYOUT.byteOffset(PATH$indirectStride);
    public static final long OFFSET$pipelineLayout = LAYOUT.byteOffset(PATH$pipelineLayout);
    public static final long OFFSET$tokenCount = LAYOUT.byteOffset(PATH$tokenCount);
    public static final long OFFSET$pTokens = LAYOUT.byteOffset(PATH$pTokens);
}
