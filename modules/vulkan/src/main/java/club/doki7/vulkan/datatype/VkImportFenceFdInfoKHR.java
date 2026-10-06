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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImportFenceFdInfoKHR.html"><code>VkImportFenceFdInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkImportFenceFdInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkFence fence; // @link substring="VkFence" target="VkFence" @link substring="fence" target="#fence"
///     VkFenceImportFlags flags; // optional // @link substring="VkFenceImportFlags" target="VkFenceImportFlags" @link substring="flags" target="#flags"
///     VkExternalFenceHandleTypeFlags handleType; // @link substring="VkExternalFenceHandleTypeFlags" target="VkExternalFenceHandleTypeFlags" @link substring="handleType" target="#handleType"
///     int fd; // @link substring="fd" target="#fd"
/// } VkImportFenceFdInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_IMPORT_FENCE_FD_INFO_KHR`
///
/// The {@code allocate} ({@link VkImportFenceFdInfoKHR#allocate(Arena)}, {@link VkImportFenceFdInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkImportFenceFdInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImportFenceFdInfoKHR.html"><code>VkImportFenceFdInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkImportFenceFdInfoKHR(@NotNull MemorySegment segment) implements IVkImportFenceFdInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImportFenceFdInfoKHR.html"><code>VkImportFenceFdInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkImportFenceFdInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkImportFenceFdInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkImportFenceFdInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkImportFenceFdInfoKHR, Iterable<VkImportFenceFdInfoKHR> {
        public long size() {
            return segment.byteSize() / VkImportFenceFdInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkImportFenceFdInfoKHR at(long index) {
            return new VkImportFenceFdInfoKHR(segment.asSlice(index * VkImportFenceFdInfoKHR.BYTES, VkImportFenceFdInfoKHR.BYTES));
        }

        public VkImportFenceFdInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkImportFenceFdInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkImportFenceFdInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkImportFenceFdInfoKHR.BYTES, VkImportFenceFdInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkImportFenceFdInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkImportFenceFdInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkImportFenceFdInfoKHR.BYTES,
                (end - start) * VkImportFenceFdInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkImportFenceFdInfoKHR.BYTES));
        }

        public VkImportFenceFdInfoKHR[] toArray() {
            VkImportFenceFdInfoKHR[] ret = new VkImportFenceFdInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkImportFenceFdInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkImportFenceFdInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkImportFenceFdInfoKHR.BYTES;
            }

            @Override
            public VkImportFenceFdInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkImportFenceFdInfoKHR ret = new VkImportFenceFdInfoKHR(segment.asSlice(0, VkImportFenceFdInfoKHR.BYTES));
                segment = segment.asSlice(VkImportFenceFdInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkImportFenceFdInfoKHR allocate(Arena arena) {
        VkImportFenceFdInfoKHR ret = new VkImportFenceFdInfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.IMPORT_FENCE_FD_INFO_KHR);
        return ret;
    }

    public static VkImportFenceFdInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkImportFenceFdInfoKHR.Ptr ret = new VkImportFenceFdInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.IMPORT_FENCE_FD_INFO_KHR);
        }
        return ret;
    }

    public static VkImportFenceFdInfoKHR clone(Arena arena, VkImportFenceFdInfoKHR src) {
        VkImportFenceFdInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.IMPORT_FENCE_FD_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkImportFenceFdInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkImportFenceFdInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkImportFenceFdInfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Nullable VkFence fence() {
        MemorySegment s = segment.asSlice(OFFSET$fence, SIZE$fence);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkFence(s);
    }

    public VkImportFenceFdInfoKHR fence(@Nullable VkFence value) {
        segment.set(LAYOUT$fence, OFFSET$fence, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkFenceImportFlags.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkImportFenceFdInfoKHR flags(@Bitmask(VkFenceImportFlags.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @Bitmask(VkExternalFenceHandleTypeFlags.class) int handleType() {
        return segment.get(LAYOUT$handleType, OFFSET$handleType);
    }

    public VkImportFenceFdInfoKHR handleType(@Bitmask(VkExternalFenceHandleTypeFlags.class) int value) {
        segment.set(LAYOUT$handleType, OFFSET$handleType, value);
        return this;
    }

    public int fd() {
        return segment.get(LAYOUT$fd, OFFSET$fd);
    }

    public VkImportFenceFdInfoKHR fd(int value) {
        segment.set(LAYOUT$fd, OFFSET$fd, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withName("fence"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("handleType"),
        ValueLayout.JAVA_INT.withName("fd")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$fence = PathElement.groupElement("fence");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$handleType = PathElement.groupElement("handleType");
    public static final PathElement PATH$fd = PathElement.groupElement("fd");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$fence = (AddressLayout) LAYOUT.select(PATH$fence);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$handleType = (OfInt) LAYOUT.select(PATH$handleType);
    public static final OfInt LAYOUT$fd = (OfInt) LAYOUT.select(PATH$fd);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$fence = LAYOUT$fence.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$handleType = LAYOUT$handleType.byteSize();
    public static final long SIZE$fd = LAYOUT$fd.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$fence = LAYOUT.byteOffset(PATH$fence);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$handleType = LAYOUT.byteOffset(PATH$handleType);
    public static final long OFFSET$fd = LAYOUT.byteOffset(PATH$fd);
}
