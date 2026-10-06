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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDisplayPropertiesKHR.html"><code>VkDisplayPropertiesKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDisplayPropertiesKHR {
///     VkDisplayKHR display; // @link substring="VkDisplayKHR" target="VkDisplayKHR" @link substring="display" target="#display"
///     char const* displayName; // @link substring="displayName" target="#displayName"
///     VkExtent2D physicalDimensions; // @link substring="VkExtent2D" target="VkExtent2D" @link substring="physicalDimensions" target="#physicalDimensions"
///     VkExtent2D physicalResolution; // @link substring="VkExtent2D" target="VkExtent2D" @link substring="physicalResolution" target="#physicalResolution"
///     VkSurfaceTransformFlagsKHR supportedTransforms; // optional // @link substring="VkSurfaceTransformFlagsKHR" target="VkSurfaceTransformFlagsKHR" @link substring="supportedTransforms" target="#supportedTransforms"
///     VkBool32 planeReorderPossible; // @link substring="planeReorderPossible" target="#planeReorderPossible"
///     VkBool32 persistentContent; // @link substring="persistentContent" target="#persistentContent"
/// } VkDisplayPropertiesKHR;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDisplayPropertiesKHR.html"><code>VkDisplayPropertiesKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDisplayPropertiesKHR(@NotNull MemorySegment segment) implements IVkDisplayPropertiesKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDisplayPropertiesKHR.html"><code>VkDisplayPropertiesKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDisplayPropertiesKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDisplayPropertiesKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDisplayPropertiesKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDisplayPropertiesKHR, Iterable<VkDisplayPropertiesKHR> {
        public long size() {
            return segment.byteSize() / VkDisplayPropertiesKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDisplayPropertiesKHR at(long index) {
            return new VkDisplayPropertiesKHR(segment.asSlice(index * VkDisplayPropertiesKHR.BYTES, VkDisplayPropertiesKHR.BYTES));
        }

        public VkDisplayPropertiesKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkDisplayPropertiesKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDisplayPropertiesKHR value) {
            MemorySegment s = segment.asSlice(index * VkDisplayPropertiesKHR.BYTES, VkDisplayPropertiesKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDisplayPropertiesKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDisplayPropertiesKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDisplayPropertiesKHR.BYTES,
                (end - start) * VkDisplayPropertiesKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDisplayPropertiesKHR.BYTES));
        }

        public VkDisplayPropertiesKHR[] toArray() {
            VkDisplayPropertiesKHR[] ret = new VkDisplayPropertiesKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDisplayPropertiesKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDisplayPropertiesKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDisplayPropertiesKHR.BYTES;
            }

            @Override
            public VkDisplayPropertiesKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDisplayPropertiesKHR ret = new VkDisplayPropertiesKHR(segment.asSlice(0, VkDisplayPropertiesKHR.BYTES));
                segment = segment.asSlice(VkDisplayPropertiesKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDisplayPropertiesKHR allocate(Arena arena) {
        return new VkDisplayPropertiesKHR(arena.allocate(LAYOUT));
    }

    public static VkDisplayPropertiesKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkDisplayPropertiesKHR.Ptr(segment);
    }

    public static VkDisplayPropertiesKHR clone(Arena arena, VkDisplayPropertiesKHR src) {
        VkDisplayPropertiesKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Nullable VkDisplayKHR display() {
        MemorySegment s = segment.asSlice(OFFSET$display, SIZE$display);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkDisplayKHR(s);
    }

    public VkDisplayPropertiesKHR display(@Nullable VkDisplayKHR value) {
        segment.set(LAYOUT$display, OFFSET$display, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    /// Note: the returned {@link BytePtr} does not have correct
    /// {@link BytePtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link BytePtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable BytePtr displayName() {
        MemorySegment s = displayNameRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new BytePtr(s);
    }

    public VkDisplayPropertiesKHR displayName(@Nullable BytePtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        displayNameRaw(s);
        return this;
    }

    public @Pointer(comment="int8_t*") @NotNull MemorySegment displayNameRaw() {
        return segment.get(LAYOUT$displayName, OFFSET$displayName);
    }

    public void displayNameRaw(@Pointer(comment="int8_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$displayName, OFFSET$displayName, value);
    }

    public @NotNull VkExtent2D physicalDimensions() {
        return new VkExtent2D(segment.asSlice(OFFSET$physicalDimensions, LAYOUT$physicalDimensions));
    }

    public VkDisplayPropertiesKHR physicalDimensions(@NotNull VkExtent2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$physicalDimensions, SIZE$physicalDimensions);
        return this;
    }

    public VkDisplayPropertiesKHR physicalDimensions(Consumer<@NotNull VkExtent2D> consumer) {
        consumer.accept(physicalDimensions());
        return this;
    }

    public @NotNull VkExtent2D physicalResolution() {
        return new VkExtent2D(segment.asSlice(OFFSET$physicalResolution, LAYOUT$physicalResolution));
    }

    public VkDisplayPropertiesKHR physicalResolution(@NotNull VkExtent2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$physicalResolution, SIZE$physicalResolution);
        return this;
    }

    public VkDisplayPropertiesKHR physicalResolution(Consumer<@NotNull VkExtent2D> consumer) {
        consumer.accept(physicalResolution());
        return this;
    }

    public @Bitmask(VkSurfaceTransformFlagsKHR.class) int supportedTransforms() {
        return segment.get(LAYOUT$supportedTransforms, OFFSET$supportedTransforms);
    }

    public VkDisplayPropertiesKHR supportedTransforms(@Bitmask(VkSurfaceTransformFlagsKHR.class) int value) {
        segment.set(LAYOUT$supportedTransforms, OFFSET$supportedTransforms, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int planeReorderPossible() {
        return segment.get(LAYOUT$planeReorderPossible, OFFSET$planeReorderPossible);
    }

    public VkDisplayPropertiesKHR planeReorderPossible(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$planeReorderPossible, OFFSET$planeReorderPossible, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int persistentContent() {
        return segment.get(LAYOUT$persistentContent, OFFSET$persistentContent);
    }

    public VkDisplayPropertiesKHR persistentContent(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$persistentContent, OFFSET$persistentContent, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.ADDRESS.withName("display"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE).withName("displayName"),
        VkExtent2D.LAYOUT.withName("physicalDimensions"),
        VkExtent2D.LAYOUT.withName("physicalResolution"),
        ValueLayout.JAVA_INT.withName("supportedTransforms"),
        ValueLayout.JAVA_INT.withName("planeReorderPossible"),
        ValueLayout.JAVA_INT.withName("persistentContent")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$display = PathElement.groupElement("display");
    public static final PathElement PATH$displayName = PathElement.groupElement("displayName");
    public static final PathElement PATH$physicalDimensions = PathElement.groupElement("physicalDimensions");
    public static final PathElement PATH$physicalResolution = PathElement.groupElement("physicalResolution");
    public static final PathElement PATH$supportedTransforms = PathElement.groupElement("supportedTransforms");
    public static final PathElement PATH$planeReorderPossible = PathElement.groupElement("planeReorderPossible");
    public static final PathElement PATH$persistentContent = PathElement.groupElement("persistentContent");

    public static final AddressLayout LAYOUT$display = (AddressLayout) LAYOUT.select(PATH$display);
    public static final AddressLayout LAYOUT$displayName = (AddressLayout) LAYOUT.select(PATH$displayName);
    public static final StructLayout LAYOUT$physicalDimensions = (StructLayout) LAYOUT.select(PATH$physicalDimensions);
    public static final StructLayout LAYOUT$physicalResolution = (StructLayout) LAYOUT.select(PATH$physicalResolution);
    public static final OfInt LAYOUT$supportedTransforms = (OfInt) LAYOUT.select(PATH$supportedTransforms);
    public static final OfInt LAYOUT$planeReorderPossible = (OfInt) LAYOUT.select(PATH$planeReorderPossible);
    public static final OfInt LAYOUT$persistentContent = (OfInt) LAYOUT.select(PATH$persistentContent);

    public static final long SIZE$display = LAYOUT$display.byteSize();
    public static final long SIZE$displayName = LAYOUT$displayName.byteSize();
    public static final long SIZE$physicalDimensions = LAYOUT$physicalDimensions.byteSize();
    public static final long SIZE$physicalResolution = LAYOUT$physicalResolution.byteSize();
    public static final long SIZE$supportedTransforms = LAYOUT$supportedTransforms.byteSize();
    public static final long SIZE$planeReorderPossible = LAYOUT$planeReorderPossible.byteSize();
    public static final long SIZE$persistentContent = LAYOUT$persistentContent.byteSize();

    public static final long OFFSET$display = LAYOUT.byteOffset(PATH$display);
    public static final long OFFSET$displayName = LAYOUT.byteOffset(PATH$displayName);
    public static final long OFFSET$physicalDimensions = LAYOUT.byteOffset(PATH$physicalDimensions);
    public static final long OFFSET$physicalResolution = LAYOUT.byteOffset(PATH$physicalResolution);
    public static final long OFFSET$supportedTransforms = LAYOUT.byteOffset(PATH$supportedTransforms);
    public static final long OFFSET$planeReorderPossible = LAYOUT.byteOffset(PATH$planeReorderPossible);
    public static final long OFFSET$persistentContent = LAYOUT.byteOffset(PATH$persistentContent);
}
