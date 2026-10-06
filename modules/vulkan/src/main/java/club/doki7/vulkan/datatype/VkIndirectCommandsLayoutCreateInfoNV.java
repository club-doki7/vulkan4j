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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkIndirectCommandsLayoutCreateInfoNV.html"><code>VkIndirectCommandsLayoutCreateInfoNV</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkIndirectCommandsLayoutCreateInfoNV {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkIndirectCommandsLayoutUsageFlagsNV flags; // optional // @link substring="VkIndirectCommandsLayoutUsageFlagsNV" target="VkIndirectCommandsLayoutUsageFlagsNV" @link substring="flags" target="#flags"
///     VkPipelineBindPoint pipelineBindPoint; // @link substring="VkPipelineBindPoint" target="VkPipelineBindPoint" @link substring="pipelineBindPoint" target="#pipelineBindPoint"
///     uint32_t tokenCount; // @link substring="tokenCount" target="#tokenCount"
///     VkIndirectCommandsLayoutTokenNV const* pTokens; // @link substring="VkIndirectCommandsLayoutTokenNV" target="VkIndirectCommandsLayoutTokenNV" @link substring="pTokens" target="#pTokens"
///     uint32_t streamCount; // @link substring="streamCount" target="#streamCount"
///     uint32_t const* pStreamStrides; // @link substring="pStreamStrides" target="#pStreamStrides"
/// } VkIndirectCommandsLayoutCreateInfoNV;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_INDIRECT_COMMANDS_LAYOUT_CREATE_INFO_NV`
///
/// The {@code allocate} ({@link VkIndirectCommandsLayoutCreateInfoNV#allocate(Arena)}, {@link VkIndirectCommandsLayoutCreateInfoNV#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkIndirectCommandsLayoutCreateInfoNV#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkIndirectCommandsLayoutCreateInfoNV.html"><code>VkIndirectCommandsLayoutCreateInfoNV</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkIndirectCommandsLayoutCreateInfoNV(@NotNull MemorySegment segment) implements IVkIndirectCommandsLayoutCreateInfoNV {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkIndirectCommandsLayoutCreateInfoNV.html"><code>VkIndirectCommandsLayoutCreateInfoNV</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkIndirectCommandsLayoutCreateInfoNV}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkIndirectCommandsLayoutCreateInfoNV to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkIndirectCommandsLayoutCreateInfoNV.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkIndirectCommandsLayoutCreateInfoNV, Iterable<VkIndirectCommandsLayoutCreateInfoNV> {
        public long size() {
            return segment.byteSize() / VkIndirectCommandsLayoutCreateInfoNV.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkIndirectCommandsLayoutCreateInfoNV at(long index) {
            return new VkIndirectCommandsLayoutCreateInfoNV(segment.asSlice(index * VkIndirectCommandsLayoutCreateInfoNV.BYTES, VkIndirectCommandsLayoutCreateInfoNV.BYTES));
        }

        public VkIndirectCommandsLayoutCreateInfoNV.Ptr at(long index, @NotNull Consumer<@NotNull VkIndirectCommandsLayoutCreateInfoNV> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkIndirectCommandsLayoutCreateInfoNV value) {
            MemorySegment s = segment.asSlice(index * VkIndirectCommandsLayoutCreateInfoNV.BYTES, VkIndirectCommandsLayoutCreateInfoNV.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkIndirectCommandsLayoutCreateInfoNV.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkIndirectCommandsLayoutCreateInfoNV.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkIndirectCommandsLayoutCreateInfoNV.BYTES,
                (end - start) * VkIndirectCommandsLayoutCreateInfoNV.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkIndirectCommandsLayoutCreateInfoNV.BYTES));
        }

        public VkIndirectCommandsLayoutCreateInfoNV[] toArray() {
            VkIndirectCommandsLayoutCreateInfoNV[] ret = new VkIndirectCommandsLayoutCreateInfoNV[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkIndirectCommandsLayoutCreateInfoNV> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkIndirectCommandsLayoutCreateInfoNV> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkIndirectCommandsLayoutCreateInfoNV.BYTES;
            }

            @Override
            public VkIndirectCommandsLayoutCreateInfoNV next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkIndirectCommandsLayoutCreateInfoNV ret = new VkIndirectCommandsLayoutCreateInfoNV(segment.asSlice(0, VkIndirectCommandsLayoutCreateInfoNV.BYTES));
                segment = segment.asSlice(VkIndirectCommandsLayoutCreateInfoNV.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkIndirectCommandsLayoutCreateInfoNV allocate(Arena arena) {
        VkIndirectCommandsLayoutCreateInfoNV ret = new VkIndirectCommandsLayoutCreateInfoNV(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.INDIRECT_COMMANDS_LAYOUT_CREATE_INFO_NV);
        return ret;
    }

    public static VkIndirectCommandsLayoutCreateInfoNV.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkIndirectCommandsLayoutCreateInfoNV.Ptr ret = new VkIndirectCommandsLayoutCreateInfoNV.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.INDIRECT_COMMANDS_LAYOUT_CREATE_INFO_NV);
        }
        return ret;
    }

    public static VkIndirectCommandsLayoutCreateInfoNV clone(Arena arena, VkIndirectCommandsLayoutCreateInfoNV src) {
        VkIndirectCommandsLayoutCreateInfoNV ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.INDIRECT_COMMANDS_LAYOUT_CREATE_INFO_NV);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkIndirectCommandsLayoutCreateInfoNV sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkIndirectCommandsLayoutCreateInfoNV pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkIndirectCommandsLayoutCreateInfoNV pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkIndirectCommandsLayoutUsageFlagsNV.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkIndirectCommandsLayoutCreateInfoNV flags(@Bitmask(VkIndirectCommandsLayoutUsageFlagsNV.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @EnumType(VkPipelineBindPoint.class) int pipelineBindPoint() {
        return segment.get(LAYOUT$pipelineBindPoint, OFFSET$pipelineBindPoint);
    }

    public VkIndirectCommandsLayoutCreateInfoNV pipelineBindPoint(@EnumType(VkPipelineBindPoint.class) int value) {
        segment.set(LAYOUT$pipelineBindPoint, OFFSET$pipelineBindPoint, value);
        return this;
    }

    public @Unsigned int tokenCount() {
        return segment.get(LAYOUT$tokenCount, OFFSET$tokenCount);
    }

    public VkIndirectCommandsLayoutCreateInfoNV tokenCount(@Unsigned int value) {
        segment.set(LAYOUT$tokenCount, OFFSET$tokenCount, value);
        return this;
    }

    public VkIndirectCommandsLayoutCreateInfoNV pTokens(@Nullable IVkIndirectCommandsLayoutTokenNV value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pTokensRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkIndirectCommandsLayoutTokenNV.Ptr pTokens(int assumedCount) {
        MemorySegment s = pTokensRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkIndirectCommandsLayoutTokenNV.BYTES);
        return new VkIndirectCommandsLayoutTokenNV.Ptr(s);
    }

    public @Nullable VkIndirectCommandsLayoutTokenNV pTokens() {
        MemorySegment s = pTokensRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkIndirectCommandsLayoutTokenNV(s);
    }

    public @Pointer(target=VkIndirectCommandsLayoutTokenNV.class) @NotNull MemorySegment pTokensRaw() {
        return segment.get(LAYOUT$pTokens, OFFSET$pTokens);
    }

    public void pTokensRaw(@Pointer(target=VkIndirectCommandsLayoutTokenNV.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pTokens, OFFSET$pTokens, value);
    }

    public @Unsigned int streamCount() {
        return segment.get(LAYOUT$streamCount, OFFSET$streamCount);
    }

    public VkIndirectCommandsLayoutCreateInfoNV streamCount(@Unsigned int value) {
        segment.set(LAYOUT$streamCount, OFFSET$streamCount, value);
        return this;
    }

    /// Note: the returned {@link IntPtr} does not have correct
    /// {@link IntPtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link IntPtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable @Unsigned IntPtr pStreamStrides() {
        MemorySegment s = pStreamStridesRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new IntPtr(s);
    }

    public VkIndirectCommandsLayoutCreateInfoNV pStreamStrides(@Nullable @Unsigned IntPtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pStreamStridesRaw(s);
        return this;
    }

    public @Pointer(comment="uint32_t*") @NotNull MemorySegment pStreamStridesRaw() {
        return segment.get(LAYOUT$pStreamStrides, OFFSET$pStreamStrides);
    }

    public void pStreamStridesRaw(@Pointer(comment="uint32_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pStreamStrides, OFFSET$pStreamStrides, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("pipelineBindPoint"),
        ValueLayout.JAVA_INT.withName("tokenCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkIndirectCommandsLayoutTokenNV.LAYOUT).withName("pTokens"),
        ValueLayout.JAVA_INT.withName("streamCount"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_INT).withName("pStreamStrides")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$pipelineBindPoint = PathElement.groupElement("pipelineBindPoint");
    public static final PathElement PATH$tokenCount = PathElement.groupElement("tokenCount");
    public static final PathElement PATH$pTokens = PathElement.groupElement("pTokens");
    public static final PathElement PATH$streamCount = PathElement.groupElement("streamCount");
    public static final PathElement PATH$pStreamStrides = PathElement.groupElement("pStreamStrides");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$pipelineBindPoint = (OfInt) LAYOUT.select(PATH$pipelineBindPoint);
    public static final OfInt LAYOUT$tokenCount = (OfInt) LAYOUT.select(PATH$tokenCount);
    public static final AddressLayout LAYOUT$pTokens = (AddressLayout) LAYOUT.select(PATH$pTokens);
    public static final OfInt LAYOUT$streamCount = (OfInt) LAYOUT.select(PATH$streamCount);
    public static final AddressLayout LAYOUT$pStreamStrides = (AddressLayout) LAYOUT.select(PATH$pStreamStrides);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$pipelineBindPoint = LAYOUT$pipelineBindPoint.byteSize();
    public static final long SIZE$tokenCount = LAYOUT$tokenCount.byteSize();
    public static final long SIZE$pTokens = LAYOUT$pTokens.byteSize();
    public static final long SIZE$streamCount = LAYOUT$streamCount.byteSize();
    public static final long SIZE$pStreamStrides = LAYOUT$pStreamStrides.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$pipelineBindPoint = LAYOUT.byteOffset(PATH$pipelineBindPoint);
    public static final long OFFSET$tokenCount = LAYOUT.byteOffset(PATH$tokenCount);
    public static final long OFFSET$pTokens = LAYOUT.byteOffset(PATH$pTokens);
    public static final long OFFSET$streamCount = LAYOUT.byteOffset(PATH$streamCount);
    public static final long OFFSET$pStreamStrides = LAYOUT.byteOffset(PATH$pStreamStrides);
}
