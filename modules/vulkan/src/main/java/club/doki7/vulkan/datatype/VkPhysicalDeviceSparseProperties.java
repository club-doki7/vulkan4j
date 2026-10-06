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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceSparseProperties.html"><code>VkPhysicalDeviceSparseProperties</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceSparseProperties {
///     VkBool32 residencyStandard2DBlockShape; // @link substring="residencyStandard2DBlockShape" target="#residencyStandard2DBlockShape"
///     VkBool32 residencyStandard2DMultisampleBlockShape; // @link substring="residencyStandard2DMultisampleBlockShape" target="#residencyStandard2DMultisampleBlockShape"
///     VkBool32 residencyStandard3DBlockShape; // @link substring="residencyStandard3DBlockShape" target="#residencyStandard3DBlockShape"
///     VkBool32 residencyAlignedMipSize; // @link substring="residencyAlignedMipSize" target="#residencyAlignedMipSize"
///     VkBool32 residencyNonResidentStrict; // @link substring="residencyNonResidentStrict" target="#residencyNonResidentStrict"
/// } VkPhysicalDeviceSparseProperties;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceSparseProperties.html"><code>VkPhysicalDeviceSparseProperties</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceSparseProperties(@NotNull MemorySegment segment) implements IVkPhysicalDeviceSparseProperties {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceSparseProperties.html"><code>VkPhysicalDeviceSparseProperties</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceSparseProperties}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceSparseProperties to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceSparseProperties.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceSparseProperties, Iterable<VkPhysicalDeviceSparseProperties> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceSparseProperties.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceSparseProperties at(long index) {
            return new VkPhysicalDeviceSparseProperties(segment.asSlice(index * VkPhysicalDeviceSparseProperties.BYTES, VkPhysicalDeviceSparseProperties.BYTES));
        }

        public VkPhysicalDeviceSparseProperties.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceSparseProperties> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceSparseProperties value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceSparseProperties.BYTES, VkPhysicalDeviceSparseProperties.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceSparseProperties.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceSparseProperties.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceSparseProperties.BYTES,
                (end - start) * VkPhysicalDeviceSparseProperties.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceSparseProperties.BYTES));
        }

        public VkPhysicalDeviceSparseProperties[] toArray() {
            VkPhysicalDeviceSparseProperties[] ret = new VkPhysicalDeviceSparseProperties[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceSparseProperties> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceSparseProperties> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceSparseProperties.BYTES;
            }

            @Override
            public VkPhysicalDeviceSparseProperties next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceSparseProperties ret = new VkPhysicalDeviceSparseProperties(segment.asSlice(0, VkPhysicalDeviceSparseProperties.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceSparseProperties.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceSparseProperties allocate(Arena arena) {
        return new VkPhysicalDeviceSparseProperties(arena.allocate(LAYOUT));
    }

    public static VkPhysicalDeviceSparseProperties.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkPhysicalDeviceSparseProperties.Ptr(segment);
    }

    public static VkPhysicalDeviceSparseProperties clone(Arena arena, VkPhysicalDeviceSparseProperties src) {
        VkPhysicalDeviceSparseProperties ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NativeType("VkBool32") @Unsigned int residencyStandard2DBlockShape() {
        return segment.get(LAYOUT$residencyStandard2DBlockShape, OFFSET$residencyStandard2DBlockShape);
    }

    public VkPhysicalDeviceSparseProperties residencyStandard2DBlockShape(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$residencyStandard2DBlockShape, OFFSET$residencyStandard2DBlockShape, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int residencyStandard2DMultisampleBlockShape() {
        return segment.get(LAYOUT$residencyStandard2DMultisampleBlockShape, OFFSET$residencyStandard2DMultisampleBlockShape);
    }

    public VkPhysicalDeviceSparseProperties residencyStandard2DMultisampleBlockShape(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$residencyStandard2DMultisampleBlockShape, OFFSET$residencyStandard2DMultisampleBlockShape, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int residencyStandard3DBlockShape() {
        return segment.get(LAYOUT$residencyStandard3DBlockShape, OFFSET$residencyStandard3DBlockShape);
    }

    public VkPhysicalDeviceSparseProperties residencyStandard3DBlockShape(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$residencyStandard3DBlockShape, OFFSET$residencyStandard3DBlockShape, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int residencyAlignedMipSize() {
        return segment.get(LAYOUT$residencyAlignedMipSize, OFFSET$residencyAlignedMipSize);
    }

    public VkPhysicalDeviceSparseProperties residencyAlignedMipSize(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$residencyAlignedMipSize, OFFSET$residencyAlignedMipSize, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int residencyNonResidentStrict() {
        return segment.get(LAYOUT$residencyNonResidentStrict, OFFSET$residencyNonResidentStrict);
    }

    public VkPhysicalDeviceSparseProperties residencyNonResidentStrict(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$residencyNonResidentStrict, OFFSET$residencyNonResidentStrict, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("residencyStandard2DBlockShape"),
        ValueLayout.JAVA_INT.withName("residencyStandard2DMultisampleBlockShape"),
        ValueLayout.JAVA_INT.withName("residencyStandard3DBlockShape"),
        ValueLayout.JAVA_INT.withName("residencyAlignedMipSize"),
        ValueLayout.JAVA_INT.withName("residencyNonResidentStrict")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$residencyStandard2DBlockShape = PathElement.groupElement("residencyStandard2DBlockShape");
    public static final PathElement PATH$residencyStandard2DMultisampleBlockShape = PathElement.groupElement("residencyStandard2DMultisampleBlockShape");
    public static final PathElement PATH$residencyStandard3DBlockShape = PathElement.groupElement("residencyStandard3DBlockShape");
    public static final PathElement PATH$residencyAlignedMipSize = PathElement.groupElement("residencyAlignedMipSize");
    public static final PathElement PATH$residencyNonResidentStrict = PathElement.groupElement("residencyNonResidentStrict");

    public static final OfInt LAYOUT$residencyStandard2DBlockShape = (OfInt) LAYOUT.select(PATH$residencyStandard2DBlockShape);
    public static final OfInt LAYOUT$residencyStandard2DMultisampleBlockShape = (OfInt) LAYOUT.select(PATH$residencyStandard2DMultisampleBlockShape);
    public static final OfInt LAYOUT$residencyStandard3DBlockShape = (OfInt) LAYOUT.select(PATH$residencyStandard3DBlockShape);
    public static final OfInt LAYOUT$residencyAlignedMipSize = (OfInt) LAYOUT.select(PATH$residencyAlignedMipSize);
    public static final OfInt LAYOUT$residencyNonResidentStrict = (OfInt) LAYOUT.select(PATH$residencyNonResidentStrict);

    public static final long SIZE$residencyStandard2DBlockShape = LAYOUT$residencyStandard2DBlockShape.byteSize();
    public static final long SIZE$residencyStandard2DMultisampleBlockShape = LAYOUT$residencyStandard2DMultisampleBlockShape.byteSize();
    public static final long SIZE$residencyStandard3DBlockShape = LAYOUT$residencyStandard3DBlockShape.byteSize();
    public static final long SIZE$residencyAlignedMipSize = LAYOUT$residencyAlignedMipSize.byteSize();
    public static final long SIZE$residencyNonResidentStrict = LAYOUT$residencyNonResidentStrict.byteSize();

    public static final long OFFSET$residencyStandard2DBlockShape = LAYOUT.byteOffset(PATH$residencyStandard2DBlockShape);
    public static final long OFFSET$residencyStandard2DMultisampleBlockShape = LAYOUT.byteOffset(PATH$residencyStandard2DMultisampleBlockShape);
    public static final long OFFSET$residencyStandard3DBlockShape = LAYOUT.byteOffset(PATH$residencyStandard3DBlockShape);
    public static final long OFFSET$residencyAlignedMipSize = LAYOUT.byteOffset(PATH$residencyAlignedMipSize);
    public static final long OFFSET$residencyNonResidentStrict = LAYOUT.byteOffset(PATH$residencyNonResidentStrict);
}
