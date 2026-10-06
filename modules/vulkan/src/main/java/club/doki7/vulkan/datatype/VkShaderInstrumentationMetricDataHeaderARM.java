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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkShaderInstrumentationMetricDataHeaderARM.html"><code>VkShaderInstrumentationMetricDataHeaderARM</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkShaderInstrumentationMetricDataHeaderARM {
///     uint32_t resultIndex; // @link substring="resultIndex" target="#resultIndex"
///     uint32_t resultSubIndex; // @link substring="resultSubIndex" target="#resultSubIndex"
///     VkShaderStageFlags stages; // @link substring="VkShaderStageFlags" target="VkShaderStageFlags" @link substring="stages" target="#stages"
///     uint32_t basicBlockIndex; // @link substring="basicBlockIndex" target="#basicBlockIndex"
/// } VkShaderInstrumentationMetricDataHeaderARM;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkShaderInstrumentationMetricDataHeaderARM.html"><code>VkShaderInstrumentationMetricDataHeaderARM</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkShaderInstrumentationMetricDataHeaderARM(@NotNull MemorySegment segment) implements IVkShaderInstrumentationMetricDataHeaderARM {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkShaderInstrumentationMetricDataHeaderARM.html"><code>VkShaderInstrumentationMetricDataHeaderARM</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkShaderInstrumentationMetricDataHeaderARM}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkShaderInstrumentationMetricDataHeaderARM to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkShaderInstrumentationMetricDataHeaderARM.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkShaderInstrumentationMetricDataHeaderARM, Iterable<VkShaderInstrumentationMetricDataHeaderARM> {
        public long size() {
            return segment.byteSize() / VkShaderInstrumentationMetricDataHeaderARM.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkShaderInstrumentationMetricDataHeaderARM at(long index) {
            return new VkShaderInstrumentationMetricDataHeaderARM(segment.asSlice(index * VkShaderInstrumentationMetricDataHeaderARM.BYTES, VkShaderInstrumentationMetricDataHeaderARM.BYTES));
        }

        public VkShaderInstrumentationMetricDataHeaderARM.Ptr at(long index, @NotNull Consumer<@NotNull VkShaderInstrumentationMetricDataHeaderARM> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkShaderInstrumentationMetricDataHeaderARM value) {
            MemorySegment s = segment.asSlice(index * VkShaderInstrumentationMetricDataHeaderARM.BYTES, VkShaderInstrumentationMetricDataHeaderARM.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkShaderInstrumentationMetricDataHeaderARM.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkShaderInstrumentationMetricDataHeaderARM.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkShaderInstrumentationMetricDataHeaderARM.BYTES,
                (end - start) * VkShaderInstrumentationMetricDataHeaderARM.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkShaderInstrumentationMetricDataHeaderARM.BYTES));
        }

        public VkShaderInstrumentationMetricDataHeaderARM[] toArray() {
            VkShaderInstrumentationMetricDataHeaderARM[] ret = new VkShaderInstrumentationMetricDataHeaderARM[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkShaderInstrumentationMetricDataHeaderARM> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkShaderInstrumentationMetricDataHeaderARM> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkShaderInstrumentationMetricDataHeaderARM.BYTES;
            }

            @Override
            public VkShaderInstrumentationMetricDataHeaderARM next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkShaderInstrumentationMetricDataHeaderARM ret = new VkShaderInstrumentationMetricDataHeaderARM(segment.asSlice(0, VkShaderInstrumentationMetricDataHeaderARM.BYTES));
                segment = segment.asSlice(VkShaderInstrumentationMetricDataHeaderARM.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkShaderInstrumentationMetricDataHeaderARM allocate(Arena arena) {
        return new VkShaderInstrumentationMetricDataHeaderARM(arena.allocate(LAYOUT));
    }

    public static VkShaderInstrumentationMetricDataHeaderARM.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkShaderInstrumentationMetricDataHeaderARM.Ptr(segment);
    }

    public static VkShaderInstrumentationMetricDataHeaderARM clone(Arena arena, VkShaderInstrumentationMetricDataHeaderARM src) {
        VkShaderInstrumentationMetricDataHeaderARM ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned int resultIndex() {
        return segment.get(LAYOUT$resultIndex, OFFSET$resultIndex);
    }

    public VkShaderInstrumentationMetricDataHeaderARM resultIndex(@Unsigned int value) {
        segment.set(LAYOUT$resultIndex, OFFSET$resultIndex, value);
        return this;
    }

    public @Unsigned int resultSubIndex() {
        return segment.get(LAYOUT$resultSubIndex, OFFSET$resultSubIndex);
    }

    public VkShaderInstrumentationMetricDataHeaderARM resultSubIndex(@Unsigned int value) {
        segment.set(LAYOUT$resultSubIndex, OFFSET$resultSubIndex, value);
        return this;
    }

    public @Bitmask(VkShaderStageFlags.class) int stages() {
        return segment.get(LAYOUT$stages, OFFSET$stages);
    }

    public VkShaderInstrumentationMetricDataHeaderARM stages(@Bitmask(VkShaderStageFlags.class) int value) {
        segment.set(LAYOUT$stages, OFFSET$stages, value);
        return this;
    }

    public @Unsigned int basicBlockIndex() {
        return segment.get(LAYOUT$basicBlockIndex, OFFSET$basicBlockIndex);
    }

    public VkShaderInstrumentationMetricDataHeaderARM basicBlockIndex(@Unsigned int value) {
        segment.set(LAYOUT$basicBlockIndex, OFFSET$basicBlockIndex, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("resultIndex"),
        ValueLayout.JAVA_INT.withName("resultSubIndex"),
        ValueLayout.JAVA_INT.withName("stages"),
        ValueLayout.JAVA_INT.withName("basicBlockIndex")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$resultIndex = PathElement.groupElement("resultIndex");
    public static final PathElement PATH$resultSubIndex = PathElement.groupElement("resultSubIndex");
    public static final PathElement PATH$stages = PathElement.groupElement("stages");
    public static final PathElement PATH$basicBlockIndex = PathElement.groupElement("basicBlockIndex");

    public static final OfInt LAYOUT$resultIndex = (OfInt) LAYOUT.select(PATH$resultIndex);
    public static final OfInt LAYOUT$resultSubIndex = (OfInt) LAYOUT.select(PATH$resultSubIndex);
    public static final OfInt LAYOUT$stages = (OfInt) LAYOUT.select(PATH$stages);
    public static final OfInt LAYOUT$basicBlockIndex = (OfInt) LAYOUT.select(PATH$basicBlockIndex);

    public static final long SIZE$resultIndex = LAYOUT$resultIndex.byteSize();
    public static final long SIZE$resultSubIndex = LAYOUT$resultSubIndex.byteSize();
    public static final long SIZE$stages = LAYOUT$stages.byteSize();
    public static final long SIZE$basicBlockIndex = LAYOUT$basicBlockIndex.byteSize();

    public static final long OFFSET$resultIndex = LAYOUT.byteOffset(PATH$resultIndex);
    public static final long OFFSET$resultSubIndex = LAYOUT.byteOffset(PATH$resultSubIndex);
    public static final long OFFSET$stages = LAYOUT.byteOffset(PATH$stages);
    public static final long OFFSET$basicBlockIndex = LAYOUT.byteOffset(PATH$basicBlockIndex);
}
