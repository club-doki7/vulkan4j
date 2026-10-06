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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDeviceFaultInfoEXT.html"><code>VkDeviceFaultInfoEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDeviceFaultInfoEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     char[VK_MAX_DESCRIPTION_SIZE] description; // @link substring="description" target="#description"
///     VkDeviceFaultAddressInfoKHR* pAddressInfos; // optional // @link substring="VkDeviceFaultAddressInfoKHR" target="VkDeviceFaultAddressInfoKHR" @link substring="pAddressInfos" target="#pAddressInfos"
///     VkDeviceFaultVendorInfoKHR* pVendorInfos; // optional // @link substring="VkDeviceFaultVendorInfoKHR" target="VkDeviceFaultVendorInfoKHR" @link substring="pVendorInfos" target="#pVendorInfos"
///     void* pVendorBinaryData; // optional // @link substring="pVendorBinaryData" target="#pVendorBinaryData"
/// } VkDeviceFaultInfoEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_DEVICE_FAULT_INFO_EXT`
///
/// The {@code allocate} ({@link VkDeviceFaultInfoEXT#allocate(Arena)}, {@link VkDeviceFaultInfoEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkDeviceFaultInfoEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDeviceFaultInfoEXT.html"><code>VkDeviceFaultInfoEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDeviceFaultInfoEXT(@NotNull MemorySegment segment) implements IVkDeviceFaultInfoEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDeviceFaultInfoEXT.html"><code>VkDeviceFaultInfoEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDeviceFaultInfoEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDeviceFaultInfoEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDeviceFaultInfoEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDeviceFaultInfoEXT, Iterable<VkDeviceFaultInfoEXT> {
        public long size() {
            return segment.byteSize() / VkDeviceFaultInfoEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDeviceFaultInfoEXT at(long index) {
            return new VkDeviceFaultInfoEXT(segment.asSlice(index * VkDeviceFaultInfoEXT.BYTES, VkDeviceFaultInfoEXT.BYTES));
        }

        public VkDeviceFaultInfoEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkDeviceFaultInfoEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDeviceFaultInfoEXT value) {
            MemorySegment s = segment.asSlice(index * VkDeviceFaultInfoEXT.BYTES, VkDeviceFaultInfoEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDeviceFaultInfoEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDeviceFaultInfoEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDeviceFaultInfoEXT.BYTES,
                (end - start) * VkDeviceFaultInfoEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDeviceFaultInfoEXT.BYTES));
        }

        public VkDeviceFaultInfoEXT[] toArray() {
            VkDeviceFaultInfoEXT[] ret = new VkDeviceFaultInfoEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDeviceFaultInfoEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDeviceFaultInfoEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDeviceFaultInfoEXT.BYTES;
            }

            @Override
            public VkDeviceFaultInfoEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDeviceFaultInfoEXT ret = new VkDeviceFaultInfoEXT(segment.asSlice(0, VkDeviceFaultInfoEXT.BYTES));
                segment = segment.asSlice(VkDeviceFaultInfoEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDeviceFaultInfoEXT allocate(Arena arena) {
        VkDeviceFaultInfoEXT ret = new VkDeviceFaultInfoEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.DEVICE_FAULT_INFO_EXT);
        return ret;
    }

    public static VkDeviceFaultInfoEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkDeviceFaultInfoEXT.Ptr ret = new VkDeviceFaultInfoEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.DEVICE_FAULT_INFO_EXT);
        }
        return ret;
    }

    public static VkDeviceFaultInfoEXT clone(Arena arena, VkDeviceFaultInfoEXT src) {
        VkDeviceFaultInfoEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.DEVICE_FAULT_INFO_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkDeviceFaultInfoEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkDeviceFaultInfoEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkDeviceFaultInfoEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public BytePtr description() {
        return new BytePtr(descriptionRaw());
    }

    public VkDeviceFaultInfoEXT description(@NotNull Consumer<BytePtr> consumer) {
        BytePtr ptr = description();
        consumer.accept(ptr);
        return this;
    }

    public VkDeviceFaultInfoEXT description(BytePtr value) {
        MemorySegment s = descriptionRaw();
        s.copyFrom(value.segment());
        return this;
    }

    public @NotNull MemorySegment descriptionRaw() {
        return segment.asSlice(OFFSET$description, SIZE$description);
    }

    public VkDeviceFaultInfoEXT pAddressInfos(@Nullable IVkDeviceFaultAddressInfoKHR value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pAddressInfosRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkDeviceFaultAddressInfoKHR.Ptr pAddressInfos(int assumedCount) {
        MemorySegment s = pAddressInfosRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkDeviceFaultAddressInfoKHR.BYTES);
        return new VkDeviceFaultAddressInfoKHR.Ptr(s);
    }

    public @Nullable VkDeviceFaultAddressInfoKHR pAddressInfos() {
        MemorySegment s = pAddressInfosRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkDeviceFaultAddressInfoKHR(s);
    }

    public @Pointer(target=VkDeviceFaultAddressInfoKHR.class) @NotNull MemorySegment pAddressInfosRaw() {
        return segment.get(LAYOUT$pAddressInfos, OFFSET$pAddressInfos);
    }

    public void pAddressInfosRaw(@Pointer(target=VkDeviceFaultAddressInfoKHR.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pAddressInfos, OFFSET$pAddressInfos, value);
    }

    public VkDeviceFaultInfoEXT pVendorInfos(@Nullable IVkDeviceFaultVendorInfoKHR value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pVendorInfosRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkDeviceFaultVendorInfoKHR.Ptr pVendorInfos(int assumedCount) {
        MemorySegment s = pVendorInfosRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkDeviceFaultVendorInfoKHR.BYTES);
        return new VkDeviceFaultVendorInfoKHR.Ptr(s);
    }

    public @Nullable VkDeviceFaultVendorInfoKHR pVendorInfos() {
        MemorySegment s = pVendorInfosRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkDeviceFaultVendorInfoKHR(s);
    }

    public @Pointer(target=VkDeviceFaultVendorInfoKHR.class) @NotNull MemorySegment pVendorInfosRaw() {
        return segment.get(LAYOUT$pVendorInfos, OFFSET$pVendorInfos);
    }

    public void pVendorInfosRaw(@Pointer(target=VkDeviceFaultVendorInfoKHR.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pVendorInfos, OFFSET$pVendorInfos, value);
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pVendorBinaryData() {
        return segment.get(LAYOUT$pVendorBinaryData, OFFSET$pVendorBinaryData);
    }

    public VkDeviceFaultInfoEXT pVendorBinaryData(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pVendorBinaryData, OFFSET$pVendorBinaryData, value);
        return this;
    }

    public VkDeviceFaultInfoEXT pVendorBinaryData(@Nullable IPointer pointer) {
        pVendorBinaryData(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        MemoryLayout.sequenceLayout(MAX_DESCRIPTION_SIZE, ValueLayout.JAVA_BYTE).withName("description"),
        ValueLayout.ADDRESS.withTargetLayout(VkDeviceFaultAddressInfoKHR.LAYOUT).withName("pAddressInfos"),
        ValueLayout.ADDRESS.withTargetLayout(VkDeviceFaultVendorInfoKHR.LAYOUT).withName("pVendorInfos"),
        ValueLayout.ADDRESS.withName("pVendorBinaryData")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$description = PathElement.groupElement("description");
    public static final PathElement PATH$pAddressInfos = PathElement.groupElement("pAddressInfos");
    public static final PathElement PATH$pVendorInfos = PathElement.groupElement("pVendorInfos");
    public static final PathElement PATH$pVendorBinaryData = PathElement.groupElement("pVendorBinaryData");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final SequenceLayout LAYOUT$description = (SequenceLayout) LAYOUT.select(PATH$description);
    public static final AddressLayout LAYOUT$pAddressInfos = (AddressLayout) LAYOUT.select(PATH$pAddressInfos);
    public static final AddressLayout LAYOUT$pVendorInfos = (AddressLayout) LAYOUT.select(PATH$pVendorInfos);
    public static final AddressLayout LAYOUT$pVendorBinaryData = (AddressLayout) LAYOUT.select(PATH$pVendorBinaryData);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$description = LAYOUT$description.byteSize();
    public static final long SIZE$pAddressInfos = LAYOUT$pAddressInfos.byteSize();
    public static final long SIZE$pVendorInfos = LAYOUT$pVendorInfos.byteSize();
    public static final long SIZE$pVendorBinaryData = LAYOUT$pVendorBinaryData.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$description = LAYOUT.byteOffset(PATH$description);
    public static final long OFFSET$pAddressInfos = LAYOUT.byteOffset(PATH$pAddressInfos);
    public static final long OFFSET$pVendorInfos = LAYOUT.byteOffset(PATH$pVendorInfos);
    public static final long OFFSET$pVendorBinaryData = LAYOUT.byteOffset(PATH$pVendorBinaryData);
}
