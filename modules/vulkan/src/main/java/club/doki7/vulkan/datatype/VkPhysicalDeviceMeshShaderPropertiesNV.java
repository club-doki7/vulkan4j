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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceMeshShaderPropertiesNV.html"><code>VkPhysicalDeviceMeshShaderPropertiesNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceMeshShaderPropertiesNV {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t maxDrawMeshTasksCount; // @link substring="maxDrawMeshTasksCount" target="#maxDrawMeshTasksCount"
///     uint32_t maxTaskWorkGroupInvocations; // @link substring="maxTaskWorkGroupInvocations" target="#maxTaskWorkGroupInvocations"
///     uint32_t[3] maxTaskWorkGroupSize; // @link substring="maxTaskWorkGroupSize" target="#maxTaskWorkGroupSize"
///     uint32_t maxTaskTotalMemorySize; // @link substring="maxTaskTotalMemorySize" target="#maxTaskTotalMemorySize"
///     uint32_t maxTaskOutputCount; // @link substring="maxTaskOutputCount" target="#maxTaskOutputCount"
///     uint32_t maxMeshWorkGroupInvocations; // @link substring="maxMeshWorkGroupInvocations" target="#maxMeshWorkGroupInvocations"
///     uint32_t[3] maxMeshWorkGroupSize; // @link substring="maxMeshWorkGroupSize" target="#maxMeshWorkGroupSize"
///     uint32_t maxMeshTotalMemorySize; // @link substring="maxMeshTotalMemorySize" target="#maxMeshTotalMemorySize"
///     uint32_t maxMeshOutputVertices; // @link substring="maxMeshOutputVertices" target="#maxMeshOutputVertices"
///     uint32_t maxMeshOutputPrimitives; // @link substring="maxMeshOutputPrimitives" target="#maxMeshOutputPrimitives"
///     uint32_t maxMeshMultiviewViewCount; // @link substring="maxMeshMultiviewViewCount" target="#maxMeshMultiviewViewCount"
///     uint32_t meshOutputPerVertexGranularity; // @link substring="meshOutputPerVertexGranularity" target="#meshOutputPerVertexGranularity"
///     uint32_t meshOutputPerPrimitiveGranularity; // @link substring="meshOutputPerPrimitiveGranularity" target="#meshOutputPerPrimitiveGranularity"
/// } VkPhysicalDeviceMeshShaderPropertiesNV;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_MESH_SHADER_PROPERTIES_NV`
///
/// The {@code allocate} ({@link VkPhysicalDeviceMeshShaderPropertiesNV#allocate(Arena)}, {@link VkPhysicalDeviceMeshShaderPropertiesNV#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceMeshShaderPropertiesNV#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceMeshShaderPropertiesNV.html"><code>VkPhysicalDeviceMeshShaderPropertiesNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceMeshShaderPropertiesNV(@NotNull MemorySegment segment) implements IVkPhysicalDeviceMeshShaderPropertiesNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceMeshShaderPropertiesNV.html"><code>VkPhysicalDeviceMeshShaderPropertiesNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceMeshShaderPropertiesNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceMeshShaderPropertiesNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceMeshShaderPropertiesNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceMeshShaderPropertiesNV, Iterable<VkPhysicalDeviceMeshShaderPropertiesNV> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceMeshShaderPropertiesNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceMeshShaderPropertiesNV at(long index) {
            return new VkPhysicalDeviceMeshShaderPropertiesNV(segment.asSlice(index * VkPhysicalDeviceMeshShaderPropertiesNV.BYTES, VkPhysicalDeviceMeshShaderPropertiesNV.BYTES));
        }

        public VkPhysicalDeviceMeshShaderPropertiesNV.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceMeshShaderPropertiesNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceMeshShaderPropertiesNV value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceMeshShaderPropertiesNV.BYTES, VkPhysicalDeviceMeshShaderPropertiesNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceMeshShaderPropertiesNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceMeshShaderPropertiesNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceMeshShaderPropertiesNV.BYTES,
                (end - start) * VkPhysicalDeviceMeshShaderPropertiesNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceMeshShaderPropertiesNV.BYTES));
        }

        public VkPhysicalDeviceMeshShaderPropertiesNV[] toArray() {
            VkPhysicalDeviceMeshShaderPropertiesNV[] ret = new VkPhysicalDeviceMeshShaderPropertiesNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceMeshShaderPropertiesNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceMeshShaderPropertiesNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceMeshShaderPropertiesNV.BYTES;
            }

            @Override
            public VkPhysicalDeviceMeshShaderPropertiesNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceMeshShaderPropertiesNV ret = new VkPhysicalDeviceMeshShaderPropertiesNV(segment.asSlice(0, VkPhysicalDeviceMeshShaderPropertiesNV.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceMeshShaderPropertiesNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceMeshShaderPropertiesNV allocate(Arena arena) {
        VkPhysicalDeviceMeshShaderPropertiesNV ret = new VkPhysicalDeviceMeshShaderPropertiesNV(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_MESH_SHADER_PROPERTIES_NV);
        return ret;
    }

    public static VkPhysicalDeviceMeshShaderPropertiesNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceMeshShaderPropertiesNV.Ptr ret = new VkPhysicalDeviceMeshShaderPropertiesNV.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_MESH_SHADER_PROPERTIES_NV);
        }
        return ret;
    }

    public static VkPhysicalDeviceMeshShaderPropertiesNV clone(Arena arena, VkPhysicalDeviceMeshShaderPropertiesNV src) {
        VkPhysicalDeviceMeshShaderPropertiesNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_MESH_SHADER_PROPERTIES_NV);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceMeshShaderPropertiesNV sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceMeshShaderPropertiesNV pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceMeshShaderPropertiesNV pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int maxDrawMeshTasksCount() {
        return segment.get(LAYOUT$maxDrawMeshTasksCount, OFFSET$maxDrawMeshTasksCount);
    }

    public VkPhysicalDeviceMeshShaderPropertiesNV maxDrawMeshTasksCount(@Unsigned int value) {
        segment.set(LAYOUT$maxDrawMeshTasksCount, OFFSET$maxDrawMeshTasksCount, value);
        return this;
    }

    public @Unsigned int maxTaskWorkGroupInvocations() {
        return segment.get(LAYOUT$maxTaskWorkGroupInvocations, OFFSET$maxTaskWorkGroupInvocations);
    }

    public VkPhysicalDeviceMeshShaderPropertiesNV maxTaskWorkGroupInvocations(@Unsigned int value) {
        segment.set(LAYOUT$maxTaskWorkGroupInvocations, OFFSET$maxTaskWorkGroupInvocations, value);
        return this;
    }

    public @Unsigned IntPtr maxTaskWorkGroupSize() {
        return new IntPtr(maxTaskWorkGroupSizeRaw());
    }

    public VkPhysicalDeviceMeshShaderPropertiesNV maxTaskWorkGroupSize(@NotNull Consumer<IntPtr> consumer) {
        @Unsigned IntPtr ptr = maxTaskWorkGroupSize();
        consumer.accept(ptr);
        return this;
    }

    public VkPhysicalDeviceMeshShaderPropertiesNV maxTaskWorkGroupSize(@Unsigned IntPtr value) {
        MemorySegment s = maxTaskWorkGroupSizeRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment maxTaskWorkGroupSizeRaw() {
        return segment.asSlice(OFFSET$maxTaskWorkGroupSize, SIZE$maxTaskWorkGroupSize);
    }

    public @Unsigned int maxTaskTotalMemorySize() {
        return segment.get(LAYOUT$maxTaskTotalMemorySize, OFFSET$maxTaskTotalMemorySize);
    }

    public VkPhysicalDeviceMeshShaderPropertiesNV maxTaskTotalMemorySize(@Unsigned int value) {
        segment.set(LAYOUT$maxTaskTotalMemorySize, OFFSET$maxTaskTotalMemorySize, value);
        return this;
    }

    public @Unsigned int maxTaskOutputCount() {
        return segment.get(LAYOUT$maxTaskOutputCount, OFFSET$maxTaskOutputCount);
    }

    public VkPhysicalDeviceMeshShaderPropertiesNV maxTaskOutputCount(@Unsigned int value) {
        segment.set(LAYOUT$maxTaskOutputCount, OFFSET$maxTaskOutputCount, value);
        return this;
    }

    public @Unsigned int maxMeshWorkGroupInvocations() {
        return segment.get(LAYOUT$maxMeshWorkGroupInvocations, OFFSET$maxMeshWorkGroupInvocations);
    }

    public VkPhysicalDeviceMeshShaderPropertiesNV maxMeshWorkGroupInvocations(@Unsigned int value) {
        segment.set(LAYOUT$maxMeshWorkGroupInvocations, OFFSET$maxMeshWorkGroupInvocations, value);
        return this;
    }

    public @Unsigned IntPtr maxMeshWorkGroupSize() {
        return new IntPtr(maxMeshWorkGroupSizeRaw());
    }

    public VkPhysicalDeviceMeshShaderPropertiesNV maxMeshWorkGroupSize(@NotNull Consumer<IntPtr> consumer) {
        @Unsigned IntPtr ptr = maxMeshWorkGroupSize();
        consumer.accept(ptr);
        return this;
    }

    public VkPhysicalDeviceMeshShaderPropertiesNV maxMeshWorkGroupSize(@Unsigned IntPtr value) {
        MemorySegment s = maxMeshWorkGroupSizeRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment maxMeshWorkGroupSizeRaw() {
        return segment.asSlice(OFFSET$maxMeshWorkGroupSize, SIZE$maxMeshWorkGroupSize);
    }

    public @Unsigned int maxMeshTotalMemorySize() {
        return segment.get(LAYOUT$maxMeshTotalMemorySize, OFFSET$maxMeshTotalMemorySize);
    }

    public VkPhysicalDeviceMeshShaderPropertiesNV maxMeshTotalMemorySize(@Unsigned int value) {
        segment.set(LAYOUT$maxMeshTotalMemorySize, OFFSET$maxMeshTotalMemorySize, value);
        return this;
    }

    public @Unsigned int maxMeshOutputVertices() {
        return segment.get(LAYOUT$maxMeshOutputVertices, OFFSET$maxMeshOutputVertices);
    }

    public VkPhysicalDeviceMeshShaderPropertiesNV maxMeshOutputVertices(@Unsigned int value) {
        segment.set(LAYOUT$maxMeshOutputVertices, OFFSET$maxMeshOutputVertices, value);
        return this;
    }

    public @Unsigned int maxMeshOutputPrimitives() {
        return segment.get(LAYOUT$maxMeshOutputPrimitives, OFFSET$maxMeshOutputPrimitives);
    }

    public VkPhysicalDeviceMeshShaderPropertiesNV maxMeshOutputPrimitives(@Unsigned int value) {
        segment.set(LAYOUT$maxMeshOutputPrimitives, OFFSET$maxMeshOutputPrimitives, value);
        return this;
    }

    public @Unsigned int maxMeshMultiviewViewCount() {
        return segment.get(LAYOUT$maxMeshMultiviewViewCount, OFFSET$maxMeshMultiviewViewCount);
    }

    public VkPhysicalDeviceMeshShaderPropertiesNV maxMeshMultiviewViewCount(@Unsigned int value) {
        segment.set(LAYOUT$maxMeshMultiviewViewCount, OFFSET$maxMeshMultiviewViewCount, value);
        return this;
    }

    public @Unsigned int meshOutputPerVertexGranularity() {
        return segment.get(LAYOUT$meshOutputPerVertexGranularity, OFFSET$meshOutputPerVertexGranularity);
    }

    public VkPhysicalDeviceMeshShaderPropertiesNV meshOutputPerVertexGranularity(@Unsigned int value) {
        segment.set(LAYOUT$meshOutputPerVertexGranularity, OFFSET$meshOutputPerVertexGranularity, value);
        return this;
    }

    public @Unsigned int meshOutputPerPrimitiveGranularity() {
        return segment.get(LAYOUT$meshOutputPerPrimitiveGranularity, OFFSET$meshOutputPerPrimitiveGranularity);
    }

    public VkPhysicalDeviceMeshShaderPropertiesNV meshOutputPerPrimitiveGranularity(@Unsigned int value) {
        segment.set(LAYOUT$meshOutputPerPrimitiveGranularity, OFFSET$meshOutputPerPrimitiveGranularity, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("maxDrawMeshTasksCount"),
        ValueLayout.JAVA_INT.withName("maxTaskWorkGroupInvocations"),
        MemoryLayout.sequenceLayout(3, ValueLayout.JAVA_INT).withName("maxTaskWorkGroupSize"),
        ValueLayout.JAVA_INT.withName("maxTaskTotalMemorySize"),
        ValueLayout.JAVA_INT.withName("maxTaskOutputCount"),
        ValueLayout.JAVA_INT.withName("maxMeshWorkGroupInvocations"),
        MemoryLayout.sequenceLayout(3, ValueLayout.JAVA_INT).withName("maxMeshWorkGroupSize"),
        ValueLayout.JAVA_INT.withName("maxMeshTotalMemorySize"),
        ValueLayout.JAVA_INT.withName("maxMeshOutputVertices"),
        ValueLayout.JAVA_INT.withName("maxMeshOutputPrimitives"),
        ValueLayout.JAVA_INT.withName("maxMeshMultiviewViewCount"),
        ValueLayout.JAVA_INT.withName("meshOutputPerVertexGranularity"),
        ValueLayout.JAVA_INT.withName("meshOutputPerPrimitiveGranularity")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$maxDrawMeshTasksCount = PathElement.groupElement("maxDrawMeshTasksCount");
    public static final PathElement PATH$maxTaskWorkGroupInvocations = PathElement.groupElement("maxTaskWorkGroupInvocations");
    public static final PathElement PATH$maxTaskWorkGroupSize = PathElement.groupElement("maxTaskWorkGroupSize");
    public static final PathElement PATH$maxTaskTotalMemorySize = PathElement.groupElement("maxTaskTotalMemorySize");
    public static final PathElement PATH$maxTaskOutputCount = PathElement.groupElement("maxTaskOutputCount");
    public static final PathElement PATH$maxMeshWorkGroupInvocations = PathElement.groupElement("maxMeshWorkGroupInvocations");
    public static final PathElement PATH$maxMeshWorkGroupSize = PathElement.groupElement("maxMeshWorkGroupSize");
    public static final PathElement PATH$maxMeshTotalMemorySize = PathElement.groupElement("maxMeshTotalMemorySize");
    public static final PathElement PATH$maxMeshOutputVertices = PathElement.groupElement("maxMeshOutputVertices");
    public static final PathElement PATH$maxMeshOutputPrimitives = PathElement.groupElement("maxMeshOutputPrimitives");
    public static final PathElement PATH$maxMeshMultiviewViewCount = PathElement.groupElement("maxMeshMultiviewViewCount");
    public static final PathElement PATH$meshOutputPerVertexGranularity = PathElement.groupElement("meshOutputPerVertexGranularity");
    public static final PathElement PATH$meshOutputPerPrimitiveGranularity = PathElement.groupElement("meshOutputPerPrimitiveGranularity");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$maxDrawMeshTasksCount = (OfInt) LAYOUT.select(PATH$maxDrawMeshTasksCount);
    public static final OfInt LAYOUT$maxTaskWorkGroupInvocations = (OfInt) LAYOUT.select(PATH$maxTaskWorkGroupInvocations);
    public static final SequenceLayout LAYOUT$maxTaskWorkGroupSize = (SequenceLayout) LAYOUT.select(PATH$maxTaskWorkGroupSize);
    public static final OfInt LAYOUT$maxTaskTotalMemorySize = (OfInt) LAYOUT.select(PATH$maxTaskTotalMemorySize);
    public static final OfInt LAYOUT$maxTaskOutputCount = (OfInt) LAYOUT.select(PATH$maxTaskOutputCount);
    public static final OfInt LAYOUT$maxMeshWorkGroupInvocations = (OfInt) LAYOUT.select(PATH$maxMeshWorkGroupInvocations);
    public static final SequenceLayout LAYOUT$maxMeshWorkGroupSize = (SequenceLayout) LAYOUT.select(PATH$maxMeshWorkGroupSize);
    public static final OfInt LAYOUT$maxMeshTotalMemorySize = (OfInt) LAYOUT.select(PATH$maxMeshTotalMemorySize);
    public static final OfInt LAYOUT$maxMeshOutputVertices = (OfInt) LAYOUT.select(PATH$maxMeshOutputVertices);
    public static final OfInt LAYOUT$maxMeshOutputPrimitives = (OfInt) LAYOUT.select(PATH$maxMeshOutputPrimitives);
    public static final OfInt LAYOUT$maxMeshMultiviewViewCount = (OfInt) LAYOUT.select(PATH$maxMeshMultiviewViewCount);
    public static final OfInt LAYOUT$meshOutputPerVertexGranularity = (OfInt) LAYOUT.select(PATH$meshOutputPerVertexGranularity);
    public static final OfInt LAYOUT$meshOutputPerPrimitiveGranularity = (OfInt) LAYOUT.select(PATH$meshOutputPerPrimitiveGranularity);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$maxDrawMeshTasksCount = LAYOUT$maxDrawMeshTasksCount.byteSize();
    public static final long SIZE$maxTaskWorkGroupInvocations = LAYOUT$maxTaskWorkGroupInvocations.byteSize();
    public static final long SIZE$maxTaskWorkGroupSize = LAYOUT$maxTaskWorkGroupSize.byteSize();
    public static final long SIZE$maxTaskTotalMemorySize = LAYOUT$maxTaskTotalMemorySize.byteSize();
    public static final long SIZE$maxTaskOutputCount = LAYOUT$maxTaskOutputCount.byteSize();
    public static final long SIZE$maxMeshWorkGroupInvocations = LAYOUT$maxMeshWorkGroupInvocations.byteSize();
    public static final long SIZE$maxMeshWorkGroupSize = LAYOUT$maxMeshWorkGroupSize.byteSize();
    public static final long SIZE$maxMeshTotalMemorySize = LAYOUT$maxMeshTotalMemorySize.byteSize();
    public static final long SIZE$maxMeshOutputVertices = LAYOUT$maxMeshOutputVertices.byteSize();
    public static final long SIZE$maxMeshOutputPrimitives = LAYOUT$maxMeshOutputPrimitives.byteSize();
    public static final long SIZE$maxMeshMultiviewViewCount = LAYOUT$maxMeshMultiviewViewCount.byteSize();
    public static final long SIZE$meshOutputPerVertexGranularity = LAYOUT$meshOutputPerVertexGranularity.byteSize();
    public static final long SIZE$meshOutputPerPrimitiveGranularity = LAYOUT$meshOutputPerPrimitiveGranularity.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$maxDrawMeshTasksCount = LAYOUT.byteOffset(PATH$maxDrawMeshTasksCount);
    public static final long OFFSET$maxTaskWorkGroupInvocations = LAYOUT.byteOffset(PATH$maxTaskWorkGroupInvocations);
    public static final long OFFSET$maxTaskWorkGroupSize = LAYOUT.byteOffset(PATH$maxTaskWorkGroupSize);
    public static final long OFFSET$maxTaskTotalMemorySize = LAYOUT.byteOffset(PATH$maxTaskTotalMemorySize);
    public static final long OFFSET$maxTaskOutputCount = LAYOUT.byteOffset(PATH$maxTaskOutputCount);
    public static final long OFFSET$maxMeshWorkGroupInvocations = LAYOUT.byteOffset(PATH$maxMeshWorkGroupInvocations);
    public static final long OFFSET$maxMeshWorkGroupSize = LAYOUT.byteOffset(PATH$maxMeshWorkGroupSize);
    public static final long OFFSET$maxMeshTotalMemorySize = LAYOUT.byteOffset(PATH$maxMeshTotalMemorySize);
    public static final long OFFSET$maxMeshOutputVertices = LAYOUT.byteOffset(PATH$maxMeshOutputVertices);
    public static final long OFFSET$maxMeshOutputPrimitives = LAYOUT.byteOffset(PATH$maxMeshOutputPrimitives);
    public static final long OFFSET$maxMeshMultiviewViewCount = LAYOUT.byteOffset(PATH$maxMeshMultiviewViewCount);
    public static final long OFFSET$meshOutputPerVertexGranularity = LAYOUT.byteOffset(PATH$meshOutputPerVertexGranularity);
    public static final long OFFSET$meshOutputPerPrimitiveGranularity = LAYOUT.byteOffset(PATH$meshOutputPerPrimitiveGranularity);
}
