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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDeviceFaultInfoKHR.html"><code>VkDeviceFaultInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDeviceFaultInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkDeviceFaultFlagsKHR flags; // @link substring="VkDeviceFaultFlagsKHR" target="VkDeviceFaultFlagsKHR" @link substring="flags" target="#flags"
///     uint64_t groupId; // @link substring="groupId" target="#groupId"
///     char[VK_MAX_DESCRIPTION_SIZE] description; // @link substring="description" target="#description"
///     VkDeviceFaultAddressInfoKHR faultAddressInfo; // optional // @link substring="VkDeviceFaultAddressInfoKHR" target="VkDeviceFaultAddressInfoKHR" @link substring="faultAddressInfo" target="#faultAddressInfo"
///     VkDeviceFaultAddressInfoKHR instructionAddressInfo; // optional // @link substring="VkDeviceFaultAddressInfoKHR" target="VkDeviceFaultAddressInfoKHR" @link substring="instructionAddressInfo" target="#instructionAddressInfo"
///     VkDeviceFaultVendorInfoKHR vendorInfo; // optional // @link substring="VkDeviceFaultVendorInfoKHR" target="VkDeviceFaultVendorInfoKHR" @link substring="vendorInfo" target="#vendorInfo"
/// } VkDeviceFaultInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_DEVICE_FAULT_INFO_KHR`
///
/// The {@code allocate} ({@link VkDeviceFaultInfoKHR#allocate(Arena)}, {@link VkDeviceFaultInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkDeviceFaultInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDeviceFaultInfoKHR.html"><code>VkDeviceFaultInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDeviceFaultInfoKHR(@NotNull MemorySegment segment) implements IVkDeviceFaultInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDeviceFaultInfoKHR.html"><code>VkDeviceFaultInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDeviceFaultInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDeviceFaultInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDeviceFaultInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDeviceFaultInfoKHR, Iterable<VkDeviceFaultInfoKHR> {
        public long size() {
            return segment.byteSize() / VkDeviceFaultInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDeviceFaultInfoKHR at(long index) {
            return new VkDeviceFaultInfoKHR(segment.asSlice(index * VkDeviceFaultInfoKHR.BYTES, VkDeviceFaultInfoKHR.BYTES));
        }

        public VkDeviceFaultInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkDeviceFaultInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDeviceFaultInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkDeviceFaultInfoKHR.BYTES, VkDeviceFaultInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDeviceFaultInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDeviceFaultInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDeviceFaultInfoKHR.BYTES,
                (end - start) * VkDeviceFaultInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDeviceFaultInfoKHR.BYTES));
        }

        public VkDeviceFaultInfoKHR[] toArray() {
            VkDeviceFaultInfoKHR[] ret = new VkDeviceFaultInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDeviceFaultInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDeviceFaultInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDeviceFaultInfoKHR.BYTES;
            }

            @Override
            public VkDeviceFaultInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDeviceFaultInfoKHR ret = new VkDeviceFaultInfoKHR(segment.asSlice(0, VkDeviceFaultInfoKHR.BYTES));
                segment = segment.asSlice(VkDeviceFaultInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDeviceFaultInfoKHR allocate(Arena arena) {
        VkDeviceFaultInfoKHR ret = new VkDeviceFaultInfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.DEVICE_FAULT_INFO_KHR);
        return ret;
    }

    public static VkDeviceFaultInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkDeviceFaultInfoKHR.Ptr ret = new VkDeviceFaultInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.DEVICE_FAULT_INFO_KHR);
        }
        return ret;
    }

    public static VkDeviceFaultInfoKHR clone(Arena arena, VkDeviceFaultInfoKHR src) {
        VkDeviceFaultInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.DEVICE_FAULT_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkDeviceFaultInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkDeviceFaultInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkDeviceFaultInfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkDeviceFaultFlagsKHR.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkDeviceFaultInfoKHR flags(@Bitmask(VkDeviceFaultFlagsKHR.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @Unsigned long groupId() {
        return segment.get(LAYOUT$groupId, OFFSET$groupId);
    }

    public VkDeviceFaultInfoKHR groupId(@Unsigned long value) {
        segment.set(LAYOUT$groupId, OFFSET$groupId, value);
        return this;
    }

    public BytePtr description() {
        return new BytePtr(descriptionRaw());
    }

    public VkDeviceFaultInfoKHR description(@NotNull Consumer<BytePtr> consumer) {
        BytePtr ptr = description();
        consumer.accept(ptr);
        return this;
    }

    public VkDeviceFaultInfoKHR description(BytePtr value) {
        MemorySegment s = descriptionRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment descriptionRaw() {
        return segment.asSlice(OFFSET$description, SIZE$description);
    }

    public @NotNull VkDeviceFaultAddressInfoKHR faultAddressInfo() {
        return new VkDeviceFaultAddressInfoKHR(segment.asSlice(OFFSET$faultAddressInfo, LAYOUT$faultAddressInfo));
    }

    public VkDeviceFaultInfoKHR faultAddressInfo(@NotNull VkDeviceFaultAddressInfoKHR value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$faultAddressInfo, SIZE$faultAddressInfo);
        return this;
    }

    public VkDeviceFaultInfoKHR faultAddressInfo(Consumer<@NotNull VkDeviceFaultAddressInfoKHR> consumer) {
        consumer.accept(faultAddressInfo());
        return this;
    }

    public @NotNull VkDeviceFaultAddressInfoKHR instructionAddressInfo() {
        return new VkDeviceFaultAddressInfoKHR(segment.asSlice(OFFSET$instructionAddressInfo, LAYOUT$instructionAddressInfo));
    }

    public VkDeviceFaultInfoKHR instructionAddressInfo(@NotNull VkDeviceFaultAddressInfoKHR value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$instructionAddressInfo, SIZE$instructionAddressInfo);
        return this;
    }

    public VkDeviceFaultInfoKHR instructionAddressInfo(Consumer<@NotNull VkDeviceFaultAddressInfoKHR> consumer) {
        consumer.accept(instructionAddressInfo());
        return this;
    }

    public @NotNull VkDeviceFaultVendorInfoKHR vendorInfo() {
        return new VkDeviceFaultVendorInfoKHR(segment.asSlice(OFFSET$vendorInfo, LAYOUT$vendorInfo));
    }

    public VkDeviceFaultInfoKHR vendorInfo(@NotNull VkDeviceFaultVendorInfoKHR value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$vendorInfo, SIZE$vendorInfo);
        return this;
    }

    public VkDeviceFaultInfoKHR vendorInfo(Consumer<@NotNull VkDeviceFaultVendorInfoKHR> consumer) {
        consumer.accept(vendorInfo());
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_LONG.withName("groupId"),
        MemoryLayout.sequenceLayout(MAX_DESCRIPTION_SIZE, ValueLayout.JAVA_BYTE).withName("description"),
        VkDeviceFaultAddressInfoKHR.LAYOUT.withName("faultAddressInfo"),
        VkDeviceFaultAddressInfoKHR.LAYOUT.withName("instructionAddressInfo"),
        VkDeviceFaultVendorInfoKHR.LAYOUT.withName("vendorInfo")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$groupId = PathElement.groupElement("groupId");
    public static final PathElement PATH$description = PathElement.groupElement("description");
    public static final PathElement PATH$faultAddressInfo = PathElement.groupElement("faultAddressInfo");
    public static final PathElement PATH$instructionAddressInfo = PathElement.groupElement("instructionAddressInfo");
    public static final PathElement PATH$vendorInfo = PathElement.groupElement("vendorInfo");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfLong LAYOUT$groupId = (OfLong) LAYOUT.select(PATH$groupId);
    public static final SequenceLayout LAYOUT$description = (SequenceLayout) LAYOUT.select(PATH$description);
    public static final StructLayout LAYOUT$faultAddressInfo = (StructLayout) LAYOUT.select(PATH$faultAddressInfo);
    public static final StructLayout LAYOUT$instructionAddressInfo = (StructLayout) LAYOUT.select(PATH$instructionAddressInfo);
    public static final StructLayout LAYOUT$vendorInfo = (StructLayout) LAYOUT.select(PATH$vendorInfo);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$groupId = LAYOUT$groupId.byteSize();
    public static final long SIZE$description = LAYOUT$description.byteSize();
    public static final long SIZE$faultAddressInfo = LAYOUT$faultAddressInfo.byteSize();
    public static final long SIZE$instructionAddressInfo = LAYOUT$instructionAddressInfo.byteSize();
    public static final long SIZE$vendorInfo = LAYOUT$vendorInfo.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$groupId = LAYOUT.byteOffset(PATH$groupId);
    public static final long OFFSET$description = LAYOUT.byteOffset(PATH$description);
    public static final long OFFSET$faultAddressInfo = LAYOUT.byteOffset(PATH$faultAddressInfo);
    public static final long OFFSET$instructionAddressInfo = LAYOUT.byteOffset(PATH$instructionAddressInfo);
    public static final long OFFSET$vendorInfo = LAYOUT.byteOffset(PATH$vendorInfo);
}
