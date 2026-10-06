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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAccelerationStructureBuildGeometryInfoKHR.html"><code>VkAccelerationStructureBuildGeometryInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkAccelerationStructureBuildGeometryInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkAccelerationStructureTypeKHR type; // @link substring="VkAccelerationStructureTypeKHR" target="VkAccelerationStructureTypeKHR" @link substring="type" target="#type"
///     VkBuildAccelerationStructureFlagsKHR flags; // optional // @link substring="VkBuildAccelerationStructureFlagsKHR" target="VkBuildAccelerationStructureFlagsKHR" @link substring="flags" target="#flags"
///     VkBuildAccelerationStructureModeKHR mode; // @link substring="VkBuildAccelerationStructureModeKHR" target="VkBuildAccelerationStructureModeKHR" @link substring="mode" target="#mode"
///     VkAccelerationStructureKHR srcAccelerationStructure; // optional // @link substring="VkAccelerationStructureKHR" target="VkAccelerationStructureKHR" @link substring="srcAccelerationStructure" target="#srcAccelerationStructure"
///     VkAccelerationStructureKHR dstAccelerationStructure; // optional // @link substring="VkAccelerationStructureKHR" target="VkAccelerationStructureKHR" @link substring="dstAccelerationStructure" target="#dstAccelerationStructure"
///     uint32_t geometryCount; // optional // @link substring="geometryCount" target="#geometryCount"
///     VkAccelerationStructureGeometryKHR const* pGeometries; // optional // @link substring="VkAccelerationStructureGeometryKHR" target="VkAccelerationStructureGeometryKHR" @link substring="pGeometries" target="#pGeometries"
///     VkAccelerationStructureGeometryKHR const* const* ppGeometries; // optional // @link substring="VkAccelerationStructureGeometryKHR" target="VkAccelerationStructureGeometryKHR" @link substring="ppGeometries" target="#ppGeometries"
///     VkDeviceOrHostAddressKHR scratchData; // @link substring="VkDeviceOrHostAddressKHR" target="VkDeviceOrHostAddressKHR" @link substring="scratchData" target="#scratchData"
/// } VkAccelerationStructureBuildGeometryInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_ACCELERATION_STRUCTURE_BUILD_GEOMETRY_INFO_KHR`
///
/// The {@code allocate} ({@link VkAccelerationStructureBuildGeometryInfoKHR#allocate(Arena)}, {@link VkAccelerationStructureBuildGeometryInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkAccelerationStructureBuildGeometryInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAccelerationStructureBuildGeometryInfoKHR.html"><code>VkAccelerationStructureBuildGeometryInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkAccelerationStructureBuildGeometryInfoKHR(@NotNull MemorySegment segment) implements IVkAccelerationStructureBuildGeometryInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAccelerationStructureBuildGeometryInfoKHR.html"><code>VkAccelerationStructureBuildGeometryInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkAccelerationStructureBuildGeometryInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkAccelerationStructureBuildGeometryInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkAccelerationStructureBuildGeometryInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkAccelerationStructureBuildGeometryInfoKHR, Iterable<VkAccelerationStructureBuildGeometryInfoKHR> {
        public long size() {
            return segment.byteSize() / VkAccelerationStructureBuildGeometryInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkAccelerationStructureBuildGeometryInfoKHR at(long index) {
            return new VkAccelerationStructureBuildGeometryInfoKHR(segment.asSlice(index * VkAccelerationStructureBuildGeometryInfoKHR.BYTES, VkAccelerationStructureBuildGeometryInfoKHR.BYTES));
        }

        public VkAccelerationStructureBuildGeometryInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkAccelerationStructureBuildGeometryInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkAccelerationStructureBuildGeometryInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkAccelerationStructureBuildGeometryInfoKHR.BYTES, VkAccelerationStructureBuildGeometryInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkAccelerationStructureBuildGeometryInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkAccelerationStructureBuildGeometryInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkAccelerationStructureBuildGeometryInfoKHR.BYTES,
                (end - start) * VkAccelerationStructureBuildGeometryInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkAccelerationStructureBuildGeometryInfoKHR.BYTES));
        }

        public VkAccelerationStructureBuildGeometryInfoKHR[] toArray() {
            VkAccelerationStructureBuildGeometryInfoKHR[] ret = new VkAccelerationStructureBuildGeometryInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkAccelerationStructureBuildGeometryInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkAccelerationStructureBuildGeometryInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkAccelerationStructureBuildGeometryInfoKHR.BYTES;
            }

            @Override
            public VkAccelerationStructureBuildGeometryInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkAccelerationStructureBuildGeometryInfoKHR ret = new VkAccelerationStructureBuildGeometryInfoKHR(segment.asSlice(0, VkAccelerationStructureBuildGeometryInfoKHR.BYTES));
                segment = segment.asSlice(VkAccelerationStructureBuildGeometryInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkAccelerationStructureBuildGeometryInfoKHR allocate(Arena arena) {
        VkAccelerationStructureBuildGeometryInfoKHR ret = new VkAccelerationStructureBuildGeometryInfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.ACCELERATION_STRUCTURE_BUILD_GEOMETRY_INFO_KHR);
        return ret;
    }

    public static VkAccelerationStructureBuildGeometryInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkAccelerationStructureBuildGeometryInfoKHR.Ptr ret = new VkAccelerationStructureBuildGeometryInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.ACCELERATION_STRUCTURE_BUILD_GEOMETRY_INFO_KHR);
        }
        return ret;
    }

    public static VkAccelerationStructureBuildGeometryInfoKHR clone(Arena arena, VkAccelerationStructureBuildGeometryInfoKHR src) {
        VkAccelerationStructureBuildGeometryInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.ACCELERATION_STRUCTURE_BUILD_GEOMETRY_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkAccelerationStructureBuildGeometryInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkAccelerationStructureBuildGeometryInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkAccelerationStructureBuildGeometryInfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @EnumType(VkAccelerationStructureTypeKHR.class) int type() {
        return segment.get(LAYOUT$type, OFFSET$type);
    }

    public VkAccelerationStructureBuildGeometryInfoKHR type(@EnumType(VkAccelerationStructureTypeKHR.class) int value) {
        segment.set(LAYOUT$type, OFFSET$type, value);
        return this;
    }

    public @Bitmask(VkBuildAccelerationStructureFlagsKHR.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkAccelerationStructureBuildGeometryInfoKHR flags(@Bitmask(VkBuildAccelerationStructureFlagsKHR.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @EnumType(VkBuildAccelerationStructureModeKHR.class) int mode() {
        return segment.get(LAYOUT$mode, OFFSET$mode);
    }

    public VkAccelerationStructureBuildGeometryInfoKHR mode(@EnumType(VkBuildAccelerationStructureModeKHR.class) int value) {
        segment.set(LAYOUT$mode, OFFSET$mode, value);
        return this;
    }

    public @Nullable VkAccelerationStructureKHR srcAccelerationStructure() {
        MemorySegment s = segment.asSlice(OFFSET$srcAccelerationStructure, SIZE$srcAccelerationStructure);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkAccelerationStructureKHR(s);
    }

    public VkAccelerationStructureBuildGeometryInfoKHR srcAccelerationStructure(@Nullable VkAccelerationStructureKHR value) {
        segment.set(LAYOUT$srcAccelerationStructure, OFFSET$srcAccelerationStructure, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Nullable VkAccelerationStructureKHR dstAccelerationStructure() {
        MemorySegment s = segment.asSlice(OFFSET$dstAccelerationStructure, SIZE$dstAccelerationStructure);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkAccelerationStructureKHR(s);
    }

    public VkAccelerationStructureBuildGeometryInfoKHR dstAccelerationStructure(@Nullable VkAccelerationStructureKHR value) {
        segment.set(LAYOUT$dstAccelerationStructure, OFFSET$dstAccelerationStructure, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int geometryCount() {
        return segment.get(LAYOUT$geometryCount, OFFSET$geometryCount);
    }

    public VkAccelerationStructureBuildGeometryInfoKHR geometryCount(@Unsigned int value) {
        segment.set(LAYOUT$geometryCount, OFFSET$geometryCount, value);
        return this;
    }

    public VkAccelerationStructureBuildGeometryInfoKHR pGeometries(@Nullable IVkAccelerationStructureGeometryKHR value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pGeometriesRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkAccelerationStructureGeometryKHR.Ptr pGeometries(int assumedCount) {
        MemorySegment s = pGeometriesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkAccelerationStructureGeometryKHR.BYTES);
        return new VkAccelerationStructureGeometryKHR.Ptr(s);
    }

    public @Nullable VkAccelerationStructureGeometryKHR pGeometries() {
        MemorySegment s = pGeometriesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkAccelerationStructureGeometryKHR(s);
    }

    public @Pointer(target=VkAccelerationStructureGeometryKHR.class) @NotNull MemorySegment pGeometriesRaw() {
        return segment.get(LAYOUT$pGeometries, OFFSET$pGeometries);
    }

    public void pGeometriesRaw(@Pointer(target=VkAccelerationStructureGeometryKHR.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pGeometries, OFFSET$pGeometries, value);
    }

    /// Note: the returned {@link PointerPtr} does not have correct {@link PointerPtr#size} property. It's up
    /// to user to track the size of the buffer, and use {@link PointerPtr#reinterpret} to set the size before
    /// actually reading from or writing to the buffer.
    public @Nullable PointerPtr ppGeometries() {
        MemorySegment s = ppGeometriesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new PointerPtr(s);
    }

    public VkAccelerationStructureBuildGeometryInfoKHR ppGeometries(@Nullable PointerPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        ppGeometriesRaw(s);
        return this;
    }

    public @Pointer(comment="void**") @NotNull MemorySegment ppGeometriesRaw() {
        return segment.get(LAYOUT$ppGeometries, OFFSET$ppGeometries);
    }

    public void ppGeometriesRaw(@Pointer(comment="void**") @NotNull MemorySegment value) {
        segment.set(LAYOUT$ppGeometries, OFFSET$ppGeometries, value);
    }

    public @NotNull VkDeviceOrHostAddressKHR scratchData() {
        return new VkDeviceOrHostAddressKHR(segment.asSlice(OFFSET$scratchData, LAYOUT$scratchData));
    }

    public VkAccelerationStructureBuildGeometryInfoKHR scratchData(@NotNull VkDeviceOrHostAddressKHR value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$scratchData, SIZE$scratchData);
        return this;
    }

    public VkAccelerationStructureBuildGeometryInfoKHR scratchData(Consumer<@NotNull VkDeviceOrHostAddressKHR> consumer) {
        consumer.accept(scratchData());
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("type"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("mode"),
        ValueLayout.ADDRESS.withName("srcAccelerationStructure"),
        ValueLayout.ADDRESS.withName("dstAccelerationStructure"),
        ValueLayout.JAVA_INT.withName("geometryCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkAccelerationStructureGeometryKHR.LAYOUT).withName("pGeometries"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.ADDRESS.withTargetLayout(VkAccelerationStructureGeometryKHR.LAYOUT)).withName("ppGeometries"),
        VkDeviceOrHostAddressKHR.LAYOUT.withName("scratchData")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$type = PathElement.groupElement("type");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$mode = PathElement.groupElement("mode");
    public static final PathElement PATH$srcAccelerationStructure = PathElement.groupElement("srcAccelerationStructure");
    public static final PathElement PATH$dstAccelerationStructure = PathElement.groupElement("dstAccelerationStructure");
    public static final PathElement PATH$geometryCount = PathElement.groupElement("geometryCount");
    public static final PathElement PATH$pGeometries = PathElement.groupElement("pGeometries");
    public static final PathElement PATH$ppGeometries = PathElement.groupElement("ppGeometries");
    public static final PathElement PATH$scratchData = PathElement.groupElement("scratchData");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$type = (OfInt) LAYOUT.select(PATH$type);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$mode = (OfInt) LAYOUT.select(PATH$mode);
    public static final AddressLayout LAYOUT$srcAccelerationStructure = (AddressLayout) LAYOUT.select(PATH$srcAccelerationStructure);
    public static final AddressLayout LAYOUT$dstAccelerationStructure = (AddressLayout) LAYOUT.select(PATH$dstAccelerationStructure);
    public static final OfInt LAYOUT$geometryCount = (OfInt) LAYOUT.select(PATH$geometryCount);
    public static final AddressLayout LAYOUT$pGeometries = (AddressLayout) LAYOUT.select(PATH$pGeometries);
    public static final AddressLayout LAYOUT$ppGeometries = (AddressLayout) LAYOUT.select(PATH$ppGeometries);
    public static final UnionLayout LAYOUT$scratchData = (UnionLayout) LAYOUT.select(PATH$scratchData);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$type = LAYOUT$type.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$mode = LAYOUT$mode.byteSize();
    public static final long SIZE$srcAccelerationStructure = LAYOUT$srcAccelerationStructure.byteSize();
    public static final long SIZE$dstAccelerationStructure = LAYOUT$dstAccelerationStructure.byteSize();
    public static final long SIZE$geometryCount = LAYOUT$geometryCount.byteSize();
    public static final long SIZE$pGeometries = LAYOUT$pGeometries.byteSize();
    public static final long SIZE$ppGeometries = LAYOUT$ppGeometries.byteSize();
    public static final long SIZE$scratchData = LAYOUT$scratchData.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$type = LAYOUT.byteOffset(PATH$type);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$mode = LAYOUT.byteOffset(PATH$mode);
    public static final long OFFSET$srcAccelerationStructure = LAYOUT.byteOffset(PATH$srcAccelerationStructure);
    public static final long OFFSET$dstAccelerationStructure = LAYOUT.byteOffset(PATH$dstAccelerationStructure);
    public static final long OFFSET$geometryCount = LAYOUT.byteOffset(PATH$geometryCount);
    public static final long OFFSET$pGeometries = LAYOUT.byteOffset(PATH$pGeometries);
    public static final long OFFSET$ppGeometries = LAYOUT.byteOffset(PATH$ppGeometries);
    public static final long OFFSET$scratchData = LAYOUT.byteOffset(PATH$scratchData);
}
