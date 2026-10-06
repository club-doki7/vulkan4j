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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRenderPassBeginInfo.html"><code>VkRenderPassBeginInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkRenderPassBeginInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkRenderPass renderPass; // @link substring="VkRenderPass" target="VkRenderPass" @link substring="renderPass" target="#renderPass"
///     VkFramebuffer framebuffer; // @link substring="VkFramebuffer" target="VkFramebuffer" @link substring="framebuffer" target="#framebuffer"
///     VkRect2D renderArea; // @link substring="VkRect2D" target="VkRect2D" @link substring="renderArea" target="#renderArea"
///     uint32_t clearValueCount; // optional // @link substring="clearValueCount" target="#clearValueCount"
///     VkClearValue const* pClearValues; // optional // @link substring="VkClearValue" target="VkClearValue" @link substring="pClearValues" target="#pClearValues"
/// } VkRenderPassBeginInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_RENDER_PASS_BEGIN_INFO`
///
/// The {@code allocate} ({@link VkRenderPassBeginInfo#allocate(Arena)}, {@link VkRenderPassBeginInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkRenderPassBeginInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRenderPassBeginInfo.html"><code>VkRenderPassBeginInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkRenderPassBeginInfo(@NotNull MemorySegment segment) implements IVkRenderPassBeginInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRenderPassBeginInfo.html"><code>VkRenderPassBeginInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkRenderPassBeginInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkRenderPassBeginInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkRenderPassBeginInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkRenderPassBeginInfo, Iterable<VkRenderPassBeginInfo> {
        public long size() {
            return segment.byteSize() / VkRenderPassBeginInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkRenderPassBeginInfo at(long index) {
            return new VkRenderPassBeginInfo(segment.asSlice(index * VkRenderPassBeginInfo.BYTES, VkRenderPassBeginInfo.BYTES));
        }

        public VkRenderPassBeginInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkRenderPassBeginInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkRenderPassBeginInfo value) {
            MemorySegment s = segment.asSlice(index * VkRenderPassBeginInfo.BYTES, VkRenderPassBeginInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkRenderPassBeginInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkRenderPassBeginInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkRenderPassBeginInfo.BYTES,
                (end - start) * VkRenderPassBeginInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkRenderPassBeginInfo.BYTES));
        }

        public VkRenderPassBeginInfo[] toArray() {
            VkRenderPassBeginInfo[] ret = new VkRenderPassBeginInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkRenderPassBeginInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkRenderPassBeginInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkRenderPassBeginInfo.BYTES;
            }

            @Override
            public VkRenderPassBeginInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkRenderPassBeginInfo ret = new VkRenderPassBeginInfo(segment.asSlice(0, VkRenderPassBeginInfo.BYTES));
                segment = segment.asSlice(VkRenderPassBeginInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkRenderPassBeginInfo allocate(Arena arena) {
        VkRenderPassBeginInfo ret = new VkRenderPassBeginInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.RENDER_PASS_BEGIN_INFO);
        return ret;
    }

    public static VkRenderPassBeginInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkRenderPassBeginInfo.Ptr ret = new VkRenderPassBeginInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.RENDER_PASS_BEGIN_INFO);
        }
        return ret;
    }

    public static VkRenderPassBeginInfo clone(Arena arena, VkRenderPassBeginInfo src) {
        VkRenderPassBeginInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.RENDER_PASS_BEGIN_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkRenderPassBeginInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkRenderPassBeginInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkRenderPassBeginInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Nullable VkRenderPass renderPass() {
        MemorySegment s = segment.asSlice(OFFSET$renderPass, SIZE$renderPass);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkRenderPass(s);
    }

    public VkRenderPassBeginInfo renderPass(@Nullable VkRenderPass value) {
        segment.set(LAYOUT$renderPass, OFFSET$renderPass, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Nullable VkFramebuffer framebuffer() {
        MemorySegment s = segment.asSlice(OFFSET$framebuffer, SIZE$framebuffer);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkFramebuffer(s);
    }

    public VkRenderPassBeginInfo framebuffer(@Nullable VkFramebuffer value) {
        segment.set(LAYOUT$framebuffer, OFFSET$framebuffer, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @NotNull VkRect2D renderArea() {
        return new VkRect2D(segment.asSlice(OFFSET$renderArea, LAYOUT$renderArea));
    }

    public VkRenderPassBeginInfo renderArea(@NotNull VkRect2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$renderArea, SIZE$renderArea);
        return this;
    }

    public VkRenderPassBeginInfo renderArea(Consumer<@NotNull VkRect2D> consumer) {
        consumer.accept(renderArea());
        return this;
    }

    public @Unsigned int clearValueCount() {
        return segment.get(LAYOUT$clearValueCount, OFFSET$clearValueCount);
    }

    public VkRenderPassBeginInfo clearValueCount(@Unsigned int value) {
        segment.set(LAYOUT$clearValueCount, OFFSET$clearValueCount, value);
        return this;
    }

    public VkRenderPassBeginInfo pClearValues(@Nullable IVkClearValue value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pClearValuesRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkClearValue.Ptr pClearValues(int assumedCount) {
        MemorySegment s = pClearValuesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkClearValue.BYTES);
        return new VkClearValue.Ptr(s);
    }

    public @Nullable VkClearValue pClearValues() {
        MemorySegment s = pClearValuesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkClearValue(s);
    }

    public @Pointer(target=VkClearValue.class) @NotNull MemorySegment pClearValuesRaw() {
        return segment.get(LAYOUT$pClearValues, OFFSET$pClearValues);
    }

    public void pClearValuesRaw(@Pointer(target=VkClearValue.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pClearValues, OFFSET$pClearValues, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withName("renderPass"),
        ValueLayout.ADDRESS.withName("framebuffer"),
        VkRect2D.LAYOUT.withName("renderArea"),
        ValueLayout.JAVA_INT.withName("clearValueCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkClearValue.LAYOUT).withName("pClearValues")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$renderPass = PathElement.groupElement("renderPass");
    public static final PathElement PATH$framebuffer = PathElement.groupElement("framebuffer");
    public static final PathElement PATH$renderArea = PathElement.groupElement("renderArea");
    public static final PathElement PATH$clearValueCount = PathElement.groupElement("clearValueCount");
    public static final PathElement PATH$pClearValues = PathElement.groupElement("pClearValues");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$renderPass = (AddressLayout) LAYOUT.select(PATH$renderPass);
    public static final AddressLayout LAYOUT$framebuffer = (AddressLayout) LAYOUT.select(PATH$framebuffer);
    public static final StructLayout LAYOUT$renderArea = (StructLayout) LAYOUT.select(PATH$renderArea);
    public static final OfInt LAYOUT$clearValueCount = (OfInt) LAYOUT.select(PATH$clearValueCount);
    public static final AddressLayout LAYOUT$pClearValues = (AddressLayout) LAYOUT.select(PATH$pClearValues);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$renderPass = LAYOUT$renderPass.byteSize();
    public static final long SIZE$framebuffer = LAYOUT$framebuffer.byteSize();
    public static final long SIZE$renderArea = LAYOUT$renderArea.byteSize();
    public static final long SIZE$clearValueCount = LAYOUT$clearValueCount.byteSize();
    public static final long SIZE$pClearValues = LAYOUT$pClearValues.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$renderPass = LAYOUT.byteOffset(PATH$renderPass);
    public static final long OFFSET$framebuffer = LAYOUT.byteOffset(PATH$framebuffer);
    public static final long OFFSET$renderArea = LAYOUT.byteOffset(PATH$renderArea);
    public static final long OFFSET$clearValueCount = LAYOUT.byteOffset(PATH$clearValueCount);
    public static final long OFFSET$pClearValues = LAYOUT.byteOffset(PATH$pClearValues);
}
