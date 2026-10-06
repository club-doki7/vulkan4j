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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkQueueFamilyDataGraphPropertiesARM.html"><code>VkQueueFamilyDataGraphPropertiesARM</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkQueueFamilyDataGraphPropertiesARM {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkPhysicalDeviceDataGraphProcessingEngineARM engine; // @link substring="VkPhysicalDeviceDataGraphProcessingEngineARM" target="VkPhysicalDeviceDataGraphProcessingEngineARM" @link substring="engine" target="#engine"
///     VkPhysicalDeviceDataGraphOperationSupportARM operation; // @link substring="VkPhysicalDeviceDataGraphOperationSupportARM" target="VkPhysicalDeviceDataGraphOperationSupportARM" @link substring="operation" target="#operation"
/// } VkQueueFamilyDataGraphPropertiesARM;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_QUEUE_FAMILY_DATA_GRAPH_PROPERTIES_ARM`
///
/// The {@code allocate} ({@link VkQueueFamilyDataGraphPropertiesARM#allocate(Arena)}, {@link VkQueueFamilyDataGraphPropertiesARM#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkQueueFamilyDataGraphPropertiesARM#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkQueueFamilyDataGraphPropertiesARM.html"><code>VkQueueFamilyDataGraphPropertiesARM</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkQueueFamilyDataGraphPropertiesARM(@NotNull MemorySegment segment) implements IVkQueueFamilyDataGraphPropertiesARM {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkQueueFamilyDataGraphPropertiesARM.html"><code>VkQueueFamilyDataGraphPropertiesARM</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkQueueFamilyDataGraphPropertiesARM}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkQueueFamilyDataGraphPropertiesARM to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkQueueFamilyDataGraphPropertiesARM.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkQueueFamilyDataGraphPropertiesARM, Iterable<VkQueueFamilyDataGraphPropertiesARM> {
        public long size() {
            return segment.byteSize() / VkQueueFamilyDataGraphPropertiesARM.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkQueueFamilyDataGraphPropertiesARM at(long index) {
            return new VkQueueFamilyDataGraphPropertiesARM(segment.asSlice(index * VkQueueFamilyDataGraphPropertiesARM.BYTES, VkQueueFamilyDataGraphPropertiesARM.BYTES));
        }

        public VkQueueFamilyDataGraphPropertiesARM.Ptr at(long index, @NotNull Consumer<@NotNull VkQueueFamilyDataGraphPropertiesARM> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkQueueFamilyDataGraphPropertiesARM value) {
            MemorySegment s = segment.asSlice(index * VkQueueFamilyDataGraphPropertiesARM.BYTES, VkQueueFamilyDataGraphPropertiesARM.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkQueueFamilyDataGraphPropertiesARM.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkQueueFamilyDataGraphPropertiesARM.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkQueueFamilyDataGraphPropertiesARM.BYTES,
                (end - start) * VkQueueFamilyDataGraphPropertiesARM.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkQueueFamilyDataGraphPropertiesARM.BYTES));
        }

        public VkQueueFamilyDataGraphPropertiesARM[] toArray() {
            VkQueueFamilyDataGraphPropertiesARM[] ret = new VkQueueFamilyDataGraphPropertiesARM[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkQueueFamilyDataGraphPropertiesARM> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkQueueFamilyDataGraphPropertiesARM> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkQueueFamilyDataGraphPropertiesARM.BYTES;
            }

            @Override
            public VkQueueFamilyDataGraphPropertiesARM next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkQueueFamilyDataGraphPropertiesARM ret = new VkQueueFamilyDataGraphPropertiesARM(segment.asSlice(0, VkQueueFamilyDataGraphPropertiesARM.BYTES));
                segment = segment.asSlice(VkQueueFamilyDataGraphPropertiesARM.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkQueueFamilyDataGraphPropertiesARM allocate(Arena arena) {
        VkQueueFamilyDataGraphPropertiesARM ret = new VkQueueFamilyDataGraphPropertiesARM(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.QUEUE_FAMILY_DATA_GRAPH_PROPERTIES_ARM);
        return ret;
    }

    public static VkQueueFamilyDataGraphPropertiesARM.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkQueueFamilyDataGraphPropertiesARM.Ptr ret = new VkQueueFamilyDataGraphPropertiesARM.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.QUEUE_FAMILY_DATA_GRAPH_PROPERTIES_ARM);
        }
        return ret;
    }

    public static VkQueueFamilyDataGraphPropertiesARM clone(Arena arena, VkQueueFamilyDataGraphPropertiesARM src) {
        VkQueueFamilyDataGraphPropertiesARM ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.QUEUE_FAMILY_DATA_GRAPH_PROPERTIES_ARM);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkQueueFamilyDataGraphPropertiesARM sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkQueueFamilyDataGraphPropertiesARM pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkQueueFamilyDataGraphPropertiesARM pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NotNull VkPhysicalDeviceDataGraphProcessingEngineARM engine() {
        return new VkPhysicalDeviceDataGraphProcessingEngineARM(segment.asSlice(OFFSET$engine, LAYOUT$engine));
    }

    public VkQueueFamilyDataGraphPropertiesARM engine(@NotNull VkPhysicalDeviceDataGraphProcessingEngineARM value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$engine, SIZE$engine);
        return this;
    }

    public VkQueueFamilyDataGraphPropertiesARM engine(Consumer<@NotNull VkPhysicalDeviceDataGraphProcessingEngineARM> consumer) {
        consumer.accept(engine());
        return this;
    }

    public @NotNull VkPhysicalDeviceDataGraphOperationSupportARM operation() {
        return new VkPhysicalDeviceDataGraphOperationSupportARM(segment.asSlice(OFFSET$operation, LAYOUT$operation));
    }

    public VkQueueFamilyDataGraphPropertiesARM operation(@NotNull VkPhysicalDeviceDataGraphOperationSupportARM value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$operation, SIZE$operation);
        return this;
    }

    public VkQueueFamilyDataGraphPropertiesARM operation(Consumer<@NotNull VkPhysicalDeviceDataGraphOperationSupportARM> consumer) {
        consumer.accept(operation());
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        VkPhysicalDeviceDataGraphProcessingEngineARM.LAYOUT.withName("engine"),
        VkPhysicalDeviceDataGraphOperationSupportARM.LAYOUT.withName("operation")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$engine = PathElement.groupElement("engine");
    public static final PathElement PATH$operation = PathElement.groupElement("operation");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final StructLayout LAYOUT$engine = (StructLayout) LAYOUT.select(PATH$engine);
    public static final StructLayout LAYOUT$operation = (StructLayout) LAYOUT.select(PATH$operation);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$engine = LAYOUT$engine.byteSize();
    public static final long SIZE$operation = LAYOUT$operation.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$engine = LAYOUT.byteOffset(PATH$engine);
    public static final long OFFSET$operation = LAYOUT.byteOffset(PATH$operation);
}
