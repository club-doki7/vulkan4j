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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkLatencySurfaceCapabilitiesNV.html"><code>VkLatencySurfaceCapabilitiesNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkLatencySurfaceCapabilitiesNV {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t presentModeCount; // optional // @link substring="presentModeCount" target="#presentModeCount"
///     VkPresentModeKHR* pPresentModes; // optional // @link substring="VkPresentModeKHR" target="VkPresentModeKHR" @link substring="pPresentModes" target="#pPresentModes"
/// } VkLatencySurfaceCapabilitiesNV;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_LATENCY_SURFACE_CAPABILITIES_NV`
///
/// The {@code allocate} ({@link VkLatencySurfaceCapabilitiesNV#allocate(Arena)}, {@link VkLatencySurfaceCapabilitiesNV#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkLatencySurfaceCapabilitiesNV#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkLatencySurfaceCapabilitiesNV.html"><code>VkLatencySurfaceCapabilitiesNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkLatencySurfaceCapabilitiesNV(@NotNull MemorySegment segment) implements IVkLatencySurfaceCapabilitiesNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkLatencySurfaceCapabilitiesNV.html"><code>VkLatencySurfaceCapabilitiesNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkLatencySurfaceCapabilitiesNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkLatencySurfaceCapabilitiesNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkLatencySurfaceCapabilitiesNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkLatencySurfaceCapabilitiesNV, Iterable<VkLatencySurfaceCapabilitiesNV> {
        public long size() {
            return segment.byteSize() / VkLatencySurfaceCapabilitiesNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkLatencySurfaceCapabilitiesNV at(long index) {
            return new VkLatencySurfaceCapabilitiesNV(segment.asSlice(index * VkLatencySurfaceCapabilitiesNV.BYTES, VkLatencySurfaceCapabilitiesNV.BYTES));
        }

        public VkLatencySurfaceCapabilitiesNV.Ptr at(long index, @NotNull Consumer<@NotNull VkLatencySurfaceCapabilitiesNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkLatencySurfaceCapabilitiesNV value) {
            MemorySegment s = segment.asSlice(index * VkLatencySurfaceCapabilitiesNV.BYTES, VkLatencySurfaceCapabilitiesNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkLatencySurfaceCapabilitiesNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkLatencySurfaceCapabilitiesNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkLatencySurfaceCapabilitiesNV.BYTES,
                (end - start) * VkLatencySurfaceCapabilitiesNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkLatencySurfaceCapabilitiesNV.BYTES));
        }

        public VkLatencySurfaceCapabilitiesNV[] toArray() {
            VkLatencySurfaceCapabilitiesNV[] ret = new VkLatencySurfaceCapabilitiesNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkLatencySurfaceCapabilitiesNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkLatencySurfaceCapabilitiesNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkLatencySurfaceCapabilitiesNV.BYTES;
            }

            @Override
            public VkLatencySurfaceCapabilitiesNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkLatencySurfaceCapabilitiesNV ret = new VkLatencySurfaceCapabilitiesNV(segment.asSlice(0, VkLatencySurfaceCapabilitiesNV.BYTES));
                segment = segment.asSlice(VkLatencySurfaceCapabilitiesNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkLatencySurfaceCapabilitiesNV allocate(Arena arena) {
        VkLatencySurfaceCapabilitiesNV ret = new VkLatencySurfaceCapabilitiesNV(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.LATENCY_SURFACE_CAPABILITIES_NV);
        return ret;
    }

    public static VkLatencySurfaceCapabilitiesNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkLatencySurfaceCapabilitiesNV.Ptr ret = new VkLatencySurfaceCapabilitiesNV.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.LATENCY_SURFACE_CAPABILITIES_NV);
        }
        return ret;
    }

    public static VkLatencySurfaceCapabilitiesNV clone(Arena arena, VkLatencySurfaceCapabilitiesNV src) {
        VkLatencySurfaceCapabilitiesNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.LATENCY_SURFACE_CAPABILITIES_NV);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkLatencySurfaceCapabilitiesNV sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkLatencySurfaceCapabilitiesNV pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkLatencySurfaceCapabilitiesNV pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int presentModeCount() {
        return segment.get(LAYOUT$presentModeCount, OFFSET$presentModeCount);
    }

    public VkLatencySurfaceCapabilitiesNV presentModeCount(@Unsigned int value) {
        segment.set(LAYOUT$presentModeCount, OFFSET$presentModeCount, value);
        return this;
    }


    /// Note: the returned {@link IntPtr} does not have correct
    /// {@link IntPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link IntPtr#reinterpret} to set the size before actually reading fro
    /// or writing to the buffer.
    public @Nullable @EnumType(VkPresentModeKHR.class) IntPtr pPresentModes() {
        MemorySegment s = pPresentModesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new IntPtr(s);
    }

    public VkLatencySurfaceCapabilitiesNV pPresentModes(@Nullable @EnumType(VkPresentModeKHR.class) IntPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pPresentModesRaw(s);
        return this;
    }

    public @Pointer(target=VkPresentModeKHR.class) @NotNull MemorySegment pPresentModesRaw() {
        return segment.get(LAYOUT$pPresentModes, OFFSET$pPresentModes);
    }

    public void pPresentModesRaw(@Pointer(target=VkPresentModeKHR.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pPresentModes, OFFSET$pPresentModes, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("presentModeCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pPresentModes")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$presentModeCount = PathElement.groupElement("presentModeCount");
    public static final PathElement PATH$pPresentModes = PathElement.groupElement("pPresentModes");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$presentModeCount = (OfInt) LAYOUT.select(PATH$presentModeCount);
    public static final AddressLayout LAYOUT$pPresentModes = (AddressLayout) LAYOUT.select(PATH$pPresentModes);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$presentModeCount = LAYOUT$presentModeCount.byteSize();
    public static final long SIZE$pPresentModes = LAYOUT$pPresentModes.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$presentModeCount = LAYOUT.byteOffset(PATH$presentModeCount);
    public static final long OFFSET$pPresentModes = LAYOUT.byteOffset(PATH$pPresentModes);
}
