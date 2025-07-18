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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeUsageInfoKHR.html"><code>VkVideoEncodeUsageInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkVideoEncodeUsageInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkVideoEncodeUsageFlagsKHR videoUsageHints; // optional // @link substring="VkVideoEncodeUsageFlagsKHR" target="VkVideoEncodeUsageFlagsKHR" @link substring="videoUsageHints" target="#videoUsageHints"
///     VkVideoEncodeContentFlagsKHR videoContentHints; // optional // @link substring="VkVideoEncodeContentFlagsKHR" target="VkVideoEncodeContentFlagsKHR" @link substring="videoContentHints" target="#videoContentHints"
///     VkVideoEncodeTuningModeKHR tuningMode; // optional // @link substring="VkVideoEncodeTuningModeKHR" target="VkVideoEncodeTuningModeKHR" @link substring="tuningMode" target="#tuningMode"
/// } VkVideoEncodeUsageInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_VIDEO_ENCODE_USAGE_INFO_KHR`
///
/// The {@code allocate} ({@link VkVideoEncodeUsageInfoKHR#allocate(Arena)}, {@link VkVideoEncodeUsageInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkVideoEncodeUsageInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeUsageInfoKHR.html"><code>VkVideoEncodeUsageInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkVideoEncodeUsageInfoKHR(@NotNull MemorySegment segment) implements IVkVideoEncodeUsageInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeUsageInfoKHR.html"><code>VkVideoEncodeUsageInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkVideoEncodeUsageInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkVideoEncodeUsageInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkVideoEncodeUsageInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkVideoEncodeUsageInfoKHR, Iterable<VkVideoEncodeUsageInfoKHR> {
        public long size() {
            return segment.byteSize() / VkVideoEncodeUsageInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkVideoEncodeUsageInfoKHR at(long index) {
            return new VkVideoEncodeUsageInfoKHR(segment.asSlice(index * VkVideoEncodeUsageInfoKHR.BYTES, VkVideoEncodeUsageInfoKHR.BYTES));
        }

        public VkVideoEncodeUsageInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkVideoEncodeUsageInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkVideoEncodeUsageInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkVideoEncodeUsageInfoKHR.BYTES, VkVideoEncodeUsageInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkVideoEncodeUsageInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkVideoEncodeUsageInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkVideoEncodeUsageInfoKHR.BYTES,
                (end - start) * VkVideoEncodeUsageInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkVideoEncodeUsageInfoKHR.BYTES));
        }

        public VkVideoEncodeUsageInfoKHR[] toArray() {
            VkVideoEncodeUsageInfoKHR[] ret = new VkVideoEncodeUsageInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkVideoEncodeUsageInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkVideoEncodeUsageInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkVideoEncodeUsageInfoKHR.BYTES;
            }

            @Override
            public VkVideoEncodeUsageInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkVideoEncodeUsageInfoKHR ret = new VkVideoEncodeUsageInfoKHR(segment.asSlice(0, VkVideoEncodeUsageInfoKHR.BYTES));
                segment = segment.asSlice(VkVideoEncodeUsageInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkVideoEncodeUsageInfoKHR allocate(Arena arena) {
        VkVideoEncodeUsageInfoKHR ret = new VkVideoEncodeUsageInfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.VIDEO_ENCODE_USAGE_INFO_KHR);
        return ret;
    }

    public static VkVideoEncodeUsageInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkVideoEncodeUsageInfoKHR.Ptr ret = new VkVideoEncodeUsageInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.VIDEO_ENCODE_USAGE_INFO_KHR);
        }
        return ret;
    }

    public static VkVideoEncodeUsageInfoKHR clone(Arena arena, VkVideoEncodeUsageInfoKHR src) {
        VkVideoEncodeUsageInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.VIDEO_ENCODE_USAGE_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkVideoEncodeUsageInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkVideoEncodeUsageInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkVideoEncodeUsageInfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkVideoEncodeUsageFlagsKHR.class) int videoUsageHints() {
        return segment.get(LAYOUT$videoUsageHints, OFFSET$videoUsageHints);
    }

    public VkVideoEncodeUsageInfoKHR videoUsageHints(@Bitmask(VkVideoEncodeUsageFlagsKHR.class) int value) {
        segment.set(LAYOUT$videoUsageHints, OFFSET$videoUsageHints, value);
        return this;
    }

    public @Bitmask(VkVideoEncodeContentFlagsKHR.class) int videoContentHints() {
        return segment.get(LAYOUT$videoContentHints, OFFSET$videoContentHints);
    }

    public VkVideoEncodeUsageInfoKHR videoContentHints(@Bitmask(VkVideoEncodeContentFlagsKHR.class) int value) {
        segment.set(LAYOUT$videoContentHints, OFFSET$videoContentHints, value);
        return this;
    }

    public @EnumType(VkVideoEncodeTuningModeKHR.class) int tuningMode() {
        return segment.get(LAYOUT$tuningMode, OFFSET$tuningMode);
    }

    public VkVideoEncodeUsageInfoKHR tuningMode(@EnumType(VkVideoEncodeTuningModeKHR.class) int value) {
        segment.set(LAYOUT$tuningMode, OFFSET$tuningMode, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("videoUsageHints"),
        ValueLayout.JAVA_INT.withName("videoContentHints"),
        ValueLayout.JAVA_INT.withName("tuningMode")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$videoUsageHints = PathElement.groupElement("videoUsageHints");
    public static final PathElement PATH$videoContentHints = PathElement.groupElement("videoContentHints");
    public static final PathElement PATH$tuningMode = PathElement.groupElement("tuningMode");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$videoUsageHints = (OfInt) LAYOUT.select(PATH$videoUsageHints);
    public static final OfInt LAYOUT$videoContentHints = (OfInt) LAYOUT.select(PATH$videoContentHints);
    public static final OfInt LAYOUT$tuningMode = (OfInt) LAYOUT.select(PATH$tuningMode);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$videoUsageHints = LAYOUT$videoUsageHints.byteSize();
    public static final long SIZE$videoContentHints = LAYOUT$videoContentHints.byteSize();
    public static final long SIZE$tuningMode = LAYOUT$tuningMode.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$videoUsageHints = LAYOUT.byteOffset(PATH$videoUsageHints);
    public static final long OFFSET$videoContentHints = LAYOUT.byteOffset(PATH$videoContentHints);
    public static final long OFFSET$tuningMode = LAYOUT.byteOffset(PATH$tuningMode);
}
