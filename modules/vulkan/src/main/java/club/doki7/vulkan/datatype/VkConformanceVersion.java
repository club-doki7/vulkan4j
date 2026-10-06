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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkConformanceVersion.html"><code>VkConformanceVersion</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkConformanceVersion {
///     uint8_t major; // @link substring="major" target="#major"
///     uint8_t minor; // @link substring="minor" target="#minor"
///     uint8_t subminor; // @link substring="subminor" target="#subminor"
///     uint8_t patch; // @link substring="patch" target="#patch"
/// } VkConformanceVersion;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkConformanceVersion.html"><code>VkConformanceVersion</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkConformanceVersion(@NotNull MemorySegment segment) implements IVkConformanceVersion {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkConformanceVersion.html"><code>VkConformanceVersion</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkConformanceVersion}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkConformanceVersion to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkConformanceVersion.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkConformanceVersion, Iterable<VkConformanceVersion> {
        public long size() {
            return segment.byteSize() / VkConformanceVersion.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkConformanceVersion at(long index) {
            return new VkConformanceVersion(segment.asSlice(index * VkConformanceVersion.BYTES, VkConformanceVersion.BYTES));
        }

        public VkConformanceVersion.Ptr at(long index, @NotNull Consumer<@NotNull VkConformanceVersion> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkConformanceVersion value) {
            MemorySegment s = segment.asSlice(index * VkConformanceVersion.BYTES, VkConformanceVersion.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkConformanceVersion.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkConformanceVersion.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkConformanceVersion.BYTES,
                (end - start) * VkConformanceVersion.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkConformanceVersion.BYTES));
        }

        public VkConformanceVersion[] toArray() {
            VkConformanceVersion[] ret = new VkConformanceVersion[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkConformanceVersion> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkConformanceVersion> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkConformanceVersion.BYTES;
            }

            @Override
            public VkConformanceVersion next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkConformanceVersion ret = new VkConformanceVersion(segment.asSlice(0, VkConformanceVersion.BYTES));
                segment = segment.asSlice(VkConformanceVersion.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkConformanceVersion allocate(Arena arena) {
        return new VkConformanceVersion(arena.allocate(LAYOUT));
    }

    public static VkConformanceVersion.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkConformanceVersion.Ptr(segment);
    }

    public static VkConformanceVersion clone(Arena arena, VkConformanceVersion src) {
        VkConformanceVersion ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned byte major() {
        return segment.get(LAYOUT$major, OFFSET$major);
    }

    public VkConformanceVersion major(@Unsigned byte value) {
        segment.set(LAYOUT$major, OFFSET$major, value);
        return this;
    }

    public @Unsigned byte minor() {
        return segment.get(LAYOUT$minor, OFFSET$minor);
    }

    public VkConformanceVersion minor(@Unsigned byte value) {
        segment.set(LAYOUT$minor, OFFSET$minor, value);
        return this;
    }

    public @Unsigned byte subminor() {
        return segment.get(LAYOUT$subminor, OFFSET$subminor);
    }

    public VkConformanceVersion subminor(@Unsigned byte value) {
        segment.set(LAYOUT$subminor, OFFSET$subminor, value);
        return this;
    }

    public @Unsigned byte patch() {
        return segment.get(LAYOUT$patch, OFFSET$patch);
    }

    public VkConformanceVersion patch(@Unsigned byte value) {
        segment.set(LAYOUT$patch, OFFSET$patch, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_BYTE.withName("major"),
        ValueLayout.JAVA_BYTE.withName("minor"),
        ValueLayout.JAVA_BYTE.withName("subminor"),
        ValueLayout.JAVA_BYTE.withName("patch")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$major = PathElement.groupElement("major");
    public static final PathElement PATH$minor = PathElement.groupElement("minor");
    public static final PathElement PATH$subminor = PathElement.groupElement("subminor");
    public static final PathElement PATH$patch = PathElement.groupElement("patch");

    public static final OfByte LAYOUT$major = (OfByte) LAYOUT.select(PATH$major);
    public static final OfByte LAYOUT$minor = (OfByte) LAYOUT.select(PATH$minor);
    public static final OfByte LAYOUT$subminor = (OfByte) LAYOUT.select(PATH$subminor);
    public static final OfByte LAYOUT$patch = (OfByte) LAYOUT.select(PATH$patch);

    public static final long SIZE$major = LAYOUT$major.byteSize();
    public static final long SIZE$minor = LAYOUT$minor.byteSize();
    public static final long SIZE$subminor = LAYOUT$subminor.byteSize();
    public static final long SIZE$patch = LAYOUT$patch.byteSize();

    public static final long OFFSET$major = LAYOUT.byteOffset(PATH$major);
    public static final long OFFSET$minor = LAYOUT.byteOffset(PATH$minor);
    public static final long OFFSET$subminor = LAYOUT.byteOffset(PATH$subminor);
    public static final long OFFSET$patch = LAYOUT.byteOffset(PATH$patch);
}
