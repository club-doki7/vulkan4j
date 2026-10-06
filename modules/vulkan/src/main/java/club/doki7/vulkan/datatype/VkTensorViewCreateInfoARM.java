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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkTensorViewCreateInfoARM.html"><code>VkTensorViewCreateInfoARM</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkTensorViewCreateInfoARM {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkTensorViewCreateFlagsARM flags; // optional // @link substring="VkTensorViewCreateFlagsARM" target="VkTensorViewCreateFlagsARM" @link substring="flags" target="#flags"
///     VkTensorARM tensor; // @link substring="VkTensorARM" target="VkTensorARM" @link substring="tensor" target="#tensor"
///     VkFormat format; // @link substring="VkFormat" target="VkFormat" @link substring="format" target="#format"
/// } VkTensorViewCreateInfoARM;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_TENSOR_VIEW_CREATE_INFO_ARM`
///
/// The {@code allocate} ({@link VkTensorViewCreateInfoARM#allocate(Arena)}, {@link VkTensorViewCreateInfoARM#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkTensorViewCreateInfoARM#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkTensorViewCreateInfoARM.html"><code>VkTensorViewCreateInfoARM</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkTensorViewCreateInfoARM(@NotNull MemorySegment segment) implements IVkTensorViewCreateInfoARM {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkTensorViewCreateInfoARM.html"><code>VkTensorViewCreateInfoARM</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkTensorViewCreateInfoARM}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkTensorViewCreateInfoARM to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkTensorViewCreateInfoARM.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkTensorViewCreateInfoARM, Iterable<VkTensorViewCreateInfoARM> {
        public long size() {
            return segment.byteSize() / VkTensorViewCreateInfoARM.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkTensorViewCreateInfoARM at(long index) {
            return new VkTensorViewCreateInfoARM(segment.asSlice(index * VkTensorViewCreateInfoARM.BYTES, VkTensorViewCreateInfoARM.BYTES));
        }

        public VkTensorViewCreateInfoARM.Ptr at(long index, @NotNull Consumer<@NotNull VkTensorViewCreateInfoARM> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkTensorViewCreateInfoARM value) {
            MemorySegment s = segment.asSlice(index * VkTensorViewCreateInfoARM.BYTES, VkTensorViewCreateInfoARM.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkTensorViewCreateInfoARM.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkTensorViewCreateInfoARM.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkTensorViewCreateInfoARM.BYTES,
                (end - start) * VkTensorViewCreateInfoARM.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkTensorViewCreateInfoARM.BYTES));
        }

        public VkTensorViewCreateInfoARM[] toArray() {
            VkTensorViewCreateInfoARM[] ret = new VkTensorViewCreateInfoARM[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkTensorViewCreateInfoARM> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkTensorViewCreateInfoARM> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkTensorViewCreateInfoARM.BYTES;
            }

            @Override
            public VkTensorViewCreateInfoARM next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkTensorViewCreateInfoARM ret = new VkTensorViewCreateInfoARM(segment.asSlice(0, VkTensorViewCreateInfoARM.BYTES));
                segment = segment.asSlice(VkTensorViewCreateInfoARM.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkTensorViewCreateInfoARM allocate(Arena arena) {
        VkTensorViewCreateInfoARM ret = new VkTensorViewCreateInfoARM(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.TENSOR_VIEW_CREATE_INFO_ARM);
        return ret;
    }

    public static VkTensorViewCreateInfoARM.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkTensorViewCreateInfoARM.Ptr ret = new VkTensorViewCreateInfoARM.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.TENSOR_VIEW_CREATE_INFO_ARM);
        }
        return ret;
    }

    public static VkTensorViewCreateInfoARM clone(Arena arena, VkTensorViewCreateInfoARM src) {
        VkTensorViewCreateInfoARM ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.TENSOR_VIEW_CREATE_INFO_ARM);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkTensorViewCreateInfoARM sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkTensorViewCreateInfoARM pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkTensorViewCreateInfoARM pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkTensorViewCreateFlagsARM.class) long flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkTensorViewCreateInfoARM flags(@Bitmask(VkTensorViewCreateFlagsARM.class) long value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @Nullable VkTensorARM tensor() {
        MemorySegment s = segment.asSlice(OFFSET$tensor, SIZE$tensor);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkTensorARM(s);
    }

    public VkTensorViewCreateInfoARM tensor(@Nullable VkTensorARM value) {
        segment.set(LAYOUT$tensor, OFFSET$tensor, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @EnumType(VkFormat.class) int format() {
        return segment.get(LAYOUT$format, OFFSET$format);
    }

    public VkTensorViewCreateInfoARM format(@EnumType(VkFormat.class) int value) {
        segment.set(LAYOUT$format, OFFSET$format, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_LONG.withName("flags"),
        ValueLayout.ADDRESS.withName("tensor"),
        ValueLayout.JAVA_INT.withName("format")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$tensor = PathElement.groupElement("tensor");
    public static final PathElement PATH$format = PathElement.groupElement("format");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfLong LAYOUT$flags = (OfLong) LAYOUT.select(PATH$flags);
    public static final AddressLayout LAYOUT$tensor = (AddressLayout) LAYOUT.select(PATH$tensor);
    public static final OfInt LAYOUT$format = (OfInt) LAYOUT.select(PATH$format);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$tensor = LAYOUT$tensor.byteSize();
    public static final long SIZE$format = LAYOUT$format.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$tensor = LAYOUT.byteOffset(PATH$tensor);
    public static final long OFFSET$format = LAYOUT.byteOffset(PATH$format);
}
