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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceDataGraphFeaturesARM.html"><code>VkPhysicalDeviceDataGraphFeaturesARM</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceDataGraphFeaturesARM {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 dataGraph; // @link substring="dataGraph" target="#dataGraph"
///     VkBool32 dataGraphUpdateAfterBind; // @link substring="dataGraphUpdateAfterBind" target="#dataGraphUpdateAfterBind"
///     VkBool32 dataGraphSpecializationConstants; // @link substring="dataGraphSpecializationConstants" target="#dataGraphSpecializationConstants"
///     VkBool32 dataGraphDescriptorBuffer; // @link substring="dataGraphDescriptorBuffer" target="#dataGraphDescriptorBuffer"
///     VkBool32 dataGraphShaderModule; // @link substring="dataGraphShaderModule" target="#dataGraphShaderModule"
/// } VkPhysicalDeviceDataGraphFeaturesARM;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_DATA_GRAPH_FEATURES_ARM`
///
/// The {@code allocate} ({@link VkPhysicalDeviceDataGraphFeaturesARM#allocate(Arena)}, {@link VkPhysicalDeviceDataGraphFeaturesARM#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceDataGraphFeaturesARM#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceDataGraphFeaturesARM.html"><code>VkPhysicalDeviceDataGraphFeaturesARM</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceDataGraphFeaturesARM(@NotNull MemorySegment segment) implements IVkPhysicalDeviceDataGraphFeaturesARM {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceDataGraphFeaturesARM.html"><code>VkPhysicalDeviceDataGraphFeaturesARM</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceDataGraphFeaturesARM}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceDataGraphFeaturesARM to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceDataGraphFeaturesARM.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceDataGraphFeaturesARM, Iterable<VkPhysicalDeviceDataGraphFeaturesARM> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceDataGraphFeaturesARM.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceDataGraphFeaturesARM at(long index) {
            return new VkPhysicalDeviceDataGraphFeaturesARM(segment.asSlice(index * VkPhysicalDeviceDataGraphFeaturesARM.BYTES, VkPhysicalDeviceDataGraphFeaturesARM.BYTES));
        }

        public VkPhysicalDeviceDataGraphFeaturesARM.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceDataGraphFeaturesARM> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceDataGraphFeaturesARM value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceDataGraphFeaturesARM.BYTES, VkPhysicalDeviceDataGraphFeaturesARM.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceDataGraphFeaturesARM.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceDataGraphFeaturesARM.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceDataGraphFeaturesARM.BYTES,
                (end - start) * VkPhysicalDeviceDataGraphFeaturesARM.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceDataGraphFeaturesARM.BYTES));
        }

        public VkPhysicalDeviceDataGraphFeaturesARM[] toArray() {
            VkPhysicalDeviceDataGraphFeaturesARM[] ret = new VkPhysicalDeviceDataGraphFeaturesARM[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceDataGraphFeaturesARM> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceDataGraphFeaturesARM> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceDataGraphFeaturesARM.BYTES;
            }

            @Override
            public VkPhysicalDeviceDataGraphFeaturesARM next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceDataGraphFeaturesARM ret = new VkPhysicalDeviceDataGraphFeaturesARM(segment.asSlice(0, VkPhysicalDeviceDataGraphFeaturesARM.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceDataGraphFeaturesARM.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceDataGraphFeaturesARM allocate(Arena arena) {
        VkPhysicalDeviceDataGraphFeaturesARM ret = new VkPhysicalDeviceDataGraphFeaturesARM(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_DATA_GRAPH_FEATURES_ARM);
        return ret;
    }

    public static VkPhysicalDeviceDataGraphFeaturesARM.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceDataGraphFeaturesARM.Ptr ret = new VkPhysicalDeviceDataGraphFeaturesARM.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_DATA_GRAPH_FEATURES_ARM);
        }
        return ret;
    }

    public static VkPhysicalDeviceDataGraphFeaturesARM clone(Arena arena, VkPhysicalDeviceDataGraphFeaturesARM src) {
        VkPhysicalDeviceDataGraphFeaturesARM ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_DATA_GRAPH_FEATURES_ARM);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceDataGraphFeaturesARM sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceDataGraphFeaturesARM pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceDataGraphFeaturesARM pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int dataGraph() {
        return segment.get(LAYOUT$dataGraph, OFFSET$dataGraph);
    }

    public VkPhysicalDeviceDataGraphFeaturesARM dataGraph(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$dataGraph, OFFSET$dataGraph, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int dataGraphUpdateAfterBind() {
        return segment.get(LAYOUT$dataGraphUpdateAfterBind, OFFSET$dataGraphUpdateAfterBind);
    }

    public VkPhysicalDeviceDataGraphFeaturesARM dataGraphUpdateAfterBind(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$dataGraphUpdateAfterBind, OFFSET$dataGraphUpdateAfterBind, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int dataGraphSpecializationConstants() {
        return segment.get(LAYOUT$dataGraphSpecializationConstants, OFFSET$dataGraphSpecializationConstants);
    }

    public VkPhysicalDeviceDataGraphFeaturesARM dataGraphSpecializationConstants(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$dataGraphSpecializationConstants, OFFSET$dataGraphSpecializationConstants, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int dataGraphDescriptorBuffer() {
        return segment.get(LAYOUT$dataGraphDescriptorBuffer, OFFSET$dataGraphDescriptorBuffer);
    }

    public VkPhysicalDeviceDataGraphFeaturesARM dataGraphDescriptorBuffer(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$dataGraphDescriptorBuffer, OFFSET$dataGraphDescriptorBuffer, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int dataGraphShaderModule() {
        return segment.get(LAYOUT$dataGraphShaderModule, OFFSET$dataGraphShaderModule);
    }

    public VkPhysicalDeviceDataGraphFeaturesARM dataGraphShaderModule(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$dataGraphShaderModule, OFFSET$dataGraphShaderModule, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("dataGraph"),
        ValueLayout.JAVA_INT.withName("dataGraphUpdateAfterBind"),
        ValueLayout.JAVA_INT.withName("dataGraphSpecializationConstants"),
        ValueLayout.JAVA_INT.withName("dataGraphDescriptorBuffer"),
        ValueLayout.JAVA_INT.withName("dataGraphShaderModule")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$dataGraph = PathElement.groupElement("dataGraph");
    public static final PathElement PATH$dataGraphUpdateAfterBind = PathElement.groupElement("dataGraphUpdateAfterBind");
    public static final PathElement PATH$dataGraphSpecializationConstants = PathElement.groupElement("dataGraphSpecializationConstants");
    public static final PathElement PATH$dataGraphDescriptorBuffer = PathElement.groupElement("dataGraphDescriptorBuffer");
    public static final PathElement PATH$dataGraphShaderModule = PathElement.groupElement("dataGraphShaderModule");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$dataGraph = (OfInt) LAYOUT.select(PATH$dataGraph);
    public static final OfInt LAYOUT$dataGraphUpdateAfterBind = (OfInt) LAYOUT.select(PATH$dataGraphUpdateAfterBind);
    public static final OfInt LAYOUT$dataGraphSpecializationConstants = (OfInt) LAYOUT.select(PATH$dataGraphSpecializationConstants);
    public static final OfInt LAYOUT$dataGraphDescriptorBuffer = (OfInt) LAYOUT.select(PATH$dataGraphDescriptorBuffer);
    public static final OfInt LAYOUT$dataGraphShaderModule = (OfInt) LAYOUT.select(PATH$dataGraphShaderModule);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$dataGraph = LAYOUT$dataGraph.byteSize();
    public static final long SIZE$dataGraphUpdateAfterBind = LAYOUT$dataGraphUpdateAfterBind.byteSize();
    public static final long SIZE$dataGraphSpecializationConstants = LAYOUT$dataGraphSpecializationConstants.byteSize();
    public static final long SIZE$dataGraphDescriptorBuffer = LAYOUT$dataGraphDescriptorBuffer.byteSize();
    public static final long SIZE$dataGraphShaderModule = LAYOUT$dataGraphShaderModule.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$dataGraph = LAYOUT.byteOffset(PATH$dataGraph);
    public static final long OFFSET$dataGraphUpdateAfterBind = LAYOUT.byteOffset(PATH$dataGraphUpdateAfterBind);
    public static final long OFFSET$dataGraphSpecializationConstants = LAYOUT.byteOffset(PATH$dataGraphSpecializationConstants);
    public static final long OFFSET$dataGraphDescriptorBuffer = LAYOUT.byteOffset(PATH$dataGraphDescriptorBuffer);
    public static final long OFFSET$dataGraphShaderModule = LAYOUT.byteOffset(PATH$dataGraphShaderModule);
}
