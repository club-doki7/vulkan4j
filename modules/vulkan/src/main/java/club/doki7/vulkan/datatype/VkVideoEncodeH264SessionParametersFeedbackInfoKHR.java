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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeH264SessionParametersFeedbackInfoKHR.html"><code>VkVideoEncodeH264SessionParametersFeedbackInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkVideoEncodeH264SessionParametersFeedbackInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 hasStdSPSOverrides; // @link substring="hasStdSPSOverrides" target="#hasStdSPSOverrides"
///     VkBool32 hasStdPPSOverrides; // @link substring="hasStdPPSOverrides" target="#hasStdPPSOverrides"
/// } VkVideoEncodeH264SessionParametersFeedbackInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_VIDEO_ENCODE_H264_SESSION_PARAMETERS_FEEDBACK_INFO_KHR`
///
/// The {@code allocate} ({@link VkVideoEncodeH264SessionParametersFeedbackInfoKHR#allocate(Arena)}, {@link VkVideoEncodeH264SessionParametersFeedbackInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkVideoEncodeH264SessionParametersFeedbackInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeH264SessionParametersFeedbackInfoKHR.html"><code>VkVideoEncodeH264SessionParametersFeedbackInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkVideoEncodeH264SessionParametersFeedbackInfoKHR(@NotNull MemorySegment segment) implements IVkVideoEncodeH264SessionParametersFeedbackInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeH264SessionParametersFeedbackInfoKHR.html"><code>VkVideoEncodeH264SessionParametersFeedbackInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkVideoEncodeH264SessionParametersFeedbackInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkVideoEncodeH264SessionParametersFeedbackInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkVideoEncodeH264SessionParametersFeedbackInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkVideoEncodeH264SessionParametersFeedbackInfoKHR, Iterable<VkVideoEncodeH264SessionParametersFeedbackInfoKHR> {
        public long size() {
            return segment.byteSize() / VkVideoEncodeH264SessionParametersFeedbackInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkVideoEncodeH264SessionParametersFeedbackInfoKHR at(long index) {
            return new VkVideoEncodeH264SessionParametersFeedbackInfoKHR(segment.asSlice(index * VkVideoEncodeH264SessionParametersFeedbackInfoKHR.BYTES, VkVideoEncodeH264SessionParametersFeedbackInfoKHR.BYTES));
        }

        public VkVideoEncodeH264SessionParametersFeedbackInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkVideoEncodeH264SessionParametersFeedbackInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkVideoEncodeH264SessionParametersFeedbackInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkVideoEncodeH264SessionParametersFeedbackInfoKHR.BYTES, VkVideoEncodeH264SessionParametersFeedbackInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkVideoEncodeH264SessionParametersFeedbackInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkVideoEncodeH264SessionParametersFeedbackInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkVideoEncodeH264SessionParametersFeedbackInfoKHR.BYTES,
                (end - start) * VkVideoEncodeH264SessionParametersFeedbackInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkVideoEncodeH264SessionParametersFeedbackInfoKHR.BYTES));
        }

        public VkVideoEncodeH264SessionParametersFeedbackInfoKHR[] toArray() {
            VkVideoEncodeH264SessionParametersFeedbackInfoKHR[] ret = new VkVideoEncodeH264SessionParametersFeedbackInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkVideoEncodeH264SessionParametersFeedbackInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkVideoEncodeH264SessionParametersFeedbackInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkVideoEncodeH264SessionParametersFeedbackInfoKHR.BYTES;
            }

            @Override
            public VkVideoEncodeH264SessionParametersFeedbackInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkVideoEncodeH264SessionParametersFeedbackInfoKHR ret = new VkVideoEncodeH264SessionParametersFeedbackInfoKHR(segment.asSlice(0, VkVideoEncodeH264SessionParametersFeedbackInfoKHR.BYTES));
                segment = segment.asSlice(VkVideoEncodeH264SessionParametersFeedbackInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkVideoEncodeH264SessionParametersFeedbackInfoKHR allocate(Arena arena) {
        VkVideoEncodeH264SessionParametersFeedbackInfoKHR ret = new VkVideoEncodeH264SessionParametersFeedbackInfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.VIDEO_ENCODE_H264_SESSION_PARAMETERS_FEEDBACK_INFO_KHR);
        return ret;
    }

    public static VkVideoEncodeH264SessionParametersFeedbackInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkVideoEncodeH264SessionParametersFeedbackInfoKHR.Ptr ret = new VkVideoEncodeH264SessionParametersFeedbackInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.VIDEO_ENCODE_H264_SESSION_PARAMETERS_FEEDBACK_INFO_KHR);
        }
        return ret;
    }

    public static VkVideoEncodeH264SessionParametersFeedbackInfoKHR clone(Arena arena, VkVideoEncodeH264SessionParametersFeedbackInfoKHR src) {
        VkVideoEncodeH264SessionParametersFeedbackInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.VIDEO_ENCODE_H264_SESSION_PARAMETERS_FEEDBACK_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkVideoEncodeH264SessionParametersFeedbackInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkVideoEncodeH264SessionParametersFeedbackInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkVideoEncodeH264SessionParametersFeedbackInfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int hasStdSPSOverrides() {
        return segment.get(LAYOUT$hasStdSPSOverrides, OFFSET$hasStdSPSOverrides);
    }

    public VkVideoEncodeH264SessionParametersFeedbackInfoKHR hasStdSPSOverrides(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$hasStdSPSOverrides, OFFSET$hasStdSPSOverrides, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int hasStdPPSOverrides() {
        return segment.get(LAYOUT$hasStdPPSOverrides, OFFSET$hasStdPPSOverrides);
    }

    public VkVideoEncodeH264SessionParametersFeedbackInfoKHR hasStdPPSOverrides(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$hasStdPPSOverrides, OFFSET$hasStdPPSOverrides, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("hasStdSPSOverrides"),
        ValueLayout.JAVA_INT.withName("hasStdPPSOverrides")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$hasStdSPSOverrides = PathElement.groupElement("hasStdSPSOverrides");
    public static final PathElement PATH$hasStdPPSOverrides = PathElement.groupElement("hasStdPPSOverrides");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$hasStdSPSOverrides = (OfInt) LAYOUT.select(PATH$hasStdSPSOverrides);
    public static final OfInt LAYOUT$hasStdPPSOverrides = (OfInt) LAYOUT.select(PATH$hasStdPPSOverrides);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$hasStdSPSOverrides = LAYOUT$hasStdSPSOverrides.byteSize();
    public static final long SIZE$hasStdPPSOverrides = LAYOUT$hasStdPPSOverrides.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$hasStdSPSOverrides = LAYOUT.byteOffset(PATH$hasStdSPSOverrides);
    public static final long OFFSET$hasStdPPSOverrides = LAYOUT.byteOffset(PATH$hasStdPPSOverrides);
}
