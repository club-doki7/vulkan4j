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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV.html"><code>VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkDeviceSize extendedSparseAddressSpaceSize; // @link substring="extendedSparseAddressSpaceSize" target="#extendedSparseAddressSpaceSize"
///     VkImageUsageFlags extendedSparseImageUsageFlags; // @link substring="VkImageUsageFlags" target="VkImageUsageFlags" @link substring="extendedSparseImageUsageFlags" target="#extendedSparseImageUsageFlags"
///     VkBufferUsageFlags extendedSparseBufferUsageFlags; // @link substring="VkBufferUsageFlags" target="VkBufferUsageFlags" @link substring="extendedSparseBufferUsageFlags" target="#extendedSparseBufferUsageFlags"
/// } VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_EXTENDED_SPARSE_ADDRESS_SPACE_PROPERTIES_NV`
///
/// The {@code allocate} ({@link VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV#allocate(Arena)}, {@link VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV.html"><code>VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV(@NotNull MemorySegment segment) implements IVkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV.html"><code>VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV, Iterable<VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV at(long index) {
            return new VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV(segment.asSlice(index * VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV.BYTES, VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV.BYTES));
        }

        public VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV.BYTES, VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV.BYTES,
                (end - start) * VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV.BYTES));
        }

        public VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV[] toArray() {
            VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV[] ret = new VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV.BYTES;
            }

            @Override
            public VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV ret = new VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV(segment.asSlice(0, VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV allocate(Arena arena) {
        VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV ret = new VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_EXTENDED_SPARSE_ADDRESS_SPACE_PROPERTIES_NV);
        return ret;
    }

    public static VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV.Ptr ret = new VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_EXTENDED_SPARSE_ADDRESS_SPACE_PROPERTIES_NV);
        }
        return ret;
    }

    public static VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV clone(Arena arena, VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV src) {
        VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_EXTENDED_SPARSE_ADDRESS_SPACE_PROPERTIES_NV);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long extendedSparseAddressSpaceSize() {
        return segment.get(LAYOUT$extendedSparseAddressSpaceSize, OFFSET$extendedSparseAddressSpaceSize);
    }

    public VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV extendedSparseAddressSpaceSize(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$extendedSparseAddressSpaceSize, OFFSET$extendedSparseAddressSpaceSize, value);
        return this;
    }

    public @Bitmask(VkImageUsageFlags.class) int extendedSparseImageUsageFlags() {
        return segment.get(LAYOUT$extendedSparseImageUsageFlags, OFFSET$extendedSparseImageUsageFlags);
    }

    public VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV extendedSparseImageUsageFlags(@Bitmask(VkImageUsageFlags.class) int value) {
        segment.set(LAYOUT$extendedSparseImageUsageFlags, OFFSET$extendedSparseImageUsageFlags, value);
        return this;
    }

    public @Bitmask(VkBufferUsageFlags.class) int extendedSparseBufferUsageFlags() {
        return segment.get(LAYOUT$extendedSparseBufferUsageFlags, OFFSET$extendedSparseBufferUsageFlags);
    }

    public VkPhysicalDeviceExtendedSparseAddressSpacePropertiesNV extendedSparseBufferUsageFlags(@Bitmask(VkBufferUsageFlags.class) int value) {
        segment.set(LAYOUT$extendedSparseBufferUsageFlags, OFFSET$extendedSparseBufferUsageFlags, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_LONG.withName("extendedSparseAddressSpaceSize"),
        ValueLayout.JAVA_INT.withName("extendedSparseImageUsageFlags"),
        ValueLayout.JAVA_INT.withName("extendedSparseBufferUsageFlags")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$extendedSparseAddressSpaceSize = PathElement.groupElement("extendedSparseAddressSpaceSize");
    public static final PathElement PATH$extendedSparseImageUsageFlags = PathElement.groupElement("extendedSparseImageUsageFlags");
    public static final PathElement PATH$extendedSparseBufferUsageFlags = PathElement.groupElement("extendedSparseBufferUsageFlags");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfLong LAYOUT$extendedSparseAddressSpaceSize = (OfLong) LAYOUT.select(PATH$extendedSparseAddressSpaceSize);
    public static final OfInt LAYOUT$extendedSparseImageUsageFlags = (OfInt) LAYOUT.select(PATH$extendedSparseImageUsageFlags);
    public static final OfInt LAYOUT$extendedSparseBufferUsageFlags = (OfInt) LAYOUT.select(PATH$extendedSparseBufferUsageFlags);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$extendedSparseAddressSpaceSize = LAYOUT$extendedSparseAddressSpaceSize.byteSize();
    public static final long SIZE$extendedSparseImageUsageFlags = LAYOUT$extendedSparseImageUsageFlags.byteSize();
    public static final long SIZE$extendedSparseBufferUsageFlags = LAYOUT$extendedSparseBufferUsageFlags.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$extendedSparseAddressSpaceSize = LAYOUT.byteOffset(PATH$extendedSparseAddressSpaceSize);
    public static final long OFFSET$extendedSparseImageUsageFlags = LAYOUT.byteOffset(PATH$extendedSparseImageUsageFlags);
    public static final long OFFSET$extendedSparseBufferUsageFlags = LAYOUT.byteOffset(PATH$extendedSparseBufferUsageFlags);
}
