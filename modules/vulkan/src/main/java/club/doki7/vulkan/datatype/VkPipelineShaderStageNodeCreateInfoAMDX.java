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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineShaderStageNodeCreateInfoAMDX.html"><code>VkPipelineShaderStageNodeCreateInfoAMDX</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPipelineShaderStageNodeCreateInfoAMDX {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     char const* pName; // optional // @link substring="pName" target="#pName"
///     uint32_t index; // @link substring="index" target="#index"
/// } VkPipelineShaderStageNodeCreateInfoAMDX;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PIPELINE_SHADER_STAGE_NODE_CREATE_INFO_AMDX`
///
/// The {@code allocate} ({@link VkPipelineShaderStageNodeCreateInfoAMDX#allocate(Arena)}, {@link VkPipelineShaderStageNodeCreateInfoAMDX#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPipelineShaderStageNodeCreateInfoAMDX#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineShaderStageNodeCreateInfoAMDX.html"><code>VkPipelineShaderStageNodeCreateInfoAMDX</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPipelineShaderStageNodeCreateInfoAMDX(@NotNull MemorySegment segment) implements IVkPipelineShaderStageNodeCreateInfoAMDX {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineShaderStageNodeCreateInfoAMDX.html"><code>VkPipelineShaderStageNodeCreateInfoAMDX</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPipelineShaderStageNodeCreateInfoAMDX}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPipelineShaderStageNodeCreateInfoAMDX to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPipelineShaderStageNodeCreateInfoAMDX.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPipelineShaderStageNodeCreateInfoAMDX, Iterable<VkPipelineShaderStageNodeCreateInfoAMDX> {
        public long size() {
            return segment.byteSize() / VkPipelineShaderStageNodeCreateInfoAMDX.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPipelineShaderStageNodeCreateInfoAMDX at(long index) {
            return new VkPipelineShaderStageNodeCreateInfoAMDX(segment.asSlice(index * VkPipelineShaderStageNodeCreateInfoAMDX.BYTES, VkPipelineShaderStageNodeCreateInfoAMDX.BYTES));
        }

        public VkPipelineShaderStageNodeCreateInfoAMDX.Ptr at(long index, @NotNull Consumer<@NotNull VkPipelineShaderStageNodeCreateInfoAMDX> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPipelineShaderStageNodeCreateInfoAMDX value) {
            MemorySegment s = segment.asSlice(index * VkPipelineShaderStageNodeCreateInfoAMDX.BYTES, VkPipelineShaderStageNodeCreateInfoAMDX.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPipelineShaderStageNodeCreateInfoAMDX.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPipelineShaderStageNodeCreateInfoAMDX.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPipelineShaderStageNodeCreateInfoAMDX.BYTES,
                (end - start) * VkPipelineShaderStageNodeCreateInfoAMDX.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPipelineShaderStageNodeCreateInfoAMDX.BYTES));
        }

        public VkPipelineShaderStageNodeCreateInfoAMDX[] toArray() {
            VkPipelineShaderStageNodeCreateInfoAMDX[] ret = new VkPipelineShaderStageNodeCreateInfoAMDX[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPipelineShaderStageNodeCreateInfoAMDX> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPipelineShaderStageNodeCreateInfoAMDX> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPipelineShaderStageNodeCreateInfoAMDX.BYTES;
            }

            @Override
            public VkPipelineShaderStageNodeCreateInfoAMDX next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPipelineShaderStageNodeCreateInfoAMDX ret = new VkPipelineShaderStageNodeCreateInfoAMDX(segment.asSlice(0, VkPipelineShaderStageNodeCreateInfoAMDX.BYTES));
                segment = segment.asSlice(VkPipelineShaderStageNodeCreateInfoAMDX.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPipelineShaderStageNodeCreateInfoAMDX allocate(Arena arena) {
        VkPipelineShaderStageNodeCreateInfoAMDX ret = new VkPipelineShaderStageNodeCreateInfoAMDX(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PIPELINE_SHADER_STAGE_NODE_CREATE_INFO_AMDX);
        return ret;
    }

    public static VkPipelineShaderStageNodeCreateInfoAMDX.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPipelineShaderStageNodeCreateInfoAMDX.Ptr ret = new VkPipelineShaderStageNodeCreateInfoAMDX.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PIPELINE_SHADER_STAGE_NODE_CREATE_INFO_AMDX);
        }
        return ret;
    }

    public static VkPipelineShaderStageNodeCreateInfoAMDX clone(Arena arena, VkPipelineShaderStageNodeCreateInfoAMDX src) {
        VkPipelineShaderStageNodeCreateInfoAMDX ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PIPELINE_SHADER_STAGE_NODE_CREATE_INFO_AMDX);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPipelineShaderStageNodeCreateInfoAMDX sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPipelineShaderStageNodeCreateInfoAMDX pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPipelineShaderStageNodeCreateInfoAMDX pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    /// Note: the returned {@link BytePtr} does not have correct
    /// {@link BytePtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link BytePtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable BytePtr pName() {
        MemorySegment s = pNameRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new BytePtr(s);
    }

    public VkPipelineShaderStageNodeCreateInfoAMDX pName(@Nullable BytePtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pNameRaw(s);
        return this;
    }

    public @Pointer(comment="int8_t*") @NotNull MemorySegment pNameRaw() {
        return segment.get(LAYOUT$pName, OFFSET$pName);
    }

    public void pNameRaw(@Pointer(comment="int8_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pName, OFFSET$pName, value);
    }

    public @Unsigned int index() {
        return segment.get(LAYOUT$index, OFFSET$index);
    }

    public VkPipelineShaderStageNodeCreateInfoAMDX index(@Unsigned int value) {
        segment.set(LAYOUT$index, OFFSET$index, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE).withName("pName"),
        ValueLayout.JAVA_INT.withName("index")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$pName = PathElement.groupElement("pName");
    public static final PathElement PATH$index = PathElement.groupElement("index");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$pName = (AddressLayout) LAYOUT.select(PATH$pName);
    public static final OfInt LAYOUT$index = (OfInt) LAYOUT.select(PATH$index);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$pName = LAYOUT$pName.byteSize();
    public static final long SIZE$index = LAYOUT$index.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$pName = LAYOUT.byteOffset(PATH$pName);
    public static final long OFFSET$index = LAYOUT.byteOffset(PATH$index);
}
