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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR.html"><code>VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkVideoProfileInfoKHR const* pVideoProfile; // @link substring="VkVideoProfileInfoKHR" target="VkVideoProfileInfoKHR" @link substring="pVideoProfile" target="#pVideoProfile"
///     uint32_t qualityLevel; // @link substring="qualityLevel" target="#qualityLevel"
/// } VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_VIDEO_ENCODE_QUALITY_LEVEL_INFO_KHR`
///
/// The {@code allocate} ({@link VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR#allocate(Arena)}, {@link VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR.html"><code>VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR(@NotNull MemorySegment segment) implements IVkPhysicalDeviceVideoEncodeQualityLevelInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR.html"><code>VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceVideoEncodeQualityLevelInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceVideoEncodeQualityLevelInfoKHR, Iterable<VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR at(long index) {
            return new VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR(segment.asSlice(index * VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR.BYTES, VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR.BYTES));
        }

        public VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR.BYTES, VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR.BYTES,
                (end - start) * VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR.BYTES));
        }

        public VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR[] toArray() {
            VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR[] ret = new VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR.BYTES;
            }

            @Override
            public VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR ret = new VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR(segment.asSlice(0, VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR allocate(Arena arena) {
        VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR ret = new VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_VIDEO_ENCODE_QUALITY_LEVEL_INFO_KHR);
        return ret;
    }

    public static VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR.Ptr ret = new VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_VIDEO_ENCODE_QUALITY_LEVEL_INFO_KHR);
        }
        return ret;
    }

    public static VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR clone(Arena arena, VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR src) {
        VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_VIDEO_ENCODE_QUALITY_LEVEL_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR pVideoProfile(@Nullable IVkVideoProfileInfoKHR value) {
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

    public @Unsigned int qualityLevel() {
        return segment.get(LAYOUT$qualityLevel, OFFSET$qualityLevel);
    }

    public VkPhysicalDeviceVideoEncodeQualityLevelInfoKHR qualityLevel(@Unsigned int value) {
        segment.set(LAYOUT$qualityLevel, OFFSET$qualityLevel, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withTargetLayout(VkVideoProfileInfoKHR.LAYOUT).withName("pVideoProfile"),
        ValueLayout.JAVA_INT.withName("qualityLevel")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$pVideoProfile = PathElement.groupElement("pVideoProfile");
    public static final PathElement PATH$qualityLevel = PathElement.groupElement("qualityLevel");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$pVideoProfile = (AddressLayout) LAYOUT.select(PATH$pVideoProfile);
    public static final OfInt LAYOUT$qualityLevel = (OfInt) LAYOUT.select(PATH$qualityLevel);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$pVideoProfile = LAYOUT$pVideoProfile.byteSize();
    public static final long SIZE$qualityLevel = LAYOUT$qualityLevel.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$pVideoProfile = LAYOUT.byteOffset(PATH$pVideoProfile);
    public static final long OFFSET$qualityLevel = LAYOUT.byteOffset(PATH$qualityLevel);
}
