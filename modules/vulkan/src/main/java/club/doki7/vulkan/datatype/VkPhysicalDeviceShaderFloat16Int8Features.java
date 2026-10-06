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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceShaderFloat16Int8Features.html"><code>VkPhysicalDeviceShaderFloat16Int8Features</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceShaderFloat16Int8Features {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 shaderFloat16; // @link substring="shaderFloat16" target="#shaderFloat16"
///     VkBool32 shaderInt8; // @link substring="shaderInt8" target="#shaderInt8"
/// } VkPhysicalDeviceShaderFloat16Int8Features;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SHADER_FLOAT16_INT8_FEATURES`
///
/// The {@code allocate} ({@link VkPhysicalDeviceShaderFloat16Int8Features#allocate(Arena)}, {@link VkPhysicalDeviceShaderFloat16Int8Features#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceShaderFloat16Int8Features#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceShaderFloat16Int8Features.html"><code>VkPhysicalDeviceShaderFloat16Int8Features</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceShaderFloat16Int8Features(@NotNull MemorySegment segment) implements IVkPhysicalDeviceShaderFloat16Int8Features {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceShaderFloat16Int8Features.html"><code>VkPhysicalDeviceShaderFloat16Int8Features</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceShaderFloat16Int8Features}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceShaderFloat16Int8Features to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceShaderFloat16Int8Features.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceShaderFloat16Int8Features, Iterable<VkPhysicalDeviceShaderFloat16Int8Features> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceShaderFloat16Int8Features.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceShaderFloat16Int8Features at(long index) {
            return new VkPhysicalDeviceShaderFloat16Int8Features(segment.asSlice(index * VkPhysicalDeviceShaderFloat16Int8Features.BYTES, VkPhysicalDeviceShaderFloat16Int8Features.BYTES));
        }

        public VkPhysicalDeviceShaderFloat16Int8Features.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceShaderFloat16Int8Features> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceShaderFloat16Int8Features value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceShaderFloat16Int8Features.BYTES, VkPhysicalDeviceShaderFloat16Int8Features.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceShaderFloat16Int8Features.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceShaderFloat16Int8Features.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceShaderFloat16Int8Features.BYTES,
                (end - start) * VkPhysicalDeviceShaderFloat16Int8Features.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceShaderFloat16Int8Features.BYTES));
        }

        public VkPhysicalDeviceShaderFloat16Int8Features[] toArray() {
            VkPhysicalDeviceShaderFloat16Int8Features[] ret = new VkPhysicalDeviceShaderFloat16Int8Features[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceShaderFloat16Int8Features> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceShaderFloat16Int8Features> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceShaderFloat16Int8Features.BYTES;
            }

            @Override
            public VkPhysicalDeviceShaderFloat16Int8Features next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceShaderFloat16Int8Features ret = new VkPhysicalDeviceShaderFloat16Int8Features(segment.asSlice(0, VkPhysicalDeviceShaderFloat16Int8Features.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceShaderFloat16Int8Features.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceShaderFloat16Int8Features allocate(Arena arena) {
        VkPhysicalDeviceShaderFloat16Int8Features ret = new VkPhysicalDeviceShaderFloat16Int8Features(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_SHADER_FLOAT16_INT8_FEATURES);
        return ret;
    }

    public static VkPhysicalDeviceShaderFloat16Int8Features.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceShaderFloat16Int8Features.Ptr ret = new VkPhysicalDeviceShaderFloat16Int8Features.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_SHADER_FLOAT16_INT8_FEATURES);
        }
        return ret;
    }

    public static VkPhysicalDeviceShaderFloat16Int8Features clone(Arena arena, VkPhysicalDeviceShaderFloat16Int8Features src) {
        VkPhysicalDeviceShaderFloat16Int8Features ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_SHADER_FLOAT16_INT8_FEATURES);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceShaderFloat16Int8Features sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceShaderFloat16Int8Features pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceShaderFloat16Int8Features pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderFloat16() {
        return segment.get(LAYOUT$shaderFloat16, OFFSET$shaderFloat16);
    }

    public VkPhysicalDeviceShaderFloat16Int8Features shaderFloat16(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderFloat16, OFFSET$shaderFloat16, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int shaderInt8() {
        return segment.get(LAYOUT$shaderInt8, OFFSET$shaderInt8);
    }

    public VkPhysicalDeviceShaderFloat16Int8Features shaderInt8(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$shaderInt8, OFFSET$shaderInt8, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("shaderFloat16"),
        ValueLayout.JAVA_INT.withName("shaderInt8")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$shaderFloat16 = PathElement.groupElement("shaderFloat16");
    public static final PathElement PATH$shaderInt8 = PathElement.groupElement("shaderInt8");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$shaderFloat16 = (OfInt) LAYOUT.select(PATH$shaderFloat16);
    public static final OfInt LAYOUT$shaderInt8 = (OfInt) LAYOUT.select(PATH$shaderInt8);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$shaderFloat16 = LAYOUT$shaderFloat16.byteSize();
    public static final long SIZE$shaderInt8 = LAYOUT$shaderInt8.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$shaderFloat16 = LAYOUT.byteOffset(PATH$shaderFloat16);
    public static final long OFFSET$shaderInt8 = LAYOUT.byteOffset(PATH$shaderInt8);
}
