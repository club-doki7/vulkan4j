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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAttachmentReference.html"><code>VkAttachmentReference</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkAttachmentReference {
///     uint32_t attachment; // @link substring="attachment" target="#attachment"
///     VkImageLayout layout; // @link substring="VkImageLayout" target="VkImageLayout" @link substring="layout" target="#layout"
/// } VkAttachmentReference;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAttachmentReference.html"><code>VkAttachmentReference</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkAttachmentReference(@NotNull MemorySegment segment) implements IVkAttachmentReference {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAttachmentReference.html"><code>VkAttachmentReference</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkAttachmentReference}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkAttachmentReference to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkAttachmentReference.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkAttachmentReference, Iterable<VkAttachmentReference> {
        public long size() {
            return segment.byteSize() / VkAttachmentReference.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkAttachmentReference at(long index) {
            return new VkAttachmentReference(segment.asSlice(index * VkAttachmentReference.BYTES, VkAttachmentReference.BYTES));
        }

        public VkAttachmentReference.Ptr at(long index, @NotNull Consumer<@NotNull VkAttachmentReference> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkAttachmentReference value) {
            MemorySegment s = segment.asSlice(index * VkAttachmentReference.BYTES, VkAttachmentReference.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkAttachmentReference.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkAttachmentReference.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkAttachmentReference.BYTES,
                (end - start) * VkAttachmentReference.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkAttachmentReference.BYTES));
        }

        public VkAttachmentReference[] toArray() {
            VkAttachmentReference[] ret = new VkAttachmentReference[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkAttachmentReference> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkAttachmentReference> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkAttachmentReference.BYTES;
            }

            @Override
            public VkAttachmentReference next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkAttachmentReference ret = new VkAttachmentReference(segment.asSlice(0, VkAttachmentReference.BYTES));
                segment = segment.asSlice(VkAttachmentReference.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkAttachmentReference allocate(Arena arena) {
        return new VkAttachmentReference(arena.allocate(LAYOUT));
    }

    public static VkAttachmentReference.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkAttachmentReference.Ptr(segment);
    }

    public static VkAttachmentReference clone(Arena arena, VkAttachmentReference src) {
        VkAttachmentReference ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned int attachment() {
        return segment.get(LAYOUT$attachment, OFFSET$attachment);
    }

    public VkAttachmentReference attachment(@Unsigned int value) {
        segment.set(LAYOUT$attachment, OFFSET$attachment, value);
        return this;
    }

    public @EnumType(VkImageLayout.class) int layout() {
        return segment.get(LAYOUT$layout, OFFSET$layout);
    }

    public VkAttachmentReference layout(@EnumType(VkImageLayout.class) int value) {
        segment.set(LAYOUT$layout, OFFSET$layout, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("attachment"),
        ValueLayout.JAVA_INT.withName("layout")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$attachment = PathElement.groupElement("attachment");
    public static final PathElement PATH$layout = PathElement.groupElement("layout");

    public static final OfInt LAYOUT$attachment = (OfInt) LAYOUT.select(PATH$attachment);
    public static final OfInt LAYOUT$layout = (OfInt) LAYOUT.select(PATH$layout);

    public static final long SIZE$attachment = LAYOUT$attachment.byteSize();
    public static final long SIZE$layout = LAYOUT$layout.byteSize();

    public static final long OFFSET$attachment = LAYOUT.byteOffset(PATH$attachment);
    public static final long OFFSET$layout = LAYOUT.byteOffset(PATH$layout);
}
