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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageViewAddressPropertiesNVX.html"><code>VkImageViewAddressPropertiesNVX</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkImageViewAddressPropertiesNVX {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkDeviceAddress deviceAddress; // @link substring="deviceAddress" target="#deviceAddress"
///     VkDeviceSize size; // @link substring="size" target="#size"
/// } VkImageViewAddressPropertiesNVX;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_IMAGE_VIEW_ADDRESS_PROPERTIES_NVX`
///
/// The {@code allocate} ({@link VkImageViewAddressPropertiesNVX#allocate(Arena)}, {@link VkImageViewAddressPropertiesNVX#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkImageViewAddressPropertiesNVX#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageViewAddressPropertiesNVX.html"><code>VkImageViewAddressPropertiesNVX</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkImageViewAddressPropertiesNVX(@NotNull MemorySegment segment) implements IVkImageViewAddressPropertiesNVX {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageViewAddressPropertiesNVX.html"><code>VkImageViewAddressPropertiesNVX</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkImageViewAddressPropertiesNVX}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkImageViewAddressPropertiesNVX to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkImageViewAddressPropertiesNVX.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkImageViewAddressPropertiesNVX, Iterable<VkImageViewAddressPropertiesNVX> {
        public long size() {
            return segment.byteSize() / VkImageViewAddressPropertiesNVX.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkImageViewAddressPropertiesNVX at(long index) {
            return new VkImageViewAddressPropertiesNVX(segment.asSlice(index * VkImageViewAddressPropertiesNVX.BYTES, VkImageViewAddressPropertiesNVX.BYTES));
        }

        public VkImageViewAddressPropertiesNVX.Ptr at(long index, @NotNull Consumer<@NotNull VkImageViewAddressPropertiesNVX> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkImageViewAddressPropertiesNVX value) {
            MemorySegment s = segment.asSlice(index * VkImageViewAddressPropertiesNVX.BYTES, VkImageViewAddressPropertiesNVX.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkImageViewAddressPropertiesNVX.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkImageViewAddressPropertiesNVX.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkImageViewAddressPropertiesNVX.BYTES,
                (end - start) * VkImageViewAddressPropertiesNVX.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkImageViewAddressPropertiesNVX.BYTES));
        }

        public VkImageViewAddressPropertiesNVX[] toArray() {
            VkImageViewAddressPropertiesNVX[] ret = new VkImageViewAddressPropertiesNVX[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkImageViewAddressPropertiesNVX> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkImageViewAddressPropertiesNVX> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkImageViewAddressPropertiesNVX.BYTES;
            }

            @Override
            public VkImageViewAddressPropertiesNVX next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkImageViewAddressPropertiesNVX ret = new VkImageViewAddressPropertiesNVX(segment.asSlice(0, VkImageViewAddressPropertiesNVX.BYTES));
                segment = segment.asSlice(VkImageViewAddressPropertiesNVX.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkImageViewAddressPropertiesNVX allocate(Arena arena) {
        VkImageViewAddressPropertiesNVX ret = new VkImageViewAddressPropertiesNVX(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.IMAGE_VIEW_ADDRESS_PROPERTIES_NVX);
        return ret;
    }

    public static VkImageViewAddressPropertiesNVX.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkImageViewAddressPropertiesNVX.Ptr ret = new VkImageViewAddressPropertiesNVX.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.IMAGE_VIEW_ADDRESS_PROPERTIES_NVX);
        }
        return ret;
    }

    public static VkImageViewAddressPropertiesNVX clone(Arena arena, VkImageViewAddressPropertiesNVX src) {
        VkImageViewAddressPropertiesNVX ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.IMAGE_VIEW_ADDRESS_PROPERTIES_NVX);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkImageViewAddressPropertiesNVX sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkImageViewAddressPropertiesNVX pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkImageViewAddressPropertiesNVX pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkDeviceAddress") @Unsigned long deviceAddress() {
        return segment.get(LAYOUT$deviceAddress, OFFSET$deviceAddress);
    }

    public VkImageViewAddressPropertiesNVX deviceAddress(@NativeType("VkDeviceAddress") @Unsigned long value) {
        segment.set(LAYOUT$deviceAddress, OFFSET$deviceAddress, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long size() {
        return segment.get(LAYOUT$size, OFFSET$size);
    }

    public VkImageViewAddressPropertiesNVX size(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$size, OFFSET$size, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_LONG.withName("deviceAddress"),
        ValueLayout.JAVA_LONG.withName("size")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$deviceAddress = PathElement.groupElement("deviceAddress");
    public static final PathElement PATH$size = PathElement.groupElement("size");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfLong LAYOUT$deviceAddress = (OfLong) LAYOUT.select(PATH$deviceAddress);
    public static final OfLong LAYOUT$size = (OfLong) LAYOUT.select(PATH$size);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$deviceAddress = LAYOUT$deviceAddress.byteSize();
    public static final long SIZE$size = LAYOUT$size.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$deviceAddress = LAYOUT.byteOffset(PATH$deviceAddress);
    public static final long OFFSET$size = LAYOUT.byteOffset(PATH$size);
}
