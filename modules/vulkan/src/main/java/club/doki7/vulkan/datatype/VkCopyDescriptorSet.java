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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCopyDescriptorSet.html"><code>VkCopyDescriptorSet</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkCopyDescriptorSet {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkDescriptorSet srcSet; // @link substring="VkDescriptorSet" target="VkDescriptorSet" @link substring="srcSet" target="#srcSet"
///     uint32_t srcBinding; // @link substring="srcBinding" target="#srcBinding"
///     uint32_t srcArrayElement; // @link substring="srcArrayElement" target="#srcArrayElement"
///     VkDescriptorSet dstSet; // @link substring="VkDescriptorSet" target="VkDescriptorSet" @link substring="dstSet" target="#dstSet"
///     uint32_t dstBinding; // @link substring="dstBinding" target="#dstBinding"
///     uint32_t dstArrayElement; // @link substring="dstArrayElement" target="#dstArrayElement"
///     uint32_t descriptorCount; // @link substring="descriptorCount" target="#descriptorCount"
/// } VkCopyDescriptorSet;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_COPY_DESCRIPTOR_SET`
///
/// The {@code allocate} ({@link VkCopyDescriptorSet#allocate(Arena)}, {@link VkCopyDescriptorSet#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkCopyDescriptorSet#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCopyDescriptorSet.html"><code>VkCopyDescriptorSet</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkCopyDescriptorSet(@NotNull MemorySegment segment) implements IVkCopyDescriptorSet {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCopyDescriptorSet.html"><code>VkCopyDescriptorSet</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkCopyDescriptorSet}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkCopyDescriptorSet to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkCopyDescriptorSet.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkCopyDescriptorSet, Iterable<VkCopyDescriptorSet> {
        public long size() {
            return segment.byteSize() / VkCopyDescriptorSet.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkCopyDescriptorSet at(long index) {
            return new VkCopyDescriptorSet(segment.asSlice(index * VkCopyDescriptorSet.BYTES, VkCopyDescriptorSet.BYTES));
        }

        public VkCopyDescriptorSet.Ptr at(long index, @NotNull Consumer<@NotNull VkCopyDescriptorSet> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkCopyDescriptorSet value) {
            MemorySegment s = segment.asSlice(index * VkCopyDescriptorSet.BYTES, VkCopyDescriptorSet.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkCopyDescriptorSet.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkCopyDescriptorSet.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkCopyDescriptorSet.BYTES,
                (end - start) * VkCopyDescriptorSet.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkCopyDescriptorSet.BYTES));
        }

        public VkCopyDescriptorSet[] toArray() {
            VkCopyDescriptorSet[] ret = new VkCopyDescriptorSet[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkCopyDescriptorSet> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkCopyDescriptorSet> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkCopyDescriptorSet.BYTES;
            }

            @Override
            public VkCopyDescriptorSet next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkCopyDescriptorSet ret = new VkCopyDescriptorSet(segment.asSlice(0, VkCopyDescriptorSet.BYTES));
                segment = segment.asSlice(VkCopyDescriptorSet.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkCopyDescriptorSet allocate(Arena arena) {
        VkCopyDescriptorSet ret = new VkCopyDescriptorSet(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.COPY_DESCRIPTOR_SET);
        return ret;
    }

    public static VkCopyDescriptorSet.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkCopyDescriptorSet.Ptr ret = new VkCopyDescriptorSet.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.COPY_DESCRIPTOR_SET);
        }
        return ret;
    }

    public static VkCopyDescriptorSet clone(Arena arena, VkCopyDescriptorSet src) {
        VkCopyDescriptorSet ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.COPY_DESCRIPTOR_SET);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkCopyDescriptorSet sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkCopyDescriptorSet pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkCopyDescriptorSet pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Nullable VkDescriptorSet srcSet() {
        MemorySegment s = segment.asSlice(OFFSET$srcSet, SIZE$srcSet);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkDescriptorSet(s);
    }

    public VkCopyDescriptorSet srcSet(@Nullable VkDescriptorSet value) {
        segment.set(LAYOUT$srcSet, OFFSET$srcSet, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int srcBinding() {
        return segment.get(LAYOUT$srcBinding, OFFSET$srcBinding);
    }

    public VkCopyDescriptorSet srcBinding(@Unsigned int value) {
        segment.set(LAYOUT$srcBinding, OFFSET$srcBinding, value);
        return this;
    }

    public @Unsigned int srcArrayElement() {
        return segment.get(LAYOUT$srcArrayElement, OFFSET$srcArrayElement);
    }

    public VkCopyDescriptorSet srcArrayElement(@Unsigned int value) {
        segment.set(LAYOUT$srcArrayElement, OFFSET$srcArrayElement, value);
        return this;
    }

    public @Nullable VkDescriptorSet dstSet() {
        MemorySegment s = segment.asSlice(OFFSET$dstSet, SIZE$dstSet);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkDescriptorSet(s);
    }

    public VkCopyDescriptorSet dstSet(@Nullable VkDescriptorSet value) {
        segment.set(LAYOUT$dstSet, OFFSET$dstSet, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int dstBinding() {
        return segment.get(LAYOUT$dstBinding, OFFSET$dstBinding);
    }

    public VkCopyDescriptorSet dstBinding(@Unsigned int value) {
        segment.set(LAYOUT$dstBinding, OFFSET$dstBinding, value);
        return this;
    }

    public @Unsigned int dstArrayElement() {
        return segment.get(LAYOUT$dstArrayElement, OFFSET$dstArrayElement);
    }

    public VkCopyDescriptorSet dstArrayElement(@Unsigned int value) {
        segment.set(LAYOUT$dstArrayElement, OFFSET$dstArrayElement, value);
        return this;
    }

    public @Unsigned int descriptorCount() {
        return segment.get(LAYOUT$descriptorCount, OFFSET$descriptorCount);
    }

    public VkCopyDescriptorSet descriptorCount(@Unsigned int value) {
        segment.set(LAYOUT$descriptorCount, OFFSET$descriptorCount, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withName("srcSet"),
        ValueLayout.JAVA_INT.withName("srcBinding"),
        ValueLayout.JAVA_INT.withName("srcArrayElement"),
        ValueLayout.ADDRESS.withName("dstSet"),
        ValueLayout.JAVA_INT.withName("dstBinding"),
        ValueLayout.JAVA_INT.withName("dstArrayElement"),
        ValueLayout.JAVA_INT.withName("descriptorCount")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$srcSet = PathElement.groupElement("srcSet");
    public static final PathElement PATH$srcBinding = PathElement.groupElement("srcBinding");
    public static final PathElement PATH$srcArrayElement = PathElement.groupElement("srcArrayElement");
    public static final PathElement PATH$dstSet = PathElement.groupElement("dstSet");
    public static final PathElement PATH$dstBinding = PathElement.groupElement("dstBinding");
    public static final PathElement PATH$dstArrayElement = PathElement.groupElement("dstArrayElement");
    public static final PathElement PATH$descriptorCount = PathElement.groupElement("descriptorCount");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$srcSet = (AddressLayout) LAYOUT.select(PATH$srcSet);
    public static final OfInt LAYOUT$srcBinding = (OfInt) LAYOUT.select(PATH$srcBinding);
    public static final OfInt LAYOUT$srcArrayElement = (OfInt) LAYOUT.select(PATH$srcArrayElement);
    public static final AddressLayout LAYOUT$dstSet = (AddressLayout) LAYOUT.select(PATH$dstSet);
    public static final OfInt LAYOUT$dstBinding = (OfInt) LAYOUT.select(PATH$dstBinding);
    public static final OfInt LAYOUT$dstArrayElement = (OfInt) LAYOUT.select(PATH$dstArrayElement);
    public static final OfInt LAYOUT$descriptorCount = (OfInt) LAYOUT.select(PATH$descriptorCount);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$srcSet = LAYOUT$srcSet.byteSize();
    public static final long SIZE$srcBinding = LAYOUT$srcBinding.byteSize();
    public static final long SIZE$srcArrayElement = LAYOUT$srcArrayElement.byteSize();
    public static final long SIZE$dstSet = LAYOUT$dstSet.byteSize();
    public static final long SIZE$dstBinding = LAYOUT$dstBinding.byteSize();
    public static final long SIZE$dstArrayElement = LAYOUT$dstArrayElement.byteSize();
    public static final long SIZE$descriptorCount = LAYOUT$descriptorCount.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$srcSet = LAYOUT.byteOffset(PATH$srcSet);
    public static final long OFFSET$srcBinding = LAYOUT.byteOffset(PATH$srcBinding);
    public static final long OFFSET$srcArrayElement = LAYOUT.byteOffset(PATH$srcArrayElement);
    public static final long OFFSET$dstSet = LAYOUT.byteOffset(PATH$dstSet);
    public static final long OFFSET$dstBinding = LAYOUT.byteOffset(PATH$dstBinding);
    public static final long OFFSET$dstArrayElement = LAYOUT.byteOffset(PATH$dstArrayElement);
    public static final long OFFSET$descriptorCount = LAYOUT.byteOffset(PATH$descriptorCount);
}
