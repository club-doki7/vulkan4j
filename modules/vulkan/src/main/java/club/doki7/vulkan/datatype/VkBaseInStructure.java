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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBaseInStructure.html"><code>VkBaseInStructure</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkBaseInStructure {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     VkBaseInStructure const* pNext; // optional // @link substring="VkBaseInStructure" target="VkBaseInStructure" @link substring="pNext" target="#pNext"
/// } VkBaseInStructure;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBaseInStructure.html"><code>VkBaseInStructure</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkBaseInStructure(@NotNull MemorySegment segment) implements IVkBaseInStructure {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBaseInStructure.html"><code>VkBaseInStructure</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkBaseInStructure}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkBaseInStructure to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkBaseInStructure.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkBaseInStructure, Iterable<VkBaseInStructure> {
        public long size() {
            return segment.byteSize() / VkBaseInStructure.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkBaseInStructure at(long index) {
            return new VkBaseInStructure(segment.asSlice(index * VkBaseInStructure.BYTES, VkBaseInStructure.BYTES));
        }

        public VkBaseInStructure.Ptr at(long index, @NotNull Consumer<@NotNull VkBaseInStructure> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkBaseInStructure value) {
            MemorySegment s = segment.asSlice(index * VkBaseInStructure.BYTES, VkBaseInStructure.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkBaseInStructure.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkBaseInStructure.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkBaseInStructure.BYTES,
                (end - start) * VkBaseInStructure.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkBaseInStructure.BYTES));
        }

        public VkBaseInStructure[] toArray() {
            VkBaseInStructure[] ret = new VkBaseInStructure[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkBaseInStructure> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkBaseInStructure> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkBaseInStructure.BYTES;
            }

            @Override
            public VkBaseInStructure next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkBaseInStructure ret = new VkBaseInStructure(segment.asSlice(0, VkBaseInStructure.BYTES));
                segment = segment.asSlice(VkBaseInStructure.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkBaseInStructure allocate(Arena arena) {
        return new VkBaseInStructure(arena.allocate(LAYOUT));
    }

    public static VkBaseInStructure.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkBaseInStructure.Ptr(segment);
    }

    public static VkBaseInStructure clone(Arena arena, VkBaseInStructure src) {
        VkBaseInStructure ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkBaseInStructure sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public VkBaseInStructure pNext(@Nullable IVkBaseInStructure value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pNextRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkBaseInStructure.Ptr pNext(int assumedCount) {
        MemorySegment s = pNextRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkBaseInStructure.BYTES);
        return new VkBaseInStructure.Ptr(s);
    }

    public @Nullable VkBaseInStructure pNext() {
        MemorySegment s = pNextRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkBaseInStructure(s);
    }

    public @Pointer(target=VkBaseInStructure.class) @NotNull MemorySegment pNextRaw() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public void pNextRaw(@Pointer(target=VkBaseInStructure.class) @NotNull MemorySegment value) {
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
