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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI.html"><code>VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t[3] maxWorkGroupCount; // @link substring="maxWorkGroupCount" target="#maxWorkGroupCount"
///     uint32_t[3] maxWorkGroupSize; // @link substring="maxWorkGroupSize" target="#maxWorkGroupSize"
///     uint32_t maxOutputClusterCount; // @link substring="maxOutputClusterCount" target="#maxOutputClusterCount"
///     VkDeviceSize indirectBufferOffsetAlignment; // @link substring="indirectBufferOffsetAlignment" target="#indirectBufferOffsetAlignment"
/// } VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_CLUSTER_CULLING_SHADER_PROPERTIES_HUAWEI`
///
/// The {@code allocate} ({@link VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI#allocate(Arena)}, {@link VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI.html"><code>VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI(@NotNull MemorySegment segment) implements IVkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI.html"><code>VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI, Iterable<VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI at(long index) {
            return new VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI(segment.asSlice(index * VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI.BYTES, VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI.BYTES));
        }

        public VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI.BYTES, VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI.BYTES,
                (end - start) * VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI.BYTES));
        }

        public VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI[] toArray() {
            VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI[] ret = new VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI.BYTES;
            }

            @Override
            public VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI ret = new VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI(segment.asSlice(0, VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI allocate(Arena arena) {
        VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI ret = new VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_CLUSTER_CULLING_SHADER_PROPERTIES_HUAWEI);
        return ret;
    }

    public static VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI.Ptr ret = new VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_CLUSTER_CULLING_SHADER_PROPERTIES_HUAWEI);
        }
        return ret;
    }

    public static VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI clone(Arena arena, VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI src) {
        VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_CLUSTER_CULLING_SHADER_PROPERTIES_HUAWEI);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned IntPtr maxWorkGroupCount() {
        return new IntPtr(maxWorkGroupCountRaw());
    }

    public VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI maxWorkGroupCount(@NotNull Consumer<IntPtr> consumer) {
        @Unsigned IntPtr ptr = maxWorkGroupCount();
        consumer.accept(ptr);
        return this;
    }

    public VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI maxWorkGroupCount(@Unsigned IntPtr value) {
        MemorySegment s = maxWorkGroupCountRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment maxWorkGroupCountRaw() {
        return segment.asSlice(OFFSET$maxWorkGroupCount, SIZE$maxWorkGroupCount);
    }

    public @Unsigned IntPtr maxWorkGroupSize() {
        return new IntPtr(maxWorkGroupSizeRaw());
    }

    public VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI maxWorkGroupSize(@NotNull Consumer<IntPtr> consumer) {
        @Unsigned IntPtr ptr = maxWorkGroupSize();
        consumer.accept(ptr);
        return this;
    }

    public VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI maxWorkGroupSize(@Unsigned IntPtr value) {
        MemorySegment s = maxWorkGroupSizeRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment maxWorkGroupSizeRaw() {
        return segment.asSlice(OFFSET$maxWorkGroupSize, SIZE$maxWorkGroupSize);
    }

    public @Unsigned int maxOutputClusterCount() {
        return segment.get(LAYOUT$maxOutputClusterCount, OFFSET$maxOutputClusterCount);
    }

    public VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI maxOutputClusterCount(@Unsigned int value) {
        segment.set(LAYOUT$maxOutputClusterCount, OFFSET$maxOutputClusterCount, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long indirectBufferOffsetAlignment() {
        return segment.get(LAYOUT$indirectBufferOffsetAlignment, OFFSET$indirectBufferOffsetAlignment);
    }

    public VkPhysicalDeviceClusterCullingShaderPropertiesHUAWEI indirectBufferOffsetAlignment(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$indirectBufferOffsetAlignment, OFFSET$indirectBufferOffsetAlignment, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        MemoryLayout.sequenceLayout(3, ValueLayout.JAVA_INT).withName("maxWorkGroupCount"),
        MemoryLayout.sequenceLayout(3, ValueLayout.JAVA_INT).withName("maxWorkGroupSize"),
        ValueLayout.JAVA_INT.withName("maxOutputClusterCount"),
        ValueLayout.JAVA_LONG.withName("indirectBufferOffsetAlignment")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$maxWorkGroupCount = PathElement.groupElement("maxWorkGroupCount");
    public static final PathElement PATH$maxWorkGroupSize = PathElement.groupElement("maxWorkGroupSize");
    public static final PathElement PATH$maxOutputClusterCount = PathElement.groupElement("maxOutputClusterCount");
    public static final PathElement PATH$indirectBufferOffsetAlignment = PathElement.groupElement("indirectBufferOffsetAlignment");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final SequenceLayout LAYOUT$maxWorkGroupCount = (SequenceLayout) LAYOUT.select(PATH$maxWorkGroupCount);
    public static final SequenceLayout LAYOUT$maxWorkGroupSize = (SequenceLayout) LAYOUT.select(PATH$maxWorkGroupSize);
    public static final OfInt LAYOUT$maxOutputClusterCount = (OfInt) LAYOUT.select(PATH$maxOutputClusterCount);
    public static final OfLong LAYOUT$indirectBufferOffsetAlignment = (OfLong) LAYOUT.select(PATH$indirectBufferOffsetAlignment);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$maxWorkGroupCount = LAYOUT$maxWorkGroupCount.byteSize();
    public static final long SIZE$maxWorkGroupSize = LAYOUT$maxWorkGroupSize.byteSize();
    public static final long SIZE$maxOutputClusterCount = LAYOUT$maxOutputClusterCount.byteSize();
    public static final long SIZE$indirectBufferOffsetAlignment = LAYOUT$indirectBufferOffsetAlignment.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$maxWorkGroupCount = LAYOUT.byteOffset(PATH$maxWorkGroupCount);
    public static final long OFFSET$maxWorkGroupSize = LAYOUT.byteOffset(PATH$maxWorkGroupSize);
    public static final long OFFSET$maxOutputClusterCount = LAYOUT.byteOffset(PATH$maxOutputClusterCount);
    public static final long OFFSET$indirectBufferOffsetAlignment = LAYOUT.byteOffset(PATH$indirectBufferOffsetAlignment);
}
