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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGeneratedCommandsShaderInfoEXT.html"><code>VkGeneratedCommandsShaderInfoEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkGeneratedCommandsShaderInfoEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t shaderCount; // @link substring="shaderCount" target="#shaderCount"
///     VkShaderEXT const* pShaders; // @link substring="VkShaderEXT" target="VkShaderEXT" @link substring="pShaders" target="#pShaders"
/// } VkGeneratedCommandsShaderInfoEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_GENERATED_COMMANDS_SHADER_INFO_EXT`
///
/// The {@code allocate} ({@link VkGeneratedCommandsShaderInfoEXT#allocate(Arena)}, {@link VkGeneratedCommandsShaderInfoEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkGeneratedCommandsShaderInfoEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGeneratedCommandsShaderInfoEXT.html"><code>VkGeneratedCommandsShaderInfoEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkGeneratedCommandsShaderInfoEXT(@NotNull MemorySegment segment) implements IVkGeneratedCommandsShaderInfoEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGeneratedCommandsShaderInfoEXT.html"><code>VkGeneratedCommandsShaderInfoEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkGeneratedCommandsShaderInfoEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkGeneratedCommandsShaderInfoEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkGeneratedCommandsShaderInfoEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkGeneratedCommandsShaderInfoEXT, Iterable<VkGeneratedCommandsShaderInfoEXT> {
        public long size() {
            return segment.byteSize() / VkGeneratedCommandsShaderInfoEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkGeneratedCommandsShaderInfoEXT at(long index) {
            return new VkGeneratedCommandsShaderInfoEXT(segment.asSlice(index * VkGeneratedCommandsShaderInfoEXT.BYTES, VkGeneratedCommandsShaderInfoEXT.BYTES));
        }

        public VkGeneratedCommandsShaderInfoEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkGeneratedCommandsShaderInfoEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkGeneratedCommandsShaderInfoEXT value) {
            MemorySegment s = segment.asSlice(index * VkGeneratedCommandsShaderInfoEXT.BYTES, VkGeneratedCommandsShaderInfoEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkGeneratedCommandsShaderInfoEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkGeneratedCommandsShaderInfoEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkGeneratedCommandsShaderInfoEXT.BYTES,
                (end - start) * VkGeneratedCommandsShaderInfoEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkGeneratedCommandsShaderInfoEXT.BYTES));
        }

        public VkGeneratedCommandsShaderInfoEXT[] toArray() {
            VkGeneratedCommandsShaderInfoEXT[] ret = new VkGeneratedCommandsShaderInfoEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkGeneratedCommandsShaderInfoEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkGeneratedCommandsShaderInfoEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkGeneratedCommandsShaderInfoEXT.BYTES;
            }

            @Override
            public VkGeneratedCommandsShaderInfoEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkGeneratedCommandsShaderInfoEXT ret = new VkGeneratedCommandsShaderInfoEXT(segment.asSlice(0, VkGeneratedCommandsShaderInfoEXT.BYTES));
                segment = segment.asSlice(VkGeneratedCommandsShaderInfoEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkGeneratedCommandsShaderInfoEXT allocate(Arena arena) {
        VkGeneratedCommandsShaderInfoEXT ret = new VkGeneratedCommandsShaderInfoEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.GENERATED_COMMANDS_SHADER_INFO_EXT);
        return ret;
    }

    public static VkGeneratedCommandsShaderInfoEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkGeneratedCommandsShaderInfoEXT.Ptr ret = new VkGeneratedCommandsShaderInfoEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.GENERATED_COMMANDS_SHADER_INFO_EXT);
        }
        return ret;
    }

    public static VkGeneratedCommandsShaderInfoEXT clone(Arena arena, VkGeneratedCommandsShaderInfoEXT src) {
        VkGeneratedCommandsShaderInfoEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.GENERATED_COMMANDS_SHADER_INFO_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkGeneratedCommandsShaderInfoEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkGeneratedCommandsShaderInfoEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkGeneratedCommandsShaderInfoEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int shaderCount() {
        return segment.get(LAYOUT$shaderCount, OFFSET$shaderCount);
    }

    public VkGeneratedCommandsShaderInfoEXT shaderCount(@Unsigned int value) {
        segment.set(LAYOUT$shaderCount, OFFSET$shaderCount, value);
        return this;
    }

    /// Note: the returned {@link VkShaderEXT.Ptr} does not have correct {@link VkShaderEXT.Ptr#size}
    /// property. It's up to user to track the size of the buffer, and use
    /// {@link VkShaderEXT.Ptr#reinterpret} to set the size before actually reading from or writing to the
    /// buffer.
    public @Nullable VkShaderEXT.Ptr pShaders() {
        MemorySegment s = pShadersRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkShaderEXT.Ptr(s);
    }

    public VkGeneratedCommandsShaderInfoEXT pShaders(@Nullable VkShaderEXT.Ptr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pShadersRaw(s);
        return this;
    }

    public @Pointer(target=VkShaderEXT.class) @NotNull MemorySegment pShadersRaw() {
        return segment.get(LAYOUT$pShaders, OFFSET$pShaders);
    }

    public void pShadersRaw(@Pointer(target=VkShaderEXT.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pShaders, OFFSET$pShaders, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("shaderCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS).withName("pShaders")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$shaderCount = PathElement.groupElement("shaderCount");
    public static final PathElement PATH$pShaders = PathElement.groupElement("pShaders");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$shaderCount = (OfInt) LAYOUT.select(PATH$shaderCount);
    public static final AddressLayout LAYOUT$pShaders = (AddressLayout) LAYOUT.select(PATH$pShaders);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$shaderCount = LAYOUT$shaderCount.byteSize();
    public static final long SIZE$pShaders = LAYOUT$pShaders.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$shaderCount = LAYOUT.byteOffset(PATH$shaderCount);
    public static final long OFFSET$pShaders = LAYOUT.byteOffset(PATH$pShaders);
}
