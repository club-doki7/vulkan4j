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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSemaphoreWaitInfo.html"><code>VkSemaphoreWaitInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkSemaphoreWaitInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkSemaphoreWaitFlags flags; // optional // @link substring="VkSemaphoreWaitFlags" target="VkSemaphoreWaitFlags" @link substring="flags" target="#flags"
///     uint32_t semaphoreCount; // @link substring="semaphoreCount" target="#semaphoreCount"
///     VkSemaphore const* pSemaphores; // @link substring="VkSemaphore" target="VkSemaphore" @link substring="pSemaphores" target="#pSemaphores"
///     uint64_t const* pValues; // @link substring="pValues" target="#pValues"
/// } VkSemaphoreWaitInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_SEMAPHORE_WAIT_INFO`
///
/// The {@code allocate} ({@link VkSemaphoreWaitInfo#allocate(Arena)}, {@link VkSemaphoreWaitInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkSemaphoreWaitInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSemaphoreWaitInfo.html"><code>VkSemaphoreWaitInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkSemaphoreWaitInfo(@NotNull MemorySegment segment) implements IVkSemaphoreWaitInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSemaphoreWaitInfo.html"><code>VkSemaphoreWaitInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkSemaphoreWaitInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkSemaphoreWaitInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkSemaphoreWaitInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkSemaphoreWaitInfo, Iterable<VkSemaphoreWaitInfo> {
        public long size() {
            return segment.byteSize() / VkSemaphoreWaitInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkSemaphoreWaitInfo at(long index) {
            return new VkSemaphoreWaitInfo(segment.asSlice(index * VkSemaphoreWaitInfo.BYTES, VkSemaphoreWaitInfo.BYTES));
        }

        public VkSemaphoreWaitInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkSemaphoreWaitInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkSemaphoreWaitInfo value) {
            MemorySegment s = segment.asSlice(index * VkSemaphoreWaitInfo.BYTES, VkSemaphoreWaitInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkSemaphoreWaitInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkSemaphoreWaitInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkSemaphoreWaitInfo.BYTES,
                (end - start) * VkSemaphoreWaitInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkSemaphoreWaitInfo.BYTES));
        }

        public VkSemaphoreWaitInfo[] toArray() {
            VkSemaphoreWaitInfo[] ret = new VkSemaphoreWaitInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkSemaphoreWaitInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkSemaphoreWaitInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkSemaphoreWaitInfo.BYTES;
            }

            @Override
            public VkSemaphoreWaitInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkSemaphoreWaitInfo ret = new VkSemaphoreWaitInfo(segment.asSlice(0, VkSemaphoreWaitInfo.BYTES));
                segment = segment.asSlice(VkSemaphoreWaitInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkSemaphoreWaitInfo allocate(Arena arena) {
        VkSemaphoreWaitInfo ret = new VkSemaphoreWaitInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.SEMAPHORE_WAIT_INFO);
        return ret;
    }

    public static VkSemaphoreWaitInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkSemaphoreWaitInfo.Ptr ret = new VkSemaphoreWaitInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.SEMAPHORE_WAIT_INFO);
        }
        return ret;
    }

    public static VkSemaphoreWaitInfo clone(Arena arena, VkSemaphoreWaitInfo src) {
        VkSemaphoreWaitInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.SEMAPHORE_WAIT_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkSemaphoreWaitInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkSemaphoreWaitInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkSemaphoreWaitInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkSemaphoreWaitFlags.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkSemaphoreWaitInfo flags(@Bitmask(VkSemaphoreWaitFlags.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @Unsigned int semaphoreCount() {
        return segment.get(LAYOUT$semaphoreCount, OFFSET$semaphoreCount);
    }

    public VkSemaphoreWaitInfo semaphoreCount(@Unsigned int value) {
        segment.set(LAYOUT$semaphoreCount, OFFSET$semaphoreCount, value);
        return this;
    }

    /// Note: the returned {@link VkSemaphore.Ptr} does not have correct {@link VkSemaphore.Ptr#size}
    /// property. It's up to user to track the size of the buffer, and use
    /// {@link VkSemaphore.Ptr#reinterpret} to set the size before actually reading from or writing to the
    /// buffer.
    public @Nullable VkSemaphore.Ptr pSemaphores() {
        MemorySegment s = pSemaphoresRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkSemaphore.Ptr(s);
    }

    public VkSemaphoreWaitInfo pSemaphores(@Nullable VkSemaphore.Ptr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pSemaphoresRaw(s);
        return this;
    }

    public @Pointer(target=VkSemaphore.class) @NotNull MemorySegment pSemaphoresRaw() {
        return segment.get(LAYOUT$pSemaphores, OFFSET$pSemaphores);
    }

    public void pSemaphoresRaw(@Pointer(target=VkSemaphore.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pSemaphores, OFFSET$pSemaphores, value);
    }

    /// Note: the returned {@link LongPtr} does not have correct
    /// {@link LongPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link LongPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable @Unsigned LongPtr pValues() {
        MemorySegment s = pValuesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new LongPtr(s);
    }

    public VkSemaphoreWaitInfo pValues(@Nullable @Unsigned LongPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pValuesRaw(s);
        return this;
    }

    public @Pointer(comment="uint64_t*") @NotNull MemorySegment pValuesRaw() {
        return segment.get(LAYOUT$pValues, OFFSET$pValues);
    }

    public void pValuesRaw(@Pointer(comment="uint64_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pValues, OFFSET$pValues, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("semaphoreCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS).withName("pSemaphores"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG).withName("pValues")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$semaphoreCount = PathElement.groupElement("semaphoreCount");
    public static final PathElement PATH$pSemaphores = PathElement.groupElement("pSemaphores");
    public static final PathElement PATH$pValues = PathElement.groupElement("pValues");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$semaphoreCount = (OfInt) LAYOUT.select(PATH$semaphoreCount);
    public static final AddressLayout LAYOUT$pSemaphores = (AddressLayout) LAYOUT.select(PATH$pSemaphores);
    public static final AddressLayout LAYOUT$pValues = (AddressLayout) LAYOUT.select(PATH$pValues);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$semaphoreCount = LAYOUT$semaphoreCount.byteSize();
    public static final long SIZE$pSemaphores = LAYOUT$pSemaphores.byteSize();
    public static final long SIZE$pValues = LAYOUT$pValues.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$semaphoreCount = LAYOUT.byteOffset(PATH$semaphoreCount);
    public static final long OFFSET$pSemaphores = LAYOUT.byteOffset(PATH$pSemaphores);
    public static final long OFFSET$pValues = LAYOUT.byteOffset(PATH$pValues);
}
