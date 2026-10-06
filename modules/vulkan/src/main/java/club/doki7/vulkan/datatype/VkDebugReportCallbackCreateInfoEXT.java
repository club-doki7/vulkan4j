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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDebugReportCallbackCreateInfoEXT.html"><code>VkDebugReportCallbackCreateInfoEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDebugReportCallbackCreateInfoEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkDebugReportFlagsEXT flags; // optional // @link substring="VkDebugReportFlagsEXT" target="VkDebugReportFlagsEXT" @link substring="flags" target="#flags"
///     PFN_vkDebugReportCallbackEXT pfnCallback; // @link substring="PFN_vkDebugReportCallbackEXT" target="IPFN_vkDebugReportCallbackEXT" @link substring="pfnCallback" target="#pfnCallback"
///     void* pUserData; // optional // @link substring="pUserData" target="#pUserData"
/// } VkDebugReportCallbackCreateInfoEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_DEBUG_REPORT_CALLBACK_CREATE_INFO_EXT`
///
/// The {@code allocate} ({@link VkDebugReportCallbackCreateInfoEXT#allocate(Arena)}, {@link VkDebugReportCallbackCreateInfoEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkDebugReportCallbackCreateInfoEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDebugReportCallbackCreateInfoEXT.html"><code>VkDebugReportCallbackCreateInfoEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDebugReportCallbackCreateInfoEXT(@NotNull MemorySegment segment) implements IVkDebugReportCallbackCreateInfoEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDebugReportCallbackCreateInfoEXT.html"><code>VkDebugReportCallbackCreateInfoEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDebugReportCallbackCreateInfoEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDebugReportCallbackCreateInfoEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDebugReportCallbackCreateInfoEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDebugReportCallbackCreateInfoEXT, Iterable<VkDebugReportCallbackCreateInfoEXT> {
        public long size() {
            return segment.byteSize() / VkDebugReportCallbackCreateInfoEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDebugReportCallbackCreateInfoEXT at(long index) {
            return new VkDebugReportCallbackCreateInfoEXT(segment.asSlice(index * VkDebugReportCallbackCreateInfoEXT.BYTES, VkDebugReportCallbackCreateInfoEXT.BYTES));
        }

        public VkDebugReportCallbackCreateInfoEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkDebugReportCallbackCreateInfoEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDebugReportCallbackCreateInfoEXT value) {
            MemorySegment s = segment.asSlice(index * VkDebugReportCallbackCreateInfoEXT.BYTES, VkDebugReportCallbackCreateInfoEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDebugReportCallbackCreateInfoEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDebugReportCallbackCreateInfoEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDebugReportCallbackCreateInfoEXT.BYTES,
                (end - start) * VkDebugReportCallbackCreateInfoEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDebugReportCallbackCreateInfoEXT.BYTES));
        }

        public VkDebugReportCallbackCreateInfoEXT[] toArray() {
            VkDebugReportCallbackCreateInfoEXT[] ret = new VkDebugReportCallbackCreateInfoEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDebugReportCallbackCreateInfoEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDebugReportCallbackCreateInfoEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDebugReportCallbackCreateInfoEXT.BYTES;
            }

            @Override
            public VkDebugReportCallbackCreateInfoEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDebugReportCallbackCreateInfoEXT ret = new VkDebugReportCallbackCreateInfoEXT(segment.asSlice(0, VkDebugReportCallbackCreateInfoEXT.BYTES));
                segment = segment.asSlice(VkDebugReportCallbackCreateInfoEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDebugReportCallbackCreateInfoEXT allocate(Arena arena) {
        VkDebugReportCallbackCreateInfoEXT ret = new VkDebugReportCallbackCreateInfoEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.DEBUG_REPORT_CALLBACK_CREATE_INFO_EXT);
        return ret;
    }

    public static VkDebugReportCallbackCreateInfoEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkDebugReportCallbackCreateInfoEXT.Ptr ret = new VkDebugReportCallbackCreateInfoEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.DEBUG_REPORT_CALLBACK_CREATE_INFO_EXT);
        }
        return ret;
    }

    public static VkDebugReportCallbackCreateInfoEXT clone(Arena arena, VkDebugReportCallbackCreateInfoEXT src) {
        VkDebugReportCallbackCreateInfoEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.DEBUG_REPORT_CALLBACK_CREATE_INFO_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkDebugReportCallbackCreateInfoEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkDebugReportCallbackCreateInfoEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkDebugReportCallbackCreateInfoEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkDebugReportFlagsEXT.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkDebugReportCallbackCreateInfoEXT flags(@Bitmask(VkDebugReportFlagsEXT.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @Pointer(comment="PFN_vkDebugReportCallbackEXT") @NotNull MemorySegment pfnCallback() {
        return segment.get(LAYOUT$pfnCallback, OFFSET$pfnCallback);
    }

    public VkDebugReportCallbackCreateInfoEXT pfnCallback(@Pointer(comment="PFN_vkDebugReportCallbackEXT") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pfnCallback, OFFSET$pfnCallback, value);
        return this;
    }

    public VkDebugReportCallbackCreateInfoEXT pfnCallback(@NotNull IPFN_vkDebugReportCallbackEXT value) {
        return pfnCallback(IPFN_vkDebugReportCallbackEXT.ofNative(value));
    }

    public VkDebugReportCallbackCreateInfoEXT pfnCallback(@NotNull Arena arena, @NotNull IPFN_vkDebugReportCallbackEXT value) {
        return pfnCallback(IPFN_vkDebugReportCallbackEXT.ofNative(arena, value));
    }

    public VkDebugReportCallbackCreateInfoEXT pfnCallback(@Nullable IPointer pointer) {
        pfnCallback(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pUserData() {
        return segment.get(LAYOUT$pUserData, OFFSET$pUserData);
    }

    public VkDebugReportCallbackCreateInfoEXT pUserData(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pUserData, OFFSET$pUserData, value);
        return this;
    }

    public VkDebugReportCallbackCreateInfoEXT pUserData(@Nullable IPointer pointer) {
        pUserData(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.ADDRESS.withName("pfnCallback"),
        ValueLayout.ADDRESS.withName("pUserData")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$pfnCallback = PathElement.groupElement("pfnCallback");
    public static final PathElement PATH$pUserData = PathElement.groupElement("pUserData");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final AddressLayout LAYOUT$pfnCallback = (AddressLayout) LAYOUT.select(PATH$pfnCallback);
    public static final AddressLayout LAYOUT$pUserData = (AddressLayout) LAYOUT.select(PATH$pUserData);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$pfnCallback = LAYOUT$pfnCallback.byteSize();
    public static final long SIZE$pUserData = LAYOUT$pUserData.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$pfnCallback = LAYOUT.byteOffset(PATH$pfnCallback);
    public static final long OFFSET$pUserData = LAYOUT.byteOffset(PATH$pUserData);
}
