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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBindSparseInfo.html"><code>VkBindSparseInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkBindSparseInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t waitSemaphoreCount; // optional // @link substring="waitSemaphoreCount" target="#waitSemaphoreCount"
///     VkSemaphore const* pWaitSemaphores; // optional // @link substring="VkSemaphore" target="VkSemaphore" @link substring="pWaitSemaphores" target="#pWaitSemaphores"
///     uint32_t bufferBindCount; // optional // @link substring="bufferBindCount" target="#bufferBindCount"
///     VkSparseBufferMemoryBindInfo const* pBufferBinds; // optional // @link substring="VkSparseBufferMemoryBindInfo" target="VkSparseBufferMemoryBindInfo" @link substring="pBufferBinds" target="#pBufferBinds"
///     uint32_t imageOpaqueBindCount; // optional // @link substring="imageOpaqueBindCount" target="#imageOpaqueBindCount"
///     VkSparseImageOpaqueMemoryBindInfo const* pImageOpaqueBinds; // optional // @link substring="VkSparseImageOpaqueMemoryBindInfo" target="VkSparseImageOpaqueMemoryBindInfo" @link substring="pImageOpaqueBinds" target="#pImageOpaqueBinds"
///     uint32_t imageBindCount; // optional // @link substring="imageBindCount" target="#imageBindCount"
///     VkSparseImageMemoryBindInfo const* pImageBinds; // optional // @link substring="VkSparseImageMemoryBindInfo" target="VkSparseImageMemoryBindInfo" @link substring="pImageBinds" target="#pImageBinds"
///     uint32_t signalSemaphoreCount; // optional // @link substring="signalSemaphoreCount" target="#signalSemaphoreCount"
///     VkSemaphore const* pSignalSemaphores; // optional // @link substring="VkSemaphore" target="VkSemaphore" @link substring="pSignalSemaphores" target="#pSignalSemaphores"
/// } VkBindSparseInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_BIND_SPARSE_INFO`
///
/// The {@code allocate} ({@link VkBindSparseInfo#allocate(Arena)}, {@link VkBindSparseInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkBindSparseInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBindSparseInfo.html"><code>VkBindSparseInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkBindSparseInfo(@NotNull MemorySegment segment) implements IVkBindSparseInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBindSparseInfo.html"><code>VkBindSparseInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkBindSparseInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkBindSparseInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkBindSparseInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkBindSparseInfo, Iterable<VkBindSparseInfo> {
        public long size() {
            return segment.byteSize() / VkBindSparseInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkBindSparseInfo at(long index) {
            return new VkBindSparseInfo(segment.asSlice(index * VkBindSparseInfo.BYTES, VkBindSparseInfo.BYTES));
        }

        public VkBindSparseInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkBindSparseInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkBindSparseInfo value) {
            MemorySegment s = segment.asSlice(index * VkBindSparseInfo.BYTES, VkBindSparseInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkBindSparseInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkBindSparseInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkBindSparseInfo.BYTES,
                (end - start) * VkBindSparseInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkBindSparseInfo.BYTES));
        }

        public VkBindSparseInfo[] toArray() {
            VkBindSparseInfo[] ret = new VkBindSparseInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkBindSparseInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkBindSparseInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkBindSparseInfo.BYTES;
            }

            @Override
            public VkBindSparseInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkBindSparseInfo ret = new VkBindSparseInfo(segment.asSlice(0, VkBindSparseInfo.BYTES));
                segment = segment.asSlice(VkBindSparseInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkBindSparseInfo allocate(Arena arena) {
        VkBindSparseInfo ret = new VkBindSparseInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.BIND_SPARSE_INFO);
        return ret;
    }

    public static VkBindSparseInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkBindSparseInfo.Ptr ret = new VkBindSparseInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.BIND_SPARSE_INFO);
        }
        return ret;
    }

    public static VkBindSparseInfo clone(Arena arena, VkBindSparseInfo src) {
        VkBindSparseInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.BIND_SPARSE_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkBindSparseInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkBindSparseInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkBindSparseInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int waitSemaphoreCount() {
        return segment.get(LAYOUT$waitSemaphoreCount, OFFSET$waitSemaphoreCount);
    }

    public VkBindSparseInfo waitSemaphoreCount(@Unsigned int value) {
        segment.set(LAYOUT$waitSemaphoreCount, OFFSET$waitSemaphoreCount, value);
        return this;
    }

    /// Note: the returned {@link VkSemaphore.Ptr} does not have correct {@link VkSemaphore.Ptr#size}
    /// property. It's up to user to track the size of the buffer, and use
    /// {@link VkSemaphore.Ptr#reinterpret} to set the size before actually reading from or writing to the
    /// buffer.
    public @Nullable VkSemaphore.Ptr pWaitSemaphores() {
        MemorySegment s = pWaitSemaphoresRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkSemaphore.Ptr(s);
    }

    public VkBindSparseInfo pWaitSemaphores(@Nullable VkSemaphore.Ptr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pWaitSemaphoresRaw(s);
        return this;
    }

    public @Pointer(target=VkSemaphore.class) @NotNull MemorySegment pWaitSemaphoresRaw() {
        return segment.get(LAYOUT$pWaitSemaphores, OFFSET$pWaitSemaphores);
    }

    public void pWaitSemaphoresRaw(@Pointer(target=VkSemaphore.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pWaitSemaphores, OFFSET$pWaitSemaphores, value);
    }

    public @Unsigned int bufferBindCount() {
        return segment.get(LAYOUT$bufferBindCount, OFFSET$bufferBindCount);
    }

    public VkBindSparseInfo bufferBindCount(@Unsigned int value) {
        segment.set(LAYOUT$bufferBindCount, OFFSET$bufferBindCount, value);
        return this;
    }

    public VkBindSparseInfo pBufferBinds(@Nullable IVkSparseBufferMemoryBindInfo value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pBufferBindsRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkSparseBufferMemoryBindInfo.Ptr pBufferBinds(int assumedCount) {
        MemorySegment s = pBufferBindsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkSparseBufferMemoryBindInfo.BYTES);
        return new VkSparseBufferMemoryBindInfo.Ptr(s);
    }

    public @Nullable VkSparseBufferMemoryBindInfo pBufferBinds() {
        MemorySegment s = pBufferBindsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkSparseBufferMemoryBindInfo(s);
    }

    public @Pointer(target=VkSparseBufferMemoryBindInfo.class) @NotNull MemorySegment pBufferBindsRaw() {
        return segment.get(LAYOUT$pBufferBinds, OFFSET$pBufferBinds);
    }

    public void pBufferBindsRaw(@Pointer(target=VkSparseBufferMemoryBindInfo.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pBufferBinds, OFFSET$pBufferBinds, value);
    }

    public @Unsigned int imageOpaqueBindCount() {
        return segment.get(LAYOUT$imageOpaqueBindCount, OFFSET$imageOpaqueBindCount);
    }

    public VkBindSparseInfo imageOpaqueBindCount(@Unsigned int value) {
        segment.set(LAYOUT$imageOpaqueBindCount, OFFSET$imageOpaqueBindCount, value);
        return this;
    }

    public VkBindSparseInfo pImageOpaqueBinds(@Nullable IVkSparseImageOpaqueMemoryBindInfo value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pImageOpaqueBindsRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkSparseImageOpaqueMemoryBindInfo.Ptr pImageOpaqueBinds(int assumedCount) {
        MemorySegment s = pImageOpaqueBindsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkSparseImageOpaqueMemoryBindInfo.BYTES);
        return new VkSparseImageOpaqueMemoryBindInfo.Ptr(s);
    }

    public @Nullable VkSparseImageOpaqueMemoryBindInfo pImageOpaqueBinds() {
        MemorySegment s = pImageOpaqueBindsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkSparseImageOpaqueMemoryBindInfo(s);
    }

    public @Pointer(target=VkSparseImageOpaqueMemoryBindInfo.class) @NotNull MemorySegment pImageOpaqueBindsRaw() {
        return segment.get(LAYOUT$pImageOpaqueBinds, OFFSET$pImageOpaqueBinds);
    }

    public void pImageOpaqueBindsRaw(@Pointer(target=VkSparseImageOpaqueMemoryBindInfo.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pImageOpaqueBinds, OFFSET$pImageOpaqueBinds, value);
    }

    public @Unsigned int imageBindCount() {
        return segment.get(LAYOUT$imageBindCount, OFFSET$imageBindCount);
    }

    public VkBindSparseInfo imageBindCount(@Unsigned int value) {
        segment.set(LAYOUT$imageBindCount, OFFSET$imageBindCount, value);
        return this;
    }

    public VkBindSparseInfo pImageBinds(@Nullable IVkSparseImageMemoryBindInfo value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pImageBindsRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkSparseImageMemoryBindInfo.Ptr pImageBinds(int assumedCount) {
        MemorySegment s = pImageBindsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkSparseImageMemoryBindInfo.BYTES);
        return new VkSparseImageMemoryBindInfo.Ptr(s);
    }

    public @Nullable VkSparseImageMemoryBindInfo pImageBinds() {
        MemorySegment s = pImageBindsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkSparseImageMemoryBindInfo(s);
    }

    public @Pointer(target=VkSparseImageMemoryBindInfo.class) @NotNull MemorySegment pImageBindsRaw() {
        return segment.get(LAYOUT$pImageBinds, OFFSET$pImageBinds);
    }

    public void pImageBindsRaw(@Pointer(target=VkSparseImageMemoryBindInfo.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pImageBinds, OFFSET$pImageBinds, value);
    }

    public @Unsigned int signalSemaphoreCount() {
        return segment.get(LAYOUT$signalSemaphoreCount, OFFSET$signalSemaphoreCount);
    }

    public VkBindSparseInfo signalSemaphoreCount(@Unsigned int value) {
        segment.set(LAYOUT$signalSemaphoreCount, OFFSET$signalSemaphoreCount, value);
        return this;
    }

    /// Note: the returned {@link VkSemaphore.Ptr} does not have correct {@link VkSemaphore.Ptr#size}
    /// property. It's up to user to track the size of the buffer, and use
    /// {@link VkSemaphore.Ptr#reinterpret} to set the size before actually reading from or writing to the
    /// buffer.
    public @Nullable VkSemaphore.Ptr pSignalSemaphores() {
        MemorySegment s = pSignalSemaphoresRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkSemaphore.Ptr(s);
    }

    public VkBindSparseInfo pSignalSemaphores(@Nullable VkSemaphore.Ptr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pSignalSemaphoresRaw(s);
        return this;
    }

    public @Pointer(target=VkSemaphore.class) @NotNull MemorySegment pSignalSemaphoresRaw() {
        return segment.get(LAYOUT$pSignalSemaphores, OFFSET$pSignalSemaphores);
    }

    public void pSignalSemaphoresRaw(@Pointer(target=VkSemaphore.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pSignalSemaphores, OFFSET$pSignalSemaphores, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("waitSemaphoreCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS).withName("pWaitSemaphores"),
        ValueLayout.JAVA_INT.withName("bufferBindCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkSparseBufferMemoryBindInfo.LAYOUT).withName("pBufferBinds"),
        ValueLayout.JAVA_INT.withName("imageOpaqueBindCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkSparseImageOpaqueMemoryBindInfo.LAYOUT).withName("pImageOpaqueBinds"),
        ValueLayout.JAVA_INT.withName("imageBindCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkSparseImageMemoryBindInfo.LAYOUT).withName("pImageBinds"),
        ValueLayout.JAVA_INT.withName("signalSemaphoreCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS).withName("pSignalSemaphores")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$waitSemaphoreCount = PathElement.groupElement("waitSemaphoreCount");
    public static final PathElement PATH$pWaitSemaphores = PathElement.groupElement("pWaitSemaphores");
    public static final PathElement PATH$bufferBindCount = PathElement.groupElement("bufferBindCount");
    public static final PathElement PATH$pBufferBinds = PathElement.groupElement("pBufferBinds");
    public static final PathElement PATH$imageOpaqueBindCount = PathElement.groupElement("imageOpaqueBindCount");
    public static final PathElement PATH$pImageOpaqueBinds = PathElement.groupElement("pImageOpaqueBinds");
    public static final PathElement PATH$imageBindCount = PathElement.groupElement("imageBindCount");
    public static final PathElement PATH$pImageBinds = PathElement.groupElement("pImageBinds");
    public static final PathElement PATH$signalSemaphoreCount = PathElement.groupElement("signalSemaphoreCount");
    public static final PathElement PATH$pSignalSemaphores = PathElement.groupElement("pSignalSemaphores");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$waitSemaphoreCount = (OfInt) LAYOUT.select(PATH$waitSemaphoreCount);
    public static final AddressLayout LAYOUT$pWaitSemaphores = (AddressLayout) LAYOUT.select(PATH$pWaitSemaphores);
    public static final OfInt LAYOUT$bufferBindCount = (OfInt) LAYOUT.select(PATH$bufferBindCount);
    public static final AddressLayout LAYOUT$pBufferBinds = (AddressLayout) LAYOUT.select(PATH$pBufferBinds);
    public static final OfInt LAYOUT$imageOpaqueBindCount = (OfInt) LAYOUT.select(PATH$imageOpaqueBindCount);
    public static final AddressLayout LAYOUT$pImageOpaqueBinds = (AddressLayout) LAYOUT.select(PATH$pImageOpaqueBinds);
    public static final OfInt LAYOUT$imageBindCount = (OfInt) LAYOUT.select(PATH$imageBindCount);
    public static final AddressLayout LAYOUT$pImageBinds = (AddressLayout) LAYOUT.select(PATH$pImageBinds);
    public static final OfInt LAYOUT$signalSemaphoreCount = (OfInt) LAYOUT.select(PATH$signalSemaphoreCount);
    public static final AddressLayout LAYOUT$pSignalSemaphores = (AddressLayout) LAYOUT.select(PATH$pSignalSemaphores);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$waitSemaphoreCount = LAYOUT$waitSemaphoreCount.byteSize();
    public static final long SIZE$pWaitSemaphores = LAYOUT$pWaitSemaphores.byteSize();
    public static final long SIZE$bufferBindCount = LAYOUT$bufferBindCount.byteSize();
    public static final long SIZE$pBufferBinds = LAYOUT$pBufferBinds.byteSize();
    public static final long SIZE$imageOpaqueBindCount = LAYOUT$imageOpaqueBindCount.byteSize();
    public static final long SIZE$pImageOpaqueBinds = LAYOUT$pImageOpaqueBinds.byteSize();
    public static final long SIZE$imageBindCount = LAYOUT$imageBindCount.byteSize();
    public static final long SIZE$pImageBinds = LAYOUT$pImageBinds.byteSize();
    public static final long SIZE$signalSemaphoreCount = LAYOUT$signalSemaphoreCount.byteSize();
    public static final long SIZE$pSignalSemaphores = LAYOUT$pSignalSemaphores.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$waitSemaphoreCount = LAYOUT.byteOffset(PATH$waitSemaphoreCount);
    public static final long OFFSET$pWaitSemaphores = LAYOUT.byteOffset(PATH$pWaitSemaphores);
    public static final long OFFSET$bufferBindCount = LAYOUT.byteOffset(PATH$bufferBindCount);
    public static final long OFFSET$pBufferBinds = LAYOUT.byteOffset(PATH$pBufferBinds);
    public static final long OFFSET$imageOpaqueBindCount = LAYOUT.byteOffset(PATH$imageOpaqueBindCount);
    public static final long OFFSET$pImageOpaqueBinds = LAYOUT.byteOffset(PATH$pImageOpaqueBinds);
    public static final long OFFSET$imageBindCount = LAYOUT.byteOffset(PATH$imageBindCount);
    public static final long OFFSET$pImageBinds = LAYOUT.byteOffset(PATH$pImageBinds);
    public static final long OFFSET$signalSemaphoreCount = LAYOUT.byteOffset(PATH$signalSemaphoreCount);
    public static final long OFFSET$pSignalSemaphores = LAYOUT.byteOffset(PATH$pSignalSemaphores);
}
