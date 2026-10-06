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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDepthBiasInfoEXT.html"><code>VkDepthBiasInfoEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDepthBiasInfoEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     float depthBiasConstantFactor; // @link substring="depthBiasConstantFactor" target="#depthBiasConstantFactor"
///     float depthBiasClamp; // @link substring="depthBiasClamp" target="#depthBiasClamp"
///     float depthBiasSlopeFactor; // @link substring="depthBiasSlopeFactor" target="#depthBiasSlopeFactor"
/// } VkDepthBiasInfoEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_DEPTH_BIAS_INFO_EXT`
///
/// The {@code allocate} ({@link VkDepthBiasInfoEXT#allocate(Arena)}, {@link VkDepthBiasInfoEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkDepthBiasInfoEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDepthBiasInfoEXT.html"><code>VkDepthBiasInfoEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDepthBiasInfoEXT(@NotNull MemorySegment segment) implements IVkDepthBiasInfoEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDepthBiasInfoEXT.html"><code>VkDepthBiasInfoEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDepthBiasInfoEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDepthBiasInfoEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDepthBiasInfoEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDepthBiasInfoEXT, Iterable<VkDepthBiasInfoEXT> {
        public long size() {
            return segment.byteSize() / VkDepthBiasInfoEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDepthBiasInfoEXT at(long index) {
            return new VkDepthBiasInfoEXT(segment.asSlice(index * VkDepthBiasInfoEXT.BYTES, VkDepthBiasInfoEXT.BYTES));
        }

        public VkDepthBiasInfoEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkDepthBiasInfoEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDepthBiasInfoEXT value) {
            MemorySegment s = segment.asSlice(index * VkDepthBiasInfoEXT.BYTES, VkDepthBiasInfoEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDepthBiasInfoEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDepthBiasInfoEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDepthBiasInfoEXT.BYTES,
                (end - start) * VkDepthBiasInfoEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDepthBiasInfoEXT.BYTES));
        }

        public VkDepthBiasInfoEXT[] toArray() {
            VkDepthBiasInfoEXT[] ret = new VkDepthBiasInfoEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDepthBiasInfoEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDepthBiasInfoEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDepthBiasInfoEXT.BYTES;
            }

            @Override
            public VkDepthBiasInfoEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDepthBiasInfoEXT ret = new VkDepthBiasInfoEXT(segment.asSlice(0, VkDepthBiasInfoEXT.BYTES));
                segment = segment.asSlice(VkDepthBiasInfoEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDepthBiasInfoEXT allocate(Arena arena) {
        VkDepthBiasInfoEXT ret = new VkDepthBiasInfoEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.DEPTH_BIAS_INFO_EXT);
        return ret;
    }

    public static VkDepthBiasInfoEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkDepthBiasInfoEXT.Ptr ret = new VkDepthBiasInfoEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.DEPTH_BIAS_INFO_EXT);
        }
        return ret;
    }

    public static VkDepthBiasInfoEXT clone(Arena arena, VkDepthBiasInfoEXT src) {
        VkDepthBiasInfoEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.DEPTH_BIAS_INFO_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkDepthBiasInfoEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkDepthBiasInfoEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkDepthBiasInfoEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public float depthBiasConstantFactor() {
        return segment.get(LAYOUT$depthBiasConstantFactor, OFFSET$depthBiasConstantFactor);
    }

    public VkDepthBiasInfoEXT depthBiasConstantFactor(float value) {
        segment.set(LAYOUT$depthBiasConstantFactor, OFFSET$depthBiasConstantFactor, value);
        return this;
    }

    public float depthBiasClamp() {
        return segment.get(LAYOUT$depthBiasClamp, OFFSET$depthBiasClamp);
    }

    public VkDepthBiasInfoEXT depthBiasClamp(float value) {
        segment.set(LAYOUT$depthBiasClamp, OFFSET$depthBiasClamp, value);
        return this;
    }

    public float depthBiasSlopeFactor() {
        return segment.get(LAYOUT$depthBiasSlopeFactor, OFFSET$depthBiasSlopeFactor);
    }

    public VkDepthBiasInfoEXT depthBiasSlopeFactor(float value) {
        segment.set(LAYOUT$depthBiasSlopeFactor, OFFSET$depthBiasSlopeFactor, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_FLOAT.withName("depthBiasConstantFactor"),
        ValueLayout.JAVA_FLOAT.withName("depthBiasClamp"),
        ValueLayout.JAVA_FLOAT.withName("depthBiasSlopeFactor")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$depthBiasConstantFactor = PathElement.groupElement("depthBiasConstantFactor");
    public static final PathElement PATH$depthBiasClamp = PathElement.groupElement("depthBiasClamp");
    public static final PathElement PATH$depthBiasSlopeFactor = PathElement.groupElement("depthBiasSlopeFactor");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfFloat LAYOUT$depthBiasConstantFactor = (OfFloat) LAYOUT.select(PATH$depthBiasConstantFactor);
    public static final OfFloat LAYOUT$depthBiasClamp = (OfFloat) LAYOUT.select(PATH$depthBiasClamp);
    public static final OfFloat LAYOUT$depthBiasSlopeFactor = (OfFloat) LAYOUT.select(PATH$depthBiasSlopeFactor);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$depthBiasConstantFactor = LAYOUT$depthBiasConstantFactor.byteSize();
    public static final long SIZE$depthBiasClamp = LAYOUT$depthBiasClamp.byteSize();
    public static final long SIZE$depthBiasSlopeFactor = LAYOUT$depthBiasSlopeFactor.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$depthBiasConstantFactor = LAYOUT.byteOffset(PATH$depthBiasConstantFactor);
    public static final long OFFSET$depthBiasClamp = LAYOUT.byteOffset(PATH$depthBiasClamp);
    public static final long OFFSET$depthBiasSlopeFactor = LAYOUT.byteOffset(PATH$depthBiasSlopeFactor);
}
