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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCuFunctionCreateInfoNVX.html"><code>VkCuFunctionCreateInfoNVX</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkCuFunctionCreateInfoNVX {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkCuModuleNVX module; // @link substring="VkCuModuleNVX" target="VkCuModuleNVX" @link substring="module" target="#module"
///     char const* pName; // @link substring="pName" target="#pName"
/// } VkCuFunctionCreateInfoNVX;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_CU_FUNCTION_CREATE_INFO_NVX`
///
/// The {@code allocate} ({@link VkCuFunctionCreateInfoNVX#allocate(Arena)}, {@link VkCuFunctionCreateInfoNVX#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkCuFunctionCreateInfoNVX#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCuFunctionCreateInfoNVX.html"><code>VkCuFunctionCreateInfoNVX</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkCuFunctionCreateInfoNVX(@NotNull MemorySegment segment) implements IVkCuFunctionCreateInfoNVX {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkCuFunctionCreateInfoNVX.html"><code>VkCuFunctionCreateInfoNVX</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkCuFunctionCreateInfoNVX}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkCuFunctionCreateInfoNVX to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkCuFunctionCreateInfoNVX.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkCuFunctionCreateInfoNVX, Iterable<VkCuFunctionCreateInfoNVX> {
        public long size() {
            return segment.byteSize() / VkCuFunctionCreateInfoNVX.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkCuFunctionCreateInfoNVX at(long index) {
            return new VkCuFunctionCreateInfoNVX(segment.asSlice(index * VkCuFunctionCreateInfoNVX.BYTES, VkCuFunctionCreateInfoNVX.BYTES));
        }

        public VkCuFunctionCreateInfoNVX.Ptr at(long index, @NotNull Consumer<@NotNull VkCuFunctionCreateInfoNVX> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkCuFunctionCreateInfoNVX value) {
            MemorySegment s = segment.asSlice(index * VkCuFunctionCreateInfoNVX.BYTES, VkCuFunctionCreateInfoNVX.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkCuFunctionCreateInfoNVX.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkCuFunctionCreateInfoNVX.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkCuFunctionCreateInfoNVX.BYTES,
                (end - start) * VkCuFunctionCreateInfoNVX.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkCuFunctionCreateInfoNVX.BYTES));
        }

        public VkCuFunctionCreateInfoNVX[] toArray() {
            VkCuFunctionCreateInfoNVX[] ret = new VkCuFunctionCreateInfoNVX[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkCuFunctionCreateInfoNVX> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkCuFunctionCreateInfoNVX> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkCuFunctionCreateInfoNVX.BYTES;
            }

            @Override
            public VkCuFunctionCreateInfoNVX next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkCuFunctionCreateInfoNVX ret = new VkCuFunctionCreateInfoNVX(segment.asSlice(0, VkCuFunctionCreateInfoNVX.BYTES));
                segment = segment.asSlice(VkCuFunctionCreateInfoNVX.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkCuFunctionCreateInfoNVX allocate(Arena arena) {
        VkCuFunctionCreateInfoNVX ret = new VkCuFunctionCreateInfoNVX(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.CU_FUNCTION_CREATE_INFO_NVX);
        return ret;
    }

    public static VkCuFunctionCreateInfoNVX.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkCuFunctionCreateInfoNVX.Ptr ret = new VkCuFunctionCreateInfoNVX.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.CU_FUNCTION_CREATE_INFO_NVX);
        }
        return ret;
    }

    public static VkCuFunctionCreateInfoNVX clone(Arena arena, VkCuFunctionCreateInfoNVX src) {
        VkCuFunctionCreateInfoNVX ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.CU_FUNCTION_CREATE_INFO_NVX);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkCuFunctionCreateInfoNVX sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkCuFunctionCreateInfoNVX pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkCuFunctionCreateInfoNVX pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Nullable VkCuModuleNVX module() {
        MemorySegment s = segment.asSlice(OFFSET$module, SIZE$module);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkCuModuleNVX(s);
    }

    public VkCuFunctionCreateInfoNVX module(@Nullable VkCuModuleNVX value) {
        segment.set(LAYOUT$module, OFFSET$module, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    /// Note: the returned {@link BytePtr} does not have correct
    /// {@link BytePtr#size} property. It's up to user to track the size of the buffer,
    /// and use {@link BytePtr#reinterpret} to set the size before actually reading from or
    /// writing to the buffer.
    public @Nullable BytePtr pName() {
        MemorySegment s = pNameRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new BytePtr(s);
    }

    public VkCuFunctionCreateInfoNVX pName(@Nullable BytePtr value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pNameRaw(s);
        return this;
    }

    public @Pointer(comment="int8_t*") @NotNull MemorySegment pNameRaw() {
        return segment.get(LAYOUT$pName, OFFSET$pName);
    }

    public void pNameRaw(@Pointer(comment="int8_t*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pName, OFFSET$pName, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withName("module"),
        ValueLayout.ADDRESS.withTargetLayout(ValueLayout.JAVA_BYTE).withName("pName")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$module = PathElement.groupElement("module");
    public static final PathElement PATH$pName = PathElement.groupElement("pName");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$module = (AddressLayout) LAYOUT.select(PATH$module);
    public static final AddressLayout LAYOUT$pName = (AddressLayout) LAYOUT.select(PATH$pName);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$module = LAYOUT$module.byteSize();
    public static final long SIZE$pName = LAYOUT$pName.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$module = LAYOUT.byteOffset(PATH$module);
    public static final long OFFSET$pName = LAYOUT.byteOffset(PATH$pName);
}
