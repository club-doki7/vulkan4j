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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMutableDescriptorTypeCreateInfoEXT.html"><code>VkMutableDescriptorTypeCreateInfoEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkMutableDescriptorTypeCreateInfoEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t mutableDescriptorTypeListCount; // optional // @link substring="mutableDescriptorTypeListCount" target="#mutableDescriptorTypeListCount"
///     VkMutableDescriptorTypeListEXT const* pMutableDescriptorTypeLists; // optional // @link substring="VkMutableDescriptorTypeListEXT" target="VkMutableDescriptorTypeListEXT" @link substring="pMutableDescriptorTypeLists" target="#pMutableDescriptorTypeLists"
/// } VkMutableDescriptorTypeCreateInfoEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_MUTABLE_DESCRIPTOR_TYPE_CREATE_INFO_EXT`
///
/// The {@code allocate} ({@link VkMutableDescriptorTypeCreateInfoEXT#allocate(Arena)}, {@link VkMutableDescriptorTypeCreateInfoEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkMutableDescriptorTypeCreateInfoEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMutableDescriptorTypeCreateInfoEXT.html"><code>VkMutableDescriptorTypeCreateInfoEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkMutableDescriptorTypeCreateInfoEXT(@NotNull MemorySegment segment) implements IVkMutableDescriptorTypeCreateInfoEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMutableDescriptorTypeCreateInfoEXT.html"><code>VkMutableDescriptorTypeCreateInfoEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkMutableDescriptorTypeCreateInfoEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkMutableDescriptorTypeCreateInfoEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkMutableDescriptorTypeCreateInfoEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkMutableDescriptorTypeCreateInfoEXT, Iterable<VkMutableDescriptorTypeCreateInfoEXT> {
        public long size() {
            return segment.byteSize() / VkMutableDescriptorTypeCreateInfoEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkMutableDescriptorTypeCreateInfoEXT at(long index) {
            return new VkMutableDescriptorTypeCreateInfoEXT(segment.asSlice(index * VkMutableDescriptorTypeCreateInfoEXT.BYTES, VkMutableDescriptorTypeCreateInfoEXT.BYTES));
        }

        public VkMutableDescriptorTypeCreateInfoEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkMutableDescriptorTypeCreateInfoEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkMutableDescriptorTypeCreateInfoEXT value) {
            MemorySegment s = segment.asSlice(index * VkMutableDescriptorTypeCreateInfoEXT.BYTES, VkMutableDescriptorTypeCreateInfoEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkMutableDescriptorTypeCreateInfoEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkMutableDescriptorTypeCreateInfoEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkMutableDescriptorTypeCreateInfoEXT.BYTES,
                (end - start) * VkMutableDescriptorTypeCreateInfoEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkMutableDescriptorTypeCreateInfoEXT.BYTES));
        }

        public VkMutableDescriptorTypeCreateInfoEXT[] toArray() {
            VkMutableDescriptorTypeCreateInfoEXT[] ret = new VkMutableDescriptorTypeCreateInfoEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkMutableDescriptorTypeCreateInfoEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkMutableDescriptorTypeCreateInfoEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkMutableDescriptorTypeCreateInfoEXT.BYTES;
            }

            @Override
            public VkMutableDescriptorTypeCreateInfoEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkMutableDescriptorTypeCreateInfoEXT ret = new VkMutableDescriptorTypeCreateInfoEXT(segment.asSlice(0, VkMutableDescriptorTypeCreateInfoEXT.BYTES));
                segment = segment.asSlice(VkMutableDescriptorTypeCreateInfoEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkMutableDescriptorTypeCreateInfoEXT allocate(Arena arena) {
        VkMutableDescriptorTypeCreateInfoEXT ret = new VkMutableDescriptorTypeCreateInfoEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.MUTABLE_DESCRIPTOR_TYPE_CREATE_INFO_EXT);
        return ret;
    }

    public static VkMutableDescriptorTypeCreateInfoEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkMutableDescriptorTypeCreateInfoEXT.Ptr ret = new VkMutableDescriptorTypeCreateInfoEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.MUTABLE_DESCRIPTOR_TYPE_CREATE_INFO_EXT);
        }
        return ret;
    }

    public static VkMutableDescriptorTypeCreateInfoEXT clone(Arena arena, VkMutableDescriptorTypeCreateInfoEXT src) {
        VkMutableDescriptorTypeCreateInfoEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.MUTABLE_DESCRIPTOR_TYPE_CREATE_INFO_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkMutableDescriptorTypeCreateInfoEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkMutableDescriptorTypeCreateInfoEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkMutableDescriptorTypeCreateInfoEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int mutableDescriptorTypeListCount() {
        return segment.get(LAYOUT$mutableDescriptorTypeListCount, OFFSET$mutableDescriptorTypeListCount);
    }

    public VkMutableDescriptorTypeCreateInfoEXT mutableDescriptorTypeListCount(@Unsigned int value) {
        segment.set(LAYOUT$mutableDescriptorTypeListCount, OFFSET$mutableDescriptorTypeListCount, value);
        return this;
    }

    public VkMutableDescriptorTypeCreateInfoEXT pMutableDescriptorTypeLists(@Nullable IVkMutableDescriptorTypeListEXT value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pMutableDescriptorTypeListsRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkMutableDescriptorTypeListEXT.Ptr pMutableDescriptorTypeLists(int assumedCount) {
        MemorySegment s = pMutableDescriptorTypeListsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkMutableDescriptorTypeListEXT.BYTES);
        return new VkMutableDescriptorTypeListEXT.Ptr(s);
    }

    public @Nullable VkMutableDescriptorTypeListEXT pMutableDescriptorTypeLists() {
        MemorySegment s = pMutableDescriptorTypeListsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkMutableDescriptorTypeListEXT(s);
    }

    public @Pointer(target=VkMutableDescriptorTypeListEXT.class) @NotNull MemorySegment pMutableDescriptorTypeListsRaw() {
        return segment.get(LAYOUT$pMutableDescriptorTypeLists, OFFSET$pMutableDescriptorTypeLists);
    }

    public void pMutableDescriptorTypeListsRaw(@Pointer(target=VkMutableDescriptorTypeListEXT.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pMutableDescriptorTypeLists, OFFSET$pMutableDescriptorTypeLists, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("mutableDescriptorTypeListCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkMutableDescriptorTypeListEXT.LAYOUT).withName("pMutableDescriptorTypeLists")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$mutableDescriptorTypeListCount = PathElement.groupElement("mutableDescriptorTypeListCount");
    public static final PathElement PATH$pMutableDescriptorTypeLists = PathElement.groupElement("pMutableDescriptorTypeLists");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$mutableDescriptorTypeListCount = (OfInt) LAYOUT.select(PATH$mutableDescriptorTypeListCount);
    public static final AddressLayout LAYOUT$pMutableDescriptorTypeLists = (AddressLayout) LAYOUT.select(PATH$pMutableDescriptorTypeLists);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$mutableDescriptorTypeListCount = LAYOUT$mutableDescriptorTypeListCount.byteSize();
    public static final long SIZE$pMutableDescriptorTypeLists = LAYOUT$pMutableDescriptorTypeLists.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$mutableDescriptorTypeListCount = LAYOUT.byteOffset(PATH$mutableDescriptorTypeListCount);
    public static final long OFFSET$pMutableDescriptorTypeLists = LAYOUT.byteOffset(PATH$pMutableDescriptorTypeLists);
}
