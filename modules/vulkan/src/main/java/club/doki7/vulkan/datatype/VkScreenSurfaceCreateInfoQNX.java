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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkScreenSurfaceCreateInfoQNX.html"><code>VkScreenSurfaceCreateInfoQNX</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkScreenSurfaceCreateInfoQNX {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkScreenSurfaceCreateFlagsQNX flags; // optional // @link substring="VkScreenSurfaceCreateFlagsQNX" target="VkScreenSurfaceCreateFlagsQNX" @link substring="flags" target="#flags"
///     _screen_context* context; // @link substring="context" target="#context"
///     _screen_window* window; // @link substring="window" target="#window"
/// } VkScreenSurfaceCreateInfoQNX;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_SCREEN_SURFACE_CREATE_INFO_QNX`
///
/// The {@code allocate} ({@link VkScreenSurfaceCreateInfoQNX#allocate(Arena)}, {@link VkScreenSurfaceCreateInfoQNX#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkScreenSurfaceCreateInfoQNX#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkScreenSurfaceCreateInfoQNX.html"><code>VkScreenSurfaceCreateInfoQNX</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkScreenSurfaceCreateInfoQNX(@NotNull MemorySegment segment) implements IVkScreenSurfaceCreateInfoQNX {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkScreenSurfaceCreateInfoQNX.html"><code>VkScreenSurfaceCreateInfoQNX</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkScreenSurfaceCreateInfoQNX}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkScreenSurfaceCreateInfoQNX to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkScreenSurfaceCreateInfoQNX.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkScreenSurfaceCreateInfoQNX, Iterable<VkScreenSurfaceCreateInfoQNX> {
        public long size() {
            return segment.byteSize() / VkScreenSurfaceCreateInfoQNX.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkScreenSurfaceCreateInfoQNX at(long index) {
            return new VkScreenSurfaceCreateInfoQNX(segment.asSlice(index * VkScreenSurfaceCreateInfoQNX.BYTES, VkScreenSurfaceCreateInfoQNX.BYTES));
        }

        public VkScreenSurfaceCreateInfoQNX.Ptr at(long index, @NotNull Consumer<@NotNull VkScreenSurfaceCreateInfoQNX> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkScreenSurfaceCreateInfoQNX value) {
            MemorySegment s = segment.asSlice(index * VkScreenSurfaceCreateInfoQNX.BYTES, VkScreenSurfaceCreateInfoQNX.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkScreenSurfaceCreateInfoQNX.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkScreenSurfaceCreateInfoQNX.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkScreenSurfaceCreateInfoQNX.BYTES,
                (end - start) * VkScreenSurfaceCreateInfoQNX.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkScreenSurfaceCreateInfoQNX.BYTES));
        }

        public VkScreenSurfaceCreateInfoQNX[] toArray() {
            VkScreenSurfaceCreateInfoQNX[] ret = new VkScreenSurfaceCreateInfoQNX[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkScreenSurfaceCreateInfoQNX> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkScreenSurfaceCreateInfoQNX> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkScreenSurfaceCreateInfoQNX.BYTES;
            }

            @Override
            public VkScreenSurfaceCreateInfoQNX next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkScreenSurfaceCreateInfoQNX ret = new VkScreenSurfaceCreateInfoQNX(segment.asSlice(0, VkScreenSurfaceCreateInfoQNX.BYTES));
                segment = segment.asSlice(VkScreenSurfaceCreateInfoQNX.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkScreenSurfaceCreateInfoQNX allocate(Arena arena) {
        VkScreenSurfaceCreateInfoQNX ret = new VkScreenSurfaceCreateInfoQNX(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.SCREEN_SURFACE_CREATE_INFO_QNX);
        return ret;
    }

    public static VkScreenSurfaceCreateInfoQNX.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkScreenSurfaceCreateInfoQNX.Ptr ret = new VkScreenSurfaceCreateInfoQNX.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.SCREEN_SURFACE_CREATE_INFO_QNX);
        }
        return ret;
    }

    public static VkScreenSurfaceCreateInfoQNX clone(Arena arena, VkScreenSurfaceCreateInfoQNX src) {
        VkScreenSurfaceCreateInfoQNX ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.SCREEN_SURFACE_CREATE_INFO_QNX);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkScreenSurfaceCreateInfoQNX sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkScreenSurfaceCreateInfoQNX pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkScreenSurfaceCreateInfoQNX pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkScreenSurfaceCreateFlagsQNX.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkScreenSurfaceCreateInfoQNX flags(@Bitmask(VkScreenSurfaceCreateFlagsQNX.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    /// Note: the returned {@link PointerPtr} does not have correct {@link PointerPtr#size} property. It's up
    /// to user to track the size of the buffer, and use {@link PointerPtr#reinterpret} to set the size before
    /// actually reading from or writing to the buffer.
    public @Nullable PointerPtr context() {
        MemorySegment s = contextRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new PointerPtr(s);
    }

    public VkScreenSurfaceCreateInfoQNX context(@Nullable PointerPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        contextRaw(s);
        return this;
    }

    public @Pointer(comment="_screen_context*") @NotNull MemorySegment contextRaw() {
        return segment.get(LAYOUT$context, OFFSET$context);
    }

    public void contextRaw(@Pointer(comment="_screen_context*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$context, OFFSET$context, value);
    }

    /// Note: the returned {@link PointerPtr} does not have correct {@link PointerPtr#size} property. It's up
    /// to user to track the size of the buffer, and use {@link PointerPtr#reinterpret} to set the size before
    /// actually reading from or writing to the buffer.
    public @Nullable PointerPtr window() {
        MemorySegment s = windowRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new PointerPtr(s);
    }

    public VkScreenSurfaceCreateInfoQNX window(@Nullable PointerPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        windowRaw(s);
        return this;
    }

    public @Pointer(comment="_screen_window*") @NotNull MemorySegment windowRaw() {
        return segment.get(LAYOUT$window, OFFSET$window);
    }

    public void windowRaw(@Pointer(comment="_screen_window*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$window, OFFSET$window, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS).withName("context"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS).withName("window")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$context = PathElement.groupElement("context");
    public static final PathElement PATH$window = PathElement.groupElement("window");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final AddressLayout LAYOUT$context = (AddressLayout) LAYOUT.select(PATH$context);
    public static final AddressLayout LAYOUT$window = (AddressLayout) LAYOUT.select(PATH$window);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$context = LAYOUT$context.byteSize();
    public static final long SIZE$window = LAYOUT$window.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$context = LAYOUT.byteOffset(PATH$context);
    public static final long OFFSET$window = LAYOUT.byteOffset(PATH$window);
}
