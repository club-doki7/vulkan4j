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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkShadingRatePaletteNV.html"><code>VkShadingRatePaletteNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkShadingRatePaletteNV {
///     uint32_t shadingRatePaletteEntryCount; // @link substring="shadingRatePaletteEntryCount" target="#shadingRatePaletteEntryCount"
///     VkShadingRatePaletteEntryNV const* pShadingRatePaletteEntries; // @link substring="VkShadingRatePaletteEntryNV" target="VkShadingRatePaletteEntryNV" @link substring="pShadingRatePaletteEntries" target="#pShadingRatePaletteEntries"
/// } VkShadingRatePaletteNV;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkShadingRatePaletteNV.html"><code>VkShadingRatePaletteNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkShadingRatePaletteNV(@NotNull MemorySegment segment) implements IVkShadingRatePaletteNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkShadingRatePaletteNV.html"><code>VkShadingRatePaletteNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkShadingRatePaletteNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkShadingRatePaletteNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkShadingRatePaletteNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkShadingRatePaletteNV, Iterable<VkShadingRatePaletteNV> {
        public long size() {
            return segment.byteSize() / VkShadingRatePaletteNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkShadingRatePaletteNV at(long index) {
            return new VkShadingRatePaletteNV(segment.asSlice(index * VkShadingRatePaletteNV.BYTES, VkShadingRatePaletteNV.BYTES));
        }

        public VkShadingRatePaletteNV.Ptr at(long index, @NotNull Consumer<@NotNull VkShadingRatePaletteNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkShadingRatePaletteNV value) {
            MemorySegment s = segment.asSlice(index * VkShadingRatePaletteNV.BYTES, VkShadingRatePaletteNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkShadingRatePaletteNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkShadingRatePaletteNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkShadingRatePaletteNV.BYTES,
                (end - start) * VkShadingRatePaletteNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkShadingRatePaletteNV.BYTES));
        }

        public VkShadingRatePaletteNV[] toArray() {
            VkShadingRatePaletteNV[] ret = new VkShadingRatePaletteNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkShadingRatePaletteNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkShadingRatePaletteNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkShadingRatePaletteNV.BYTES;
            }

            @Override
            public VkShadingRatePaletteNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkShadingRatePaletteNV ret = new VkShadingRatePaletteNV(segment.asSlice(0, VkShadingRatePaletteNV.BYTES));
                segment = segment.asSlice(VkShadingRatePaletteNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkShadingRatePaletteNV allocate(Arena arena) {
        return new VkShadingRatePaletteNV(arena.allocate(LAYOUT));
    }

    public static VkShadingRatePaletteNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkShadingRatePaletteNV.Ptr(segment);
    }

    public static VkShadingRatePaletteNV clone(Arena arena, VkShadingRatePaletteNV src) {
        VkShadingRatePaletteNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned int shadingRatePaletteEntryCount() {
        return segment.get(LAYOUT$shadingRatePaletteEntryCount, OFFSET$shadingRatePaletteEntryCount);
    }

    public VkShadingRatePaletteNV shadingRatePaletteEntryCount(@Unsigned int value) {
        segment.set(LAYOUT$shadingRatePaletteEntryCount, OFFSET$shadingRatePaletteEntryCount, value);
        return this;
    }


    /// Note: the returned {@link IntPtr} does not have correct
    /// {@link IntPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link IntPtr#reinterpret} to set the size before actually reading fro
    /// or writing to the buffer.
    public @Nullable @EnumType(VkShadingRatePaletteEntryNV.class) IntPtr pShadingRatePaletteEntries() {
        MemorySegment s = pShadingRatePaletteEntriesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new IntPtr(s);
    }

    public VkShadingRatePaletteNV pShadingRatePaletteEntries(@Nullable @EnumType(VkShadingRatePaletteEntryNV.class) IntPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pShadingRatePaletteEntriesRaw(s);
        return this;
    }

    public @Pointer(target=VkShadingRatePaletteEntryNV.class) @NotNull MemorySegment pShadingRatePaletteEntriesRaw() {
        return segment.get(LAYOUT$pShadingRatePaletteEntries, OFFSET$pShadingRatePaletteEntries);
    }

    public void pShadingRatePaletteEntriesRaw(@Pointer(target=VkShadingRatePaletteEntryNV.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pShadingRatePaletteEntries, OFFSET$pShadingRatePaletteEntries, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("shadingRatePaletteEntryCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pShadingRatePaletteEntries")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$shadingRatePaletteEntryCount = PathElement.groupElement("shadingRatePaletteEntryCount");
    public static final PathElement PATH$pShadingRatePaletteEntries = PathElement.groupElement("pShadingRatePaletteEntries");

    public static final OfInt LAYOUT$shadingRatePaletteEntryCount = (OfInt) LAYOUT.select(PATH$shadingRatePaletteEntryCount);
    public static final AddressLayout LAYOUT$pShadingRatePaletteEntries = (AddressLayout) LAYOUT.select(PATH$pShadingRatePaletteEntries);

    public static final long SIZE$shadingRatePaletteEntryCount = LAYOUT$shadingRatePaletteEntryCount.byteSize();
    public static final long SIZE$pShadingRatePaletteEntries = LAYOUT$pShadingRatePaletteEntries.byteSize();

    public static final long OFFSET$shadingRatePaletteEntryCount = LAYOUT.byteOffset(PATH$shadingRatePaletteEntryCount);
    public static final long OFFSET$pShadingRatePaletteEntries = LAYOUT.byteOffset(PATH$pShadingRatePaletteEntries);
}
