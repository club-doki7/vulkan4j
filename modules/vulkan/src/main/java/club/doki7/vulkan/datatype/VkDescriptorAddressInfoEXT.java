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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDescriptorAddressInfoEXT.html"><code>VkDescriptorAddressInfoEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDescriptorAddressInfoEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkDeviceAddress address; // optional // @link substring="address" target="#address"
///     VkDeviceSize range; // @link substring="range" target="#range"
///     VkFormat format; // @link substring="VkFormat" target="VkFormat" @link substring="format" target="#format"
/// } VkDescriptorAddressInfoEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_DESCRIPTOR_ADDRESS_INFO_EXT`
///
/// The {@code allocate} ({@link VkDescriptorAddressInfoEXT#allocate(Arena)}, {@link VkDescriptorAddressInfoEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkDescriptorAddressInfoEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDescriptorAddressInfoEXT.html"><code>VkDescriptorAddressInfoEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDescriptorAddressInfoEXT(@NotNull MemorySegment segment) implements IVkDescriptorAddressInfoEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDescriptorAddressInfoEXT.html"><code>VkDescriptorAddressInfoEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDescriptorAddressInfoEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDescriptorAddressInfoEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDescriptorAddressInfoEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDescriptorAddressInfoEXT, Iterable<VkDescriptorAddressInfoEXT> {
        public long size() {
            return segment.byteSize() / VkDescriptorAddressInfoEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDescriptorAddressInfoEXT at(long index) {
            return new VkDescriptorAddressInfoEXT(segment.asSlice(index * VkDescriptorAddressInfoEXT.BYTES, VkDescriptorAddressInfoEXT.BYTES));
        }

        public VkDescriptorAddressInfoEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkDescriptorAddressInfoEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDescriptorAddressInfoEXT value) {
            MemorySegment s = segment.asSlice(index * VkDescriptorAddressInfoEXT.BYTES, VkDescriptorAddressInfoEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDescriptorAddressInfoEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDescriptorAddressInfoEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDescriptorAddressInfoEXT.BYTES,
                (end - start) * VkDescriptorAddressInfoEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDescriptorAddressInfoEXT.BYTES));
        }

        public VkDescriptorAddressInfoEXT[] toArray() {
            VkDescriptorAddressInfoEXT[] ret = new VkDescriptorAddressInfoEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDescriptorAddressInfoEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDescriptorAddressInfoEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDescriptorAddressInfoEXT.BYTES;
            }

            @Override
            public VkDescriptorAddressInfoEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDescriptorAddressInfoEXT ret = new VkDescriptorAddressInfoEXT(segment.asSlice(0, VkDescriptorAddressInfoEXT.BYTES));
                segment = segment.asSlice(VkDescriptorAddressInfoEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDescriptorAddressInfoEXT allocate(Arena arena) {
        VkDescriptorAddressInfoEXT ret = new VkDescriptorAddressInfoEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.DESCRIPTOR_ADDRESS_INFO_EXT);
        return ret;
    }

    public static VkDescriptorAddressInfoEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkDescriptorAddressInfoEXT.Ptr ret = new VkDescriptorAddressInfoEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.DESCRIPTOR_ADDRESS_INFO_EXT);
        }
        return ret;
    }

    public static VkDescriptorAddressInfoEXT clone(Arena arena, VkDescriptorAddressInfoEXT src) {
        VkDescriptorAddressInfoEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.DESCRIPTOR_ADDRESS_INFO_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkDescriptorAddressInfoEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkDescriptorAddressInfoEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkDescriptorAddressInfoEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkDeviceAddress") @Unsigned long address() {
        return segment.get(LAYOUT$address, OFFSET$address);
    }

    public VkDescriptorAddressInfoEXT address(@NativeType("VkDeviceAddress") @Unsigned long value) {
        segment.set(LAYOUT$address, OFFSET$address, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long range() {
        return segment.get(LAYOUT$range, OFFSET$range);
    }

    public VkDescriptorAddressInfoEXT range(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$range, OFFSET$range, value);
        return this;
    }

    public @EnumType(VkFormat.class) int format() {
        return segment.get(LAYOUT$format, OFFSET$format);
    }

    public VkDescriptorAddressInfoEXT format(@EnumType(VkFormat.class) int value) {
        segment.set(LAYOUT$format, OFFSET$format, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_LONG.withName("address"),
        ValueLayout.JAVA_LONG.withName("range"),
        ValueLayout.JAVA_INT.withName("format")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$address = PathElement.groupElement("address");
    public static final PathElement PATH$range = PathElement.groupElement("range");
    public static final PathElement PATH$format = PathElement.groupElement("format");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfLong LAYOUT$address = (OfLong) LAYOUT.select(PATH$address);
    public static final OfLong LAYOUT$range = (OfLong) LAYOUT.select(PATH$range);
    public static final OfInt LAYOUT$format = (OfInt) LAYOUT.select(PATH$format);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$address = LAYOUT$address.byteSize();
    public static final long SIZE$range = LAYOUT$range.byteSize();
    public static final long SIZE$format = LAYOUT$format.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$address = LAYOUT.byteOffset(PATH$address);
    public static final long OFFSET$range = LAYOUT.byteOffset(PATH$range);
    public static final long OFFSET$format = LAYOUT.byteOffset(PATH$format);
}
