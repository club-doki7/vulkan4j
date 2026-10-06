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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSubmitInfo2.html"><code>VkSubmitInfo2</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkSubmitInfo2 {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkSubmitFlags flags; // optional // @link substring="VkSubmitFlags" target="VkSubmitFlags" @link substring="flags" target="#flags"
///     uint32_t waitSemaphoreInfoCount; // optional // @link substring="waitSemaphoreInfoCount" target="#waitSemaphoreInfoCount"
///     VkSemaphoreSubmitInfo const* pWaitSemaphoreInfos; // optional // @link substring="VkSemaphoreSubmitInfo" target="VkSemaphoreSubmitInfo" @link substring="pWaitSemaphoreInfos" target="#pWaitSemaphoreInfos"
///     uint32_t commandBufferInfoCount; // optional // @link substring="commandBufferInfoCount" target="#commandBufferInfoCount"
///     VkCommandBufferSubmitInfo const* pCommandBufferInfos; // optional // @link substring="VkCommandBufferSubmitInfo" target="VkCommandBufferSubmitInfo" @link substring="pCommandBufferInfos" target="#pCommandBufferInfos"
///     uint32_t signalSemaphoreInfoCount; // optional // @link substring="signalSemaphoreInfoCount" target="#signalSemaphoreInfoCount"
///     VkSemaphoreSubmitInfo const* pSignalSemaphoreInfos; // optional // @link substring="VkSemaphoreSubmitInfo" target="VkSemaphoreSubmitInfo" @link substring="pSignalSemaphoreInfos" target="#pSignalSemaphoreInfos"
/// } VkSubmitInfo2;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_SUBMIT_INFO_2`
///
/// The {@code allocate} ({@link VkSubmitInfo2#allocate(Arena)}, {@link VkSubmitInfo2#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkSubmitInfo2#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSubmitInfo2.html"><code>VkSubmitInfo2</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkSubmitInfo2(@NotNull MemorySegment segment) implements IVkSubmitInfo2 {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSubmitInfo2.html"><code>VkSubmitInfo2</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkSubmitInfo2}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkSubmitInfo2 to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkSubmitInfo2.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkSubmitInfo2, Iterable<VkSubmitInfo2> {
        public long size() {
            return segment.byteSize() / VkSubmitInfo2.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkSubmitInfo2 at(long index) {
            return new VkSubmitInfo2(segment.asSlice(index * VkSubmitInfo2.BYTES, VkSubmitInfo2.BYTES));
        }

        public VkSubmitInfo2.Ptr at(long index, @NotNull Consumer<@NotNull VkSubmitInfo2> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkSubmitInfo2 value) {
            MemorySegment s = segment.asSlice(index * VkSubmitInfo2.BYTES, VkSubmitInfo2.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkSubmitInfo2.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkSubmitInfo2.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkSubmitInfo2.BYTES,
                (end - start) * VkSubmitInfo2.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkSubmitInfo2.BYTES));
        }

        public VkSubmitInfo2[] toArray() {
            VkSubmitInfo2[] ret = new VkSubmitInfo2[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkSubmitInfo2> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkSubmitInfo2> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkSubmitInfo2.BYTES;
            }

            @Override
            public VkSubmitInfo2 next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkSubmitInfo2 ret = new VkSubmitInfo2(segment.asSlice(0, VkSubmitInfo2.BYTES));
                segment = segment.asSlice(VkSubmitInfo2.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkSubmitInfo2 allocate(Arena arena) {
        VkSubmitInfo2 ret = new VkSubmitInfo2(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.SUBMIT_INFO_2);
        return ret;
    }

    public static VkSubmitInfo2.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkSubmitInfo2.Ptr ret = new VkSubmitInfo2.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.SUBMIT_INFO_2);
        }
        return ret;
    }

    public static VkSubmitInfo2 clone(Arena arena, VkSubmitInfo2 src) {
        VkSubmitInfo2 ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.SUBMIT_INFO_2);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkSubmitInfo2 sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkSubmitInfo2 pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkSubmitInfo2 pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkSubmitFlags.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkSubmitInfo2 flags(@Bitmask(VkSubmitFlags.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @Unsigned int waitSemaphoreInfoCount() {
        return segment.get(LAYOUT$waitSemaphoreInfoCount, OFFSET$waitSemaphoreInfoCount);
    }

    public VkSubmitInfo2 waitSemaphoreInfoCount(@Unsigned int value) {
        segment.set(LAYOUT$waitSemaphoreInfoCount, OFFSET$waitSemaphoreInfoCount, value);
        return this;
    }

    public VkSubmitInfo2 pWaitSemaphoreInfos(@Nullable IVkSemaphoreSubmitInfo value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pWaitSemaphoreInfosRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkSemaphoreSubmitInfo.Ptr pWaitSemaphoreInfos(int assumedCount) {
        MemorySegment s = pWaitSemaphoreInfosRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkSemaphoreSubmitInfo.BYTES);
        return new VkSemaphoreSubmitInfo.Ptr(s);
    }

    public @Nullable VkSemaphoreSubmitInfo pWaitSemaphoreInfos() {
        MemorySegment s = pWaitSemaphoreInfosRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkSemaphoreSubmitInfo(s);
    }

    public @Pointer(target=VkSemaphoreSubmitInfo.class) @NotNull MemorySegment pWaitSemaphoreInfosRaw() {
        return segment.get(LAYOUT$pWaitSemaphoreInfos, OFFSET$pWaitSemaphoreInfos);
    }

    public void pWaitSemaphoreInfosRaw(@Pointer(target=VkSemaphoreSubmitInfo.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pWaitSemaphoreInfos, OFFSET$pWaitSemaphoreInfos, value);
    }

    public @Unsigned int commandBufferInfoCount() {
        return segment.get(LAYOUT$commandBufferInfoCount, OFFSET$commandBufferInfoCount);
    }

    public VkSubmitInfo2 commandBufferInfoCount(@Unsigned int value) {
        segment.set(LAYOUT$commandBufferInfoCount, OFFSET$commandBufferInfoCount, value);
        return this;
    }

    public VkSubmitInfo2 pCommandBufferInfos(@Nullable IVkCommandBufferSubmitInfo value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pCommandBufferInfosRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkCommandBufferSubmitInfo.Ptr pCommandBufferInfos(int assumedCount) {
        MemorySegment s = pCommandBufferInfosRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkCommandBufferSubmitInfo.BYTES);
        return new VkCommandBufferSubmitInfo.Ptr(s);
    }

    public @Nullable VkCommandBufferSubmitInfo pCommandBufferInfos() {
        MemorySegment s = pCommandBufferInfosRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkCommandBufferSubmitInfo(s);
    }

    public @Pointer(target=VkCommandBufferSubmitInfo.class) @NotNull MemorySegment pCommandBufferInfosRaw() {
        return segment.get(LAYOUT$pCommandBufferInfos, OFFSET$pCommandBufferInfos);
    }

    public void pCommandBufferInfosRaw(@Pointer(target=VkCommandBufferSubmitInfo.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pCommandBufferInfos, OFFSET$pCommandBufferInfos, value);
    }

    public @Unsigned int signalSemaphoreInfoCount() {
        return segment.get(LAYOUT$signalSemaphoreInfoCount, OFFSET$signalSemaphoreInfoCount);
    }

    public VkSubmitInfo2 signalSemaphoreInfoCount(@Unsigned int value) {
        segment.set(LAYOUT$signalSemaphoreInfoCount, OFFSET$signalSemaphoreInfoCount, value);
        return this;
    }

    public VkSubmitInfo2 pSignalSemaphoreInfos(@Nullable IVkSemaphoreSubmitInfo value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pSignalSemaphoreInfosRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkSemaphoreSubmitInfo.Ptr pSignalSemaphoreInfos(int assumedCount) {
        MemorySegment s = pSignalSemaphoreInfosRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkSemaphoreSubmitInfo.BYTES);
        return new VkSemaphoreSubmitInfo.Ptr(s);
    }

    public @Nullable VkSemaphoreSubmitInfo pSignalSemaphoreInfos() {
        MemorySegment s = pSignalSemaphoreInfosRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkSemaphoreSubmitInfo(s);
    }

    public @Pointer(target=VkSemaphoreSubmitInfo.class) @NotNull MemorySegment pSignalSemaphoreInfosRaw() {
        return segment.get(LAYOUT$pSignalSemaphoreInfos, OFFSET$pSignalSemaphoreInfos);
    }

    public void pSignalSemaphoreInfosRaw(@Pointer(target=VkSemaphoreSubmitInfo.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pSignalSemaphoreInfos, OFFSET$pSignalSemaphoreInfos, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("waitSemaphoreInfoCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkSemaphoreSubmitInfo.LAYOUT).withName("pWaitSemaphoreInfos"),
        ValueLayout.JAVA_INT.withName("commandBufferInfoCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkCommandBufferSubmitInfo.LAYOUT).withName("pCommandBufferInfos"),
        ValueLayout.JAVA_INT.withName("signalSemaphoreInfoCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkSemaphoreSubmitInfo.LAYOUT).withName("pSignalSemaphoreInfos")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$waitSemaphoreInfoCount = PathElement.groupElement("waitSemaphoreInfoCount");
    public static final PathElement PATH$pWaitSemaphoreInfos = PathElement.groupElement("pWaitSemaphoreInfos");
    public static final PathElement PATH$commandBufferInfoCount = PathElement.groupElement("commandBufferInfoCount");
    public static final PathElement PATH$pCommandBufferInfos = PathElement.groupElement("pCommandBufferInfos");
    public static final PathElement PATH$signalSemaphoreInfoCount = PathElement.groupElement("signalSemaphoreInfoCount");
    public static final PathElement PATH$pSignalSemaphoreInfos = PathElement.groupElement("pSignalSemaphoreInfos");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$waitSemaphoreInfoCount = (OfInt) LAYOUT.select(PATH$waitSemaphoreInfoCount);
    public static final AddressLayout LAYOUT$pWaitSemaphoreInfos = (AddressLayout) LAYOUT.select(PATH$pWaitSemaphoreInfos);
    public static final OfInt LAYOUT$commandBufferInfoCount = (OfInt) LAYOUT.select(PATH$commandBufferInfoCount);
    public static final AddressLayout LAYOUT$pCommandBufferInfos = (AddressLayout) LAYOUT.select(PATH$pCommandBufferInfos);
    public static final OfInt LAYOUT$signalSemaphoreInfoCount = (OfInt) LAYOUT.select(PATH$signalSemaphoreInfoCount);
    public static final AddressLayout LAYOUT$pSignalSemaphoreInfos = (AddressLayout) LAYOUT.select(PATH$pSignalSemaphoreInfos);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$waitSemaphoreInfoCount = LAYOUT$waitSemaphoreInfoCount.byteSize();
    public static final long SIZE$pWaitSemaphoreInfos = LAYOUT$pWaitSemaphoreInfos.byteSize();
    public static final long SIZE$commandBufferInfoCount = LAYOUT$commandBufferInfoCount.byteSize();
    public static final long SIZE$pCommandBufferInfos = LAYOUT$pCommandBufferInfos.byteSize();
    public static final long SIZE$signalSemaphoreInfoCount = LAYOUT$signalSemaphoreInfoCount.byteSize();
    public static final long SIZE$pSignalSemaphoreInfos = LAYOUT$pSignalSemaphoreInfos.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$waitSemaphoreInfoCount = LAYOUT.byteOffset(PATH$waitSemaphoreInfoCount);
    public static final long OFFSET$pWaitSemaphoreInfos = LAYOUT.byteOffset(PATH$pWaitSemaphoreInfos);
    public static final long OFFSET$commandBufferInfoCount = LAYOUT.byteOffset(PATH$commandBufferInfoCount);
    public static final long OFFSET$pCommandBufferInfos = LAYOUT.byteOffset(PATH$pCommandBufferInfos);
    public static final long OFFSET$signalSemaphoreInfoCount = LAYOUT.byteOffset(PATH$signalSemaphoreInfoCount);
    public static final long OFFSET$pSignalSemaphoreInfos = LAYOUT.byteOffset(PATH$pSignalSemaphoreInfos);
}
