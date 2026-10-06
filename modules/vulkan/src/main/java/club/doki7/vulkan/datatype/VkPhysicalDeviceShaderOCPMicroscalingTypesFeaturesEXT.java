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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT.html"><code>VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 shaderFloat4; // @link substring="shaderFloat4" target="#shaderFloat4"
///     VkBool32 shaderFloat6; // @link substring="shaderFloat6" target="#shaderFloat6"
///     VkBool32 shaderFloat8UnsignedE8M0; // @link substring="shaderFloat8UnsignedE8M0" target="#shaderFloat8UnsignedE8M0"
///     VkBool32 shaderMXInt8; // @link substring="shaderMXInt8" target="#shaderMXInt8"
/// } VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SHADER_OCP_MICROSCALING_TYPES_FEATURES_EXT`
///
/// The {@code allocate} ({@link VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT#allocate(Arena)}, {@link VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT.html"><code>VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT(@NotNull MemorySegment segment) implements IVkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT.html"><code>VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT, Iterable<VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT at(long index) {
            return new VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT(segment.asSlice(index * VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT.BYTES, VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT.BYTES));
        }

        public VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT.BYTES, VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT.BYTES,
                (end - start) * VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT.BYTES));
        }

        public VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT[] toArray() {
            VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT[] ret = new VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT.BYTES;
            }

            @Override
            public VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT ret = new VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT(segment.asSlice(0, VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT allocate(Arena arena) {
        VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT ret = new VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_SHADER_OCP_MICROSCALING_TYPES_FEATURES_EXT);
        return ret;
    }

    public static VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT.Ptr ret = new VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_SHADER_OCP_MICROSCALING_TYPES_FEATURES_EXT);
        }
        return ret;
    }

    public static VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT clone(Arena arena, VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT src) {
        VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_SHADER_OCP_MICROSCALING_TYPES_FEATURES_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderFloat4() {
        return segment.get(LAYOUT$shaderFloat4, OFFSET$shaderFloat4);
    }

    public VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT shaderFloat4(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderFloat4, OFFSET$shaderFloat4, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderFloat6() {
        return segment.get(LAYOUT$shaderFloat6, OFFSET$shaderFloat6);
    }

    public VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT shaderFloat6(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderFloat6, OFFSET$shaderFloat6, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderFloat8UnsignedE8M0() {
        return segment.get(LAYOUT$shaderFloat8UnsignedE8M0, OFFSET$shaderFloat8UnsignedE8M0);
    }

    public VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT shaderFloat8UnsignedE8M0(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderFloat8UnsignedE8M0, OFFSET$shaderFloat8UnsignedE8M0, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderMXInt8() {
        return segment.get(LAYOUT$shaderMXInt8, OFFSET$shaderMXInt8);
    }

    public VkPhysicalDeviceShaderOCPMicroscalingTypesFeaturesEXT shaderMXInt8(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderMXInt8, OFFSET$shaderMXInt8, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("shaderFloat4"),
        ValueLayout.JAVA_INT.withName("shaderFloat6"),
        ValueLayout.JAVA_INT.withName("shaderFloat8UnsignedE8M0"),
        ValueLayout.JAVA_INT.withName("shaderMXInt8")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$shaderFloat4 = PathElement.groupElement("shaderFloat4");
    public static final PathElement PATH$shaderFloat6 = PathElement.groupElement("shaderFloat6");
    public static final PathElement PATH$shaderFloat8UnsignedE8M0 = PathElement.groupElement("shaderFloat8UnsignedE8M0");
    public static final PathElement PATH$shaderMXInt8 = PathElement.groupElement("shaderMXInt8");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$shaderFloat4 = (OfInt) LAYOUT.select(PATH$shaderFloat4);
    public static final OfInt LAYOUT$shaderFloat6 = (OfInt) LAYOUT.select(PATH$shaderFloat6);
    public static final OfInt LAYOUT$shaderFloat8UnsignedE8M0 = (OfInt) LAYOUT.select(PATH$shaderFloat8UnsignedE8M0);
    public static final OfInt LAYOUT$shaderMXInt8 = (OfInt) LAYOUT.select(PATH$shaderMXInt8);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$shaderFloat4 = LAYOUT$shaderFloat4.byteSize();
    public static final long SIZE$shaderFloat6 = LAYOUT$shaderFloat6.byteSize();
    public static final long SIZE$shaderFloat8UnsignedE8M0 = LAYOUT$shaderFloat8UnsignedE8M0.byteSize();
    public static final long SIZE$shaderMXInt8 = LAYOUT$shaderMXInt8.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$shaderFloat4 = LAYOUT.byteOffset(PATH$shaderFloat4);
    public static final long OFFSET$shaderFloat6 = LAYOUT.byteOffset(PATH$shaderFloat6);
    public static final long OFFSET$shaderFloat8UnsignedE8M0 = LAYOUT.byteOffset(PATH$shaderFloat8UnsignedE8M0);
    public static final long OFFSET$shaderMXInt8 = LAYOUT.byteOffset(PATH$shaderMXInt8);
}
