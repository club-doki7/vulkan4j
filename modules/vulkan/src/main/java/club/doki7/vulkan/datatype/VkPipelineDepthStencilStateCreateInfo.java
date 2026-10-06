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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineDepthStencilStateCreateInfo.html"><code>VkPipelineDepthStencilStateCreateInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPipelineDepthStencilStateCreateInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkPipelineDepthStencilStateCreateFlags flags; // optional // @link substring="VkPipelineDepthStencilStateCreateFlags" target="VkPipelineDepthStencilStateCreateFlags" @link substring="flags" target="#flags"
///     VkBool32 depthTestEnable; // @link substring="depthTestEnable" target="#depthTestEnable"
///     VkBool32 depthWriteEnable; // @link substring="depthWriteEnable" target="#depthWriteEnable"
///     VkCompareOp depthCompareOp; // @link substring="VkCompareOp" target="VkCompareOp" @link substring="depthCompareOp" target="#depthCompareOp"
///     VkBool32 depthBoundsTestEnable; // @link substring="depthBoundsTestEnable" target="#depthBoundsTestEnable"
///     VkBool32 stencilTestEnable; // @link substring="stencilTestEnable" target="#stencilTestEnable"
///     VkStencilOpState front; // @link substring="VkStencilOpState" target="VkStencilOpState" @link substring="front" target="#front"
///     VkStencilOpState back; // @link substring="VkStencilOpState" target="VkStencilOpState" @link substring="back" target="#back"
///     float minDepthBounds; // @link substring="minDepthBounds" target="#minDepthBounds"
///     float maxDepthBounds; // @link substring="maxDepthBounds" target="#maxDepthBounds"
/// } VkPipelineDepthStencilStateCreateInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PIPELINE_DEPTH_STENCIL_STATE_CREATE_INFO`
///
/// The {@code allocate} ({@link VkPipelineDepthStencilStateCreateInfo#allocate(Arena)}, {@link VkPipelineDepthStencilStateCreateInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPipelineDepthStencilStateCreateInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineDepthStencilStateCreateInfo.html"><code>VkPipelineDepthStencilStateCreateInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPipelineDepthStencilStateCreateInfo(@NotNull MemorySegment segment) implements IVkPipelineDepthStencilStateCreateInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineDepthStencilStateCreateInfo.html"><code>VkPipelineDepthStencilStateCreateInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPipelineDepthStencilStateCreateInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPipelineDepthStencilStateCreateInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPipelineDepthStencilStateCreateInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPipelineDepthStencilStateCreateInfo, Iterable<VkPipelineDepthStencilStateCreateInfo> {
        public long size() {
            return segment.byteSize() / VkPipelineDepthStencilStateCreateInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPipelineDepthStencilStateCreateInfo at(long index) {
            return new VkPipelineDepthStencilStateCreateInfo(segment.asSlice(index * VkPipelineDepthStencilStateCreateInfo.BYTES, VkPipelineDepthStencilStateCreateInfo.BYTES));
        }

        public VkPipelineDepthStencilStateCreateInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkPipelineDepthStencilStateCreateInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPipelineDepthStencilStateCreateInfo value) {
            MemorySegment s = segment.asSlice(index * VkPipelineDepthStencilStateCreateInfo.BYTES, VkPipelineDepthStencilStateCreateInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPipelineDepthStencilStateCreateInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPipelineDepthStencilStateCreateInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPipelineDepthStencilStateCreateInfo.BYTES,
                (end - start) * VkPipelineDepthStencilStateCreateInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPipelineDepthStencilStateCreateInfo.BYTES));
        }

        public VkPipelineDepthStencilStateCreateInfo[] toArray() {
            VkPipelineDepthStencilStateCreateInfo[] ret = new VkPipelineDepthStencilStateCreateInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPipelineDepthStencilStateCreateInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPipelineDepthStencilStateCreateInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPipelineDepthStencilStateCreateInfo.BYTES;
            }

            @Override
            public VkPipelineDepthStencilStateCreateInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPipelineDepthStencilStateCreateInfo ret = new VkPipelineDepthStencilStateCreateInfo(segment.asSlice(0, VkPipelineDepthStencilStateCreateInfo.BYTES));
                segment = segment.asSlice(VkPipelineDepthStencilStateCreateInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPipelineDepthStencilStateCreateInfo allocate(Arena arena) {
        VkPipelineDepthStencilStateCreateInfo ret = new VkPipelineDepthStencilStateCreateInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PIPELINE_DEPTH_STENCIL_STATE_CREATE_INFO);
        return ret;
    }

    public static VkPipelineDepthStencilStateCreateInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPipelineDepthStencilStateCreateInfo.Ptr ret = new VkPipelineDepthStencilStateCreateInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PIPELINE_DEPTH_STENCIL_STATE_CREATE_INFO);
        }
        return ret;
    }

    public static VkPipelineDepthStencilStateCreateInfo clone(Arena arena, VkPipelineDepthStencilStateCreateInfo src) {
        VkPipelineDepthStencilStateCreateInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PIPELINE_DEPTH_STENCIL_STATE_CREATE_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPipelineDepthStencilStateCreateInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPipelineDepthStencilStateCreateInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPipelineDepthStencilStateCreateInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkPipelineDepthStencilStateCreateFlags.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkPipelineDepthStencilStateCreateInfo flags(@Bitmask(VkPipelineDepthStencilStateCreateFlags.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int depthTestEnable() {
        return segment.get(LAYOUT$depthTestEnable, OFFSET$depthTestEnable);
    }

    public VkPipelineDepthStencilStateCreateInfo depthTestEnable(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$depthTestEnable, OFFSET$depthTestEnable, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int depthWriteEnable() {
        return segment.get(LAYOUT$depthWriteEnable, OFFSET$depthWriteEnable);
    }

    public VkPipelineDepthStencilStateCreateInfo depthWriteEnable(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$depthWriteEnable, OFFSET$depthWriteEnable, value);
        return this;
    }

    public @EnumType(VkCompareOp.class) int depthCompareOp() {
        return segment.get(LAYOUT$depthCompareOp, OFFSET$depthCompareOp);
    }

    public VkPipelineDepthStencilStateCreateInfo depthCompareOp(@EnumType(VkCompareOp.class) int value) {
        segment.set(LAYOUT$depthCompareOp, OFFSET$depthCompareOp, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int depthBoundsTestEnable() {
        return segment.get(LAYOUT$depthBoundsTestEnable, OFFSET$depthBoundsTestEnable);
    }

    public VkPipelineDepthStencilStateCreateInfo depthBoundsTestEnable(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$depthBoundsTestEnable, OFFSET$depthBoundsTestEnable, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int stencilTestEnable() {
        return segment.get(LAYOUT$stencilTestEnable, OFFSET$stencilTestEnable);
    }

    public VkPipelineDepthStencilStateCreateInfo stencilTestEnable(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$stencilTestEnable, OFFSET$stencilTestEnable, value);
        return this;
    }

    public @NotNull VkStencilOpState front() {
        return new VkStencilOpState(segment.asSlice(OFFSET$front, LAYOUT$front));
    }

    public VkPipelineDepthStencilStateCreateInfo front(@NotNull VkStencilOpState value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$front, SIZE$front);
        return this;
    }

    public VkPipelineDepthStencilStateCreateInfo front(Consumer<@NotNull VkStencilOpState> consumer) {
        consumer.accept(front());
        return this;
    }

    public @NotNull VkStencilOpState back() {
        return new VkStencilOpState(segment.asSlice(OFFSET$back, LAYOUT$back));
    }

    public VkPipelineDepthStencilStateCreateInfo back(@NotNull VkStencilOpState value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$back, SIZE$back);
        return this;
    }

    public VkPipelineDepthStencilStateCreateInfo back(Consumer<@NotNull VkStencilOpState> consumer) {
        consumer.accept(back());
        return this;
    }

    public float minDepthBounds() {
        return segment.get(LAYOUT$minDepthBounds, OFFSET$minDepthBounds);
    }

    public VkPipelineDepthStencilStateCreateInfo minDepthBounds(float value) {
        segment.set(LAYOUT$minDepthBounds, OFFSET$minDepthBounds, value);
        return this;
    }

    public float maxDepthBounds() {
        return segment.get(LAYOUT$maxDepthBounds, OFFSET$maxDepthBounds);
    }

    public VkPipelineDepthStencilStateCreateInfo maxDepthBounds(float value) {
        segment.set(LAYOUT$maxDepthBounds, OFFSET$maxDepthBounds, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("depthTestEnable"),
        ValueLayout.JAVA_INT.withName("depthWriteEnable"),
        ValueLayout.JAVA_INT.withName("depthCompareOp"),
        ValueLayout.JAVA_INT.withName("depthBoundsTestEnable"),
        ValueLayout.JAVA_INT.withName("stencilTestEnable"),
        VkStencilOpState.LAYOUT.withName("front"),
        VkStencilOpState.LAYOUT.withName("back"),
        ValueLayout.JAVA_FLOAT.withName("minDepthBounds"),
        ValueLayout.JAVA_FLOAT.withName("maxDepthBounds")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$depthTestEnable = PathElement.groupElement("depthTestEnable");
    public static final PathElement PATH$depthWriteEnable = PathElement.groupElement("depthWriteEnable");
    public static final PathElement PATH$depthCompareOp = PathElement.groupElement("depthCompareOp");
    public static final PathElement PATH$depthBoundsTestEnable = PathElement.groupElement("depthBoundsTestEnable");
    public static final PathElement PATH$stencilTestEnable = PathElement.groupElement("stencilTestEnable");
    public static final PathElement PATH$front = PathElement.groupElement("front");
    public static final PathElement PATH$back = PathElement.groupElement("back");
    public static final PathElement PATH$minDepthBounds = PathElement.groupElement("minDepthBounds");
    public static final PathElement PATH$maxDepthBounds = PathElement.groupElement("maxDepthBounds");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$depthTestEnable = (OfInt) LAYOUT.select(PATH$depthTestEnable);
    public static final OfInt LAYOUT$depthWriteEnable = (OfInt) LAYOUT.select(PATH$depthWriteEnable);
    public static final OfInt LAYOUT$depthCompareOp = (OfInt) LAYOUT.select(PATH$depthCompareOp);
    public static final OfInt LAYOUT$depthBoundsTestEnable = (OfInt) LAYOUT.select(PATH$depthBoundsTestEnable);
    public static final OfInt LAYOUT$stencilTestEnable = (OfInt) LAYOUT.select(PATH$stencilTestEnable);
    public static final StructLayout LAYOUT$front = (StructLayout) LAYOUT.select(PATH$front);
    public static final StructLayout LAYOUT$back = (StructLayout) LAYOUT.select(PATH$back);
    public static final OfFloat LAYOUT$minDepthBounds = (OfFloat) LAYOUT.select(PATH$minDepthBounds);
    public static final OfFloat LAYOUT$maxDepthBounds = (OfFloat) LAYOUT.select(PATH$maxDepthBounds);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$depthTestEnable = LAYOUT$depthTestEnable.byteSize();
    public static final long SIZE$depthWriteEnable = LAYOUT$depthWriteEnable.byteSize();
    public static final long SIZE$depthCompareOp = LAYOUT$depthCompareOp.byteSize();
    public static final long SIZE$depthBoundsTestEnable = LAYOUT$depthBoundsTestEnable.byteSize();
    public static final long SIZE$stencilTestEnable = LAYOUT$stencilTestEnable.byteSize();
    public static final long SIZE$front = LAYOUT$front.byteSize();
    public static final long SIZE$back = LAYOUT$back.byteSize();
    public static final long SIZE$minDepthBounds = LAYOUT$minDepthBounds.byteSize();
    public static final long SIZE$maxDepthBounds = LAYOUT$maxDepthBounds.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$depthTestEnable = LAYOUT.byteOffset(PATH$depthTestEnable);
    public static final long OFFSET$depthWriteEnable = LAYOUT.byteOffset(PATH$depthWriteEnable);
    public static final long OFFSET$depthCompareOp = LAYOUT.byteOffset(PATH$depthCompareOp);
    public static final long OFFSET$depthBoundsTestEnable = LAYOUT.byteOffset(PATH$depthBoundsTestEnable);
    public static final long OFFSET$stencilTestEnable = LAYOUT.byteOffset(PATH$stencilTestEnable);
    public static final long OFFSET$front = LAYOUT.byteOffset(PATH$front);
    public static final long OFFSET$back = LAYOUT.byteOffset(PATH$back);
    public static final long OFFSET$minDepthBounds = LAYOUT.byteOffset(PATH$minDepthBounds);
    public static final long OFFSET$maxDepthBounds = LAYOUT.byteOffset(PATH$maxDepthBounds);
}
