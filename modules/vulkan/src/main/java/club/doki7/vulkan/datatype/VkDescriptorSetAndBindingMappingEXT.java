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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDescriptorSetAndBindingMappingEXT.html"><code>VkDescriptorSetAndBindingMappingEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDescriptorSetAndBindingMappingEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t descriptorSet; // @link substring="descriptorSet" target="#descriptorSet"
///     uint32_t firstBinding; // @link substring="firstBinding" target="#firstBinding"
///     uint32_t bindingCount; // @link substring="bindingCount" target="#bindingCount"
///     VkSpirvResourceTypeFlagsEXT resourceMask; // @link substring="VkSpirvResourceTypeFlagsEXT" target="VkSpirvResourceTypeFlagsEXT" @link substring="resourceMask" target="#resourceMask"
///     VkDescriptorMappingSourceEXT source; // @link substring="VkDescriptorMappingSourceEXT" target="VkDescriptorMappingSourceEXT" @link substring="source" target="#source"
///     VkDescriptorMappingSourceDataEXT sourceData; // @link substring="VkDescriptorMappingSourceDataEXT" target="VkDescriptorMappingSourceDataEXT" @link substring="sourceData" target="#sourceData"
/// } VkDescriptorSetAndBindingMappingEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_DESCRIPTOR_SET_AND_BINDING_MAPPING_EXT`
///
/// The {@code allocate} ({@link VkDescriptorSetAndBindingMappingEXT#allocate(Arena)}, {@link VkDescriptorSetAndBindingMappingEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkDescriptorSetAndBindingMappingEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDescriptorSetAndBindingMappingEXT.html"><code>VkDescriptorSetAndBindingMappingEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDescriptorSetAndBindingMappingEXT(@NotNull MemorySegment segment) implements IVkDescriptorSetAndBindingMappingEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDescriptorSetAndBindingMappingEXT.html"><code>VkDescriptorSetAndBindingMappingEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDescriptorSetAndBindingMappingEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDescriptorSetAndBindingMappingEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDescriptorSetAndBindingMappingEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDescriptorSetAndBindingMappingEXT, Iterable<VkDescriptorSetAndBindingMappingEXT> {
        public long size() {
            return segment.byteSize() / VkDescriptorSetAndBindingMappingEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDescriptorSetAndBindingMappingEXT at(long index) {
            return new VkDescriptorSetAndBindingMappingEXT(segment.asSlice(index * VkDescriptorSetAndBindingMappingEXT.BYTES, VkDescriptorSetAndBindingMappingEXT.BYTES));
        }

        public VkDescriptorSetAndBindingMappingEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkDescriptorSetAndBindingMappingEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDescriptorSetAndBindingMappingEXT value) {
            MemorySegment s = segment.asSlice(index * VkDescriptorSetAndBindingMappingEXT.BYTES, VkDescriptorSetAndBindingMappingEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDescriptorSetAndBindingMappingEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDescriptorSetAndBindingMappingEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDescriptorSetAndBindingMappingEXT.BYTES,
                (end - start) * VkDescriptorSetAndBindingMappingEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDescriptorSetAndBindingMappingEXT.BYTES));
        }

        public VkDescriptorSetAndBindingMappingEXT[] toArray() {
            VkDescriptorSetAndBindingMappingEXT[] ret = new VkDescriptorSetAndBindingMappingEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDescriptorSetAndBindingMappingEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDescriptorSetAndBindingMappingEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDescriptorSetAndBindingMappingEXT.BYTES;
            }

            @Override
            public VkDescriptorSetAndBindingMappingEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDescriptorSetAndBindingMappingEXT ret = new VkDescriptorSetAndBindingMappingEXT(segment.asSlice(0, VkDescriptorSetAndBindingMappingEXT.BYTES));
                segment = segment.asSlice(VkDescriptorSetAndBindingMappingEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDescriptorSetAndBindingMappingEXT allocate(Arena arena) {
        VkDescriptorSetAndBindingMappingEXT ret = new VkDescriptorSetAndBindingMappingEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.DESCRIPTOR_SET_AND_BINDING_MAPPING_EXT);
        return ret;
    }

    public static VkDescriptorSetAndBindingMappingEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkDescriptorSetAndBindingMappingEXT.Ptr ret = new VkDescriptorSetAndBindingMappingEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.DESCRIPTOR_SET_AND_BINDING_MAPPING_EXT);
        }
        return ret;
    }

    public static VkDescriptorSetAndBindingMappingEXT clone(Arena arena, VkDescriptorSetAndBindingMappingEXT src) {
        VkDescriptorSetAndBindingMappingEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.DESCRIPTOR_SET_AND_BINDING_MAPPING_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkDescriptorSetAndBindingMappingEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkDescriptorSetAndBindingMappingEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkDescriptorSetAndBindingMappingEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int descriptorSet() {
        return segment.get(LAYOUT$descriptorSet, OFFSET$descriptorSet);
    }

    public VkDescriptorSetAndBindingMappingEXT descriptorSet(@Unsigned int value) {
        segment.set(LAYOUT$descriptorSet, OFFSET$descriptorSet, value);
        return this;
    }

    public @Unsigned int firstBinding() {
        return segment.get(LAYOUT$firstBinding, OFFSET$firstBinding);
    }

    public VkDescriptorSetAndBindingMappingEXT firstBinding(@Unsigned int value) {
        segment.set(LAYOUT$firstBinding, OFFSET$firstBinding, value);
        return this;
    }

    public @Unsigned int bindingCount() {
        return segment.get(LAYOUT$bindingCount, OFFSET$bindingCount);
    }

    public VkDescriptorSetAndBindingMappingEXT bindingCount(@Unsigned int value) {
        segment.set(LAYOUT$bindingCount, OFFSET$bindingCount, value);
        return this;
    }

    public @Bitmask(VkSpirvResourceTypeFlagsEXT.class) int resourceMask() {
        return segment.get(LAYOUT$resourceMask, OFFSET$resourceMask);
    }

    public VkDescriptorSetAndBindingMappingEXT resourceMask(@Bitmask(VkSpirvResourceTypeFlagsEXT.class) int value) {
        segment.set(LAYOUT$resourceMask, OFFSET$resourceMask, value);
        return this;
    }

    public @EnumType(VkDescriptorMappingSourceEXT.class) int source() {
        return segment.get(LAYOUT$source, OFFSET$source);
    }

    public VkDescriptorSetAndBindingMappingEXT source(@EnumType(VkDescriptorMappingSourceEXT.class) int value) {
        segment.set(LAYOUT$source, OFFSET$source, value);
        return this;
    }

    public @NotNull VkDescriptorMappingSourceDataEXT sourceData() {
        return new VkDescriptorMappingSourceDataEXT(segment.asSlice(OFFSET$sourceData, LAYOUT$sourceData));
    }

    public VkDescriptorSetAndBindingMappingEXT sourceData(@NotNull VkDescriptorMappingSourceDataEXT value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$sourceData, SIZE$sourceData);
        return this;
    }

    public VkDescriptorSetAndBindingMappingEXT sourceData(Consumer<@NotNull VkDescriptorMappingSourceDataEXT> consumer) {
        consumer.accept(sourceData());
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("descriptorSet"),
        ValueLayout.JAVA_INT.withName("firstBinding"),
        ValueLayout.JAVA_INT.withName("bindingCount"),
        ValueLayout.JAVA_INT.withName("resourceMask"),
        ValueLayout.JAVA_INT.withName("source"),
        VkDescriptorMappingSourceDataEXT.LAYOUT.withName("sourceData")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$descriptorSet = PathElement.groupElement("descriptorSet");
    public static final PathElement PATH$firstBinding = PathElement.groupElement("firstBinding");
    public static final PathElement PATH$bindingCount = PathElement.groupElement("bindingCount");
    public static final PathElement PATH$resourceMask = PathElement.groupElement("resourceMask");
    public static final PathElement PATH$source = PathElement.groupElement("source");
    public static final PathElement PATH$sourceData = PathElement.groupElement("sourceData");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$descriptorSet = (OfInt) LAYOUT.select(PATH$descriptorSet);
    public static final OfInt LAYOUT$firstBinding = (OfInt) LAYOUT.select(PATH$firstBinding);
    public static final OfInt LAYOUT$bindingCount = (OfInt) LAYOUT.select(PATH$bindingCount);
    public static final OfInt LAYOUT$resourceMask = (OfInt) LAYOUT.select(PATH$resourceMask);
    public static final OfInt LAYOUT$source = (OfInt) LAYOUT.select(PATH$source);
    public static final UnionLayout LAYOUT$sourceData = (UnionLayout) LAYOUT.select(PATH$sourceData);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$descriptorSet = LAYOUT$descriptorSet.byteSize();
    public static final long SIZE$firstBinding = LAYOUT$firstBinding.byteSize();
    public static final long SIZE$bindingCount = LAYOUT$bindingCount.byteSize();
    public static final long SIZE$resourceMask = LAYOUT$resourceMask.byteSize();
    public static final long SIZE$source = LAYOUT$source.byteSize();
    public static final long SIZE$sourceData = LAYOUT$sourceData.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$descriptorSet = LAYOUT.byteOffset(PATH$descriptorSet);
    public static final long OFFSET$firstBinding = LAYOUT.byteOffset(PATH$firstBinding);
    public static final long OFFSET$bindingCount = LAYOUT.byteOffset(PATH$bindingCount);
    public static final long OFFSET$resourceMask = LAYOUT.byteOffset(PATH$resourceMask);
    public static final long OFFSET$source = LAYOUT.byteOffset(PATH$source);
    public static final long OFFSET$sourceData = LAYOUT.byteOffset(PATH$sourceData);
}
