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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkFrameBoundaryEXT.html"><code>VkFrameBoundaryEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkFrameBoundaryEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkFrameBoundaryFlagsEXT flags; // optional // @link substring="VkFrameBoundaryFlagsEXT" target="VkFrameBoundaryFlagsEXT" @link substring="flags" target="#flags"
///     uint64_t frameID; // @link substring="frameID" target="#frameID"
///     uint32_t imageCount; // optional // @link substring="imageCount" target="#imageCount"
///     VkImage const* pImages; // optional // @link substring="VkImage" target="VkImage" @link substring="pImages" target="#pImages"
///     uint32_t bufferCount; // optional // @link substring="bufferCount" target="#bufferCount"
///     VkBuffer const* pBuffers; // optional // @link substring="VkBuffer" target="VkBuffer" @link substring="pBuffers" target="#pBuffers"
///     uint64_t tagName; // optional // @link substring="tagName" target="#tagName"
///     size_t tagSize; // optional // @link substring="tagSize" target="#tagSize"
///     void const* pTag; // optional // @link substring="pTag" target="#pTag"
/// } VkFrameBoundaryEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_FRAME_BOUNDARY_EXT`
///
/// The {@code allocate} ({@link VkFrameBoundaryEXT#allocate(Arena)}, {@link VkFrameBoundaryEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkFrameBoundaryEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkFrameBoundaryEXT.html"><code>VkFrameBoundaryEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkFrameBoundaryEXT(@NotNull MemorySegment segment) implements IVkFrameBoundaryEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkFrameBoundaryEXT.html"><code>VkFrameBoundaryEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkFrameBoundaryEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkFrameBoundaryEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkFrameBoundaryEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkFrameBoundaryEXT, Iterable<VkFrameBoundaryEXT> {
        public long size() {
            return segment.byteSize() / VkFrameBoundaryEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkFrameBoundaryEXT at(long index) {
            return new VkFrameBoundaryEXT(segment.asSlice(index * VkFrameBoundaryEXT.BYTES, VkFrameBoundaryEXT.BYTES));
        }

        public VkFrameBoundaryEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkFrameBoundaryEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkFrameBoundaryEXT value) {
            MemorySegment s = segment.asSlice(index * VkFrameBoundaryEXT.BYTES, VkFrameBoundaryEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkFrameBoundaryEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkFrameBoundaryEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkFrameBoundaryEXT.BYTES,
                (end - start) * VkFrameBoundaryEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkFrameBoundaryEXT.BYTES));
        }

        public VkFrameBoundaryEXT[] toArray() {
            VkFrameBoundaryEXT[] ret = new VkFrameBoundaryEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkFrameBoundaryEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkFrameBoundaryEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkFrameBoundaryEXT.BYTES;
            }

            @Override
            public VkFrameBoundaryEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkFrameBoundaryEXT ret = new VkFrameBoundaryEXT(segment.asSlice(0, VkFrameBoundaryEXT.BYTES));
                segment = segment.asSlice(VkFrameBoundaryEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkFrameBoundaryEXT allocate(Arena arena) {
        VkFrameBoundaryEXT ret = new VkFrameBoundaryEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.FRAME_BOUNDARY_EXT);
        return ret;
    }

    public static VkFrameBoundaryEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkFrameBoundaryEXT.Ptr ret = new VkFrameBoundaryEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.FRAME_BOUNDARY_EXT);
        }
        return ret;
    }

    public static VkFrameBoundaryEXT clone(Arena arena, VkFrameBoundaryEXT src) {
        VkFrameBoundaryEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.FRAME_BOUNDARY_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkFrameBoundaryEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkFrameBoundaryEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkFrameBoundaryEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkFrameBoundaryFlagsEXT.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkFrameBoundaryEXT flags(@Bitmask(VkFrameBoundaryFlagsEXT.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @Unsigned long frameID() {
        return segment.get(LAYOUT$frameID, OFFSET$frameID);
    }

    public VkFrameBoundaryEXT frameID(@Unsigned long value) {
        segment.set(LAYOUT$frameID, OFFSET$frameID, value);
        return this;
    }

    public @Unsigned int imageCount() {
        return segment.get(LAYOUT$imageCount, OFFSET$imageCount);
    }

    public VkFrameBoundaryEXT imageCount(@Unsigned int value) {
        segment.set(LAYOUT$imageCount, OFFSET$imageCount, value);
        return this;
    }

    /// Note: the returned {@link VkImage.Ptr} does not have correct {@link VkImage.Ptr#size}
    /// property. It's up to user to track the size of the buffer, and use
    /// {@link VkImage.Ptr#reinterpret} to set the size before actually reading from or writing to the
    /// buffer.
    public @Nullable VkImage.Ptr pImages() {
        MemorySegment s = pImagesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkImage.Ptr(s);
    }

    public VkFrameBoundaryEXT pImages(@Nullable VkImage.Ptr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pImagesRaw(s);
        return this;
    }

    public @Pointer(target=VkImage.class) @NotNull MemorySegment pImagesRaw() {
        return segment.get(LAYOUT$pImages, OFFSET$pImages);
    }

    public void pImagesRaw(@Pointer(target=VkImage.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pImages, OFFSET$pImages, value);
    }

    public @Unsigned int bufferCount() {
        return segment.get(LAYOUT$bufferCount, OFFSET$bufferCount);
    }

    public VkFrameBoundaryEXT bufferCount(@Unsigned int value) {
        segment.set(LAYOUT$bufferCount, OFFSET$bufferCount, value);
        return this;
    }

    /// Note: the returned {@link VkBuffer.Ptr} does not have correct {@link VkBuffer.Ptr#size}
    /// property. It's up to user to track the size of the buffer, and use
    /// {@link VkBuffer.Ptr#reinterpret} to set the size before actually reading from or writing to the
    /// buffer.
    public @Nullable VkBuffer.Ptr pBuffers() {
        MemorySegment s = pBuffersRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkBuffer.Ptr(s);
    }

    public VkFrameBoundaryEXT pBuffers(@Nullable VkBuffer.Ptr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pBuffersRaw(s);
        return this;
    }

    public @Pointer(target=VkBuffer.class) @NotNull MemorySegment pBuffersRaw() {
        return segment.get(LAYOUT$pBuffers, OFFSET$pBuffers);
    }

    public void pBuffersRaw(@Pointer(target=VkBuffer.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pBuffers, OFFSET$pBuffers, value);
    }

    public @Unsigned long tagName() {
        return segment.get(LAYOUT$tagName, OFFSET$tagName);
    }

    public VkFrameBoundaryEXT tagName(@Unsigned long value) {
        segment.set(LAYOUT$tagName, OFFSET$tagName, value);
        return this;
    }

    public @Unsigned long tagSize() {
        return NativeLayout.readCSizeT(segment, OFFSET$tagSize);
    }

    public VkFrameBoundaryEXT tagSize(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$tagSize, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pTag() {
        return segment.get(LAYOUT$pTag, OFFSET$pTag);
    }

    public VkFrameBoundaryEXT pTag(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pTag, OFFSET$pTag, value);
        return this;
    }

    public VkFrameBoundaryEXT pTag(@Nullable IPointer pointer) {
        pTag(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_LONG.withName("frameID"),
        ValueLayout.JAVA_INT.withName("imageCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS).withName("pImages"),
        ValueLayout.JAVA_INT.withName("bufferCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS).withName("pBuffers"),
        ValueLayout.JAVA_LONG.withName("tagName"),
        NativeLayout.C_SIZE_T.withName("tagSize"),
        ValueLayout.ADDRESS.withName("pTag")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$frameID = PathElement.groupElement("frameID");
    public static final PathElement PATH$imageCount = PathElement.groupElement("imageCount");
    public static final PathElement PATH$pImages = PathElement.groupElement("pImages");
    public static final PathElement PATH$bufferCount = PathElement.groupElement("bufferCount");
    public static final PathElement PATH$pBuffers = PathElement.groupElement("pBuffers");
    public static final PathElement PATH$tagName = PathElement.groupElement("tagName");
    public static final PathElement PATH$tagSize = PathElement.groupElement("tagSize");
    public static final PathElement PATH$pTag = PathElement.groupElement("pTag");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfLong LAYOUT$frameID = (OfLong) LAYOUT.select(PATH$frameID);
    public static final OfInt LAYOUT$imageCount = (OfInt) LAYOUT.select(PATH$imageCount);
    public static final AddressLayout LAYOUT$pImages = (AddressLayout) LAYOUT.select(PATH$pImages);
    public static final OfInt LAYOUT$bufferCount = (OfInt) LAYOUT.select(PATH$bufferCount);
    public static final AddressLayout LAYOUT$pBuffers = (AddressLayout) LAYOUT.select(PATH$pBuffers);
    public static final OfLong LAYOUT$tagName = (OfLong) LAYOUT.select(PATH$tagName);
    public static final AddressLayout LAYOUT$pTag = (AddressLayout) LAYOUT.select(PATH$pTag);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$frameID = LAYOUT$frameID.byteSize();
    public static final long SIZE$imageCount = LAYOUT$imageCount.byteSize();
    public static final long SIZE$pImages = LAYOUT$pImages.byteSize();
    public static final long SIZE$bufferCount = LAYOUT$bufferCount.byteSize();
    public static final long SIZE$pBuffers = LAYOUT$pBuffers.byteSize();
    public static final long SIZE$tagName = LAYOUT$tagName.byteSize();
    public static final long SIZE$tagSize = NativeLayout.C_SIZE_T.byteSize();
    public static final long SIZE$pTag = LAYOUT$pTag.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$frameID = LAYOUT.byteOffset(PATH$frameID);
    public static final long OFFSET$imageCount = LAYOUT.byteOffset(PATH$imageCount);
    public static final long OFFSET$pImages = LAYOUT.byteOffset(PATH$pImages);
    public static final long OFFSET$bufferCount = LAYOUT.byteOffset(PATH$bufferCount);
    public static final long OFFSET$pBuffers = LAYOUT.byteOffset(PATH$pBuffers);
    public static final long OFFSET$tagName = LAYOUT.byteOffset(PATH$tagName);
    public static final long OFFSET$tagSize = LAYOUT.byteOffset(PATH$tagSize);
    public static final long OFFSET$pTag = LAYOUT.byteOffset(PATH$pTag);
}
