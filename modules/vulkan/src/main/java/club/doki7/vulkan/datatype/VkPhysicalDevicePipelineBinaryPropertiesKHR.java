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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDevicePipelineBinaryPropertiesKHR.html"><code>VkPhysicalDevicePipelineBinaryPropertiesKHR</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDevicePipelineBinaryPropertiesKHR {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 pipelineBinaryInternalCache; // @link substring="pipelineBinaryInternalCache" target="#pipelineBinaryInternalCache"
///     VkBool32 pipelineBinaryInternalCacheControl; // @link substring="pipelineBinaryInternalCacheControl" target="#pipelineBinaryInternalCacheControl"
///     VkBool32 pipelineBinaryPrefersInternalCache; // @link substring="pipelineBinaryPrefersInternalCache" target="#pipelineBinaryPrefersInternalCache"
///     VkBool32 pipelineBinaryPrecompiledInternalCache; // @link substring="pipelineBinaryPrecompiledInternalCache" target="#pipelineBinaryPrecompiledInternalCache"
///     VkBool32 pipelineBinaryCompressedData; // @link substring="pipelineBinaryCompressedData" target="#pipelineBinaryCompressedData"
/// } VkPhysicalDevicePipelineBinaryPropertiesKHR;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_PIPELINE_BINARY_PROPERTIES_KHR`
///
/// The {@code allocate} ({@link VkPhysicalDevicePipelineBinaryPropertiesKHR#allocate(Arena)}, {@link VkPhysicalDevicePipelineBinaryPropertiesKHR#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDevicePipelineBinaryPropertiesKHR#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDevicePipelineBinaryPropertiesKHR.html"><code>VkPhysicalDevicePipelineBinaryPropertiesKHR</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDevicePipelineBinaryPropertiesKHR(@NotNull MemorySegment segment) implements IVkPhysicalDevicePipelineBinaryPropertiesKHR {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDevicePipelineBinaryPropertiesKHR.html"><code>VkPhysicalDevicePipelineBinaryPropertiesKHR</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDevicePipelineBinaryPropertiesKHR}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDevicePipelineBinaryPropertiesKHR to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDevicePipelineBinaryPropertiesKHR.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDevicePipelineBinaryPropertiesKHR, Iterable<VkPhysicalDevicePipelineBinaryPropertiesKHR> {
        public long size() {
            return segment.byteSize() / VkPhysicalDevicePipelineBinaryPropertiesKHR.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDevicePipelineBinaryPropertiesKHR at(long index) {
            return new VkPhysicalDevicePipelineBinaryPropertiesKHR(segment.asSlice(index * VkPhysicalDevicePipelineBinaryPropertiesKHR.BYTES, VkPhysicalDevicePipelineBinaryPropertiesKHR.BYTES));
        }

        public VkPhysicalDevicePipelineBinaryPropertiesKHR.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDevicePipelineBinaryPropertiesKHR> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDevicePipelineBinaryPropertiesKHR value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDevicePipelineBinaryPropertiesKHR.BYTES, VkPhysicalDevicePipelineBinaryPropertiesKHR.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDevicePipelineBinaryPropertiesKHR.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDevicePipelineBinaryPropertiesKHR.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDevicePipelineBinaryPropertiesKHR.BYTES,
                (end - start) * VkPhysicalDevicePipelineBinaryPropertiesKHR.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDevicePipelineBinaryPropertiesKHR.BYTES));
        }

        public VkPhysicalDevicePipelineBinaryPropertiesKHR[] toArray() {
            VkPhysicalDevicePipelineBinaryPropertiesKHR[] ret = new VkPhysicalDevicePipelineBinaryPropertiesKHR[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDevicePipelineBinaryPropertiesKHR> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDevicePipelineBinaryPropertiesKHR> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDevicePipelineBinaryPropertiesKHR.BYTES;
            }

            @Override
            public VkPhysicalDevicePipelineBinaryPropertiesKHR next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDevicePipelineBinaryPropertiesKHR ret = new VkPhysicalDevicePipelineBinaryPropertiesKHR(segment.asSlice(0, VkPhysicalDevicePipelineBinaryPropertiesKHR.BYTES));
                segment = segment.asSlice(VkPhysicalDevicePipelineBinaryPropertiesKHR.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDevicePipelineBinaryPropertiesKHR allocate(Arena arena) {
        VkPhysicalDevicePipelineBinaryPropertiesKHR ret = new VkPhysicalDevicePipelineBinaryPropertiesKHR(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_PIPELINE_BINARY_PROPERTIES_KHR);
        return ret;
    }

    public static VkPhysicalDevicePipelineBinaryPropertiesKHR.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDevicePipelineBinaryPropertiesKHR.Ptr ret = new VkPhysicalDevicePipelineBinaryPropertiesKHR.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_PIPELINE_BINARY_PROPERTIES_KHR);
        }
        return ret;
    }

    public static VkPhysicalDevicePipelineBinaryPropertiesKHR clone(Arena arena, VkPhysicalDevicePipelineBinaryPropertiesKHR src) {
        VkPhysicalDevicePipelineBinaryPropertiesKHR ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_PIPELINE_BINARY_PROPERTIES_KHR);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDevicePipelineBinaryPropertiesKHR sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDevicePipelineBinaryPropertiesKHR pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDevicePipelineBinaryPropertiesKHR pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int pipelineBinaryInternalCache() {
        return segment.get(LAYOUT$pipelineBinaryInternalCache, OFFSET$pipelineBinaryInternalCache);
    }

    public VkPhysicalDevicePipelineBinaryPropertiesKHR pipelineBinaryInternalCache(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$pipelineBinaryInternalCache, OFFSET$pipelineBinaryInternalCache, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int pipelineBinaryInternalCacheControl() {
        return segment.get(LAYOUT$pipelineBinaryInternalCacheControl, OFFSET$pipelineBinaryInternalCacheControl);
    }

    public VkPhysicalDevicePipelineBinaryPropertiesKHR pipelineBinaryInternalCacheControl(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$pipelineBinaryInternalCacheControl, OFFSET$pipelineBinaryInternalCacheControl, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int pipelineBinaryPrefersInternalCache() {
        return segment.get(LAYOUT$pipelineBinaryPrefersInternalCache, OFFSET$pipelineBinaryPrefersInternalCache);
    }

    public VkPhysicalDevicePipelineBinaryPropertiesKHR pipelineBinaryPrefersInternalCache(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$pipelineBinaryPrefersInternalCache, OFFSET$pipelineBinaryPrefersInternalCache, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int pipelineBinaryPrecompiledInternalCache() {
        return segment.get(LAYOUT$pipelineBinaryPrecompiledInternalCache, OFFSET$pipelineBinaryPrecompiledInternalCache);
    }

    public VkPhysicalDevicePipelineBinaryPropertiesKHR pipelineBinaryPrecompiledInternalCache(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$pipelineBinaryPrecompiledInternalCache, OFFSET$pipelineBinaryPrecompiledInternalCache, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int pipelineBinaryCompressedData() {
        return segment.get(LAYOUT$pipelineBinaryCompressedData, OFFSET$pipelineBinaryCompressedData);
    }

    public VkPhysicalDevicePipelineBinaryPropertiesKHR pipelineBinaryCompressedData(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$pipelineBinaryCompressedData, OFFSET$pipelineBinaryCompressedData, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("pipelineBinaryInternalCache"),
        ValueLayout.JAVA_INT.withName("pipelineBinaryInternalCacheControl"),
        ValueLayout.JAVA_INT.withName("pipelineBinaryPrefersInternalCache"),
        ValueLayout.JAVA_INT.withName("pipelineBinaryPrecompiledInternalCache"),
        ValueLayout.JAVA_INT.withName("pipelineBinaryCompressedData")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$pipelineBinaryInternalCache = PathElement.groupElement("pipelineBinaryInternalCache");
    public static final PathElement PATH$pipelineBinaryInternalCacheControl = PathElement.groupElement("pipelineBinaryInternalCacheControl");
    public static final PathElement PATH$pipelineBinaryPrefersInternalCache = PathElement.groupElement("pipelineBinaryPrefersInternalCache");
    public static final PathElement PATH$pipelineBinaryPrecompiledInternalCache = PathElement.groupElement("pipelineBinaryPrecompiledInternalCache");
    public static final PathElement PATH$pipelineBinaryCompressedData = PathElement.groupElement("pipelineBinaryCompressedData");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$pipelineBinaryInternalCache = (OfInt) LAYOUT.select(PATH$pipelineBinaryInternalCache);
    public static final OfInt LAYOUT$pipelineBinaryInternalCacheControl = (OfInt) LAYOUT.select(PATH$pipelineBinaryInternalCacheControl);
    public static final OfInt LAYOUT$pipelineBinaryPrefersInternalCache = (OfInt) LAYOUT.select(PATH$pipelineBinaryPrefersInternalCache);
    public static final OfInt LAYOUT$pipelineBinaryPrecompiledInternalCache = (OfInt) LAYOUT.select(PATH$pipelineBinaryPrecompiledInternalCache);
    public static final OfInt LAYOUT$pipelineBinaryCompressedData = (OfInt) LAYOUT.select(PATH$pipelineBinaryCompressedData);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$pipelineBinaryInternalCache = LAYOUT$pipelineBinaryInternalCache.byteSize();
    public static final long SIZE$pipelineBinaryInternalCacheControl = LAYOUT$pipelineBinaryInternalCacheControl.byteSize();
    public static final long SIZE$pipelineBinaryPrefersInternalCache = LAYOUT$pipelineBinaryPrefersInternalCache.byteSize();
    public static final long SIZE$pipelineBinaryPrecompiledInternalCache = LAYOUT$pipelineBinaryPrecompiledInternalCache.byteSize();
    public static final long SIZE$pipelineBinaryCompressedData = LAYOUT$pipelineBinaryCompressedData.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$pipelineBinaryInternalCache = LAYOUT.byteOffset(PATH$pipelineBinaryInternalCache);
    public static final long OFFSET$pipelineBinaryInternalCacheControl = LAYOUT.byteOffset(PATH$pipelineBinaryInternalCacheControl);
    public static final long OFFSET$pipelineBinaryPrefersInternalCache = LAYOUT.byteOffset(PATH$pipelineBinaryPrefersInternalCache);
    public static final long OFFSET$pipelineBinaryPrecompiledInternalCache = LAYOUT.byteOffset(PATH$pipelineBinaryPrecompiledInternalCache);
    public static final long OFFSET$pipelineBinaryCompressedData = LAYOUT.byteOffset(PATH$pipelineBinaryCompressedData);
}
