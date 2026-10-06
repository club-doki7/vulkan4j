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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM.html"><code>VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     uint64_t shaderCoreMask; // @link substring="shaderCoreMask" target="#shaderCoreMask"
///     uint32_t shaderCoreCount; // @link substring="shaderCoreCount" target="#shaderCoreCount"
///     uint32_t shaderWarpsPerCore; // @link substring="shaderWarpsPerCore" target="#shaderWarpsPerCore"
/// } VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SHADER_CORE_BUILTINS_PROPERTIES_ARM`
///
/// The {@code allocate} ({@link VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM#allocate(Arena)}, {@link VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM.html"><code>VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM(@NotNull MemorySegment segment) implements IVkPhysicalDeviceShaderCoreBuiltinsPropertiesARM {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM.html"><code>VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceShaderCoreBuiltinsPropertiesARM to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceShaderCoreBuiltinsPropertiesARM, Iterable<VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM at(long index) {
            return new VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM(segment.asSlice(index * VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM.BYTES, VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM.BYTES));
        }

        public VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM.BYTES, VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM.BYTES,
                (end - start) * VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM.BYTES));
        }

        public VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM[] toArray() {
            VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM[] ret = new VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM.BYTES;
            }

            @Override
            public VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM ret = new VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM(segment.asSlice(0, VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM allocate(Arena arena) {
        VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM ret = new VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_SHADER_CORE_BUILTINS_PROPERTIES_ARM);
        return ret;
    }

    public static VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM.Ptr ret = new VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_SHADER_CORE_BUILTINS_PROPERTIES_ARM);
        }
        return ret;
    }

    public static VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM clone(Arena arena, VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM src) {
        VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_SHADER_CORE_BUILTINS_PROPERTIES_ARM);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Unsigned long shaderCoreMask() {
        return segment.get(LAYOUT$shaderCoreMask, OFFSET$shaderCoreMask);
    }

    public VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM shaderCoreMask(@Unsigned long value) {
        segment.set(LAYOUT$shaderCoreMask, OFFSET$shaderCoreMask, value);
        return this;
    }

    public @Unsigned int shaderCoreCount() {
        return segment.get(LAYOUT$shaderCoreCount, OFFSET$shaderCoreCount);
    }

    public VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM shaderCoreCount(@Unsigned int value) {
        segment.set(LAYOUT$shaderCoreCount, OFFSET$shaderCoreCount, value);
        return this;
    }

    public @Unsigned int shaderWarpsPerCore() {
        return segment.get(LAYOUT$shaderWarpsPerCore, OFFSET$shaderWarpsPerCore);
    }

    public VkPhysicalDeviceShaderCoreBuiltinsPropertiesARM shaderWarpsPerCore(@Unsigned int value) {
        segment.set(LAYOUT$shaderWarpsPerCore, OFFSET$shaderWarpsPerCore, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_LONG.withName("shaderCoreMask"),
        ValueLayout.JAVA_INT.withName("shaderCoreCount"),
        ValueLayout.JAVA_INT.withName("shaderWarpsPerCore")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$shaderCoreMask = PathElement.groupElement("shaderCoreMask");
    public static final PathElement PATH$shaderCoreCount = PathElement.groupElement("shaderCoreCount");
    public static final PathElement PATH$shaderWarpsPerCore = PathElement.groupElement("shaderWarpsPerCore");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfLong LAYOUT$shaderCoreMask = (OfLong) LAYOUT.select(PATH$shaderCoreMask);
    public static final OfInt LAYOUT$shaderCoreCount = (OfInt) LAYOUT.select(PATH$shaderCoreCount);
    public static final OfInt LAYOUT$shaderWarpsPerCore = (OfInt) LAYOUT.select(PATH$shaderWarpsPerCore);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$shaderCoreMask = LAYOUT$shaderCoreMask.byteSize();
    public static final long SIZE$shaderCoreCount = LAYOUT$shaderCoreCount.byteSize();
    public static final long SIZE$shaderWarpsPerCore = LAYOUT$shaderWarpsPerCore.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$shaderCoreMask = LAYOUT.byteOffset(PATH$shaderCoreMask);
    public static final long OFFSET$shaderCoreCount = LAYOUT.byteOffset(PATH$shaderCoreCount);
    public static final long OFFSET$shaderWarpsPerCore = LAYOUT.byteOffset(PATH$shaderWarpsPerCore);
}
