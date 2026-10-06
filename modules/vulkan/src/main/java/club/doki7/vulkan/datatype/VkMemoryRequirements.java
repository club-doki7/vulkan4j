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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMemoryRequirements.html"><code>VkMemoryRequirements</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkMemoryRequirements {
///     VkDeviceSize size; // @link substring="size" target="#size"
///     VkDeviceSize alignment; // @link substring="alignment" target="#alignment"
///     uint32_t memoryTypeBits; // @link substring="memoryTypeBits" target="#memoryTypeBits"
/// } VkMemoryRequirements;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMemoryRequirements.html"><code>VkMemoryRequirements</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkMemoryRequirements(@NotNull MemorySegment segment) implements IVkMemoryRequirements {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMemoryRequirements.html"><code>VkMemoryRequirements</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkMemoryRequirements}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkMemoryRequirements to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkMemoryRequirements.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkMemoryRequirements, Iterable<VkMemoryRequirements> {
        public long size() {
            return segment.byteSize() / VkMemoryRequirements.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkMemoryRequirements at(long index) {
            return new VkMemoryRequirements(segment.asSlice(index * VkMemoryRequirements.BYTES, VkMemoryRequirements.BYTES));
        }

        public VkMemoryRequirements.Ptr at(long index, @NotNull Consumer<@NotNull VkMemoryRequirements> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkMemoryRequirements value) {
            MemorySegment s = segment.asSlice(index * VkMemoryRequirements.BYTES, VkMemoryRequirements.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkMemoryRequirements.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkMemoryRequirements.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkMemoryRequirements.BYTES,
                (end - start) * VkMemoryRequirements.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkMemoryRequirements.BYTES));
        }

        public VkMemoryRequirements[] toArray() {
            VkMemoryRequirements[] ret = new VkMemoryRequirements[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkMemoryRequirements> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkMemoryRequirements> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkMemoryRequirements.BYTES;
            }

            @Override
            public VkMemoryRequirements next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkMemoryRequirements ret = new VkMemoryRequirements(segment.asSlice(0, VkMemoryRequirements.BYTES));
                segment = segment.asSlice(VkMemoryRequirements.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkMemoryRequirements allocate(Arena arena) {
        return new VkMemoryRequirements(arena.allocate(LAYOUT));
    }

    public static VkMemoryRequirements.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkMemoryRequirements.Ptr(segment);
    }

    public static VkMemoryRequirements clone(Arena arena, VkMemoryRequirements src) {
        VkMemoryRequirements ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NativeType("VkDeviceSize") @Unsigned long size() {
        return segment.get(LAYOUT$size, OFFSET$size);
    }

    public VkMemoryRequirements size(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$size, OFFSET$size, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long alignment() {
        return segment.get(LAYOUT$alignment, OFFSET$alignment);
    }

    public VkMemoryRequirements alignment(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$alignment, OFFSET$alignment, value);
        return this;
    }

    public @Unsigned int memoryTypeBits() {
        return segment.get(LAYOUT$memoryTypeBits, OFFSET$memoryTypeBits);
    }

    public VkMemoryRequirements memoryTypeBits(@Unsigned int value) {
        segment.set(LAYOUT$memoryTypeBits, OFFSET$memoryTypeBits, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_LONG.withName("size"),
        ValueLayout.JAVA_LONG.withName("alignment"),
        ValueLayout.JAVA_INT.withName("memoryTypeBits")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$size = PathElement.groupElement("size");
    public static final PathElement PATH$alignment = PathElement.groupElement("alignment");
    public static final PathElement PATH$memoryTypeBits = PathElement.groupElement("memoryTypeBits");

    public static final OfLong LAYOUT$size = (OfLong) LAYOUT.select(PATH$size);
    public static final OfLong LAYOUT$alignment = (OfLong) LAYOUT.select(PATH$alignment);
    public static final OfInt LAYOUT$memoryTypeBits = (OfInt) LAYOUT.select(PATH$memoryTypeBits);

    public static final long SIZE$size = LAYOUT$size.byteSize();
    public static final long SIZE$alignment = LAYOUT$alignment.byteSize();
    public static final long SIZE$memoryTypeBits = LAYOUT$memoryTypeBits.byteSize();

    public static final long OFFSET$size = LAYOUT.byteOffset(PATH$size);
    public static final long OFFSET$alignment = LAYOUT.byteOffset(PATH$alignment);
    public static final long OFFSET$memoryTypeBits = LAYOUT.byteOffset(PATH$memoryTypeBits);
}
