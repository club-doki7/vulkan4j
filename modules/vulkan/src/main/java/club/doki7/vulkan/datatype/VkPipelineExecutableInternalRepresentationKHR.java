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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineExecutableInternalRepresentationKHR.html"><code>VkPipelineExecutableInternalRepresentationKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPipelineExecutableInternalRepresentationKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     char[VK_MAX_DESCRIPTION_SIZE] name; // @link substring="name" target="#name"
///     char[VK_MAX_DESCRIPTION_SIZE] description; // @link substring="description" target="#description"
///     VkBool32 isText; // @link substring="isText" target="#isText"
///     size_t dataSize; // @link substring="dataSize" target="#dataSize"
///     void* pData; // @link substring="pData" target="#pData"
/// } VkPipelineExecutableInternalRepresentationKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PIPELINE_EXECUTABLE_INTERNAL_REPRESENTATION_KHR`
///
/// The {@code allocate} ({@link VkPipelineExecutableInternalRepresentationKHR#allocate(Arena)}, {@link VkPipelineExecutableInternalRepresentationKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPipelineExecutableInternalRepresentationKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineExecutableInternalRepresentationKHR.html"><code>VkPipelineExecutableInternalRepresentationKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPipelineExecutableInternalRepresentationKHR(@NotNull MemorySegment segment) implements IVkPipelineExecutableInternalRepresentationKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineExecutableInternalRepresentationKHR.html"><code>VkPipelineExecutableInternalRepresentationKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPipelineExecutableInternalRepresentationKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPipelineExecutableInternalRepresentationKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPipelineExecutableInternalRepresentationKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPipelineExecutableInternalRepresentationKHR, Iterable<VkPipelineExecutableInternalRepresentationKHR> {
        public long size() {
            return segment.byteSize() / VkPipelineExecutableInternalRepresentationKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPipelineExecutableInternalRepresentationKHR at(long index) {
            return new VkPipelineExecutableInternalRepresentationKHR(segment.asSlice(index * VkPipelineExecutableInternalRepresentationKHR.BYTES, VkPipelineExecutableInternalRepresentationKHR.BYTES));
        }

        public VkPipelineExecutableInternalRepresentationKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkPipelineExecutableInternalRepresentationKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPipelineExecutableInternalRepresentationKHR value) {
            MemorySegment s = segment.asSlice(index * VkPipelineExecutableInternalRepresentationKHR.BYTES, VkPipelineExecutableInternalRepresentationKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPipelineExecutableInternalRepresentationKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPipelineExecutableInternalRepresentationKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPipelineExecutableInternalRepresentationKHR.BYTES,
                (end - start) * VkPipelineExecutableInternalRepresentationKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPipelineExecutableInternalRepresentationKHR.BYTES));
        }

        public VkPipelineExecutableInternalRepresentationKHR[] toArray() {
            VkPipelineExecutableInternalRepresentationKHR[] ret = new VkPipelineExecutableInternalRepresentationKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPipelineExecutableInternalRepresentationKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPipelineExecutableInternalRepresentationKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPipelineExecutableInternalRepresentationKHR.BYTES;
            }

            @Override
            public VkPipelineExecutableInternalRepresentationKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPipelineExecutableInternalRepresentationKHR ret = new VkPipelineExecutableInternalRepresentationKHR(segment.asSlice(0, VkPipelineExecutableInternalRepresentationKHR.BYTES));
                segment = segment.asSlice(VkPipelineExecutableInternalRepresentationKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPipelineExecutableInternalRepresentationKHR allocate(Arena arena) {
        VkPipelineExecutableInternalRepresentationKHR ret = new VkPipelineExecutableInternalRepresentationKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PIPELINE_EXECUTABLE_INTERNAL_REPRESENTATION_KHR);
        return ret;
    }

    public static VkPipelineExecutableInternalRepresentationKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPipelineExecutableInternalRepresentationKHR.Ptr ret = new VkPipelineExecutableInternalRepresentationKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PIPELINE_EXECUTABLE_INTERNAL_REPRESENTATION_KHR);
        }
        return ret;
    }

    public static VkPipelineExecutableInternalRepresentationKHR clone(Arena arena, VkPipelineExecutableInternalRepresentationKHR src) {
        VkPipelineExecutableInternalRepresentationKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PIPELINE_EXECUTABLE_INTERNAL_REPRESENTATION_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPipelineExecutableInternalRepresentationKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPipelineExecutableInternalRepresentationKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPipelineExecutableInternalRepresentationKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public BytePtr name() {
        return new BytePtr(nameRaw());
    }

    public VkPipelineExecutableInternalRepresentationKHR name(@NotNull Consumer<BytePtr> consumer) {
        BytePtr ptr = name();
        consumer.accept(ptr);
        return this;
    }

    public VkPipelineExecutableInternalRepresentationKHR name(BytePtr value) {
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

    public VkPipelineExecutableInternalRepresentationKHR description(@NotNull Consumer<BytePtr> consumer) {
        BytePtr ptr = description();
        consumer.accept(ptr);
        return this;
    }

    public VkPipelineExecutableInternalRepresentationKHR description(BytePtr value) {
        MemorySegment s = descriptionRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment descriptionRaw() {
        return segment.asSlice(OFFSET$description, SIZE$description);
    }

    public @NativeType("VkBool32") @Unsigned int isText() {
        return segment.get(LAYOUT$isText, OFFSET$isText);
    }

    public VkPipelineExecutableInternalRepresentationKHR isText(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$isText, OFFSET$isText, value);
        return this;
    }

    public @Unsigned long dataSize() {
        return NativeLayout.readCSizeT(segment, OFFSET$dataSize);
    }

    public VkPipelineExecutableInternalRepresentationKHR dataSize(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$dataSize, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pData() {
        return segment.get(LAYOUT$pData, OFFSET$pData);
    }

    public VkPipelineExecutableInternalRepresentationKHR pData(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pData, OFFSET$pData, value);
        return this;
    }

    public VkPipelineExecutableInternalRepresentationKHR pData(@Nullable IPointer pointer) {
        pData(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        MemoryLayout.sequenceLayout(MAX_DESCRIPTION_SIZE, ValueLayout.JAVA_BYTE).withName("name"),
        MemoryLayout.sequenceLayout(MAX_DESCRIPTION_SIZE, ValueLayout.JAVA_BYTE).withName("description"),
        ValueLayout.JAVA_INT.withName("isText"),
        NativeLayout.C_SIZE_T.withName("dataSize"),
        ValueLayout.ADDRESS.withName("pData")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$name = PathElement.groupElement("name");
    public static final PathElement PATH$description = PathElement.groupElement("description");
    public static final PathElement PATH$isText = PathElement.groupElement("isText");
    public static final PathElement PATH$dataSize = PathElement.groupElement("dataSize");
    public static final PathElement PATH$pData = PathElement.groupElement("pData");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final SequenceLayout LAYOUT$name = (SequenceLayout) LAYOUT.select(PATH$name);
    public static final SequenceLayout LAYOUT$description = (SequenceLayout) LAYOUT.select(PATH$description);
    public static final OfInt LAYOUT$isText = (OfInt) LAYOUT.select(PATH$isText);
    public static final AddressLayout LAYOUT$pData = (AddressLayout) LAYOUT.select(PATH$pData);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$name = LAYOUT$name.byteSize();
    public static final long SIZE$description = LAYOUT$description.byteSize();
    public static final long SIZE$isText = LAYOUT$isText.byteSize();
    public static final long SIZE$dataSize = NativeLayout.C_SIZE_T.byteSize();
    public static final long SIZE$pData = LAYOUT$pData.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$name = LAYOUT.byteOffset(PATH$name);
    public static final long OFFSET$description = LAYOUT.byteOffset(PATH$description);
    public static final long OFFSET$isText = LAYOUT.byteOffset(PATH$isText);
    public static final long OFFSET$dataSize = LAYOUT.byteOffset(PATH$dataSize);
    public static final long OFFSET$pData = LAYOUT.byteOffset(PATH$pData);
}
