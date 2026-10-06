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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkFormatProperties4KHR.html"><code>VkFormatProperties4KHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkFormatProperties4KHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkFormatFeatureFlags4KHR linearTilingFeatures; // optional // @link substring="VkFormatFeatureFlags4KHR" target="VkFormatFeatureFlags4KHR" @link substring="linearTilingFeatures" target="#linearTilingFeatures"
///     VkFormatFeatureFlags4KHR optimalTilingFeatures; // optional // @link substring="VkFormatFeatureFlags4KHR" target="VkFormatFeatureFlags4KHR" @link substring="optimalTilingFeatures" target="#optimalTilingFeatures"
///     VkFormatFeatureFlags4KHR bufferFeatures; // optional // @link substring="VkFormatFeatureFlags4KHR" target="VkFormatFeatureFlags4KHR" @link substring="bufferFeatures" target="#bufferFeatures"
/// } VkFormatProperties4KHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_FORMAT_PROPERTIES_4_KHR`
///
/// The {@code allocate} ({@link VkFormatProperties4KHR#allocate(Arena)}, {@link VkFormatProperties4KHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkFormatProperties4KHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkFormatProperties4KHR.html"><code>VkFormatProperties4KHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkFormatProperties4KHR(@NotNull MemorySegment segment) implements IVkFormatProperties4KHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkFormatProperties4KHR.html"><code>VkFormatProperties4KHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkFormatProperties4KHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkFormatProperties4KHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkFormatProperties4KHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkFormatProperties4KHR, Iterable<VkFormatProperties4KHR> {
        public long size() {
            return segment.byteSize() / VkFormatProperties4KHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkFormatProperties4KHR at(long index) {
            return new VkFormatProperties4KHR(segment.asSlice(index * VkFormatProperties4KHR.BYTES, VkFormatProperties4KHR.BYTES));
        }

        public VkFormatProperties4KHR.Ptr at(long index, @NotNull Consumer<@NotNull VkFormatProperties4KHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkFormatProperties4KHR value) {
            MemorySegment s = segment.asSlice(index * VkFormatProperties4KHR.BYTES, VkFormatProperties4KHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkFormatProperties4KHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkFormatProperties4KHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkFormatProperties4KHR.BYTES,
                (end - start) * VkFormatProperties4KHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkFormatProperties4KHR.BYTES));
        }

        public VkFormatProperties4KHR[] toArray() {
            VkFormatProperties4KHR[] ret = new VkFormatProperties4KHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkFormatProperties4KHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkFormatProperties4KHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkFormatProperties4KHR.BYTES;
            }

            @Override
            public VkFormatProperties4KHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkFormatProperties4KHR ret = new VkFormatProperties4KHR(segment.asSlice(0, VkFormatProperties4KHR.BYTES));
                segment = segment.asSlice(VkFormatProperties4KHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkFormatProperties4KHR allocate(Arena arena) {
        VkFormatProperties4KHR ret = new VkFormatProperties4KHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.FORMAT_PROPERTIES_4_KHR);
        return ret;
    }

    public static VkFormatProperties4KHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkFormatProperties4KHR.Ptr ret = new VkFormatProperties4KHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.FORMAT_PROPERTIES_4_KHR);
        }
        return ret;
    }

    public static VkFormatProperties4KHR clone(Arena arena, VkFormatProperties4KHR src) {
        VkFormatProperties4KHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.FORMAT_PROPERTIES_4_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkFormatProperties4KHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkFormatProperties4KHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkFormatProperties4KHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkFormatFeatureFlags4KHR.class) long linearTilingFeatures() {
        return segment.get(LAYOUT$linearTilingFeatures, OFFSET$linearTilingFeatures);
    }

    public VkFormatProperties4KHR linearTilingFeatures(@Bitmask(VkFormatFeatureFlags4KHR.class) long value) {
        segment.set(LAYOUT$linearTilingFeatures, OFFSET$linearTilingFeatures, value);
        return this;
    }

    public @Bitmask(VkFormatFeatureFlags4KHR.class) long optimalTilingFeatures() {
        return segment.get(LAYOUT$optimalTilingFeatures, OFFSET$optimalTilingFeatures);
    }

    public VkFormatProperties4KHR optimalTilingFeatures(@Bitmask(VkFormatFeatureFlags4KHR.class) long value) {
        segment.set(LAYOUT$optimalTilingFeatures, OFFSET$optimalTilingFeatures, value);
        return this;
    }

    public @Bitmask(VkFormatFeatureFlags4KHR.class) long bufferFeatures() {
        return segment.get(LAYOUT$bufferFeatures, OFFSET$bufferFeatures);
    }

    public VkFormatProperties4KHR bufferFeatures(@Bitmask(VkFormatFeatureFlags4KHR.class) long value) {
        segment.set(LAYOUT$bufferFeatures, OFFSET$bufferFeatures, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_LONG.withName("linearTilingFeatures"),
        ValueLayout.JAVA_LONG.withName("optimalTilingFeatures"),
        ValueLayout.JAVA_LONG.withName("bufferFeatures")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$linearTilingFeatures = PathElement.groupElement("linearTilingFeatures");
    public static final PathElement PATH$optimalTilingFeatures = PathElement.groupElement("optimalTilingFeatures");
    public static final PathElement PATH$bufferFeatures = PathElement.groupElement("bufferFeatures");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfLong LAYOUT$linearTilingFeatures = (OfLong) LAYOUT.select(PATH$linearTilingFeatures);
    public static final OfLong LAYOUT$optimalTilingFeatures = (OfLong) LAYOUT.select(PATH$optimalTilingFeatures);
    public static final OfLong LAYOUT$bufferFeatures = (OfLong) LAYOUT.select(PATH$bufferFeatures);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$linearTilingFeatures = LAYOUT$linearTilingFeatures.byteSize();
    public static final long SIZE$optimalTilingFeatures = LAYOUT$optimalTilingFeatures.byteSize();
    public static final long SIZE$bufferFeatures = LAYOUT$bufferFeatures.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$linearTilingFeatures = LAYOUT.byteOffset(PATH$linearTilingFeatures);
    public static final long OFFSET$optimalTilingFeatures = LAYOUT.byteOffset(PATH$optimalTilingFeatures);
    public static final long OFFSET$bufferFeatures = LAYOUT.byteOffset(PATH$bufferFeatures);
}
