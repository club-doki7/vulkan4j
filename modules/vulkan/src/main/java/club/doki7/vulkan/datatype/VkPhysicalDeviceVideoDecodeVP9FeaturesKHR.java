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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceVideoDecodeVP9FeaturesKHR.html"><code>VkPhysicalDeviceVideoDecodeVP9FeaturesKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceVideoDecodeVP9FeaturesKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 videoDecodeVP9; // @link substring="videoDecodeVP9" target="#videoDecodeVP9"
/// } VkPhysicalDeviceVideoDecodeVP9FeaturesKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_VIDEO_DECODE_VP9_FEATURES_KHR`
///
/// The {@code allocate} ({@link VkPhysicalDeviceVideoDecodeVP9FeaturesKHR#allocate(Arena)}, {@link VkPhysicalDeviceVideoDecodeVP9FeaturesKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceVideoDecodeVP9FeaturesKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceVideoDecodeVP9FeaturesKHR.html"><code>VkPhysicalDeviceVideoDecodeVP9FeaturesKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceVideoDecodeVP9FeaturesKHR(@NotNull MemorySegment segment) implements IVkPhysicalDeviceVideoDecodeVP9FeaturesKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceVideoDecodeVP9FeaturesKHR.html"><code>VkPhysicalDeviceVideoDecodeVP9FeaturesKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceVideoDecodeVP9FeaturesKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceVideoDecodeVP9FeaturesKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceVideoDecodeVP9FeaturesKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceVideoDecodeVP9FeaturesKHR, Iterable<VkPhysicalDeviceVideoDecodeVP9FeaturesKHR> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceVideoDecodeVP9FeaturesKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceVideoDecodeVP9FeaturesKHR at(long index) {
            return new VkPhysicalDeviceVideoDecodeVP9FeaturesKHR(segment.asSlice(index * VkPhysicalDeviceVideoDecodeVP9FeaturesKHR.BYTES, VkPhysicalDeviceVideoDecodeVP9FeaturesKHR.BYTES));
        }

        public VkPhysicalDeviceVideoDecodeVP9FeaturesKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceVideoDecodeVP9FeaturesKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceVideoDecodeVP9FeaturesKHR value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceVideoDecodeVP9FeaturesKHR.BYTES, VkPhysicalDeviceVideoDecodeVP9FeaturesKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceVideoDecodeVP9FeaturesKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceVideoDecodeVP9FeaturesKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceVideoDecodeVP9FeaturesKHR.BYTES,
                (end - start) * VkPhysicalDeviceVideoDecodeVP9FeaturesKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceVideoDecodeVP9FeaturesKHR.BYTES));
        }

        public VkPhysicalDeviceVideoDecodeVP9FeaturesKHR[] toArray() {
            VkPhysicalDeviceVideoDecodeVP9FeaturesKHR[] ret = new VkPhysicalDeviceVideoDecodeVP9FeaturesKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceVideoDecodeVP9FeaturesKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceVideoDecodeVP9FeaturesKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceVideoDecodeVP9FeaturesKHR.BYTES;
            }

            @Override
            public VkPhysicalDeviceVideoDecodeVP9FeaturesKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceVideoDecodeVP9FeaturesKHR ret = new VkPhysicalDeviceVideoDecodeVP9FeaturesKHR(segment.asSlice(0, VkPhysicalDeviceVideoDecodeVP9FeaturesKHR.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceVideoDecodeVP9FeaturesKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceVideoDecodeVP9FeaturesKHR allocate(Arena arena) {
        VkPhysicalDeviceVideoDecodeVP9FeaturesKHR ret = new VkPhysicalDeviceVideoDecodeVP9FeaturesKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_VIDEO_DECODE_VP9_FEATURES_KHR);
        return ret;
    }

    public static VkPhysicalDeviceVideoDecodeVP9FeaturesKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceVideoDecodeVP9FeaturesKHR.Ptr ret = new VkPhysicalDeviceVideoDecodeVP9FeaturesKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_VIDEO_DECODE_VP9_FEATURES_KHR);
        }
        return ret;
    }

    public static VkPhysicalDeviceVideoDecodeVP9FeaturesKHR clone(Arena arena, VkPhysicalDeviceVideoDecodeVP9FeaturesKHR src) {
        VkPhysicalDeviceVideoDecodeVP9FeaturesKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_VIDEO_DECODE_VP9_FEATURES_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceVideoDecodeVP9FeaturesKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceVideoDecodeVP9FeaturesKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceVideoDecodeVP9FeaturesKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int videoDecodeVP9() {
        return segment.get(LAYOUT$videoDecodeVP9, OFFSET$videoDecodeVP9);
    }

    public VkPhysicalDeviceVideoDecodeVP9FeaturesKHR videoDecodeVP9(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$videoDecodeVP9, OFFSET$videoDecodeVP9, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("videoDecodeVP9")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$videoDecodeVP9 = PathElement.groupElement("videoDecodeVP9");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$videoDecodeVP9 = (OfInt) LAYOUT.select(PATH$videoDecodeVP9);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$videoDecodeVP9 = LAYOUT$videoDecodeVP9.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$videoDecodeVP9 = LAYOUT.byteOffset(PATH$videoDecodeVP9);
}
