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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCopyTensorInfoARM.html"><code>VkCopyTensorInfoARM</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkCopyTensorInfoARM {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkTensorARM srcTensor; // @link substring="VkTensorARM" target="VkTensorARM" @link substring="srcTensor" target="#srcTensor"
///     VkTensorARM dstTensor; // @link substring="VkTensorARM" target="VkTensorARM" @link substring="dstTensor" target="#dstTensor"
///     uint32_t regionCount; // @link substring="regionCount" target="#regionCount"
///     VkTensorCopyARM const* pRegions; // @link substring="VkTensorCopyARM" target="VkTensorCopyARM" @link substring="pRegions" target="#pRegions"
/// } VkCopyTensorInfoARM;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_COPY_TENSOR_INFO_ARM`
///
/// The {@code allocate} ({@link VkCopyTensorInfoARM#allocate(Arena)}, {@link VkCopyTensorInfoARM#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkCopyTensorInfoARM#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCopyTensorInfoARM.html"><code>VkCopyTensorInfoARM</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkCopyTensorInfoARM(@NotNull MemorySegment segment) implements IVkCopyTensorInfoARM {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCopyTensorInfoARM.html"><code>VkCopyTensorInfoARM</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkCopyTensorInfoARM}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkCopyTensorInfoARM to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkCopyTensorInfoARM.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkCopyTensorInfoARM, Iterable<VkCopyTensorInfoARM> {
        public long size() {
            return segment.byteSize() / VkCopyTensorInfoARM.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkCopyTensorInfoARM at(long index) {
            return new VkCopyTensorInfoARM(segment.asSlice(index * VkCopyTensorInfoARM.BYTES, VkCopyTensorInfoARM.BYTES));
        }

        public VkCopyTensorInfoARM.Ptr at(long index, @NotNull Consumer<@NotNull VkCopyTensorInfoARM> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkCopyTensorInfoARM value) {
            MemorySegment s = segment.asSlice(index * VkCopyTensorInfoARM.BYTES, VkCopyTensorInfoARM.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkCopyTensorInfoARM.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkCopyTensorInfoARM.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkCopyTensorInfoARM.BYTES,
                (end - start) * VkCopyTensorInfoARM.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkCopyTensorInfoARM.BYTES));
        }

        public VkCopyTensorInfoARM[] toArray() {
            VkCopyTensorInfoARM[] ret = new VkCopyTensorInfoARM[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkCopyTensorInfoARM> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkCopyTensorInfoARM> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkCopyTensorInfoARM.BYTES;
            }

            @Override
            public VkCopyTensorInfoARM next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkCopyTensorInfoARM ret = new VkCopyTensorInfoARM(segment.asSlice(0, VkCopyTensorInfoARM.BYTES));
                segment = segment.asSlice(VkCopyTensorInfoARM.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkCopyTensorInfoARM allocate(Arena arena) {
        VkCopyTensorInfoARM ret = new VkCopyTensorInfoARM(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.COPY_TENSOR_INFO_ARM);
        return ret;
    }

    public static VkCopyTensorInfoARM.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkCopyTensorInfoARM.Ptr ret = new VkCopyTensorInfoARM.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.COPY_TENSOR_INFO_ARM);
        }
        return ret;
    }

    public static VkCopyTensorInfoARM clone(Arena arena, VkCopyTensorInfoARM src) {
        VkCopyTensorInfoARM ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.COPY_TENSOR_INFO_ARM);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkCopyTensorInfoARM sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkCopyTensorInfoARM pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkCopyTensorInfoARM pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Nullable VkTensorARM srcTensor() {
        MemorySegment s = segment.asSlice(OFFSET$srcTensor, SIZE$srcTensor);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkTensorARM(s);
    }

    public VkCopyTensorInfoARM srcTensor(@Nullable VkTensorARM value) {
        segment.set(LAYOUT$srcTensor, OFFSET$srcTensor, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Nullable VkTensorARM dstTensor() {
        MemorySegment s = segment.asSlice(OFFSET$dstTensor, SIZE$dstTensor);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkTensorARM(s);
    }

    public VkCopyTensorInfoARM dstTensor(@Nullable VkTensorARM value) {
        segment.set(LAYOUT$dstTensor, OFFSET$dstTensor, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int regionCount() {
        return segment.get(LAYOUT$regionCount, OFFSET$regionCount);
    }

    public VkCopyTensorInfoARM regionCount(@Unsigned int value) {
        segment.set(LAYOUT$regionCount, OFFSET$regionCount, value);
        return this;
    }

    public VkCopyTensorInfoARM pRegions(@Nullable IVkTensorCopyARM value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pRegionsRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkTensorCopyARM.Ptr pRegions(int assumedCount) {
        MemorySegment s = pRegionsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkTensorCopyARM.BYTES);
        return new VkTensorCopyARM.Ptr(s);
    }

    public @Nullable VkTensorCopyARM pRegions() {
        MemorySegment s = pRegionsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkTensorCopyARM(s);
    }

    public @Pointer(target=VkTensorCopyARM.class) @NotNull MemorySegment pRegionsRaw() {
        return segment.get(LAYOUT$pRegions, OFFSET$pRegions);
    }

    public void pRegionsRaw(@Pointer(target=VkTensorCopyARM.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pRegions, OFFSET$pRegions, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withName("srcTensor"),
        ValueLayout.ADDRESS.withName("dstTensor"),
        ValueLayout.JAVA_INT.withName("regionCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkTensorCopyARM.LAYOUT).withName("pRegions")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$srcTensor = PathElement.groupElement("srcTensor");
    public static final PathElement PATH$dstTensor = PathElement.groupElement("dstTensor");
    public static final PathElement PATH$regionCount = PathElement.groupElement("regionCount");
    public static final PathElement PATH$pRegions = PathElement.groupElement("pRegions");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$srcTensor = (AddressLayout) LAYOUT.select(PATH$srcTensor);
    public static final AddressLayout LAYOUT$dstTensor = (AddressLayout) LAYOUT.select(PATH$dstTensor);
    public static final OfInt LAYOUT$regionCount = (OfInt) LAYOUT.select(PATH$regionCount);
    public static final AddressLayout LAYOUT$pRegions = (AddressLayout) LAYOUT.select(PATH$pRegions);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$srcTensor = LAYOUT$srcTensor.byteSize();
    public static final long SIZE$dstTensor = LAYOUT$dstTensor.byteSize();
    public static final long SIZE$regionCount = LAYOUT$regionCount.byteSize();
    public static final long SIZE$pRegions = LAYOUT$pRegions.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$srcTensor = LAYOUT.byteOffset(PATH$srcTensor);
    public static final long OFFSET$dstTensor = LAYOUT.byteOffset(PATH$dstTensor);
    public static final long OFFSET$regionCount = LAYOUT.byteOffset(PATH$regionCount);
    public static final long OFFSET$pRegions = LAYOUT.byteOffset(PATH$pRegions);
}
