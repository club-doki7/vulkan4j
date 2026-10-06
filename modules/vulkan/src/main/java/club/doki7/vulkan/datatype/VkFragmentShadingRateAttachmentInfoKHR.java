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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkFragmentShadingRateAttachmentInfoKHR.html"><code>VkFragmentShadingRateAttachmentInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkFragmentShadingRateAttachmentInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkAttachmentReference2 const* pFragmentShadingRateAttachment; // optional // @link substring="VkAttachmentReference2" target="VkAttachmentReference2" @link substring="pFragmentShadingRateAttachment" target="#pFragmentShadingRateAttachment"
///     VkExtent2D shadingRateAttachmentTexelSize; // @link substring="VkExtent2D" target="VkExtent2D" @link substring="shadingRateAttachmentTexelSize" target="#shadingRateAttachmentTexelSize"
/// } VkFragmentShadingRateAttachmentInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_FRAGMENT_SHADING_RATE_ATTACHMENT_INFO_KHR`
///
/// The {@code allocate} ({@link VkFragmentShadingRateAttachmentInfoKHR#allocate(Arena)}, {@link VkFragmentShadingRateAttachmentInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkFragmentShadingRateAttachmentInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkFragmentShadingRateAttachmentInfoKHR.html"><code>VkFragmentShadingRateAttachmentInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkFragmentShadingRateAttachmentInfoKHR(@NotNull MemorySegment segment) implements IVkFragmentShadingRateAttachmentInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkFragmentShadingRateAttachmentInfoKHR.html"><code>VkFragmentShadingRateAttachmentInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkFragmentShadingRateAttachmentInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkFragmentShadingRateAttachmentInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkFragmentShadingRateAttachmentInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkFragmentShadingRateAttachmentInfoKHR, Iterable<VkFragmentShadingRateAttachmentInfoKHR> {
        public long size() {
            return segment.byteSize() / VkFragmentShadingRateAttachmentInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkFragmentShadingRateAttachmentInfoKHR at(long index) {
            return new VkFragmentShadingRateAttachmentInfoKHR(segment.asSlice(index * VkFragmentShadingRateAttachmentInfoKHR.BYTES, VkFragmentShadingRateAttachmentInfoKHR.BYTES));
        }

        public VkFragmentShadingRateAttachmentInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkFragmentShadingRateAttachmentInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkFragmentShadingRateAttachmentInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkFragmentShadingRateAttachmentInfoKHR.BYTES, VkFragmentShadingRateAttachmentInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkFragmentShadingRateAttachmentInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkFragmentShadingRateAttachmentInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkFragmentShadingRateAttachmentInfoKHR.BYTES,
                (end - start) * VkFragmentShadingRateAttachmentInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkFragmentShadingRateAttachmentInfoKHR.BYTES));
        }

        public VkFragmentShadingRateAttachmentInfoKHR[] toArray() {
            VkFragmentShadingRateAttachmentInfoKHR[] ret = new VkFragmentShadingRateAttachmentInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkFragmentShadingRateAttachmentInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkFragmentShadingRateAttachmentInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkFragmentShadingRateAttachmentInfoKHR.BYTES;
            }

            @Override
            public VkFragmentShadingRateAttachmentInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkFragmentShadingRateAttachmentInfoKHR ret = new VkFragmentShadingRateAttachmentInfoKHR(segment.asSlice(0, VkFragmentShadingRateAttachmentInfoKHR.BYTES));
                segment = segment.asSlice(VkFragmentShadingRateAttachmentInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkFragmentShadingRateAttachmentInfoKHR allocate(Arena arena) {
        VkFragmentShadingRateAttachmentInfoKHR ret = new VkFragmentShadingRateAttachmentInfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.FRAGMENT_SHADING_RATE_ATTACHMENT_INFO_KHR);
        return ret;
    }

    public static VkFragmentShadingRateAttachmentInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkFragmentShadingRateAttachmentInfoKHR.Ptr ret = new VkFragmentShadingRateAttachmentInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.FRAGMENT_SHADING_RATE_ATTACHMENT_INFO_KHR);
        }
        return ret;
    }

    public static VkFragmentShadingRateAttachmentInfoKHR clone(Arena arena, VkFragmentShadingRateAttachmentInfoKHR src) {
        VkFragmentShadingRateAttachmentInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.FRAGMENT_SHADING_RATE_ATTACHMENT_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkFragmentShadingRateAttachmentInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkFragmentShadingRateAttachmentInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkFragmentShadingRateAttachmentInfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public VkFragmentShadingRateAttachmentInfoKHR pFragmentShadingRateAttachment(@Nullable IVkAttachmentReference2 value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pFragmentShadingRateAttachmentRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkAttachmentReference2.Ptr pFragmentShadingRateAttachment(int assumedCount) {
        MemorySegment s = pFragmentShadingRateAttachmentRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkAttachmentReference2.BYTES);
        return new VkAttachmentReference2.Ptr(s);
    }

    public @Nullable VkAttachmentReference2 pFragmentShadingRateAttachment() {
        MemorySegment s = pFragmentShadingRateAttachmentRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkAttachmentReference2(s);
    }

    public @Pointer(target=VkAttachmentReference2.class) @NotNull MemorySegment pFragmentShadingRateAttachmentRaw() {
        return segment.get(LAYOUT$pFragmentShadingRateAttachment, OFFSET$pFragmentShadingRateAttachment);
    }

    public void pFragmentShadingRateAttachmentRaw(@Pointer(target=VkAttachmentReference2.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pFragmentShadingRateAttachment, OFFSET$pFragmentShadingRateAttachment, value);
    }

    public @NotNull VkExtent2D shadingRateAttachmentTexelSize() {
        return new VkExtent2D(segment.asSlice(OFFSET$shadingRateAttachmentTexelSize, LAYOUT$shadingRateAttachmentTexelSize));
    }

    public VkFragmentShadingRateAttachmentInfoKHR shadingRateAttachmentTexelSize(@NotNull VkExtent2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$shadingRateAttachmentTexelSize, SIZE$shadingRateAttachmentTexelSize);
        return this;
    }

    public VkFragmentShadingRateAttachmentInfoKHR shadingRateAttachmentTexelSize(Consumer<@NotNull VkExtent2D> consumer) {
        consumer.accept(shadingRateAttachmentTexelSize());
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withTargetLayout(VkAttachmentReference2.LAYOUT).withName("pFragmentShadingRateAttachment"),
        VkExtent2D.LAYOUT.withName("shadingRateAttachmentTexelSize")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$pFragmentShadingRateAttachment = PathElement.groupElement("pFragmentShadingRateAttachment");
    public static final PathElement PATH$shadingRateAttachmentTexelSize = PathElement.groupElement("shadingRateAttachmentTexelSize");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$pFragmentShadingRateAttachment = (AddressLayout) LAYOUT.select(PATH$pFragmentShadingRateAttachment);
    public static final StructLayout LAYOUT$shadingRateAttachmentTexelSize = (StructLayout) LAYOUT.select(PATH$shadingRateAttachmentTexelSize);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$pFragmentShadingRateAttachment = LAYOUT$pFragmentShadingRateAttachment.byteSize();
    public static final long SIZE$shadingRateAttachmentTexelSize = LAYOUT$shadingRateAttachmentTexelSize.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$pFragmentShadingRateAttachment = LAYOUT.byteOffset(PATH$pFragmentShadingRateAttachment);
    public static final long OFFSET$shadingRateAttachmentTexelSize = LAYOUT.byteOffset(PATH$shadingRateAttachmentTexelSize);
}
