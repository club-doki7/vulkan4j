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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDescriptorBufferBindingInfoEXT.html"><code>VkDescriptorBufferBindingInfoEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDescriptorBufferBindingInfoEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkDeviceAddress address; // @link substring="address" target="#address"
///     VkBufferUsageFlags usage; // optional // @link substring="VkBufferUsageFlags" target="VkBufferUsageFlags" @link substring="usage" target="#usage"
/// } VkDescriptorBufferBindingInfoEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_DESCRIPTOR_BUFFER_BINDING_INFO_EXT`
///
/// The {@code allocate} ({@link VkDescriptorBufferBindingInfoEXT#allocate(Arena)}, {@link VkDescriptorBufferBindingInfoEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkDescriptorBufferBindingInfoEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDescriptorBufferBindingInfoEXT.html"><code>VkDescriptorBufferBindingInfoEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDescriptorBufferBindingInfoEXT(@NotNull MemorySegment segment) implements IVkDescriptorBufferBindingInfoEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDescriptorBufferBindingInfoEXT.html"><code>VkDescriptorBufferBindingInfoEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDescriptorBufferBindingInfoEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDescriptorBufferBindingInfoEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDescriptorBufferBindingInfoEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDescriptorBufferBindingInfoEXT, Iterable<VkDescriptorBufferBindingInfoEXT> {
        public long size() {
            return segment.byteSize() / VkDescriptorBufferBindingInfoEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDescriptorBufferBindingInfoEXT at(long index) {
            return new VkDescriptorBufferBindingInfoEXT(segment.asSlice(index * VkDescriptorBufferBindingInfoEXT.BYTES, VkDescriptorBufferBindingInfoEXT.BYTES));
        }

        public VkDescriptorBufferBindingInfoEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkDescriptorBufferBindingInfoEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDescriptorBufferBindingInfoEXT value) {
            MemorySegment s = segment.asSlice(index * VkDescriptorBufferBindingInfoEXT.BYTES, VkDescriptorBufferBindingInfoEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDescriptorBufferBindingInfoEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDescriptorBufferBindingInfoEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDescriptorBufferBindingInfoEXT.BYTES,
                (end - start) * VkDescriptorBufferBindingInfoEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDescriptorBufferBindingInfoEXT.BYTES));
        }

        public VkDescriptorBufferBindingInfoEXT[] toArray() {
            VkDescriptorBufferBindingInfoEXT[] ret = new VkDescriptorBufferBindingInfoEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDescriptorBufferBindingInfoEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDescriptorBufferBindingInfoEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDescriptorBufferBindingInfoEXT.BYTES;
            }

            @Override
            public VkDescriptorBufferBindingInfoEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDescriptorBufferBindingInfoEXT ret = new VkDescriptorBufferBindingInfoEXT(segment.asSlice(0, VkDescriptorBufferBindingInfoEXT.BYTES));
                segment = segment.asSlice(VkDescriptorBufferBindingInfoEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDescriptorBufferBindingInfoEXT allocate(Arena arena) {
        VkDescriptorBufferBindingInfoEXT ret = new VkDescriptorBufferBindingInfoEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.DESCRIPTOR_BUFFER_BINDING_INFO_EXT);
        return ret;
    }

    public static VkDescriptorBufferBindingInfoEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkDescriptorBufferBindingInfoEXT.Ptr ret = new VkDescriptorBufferBindingInfoEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.DESCRIPTOR_BUFFER_BINDING_INFO_EXT);
        }
        return ret;
    }

    public static VkDescriptorBufferBindingInfoEXT clone(Arena arena, VkDescriptorBufferBindingInfoEXT src) {
        VkDescriptorBufferBindingInfoEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.DESCRIPTOR_BUFFER_BINDING_INFO_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkDescriptorBufferBindingInfoEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkDescriptorBufferBindingInfoEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkDescriptorBufferBindingInfoEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkDeviceAddress") @Unsigned long address() {
        return segment.get(LAYOUT$address, OFFSET$address);
    }

    public VkDescriptorBufferBindingInfoEXT address(@NativeType("VkDeviceAddress") @Unsigned long value) {
        segment.set(LAYOUT$address, OFFSET$address, value);
        return this;
    }

    public @Bitmask(VkBufferUsageFlags.class) int usage() {
        return segment.get(LAYOUT$usage, OFFSET$usage);
    }

    public VkDescriptorBufferBindingInfoEXT usage(@Bitmask(VkBufferUsageFlags.class) int value) {
        segment.set(LAYOUT$usage, OFFSET$usage, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_LONG.withName("address"),
        ValueLayout.JAVA_INT.withName("usage")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$address = PathElement.groupElement("address");
    public static final PathElement PATH$usage = PathElement.groupElement("usage");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfLong LAYOUT$address = (OfLong) LAYOUT.select(PATH$address);
    public static final OfInt LAYOUT$usage = (OfInt) LAYOUT.select(PATH$usage);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$address = LAYOUT$address.byteSize();
    public static final long SIZE$usage = LAYOUT$usage.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$address = LAYOUT.byteOffset(PATH$address);
    public static final long OFFSET$usage = LAYOUT.byteOffset(PATH$usage);
}
