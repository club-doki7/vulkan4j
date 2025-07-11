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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAttachmentSampleLocationsEXT.html"><code>VkAttachmentSampleLocationsEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkAttachmentSampleLocationsEXT {
///     uint32_t attachmentIndex; // @link substring="attachmentIndex" target="#attachmentIndex"
///     VkSampleLocationsInfoEXT sampleLocationsInfo; // @link substring="VkSampleLocationsInfoEXT" target="VkSampleLocationsInfoEXT" @link substring="sampleLocationsInfo" target="#sampleLocationsInfo"
/// } VkAttachmentSampleLocationsEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sampleLocationsInfo.autoInit()`
///
/// The {@code allocate} ({@link VkAttachmentSampleLocationsEXT#allocate(Arena)}, {@link VkAttachmentSampleLocationsEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkAttachmentSampleLocationsEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAttachmentSampleLocationsEXT.html"><code>VkAttachmentSampleLocationsEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkAttachmentSampleLocationsEXT(@NotNull MemorySegment segment) implements IVkAttachmentSampleLocationsEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAttachmentSampleLocationsEXT.html"><code>VkAttachmentSampleLocationsEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkAttachmentSampleLocationsEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkAttachmentSampleLocationsEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkAttachmentSampleLocationsEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkAttachmentSampleLocationsEXT, Iterable<VkAttachmentSampleLocationsEXT> {
        public long size() {
            return segment.byteSize() / VkAttachmentSampleLocationsEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkAttachmentSampleLocationsEXT at(long index) {
            return new VkAttachmentSampleLocationsEXT(segment.asSlice(index * VkAttachmentSampleLocationsEXT.BYTES, VkAttachmentSampleLocationsEXT.BYTES));
        }

        public VkAttachmentSampleLocationsEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkAttachmentSampleLocationsEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkAttachmentSampleLocationsEXT value) {
            MemorySegment s = segment.asSlice(index * VkAttachmentSampleLocationsEXT.BYTES, VkAttachmentSampleLocationsEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkAttachmentSampleLocationsEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkAttachmentSampleLocationsEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkAttachmentSampleLocationsEXT.BYTES,
                (end - start) * VkAttachmentSampleLocationsEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkAttachmentSampleLocationsEXT.BYTES));
        }

        public VkAttachmentSampleLocationsEXT[] toArray() {
            VkAttachmentSampleLocationsEXT[] ret = new VkAttachmentSampleLocationsEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkAttachmentSampleLocationsEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkAttachmentSampleLocationsEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkAttachmentSampleLocationsEXT.BYTES;
            }

            @Override
            public VkAttachmentSampleLocationsEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkAttachmentSampleLocationsEXT ret = new VkAttachmentSampleLocationsEXT(segment.asSlice(0, VkAttachmentSampleLocationsEXT.BYTES));
                segment = segment.asSlice(VkAttachmentSampleLocationsEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkAttachmentSampleLocationsEXT allocate(Arena arena) {
        VkAttachmentSampleLocationsEXT ret = new VkAttachmentSampleLocationsEXT(arena.allocate(LAYOUT));
        ret.sampleLocationsInfo().autoInit();
        return ret;
    }

    public static VkAttachmentSampleLocationsEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkAttachmentSampleLocationsEXT.Ptr ret = new VkAttachmentSampleLocationsEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sampleLocationsInfo(VkSampleLocationsInfoEXT.null);
        }
        return ret;
    }

    public static VkAttachmentSampleLocationsEXT clone(Arena arena, VkAttachmentSampleLocationsEXT src) {
        VkAttachmentSampleLocationsEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sampleLocationsInfo().autoInit();
    }

    public @Unsigned int attachmentIndex() {
        return segment.get(LAYOUT$attachmentIndex, OFFSET$attachmentIndex);
    }

    public VkAttachmentSampleLocationsEXT attachmentIndex(@Unsigned int value) {
        segment.set(LAYOUT$attachmentIndex, OFFSET$attachmentIndex, value);
        return this;
    }

    public @NotNull VkSampleLocationsInfoEXT sampleLocationsInfo() {
        return new VkSampleLocationsInfoEXT(segment.asSlice(OFFSET$sampleLocationsInfo, LAYOUT$sampleLocationsInfo));
    }

    public VkAttachmentSampleLocationsEXT sampleLocationsInfo(@NotNull VkSampleLocationsInfoEXT value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$sampleLocationsInfo, SIZE$sampleLocationsInfo);
        return this;
    }

    public VkAttachmentSampleLocationsEXT sampleLocationsInfo(Consumer<@NotNull VkSampleLocationsInfoEXT> consumer) {
        consumer.accept(sampleLocationsInfo());
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("attachmentIndex"),
        VkSampleLocationsInfoEXT.LAYOUT.withName("sampleLocationsInfo")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$attachmentIndex = PathElement.groupElement("attachmentIndex");
    public static final PathElement PATH$sampleLocationsInfo = PathElement.groupElement("sampleLocationsInfo");

    public static final OfInt LAYOUT$attachmentIndex = (OfInt) LAYOUT.select(PATH$attachmentIndex);
    public static final StructLayout LAYOUT$sampleLocationsInfo = (StructLayout) LAYOUT.select(PATH$sampleLocationsInfo);

    public static final long SIZE$attachmentIndex = LAYOUT$attachmentIndex.byteSize();
    public static final long SIZE$sampleLocationsInfo = LAYOUT$sampleLocationsInfo.byteSize();

    public static final long OFFSET$attachmentIndex = LAYOUT.byteOffset(PATH$attachmentIndex);
    public static final long OFFSET$sampleLocationsInfo = LAYOUT.byteOffset(PATH$sampleLocationsInfo);
}
