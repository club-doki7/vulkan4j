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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineViewportWScalingStateCreateInfoNV.html"><code>VkPipelineViewportWScalingStateCreateInfoNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPipelineViewportWScalingStateCreateInfoNV {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 viewportWScalingEnable; // @link substring="viewportWScalingEnable" target="#viewportWScalingEnable"
///     uint32_t viewportCount; // @link substring="viewportCount" target="#viewportCount"
///     VkViewportWScalingNV const* pViewportWScalings; // @link substring="VkViewportWScalingNV" target="VkViewportWScalingNV" @link substring="pViewportWScalings" target="#pViewportWScalings"
/// } VkPipelineViewportWScalingStateCreateInfoNV;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PIPELINE_VIEWPORT_W_SCALING_STATE_CREATE_INFO_NV`
///
/// The {@code allocate} ({@link VkPipelineViewportWScalingStateCreateInfoNV#allocate(Arena)}, {@link VkPipelineViewportWScalingStateCreateInfoNV#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPipelineViewportWScalingStateCreateInfoNV#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineViewportWScalingStateCreateInfoNV.html"><code>VkPipelineViewportWScalingStateCreateInfoNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPipelineViewportWScalingStateCreateInfoNV(@NotNull MemorySegment segment) implements IVkPipelineViewportWScalingStateCreateInfoNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineViewportWScalingStateCreateInfoNV.html"><code>VkPipelineViewportWScalingStateCreateInfoNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPipelineViewportWScalingStateCreateInfoNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPipelineViewportWScalingStateCreateInfoNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPipelineViewportWScalingStateCreateInfoNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPipelineViewportWScalingStateCreateInfoNV, Iterable<VkPipelineViewportWScalingStateCreateInfoNV> {
        public long size() {
            return segment.byteSize() / VkPipelineViewportWScalingStateCreateInfoNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPipelineViewportWScalingStateCreateInfoNV at(long index) {
            return new VkPipelineViewportWScalingStateCreateInfoNV(segment.asSlice(index * VkPipelineViewportWScalingStateCreateInfoNV.BYTES, VkPipelineViewportWScalingStateCreateInfoNV.BYTES));
        }

        public VkPipelineViewportWScalingStateCreateInfoNV.Ptr at(long index, @NotNull Consumer<@NotNull VkPipelineViewportWScalingStateCreateInfoNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPipelineViewportWScalingStateCreateInfoNV value) {
            MemorySegment s = segment.asSlice(index * VkPipelineViewportWScalingStateCreateInfoNV.BYTES, VkPipelineViewportWScalingStateCreateInfoNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPipelineViewportWScalingStateCreateInfoNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPipelineViewportWScalingStateCreateInfoNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPipelineViewportWScalingStateCreateInfoNV.BYTES,
                (end - start) * VkPipelineViewportWScalingStateCreateInfoNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPipelineViewportWScalingStateCreateInfoNV.BYTES));
        }

        public VkPipelineViewportWScalingStateCreateInfoNV[] toArray() {
            VkPipelineViewportWScalingStateCreateInfoNV[] ret = new VkPipelineViewportWScalingStateCreateInfoNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPipelineViewportWScalingStateCreateInfoNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPipelineViewportWScalingStateCreateInfoNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPipelineViewportWScalingStateCreateInfoNV.BYTES;
            }

            @Override
            public VkPipelineViewportWScalingStateCreateInfoNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPipelineViewportWScalingStateCreateInfoNV ret = new VkPipelineViewportWScalingStateCreateInfoNV(segment.asSlice(0, VkPipelineViewportWScalingStateCreateInfoNV.BYTES));
                segment = segment.asSlice(VkPipelineViewportWScalingStateCreateInfoNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPipelineViewportWScalingStateCreateInfoNV allocate(Arena arena) {
        VkPipelineViewportWScalingStateCreateInfoNV ret = new VkPipelineViewportWScalingStateCreateInfoNV(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PIPELINE_VIEWPORT_W_SCALING_STATE_CREATE_INFO_NV);
        return ret;
    }

    public static VkPipelineViewportWScalingStateCreateInfoNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPipelineViewportWScalingStateCreateInfoNV.Ptr ret = new VkPipelineViewportWScalingStateCreateInfoNV.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PIPELINE_VIEWPORT_W_SCALING_STATE_CREATE_INFO_NV);
        }
        return ret;
    }

    public static VkPipelineViewportWScalingStateCreateInfoNV clone(Arena arena, VkPipelineViewportWScalingStateCreateInfoNV src) {
        VkPipelineViewportWScalingStateCreateInfoNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PIPELINE_VIEWPORT_W_SCALING_STATE_CREATE_INFO_NV);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPipelineViewportWScalingStateCreateInfoNV sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPipelineViewportWScalingStateCreateInfoNV pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPipelineViewportWScalingStateCreateInfoNV pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int viewportWScalingEnable() {
        return segment.get(LAYOUT$viewportWScalingEnable, OFFSET$viewportWScalingEnable);
    }

    public VkPipelineViewportWScalingStateCreateInfoNV viewportWScalingEnable(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$viewportWScalingEnable, OFFSET$viewportWScalingEnable, value);
        return this;
    }

    public @Unsigned int viewportCount() {
        return segment.get(LAYOUT$viewportCount, OFFSET$viewportCount);
    }

    public VkPipelineViewportWScalingStateCreateInfoNV viewportCount(@Unsigned int value) {
        segment.set(LAYOUT$viewportCount, OFFSET$viewportCount, value);
        return this;
    }

    public VkPipelineViewportWScalingStateCreateInfoNV pViewportWScalings(@Nullable IVkViewportWScalingNV value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pViewportWScalingsRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkViewportWScalingNV.Ptr pViewportWScalings(int assumedCount) {
        MemorySegment s = pViewportWScalingsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkViewportWScalingNV.BYTES);
        return new VkViewportWScalingNV.Ptr(s);
    }

    public @Nullable VkViewportWScalingNV pViewportWScalings() {
        MemorySegment s = pViewportWScalingsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkViewportWScalingNV(s);
    }

    public @Pointer(target=VkViewportWScalingNV.class) @NotNull MemorySegment pViewportWScalingsRaw() {
        return segment.get(LAYOUT$pViewportWScalings, OFFSET$pViewportWScalings);
    }

    public void pViewportWScalingsRaw(@Pointer(target=VkViewportWScalingNV.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pViewportWScalings, OFFSET$pViewportWScalings, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("viewportWScalingEnable"),
        ValueLayout.JAVA_INT.withName("viewportCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkViewportWScalingNV.LAYOUT).withName("pViewportWScalings")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$viewportWScalingEnable = PathElement.groupElement("viewportWScalingEnable");
    public static final PathElement PATH$viewportCount = PathElement.groupElement("viewportCount");
    public static final PathElement PATH$pViewportWScalings = PathElement.groupElement("pViewportWScalings");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$viewportWScalingEnable = (OfInt) LAYOUT.select(PATH$viewportWScalingEnable);
    public static final OfInt LAYOUT$viewportCount = (OfInt) LAYOUT.select(PATH$viewportCount);
    public static final AddressLayout LAYOUT$pViewportWScalings = (AddressLayout) LAYOUT.select(PATH$pViewportWScalings);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$viewportWScalingEnable = LAYOUT$viewportWScalingEnable.byteSize();
    public static final long SIZE$viewportCount = LAYOUT$viewportCount.byteSize();
    public static final long SIZE$pViewportWScalings = LAYOUT$pViewportWScalings.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$viewportWScalingEnable = LAYOUT.byteOffset(PATH$viewportWScalingEnable);
    public static final long OFFSET$viewportCount = LAYOUT.byteOffset(PATH$viewportCount);
    public static final long OFFSET$pViewportWScalings = LAYOUT.byteOffset(PATH$pViewportWScalings);
}
