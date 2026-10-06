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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceTileShadingFeaturesQCOM.html"><code>VkPhysicalDeviceTileShadingFeaturesQCOM</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceTileShadingFeaturesQCOM {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 tileShading; // @link substring="tileShading" target="#tileShading"
///     VkBool32 tileShadingFragmentStage; // @link substring="tileShadingFragmentStage" target="#tileShadingFragmentStage"
///     VkBool32 tileShadingColorAttachments; // @link substring="tileShadingColorAttachments" target="#tileShadingColorAttachments"
///     VkBool32 tileShadingDepthAttachments; // @link substring="tileShadingDepthAttachments" target="#tileShadingDepthAttachments"
///     VkBool32 tileShadingStencilAttachments; // @link substring="tileShadingStencilAttachments" target="#tileShadingStencilAttachments"
///     VkBool32 tileShadingInputAttachments; // @link substring="tileShadingInputAttachments" target="#tileShadingInputAttachments"
///     VkBool32 tileShadingSampledAttachments; // @link substring="tileShadingSampledAttachments" target="#tileShadingSampledAttachments"
///     VkBool32 tileShadingPerTileDraw; // @link substring="tileShadingPerTileDraw" target="#tileShadingPerTileDraw"
///     VkBool32 tileShadingPerTileDispatch; // @link substring="tileShadingPerTileDispatch" target="#tileShadingPerTileDispatch"
///     VkBool32 tileShadingDispatchTile; // @link substring="tileShadingDispatchTile" target="#tileShadingDispatchTile"
///     VkBool32 tileShadingApron; // @link substring="tileShadingApron" target="#tileShadingApron"
///     VkBool32 tileShadingAnisotropicApron; // @link substring="tileShadingAnisotropicApron" target="#tileShadingAnisotropicApron"
///     VkBool32 tileShadingAtomicOps; // @link substring="tileShadingAtomicOps" target="#tileShadingAtomicOps"
///     VkBool32 tileShadingImageProcessing; // @link substring="tileShadingImageProcessing" target="#tileShadingImageProcessing"
/// } VkPhysicalDeviceTileShadingFeaturesQCOM;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_TILE_SHADING_FEATURES_QCOM`
///
/// The {@code allocate} ({@link VkPhysicalDeviceTileShadingFeaturesQCOM#allocate(Arena)}, {@link VkPhysicalDeviceTileShadingFeaturesQCOM#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceTileShadingFeaturesQCOM#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceTileShadingFeaturesQCOM.html"><code>VkPhysicalDeviceTileShadingFeaturesQCOM</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceTileShadingFeaturesQCOM(@NotNull MemorySegment segment) implements IVkPhysicalDeviceTileShadingFeaturesQCOM {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceTileShadingFeaturesQCOM.html"><code>VkPhysicalDeviceTileShadingFeaturesQCOM</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceTileShadingFeaturesQCOM}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceTileShadingFeaturesQCOM to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceTileShadingFeaturesQCOM.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceTileShadingFeaturesQCOM, Iterable<VkPhysicalDeviceTileShadingFeaturesQCOM> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceTileShadingFeaturesQCOM.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceTileShadingFeaturesQCOM at(long index) {
            return new VkPhysicalDeviceTileShadingFeaturesQCOM(segment.asSlice(index * VkPhysicalDeviceTileShadingFeaturesQCOM.BYTES, VkPhysicalDeviceTileShadingFeaturesQCOM.BYTES));
        }

        public VkPhysicalDeviceTileShadingFeaturesQCOM.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceTileShadingFeaturesQCOM> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceTileShadingFeaturesQCOM value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceTileShadingFeaturesQCOM.BYTES, VkPhysicalDeviceTileShadingFeaturesQCOM.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceTileShadingFeaturesQCOM.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceTileShadingFeaturesQCOM.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceTileShadingFeaturesQCOM.BYTES,
                (end - start) * VkPhysicalDeviceTileShadingFeaturesQCOM.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceTileShadingFeaturesQCOM.BYTES));
        }

        public VkPhysicalDeviceTileShadingFeaturesQCOM[] toArray() {
            VkPhysicalDeviceTileShadingFeaturesQCOM[] ret = new VkPhysicalDeviceTileShadingFeaturesQCOM[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceTileShadingFeaturesQCOM> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceTileShadingFeaturesQCOM> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceTileShadingFeaturesQCOM.BYTES;
            }

            @Override
            public VkPhysicalDeviceTileShadingFeaturesQCOM next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceTileShadingFeaturesQCOM ret = new VkPhysicalDeviceTileShadingFeaturesQCOM(segment.asSlice(0, VkPhysicalDeviceTileShadingFeaturesQCOM.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceTileShadingFeaturesQCOM.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceTileShadingFeaturesQCOM allocate(Arena arena) {
        VkPhysicalDeviceTileShadingFeaturesQCOM ret = new VkPhysicalDeviceTileShadingFeaturesQCOM(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_TILE_SHADING_FEATURES_QCOM);
        return ret;
    }

    public static VkPhysicalDeviceTileShadingFeaturesQCOM.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceTileShadingFeaturesQCOM.Ptr ret = new VkPhysicalDeviceTileShadingFeaturesQCOM.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_TILE_SHADING_FEATURES_QCOM);
        }
        return ret;
    }

    public static VkPhysicalDeviceTileShadingFeaturesQCOM clone(Arena arena, VkPhysicalDeviceTileShadingFeaturesQCOM src) {
        VkPhysicalDeviceTileShadingFeaturesQCOM ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_TILE_SHADING_FEATURES_QCOM);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceTileShadingFeaturesQCOM sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceTileShadingFeaturesQCOM pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceTileShadingFeaturesQCOM pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int tileShading() {
        return segment.get(LAYOUT$tileShading, OFFSET$tileShading);
    }

    public VkPhysicalDeviceTileShadingFeaturesQCOM tileShading(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$tileShading, OFFSET$tileShading, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int tileShadingFragmentStage() {
        return segment.get(LAYOUT$tileShadingFragmentStage, OFFSET$tileShadingFragmentStage);
    }

    public VkPhysicalDeviceTileShadingFeaturesQCOM tileShadingFragmentStage(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$tileShadingFragmentStage, OFFSET$tileShadingFragmentStage, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int tileShadingColorAttachments() {
        return segment.get(LAYOUT$tileShadingColorAttachments, OFFSET$tileShadingColorAttachments);
    }

    public VkPhysicalDeviceTileShadingFeaturesQCOM tileShadingColorAttachments(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$tileShadingColorAttachments, OFFSET$tileShadingColorAttachments, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int tileShadingDepthAttachments() {
        return segment.get(LAYOUT$tileShadingDepthAttachments, OFFSET$tileShadingDepthAttachments);
    }

    public VkPhysicalDeviceTileShadingFeaturesQCOM tileShadingDepthAttachments(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$tileShadingDepthAttachments, OFFSET$tileShadingDepthAttachments, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int tileShadingStencilAttachments() {
        return segment.get(LAYOUT$tileShadingStencilAttachments, OFFSET$tileShadingStencilAttachments);
    }

    public VkPhysicalDeviceTileShadingFeaturesQCOM tileShadingStencilAttachments(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$tileShadingStencilAttachments, OFFSET$tileShadingStencilAttachments, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int tileShadingInputAttachments() {
        return segment.get(LAYOUT$tileShadingInputAttachments, OFFSET$tileShadingInputAttachments);
    }

    public VkPhysicalDeviceTileShadingFeaturesQCOM tileShadingInputAttachments(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$tileShadingInputAttachments, OFFSET$tileShadingInputAttachments, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int tileShadingSampledAttachments() {
        return segment.get(LAYOUT$tileShadingSampledAttachments, OFFSET$tileShadingSampledAttachments);
    }

    public VkPhysicalDeviceTileShadingFeaturesQCOM tileShadingSampledAttachments(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$tileShadingSampledAttachments, OFFSET$tileShadingSampledAttachments, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int tileShadingPerTileDraw() {
        return segment.get(LAYOUT$tileShadingPerTileDraw, OFFSET$tileShadingPerTileDraw);
    }

    public VkPhysicalDeviceTileShadingFeaturesQCOM tileShadingPerTileDraw(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$tileShadingPerTileDraw, OFFSET$tileShadingPerTileDraw, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int tileShadingPerTileDispatch() {
        return segment.get(LAYOUT$tileShadingPerTileDispatch, OFFSET$tileShadingPerTileDispatch);
    }

    public VkPhysicalDeviceTileShadingFeaturesQCOM tileShadingPerTileDispatch(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$tileShadingPerTileDispatch, OFFSET$tileShadingPerTileDispatch, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int tileShadingDispatchTile() {
        return segment.get(LAYOUT$tileShadingDispatchTile, OFFSET$tileShadingDispatchTile);
    }

    public VkPhysicalDeviceTileShadingFeaturesQCOM tileShadingDispatchTile(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$tileShadingDispatchTile, OFFSET$tileShadingDispatchTile, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int tileShadingApron() {
        return segment.get(LAYOUT$tileShadingApron, OFFSET$tileShadingApron);
    }

    public VkPhysicalDeviceTileShadingFeaturesQCOM tileShadingApron(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$tileShadingApron, OFFSET$tileShadingApron, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int tileShadingAnisotropicApron() {
        return segment.get(LAYOUT$tileShadingAnisotropicApron, OFFSET$tileShadingAnisotropicApron);
    }

    public VkPhysicalDeviceTileShadingFeaturesQCOM tileShadingAnisotropicApron(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$tileShadingAnisotropicApron, OFFSET$tileShadingAnisotropicApron, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int tileShadingAtomicOps() {
        return segment.get(LAYOUT$tileShadingAtomicOps, OFFSET$tileShadingAtomicOps);
    }

    public VkPhysicalDeviceTileShadingFeaturesQCOM tileShadingAtomicOps(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$tileShadingAtomicOps, OFFSET$tileShadingAtomicOps, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int tileShadingImageProcessing() {
        return segment.get(LAYOUT$tileShadingImageProcessing, OFFSET$tileShadingImageProcessing);
    }

    public VkPhysicalDeviceTileShadingFeaturesQCOM tileShadingImageProcessing(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$tileShadingImageProcessing, OFFSET$tileShadingImageProcessing, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("tileShading"),
        ValueLayout.JAVA_INT.withName("tileShadingFragmentStage"),
        ValueLayout.JAVA_INT.withName("tileShadingColorAttachments"),
        ValueLayout.JAVA_INT.withName("tileShadingDepthAttachments"),
        ValueLayout.JAVA_INT.withName("tileShadingStencilAttachments"),
        ValueLayout.JAVA_INT.withName("tileShadingInputAttachments"),
        ValueLayout.JAVA_INT.withName("tileShadingSampledAttachments"),
        ValueLayout.JAVA_INT.withName("tileShadingPerTileDraw"),
        ValueLayout.JAVA_INT.withName("tileShadingPerTileDispatch"),
        ValueLayout.JAVA_INT.withName("tileShadingDispatchTile"),
        ValueLayout.JAVA_INT.withName("tileShadingApron"),
        ValueLayout.JAVA_INT.withName("tileShadingAnisotropicApron"),
        ValueLayout.JAVA_INT.withName("tileShadingAtomicOps"),
        ValueLayout.JAVA_INT.withName("tileShadingImageProcessing")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$tileShading = PathElement.groupElement("tileShading");
    public static final PathElement PATH$tileShadingFragmentStage = PathElement.groupElement("tileShadingFragmentStage");
    public static final PathElement PATH$tileShadingColorAttachments = PathElement.groupElement("tileShadingColorAttachments");
    public static final PathElement PATH$tileShadingDepthAttachments = PathElement.groupElement("tileShadingDepthAttachments");
    public static final PathElement PATH$tileShadingStencilAttachments = PathElement.groupElement("tileShadingStencilAttachments");
    public static final PathElement PATH$tileShadingInputAttachments = PathElement.groupElement("tileShadingInputAttachments");
    public static final PathElement PATH$tileShadingSampledAttachments = PathElement.groupElement("tileShadingSampledAttachments");
    public static final PathElement PATH$tileShadingPerTileDraw = PathElement.groupElement("tileShadingPerTileDraw");
    public static final PathElement PATH$tileShadingPerTileDispatch = PathElement.groupElement("tileShadingPerTileDispatch");
    public static final PathElement PATH$tileShadingDispatchTile = PathElement.groupElement("tileShadingDispatchTile");
    public static final PathElement PATH$tileShadingApron = PathElement.groupElement("tileShadingApron");
    public static final PathElement PATH$tileShadingAnisotropicApron = PathElement.groupElement("tileShadingAnisotropicApron");
    public static final PathElement PATH$tileShadingAtomicOps = PathElement.groupElement("tileShadingAtomicOps");
    public static final PathElement PATH$tileShadingImageProcessing = PathElement.groupElement("tileShadingImageProcessing");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$tileShading = (OfInt) LAYOUT.select(PATH$tileShading);
    public static final OfInt LAYOUT$tileShadingFragmentStage = (OfInt) LAYOUT.select(PATH$tileShadingFragmentStage);
    public static final OfInt LAYOUT$tileShadingColorAttachments = (OfInt) LAYOUT.select(PATH$tileShadingColorAttachments);
    public static final OfInt LAYOUT$tileShadingDepthAttachments = (OfInt) LAYOUT.select(PATH$tileShadingDepthAttachments);
    public static final OfInt LAYOUT$tileShadingStencilAttachments = (OfInt) LAYOUT.select(PATH$tileShadingStencilAttachments);
    public static final OfInt LAYOUT$tileShadingInputAttachments = (OfInt) LAYOUT.select(PATH$tileShadingInputAttachments);
    public static final OfInt LAYOUT$tileShadingSampledAttachments = (OfInt) LAYOUT.select(PATH$tileShadingSampledAttachments);
    public static final OfInt LAYOUT$tileShadingPerTileDraw = (OfInt) LAYOUT.select(PATH$tileShadingPerTileDraw);
    public static final OfInt LAYOUT$tileShadingPerTileDispatch = (OfInt) LAYOUT.select(PATH$tileShadingPerTileDispatch);
    public static final OfInt LAYOUT$tileShadingDispatchTile = (OfInt) LAYOUT.select(PATH$tileShadingDispatchTile);
    public static final OfInt LAYOUT$tileShadingApron = (OfInt) LAYOUT.select(PATH$tileShadingApron);
    public static final OfInt LAYOUT$tileShadingAnisotropicApron = (OfInt) LAYOUT.select(PATH$tileShadingAnisotropicApron);
    public static final OfInt LAYOUT$tileShadingAtomicOps = (OfInt) LAYOUT.select(PATH$tileShadingAtomicOps);
    public static final OfInt LAYOUT$tileShadingImageProcessing = (OfInt) LAYOUT.select(PATH$tileShadingImageProcessing);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$tileShading = LAYOUT$tileShading.byteSize();
    public static final long SIZE$tileShadingFragmentStage = LAYOUT$tileShadingFragmentStage.byteSize();
    public static final long SIZE$tileShadingColorAttachments = LAYOUT$tileShadingColorAttachments.byteSize();
    public static final long SIZE$tileShadingDepthAttachments = LAYOUT$tileShadingDepthAttachments.byteSize();
    public static final long SIZE$tileShadingStencilAttachments = LAYOUT$tileShadingStencilAttachments.byteSize();
    public static final long SIZE$tileShadingInputAttachments = LAYOUT$tileShadingInputAttachments.byteSize();
    public static final long SIZE$tileShadingSampledAttachments = LAYOUT$tileShadingSampledAttachments.byteSize();
    public static final long SIZE$tileShadingPerTileDraw = LAYOUT$tileShadingPerTileDraw.byteSize();
    public static final long SIZE$tileShadingPerTileDispatch = LAYOUT$tileShadingPerTileDispatch.byteSize();
    public static final long SIZE$tileShadingDispatchTile = LAYOUT$tileShadingDispatchTile.byteSize();
    public static final long SIZE$tileShadingApron = LAYOUT$tileShadingApron.byteSize();
    public static final long SIZE$tileShadingAnisotropicApron = LAYOUT$tileShadingAnisotropicApron.byteSize();
    public static final long SIZE$tileShadingAtomicOps = LAYOUT$tileShadingAtomicOps.byteSize();
    public static final long SIZE$tileShadingImageProcessing = LAYOUT$tileShadingImageProcessing.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$tileShading = LAYOUT.byteOffset(PATH$tileShading);
    public static final long OFFSET$tileShadingFragmentStage = LAYOUT.byteOffset(PATH$tileShadingFragmentStage);
    public static final long OFFSET$tileShadingColorAttachments = LAYOUT.byteOffset(PATH$tileShadingColorAttachments);
    public static final long OFFSET$tileShadingDepthAttachments = LAYOUT.byteOffset(PATH$tileShadingDepthAttachments);
    public static final long OFFSET$tileShadingStencilAttachments = LAYOUT.byteOffset(PATH$tileShadingStencilAttachments);
    public static final long OFFSET$tileShadingInputAttachments = LAYOUT.byteOffset(PATH$tileShadingInputAttachments);
    public static final long OFFSET$tileShadingSampledAttachments = LAYOUT.byteOffset(PATH$tileShadingSampledAttachments);
    public static final long OFFSET$tileShadingPerTileDraw = LAYOUT.byteOffset(PATH$tileShadingPerTileDraw);
    public static final long OFFSET$tileShadingPerTileDispatch = LAYOUT.byteOffset(PATH$tileShadingPerTileDispatch);
    public static final long OFFSET$tileShadingDispatchTile = LAYOUT.byteOffset(PATH$tileShadingDispatchTile);
    public static final long OFFSET$tileShadingApron = LAYOUT.byteOffset(PATH$tileShadingApron);
    public static final long OFFSET$tileShadingAnisotropicApron = LAYOUT.byteOffset(PATH$tileShadingAnisotropicApron);
    public static final long OFFSET$tileShadingAtomicOps = LAYOUT.byteOffset(PATH$tileShadingAtomicOps);
    public static final long OFFSET$tileShadingImageProcessing = LAYOUT.byteOffset(PATH$tileShadingImageProcessing);
}
