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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineRenderingCreateInfo.html"><code>VkPipelineRenderingCreateInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPipelineRenderingCreateInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t viewMask; // @link substring="viewMask" target="#viewMask"
///     uint32_t colorAttachmentCount; // optional // @link substring="colorAttachmentCount" target="#colorAttachmentCount"
///     VkFormat const* pColorAttachmentFormats; // optional // @link substring="VkFormat" target="VkFormat" @link substring="pColorAttachmentFormats" target="#pColorAttachmentFormats"
///     VkFormat depthAttachmentFormat; // @link substring="VkFormat" target="VkFormat" @link substring="depthAttachmentFormat" target="#depthAttachmentFormat"
///     VkFormat stencilAttachmentFormat; // @link substring="VkFormat" target="VkFormat" @link substring="stencilAttachmentFormat" target="#stencilAttachmentFormat"
/// } VkPipelineRenderingCreateInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PIPELINE_RENDERING_CREATE_INFO`
///
/// The {@code allocate} ({@link VkPipelineRenderingCreateInfo#allocate(Arena)}, {@link VkPipelineRenderingCreateInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPipelineRenderingCreateInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineRenderingCreateInfo.html"><code>VkPipelineRenderingCreateInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPipelineRenderingCreateInfo(@NotNull MemorySegment segment) implements IVkPipelineRenderingCreateInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineRenderingCreateInfo.html"><code>VkPipelineRenderingCreateInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPipelineRenderingCreateInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPipelineRenderingCreateInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPipelineRenderingCreateInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPipelineRenderingCreateInfo, Iterable<VkPipelineRenderingCreateInfo> {
        public long size() {
            return segment.byteSize() / VkPipelineRenderingCreateInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPipelineRenderingCreateInfo at(long index) {
            return new VkPipelineRenderingCreateInfo(segment.asSlice(index * VkPipelineRenderingCreateInfo.BYTES, VkPipelineRenderingCreateInfo.BYTES));
        }

        public VkPipelineRenderingCreateInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkPipelineRenderingCreateInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPipelineRenderingCreateInfo value) {
            MemorySegment s = segment.asSlice(index * VkPipelineRenderingCreateInfo.BYTES, VkPipelineRenderingCreateInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPipelineRenderingCreateInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPipelineRenderingCreateInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPipelineRenderingCreateInfo.BYTES,
                (end - start) * VkPipelineRenderingCreateInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPipelineRenderingCreateInfo.BYTES));
        }

        public VkPipelineRenderingCreateInfo[] toArray() {
            VkPipelineRenderingCreateInfo[] ret = new VkPipelineRenderingCreateInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPipelineRenderingCreateInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPipelineRenderingCreateInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPipelineRenderingCreateInfo.BYTES;
            }

            @Override
            public VkPipelineRenderingCreateInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPipelineRenderingCreateInfo ret = new VkPipelineRenderingCreateInfo(segment.asSlice(0, VkPipelineRenderingCreateInfo.BYTES));
                segment = segment.asSlice(VkPipelineRenderingCreateInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPipelineRenderingCreateInfo allocate(Arena arena) {
        VkPipelineRenderingCreateInfo ret = new VkPipelineRenderingCreateInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PIPELINE_RENDERING_CREATE_INFO);
        return ret;
    }

    public static VkPipelineRenderingCreateInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPipelineRenderingCreateInfo.Ptr ret = new VkPipelineRenderingCreateInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PIPELINE_RENDERING_CREATE_INFO);
        }
        return ret;
    }

    public static VkPipelineRenderingCreateInfo clone(Arena arena, VkPipelineRenderingCreateInfo src) {
        VkPipelineRenderingCreateInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PIPELINE_RENDERING_CREATE_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPipelineRenderingCreateInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPipelineRenderingCreateInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPipelineRenderingCreateInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int viewMask() {
        return segment.get(LAYOUT$viewMask, OFFSET$viewMask);
    }

    public VkPipelineRenderingCreateInfo viewMask(@Unsigned int value) {
        segment.set(LAYOUT$viewMask, OFFSET$viewMask, value);
        return this;
    }

    public @Unsigned int colorAttachmentCount() {
        return segment.get(LAYOUT$colorAttachmentCount, OFFSET$colorAttachmentCount);
    }

    public VkPipelineRenderingCreateInfo colorAttachmentCount(@Unsigned int value) {
        segment.set(LAYOUT$colorAttachmentCount, OFFSET$colorAttachmentCount, value);
        return this;
    }


    /// Note: the returned {@link IntPtr} does not have correct
    /// {@link IntPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link IntPtr#reinterpret} to set the size before actually reading fro
    /// or writing to the buffer.
    public @Nullable @EnumType(VkFormat.class) IntPtr pColorAttachmentFormats() {
        MemorySegment s = pColorAttachmentFormatsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new IntPtr(s);
    }

    public VkPipelineRenderingCreateInfo pColorAttachmentFormats(@Nullable @EnumType(VkFormat.class) IntPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pColorAttachmentFormatsRaw(s);
        return this;
    }

    public @Pointer(target=VkFormat.class) @NotNull MemorySegment pColorAttachmentFormatsRaw() {
        return segment.get(LAYOUT$pColorAttachmentFormats, OFFSET$pColorAttachmentFormats);
    }

    public void pColorAttachmentFormatsRaw(@Pointer(target=VkFormat.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pColorAttachmentFormats, OFFSET$pColorAttachmentFormats, value);
    }

    public @EnumType(VkFormat.class) int depthAttachmentFormat() {
        return segment.get(LAYOUT$depthAttachmentFormat, OFFSET$depthAttachmentFormat);
    }

    public VkPipelineRenderingCreateInfo depthAttachmentFormat(@EnumType(VkFormat.class) int value) {
        segment.set(LAYOUT$depthAttachmentFormat, OFFSET$depthAttachmentFormat, value);
        return this;
    }

    public @EnumType(VkFormat.class) int stencilAttachmentFormat() {
        return segment.get(LAYOUT$stencilAttachmentFormat, OFFSET$stencilAttachmentFormat);
    }

    public VkPipelineRenderingCreateInfo stencilAttachmentFormat(@EnumType(VkFormat.class) int value) {
        segment.set(LAYOUT$stencilAttachmentFormat, OFFSET$stencilAttachmentFormat, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("viewMask"),
        ValueLayout.JAVA_INT.withName("colorAttachmentCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pColorAttachmentFormats"),
        ValueLayout.JAVA_INT.withName("depthAttachmentFormat"),
        ValueLayout.JAVA_INT.withName("stencilAttachmentFormat")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$viewMask = PathElement.groupElement("viewMask");
    public static final PathElement PATH$colorAttachmentCount = PathElement.groupElement("colorAttachmentCount");
    public static final PathElement PATH$pColorAttachmentFormats = PathElement.groupElement("pColorAttachmentFormats");
    public static final PathElement PATH$depthAttachmentFormat = PathElement.groupElement("depthAttachmentFormat");
    public static final PathElement PATH$stencilAttachmentFormat = PathElement.groupElement("stencilAttachmentFormat");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$viewMask = (OfInt) LAYOUT.select(PATH$viewMask);
    public static final OfInt LAYOUT$colorAttachmentCount = (OfInt) LAYOUT.select(PATH$colorAttachmentCount);
    public static final AddressLayout LAYOUT$pColorAttachmentFormats = (AddressLayout) LAYOUT.select(PATH$pColorAttachmentFormats);
    public static final OfInt LAYOUT$depthAttachmentFormat = (OfInt) LAYOUT.select(PATH$depthAttachmentFormat);
    public static final OfInt LAYOUT$stencilAttachmentFormat = (OfInt) LAYOUT.select(PATH$stencilAttachmentFormat);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$viewMask = LAYOUT$viewMask.byteSize();
    public static final long SIZE$colorAttachmentCount = LAYOUT$colorAttachmentCount.byteSize();
    public static final long SIZE$pColorAttachmentFormats = LAYOUT$pColorAttachmentFormats.byteSize();
    public static final long SIZE$depthAttachmentFormat = LAYOUT$depthAttachmentFormat.byteSize();
    public static final long SIZE$stencilAttachmentFormat = LAYOUT$stencilAttachmentFormat.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$viewMask = LAYOUT.byteOffset(PATH$viewMask);
    public static final long OFFSET$colorAttachmentCount = LAYOUT.byteOffset(PATH$colorAttachmentCount);
    public static final long OFFSET$pColorAttachmentFormats = LAYOUT.byteOffset(PATH$pColorAttachmentFormats);
    public static final long OFFSET$depthAttachmentFormat = LAYOUT.byteOffset(PATH$depthAttachmentFormat);
    public static final long OFFSET$stencilAttachmentFormat = LAYOUT.byteOffset(PATH$stencilAttachmentFormat);
}
