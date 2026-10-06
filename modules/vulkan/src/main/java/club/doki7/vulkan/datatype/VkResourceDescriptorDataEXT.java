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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkResourceDescriptorDataEXT.html"><code>VkResourceDescriptorDataEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef union VkResourceDescriptorDataEXT {
///     VkImageDescriptorInfoEXT const* pImage; // optional // @link substring="VkImageDescriptorInfoEXT" target="VkImageDescriptorInfoEXT" @link substring="pImage" target="#pImage"
///     VkTexelBufferDescriptorInfoEXT const* pTexelBuffer; // optional // @link substring="VkTexelBufferDescriptorInfoEXT" target="VkTexelBufferDescriptorInfoEXT" @link substring="pTexelBuffer" target="#pTexelBuffer"
///     VkDeviceAddressRangeEXT const* pAddressRange; // optional // @link substring="VkDeviceAddressRangeKHR" target="VkDeviceAddressRangeEXT" @link substring="pAddressRange" target="#pAddressRange"
///     VkTensorViewCreateInfoARM const* pTensorARM; // optional // @link substring="VkTensorViewCreateInfoARM" target="VkTensorViewCreateInfoARM" @link substring="pTensorARM" target="#pTensorARM"
/// } VkResourceDescriptorDataEXT;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkResourceDescriptorDataEXT.html"><code>VkResourceDescriptorDataEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkResourceDescriptorDataEXT(@NotNull MemorySegment segment) implements IVkResourceDescriptorDataEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkResourceDescriptorDataEXT.html"><code>VkResourceDescriptorDataEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkResourceDescriptorDataEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkResourceDescriptorDataEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkResourceDescriptorDataEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkResourceDescriptorDataEXT, Iterable<VkResourceDescriptorDataEXT> {
        public long size() {
            return segment.byteSize() / VkResourceDescriptorDataEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkResourceDescriptorDataEXT at(long index) {
            return new VkResourceDescriptorDataEXT(segment.asSlice(index * VkResourceDescriptorDataEXT.BYTES, VkResourceDescriptorDataEXT.BYTES));
        }

        public VkResourceDescriptorDataEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkResourceDescriptorDataEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkResourceDescriptorDataEXT value) {
            MemorySegment s = segment.asSlice(index * VkResourceDescriptorDataEXT.BYTES, VkResourceDescriptorDataEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkResourceDescriptorDataEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkResourceDescriptorDataEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkResourceDescriptorDataEXT.BYTES,
                (end - start) * VkResourceDescriptorDataEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkResourceDescriptorDataEXT.BYTES));
        }

        public VkResourceDescriptorDataEXT[] toArray() {
            VkResourceDescriptorDataEXT[] ret = new VkResourceDescriptorDataEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkResourceDescriptorDataEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkResourceDescriptorDataEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkResourceDescriptorDataEXT.BYTES;
            }

            @Override
            public VkResourceDescriptorDataEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkResourceDescriptorDataEXT ret = new VkResourceDescriptorDataEXT(segment.asSlice(0, VkResourceDescriptorDataEXT.BYTES));
                segment = segment.asSlice(VkResourceDescriptorDataEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkResourceDescriptorDataEXT allocate(Arena arena) {
        return new VkResourceDescriptorDataEXT(arena.allocate(LAYOUT));
    }

    public static VkResourceDescriptorDataEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkResourceDescriptorDataEXT.Ptr(segment);
    }

    public static VkResourceDescriptorDataEXT clone(Arena arena, VkResourceDescriptorDataEXT src) {
        VkResourceDescriptorDataEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public VkResourceDescriptorDataEXT pImage(@Nullable IVkImageDescriptorInfoEXT value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pImageRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkImageDescriptorInfoEXT.Ptr pImage(int assumedCount) {
        MemorySegment s = pImageRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkImageDescriptorInfoEXT.BYTES);
        return new VkImageDescriptorInfoEXT.Ptr(s);
    }

    public @Nullable VkImageDescriptorInfoEXT pImage() {
        MemorySegment s = pImageRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkImageDescriptorInfoEXT(s);
    }

    public @Pointer(target=VkImageDescriptorInfoEXT.class) @NotNull MemorySegment pImageRaw() {
        return segment.get(LAYOUT$pImage, OFFSET$pImage);
    }

    public void pImageRaw(@Pointer(target=VkImageDescriptorInfoEXT.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pImage, OFFSET$pImage, value);
    }

    public VkResourceDescriptorDataEXT pTexelBuffer(@Nullable IVkTexelBufferDescriptorInfoEXT value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pTexelBufferRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkTexelBufferDescriptorInfoEXT.Ptr pTexelBuffer(int assumedCount) {
        MemorySegment s = pTexelBufferRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkTexelBufferDescriptorInfoEXT.BYTES);
        return new VkTexelBufferDescriptorInfoEXT.Ptr(s);
    }

    public @Nullable VkTexelBufferDescriptorInfoEXT pTexelBuffer() {
        MemorySegment s = pTexelBufferRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkTexelBufferDescriptorInfoEXT(s);
    }

    public @Pointer(target=VkTexelBufferDescriptorInfoEXT.class) @NotNull MemorySegment pTexelBufferRaw() {
        return segment.get(LAYOUT$pTexelBuffer, OFFSET$pTexelBuffer);
    }

    public void pTexelBufferRaw(@Pointer(target=VkTexelBufferDescriptorInfoEXT.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pTexelBuffer, OFFSET$pTexelBuffer, value);
    }

    public VkResourceDescriptorDataEXT pAddressRange(@Nullable IVkDeviceAddressRangeKHR value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pAddressRangeRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkDeviceAddressRangeKHR.Ptr pAddressRange(int assumedCount) {
        MemorySegment s = pAddressRangeRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkDeviceAddressRangeKHR.BYTES);
        return new VkDeviceAddressRangeKHR.Ptr(s);
    }

    public @Nullable VkDeviceAddressRangeKHR pAddressRange() {
        MemorySegment s = pAddressRangeRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkDeviceAddressRangeKHR(s);
    }

    public @Pointer(target=VkDeviceAddressRangeKHR.class) @NotNull MemorySegment pAddressRangeRaw() {
        return segment.get(LAYOUT$pAddressRange, OFFSET$pAddressRange);
    }

    public void pAddressRangeRaw(@Pointer(target=VkDeviceAddressRangeKHR.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pAddressRange, OFFSET$pAddressRange, value);
    }

    public VkResourceDescriptorDataEXT pTensorARM(@Nullable IVkTensorViewCreateInfoARM value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pTensorARMRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkTensorViewCreateInfoARM.Ptr pTensorARM(int assumedCount) {
        MemorySegment s = pTensorARMRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkTensorViewCreateInfoARM.BYTES);
        return new VkTensorViewCreateInfoARM.Ptr(s);
    }

    public @Nullable VkTensorViewCreateInfoARM pTensorARM() {
        MemorySegment s = pTensorARMRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkTensorViewCreateInfoARM(s);
    }

    public @Pointer(target=VkTensorViewCreateInfoARM.class) @NotNull MemorySegment pTensorARMRaw() {
        return segment.get(LAYOUT$pTensorARM, OFFSET$pTensorARM);
    }

    public void pTensorARMRaw(@Pointer(target=VkTensorViewCreateInfoARM.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pTensorARM, OFFSET$pTensorARM, value);
    }

    public static final UnionLayout LAYOUT = NativeLayout.unionLayout(
        ValueLayout.ADDRESS.withTargetLayout(VkImageDescriptorInfoEXT.LAYOUT).withName("pImage"),
        ValueLayout.ADDRESS.withTargetLayout(VkTexelBufferDescriptorInfoEXT.LAYOUT).withName("pTexelBuffer"),
        ValueLayout.ADDRESS.withTargetLayout(VkDeviceAddressRangeKHR.LAYOUT).withName("pAddressRange"),
        ValueLayout.ADDRESS.withTargetLayout(VkTensorViewCreateInfoARM.LAYOUT).withName("pTensorARM")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$pImage = PathElement.groupElement("pImage");
    public static final PathElement PATH$pTexelBuffer = PathElement.groupElement("pTexelBuffer");
    public static final PathElement PATH$pAddressRange = PathElement.groupElement("pAddressRange");
    public static final PathElement PATH$pTensorARM = PathElement.groupElement("pTensorARM");

    public static final AddressLayout LAYOUT$pImage = (AddressLayout) LAYOUT.select(PATH$pImage);
    public static final AddressLayout LAYOUT$pTexelBuffer = (AddressLayout) LAYOUT.select(PATH$pTexelBuffer);
    public static final AddressLayout LAYOUT$pAddressRange = (AddressLayout) LAYOUT.select(PATH$pAddressRange);
    public static final AddressLayout LAYOUT$pTensorARM = (AddressLayout) LAYOUT.select(PATH$pTensorARM);

    public static final long SIZE$pImage = LAYOUT$pImage.byteSize();
    public static final long SIZE$pTexelBuffer = LAYOUT$pTexelBuffer.byteSize();
    public static final long SIZE$pAddressRange = LAYOUT$pAddressRange.byteSize();
    public static final long SIZE$pTensorARM = LAYOUT$pTensorARM.byteSize();

    public static final long OFFSET$pImage = LAYOUT.byteOffset(PATH$pImage);
    public static final long OFFSET$pTexelBuffer = LAYOUT.byteOffset(PATH$pTexelBuffer);
    public static final long OFFSET$pAddressRange = LAYOUT.byteOffset(PATH$pAddressRange);
    public static final long OFFSET$pTensorARM = LAYOUT.byteOffset(PATH$pTensorARM);
}
