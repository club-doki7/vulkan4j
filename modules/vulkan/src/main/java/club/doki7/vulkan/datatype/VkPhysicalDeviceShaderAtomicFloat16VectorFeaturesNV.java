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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV.html"><code>VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 shaderFloat16VectorAtomics; // @link substring="shaderFloat16VectorAtomics" target="#shaderFloat16VectorAtomics"
/// } VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SHADER_ATOMIC_FLOAT16_VECTOR_FEATURES_NV`
///
/// The {@code allocate} ({@link VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV#allocate(Arena)}, {@link VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV.html"><code>VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV(@NotNull MemorySegment segment) implements IVkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV.html"><code>VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV, Iterable<VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV at(long index) {
            return new VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV(segment.asSlice(index * VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV.BYTES, VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV.BYTES));
        }

        public VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV.BYTES, VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV.BYTES,
                (end - start) * VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV.BYTES));
        }

        public VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV[] toArray() {
            VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV[] ret = new VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV.BYTES;
            }

            @Override
            public VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV ret = new VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV(segment.asSlice(0, VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV allocate(Arena arena) {
        VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV ret = new VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_SHADER_ATOMIC_FLOAT16_VECTOR_FEATURES_NV);
        return ret;
    }

    public static VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV.Ptr ret = new VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_SHADER_ATOMIC_FLOAT16_VECTOR_FEATURES_NV);
        }
        return ret;
    }

    public static VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV clone(Arena arena, VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV src) {
        VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_SHADER_ATOMIC_FLOAT16_VECTOR_FEATURES_NV);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderFloat16VectorAtomics() {
        return segment.get(LAYOUT$shaderFloat16VectorAtomics, OFFSET$shaderFloat16VectorAtomics);
    }

    public VkPhysicalDeviceShaderAtomicFloat16VectorFeaturesNV shaderFloat16VectorAtomics(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderFloat16VectorAtomics, OFFSET$shaderFloat16VectorAtomics, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("shaderFloat16VectorAtomics")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$shaderFloat16VectorAtomics = PathElement.groupElement("shaderFloat16VectorAtomics");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$shaderFloat16VectorAtomics = (OfInt) LAYOUT.select(PATH$shaderFloat16VectorAtomics);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$shaderFloat16VectorAtomics = LAYOUT$shaderFloat16VectorAtomics.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$shaderFloat16VectorAtomics = LAYOUT.byteOffset(PATH$shaderFloat16VectorAtomics);
}
