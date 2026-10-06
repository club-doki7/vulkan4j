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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBufferCreateInfo.html"><code>VkBufferCreateInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkBufferCreateInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBufferCreateFlags flags; // optional // @link substring="VkBufferCreateFlags" target="VkBufferCreateFlags" @link substring="flags" target="#flags"
///     VkDeviceSize size; // @link substring="size" target="#size"
///     VkBufferUsageFlags usage; // @link substring="VkBufferUsageFlags" target="VkBufferUsageFlags" @link substring="usage" target="#usage"
///     VkSharingMode sharingMode; // @link substring="VkSharingMode" target="VkSharingMode" @link substring="sharingMode" target="#sharingMode"
///     uint32_t queueFamilyIndexCount; // optional // @link substring="queueFamilyIndexCount" target="#queueFamilyIndexCount"
///     uint32_t const* pQueueFamilyIndices; // optional // @link substring="pQueueFamilyIndices" target="#pQueueFamilyIndices"
/// } VkBufferCreateInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_BUFFER_CREATE_INFO`
///
/// The {@code allocate} ({@link VkBufferCreateInfo#allocate(Arena)}, {@link VkBufferCreateInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkBufferCreateInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBufferCreateInfo.html"><code>VkBufferCreateInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkBufferCreateInfo(@NotNull MemorySegment segment) implements IVkBufferCreateInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBufferCreateInfo.html"><code>VkBufferCreateInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkBufferCreateInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkBufferCreateInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkBufferCreateInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkBufferCreateInfo, Iterable<VkBufferCreateInfo> {
        public long size() {
            return segment.byteSize() / VkBufferCreateInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkBufferCreateInfo at(long index) {
            return new VkBufferCreateInfo(segment.asSlice(index * VkBufferCreateInfo.BYTES, VkBufferCreateInfo.BYTES));
        }

        public VkBufferCreateInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkBufferCreateInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkBufferCreateInfo value) {
            MemorySegment s = segment.asSlice(index * VkBufferCreateInfo.BYTES, VkBufferCreateInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkBufferCreateInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkBufferCreateInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkBufferCreateInfo.BYTES,
                (end - start) * VkBufferCreateInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkBufferCreateInfo.BYTES));
        }

        public VkBufferCreateInfo[] toArray() {
            VkBufferCreateInfo[] ret = new VkBufferCreateInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkBufferCreateInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkBufferCreateInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkBufferCreateInfo.BYTES;
            }

            @Override
            public VkBufferCreateInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkBufferCreateInfo ret = new VkBufferCreateInfo(segment.asSlice(0, VkBufferCreateInfo.BYTES));
                segment = segment.asSlice(VkBufferCreateInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkBufferCreateInfo allocate(Arena arena) {
        VkBufferCreateInfo ret = new VkBufferCreateInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.BUFFER_CREATE_INFO);
        return ret;
    }

    public static VkBufferCreateInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkBufferCreateInfo.Ptr ret = new VkBufferCreateInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.BUFFER_CREATE_INFO);
        }
        return ret;
    }

    public static VkBufferCreateInfo clone(Arena arena, VkBufferCreateInfo src) {
        VkBufferCreateInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.BUFFER_CREATE_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkBufferCreateInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkBufferCreateInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkBufferCreateInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkBufferCreateFlags.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkBufferCreateInfo flags(@Bitmask(VkBufferCreateFlags.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long size() {
        return segment.get(LAYOUT$size, OFFSET$size);
    }

    public VkBufferCreateInfo size(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$size, OFFSET$size, value);
        return this;
    }

    public @Bitmask(VkBufferUsageFlags.class) int usage() {
        return segment.get(LAYOUT$usage, OFFSET$usage);
    }

    public VkBufferCreateInfo usage(@Bitmask(VkBufferUsageFlags.class) int value) {
        segment.set(LAYOUT$usage, OFFSET$usage, value);
        return this;
    }

    public @EnumType(VkSharingMode.class) int sharingMode() {
        return segment.get(LAYOUT$sharingMode, OFFSET$sharingMode);
    }

    public VkBufferCreateInfo sharingMode(@EnumType(VkSharingMode.class) int value) {
        segment.set(LAYOUT$sharingMode, OFFSET$sharingMode, value);
        return this;
    }

    public @Unsigned int queueFamilyIndexCount() {
        return segment.get(LAYOUT$queueFamilyIndexCount, OFFSET$queueFamilyIndexCount);
    }

    public VkBufferCreateInfo queueFamilyIndexCount(@Unsigned int value) {
        segment.set(LAYOUT$queueFamilyIndexCount, OFFSET$queueFamilyIndexCount, value);
        return this;
    }

    /// Note: the returned {@link IntPtr} does not have correct
    /// {@link IntPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link IntPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable @Unsigned IntPtr pQueueFamilyIndices() {
        MemorySegment s = pQueueFamilyIndicesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new IntPtr(s);
    }

    public VkBufferCreateInfo pQueueFamilyIndices(@Nullable @Unsigned IntPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pQueueFamilyIndicesRaw(s);
        return this;
    }

    public @Pointer(comment="uint32_t*") @NotNull MemorySegment pQueueFamilyIndicesRaw() {
        return segment.get(LAYOUT$pQueueFamilyIndices, OFFSET$pQueueFamilyIndices);
    }

    public void pQueueFamilyIndicesRaw(@Pointer(comment="uint32_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pQueueFamilyIndices, OFFSET$pQueueFamilyIndices, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_LONG.withName("size"),
        ValueLayout.JAVA_INT.withName("usage"),
        ValueLayout.JAVA_INT.withName("sharingMode"),
        ValueLayout.JAVA_INT.withName("queueFamilyIndexCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pQueueFamilyIndices")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$size = PathElement.groupElement("size");
    public static final PathElement PATH$usage = PathElement.groupElement("usage");
    public static final PathElement PATH$sharingMode = PathElement.groupElement("sharingMode");
    public static final PathElement PATH$queueFamilyIndexCount = PathElement.groupElement("queueFamilyIndexCount");
    public static final PathElement PATH$pQueueFamilyIndices = PathElement.groupElement("pQueueFamilyIndices");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfLong LAYOUT$size = (OfLong) LAYOUT.select(PATH$size);
    public static final OfInt LAYOUT$usage = (OfInt) LAYOUT.select(PATH$usage);
    public static final OfInt LAYOUT$sharingMode = (OfInt) LAYOUT.select(PATH$sharingMode);
    public static final OfInt LAYOUT$queueFamilyIndexCount = (OfInt) LAYOUT.select(PATH$queueFamilyIndexCount);
    public static final AddressLayout LAYOUT$pQueueFamilyIndices = (AddressLayout) LAYOUT.select(PATH$pQueueFamilyIndices);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$size = LAYOUT$size.byteSize();
    public static final long SIZE$usage = LAYOUT$usage.byteSize();
    public static final long SIZE$sharingMode = LAYOUT$sharingMode.byteSize();
    public static final long SIZE$queueFamilyIndexCount = LAYOUT$queueFamilyIndexCount.byteSize();
    public static final long SIZE$pQueueFamilyIndices = LAYOUT$pQueueFamilyIndices.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$size = LAYOUT.byteOffset(PATH$size);
    public static final long OFFSET$usage = LAYOUT.byteOffset(PATH$usage);
    public static final long OFFSET$sharingMode = LAYOUT.byteOffset(PATH$sharingMode);
    public static final long OFFSET$queueFamilyIndexCount = LAYOUT.byteOffset(PATH$queueFamilyIndexCount);
    public static final long OFFSET$pQueueFamilyIndices = LAYOUT.byteOffset(PATH$pQueueFamilyIndices);
}
