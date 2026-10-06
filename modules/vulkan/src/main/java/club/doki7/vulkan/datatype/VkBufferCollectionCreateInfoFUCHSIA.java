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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBufferCollectionCreateInfoFUCHSIA.html"><code>VkBufferCollectionCreateInfoFUCHSIA</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkBufferCollectionCreateInfoFUCHSIA {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     zx_handle_t collectionToken; // @link substring="collectionToken" target="#collectionToken"
/// } VkBufferCollectionCreateInfoFUCHSIA;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_BUFFER_COLLECTION_CREATE_INFO_FUCHSIA`
///
/// The {@code allocate} ({@link VkBufferCollectionCreateInfoFUCHSIA#allocate(Arena)}, {@link VkBufferCollectionCreateInfoFUCHSIA#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkBufferCollectionCreateInfoFUCHSIA#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBufferCollectionCreateInfoFUCHSIA.html"><code>VkBufferCollectionCreateInfoFUCHSIA</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkBufferCollectionCreateInfoFUCHSIA(@NotNull MemorySegment segment) implements IVkBufferCollectionCreateInfoFUCHSIA {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBufferCollectionCreateInfoFUCHSIA.html"><code>VkBufferCollectionCreateInfoFUCHSIA</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkBufferCollectionCreateInfoFUCHSIA}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkBufferCollectionCreateInfoFUCHSIA to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkBufferCollectionCreateInfoFUCHSIA.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkBufferCollectionCreateInfoFUCHSIA, Iterable<VkBufferCollectionCreateInfoFUCHSIA> {
        public long size() {
            return segment.byteSize() / VkBufferCollectionCreateInfoFUCHSIA.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkBufferCollectionCreateInfoFUCHSIA at(long index) {
            return new VkBufferCollectionCreateInfoFUCHSIA(segment.asSlice(index * VkBufferCollectionCreateInfoFUCHSIA.BYTES, VkBufferCollectionCreateInfoFUCHSIA.BYTES));
        }

        public VkBufferCollectionCreateInfoFUCHSIA.Ptr at(long index, @NotNull Consumer<@NotNull VkBufferCollectionCreateInfoFUCHSIA> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkBufferCollectionCreateInfoFUCHSIA value) {
            MemorySegment s = segment.asSlice(index * VkBufferCollectionCreateInfoFUCHSIA.BYTES, VkBufferCollectionCreateInfoFUCHSIA.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkBufferCollectionCreateInfoFUCHSIA.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkBufferCollectionCreateInfoFUCHSIA.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkBufferCollectionCreateInfoFUCHSIA.BYTES,
                (end - start) * VkBufferCollectionCreateInfoFUCHSIA.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkBufferCollectionCreateInfoFUCHSIA.BYTES));
        }

        public VkBufferCollectionCreateInfoFUCHSIA[] toArray() {
            VkBufferCollectionCreateInfoFUCHSIA[] ret = new VkBufferCollectionCreateInfoFUCHSIA[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkBufferCollectionCreateInfoFUCHSIA> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkBufferCollectionCreateInfoFUCHSIA> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkBufferCollectionCreateInfoFUCHSIA.BYTES;
            }

            @Override
            public VkBufferCollectionCreateInfoFUCHSIA next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkBufferCollectionCreateInfoFUCHSIA ret = new VkBufferCollectionCreateInfoFUCHSIA(segment.asSlice(0, VkBufferCollectionCreateInfoFUCHSIA.BYTES));
                segment = segment.asSlice(VkBufferCollectionCreateInfoFUCHSIA.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkBufferCollectionCreateInfoFUCHSIA allocate(Arena arena) {
        VkBufferCollectionCreateInfoFUCHSIA ret = new VkBufferCollectionCreateInfoFUCHSIA(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.BUFFER_COLLECTION_CREATE_INFO_FUCHSIA);
        return ret;
    }

    public static VkBufferCollectionCreateInfoFUCHSIA.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkBufferCollectionCreateInfoFUCHSIA.Ptr ret = new VkBufferCollectionCreateInfoFUCHSIA.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.BUFFER_COLLECTION_CREATE_INFO_FUCHSIA);
        }
        return ret;
    }

    public static VkBufferCollectionCreateInfoFUCHSIA clone(Arena arena, VkBufferCollectionCreateInfoFUCHSIA src) {
        VkBufferCollectionCreateInfoFUCHSIA ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.BUFFER_COLLECTION_CREATE_INFO_FUCHSIA);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkBufferCollectionCreateInfoFUCHSIA sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkBufferCollectionCreateInfoFUCHSIA pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkBufferCollectionCreateInfoFUCHSIA pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("zx_handle_t") @Unsigned int collectionToken() {
        return segment.get(LAYOUT$collectionToken, OFFSET$collectionToken);
    }

    public VkBufferCollectionCreateInfoFUCHSIA collectionToken(@NativeType("zx_handle_t") @Unsigned int value) {
        segment.set(LAYOUT$collectionToken, OFFSET$collectionToken, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("collectionToken")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$collectionToken = PathElement.groupElement("collectionToken");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$collectionToken = (OfInt) LAYOUT.select(PATH$collectionToken);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$collectionToken = LAYOUT$collectionToken.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$collectionToken = LAYOUT.byteOffset(PATH$collectionToken);
}
