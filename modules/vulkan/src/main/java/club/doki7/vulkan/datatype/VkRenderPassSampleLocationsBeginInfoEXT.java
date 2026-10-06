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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRenderPassSampleLocationsBeginInfoEXT.html"><code>VkRenderPassSampleLocationsBeginInfoEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkRenderPassSampleLocationsBeginInfoEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t attachmentInitialSampleLocationsCount; // optional // @link substring="attachmentInitialSampleLocationsCount" target="#attachmentInitialSampleLocationsCount"
///     VkAttachmentSampleLocationsEXT const* pAttachmentInitialSampleLocations; // optional // @link substring="VkAttachmentSampleLocationsEXT" target="VkAttachmentSampleLocationsEXT" @link substring="pAttachmentInitialSampleLocations" target="#pAttachmentInitialSampleLocations"
///     uint32_t postSubpassSampleLocationsCount; // optional // @link substring="postSubpassSampleLocationsCount" target="#postSubpassSampleLocationsCount"
///     VkSubpassSampleLocationsEXT const* pPostSubpassSampleLocations; // optional // @link substring="VkSubpassSampleLocationsEXT" target="VkSubpassSampleLocationsEXT" @link substring="pPostSubpassSampleLocations" target="#pPostSubpassSampleLocations"
/// } VkRenderPassSampleLocationsBeginInfoEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_RENDER_PASS_SAMPLE_LOCATIONS_BEGIN_INFO_EXT`
///
/// The {@code allocate} ({@link VkRenderPassSampleLocationsBeginInfoEXT#allocate(Arena)}, {@link VkRenderPassSampleLocationsBeginInfoEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkRenderPassSampleLocationsBeginInfoEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRenderPassSampleLocationsBeginInfoEXT.html"><code>VkRenderPassSampleLocationsBeginInfoEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkRenderPassSampleLocationsBeginInfoEXT(@NotNull MemorySegment segment) implements IVkRenderPassSampleLocationsBeginInfoEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkRenderPassSampleLocationsBeginInfoEXT.html"><code>VkRenderPassSampleLocationsBeginInfoEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkRenderPassSampleLocationsBeginInfoEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkRenderPassSampleLocationsBeginInfoEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkRenderPassSampleLocationsBeginInfoEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkRenderPassSampleLocationsBeginInfoEXT, Iterable<VkRenderPassSampleLocationsBeginInfoEXT> {
        public long size() {
            return segment.byteSize() / VkRenderPassSampleLocationsBeginInfoEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkRenderPassSampleLocationsBeginInfoEXT at(long index) {
            return new VkRenderPassSampleLocationsBeginInfoEXT(segment.asSlice(index * VkRenderPassSampleLocationsBeginInfoEXT.BYTES, VkRenderPassSampleLocationsBeginInfoEXT.BYTES));
        }

        public VkRenderPassSampleLocationsBeginInfoEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkRenderPassSampleLocationsBeginInfoEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkRenderPassSampleLocationsBeginInfoEXT value) {
            MemorySegment s = segment.asSlice(index * VkRenderPassSampleLocationsBeginInfoEXT.BYTES, VkRenderPassSampleLocationsBeginInfoEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkRenderPassSampleLocationsBeginInfoEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkRenderPassSampleLocationsBeginInfoEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkRenderPassSampleLocationsBeginInfoEXT.BYTES,
                (end - start) * VkRenderPassSampleLocationsBeginInfoEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkRenderPassSampleLocationsBeginInfoEXT.BYTES));
        }

        public VkRenderPassSampleLocationsBeginInfoEXT[] toArray() {
            VkRenderPassSampleLocationsBeginInfoEXT[] ret = new VkRenderPassSampleLocationsBeginInfoEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkRenderPassSampleLocationsBeginInfoEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkRenderPassSampleLocationsBeginInfoEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkRenderPassSampleLocationsBeginInfoEXT.BYTES;
            }

            @Override
            public VkRenderPassSampleLocationsBeginInfoEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkRenderPassSampleLocationsBeginInfoEXT ret = new VkRenderPassSampleLocationsBeginInfoEXT(segment.asSlice(0, VkRenderPassSampleLocationsBeginInfoEXT.BYTES));
                segment = segment.asSlice(VkRenderPassSampleLocationsBeginInfoEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkRenderPassSampleLocationsBeginInfoEXT allocate(Arena arena) {
        VkRenderPassSampleLocationsBeginInfoEXT ret = new VkRenderPassSampleLocationsBeginInfoEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.RENDER_PASS_SAMPLE_LOCATIONS_BEGIN_INFO_EXT);
        return ret;
    }

    public static VkRenderPassSampleLocationsBeginInfoEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkRenderPassSampleLocationsBeginInfoEXT.Ptr ret = new VkRenderPassSampleLocationsBeginInfoEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.RENDER_PASS_SAMPLE_LOCATIONS_BEGIN_INFO_EXT);
        }
        return ret;
    }

    public static VkRenderPassSampleLocationsBeginInfoEXT clone(Arena arena, VkRenderPassSampleLocationsBeginInfoEXT src) {
        VkRenderPassSampleLocationsBeginInfoEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.RENDER_PASS_SAMPLE_LOCATIONS_BEGIN_INFO_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkRenderPassSampleLocationsBeginInfoEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkRenderPassSampleLocationsBeginInfoEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkRenderPassSampleLocationsBeginInfoEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int attachmentInitialSampleLocationsCount() {
        return segment.get(LAYOUT$attachmentInitialSampleLocationsCount, OFFSET$attachmentInitialSampleLocationsCount);
    }

    public VkRenderPassSampleLocationsBeginInfoEXT attachmentInitialSampleLocationsCount(@Unsigned int value) {
        segment.set(LAYOUT$attachmentInitialSampleLocationsCount, OFFSET$attachmentInitialSampleLocationsCount, value);
        return this;
    }

    public VkRenderPassSampleLocationsBeginInfoEXT pAttachmentInitialSampleLocations(@Nullable IVkAttachmentSampleLocationsEXT value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pAttachmentInitialSampleLocationsRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkAttachmentSampleLocationsEXT.Ptr pAttachmentInitialSampleLocations(int assumedCount) {
        MemorySegment s = pAttachmentInitialSampleLocationsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkAttachmentSampleLocationsEXT.BYTES);
        return new VkAttachmentSampleLocationsEXT.Ptr(s);
    }

    public @Nullable VkAttachmentSampleLocationsEXT pAttachmentInitialSampleLocations() {
        MemorySegment s = pAttachmentInitialSampleLocationsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkAttachmentSampleLocationsEXT(s);
    }

    public @Pointer(target=VkAttachmentSampleLocationsEXT.class) @NotNull MemorySegment pAttachmentInitialSampleLocationsRaw() {
        return segment.get(LAYOUT$pAttachmentInitialSampleLocations, OFFSET$pAttachmentInitialSampleLocations);
    }

    public void pAttachmentInitialSampleLocationsRaw(@Pointer(target=VkAttachmentSampleLocationsEXT.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pAttachmentInitialSampleLocations, OFFSET$pAttachmentInitialSampleLocations, value);
    }

    public @Unsigned int postSubpassSampleLocationsCount() {
        return segment.get(LAYOUT$postSubpassSampleLocationsCount, OFFSET$postSubpassSampleLocationsCount);
    }

    public VkRenderPassSampleLocationsBeginInfoEXT postSubpassSampleLocationsCount(@Unsigned int value) {
        segment.set(LAYOUT$postSubpassSampleLocationsCount, OFFSET$postSubpassSampleLocationsCount, value);
        return this;
    }

    public VkRenderPassSampleLocationsBeginInfoEXT pPostSubpassSampleLocations(@Nullable IVkSubpassSampleLocationsEXT value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pPostSubpassSampleLocationsRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkSubpassSampleLocationsEXT.Ptr pPostSubpassSampleLocations(int assumedCount) {
        MemorySegment s = pPostSubpassSampleLocationsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkSubpassSampleLocationsEXT.BYTES);
        return new VkSubpassSampleLocationsEXT.Ptr(s);
    }

    public @Nullable VkSubpassSampleLocationsEXT pPostSubpassSampleLocations() {
        MemorySegment s = pPostSubpassSampleLocationsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkSubpassSampleLocationsEXT(s);
    }

    public @Pointer(target=VkSubpassSampleLocationsEXT.class) @NotNull MemorySegment pPostSubpassSampleLocationsRaw() {
        return segment.get(LAYOUT$pPostSubpassSampleLocations, OFFSET$pPostSubpassSampleLocations);
    }

    public void pPostSubpassSampleLocationsRaw(@Pointer(target=VkSubpassSampleLocationsEXT.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pPostSubpassSampleLocations, OFFSET$pPostSubpassSampleLocations, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("attachmentInitialSampleLocationsCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkAttachmentSampleLocationsEXT.LAYOUT).withName("pAttachmentInitialSampleLocations"),
        ValueLayout.JAVA_INT.withName("postSubpassSampleLocationsCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkSubpassSampleLocationsEXT.LAYOUT).withName("pPostSubpassSampleLocations")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$attachmentInitialSampleLocationsCount = PathElement.groupElement("attachmentInitialSampleLocationsCount");
    public static final PathElement PATH$pAttachmentInitialSampleLocations = PathElement.groupElement("pAttachmentInitialSampleLocations");
    public static final PathElement PATH$postSubpassSampleLocationsCount = PathElement.groupElement("postSubpassSampleLocationsCount");
    public static final PathElement PATH$pPostSubpassSampleLocations = PathElement.groupElement("pPostSubpassSampleLocations");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$attachmentInitialSampleLocationsCount = (OfInt) LAYOUT.select(PATH$attachmentInitialSampleLocationsCount);
    public static final AddressLayout LAYOUT$pAttachmentInitialSampleLocations = (AddressLayout) LAYOUT.select(PATH$pAttachmentInitialSampleLocations);
    public static final OfInt LAYOUT$postSubpassSampleLocationsCount = (OfInt) LAYOUT.select(PATH$postSubpassSampleLocationsCount);
    public static final AddressLayout LAYOUT$pPostSubpassSampleLocations = (AddressLayout) LAYOUT.select(PATH$pPostSubpassSampleLocations);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$attachmentInitialSampleLocationsCount = LAYOUT$attachmentInitialSampleLocationsCount.byteSize();
    public static final long SIZE$pAttachmentInitialSampleLocations = LAYOUT$pAttachmentInitialSampleLocations.byteSize();
    public static final long SIZE$postSubpassSampleLocationsCount = LAYOUT$postSubpassSampleLocationsCount.byteSize();
    public static final long SIZE$pPostSubpassSampleLocations = LAYOUT$pPostSubpassSampleLocations.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$attachmentInitialSampleLocationsCount = LAYOUT.byteOffset(PATH$attachmentInitialSampleLocationsCount);
    public static final long OFFSET$pAttachmentInitialSampleLocations = LAYOUT.byteOffset(PATH$pAttachmentInitialSampleLocations);
    public static final long OFFSET$postSubpassSampleLocationsCount = LAYOUT.byteOffset(PATH$postSubpassSampleLocationsCount);
    public static final long OFFSET$pPostSubpassSampleLocations = LAYOUT.byteOffset(PATH$pPostSubpassSampleLocations);
}
