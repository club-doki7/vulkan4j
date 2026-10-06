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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDrmFormatModifierPropertiesEXT.html"><code>VkDrmFormatModifierPropertiesEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDrmFormatModifierPropertiesEXT {
///     uint64_t drmFormatModifier; // @link substring="drmFormatModifier" target="#drmFormatModifier"
///     uint32_t drmFormatModifierPlaneCount; // @link substring="drmFormatModifierPlaneCount" target="#drmFormatModifierPlaneCount"
///     VkFormatFeatureFlags drmFormatModifierTilingFeatures; // @link substring="VkFormatFeatureFlags" target="VkFormatFeatureFlags" @link substring="drmFormatModifierTilingFeatures" target="#drmFormatModifierTilingFeatures"
/// } VkDrmFormatModifierPropertiesEXT;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDrmFormatModifierPropertiesEXT.html"><code>VkDrmFormatModifierPropertiesEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDrmFormatModifierPropertiesEXT(@NotNull MemorySegment segment) implements IVkDrmFormatModifierPropertiesEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDrmFormatModifierPropertiesEXT.html"><code>VkDrmFormatModifierPropertiesEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDrmFormatModifierPropertiesEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDrmFormatModifierPropertiesEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDrmFormatModifierPropertiesEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDrmFormatModifierPropertiesEXT, Iterable<VkDrmFormatModifierPropertiesEXT> {
        public long size() {
            return segment.byteSize() / VkDrmFormatModifierPropertiesEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDrmFormatModifierPropertiesEXT at(long index) {
            return new VkDrmFormatModifierPropertiesEXT(segment.asSlice(index * VkDrmFormatModifierPropertiesEXT.BYTES, VkDrmFormatModifierPropertiesEXT.BYTES));
        }

        public VkDrmFormatModifierPropertiesEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkDrmFormatModifierPropertiesEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDrmFormatModifierPropertiesEXT value) {
            MemorySegment s = segment.asSlice(index * VkDrmFormatModifierPropertiesEXT.BYTES, VkDrmFormatModifierPropertiesEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDrmFormatModifierPropertiesEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDrmFormatModifierPropertiesEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDrmFormatModifierPropertiesEXT.BYTES,
                (end - start) * VkDrmFormatModifierPropertiesEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDrmFormatModifierPropertiesEXT.BYTES));
        }

        public VkDrmFormatModifierPropertiesEXT[] toArray() {
            VkDrmFormatModifierPropertiesEXT[] ret = new VkDrmFormatModifierPropertiesEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDrmFormatModifierPropertiesEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDrmFormatModifierPropertiesEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDrmFormatModifierPropertiesEXT.BYTES;
            }

            @Override
            public VkDrmFormatModifierPropertiesEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDrmFormatModifierPropertiesEXT ret = new VkDrmFormatModifierPropertiesEXT(segment.asSlice(0, VkDrmFormatModifierPropertiesEXT.BYTES));
                segment = segment.asSlice(VkDrmFormatModifierPropertiesEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDrmFormatModifierPropertiesEXT allocate(Arena arena) {
        return new VkDrmFormatModifierPropertiesEXT(arena.allocate(LAYOUT));
    }

    public static VkDrmFormatModifierPropertiesEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkDrmFormatModifierPropertiesEXT.Ptr(segment);
    }

    public static VkDrmFormatModifierPropertiesEXT clone(Arena arena, VkDrmFormatModifierPropertiesEXT src) {
        VkDrmFormatModifierPropertiesEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned long drmFormatModifier() {
        return segment.get(LAYOUT$drmFormatModifier, OFFSET$drmFormatModifier);
    }

    public VkDrmFormatModifierPropertiesEXT drmFormatModifier(@Unsigned long value) {
        segment.set(LAYOUT$drmFormatModifier, OFFSET$drmFormatModifier, value);
        return this;
    }

    public @Unsigned int drmFormatModifierPlaneCount() {
        return segment.get(LAYOUT$drmFormatModifierPlaneCount, OFFSET$drmFormatModifierPlaneCount);
    }

    public VkDrmFormatModifierPropertiesEXT drmFormatModifierPlaneCount(@Unsigned int value) {
        segment.set(LAYOUT$drmFormatModifierPlaneCount, OFFSET$drmFormatModifierPlaneCount, value);
        return this;
    }

    public @Bitmask(VkFormatFeatureFlags.class) int drmFormatModifierTilingFeatures() {
        return segment.get(LAYOUT$drmFormatModifierTilingFeatures, OFFSET$drmFormatModifierTilingFeatures);
    }

    public VkDrmFormatModifierPropertiesEXT drmFormatModifierTilingFeatures(@Bitmask(VkFormatFeatureFlags.class) int value) {
        segment.set(LAYOUT$drmFormatModifierTilingFeatures, OFFSET$drmFormatModifierTilingFeatures, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_LONG.withName("drmFormatModifier"),
        ValueLayout.JAVA_INT.withName("drmFormatModifierPlaneCount"),
        ValueLayout.JAVA_INT.withName("drmFormatModifierTilingFeatures")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$drmFormatModifier = PathElement.groupElement("drmFormatModifier");
    public static final PathElement PATH$drmFormatModifierPlaneCount = PathElement.groupElement("drmFormatModifierPlaneCount");
    public static final PathElement PATH$drmFormatModifierTilingFeatures = PathElement.groupElement("drmFormatModifierTilingFeatures");

    public static final OfLong LAYOUT$drmFormatModifier = (OfLong) LAYOUT.select(PATH$drmFormatModifier);
    public static final OfInt LAYOUT$drmFormatModifierPlaneCount = (OfInt) LAYOUT.select(PATH$drmFormatModifierPlaneCount);
    public static final OfInt LAYOUT$drmFormatModifierTilingFeatures = (OfInt) LAYOUT.select(PATH$drmFormatModifierTilingFeatures);

    public static final long SIZE$drmFormatModifier = LAYOUT$drmFormatModifier.byteSize();
    public static final long SIZE$drmFormatModifierPlaneCount = LAYOUT$drmFormatModifierPlaneCount.byteSize();
    public static final long SIZE$drmFormatModifierTilingFeatures = LAYOUT$drmFormatModifierTilingFeatures.byteSize();

    public static final long OFFSET$drmFormatModifier = LAYOUT.byteOffset(PATH$drmFormatModifier);
    public static final long OFFSET$drmFormatModifierPlaneCount = LAYOUT.byteOffset(PATH$drmFormatModifierPlaneCount);
    public static final long OFFSET$drmFormatModifierTilingFeatures = LAYOUT.byteOffset(PATH$drmFormatModifierTilingFeatures);
}
