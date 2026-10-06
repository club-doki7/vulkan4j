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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageConstraintsInfoFUCHSIA.html"><code>VkImageConstraintsInfoFUCHSIA</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkImageConstraintsInfoFUCHSIA {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint32_t formatConstraintsCount; // @link substring="formatConstraintsCount" target="#formatConstraintsCount"
///     VkImageFormatConstraintsInfoFUCHSIA const* pFormatConstraints; // @link substring="VkImageFormatConstraintsInfoFUCHSIA" target="VkImageFormatConstraintsInfoFUCHSIA" @link substring="pFormatConstraints" target="#pFormatConstraints"
///     VkBufferCollectionConstraintsInfoFUCHSIA bufferCollectionConstraints; // @link substring="VkBufferCollectionConstraintsInfoFUCHSIA" target="VkBufferCollectionConstraintsInfoFUCHSIA" @link substring="bufferCollectionConstraints" target="#bufferCollectionConstraints"
///     VkImageConstraintsInfoFlagsFUCHSIA flags; // optional // @link substring="VkImageConstraintsInfoFlagsFUCHSIA" target="VkImageConstraintsInfoFlagsFUCHSIA" @link substring="flags" target="#flags"
/// } VkImageConstraintsInfoFUCHSIA;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_IMAGE_CONSTRAINTS_INFO_FUCHSIA`
/// - `bufferCollectionConstraints.autoInit()`
///
/// The {@code allocate} ({@link VkImageConstraintsInfoFUCHSIA#allocate(Arena)}, {@link VkImageConstraintsInfoFUCHSIA#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkImageConstraintsInfoFUCHSIA#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageConstraintsInfoFUCHSIA.html"><code>VkImageConstraintsInfoFUCHSIA</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkImageConstraintsInfoFUCHSIA(@NotNull MemorySegment segment) implements IVkImageConstraintsInfoFUCHSIA {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkImageConstraintsInfoFUCHSIA.html"><code>VkImageConstraintsInfoFUCHSIA</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkImageConstraintsInfoFUCHSIA}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkImageConstraintsInfoFUCHSIA to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkImageConstraintsInfoFUCHSIA.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkImageConstraintsInfoFUCHSIA, Iterable<VkImageConstraintsInfoFUCHSIA> {
        public long size() {
            return segment.byteSize() / VkImageConstraintsInfoFUCHSIA.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkImageConstraintsInfoFUCHSIA at(long index) {
            return new VkImageConstraintsInfoFUCHSIA(segment.asSlice(index * VkImageConstraintsInfoFUCHSIA.BYTES, VkImageConstraintsInfoFUCHSIA.BYTES));
        }

        public VkImageConstraintsInfoFUCHSIA.Ptr at(long index, @NotNull Consumer<@NotNull VkImageConstraintsInfoFUCHSIA> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkImageConstraintsInfoFUCHSIA value) {
            MemorySegment s = segment.asSlice(index * VkImageConstraintsInfoFUCHSIA.BYTES, VkImageConstraintsInfoFUCHSIA.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkImageConstraintsInfoFUCHSIA.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkImageConstraintsInfoFUCHSIA.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkImageConstraintsInfoFUCHSIA.BYTES,
                (end - start) * VkImageConstraintsInfoFUCHSIA.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkImageConstraintsInfoFUCHSIA.BYTES));
        }

        public VkImageConstraintsInfoFUCHSIA[] toArray() {
            VkImageConstraintsInfoFUCHSIA[] ret = new VkImageConstraintsInfoFUCHSIA[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkImageConstraintsInfoFUCHSIA> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkImageConstraintsInfoFUCHSIA> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkImageConstraintsInfoFUCHSIA.BYTES;
            }

            @Override
            public VkImageConstraintsInfoFUCHSIA next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkImageConstraintsInfoFUCHSIA ret = new VkImageConstraintsInfoFUCHSIA(segment.asSlice(0, VkImageConstraintsInfoFUCHSIA.BYTES));
                segment = segment.asSlice(VkImageConstraintsInfoFUCHSIA.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkImageConstraintsInfoFUCHSIA allocate(Arena arena) {
        VkImageConstraintsInfoFUCHSIA ret = new VkImageConstraintsInfoFUCHSIA(arena.allocate(LAYOUT));
        ret.autoInit();
        return ret;
    }

    public static VkImageConstraintsInfoFUCHSIA.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkImageConstraintsInfoFUCHSIA.Ptr ret = new VkImageConstraintsInfoFUCHSIA.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).autoInit();
        }
        return ret;
    }

    public static VkImageConstraintsInfoFUCHSIA clone(Arena arena, VkImageConstraintsInfoFUCHSIA src) {
        VkImageConstraintsInfoFUCHSIA ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.IMAGE_CONSTRAINTS_INFO_FUCHSIA);
        bufferCollectionConstraints().autoInit();
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkImageConstraintsInfoFUCHSIA sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkImageConstraintsInfoFUCHSIA pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkImageConstraintsInfoFUCHSIA pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int formatConstraintsCount() {
        return segment.get(LAYOUT$formatConstraintsCount, OFFSET$formatConstraintsCount);
    }

    public VkImageConstraintsInfoFUCHSIA formatConstraintsCount(@Unsigned int value) {
        segment.set(LAYOUT$formatConstraintsCount, OFFSET$formatConstraintsCount, value);
        return this;
    }

    public VkImageConstraintsInfoFUCHSIA pFormatConstraints(@Nullable IVkImageFormatConstraintsInfoFUCHSIA value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pFormatConstraintsRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkImageFormatConstraintsInfoFUCHSIA.Ptr pFormatConstraints(int assumedCount) {
        MemorySegment s = pFormatConstraintsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkImageFormatConstraintsInfoFUCHSIA.BYTES);
        return new VkImageFormatConstraintsInfoFUCHSIA.Ptr(s);
    }

    public @Nullable VkImageFormatConstraintsInfoFUCHSIA pFormatConstraints() {
        MemorySegment s = pFormatConstraintsRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkImageFormatConstraintsInfoFUCHSIA(s);
    }

    public @Pointer(target=VkImageFormatConstraintsInfoFUCHSIA.class) @NotNull MemorySegment pFormatConstraintsRaw() {
        return segment.get(LAYOUT$pFormatConstraints, OFFSET$pFormatConstraints);
    }

    public void pFormatConstraintsRaw(@Pointer(target=VkImageFormatConstraintsInfoFUCHSIA.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pFormatConstraints, OFFSET$pFormatConstraints, value);
    }

    public @NotNull VkBufferCollectionConstraintsInfoFUCHSIA bufferCollectionConstraints() {
        return new VkBufferCollectionConstraintsInfoFUCHSIA(segment.asSlice(OFFSET$bufferCollectionConstraints, LAYOUT$bufferCollectionConstraints));
    }

    public VkImageConstraintsInfoFUCHSIA bufferCollectionConstraints(@NotNull VkBufferCollectionConstraintsInfoFUCHSIA value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$bufferCollectionConstraints, SIZE$bufferCollectionConstraints);
        return this;
    }

    public VkImageConstraintsInfoFUCHSIA bufferCollectionConstraints(Consumer<@NotNull VkBufferCollectionConstraintsInfoFUCHSIA> consumer) {
        consumer.accept(bufferCollectionConstraints());
        return this;
    }

    public @Bitmask(VkImageConstraintsInfoFlagsFUCHSIA.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkImageConstraintsInfoFUCHSIA flags(@Bitmask(VkImageConstraintsInfoFlagsFUCHSIA.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("formatConstraintsCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkImageFormatConstraintsInfoFUCHSIA.LAYOUT).withName("pFormatConstraints"),
        VkBufferCollectionConstraintsInfoFUCHSIA.LAYOUT.withName("bufferCollectionConstraints"),
        ValueLayout.JAVA_INT.withName("flags")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$formatConstraintsCount = PathElement.groupElement("formatConstraintsCount");
    public static final PathElement PATH$pFormatConstraints = PathElement.groupElement("pFormatConstraints");
    public static final PathElement PATH$bufferCollectionConstraints = PathElement.groupElement("bufferCollectionConstraints");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$formatConstraintsCount = (OfInt) LAYOUT.select(PATH$formatConstraintsCount);
    public static final AddressLayout LAYOUT$pFormatConstraints = (AddressLayout) LAYOUT.select(PATH$pFormatConstraints);
    public static final StructLayout LAYOUT$bufferCollectionConstraints = (StructLayout) LAYOUT.select(PATH$bufferCollectionConstraints);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$formatConstraintsCount = LAYOUT$formatConstraintsCount.byteSize();
    public static final long SIZE$pFormatConstraints = LAYOUT$pFormatConstraints.byteSize();
    public static final long SIZE$bufferCollectionConstraints = LAYOUT$bufferCollectionConstraints.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$formatConstraintsCount = LAYOUT.byteOffset(PATH$formatConstraintsCount);
    public static final long OFFSET$pFormatConstraints = LAYOUT.byteOffset(PATH$pFormatConstraints);
    public static final long OFFSET$bufferCollectionConstraints = LAYOUT.byteOffset(PATH$bufferCollectionConstraints);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
}
