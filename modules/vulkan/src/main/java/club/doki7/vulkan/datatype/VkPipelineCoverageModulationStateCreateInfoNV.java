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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineCoverageModulationStateCreateInfoNV.html"><code>VkPipelineCoverageModulationStateCreateInfoNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPipelineCoverageModulationStateCreateInfoNV {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkPipelineCoverageModulationStateCreateFlagsNV flags; // optional // @link substring="VkPipelineCoverageModulationStateCreateFlagsNV" target="VkPipelineCoverageModulationStateCreateFlagsNV" @link substring="flags" target="#flags"
///     VkCoverageModulationModeNV coverageModulationMode; // @link substring="VkCoverageModulationModeNV" target="VkCoverageModulationModeNV" @link substring="coverageModulationMode" target="#coverageModulationMode"
///     VkBool32 coverageModulationTableEnable; // @link substring="coverageModulationTableEnable" target="#coverageModulationTableEnable"
///     uint32_t coverageModulationTableCount; // optional // @link substring="coverageModulationTableCount" target="#coverageModulationTableCount"
///     float const* pCoverageModulationTable; // optional // @link substring="pCoverageModulationTable" target="#pCoverageModulationTable"
/// } VkPipelineCoverageModulationStateCreateInfoNV;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PIPELINE_COVERAGE_MODULATION_STATE_CREATE_INFO_NV`
///
/// The {@code allocate} ({@link VkPipelineCoverageModulationStateCreateInfoNV#allocate(Arena)}, {@link VkPipelineCoverageModulationStateCreateInfoNV#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPipelineCoverageModulationStateCreateInfoNV#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineCoverageModulationStateCreateInfoNV.html"><code>VkPipelineCoverageModulationStateCreateInfoNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPipelineCoverageModulationStateCreateInfoNV(@NotNull MemorySegment segment) implements IVkPipelineCoverageModulationStateCreateInfoNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineCoverageModulationStateCreateInfoNV.html"><code>VkPipelineCoverageModulationStateCreateInfoNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPipelineCoverageModulationStateCreateInfoNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPipelineCoverageModulationStateCreateInfoNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPipelineCoverageModulationStateCreateInfoNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPipelineCoverageModulationStateCreateInfoNV, Iterable<VkPipelineCoverageModulationStateCreateInfoNV> {
        public long size() {
            return segment.byteSize() / VkPipelineCoverageModulationStateCreateInfoNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPipelineCoverageModulationStateCreateInfoNV at(long index) {
            return new VkPipelineCoverageModulationStateCreateInfoNV(segment.asSlice(index * VkPipelineCoverageModulationStateCreateInfoNV.BYTES, VkPipelineCoverageModulationStateCreateInfoNV.BYTES));
        }

        public VkPipelineCoverageModulationStateCreateInfoNV.Ptr at(long index, @NotNull Consumer<@NotNull VkPipelineCoverageModulationStateCreateInfoNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPipelineCoverageModulationStateCreateInfoNV value) {
            MemorySegment s = segment.asSlice(index * VkPipelineCoverageModulationStateCreateInfoNV.BYTES, VkPipelineCoverageModulationStateCreateInfoNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPipelineCoverageModulationStateCreateInfoNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPipelineCoverageModulationStateCreateInfoNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPipelineCoverageModulationStateCreateInfoNV.BYTES,
                (end - start) * VkPipelineCoverageModulationStateCreateInfoNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPipelineCoverageModulationStateCreateInfoNV.BYTES));
        }

        public VkPipelineCoverageModulationStateCreateInfoNV[] toArray() {
            VkPipelineCoverageModulationStateCreateInfoNV[] ret = new VkPipelineCoverageModulationStateCreateInfoNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPipelineCoverageModulationStateCreateInfoNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPipelineCoverageModulationStateCreateInfoNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPipelineCoverageModulationStateCreateInfoNV.BYTES;
            }

            @Override
            public VkPipelineCoverageModulationStateCreateInfoNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPipelineCoverageModulationStateCreateInfoNV ret = new VkPipelineCoverageModulationStateCreateInfoNV(segment.asSlice(0, VkPipelineCoverageModulationStateCreateInfoNV.BYTES));
                segment = segment.asSlice(VkPipelineCoverageModulationStateCreateInfoNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPipelineCoverageModulationStateCreateInfoNV allocate(Arena arena) {
        VkPipelineCoverageModulationStateCreateInfoNV ret = new VkPipelineCoverageModulationStateCreateInfoNV(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PIPELINE_COVERAGE_MODULATION_STATE_CREATE_INFO_NV);
        return ret;
    }

    public static VkPipelineCoverageModulationStateCreateInfoNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPipelineCoverageModulationStateCreateInfoNV.Ptr ret = new VkPipelineCoverageModulationStateCreateInfoNV.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PIPELINE_COVERAGE_MODULATION_STATE_CREATE_INFO_NV);
        }
        return ret;
    }

    public static VkPipelineCoverageModulationStateCreateInfoNV clone(Arena arena, VkPipelineCoverageModulationStateCreateInfoNV src) {
        VkPipelineCoverageModulationStateCreateInfoNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PIPELINE_COVERAGE_MODULATION_STATE_CREATE_INFO_NV);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPipelineCoverageModulationStateCreateInfoNV sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPipelineCoverageModulationStateCreateInfoNV pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPipelineCoverageModulationStateCreateInfoNV pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkPipelineCoverageModulationStateCreateFlagsNV.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkPipelineCoverageModulationStateCreateInfoNV flags(@Bitmask(VkPipelineCoverageModulationStateCreateFlagsNV.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @EnumType(VkCoverageModulationModeNV.class) int coverageModulationMode() {
        return segment.get(LAYOUT$coverageModulationMode, OFFSET$coverageModulationMode);
    }

    public VkPipelineCoverageModulationStateCreateInfoNV coverageModulationMode(@EnumType(VkCoverageModulationModeNV.class) int value) {
        segment.set(LAYOUT$coverageModulationMode, OFFSET$coverageModulationMode, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int coverageModulationTableEnable() {
        return segment.get(LAYOUT$coverageModulationTableEnable, OFFSET$coverageModulationTableEnable);
    }

    public VkPipelineCoverageModulationStateCreateInfoNV coverageModulationTableEnable(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$coverageModulationTableEnable, OFFSET$coverageModulationTableEnable, value);
        return this;
    }

    public @Unsigned int coverageModulationTableCount() {
        return segment.get(LAYOUT$coverageModulationTableCount, OFFSET$coverageModulationTableCount);
    }

    public VkPipelineCoverageModulationStateCreateInfoNV coverageModulationTableCount(@Unsigned int value) {
        segment.set(LAYOUT$coverageModulationTableCount, OFFSET$coverageModulationTableCount, value);
        return this;
    }

    /// Note: the returned {@link FloatPtr} does not have correct
    /// {@link FloatPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link FloatPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable FloatPtr pCoverageModulationTable() {
        MemorySegment s = pCoverageModulationTableRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new FloatPtr(s);
    }

    public VkPipelineCoverageModulationStateCreateInfoNV pCoverageModulationTable(@Nullable FloatPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pCoverageModulationTableRaw(s);
        return this;
    }

    public @Pointer(comment="float*") @NotNull MemorySegment pCoverageModulationTableRaw() {
        return segment.get(LAYOUT$pCoverageModulationTable, OFFSET$pCoverageModulationTable);
    }

    public void pCoverageModulationTableRaw(@Pointer(comment="float*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pCoverageModulationTable, OFFSET$pCoverageModulationTable, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("coverageModulationMode"),
        ValueLayout.JAVA_INT.withName("coverageModulationTableEnable"),
        ValueLayout.JAVA_INT.withName("coverageModulationTableCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_FLOAT).withName("pCoverageModulationTable")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$coverageModulationMode = PathElement.groupElement("coverageModulationMode");
    public static final PathElement PATH$coverageModulationTableEnable = PathElement.groupElement("coverageModulationTableEnable");
    public static final PathElement PATH$coverageModulationTableCount = PathElement.groupElement("coverageModulationTableCount");
    public static final PathElement PATH$pCoverageModulationTable = PathElement.groupElement("pCoverageModulationTable");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$coverageModulationMode = (OfInt) LAYOUT.select(PATH$coverageModulationMode);
    public static final OfInt LAYOUT$coverageModulationTableEnable = (OfInt) LAYOUT.select(PATH$coverageModulationTableEnable);
    public static final OfInt LAYOUT$coverageModulationTableCount = (OfInt) LAYOUT.select(PATH$coverageModulationTableCount);
    public static final AddressLayout LAYOUT$pCoverageModulationTable = (AddressLayout) LAYOUT.select(PATH$pCoverageModulationTable);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$coverageModulationMode = LAYOUT$coverageModulationMode.byteSize();
    public static final long SIZE$coverageModulationTableEnable = LAYOUT$coverageModulationTableEnable.byteSize();
    public static final long SIZE$coverageModulationTableCount = LAYOUT$coverageModulationTableCount.byteSize();
    public static final long SIZE$pCoverageModulationTable = LAYOUT$pCoverageModulationTable.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$coverageModulationMode = LAYOUT.byteOffset(PATH$coverageModulationMode);
    public static final long OFFSET$coverageModulationTableEnable = LAYOUT.byteOffset(PATH$coverageModulationTableEnable);
    public static final long OFFSET$coverageModulationTableCount = LAYOUT.byteOffset(PATH$coverageModulationTableCount);
    public static final long OFFSET$pCoverageModulationTable = LAYOUT.byteOffset(PATH$pCoverageModulationTable);
}
