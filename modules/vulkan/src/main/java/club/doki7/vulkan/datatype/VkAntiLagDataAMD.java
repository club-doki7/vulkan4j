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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAntiLagDataAMD.html"><code>VkAntiLagDataAMD</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkAntiLagDataAMD {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkAntiLagModeAMD mode; // @link substring="VkAntiLagModeAMD" target="VkAntiLagModeAMD" @link substring="mode" target="#mode"
///     uint32_t maxFPS; // @link substring="maxFPS" target="#maxFPS"
///     VkAntiLagPresentationInfoAMD const* pPresentationInfo; // optional // @link substring="VkAntiLagPresentationInfoAMD" target="VkAntiLagPresentationInfoAMD" @link substring="pPresentationInfo" target="#pPresentationInfo"
/// } VkAntiLagDataAMD;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_ANTI_LAG_DATA_AMD`
///
/// The {@code allocate} ({@link VkAntiLagDataAMD#allocate(Arena)}, {@link VkAntiLagDataAMD#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkAntiLagDataAMD#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAntiLagDataAMD.html"><code>VkAntiLagDataAMD</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkAntiLagDataAMD(@NotNull MemorySegment segment) implements IVkAntiLagDataAMD {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAntiLagDataAMD.html"><code>VkAntiLagDataAMD</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkAntiLagDataAMD}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkAntiLagDataAMD to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkAntiLagDataAMD.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkAntiLagDataAMD, Iterable<VkAntiLagDataAMD> {
        public long size() {
            return segment.byteSize() / VkAntiLagDataAMD.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkAntiLagDataAMD at(long index) {
            return new VkAntiLagDataAMD(segment.asSlice(index * VkAntiLagDataAMD.BYTES, VkAntiLagDataAMD.BYTES));
        }

        public VkAntiLagDataAMD.Ptr at(long index, @NotNull Consumer<@NotNull VkAntiLagDataAMD> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkAntiLagDataAMD value) {
            MemorySegment s = segment.asSlice(index * VkAntiLagDataAMD.BYTES, VkAntiLagDataAMD.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkAntiLagDataAMD.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkAntiLagDataAMD.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkAntiLagDataAMD.BYTES,
                (end - start) * VkAntiLagDataAMD.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkAntiLagDataAMD.BYTES));
        }

        public VkAntiLagDataAMD[] toArray() {
            VkAntiLagDataAMD[] ret = new VkAntiLagDataAMD[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkAntiLagDataAMD> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkAntiLagDataAMD> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkAntiLagDataAMD.BYTES;
            }

            @Override
            public VkAntiLagDataAMD next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkAntiLagDataAMD ret = new VkAntiLagDataAMD(segment.asSlice(0, VkAntiLagDataAMD.BYTES));
                segment = segment.asSlice(VkAntiLagDataAMD.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkAntiLagDataAMD allocate(Arena arena) {
        VkAntiLagDataAMD ret = new VkAntiLagDataAMD(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.ANTI_LAG_DATA_AMD);
        return ret;
    }

    public static VkAntiLagDataAMD.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkAntiLagDataAMD.Ptr ret = new VkAntiLagDataAMD.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.ANTI_LAG_DATA_AMD);
        }
        return ret;
    }

    public static VkAntiLagDataAMD clone(Arena arena, VkAntiLagDataAMD src) {
        VkAntiLagDataAMD ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.ANTI_LAG_DATA_AMD);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkAntiLagDataAMD sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkAntiLagDataAMD pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkAntiLagDataAMD pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @EnumType(VkAntiLagModeAMD.class) int mode() {
        return segment.get(LAYOUT$mode, OFFSET$mode);
    }

    public VkAntiLagDataAMD mode(@EnumType(VkAntiLagModeAMD.class) int value) {
        segment.set(LAYOUT$mode, OFFSET$mode, value);
        return this;
    }

    public @Unsigned int maxFPS() {
        return segment.get(LAYOUT$maxFPS, OFFSET$maxFPS);
    }

    public VkAntiLagDataAMD maxFPS(@Unsigned int value) {
        segment.set(LAYOUT$maxFPS, OFFSET$maxFPS, value);
        return this;
    }

    public VkAntiLagDataAMD pPresentationInfo(@Nullable IVkAntiLagPresentationInfoAMD value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pPresentationInfoRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkAntiLagPresentationInfoAMD.Ptr pPresentationInfo(int assumedCount) {
        MemorySegment s = pPresentationInfoRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkAntiLagPresentationInfoAMD.BYTES);
        return new VkAntiLagPresentationInfoAMD.Ptr(s);
    }

    public @Nullable VkAntiLagPresentationInfoAMD pPresentationInfo() {
        MemorySegment s = pPresentationInfoRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkAntiLagPresentationInfoAMD(s);
    }

    public @Pointer(target=VkAntiLagPresentationInfoAMD.class) @NotNull MemorySegment pPresentationInfoRaw() {
        return segment.get(LAYOUT$pPresentationInfo, OFFSET$pPresentationInfo);
    }

    public void pPresentationInfoRaw(@Pointer(target=VkAntiLagPresentationInfoAMD.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pPresentationInfo, OFFSET$pPresentationInfo, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("mode"),
        ValueLayout.JAVA_INT.withName("maxFPS"),
        ValueLayout.ADDRESS.withTargetLayout(VkAntiLagPresentationInfoAMD.LAYOUT).withName("pPresentationInfo")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$mode = PathElement.groupElement("mode");
    public static final PathElement PATH$maxFPS = PathElement.groupElement("maxFPS");
    public static final PathElement PATH$pPresentationInfo = PathElement.groupElement("pPresentationInfo");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$mode = (OfInt) LAYOUT.select(PATH$mode);
    public static final OfInt LAYOUT$maxFPS = (OfInt) LAYOUT.select(PATH$maxFPS);
    public static final AddressLayout LAYOUT$pPresentationInfo = (AddressLayout) LAYOUT.select(PATH$pPresentationInfo);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$mode = LAYOUT$mode.byteSize();
    public static final long SIZE$maxFPS = LAYOUT$maxFPS.byteSize();
    public static final long SIZE$pPresentationInfo = LAYOUT$pPresentationInfo.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$mode = LAYOUT.byteOffset(PATH$mode);
    public static final long OFFSET$maxFPS = LAYOUT.byteOffset(PATH$maxFPS);
    public static final long OFFSET$pPresentationInfo = LAYOUT.byteOffset(PATH$pPresentationInfo);
}
