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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSemaphoreSciSyncCreateInfoNV.html"><code>VkSemaphoreSciSyncCreateInfoNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkSemaphoreSciSyncCreateInfoNV {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkSemaphoreSciSyncPoolNV semaphorePool; // @link substring="VkSemaphoreSciSyncPoolNV" target="VkSemaphoreSciSyncPoolNV" @link substring="semaphorePool" target="#semaphorePool"
///     NvSciSyncFence const* pFence; // @link substring="NvSciSyncFenceVKREF" target="NvSciSyncFenceVKREF" @link substring="pFence" target="#pFence"
/// } VkSemaphoreSciSyncCreateInfoNV;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_SEMAPHORE_SCI_SYNC_CREATE_INFO_NV`
///
/// The {@code allocate} ({@link VkSemaphoreSciSyncCreateInfoNV#allocate(Arena)}, {@link VkSemaphoreSciSyncCreateInfoNV#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkSemaphoreSciSyncCreateInfoNV#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSemaphoreSciSyncCreateInfoNV.html"><code>VkSemaphoreSciSyncCreateInfoNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkSemaphoreSciSyncCreateInfoNV(@NotNull MemorySegment segment) implements IVkSemaphoreSciSyncCreateInfoNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSemaphoreSciSyncCreateInfoNV.html"><code>VkSemaphoreSciSyncCreateInfoNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkSemaphoreSciSyncCreateInfoNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkSemaphoreSciSyncCreateInfoNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkSemaphoreSciSyncCreateInfoNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkSemaphoreSciSyncCreateInfoNV, Iterable<VkSemaphoreSciSyncCreateInfoNV> {
        public long size() {
            return segment.byteSize() / VkSemaphoreSciSyncCreateInfoNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkSemaphoreSciSyncCreateInfoNV at(long index) {
            return new VkSemaphoreSciSyncCreateInfoNV(segment.asSlice(index * VkSemaphoreSciSyncCreateInfoNV.BYTES, VkSemaphoreSciSyncCreateInfoNV.BYTES));
        }

        public VkSemaphoreSciSyncCreateInfoNV.Ptr at(long index, @NotNull Consumer<@NotNull VkSemaphoreSciSyncCreateInfoNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkSemaphoreSciSyncCreateInfoNV value) {
            MemorySegment s = segment.asSlice(index * VkSemaphoreSciSyncCreateInfoNV.BYTES, VkSemaphoreSciSyncCreateInfoNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkSemaphoreSciSyncCreateInfoNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkSemaphoreSciSyncCreateInfoNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkSemaphoreSciSyncCreateInfoNV.BYTES,
                (end - start) * VkSemaphoreSciSyncCreateInfoNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkSemaphoreSciSyncCreateInfoNV.BYTES));
        }

        public VkSemaphoreSciSyncCreateInfoNV[] toArray() {
            VkSemaphoreSciSyncCreateInfoNV[] ret = new VkSemaphoreSciSyncCreateInfoNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkSemaphoreSciSyncCreateInfoNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkSemaphoreSciSyncCreateInfoNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkSemaphoreSciSyncCreateInfoNV.BYTES;
            }

            @Override
            public VkSemaphoreSciSyncCreateInfoNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkSemaphoreSciSyncCreateInfoNV ret = new VkSemaphoreSciSyncCreateInfoNV(segment.asSlice(0, VkSemaphoreSciSyncCreateInfoNV.BYTES));
                segment = segment.asSlice(VkSemaphoreSciSyncCreateInfoNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkSemaphoreSciSyncCreateInfoNV allocate(Arena arena) {
        VkSemaphoreSciSyncCreateInfoNV ret = new VkSemaphoreSciSyncCreateInfoNV(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.SEMAPHORE_SCI_SYNC_CREATE_INFO_NV);
        return ret;
    }

    public static VkSemaphoreSciSyncCreateInfoNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkSemaphoreSciSyncCreateInfoNV.Ptr ret = new VkSemaphoreSciSyncCreateInfoNV.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.SEMAPHORE_SCI_SYNC_CREATE_INFO_NV);
        }
        return ret;
    }

    public static VkSemaphoreSciSyncCreateInfoNV clone(Arena arena, VkSemaphoreSciSyncCreateInfoNV src) {
        VkSemaphoreSciSyncCreateInfoNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.SEMAPHORE_SCI_SYNC_CREATE_INFO_NV);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkSemaphoreSciSyncCreateInfoNV sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkSemaphoreSciSyncCreateInfoNV pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkSemaphoreSciSyncCreateInfoNV pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Nullable VkSemaphoreSciSyncPoolNV semaphorePool() {
        MemorySegment s = segment.asSlice(OFFSET$semaphorePool, SIZE$semaphorePool);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkSemaphoreSciSyncPoolNV(s);
    }

    public VkSemaphoreSciSyncCreateInfoNV semaphorePool(@Nullable VkSemaphoreSciSyncPoolNV value) {
        segment.set(LAYOUT$semaphorePool, OFFSET$semaphorePool, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public VkSemaphoreSciSyncCreateInfoNV pFence(@Nullable INvSciSyncFenceVKREF value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pFenceRaw(s);
        return this;
    }

    @Unsafe public @Nullable NvSciSyncFenceVKREF.Ptr pFence(int assumedCount) {
        MemorySegment s = pFenceRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * NvSciSyncFenceVKREF.BYTES);
        return new NvSciSyncFenceVKREF.Ptr(s);
    }

    public @Nullable NvSciSyncFenceVKREF pFence() {
        MemorySegment s = pFenceRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new NvSciSyncFenceVKREF(s);
    }

    public @Pointer(target=NvSciSyncFenceVKREF.class) @NotNull MemorySegment pFenceRaw() {
        return segment.get(LAYOUT$pFence, OFFSET$pFence);
    }

    public void pFenceRaw(@Pointer(target=NvSciSyncFenceVKREF.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pFence, OFFSET$pFence, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withName("semaphorePool"),
        ValueLayout.ADDRESS.withTargetLayout(NvSciSyncFenceVKREF.LAYOUT).withName("pFence")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$semaphorePool = PathElement.groupElement("semaphorePool");
    public static final PathElement PATH$pFence = PathElement.groupElement("pFence");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$semaphorePool = (AddressLayout) LAYOUT.select(PATH$semaphorePool);
    public static final AddressLayout LAYOUT$pFence = (AddressLayout) LAYOUT.select(PATH$pFence);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$semaphorePool = LAYOUT$semaphorePool.byteSize();
    public static final long SIZE$pFence = LAYOUT$pFence.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$semaphorePool = LAYOUT.byteOffset(PATH$semaphorePool);
    public static final long OFFSET$pFence = LAYOUT.byteOffset(PATH$pFence);
}
