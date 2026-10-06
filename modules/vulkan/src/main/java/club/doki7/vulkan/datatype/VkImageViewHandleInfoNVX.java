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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageViewHandleInfoNVX.html"><code>VkImageViewHandleInfoNVX</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkImageViewHandleInfoNVX {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkImageView imageView; // @link substring="VkImageView" target="VkImageView" @link substring="imageView" target="#imageView"
///     VkDescriptorType descriptorType; // @link substring="VkDescriptorType" target="VkDescriptorType" @link substring="descriptorType" target="#descriptorType"
///     VkSampler sampler; // optional // @link substring="VkSampler" target="VkSampler" @link substring="sampler" target="#sampler"
/// } VkImageViewHandleInfoNVX;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_IMAGE_VIEW_HANDLE_INFO_NVX`
///
/// The {@code allocate} ({@link VkImageViewHandleInfoNVX#allocate(Arena)}, {@link VkImageViewHandleInfoNVX#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkImageViewHandleInfoNVX#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageViewHandleInfoNVX.html"><code>VkImageViewHandleInfoNVX</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkImageViewHandleInfoNVX(@NotNull MemorySegment segment) implements IVkImageViewHandleInfoNVX {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageViewHandleInfoNVX.html"><code>VkImageViewHandleInfoNVX</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkImageViewHandleInfoNVX}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkImageViewHandleInfoNVX to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkImageViewHandleInfoNVX.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkImageViewHandleInfoNVX, Iterable<VkImageViewHandleInfoNVX> {
        public long size() {
            return segment.byteSize() / VkImageViewHandleInfoNVX.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkImageViewHandleInfoNVX at(long index) {
            return new VkImageViewHandleInfoNVX(segment.asSlice(index * VkImageViewHandleInfoNVX.BYTES, VkImageViewHandleInfoNVX.BYTES));
        }

        public VkImageViewHandleInfoNVX.Ptr at(long index, @NotNull Consumer<@NotNull VkImageViewHandleInfoNVX> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkImageViewHandleInfoNVX value) {
            MemorySegment s = segment.asSlice(index * VkImageViewHandleInfoNVX.BYTES, VkImageViewHandleInfoNVX.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkImageViewHandleInfoNVX.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkImageViewHandleInfoNVX.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkImageViewHandleInfoNVX.BYTES,
                (end - start) * VkImageViewHandleInfoNVX.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkImageViewHandleInfoNVX.BYTES));
        }

        public VkImageViewHandleInfoNVX[] toArray() {
            VkImageViewHandleInfoNVX[] ret = new VkImageViewHandleInfoNVX[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkImageViewHandleInfoNVX> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkImageViewHandleInfoNVX> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkImageViewHandleInfoNVX.BYTES;
            }

            @Override
            public VkImageViewHandleInfoNVX next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkImageViewHandleInfoNVX ret = new VkImageViewHandleInfoNVX(segment.asSlice(0, VkImageViewHandleInfoNVX.BYTES));
                segment = segment.asSlice(VkImageViewHandleInfoNVX.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkImageViewHandleInfoNVX allocate(Arena arena) {
        VkImageViewHandleInfoNVX ret = new VkImageViewHandleInfoNVX(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.IMAGE_VIEW_HANDLE_INFO_NVX);
        return ret;
    }

    public static VkImageViewHandleInfoNVX.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkImageViewHandleInfoNVX.Ptr ret = new VkImageViewHandleInfoNVX.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.IMAGE_VIEW_HANDLE_INFO_NVX);
        }
        return ret;
    }

    public static VkImageViewHandleInfoNVX clone(Arena arena, VkImageViewHandleInfoNVX src) {
        VkImageViewHandleInfoNVX ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.IMAGE_VIEW_HANDLE_INFO_NVX);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkImageViewHandleInfoNVX sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkImageViewHandleInfoNVX pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkImageViewHandleInfoNVX pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Nullable VkImageView imageView() {
        MemorySegment s = segment.asSlice(OFFSET$imageView, SIZE$imageView);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkImageView(s);
    }

    public VkImageViewHandleInfoNVX imageView(@Nullable VkImageView value) {
        segment.set(LAYOUT$imageView, OFFSET$imageView, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @EnumType(VkDescriptorType.class) int descriptorType() {
        return segment.get(LAYOUT$descriptorType, OFFSET$descriptorType);
    }

    public VkImageViewHandleInfoNVX descriptorType(@EnumType(VkDescriptorType.class) int value) {
        segment.set(LAYOUT$descriptorType, OFFSET$descriptorType, value);
        return this;
    }

    public @Nullable VkSampler sampler() {
        MemorySegment s = segment.asSlice(OFFSET$sampler, SIZE$sampler);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkSampler(s);
    }

    public VkImageViewHandleInfoNVX sampler(@Nullable VkSampler value) {
        segment.set(LAYOUT$sampler, OFFSET$sampler, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withName("imageView"),
        ValueLayout.JAVA_INT.withName("descriptorType"),
        ValueLayout.ADDRESS.withName("sampler")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$imageView = PathElement.groupElement("imageView");
    public static final PathElement PATH$descriptorType = PathElement.groupElement("descriptorType");
    public static final PathElement PATH$sampler = PathElement.groupElement("sampler");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$imageView = (AddressLayout) LAYOUT.select(PATH$imageView);
    public static final OfInt LAYOUT$descriptorType = (OfInt) LAYOUT.select(PATH$descriptorType);
    public static final AddressLayout LAYOUT$sampler = (AddressLayout) LAYOUT.select(PATH$sampler);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$imageView = LAYOUT$imageView.byteSize();
    public static final long SIZE$descriptorType = LAYOUT$descriptorType.byteSize();
    public static final long SIZE$sampler = LAYOUT$sampler.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$imageView = LAYOUT.byteOffset(PATH$imageView);
    public static final long OFFSET$descriptorType = LAYOUT.byteOffset(PATH$descriptorType);
    public static final long OFFSET$sampler = LAYOUT.byteOffset(PATH$sampler);
}
