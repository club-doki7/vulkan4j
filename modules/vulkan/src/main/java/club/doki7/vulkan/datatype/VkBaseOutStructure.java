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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBaseOutStructure.html"><code>VkBaseOutStructure</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkBaseOutStructure {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     VkBaseOutStructure* pNext; // optional // @link substring="VkBaseOutStructure" target="VkBaseOutStructure" @link substring="pNext" target="#pNext"
/// } VkBaseOutStructure;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBaseOutStructure.html"><code>VkBaseOutStructure</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkBaseOutStructure(@NotNull MemorySegment segment) implements IVkBaseOutStructure {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBaseOutStructure.html"><code>VkBaseOutStructure</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkBaseOutStructure}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkBaseOutStructure to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkBaseOutStructure.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkBaseOutStructure, Iterable<VkBaseOutStructure> {
        public long size() {
            return segment.byteSize() / VkBaseOutStructure.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkBaseOutStructure at(long index) {
            return new VkBaseOutStructure(segment.asSlice(index * VkBaseOutStructure.BYTES, VkBaseOutStructure.BYTES));
        }

        public VkBaseOutStructure.Ptr at(long index, @NotNull Consumer<@NotNull VkBaseOutStructure> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkBaseOutStructure value) {
            MemorySegment s = segment.asSlice(index * VkBaseOutStructure.BYTES, VkBaseOutStructure.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkBaseOutStructure.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkBaseOutStructure.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkBaseOutStructure.BYTES,
                (end - start) * VkBaseOutStructure.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkBaseOutStructure.BYTES));
        }

        public VkBaseOutStructure[] toArray() {
            VkBaseOutStructure[] ret = new VkBaseOutStructure[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkBaseOutStructure> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkBaseOutStructure> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkBaseOutStructure.BYTES;
            }

            @Override
            public VkBaseOutStructure next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkBaseOutStructure ret = new VkBaseOutStructure(segment.asSlice(0, VkBaseOutStructure.BYTES));
                segment = segment.asSlice(VkBaseOutStructure.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkBaseOutStructure allocate(Arena arena) {
        return new VkBaseOutStructure(arena.allocate(LAYOUT));
    }

    public static VkBaseOutStructure.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkBaseOutStructure.Ptr(segment);
    }

    public static VkBaseOutStructure clone(Arena arena, VkBaseOutStructure src) {
        VkBaseOutStructure ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkBaseOutStructure sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public VkBaseOutStructure pNext(@Nullable IVkBaseOutStructure value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pNextRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkBaseOutStructure.Ptr pNext(int assumedCount) {
        MemorySegment s = pNextRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkBaseOutStructure.BYTES);
        return new VkBaseOutStructure.Ptr(s);
    }

    public @Nullable VkBaseOutStructure pNext() {
        MemorySegment s = pNextRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkBaseOutStructure(s);
    }

    public @Pointer(target=VkBaseOutStructure.class) @NotNull MemorySegment pNextRaw() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public void pNextRaw(@Pointer(target=VkBaseOutStructure.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
}
