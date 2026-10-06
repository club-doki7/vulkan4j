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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSurfaceFormat2KHR.html"><code>VkSurfaceFormat2KHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkSurfaceFormat2KHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkSurfaceFormatKHR surfaceFormat; // @link substring="VkSurfaceFormatKHR" target="VkSurfaceFormatKHR" @link substring="surfaceFormat" target="#surfaceFormat"
/// } VkSurfaceFormat2KHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_SURFACE_FORMAT_2_KHR`
///
/// The {@code allocate} ({@link VkSurfaceFormat2KHR#allocate(Arena)}, {@link VkSurfaceFormat2KHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkSurfaceFormat2KHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSurfaceFormat2KHR.html"><code>VkSurfaceFormat2KHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkSurfaceFormat2KHR(@NotNull MemorySegment segment) implements IVkSurfaceFormat2KHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSurfaceFormat2KHR.html"><code>VkSurfaceFormat2KHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkSurfaceFormat2KHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkSurfaceFormat2KHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkSurfaceFormat2KHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkSurfaceFormat2KHR, Iterable<VkSurfaceFormat2KHR> {
        public long size() {
            return segment.byteSize() / VkSurfaceFormat2KHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkSurfaceFormat2KHR at(long index) {
            return new VkSurfaceFormat2KHR(segment.asSlice(index * VkSurfaceFormat2KHR.BYTES, VkSurfaceFormat2KHR.BYTES));
        }

        public VkSurfaceFormat2KHR.Ptr at(long index, @NotNull Consumer<@NotNull VkSurfaceFormat2KHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkSurfaceFormat2KHR value) {
            MemorySegment s = segment.asSlice(index * VkSurfaceFormat2KHR.BYTES, VkSurfaceFormat2KHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkSurfaceFormat2KHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkSurfaceFormat2KHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkSurfaceFormat2KHR.BYTES,
                (end - start) * VkSurfaceFormat2KHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkSurfaceFormat2KHR.BYTES));
        }

        public VkSurfaceFormat2KHR[] toArray() {
            VkSurfaceFormat2KHR[] ret = new VkSurfaceFormat2KHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkSurfaceFormat2KHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkSurfaceFormat2KHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkSurfaceFormat2KHR.BYTES;
            }

            @Override
            public VkSurfaceFormat2KHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkSurfaceFormat2KHR ret = new VkSurfaceFormat2KHR(segment.asSlice(0, VkSurfaceFormat2KHR.BYTES));
                segment = segment.asSlice(VkSurfaceFormat2KHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkSurfaceFormat2KHR allocate(Arena arena) {
        VkSurfaceFormat2KHR ret = new VkSurfaceFormat2KHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.SURFACE_FORMAT_2_KHR);
        return ret;
    }

    public static VkSurfaceFormat2KHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkSurfaceFormat2KHR.Ptr ret = new VkSurfaceFormat2KHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.SURFACE_FORMAT_2_KHR);
        }
        return ret;
    }

    public static VkSurfaceFormat2KHR clone(Arena arena, VkSurfaceFormat2KHR src) {
        VkSurfaceFormat2KHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.SURFACE_FORMAT_2_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkSurfaceFormat2KHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkSurfaceFormat2KHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkSurfaceFormat2KHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NotNull VkSurfaceFormatKHR surfaceFormat() {
        return new VkSurfaceFormatKHR(segment.asSlice(OFFSET$surfaceFormat, LAYOUT$surfaceFormat));
    }

    public VkSurfaceFormat2KHR surfaceFormat(@NotNull VkSurfaceFormatKHR value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$surfaceFormat, SIZE$surfaceFormat);
        return this;
    }

    public VkSurfaceFormat2KHR surfaceFormat(Consumer<@NotNull VkSurfaceFormatKHR> consumer) {
        consumer.accept(surfaceFormat());
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        VkSurfaceFormatKHR.LAYOUT.withName("surfaceFormat")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$surfaceFormat = PathElement.groupElement("surfaceFormat");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final StructLayout LAYOUT$surfaceFormat = (StructLayout) LAYOUT.select(PATH$surfaceFormat);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$surfaceFormat = LAYOUT$surfaceFormat.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$surfaceFormat = LAYOUT.byteOffset(PATH$surfaceFormat);
}
