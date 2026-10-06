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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDescriptorUpdateTemplateCreateInfo.html"><code>VkDescriptorUpdateTemplateCreateInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDescriptorUpdateTemplateCreateInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkDescriptorUpdateTemplateCreateFlags flags; // optional // @link substring="VkDescriptorUpdateTemplateCreateFlags" target="VkDescriptorUpdateTemplateCreateFlags" @link substring="flags" target="#flags"
///     uint32_t descriptorUpdateEntryCount; // @link substring="descriptorUpdateEntryCount" target="#descriptorUpdateEntryCount"
///     VkDescriptorUpdateTemplateEntry const* pDescriptorUpdateEntries; // @link substring="VkDescriptorUpdateTemplateEntry" target="VkDescriptorUpdateTemplateEntry" @link substring="pDescriptorUpdateEntries" target="#pDescriptorUpdateEntries"
///     VkDescriptorUpdateTemplateType templateType; // @link substring="VkDescriptorUpdateTemplateType" target="VkDescriptorUpdateTemplateType" @link substring="templateType" target="#templateType"
///     VkDescriptorSetLayout descriptorSetLayout; // @link substring="VkDescriptorSetLayout" target="VkDescriptorSetLayout" @link substring="descriptorSetLayout" target="#descriptorSetLayout"
///     VkPipelineBindPoint pipelineBindPoint; // @link substring="VkPipelineBindPoint" target="VkPipelineBindPoint" @link substring="pipelineBindPoint" target="#pipelineBindPoint"
///     VkPipelineLayout pipelineLayout; // @link substring="VkPipelineLayout" target="VkPipelineLayout" @link substring="pipelineLayout" target="#pipelineLayout"
///     uint32_t set; // @link substring="set" target="#set"
/// } VkDescriptorUpdateTemplateCreateInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_DESCRIPTOR_UPDATE_TEMPLATE_CREATE_INFO`
///
/// The {@code allocate} ({@link VkDescriptorUpdateTemplateCreateInfo#allocate(Arena)}, {@link VkDescriptorUpdateTemplateCreateInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkDescriptorUpdateTemplateCreateInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDescriptorUpdateTemplateCreateInfo.html"><code>VkDescriptorUpdateTemplateCreateInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDescriptorUpdateTemplateCreateInfo(@NotNull MemorySegment segment) implements IVkDescriptorUpdateTemplateCreateInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDescriptorUpdateTemplateCreateInfo.html"><code>VkDescriptorUpdateTemplateCreateInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDescriptorUpdateTemplateCreateInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDescriptorUpdateTemplateCreateInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDescriptorUpdateTemplateCreateInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDescriptorUpdateTemplateCreateInfo, Iterable<VkDescriptorUpdateTemplateCreateInfo> {
        public long size() {
            return segment.byteSize() / VkDescriptorUpdateTemplateCreateInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDescriptorUpdateTemplateCreateInfo at(long index) {
            return new VkDescriptorUpdateTemplateCreateInfo(segment.asSlice(index * VkDescriptorUpdateTemplateCreateInfo.BYTES, VkDescriptorUpdateTemplateCreateInfo.BYTES));
        }

        public VkDescriptorUpdateTemplateCreateInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkDescriptorUpdateTemplateCreateInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDescriptorUpdateTemplateCreateInfo value) {
            MemorySegment s = segment.asSlice(index * VkDescriptorUpdateTemplateCreateInfo.BYTES, VkDescriptorUpdateTemplateCreateInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDescriptorUpdateTemplateCreateInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDescriptorUpdateTemplateCreateInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDescriptorUpdateTemplateCreateInfo.BYTES,
                (end - start) * VkDescriptorUpdateTemplateCreateInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDescriptorUpdateTemplateCreateInfo.BYTES));
        }

        public VkDescriptorUpdateTemplateCreateInfo[] toArray() {
            VkDescriptorUpdateTemplateCreateInfo[] ret = new VkDescriptorUpdateTemplateCreateInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDescriptorUpdateTemplateCreateInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDescriptorUpdateTemplateCreateInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDescriptorUpdateTemplateCreateInfo.BYTES;
            }

            @Override
            public VkDescriptorUpdateTemplateCreateInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDescriptorUpdateTemplateCreateInfo ret = new VkDescriptorUpdateTemplateCreateInfo(segment.asSlice(0, VkDescriptorUpdateTemplateCreateInfo.BYTES));
                segment = segment.asSlice(VkDescriptorUpdateTemplateCreateInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDescriptorUpdateTemplateCreateInfo allocate(Arena arena) {
        VkDescriptorUpdateTemplateCreateInfo ret = new VkDescriptorUpdateTemplateCreateInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.DESCRIPTOR_UPDATE_TEMPLATE_CREATE_INFO);
        return ret;
    }

    public static VkDescriptorUpdateTemplateCreateInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkDescriptorUpdateTemplateCreateInfo.Ptr ret = new VkDescriptorUpdateTemplateCreateInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.DESCRIPTOR_UPDATE_TEMPLATE_CREATE_INFO);
        }
        return ret;
    }

    public static VkDescriptorUpdateTemplateCreateInfo clone(Arena arena, VkDescriptorUpdateTemplateCreateInfo src) {
        VkDescriptorUpdateTemplateCreateInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.DESCRIPTOR_UPDATE_TEMPLATE_CREATE_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkDescriptorUpdateTemplateCreateInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkDescriptorUpdateTemplateCreateInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkDescriptorUpdateTemplateCreateInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkDescriptorUpdateTemplateCreateFlags.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkDescriptorUpdateTemplateCreateInfo flags(@Bitmask(VkDescriptorUpdateTemplateCreateFlags.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @Unsigned int descriptorUpdateEntryCount() {
        return segment.get(LAYOUT$descriptorUpdateEntryCount, OFFSET$descriptorUpdateEntryCount);
    }

    public VkDescriptorUpdateTemplateCreateInfo descriptorUpdateEntryCount(@Unsigned int value) {
        segment.set(LAYOUT$descriptorUpdateEntryCount, OFFSET$descriptorUpdateEntryCount, value);
        return this;
    }

    public VkDescriptorUpdateTemplateCreateInfo pDescriptorUpdateEntries(@Nullable IVkDescriptorUpdateTemplateEntry value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pDescriptorUpdateEntriesRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkDescriptorUpdateTemplateEntry.Ptr pDescriptorUpdateEntries(int assumedCount) {
        MemorySegment s = pDescriptorUpdateEntriesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkDescriptorUpdateTemplateEntry.BYTES);
        return new VkDescriptorUpdateTemplateEntry.Ptr(s);
    }

    public @Nullable VkDescriptorUpdateTemplateEntry pDescriptorUpdateEntries() {
        MemorySegment s = pDescriptorUpdateEntriesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkDescriptorUpdateTemplateEntry(s);
    }

    public @Pointer(target=VkDescriptorUpdateTemplateEntry.class) @NotNull MemorySegment pDescriptorUpdateEntriesRaw() {
        return segment.get(LAYOUT$pDescriptorUpdateEntries, OFFSET$pDescriptorUpdateEntries);
    }

    public void pDescriptorUpdateEntriesRaw(@Pointer(target=VkDescriptorUpdateTemplateEntry.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pDescriptorUpdateEntries, OFFSET$pDescriptorUpdateEntries, value);
    }

    public @EnumType(VkDescriptorUpdateTemplateType.class) int templateType() {
        return segment.get(LAYOUT$templateType, OFFSET$templateType);
    }

    public VkDescriptorUpdateTemplateCreateInfo templateType(@EnumType(VkDescriptorUpdateTemplateType.class) int value) {
        segment.set(LAYOUT$templateType, OFFSET$templateType, value);
        return this;
    }

    public @Nullable VkDescriptorSetLayout descriptorSetLayout() {
        MemorySegment s = segment.asSlice(OFFSET$descriptorSetLayout, SIZE$descriptorSetLayout);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkDescriptorSetLayout(s);
    }

    public VkDescriptorUpdateTemplateCreateInfo descriptorSetLayout(@Nullable VkDescriptorSetLayout value) {
        segment.set(LAYOUT$descriptorSetLayout, OFFSET$descriptorSetLayout, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @EnumType(VkPipelineBindPoint.class) int pipelineBindPoint() {
        return segment.get(LAYOUT$pipelineBindPoint, OFFSET$pipelineBindPoint);
    }

    public VkDescriptorUpdateTemplateCreateInfo pipelineBindPoint(@EnumType(VkPipelineBindPoint.class) int value) {
        segment.set(LAYOUT$pipelineBindPoint, OFFSET$pipelineBindPoint, value);
        return this;
    }

    public @Nullable VkPipelineLayout pipelineLayout() {
        MemorySegment s = segment.asSlice(OFFSET$pipelineLayout, SIZE$pipelineLayout);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkPipelineLayout(s);
    }

    public VkDescriptorUpdateTemplateCreateInfo pipelineLayout(@Nullable VkPipelineLayout value) {
        segment.set(LAYOUT$pipelineLayout, OFFSET$pipelineLayout, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int set() {
        return segment.get(LAYOUT$set, OFFSET$set);
    }

    public VkDescriptorUpdateTemplateCreateInfo set(@Unsigned int value) {
        segment.set(LAYOUT$set, OFFSET$set, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("descriptorUpdateEntryCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkDescriptorUpdateTemplateEntry.LAYOUT).withName("pDescriptorUpdateEntries"),
        ValueLayout.JAVA_INT.withName("templateType"),
        ValueLayout.ADDRESS.withName("descriptorSetLayout"),
        ValueLayout.JAVA_INT.withName("pipelineBindPoint"),
        ValueLayout.ADDRESS.withName("pipelineLayout"),
        ValueLayout.JAVA_INT.withName("set")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$descriptorUpdateEntryCount = PathElement.groupElement("descriptorUpdateEntryCount");
    public static final PathElement PATH$pDescriptorUpdateEntries = PathElement.groupElement("pDescriptorUpdateEntries");
    public static final PathElement PATH$templateType = PathElement.groupElement("templateType");
    public static final PathElement PATH$descriptorSetLayout = PathElement.groupElement("descriptorSetLayout");
    public static final PathElement PATH$pipelineBindPoint = PathElement.groupElement("pipelineBindPoint");
    public static final PathElement PATH$pipelineLayout = PathElement.groupElement("pipelineLayout");
    public static final PathElement PATH$set = PathElement.groupElement("set");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$descriptorUpdateEntryCount = (OfInt) LAYOUT.select(PATH$descriptorUpdateEntryCount);
    public static final AddressLayout LAYOUT$pDescriptorUpdateEntries = (AddressLayout) LAYOUT.select(PATH$pDescriptorUpdateEntries);
    public static final OfInt LAYOUT$templateType = (OfInt) LAYOUT.select(PATH$templateType);
    public static final AddressLayout LAYOUT$descriptorSetLayout = (AddressLayout) LAYOUT.select(PATH$descriptorSetLayout);
    public static final OfInt LAYOUT$pipelineBindPoint = (OfInt) LAYOUT.select(PATH$pipelineBindPoint);
    public static final AddressLayout LAYOUT$pipelineLayout = (AddressLayout) LAYOUT.select(PATH$pipelineLayout);
    public static final OfInt LAYOUT$set = (OfInt) LAYOUT.select(PATH$set);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$descriptorUpdateEntryCount = LAYOUT$descriptorUpdateEntryCount.byteSize();
    public static final long SIZE$pDescriptorUpdateEntries = LAYOUT$pDescriptorUpdateEntries.byteSize();
    public static final long SIZE$templateType = LAYOUT$templateType.byteSize();
    public static final long SIZE$descriptorSetLayout = LAYOUT$descriptorSetLayout.byteSize();
    public static final long SIZE$pipelineBindPoint = LAYOUT$pipelineBindPoint.byteSize();
    public static final long SIZE$pipelineLayout = LAYOUT$pipelineLayout.byteSize();
    public static final long SIZE$set = LAYOUT$set.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$descriptorUpdateEntryCount = LAYOUT.byteOffset(PATH$descriptorUpdateEntryCount);
    public static final long OFFSET$pDescriptorUpdateEntries = LAYOUT.byteOffset(PATH$pDescriptorUpdateEntries);
    public static final long OFFSET$templateType = LAYOUT.byteOffset(PATH$templateType);
    public static final long OFFSET$descriptorSetLayout = LAYOUT.byteOffset(PATH$descriptorSetLayout);
    public static final long OFFSET$pipelineBindPoint = LAYOUT.byteOffset(PATH$pipelineBindPoint);
    public static final long OFFSET$pipelineLayout = LAYOUT.byteOffset(PATH$pipelineLayout);
    public static final long OFFSET$set = LAYOUT.byteOffset(PATH$set);
}
