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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVertexInputAttributeDescription.html"><code>VkVertexInputAttributeDescription</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkVertexInputAttributeDescription {
///     uint32_t location; // @link substring="location" target="#location"
///     uint32_t binding; // @link substring="binding" target="#binding"
///     VkFormat format; // @link substring="VkFormat" target="VkFormat" @link substring="format" target="#format"
///     uint32_t offset; // @link substring="offset" target="#offset"
/// } VkVertexInputAttributeDescription;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVertexInputAttributeDescription.html"><code>VkVertexInputAttributeDescription</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkVertexInputAttributeDescription(@NotNull MemorySegment segment) implements IVkVertexInputAttributeDescription {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVertexInputAttributeDescription.html"><code>VkVertexInputAttributeDescription</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkVertexInputAttributeDescription}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkVertexInputAttributeDescription to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkVertexInputAttributeDescription.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkVertexInputAttributeDescription, Iterable<VkVertexInputAttributeDescription> {
        public long size() {
            return segment.byteSize() / VkVertexInputAttributeDescription.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkVertexInputAttributeDescription at(long index) {
            return new VkVertexInputAttributeDescription(segment.asSlice(index * VkVertexInputAttributeDescription.BYTES, VkVertexInputAttributeDescription.BYTES));
        }

        public VkVertexInputAttributeDescription.Ptr at(long index, @NotNull Consumer<@NotNull VkVertexInputAttributeDescription> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkVertexInputAttributeDescription value) {
            MemorySegment s = segment.asSlice(index * VkVertexInputAttributeDescription.BYTES, VkVertexInputAttributeDescription.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkVertexInputAttributeDescription.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkVertexInputAttributeDescription.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkVertexInputAttributeDescription.BYTES,
                (end - start) * VkVertexInputAttributeDescription.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkVertexInputAttributeDescription.BYTES));
        }

        public VkVertexInputAttributeDescription[] toArray() {
            VkVertexInputAttributeDescription[] ret = new VkVertexInputAttributeDescription[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkVertexInputAttributeDescription> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkVertexInputAttributeDescription> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkVertexInputAttributeDescription.BYTES;
            }

            @Override
            public VkVertexInputAttributeDescription next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkVertexInputAttributeDescription ret = new VkVertexInputAttributeDescription(segment.asSlice(0, VkVertexInputAttributeDescription.BYTES));
                segment = segment.asSlice(VkVertexInputAttributeDescription.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkVertexInputAttributeDescription allocate(Arena arena) {
        return new VkVertexInputAttributeDescription(arena.allocate(LAYOUT));
    }

    public static VkVertexInputAttributeDescription.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkVertexInputAttributeDescription.Ptr(segment);
    }

    public static VkVertexInputAttributeDescription clone(Arena arena, VkVertexInputAttributeDescription src) {
        VkVertexInputAttributeDescription ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned int location() {
        return segment.get(LAYOUT$location, OFFSET$location);
    }

    public VkVertexInputAttributeDescription location(@Unsigned int value) {
        segment.set(LAYOUT$location, OFFSET$location, value);
        return this;
    }

    public @Unsigned int binding() {
        return segment.get(LAYOUT$binding, OFFSET$binding);
    }

    public VkVertexInputAttributeDescription binding(@Unsigned int value) {
        segment.set(LAYOUT$binding, OFFSET$binding, value);
        return this;
    }

    public @EnumType(VkFormat.class) int format() {
        return segment.get(LAYOUT$format, OFFSET$format);
    }

    public VkVertexInputAttributeDescription format(@EnumType(VkFormat.class) int value) {
        segment.set(LAYOUT$format, OFFSET$format, value);
        return this;
    }

    public @Unsigned int offset() {
        return segment.get(LAYOUT$offset, OFFSET$offset);
    }

    public VkVertexInputAttributeDescription offset(@Unsigned int value) {
        segment.set(LAYOUT$offset, OFFSET$offset, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("location"),
        ValueLayout.JAVA_INT.withName("binding"),
        ValueLayout.JAVA_INT.withName("format"),
        ValueLayout.JAVA_INT.withName("offset")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$location = PathElement.groupElement("location");
    public static final PathElement PATH$binding = PathElement.groupElement("binding");
    public static final PathElement PATH$format = PathElement.groupElement("format");
    public static final PathElement PATH$offset = PathElement.groupElement("offset");

    public static final OfInt LAYOUT$location = (OfInt) LAYOUT.select(PATH$location);
    public static final OfInt LAYOUT$binding = (OfInt) LAYOUT.select(PATH$binding);
    public static final OfInt LAYOUT$format = (OfInt) LAYOUT.select(PATH$format);
    public static final OfInt LAYOUT$offset = (OfInt) LAYOUT.select(PATH$offset);

    public static final long SIZE$location = LAYOUT$location.byteSize();
    public static final long SIZE$binding = LAYOUT$binding.byteSize();
    public static final long SIZE$format = LAYOUT$format.byteSize();
    public static final long SIZE$offset = LAYOUT$offset.byteSize();

    public static final long OFFSET$location = LAYOUT.byteOffset(PATH$location);
    public static final long OFFSET$binding = LAYOUT.byteOffset(PATH$binding);
    public static final long OFFSET$format = LAYOUT.byteOffset(PATH$format);
    public static final long OFFSET$offset = LAYOUT.byteOffset(PATH$offset);
}
