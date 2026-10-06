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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDebugUtilsObjectNameInfoEXT.html"><code>VkDebugUtilsObjectNameInfoEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDebugUtilsObjectNameInfoEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkObjectType objectType; // @link substring="VkObjectType" target="VkObjectType" @link substring="objectType" target="#objectType"
///     uint64_t objectHandle; // @link substring="objectHandle" target="#objectHandle"
///     char const* pObjectName; // optional // @link substring="pObjectName" target="#pObjectName"
/// } VkDebugUtilsObjectNameInfoEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_DEBUG_UTILS_OBJECT_NAME_INFO_EXT`
///
/// The {@code allocate} ({@link VkDebugUtilsObjectNameInfoEXT#allocate(Arena)}, {@link VkDebugUtilsObjectNameInfoEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkDebugUtilsObjectNameInfoEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDebugUtilsObjectNameInfoEXT.html"><code>VkDebugUtilsObjectNameInfoEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDebugUtilsObjectNameInfoEXT(@NotNull MemorySegment segment) implements IVkDebugUtilsObjectNameInfoEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDebugUtilsObjectNameInfoEXT.html"><code>VkDebugUtilsObjectNameInfoEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDebugUtilsObjectNameInfoEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDebugUtilsObjectNameInfoEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDebugUtilsObjectNameInfoEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDebugUtilsObjectNameInfoEXT, Iterable<VkDebugUtilsObjectNameInfoEXT> {
        public long size() {
            return segment.byteSize() / VkDebugUtilsObjectNameInfoEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDebugUtilsObjectNameInfoEXT at(long index) {
            return new VkDebugUtilsObjectNameInfoEXT(segment.asSlice(index * VkDebugUtilsObjectNameInfoEXT.BYTES, VkDebugUtilsObjectNameInfoEXT.BYTES));
        }

        public VkDebugUtilsObjectNameInfoEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkDebugUtilsObjectNameInfoEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDebugUtilsObjectNameInfoEXT value) {
            MemorySegment s = segment.asSlice(index * VkDebugUtilsObjectNameInfoEXT.BYTES, VkDebugUtilsObjectNameInfoEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDebugUtilsObjectNameInfoEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDebugUtilsObjectNameInfoEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDebugUtilsObjectNameInfoEXT.BYTES,
                (end - start) * VkDebugUtilsObjectNameInfoEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDebugUtilsObjectNameInfoEXT.BYTES));
        }

        public VkDebugUtilsObjectNameInfoEXT[] toArray() {
            VkDebugUtilsObjectNameInfoEXT[] ret = new VkDebugUtilsObjectNameInfoEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDebugUtilsObjectNameInfoEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDebugUtilsObjectNameInfoEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDebugUtilsObjectNameInfoEXT.BYTES;
            }

            @Override
            public VkDebugUtilsObjectNameInfoEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDebugUtilsObjectNameInfoEXT ret = new VkDebugUtilsObjectNameInfoEXT(segment.asSlice(0, VkDebugUtilsObjectNameInfoEXT.BYTES));
                segment = segment.asSlice(VkDebugUtilsObjectNameInfoEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDebugUtilsObjectNameInfoEXT allocate(Arena arena) {
        VkDebugUtilsObjectNameInfoEXT ret = new VkDebugUtilsObjectNameInfoEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.DEBUG_UTILS_OBJECT_NAME_INFO_EXT);
        return ret;
    }

    public static VkDebugUtilsObjectNameInfoEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkDebugUtilsObjectNameInfoEXT.Ptr ret = new VkDebugUtilsObjectNameInfoEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.DEBUG_UTILS_OBJECT_NAME_INFO_EXT);
        }
        return ret;
    }

    public static VkDebugUtilsObjectNameInfoEXT clone(Arena arena, VkDebugUtilsObjectNameInfoEXT src) {
        VkDebugUtilsObjectNameInfoEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.DEBUG_UTILS_OBJECT_NAME_INFO_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkDebugUtilsObjectNameInfoEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkDebugUtilsObjectNameInfoEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkDebugUtilsObjectNameInfoEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @EnumType(VkObjectType.class) int objectType() {
        return segment.get(LAYOUT$objectType, OFFSET$objectType);
    }

    public VkDebugUtilsObjectNameInfoEXT objectType(@EnumType(VkObjectType.class) int value) {
        segment.set(LAYOUT$objectType, OFFSET$objectType, value);
        return this;
    }

    public @Unsigned long objectHandle() {
        return segment.get(LAYOUT$objectHandle, OFFSET$objectHandle);
    }

    public VkDebugUtilsObjectNameInfoEXT objectHandle(@Unsigned long value) {
        segment.set(LAYOUT$objectHandle, OFFSET$objectHandle, value);
        return this;
    }

    /// Note: the returned {@link BytePtr} does not have correct
    /// {@link BytePtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link BytePtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable BytePtr pObjectName() {
        MemorySegment s = pObjectNameRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new BytePtr(s);
    }

    public VkDebugUtilsObjectNameInfoEXT pObjectName(@Nullable BytePtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pObjectNameRaw(s);
        return this;
    }

    public @Pointer(comment="int8_t*") @NotNull MemorySegment pObjectNameRaw() {
        return segment.get(LAYOUT$pObjectName, OFFSET$pObjectName);
    }

    public void pObjectNameRaw(@Pointer(comment="int8_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pObjectName, OFFSET$pObjectName, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("objectType"),
        ValueLayout.JAVA_LONG.withName("objectHandle"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE).withName("pObjectName")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$objectType = PathElement.groupElement("objectType");
    public static final PathElement PATH$objectHandle = PathElement.groupElement("objectHandle");
    public static final PathElement PATH$pObjectName = PathElement.groupElement("pObjectName");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$objectType = (OfInt) LAYOUT.select(PATH$objectType);
    public static final OfLong LAYOUT$objectHandle = (OfLong) LAYOUT.select(PATH$objectHandle);
    public static final AddressLayout LAYOUT$pObjectName = (AddressLayout) LAYOUT.select(PATH$pObjectName);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$objectType = LAYOUT$objectType.byteSize();
    public static final long SIZE$objectHandle = LAYOUT$objectHandle.byteSize();
    public static final long SIZE$pObjectName = LAYOUT$pObjectName.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$objectType = LAYOUT.byteOffset(PATH$objectType);
    public static final long OFFSET$objectHandle = LAYOUT.byteOffset(PATH$objectHandle);
    public static final long OFFSET$pObjectName = LAYOUT.byteOffset(PATH$pObjectName);
}
