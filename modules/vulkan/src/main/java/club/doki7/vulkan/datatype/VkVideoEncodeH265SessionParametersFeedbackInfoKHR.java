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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeH265SessionParametersFeedbackInfoKHR.html"><code>VkVideoEncodeH265SessionParametersFeedbackInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkVideoEncodeH265SessionParametersFeedbackInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 hasStdVPSOverrides; // @link substring="hasStdVPSOverrides" target="#hasStdVPSOverrides"
///     VkBool32 hasStdSPSOverrides; // @link substring="hasStdSPSOverrides" target="#hasStdSPSOverrides"
///     VkBool32 hasStdPPSOverrides; // @link substring="hasStdPPSOverrides" target="#hasStdPPSOverrides"
/// } VkVideoEncodeH265SessionParametersFeedbackInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_VIDEO_ENCODE_H265_SESSION_PARAMETERS_FEEDBACK_INFO_KHR`
///
/// The {@code allocate} ({@link VkVideoEncodeH265SessionParametersFeedbackInfoKHR#allocate(Arena)}, {@link VkVideoEncodeH265SessionParametersFeedbackInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkVideoEncodeH265SessionParametersFeedbackInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeH265SessionParametersFeedbackInfoKHR.html"><code>VkVideoEncodeH265SessionParametersFeedbackInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkVideoEncodeH265SessionParametersFeedbackInfoKHR(@NotNull MemorySegment segment) implements IVkVideoEncodeH265SessionParametersFeedbackInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkVideoEncodeH265SessionParametersFeedbackInfoKHR.html"><code>VkVideoEncodeH265SessionParametersFeedbackInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkVideoEncodeH265SessionParametersFeedbackInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkVideoEncodeH265SessionParametersFeedbackInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkVideoEncodeH265SessionParametersFeedbackInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkVideoEncodeH265SessionParametersFeedbackInfoKHR, Iterable<VkVideoEncodeH265SessionParametersFeedbackInfoKHR> {
        public long size() {
            return segment.byteSize() / VkVideoEncodeH265SessionParametersFeedbackInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkVideoEncodeH265SessionParametersFeedbackInfoKHR at(long index) {
            return new VkVideoEncodeH265SessionParametersFeedbackInfoKHR(segment.asSlice(index * VkVideoEncodeH265SessionParametersFeedbackInfoKHR.BYTES, VkVideoEncodeH265SessionParametersFeedbackInfoKHR.BYTES));
        }

        public VkVideoEncodeH265SessionParametersFeedbackInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkVideoEncodeH265SessionParametersFeedbackInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkVideoEncodeH265SessionParametersFeedbackInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkVideoEncodeH265SessionParametersFeedbackInfoKHR.BYTES, VkVideoEncodeH265SessionParametersFeedbackInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkVideoEncodeH265SessionParametersFeedbackInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkVideoEncodeH265SessionParametersFeedbackInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkVideoEncodeH265SessionParametersFeedbackInfoKHR.BYTES,
                (end - start) * VkVideoEncodeH265SessionParametersFeedbackInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkVideoEncodeH265SessionParametersFeedbackInfoKHR.BYTES));
        }

        public VkVideoEncodeH265SessionParametersFeedbackInfoKHR[] toArray() {
            VkVideoEncodeH265SessionParametersFeedbackInfoKHR[] ret = new VkVideoEncodeH265SessionParametersFeedbackInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkVideoEncodeH265SessionParametersFeedbackInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkVideoEncodeH265SessionParametersFeedbackInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkVideoEncodeH265SessionParametersFeedbackInfoKHR.BYTES;
            }

            @Override
            public VkVideoEncodeH265SessionParametersFeedbackInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkVideoEncodeH265SessionParametersFeedbackInfoKHR ret = new VkVideoEncodeH265SessionParametersFeedbackInfoKHR(segment.asSlice(0, VkVideoEncodeH265SessionParametersFeedbackInfoKHR.BYTES));
                segment = segment.asSlice(VkVideoEncodeH265SessionParametersFeedbackInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkVideoEncodeH265SessionParametersFeedbackInfoKHR allocate(Arena arena) {
        VkVideoEncodeH265SessionParametersFeedbackInfoKHR ret = new VkVideoEncodeH265SessionParametersFeedbackInfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.VIDEO_ENCODE_H265_SESSION_PARAMETERS_FEEDBACK_INFO_KHR);
        return ret;
    }

    public static VkVideoEncodeH265SessionParametersFeedbackInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkVideoEncodeH265SessionParametersFeedbackInfoKHR.Ptr ret = new VkVideoEncodeH265SessionParametersFeedbackInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.VIDEO_ENCODE_H265_SESSION_PARAMETERS_FEEDBACK_INFO_KHR);
        }
        return ret;
    }

    public static VkVideoEncodeH265SessionParametersFeedbackInfoKHR clone(Arena arena, VkVideoEncodeH265SessionParametersFeedbackInfoKHR src) {
        VkVideoEncodeH265SessionParametersFeedbackInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.VIDEO_ENCODE_H265_SESSION_PARAMETERS_FEEDBACK_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkVideoEncodeH265SessionParametersFeedbackInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkVideoEncodeH265SessionParametersFeedbackInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkVideoEncodeH265SessionParametersFeedbackInfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int hasStdVPSOverrides() {
        return segment.get(LAYOUT$hasStdVPSOverrides, OFFSET$hasStdVPSOverrides);
    }

    public VkVideoEncodeH265SessionParametersFeedbackInfoKHR hasStdVPSOverrides(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$hasStdVPSOverrides, OFFSET$hasStdVPSOverrides, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int hasStdSPSOverrides() {
        return segment.get(LAYOUT$hasStdSPSOverrides, OFFSET$hasStdSPSOverrides);
    }

    public VkVideoEncodeH265SessionParametersFeedbackInfoKHR hasStdSPSOverrides(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$hasStdSPSOverrides, OFFSET$hasStdSPSOverrides, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int hasStdPPSOverrides() {
        return segment.get(LAYOUT$hasStdPPSOverrides, OFFSET$hasStdPPSOverrides);
    }

    public VkVideoEncodeH265SessionParametersFeedbackInfoKHR hasStdPPSOverrides(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$hasStdPPSOverrides, OFFSET$hasStdPPSOverrides, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("hasStdVPSOverrides"),
        ValueLayout.JAVA_INT.withName("hasStdSPSOverrides"),
        ValueLayout.JAVA_INT.withName("hasStdPPSOverrides")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$hasStdVPSOverrides = PathElement.groupElement("hasStdVPSOverrides");
    public static final PathElement PATH$hasStdSPSOverrides = PathElement.groupElement("hasStdSPSOverrides");
    public static final PathElement PATH$hasStdPPSOverrides = PathElement.groupElement("hasStdPPSOverrides");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$hasStdVPSOverrides = (OfInt) LAYOUT.select(PATH$hasStdVPSOverrides);
    public static final OfInt LAYOUT$hasStdSPSOverrides = (OfInt) LAYOUT.select(PATH$hasStdSPSOverrides);
    public static final OfInt LAYOUT$hasStdPPSOverrides = (OfInt) LAYOUT.select(PATH$hasStdPPSOverrides);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$hasStdVPSOverrides = LAYOUT$hasStdVPSOverrides.byteSize();
    public static final long SIZE$hasStdSPSOverrides = LAYOUT$hasStdSPSOverrides.byteSize();
    public static final long SIZE$hasStdPPSOverrides = LAYOUT$hasStdPPSOverrides.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$hasStdVPSOverrides = LAYOUT.byteOffset(PATH$hasStdVPSOverrides);
    public static final long OFFSET$hasStdSPSOverrides = LAYOUT.byteOffset(PATH$hasStdSPSOverrides);
    public static final long OFFSET$hasStdPPSOverrides = LAYOUT.byteOffset(PATH$hasStdPPSOverrides);
}
