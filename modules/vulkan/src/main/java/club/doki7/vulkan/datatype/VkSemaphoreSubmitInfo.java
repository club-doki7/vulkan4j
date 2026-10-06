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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSemaphoreSubmitInfo.html"><code>VkSemaphoreSubmitInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkSemaphoreSubmitInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkSemaphore semaphore; // @link substring="VkSemaphore" target="VkSemaphore" @link substring="semaphore" target="#semaphore"
///     uint64_t value; // @link substring="value" target="#value"
///     VkPipelineStageFlags2 stageMask; // optional // @link substring="VkPipelineStageFlags2" target="VkPipelineStageFlags2" @link substring="stageMask" target="#stageMask"
///     uint32_t deviceIndex; // @link substring="deviceIndex" target="#deviceIndex"
/// } VkSemaphoreSubmitInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_SEMAPHORE_SUBMIT_INFO`
///
/// The {@code allocate} ({@link VkSemaphoreSubmitInfo#allocate(Arena)}, {@link VkSemaphoreSubmitInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkSemaphoreSubmitInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSemaphoreSubmitInfo.html"><code>VkSemaphoreSubmitInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkSemaphoreSubmitInfo(@NotNull MemorySegment segment) implements IVkSemaphoreSubmitInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSemaphoreSubmitInfo.html"><code>VkSemaphoreSubmitInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkSemaphoreSubmitInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkSemaphoreSubmitInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkSemaphoreSubmitInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkSemaphoreSubmitInfo, Iterable<VkSemaphoreSubmitInfo> {
        public long size() {
            return segment.byteSize() / VkSemaphoreSubmitInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkSemaphoreSubmitInfo at(long index) {
            return new VkSemaphoreSubmitInfo(segment.asSlice(index * VkSemaphoreSubmitInfo.BYTES, VkSemaphoreSubmitInfo.BYTES));
        }

        public VkSemaphoreSubmitInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkSemaphoreSubmitInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkSemaphoreSubmitInfo value) {
            MemorySegment s = segment.asSlice(index * VkSemaphoreSubmitInfo.BYTES, VkSemaphoreSubmitInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkSemaphoreSubmitInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkSemaphoreSubmitInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkSemaphoreSubmitInfo.BYTES,
                (end - start) * VkSemaphoreSubmitInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkSemaphoreSubmitInfo.BYTES));
        }

        public VkSemaphoreSubmitInfo[] toArray() {
            VkSemaphoreSubmitInfo[] ret = new VkSemaphoreSubmitInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkSemaphoreSubmitInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkSemaphoreSubmitInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkSemaphoreSubmitInfo.BYTES;
            }

            @Override
            public VkSemaphoreSubmitInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkSemaphoreSubmitInfo ret = new VkSemaphoreSubmitInfo(segment.asSlice(0, VkSemaphoreSubmitInfo.BYTES));
                segment = segment.asSlice(VkSemaphoreSubmitInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkSemaphoreSubmitInfo allocate(Arena arena) {
        VkSemaphoreSubmitInfo ret = new VkSemaphoreSubmitInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.SEMAPHORE_SUBMIT_INFO);
        return ret;
    }

    public static VkSemaphoreSubmitInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkSemaphoreSubmitInfo.Ptr ret = new VkSemaphoreSubmitInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.SEMAPHORE_SUBMIT_INFO);
        }
        return ret;
    }

    public static VkSemaphoreSubmitInfo clone(Arena arena, VkSemaphoreSubmitInfo src) {
        VkSemaphoreSubmitInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.SEMAPHORE_SUBMIT_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkSemaphoreSubmitInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkSemaphoreSubmitInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkSemaphoreSubmitInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Nullable VkSemaphore semaphore() {
        MemorySegment s = segment.asSlice(OFFSET$semaphore, SIZE$semaphore);
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkSemaphore(s);
    }

    public VkSemaphoreSubmitInfo semaphore(@Nullable VkSemaphore value) {
        segment.set(LAYOUT$semaphore, OFFSET$semaphore, value != null ? value.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned long value() {
        return segment.get(LAYOUT$value, OFFSET$value);
    }

    public VkSemaphoreSubmitInfo value(@Unsigned long value) {
        segment.set(LAYOUT$value, OFFSET$value, value);
        return this;
    }

    public @Bitmask(VkPipelineStageFlags2.class) long stageMask() {
        return segment.get(LAYOUT$stageMask, OFFSET$stageMask);
    }

    public VkSemaphoreSubmitInfo stageMask(@Bitmask(VkPipelineStageFlags2.class) long value) {
        segment.set(LAYOUT$stageMask, OFFSET$stageMask, value);
        return this;
    }

    public @Unsigned int deviceIndex() {
        return segment.get(LAYOUT$deviceIndex, OFFSET$deviceIndex);
    }

    public VkSemaphoreSubmitInfo deviceIndex(@Unsigned int value) {
        segment.set(LAYOUT$deviceIndex, OFFSET$deviceIndex, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.ADDRESS.withName("semaphore"),
        ValueLayout.JAVA_LONG.withName("value"),
        ValueLayout.JAVA_LONG.withName("stageMask"),
        ValueLayout.JAVA_INT.withName("deviceIndex")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$semaphore = PathElement.groupElement("semaphore");
    public static final PathElement PATH$value = PathElement.groupElement("value");
    public static final PathElement PATH$stageMask = PathElement.groupElement("stageMask");
    public static final PathElement PATH$deviceIndex = PathElement.groupElement("deviceIndex");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final AddressLayout LAYOUT$semaphore = (AddressLayout) LAYOUT.select(PATH$semaphore);
    public static final OfLong LAYOUT$value = (OfLong) LAYOUT.select(PATH$value);
    public static final OfLong LAYOUT$stageMask = (OfLong) LAYOUT.select(PATH$stageMask);
    public static final OfInt LAYOUT$deviceIndex = (OfInt) LAYOUT.select(PATH$deviceIndex);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$semaphore = LAYOUT$semaphore.byteSize();
    public static final long SIZE$value = LAYOUT$value.byteSize();
    public static final long SIZE$stageMask = LAYOUT$stageMask.byteSize();
    public static final long SIZE$deviceIndex = LAYOUT$deviceIndex.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$semaphore = LAYOUT.byteOffset(PATH$semaphore);
    public static final long OFFSET$value = LAYOUT.byteOffset(PATH$value);
    public static final long OFFSET$stageMask = LAYOUT.byteOffset(PATH$stageMask);
    public static final long OFFSET$deviceIndex = LAYOUT.byteOffset(PATH$deviceIndex);
}
