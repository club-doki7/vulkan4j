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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceMaintenance10PropertiesKHR.html"><code>VkPhysicalDeviceMaintenance10PropertiesKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceMaintenance10PropertiesKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 rgba4OpaqueBlackSwizzled; // @link substring="rgba4OpaqueBlackSwizzled" target="#rgba4OpaqueBlackSwizzled"
///     VkBool32 resolveSrgbFormatAppliesTransferFunction; // @link substring="resolveSrgbFormatAppliesTransferFunction" target="#resolveSrgbFormatAppliesTransferFunction"
///     VkBool32 resolveSrgbFormatSupportsTransferFunctionControl; // @link substring="resolveSrgbFormatSupportsTransferFunctionControl" target="#resolveSrgbFormatSupportsTransferFunctionControl"
/// } VkPhysicalDeviceMaintenance10PropertiesKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_MAINTENANCE_10_PROPERTIES_KHR`
///
/// The {@code allocate} ({@link VkPhysicalDeviceMaintenance10PropertiesKHR#allocate(Arena)}, {@link VkPhysicalDeviceMaintenance10PropertiesKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceMaintenance10PropertiesKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceMaintenance10PropertiesKHR.html"><code>VkPhysicalDeviceMaintenance10PropertiesKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceMaintenance10PropertiesKHR(@NotNull MemorySegment segment) implements IVkPhysicalDeviceMaintenance10PropertiesKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceMaintenance10PropertiesKHR.html"><code>VkPhysicalDeviceMaintenance10PropertiesKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceMaintenance10PropertiesKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceMaintenance10PropertiesKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceMaintenance10PropertiesKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceMaintenance10PropertiesKHR, Iterable<VkPhysicalDeviceMaintenance10PropertiesKHR> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceMaintenance10PropertiesKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceMaintenance10PropertiesKHR at(long index) {
            return new VkPhysicalDeviceMaintenance10PropertiesKHR(segment.asSlice(index * VkPhysicalDeviceMaintenance10PropertiesKHR.BYTES, VkPhysicalDeviceMaintenance10PropertiesKHR.BYTES));
        }

        public VkPhysicalDeviceMaintenance10PropertiesKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceMaintenance10PropertiesKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceMaintenance10PropertiesKHR value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceMaintenance10PropertiesKHR.BYTES, VkPhysicalDeviceMaintenance10PropertiesKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceMaintenance10PropertiesKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceMaintenance10PropertiesKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceMaintenance10PropertiesKHR.BYTES,
                (end - start) * VkPhysicalDeviceMaintenance10PropertiesKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceMaintenance10PropertiesKHR.BYTES));
        }

        public VkPhysicalDeviceMaintenance10PropertiesKHR[] toArray() {
            VkPhysicalDeviceMaintenance10PropertiesKHR[] ret = new VkPhysicalDeviceMaintenance10PropertiesKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceMaintenance10PropertiesKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceMaintenance10PropertiesKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceMaintenance10PropertiesKHR.BYTES;
            }

            @Override
            public VkPhysicalDeviceMaintenance10PropertiesKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceMaintenance10PropertiesKHR ret = new VkPhysicalDeviceMaintenance10PropertiesKHR(segment.asSlice(0, VkPhysicalDeviceMaintenance10PropertiesKHR.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceMaintenance10PropertiesKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceMaintenance10PropertiesKHR allocate(Arena arena) {
        VkPhysicalDeviceMaintenance10PropertiesKHR ret = new VkPhysicalDeviceMaintenance10PropertiesKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_MAINTENANCE_10_PROPERTIES_KHR);
        return ret;
    }

    public static VkPhysicalDeviceMaintenance10PropertiesKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceMaintenance10PropertiesKHR.Ptr ret = new VkPhysicalDeviceMaintenance10PropertiesKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_MAINTENANCE_10_PROPERTIES_KHR);
        }
        return ret;
    }

    public static VkPhysicalDeviceMaintenance10PropertiesKHR clone(Arena arena, VkPhysicalDeviceMaintenance10PropertiesKHR src) {
        VkPhysicalDeviceMaintenance10PropertiesKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_MAINTENANCE_10_PROPERTIES_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceMaintenance10PropertiesKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceMaintenance10PropertiesKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceMaintenance10PropertiesKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int rgba4OpaqueBlackSwizzled() {
        return segment.get(LAYOUT$rgba4OpaqueBlackSwizzled, OFFSET$rgba4OpaqueBlackSwizzled);
    }

    public VkPhysicalDeviceMaintenance10PropertiesKHR rgba4OpaqueBlackSwizzled(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$rgba4OpaqueBlackSwizzled, OFFSET$rgba4OpaqueBlackSwizzled, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int resolveSrgbFormatAppliesTransferFunction() {
        return segment.get(LAYOUT$resolveSrgbFormatAppliesTransferFunction, OFFSET$resolveSrgbFormatAppliesTransferFunction);
    }

    public VkPhysicalDeviceMaintenance10PropertiesKHR resolveSrgbFormatAppliesTransferFunction(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$resolveSrgbFormatAppliesTransferFunction, OFFSET$resolveSrgbFormatAppliesTransferFunction, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int resolveSrgbFormatSupportsTransferFunctionControl() {
        return segment.get(LAYOUT$resolveSrgbFormatSupportsTransferFunctionControl, OFFSET$resolveSrgbFormatSupportsTransferFunctionControl);
    }

    public VkPhysicalDeviceMaintenance10PropertiesKHR resolveSrgbFormatSupportsTransferFunctionControl(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$resolveSrgbFormatSupportsTransferFunctionControl, OFFSET$resolveSrgbFormatSupportsTransferFunctionControl, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("rgba4OpaqueBlackSwizzled"),
        ValueLayout.JAVA_INT.withName("resolveSrgbFormatAppliesTransferFunction"),
        ValueLayout.JAVA_INT.withName("resolveSrgbFormatSupportsTransferFunctionControl")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$rgba4OpaqueBlackSwizzled = PathElement.groupElement("rgba4OpaqueBlackSwizzled");
    public static final PathElement PATH$resolveSrgbFormatAppliesTransferFunction = PathElement.groupElement("resolveSrgbFormatAppliesTransferFunction");
    public static final PathElement PATH$resolveSrgbFormatSupportsTransferFunctionControl = PathElement.groupElement("resolveSrgbFormatSupportsTransferFunctionControl");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$rgba4OpaqueBlackSwizzled = (OfInt) LAYOUT.select(PATH$rgba4OpaqueBlackSwizzled);
    public static final OfInt LAYOUT$resolveSrgbFormatAppliesTransferFunction = (OfInt) LAYOUT.select(PATH$resolveSrgbFormatAppliesTransferFunction);
    public static final OfInt LAYOUT$resolveSrgbFormatSupportsTransferFunctionControl = (OfInt) LAYOUT.select(PATH$resolveSrgbFormatSupportsTransferFunctionControl);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$rgba4OpaqueBlackSwizzled = LAYOUT$rgba4OpaqueBlackSwizzled.byteSize();
    public static final long SIZE$resolveSrgbFormatAppliesTransferFunction = LAYOUT$resolveSrgbFormatAppliesTransferFunction.byteSize();
    public static final long SIZE$resolveSrgbFormatSupportsTransferFunctionControl = LAYOUT$resolveSrgbFormatSupportsTransferFunctionControl.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$rgba4OpaqueBlackSwizzled = LAYOUT.byteOffset(PATH$rgba4OpaqueBlackSwizzled);
    public static final long OFFSET$resolveSrgbFormatAppliesTransferFunction = LAYOUT.byteOffset(PATH$resolveSrgbFormatAppliesTransferFunction);
    public static final long OFFSET$resolveSrgbFormatSupportsTransferFunctionControl = LAYOUT.byteOffset(PATH$resolveSrgbFormatSupportsTransferFunctionControl);
}
