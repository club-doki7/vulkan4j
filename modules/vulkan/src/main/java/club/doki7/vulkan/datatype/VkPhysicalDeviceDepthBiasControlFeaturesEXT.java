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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceDepthBiasControlFeaturesEXT.html"><code>VkPhysicalDeviceDepthBiasControlFeaturesEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceDepthBiasControlFeaturesEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 depthBiasControl; // @link substring="depthBiasControl" target="#depthBiasControl"
///     VkBool32 leastRepresentableValueForceUnormRepresentation; // @link substring="leastRepresentableValueForceUnormRepresentation" target="#leastRepresentableValueForceUnormRepresentation"
///     VkBool32 floatRepresentation; // @link substring="floatRepresentation" target="#floatRepresentation"
///     VkBool32 depthBiasExact; // @link substring="depthBiasExact" target="#depthBiasExact"
/// } VkPhysicalDeviceDepthBiasControlFeaturesEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_DEPTH_BIAS_CONTROL_FEATURES_EXT`
///
/// The {@code allocate} ({@link VkPhysicalDeviceDepthBiasControlFeaturesEXT#allocate(Arena)}, {@link VkPhysicalDeviceDepthBiasControlFeaturesEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceDepthBiasControlFeaturesEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceDepthBiasControlFeaturesEXT.html"><code>VkPhysicalDeviceDepthBiasControlFeaturesEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceDepthBiasControlFeaturesEXT(@NotNull MemorySegment segment) implements IVkPhysicalDeviceDepthBiasControlFeaturesEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceDepthBiasControlFeaturesEXT.html"><code>VkPhysicalDeviceDepthBiasControlFeaturesEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceDepthBiasControlFeaturesEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceDepthBiasControlFeaturesEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceDepthBiasControlFeaturesEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceDepthBiasControlFeaturesEXT, Iterable<VkPhysicalDeviceDepthBiasControlFeaturesEXT> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceDepthBiasControlFeaturesEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceDepthBiasControlFeaturesEXT at(long index) {
            return new VkPhysicalDeviceDepthBiasControlFeaturesEXT(segment.asSlice(index * VkPhysicalDeviceDepthBiasControlFeaturesEXT.BYTES, VkPhysicalDeviceDepthBiasControlFeaturesEXT.BYTES));
        }

        public VkPhysicalDeviceDepthBiasControlFeaturesEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceDepthBiasControlFeaturesEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceDepthBiasControlFeaturesEXT value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceDepthBiasControlFeaturesEXT.BYTES, VkPhysicalDeviceDepthBiasControlFeaturesEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceDepthBiasControlFeaturesEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceDepthBiasControlFeaturesEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceDepthBiasControlFeaturesEXT.BYTES,
                (end - start) * VkPhysicalDeviceDepthBiasControlFeaturesEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceDepthBiasControlFeaturesEXT.BYTES));
        }

        public VkPhysicalDeviceDepthBiasControlFeaturesEXT[] toArray() {
            VkPhysicalDeviceDepthBiasControlFeaturesEXT[] ret = new VkPhysicalDeviceDepthBiasControlFeaturesEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceDepthBiasControlFeaturesEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceDepthBiasControlFeaturesEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceDepthBiasControlFeaturesEXT.BYTES;
            }

            @Override
            public VkPhysicalDeviceDepthBiasControlFeaturesEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceDepthBiasControlFeaturesEXT ret = new VkPhysicalDeviceDepthBiasControlFeaturesEXT(segment.asSlice(0, VkPhysicalDeviceDepthBiasControlFeaturesEXT.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceDepthBiasControlFeaturesEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceDepthBiasControlFeaturesEXT allocate(Arena arena) {
        VkPhysicalDeviceDepthBiasControlFeaturesEXT ret = new VkPhysicalDeviceDepthBiasControlFeaturesEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_DEPTH_BIAS_CONTROL_FEATURES_EXT);
        return ret;
    }

    public static VkPhysicalDeviceDepthBiasControlFeaturesEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceDepthBiasControlFeaturesEXT.Ptr ret = new VkPhysicalDeviceDepthBiasControlFeaturesEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_DEPTH_BIAS_CONTROL_FEATURES_EXT);
        }
        return ret;
    }

    public static VkPhysicalDeviceDepthBiasControlFeaturesEXT clone(Arena arena, VkPhysicalDeviceDepthBiasControlFeaturesEXT src) {
        VkPhysicalDeviceDepthBiasControlFeaturesEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_DEPTH_BIAS_CONTROL_FEATURES_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceDepthBiasControlFeaturesEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceDepthBiasControlFeaturesEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceDepthBiasControlFeaturesEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int depthBiasControl() {
        return segment.get(LAYOUT$depthBiasControl, OFFSET$depthBiasControl);
    }

    public VkPhysicalDeviceDepthBiasControlFeaturesEXT depthBiasControl(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$depthBiasControl, OFFSET$depthBiasControl, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int leastRepresentableValueForceUnormRepresentation() {
        return segment.get(LAYOUT$leastRepresentableValueForceUnormRepresentation, OFFSET$leastRepresentableValueForceUnormRepresentation);
    }

    public VkPhysicalDeviceDepthBiasControlFeaturesEXT leastRepresentableValueForceUnormRepresentation(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$leastRepresentableValueForceUnormRepresentation, OFFSET$leastRepresentableValueForceUnormRepresentation, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int floatRepresentation() {
        return segment.get(LAYOUT$floatRepresentation, OFFSET$floatRepresentation);
    }

    public VkPhysicalDeviceDepthBiasControlFeaturesEXT floatRepresentation(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$floatRepresentation, OFFSET$floatRepresentation, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int depthBiasExact() {
        return segment.get(LAYOUT$depthBiasExact, OFFSET$depthBiasExact);
    }

    public VkPhysicalDeviceDepthBiasControlFeaturesEXT depthBiasExact(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$depthBiasExact, OFFSET$depthBiasExact, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("depthBiasControl"),
        ValueLayout.JAVA_INT.withName("leastRepresentableValueForceUnormRepresentation"),
        ValueLayout.JAVA_INT.withName("floatRepresentation"),
        ValueLayout.JAVA_INT.withName("depthBiasExact")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$depthBiasControl = PathElement.groupElement("depthBiasControl");
    public static final PathElement PATH$leastRepresentableValueForceUnormRepresentation = PathElement.groupElement("leastRepresentableValueForceUnormRepresentation");
    public static final PathElement PATH$floatRepresentation = PathElement.groupElement("floatRepresentation");
    public static final PathElement PATH$depthBiasExact = PathElement.groupElement("depthBiasExact");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$depthBiasControl = (OfInt) LAYOUT.select(PATH$depthBiasControl);
    public static final OfInt LAYOUT$leastRepresentableValueForceUnormRepresentation = (OfInt) LAYOUT.select(PATH$leastRepresentableValueForceUnormRepresentation);
    public static final OfInt LAYOUT$floatRepresentation = (OfInt) LAYOUT.select(PATH$floatRepresentation);
    public static final OfInt LAYOUT$depthBiasExact = (OfInt) LAYOUT.select(PATH$depthBiasExact);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$depthBiasControl = LAYOUT$depthBiasControl.byteSize();
    public static final long SIZE$leastRepresentableValueForceUnormRepresentation = LAYOUT$leastRepresentableValueForceUnormRepresentation.byteSize();
    public static final long SIZE$floatRepresentation = LAYOUT$floatRepresentation.byteSize();
    public static final long SIZE$depthBiasExact = LAYOUT$depthBiasExact.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$depthBiasControl = LAYOUT.byteOffset(PATH$depthBiasControl);
    public static final long OFFSET$leastRepresentableValueForceUnormRepresentation = LAYOUT.byteOffset(PATH$leastRepresentableValueForceUnormRepresentation);
    public static final long OFFSET$floatRepresentation = LAYOUT.byteOffset(PATH$floatRepresentation);
    public static final long OFFSET$depthBiasExact = LAYOUT.byteOffset(PATH$depthBiasExact);
}
