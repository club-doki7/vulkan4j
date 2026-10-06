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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkTensorDescriptionARM.html"><code>VkTensorDescriptionARM</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkTensorDescriptionARM {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkTensorTilingARM tiling; // @link substring="VkTensorTilingARM" target="VkTensorTilingARM" @link substring="tiling" target="#tiling"
///     VkFormat format; // @link substring="VkFormat" target="VkFormat" @link substring="format" target="#format"
///     uint32_t dimensionCount; // @link substring="dimensionCount" target="#dimensionCount"
///     int64_t const* pDimensions; // @link substring="pDimensions" target="#pDimensions"
///     int64_t const* pStrides; // @link substring="pStrides" target="#pStrides"
///     VkTensorUsageFlagsARM usage; // @link substring="VkTensorUsageFlagsARM" target="VkTensorUsageFlagsARM" @link substring="usage" target="#usage"
/// } VkTensorDescriptionARM;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_TENSOR_DESCRIPTION_ARM`
///
/// The {@code allocate} ({@link VkTensorDescriptionARM#allocate(Arena)}, {@link VkTensorDescriptionARM#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkTensorDescriptionARM#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkTensorDescriptionARM.html"><code>VkTensorDescriptionARM</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkTensorDescriptionARM(@NotNull MemorySegment segment) implements IVkTensorDescriptionARM {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkTensorDescriptionARM.html"><code>VkTensorDescriptionARM</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkTensorDescriptionARM}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkTensorDescriptionARM to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkTensorDescriptionARM.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkTensorDescriptionARM, Iterable<VkTensorDescriptionARM> {
        public long size() {
            return segment.byteSize() / VkTensorDescriptionARM.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkTensorDescriptionARM at(long index) {
            return new VkTensorDescriptionARM(segment.asSlice(index * VkTensorDescriptionARM.BYTES, VkTensorDescriptionARM.BYTES));
        }

        public VkTensorDescriptionARM.Ptr at(long index, @NotNull Consumer<@NotNull VkTensorDescriptionARM> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkTensorDescriptionARM value) {
            MemorySegment s = segment.asSlice(index * VkTensorDescriptionARM.BYTES, VkTensorDescriptionARM.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkTensorDescriptionARM.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkTensorDescriptionARM.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkTensorDescriptionARM.BYTES,
                (end - start) * VkTensorDescriptionARM.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkTensorDescriptionARM.BYTES));
        }

        public VkTensorDescriptionARM[] toArray() {
            VkTensorDescriptionARM[] ret = new VkTensorDescriptionARM[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkTensorDescriptionARM> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkTensorDescriptionARM> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkTensorDescriptionARM.BYTES;
            }

            @Override
            public VkTensorDescriptionARM next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkTensorDescriptionARM ret = new VkTensorDescriptionARM(segment.asSlice(0, VkTensorDescriptionARM.BYTES));
                segment = segment.asSlice(VkTensorDescriptionARM.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkTensorDescriptionARM allocate(Arena arena) {
        VkTensorDescriptionARM ret = new VkTensorDescriptionARM(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.TENSOR_DESCRIPTION_ARM);
        return ret;
    }

    public static VkTensorDescriptionARM.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkTensorDescriptionARM.Ptr ret = new VkTensorDescriptionARM.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.TENSOR_DESCRIPTION_ARM);
        }
        return ret;
    }

    public static VkTensorDescriptionARM clone(Arena arena, VkTensorDescriptionARM src) {
        VkTensorDescriptionARM ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.TENSOR_DESCRIPTION_ARM);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkTensorDescriptionARM sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkTensorDescriptionARM pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkTensorDescriptionARM pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @EnumType(VkTensorTilingARM.class) int tiling() {
        return segment.get(LAYOUT$tiling, OFFSET$tiling);
    }

    public VkTensorDescriptionARM tiling(@EnumType(VkTensorTilingARM.class) int value) {
        segment.set(LAYOUT$tiling, OFFSET$tiling, value);
        return this;
    }

    public @EnumType(VkFormat.class) int format() {
        return segment.get(LAYOUT$format, OFFSET$format);
    }

    public VkTensorDescriptionARM format(@EnumType(VkFormat.class) int value) {
        segment.set(LAYOUT$format, OFFSET$format, value);
        return this;
    }

    public @Unsigned int dimensionCount() {
        return segment.get(LAYOUT$dimensionCount, OFFSET$dimensionCount);
    }

    public VkTensorDescriptionARM dimensionCount(@Unsigned int value) {
        segment.set(LAYOUT$dimensionCount, OFFSET$dimensionCount, value);
        return this;
    }

    /// Note: the returned {@link LongPtr} does not have correct
    /// {@link LongPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link LongPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable LongPtr pDimensions() {
        MemorySegment s = pDimensionsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new LongPtr(s);
    }

    public VkTensorDescriptionARM pDimensions(@Nullable LongPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pDimensionsRaw(s);
        return this;
    }

    public @Pointer(comment="int64_t*") @NotNull MemorySegment pDimensionsRaw() {
        return segment.get(LAYOUT$pDimensions, OFFSET$pDimensions);
    }

    public void pDimensionsRaw(@Pointer(comment="int64_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pDimensions, OFFSET$pDimensions, value);
    }

    /// Note: the returned {@link LongPtr} does not have correct
    /// {@link LongPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link LongPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable LongPtr pStrides() {
        MemorySegment s = pStridesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new LongPtr(s);
    }

    public VkTensorDescriptionARM pStrides(@Nullable LongPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pStridesRaw(s);
        return this;
    }

    public @Pointer(comment="int64_t*") @NotNull MemorySegment pStridesRaw() {
        return segment.get(LAYOUT$pStrides, OFFSET$pStrides);
    }

    public void pStridesRaw(@Pointer(comment="int64_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pStrides, OFFSET$pStrides, value);
    }

    public @Bitmask(VkTensorUsageFlagsARM.class) long usage() {
        return segment.get(LAYOUT$usage, OFFSET$usage);
    }

    public VkTensorDescriptionARM usage(@Bitmask(VkTensorUsageFlagsARM.class) long value) {
        segment.set(LAYOUT$usage, OFFSET$usage, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("tiling"),
        ValueLayout.JAVA_INT.withName("format"),
        ValueLayout.JAVA_INT.withName("dimensionCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG).withName("pDimensions"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_LONG).withName("pStrides"),
        ValueLayout.JAVA_LONG.withName("usage")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$tiling = PathElement.groupElement("tiling");
    public static final PathElement PATH$format = PathElement.groupElement("format");
    public static final PathElement PATH$dimensionCount = PathElement.groupElement("dimensionCount");
    public static final PathElement PATH$pDimensions = PathElement.groupElement("pDimensions");
    public static final PathElement PATH$pStrides = PathElement.groupElement("pStrides");
    public static final PathElement PATH$usage = PathElement.groupElement("usage");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$tiling = (OfInt) LAYOUT.select(PATH$tiling);
    public static final OfInt LAYOUT$format = (OfInt) LAYOUT.select(PATH$format);
    public static final OfInt LAYOUT$dimensionCount = (OfInt) LAYOUT.select(PATH$dimensionCount);
    public static final AddressLayout LAYOUT$pDimensions = (AddressLayout) LAYOUT.select(PATH$pDimensions);
    public static final AddressLayout LAYOUT$pStrides = (AddressLayout) LAYOUT.select(PATH$pStrides);
    public static final OfLong LAYOUT$usage = (OfLong) LAYOUT.select(PATH$usage);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$tiling = LAYOUT$tiling.byteSize();
    public static final long SIZE$format = LAYOUT$format.byteSize();
    public static final long SIZE$dimensionCount = LAYOUT$dimensionCount.byteSize();
    public static final long SIZE$pDimensions = LAYOUT$pDimensions.byteSize();
    public static final long SIZE$pStrides = LAYOUT$pStrides.byteSize();
    public static final long SIZE$usage = LAYOUT$usage.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$tiling = LAYOUT.byteOffset(PATH$tiling);
    public static final long OFFSET$format = LAYOUT.byteOffset(PATH$format);
    public static final long OFFSET$dimensionCount = LAYOUT.byteOffset(PATH$dimensionCount);
    public static final long OFFSET$pDimensions = LAYOUT.byteOffset(PATH$pDimensions);
    public static final long OFFSET$pStrides = LAYOUT.byteOffset(PATH$pStrides);
    public static final long OFFSET$usage = LAYOUT.byteOffset(PATH$usage);
}
