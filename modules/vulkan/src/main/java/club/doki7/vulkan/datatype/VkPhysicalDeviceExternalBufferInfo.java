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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceExternalBufferInfo.html"><code>VkPhysicalDeviceExternalBufferInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceExternalBufferInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBufferCreateFlags flags; // optional // @link substring="VkBufferCreateFlags" target="VkBufferCreateFlags" @link substring="flags" target="#flags"
///     VkBufferUsageFlags usage; // optional // @link substring="VkBufferUsageFlags" target="VkBufferUsageFlags" @link substring="usage" target="#usage"
///     VkExternalMemoryHandleTypeFlags handleType; // @link substring="VkExternalMemoryHandleTypeFlags" target="VkExternalMemoryHandleTypeFlags" @link substring="handleType" target="#handleType"
/// } VkPhysicalDeviceExternalBufferInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_EXTERNAL_BUFFER_INFO`
///
/// The {@code allocate} ({@link VkPhysicalDeviceExternalBufferInfo#allocate(Arena)}, {@link VkPhysicalDeviceExternalBufferInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceExternalBufferInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceExternalBufferInfo.html"><code>VkPhysicalDeviceExternalBufferInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceExternalBufferInfo(@NotNull MemorySegment segment) implements IVkPhysicalDeviceExternalBufferInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceExternalBufferInfo.html"><code>VkPhysicalDeviceExternalBufferInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceExternalBufferInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceExternalBufferInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceExternalBufferInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceExternalBufferInfo, Iterable<VkPhysicalDeviceExternalBufferInfo> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceExternalBufferInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceExternalBufferInfo at(long index) {
            return new VkPhysicalDeviceExternalBufferInfo(segment.asSlice(index * VkPhysicalDeviceExternalBufferInfo.BYTES, VkPhysicalDeviceExternalBufferInfo.BYTES));
        }

        public VkPhysicalDeviceExternalBufferInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceExternalBufferInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceExternalBufferInfo value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceExternalBufferInfo.BYTES, VkPhysicalDeviceExternalBufferInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceExternalBufferInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceExternalBufferInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceExternalBufferInfo.BYTES,
                (end - start) * VkPhysicalDeviceExternalBufferInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceExternalBufferInfo.BYTES));
        }

        public VkPhysicalDeviceExternalBufferInfo[] toArray() {
            VkPhysicalDeviceExternalBufferInfo[] ret = new VkPhysicalDeviceExternalBufferInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceExternalBufferInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceExternalBufferInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceExternalBufferInfo.BYTES;
            }

            @Override
            public VkPhysicalDeviceExternalBufferInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceExternalBufferInfo ret = new VkPhysicalDeviceExternalBufferInfo(segment.asSlice(0, VkPhysicalDeviceExternalBufferInfo.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceExternalBufferInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceExternalBufferInfo allocate(Arena arena) {
        VkPhysicalDeviceExternalBufferInfo ret = new VkPhysicalDeviceExternalBufferInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_EXTERNAL_BUFFER_INFO);
        return ret;
    }

    public static VkPhysicalDeviceExternalBufferInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceExternalBufferInfo.Ptr ret = new VkPhysicalDeviceExternalBufferInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_EXTERNAL_BUFFER_INFO);
        }
        return ret;
    }

    public static VkPhysicalDeviceExternalBufferInfo clone(Arena arena, VkPhysicalDeviceExternalBufferInfo src) {
        VkPhysicalDeviceExternalBufferInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_EXTERNAL_BUFFER_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceExternalBufferInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceExternalBufferInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceExternalBufferInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkBufferCreateFlags.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkPhysicalDeviceExternalBufferInfo flags(@Bitmask(VkBufferCreateFlags.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @Bitmask(VkBufferUsageFlags.class) int usage() {
        return segment.get(LAYOUT$usage, OFFSET$usage);
    }

    public VkPhysicalDeviceExternalBufferInfo usage(@Bitmask(VkBufferUsageFlags.class) int value) {
        segment.set(LAYOUT$usage, OFFSET$usage, value);
        return this;
    }

    public @Bitmask(VkExternalMemoryHandleTypeFlags.class) int handleType() {
        return segment.get(LAYOUT$handleType, OFFSET$handleType);
    }

    public VkPhysicalDeviceExternalBufferInfo handleType(@Bitmask(VkExternalMemoryHandleTypeFlags.class) int value) {
        segment.set(LAYOUT$handleType, OFFSET$handleType, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("usage"),
        ValueLayout.JAVA_INT.withName("handleType")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$usage = PathElement.groupElement("usage");
    public static final PathElement PATH$handleType = PathElement.groupElement("handleType");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$usage = (OfInt) LAYOUT.select(PATH$usage);
    public static final OfInt LAYOUT$handleType = (OfInt) LAYOUT.select(PATH$handleType);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$usage = LAYOUT$usage.byteSize();
    public static final long SIZE$handleType = LAYOUT$handleType.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$usage = LAYOUT.byteOffset(PATH$usage);
    public static final long OFFSET$handleType = LAYOUT.byteOffset(PATH$handleType);
}
