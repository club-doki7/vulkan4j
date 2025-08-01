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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCopyMemoryToAccelerationStructureInfoKHR.html"><code>VkCopyMemoryToAccelerationStructureInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkCopyMemoryToAccelerationStructureInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkDeviceOrHostAddressConstKHR src; // @link substring="VkDeviceOrHostAddressConstKHR" target="VkDeviceOrHostAddressConstKHR" @link substring="src" target="#src"
///     VkAccelerationStructureKHR dst; // @link substring="VkAccelerationStructureKHR" target="VkAccelerationStructureKHR" @link substring="dst" target="#dst"
///     VkCopyAccelerationStructureModeKHR mode; // @link substring="VkCopyAccelerationStructureModeKHR" target="VkCopyAccelerationStructureModeKHR" @link substring="mode" target="#mode"
/// } VkCopyMemoryToAccelerationStructureInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_COPY_MEMORY_TO_ACCELERATION_STRUCTURE_INFO_KHR`
///
/// The {@code allocate} ({@link VkCopyMemoryToAccelerationStructureInfoKHR#allocate(Arena)}, {@link VkCopyMemoryToAccelerationStructureInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkCopyMemoryToAccelerationStructureInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCopyMemoryToAccelerationStructureInfoKHR.html"><code>VkCopyMemoryToAccelerationStructureInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkCopyMemoryToAccelerationStructureInfoKHR(@NotNull MemorySegment segment) implements IVkCopyMemoryToAccelerationStructureInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCopyMemoryToAccelerationStructureInfoKHR.html"><code>VkCopyMemoryToAccelerationStructureInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkCopyMemoryToAccelerationStructureInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkCopyMemoryToAccelerationStructureInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkCopyMemoryToAccelerationStructureInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkCopyMemoryToAccelerationStructureInfoKHR, Iterable<VkCopyMemoryToAccelerationStructureInfoKHR> {
        public long size() {
            return segment.byteSize() / VkCopyMemoryToAccelerationStructureInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkCopyMemoryToAccelerationStructureInfoKHR at(long index) {
            return new VkCopyMemoryToAccelerationStructureInfoKHR(segment.asSlice(index * VkCopyMemoryToAccelerationStructureInfoKHR.BYTES, VkCopyMemoryToAccelerationStructureInfoKHR.BYTES));
        }

        public VkCopyMemoryToAccelerationStructureInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkCopyMemoryToAccelerationStructureInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkCopyMemoryToAccelerationStructureInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkCopyMemoryToAccelerationStructureInfoKHR.BYTES, VkCopyMemoryToAccelerationStructureInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkCopyMemoryToAccelerationStructureInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkCopyMemoryToAccelerationStructureInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkCopyMemoryToAccelerationStructureInfoKHR.BYTES,
                (end - start) * VkCopyMemoryToAccelerationStructureInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkCopyMemoryToAccelerationStructureInfoKHR.BYTES));
        }

        public VkCopyMemoryToAccelerationStructureInfoKHR[] toArray() {
            VkCopyMemoryToAccelerationStructureInfoKHR[] ret = new VkCopyMemoryToAccelerationStructureInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkCopyMemoryToAccelerationStructureInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkCopyMemoryToAccelerationStructureInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkCopyMemoryToAccelerationStructureInfoKHR.BYTES;
            }

            @Override
            public VkCopyMemoryToAccelerationStructureInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkCopyMemoryToAccelerationStructureInfoKHR ret = new VkCopyMemoryToAccelerationStructureInfoKHR(segment.asSlice(0, VkCopyMemoryToAccelerationStructureInfoKHR.BYTES));
                segment = segment.asSlice(VkCopyMemoryToAccelerationStructureInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkCopyMemoryToAccelerationStructureInfoKHR allocate(Arena arena) {
        VkCopyMemoryToAccelerationStructureInfoKHR ret = new VkCopyMemoryToAccelerationStructureInfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.COPY_MEMORY_TO_ACCELERATION_STRUCTURE_INFO_KHR);
        return ret;
    }

    public static VkCopyMemoryToAccelerationStructureInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkCopyMemoryToAccelerationStructureInfoKHR.Ptr ret = new VkCopyMemoryToAccelerationStructureInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.COPY_MEMORY_TO_ACCELERATION_STRUCTURE_INFO_KHR);
        }
        return ret;
    }

    public static VkCopyMemoryToAccelerationStructureInfoKHR clone(Arena arena, VkCopyMemoryToAccelerationStructureInfoKHR src) {
        VkCopyMemoryToAccelerationStructureInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.COPY_MEMORY_TO_ACCELERATION_STRUCTURE_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkCopyMemoryToAccelerationStructureInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkCopyMemoryToAccelerationStructureInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkCopyMemoryToAccelerationStructureInfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NotNull VkDeviceOrHostAddressConstKHR src() {
        return new VkDeviceOrHostAddressConstKHR(segment.asSlice(OFFSET$src, LAYOUT$src));
    }

    public VkCopyMemoryToAccelerationStructureInfoKHR src(@NotNull VkDeviceOrHostAddressConstKHR value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$src, SIZE$src);
        return this;
    }

    public VkCopyMemoryToAccelerationStructureInfoKHR src(Consumer<@NotNull VkDeviceOrHostAddressConstKHR> consumer) {
        consumer.accept(src());
        return this;
    }

    public @Nullable VkAccelerationStructureKHR dst() {
        MemorySegment s = segment.asSlice(OFFSET$dst, SIZE$dst);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkAccelerationStructureKHR(s);
    }

    public VkCopyMemoryToAccelerationStructureInfoKHR dst(@Nullable VkAccelerationStructureKHR value) {
        segment.set(LAYOUT$dst, OFFSET$dst, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @EnumType(VkCopyAccelerationStructureModeKHR.class) int mode() {
        return segment.get(LAYOUT$mode, OFFSET$mode);
    }

    public VkCopyMemoryToAccelerationStructureInfoKHR mode(@EnumType(VkCopyAccelerationStructureModeKHR.class) int value) {
        segment.set(LAYOUT$mode, OFFSET$mode, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        VkDeviceOrHostAddressConstKHR.LAYOUT.withName("src"),
        ValueLayout.ADDRESS.withName("dst"),
        ValueLayout.JAVA_INT.withName("mode")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$src = PathElement.groupElement("src");
    public static final PathElement PATH$dst = PathElement.groupElement("dst");
    public static final PathElement PATH$mode = PathElement.groupElement("mode");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final UnionLayout LAYOUT$src = (UnionLayout) LAYOUT.select(PATH$src);
    public static final AddressLayout LAYOUT$dst = (AddressLayout) LAYOUT.select(PATH$dst);
    public static final OfInt LAYOUT$mode = (OfInt) LAYOUT.select(PATH$mode);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$src = LAYOUT$src.byteSize();
    public static final long SIZE$dst = LAYOUT$dst.byteSize();
    public static final long SIZE$mode = LAYOUT$mode.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$src = LAYOUT.byteOffset(PATH$src);
    public static final long OFFSET$dst = LAYOUT.byteOffset(PATH$dst);
    public static final long OFFSET$mode = LAYOUT.byteOffset(PATH$mode);
}
