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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkValidationFeaturesEXT.html"><code>VkValidationFeaturesEXT</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkValidationFeaturesEXT {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t enabledValidationFeatureCount; // optional // @link substring="enabledValidationFeatureCount" target="#enabledValidationFeatureCount"
///     VkValidationFeatureEnableEXT const* pEnabledValidationFeatures; // optional // @link substring="VkValidationFeatureEnableEXT" target="VkValidationFeatureEnableEXT" @link substring="pEnabledValidationFeatures" target="#pEnabledValidationFeatures"
///     uint32_t disabledValidationFeatureCount; // optional // @link substring="disabledValidationFeatureCount" target="#disabledValidationFeatureCount"
///     VkValidationFeatureDisableEXT const* pDisabledValidationFeatures; // optional // @link substring="VkValidationFeatureDisableEXT" target="VkValidationFeatureDisableEXT" @link substring="pDisabledValidationFeatures" target="#pDisabledValidationFeatures"
/// } VkValidationFeaturesEXT;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_VALIDATION_FEATURES_EXT`
///
/// The {@code allocate} ({@link VkValidationFeaturesEXT#allocate(Arena)}, {@link VkValidationFeaturesEXT#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkValidationFeaturesEXT#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkValidationFeaturesEXT.html"><code>VkValidationFeaturesEXT</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkValidationFeaturesEXT(@NotNull MemorySegment segment) implements IVkValidationFeaturesEXT {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkValidationFeaturesEXT.html"><code>VkValidationFeaturesEXT</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkValidationFeaturesEXT}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkValidationFeaturesEXT to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkValidationFeaturesEXT.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkValidationFeaturesEXT, Iterable<VkValidationFeaturesEXT> {
        public long size() {
            return segment.byteSize() / VkValidationFeaturesEXT.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkValidationFeaturesEXT at(long index) {
            return new VkValidationFeaturesEXT(segment.asSlice(index * VkValidationFeaturesEXT.BYTES, VkValidationFeaturesEXT.BYTES));
        }

        public VkValidationFeaturesEXT.Ptr at(long index, @NotNull Consumer<@NotNull VkValidationFeaturesEXT> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkValidationFeaturesEXT value) {
            MemorySegment s = segment.asSlice(index * VkValidationFeaturesEXT.BYTES, VkValidationFeaturesEXT.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkValidationFeaturesEXT.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkValidationFeaturesEXT.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkValidationFeaturesEXT.BYTES,
                (end - start) * VkValidationFeaturesEXT.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkValidationFeaturesEXT.BYTES));
        }

        public VkValidationFeaturesEXT[] toArray() {
            VkValidationFeaturesEXT[] ret = new VkValidationFeaturesEXT[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkValidationFeaturesEXT> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkValidationFeaturesEXT> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkValidationFeaturesEXT.BYTES;
            }

            @Override
            public VkValidationFeaturesEXT next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkValidationFeaturesEXT ret = new VkValidationFeaturesEXT(segment.asSlice(0, VkValidationFeaturesEXT.BYTES));
                segment = segment.asSlice(VkValidationFeaturesEXT.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkValidationFeaturesEXT allocate(Arena arena) {
        VkValidationFeaturesEXT ret = new VkValidationFeaturesEXT(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.VALIDATION_FEATURES_EXT);
        return ret;
    }

    public static VkValidationFeaturesEXT.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkValidationFeaturesEXT.Ptr ret = new VkValidationFeaturesEXT.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.VALIDATION_FEATURES_EXT);
        }
        return ret;
    }

    public static VkValidationFeaturesEXT clone(Arena arena, VkValidationFeaturesEXT src) {
        VkValidationFeaturesEXT ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.VALIDATION_FEATURES_EXT);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkValidationFeaturesEXT sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkValidationFeaturesEXT pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkValidationFeaturesEXT pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int enabledValidationFeatureCount() {
        return segment.get(LAYOUT$enabledValidationFeatureCount, OFFSET$enabledValidationFeatureCount);
    }

    public VkValidationFeaturesEXT enabledValidationFeatureCount(@Unsigned int value) {
        segment.set(LAYOUT$enabledValidationFeatureCount, OFFSET$enabledValidationFeatureCount, value);
        return this;
    }


    /// Note: the returned {@link IntPtr} does not have correct
    /// {@link IntPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link IntPtr#reinterpret} to set the size before actually reading fro
    /// or writing to the buffer.
    public @Nullable @EnumType(VkValidationFeatureEnableEXT.class) IntPtr pEnabledValidationFeatures() {
        MemorySegment s = pEnabledValidationFeaturesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new IntPtr(s);
    }

    public VkValidationFeaturesEXT pEnabledValidationFeatures(@Nullable @EnumType(VkValidationFeatureEnableEXT.class) IntPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pEnabledValidationFeaturesRaw(s);
        return this;
    }

    public @Pointer(target=VkValidationFeatureEnableEXT.class) @NotNull MemorySegment pEnabledValidationFeaturesRaw() {
        return segment.get(LAYOUT$pEnabledValidationFeatures, OFFSET$pEnabledValidationFeatures);
    }

    public void pEnabledValidationFeaturesRaw(@Pointer(target=VkValidationFeatureEnableEXT.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pEnabledValidationFeatures, OFFSET$pEnabledValidationFeatures, value);
    }

    public @Unsigned int disabledValidationFeatureCount() {
        return segment.get(LAYOUT$disabledValidationFeatureCount, OFFSET$disabledValidationFeatureCount);
    }

    public VkValidationFeaturesEXT disabledValidationFeatureCount(@Unsigned int value) {
        segment.set(LAYOUT$disabledValidationFeatureCount, OFFSET$disabledValidationFeatureCount, value);
        return this;
    }


    /// Note: the returned {@link IntPtr} does not have correct
    /// {@link IntPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link IntPtr#reinterpret} to set the size before actually reading fro
    /// or writing to the buffer.
    public @Nullable @EnumType(VkValidationFeatureDisableEXT.class) IntPtr pDisabledValidationFeatures() {
        MemorySegment s = pDisabledValidationFeaturesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new IntPtr(s);
    }

    public VkValidationFeaturesEXT pDisabledValidationFeatures(@Nullable @EnumType(VkValidationFeatureDisableEXT.class) IntPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pDisabledValidationFeaturesRaw(s);
        return this;
    }

    public @Pointer(target=VkValidationFeatureDisableEXT.class) @NotNull MemorySegment pDisabledValidationFeaturesRaw() {
        return segment.get(LAYOUT$pDisabledValidationFeatures, OFFSET$pDisabledValidationFeatures);
    }

    public void pDisabledValidationFeaturesRaw(@Pointer(target=VkValidationFeatureDisableEXT.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pDisabledValidationFeatures, OFFSET$pDisabledValidationFeatures, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("enabledValidationFeatureCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pEnabledValidationFeatures"),
        ValueLayout.JAVA_INT.withName("disabledValidationFeatureCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pDisabledValidationFeatures")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$enabledValidationFeatureCount = PathElement.groupElement("enabledValidationFeatureCount");
    public static final PathElement PATH$pEnabledValidationFeatures = PathElement.groupElement("pEnabledValidationFeatures");
    public static final PathElement PATH$disabledValidationFeatureCount = PathElement.groupElement("disabledValidationFeatureCount");
    public static final PathElement PATH$pDisabledValidationFeatures = PathElement.groupElement("pDisabledValidationFeatures");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$enabledValidationFeatureCount = (OfInt) LAYOUT.select(PATH$enabledValidationFeatureCount);
    public static final AddressLayout LAYOUT$pEnabledValidationFeatures = (AddressLayout) LAYOUT.select(PATH$pEnabledValidationFeatures);
    public static final OfInt LAYOUT$disabledValidationFeatureCount = (OfInt) LAYOUT.select(PATH$disabledValidationFeatureCount);
    public static final AddressLayout LAYOUT$pDisabledValidationFeatures = (AddressLayout) LAYOUT.select(PATH$pDisabledValidationFeatures);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$enabledValidationFeatureCount = LAYOUT$enabledValidationFeatureCount.byteSize();
    public static final long SIZE$pEnabledValidationFeatures = LAYOUT$pEnabledValidationFeatures.byteSize();
    public static final long SIZE$disabledValidationFeatureCount = LAYOUT$disabledValidationFeatureCount.byteSize();
    public static final long SIZE$pDisabledValidationFeatures = LAYOUT$pDisabledValidationFeatures.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$enabledValidationFeatureCount = LAYOUT.byteOffset(PATH$enabledValidationFeatureCount);
    public static final long OFFSET$pEnabledValidationFeatures = LAYOUT.byteOffset(PATH$pEnabledValidationFeatures);
    public static final long OFFSET$disabledValidationFeatureCount = LAYOUT.byteOffset(PATH$disabledValidationFeatureCount);
    public static final long OFFSET$pDisabledValidationFeatures = LAYOUT.byteOffset(PATH$pDisabledValidationFeatures);
}
