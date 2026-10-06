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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoCapabilitiesKHR.html"><code>VkVideoCapabilitiesKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkVideoCapabilitiesKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkVideoCapabilityFlagsKHR flags; // @link substring="VkVideoCapabilityFlagsKHR" target="VkVideoCapabilityFlagsKHR" @link substring="flags" target="#flags"
///     VkDeviceSize minBitstreamBufferOffsetAlignment; // @link substring="minBitstreamBufferOffsetAlignment" target="#minBitstreamBufferOffsetAlignment"
///     VkDeviceSize minBitstreamBufferSizeAlignment; // @link substring="minBitstreamBufferSizeAlignment" target="#minBitstreamBufferSizeAlignment"
///     VkExtent2D pictureAccessGranularity; // @link substring="VkExtent2D" target="VkExtent2D" @link substring="pictureAccessGranularity" target="#pictureAccessGranularity"
///     VkExtent2D minCodedExtent; // @link substring="VkExtent2D" target="VkExtent2D" @link substring="minCodedExtent" target="#minCodedExtent"
///     VkExtent2D maxCodedExtent; // @link substring="VkExtent2D" target="VkExtent2D" @link substring="maxCodedExtent" target="#maxCodedExtent"
///     uint32_t maxDpbSlots; // @link substring="maxDpbSlots" target="#maxDpbSlots"
///     uint32_t maxActiveReferencePictures; // @link substring="maxActiveReferencePictures" target="#maxActiveReferencePictures"
///     VkExtensionProperties stdHeaderVersion; // @link substring="VkExtensionProperties" target="VkExtensionProperties" @link substring="stdHeaderVersion" target="#stdHeaderVersion"
/// } VkVideoCapabilitiesKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_VIDEO_CAPABILITIES_KHR`
///
/// The {@code allocate} ({@link VkVideoCapabilitiesKHR#allocate(Arena)}, {@link VkVideoCapabilitiesKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkVideoCapabilitiesKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoCapabilitiesKHR.html"><code>VkVideoCapabilitiesKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkVideoCapabilitiesKHR(@NotNull MemorySegment segment) implements IVkVideoCapabilitiesKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoCapabilitiesKHR.html"><code>VkVideoCapabilitiesKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkVideoCapabilitiesKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkVideoCapabilitiesKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkVideoCapabilitiesKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkVideoCapabilitiesKHR, Iterable<VkVideoCapabilitiesKHR> {
        public long size() {
            return segment.byteSize() / VkVideoCapabilitiesKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkVideoCapabilitiesKHR at(long index) {
            return new VkVideoCapabilitiesKHR(segment.asSlice(index * VkVideoCapabilitiesKHR.BYTES, VkVideoCapabilitiesKHR.BYTES));
        }

        public VkVideoCapabilitiesKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkVideoCapabilitiesKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkVideoCapabilitiesKHR value) {
            MemorySegment s = segment.asSlice(index * VkVideoCapabilitiesKHR.BYTES, VkVideoCapabilitiesKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkVideoCapabilitiesKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkVideoCapabilitiesKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkVideoCapabilitiesKHR.BYTES,
                (end - start) * VkVideoCapabilitiesKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkVideoCapabilitiesKHR.BYTES));
        }

        public VkVideoCapabilitiesKHR[] toArray() {
            VkVideoCapabilitiesKHR[] ret = new VkVideoCapabilitiesKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkVideoCapabilitiesKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkVideoCapabilitiesKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkVideoCapabilitiesKHR.BYTES;
            }

            @Override
            public VkVideoCapabilitiesKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkVideoCapabilitiesKHR ret = new VkVideoCapabilitiesKHR(segment.asSlice(0, VkVideoCapabilitiesKHR.BYTES));
                segment = segment.asSlice(VkVideoCapabilitiesKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkVideoCapabilitiesKHR allocate(Arena arena) {
        VkVideoCapabilitiesKHR ret = new VkVideoCapabilitiesKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.VIDEO_CAPABILITIES_KHR);
        return ret;
    }

    public static VkVideoCapabilitiesKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkVideoCapabilitiesKHR.Ptr ret = new VkVideoCapabilitiesKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.VIDEO_CAPABILITIES_KHR);
        }
        return ret;
    }

    public static VkVideoCapabilitiesKHR clone(Arena arena, VkVideoCapabilitiesKHR src) {
        VkVideoCapabilitiesKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.VIDEO_CAPABILITIES_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkVideoCapabilitiesKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkVideoCapabilitiesKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkVideoCapabilitiesKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkVideoCapabilityFlagsKHR.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkVideoCapabilitiesKHR flags(@Bitmask(VkVideoCapabilityFlagsKHR.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long minBitstreamBufferOffsetAlignment() {
        return segment.get(LAYOUT$minBitstreamBufferOffsetAlignment, OFFSET$minBitstreamBufferOffsetAlignment);
    }

    public VkVideoCapabilitiesKHR minBitstreamBufferOffsetAlignment(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$minBitstreamBufferOffsetAlignment, OFFSET$minBitstreamBufferOffsetAlignment, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long minBitstreamBufferSizeAlignment() {
        return segment.get(LAYOUT$minBitstreamBufferSizeAlignment, OFFSET$minBitstreamBufferSizeAlignment);
    }

    public VkVideoCapabilitiesKHR minBitstreamBufferSizeAlignment(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$minBitstreamBufferSizeAlignment, OFFSET$minBitstreamBufferSizeAlignment, value);
        return this;
    }

    public @NotNull VkExtent2D pictureAccessGranularity() {
        return new VkExtent2D(segment.asSlice(OFFSET$pictureAccessGranularity, LAYOUT$pictureAccessGranularity));
    }

    public VkVideoCapabilitiesKHR pictureAccessGranularity(@NotNull VkExtent2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$pictureAccessGranularity, SIZE$pictureAccessGranularity);
        return this;
    }

    public VkVideoCapabilitiesKHR pictureAccessGranularity(Consumer<@NotNull VkExtent2D> consumer) {
        consumer.accept(pictureAccessGranularity());
        return this;
    }

    public @NotNull VkExtent2D minCodedExtent() {
        return new VkExtent2D(segment.asSlice(OFFSET$minCodedExtent, LAYOUT$minCodedExtent));
    }

    public VkVideoCapabilitiesKHR minCodedExtent(@NotNull VkExtent2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$minCodedExtent, SIZE$minCodedExtent);
        return this;
    }

    public VkVideoCapabilitiesKHR minCodedExtent(Consumer<@NotNull VkExtent2D> consumer) {
        consumer.accept(minCodedExtent());
        return this;
    }

    public @NotNull VkExtent2D maxCodedExtent() {
        return new VkExtent2D(segment.asSlice(OFFSET$maxCodedExtent, LAYOUT$maxCodedExtent));
    }

    public VkVideoCapabilitiesKHR maxCodedExtent(@NotNull VkExtent2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$maxCodedExtent, SIZE$maxCodedExtent);
        return this;
    }

    public VkVideoCapabilitiesKHR maxCodedExtent(Consumer<@NotNull VkExtent2D> consumer) {
        consumer.accept(maxCodedExtent());
        return this;
    }

    public @Unsigned int maxDpbSlots() {
        return segment.get(LAYOUT$maxDpbSlots, OFFSET$maxDpbSlots);
    }

    public VkVideoCapabilitiesKHR maxDpbSlots(@Unsigned int value) {
        segment.set(LAYOUT$maxDpbSlots, OFFSET$maxDpbSlots, value);
        return this;
    }

    public @Unsigned int maxActiveReferencePictures() {
        return segment.get(LAYOUT$maxActiveReferencePictures, OFFSET$maxActiveReferencePictures);
    }

    public VkVideoCapabilitiesKHR maxActiveReferencePictures(@Unsigned int value) {
        segment.set(LAYOUT$maxActiveReferencePictures, OFFSET$maxActiveReferencePictures, value);
        return this;
    }

    public @NotNull VkExtensionProperties stdHeaderVersion() {
        return new VkExtensionProperties(segment.asSlice(OFFSET$stdHeaderVersion, LAYOUT$stdHeaderVersion));
    }

    public VkVideoCapabilitiesKHR stdHeaderVersion(@NotNull VkExtensionProperties value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$stdHeaderVersion, SIZE$stdHeaderVersion);
        return this;
    }

    public VkVideoCapabilitiesKHR stdHeaderVersion(Consumer<@NotNull VkExtensionProperties> consumer) {
        consumer.accept(stdHeaderVersion());
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_LONG.withName("minBitstreamBufferOffsetAlignment"),
        ValueLayout.JAVA_LONG.withName("minBitstreamBufferSizeAlignment"),
        VkExtent2D.LAYOUT.withName("pictureAccessGranularity"),
        VkExtent2D.LAYOUT.withName("minCodedExtent"),
        VkExtent2D.LAYOUT.withName("maxCodedExtent"),
        ValueLayout.JAVA_INT.withName("maxDpbSlots"),
        ValueLayout.JAVA_INT.withName("maxActiveReferencePictures"),
        VkExtensionProperties.LAYOUT.withName("stdHeaderVersion")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$minBitstreamBufferOffsetAlignment = PathElement.groupElement("minBitstreamBufferOffsetAlignment");
    public static final PathElement PATH$minBitstreamBufferSizeAlignment = PathElement.groupElement("minBitstreamBufferSizeAlignment");
    public static final PathElement PATH$pictureAccessGranularity = PathElement.groupElement("pictureAccessGranularity");
    public static final PathElement PATH$minCodedExtent = PathElement.groupElement("minCodedExtent");
    public static final PathElement PATH$maxCodedExtent = PathElement.groupElement("maxCodedExtent");
    public static final PathElement PATH$maxDpbSlots = PathElement.groupElement("maxDpbSlots");
    public static final PathElement PATH$maxActiveReferencePictures = PathElement.groupElement("maxActiveReferencePictures");
    public static final PathElement PATH$stdHeaderVersion = PathElement.groupElement("stdHeaderVersion");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfLong LAYOUT$minBitstreamBufferOffsetAlignment = (OfLong) LAYOUT.select(PATH$minBitstreamBufferOffsetAlignment);
    public static final OfLong LAYOUT$minBitstreamBufferSizeAlignment = (OfLong) LAYOUT.select(PATH$minBitstreamBufferSizeAlignment);
    public static final StructLayout LAYOUT$pictureAccessGranularity = (StructLayout) LAYOUT.select(PATH$pictureAccessGranularity);
    public static final StructLayout LAYOUT$minCodedExtent = (StructLayout) LAYOUT.select(PATH$minCodedExtent);
    public static final StructLayout LAYOUT$maxCodedExtent = (StructLayout) LAYOUT.select(PATH$maxCodedExtent);
    public static final OfInt LAYOUT$maxDpbSlots = (OfInt) LAYOUT.select(PATH$maxDpbSlots);
    public static final OfInt LAYOUT$maxActiveReferencePictures = (OfInt) LAYOUT.select(PATH$maxActiveReferencePictures);
    public static final StructLayout LAYOUT$stdHeaderVersion = (StructLayout) LAYOUT.select(PATH$stdHeaderVersion);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$minBitstreamBufferOffsetAlignment = LAYOUT$minBitstreamBufferOffsetAlignment.byteSize();
    public static final long SIZE$minBitstreamBufferSizeAlignment = LAYOUT$minBitstreamBufferSizeAlignment.byteSize();
    public static final long SIZE$pictureAccessGranularity = LAYOUT$pictureAccessGranularity.byteSize();
    public static final long SIZE$minCodedExtent = LAYOUT$minCodedExtent.byteSize();
    public static final long SIZE$maxCodedExtent = LAYOUT$maxCodedExtent.byteSize();
    public static final long SIZE$maxDpbSlots = LAYOUT$maxDpbSlots.byteSize();
    public static final long SIZE$maxActiveReferencePictures = LAYOUT$maxActiveReferencePictures.byteSize();
    public static final long SIZE$stdHeaderVersion = LAYOUT$stdHeaderVersion.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$minBitstreamBufferOffsetAlignment = LAYOUT.byteOffset(PATH$minBitstreamBufferOffsetAlignment);
    public static final long OFFSET$minBitstreamBufferSizeAlignment = LAYOUT.byteOffset(PATH$minBitstreamBufferSizeAlignment);
    public static final long OFFSET$pictureAccessGranularity = LAYOUT.byteOffset(PATH$pictureAccessGranularity);
    public static final long OFFSET$minCodedExtent = LAYOUT.byteOffset(PATH$minCodedExtent);
    public static final long OFFSET$maxCodedExtent = LAYOUT.byteOffset(PATH$maxCodedExtent);
    public static final long OFFSET$maxDpbSlots = LAYOUT.byteOffset(PATH$maxDpbSlots);
    public static final long OFFSET$maxActiveReferencePictures = LAYOUT.byteOffset(PATH$maxActiveReferencePictures);
    public static final long OFFSET$stdHeaderVersion = LAYOUT.byteOffset(PATH$stdHeaderVersion);
}
