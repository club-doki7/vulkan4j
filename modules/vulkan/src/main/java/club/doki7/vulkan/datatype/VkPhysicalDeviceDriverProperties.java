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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceDriverProperties.html"><code>VkPhysicalDeviceDriverProperties</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceDriverProperties {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkDriverId driverID; // @link substring="VkDriverId" target="VkDriverId" @link substring="driverID" target="#driverID"
///     char[VK_MAX_DRIVER_NAME_SIZE] driverName; // @link substring="driverName" target="#driverName"
///     char[VK_MAX_DRIVER_INFO_SIZE] driverInfo; // @link substring="driverInfo" target="#driverInfo"
///     VkConformanceVersion conformanceVersion; // @link substring="VkConformanceVersion" target="VkConformanceVersion" @link substring="conformanceVersion" target="#conformanceVersion"
/// } VkPhysicalDeviceDriverProperties;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_DRIVER_PROPERTIES`
///
/// The {@code allocate} ({@link VkPhysicalDeviceDriverProperties#allocate(Arena)}, {@link VkPhysicalDeviceDriverProperties#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceDriverProperties#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceDriverProperties.html"><code>VkPhysicalDeviceDriverProperties</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceDriverProperties(@NotNull MemorySegment segment) implements IVkPhysicalDeviceDriverProperties {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceDriverProperties.html"><code>VkPhysicalDeviceDriverProperties</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceDriverProperties}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceDriverProperties to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceDriverProperties.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceDriverProperties, Iterable<VkPhysicalDeviceDriverProperties> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceDriverProperties.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceDriverProperties at(long index) {
            return new VkPhysicalDeviceDriverProperties(segment.asSlice(index * VkPhysicalDeviceDriverProperties.BYTES, VkPhysicalDeviceDriverProperties.BYTES));
        }

        public VkPhysicalDeviceDriverProperties.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceDriverProperties> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceDriverProperties value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceDriverProperties.BYTES, VkPhysicalDeviceDriverProperties.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceDriverProperties.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceDriverProperties.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceDriverProperties.BYTES,
                (end - start) * VkPhysicalDeviceDriverProperties.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceDriverProperties.BYTES));
        }

        public VkPhysicalDeviceDriverProperties[] toArray() {
            VkPhysicalDeviceDriverProperties[] ret = new VkPhysicalDeviceDriverProperties[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceDriverProperties> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceDriverProperties> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceDriverProperties.BYTES;
            }

            @Override
            public VkPhysicalDeviceDriverProperties next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceDriverProperties ret = new VkPhysicalDeviceDriverProperties(segment.asSlice(0, VkPhysicalDeviceDriverProperties.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceDriverProperties.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceDriverProperties allocate(Arena arena) {
        VkPhysicalDeviceDriverProperties ret = new VkPhysicalDeviceDriverProperties(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_DRIVER_PROPERTIES);
        return ret;
    }

    public static VkPhysicalDeviceDriverProperties.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceDriverProperties.Ptr ret = new VkPhysicalDeviceDriverProperties.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_DRIVER_PROPERTIES);
        }
        return ret;
    }

    public static VkPhysicalDeviceDriverProperties clone(Arena arena, VkPhysicalDeviceDriverProperties src) {
        VkPhysicalDeviceDriverProperties ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_DRIVER_PROPERTIES);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceDriverProperties sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceDriverProperties pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceDriverProperties pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @EnumType(VkDriverId.class) int driverID() {
        return segment.get(LAYOUT$driverID, OFFSET$driverID);
    }

    public VkPhysicalDeviceDriverProperties driverID(@EnumType(VkDriverId.class) int value) {
        segment.set(LAYOUT$driverID, OFFSET$driverID, value);
        return this;
    }

    public BytePtr driverName() {
        return new BytePtr(driverNameRaw());
    }

    public VkPhysicalDeviceDriverProperties driverName(@NotNull Consumer<BytePtr> consumer) {
        BytePtr ptr = driverName();
        consumer.accept(ptr);
        return this;
    }

    public VkPhysicalDeviceDriverProperties driverName(BytePtr value) {
        MemorySegment s = driverNameRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment driverNameRaw() {
        return segment.asSlice(OFFSET$driverName, SIZE$driverName);
    }

    public BytePtr driverInfo() {
        return new BytePtr(driverInfoRaw());
    }

    public VkPhysicalDeviceDriverProperties driverInfo(@NotNull Consumer<BytePtr> consumer) {
        BytePtr ptr = driverInfo();
        consumer.accept(ptr);
        return this;
    }

    public VkPhysicalDeviceDriverProperties driverInfo(BytePtr value) {
        MemorySegment s = driverInfoRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment driverInfoRaw() {
        return segment.asSlice(OFFSET$driverInfo, SIZE$driverInfo);
    }

    public @NotNull VkConformanceVersion conformanceVersion() {
        return new VkConformanceVersion(segment.asSlice(OFFSET$conformanceVersion, LAYOUT$conformanceVersion));
    }

    public VkPhysicalDeviceDriverProperties conformanceVersion(@NotNull VkConformanceVersion value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$conformanceVersion, SIZE$conformanceVersion);
        return this;
    }

    public VkPhysicalDeviceDriverProperties conformanceVersion(Consumer<@NotNull VkConformanceVersion> consumer) {
        consumer.accept(conformanceVersion());
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("driverID"),
        MemoryLayout.sequenceLayout(MAX_DRIVER_NAME_SIZE, ValueLayout.JAVA_BYTE).withName("driverName"),
        MemoryLayout.sequenceLayout(MAX_DRIVER_INFO_SIZE, ValueLayout.JAVA_BYTE).withName("driverInfo"),
        VkConformanceVersion.LAYOUT.withName("conformanceVersion")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$driverID = PathElement.groupElement("driverID");
    public static final PathElement PATH$driverName = PathElement.groupElement("driverName");
    public static final PathElement PATH$driverInfo = PathElement.groupElement("driverInfo");
    public static final PathElement PATH$conformanceVersion = PathElement.groupElement("conformanceVersion");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$driverID = (OfInt) LAYOUT.select(PATH$driverID);
    public static final SequenceLayout LAYOUT$driverName = (SequenceLayout) LAYOUT.select(PATH$driverName);
    public static final SequenceLayout LAYOUT$driverInfo = (SequenceLayout) LAYOUT.select(PATH$driverInfo);
    public static final StructLayout LAYOUT$conformanceVersion = (StructLayout) LAYOUT.select(PATH$conformanceVersion);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$driverID = LAYOUT$driverID.byteSize();
    public static final long SIZE$driverName = LAYOUT$driverName.byteSize();
    public static final long SIZE$driverInfo = LAYOUT$driverInfo.byteSize();
    public static final long SIZE$conformanceVersion = LAYOUT$conformanceVersion.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$driverID = LAYOUT.byteOffset(PATH$driverID);
    public static final long OFFSET$driverName = LAYOUT.byteOffset(PATH$driverName);
    public static final long OFFSET$driverInfo = LAYOUT.byteOffset(PATH$driverInfo);
    public static final long OFFSET$conformanceVersion = LAYOUT.byteOffset(PATH$conformanceVersion);
}
