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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDataGraphPipelineCreateInfoARM.html"><code>VkDataGraphPipelineCreateInfoARM</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDataGraphPipelineCreateInfoARM {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkPipelineCreateFlags2 flags; // optional // @link substring="VkPipelineCreateFlags2" target="VkPipelineCreateFlags2" @link substring="flags" target="#flags"
///     VkPipelineLayout layout; // @link substring="VkPipelineLayout" target="VkPipelineLayout" @link substring="layout" target="#layout"
///     uint32_t resourceInfoCount; // optional // @link substring="resourceInfoCount" target="#resourceInfoCount"
///     VkDataGraphPipelineResourceInfoARM const* pResourceInfos; // optional // @link substring="VkDataGraphPipelineResourceInfoARM" target="VkDataGraphPipelineResourceInfoARM" @link substring="pResourceInfos" target="#pResourceInfos"
/// } VkDataGraphPipelineCreateInfoARM;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_DATA_GRAPH_PIPELINE_CREATE_INFO_ARM`
///
/// The {@code allocate} ({@link VkDataGraphPipelineCreateInfoARM#allocate(Arena)}, {@link VkDataGraphPipelineCreateInfoARM#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkDataGraphPipelineCreateInfoARM#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDataGraphPipelineCreateInfoARM.html"><code>VkDataGraphPipelineCreateInfoARM</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDataGraphPipelineCreateInfoARM(@NotNull MemorySegment segment) implements IVkDataGraphPipelineCreateInfoARM {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDataGraphPipelineCreateInfoARM.html"><code>VkDataGraphPipelineCreateInfoARM</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDataGraphPipelineCreateInfoARM}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDataGraphPipelineCreateInfoARM to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDataGraphPipelineCreateInfoARM.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDataGraphPipelineCreateInfoARM, Iterable<VkDataGraphPipelineCreateInfoARM> {
        public long size() {
            return segment.byteSize() / VkDataGraphPipelineCreateInfoARM.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDataGraphPipelineCreateInfoARM at(long index) {
            return new VkDataGraphPipelineCreateInfoARM(segment.asSlice(index * VkDataGraphPipelineCreateInfoARM.BYTES, VkDataGraphPipelineCreateInfoARM.BYTES));
        }

        public VkDataGraphPipelineCreateInfoARM.Ptr at(long index, @NotNull Consumer<@NotNull VkDataGraphPipelineCreateInfoARM> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDataGraphPipelineCreateInfoARM value) {
            MemorySegment s = segment.asSlice(index * VkDataGraphPipelineCreateInfoARM.BYTES, VkDataGraphPipelineCreateInfoARM.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDataGraphPipelineCreateInfoARM.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDataGraphPipelineCreateInfoARM.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDataGraphPipelineCreateInfoARM.BYTES,
                (end - start) * VkDataGraphPipelineCreateInfoARM.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDataGraphPipelineCreateInfoARM.BYTES));
        }

        public VkDataGraphPipelineCreateInfoARM[] toArray() {
            VkDataGraphPipelineCreateInfoARM[] ret = new VkDataGraphPipelineCreateInfoARM[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDataGraphPipelineCreateInfoARM> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDataGraphPipelineCreateInfoARM> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDataGraphPipelineCreateInfoARM.BYTES;
            }

            @Override
            public VkDataGraphPipelineCreateInfoARM next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDataGraphPipelineCreateInfoARM ret = new VkDataGraphPipelineCreateInfoARM(segment.asSlice(0, VkDataGraphPipelineCreateInfoARM.BYTES));
                segment = segment.asSlice(VkDataGraphPipelineCreateInfoARM.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDataGraphPipelineCreateInfoARM allocate(Arena arena) {
        VkDataGraphPipelineCreateInfoARM ret = new VkDataGraphPipelineCreateInfoARM(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.DATA_GRAPH_PIPELINE_CREATE_INFO_ARM);
        return ret;
    }

    public static VkDataGraphPipelineCreateInfoARM.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkDataGraphPipelineCreateInfoARM.Ptr ret = new VkDataGraphPipelineCreateInfoARM.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.DATA_GRAPH_PIPELINE_CREATE_INFO_ARM);
        }
        return ret;
    }

    public static VkDataGraphPipelineCreateInfoARM clone(Arena arena, VkDataGraphPipelineCreateInfoARM src) {
        VkDataGraphPipelineCreateInfoARM ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.DATA_GRAPH_PIPELINE_CREATE_INFO_ARM);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkDataGraphPipelineCreateInfoARM sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkDataGraphPipelineCreateInfoARM pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkDataGraphPipelineCreateInfoARM pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkPipelineCreateFlags2.class) long flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkDataGraphPipelineCreateInfoARM flags(@Bitmask(VkPipelineCreateFlags2.class) long value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @Nullable VkPipelineLayout layout() {
        MemorySegment s = segment.asSlice(OFFSET$layout, SIZE$layout);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkPipelineLayout(s);
    }

    public VkDataGraphPipelineCreateInfoARM layout(@Nullable VkPipelineLayout value) {
        segment.set(LAYOUT$layout, OFFSET$layout, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int resourceInfoCount() {
        return segment.get(LAYOUT$resourceInfoCount, OFFSET$resourceInfoCount);
    }

    public VkDataGraphPipelineCreateInfoARM resourceInfoCount(@Unsigned int value) {
        segment.set(LAYOUT$resourceInfoCount, OFFSET$resourceInfoCount, value);
        return this;
    }

    public VkDataGraphPipelineCreateInfoARM pResourceInfos(@Nullable IVkDataGraphPipelineResourceInfoARM value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pResourceInfosRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkDataGraphPipelineResourceInfoARM.Ptr pResourceInfos(int assumedCount) {
        MemorySegment s = pResourceInfosRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkDataGraphPipelineResourceInfoARM.BYTES);
        return new VkDataGraphPipelineResourceInfoARM.Ptr(s);
    }

    public @Nullable VkDataGraphPipelineResourceInfoARM pResourceInfos() {
        MemorySegment s = pResourceInfosRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkDataGraphPipelineResourceInfoARM(s);
    }

    public @Pointer(target=VkDataGraphPipelineResourceInfoARM.class) @NotNull MemorySegment pResourceInfosRaw() {
        return segment.get(LAYOUT$pResourceInfos, OFFSET$pResourceInfos);
    }

    public void pResourceInfosRaw(@Pointer(target=VkDataGraphPipelineResourceInfoARM.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pResourceInfos, OFFSET$pResourceInfos, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_LONG.withName("flags"),
        ValueLayout.ADDRESS.withName("layout"),
        ValueLayout.JAVA_INT.withName("resourceInfoCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkDataGraphPipelineResourceInfoARM.LAYOUT).withName("pResourceInfos")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$layout = PathElement.groupElement("layout");
    public static final PathElement PATH$resourceInfoCount = PathElement.groupElement("resourceInfoCount");
    public static final PathElement PATH$pResourceInfos = PathElement.groupElement("pResourceInfos");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfLong LAYOUT$flags = (OfLong) LAYOUT.select(PATH$flags);
    public static final AddressLayout LAYOUT$layout = (AddressLayout) LAYOUT.select(PATH$layout);
    public static final OfInt LAYOUT$resourceInfoCount = (OfInt) LAYOUT.select(PATH$resourceInfoCount);
    public static final AddressLayout LAYOUT$pResourceInfos = (AddressLayout) LAYOUT.select(PATH$pResourceInfos);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$layout = LAYOUT$layout.byteSize();
    public static final long SIZE$resourceInfoCount = LAYOUT$resourceInfoCount.byteSize();
    public static final long SIZE$pResourceInfos = LAYOUT$pResourceInfos.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$layout = LAYOUT.byteOffset(PATH$layout);
    public static final long OFFSET$resourceInfoCount = LAYOUT.byteOffset(PATH$resourceInfoCount);
    public static final long OFFSET$pResourceInfos = LAYOUT.byteOffset(PATH$pResourceInfos);
}
