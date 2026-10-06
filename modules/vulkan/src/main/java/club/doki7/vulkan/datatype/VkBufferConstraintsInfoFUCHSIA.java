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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBufferConstraintsInfoFUCHSIA.html"><code>VkBufferConstraintsInfoFUCHSIA</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkBufferConstraintsInfoFUCHSIA {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBufferCreateInfo createInfo; // @link substring="VkBufferCreateInfo" target="VkBufferCreateInfo" @link substring="createInfo" target="#createInfo"
///     VkFormatFeatureFlags requiredFormatFeatures; // optional // @link substring="VkFormatFeatureFlags" target="VkFormatFeatureFlags" @link substring="requiredFormatFeatures" target="#requiredFormatFeatures"
///     VkBufferCollectionConstraintsInfoFUCHSIA bufferCollectionConstraints; // @link substring="VkBufferCollectionConstraintsInfoFUCHSIA" target="VkBufferCollectionConstraintsInfoFUCHSIA" @link substring="bufferCollectionConstraints" target="#bufferCollectionConstraints"
/// } VkBufferConstraintsInfoFUCHSIA;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_BUFFER_CONSTRAINTS_INFO_FUCHSIA`
/// - `createInfo.autoInit()`
/// - `bufferCollectionConstraints.autoInit()`
///
/// The {@code allocate} ({@link VkBufferConstraintsInfoFUCHSIA#allocate(Arena)}, {@link VkBufferConstraintsInfoFUCHSIA#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkBufferConstraintsInfoFUCHSIA#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBufferConstraintsInfoFUCHSIA.html"><code>VkBufferConstraintsInfoFUCHSIA</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkBufferConstraintsInfoFUCHSIA(@NotNull MemorySegment segment) implements IVkBufferConstraintsInfoFUCHSIA {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkBufferConstraintsInfoFUCHSIA.html"><code>VkBufferConstraintsInfoFUCHSIA</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkBufferConstraintsInfoFUCHSIA}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkBufferConstraintsInfoFUCHSIA to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkBufferConstraintsInfoFUCHSIA.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkBufferConstraintsInfoFUCHSIA, Iterable<VkBufferConstraintsInfoFUCHSIA> {
        public long size() {
            return segment.byteSize() / VkBufferConstraintsInfoFUCHSIA.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkBufferConstraintsInfoFUCHSIA at(long index) {
            return new VkBufferConstraintsInfoFUCHSIA(segment.asSlice(index * VkBufferConstraintsInfoFUCHSIA.BYTES, VkBufferConstraintsInfoFUCHSIA.BYTES));
        }

        public VkBufferConstraintsInfoFUCHSIA.Ptr at(long index, @NotNull Consumer<@NotNull VkBufferConstraintsInfoFUCHSIA> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkBufferConstraintsInfoFUCHSIA value) {
            MemorySegment s = segment.asSlice(index * VkBufferConstraintsInfoFUCHSIA.BYTES, VkBufferConstraintsInfoFUCHSIA.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkBufferConstraintsInfoFUCHSIA.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkBufferConstraintsInfoFUCHSIA.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkBufferConstraintsInfoFUCHSIA.BYTES,
                (end - start) * VkBufferConstraintsInfoFUCHSIA.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkBufferConstraintsInfoFUCHSIA.BYTES));
        }

        public VkBufferConstraintsInfoFUCHSIA[] toArray() {
            VkBufferConstraintsInfoFUCHSIA[] ret = new VkBufferConstraintsInfoFUCHSIA[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkBufferConstraintsInfoFUCHSIA> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkBufferConstraintsInfoFUCHSIA> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkBufferConstraintsInfoFUCHSIA.BYTES;
            }

            @Override
            public VkBufferConstraintsInfoFUCHSIA next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkBufferConstraintsInfoFUCHSIA ret = new VkBufferConstraintsInfoFUCHSIA(segment.asSlice(0, VkBufferConstraintsInfoFUCHSIA.BYTES));
                segment = segment.asSlice(VkBufferConstraintsInfoFUCHSIA.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkBufferConstraintsInfoFUCHSIA allocate(Arena arena) {
        VkBufferConstraintsInfoFUCHSIA ret = new VkBufferConstraintsInfoFUCHSIA(arena.allocate(LAYOUT));
        ret.autoInit();
        return ret;
    }

    public static VkBufferConstraintsInfoFUCHSIA.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkBufferConstraintsInfoFUCHSIA.Ptr ret = new VkBufferConstraintsInfoFUCHSIA.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).autoInit();
        }
        return ret;
    }

    public static VkBufferConstraintsInfoFUCHSIA clone(Arena arena, VkBufferConstraintsInfoFUCHSIA src) {
        VkBufferConstraintsInfoFUCHSIA ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.BUFFER_CONSTRAINTS_INFO_FUCHSIA);
        createInfo().autoInit();
        bufferCollectionConstraints().autoInit();
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkBufferConstraintsInfoFUCHSIA sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkBufferConstraintsInfoFUCHSIA pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkBufferConstraintsInfoFUCHSIA pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NotNull VkBufferCreateInfo createInfo() {
        return new VkBufferCreateInfo(segment.asSlice(OFFSET$createInfo, LAYOUT$createInfo));
    }

    public VkBufferConstraintsInfoFUCHSIA createInfo(@NotNull VkBufferCreateInfo value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$createInfo, SIZE$createInfo);
        return this;
    }

    public VkBufferConstraintsInfoFUCHSIA createInfo(Consumer<@NotNull VkBufferCreateInfo> consumer) {
        consumer.accept(createInfo());
        return this;
    }

    public @Bitmask(VkFormatFeatureFlags.class) int requiredFormatFeatures() {
        return segment.get(LAYOUT$requiredFormatFeatures, OFFSET$requiredFormatFeatures);
    }

    public VkBufferConstraintsInfoFUCHSIA requiredFormatFeatures(@Bitmask(VkFormatFeatureFlags.class) int value) {
        segment.set(LAYOUT$requiredFormatFeatures, OFFSET$requiredFormatFeatures, value);
        return this;
    }

    public @NotNull VkBufferCollectionConstraintsInfoFUCHSIA bufferCollectionConstraints() {
        return new VkBufferCollectionConstraintsInfoFUCHSIA(segment.asSlice(OFFSET$bufferCollectionConstraints, LAYOUT$bufferCollectionConstraints));
    }

    public VkBufferConstraintsInfoFUCHSIA bufferCollectionConstraints(@NotNull VkBufferCollectionConstraintsInfoFUCHSIA value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$bufferCollectionConstraints, SIZE$bufferCollectionConstraints);
        return this;
    }

    public VkBufferConstraintsInfoFUCHSIA bufferCollectionConstraints(Consumer<@NotNull VkBufferCollectionConstraintsInfoFUCHSIA> consumer) {
        consumer.accept(bufferCollectionConstraints());
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        VkBufferCreateInfo.LAYOUT.withName("createInfo"),
        ValueLayout.JAVA_INT.withName("requiredFormatFeatures"),
        VkBufferCollectionConstraintsInfoFUCHSIA.LAYOUT.withName("bufferCollectionConstraints")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$createInfo = PathElement.groupElement("createInfo");
    public static final PathElement PATH$requiredFormatFeatures = PathElement.groupElement("requiredFormatFeatures");
    public static final PathElement PATH$bufferCollectionConstraints = PathElement.groupElement("bufferCollectionConstraints");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final StructLayout LAYOUT$createInfo = (StructLayout) LAYOUT.select(PATH$createInfo);
    public static final OfInt LAYOUT$requiredFormatFeatures = (OfInt) LAYOUT.select(PATH$requiredFormatFeatures);
    public static final StructLayout LAYOUT$bufferCollectionConstraints = (StructLayout) LAYOUT.select(PATH$bufferCollectionConstraints);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$createInfo = LAYOUT$createInfo.byteSize();
    public static final long SIZE$requiredFormatFeatures = LAYOUT$requiredFormatFeatures.byteSize();
    public static final long SIZE$bufferCollectionConstraints = LAYOUT$bufferCollectionConstraints.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$createInfo = LAYOUT.byteOffset(PATH$createInfo);
    public static final long OFFSET$requiredFormatFeatures = LAYOUT.byteOffset(PATH$requiredFormatFeatures);
    public static final long OFFSET$bufferCollectionConstraints = LAYOUT.byteOffset(PATH$bufferCollectionConstraints);
}
