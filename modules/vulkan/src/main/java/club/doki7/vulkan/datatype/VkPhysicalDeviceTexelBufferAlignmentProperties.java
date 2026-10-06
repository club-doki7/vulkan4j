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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceTexelBufferAlignmentProperties.html"><code>VkPhysicalDeviceTexelBufferAlignmentProperties</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceTexelBufferAlignmentProperties {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkDeviceSize storageTexelBufferOffsetAlignmentBytes; // @link substring="storageTexelBufferOffsetAlignmentBytes" target="#storageTexelBufferOffsetAlignmentBytes"
///     VkBool32 storageTexelBufferOffsetSingleTexelAlignment; // @link substring="storageTexelBufferOffsetSingleTexelAlignment" target="#storageTexelBufferOffsetSingleTexelAlignment"
///     VkDeviceSize uniformTexelBufferOffsetAlignmentBytes; // @link substring="uniformTexelBufferOffsetAlignmentBytes" target="#uniformTexelBufferOffsetAlignmentBytes"
///     VkBool32 uniformTexelBufferOffsetSingleTexelAlignment; // @link substring="uniformTexelBufferOffsetSingleTexelAlignment" target="#uniformTexelBufferOffsetSingleTexelAlignment"
/// } VkPhysicalDeviceTexelBufferAlignmentProperties;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_TEXEL_BUFFER_ALIGNMENT_PROPERTIES`
///
/// The {@code allocate} ({@link VkPhysicalDeviceTexelBufferAlignmentProperties#allocate(Arena)}, {@link VkPhysicalDeviceTexelBufferAlignmentProperties#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceTexelBufferAlignmentProperties#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceTexelBufferAlignmentProperties.html"><code>VkPhysicalDeviceTexelBufferAlignmentProperties</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceTexelBufferAlignmentProperties(@NotNull MemorySegment segment) implements IVkPhysicalDeviceTexelBufferAlignmentProperties {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceTexelBufferAlignmentProperties.html"><code>VkPhysicalDeviceTexelBufferAlignmentProperties</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceTexelBufferAlignmentProperties}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceTexelBufferAlignmentProperties to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceTexelBufferAlignmentProperties.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceTexelBufferAlignmentProperties, Iterable<VkPhysicalDeviceTexelBufferAlignmentProperties> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceTexelBufferAlignmentProperties.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceTexelBufferAlignmentProperties at(long index) {
            return new VkPhysicalDeviceTexelBufferAlignmentProperties(segment.asSlice(index * VkPhysicalDeviceTexelBufferAlignmentProperties.BYTES, VkPhysicalDeviceTexelBufferAlignmentProperties.BYTES));
        }

        public VkPhysicalDeviceTexelBufferAlignmentProperties.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceTexelBufferAlignmentProperties> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceTexelBufferAlignmentProperties value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceTexelBufferAlignmentProperties.BYTES, VkPhysicalDeviceTexelBufferAlignmentProperties.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceTexelBufferAlignmentProperties.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceTexelBufferAlignmentProperties.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceTexelBufferAlignmentProperties.BYTES,
                (end - start) * VkPhysicalDeviceTexelBufferAlignmentProperties.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceTexelBufferAlignmentProperties.BYTES));
        }

        public VkPhysicalDeviceTexelBufferAlignmentProperties[] toArray() {
            VkPhysicalDeviceTexelBufferAlignmentProperties[] ret = new VkPhysicalDeviceTexelBufferAlignmentProperties[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceTexelBufferAlignmentProperties> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceTexelBufferAlignmentProperties> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceTexelBufferAlignmentProperties.BYTES;
            }

            @Override
            public VkPhysicalDeviceTexelBufferAlignmentProperties next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceTexelBufferAlignmentProperties ret = new VkPhysicalDeviceTexelBufferAlignmentProperties(segment.asSlice(0, VkPhysicalDeviceTexelBufferAlignmentProperties.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceTexelBufferAlignmentProperties.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceTexelBufferAlignmentProperties allocate(Arena arena) {
        VkPhysicalDeviceTexelBufferAlignmentProperties ret = new VkPhysicalDeviceTexelBufferAlignmentProperties(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_TEXEL_BUFFER_ALIGNMENT_PROPERTIES);
        return ret;
    }

    public static VkPhysicalDeviceTexelBufferAlignmentProperties.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceTexelBufferAlignmentProperties.Ptr ret = new VkPhysicalDeviceTexelBufferAlignmentProperties.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_TEXEL_BUFFER_ALIGNMENT_PROPERTIES);
        }
        return ret;
    }

    public static VkPhysicalDeviceTexelBufferAlignmentProperties clone(Arena arena, VkPhysicalDeviceTexelBufferAlignmentProperties src) {
        VkPhysicalDeviceTexelBufferAlignmentProperties ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_TEXEL_BUFFER_ALIGNMENT_PROPERTIES);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceTexelBufferAlignmentProperties sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceTexelBufferAlignmentProperties pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceTexelBufferAlignmentProperties pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long storageTexelBufferOffsetAlignmentBytes() {
        return segment.get(LAYOUT$storageTexelBufferOffsetAlignmentBytes, OFFSET$storageTexelBufferOffsetAlignmentBytes);
    }

    public VkPhysicalDeviceTexelBufferAlignmentProperties storageTexelBufferOffsetAlignmentBytes(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$storageTexelBufferOffsetAlignmentBytes, OFFSET$storageTexelBufferOffsetAlignmentBytes, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int storageTexelBufferOffsetSingleTexelAlignment() {
        return segment.get(LAYOUT$storageTexelBufferOffsetSingleTexelAlignment, OFFSET$storageTexelBufferOffsetSingleTexelAlignment);
    }

    public VkPhysicalDeviceTexelBufferAlignmentProperties storageTexelBufferOffsetSingleTexelAlignment(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$storageTexelBufferOffsetSingleTexelAlignment, OFFSET$storageTexelBufferOffsetSingleTexelAlignment, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long uniformTexelBufferOffsetAlignmentBytes() {
        return segment.get(LAYOUT$uniformTexelBufferOffsetAlignmentBytes, OFFSET$uniformTexelBufferOffsetAlignmentBytes);
    }

    public VkPhysicalDeviceTexelBufferAlignmentProperties uniformTexelBufferOffsetAlignmentBytes(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$uniformTexelBufferOffsetAlignmentBytes, OFFSET$uniformTexelBufferOffsetAlignmentBytes, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int uniformTexelBufferOffsetSingleTexelAlignment() {
        return segment.get(LAYOUT$uniformTexelBufferOffsetSingleTexelAlignment, OFFSET$uniformTexelBufferOffsetSingleTexelAlignment);
    }

    public VkPhysicalDeviceTexelBufferAlignmentProperties uniformTexelBufferOffsetSingleTexelAlignment(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$uniformTexelBufferOffsetSingleTexelAlignment, OFFSET$uniformTexelBufferOffsetSingleTexelAlignment, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_LONG.withName("storageTexelBufferOffsetAlignmentBytes"),
        ValueLayout.JAVA_INT.withName("storageTexelBufferOffsetSingleTexelAlignment"),
        ValueLayout.JAVA_LONG.withName("uniformTexelBufferOffsetAlignmentBytes"),
        ValueLayout.JAVA_INT.withName("uniformTexelBufferOffsetSingleTexelAlignment")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$storageTexelBufferOffsetAlignmentBytes = PathElement.groupElement("storageTexelBufferOffsetAlignmentBytes");
    public static final PathElement PATH$storageTexelBufferOffsetSingleTexelAlignment = PathElement.groupElement("storageTexelBufferOffsetSingleTexelAlignment");
    public static final PathElement PATH$uniformTexelBufferOffsetAlignmentBytes = PathElement.groupElement("uniformTexelBufferOffsetAlignmentBytes");
    public static final PathElement PATH$uniformTexelBufferOffsetSingleTexelAlignment = PathElement.groupElement("uniformTexelBufferOffsetSingleTexelAlignment");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfLong LAYOUT$storageTexelBufferOffsetAlignmentBytes = (OfLong) LAYOUT.select(PATH$storageTexelBufferOffsetAlignmentBytes);
    public static final OfInt LAYOUT$storageTexelBufferOffsetSingleTexelAlignment = (OfInt) LAYOUT.select(PATH$storageTexelBufferOffsetSingleTexelAlignment);
    public static final OfLong LAYOUT$uniformTexelBufferOffsetAlignmentBytes = (OfLong) LAYOUT.select(PATH$uniformTexelBufferOffsetAlignmentBytes);
    public static final OfInt LAYOUT$uniformTexelBufferOffsetSingleTexelAlignment = (OfInt) LAYOUT.select(PATH$uniformTexelBufferOffsetSingleTexelAlignment);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$storageTexelBufferOffsetAlignmentBytes = LAYOUT$storageTexelBufferOffsetAlignmentBytes.byteSize();
    public static final long SIZE$storageTexelBufferOffsetSingleTexelAlignment = LAYOUT$storageTexelBufferOffsetSingleTexelAlignment.byteSize();
    public static final long SIZE$uniformTexelBufferOffsetAlignmentBytes = LAYOUT$uniformTexelBufferOffsetAlignmentBytes.byteSize();
    public static final long SIZE$uniformTexelBufferOffsetSingleTexelAlignment = LAYOUT$uniformTexelBufferOffsetSingleTexelAlignment.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$storageTexelBufferOffsetAlignmentBytes = LAYOUT.byteOffset(PATH$storageTexelBufferOffsetAlignmentBytes);
    public static final long OFFSET$storageTexelBufferOffsetSingleTexelAlignment = LAYOUT.byteOffset(PATH$storageTexelBufferOffsetSingleTexelAlignment);
    public static final long OFFSET$uniformTexelBufferOffsetAlignmentBytes = LAYOUT.byteOffset(PATH$uniformTexelBufferOffsetAlignmentBytes);
    public static final long OFFSET$uniformTexelBufferOffsetSingleTexelAlignment = LAYOUT.byteOffset(PATH$uniformTexelBufferOffsetSingleTexelAlignment);
}
