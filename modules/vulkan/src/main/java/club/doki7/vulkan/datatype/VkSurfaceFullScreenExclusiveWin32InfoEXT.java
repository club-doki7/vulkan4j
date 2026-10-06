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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSurfaceFullScreenExclusiveWin32InfoEXT.html"><code>VkSurfaceFullScreenExclusiveWin32InfoEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkSurfaceFullScreenExclusiveWin32InfoEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     HMONITOR hmonitor; // @link substring="hmonitor" target="#hmonitor"
/// } VkSurfaceFullScreenExclusiveWin32InfoEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_SURFACE_FULL_SCREEN_EXCLUSIVE_WIN32_INFO_EXT`
///
/// The {@code allocate} ({@link VkSurfaceFullScreenExclusiveWin32InfoEXT#allocate(Arena)}, {@link VkSurfaceFullScreenExclusiveWin32InfoEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkSurfaceFullScreenExclusiveWin32InfoEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSurfaceFullScreenExclusiveWin32InfoEXT.html"><code>VkSurfaceFullScreenExclusiveWin32InfoEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkSurfaceFullScreenExclusiveWin32InfoEXT(@NotNull MemorySegment segment) implements IVkSurfaceFullScreenExclusiveWin32InfoEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSurfaceFullScreenExclusiveWin32InfoEXT.html"><code>VkSurfaceFullScreenExclusiveWin32InfoEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkSurfaceFullScreenExclusiveWin32InfoEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkSurfaceFullScreenExclusiveWin32InfoEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkSurfaceFullScreenExclusiveWin32InfoEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkSurfaceFullScreenExclusiveWin32InfoEXT, Iterable<VkSurfaceFullScreenExclusiveWin32InfoEXT> {
        public long size() {
            return segment.byteSize() / VkSurfaceFullScreenExclusiveWin32InfoEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkSurfaceFullScreenExclusiveWin32InfoEXT at(long index) {
            return new VkSurfaceFullScreenExclusiveWin32InfoEXT(segment.asSlice(index * VkSurfaceFullScreenExclusiveWin32InfoEXT.BYTES, VkSurfaceFullScreenExclusiveWin32InfoEXT.BYTES));
        }

        public VkSurfaceFullScreenExclusiveWin32InfoEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkSurfaceFullScreenExclusiveWin32InfoEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkSurfaceFullScreenExclusiveWin32InfoEXT value) {
            MemorySegment s = segment.asSlice(index * VkSurfaceFullScreenExclusiveWin32InfoEXT.BYTES, VkSurfaceFullScreenExclusiveWin32InfoEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkSurfaceFullScreenExclusiveWin32InfoEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkSurfaceFullScreenExclusiveWin32InfoEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkSurfaceFullScreenExclusiveWin32InfoEXT.BYTES,
                (end - start) * VkSurfaceFullScreenExclusiveWin32InfoEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkSurfaceFullScreenExclusiveWin32InfoEXT.BYTES));
        }

        public VkSurfaceFullScreenExclusiveWin32InfoEXT[] toArray() {
            VkSurfaceFullScreenExclusiveWin32InfoEXT[] ret = new VkSurfaceFullScreenExclusiveWin32InfoEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkSurfaceFullScreenExclusiveWin32InfoEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkSurfaceFullScreenExclusiveWin32InfoEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkSurfaceFullScreenExclusiveWin32InfoEXT.BYTES;
            }

            @Override
            public VkSurfaceFullScreenExclusiveWin32InfoEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkSurfaceFullScreenExclusiveWin32InfoEXT ret = new VkSurfaceFullScreenExclusiveWin32InfoEXT(segment.asSlice(0, VkSurfaceFullScreenExclusiveWin32InfoEXT.BYTES));
                segment = segment.asSlice(VkSurfaceFullScreenExclusiveWin32InfoEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkSurfaceFullScreenExclusiveWin32InfoEXT allocate(Arena arena) {
        VkSurfaceFullScreenExclusiveWin32InfoEXT ret = new VkSurfaceFullScreenExclusiveWin32InfoEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.SURFACE_FULL_SCREEN_EXCLUSIVE_WIN32_INFO_EXT);
        return ret;
    }

    public static VkSurfaceFullScreenExclusiveWin32InfoEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkSurfaceFullScreenExclusiveWin32InfoEXT.Ptr ret = new VkSurfaceFullScreenExclusiveWin32InfoEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.SURFACE_FULL_SCREEN_EXCLUSIVE_WIN32_INFO_EXT);
        }
        return ret;
    }

    public static VkSurfaceFullScreenExclusiveWin32InfoEXT clone(Arena arena, VkSurfaceFullScreenExclusiveWin32InfoEXT src) {
        VkSurfaceFullScreenExclusiveWin32InfoEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.SURFACE_FULL_SCREEN_EXCLUSIVE_WIN32_INFO_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkSurfaceFullScreenExclusiveWin32InfoEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkSurfaceFullScreenExclusiveWin32InfoEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkSurfaceFullScreenExclusiveWin32InfoEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Pointer(comment="HMONITOR") @NotNull MemorySegment hmonitor() {
        return segment.get(LAYOUT$hmonitor, OFFSET$hmonitor);
    }

    public VkSurfaceFullScreenExclusiveWin32InfoEXT hmonitor(@Pointer(comment="HMONITOR") @NotNull MemorySegment value) {
        segment.set(LAYOUT$hmonitor, OFFSET$hmonitor, value);
        return this;
    }

    public VkSurfaceFullScreenExclusiveWin32InfoEXT hmonitor(@Nullable IPointer pointer) {
        hmonitor(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withName("hmonitor")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$hmonitor = PathElement.groupElement("hmonitor");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$hmonitor = (AddressLayout) LAYOUT.select(PATH$hmonitor);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$hmonitor = LAYOUT$hmonitor.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$hmonitor = LAYOUT.byteOffset(PATH$hmonitor);
}
