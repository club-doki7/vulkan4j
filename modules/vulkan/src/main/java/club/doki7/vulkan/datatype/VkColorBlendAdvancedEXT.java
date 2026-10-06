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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkColorBlendAdvancedEXT.html"><code>VkColorBlendAdvancedEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkColorBlendAdvancedEXT {
///     VkBlendOp advancedBlendOp; // @link substring="VkBlendOp" target="VkBlendOp" @link substring="advancedBlendOp" target="#advancedBlendOp"
///     VkBool32 srcPremultiplied; // @link substring="srcPremultiplied" target="#srcPremultiplied"
///     VkBool32 dstPremultiplied; // @link substring="dstPremultiplied" target="#dstPremultiplied"
///     VkBlendOverlapEXT blendOverlap; // @link substring="VkBlendOverlapEXT" target="VkBlendOverlapEXT" @link substring="blendOverlap" target="#blendOverlap"
///     VkBool32 clampResults; // @link substring="clampResults" target="#clampResults"
/// } VkColorBlendAdvancedEXT;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkColorBlendAdvancedEXT.html"><code>VkColorBlendAdvancedEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkColorBlendAdvancedEXT(@NotNull MemorySegment segment) implements IVkColorBlendAdvancedEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkColorBlendAdvancedEXT.html"><code>VkColorBlendAdvancedEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkColorBlendAdvancedEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkColorBlendAdvancedEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkColorBlendAdvancedEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkColorBlendAdvancedEXT, Iterable<VkColorBlendAdvancedEXT> {
        public long size() {
            return segment.byteSize() / VkColorBlendAdvancedEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkColorBlendAdvancedEXT at(long index) {
            return new VkColorBlendAdvancedEXT(segment.asSlice(index * VkColorBlendAdvancedEXT.BYTES, VkColorBlendAdvancedEXT.BYTES));
        }

        public VkColorBlendAdvancedEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkColorBlendAdvancedEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkColorBlendAdvancedEXT value) {
            MemorySegment s = segment.asSlice(index * VkColorBlendAdvancedEXT.BYTES, VkColorBlendAdvancedEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkColorBlendAdvancedEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkColorBlendAdvancedEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkColorBlendAdvancedEXT.BYTES,
                (end - start) * VkColorBlendAdvancedEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkColorBlendAdvancedEXT.BYTES));
        }

        public VkColorBlendAdvancedEXT[] toArray() {
            VkColorBlendAdvancedEXT[] ret = new VkColorBlendAdvancedEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkColorBlendAdvancedEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkColorBlendAdvancedEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkColorBlendAdvancedEXT.BYTES;
            }

            @Override
            public VkColorBlendAdvancedEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkColorBlendAdvancedEXT ret = new VkColorBlendAdvancedEXT(segment.asSlice(0, VkColorBlendAdvancedEXT.BYTES));
                segment = segment.asSlice(VkColorBlendAdvancedEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkColorBlendAdvancedEXT allocate(Arena arena) {
        return new VkColorBlendAdvancedEXT(arena.allocate(LAYOUT));
    }

    public static VkColorBlendAdvancedEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkColorBlendAdvancedEXT.Ptr(segment);
    }

    public static VkColorBlendAdvancedEXT clone(Arena arena, VkColorBlendAdvancedEXT src) {
        VkColorBlendAdvancedEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @EnumType(VkBlendOp.class) int advancedBlendOp() {
        return segment.get(LAYOUT$advancedBlendOp, OFFSET$advancedBlendOp);
    }

    public VkColorBlendAdvancedEXT advancedBlendOp(@EnumType(VkBlendOp.class) int value) {
        segment.set(LAYOUT$advancedBlendOp, OFFSET$advancedBlendOp, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int srcPremultiplied() {
        return segment.get(LAYOUT$srcPremultiplied, OFFSET$srcPremultiplied);
    }

    public VkColorBlendAdvancedEXT srcPremultiplied(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$srcPremultiplied, OFFSET$srcPremultiplied, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int dstPremultiplied() {
        return segment.get(LAYOUT$dstPremultiplied, OFFSET$dstPremultiplied);
    }

    public VkColorBlendAdvancedEXT dstPremultiplied(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$dstPremultiplied, OFFSET$dstPremultiplied, value);
        return this;
    }

    public @EnumType(VkBlendOverlapEXT.class) int blendOverlap() {
        return segment.get(LAYOUT$blendOverlap, OFFSET$blendOverlap);
    }

    public VkColorBlendAdvancedEXT blendOverlap(@EnumType(VkBlendOverlapEXT.class) int value) {
        segment.set(LAYOUT$blendOverlap, OFFSET$blendOverlap, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int clampResults() {
        return segment.get(LAYOUT$clampResults, OFFSET$clampResults);
    }

    public VkColorBlendAdvancedEXT clampResults(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$clampResults, OFFSET$clampResults, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("advancedBlendOp"),
        ValueLayout.JAVA_INT.withName("srcPremultiplied"),
        ValueLayout.JAVA_INT.withName("dstPremultiplied"),
        ValueLayout.JAVA_INT.withName("blendOverlap"),
        ValueLayout.JAVA_INT.withName("clampResults")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$advancedBlendOp = PathElement.groupElement("advancedBlendOp");
    public static final PathElement PATH$srcPremultiplied = PathElement.groupElement("srcPremultiplied");
    public static final PathElement PATH$dstPremultiplied = PathElement.groupElement("dstPremultiplied");
    public static final PathElement PATH$blendOverlap = PathElement.groupElement("blendOverlap");
    public static final PathElement PATH$clampResults = PathElement.groupElement("clampResults");

    public static final OfInt LAYOUT$advancedBlendOp = (OfInt) LAYOUT.select(PATH$advancedBlendOp);
    public static final OfInt LAYOUT$srcPremultiplied = (OfInt) LAYOUT.select(PATH$srcPremultiplied);
    public static final OfInt LAYOUT$dstPremultiplied = (OfInt) LAYOUT.select(PATH$dstPremultiplied);
    public static final OfInt LAYOUT$blendOverlap = (OfInt) LAYOUT.select(PATH$blendOverlap);
    public static final OfInt LAYOUT$clampResults = (OfInt) LAYOUT.select(PATH$clampResults);

    public static final long SIZE$advancedBlendOp = LAYOUT$advancedBlendOp.byteSize();
    public static final long SIZE$srcPremultiplied = LAYOUT$srcPremultiplied.byteSize();
    public static final long SIZE$dstPremultiplied = LAYOUT$dstPremultiplied.byteSize();
    public static final long SIZE$blendOverlap = LAYOUT$blendOverlap.byteSize();
    public static final long SIZE$clampResults = LAYOUT$clampResults.byteSize();

    public static final long OFFSET$advancedBlendOp = LAYOUT.byteOffset(PATH$advancedBlendOp);
    public static final long OFFSET$srcPremultiplied = LAYOUT.byteOffset(PATH$srcPremultiplied);
    public static final long OFFSET$dstPremultiplied = LAYOUT.byteOffset(PATH$dstPremultiplied);
    public static final long OFFSET$blendOverlap = LAYOUT.byteOffset(PATH$blendOverlap);
    public static final long OFFSET$clampResults = LAYOUT.byteOffset(PATH$clampResults);
}
