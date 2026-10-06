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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkLayerProperties.html"><code>VkLayerProperties</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkLayerProperties {
///     char[VK_MAX_EXTENSION_NAME_SIZE] layerName; // @link substring="layerName" target="#layerName"
///     uint32_t specVersion; // @link substring="specVersion" target="#specVersion"
///     uint32_t implementationVersion; // @link substring="implementationVersion" target="#implementationVersion"
///     char[VK_MAX_DESCRIPTION_SIZE] description; // @link substring="description" target="#description"
/// } VkLayerProperties;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkLayerProperties.html"><code>VkLayerProperties</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkLayerProperties(@NotNull MemorySegment segment) implements IVkLayerProperties {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkLayerProperties.html"><code>VkLayerProperties</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkLayerProperties}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkLayerProperties to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkLayerProperties.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkLayerProperties, Iterable<VkLayerProperties> {
        public long size() {
            return segment.byteSize() / VkLayerProperties.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkLayerProperties at(long index) {
            return new VkLayerProperties(segment.asSlice(index * VkLayerProperties.BYTES, VkLayerProperties.BYTES));
        }

        public VkLayerProperties.Ptr at(long index, @NotNull Consumer<@NotNull VkLayerProperties> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkLayerProperties value) {
            MemorySegment s = segment.asSlice(index * VkLayerProperties.BYTES, VkLayerProperties.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkLayerProperties.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkLayerProperties.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkLayerProperties.BYTES,
                (end - start) * VkLayerProperties.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkLayerProperties.BYTES));
        }

        public VkLayerProperties[] toArray() {
            VkLayerProperties[] ret = new VkLayerProperties[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkLayerProperties> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkLayerProperties> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkLayerProperties.BYTES;
            }

            @Override
            public VkLayerProperties next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkLayerProperties ret = new VkLayerProperties(segment.asSlice(0, VkLayerProperties.BYTES));
                segment = segment.asSlice(VkLayerProperties.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkLayerProperties allocate(Arena arena) {
        return new VkLayerProperties(arena.allocate(LAYOUT));
    }

    public static VkLayerProperties.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkLayerProperties.Ptr(segment);
    }

    public static VkLayerProperties clone(Arena arena, VkLayerProperties src) {
        VkLayerProperties ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public BytePtr layerName() {
        return new BytePtr(layerNameRaw());
    }

    public VkLayerProperties layerName(@NotNull Consumer<BytePtr> consumer) {
        BytePtr ptr = layerName();
        consumer.accept(ptr);
        return this;
    }

    public VkLayerProperties layerName(BytePtr value) {
        MemorySegment s = layerNameRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment layerNameRaw() {
        return segment.asSlice(OFFSET$layerName, SIZE$layerName);
    }

    public @Unsigned int specVersion() {
        return segment.get(LAYOUT$specVersion, OFFSET$specVersion);
    }

    public VkLayerProperties specVersion(@Unsigned int value) {
        segment.set(LAYOUT$specVersion, OFFSET$specVersion, value);
        return this;
    }

    public @Unsigned int implementationVersion() {
        return segment.get(LAYOUT$implementationVersion, OFFSET$implementationVersion);
    }

    public VkLayerProperties implementationVersion(@Unsigned int value) {
        segment.set(LAYOUT$implementationVersion, OFFSET$implementationVersion, value);
        return this;
    }

    public BytePtr description() {
        return new BytePtr(descriptionRaw());
    }

    public VkLayerProperties description(@NotNull Consumer<BytePtr> consumer) {
        BytePtr ptr = description();
        consumer.accept(ptr);
        return this;
    }

    public VkLayerProperties description(BytePtr value) {
        MemorySegment s = descriptionRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment descriptionRaw() {
        return segment.asSlice(OFFSET$description, SIZE$description);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        MemoryLayout.sequenceLayout(MAX_EXTENSION_NAME_SIZE, ValueLayout.JAVA_BYTE).withName("layerName"),
        ValueLayout.JAVA_INT.withName("specVersion"),
        ValueLayout.JAVA_INT.withName("implementationVersion"),
        MemoryLayout.sequenceLayout(MAX_DESCRIPTION_SIZE, ValueLayout.JAVA_BYTE).withName("description")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$layerName = PathElement.groupElement("layerName");
    public static final PathElement PATH$specVersion = PathElement.groupElement("specVersion");
    public static final PathElement PATH$implementationVersion = PathElement.groupElement("implementationVersion");
    public static final PathElement PATH$description = PathElement.groupElement("description");

    public static final SequenceLayout LAYOUT$layerName = (SequenceLayout) LAYOUT.select(PATH$layerName);
    public static final OfInt LAYOUT$specVersion = (OfInt) LAYOUT.select(PATH$specVersion);
    public static final OfInt LAYOUT$implementationVersion = (OfInt) LAYOUT.select(PATH$implementationVersion);
    public static final SequenceLayout LAYOUT$description = (SequenceLayout) LAYOUT.select(PATH$description);

    public static final long SIZE$layerName = LAYOUT$layerName.byteSize();
    public static final long SIZE$specVersion = LAYOUT$specVersion.byteSize();
    public static final long SIZE$implementationVersion = LAYOUT$implementationVersion.byteSize();
    public static final long SIZE$description = LAYOUT$description.byteSize();

    public static final long OFFSET$layerName = LAYOUT.byteOffset(PATH$layerName);
    public static final long OFFSET$specVersion = LAYOUT.byteOffset(PATH$specVersion);
    public static final long OFFSET$implementationVersion = LAYOUT.byteOffset(PATH$implementationVersion);
    public static final long OFFSET$description = LAYOUT.byteOffset(PATH$description);
}
