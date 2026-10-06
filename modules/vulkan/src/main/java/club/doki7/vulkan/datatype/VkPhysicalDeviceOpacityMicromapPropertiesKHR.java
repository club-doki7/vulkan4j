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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceOpacityMicromapPropertiesKHR.html"><code>VkPhysicalDeviceOpacityMicromapPropertiesKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceOpacityMicromapPropertiesKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t maxOpacity2StateSubdivisionLevel; // @link substring="maxOpacity2StateSubdivisionLevel" target="#maxOpacity2StateSubdivisionLevel"
///     uint32_t maxOpacity4StateSubdivisionLevel; // @link substring="maxOpacity4StateSubdivisionLevel" target="#maxOpacity4StateSubdivisionLevel"
///     uint32_t maxOpacityLossy4StateSubdivisionLevel; // @link substring="maxOpacityLossy4StateSubdivisionLevel" target="#maxOpacityLossy4StateSubdivisionLevel"
///     uint64_t maxMicromapTriangles; // @link substring="maxMicromapTriangles" target="#maxMicromapTriangles"
/// } VkPhysicalDeviceOpacityMicromapPropertiesKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_OPACITY_MICROMAP_PROPERTIES_KHR`
///
/// The {@code allocate} ({@link VkPhysicalDeviceOpacityMicromapPropertiesKHR#allocate(Arena)}, {@link VkPhysicalDeviceOpacityMicromapPropertiesKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceOpacityMicromapPropertiesKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceOpacityMicromapPropertiesKHR.html"><code>VkPhysicalDeviceOpacityMicromapPropertiesKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceOpacityMicromapPropertiesKHR(@NotNull MemorySegment segment) implements IVkPhysicalDeviceOpacityMicromapPropertiesKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceOpacityMicromapPropertiesKHR.html"><code>VkPhysicalDeviceOpacityMicromapPropertiesKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceOpacityMicromapPropertiesKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceOpacityMicromapPropertiesKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceOpacityMicromapPropertiesKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceOpacityMicromapPropertiesKHR, Iterable<VkPhysicalDeviceOpacityMicromapPropertiesKHR> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceOpacityMicromapPropertiesKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceOpacityMicromapPropertiesKHR at(long index) {
            return new VkPhysicalDeviceOpacityMicromapPropertiesKHR(segment.asSlice(index * VkPhysicalDeviceOpacityMicromapPropertiesKHR.BYTES, VkPhysicalDeviceOpacityMicromapPropertiesKHR.BYTES));
        }

        public VkPhysicalDeviceOpacityMicromapPropertiesKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceOpacityMicromapPropertiesKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceOpacityMicromapPropertiesKHR value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceOpacityMicromapPropertiesKHR.BYTES, VkPhysicalDeviceOpacityMicromapPropertiesKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceOpacityMicromapPropertiesKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceOpacityMicromapPropertiesKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceOpacityMicromapPropertiesKHR.BYTES,
                (end - start) * VkPhysicalDeviceOpacityMicromapPropertiesKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceOpacityMicromapPropertiesKHR.BYTES));
        }

        public VkPhysicalDeviceOpacityMicromapPropertiesKHR[] toArray() {
            VkPhysicalDeviceOpacityMicromapPropertiesKHR[] ret = new VkPhysicalDeviceOpacityMicromapPropertiesKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceOpacityMicromapPropertiesKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceOpacityMicromapPropertiesKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceOpacityMicromapPropertiesKHR.BYTES;
            }

            @Override
            public VkPhysicalDeviceOpacityMicromapPropertiesKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceOpacityMicromapPropertiesKHR ret = new VkPhysicalDeviceOpacityMicromapPropertiesKHR(segment.asSlice(0, VkPhysicalDeviceOpacityMicromapPropertiesKHR.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceOpacityMicromapPropertiesKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceOpacityMicromapPropertiesKHR allocate(Arena arena) {
        VkPhysicalDeviceOpacityMicromapPropertiesKHR ret = new VkPhysicalDeviceOpacityMicromapPropertiesKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_OPACITY_MICROMAP_PROPERTIES_KHR);
        return ret;
    }

    public static VkPhysicalDeviceOpacityMicromapPropertiesKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceOpacityMicromapPropertiesKHR.Ptr ret = new VkPhysicalDeviceOpacityMicromapPropertiesKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_OPACITY_MICROMAP_PROPERTIES_KHR);
        }
        return ret;
    }

    public static VkPhysicalDeviceOpacityMicromapPropertiesKHR clone(Arena arena, VkPhysicalDeviceOpacityMicromapPropertiesKHR src) {
        VkPhysicalDeviceOpacityMicromapPropertiesKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_OPACITY_MICROMAP_PROPERTIES_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceOpacityMicromapPropertiesKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceOpacityMicromapPropertiesKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceOpacityMicromapPropertiesKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int maxOpacity2StateSubdivisionLevel() {
        return segment.get(LAYOUT$maxOpacity2StateSubdivisionLevel, OFFSET$maxOpacity2StateSubdivisionLevel);
    }

    public VkPhysicalDeviceOpacityMicromapPropertiesKHR maxOpacity2StateSubdivisionLevel(@Unsigned int value) {
        segment.set(LAYOUT$maxOpacity2StateSubdivisionLevel, OFFSET$maxOpacity2StateSubdivisionLevel, value);
        return this;
    }

    public @Unsigned int maxOpacity4StateSubdivisionLevel() {
        return segment.get(LAYOUT$maxOpacity4StateSubdivisionLevel, OFFSET$maxOpacity4StateSubdivisionLevel);
    }

    public VkPhysicalDeviceOpacityMicromapPropertiesKHR maxOpacity4StateSubdivisionLevel(@Unsigned int value) {
        segment.set(LAYOUT$maxOpacity4StateSubdivisionLevel, OFFSET$maxOpacity4StateSubdivisionLevel, value);
        return this;
    }

    public @Unsigned int maxOpacityLossy4StateSubdivisionLevel() {
        return segment.get(LAYOUT$maxOpacityLossy4StateSubdivisionLevel, OFFSET$maxOpacityLossy4StateSubdivisionLevel);
    }

    public VkPhysicalDeviceOpacityMicromapPropertiesKHR maxOpacityLossy4StateSubdivisionLevel(@Unsigned int value) {
        segment.set(LAYOUT$maxOpacityLossy4StateSubdivisionLevel, OFFSET$maxOpacityLossy4StateSubdivisionLevel, value);
        return this;
    }

    public @Unsigned long maxMicromapTriangles() {
        return segment.get(LAYOUT$maxMicromapTriangles, OFFSET$maxMicromapTriangles);
    }

    public VkPhysicalDeviceOpacityMicromapPropertiesKHR maxMicromapTriangles(@Unsigned long value) {
        segment.set(LAYOUT$maxMicromapTriangles, OFFSET$maxMicromapTriangles, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("maxOpacity2StateSubdivisionLevel"),
        ValueLayout.JAVA_INT.withName("maxOpacity4StateSubdivisionLevel"),
        ValueLayout.JAVA_INT.withName("maxOpacityLossy4StateSubdivisionLevel"),
        ValueLayout.JAVA_LONG.withName("maxMicromapTriangles")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$maxOpacity2StateSubdivisionLevel = PathElement.groupElement("maxOpacity2StateSubdivisionLevel");
    public static final PathElement PATH$maxOpacity4StateSubdivisionLevel = PathElement.groupElement("maxOpacity4StateSubdivisionLevel");
    public static final PathElement PATH$maxOpacityLossy4StateSubdivisionLevel = PathElement.groupElement("maxOpacityLossy4StateSubdivisionLevel");
    public static final PathElement PATH$maxMicromapTriangles = PathElement.groupElement("maxMicromapTriangles");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$maxOpacity2StateSubdivisionLevel = (OfInt) LAYOUT.select(PATH$maxOpacity2StateSubdivisionLevel);
    public static final OfInt LAYOUT$maxOpacity4StateSubdivisionLevel = (OfInt) LAYOUT.select(PATH$maxOpacity4StateSubdivisionLevel);
    public static final OfInt LAYOUT$maxOpacityLossy4StateSubdivisionLevel = (OfInt) LAYOUT.select(PATH$maxOpacityLossy4StateSubdivisionLevel);
    public static final OfLong LAYOUT$maxMicromapTriangles = (OfLong) LAYOUT.select(PATH$maxMicromapTriangles);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$maxOpacity2StateSubdivisionLevel = LAYOUT$maxOpacity2StateSubdivisionLevel.byteSize();
    public static final long SIZE$maxOpacity4StateSubdivisionLevel = LAYOUT$maxOpacity4StateSubdivisionLevel.byteSize();
    public static final long SIZE$maxOpacityLossy4StateSubdivisionLevel = LAYOUT$maxOpacityLossy4StateSubdivisionLevel.byteSize();
    public static final long SIZE$maxMicromapTriangles = LAYOUT$maxMicromapTriangles.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$maxOpacity2StateSubdivisionLevel = LAYOUT.byteOffset(PATH$maxOpacity2StateSubdivisionLevel);
    public static final long OFFSET$maxOpacity4StateSubdivisionLevel = LAYOUT.byteOffset(PATH$maxOpacity4StateSubdivisionLevel);
    public static final long OFFSET$maxOpacityLossy4StateSubdivisionLevel = LAYOUT.byteOffset(PATH$maxOpacityLossy4StateSubdivisionLevel);
    public static final long OFFSET$maxMicromapTriangles = LAYOUT.byteOffset(PATH$maxMicromapTriangles);
}
