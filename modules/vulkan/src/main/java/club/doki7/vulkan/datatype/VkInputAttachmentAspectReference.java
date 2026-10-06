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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkInputAttachmentAspectReference.html"><code>VkInputAttachmentAspectReference</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkInputAttachmentAspectReference {
///     uint32_t subpass; // @link substring="subpass" target="#subpass"
///     uint32_t inputAttachmentIndex; // @link substring="inputAttachmentIndex" target="#inputAttachmentIndex"
///     VkImageAspectFlags aspectMask; // @link substring="VkImageAspectFlags" target="VkImageAspectFlags" @link substring="aspectMask" target="#aspectMask"
/// } VkInputAttachmentAspectReference;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkInputAttachmentAspectReference.html"><code>VkInputAttachmentAspectReference</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkInputAttachmentAspectReference(@NotNull MemorySegment segment) implements IVkInputAttachmentAspectReference {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkInputAttachmentAspectReference.html"><code>VkInputAttachmentAspectReference</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkInputAttachmentAspectReference}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkInputAttachmentAspectReference to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkInputAttachmentAspectReference.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkInputAttachmentAspectReference, Iterable<VkInputAttachmentAspectReference> {
        public long size() {
            return segment.byteSize() / VkInputAttachmentAspectReference.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkInputAttachmentAspectReference at(long index) {
            return new VkInputAttachmentAspectReference(segment.asSlice(index * VkInputAttachmentAspectReference.BYTES, VkInputAttachmentAspectReference.BYTES));
        }

        public VkInputAttachmentAspectReference.Ptr at(long index, @NotNull Consumer<@NotNull VkInputAttachmentAspectReference> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkInputAttachmentAspectReference value) {
            MemorySegment s = segment.asSlice(index * VkInputAttachmentAspectReference.BYTES, VkInputAttachmentAspectReference.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkInputAttachmentAspectReference.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkInputAttachmentAspectReference.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkInputAttachmentAspectReference.BYTES,
                (end - start) * VkInputAttachmentAspectReference.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkInputAttachmentAspectReference.BYTES));
        }

        public VkInputAttachmentAspectReference[] toArray() {
            VkInputAttachmentAspectReference[] ret = new VkInputAttachmentAspectReference[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkInputAttachmentAspectReference> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkInputAttachmentAspectReference> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkInputAttachmentAspectReference.BYTES;
            }

            @Override
            public VkInputAttachmentAspectReference next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkInputAttachmentAspectReference ret = new VkInputAttachmentAspectReference(segment.asSlice(0, VkInputAttachmentAspectReference.BYTES));
                segment = segment.asSlice(VkInputAttachmentAspectReference.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkInputAttachmentAspectReference allocate(Arena arena) {
        return new VkInputAttachmentAspectReference(arena.allocate(LAYOUT));
    }

    public static VkInputAttachmentAspectReference.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkInputAttachmentAspectReference.Ptr(segment);
    }

    public static VkInputAttachmentAspectReference clone(Arena arena, VkInputAttachmentAspectReference src) {
        VkInputAttachmentAspectReference ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned int subpass() {
        return segment.get(LAYOUT$subpass, OFFSET$subpass);
    }

    public VkInputAttachmentAspectReference subpass(@Unsigned int value) {
        segment.set(LAYOUT$subpass, OFFSET$subpass, value);
        return this;
    }

    public @Unsigned int inputAttachmentIndex() {
        return segment.get(LAYOUT$inputAttachmentIndex, OFFSET$inputAttachmentIndex);
    }

    public VkInputAttachmentAspectReference inputAttachmentIndex(@Unsigned int value) {
        segment.set(LAYOUT$inputAttachmentIndex, OFFSET$inputAttachmentIndex, value);
        return this;
    }

    public @Bitmask(VkImageAspectFlags.class) int aspectMask() {
        return segment.get(LAYOUT$aspectMask, OFFSET$aspectMask);
    }

    public VkInputAttachmentAspectReference aspectMask(@Bitmask(VkImageAspectFlags.class) int value) {
        segment.set(LAYOUT$aspectMask, OFFSET$aspectMask, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("subpass"),
        ValueLayout.JAVA_INT.withName("inputAttachmentIndex"),
        ValueLayout.JAVA_INT.withName("aspectMask")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$subpass = PathElement.groupElement("subpass");
    public static final PathElement PATH$inputAttachmentIndex = PathElement.groupElement("inputAttachmentIndex");
    public static final PathElement PATH$aspectMask = PathElement.groupElement("aspectMask");

    public static final OfInt LAYOUT$subpass = (OfInt) LAYOUT.select(PATH$subpass);
    public static final OfInt LAYOUT$inputAttachmentIndex = (OfInt) LAYOUT.select(PATH$inputAttachmentIndex);
    public static final OfInt LAYOUT$aspectMask = (OfInt) LAYOUT.select(PATH$aspectMask);

    public static final long SIZE$subpass = LAYOUT$subpass.byteSize();
    public static final long SIZE$inputAttachmentIndex = LAYOUT$inputAttachmentIndex.byteSize();
    public static final long SIZE$aspectMask = LAYOUT$aspectMask.byteSize();

    public static final long OFFSET$subpass = LAYOUT.byteOffset(PATH$subpass);
    public static final long OFFSET$inputAttachmentIndex = LAYOUT.byteOffset(PATH$inputAttachmentIndex);
    public static final long OFFSET$aspectMask = LAYOUT.byteOffset(PATH$aspectMask);
}
