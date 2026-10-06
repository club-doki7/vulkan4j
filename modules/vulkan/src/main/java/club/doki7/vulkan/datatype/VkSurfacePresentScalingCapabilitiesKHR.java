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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSurfacePresentScalingCapabilitiesKHR.html"><code>VkSurfacePresentScalingCapabilitiesKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkSurfacePresentScalingCapabilitiesKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkPresentScalingFlagsKHR supportedPresentScaling; // optional // @link substring="VkPresentScalingFlagsKHR" target="VkPresentScalingFlagsKHR" @link substring="supportedPresentScaling" target="#supportedPresentScaling"
///     VkPresentGravityFlagsKHR supportedPresentGravityX; // optional // @link substring="VkPresentGravityFlagsKHR" target="VkPresentGravityFlagsKHR" @link substring="supportedPresentGravityX" target="#supportedPresentGravityX"
///     VkPresentGravityFlagsKHR supportedPresentGravityY; // optional // @link substring="VkPresentGravityFlagsKHR" target="VkPresentGravityFlagsKHR" @link substring="supportedPresentGravityY" target="#supportedPresentGravityY"
///     VkExtent2D minScaledImageExtent; // optional // @link substring="VkExtent2D" target="VkExtent2D" @link substring="minScaledImageExtent" target="#minScaledImageExtent"
///     VkExtent2D maxScaledImageExtent; // optional // @link substring="VkExtent2D" target="VkExtent2D" @link substring="maxScaledImageExtent" target="#maxScaledImageExtent"
/// } VkSurfacePresentScalingCapabilitiesKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_SURFACE_PRESENT_SCALING_CAPABILITIES_KHR`
///
/// The {@code allocate} ({@link VkSurfacePresentScalingCapabilitiesKHR#allocate(Arena)}, {@link VkSurfacePresentScalingCapabilitiesKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkSurfacePresentScalingCapabilitiesKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSurfacePresentScalingCapabilitiesKHR.html"><code>VkSurfacePresentScalingCapabilitiesKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkSurfacePresentScalingCapabilitiesKHR(@NotNull MemorySegment segment) implements IVkSurfacePresentScalingCapabilitiesKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSurfacePresentScalingCapabilitiesKHR.html"><code>VkSurfacePresentScalingCapabilitiesKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkSurfacePresentScalingCapabilitiesKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkSurfacePresentScalingCapabilitiesKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkSurfacePresentScalingCapabilitiesKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkSurfacePresentScalingCapabilitiesKHR, Iterable<VkSurfacePresentScalingCapabilitiesKHR> {
        public long size() {
            return segment.byteSize() / VkSurfacePresentScalingCapabilitiesKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkSurfacePresentScalingCapabilitiesKHR at(long index) {
            return new VkSurfacePresentScalingCapabilitiesKHR(segment.asSlice(index * VkSurfacePresentScalingCapabilitiesKHR.BYTES, VkSurfacePresentScalingCapabilitiesKHR.BYTES));
        }

        public VkSurfacePresentScalingCapabilitiesKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkSurfacePresentScalingCapabilitiesKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkSurfacePresentScalingCapabilitiesKHR value) {
            MemorySegment s = segment.asSlice(index * VkSurfacePresentScalingCapabilitiesKHR.BYTES, VkSurfacePresentScalingCapabilitiesKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkSurfacePresentScalingCapabilitiesKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkSurfacePresentScalingCapabilitiesKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkSurfacePresentScalingCapabilitiesKHR.BYTES,
                (end - start) * VkSurfacePresentScalingCapabilitiesKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkSurfacePresentScalingCapabilitiesKHR.BYTES));
        }

        public VkSurfacePresentScalingCapabilitiesKHR[] toArray() {
            VkSurfacePresentScalingCapabilitiesKHR[] ret = new VkSurfacePresentScalingCapabilitiesKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkSurfacePresentScalingCapabilitiesKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkSurfacePresentScalingCapabilitiesKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkSurfacePresentScalingCapabilitiesKHR.BYTES;
            }

            @Override
            public VkSurfacePresentScalingCapabilitiesKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkSurfacePresentScalingCapabilitiesKHR ret = new VkSurfacePresentScalingCapabilitiesKHR(segment.asSlice(0, VkSurfacePresentScalingCapabilitiesKHR.BYTES));
                segment = segment.asSlice(VkSurfacePresentScalingCapabilitiesKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkSurfacePresentScalingCapabilitiesKHR allocate(Arena arena) {
        VkSurfacePresentScalingCapabilitiesKHR ret = new VkSurfacePresentScalingCapabilitiesKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.SURFACE_PRESENT_SCALING_CAPABILITIES_KHR);
        return ret;
    }

    public static VkSurfacePresentScalingCapabilitiesKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkSurfacePresentScalingCapabilitiesKHR.Ptr ret = new VkSurfacePresentScalingCapabilitiesKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.SURFACE_PRESENT_SCALING_CAPABILITIES_KHR);
        }
        return ret;
    }

    public static VkSurfacePresentScalingCapabilitiesKHR clone(Arena arena, VkSurfacePresentScalingCapabilitiesKHR src) {
        VkSurfacePresentScalingCapabilitiesKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.SURFACE_PRESENT_SCALING_CAPABILITIES_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkSurfacePresentScalingCapabilitiesKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkSurfacePresentScalingCapabilitiesKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkSurfacePresentScalingCapabilitiesKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkPresentScalingFlagsKHR.class) int supportedPresentScaling() {
        return segment.get(LAYOUT$supportedPresentScaling, OFFSET$supportedPresentScaling);
    }

    public VkSurfacePresentScalingCapabilitiesKHR supportedPresentScaling(@Bitmask(VkPresentScalingFlagsKHR.class) int value) {
        segment.set(LAYOUT$supportedPresentScaling, OFFSET$supportedPresentScaling, value);
        return this;
    }

    public @Bitmask(VkPresentGravityFlagsKHR.class) int supportedPresentGravityX() {
        return segment.get(LAYOUT$supportedPresentGravityX, OFFSET$supportedPresentGravityX);
    }

    public VkSurfacePresentScalingCapabilitiesKHR supportedPresentGravityX(@Bitmask(VkPresentGravityFlagsKHR.class) int value) {
        segment.set(LAYOUT$supportedPresentGravityX, OFFSET$supportedPresentGravityX, value);
        return this;
    }

    public @Bitmask(VkPresentGravityFlagsKHR.class) int supportedPresentGravityY() {
        return segment.get(LAYOUT$supportedPresentGravityY, OFFSET$supportedPresentGravityY);
    }

    public VkSurfacePresentScalingCapabilitiesKHR supportedPresentGravityY(@Bitmask(VkPresentGravityFlagsKHR.class) int value) {
        segment.set(LAYOUT$supportedPresentGravityY, OFFSET$supportedPresentGravityY, value);
        return this;
    }

    public @NotNull VkExtent2D minScaledImageExtent() {
        return new VkExtent2D(segment.asSlice(OFFSET$minScaledImageExtent, LAYOUT$minScaledImageExtent));
    }

    public VkSurfacePresentScalingCapabilitiesKHR minScaledImageExtent(@NotNull VkExtent2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$minScaledImageExtent, SIZE$minScaledImageExtent);
        return this;
    }

    public VkSurfacePresentScalingCapabilitiesKHR minScaledImageExtent(Consumer<@NotNull VkExtent2D> consumer) {
        consumer.accept(minScaledImageExtent());
        return this;
    }

    public @NotNull VkExtent2D maxScaledImageExtent() {
        return new VkExtent2D(segment.asSlice(OFFSET$maxScaledImageExtent, LAYOUT$maxScaledImageExtent));
    }

    public VkSurfacePresentScalingCapabilitiesKHR maxScaledImageExtent(@NotNull VkExtent2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$maxScaledImageExtent, SIZE$maxScaledImageExtent);
        return this;
    }

    public VkSurfacePresentScalingCapabilitiesKHR maxScaledImageExtent(Consumer<@NotNull VkExtent2D> consumer) {
        consumer.accept(maxScaledImageExtent());
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("supportedPresentScaling"),
        ValueLayout.JAVA_INT.withName("supportedPresentGravityX"),
        ValueLayout.JAVA_INT.withName("supportedPresentGravityY"),
        VkExtent2D.LAYOUT.withName("minScaledImageExtent"),
        VkExtent2D.LAYOUT.withName("maxScaledImageExtent")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$supportedPresentScaling = PathElement.groupElement("supportedPresentScaling");
    public static final PathElement PATH$supportedPresentGravityX = PathElement.groupElement("supportedPresentGravityX");
    public static final PathElement PATH$supportedPresentGravityY = PathElement.groupElement("supportedPresentGravityY");
    public static final PathElement PATH$minScaledImageExtent = PathElement.groupElement("minScaledImageExtent");
    public static final PathElement PATH$maxScaledImageExtent = PathElement.groupElement("maxScaledImageExtent");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$supportedPresentScaling = (OfInt) LAYOUT.select(PATH$supportedPresentScaling);
    public static final OfInt LAYOUT$supportedPresentGravityX = (OfInt) LAYOUT.select(PATH$supportedPresentGravityX);
    public static final OfInt LAYOUT$supportedPresentGravityY = (OfInt) LAYOUT.select(PATH$supportedPresentGravityY);
    public static final StructLayout LAYOUT$minScaledImageExtent = (StructLayout) LAYOUT.select(PATH$minScaledImageExtent);
    public static final StructLayout LAYOUT$maxScaledImageExtent = (StructLayout) LAYOUT.select(PATH$maxScaledImageExtent);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$supportedPresentScaling = LAYOUT$supportedPresentScaling.byteSize();
    public static final long SIZE$supportedPresentGravityX = LAYOUT$supportedPresentGravityX.byteSize();
    public static final long SIZE$supportedPresentGravityY = LAYOUT$supportedPresentGravityY.byteSize();
    public static final long SIZE$minScaledImageExtent = LAYOUT$minScaledImageExtent.byteSize();
    public static final long SIZE$maxScaledImageExtent = LAYOUT$maxScaledImageExtent.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$supportedPresentScaling = LAYOUT.byteOffset(PATH$supportedPresentScaling);
    public static final long OFFSET$supportedPresentGravityX = LAYOUT.byteOffset(PATH$supportedPresentGravityX);
    public static final long OFFSET$supportedPresentGravityY = LAYOUT.byteOffset(PATH$supportedPresentGravityY);
    public static final long OFFSET$minScaledImageExtent = LAYOUT.byteOffset(PATH$minScaledImageExtent);
    public static final long OFFSET$maxScaledImageExtent = LAYOUT.byteOffset(PATH$maxScaledImageExtent);
}
