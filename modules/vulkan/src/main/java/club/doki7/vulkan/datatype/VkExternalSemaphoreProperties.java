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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkExternalSemaphoreProperties.html"><code>VkExternalSemaphoreProperties</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkExternalSemaphoreProperties {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkExternalSemaphoreHandleTypeFlags exportFromImportedHandleTypes; // @link substring="VkExternalSemaphoreHandleTypeFlags" target="VkExternalSemaphoreHandleTypeFlags" @link substring="exportFromImportedHandleTypes" target="#exportFromImportedHandleTypes"
///     VkExternalSemaphoreHandleTypeFlags compatibleHandleTypes; // @link substring="VkExternalSemaphoreHandleTypeFlags" target="VkExternalSemaphoreHandleTypeFlags" @link substring="compatibleHandleTypes" target="#compatibleHandleTypes"
///     VkExternalSemaphoreFeatureFlags externalSemaphoreFeatures; // optional // @link substring="VkExternalSemaphoreFeatureFlags" target="VkExternalSemaphoreFeatureFlags" @link substring="externalSemaphoreFeatures" target="#externalSemaphoreFeatures"
/// } VkExternalSemaphoreProperties;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_EXTERNAL_SEMAPHORE_PROPERTIES`
///
/// The {@code allocate} ({@link VkExternalSemaphoreProperties#allocate(Arena)}, {@link VkExternalSemaphoreProperties#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkExternalSemaphoreProperties#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkExternalSemaphoreProperties.html"><code>VkExternalSemaphoreProperties</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkExternalSemaphoreProperties(@NotNull MemorySegment segment) implements IVkExternalSemaphoreProperties {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkExternalSemaphoreProperties.html"><code>VkExternalSemaphoreProperties</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkExternalSemaphoreProperties}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkExternalSemaphoreProperties to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkExternalSemaphoreProperties.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkExternalSemaphoreProperties, Iterable<VkExternalSemaphoreProperties> {
        public long size() {
            return segment.byteSize() / VkExternalSemaphoreProperties.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkExternalSemaphoreProperties at(long index) {
            return new VkExternalSemaphoreProperties(segment.asSlice(index * VkExternalSemaphoreProperties.BYTES, VkExternalSemaphoreProperties.BYTES));
        }

        public VkExternalSemaphoreProperties.Ptr at(long index, @NotNull Consumer<@NotNull VkExternalSemaphoreProperties> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkExternalSemaphoreProperties value) {
            MemorySegment s = segment.asSlice(index * VkExternalSemaphoreProperties.BYTES, VkExternalSemaphoreProperties.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkExternalSemaphoreProperties.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkExternalSemaphoreProperties.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkExternalSemaphoreProperties.BYTES,
                (end - start) * VkExternalSemaphoreProperties.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkExternalSemaphoreProperties.BYTES));
        }

        public VkExternalSemaphoreProperties[] toArray() {
            VkExternalSemaphoreProperties[] ret = new VkExternalSemaphoreProperties[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkExternalSemaphoreProperties> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkExternalSemaphoreProperties> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkExternalSemaphoreProperties.BYTES;
            }

            @Override
            public VkExternalSemaphoreProperties next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkExternalSemaphoreProperties ret = new VkExternalSemaphoreProperties(segment.asSlice(0, VkExternalSemaphoreProperties.BYTES));
                segment = segment.asSlice(VkExternalSemaphoreProperties.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkExternalSemaphoreProperties allocate(Arena arena) {
        VkExternalSemaphoreProperties ret = new VkExternalSemaphoreProperties(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.EXTERNAL_SEMAPHORE_PROPERTIES);
        return ret;
    }

    public static VkExternalSemaphoreProperties.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkExternalSemaphoreProperties.Ptr ret = new VkExternalSemaphoreProperties.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.EXTERNAL_SEMAPHORE_PROPERTIES);
        }
        return ret;
    }

    public static VkExternalSemaphoreProperties clone(Arena arena, VkExternalSemaphoreProperties src) {
        VkExternalSemaphoreProperties ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.EXTERNAL_SEMAPHORE_PROPERTIES);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkExternalSemaphoreProperties sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkExternalSemaphoreProperties pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkExternalSemaphoreProperties pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkExternalSemaphoreHandleTypeFlags.class) int exportFromImportedHandleTypes() {
        return segment.get(LAYOUT$exportFromImportedHandleTypes, OFFSET$exportFromImportedHandleTypes);
    }

    public VkExternalSemaphoreProperties exportFromImportedHandleTypes(@Bitmask(VkExternalSemaphoreHandleTypeFlags.class) int value) {
        segment.set(LAYOUT$exportFromImportedHandleTypes, OFFSET$exportFromImportedHandleTypes, value);
        return this;
    }

    public @Bitmask(VkExternalSemaphoreHandleTypeFlags.class) int compatibleHandleTypes() {
        return segment.get(LAYOUT$compatibleHandleTypes, OFFSET$compatibleHandleTypes);
    }

    public VkExternalSemaphoreProperties compatibleHandleTypes(@Bitmask(VkExternalSemaphoreHandleTypeFlags.class) int value) {
        segment.set(LAYOUT$compatibleHandleTypes, OFFSET$compatibleHandleTypes, value);
        return this;
    }

    public @Bitmask(VkExternalSemaphoreFeatureFlags.class) int externalSemaphoreFeatures() {
        return segment.get(LAYOUT$externalSemaphoreFeatures, OFFSET$externalSemaphoreFeatures);
    }

    public VkExternalSemaphoreProperties externalSemaphoreFeatures(@Bitmask(VkExternalSemaphoreFeatureFlags.class) int value) {
        segment.set(LAYOUT$externalSemaphoreFeatures, OFFSET$externalSemaphoreFeatures, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("exportFromImportedHandleTypes"),
        ValueLayout.JAVA_INT.withName("compatibleHandleTypes"),
        ValueLayout.JAVA_INT.withName("externalSemaphoreFeatures")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$exportFromImportedHandleTypes = PathElement.groupElement("exportFromImportedHandleTypes");
    public static final PathElement PATH$compatibleHandleTypes = PathElement.groupElement("compatibleHandleTypes");
    public static final PathElement PATH$externalSemaphoreFeatures = PathElement.groupElement("externalSemaphoreFeatures");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$exportFromImportedHandleTypes = (OfInt) LAYOUT.select(PATH$exportFromImportedHandleTypes);
    public static final OfInt LAYOUT$compatibleHandleTypes = (OfInt) LAYOUT.select(PATH$compatibleHandleTypes);
    public static final OfInt LAYOUT$externalSemaphoreFeatures = (OfInt) LAYOUT.select(PATH$externalSemaphoreFeatures);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$exportFromImportedHandleTypes = LAYOUT$exportFromImportedHandleTypes.byteSize();
    public static final long SIZE$compatibleHandleTypes = LAYOUT$compatibleHandleTypes.byteSize();
    public static final long SIZE$externalSemaphoreFeatures = LAYOUT$externalSemaphoreFeatures.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$exportFromImportedHandleTypes = LAYOUT.byteOffset(PATH$exportFromImportedHandleTypes);
    public static final long OFFSET$compatibleHandleTypes = LAYOUT.byteOffset(PATH$compatibleHandleTypes);
    public static final long OFFSET$externalSemaphoreFeatures = LAYOUT.byteOffset(PATH$externalSemaphoreFeatures);
}
