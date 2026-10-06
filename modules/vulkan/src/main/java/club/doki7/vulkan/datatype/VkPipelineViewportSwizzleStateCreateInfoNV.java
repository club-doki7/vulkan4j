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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineViewportSwizzleStateCreateInfoNV.html"><code>VkPipelineViewportSwizzleStateCreateInfoNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPipelineViewportSwizzleStateCreateInfoNV {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkPipelineViewportSwizzleStateCreateFlagsNV flags; // optional // @link substring="VkPipelineViewportSwizzleStateCreateFlagsNV" target="VkPipelineViewportSwizzleStateCreateFlagsNV" @link substring="flags" target="#flags"
///     uint32_t viewportCount; // @link substring="viewportCount" target="#viewportCount"
///     VkViewportSwizzleNV const* pViewportSwizzles; // @link substring="VkViewportSwizzleNV" target="VkViewportSwizzleNV" @link substring="pViewportSwizzles" target="#pViewportSwizzles"
/// } VkPipelineViewportSwizzleStateCreateInfoNV;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PIPELINE_VIEWPORT_SWIZZLE_STATE_CREATE_INFO_NV`
///
/// The {@code allocate} ({@link VkPipelineViewportSwizzleStateCreateInfoNV#allocate(Arena)}, {@link VkPipelineViewportSwizzleStateCreateInfoNV#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPipelineViewportSwizzleStateCreateInfoNV#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineViewportSwizzleStateCreateInfoNV.html"><code>VkPipelineViewportSwizzleStateCreateInfoNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPipelineViewportSwizzleStateCreateInfoNV(@NotNull MemorySegment segment) implements IVkPipelineViewportSwizzleStateCreateInfoNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineViewportSwizzleStateCreateInfoNV.html"><code>VkPipelineViewportSwizzleStateCreateInfoNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPipelineViewportSwizzleStateCreateInfoNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPipelineViewportSwizzleStateCreateInfoNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPipelineViewportSwizzleStateCreateInfoNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPipelineViewportSwizzleStateCreateInfoNV, Iterable<VkPipelineViewportSwizzleStateCreateInfoNV> {
        public long size() {
            return segment.byteSize() / VkPipelineViewportSwizzleStateCreateInfoNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPipelineViewportSwizzleStateCreateInfoNV at(long index) {
            return new VkPipelineViewportSwizzleStateCreateInfoNV(segment.asSlice(index * VkPipelineViewportSwizzleStateCreateInfoNV.BYTES, VkPipelineViewportSwizzleStateCreateInfoNV.BYTES));
        }

        public VkPipelineViewportSwizzleStateCreateInfoNV.Ptr at(long index, @NotNull Consumer<@NotNull VkPipelineViewportSwizzleStateCreateInfoNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPipelineViewportSwizzleStateCreateInfoNV value) {
            MemorySegment s = segment.asSlice(index * VkPipelineViewportSwizzleStateCreateInfoNV.BYTES, VkPipelineViewportSwizzleStateCreateInfoNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPipelineViewportSwizzleStateCreateInfoNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPipelineViewportSwizzleStateCreateInfoNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPipelineViewportSwizzleStateCreateInfoNV.BYTES,
                (end - start) * VkPipelineViewportSwizzleStateCreateInfoNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPipelineViewportSwizzleStateCreateInfoNV.BYTES));
        }

        public VkPipelineViewportSwizzleStateCreateInfoNV[] toArray() {
            VkPipelineViewportSwizzleStateCreateInfoNV[] ret = new VkPipelineViewportSwizzleStateCreateInfoNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPipelineViewportSwizzleStateCreateInfoNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPipelineViewportSwizzleStateCreateInfoNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPipelineViewportSwizzleStateCreateInfoNV.BYTES;
            }

            @Override
            public VkPipelineViewportSwizzleStateCreateInfoNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPipelineViewportSwizzleStateCreateInfoNV ret = new VkPipelineViewportSwizzleStateCreateInfoNV(segment.asSlice(0, VkPipelineViewportSwizzleStateCreateInfoNV.BYTES));
                segment = segment.asSlice(VkPipelineViewportSwizzleStateCreateInfoNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPipelineViewportSwizzleStateCreateInfoNV allocate(Arena arena) {
        VkPipelineViewportSwizzleStateCreateInfoNV ret = new VkPipelineViewportSwizzleStateCreateInfoNV(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PIPELINE_VIEWPORT_SWIZZLE_STATE_CREATE_INFO_NV);
        return ret;
    }

    public static VkPipelineViewportSwizzleStateCreateInfoNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPipelineViewportSwizzleStateCreateInfoNV.Ptr ret = new VkPipelineViewportSwizzleStateCreateInfoNV.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PIPELINE_VIEWPORT_SWIZZLE_STATE_CREATE_INFO_NV);
        }
        return ret;
    }

    public static VkPipelineViewportSwizzleStateCreateInfoNV clone(Arena arena, VkPipelineViewportSwizzleStateCreateInfoNV src) {
        VkPipelineViewportSwizzleStateCreateInfoNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PIPELINE_VIEWPORT_SWIZZLE_STATE_CREATE_INFO_NV);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPipelineViewportSwizzleStateCreateInfoNV sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPipelineViewportSwizzleStateCreateInfoNV pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPipelineViewportSwizzleStateCreateInfoNV pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkPipelineViewportSwizzleStateCreateFlagsNV.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkPipelineViewportSwizzleStateCreateInfoNV flags(@Bitmask(VkPipelineViewportSwizzleStateCreateFlagsNV.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @Unsigned int viewportCount() {
        return segment.get(LAYOUT$viewportCount, OFFSET$viewportCount);
    }

    public VkPipelineViewportSwizzleStateCreateInfoNV viewportCount(@Unsigned int value) {
        segment.set(LAYOUT$viewportCount, OFFSET$viewportCount, value);
        return this;
    }

    public VkPipelineViewportSwizzleStateCreateInfoNV pViewportSwizzles(@Nullable IVkViewportSwizzleNV value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pViewportSwizzlesRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkViewportSwizzleNV.Ptr pViewportSwizzles(int assumedCount) {
        MemorySegment s = pViewportSwizzlesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkViewportSwizzleNV.BYTES);
        return new VkViewportSwizzleNV.Ptr(s);
    }

    public @Nullable VkViewportSwizzleNV pViewportSwizzles() {
        MemorySegment s = pViewportSwizzlesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkViewportSwizzleNV(s);
    }

    public @Pointer(target=VkViewportSwizzleNV.class) @NotNull MemorySegment pViewportSwizzlesRaw() {
        return segment.get(LAYOUT$pViewportSwizzles, OFFSET$pViewportSwizzles);
    }

    public void pViewportSwizzlesRaw(@Pointer(target=VkViewportSwizzleNV.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pViewportSwizzles, OFFSET$pViewportSwizzles, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("viewportCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkViewportSwizzleNV.LAYOUT).withName("pViewportSwizzles")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$viewportCount = PathElement.groupElement("viewportCount");
    public static final PathElement PATH$pViewportSwizzles = PathElement.groupElement("pViewportSwizzles");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$viewportCount = (OfInt) LAYOUT.select(PATH$viewportCount);
    public static final AddressLayout LAYOUT$pViewportSwizzles = (AddressLayout) LAYOUT.select(PATH$pViewportSwizzles);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$viewportCount = LAYOUT$viewportCount.byteSize();
    public static final long SIZE$pViewportSwizzles = LAYOUT$pViewportSwizzles.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$viewportCount = LAYOUT.byteOffset(PATH$viewportCount);
    public static final long OFFSET$pViewportSwizzles = LAYOUT.byteOffset(PATH$pViewportSwizzles);
}
