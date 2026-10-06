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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMicromapUsageKHR.html"><code>VkMicromapUsageKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkMicromapUsageKHR {
///     uint32_t count; // @link substring="count" target="#count"
///     uint32_t subdivisionLevel; // @link substring="subdivisionLevel" target="#subdivisionLevel"
///     VkOpacityMicromapFormatKHR format; // @link substring="VkOpacityMicromapFormatKHR" target="VkOpacityMicromapFormatKHR" @link substring="format" target="#format"
/// } VkMicromapUsageKHR;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMicromapUsageKHR.html"><code>VkMicromapUsageKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkMicromapUsageKHR(@NotNull MemorySegment segment) implements IVkMicromapUsageKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkMicromapUsageKHR.html"><code>VkMicromapUsageKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkMicromapUsageKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkMicromapUsageKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkMicromapUsageKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkMicromapUsageKHR, Iterable<VkMicromapUsageKHR> {
        public long size() {
            return segment.byteSize() / VkMicromapUsageKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkMicromapUsageKHR at(long index) {
            return new VkMicromapUsageKHR(segment.asSlice(index * VkMicromapUsageKHR.BYTES, VkMicromapUsageKHR.BYTES));
        }

        public VkMicromapUsageKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkMicromapUsageKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkMicromapUsageKHR value) {
            MemorySegment s = segment.asSlice(index * VkMicromapUsageKHR.BYTES, VkMicromapUsageKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkMicromapUsageKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkMicromapUsageKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkMicromapUsageKHR.BYTES,
                (end - start) * VkMicromapUsageKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkMicromapUsageKHR.BYTES));
        }

        public VkMicromapUsageKHR[] toArray() {
            VkMicromapUsageKHR[] ret = new VkMicromapUsageKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkMicromapUsageKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkMicromapUsageKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkMicromapUsageKHR.BYTES;
            }

            @Override
            public VkMicromapUsageKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkMicromapUsageKHR ret = new VkMicromapUsageKHR(segment.asSlice(0, VkMicromapUsageKHR.BYTES));
                segment = segment.asSlice(VkMicromapUsageKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkMicromapUsageKHR allocate(Arena arena) {
        return new VkMicromapUsageKHR(arena.allocate(LAYOUT));
    }

    public static VkMicromapUsageKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkMicromapUsageKHR.Ptr(segment);
    }

    public static VkMicromapUsageKHR clone(Arena arena, VkMicromapUsageKHR src) {
        VkMicromapUsageKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned int count() {
        return segment.get(LAYOUT$count, OFFSET$count);
    }

    public VkMicromapUsageKHR count(@Unsigned int value) {
        segment.set(LAYOUT$count, OFFSET$count, value);
        return this;
    }

    public @Unsigned int subdivisionLevel() {
        return segment.get(LAYOUT$subdivisionLevel, OFFSET$subdivisionLevel);
    }

    public VkMicromapUsageKHR subdivisionLevel(@Unsigned int value) {
        segment.set(LAYOUT$subdivisionLevel, OFFSET$subdivisionLevel, value);
        return this;
    }

    public @EnumType(VkOpacityMicromapFormatKHR.class) int format() {
        return segment.get(LAYOUT$format, OFFSET$format);
    }

    public VkMicromapUsageKHR format(@EnumType(VkOpacityMicromapFormatKHR.class) int value) {
        segment.set(LAYOUT$format, OFFSET$format, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("count"),
        ValueLayout.JAVA_INT.withName("subdivisionLevel"),
        ValueLayout.JAVA_INT.withName("format")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$count = PathElement.groupElement("count");
    public static final PathElement PATH$subdivisionLevel = PathElement.groupElement("subdivisionLevel");
    public static final PathElement PATH$format = PathElement.groupElement("format");

    public static final OfInt LAYOUT$count = (OfInt) LAYOUT.select(PATH$count);
    public static final OfInt LAYOUT$subdivisionLevel = (OfInt) LAYOUT.select(PATH$subdivisionLevel);
    public static final OfInt LAYOUT$format = (OfInt) LAYOUT.select(PATH$format);

    public static final long SIZE$count = LAYOUT$count.byteSize();
    public static final long SIZE$subdivisionLevel = LAYOUT$subdivisionLevel.byteSize();
    public static final long SIZE$format = LAYOUT$format.byteSize();

    public static final long OFFSET$count = LAYOUT.byteOffset(PATH$count);
    public static final long OFFSET$subdivisionLevel = LAYOUT.byteOffset(PATH$subdivisionLevel);
    public static final long OFFSET$format = LAYOUT.byteOffset(PATH$format);
}
