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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkStridedDeviceAddressNV.html"><code>VkStridedDeviceAddressNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkStridedDeviceAddressNV {
///     VkDeviceAddress startAddress; // @link substring="startAddress" target="#startAddress"
///     VkDeviceSize strideInBytes; // @link substring="strideInBytes" target="#strideInBytes"
/// } VkStridedDeviceAddressNV;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkStridedDeviceAddressNV.html"><code>VkStridedDeviceAddressNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkStridedDeviceAddressNV(@NotNull MemorySegment segment) implements IVkStridedDeviceAddressNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkStridedDeviceAddressNV.html"><code>VkStridedDeviceAddressNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkStridedDeviceAddressNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkStridedDeviceAddressNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkStridedDeviceAddressNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkStridedDeviceAddressNV, Iterable<VkStridedDeviceAddressNV> {
        public long size() {
            return segment.byteSize() / VkStridedDeviceAddressNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkStridedDeviceAddressNV at(long index) {
            return new VkStridedDeviceAddressNV(segment.asSlice(index * VkStridedDeviceAddressNV.BYTES, VkStridedDeviceAddressNV.BYTES));
        }

        public VkStridedDeviceAddressNV.Ptr at(long index, @NotNull Consumer<@NotNull VkStridedDeviceAddressNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkStridedDeviceAddressNV value) {
            MemorySegment s = segment.asSlice(index * VkStridedDeviceAddressNV.BYTES, VkStridedDeviceAddressNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkStridedDeviceAddressNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkStridedDeviceAddressNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkStridedDeviceAddressNV.BYTES,
                (end - start) * VkStridedDeviceAddressNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkStridedDeviceAddressNV.BYTES));
        }

        public VkStridedDeviceAddressNV[] toArray() {
            VkStridedDeviceAddressNV[] ret = new VkStridedDeviceAddressNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkStridedDeviceAddressNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkStridedDeviceAddressNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkStridedDeviceAddressNV.BYTES;
            }

            @Override
            public VkStridedDeviceAddressNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkStridedDeviceAddressNV ret = new VkStridedDeviceAddressNV(segment.asSlice(0, VkStridedDeviceAddressNV.BYTES));
                segment = segment.asSlice(VkStridedDeviceAddressNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkStridedDeviceAddressNV allocate(Arena arena) {
        return new VkStridedDeviceAddressNV(arena.allocate(LAYOUT));
    }

    public static VkStridedDeviceAddressNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkStridedDeviceAddressNV.Ptr(segment);
    }

    public static VkStridedDeviceAddressNV clone(Arena arena, VkStridedDeviceAddressNV src) {
        VkStridedDeviceAddressNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NativeType("VkDeviceAddress") @Unsigned long startAddress() {
        return segment.get(LAYOUT$startAddress, OFFSET$startAddress);
    }

    public VkStridedDeviceAddressNV startAddress(@NativeType("VkDeviceAddress") @Unsigned long value) {
        segment.set(LAYOUT$startAddress, OFFSET$startAddress, value);
        return this;
    }

    public @NativeType("VkDeviceSize") @Unsigned long strideInBytes() {
        return segment.get(LAYOUT$strideInBytes, OFFSET$strideInBytes);
    }

    public VkStridedDeviceAddressNV strideInBytes(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$strideInBytes, OFFSET$strideInBytes, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_LONG.withName("startAddress"),
        ValueLayout.JAVA_LONG.withName("strideInBytes")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$startAddress = PathElement.groupElement("startAddress");
    public static final PathElement PATH$strideInBytes = PathElement.groupElement("strideInBytes");

    public static final OfLong LAYOUT$startAddress = (OfLong) LAYOUT.select(PATH$startAddress);
    public static final OfLong LAYOUT$strideInBytes = (OfLong) LAYOUT.select(PATH$strideInBytes);

    public static final long SIZE$startAddress = LAYOUT$startAddress.byteSize();
    public static final long SIZE$strideInBytes = LAYOUT$strideInBytes.byteSize();

    public static final long OFFSET$startAddress = LAYOUT.byteOffset(PATH$startAddress);
    public static final long OFFSET$strideInBytes = LAYOUT.byteOffset(PATH$strideInBytes);
}
