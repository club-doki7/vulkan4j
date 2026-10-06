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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkTilePropertiesQCOM.html"><code>VkTilePropertiesQCOM</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkTilePropertiesQCOM {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkExtent3D tileSize; // @link substring="VkExtent3D" target="VkExtent3D" @link substring="tileSize" target="#tileSize"
///     VkExtent2D apronSize; // @link substring="VkExtent2D" target="VkExtent2D" @link substring="apronSize" target="#apronSize"
///     VkOffset2D origin; // @link substring="VkOffset2D" target="VkOffset2D" @link substring="origin" target="#origin"
/// } VkTilePropertiesQCOM;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_TILE_PROPERTIES_QCOM`
///
/// The {@code allocate} ({@link VkTilePropertiesQCOM#allocate(Arena)}, {@link VkTilePropertiesQCOM#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkTilePropertiesQCOM#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkTilePropertiesQCOM.html"><code>VkTilePropertiesQCOM</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkTilePropertiesQCOM(@NotNull MemorySegment segment) implements IVkTilePropertiesQCOM {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkTilePropertiesQCOM.html"><code>VkTilePropertiesQCOM</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkTilePropertiesQCOM}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkTilePropertiesQCOM to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkTilePropertiesQCOM.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkTilePropertiesQCOM, Iterable<VkTilePropertiesQCOM> {
        public long size() {
            return segment.byteSize() / VkTilePropertiesQCOM.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkTilePropertiesQCOM at(long index) {
            return new VkTilePropertiesQCOM(segment.asSlice(index * VkTilePropertiesQCOM.BYTES, VkTilePropertiesQCOM.BYTES));
        }

        public VkTilePropertiesQCOM.Ptr at(long index, @NotNull Consumer<@NotNull VkTilePropertiesQCOM> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkTilePropertiesQCOM value) {
            MemorySegment s = segment.asSlice(index * VkTilePropertiesQCOM.BYTES, VkTilePropertiesQCOM.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkTilePropertiesQCOM.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkTilePropertiesQCOM.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkTilePropertiesQCOM.BYTES,
                (end - start) * VkTilePropertiesQCOM.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkTilePropertiesQCOM.BYTES));
        }

        public VkTilePropertiesQCOM[] toArray() {
            VkTilePropertiesQCOM[] ret = new VkTilePropertiesQCOM[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkTilePropertiesQCOM> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkTilePropertiesQCOM> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkTilePropertiesQCOM.BYTES;
            }

            @Override
            public VkTilePropertiesQCOM next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkTilePropertiesQCOM ret = new VkTilePropertiesQCOM(segment.asSlice(0, VkTilePropertiesQCOM.BYTES));
                segment = segment.asSlice(VkTilePropertiesQCOM.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkTilePropertiesQCOM allocate(Arena arena) {
        VkTilePropertiesQCOM ret = new VkTilePropertiesQCOM(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.TILE_PROPERTIES_QCOM);
        return ret;
    }

    public static VkTilePropertiesQCOM.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkTilePropertiesQCOM.Ptr ret = new VkTilePropertiesQCOM.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.TILE_PROPERTIES_QCOM);
        }
        return ret;
    }

    public static VkTilePropertiesQCOM clone(Arena arena, VkTilePropertiesQCOM src) {
        VkTilePropertiesQCOM ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.TILE_PROPERTIES_QCOM);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkTilePropertiesQCOM sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkTilePropertiesQCOM pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkTilePropertiesQCOM pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NotNull VkExtent3D tileSize() {
        return new VkExtent3D(segment.asSlice(OFFSET$tileSize, LAYOUT$tileSize));
    }

    public VkTilePropertiesQCOM tileSize(@NotNull VkExtent3D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$tileSize, SIZE$tileSize);
        return this;
    }

    public VkTilePropertiesQCOM tileSize(Consumer<@NotNull VkExtent3D> consumer) {
        consumer.accept(tileSize());
        return this;
    }

    public @NotNull VkExtent2D apronSize() {
        return new VkExtent2D(segment.asSlice(OFFSET$apronSize, LAYOUT$apronSize));
    }

    public VkTilePropertiesQCOM apronSize(@NotNull VkExtent2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$apronSize, SIZE$apronSize);
        return this;
    }

    public VkTilePropertiesQCOM apronSize(Consumer<@NotNull VkExtent2D> consumer) {
        consumer.accept(apronSize());
        return this;
    }

    public @NotNull VkOffset2D origin() {
        return new VkOffset2D(segment.asSlice(OFFSET$origin, LAYOUT$origin));
    }

    public VkTilePropertiesQCOM origin(@NotNull VkOffset2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$origin, SIZE$origin);
        return this;
    }

    public VkTilePropertiesQCOM origin(Consumer<@NotNull VkOffset2D> consumer) {
        consumer.accept(origin());
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        VkExtent3D.LAYOUT.withName("tileSize"),
        VkExtent2D.LAYOUT.withName("apronSize"),
        VkOffset2D.LAYOUT.withName("origin")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$tileSize = PathElement.groupElement("tileSize");
    public static final PathElement PATH$apronSize = PathElement.groupElement("apronSize");
    public static final PathElement PATH$origin = PathElement.groupElement("origin");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final StructLayout LAYOUT$tileSize = (StructLayout) LAYOUT.select(PATH$tileSize);
    public static final StructLayout LAYOUT$apronSize = (StructLayout) LAYOUT.select(PATH$apronSize);
    public static final StructLayout LAYOUT$origin = (StructLayout) LAYOUT.select(PATH$origin);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$tileSize = LAYOUT$tileSize.byteSize();
    public static final long SIZE$apronSize = LAYOUT$apronSize.byteSize();
    public static final long SIZE$origin = LAYOUT$origin.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$tileSize = LAYOUT.byteOffset(PATH$tileSize);
    public static final long OFFSET$apronSize = LAYOUT.byteOffset(PATH$apronSize);
    public static final long OFFSET$origin = LAYOUT.byteOffset(PATH$origin);
}
