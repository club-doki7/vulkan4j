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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDisplaySurfaceCreateInfoKHR.html"><code>VkDisplaySurfaceCreateInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDisplaySurfaceCreateInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkDisplaySurfaceCreateFlagsKHR flags; // optional // @link substring="VkDisplaySurfaceCreateFlagsKHR" target="VkDisplaySurfaceCreateFlagsKHR" @link substring="flags" target="#flags"
///     VkDisplayModeKHR displayMode; // @link substring="VkDisplayModeKHR" target="VkDisplayModeKHR" @link substring="displayMode" target="#displayMode"
///     uint32_t planeIndex; // @link substring="planeIndex" target="#planeIndex"
///     uint32_t planeStackIndex; // @link substring="planeStackIndex" target="#planeStackIndex"
///     VkSurfaceTransformFlagsKHR transform; // @link substring="VkSurfaceTransformFlagsKHR" target="VkSurfaceTransformFlagsKHR" @link substring="transform" target="#transform"
///     float globalAlpha; // @link substring="globalAlpha" target="#globalAlpha"
///     VkDisplayPlaneAlphaFlagsKHR alphaMode; // @link substring="VkDisplayPlaneAlphaFlagsKHR" target="VkDisplayPlaneAlphaFlagsKHR" @link substring="alphaMode" target="#alphaMode"
///     VkExtent2D imageExtent; // @link substring="VkExtent2D" target="VkExtent2D" @link substring="imageExtent" target="#imageExtent"
/// } VkDisplaySurfaceCreateInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_DISPLAY_SURFACE_CREATE_INFO_KHR`
///
/// The {@code allocate} ({@link VkDisplaySurfaceCreateInfoKHR#allocate(Arena)}, {@link VkDisplaySurfaceCreateInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkDisplaySurfaceCreateInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDisplaySurfaceCreateInfoKHR.html"><code>VkDisplaySurfaceCreateInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDisplaySurfaceCreateInfoKHR(@NotNull MemorySegment segment) implements IVkDisplaySurfaceCreateInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDisplaySurfaceCreateInfoKHR.html"><code>VkDisplaySurfaceCreateInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDisplaySurfaceCreateInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDisplaySurfaceCreateInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDisplaySurfaceCreateInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDisplaySurfaceCreateInfoKHR, Iterable<VkDisplaySurfaceCreateInfoKHR> {
        public long size() {
            return segment.byteSize() / VkDisplaySurfaceCreateInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDisplaySurfaceCreateInfoKHR at(long index) {
            return new VkDisplaySurfaceCreateInfoKHR(segment.asSlice(index * VkDisplaySurfaceCreateInfoKHR.BYTES, VkDisplaySurfaceCreateInfoKHR.BYTES));
        }

        public VkDisplaySurfaceCreateInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkDisplaySurfaceCreateInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDisplaySurfaceCreateInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkDisplaySurfaceCreateInfoKHR.BYTES, VkDisplaySurfaceCreateInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDisplaySurfaceCreateInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDisplaySurfaceCreateInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDisplaySurfaceCreateInfoKHR.BYTES,
                (end - start) * VkDisplaySurfaceCreateInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDisplaySurfaceCreateInfoKHR.BYTES));
        }

        public VkDisplaySurfaceCreateInfoKHR[] toArray() {
            VkDisplaySurfaceCreateInfoKHR[] ret = new VkDisplaySurfaceCreateInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDisplaySurfaceCreateInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDisplaySurfaceCreateInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDisplaySurfaceCreateInfoKHR.BYTES;
            }

            @Override
            public VkDisplaySurfaceCreateInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDisplaySurfaceCreateInfoKHR ret = new VkDisplaySurfaceCreateInfoKHR(segment.asSlice(0, VkDisplaySurfaceCreateInfoKHR.BYTES));
                segment = segment.asSlice(VkDisplaySurfaceCreateInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDisplaySurfaceCreateInfoKHR allocate(Arena arena) {
        VkDisplaySurfaceCreateInfoKHR ret = new VkDisplaySurfaceCreateInfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.DISPLAY_SURFACE_CREATE_INFO_KHR);
        return ret;
    }

    public static VkDisplaySurfaceCreateInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkDisplaySurfaceCreateInfoKHR.Ptr ret = new VkDisplaySurfaceCreateInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.DISPLAY_SURFACE_CREATE_INFO_KHR);
        }
        return ret;
    }

    public static VkDisplaySurfaceCreateInfoKHR clone(Arena arena, VkDisplaySurfaceCreateInfoKHR src) {
        VkDisplaySurfaceCreateInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.DISPLAY_SURFACE_CREATE_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkDisplaySurfaceCreateInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkDisplaySurfaceCreateInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkDisplaySurfaceCreateInfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkDisplaySurfaceCreateFlagsKHR.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkDisplaySurfaceCreateInfoKHR flags(@Bitmask(VkDisplaySurfaceCreateFlagsKHR.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @Nullable VkDisplayModeKHR displayMode() {
        MemorySegment s = segment.asSlice(OFFSET$displayMode, SIZE$displayMode);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkDisplayModeKHR(s);
    }

    public VkDisplaySurfaceCreateInfoKHR displayMode(@Nullable VkDisplayModeKHR value) {
        segment.set(LAYOUT$displayMode, OFFSET$displayMode, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int planeIndex() {
        return segment.get(LAYOUT$planeIndex, OFFSET$planeIndex);
    }

    public VkDisplaySurfaceCreateInfoKHR planeIndex(@Unsigned int value) {
        segment.set(LAYOUT$planeIndex, OFFSET$planeIndex, value);
        return this;
    }

    public @Unsigned int planeStackIndex() {
        return segment.get(LAYOUT$planeStackIndex, OFFSET$planeStackIndex);
    }

    public VkDisplaySurfaceCreateInfoKHR planeStackIndex(@Unsigned int value) {
        segment.set(LAYOUT$planeStackIndex, OFFSET$planeStackIndex, value);
        return this;
    }

    public @Bitmask(VkSurfaceTransformFlagsKHR.class) int transform() {
        return segment.get(LAYOUT$transform, OFFSET$transform);
    }

    public VkDisplaySurfaceCreateInfoKHR transform(@Bitmask(VkSurfaceTransformFlagsKHR.class) int value) {
        segment.set(LAYOUT$transform, OFFSET$transform, value);
        return this;
    }

    public float globalAlpha() {
        return segment.get(LAYOUT$globalAlpha, OFFSET$globalAlpha);
    }

    public VkDisplaySurfaceCreateInfoKHR globalAlpha(float value) {
        segment.set(LAYOUT$globalAlpha, OFFSET$globalAlpha, value);
        return this;
    }

    public @Bitmask(VkDisplayPlaneAlphaFlagsKHR.class) int alphaMode() {
        return segment.get(LAYOUT$alphaMode, OFFSET$alphaMode);
    }

    public VkDisplaySurfaceCreateInfoKHR alphaMode(@Bitmask(VkDisplayPlaneAlphaFlagsKHR.class) int value) {
        segment.set(LAYOUT$alphaMode, OFFSET$alphaMode, value);
        return this;
    }

    public @NotNull VkExtent2D imageExtent() {
        return new VkExtent2D(segment.asSlice(OFFSET$imageExtent, LAYOUT$imageExtent));
    }

    public VkDisplaySurfaceCreateInfoKHR imageExtent(@NotNull VkExtent2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$imageExtent, SIZE$imageExtent);
        return this;
    }

    public VkDisplaySurfaceCreateInfoKHR imageExtent(Consumer<@NotNull VkExtent2D> consumer) {
        consumer.accept(imageExtent());
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.ADDRESS.withName("displayMode"),
        ValueLayout.JAVA_INT.withName("planeIndex"),
        ValueLayout.JAVA_INT.withName("planeStackIndex"),
        ValueLayout.JAVA_INT.withName("transform"),
        ValueLayout.JAVA_FLOAT.withName("globalAlpha"),
        ValueLayout.JAVA_INT.withName("alphaMode"),
        VkExtent2D.LAYOUT.withName("imageExtent")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$displayMode = PathElement.groupElement("displayMode");
    public static final PathElement PATH$planeIndex = PathElement.groupElement("planeIndex");
    public static final PathElement PATH$planeStackIndex = PathElement.groupElement("planeStackIndex");
    public static final PathElement PATH$transform = PathElement.groupElement("transform");
    public static final PathElement PATH$globalAlpha = PathElement.groupElement("globalAlpha");
    public static final PathElement PATH$alphaMode = PathElement.groupElement("alphaMode");
    public static final PathElement PATH$imageExtent = PathElement.groupElement("imageExtent");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final AddressLayout LAYOUT$displayMode = (AddressLayout) LAYOUT.select(PATH$displayMode);
    public static final OfInt LAYOUT$planeIndex = (OfInt) LAYOUT.select(PATH$planeIndex);
    public static final OfInt LAYOUT$planeStackIndex = (OfInt) LAYOUT.select(PATH$planeStackIndex);
    public static final OfInt LAYOUT$transform = (OfInt) LAYOUT.select(PATH$transform);
    public static final OfFloat LAYOUT$globalAlpha = (OfFloat) LAYOUT.select(PATH$globalAlpha);
    public static final OfInt LAYOUT$alphaMode = (OfInt) LAYOUT.select(PATH$alphaMode);
    public static final StructLayout LAYOUT$imageExtent = (StructLayout) LAYOUT.select(PATH$imageExtent);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$displayMode = LAYOUT$displayMode.byteSize();
    public static final long SIZE$planeIndex = LAYOUT$planeIndex.byteSize();
    public static final long SIZE$planeStackIndex = LAYOUT$planeStackIndex.byteSize();
    public static final long SIZE$transform = LAYOUT$transform.byteSize();
    public static final long SIZE$globalAlpha = LAYOUT$globalAlpha.byteSize();
    public static final long SIZE$alphaMode = LAYOUT$alphaMode.byteSize();
    public static final long SIZE$imageExtent = LAYOUT$imageExtent.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$displayMode = LAYOUT.byteOffset(PATH$displayMode);
    public static final long OFFSET$planeIndex = LAYOUT.byteOffset(PATH$planeIndex);
    public static final long OFFSET$planeStackIndex = LAYOUT.byteOffset(PATH$planeStackIndex);
    public static final long OFFSET$transform = LAYOUT.byteOffset(PATH$transform);
    public static final long OFFSET$globalAlpha = LAYOUT.byteOffset(PATH$globalAlpha);
    public static final long OFFSET$alphaMode = LAYOUT.byteOffset(PATH$alphaMode);
    public static final long OFFSET$imageExtent = LAYOUT.byteOffset(PATH$imageExtent);
}
