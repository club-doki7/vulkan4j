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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGeometryTrianglesNV.html"><code>VkGeometryTrianglesNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkGeometryTrianglesNV {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBuffer vertexData; // optional // @link substring="VkBuffer" target="VkBuffer" @link substring="vertexData" target="#vertexData"
///     VkDeviceSize vertexOffset; // @link substring="vertexOffset" target="#vertexOffset"
///     uint32_t vertexCount; // @link substring="vertexCount" target="#vertexCount"
///     VkDeviceSize vertexStride; // @link substring="vertexStride" target="#vertexStride"
///     VkFormat vertexFormat; // @link substring="VkFormat" target="VkFormat" @link substring="vertexFormat" target="#vertexFormat"
///     VkBuffer indexData; // optional // @link substring="VkBuffer" target="VkBuffer" @link substring="indexData" target="#indexData"
///     VkDeviceSize indexOffset; // @link substring="indexOffset" target="#indexOffset"
///     uint32_t indexCount; // @link substring="indexCount" target="#indexCount"
///     VkIndexType indexType; // @link substring="VkIndexType" target="VkIndexType" @link substring="indexType" target="#indexType"
///     VkBuffer transformData; // optional // @link substring="VkBuffer" target="VkBuffer" @link substring="transformData" target="#transformData"
///     VkDeviceSize transformOffset; // @link substring="transformOffset" target="#transformOffset"
/// } VkGeometryTrianglesNV;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_GEOMETRY_TRIANGLES_NV`
///
/// The {@code allocate} ({@link VkGeometryTrianglesNV#allocate(Arena)}, {@link VkGeometryTrianglesNV#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkGeometryTrianglesNV#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGeometryTrianglesNV.html"><code>VkGeometryTrianglesNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkGeometryTrianglesNV(@NotNull MemorySegment segment) implements IVkGeometryTrianglesNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkGeometryTrianglesNV.html"><code>VkGeometryTrianglesNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkGeometryTrianglesNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkGeometryTrianglesNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkGeometryTrianglesNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkGeometryTrianglesNV, Iterable<VkGeometryTrianglesNV> {
        public long size() {
            return segment.byteSize() / VkGeometryTrianglesNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkGeometryTrianglesNV at(long index) {
            return new VkGeometryTrianglesNV(segment.asSlice(index * VkGeometryTrianglesNV.BYTES, VkGeometryTrianglesNV.BYTES));
        }

        public VkGeometryTrianglesNV.Ptr at(long index, @NotNull Consumer<@NotNull VkGeometryTrianglesNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkGeometryTrianglesNV value) {
            MemorySegment s = segment.asSlice(index * VkGeometryTrianglesNV.BYTES, VkGeometryTrianglesNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkGeometryTrianglesNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkGeometryTrianglesNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkGeometryTrianglesNV.BYTES,
                (end - start) * VkGeometryTrianglesNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkGeometryTrianglesNV.BYTES));
        }

        public VkGeometryTrianglesNV[] toArray() {
            VkGeometryTrianglesNV[] ret = new VkGeometryTrianglesNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkGeometryTrianglesNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkGeometryTrianglesNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkGeometryTrianglesNV.BYTES;
            }

            @Override
            public VkGeometryTrianglesNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkGeometryTrianglesNV ret = new VkGeometryTrianglesNV(segment.asSlice(0, VkGeometryTrianglesNV.BYTES));
                segment = segment.asSlice(VkGeometryTrianglesNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkGeometryTrianglesNV allocate(Arena arena) {
        VkGeometryTrianglesNV ret = new VkGeometryTrianglesNV(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.GEOMETRY_TRIANGLES_NV);
        return ret;
    }

    public static VkGeometryTrianglesNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkGeometryTrianglesNV.Ptr ret = new VkGeometryTrianglesNV.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.GEOMETRY_TRIANGLES_NV);
        }
        return ret;
    }

    public static VkGeometryTrianglesNV clone(Arena arena, VkGeometryTrianglesNV src) {
        VkGeometryTrianglesNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.GEOMETRY_TRIANGLES_NV);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkGeometryTrianglesNV sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkGeometryTrianglesNV pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkGeometryTrianglesNV pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Nullable VkBuffer vertexData() {
        MemorySegment s = segment.asSlice(OFFSET$vertexData, SIZE$vertexData);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkBuffer(s);
    }

    public VkGeometryTrianglesNV vertexData(@Nullable VkBuffer value) {
        segment.set(LAYOUT$vertexData, OFFSET$vertexData, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long vertexOffset() {
        return segment.get(LAYOUT$vertexOffset, OFFSET$vertexOffset);
    }

    public VkGeometryTrianglesNV vertexOffset(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$vertexOffset, OFFSET$vertexOffset, value);
        return this;
    }

    public @Unsigned int vertexCount() {
        return segment.get(LAYOUT$vertexCount, OFFSET$vertexCount);
    }

    public VkGeometryTrianglesNV vertexCount(@Unsigned int value) {
        segment.set(LAYOUT$vertexCount, OFFSET$vertexCount, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long vertexStride() {
        return segment.get(LAYOUT$vertexStride, OFFSET$vertexStride);
    }

    public VkGeometryTrianglesNV vertexStride(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$vertexStride, OFFSET$vertexStride, value);
        return this;
    }

    public @EnumType(VkFormat.class) int vertexFormat() {
        return segment.get(LAYOUT$vertexFormat, OFFSET$vertexFormat);
    }

    public VkGeometryTrianglesNV vertexFormat(@EnumType(VkFormat.class) int value) {
        segment.set(LAYOUT$vertexFormat, OFFSET$vertexFormat, value);
        return this;
    }

    public @Nullable VkBuffer indexData() {
        MemorySegment s = segment.asSlice(OFFSET$indexData, SIZE$indexData);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkBuffer(s);
    }

    public VkGeometryTrianglesNV indexData(@Nullable VkBuffer value) {
        segment.set(LAYOUT$indexData, OFFSET$indexData, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long indexOffset() {
        return segment.get(LAYOUT$indexOffset, OFFSET$indexOffset);
    }

    public VkGeometryTrianglesNV indexOffset(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$indexOffset, OFFSET$indexOffset, value);
        return this;
    }

    public @Unsigned int indexCount() {
        return segment.get(LAYOUT$indexCount, OFFSET$indexCount);
    }

    public VkGeometryTrianglesNV indexCount(@Unsigned int value) {
        segment.set(LAYOUT$indexCount, OFFSET$indexCount, value);
        return this;
    }

    public @EnumType(VkIndexType.class) int indexType() {
        return segment.get(LAYOUT$indexType, OFFSET$indexType);
    }

    public VkGeometryTrianglesNV indexType(@EnumType(VkIndexType.class) int value) {
        segment.set(LAYOUT$indexType, OFFSET$indexType, value);
        return this;
    }

    public @Nullable VkBuffer transformData() {
        MemorySegment s = segment.asSlice(OFFSET$transformData, SIZE$transformData);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkBuffer(s);
    }

    public VkGeometryTrianglesNV transformData(@Nullable VkBuffer value) {
        segment.set(LAYOUT$transformData, OFFSET$transformData, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long transformOffset() {
        return segment.get(LAYOUT$transformOffset, OFFSET$transformOffset);
    }

    public VkGeometryTrianglesNV transformOffset(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$transformOffset, OFFSET$transformOffset, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withName("vertexData"),
        ValueLayout.JAVA_LONG.withName("vertexOffset"),
        ValueLayout.JAVA_INT.withName("vertexCount"),
        ValueLayout.JAVA_LONG.withName("vertexStride"),
        ValueLayout.JAVA_INT.withName("vertexFormat"),
        ValueLayout.ADDRESS.withName("indexData"),
        ValueLayout.JAVA_LONG.withName("indexOffset"),
        ValueLayout.JAVA_INT.withName("indexCount"),
        ValueLayout.JAVA_INT.withName("indexType"),
        ValueLayout.ADDRESS.withName("transformData"),
        ValueLayout.JAVA_LONG.withName("transformOffset")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$vertexData = PathElement.groupElement("vertexData");
    public static final PathElement PATH$vertexOffset = PathElement.groupElement("vertexOffset");
    public static final PathElement PATH$vertexCount = PathElement.groupElement("vertexCount");
    public static final PathElement PATH$vertexStride = PathElement.groupElement("vertexStride");
    public static final PathElement PATH$vertexFormat = PathElement.groupElement("vertexFormat");
    public static final PathElement PATH$indexData = PathElement.groupElement("indexData");
    public static final PathElement PATH$indexOffset = PathElement.groupElement("indexOffset");
    public static final PathElement PATH$indexCount = PathElement.groupElement("indexCount");
    public static final PathElement PATH$indexType = PathElement.groupElement("indexType");
    public static final PathElement PATH$transformData = PathElement.groupElement("transformData");
    public static final PathElement PATH$transformOffset = PathElement.groupElement("transformOffset");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$vertexData = (AddressLayout) LAYOUT.select(PATH$vertexData);
    public static final OfLong LAYOUT$vertexOffset = (OfLong) LAYOUT.select(PATH$vertexOffset);
    public static final OfInt LAYOUT$vertexCount = (OfInt) LAYOUT.select(PATH$vertexCount);
    public static final OfLong LAYOUT$vertexStride = (OfLong) LAYOUT.select(PATH$vertexStride);
    public static final OfInt LAYOUT$vertexFormat = (OfInt) LAYOUT.select(PATH$vertexFormat);
    public static final AddressLayout LAYOUT$indexData = (AddressLayout) LAYOUT.select(PATH$indexData);
    public static final OfLong LAYOUT$indexOffset = (OfLong) LAYOUT.select(PATH$indexOffset);
    public static final OfInt LAYOUT$indexCount = (OfInt) LAYOUT.select(PATH$indexCount);
    public static final OfInt LAYOUT$indexType = (OfInt) LAYOUT.select(PATH$indexType);
    public static final AddressLayout LAYOUT$transformData = (AddressLayout) LAYOUT.select(PATH$transformData);
    public static final OfLong LAYOUT$transformOffset = (OfLong) LAYOUT.select(PATH$transformOffset);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$vertexData = LAYOUT$vertexData.byteSize();
    public static final long SIZE$vertexOffset = LAYOUT$vertexOffset.byteSize();
    public static final long SIZE$vertexCount = LAYOUT$vertexCount.byteSize();
    public static final long SIZE$vertexStride = LAYOUT$vertexStride.byteSize();
    public static final long SIZE$vertexFormat = LAYOUT$vertexFormat.byteSize();
    public static final long SIZE$indexData = LAYOUT$indexData.byteSize();
    public static final long SIZE$indexOffset = LAYOUT$indexOffset.byteSize();
    public static final long SIZE$indexCount = LAYOUT$indexCount.byteSize();
    public static final long SIZE$indexType = LAYOUT$indexType.byteSize();
    public static final long SIZE$transformData = LAYOUT$transformData.byteSize();
    public static final long SIZE$transformOffset = LAYOUT$transformOffset.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$vertexData = LAYOUT.byteOffset(PATH$vertexData);
    public static final long OFFSET$vertexOffset = LAYOUT.byteOffset(PATH$vertexOffset);
    public static final long OFFSET$vertexCount = LAYOUT.byteOffset(PATH$vertexCount);
    public static final long OFFSET$vertexStride = LAYOUT.byteOffset(PATH$vertexStride);
    public static final long OFFSET$vertexFormat = LAYOUT.byteOffset(PATH$vertexFormat);
    public static final long OFFSET$indexData = LAYOUT.byteOffset(PATH$indexData);
    public static final long OFFSET$indexOffset = LAYOUT.byteOffset(PATH$indexOffset);
    public static final long OFFSET$indexCount = LAYOUT.byteOffset(PATH$indexCount);
    public static final long OFFSET$indexType = LAYOUT.byteOffset(PATH$indexType);
    public static final long OFFSET$transformData = LAYOUT.byteOffset(PATH$transformData);
    public static final long OFFSET$transformOffset = LAYOUT.byteOffset(PATH$transformOffset);
}
