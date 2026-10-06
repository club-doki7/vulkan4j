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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDebugUtilsMessengerCreateInfoEXT.html"><code>VkDebugUtilsMessengerCreateInfoEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDebugUtilsMessengerCreateInfoEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkDebugUtilsMessengerCreateFlagsEXT flags; // optional // @link substring="VkDebugUtilsMessengerCreateFlagsEXT" target="VkDebugUtilsMessengerCreateFlagsEXT" @link substring="flags" target="#flags"
///     VkDebugUtilsMessageSeverityFlagsEXT messageSeverity; // @link substring="VkDebugUtilsMessageSeverityFlagsEXT" target="VkDebugUtilsMessageSeverityFlagsEXT" @link substring="messageSeverity" target="#messageSeverity"
///     VkDebugUtilsMessageTypeFlagsEXT messageType; // @link substring="VkDebugUtilsMessageTypeFlagsEXT" target="VkDebugUtilsMessageTypeFlagsEXT" @link substring="messageType" target="#messageType"
///     PFN_vkDebugUtilsMessengerCallbackEXT pfnUserCallback; // @link substring="PFN_vkDebugUtilsMessengerCallbackEXT" target="IPFN_vkDebugUtilsMessengerCallbackEXT" @link substring="pfnUserCallback" target="#pfnUserCallback"
///     void* pUserData; // optional // @link substring="pUserData" target="#pUserData"
/// } VkDebugUtilsMessengerCreateInfoEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_DEBUG_UTILS_MESSENGER_CREATE_INFO_EXT`
///
/// The {@code allocate} ({@link VkDebugUtilsMessengerCreateInfoEXT#allocate(Arena)}, {@link VkDebugUtilsMessengerCreateInfoEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkDebugUtilsMessengerCreateInfoEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDebugUtilsMessengerCreateInfoEXT.html"><code>VkDebugUtilsMessengerCreateInfoEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDebugUtilsMessengerCreateInfoEXT(@NotNull MemorySegment segment) implements IVkDebugUtilsMessengerCreateInfoEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDebugUtilsMessengerCreateInfoEXT.html"><code>VkDebugUtilsMessengerCreateInfoEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDebugUtilsMessengerCreateInfoEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDebugUtilsMessengerCreateInfoEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDebugUtilsMessengerCreateInfoEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDebugUtilsMessengerCreateInfoEXT, Iterable<VkDebugUtilsMessengerCreateInfoEXT> {
        public long size() {
            return segment.byteSize() / VkDebugUtilsMessengerCreateInfoEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDebugUtilsMessengerCreateInfoEXT at(long index) {
            return new VkDebugUtilsMessengerCreateInfoEXT(segment.asSlice(index * VkDebugUtilsMessengerCreateInfoEXT.BYTES, VkDebugUtilsMessengerCreateInfoEXT.BYTES));
        }

        public VkDebugUtilsMessengerCreateInfoEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkDebugUtilsMessengerCreateInfoEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDebugUtilsMessengerCreateInfoEXT value) {
            MemorySegment s = segment.asSlice(index * VkDebugUtilsMessengerCreateInfoEXT.BYTES, VkDebugUtilsMessengerCreateInfoEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDebugUtilsMessengerCreateInfoEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDebugUtilsMessengerCreateInfoEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDebugUtilsMessengerCreateInfoEXT.BYTES,
                (end - start) * VkDebugUtilsMessengerCreateInfoEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDebugUtilsMessengerCreateInfoEXT.BYTES));
        }

        public VkDebugUtilsMessengerCreateInfoEXT[] toArray() {
            VkDebugUtilsMessengerCreateInfoEXT[] ret = new VkDebugUtilsMessengerCreateInfoEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDebugUtilsMessengerCreateInfoEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDebugUtilsMessengerCreateInfoEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDebugUtilsMessengerCreateInfoEXT.BYTES;
            }

            @Override
            public VkDebugUtilsMessengerCreateInfoEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDebugUtilsMessengerCreateInfoEXT ret = new VkDebugUtilsMessengerCreateInfoEXT(segment.asSlice(0, VkDebugUtilsMessengerCreateInfoEXT.BYTES));
                segment = segment.asSlice(VkDebugUtilsMessengerCreateInfoEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDebugUtilsMessengerCreateInfoEXT allocate(Arena arena) {
        VkDebugUtilsMessengerCreateInfoEXT ret = new VkDebugUtilsMessengerCreateInfoEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.DEBUG_UTILS_MESSENGER_CREATE_INFO_EXT);
        return ret;
    }

    public static VkDebugUtilsMessengerCreateInfoEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkDebugUtilsMessengerCreateInfoEXT.Ptr ret = new VkDebugUtilsMessengerCreateInfoEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.DEBUG_UTILS_MESSENGER_CREATE_INFO_EXT);
        }
        return ret;
    }

    public static VkDebugUtilsMessengerCreateInfoEXT clone(Arena arena, VkDebugUtilsMessengerCreateInfoEXT src) {
        VkDebugUtilsMessengerCreateInfoEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.DEBUG_UTILS_MESSENGER_CREATE_INFO_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkDebugUtilsMessengerCreateInfoEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkDebugUtilsMessengerCreateInfoEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkDebugUtilsMessengerCreateInfoEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkDebugUtilsMessengerCreateFlagsEXT.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkDebugUtilsMessengerCreateInfoEXT flags(@Bitmask(VkDebugUtilsMessengerCreateFlagsEXT.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @Bitmask(VkDebugUtilsMessageSeverityFlagsEXT.class) int messageSeverity() {
        return segment.get(LAYOUT$messageSeverity, OFFSET$messageSeverity);
    }

    public VkDebugUtilsMessengerCreateInfoEXT messageSeverity(@Bitmask(VkDebugUtilsMessageSeverityFlagsEXT.class) int value) {
        segment.set(LAYOUT$messageSeverity, OFFSET$messageSeverity, value);
        return this;
    }

    public @Bitmask(VkDebugUtilsMessageTypeFlagsEXT.class) int messageType() {
        return segment.get(LAYOUT$messageType, OFFSET$messageType);
    }

    public VkDebugUtilsMessengerCreateInfoEXT messageType(@Bitmask(VkDebugUtilsMessageTypeFlagsEXT.class) int value) {
        segment.set(LAYOUT$messageType, OFFSET$messageType, value);
        return this;
    }

    public @Pointer(comment="PFN_vkDebugUtilsMessengerCallbackEXT") @NotNull MemorySegment pfnUserCallback() {
        return segment.get(LAYOUT$pfnUserCallback, OFFSET$pfnUserCallback);
    }

    public VkDebugUtilsMessengerCreateInfoEXT pfnUserCallback(@Pointer(comment="PFN_vkDebugUtilsMessengerCallbackEXT") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pfnUserCallback, OFFSET$pfnUserCallback, value);
        return this;
    }

    public VkDebugUtilsMessengerCreateInfoEXT pfnUserCallback(@NotNull IPFN_vkDebugUtilsMessengerCallbackEXT value) {
        return pfnUserCallback(IPFN_vkDebugUtilsMessengerCallbackEXT.ofNative(value));
    }

    public VkDebugUtilsMessengerCreateInfoEXT pfnUserCallback(@NotNull Arena arena, @NotNull IPFN_vkDebugUtilsMessengerCallbackEXT value) {
        return pfnUserCallback(IPFN_vkDebugUtilsMessengerCallbackEXT.ofNative(arena, value));
    }

    public VkDebugUtilsMessengerCreateInfoEXT pfnUserCallback(@Nullable IPointer pointer) {
        pfnUserCallback(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pUserData() {
        return segment.get(LAYOUT$pUserData, OFFSET$pUserData);
    }

    public VkDebugUtilsMessengerCreateInfoEXT pUserData(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pUserData, OFFSET$pUserData, value);
        return this;
    }

    public VkDebugUtilsMessengerCreateInfoEXT pUserData(@Nullable IPointer pointer) {
        pUserData(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("messageSeverity"),
        ValueLayout.JAVA_INT.withName("messageType"),
        ValueLayout.ADDRESS.withName("pfnUserCallback"),
        ValueLayout.ADDRESS.withName("pUserData")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$messageSeverity = PathElement.groupElement("messageSeverity");
    public static final PathElement PATH$messageType = PathElement.groupElement("messageType");
    public static final PathElement PATH$pfnUserCallback = PathElement.groupElement("pfnUserCallback");
    public static final PathElement PATH$pUserData = PathElement.groupElement("pUserData");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$messageSeverity = (OfInt) LAYOUT.select(PATH$messageSeverity);
    public static final OfInt LAYOUT$messageType = (OfInt) LAYOUT.select(PATH$messageType);
    public static final AddressLayout LAYOUT$pfnUserCallback = (AddressLayout) LAYOUT.select(PATH$pfnUserCallback);
    public static final AddressLayout LAYOUT$pUserData = (AddressLayout) LAYOUT.select(PATH$pUserData);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$messageSeverity = LAYOUT$messageSeverity.byteSize();
    public static final long SIZE$messageType = LAYOUT$messageType.byteSize();
    public static final long SIZE$pfnUserCallback = LAYOUT$pfnUserCallback.byteSize();
    public static final long SIZE$pUserData = LAYOUT$pUserData.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$messageSeverity = LAYOUT.byteOffset(PATH$messageSeverity);
    public static final long OFFSET$messageType = LAYOUT.byteOffset(PATH$messageType);
    public static final long OFFSET$pfnUserCallback = LAYOUT.byteOffset(PATH$pfnUserCallback);
    public static final long OFFSET$pUserData = LAYOUT.byteOffset(PATH$pUserData);
}
