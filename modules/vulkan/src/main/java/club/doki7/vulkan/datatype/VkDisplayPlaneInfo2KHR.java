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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDisplayPlaneInfo2KHR.html"><code>VkDisplayPlaneInfo2KHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDisplayPlaneInfo2KHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkDisplayModeKHR mode; // @link substring="VkDisplayModeKHR" target="VkDisplayModeKHR" @link substring="mode" target="#mode"
///     uint32_t planeIndex; // @link substring="planeIndex" target="#planeIndex"
/// } VkDisplayPlaneInfo2KHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_DISPLAY_PLANE_INFO_2_KHR`
///
/// The {@code allocate} ({@link VkDisplayPlaneInfo2KHR#allocate(Arena)}, {@link VkDisplayPlaneInfo2KHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkDisplayPlaneInfo2KHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDisplayPlaneInfo2KHR.html"><code>VkDisplayPlaneInfo2KHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDisplayPlaneInfo2KHR(@NotNull MemorySegment segment) implements IVkDisplayPlaneInfo2KHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDisplayPlaneInfo2KHR.html"><code>VkDisplayPlaneInfo2KHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDisplayPlaneInfo2KHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDisplayPlaneInfo2KHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDisplayPlaneInfo2KHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDisplayPlaneInfo2KHR, Iterable<VkDisplayPlaneInfo2KHR> {
        public long size() {
            return segment.byteSize() / VkDisplayPlaneInfo2KHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDisplayPlaneInfo2KHR at(long index) {
            return new VkDisplayPlaneInfo2KHR(segment.asSlice(index * VkDisplayPlaneInfo2KHR.BYTES, VkDisplayPlaneInfo2KHR.BYTES));
        }

        public VkDisplayPlaneInfo2KHR.Ptr at(long index, @NotNull Consumer<@NotNull VkDisplayPlaneInfo2KHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDisplayPlaneInfo2KHR value) {
            MemorySegment s = segment.asSlice(index * VkDisplayPlaneInfo2KHR.BYTES, VkDisplayPlaneInfo2KHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDisplayPlaneInfo2KHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDisplayPlaneInfo2KHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDisplayPlaneInfo2KHR.BYTES,
                (end - start) * VkDisplayPlaneInfo2KHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDisplayPlaneInfo2KHR.BYTES));
        }

        public VkDisplayPlaneInfo2KHR[] toArray() {
            VkDisplayPlaneInfo2KHR[] ret = new VkDisplayPlaneInfo2KHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDisplayPlaneInfo2KHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDisplayPlaneInfo2KHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDisplayPlaneInfo2KHR.BYTES;
            }

            @Override
            public VkDisplayPlaneInfo2KHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDisplayPlaneInfo2KHR ret = new VkDisplayPlaneInfo2KHR(segment.asSlice(0, VkDisplayPlaneInfo2KHR.BYTES));
                segment = segment.asSlice(VkDisplayPlaneInfo2KHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDisplayPlaneInfo2KHR allocate(Arena arena) {
        VkDisplayPlaneInfo2KHR ret = new VkDisplayPlaneInfo2KHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.DISPLAY_PLANE_INFO_2_KHR);
        return ret;
    }

    public static VkDisplayPlaneInfo2KHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkDisplayPlaneInfo2KHR.Ptr ret = new VkDisplayPlaneInfo2KHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.DISPLAY_PLANE_INFO_2_KHR);
        }
        return ret;
    }

    public static VkDisplayPlaneInfo2KHR clone(Arena arena, VkDisplayPlaneInfo2KHR src) {
        VkDisplayPlaneInfo2KHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.DISPLAY_PLANE_INFO_2_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkDisplayPlaneInfo2KHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkDisplayPlaneInfo2KHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkDisplayPlaneInfo2KHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Nullable VkDisplayModeKHR mode() {
        MemorySegment s = segment.asSlice(OFFSET$mode, SIZE$mode);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkDisplayModeKHR(s);
    }

    public VkDisplayPlaneInfo2KHR mode(@Nullable VkDisplayModeKHR value) {
        segment.set(LAYOUT$mode, OFFSET$mode, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int planeIndex() {
        return segment.get(LAYOUT$planeIndex, OFFSET$planeIndex);
    }

    public VkDisplayPlaneInfo2KHR planeIndex(@Unsigned int value) {
        segment.set(LAYOUT$planeIndex, OFFSET$planeIndex, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withName("mode"),
        ValueLayout.JAVA_INT.withName("planeIndex")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$mode = PathElement.groupElement("mode");
    public static final PathElement PATH$planeIndex = PathElement.groupElement("planeIndex");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$mode = (AddressLayout) LAYOUT.select(PATH$mode);
    public static final OfInt LAYOUT$planeIndex = (OfInt) LAYOUT.select(PATH$planeIndex);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$mode = LAYOUT$mode.byteSize();
    public static final long SIZE$planeIndex = LAYOUT$planeIndex.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$mode = LAYOUT.byteOffset(PATH$mode);
    public static final long OFFSET$planeIndex = LAYOUT.byteOffset(PATH$planeIndex);
}
