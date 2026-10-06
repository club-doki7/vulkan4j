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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRenderingInputAttachmentIndexInfo.html"><code>VkRenderingInputAttachmentIndexInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkRenderingInputAttachmentIndexInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t colorAttachmentCount; // optional // @link substring="colorAttachmentCount" target="#colorAttachmentCount"
///     uint32_t const* pColorAttachmentInputIndices; // optional // @link substring="pColorAttachmentInputIndices" target="#pColorAttachmentInputIndices"
///     uint32_t const* pDepthInputAttachmentIndex; // optional // @link substring="pDepthInputAttachmentIndex" target="#pDepthInputAttachmentIndex"
///     uint32_t const* pStencilInputAttachmentIndex; // optional // @link substring="pStencilInputAttachmentIndex" target="#pStencilInputAttachmentIndex"
/// } VkRenderingInputAttachmentIndexInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_RENDERING_INPUT_ATTACHMENT_INDEX_INFO`
///
/// The {@code allocate} ({@link VkRenderingInputAttachmentIndexInfo#allocate(Arena)}, {@link VkRenderingInputAttachmentIndexInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkRenderingInputAttachmentIndexInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRenderingInputAttachmentIndexInfo.html"><code>VkRenderingInputAttachmentIndexInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkRenderingInputAttachmentIndexInfo(@NotNull MemorySegment segment) implements IVkRenderingInputAttachmentIndexInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRenderingInputAttachmentIndexInfo.html"><code>VkRenderingInputAttachmentIndexInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkRenderingInputAttachmentIndexInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkRenderingInputAttachmentIndexInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkRenderingInputAttachmentIndexInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkRenderingInputAttachmentIndexInfo, Iterable<VkRenderingInputAttachmentIndexInfo> {
        public long size() {
            return segment.byteSize() / VkRenderingInputAttachmentIndexInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkRenderingInputAttachmentIndexInfo at(long index) {
            return new VkRenderingInputAttachmentIndexInfo(segment.asSlice(index * VkRenderingInputAttachmentIndexInfo.BYTES, VkRenderingInputAttachmentIndexInfo.BYTES));
        }

        public VkRenderingInputAttachmentIndexInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkRenderingInputAttachmentIndexInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkRenderingInputAttachmentIndexInfo value) {
            MemorySegment s = segment.asSlice(index * VkRenderingInputAttachmentIndexInfo.BYTES, VkRenderingInputAttachmentIndexInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkRenderingInputAttachmentIndexInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkRenderingInputAttachmentIndexInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkRenderingInputAttachmentIndexInfo.BYTES,
                (end - start) * VkRenderingInputAttachmentIndexInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkRenderingInputAttachmentIndexInfo.BYTES));
        }

        public VkRenderingInputAttachmentIndexInfo[] toArray() {
            VkRenderingInputAttachmentIndexInfo[] ret = new VkRenderingInputAttachmentIndexInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkRenderingInputAttachmentIndexInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkRenderingInputAttachmentIndexInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkRenderingInputAttachmentIndexInfo.BYTES;
            }

            @Override
            public VkRenderingInputAttachmentIndexInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkRenderingInputAttachmentIndexInfo ret = new VkRenderingInputAttachmentIndexInfo(segment.asSlice(0, VkRenderingInputAttachmentIndexInfo.BYTES));
                segment = segment.asSlice(VkRenderingInputAttachmentIndexInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkRenderingInputAttachmentIndexInfo allocate(Arena arena) {
        VkRenderingInputAttachmentIndexInfo ret = new VkRenderingInputAttachmentIndexInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.RENDERING_INPUT_ATTACHMENT_INDEX_INFO);
        return ret;
    }

    public static VkRenderingInputAttachmentIndexInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkRenderingInputAttachmentIndexInfo.Ptr ret = new VkRenderingInputAttachmentIndexInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.RENDERING_INPUT_ATTACHMENT_INDEX_INFO);
        }
        return ret;
    }

    public static VkRenderingInputAttachmentIndexInfo clone(Arena arena, VkRenderingInputAttachmentIndexInfo src) {
        VkRenderingInputAttachmentIndexInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.RENDERING_INPUT_ATTACHMENT_INDEX_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkRenderingInputAttachmentIndexInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkRenderingInputAttachmentIndexInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkRenderingInputAttachmentIndexInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int colorAttachmentCount() {
        return segment.get(LAYOUT$colorAttachmentCount, OFFSET$colorAttachmentCount);
    }

    public VkRenderingInputAttachmentIndexInfo colorAttachmentCount(@Unsigned int value) {
        segment.set(LAYOUT$colorAttachmentCount, OFFSET$colorAttachmentCount, value);
        return this;
    }

    /// Note: the returned {@link IntPtr} does not have correct
    /// {@link IntPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link IntPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable @Unsigned IntPtr pColorAttachmentInputIndices() {
        MemorySegment s = pColorAttachmentInputIndicesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new IntPtr(s);
    }

    public VkRenderingInputAttachmentIndexInfo pColorAttachmentInputIndices(@Nullable @Unsigned IntPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pColorAttachmentInputIndicesRaw(s);
        return this;
    }

    public @Pointer(comment="uint32_t*") @NotNull MemorySegment pColorAttachmentInputIndicesRaw() {
        return segment.get(LAYOUT$pColorAttachmentInputIndices, OFFSET$pColorAttachmentInputIndices);
    }

    public void pColorAttachmentInputIndicesRaw(@Pointer(comment="uint32_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pColorAttachmentInputIndices, OFFSET$pColorAttachmentInputIndices, value);
    }

    /// Note: the returned {@link IntPtr} does not have correct
    /// {@link IntPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link IntPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable @Unsigned IntPtr pDepthInputAttachmentIndex() {
        MemorySegment s = pDepthInputAttachmentIndexRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new IntPtr(s);
    }

    public VkRenderingInputAttachmentIndexInfo pDepthInputAttachmentIndex(@Nullable @Unsigned IntPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pDepthInputAttachmentIndexRaw(s);
        return this;
    }

    public @Pointer(comment="uint32_t*") @NotNull MemorySegment pDepthInputAttachmentIndexRaw() {
        return segment.get(LAYOUT$pDepthInputAttachmentIndex, OFFSET$pDepthInputAttachmentIndex);
    }

    public void pDepthInputAttachmentIndexRaw(@Pointer(comment="uint32_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pDepthInputAttachmentIndex, OFFSET$pDepthInputAttachmentIndex, value);
    }

    /// Note: the returned {@link IntPtr} does not have correct
    /// {@link IntPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link IntPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable @Unsigned IntPtr pStencilInputAttachmentIndex() {
        MemorySegment s = pStencilInputAttachmentIndexRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new IntPtr(s);
    }

    public VkRenderingInputAttachmentIndexInfo pStencilInputAttachmentIndex(@Nullable @Unsigned IntPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pStencilInputAttachmentIndexRaw(s);
        return this;
    }

    public @Pointer(comment="uint32_t*") @NotNull MemorySegment pStencilInputAttachmentIndexRaw() {
        return segment.get(LAYOUT$pStencilInputAttachmentIndex, OFFSET$pStencilInputAttachmentIndex);
    }

    public void pStencilInputAttachmentIndexRaw(@Pointer(comment="uint32_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pStencilInputAttachmentIndex, OFFSET$pStencilInputAttachmentIndex, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("colorAttachmentCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pColorAttachmentInputIndices"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pDepthInputAttachmentIndex"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pStencilInputAttachmentIndex")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$colorAttachmentCount = PathElement.groupElement("colorAttachmentCount");
    public static final PathElement PATH$pColorAttachmentInputIndices = PathElement.groupElement("pColorAttachmentInputIndices");
    public static final PathElement PATH$pDepthInputAttachmentIndex = PathElement.groupElement("pDepthInputAttachmentIndex");
    public static final PathElement PATH$pStencilInputAttachmentIndex = PathElement.groupElement("pStencilInputAttachmentIndex");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$colorAttachmentCount = (OfInt) LAYOUT.select(PATH$colorAttachmentCount);
    public static final AddressLayout LAYOUT$pColorAttachmentInputIndices = (AddressLayout) LAYOUT.select(PATH$pColorAttachmentInputIndices);
    public static final AddressLayout LAYOUT$pDepthInputAttachmentIndex = (AddressLayout) LAYOUT.select(PATH$pDepthInputAttachmentIndex);
    public static final AddressLayout LAYOUT$pStencilInputAttachmentIndex = (AddressLayout) LAYOUT.select(PATH$pStencilInputAttachmentIndex);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$colorAttachmentCount = LAYOUT$colorAttachmentCount.byteSize();
    public static final long SIZE$pColorAttachmentInputIndices = LAYOUT$pColorAttachmentInputIndices.byteSize();
    public static final long SIZE$pDepthInputAttachmentIndex = LAYOUT$pDepthInputAttachmentIndex.byteSize();
    public static final long SIZE$pStencilInputAttachmentIndex = LAYOUT$pStencilInputAttachmentIndex.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$colorAttachmentCount = LAYOUT.byteOffset(PATH$colorAttachmentCount);
    public static final long OFFSET$pColorAttachmentInputIndices = LAYOUT.byteOffset(PATH$pColorAttachmentInputIndices);
    public static final long OFFSET$pDepthInputAttachmentIndex = LAYOUT.byteOffset(PATH$pDepthInputAttachmentIndex);
    public static final long OFFSET$pStencilInputAttachmentIndex = LAYOUT.byteOffset(PATH$pStencilInputAttachmentIndex);
}
