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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceMaintenance9FeaturesKHR.html"><code>VkPhysicalDeviceMaintenance9FeaturesKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceMaintenance9FeaturesKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 maintenance9; // @link substring="maintenance9" target="#maintenance9"
/// } VkPhysicalDeviceMaintenance9FeaturesKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_MAINTENANCE_9_FEATURES_KHR`
///
/// The {@code allocate} ({@link VkPhysicalDeviceMaintenance9FeaturesKHR#allocate(Arena)}, {@link VkPhysicalDeviceMaintenance9FeaturesKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceMaintenance9FeaturesKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceMaintenance9FeaturesKHR.html"><code>VkPhysicalDeviceMaintenance9FeaturesKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceMaintenance9FeaturesKHR(@NotNull MemorySegment segment) implements IVkPhysicalDeviceMaintenance9FeaturesKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceMaintenance9FeaturesKHR.html"><code>VkPhysicalDeviceMaintenance9FeaturesKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceMaintenance9FeaturesKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceMaintenance9FeaturesKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceMaintenance9FeaturesKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceMaintenance9FeaturesKHR, Iterable<VkPhysicalDeviceMaintenance9FeaturesKHR> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceMaintenance9FeaturesKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceMaintenance9FeaturesKHR at(long index) {
            return new VkPhysicalDeviceMaintenance9FeaturesKHR(segment.asSlice(index * VkPhysicalDeviceMaintenance9FeaturesKHR.BYTES, VkPhysicalDeviceMaintenance9FeaturesKHR.BYTES));
        }

        public VkPhysicalDeviceMaintenance9FeaturesKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceMaintenance9FeaturesKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceMaintenance9FeaturesKHR value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceMaintenance9FeaturesKHR.BYTES, VkPhysicalDeviceMaintenance9FeaturesKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceMaintenance9FeaturesKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceMaintenance9FeaturesKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceMaintenance9FeaturesKHR.BYTES,
                (end - start) * VkPhysicalDeviceMaintenance9FeaturesKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceMaintenance9FeaturesKHR.BYTES));
        }

        public VkPhysicalDeviceMaintenance9FeaturesKHR[] toArray() {
            VkPhysicalDeviceMaintenance9FeaturesKHR[] ret = new VkPhysicalDeviceMaintenance9FeaturesKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceMaintenance9FeaturesKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceMaintenance9FeaturesKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceMaintenance9FeaturesKHR.BYTES;
            }

            @Override
            public VkPhysicalDeviceMaintenance9FeaturesKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceMaintenance9FeaturesKHR ret = new VkPhysicalDeviceMaintenance9FeaturesKHR(segment.asSlice(0, VkPhysicalDeviceMaintenance9FeaturesKHR.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceMaintenance9FeaturesKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceMaintenance9FeaturesKHR allocate(Arena arena) {
        VkPhysicalDeviceMaintenance9FeaturesKHR ret = new VkPhysicalDeviceMaintenance9FeaturesKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_MAINTENANCE_9_FEATURES_KHR);
        return ret;
    }

    public static VkPhysicalDeviceMaintenance9FeaturesKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceMaintenance9FeaturesKHR.Ptr ret = new VkPhysicalDeviceMaintenance9FeaturesKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_MAINTENANCE_9_FEATURES_KHR);
        }
        return ret;
    }

    public static VkPhysicalDeviceMaintenance9FeaturesKHR clone(Arena arena, VkPhysicalDeviceMaintenance9FeaturesKHR src) {
        VkPhysicalDeviceMaintenance9FeaturesKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_MAINTENANCE_9_FEATURES_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceMaintenance9FeaturesKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceMaintenance9FeaturesKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceMaintenance9FeaturesKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int maintenance9() {
        return segment.get(LAYOUT$maintenance9, OFFSET$maintenance9);
    }

    public VkPhysicalDeviceMaintenance9FeaturesKHR maintenance9(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$maintenance9, OFFSET$maintenance9, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("maintenance9")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$maintenance9 = PathElement.groupElement("maintenance9");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$maintenance9 = (OfInt) LAYOUT.select(PATH$maintenance9);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$maintenance9 = LAYOUT$maintenance9.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$maintenance9 = LAYOUT.byteOffset(PATH$maintenance9);
}
