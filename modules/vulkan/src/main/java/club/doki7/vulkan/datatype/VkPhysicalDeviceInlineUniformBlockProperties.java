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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceInlineUniformBlockProperties.html"><code>VkPhysicalDeviceInlineUniformBlockProperties</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceInlineUniformBlockProperties {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t maxInlineUniformBlockSize; // @link substring="maxInlineUniformBlockSize" target="#maxInlineUniformBlockSize"
///     uint32_t maxPerStageDescriptorInlineUniformBlocks; // @link substring="maxPerStageDescriptorInlineUniformBlocks" target="#maxPerStageDescriptorInlineUniformBlocks"
///     uint32_t maxPerStageDescriptorUpdateAfterBindInlineUniformBlocks; // @link substring="maxPerStageDescriptorUpdateAfterBindInlineUniformBlocks" target="#maxPerStageDescriptorUpdateAfterBindInlineUniformBlocks"
///     uint32_t maxDescriptorSetInlineUniformBlocks; // @link substring="maxDescriptorSetInlineUniformBlocks" target="#maxDescriptorSetInlineUniformBlocks"
///     uint32_t maxDescriptorSetUpdateAfterBindInlineUniformBlocks; // @link substring="maxDescriptorSetUpdateAfterBindInlineUniformBlocks" target="#maxDescriptorSetUpdateAfterBindInlineUniformBlocks"
/// } VkPhysicalDeviceInlineUniformBlockProperties;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_INLINE_UNIFORM_BLOCK_PROPERTIES`
///
/// The {@code allocate} ({@link VkPhysicalDeviceInlineUniformBlockProperties#allocate(Arena)}, {@link VkPhysicalDeviceInlineUniformBlockProperties#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceInlineUniformBlockProperties#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceInlineUniformBlockProperties.html"><code>VkPhysicalDeviceInlineUniformBlockProperties</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceInlineUniformBlockProperties(@NotNull MemorySegment segment) implements IVkPhysicalDeviceInlineUniformBlockProperties {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceInlineUniformBlockProperties.html"><code>VkPhysicalDeviceInlineUniformBlockProperties</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceInlineUniformBlockProperties}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceInlineUniformBlockProperties to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceInlineUniformBlockProperties.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceInlineUniformBlockProperties, Iterable<VkPhysicalDeviceInlineUniformBlockProperties> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceInlineUniformBlockProperties.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceInlineUniformBlockProperties at(long index) {
            return new VkPhysicalDeviceInlineUniformBlockProperties(segment.asSlice(index * VkPhysicalDeviceInlineUniformBlockProperties.BYTES, VkPhysicalDeviceInlineUniformBlockProperties.BYTES));
        }

        public VkPhysicalDeviceInlineUniformBlockProperties.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceInlineUniformBlockProperties> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceInlineUniformBlockProperties value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceInlineUniformBlockProperties.BYTES, VkPhysicalDeviceInlineUniformBlockProperties.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceInlineUniformBlockProperties.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceInlineUniformBlockProperties.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceInlineUniformBlockProperties.BYTES,
                (end - start) * VkPhysicalDeviceInlineUniformBlockProperties.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceInlineUniformBlockProperties.BYTES));
        }

        public VkPhysicalDeviceInlineUniformBlockProperties[] toArray() {
            VkPhysicalDeviceInlineUniformBlockProperties[] ret = new VkPhysicalDeviceInlineUniformBlockProperties[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceInlineUniformBlockProperties> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceInlineUniformBlockProperties> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceInlineUniformBlockProperties.BYTES;
            }

            @Override
            public VkPhysicalDeviceInlineUniformBlockProperties next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceInlineUniformBlockProperties ret = new VkPhysicalDeviceInlineUniformBlockProperties(segment.asSlice(0, VkPhysicalDeviceInlineUniformBlockProperties.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceInlineUniformBlockProperties.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceInlineUniformBlockProperties allocate(Arena arena) {
        VkPhysicalDeviceInlineUniformBlockProperties ret = new VkPhysicalDeviceInlineUniformBlockProperties(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_INLINE_UNIFORM_BLOCK_PROPERTIES);
        return ret;
    }

    public static VkPhysicalDeviceInlineUniformBlockProperties.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceInlineUniformBlockProperties.Ptr ret = new VkPhysicalDeviceInlineUniformBlockProperties.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_INLINE_UNIFORM_BLOCK_PROPERTIES);
        }
        return ret;
    }

    public static VkPhysicalDeviceInlineUniformBlockProperties clone(Arena arena, VkPhysicalDeviceInlineUniformBlockProperties src) {
        VkPhysicalDeviceInlineUniformBlockProperties ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_INLINE_UNIFORM_BLOCK_PROPERTIES);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceInlineUniformBlockProperties sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceInlineUniformBlockProperties pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceInlineUniformBlockProperties pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int maxInlineUniformBlockSize() {
        return segment.get(LAYOUT$maxInlineUniformBlockSize, OFFSET$maxInlineUniformBlockSize);
    }

    public VkPhysicalDeviceInlineUniformBlockProperties maxInlineUniformBlockSize(@Unsigned int value) {
        segment.set(LAYOUT$maxInlineUniformBlockSize, OFFSET$maxInlineUniformBlockSize, value);
        return this;
    }

    public @Unsigned int maxPerStageDescriptorInlineUniformBlocks() {
        return segment.get(LAYOUT$maxPerStageDescriptorInlineUniformBlocks, OFFSET$maxPerStageDescriptorInlineUniformBlocks);
    }

    public VkPhysicalDeviceInlineUniformBlockProperties maxPerStageDescriptorInlineUniformBlocks(@Unsigned int value) {
        segment.set(LAYOUT$maxPerStageDescriptorInlineUniformBlocks, OFFSET$maxPerStageDescriptorInlineUniformBlocks, value);
        return this;
    }

    public @Unsigned int maxPerStageDescriptorUpdateAfterBindInlineUniformBlocks() {
        return segment.get(LAYOUT$maxPerStageDescriptorUpdateAfterBindInlineUniformBlocks, OFFSET$maxPerStageDescriptorUpdateAfterBindInlineUniformBlocks);
    }

    public VkPhysicalDeviceInlineUniformBlockProperties maxPerStageDescriptorUpdateAfterBindInlineUniformBlocks(@Unsigned int value) {
        segment.set(LAYOUT$maxPerStageDescriptorUpdateAfterBindInlineUniformBlocks, OFFSET$maxPerStageDescriptorUpdateAfterBindInlineUniformBlocks, value);
        return this;
    }

    public @Unsigned int maxDescriptorSetInlineUniformBlocks() {
        return segment.get(LAYOUT$maxDescriptorSetInlineUniformBlocks, OFFSET$maxDescriptorSetInlineUniformBlocks);
    }

    public VkPhysicalDeviceInlineUniformBlockProperties maxDescriptorSetInlineUniformBlocks(@Unsigned int value) {
        segment.set(LAYOUT$maxDescriptorSetInlineUniformBlocks, OFFSET$maxDescriptorSetInlineUniformBlocks, value);
        return this;
    }

    public @Unsigned int maxDescriptorSetUpdateAfterBindInlineUniformBlocks() {
        return segment.get(LAYOUT$maxDescriptorSetUpdateAfterBindInlineUniformBlocks, OFFSET$maxDescriptorSetUpdateAfterBindInlineUniformBlocks);
    }

    public VkPhysicalDeviceInlineUniformBlockProperties maxDescriptorSetUpdateAfterBindInlineUniformBlocks(@Unsigned int value) {
        segment.set(LAYOUT$maxDescriptorSetUpdateAfterBindInlineUniformBlocks, OFFSET$maxDescriptorSetUpdateAfterBindInlineUniformBlocks, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("maxInlineUniformBlockSize"),
        ValueLayout.JAVA_INT.withName("maxPerStageDescriptorInlineUniformBlocks"),
        ValueLayout.JAVA_INT.withName("maxPerStageDescriptorUpdateAfterBindInlineUniformBlocks"),
        ValueLayout.JAVA_INT.withName("maxDescriptorSetInlineUniformBlocks"),
        ValueLayout.JAVA_INT.withName("maxDescriptorSetUpdateAfterBindInlineUniformBlocks")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$maxInlineUniformBlockSize = PathElement.groupElement("maxInlineUniformBlockSize");
    public static final PathElement PATH$maxPerStageDescriptorInlineUniformBlocks = PathElement.groupElement("maxPerStageDescriptorInlineUniformBlocks");
    public static final PathElement PATH$maxPerStageDescriptorUpdateAfterBindInlineUniformBlocks = PathElement.groupElement("maxPerStageDescriptorUpdateAfterBindInlineUniformBlocks");
    public static final PathElement PATH$maxDescriptorSetInlineUniformBlocks = PathElement.groupElement("maxDescriptorSetInlineUniformBlocks");
    public static final PathElement PATH$maxDescriptorSetUpdateAfterBindInlineUniformBlocks = PathElement.groupElement("maxDescriptorSetUpdateAfterBindInlineUniformBlocks");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$maxInlineUniformBlockSize = (OfInt) LAYOUT.select(PATH$maxInlineUniformBlockSize);
    public static final OfInt LAYOUT$maxPerStageDescriptorInlineUniformBlocks = (OfInt) LAYOUT.select(PATH$maxPerStageDescriptorInlineUniformBlocks);
    public static final OfInt LAYOUT$maxPerStageDescriptorUpdateAfterBindInlineUniformBlocks = (OfInt) LAYOUT.select(PATH$maxPerStageDescriptorUpdateAfterBindInlineUniformBlocks);
    public static final OfInt LAYOUT$maxDescriptorSetInlineUniformBlocks = (OfInt) LAYOUT.select(PATH$maxDescriptorSetInlineUniformBlocks);
    public static final OfInt LAYOUT$maxDescriptorSetUpdateAfterBindInlineUniformBlocks = (OfInt) LAYOUT.select(PATH$maxDescriptorSetUpdateAfterBindInlineUniformBlocks);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$maxInlineUniformBlockSize = LAYOUT$maxInlineUniformBlockSize.byteSize();
    public static final long SIZE$maxPerStageDescriptorInlineUniformBlocks = LAYOUT$maxPerStageDescriptorInlineUniformBlocks.byteSize();
    public static final long SIZE$maxPerStageDescriptorUpdateAfterBindInlineUniformBlocks = LAYOUT$maxPerStageDescriptorUpdateAfterBindInlineUniformBlocks.byteSize();
    public static final long SIZE$maxDescriptorSetInlineUniformBlocks = LAYOUT$maxDescriptorSetInlineUniformBlocks.byteSize();
    public static final long SIZE$maxDescriptorSetUpdateAfterBindInlineUniformBlocks = LAYOUT$maxDescriptorSetUpdateAfterBindInlineUniformBlocks.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$maxInlineUniformBlockSize = LAYOUT.byteOffset(PATH$maxInlineUniformBlockSize);
    public static final long OFFSET$maxPerStageDescriptorInlineUniformBlocks = LAYOUT.byteOffset(PATH$maxPerStageDescriptorInlineUniformBlocks);
    public static final long OFFSET$maxPerStageDescriptorUpdateAfterBindInlineUniformBlocks = LAYOUT.byteOffset(PATH$maxPerStageDescriptorUpdateAfterBindInlineUniformBlocks);
    public static final long OFFSET$maxDescriptorSetInlineUniformBlocks = LAYOUT.byteOffset(PATH$maxDescriptorSetInlineUniformBlocks);
    public static final long OFFSET$maxDescriptorSetUpdateAfterBindInlineUniformBlocks = LAYOUT.byteOffset(PATH$maxDescriptorSetUpdateAfterBindInlineUniformBlocks);
}
