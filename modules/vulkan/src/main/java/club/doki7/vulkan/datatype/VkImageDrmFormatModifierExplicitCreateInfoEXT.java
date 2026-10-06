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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageDrmFormatModifierExplicitCreateInfoEXT.html"><code>VkImageDrmFormatModifierExplicitCreateInfoEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkImageDrmFormatModifierExplicitCreateInfoEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint64_t drmFormatModifier; // @link substring="drmFormatModifier" target="#drmFormatModifier"
///     uint32_t drmFormatModifierPlaneCount; // @link substring="drmFormatModifierPlaneCount" target="#drmFormatModifierPlaneCount"
///     VkSubresourceLayout const* pPlaneLayouts; // @link substring="VkSubresourceLayout" target="VkSubresourceLayout" @link substring="pPlaneLayouts" target="#pPlaneLayouts"
/// } VkImageDrmFormatModifierExplicitCreateInfoEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_IMAGE_DRM_FORMAT_MODIFIER_EXPLICIT_CREATE_INFO_EXT`
///
/// The {@code allocate} ({@link VkImageDrmFormatModifierExplicitCreateInfoEXT#allocate(Arena)}, {@link VkImageDrmFormatModifierExplicitCreateInfoEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkImageDrmFormatModifierExplicitCreateInfoEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageDrmFormatModifierExplicitCreateInfoEXT.html"><code>VkImageDrmFormatModifierExplicitCreateInfoEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkImageDrmFormatModifierExplicitCreateInfoEXT(@NotNull MemorySegment segment) implements IVkImageDrmFormatModifierExplicitCreateInfoEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageDrmFormatModifierExplicitCreateInfoEXT.html"><code>VkImageDrmFormatModifierExplicitCreateInfoEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkImageDrmFormatModifierExplicitCreateInfoEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkImageDrmFormatModifierExplicitCreateInfoEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkImageDrmFormatModifierExplicitCreateInfoEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkImageDrmFormatModifierExplicitCreateInfoEXT, Iterable<VkImageDrmFormatModifierExplicitCreateInfoEXT> {
        public long size() {
            return segment.byteSize() / VkImageDrmFormatModifierExplicitCreateInfoEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkImageDrmFormatModifierExplicitCreateInfoEXT at(long index) {
            return new VkImageDrmFormatModifierExplicitCreateInfoEXT(segment.asSlice(index * VkImageDrmFormatModifierExplicitCreateInfoEXT.BYTES, VkImageDrmFormatModifierExplicitCreateInfoEXT.BYTES));
        }

        public VkImageDrmFormatModifierExplicitCreateInfoEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkImageDrmFormatModifierExplicitCreateInfoEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkImageDrmFormatModifierExplicitCreateInfoEXT value) {
            MemorySegment s = segment.asSlice(index * VkImageDrmFormatModifierExplicitCreateInfoEXT.BYTES, VkImageDrmFormatModifierExplicitCreateInfoEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkImageDrmFormatModifierExplicitCreateInfoEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkImageDrmFormatModifierExplicitCreateInfoEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkImageDrmFormatModifierExplicitCreateInfoEXT.BYTES,
                (end - start) * VkImageDrmFormatModifierExplicitCreateInfoEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkImageDrmFormatModifierExplicitCreateInfoEXT.BYTES));
        }

        public VkImageDrmFormatModifierExplicitCreateInfoEXT[] toArray() {
            VkImageDrmFormatModifierExplicitCreateInfoEXT[] ret = new VkImageDrmFormatModifierExplicitCreateInfoEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkImageDrmFormatModifierExplicitCreateInfoEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkImageDrmFormatModifierExplicitCreateInfoEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkImageDrmFormatModifierExplicitCreateInfoEXT.BYTES;
            }

            @Override
            public VkImageDrmFormatModifierExplicitCreateInfoEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkImageDrmFormatModifierExplicitCreateInfoEXT ret = new VkImageDrmFormatModifierExplicitCreateInfoEXT(segment.asSlice(0, VkImageDrmFormatModifierExplicitCreateInfoEXT.BYTES));
                segment = segment.asSlice(VkImageDrmFormatModifierExplicitCreateInfoEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkImageDrmFormatModifierExplicitCreateInfoEXT allocate(Arena arena) {
        VkImageDrmFormatModifierExplicitCreateInfoEXT ret = new VkImageDrmFormatModifierExplicitCreateInfoEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.IMAGE_DRM_FORMAT_MODIFIER_EXPLICIT_CREATE_INFO_EXT);
        return ret;
    }

    public static VkImageDrmFormatModifierExplicitCreateInfoEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkImageDrmFormatModifierExplicitCreateInfoEXT.Ptr ret = new VkImageDrmFormatModifierExplicitCreateInfoEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.IMAGE_DRM_FORMAT_MODIFIER_EXPLICIT_CREATE_INFO_EXT);
        }
        return ret;
    }

    public static VkImageDrmFormatModifierExplicitCreateInfoEXT clone(Arena arena, VkImageDrmFormatModifierExplicitCreateInfoEXT src) {
        VkImageDrmFormatModifierExplicitCreateInfoEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.IMAGE_DRM_FORMAT_MODIFIER_EXPLICIT_CREATE_INFO_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkImageDrmFormatModifierExplicitCreateInfoEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkImageDrmFormatModifierExplicitCreateInfoEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkImageDrmFormatModifierExplicitCreateInfoEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned long drmFormatModifier() {
        return segment.get(LAYOUT$drmFormatModifier, OFFSET$drmFormatModifier);
    }

    public VkImageDrmFormatModifierExplicitCreateInfoEXT drmFormatModifier(@Unsigned long value) {
        segment.set(LAYOUT$drmFormatModifier, OFFSET$drmFormatModifier, value);
        return this;
    }

    public @Unsigned int drmFormatModifierPlaneCount() {
        return segment.get(LAYOUT$drmFormatModifierPlaneCount, OFFSET$drmFormatModifierPlaneCount);
    }

    public VkImageDrmFormatModifierExplicitCreateInfoEXT drmFormatModifierPlaneCount(@Unsigned int value) {
        segment.set(LAYOUT$drmFormatModifierPlaneCount, OFFSET$drmFormatModifierPlaneCount, value);
        return this;
    }

    public VkImageDrmFormatModifierExplicitCreateInfoEXT pPlaneLayouts(@Nullable IVkSubresourceLayout value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pPlaneLayoutsRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkSubresourceLayout.Ptr pPlaneLayouts(int assumedCount) {
        MemorySegment s = pPlaneLayoutsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkSubresourceLayout.BYTES);
        return new VkSubresourceLayout.Ptr(s);
    }

    public @Nullable VkSubresourceLayout pPlaneLayouts() {
        MemorySegment s = pPlaneLayoutsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkSubresourceLayout(s);
    }

    public @Pointer(target=VkSubresourceLayout.class) @NotNull MemorySegment pPlaneLayoutsRaw() {
        return segment.get(LAYOUT$pPlaneLayouts, OFFSET$pPlaneLayouts);
    }

    public void pPlaneLayoutsRaw(@Pointer(target=VkSubresourceLayout.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pPlaneLayouts, OFFSET$pPlaneLayouts, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_LONG.withName("drmFormatModifier"),
        ValueLayout.JAVA_INT.withName("drmFormatModifierPlaneCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkSubresourceLayout.LAYOUT).withName("pPlaneLayouts")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$drmFormatModifier = PathElement.groupElement("drmFormatModifier");
    public static final PathElement PATH$drmFormatModifierPlaneCount = PathElement.groupElement("drmFormatModifierPlaneCount");
    public static final PathElement PATH$pPlaneLayouts = PathElement.groupElement("pPlaneLayouts");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfLong LAYOUT$drmFormatModifier = (OfLong) LAYOUT.select(PATH$drmFormatModifier);
    public static final OfInt LAYOUT$drmFormatModifierPlaneCount = (OfInt) LAYOUT.select(PATH$drmFormatModifierPlaneCount);
    public static final AddressLayout LAYOUT$pPlaneLayouts = (AddressLayout) LAYOUT.select(PATH$pPlaneLayouts);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$drmFormatModifier = LAYOUT$drmFormatModifier.byteSize();
    public static final long SIZE$drmFormatModifierPlaneCount = LAYOUT$drmFormatModifierPlaneCount.byteSize();
    public static final long SIZE$pPlaneLayouts = LAYOUT$pPlaneLayouts.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$drmFormatModifier = LAYOUT.byteOffset(PATH$drmFormatModifier);
    public static final long OFFSET$drmFormatModifierPlaneCount = LAYOUT.byteOffset(PATH$drmFormatModifierPlaneCount);
    public static final long OFFSET$pPlaneLayouts = LAYOUT.byteOffset(PATH$pPlaneLayouts);
}
