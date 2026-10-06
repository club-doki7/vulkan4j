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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDescriptorMappingSourceDataEXT.html"><code>VkDescriptorMappingSourceDataEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef union VkDescriptorMappingSourceDataEXT {
///     VkDescriptorMappingSourceConstantOffsetEXT constantOffset; // @link substring="VkDescriptorMappingSourceConstantOffsetEXT" target="VkDescriptorMappingSourceConstantOffsetEXT" @link substring="constantOffset" target="#constantOffset"
///     VkDescriptorMappingSourcePushIndexEXT pushIndex; // @link substring="VkDescriptorMappingSourcePushIndexEXT" target="VkDescriptorMappingSourcePushIndexEXT" @link substring="pushIndex" target="#pushIndex"
///     VkDescriptorMappingSourceIndirectIndexEXT indirectIndex; // @link substring="VkDescriptorMappingSourceIndirectIndexEXT" target="VkDescriptorMappingSourceIndirectIndexEXT" @link substring="indirectIndex" target="#indirectIndex"
///     VkDescriptorMappingSourceIndirectIndexArrayEXT indirectIndexArray; // @link substring="VkDescriptorMappingSourceIndirectIndexArrayEXT" target="VkDescriptorMappingSourceIndirectIndexArrayEXT" @link substring="indirectIndexArray" target="#indirectIndexArray"
///     VkDescriptorMappingSourceHeapDataEXT heapData; // @link substring="VkDescriptorMappingSourceHeapDataEXT" target="VkDescriptorMappingSourceHeapDataEXT" @link substring="heapData" target="#heapData"
///     uint32_t pushDataOffset; // @link substring="pushDataOffset" target="#pushDataOffset"
///     uint32_t pushAddressOffset; // @link substring="pushAddressOffset" target="#pushAddressOffset"
///     VkDescriptorMappingSourceIndirectAddressEXT indirectAddress; // @link substring="VkDescriptorMappingSourceIndirectAddressEXT" target="VkDescriptorMappingSourceIndirectAddressEXT" @link substring="indirectAddress" target="#indirectAddress"
///     VkDescriptorMappingSourceShaderRecordIndexEXT shaderRecordIndex; // @link substring="VkDescriptorMappingSourceShaderRecordIndexEXT" target="VkDescriptorMappingSourceShaderRecordIndexEXT" @link substring="shaderRecordIndex" target="#shaderRecordIndex"
///     uint32_t shaderRecordDataOffset; // @link substring="shaderRecordDataOffset" target="#shaderRecordDataOffset"
///     uint32_t shaderRecordAddressOffset; // @link substring="shaderRecordAddressOffset" target="#shaderRecordAddressOffset"
/// } VkDescriptorMappingSourceDataEXT;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDescriptorMappingSourceDataEXT.html"><code>VkDescriptorMappingSourceDataEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDescriptorMappingSourceDataEXT(@NotNull MemorySegment segment) implements IVkDescriptorMappingSourceDataEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDescriptorMappingSourceDataEXT.html"><code>VkDescriptorMappingSourceDataEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDescriptorMappingSourceDataEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDescriptorMappingSourceDataEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDescriptorMappingSourceDataEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDescriptorMappingSourceDataEXT, Iterable<VkDescriptorMappingSourceDataEXT> {
        public long size() {
            return segment.byteSize() / VkDescriptorMappingSourceDataEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDescriptorMappingSourceDataEXT at(long index) {
            return new VkDescriptorMappingSourceDataEXT(segment.asSlice(index * VkDescriptorMappingSourceDataEXT.BYTES, VkDescriptorMappingSourceDataEXT.BYTES));
        }

        public VkDescriptorMappingSourceDataEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkDescriptorMappingSourceDataEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDescriptorMappingSourceDataEXT value) {
            MemorySegment s = segment.asSlice(index * VkDescriptorMappingSourceDataEXT.BYTES, VkDescriptorMappingSourceDataEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDescriptorMappingSourceDataEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDescriptorMappingSourceDataEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDescriptorMappingSourceDataEXT.BYTES,
                (end - start) * VkDescriptorMappingSourceDataEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDescriptorMappingSourceDataEXT.BYTES));
        }

        public VkDescriptorMappingSourceDataEXT[] toArray() {
            VkDescriptorMappingSourceDataEXT[] ret = new VkDescriptorMappingSourceDataEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDescriptorMappingSourceDataEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDescriptorMappingSourceDataEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDescriptorMappingSourceDataEXT.BYTES;
            }

            @Override
            public VkDescriptorMappingSourceDataEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDescriptorMappingSourceDataEXT ret = new VkDescriptorMappingSourceDataEXT(segment.asSlice(0, VkDescriptorMappingSourceDataEXT.BYTES));
                segment = segment.asSlice(VkDescriptorMappingSourceDataEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDescriptorMappingSourceDataEXT allocate(Arena arena) {
        return new VkDescriptorMappingSourceDataEXT(arena.allocate(LAYOUT));
    }

    public static VkDescriptorMappingSourceDataEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkDescriptorMappingSourceDataEXT.Ptr(segment);
    }

    public static VkDescriptorMappingSourceDataEXT clone(Arena arena, VkDescriptorMappingSourceDataEXT src) {
        VkDescriptorMappingSourceDataEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull VkDescriptorMappingSourceConstantOffsetEXT constantOffset() {
        return new VkDescriptorMappingSourceConstantOffsetEXT(segment.asSlice(OFFSET$constantOffset, LAYOUT$constantOffset));
    }

    public VkDescriptorMappingSourceDataEXT constantOffset(@NotNull VkDescriptorMappingSourceConstantOffsetEXT value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$constantOffset, SIZE$constantOffset);
        return this;
    }

    public VkDescriptorMappingSourceDataEXT constantOffset(Consumer<@NotNull VkDescriptorMappingSourceConstantOffsetEXT> consumer) {
        consumer.accept(constantOffset());
        return this;
    }

    public @NotNull VkDescriptorMappingSourcePushIndexEXT pushIndex() {
        return new VkDescriptorMappingSourcePushIndexEXT(segment.asSlice(OFFSET$pushIndex, LAYOUT$pushIndex));
    }

    public VkDescriptorMappingSourceDataEXT pushIndex(@NotNull VkDescriptorMappingSourcePushIndexEXT value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$pushIndex, SIZE$pushIndex);
        return this;
    }

    public VkDescriptorMappingSourceDataEXT pushIndex(Consumer<@NotNull VkDescriptorMappingSourcePushIndexEXT> consumer) {
        consumer.accept(pushIndex());
        return this;
    }

    public @NotNull VkDescriptorMappingSourceIndirectIndexEXT indirectIndex() {
        return new VkDescriptorMappingSourceIndirectIndexEXT(segment.asSlice(OFFSET$indirectIndex, LAYOUT$indirectIndex));
    }

    public VkDescriptorMappingSourceDataEXT indirectIndex(@NotNull VkDescriptorMappingSourceIndirectIndexEXT value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$indirectIndex, SIZE$indirectIndex);
        return this;
    }

    public VkDescriptorMappingSourceDataEXT indirectIndex(Consumer<@NotNull VkDescriptorMappingSourceIndirectIndexEXT> consumer) {
        consumer.accept(indirectIndex());
        return this;
    }

    public @NotNull VkDescriptorMappingSourceIndirectIndexArrayEXT indirectIndexArray() {
        return new VkDescriptorMappingSourceIndirectIndexArrayEXT(segment.asSlice(OFFSET$indirectIndexArray, LAYOUT$indirectIndexArray));
    }

    public VkDescriptorMappingSourceDataEXT indirectIndexArray(@NotNull VkDescriptorMappingSourceIndirectIndexArrayEXT value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$indirectIndexArray, SIZE$indirectIndexArray);
        return this;
    }

    public VkDescriptorMappingSourceDataEXT indirectIndexArray(Consumer<@NotNull VkDescriptorMappingSourceIndirectIndexArrayEXT> consumer) {
        consumer.accept(indirectIndexArray());
        return this;
    }

    public @NotNull VkDescriptorMappingSourceHeapDataEXT heapData() {
        return new VkDescriptorMappingSourceHeapDataEXT(segment.asSlice(OFFSET$heapData, LAYOUT$heapData));
    }

    public VkDescriptorMappingSourceDataEXT heapData(@NotNull VkDescriptorMappingSourceHeapDataEXT value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$heapData, SIZE$heapData);
        return this;
    }

    public VkDescriptorMappingSourceDataEXT heapData(Consumer<@NotNull VkDescriptorMappingSourceHeapDataEXT> consumer) {
        consumer.accept(heapData());
        return this;
    }

    public @Unsigned int pushDataOffset() {
        return segment.get(LAYOUT$pushDataOffset, OFFSET$pushDataOffset);
    }

    public VkDescriptorMappingSourceDataEXT pushDataOffset(@Unsigned int value) {
        segment.set(LAYOUT$pushDataOffset, OFFSET$pushDataOffset, value);
        return this;
    }

    public @Unsigned int pushAddressOffset() {
        return segment.get(LAYOUT$pushAddressOffset, OFFSET$pushAddressOffset);
    }

    public VkDescriptorMappingSourceDataEXT pushAddressOffset(@Unsigned int value) {
        segment.set(LAYOUT$pushAddressOffset, OFFSET$pushAddressOffset, value);
        return this;
    }

    public @NotNull VkDescriptorMappingSourceIndirectAddressEXT indirectAddress() {
        return new VkDescriptorMappingSourceIndirectAddressEXT(segment.asSlice(OFFSET$indirectAddress, LAYOUT$indirectAddress));
    }

    public VkDescriptorMappingSourceDataEXT indirectAddress(@NotNull VkDescriptorMappingSourceIndirectAddressEXT value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$indirectAddress, SIZE$indirectAddress);
        return this;
    }

    public VkDescriptorMappingSourceDataEXT indirectAddress(Consumer<@NotNull VkDescriptorMappingSourceIndirectAddressEXT> consumer) {
        consumer.accept(indirectAddress());
        return this;
    }

    public @NotNull VkDescriptorMappingSourceShaderRecordIndexEXT shaderRecordIndex() {
        return new VkDescriptorMappingSourceShaderRecordIndexEXT(segment.asSlice(OFFSET$shaderRecordIndex, LAYOUT$shaderRecordIndex));
    }

    public VkDescriptorMappingSourceDataEXT shaderRecordIndex(@NotNull VkDescriptorMappingSourceShaderRecordIndexEXT value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$shaderRecordIndex, SIZE$shaderRecordIndex);
        return this;
    }

    public VkDescriptorMappingSourceDataEXT shaderRecordIndex(Consumer<@NotNull VkDescriptorMappingSourceShaderRecordIndexEXT> consumer) {
        consumer.accept(shaderRecordIndex());
        return this;
    }

    public @Unsigned int shaderRecordDataOffset() {
        return segment.get(LAYOUT$shaderRecordDataOffset, OFFSET$shaderRecordDataOffset);
    }

    public VkDescriptorMappingSourceDataEXT shaderRecordDataOffset(@Unsigned int value) {
        segment.set(LAYOUT$shaderRecordDataOffset, OFFSET$shaderRecordDataOffset, value);
        return this;
    }

    public @Unsigned int shaderRecordAddressOffset() {
        return segment.get(LAYOUT$shaderRecordAddressOffset, OFFSET$shaderRecordAddressOffset);
    }

    public VkDescriptorMappingSourceDataEXT shaderRecordAddressOffset(@Unsigned int value) {
        segment.set(LAYOUT$shaderRecordAddressOffset, OFFSET$shaderRecordAddressOffset, value);
        return this;
    }

    public static final UnionLayout LAYOUT = NativeLayout.unionLayout(
        VkDescriptorMappingSourceConstantOffsetEXT.LAYOUT.withName("constantOffset"),
        VkDescriptorMappingSourcePushIndexEXT.LAYOUT.withName("pushIndex"),
        VkDescriptorMappingSourceIndirectIndexEXT.LAYOUT.withName("indirectIndex"),
        VkDescriptorMappingSourceIndirectIndexArrayEXT.LAYOUT.withName("indirectIndexArray"),
        VkDescriptorMappingSourceHeapDataEXT.LAYOUT.withName("heapData"),
        ValueLayout.JAVA_INT.withName("pushDataOffset"),
        ValueLayout.JAVA_INT.withName("pushAddressOffset"),
        VkDescriptorMappingSourceIndirectAddressEXT.LAYOUT.withName("indirectAddress"),
        VkDescriptorMappingSourceShaderRecordIndexEXT.LAYOUT.withName("shaderRecordIndex"),
        ValueLayout.JAVA_INT.withName("shaderRecordDataOffset"),
        ValueLayout.JAVA_INT.withName("shaderRecordAddressOffset")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$constantOffset = PathElement.groupElement("constantOffset");
    public static final PathElement PATH$pushIndex = PathElement.groupElement("pushIndex");
    public static final PathElement PATH$indirectIndex = PathElement.groupElement("indirectIndex");
    public static final PathElement PATH$indirectIndexArray = PathElement.groupElement("indirectIndexArray");
    public static final PathElement PATH$heapData = PathElement.groupElement("heapData");
    public static final PathElement PATH$pushDataOffset = PathElement.groupElement("pushDataOffset");
    public static final PathElement PATH$pushAddressOffset = PathElement.groupElement("pushAddressOffset");
    public static final PathElement PATH$indirectAddress = PathElement.groupElement("indirectAddress");
    public static final PathElement PATH$shaderRecordIndex = PathElement.groupElement("shaderRecordIndex");
    public static final PathElement PATH$shaderRecordDataOffset = PathElement.groupElement("shaderRecordDataOffset");
    public static final PathElement PATH$shaderRecordAddressOffset = PathElement.groupElement("shaderRecordAddressOffset");

    public static final StructLayout LAYOUT$constantOffset = (StructLayout) LAYOUT.select(PATH$constantOffset);
    public static final StructLayout LAYOUT$pushIndex = (StructLayout) LAYOUT.select(PATH$pushIndex);
    public static final StructLayout LAYOUT$indirectIndex = (StructLayout) LAYOUT.select(PATH$indirectIndex);
    public static final StructLayout LAYOUT$indirectIndexArray = (StructLayout) LAYOUT.select(PATH$indirectIndexArray);
    public static final StructLayout LAYOUT$heapData = (StructLayout) LAYOUT.select(PATH$heapData);
    public static final OfInt LAYOUT$pushDataOffset = (OfInt) LAYOUT.select(PATH$pushDataOffset);
    public static final OfInt LAYOUT$pushAddressOffset = (OfInt) LAYOUT.select(PATH$pushAddressOffset);
    public static final StructLayout LAYOUT$indirectAddress = (StructLayout) LAYOUT.select(PATH$indirectAddress);
    public static final StructLayout LAYOUT$shaderRecordIndex = (StructLayout) LAYOUT.select(PATH$shaderRecordIndex);
    public static final OfInt LAYOUT$shaderRecordDataOffset = (OfInt) LAYOUT.select(PATH$shaderRecordDataOffset);
    public static final OfInt LAYOUT$shaderRecordAddressOffset = (OfInt) LAYOUT.select(PATH$shaderRecordAddressOffset);

    public static final long SIZE$constantOffset = LAYOUT$constantOffset.byteSize();
    public static final long SIZE$pushIndex = LAYOUT$pushIndex.byteSize();
    public static final long SIZE$indirectIndex = LAYOUT$indirectIndex.byteSize();
    public static final long SIZE$indirectIndexArray = LAYOUT$indirectIndexArray.byteSize();
    public static final long SIZE$heapData = LAYOUT$heapData.byteSize();
    public static final long SIZE$pushDataOffset = LAYOUT$pushDataOffset.byteSize();
    public static final long SIZE$pushAddressOffset = LAYOUT$pushAddressOffset.byteSize();
    public static final long SIZE$indirectAddress = LAYOUT$indirectAddress.byteSize();
    public static final long SIZE$shaderRecordIndex = LAYOUT$shaderRecordIndex.byteSize();
    public static final long SIZE$shaderRecordDataOffset = LAYOUT$shaderRecordDataOffset.byteSize();
    public static final long SIZE$shaderRecordAddressOffset = LAYOUT$shaderRecordAddressOffset.byteSize();

    public static final long OFFSET$constantOffset = LAYOUT.byteOffset(PATH$constantOffset);
    public static final long OFFSET$pushIndex = LAYOUT.byteOffset(PATH$pushIndex);
    public static final long OFFSET$indirectIndex = LAYOUT.byteOffset(PATH$indirectIndex);
    public static final long OFFSET$indirectIndexArray = LAYOUT.byteOffset(PATH$indirectIndexArray);
    public static final long OFFSET$heapData = LAYOUT.byteOffset(PATH$heapData);
    public static final long OFFSET$pushDataOffset = LAYOUT.byteOffset(PATH$pushDataOffset);
    public static final long OFFSET$pushAddressOffset = LAYOUT.byteOffset(PATH$pushAddressOffset);
    public static final long OFFSET$indirectAddress = LAYOUT.byteOffset(PATH$indirectAddress);
    public static final long OFFSET$shaderRecordIndex = LAYOUT.byteOffset(PATH$shaderRecordIndex);
    public static final long OFFSET$shaderRecordDataOffset = LAYOUT.byteOffset(PATH$shaderRecordDataOffset);
    public static final long OFFSET$shaderRecordAddressOffset = LAYOUT.byteOffset(PATH$shaderRecordAddressOffset);
}
