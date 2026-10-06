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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineColorBlendAttachmentState.html"><code>VkPipelineColorBlendAttachmentState</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPipelineColorBlendAttachmentState {
///     VkBool32 blendEnable; // @link substring="blendEnable" target="#blendEnable"
///     VkBlendFactor srcColorBlendFactor; // @link substring="VkBlendFactor" target="VkBlendFactor" @link substring="srcColorBlendFactor" target="#srcColorBlendFactor"
///     VkBlendFactor dstColorBlendFactor; // @link substring="VkBlendFactor" target="VkBlendFactor" @link substring="dstColorBlendFactor" target="#dstColorBlendFactor"
///     VkBlendOp colorBlendOp; // @link substring="VkBlendOp" target="VkBlendOp" @link substring="colorBlendOp" target="#colorBlendOp"
///     VkBlendFactor srcAlphaBlendFactor; // @link substring="VkBlendFactor" target="VkBlendFactor" @link substring="srcAlphaBlendFactor" target="#srcAlphaBlendFactor"
///     VkBlendFactor dstAlphaBlendFactor; // @link substring="VkBlendFactor" target="VkBlendFactor" @link substring="dstAlphaBlendFactor" target="#dstAlphaBlendFactor"
///     VkBlendOp alphaBlendOp; // @link substring="VkBlendOp" target="VkBlendOp" @link substring="alphaBlendOp" target="#alphaBlendOp"
///     VkColorComponentFlags colorWriteMask; // optional // @link substring="VkColorComponentFlags" target="VkColorComponentFlags" @link substring="colorWriteMask" target="#colorWriteMask"
/// } VkPipelineColorBlendAttachmentState;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineColorBlendAttachmentState.html"><code>VkPipelineColorBlendAttachmentState</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPipelineColorBlendAttachmentState(@NotNull MemorySegment segment) implements IVkPipelineColorBlendAttachmentState {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineColorBlendAttachmentState.html"><code>VkPipelineColorBlendAttachmentState</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPipelineColorBlendAttachmentState}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPipelineColorBlendAttachmentState to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPipelineColorBlendAttachmentState.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPipelineColorBlendAttachmentState, Iterable<VkPipelineColorBlendAttachmentState> {
        public long size() {
            return segment.byteSize() / VkPipelineColorBlendAttachmentState.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPipelineColorBlendAttachmentState at(long index) {
            return new VkPipelineColorBlendAttachmentState(segment.asSlice(index * VkPipelineColorBlendAttachmentState.BYTES, VkPipelineColorBlendAttachmentState.BYTES));
        }

        public VkPipelineColorBlendAttachmentState.Ptr at(long index, @NotNull Consumer<@NotNull VkPipelineColorBlendAttachmentState> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPipelineColorBlendAttachmentState value) {
            MemorySegment s = segment.asSlice(index * VkPipelineColorBlendAttachmentState.BYTES, VkPipelineColorBlendAttachmentState.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPipelineColorBlendAttachmentState.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPipelineColorBlendAttachmentState.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPipelineColorBlendAttachmentState.BYTES,
                (end - start) * VkPipelineColorBlendAttachmentState.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPipelineColorBlendAttachmentState.BYTES));
        }

        public VkPipelineColorBlendAttachmentState[] toArray() {
            VkPipelineColorBlendAttachmentState[] ret = new VkPipelineColorBlendAttachmentState[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPipelineColorBlendAttachmentState> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPipelineColorBlendAttachmentState> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPipelineColorBlendAttachmentState.BYTES;
            }

            @Override
            public VkPipelineColorBlendAttachmentState next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPipelineColorBlendAttachmentState ret = new VkPipelineColorBlendAttachmentState(segment.asSlice(0, VkPipelineColorBlendAttachmentState.BYTES));
                segment = segment.asSlice(VkPipelineColorBlendAttachmentState.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPipelineColorBlendAttachmentState allocate(Arena arena) {
        return new VkPipelineColorBlendAttachmentState(arena.allocate(LAYOUT));
    }

    public static VkPipelineColorBlendAttachmentState.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkPipelineColorBlendAttachmentState.Ptr(segment);
    }

    public static VkPipelineColorBlendAttachmentState clone(Arena arena, VkPipelineColorBlendAttachmentState src) {
        VkPipelineColorBlendAttachmentState ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NativeType("VkBool32") @Unsigned int blendEnable() {
        return segment.get(LAYOUT$blendEnable, OFFSET$blendEnable);
    }

    public VkPipelineColorBlendAttachmentState blendEnable(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$blendEnable, OFFSET$blendEnable, value);
        return this;
    }

    public @EnumType(VkBlendFactor.class) int srcColorBlendFactor() {
        return segment.get(LAYOUT$srcColorBlendFactor, OFFSET$srcColorBlendFactor);
    }

    public VkPipelineColorBlendAttachmentState srcColorBlendFactor(@EnumType(VkBlendFactor.class) int value) {
        segment.set(LAYOUT$srcColorBlendFactor, OFFSET$srcColorBlendFactor, value);
        return this;
    }

    public @EnumType(VkBlendFactor.class) int dstColorBlendFactor() {
        return segment.get(LAYOUT$dstColorBlendFactor, OFFSET$dstColorBlendFactor);
    }

    public VkPipelineColorBlendAttachmentState dstColorBlendFactor(@EnumType(VkBlendFactor.class) int value) {
        segment.set(LAYOUT$dstColorBlendFactor, OFFSET$dstColorBlendFactor, value);
        return this;
    }

    public @EnumType(VkBlendOp.class) int colorBlendOp() {
        return segment.get(LAYOUT$colorBlendOp, OFFSET$colorBlendOp);
    }

    public VkPipelineColorBlendAttachmentState colorBlendOp(@EnumType(VkBlendOp.class) int value) {
        segment.set(LAYOUT$colorBlendOp, OFFSET$colorBlendOp, value);
        return this;
    }

    public @EnumType(VkBlendFactor.class) int srcAlphaBlendFactor() {
        return segment.get(LAYOUT$srcAlphaBlendFactor, OFFSET$srcAlphaBlendFactor);
    }

    public VkPipelineColorBlendAttachmentState srcAlphaBlendFactor(@EnumType(VkBlendFactor.class) int value) {
        segment.set(LAYOUT$srcAlphaBlendFactor, OFFSET$srcAlphaBlendFactor, value);
        return this;
    }

    public @EnumType(VkBlendFactor.class) int dstAlphaBlendFactor() {
        return segment.get(LAYOUT$dstAlphaBlendFactor, OFFSET$dstAlphaBlendFactor);
    }

    public VkPipelineColorBlendAttachmentState dstAlphaBlendFactor(@EnumType(VkBlendFactor.class) int value) {
        segment.set(LAYOUT$dstAlphaBlendFactor, OFFSET$dstAlphaBlendFactor, value);
        return this;
    }

    public @EnumType(VkBlendOp.class) int alphaBlendOp() {
        return segment.get(LAYOUT$alphaBlendOp, OFFSET$alphaBlendOp);
    }

    public VkPipelineColorBlendAttachmentState alphaBlendOp(@EnumType(VkBlendOp.class) int value) {
        segment.set(LAYOUT$alphaBlendOp, OFFSET$alphaBlendOp, value);
        return this;
    }

    public @Bitmask(VkColorComponentFlags.class) int colorWriteMask() {
        return segment.get(LAYOUT$colorWriteMask, OFFSET$colorWriteMask);
    }

    public VkPipelineColorBlendAttachmentState colorWriteMask(@Bitmask(VkColorComponentFlags.class) int value) {
        segment.set(LAYOUT$colorWriteMask, OFFSET$colorWriteMask, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("blendEnable"),
        ValueLayout.JAVA_INT.withName("srcColorBlendFactor"),
        ValueLayout.JAVA_INT.withName("dstColorBlendFactor"),
        ValueLayout.JAVA_INT.withName("colorBlendOp"),
        ValueLayout.JAVA_INT.withName("srcAlphaBlendFactor"),
        ValueLayout.JAVA_INT.withName("dstAlphaBlendFactor"),
        ValueLayout.JAVA_INT.withName("alphaBlendOp"),
        ValueLayout.JAVA_INT.withName("colorWriteMask")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$blendEnable = PathElement.groupElement("blendEnable");
    public static final PathElement PATH$srcColorBlendFactor = PathElement.groupElement("srcColorBlendFactor");
    public static final PathElement PATH$dstColorBlendFactor = PathElement.groupElement("dstColorBlendFactor");
    public static final PathElement PATH$colorBlendOp = PathElement.groupElement("colorBlendOp");
    public static final PathElement PATH$srcAlphaBlendFactor = PathElement.groupElement("srcAlphaBlendFactor");
    public static final PathElement PATH$dstAlphaBlendFactor = PathElement.groupElement("dstAlphaBlendFactor");
    public static final PathElement PATH$alphaBlendOp = PathElement.groupElement("alphaBlendOp");
    public static final PathElement PATH$colorWriteMask = PathElement.groupElement("colorWriteMask");

    public static final OfInt LAYOUT$blendEnable = (OfInt) LAYOUT.select(PATH$blendEnable);
    public static final OfInt LAYOUT$srcColorBlendFactor = (OfInt) LAYOUT.select(PATH$srcColorBlendFactor);
    public static final OfInt LAYOUT$dstColorBlendFactor = (OfInt) LAYOUT.select(PATH$dstColorBlendFactor);
    public static final OfInt LAYOUT$colorBlendOp = (OfInt) LAYOUT.select(PATH$colorBlendOp);
    public static final OfInt LAYOUT$srcAlphaBlendFactor = (OfInt) LAYOUT.select(PATH$srcAlphaBlendFactor);
    public static final OfInt LAYOUT$dstAlphaBlendFactor = (OfInt) LAYOUT.select(PATH$dstAlphaBlendFactor);
    public static final OfInt LAYOUT$alphaBlendOp = (OfInt) LAYOUT.select(PATH$alphaBlendOp);
    public static final OfInt LAYOUT$colorWriteMask = (OfInt) LAYOUT.select(PATH$colorWriteMask);

    public static final long SIZE$blendEnable = LAYOUT$blendEnable.byteSize();
    public static final long SIZE$srcColorBlendFactor = LAYOUT$srcColorBlendFactor.byteSize();
    public static final long SIZE$dstColorBlendFactor = LAYOUT$dstColorBlendFactor.byteSize();
    public static final long SIZE$colorBlendOp = LAYOUT$colorBlendOp.byteSize();
    public static final long SIZE$srcAlphaBlendFactor = LAYOUT$srcAlphaBlendFactor.byteSize();
    public static final long SIZE$dstAlphaBlendFactor = LAYOUT$dstAlphaBlendFactor.byteSize();
    public static final long SIZE$alphaBlendOp = LAYOUT$alphaBlendOp.byteSize();
    public static final long SIZE$colorWriteMask = LAYOUT$colorWriteMask.byteSize();

    public static final long OFFSET$blendEnable = LAYOUT.byteOffset(PATH$blendEnable);
    public static final long OFFSET$srcColorBlendFactor = LAYOUT.byteOffset(PATH$srcColorBlendFactor);
    public static final long OFFSET$dstColorBlendFactor = LAYOUT.byteOffset(PATH$dstColorBlendFactor);
    public static final long OFFSET$colorBlendOp = LAYOUT.byteOffset(PATH$colorBlendOp);
    public static final long OFFSET$srcAlphaBlendFactor = LAYOUT.byteOffset(PATH$srcAlphaBlendFactor);
    public static final long OFFSET$dstAlphaBlendFactor = LAYOUT.byteOffset(PATH$dstAlphaBlendFactor);
    public static final long OFFSET$alphaBlendOp = LAYOUT.byteOffset(PATH$alphaBlendOp);
    public static final long OFFSET$colorWriteMask = LAYOUT.byteOffset(PATH$colorWriteMask);
}
