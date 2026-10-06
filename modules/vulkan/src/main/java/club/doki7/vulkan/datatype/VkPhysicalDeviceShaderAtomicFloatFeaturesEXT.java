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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceShaderAtomicFloatFeaturesEXT.html"><code>VkPhysicalDeviceShaderAtomicFloatFeaturesEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceShaderAtomicFloatFeaturesEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 shaderBufferFloat32Atomics; // @link substring="shaderBufferFloat32Atomics" target="#shaderBufferFloat32Atomics"
///     VkBool32 shaderBufferFloat32AtomicAdd; // @link substring="shaderBufferFloat32AtomicAdd" target="#shaderBufferFloat32AtomicAdd"
///     VkBool32 shaderBufferFloat64Atomics; // @link substring="shaderBufferFloat64Atomics" target="#shaderBufferFloat64Atomics"
///     VkBool32 shaderBufferFloat64AtomicAdd; // @link substring="shaderBufferFloat64AtomicAdd" target="#shaderBufferFloat64AtomicAdd"
///     VkBool32 shaderSharedFloat32Atomics; // @link substring="shaderSharedFloat32Atomics" target="#shaderSharedFloat32Atomics"
///     VkBool32 shaderSharedFloat32AtomicAdd; // @link substring="shaderSharedFloat32AtomicAdd" target="#shaderSharedFloat32AtomicAdd"
///     VkBool32 shaderSharedFloat64Atomics; // @link substring="shaderSharedFloat64Atomics" target="#shaderSharedFloat64Atomics"
///     VkBool32 shaderSharedFloat64AtomicAdd; // @link substring="shaderSharedFloat64AtomicAdd" target="#shaderSharedFloat64AtomicAdd"
///     VkBool32 shaderImageFloat32Atomics; // @link substring="shaderImageFloat32Atomics" target="#shaderImageFloat32Atomics"
///     VkBool32 shaderImageFloat32AtomicAdd; // @link substring="shaderImageFloat32AtomicAdd" target="#shaderImageFloat32AtomicAdd"
///     VkBool32 sparseImageFloat32Atomics; // @link substring="sparseImageFloat32Atomics" target="#sparseImageFloat32Atomics"
///     VkBool32 sparseImageFloat32AtomicAdd; // @link substring="sparseImageFloat32AtomicAdd" target="#sparseImageFloat32AtomicAdd"
/// } VkPhysicalDeviceShaderAtomicFloatFeaturesEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SHADER_ATOMIC_FLOAT_FEATURES_EXT`
///
/// The {@code allocate} ({@link VkPhysicalDeviceShaderAtomicFloatFeaturesEXT#allocate(Arena)}, {@link VkPhysicalDeviceShaderAtomicFloatFeaturesEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceShaderAtomicFloatFeaturesEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceShaderAtomicFloatFeaturesEXT.html"><code>VkPhysicalDeviceShaderAtomicFloatFeaturesEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceShaderAtomicFloatFeaturesEXT(@NotNull MemorySegment segment) implements IVkPhysicalDeviceShaderAtomicFloatFeaturesEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceShaderAtomicFloatFeaturesEXT.html"><code>VkPhysicalDeviceShaderAtomicFloatFeaturesEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceShaderAtomicFloatFeaturesEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceShaderAtomicFloatFeaturesEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceShaderAtomicFloatFeaturesEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceShaderAtomicFloatFeaturesEXT, Iterable<VkPhysicalDeviceShaderAtomicFloatFeaturesEXT> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceShaderAtomicFloatFeaturesEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceShaderAtomicFloatFeaturesEXT at(long index) {
            return new VkPhysicalDeviceShaderAtomicFloatFeaturesEXT(segment.asSlice(index * VkPhysicalDeviceShaderAtomicFloatFeaturesEXT.BYTES, VkPhysicalDeviceShaderAtomicFloatFeaturesEXT.BYTES));
        }

        public VkPhysicalDeviceShaderAtomicFloatFeaturesEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceShaderAtomicFloatFeaturesEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceShaderAtomicFloatFeaturesEXT value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceShaderAtomicFloatFeaturesEXT.BYTES, VkPhysicalDeviceShaderAtomicFloatFeaturesEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceShaderAtomicFloatFeaturesEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceShaderAtomicFloatFeaturesEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceShaderAtomicFloatFeaturesEXT.BYTES,
                (end - start) * VkPhysicalDeviceShaderAtomicFloatFeaturesEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceShaderAtomicFloatFeaturesEXT.BYTES));
        }

        public VkPhysicalDeviceShaderAtomicFloatFeaturesEXT[] toArray() {
            VkPhysicalDeviceShaderAtomicFloatFeaturesEXT[] ret = new VkPhysicalDeviceShaderAtomicFloatFeaturesEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceShaderAtomicFloatFeaturesEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceShaderAtomicFloatFeaturesEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceShaderAtomicFloatFeaturesEXT.BYTES;
            }

            @Override
            public VkPhysicalDeviceShaderAtomicFloatFeaturesEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceShaderAtomicFloatFeaturesEXT ret = new VkPhysicalDeviceShaderAtomicFloatFeaturesEXT(segment.asSlice(0, VkPhysicalDeviceShaderAtomicFloatFeaturesEXT.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceShaderAtomicFloatFeaturesEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceShaderAtomicFloatFeaturesEXT allocate(Arena arena) {
        VkPhysicalDeviceShaderAtomicFloatFeaturesEXT ret = new VkPhysicalDeviceShaderAtomicFloatFeaturesEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_SHADER_ATOMIC_FLOAT_FEATURES_EXT);
        return ret;
    }

    public static VkPhysicalDeviceShaderAtomicFloatFeaturesEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceShaderAtomicFloatFeaturesEXT.Ptr ret = new VkPhysicalDeviceShaderAtomicFloatFeaturesEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_SHADER_ATOMIC_FLOAT_FEATURES_EXT);
        }
        return ret;
    }

    public static VkPhysicalDeviceShaderAtomicFloatFeaturesEXT clone(Arena arena, VkPhysicalDeviceShaderAtomicFloatFeaturesEXT src) {
        VkPhysicalDeviceShaderAtomicFloatFeaturesEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_SHADER_ATOMIC_FLOAT_FEATURES_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceShaderAtomicFloatFeaturesEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceShaderAtomicFloatFeaturesEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceShaderAtomicFloatFeaturesEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderBufferFloat32Atomics() {
        return segment.get(LAYOUT$shaderBufferFloat32Atomics, OFFSET$shaderBufferFloat32Atomics);
    }

    public VkPhysicalDeviceShaderAtomicFloatFeaturesEXT shaderBufferFloat32Atomics(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderBufferFloat32Atomics, OFFSET$shaderBufferFloat32Atomics, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderBufferFloat32AtomicAdd() {
        return segment.get(LAYOUT$shaderBufferFloat32AtomicAdd, OFFSET$shaderBufferFloat32AtomicAdd);
    }

    public VkPhysicalDeviceShaderAtomicFloatFeaturesEXT shaderBufferFloat32AtomicAdd(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderBufferFloat32AtomicAdd, OFFSET$shaderBufferFloat32AtomicAdd, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderBufferFloat64Atomics() {
        return segment.get(LAYOUT$shaderBufferFloat64Atomics, OFFSET$shaderBufferFloat64Atomics);
    }

    public VkPhysicalDeviceShaderAtomicFloatFeaturesEXT shaderBufferFloat64Atomics(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderBufferFloat64Atomics, OFFSET$shaderBufferFloat64Atomics, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderBufferFloat64AtomicAdd() {
        return segment.get(LAYOUT$shaderBufferFloat64AtomicAdd, OFFSET$shaderBufferFloat64AtomicAdd);
    }

    public VkPhysicalDeviceShaderAtomicFloatFeaturesEXT shaderBufferFloat64AtomicAdd(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderBufferFloat64AtomicAdd, OFFSET$shaderBufferFloat64AtomicAdd, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderSharedFloat32Atomics() {
        return segment.get(LAYOUT$shaderSharedFloat32Atomics, OFFSET$shaderSharedFloat32Atomics);
    }

    public VkPhysicalDeviceShaderAtomicFloatFeaturesEXT shaderSharedFloat32Atomics(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderSharedFloat32Atomics, OFFSET$shaderSharedFloat32Atomics, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderSharedFloat32AtomicAdd() {
        return segment.get(LAYOUT$shaderSharedFloat32AtomicAdd, OFFSET$shaderSharedFloat32AtomicAdd);
    }

    public VkPhysicalDeviceShaderAtomicFloatFeaturesEXT shaderSharedFloat32AtomicAdd(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderSharedFloat32AtomicAdd, OFFSET$shaderSharedFloat32AtomicAdd, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderSharedFloat64Atomics() {
        return segment.get(LAYOUT$shaderSharedFloat64Atomics, OFFSET$shaderSharedFloat64Atomics);
    }

    public VkPhysicalDeviceShaderAtomicFloatFeaturesEXT shaderSharedFloat64Atomics(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderSharedFloat64Atomics, OFFSET$shaderSharedFloat64Atomics, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderSharedFloat64AtomicAdd() {
        return segment.get(LAYOUT$shaderSharedFloat64AtomicAdd, OFFSET$shaderSharedFloat64AtomicAdd);
    }

    public VkPhysicalDeviceShaderAtomicFloatFeaturesEXT shaderSharedFloat64AtomicAdd(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderSharedFloat64AtomicAdd, OFFSET$shaderSharedFloat64AtomicAdd, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderImageFloat32Atomics() {
        return segment.get(LAYOUT$shaderImageFloat32Atomics, OFFSET$shaderImageFloat32Atomics);
    }

    public VkPhysicalDeviceShaderAtomicFloatFeaturesEXT shaderImageFloat32Atomics(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderImageFloat32Atomics, OFFSET$shaderImageFloat32Atomics, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderImageFloat32AtomicAdd() {
        return segment.get(LAYOUT$shaderImageFloat32AtomicAdd, OFFSET$shaderImageFloat32AtomicAdd);
    }

    public VkPhysicalDeviceShaderAtomicFloatFeaturesEXT shaderImageFloat32AtomicAdd(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderImageFloat32AtomicAdd, OFFSET$shaderImageFloat32AtomicAdd, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int sparseImageFloat32Atomics() {
        return segment.get(LAYOUT$sparseImageFloat32Atomics, OFFSET$sparseImageFloat32Atomics);
    }

    public VkPhysicalDeviceShaderAtomicFloatFeaturesEXT sparseImageFloat32Atomics(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$sparseImageFloat32Atomics, OFFSET$sparseImageFloat32Atomics, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int sparseImageFloat32AtomicAdd() {
        return segment.get(LAYOUT$sparseImageFloat32AtomicAdd, OFFSET$sparseImageFloat32AtomicAdd);
    }

    public VkPhysicalDeviceShaderAtomicFloatFeaturesEXT sparseImageFloat32AtomicAdd(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$sparseImageFloat32AtomicAdd, OFFSET$sparseImageFloat32AtomicAdd, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("shaderBufferFloat32Atomics"),
        ValueLayout.JAVA_INT.withName("shaderBufferFloat32AtomicAdd"),
        ValueLayout.JAVA_INT.withName("shaderBufferFloat64Atomics"),
        ValueLayout.JAVA_INT.withName("shaderBufferFloat64AtomicAdd"),
        ValueLayout.JAVA_INT.withName("shaderSharedFloat32Atomics"),
        ValueLayout.JAVA_INT.withName("shaderSharedFloat32AtomicAdd"),
        ValueLayout.JAVA_INT.withName("shaderSharedFloat64Atomics"),
        ValueLayout.JAVA_INT.withName("shaderSharedFloat64AtomicAdd"),
        ValueLayout.JAVA_INT.withName("shaderImageFloat32Atomics"),
        ValueLayout.JAVA_INT.withName("shaderImageFloat32AtomicAdd"),
        ValueLayout.JAVA_INT.withName("sparseImageFloat32Atomics"),
        ValueLayout.JAVA_INT.withName("sparseImageFloat32AtomicAdd")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$shaderBufferFloat32Atomics = PathElement.groupElement("shaderBufferFloat32Atomics");
    public static final PathElement PATH$shaderBufferFloat32AtomicAdd = PathElement.groupElement("shaderBufferFloat32AtomicAdd");
    public static final PathElement PATH$shaderBufferFloat64Atomics = PathElement.groupElement("shaderBufferFloat64Atomics");
    public static final PathElement PATH$shaderBufferFloat64AtomicAdd = PathElement.groupElement("shaderBufferFloat64AtomicAdd");
    public static final PathElement PATH$shaderSharedFloat32Atomics = PathElement.groupElement("shaderSharedFloat32Atomics");
    public static final PathElement PATH$shaderSharedFloat32AtomicAdd = PathElement.groupElement("shaderSharedFloat32AtomicAdd");
    public static final PathElement PATH$shaderSharedFloat64Atomics = PathElement.groupElement("shaderSharedFloat64Atomics");
    public static final PathElement PATH$shaderSharedFloat64AtomicAdd = PathElement.groupElement("shaderSharedFloat64AtomicAdd");
    public static final PathElement PATH$shaderImageFloat32Atomics = PathElement.groupElement("shaderImageFloat32Atomics");
    public static final PathElement PATH$shaderImageFloat32AtomicAdd = PathElement.groupElement("shaderImageFloat32AtomicAdd");
    public static final PathElement PATH$sparseImageFloat32Atomics = PathElement.groupElement("sparseImageFloat32Atomics");
    public static final PathElement PATH$sparseImageFloat32AtomicAdd = PathElement.groupElement("sparseImageFloat32AtomicAdd");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$shaderBufferFloat32Atomics = (OfInt) LAYOUT.select(PATH$shaderBufferFloat32Atomics);
    public static final OfInt LAYOUT$shaderBufferFloat32AtomicAdd = (OfInt) LAYOUT.select(PATH$shaderBufferFloat32AtomicAdd);
    public static final OfInt LAYOUT$shaderBufferFloat64Atomics = (OfInt) LAYOUT.select(PATH$shaderBufferFloat64Atomics);
    public static final OfInt LAYOUT$shaderBufferFloat64AtomicAdd = (OfInt) LAYOUT.select(PATH$shaderBufferFloat64AtomicAdd);
    public static final OfInt LAYOUT$shaderSharedFloat32Atomics = (OfInt) LAYOUT.select(PATH$shaderSharedFloat32Atomics);
    public static final OfInt LAYOUT$shaderSharedFloat32AtomicAdd = (OfInt) LAYOUT.select(PATH$shaderSharedFloat32AtomicAdd);
    public static final OfInt LAYOUT$shaderSharedFloat64Atomics = (OfInt) LAYOUT.select(PATH$shaderSharedFloat64Atomics);
    public static final OfInt LAYOUT$shaderSharedFloat64AtomicAdd = (OfInt) LAYOUT.select(PATH$shaderSharedFloat64AtomicAdd);
    public static final OfInt LAYOUT$shaderImageFloat32Atomics = (OfInt) LAYOUT.select(PATH$shaderImageFloat32Atomics);
    public static final OfInt LAYOUT$shaderImageFloat32AtomicAdd = (OfInt) LAYOUT.select(PATH$shaderImageFloat32AtomicAdd);
    public static final OfInt LAYOUT$sparseImageFloat32Atomics = (OfInt) LAYOUT.select(PATH$sparseImageFloat32Atomics);
    public static final OfInt LAYOUT$sparseImageFloat32AtomicAdd = (OfInt) LAYOUT.select(PATH$sparseImageFloat32AtomicAdd);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$shaderBufferFloat32Atomics = LAYOUT$shaderBufferFloat32Atomics.byteSize();
    public static final long SIZE$shaderBufferFloat32AtomicAdd = LAYOUT$shaderBufferFloat32AtomicAdd.byteSize();
    public static final long SIZE$shaderBufferFloat64Atomics = LAYOUT$shaderBufferFloat64Atomics.byteSize();
    public static final long SIZE$shaderBufferFloat64AtomicAdd = LAYOUT$shaderBufferFloat64AtomicAdd.byteSize();
    public static final long SIZE$shaderSharedFloat32Atomics = LAYOUT$shaderSharedFloat32Atomics.byteSize();
    public static final long SIZE$shaderSharedFloat32AtomicAdd = LAYOUT$shaderSharedFloat32AtomicAdd.byteSize();
    public static final long SIZE$shaderSharedFloat64Atomics = LAYOUT$shaderSharedFloat64Atomics.byteSize();
    public static final long SIZE$shaderSharedFloat64AtomicAdd = LAYOUT$shaderSharedFloat64AtomicAdd.byteSize();
    public static final long SIZE$shaderImageFloat32Atomics = LAYOUT$shaderImageFloat32Atomics.byteSize();
    public static final long SIZE$shaderImageFloat32AtomicAdd = LAYOUT$shaderImageFloat32AtomicAdd.byteSize();
    public static final long SIZE$sparseImageFloat32Atomics = LAYOUT$sparseImageFloat32Atomics.byteSize();
    public static final long SIZE$sparseImageFloat32AtomicAdd = LAYOUT$sparseImageFloat32AtomicAdd.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$shaderBufferFloat32Atomics = LAYOUT.byteOffset(PATH$shaderBufferFloat32Atomics);
    public static final long OFFSET$shaderBufferFloat32AtomicAdd = LAYOUT.byteOffset(PATH$shaderBufferFloat32AtomicAdd);
    public static final long OFFSET$shaderBufferFloat64Atomics = LAYOUT.byteOffset(PATH$shaderBufferFloat64Atomics);
    public static final long OFFSET$shaderBufferFloat64AtomicAdd = LAYOUT.byteOffset(PATH$shaderBufferFloat64AtomicAdd);
    public static final long OFFSET$shaderSharedFloat32Atomics = LAYOUT.byteOffset(PATH$shaderSharedFloat32Atomics);
    public static final long OFFSET$shaderSharedFloat32AtomicAdd = LAYOUT.byteOffset(PATH$shaderSharedFloat32AtomicAdd);
    public static final long OFFSET$shaderSharedFloat64Atomics = LAYOUT.byteOffset(PATH$shaderSharedFloat64Atomics);
    public static final long OFFSET$shaderSharedFloat64AtomicAdd = LAYOUT.byteOffset(PATH$shaderSharedFloat64AtomicAdd);
    public static final long OFFSET$shaderImageFloat32Atomics = LAYOUT.byteOffset(PATH$shaderImageFloat32Atomics);
    public static final long OFFSET$shaderImageFloat32AtomicAdd = LAYOUT.byteOffset(PATH$shaderImageFloat32AtomicAdd);
    public static final long OFFSET$sparseImageFloat32Atomics = LAYOUT.byteOffset(PATH$sparseImageFloat32Atomics);
    public static final long OFFSET$sparseImageFloat32AtomicAdd = LAYOUT.byteOffset(PATH$sparseImageFloat32AtomicAdd);
}
