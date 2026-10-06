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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineDynamicStateCreateInfo.html"><code>VkPipelineDynamicStateCreateInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPipelineDynamicStateCreateInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkPipelineDynamicStateCreateFlags flags; // optional // @link substring="VkPipelineDynamicStateCreateFlags" target="VkPipelineDynamicStateCreateFlags" @link substring="flags" target="#flags"
///     uint32_t dynamicStateCount; // optional // @link substring="dynamicStateCount" target="#dynamicStateCount"
///     VkDynamicState const* pDynamicStates; // optional // @link substring="VkDynamicState" target="VkDynamicState" @link substring="pDynamicStates" target="#pDynamicStates"
/// } VkPipelineDynamicStateCreateInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PIPELINE_DYNAMIC_STATE_CREATE_INFO`
///
/// The {@code allocate} ({@link VkPipelineDynamicStateCreateInfo#allocate(Arena)}, {@link VkPipelineDynamicStateCreateInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPipelineDynamicStateCreateInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineDynamicStateCreateInfo.html"><code>VkPipelineDynamicStateCreateInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPipelineDynamicStateCreateInfo(@NotNull MemorySegment segment) implements IVkPipelineDynamicStateCreateInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineDynamicStateCreateInfo.html"><code>VkPipelineDynamicStateCreateInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPipelineDynamicStateCreateInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPipelineDynamicStateCreateInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPipelineDynamicStateCreateInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPipelineDynamicStateCreateInfo, Iterable<VkPipelineDynamicStateCreateInfo> {
        public long size() {
            return segment.byteSize() / VkPipelineDynamicStateCreateInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPipelineDynamicStateCreateInfo at(long index) {
            return new VkPipelineDynamicStateCreateInfo(segment.asSlice(index * VkPipelineDynamicStateCreateInfo.BYTES, VkPipelineDynamicStateCreateInfo.BYTES));
        }

        public VkPipelineDynamicStateCreateInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkPipelineDynamicStateCreateInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPipelineDynamicStateCreateInfo value) {
            MemorySegment s = segment.asSlice(index * VkPipelineDynamicStateCreateInfo.BYTES, VkPipelineDynamicStateCreateInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPipelineDynamicStateCreateInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPipelineDynamicStateCreateInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPipelineDynamicStateCreateInfo.BYTES,
                (end - start) * VkPipelineDynamicStateCreateInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPipelineDynamicStateCreateInfo.BYTES));
        }

        public VkPipelineDynamicStateCreateInfo[] toArray() {
            VkPipelineDynamicStateCreateInfo[] ret = new VkPipelineDynamicStateCreateInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPipelineDynamicStateCreateInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPipelineDynamicStateCreateInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPipelineDynamicStateCreateInfo.BYTES;
            }

            @Override
            public VkPipelineDynamicStateCreateInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPipelineDynamicStateCreateInfo ret = new VkPipelineDynamicStateCreateInfo(segment.asSlice(0, VkPipelineDynamicStateCreateInfo.BYTES));
                segment = segment.asSlice(VkPipelineDynamicStateCreateInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPipelineDynamicStateCreateInfo allocate(Arena arena) {
        VkPipelineDynamicStateCreateInfo ret = new VkPipelineDynamicStateCreateInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PIPELINE_DYNAMIC_STATE_CREATE_INFO);
        return ret;
    }

    public static VkPipelineDynamicStateCreateInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPipelineDynamicStateCreateInfo.Ptr ret = new VkPipelineDynamicStateCreateInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PIPELINE_DYNAMIC_STATE_CREATE_INFO);
        }
        return ret;
    }

    public static VkPipelineDynamicStateCreateInfo clone(Arena arena, VkPipelineDynamicStateCreateInfo src) {
        VkPipelineDynamicStateCreateInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PIPELINE_DYNAMIC_STATE_CREATE_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPipelineDynamicStateCreateInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPipelineDynamicStateCreateInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPipelineDynamicStateCreateInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkPipelineDynamicStateCreateFlags.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkPipelineDynamicStateCreateInfo flags(@Bitmask(VkPipelineDynamicStateCreateFlags.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @Unsigned int dynamicStateCount() {
        return segment.get(LAYOUT$dynamicStateCount, OFFSET$dynamicStateCount);
    }

    public VkPipelineDynamicStateCreateInfo dynamicStateCount(@Unsigned int value) {
        segment.set(LAYOUT$dynamicStateCount, OFFSET$dynamicStateCount, value);
        return this;
    }


    /// Note: the returned {@link IntPtr} does not have correct
    /// {@link IntPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link IntPtr#reinterpret} to set the size before actually reading fro
    /// or writing to the buffer.
    public @Nullable @EnumType(VkDynamicState.class) IntPtr pDynamicStates() {
        MemorySegment s = pDynamicStatesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new IntPtr(s);
    }

    public VkPipelineDynamicStateCreateInfo pDynamicStates(@Nullable @EnumType(VkDynamicState.class) IntPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pDynamicStatesRaw(s);
        return this;
    }

    public @Pointer(target=VkDynamicState.class) @NotNull MemorySegment pDynamicStatesRaw() {
        return segment.get(LAYOUT$pDynamicStates, OFFSET$pDynamicStates);
    }

    public void pDynamicStatesRaw(@Pointer(target=VkDynamicState.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pDynamicStates, OFFSET$pDynamicStates, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("dynamicStateCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pDynamicStates")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$dynamicStateCount = PathElement.groupElement("dynamicStateCount");
    public static final PathElement PATH$pDynamicStates = PathElement.groupElement("pDynamicStates");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$dynamicStateCount = (OfInt) LAYOUT.select(PATH$dynamicStateCount);
    public static final AddressLayout LAYOUT$pDynamicStates = (AddressLayout) LAYOUT.select(PATH$pDynamicStates);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$dynamicStateCount = LAYOUT$dynamicStateCount.byteSize();
    public static final long SIZE$pDynamicStates = LAYOUT$pDynamicStates.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$dynamicStateCount = LAYOUT.byteOffset(PATH$dynamicStateCount);
    public static final long OFFSET$pDynamicStates = LAYOUT.byteOffset(PATH$pDynamicStates);
}
