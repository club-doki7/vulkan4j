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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT.html"><code>VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkRayTracingInvocationReorderModeEXT rayTracingInvocationReorderReorderingHint; // @link substring="VkRayTracingInvocationReorderModeEXT" target="VkRayTracingInvocationReorderModeEXT" @link substring="rayTracingInvocationReorderReorderingHint" target="#rayTracingInvocationReorderReorderingHint"
///     uint32_t maxShaderBindingTableRecordIndex; // @link substring="maxShaderBindingTableRecordIndex" target="#maxShaderBindingTableRecordIndex"
/// } VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_RAY_TRACING_INVOCATION_REORDER_PROPERTIES_EXT`
///
/// The {@code allocate} ({@link VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT#allocate(Arena)}, {@link VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT.html"><code>VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT(@NotNull MemorySegment segment) implements IVkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT.html"><code>VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT, Iterable<VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT at(long index) {
            return new VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT(segment.asSlice(index * VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT.BYTES, VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT.BYTES));
        }

        public VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT.BYTES, VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT.BYTES,
                (end - start) * VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT.BYTES));
        }

        public VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT[] toArray() {
            VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT[] ret = new VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT.BYTES;
            }

            @Override
            public VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT ret = new VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT(segment.asSlice(0, VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT allocate(Arena arena) {
        VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT ret = new VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_RAY_TRACING_INVOCATION_REORDER_PROPERTIES_EXT);
        return ret;
    }

    public static VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT.Ptr ret = new VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_RAY_TRACING_INVOCATION_REORDER_PROPERTIES_EXT);
        }
        return ret;
    }

    public static VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT clone(Arena arena, VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT src) {
        VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_RAY_TRACING_INVOCATION_REORDER_PROPERTIES_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @EnumType(VkRayTracingInvocationReorderModeEXT.class) int rayTracingInvocationReorderReorderingHint() {
        return segment.get(LAYOUT$rayTracingInvocationReorderReorderingHint, OFFSET$rayTracingInvocationReorderReorderingHint);
    }

    public VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT rayTracingInvocationReorderReorderingHint(@EnumType(VkRayTracingInvocationReorderModeEXT.class) int value) {
        segment.set(LAYOUT$rayTracingInvocationReorderReorderingHint, OFFSET$rayTracingInvocationReorderReorderingHint, value);
        return this;
    }

    public @Unsigned int maxShaderBindingTableRecordIndex() {
        return segment.get(LAYOUT$maxShaderBindingTableRecordIndex, OFFSET$maxShaderBindingTableRecordIndex);
    }

    public VkPhysicalDeviceRayTracingInvocationReorderPropertiesEXT maxShaderBindingTableRecordIndex(@Unsigned int value) {
        segment.set(LAYOUT$maxShaderBindingTableRecordIndex, OFFSET$maxShaderBindingTableRecordIndex, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("rayTracingInvocationReorderReorderingHint"),
        ValueLayout.JAVA_INT.withName("maxShaderBindingTableRecordIndex")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$rayTracingInvocationReorderReorderingHint = PathElement.groupElement("rayTracingInvocationReorderReorderingHint");
    public static final PathElement PATH$maxShaderBindingTableRecordIndex = PathElement.groupElement("maxShaderBindingTableRecordIndex");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$rayTracingInvocationReorderReorderingHint = (OfInt) LAYOUT.select(PATH$rayTracingInvocationReorderReorderingHint);
    public static final OfInt LAYOUT$maxShaderBindingTableRecordIndex = (OfInt) LAYOUT.select(PATH$maxShaderBindingTableRecordIndex);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$rayTracingInvocationReorderReorderingHint = LAYOUT$rayTracingInvocationReorderReorderingHint.byteSize();
    public static final long SIZE$maxShaderBindingTableRecordIndex = LAYOUT$maxShaderBindingTableRecordIndex.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$rayTracingInvocationReorderReorderingHint = LAYOUT.byteOffset(PATH$rayTracingInvocationReorderReorderingHint);
    public static final long OFFSET$maxShaderBindingTableRecordIndex = LAYOUT.byteOffset(PATH$maxShaderBindingTableRecordIndex);
}
