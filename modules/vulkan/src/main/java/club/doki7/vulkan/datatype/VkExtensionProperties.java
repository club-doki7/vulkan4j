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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkExtensionProperties.html"><code>VkExtensionProperties</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkExtensionProperties {
///     char[VK_MAX_EXTENSION_NAME_SIZE] extensionName; // @link substring="extensionName" target="#extensionName"
///     uint32_t specVersion; // @link substring="specVersion" target="#specVersion"
/// } VkExtensionProperties;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkExtensionProperties.html"><code>VkExtensionProperties</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkExtensionProperties(@NotNull MemorySegment segment) implements IVkExtensionProperties {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkExtensionProperties.html"><code>VkExtensionProperties</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkExtensionProperties}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkExtensionProperties to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkExtensionProperties.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkExtensionProperties, Iterable<VkExtensionProperties> {
        public long size() {
            return segment.byteSize() / VkExtensionProperties.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkExtensionProperties at(long index) {
            return new VkExtensionProperties(segment.asSlice(index * VkExtensionProperties.BYTES, VkExtensionProperties.BYTES));
        }

        public VkExtensionProperties.Ptr at(long index, @NotNull Consumer<@NotNull VkExtensionProperties> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkExtensionProperties value) {
            MemorySegment s = segment.asSlice(index * VkExtensionProperties.BYTES, VkExtensionProperties.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkExtensionProperties.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkExtensionProperties.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkExtensionProperties.BYTES,
                (end - start) * VkExtensionProperties.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkExtensionProperties.BYTES));
        }

        public VkExtensionProperties[] toArray() {
            VkExtensionProperties[] ret = new VkExtensionProperties[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkExtensionProperties> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkExtensionProperties> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkExtensionProperties.BYTES;
            }

            @Override
            public VkExtensionProperties next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkExtensionProperties ret = new VkExtensionProperties(segment.asSlice(0, VkExtensionProperties.BYTES));
                segment = segment.asSlice(VkExtensionProperties.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkExtensionProperties allocate(Arena arena) {
        return new VkExtensionProperties(arena.allocate(LAYOUT));
    }

    public static VkExtensionProperties.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkExtensionProperties.Ptr(segment);
    }

    public static VkExtensionProperties clone(Arena arena, VkExtensionProperties src) {
        VkExtensionProperties ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public BytePtr extensionName() {
        return new BytePtr(extensionNameRaw());
    }

    public VkExtensionProperties extensionName(@NotNull Consumer<BytePtr> consumer) {
        BytePtr ptr = extensionName();
        consumer.accept(ptr);
        return this;
    }

    public VkExtensionProperties extensionName(BytePtr value) {
        MemorySegment s = extensionNameRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment extensionNameRaw() {
        return segment.asSlice(OFFSET$extensionName, SIZE$extensionName);
    }

    public @Unsigned int specVersion() {
        return segment.get(LAYOUT$specVersion, OFFSET$specVersion);
    }

    public VkExtensionProperties specVersion(@Unsigned int value) {
        segment.set(LAYOUT$specVersion, OFFSET$specVersion, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        MemoryLayout.sequenceLayout(MAX_EXTENSION_NAME_SIZE, ValueLayout.JAVA_BYTE).withName("extensionName"),
        ValueLayout.JAVA_INT.withName("specVersion")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$extensionName = PathElement.groupElement("extensionName");
    public static final PathElement PATH$specVersion = PathElement.groupElement("specVersion");

    public static final SequenceLayout LAYOUT$extensionName = (SequenceLayout) LAYOUT.select(PATH$extensionName);
    public static final OfInt LAYOUT$specVersion = (OfInt) LAYOUT.select(PATH$specVersion);

    public static final long SIZE$extensionName = LAYOUT$extensionName.byteSize();
    public static final long SIZE$specVersion = LAYOUT$specVersion.byteSize();

    public static final long OFFSET$extensionName = LAYOUT.byteOffset(PATH$extensionName);
    public static final long OFFSET$specVersion = LAYOUT.byteOffset(PATH$specVersion);
}
