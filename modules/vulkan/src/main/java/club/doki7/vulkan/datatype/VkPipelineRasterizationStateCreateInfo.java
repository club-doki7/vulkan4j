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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineRasterizationStateCreateInfo.html"><code>VkPipelineRasterizationStateCreateInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPipelineRasterizationStateCreateInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkPipelineRasterizationStateCreateFlags flags; // optional // @link substring="VkPipelineRasterizationStateCreateFlags" target="VkPipelineRasterizationStateCreateFlags" @link substring="flags" target="#flags"
///     VkBool32 depthClampEnable; // @link substring="depthClampEnable" target="#depthClampEnable"
///     VkBool32 rasterizerDiscardEnable; // @link substring="rasterizerDiscardEnable" target="#rasterizerDiscardEnable"
///     VkPolygonMode polygonMode; // @link substring="VkPolygonMode" target="VkPolygonMode" @link substring="polygonMode" target="#polygonMode"
///     VkCullModeFlags cullMode; // optional // @link substring="VkCullModeFlags" target="VkCullModeFlags" @link substring="cullMode" target="#cullMode"
///     VkFrontFace frontFace; // @link substring="VkFrontFace" target="VkFrontFace" @link substring="frontFace" target="#frontFace"
///     VkBool32 depthBiasEnable; // @link substring="depthBiasEnable" target="#depthBiasEnable"
///     float depthBiasConstantFactor; // @link substring="depthBiasConstantFactor" target="#depthBiasConstantFactor"
///     float depthBiasClamp; // @link substring="depthBiasClamp" target="#depthBiasClamp"
///     float depthBiasSlopeFactor; // @link substring="depthBiasSlopeFactor" target="#depthBiasSlopeFactor"
///     float lineWidth; // @link substring="lineWidth" target="#lineWidth"
/// } VkPipelineRasterizationStateCreateInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PIPELINE_RASTERIZATION_STATE_CREATE_INFO`
///
/// The {@code allocate} ({@link VkPipelineRasterizationStateCreateInfo#allocate(Arena)}, {@link VkPipelineRasterizationStateCreateInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPipelineRasterizationStateCreateInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineRasterizationStateCreateInfo.html"><code>VkPipelineRasterizationStateCreateInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPipelineRasterizationStateCreateInfo(@NotNull MemorySegment segment) implements IVkPipelineRasterizationStateCreateInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineRasterizationStateCreateInfo.html"><code>VkPipelineRasterizationStateCreateInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPipelineRasterizationStateCreateInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPipelineRasterizationStateCreateInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPipelineRasterizationStateCreateInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPipelineRasterizationStateCreateInfo, Iterable<VkPipelineRasterizationStateCreateInfo> {
        public long size() {
            return segment.byteSize() / VkPipelineRasterizationStateCreateInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPipelineRasterizationStateCreateInfo at(long index) {
            return new VkPipelineRasterizationStateCreateInfo(segment.asSlice(index * VkPipelineRasterizationStateCreateInfo.BYTES, VkPipelineRasterizationStateCreateInfo.BYTES));
        }

        public VkPipelineRasterizationStateCreateInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkPipelineRasterizationStateCreateInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPipelineRasterizationStateCreateInfo value) {
            MemorySegment s = segment.asSlice(index * VkPipelineRasterizationStateCreateInfo.BYTES, VkPipelineRasterizationStateCreateInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPipelineRasterizationStateCreateInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPipelineRasterizationStateCreateInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPipelineRasterizationStateCreateInfo.BYTES,
                (end - start) * VkPipelineRasterizationStateCreateInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPipelineRasterizationStateCreateInfo.BYTES));
        }

        public VkPipelineRasterizationStateCreateInfo[] toArray() {
            VkPipelineRasterizationStateCreateInfo[] ret = new VkPipelineRasterizationStateCreateInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPipelineRasterizationStateCreateInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPipelineRasterizationStateCreateInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPipelineRasterizationStateCreateInfo.BYTES;
            }

            @Override
            public VkPipelineRasterizationStateCreateInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPipelineRasterizationStateCreateInfo ret = new VkPipelineRasterizationStateCreateInfo(segment.asSlice(0, VkPipelineRasterizationStateCreateInfo.BYTES));
                segment = segment.asSlice(VkPipelineRasterizationStateCreateInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPipelineRasterizationStateCreateInfo allocate(Arena arena) {
        VkPipelineRasterizationStateCreateInfo ret = new VkPipelineRasterizationStateCreateInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PIPELINE_RASTERIZATION_STATE_CREATE_INFO);
        return ret;
    }

    public static VkPipelineRasterizationStateCreateInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPipelineRasterizationStateCreateInfo.Ptr ret = new VkPipelineRasterizationStateCreateInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PIPELINE_RASTERIZATION_STATE_CREATE_INFO);
        }
        return ret;
    }

    public static VkPipelineRasterizationStateCreateInfo clone(Arena arena, VkPipelineRasterizationStateCreateInfo src) {
        VkPipelineRasterizationStateCreateInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PIPELINE_RASTERIZATION_STATE_CREATE_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPipelineRasterizationStateCreateInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPipelineRasterizationStateCreateInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPipelineRasterizationStateCreateInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkPipelineRasterizationStateCreateFlags.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkPipelineRasterizationStateCreateInfo flags(@Bitmask(VkPipelineRasterizationStateCreateFlags.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int depthClampEnable() {
        return segment.get(LAYOUT$depthClampEnable, OFFSET$depthClampEnable);
    }

    public VkPipelineRasterizationStateCreateInfo depthClampEnable(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$depthClampEnable, OFFSET$depthClampEnable, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int rasterizerDiscardEnable() {
        return segment.get(LAYOUT$rasterizerDiscardEnable, OFFSET$rasterizerDiscardEnable);
    }

    public VkPipelineRasterizationStateCreateInfo rasterizerDiscardEnable(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$rasterizerDiscardEnable, OFFSET$rasterizerDiscardEnable, value);
        return this;
    }

    public @EnumType(VkPolygonMode.class) int polygonMode() {
        return segment.get(LAYOUT$polygonMode, OFFSET$polygonMode);
    }

    public VkPipelineRasterizationStateCreateInfo polygonMode(@EnumType(VkPolygonMode.class) int value) {
        segment.set(LAYOUT$polygonMode, OFFSET$polygonMode, value);
        return this;
    }

    public @Bitmask(VkCullModeFlags.class) int cullMode() {
        return segment.get(LAYOUT$cullMode, OFFSET$cullMode);
    }

    public VkPipelineRasterizationStateCreateInfo cullMode(@Bitmask(VkCullModeFlags.class) int value) {
        segment.set(LAYOUT$cullMode, OFFSET$cullMode, value);
        return this;
    }

    public @EnumType(VkFrontFace.class) int frontFace() {
        return segment.get(LAYOUT$frontFace, OFFSET$frontFace);
    }

    public VkPipelineRasterizationStateCreateInfo frontFace(@EnumType(VkFrontFace.class) int value) {
        segment.set(LAYOUT$frontFace, OFFSET$frontFace, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int depthBiasEnable() {
        return segment.get(LAYOUT$depthBiasEnable, OFFSET$depthBiasEnable);
    }

    public VkPipelineRasterizationStateCreateInfo depthBiasEnable(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$depthBiasEnable, OFFSET$depthBiasEnable, value);
        return this;
    }

    public float depthBiasConstantFactor() {
        return segment.get(LAYOUT$depthBiasConstantFactor, OFFSET$depthBiasConstantFactor);
    }

    public VkPipelineRasterizationStateCreateInfo depthBiasConstantFactor(float value) {
        segment.set(LAYOUT$depthBiasConstantFactor, OFFSET$depthBiasConstantFactor, value);
        return this;
    }

    public float depthBiasClamp() {
        return segment.get(LAYOUT$depthBiasClamp, OFFSET$depthBiasClamp);
    }

    public VkPipelineRasterizationStateCreateInfo depthBiasClamp(float value) {
        segment.set(LAYOUT$depthBiasClamp, OFFSET$depthBiasClamp, value);
        return this;
    }

    public float depthBiasSlopeFactor() {
        return segment.get(LAYOUT$depthBiasSlopeFactor, OFFSET$depthBiasSlopeFactor);
    }

    public VkPipelineRasterizationStateCreateInfo depthBiasSlopeFactor(float value) {
        segment.set(LAYOUT$depthBiasSlopeFactor, OFFSET$depthBiasSlopeFactor, value);
        return this;
    }

    public float lineWidth() {
        return segment.get(LAYOUT$lineWidth, OFFSET$lineWidth);
    }

    public VkPipelineRasterizationStateCreateInfo lineWidth(float value) {
        segment.set(LAYOUT$lineWidth, OFFSET$lineWidth, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("depthClampEnable"),
        ValueLayout.JAVA_INT.withName("rasterizerDiscardEnable"),
        ValueLayout.JAVA_INT.withName("polygonMode"),
        ValueLayout.JAVA_INT.withName("cullMode"),
        ValueLayout.JAVA_INT.withName("frontFace"),
        ValueLayout.JAVA_INT.withName("depthBiasEnable"),
        ValueLayout.JAVA_FLOAT.withName("depthBiasConstantFactor"),
        ValueLayout.JAVA_FLOAT.withName("depthBiasClamp"),
        ValueLayout.JAVA_FLOAT.withName("depthBiasSlopeFactor"),
        ValueLayout.JAVA_FLOAT.withName("lineWidth")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$depthClampEnable = PathElement.groupElement("depthClampEnable");
    public static final PathElement PATH$rasterizerDiscardEnable = PathElement.groupElement("rasterizerDiscardEnable");
    public static final PathElement PATH$polygonMode = PathElement.groupElement("polygonMode");
    public static final PathElement PATH$cullMode = PathElement.groupElement("cullMode");
    public static final PathElement PATH$frontFace = PathElement.groupElement("frontFace");
    public static final PathElement PATH$depthBiasEnable = PathElement.groupElement("depthBiasEnable");
    public static final PathElement PATH$depthBiasConstantFactor = PathElement.groupElement("depthBiasConstantFactor");
    public static final PathElement PATH$depthBiasClamp = PathElement.groupElement("depthBiasClamp");
    public static final PathElement PATH$depthBiasSlopeFactor = PathElement.groupElement("depthBiasSlopeFactor");
    public static final PathElement PATH$lineWidth = PathElement.groupElement("lineWidth");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$depthClampEnable = (OfInt) LAYOUT.select(PATH$depthClampEnable);
    public static final OfInt LAYOUT$rasterizerDiscardEnable = (OfInt) LAYOUT.select(PATH$rasterizerDiscardEnable);
    public static final OfInt LAYOUT$polygonMode = (OfInt) LAYOUT.select(PATH$polygonMode);
    public static final OfInt LAYOUT$cullMode = (OfInt) LAYOUT.select(PATH$cullMode);
    public static final OfInt LAYOUT$frontFace = (OfInt) LAYOUT.select(PATH$frontFace);
    public static final OfInt LAYOUT$depthBiasEnable = (OfInt) LAYOUT.select(PATH$depthBiasEnable);
    public static final OfFloat LAYOUT$depthBiasConstantFactor = (OfFloat) LAYOUT.select(PATH$depthBiasConstantFactor);
    public static final OfFloat LAYOUT$depthBiasClamp = (OfFloat) LAYOUT.select(PATH$depthBiasClamp);
    public static final OfFloat LAYOUT$depthBiasSlopeFactor = (OfFloat) LAYOUT.select(PATH$depthBiasSlopeFactor);
    public static final OfFloat LAYOUT$lineWidth = (OfFloat) LAYOUT.select(PATH$lineWidth);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$depthClampEnable = LAYOUT$depthClampEnable.byteSize();
    public static final long SIZE$rasterizerDiscardEnable = LAYOUT$rasterizerDiscardEnable.byteSize();
    public static final long SIZE$polygonMode = LAYOUT$polygonMode.byteSize();
    public static final long SIZE$cullMode = LAYOUT$cullMode.byteSize();
    public static final long SIZE$frontFace = LAYOUT$frontFace.byteSize();
    public static final long SIZE$depthBiasEnable = LAYOUT$depthBiasEnable.byteSize();
    public static final long SIZE$depthBiasConstantFactor = LAYOUT$depthBiasConstantFactor.byteSize();
    public static final long SIZE$depthBiasClamp = LAYOUT$depthBiasClamp.byteSize();
    public static final long SIZE$depthBiasSlopeFactor = LAYOUT$depthBiasSlopeFactor.byteSize();
    public static final long SIZE$lineWidth = LAYOUT$lineWidth.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$depthClampEnable = LAYOUT.byteOffset(PATH$depthClampEnable);
    public static final long OFFSET$rasterizerDiscardEnable = LAYOUT.byteOffset(PATH$rasterizerDiscardEnable);
    public static final long OFFSET$polygonMode = LAYOUT.byteOffset(PATH$polygonMode);
    public static final long OFFSET$cullMode = LAYOUT.byteOffset(PATH$cullMode);
    public static final long OFFSET$frontFace = LAYOUT.byteOffset(PATH$frontFace);
    public static final long OFFSET$depthBiasEnable = LAYOUT.byteOffset(PATH$depthBiasEnable);
    public static final long OFFSET$depthBiasConstantFactor = LAYOUT.byteOffset(PATH$depthBiasConstantFactor);
    public static final long OFFSET$depthBiasClamp = LAYOUT.byteOffset(PATH$depthBiasClamp);
    public static final long OFFSET$depthBiasSlopeFactor = LAYOUT.byteOffset(PATH$depthBiasSlopeFactor);
    public static final long OFFSET$lineWidth = LAYOUT.byteOffset(PATH$lineWidth);
}
