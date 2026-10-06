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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDeviceMemoryReportCallbackDataEXT.html"><code>VkDeviceMemoryReportCallbackDataEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDeviceMemoryReportCallbackDataEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkDeviceMemoryReportFlagsEXT flags; // @link substring="VkDeviceMemoryReportFlagsEXT" target="VkDeviceMemoryReportFlagsEXT" @link substring="flags" target="#flags"
///     VkDeviceMemoryReportEventTypeEXT type; // @link substring="VkDeviceMemoryReportEventTypeEXT" target="VkDeviceMemoryReportEventTypeEXT" @link substring="type" target="#type"
///     uint64_t memoryObjectId; // @link substring="memoryObjectId" target="#memoryObjectId"
///     VkDeviceSize size; // @link substring="size" target="#size"
///     VkObjectType objectType; // @link substring="VkObjectType" target="VkObjectType" @link substring="objectType" target="#objectType"
///     uint64_t objectHandle; // @link substring="objectHandle" target="#objectHandle"
///     uint32_t heapIndex; // @link substring="heapIndex" target="#heapIndex"
/// } VkDeviceMemoryReportCallbackDataEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_DEVICE_MEMORY_REPORT_CALLBACK_DATA_EXT`
///
/// The {@code allocate} ({@link VkDeviceMemoryReportCallbackDataEXT#allocate(Arena)}, {@link VkDeviceMemoryReportCallbackDataEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkDeviceMemoryReportCallbackDataEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDeviceMemoryReportCallbackDataEXT.html"><code>VkDeviceMemoryReportCallbackDataEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDeviceMemoryReportCallbackDataEXT(@NotNull MemorySegment segment) implements IVkDeviceMemoryReportCallbackDataEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDeviceMemoryReportCallbackDataEXT.html"><code>VkDeviceMemoryReportCallbackDataEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDeviceMemoryReportCallbackDataEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDeviceMemoryReportCallbackDataEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDeviceMemoryReportCallbackDataEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDeviceMemoryReportCallbackDataEXT, Iterable<VkDeviceMemoryReportCallbackDataEXT> {
        public long size() {
            return segment.byteSize() / VkDeviceMemoryReportCallbackDataEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDeviceMemoryReportCallbackDataEXT at(long index) {
            return new VkDeviceMemoryReportCallbackDataEXT(segment.asSlice(index * VkDeviceMemoryReportCallbackDataEXT.BYTES, VkDeviceMemoryReportCallbackDataEXT.BYTES));
        }

        public VkDeviceMemoryReportCallbackDataEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkDeviceMemoryReportCallbackDataEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDeviceMemoryReportCallbackDataEXT value) {
            MemorySegment s = segment.asSlice(index * VkDeviceMemoryReportCallbackDataEXT.BYTES, VkDeviceMemoryReportCallbackDataEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDeviceMemoryReportCallbackDataEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDeviceMemoryReportCallbackDataEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDeviceMemoryReportCallbackDataEXT.BYTES,
                (end - start) * VkDeviceMemoryReportCallbackDataEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDeviceMemoryReportCallbackDataEXT.BYTES));
        }

        public VkDeviceMemoryReportCallbackDataEXT[] toArray() {
            VkDeviceMemoryReportCallbackDataEXT[] ret = new VkDeviceMemoryReportCallbackDataEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDeviceMemoryReportCallbackDataEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDeviceMemoryReportCallbackDataEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDeviceMemoryReportCallbackDataEXT.BYTES;
            }

            @Override
            public VkDeviceMemoryReportCallbackDataEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDeviceMemoryReportCallbackDataEXT ret = new VkDeviceMemoryReportCallbackDataEXT(segment.asSlice(0, VkDeviceMemoryReportCallbackDataEXT.BYTES));
                segment = segment.asSlice(VkDeviceMemoryReportCallbackDataEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDeviceMemoryReportCallbackDataEXT allocate(Arena arena) {
        VkDeviceMemoryReportCallbackDataEXT ret = new VkDeviceMemoryReportCallbackDataEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.DEVICE_MEMORY_REPORT_CALLBACK_DATA_EXT);
        return ret;
    }

    public static VkDeviceMemoryReportCallbackDataEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkDeviceMemoryReportCallbackDataEXT.Ptr ret = new VkDeviceMemoryReportCallbackDataEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.DEVICE_MEMORY_REPORT_CALLBACK_DATA_EXT);
        }
        return ret;
    }

    public static VkDeviceMemoryReportCallbackDataEXT clone(Arena arena, VkDeviceMemoryReportCallbackDataEXT src) {
        VkDeviceMemoryReportCallbackDataEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.DEVICE_MEMORY_REPORT_CALLBACK_DATA_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkDeviceMemoryReportCallbackDataEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkDeviceMemoryReportCallbackDataEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkDeviceMemoryReportCallbackDataEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkDeviceMemoryReportFlagsEXT.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkDeviceMemoryReportCallbackDataEXT flags(@Bitmask(VkDeviceMemoryReportFlagsEXT.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @EnumType(VkDeviceMemoryReportEventTypeEXT.class) int type() {
        return segment.get(LAYOUT$type, OFFSET$type);
    }

    public VkDeviceMemoryReportCallbackDataEXT type(@EnumType(VkDeviceMemoryReportEventTypeEXT.class) int value) {
        segment.set(LAYOUT$type, OFFSET$type, value);
        return this;
    }

    public @Unsigned long memoryObjectId() {
        return segment.get(LAYOUT$memoryObjectId, OFFSET$memoryObjectId);
    }

    public VkDeviceMemoryReportCallbackDataEXT memoryObjectId(@Unsigned long value) {
        segment.set(LAYOUT$memoryObjectId, OFFSET$memoryObjectId, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long size() {
        return segment.get(LAYOUT$size, OFFSET$size);
    }

    public VkDeviceMemoryReportCallbackDataEXT size(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$size, OFFSET$size, value);
        return this;
    }

    public @EnumType(VkObjectType.class) int objectType() {
        return segment.get(LAYOUT$objectType, OFFSET$objectType);
    }

    public VkDeviceMemoryReportCallbackDataEXT objectType(@EnumType(VkObjectType.class) int value) {
        segment.set(LAYOUT$objectType, OFFSET$objectType, value);
        return this;
    }

    public @Unsigned long objectHandle() {
        return segment.get(LAYOUT$objectHandle, OFFSET$objectHandle);
    }

    public VkDeviceMemoryReportCallbackDataEXT objectHandle(@Unsigned long value) {
        segment.set(LAYOUT$objectHandle, OFFSET$objectHandle, value);
        return this;
    }

    public @Unsigned int heapIndex() {
        return segment.get(LAYOUT$heapIndex, OFFSET$heapIndex);
    }

    public VkDeviceMemoryReportCallbackDataEXT heapIndex(@Unsigned int value) {
        segment.set(LAYOUT$heapIndex, OFFSET$heapIndex, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("type"),
        ValueLayout.JAVA_LONG.withName("memoryObjectId"),
        ValueLayout.JAVA_LONG.withName("size"),
        ValueLayout.JAVA_INT.withName("objectType"),
        ValueLayout.JAVA_LONG.withName("objectHandle"),
        ValueLayout.JAVA_INT.withName("heapIndex")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$type = PathElement.groupElement("type");
    public static final PathElement PATH$memoryObjectId = PathElement.groupElement("memoryObjectId");
    public static final PathElement PATH$size = PathElement.groupElement("size");
    public static final PathElement PATH$objectType = PathElement.groupElement("objectType");
    public static final PathElement PATH$objectHandle = PathElement.groupElement("objectHandle");
    public static final PathElement PATH$heapIndex = PathElement.groupElement("heapIndex");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$type = (OfInt) LAYOUT.select(PATH$type);
    public static final OfLong LAYOUT$memoryObjectId = (OfLong) LAYOUT.select(PATH$memoryObjectId);
    public static final OfLong LAYOUT$size = (OfLong) LAYOUT.select(PATH$size);
    public static final OfInt LAYOUT$objectType = (OfInt) LAYOUT.select(PATH$objectType);
    public static final OfLong LAYOUT$objectHandle = (OfLong) LAYOUT.select(PATH$objectHandle);
    public static final OfInt LAYOUT$heapIndex = (OfInt) LAYOUT.select(PATH$heapIndex);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$type = LAYOUT$type.byteSize();
    public static final long SIZE$memoryObjectId = LAYOUT$memoryObjectId.byteSize();
    public static final long SIZE$size = LAYOUT$size.byteSize();
    public static final long SIZE$objectType = LAYOUT$objectType.byteSize();
    public static final long SIZE$objectHandle = LAYOUT$objectHandle.byteSize();
    public static final long SIZE$heapIndex = LAYOUT$heapIndex.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$type = LAYOUT.byteOffset(PATH$type);
    public static final long OFFSET$memoryObjectId = LAYOUT.byteOffset(PATH$memoryObjectId);
    public static final long OFFSET$size = LAYOUT.byteOffset(PATH$size);
    public static final long OFFSET$objectType = LAYOUT.byteOffset(PATH$objectType);
    public static final long OFFSET$objectHandle = LAYOUT.byteOffset(PATH$objectHandle);
    public static final long OFFSET$heapIndex = LAYOUT.byteOffset(PATH$heapIndex);
}
