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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDataGraphPipelineShaderModuleCreateInfoARM.html"><code>VkDataGraphPipelineShaderModuleCreateInfoARM</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDataGraphPipelineShaderModuleCreateInfoARM {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkShaderModule module; // optional // @link substring="VkShaderModule" target="VkShaderModule" @link substring="module" target="#module"
///     char const* pName; // @link substring="pName" target="#pName"
///     VkSpecializationInfo const* pSpecializationInfo; // optional // @link substring="VkSpecializationInfo" target="VkSpecializationInfo" @link substring="pSpecializationInfo" target="#pSpecializationInfo"
///     uint32_t constantCount; // optional // @link substring="constantCount" target="#constantCount"
///     VkDataGraphPipelineConstantARM const* pConstants; // optional // @link substring="VkDataGraphPipelineConstantARM" target="VkDataGraphPipelineConstantARM" @link substring="pConstants" target="#pConstants"
/// } VkDataGraphPipelineShaderModuleCreateInfoARM;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_DATA_GRAPH_PIPELINE_SHADER_MODULE_CREATE_INFO_ARM`
///
/// The {@code allocate} ({@link VkDataGraphPipelineShaderModuleCreateInfoARM#allocate(Arena)}, {@link VkDataGraphPipelineShaderModuleCreateInfoARM#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkDataGraphPipelineShaderModuleCreateInfoARM#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDataGraphPipelineShaderModuleCreateInfoARM.html"><code>VkDataGraphPipelineShaderModuleCreateInfoARM</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDataGraphPipelineShaderModuleCreateInfoARM(@NotNull MemorySegment segment) implements IVkDataGraphPipelineShaderModuleCreateInfoARM {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDataGraphPipelineShaderModuleCreateInfoARM.html"><code>VkDataGraphPipelineShaderModuleCreateInfoARM</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDataGraphPipelineShaderModuleCreateInfoARM}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDataGraphPipelineShaderModuleCreateInfoARM to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDataGraphPipelineShaderModuleCreateInfoARM.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDataGraphPipelineShaderModuleCreateInfoARM, Iterable<VkDataGraphPipelineShaderModuleCreateInfoARM> {
        public long size() {
            return segment.byteSize() / VkDataGraphPipelineShaderModuleCreateInfoARM.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDataGraphPipelineShaderModuleCreateInfoARM at(long index) {
            return new VkDataGraphPipelineShaderModuleCreateInfoARM(segment.asSlice(index * VkDataGraphPipelineShaderModuleCreateInfoARM.BYTES, VkDataGraphPipelineShaderModuleCreateInfoARM.BYTES));
        }

        public VkDataGraphPipelineShaderModuleCreateInfoARM.Ptr at(long index, @NotNull Consumer<@NotNull VkDataGraphPipelineShaderModuleCreateInfoARM> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDataGraphPipelineShaderModuleCreateInfoARM value) {
            MemorySegment s = segment.asSlice(index * VkDataGraphPipelineShaderModuleCreateInfoARM.BYTES, VkDataGraphPipelineShaderModuleCreateInfoARM.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDataGraphPipelineShaderModuleCreateInfoARM.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDataGraphPipelineShaderModuleCreateInfoARM.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDataGraphPipelineShaderModuleCreateInfoARM.BYTES,
                (end - start) * VkDataGraphPipelineShaderModuleCreateInfoARM.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDataGraphPipelineShaderModuleCreateInfoARM.BYTES));
        }

        public VkDataGraphPipelineShaderModuleCreateInfoARM[] toArray() {
            VkDataGraphPipelineShaderModuleCreateInfoARM[] ret = new VkDataGraphPipelineShaderModuleCreateInfoARM[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDataGraphPipelineShaderModuleCreateInfoARM> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDataGraphPipelineShaderModuleCreateInfoARM> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDataGraphPipelineShaderModuleCreateInfoARM.BYTES;
            }

            @Override
            public VkDataGraphPipelineShaderModuleCreateInfoARM next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDataGraphPipelineShaderModuleCreateInfoARM ret = new VkDataGraphPipelineShaderModuleCreateInfoARM(segment.asSlice(0, VkDataGraphPipelineShaderModuleCreateInfoARM.BYTES));
                segment = segment.asSlice(VkDataGraphPipelineShaderModuleCreateInfoARM.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDataGraphPipelineShaderModuleCreateInfoARM allocate(Arena arena) {
        VkDataGraphPipelineShaderModuleCreateInfoARM ret = new VkDataGraphPipelineShaderModuleCreateInfoARM(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.DATA_GRAPH_PIPELINE_SHADER_MODULE_CREATE_INFO_ARM);
        return ret;
    }

    public static VkDataGraphPipelineShaderModuleCreateInfoARM.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkDataGraphPipelineShaderModuleCreateInfoARM.Ptr ret = new VkDataGraphPipelineShaderModuleCreateInfoARM.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.DATA_GRAPH_PIPELINE_SHADER_MODULE_CREATE_INFO_ARM);
        }
        return ret;
    }

    public static VkDataGraphPipelineShaderModuleCreateInfoARM clone(Arena arena, VkDataGraphPipelineShaderModuleCreateInfoARM src) {
        VkDataGraphPipelineShaderModuleCreateInfoARM ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.DATA_GRAPH_PIPELINE_SHADER_MODULE_CREATE_INFO_ARM);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkDataGraphPipelineShaderModuleCreateInfoARM sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkDataGraphPipelineShaderModuleCreateInfoARM pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkDataGraphPipelineShaderModuleCreateInfoARM pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Nullable VkShaderModule module() {
        MemorySegment s = segment.asSlice(OFFSET$module, SIZE$module);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkShaderModule(s);
    }

    public VkDataGraphPipelineShaderModuleCreateInfoARM module(@Nullable VkShaderModule value) {
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

    public VkDataGraphPipelineShaderModuleCreateInfoARM pName(@Nullable BytePtr value) {
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

    public VkDataGraphPipelineShaderModuleCreateInfoARM pSpecializationInfo(@Nullable IVkSpecializationInfo value) {
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

    public @Unsigned int constantCount() {
        return segment.get(LAYOUT$constantCount, OFFSET$constantCount);
    }

    public VkDataGraphPipelineShaderModuleCreateInfoARM constantCount(@Unsigned int value) {
        segment.set(LAYOUT$constantCount, OFFSET$constantCount, value);
        return this;
    }

    public VkDataGraphPipelineShaderModuleCreateInfoARM pConstants(@Nullable IVkDataGraphPipelineConstantARM value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pConstantsRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkDataGraphPipelineConstantARM.Ptr pConstants(int assumedCount) {
        MemorySegment s = pConstantsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkDataGraphPipelineConstantARM.BYTES);
        return new VkDataGraphPipelineConstantARM.Ptr(s);
    }

    public @Nullable VkDataGraphPipelineConstantARM pConstants() {
        MemorySegment s = pConstantsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkDataGraphPipelineConstantARM(s);
    }

    public @Pointer(target=VkDataGraphPipelineConstantARM.class) @NotNull MemorySegment pConstantsRaw() {
        return segment.get(LAYOUT$pConstants, OFFSET$pConstants);
    }

    public void pConstantsRaw(@Pointer(target=VkDataGraphPipelineConstantARM.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pConstants, OFFSET$pConstants, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withName("module"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE).withName("pName"),
        ValueLayout.ADDRESS.withTargetLayout(VkSpecializationInfo.LAYOUT).withName("pSpecializationInfo"),
        ValueLayout.JAVA_INT.withName("constantCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkDataGraphPipelineConstantARM.LAYOUT).withName("pConstants")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$module = PathElement.groupElement("module");
    public static final PathElement PATH$pName = PathElement.groupElement("pName");
    public static final PathElement PATH$pSpecializationInfo = PathElement.groupElement("pSpecializationInfo");
    public static final PathElement PATH$constantCount = PathElement.groupElement("constantCount");
    public static final PathElement PATH$pConstants = PathElement.groupElement("pConstants");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$module = (AddressLayout) LAYOUT.select(PATH$module);
    public static final AddressLayout LAYOUT$pName = (AddressLayout) LAYOUT.select(PATH$pName);
    public static final AddressLayout LAYOUT$pSpecializationInfo = (AddressLayout) LAYOUT.select(PATH$pSpecializationInfo);
    public static final OfInt LAYOUT$constantCount = (OfInt) LAYOUT.select(PATH$constantCount);
    public static final AddressLayout LAYOUT$pConstants = (AddressLayout) LAYOUT.select(PATH$pConstants);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$module = LAYOUT$module.byteSize();
    public static final long SIZE$pName = LAYOUT$pName.byteSize();
    public static final long SIZE$pSpecializationInfo = LAYOUT$pSpecializationInfo.byteSize();
    public static final long SIZE$constantCount = LAYOUT$constantCount.byteSize();
    public static final long SIZE$pConstants = LAYOUT$pConstants.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$module = LAYOUT.byteOffset(PATH$module);
    public static final long OFFSET$pName = LAYOUT.byteOffset(PATH$pName);
    public static final long OFFSET$pSpecializationInfo = LAYOUT.byteOffset(PATH$pSpecializationInfo);
    public static final long OFFSET$constantCount = LAYOUT.byteOffset(PATH$constantCount);
    public static final long OFFSET$pConstants = LAYOUT.byteOffset(PATH$pConstants);
}
