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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSparseImageMemoryBindInfo.html"><code>VkSparseImageMemoryBindInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkSparseImageMemoryBindInfo {
///     VkImage image; // @link substring="VkImage" target="VkImage" @link substring="image" target="#image"
///     uint32_t bindCount; // @link substring="bindCount" target="#bindCount"
///     VkSparseImageMemoryBind const* pBinds; // @link substring="VkSparseImageMemoryBind" target="VkSparseImageMemoryBind" @link substring="pBinds" target="#pBinds"
/// } VkSparseImageMemoryBindInfo;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSparseImageMemoryBindInfo.html"><code>VkSparseImageMemoryBindInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkSparseImageMemoryBindInfo(@NotNull MemorySegment segment) implements IVkSparseImageMemoryBindInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSparseImageMemoryBindInfo.html"><code>VkSparseImageMemoryBindInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkSparseImageMemoryBindInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkSparseImageMemoryBindInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkSparseImageMemoryBindInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkSparseImageMemoryBindInfo, Iterable<VkSparseImageMemoryBindInfo> {
        public long size() {
            return segment.byteSize() / VkSparseImageMemoryBindInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkSparseImageMemoryBindInfo at(long index) {
            return new VkSparseImageMemoryBindInfo(segment.asSlice(index * VkSparseImageMemoryBindInfo.BYTES, VkSparseImageMemoryBindInfo.BYTES));
        }

        public VkSparseImageMemoryBindInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkSparseImageMemoryBindInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkSparseImageMemoryBindInfo value) {
            MemorySegment s = segment.asSlice(index * VkSparseImageMemoryBindInfo.BYTES, VkSparseImageMemoryBindInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkSparseImageMemoryBindInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkSparseImageMemoryBindInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkSparseImageMemoryBindInfo.BYTES,
                (end - start) * VkSparseImageMemoryBindInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkSparseImageMemoryBindInfo.BYTES));
        }

        public VkSparseImageMemoryBindInfo[] toArray() {
            VkSparseImageMemoryBindInfo[] ret = new VkSparseImageMemoryBindInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkSparseImageMemoryBindInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkSparseImageMemoryBindInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkSparseImageMemoryBindInfo.BYTES;
            }

            @Override
            public VkSparseImageMemoryBindInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkSparseImageMemoryBindInfo ret = new VkSparseImageMemoryBindInfo(segment.asSlice(0, VkSparseImageMemoryBindInfo.BYTES));
                segment = segment.asSlice(VkSparseImageMemoryBindInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkSparseImageMemoryBindInfo allocate(Arena arena) {
        return new VkSparseImageMemoryBindInfo(arena.allocate(LAYOUT));
    }

    public static VkSparseImageMemoryBindInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkSparseImageMemoryBindInfo.Ptr(segment);
    }

    public static VkSparseImageMemoryBindInfo clone(Arena arena, VkSparseImageMemoryBindInfo src) {
        VkSparseImageMemoryBindInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Nullable VkImage image() {
        MemorySegment s = segment.asSlice(OFFSET$image, SIZE$image);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkImage(s);
    }

    public VkSparseImageMemoryBindInfo image(@Nullable VkImage value) {
        segment.set(LAYOUT$image, OFFSET$image, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int bindCount() {
        return segment.get(LAYOUT$bindCount, OFFSET$bindCount);
    }

    public VkSparseImageMemoryBindInfo bindCount(@Unsigned int value) {
        segment.set(LAYOUT$bindCount, OFFSET$bindCount, value);
        return this;
    }

    public VkSparseImageMemoryBindInfo pBinds(@Nullable IVkSparseImageMemoryBind value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pBindsRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkSparseImageMemoryBind.Ptr pBinds(int assumedCount) {
        MemorySegment s = pBindsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkSparseImageMemoryBind.BYTES);
        return new VkSparseImageMemoryBind.Ptr(s);
    }

    public @Nullable VkSparseImageMemoryBind pBinds() {
        MemorySegment s = pBindsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkSparseImageMemoryBind(s);
    }

    public @Pointer(target=VkSparseImageMemoryBind.class) @NotNull MemorySegment pBindsRaw() {
        return segment.get(LAYOUT$pBinds, OFFSET$pBinds);
    }

    public void pBindsRaw(@Pointer(target=VkSparseImageMemoryBind.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pBinds, OFFSET$pBinds, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.ADDRESS.withName("image"),
        ValueLayout.JAVA_INT.withName("bindCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkSparseImageMemoryBind.LAYOUT).withName("pBinds")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$image = PathElement.groupElement("image");
    public static final PathElement PATH$bindCount = PathElement.groupElement("bindCount");
    public static final PathElement PATH$pBinds = PathElement.groupElement("pBinds");

    public static final AddressLayout LAYOUT$image = (AddressLayout) LAYOUT.select(PATH$image);
    public static final OfInt LAYOUT$bindCount = (OfInt) LAYOUT.select(PATH$bindCount);
    public static final AddressLayout LAYOUT$pBinds = (AddressLayout) LAYOUT.select(PATH$pBinds);

    public static final long SIZE$image = LAYOUT$image.byteSize();
    public static final long SIZE$bindCount = LAYOUT$bindCount.byteSize();
    public static final long SIZE$pBinds = LAYOUT$pBinds.byteSize();

    public static final long OFFSET$image = LAYOUT.byteOffset(PATH$image);
    public static final long OFFSET$bindCount = LAYOUT.byteOffset(PATH$bindCount);
    public static final long OFFSET$pBinds = LAYOUT.byteOffset(PATH$pBinds);
}
