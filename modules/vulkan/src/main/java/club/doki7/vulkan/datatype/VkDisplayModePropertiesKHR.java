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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDisplayModePropertiesKHR.html"><code>VkDisplayModePropertiesKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDisplayModePropertiesKHR {
///     VkDisplayModeKHR displayMode; // @link substring="VkDisplayModeKHR" target="VkDisplayModeKHR" @link substring="displayMode" target="#displayMode"
///     VkDisplayModeParametersKHR parameters; // @link substring="VkDisplayModeParametersKHR" target="VkDisplayModeParametersKHR" @link substring="parameters" target="#parameters"
/// } VkDisplayModePropertiesKHR;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDisplayModePropertiesKHR.html"><code>VkDisplayModePropertiesKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDisplayModePropertiesKHR(@NotNull MemorySegment segment) implements IVkDisplayModePropertiesKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDisplayModePropertiesKHR.html"><code>VkDisplayModePropertiesKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDisplayModePropertiesKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDisplayModePropertiesKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDisplayModePropertiesKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDisplayModePropertiesKHR, Iterable<VkDisplayModePropertiesKHR> {
        public long size() {
            return segment.byteSize() / VkDisplayModePropertiesKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDisplayModePropertiesKHR at(long index) {
            return new VkDisplayModePropertiesKHR(segment.asSlice(index * VkDisplayModePropertiesKHR.BYTES, VkDisplayModePropertiesKHR.BYTES));
        }

        public VkDisplayModePropertiesKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkDisplayModePropertiesKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDisplayModePropertiesKHR value) {
            MemorySegment s = segment.asSlice(index * VkDisplayModePropertiesKHR.BYTES, VkDisplayModePropertiesKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDisplayModePropertiesKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDisplayModePropertiesKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDisplayModePropertiesKHR.BYTES,
                (end - start) * VkDisplayModePropertiesKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDisplayModePropertiesKHR.BYTES));
        }

        public VkDisplayModePropertiesKHR[] toArray() {
            VkDisplayModePropertiesKHR[] ret = new VkDisplayModePropertiesKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDisplayModePropertiesKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDisplayModePropertiesKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDisplayModePropertiesKHR.BYTES;
            }

            @Override
            public VkDisplayModePropertiesKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDisplayModePropertiesKHR ret = new VkDisplayModePropertiesKHR(segment.asSlice(0, VkDisplayModePropertiesKHR.BYTES));
                segment = segment.asSlice(VkDisplayModePropertiesKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDisplayModePropertiesKHR allocate(Arena arena) {
        return new VkDisplayModePropertiesKHR(arena.allocate(LAYOUT));
    }

    public static VkDisplayModePropertiesKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkDisplayModePropertiesKHR.Ptr(segment);
    }

    public static VkDisplayModePropertiesKHR clone(Arena arena, VkDisplayModePropertiesKHR src) {
        VkDisplayModePropertiesKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Nullable VkDisplayModeKHR displayMode() {
        MemorySegment s = segment.asSlice(OFFSET$displayMode, SIZE$displayMode);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkDisplayModeKHR(s);
    }

    public VkDisplayModePropertiesKHR displayMode(@Nullable VkDisplayModeKHR value) {
        segment.set(LAYOUT$displayMode, OFFSET$displayMode, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @NotNull VkDisplayModeParametersKHR parameters() {
        return new VkDisplayModeParametersKHR(segment.asSlice(OFFSET$parameters, LAYOUT$parameters));
    }

    public VkDisplayModePropertiesKHR parameters(@NotNull VkDisplayModeParametersKHR value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$parameters, SIZE$parameters);
        return this;
    }

    public VkDisplayModePropertiesKHR parameters(Consumer<@NotNull VkDisplayModeParametersKHR> consumer) {
        consumer.accept(parameters());
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.ADDRESS.withName("displayMode"),
        VkDisplayModeParametersKHR.LAYOUT.withName("parameters")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$displayMode = PathElement.groupElement("displayMode");
    public static final PathElement PATH$parameters = PathElement.groupElement("parameters");

    public static final AddressLayout LAYOUT$displayMode = (AddressLayout) LAYOUT.select(PATH$displayMode);
    public static final StructLayout LAYOUT$parameters = (StructLayout) LAYOUT.select(PATH$parameters);

    public static final long SIZE$displayMode = LAYOUT$displayMode.byteSize();
    public static final long SIZE$parameters = LAYOUT$parameters.byteSize();

    public static final long OFFSET$displayMode = LAYOUT.byteOffset(PATH$displayMode);
    public static final long OFFSET$parameters = LAYOUT.byteOffset(PATH$parameters);
}
