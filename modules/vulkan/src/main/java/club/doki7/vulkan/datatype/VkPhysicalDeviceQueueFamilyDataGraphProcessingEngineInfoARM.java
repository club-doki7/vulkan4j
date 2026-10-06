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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM.html"><code>VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t queueFamilyIndex; // @link substring="queueFamilyIndex" target="#queueFamilyIndex"
///     VkPhysicalDeviceDataGraphProcessingEngineTypeARM engineType; // @link substring="VkPhysicalDeviceDataGraphProcessingEngineTypeARM" target="VkPhysicalDeviceDataGraphProcessingEngineTypeARM" @link substring="engineType" target="#engineType"
/// } VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_QUEUE_FAMILY_DATA_GRAPH_PROCESSING_ENGINE_INFO_ARM`
///
/// The {@code allocate} ({@link VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM#allocate(Arena)}, {@link VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM.html"><code>VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM(@NotNull MemorySegment segment) implements IVkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM.html"><code>VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM, Iterable<VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM at(long index) {
            return new VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM(segment.asSlice(index * VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM.BYTES, VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM.BYTES));
        }

        public VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM.BYTES, VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM.BYTES,
                (end - start) * VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM.BYTES));
        }

        public VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM[] toArray() {
            VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM[] ret = new VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM.BYTES;
            }

            @Override
            public VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM ret = new VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM(segment.asSlice(0, VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM allocate(Arena arena) {
        VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM ret = new VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_QUEUE_FAMILY_DATA_GRAPH_PROCESSING_ENGINE_INFO_ARM);
        return ret;
    }

    public static VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM.Ptr ret = new VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_QUEUE_FAMILY_DATA_GRAPH_PROCESSING_ENGINE_INFO_ARM);
        }
        return ret;
    }

    public static VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM clone(Arena arena, VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM src) {
        VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_QUEUE_FAMILY_DATA_GRAPH_PROCESSING_ENGINE_INFO_ARM);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int queueFamilyIndex() {
        return segment.get(LAYOUT$queueFamilyIndex, OFFSET$queueFamilyIndex);
    }

    public VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM queueFamilyIndex(@Unsigned int value) {
        segment.set(LAYOUT$queueFamilyIndex, OFFSET$queueFamilyIndex, value);
        return this;
    }

    public @EnumType(VkPhysicalDeviceDataGraphProcessingEngineTypeARM.class) int engineType() {
        return segment.get(LAYOUT$engineType, OFFSET$engineType);
    }

    public VkPhysicalDeviceQueueFamilyDataGraphProcessingEngineInfoARM engineType(@EnumType(VkPhysicalDeviceDataGraphProcessingEngineTypeARM.class) int value) {
        segment.set(LAYOUT$engineType, OFFSET$engineType, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("queueFamilyIndex"),
        ValueLayout.JAVA_INT.withName("engineType")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$queueFamilyIndex = PathElement.groupElement("queueFamilyIndex");
    public static final PathElement PATH$engineType = PathElement.groupElement("engineType");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$queueFamilyIndex = (OfInt) LAYOUT.select(PATH$queueFamilyIndex);
    public static final OfInt LAYOUT$engineType = (OfInt) LAYOUT.select(PATH$engineType);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$queueFamilyIndex = LAYOUT$queueFamilyIndex.byteSize();
    public static final long SIZE$engineType = LAYOUT$engineType.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$queueFamilyIndex = LAYOUT.byteOffset(PATH$queueFamilyIndex);
    public static final long OFFSET$engineType = LAYOUT.byteOffset(PATH$engineType);
}
