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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineRasterizationConservativeStateCreateInfoEXT.html"><code>VkPipelineRasterizationConservativeStateCreateInfoEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPipelineRasterizationConservativeStateCreateInfoEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkPipelineRasterizationConservativeStateCreateFlagsEXT flags; // optional // @link substring="VkPipelineRasterizationConservativeStateCreateFlagsEXT" target="VkPipelineRasterizationConservativeStateCreateFlagsEXT" @link substring="flags" target="#flags"
///     VkConservativeRasterizationModeEXT conservativeRasterizationMode; // @link substring="VkConservativeRasterizationModeEXT" target="VkConservativeRasterizationModeEXT" @link substring="conservativeRasterizationMode" target="#conservativeRasterizationMode"
///     float extraPrimitiveOverestimationSize; // @link substring="extraPrimitiveOverestimationSize" target="#extraPrimitiveOverestimationSize"
/// } VkPipelineRasterizationConservativeStateCreateInfoEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PIPELINE_RASTERIZATION_CONSERVATIVE_STATE_CREATE_INFO_EXT`
///
/// The {@code allocate} ({@link VkPipelineRasterizationConservativeStateCreateInfoEXT#allocate(Arena)}, {@link VkPipelineRasterizationConservativeStateCreateInfoEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPipelineRasterizationConservativeStateCreateInfoEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineRasterizationConservativeStateCreateInfoEXT.html"><code>VkPipelineRasterizationConservativeStateCreateInfoEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPipelineRasterizationConservativeStateCreateInfoEXT(@NotNull MemorySegment segment) implements IVkPipelineRasterizationConservativeStateCreateInfoEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineRasterizationConservativeStateCreateInfoEXT.html"><code>VkPipelineRasterizationConservativeStateCreateInfoEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPipelineRasterizationConservativeStateCreateInfoEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPipelineRasterizationConservativeStateCreateInfoEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPipelineRasterizationConservativeStateCreateInfoEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPipelineRasterizationConservativeStateCreateInfoEXT, Iterable<VkPipelineRasterizationConservativeStateCreateInfoEXT> {
        public long size() {
            return segment.byteSize() / VkPipelineRasterizationConservativeStateCreateInfoEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPipelineRasterizationConservativeStateCreateInfoEXT at(long index) {
            return new VkPipelineRasterizationConservativeStateCreateInfoEXT(segment.asSlice(index * VkPipelineRasterizationConservativeStateCreateInfoEXT.BYTES, VkPipelineRasterizationConservativeStateCreateInfoEXT.BYTES));
        }

        public VkPipelineRasterizationConservativeStateCreateInfoEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkPipelineRasterizationConservativeStateCreateInfoEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPipelineRasterizationConservativeStateCreateInfoEXT value) {
            MemorySegment s = segment.asSlice(index * VkPipelineRasterizationConservativeStateCreateInfoEXT.BYTES, VkPipelineRasterizationConservativeStateCreateInfoEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPipelineRasterizationConservativeStateCreateInfoEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPipelineRasterizationConservativeStateCreateInfoEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPipelineRasterizationConservativeStateCreateInfoEXT.BYTES,
                (end - start) * VkPipelineRasterizationConservativeStateCreateInfoEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPipelineRasterizationConservativeStateCreateInfoEXT.BYTES));
        }

        public VkPipelineRasterizationConservativeStateCreateInfoEXT[] toArray() {
            VkPipelineRasterizationConservativeStateCreateInfoEXT[] ret = new VkPipelineRasterizationConservativeStateCreateInfoEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPipelineRasterizationConservativeStateCreateInfoEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPipelineRasterizationConservativeStateCreateInfoEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPipelineRasterizationConservativeStateCreateInfoEXT.BYTES;
            }

            @Override
            public VkPipelineRasterizationConservativeStateCreateInfoEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPipelineRasterizationConservativeStateCreateInfoEXT ret = new VkPipelineRasterizationConservativeStateCreateInfoEXT(segment.asSlice(0, VkPipelineRasterizationConservativeStateCreateInfoEXT.BYTES));
                segment = segment.asSlice(VkPipelineRasterizationConservativeStateCreateInfoEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPipelineRasterizationConservativeStateCreateInfoEXT allocate(Arena arena) {
        VkPipelineRasterizationConservativeStateCreateInfoEXT ret = new VkPipelineRasterizationConservativeStateCreateInfoEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PIPELINE_RASTERIZATION_CONSERVATIVE_STATE_CREATE_INFO_EXT);
        return ret;
    }

    public static VkPipelineRasterizationConservativeStateCreateInfoEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPipelineRasterizationConservativeStateCreateInfoEXT.Ptr ret = new VkPipelineRasterizationConservativeStateCreateInfoEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PIPELINE_RASTERIZATION_CONSERVATIVE_STATE_CREATE_INFO_EXT);
        }
        return ret;
    }

    public static VkPipelineRasterizationConservativeStateCreateInfoEXT clone(Arena arena, VkPipelineRasterizationConservativeStateCreateInfoEXT src) {
        VkPipelineRasterizationConservativeStateCreateInfoEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PIPELINE_RASTERIZATION_CONSERVATIVE_STATE_CREATE_INFO_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPipelineRasterizationConservativeStateCreateInfoEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPipelineRasterizationConservativeStateCreateInfoEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPipelineRasterizationConservativeStateCreateInfoEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkPipelineRasterizationConservativeStateCreateFlagsEXT.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkPipelineRasterizationConservativeStateCreateInfoEXT flags(@Bitmask(VkPipelineRasterizationConservativeStateCreateFlagsEXT.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @EnumType(VkConservativeRasterizationModeEXT.class) int conservativeRasterizationMode() {
        return segment.get(LAYOUT$conservativeRasterizationMode, OFFSET$conservativeRasterizationMode);
    }

    public VkPipelineRasterizationConservativeStateCreateInfoEXT conservativeRasterizationMode(@EnumType(VkConservativeRasterizationModeEXT.class) int value) {
        segment.set(LAYOUT$conservativeRasterizationMode, OFFSET$conservativeRasterizationMode, value);
        return this;
    }

    public float extraPrimitiveOverestimationSize() {
        return segment.get(LAYOUT$extraPrimitiveOverestimationSize, OFFSET$extraPrimitiveOverestimationSize);
    }

    public VkPipelineRasterizationConservativeStateCreateInfoEXT extraPrimitiveOverestimationSize(float value) {
        segment.set(LAYOUT$extraPrimitiveOverestimationSize, OFFSET$extraPrimitiveOverestimationSize, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("conservativeRasterizationMode"),
        ValueLayout.JAVA_FLOAT.withName("extraPrimitiveOverestimationSize")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$conservativeRasterizationMode = PathElement.groupElement("conservativeRasterizationMode");
    public static final PathElement PATH$extraPrimitiveOverestimationSize = PathElement.groupElement("extraPrimitiveOverestimationSize");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$conservativeRasterizationMode = (OfInt) LAYOUT.select(PATH$conservativeRasterizationMode);
    public static final OfFloat LAYOUT$extraPrimitiveOverestimationSize = (OfFloat) LAYOUT.select(PATH$extraPrimitiveOverestimationSize);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$conservativeRasterizationMode = LAYOUT$conservativeRasterizationMode.byteSize();
    public static final long SIZE$extraPrimitiveOverestimationSize = LAYOUT$extraPrimitiveOverestimationSize.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$conservativeRasterizationMode = LAYOUT.byteOffset(PATH$conservativeRasterizationMode);
    public static final long OFFSET$extraPrimitiveOverestimationSize = LAYOUT.byteOffset(PATH$extraPrimitiveOverestimationSize);
}
