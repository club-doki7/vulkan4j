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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceTensorFeaturesARM.html"><code>VkPhysicalDeviceTensorFeaturesARM</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceTensorFeaturesARM {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 tensorNonPacked; // @link substring="tensorNonPacked" target="#tensorNonPacked"
///     VkBool32 shaderTensorAccess; // @link substring="shaderTensorAccess" target="#shaderTensorAccess"
///     VkBool32 shaderStorageTensorArrayDynamicIndexing; // @link substring="shaderStorageTensorArrayDynamicIndexing" target="#shaderStorageTensorArrayDynamicIndexing"
///     VkBool32 shaderStorageTensorArrayNonUniformIndexing; // @link substring="shaderStorageTensorArrayNonUniformIndexing" target="#shaderStorageTensorArrayNonUniformIndexing"
///     VkBool32 descriptorBindingStorageTensorUpdateAfterBind; // @link substring="descriptorBindingStorageTensorUpdateAfterBind" target="#descriptorBindingStorageTensorUpdateAfterBind"
///     VkBool32 tensors; // @link substring="tensors" target="#tensors"
/// } VkPhysicalDeviceTensorFeaturesARM;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_TENSOR_FEATURES_ARM`
///
/// The {@code allocate} ({@link VkPhysicalDeviceTensorFeaturesARM#allocate(Arena)}, {@link VkPhysicalDeviceTensorFeaturesARM#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceTensorFeaturesARM#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceTensorFeaturesARM.html"><code>VkPhysicalDeviceTensorFeaturesARM</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceTensorFeaturesARM(@NotNull MemorySegment segment) implements IVkPhysicalDeviceTensorFeaturesARM {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceTensorFeaturesARM.html"><code>VkPhysicalDeviceTensorFeaturesARM</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceTensorFeaturesARM}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceTensorFeaturesARM to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceTensorFeaturesARM.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceTensorFeaturesARM, Iterable<VkPhysicalDeviceTensorFeaturesARM> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceTensorFeaturesARM.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceTensorFeaturesARM at(long index) {
            return new VkPhysicalDeviceTensorFeaturesARM(segment.asSlice(index * VkPhysicalDeviceTensorFeaturesARM.BYTES, VkPhysicalDeviceTensorFeaturesARM.BYTES));
        }

        public VkPhysicalDeviceTensorFeaturesARM.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceTensorFeaturesARM> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceTensorFeaturesARM value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceTensorFeaturesARM.BYTES, VkPhysicalDeviceTensorFeaturesARM.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceTensorFeaturesARM.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceTensorFeaturesARM.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceTensorFeaturesARM.BYTES,
                (end - start) * VkPhysicalDeviceTensorFeaturesARM.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceTensorFeaturesARM.BYTES));
        }

        public VkPhysicalDeviceTensorFeaturesARM[] toArray() {
            VkPhysicalDeviceTensorFeaturesARM[] ret = new VkPhysicalDeviceTensorFeaturesARM[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceTensorFeaturesARM> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceTensorFeaturesARM> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceTensorFeaturesARM.BYTES;
            }

            @Override
            public VkPhysicalDeviceTensorFeaturesARM next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceTensorFeaturesARM ret = new VkPhysicalDeviceTensorFeaturesARM(segment.asSlice(0, VkPhysicalDeviceTensorFeaturesARM.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceTensorFeaturesARM.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceTensorFeaturesARM allocate(Arena arena) {
        VkPhysicalDeviceTensorFeaturesARM ret = new VkPhysicalDeviceTensorFeaturesARM(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_TENSOR_FEATURES_ARM);
        return ret;
    }

    public static VkPhysicalDeviceTensorFeaturesARM.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceTensorFeaturesARM.Ptr ret = new VkPhysicalDeviceTensorFeaturesARM.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_TENSOR_FEATURES_ARM);
        }
        return ret;
    }

    public static VkPhysicalDeviceTensorFeaturesARM clone(Arena arena, VkPhysicalDeviceTensorFeaturesARM src) {
        VkPhysicalDeviceTensorFeaturesARM ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_TENSOR_FEATURES_ARM);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceTensorFeaturesARM sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceTensorFeaturesARM pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceTensorFeaturesARM pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int tensorNonPacked() {
        return segment.get(LAYOUT$tensorNonPacked, OFFSET$tensorNonPacked);
    }

    public VkPhysicalDeviceTensorFeaturesARM tensorNonPacked(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$tensorNonPacked, OFFSET$tensorNonPacked, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderTensorAccess() {
        return segment.get(LAYOUT$shaderTensorAccess, OFFSET$shaderTensorAccess);
    }

    public VkPhysicalDeviceTensorFeaturesARM shaderTensorAccess(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderTensorAccess, OFFSET$shaderTensorAccess, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderStorageTensorArrayDynamicIndexing() {
        return segment.get(LAYOUT$shaderStorageTensorArrayDynamicIndexing, OFFSET$shaderStorageTensorArrayDynamicIndexing);
    }

    public VkPhysicalDeviceTensorFeaturesARM shaderStorageTensorArrayDynamicIndexing(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderStorageTensorArrayDynamicIndexing, OFFSET$shaderStorageTensorArrayDynamicIndexing, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderStorageTensorArrayNonUniformIndexing() {
        return segment.get(LAYOUT$shaderStorageTensorArrayNonUniformIndexing, OFFSET$shaderStorageTensorArrayNonUniformIndexing);
    }

    public VkPhysicalDeviceTensorFeaturesARM shaderStorageTensorArrayNonUniformIndexing(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderStorageTensorArrayNonUniformIndexing, OFFSET$shaderStorageTensorArrayNonUniformIndexing, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int descriptorBindingStorageTensorUpdateAfterBind() {
        return segment.get(LAYOUT$descriptorBindingStorageTensorUpdateAfterBind, OFFSET$descriptorBindingStorageTensorUpdateAfterBind);
    }

    public VkPhysicalDeviceTensorFeaturesARM descriptorBindingStorageTensorUpdateAfterBind(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$descriptorBindingStorageTensorUpdateAfterBind, OFFSET$descriptorBindingStorageTensorUpdateAfterBind, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int tensors() {
        return segment.get(LAYOUT$tensors, OFFSET$tensors);
    }

    public VkPhysicalDeviceTensorFeaturesARM tensors(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$tensors, OFFSET$tensors, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("tensorNonPacked"),
        ValueLayout.JAVA_INT.withName("shaderTensorAccess"),
        ValueLayout.JAVA_INT.withName("shaderStorageTensorArrayDynamicIndexing"),
        ValueLayout.JAVA_INT.withName("shaderStorageTensorArrayNonUniformIndexing"),
        ValueLayout.JAVA_INT.withName("descriptorBindingStorageTensorUpdateAfterBind"),
        ValueLayout.JAVA_INT.withName("tensors")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$tensorNonPacked = PathElement.groupElement("tensorNonPacked");
    public static final PathElement PATH$shaderTensorAccess = PathElement.groupElement("shaderTensorAccess");
    public static final PathElement PATH$shaderStorageTensorArrayDynamicIndexing = PathElement.groupElement("shaderStorageTensorArrayDynamicIndexing");
    public static final PathElement PATH$shaderStorageTensorArrayNonUniformIndexing = PathElement.groupElement("shaderStorageTensorArrayNonUniformIndexing");
    public static final PathElement PATH$descriptorBindingStorageTensorUpdateAfterBind = PathElement.groupElement("descriptorBindingStorageTensorUpdateAfterBind");
    public static final PathElement PATH$tensors = PathElement.groupElement("tensors");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$tensorNonPacked = (OfInt) LAYOUT.select(PATH$tensorNonPacked);
    public static final OfInt LAYOUT$shaderTensorAccess = (OfInt) LAYOUT.select(PATH$shaderTensorAccess);
    public static final OfInt LAYOUT$shaderStorageTensorArrayDynamicIndexing = (OfInt) LAYOUT.select(PATH$shaderStorageTensorArrayDynamicIndexing);
    public static final OfInt LAYOUT$shaderStorageTensorArrayNonUniformIndexing = (OfInt) LAYOUT.select(PATH$shaderStorageTensorArrayNonUniformIndexing);
    public static final OfInt LAYOUT$descriptorBindingStorageTensorUpdateAfterBind = (OfInt) LAYOUT.select(PATH$descriptorBindingStorageTensorUpdateAfterBind);
    public static final OfInt LAYOUT$tensors = (OfInt) LAYOUT.select(PATH$tensors);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$tensorNonPacked = LAYOUT$tensorNonPacked.byteSize();
    public static final long SIZE$shaderTensorAccess = LAYOUT$shaderTensorAccess.byteSize();
    public static final long SIZE$shaderStorageTensorArrayDynamicIndexing = LAYOUT$shaderStorageTensorArrayDynamicIndexing.byteSize();
    public static final long SIZE$shaderStorageTensorArrayNonUniformIndexing = LAYOUT$shaderStorageTensorArrayNonUniformIndexing.byteSize();
    public static final long SIZE$descriptorBindingStorageTensorUpdateAfterBind = LAYOUT$descriptorBindingStorageTensorUpdateAfterBind.byteSize();
    public static final long SIZE$tensors = LAYOUT$tensors.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$tensorNonPacked = LAYOUT.byteOffset(PATH$tensorNonPacked);
    public static final long OFFSET$shaderTensorAccess = LAYOUT.byteOffset(PATH$shaderTensorAccess);
    public static final long OFFSET$shaderStorageTensorArrayDynamicIndexing = LAYOUT.byteOffset(PATH$shaderStorageTensorArrayDynamicIndexing);
    public static final long OFFSET$shaderStorageTensorArrayNonUniformIndexing = LAYOUT.byteOffset(PATH$shaderStorageTensorArrayNonUniformIndexing);
    public static final long OFFSET$descriptorBindingStorageTensorUpdateAfterBind = LAYOUT.byteOffset(PATH$descriptorBindingStorageTensorUpdateAfterBind);
    public static final long OFFSET$tensors = LAYOUT.byteOffset(PATH$tensors);
}
