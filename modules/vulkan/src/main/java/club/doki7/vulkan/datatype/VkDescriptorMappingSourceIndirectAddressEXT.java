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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDescriptorMappingSourceIndirectAddressEXT.html"><code>VkDescriptorMappingSourceIndirectAddressEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDescriptorMappingSourceIndirectAddressEXT {
///     uint32_t pushOffset; // @link substring="pushOffset" target="#pushOffset"
///     uint32_t addressOffset; // @link substring="addressOffset" target="#addressOffset"
/// } VkDescriptorMappingSourceIndirectAddressEXT;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDescriptorMappingSourceIndirectAddressEXT.html"><code>VkDescriptorMappingSourceIndirectAddressEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDescriptorMappingSourceIndirectAddressEXT(@NotNull MemorySegment segment) implements IVkDescriptorMappingSourceIndirectAddressEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDescriptorMappingSourceIndirectAddressEXT.html"><code>VkDescriptorMappingSourceIndirectAddressEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDescriptorMappingSourceIndirectAddressEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDescriptorMappingSourceIndirectAddressEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDescriptorMappingSourceIndirectAddressEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDescriptorMappingSourceIndirectAddressEXT, Iterable<VkDescriptorMappingSourceIndirectAddressEXT> {
        public long size() {
            return segment.byteSize() / VkDescriptorMappingSourceIndirectAddressEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDescriptorMappingSourceIndirectAddressEXT at(long index) {
            return new VkDescriptorMappingSourceIndirectAddressEXT(segment.asSlice(index * VkDescriptorMappingSourceIndirectAddressEXT.BYTES, VkDescriptorMappingSourceIndirectAddressEXT.BYTES));
        }

        public VkDescriptorMappingSourceIndirectAddressEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkDescriptorMappingSourceIndirectAddressEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDescriptorMappingSourceIndirectAddressEXT value) {
            MemorySegment s = segment.asSlice(index * VkDescriptorMappingSourceIndirectAddressEXT.BYTES, VkDescriptorMappingSourceIndirectAddressEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDescriptorMappingSourceIndirectAddressEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDescriptorMappingSourceIndirectAddressEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDescriptorMappingSourceIndirectAddressEXT.BYTES,
                (end - start) * VkDescriptorMappingSourceIndirectAddressEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDescriptorMappingSourceIndirectAddressEXT.BYTES));
        }

        public VkDescriptorMappingSourceIndirectAddressEXT[] toArray() {
            VkDescriptorMappingSourceIndirectAddressEXT[] ret = new VkDescriptorMappingSourceIndirectAddressEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDescriptorMappingSourceIndirectAddressEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDescriptorMappingSourceIndirectAddressEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDescriptorMappingSourceIndirectAddressEXT.BYTES;
            }

            @Override
            public VkDescriptorMappingSourceIndirectAddressEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDescriptorMappingSourceIndirectAddressEXT ret = new VkDescriptorMappingSourceIndirectAddressEXT(segment.asSlice(0, VkDescriptorMappingSourceIndirectAddressEXT.BYTES));
                segment = segment.asSlice(VkDescriptorMappingSourceIndirectAddressEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDescriptorMappingSourceIndirectAddressEXT allocate(Arena arena) {
        return new VkDescriptorMappingSourceIndirectAddressEXT(arena.allocate(LAYOUT));
    }

    public static VkDescriptorMappingSourceIndirectAddressEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkDescriptorMappingSourceIndirectAddressEXT.Ptr(segment);
    }

    public static VkDescriptorMappingSourceIndirectAddressEXT clone(Arena arena, VkDescriptorMappingSourceIndirectAddressEXT src) {
        VkDescriptorMappingSourceIndirectAddressEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned int pushOffset() {
        return segment.get(LAYOUT$pushOffset, OFFSET$pushOffset);
    }

    public VkDescriptorMappingSourceIndirectAddressEXT pushOffset(@Unsigned int value) {
        segment.set(LAYOUT$pushOffset, OFFSET$pushOffset, value);
        return this;
    }

    public @Unsigned int addressOffset() {
        return segment.get(LAYOUT$addressOffset, OFFSET$addressOffset);
    }

    public VkDescriptorMappingSourceIndirectAddressEXT addressOffset(@Unsigned int value) {
        segment.set(LAYOUT$addressOffset, OFFSET$addressOffset, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("pushOffset"),
        ValueLayout.JAVA_INT.withName("addressOffset")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$pushOffset = PathElement.groupElement("pushOffset");
    public static final PathElement PATH$addressOffset = PathElement.groupElement("addressOffset");

    public static final OfInt LAYOUT$pushOffset = (OfInt) LAYOUT.select(PATH$pushOffset);
    public static final OfInt LAYOUT$addressOffset = (OfInt) LAYOUT.select(PATH$addressOffset);

    public static final long SIZE$pushOffset = LAYOUT$pushOffset.byteSize();
    public static final long SIZE$addressOffset = LAYOUT$addressOffset.byteSize();

    public static final long OFFSET$pushOffset = LAYOUT.byteOffset(PATH$pushOffset);
    public static final long OFFSET$addressOffset = LAYOUT.byteOffset(PATH$addressOffset);
}
