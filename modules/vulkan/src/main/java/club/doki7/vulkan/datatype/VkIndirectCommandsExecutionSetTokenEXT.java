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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkIndirectCommandsExecutionSetTokenEXT.html"><code>VkIndirectCommandsExecutionSetTokenEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkIndirectCommandsExecutionSetTokenEXT {
///     VkIndirectExecutionSetInfoTypeEXT type; // @link substring="VkIndirectExecutionSetInfoTypeEXT" target="VkIndirectExecutionSetInfoTypeEXT" @link substring="type" target="#type"
///     VkShaderStageFlags shaderStages; // @link substring="VkShaderStageFlags" target="VkShaderStageFlags" @link substring="shaderStages" target="#shaderStages"
/// } VkIndirectCommandsExecutionSetTokenEXT;
/// }
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkIndirectCommandsExecutionSetTokenEXT.html"><code>VkIndirectCommandsExecutionSetTokenEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkIndirectCommandsExecutionSetTokenEXT(@NotNull MemorySegment segment) implements IVkIndirectCommandsExecutionSetTokenEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkIndirectCommandsExecutionSetTokenEXT.html"><code>VkIndirectCommandsExecutionSetTokenEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkIndirectCommandsExecutionSetTokenEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkIndirectCommandsExecutionSetTokenEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkIndirectCommandsExecutionSetTokenEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkIndirectCommandsExecutionSetTokenEXT, Iterable<VkIndirectCommandsExecutionSetTokenEXT> {
        public long size() {
            return segment.byteSize() / VkIndirectCommandsExecutionSetTokenEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkIndirectCommandsExecutionSetTokenEXT at(long index) {
            return new VkIndirectCommandsExecutionSetTokenEXT(segment.asSlice(index * VkIndirectCommandsExecutionSetTokenEXT.BYTES, VkIndirectCommandsExecutionSetTokenEXT.BYTES));
        }

        public VkIndirectCommandsExecutionSetTokenEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkIndirectCommandsExecutionSetTokenEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkIndirectCommandsExecutionSetTokenEXT value) {
            MemorySegment s = segment.asSlice(index * VkIndirectCommandsExecutionSetTokenEXT.BYTES, VkIndirectCommandsExecutionSetTokenEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkIndirectCommandsExecutionSetTokenEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkIndirectCommandsExecutionSetTokenEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkIndirectCommandsExecutionSetTokenEXT.BYTES,
                (end - start) * VkIndirectCommandsExecutionSetTokenEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkIndirectCommandsExecutionSetTokenEXT.BYTES));
        }

        public VkIndirectCommandsExecutionSetTokenEXT[] toArray() {
            VkIndirectCommandsExecutionSetTokenEXT[] ret = new VkIndirectCommandsExecutionSetTokenEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkIndirectCommandsExecutionSetTokenEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkIndirectCommandsExecutionSetTokenEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkIndirectCommandsExecutionSetTokenEXT.BYTES;
            }

            @Override
            public VkIndirectCommandsExecutionSetTokenEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkIndirectCommandsExecutionSetTokenEXT ret = new VkIndirectCommandsExecutionSetTokenEXT(segment.asSlice(0, VkIndirectCommandsExecutionSetTokenEXT.BYTES));
                segment = segment.asSlice(VkIndirectCommandsExecutionSetTokenEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkIndirectCommandsExecutionSetTokenEXT allocate(Arena arena) {
        return new VkIndirectCommandsExecutionSetTokenEXT(arena.allocate(LAYOUT));
    }

    public static VkIndirectCommandsExecutionSetTokenEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkIndirectCommandsExecutionSetTokenEXT.Ptr(segment);
    }

    public static VkIndirectCommandsExecutionSetTokenEXT clone(Arena arena, VkIndirectCommandsExecutionSetTokenEXT src) {
        VkIndirectCommandsExecutionSetTokenEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @EnumType(VkIndirectExecutionSetInfoTypeEXT.class) int type() {
        return segment.get(LAYOUT$type, OFFSET$type);
    }

    public VkIndirectCommandsExecutionSetTokenEXT type(@EnumType(VkIndirectExecutionSetInfoTypeEXT.class) int value) {
        segment.set(LAYOUT$type, OFFSET$type, value);
        return this;
    }

    public @Bitmask(VkShaderStageFlags.class) int shaderStages() {
        return segment.get(LAYOUT$shaderStages, OFFSET$shaderStages);
    }

    public VkIndirectCommandsExecutionSetTokenEXT shaderStages(@Bitmask(VkShaderStageFlags.class) int value) {
        segment.set(LAYOUT$shaderStages, OFFSET$shaderStages, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("type"),
        ValueLayout.JAVA_INT.withName("shaderStages")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$type = PathElement.groupElement("type");
    public static final PathElement PATH$shaderStages = PathElement.groupElement("shaderStages");

    public static final OfInt LAYOUT$type = (OfInt) LAYOUT.select(PATH$type);
    public static final OfInt LAYOUT$shaderStages = (OfInt) LAYOUT.select(PATH$shaderStages);

    public static final long SIZE$type = LAYOUT$type.byteSize();
    public static final long SIZE$shaderStages = LAYOUT$shaderStages.byteSize();

    public static final long OFFSET$type = LAYOUT.byteOffset(PATH$type);
    public static final long OFFSET$shaderStages = LAYOUT.byteOffset(PATH$shaderStages);
}
