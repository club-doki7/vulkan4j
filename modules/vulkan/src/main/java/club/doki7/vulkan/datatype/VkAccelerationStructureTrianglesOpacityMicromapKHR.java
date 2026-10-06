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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAccelerationStructureTrianglesOpacityMicromapKHR.html"><code>VkAccelerationStructureTrianglesOpacityMicromapKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkAccelerationStructureTrianglesOpacityMicromapKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkIndexType indexType; // @link substring="VkIndexType" target="VkIndexType" @link substring="indexType" target="#indexType"
///     VkDeviceAddress indexBuffer; // @link substring="indexBuffer" target="#indexBuffer"
///     VkDeviceSize indexStride; // @link substring="indexStride" target="#indexStride"
///     uint32_t baseTriangle; // @link substring="baseTriangle" target="#baseTriangle"
///     VkAccelerationStructureKHR micromap; // optional // @link substring="VkAccelerationStructureKHR" target="VkAccelerationStructureKHR" @link substring="micromap" target="#micromap"
/// } VkAccelerationStructureTrianglesOpacityMicromapKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_ACCELERATION_STRUCTURE_TRIANGLES_OPACITY_MICROMAP_KHR`
///
/// The {@code allocate} ({@link VkAccelerationStructureTrianglesOpacityMicromapKHR#allocate(Arena)}, {@link VkAccelerationStructureTrianglesOpacityMicromapKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkAccelerationStructureTrianglesOpacityMicromapKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAccelerationStructureTrianglesOpacityMicromapKHR.html"><code>VkAccelerationStructureTrianglesOpacityMicromapKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkAccelerationStructureTrianglesOpacityMicromapKHR(@NotNull MemorySegment segment) implements IVkAccelerationStructureTrianglesOpacityMicromapKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAccelerationStructureTrianglesOpacityMicromapKHR.html"><code>VkAccelerationStructureTrianglesOpacityMicromapKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkAccelerationStructureTrianglesOpacityMicromapKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkAccelerationStructureTrianglesOpacityMicromapKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkAccelerationStructureTrianglesOpacityMicromapKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkAccelerationStructureTrianglesOpacityMicromapKHR, Iterable<VkAccelerationStructureTrianglesOpacityMicromapKHR> {
        public long size() {
            return segment.byteSize() / VkAccelerationStructureTrianglesOpacityMicromapKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkAccelerationStructureTrianglesOpacityMicromapKHR at(long index) {
            return new VkAccelerationStructureTrianglesOpacityMicromapKHR(segment.asSlice(index * VkAccelerationStructureTrianglesOpacityMicromapKHR.BYTES, VkAccelerationStructureTrianglesOpacityMicromapKHR.BYTES));
        }

        public VkAccelerationStructureTrianglesOpacityMicromapKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkAccelerationStructureTrianglesOpacityMicromapKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkAccelerationStructureTrianglesOpacityMicromapKHR value) {
            MemorySegment s = segment.asSlice(index * VkAccelerationStructureTrianglesOpacityMicromapKHR.BYTES, VkAccelerationStructureTrianglesOpacityMicromapKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkAccelerationStructureTrianglesOpacityMicromapKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkAccelerationStructureTrianglesOpacityMicromapKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkAccelerationStructureTrianglesOpacityMicromapKHR.BYTES,
                (end - start) * VkAccelerationStructureTrianglesOpacityMicromapKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkAccelerationStructureTrianglesOpacityMicromapKHR.BYTES));
        }

        public VkAccelerationStructureTrianglesOpacityMicromapKHR[] toArray() {
            VkAccelerationStructureTrianglesOpacityMicromapKHR[] ret = new VkAccelerationStructureTrianglesOpacityMicromapKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkAccelerationStructureTrianglesOpacityMicromapKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkAccelerationStructureTrianglesOpacityMicromapKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkAccelerationStructureTrianglesOpacityMicromapKHR.BYTES;
            }

            @Override
            public VkAccelerationStructureTrianglesOpacityMicromapKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkAccelerationStructureTrianglesOpacityMicromapKHR ret = new VkAccelerationStructureTrianglesOpacityMicromapKHR(segment.asSlice(0, VkAccelerationStructureTrianglesOpacityMicromapKHR.BYTES));
                segment = segment.asSlice(VkAccelerationStructureTrianglesOpacityMicromapKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkAccelerationStructureTrianglesOpacityMicromapKHR allocate(Arena arena) {
        VkAccelerationStructureTrianglesOpacityMicromapKHR ret = new VkAccelerationStructureTrianglesOpacityMicromapKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.ACCELERATION_STRUCTURE_TRIANGLES_OPACITY_MICROMAP_KHR);
        return ret;
    }

    public static VkAccelerationStructureTrianglesOpacityMicromapKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkAccelerationStructureTrianglesOpacityMicromapKHR.Ptr ret = new VkAccelerationStructureTrianglesOpacityMicromapKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.ACCELERATION_STRUCTURE_TRIANGLES_OPACITY_MICROMAP_KHR);
        }
        return ret;
    }

    public static VkAccelerationStructureTrianglesOpacityMicromapKHR clone(Arena arena, VkAccelerationStructureTrianglesOpacityMicromapKHR src) {
        VkAccelerationStructureTrianglesOpacityMicromapKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.ACCELERATION_STRUCTURE_TRIANGLES_OPACITY_MICROMAP_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkAccelerationStructureTrianglesOpacityMicromapKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkAccelerationStructureTrianglesOpacityMicromapKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkAccelerationStructureTrianglesOpacityMicromapKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @EnumType(VkIndexType.class) int indexType() {
        return segment.get(LAYOUT$indexType, OFFSET$indexType);
    }

    public VkAccelerationStructureTrianglesOpacityMicromapKHR indexType(@EnumType(VkIndexType.class) int value) {
        segment.set(LAYOUT$indexType, OFFSET$indexType, value);
        return this;
    }

    public @NativeType("VkDeviceAddress") @Unsigned long indexBuffer() {
        return segment.get(LAYOUT$indexBuffer, OFFSET$indexBuffer);
    }

    public VkAccelerationStructureTrianglesOpacityMicromapKHR indexBuffer(@NativeType("VkDeviceAddress") @Unsigned long value) {
        segment.set(LAYOUT$indexBuffer, OFFSET$indexBuffer, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long indexStride() {
        return segment.get(LAYOUT$indexStride, OFFSET$indexStride);
    }

    public VkAccelerationStructureTrianglesOpacityMicromapKHR indexStride(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$indexStride, OFFSET$indexStride, value);
        return this;
    }

    public @Unsigned int baseTriangle() {
        return segment.get(LAYOUT$baseTriangle, OFFSET$baseTriangle);
    }

    public VkAccelerationStructureTrianglesOpacityMicromapKHR baseTriangle(@Unsigned int value) {
        segment.set(LAYOUT$baseTriangle, OFFSET$baseTriangle, value);
        return this;
    }

    public @Nullable VkAccelerationStructureKHR micromap() {
        MemorySegment s = segment.asSlice(OFFSET$micromap, SIZE$micromap);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkAccelerationStructureKHR(s);
    }

    public VkAccelerationStructureTrianglesOpacityMicromapKHR micromap(@Nullable VkAccelerationStructureKHR value) {
        segment.set(LAYOUT$micromap, OFFSET$micromap, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("indexType"),
        ValueLayout.JAVA_LONG.withName("indexBuffer"),
        ValueLayout.JAVA_LONG.withName("indexStride"),
        ValueLayout.JAVA_INT.withName("baseTriangle"),
        ValueLayout.ADDRESS.withName("micromap")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$indexType = PathElement.groupElement("indexType");
    public static final PathElement PATH$indexBuffer = PathElement.groupElement("indexBuffer");
    public static final PathElement PATH$indexStride = PathElement.groupElement("indexStride");
    public static final PathElement PATH$baseTriangle = PathElement.groupElement("baseTriangle");
    public static final PathElement PATH$micromap = PathElement.groupElement("micromap");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$indexType = (OfInt) LAYOUT.select(PATH$indexType);
    public static final OfLong LAYOUT$indexBuffer = (OfLong) LAYOUT.select(PATH$indexBuffer);
    public static final OfLong LAYOUT$indexStride = (OfLong) LAYOUT.select(PATH$indexStride);
    public static final OfInt LAYOUT$baseTriangle = (OfInt) LAYOUT.select(PATH$baseTriangle);
    public static final AddressLayout LAYOUT$micromap = (AddressLayout) LAYOUT.select(PATH$micromap);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$indexType = LAYOUT$indexType.byteSize();
    public static final long SIZE$indexBuffer = LAYOUT$indexBuffer.byteSize();
    public static final long SIZE$indexStride = LAYOUT$indexStride.byteSize();
    public static final long SIZE$baseTriangle = LAYOUT$baseTriangle.byteSize();
    public static final long SIZE$micromap = LAYOUT$micromap.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$indexType = LAYOUT.byteOffset(PATH$indexType);
    public static final long OFFSET$indexBuffer = LAYOUT.byteOffset(PATH$indexBuffer);
    public static final long OFFSET$indexStride = LAYOUT.byteOffset(PATH$indexStride);
    public static final long OFFSET$baseTriangle = LAYOUT.byteOffset(PATH$baseTriangle);
    public static final long OFFSET$micromap = LAYOUT.byteOffset(PATH$micromap);
}
