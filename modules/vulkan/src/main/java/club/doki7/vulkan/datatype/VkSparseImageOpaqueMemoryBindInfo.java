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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSparseImageOpaqueMemoryBindInfo.html"><code>VkSparseImageOpaqueMemoryBindInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkSparseImageOpaqueMemoryBindInfo {
///     VkImage image; // @link substring="VkImage" target="VkImage" @link substring="image" target="#image"
///     uint32_t bindCount; // @link substring="bindCount" target="#bindCount"
///     VkSparseMemoryBind const* pBinds; // @link substring="VkSparseMemoryBind" target="VkSparseMemoryBind" @link substring="pBinds" target="#pBinds"
/// } VkSparseImageOpaqueMemoryBindInfo;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSparseImageOpaqueMemoryBindInfo.html"><code>VkSparseImageOpaqueMemoryBindInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkSparseImageOpaqueMemoryBindInfo(@NotNull MemorySegment segment) implements IVkSparseImageOpaqueMemoryBindInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSparseImageOpaqueMemoryBindInfo.html"><code>VkSparseImageOpaqueMemoryBindInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkSparseImageOpaqueMemoryBindInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkSparseImageOpaqueMemoryBindInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkSparseImageOpaqueMemoryBindInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkSparseImageOpaqueMemoryBindInfo, Iterable<VkSparseImageOpaqueMemoryBindInfo> {
        public long size() {
            return segment.byteSize() / VkSparseImageOpaqueMemoryBindInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkSparseImageOpaqueMemoryBindInfo at(long index) {
            return new VkSparseImageOpaqueMemoryBindInfo(segment.asSlice(index * VkSparseImageOpaqueMemoryBindInfo.BYTES, VkSparseImageOpaqueMemoryBindInfo.BYTES));
        }

        public VkSparseImageOpaqueMemoryBindInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkSparseImageOpaqueMemoryBindInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkSparseImageOpaqueMemoryBindInfo value) {
            MemorySegment s = segment.asSlice(index * VkSparseImageOpaqueMemoryBindInfo.BYTES, VkSparseImageOpaqueMemoryBindInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkSparseImageOpaqueMemoryBindInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkSparseImageOpaqueMemoryBindInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkSparseImageOpaqueMemoryBindInfo.BYTES,
                (end - start) * VkSparseImageOpaqueMemoryBindInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkSparseImageOpaqueMemoryBindInfo.BYTES));
        }

        public VkSparseImageOpaqueMemoryBindInfo[] toArray() {
            VkSparseImageOpaqueMemoryBindInfo[] ret = new VkSparseImageOpaqueMemoryBindInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkSparseImageOpaqueMemoryBindInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkSparseImageOpaqueMemoryBindInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkSparseImageOpaqueMemoryBindInfo.BYTES;
            }

            @Override
            public VkSparseImageOpaqueMemoryBindInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkSparseImageOpaqueMemoryBindInfo ret = new VkSparseImageOpaqueMemoryBindInfo(segment.asSlice(0, VkSparseImageOpaqueMemoryBindInfo.BYTES));
                segment = segment.asSlice(VkSparseImageOpaqueMemoryBindInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkSparseImageOpaqueMemoryBindInfo allocate(Arena arena) {
        return new VkSparseImageOpaqueMemoryBindInfo(arena.allocate(LAYOUT));
    }

    public static VkSparseImageOpaqueMemoryBindInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkSparseImageOpaqueMemoryBindInfo.Ptr(segment);
    }

    public static VkSparseImageOpaqueMemoryBindInfo clone(Arena arena, VkSparseImageOpaqueMemoryBindInfo src) {
        VkSparseImageOpaqueMemoryBindInfo ret = allocate(arena);
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

    public VkSparseImageOpaqueMemoryBindInfo image(@Nullable VkImage value) {
        segment.set(LAYOUT$image, OFFSET$image, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int bindCount() {
        return segment.get(LAYOUT$bindCount, OFFSET$bindCount);
    }

    public VkSparseImageOpaqueMemoryBindInfo bindCount(@Unsigned int value) {
        segment.set(LAYOUT$bindCount, OFFSET$bindCount, value);
        return this;
    }

    public VkSparseImageOpaqueMemoryBindInfo pBinds(@Nullable IVkSparseMemoryBind value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pBindsRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkSparseMemoryBind.Ptr pBinds(int assumedCount) {
        MemorySegment s = pBindsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkSparseMemoryBind.BYTES);
        return new VkSparseMemoryBind.Ptr(s);
    }

    public @Nullable VkSparseMemoryBind pBinds() {
        MemorySegment s = pBindsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkSparseMemoryBind(s);
    }

    public @Pointer(target=VkSparseMemoryBind.class) @NotNull MemorySegment pBindsRaw() {
        return segment.get(LAYOUT$pBinds, OFFSET$pBinds);
    }

    public void pBindsRaw(@Pointer(target=VkSparseMemoryBind.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pBinds, OFFSET$pBinds, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.ADDRESS.withName("image"),
        ValueLayout.JAVA_INT.withName("bindCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkSparseMemoryBind.LAYOUT).withName("pBinds")
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
