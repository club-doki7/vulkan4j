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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineMultisampleStateCreateInfo.html"><code>VkPipelineMultisampleStateCreateInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPipelineMultisampleStateCreateInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkPipelineMultisampleStateCreateFlags flags; // optional // @link substring="VkPipelineMultisampleStateCreateFlags" target="VkPipelineMultisampleStateCreateFlags" @link substring="flags" target="#flags"
///     VkSampleCountFlags rasterizationSamples; // @link substring="VkSampleCountFlags" target="VkSampleCountFlags" @link substring="rasterizationSamples" target="#rasterizationSamples"
///     VkBool32 sampleShadingEnable; // @link substring="sampleShadingEnable" target="#sampleShadingEnable"
///     float minSampleShading; // @link substring="minSampleShading" target="#minSampleShading"
///     VkSampleMask const* pSampleMask; // optional // @link substring="pSampleMask" target="#pSampleMask"
///     VkBool32 alphaToCoverageEnable; // @link substring="alphaToCoverageEnable" target="#alphaToCoverageEnable"
///     VkBool32 alphaToOneEnable; // @link substring="alphaToOneEnable" target="#alphaToOneEnable"
/// } VkPipelineMultisampleStateCreateInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PIPELINE_MULTISAMPLE_STATE_CREATE_INFO`
///
/// The {@code allocate} ({@link VkPipelineMultisampleStateCreateInfo#allocate(Arena)}, {@link VkPipelineMultisampleStateCreateInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPipelineMultisampleStateCreateInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineMultisampleStateCreateInfo.html"><code>VkPipelineMultisampleStateCreateInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPipelineMultisampleStateCreateInfo(@NotNull MemorySegment segment) implements IVkPipelineMultisampleStateCreateInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineMultisampleStateCreateInfo.html"><code>VkPipelineMultisampleStateCreateInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPipelineMultisampleStateCreateInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPipelineMultisampleStateCreateInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPipelineMultisampleStateCreateInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPipelineMultisampleStateCreateInfo, Iterable<VkPipelineMultisampleStateCreateInfo> {
        public long size() {
            return segment.byteSize() / VkPipelineMultisampleStateCreateInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPipelineMultisampleStateCreateInfo at(long index) {
            return new VkPipelineMultisampleStateCreateInfo(segment.asSlice(index * VkPipelineMultisampleStateCreateInfo.BYTES, VkPipelineMultisampleStateCreateInfo.BYTES));
        }

        public VkPipelineMultisampleStateCreateInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkPipelineMultisampleStateCreateInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPipelineMultisampleStateCreateInfo value) {
            MemorySegment s = segment.asSlice(index * VkPipelineMultisampleStateCreateInfo.BYTES, VkPipelineMultisampleStateCreateInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPipelineMultisampleStateCreateInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPipelineMultisampleStateCreateInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPipelineMultisampleStateCreateInfo.BYTES,
                (end - start) * VkPipelineMultisampleStateCreateInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPipelineMultisampleStateCreateInfo.BYTES));
        }

        public VkPipelineMultisampleStateCreateInfo[] toArray() {
            VkPipelineMultisampleStateCreateInfo[] ret = new VkPipelineMultisampleStateCreateInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPipelineMultisampleStateCreateInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPipelineMultisampleStateCreateInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPipelineMultisampleStateCreateInfo.BYTES;
            }

            @Override
            public VkPipelineMultisampleStateCreateInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPipelineMultisampleStateCreateInfo ret = new VkPipelineMultisampleStateCreateInfo(segment.asSlice(0, VkPipelineMultisampleStateCreateInfo.BYTES));
                segment = segment.asSlice(VkPipelineMultisampleStateCreateInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPipelineMultisampleStateCreateInfo allocate(Arena arena) {
        VkPipelineMultisampleStateCreateInfo ret = new VkPipelineMultisampleStateCreateInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PIPELINE_MULTISAMPLE_STATE_CREATE_INFO);
        return ret;
    }

    public static VkPipelineMultisampleStateCreateInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPipelineMultisampleStateCreateInfo.Ptr ret = new VkPipelineMultisampleStateCreateInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PIPELINE_MULTISAMPLE_STATE_CREATE_INFO);
        }
        return ret;
    }

    public static VkPipelineMultisampleStateCreateInfo clone(Arena arena, VkPipelineMultisampleStateCreateInfo src) {
        VkPipelineMultisampleStateCreateInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PIPELINE_MULTISAMPLE_STATE_CREATE_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPipelineMultisampleStateCreateInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPipelineMultisampleStateCreateInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPipelineMultisampleStateCreateInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkPipelineMultisampleStateCreateFlags.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkPipelineMultisampleStateCreateInfo flags(@Bitmask(VkPipelineMultisampleStateCreateFlags.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @Bitmask(VkSampleCountFlags.class) int rasterizationSamples() {
        return segment.get(LAYOUT$rasterizationSamples, OFFSET$rasterizationSamples);
    }

    public VkPipelineMultisampleStateCreateInfo rasterizationSamples(@Bitmask(VkSampleCountFlags.class) int value) {
        segment.set(LAYOUT$rasterizationSamples, OFFSET$rasterizationSamples, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int sampleShadingEnable() {
        return segment.get(LAYOUT$sampleShadingEnable, OFFSET$sampleShadingEnable);
    }

    public VkPipelineMultisampleStateCreateInfo sampleShadingEnable(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$sampleShadingEnable, OFFSET$sampleShadingEnable, value);
        return this;
    }

    public float minSampleShading() {
        return segment.get(LAYOUT$minSampleShading, OFFSET$minSampleShading);
    }

    public VkPipelineMultisampleStateCreateInfo minSampleShading(float value) {
        segment.set(LAYOUT$minSampleShading, OFFSET$minSampleShading, value);
        return this;
    }

    /// Note: the returned {@link IntPtr} does not have correct
    /// {@link IntPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link IntPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable @Pointer(comment="VkSampleMask") @Unsigned IntPtr pSampleMask() {
        MemorySegment s = pSampleMaskRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new IntPtr(s);
    }

    public VkPipelineMultisampleStateCreateInfo pSampleMask(@Nullable @Pointer(comment="VkSampleMask") @Unsigned IntPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pSampleMaskRaw(s);
        return this;
    }

    public @Pointer(comment="uint32_t*") @NotNull MemorySegment pSampleMaskRaw() {
        return segment.get(LAYOUT$pSampleMask, OFFSET$pSampleMask);
    }

    public void pSampleMaskRaw(@Pointer(comment="uint32_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pSampleMask, OFFSET$pSampleMask, value);
    }

    public @NativeType("VkBool32") @Unsigned int alphaToCoverageEnable() {
        return segment.get(LAYOUT$alphaToCoverageEnable, OFFSET$alphaToCoverageEnable);
    }

    public VkPipelineMultisampleStateCreateInfo alphaToCoverageEnable(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$alphaToCoverageEnable, OFFSET$alphaToCoverageEnable, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int alphaToOneEnable() {
        return segment.get(LAYOUT$alphaToOneEnable, OFFSET$alphaToOneEnable);
    }

    public VkPipelineMultisampleStateCreateInfo alphaToOneEnable(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$alphaToOneEnable, OFFSET$alphaToOneEnable, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("rasterizationSamples"),
        ValueLayout.JAVA_INT.withName("sampleShadingEnable"),
        ValueLayout.JAVA_FLOAT.withName("minSampleShading"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pSampleMask"),
        ValueLayout.JAVA_INT.withName("alphaToCoverageEnable"),
        ValueLayout.JAVA_INT.withName("alphaToOneEnable")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$rasterizationSamples = PathElement.groupElement("rasterizationSamples");
    public static final PathElement PATH$sampleShadingEnable = PathElement.groupElement("sampleShadingEnable");
    public static final PathElement PATH$minSampleShading = PathElement.groupElement("minSampleShading");
    public static final PathElement PATH$pSampleMask = PathElement.groupElement("pSampleMask");
    public static final PathElement PATH$alphaToCoverageEnable = PathElement.groupElement("alphaToCoverageEnable");
    public static final PathElement PATH$alphaToOneEnable = PathElement.groupElement("alphaToOneEnable");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$rasterizationSamples = (OfInt) LAYOUT.select(PATH$rasterizationSamples);
    public static final OfInt LAYOUT$sampleShadingEnable = (OfInt) LAYOUT.select(PATH$sampleShadingEnable);
    public static final OfFloat LAYOUT$minSampleShading = (OfFloat) LAYOUT.select(PATH$minSampleShading);
    public static final AddressLayout LAYOUT$pSampleMask = (AddressLayout) LAYOUT.select(PATH$pSampleMask);
    public static final OfInt LAYOUT$alphaToCoverageEnable = (OfInt) LAYOUT.select(PATH$alphaToCoverageEnable);
    public static final OfInt LAYOUT$alphaToOneEnable = (OfInt) LAYOUT.select(PATH$alphaToOneEnable);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$rasterizationSamples = LAYOUT$rasterizationSamples.byteSize();
    public static final long SIZE$sampleShadingEnable = LAYOUT$sampleShadingEnable.byteSize();
    public static final long SIZE$minSampleShading = LAYOUT$minSampleShading.byteSize();
    public static final long SIZE$pSampleMask = LAYOUT$pSampleMask.byteSize();
    public static final long SIZE$alphaToCoverageEnable = LAYOUT$alphaToCoverageEnable.byteSize();
    public static final long SIZE$alphaToOneEnable = LAYOUT$alphaToOneEnable.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$rasterizationSamples = LAYOUT.byteOffset(PATH$rasterizationSamples);
    public static final long OFFSET$sampleShadingEnable = LAYOUT.byteOffset(PATH$sampleShadingEnable);
    public static final long OFFSET$minSampleShading = LAYOUT.byteOffset(PATH$minSampleShading);
    public static final long OFFSET$pSampleMask = LAYOUT.byteOffset(PATH$pSampleMask);
    public static final long OFFSET$alphaToCoverageEnable = LAYOUT.byteOffset(PATH$alphaToCoverageEnable);
    public static final long OFFSET$alphaToOneEnable = LAYOUT.byteOffset(PATH$alphaToOneEnable);
}
