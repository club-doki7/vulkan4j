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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV.html"><code>VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t maxGraphicsShaderGroupCount; // @link substring="maxGraphicsShaderGroupCount" target="#maxGraphicsShaderGroupCount"
///     uint32_t maxIndirectSequenceCount; // @link substring="maxIndirectSequenceCount" target="#maxIndirectSequenceCount"
///     uint32_t maxIndirectCommandsTokenCount; // @link substring="maxIndirectCommandsTokenCount" target="#maxIndirectCommandsTokenCount"
///     uint32_t maxIndirectCommandsStreamCount; // @link substring="maxIndirectCommandsStreamCount" target="#maxIndirectCommandsStreamCount"
///     uint32_t maxIndirectCommandsTokenOffset; // @link substring="maxIndirectCommandsTokenOffset" target="#maxIndirectCommandsTokenOffset"
///     uint32_t maxIndirectCommandsStreamStride; // @link substring="maxIndirectCommandsStreamStride" target="#maxIndirectCommandsStreamStride"
///     uint32_t minSequencesCountBufferOffsetAlignment; // @link substring="minSequencesCountBufferOffsetAlignment" target="#minSequencesCountBufferOffsetAlignment"
///     uint32_t minSequencesIndexBufferOffsetAlignment; // @link substring="minSequencesIndexBufferOffsetAlignment" target="#minSequencesIndexBufferOffsetAlignment"
///     uint32_t minIndirectCommandsBufferOffsetAlignment; // @link substring="minIndirectCommandsBufferOffsetAlignment" target="#minIndirectCommandsBufferOffsetAlignment"
/// } VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_DEVICE_GENERATED_COMMANDS_PROPERTIES_NV`
///
/// The {@code allocate} ({@link VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV#allocate(Arena)}, {@link VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV.html"><code>VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV(@NotNull MemorySegment segment) implements IVkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV.html"><code>VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV, Iterable<VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV at(long index) {
            return new VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV(segment.asSlice(index * VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV.BYTES, VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV.BYTES));
        }

        public VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV.BYTES, VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV.BYTES,
                (end - start) * VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV.BYTES));
        }

        public VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV[] toArray() {
            VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV[] ret = new VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV.BYTES;
            }

            @Override
            public VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV ret = new VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV(segment.asSlice(0, VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV allocate(Arena arena) {
        VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV ret = new VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_DEVICE_GENERATED_COMMANDS_PROPERTIES_NV);
        return ret;
    }

    public static VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV.Ptr ret = new VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_DEVICE_GENERATED_COMMANDS_PROPERTIES_NV);
        }
        return ret;
    }

    public static VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV clone(Arena arena, VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV src) {
        VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_DEVICE_GENERATED_COMMANDS_PROPERTIES_NV);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int maxGraphicsShaderGroupCount() {
        return segment.get(LAYOUT$maxGraphicsShaderGroupCount, OFFSET$maxGraphicsShaderGroupCount);
    }

    public VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV maxGraphicsShaderGroupCount(@Unsigned int value) {
        segment.set(LAYOUT$maxGraphicsShaderGroupCount, OFFSET$maxGraphicsShaderGroupCount, value);
        return this;
    }

    public @Unsigned int maxIndirectSequenceCount() {
        return segment.get(LAYOUT$maxIndirectSequenceCount, OFFSET$maxIndirectSequenceCount);
    }

    public VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV maxIndirectSequenceCount(@Unsigned int value) {
        segment.set(LAYOUT$maxIndirectSequenceCount, OFFSET$maxIndirectSequenceCount, value);
        return this;
    }

    public @Unsigned int maxIndirectCommandsTokenCount() {
        return segment.get(LAYOUT$maxIndirectCommandsTokenCount, OFFSET$maxIndirectCommandsTokenCount);
    }

    public VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV maxIndirectCommandsTokenCount(@Unsigned int value) {
        segment.set(LAYOUT$maxIndirectCommandsTokenCount, OFFSET$maxIndirectCommandsTokenCount, value);
        return this;
    }

    public @Unsigned int maxIndirectCommandsStreamCount() {
        return segment.get(LAYOUT$maxIndirectCommandsStreamCount, OFFSET$maxIndirectCommandsStreamCount);
    }

    public VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV maxIndirectCommandsStreamCount(@Unsigned int value) {
        segment.set(LAYOUT$maxIndirectCommandsStreamCount, OFFSET$maxIndirectCommandsStreamCount, value);
        return this;
    }

    public @Unsigned int maxIndirectCommandsTokenOffset() {
        return segment.get(LAYOUT$maxIndirectCommandsTokenOffset, OFFSET$maxIndirectCommandsTokenOffset);
    }

    public VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV maxIndirectCommandsTokenOffset(@Unsigned int value) {
        segment.set(LAYOUT$maxIndirectCommandsTokenOffset, OFFSET$maxIndirectCommandsTokenOffset, value);
        return this;
    }

    public @Unsigned int maxIndirectCommandsStreamStride() {
        return segment.get(LAYOUT$maxIndirectCommandsStreamStride, OFFSET$maxIndirectCommandsStreamStride);
    }

    public VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV maxIndirectCommandsStreamStride(@Unsigned int value) {
        segment.set(LAYOUT$maxIndirectCommandsStreamStride, OFFSET$maxIndirectCommandsStreamStride, value);
        return this;
    }

    public @Unsigned int minSequencesCountBufferOffsetAlignment() {
        return segment.get(LAYOUT$minSequencesCountBufferOffsetAlignment, OFFSET$minSequencesCountBufferOffsetAlignment);
    }

    public VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV minSequencesCountBufferOffsetAlignment(@Unsigned int value) {
        segment.set(LAYOUT$minSequencesCountBufferOffsetAlignment, OFFSET$minSequencesCountBufferOffsetAlignment, value);
        return this;
    }

    public @Unsigned int minSequencesIndexBufferOffsetAlignment() {
        return segment.get(LAYOUT$minSequencesIndexBufferOffsetAlignment, OFFSET$minSequencesIndexBufferOffsetAlignment);
    }

    public VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV minSequencesIndexBufferOffsetAlignment(@Unsigned int value) {
        segment.set(LAYOUT$minSequencesIndexBufferOffsetAlignment, OFFSET$minSequencesIndexBufferOffsetAlignment, value);
        return this;
    }

    public @Unsigned int minIndirectCommandsBufferOffsetAlignment() {
        return segment.get(LAYOUT$minIndirectCommandsBufferOffsetAlignment, OFFSET$minIndirectCommandsBufferOffsetAlignment);
    }

    public VkPhysicalDeviceDeviceGeneratedCommandsPropertiesNV minIndirectCommandsBufferOffsetAlignment(@Unsigned int value) {
        segment.set(LAYOUT$minIndirectCommandsBufferOffsetAlignment, OFFSET$minIndirectCommandsBufferOffsetAlignment, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("maxGraphicsShaderGroupCount"),
        ValueLayout.JAVA_INT.withName("maxIndirectSequenceCount"),
        ValueLayout.JAVA_INT.withName("maxIndirectCommandsTokenCount"),
        ValueLayout.JAVA_INT.withName("maxIndirectCommandsStreamCount"),
        ValueLayout.JAVA_INT.withName("maxIndirectCommandsTokenOffset"),
        ValueLayout.JAVA_INT.withName("maxIndirectCommandsStreamStride"),
        ValueLayout.JAVA_INT.withName("minSequencesCountBufferOffsetAlignment"),
        ValueLayout.JAVA_INT.withName("minSequencesIndexBufferOffsetAlignment"),
        ValueLayout.JAVA_INT.withName("minIndirectCommandsBufferOffsetAlignment")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$maxGraphicsShaderGroupCount = PathElement.groupElement("maxGraphicsShaderGroupCount");
    public static final PathElement PATH$maxIndirectSequenceCount = PathElement.groupElement("maxIndirectSequenceCount");
    public static final PathElement PATH$maxIndirectCommandsTokenCount = PathElement.groupElement("maxIndirectCommandsTokenCount");
    public static final PathElement PATH$maxIndirectCommandsStreamCount = PathElement.groupElement("maxIndirectCommandsStreamCount");
    public static final PathElement PATH$maxIndirectCommandsTokenOffset = PathElement.groupElement("maxIndirectCommandsTokenOffset");
    public static final PathElement PATH$maxIndirectCommandsStreamStride = PathElement.groupElement("maxIndirectCommandsStreamStride");
    public static final PathElement PATH$minSequencesCountBufferOffsetAlignment = PathElement.groupElement("minSequencesCountBufferOffsetAlignment");
    public static final PathElement PATH$minSequencesIndexBufferOffsetAlignment = PathElement.groupElement("minSequencesIndexBufferOffsetAlignment");
    public static final PathElement PATH$minIndirectCommandsBufferOffsetAlignment = PathElement.groupElement("minIndirectCommandsBufferOffsetAlignment");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$maxGraphicsShaderGroupCount = (OfInt) LAYOUT.select(PATH$maxGraphicsShaderGroupCount);
    public static final OfInt LAYOUT$maxIndirectSequenceCount = (OfInt) LAYOUT.select(PATH$maxIndirectSequenceCount);
    public static final OfInt LAYOUT$maxIndirectCommandsTokenCount = (OfInt) LAYOUT.select(PATH$maxIndirectCommandsTokenCount);
    public static final OfInt LAYOUT$maxIndirectCommandsStreamCount = (OfInt) LAYOUT.select(PATH$maxIndirectCommandsStreamCount);
    public static final OfInt LAYOUT$maxIndirectCommandsTokenOffset = (OfInt) LAYOUT.select(PATH$maxIndirectCommandsTokenOffset);
    public static final OfInt LAYOUT$maxIndirectCommandsStreamStride = (OfInt) LAYOUT.select(PATH$maxIndirectCommandsStreamStride);
    public static final OfInt LAYOUT$minSequencesCountBufferOffsetAlignment = (OfInt) LAYOUT.select(PATH$minSequencesCountBufferOffsetAlignment);
    public static final OfInt LAYOUT$minSequencesIndexBufferOffsetAlignment = (OfInt) LAYOUT.select(PATH$minSequencesIndexBufferOffsetAlignment);
    public static final OfInt LAYOUT$minIndirectCommandsBufferOffsetAlignment = (OfInt) LAYOUT.select(PATH$minIndirectCommandsBufferOffsetAlignment);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$maxGraphicsShaderGroupCount = LAYOUT$maxGraphicsShaderGroupCount.byteSize();
    public static final long SIZE$maxIndirectSequenceCount = LAYOUT$maxIndirectSequenceCount.byteSize();
    public static final long SIZE$maxIndirectCommandsTokenCount = LAYOUT$maxIndirectCommandsTokenCount.byteSize();
    public static final long SIZE$maxIndirectCommandsStreamCount = LAYOUT$maxIndirectCommandsStreamCount.byteSize();
    public static final long SIZE$maxIndirectCommandsTokenOffset = LAYOUT$maxIndirectCommandsTokenOffset.byteSize();
    public static final long SIZE$maxIndirectCommandsStreamStride = LAYOUT$maxIndirectCommandsStreamStride.byteSize();
    public static final long SIZE$minSequencesCountBufferOffsetAlignment = LAYOUT$minSequencesCountBufferOffsetAlignment.byteSize();
    public static final long SIZE$minSequencesIndexBufferOffsetAlignment = LAYOUT$minSequencesIndexBufferOffsetAlignment.byteSize();
    public static final long SIZE$minIndirectCommandsBufferOffsetAlignment = LAYOUT$minIndirectCommandsBufferOffsetAlignment.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$maxGraphicsShaderGroupCount = LAYOUT.byteOffset(PATH$maxGraphicsShaderGroupCount);
    public static final long OFFSET$maxIndirectSequenceCount = LAYOUT.byteOffset(PATH$maxIndirectSequenceCount);
    public static final long OFFSET$maxIndirectCommandsTokenCount = LAYOUT.byteOffset(PATH$maxIndirectCommandsTokenCount);
    public static final long OFFSET$maxIndirectCommandsStreamCount = LAYOUT.byteOffset(PATH$maxIndirectCommandsStreamCount);
    public static final long OFFSET$maxIndirectCommandsTokenOffset = LAYOUT.byteOffset(PATH$maxIndirectCommandsTokenOffset);
    public static final long OFFSET$maxIndirectCommandsStreamStride = LAYOUT.byteOffset(PATH$maxIndirectCommandsStreamStride);
    public static final long OFFSET$minSequencesCountBufferOffsetAlignment = LAYOUT.byteOffset(PATH$minSequencesCountBufferOffsetAlignment);
    public static final long OFFSET$minSequencesIndexBufferOffsetAlignment = LAYOUT.byteOffset(PATH$minSequencesIndexBufferOffsetAlignment);
    public static final long OFFSET$minIndirectCommandsBufferOffsetAlignment = LAYOUT.byteOffset(PATH$minIndirectCommandsBufferOffsetAlignment);
}
