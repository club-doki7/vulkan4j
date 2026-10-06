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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDispatchParametersARM.html"><code>VkDispatchParametersARM</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDispatchParametersARM {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t workGroupBatchSize; // optional // @link substring="workGroupBatchSize" target="#workGroupBatchSize"
///     uint32_t maxQueuedWorkGroupBatches; // optional // @link substring="maxQueuedWorkGroupBatches" target="#maxQueuedWorkGroupBatches"
///     uint32_t maxWarpsPerShaderCore; // optional // @link substring="maxWarpsPerShaderCore" target="#maxWarpsPerShaderCore"
/// } VkDispatchParametersARM;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_DISPATCH_PARAMETERS_ARM`
///
/// The {@code allocate} ({@link VkDispatchParametersARM#allocate(Arena)}, {@link VkDispatchParametersARM#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkDispatchParametersARM#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDispatchParametersARM.html"><code>VkDispatchParametersARM</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDispatchParametersARM(@NotNull MemorySegment segment) implements IVkDispatchParametersARM {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDispatchParametersARM.html"><code>VkDispatchParametersARM</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDispatchParametersARM}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDispatchParametersARM to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDispatchParametersARM.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDispatchParametersARM, Iterable<VkDispatchParametersARM> {
        public long size() {
            return segment.byteSize() / VkDispatchParametersARM.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDispatchParametersARM at(long index) {
            return new VkDispatchParametersARM(segment.asSlice(index * VkDispatchParametersARM.BYTES, VkDispatchParametersARM.BYTES));
        }

        public VkDispatchParametersARM.Ptr at(long index, @NotNull Consumer<@NotNull VkDispatchParametersARM> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDispatchParametersARM value) {
            MemorySegment s = segment.asSlice(index * VkDispatchParametersARM.BYTES, VkDispatchParametersARM.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDispatchParametersARM.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDispatchParametersARM.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDispatchParametersARM.BYTES,
                (end - start) * VkDispatchParametersARM.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDispatchParametersARM.BYTES));
        }

        public VkDispatchParametersARM[] toArray() {
            VkDispatchParametersARM[] ret = new VkDispatchParametersARM[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDispatchParametersARM> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDispatchParametersARM> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDispatchParametersARM.BYTES;
            }

            @Override
            public VkDispatchParametersARM next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDispatchParametersARM ret = new VkDispatchParametersARM(segment.asSlice(0, VkDispatchParametersARM.BYTES));
                segment = segment.asSlice(VkDispatchParametersARM.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDispatchParametersARM allocate(Arena arena) {
        VkDispatchParametersARM ret = new VkDispatchParametersARM(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.DISPATCH_PARAMETERS_ARM);
        return ret;
    }

    public static VkDispatchParametersARM.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkDispatchParametersARM.Ptr ret = new VkDispatchParametersARM.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.DISPATCH_PARAMETERS_ARM);
        }
        return ret;
    }

    public static VkDispatchParametersARM clone(Arena arena, VkDispatchParametersARM src) {
        VkDispatchParametersARM ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.DISPATCH_PARAMETERS_ARM);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkDispatchParametersARM sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkDispatchParametersARM pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkDispatchParametersARM pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int workGroupBatchSize() {
        return segment.get(LAYOUT$workGroupBatchSize, OFFSET$workGroupBatchSize);
    }

    public VkDispatchParametersARM workGroupBatchSize(@Unsigned int value) {
        segment.set(LAYOUT$workGroupBatchSize, OFFSET$workGroupBatchSize, value);
        return this;
    }

    public @Unsigned int maxQueuedWorkGroupBatches() {
        return segment.get(LAYOUT$maxQueuedWorkGroupBatches, OFFSET$maxQueuedWorkGroupBatches);
    }

    public VkDispatchParametersARM maxQueuedWorkGroupBatches(@Unsigned int value) {
        segment.set(LAYOUT$maxQueuedWorkGroupBatches, OFFSET$maxQueuedWorkGroupBatches, value);
        return this;
    }

    public @Unsigned int maxWarpsPerShaderCore() {
        return segment.get(LAYOUT$maxWarpsPerShaderCore, OFFSET$maxWarpsPerShaderCore);
    }

    public VkDispatchParametersARM maxWarpsPerShaderCore(@Unsigned int value) {
        segment.set(LAYOUT$maxWarpsPerShaderCore, OFFSET$maxWarpsPerShaderCore, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("workGroupBatchSize"),
        ValueLayout.JAVA_INT.withName("maxQueuedWorkGroupBatches"),
        ValueLayout.JAVA_INT.withName("maxWarpsPerShaderCore")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$workGroupBatchSize = PathElement.groupElement("workGroupBatchSize");
    public static final PathElement PATH$maxQueuedWorkGroupBatches = PathElement.groupElement("maxQueuedWorkGroupBatches");
    public static final PathElement PATH$maxWarpsPerShaderCore = PathElement.groupElement("maxWarpsPerShaderCore");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$workGroupBatchSize = (OfInt) LAYOUT.select(PATH$workGroupBatchSize);
    public static final OfInt LAYOUT$maxQueuedWorkGroupBatches = (OfInt) LAYOUT.select(PATH$maxQueuedWorkGroupBatches);
    public static final OfInt LAYOUT$maxWarpsPerShaderCore = (OfInt) LAYOUT.select(PATH$maxWarpsPerShaderCore);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$workGroupBatchSize = LAYOUT$workGroupBatchSize.byteSize();
    public static final long SIZE$maxQueuedWorkGroupBatches = LAYOUT$maxQueuedWorkGroupBatches.byteSize();
    public static final long SIZE$maxWarpsPerShaderCore = LAYOUT$maxWarpsPerShaderCore.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$workGroupBatchSize = LAYOUT.byteOffset(PATH$workGroupBatchSize);
    public static final long OFFSET$maxQueuedWorkGroupBatches = LAYOUT.byteOffset(PATH$maxQueuedWorkGroupBatches);
    public static final long OFFSET$maxWarpsPerShaderCore = LAYOUT.byteOffset(PATH$maxWarpsPerShaderCore);
}
