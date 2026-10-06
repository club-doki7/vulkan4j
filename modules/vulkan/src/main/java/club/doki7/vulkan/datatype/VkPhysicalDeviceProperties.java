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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceProperties.html"><code>VkPhysicalDeviceProperties</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceProperties {
///     uint32_t apiVersion; // @link substring="apiVersion" target="#apiVersion"
///     uint32_t driverVersion; // @link substring="driverVersion" target="#driverVersion"
///     uint32_t vendorID; // @link substring="vendorID" target="#vendorID"
///     uint32_t deviceID; // @link substring="deviceID" target="#deviceID"
///     VkPhysicalDeviceType deviceType; // @link substring="VkPhysicalDeviceType" target="VkPhysicalDeviceType" @link substring="deviceType" target="#deviceType"
///     char[VK_MAX_PHYSICAL_DEVICE_NAME_SIZE] deviceName; // @link substring="deviceName" target="#deviceName"
///     uint8_t[VK_UUID_SIZE] pipelineCacheUUID; // @link substring="pipelineCacheUUID" target="#pipelineCacheUUID"
///     VkPhysicalDeviceLimits limits; // @link substring="VkPhysicalDeviceLimits" target="VkPhysicalDeviceLimits" @link substring="limits" target="#limits"
///     VkPhysicalDeviceSparseProperties sparseProperties; // @link substring="VkPhysicalDeviceSparseProperties" target="VkPhysicalDeviceSparseProperties" @link substring="sparseProperties" target="#sparseProperties"
/// } VkPhysicalDeviceProperties;
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceProperties.html"><code>VkPhysicalDeviceProperties</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceProperties(@NotNull MemorySegment segment) implements IVkPhysicalDeviceProperties {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceProperties.html"><code>VkPhysicalDeviceProperties</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceProperties}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceProperties to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceProperties.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceProperties, Iterable<VkPhysicalDeviceProperties> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceProperties.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceProperties at(long index) {
            return new VkPhysicalDeviceProperties(segment.asSlice(index * VkPhysicalDeviceProperties.BYTES, VkPhysicalDeviceProperties.BYTES));
        }

        public VkPhysicalDeviceProperties.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceProperties> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceProperties value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceProperties.BYTES, VkPhysicalDeviceProperties.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceProperties.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceProperties.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceProperties.BYTES,
                (end - start) * VkPhysicalDeviceProperties.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceProperties.BYTES));
        }

        public VkPhysicalDeviceProperties[] toArray() {
            VkPhysicalDeviceProperties[] ret = new VkPhysicalDeviceProperties[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceProperties> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceProperties> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceProperties.BYTES;
            }

            @Override
            public VkPhysicalDeviceProperties next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceProperties ret = new VkPhysicalDeviceProperties(segment.asSlice(0, VkPhysicalDeviceProperties.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceProperties.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceProperties allocate(Arena arena) {
        return new VkPhysicalDeviceProperties(arena.allocate(LAYOUT));
    }

    public static VkPhysicalDeviceProperties.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkPhysicalDeviceProperties.Ptr(segment);
    }

    public static VkPhysicalDeviceProperties clone(Arena arena, VkPhysicalDeviceProperties src) {
        VkPhysicalDeviceProperties ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned int apiVersion() {
        return segment.get(LAYOUT$apiVersion, OFFSET$apiVersion);
    }

    public VkPhysicalDeviceProperties apiVersion(@Unsigned int value) {
        segment.set(LAYOUT$apiVersion, OFFSET$apiVersion, value);
        return this;
    }

    public @Unsigned int driverVersion() {
        return segment.get(LAYOUT$driverVersion, OFFSET$driverVersion);
    }

    public VkPhysicalDeviceProperties driverVersion(@Unsigned int value) {
        segment.set(LAYOUT$driverVersion, OFFSET$driverVersion, value);
        return this;
    }

    public @Unsigned int vendorID() {
        return segment.get(LAYOUT$vendorID, OFFSET$vendorID);
    }

    public VkPhysicalDeviceProperties vendorID(@Unsigned int value) {
        segment.set(LAYOUT$vendorID, OFFSET$vendorID, value);
        return this;
    }

    public @Unsigned int deviceID() {
        return segment.get(LAYOUT$deviceID, OFFSET$deviceID);
    }

    public VkPhysicalDeviceProperties deviceID(@Unsigned int value) {
        segment.set(LAYOUT$deviceID, OFFSET$deviceID, value);
        return this;
    }

    public @EnumType(VkPhysicalDeviceType.class) int deviceType() {
        return segment.get(LAYOUT$deviceType, OFFSET$deviceType);
    }

    public VkPhysicalDeviceProperties deviceType(@EnumType(VkPhysicalDeviceType.class) int value) {
        segment.set(LAYOUT$deviceType, OFFSET$deviceType, value);
        return this;
    }

    public BytePtr deviceName() {
        return new BytePtr(deviceNameRaw());
    }

    public VkPhysicalDeviceProperties deviceName(@NotNull Consumer<BytePtr> consumer) {
        BytePtr ptr = deviceName();
        consumer.accept(ptr);
        return this;
    }

    public VkPhysicalDeviceProperties deviceName(BytePtr value) {
        MemorySegment s = deviceNameRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment deviceNameRaw() {
        return segment.asSlice(OFFSET$deviceName, SIZE$deviceName);
    }

    public @Unsigned BytePtr pipelineCacheUUID() {
        return new BytePtr(pipelineCacheUUIDRaw());
    }

    public VkPhysicalDeviceProperties pipelineCacheUUID(@NotNull Consumer<BytePtr> consumer) {
        @Unsigned BytePtr ptr = pipelineCacheUUID();
        consumer.accept(ptr);
        return this;
    }

    public VkPhysicalDeviceProperties pipelineCacheUUID(@Unsigned BytePtr value) {
        MemorySegment s = pipelineCacheUUIDRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment pipelineCacheUUIDRaw() {
        return segment.asSlice(OFFSET$pipelineCacheUUID, SIZE$pipelineCacheUUID);
    }

    public @NotNull VkPhysicalDeviceLimits limits() {
        return new VkPhysicalDeviceLimits(segment.asSlice(OFFSET$limits, LAYOUT$limits));
    }

    public VkPhysicalDeviceProperties limits(@NotNull VkPhysicalDeviceLimits value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$limits, SIZE$limits);
        return this;
    }

    public VkPhysicalDeviceProperties limits(Consumer<@NotNull VkPhysicalDeviceLimits> consumer) {
        consumer.accept(limits());
        return this;
    }

    public @NotNull VkPhysicalDeviceSparseProperties sparseProperties() {
        return new VkPhysicalDeviceSparseProperties(segment.asSlice(OFFSET$sparseProperties, LAYOUT$sparseProperties));
    }

    public VkPhysicalDeviceProperties sparseProperties(@NotNull VkPhysicalDeviceSparseProperties value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$sparseProperties, SIZE$sparseProperties);
        return this;
    }

    public VkPhysicalDeviceProperties sparseProperties(Consumer<@NotNull VkPhysicalDeviceSparseProperties> consumer) {
        consumer.accept(sparseProperties());
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("apiVersion"),
        ValueLayout.JAVA_INT.withName("driverVersion"),
        ValueLayout.JAVA_INT.withName("vendorID"),
        ValueLayout.JAVA_INT.withName("deviceID"),
        ValueLayout.JAVA_INT.withName("deviceType"),
        MemoryLayout.sequenceLayout(MAX_PHYSICAL_DEVICE_NAME_SIZE, ValueLayout.JAVA_BYTE).withName("deviceName"),
        MemoryLayout.sequenceLayout(UUID_SIZE, ValueLayout.JAVA_BYTE).withName("pipelineCacheUUID"),
        VkPhysicalDeviceLimits.LAYOUT.withName("limits"),
        VkPhysicalDeviceSparseProperties.LAYOUT.withName("sparseProperties")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$apiVersion = PathElement.groupElement("apiVersion");
    public static final PathElement PATH$driverVersion = PathElement.groupElement("driverVersion");
    public static final PathElement PATH$vendorID = PathElement.groupElement("vendorID");
    public static final PathElement PATH$deviceID = PathElement.groupElement("deviceID");
    public static final PathElement PATH$deviceType = PathElement.groupElement("deviceType");
    public static final PathElement PATH$deviceName = PathElement.groupElement("deviceName");
    public static final PathElement PATH$pipelineCacheUUID = PathElement.groupElement("pipelineCacheUUID");
    public static final PathElement PATH$limits = PathElement.groupElement("limits");
    public static final PathElement PATH$sparseProperties = PathElement.groupElement("sparseProperties");

    public static final OfInt LAYOUT$apiVersion = (OfInt) LAYOUT.select(PATH$apiVersion);
    public static final OfInt LAYOUT$driverVersion = (OfInt) LAYOUT.select(PATH$driverVersion);
    public static final OfInt LAYOUT$vendorID = (OfInt) LAYOUT.select(PATH$vendorID);
    public static final OfInt LAYOUT$deviceID = (OfInt) LAYOUT.select(PATH$deviceID);
    public static final OfInt LAYOUT$deviceType = (OfInt) LAYOUT.select(PATH$deviceType);
    public static final SequenceLayout LAYOUT$deviceName = (SequenceLayout) LAYOUT.select(PATH$deviceName);
    public static final SequenceLayout LAYOUT$pipelineCacheUUID = (SequenceLayout) LAYOUT.select(PATH$pipelineCacheUUID);
    public static final StructLayout LAYOUT$limits = (StructLayout) LAYOUT.select(PATH$limits);
    public static final StructLayout LAYOUT$sparseProperties = (StructLayout) LAYOUT.select(PATH$sparseProperties);

    public static final long SIZE$apiVersion = LAYOUT$apiVersion.byteSize();
    public static final long SIZE$driverVersion = LAYOUT$driverVersion.byteSize();
    public static final long SIZE$vendorID = LAYOUT$vendorID.byteSize();
    public static final long SIZE$deviceID = LAYOUT$deviceID.byteSize();
    public static final long SIZE$deviceType = LAYOUT$deviceType.byteSize();
    public static final long SIZE$deviceName = LAYOUT$deviceName.byteSize();
    public static final long SIZE$pipelineCacheUUID = LAYOUT$pipelineCacheUUID.byteSize();
    public static final long SIZE$limits = LAYOUT$limits.byteSize();
    public static final long SIZE$sparseProperties = LAYOUT$sparseProperties.byteSize();

    public static final long OFFSET$apiVersion = LAYOUT.byteOffset(PATH$apiVersion);
    public static final long OFFSET$driverVersion = LAYOUT.byteOffset(PATH$driverVersion);
    public static final long OFFSET$vendorID = LAYOUT.byteOffset(PATH$vendorID);
    public static final long OFFSET$deviceID = LAYOUT.byteOffset(PATH$deviceID);
    public static final long OFFSET$deviceType = LAYOUT.byteOffset(PATH$deviceType);
    public static final long OFFSET$deviceName = LAYOUT.byteOffset(PATH$deviceName);
    public static final long OFFSET$pipelineCacheUUID = LAYOUT.byteOffset(PATH$pipelineCacheUUID);
    public static final long OFFSET$limits = LAYOUT.byteOffset(PATH$limits);
    public static final long OFFSET$sparseProperties = LAYOUT.byteOffset(PATH$sparseProperties);
}
