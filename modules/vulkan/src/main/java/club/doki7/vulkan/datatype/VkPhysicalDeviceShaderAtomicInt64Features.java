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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceShaderAtomicInt64Features.html"><code>VkPhysicalDeviceShaderAtomicInt64Features</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceShaderAtomicInt64Features {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 shaderBufferInt64Atomics; // @link substring="shaderBufferInt64Atomics" target="#shaderBufferInt64Atomics"
///     VkBool32 shaderSharedInt64Atomics; // @link substring="shaderSharedInt64Atomics" target="#shaderSharedInt64Atomics"
/// } VkPhysicalDeviceShaderAtomicInt64Features;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SHADER_ATOMIC_INT64_FEATURES`
///
/// The {@code allocate} ({@link VkPhysicalDeviceShaderAtomicInt64Features#allocate(Arena)}, {@link VkPhysicalDeviceShaderAtomicInt64Features#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceShaderAtomicInt64Features#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceShaderAtomicInt64Features.html"><code>VkPhysicalDeviceShaderAtomicInt64Features</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceShaderAtomicInt64Features(@NotNull MemorySegment segment) implements IVkPhysicalDeviceShaderAtomicInt64Features {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceShaderAtomicInt64Features.html"><code>VkPhysicalDeviceShaderAtomicInt64Features</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceShaderAtomicInt64Features}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceShaderAtomicInt64Features to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceShaderAtomicInt64Features.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceShaderAtomicInt64Features, Iterable<VkPhysicalDeviceShaderAtomicInt64Features> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceShaderAtomicInt64Features.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceShaderAtomicInt64Features at(long index) {
            return new VkPhysicalDeviceShaderAtomicInt64Features(segment.asSlice(index * VkPhysicalDeviceShaderAtomicInt64Features.BYTES, VkPhysicalDeviceShaderAtomicInt64Features.BYTES));
        }

        public VkPhysicalDeviceShaderAtomicInt64Features.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceShaderAtomicInt64Features> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceShaderAtomicInt64Features value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceShaderAtomicInt64Features.BYTES, VkPhysicalDeviceShaderAtomicInt64Features.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceShaderAtomicInt64Features.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceShaderAtomicInt64Features.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceShaderAtomicInt64Features.BYTES,
                (end - start) * VkPhysicalDeviceShaderAtomicInt64Features.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceShaderAtomicInt64Features.BYTES));
        }

        public VkPhysicalDeviceShaderAtomicInt64Features[] toArray() {
            VkPhysicalDeviceShaderAtomicInt64Features[] ret = new VkPhysicalDeviceShaderAtomicInt64Features[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceShaderAtomicInt64Features> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceShaderAtomicInt64Features> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceShaderAtomicInt64Features.BYTES;
            }

            @Override
            public VkPhysicalDeviceShaderAtomicInt64Features next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceShaderAtomicInt64Features ret = new VkPhysicalDeviceShaderAtomicInt64Features(segment.asSlice(0, VkPhysicalDeviceShaderAtomicInt64Features.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceShaderAtomicInt64Features.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceShaderAtomicInt64Features allocate(Arena arena) {
        VkPhysicalDeviceShaderAtomicInt64Features ret = new VkPhysicalDeviceShaderAtomicInt64Features(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_SHADER_ATOMIC_INT64_FEATURES);
        return ret;
    }

    public static VkPhysicalDeviceShaderAtomicInt64Features.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceShaderAtomicInt64Features.Ptr ret = new VkPhysicalDeviceShaderAtomicInt64Features.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_SHADER_ATOMIC_INT64_FEATURES);
        }
        return ret;
    }

    public static VkPhysicalDeviceShaderAtomicInt64Features clone(Arena arena, VkPhysicalDeviceShaderAtomicInt64Features src) {
        VkPhysicalDeviceShaderAtomicInt64Features ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_SHADER_ATOMIC_INT64_FEATURES);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceShaderAtomicInt64Features sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceShaderAtomicInt64Features pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceShaderAtomicInt64Features pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderBufferInt64Atomics() {
        return segment.get(LAYOUT$shaderBufferInt64Atomics, OFFSET$shaderBufferInt64Atomics);
    }

    public VkPhysicalDeviceShaderAtomicInt64Features shaderBufferInt64Atomics(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderBufferInt64Atomics, OFFSET$shaderBufferInt64Atomics, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderSharedInt64Atomics() {
        return segment.get(LAYOUT$shaderSharedInt64Atomics, OFFSET$shaderSharedInt64Atomics);
    }

    public VkPhysicalDeviceShaderAtomicInt64Features shaderSharedInt64Atomics(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderSharedInt64Atomics, OFFSET$shaderSharedInt64Atomics, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("shaderBufferInt64Atomics"),
        ValueLayout.JAVA_INT.withName("shaderSharedInt64Atomics")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$shaderBufferInt64Atomics = PathElement.groupElement("shaderBufferInt64Atomics");
    public static final PathElement PATH$shaderSharedInt64Atomics = PathElement.groupElement("shaderSharedInt64Atomics");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$shaderBufferInt64Atomics = (OfInt) LAYOUT.select(PATH$shaderBufferInt64Atomics);
    public static final OfInt LAYOUT$shaderSharedInt64Atomics = (OfInt) LAYOUT.select(PATH$shaderSharedInt64Atomics);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$shaderBufferInt64Atomics = LAYOUT$shaderBufferInt64Atomics.byteSize();
    public static final long SIZE$shaderSharedInt64Atomics = LAYOUT$shaderSharedInt64Atomics.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$shaderBufferInt64Atomics = LAYOUT.byteOffset(PATH$shaderBufferInt64Atomics);
    public static final long OFFSET$shaderSharedInt64Atomics = LAYOUT.byteOffset(PATH$shaderSharedInt64Atomics);
}
