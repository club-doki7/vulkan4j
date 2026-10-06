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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkWriteDescriptorSetAccelerationStructureNV.html"><code>VkWriteDescriptorSetAccelerationStructureNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkWriteDescriptorSetAccelerationStructureNV {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t accelerationStructureCount; // @link substring="accelerationStructureCount" target="#accelerationStructureCount"
///     VkAccelerationStructureNV const* pAccelerationStructures; // @link substring="VkAccelerationStructureNV" target="VkAccelerationStructureNV" @link substring="pAccelerationStructures" target="#pAccelerationStructures"
/// } VkWriteDescriptorSetAccelerationStructureNV;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET_ACCELERATION_STRUCTURE_NV`
///
/// The {@code allocate} ({@link VkWriteDescriptorSetAccelerationStructureNV#allocate(Arena)}, {@link VkWriteDescriptorSetAccelerationStructureNV#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkWriteDescriptorSetAccelerationStructureNV#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkWriteDescriptorSetAccelerationStructureNV.html"><code>VkWriteDescriptorSetAccelerationStructureNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkWriteDescriptorSetAccelerationStructureNV(@NotNull MemorySegment segment) implements IVkWriteDescriptorSetAccelerationStructureNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkWriteDescriptorSetAccelerationStructureNV.html"><code>VkWriteDescriptorSetAccelerationStructureNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkWriteDescriptorSetAccelerationStructureNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkWriteDescriptorSetAccelerationStructureNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkWriteDescriptorSetAccelerationStructureNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkWriteDescriptorSetAccelerationStructureNV, Iterable<VkWriteDescriptorSetAccelerationStructureNV> {
        public long size() {
            return segment.byteSize() / VkWriteDescriptorSetAccelerationStructureNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkWriteDescriptorSetAccelerationStructureNV at(long index) {
            return new VkWriteDescriptorSetAccelerationStructureNV(segment.asSlice(index * VkWriteDescriptorSetAccelerationStructureNV.BYTES, VkWriteDescriptorSetAccelerationStructureNV.BYTES));
        }

        public VkWriteDescriptorSetAccelerationStructureNV.Ptr at(long index, @NotNull Consumer<@NotNull VkWriteDescriptorSetAccelerationStructureNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkWriteDescriptorSetAccelerationStructureNV value) {
            MemorySegment s = segment.asSlice(index * VkWriteDescriptorSetAccelerationStructureNV.BYTES, VkWriteDescriptorSetAccelerationStructureNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkWriteDescriptorSetAccelerationStructureNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkWriteDescriptorSetAccelerationStructureNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkWriteDescriptorSetAccelerationStructureNV.BYTES,
                (end - start) * VkWriteDescriptorSetAccelerationStructureNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkWriteDescriptorSetAccelerationStructureNV.BYTES));
        }

        public VkWriteDescriptorSetAccelerationStructureNV[] toArray() {
            VkWriteDescriptorSetAccelerationStructureNV[] ret = new VkWriteDescriptorSetAccelerationStructureNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkWriteDescriptorSetAccelerationStructureNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkWriteDescriptorSetAccelerationStructureNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkWriteDescriptorSetAccelerationStructureNV.BYTES;
            }

            @Override
            public VkWriteDescriptorSetAccelerationStructureNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkWriteDescriptorSetAccelerationStructureNV ret = new VkWriteDescriptorSetAccelerationStructureNV(segment.asSlice(0, VkWriteDescriptorSetAccelerationStructureNV.BYTES));
                segment = segment.asSlice(VkWriteDescriptorSetAccelerationStructureNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkWriteDescriptorSetAccelerationStructureNV allocate(Arena arena) {
        VkWriteDescriptorSetAccelerationStructureNV ret = new VkWriteDescriptorSetAccelerationStructureNV(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.WRITE_DESCRIPTOR_SET_ACCELERATION_STRUCTURE_NV);
        return ret;
    }

    public static VkWriteDescriptorSetAccelerationStructureNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkWriteDescriptorSetAccelerationStructureNV.Ptr ret = new VkWriteDescriptorSetAccelerationStructureNV.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.WRITE_DESCRIPTOR_SET_ACCELERATION_STRUCTURE_NV);
        }
        return ret;
    }

    public static VkWriteDescriptorSetAccelerationStructureNV clone(Arena arena, VkWriteDescriptorSetAccelerationStructureNV src) {
        VkWriteDescriptorSetAccelerationStructureNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.WRITE_DESCRIPTOR_SET_ACCELERATION_STRUCTURE_NV);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkWriteDescriptorSetAccelerationStructureNV sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkWriteDescriptorSetAccelerationStructureNV pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkWriteDescriptorSetAccelerationStructureNV pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int accelerationStructureCount() {
        return segment.get(LAYOUT$accelerationStructureCount, OFFSET$accelerationStructureCount);
    }

    public VkWriteDescriptorSetAccelerationStructureNV accelerationStructureCount(@Unsigned int value) {
        segment.set(LAYOUT$accelerationStructureCount, OFFSET$accelerationStructureCount, value);
        return this;
    }

    /// Note: the returned {@link VkAccelerationStructureNV.Ptr} does not have correct {@link VkAccelerationStructureNV.Ptr#size}
    /// property. It's up to user to track the size of the buffer, and use
    /// {@link VkAccelerationStructureNV.Ptr#reinterpret} to set the size before actually reading from or writing to the
    /// buffer.
    public @Nullable VkAccelerationStructureNV.Ptr pAccelerationStructures() {
        MemorySegment s = pAccelerationStructuresRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkAccelerationStructureNV.Ptr(s);
    }

    public VkWriteDescriptorSetAccelerationStructureNV pAccelerationStructures(@Nullable VkAccelerationStructureNV.Ptr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pAccelerationStructuresRaw(s);
        return this;
    }

    public @Pointer(target=VkAccelerationStructureNV.class) @NotNull MemorySegment pAccelerationStructuresRaw() {
        return segment.get(LAYOUT$pAccelerationStructures, OFFSET$pAccelerationStructures);
    }

    public void pAccelerationStructuresRaw(@Pointer(target=VkAccelerationStructureNV.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pAccelerationStructures, OFFSET$pAccelerationStructures, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("accelerationStructureCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS).withName("pAccelerationStructures")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$accelerationStructureCount = PathElement.groupElement("accelerationStructureCount");
    public static final PathElement PATH$pAccelerationStructures = PathElement.groupElement("pAccelerationStructures");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$accelerationStructureCount = (OfInt) LAYOUT.select(PATH$accelerationStructureCount);
    public static final AddressLayout LAYOUT$pAccelerationStructures = (AddressLayout) LAYOUT.select(PATH$pAccelerationStructures);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$accelerationStructureCount = LAYOUT$accelerationStructureCount.byteSize();
    public static final long SIZE$pAccelerationStructures = LAYOUT$pAccelerationStructures.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$accelerationStructureCount = LAYOUT.byteOffset(PATH$accelerationStructureCount);
    public static final long OFFSET$pAccelerationStructures = LAYOUT.byteOffset(PATH$pAccelerationStructures);
}
