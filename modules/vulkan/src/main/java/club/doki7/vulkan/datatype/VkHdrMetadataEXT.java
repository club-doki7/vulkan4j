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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkHdrMetadataEXT.html"><code>VkHdrMetadataEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkHdrMetadataEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkXYColorEXT displayPrimaryRed; // @link substring="VkXYColorEXT" target="VkXYColorEXT" @link substring="displayPrimaryRed" target="#displayPrimaryRed"
///     VkXYColorEXT displayPrimaryGreen; // @link substring="VkXYColorEXT" target="VkXYColorEXT" @link substring="displayPrimaryGreen" target="#displayPrimaryGreen"
///     VkXYColorEXT displayPrimaryBlue; // @link substring="VkXYColorEXT" target="VkXYColorEXT" @link substring="displayPrimaryBlue" target="#displayPrimaryBlue"
///     VkXYColorEXT whitePoint; // @link substring="VkXYColorEXT" target="VkXYColorEXT" @link substring="whitePoint" target="#whitePoint"
///     float maxLuminance; // @link substring="maxLuminance" target="#maxLuminance"
///     float minLuminance; // @link substring="minLuminance" target="#minLuminance"
///     float maxContentLightLevel; // @link substring="maxContentLightLevel" target="#maxContentLightLevel"
///     float maxFrameAverageLightLevel; // @link substring="maxFrameAverageLightLevel" target="#maxFrameAverageLightLevel"
/// } VkHdrMetadataEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_HDR_METADATA_EXT`
///
/// The {@code allocate} ({@link VkHdrMetadataEXT#allocate(Arena)}, {@link VkHdrMetadataEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkHdrMetadataEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkHdrMetadataEXT.html"><code>VkHdrMetadataEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkHdrMetadataEXT(@NotNull MemorySegment segment) implements IVkHdrMetadataEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkHdrMetadataEXT.html"><code>VkHdrMetadataEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkHdrMetadataEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkHdrMetadataEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkHdrMetadataEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkHdrMetadataEXT, Iterable<VkHdrMetadataEXT> {
        public long size() {
            return segment.byteSize() / VkHdrMetadataEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkHdrMetadataEXT at(long index) {
            return new VkHdrMetadataEXT(segment.asSlice(index * VkHdrMetadataEXT.BYTES, VkHdrMetadataEXT.BYTES));
        }

        public VkHdrMetadataEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkHdrMetadataEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkHdrMetadataEXT value) {
            MemorySegment s = segment.asSlice(index * VkHdrMetadataEXT.BYTES, VkHdrMetadataEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkHdrMetadataEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkHdrMetadataEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkHdrMetadataEXT.BYTES,
                (end - start) * VkHdrMetadataEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkHdrMetadataEXT.BYTES));
        }

        public VkHdrMetadataEXT[] toArray() {
            VkHdrMetadataEXT[] ret = new VkHdrMetadataEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkHdrMetadataEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkHdrMetadataEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkHdrMetadataEXT.BYTES;
            }

            @Override
            public VkHdrMetadataEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkHdrMetadataEXT ret = new VkHdrMetadataEXT(segment.asSlice(0, VkHdrMetadataEXT.BYTES));
                segment = segment.asSlice(VkHdrMetadataEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkHdrMetadataEXT allocate(Arena arena) {
        VkHdrMetadataEXT ret = new VkHdrMetadataEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.HDR_METADATA_EXT);
        return ret;
    }

    public static VkHdrMetadataEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkHdrMetadataEXT.Ptr ret = new VkHdrMetadataEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.HDR_METADATA_EXT);
        }
        return ret;
    }

    public static VkHdrMetadataEXT clone(Arena arena, VkHdrMetadataEXT src) {
        VkHdrMetadataEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.HDR_METADATA_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkHdrMetadataEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkHdrMetadataEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkHdrMetadataEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NotNull VkXYColorEXT displayPrimaryRed() {
        return new VkXYColorEXT(segment.asSlice(OFFSET$displayPrimaryRed, LAYOUT$displayPrimaryRed));
    }

    public VkHdrMetadataEXT displayPrimaryRed(@NotNull VkXYColorEXT value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$displayPrimaryRed, SIZE$displayPrimaryRed);
        return this;
    }

    public VkHdrMetadataEXT displayPrimaryRed(Consumer<@NotNull VkXYColorEXT> consumer) {
        consumer.accept(displayPrimaryRed());
        return this;
    }

    public @NotNull VkXYColorEXT displayPrimaryGreen() {
        return new VkXYColorEXT(segment.asSlice(OFFSET$displayPrimaryGreen, LAYOUT$displayPrimaryGreen));
    }

    public VkHdrMetadataEXT displayPrimaryGreen(@NotNull VkXYColorEXT value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$displayPrimaryGreen, SIZE$displayPrimaryGreen);
        return this;
    }

    public VkHdrMetadataEXT displayPrimaryGreen(Consumer<@NotNull VkXYColorEXT> consumer) {
        consumer.accept(displayPrimaryGreen());
        return this;
    }

    public @NotNull VkXYColorEXT displayPrimaryBlue() {
        return new VkXYColorEXT(segment.asSlice(OFFSET$displayPrimaryBlue, LAYOUT$displayPrimaryBlue));
    }

    public VkHdrMetadataEXT displayPrimaryBlue(@NotNull VkXYColorEXT value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$displayPrimaryBlue, SIZE$displayPrimaryBlue);
        return this;
    }

    public VkHdrMetadataEXT displayPrimaryBlue(Consumer<@NotNull VkXYColorEXT> consumer) {
        consumer.accept(displayPrimaryBlue());
        return this;
    }

    public @NotNull VkXYColorEXT whitePoint() {
        return new VkXYColorEXT(segment.asSlice(OFFSET$whitePoint, LAYOUT$whitePoint));
    }

    public VkHdrMetadataEXT whitePoint(@NotNull VkXYColorEXT value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$whitePoint, SIZE$whitePoint);
        return this;
    }

    public VkHdrMetadataEXT whitePoint(Consumer<@NotNull VkXYColorEXT> consumer) {
        consumer.accept(whitePoint());
        return this;
    }

    public float maxLuminance() {
        return segment.get(LAYOUT$maxLuminance, OFFSET$maxLuminance);
    }

    public VkHdrMetadataEXT maxLuminance(float value) {
        segment.set(LAYOUT$maxLuminance, OFFSET$maxLuminance, value);
        return this;
    }

    public float minLuminance() {
        return segment.get(LAYOUT$minLuminance, OFFSET$minLuminance);
    }

    public VkHdrMetadataEXT minLuminance(float value) {
        segment.set(LAYOUT$minLuminance, OFFSET$minLuminance, value);
        return this;
    }

    public float maxContentLightLevel() {
        return segment.get(LAYOUT$maxContentLightLevel, OFFSET$maxContentLightLevel);
    }

    public VkHdrMetadataEXT maxContentLightLevel(float value) {
        segment.set(LAYOUT$maxContentLightLevel, OFFSET$maxContentLightLevel, value);
        return this;
    }

    public float maxFrameAverageLightLevel() {
        return segment.get(LAYOUT$maxFrameAverageLightLevel, OFFSET$maxFrameAverageLightLevel);
    }

    public VkHdrMetadataEXT maxFrameAverageLightLevel(float value) {
        segment.set(LAYOUT$maxFrameAverageLightLevel, OFFSET$maxFrameAverageLightLevel, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        VkXYColorEXT.LAYOUT.withName("displayPrimaryRed"),
        VkXYColorEXT.LAYOUT.withName("displayPrimaryGreen"),
        VkXYColorEXT.LAYOUT.withName("displayPrimaryBlue"),
        VkXYColorEXT.LAYOUT.withName("whitePoint"),
        ValueLayout.JAVA_FLOAT.withName("maxLuminance"),
        ValueLayout.JAVA_FLOAT.withName("minLuminance"),
        ValueLayout.JAVA_FLOAT.withName("maxContentLightLevel"),
        ValueLayout.JAVA_FLOAT.withName("maxFrameAverageLightLevel")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$displayPrimaryRed = PathElement.groupElement("displayPrimaryRed");
    public static final PathElement PATH$displayPrimaryGreen = PathElement.groupElement("displayPrimaryGreen");
    public static final PathElement PATH$displayPrimaryBlue = PathElement.groupElement("displayPrimaryBlue");
    public static final PathElement PATH$whitePoint = PathElement.groupElement("whitePoint");
    public static final PathElement PATH$maxLuminance = PathElement.groupElement("maxLuminance");
    public static final PathElement PATH$minLuminance = PathElement.groupElement("minLuminance");
    public static final PathElement PATH$maxContentLightLevel = PathElement.groupElement("maxContentLightLevel");
    public static final PathElement PATH$maxFrameAverageLightLevel = PathElement.groupElement("maxFrameAverageLightLevel");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final StructLayout LAYOUT$displayPrimaryRed = (StructLayout) LAYOUT.select(PATH$displayPrimaryRed);
    public static final StructLayout LAYOUT$displayPrimaryGreen = (StructLayout) LAYOUT.select(PATH$displayPrimaryGreen);
    public static final StructLayout LAYOUT$displayPrimaryBlue = (StructLayout) LAYOUT.select(PATH$displayPrimaryBlue);
    public static final StructLayout LAYOUT$whitePoint = (StructLayout) LAYOUT.select(PATH$whitePoint);
    public static final OfFloat LAYOUT$maxLuminance = (OfFloat) LAYOUT.select(PATH$maxLuminance);
    public static final OfFloat LAYOUT$minLuminance = (OfFloat) LAYOUT.select(PATH$minLuminance);
    public static final OfFloat LAYOUT$maxContentLightLevel = (OfFloat) LAYOUT.select(PATH$maxContentLightLevel);
    public static final OfFloat LAYOUT$maxFrameAverageLightLevel = (OfFloat) LAYOUT.select(PATH$maxFrameAverageLightLevel);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$displayPrimaryRed = LAYOUT$displayPrimaryRed.byteSize();
    public static final long SIZE$displayPrimaryGreen = LAYOUT$displayPrimaryGreen.byteSize();
    public static final long SIZE$displayPrimaryBlue = LAYOUT$displayPrimaryBlue.byteSize();
    public static final long SIZE$whitePoint = LAYOUT$whitePoint.byteSize();
    public static final long SIZE$maxLuminance = LAYOUT$maxLuminance.byteSize();
    public static final long SIZE$minLuminance = LAYOUT$minLuminance.byteSize();
    public static final long SIZE$maxContentLightLevel = LAYOUT$maxContentLightLevel.byteSize();
    public static final long SIZE$maxFrameAverageLightLevel = LAYOUT$maxFrameAverageLightLevel.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$displayPrimaryRed = LAYOUT.byteOffset(PATH$displayPrimaryRed);
    public static final long OFFSET$displayPrimaryGreen = LAYOUT.byteOffset(PATH$displayPrimaryGreen);
    public static final long OFFSET$displayPrimaryBlue = LAYOUT.byteOffset(PATH$displayPrimaryBlue);
    public static final long OFFSET$whitePoint = LAYOUT.byteOffset(PATH$whitePoint);
    public static final long OFFSET$maxLuminance = LAYOUT.byteOffset(PATH$maxLuminance);
    public static final long OFFSET$minLuminance = LAYOUT.byteOffset(PATH$minLuminance);
    public static final long OFFSET$maxContentLightLevel = LAYOUT.byteOffset(PATH$maxContentLightLevel);
    public static final long OFFSET$maxFrameAverageLightLevel = LAYOUT.byteOffset(PATH$maxFrameAverageLightLevel);
}
