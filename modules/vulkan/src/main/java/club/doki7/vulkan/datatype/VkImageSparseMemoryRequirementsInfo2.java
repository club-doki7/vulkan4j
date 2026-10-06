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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageSparseMemoryRequirementsInfo2.html"><code>VkImageSparseMemoryRequirementsInfo2</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkImageSparseMemoryRequirementsInfo2 {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkImage image; // @link substring="VkImage" target="VkImage" @link substring="image" target="#image"
/// } VkImageSparseMemoryRequirementsInfo2;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_IMAGE_SPARSE_MEMORY_REQUIREMENTS_INFO_2`
///
/// The {@code allocate} ({@link VkImageSparseMemoryRequirementsInfo2#allocate(Arena)}, {@link VkImageSparseMemoryRequirementsInfo2#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkImageSparseMemoryRequirementsInfo2#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageSparseMemoryRequirementsInfo2.html"><code>VkImageSparseMemoryRequirementsInfo2</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkImageSparseMemoryRequirementsInfo2(@NotNull MemorySegment segment) implements IVkImageSparseMemoryRequirementsInfo2 {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageSparseMemoryRequirementsInfo2.html"><code>VkImageSparseMemoryRequirementsInfo2</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkImageSparseMemoryRequirementsInfo2}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkImageSparseMemoryRequirementsInfo2 to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkImageSparseMemoryRequirementsInfo2.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkImageSparseMemoryRequirementsInfo2, Iterable<VkImageSparseMemoryRequirementsInfo2> {
        public long size() {
            return segment.byteSize() / VkImageSparseMemoryRequirementsInfo2.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkImageSparseMemoryRequirementsInfo2 at(long index) {
            return new VkImageSparseMemoryRequirementsInfo2(segment.asSlice(index * VkImageSparseMemoryRequirementsInfo2.BYTES, VkImageSparseMemoryRequirementsInfo2.BYTES));
        }

        public VkImageSparseMemoryRequirementsInfo2.Ptr at(long index, @NotNull Consumer<@NotNull VkImageSparseMemoryRequirementsInfo2> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkImageSparseMemoryRequirementsInfo2 value) {
            MemorySegment s = segment.asSlice(index * VkImageSparseMemoryRequirementsInfo2.BYTES, VkImageSparseMemoryRequirementsInfo2.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkImageSparseMemoryRequirementsInfo2.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkImageSparseMemoryRequirementsInfo2.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkImageSparseMemoryRequirementsInfo2.BYTES,
                (end - start) * VkImageSparseMemoryRequirementsInfo2.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkImageSparseMemoryRequirementsInfo2.BYTES));
        }

        public VkImageSparseMemoryRequirementsInfo2[] toArray() {
            VkImageSparseMemoryRequirementsInfo2[] ret = new VkImageSparseMemoryRequirementsInfo2[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkImageSparseMemoryRequirementsInfo2> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkImageSparseMemoryRequirementsInfo2> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkImageSparseMemoryRequirementsInfo2.BYTES;
            }

            @Override
            public VkImageSparseMemoryRequirementsInfo2 next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkImageSparseMemoryRequirementsInfo2 ret = new VkImageSparseMemoryRequirementsInfo2(segment.asSlice(0, VkImageSparseMemoryRequirementsInfo2.BYTES));
                segment = segment.asSlice(VkImageSparseMemoryRequirementsInfo2.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkImageSparseMemoryRequirementsInfo2 allocate(Arena arena) {
        VkImageSparseMemoryRequirementsInfo2 ret = new VkImageSparseMemoryRequirementsInfo2(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.IMAGE_SPARSE_MEMORY_REQUIREMENTS_INFO_2);
        return ret;
    }

    public static VkImageSparseMemoryRequirementsInfo2.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkImageSparseMemoryRequirementsInfo2.Ptr ret = new VkImageSparseMemoryRequirementsInfo2.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.IMAGE_SPARSE_MEMORY_REQUIREMENTS_INFO_2);
        }
        return ret;
    }

    public static VkImageSparseMemoryRequirementsInfo2 clone(Arena arena, VkImageSparseMemoryRequirementsInfo2 src) {
        VkImageSparseMemoryRequirementsInfo2 ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.IMAGE_SPARSE_MEMORY_REQUIREMENTS_INFO_2);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkImageSparseMemoryRequirementsInfo2 sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkImageSparseMemoryRequirementsInfo2 pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkImageSparseMemoryRequirementsInfo2 pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Nullable VkImage image() {
        MemorySegment s = segment.asSlice(OFFSET$image, SIZE$image);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkImage(s);
    }

    public VkImageSparseMemoryRequirementsInfo2 image(@Nullable VkImage value) {
        segment.set(LAYOUT$image, OFFSET$image, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withName("image")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$image = PathElement.groupElement("image");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$image = (AddressLayout) LAYOUT.select(PATH$image);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$image = LAYOUT$image.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$image = LAYOUT.byteOffset(PATH$image);
}
