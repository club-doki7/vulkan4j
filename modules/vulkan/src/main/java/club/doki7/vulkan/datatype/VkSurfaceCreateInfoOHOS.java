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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSurfaceCreateInfoOHOS.html"><code>VkSurfaceCreateInfoOHOS</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkSurfaceCreateInfoOHOS {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkSurfaceCreateFlagsOHOS flags; // optional // @link substring="VkSurfaceCreateFlagsOHOS" target="VkSurfaceCreateFlagsOHOS" @link substring="flags" target="#flags"
///     OHNativeWindow* window; // @link substring="window" target="#window"
/// } VkSurfaceCreateInfoOHOS;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_SURFACE_CREATE_INFO_OHOS`
///
/// The {@code allocate} ({@link VkSurfaceCreateInfoOHOS#allocate(Arena)}, {@link VkSurfaceCreateInfoOHOS#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkSurfaceCreateInfoOHOS#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSurfaceCreateInfoOHOS.html"><code>VkSurfaceCreateInfoOHOS</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkSurfaceCreateInfoOHOS(@NotNull MemorySegment segment) implements IVkSurfaceCreateInfoOHOS {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSurfaceCreateInfoOHOS.html"><code>VkSurfaceCreateInfoOHOS</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkSurfaceCreateInfoOHOS}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkSurfaceCreateInfoOHOS to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkSurfaceCreateInfoOHOS.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkSurfaceCreateInfoOHOS, Iterable<VkSurfaceCreateInfoOHOS> {
        public long size() {
            return segment.byteSize() / VkSurfaceCreateInfoOHOS.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkSurfaceCreateInfoOHOS at(long index) {
            return new VkSurfaceCreateInfoOHOS(segment.asSlice(index * VkSurfaceCreateInfoOHOS.BYTES, VkSurfaceCreateInfoOHOS.BYTES));
        }

        public VkSurfaceCreateInfoOHOS.Ptr at(long index, @NotNull Consumer<@NotNull VkSurfaceCreateInfoOHOS> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkSurfaceCreateInfoOHOS value) {
            MemorySegment s = segment.asSlice(index * VkSurfaceCreateInfoOHOS.BYTES, VkSurfaceCreateInfoOHOS.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkSurfaceCreateInfoOHOS.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkSurfaceCreateInfoOHOS.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkSurfaceCreateInfoOHOS.BYTES,
                (end - start) * VkSurfaceCreateInfoOHOS.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkSurfaceCreateInfoOHOS.BYTES));
        }

        public VkSurfaceCreateInfoOHOS[] toArray() {
            VkSurfaceCreateInfoOHOS[] ret = new VkSurfaceCreateInfoOHOS[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkSurfaceCreateInfoOHOS> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkSurfaceCreateInfoOHOS> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkSurfaceCreateInfoOHOS.BYTES;
            }

            @Override
            public VkSurfaceCreateInfoOHOS next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkSurfaceCreateInfoOHOS ret = new VkSurfaceCreateInfoOHOS(segment.asSlice(0, VkSurfaceCreateInfoOHOS.BYTES));
                segment = segment.asSlice(VkSurfaceCreateInfoOHOS.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkSurfaceCreateInfoOHOS allocate(Arena arena) {
        VkSurfaceCreateInfoOHOS ret = new VkSurfaceCreateInfoOHOS(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.SURFACE_CREATE_INFO_OHOS);
        return ret;
    }

    public static VkSurfaceCreateInfoOHOS.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkSurfaceCreateInfoOHOS.Ptr ret = new VkSurfaceCreateInfoOHOS.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.SURFACE_CREATE_INFO_OHOS);
        }
        return ret;
    }

    public static VkSurfaceCreateInfoOHOS clone(Arena arena, VkSurfaceCreateInfoOHOS src) {
        VkSurfaceCreateInfoOHOS ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.SURFACE_CREATE_INFO_OHOS);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkSurfaceCreateInfoOHOS sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkSurfaceCreateInfoOHOS pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkSurfaceCreateInfoOHOS pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkSurfaceCreateFlagsOHOS.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkSurfaceCreateInfoOHOS flags(@Bitmask(VkSurfaceCreateFlagsOHOS.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment window() {
        return segment.get(LAYOUT$window, OFFSET$window);
    }

    public VkSurfaceCreateInfoOHOS window(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$window, OFFSET$window, value);
        return this;
    }

    public VkSurfaceCreateInfoOHOS window(@Nullable IPointer pointer) {
        window(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.ADDRESS.withName("window")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$window = PathElement.groupElement("window");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final AddressLayout LAYOUT$window = (AddressLayout) LAYOUT.select(PATH$window);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$window = LAYOUT$window.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$window = LAYOUT.byteOffset(PATH$window);
}
