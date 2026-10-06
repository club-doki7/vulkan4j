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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkLayerSettingEXT.html"><code>VkLayerSettingEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkLayerSettingEXT {
///     char const* pLayerName; // @link substring="pLayerName" target="#pLayerName"
///     char const* pSettingName; // @link substring="pSettingName" target="#pSettingName"
///     VkLayerSettingTypeEXT type; // @link substring="VkLayerSettingTypeEXT" target="VkLayerSettingTypeEXT" @link substring="type" target="#type"
///     uint32_t valueCount; // optional // @link substring="valueCount" target="#valueCount"
///     void const* pValues; // optional // @link substring="pValues" target="#pValues"
/// } VkLayerSettingEXT;
/// }
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkLayerSettingEXT.html"><code>VkLayerSettingEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkLayerSettingEXT(@NotNull MemorySegment segment) implements IVkLayerSettingEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkLayerSettingEXT.html"><code>VkLayerSettingEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkLayerSettingEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkLayerSettingEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkLayerSettingEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkLayerSettingEXT, Iterable<VkLayerSettingEXT> {
        public long size() {
            return segment.byteSize() / VkLayerSettingEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkLayerSettingEXT at(long index) {
            return new VkLayerSettingEXT(segment.asSlice(index * VkLayerSettingEXT.BYTES, VkLayerSettingEXT.BYTES));
        }

        public VkLayerSettingEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkLayerSettingEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkLayerSettingEXT value) {
            MemorySegment s = segment.asSlice(index * VkLayerSettingEXT.BYTES, VkLayerSettingEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkLayerSettingEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkLayerSettingEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkLayerSettingEXT.BYTES,
                (end - start) * VkLayerSettingEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkLayerSettingEXT.BYTES));
        }

        public VkLayerSettingEXT[] toArray() {
            VkLayerSettingEXT[] ret = new VkLayerSettingEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkLayerSettingEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkLayerSettingEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkLayerSettingEXT.BYTES;
            }

            @Override
            public VkLayerSettingEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkLayerSettingEXT ret = new VkLayerSettingEXT(segment.asSlice(0, VkLayerSettingEXT.BYTES));
                segment = segment.asSlice(VkLayerSettingEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkLayerSettingEXT allocate(Arena arena) {
        return new VkLayerSettingEXT(arena.allocate(LAYOUT));
    }

    public static VkLayerSettingEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkLayerSettingEXT.Ptr(segment);
    }

    public static VkLayerSettingEXT clone(Arena arena, VkLayerSettingEXT src) {
        VkLayerSettingEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    /// Note: the returned {@link BytePtr} does not have correct
    /// {@link BytePtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link BytePtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable BytePtr pLayerName() {
        MemorySegment s = pLayerNameRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new BytePtr(s);
    }

    public VkLayerSettingEXT pLayerName(@Nullable BytePtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pLayerNameRaw(s);
        return this;
    }

    public @Pointer(comment="int8_t*") @NotNull MemorySegment pLayerNameRaw() {
        return segment.get(LAYOUT$pLayerName, OFFSET$pLayerName);
    }

    public void pLayerNameRaw(@Pointer(comment="int8_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pLayerName, OFFSET$pLayerName, value);
    }

    /// Note: the returned {@link BytePtr} does not have correct
    /// {@link BytePtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link BytePtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable BytePtr pSettingName() {
        MemorySegment s = pSettingNameRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new BytePtr(s);
    }

    public VkLayerSettingEXT pSettingName(@Nullable BytePtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pSettingNameRaw(s);
        return this;
    }

    public @Pointer(comment="int8_t*") @NotNull MemorySegment pSettingNameRaw() {
        return segment.get(LAYOUT$pSettingName, OFFSET$pSettingName);
    }

    public void pSettingNameRaw(@Pointer(comment="int8_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pSettingName, OFFSET$pSettingName, value);
    }

    public @EnumType(VkLayerSettingTypeEXT.class) int type() {
        return segment.get(LAYOUT$type, OFFSET$type);
    }

    public VkLayerSettingEXT type(@EnumType(VkLayerSettingTypeEXT.class) int value) {
        segment.set(LAYOUT$type, OFFSET$type, value);
        return this;
    }

    public @Unsigned int valueCount() {
        return segment.get(LAYOUT$valueCount, OFFSET$valueCount);
    }

    public VkLayerSettingEXT valueCount(@Unsigned int value) {
        segment.set(LAYOUT$valueCount, OFFSET$valueCount, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pValues() {
        return segment.get(LAYOUT$pValues, OFFSET$pValues);
    }

    public VkLayerSettingEXT pValues(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pValues, OFFSET$pValues, value);
        return this;
    }

    public VkLayerSettingEXT pValues(@Nullable IPointer pointer) {
        pValues(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE).withName("pLayerName"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE).withName("pSettingName"),
        ValueLayout.JAVA_INT.withName("type"),
        ValueLayout.JAVA_INT.withName("valueCount"),
        ValueLayout.ADDRESS.withName("pValues")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$pLayerName = PathElement.groupElement("pLayerName");
    public static final PathElement PATH$pSettingName = PathElement.groupElement("pSettingName");
    public static final PathElement PATH$type = PathElement.groupElement("type");
    public static final PathElement PATH$valueCount = PathElement.groupElement("valueCount");
    public static final PathElement PATH$pValues = PathElement.groupElement("pValues");

    public static final AddressLayout LAYOUT$pLayerName = (AddressLayout) LAYOUT.select(PATH$pLayerName);
    public static final AddressLayout LAYOUT$pSettingName = (AddressLayout) LAYOUT.select(PATH$pSettingName);
    public static final OfInt LAYOUT$type = (OfInt) LAYOUT.select(PATH$type);
    public static final OfInt LAYOUT$valueCount = (OfInt) LAYOUT.select(PATH$valueCount);
    public static final AddressLayout LAYOUT$pValues = (AddressLayout) LAYOUT.select(PATH$pValues);

    public static final long SIZE$pLayerName = LAYOUT$pLayerName.byteSize();
    public static final long SIZE$pSettingName = LAYOUT$pSettingName.byteSize();
    public static final long SIZE$type = LAYOUT$type.byteSize();
    public static final long SIZE$valueCount = LAYOUT$valueCount.byteSize();
    public static final long SIZE$pValues = LAYOUT$pValues.byteSize();

    public static final long OFFSET$pLayerName = LAYOUT.byteOffset(PATH$pLayerName);
    public static final long OFFSET$pSettingName = LAYOUT.byteOffset(PATH$pSettingName);
    public static final long OFFSET$type = LAYOUT.byteOffset(PATH$type);
    public static final long OFFSET$valueCount = LAYOUT.byteOffset(PATH$valueCount);
    public static final long OFFSET$pValues = LAYOUT.byteOffset(PATH$pValues);
}
