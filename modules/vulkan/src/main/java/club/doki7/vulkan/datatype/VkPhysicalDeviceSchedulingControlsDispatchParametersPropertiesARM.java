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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM.html"><code>VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t schedulingControlsMaxWarpsCount; // @link substring="schedulingControlsMaxWarpsCount" target="#schedulingControlsMaxWarpsCount"
///     uint32_t schedulingControlsMaxQueuedBatchesCount; // @link substring="schedulingControlsMaxQueuedBatchesCount" target="#schedulingControlsMaxQueuedBatchesCount"
///     uint32_t schedulingControlsMaxWorkGroupBatchSize; // @link substring="schedulingControlsMaxWorkGroupBatchSize" target="#schedulingControlsMaxWorkGroupBatchSize"
/// } VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SCHEDULING_CONTROLS_DISPATCH_PARAMETERS_PROPERTIES_ARM`
///
/// The {@code allocate} ({@link VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM#allocate(Arena)}, {@link VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM.html"><code>VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM(@NotNull MemorySegment segment) implements IVkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM.html"><code>VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM, Iterable<VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM at(long index) {
            return new VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM(segment.asSlice(index * VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM.BYTES, VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM.BYTES));
        }

        public VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM.BYTES, VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM.BYTES,
                (end - start) * VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM.BYTES));
        }

        public VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM[] toArray() {
            VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM[] ret = new VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM.BYTES;
            }

            @Override
            public VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM ret = new VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM(segment.asSlice(0, VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM allocate(Arena arena) {
        VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM ret = new VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_SCHEDULING_CONTROLS_DISPATCH_PARAMETERS_PROPERTIES_ARM);
        return ret;
    }

    public static VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM.Ptr ret = new VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_SCHEDULING_CONTROLS_DISPATCH_PARAMETERS_PROPERTIES_ARM);
        }
        return ret;
    }

    public static VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM clone(Arena arena, VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM src) {
        VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_SCHEDULING_CONTROLS_DISPATCH_PARAMETERS_PROPERTIES_ARM);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int schedulingControlsMaxWarpsCount() {
        return segment.get(LAYOUT$schedulingControlsMaxWarpsCount, OFFSET$schedulingControlsMaxWarpsCount);
    }

    public VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM schedulingControlsMaxWarpsCount(@Unsigned int value) {
        segment.set(LAYOUT$schedulingControlsMaxWarpsCount, OFFSET$schedulingControlsMaxWarpsCount, value);
        return this;
    }

    public @Unsigned int schedulingControlsMaxQueuedBatchesCount() {
        return segment.get(LAYOUT$schedulingControlsMaxQueuedBatchesCount, OFFSET$schedulingControlsMaxQueuedBatchesCount);
    }

    public VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM schedulingControlsMaxQueuedBatchesCount(@Unsigned int value) {
        segment.set(LAYOUT$schedulingControlsMaxQueuedBatchesCount, OFFSET$schedulingControlsMaxQueuedBatchesCount, value);
        return this;
    }

    public @Unsigned int schedulingControlsMaxWorkGroupBatchSize() {
        return segment.get(LAYOUT$schedulingControlsMaxWorkGroupBatchSize, OFFSET$schedulingControlsMaxWorkGroupBatchSize);
    }

    public VkPhysicalDeviceSchedulingControlsDispatchParametersPropertiesARM schedulingControlsMaxWorkGroupBatchSize(@Unsigned int value) {
        segment.set(LAYOUT$schedulingControlsMaxWorkGroupBatchSize, OFFSET$schedulingControlsMaxWorkGroupBatchSize, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("schedulingControlsMaxWarpsCount"),
        ValueLayout.JAVA_INT.withName("schedulingControlsMaxQueuedBatchesCount"),
        ValueLayout.JAVA_INT.withName("schedulingControlsMaxWorkGroupBatchSize")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$schedulingControlsMaxWarpsCount = PathElement.groupElement("schedulingControlsMaxWarpsCount");
    public static final PathElement PATH$schedulingControlsMaxQueuedBatchesCount = PathElement.groupElement("schedulingControlsMaxQueuedBatchesCount");
    public static final PathElement PATH$schedulingControlsMaxWorkGroupBatchSize = PathElement.groupElement("schedulingControlsMaxWorkGroupBatchSize");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$schedulingControlsMaxWarpsCount = (OfInt) LAYOUT.select(PATH$schedulingControlsMaxWarpsCount);
    public static final OfInt LAYOUT$schedulingControlsMaxQueuedBatchesCount = (OfInt) LAYOUT.select(PATH$schedulingControlsMaxQueuedBatchesCount);
    public static final OfInt LAYOUT$schedulingControlsMaxWorkGroupBatchSize = (OfInt) LAYOUT.select(PATH$schedulingControlsMaxWorkGroupBatchSize);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$schedulingControlsMaxWarpsCount = LAYOUT$schedulingControlsMaxWarpsCount.byteSize();
    public static final long SIZE$schedulingControlsMaxQueuedBatchesCount = LAYOUT$schedulingControlsMaxQueuedBatchesCount.byteSize();
    public static final long SIZE$schedulingControlsMaxWorkGroupBatchSize = LAYOUT$schedulingControlsMaxWorkGroupBatchSize.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$schedulingControlsMaxWarpsCount = LAYOUT.byteOffset(PATH$schedulingControlsMaxWarpsCount);
    public static final long OFFSET$schedulingControlsMaxQueuedBatchesCount = LAYOUT.byteOffset(PATH$schedulingControlsMaxQueuedBatchesCount);
    public static final long OFFSET$schedulingControlsMaxWorkGroupBatchSize = LAYOUT.byteOffset(PATH$schedulingControlsMaxWorkGroupBatchSize);
}
