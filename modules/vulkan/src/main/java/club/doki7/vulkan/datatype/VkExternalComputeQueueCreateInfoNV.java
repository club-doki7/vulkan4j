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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkExternalComputeQueueCreateInfoNV.html"><code>VkExternalComputeQueueCreateInfoNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkExternalComputeQueueCreateInfoNV {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkQueue preferredQueue; // @link substring="VkQueue" target="VkQueue" @link substring="preferredQueue" target="#preferredQueue"
/// } VkExternalComputeQueueCreateInfoNV;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_EXTERNAL_COMPUTE_QUEUE_CREATE_INFO_NV`
///
/// The {@code allocate} ({@link VkExternalComputeQueueCreateInfoNV#allocate(Arena)}, {@link VkExternalComputeQueueCreateInfoNV#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkExternalComputeQueueCreateInfoNV#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkExternalComputeQueueCreateInfoNV.html"><code>VkExternalComputeQueueCreateInfoNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkExternalComputeQueueCreateInfoNV(@NotNull MemorySegment segment) implements IVkExternalComputeQueueCreateInfoNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkExternalComputeQueueCreateInfoNV.html"><code>VkExternalComputeQueueCreateInfoNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkExternalComputeQueueCreateInfoNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkExternalComputeQueueCreateInfoNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkExternalComputeQueueCreateInfoNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkExternalComputeQueueCreateInfoNV, Iterable<VkExternalComputeQueueCreateInfoNV> {
        public long size() {
            return segment.byteSize() / VkExternalComputeQueueCreateInfoNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkExternalComputeQueueCreateInfoNV at(long index) {
            return new VkExternalComputeQueueCreateInfoNV(segment.asSlice(index * VkExternalComputeQueueCreateInfoNV.BYTES, VkExternalComputeQueueCreateInfoNV.BYTES));
        }

        public VkExternalComputeQueueCreateInfoNV.Ptr at(long index, @NotNull Consumer<@NotNull VkExternalComputeQueueCreateInfoNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkExternalComputeQueueCreateInfoNV value) {
            MemorySegment s = segment.asSlice(index * VkExternalComputeQueueCreateInfoNV.BYTES, VkExternalComputeQueueCreateInfoNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkExternalComputeQueueCreateInfoNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkExternalComputeQueueCreateInfoNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkExternalComputeQueueCreateInfoNV.BYTES,
                (end - start) * VkExternalComputeQueueCreateInfoNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkExternalComputeQueueCreateInfoNV.BYTES));
        }

        public VkExternalComputeQueueCreateInfoNV[] toArray() {
            VkExternalComputeQueueCreateInfoNV[] ret = new VkExternalComputeQueueCreateInfoNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkExternalComputeQueueCreateInfoNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkExternalComputeQueueCreateInfoNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkExternalComputeQueueCreateInfoNV.BYTES;
            }

            @Override
            public VkExternalComputeQueueCreateInfoNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkExternalComputeQueueCreateInfoNV ret = new VkExternalComputeQueueCreateInfoNV(segment.asSlice(0, VkExternalComputeQueueCreateInfoNV.BYTES));
                segment = segment.asSlice(VkExternalComputeQueueCreateInfoNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkExternalComputeQueueCreateInfoNV allocate(Arena arena) {
        VkExternalComputeQueueCreateInfoNV ret = new VkExternalComputeQueueCreateInfoNV(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.EXTERNAL_COMPUTE_QUEUE_CREATE_INFO_NV);
        return ret;
    }

    public static VkExternalComputeQueueCreateInfoNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkExternalComputeQueueCreateInfoNV.Ptr ret = new VkExternalComputeQueueCreateInfoNV.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.EXTERNAL_COMPUTE_QUEUE_CREATE_INFO_NV);
        }
        return ret;
    }

    public static VkExternalComputeQueueCreateInfoNV clone(Arena arena, VkExternalComputeQueueCreateInfoNV src) {
        VkExternalComputeQueueCreateInfoNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.EXTERNAL_COMPUTE_QUEUE_CREATE_INFO_NV);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkExternalComputeQueueCreateInfoNV sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkExternalComputeQueueCreateInfoNV pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkExternalComputeQueueCreateInfoNV pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Nullable VkQueue preferredQueue() {
        MemorySegment s = segment.asSlice(OFFSET$preferredQueue, SIZE$preferredQueue);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkQueue(s);
    }

    public VkExternalComputeQueueCreateInfoNV preferredQueue(@Nullable VkQueue value) {
        segment.set(LAYOUT$preferredQueue, OFFSET$preferredQueue, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withName("preferredQueue")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$preferredQueue = PathElement.groupElement("preferredQueue");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$preferredQueue = (AddressLayout) LAYOUT.select(PATH$preferredQueue);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$preferredQueue = LAYOUT$preferredQueue.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$preferredQueue = LAYOUT.byteOffset(PATH$preferredQueue);
}
