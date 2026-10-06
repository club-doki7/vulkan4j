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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkTensorExplicitTilingFormatPropertiesARM.html"><code>VkTensorExplicitTilingFormatPropertiesARM</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkTensorExplicitTilingFormatPropertiesARM {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkFormatFeatureFlags2 brick16TilingTensorFeatures; // @link substring="VkFormatFeatureFlags2" target="VkFormatFeatureFlags2" @link substring="brick16TilingTensorFeatures" target="#brick16TilingTensorFeatures"
///     VkFormatFeatureFlags2 brick8TilingTensorFeatures; // @link substring="VkFormatFeatureFlags2" target="VkFormatFeatureFlags2" @link substring="brick8TilingTensorFeatures" target="#brick8TilingTensorFeatures"
///     VkFormatFeatureFlags2 brick4TilingTensorFeatures; // @link substring="VkFormatFeatureFlags2" target="VkFormatFeatureFlags2" @link substring="brick4TilingTensorFeatures" target="#brick4TilingTensorFeatures"
///     VkFormatFeatureFlags2 blockUTilingTensorFeatures; // @link substring="VkFormatFeatureFlags2" target="VkFormatFeatureFlags2" @link substring="blockUTilingTensorFeatures" target="#blockUTilingTensorFeatures"
///     VkFormatFeatureFlags2 blockU64kTilingTensorFeatures; // @link substring="VkFormatFeatureFlags2" target="VkFormatFeatureFlags2" @link substring="blockU64kTilingTensorFeatures" target="#blockU64kTilingTensorFeatures"
/// } VkTensorExplicitTilingFormatPropertiesARM;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_TENSOR_EXPLICIT_TILING_FORMAT_PROPERTIES_ARM`
///
/// The {@code allocate} ({@link VkTensorExplicitTilingFormatPropertiesARM#allocate(Arena)}, {@link VkTensorExplicitTilingFormatPropertiesARM#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkTensorExplicitTilingFormatPropertiesARM#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkTensorExplicitTilingFormatPropertiesARM.html"><code>VkTensorExplicitTilingFormatPropertiesARM</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkTensorExplicitTilingFormatPropertiesARM(@NotNull MemorySegment segment) implements IVkTensorExplicitTilingFormatPropertiesARM {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkTensorExplicitTilingFormatPropertiesARM.html"><code>VkTensorExplicitTilingFormatPropertiesARM</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkTensorExplicitTilingFormatPropertiesARM}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkTensorExplicitTilingFormatPropertiesARM to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkTensorExplicitTilingFormatPropertiesARM.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkTensorExplicitTilingFormatPropertiesARM, Iterable<VkTensorExplicitTilingFormatPropertiesARM> {
        public long size() {
            return segment.byteSize() / VkTensorExplicitTilingFormatPropertiesARM.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkTensorExplicitTilingFormatPropertiesARM at(long index) {
            return new VkTensorExplicitTilingFormatPropertiesARM(segment.asSlice(index * VkTensorExplicitTilingFormatPropertiesARM.BYTES, VkTensorExplicitTilingFormatPropertiesARM.BYTES));
        }

        public VkTensorExplicitTilingFormatPropertiesARM.Ptr at(long index, @NotNull Consumer<@NotNull VkTensorExplicitTilingFormatPropertiesARM> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkTensorExplicitTilingFormatPropertiesARM value) {
            MemorySegment s = segment.asSlice(index * VkTensorExplicitTilingFormatPropertiesARM.BYTES, VkTensorExplicitTilingFormatPropertiesARM.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkTensorExplicitTilingFormatPropertiesARM.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkTensorExplicitTilingFormatPropertiesARM.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkTensorExplicitTilingFormatPropertiesARM.BYTES,
                (end - start) * VkTensorExplicitTilingFormatPropertiesARM.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkTensorExplicitTilingFormatPropertiesARM.BYTES));
        }

        public VkTensorExplicitTilingFormatPropertiesARM[] toArray() {
            VkTensorExplicitTilingFormatPropertiesARM[] ret = new VkTensorExplicitTilingFormatPropertiesARM[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkTensorExplicitTilingFormatPropertiesARM> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkTensorExplicitTilingFormatPropertiesARM> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkTensorExplicitTilingFormatPropertiesARM.BYTES;
            }

            @Override
            public VkTensorExplicitTilingFormatPropertiesARM next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkTensorExplicitTilingFormatPropertiesARM ret = new VkTensorExplicitTilingFormatPropertiesARM(segment.asSlice(0, VkTensorExplicitTilingFormatPropertiesARM.BYTES));
                segment = segment.asSlice(VkTensorExplicitTilingFormatPropertiesARM.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkTensorExplicitTilingFormatPropertiesARM allocate(Arena arena) {
        VkTensorExplicitTilingFormatPropertiesARM ret = new VkTensorExplicitTilingFormatPropertiesARM(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.TENSOR_EXPLICIT_TILING_FORMAT_PROPERTIES_ARM);
        return ret;
    }

    public static VkTensorExplicitTilingFormatPropertiesARM.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkTensorExplicitTilingFormatPropertiesARM.Ptr ret = new VkTensorExplicitTilingFormatPropertiesARM.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.TENSOR_EXPLICIT_TILING_FORMAT_PROPERTIES_ARM);
        }
        return ret;
    }

    public static VkTensorExplicitTilingFormatPropertiesARM clone(Arena arena, VkTensorExplicitTilingFormatPropertiesARM src) {
        VkTensorExplicitTilingFormatPropertiesARM ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.TENSOR_EXPLICIT_TILING_FORMAT_PROPERTIES_ARM);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkTensorExplicitTilingFormatPropertiesARM sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkTensorExplicitTilingFormatPropertiesARM pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkTensorExplicitTilingFormatPropertiesARM pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkFormatFeatureFlags2.class) long brick16TilingTensorFeatures() {
        return segment.get(LAYOUT$brick16TilingTensorFeatures, OFFSET$brick16TilingTensorFeatures);
    }

    public VkTensorExplicitTilingFormatPropertiesARM brick16TilingTensorFeatures(@Bitmask(VkFormatFeatureFlags2.class) long value) {
        segment.set(LAYOUT$brick16TilingTensorFeatures, OFFSET$brick16TilingTensorFeatures, value);
        return this;
    }

    public @Bitmask(VkFormatFeatureFlags2.class) long brick8TilingTensorFeatures() {
        return segment.get(LAYOUT$brick8TilingTensorFeatures, OFFSET$brick8TilingTensorFeatures);
    }

    public VkTensorExplicitTilingFormatPropertiesARM brick8TilingTensorFeatures(@Bitmask(VkFormatFeatureFlags2.class) long value) {
        segment.set(LAYOUT$brick8TilingTensorFeatures, OFFSET$brick8TilingTensorFeatures, value);
        return this;
    }

    public @Bitmask(VkFormatFeatureFlags2.class) long brick4TilingTensorFeatures() {
        return segment.get(LAYOUT$brick4TilingTensorFeatures, OFFSET$brick4TilingTensorFeatures);
    }

    public VkTensorExplicitTilingFormatPropertiesARM brick4TilingTensorFeatures(@Bitmask(VkFormatFeatureFlags2.class) long value) {
        segment.set(LAYOUT$brick4TilingTensorFeatures, OFFSET$brick4TilingTensorFeatures, value);
        return this;
    }

    public @Bitmask(VkFormatFeatureFlags2.class) long blockUTilingTensorFeatures() {
        return segment.get(LAYOUT$blockUTilingTensorFeatures, OFFSET$blockUTilingTensorFeatures);
    }

    public VkTensorExplicitTilingFormatPropertiesARM blockUTilingTensorFeatures(@Bitmask(VkFormatFeatureFlags2.class) long value) {
        segment.set(LAYOUT$blockUTilingTensorFeatures, OFFSET$blockUTilingTensorFeatures, value);
        return this;
    }

    public @Bitmask(VkFormatFeatureFlags2.class) long blockU64kTilingTensorFeatures() {
        return segment.get(LAYOUT$blockU64kTilingTensorFeatures, OFFSET$blockU64kTilingTensorFeatures);
    }

    public VkTensorExplicitTilingFormatPropertiesARM blockU64kTilingTensorFeatures(@Bitmask(VkFormatFeatureFlags2.class) long value) {
        segment.set(LAYOUT$blockU64kTilingTensorFeatures, OFFSET$blockU64kTilingTensorFeatures, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_LONG.withName("brick16TilingTensorFeatures"),
        ValueLayout.JAVA_LONG.withName("brick8TilingTensorFeatures"),
        ValueLayout.JAVA_LONG.withName("brick4TilingTensorFeatures"),
        ValueLayout.JAVA_LONG.withName("blockUTilingTensorFeatures"),
        ValueLayout.JAVA_LONG.withName("blockU64kTilingTensorFeatures")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$brick16TilingTensorFeatures = PathElement.groupElement("brick16TilingTensorFeatures");
    public static final PathElement PATH$brick8TilingTensorFeatures = PathElement.groupElement("brick8TilingTensorFeatures");
    public static final PathElement PATH$brick4TilingTensorFeatures = PathElement.groupElement("brick4TilingTensorFeatures");
    public static final PathElement PATH$blockUTilingTensorFeatures = PathElement.groupElement("blockUTilingTensorFeatures");
    public static final PathElement PATH$blockU64kTilingTensorFeatures = PathElement.groupElement("blockU64kTilingTensorFeatures");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfLong LAYOUT$brick16TilingTensorFeatures = (OfLong) LAYOUT.select(PATH$brick16TilingTensorFeatures);
    public static final OfLong LAYOUT$brick8TilingTensorFeatures = (OfLong) LAYOUT.select(PATH$brick8TilingTensorFeatures);
    public static final OfLong LAYOUT$brick4TilingTensorFeatures = (OfLong) LAYOUT.select(PATH$brick4TilingTensorFeatures);
    public static final OfLong LAYOUT$blockUTilingTensorFeatures = (OfLong) LAYOUT.select(PATH$blockUTilingTensorFeatures);
    public static final OfLong LAYOUT$blockU64kTilingTensorFeatures = (OfLong) LAYOUT.select(PATH$blockU64kTilingTensorFeatures);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$brick16TilingTensorFeatures = LAYOUT$brick16TilingTensorFeatures.byteSize();
    public static final long SIZE$brick8TilingTensorFeatures = LAYOUT$brick8TilingTensorFeatures.byteSize();
    public static final long SIZE$brick4TilingTensorFeatures = LAYOUT$brick4TilingTensorFeatures.byteSize();
    public static final long SIZE$blockUTilingTensorFeatures = LAYOUT$blockUTilingTensorFeatures.byteSize();
    public static final long SIZE$blockU64kTilingTensorFeatures = LAYOUT$blockU64kTilingTensorFeatures.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$brick16TilingTensorFeatures = LAYOUT.byteOffset(PATH$brick16TilingTensorFeatures);
    public static final long OFFSET$brick8TilingTensorFeatures = LAYOUT.byteOffset(PATH$brick8TilingTensorFeatures);
    public static final long OFFSET$brick4TilingTensorFeatures = LAYOUT.byteOffset(PATH$brick4TilingTensorFeatures);
    public static final long OFFSET$blockUTilingTensorFeatures = LAYOUT.byteOffset(PATH$blockUTilingTensorFeatures);
    public static final long OFFSET$blockU64kTilingTensorFeatures = LAYOUT.byteOffset(PATH$blockU64kTilingTensorFeatures);
}
