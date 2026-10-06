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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkWriteDescriptorSetAccelerationStructureKHR.html"><code>VkWriteDescriptorSetAccelerationStructureKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkWriteDescriptorSetAccelerationStructureKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t accelerationStructureCount; // @link substring="accelerationStructureCount" target="#accelerationStructureCount"
///     VkAccelerationStructureKHR const* pAccelerationStructures; // @link substring="VkAccelerationStructureKHR" target="VkAccelerationStructureKHR" @link substring="pAccelerationStructures" target="#pAccelerationStructures"
/// } VkWriteDescriptorSetAccelerationStructureKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_WRITE_DESCRIPTOR_SET_ACCELERATION_STRUCTURE_KHR`
///
/// The {@code allocate} ({@link VkWriteDescriptorSetAccelerationStructureKHR#allocate(Arena)}, {@link VkWriteDescriptorSetAccelerationStructureKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkWriteDescriptorSetAccelerationStructureKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkWriteDescriptorSetAccelerationStructureKHR.html"><code>VkWriteDescriptorSetAccelerationStructureKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkWriteDescriptorSetAccelerationStructureKHR(@NotNull MemorySegment segment) implements IVkWriteDescriptorSetAccelerationStructureKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkWriteDescriptorSetAccelerationStructureKHR.html"><code>VkWriteDescriptorSetAccelerationStructureKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkWriteDescriptorSetAccelerationStructureKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkWriteDescriptorSetAccelerationStructureKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkWriteDescriptorSetAccelerationStructureKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkWriteDescriptorSetAccelerationStructureKHR, Iterable<VkWriteDescriptorSetAccelerationStructureKHR> {
        public long size() {
            return segment.byteSize() / VkWriteDescriptorSetAccelerationStructureKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkWriteDescriptorSetAccelerationStructureKHR at(long index) {
            return new VkWriteDescriptorSetAccelerationStructureKHR(segment.asSlice(index * VkWriteDescriptorSetAccelerationStructureKHR.BYTES, VkWriteDescriptorSetAccelerationStructureKHR.BYTES));
        }

        public VkWriteDescriptorSetAccelerationStructureKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkWriteDescriptorSetAccelerationStructureKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkWriteDescriptorSetAccelerationStructureKHR value) {
            MemorySegment s = segment.asSlice(index * VkWriteDescriptorSetAccelerationStructureKHR.BYTES, VkWriteDescriptorSetAccelerationStructureKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkWriteDescriptorSetAccelerationStructureKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkWriteDescriptorSetAccelerationStructureKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkWriteDescriptorSetAccelerationStructureKHR.BYTES,
                (end - start) * VkWriteDescriptorSetAccelerationStructureKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkWriteDescriptorSetAccelerationStructureKHR.BYTES));
        }

        public VkWriteDescriptorSetAccelerationStructureKHR[] toArray() {
            VkWriteDescriptorSetAccelerationStructureKHR[] ret = new VkWriteDescriptorSetAccelerationStructureKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkWriteDescriptorSetAccelerationStructureKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkWriteDescriptorSetAccelerationStructureKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkWriteDescriptorSetAccelerationStructureKHR.BYTES;
            }

            @Override
            public VkWriteDescriptorSetAccelerationStructureKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkWriteDescriptorSetAccelerationStructureKHR ret = new VkWriteDescriptorSetAccelerationStructureKHR(segment.asSlice(0, VkWriteDescriptorSetAccelerationStructureKHR.BYTES));
                segment = segment.asSlice(VkWriteDescriptorSetAccelerationStructureKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkWriteDescriptorSetAccelerationStructureKHR allocate(Arena arena) {
        VkWriteDescriptorSetAccelerationStructureKHR ret = new VkWriteDescriptorSetAccelerationStructureKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.WRITE_DESCRIPTOR_SET_ACCELERATION_STRUCTURE_KHR);
        return ret;
    }

    public static VkWriteDescriptorSetAccelerationStructureKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkWriteDescriptorSetAccelerationStructureKHR.Ptr ret = new VkWriteDescriptorSetAccelerationStructureKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.WRITE_DESCRIPTOR_SET_ACCELERATION_STRUCTURE_KHR);
        }
        return ret;
    }

    public static VkWriteDescriptorSetAccelerationStructureKHR clone(Arena arena, VkWriteDescriptorSetAccelerationStructureKHR src) {
        VkWriteDescriptorSetAccelerationStructureKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.WRITE_DESCRIPTOR_SET_ACCELERATION_STRUCTURE_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkWriteDescriptorSetAccelerationStructureKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkWriteDescriptorSetAccelerationStructureKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkWriteDescriptorSetAccelerationStructureKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int accelerationStructureCount() {
        return segment.get(LAYOUT$accelerationStructureCount, OFFSET$accelerationStructureCount);
    }

    public VkWriteDescriptorSetAccelerationStructureKHR accelerationStructureCount(@Unsigned int value) {
        segment.set(LAYOUT$accelerationStructureCount, OFFSET$accelerationStructureCount, value);
        return this;
    }

    /// Note: the returned {@link VkAccelerationStructureKHR.Ptr} does not have correct {@link VkAccelerationStructureKHR.Ptr#size}
    /// property. It's up to user to track the size of the buffer, and use
    /// {@link VkAccelerationStructureKHR.Ptr#reinterpret} to set the size before actually reading from or writing to the
    /// buffer.
    public @Nullable VkAccelerationStructureKHR.Ptr pAccelerationStructures() {
        MemorySegment s = pAccelerationStructuresRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkAccelerationStructureKHR.Ptr(s);
    }

    public VkWriteDescriptorSetAccelerationStructureKHR pAccelerationStructures(@Nullable VkAccelerationStructureKHR.Ptr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pAccelerationStructuresRaw(s);
        return this;
    }

    public @Pointer(target=VkAccelerationStructureKHR.class) @NotNull MemorySegment pAccelerationStructuresRaw() {
        return segment.get(LAYOUT$pAccelerationStructures, OFFSET$pAccelerationStructures);
    }

    public void pAccelerationStructuresRaw(@Pointer(target=VkAccelerationStructureKHR.class) @NotNull MemorySegment value) {
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
