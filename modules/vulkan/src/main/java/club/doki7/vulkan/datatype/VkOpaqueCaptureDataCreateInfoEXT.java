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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkOpaqueCaptureDataCreateInfoEXT.html"><code>VkOpaqueCaptureDataCreateInfoEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkOpaqueCaptureDataCreateInfoEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkHostAddressRangeConstEXT const* pData; // optional // @link substring="VkHostAddressRangeConstEXT" target="VkHostAddressRangeConstEXT" @link substring="pData" target="#pData"
/// } VkOpaqueCaptureDataCreateInfoEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_OPAQUE_CAPTURE_DATA_CREATE_INFO_EXT`
///
/// The {@code allocate} ({@link VkOpaqueCaptureDataCreateInfoEXT#allocate(Arena)}, {@link VkOpaqueCaptureDataCreateInfoEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkOpaqueCaptureDataCreateInfoEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkOpaqueCaptureDataCreateInfoEXT.html"><code>VkOpaqueCaptureDataCreateInfoEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkOpaqueCaptureDataCreateInfoEXT(@NotNull MemorySegment segment) implements IVkOpaqueCaptureDataCreateInfoEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkOpaqueCaptureDataCreateInfoEXT.html"><code>VkOpaqueCaptureDataCreateInfoEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkOpaqueCaptureDataCreateInfoEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkOpaqueCaptureDataCreateInfoEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkOpaqueCaptureDataCreateInfoEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkOpaqueCaptureDataCreateInfoEXT, Iterable<VkOpaqueCaptureDataCreateInfoEXT> {
        public long size() {
            return segment.byteSize() / VkOpaqueCaptureDataCreateInfoEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkOpaqueCaptureDataCreateInfoEXT at(long index) {
            return new VkOpaqueCaptureDataCreateInfoEXT(segment.asSlice(index * VkOpaqueCaptureDataCreateInfoEXT.BYTES, VkOpaqueCaptureDataCreateInfoEXT.BYTES));
        }

        public VkOpaqueCaptureDataCreateInfoEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkOpaqueCaptureDataCreateInfoEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkOpaqueCaptureDataCreateInfoEXT value) {
            MemorySegment s = segment.asSlice(index * VkOpaqueCaptureDataCreateInfoEXT.BYTES, VkOpaqueCaptureDataCreateInfoEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkOpaqueCaptureDataCreateInfoEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkOpaqueCaptureDataCreateInfoEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkOpaqueCaptureDataCreateInfoEXT.BYTES,
                (end - start) * VkOpaqueCaptureDataCreateInfoEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkOpaqueCaptureDataCreateInfoEXT.BYTES));
        }

        public VkOpaqueCaptureDataCreateInfoEXT[] toArray() {
            VkOpaqueCaptureDataCreateInfoEXT[] ret = new VkOpaqueCaptureDataCreateInfoEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkOpaqueCaptureDataCreateInfoEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkOpaqueCaptureDataCreateInfoEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkOpaqueCaptureDataCreateInfoEXT.BYTES;
            }

            @Override
            public VkOpaqueCaptureDataCreateInfoEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkOpaqueCaptureDataCreateInfoEXT ret = new VkOpaqueCaptureDataCreateInfoEXT(segment.asSlice(0, VkOpaqueCaptureDataCreateInfoEXT.BYTES));
                segment = segment.asSlice(VkOpaqueCaptureDataCreateInfoEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkOpaqueCaptureDataCreateInfoEXT allocate(Arena arena) {
        VkOpaqueCaptureDataCreateInfoEXT ret = new VkOpaqueCaptureDataCreateInfoEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.OPAQUE_CAPTURE_DATA_CREATE_INFO_EXT);
        return ret;
    }

    public static VkOpaqueCaptureDataCreateInfoEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkOpaqueCaptureDataCreateInfoEXT.Ptr ret = new VkOpaqueCaptureDataCreateInfoEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.OPAQUE_CAPTURE_DATA_CREATE_INFO_EXT);
        }
        return ret;
    }

    public static VkOpaqueCaptureDataCreateInfoEXT clone(Arena arena, VkOpaqueCaptureDataCreateInfoEXT src) {
        VkOpaqueCaptureDataCreateInfoEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.OPAQUE_CAPTURE_DATA_CREATE_INFO_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkOpaqueCaptureDataCreateInfoEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkOpaqueCaptureDataCreateInfoEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkOpaqueCaptureDataCreateInfoEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public VkOpaqueCaptureDataCreateInfoEXT pData(@Nullable IVkHostAddressRangeConstEXT value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pDataRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkHostAddressRangeConstEXT.Ptr pData(int assumedCount) {
        MemorySegment s = pDataRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkHostAddressRangeConstEXT.BYTES);
        return new VkHostAddressRangeConstEXT.Ptr(s);
    }

    public @Nullable VkHostAddressRangeConstEXT pData() {
        MemorySegment s = pDataRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkHostAddressRangeConstEXT(s);
    }

    public @Pointer(target=VkHostAddressRangeConstEXT.class) @NotNull MemorySegment pDataRaw() {
        return segment.get(LAYOUT$pData, OFFSET$pData);
    }

    public void pDataRaw(@Pointer(target=VkHostAddressRangeConstEXT.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pData, OFFSET$pData, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withTargetLayout(VkHostAddressRangeConstEXT.LAYOUT).withName("pData")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$pData = PathElement.groupElement("pData");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$pData = (AddressLayout) LAYOUT.select(PATH$pData);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$pData = LAYOUT$pData.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$pData = LAYOUT.byteOffset(PATH$pData);
}
