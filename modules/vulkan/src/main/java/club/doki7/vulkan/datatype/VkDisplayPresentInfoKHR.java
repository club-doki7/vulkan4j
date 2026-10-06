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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDisplayPresentInfoKHR.html"><code>VkDisplayPresentInfoKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkDisplayPresentInfoKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkRect2D srcRect; // @link substring="VkRect2D" target="VkRect2D" @link substring="srcRect" target="#srcRect"
///     VkRect2D dstRect; // @link substring="VkRect2D" target="VkRect2D" @link substring="dstRect" target="#dstRect"
///     VkBool32 persistent; // @link substring="persistent" target="#persistent"
/// } VkDisplayPresentInfoKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_DISPLAY_PRESENT_INFO_KHR`
///
/// The {@code allocate} ({@link VkDisplayPresentInfoKHR#allocate(Arena)}, {@link VkDisplayPresentInfoKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkDisplayPresentInfoKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDisplayPresentInfoKHR.html"><code>VkDisplayPresentInfoKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkDisplayPresentInfoKHR(@NotNull MemorySegment segment) implements IVkDisplayPresentInfoKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkDisplayPresentInfoKHR.html"><code>VkDisplayPresentInfoKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkDisplayPresentInfoKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkDisplayPresentInfoKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkDisplayPresentInfoKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkDisplayPresentInfoKHR, Iterable<VkDisplayPresentInfoKHR> {
        public long size() {
            return segment.byteSize() / VkDisplayPresentInfoKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkDisplayPresentInfoKHR at(long index) {
            return new VkDisplayPresentInfoKHR(segment.asSlice(index * VkDisplayPresentInfoKHR.BYTES, VkDisplayPresentInfoKHR.BYTES));
        }

        public VkDisplayPresentInfoKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkDisplayPresentInfoKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkDisplayPresentInfoKHR value) {
            MemorySegment s = segment.asSlice(index * VkDisplayPresentInfoKHR.BYTES, VkDisplayPresentInfoKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkDisplayPresentInfoKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkDisplayPresentInfoKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkDisplayPresentInfoKHR.BYTES,
                (end - start) * VkDisplayPresentInfoKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkDisplayPresentInfoKHR.BYTES));
        }

        public VkDisplayPresentInfoKHR[] toArray() {
            VkDisplayPresentInfoKHR[] ret = new VkDisplayPresentInfoKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkDisplayPresentInfoKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkDisplayPresentInfoKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkDisplayPresentInfoKHR.BYTES;
            }

            @Override
            public VkDisplayPresentInfoKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkDisplayPresentInfoKHR ret = new VkDisplayPresentInfoKHR(segment.asSlice(0, VkDisplayPresentInfoKHR.BYTES));
                segment = segment.asSlice(VkDisplayPresentInfoKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkDisplayPresentInfoKHR allocate(Arena arena) {
        VkDisplayPresentInfoKHR ret = new VkDisplayPresentInfoKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.DISPLAY_PRESENT_INFO_KHR);
        return ret;
    }

    public static VkDisplayPresentInfoKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkDisplayPresentInfoKHR.Ptr ret = new VkDisplayPresentInfoKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.DISPLAY_PRESENT_INFO_KHR);
        }
        return ret;
    }

    public static VkDisplayPresentInfoKHR clone(Arena arena, VkDisplayPresentInfoKHR src) {
        VkDisplayPresentInfoKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.DISPLAY_PRESENT_INFO_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkDisplayPresentInfoKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkDisplayPresentInfoKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkDisplayPresentInfoKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NotNull VkRect2D srcRect() {
        return new VkRect2D(segment.asSlice(OFFSET$srcRect, LAYOUT$srcRect));
    }

    public VkDisplayPresentInfoKHR srcRect(@NotNull VkRect2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$srcRect, SIZE$srcRect);
        return this;
    }

    public VkDisplayPresentInfoKHR srcRect(Consumer<@NotNull VkRect2D> consumer) {
        consumer.accept(srcRect());
        return this;
    }

    public @NotNull VkRect2D dstRect() {
        return new VkRect2D(segment.asSlice(OFFSET$dstRect, LAYOUT$dstRect));
    }

    public VkDisplayPresentInfoKHR dstRect(@NotNull VkRect2D value) {
        MemorySegment.copy(value.segment(), 0, segment, OFFSET$dstRect, SIZE$dstRect);
        return this;
    }

    public VkDisplayPresentInfoKHR dstRect(Consumer<@NotNull VkRect2D> consumer) {
        consumer.accept(dstRect());
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int persistent() {
        return segment.get(LAYOUT$persistent, OFFSET$persistent);
    }

    public VkDisplayPresentInfoKHR persistent(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$persistent, OFFSET$persistent, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        VkRect2D.LAYOUT.withName("srcRect"),
        VkRect2D.LAYOUT.withName("dstRect"),
        ValueLayout.JAVA_INT.withName("persistent")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$srcRect = PathElement.groupElement("srcRect");
    public static final PathElement PATH$dstRect = PathElement.groupElement("dstRect");
    public static final PathElement PATH$persistent = PathElement.groupElement("persistent");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final StructLayout LAYOUT$srcRect = (StructLayout) LAYOUT.select(PATH$srcRect);
    public static final StructLayout LAYOUT$dstRect = (StructLayout) LAYOUT.select(PATH$dstRect);
    public static final OfInt LAYOUT$persistent = (OfInt) LAYOUT.select(PATH$persistent);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$srcRect = LAYOUT$srcRect.byteSize();
    public static final long SIZE$dstRect = LAYOUT$dstRect.byteSize();
    public static final long SIZE$persistent = LAYOUT$persistent.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$srcRect = LAYOUT.byteOffset(PATH$srcRect);
    public static final long OFFSET$dstRect = LAYOUT.byteOffset(PATH$dstRect);
    public static final long OFFSET$persistent = LAYOUT.byteOffset(PATH$persistent);
}
