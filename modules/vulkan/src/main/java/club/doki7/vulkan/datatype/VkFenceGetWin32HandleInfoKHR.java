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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkFenceGetWin32HandleInfoKHR.html"><code>VkFenceGetWin32HandleInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkFenceGetWin32HandleInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkFence fence; // @link substring="VkFence" target="VkFence" @link substring="fence" target="#fence"
///     VkExternalFenceHandleTypeFlags handleType; // @link substring="VkExternalFenceHandleTypeFlags" target="VkExternalFenceHandleTypeFlags" @link substring="handleType" target="#handleType"
/// } VkFenceGetWin32HandleInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_FENCE_GET_WIN32_HANDLE_INFO_KHR`
///
/// The {@code allocate} ({@link VkFenceGetWin32HandleInfoKHR#allocate(Arena)}, {@link VkFenceGetWin32HandleInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkFenceGetWin32HandleInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkFenceGetWin32HandleInfoKHR.html"><code>VkFenceGetWin32HandleInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkFenceGetWin32HandleInfoKHR(@NotNull MemorySegment segment) implements IVkFenceGetWin32HandleInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkFenceGetWin32HandleInfoKHR.html"><code>VkFenceGetWin32HandleInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkFenceGetWin32HandleInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkFenceGetWin32HandleInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkFenceGetWin32HandleInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkFenceGetWin32HandleInfoKHR, Iterable<VkFenceGetWin32HandleInfoKHR> {
        public long size() {
            return segment.byteSize() / VkFenceGetWin32HandleInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkFenceGetWin32HandleInfoKHR at(long index) {
            return new VkFenceGetWin32HandleInfoKHR(segment.asSlice(index * VkFenceGetWin32HandleInfoKHR.BYTES, VkFenceGetWin32HandleInfoKHR.BYTES));
        }

        public VkFenceGetWin32HandleInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkFenceGetWin32HandleInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkFenceGetWin32HandleInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkFenceGetWin32HandleInfoKHR.BYTES, VkFenceGetWin32HandleInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkFenceGetWin32HandleInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkFenceGetWin32HandleInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkFenceGetWin32HandleInfoKHR.BYTES,
                (end - start) * VkFenceGetWin32HandleInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkFenceGetWin32HandleInfoKHR.BYTES));
        }

        public VkFenceGetWin32HandleInfoKHR[] toArray() {
            VkFenceGetWin32HandleInfoKHR[] ret = new VkFenceGetWin32HandleInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkFenceGetWin32HandleInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkFenceGetWin32HandleInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkFenceGetWin32HandleInfoKHR.BYTES;
            }

            @Override
            public VkFenceGetWin32HandleInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkFenceGetWin32HandleInfoKHR ret = new VkFenceGetWin32HandleInfoKHR(segment.asSlice(0, VkFenceGetWin32HandleInfoKHR.BYTES));
                segment = segment.asSlice(VkFenceGetWin32HandleInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkFenceGetWin32HandleInfoKHR allocate(Arena arena) {
        VkFenceGetWin32HandleInfoKHR ret = new VkFenceGetWin32HandleInfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.FENCE_GET_WIN32_HANDLE_INFO_KHR);
        return ret;
    }

    public static VkFenceGetWin32HandleInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkFenceGetWin32HandleInfoKHR.Ptr ret = new VkFenceGetWin32HandleInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.FENCE_GET_WIN32_HANDLE_INFO_KHR);
        }
        return ret;
    }

    public static VkFenceGetWin32HandleInfoKHR clone(Arena arena, VkFenceGetWin32HandleInfoKHR src) {
        VkFenceGetWin32HandleInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.FENCE_GET_WIN32_HANDLE_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkFenceGetWin32HandleInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkFenceGetWin32HandleInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkFenceGetWin32HandleInfoKHR pNext(@Nullable IPointer pointer) {
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

    public VkFenceGetWin32HandleInfoKHR fence(@Nullable VkFence value) {
        segment.set(LAYOUT$fence, OFFSET$fence, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkExternalFenceHandleTypeFlags.class) int handleType() {
        return segment.get(LAYOUT$handleType, OFFSET$handleType);
    }

    public VkFenceGetWin32HandleInfoKHR handleType(@Bitmask(VkExternalFenceHandleTypeFlags.class) int value) {
        segment.set(LAYOUT$handleType, OFFSET$handleType, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withName("fence"),
        ValueLayout.JAVA_INT.withName("handleType")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$fence = PathElement.groupElement("fence");
    public static final PathElement PATH$handleType = PathElement.groupElement("handleType");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$fence = (AddressLayout) LAYOUT.select(PATH$fence);
    public static final OfInt LAYOUT$handleType = (OfInt) LAYOUT.select(PATH$handleType);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$fence = LAYOUT$fence.byteSize();
    public static final long SIZE$handleType = LAYOUT$handleType.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$fence = LAYOUT.byteOffset(PATH$fence);
    public static final long OFFSET$handleType = LAYOUT.byteOffset(PATH$handleType);
}
