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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkShaderResourceUsageAMD.html"><code>VkShaderResourceUsageAMD</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkShaderResourceUsageAMD {
///     uint32_t numUsedVgprs; // @link substring="numUsedVgprs" target="#numUsedVgprs"
///     uint32_t numUsedSgprs; // @link substring="numUsedSgprs" target="#numUsedSgprs"
///     uint32_t ldsSizePerLocalWorkGroup; // @link substring="ldsSizePerLocalWorkGroup" target="#ldsSizePerLocalWorkGroup"
///     size_t ldsUsageSizeInBytes; // @link substring="ldsUsageSizeInBytes" target="#ldsUsageSizeInBytes"
///     size_t scratchMemUsageInBytes; // @link substring="scratchMemUsageInBytes" target="#scratchMemUsageInBytes"
/// } VkShaderResourceUsageAMD;
/// }
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkShaderResourceUsageAMD.html"><code>VkShaderResourceUsageAMD</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkShaderResourceUsageAMD(@NotNull MemorySegment segment) implements IVkShaderResourceUsageAMD {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkShaderResourceUsageAMD.html"><code>VkShaderResourceUsageAMD</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkShaderResourceUsageAMD}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkShaderResourceUsageAMD to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkShaderResourceUsageAMD.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkShaderResourceUsageAMD, Iterable<VkShaderResourceUsageAMD> {
        public long size() {
            return segment.byteSize() / VkShaderResourceUsageAMD.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkShaderResourceUsageAMD at(long index) {
            return new VkShaderResourceUsageAMD(segment.asSlice(index * VkShaderResourceUsageAMD.BYTES, VkShaderResourceUsageAMD.BYTES));
        }

        public VkShaderResourceUsageAMD.Ptr at(long index, @NotNull Consumer<@NotNull VkShaderResourceUsageAMD> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkShaderResourceUsageAMD value) {
            MemorySegment s = segment.asSlice(index * VkShaderResourceUsageAMD.BYTES, VkShaderResourceUsageAMD.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkShaderResourceUsageAMD.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkShaderResourceUsageAMD.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkShaderResourceUsageAMD.BYTES,
                (end - start) * VkShaderResourceUsageAMD.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkShaderResourceUsageAMD.BYTES));
        }

        public VkShaderResourceUsageAMD[] toArray() {
            VkShaderResourceUsageAMD[] ret = new VkShaderResourceUsageAMD[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkShaderResourceUsageAMD> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkShaderResourceUsageAMD> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkShaderResourceUsageAMD.BYTES;
            }

            @Override
            public VkShaderResourceUsageAMD next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkShaderResourceUsageAMD ret = new VkShaderResourceUsageAMD(segment.asSlice(0, VkShaderResourceUsageAMD.BYTES));
                segment = segment.asSlice(VkShaderResourceUsageAMD.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkShaderResourceUsageAMD allocate(Arena arena) {
        return new VkShaderResourceUsageAMD(arena.allocate(LAYOUT));
    }

    public static VkShaderResourceUsageAMD.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VkShaderResourceUsageAMD.Ptr(segment);
    }

    public static VkShaderResourceUsageAMD clone(Arena arena, VkShaderResourceUsageAMD src) {
        VkShaderResourceUsageAMD ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @Unsigned int numUsedVgprs() {
        return segment.get(LAYOUT$numUsedVgprs, OFFSET$numUsedVgprs);
    }

    public VkShaderResourceUsageAMD numUsedVgprs(@Unsigned int value) {
        segment.set(LAYOUT$numUsedVgprs, OFFSET$numUsedVgprs, value);
        return this;
    }

    public @Unsigned int numUsedSgprs() {
        return segment.get(LAYOUT$numUsedSgprs, OFFSET$numUsedSgprs);
    }

    public VkShaderResourceUsageAMD numUsedSgprs(@Unsigned int value) {
        segment.set(LAYOUT$numUsedSgprs, OFFSET$numUsedSgprs, value);
        return this;
    }

    public @Unsigned int ldsSizePerLocalWorkGroup() {
        return segment.get(LAYOUT$ldsSizePerLocalWorkGroup, OFFSET$ldsSizePerLocalWorkGroup);
    }

    public VkShaderResourceUsageAMD ldsSizePerLocalWorkGroup(@Unsigned int value) {
        segment.set(LAYOUT$ldsSizePerLocalWorkGroup, OFFSET$ldsSizePerLocalWorkGroup, value);
        return this;
    }

    public @Unsigned long ldsUsageSizeInBytes() {
        return NativeLayout.readCSizeT(segment, OFFSET$ldsUsageSizeInBytes);
    }

    public VkShaderResourceUsageAMD ldsUsageSizeInBytes(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$ldsUsageSizeInBytes, value);
        return this;
    }

    public @Unsigned long scratchMemUsageInBytes() {
        return NativeLayout.readCSizeT(segment, OFFSET$scratchMemUsageInBytes);
    }

    public VkShaderResourceUsageAMD scratchMemUsageInBytes(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$scratchMemUsageInBytes, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("numUsedVgprs"),
        ValueLayout.JAVA_INT.withName("numUsedSgprs"),
        ValueLayout.JAVA_INT.withName("ldsSizePerLocalWorkGroup"),
        NativeLayout.C_SIZE_T.withName("ldsUsageSizeInBytes"),
        NativeLayout.C_SIZE_T.withName("scratchMemUsageInBytes")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$numUsedVgprs = PathElement.groupElement("numUsedVgprs");
    public static final PathElement PATH$numUsedSgprs = PathElement.groupElement("numUsedSgprs");
    public static final PathElement PATH$ldsSizePerLocalWorkGroup = PathElement.groupElement("ldsSizePerLocalWorkGroup");
    public static final PathElement PATH$ldsUsageSizeInBytes = PathElement.groupElement("ldsUsageSizeInBytes");
    public static final PathElement PATH$scratchMemUsageInBytes = PathElement.groupElement("scratchMemUsageInBytes");

    public static final OfInt LAYOUT$numUsedVgprs = (OfInt) LAYOUT.select(PATH$numUsedVgprs);
    public static final OfInt LAYOUT$numUsedSgprs = (OfInt) LAYOUT.select(PATH$numUsedSgprs);
    public static final OfInt LAYOUT$ldsSizePerLocalWorkGroup = (OfInt) LAYOUT.select(PATH$ldsSizePerLocalWorkGroup);

    public static final long SIZE$numUsedVgprs = LAYOUT$numUsedVgprs.byteSize();
    public static final long SIZE$numUsedSgprs = LAYOUT$numUsedSgprs.byteSize();
    public static final long SIZE$ldsSizePerLocalWorkGroup = LAYOUT$ldsSizePerLocalWorkGroup.byteSize();
    public static final long SIZE$ldsUsageSizeInBytes = NativeLayout.C_SIZE_T.byteSize();
    public static final long SIZE$scratchMemUsageInBytes = NativeLayout.C_SIZE_T.byteSize();

    public static final long OFFSET$numUsedVgprs = LAYOUT.byteOffset(PATH$numUsedVgprs);
    public static final long OFFSET$numUsedSgprs = LAYOUT.byteOffset(PATH$numUsedSgprs);
    public static final long OFFSET$ldsSizePerLocalWorkGroup = LAYOUT.byteOffset(PATH$ldsSizePerLocalWorkGroup);
    public static final long OFFSET$ldsUsageSizeInBytes = LAYOUT.byteOffset(PATH$ldsUsageSizeInBytes);
    public static final long OFFSET$scratchMemUsageInBytes = LAYOUT.byteOffset(PATH$scratchMemUsageInBytes);
}
