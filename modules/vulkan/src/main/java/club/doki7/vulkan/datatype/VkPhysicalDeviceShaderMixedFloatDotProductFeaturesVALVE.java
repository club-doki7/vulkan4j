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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE.html"><code>VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 shaderMixedFloatDotProductFloat16AccFloat32; // @link substring="shaderMixedFloatDotProductFloat16AccFloat32" target="#shaderMixedFloatDotProductFloat16AccFloat32"
///     VkBool32 shaderMixedFloatDotProductFloat16AccFloat16; // @link substring="shaderMixedFloatDotProductFloat16AccFloat16" target="#shaderMixedFloatDotProductFloat16AccFloat16"
///     VkBool32 shaderMixedFloatDotProductBFloat16Acc; // @link substring="shaderMixedFloatDotProductBFloat16Acc" target="#shaderMixedFloatDotProductBFloat16Acc"
///     VkBool32 shaderMixedFloatDotProductFloat8AccFloat32; // @link substring="shaderMixedFloatDotProductFloat8AccFloat32" target="#shaderMixedFloatDotProductFloat8AccFloat32"
/// } VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SHADER_MIXED_FLOAT_DOT_PRODUCT_FEATURES_VALVE`
///
/// The {@code allocate} ({@link VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE#allocate(Arena)}, {@link VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE.html"><code>VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE(@NotNull MemorySegment segment) implements IVkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE.html"><code>VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE, Iterable<VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE at(long index) {
            return new VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE(segment.asSlice(index * VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE.BYTES, VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE.BYTES));
        }

        public VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE.BYTES, VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE.BYTES,
                (end - start) * VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE.BYTES));
        }

        public VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE[] toArray() {
            VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE[] ret = new VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE.BYTES;
            }

            @Override
            public VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE ret = new VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE(segment.asSlice(0, VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE allocate(Arena arena) {
        VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE ret = new VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_SHADER_MIXED_FLOAT_DOT_PRODUCT_FEATURES_VALVE);
        return ret;
    }

    public static VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE.Ptr ret = new VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_SHADER_MIXED_FLOAT_DOT_PRODUCT_FEATURES_VALVE);
        }
        return ret;
    }

    public static VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE clone(Arena arena, VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE src) {
        VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_SHADER_MIXED_FLOAT_DOT_PRODUCT_FEATURES_VALVE);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderMixedFloatDotProductFloat16AccFloat32() {
        return segment.get(LAYOUT$shaderMixedFloatDotProductFloat16AccFloat32, OFFSET$shaderMixedFloatDotProductFloat16AccFloat32);
    }

    public VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE shaderMixedFloatDotProductFloat16AccFloat32(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderMixedFloatDotProductFloat16AccFloat32, OFFSET$shaderMixedFloatDotProductFloat16AccFloat32, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderMixedFloatDotProductFloat16AccFloat16() {
        return segment.get(LAYOUT$shaderMixedFloatDotProductFloat16AccFloat16, OFFSET$shaderMixedFloatDotProductFloat16AccFloat16);
    }

    public VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE shaderMixedFloatDotProductFloat16AccFloat16(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderMixedFloatDotProductFloat16AccFloat16, OFFSET$shaderMixedFloatDotProductFloat16AccFloat16, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderMixedFloatDotProductBFloat16Acc() {
        return segment.get(LAYOUT$shaderMixedFloatDotProductBFloat16Acc, OFFSET$shaderMixedFloatDotProductBFloat16Acc);
    }

    public VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE shaderMixedFloatDotProductBFloat16Acc(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderMixedFloatDotProductBFloat16Acc, OFFSET$shaderMixedFloatDotProductBFloat16Acc, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderMixedFloatDotProductFloat8AccFloat32() {
        return segment.get(LAYOUT$shaderMixedFloatDotProductFloat8AccFloat32, OFFSET$shaderMixedFloatDotProductFloat8AccFloat32);
    }

    public VkPhysicalDeviceShaderMixedFloatDotProductFeaturesVALVE shaderMixedFloatDotProductFloat8AccFloat32(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderMixedFloatDotProductFloat8AccFloat32, OFFSET$shaderMixedFloatDotProductFloat8AccFloat32, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("shaderMixedFloatDotProductFloat16AccFloat32"),
        ValueLayout.JAVA_INT.withName("shaderMixedFloatDotProductFloat16AccFloat16"),
        ValueLayout.JAVA_INT.withName("shaderMixedFloatDotProductBFloat16Acc"),
        ValueLayout.JAVA_INT.withName("shaderMixedFloatDotProductFloat8AccFloat32")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$shaderMixedFloatDotProductFloat16AccFloat32 = PathElement.groupElement("shaderMixedFloatDotProductFloat16AccFloat32");
    public static final PathElement PATH$shaderMixedFloatDotProductFloat16AccFloat16 = PathElement.groupElement("shaderMixedFloatDotProductFloat16AccFloat16");
    public static final PathElement PATH$shaderMixedFloatDotProductBFloat16Acc = PathElement.groupElement("shaderMixedFloatDotProductBFloat16Acc");
    public static final PathElement PATH$shaderMixedFloatDotProductFloat8AccFloat32 = PathElement.groupElement("shaderMixedFloatDotProductFloat8AccFloat32");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$shaderMixedFloatDotProductFloat16AccFloat32 = (OfInt) LAYOUT.select(PATH$shaderMixedFloatDotProductFloat16AccFloat32);
    public static final OfInt LAYOUT$shaderMixedFloatDotProductFloat16AccFloat16 = (OfInt) LAYOUT.select(PATH$shaderMixedFloatDotProductFloat16AccFloat16);
    public static final OfInt LAYOUT$shaderMixedFloatDotProductBFloat16Acc = (OfInt) LAYOUT.select(PATH$shaderMixedFloatDotProductBFloat16Acc);
    public static final OfInt LAYOUT$shaderMixedFloatDotProductFloat8AccFloat32 = (OfInt) LAYOUT.select(PATH$shaderMixedFloatDotProductFloat8AccFloat32);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$shaderMixedFloatDotProductFloat16AccFloat32 = LAYOUT$shaderMixedFloatDotProductFloat16AccFloat32.byteSize();
    public static final long SIZE$shaderMixedFloatDotProductFloat16AccFloat16 = LAYOUT$shaderMixedFloatDotProductFloat16AccFloat16.byteSize();
    public static final long SIZE$shaderMixedFloatDotProductBFloat16Acc = LAYOUT$shaderMixedFloatDotProductBFloat16Acc.byteSize();
    public static final long SIZE$shaderMixedFloatDotProductFloat8AccFloat32 = LAYOUT$shaderMixedFloatDotProductFloat8AccFloat32.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$shaderMixedFloatDotProductFloat16AccFloat32 = LAYOUT.byteOffset(PATH$shaderMixedFloatDotProductFloat16AccFloat32);
    public static final long OFFSET$shaderMixedFloatDotProductFloat16AccFloat16 = LAYOUT.byteOffset(PATH$shaderMixedFloatDotProductFloat16AccFloat16);
    public static final long OFFSET$shaderMixedFloatDotProductBFloat16Acc = LAYOUT.byteOffset(PATH$shaderMixedFloatDotProductBFloat16Acc);
    public static final long OFFSET$shaderMixedFloatDotProductFloat8AccFloat32 = LAYOUT.byteOffset(PATH$shaderMixedFloatDotProductFloat8AccFloat32);
}
