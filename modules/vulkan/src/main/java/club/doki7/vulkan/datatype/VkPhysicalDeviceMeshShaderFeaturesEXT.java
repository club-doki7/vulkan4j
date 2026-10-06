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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceMeshShaderFeaturesEXT.html"><code>VkPhysicalDeviceMeshShaderFeaturesEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceMeshShaderFeaturesEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 taskShader; // @link substring="taskShader" target="#taskShader"
///     VkBool32 meshShader; // @link substring="meshShader" target="#meshShader"
///     VkBool32 multiviewMeshShader; // @link substring="multiviewMeshShader" target="#multiviewMeshShader"
///     VkBool32 primitiveFragmentShadingRateMeshShader; // @link substring="primitiveFragmentShadingRateMeshShader" target="#primitiveFragmentShadingRateMeshShader"
///     VkBool32 meshShaderQueries; // @link substring="meshShaderQueries" target="#meshShaderQueries"
/// } VkPhysicalDeviceMeshShaderFeaturesEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_MESH_SHADER_FEATURES_EXT`
///
/// The {@code allocate} ({@link VkPhysicalDeviceMeshShaderFeaturesEXT#allocate(Arena)}, {@link VkPhysicalDeviceMeshShaderFeaturesEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceMeshShaderFeaturesEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceMeshShaderFeaturesEXT.html"><code>VkPhysicalDeviceMeshShaderFeaturesEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceMeshShaderFeaturesEXT(@NotNull MemorySegment segment) implements IVkPhysicalDeviceMeshShaderFeaturesEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceMeshShaderFeaturesEXT.html"><code>VkPhysicalDeviceMeshShaderFeaturesEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceMeshShaderFeaturesEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceMeshShaderFeaturesEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceMeshShaderFeaturesEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceMeshShaderFeaturesEXT, Iterable<VkPhysicalDeviceMeshShaderFeaturesEXT> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceMeshShaderFeaturesEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceMeshShaderFeaturesEXT at(long index) {
            return new VkPhysicalDeviceMeshShaderFeaturesEXT(segment.asSlice(index * VkPhysicalDeviceMeshShaderFeaturesEXT.BYTES, VkPhysicalDeviceMeshShaderFeaturesEXT.BYTES));
        }

        public VkPhysicalDeviceMeshShaderFeaturesEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceMeshShaderFeaturesEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceMeshShaderFeaturesEXT value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceMeshShaderFeaturesEXT.BYTES, VkPhysicalDeviceMeshShaderFeaturesEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceMeshShaderFeaturesEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceMeshShaderFeaturesEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceMeshShaderFeaturesEXT.BYTES,
                (end - start) * VkPhysicalDeviceMeshShaderFeaturesEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceMeshShaderFeaturesEXT.BYTES));
        }

        public VkPhysicalDeviceMeshShaderFeaturesEXT[] toArray() {
            VkPhysicalDeviceMeshShaderFeaturesEXT[] ret = new VkPhysicalDeviceMeshShaderFeaturesEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceMeshShaderFeaturesEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceMeshShaderFeaturesEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceMeshShaderFeaturesEXT.BYTES;
            }

            @Override
            public VkPhysicalDeviceMeshShaderFeaturesEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceMeshShaderFeaturesEXT ret = new VkPhysicalDeviceMeshShaderFeaturesEXT(segment.asSlice(0, VkPhysicalDeviceMeshShaderFeaturesEXT.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceMeshShaderFeaturesEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceMeshShaderFeaturesEXT allocate(Arena arena) {
        VkPhysicalDeviceMeshShaderFeaturesEXT ret = new VkPhysicalDeviceMeshShaderFeaturesEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_MESH_SHADER_FEATURES_EXT);
        return ret;
    }

    public static VkPhysicalDeviceMeshShaderFeaturesEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceMeshShaderFeaturesEXT.Ptr ret = new VkPhysicalDeviceMeshShaderFeaturesEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_MESH_SHADER_FEATURES_EXT);
        }
        return ret;
    }

    public static VkPhysicalDeviceMeshShaderFeaturesEXT clone(Arena arena, VkPhysicalDeviceMeshShaderFeaturesEXT src) {
        VkPhysicalDeviceMeshShaderFeaturesEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_MESH_SHADER_FEATURES_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceMeshShaderFeaturesEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceMeshShaderFeaturesEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceMeshShaderFeaturesEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int taskShader() {
        return segment.get(LAYOUT$taskShader, OFFSET$taskShader);
    }

    public VkPhysicalDeviceMeshShaderFeaturesEXT taskShader(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$taskShader, OFFSET$taskShader, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int meshShader() {
        return segment.get(LAYOUT$meshShader, OFFSET$meshShader);
    }

    public VkPhysicalDeviceMeshShaderFeaturesEXT meshShader(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$meshShader, OFFSET$meshShader, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int multiviewMeshShader() {
        return segment.get(LAYOUT$multiviewMeshShader, OFFSET$multiviewMeshShader);
    }

    public VkPhysicalDeviceMeshShaderFeaturesEXT multiviewMeshShader(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$multiviewMeshShader, OFFSET$multiviewMeshShader, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int primitiveFragmentShadingRateMeshShader() {
        return segment.get(LAYOUT$primitiveFragmentShadingRateMeshShader, OFFSET$primitiveFragmentShadingRateMeshShader);
    }

    public VkPhysicalDeviceMeshShaderFeaturesEXT primitiveFragmentShadingRateMeshShader(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$primitiveFragmentShadingRateMeshShader, OFFSET$primitiveFragmentShadingRateMeshShader, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int meshShaderQueries() {
        return segment.get(LAYOUT$meshShaderQueries, OFFSET$meshShaderQueries);
    }

    public VkPhysicalDeviceMeshShaderFeaturesEXT meshShaderQueries(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$meshShaderQueries, OFFSET$meshShaderQueries, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("taskShader"),
        ValueLayout.JAVA_INT.withName("meshShader"),
        ValueLayout.JAVA_INT.withName("multiviewMeshShader"),
        ValueLayout.JAVA_INT.withName("primitiveFragmentShadingRateMeshShader"),
        ValueLayout.JAVA_INT.withName("meshShaderQueries")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$taskShader = PathElement.groupElement("taskShader");
    public static final PathElement PATH$meshShader = PathElement.groupElement("meshShader");
    public static final PathElement PATH$multiviewMeshShader = PathElement.groupElement("multiviewMeshShader");
    public static final PathElement PATH$primitiveFragmentShadingRateMeshShader = PathElement.groupElement("primitiveFragmentShadingRateMeshShader");
    public static final PathElement PATH$meshShaderQueries = PathElement.groupElement("meshShaderQueries");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$taskShader = (OfInt) LAYOUT.select(PATH$taskShader);
    public static final OfInt LAYOUT$meshShader = (OfInt) LAYOUT.select(PATH$meshShader);
    public static final OfInt LAYOUT$multiviewMeshShader = (OfInt) LAYOUT.select(PATH$multiviewMeshShader);
    public static final OfInt LAYOUT$primitiveFragmentShadingRateMeshShader = (OfInt) LAYOUT.select(PATH$primitiveFragmentShadingRateMeshShader);
    public static final OfInt LAYOUT$meshShaderQueries = (OfInt) LAYOUT.select(PATH$meshShaderQueries);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$taskShader = LAYOUT$taskShader.byteSize();
    public static final long SIZE$meshShader = LAYOUT$meshShader.byteSize();
    public static final long SIZE$multiviewMeshShader = LAYOUT$multiviewMeshShader.byteSize();
    public static final long SIZE$primitiveFragmentShadingRateMeshShader = LAYOUT$primitiveFragmentShadingRateMeshShader.byteSize();
    public static final long SIZE$meshShaderQueries = LAYOUT$meshShaderQueries.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$taskShader = LAYOUT.byteOffset(PATH$taskShader);
    public static final long OFFSET$meshShader = LAYOUT.byteOffset(PATH$meshShader);
    public static final long OFFSET$multiviewMeshShader = LAYOUT.byteOffset(PATH$multiviewMeshShader);
    public static final long OFFSET$primitiveFragmentShadingRateMeshShader = LAYOUT.byteOffset(PATH$primitiveFragmentShadingRateMeshShader);
    public static final long OFFSET$meshShaderQueries = LAYOUT.byteOffset(PATH$meshShaderQueries);
}
