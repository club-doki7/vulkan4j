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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkApplicationParametersEXT.html"><code>VkApplicationParametersEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkApplicationParametersEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t vendorID; // @link substring="vendorID" target="#vendorID"
///     uint32_t deviceID; // optional // @link substring="deviceID" target="#deviceID"
///     uint32_t key; // @link substring="key" target="#key"
///     uint64_t value; // @link substring="value" target="#value"
/// } VkApplicationParametersEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_APPLICATION_PARAMETERS_EXT`
///
/// The {@code allocate} ({@link VkApplicationParametersEXT#allocate(Arena)}, {@link VkApplicationParametersEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkApplicationParametersEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkApplicationParametersEXT.html"><code>VkApplicationParametersEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkApplicationParametersEXT(@NotNull MemorySegment segment) implements IVkApplicationParametersEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkApplicationParametersEXT.html"><code>VkApplicationParametersEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkApplicationParametersEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkApplicationParametersEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkApplicationParametersEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkApplicationParametersEXT, Iterable<VkApplicationParametersEXT> {
        public long size() {
            return segment.byteSize() / VkApplicationParametersEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkApplicationParametersEXT at(long index) {
            return new VkApplicationParametersEXT(segment.asSlice(index * VkApplicationParametersEXT.BYTES, VkApplicationParametersEXT.BYTES));
        }

        public VkApplicationParametersEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkApplicationParametersEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkApplicationParametersEXT value) {
            MemorySegment s = segment.asSlice(index * VkApplicationParametersEXT.BYTES, VkApplicationParametersEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkApplicationParametersEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkApplicationParametersEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkApplicationParametersEXT.BYTES,
                (end - start) * VkApplicationParametersEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkApplicationParametersEXT.BYTES));
        }

        public VkApplicationParametersEXT[] toArray() {
            VkApplicationParametersEXT[] ret = new VkApplicationParametersEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkApplicationParametersEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkApplicationParametersEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkApplicationParametersEXT.BYTES;
            }

            @Override
            public VkApplicationParametersEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkApplicationParametersEXT ret = new VkApplicationParametersEXT(segment.asSlice(0, VkApplicationParametersEXT.BYTES));
                segment = segment.asSlice(VkApplicationParametersEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkApplicationParametersEXT allocate(Arena arena) {
        VkApplicationParametersEXT ret = new VkApplicationParametersEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.APPLICATION_PARAMETERS_EXT);
        return ret;
    }

    public static VkApplicationParametersEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkApplicationParametersEXT.Ptr ret = new VkApplicationParametersEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.APPLICATION_PARAMETERS_EXT);
        }
        return ret;
    }

    public static VkApplicationParametersEXT clone(Arena arena, VkApplicationParametersEXT src) {
        VkApplicationParametersEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.APPLICATION_PARAMETERS_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkApplicationParametersEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkApplicationParametersEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkApplicationParametersEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int vendorID() {
        return segment.get(LAYOUT$vendorID, OFFSET$vendorID);
    }

    public VkApplicationParametersEXT vendorID(@Unsigned int value) {
        segment.set(LAYOUT$vendorID, OFFSET$vendorID, value);
        return this;
    }

    public @Unsigned int deviceID() {
        return segment.get(LAYOUT$deviceID, OFFSET$deviceID);
    }

    public VkApplicationParametersEXT deviceID(@Unsigned int value) {
        segment.set(LAYOUT$deviceID, OFFSET$deviceID, value);
        return this;
    }

    public @Unsigned int key() {
        return segment.get(LAYOUT$key, OFFSET$key);
    }

    public VkApplicationParametersEXT key(@Unsigned int value) {
        segment.set(LAYOUT$key, OFFSET$key, value);
        return this;
    }

    public @Unsigned long value() {
        return segment.get(LAYOUT$value, OFFSET$value);
    }

    public VkApplicationParametersEXT value(@Unsigned long value) {
        segment.set(LAYOUT$value, OFFSET$value, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("vendorID"),
        ValueLayout.JAVA_INT.withName("deviceID"),
        ValueLayout.JAVA_INT.withName("key"),
        ValueLayout.JAVA_LONG.withName("value")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$vendorID = PathElement.groupElement("vendorID");
    public static final PathElement PATH$deviceID = PathElement.groupElement("deviceID");
    public static final PathElement PATH$key = PathElement.groupElement("key");
    public static final PathElement PATH$value = PathElement.groupElement("value");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$vendorID = (OfInt) LAYOUT.select(PATH$vendorID);
    public static final OfInt LAYOUT$deviceID = (OfInt) LAYOUT.select(PATH$deviceID);
    public static final OfInt LAYOUT$key = (OfInt) LAYOUT.select(PATH$key);
    public static final OfLong LAYOUT$value = (OfLong) LAYOUT.select(PATH$value);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$vendorID = LAYOUT$vendorID.byteSize();
    public static final long SIZE$deviceID = LAYOUT$deviceID.byteSize();
    public static final long SIZE$key = LAYOUT$key.byteSize();
    public static final long SIZE$value = LAYOUT$value.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$vendorID = LAYOUT.byteOffset(PATH$vendorID);
    public static final long OFFSET$deviceID = LAYOUT.byteOffset(PATH$deviceID);
    public static final long OFFSET$key = LAYOUT.byteOffset(PATH$key);
    public static final long OFFSET$value = LAYOUT.byteOffset(PATH$value);
}
