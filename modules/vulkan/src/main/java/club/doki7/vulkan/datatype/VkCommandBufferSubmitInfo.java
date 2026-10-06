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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCommandBufferSubmitInfo.html"><code>VkCommandBufferSubmitInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkCommandBufferSubmitInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkCommandBuffer commandBuffer; // @link substring="VkCommandBuffer" target="VkCommandBuffer" @link substring="commandBuffer" target="#commandBuffer"
///     uint32_t deviceMask; // @link substring="deviceMask" target="#deviceMask"
/// } VkCommandBufferSubmitInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_COMMAND_BUFFER_SUBMIT_INFO`
///
/// The {@code allocate} ({@link VkCommandBufferSubmitInfo#allocate(Arena)}, {@link VkCommandBufferSubmitInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkCommandBufferSubmitInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCommandBufferSubmitInfo.html"><code>VkCommandBufferSubmitInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkCommandBufferSubmitInfo(@NotNull MemorySegment segment) implements IVkCommandBufferSubmitInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCommandBufferSubmitInfo.html"><code>VkCommandBufferSubmitInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkCommandBufferSubmitInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkCommandBufferSubmitInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkCommandBufferSubmitInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkCommandBufferSubmitInfo, Iterable<VkCommandBufferSubmitInfo> {
        public long size() {
            return segment.byteSize() / VkCommandBufferSubmitInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkCommandBufferSubmitInfo at(long index) {
            return new VkCommandBufferSubmitInfo(segment.asSlice(index * VkCommandBufferSubmitInfo.BYTES, VkCommandBufferSubmitInfo.BYTES));
        }

        public VkCommandBufferSubmitInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkCommandBufferSubmitInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkCommandBufferSubmitInfo value) {
            MemorySegment s = segment.asSlice(index * VkCommandBufferSubmitInfo.BYTES, VkCommandBufferSubmitInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkCommandBufferSubmitInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkCommandBufferSubmitInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkCommandBufferSubmitInfo.BYTES,
                (end - start) * VkCommandBufferSubmitInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkCommandBufferSubmitInfo.BYTES));
        }

        public VkCommandBufferSubmitInfo[] toArray() {
            VkCommandBufferSubmitInfo[] ret = new VkCommandBufferSubmitInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkCommandBufferSubmitInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkCommandBufferSubmitInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkCommandBufferSubmitInfo.BYTES;
            }

            @Override
            public VkCommandBufferSubmitInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkCommandBufferSubmitInfo ret = new VkCommandBufferSubmitInfo(segment.asSlice(0, VkCommandBufferSubmitInfo.BYTES));
                segment = segment.asSlice(VkCommandBufferSubmitInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkCommandBufferSubmitInfo allocate(Arena arena) {
        VkCommandBufferSubmitInfo ret = new VkCommandBufferSubmitInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.COMMAND_BUFFER_SUBMIT_INFO);
        return ret;
    }

    public static VkCommandBufferSubmitInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkCommandBufferSubmitInfo.Ptr ret = new VkCommandBufferSubmitInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.COMMAND_BUFFER_SUBMIT_INFO);
        }
        return ret;
    }

    public static VkCommandBufferSubmitInfo clone(Arena arena, VkCommandBufferSubmitInfo src) {
        VkCommandBufferSubmitInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.COMMAND_BUFFER_SUBMIT_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkCommandBufferSubmitInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkCommandBufferSubmitInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkCommandBufferSubmitInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Nullable VkCommandBuffer commandBuffer() {
        MemorySegment s = segment.asSlice(OFFSET$commandBuffer, SIZE$commandBuffer);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkCommandBuffer(s);
    }

    public VkCommandBufferSubmitInfo commandBuffer(@Nullable VkCommandBuffer value) {
        segment.set(LAYOUT$commandBuffer, OFFSET$commandBuffer, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int deviceMask() {
        return segment.get(LAYOUT$deviceMask, OFFSET$deviceMask);
    }

    public VkCommandBufferSubmitInfo deviceMask(@Unsigned int value) {
        segment.set(LAYOUT$deviceMask, OFFSET$deviceMask, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withName("commandBuffer"),
        ValueLayout.JAVA_INT.withName("deviceMask")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$commandBuffer = PathElement.groupElement("commandBuffer");
    public static final PathElement PATH$deviceMask = PathElement.groupElement("deviceMask");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$commandBuffer = (AddressLayout) LAYOUT.select(PATH$commandBuffer);
    public static final OfInt LAYOUT$deviceMask = (OfInt) LAYOUT.select(PATH$deviceMask);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$commandBuffer = LAYOUT$commandBuffer.byteSize();
    public static final long SIZE$deviceMask = LAYOUT$deviceMask.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$commandBuffer = LAYOUT.byteOffset(PATH$commandBuffer);
    public static final long OFFSET$deviceMask = LAYOUT.byteOffset(PATH$deviceMask);
}
