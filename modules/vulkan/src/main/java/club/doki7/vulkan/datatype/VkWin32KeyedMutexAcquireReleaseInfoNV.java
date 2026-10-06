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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkWin32KeyedMutexAcquireReleaseInfoNV.html"><code>VkWin32KeyedMutexAcquireReleaseInfoNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkWin32KeyedMutexAcquireReleaseInfoNV {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t acquireCount; // optional // @link substring="acquireCount" target="#acquireCount"
///     VkDeviceMemory const* pAcquireSyncs; // optional // @link substring="VkDeviceMemory" target="VkDeviceMemory" @link substring="pAcquireSyncs" target="#pAcquireSyncs"
///     uint64_t const* pAcquireKeys; // optional // @link substring="pAcquireKeys" target="#pAcquireKeys"
///     uint32_t const* pAcquireTimeoutMilliseconds; // optional // @link substring="pAcquireTimeoutMilliseconds" target="#pAcquireTimeoutMilliseconds"
///     uint32_t releaseCount; // optional // @link substring="releaseCount" target="#releaseCount"
///     VkDeviceMemory const* pReleaseSyncs; // optional // @link substring="VkDeviceMemory" target="VkDeviceMemory" @link substring="pReleaseSyncs" target="#pReleaseSyncs"
///     uint64_t const* pReleaseKeys; // optional // @link substring="pReleaseKeys" target="#pReleaseKeys"
/// } VkWin32KeyedMutexAcquireReleaseInfoNV;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_WIN32_KEYED_MUTEX_ACQUIRE_RELEASE_INFO_NV`
///
/// The {@code allocate} ({@link VkWin32KeyedMutexAcquireReleaseInfoNV#allocate(Arena)}, {@link VkWin32KeyedMutexAcquireReleaseInfoNV#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkWin32KeyedMutexAcquireReleaseInfoNV#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkWin32KeyedMutexAcquireReleaseInfoNV.html"><code>VkWin32KeyedMutexAcquireReleaseInfoNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkWin32KeyedMutexAcquireReleaseInfoNV(@NotNull MemorySegment segment) implements IVkWin32KeyedMutexAcquireReleaseInfoNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkWin32KeyedMutexAcquireReleaseInfoNV.html"><code>VkWin32KeyedMutexAcquireReleaseInfoNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkWin32KeyedMutexAcquireReleaseInfoNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkWin32KeyedMutexAcquireReleaseInfoNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkWin32KeyedMutexAcquireReleaseInfoNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkWin32KeyedMutexAcquireReleaseInfoNV, Iterable<VkWin32KeyedMutexAcquireReleaseInfoNV> {
        public long size() {
            return segment.byteSize() / VkWin32KeyedMutexAcquireReleaseInfoNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkWin32KeyedMutexAcquireReleaseInfoNV at(long index) {
            return new VkWin32KeyedMutexAcquireReleaseInfoNV(segment.asSlice(index * VkWin32KeyedMutexAcquireReleaseInfoNV.BYTES, VkWin32KeyedMutexAcquireReleaseInfoNV.BYTES));
        }

        public VkWin32KeyedMutexAcquireReleaseInfoNV.Ptr at(long index, @NotNull Consumer<@NotNull VkWin32KeyedMutexAcquireReleaseInfoNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkWin32KeyedMutexAcquireReleaseInfoNV value) {
            MemorySegment s = segment.asSlice(index * VkWin32KeyedMutexAcquireReleaseInfoNV.BYTES, VkWin32KeyedMutexAcquireReleaseInfoNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkWin32KeyedMutexAcquireReleaseInfoNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkWin32KeyedMutexAcquireReleaseInfoNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkWin32KeyedMutexAcquireReleaseInfoNV.BYTES,
                (end - start) * VkWin32KeyedMutexAcquireReleaseInfoNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkWin32KeyedMutexAcquireReleaseInfoNV.BYTES));
        }

        public VkWin32KeyedMutexAcquireReleaseInfoNV[] toArray() {
            VkWin32KeyedMutexAcquireReleaseInfoNV[] ret = new VkWin32KeyedMutexAcquireReleaseInfoNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkWin32KeyedMutexAcquireReleaseInfoNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkWin32KeyedMutexAcquireReleaseInfoNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkWin32KeyedMutexAcquireReleaseInfoNV.BYTES;
            }

            @Override
            public VkWin32KeyedMutexAcquireReleaseInfoNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkWin32KeyedMutexAcquireReleaseInfoNV ret = new VkWin32KeyedMutexAcquireReleaseInfoNV(segment.asSlice(0, VkWin32KeyedMutexAcquireReleaseInfoNV.BYTES));
                segment = segment.asSlice(VkWin32KeyedMutexAcquireReleaseInfoNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkWin32KeyedMutexAcquireReleaseInfoNV allocate(Arena arena) {
        VkWin32KeyedMutexAcquireReleaseInfoNV ret = new VkWin32KeyedMutexAcquireReleaseInfoNV(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.WIN32_KEYED_MUTEX_ACQUIRE_RELEASE_INFO_NV);
        return ret;
    }

    public static VkWin32KeyedMutexAcquireReleaseInfoNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkWin32KeyedMutexAcquireReleaseInfoNV.Ptr ret = new VkWin32KeyedMutexAcquireReleaseInfoNV.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.WIN32_KEYED_MUTEX_ACQUIRE_RELEASE_INFO_NV);
        }
        return ret;
    }

    public static VkWin32KeyedMutexAcquireReleaseInfoNV clone(Arena arena, VkWin32KeyedMutexAcquireReleaseInfoNV src) {
        VkWin32KeyedMutexAcquireReleaseInfoNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.WIN32_KEYED_MUTEX_ACQUIRE_RELEASE_INFO_NV);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkWin32KeyedMutexAcquireReleaseInfoNV sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkWin32KeyedMutexAcquireReleaseInfoNV pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkWin32KeyedMutexAcquireReleaseInfoNV pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int acquireCount() {
        return segment.get(LAYOUT$acquireCount, OFFSET$acquireCount);
    }

    public VkWin32KeyedMutexAcquireReleaseInfoNV acquireCount(@Unsigned int value) {
        segment.set(LAYOUT$acquireCount, OFFSET$acquireCount, value);
        return this;
    }

    /// Note: the returned {@link VkDeviceMemory.Ptr} does not have correct {@link VkDeviceMemory.Ptr#size}
    /// property. It's up to user to track the size of the buffer, and use
    /// {@link VkDeviceMemory.Ptr#reinterpret} to set the size before actually reading from or writing to the
    /// buffer.
    public @Nullable VkDeviceMemory.Ptr pAcquireSyncs() {
        MemorySegment s = pAcquireSyncsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkDeviceMemory.Ptr(s);
    }

    public VkWin32KeyedMutexAcquireReleaseInfoNV pAcquireSyncs(@Nullable VkDeviceMemory.Ptr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pAcquireSyncsRaw(s);
        return this;
    }

    public @Pointer(target=VkDeviceMemory.class) @NotNull MemorySegment pAcquireSyncsRaw() {
        return segment.get(LAYOUT$pAcquireSyncs, OFFSET$pAcquireSyncs);
    }

    public void pAcquireSyncsRaw(@Pointer(target=VkDeviceMemory.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pAcquireSyncs, OFFSET$pAcquireSyncs, value);
    }

    /// Note: the returned {@link LongPtr} does not have correct
    /// {@link LongPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link LongPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable @Unsigned LongPtr pAcquireKeys() {
        MemorySegment s = pAcquireKeysRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new LongPtr(s);
    }

    public VkWin32KeyedMutexAcquireReleaseInfoNV pAcquireKeys(@Nullable @Unsigned LongPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pAcquireKeysRaw(s);
        return this;
    }

    public @Pointer(comment="uint64_t*") @NotNull MemorySegment pAcquireKeysRaw() {
        return segment.get(LAYOUT$pAcquireKeys, OFFSET$pAcquireKeys);
    }

    public void pAcquireKeysRaw(@Pointer(comment="uint64_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pAcquireKeys, OFFSET$pAcquireKeys, value);
    }

    /// Note: the returned {@link IntPtr} does not have correct
    /// {@link IntPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link IntPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable @Unsigned IntPtr pAcquireTimeoutMilliseconds() {
        MemorySegment s = pAcquireTimeoutMillisecondsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new IntPtr(s);
    }

    public VkWin32KeyedMutexAcquireReleaseInfoNV pAcquireTimeoutMilliseconds(@Nullable @Unsigned IntPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pAcquireTimeoutMillisecondsRaw(s);
        return this;
    }

    public @Pointer(comment="uint32_t*") @NotNull MemorySegment pAcquireTimeoutMillisecondsRaw() {
        return segment.get(LAYOUT$pAcquireTimeoutMilliseconds, OFFSET$pAcquireTimeoutMilliseconds);
    }

    public void pAcquireTimeoutMillisecondsRaw(@Pointer(comment="uint32_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pAcquireTimeoutMilliseconds, OFFSET$pAcquireTimeoutMilliseconds, value);
    }

    public @Unsigned int releaseCount() {
        return segment.get(LAYOUT$releaseCount, OFFSET$releaseCount);
    }

    public VkWin32KeyedMutexAcquireReleaseInfoNV releaseCount(@Unsigned int value) {
        segment.set(LAYOUT$releaseCount, OFFSET$releaseCount, value);
        return this;
    }

    /// Note: the returned {@link VkDeviceMemory.Ptr} does not have correct {@link VkDeviceMemory.Ptr#size}
    /// property. It's up to user to track the size of the buffer, and use
    /// {@link VkDeviceMemory.Ptr#reinterpret} to set the size before actually reading from or writing to the
    /// buffer.
    public @Nullable VkDeviceMemory.Ptr pReleaseSyncs() {
        MemorySegment s = pReleaseSyncsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkDeviceMemory.Ptr(s);
    }

    public VkWin32KeyedMutexAcquireReleaseInfoNV pReleaseSyncs(@Nullable VkDeviceMemory.Ptr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pReleaseSyncsRaw(s);
        return this;
    }

    public @Pointer(target=VkDeviceMemory.class) @NotNull MemorySegment pReleaseSyncsRaw() {
        return segment.get(LAYOUT$pReleaseSyncs, OFFSET$pReleaseSyncs);
    }

    public void pReleaseSyncsRaw(@Pointer(target=VkDeviceMemory.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pReleaseSyncs, OFFSET$pReleaseSyncs, value);
    }

    /// Note: the returned {@link LongPtr} does not have correct
    /// {@link LongPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link LongPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable @Unsigned LongPtr pReleaseKeys() {
        MemorySegment s = pReleaseKeysRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new LongPtr(s);
    }

    public VkWin32KeyedMutexAcquireReleaseInfoNV pReleaseKeys(@Nullable @Unsigned LongPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pReleaseKeysRaw(s);
        return this;
    }

    public @Pointer(comment="uint64_t*") @NotNull MemorySegment pReleaseKeysRaw() {
        return segment.get(LAYOUT$pReleaseKeys, OFFSET$pReleaseKeys);
    }

    public void pReleaseKeysRaw(@Pointer(comment="uint64_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pReleaseKeys, OFFSET$pReleaseKeys, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("acquireCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS).withName("pAcquireSyncs"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG).withName("pAcquireKeys"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pAcquireTimeoutMilliseconds"),
        ValueLayout.JAVA_INT.withName("releaseCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS).withName("pReleaseSyncs"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG).withName("pReleaseKeys")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$acquireCount = PathElement.groupElement("acquireCount");
    public static final PathElement PATH$pAcquireSyncs = PathElement.groupElement("pAcquireSyncs");
    public static final PathElement PATH$pAcquireKeys = PathElement.groupElement("pAcquireKeys");
    public static final PathElement PATH$pAcquireTimeoutMilliseconds = PathElement.groupElement("pAcquireTimeoutMilliseconds");
    public static final PathElement PATH$releaseCount = PathElement.groupElement("releaseCount");
    public static final PathElement PATH$pReleaseSyncs = PathElement.groupElement("pReleaseSyncs");
    public static final PathElement PATH$pReleaseKeys = PathElement.groupElement("pReleaseKeys");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$acquireCount = (OfInt) LAYOUT.select(PATH$acquireCount);
    public static final AddressLayout LAYOUT$pAcquireSyncs = (AddressLayout) LAYOUT.select(PATH$pAcquireSyncs);
    public static final AddressLayout LAYOUT$pAcquireKeys = (AddressLayout) LAYOUT.select(PATH$pAcquireKeys);
    public static final AddressLayout LAYOUT$pAcquireTimeoutMilliseconds = (AddressLayout) LAYOUT.select(PATH$pAcquireTimeoutMilliseconds);
    public static final OfInt LAYOUT$releaseCount = (OfInt) LAYOUT.select(PATH$releaseCount);
    public static final AddressLayout LAYOUT$pReleaseSyncs = (AddressLayout) LAYOUT.select(PATH$pReleaseSyncs);
    public static final AddressLayout LAYOUT$pReleaseKeys = (AddressLayout) LAYOUT.select(PATH$pReleaseKeys);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$acquireCount = LAYOUT$acquireCount.byteSize();
    public static final long SIZE$pAcquireSyncs = LAYOUT$pAcquireSyncs.byteSize();
    public static final long SIZE$pAcquireKeys = LAYOUT$pAcquireKeys.byteSize();
    public static final long SIZE$pAcquireTimeoutMilliseconds = LAYOUT$pAcquireTimeoutMilliseconds.byteSize();
    public static final long SIZE$releaseCount = LAYOUT$releaseCount.byteSize();
    public static final long SIZE$pReleaseSyncs = LAYOUT$pReleaseSyncs.byteSize();
    public static final long SIZE$pReleaseKeys = LAYOUT$pReleaseKeys.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$acquireCount = LAYOUT.byteOffset(PATH$acquireCount);
    public static final long OFFSET$pAcquireSyncs = LAYOUT.byteOffset(PATH$pAcquireSyncs);
    public static final long OFFSET$pAcquireKeys = LAYOUT.byteOffset(PATH$pAcquireKeys);
    public static final long OFFSET$pAcquireTimeoutMilliseconds = LAYOUT.byteOffset(PATH$pAcquireTimeoutMilliseconds);
    public static final long OFFSET$releaseCount = LAYOUT.byteOffset(PATH$releaseCount);
    public static final long OFFSET$pReleaseSyncs = LAYOUT.byteOffset(PATH$pReleaseSyncs);
    public static final long OFFSET$pReleaseKeys = LAYOUT.byteOffset(PATH$pReleaseKeys);
}
