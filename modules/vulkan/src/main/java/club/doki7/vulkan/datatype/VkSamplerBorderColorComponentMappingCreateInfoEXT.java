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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSamplerBorderColorComponentMappingCreateInfoEXT.html"><code>VkSamplerBorderColorComponentMappingCreateInfoEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkSamplerBorderColorComponentMappingCreateInfoEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkComponentMapping components; // @link substring="VkComponentMapping" target="VkComponentMapping" @link substring="components" target="#components"
///     VkBool32 srgb; // @link substring="srgb" target="#srgb"
/// } VkSamplerBorderColorComponentMappingCreateInfoEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_SAMPLER_BORDER_COLOR_COMPONENT_MAPPING_CREATE_INFO_EXT`
///
/// The {@code allocate} ({@link VkSamplerBorderColorComponentMappingCreateInfoEXT#allocate(Arena)}, {@link VkSamplerBorderColorComponentMappingCreateInfoEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkSamplerBorderColorComponentMappingCreateInfoEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSamplerBorderColorComponentMappingCreateInfoEXT.html"><code>VkSamplerBorderColorComponentMappingCreateInfoEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkSamplerBorderColorComponentMappingCreateInfoEXT(@NotNull MemorySegment segment) implements IVkSamplerBorderColorComponentMappingCreateInfoEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSamplerBorderColorComponentMappingCreateInfoEXT.html"><code>VkSamplerBorderColorComponentMappingCreateInfoEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkSamplerBorderColorComponentMappingCreateInfoEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkSamplerBorderColorComponentMappingCreateInfoEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkSamplerBorderColorComponentMappingCreateInfoEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkSamplerBorderColorComponentMappingCreateInfoEXT, Iterable<VkSamplerBorderColorComponentMappingCreateInfoEXT> {
        public long size() {
            return segment.byteSize() / VkSamplerBorderColorComponentMappingCreateInfoEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkSamplerBorderColorComponentMappingCreateInfoEXT at(long index) {
            return new VkSamplerBorderColorComponentMappingCreateInfoEXT(segment.asSlice(index * VkSamplerBorderColorComponentMappingCreateInfoEXT.BYTES, VkSamplerBorderColorComponentMappingCreateInfoEXT.BYTES));
        }

        public VkSamplerBorderColorComponentMappingCreateInfoEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkSamplerBorderColorComponentMappingCreateInfoEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkSamplerBorderColorComponentMappingCreateInfoEXT value) {
            MemorySegment s = segment.asSlice(index * VkSamplerBorderColorComponentMappingCreateInfoEXT.BYTES, VkSamplerBorderColorComponentMappingCreateInfoEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkSamplerBorderColorComponentMappingCreateInfoEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkSamplerBorderColorComponentMappingCreateInfoEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkSamplerBorderColorComponentMappingCreateInfoEXT.BYTES,
                (end - start) * VkSamplerBorderColorComponentMappingCreateInfoEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkSamplerBorderColorComponentMappingCreateInfoEXT.BYTES));
        }

        public VkSamplerBorderColorComponentMappingCreateInfoEXT[] toArray() {
            VkSamplerBorderColorComponentMappingCreateInfoEXT[] ret = new VkSamplerBorderColorComponentMappingCreateInfoEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkSamplerBorderColorComponentMappingCreateInfoEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkSamplerBorderColorComponentMappingCreateInfoEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkSamplerBorderColorComponentMappingCreateInfoEXT.BYTES;
            }

            @Override
            public VkSamplerBorderColorComponentMappingCreateInfoEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkSamplerBorderColorComponentMappingCreateInfoEXT ret = new VkSamplerBorderColorComponentMappingCreateInfoEXT(segment.asSlice(0, VkSamplerBorderColorComponentMappingCreateInfoEXT.BYTES));
                segment = segment.asSlice(VkSamplerBorderColorComponentMappingCreateInfoEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkSamplerBorderColorComponentMappingCreateInfoEXT allocate(Arena arena) {
        VkSamplerBorderColorComponentMappingCreateInfoEXT ret = new VkSamplerBorderColorComponentMappingCreateInfoEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.SAMPLER_BORDER_COLOR_COMPONENT_MAPPING_CREATE_INFO_EXT);
        return ret;
    }

    public static VkSamplerBorderColorComponentMappingCreateInfoEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkSamplerBorderColorComponentMappingCreateInfoEXT.Ptr ret = new VkSamplerBorderColorComponentMappingCreateInfoEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.SAMPLER_BORDER_COLOR_COMPONENT_MAPPING_CREATE_INFO_EXT);
        }
        return ret;
    }

    public static VkSamplerBorderColorComponentMappingCreateInfoEXT clone(Arena arena, VkSamplerBorderColorComponentMappingCreateInfoEXT src) {
        VkSamplerBorderColorComponentMappingCreateInfoEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.SAMPLER_BORDER_COLOR_COMPONENT_MAPPING_CREATE_INFO_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkSamplerBorderColorComponentMappingCreateInfoEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkSamplerBorderColorComponentMappingCreateInfoEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkSamplerBorderColorComponentMappingCreateInfoEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NotNull VkComponentMapping components() {
        return new VkComponentMapping(segment.asSlice(OFFSET$components, LAYOUT$components));
    }

    public VkSamplerBorderColorComponentMappingCreateInfoEXT components(@NotNull VkComponentMapping value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$components, SIZE$components);
        return this;
    }

    public VkSamplerBorderColorComponentMappingCreateInfoEXT components(Consumer<@NotNull VkComponentMapping> consumer) {
        consumer.accept(components());
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int srgb() {
        return segment.get(LAYOUT$srgb, OFFSET$srgb);
    }

    public VkSamplerBorderColorComponentMappingCreateInfoEXT srgb(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$srgb, OFFSET$srgb, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        VkComponentMapping.LAYOUT.withName("components"),
        ValueLayout.JAVA_INT.withName("srgb")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$components = PathElement.groupElement("components");
    public static final PathElement PATH$srgb = PathElement.groupElement("srgb");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final StructLayout LAYOUT$components = (StructLayout) LAYOUT.select(PATH$components);
    public static final OfInt LAYOUT$srgb = (OfInt) LAYOUT.select(PATH$srgb);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$components = LAYOUT$components.byteSize();
    public static final long SIZE$srgb = LAYOUT$srgb.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$components = LAYOUT.byteOffset(PATH$components);
    public static final long OFFSET$srgb = LAYOUT.byteOffset(PATH$srgb);
}
