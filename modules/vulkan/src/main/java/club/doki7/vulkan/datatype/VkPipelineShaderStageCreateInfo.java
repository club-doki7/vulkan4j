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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineShaderStageCreateInfo.html"><code>VkPipelineShaderStageCreateInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPipelineShaderStageCreateInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkPipelineShaderStageCreateFlags flags; // optional // @link substring="VkPipelineShaderStageCreateFlags" target="VkPipelineShaderStageCreateFlags" @link substring="flags" target="#flags"
///     VkShaderStageFlags stage; // @link substring="VkShaderStageFlags" target="VkShaderStageFlags" @link substring="stage" target="#stage"
///     VkShaderModule module; // optional // @link substring="VkShaderModule" target="VkShaderModule" @link substring="module" target="#module"
///     char const* pName; // @link substring="pName" target="#pName"
///     VkSpecializationInfo const* pSpecializationInfo; // optional // @link substring="VkSpecializationInfo" target="VkSpecializationInfo" @link substring="pSpecializationInfo" target="#pSpecializationInfo"
/// } VkPipelineShaderStageCreateInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PIPELINE_SHADER_STAGE_CREATE_INFO`
///
/// The {@code allocate} ({@link VkPipelineShaderStageCreateInfo#allocate(Arena)}, {@link VkPipelineShaderStageCreateInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPipelineShaderStageCreateInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineShaderStageCreateInfo.html"><code>VkPipelineShaderStageCreateInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPipelineShaderStageCreateInfo(@NotNull MemorySegment segment) implements IVkPipelineShaderStageCreateInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineShaderStageCreateInfo.html"><code>VkPipelineShaderStageCreateInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPipelineShaderStageCreateInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPipelineShaderStageCreateInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPipelineShaderStageCreateInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPipelineShaderStageCreateInfo, Iterable<VkPipelineShaderStageCreateInfo> {
        public long size() {
            return segment.byteSize() / VkPipelineShaderStageCreateInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPipelineShaderStageCreateInfo at(long index) {
            return new VkPipelineShaderStageCreateInfo(segment.asSlice(index * VkPipelineShaderStageCreateInfo.BYTES, VkPipelineShaderStageCreateInfo.BYTES));
        }

        public VkPipelineShaderStageCreateInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkPipelineShaderStageCreateInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPipelineShaderStageCreateInfo value) {
            MemorySegment s = segment.asSlice(index * VkPipelineShaderStageCreateInfo.BYTES, VkPipelineShaderStageCreateInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPipelineShaderStageCreateInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPipelineShaderStageCreateInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPipelineShaderStageCreateInfo.BYTES,
                (end - start) * VkPipelineShaderStageCreateInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPipelineShaderStageCreateInfo.BYTES));
        }

        public VkPipelineShaderStageCreateInfo[] toArray() {
            VkPipelineShaderStageCreateInfo[] ret = new VkPipelineShaderStageCreateInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPipelineShaderStageCreateInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPipelineShaderStageCreateInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPipelineShaderStageCreateInfo.BYTES;
            }

            @Override
            public VkPipelineShaderStageCreateInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPipelineShaderStageCreateInfo ret = new VkPipelineShaderStageCreateInfo(segment.asSlice(0, VkPipelineShaderStageCreateInfo.BYTES));
                segment = segment.asSlice(VkPipelineShaderStageCreateInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPipelineShaderStageCreateInfo allocate(Arena arena) {
        VkPipelineShaderStageCreateInfo ret = new VkPipelineShaderStageCreateInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PIPELINE_SHADER_STAGE_CREATE_INFO);
        return ret;
    }

    public static VkPipelineShaderStageCreateInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPipelineShaderStageCreateInfo.Ptr ret = new VkPipelineShaderStageCreateInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PIPELINE_SHADER_STAGE_CREATE_INFO);
        }
        return ret;
    }

    public static VkPipelineShaderStageCreateInfo clone(Arena arena, VkPipelineShaderStageCreateInfo src) {
        VkPipelineShaderStageCreateInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PIPELINE_SHADER_STAGE_CREATE_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPipelineShaderStageCreateInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPipelineShaderStageCreateInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPipelineShaderStageCreateInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkPipelineShaderStageCreateFlags.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkPipelineShaderStageCreateInfo flags(@Bitmask(VkPipelineShaderStageCreateFlags.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @Bitmask(VkShaderStageFlags.class) int stage() {
        return segment.get(LAYOUT$stage, OFFSET$stage);
    }

    public VkPipelineShaderStageCreateInfo stage(@Bitmask(VkShaderStageFlags.class) int value) {
        segment.set(LAYOUT$stage, OFFSET$stage, value);
        return this;
    }

    public @Nullable VkShaderModule module() {
        MemorySegment s = segment.asSlice(OFFSET$module, SIZE$module);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkShaderModule(s);
    }

    public VkPipelineShaderStageCreateInfo module(@Nullable VkShaderModule value) {
        segment.set(LAYOUT$module, OFFSET$module, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    /// Note: the returned {@link BytePtr} does not have correct
    /// {@link BytePtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link BytePtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable BytePtr pName() {
        MemorySegment s = pNameRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new BytePtr(s);
    }

    public VkPipelineShaderStageCreateInfo pName(@Nullable BytePtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pNameRaw(s);
        return this;
    }

    public @Pointer(comment="int8_t*") @NotNull MemorySegment pNameRaw() {
        return segment.get(LAYOUT$pName, OFFSET$pName);
    }

    public void pNameRaw(@Pointer(comment="int8_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pName, OFFSET$pName, value);
    }

    public VkPipelineShaderStageCreateInfo pSpecializationInfo(@Nullable IVkSpecializationInfo value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pSpecializationInfoRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkSpecializationInfo.Ptr pSpecializationInfo(int assumedCount) {
        MemorySegment s = pSpecializationInfoRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkSpecializationInfo.BYTES);
        return new VkSpecializationInfo.Ptr(s);
    }

    public @Nullable VkSpecializationInfo pSpecializationInfo() {
        MemorySegment s = pSpecializationInfoRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkSpecializationInfo(s);
    }

    public @Pointer(target=VkSpecializationInfo.class) @NotNull MemorySegment pSpecializationInfoRaw() {
        return segment.get(LAYOUT$pSpecializationInfo, OFFSET$pSpecializationInfo);
    }

    public void pSpecializationInfoRaw(@Pointer(target=VkSpecializationInfo.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pSpecializationInfo, OFFSET$pSpecializationInfo, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("stage"),
        ValueLayout.ADDRESS.withName("module"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE).withName("pName"),
        ValueLayout.ADDRESS.withTargetLayout(VkSpecializationInfo.LAYOUT).withName("pSpecializationInfo")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$stage = PathElement.groupElement("stage");
    public static final PathElement PATH$module = PathElement.groupElement("module");
    public static final PathElement PATH$pName = PathElement.groupElement("pName");
    public static final PathElement PATH$pSpecializationInfo = PathElement.groupElement("pSpecializationInfo");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$stage = (OfInt) LAYOUT.select(PATH$stage);
    public static final AddressLayout LAYOUT$module = (AddressLayout) LAYOUT.select(PATH$module);
    public static final AddressLayout LAYOUT$pName = (AddressLayout) LAYOUT.select(PATH$pName);
    public static final AddressLayout LAYOUT$pSpecializationInfo = (AddressLayout) LAYOUT.select(PATH$pSpecializationInfo);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$stage = LAYOUT$stage.byteSize();
    public static final long SIZE$module = LAYOUT$module.byteSize();
    public static final long SIZE$pName = LAYOUT$pName.byteSize();
    public static final long SIZE$pSpecializationInfo = LAYOUT$pSpecializationInfo.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$stage = LAYOUT.byteOffset(PATH$stage);
    public static final long OFFSET$module = LAYOUT.byteOffset(PATH$module);
    public static final long OFFSET$pName = LAYOUT.byteOffset(PATH$pName);
    public static final long OFFSET$pSpecializationInfo = LAYOUT.byteOffset(PATH$pSpecializationInfo);
}
