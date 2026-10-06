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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDirectDriverLoadingListLUNARG.html"><code>VkDirectDriverLoadingListLUNARG</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDirectDriverLoadingListLUNARG {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkDirectDriverLoadingModeLUNARG mode; // @link substring="VkDirectDriverLoadingModeLUNARG" target="VkDirectDriverLoadingModeLUNARG" @link substring="mode" target="#mode"
///     uint32_t driverCount; // @link substring="driverCount" target="#driverCount"
///     VkDirectDriverLoadingInfoLUNARG const* pDrivers; // @link substring="VkDirectDriverLoadingInfoLUNARG" target="VkDirectDriverLoadingInfoLUNARG" @link substring="pDrivers" target="#pDrivers"
/// } VkDirectDriverLoadingListLUNARG;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_DIRECT_DRIVER_LOADING_LIST_LUNARG`
///
/// The {@code allocate} ({@link VkDirectDriverLoadingListLUNARG#allocate(Arena)}, {@link VkDirectDriverLoadingListLUNARG#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkDirectDriverLoadingListLUNARG#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDirectDriverLoadingListLUNARG.html"><code>VkDirectDriverLoadingListLUNARG</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDirectDriverLoadingListLUNARG(@NotNull MemorySegment segment) implements IVkDirectDriverLoadingListLUNARG {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDirectDriverLoadingListLUNARG.html"><code>VkDirectDriverLoadingListLUNARG</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDirectDriverLoadingListLUNARG}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDirectDriverLoadingListLUNARG to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDirectDriverLoadingListLUNARG.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDirectDriverLoadingListLUNARG, Iterable<VkDirectDriverLoadingListLUNARG> {
        public long size() {
            return segment.byteSize() / VkDirectDriverLoadingListLUNARG.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDirectDriverLoadingListLUNARG at(long index) {
            return new VkDirectDriverLoadingListLUNARG(segment.asSlice(index * VkDirectDriverLoadingListLUNARG.BYTES, VkDirectDriverLoadingListLUNARG.BYTES));
        }

        public VkDirectDriverLoadingListLUNARG.Ptr at(long index, @NotNull Consumer<@NotNull VkDirectDriverLoadingListLUNARG> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDirectDriverLoadingListLUNARG value) {
            MemorySegment s = segment.asSlice(index * VkDirectDriverLoadingListLUNARG.BYTES, VkDirectDriverLoadingListLUNARG.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDirectDriverLoadingListLUNARG.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDirectDriverLoadingListLUNARG.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDirectDriverLoadingListLUNARG.BYTES,
                (end - start) * VkDirectDriverLoadingListLUNARG.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDirectDriverLoadingListLUNARG.BYTES));
        }

        public VkDirectDriverLoadingListLUNARG[] toArray() {
            VkDirectDriverLoadingListLUNARG[] ret = new VkDirectDriverLoadingListLUNARG[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDirectDriverLoadingListLUNARG> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDirectDriverLoadingListLUNARG> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDirectDriverLoadingListLUNARG.BYTES;
            }

            @Override
            public VkDirectDriverLoadingListLUNARG next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDirectDriverLoadingListLUNARG ret = new VkDirectDriverLoadingListLUNARG(segment.asSlice(0, VkDirectDriverLoadingListLUNARG.BYTES));
                segment = segment.asSlice(VkDirectDriverLoadingListLUNARG.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDirectDriverLoadingListLUNARG allocate(Arena arena) {
        VkDirectDriverLoadingListLUNARG ret = new VkDirectDriverLoadingListLUNARG(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.DIRECT_DRIVER_LOADING_LIST_LUNARG);
        return ret;
    }

    public static VkDirectDriverLoadingListLUNARG.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkDirectDriverLoadingListLUNARG.Ptr ret = new VkDirectDriverLoadingListLUNARG.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.DIRECT_DRIVER_LOADING_LIST_LUNARG);
        }
        return ret;
    }

    public static VkDirectDriverLoadingListLUNARG clone(Arena arena, VkDirectDriverLoadingListLUNARG src) {
        VkDirectDriverLoadingListLUNARG ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.DIRECT_DRIVER_LOADING_LIST_LUNARG);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkDirectDriverLoadingListLUNARG sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkDirectDriverLoadingListLUNARG pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkDirectDriverLoadingListLUNARG pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @EnumType(VkDirectDriverLoadingModeLUNARG.class) int mode() {
        return segment.get(LAYOUT$mode, OFFSET$mode);
    }

    public VkDirectDriverLoadingListLUNARG mode(@EnumType(VkDirectDriverLoadingModeLUNARG.class) int value) {
        segment.set(LAYOUT$mode, OFFSET$mode, value);
        return this;
    }

    public @Unsigned int driverCount() {
        return segment.get(LAYOUT$driverCount, OFFSET$driverCount);
    }

    public VkDirectDriverLoadingListLUNARG driverCount(@Unsigned int value) {
        segment.set(LAYOUT$driverCount, OFFSET$driverCount, value);
        return this;
    }

    public VkDirectDriverLoadingListLUNARG pDrivers(@Nullable IVkDirectDriverLoadingInfoLUNARG value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pDriversRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkDirectDriverLoadingInfoLUNARG.Ptr pDrivers(int assumedCount) {
        MemorySegment s = pDriversRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkDirectDriverLoadingInfoLUNARG.BYTES);
        return new VkDirectDriverLoadingInfoLUNARG.Ptr(s);
    }

    public @Nullable VkDirectDriverLoadingInfoLUNARG pDrivers() {
        MemorySegment s = pDriversRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkDirectDriverLoadingInfoLUNARG(s);
    }

    public @Pointer(target=VkDirectDriverLoadingInfoLUNARG.class) @NotNull MemorySegment pDriversRaw() {
        return segment.get(LAYOUT$pDrivers, OFFSET$pDrivers);
    }

    public void pDriversRaw(@Pointer(target=VkDirectDriverLoadingInfoLUNARG.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pDrivers, OFFSET$pDrivers, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("mode"),
        ValueLayout.JAVA_INT.withName("driverCount"),
        ValueLayout.ADDRESS.withTargetLayout(VkDirectDriverLoadingInfoLUNARG.LAYOUT).withName("pDrivers")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$mode = PathElement.groupElement("mode");
    public static final PathElement PATH$driverCount = PathElement.groupElement("driverCount");
    public static final PathElement PATH$pDrivers = PathElement.groupElement("pDrivers");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$mode = (OfInt) LAYOUT.select(PATH$mode);
    public static final OfInt LAYOUT$driverCount = (OfInt) LAYOUT.select(PATH$driverCount);
    public static final AddressLayout LAYOUT$pDrivers = (AddressLayout) LAYOUT.select(PATH$pDrivers);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$mode = LAYOUT$mode.byteSize();
    public static final long SIZE$driverCount = LAYOUT$driverCount.byteSize();
    public static final long SIZE$pDrivers = LAYOUT$pDrivers.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$mode = LAYOUT.byteOffset(PATH$mode);
    public static final long OFFSET$driverCount = LAYOUT.byteOffset(PATH$driverCount);
    public static final long OFFSET$pDrivers = LAYOUT.byteOffset(PATH$pDrivers);
}
