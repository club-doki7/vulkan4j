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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineExecutablePropertiesKHR.html"><code>VkPipelineExecutablePropertiesKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPipelineExecutablePropertiesKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkShaderStageFlags stages; // @link substring="VkShaderStageFlags" target="VkShaderStageFlags" @link substring="stages" target="#stages"
///     char[VK_MAX_DESCRIPTION_SIZE] name; // @link substring="name" target="#name"
///     char[VK_MAX_DESCRIPTION_SIZE] description; // @link substring="description" target="#description"
///     uint32_t subgroupSize; // @link substring="subgroupSize" target="#subgroupSize"
/// } VkPipelineExecutablePropertiesKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PIPELINE_EXECUTABLE_PROPERTIES_KHR`
///
/// The {@code allocate} ({@link VkPipelineExecutablePropertiesKHR#allocate(Arena)}, {@link VkPipelineExecutablePropertiesKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPipelineExecutablePropertiesKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineExecutablePropertiesKHR.html"><code>VkPipelineExecutablePropertiesKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPipelineExecutablePropertiesKHR(@NotNull MemorySegment segment) implements IVkPipelineExecutablePropertiesKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineExecutablePropertiesKHR.html"><code>VkPipelineExecutablePropertiesKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPipelineExecutablePropertiesKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPipelineExecutablePropertiesKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPipelineExecutablePropertiesKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPipelineExecutablePropertiesKHR, Iterable<VkPipelineExecutablePropertiesKHR> {
        public long size() {
            return segment.byteSize() / VkPipelineExecutablePropertiesKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPipelineExecutablePropertiesKHR at(long index) {
            return new VkPipelineExecutablePropertiesKHR(segment.asSlice(index * VkPipelineExecutablePropertiesKHR.BYTES, VkPipelineExecutablePropertiesKHR.BYTES));
        }

        public VkPipelineExecutablePropertiesKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkPipelineExecutablePropertiesKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPipelineExecutablePropertiesKHR value) {
            MemorySegment s = segment.asSlice(index * VkPipelineExecutablePropertiesKHR.BYTES, VkPipelineExecutablePropertiesKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPipelineExecutablePropertiesKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPipelineExecutablePropertiesKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPipelineExecutablePropertiesKHR.BYTES,
                (end - start) * VkPipelineExecutablePropertiesKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPipelineExecutablePropertiesKHR.BYTES));
        }

        public VkPipelineExecutablePropertiesKHR[] toArray() {
            VkPipelineExecutablePropertiesKHR[] ret = new VkPipelineExecutablePropertiesKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPipelineExecutablePropertiesKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPipelineExecutablePropertiesKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPipelineExecutablePropertiesKHR.BYTES;
            }

            @Override
            public VkPipelineExecutablePropertiesKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPipelineExecutablePropertiesKHR ret = new VkPipelineExecutablePropertiesKHR(segment.asSlice(0, VkPipelineExecutablePropertiesKHR.BYTES));
                segment = segment.asSlice(VkPipelineExecutablePropertiesKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPipelineExecutablePropertiesKHR allocate(Arena arena) {
        VkPipelineExecutablePropertiesKHR ret = new VkPipelineExecutablePropertiesKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PIPELINE_EXECUTABLE_PROPERTIES_KHR);
        return ret;
    }

    public static VkPipelineExecutablePropertiesKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPipelineExecutablePropertiesKHR.Ptr ret = new VkPipelineExecutablePropertiesKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PIPELINE_EXECUTABLE_PROPERTIES_KHR);
        }
        return ret;
    }

    public static VkPipelineExecutablePropertiesKHR clone(Arena arena, VkPipelineExecutablePropertiesKHR src) {
        VkPipelineExecutablePropertiesKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PIPELINE_EXECUTABLE_PROPERTIES_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPipelineExecutablePropertiesKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPipelineExecutablePropertiesKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPipelineExecutablePropertiesKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkShaderStageFlags.class) int stages() {
        return segment.get(LAYOUT$stages, OFFSET$stages);
    }

    public VkPipelineExecutablePropertiesKHR stages(@Bitmask(VkShaderStageFlags.class) int value) {
        segment.set(LAYOUT$stages, OFFSET$stages, value);
        return this;
    }

    public BytePtr name() {
        return new BytePtr(nameRaw());
    }

    public VkPipelineExecutablePropertiesKHR name(@NotNull Consumer<BytePtr> consumer) {
        BytePtr ptr = name();
        consumer.accept(ptr);
        return this;
    }

    public VkPipelineExecutablePropertiesKHR name(BytePtr value) {
        MemorySegment s = nameRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment nameRaw() {
        return segment.asSlice(OFFSET$name, SIZE$name);
    }

    public BytePtr description() {
        return new BytePtr(descriptionRaw());
    }

    public VkPipelineExecutablePropertiesKHR description(@NotNull Consumer<BytePtr> consumer) {
        BytePtr ptr = description();
        consumer.accept(ptr);
        return this;
    }

    public VkPipelineExecutablePropertiesKHR description(BytePtr value) {
        MemorySegment s = descriptionRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment descriptionRaw() {
        return segment.asSlice(OFFSET$description, SIZE$description);
    }

    public @Unsigned int subgroupSize() {
        return segment.get(LAYOUT$subgroupSize, OFFSET$subgroupSize);
    }

    public VkPipelineExecutablePropertiesKHR subgroupSize(@Unsigned int value) {
        segment.set(LAYOUT$subgroupSize, OFFSET$subgroupSize, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("stages"),
        MemoryLayout.sequenceLayout(MAX_DESCRIPTION_SIZE, ValueLayout.JAVA_BYTE).withName("name"),
        MemoryLayout.sequenceLayout(MAX_DESCRIPTION_SIZE, ValueLayout.JAVA_BYTE).withName("description"),
        ValueLayout.JAVA_INT.withName("subgroupSize")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$stages = PathElement.groupElement("stages");
    public static final PathElement PATH$name = PathElement.groupElement("name");
    public static final PathElement PATH$description = PathElement.groupElement("description");
    public static final PathElement PATH$subgroupSize = PathElement.groupElement("subgroupSize");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$stages = (OfInt) LAYOUT.select(PATH$stages);
    public static final SequenceLayout LAYOUT$name = (SequenceLayout) LAYOUT.select(PATH$name);
    public static final SequenceLayout LAYOUT$description = (SequenceLayout) LAYOUT.select(PATH$description);
    public static final OfInt LAYOUT$subgroupSize = (OfInt) LAYOUT.select(PATH$subgroupSize);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$stages = LAYOUT$stages.byteSize();
    public static final long SIZE$name = LAYOUT$name.byteSize();
    public static final long SIZE$description = LAYOUT$description.byteSize();
    public static final long SIZE$subgroupSize = LAYOUT$subgroupSize.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$stages = LAYOUT.byteOffset(PATH$stages);
    public static final long OFFSET$name = LAYOUT.byteOffset(PATH$name);
    public static final long OFFSET$description = LAYOUT.byteOffset(PATH$description);
    public static final long OFFSET$subgroupSize = LAYOUT.byteOffset(PATH$subgroupSize);
}
