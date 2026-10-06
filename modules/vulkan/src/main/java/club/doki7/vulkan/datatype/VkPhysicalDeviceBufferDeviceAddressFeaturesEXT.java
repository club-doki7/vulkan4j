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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceBufferDeviceAddressFeaturesEXT.html"><code>VkPhysicalDeviceBufferDeviceAddressFeaturesEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceBufferDeviceAddressFeaturesEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 bufferDeviceAddress; // @link substring="bufferDeviceAddress" target="#bufferDeviceAddress"
///     VkBool32 bufferDeviceAddressCaptureReplay; // @link substring="bufferDeviceAddressCaptureReplay" target="#bufferDeviceAddressCaptureReplay"
///     VkBool32 bufferDeviceAddressMultiDevice; // @link substring="bufferDeviceAddressMultiDevice" target="#bufferDeviceAddressMultiDevice"
/// } VkPhysicalDeviceBufferDeviceAddressFeaturesEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_BUFFER_DEVICE_ADDRESS_FEATURES_EXT`
///
/// The {@code allocate} ({@link VkPhysicalDeviceBufferDeviceAddressFeaturesEXT#allocate(Arena)}, {@link VkPhysicalDeviceBufferDeviceAddressFeaturesEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceBufferDeviceAddressFeaturesEXT#autoInit}
/// to initialize these fields manually for non-allocated instances.
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceBufferDeviceAddressFeaturesEXT.html"><code>VkPhysicalDeviceBufferDeviceAddressFeaturesEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceBufferDeviceAddressFeaturesEXT(@NotNull MemorySegment segment) implements IVkPhysicalDeviceBufferDeviceAddressFeaturesEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceBufferDeviceAddressFeaturesEXT.html"><code>VkPhysicalDeviceBufferDeviceAddressFeaturesEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceBufferDeviceAddressFeaturesEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceBufferDeviceAddressFeaturesEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceBufferDeviceAddressFeaturesEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceBufferDeviceAddressFeaturesEXT, Iterable<VkPhysicalDeviceBufferDeviceAddressFeaturesEXT> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceBufferDeviceAddressFeaturesEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceBufferDeviceAddressFeaturesEXT at(long index) {
            return new VkPhysicalDeviceBufferDeviceAddressFeaturesEXT(segment.asSlice(index * VkPhysicalDeviceBufferDeviceAddressFeaturesEXT.BYTES, VkPhysicalDeviceBufferDeviceAddressFeaturesEXT.BYTES));
        }

        public VkPhysicalDeviceBufferDeviceAddressFeaturesEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceBufferDeviceAddressFeaturesEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceBufferDeviceAddressFeaturesEXT value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceBufferDeviceAddressFeaturesEXT.BYTES, VkPhysicalDeviceBufferDeviceAddressFeaturesEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceBufferDeviceAddressFeaturesEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceBufferDeviceAddressFeaturesEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceBufferDeviceAddressFeaturesEXT.BYTES,
                (end - start) * VkPhysicalDeviceBufferDeviceAddressFeaturesEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceBufferDeviceAddressFeaturesEXT.BYTES));
        }

        public VkPhysicalDeviceBufferDeviceAddressFeaturesEXT[] toArray() {
            VkPhysicalDeviceBufferDeviceAddressFeaturesEXT[] ret = new VkPhysicalDeviceBufferDeviceAddressFeaturesEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceBufferDeviceAddressFeaturesEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceBufferDeviceAddressFeaturesEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceBufferDeviceAddressFeaturesEXT.BYTES;
            }

            @Override
            public VkPhysicalDeviceBufferDeviceAddressFeaturesEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceBufferDeviceAddressFeaturesEXT ret = new VkPhysicalDeviceBufferDeviceAddressFeaturesEXT(segment.asSlice(0, VkPhysicalDeviceBufferDeviceAddressFeaturesEXT.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceBufferDeviceAddressFeaturesEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceBufferDeviceAddressFeaturesEXT allocate(Arena arena) {
        VkPhysicalDeviceBufferDeviceAddressFeaturesEXT ret = new VkPhysicalDeviceBufferDeviceAddressFeaturesEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_BUFFER_DEVICE_ADDRESS_FEATURES_EXT);
        return ret;
    }

    public static VkPhysicalDeviceBufferDeviceAddressFeaturesEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceBufferDeviceAddressFeaturesEXT.Ptr ret = new VkPhysicalDeviceBufferDeviceAddressFeaturesEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_BUFFER_DEVICE_ADDRESS_FEATURES_EXT);
        }
        return ret;
    }

    public static VkPhysicalDeviceBufferDeviceAddressFeaturesEXT clone(Arena arena, VkPhysicalDeviceBufferDeviceAddressFeaturesEXT src) {
        VkPhysicalDeviceBufferDeviceAddressFeaturesEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_BUFFER_DEVICE_ADDRESS_FEATURES_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceBufferDeviceAddressFeaturesEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceBufferDeviceAddressFeaturesEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceBufferDeviceAddressFeaturesEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int bufferDeviceAddress() {
        return segment.get(LAYOUT$bufferDeviceAddress, OFFSET$bufferDeviceAddress);
    }

    public VkPhysicalDeviceBufferDeviceAddressFeaturesEXT bufferDeviceAddress(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$bufferDeviceAddress, OFFSET$bufferDeviceAddress, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int bufferDeviceAddressCaptureReplay() {
        return segment.get(LAYOUT$bufferDeviceAddressCaptureReplay, OFFSET$bufferDeviceAddressCaptureReplay);
    }

    public VkPhysicalDeviceBufferDeviceAddressFeaturesEXT bufferDeviceAddressCaptureReplay(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$bufferDeviceAddressCaptureReplay, OFFSET$bufferDeviceAddressCaptureReplay, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int bufferDeviceAddressMultiDevice() {
        return segment.get(LAYOUT$bufferDeviceAddressMultiDevice, OFFSET$bufferDeviceAddressMultiDevice);
    }

    public VkPhysicalDeviceBufferDeviceAddressFeaturesEXT bufferDeviceAddressMultiDevice(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$bufferDeviceAddressMultiDevice, OFFSET$bufferDeviceAddressMultiDevice, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("bufferDeviceAddress"),
        ValueLayout.JAVA_INT.withName("bufferDeviceAddressCaptureReplay"),
        ValueLayout.JAVA_INT.withName("bufferDeviceAddressMultiDevice")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$bufferDeviceAddress = PathElement.groupElement("bufferDeviceAddress");
    public static final PathElement PATH$bufferDeviceAddressCaptureReplay = PathElement.groupElement("bufferDeviceAddressCaptureReplay");
    public static final PathElement PATH$bufferDeviceAddressMultiDevice = PathElement.groupElement("bufferDeviceAddressMultiDevice");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$bufferDeviceAddress = (OfInt) LAYOUT.select(PATH$bufferDeviceAddress);
    public static final OfInt LAYOUT$bufferDeviceAddressCaptureReplay = (OfInt) LAYOUT.select(PATH$bufferDeviceAddressCaptureReplay);
    public static final OfInt LAYOUT$bufferDeviceAddressMultiDevice = (OfInt) LAYOUT.select(PATH$bufferDeviceAddressMultiDevice);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$bufferDeviceAddress = LAYOUT$bufferDeviceAddress.byteSize();
    public static final long SIZE$bufferDeviceAddressCaptureReplay = LAYOUT$bufferDeviceAddressCaptureReplay.byteSize();
    public static final long SIZE$bufferDeviceAddressMultiDevice = LAYOUT$bufferDeviceAddressMultiDevice.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$bufferDeviceAddress = LAYOUT.byteOffset(PATH$bufferDeviceAddress);
    public static final long OFFSET$bufferDeviceAddressCaptureReplay = LAYOUT.byteOffset(PATH$bufferDeviceAddressCaptureReplay);
    public static final long OFFSET$bufferDeviceAddressMultiDevice = LAYOUT.byteOffset(PATH$bufferDeviceAddressMultiDevice);
}
