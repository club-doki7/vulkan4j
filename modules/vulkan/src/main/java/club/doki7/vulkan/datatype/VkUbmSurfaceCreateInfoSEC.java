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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkUbmSurfaceCreateInfoSEC.html"><code>VkUbmSurfaceCreateInfoSEC</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkUbmSurfaceCreateInfoSEC {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkUbmSurfaceCreateFlagsSEC flags; // optional // @link substring="VkUbmSurfaceCreateFlagsSEC" target="VkUbmSurfaceCreateFlagsSEC" @link substring="flags" target="#flags"
///     ubm_device* device; // @link substring="device" target="#device"
///     ubm_surface* surface; // @link substring="surface" target="#surface"
/// } VkUbmSurfaceCreateInfoSEC;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_UBM_SURFACE_CREATE_INFO_SEC`
///
/// The {@code allocate} ({@link VkUbmSurfaceCreateInfoSEC#allocate(Arena)}, {@link VkUbmSurfaceCreateInfoSEC#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkUbmSurfaceCreateInfoSEC#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkUbmSurfaceCreateInfoSEC.html"><code>VkUbmSurfaceCreateInfoSEC</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkUbmSurfaceCreateInfoSEC(@NotNull MemorySegment segment) implements IVkUbmSurfaceCreateInfoSEC {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkUbmSurfaceCreateInfoSEC.html"><code>VkUbmSurfaceCreateInfoSEC</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkUbmSurfaceCreateInfoSEC}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkUbmSurfaceCreateInfoSEC to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkUbmSurfaceCreateInfoSEC.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkUbmSurfaceCreateInfoSEC, Iterable<VkUbmSurfaceCreateInfoSEC> {
        public long size() {
            return segment.byteSize() / VkUbmSurfaceCreateInfoSEC.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkUbmSurfaceCreateInfoSEC at(long index) {
            return new VkUbmSurfaceCreateInfoSEC(segment.asSlice(index * VkUbmSurfaceCreateInfoSEC.BYTES, VkUbmSurfaceCreateInfoSEC.BYTES));
        }

        public VkUbmSurfaceCreateInfoSEC.Ptr at(long index, @NotNull Consumer<@NotNull VkUbmSurfaceCreateInfoSEC> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkUbmSurfaceCreateInfoSEC value) {
            MemorySegment s = segment.asSlice(index * VkUbmSurfaceCreateInfoSEC.BYTES, VkUbmSurfaceCreateInfoSEC.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkUbmSurfaceCreateInfoSEC.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkUbmSurfaceCreateInfoSEC.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkUbmSurfaceCreateInfoSEC.BYTES,
                (end - start) * VkUbmSurfaceCreateInfoSEC.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkUbmSurfaceCreateInfoSEC.BYTES));
        }

        public VkUbmSurfaceCreateInfoSEC[] toArray() {
            VkUbmSurfaceCreateInfoSEC[] ret = new VkUbmSurfaceCreateInfoSEC[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkUbmSurfaceCreateInfoSEC> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkUbmSurfaceCreateInfoSEC> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkUbmSurfaceCreateInfoSEC.BYTES;
            }

            @Override
            public VkUbmSurfaceCreateInfoSEC next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkUbmSurfaceCreateInfoSEC ret = new VkUbmSurfaceCreateInfoSEC(segment.asSlice(0, VkUbmSurfaceCreateInfoSEC.BYTES));
                segment = segment.asSlice(VkUbmSurfaceCreateInfoSEC.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkUbmSurfaceCreateInfoSEC allocate(Arena arena) {
        VkUbmSurfaceCreateInfoSEC ret = new VkUbmSurfaceCreateInfoSEC(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.UBM_SURFACE_CREATE_INFO_SEC);
        return ret;
    }

    public static VkUbmSurfaceCreateInfoSEC.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkUbmSurfaceCreateInfoSEC.Ptr ret = new VkUbmSurfaceCreateInfoSEC.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.UBM_SURFACE_CREATE_INFO_SEC);
        }
        return ret;
    }

    public static VkUbmSurfaceCreateInfoSEC clone(Arena arena, VkUbmSurfaceCreateInfoSEC src) {
        VkUbmSurfaceCreateInfoSEC ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.UBM_SURFACE_CREATE_INFO_SEC);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkUbmSurfaceCreateInfoSEC sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkUbmSurfaceCreateInfoSEC pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkUbmSurfaceCreateInfoSEC pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkUbmSurfaceCreateFlagsSEC.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkUbmSurfaceCreateInfoSEC flags(@Bitmask(VkUbmSurfaceCreateFlagsSEC.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment device() {
        return segment.get(LAYOUT$device, OFFSET$device);
    }

    public VkUbmSurfaceCreateInfoSEC device(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$device, OFFSET$device, value);
        return this;
    }

    public VkUbmSurfaceCreateInfoSEC device(@Nullable IPointer pointer) {
        device(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment surface() {
        return segment.get(LAYOUT$surface, OFFSET$surface);
    }

    public VkUbmSurfaceCreateInfoSEC surface(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$surface, OFFSET$surface, value);
        return this;
    }

    public VkUbmSurfaceCreateInfoSEC surface(@Nullable IPointer pointer) {
        surface(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.ADDRESS.withName("device"),
        ValueLayout.ADDRESS.withName("surface")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$device = PathElement.groupElement("device");
    public static final PathElement PATH$surface = PathElement.groupElement("surface");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final AddressLayout LAYOUT$device = (AddressLayout) LAYOUT.select(PATH$device);
    public static final AddressLayout LAYOUT$surface = (AddressLayout) LAYOUT.select(PATH$surface);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$device = LAYOUT$device.byteSize();
    public static final long SIZE$surface = LAYOUT$surface.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$device = LAYOUT.byteOffset(PATH$device);
    public static final long OFFSET$surface = LAYOUT.byteOffset(PATH$surface);
}
