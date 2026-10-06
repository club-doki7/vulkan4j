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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSpecializationInfo.html"><code>VkSpecializationInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkSpecializationInfo {
///     uint32_t mapEntryCount; // optional // @link substring="mapEntryCount" target="#mapEntryCount"
///     VkSpecializationMapEntry const* pMapEntries; // optional // @link substring="VkSpecializationMapEntry" target="VkSpecializationMapEntry" @link substring="pMapEntries" target="#pMapEntries"
///     size_t dataSize; // optional // @link substring="dataSize" target="#dataSize"
///     void const* pData; // optional // @link substring="pData" target="#pData"
/// } VkSpecializationInfo;
/// }
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSpecializationInfo.html"><code>VkSpecializationInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkSpecializationInfo(@NotNull MemorySegment segment) implements IVkSpecializationInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSpecializationInfo.html"><code>VkSpecializationInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkSpecializationInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkSpecializationInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkSpecializationInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkSpecializationInfo, Iterable<VkSpecializationInfo> {
        public long size() {
            return segment.byteSize() / VkSpecializationInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkSpecializationInfo at(long index) {
            return new VkSpecializationInfo(segment.asSlice(index * VkSpecializationInfo.BYTES, VkSpecializationInfo.BYTES));
        }

        public VkSpecializationInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkSpecializationInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkSpecializationInfo value) {
            MemorySegment s = segment.asSlice(index * VkSpecializationInfo.BYTES, VkSpecializationInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkSpecializationInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkSpecializationInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkSpecializationInfo.BYTES,
                (end - start) * VkSpecializationInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkSpecializationInfo.BYTES));
        }

        public VkSpecializationInfo[] toArray() {
            VkSpecializationInfo[] ret = new VkSpecializationInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkSpecializationInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkSpecializationInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkSpecializationInfo.BYTES;
            }

            @Override
            public VkSpecializationInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkSpecializationInfo ret = new VkSpecializationInfo(segment.asSlice(0, VkSpecializationInfo.BYTES));
                segment = segment.asSlice(VkSpecializationInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkSpecializationInfo allocate(Arena arena) {
        return new VkSpecializationInfo(arena.allocate(LAYOUT));
    }

    public static VkSpecializationInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkSpecializationInfo.Ptr(segment);
    }

    public static VkSpecializationInfo clone(Arena arena, VkSpecializationInfo src) {
        VkSpecializationInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned int mapEntryCount() {
        return segment.get(LAYOUT$mapEntryCount, OFFSET$mapEntryCount);
    }

    public VkSpecializationInfo mapEntryCount(@Unsigned int value) {
        segment.set(LAYOUT$mapEntryCount, OFFSET$mapEntryCount, value);
        return this;
    }

    public VkSpecializationInfo pMapEntries(@Nullable IVkSpecializationMapEntry value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pMapEntriesRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkSpecializationMapEntry.Ptr pMapEntries(int assumedCount) {
        MemorySegment s = pMapEntriesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkSpecializationMapEntry.BYTES);
        return new VkSpecializationMapEntry.Ptr(s);
    }

    public @Nullable VkSpecializationMapEntry pMapEntries() {
        MemorySegment s = pMapEntriesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkSpecializationMapEntry(s);
    }

    public @Pointer(target=VkSpecializationMapEntry.class) @NotNull MemorySegment pMapEntriesRaw() {
        return segment.get(LAYOUT$pMapEntries, OFFSET$pMapEntries);
    }

    public void pMapEntriesRaw(@Pointer(target=VkSpecializationMapEntry.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pMapEntries, OFFSET$pMapEntries, value);
    }

    public @Unsigned long dataSize() {
        return NativeLayout.readCSizeT(segment, OFFSET$dataSize);
    }

    public VkSpecializationInfo dataSize(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$dataSize, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pData() {
        return segment.get(LAYOUT$pData, OFFSET$pData);
    }

    public VkSpecializationInfo pData(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pData, OFFSET$pData, value);
        return this;
    }

    public VkSpecializationInfo pData(@Nullable IPointer pointer) {
        pData(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("mapEntryCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkSpecializationMapEntry.LAYOUT).withName("pMapEntries"),
        NativeLayout.C_SIZE_T.withName("dataSize"),
        ValueLayout.ADDRESS.withName("pData")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$mapEntryCount = PathElement.groupElement("mapEntryCount");
    public static final PathElement PATH$pMapEntries = PathElement.groupElement("pMapEntries");
    public static final PathElement PATH$dataSize = PathElement.groupElement("dataSize");
    public static final PathElement PATH$pData = PathElement.groupElement("pData");

    public static final OfInt LAYOUT$mapEntryCount = (OfInt) LAYOUT.select(PATH$mapEntryCount);
    public static final AddressLayout LAYOUT$pMapEntries = (AddressLayout) LAYOUT.select(PATH$pMapEntries);
    public static final AddressLayout LAYOUT$pData = (AddressLayout) LAYOUT.select(PATH$pData);

    public static final long SIZE$mapEntryCount = LAYOUT$mapEntryCount.byteSize();
    public static final long SIZE$pMapEntries = LAYOUT$pMapEntries.byteSize();
    public static final long SIZE$dataSize = NativeLayout.C_SIZE_T.byteSize();
    public static final long SIZE$pData = LAYOUT$pData.byteSize();

    public static final long OFFSET$mapEntryCount = LAYOUT.byteOffset(PATH$mapEntryCount);
    public static final long OFFSET$pMapEntries = LAYOUT.byteOffset(PATH$pMapEntries);
    public static final long OFFSET$dataSize = LAYOUT.byteOffset(PATH$dataSize);
    public static final long OFFSET$pData = LAYOUT.byteOffset(PATH$pData);
}
