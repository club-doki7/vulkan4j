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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCopyMemoryToImageIndirectCommandKHR.html"><code>VkCopyMemoryToImageIndirectCommandKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkCopyMemoryToImageIndirectCommandKHR {
///     VkDeviceAddress srcAddress; // @link substring="srcAddress" target="#srcAddress"
///     uint32_t bufferRowLength; // @link substring="bufferRowLength" target="#bufferRowLength"
///     uint32_t bufferImageHeight; // @link substring="bufferImageHeight" target="#bufferImageHeight"
///     VkImageSubresourceLayers imageSubresource; // @link substring="VkImageSubresourceLayers" target="VkImageSubresourceLayers" @link substring="imageSubresource" target="#imageSubresource"
///     VkOffset3D imageOffset; // @link substring="VkOffset3D" target="VkOffset3D" @link substring="imageOffset" target="#imageOffset"
///     VkExtent3D imageExtent; // @link substring="VkExtent3D" target="VkExtent3D" @link substring="imageExtent" target="#imageExtent"
/// } VkCopyMemoryToImageIndirectCommandKHR;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCopyMemoryToImageIndirectCommandKHR.html"><code>VkCopyMemoryToImageIndirectCommandKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkCopyMemoryToImageIndirectCommandKHR(@NotNull MemorySegment segment) implements IVkCopyMemoryToImageIndirectCommandKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCopyMemoryToImageIndirectCommandKHR.html"><code>VkCopyMemoryToImageIndirectCommandKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkCopyMemoryToImageIndirectCommandKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkCopyMemoryToImageIndirectCommandKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkCopyMemoryToImageIndirectCommandKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkCopyMemoryToImageIndirectCommandKHR, Iterable<VkCopyMemoryToImageIndirectCommandKHR> {
        public long size() {
            return segment.byteSize() / VkCopyMemoryToImageIndirectCommandKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkCopyMemoryToImageIndirectCommandKHR at(long index) {
            return new VkCopyMemoryToImageIndirectCommandKHR(segment.asSlice(index * VkCopyMemoryToImageIndirectCommandKHR.BYTES, VkCopyMemoryToImageIndirectCommandKHR.BYTES));
        }

        public VkCopyMemoryToImageIndirectCommandKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkCopyMemoryToImageIndirectCommandKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkCopyMemoryToImageIndirectCommandKHR value) {
            MemorySegment s = segment.asSlice(index * VkCopyMemoryToImageIndirectCommandKHR.BYTES, VkCopyMemoryToImageIndirectCommandKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkCopyMemoryToImageIndirectCommandKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkCopyMemoryToImageIndirectCommandKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkCopyMemoryToImageIndirectCommandKHR.BYTES,
                (end - start) * VkCopyMemoryToImageIndirectCommandKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkCopyMemoryToImageIndirectCommandKHR.BYTES));
        }

        public VkCopyMemoryToImageIndirectCommandKHR[] toArray() {
            VkCopyMemoryToImageIndirectCommandKHR[] ret = new VkCopyMemoryToImageIndirectCommandKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkCopyMemoryToImageIndirectCommandKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkCopyMemoryToImageIndirectCommandKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkCopyMemoryToImageIndirectCommandKHR.BYTES;
            }

            @Override
            public VkCopyMemoryToImageIndirectCommandKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkCopyMemoryToImageIndirectCommandKHR ret = new VkCopyMemoryToImageIndirectCommandKHR(segment.asSlice(0, VkCopyMemoryToImageIndirectCommandKHR.BYTES));
                segment = segment.asSlice(VkCopyMemoryToImageIndirectCommandKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkCopyMemoryToImageIndirectCommandKHR allocate(Arena arena) {
        return new VkCopyMemoryToImageIndirectCommandKHR(arena.allocate(LAYOUT));
    }

    public static VkCopyMemoryToImageIndirectCommandKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkCopyMemoryToImageIndirectCommandKHR.Ptr(segment);
    }

    public static VkCopyMemoryToImageIndirectCommandKHR clone(Arena arena, VkCopyMemoryToImageIndirectCommandKHR src) {
        VkCopyMemoryToImageIndirectCommandKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NativeType("VkDeviceAddress") @Unsigned long srcAddress() {
        return segment.get(LAYOUT$srcAddress, OFFSET$srcAddress);
    }

    public VkCopyMemoryToImageIndirectCommandKHR srcAddress(@NativeType("VkDeviceAddress") @Unsigned long value) {
        segment.set(LAYOUT$srcAddress, OFFSET$srcAddress, value);
        return this;
    }

    public @Unsigned int bufferRowLength() {
        return segment.get(LAYOUT$bufferRowLength, OFFSET$bufferRowLength);
    }

    public VkCopyMemoryToImageIndirectCommandKHR bufferRowLength(@Unsigned int value) {
        segment.set(LAYOUT$bufferRowLength, OFFSET$bufferRowLength, value);
        return this;
    }

    public @Unsigned int bufferImageHeight() {
        return segment.get(LAYOUT$bufferImageHeight, OFFSET$bufferImageHeight);
    }

    public VkCopyMemoryToImageIndirectCommandKHR bufferImageHeight(@Unsigned int value) {
        segment.set(LAYOUT$bufferImageHeight, OFFSET$bufferImageHeight, value);
        return this;
    }

    public @NotNull VkImageSubresourceLayers imageSubresource() {
        return new VkImageSubresourceLayers(segment.asSlice(OFFSET$imageSubresource, LAYOUT$imageSubresource));
    }

    public VkCopyMemoryToImageIndirectCommandKHR imageSubresource(@NotNull VkImageSubresourceLayers value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$imageSubresource, SIZE$imageSubresource);
        return this;
    }

    public VkCopyMemoryToImageIndirectCommandKHR imageSubresource(Consumer<@NotNull VkImageSubresourceLayers> consumer) {
        consumer.accept(imageSubresource());
        return this;
    }

    public @NotNull VkOffset3D imageOffset() {
        return new VkOffset3D(segment.asSlice(OFFSET$imageOffset, LAYOUT$imageOffset));
    }

    public VkCopyMemoryToImageIndirectCommandKHR imageOffset(@NotNull VkOffset3D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$imageOffset, SIZE$imageOffset);
        return this;
    }

    public VkCopyMemoryToImageIndirectCommandKHR imageOffset(Consumer<@NotNull VkOffset3D> consumer) {
        consumer.accept(imageOffset());
        return this;
    }

    public @NotNull VkExtent3D imageExtent() {
        return new VkExtent3D(segment.asSlice(OFFSET$imageExtent, LAYOUT$imageExtent));
    }

    public VkCopyMemoryToImageIndirectCommandKHR imageExtent(@NotNull VkExtent3D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$imageExtent, SIZE$imageExtent);
        return this;
    }

    public VkCopyMemoryToImageIndirectCommandKHR imageExtent(Consumer<@NotNull VkExtent3D> consumer) {
        consumer.accept(imageExtent());
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_LONG.withName("srcAddress"),
        ValueLayout.JAVA_INT.withName("bufferRowLength"),
        ValueLayout.JAVA_INT.withName("bufferImageHeight"),
        VkImageSubresourceLayers.LAYOUT.withName("imageSubresource"),
        VkOffset3D.LAYOUT.withName("imageOffset"),
        VkExtent3D.LAYOUT.withName("imageExtent")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$srcAddress = PathElement.groupElement("srcAddress");
    public static final PathElement PATH$bufferRowLength = PathElement.groupElement("bufferRowLength");
    public static final PathElement PATH$bufferImageHeight = PathElement.groupElement("bufferImageHeight");
    public static final PathElement PATH$imageSubresource = PathElement.groupElement("imageSubresource");
    public static final PathElement PATH$imageOffset = PathElement.groupElement("imageOffset");
    public static final PathElement PATH$imageExtent = PathElement.groupElement("imageExtent");

    public static final OfLong LAYOUT$srcAddress = (OfLong) LAYOUT.select(PATH$srcAddress);
    public static final OfInt LAYOUT$bufferRowLength = (OfInt) LAYOUT.select(PATH$bufferRowLength);
    public static final OfInt LAYOUT$bufferImageHeight = (OfInt) LAYOUT.select(PATH$bufferImageHeight);
    public static final StructLayout LAYOUT$imageSubresource = (StructLayout) LAYOUT.select(PATH$imageSubresource);
    public static final StructLayout LAYOUT$imageOffset = (StructLayout) LAYOUT.select(PATH$imageOffset);
    public static final StructLayout LAYOUT$imageExtent = (StructLayout) LAYOUT.select(PATH$imageExtent);

    public static final long SIZE$srcAddress = LAYOUT$srcAddress.byteSize();
    public static final long SIZE$bufferRowLength = LAYOUT$bufferRowLength.byteSize();
    public static final long SIZE$bufferImageHeight = LAYOUT$bufferImageHeight.byteSize();
    public static final long SIZE$imageSubresource = LAYOUT$imageSubresource.byteSize();
    public static final long SIZE$imageOffset = LAYOUT$imageOffset.byteSize();
    public static final long SIZE$imageExtent = LAYOUT$imageExtent.byteSize();

    public static final long OFFSET$srcAddress = LAYOUT.byteOffset(PATH$srcAddress);
    public static final long OFFSET$bufferRowLength = LAYOUT.byteOffset(PATH$bufferRowLength);
    public static final long OFFSET$bufferImageHeight = LAYOUT.byteOffset(PATH$bufferImageHeight);
    public static final long OFFSET$imageSubresource = LAYOUT.byteOffset(PATH$imageSubresource);
    public static final long OFFSET$imageOffset = LAYOUT.byteOffset(PATH$imageOffset);
    public static final long OFFSET$imageExtent = LAYOUT.byteOffset(PATH$imageExtent);
}
