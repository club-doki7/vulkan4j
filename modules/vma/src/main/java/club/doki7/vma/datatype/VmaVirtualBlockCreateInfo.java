package club.doki7.vma.datatype;

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
import club.doki7.vma.bitmask.*;
import club.doki7.vma.handle.*;
import club.doki7.vma.enumtype.*;
import club.doki7.vma.VMAFunctionTypes.*;
import club.doki7.vulkan.bitmask.*;
import club.doki7.vulkan.datatype.*;
import club.doki7.vulkan.enumtype.*;
import club.doki7.vulkan.handle.*;
import static club.doki7.vulkan.VkConstants.*;

/// Parameters of created {@code VmaVirtualBlock} object to be passed to vmaCreateVirtualBlock().
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VmaVirtualBlockCreateInfo {
///     VkDeviceSize size; // @link substring="size" target="#size"
///     VmaVirtualBlockCreateFlags flags; // @link substring="VmaVirtualBlockCreateFlags" target="VmaVirtualBlockCreateFlags" @link substring="flags" target="#flags"
///     VkAllocationCallbacks const* pAllocationCallbacks; // optional // @link substring="VkAllocationCallbacks" target="VkAllocationCallbacks" @link substring="pAllocationCallbacks" target="#pAllocationCallbacks"
/// } VmaVirtualBlockCreateInfo;
/// }
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
/// ## Member documentation
///
/// <ul>
/// <li>{@link #size} Total size of the virtual block.
///
/// Sizes can be expressed in bytes or any units you want as long as you are consistent in using them.
/// For example, if you allocate from some array of structures, 1 can mean single instance of entire structure.
/// </li>
/// <li>{@link #flags} Use combination of {@code VmaVirtualBlockCreateFlagBits}.</li>
/// <li>{@link #pAllocationCallbacks} Custom CPU memory allocation callbacks. Optional.
///
/// Optional, can be null. When specified, they will be used for all CPU-side memory allocations.
/// </li>
/// </ul>
@ValueBasedCandidate
@UnsafeConstructor
public record VmaVirtualBlockCreateInfo(@NotNull MemorySegment segment) implements IVmaVirtualBlockCreateInfo {
    /// Represents a pointer to / an array of null structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VmaVirtualBlockCreateInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVmaVirtualBlockCreateInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VmaVirtualBlockCreateInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVmaVirtualBlockCreateInfo, Iterable<VmaVirtualBlockCreateInfo> {
        public long size() {
            return segment.byteSize() / VmaVirtualBlockCreateInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VmaVirtualBlockCreateInfo at(long index) {
            return new VmaVirtualBlockCreateInfo(segment.asSlice(index * VmaVirtualBlockCreateInfo.BYTES, VmaVirtualBlockCreateInfo.BYTES));
        }

        public VmaVirtualBlockCreateInfo.Ptr at(long index, @NotNull Consumer<@NotNull VmaVirtualBlockCreateInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VmaVirtualBlockCreateInfo value) {
            MemorySegment s = segment.asSlice(index * VmaVirtualBlockCreateInfo.BYTES, VmaVirtualBlockCreateInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VmaVirtualBlockCreateInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VmaVirtualBlockCreateInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VmaVirtualBlockCreateInfo.BYTES,
                (end - start) * VmaVirtualBlockCreateInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VmaVirtualBlockCreateInfo.BYTES));
        }

        public VmaVirtualBlockCreateInfo[] toArray() {
            VmaVirtualBlockCreateInfo[] ret = new VmaVirtualBlockCreateInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VmaVirtualBlockCreateInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VmaVirtualBlockCreateInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VmaVirtualBlockCreateInfo.BYTES;
            }

            @Override
            public VmaVirtualBlockCreateInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VmaVirtualBlockCreateInfo ret = new VmaVirtualBlockCreateInfo(segment.asSlice(0, VmaVirtualBlockCreateInfo.BYTES));
                segment = segment.asSlice(VmaVirtualBlockCreateInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VmaVirtualBlockCreateInfo allocate(Arena arena) {
        return new VmaVirtualBlockCreateInfo(arena.allocate(LAYOUT));
    }

    public static VmaVirtualBlockCreateInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        return new VmaVirtualBlockCreateInfo.Ptr(segment);
    }

    public static VmaVirtualBlockCreateInfo clone(Arena arena, VmaVirtualBlockCreateInfo src) {
        VmaVirtualBlockCreateInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public @NativeType("VkDeviceSize") @Unsigned long size() {
        return segment.get(LAYOUT$size, OFFSET$size);
    }

    public VmaVirtualBlockCreateInfo size(@NativeType("VkDeviceSize") @Unsigned long value) {
        segment.set(LAYOUT$size, OFFSET$size, value);
        return this;
    }

    public @Bitmask(VmaVirtualBlockCreateFlags.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VmaVirtualBlockCreateInfo flags(@Bitmask(VmaVirtualBlockCreateFlags.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public VmaVirtualBlockCreateInfo pAllocationCallbacks(@Nullable IVkAllocationCallbacks value) {
        MemorySegment s = value == null ? MemorySegment.NULL : value.segment();
        pAllocationCallbacksRaw(s);
        return this;
    }

    @Unsafe public @Nullable VkAllocationCallbacks.Ptr pAllocationCallbacks(int assumedCount) {
        MemorySegment s = pAllocationCallbacksRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }

        s = s.reinterpret(assumedCount * VkAllocationCallbacks.BYTES);
        return new VkAllocationCallbacks.Ptr(s);
    }

    public @Nullable VkAllocationCallbacks pAllocationCallbacks() {
        MemorySegment s = pAllocationCallbacksRaw();
        if (s.equals(MemorySegment.NULL)) {
            return null;
        }
        return new VkAllocationCallbacks(s);
    }

    public @Pointer(target=VkAllocationCallbacks.class) @NotNull MemorySegment pAllocationCallbacksRaw() {
        return segment.get(LAYOUT$pAllocationCallbacks, OFFSET$pAllocationCallbacks);
    }

    public void pAllocationCallbacksRaw(@Pointer(target=VkAllocationCallbacks.class) @NotNull MemorySegment value) {
        segment.set(LAYOUT$pAllocationCallbacks, OFFSET$pAllocationCallbacks, value);
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_LONG.withName("size"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.ADDRESS.withTargetLayout(VkAllocationCallbacks.LAYOUT).withName("pAllocationCallbacks")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$size = PathElement.groupElement("size");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$pAllocationCallbacks = PathElement.groupElement("pAllocationCallbacks");

    public static final OfLong LAYOUT$size = (OfLong) LAYOUT.select(PATH$size);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final AddressLayout LAYOUT$pAllocationCallbacks = (AddressLayout) LAYOUT.select(PATH$pAllocationCallbacks);

    public static final long SIZE$size = LAYOUT$size.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$pAllocationCallbacks = LAYOUT$pAllocationCallbacks.byteSize();

    public static final long OFFSET$size = LAYOUT.byteOffset(PATH$size);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$pAllocationCallbacks = LAYOUT.byteOffset(PATH$pAllocationCallbacks);
}
