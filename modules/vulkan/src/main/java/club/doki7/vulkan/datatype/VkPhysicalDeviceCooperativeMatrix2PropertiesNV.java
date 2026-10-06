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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceCooperativeMatrix2PropertiesNV.html"><code>VkPhysicalDeviceCooperativeMatrix2PropertiesNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceCooperativeMatrix2PropertiesNV {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t cooperativeMatrixWorkgroupScopeMaxWorkgroupSize; // @link substring="cooperativeMatrixWorkgroupScopeMaxWorkgroupSize" target="#cooperativeMatrixWorkgroupScopeMaxWorkgroupSize"
///     uint32_t cooperativeMatrixFlexibleDimensionsMaxDimension; // @link substring="cooperativeMatrixFlexibleDimensionsMaxDimension" target="#cooperativeMatrixFlexibleDimensionsMaxDimension"
///     uint32_t cooperativeMatrixWorkgroupScopeReservedSharedMemory; // @link substring="cooperativeMatrixWorkgroupScopeReservedSharedMemory" target="#cooperativeMatrixWorkgroupScopeReservedSharedMemory"
/// } VkPhysicalDeviceCooperativeMatrix2PropertiesNV;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_COOPERATIVE_MATRIX_2_PROPERTIES_NV`
///
/// The {@code allocate} ({@link VkPhysicalDeviceCooperativeMatrix2PropertiesNV#allocate(Arena)}, {@link VkPhysicalDeviceCooperativeMatrix2PropertiesNV#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceCooperativeMatrix2PropertiesNV#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceCooperativeMatrix2PropertiesNV.html"><code>VkPhysicalDeviceCooperativeMatrix2PropertiesNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceCooperativeMatrix2PropertiesNV(@NotNull MemorySegment segment) implements IVkPhysicalDeviceCooperativeMatrix2PropertiesNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceCooperativeMatrix2PropertiesNV.html"><code>VkPhysicalDeviceCooperativeMatrix2PropertiesNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceCooperativeMatrix2PropertiesNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceCooperativeMatrix2PropertiesNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceCooperativeMatrix2PropertiesNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceCooperativeMatrix2PropertiesNV, Iterable<VkPhysicalDeviceCooperativeMatrix2PropertiesNV> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceCooperativeMatrix2PropertiesNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceCooperativeMatrix2PropertiesNV at(long index) {
            return new VkPhysicalDeviceCooperativeMatrix2PropertiesNV(segment.asSlice(index * VkPhysicalDeviceCooperativeMatrix2PropertiesNV.BYTES, VkPhysicalDeviceCooperativeMatrix2PropertiesNV.BYTES));
        }

        public VkPhysicalDeviceCooperativeMatrix2PropertiesNV.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceCooperativeMatrix2PropertiesNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceCooperativeMatrix2PropertiesNV value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceCooperativeMatrix2PropertiesNV.BYTES, VkPhysicalDeviceCooperativeMatrix2PropertiesNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceCooperativeMatrix2PropertiesNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceCooperativeMatrix2PropertiesNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceCooperativeMatrix2PropertiesNV.BYTES,
                (end - start) * VkPhysicalDeviceCooperativeMatrix2PropertiesNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceCooperativeMatrix2PropertiesNV.BYTES));
        }

        public VkPhysicalDeviceCooperativeMatrix2PropertiesNV[] toArray() {
            VkPhysicalDeviceCooperativeMatrix2PropertiesNV[] ret = new VkPhysicalDeviceCooperativeMatrix2PropertiesNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceCooperativeMatrix2PropertiesNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceCooperativeMatrix2PropertiesNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceCooperativeMatrix2PropertiesNV.BYTES;
            }

            @Override
            public VkPhysicalDeviceCooperativeMatrix2PropertiesNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceCooperativeMatrix2PropertiesNV ret = new VkPhysicalDeviceCooperativeMatrix2PropertiesNV(segment.asSlice(0, VkPhysicalDeviceCooperativeMatrix2PropertiesNV.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceCooperativeMatrix2PropertiesNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceCooperativeMatrix2PropertiesNV allocate(Arena arena) {
        VkPhysicalDeviceCooperativeMatrix2PropertiesNV ret = new VkPhysicalDeviceCooperativeMatrix2PropertiesNV(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_COOPERATIVE_MATRIX_2_PROPERTIES_NV);
        return ret;
    }

    public static VkPhysicalDeviceCooperativeMatrix2PropertiesNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceCooperativeMatrix2PropertiesNV.Ptr ret = new VkPhysicalDeviceCooperativeMatrix2PropertiesNV.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_COOPERATIVE_MATRIX_2_PROPERTIES_NV);
        }
        return ret;
    }

    public static VkPhysicalDeviceCooperativeMatrix2PropertiesNV clone(Arena arena, VkPhysicalDeviceCooperativeMatrix2PropertiesNV src) {
        VkPhysicalDeviceCooperativeMatrix2PropertiesNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_COOPERATIVE_MATRIX_2_PROPERTIES_NV);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceCooperativeMatrix2PropertiesNV sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceCooperativeMatrix2PropertiesNV pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceCooperativeMatrix2PropertiesNV pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int cooperativeMatrixWorkgroupScopeMaxWorkgroupSize() {
        return segment.get(LAYOUT$cooperativeMatrixWorkgroupScopeMaxWorkgroupSize, OFFSET$cooperativeMatrixWorkgroupScopeMaxWorkgroupSize);
    }

    public VkPhysicalDeviceCooperativeMatrix2PropertiesNV cooperativeMatrixWorkgroupScopeMaxWorkgroupSize(@Unsigned int value) {
        segment.set(LAYOUT$cooperativeMatrixWorkgroupScopeMaxWorkgroupSize, OFFSET$cooperativeMatrixWorkgroupScopeMaxWorkgroupSize, value);
        return this;
    }

    public @Unsigned int cooperativeMatrixFlexibleDimensionsMaxDimension() {
        return segment.get(LAYOUT$cooperativeMatrixFlexibleDimensionsMaxDimension, OFFSET$cooperativeMatrixFlexibleDimensionsMaxDimension);
    }

    public VkPhysicalDeviceCooperativeMatrix2PropertiesNV cooperativeMatrixFlexibleDimensionsMaxDimension(@Unsigned int value) {
        segment.set(LAYOUT$cooperativeMatrixFlexibleDimensionsMaxDimension, OFFSET$cooperativeMatrixFlexibleDimensionsMaxDimension, value);
        return this;
    }

    public @Unsigned int cooperativeMatrixWorkgroupScopeReservedSharedMemory() {
        return segment.get(LAYOUT$cooperativeMatrixWorkgroupScopeReservedSharedMemory, OFFSET$cooperativeMatrixWorkgroupScopeReservedSharedMemory);
    }

    public VkPhysicalDeviceCooperativeMatrix2PropertiesNV cooperativeMatrixWorkgroupScopeReservedSharedMemory(@Unsigned int value) {
        segment.set(LAYOUT$cooperativeMatrixWorkgroupScopeReservedSharedMemory, OFFSET$cooperativeMatrixWorkgroupScopeReservedSharedMemory, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("cooperativeMatrixWorkgroupScopeMaxWorkgroupSize"),
        ValueLayout.JAVA_INT.withName("cooperativeMatrixFlexibleDimensionsMaxDimension"),
        ValueLayout.JAVA_INT.withName("cooperativeMatrixWorkgroupScopeReservedSharedMemory")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$cooperativeMatrixWorkgroupScopeMaxWorkgroupSize = PathElement.groupElement("cooperativeMatrixWorkgroupScopeMaxWorkgroupSize");
    public static final PathElement PATH$cooperativeMatrixFlexibleDimensionsMaxDimension = PathElement.groupElement("cooperativeMatrixFlexibleDimensionsMaxDimension");
    public static final PathElement PATH$cooperativeMatrixWorkgroupScopeReservedSharedMemory = PathElement.groupElement("cooperativeMatrixWorkgroupScopeReservedSharedMemory");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$cooperativeMatrixWorkgroupScopeMaxWorkgroupSize = (OfInt) LAYOUT.select(PATH$cooperativeMatrixWorkgroupScopeMaxWorkgroupSize);
    public static final OfInt LAYOUT$cooperativeMatrixFlexibleDimensionsMaxDimension = (OfInt) LAYOUT.select(PATH$cooperativeMatrixFlexibleDimensionsMaxDimension);
    public static final OfInt LAYOUT$cooperativeMatrixWorkgroupScopeReservedSharedMemory = (OfInt) LAYOUT.select(PATH$cooperativeMatrixWorkgroupScopeReservedSharedMemory);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$cooperativeMatrixWorkgroupScopeMaxWorkgroupSize = LAYOUT$cooperativeMatrixWorkgroupScopeMaxWorkgroupSize.byteSize();
    public static final long SIZE$cooperativeMatrixFlexibleDimensionsMaxDimension = LAYOUT$cooperativeMatrixFlexibleDimensionsMaxDimension.byteSize();
    public static final long SIZE$cooperativeMatrixWorkgroupScopeReservedSharedMemory = LAYOUT$cooperativeMatrixWorkgroupScopeReservedSharedMemory.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$cooperativeMatrixWorkgroupScopeMaxWorkgroupSize = LAYOUT.byteOffset(PATH$cooperativeMatrixWorkgroupScopeMaxWorkgroupSize);
    public static final long OFFSET$cooperativeMatrixFlexibleDimensionsMaxDimension = LAYOUT.byteOffset(PATH$cooperativeMatrixFlexibleDimensionsMaxDimension);
    public static final long OFFSET$cooperativeMatrixWorkgroupScopeReservedSharedMemory = LAYOUT.byteOffset(PATH$cooperativeMatrixWorkgroupScopeReservedSharedMemory);
}
