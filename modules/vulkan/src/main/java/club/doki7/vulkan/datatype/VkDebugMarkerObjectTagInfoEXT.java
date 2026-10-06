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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDebugMarkerObjectTagInfoEXT.html"><code>VkDebugMarkerObjectTagInfoEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDebugMarkerObjectTagInfoEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkDebugReportObjectTypeEXT objectType; // @link substring="VkDebugReportObjectTypeEXT" target="VkDebugReportObjectTypeEXT" @link substring="objectType" target="#objectType"
///     uint64_t object; // @link substring="object" target="#object"
///     uint64_t tagName; // @link substring="tagName" target="#tagName"
///     size_t tagSize; // @link substring="tagSize" target="#tagSize"
///     void const* pTag; // @link substring="pTag" target="#pTag"
/// } VkDebugMarkerObjectTagInfoEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_DEBUG_MARKER_OBJECT_TAG_INFO_EXT`
///
/// The {@code allocate} ({@link VkDebugMarkerObjectTagInfoEXT#allocate(Arena)}, {@link VkDebugMarkerObjectTagInfoEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkDebugMarkerObjectTagInfoEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDebugMarkerObjectTagInfoEXT.html"><code>VkDebugMarkerObjectTagInfoEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDebugMarkerObjectTagInfoEXT(@NotNull MemorySegment segment) implements IVkDebugMarkerObjectTagInfoEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDebugMarkerObjectTagInfoEXT.html"><code>VkDebugMarkerObjectTagInfoEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDebugMarkerObjectTagInfoEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDebugMarkerObjectTagInfoEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDebugMarkerObjectTagInfoEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDebugMarkerObjectTagInfoEXT, Iterable<VkDebugMarkerObjectTagInfoEXT> {
        public long size() {
            return segment.byteSize() / VkDebugMarkerObjectTagInfoEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDebugMarkerObjectTagInfoEXT at(long index) {
            return new VkDebugMarkerObjectTagInfoEXT(segment.asSlice(index * VkDebugMarkerObjectTagInfoEXT.BYTES, VkDebugMarkerObjectTagInfoEXT.BYTES));
        }

        public VkDebugMarkerObjectTagInfoEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkDebugMarkerObjectTagInfoEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDebugMarkerObjectTagInfoEXT value) {
            MemorySegment s = segment.asSlice(index * VkDebugMarkerObjectTagInfoEXT.BYTES, VkDebugMarkerObjectTagInfoEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDebugMarkerObjectTagInfoEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDebugMarkerObjectTagInfoEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDebugMarkerObjectTagInfoEXT.BYTES,
                (end - start) * VkDebugMarkerObjectTagInfoEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDebugMarkerObjectTagInfoEXT.BYTES));
        }

        public VkDebugMarkerObjectTagInfoEXT[] toArray() {
            VkDebugMarkerObjectTagInfoEXT[] ret = new VkDebugMarkerObjectTagInfoEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDebugMarkerObjectTagInfoEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDebugMarkerObjectTagInfoEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDebugMarkerObjectTagInfoEXT.BYTES;
            }

            @Override
            public VkDebugMarkerObjectTagInfoEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDebugMarkerObjectTagInfoEXT ret = new VkDebugMarkerObjectTagInfoEXT(segment.asSlice(0, VkDebugMarkerObjectTagInfoEXT.BYTES));
                segment = segment.asSlice(VkDebugMarkerObjectTagInfoEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDebugMarkerObjectTagInfoEXT allocate(Arena arena) {
        VkDebugMarkerObjectTagInfoEXT ret = new VkDebugMarkerObjectTagInfoEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.DEBUG_MARKER_OBJECT_TAG_INFO_EXT);
        return ret;
    }

    public static VkDebugMarkerObjectTagInfoEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkDebugMarkerObjectTagInfoEXT.Ptr ret = new VkDebugMarkerObjectTagInfoEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.DEBUG_MARKER_OBJECT_TAG_INFO_EXT);
        }
        return ret;
    }

    public static VkDebugMarkerObjectTagInfoEXT clone(Arena arena, VkDebugMarkerObjectTagInfoEXT src) {
        VkDebugMarkerObjectTagInfoEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.DEBUG_MARKER_OBJECT_TAG_INFO_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkDebugMarkerObjectTagInfoEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkDebugMarkerObjectTagInfoEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkDebugMarkerObjectTagInfoEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @EnumType(VkDebugReportObjectTypeEXT.class) int objectType() {
        return segment.get(LAYOUT$objectType, OFFSET$objectType);
    }

    public VkDebugMarkerObjectTagInfoEXT objectType(@EnumType(VkDebugReportObjectTypeEXT.class) int value) {
        segment.set(LAYOUT$objectType, OFFSET$objectType, value);
        return this;
    }

    public @Unsigned long object() {
        return segment.get(LAYOUT$object, OFFSET$object);
    }

    public VkDebugMarkerObjectTagInfoEXT object(@Unsigned long value) {
        segment.set(LAYOUT$object, OFFSET$object, value);
        return this;
    }

    public @Unsigned long tagName() {
        return segment.get(LAYOUT$tagName, OFFSET$tagName);
    }

    public VkDebugMarkerObjectTagInfoEXT tagName(@Unsigned long value) {
        segment.set(LAYOUT$tagName, OFFSET$tagName, value);
        return this;
    }

    public @Unsigned long tagSize() {
        return NativeLayout.readCSizeT(segment, OFFSET$tagSize);
    }

    public VkDebugMarkerObjectTagInfoEXT tagSize(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$tagSize, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pTag() {
        return segment.get(LAYOUT$pTag, OFFSET$pTag);
    }

    public VkDebugMarkerObjectTagInfoEXT pTag(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pTag, OFFSET$pTag, value);
        return this;
    }

    public VkDebugMarkerObjectTagInfoEXT pTag(@Nullable IPointer pointer) {
        pTag(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("objectType"),
        ValueLayout.JAVA_LONG.withName("object"),
        ValueLayout.JAVA_LONG.withName("tagName"),
        NativeLayout.C_SIZE_T.withName("tagSize"),
        ValueLayout.ADDRESS.withName("pTag")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$objectType = PathElement.groupElement("objectType");
    public static final PathElement PATH$object = PathElement.groupElement("object");
    public static final PathElement PATH$tagName = PathElement.groupElement("tagName");
    public static final PathElement PATH$tagSize = PathElement.groupElement("tagSize");
    public static final PathElement PATH$pTag = PathElement.groupElement("pTag");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$objectType = (OfInt) LAYOUT.select(PATH$objectType);
    public static final OfLong LAYOUT$object = (OfLong) LAYOUT.select(PATH$object);
    public static final OfLong LAYOUT$tagName = (OfLong) LAYOUT.select(PATH$tagName);
    public static final AddressLayout LAYOUT$pTag = (AddressLayout) LAYOUT.select(PATH$pTag);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$objectType = LAYOUT$objectType.byteSize();
    public static final long SIZE$object = LAYOUT$object.byteSize();
    public static final long SIZE$tagName = LAYOUT$tagName.byteSize();
    public static final long SIZE$tagSize = NativeLayout.C_SIZE_T.byteSize();
    public static final long SIZE$pTag = LAYOUT$pTag.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$objectType = LAYOUT.byteOffset(PATH$objectType);
    public static final long OFFSET$object = LAYOUT.byteOffset(PATH$object);
    public static final long OFFSET$tagName = LAYOUT.byteOffset(PATH$tagName);
    public static final long OFFSET$tagSize = LAYOUT.byteOffset(PATH$tagSize);
    public static final long OFFSET$pTag = LAYOUT.byteOffset(PATH$pTag);
}
