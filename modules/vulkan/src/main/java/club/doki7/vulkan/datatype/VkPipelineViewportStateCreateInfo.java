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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineViewportStateCreateInfo.html"><code>VkPipelineViewportStateCreateInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPipelineViewportStateCreateInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkPipelineViewportStateCreateFlags flags; // optional // @link substring="VkPipelineViewportStateCreateFlags" target="VkPipelineViewportStateCreateFlags" @link substring="flags" target="#flags"
///     uint32_t viewportCount; // optional // @link substring="viewportCount" target="#viewportCount"
///     VkViewport const* pViewports; // optional // @link substring="VkViewport" target="VkViewport" @link substring="pViewports" target="#pViewports"
///     uint32_t scissorCount; // optional // @link substring="scissorCount" target="#scissorCount"
///     VkRect2D const* pScissors; // optional // @link substring="VkRect2D" target="VkRect2D" @link substring="pScissors" target="#pScissors"
/// } VkPipelineViewportStateCreateInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PIPELINE_VIEWPORT_STATE_CREATE_INFO`
///
/// The {@code allocate} ({@link VkPipelineViewportStateCreateInfo#allocate(Arena)}, {@link VkPipelineViewportStateCreateInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPipelineViewportStateCreateInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineViewportStateCreateInfo.html"><code>VkPipelineViewportStateCreateInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPipelineViewportStateCreateInfo(@NotNull MemorySegment segment) implements IVkPipelineViewportStateCreateInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineViewportStateCreateInfo.html"><code>VkPipelineViewportStateCreateInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPipelineViewportStateCreateInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPipelineViewportStateCreateInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPipelineViewportStateCreateInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPipelineViewportStateCreateInfo, Iterable<VkPipelineViewportStateCreateInfo> {
        public long size() {
            return segment.byteSize() / VkPipelineViewportStateCreateInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPipelineViewportStateCreateInfo at(long index) {
            return new VkPipelineViewportStateCreateInfo(segment.asSlice(index * VkPipelineViewportStateCreateInfo.BYTES, VkPipelineViewportStateCreateInfo.BYTES));
        }

        public VkPipelineViewportStateCreateInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkPipelineViewportStateCreateInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPipelineViewportStateCreateInfo value) {
            MemorySegment s = segment.asSlice(index * VkPipelineViewportStateCreateInfo.BYTES, VkPipelineViewportStateCreateInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPipelineViewportStateCreateInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPipelineViewportStateCreateInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPipelineViewportStateCreateInfo.BYTES,
                (end - start) * VkPipelineViewportStateCreateInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPipelineViewportStateCreateInfo.BYTES));
        }

        public VkPipelineViewportStateCreateInfo[] toArray() {
            VkPipelineViewportStateCreateInfo[] ret = new VkPipelineViewportStateCreateInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPipelineViewportStateCreateInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPipelineViewportStateCreateInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPipelineViewportStateCreateInfo.BYTES;
            }

            @Override
            public VkPipelineViewportStateCreateInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPipelineViewportStateCreateInfo ret = new VkPipelineViewportStateCreateInfo(segment.asSlice(0, VkPipelineViewportStateCreateInfo.BYTES));
                segment = segment.asSlice(VkPipelineViewportStateCreateInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPipelineViewportStateCreateInfo allocate(Arena arena) {
        VkPipelineViewportStateCreateInfo ret = new VkPipelineViewportStateCreateInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PIPELINE_VIEWPORT_STATE_CREATE_INFO);
        return ret;
    }

    public static VkPipelineViewportStateCreateInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPipelineViewportStateCreateInfo.Ptr ret = new VkPipelineViewportStateCreateInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PIPELINE_VIEWPORT_STATE_CREATE_INFO);
        }
        return ret;
    }

    public static VkPipelineViewportStateCreateInfo clone(Arena arena, VkPipelineViewportStateCreateInfo src) {
        VkPipelineViewportStateCreateInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PIPELINE_VIEWPORT_STATE_CREATE_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPipelineViewportStateCreateInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPipelineViewportStateCreateInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPipelineViewportStateCreateInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkPipelineViewportStateCreateFlags.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkPipelineViewportStateCreateInfo flags(@Bitmask(VkPipelineViewportStateCreateFlags.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @Unsigned int viewportCount() {
        return segment.get(LAYOUT$viewportCount, OFFSET$viewportCount);
    }

    public VkPipelineViewportStateCreateInfo viewportCount(@Unsigned int value) {
        segment.set(LAYOUT$viewportCount, OFFSET$viewportCount, value);
        return this;
    }

    public VkPipelineViewportStateCreateInfo pViewports(@Nullable IVkViewport value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pViewportsRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkViewport.Ptr pViewports(int assumedCount) {
        MemorySegment s = pViewportsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkViewport.BYTES);
        return new VkViewport.Ptr(s);
    }

    public @Nullable VkViewport pViewports() {
        MemorySegment s = pViewportsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkViewport(s);
    }

    public @Pointer(target=VkViewport.class) @NotNull MemorySegment pViewportsRaw() {
        return segment.get(LAYOUT$pViewports, OFFSET$pViewports);
    }

    public void pViewportsRaw(@Pointer(target=VkViewport.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pViewports, OFFSET$pViewports, value);
    }

    public @Unsigned int scissorCount() {
        return segment.get(LAYOUT$scissorCount, OFFSET$scissorCount);
    }

    public VkPipelineViewportStateCreateInfo scissorCount(@Unsigned int value) {
        segment.set(LAYOUT$scissorCount, OFFSET$scissorCount, value);
        return this;
    }

    public VkPipelineViewportStateCreateInfo pScissors(@Nullable IVkRect2D value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pScissorsRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkRect2D.Ptr pScissors(int assumedCount) {
        MemorySegment s = pScissorsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkRect2D.BYTES);
        return new VkRect2D.Ptr(s);
    }

    public @Nullable VkRect2D pScissors() {
        MemorySegment s = pScissorsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkRect2D(s);
    }

    public @Pointer(target=VkRect2D.class) @NotNull MemorySegment pScissorsRaw() {
        return segment.get(LAYOUT$pScissors, OFFSET$pScissors);
    }

    public void pScissorsRaw(@Pointer(target=VkRect2D.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pScissors, OFFSET$pScissors, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("viewportCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkViewport.LAYOUT).withName("pViewports"),
        ValueLayout.JAVA_INT.withName("scissorCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkRect2D.LAYOUT).withName("pScissors")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$viewportCount = PathElement.groupElement("viewportCount");
    public static final PathElement PATH$pViewports = PathElement.groupElement("pViewports");
    public static final PathElement PATH$scissorCount = PathElement.groupElement("scissorCount");
    public static final PathElement PATH$pScissors = PathElement.groupElement("pScissors");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$viewportCount = (OfInt) LAYOUT.select(PATH$viewportCount);
    public static final AddressLayout LAYOUT$pViewports = (AddressLayout) LAYOUT.select(PATH$pViewports);
    public static final OfInt LAYOUT$scissorCount = (OfInt) LAYOUT.select(PATH$scissorCount);
    public static final AddressLayout LAYOUT$pScissors = (AddressLayout) LAYOUT.select(PATH$pScissors);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$viewportCount = LAYOUT$viewportCount.byteSize();
    public static final long SIZE$pViewports = LAYOUT$pViewports.byteSize();
    public static final long SIZE$scissorCount = LAYOUT$scissorCount.byteSize();
    public static final long SIZE$pScissors = LAYOUT$pScissors.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$viewportCount = LAYOUT.byteOffset(PATH$viewportCount);
    public static final long OFFSET$pViewports = LAYOUT.byteOffset(PATH$pViewports);
    public static final long OFFSET$scissorCount = LAYOUT.byteOffset(PATH$scissorCount);
    public static final long OFFSET$pScissors = LAYOUT.byteOffset(PATH$pScissors);
}
