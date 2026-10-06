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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkWaylandSurfaceCreateInfoKHR.html"><code>VkWaylandSurfaceCreateInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkWaylandSurfaceCreateInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkWaylandSurfaceCreateFlagsKHR flags; // optional // @link substring="VkWaylandSurfaceCreateFlagsKHR" target="VkWaylandSurfaceCreateFlagsKHR" @link substring="flags" target="#flags"
///     wl_display* display; // @link substring="display" target="#display"
///     wl_surface* surface; // @link substring="surface" target="#surface"
/// } VkWaylandSurfaceCreateInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_WAYLAND_SURFACE_CREATE_INFO_KHR`
///
/// The {@code allocate} ({@link VkWaylandSurfaceCreateInfoKHR#allocate(Arena)}, {@link VkWaylandSurfaceCreateInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkWaylandSurfaceCreateInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkWaylandSurfaceCreateInfoKHR.html"><code>VkWaylandSurfaceCreateInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkWaylandSurfaceCreateInfoKHR(@NotNull MemorySegment segment) implements IVkWaylandSurfaceCreateInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkWaylandSurfaceCreateInfoKHR.html"><code>VkWaylandSurfaceCreateInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkWaylandSurfaceCreateInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkWaylandSurfaceCreateInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkWaylandSurfaceCreateInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkWaylandSurfaceCreateInfoKHR, Iterable<VkWaylandSurfaceCreateInfoKHR> {
        public long size() {
            return segment.byteSize() / VkWaylandSurfaceCreateInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkWaylandSurfaceCreateInfoKHR at(long index) {
            return new VkWaylandSurfaceCreateInfoKHR(segment.asSlice(index * VkWaylandSurfaceCreateInfoKHR.BYTES, VkWaylandSurfaceCreateInfoKHR.BYTES));
        }

        public VkWaylandSurfaceCreateInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkWaylandSurfaceCreateInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkWaylandSurfaceCreateInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkWaylandSurfaceCreateInfoKHR.BYTES, VkWaylandSurfaceCreateInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkWaylandSurfaceCreateInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkWaylandSurfaceCreateInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkWaylandSurfaceCreateInfoKHR.BYTES,
                (end - start) * VkWaylandSurfaceCreateInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkWaylandSurfaceCreateInfoKHR.BYTES));
        }

        public VkWaylandSurfaceCreateInfoKHR[] toArray() {
            VkWaylandSurfaceCreateInfoKHR[] ret = new VkWaylandSurfaceCreateInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkWaylandSurfaceCreateInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkWaylandSurfaceCreateInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkWaylandSurfaceCreateInfoKHR.BYTES;
            }

            @Override
            public VkWaylandSurfaceCreateInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkWaylandSurfaceCreateInfoKHR ret = new VkWaylandSurfaceCreateInfoKHR(segment.asSlice(0, VkWaylandSurfaceCreateInfoKHR.BYTES));
                segment = segment.asSlice(VkWaylandSurfaceCreateInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkWaylandSurfaceCreateInfoKHR allocate(Arena arena) {
        VkWaylandSurfaceCreateInfoKHR ret = new VkWaylandSurfaceCreateInfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.WAYLAND_SURFACE_CREATE_INFO_KHR);
        return ret;
    }

    public static VkWaylandSurfaceCreateInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkWaylandSurfaceCreateInfoKHR.Ptr ret = new VkWaylandSurfaceCreateInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.WAYLAND_SURFACE_CREATE_INFO_KHR);
        }
        return ret;
    }

    public static VkWaylandSurfaceCreateInfoKHR clone(Arena arena, VkWaylandSurfaceCreateInfoKHR src) {
        VkWaylandSurfaceCreateInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.WAYLAND_SURFACE_CREATE_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkWaylandSurfaceCreateInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkWaylandSurfaceCreateInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkWaylandSurfaceCreateInfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkWaylandSurfaceCreateFlagsKHR.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkWaylandSurfaceCreateInfoKHR flags(@Bitmask(VkWaylandSurfaceCreateFlagsKHR.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    /// Note: the returned {@link PointerPtr} does not have correct {@link PointerPtr#size} property. It's up
    /// to user to track the size of the buffer, and use {@link PointerPtr#reinterpret} to set the size before
    /// actually reading from or writing to the buffer.
    public @Nullable PointerPtr display() {
        MemorySegment s = displayRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new PointerPtr(s);
    }

    public VkWaylandSurfaceCreateInfoKHR display(@Nullable PointerPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        displayRaw(s);
        return this;
    }

    public @Pointer(comment="wl_display*") @NotNull MemorySegment displayRaw() {
        return segment.get(LAYOUT$display, OFFSET$display);
    }

    public void displayRaw(@Pointer(comment="wl_display*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$display, OFFSET$display, value);
    }

    /// Note: the returned {@link PointerPtr} does not have correct {@link PointerPtr#size} property. It's up
    /// to user to track the size of the buffer, and use {@link PointerPtr#reinterpret} to set the size before
    /// actually reading from or writing to the buffer.
    public @Nullable PointerPtr surface() {
        MemorySegment s = surfaceRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new PointerPtr(s);
    }

    public VkWaylandSurfaceCreateInfoKHR surface(@Nullable PointerPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        surfaceRaw(s);
        return this;
    }

    public @Pointer(comment="wl_surface*") @NotNull MemorySegment surfaceRaw() {
        return segment.get(LAYOUT$surface, OFFSET$surface);
    }

    public void surfaceRaw(@Pointer(comment="wl_surface*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$surface, OFFSET$surface, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS).withName("display"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS).withName("surface")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$display = PathElement.groupElement("display");
    public static final PathElement PATH$surface = PathElement.groupElement("surface");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final AddressLayout LAYOUT$display = (AddressLayout) LAYOUT.select(PATH$display);
    public static final AddressLayout LAYOUT$surface = (AddressLayout) LAYOUT.select(PATH$surface);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$display = LAYOUT$display.byteSize();
    public static final long SIZE$surface = LAYOUT$surface.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$display = LAYOUT.byteOffset(PATH$display);
    public static final long OFFSET$surface = LAYOUT.byteOffset(PATH$surface);
}
