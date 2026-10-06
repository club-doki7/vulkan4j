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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSubresourceLayout.html"><code>VkSubresourceLayout</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkSubresourceLayout {
///     VkDeviceSize offset; // @link substring="offset" target="#offset"
///     VkDeviceSize size; // @link substring="size" target="#size"
///     VkDeviceSize rowPitch; // @link substring="rowPitch" target="#rowPitch"
///     VkDeviceSize arrayPitch; // @link substring="arrayPitch" target="#arrayPitch"
///     VkDeviceSize depthPitch; // @link substring="depthPitch" target="#depthPitch"
/// } VkSubresourceLayout;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSubresourceLayout.html"><code>VkSubresourceLayout</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkSubresourceLayout(@NotNull MemorySegment segment) implements IVkSubresourceLayout {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSubresourceLayout.html"><code>VkSubresourceLayout</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkSubresourceLayout}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkSubresourceLayout to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkSubresourceLayout.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkSubresourceLayout, Iterable<VkSubresourceLayout> {
        public long size() {
            return segment.byteSize() / VkSubresourceLayout.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkSubresourceLayout at(long index) {
            return new VkSubresourceLayout(segment.asSlice(index * VkSubresourceLayout.BYTES, VkSubresourceLayout.BYTES));
        }

        public VkSubresourceLayout.Ptr at(long index, @NotNull Consumer<@NotNull VkSubresourceLayout> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkSubresourceLayout value) {
            MemorySegment s = segment.asSlice(index * VkSubresourceLayout.BYTES, VkSubresourceLayout.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkSubresourceLayout.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkSubresourceLayout.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkSubresourceLayout.BYTES,
                (end - start) * VkSubresourceLayout.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkSubresourceLayout.BYTES));
        }

        public VkSubresourceLayout[] toArray() {
            VkSubresourceLayout[] ret = new VkSubresourceLayout[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkSubresourceLayout> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkSubresourceLayout> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkSubresourceLayout.BYTES;
            }

            @Override
            public VkSubresourceLayout next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkSubresourceLayout ret = new VkSubresourceLayout(segment.asSlice(0, VkSubresourceLayout.BYTES));
                segment = segment.asSlice(VkSubresourceLayout.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkSubresourceLayout allocate(Arena arena) {
        return new VkSubresourceLayout(arena.allocate(LAYOUT));
    }

    public static VkSubresourceLayout.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkSubresourceLayout.Ptr(segment);
    }

    public static VkSubresourceLayout clone(Arena arena, VkSubresourceLayout src) {
        VkSubresourceLayout ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NativeType("VkDeviceSize") @Unsigned long offset() {
        return segment.get(LAYOUT$offset, OFFSET$offset);
    }

    public VkSubresourceLayout offset(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$offset, OFFSET$offset, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long size() {
        return segment.get(LAYOUT$size, OFFSET$size);
    }

    public VkSubresourceLayout size(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$size, OFFSET$size, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long rowPitch() {
        return segment.get(LAYOUT$rowPitch, OFFSET$rowPitch);
    }

    public VkSubresourceLayout rowPitch(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$rowPitch, OFFSET$rowPitch, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long arrayPitch() {
        return segment.get(LAYOUT$arrayPitch, OFFSET$arrayPitch);
    }

    public VkSubresourceLayout arrayPitch(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$arrayPitch, OFFSET$arrayPitch, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long depthPitch() {
        return segment.get(LAYOUT$depthPitch, OFFSET$depthPitch);
    }

    public VkSubresourceLayout depthPitch(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$depthPitch, OFFSET$depthPitch, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_LONG.withName("offset"),
        ValueLayout.JAVA_LONG.withName("size"),
        ValueLayout.JAVA_LONG.withName("rowPitch"),
        ValueLayout.JAVA_LONG.withName("arrayPitch"),
        ValueLayout.JAVA_LONG.withName("depthPitch")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$offset = PathElement.groupElement("offset");
    public static final PathElement PATH$size = PathElement.groupElement("size");
    public static final PathElement PATH$rowPitch = PathElement.groupElement("rowPitch");
    public static final PathElement PATH$arrayPitch = PathElement.groupElement("arrayPitch");
    public static final PathElement PATH$depthPitch = PathElement.groupElement("depthPitch");

    public static final OfLong LAYOUT$offset = (OfLong) LAYOUT.select(PATH$offset);
    public static final OfLong LAYOUT$size = (OfLong) LAYOUT.select(PATH$size);
    public static final OfLong LAYOUT$rowPitch = (OfLong) LAYOUT.select(PATH$rowPitch);
    public static final OfLong LAYOUT$arrayPitch = (OfLong) LAYOUT.select(PATH$arrayPitch);
    public static final OfLong LAYOUT$depthPitch = (OfLong) LAYOUT.select(PATH$depthPitch);

    public static final long SIZE$offset = LAYOUT$offset.byteSize();
    public static final long SIZE$size = LAYOUT$size.byteSize();
    public static final long SIZE$rowPitch = LAYOUT$rowPitch.byteSize();
    public static final long SIZE$arrayPitch = LAYOUT$arrayPitch.byteSize();
    public static final long SIZE$depthPitch = LAYOUT$depthPitch.byteSize();

    public static final long OFFSET$offset = LAYOUT.byteOffset(PATH$offset);
    public static final long OFFSET$size = LAYOUT.byteOffset(PATH$size);
    public static final long OFFSET$rowPitch = LAYOUT.byteOffset(PATH$rowPitch);
    public static final long OFFSET$arrayPitch = LAYOUT.byteOffset(PATH$arrayPitch);
    public static final long OFFSET$depthPitch = LAYOUT.byteOffset(PATH$depthPitch);
}
