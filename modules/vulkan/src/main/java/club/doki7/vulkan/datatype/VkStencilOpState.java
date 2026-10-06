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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkStencilOpState.html"><code>VkStencilOpState</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkStencilOpState {
///     VkStencilOp failOp; // @link substring="VkStencilOp" target="VkStencilOp" @link substring="failOp" target="#failOp"
///     VkStencilOp passOp; // @link substring="VkStencilOp" target="VkStencilOp" @link substring="passOp" target="#passOp"
///     VkStencilOp depthFailOp; // @link substring="VkStencilOp" target="VkStencilOp" @link substring="depthFailOp" target="#depthFailOp"
///     VkCompareOp compareOp; // @link substring="VkCompareOp" target="VkCompareOp" @link substring="compareOp" target="#compareOp"
///     uint32_t compareMask; // @link substring="compareMask" target="#compareMask"
///     uint32_t writeMask; // @link substring="writeMask" target="#writeMask"
///     uint32_t reference; // @link substring="reference" target="#reference"
/// } VkStencilOpState;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkStencilOpState.html"><code>VkStencilOpState</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkStencilOpState(@NotNull MemorySegment segment) implements IVkStencilOpState {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkStencilOpState.html"><code>VkStencilOpState</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkStencilOpState}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkStencilOpState to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkStencilOpState.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkStencilOpState, Iterable<VkStencilOpState> {
        public long size() {
            return segment.byteSize() / VkStencilOpState.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkStencilOpState at(long index) {
            return new VkStencilOpState(segment.asSlice(index * VkStencilOpState.BYTES, VkStencilOpState.BYTES));
        }

        public VkStencilOpState.Ptr at(long index, @NotNull Consumer<@NotNull VkStencilOpState> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkStencilOpState value) {
            MemorySegment s = segment.asSlice(index * VkStencilOpState.BYTES, VkStencilOpState.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkStencilOpState.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkStencilOpState.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkStencilOpState.BYTES,
                (end - start) * VkStencilOpState.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkStencilOpState.BYTES));
        }

        public VkStencilOpState[] toArray() {
            VkStencilOpState[] ret = new VkStencilOpState[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkStencilOpState> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkStencilOpState> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkStencilOpState.BYTES;
            }

            @Override
            public VkStencilOpState next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkStencilOpState ret = new VkStencilOpState(segment.asSlice(0, VkStencilOpState.BYTES));
                segment = segment.asSlice(VkStencilOpState.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkStencilOpState allocate(Arena arena) {
        return new VkStencilOpState(arena.allocate(LAYOUT));
    }

    public static VkStencilOpState.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkStencilOpState.Ptr(segment);
    }

    public static VkStencilOpState clone(Arena arena, VkStencilOpState src) {
        VkStencilOpState ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @EnumType(VkStencilOp.class) int failOp() {
        return segment.get(LAYOUT$failOp, OFFSET$failOp);
    }

    public VkStencilOpState failOp(@EnumType(VkStencilOp.class) int value) {
        segment.set(LAYOUT$failOp, OFFSET$failOp, value);
        return this;
    }

    public @EnumType(VkStencilOp.class) int passOp() {
        return segment.get(LAYOUT$passOp, OFFSET$passOp);
    }

    public VkStencilOpState passOp(@EnumType(VkStencilOp.class) int value) {
        segment.set(LAYOUT$passOp, OFFSET$passOp, value);
        return this;
    }

    public @EnumType(VkStencilOp.class) int depthFailOp() {
        return segment.get(LAYOUT$depthFailOp, OFFSET$depthFailOp);
    }

    public VkStencilOpState depthFailOp(@EnumType(VkStencilOp.class) int value) {
        segment.set(LAYOUT$depthFailOp, OFFSET$depthFailOp, value);
        return this;
    }

    public @EnumType(VkCompareOp.class) int compareOp() {
        return segment.get(LAYOUT$compareOp, OFFSET$compareOp);
    }

    public VkStencilOpState compareOp(@EnumType(VkCompareOp.class) int value) {
        segment.set(LAYOUT$compareOp, OFFSET$compareOp, value);
        return this;
    }

    public @Unsigned int compareMask() {
        return segment.get(LAYOUT$compareMask, OFFSET$compareMask);
    }

    public VkStencilOpState compareMask(@Unsigned int value) {
        segment.set(LAYOUT$compareMask, OFFSET$compareMask, value);
        return this;
    }

    public @Unsigned int writeMask() {
        return segment.get(LAYOUT$writeMask, OFFSET$writeMask);
    }

    public VkStencilOpState writeMask(@Unsigned int value) {
        segment.set(LAYOUT$writeMask, OFFSET$writeMask, value);
        return this;
    }

    public @Unsigned int reference() {
        return segment.get(LAYOUT$reference, OFFSET$reference);
    }

    public VkStencilOpState reference(@Unsigned int value) {
        segment.set(LAYOUT$reference, OFFSET$reference, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("failOp"),
        ValueLayout.JAVA_INT.withName("passOp"),
        ValueLayout.JAVA_INT.withName("depthFailOp"),
        ValueLayout.JAVA_INT.withName("compareOp"),
        ValueLayout.JAVA_INT.withName("compareMask"),
        ValueLayout.JAVA_INT.withName("writeMask"),
        ValueLayout.JAVA_INT.withName("reference")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$failOp = PathElement.groupElement("failOp");
    public static final PathElement PATH$passOp = PathElement.groupElement("passOp");
    public static final PathElement PATH$depthFailOp = PathElement.groupElement("depthFailOp");
    public static final PathElement PATH$compareOp = PathElement.groupElement("compareOp");
    public static final PathElement PATH$compareMask = PathElement.groupElement("compareMask");
    public static final PathElement PATH$writeMask = PathElement.groupElement("writeMask");
    public static final PathElement PATH$reference = PathElement.groupElement("reference");

    public static final OfInt LAYOUT$failOp = (OfInt) LAYOUT.select(PATH$failOp);
    public static final OfInt LAYOUT$passOp = (OfInt) LAYOUT.select(PATH$passOp);
    public static final OfInt LAYOUT$depthFailOp = (OfInt) LAYOUT.select(PATH$depthFailOp);
    public static final OfInt LAYOUT$compareOp = (OfInt) LAYOUT.select(PATH$compareOp);
    public static final OfInt LAYOUT$compareMask = (OfInt) LAYOUT.select(PATH$compareMask);
    public static final OfInt LAYOUT$writeMask = (OfInt) LAYOUT.select(PATH$writeMask);
    public static final OfInt LAYOUT$reference = (OfInt) LAYOUT.select(PATH$reference);

    public static final long SIZE$failOp = LAYOUT$failOp.byteSize();
    public static final long SIZE$passOp = LAYOUT$passOp.byteSize();
    public static final long SIZE$depthFailOp = LAYOUT$depthFailOp.byteSize();
    public static final long SIZE$compareOp = LAYOUT$compareOp.byteSize();
    public static final long SIZE$compareMask = LAYOUT$compareMask.byteSize();
    public static final long SIZE$writeMask = LAYOUT$writeMask.byteSize();
    public static final long SIZE$reference = LAYOUT$reference.byteSize();

    public static final long OFFSET$failOp = LAYOUT.byteOffset(PATH$failOp);
    public static final long OFFSET$passOp = LAYOUT.byteOffset(PATH$passOp);
    public static final long OFFSET$depthFailOp = LAYOUT.byteOffset(PATH$depthFailOp);
    public static final long OFFSET$compareOp = LAYOUT.byteOffset(PATH$compareOp);
    public static final long OFFSET$compareMask = LAYOUT.byteOffset(PATH$compareMask);
    public static final long OFFSET$writeMask = LAYOUT.byteOffset(PATH$writeMask);
    public static final long OFFSET$reference = LAYOUT.byteOffset(PATH$reference);
}
