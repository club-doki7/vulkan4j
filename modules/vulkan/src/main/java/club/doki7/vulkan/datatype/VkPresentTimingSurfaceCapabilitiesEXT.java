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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPresentTimingSurfaceCapabilitiesEXT.html"><code>VkPresentTimingSurfaceCapabilitiesEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPresentTimingSurfaceCapabilitiesEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 presentTimingSupported; // @link substring="presentTimingSupported" target="#presentTimingSupported"
///     VkBool32 presentAtAbsoluteTimeSupported; // @link substring="presentAtAbsoluteTimeSupported" target="#presentAtAbsoluteTimeSupported"
///     VkBool32 presentAtRelativeTimeSupported; // @link substring="presentAtRelativeTimeSupported" target="#presentAtRelativeTimeSupported"
///     VkPresentStageFlagsEXT presentStageQueries; // @link substring="VkPresentStageFlagsEXT" target="VkPresentStageFlagsEXT" @link substring="presentStageQueries" target="#presentStageQueries"
/// } VkPresentTimingSurfaceCapabilitiesEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PRESENT_TIMING_SURFACE_CAPABILITIES_EXT`
///
/// The {@code allocate} ({@link VkPresentTimingSurfaceCapabilitiesEXT#allocate(Arena)}, {@link VkPresentTimingSurfaceCapabilitiesEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPresentTimingSurfaceCapabilitiesEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPresentTimingSurfaceCapabilitiesEXT.html"><code>VkPresentTimingSurfaceCapabilitiesEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPresentTimingSurfaceCapabilitiesEXT(@NotNull MemorySegment segment) implements IVkPresentTimingSurfaceCapabilitiesEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPresentTimingSurfaceCapabilitiesEXT.html"><code>VkPresentTimingSurfaceCapabilitiesEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPresentTimingSurfaceCapabilitiesEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPresentTimingSurfaceCapabilitiesEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPresentTimingSurfaceCapabilitiesEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPresentTimingSurfaceCapabilitiesEXT, Iterable<VkPresentTimingSurfaceCapabilitiesEXT> {
        public long size() {
            return segment.byteSize() / VkPresentTimingSurfaceCapabilitiesEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPresentTimingSurfaceCapabilitiesEXT at(long index) {
            return new VkPresentTimingSurfaceCapabilitiesEXT(segment.asSlice(index * VkPresentTimingSurfaceCapabilitiesEXT.BYTES, VkPresentTimingSurfaceCapabilitiesEXT.BYTES));
        }

        public VkPresentTimingSurfaceCapabilitiesEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkPresentTimingSurfaceCapabilitiesEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPresentTimingSurfaceCapabilitiesEXT value) {
            MemorySegment s = segment.asSlice(index * VkPresentTimingSurfaceCapabilitiesEXT.BYTES, VkPresentTimingSurfaceCapabilitiesEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPresentTimingSurfaceCapabilitiesEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPresentTimingSurfaceCapabilitiesEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPresentTimingSurfaceCapabilitiesEXT.BYTES,
                (end - start) * VkPresentTimingSurfaceCapabilitiesEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPresentTimingSurfaceCapabilitiesEXT.BYTES));
        }

        public VkPresentTimingSurfaceCapabilitiesEXT[] toArray() {
            VkPresentTimingSurfaceCapabilitiesEXT[] ret = new VkPresentTimingSurfaceCapabilitiesEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPresentTimingSurfaceCapabilitiesEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPresentTimingSurfaceCapabilitiesEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPresentTimingSurfaceCapabilitiesEXT.BYTES;
            }

            @Override
            public VkPresentTimingSurfaceCapabilitiesEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPresentTimingSurfaceCapabilitiesEXT ret = new VkPresentTimingSurfaceCapabilitiesEXT(segment.asSlice(0, VkPresentTimingSurfaceCapabilitiesEXT.BYTES));
                segment = segment.asSlice(VkPresentTimingSurfaceCapabilitiesEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPresentTimingSurfaceCapabilitiesEXT allocate(Arena arena) {
        VkPresentTimingSurfaceCapabilitiesEXT ret = new VkPresentTimingSurfaceCapabilitiesEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PRESENT_TIMING_SURFACE_CAPABILITIES_EXT);
        return ret;
    }

    public static VkPresentTimingSurfaceCapabilitiesEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPresentTimingSurfaceCapabilitiesEXT.Ptr ret = new VkPresentTimingSurfaceCapabilitiesEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PRESENT_TIMING_SURFACE_CAPABILITIES_EXT);
        }
        return ret;
    }

    public static VkPresentTimingSurfaceCapabilitiesEXT clone(Arena arena, VkPresentTimingSurfaceCapabilitiesEXT src) {
        VkPresentTimingSurfaceCapabilitiesEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PRESENT_TIMING_SURFACE_CAPABILITIES_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPresentTimingSurfaceCapabilitiesEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPresentTimingSurfaceCapabilitiesEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPresentTimingSurfaceCapabilitiesEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int presentTimingSupported() {
        return segment.get(LAYOUT$presentTimingSupported, OFFSET$presentTimingSupported);
    }

    public VkPresentTimingSurfaceCapabilitiesEXT presentTimingSupported(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$presentTimingSupported, OFFSET$presentTimingSupported, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int presentAtAbsoluteTimeSupported() {
        return segment.get(LAYOUT$presentAtAbsoluteTimeSupported, OFFSET$presentAtAbsoluteTimeSupported);
    }

    public VkPresentTimingSurfaceCapabilitiesEXT presentAtAbsoluteTimeSupported(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$presentAtAbsoluteTimeSupported, OFFSET$presentAtAbsoluteTimeSupported, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int presentAtRelativeTimeSupported() {
        return segment.get(LAYOUT$presentAtRelativeTimeSupported, OFFSET$presentAtRelativeTimeSupported);
    }

    public VkPresentTimingSurfaceCapabilitiesEXT presentAtRelativeTimeSupported(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$presentAtRelativeTimeSupported, OFFSET$presentAtRelativeTimeSupported, value);
        return this;
    }

    public @Bitmask(VkPresentStageFlagsEXT.class) int presentStageQueries() {
        return segment.get(LAYOUT$presentStageQueries, OFFSET$presentStageQueries);
    }

    public VkPresentTimingSurfaceCapabilitiesEXT presentStageQueries(@Bitmask(VkPresentStageFlagsEXT.class) int value) {
        segment.set(LAYOUT$presentStageQueries, OFFSET$presentStageQueries, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("presentTimingSupported"),
        ValueLayout.JAVA_INT.withName("presentAtAbsoluteTimeSupported"),
        ValueLayout.JAVA_INT.withName("presentAtRelativeTimeSupported"),
        ValueLayout.JAVA_INT.withName("presentStageQueries")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$presentTimingSupported = PathElement.groupElement("presentTimingSupported");
    public static final PathElement PATH$presentAtAbsoluteTimeSupported = PathElement.groupElement("presentAtAbsoluteTimeSupported");
    public static final PathElement PATH$presentAtRelativeTimeSupported = PathElement.groupElement("presentAtRelativeTimeSupported");
    public static final PathElement PATH$presentStageQueries = PathElement.groupElement("presentStageQueries");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$presentTimingSupported = (OfInt) LAYOUT.select(PATH$presentTimingSupported);
    public static final OfInt LAYOUT$presentAtAbsoluteTimeSupported = (OfInt) LAYOUT.select(PATH$presentAtAbsoluteTimeSupported);
    public static final OfInt LAYOUT$presentAtRelativeTimeSupported = (OfInt) LAYOUT.select(PATH$presentAtRelativeTimeSupported);
    public static final OfInt LAYOUT$presentStageQueries = (OfInt) LAYOUT.select(PATH$presentStageQueries);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$presentTimingSupported = LAYOUT$presentTimingSupported.byteSize();
    public static final long SIZE$presentAtAbsoluteTimeSupported = LAYOUT$presentAtAbsoluteTimeSupported.byteSize();
    public static final long SIZE$presentAtRelativeTimeSupported = LAYOUT$presentAtRelativeTimeSupported.byteSize();
    public static final long SIZE$presentStageQueries = LAYOUT$presentStageQueries.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$presentTimingSupported = LAYOUT.byteOffset(PATH$presentTimingSupported);
    public static final long OFFSET$presentAtAbsoluteTimeSupported = LAYOUT.byteOffset(PATH$presentAtAbsoluteTimeSupported);
    public static final long OFFSET$presentAtRelativeTimeSupported = LAYOUT.byteOffset(PATH$presentAtRelativeTimeSupported);
    public static final long OFFSET$presentStageQueries = LAYOUT.byteOffset(PATH$presentStageQueries);
}
