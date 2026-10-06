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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineVertexInputStateCreateInfo.html"><code>VkPipelineVertexInputStateCreateInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPipelineVertexInputStateCreateInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkPipelineVertexInputStateCreateFlags flags; // optional // @link substring="VkPipelineVertexInputStateCreateFlags" target="VkPipelineVertexInputStateCreateFlags" @link substring="flags" target="#flags"
///     uint32_t vertexBindingDescriptionCount; // optional // @link substring="vertexBindingDescriptionCount" target="#vertexBindingDescriptionCount"
///     VkVertexInputBindingDescription const* pVertexBindingDescriptions; // optional // @link substring="VkVertexInputBindingDescription" target="VkVertexInputBindingDescription" @link substring="pVertexBindingDescriptions" target="#pVertexBindingDescriptions"
///     uint32_t vertexAttributeDescriptionCount; // optional // @link substring="vertexAttributeDescriptionCount" target="#vertexAttributeDescriptionCount"
///     VkVertexInputAttributeDescription const* pVertexAttributeDescriptions; // optional // @link substring="VkVertexInputAttributeDescription" target="VkVertexInputAttributeDescription" @link substring="pVertexAttributeDescriptions" target="#pVertexAttributeDescriptions"
/// } VkPipelineVertexInputStateCreateInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PIPELINE_VERTEX_INPUT_STATE_CREATE_INFO`
///
/// The {@code allocate} ({@link VkPipelineVertexInputStateCreateInfo#allocate(Arena)}, {@link VkPipelineVertexInputStateCreateInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPipelineVertexInputStateCreateInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineVertexInputStateCreateInfo.html"><code>VkPipelineVertexInputStateCreateInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPipelineVertexInputStateCreateInfo(@NotNull MemorySegment segment) implements IVkPipelineVertexInputStateCreateInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineVertexInputStateCreateInfo.html"><code>VkPipelineVertexInputStateCreateInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPipelineVertexInputStateCreateInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPipelineVertexInputStateCreateInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPipelineVertexInputStateCreateInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPipelineVertexInputStateCreateInfo, Iterable<VkPipelineVertexInputStateCreateInfo> {
        public long size() {
            return segment.byteSize() / VkPipelineVertexInputStateCreateInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPipelineVertexInputStateCreateInfo at(long index) {
            return new VkPipelineVertexInputStateCreateInfo(segment.asSlice(index * VkPipelineVertexInputStateCreateInfo.BYTES, VkPipelineVertexInputStateCreateInfo.BYTES));
        }

        public VkPipelineVertexInputStateCreateInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkPipelineVertexInputStateCreateInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPipelineVertexInputStateCreateInfo value) {
            MemorySegment s = segment.asSlice(index * VkPipelineVertexInputStateCreateInfo.BYTES, VkPipelineVertexInputStateCreateInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPipelineVertexInputStateCreateInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPipelineVertexInputStateCreateInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPipelineVertexInputStateCreateInfo.BYTES,
                (end - start) * VkPipelineVertexInputStateCreateInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPipelineVertexInputStateCreateInfo.BYTES));
        }

        public VkPipelineVertexInputStateCreateInfo[] toArray() {
            VkPipelineVertexInputStateCreateInfo[] ret = new VkPipelineVertexInputStateCreateInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPipelineVertexInputStateCreateInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPipelineVertexInputStateCreateInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPipelineVertexInputStateCreateInfo.BYTES;
            }

            @Override
            public VkPipelineVertexInputStateCreateInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPipelineVertexInputStateCreateInfo ret = new VkPipelineVertexInputStateCreateInfo(segment.asSlice(0, VkPipelineVertexInputStateCreateInfo.BYTES));
                segment = segment.asSlice(VkPipelineVertexInputStateCreateInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPipelineVertexInputStateCreateInfo allocate(Arena arena) {
        VkPipelineVertexInputStateCreateInfo ret = new VkPipelineVertexInputStateCreateInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PIPELINE_VERTEX_INPUT_STATE_CREATE_INFO);
        return ret;
    }

    public static VkPipelineVertexInputStateCreateInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPipelineVertexInputStateCreateInfo.Ptr ret = new VkPipelineVertexInputStateCreateInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PIPELINE_VERTEX_INPUT_STATE_CREATE_INFO);
        }
        return ret;
    }

    public static VkPipelineVertexInputStateCreateInfo clone(Arena arena, VkPipelineVertexInputStateCreateInfo src) {
        VkPipelineVertexInputStateCreateInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PIPELINE_VERTEX_INPUT_STATE_CREATE_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPipelineVertexInputStateCreateInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPipelineVertexInputStateCreateInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPipelineVertexInputStateCreateInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkPipelineVertexInputStateCreateFlags.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkPipelineVertexInputStateCreateInfo flags(@Bitmask(VkPipelineVertexInputStateCreateFlags.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @Unsigned int vertexBindingDescriptionCount() {
        return segment.get(LAYOUT$vertexBindingDescriptionCount, OFFSET$vertexBindingDescriptionCount);
    }

    public VkPipelineVertexInputStateCreateInfo vertexBindingDescriptionCount(@Unsigned int value) {
        segment.set(LAYOUT$vertexBindingDescriptionCount, OFFSET$vertexBindingDescriptionCount, value);
        return this;
    }

    public VkPipelineVertexInputStateCreateInfo pVertexBindingDescriptions(@Nullable IVkVertexInputBindingDescription value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pVertexBindingDescriptionsRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkVertexInputBindingDescription.Ptr pVertexBindingDescriptions(int assumedCount) {
        MemorySegment s = pVertexBindingDescriptionsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkVertexInputBindingDescription.BYTES);
        return new VkVertexInputBindingDescription.Ptr(s);
    }

    public @Nullable VkVertexInputBindingDescription pVertexBindingDescriptions() {
        MemorySegment s = pVertexBindingDescriptionsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkVertexInputBindingDescription(s);
    }

    public @Pointer(target=VkVertexInputBindingDescription.class) @NotNull MemorySegment pVertexBindingDescriptionsRaw() {
        return segment.get(LAYOUT$pVertexBindingDescriptions, OFFSET$pVertexBindingDescriptions);
    }

    public void pVertexBindingDescriptionsRaw(@Pointer(target=VkVertexInputBindingDescription.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pVertexBindingDescriptions, OFFSET$pVertexBindingDescriptions, value);
    }

    public @Unsigned int vertexAttributeDescriptionCount() {
        return segment.get(LAYOUT$vertexAttributeDescriptionCount, OFFSET$vertexAttributeDescriptionCount);
    }

    public VkPipelineVertexInputStateCreateInfo vertexAttributeDescriptionCount(@Unsigned int value) {
        segment.set(LAYOUT$vertexAttributeDescriptionCount, OFFSET$vertexAttributeDescriptionCount, value);
        return this;
    }

    public VkPipelineVertexInputStateCreateInfo pVertexAttributeDescriptions(@Nullable IVkVertexInputAttributeDescription value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pVertexAttributeDescriptionsRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkVertexInputAttributeDescription.Ptr pVertexAttributeDescriptions(int assumedCount) {
        MemorySegment s = pVertexAttributeDescriptionsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkVertexInputAttributeDescription.BYTES);
        return new VkVertexInputAttributeDescription.Ptr(s);
    }

    public @Nullable VkVertexInputAttributeDescription pVertexAttributeDescriptions() {
        MemorySegment s = pVertexAttributeDescriptionsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkVertexInputAttributeDescription(s);
    }

    public @Pointer(target=VkVertexInputAttributeDescription.class) @NotNull MemorySegment pVertexAttributeDescriptionsRaw() {
        return segment.get(LAYOUT$pVertexAttributeDescriptions, OFFSET$pVertexAttributeDescriptions);
    }

    public void pVertexAttributeDescriptionsRaw(@Pointer(target=VkVertexInputAttributeDescription.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pVertexAttributeDescriptions, OFFSET$pVertexAttributeDescriptions, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("vertexBindingDescriptionCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkVertexInputBindingDescription.LAYOUT).withName("pVertexBindingDescriptions"),
        ValueLayout.JAVA_INT.withName("vertexAttributeDescriptionCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkVertexInputAttributeDescription.LAYOUT).withName("pVertexAttributeDescriptions")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$vertexBindingDescriptionCount = PathElement.groupElement("vertexBindingDescriptionCount");
    public static final PathElement PATH$pVertexBindingDescriptions = PathElement.groupElement("pVertexBindingDescriptions");
    public static final PathElement PATH$vertexAttributeDescriptionCount = PathElement.groupElement("vertexAttributeDescriptionCount");
    public static final PathElement PATH$pVertexAttributeDescriptions = PathElement.groupElement("pVertexAttributeDescriptions");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$vertexBindingDescriptionCount = (OfInt) LAYOUT.select(PATH$vertexBindingDescriptionCount);
    public static final AddressLayout LAYOUT$pVertexBindingDescriptions = (AddressLayout) LAYOUT.select(PATH$pVertexBindingDescriptions);
    public static final OfInt LAYOUT$vertexAttributeDescriptionCount = (OfInt) LAYOUT.select(PATH$vertexAttributeDescriptionCount);
    public static final AddressLayout LAYOUT$pVertexAttributeDescriptions = (AddressLayout) LAYOUT.select(PATH$pVertexAttributeDescriptions);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$vertexBindingDescriptionCount = LAYOUT$vertexBindingDescriptionCount.byteSize();
    public static final long SIZE$pVertexBindingDescriptions = LAYOUT$pVertexBindingDescriptions.byteSize();
    public static final long SIZE$vertexAttributeDescriptionCount = LAYOUT$vertexAttributeDescriptionCount.byteSize();
    public static final long SIZE$pVertexAttributeDescriptions = LAYOUT$pVertexAttributeDescriptions.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$vertexBindingDescriptionCount = LAYOUT.byteOffset(PATH$vertexBindingDescriptionCount);
    public static final long OFFSET$pVertexBindingDescriptions = LAYOUT.byteOffset(PATH$pVertexBindingDescriptions);
    public static final long OFFSET$vertexAttributeDescriptionCount = LAYOUT.byteOffset(PATH$vertexAttributeDescriptionCount);
    public static final long OFFSET$pVertexAttributeDescriptions = LAYOUT.byteOffset(PATH$pVertexAttributeDescriptions);
}
