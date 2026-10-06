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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT.html"><code>VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 shaderBufferFloat16Atomics; // @link substring="shaderBufferFloat16Atomics" target="#shaderBufferFloat16Atomics"
///     VkBool32 shaderBufferFloat16AtomicAdd; // @link substring="shaderBufferFloat16AtomicAdd" target="#shaderBufferFloat16AtomicAdd"
///     VkBool32 shaderBufferFloat16AtomicMinMax; // @link substring="shaderBufferFloat16AtomicMinMax" target="#shaderBufferFloat16AtomicMinMax"
///     VkBool32 shaderBufferFloat32AtomicMinMax; // @link substring="shaderBufferFloat32AtomicMinMax" target="#shaderBufferFloat32AtomicMinMax"
///     VkBool32 shaderBufferFloat64AtomicMinMax; // @link substring="shaderBufferFloat64AtomicMinMax" target="#shaderBufferFloat64AtomicMinMax"
///     VkBool32 shaderSharedFloat16Atomics; // @link substring="shaderSharedFloat16Atomics" target="#shaderSharedFloat16Atomics"
///     VkBool32 shaderSharedFloat16AtomicAdd; // @link substring="shaderSharedFloat16AtomicAdd" target="#shaderSharedFloat16AtomicAdd"
///     VkBool32 shaderSharedFloat16AtomicMinMax; // @link substring="shaderSharedFloat16AtomicMinMax" target="#shaderSharedFloat16AtomicMinMax"
///     VkBool32 shaderSharedFloat32AtomicMinMax; // @link substring="shaderSharedFloat32AtomicMinMax" target="#shaderSharedFloat32AtomicMinMax"
///     VkBool32 shaderSharedFloat64AtomicMinMax; // @link substring="shaderSharedFloat64AtomicMinMax" target="#shaderSharedFloat64AtomicMinMax"
///     VkBool32 shaderImageFloat32AtomicMinMax; // @link substring="shaderImageFloat32AtomicMinMax" target="#shaderImageFloat32AtomicMinMax"
///     VkBool32 sparseImageFloat32AtomicMinMax; // @link substring="sparseImageFloat32AtomicMinMax" target="#sparseImageFloat32AtomicMinMax"
/// } VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SHADER_ATOMIC_FLOAT_2_FEATURES_EXT`
///
/// The {@code allocate} ({@link VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT#allocate(Arena)}, {@link VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT.html"><code>VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT(@NotNull MemorySegment segment) implements IVkPhysicalDeviceShaderAtomicFloat2FeaturesEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT.html"><code>VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceShaderAtomicFloat2FeaturesEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceShaderAtomicFloat2FeaturesEXT, Iterable<VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT at(long index) {
            return new VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT(segment.asSlice(index * VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT.BYTES, VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT.BYTES));
        }

        public VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT.BYTES, VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT.BYTES,
                (end - start) * VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT.BYTES));
        }

        public VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT[] toArray() {
            VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT[] ret = new VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT.BYTES;
            }

            @Override
            public VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT ret = new VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT(segment.asSlice(0, VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT allocate(Arena arena) {
        VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT ret = new VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_SHADER_ATOMIC_FLOAT_2_FEATURES_EXT);
        return ret;
    }

    public static VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT.Ptr ret = new VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_SHADER_ATOMIC_FLOAT_2_FEATURES_EXT);
        }
        return ret;
    }

    public static VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT clone(Arena arena, VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT src) {
        VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_SHADER_ATOMIC_FLOAT_2_FEATURES_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderBufferFloat16Atomics() {
        return segment.get(LAYOUT$shaderBufferFloat16Atomics, OFFSET$shaderBufferFloat16Atomics);
    }

    public VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT shaderBufferFloat16Atomics(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderBufferFloat16Atomics, OFFSET$shaderBufferFloat16Atomics, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderBufferFloat16AtomicAdd() {
        return segment.get(LAYOUT$shaderBufferFloat16AtomicAdd, OFFSET$shaderBufferFloat16AtomicAdd);
    }

    public VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT shaderBufferFloat16AtomicAdd(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderBufferFloat16AtomicAdd, OFFSET$shaderBufferFloat16AtomicAdd, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderBufferFloat16AtomicMinMax() {
        return segment.get(LAYOUT$shaderBufferFloat16AtomicMinMax, OFFSET$shaderBufferFloat16AtomicMinMax);
    }

    public VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT shaderBufferFloat16AtomicMinMax(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderBufferFloat16AtomicMinMax, OFFSET$shaderBufferFloat16AtomicMinMax, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderBufferFloat32AtomicMinMax() {
        return segment.get(LAYOUT$shaderBufferFloat32AtomicMinMax, OFFSET$shaderBufferFloat32AtomicMinMax);
    }

    public VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT shaderBufferFloat32AtomicMinMax(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderBufferFloat32AtomicMinMax, OFFSET$shaderBufferFloat32AtomicMinMax, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderBufferFloat64AtomicMinMax() {
        return segment.get(LAYOUT$shaderBufferFloat64AtomicMinMax, OFFSET$shaderBufferFloat64AtomicMinMax);
    }

    public VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT shaderBufferFloat64AtomicMinMax(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderBufferFloat64AtomicMinMax, OFFSET$shaderBufferFloat64AtomicMinMax, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderSharedFloat16Atomics() {
        return segment.get(LAYOUT$shaderSharedFloat16Atomics, OFFSET$shaderSharedFloat16Atomics);
    }

    public VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT shaderSharedFloat16Atomics(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderSharedFloat16Atomics, OFFSET$shaderSharedFloat16Atomics, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderSharedFloat16AtomicAdd() {
        return segment.get(LAYOUT$shaderSharedFloat16AtomicAdd, OFFSET$shaderSharedFloat16AtomicAdd);
    }

    public VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT shaderSharedFloat16AtomicAdd(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderSharedFloat16AtomicAdd, OFFSET$shaderSharedFloat16AtomicAdd, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderSharedFloat16AtomicMinMax() {
        return segment.get(LAYOUT$shaderSharedFloat16AtomicMinMax, OFFSET$shaderSharedFloat16AtomicMinMax);
    }

    public VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT shaderSharedFloat16AtomicMinMax(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderSharedFloat16AtomicMinMax, OFFSET$shaderSharedFloat16AtomicMinMax, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderSharedFloat32AtomicMinMax() {
        return segment.get(LAYOUT$shaderSharedFloat32AtomicMinMax, OFFSET$shaderSharedFloat32AtomicMinMax);
    }

    public VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT shaderSharedFloat32AtomicMinMax(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderSharedFloat32AtomicMinMax, OFFSET$shaderSharedFloat32AtomicMinMax, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderSharedFloat64AtomicMinMax() {
        return segment.get(LAYOUT$shaderSharedFloat64AtomicMinMax, OFFSET$shaderSharedFloat64AtomicMinMax);
    }

    public VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT shaderSharedFloat64AtomicMinMax(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderSharedFloat64AtomicMinMax, OFFSET$shaderSharedFloat64AtomicMinMax, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderImageFloat32AtomicMinMax() {
        return segment.get(LAYOUT$shaderImageFloat32AtomicMinMax, OFFSET$shaderImageFloat32AtomicMinMax);
    }

    public VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT shaderImageFloat32AtomicMinMax(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderImageFloat32AtomicMinMax, OFFSET$shaderImageFloat32AtomicMinMax, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int sparseImageFloat32AtomicMinMax() {
        return segment.get(LAYOUT$sparseImageFloat32AtomicMinMax, OFFSET$sparseImageFloat32AtomicMinMax);
    }

    public VkPhysicalDeviceShaderAtomicFloat2FeaturesEXT sparseImageFloat32AtomicMinMax(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$sparseImageFloat32AtomicMinMax, OFFSET$sparseImageFloat32AtomicMinMax, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("shaderBufferFloat16Atomics"),
        ValueLayout.JAVA_INT.withName("shaderBufferFloat16AtomicAdd"),
        ValueLayout.JAVA_INT.withName("shaderBufferFloat16AtomicMinMax"),
        ValueLayout.JAVA_INT.withName("shaderBufferFloat32AtomicMinMax"),
        ValueLayout.JAVA_INT.withName("shaderBufferFloat64AtomicMinMax"),
        ValueLayout.JAVA_INT.withName("shaderSharedFloat16Atomics"),
        ValueLayout.JAVA_INT.withName("shaderSharedFloat16AtomicAdd"),
        ValueLayout.JAVA_INT.withName("shaderSharedFloat16AtomicMinMax"),
        ValueLayout.JAVA_INT.withName("shaderSharedFloat32AtomicMinMax"),
        ValueLayout.JAVA_INT.withName("shaderSharedFloat64AtomicMinMax"),
        ValueLayout.JAVA_INT.withName("shaderImageFloat32AtomicMinMax"),
        ValueLayout.JAVA_INT.withName("sparseImageFloat32AtomicMinMax")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$shaderBufferFloat16Atomics = PathElement.groupElement("shaderBufferFloat16Atomics");
    public static final PathElement PATH$shaderBufferFloat16AtomicAdd = PathElement.groupElement("shaderBufferFloat16AtomicAdd");
    public static final PathElement PATH$shaderBufferFloat16AtomicMinMax = PathElement.groupElement("shaderBufferFloat16AtomicMinMax");
    public static final PathElement PATH$shaderBufferFloat32AtomicMinMax = PathElement.groupElement("shaderBufferFloat32AtomicMinMax");
    public static final PathElement PATH$shaderBufferFloat64AtomicMinMax = PathElement.groupElement("shaderBufferFloat64AtomicMinMax");
    public static final PathElement PATH$shaderSharedFloat16Atomics = PathElement.groupElement("shaderSharedFloat16Atomics");
    public static final PathElement PATH$shaderSharedFloat16AtomicAdd = PathElement.groupElement("shaderSharedFloat16AtomicAdd");
    public static final PathElement PATH$shaderSharedFloat16AtomicMinMax = PathElement.groupElement("shaderSharedFloat16AtomicMinMax");
    public static final PathElement PATH$shaderSharedFloat32AtomicMinMax = PathElement.groupElement("shaderSharedFloat32AtomicMinMax");
    public static final PathElement PATH$shaderSharedFloat64AtomicMinMax = PathElement.groupElement("shaderSharedFloat64AtomicMinMax");
    public static final PathElement PATH$shaderImageFloat32AtomicMinMax = PathElement.groupElement("shaderImageFloat32AtomicMinMax");
    public static final PathElement PATH$sparseImageFloat32AtomicMinMax = PathElement.groupElement("sparseImageFloat32AtomicMinMax");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$shaderBufferFloat16Atomics = (OfInt) LAYOUT.select(PATH$shaderBufferFloat16Atomics);
    public static final OfInt LAYOUT$shaderBufferFloat16AtomicAdd = (OfInt) LAYOUT.select(PATH$shaderBufferFloat16AtomicAdd);
    public static final OfInt LAYOUT$shaderBufferFloat16AtomicMinMax = (OfInt) LAYOUT.select(PATH$shaderBufferFloat16AtomicMinMax);
    public static final OfInt LAYOUT$shaderBufferFloat32AtomicMinMax = (OfInt) LAYOUT.select(PATH$shaderBufferFloat32AtomicMinMax);
    public static final OfInt LAYOUT$shaderBufferFloat64AtomicMinMax = (OfInt) LAYOUT.select(PATH$shaderBufferFloat64AtomicMinMax);
    public static final OfInt LAYOUT$shaderSharedFloat16Atomics = (OfInt) LAYOUT.select(PATH$shaderSharedFloat16Atomics);
    public static final OfInt LAYOUT$shaderSharedFloat16AtomicAdd = (OfInt) LAYOUT.select(PATH$shaderSharedFloat16AtomicAdd);
    public static final OfInt LAYOUT$shaderSharedFloat16AtomicMinMax = (OfInt) LAYOUT.select(PATH$shaderSharedFloat16AtomicMinMax);
    public static final OfInt LAYOUT$shaderSharedFloat32AtomicMinMax = (OfInt) LAYOUT.select(PATH$shaderSharedFloat32AtomicMinMax);
    public static final OfInt LAYOUT$shaderSharedFloat64AtomicMinMax = (OfInt) LAYOUT.select(PATH$shaderSharedFloat64AtomicMinMax);
    public static final OfInt LAYOUT$shaderImageFloat32AtomicMinMax = (OfInt) LAYOUT.select(PATH$shaderImageFloat32AtomicMinMax);
    public static final OfInt LAYOUT$sparseImageFloat32AtomicMinMax = (OfInt) LAYOUT.select(PATH$sparseImageFloat32AtomicMinMax);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$shaderBufferFloat16Atomics = LAYOUT$shaderBufferFloat16Atomics.byteSize();
    public static final long SIZE$shaderBufferFloat16AtomicAdd = LAYOUT$shaderBufferFloat16AtomicAdd.byteSize();
    public static final long SIZE$shaderBufferFloat16AtomicMinMax = LAYOUT$shaderBufferFloat16AtomicMinMax.byteSize();
    public static final long SIZE$shaderBufferFloat32AtomicMinMax = LAYOUT$shaderBufferFloat32AtomicMinMax.byteSize();
    public static final long SIZE$shaderBufferFloat64AtomicMinMax = LAYOUT$shaderBufferFloat64AtomicMinMax.byteSize();
    public static final long SIZE$shaderSharedFloat16Atomics = LAYOUT$shaderSharedFloat16Atomics.byteSize();
    public static final long SIZE$shaderSharedFloat16AtomicAdd = LAYOUT$shaderSharedFloat16AtomicAdd.byteSize();
    public static final long SIZE$shaderSharedFloat16AtomicMinMax = LAYOUT$shaderSharedFloat16AtomicMinMax.byteSize();
    public static final long SIZE$shaderSharedFloat32AtomicMinMax = LAYOUT$shaderSharedFloat32AtomicMinMax.byteSize();
    public static final long SIZE$shaderSharedFloat64AtomicMinMax = LAYOUT$shaderSharedFloat64AtomicMinMax.byteSize();
    public static final long SIZE$shaderImageFloat32AtomicMinMax = LAYOUT$shaderImageFloat32AtomicMinMax.byteSize();
    public static final long SIZE$sparseImageFloat32AtomicMinMax = LAYOUT$sparseImageFloat32AtomicMinMax.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$shaderBufferFloat16Atomics = LAYOUT.byteOffset(PATH$shaderBufferFloat16Atomics);
    public static final long OFFSET$shaderBufferFloat16AtomicAdd = LAYOUT.byteOffset(PATH$shaderBufferFloat16AtomicAdd);
    public static final long OFFSET$shaderBufferFloat16AtomicMinMax = LAYOUT.byteOffset(PATH$shaderBufferFloat16AtomicMinMax);
    public static final long OFFSET$shaderBufferFloat32AtomicMinMax = LAYOUT.byteOffset(PATH$shaderBufferFloat32AtomicMinMax);
    public static final long OFFSET$shaderBufferFloat64AtomicMinMax = LAYOUT.byteOffset(PATH$shaderBufferFloat64AtomicMinMax);
    public static final long OFFSET$shaderSharedFloat16Atomics = LAYOUT.byteOffset(PATH$shaderSharedFloat16Atomics);
    public static final long OFFSET$shaderSharedFloat16AtomicAdd = LAYOUT.byteOffset(PATH$shaderSharedFloat16AtomicAdd);
    public static final long OFFSET$shaderSharedFloat16AtomicMinMax = LAYOUT.byteOffset(PATH$shaderSharedFloat16AtomicMinMax);
    public static final long OFFSET$shaderSharedFloat32AtomicMinMax = LAYOUT.byteOffset(PATH$shaderSharedFloat32AtomicMinMax);
    public static final long OFFSET$shaderSharedFloat64AtomicMinMax = LAYOUT.byteOffset(PATH$shaderSharedFloat64AtomicMinMax);
    public static final long OFFSET$shaderImageFloat32AtomicMinMax = LAYOUT.byteOffset(PATH$shaderImageFloat32AtomicMinMax);
    public static final long OFFSET$sparseImageFloat32AtomicMinMax = LAYOUT.byteOffset(PATH$sparseImageFloat32AtomicMinMax);
}
