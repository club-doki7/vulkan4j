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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceFragmentDensityMapPropertiesEXT.html"><code>VkPhysicalDeviceFragmentDensityMapPropertiesEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceFragmentDensityMapPropertiesEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkExtent2D minFragmentDensityTexelSize; // @link substring="VkExtent2D" target="VkExtent2D" @link substring="minFragmentDensityTexelSize" target="#minFragmentDensityTexelSize"
///     VkExtent2D maxFragmentDensityTexelSize; // @link substring="VkExtent2D" target="VkExtent2D" @link substring="maxFragmentDensityTexelSize" target="#maxFragmentDensityTexelSize"
///     VkBool32 fragmentDensityInvocations; // @link substring="fragmentDensityInvocations" target="#fragmentDensityInvocations"
/// } VkPhysicalDeviceFragmentDensityMapPropertiesEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_FRAGMENT_DENSITY_MAP_PROPERTIES_EXT`
///
/// The {@code allocate} ({@link VkPhysicalDeviceFragmentDensityMapPropertiesEXT#allocate(Arena)}, {@link VkPhysicalDeviceFragmentDensityMapPropertiesEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceFragmentDensityMapPropertiesEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceFragmentDensityMapPropertiesEXT.html"><code>VkPhysicalDeviceFragmentDensityMapPropertiesEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceFragmentDensityMapPropertiesEXT(@NotNull MemorySegment segment) implements IVkPhysicalDeviceFragmentDensityMapPropertiesEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceFragmentDensityMapPropertiesEXT.html"><code>VkPhysicalDeviceFragmentDensityMapPropertiesEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceFragmentDensityMapPropertiesEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceFragmentDensityMapPropertiesEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceFragmentDensityMapPropertiesEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceFragmentDensityMapPropertiesEXT, Iterable<VkPhysicalDeviceFragmentDensityMapPropertiesEXT> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceFragmentDensityMapPropertiesEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceFragmentDensityMapPropertiesEXT at(long index) {
            return new VkPhysicalDeviceFragmentDensityMapPropertiesEXT(segment.asSlice(index * VkPhysicalDeviceFragmentDensityMapPropertiesEXT.BYTES, VkPhysicalDeviceFragmentDensityMapPropertiesEXT.BYTES));
        }

        public VkPhysicalDeviceFragmentDensityMapPropertiesEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceFragmentDensityMapPropertiesEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceFragmentDensityMapPropertiesEXT value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceFragmentDensityMapPropertiesEXT.BYTES, VkPhysicalDeviceFragmentDensityMapPropertiesEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceFragmentDensityMapPropertiesEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceFragmentDensityMapPropertiesEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceFragmentDensityMapPropertiesEXT.BYTES,
                (end - start) * VkPhysicalDeviceFragmentDensityMapPropertiesEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceFragmentDensityMapPropertiesEXT.BYTES));
        }

        public VkPhysicalDeviceFragmentDensityMapPropertiesEXT[] toArray() {
            VkPhysicalDeviceFragmentDensityMapPropertiesEXT[] ret = new VkPhysicalDeviceFragmentDensityMapPropertiesEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceFragmentDensityMapPropertiesEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceFragmentDensityMapPropertiesEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceFragmentDensityMapPropertiesEXT.BYTES;
            }

            @Override
            public VkPhysicalDeviceFragmentDensityMapPropertiesEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceFragmentDensityMapPropertiesEXT ret = new VkPhysicalDeviceFragmentDensityMapPropertiesEXT(segment.asSlice(0, VkPhysicalDeviceFragmentDensityMapPropertiesEXT.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceFragmentDensityMapPropertiesEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceFragmentDensityMapPropertiesEXT allocate(Arena arena) {
        VkPhysicalDeviceFragmentDensityMapPropertiesEXT ret = new VkPhysicalDeviceFragmentDensityMapPropertiesEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_FRAGMENT_DENSITY_MAP_PROPERTIES_EXT);
        return ret;
    }

    public static VkPhysicalDeviceFragmentDensityMapPropertiesEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceFragmentDensityMapPropertiesEXT.Ptr ret = new VkPhysicalDeviceFragmentDensityMapPropertiesEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_FRAGMENT_DENSITY_MAP_PROPERTIES_EXT);
        }
        return ret;
    }

    public static VkPhysicalDeviceFragmentDensityMapPropertiesEXT clone(Arena arena, VkPhysicalDeviceFragmentDensityMapPropertiesEXT src) {
        VkPhysicalDeviceFragmentDensityMapPropertiesEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_FRAGMENT_DENSITY_MAP_PROPERTIES_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceFragmentDensityMapPropertiesEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceFragmentDensityMapPropertiesEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceFragmentDensityMapPropertiesEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NotNull VkExtent2D minFragmentDensityTexelSize() {
        return new VkExtent2D(segment.asSlice(OFFSET$minFragmentDensityTexelSize, LAYOUT$minFragmentDensityTexelSize));
    }

    public VkPhysicalDeviceFragmentDensityMapPropertiesEXT minFragmentDensityTexelSize(@NotNull VkExtent2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$minFragmentDensityTexelSize, SIZE$minFragmentDensityTexelSize);
        return this;
    }

    public VkPhysicalDeviceFragmentDensityMapPropertiesEXT minFragmentDensityTexelSize(Consumer<@NotNull VkExtent2D> consumer) {
        consumer.accept(minFragmentDensityTexelSize());
        return this;
    }

    public @NotNull VkExtent2D maxFragmentDensityTexelSize() {
        return new VkExtent2D(segment.asSlice(OFFSET$maxFragmentDensityTexelSize, LAYOUT$maxFragmentDensityTexelSize));
    }

    public VkPhysicalDeviceFragmentDensityMapPropertiesEXT maxFragmentDensityTexelSize(@NotNull VkExtent2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$maxFragmentDensityTexelSize, SIZE$maxFragmentDensityTexelSize);
        return this;
    }

    public VkPhysicalDeviceFragmentDensityMapPropertiesEXT maxFragmentDensityTexelSize(Consumer<@NotNull VkExtent2D> consumer) {
        consumer.accept(maxFragmentDensityTexelSize());
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int fragmentDensityInvocations() {
        return segment.get(LAYOUT$fragmentDensityInvocations, OFFSET$fragmentDensityInvocations);
    }

    public VkPhysicalDeviceFragmentDensityMapPropertiesEXT fragmentDensityInvocations(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$fragmentDensityInvocations, OFFSET$fragmentDensityInvocations, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        VkExtent2D.LAYOUT.withName("minFragmentDensityTexelSize"),
        VkExtent2D.LAYOUT.withName("maxFragmentDensityTexelSize"),
        ValueLayout.JAVA_INT.withName("fragmentDensityInvocations")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$minFragmentDensityTexelSize = PathElement.groupElement("minFragmentDensityTexelSize");
    public static final PathElement PATH$maxFragmentDensityTexelSize = PathElement.groupElement("maxFragmentDensityTexelSize");
    public static final PathElement PATH$fragmentDensityInvocations = PathElement.groupElement("fragmentDensityInvocations");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final StructLayout LAYOUT$minFragmentDensityTexelSize = (StructLayout) LAYOUT.select(PATH$minFragmentDensityTexelSize);
    public static final StructLayout LAYOUT$maxFragmentDensityTexelSize = (StructLayout) LAYOUT.select(PATH$maxFragmentDensityTexelSize);
    public static final OfInt LAYOUT$fragmentDensityInvocations = (OfInt) LAYOUT.select(PATH$fragmentDensityInvocations);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$minFragmentDensityTexelSize = LAYOUT$minFragmentDensityTexelSize.byteSize();
    public static final long SIZE$maxFragmentDensityTexelSize = LAYOUT$maxFragmentDensityTexelSize.byteSize();
    public static final long SIZE$fragmentDensityInvocations = LAYOUT$fragmentDensityInvocations.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$minFragmentDensityTexelSize = LAYOUT.byteOffset(PATH$minFragmentDensityTexelSize);
    public static final long OFFSET$maxFragmentDensityTexelSize = LAYOUT.byteOffset(PATH$maxFragmentDensityTexelSize);
    public static final long OFFSET$fragmentDensityInvocations = LAYOUT.byteOffset(PATH$fragmentDensityInvocations);
}
