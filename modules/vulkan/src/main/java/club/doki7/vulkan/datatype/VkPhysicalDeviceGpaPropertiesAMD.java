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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceGpaPropertiesAMD.html"><code>VkPhysicalDeviceGpaPropertiesAMD</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceGpaPropertiesAMD {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkPhysicalDeviceGpaPropertiesFlagsAMD flags; // @link substring="VkPhysicalDeviceGpaPropertiesFlagsAMD" target="VkPhysicalDeviceGpaPropertiesFlagsAMD" @link substring="flags" target="#flags"
///     VkDeviceSize maxSqttSeBufferSize; // @link substring="maxSqttSeBufferSize" target="#maxSqttSeBufferSize"
///     uint32_t shaderEngineCount; // @link substring="shaderEngineCount" target="#shaderEngineCount"
///     uint32_t perfBlockCount; // @link substring="perfBlockCount" target="#perfBlockCount"
///     VkGpaPerfBlockPropertiesAMD* pPerfBlocks; // @link substring="VkGpaPerfBlockPropertiesAMD" target="VkGpaPerfBlockPropertiesAMD" @link substring="pPerfBlocks" target="#pPerfBlocks"
/// } VkPhysicalDeviceGpaPropertiesAMD;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_GPA_PROPERTIES_AMD`
///
/// The {@code allocate} ({@link VkPhysicalDeviceGpaPropertiesAMD#allocate(Arena)}, {@link VkPhysicalDeviceGpaPropertiesAMD#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceGpaPropertiesAMD#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceGpaPropertiesAMD.html"><code>VkPhysicalDeviceGpaPropertiesAMD</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceGpaPropertiesAMD(@NotNull MemorySegment segment) implements IVkPhysicalDeviceGpaPropertiesAMD {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceGpaPropertiesAMD.html"><code>VkPhysicalDeviceGpaPropertiesAMD</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceGpaPropertiesAMD}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceGpaPropertiesAMD to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceGpaPropertiesAMD.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceGpaPropertiesAMD, Iterable<VkPhysicalDeviceGpaPropertiesAMD> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceGpaPropertiesAMD.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceGpaPropertiesAMD at(long index) {
            return new VkPhysicalDeviceGpaPropertiesAMD(segment.asSlice(index * VkPhysicalDeviceGpaPropertiesAMD.BYTES, VkPhysicalDeviceGpaPropertiesAMD.BYTES));
        }

        public VkPhysicalDeviceGpaPropertiesAMD.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceGpaPropertiesAMD> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceGpaPropertiesAMD value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceGpaPropertiesAMD.BYTES, VkPhysicalDeviceGpaPropertiesAMD.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceGpaPropertiesAMD.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceGpaPropertiesAMD.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceGpaPropertiesAMD.BYTES,
                (end - start) * VkPhysicalDeviceGpaPropertiesAMD.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceGpaPropertiesAMD.BYTES));
        }

        public VkPhysicalDeviceGpaPropertiesAMD[] toArray() {
            VkPhysicalDeviceGpaPropertiesAMD[] ret = new VkPhysicalDeviceGpaPropertiesAMD[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceGpaPropertiesAMD> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceGpaPropertiesAMD> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceGpaPropertiesAMD.BYTES;
            }

            @Override
            public VkPhysicalDeviceGpaPropertiesAMD next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceGpaPropertiesAMD ret = new VkPhysicalDeviceGpaPropertiesAMD(segment.asSlice(0, VkPhysicalDeviceGpaPropertiesAMD.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceGpaPropertiesAMD.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceGpaPropertiesAMD allocate(Arena arena) {
        VkPhysicalDeviceGpaPropertiesAMD ret = new VkPhysicalDeviceGpaPropertiesAMD(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_GPA_PROPERTIES_AMD);
        return ret;
    }

    public static VkPhysicalDeviceGpaPropertiesAMD.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceGpaPropertiesAMD.Ptr ret = new VkPhysicalDeviceGpaPropertiesAMD.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_GPA_PROPERTIES_AMD);
        }
        return ret;
    }

    public static VkPhysicalDeviceGpaPropertiesAMD clone(Arena arena, VkPhysicalDeviceGpaPropertiesAMD src) {
        VkPhysicalDeviceGpaPropertiesAMD ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_GPA_PROPERTIES_AMD);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceGpaPropertiesAMD sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceGpaPropertiesAMD pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceGpaPropertiesAMD pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkPhysicalDeviceGpaPropertiesFlagsAMD.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkPhysicalDeviceGpaPropertiesAMD flags(@Bitmask(VkPhysicalDeviceGpaPropertiesFlagsAMD.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long maxSqttSeBufferSize() {
        return segment.get(LAYOUT$maxSqttSeBufferSize, OFFSET$maxSqttSeBufferSize);
    }

    public VkPhysicalDeviceGpaPropertiesAMD maxSqttSeBufferSize(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$maxSqttSeBufferSize, OFFSET$maxSqttSeBufferSize, value);
        return this;
    }

    public @Unsigned int shaderEngineCount() {
        return segment.get(LAYOUT$shaderEngineCount, OFFSET$shaderEngineCount);
    }

    public VkPhysicalDeviceGpaPropertiesAMD shaderEngineCount(@Unsigned int value) {
        segment.set(LAYOUT$shaderEngineCount, OFFSET$shaderEngineCount, value);
        return this;
    }

    public @Unsigned int perfBlockCount() {
        return segment.get(LAYOUT$perfBlockCount, OFFSET$perfBlockCount);
    }

    public VkPhysicalDeviceGpaPropertiesAMD perfBlockCount(@Unsigned int value) {
        segment.set(LAYOUT$perfBlockCount, OFFSET$perfBlockCount, value);
        return this;
    }

    public VkPhysicalDeviceGpaPropertiesAMD pPerfBlocks(@Nullable IVkGpaPerfBlockPropertiesAMD value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pPerfBlocksRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkGpaPerfBlockPropertiesAMD.Ptr pPerfBlocks(int assumedCount) {
        MemorySegment s = pPerfBlocksRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkGpaPerfBlockPropertiesAMD.BYTES);
        return new VkGpaPerfBlockPropertiesAMD.Ptr(s);
    }

    public @Nullable VkGpaPerfBlockPropertiesAMD pPerfBlocks() {
        MemorySegment s = pPerfBlocksRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkGpaPerfBlockPropertiesAMD(s);
    }

    public @Pointer(target=VkGpaPerfBlockPropertiesAMD.class) @NotNull MemorySegment pPerfBlocksRaw() {
        return segment.get(LAYOUT$pPerfBlocks, OFFSET$pPerfBlocks);
    }

    public void pPerfBlocksRaw(@Pointer(target=VkGpaPerfBlockPropertiesAMD.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pPerfBlocks, OFFSET$pPerfBlocks, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_LONG.withName("maxSqttSeBufferSize"),
        ValueLayout.JAVA_INT.withName("shaderEngineCount"),
        ValueLayout.JAVA_INT.withName("perfBlockCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkGpaPerfBlockPropertiesAMD.LAYOUT).withName("pPerfBlocks")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$maxSqttSeBufferSize = PathElement.groupElement("maxSqttSeBufferSize");
    public static final PathElement PATH$shaderEngineCount = PathElement.groupElement("shaderEngineCount");
    public static final PathElement PATH$perfBlockCount = PathElement.groupElement("perfBlockCount");
    public static final PathElement PATH$pPerfBlocks = PathElement.groupElement("pPerfBlocks");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfLong LAYOUT$maxSqttSeBufferSize = (OfLong) LAYOUT.select(PATH$maxSqttSeBufferSize);
    public static final OfInt LAYOUT$shaderEngineCount = (OfInt) LAYOUT.select(PATH$shaderEngineCount);
    public static final OfInt LAYOUT$perfBlockCount = (OfInt) LAYOUT.select(PATH$perfBlockCount);
    public static final AddressLayout LAYOUT$pPerfBlocks = (AddressLayout) LAYOUT.select(PATH$pPerfBlocks);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$maxSqttSeBufferSize = LAYOUT$maxSqttSeBufferSize.byteSize();
    public static final long SIZE$shaderEngineCount = LAYOUT$shaderEngineCount.byteSize();
    public static final long SIZE$perfBlockCount = LAYOUT$perfBlockCount.byteSize();
    public static final long SIZE$pPerfBlocks = LAYOUT$pPerfBlocks.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$maxSqttSeBufferSize = LAYOUT.byteOffset(PATH$maxSqttSeBufferSize);
    public static final long OFFSET$shaderEngineCount = LAYOUT.byteOffset(PATH$shaderEngineCount);
    public static final long OFFSET$perfBlockCount = LAYOUT.byteOffset(PATH$perfBlockCount);
    public static final long OFFSET$pPerfBlocks = LAYOUT.byteOffset(PATH$pPerfBlocks);
}
