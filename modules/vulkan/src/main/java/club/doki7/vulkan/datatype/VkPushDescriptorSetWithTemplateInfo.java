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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPushDescriptorSetWithTemplateInfo.html"><code>VkPushDescriptorSetWithTemplateInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPushDescriptorSetWithTemplateInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkDescriptorUpdateTemplate descriptorUpdateTemplate; // @link substring="VkDescriptorUpdateTemplate" target="VkDescriptorUpdateTemplate" @link substring="descriptorUpdateTemplate" target="#descriptorUpdateTemplate"
///     VkPipelineLayout layout; // optional // @link substring="VkPipelineLayout" target="VkPipelineLayout" @link substring="layout" target="#layout"
///     uint32_t set; // optional // @link substring="set" target="#set"
///     void const* pData; // @link substring="pData" target="#pData"
/// } VkPushDescriptorSetWithTemplateInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PUSH_DESCRIPTOR_SET_WITH_TEMPLATE_INFO`
///
/// The {@code allocate} ({@link VkPushDescriptorSetWithTemplateInfo#allocate(Arena)}, {@link VkPushDescriptorSetWithTemplateInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPushDescriptorSetWithTemplateInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPushDescriptorSetWithTemplateInfo.html"><code>VkPushDescriptorSetWithTemplateInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPushDescriptorSetWithTemplateInfo(@NotNull MemorySegment segment) implements IVkPushDescriptorSetWithTemplateInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPushDescriptorSetWithTemplateInfo.html"><code>VkPushDescriptorSetWithTemplateInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPushDescriptorSetWithTemplateInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPushDescriptorSetWithTemplateInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPushDescriptorSetWithTemplateInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPushDescriptorSetWithTemplateInfo, Iterable<VkPushDescriptorSetWithTemplateInfo> {
        public long size() {
            return segment.byteSize() / VkPushDescriptorSetWithTemplateInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPushDescriptorSetWithTemplateInfo at(long index) {
            return new VkPushDescriptorSetWithTemplateInfo(segment.asSlice(index * VkPushDescriptorSetWithTemplateInfo.BYTES, VkPushDescriptorSetWithTemplateInfo.BYTES));
        }

        public VkPushDescriptorSetWithTemplateInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkPushDescriptorSetWithTemplateInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPushDescriptorSetWithTemplateInfo value) {
            MemorySegment s = segment.asSlice(index * VkPushDescriptorSetWithTemplateInfo.BYTES, VkPushDescriptorSetWithTemplateInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPushDescriptorSetWithTemplateInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPushDescriptorSetWithTemplateInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPushDescriptorSetWithTemplateInfo.BYTES,
                (end - start) * VkPushDescriptorSetWithTemplateInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPushDescriptorSetWithTemplateInfo.BYTES));
        }

        public VkPushDescriptorSetWithTemplateInfo[] toArray() {
            VkPushDescriptorSetWithTemplateInfo[] ret = new VkPushDescriptorSetWithTemplateInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPushDescriptorSetWithTemplateInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPushDescriptorSetWithTemplateInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPushDescriptorSetWithTemplateInfo.BYTES;
            }

            @Override
            public VkPushDescriptorSetWithTemplateInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPushDescriptorSetWithTemplateInfo ret = new VkPushDescriptorSetWithTemplateInfo(segment.asSlice(0, VkPushDescriptorSetWithTemplateInfo.BYTES));
                segment = segment.asSlice(VkPushDescriptorSetWithTemplateInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPushDescriptorSetWithTemplateInfo allocate(Arena arena) {
        VkPushDescriptorSetWithTemplateInfo ret = new VkPushDescriptorSetWithTemplateInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PUSH_DESCRIPTOR_SET_WITH_TEMPLATE_INFO);
        return ret;
    }

    public static VkPushDescriptorSetWithTemplateInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPushDescriptorSetWithTemplateInfo.Ptr ret = new VkPushDescriptorSetWithTemplateInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PUSH_DESCRIPTOR_SET_WITH_TEMPLATE_INFO);
        }
        return ret;
    }

    public static VkPushDescriptorSetWithTemplateInfo clone(Arena arena, VkPushDescriptorSetWithTemplateInfo src) {
        VkPushDescriptorSetWithTemplateInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PUSH_DESCRIPTOR_SET_WITH_TEMPLATE_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPushDescriptorSetWithTemplateInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPushDescriptorSetWithTemplateInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPushDescriptorSetWithTemplateInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Nullable VkDescriptorUpdateTemplate descriptorUpdateTemplate() {
        MemorySegment s = segment.asSlice(OFFSET$descriptorUpdateTemplate, SIZE$descriptorUpdateTemplate);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkDescriptorUpdateTemplate(s);
    }

    public VkPushDescriptorSetWithTemplateInfo descriptorUpdateTemplate(@Nullable VkDescriptorUpdateTemplate value) {
        segment.set(LAYOUT$descriptorUpdateTemplate, OFFSET$descriptorUpdateTemplate, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Nullable VkPipelineLayout layout() {
        MemorySegment s = segment.asSlice(OFFSET$layout, SIZE$layout);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkPipelineLayout(s);
    }

    public VkPushDescriptorSetWithTemplateInfo layout(@Nullable VkPipelineLayout value) {
        segment.set(LAYOUT$layout, OFFSET$layout, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int set() {
        return segment.get(LAYOUT$set, OFFSET$set);
    }

    public VkPushDescriptorSetWithTemplateInfo set(@Unsigned int value) {
        segment.set(LAYOUT$set, OFFSET$set, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pData() {
        return segment.get(LAYOUT$pData, OFFSET$pData);
    }

    public VkPushDescriptorSetWithTemplateInfo pData(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pData, OFFSET$pData, value);
        return this;
    }

    public VkPushDescriptorSetWithTemplateInfo pData(@Nullable IPointer pointer) {
        pData(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withName("descriptorUpdateTemplate"),
        ValueLayout.ADDRESS.withName("layout"),
        ValueLayout.JAVA_INT.withName("set"),
        ValueLayout.ADDRESS.withName("pData")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$descriptorUpdateTemplate = PathElement.groupElement("descriptorUpdateTemplate");
    public static final PathElement PATH$layout = PathElement.groupElement("layout");
    public static final PathElement PATH$set = PathElement.groupElement("set");
    public static final PathElement PATH$pData = PathElement.groupElement("pData");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$descriptorUpdateTemplate = (AddressLayout) LAYOUT.select(PATH$descriptorUpdateTemplate);
    public static final AddressLayout LAYOUT$layout = (AddressLayout) LAYOUT.select(PATH$layout);
    public static final OfInt LAYOUT$set = (OfInt) LAYOUT.select(PATH$set);
    public static final AddressLayout LAYOUT$pData = (AddressLayout) LAYOUT.select(PATH$pData);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$descriptorUpdateTemplate = LAYOUT$descriptorUpdateTemplate.byteSize();
    public static final long SIZE$layout = LAYOUT$layout.byteSize();
    public static final long SIZE$set = LAYOUT$set.byteSize();
    public static final long SIZE$pData = LAYOUT$pData.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$descriptorUpdateTemplate = LAYOUT.byteOffset(PATH$descriptorUpdateTemplate);
    public static final long OFFSET$layout = LAYOUT.byteOffset(PATH$layout);
    public static final long OFFSET$set = LAYOUT.byteOffset(PATH$set);
    public static final long OFFSET$pData = LAYOUT.byteOffset(PATH$pData);
}
