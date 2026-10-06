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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoSessionCreateInfoKHR.html"><code>VkVideoSessionCreateInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkVideoSessionCreateInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t queueFamilyIndex; // @link substring="queueFamilyIndex" target="#queueFamilyIndex"
///     VkVideoSessionCreateFlagsKHR flags; // optional // @link substring="VkVideoSessionCreateFlagsKHR" target="VkVideoSessionCreateFlagsKHR" @link substring="flags" target="#flags"
///     VkVideoProfileInfoKHR const* pVideoProfile; // @link substring="VkVideoProfileInfoKHR" target="VkVideoProfileInfoKHR" @link substring="pVideoProfile" target="#pVideoProfile"
///     VkFormat pictureFormat; // @link substring="VkFormat" target="VkFormat" @link substring="pictureFormat" target="#pictureFormat"
///     VkExtent2D maxCodedExtent; // @link substring="VkExtent2D" target="VkExtent2D" @link substring="maxCodedExtent" target="#maxCodedExtent"
///     VkFormat referencePictureFormat; // @link substring="VkFormat" target="VkFormat" @link substring="referencePictureFormat" target="#referencePictureFormat"
///     uint32_t maxDpbSlots; // @link substring="maxDpbSlots" target="#maxDpbSlots"
///     uint32_t maxActiveReferencePictures; // @link substring="maxActiveReferencePictures" target="#maxActiveReferencePictures"
///     VkExtensionProperties const* pStdHeaderVersion; // @link substring="VkExtensionProperties" target="VkExtensionProperties" @link substring="pStdHeaderVersion" target="#pStdHeaderVersion"
/// } VkVideoSessionCreateInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_VIDEO_SESSION_CREATE_INFO_KHR`
///
/// The {@code allocate} ({@link VkVideoSessionCreateInfoKHR#allocate(Arena)}, {@link VkVideoSessionCreateInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkVideoSessionCreateInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoSessionCreateInfoKHR.html"><code>VkVideoSessionCreateInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkVideoSessionCreateInfoKHR(@NotNull MemorySegment segment) implements IVkVideoSessionCreateInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoSessionCreateInfoKHR.html"><code>VkVideoSessionCreateInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkVideoSessionCreateInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkVideoSessionCreateInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkVideoSessionCreateInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkVideoSessionCreateInfoKHR, Iterable<VkVideoSessionCreateInfoKHR> {
        public long size() {
            return segment.byteSize() / VkVideoSessionCreateInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkVideoSessionCreateInfoKHR at(long index) {
            return new VkVideoSessionCreateInfoKHR(segment.asSlice(index * VkVideoSessionCreateInfoKHR.BYTES, VkVideoSessionCreateInfoKHR.BYTES));
        }

        public VkVideoSessionCreateInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkVideoSessionCreateInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkVideoSessionCreateInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkVideoSessionCreateInfoKHR.BYTES, VkVideoSessionCreateInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkVideoSessionCreateInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkVideoSessionCreateInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkVideoSessionCreateInfoKHR.BYTES,
                (end - start) * VkVideoSessionCreateInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkVideoSessionCreateInfoKHR.BYTES));
        }

        public VkVideoSessionCreateInfoKHR[] toArray() {
            VkVideoSessionCreateInfoKHR[] ret = new VkVideoSessionCreateInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkVideoSessionCreateInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkVideoSessionCreateInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkVideoSessionCreateInfoKHR.BYTES;
            }

            @Override
            public VkVideoSessionCreateInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkVideoSessionCreateInfoKHR ret = new VkVideoSessionCreateInfoKHR(segment.asSlice(0, VkVideoSessionCreateInfoKHR.BYTES));
                segment = segment.asSlice(VkVideoSessionCreateInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkVideoSessionCreateInfoKHR allocate(Arena arena) {
        VkVideoSessionCreateInfoKHR ret = new VkVideoSessionCreateInfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.VIDEO_SESSION_CREATE_INFO_KHR);
        return ret;
    }

    public static VkVideoSessionCreateInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkVideoSessionCreateInfoKHR.Ptr ret = new VkVideoSessionCreateInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.VIDEO_SESSION_CREATE_INFO_KHR);
        }
        return ret;
    }

    public static VkVideoSessionCreateInfoKHR clone(Arena arena, VkVideoSessionCreateInfoKHR src) {
        VkVideoSessionCreateInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.VIDEO_SESSION_CREATE_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkVideoSessionCreateInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkVideoSessionCreateInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkVideoSessionCreateInfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int queueFamilyIndex() {
        return segment.get(LAYOUT$queueFamilyIndex, OFFSET$queueFamilyIndex);
    }

    public VkVideoSessionCreateInfoKHR queueFamilyIndex(@Unsigned int value) {
        segment.set(LAYOUT$queueFamilyIndex, OFFSET$queueFamilyIndex, value);
        return this;
    }

    public @Bitmask(VkVideoSessionCreateFlagsKHR.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkVideoSessionCreateInfoKHR flags(@Bitmask(VkVideoSessionCreateFlagsKHR.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public VkVideoSessionCreateInfoKHR pVideoProfile(@Nullable IVkVideoProfileInfoKHR value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pVideoProfileRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkVideoProfileInfoKHR.Ptr pVideoProfile(int assumedCount) {
        MemorySegment s = pVideoProfileRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkVideoProfileInfoKHR.BYTES);
        return new VkVideoProfileInfoKHR.Ptr(s);
    }

    public @Nullable VkVideoProfileInfoKHR pVideoProfile() {
        MemorySegment s = pVideoProfileRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkVideoProfileInfoKHR(s);
    }

    public @Pointer(target=VkVideoProfileInfoKHR.class) @NotNull MemorySegment pVideoProfileRaw() {
        return segment.get(LAYOUT$pVideoProfile, OFFSET$pVideoProfile);
    }

    public void pVideoProfileRaw(@Pointer(target=VkVideoProfileInfoKHR.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pVideoProfile, OFFSET$pVideoProfile, value);
    }

    public @EnumType(VkFormat.class) int pictureFormat() {
        return segment.get(LAYOUT$pictureFormat, OFFSET$pictureFormat);
    }

    public VkVideoSessionCreateInfoKHR pictureFormat(@EnumType(VkFormat.class) int value) {
        segment.set(LAYOUT$pictureFormat, OFFSET$pictureFormat, value);
        return this;
    }

    public @NotNull VkExtent2D maxCodedExtent() {
        return new VkExtent2D(segment.asSlice(OFFSET$maxCodedExtent, LAYOUT$maxCodedExtent));
    }

    public VkVideoSessionCreateInfoKHR maxCodedExtent(@NotNull VkExtent2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$maxCodedExtent, SIZE$maxCodedExtent);
        return this;
    }

    public VkVideoSessionCreateInfoKHR maxCodedExtent(Consumer<@NotNull VkExtent2D> consumer) {
        consumer.accept(maxCodedExtent());
        return this;
    }

    public @EnumType(VkFormat.class) int referencePictureFormat() {
        return segment.get(LAYOUT$referencePictureFormat, OFFSET$referencePictureFormat);
    }

    public VkVideoSessionCreateInfoKHR referencePictureFormat(@EnumType(VkFormat.class) int value) {
        segment.set(LAYOUT$referencePictureFormat, OFFSET$referencePictureFormat, value);
        return this;
    }

    public @Unsigned int maxDpbSlots() {
        return segment.get(LAYOUT$maxDpbSlots, OFFSET$maxDpbSlots);
    }

    public VkVideoSessionCreateInfoKHR maxDpbSlots(@Unsigned int value) {
        segment.set(LAYOUT$maxDpbSlots, OFFSET$maxDpbSlots, value);
        return this;
    }

    public @Unsigned int maxActiveReferencePictures() {
        return segment.get(LAYOUT$maxActiveReferencePictures, OFFSET$maxActiveReferencePictures);
    }

    public VkVideoSessionCreateInfoKHR maxActiveReferencePictures(@Unsigned int value) {
        segment.set(LAYOUT$maxActiveReferencePictures, OFFSET$maxActiveReferencePictures, value);
        return this;
    }

    public VkVideoSessionCreateInfoKHR pStdHeaderVersion(@Nullable IVkExtensionProperties value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pStdHeaderVersionRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkExtensionProperties.Ptr pStdHeaderVersion(int assumedCount) {
        MemorySegment s = pStdHeaderVersionRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkExtensionProperties.BYTES);
        return new VkExtensionProperties.Ptr(s);
    }

    public @Nullable VkExtensionProperties pStdHeaderVersion() {
        MemorySegment s = pStdHeaderVersionRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkExtensionProperties(s);
    }

    public @Pointer(target=VkExtensionProperties.class) @NotNull MemorySegment pStdHeaderVersionRaw() {
        return segment.get(LAYOUT$pStdHeaderVersion, OFFSET$pStdHeaderVersion);
    }

    public void pStdHeaderVersionRaw(@Pointer(target=VkExtensionProperties.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pStdHeaderVersion, OFFSET$pStdHeaderVersion, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("queueFamilyIndex"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.ADDRESS.withTargetLayout(VkVideoProfileInfoKHR.LAYOUT).withName("pVideoProfile"),
        ValueLayout.JAVA_INT.withName("pictureFormat"),
        VkExtent2D.LAYOUT.withName("maxCodedExtent"),
        ValueLayout.JAVA_INT.withName("referencePictureFormat"),
        ValueLayout.JAVA_INT.withName("maxDpbSlots"),
        ValueLayout.JAVA_INT.withName("maxActiveReferencePictures"),
        ValueLayout.ADDRESS.withTargetLayout(VkExtensionProperties.LAYOUT).withName("pStdHeaderVersion")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$queueFamilyIndex = PathElement.groupElement("queueFamilyIndex");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$pVideoProfile = PathElement.groupElement("pVideoProfile");
    public static final PathElement PATH$pictureFormat = PathElement.groupElement("pictureFormat");
    public static final PathElement PATH$maxCodedExtent = PathElement.groupElement("maxCodedExtent");
    public static final PathElement PATH$referencePictureFormat = PathElement.groupElement("referencePictureFormat");
    public static final PathElement PATH$maxDpbSlots = PathElement.groupElement("maxDpbSlots");
    public static final PathElement PATH$maxActiveReferencePictures = PathElement.groupElement("maxActiveReferencePictures");
    public static final PathElement PATH$pStdHeaderVersion = PathElement.groupElement("pStdHeaderVersion");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$queueFamilyIndex = (OfInt) LAYOUT.select(PATH$queueFamilyIndex);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final AddressLayout LAYOUT$pVideoProfile = (AddressLayout) LAYOUT.select(PATH$pVideoProfile);
    public static final OfInt LAYOUT$pictureFormat = (OfInt) LAYOUT.select(PATH$pictureFormat);
    public static final StructLayout LAYOUT$maxCodedExtent = (StructLayout) LAYOUT.select(PATH$maxCodedExtent);
    public static final OfInt LAYOUT$referencePictureFormat = (OfInt) LAYOUT.select(PATH$referencePictureFormat);
    public static final OfInt LAYOUT$maxDpbSlots = (OfInt) LAYOUT.select(PATH$maxDpbSlots);
    public static final OfInt LAYOUT$maxActiveReferencePictures = (OfInt) LAYOUT.select(PATH$maxActiveReferencePictures);
    public static final AddressLayout LAYOUT$pStdHeaderVersion = (AddressLayout) LAYOUT.select(PATH$pStdHeaderVersion);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$queueFamilyIndex = LAYOUT$queueFamilyIndex.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$pVideoProfile = LAYOUT$pVideoProfile.byteSize();
    public static final long SIZE$pictureFormat = LAYOUT$pictureFormat.byteSize();
    public static final long SIZE$maxCodedExtent = LAYOUT$maxCodedExtent.byteSize();
    public static final long SIZE$referencePictureFormat = LAYOUT$referencePictureFormat.byteSize();
    public static final long SIZE$maxDpbSlots = LAYOUT$maxDpbSlots.byteSize();
    public static final long SIZE$maxActiveReferencePictures = LAYOUT$maxActiveReferencePictures.byteSize();
    public static final long SIZE$pStdHeaderVersion = LAYOUT$pStdHeaderVersion.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$queueFamilyIndex = LAYOUT.byteOffset(PATH$queueFamilyIndex);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$pVideoProfile = LAYOUT.byteOffset(PATH$pVideoProfile);
    public static final long OFFSET$pictureFormat = LAYOUT.byteOffset(PATH$pictureFormat);
    public static final long OFFSET$maxCodedExtent = LAYOUT.byteOffset(PATH$maxCodedExtent);
    public static final long OFFSET$referencePictureFormat = LAYOUT.byteOffset(PATH$referencePictureFormat);
    public static final long OFFSET$maxDpbSlots = LAYOUT.byteOffset(PATH$maxDpbSlots);
    public static final long OFFSET$maxActiveReferencePictures = LAYOUT.byteOffset(PATH$maxActiveReferencePictures);
    public static final long OFFSET$pStdHeaderVersion = LAYOUT.byteOffset(PATH$pStdHeaderVersion);
}
