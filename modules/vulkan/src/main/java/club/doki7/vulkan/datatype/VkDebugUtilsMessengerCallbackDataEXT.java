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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDebugUtilsMessengerCallbackDataEXT.html"><code>VkDebugUtilsMessengerCallbackDataEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDebugUtilsMessengerCallbackDataEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkDebugUtilsMessengerCallbackDataFlagsEXT flags; // optional // @link substring="VkDebugUtilsMessengerCallbackDataFlagsEXT" target="VkDebugUtilsMessengerCallbackDataFlagsEXT" @link substring="flags" target="#flags"
///     char const* pMessageIdName; // optional // @link substring="pMessageIdName" target="#pMessageIdName"
///     int32_t messageIdNumber; // @link substring="messageIdNumber" target="#messageIdNumber"
///     char const* pMessage; // optional // @link substring="pMessage" target="#pMessage"
///     uint32_t queueLabelCount; // optional // @link substring="queueLabelCount" target="#queueLabelCount"
///     VkDebugUtilsLabelEXT const* pQueueLabels; // optional // @link substring="VkDebugUtilsLabelEXT" target="VkDebugUtilsLabelEXT" @link substring="pQueueLabels" target="#pQueueLabels"
///     uint32_t cmdBufLabelCount; // optional // @link substring="cmdBufLabelCount" target="#cmdBufLabelCount"
///     VkDebugUtilsLabelEXT const* pCmdBufLabels; // optional // @link substring="VkDebugUtilsLabelEXT" target="VkDebugUtilsLabelEXT" @link substring="pCmdBufLabels" target="#pCmdBufLabels"
///     uint32_t objectCount; // optional // @link substring="objectCount" target="#objectCount"
///     VkDebugUtilsObjectNameInfoEXT const* pObjects; // optional // @link substring="VkDebugUtilsObjectNameInfoEXT" target="VkDebugUtilsObjectNameInfoEXT" @link substring="pObjects" target="#pObjects"
/// } VkDebugUtilsMessengerCallbackDataEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_DEBUG_UTILS_MESSENGER_CALLBACK_DATA_EXT`
///
/// The {@code allocate} ({@link VkDebugUtilsMessengerCallbackDataEXT#allocate(Arena)}, {@link VkDebugUtilsMessengerCallbackDataEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkDebugUtilsMessengerCallbackDataEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDebugUtilsMessengerCallbackDataEXT.html"><code>VkDebugUtilsMessengerCallbackDataEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDebugUtilsMessengerCallbackDataEXT(@NotNull MemorySegment segment) implements IVkDebugUtilsMessengerCallbackDataEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDebugUtilsMessengerCallbackDataEXT.html"><code>VkDebugUtilsMessengerCallbackDataEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDebugUtilsMessengerCallbackDataEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDebugUtilsMessengerCallbackDataEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDebugUtilsMessengerCallbackDataEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDebugUtilsMessengerCallbackDataEXT, Iterable<VkDebugUtilsMessengerCallbackDataEXT> {
        public long size() {
            return segment.byteSize() / VkDebugUtilsMessengerCallbackDataEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDebugUtilsMessengerCallbackDataEXT at(long index) {
            return new VkDebugUtilsMessengerCallbackDataEXT(segment.asSlice(index * VkDebugUtilsMessengerCallbackDataEXT.BYTES, VkDebugUtilsMessengerCallbackDataEXT.BYTES));
        }

        public VkDebugUtilsMessengerCallbackDataEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkDebugUtilsMessengerCallbackDataEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDebugUtilsMessengerCallbackDataEXT value) {
            MemorySegment s = segment.asSlice(index * VkDebugUtilsMessengerCallbackDataEXT.BYTES, VkDebugUtilsMessengerCallbackDataEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDebugUtilsMessengerCallbackDataEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDebugUtilsMessengerCallbackDataEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDebugUtilsMessengerCallbackDataEXT.BYTES,
                (end - start) * VkDebugUtilsMessengerCallbackDataEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDebugUtilsMessengerCallbackDataEXT.BYTES));
        }

        public VkDebugUtilsMessengerCallbackDataEXT[] toArray() {
            VkDebugUtilsMessengerCallbackDataEXT[] ret = new VkDebugUtilsMessengerCallbackDataEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDebugUtilsMessengerCallbackDataEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDebugUtilsMessengerCallbackDataEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDebugUtilsMessengerCallbackDataEXT.BYTES;
            }

            @Override
            public VkDebugUtilsMessengerCallbackDataEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDebugUtilsMessengerCallbackDataEXT ret = new VkDebugUtilsMessengerCallbackDataEXT(segment.asSlice(0, VkDebugUtilsMessengerCallbackDataEXT.BYTES));
                segment = segment.asSlice(VkDebugUtilsMessengerCallbackDataEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDebugUtilsMessengerCallbackDataEXT allocate(Arena arena) {
        VkDebugUtilsMessengerCallbackDataEXT ret = new VkDebugUtilsMessengerCallbackDataEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.DEBUG_UTILS_MESSENGER_CALLBACK_DATA_EXT);
        return ret;
    }

    public static VkDebugUtilsMessengerCallbackDataEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkDebugUtilsMessengerCallbackDataEXT.Ptr ret = new VkDebugUtilsMessengerCallbackDataEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.DEBUG_UTILS_MESSENGER_CALLBACK_DATA_EXT);
        }
        return ret;
    }

    public static VkDebugUtilsMessengerCallbackDataEXT clone(Arena arena, VkDebugUtilsMessengerCallbackDataEXT src) {
        VkDebugUtilsMessengerCallbackDataEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.DEBUG_UTILS_MESSENGER_CALLBACK_DATA_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkDebugUtilsMessengerCallbackDataEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkDebugUtilsMessengerCallbackDataEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkDebugUtilsMessengerCallbackDataEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkDebugUtilsMessengerCallbackDataFlagsEXT.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkDebugUtilsMessengerCallbackDataEXT flags(@Bitmask(VkDebugUtilsMessengerCallbackDataFlagsEXT.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    /// Note: the returned {@link BytePtr} does not have correct
    /// {@link BytePtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link BytePtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable BytePtr pMessageIdName() {
        MemorySegment s = pMessageIdNameRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new BytePtr(s);
    }

    public VkDebugUtilsMessengerCallbackDataEXT pMessageIdName(@Nullable BytePtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pMessageIdNameRaw(s);
        return this;
    }

    public @Pointer(comment="int8_t*") @NotNull MemorySegment pMessageIdNameRaw() {
        return segment.get(LAYOUT$pMessageIdName, OFFSET$pMessageIdName);
    }

    public void pMessageIdNameRaw(@Pointer(comment="int8_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pMessageIdName, OFFSET$pMessageIdName, value);
    }

    public int messageIdNumber() {
        return segment.get(LAYOUT$messageIdNumber, OFFSET$messageIdNumber);
    }

    public VkDebugUtilsMessengerCallbackDataEXT messageIdNumber(int value) {
        segment.set(LAYOUT$messageIdNumber, OFFSET$messageIdNumber, value);
        return this;
    }

    /// Note: the returned {@link BytePtr} does not have correct
    /// {@link BytePtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link BytePtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable BytePtr pMessage() {
        MemorySegment s = pMessageRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new BytePtr(s);
    }

    public VkDebugUtilsMessengerCallbackDataEXT pMessage(@Nullable BytePtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pMessageRaw(s);
        return this;
    }

    public @Pointer(comment="int8_t*") @NotNull MemorySegment pMessageRaw() {
        return segment.get(LAYOUT$pMessage, OFFSET$pMessage);
    }

    public void pMessageRaw(@Pointer(comment="int8_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pMessage, OFFSET$pMessage, value);
    }

    public @Unsigned int queueLabelCount() {
        return segment.get(LAYOUT$queueLabelCount, OFFSET$queueLabelCount);
    }

    public VkDebugUtilsMessengerCallbackDataEXT queueLabelCount(@Unsigned int value) {
        segment.set(LAYOUT$queueLabelCount, OFFSET$queueLabelCount, value);
        return this;
    }

    public VkDebugUtilsMessengerCallbackDataEXT pQueueLabels(@Nullable IVkDebugUtilsLabelEXT value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pQueueLabelsRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkDebugUtilsLabelEXT.Ptr pQueueLabels(int assumedCount) {
        MemorySegment s = pQueueLabelsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkDebugUtilsLabelEXT.BYTES);
        return new VkDebugUtilsLabelEXT.Ptr(s);
    }

    public @Nullable VkDebugUtilsLabelEXT pQueueLabels() {
        MemorySegment s = pQueueLabelsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkDebugUtilsLabelEXT(s);
    }

    public @Pointer(target=VkDebugUtilsLabelEXT.class) @NotNull MemorySegment pQueueLabelsRaw() {
        return segment.get(LAYOUT$pQueueLabels, OFFSET$pQueueLabels);
    }

    public void pQueueLabelsRaw(@Pointer(target=VkDebugUtilsLabelEXT.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pQueueLabels, OFFSET$pQueueLabels, value);
    }

    public @Unsigned int cmdBufLabelCount() {
        return segment.get(LAYOUT$cmdBufLabelCount, OFFSET$cmdBufLabelCount);
    }

    public VkDebugUtilsMessengerCallbackDataEXT cmdBufLabelCount(@Unsigned int value) {
        segment.set(LAYOUT$cmdBufLabelCount, OFFSET$cmdBufLabelCount, value);
        return this;
    }

    public VkDebugUtilsMessengerCallbackDataEXT pCmdBufLabels(@Nullable IVkDebugUtilsLabelEXT value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pCmdBufLabelsRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkDebugUtilsLabelEXT.Ptr pCmdBufLabels(int assumedCount) {
        MemorySegment s = pCmdBufLabelsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkDebugUtilsLabelEXT.BYTES);
        return new VkDebugUtilsLabelEXT.Ptr(s);
    }

    public @Nullable VkDebugUtilsLabelEXT pCmdBufLabels() {
        MemorySegment s = pCmdBufLabelsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkDebugUtilsLabelEXT(s);
    }

    public @Pointer(target=VkDebugUtilsLabelEXT.class) @NotNull MemorySegment pCmdBufLabelsRaw() {
        return segment.get(LAYOUT$pCmdBufLabels, OFFSET$pCmdBufLabels);
    }

    public void pCmdBufLabelsRaw(@Pointer(target=VkDebugUtilsLabelEXT.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pCmdBufLabels, OFFSET$pCmdBufLabels, value);
    }

    public @Unsigned int objectCount() {
        return segment.get(LAYOUT$objectCount, OFFSET$objectCount);
    }

    public VkDebugUtilsMessengerCallbackDataEXT objectCount(@Unsigned int value) {
        segment.set(LAYOUT$objectCount, OFFSET$objectCount, value);
        return this;
    }

    public VkDebugUtilsMessengerCallbackDataEXT pObjects(@Nullable IVkDebugUtilsObjectNameInfoEXT value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pObjectsRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkDebugUtilsObjectNameInfoEXT.Ptr pObjects(int assumedCount) {
        MemorySegment s = pObjectsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkDebugUtilsObjectNameInfoEXT.BYTES);
        return new VkDebugUtilsObjectNameInfoEXT.Ptr(s);
    }

    public @Nullable VkDebugUtilsObjectNameInfoEXT pObjects() {
        MemorySegment s = pObjectsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkDebugUtilsObjectNameInfoEXT(s);
    }

    public @Pointer(target=VkDebugUtilsObjectNameInfoEXT.class) @NotNull MemorySegment pObjectsRaw() {
        return segment.get(LAYOUT$pObjects, OFFSET$pObjects);
    }

    public void pObjectsRaw(@Pointer(target=VkDebugUtilsObjectNameInfoEXT.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pObjects, OFFSET$pObjects, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE).withName("pMessageIdName"),
        ValueLayout.JAVA_INT.withName("messageIdNumber"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE).withName("pMessage"),
        ValueLayout.JAVA_INT.withName("queueLabelCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkDebugUtilsLabelEXT.LAYOUT).withName("pQueueLabels"),
        ValueLayout.JAVA_INT.withName("cmdBufLabelCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkDebugUtilsLabelEXT.LAYOUT).withName("pCmdBufLabels"),
        ValueLayout.JAVA_INT.withName("objectCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkDebugUtilsObjectNameInfoEXT.LAYOUT).withName("pObjects")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$pMessageIdName = PathElement.groupElement("pMessageIdName");
    public static final PathElement PATH$messageIdNumber = PathElement.groupElement("messageIdNumber");
    public static final PathElement PATH$pMessage = PathElement.groupElement("pMessage");
    public static final PathElement PATH$queueLabelCount = PathElement.groupElement("queueLabelCount");
    public static final PathElement PATH$pQueueLabels = PathElement.groupElement("pQueueLabels");
    public static final PathElement PATH$cmdBufLabelCount = PathElement.groupElement("cmdBufLabelCount");
    public static final PathElement PATH$pCmdBufLabels = PathElement.groupElement("pCmdBufLabels");
    public static final PathElement PATH$objectCount = PathElement.groupElement("objectCount");
    public static final PathElement PATH$pObjects = PathElement.groupElement("pObjects");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final AddressLayout LAYOUT$pMessageIdName = (AddressLayout) LAYOUT.select(PATH$pMessageIdName);
    public static final OfInt LAYOUT$messageIdNumber = (OfInt) LAYOUT.select(PATH$messageIdNumber);
    public static final AddressLayout LAYOUT$pMessage = (AddressLayout) LAYOUT.select(PATH$pMessage);
    public static final OfInt LAYOUT$queueLabelCount = (OfInt) LAYOUT.select(PATH$queueLabelCount);
    public static final AddressLayout LAYOUT$pQueueLabels = (AddressLayout) LAYOUT.select(PATH$pQueueLabels);
    public static final OfInt LAYOUT$cmdBufLabelCount = (OfInt) LAYOUT.select(PATH$cmdBufLabelCount);
    public static final AddressLayout LAYOUT$pCmdBufLabels = (AddressLayout) LAYOUT.select(PATH$pCmdBufLabels);
    public static final OfInt LAYOUT$objectCount = (OfInt) LAYOUT.select(PATH$objectCount);
    public static final AddressLayout LAYOUT$pObjects = (AddressLayout) LAYOUT.select(PATH$pObjects);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$pMessageIdName = LAYOUT$pMessageIdName.byteSize();
    public static final long SIZE$messageIdNumber = LAYOUT$messageIdNumber.byteSize();
    public static final long SIZE$pMessage = LAYOUT$pMessage.byteSize();
    public static final long SIZE$queueLabelCount = LAYOUT$queueLabelCount.byteSize();
    public static final long SIZE$pQueueLabels = LAYOUT$pQueueLabels.byteSize();
    public static final long SIZE$cmdBufLabelCount = LAYOUT$cmdBufLabelCount.byteSize();
    public static final long SIZE$pCmdBufLabels = LAYOUT$pCmdBufLabels.byteSize();
    public static final long SIZE$objectCount = LAYOUT$objectCount.byteSize();
    public static final long SIZE$pObjects = LAYOUT$pObjects.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$pMessageIdName = LAYOUT.byteOffset(PATH$pMessageIdName);
    public static final long OFFSET$messageIdNumber = LAYOUT.byteOffset(PATH$messageIdNumber);
    public static final long OFFSET$pMessage = LAYOUT.byteOffset(PATH$pMessage);
    public static final long OFFSET$queueLabelCount = LAYOUT.byteOffset(PATH$queueLabelCount);
    public static final long OFFSET$pQueueLabels = LAYOUT.byteOffset(PATH$pQueueLabels);
    public static final long OFFSET$cmdBufLabelCount = LAYOUT.byteOffset(PATH$cmdBufLabelCount);
    public static final long OFFSET$pCmdBufLabels = LAYOUT.byteOffset(PATH$pCmdBufLabels);
    public static final long OFFSET$objectCount = LAYOUT.byteOffset(PATH$objectCount);
    public static final long OFFSET$pObjects = LAYOUT.byteOffset(PATH$pObjects);
}
