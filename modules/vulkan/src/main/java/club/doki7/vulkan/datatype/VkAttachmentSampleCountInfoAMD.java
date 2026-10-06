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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAttachmentSampleCountInfoAMD.html"><code>VkAttachmentSampleCountInfoAMD</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkAttachmentSampleCountInfoAMD {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t colorAttachmentCount; // optional // @link substring="colorAttachmentCount" target="#colorAttachmentCount"
///     VkSampleCountFlags const* pColorAttachmentSamples; // optional // @link substring="VkSampleCountFlags" target="VkSampleCountFlags" @link substring="pColorAttachmentSamples" target="#pColorAttachmentSamples"
///     VkSampleCountFlags depthStencilAttachmentSamples; // optional // @link substring="VkSampleCountFlags" target="VkSampleCountFlags" @link substring="depthStencilAttachmentSamples" target="#depthStencilAttachmentSamples"
/// } VkAttachmentSampleCountInfoAMD;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_ATTACHMENT_SAMPLE_COUNT_INFO_AMD`
///
/// The {@code allocate} ({@link VkAttachmentSampleCountInfoAMD#allocate(Arena)}, {@link VkAttachmentSampleCountInfoAMD#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkAttachmentSampleCountInfoAMD#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAttachmentSampleCountInfoAMD.html"><code>VkAttachmentSampleCountInfoAMD</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkAttachmentSampleCountInfoAMD(@NotNull MemorySegment segment) implements IVkAttachmentSampleCountInfoAMD {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkAttachmentSampleCountInfoAMD.html"><code>VkAttachmentSampleCountInfoAMD</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkAttachmentSampleCountInfoAMD}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkAttachmentSampleCountInfoAMD to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkAttachmentSampleCountInfoAMD.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkAttachmentSampleCountInfoAMD, Iterable<VkAttachmentSampleCountInfoAMD> {
        public long size() {
            return segment.byteSize() / VkAttachmentSampleCountInfoAMD.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkAttachmentSampleCountInfoAMD at(long index) {
            return new VkAttachmentSampleCountInfoAMD(segment.asSlice(index * VkAttachmentSampleCountInfoAMD.BYTES, VkAttachmentSampleCountInfoAMD.BYTES));
        }

        public VkAttachmentSampleCountInfoAMD.Ptr at(long index, @NotNull Consumer<@NotNull VkAttachmentSampleCountInfoAMD> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkAttachmentSampleCountInfoAMD value) {
            MemorySegment s = segment.asSlice(index * VkAttachmentSampleCountInfoAMD.BYTES, VkAttachmentSampleCountInfoAMD.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkAttachmentSampleCountInfoAMD.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkAttachmentSampleCountInfoAMD.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkAttachmentSampleCountInfoAMD.BYTES,
                (end - start) * VkAttachmentSampleCountInfoAMD.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkAttachmentSampleCountInfoAMD.BYTES));
        }

        public VkAttachmentSampleCountInfoAMD[] toArray() {
            VkAttachmentSampleCountInfoAMD[] ret = new VkAttachmentSampleCountInfoAMD[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkAttachmentSampleCountInfoAMD> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkAttachmentSampleCountInfoAMD> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkAttachmentSampleCountInfoAMD.BYTES;
            }

            @Override
            public VkAttachmentSampleCountInfoAMD next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkAttachmentSampleCountInfoAMD ret = new VkAttachmentSampleCountInfoAMD(segment.asSlice(0, VkAttachmentSampleCountInfoAMD.BYTES));
                segment = segment.asSlice(VkAttachmentSampleCountInfoAMD.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkAttachmentSampleCountInfoAMD allocate(Arena arena) {
        VkAttachmentSampleCountInfoAMD ret = new VkAttachmentSampleCountInfoAMD(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.ATTACHMENT_SAMPLE_COUNT_INFO_AMD);
        return ret;
    }

    public static VkAttachmentSampleCountInfoAMD.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkAttachmentSampleCountInfoAMD.Ptr ret = new VkAttachmentSampleCountInfoAMD.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.ATTACHMENT_SAMPLE_COUNT_INFO_AMD);
        }
        return ret;
    }

    public static VkAttachmentSampleCountInfoAMD clone(Arena arena, VkAttachmentSampleCountInfoAMD src) {
        VkAttachmentSampleCountInfoAMD ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.ATTACHMENT_SAMPLE_COUNT_INFO_AMD);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkAttachmentSampleCountInfoAMD sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkAttachmentSampleCountInfoAMD pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkAttachmentSampleCountInfoAMD pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int colorAttachmentCount() {
        return segment.get(LAYOUT$colorAttachmentCount, OFFSET$colorAttachmentCount);
    }

    public VkAttachmentSampleCountInfoAMD colorAttachmentCount(@Unsigned int value) {
        segment.set(LAYOUT$colorAttachmentCount, OFFSET$colorAttachmentCount, value);
        return this;
    }


    /// Note: the returned {@link IntPtr} does not have correct
    /// {@link IntPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link IntPtr#reinterpret} to set the size before actually reading fro
    /// or writing to the buffer.
    public @Nullable @Bitmask(VkSampleCountFlags.class) IntPtr pColorAttachmentSamples() {
        MemorySegment s = pColorAttachmentSamplesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new IntPtr(s);
    }

    public VkAttachmentSampleCountInfoAMD pColorAttachmentSamples(@Nullable @Bitmask(VkSampleCountFlags.class) IntPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pColorAttachmentSamplesRaw(s);
        return this;
    }

    public @Pointer(target=VkSampleCountFlags.class) @NotNull MemorySegment pColorAttachmentSamplesRaw() {
        return segment.get(LAYOUT$pColorAttachmentSamples, OFFSET$pColorAttachmentSamples);
    }

    public void pColorAttachmentSamplesRaw(@Pointer(target=VkSampleCountFlags.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pColorAttachmentSamples, OFFSET$pColorAttachmentSamples, value);
    }

    public @Bitmask(VkSampleCountFlags.class) int depthStencilAttachmentSamples() {
        return segment.get(LAYOUT$depthStencilAttachmentSamples, OFFSET$depthStencilAttachmentSamples);
    }

    public VkAttachmentSampleCountInfoAMD depthStencilAttachmentSamples(@Bitmask(VkSampleCountFlags.class) int value) {
        segment.set(LAYOUT$depthStencilAttachmentSamples, OFFSET$depthStencilAttachmentSamples, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("colorAttachmentCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pColorAttachmentSamples"),
        ValueLayout.JAVA_INT.withName("depthStencilAttachmentSamples")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$colorAttachmentCount = PathElement.groupElement("colorAttachmentCount");
    public static final PathElement PATH$pColorAttachmentSamples = PathElement.groupElement("pColorAttachmentSamples");
    public static final PathElement PATH$depthStencilAttachmentSamples = PathElement.groupElement("depthStencilAttachmentSamples");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$colorAttachmentCount = (OfInt) LAYOUT.select(PATH$colorAttachmentCount);
    public static final AddressLayout LAYOUT$pColorAttachmentSamples = (AddressLayout) LAYOUT.select(PATH$pColorAttachmentSamples);
    public static final OfInt LAYOUT$depthStencilAttachmentSamples = (OfInt) LAYOUT.select(PATH$depthStencilAttachmentSamples);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$colorAttachmentCount = LAYOUT$colorAttachmentCount.byteSize();
    public static final long SIZE$pColorAttachmentSamples = LAYOUT$pColorAttachmentSamples.byteSize();
    public static final long SIZE$depthStencilAttachmentSamples = LAYOUT$depthStencilAttachmentSamples.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$colorAttachmentCount = LAYOUT.byteOffset(PATH$colorAttachmentCount);
    public static final long OFFSET$pColorAttachmentSamples = LAYOUT.byteOffset(PATH$pColorAttachmentSamples);
    public static final long OFFSET$depthStencilAttachmentSamples = LAYOUT.byteOffset(PATH$depthStencilAttachmentSamples);
}
