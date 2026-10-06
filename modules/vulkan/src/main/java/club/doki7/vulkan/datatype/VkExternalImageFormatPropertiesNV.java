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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkExternalImageFormatPropertiesNV.html"><code>VkExternalImageFormatPropertiesNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkExternalImageFormatPropertiesNV {
///     VkImageFormatProperties imageFormatProperties; // @link substring="VkImageFormatProperties" target="VkImageFormatProperties" @link substring="imageFormatProperties" target="#imageFormatProperties"
///     VkExternalMemoryFeatureFlagsNV externalMemoryFeatures; // optional // @link substring="VkExternalMemoryFeatureFlagsNV" target="VkExternalMemoryFeatureFlagsNV" @link substring="externalMemoryFeatures" target="#externalMemoryFeatures"
///     VkExternalMemoryHandleTypeFlagsNV exportFromImportedHandleTypes; // optional // @link substring="VkExternalMemoryHandleTypeFlagsNV" target="VkExternalMemoryHandleTypeFlagsNV" @link substring="exportFromImportedHandleTypes" target="#exportFromImportedHandleTypes"
///     VkExternalMemoryHandleTypeFlagsNV compatibleHandleTypes; // optional // @link substring="VkExternalMemoryHandleTypeFlagsNV" target="VkExternalMemoryHandleTypeFlagsNV" @link substring="compatibleHandleTypes" target="#compatibleHandleTypes"
/// } VkExternalImageFormatPropertiesNV;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkExternalImageFormatPropertiesNV.html"><code>VkExternalImageFormatPropertiesNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkExternalImageFormatPropertiesNV(@NotNull MemorySegment segment) implements IVkExternalImageFormatPropertiesNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkExternalImageFormatPropertiesNV.html"><code>VkExternalImageFormatPropertiesNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkExternalImageFormatPropertiesNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkExternalImageFormatPropertiesNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkExternalImageFormatPropertiesNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkExternalImageFormatPropertiesNV, Iterable<VkExternalImageFormatPropertiesNV> {
        public long size() {
            return segment.byteSize() / VkExternalImageFormatPropertiesNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkExternalImageFormatPropertiesNV at(long index) {
            return new VkExternalImageFormatPropertiesNV(segment.asSlice(index * VkExternalImageFormatPropertiesNV.BYTES, VkExternalImageFormatPropertiesNV.BYTES));
        }

        public VkExternalImageFormatPropertiesNV.Ptr at(long index, @NotNull Consumer<@NotNull VkExternalImageFormatPropertiesNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkExternalImageFormatPropertiesNV value) {
            MemorySegment s = segment.asSlice(index * VkExternalImageFormatPropertiesNV.BYTES, VkExternalImageFormatPropertiesNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkExternalImageFormatPropertiesNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkExternalImageFormatPropertiesNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkExternalImageFormatPropertiesNV.BYTES,
                (end - start) * VkExternalImageFormatPropertiesNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkExternalImageFormatPropertiesNV.BYTES));
        }

        public VkExternalImageFormatPropertiesNV[] toArray() {
            VkExternalImageFormatPropertiesNV[] ret = new VkExternalImageFormatPropertiesNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkExternalImageFormatPropertiesNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkExternalImageFormatPropertiesNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkExternalImageFormatPropertiesNV.BYTES;
            }

            @Override
            public VkExternalImageFormatPropertiesNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkExternalImageFormatPropertiesNV ret = new VkExternalImageFormatPropertiesNV(segment.asSlice(0, VkExternalImageFormatPropertiesNV.BYTES));
                segment = segment.asSlice(VkExternalImageFormatPropertiesNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkExternalImageFormatPropertiesNV allocate(Arena arena) {
        return new VkExternalImageFormatPropertiesNV(arena.allocate(LAYOUT));
    }

    public static VkExternalImageFormatPropertiesNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkExternalImageFormatPropertiesNV.Ptr(segment);
    }

    public static VkExternalImageFormatPropertiesNV clone(Arena arena, VkExternalImageFormatPropertiesNV src) {
        VkExternalImageFormatPropertiesNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NotNull VkImageFormatProperties imageFormatProperties() {
        return new VkImageFormatProperties(segment.asSlice(OFFSET$imageFormatProperties, LAYOUT$imageFormatProperties));
    }

    public VkExternalImageFormatPropertiesNV imageFormatProperties(@NotNull VkImageFormatProperties value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$imageFormatProperties, SIZE$imageFormatProperties);
        return this;
    }

    public VkExternalImageFormatPropertiesNV imageFormatProperties(Consumer<@NotNull VkImageFormatProperties> consumer) {
        consumer.accept(imageFormatProperties());
        return this;
    }

    public @Bitmask(VkExternalMemoryFeatureFlagsNV.class) int externalMemoryFeatures() {
        return segment.get(LAYOUT$externalMemoryFeatures, OFFSET$externalMemoryFeatures);
    }

    public VkExternalImageFormatPropertiesNV externalMemoryFeatures(@Bitmask(VkExternalMemoryFeatureFlagsNV.class) int value) {
        segment.set(LAYOUT$externalMemoryFeatures, OFFSET$externalMemoryFeatures, value);
        return this;
    }

    public @Bitmask(VkExternalMemoryHandleTypeFlagsNV.class) int exportFromImportedHandleTypes() {
        return segment.get(LAYOUT$exportFromImportedHandleTypes, OFFSET$exportFromImportedHandleTypes);
    }

    public VkExternalImageFormatPropertiesNV exportFromImportedHandleTypes(@Bitmask(VkExternalMemoryHandleTypeFlagsNV.class) int value) {
        segment.set(LAYOUT$exportFromImportedHandleTypes, OFFSET$exportFromImportedHandleTypes, value);
        return this;
    }

    public @Bitmask(VkExternalMemoryHandleTypeFlagsNV.class) int compatibleHandleTypes() {
        return segment.get(LAYOUT$compatibleHandleTypes, OFFSET$compatibleHandleTypes);
    }

    public VkExternalImageFormatPropertiesNV compatibleHandleTypes(@Bitmask(VkExternalMemoryHandleTypeFlagsNV.class) int value) {
        segment.set(LAYOUT$compatibleHandleTypes, OFFSET$compatibleHandleTypes, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        VkImageFormatProperties.LAYOUT.withName("imageFormatProperties"),
        ValueLayout.JAVA_INT.withName("externalMemoryFeatures"),
        ValueLayout.JAVA_INT.withName("exportFromImportedHandleTypes"),
        ValueLayout.JAVA_INT.withName("compatibleHandleTypes")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$imageFormatProperties = PathElement.groupElement("imageFormatProperties");
    public static final PathElement PATH$externalMemoryFeatures = PathElement.groupElement("externalMemoryFeatures");
    public static final PathElement PATH$exportFromImportedHandleTypes = PathElement.groupElement("exportFromImportedHandleTypes");
    public static final PathElement PATH$compatibleHandleTypes = PathElement.groupElement("compatibleHandleTypes");

    public static final StructLayout LAYOUT$imageFormatProperties = (StructLayout) LAYOUT.select(PATH$imageFormatProperties);
    public static final OfInt LAYOUT$externalMemoryFeatures = (OfInt) LAYOUT.select(PATH$externalMemoryFeatures);
    public static final OfInt LAYOUT$exportFromImportedHandleTypes = (OfInt) LAYOUT.select(PATH$exportFromImportedHandleTypes);
    public static final OfInt LAYOUT$compatibleHandleTypes = (OfInt) LAYOUT.select(PATH$compatibleHandleTypes);

    public static final long SIZE$imageFormatProperties = LAYOUT$imageFormatProperties.byteSize();
    public static final long SIZE$externalMemoryFeatures = LAYOUT$externalMemoryFeatures.byteSize();
    public static final long SIZE$exportFromImportedHandleTypes = LAYOUT$exportFromImportedHandleTypes.byteSize();
    public static final long SIZE$compatibleHandleTypes = LAYOUT$compatibleHandleTypes.byteSize();

    public static final long OFFSET$imageFormatProperties = LAYOUT.byteOffset(PATH$imageFormatProperties);
    public static final long OFFSET$externalMemoryFeatures = LAYOUT.byteOffset(PATH$externalMemoryFeatures);
    public static final long OFFSET$exportFromImportedHandleTypes = LAYOUT.byteOffset(PATH$exportFromImportedHandleTypes);
    public static final long OFFSET$compatibleHandleTypes = LAYOUT.byteOffset(PATH$compatibleHandleTypes);
}
