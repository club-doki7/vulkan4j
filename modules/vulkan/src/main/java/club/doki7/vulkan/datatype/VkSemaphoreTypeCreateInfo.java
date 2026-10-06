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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSemaphoreTypeCreateInfo.html"><code>VkSemaphoreTypeCreateInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkSemaphoreTypeCreateInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkSemaphoreType semaphoreType; // @link substring="VkSemaphoreType" target="VkSemaphoreType" @link substring="semaphoreType" target="#semaphoreType"
///     uint64_t initialValue; // @link substring="initialValue" target="#initialValue"
/// } VkSemaphoreTypeCreateInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_SEMAPHORE_TYPE_CREATE_INFO`
///
/// The {@code allocate} ({@link VkSemaphoreTypeCreateInfo#allocate(Arena)}, {@link VkSemaphoreTypeCreateInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkSemaphoreTypeCreateInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSemaphoreTypeCreateInfo.html"><code>VkSemaphoreTypeCreateInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkSemaphoreTypeCreateInfo(@NotNull MemorySegment segment) implements IVkSemaphoreTypeCreateInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSemaphoreTypeCreateInfo.html"><code>VkSemaphoreTypeCreateInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkSemaphoreTypeCreateInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkSemaphoreTypeCreateInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkSemaphoreTypeCreateInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkSemaphoreTypeCreateInfo, Iterable<VkSemaphoreTypeCreateInfo> {
        public long size() {
            return segment.byteSize() / VkSemaphoreTypeCreateInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkSemaphoreTypeCreateInfo at(long index) {
            return new VkSemaphoreTypeCreateInfo(segment.asSlice(index * VkSemaphoreTypeCreateInfo.BYTES, VkSemaphoreTypeCreateInfo.BYTES));
        }

        public VkSemaphoreTypeCreateInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkSemaphoreTypeCreateInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkSemaphoreTypeCreateInfo value) {
            MemorySegment s = segment.asSlice(index * VkSemaphoreTypeCreateInfo.BYTES, VkSemaphoreTypeCreateInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkSemaphoreTypeCreateInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkSemaphoreTypeCreateInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkSemaphoreTypeCreateInfo.BYTES,
                (end - start) * VkSemaphoreTypeCreateInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkSemaphoreTypeCreateInfo.BYTES));
        }

        public VkSemaphoreTypeCreateInfo[] toArray() {
            VkSemaphoreTypeCreateInfo[] ret = new VkSemaphoreTypeCreateInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkSemaphoreTypeCreateInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkSemaphoreTypeCreateInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkSemaphoreTypeCreateInfo.BYTES;
            }

            @Override
            public VkSemaphoreTypeCreateInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkSemaphoreTypeCreateInfo ret = new VkSemaphoreTypeCreateInfo(segment.asSlice(0, VkSemaphoreTypeCreateInfo.BYTES));
                segment = segment.asSlice(VkSemaphoreTypeCreateInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkSemaphoreTypeCreateInfo allocate(Arena arena) {
        VkSemaphoreTypeCreateInfo ret = new VkSemaphoreTypeCreateInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.SEMAPHORE_TYPE_CREATE_INFO);
        return ret;
    }

    public static VkSemaphoreTypeCreateInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkSemaphoreTypeCreateInfo.Ptr ret = new VkSemaphoreTypeCreateInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.SEMAPHORE_TYPE_CREATE_INFO);
        }
        return ret;
    }

    public static VkSemaphoreTypeCreateInfo clone(Arena arena, VkSemaphoreTypeCreateInfo src) {
        VkSemaphoreTypeCreateInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.SEMAPHORE_TYPE_CREATE_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkSemaphoreTypeCreateInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkSemaphoreTypeCreateInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkSemaphoreTypeCreateInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @EnumType(VkSemaphoreType.class) int semaphoreType() {
        return segment.get(LAYOUT$semaphoreType, OFFSET$semaphoreType);
    }

    public VkSemaphoreTypeCreateInfo semaphoreType(@EnumType(VkSemaphoreType.class) int value) {
        segment.set(LAYOUT$semaphoreType, OFFSET$semaphoreType, value);
        return this;
    }

    public @Unsigned long initialValue() {
        return segment.get(LAYOUT$initialValue, OFFSET$initialValue);
    }

    public VkSemaphoreTypeCreateInfo initialValue(@Unsigned long value) {
        segment.set(LAYOUT$initialValue, OFFSET$initialValue, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("semaphoreType"),
        ValueLayout.JAVA_LONG.withName("initialValue")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$semaphoreType = PathElement.groupElement("semaphoreType");
    public static final PathElement PATH$initialValue = PathElement.groupElement("initialValue");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$semaphoreType = (OfInt) LAYOUT.select(PATH$semaphoreType);
    public static final OfLong LAYOUT$initialValue = (OfLong) LAYOUT.select(PATH$initialValue);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$semaphoreType = LAYOUT$semaphoreType.byteSize();
    public static final long SIZE$initialValue = LAYOUT$initialValue.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$semaphoreType = LAYOUT.byteOffset(PATH$semaphoreType);
    public static final long OFFSET$initialValue = LAYOUT.byteOffset(PATH$initialValue);
}
