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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceShaderEnqueuePropertiesAMDX.html"><code>VkPhysicalDeviceShaderEnqueuePropertiesAMDX</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceShaderEnqueuePropertiesAMDX {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t maxExecutionGraphDepth; // @link substring="maxExecutionGraphDepth" target="#maxExecutionGraphDepth"
///     uint32_t maxExecutionGraphShaderOutputNodes; // @link substring="maxExecutionGraphShaderOutputNodes" target="#maxExecutionGraphShaderOutputNodes"
///     uint32_t maxExecutionGraphShaderPayloadSize; // @link substring="maxExecutionGraphShaderPayloadSize" target="#maxExecutionGraphShaderPayloadSize"
///     uint32_t maxExecutionGraphShaderPayloadCount; // @link substring="maxExecutionGraphShaderPayloadCount" target="#maxExecutionGraphShaderPayloadCount"
///     uint32_t executionGraphDispatchAddressAlignment; // @link substring="executionGraphDispatchAddressAlignment" target="#executionGraphDispatchAddressAlignment"
///     uint32_t[3] maxExecutionGraphWorkgroupCount; // @link substring="maxExecutionGraphWorkgroupCount" target="#maxExecutionGraphWorkgroupCount"
///     uint32_t maxExecutionGraphWorkgroups; // @link substring="maxExecutionGraphWorkgroups" target="#maxExecutionGraphWorkgroups"
/// } VkPhysicalDeviceShaderEnqueuePropertiesAMDX;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SHADER_ENQUEUE_PROPERTIES_AMDX`
///
/// The {@code allocate} ({@link VkPhysicalDeviceShaderEnqueuePropertiesAMDX#allocate(Arena)}, {@link VkPhysicalDeviceShaderEnqueuePropertiesAMDX#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceShaderEnqueuePropertiesAMDX#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceShaderEnqueuePropertiesAMDX.html"><code>VkPhysicalDeviceShaderEnqueuePropertiesAMDX</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceShaderEnqueuePropertiesAMDX(@NotNull MemorySegment segment) implements IVkPhysicalDeviceShaderEnqueuePropertiesAMDX {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceShaderEnqueuePropertiesAMDX.html"><code>VkPhysicalDeviceShaderEnqueuePropertiesAMDX</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceShaderEnqueuePropertiesAMDX}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceShaderEnqueuePropertiesAMDX to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceShaderEnqueuePropertiesAMDX.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceShaderEnqueuePropertiesAMDX, Iterable<VkPhysicalDeviceShaderEnqueuePropertiesAMDX> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceShaderEnqueuePropertiesAMDX.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceShaderEnqueuePropertiesAMDX at(long index) {
            return new VkPhysicalDeviceShaderEnqueuePropertiesAMDX(segment.asSlice(index * VkPhysicalDeviceShaderEnqueuePropertiesAMDX.BYTES, VkPhysicalDeviceShaderEnqueuePropertiesAMDX.BYTES));
        }

        public VkPhysicalDeviceShaderEnqueuePropertiesAMDX.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceShaderEnqueuePropertiesAMDX> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceShaderEnqueuePropertiesAMDX value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceShaderEnqueuePropertiesAMDX.BYTES, VkPhysicalDeviceShaderEnqueuePropertiesAMDX.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceShaderEnqueuePropertiesAMDX.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceShaderEnqueuePropertiesAMDX.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceShaderEnqueuePropertiesAMDX.BYTES,
                (end - start) * VkPhysicalDeviceShaderEnqueuePropertiesAMDX.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceShaderEnqueuePropertiesAMDX.BYTES));
        }

        public VkPhysicalDeviceShaderEnqueuePropertiesAMDX[] toArray() {
            VkPhysicalDeviceShaderEnqueuePropertiesAMDX[] ret = new VkPhysicalDeviceShaderEnqueuePropertiesAMDX[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceShaderEnqueuePropertiesAMDX> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceShaderEnqueuePropertiesAMDX> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceShaderEnqueuePropertiesAMDX.BYTES;
            }

            @Override
            public VkPhysicalDeviceShaderEnqueuePropertiesAMDX next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceShaderEnqueuePropertiesAMDX ret = new VkPhysicalDeviceShaderEnqueuePropertiesAMDX(segment.asSlice(0, VkPhysicalDeviceShaderEnqueuePropertiesAMDX.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceShaderEnqueuePropertiesAMDX.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceShaderEnqueuePropertiesAMDX allocate(Arena arena) {
        VkPhysicalDeviceShaderEnqueuePropertiesAMDX ret = new VkPhysicalDeviceShaderEnqueuePropertiesAMDX(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_SHADER_ENQUEUE_PROPERTIES_AMDX);
        return ret;
    }

    public static VkPhysicalDeviceShaderEnqueuePropertiesAMDX.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceShaderEnqueuePropertiesAMDX.Ptr ret = new VkPhysicalDeviceShaderEnqueuePropertiesAMDX.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_SHADER_ENQUEUE_PROPERTIES_AMDX);
        }
        return ret;
    }

    public static VkPhysicalDeviceShaderEnqueuePropertiesAMDX clone(Arena arena, VkPhysicalDeviceShaderEnqueuePropertiesAMDX src) {
        VkPhysicalDeviceShaderEnqueuePropertiesAMDX ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_SHADER_ENQUEUE_PROPERTIES_AMDX);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceShaderEnqueuePropertiesAMDX sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceShaderEnqueuePropertiesAMDX pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceShaderEnqueuePropertiesAMDX pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int maxExecutionGraphDepth() {
        return segment.get(LAYOUT$maxExecutionGraphDepth, OFFSET$maxExecutionGraphDepth);
    }

    public VkPhysicalDeviceShaderEnqueuePropertiesAMDX maxExecutionGraphDepth(@Unsigned int value) {
        segment.set(LAYOUT$maxExecutionGraphDepth, OFFSET$maxExecutionGraphDepth, value);
        return this;
    }

    public @Unsigned int maxExecutionGraphShaderOutputNodes() {
        return segment.get(LAYOUT$maxExecutionGraphShaderOutputNodes, OFFSET$maxExecutionGraphShaderOutputNodes);
    }

    public VkPhysicalDeviceShaderEnqueuePropertiesAMDX maxExecutionGraphShaderOutputNodes(@Unsigned int value) {
        segment.set(LAYOUT$maxExecutionGraphShaderOutputNodes, OFFSET$maxExecutionGraphShaderOutputNodes, value);
        return this;
    }

    public @Unsigned int maxExecutionGraphShaderPayloadSize() {
        return segment.get(LAYOUT$maxExecutionGraphShaderPayloadSize, OFFSET$maxExecutionGraphShaderPayloadSize);
    }

    public VkPhysicalDeviceShaderEnqueuePropertiesAMDX maxExecutionGraphShaderPayloadSize(@Unsigned int value) {
        segment.set(LAYOUT$maxExecutionGraphShaderPayloadSize, OFFSET$maxExecutionGraphShaderPayloadSize, value);
        return this;
    }

    public @Unsigned int maxExecutionGraphShaderPayloadCount() {
        return segment.get(LAYOUT$maxExecutionGraphShaderPayloadCount, OFFSET$maxExecutionGraphShaderPayloadCount);
    }

    public VkPhysicalDeviceShaderEnqueuePropertiesAMDX maxExecutionGraphShaderPayloadCount(@Unsigned int value) {
        segment.set(LAYOUT$maxExecutionGraphShaderPayloadCount, OFFSET$maxExecutionGraphShaderPayloadCount, value);
        return this;
    }

    public @Unsigned int executionGraphDispatchAddressAlignment() {
        return segment.get(LAYOUT$executionGraphDispatchAddressAlignment, OFFSET$executionGraphDispatchAddressAlignment);
    }

    public VkPhysicalDeviceShaderEnqueuePropertiesAMDX executionGraphDispatchAddressAlignment(@Unsigned int value) {
        segment.set(LAYOUT$executionGraphDispatchAddressAlignment, OFFSET$executionGraphDispatchAddressAlignment, value);
        return this;
    }

    public @Unsigned IntPtr maxExecutionGraphWorkgroupCount() {
        return new IntPtr(maxExecutionGraphWorkgroupCountRaw());
    }

    public VkPhysicalDeviceShaderEnqueuePropertiesAMDX maxExecutionGraphWorkgroupCount(@NotNull Consumer<IntPtr> consumer) {
        @Unsigned IntPtr ptr = maxExecutionGraphWorkgroupCount();
        consumer.accept(ptr);
        return this;
    }

    public VkPhysicalDeviceShaderEnqueuePropertiesAMDX maxExecutionGraphWorkgroupCount(@Unsigned IntPtr value) {
        MemorySegment s = maxExecutionGraphWorkgroupCountRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment maxExecutionGraphWorkgroupCountRaw() {
        return segment.asSlice(OFFSET$maxExecutionGraphWorkgroupCount, SIZE$maxExecutionGraphWorkgroupCount);
    }

    public @Unsigned int maxExecutionGraphWorkgroups() {
        return segment.get(LAYOUT$maxExecutionGraphWorkgroups, OFFSET$maxExecutionGraphWorkgroups);
    }

    public VkPhysicalDeviceShaderEnqueuePropertiesAMDX maxExecutionGraphWorkgroups(@Unsigned int value) {
        segment.set(LAYOUT$maxExecutionGraphWorkgroups, OFFSET$maxExecutionGraphWorkgroups, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("maxExecutionGraphDepth"),
        ValueLayout.JAVA_INT.withName("maxExecutionGraphShaderOutputNodes"),
        ValueLayout.JAVA_INT.withName("maxExecutionGraphShaderPayloadSize"),
        ValueLayout.JAVA_INT.withName("maxExecutionGraphShaderPayloadCount"),
        ValueLayout.JAVA_INT.withName("executionGraphDispatchAddressAlignment"),
        MemoryLayout.sequenceLayout(3, ValueLayout.JAVA_INT).withName("maxExecutionGraphWorkgroupCount"),
        ValueLayout.JAVA_INT.withName("maxExecutionGraphWorkgroups")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$maxExecutionGraphDepth = PathElement.groupElement("maxExecutionGraphDepth");
    public static final PathElement PATH$maxExecutionGraphShaderOutputNodes = PathElement.groupElement("maxExecutionGraphShaderOutputNodes");
    public static final PathElement PATH$maxExecutionGraphShaderPayloadSize = PathElement.groupElement("maxExecutionGraphShaderPayloadSize");
    public static final PathElement PATH$maxExecutionGraphShaderPayloadCount = PathElement.groupElement("maxExecutionGraphShaderPayloadCount");
    public static final PathElement PATH$executionGraphDispatchAddressAlignment = PathElement.groupElement("executionGraphDispatchAddressAlignment");
    public static final PathElement PATH$maxExecutionGraphWorkgroupCount = PathElement.groupElement("maxExecutionGraphWorkgroupCount");
    public static final PathElement PATH$maxExecutionGraphWorkgroups = PathElement.groupElement("maxExecutionGraphWorkgroups");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$maxExecutionGraphDepth = (OfInt) LAYOUT.select(PATH$maxExecutionGraphDepth);
    public static final OfInt LAYOUT$maxExecutionGraphShaderOutputNodes = (OfInt) LAYOUT.select(PATH$maxExecutionGraphShaderOutputNodes);
    public static final OfInt LAYOUT$maxExecutionGraphShaderPayloadSize = (OfInt) LAYOUT.select(PATH$maxExecutionGraphShaderPayloadSize);
    public static final OfInt LAYOUT$maxExecutionGraphShaderPayloadCount = (OfInt) LAYOUT.select(PATH$maxExecutionGraphShaderPayloadCount);
    public static final OfInt LAYOUT$executionGraphDispatchAddressAlignment = (OfInt) LAYOUT.select(PATH$executionGraphDispatchAddressAlignment);
    public static final SequenceLayout LAYOUT$maxExecutionGraphWorkgroupCount = (SequenceLayout) LAYOUT.select(PATH$maxExecutionGraphWorkgroupCount);
    public static final OfInt LAYOUT$maxExecutionGraphWorkgroups = (OfInt) LAYOUT.select(PATH$maxExecutionGraphWorkgroups);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$maxExecutionGraphDepth = LAYOUT$maxExecutionGraphDepth.byteSize();
    public static final long SIZE$maxExecutionGraphShaderOutputNodes = LAYOUT$maxExecutionGraphShaderOutputNodes.byteSize();
    public static final long SIZE$maxExecutionGraphShaderPayloadSize = LAYOUT$maxExecutionGraphShaderPayloadSize.byteSize();
    public static final long SIZE$maxExecutionGraphShaderPayloadCount = LAYOUT$maxExecutionGraphShaderPayloadCount.byteSize();
    public static final long SIZE$executionGraphDispatchAddressAlignment = LAYOUT$executionGraphDispatchAddressAlignment.byteSize();
    public static final long SIZE$maxExecutionGraphWorkgroupCount = LAYOUT$maxExecutionGraphWorkgroupCount.byteSize();
    public static final long SIZE$maxExecutionGraphWorkgroups = LAYOUT$maxExecutionGraphWorkgroups.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$maxExecutionGraphDepth = LAYOUT.byteOffset(PATH$maxExecutionGraphDepth);
    public static final long OFFSET$maxExecutionGraphShaderOutputNodes = LAYOUT.byteOffset(PATH$maxExecutionGraphShaderOutputNodes);
    public static final long OFFSET$maxExecutionGraphShaderPayloadSize = LAYOUT.byteOffset(PATH$maxExecutionGraphShaderPayloadSize);
    public static final long OFFSET$maxExecutionGraphShaderPayloadCount = LAYOUT.byteOffset(PATH$maxExecutionGraphShaderPayloadCount);
    public static final long OFFSET$executionGraphDispatchAddressAlignment = LAYOUT.byteOffset(PATH$executionGraphDispatchAddressAlignment);
    public static final long OFFSET$maxExecutionGraphWorkgroupCount = LAYOUT.byteOffset(PATH$maxExecutionGraphWorkgroupCount);
    public static final long OFFSET$maxExecutionGraphWorkgroups = LAYOUT.byteOffset(PATH$maxExecutionGraphWorkgroups);
}
