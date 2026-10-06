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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkWriteDescriptorSet.html"><code>VkWriteDescriptorSet</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkWriteDescriptorSet {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkDescriptorSet dstSet; // @link substring="VkDescriptorSet" target="VkDescriptorSet" @link substring="dstSet" target="#dstSet"
///     uint32_t dstBinding; // @link substring="dstBinding" target="#dstBinding"
///     uint32_t dstArrayElement; // @link substring="dstArrayElement" target="#dstArrayElement"
///     uint32_t descriptorCount; // @link substring="descriptorCount" target="#descriptorCount"
///     VkDescriptorType descriptorType; // @link substring="VkDescriptorType" target="VkDescriptorType" @link substring="descriptorType" target="#descriptorType"
///     VkDescriptorImageInfo const* pImageInfo; // @link substring="VkDescriptorImageInfo" target="VkDescriptorImageInfo" @link substring="pImageInfo" target="#pImageInfo"
///     VkDescriptorBufferInfo const* pBufferInfo; // @link substring="VkDescriptorBufferInfo" target="VkDescriptorBufferInfo" @link substring="pBufferInfo" target="#pBufferInfo"
///     VkBufferView const* pTexelBufferView; // @link substring="VkBufferView" target="VkBufferView" @link substring="pTexelBufferView" target="#pTexelBufferView"
/// } VkWriteDescriptorSet;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET`
///
/// The {@code allocate} ({@link VkWriteDescriptorSet#allocate(Arena)}, {@link VkWriteDescriptorSet#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkWriteDescriptorSet#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkWriteDescriptorSet.html"><code>VkWriteDescriptorSet</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkWriteDescriptorSet(@NotNull MemorySegment segment) implements IVkWriteDescriptorSet {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkWriteDescriptorSet.html"><code>VkWriteDescriptorSet</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkWriteDescriptorSet}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkWriteDescriptorSet to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkWriteDescriptorSet.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkWriteDescriptorSet, Iterable<VkWriteDescriptorSet> {
        public long size() {
            return segment.byteSize() / VkWriteDescriptorSet.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkWriteDescriptorSet at(long index) {
            return new VkWriteDescriptorSet(segment.asSlice(index * VkWriteDescriptorSet.BYTES, VkWriteDescriptorSet.BYTES));
        }

        public VkWriteDescriptorSet.Ptr at(long index, @NotNull Consumer<@NotNull VkWriteDescriptorSet> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkWriteDescriptorSet value) {
            MemorySegment s = segment.asSlice(index * VkWriteDescriptorSet.BYTES, VkWriteDescriptorSet.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkWriteDescriptorSet.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkWriteDescriptorSet.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkWriteDescriptorSet.BYTES,
                (end - start) * VkWriteDescriptorSet.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkWriteDescriptorSet.BYTES));
        }

        public VkWriteDescriptorSet[] toArray() {
            VkWriteDescriptorSet[] ret = new VkWriteDescriptorSet[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkWriteDescriptorSet> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkWriteDescriptorSet> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkWriteDescriptorSet.BYTES;
            }

            @Override
            public VkWriteDescriptorSet next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkWriteDescriptorSet ret = new VkWriteDescriptorSet(segment.asSlice(0, VkWriteDescriptorSet.BYTES));
                segment = segment.asSlice(VkWriteDescriptorSet.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkWriteDescriptorSet allocate(Arena arena) {
        VkWriteDescriptorSet ret = new VkWriteDescriptorSet(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.WRITE_DESCRIPTOR_SET);
        return ret;
    }

    public static VkWriteDescriptorSet.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkWriteDescriptorSet.Ptr ret = new VkWriteDescriptorSet.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.WRITE_DESCRIPTOR_SET);
        }
        return ret;
    }

    public static VkWriteDescriptorSet clone(Arena arena, VkWriteDescriptorSet src) {
        VkWriteDescriptorSet ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.WRITE_DESCRIPTOR_SET);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkWriteDescriptorSet sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkWriteDescriptorSet pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkWriteDescriptorSet pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Nullable VkDescriptorSet dstSet() {
        MemorySegment s = segment.asSlice(OFFSET$dstSet, SIZE$dstSet);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkDescriptorSet(s);
    }

    public VkWriteDescriptorSet dstSet(@Nullable VkDescriptorSet value) {
        segment.set(LAYOUT$dstSet, OFFSET$dstSet, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int dstBinding() {
        return segment.get(LAYOUT$dstBinding, OFFSET$dstBinding);
    }

    public VkWriteDescriptorSet dstBinding(@Unsigned int value) {
        segment.set(LAYOUT$dstBinding, OFFSET$dstBinding, value);
        return this;
    }

    public @Unsigned int dstArrayElement() {
        return segment.get(LAYOUT$dstArrayElement, OFFSET$dstArrayElement);
    }

    public VkWriteDescriptorSet dstArrayElement(@Unsigned int value) {
        segment.set(LAYOUT$dstArrayElement, OFFSET$dstArrayElement, value);
        return this;
    }

    public @Unsigned int descriptorCount() {
        return segment.get(LAYOUT$descriptorCount, OFFSET$descriptorCount);
    }

    public VkWriteDescriptorSet descriptorCount(@Unsigned int value) {
        segment.set(LAYOUT$descriptorCount, OFFSET$descriptorCount, value);
        return this;
    }

    public @EnumType(VkDescriptorType.class) int descriptorType() {
        return segment.get(LAYOUT$descriptorType, OFFSET$descriptorType);
    }

    public VkWriteDescriptorSet descriptorType(@EnumType(VkDescriptorType.class) int value) {
        segment.set(LAYOUT$descriptorType, OFFSET$descriptorType, value);
        return this;
    }

    public VkWriteDescriptorSet pImageInfo(@Nullable IVkDescriptorImageInfo value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pImageInfoRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkDescriptorImageInfo.Ptr pImageInfo(int assumedCount) {
        MemorySegment s = pImageInfoRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkDescriptorImageInfo.BYTES);
        return new VkDescriptorImageInfo.Ptr(s);
    }

    public @Nullable VkDescriptorImageInfo pImageInfo() {
        MemorySegment s = pImageInfoRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkDescriptorImageInfo(s);
    }

    public @Pointer(target=VkDescriptorImageInfo.class) @NotNull MemorySegment pImageInfoRaw() {
        return segment.get(LAYOUT$pImageInfo, OFFSET$pImageInfo);
    }

    public void pImageInfoRaw(@Pointer(target=VkDescriptorImageInfo.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pImageInfo, OFFSET$pImageInfo, value);
    }

    public VkWriteDescriptorSet pBufferInfo(@Nullable IVkDescriptorBufferInfo value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pBufferInfoRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkDescriptorBufferInfo.Ptr pBufferInfo(int assumedCount) {
        MemorySegment s = pBufferInfoRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkDescriptorBufferInfo.BYTES);
        return new VkDescriptorBufferInfo.Ptr(s);
    }

    public @Nullable VkDescriptorBufferInfo pBufferInfo() {
        MemorySegment s = pBufferInfoRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkDescriptorBufferInfo(s);
    }

    public @Pointer(target=VkDescriptorBufferInfo.class) @NotNull MemorySegment pBufferInfoRaw() {
        return segment.get(LAYOUT$pBufferInfo, OFFSET$pBufferInfo);
    }

    public void pBufferInfoRaw(@Pointer(target=VkDescriptorBufferInfo.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pBufferInfo, OFFSET$pBufferInfo, value);
    }

    /// Note: the returned {@link VkBufferView.Ptr} does not have correct {@link VkBufferView.Ptr#size}
    /// property. It's up to user to track the size of the buffer, and use
    /// {@link VkBufferView.Ptr#reinterpret} to set the size before actually reading from or writing to the
    /// buffer.
    public @Nullable VkBufferView.Ptr pTexelBufferView() {
        MemorySegment s = pTexelBufferViewRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkBufferView.Ptr(s);
    }

    public VkWriteDescriptorSet pTexelBufferView(@Nullable VkBufferView.Ptr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pTexelBufferViewRaw(s);
        return this;
    }

    public @Pointer(target=VkBufferView.class) @NotNull MemorySegment pTexelBufferViewRaw() {
        return segment.get(LAYOUT$pTexelBufferView, OFFSET$pTexelBufferView);
    }

    public void pTexelBufferViewRaw(@Pointer(target=VkBufferView.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pTexelBufferView, OFFSET$pTexelBufferView, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withName("dstSet"),
        ValueLayout.JAVA_INT.withName("dstBinding"),
        ValueLayout.JAVA_INT.withName("dstArrayElement"),
        ValueLayout.JAVA_INT.withName("descriptorCount"),
        ValueLayout.JAVA_INT.withName("descriptorType"),
        ValueLayout.ADDRESS.withTargetLayout(VkDescriptorImageInfo.LAYOUT).withName("pImageInfo"),
        ValueLayout.ADDRESS.withTargetLayout(VkDescriptorBufferInfo.LAYOUT).withName("pBufferInfo"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS).withName("pTexelBufferView")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$dstSet = PathElement.groupElement("dstSet");
    public static final PathElement PATH$dstBinding = PathElement.groupElement("dstBinding");
    public static final PathElement PATH$dstArrayElement = PathElement.groupElement("dstArrayElement");
    public static final PathElement PATH$descriptorCount = PathElement.groupElement("descriptorCount");
    public static final PathElement PATH$descriptorType = PathElement.groupElement("descriptorType");
    public static final PathElement PATH$pImageInfo = PathElement.groupElement("pImageInfo");
    public static final PathElement PATH$pBufferInfo = PathElement.groupElement("pBufferInfo");
    public static final PathElement PATH$pTexelBufferView = PathElement.groupElement("pTexelBufferView");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$dstSet = (AddressLayout) LAYOUT.select(PATH$dstSet);
    public static final OfInt LAYOUT$dstBinding = (OfInt) LAYOUT.select(PATH$dstBinding);
    public static final OfInt LAYOUT$dstArrayElement = (OfInt) LAYOUT.select(PATH$dstArrayElement);
    public static final OfInt LAYOUT$descriptorCount = (OfInt) LAYOUT.select(PATH$descriptorCount);
    public static final OfInt LAYOUT$descriptorType = (OfInt) LAYOUT.select(PATH$descriptorType);
    public static final AddressLayout LAYOUT$pImageInfo = (AddressLayout) LAYOUT.select(PATH$pImageInfo);
    public static final AddressLayout LAYOUT$pBufferInfo = (AddressLayout) LAYOUT.select(PATH$pBufferInfo);
    public static final AddressLayout LAYOUT$pTexelBufferView = (AddressLayout) LAYOUT.select(PATH$pTexelBufferView);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$dstSet = LAYOUT$dstSet.byteSize();
    public static final long SIZE$dstBinding = LAYOUT$dstBinding.byteSize();
    public static final long SIZE$dstArrayElement = LAYOUT$dstArrayElement.byteSize();
    public static final long SIZE$descriptorCount = LAYOUT$descriptorCount.byteSize();
    public static final long SIZE$descriptorType = LAYOUT$descriptorType.byteSize();
    public static final long SIZE$pImageInfo = LAYOUT$pImageInfo.byteSize();
    public static final long SIZE$pBufferInfo = LAYOUT$pBufferInfo.byteSize();
    public static final long SIZE$pTexelBufferView = LAYOUT$pTexelBufferView.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$dstSet = LAYOUT.byteOffset(PATH$dstSet);
    public static final long OFFSET$dstBinding = LAYOUT.byteOffset(PATH$dstBinding);
    public static final long OFFSET$dstArrayElement = LAYOUT.byteOffset(PATH$dstArrayElement);
    public static final long OFFSET$descriptorCount = LAYOUT.byteOffset(PATH$descriptorCount);
    public static final long OFFSET$descriptorType = LAYOUT.byteOffset(PATH$descriptorType);
    public static final long OFFSET$pImageInfo = LAYOUT.byteOffset(PATH$pImageInfo);
    public static final long OFFSET$pBufferInfo = LAYOUT.byteOffset(PATH$pBufferInfo);
    public static final long OFFSET$pTexelBufferView = LAYOUT.byteOffset(PATH$pTexelBufferView);
}
