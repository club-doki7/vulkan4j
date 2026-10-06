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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDisplayPlaneCapabilities2KHR.html"><code>VkDisplayPlaneCapabilities2KHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDisplayPlaneCapabilities2KHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkDisplayPlaneCapabilitiesKHR capabilities; // @link substring="VkDisplayPlaneCapabilitiesKHR" target="VkDisplayPlaneCapabilitiesKHR" @link substring="capabilities" target="#capabilities"
/// } VkDisplayPlaneCapabilities2KHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_DISPLAY_PLANE_CAPABILITIES_2_KHR`
///
/// The {@code allocate} ({@link VkDisplayPlaneCapabilities2KHR#allocate(Arena)}, {@link VkDisplayPlaneCapabilities2KHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkDisplayPlaneCapabilities2KHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDisplayPlaneCapabilities2KHR.html"><code>VkDisplayPlaneCapabilities2KHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDisplayPlaneCapabilities2KHR(@NotNull MemorySegment segment) implements IVkDisplayPlaneCapabilities2KHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDisplayPlaneCapabilities2KHR.html"><code>VkDisplayPlaneCapabilities2KHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDisplayPlaneCapabilities2KHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDisplayPlaneCapabilities2KHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDisplayPlaneCapabilities2KHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDisplayPlaneCapabilities2KHR, Iterable<VkDisplayPlaneCapabilities2KHR> {
        public long size() {
            return segment.byteSize() / VkDisplayPlaneCapabilities2KHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDisplayPlaneCapabilities2KHR at(long index) {
            return new VkDisplayPlaneCapabilities2KHR(segment.asSlice(index * VkDisplayPlaneCapabilities2KHR.BYTES, VkDisplayPlaneCapabilities2KHR.BYTES));
        }

        public VkDisplayPlaneCapabilities2KHR.Ptr at(long index, @NotNull Consumer<@NotNull VkDisplayPlaneCapabilities2KHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDisplayPlaneCapabilities2KHR value) {
            MemorySegment s = segment.asSlice(index * VkDisplayPlaneCapabilities2KHR.BYTES, VkDisplayPlaneCapabilities2KHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDisplayPlaneCapabilities2KHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDisplayPlaneCapabilities2KHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDisplayPlaneCapabilities2KHR.BYTES,
                (end - start) * VkDisplayPlaneCapabilities2KHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDisplayPlaneCapabilities2KHR.BYTES));
        }

        public VkDisplayPlaneCapabilities2KHR[] toArray() {
            VkDisplayPlaneCapabilities2KHR[] ret = new VkDisplayPlaneCapabilities2KHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDisplayPlaneCapabilities2KHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDisplayPlaneCapabilities2KHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDisplayPlaneCapabilities2KHR.BYTES;
            }

            @Override
            public VkDisplayPlaneCapabilities2KHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDisplayPlaneCapabilities2KHR ret = new VkDisplayPlaneCapabilities2KHR(segment.asSlice(0, VkDisplayPlaneCapabilities2KHR.BYTES));
                segment = segment.asSlice(VkDisplayPlaneCapabilities2KHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDisplayPlaneCapabilities2KHR allocate(Arena arena) {
        VkDisplayPlaneCapabilities2KHR ret = new VkDisplayPlaneCapabilities2KHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.DISPLAY_PLANE_CAPABILITIES_2_KHR);
        return ret;
    }

    public static VkDisplayPlaneCapabilities2KHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkDisplayPlaneCapabilities2KHR.Ptr ret = new VkDisplayPlaneCapabilities2KHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.DISPLAY_PLANE_CAPABILITIES_2_KHR);
        }
        return ret;
    }

    public static VkDisplayPlaneCapabilities2KHR clone(Arena arena, VkDisplayPlaneCapabilities2KHR src) {
        VkDisplayPlaneCapabilities2KHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.DISPLAY_PLANE_CAPABILITIES_2_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkDisplayPlaneCapabilities2KHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkDisplayPlaneCapabilities2KHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkDisplayPlaneCapabilities2KHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NotNull VkDisplayPlaneCapabilitiesKHR capabilities() {
        return new VkDisplayPlaneCapabilitiesKHR(segment.asSlice(OFFSET$capabilities, LAYOUT$capabilities));
    }

    public VkDisplayPlaneCapabilities2KHR capabilities(@NotNull VkDisplayPlaneCapabilitiesKHR value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$capabilities, SIZE$capabilities);
        return this;
    }

    public VkDisplayPlaneCapabilities2KHR capabilities(Consumer<@NotNull VkDisplayPlaneCapabilitiesKHR> consumer) {
        consumer.accept(capabilities());
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        VkDisplayPlaneCapabilitiesKHR.LAYOUT.withName("capabilities")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$capabilities = PathElement.groupElement("capabilities");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final StructLayout LAYOUT$capabilities = (StructLayout) LAYOUT.select(PATH$capabilities);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$capabilities = LAYOUT$capabilities.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$capabilities = LAYOUT.byteOffset(PATH$capabilities);
}
