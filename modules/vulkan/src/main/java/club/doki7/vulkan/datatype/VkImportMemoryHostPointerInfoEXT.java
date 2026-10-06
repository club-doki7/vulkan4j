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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImportMemoryHostPointerInfoEXT.html"><code>VkImportMemoryHostPointerInfoEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkImportMemoryHostPointerInfoEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkExternalMemoryHandleTypeFlags handleType; // @link substring="VkExternalMemoryHandleTypeFlags" target="VkExternalMemoryHandleTypeFlags" @link substring="handleType" target="#handleType"
///     void* pHostPointer; // @link substring="pHostPointer" target="#pHostPointer"
/// } VkImportMemoryHostPointerInfoEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_IMPORT_MEMORY_HOST_POINTER_INFO_EXT`
///
/// The {@code allocate} ({@link VkImportMemoryHostPointerInfoEXT#allocate(Arena)}, {@link VkImportMemoryHostPointerInfoEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkImportMemoryHostPointerInfoEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImportMemoryHostPointerInfoEXT.html"><code>VkImportMemoryHostPointerInfoEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkImportMemoryHostPointerInfoEXT(@NotNull MemorySegment segment) implements IVkImportMemoryHostPointerInfoEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImportMemoryHostPointerInfoEXT.html"><code>VkImportMemoryHostPointerInfoEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkImportMemoryHostPointerInfoEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkImportMemoryHostPointerInfoEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkImportMemoryHostPointerInfoEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkImportMemoryHostPointerInfoEXT, Iterable<VkImportMemoryHostPointerInfoEXT> {
        public long size() {
            return segment.byteSize() / VkImportMemoryHostPointerInfoEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkImportMemoryHostPointerInfoEXT at(long index) {
            return new VkImportMemoryHostPointerInfoEXT(segment.asSlice(index * VkImportMemoryHostPointerInfoEXT.BYTES, VkImportMemoryHostPointerInfoEXT.BYTES));
        }

        public VkImportMemoryHostPointerInfoEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkImportMemoryHostPointerInfoEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkImportMemoryHostPointerInfoEXT value) {
            MemorySegment s = segment.asSlice(index * VkImportMemoryHostPointerInfoEXT.BYTES, VkImportMemoryHostPointerInfoEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkImportMemoryHostPointerInfoEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkImportMemoryHostPointerInfoEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkImportMemoryHostPointerInfoEXT.BYTES,
                (end - start) * VkImportMemoryHostPointerInfoEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkImportMemoryHostPointerInfoEXT.BYTES));
        }

        public VkImportMemoryHostPointerInfoEXT[] toArray() {
            VkImportMemoryHostPointerInfoEXT[] ret = new VkImportMemoryHostPointerInfoEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkImportMemoryHostPointerInfoEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkImportMemoryHostPointerInfoEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkImportMemoryHostPointerInfoEXT.BYTES;
            }

            @Override
            public VkImportMemoryHostPointerInfoEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkImportMemoryHostPointerInfoEXT ret = new VkImportMemoryHostPointerInfoEXT(segment.asSlice(0, VkImportMemoryHostPointerInfoEXT.BYTES));
                segment = segment.asSlice(VkImportMemoryHostPointerInfoEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkImportMemoryHostPointerInfoEXT allocate(Arena arena) {
        VkImportMemoryHostPointerInfoEXT ret = new VkImportMemoryHostPointerInfoEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.IMPORT_MEMORY_HOST_POINTER_INFO_EXT);
        return ret;
    }

    public static VkImportMemoryHostPointerInfoEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkImportMemoryHostPointerInfoEXT.Ptr ret = new VkImportMemoryHostPointerInfoEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.IMPORT_MEMORY_HOST_POINTER_INFO_EXT);
        }
        return ret;
    }

    public static VkImportMemoryHostPointerInfoEXT clone(Arena arena, VkImportMemoryHostPointerInfoEXT src) {
        VkImportMemoryHostPointerInfoEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.IMPORT_MEMORY_HOST_POINTER_INFO_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkImportMemoryHostPointerInfoEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkImportMemoryHostPointerInfoEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkImportMemoryHostPointerInfoEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkExternalMemoryHandleTypeFlags.class) int handleType() {
        return segment.get(LAYOUT$handleType, OFFSET$handleType);
    }

    public VkImportMemoryHostPointerInfoEXT handleType(@Bitmask(VkExternalMemoryHandleTypeFlags.class) int value) {
        segment.set(LAYOUT$handleType, OFFSET$handleType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pHostPointer() {
        return segment.get(LAYOUT$pHostPointer, OFFSET$pHostPointer);
    }

    public VkImportMemoryHostPointerInfoEXT pHostPointer(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pHostPointer, OFFSET$pHostPointer, value);
        return this;
    }

    public VkImportMemoryHostPointerInfoEXT pHostPointer(@Nullable IPointer pointer) {
        pHostPointer(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("handleType"),
        ValueLayout.ADDRESS.withName("pHostPointer")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$handleType = PathElement.groupElement("handleType");
    public static final PathElement PATH$pHostPointer = PathElement.groupElement("pHostPointer");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$handleType = (OfInt) LAYOUT.select(PATH$handleType);
    public static final AddressLayout LAYOUT$pHostPointer = (AddressLayout) LAYOUT.select(PATH$pHostPointer);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$handleType = LAYOUT$handleType.byteSize();
    public static final long SIZE$pHostPointer = LAYOUT$pHostPointer.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$handleType = LAYOUT.byteOffset(PATH$handleType);
    public static final long OFFSET$pHostPointer = LAYOUT.byteOffset(PATH$pHostPointer);
}
