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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDrmFormatModifierPropertiesList2EXT.html"><code>VkDrmFormatModifierPropertiesList2EXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDrmFormatModifierPropertiesList2EXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t drmFormatModifierCount; // optional // @link substring="drmFormatModifierCount" target="#drmFormatModifierCount"
///     VkDrmFormatModifierProperties2EXT* pDrmFormatModifierProperties; // optional // @link substring="VkDrmFormatModifierProperties2EXT" target="VkDrmFormatModifierProperties2EXT" @link substring="pDrmFormatModifierProperties" target="#pDrmFormatModifierProperties"
/// } VkDrmFormatModifierPropertiesList2EXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_DRM_FORMAT_MODIFIER_PROPERTIES_LIST_2_EXT`
///
/// The {@code allocate} ({@link VkDrmFormatModifierPropertiesList2EXT#allocate(Arena)}, {@link VkDrmFormatModifierPropertiesList2EXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkDrmFormatModifierPropertiesList2EXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDrmFormatModifierPropertiesList2EXT.html"><code>VkDrmFormatModifierPropertiesList2EXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDrmFormatModifierPropertiesList2EXT(@NotNull MemorySegment segment) implements IVkDrmFormatModifierPropertiesList2EXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDrmFormatModifierPropertiesList2EXT.html"><code>VkDrmFormatModifierPropertiesList2EXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDrmFormatModifierPropertiesList2EXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDrmFormatModifierPropertiesList2EXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDrmFormatModifierPropertiesList2EXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDrmFormatModifierPropertiesList2EXT, Iterable<VkDrmFormatModifierPropertiesList2EXT> {
        public long size() {
            return segment.byteSize() / VkDrmFormatModifierPropertiesList2EXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDrmFormatModifierPropertiesList2EXT at(long index) {
            return new VkDrmFormatModifierPropertiesList2EXT(segment.asSlice(index * VkDrmFormatModifierPropertiesList2EXT.BYTES, VkDrmFormatModifierPropertiesList2EXT.BYTES));
        }

        public VkDrmFormatModifierPropertiesList2EXT.Ptr at(long index, @NotNull Consumer<@NotNull VkDrmFormatModifierPropertiesList2EXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDrmFormatModifierPropertiesList2EXT value) {
            MemorySegment s = segment.asSlice(index * VkDrmFormatModifierPropertiesList2EXT.BYTES, VkDrmFormatModifierPropertiesList2EXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDrmFormatModifierPropertiesList2EXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDrmFormatModifierPropertiesList2EXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDrmFormatModifierPropertiesList2EXT.BYTES,
                (end - start) * VkDrmFormatModifierPropertiesList2EXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDrmFormatModifierPropertiesList2EXT.BYTES));
        }

        public VkDrmFormatModifierPropertiesList2EXT[] toArray() {
            VkDrmFormatModifierPropertiesList2EXT[] ret = new VkDrmFormatModifierPropertiesList2EXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDrmFormatModifierPropertiesList2EXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDrmFormatModifierPropertiesList2EXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDrmFormatModifierPropertiesList2EXT.BYTES;
            }

            @Override
            public VkDrmFormatModifierPropertiesList2EXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDrmFormatModifierPropertiesList2EXT ret = new VkDrmFormatModifierPropertiesList2EXT(segment.asSlice(0, VkDrmFormatModifierPropertiesList2EXT.BYTES));
                segment = segment.asSlice(VkDrmFormatModifierPropertiesList2EXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDrmFormatModifierPropertiesList2EXT allocate(Arena arena) {
        VkDrmFormatModifierPropertiesList2EXT ret = new VkDrmFormatModifierPropertiesList2EXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.DRM_FORMAT_MODIFIER_PROPERTIES_LIST_2_EXT);
        return ret;
    }

    public static VkDrmFormatModifierPropertiesList2EXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkDrmFormatModifierPropertiesList2EXT.Ptr ret = new VkDrmFormatModifierPropertiesList2EXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.DRM_FORMAT_MODIFIER_PROPERTIES_LIST_2_EXT);
        }
        return ret;
    }

    public static VkDrmFormatModifierPropertiesList2EXT clone(Arena arena, VkDrmFormatModifierPropertiesList2EXT src) {
        VkDrmFormatModifierPropertiesList2EXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.DRM_FORMAT_MODIFIER_PROPERTIES_LIST_2_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkDrmFormatModifierPropertiesList2EXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkDrmFormatModifierPropertiesList2EXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkDrmFormatModifierPropertiesList2EXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int drmFormatModifierCount() {
        return segment.get(LAYOUT$drmFormatModifierCount, OFFSET$drmFormatModifierCount);
    }

    public VkDrmFormatModifierPropertiesList2EXT drmFormatModifierCount(@Unsigned int value) {
        segment.set(LAYOUT$drmFormatModifierCount, OFFSET$drmFormatModifierCount, value);
        return this;
    }

    public VkDrmFormatModifierPropertiesList2EXT pDrmFormatModifierProperties(@Nullable IVkDrmFormatModifierProperties2EXT value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pDrmFormatModifierPropertiesRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkDrmFormatModifierProperties2EXT.Ptr pDrmFormatModifierProperties(int assumedCount) {
        MemorySegment s = pDrmFormatModifierPropertiesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkDrmFormatModifierProperties2EXT.BYTES);
        return new VkDrmFormatModifierProperties2EXT.Ptr(s);
    }

    public @Nullable VkDrmFormatModifierProperties2EXT pDrmFormatModifierProperties() {
        MemorySegment s = pDrmFormatModifierPropertiesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkDrmFormatModifierProperties2EXT(s);
    }

    public @Pointer(target=VkDrmFormatModifierProperties2EXT.class) @NotNull MemorySegment pDrmFormatModifierPropertiesRaw() {
        return segment.get(LAYOUT$pDrmFormatModifierProperties, OFFSET$pDrmFormatModifierProperties);
    }

    public void pDrmFormatModifierPropertiesRaw(@Pointer(target=VkDrmFormatModifierProperties2EXT.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pDrmFormatModifierProperties, OFFSET$pDrmFormatModifierProperties, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("drmFormatModifierCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkDrmFormatModifierProperties2EXT.LAYOUT).withName("pDrmFormatModifierProperties")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$drmFormatModifierCount = PathElement.groupElement("drmFormatModifierCount");
    public static final PathElement PATH$pDrmFormatModifierProperties = PathElement.groupElement("pDrmFormatModifierProperties");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$drmFormatModifierCount = (OfInt) LAYOUT.select(PATH$drmFormatModifierCount);
    public static final AddressLayout LAYOUT$pDrmFormatModifierProperties = (AddressLayout) LAYOUT.select(PATH$pDrmFormatModifierProperties);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$drmFormatModifierCount = LAYOUT$drmFormatModifierCount.byteSize();
    public static final long SIZE$pDrmFormatModifierProperties = LAYOUT$pDrmFormatModifierProperties.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$drmFormatModifierCount = LAYOUT.byteOffset(PATH$drmFormatModifierCount);
    public static final long OFFSET$pDrmFormatModifierProperties = LAYOUT.byteOffset(PATH$pDrmFormatModifierProperties);
}
