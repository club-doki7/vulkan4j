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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineCoverageToColorStateCreateInfoNV.html"><code>VkPipelineCoverageToColorStateCreateInfoNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPipelineCoverageToColorStateCreateInfoNV {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkPipelineCoverageToColorStateCreateFlagsNV flags; // optional // @link substring="VkPipelineCoverageToColorStateCreateFlagsNV" target="VkPipelineCoverageToColorStateCreateFlagsNV" @link substring="flags" target="#flags"
///     VkBool32 coverageToColorEnable; // @link substring="coverageToColorEnable" target="#coverageToColorEnable"
///     uint32_t coverageToColorLocation; // optional // @link substring="coverageToColorLocation" target="#coverageToColorLocation"
/// } VkPipelineCoverageToColorStateCreateInfoNV;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PIPELINE_COVERAGE_TO_COLOR_STATE_CREATE_INFO_NV`
///
/// The {@code allocate} ({@link VkPipelineCoverageToColorStateCreateInfoNV#allocate(Arena)}, {@link VkPipelineCoverageToColorStateCreateInfoNV#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPipelineCoverageToColorStateCreateInfoNV#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineCoverageToColorStateCreateInfoNV.html"><code>VkPipelineCoverageToColorStateCreateInfoNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPipelineCoverageToColorStateCreateInfoNV(@NotNull MemorySegment segment) implements IVkPipelineCoverageToColorStateCreateInfoNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPipelineCoverageToColorStateCreateInfoNV.html"><code>VkPipelineCoverageToColorStateCreateInfoNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPipelineCoverageToColorStateCreateInfoNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPipelineCoverageToColorStateCreateInfoNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPipelineCoverageToColorStateCreateInfoNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPipelineCoverageToColorStateCreateInfoNV, Iterable<VkPipelineCoverageToColorStateCreateInfoNV> {
        public long size() {
            return segment.byteSize() / VkPipelineCoverageToColorStateCreateInfoNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPipelineCoverageToColorStateCreateInfoNV at(long index) {
            return new VkPipelineCoverageToColorStateCreateInfoNV(segment.asSlice(index * VkPipelineCoverageToColorStateCreateInfoNV.BYTES, VkPipelineCoverageToColorStateCreateInfoNV.BYTES));
        }

        public VkPipelineCoverageToColorStateCreateInfoNV.Ptr at(long index, @NotNull Consumer<@NotNull VkPipelineCoverageToColorStateCreateInfoNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPipelineCoverageToColorStateCreateInfoNV value) {
            MemorySegment s = segment.asSlice(index * VkPipelineCoverageToColorStateCreateInfoNV.BYTES, VkPipelineCoverageToColorStateCreateInfoNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPipelineCoverageToColorStateCreateInfoNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPipelineCoverageToColorStateCreateInfoNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPipelineCoverageToColorStateCreateInfoNV.BYTES,
                (end - start) * VkPipelineCoverageToColorStateCreateInfoNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPipelineCoverageToColorStateCreateInfoNV.BYTES));
        }

        public VkPipelineCoverageToColorStateCreateInfoNV[] toArray() {
            VkPipelineCoverageToColorStateCreateInfoNV[] ret = new VkPipelineCoverageToColorStateCreateInfoNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPipelineCoverageToColorStateCreateInfoNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPipelineCoverageToColorStateCreateInfoNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPipelineCoverageToColorStateCreateInfoNV.BYTES;
            }

            @Override
            public VkPipelineCoverageToColorStateCreateInfoNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPipelineCoverageToColorStateCreateInfoNV ret = new VkPipelineCoverageToColorStateCreateInfoNV(segment.asSlice(0, VkPipelineCoverageToColorStateCreateInfoNV.BYTES));
                segment = segment.asSlice(VkPipelineCoverageToColorStateCreateInfoNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPipelineCoverageToColorStateCreateInfoNV allocate(Arena arena) {
        VkPipelineCoverageToColorStateCreateInfoNV ret = new VkPipelineCoverageToColorStateCreateInfoNV(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PIPELINE_COVERAGE_TO_COLOR_STATE_CREATE_INFO_NV);
        return ret;
    }

    public static VkPipelineCoverageToColorStateCreateInfoNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPipelineCoverageToColorStateCreateInfoNV.Ptr ret = new VkPipelineCoverageToColorStateCreateInfoNV.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PIPELINE_COVERAGE_TO_COLOR_STATE_CREATE_INFO_NV);
        }
        return ret;
    }

    public static VkPipelineCoverageToColorStateCreateInfoNV clone(Arena arena, VkPipelineCoverageToColorStateCreateInfoNV src) {
        VkPipelineCoverageToColorStateCreateInfoNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PIPELINE_COVERAGE_TO_COLOR_STATE_CREATE_INFO_NV);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPipelineCoverageToColorStateCreateInfoNV sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPipelineCoverageToColorStateCreateInfoNV pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPipelineCoverageToColorStateCreateInfoNV pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkPipelineCoverageToColorStateCreateFlagsNV.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkPipelineCoverageToColorStateCreateInfoNV flags(@Bitmask(VkPipelineCoverageToColorStateCreateFlagsNV.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int coverageToColorEnable() {
        return segment.get(LAYOUT$coverageToColorEnable, OFFSET$coverageToColorEnable);
    }

    public VkPipelineCoverageToColorStateCreateInfoNV coverageToColorEnable(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$coverageToColorEnable, OFFSET$coverageToColorEnable, value);
        return this;
    }

    public @Unsigned int coverageToColorLocation() {
        return segment.get(LAYOUT$coverageToColorLocation, OFFSET$coverageToColorLocation);
    }

    public VkPipelineCoverageToColorStateCreateInfoNV coverageToColorLocation(@Unsigned int value) {
        segment.set(LAYOUT$coverageToColorLocation, OFFSET$coverageToColorLocation, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("coverageToColorEnable"),
        ValueLayout.JAVA_INT.withName("coverageToColorLocation")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$coverageToColorEnable = PathElement.groupElement("coverageToColorEnable");
    public static final PathElement PATH$coverageToColorLocation = PathElement.groupElement("coverageToColorLocation");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$coverageToColorEnable = (OfInt) LAYOUT.select(PATH$coverageToColorEnable);
    public static final OfInt LAYOUT$coverageToColorLocation = (OfInt) LAYOUT.select(PATH$coverageToColorLocation);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$coverageToColorEnable = LAYOUT$coverageToColorEnable.byteSize();
    public static final long SIZE$coverageToColorLocation = LAYOUT$coverageToColorLocation.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$coverageToColorEnable = LAYOUT.byteOffset(PATH$coverageToColorEnable);
    public static final long OFFSET$coverageToColorLocation = LAYOUT.byteOffset(PATH$coverageToColorLocation);
}
