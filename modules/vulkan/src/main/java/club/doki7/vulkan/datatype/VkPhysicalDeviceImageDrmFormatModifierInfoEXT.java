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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceImageDrmFormatModifierInfoEXT.html"><code>VkPhysicalDeviceImageDrmFormatModifierInfoEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceImageDrmFormatModifierInfoEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint64_t drmFormatModifier; // @link substring="drmFormatModifier" target="#drmFormatModifier"
///     VkSharingMode sharingMode; // @link substring="VkSharingMode" target="VkSharingMode" @link substring="sharingMode" target="#sharingMode"
///     uint32_t queueFamilyIndexCount; // optional // @link substring="queueFamilyIndexCount" target="#queueFamilyIndexCount"
///     uint32_t const* pQueueFamilyIndices; // optional // @link substring="pQueueFamilyIndices" target="#pQueueFamilyIndices"
/// } VkPhysicalDeviceImageDrmFormatModifierInfoEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_IMAGE_DRM_FORMAT_MODIFIER_INFO_EXT`
///
/// The {@code allocate} ({@link VkPhysicalDeviceImageDrmFormatModifierInfoEXT#allocate(Arena)}, {@link VkPhysicalDeviceImageDrmFormatModifierInfoEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceImageDrmFormatModifierInfoEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceImageDrmFormatModifierInfoEXT.html"><code>VkPhysicalDeviceImageDrmFormatModifierInfoEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceImageDrmFormatModifierInfoEXT(@NotNull MemorySegment segment) implements IVkPhysicalDeviceImageDrmFormatModifierInfoEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceImageDrmFormatModifierInfoEXT.html"><code>VkPhysicalDeviceImageDrmFormatModifierInfoEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceImageDrmFormatModifierInfoEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceImageDrmFormatModifierInfoEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceImageDrmFormatModifierInfoEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceImageDrmFormatModifierInfoEXT, Iterable<VkPhysicalDeviceImageDrmFormatModifierInfoEXT> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceImageDrmFormatModifierInfoEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceImageDrmFormatModifierInfoEXT at(long index) {
            return new VkPhysicalDeviceImageDrmFormatModifierInfoEXT(segment.asSlice(index * VkPhysicalDeviceImageDrmFormatModifierInfoEXT.BYTES, VkPhysicalDeviceImageDrmFormatModifierInfoEXT.BYTES));
        }

        public VkPhysicalDeviceImageDrmFormatModifierInfoEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceImageDrmFormatModifierInfoEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceImageDrmFormatModifierInfoEXT value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceImageDrmFormatModifierInfoEXT.BYTES, VkPhysicalDeviceImageDrmFormatModifierInfoEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceImageDrmFormatModifierInfoEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceImageDrmFormatModifierInfoEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceImageDrmFormatModifierInfoEXT.BYTES,
                (end - start) * VkPhysicalDeviceImageDrmFormatModifierInfoEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceImageDrmFormatModifierInfoEXT.BYTES));
        }

        public VkPhysicalDeviceImageDrmFormatModifierInfoEXT[] toArray() {
            VkPhysicalDeviceImageDrmFormatModifierInfoEXT[] ret = new VkPhysicalDeviceImageDrmFormatModifierInfoEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceImageDrmFormatModifierInfoEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceImageDrmFormatModifierInfoEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceImageDrmFormatModifierInfoEXT.BYTES;
            }

            @Override
            public VkPhysicalDeviceImageDrmFormatModifierInfoEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceImageDrmFormatModifierInfoEXT ret = new VkPhysicalDeviceImageDrmFormatModifierInfoEXT(segment.asSlice(0, VkPhysicalDeviceImageDrmFormatModifierInfoEXT.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceImageDrmFormatModifierInfoEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceImageDrmFormatModifierInfoEXT allocate(Arena arena) {
        VkPhysicalDeviceImageDrmFormatModifierInfoEXT ret = new VkPhysicalDeviceImageDrmFormatModifierInfoEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_IMAGE_DRM_FORMAT_MODIFIER_INFO_EXT);
        return ret;
    }

    public static VkPhysicalDeviceImageDrmFormatModifierInfoEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceImageDrmFormatModifierInfoEXT.Ptr ret = new VkPhysicalDeviceImageDrmFormatModifierInfoEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_IMAGE_DRM_FORMAT_MODIFIER_INFO_EXT);
        }
        return ret;
    }

    public static VkPhysicalDeviceImageDrmFormatModifierInfoEXT clone(Arena arena, VkPhysicalDeviceImageDrmFormatModifierInfoEXT src) {
        VkPhysicalDeviceImageDrmFormatModifierInfoEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_IMAGE_DRM_FORMAT_MODIFIER_INFO_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceImageDrmFormatModifierInfoEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceImageDrmFormatModifierInfoEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceImageDrmFormatModifierInfoEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned long drmFormatModifier() {
        return segment.get(LAYOUT$drmFormatModifier, OFFSET$drmFormatModifier);
    }

    public VkPhysicalDeviceImageDrmFormatModifierInfoEXT drmFormatModifier(@Unsigned long value) {
        segment.set(LAYOUT$drmFormatModifier, OFFSET$drmFormatModifier, value);
        return this;
    }

    public @EnumType(VkSharingMode.class) int sharingMode() {
        return segment.get(LAYOUT$sharingMode, OFFSET$sharingMode);
    }

    public VkPhysicalDeviceImageDrmFormatModifierInfoEXT sharingMode(@EnumType(VkSharingMode.class) int value) {
        segment.set(LAYOUT$sharingMode, OFFSET$sharingMode, value);
        return this;
    }

    public @Unsigned int queueFamilyIndexCount() {
        return segment.get(LAYOUT$queueFamilyIndexCount, OFFSET$queueFamilyIndexCount);
    }

    public VkPhysicalDeviceImageDrmFormatModifierInfoEXT queueFamilyIndexCount(@Unsigned int value) {
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

    public VkPhysicalDeviceImageDrmFormatModifierInfoEXT pQueueFamilyIndices(@Nullable @Unsigned IntPtr value) {
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
        ValueLayout.JAVA_LONG.withName("drmFormatModifier"),
        ValueLayout.JAVA_INT.withName("sharingMode"),
        ValueLayout.JAVA_INT.withName("queueFamilyIndexCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pQueueFamilyIndices")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$drmFormatModifier = PathElement.groupElement("drmFormatModifier");
    public static final PathElement PATH$sharingMode = PathElement.groupElement("sharingMode");
    public static final PathElement PATH$queueFamilyIndexCount = PathElement.groupElement("queueFamilyIndexCount");
    public static final PathElement PATH$pQueueFamilyIndices = PathElement.groupElement("pQueueFamilyIndices");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfLong LAYOUT$drmFormatModifier = (OfLong) LAYOUT.select(PATH$drmFormatModifier);
    public static final OfInt LAYOUT$sharingMode = (OfInt) LAYOUT.select(PATH$sharingMode);
    public static final OfInt LAYOUT$queueFamilyIndexCount = (OfInt) LAYOUT.select(PATH$queueFamilyIndexCount);
    public static final AddressLayout LAYOUT$pQueueFamilyIndices = (AddressLayout) LAYOUT.select(PATH$pQueueFamilyIndices);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$drmFormatModifier = LAYOUT$drmFormatModifier.byteSize();
    public static final long SIZE$sharingMode = LAYOUT$sharingMode.byteSize();
    public static final long SIZE$queueFamilyIndexCount = LAYOUT$queueFamilyIndexCount.byteSize();
    public static final long SIZE$pQueueFamilyIndices = LAYOUT$pQueueFamilyIndices.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$drmFormatModifier = LAYOUT.byteOffset(PATH$drmFormatModifier);
    public static final long OFFSET$sharingMode = LAYOUT.byteOffset(PATH$sharingMode);
    public static final long OFFSET$queueFamilyIndexCount = LAYOUT.byteOffset(PATH$queueFamilyIndexCount);
    public static final long OFFSET$pQueueFamilyIndices = LAYOUT.byteOffset(PATH$pQueueFamilyIndices);
}
