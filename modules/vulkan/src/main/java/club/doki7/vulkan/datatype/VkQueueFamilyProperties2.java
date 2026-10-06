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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkQueueFamilyProperties2.html"><code>VkQueueFamilyProperties2</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkQueueFamilyProperties2 {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkQueueFamilyProperties queueFamilyProperties; // @link substring="VkQueueFamilyProperties" target="VkQueueFamilyProperties" @link substring="queueFamilyProperties" target="#queueFamilyProperties"
/// } VkQueueFamilyProperties2;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_QUEUE_FAMILY_PROPERTIES_2`
///
/// The {@code allocate} ({@link VkQueueFamilyProperties2#allocate(Arena)}, {@link VkQueueFamilyProperties2#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkQueueFamilyProperties2#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkQueueFamilyProperties2.html"><code>VkQueueFamilyProperties2</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkQueueFamilyProperties2(@NotNull MemorySegment segment) implements IVkQueueFamilyProperties2 {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkQueueFamilyProperties2.html"><code>VkQueueFamilyProperties2</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkQueueFamilyProperties2}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkQueueFamilyProperties2 to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkQueueFamilyProperties2.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkQueueFamilyProperties2, Iterable<VkQueueFamilyProperties2> {
        public long size() {
            return segment.byteSize() / VkQueueFamilyProperties2.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkQueueFamilyProperties2 at(long index) {
            return new VkQueueFamilyProperties2(segment.asSlice(index * VkQueueFamilyProperties2.BYTES, VkQueueFamilyProperties2.BYTES));
        }

        public VkQueueFamilyProperties2.Ptr at(long index, @NotNull Consumer<@NotNull VkQueueFamilyProperties2> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkQueueFamilyProperties2 value) {
            MemorySegment s = segment.asSlice(index * VkQueueFamilyProperties2.BYTES, VkQueueFamilyProperties2.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkQueueFamilyProperties2.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkQueueFamilyProperties2.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkQueueFamilyProperties2.BYTES,
                (end - start) * VkQueueFamilyProperties2.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkQueueFamilyProperties2.BYTES));
        }

        public VkQueueFamilyProperties2[] toArray() {
            VkQueueFamilyProperties2[] ret = new VkQueueFamilyProperties2[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkQueueFamilyProperties2> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkQueueFamilyProperties2> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkQueueFamilyProperties2.BYTES;
            }

            @Override
            public VkQueueFamilyProperties2 next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkQueueFamilyProperties2 ret = new VkQueueFamilyProperties2(segment.asSlice(0, VkQueueFamilyProperties2.BYTES));
                segment = segment.asSlice(VkQueueFamilyProperties2.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkQueueFamilyProperties2 allocate(Arena arena) {
        VkQueueFamilyProperties2 ret = new VkQueueFamilyProperties2(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.QUEUE_FAMILY_PROPERTIES_2);
        return ret;
    }

    public static VkQueueFamilyProperties2.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkQueueFamilyProperties2.Ptr ret = new VkQueueFamilyProperties2.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.QUEUE_FAMILY_PROPERTIES_2);
        }
        return ret;
    }

    public static VkQueueFamilyProperties2 clone(Arena arena, VkQueueFamilyProperties2 src) {
        VkQueueFamilyProperties2 ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.QUEUE_FAMILY_PROPERTIES_2);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkQueueFamilyProperties2 sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkQueueFamilyProperties2 pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkQueueFamilyProperties2 pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NotNull VkQueueFamilyProperties queueFamilyProperties() {
        return new VkQueueFamilyProperties(segment.asSlice(OFFSET$queueFamilyProperties, LAYOUT$queueFamilyProperties));
    }

    public VkQueueFamilyProperties2 queueFamilyProperties(@NotNull VkQueueFamilyProperties value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$queueFamilyProperties, SIZE$queueFamilyProperties);
        return this;
    }

    public VkQueueFamilyProperties2 queueFamilyProperties(Consumer<@NotNull VkQueueFamilyProperties> consumer) {
        consumer.accept(queueFamilyProperties());
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        VkQueueFamilyProperties.LAYOUT.withName("queueFamilyProperties")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$queueFamilyProperties = PathElement.groupElement("queueFamilyProperties");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final StructLayout LAYOUT$queueFamilyProperties = (StructLayout) LAYOUT.select(PATH$queueFamilyProperties);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$queueFamilyProperties = LAYOUT$queueFamilyProperties.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$queueFamilyProperties = LAYOUT.byteOffset(PATH$queueFamilyProperties);
}
