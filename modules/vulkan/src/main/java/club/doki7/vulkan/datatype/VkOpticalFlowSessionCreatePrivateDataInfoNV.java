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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkOpticalFlowSessionCreatePrivateDataInfoNV.html"><code>VkOpticalFlowSessionCreatePrivateDataInfoNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkOpticalFlowSessionCreatePrivateDataInfoNV {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t id; // @link substring="id" target="#id"
///     uint32_t size; // @link substring="size" target="#size"
///     void const* pPrivateData; // @link substring="pPrivateData" target="#pPrivateData"
/// } VkOpticalFlowSessionCreatePrivateDataInfoNV;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_OPTICAL_FLOW_SESSION_CREATE_PRIVATE_DATA_INFO_NV`
///
/// The {@code allocate} ({@link VkOpticalFlowSessionCreatePrivateDataInfoNV#allocate(Arena)}, {@link VkOpticalFlowSessionCreatePrivateDataInfoNV#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkOpticalFlowSessionCreatePrivateDataInfoNV#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkOpticalFlowSessionCreatePrivateDataInfoNV.html"><code>VkOpticalFlowSessionCreatePrivateDataInfoNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkOpticalFlowSessionCreatePrivateDataInfoNV(@NotNull MemorySegment segment) implements IVkOpticalFlowSessionCreatePrivateDataInfoNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkOpticalFlowSessionCreatePrivateDataInfoNV.html"><code>VkOpticalFlowSessionCreatePrivateDataInfoNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkOpticalFlowSessionCreatePrivateDataInfoNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkOpticalFlowSessionCreatePrivateDataInfoNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkOpticalFlowSessionCreatePrivateDataInfoNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkOpticalFlowSessionCreatePrivateDataInfoNV, Iterable<VkOpticalFlowSessionCreatePrivateDataInfoNV> {
        public long size() {
            return segment.byteSize() / VkOpticalFlowSessionCreatePrivateDataInfoNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkOpticalFlowSessionCreatePrivateDataInfoNV at(long index) {
            return new VkOpticalFlowSessionCreatePrivateDataInfoNV(segment.asSlice(index * VkOpticalFlowSessionCreatePrivateDataInfoNV.BYTES, VkOpticalFlowSessionCreatePrivateDataInfoNV.BYTES));
        }

        public VkOpticalFlowSessionCreatePrivateDataInfoNV.Ptr at(long index, @NotNull Consumer<@NotNull VkOpticalFlowSessionCreatePrivateDataInfoNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkOpticalFlowSessionCreatePrivateDataInfoNV value) {
            MemorySegment s = segment.asSlice(index * VkOpticalFlowSessionCreatePrivateDataInfoNV.BYTES, VkOpticalFlowSessionCreatePrivateDataInfoNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkOpticalFlowSessionCreatePrivateDataInfoNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkOpticalFlowSessionCreatePrivateDataInfoNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkOpticalFlowSessionCreatePrivateDataInfoNV.BYTES,
                (end - start) * VkOpticalFlowSessionCreatePrivateDataInfoNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkOpticalFlowSessionCreatePrivateDataInfoNV.BYTES));
        }

        public VkOpticalFlowSessionCreatePrivateDataInfoNV[] toArray() {
            VkOpticalFlowSessionCreatePrivateDataInfoNV[] ret = new VkOpticalFlowSessionCreatePrivateDataInfoNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkOpticalFlowSessionCreatePrivateDataInfoNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkOpticalFlowSessionCreatePrivateDataInfoNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkOpticalFlowSessionCreatePrivateDataInfoNV.BYTES;
            }

            @Override
            public VkOpticalFlowSessionCreatePrivateDataInfoNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkOpticalFlowSessionCreatePrivateDataInfoNV ret = new VkOpticalFlowSessionCreatePrivateDataInfoNV(segment.asSlice(0, VkOpticalFlowSessionCreatePrivateDataInfoNV.BYTES));
                segment = segment.asSlice(VkOpticalFlowSessionCreatePrivateDataInfoNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkOpticalFlowSessionCreatePrivateDataInfoNV allocate(Arena arena) {
        VkOpticalFlowSessionCreatePrivateDataInfoNV ret = new VkOpticalFlowSessionCreatePrivateDataInfoNV(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.OPTICAL_FLOW_SESSION_CREATE_PRIVATE_DATA_INFO_NV);
        return ret;
    }

    public static VkOpticalFlowSessionCreatePrivateDataInfoNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkOpticalFlowSessionCreatePrivateDataInfoNV.Ptr ret = new VkOpticalFlowSessionCreatePrivateDataInfoNV.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.OPTICAL_FLOW_SESSION_CREATE_PRIVATE_DATA_INFO_NV);
        }
        return ret;
    }

    public static VkOpticalFlowSessionCreatePrivateDataInfoNV clone(Arena arena, VkOpticalFlowSessionCreatePrivateDataInfoNV src) {
        VkOpticalFlowSessionCreatePrivateDataInfoNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.OPTICAL_FLOW_SESSION_CREATE_PRIVATE_DATA_INFO_NV);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkOpticalFlowSessionCreatePrivateDataInfoNV sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkOpticalFlowSessionCreatePrivateDataInfoNV pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkOpticalFlowSessionCreatePrivateDataInfoNV pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int id() {
        return segment.get(LAYOUT$id, OFFSET$id);
    }

    public VkOpticalFlowSessionCreatePrivateDataInfoNV id(@Unsigned int value) {
        segment.set(LAYOUT$id, OFFSET$id, value);
        return this;
    }

    public @Unsigned int size() {
        return segment.get(LAYOUT$size, OFFSET$size);
    }

    public VkOpticalFlowSessionCreatePrivateDataInfoNV size(@Unsigned int value) {
        segment.set(LAYOUT$size, OFFSET$size, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pPrivateData() {
        return segment.get(LAYOUT$pPrivateData, OFFSET$pPrivateData);
    }

    public VkOpticalFlowSessionCreatePrivateDataInfoNV pPrivateData(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pPrivateData, OFFSET$pPrivateData, value);
        return this;
    }

    public VkOpticalFlowSessionCreatePrivateDataInfoNV pPrivateData(@Nullable IPointer pointer) {
        pPrivateData(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("id"),
        ValueLayout.JAVA_INT.withName("size"),
        ValueLayout.ADDRESS.withName("pPrivateData")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$id = PathElement.groupElement("id");
    public static final PathElement PATH$size = PathElement.groupElement("size");
    public static final PathElement PATH$pPrivateData = PathElement.groupElement("pPrivateData");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$id = (OfInt) LAYOUT.select(PATH$id);
    public static final OfInt LAYOUT$size = (OfInt) LAYOUT.select(PATH$size);
    public static final AddressLayout LAYOUT$pPrivateData = (AddressLayout) LAYOUT.select(PATH$pPrivateData);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$id = LAYOUT$id.byteSize();
    public static final long SIZE$size = LAYOUT$size.byteSize();
    public static final long SIZE$pPrivateData = LAYOUT$pPrivateData.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$id = LAYOUT.byteOffset(PATH$id);
    public static final long OFFSET$size = LAYOUT.byteOffset(PATH$size);
    public static final long OFFSET$pPrivateData = LAYOUT.byteOffset(PATH$pPrivateData);
}
