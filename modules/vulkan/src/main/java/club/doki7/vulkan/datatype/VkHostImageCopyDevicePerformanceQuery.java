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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkHostImageCopyDevicePerformanceQuery.html"><code>VkHostImageCopyDevicePerformanceQuery</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkHostImageCopyDevicePerformanceQuery {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 optimalDeviceAccess; // @link substring="optimalDeviceAccess" target="#optimalDeviceAccess"
///     VkBool32 identicalMemoryLayout; // @link substring="identicalMemoryLayout" target="#identicalMemoryLayout"
/// } VkHostImageCopyDevicePerformanceQuery;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_HOST_IMAGE_COPY_DEVICE_PERFORMANCE_QUERY`
///
/// The {@code allocate} ({@link VkHostImageCopyDevicePerformanceQuery#allocate(Arena)}, {@link VkHostImageCopyDevicePerformanceQuery#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkHostImageCopyDevicePerformanceQuery#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkHostImageCopyDevicePerformanceQuery.html"><code>VkHostImageCopyDevicePerformanceQuery</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkHostImageCopyDevicePerformanceQuery(@NotNull MemorySegment segment) implements IVkHostImageCopyDevicePerformanceQuery {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkHostImageCopyDevicePerformanceQuery.html"><code>VkHostImageCopyDevicePerformanceQuery</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkHostImageCopyDevicePerformanceQuery}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkHostImageCopyDevicePerformanceQuery to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkHostImageCopyDevicePerformanceQuery.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkHostImageCopyDevicePerformanceQuery, Iterable<VkHostImageCopyDevicePerformanceQuery> {
        public long size() {
            return segment.byteSize() / VkHostImageCopyDevicePerformanceQuery.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkHostImageCopyDevicePerformanceQuery at(long index) {
            return new VkHostImageCopyDevicePerformanceQuery(segment.asSlice(index * VkHostImageCopyDevicePerformanceQuery.BYTES, VkHostImageCopyDevicePerformanceQuery.BYTES));
        }

        public VkHostImageCopyDevicePerformanceQuery.Ptr at(long index, @NotNull Consumer<@NotNull VkHostImageCopyDevicePerformanceQuery> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkHostImageCopyDevicePerformanceQuery value) {
            MemorySegment s = segment.asSlice(index * VkHostImageCopyDevicePerformanceQuery.BYTES, VkHostImageCopyDevicePerformanceQuery.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkHostImageCopyDevicePerformanceQuery.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkHostImageCopyDevicePerformanceQuery.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkHostImageCopyDevicePerformanceQuery.BYTES,
                (end - start) * VkHostImageCopyDevicePerformanceQuery.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkHostImageCopyDevicePerformanceQuery.BYTES));
        }

        public VkHostImageCopyDevicePerformanceQuery[] toArray() {
            VkHostImageCopyDevicePerformanceQuery[] ret = new VkHostImageCopyDevicePerformanceQuery[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkHostImageCopyDevicePerformanceQuery> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkHostImageCopyDevicePerformanceQuery> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkHostImageCopyDevicePerformanceQuery.BYTES;
            }

            @Override
            public VkHostImageCopyDevicePerformanceQuery next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkHostImageCopyDevicePerformanceQuery ret = new VkHostImageCopyDevicePerformanceQuery(segment.asSlice(0, VkHostImageCopyDevicePerformanceQuery.BYTES));
                segment = segment.asSlice(VkHostImageCopyDevicePerformanceQuery.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkHostImageCopyDevicePerformanceQuery allocate(Arena arena) {
        VkHostImageCopyDevicePerformanceQuery ret = new VkHostImageCopyDevicePerformanceQuery(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.HOST_IMAGE_COPY_DEVICE_PERFORMANCE_QUERY);
        return ret;
    }

    public static VkHostImageCopyDevicePerformanceQuery.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkHostImageCopyDevicePerformanceQuery.Ptr ret = new VkHostImageCopyDevicePerformanceQuery.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.HOST_IMAGE_COPY_DEVICE_PERFORMANCE_QUERY);
        }
        return ret;
    }

    public static VkHostImageCopyDevicePerformanceQuery clone(Arena arena, VkHostImageCopyDevicePerformanceQuery src) {
        VkHostImageCopyDevicePerformanceQuery ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.HOST_IMAGE_COPY_DEVICE_PERFORMANCE_QUERY);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkHostImageCopyDevicePerformanceQuery sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkHostImageCopyDevicePerformanceQuery pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkHostImageCopyDevicePerformanceQuery pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int optimalDeviceAccess() {
        return segment.get(LAYOUT$optimalDeviceAccess, OFFSET$optimalDeviceAccess);
    }

    public VkHostImageCopyDevicePerformanceQuery optimalDeviceAccess(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$optimalDeviceAccess, OFFSET$optimalDeviceAccess, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int identicalMemoryLayout() {
        return segment.get(LAYOUT$identicalMemoryLayout, OFFSET$identicalMemoryLayout);
    }

    public VkHostImageCopyDevicePerformanceQuery identicalMemoryLayout(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$identicalMemoryLayout, OFFSET$identicalMemoryLayout, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("optimalDeviceAccess"),
        ValueLayout.JAVA_INT.withName("identicalMemoryLayout")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$optimalDeviceAccess = PathElement.groupElement("optimalDeviceAccess");
    public static final PathElement PATH$identicalMemoryLayout = PathElement.groupElement("identicalMemoryLayout");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$optimalDeviceAccess = (OfInt) LAYOUT.select(PATH$optimalDeviceAccess);
    public static final OfInt LAYOUT$identicalMemoryLayout = (OfInt) LAYOUT.select(PATH$identicalMemoryLayout);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$optimalDeviceAccess = LAYOUT$optimalDeviceAccess.byteSize();
    public static final long SIZE$identicalMemoryLayout = LAYOUT$identicalMemoryLayout.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$optimalDeviceAccess = LAYOUT.byteOffset(PATH$optimalDeviceAccess);
    public static final long OFFSET$identicalMemoryLayout = LAYOUT.byteOffset(PATH$identicalMemoryLayout);
}
