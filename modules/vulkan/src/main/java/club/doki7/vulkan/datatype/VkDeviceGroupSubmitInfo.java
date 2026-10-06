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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDeviceGroupSubmitInfo.html"><code>VkDeviceGroupSubmitInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDeviceGroupSubmitInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t waitSemaphoreCount; // optional // @link substring="waitSemaphoreCount" target="#waitSemaphoreCount"
///     uint32_t const* pWaitSemaphoreDeviceIndices; // optional // @link substring="pWaitSemaphoreDeviceIndices" target="#pWaitSemaphoreDeviceIndices"
///     uint32_t commandBufferCount; // optional // @link substring="commandBufferCount" target="#commandBufferCount"
///     uint32_t const* pCommandBufferDeviceMasks; // optional // @link substring="pCommandBufferDeviceMasks" target="#pCommandBufferDeviceMasks"
///     uint32_t signalSemaphoreCount; // optional // @link substring="signalSemaphoreCount" target="#signalSemaphoreCount"
///     uint32_t const* pSignalSemaphoreDeviceIndices; // optional // @link substring="pSignalSemaphoreDeviceIndices" target="#pSignalSemaphoreDeviceIndices"
/// } VkDeviceGroupSubmitInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_DEVICE_GROUP_SUBMIT_INFO`
///
/// The {@code allocate} ({@link VkDeviceGroupSubmitInfo#allocate(Arena)}, {@link VkDeviceGroupSubmitInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkDeviceGroupSubmitInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDeviceGroupSubmitInfo.html"><code>VkDeviceGroupSubmitInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDeviceGroupSubmitInfo(@NotNull MemorySegment segment) implements IVkDeviceGroupSubmitInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDeviceGroupSubmitInfo.html"><code>VkDeviceGroupSubmitInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDeviceGroupSubmitInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDeviceGroupSubmitInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDeviceGroupSubmitInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDeviceGroupSubmitInfo, Iterable<VkDeviceGroupSubmitInfo> {
        public long size() {
            return segment.byteSize() / VkDeviceGroupSubmitInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDeviceGroupSubmitInfo at(long index) {
            return new VkDeviceGroupSubmitInfo(segment.asSlice(index * VkDeviceGroupSubmitInfo.BYTES, VkDeviceGroupSubmitInfo.BYTES));
        }

        public VkDeviceGroupSubmitInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkDeviceGroupSubmitInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDeviceGroupSubmitInfo value) {
            MemorySegment s = segment.asSlice(index * VkDeviceGroupSubmitInfo.BYTES, VkDeviceGroupSubmitInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDeviceGroupSubmitInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDeviceGroupSubmitInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDeviceGroupSubmitInfo.BYTES,
                (end - start) * VkDeviceGroupSubmitInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDeviceGroupSubmitInfo.BYTES));
        }

        public VkDeviceGroupSubmitInfo[] toArray() {
            VkDeviceGroupSubmitInfo[] ret = new VkDeviceGroupSubmitInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDeviceGroupSubmitInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDeviceGroupSubmitInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDeviceGroupSubmitInfo.BYTES;
            }

            @Override
            public VkDeviceGroupSubmitInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDeviceGroupSubmitInfo ret = new VkDeviceGroupSubmitInfo(segment.asSlice(0, VkDeviceGroupSubmitInfo.BYTES));
                segment = segment.asSlice(VkDeviceGroupSubmitInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDeviceGroupSubmitInfo allocate(Arena arena) {
        VkDeviceGroupSubmitInfo ret = new VkDeviceGroupSubmitInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.DEVICE_GROUP_SUBMIT_INFO);
        return ret;
    }

    public static VkDeviceGroupSubmitInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkDeviceGroupSubmitInfo.Ptr ret = new VkDeviceGroupSubmitInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.DEVICE_GROUP_SUBMIT_INFO);
        }
        return ret;
    }

    public static VkDeviceGroupSubmitInfo clone(Arena arena, VkDeviceGroupSubmitInfo src) {
        VkDeviceGroupSubmitInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.DEVICE_GROUP_SUBMIT_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkDeviceGroupSubmitInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkDeviceGroupSubmitInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkDeviceGroupSubmitInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int waitSemaphoreCount() {
        return segment.get(LAYOUT$waitSemaphoreCount, OFFSET$waitSemaphoreCount);
    }

    public VkDeviceGroupSubmitInfo waitSemaphoreCount(@Unsigned int value) {
        segment.set(LAYOUT$waitSemaphoreCount, OFFSET$waitSemaphoreCount, value);
        return this;
    }

    /// Note: the returned {@link IntPtr} does not have correct
    /// {@link IntPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link IntPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable @Unsigned IntPtr pWaitSemaphoreDeviceIndices() {
        MemorySegment s = pWaitSemaphoreDeviceIndicesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new IntPtr(s);
    }

    public VkDeviceGroupSubmitInfo pWaitSemaphoreDeviceIndices(@Nullable @Unsigned IntPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pWaitSemaphoreDeviceIndicesRaw(s);
        return this;
    }

    public @Pointer(comment="uint32_t*") @NotNull MemorySegment pWaitSemaphoreDeviceIndicesRaw() {
        return segment.get(LAYOUT$pWaitSemaphoreDeviceIndices, OFFSET$pWaitSemaphoreDeviceIndices);
    }

    public void pWaitSemaphoreDeviceIndicesRaw(@Pointer(comment="uint32_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pWaitSemaphoreDeviceIndices, OFFSET$pWaitSemaphoreDeviceIndices, value);
    }

    public @Unsigned int commandBufferCount() {
        return segment.get(LAYOUT$commandBufferCount, OFFSET$commandBufferCount);
    }

    public VkDeviceGroupSubmitInfo commandBufferCount(@Unsigned int value) {
        segment.set(LAYOUT$commandBufferCount, OFFSET$commandBufferCount, value);
        return this;
    }

    /// Note: the returned {@link IntPtr} does not have correct
    /// {@link IntPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link IntPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable @Unsigned IntPtr pCommandBufferDeviceMasks() {
        MemorySegment s = pCommandBufferDeviceMasksRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new IntPtr(s);
    }

    public VkDeviceGroupSubmitInfo pCommandBufferDeviceMasks(@Nullable @Unsigned IntPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pCommandBufferDeviceMasksRaw(s);
        return this;
    }

    public @Pointer(comment="uint32_t*") @NotNull MemorySegment pCommandBufferDeviceMasksRaw() {
        return segment.get(LAYOUT$pCommandBufferDeviceMasks, OFFSET$pCommandBufferDeviceMasks);
    }

    public void pCommandBufferDeviceMasksRaw(@Pointer(comment="uint32_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pCommandBufferDeviceMasks, OFFSET$pCommandBufferDeviceMasks, value);
    }

    public @Unsigned int signalSemaphoreCount() {
        return segment.get(LAYOUT$signalSemaphoreCount, OFFSET$signalSemaphoreCount);
    }

    public VkDeviceGroupSubmitInfo signalSemaphoreCount(@Unsigned int value) {
        segment.set(LAYOUT$signalSemaphoreCount, OFFSET$signalSemaphoreCount, value);
        return this;
    }

    /// Note: the returned {@link IntPtr} does not have correct
    /// {@link IntPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link IntPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable @Unsigned IntPtr pSignalSemaphoreDeviceIndices() {
        MemorySegment s = pSignalSemaphoreDeviceIndicesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new IntPtr(s);
    }

    public VkDeviceGroupSubmitInfo pSignalSemaphoreDeviceIndices(@Nullable @Unsigned IntPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pSignalSemaphoreDeviceIndicesRaw(s);
        return this;
    }

    public @Pointer(comment="uint32_t*") @NotNull MemorySegment pSignalSemaphoreDeviceIndicesRaw() {
        return segment.get(LAYOUT$pSignalSemaphoreDeviceIndices, OFFSET$pSignalSemaphoreDeviceIndices);
    }

    public void pSignalSemaphoreDeviceIndicesRaw(@Pointer(comment="uint32_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pSignalSemaphoreDeviceIndices, OFFSET$pSignalSemaphoreDeviceIndices, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("waitSemaphoreCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pWaitSemaphoreDeviceIndices"),
        ValueLayout.JAVA_INT.withName("commandBufferCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pCommandBufferDeviceMasks"),
        ValueLayout.JAVA_INT.withName("signalSemaphoreCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pSignalSemaphoreDeviceIndices")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$waitSemaphoreCount = PathElement.groupElement("waitSemaphoreCount");
    public static final PathElement PATH$pWaitSemaphoreDeviceIndices = PathElement.groupElement("pWaitSemaphoreDeviceIndices");
    public static final PathElement PATH$commandBufferCount = PathElement.groupElement("commandBufferCount");
    public static final PathElement PATH$pCommandBufferDeviceMasks = PathElement.groupElement("pCommandBufferDeviceMasks");
    public static final PathElement PATH$signalSemaphoreCount = PathElement.groupElement("signalSemaphoreCount");
    public static final PathElement PATH$pSignalSemaphoreDeviceIndices = PathElement.groupElement("pSignalSemaphoreDeviceIndices");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$waitSemaphoreCount = (OfInt) LAYOUT.select(PATH$waitSemaphoreCount);
    public static final AddressLayout LAYOUT$pWaitSemaphoreDeviceIndices = (AddressLayout) LAYOUT.select(PATH$pWaitSemaphoreDeviceIndices);
    public static final OfInt LAYOUT$commandBufferCount = (OfInt) LAYOUT.select(PATH$commandBufferCount);
    public static final AddressLayout LAYOUT$pCommandBufferDeviceMasks = (AddressLayout) LAYOUT.select(PATH$pCommandBufferDeviceMasks);
    public static final OfInt LAYOUT$signalSemaphoreCount = (OfInt) LAYOUT.select(PATH$signalSemaphoreCount);
    public static final AddressLayout LAYOUT$pSignalSemaphoreDeviceIndices = (AddressLayout) LAYOUT.select(PATH$pSignalSemaphoreDeviceIndices);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$waitSemaphoreCount = LAYOUT$waitSemaphoreCount.byteSize();
    public static final long SIZE$pWaitSemaphoreDeviceIndices = LAYOUT$pWaitSemaphoreDeviceIndices.byteSize();
    public static final long SIZE$commandBufferCount = LAYOUT$commandBufferCount.byteSize();
    public static final long SIZE$pCommandBufferDeviceMasks = LAYOUT$pCommandBufferDeviceMasks.byteSize();
    public static final long SIZE$signalSemaphoreCount = LAYOUT$signalSemaphoreCount.byteSize();
    public static final long SIZE$pSignalSemaphoreDeviceIndices = LAYOUT$pSignalSemaphoreDeviceIndices.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$waitSemaphoreCount = LAYOUT.byteOffset(PATH$waitSemaphoreCount);
    public static final long OFFSET$pWaitSemaphoreDeviceIndices = LAYOUT.byteOffset(PATH$pWaitSemaphoreDeviceIndices);
    public static final long OFFSET$commandBufferCount = LAYOUT.byteOffset(PATH$commandBufferCount);
    public static final long OFFSET$pCommandBufferDeviceMasks = LAYOUT.byteOffset(PATH$pCommandBufferDeviceMasks);
    public static final long OFFSET$signalSemaphoreCount = LAYOUT.byteOffset(PATH$signalSemaphoreCount);
    public static final long OFFSET$pSignalSemaphoreDeviceIndices = LAYOUT.byteOffset(PATH$pSignalSemaphoreDeviceIndices);
}
