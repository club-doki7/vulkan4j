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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDeviceOrHostAddressConstKHR.html"><code>VkDeviceOrHostAddressConstKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef union VkDeviceOrHostAddressConstKHR {
///     VkDeviceAddress deviceAddress; // @link substring="deviceAddress" target="#deviceAddress"
///     void const* hostAddress; // @link substring="hostAddress" target="#hostAddress"
/// } VkDeviceOrHostAddressConstKHR;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDeviceOrHostAddressConstKHR.html"><code>VkDeviceOrHostAddressConstKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDeviceOrHostAddressConstKHR(@NotNull MemorySegment segment) implements IVkDeviceOrHostAddressConstKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDeviceOrHostAddressConstKHR.html"><code>VkDeviceOrHostAddressConstKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDeviceOrHostAddressConstKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDeviceOrHostAddressConstKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDeviceOrHostAddressConstKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDeviceOrHostAddressConstKHR, Iterable<VkDeviceOrHostAddressConstKHR> {
        public long size() {
            return segment.byteSize() / VkDeviceOrHostAddressConstKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDeviceOrHostAddressConstKHR at(long index) {
            return new VkDeviceOrHostAddressConstKHR(segment.asSlice(index * VkDeviceOrHostAddressConstKHR.BYTES, VkDeviceOrHostAddressConstKHR.BYTES));
        }

        public VkDeviceOrHostAddressConstKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkDeviceOrHostAddressConstKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDeviceOrHostAddressConstKHR value) {
            MemorySegment s = segment.asSlice(index * VkDeviceOrHostAddressConstKHR.BYTES, VkDeviceOrHostAddressConstKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDeviceOrHostAddressConstKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDeviceOrHostAddressConstKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDeviceOrHostAddressConstKHR.BYTES,
                (end - start) * VkDeviceOrHostAddressConstKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDeviceOrHostAddressConstKHR.BYTES));
        }

        public VkDeviceOrHostAddressConstKHR[] toArray() {
            VkDeviceOrHostAddressConstKHR[] ret = new VkDeviceOrHostAddressConstKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDeviceOrHostAddressConstKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDeviceOrHostAddressConstKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDeviceOrHostAddressConstKHR.BYTES;
            }

            @Override
            public VkDeviceOrHostAddressConstKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDeviceOrHostAddressConstKHR ret = new VkDeviceOrHostAddressConstKHR(segment.asSlice(0, VkDeviceOrHostAddressConstKHR.BYTES));
                segment = segment.asSlice(VkDeviceOrHostAddressConstKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDeviceOrHostAddressConstKHR allocate(Arena arena) {
        return new VkDeviceOrHostAddressConstKHR(arena.allocate(LAYOUT));
    }

    public static VkDeviceOrHostAddressConstKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkDeviceOrHostAddressConstKHR.Ptr(segment);
    }

    public static VkDeviceOrHostAddressConstKHR clone(Arena arena, VkDeviceOrHostAddressConstKHR src) {
        VkDeviceOrHostAddressConstKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NativeType("VkDeviceAddress") @Unsigned long deviceAddress() {
        return segment.get(LAYOUT$deviceAddress, OFFSET$deviceAddress);
    }

    public VkDeviceOrHostAddressConstKHR deviceAddress(@NativeType("VkDeviceAddress") @Unsigned long value) {
        segment.set(LAYOUT$deviceAddress, OFFSET$deviceAddress, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment hostAddress() {
        return segment.get(LAYOUT$hostAddress, OFFSET$hostAddress);
    }

    public VkDeviceOrHostAddressConstKHR hostAddress(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$hostAddress, OFFSET$hostAddress, value);
        return this;
    }

    public VkDeviceOrHostAddressConstKHR hostAddress(@Nullable IPointer pointer) {
        hostAddress(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public static final UnionLayout LAYOUT = NativeLayout.unionLayout(
        ValueLayout.JAVA_LONG.withName("deviceAddress"),
        ValueLayout.ADDRESS.withName("hostAddress")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$deviceAddress = PathElement.groupElement("deviceAddress");
    public static final PathElement PATH$hostAddress = PathElement.groupElement("hostAddress");

    public static final OfLong LAYOUT$deviceAddress = (OfLong) LAYOUT.select(PATH$deviceAddress);
    public static final AddressLayout LAYOUT$hostAddress = (AddressLayout) LAYOUT.select(PATH$hostAddress);

    public static final long SIZE$deviceAddress = LAYOUT$deviceAddress.byteSize();
    public static final long SIZE$hostAddress = LAYOUT$hostAddress.byteSize();

    public static final long OFFSET$deviceAddress = LAYOUT.byteOffset(PATH$deviceAddress);
    public static final long OFFSET$hostAddress = LAYOUT.byteOffset(PATH$hostAddress);
}
