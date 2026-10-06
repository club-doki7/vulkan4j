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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPushConstantsInfo.html"><code>VkPushConstantsInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPushConstantsInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkPipelineLayout layout; // optional // @link substring="VkPipelineLayout" target="VkPipelineLayout" @link substring="layout" target="#layout"
///     VkShaderStageFlags stageFlags; // @link substring="VkShaderStageFlags" target="VkShaderStageFlags" @link substring="stageFlags" target="#stageFlags"
///     uint32_t offset; // optional // @link substring="offset" target="#offset"
///     uint32_t size; // @link substring="size" target="#size"
///     void const* pValues; // @link substring="pValues" target="#pValues"
/// } VkPushConstantsInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PUSH_CONSTANTS_INFO`
///
/// The {@code allocate} ({@link VkPushConstantsInfo#allocate(Arena)}, {@link VkPushConstantsInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPushConstantsInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPushConstantsInfo.html"><code>VkPushConstantsInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPushConstantsInfo(@NotNull MemorySegment segment) implements IVkPushConstantsInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPushConstantsInfo.html"><code>VkPushConstantsInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPushConstantsInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPushConstantsInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPushConstantsInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPushConstantsInfo, Iterable<VkPushConstantsInfo> {
        public long size() {
            return segment.byteSize() / VkPushConstantsInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPushConstantsInfo at(long index) {
            return new VkPushConstantsInfo(segment.asSlice(index * VkPushConstantsInfo.BYTES, VkPushConstantsInfo.BYTES));
        }

        public VkPushConstantsInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkPushConstantsInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPushConstantsInfo value) {
            MemorySegment s = segment.asSlice(index * VkPushConstantsInfo.BYTES, VkPushConstantsInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPushConstantsInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPushConstantsInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPushConstantsInfo.BYTES,
                (end - start) * VkPushConstantsInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPushConstantsInfo.BYTES));
        }

        public VkPushConstantsInfo[] toArray() {
            VkPushConstantsInfo[] ret = new VkPushConstantsInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPushConstantsInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPushConstantsInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPushConstantsInfo.BYTES;
            }

            @Override
            public VkPushConstantsInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPushConstantsInfo ret = new VkPushConstantsInfo(segment.asSlice(0, VkPushConstantsInfo.BYTES));
                segment = segment.asSlice(VkPushConstantsInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPushConstantsInfo allocate(Arena arena) {
        VkPushConstantsInfo ret = new VkPushConstantsInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PUSH_CONSTANTS_INFO);
        return ret;
    }

    public static VkPushConstantsInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPushConstantsInfo.Ptr ret = new VkPushConstantsInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PUSH_CONSTANTS_INFO);
        }
        return ret;
    }

    public static VkPushConstantsInfo clone(Arena arena, VkPushConstantsInfo src) {
        VkPushConstantsInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PUSH_CONSTANTS_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPushConstantsInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPushConstantsInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPushConstantsInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Nullable VkPipelineLayout layout() {
        MemorySegment s = segment.asSlice(OFFSET$layout, SIZE$layout);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkPipelineLayout(s);
    }

    public VkPushConstantsInfo layout(@Nullable VkPipelineLayout value) {
        segment.set(LAYOUT$layout, OFFSET$layout, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkShaderStageFlags.class) int stageFlags() {
        return segment.get(LAYOUT$stageFlags, OFFSET$stageFlags);
    }

    public VkPushConstantsInfo stageFlags(@Bitmask(VkShaderStageFlags.class) int value) {
        segment.set(LAYOUT$stageFlags, OFFSET$stageFlags, value);
        return this;
    }

    public @Unsigned int offset() {
        return segment.get(LAYOUT$offset, OFFSET$offset);
    }

    public VkPushConstantsInfo offset(@Unsigned int value) {
        segment.set(LAYOUT$offset, OFFSET$offset, value);
        return this;
    }

    public @Unsigned int size() {
        return segment.get(LAYOUT$size, OFFSET$size);
    }

    public VkPushConstantsInfo size(@Unsigned int value) {
        segment.set(LAYOUT$size, OFFSET$size, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pValues() {
        return segment.get(LAYOUT$pValues, OFFSET$pValues);
    }

    public VkPushConstantsInfo pValues(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pValues, OFFSET$pValues, value);
        return this;
    }

    public VkPushConstantsInfo pValues(@Nullable IPointer pointer) {
        pValues(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withName("layout"),
        ValueLayout.JAVA_INT.withName("stageFlags"),
        ValueLayout.JAVA_INT.withName("offset"),
        ValueLayout.JAVA_INT.withName("size"),
        ValueLayout.ADDRESS.withName("pValues")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$layout = PathElement.groupElement("layout");
    public static final PathElement PATH$stageFlags = PathElement.groupElement("stageFlags");
    public static final PathElement PATH$offset = PathElement.groupElement("offset");
    public static final PathElement PATH$size = PathElement.groupElement("size");
    public static final PathElement PATH$pValues = PathElement.groupElement("pValues");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$layout = (AddressLayout) LAYOUT.select(PATH$layout);
    public static final OfInt LAYOUT$stageFlags = (OfInt) LAYOUT.select(PATH$stageFlags);
    public static final OfInt LAYOUT$offset = (OfInt) LAYOUT.select(PATH$offset);
    public static final OfInt LAYOUT$size = (OfInt) LAYOUT.select(PATH$size);
    public static final AddressLayout LAYOUT$pValues = (AddressLayout) LAYOUT.select(PATH$pValues);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$layout = LAYOUT$layout.byteSize();
    public static final long SIZE$stageFlags = LAYOUT$stageFlags.byteSize();
    public static final long SIZE$offset = LAYOUT$offset.byteSize();
    public static final long SIZE$size = LAYOUT$size.byteSize();
    public static final long SIZE$pValues = LAYOUT$pValues.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$layout = LAYOUT.byteOffset(PATH$layout);
    public static final long OFFSET$stageFlags = LAYOUT.byteOffset(PATH$stageFlags);
    public static final long OFFSET$offset = LAYOUT.byteOffset(PATH$offset);
    public static final long OFFSET$size = LAYOUT.byteOffset(PATH$size);
    public static final long OFFSET$pValues = LAYOUT.byteOffset(PATH$pValues);
}
