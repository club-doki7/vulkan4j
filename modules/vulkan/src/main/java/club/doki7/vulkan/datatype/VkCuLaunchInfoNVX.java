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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCuLaunchInfoNVX.html"><code>VkCuLaunchInfoNVX</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkCuLaunchInfoNVX {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkCuFunctionNVX function; // @link substring="VkCuFunctionNVX" target="VkCuFunctionNVX" @link substring="function" target="#function"
///     uint32_t gridDimX; // @link substring="gridDimX" target="#gridDimX"
///     uint32_t gridDimY; // @link substring="gridDimY" target="#gridDimY"
///     uint32_t gridDimZ; // @link substring="gridDimZ" target="#gridDimZ"
///     uint32_t blockDimX; // @link substring="blockDimX" target="#blockDimX"
///     uint32_t blockDimY; // @link substring="blockDimY" target="#blockDimY"
///     uint32_t blockDimZ; // @link substring="blockDimZ" target="#blockDimZ"
///     uint32_t sharedMemBytes; // @link substring="sharedMemBytes" target="#sharedMemBytes"
///     size_t paramCount; // optional // @link substring="paramCount" target="#paramCount"
///     void const* pParams; // optional // @link substring="pParams" target="#pParams"
///     size_t extraCount; // optional // @link substring="extraCount" target="#extraCount"
///     void const* pExtras; // optional // @link substring="pExtras" target="#pExtras"
/// } VkCuLaunchInfoNVX;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_CU_LAUNCH_INFO_NVX`
///
/// The {@code allocate} ({@link VkCuLaunchInfoNVX#allocate(Arena)}, {@link VkCuLaunchInfoNVX#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkCuLaunchInfoNVX#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCuLaunchInfoNVX.html"><code>VkCuLaunchInfoNVX</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkCuLaunchInfoNVX(@NotNull MemorySegment segment) implements IVkCuLaunchInfoNVX {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCuLaunchInfoNVX.html"><code>VkCuLaunchInfoNVX</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkCuLaunchInfoNVX}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkCuLaunchInfoNVX to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkCuLaunchInfoNVX.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkCuLaunchInfoNVX, Iterable<VkCuLaunchInfoNVX> {
        public long size() {
            return segment.byteSize() / VkCuLaunchInfoNVX.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkCuLaunchInfoNVX at(long index) {
            return new VkCuLaunchInfoNVX(segment.asSlice(index * VkCuLaunchInfoNVX.BYTES, VkCuLaunchInfoNVX.BYTES));
        }

        public VkCuLaunchInfoNVX.Ptr at(long index, @NotNull Consumer<@NotNull VkCuLaunchInfoNVX> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkCuLaunchInfoNVX value) {
            MemorySegment s = segment.asSlice(index * VkCuLaunchInfoNVX.BYTES, VkCuLaunchInfoNVX.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkCuLaunchInfoNVX.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkCuLaunchInfoNVX.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkCuLaunchInfoNVX.BYTES,
                (end - start) * VkCuLaunchInfoNVX.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkCuLaunchInfoNVX.BYTES));
        }

        public VkCuLaunchInfoNVX[] toArray() {
            VkCuLaunchInfoNVX[] ret = new VkCuLaunchInfoNVX[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkCuLaunchInfoNVX> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkCuLaunchInfoNVX> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkCuLaunchInfoNVX.BYTES;
            }

            @Override
            public VkCuLaunchInfoNVX next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkCuLaunchInfoNVX ret = new VkCuLaunchInfoNVX(segment.asSlice(0, VkCuLaunchInfoNVX.BYTES));
                segment = segment.asSlice(VkCuLaunchInfoNVX.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkCuLaunchInfoNVX allocate(Arena arena) {
        VkCuLaunchInfoNVX ret = new VkCuLaunchInfoNVX(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.CU_LAUNCH_INFO_NVX);
        return ret;
    }

    public static VkCuLaunchInfoNVX.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkCuLaunchInfoNVX.Ptr ret = new VkCuLaunchInfoNVX.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.CU_LAUNCH_INFO_NVX);
        }
        return ret;
    }

    public static VkCuLaunchInfoNVX clone(Arena arena, VkCuLaunchInfoNVX src) {
        VkCuLaunchInfoNVX ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.CU_LAUNCH_INFO_NVX);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkCuLaunchInfoNVX sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkCuLaunchInfoNVX pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkCuLaunchInfoNVX pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Nullable VkCuFunctionNVX function() {
        MemorySegment s = segment.asSlice(OFFSET$function, SIZE$function);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkCuFunctionNVX(s);
    }

    public VkCuLaunchInfoNVX function(@Nullable VkCuFunctionNVX value) {
        segment.set(LAYOUT$function, OFFSET$function, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned int gridDimX() {
        return segment.get(LAYOUT$gridDimX, OFFSET$gridDimX);
    }

    public VkCuLaunchInfoNVX gridDimX(@Unsigned int value) {
        segment.set(LAYOUT$gridDimX, OFFSET$gridDimX, value);
        return this;
    }

    public @Unsigned int gridDimY() {
        return segment.get(LAYOUT$gridDimY, OFFSET$gridDimY);
    }

    public VkCuLaunchInfoNVX gridDimY(@Unsigned int value) {
        segment.set(LAYOUT$gridDimY, OFFSET$gridDimY, value);
        return this;
    }

    public @Unsigned int gridDimZ() {
        return segment.get(LAYOUT$gridDimZ, OFFSET$gridDimZ);
    }

    public VkCuLaunchInfoNVX gridDimZ(@Unsigned int value) {
        segment.set(LAYOUT$gridDimZ, OFFSET$gridDimZ, value);
        return this;
    }

    public @Unsigned int blockDimX() {
        return segment.get(LAYOUT$blockDimX, OFFSET$blockDimX);
    }

    public VkCuLaunchInfoNVX blockDimX(@Unsigned int value) {
        segment.set(LAYOUT$blockDimX, OFFSET$blockDimX, value);
        return this;
    }

    public @Unsigned int blockDimY() {
        return segment.get(LAYOUT$blockDimY, OFFSET$blockDimY);
    }

    public VkCuLaunchInfoNVX blockDimY(@Unsigned int value) {
        segment.set(LAYOUT$blockDimY, OFFSET$blockDimY, value);
        return this;
    }

    public @Unsigned int blockDimZ() {
        return segment.get(LAYOUT$blockDimZ, OFFSET$blockDimZ);
    }

    public VkCuLaunchInfoNVX blockDimZ(@Unsigned int value) {
        segment.set(LAYOUT$blockDimZ, OFFSET$blockDimZ, value);
        return this;
    }

    public @Unsigned int sharedMemBytes() {
        return segment.get(LAYOUT$sharedMemBytes, OFFSET$sharedMemBytes);
    }

    public VkCuLaunchInfoNVX sharedMemBytes(@Unsigned int value) {
        segment.set(LAYOUT$sharedMemBytes, OFFSET$sharedMemBytes, value);
        return this;
    }

    public @Unsigned long paramCount() {
        return NativeLayout.readCSizeT(segment, OFFSET$paramCount);
    }

    public VkCuLaunchInfoNVX paramCount(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$paramCount, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pParams() {
        return segment.get(LAYOUT$pParams, OFFSET$pParams);
    }

    public VkCuLaunchInfoNVX pParams(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pParams, OFFSET$pParams, value);
        return this;
    }

    public VkCuLaunchInfoNVX pParams(@Nullable IPointer pointer) {
        pParams(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned long extraCount() {
        return NativeLayout.readCSizeT(segment, OFFSET$extraCount);
    }

    public VkCuLaunchInfoNVX extraCount(@Unsigned long value) {
        NativeLayout.writeCSizeT(segment, OFFSET$extraCount, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pExtras() {
        return segment.get(LAYOUT$pExtras, OFFSET$pExtras);
    }

    public VkCuLaunchInfoNVX pExtras(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pExtras, OFFSET$pExtras, value);
        return this;
    }

    public VkCuLaunchInfoNVX pExtras(@Nullable IPointer pointer) {
        pExtras(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withName("function"),
        ValueLayout.JAVA_INT.withName("gridDimX"),
        ValueLayout.JAVA_INT.withName("gridDimY"),
        ValueLayout.JAVA_INT.withName("gridDimZ"),
        ValueLayout.JAVA_INT.withName("blockDimX"),
        ValueLayout.JAVA_INT.withName("blockDimY"),
        ValueLayout.JAVA_INT.withName("blockDimZ"),
        ValueLayout.JAVA_INT.withName("sharedMemBytes"),
        NativeLayout.C_SIZE_T.withName("paramCount"),
        ValueLayout.ADDRESS.withName("pParams"),
        NativeLayout.C_SIZE_T.withName("extraCount"),
        ValueLayout.ADDRESS.withName("pExtras")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$function = PathElement.groupElement("function");
    public static final PathElement PATH$gridDimX = PathElement.groupElement("gridDimX");
    public static final PathElement PATH$gridDimY = PathElement.groupElement("gridDimY");
    public static final PathElement PATH$gridDimZ = PathElement.groupElement("gridDimZ");
    public static final PathElement PATH$blockDimX = PathElement.groupElement("blockDimX");
    public static final PathElement PATH$blockDimY = PathElement.groupElement("blockDimY");
    public static final PathElement PATH$blockDimZ = PathElement.groupElement("blockDimZ");
    public static final PathElement PATH$sharedMemBytes = PathElement.groupElement("sharedMemBytes");
    public static final PathElement PATH$paramCount = PathElement.groupElement("paramCount");
    public static final PathElement PATH$pParams = PathElement.groupElement("pParams");
    public static final PathElement PATH$extraCount = PathElement.groupElement("extraCount");
    public static final PathElement PATH$pExtras = PathElement.groupElement("pExtras");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$function = (AddressLayout) LAYOUT.select(PATH$function);
    public static final OfInt LAYOUT$gridDimX = (OfInt) LAYOUT.select(PATH$gridDimX);
    public static final OfInt LAYOUT$gridDimY = (OfInt) LAYOUT.select(PATH$gridDimY);
    public static final OfInt LAYOUT$gridDimZ = (OfInt) LAYOUT.select(PATH$gridDimZ);
    public static final OfInt LAYOUT$blockDimX = (OfInt) LAYOUT.select(PATH$blockDimX);
    public static final OfInt LAYOUT$blockDimY = (OfInt) LAYOUT.select(PATH$blockDimY);
    public static final OfInt LAYOUT$blockDimZ = (OfInt) LAYOUT.select(PATH$blockDimZ);
    public static final OfInt LAYOUT$sharedMemBytes = (OfInt) LAYOUT.select(PATH$sharedMemBytes);
    public static final AddressLayout LAYOUT$pParams = (AddressLayout) LAYOUT.select(PATH$pParams);
    public static final AddressLayout LAYOUT$pExtras = (AddressLayout) LAYOUT.select(PATH$pExtras);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$function = LAYOUT$function.byteSize();
    public static final long SIZE$gridDimX = LAYOUT$gridDimX.byteSize();
    public static final long SIZE$gridDimY = LAYOUT$gridDimY.byteSize();
    public static final long SIZE$gridDimZ = LAYOUT$gridDimZ.byteSize();
    public static final long SIZE$blockDimX = LAYOUT$blockDimX.byteSize();
    public static final long SIZE$blockDimY = LAYOUT$blockDimY.byteSize();
    public static final long SIZE$blockDimZ = LAYOUT$blockDimZ.byteSize();
    public static final long SIZE$sharedMemBytes = LAYOUT$sharedMemBytes.byteSize();
    public static final long SIZE$paramCount = NativeLayout.C_SIZE_T.byteSize();
    public static final long SIZE$pParams = LAYOUT$pParams.byteSize();
    public static final long SIZE$extraCount = NativeLayout.C_SIZE_T.byteSize();
    public static final long SIZE$pExtras = LAYOUT$pExtras.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$function = LAYOUT.byteOffset(PATH$function);
    public static final long OFFSET$gridDimX = LAYOUT.byteOffset(PATH$gridDimX);
    public static final long OFFSET$gridDimY = LAYOUT.byteOffset(PATH$gridDimY);
    public static final long OFFSET$gridDimZ = LAYOUT.byteOffset(PATH$gridDimZ);
    public static final long OFFSET$blockDimX = LAYOUT.byteOffset(PATH$blockDimX);
    public static final long OFFSET$blockDimY = LAYOUT.byteOffset(PATH$blockDimY);
    public static final long OFFSET$blockDimZ = LAYOUT.byteOffset(PATH$blockDimZ);
    public static final long OFFSET$sharedMemBytes = LAYOUT.byteOffset(PATH$sharedMemBytes);
    public static final long OFFSET$paramCount = LAYOUT.byteOffset(PATH$paramCount);
    public static final long OFFSET$pParams = LAYOUT.byteOffset(PATH$pParams);
    public static final long OFFSET$extraCount = LAYOUT.byteOffset(PATH$extraCount);
    public static final long OFFSET$pExtras = LAYOUT.byteOffset(PATH$pExtras);
}
