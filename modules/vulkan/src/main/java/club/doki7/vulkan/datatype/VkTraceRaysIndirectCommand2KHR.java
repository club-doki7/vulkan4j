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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkTraceRaysIndirectCommand2KHR.html"><code>VkTraceRaysIndirectCommand2KHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkTraceRaysIndirectCommand2KHR {
///     VkDeviceAddress raygenShaderRecordAddress; // @link substring="raygenShaderRecordAddress" target="#raygenShaderRecordAddress"
///     VkDeviceSize raygenShaderRecordSize; // @link substring="raygenShaderRecordSize" target="#raygenShaderRecordSize"
///     VkDeviceAddress missShaderBindingTableAddress; // @link substring="missShaderBindingTableAddress" target="#missShaderBindingTableAddress"
///     VkDeviceSize missShaderBindingTableSize; // @link substring="missShaderBindingTableSize" target="#missShaderBindingTableSize"
///     VkDeviceSize missShaderBindingTableStride; // @link substring="missShaderBindingTableStride" target="#missShaderBindingTableStride"
///     VkDeviceAddress hitShaderBindingTableAddress; // @link substring="hitShaderBindingTableAddress" target="#hitShaderBindingTableAddress"
///     VkDeviceSize hitShaderBindingTableSize; // @link substring="hitShaderBindingTableSize" target="#hitShaderBindingTableSize"
///     VkDeviceSize hitShaderBindingTableStride; // @link substring="hitShaderBindingTableStride" target="#hitShaderBindingTableStride"
///     VkDeviceAddress callableShaderBindingTableAddress; // @link substring="callableShaderBindingTableAddress" target="#callableShaderBindingTableAddress"
///     VkDeviceSize callableShaderBindingTableSize; // @link substring="callableShaderBindingTableSize" target="#callableShaderBindingTableSize"
///     VkDeviceSize callableShaderBindingTableStride; // @link substring="callableShaderBindingTableStride" target="#callableShaderBindingTableStride"
///     uint32_t width; // @link substring="width" target="#width"
///     uint32_t height; // @link substring="height" target="#height"
///     uint32_t depth; // @link substring="depth" target="#depth"
/// } VkTraceRaysIndirectCommand2KHR;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkTraceRaysIndirectCommand2KHR.html"><code>VkTraceRaysIndirectCommand2KHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkTraceRaysIndirectCommand2KHR(@NotNull MemorySegment segment) implements IVkTraceRaysIndirectCommand2KHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkTraceRaysIndirectCommand2KHR.html"><code>VkTraceRaysIndirectCommand2KHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkTraceRaysIndirectCommand2KHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkTraceRaysIndirectCommand2KHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkTraceRaysIndirectCommand2KHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkTraceRaysIndirectCommand2KHR, Iterable<VkTraceRaysIndirectCommand2KHR> {
        public long size() {
            return segment.byteSize() / VkTraceRaysIndirectCommand2KHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkTraceRaysIndirectCommand2KHR at(long index) {
            return new VkTraceRaysIndirectCommand2KHR(segment.asSlice(index * VkTraceRaysIndirectCommand2KHR.BYTES, VkTraceRaysIndirectCommand2KHR.BYTES));
        }

        public VkTraceRaysIndirectCommand2KHR.Ptr at(long index, @NotNull Consumer<@NotNull VkTraceRaysIndirectCommand2KHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkTraceRaysIndirectCommand2KHR value) {
            MemorySegment s = segment.asSlice(index * VkTraceRaysIndirectCommand2KHR.BYTES, VkTraceRaysIndirectCommand2KHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkTraceRaysIndirectCommand2KHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkTraceRaysIndirectCommand2KHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkTraceRaysIndirectCommand2KHR.BYTES,
                (end - start) * VkTraceRaysIndirectCommand2KHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkTraceRaysIndirectCommand2KHR.BYTES));
        }

        public VkTraceRaysIndirectCommand2KHR[] toArray() {
            VkTraceRaysIndirectCommand2KHR[] ret = new VkTraceRaysIndirectCommand2KHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkTraceRaysIndirectCommand2KHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkTraceRaysIndirectCommand2KHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkTraceRaysIndirectCommand2KHR.BYTES;
            }

            @Override
            public VkTraceRaysIndirectCommand2KHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkTraceRaysIndirectCommand2KHR ret = new VkTraceRaysIndirectCommand2KHR(segment.asSlice(0, VkTraceRaysIndirectCommand2KHR.BYTES));
                segment = segment.asSlice(VkTraceRaysIndirectCommand2KHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkTraceRaysIndirectCommand2KHR allocate(Arena arena) {
        return new VkTraceRaysIndirectCommand2KHR(arena.allocate(LAYOUT));
    }

    public static VkTraceRaysIndirectCommand2KHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkTraceRaysIndirectCommand2KHR.Ptr(segment);
    }

    public static VkTraceRaysIndirectCommand2KHR clone(Arena arena, VkTraceRaysIndirectCommand2KHR src) {
        VkTraceRaysIndirectCommand2KHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NativeType("VkDeviceAddress") @Unsigned long raygenShaderRecordAddress() {
        return segment.get(LAYOUT$raygenShaderRecordAddress, OFFSET$raygenShaderRecordAddress);
    }

    public VkTraceRaysIndirectCommand2KHR raygenShaderRecordAddress(@NativeType("VkDeviceAddress") @Unsigned long value) {
        segment.set(LAYOUT$raygenShaderRecordAddress, OFFSET$raygenShaderRecordAddress, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long raygenShaderRecordSize() {
        return segment.get(LAYOUT$raygenShaderRecordSize, OFFSET$raygenShaderRecordSize);
    }

    public VkTraceRaysIndirectCommand2KHR raygenShaderRecordSize(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$raygenShaderRecordSize, OFFSET$raygenShaderRecordSize, value);
        return this;
    }

    public @NativeType("VkDeviceAddress") @Unsigned long missShaderBindingTableAddress() {
        return segment.get(LAYOUT$missShaderBindingTableAddress, OFFSET$missShaderBindingTableAddress);
    }

    public VkTraceRaysIndirectCommand2KHR missShaderBindingTableAddress(@NativeType("VkDeviceAddress") @Unsigned long value) {
        segment.set(LAYOUT$missShaderBindingTableAddress, OFFSET$missShaderBindingTableAddress, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long missShaderBindingTableSize() {
        return segment.get(LAYOUT$missShaderBindingTableSize, OFFSET$missShaderBindingTableSize);
    }

    public VkTraceRaysIndirectCommand2KHR missShaderBindingTableSize(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$missShaderBindingTableSize, OFFSET$missShaderBindingTableSize, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long missShaderBindingTableStride() {
        return segment.get(LAYOUT$missShaderBindingTableStride, OFFSET$missShaderBindingTableStride);
    }

    public VkTraceRaysIndirectCommand2KHR missShaderBindingTableStride(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$missShaderBindingTableStride, OFFSET$missShaderBindingTableStride, value);
        return this;
    }

    public @NativeType("VkDeviceAddress") @Unsigned long hitShaderBindingTableAddress() {
        return segment.get(LAYOUT$hitShaderBindingTableAddress, OFFSET$hitShaderBindingTableAddress);
    }

    public VkTraceRaysIndirectCommand2KHR hitShaderBindingTableAddress(@NativeType("VkDeviceAddress") @Unsigned long value) {
        segment.set(LAYOUT$hitShaderBindingTableAddress, OFFSET$hitShaderBindingTableAddress, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long hitShaderBindingTableSize() {
        return segment.get(LAYOUT$hitShaderBindingTableSize, OFFSET$hitShaderBindingTableSize);
    }

    public VkTraceRaysIndirectCommand2KHR hitShaderBindingTableSize(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$hitShaderBindingTableSize, OFFSET$hitShaderBindingTableSize, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long hitShaderBindingTableStride() {
        return segment.get(LAYOUT$hitShaderBindingTableStride, OFFSET$hitShaderBindingTableStride);
    }

    public VkTraceRaysIndirectCommand2KHR hitShaderBindingTableStride(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$hitShaderBindingTableStride, OFFSET$hitShaderBindingTableStride, value);
        return this;
    }

    public @NativeType("VkDeviceAddress") @Unsigned long callableShaderBindingTableAddress() {
        return segment.get(LAYOUT$callableShaderBindingTableAddress, OFFSET$callableShaderBindingTableAddress);
    }

    public VkTraceRaysIndirectCommand2KHR callableShaderBindingTableAddress(@NativeType("VkDeviceAddress") @Unsigned long value) {
        segment.set(LAYOUT$callableShaderBindingTableAddress, OFFSET$callableShaderBindingTableAddress, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long callableShaderBindingTableSize() {
        return segment.get(LAYOUT$callableShaderBindingTableSize, OFFSET$callableShaderBindingTableSize);
    }

    public VkTraceRaysIndirectCommand2KHR callableShaderBindingTableSize(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$callableShaderBindingTableSize, OFFSET$callableShaderBindingTableSize, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long callableShaderBindingTableStride() {
        return segment.get(LAYOUT$callableShaderBindingTableStride, OFFSET$callableShaderBindingTableStride);
    }

    public VkTraceRaysIndirectCommand2KHR callableShaderBindingTableStride(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$callableShaderBindingTableStride, OFFSET$callableShaderBindingTableStride, value);
        return this;
    }

    public @Unsigned int width() {
        return segment.get(LAYOUT$width, OFFSET$width);
    }

    public VkTraceRaysIndirectCommand2KHR width(@Unsigned int value) {
        segment.set(LAYOUT$width, OFFSET$width, value);
        return this;
    }

    public @Unsigned int height() {
        return segment.get(LAYOUT$height, OFFSET$height);
    }

    public VkTraceRaysIndirectCommand2KHR height(@Unsigned int value) {
        segment.set(LAYOUT$height, OFFSET$height, value);
        return this;
    }

    public @Unsigned int depth() {
        return segment.get(LAYOUT$depth, OFFSET$depth);
    }

    public VkTraceRaysIndirectCommand2KHR depth(@Unsigned int value) {
        segment.set(LAYOUT$depth, OFFSET$depth, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_LONG.withName("raygenShaderRecordAddress"),
        ValueLayout.JAVA_LONG.withName("raygenShaderRecordSize"),
        ValueLayout.JAVA_LONG.withName("missShaderBindingTableAddress"),
        ValueLayout.JAVA_LONG.withName("missShaderBindingTableSize"),
        ValueLayout.JAVA_LONG.withName("missShaderBindingTableStride"),
        ValueLayout.JAVA_LONG.withName("hitShaderBindingTableAddress"),
        ValueLayout.JAVA_LONG.withName("hitShaderBindingTableSize"),
        ValueLayout.JAVA_LONG.withName("hitShaderBindingTableStride"),
        ValueLayout.JAVA_LONG.withName("callableShaderBindingTableAddress"),
        ValueLayout.JAVA_LONG.withName("callableShaderBindingTableSize"),
        ValueLayout.JAVA_LONG.withName("callableShaderBindingTableStride"),
        ValueLayout.JAVA_INT.withName("width"),
        ValueLayout.JAVA_INT.withName("height"),
        ValueLayout.JAVA_INT.withName("depth")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$raygenShaderRecordAddress = PathElement.groupElement("raygenShaderRecordAddress");
    public static final PathElement PATH$raygenShaderRecordSize = PathElement.groupElement("raygenShaderRecordSize");
    public static final PathElement PATH$missShaderBindingTableAddress = PathElement.groupElement("missShaderBindingTableAddress");
    public static final PathElement PATH$missShaderBindingTableSize = PathElement.groupElement("missShaderBindingTableSize");
    public static final PathElement PATH$missShaderBindingTableStride = PathElement.groupElement("missShaderBindingTableStride");
    public static final PathElement PATH$hitShaderBindingTableAddress = PathElement.groupElement("hitShaderBindingTableAddress");
    public static final PathElement PATH$hitShaderBindingTableSize = PathElement.groupElement("hitShaderBindingTableSize");
    public static final PathElement PATH$hitShaderBindingTableStride = PathElement.groupElement("hitShaderBindingTableStride");
    public static final PathElement PATH$callableShaderBindingTableAddress = PathElement.groupElement("callableShaderBindingTableAddress");
    public static final PathElement PATH$callableShaderBindingTableSize = PathElement.groupElement("callableShaderBindingTableSize");
    public static final PathElement PATH$callableShaderBindingTableStride = PathElement.groupElement("callableShaderBindingTableStride");
    public static final PathElement PATH$width = PathElement.groupElement("width");
    public static final PathElement PATH$height = PathElement.groupElement("height");
    public static final PathElement PATH$depth = PathElement.groupElement("depth");

    public static final OfLong LAYOUT$raygenShaderRecordAddress = (OfLong) LAYOUT.select(PATH$raygenShaderRecordAddress);
    public static final OfLong LAYOUT$raygenShaderRecordSize = (OfLong) LAYOUT.select(PATH$raygenShaderRecordSize);
    public static final OfLong LAYOUT$missShaderBindingTableAddress = (OfLong) LAYOUT.select(PATH$missShaderBindingTableAddress);
    public static final OfLong LAYOUT$missShaderBindingTableSize = (OfLong) LAYOUT.select(PATH$missShaderBindingTableSize);
    public static final OfLong LAYOUT$missShaderBindingTableStride = (OfLong) LAYOUT.select(PATH$missShaderBindingTableStride);
    public static final OfLong LAYOUT$hitShaderBindingTableAddress = (OfLong) LAYOUT.select(PATH$hitShaderBindingTableAddress);
    public static final OfLong LAYOUT$hitShaderBindingTableSize = (OfLong) LAYOUT.select(PATH$hitShaderBindingTableSize);
    public static final OfLong LAYOUT$hitShaderBindingTableStride = (OfLong) LAYOUT.select(PATH$hitShaderBindingTableStride);
    public static final OfLong LAYOUT$callableShaderBindingTableAddress = (OfLong) LAYOUT.select(PATH$callableShaderBindingTableAddress);
    public static final OfLong LAYOUT$callableShaderBindingTableSize = (OfLong) LAYOUT.select(PATH$callableShaderBindingTableSize);
    public static final OfLong LAYOUT$callableShaderBindingTableStride = (OfLong) LAYOUT.select(PATH$callableShaderBindingTableStride);
    public static final OfInt LAYOUT$width = (OfInt) LAYOUT.select(PATH$width);
    public static final OfInt LAYOUT$height = (OfInt) LAYOUT.select(PATH$height);
    public static final OfInt LAYOUT$depth = (OfInt) LAYOUT.select(PATH$depth);

    public static final long SIZE$raygenShaderRecordAddress = LAYOUT$raygenShaderRecordAddress.byteSize();
    public static final long SIZE$raygenShaderRecordSize = LAYOUT$raygenShaderRecordSize.byteSize();
    public static final long SIZE$missShaderBindingTableAddress = LAYOUT$missShaderBindingTableAddress.byteSize();
    public static final long SIZE$missShaderBindingTableSize = LAYOUT$missShaderBindingTableSize.byteSize();
    public static final long SIZE$missShaderBindingTableStride = LAYOUT$missShaderBindingTableStride.byteSize();
    public static final long SIZE$hitShaderBindingTableAddress = LAYOUT$hitShaderBindingTableAddress.byteSize();
    public static final long SIZE$hitShaderBindingTableSize = LAYOUT$hitShaderBindingTableSize.byteSize();
    public static final long SIZE$hitShaderBindingTableStride = LAYOUT$hitShaderBindingTableStride.byteSize();
    public static final long SIZE$callableShaderBindingTableAddress = LAYOUT$callableShaderBindingTableAddress.byteSize();
    public static final long SIZE$callableShaderBindingTableSize = LAYOUT$callableShaderBindingTableSize.byteSize();
    public static final long SIZE$callableShaderBindingTableStride = LAYOUT$callableShaderBindingTableStride.byteSize();
    public static final long SIZE$width = LAYOUT$width.byteSize();
    public static final long SIZE$height = LAYOUT$height.byteSize();
    public static final long SIZE$depth = LAYOUT$depth.byteSize();

    public static final long OFFSET$raygenShaderRecordAddress = LAYOUT.byteOffset(PATH$raygenShaderRecordAddress);
    public static final long OFFSET$raygenShaderRecordSize = LAYOUT.byteOffset(PATH$raygenShaderRecordSize);
    public static final long OFFSET$missShaderBindingTableAddress = LAYOUT.byteOffset(PATH$missShaderBindingTableAddress);
    public static final long OFFSET$missShaderBindingTableSize = LAYOUT.byteOffset(PATH$missShaderBindingTableSize);
    public static final long OFFSET$missShaderBindingTableStride = LAYOUT.byteOffset(PATH$missShaderBindingTableStride);
    public static final long OFFSET$hitShaderBindingTableAddress = LAYOUT.byteOffset(PATH$hitShaderBindingTableAddress);
    public static final long OFFSET$hitShaderBindingTableSize = LAYOUT.byteOffset(PATH$hitShaderBindingTableSize);
    public static final long OFFSET$hitShaderBindingTableStride = LAYOUT.byteOffset(PATH$hitShaderBindingTableStride);
    public static final long OFFSET$callableShaderBindingTableAddress = LAYOUT.byteOffset(PATH$callableShaderBindingTableAddress);
    public static final long OFFSET$callableShaderBindingTableSize = LAYOUT.byteOffset(PATH$callableShaderBindingTableSize);
    public static final long OFFSET$callableShaderBindingTableStride = LAYOUT.byteOffset(PATH$callableShaderBindingTableStride);
    public static final long OFFSET$width = LAYOUT.byteOffset(PATH$width);
    public static final long OFFSET$height = LAYOUT.byteOffset(PATH$height);
    public static final long OFFSET$depth = LAYOUT.byteOffset(PATH$depth);
}
