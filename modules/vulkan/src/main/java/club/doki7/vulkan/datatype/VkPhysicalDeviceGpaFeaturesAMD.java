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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceGpaFeaturesAMD.html"><code>VkPhysicalDeviceGpaFeaturesAMD</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceGpaFeaturesAMD {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 perfCounters; // @link substring="perfCounters" target="#perfCounters"
///     VkBool32 streamingPerfCounters; // @link substring="streamingPerfCounters" target="#streamingPerfCounters"
///     VkBool32 sqThreadTracing; // @link substring="sqThreadTracing" target="#sqThreadTracing"
///     VkBool32 clockModes; // @link substring="clockModes" target="#clockModes"
/// } VkPhysicalDeviceGpaFeaturesAMD;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_GPA_FEATURES_AMD`
///
/// The {@code allocate} ({@link VkPhysicalDeviceGpaFeaturesAMD#allocate(Arena)}, {@link VkPhysicalDeviceGpaFeaturesAMD#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceGpaFeaturesAMD#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceGpaFeaturesAMD.html"><code>VkPhysicalDeviceGpaFeaturesAMD</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceGpaFeaturesAMD(@NotNull MemorySegment segment) implements IVkPhysicalDeviceGpaFeaturesAMD {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceGpaFeaturesAMD.html"><code>VkPhysicalDeviceGpaFeaturesAMD</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceGpaFeaturesAMD}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceGpaFeaturesAMD to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceGpaFeaturesAMD.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceGpaFeaturesAMD, Iterable<VkPhysicalDeviceGpaFeaturesAMD> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceGpaFeaturesAMD.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceGpaFeaturesAMD at(long index) {
            return new VkPhysicalDeviceGpaFeaturesAMD(segment.asSlice(index * VkPhysicalDeviceGpaFeaturesAMD.BYTES, VkPhysicalDeviceGpaFeaturesAMD.BYTES));
        }

        public VkPhysicalDeviceGpaFeaturesAMD.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceGpaFeaturesAMD> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceGpaFeaturesAMD value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceGpaFeaturesAMD.BYTES, VkPhysicalDeviceGpaFeaturesAMD.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceGpaFeaturesAMD.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceGpaFeaturesAMD.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceGpaFeaturesAMD.BYTES,
                (end - start) * VkPhysicalDeviceGpaFeaturesAMD.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceGpaFeaturesAMD.BYTES));
        }

        public VkPhysicalDeviceGpaFeaturesAMD[] toArray() {
            VkPhysicalDeviceGpaFeaturesAMD[] ret = new VkPhysicalDeviceGpaFeaturesAMD[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceGpaFeaturesAMD> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceGpaFeaturesAMD> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceGpaFeaturesAMD.BYTES;
            }

            @Override
            public VkPhysicalDeviceGpaFeaturesAMD next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceGpaFeaturesAMD ret = new VkPhysicalDeviceGpaFeaturesAMD(segment.asSlice(0, VkPhysicalDeviceGpaFeaturesAMD.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceGpaFeaturesAMD.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceGpaFeaturesAMD allocate(Arena arena) {
        VkPhysicalDeviceGpaFeaturesAMD ret = new VkPhysicalDeviceGpaFeaturesAMD(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_GPA_FEATURES_AMD);
        return ret;
    }

    public static VkPhysicalDeviceGpaFeaturesAMD.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceGpaFeaturesAMD.Ptr ret = new VkPhysicalDeviceGpaFeaturesAMD.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_GPA_FEATURES_AMD);
        }
        return ret;
    }

    public static VkPhysicalDeviceGpaFeaturesAMD clone(Arena arena, VkPhysicalDeviceGpaFeaturesAMD src) {
        VkPhysicalDeviceGpaFeaturesAMD ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_GPA_FEATURES_AMD);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceGpaFeaturesAMD sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceGpaFeaturesAMD pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceGpaFeaturesAMD pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int perfCounters() {
        return segment.get(LAYOUT$perfCounters, OFFSET$perfCounters);
    }

    public VkPhysicalDeviceGpaFeaturesAMD perfCounters(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$perfCounters, OFFSET$perfCounters, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int streamingPerfCounters() {
        return segment.get(LAYOUT$streamingPerfCounters, OFFSET$streamingPerfCounters);
    }

    public VkPhysicalDeviceGpaFeaturesAMD streamingPerfCounters(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$streamingPerfCounters, OFFSET$streamingPerfCounters, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int sqThreadTracing() {
        return segment.get(LAYOUT$sqThreadTracing, OFFSET$sqThreadTracing);
    }

    public VkPhysicalDeviceGpaFeaturesAMD sqThreadTracing(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$sqThreadTracing, OFFSET$sqThreadTracing, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int clockModes() {
        return segment.get(LAYOUT$clockModes, OFFSET$clockModes);
    }

    public VkPhysicalDeviceGpaFeaturesAMD clockModes(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$clockModes, OFFSET$clockModes, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("perfCounters"),
        ValueLayout.JAVA_INT.withName("streamingPerfCounters"),
        ValueLayout.JAVA_INT.withName("sqThreadTracing"),
        ValueLayout.JAVA_INT.withName("clockModes")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$perfCounters = PathElement.groupElement("perfCounters");
    public static final PathElement PATH$streamingPerfCounters = PathElement.groupElement("streamingPerfCounters");
    public static final PathElement PATH$sqThreadTracing = PathElement.groupElement("sqThreadTracing");
    public static final PathElement PATH$clockModes = PathElement.groupElement("clockModes");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$perfCounters = (OfInt) LAYOUT.select(PATH$perfCounters);
    public static final OfInt LAYOUT$streamingPerfCounters = (OfInt) LAYOUT.select(PATH$streamingPerfCounters);
    public static final OfInt LAYOUT$sqThreadTracing = (OfInt) LAYOUT.select(PATH$sqThreadTracing);
    public static final OfInt LAYOUT$clockModes = (OfInt) LAYOUT.select(PATH$clockModes);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$perfCounters = LAYOUT$perfCounters.byteSize();
    public static final long SIZE$streamingPerfCounters = LAYOUT$streamingPerfCounters.byteSize();
    public static final long SIZE$sqThreadTracing = LAYOUT$sqThreadTracing.byteSize();
    public static final long SIZE$clockModes = LAYOUT$clockModes.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$perfCounters = LAYOUT.byteOffset(PATH$perfCounters);
    public static final long OFFSET$streamingPerfCounters = LAYOUT.byteOffset(PATH$streamingPerfCounters);
    public static final long OFFSET$sqThreadTracing = LAYOUT.byteOffset(PATH$sqThreadTracing);
    public static final long OFFSET$clockModes = LAYOUT.byteOffset(PATH$clockModes);
}
