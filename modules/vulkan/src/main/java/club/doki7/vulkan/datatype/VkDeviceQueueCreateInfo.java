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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDeviceQueueCreateInfo.html"><code>VkDeviceQueueCreateInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDeviceQueueCreateInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkDeviceQueueCreateFlags flags; // optional // @link substring="VkDeviceQueueCreateFlags" target="VkDeviceQueueCreateFlags" @link substring="flags" target="#flags"
///     uint32_t queueFamilyIndex; // @link substring="queueFamilyIndex" target="#queueFamilyIndex"
///     uint32_t queueCount; // @link substring="queueCount" target="#queueCount"
///     float const* pQueuePriorities; // @link substring="pQueuePriorities" target="#pQueuePriorities"
/// } VkDeviceQueueCreateInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_DEVICE_QUEUE_CREATE_INFO`
///
/// The {@code allocate} ({@link VkDeviceQueueCreateInfo#allocate(Arena)}, {@link VkDeviceQueueCreateInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkDeviceQueueCreateInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDeviceQueueCreateInfo.html"><code>VkDeviceQueueCreateInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDeviceQueueCreateInfo(@NotNull MemorySegment segment) implements IVkDeviceQueueCreateInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDeviceQueueCreateInfo.html"><code>VkDeviceQueueCreateInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDeviceQueueCreateInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDeviceQueueCreateInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDeviceQueueCreateInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDeviceQueueCreateInfo, Iterable<VkDeviceQueueCreateInfo> {
        public long size() {
            return segment.byteSize() / VkDeviceQueueCreateInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDeviceQueueCreateInfo at(long index) {
            return new VkDeviceQueueCreateInfo(segment.asSlice(index * VkDeviceQueueCreateInfo.BYTES, VkDeviceQueueCreateInfo.BYTES));
        }

        public VkDeviceQueueCreateInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkDeviceQueueCreateInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDeviceQueueCreateInfo value) {
            MemorySegment s = segment.asSlice(index * VkDeviceQueueCreateInfo.BYTES, VkDeviceQueueCreateInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDeviceQueueCreateInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDeviceQueueCreateInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDeviceQueueCreateInfo.BYTES,
                (end - start) * VkDeviceQueueCreateInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDeviceQueueCreateInfo.BYTES));
        }

        public VkDeviceQueueCreateInfo[] toArray() {
            VkDeviceQueueCreateInfo[] ret = new VkDeviceQueueCreateInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDeviceQueueCreateInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDeviceQueueCreateInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDeviceQueueCreateInfo.BYTES;
            }

            @Override
            public VkDeviceQueueCreateInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDeviceQueueCreateInfo ret = new VkDeviceQueueCreateInfo(segment.asSlice(0, VkDeviceQueueCreateInfo.BYTES));
                segment = segment.asSlice(VkDeviceQueueCreateInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDeviceQueueCreateInfo allocate(Arena arena) {
        VkDeviceQueueCreateInfo ret = new VkDeviceQueueCreateInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.DEVICE_QUEUE_CREATE_INFO);
        return ret;
    }

    public static VkDeviceQueueCreateInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkDeviceQueueCreateInfo.Ptr ret = new VkDeviceQueueCreateInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.DEVICE_QUEUE_CREATE_INFO);
        }
        return ret;
    }

    public static VkDeviceQueueCreateInfo clone(Arena arena, VkDeviceQueueCreateInfo src) {
        VkDeviceQueueCreateInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.DEVICE_QUEUE_CREATE_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkDeviceQueueCreateInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkDeviceQueueCreateInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkDeviceQueueCreateInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkDeviceQueueCreateFlags.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkDeviceQueueCreateInfo flags(@Bitmask(VkDeviceQueueCreateFlags.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @Unsigned int queueFamilyIndex() {
        return segment.get(LAYOUT$queueFamilyIndex, OFFSET$queueFamilyIndex);
    }

    public VkDeviceQueueCreateInfo queueFamilyIndex(@Unsigned int value) {
        segment.set(LAYOUT$queueFamilyIndex, OFFSET$queueFamilyIndex, value);
        return this;
    }

    public @Unsigned int queueCount() {
        return segment.get(LAYOUT$queueCount, OFFSET$queueCount);
    }

    public VkDeviceQueueCreateInfo queueCount(@Unsigned int value) {
        segment.set(LAYOUT$queueCount, OFFSET$queueCount, value);
        return this;
    }

    /// Note: the returned {@link FloatPtr} does not have correct
    /// {@link FloatPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link FloatPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable FloatPtr pQueuePriorities() {
        MemorySegment s = pQueuePrioritiesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new FloatPtr(s);
    }

    public VkDeviceQueueCreateInfo pQueuePriorities(@Nullable FloatPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pQueuePrioritiesRaw(s);
        return this;
    }

    public @Pointer(comment="float*") @NotNull MemorySegment pQueuePrioritiesRaw() {
        return segment.get(LAYOUT$pQueuePriorities, OFFSET$pQueuePriorities);
    }

    public void pQueuePrioritiesRaw(@Pointer(comment="float*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pQueuePriorities, OFFSET$pQueuePriorities, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("queueFamilyIndex"),
        ValueLayout.JAVA_INT.withName("queueCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT).withName("pQueuePriorities")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$queueFamilyIndex = PathElement.groupElement("queueFamilyIndex");
    public static final PathElement PATH$queueCount = PathElement.groupElement("queueCount");
    public static final PathElement PATH$pQueuePriorities = PathElement.groupElement("pQueuePriorities");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$queueFamilyIndex = (OfInt) LAYOUT.select(PATH$queueFamilyIndex);
    public static final OfInt LAYOUT$queueCount = (OfInt) LAYOUT.select(PATH$queueCount);
    public static final AddressLayout LAYOUT$pQueuePriorities = (AddressLayout) LAYOUT.select(PATH$pQueuePriorities);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$queueFamilyIndex = LAYOUT$queueFamilyIndex.byteSize();
    public static final long SIZE$queueCount = LAYOUT$queueCount.byteSize();
    public static final long SIZE$pQueuePriorities = LAYOUT$pQueuePriorities.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$queueFamilyIndex = LAYOUT.byteOffset(PATH$queueFamilyIndex);
    public static final long OFFSET$queueCount = LAYOUT.byteOffset(PATH$queueCount);
    public static final long OFFSET$pQueuePriorities = LAYOUT.byteOffset(PATH$pQueuePriorities);
}
