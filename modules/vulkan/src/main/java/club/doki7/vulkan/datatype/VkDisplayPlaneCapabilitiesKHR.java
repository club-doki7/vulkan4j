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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDisplayPlaneCapabilitiesKHR.html"><code>VkDisplayPlaneCapabilitiesKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDisplayPlaneCapabilitiesKHR {
///     VkDisplayPlaneAlphaFlagsKHR supportedAlpha; // optional // @link substring="VkDisplayPlaneAlphaFlagsKHR" target="VkDisplayPlaneAlphaFlagsKHR" @link substring="supportedAlpha" target="#supportedAlpha"
///     VkOffset2D minSrcPosition; // @link substring="VkOffset2D" target="VkOffset2D" @link substring="minSrcPosition" target="#minSrcPosition"
///     VkOffset2D maxSrcPosition; // @link substring="VkOffset2D" target="VkOffset2D" @link substring="maxSrcPosition" target="#maxSrcPosition"
///     VkExtent2D minSrcExtent; // @link substring="VkExtent2D" target="VkExtent2D" @link substring="minSrcExtent" target="#minSrcExtent"
///     VkExtent2D maxSrcExtent; // @link substring="VkExtent2D" target="VkExtent2D" @link substring="maxSrcExtent" target="#maxSrcExtent"
///     VkOffset2D minDstPosition; // @link substring="VkOffset2D" target="VkOffset2D" @link substring="minDstPosition" target="#minDstPosition"
///     VkOffset2D maxDstPosition; // @link substring="VkOffset2D" target="VkOffset2D" @link substring="maxDstPosition" target="#maxDstPosition"
///     VkExtent2D minDstExtent; // @link substring="VkExtent2D" target="VkExtent2D" @link substring="minDstExtent" target="#minDstExtent"
///     VkExtent2D maxDstExtent; // @link substring="VkExtent2D" target="VkExtent2D" @link substring="maxDstExtent" target="#maxDstExtent"
/// } VkDisplayPlaneCapabilitiesKHR;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDisplayPlaneCapabilitiesKHR.html"><code>VkDisplayPlaneCapabilitiesKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDisplayPlaneCapabilitiesKHR(@NotNull MemorySegment segment) implements IVkDisplayPlaneCapabilitiesKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDisplayPlaneCapabilitiesKHR.html"><code>VkDisplayPlaneCapabilitiesKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDisplayPlaneCapabilitiesKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDisplayPlaneCapabilitiesKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDisplayPlaneCapabilitiesKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDisplayPlaneCapabilitiesKHR, Iterable<VkDisplayPlaneCapabilitiesKHR> {
        public long size() {
            return segment.byteSize() / VkDisplayPlaneCapabilitiesKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDisplayPlaneCapabilitiesKHR at(long index) {
            return new VkDisplayPlaneCapabilitiesKHR(segment.asSlice(index * VkDisplayPlaneCapabilitiesKHR.BYTES, VkDisplayPlaneCapabilitiesKHR.BYTES));
        }

        public VkDisplayPlaneCapabilitiesKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkDisplayPlaneCapabilitiesKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDisplayPlaneCapabilitiesKHR value) {
            MemorySegment s = segment.asSlice(index * VkDisplayPlaneCapabilitiesKHR.BYTES, VkDisplayPlaneCapabilitiesKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDisplayPlaneCapabilitiesKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDisplayPlaneCapabilitiesKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDisplayPlaneCapabilitiesKHR.BYTES,
                (end - start) * VkDisplayPlaneCapabilitiesKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDisplayPlaneCapabilitiesKHR.BYTES));
        }

        public VkDisplayPlaneCapabilitiesKHR[] toArray() {
            VkDisplayPlaneCapabilitiesKHR[] ret = new VkDisplayPlaneCapabilitiesKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDisplayPlaneCapabilitiesKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDisplayPlaneCapabilitiesKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDisplayPlaneCapabilitiesKHR.BYTES;
            }

            @Override
            public VkDisplayPlaneCapabilitiesKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDisplayPlaneCapabilitiesKHR ret = new VkDisplayPlaneCapabilitiesKHR(segment.asSlice(0, VkDisplayPlaneCapabilitiesKHR.BYTES));
                segment = segment.asSlice(VkDisplayPlaneCapabilitiesKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDisplayPlaneCapabilitiesKHR allocate(Arena arena) {
        return new VkDisplayPlaneCapabilitiesKHR(arena.allocate(LAYOUT));
    }

    public static VkDisplayPlaneCapabilitiesKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkDisplayPlaneCapabilitiesKHR.Ptr(segment);
    }

    public static VkDisplayPlaneCapabilitiesKHR clone(Arena arena, VkDisplayPlaneCapabilitiesKHR src) {
        VkDisplayPlaneCapabilitiesKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Bitmask(VkDisplayPlaneAlphaFlagsKHR.class) int supportedAlpha() {
        return segment.get(LAYOUT$supportedAlpha, OFFSET$supportedAlpha);
    }

    public VkDisplayPlaneCapabilitiesKHR supportedAlpha(@Bitmask(VkDisplayPlaneAlphaFlagsKHR.class) int value) {
        segment.set(LAYOUT$supportedAlpha, OFFSET$supportedAlpha, value);
        return this;
    }

    public @NotNull VkOffset2D minSrcPosition() {
        return new VkOffset2D(segment.asSlice(OFFSET$minSrcPosition, LAYOUT$minSrcPosition));
    }

    public VkDisplayPlaneCapabilitiesKHR minSrcPosition(@NotNull VkOffset2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$minSrcPosition, SIZE$minSrcPosition);
        return this;
    }

    public VkDisplayPlaneCapabilitiesKHR minSrcPosition(Consumer<@NotNull VkOffset2D> consumer) {
        consumer.accept(minSrcPosition());
        return this;
    }

    public @NotNull VkOffset2D maxSrcPosition() {
        return new VkOffset2D(segment.asSlice(OFFSET$maxSrcPosition, LAYOUT$maxSrcPosition));
    }

    public VkDisplayPlaneCapabilitiesKHR maxSrcPosition(@NotNull VkOffset2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$maxSrcPosition, SIZE$maxSrcPosition);
        return this;
    }

    public VkDisplayPlaneCapabilitiesKHR maxSrcPosition(Consumer<@NotNull VkOffset2D> consumer) {
        consumer.accept(maxSrcPosition());
        return this;
    }

    public @NotNull VkExtent2D minSrcExtent() {
        return new VkExtent2D(segment.asSlice(OFFSET$minSrcExtent, LAYOUT$minSrcExtent));
    }

    public VkDisplayPlaneCapabilitiesKHR minSrcExtent(@NotNull VkExtent2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$minSrcExtent, SIZE$minSrcExtent);
        return this;
    }

    public VkDisplayPlaneCapabilitiesKHR minSrcExtent(Consumer<@NotNull VkExtent2D> consumer) {
        consumer.accept(minSrcExtent());
        return this;
    }

    public @NotNull VkExtent2D maxSrcExtent() {
        return new VkExtent2D(segment.asSlice(OFFSET$maxSrcExtent, LAYOUT$maxSrcExtent));
    }

    public VkDisplayPlaneCapabilitiesKHR maxSrcExtent(@NotNull VkExtent2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$maxSrcExtent, SIZE$maxSrcExtent);
        return this;
    }

    public VkDisplayPlaneCapabilitiesKHR maxSrcExtent(Consumer<@NotNull VkExtent2D> consumer) {
        consumer.accept(maxSrcExtent());
        return this;
    }

    public @NotNull VkOffset2D minDstPosition() {
        return new VkOffset2D(segment.asSlice(OFFSET$minDstPosition, LAYOUT$minDstPosition));
    }

    public VkDisplayPlaneCapabilitiesKHR minDstPosition(@NotNull VkOffset2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$minDstPosition, SIZE$minDstPosition);
        return this;
    }

    public VkDisplayPlaneCapabilitiesKHR minDstPosition(Consumer<@NotNull VkOffset2D> consumer) {
        consumer.accept(minDstPosition());
        return this;
    }

    public @NotNull VkOffset2D maxDstPosition() {
        return new VkOffset2D(segment.asSlice(OFFSET$maxDstPosition, LAYOUT$maxDstPosition));
    }

    public VkDisplayPlaneCapabilitiesKHR maxDstPosition(@NotNull VkOffset2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$maxDstPosition, SIZE$maxDstPosition);
        return this;
    }

    public VkDisplayPlaneCapabilitiesKHR maxDstPosition(Consumer<@NotNull VkOffset2D> consumer) {
        consumer.accept(maxDstPosition());
        return this;
    }

    public @NotNull VkExtent2D minDstExtent() {
        return new VkExtent2D(segment.asSlice(OFFSET$minDstExtent, LAYOUT$minDstExtent));
    }

    public VkDisplayPlaneCapabilitiesKHR minDstExtent(@NotNull VkExtent2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$minDstExtent, SIZE$minDstExtent);
        return this;
    }

    public VkDisplayPlaneCapabilitiesKHR minDstExtent(Consumer<@NotNull VkExtent2D> consumer) {
        consumer.accept(minDstExtent());
        return this;
    }

    public @NotNull VkExtent2D maxDstExtent() {
        return new VkExtent2D(segment.asSlice(OFFSET$maxDstExtent, LAYOUT$maxDstExtent));
    }

    public VkDisplayPlaneCapabilitiesKHR maxDstExtent(@NotNull VkExtent2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$maxDstExtent, SIZE$maxDstExtent);
        return this;
    }

    public VkDisplayPlaneCapabilitiesKHR maxDstExtent(Consumer<@NotNull VkExtent2D> consumer) {
        consumer.accept(maxDstExtent());
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("supportedAlpha"),
        VkOffset2D.LAYOUT.withName("minSrcPosition"),
        VkOffset2D.LAYOUT.withName("maxSrcPosition"),
        VkExtent2D.LAYOUT.withName("minSrcExtent"),
        VkExtent2D.LAYOUT.withName("maxSrcExtent"),
        VkOffset2D.LAYOUT.withName("minDstPosition"),
        VkOffset2D.LAYOUT.withName("maxDstPosition"),
        VkExtent2D.LAYOUT.withName("minDstExtent"),
        VkExtent2D.LAYOUT.withName("maxDstExtent")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$supportedAlpha = PathElement.groupElement("supportedAlpha");
    public static final PathElement PATH$minSrcPosition = PathElement.groupElement("minSrcPosition");
    public static final PathElement PATH$maxSrcPosition = PathElement.groupElement("maxSrcPosition");
    public static final PathElement PATH$minSrcExtent = PathElement.groupElement("minSrcExtent");
    public static final PathElement PATH$maxSrcExtent = PathElement.groupElement("maxSrcExtent");
    public static final PathElement PATH$minDstPosition = PathElement.groupElement("minDstPosition");
    public static final PathElement PATH$maxDstPosition = PathElement.groupElement("maxDstPosition");
    public static final PathElement PATH$minDstExtent = PathElement.groupElement("minDstExtent");
    public static final PathElement PATH$maxDstExtent = PathElement.groupElement("maxDstExtent");

    public static final OfInt LAYOUT$supportedAlpha = (OfInt) LAYOUT.select(PATH$supportedAlpha);
    public static final StructLayout LAYOUT$minSrcPosition = (StructLayout) LAYOUT.select(PATH$minSrcPosition);
    public static final StructLayout LAYOUT$maxSrcPosition = (StructLayout) LAYOUT.select(PATH$maxSrcPosition);
    public static final StructLayout LAYOUT$minSrcExtent = (StructLayout) LAYOUT.select(PATH$minSrcExtent);
    public static final StructLayout LAYOUT$maxSrcExtent = (StructLayout) LAYOUT.select(PATH$maxSrcExtent);
    public static final StructLayout LAYOUT$minDstPosition = (StructLayout) LAYOUT.select(PATH$minDstPosition);
    public static final StructLayout LAYOUT$maxDstPosition = (StructLayout) LAYOUT.select(PATH$maxDstPosition);
    public static final StructLayout LAYOUT$minDstExtent = (StructLayout) LAYOUT.select(PATH$minDstExtent);
    public static final StructLayout LAYOUT$maxDstExtent = (StructLayout) LAYOUT.select(PATH$maxDstExtent);

    public static final long SIZE$supportedAlpha = LAYOUT$supportedAlpha.byteSize();
    public static final long SIZE$minSrcPosition = LAYOUT$minSrcPosition.byteSize();
    public static final long SIZE$maxSrcPosition = LAYOUT$maxSrcPosition.byteSize();
    public static final long SIZE$minSrcExtent = LAYOUT$minSrcExtent.byteSize();
    public static final long SIZE$maxSrcExtent = LAYOUT$maxSrcExtent.byteSize();
    public static final long SIZE$minDstPosition = LAYOUT$minDstPosition.byteSize();
    public static final long SIZE$maxDstPosition = LAYOUT$maxDstPosition.byteSize();
    public static final long SIZE$minDstExtent = LAYOUT$minDstExtent.byteSize();
    public static final long SIZE$maxDstExtent = LAYOUT$maxDstExtent.byteSize();

    public static final long OFFSET$supportedAlpha = LAYOUT.byteOffset(PATH$supportedAlpha);
    public static final long OFFSET$minSrcPosition = LAYOUT.byteOffset(PATH$minSrcPosition);
    public static final long OFFSET$maxSrcPosition = LAYOUT.byteOffset(PATH$maxSrcPosition);
    public static final long OFFSET$minSrcExtent = LAYOUT.byteOffset(PATH$minSrcExtent);
    public static final long OFFSET$maxSrcExtent = LAYOUT.byteOffset(PATH$maxSrcExtent);
    public static final long OFFSET$minDstPosition = LAYOUT.byteOffset(PATH$minDstPosition);
    public static final long OFFSET$maxDstPosition = LAYOUT.byteOffset(PATH$maxDstPosition);
    public static final long OFFSET$minDstExtent = LAYOUT.byteOffset(PATH$minDstExtent);
    public static final long OFFSET$maxDstExtent = LAYOUT.byteOffset(PATH$maxDstExtent);
}
