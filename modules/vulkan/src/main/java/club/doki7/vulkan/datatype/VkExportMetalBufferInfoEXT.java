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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkExportMetalBufferInfoEXT.html"><code>VkExportMetalBufferInfoEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkExportMetalBufferInfoEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkDeviceMemory memory; // @link substring="VkDeviceMemory" target="VkDeviceMemory" @link substring="memory" target="#memory"
///     MTLBuffer_id mtlBuffer; // @link substring="mtlBuffer" target="#mtlBuffer"
/// } VkExportMetalBufferInfoEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_EXPORT_METAL_BUFFER_INFO_EXT`
///
/// The {@code allocate} ({@link VkExportMetalBufferInfoEXT#allocate(Arena)}, {@link VkExportMetalBufferInfoEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkExportMetalBufferInfoEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkExportMetalBufferInfoEXT.html"><code>VkExportMetalBufferInfoEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkExportMetalBufferInfoEXT(@NotNull MemorySegment segment) implements IVkExportMetalBufferInfoEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkExportMetalBufferInfoEXT.html"><code>VkExportMetalBufferInfoEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkExportMetalBufferInfoEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkExportMetalBufferInfoEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkExportMetalBufferInfoEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkExportMetalBufferInfoEXT, Iterable<VkExportMetalBufferInfoEXT> {
        public long size() {
            return segment.byteSize() / VkExportMetalBufferInfoEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkExportMetalBufferInfoEXT at(long index) {
            return new VkExportMetalBufferInfoEXT(segment.asSlice(index * VkExportMetalBufferInfoEXT.BYTES, VkExportMetalBufferInfoEXT.BYTES));
        }

        public VkExportMetalBufferInfoEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkExportMetalBufferInfoEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkExportMetalBufferInfoEXT value) {
            MemorySegment s = segment.asSlice(index * VkExportMetalBufferInfoEXT.BYTES, VkExportMetalBufferInfoEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkExportMetalBufferInfoEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkExportMetalBufferInfoEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkExportMetalBufferInfoEXT.BYTES,
                (end - start) * VkExportMetalBufferInfoEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkExportMetalBufferInfoEXT.BYTES));
        }

        public VkExportMetalBufferInfoEXT[] toArray() {
            VkExportMetalBufferInfoEXT[] ret = new VkExportMetalBufferInfoEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkExportMetalBufferInfoEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkExportMetalBufferInfoEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkExportMetalBufferInfoEXT.BYTES;
            }

            @Override
            public VkExportMetalBufferInfoEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkExportMetalBufferInfoEXT ret = new VkExportMetalBufferInfoEXT(segment.asSlice(0, VkExportMetalBufferInfoEXT.BYTES));
                segment = segment.asSlice(VkExportMetalBufferInfoEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkExportMetalBufferInfoEXT allocate(Arena arena) {
        VkExportMetalBufferInfoEXT ret = new VkExportMetalBufferInfoEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.EXPORT_METAL_BUFFER_INFO_EXT);
        return ret;
    }

    public static VkExportMetalBufferInfoEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkExportMetalBufferInfoEXT.Ptr ret = new VkExportMetalBufferInfoEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.EXPORT_METAL_BUFFER_INFO_EXT);
        }
        return ret;
    }

    public static VkExportMetalBufferInfoEXT clone(Arena arena, VkExportMetalBufferInfoEXT src) {
        VkExportMetalBufferInfoEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.EXPORT_METAL_BUFFER_INFO_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkExportMetalBufferInfoEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkExportMetalBufferInfoEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkExportMetalBufferInfoEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Nullable VkDeviceMemory memory() {
        MemorySegment s = segment.asSlice(OFFSET$memory, SIZE$memory);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkDeviceMemory(s);
    }

    public VkExportMetalBufferInfoEXT memory(@Nullable VkDeviceMemory value) {
        segment.set(LAYOUT$memory, OFFSET$memory, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Pointer(comment="MTLBuffer_id") @NotNull MemorySegment mtlBuffer() {
        return segment.get(LAYOUT$mtlBuffer, OFFSET$mtlBuffer);
    }

    public VkExportMetalBufferInfoEXT mtlBuffer(@Pointer(comment="MTLBuffer_id") @NotNull MemorySegment value) {
        segment.set(LAYOUT$mtlBuffer, OFFSET$mtlBuffer, value);
        return this;
    }

    public VkExportMetalBufferInfoEXT mtlBuffer(@Nullable IPointer pointer) {
        mtlBuffer(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withName("memory"),
        ValueLayout.ADDRESS.withName("mtlBuffer")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$memory = PathElement.groupElement("memory");
    public static final PathElement PATH$mtlBuffer = PathElement.groupElement("mtlBuffer");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$memory = (AddressLayout) LAYOUT.select(PATH$memory);
    public static final AddressLayout LAYOUT$mtlBuffer = (AddressLayout) LAYOUT.select(PATH$mtlBuffer);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$memory = LAYOUT$memory.byteSize();
    public static final long SIZE$mtlBuffer = LAYOUT$mtlBuffer.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$memory = LAYOUT.byteOffset(PATH$memory);
    public static final long OFFSET$mtlBuffer = LAYOUT.byteOffset(PATH$mtlBuffer);
}
