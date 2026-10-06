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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceShaderIntegerDotProductProperties.html"><code>VkPhysicalDeviceShaderIntegerDotProductProperties</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkPhysicalDeviceShaderIntegerDotProductProperties {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkBool32 integerDotProduct8BitUnsignedAccelerated; // @link substring="integerDotProduct8BitUnsignedAccelerated" target="#integerDotProduct8BitUnsignedAccelerated"
///     VkBool32 integerDotProduct8BitSignedAccelerated; // @link substring="integerDotProduct8BitSignedAccelerated" target="#integerDotProduct8BitSignedAccelerated"
///     VkBool32 integerDotProduct8BitMixedSignednessAccelerated; // @link substring="integerDotProduct8BitMixedSignednessAccelerated" target="#integerDotProduct8BitMixedSignednessAccelerated"
///     VkBool32 integerDotProduct4x8BitPackedUnsignedAccelerated; // @link substring="integerDotProduct4x8BitPackedUnsignedAccelerated" target="#integerDotProduct4x8BitPackedUnsignedAccelerated"
///     VkBool32 integerDotProduct4x8BitPackedSignedAccelerated; // @link substring="integerDotProduct4x8BitPackedSignedAccelerated" target="#integerDotProduct4x8BitPackedSignedAccelerated"
///     VkBool32 integerDotProduct4x8BitPackedMixedSignednessAccelerated; // @link substring="integerDotProduct4x8BitPackedMixedSignednessAccelerated" target="#integerDotProduct4x8BitPackedMixedSignednessAccelerated"
///     VkBool32 integerDotProduct16BitUnsignedAccelerated; // @link substring="integerDotProduct16BitUnsignedAccelerated" target="#integerDotProduct16BitUnsignedAccelerated"
///     VkBool32 integerDotProduct16BitSignedAccelerated; // @link substring="integerDotProduct16BitSignedAccelerated" target="#integerDotProduct16BitSignedAccelerated"
///     VkBool32 integerDotProduct16BitMixedSignednessAccelerated; // @link substring="integerDotProduct16BitMixedSignednessAccelerated" target="#integerDotProduct16BitMixedSignednessAccelerated"
///     VkBool32 integerDotProduct32BitUnsignedAccelerated; // @link substring="integerDotProduct32BitUnsignedAccelerated" target="#integerDotProduct32BitUnsignedAccelerated"
///     VkBool32 integerDotProduct32BitSignedAccelerated; // @link substring="integerDotProduct32BitSignedAccelerated" target="#integerDotProduct32BitSignedAccelerated"
///     VkBool32 integerDotProduct32BitMixedSignednessAccelerated; // @link substring="integerDotProduct32BitMixedSignednessAccelerated" target="#integerDotProduct32BitMixedSignednessAccelerated"
///     VkBool32 integerDotProduct64BitUnsignedAccelerated; // @link substring="integerDotProduct64BitUnsignedAccelerated" target="#integerDotProduct64BitUnsignedAccelerated"
///     VkBool32 integerDotProduct64BitSignedAccelerated; // @link substring="integerDotProduct64BitSignedAccelerated" target="#integerDotProduct64BitSignedAccelerated"
///     VkBool32 integerDotProduct64BitMixedSignednessAccelerated; // @link substring="integerDotProduct64BitMixedSignednessAccelerated" target="#integerDotProduct64BitMixedSignednessAccelerated"
///     VkBool32 integerDotProductAccumulatingSaturating8BitUnsignedAccelerated; // @link substring="integerDotProductAccumulatingSaturating8BitUnsignedAccelerated" target="#integerDotProductAccumulatingSaturating8BitUnsignedAccelerated"
///     VkBool32 integerDotProductAccumulatingSaturating8BitSignedAccelerated; // @link substring="integerDotProductAccumulatingSaturating8BitSignedAccelerated" target="#integerDotProductAccumulatingSaturating8BitSignedAccelerated"
///     VkBool32 integerDotProductAccumulatingSaturating8BitMixedSignednessAccelerated; // @link substring="integerDotProductAccumulatingSaturating8BitMixedSignednessAccelerated" target="#integerDotProductAccumulatingSaturating8BitMixedSignednessAccelerated"
///     VkBool32 integerDotProductAccumulatingSaturating4x8BitPackedUnsignedAccelerated; // @link substring="integerDotProductAccumulatingSaturating4x8BitPackedUnsignedAccelerated" target="#integerDotProductAccumulatingSaturating4x8BitPackedUnsignedAccelerated"
///     VkBool32 integerDotProductAccumulatingSaturating4x8BitPackedSignedAccelerated; // @link substring="integerDotProductAccumulatingSaturating4x8BitPackedSignedAccelerated" target="#integerDotProductAccumulatingSaturating4x8BitPackedSignedAccelerated"
///     VkBool32 integerDotProductAccumulatingSaturating4x8BitPackedMixedSignednessAccelerated; // @link substring="integerDotProductAccumulatingSaturating4x8BitPackedMixedSignednessAccelerated" target="#integerDotProductAccumulatingSaturating4x8BitPackedMixedSignednessAccelerated"
///     VkBool32 integerDotProductAccumulatingSaturating16BitUnsignedAccelerated; // @link substring="integerDotProductAccumulatingSaturating16BitUnsignedAccelerated" target="#integerDotProductAccumulatingSaturating16BitUnsignedAccelerated"
///     VkBool32 integerDotProductAccumulatingSaturating16BitSignedAccelerated; // @link substring="integerDotProductAccumulatingSaturating16BitSignedAccelerated" target="#integerDotProductAccumulatingSaturating16BitSignedAccelerated"
///     VkBool32 integerDotProductAccumulatingSaturating16BitMixedSignednessAccelerated; // @link substring="integerDotProductAccumulatingSaturating16BitMixedSignednessAccelerated" target="#integerDotProductAccumulatingSaturating16BitMixedSignednessAccelerated"
///     VkBool32 integerDotProductAccumulatingSaturating32BitUnsignedAccelerated; // @link substring="integerDotProductAccumulatingSaturating32BitUnsignedAccelerated" target="#integerDotProductAccumulatingSaturating32BitUnsignedAccelerated"
///     VkBool32 integerDotProductAccumulatingSaturating32BitSignedAccelerated; // @link substring="integerDotProductAccumulatingSaturating32BitSignedAccelerated" target="#integerDotProductAccumulatingSaturating32BitSignedAccelerated"
///     VkBool32 integerDotProductAccumulatingSaturating32BitMixedSignednessAccelerated; // @link substring="integerDotProductAccumulatingSaturating32BitMixedSignednessAccelerated" target="#integerDotProductAccumulatingSaturating32BitMixedSignednessAccelerated"
///     VkBool32 integerDotProductAccumulatingSaturating64BitUnsignedAccelerated; // @link substring="integerDotProductAccumulatingSaturating64BitUnsignedAccelerated" target="#integerDotProductAccumulatingSaturating64BitUnsignedAccelerated"
///     VkBool32 integerDotProductAccumulatingSaturating64BitSignedAccelerated; // @link substring="integerDotProductAccumulatingSaturating64BitSignedAccelerated" target="#integerDotProductAccumulatingSaturating64BitSignedAccelerated"
///     VkBool32 integerDotProductAccumulatingSaturating64BitMixedSignednessAccelerated; // @link substring="integerDotProductAccumulatingSaturating64BitMixedSignednessAccelerated" target="#integerDotProductAccumulatingSaturating64BitMixedSignednessAccelerated"
/// } VkPhysicalDeviceShaderIntegerDotProductProperties;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_SHADER_INTEGER_DOT_PRODUCT_PROPERTIES`
///
/// The {@code allocate} ({@link VkPhysicalDeviceShaderIntegerDotProductProperties#allocate(Arena)}, {@link VkPhysicalDeviceShaderIntegerDotProductProperties#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkPhysicalDeviceShaderIntegerDotProductProperties#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceShaderIntegerDotProductProperties.html"><code>VkPhysicalDeviceShaderIntegerDotProductProperties</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkPhysicalDeviceShaderIntegerDotProductProperties(@NotNull MemorySegment segment) implements IVkPhysicalDeviceShaderIntegerDotProductProperties {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkPhysicalDeviceShaderIntegerDotProductProperties.html"><code>VkPhysicalDeviceShaderIntegerDotProductProperties</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkPhysicalDeviceShaderIntegerDotProductProperties}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkPhysicalDeviceShaderIntegerDotProductProperties to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkPhysicalDeviceShaderIntegerDotProductProperties.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkPhysicalDeviceShaderIntegerDotProductProperties, Iterable<VkPhysicalDeviceShaderIntegerDotProductProperties> {
        public long size() {
            return segment.byteSize() / VkPhysicalDeviceShaderIntegerDotProductProperties.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkPhysicalDeviceShaderIntegerDotProductProperties at(long index) {
            return new VkPhysicalDeviceShaderIntegerDotProductProperties(segment.asSlice(index * VkPhysicalDeviceShaderIntegerDotProductProperties.BYTES, VkPhysicalDeviceShaderIntegerDotProductProperties.BYTES));
        }

        public VkPhysicalDeviceShaderIntegerDotProductProperties.Ptr at(long index, @NotNull Consumer<@NotNull VkPhysicalDeviceShaderIntegerDotProductProperties> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkPhysicalDeviceShaderIntegerDotProductProperties value) {
            MemorySegment s = segment.asSlice(index * VkPhysicalDeviceShaderIntegerDotProductProperties.BYTES, VkPhysicalDeviceShaderIntegerDotProductProperties.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkPhysicalDeviceShaderIntegerDotProductProperties.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkPhysicalDeviceShaderIntegerDotProductProperties.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkPhysicalDeviceShaderIntegerDotProductProperties.BYTES,
                (end - start) * VkPhysicalDeviceShaderIntegerDotProductProperties.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkPhysicalDeviceShaderIntegerDotProductProperties.BYTES));
        }

        public VkPhysicalDeviceShaderIntegerDotProductProperties[] toArray() {
            VkPhysicalDeviceShaderIntegerDotProductProperties[] ret = new VkPhysicalDeviceShaderIntegerDotProductProperties[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkPhysicalDeviceShaderIntegerDotProductProperties> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkPhysicalDeviceShaderIntegerDotProductProperties> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkPhysicalDeviceShaderIntegerDotProductProperties.BYTES;
            }

            @Override
            public VkPhysicalDeviceShaderIntegerDotProductProperties next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkPhysicalDeviceShaderIntegerDotProductProperties ret = new VkPhysicalDeviceShaderIntegerDotProductProperties(segment.asSlice(0, VkPhysicalDeviceShaderIntegerDotProductProperties.BYTES));
                segment = segment.asSlice(VkPhysicalDeviceShaderIntegerDotProductProperties.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkPhysicalDeviceShaderIntegerDotProductProperties allocate(Arena arena) {
        VkPhysicalDeviceShaderIntegerDotProductProperties ret = new VkPhysicalDeviceShaderIntegerDotProductProperties(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.PHYSICAL_DEVICE_SHADER_INTEGER_DOT_PRODUCT_PROPERTIES);
        return ret;
    }

    public static VkPhysicalDeviceShaderIntegerDotProductProperties.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkPhysicalDeviceShaderIntegerDotProductProperties.Ptr ret = new VkPhysicalDeviceShaderIntegerDotProductProperties.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.PHYSICAL_DEVICE_SHADER_INTEGER_DOT_PRODUCT_PROPERTIES);
        }
        return ret;
    }

    public static VkPhysicalDeviceShaderIntegerDotProductProperties clone(Arena arena, VkPhysicalDeviceShaderIntegerDotProductProperties src) {
        VkPhysicalDeviceShaderIntegerDotProductProperties ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.PHYSICAL_DEVICE_SHADER_INTEGER_DOT_PRODUCT_PROPERTIES);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkPhysicalDeviceShaderIntegerDotProductProperties sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkPhysicalDeviceShaderIntegerDotProductProperties pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkPhysicalDeviceShaderIntegerDotProductProperties pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int integerDotProduct8BitUnsignedAccelerated() {
        return segment.get(LAYOUT$integerDotProduct8BitUnsignedAccelerated, OFFSET$integerDotProduct8BitUnsignedAccelerated);
    }

    public VkPhysicalDeviceShaderIntegerDotProductProperties integerDotProduct8BitUnsignedAccelerated(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$integerDotProduct8BitUnsignedAccelerated, OFFSET$integerDotProduct8BitUnsignedAccelerated, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int integerDotProduct8BitSignedAccelerated() {
        return segment.get(LAYOUT$integerDotProduct8BitSignedAccelerated, OFFSET$integerDotProduct8BitSignedAccelerated);
    }

    public VkPhysicalDeviceShaderIntegerDotProductProperties integerDotProduct8BitSignedAccelerated(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$integerDotProduct8BitSignedAccelerated, OFFSET$integerDotProduct8BitSignedAccelerated, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int integerDotProduct8BitMixedSignednessAccelerated() {
        return segment.get(LAYOUT$integerDotProduct8BitMixedSignednessAccelerated, OFFSET$integerDotProduct8BitMixedSignednessAccelerated);
    }

    public VkPhysicalDeviceShaderIntegerDotProductProperties integerDotProduct8BitMixedSignednessAccelerated(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$integerDotProduct8BitMixedSignednessAccelerated, OFFSET$integerDotProduct8BitMixedSignednessAccelerated, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int integerDotProduct4x8BitPackedUnsignedAccelerated() {
        return segment.get(LAYOUT$integerDotProduct4x8BitPackedUnsignedAccelerated, OFFSET$integerDotProduct4x8BitPackedUnsignedAccelerated);
    }

    public VkPhysicalDeviceShaderIntegerDotProductProperties integerDotProduct4x8BitPackedUnsignedAccelerated(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$integerDotProduct4x8BitPackedUnsignedAccelerated, OFFSET$integerDotProduct4x8BitPackedUnsignedAccelerated, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int integerDotProduct4x8BitPackedSignedAccelerated() {
        return segment.get(LAYOUT$integerDotProduct4x8BitPackedSignedAccelerated, OFFSET$integerDotProduct4x8BitPackedSignedAccelerated);
    }

    public VkPhysicalDeviceShaderIntegerDotProductProperties integerDotProduct4x8BitPackedSignedAccelerated(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$integerDotProduct4x8BitPackedSignedAccelerated, OFFSET$integerDotProduct4x8BitPackedSignedAccelerated, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int integerDotProduct4x8BitPackedMixedSignednessAccelerated() {
        return segment.get(LAYOUT$integerDotProduct4x8BitPackedMixedSignednessAccelerated, OFFSET$integerDotProduct4x8BitPackedMixedSignednessAccelerated);
    }

    public VkPhysicalDeviceShaderIntegerDotProductProperties integerDotProduct4x8BitPackedMixedSignednessAccelerated(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$integerDotProduct4x8BitPackedMixedSignednessAccelerated, OFFSET$integerDotProduct4x8BitPackedMixedSignednessAccelerated, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int integerDotProduct16BitUnsignedAccelerated() {
        return segment.get(LAYOUT$integerDotProduct16BitUnsignedAccelerated, OFFSET$integerDotProduct16BitUnsignedAccelerated);
    }

    public VkPhysicalDeviceShaderIntegerDotProductProperties integerDotProduct16BitUnsignedAccelerated(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$integerDotProduct16BitUnsignedAccelerated, OFFSET$integerDotProduct16BitUnsignedAccelerated, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int integerDotProduct16BitSignedAccelerated() {
        return segment.get(LAYOUT$integerDotProduct16BitSignedAccelerated, OFFSET$integerDotProduct16BitSignedAccelerated);
    }

    public VkPhysicalDeviceShaderIntegerDotProductProperties integerDotProduct16BitSignedAccelerated(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$integerDotProduct16BitSignedAccelerated, OFFSET$integerDotProduct16BitSignedAccelerated, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int integerDotProduct16BitMixedSignednessAccelerated() {
        return segment.get(LAYOUT$integerDotProduct16BitMixedSignednessAccelerated, OFFSET$integerDotProduct16BitMixedSignednessAccelerated);
    }

    public VkPhysicalDeviceShaderIntegerDotProductProperties integerDotProduct16BitMixedSignednessAccelerated(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$integerDotProduct16BitMixedSignednessAccelerated, OFFSET$integerDotProduct16BitMixedSignednessAccelerated, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int integerDotProduct32BitUnsignedAccelerated() {
        return segment.get(LAYOUT$integerDotProduct32BitUnsignedAccelerated, OFFSET$integerDotProduct32BitUnsignedAccelerated);
    }

    public VkPhysicalDeviceShaderIntegerDotProductProperties integerDotProduct32BitUnsignedAccelerated(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$integerDotProduct32BitUnsignedAccelerated, OFFSET$integerDotProduct32BitUnsignedAccelerated, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int integerDotProduct32BitSignedAccelerated() {
        return segment.get(LAYOUT$integerDotProduct32BitSignedAccelerated, OFFSET$integerDotProduct32BitSignedAccelerated);
    }

    public VkPhysicalDeviceShaderIntegerDotProductProperties integerDotProduct32BitSignedAccelerated(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$integerDotProduct32BitSignedAccelerated, OFFSET$integerDotProduct32BitSignedAccelerated, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int integerDotProduct32BitMixedSignednessAccelerated() {
        return segment.get(LAYOUT$integerDotProduct32BitMixedSignednessAccelerated, OFFSET$integerDotProduct32BitMixedSignednessAccelerated);
    }

    public VkPhysicalDeviceShaderIntegerDotProductProperties integerDotProduct32BitMixedSignednessAccelerated(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$integerDotProduct32BitMixedSignednessAccelerated, OFFSET$integerDotProduct32BitMixedSignednessAccelerated, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int integerDotProduct64BitUnsignedAccelerated() {
        return segment.get(LAYOUT$integerDotProduct64BitUnsignedAccelerated, OFFSET$integerDotProduct64BitUnsignedAccelerated);
    }

    public VkPhysicalDeviceShaderIntegerDotProductProperties integerDotProduct64BitUnsignedAccelerated(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$integerDotProduct64BitUnsignedAccelerated, OFFSET$integerDotProduct64BitUnsignedAccelerated, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int integerDotProduct64BitSignedAccelerated() {
        return segment.get(LAYOUT$integerDotProduct64BitSignedAccelerated, OFFSET$integerDotProduct64BitSignedAccelerated);
    }

    public VkPhysicalDeviceShaderIntegerDotProductProperties integerDotProduct64BitSignedAccelerated(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$integerDotProduct64BitSignedAccelerated, OFFSET$integerDotProduct64BitSignedAccelerated, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int integerDotProduct64BitMixedSignednessAccelerated() {
        return segment.get(LAYOUT$integerDotProduct64BitMixedSignednessAccelerated, OFFSET$integerDotProduct64BitMixedSignednessAccelerated);
    }

    public VkPhysicalDeviceShaderIntegerDotProductProperties integerDotProduct64BitMixedSignednessAccelerated(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$integerDotProduct64BitMixedSignednessAccelerated, OFFSET$integerDotProduct64BitMixedSignednessAccelerated, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int integerDotProductAccumulatingSaturating8BitUnsignedAccelerated() {
        return segment.get(LAYOUT$integerDotProductAccumulatingSaturating8BitUnsignedAccelerated, OFFSET$integerDotProductAccumulatingSaturating8BitUnsignedAccelerated);
    }

    public VkPhysicalDeviceShaderIntegerDotProductProperties integerDotProductAccumulatingSaturating8BitUnsignedAccelerated(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$integerDotProductAccumulatingSaturating8BitUnsignedAccelerated, OFFSET$integerDotProductAccumulatingSaturating8BitUnsignedAccelerated, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int integerDotProductAccumulatingSaturating8BitSignedAccelerated() {
        return segment.get(LAYOUT$integerDotProductAccumulatingSaturating8BitSignedAccelerated, OFFSET$integerDotProductAccumulatingSaturating8BitSignedAccelerated);
    }

    public VkPhysicalDeviceShaderIntegerDotProductProperties integerDotProductAccumulatingSaturating8BitSignedAccelerated(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$integerDotProductAccumulatingSaturating8BitSignedAccelerated, OFFSET$integerDotProductAccumulatingSaturating8BitSignedAccelerated, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int integerDotProductAccumulatingSaturating8BitMixedSignednessAccelerated() {
        return segment.get(LAYOUT$integerDotProductAccumulatingSaturating8BitMixedSignednessAccelerated, OFFSET$integerDotProductAccumulatingSaturating8BitMixedSignednessAccelerated);
    }

    public VkPhysicalDeviceShaderIntegerDotProductProperties integerDotProductAccumulatingSaturating8BitMixedSignednessAccelerated(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$integerDotProductAccumulatingSaturating8BitMixedSignednessAccelerated, OFFSET$integerDotProductAccumulatingSaturating8BitMixedSignednessAccelerated, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int integerDotProductAccumulatingSaturating4x8BitPackedUnsignedAccelerated() {
        return segment.get(LAYOUT$integerDotProductAccumulatingSaturating4x8BitPackedUnsignedAccelerated, OFFSET$integerDotProductAccumulatingSaturating4x8BitPackedUnsignedAccelerated);
    }

    public VkPhysicalDeviceShaderIntegerDotProductProperties integerDotProductAccumulatingSaturating4x8BitPackedUnsignedAccelerated(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$integerDotProductAccumulatingSaturating4x8BitPackedUnsignedAccelerated, OFFSET$integerDotProductAccumulatingSaturating4x8BitPackedUnsignedAccelerated, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int integerDotProductAccumulatingSaturating4x8BitPackedSignedAccelerated() {
        return segment.get(LAYOUT$integerDotProductAccumulatingSaturating4x8BitPackedSignedAccelerated, OFFSET$integerDotProductAccumulatingSaturating4x8BitPackedSignedAccelerated);
    }

    public VkPhysicalDeviceShaderIntegerDotProductProperties integerDotProductAccumulatingSaturating4x8BitPackedSignedAccelerated(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$integerDotProductAccumulatingSaturating4x8BitPackedSignedAccelerated, OFFSET$integerDotProductAccumulatingSaturating4x8BitPackedSignedAccelerated, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int integerDotProductAccumulatingSaturating4x8BitPackedMixedSignednessAccelerated() {
        return segment.get(LAYOUT$integerDotProductAccumulatingSaturating4x8BitPackedMixedSignednessAccelerated, OFFSET$integerDotProductAccumulatingSaturating4x8BitPackedMixedSignednessAccelerated);
    }

    public VkPhysicalDeviceShaderIntegerDotProductProperties integerDotProductAccumulatingSaturating4x8BitPackedMixedSignednessAccelerated(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$integerDotProductAccumulatingSaturating4x8BitPackedMixedSignednessAccelerated, OFFSET$integerDotProductAccumulatingSaturating4x8BitPackedMixedSignednessAccelerated, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int integerDotProductAccumulatingSaturating16BitUnsignedAccelerated() {
        return segment.get(LAYOUT$integerDotProductAccumulatingSaturating16BitUnsignedAccelerated, OFFSET$integerDotProductAccumulatingSaturating16BitUnsignedAccelerated);
    }

    public VkPhysicalDeviceShaderIntegerDotProductProperties integerDotProductAccumulatingSaturating16BitUnsignedAccelerated(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$integerDotProductAccumulatingSaturating16BitUnsignedAccelerated, OFFSET$integerDotProductAccumulatingSaturating16BitUnsignedAccelerated, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int integerDotProductAccumulatingSaturating16BitSignedAccelerated() {
        return segment.get(LAYOUT$integerDotProductAccumulatingSaturating16BitSignedAccelerated, OFFSET$integerDotProductAccumulatingSaturating16BitSignedAccelerated);
    }

    public VkPhysicalDeviceShaderIntegerDotProductProperties integerDotProductAccumulatingSaturating16BitSignedAccelerated(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$integerDotProductAccumulatingSaturating16BitSignedAccelerated, OFFSET$integerDotProductAccumulatingSaturating16BitSignedAccelerated, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int integerDotProductAccumulatingSaturating16BitMixedSignednessAccelerated() {
        return segment.get(LAYOUT$integerDotProductAccumulatingSaturating16BitMixedSignednessAccelerated, OFFSET$integerDotProductAccumulatingSaturating16BitMixedSignednessAccelerated);
    }

    public VkPhysicalDeviceShaderIntegerDotProductProperties integerDotProductAccumulatingSaturating16BitMixedSignednessAccelerated(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$integerDotProductAccumulatingSaturating16BitMixedSignednessAccelerated, OFFSET$integerDotProductAccumulatingSaturating16BitMixedSignednessAccelerated, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int integerDotProductAccumulatingSaturating32BitUnsignedAccelerated() {
        return segment.get(LAYOUT$integerDotProductAccumulatingSaturating32BitUnsignedAccelerated, OFFSET$integerDotProductAccumulatingSaturating32BitUnsignedAccelerated);
    }

    public VkPhysicalDeviceShaderIntegerDotProductProperties integerDotProductAccumulatingSaturating32BitUnsignedAccelerated(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$integerDotProductAccumulatingSaturating32BitUnsignedAccelerated, OFFSET$integerDotProductAccumulatingSaturating32BitUnsignedAccelerated, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int integerDotProductAccumulatingSaturating32BitSignedAccelerated() {
        return segment.get(LAYOUT$integerDotProductAccumulatingSaturating32BitSignedAccelerated, OFFSET$integerDotProductAccumulatingSaturating32BitSignedAccelerated);
    }

    public VkPhysicalDeviceShaderIntegerDotProductProperties integerDotProductAccumulatingSaturating32BitSignedAccelerated(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$integerDotProductAccumulatingSaturating32BitSignedAccelerated, OFFSET$integerDotProductAccumulatingSaturating32BitSignedAccelerated, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int integerDotProductAccumulatingSaturating32BitMixedSignednessAccelerated() {
        return segment.get(LAYOUT$integerDotProductAccumulatingSaturating32BitMixedSignednessAccelerated, OFFSET$integerDotProductAccumulatingSaturating32BitMixedSignednessAccelerated);
    }

    public VkPhysicalDeviceShaderIntegerDotProductProperties integerDotProductAccumulatingSaturating32BitMixedSignednessAccelerated(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$integerDotProductAccumulatingSaturating32BitMixedSignednessAccelerated, OFFSET$integerDotProductAccumulatingSaturating32BitMixedSignednessAccelerated, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int integerDotProductAccumulatingSaturating64BitUnsignedAccelerated() {
        return segment.get(LAYOUT$integerDotProductAccumulatingSaturating64BitUnsignedAccelerated, OFFSET$integerDotProductAccumulatingSaturating64BitUnsignedAccelerated);
    }

    public VkPhysicalDeviceShaderIntegerDotProductProperties integerDotProductAccumulatingSaturating64BitUnsignedAccelerated(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$integerDotProductAccumulatingSaturating64BitUnsignedAccelerated, OFFSET$integerDotProductAccumulatingSaturating64BitUnsignedAccelerated, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int integerDotProductAccumulatingSaturating64BitSignedAccelerated() {
        return segment.get(LAYOUT$integerDotProductAccumulatingSaturating64BitSignedAccelerated, OFFSET$integerDotProductAccumulatingSaturating64BitSignedAccelerated);
    }

    public VkPhysicalDeviceShaderIntegerDotProductProperties integerDotProductAccumulatingSaturating64BitSignedAccelerated(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$integerDotProductAccumulatingSaturating64BitSignedAccelerated, OFFSET$integerDotProductAccumulatingSaturating64BitSignedAccelerated, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int integerDotProductAccumulatingSaturating64BitMixedSignednessAccelerated() {
        return segment.get(LAYOUT$integerDotProductAccumulatingSaturating64BitMixedSignednessAccelerated, OFFSET$integerDotProductAccumulatingSaturating64BitMixedSignednessAccelerated);
    }

    public VkPhysicalDeviceShaderIntegerDotProductProperties integerDotProductAccumulatingSaturating64BitMixedSignednessAccelerated(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$integerDotProductAccumulatingSaturating64BitMixedSignednessAccelerated, OFFSET$integerDotProductAccumulatingSaturating64BitMixedSignednessAccelerated, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("integerDotProduct8BitUnsignedAccelerated"),
        ValueLayout.JAVA_INT.withName("integerDotProduct8BitSignedAccelerated"),
        ValueLayout.JAVA_INT.withName("integerDotProduct8BitMixedSignednessAccelerated"),
        ValueLayout.JAVA_INT.withName("integerDotProduct4x8BitPackedUnsignedAccelerated"),
        ValueLayout.JAVA_INT.withName("integerDotProduct4x8BitPackedSignedAccelerated"),
        ValueLayout.JAVA_INT.withName("integerDotProduct4x8BitPackedMixedSignednessAccelerated"),
        ValueLayout.JAVA_INT.withName("integerDotProduct16BitUnsignedAccelerated"),
        ValueLayout.JAVA_INT.withName("integerDotProduct16BitSignedAccelerated"),
        ValueLayout.JAVA_INT.withName("integerDotProduct16BitMixedSignednessAccelerated"),
        ValueLayout.JAVA_INT.withName("integerDotProduct32BitUnsignedAccelerated"),
        ValueLayout.JAVA_INT.withName("integerDotProduct32BitSignedAccelerated"),
        ValueLayout.JAVA_INT.withName("integerDotProduct32BitMixedSignednessAccelerated"),
        ValueLayout.JAVA_INT.withName("integerDotProduct64BitUnsignedAccelerated"),
        ValueLayout.JAVA_INT.withName("integerDotProduct64BitSignedAccelerated"),
        ValueLayout.JAVA_INT.withName("integerDotProduct64BitMixedSignednessAccelerated"),
        ValueLayout.JAVA_INT.withName("integerDotProductAccumulatingSaturating8BitUnsignedAccelerated"),
        ValueLayout.JAVA_INT.withName("integerDotProductAccumulatingSaturating8BitSignedAccelerated"),
        ValueLayout.JAVA_INT.withName("integerDotProductAccumulatingSaturating8BitMixedSignednessAccelerated"),
        ValueLayout.JAVA_INT.withName("integerDotProductAccumulatingSaturating4x8BitPackedUnsignedAccelerated"),
        ValueLayout.JAVA_INT.withName("integerDotProductAccumulatingSaturating4x8BitPackedSignedAccelerated"),
        ValueLayout.JAVA_INT.withName("integerDotProductAccumulatingSaturating4x8BitPackedMixedSignednessAccelerated"),
        ValueLayout.JAVA_INT.withName("integerDotProductAccumulatingSaturating16BitUnsignedAccelerated"),
        ValueLayout.JAVA_INT.withName("integerDotProductAccumulatingSaturating16BitSignedAccelerated"),
        ValueLayout.JAVA_INT.withName("integerDotProductAccumulatingSaturating16BitMixedSignednessAccelerated"),
        ValueLayout.JAVA_INT.withName("integerDotProductAccumulatingSaturating32BitUnsignedAccelerated"),
        ValueLayout.JAVA_INT.withName("integerDotProductAccumulatingSaturating32BitSignedAccelerated"),
        ValueLayout.JAVA_INT.withName("integerDotProductAccumulatingSaturating32BitMixedSignednessAccelerated"),
        ValueLayout.JAVA_INT.withName("integerDotProductAccumulatingSaturating64BitUnsignedAccelerated"),
        ValueLayout.JAVA_INT.withName("integerDotProductAccumulatingSaturating64BitSignedAccelerated"),
        ValueLayout.JAVA_INT.withName("integerDotProductAccumulatingSaturating64BitMixedSignednessAccelerated")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$integerDotProduct8BitUnsignedAccelerated = PathElement.groupElement("integerDotProduct8BitUnsignedAccelerated");
    public static final PathElement PATH$integerDotProduct8BitSignedAccelerated = PathElement.groupElement("integerDotProduct8BitSignedAccelerated");
    public static final PathElement PATH$integerDotProduct8BitMixedSignednessAccelerated = PathElement.groupElement("integerDotProduct8BitMixedSignednessAccelerated");
    public static final PathElement PATH$integerDotProduct4x8BitPackedUnsignedAccelerated = PathElement.groupElement("integerDotProduct4x8BitPackedUnsignedAccelerated");
    public static final PathElement PATH$integerDotProduct4x8BitPackedSignedAccelerated = PathElement.groupElement("integerDotProduct4x8BitPackedSignedAccelerated");
    public static final PathElement PATH$integerDotProduct4x8BitPackedMixedSignednessAccelerated = PathElement.groupElement("integerDotProduct4x8BitPackedMixedSignednessAccelerated");
    public static final PathElement PATH$integerDotProduct16BitUnsignedAccelerated = PathElement.groupElement("integerDotProduct16BitUnsignedAccelerated");
    public static final PathElement PATH$integerDotProduct16BitSignedAccelerated = PathElement.groupElement("integerDotProduct16BitSignedAccelerated");
    public static final PathElement PATH$integerDotProduct16BitMixedSignednessAccelerated = PathElement.groupElement("integerDotProduct16BitMixedSignednessAccelerated");
    public static final PathElement PATH$integerDotProduct32BitUnsignedAccelerated = PathElement.groupElement("integerDotProduct32BitUnsignedAccelerated");
    public static final PathElement PATH$integerDotProduct32BitSignedAccelerated = PathElement.groupElement("integerDotProduct32BitSignedAccelerated");
    public static final PathElement PATH$integerDotProduct32BitMixedSignednessAccelerated = PathElement.groupElement("integerDotProduct32BitMixedSignednessAccelerated");
    public static final PathElement PATH$integerDotProduct64BitUnsignedAccelerated = PathElement.groupElement("integerDotProduct64BitUnsignedAccelerated");
    public static final PathElement PATH$integerDotProduct64BitSignedAccelerated = PathElement.groupElement("integerDotProduct64BitSignedAccelerated");
    public static final PathElement PATH$integerDotProduct64BitMixedSignednessAccelerated = PathElement.groupElement("integerDotProduct64BitMixedSignednessAccelerated");
    public static final PathElement PATH$integerDotProductAccumulatingSaturating8BitUnsignedAccelerated = PathElement.groupElement("integerDotProductAccumulatingSaturating8BitUnsignedAccelerated");
    public static final PathElement PATH$integerDotProductAccumulatingSaturating8BitSignedAccelerated = PathElement.groupElement("integerDotProductAccumulatingSaturating8BitSignedAccelerated");
    public static final PathElement PATH$integerDotProductAccumulatingSaturating8BitMixedSignednessAccelerated = PathElement.groupElement("integerDotProductAccumulatingSaturating8BitMixedSignednessAccelerated");
    public static final PathElement PATH$integerDotProductAccumulatingSaturating4x8BitPackedUnsignedAccelerated = PathElement.groupElement("integerDotProductAccumulatingSaturating4x8BitPackedUnsignedAccelerated");
    public static final PathElement PATH$integerDotProductAccumulatingSaturating4x8BitPackedSignedAccelerated = PathElement.groupElement("integerDotProductAccumulatingSaturating4x8BitPackedSignedAccelerated");
    public static final PathElement PATH$integerDotProductAccumulatingSaturating4x8BitPackedMixedSignednessAccelerated = PathElement.groupElement("integerDotProductAccumulatingSaturating4x8BitPackedMixedSignednessAccelerated");
    public static final PathElement PATH$integerDotProductAccumulatingSaturating16BitUnsignedAccelerated = PathElement.groupElement("integerDotProductAccumulatingSaturating16BitUnsignedAccelerated");
    public static final PathElement PATH$integerDotProductAccumulatingSaturating16BitSignedAccelerated = PathElement.groupElement("integerDotProductAccumulatingSaturating16BitSignedAccelerated");
    public static final PathElement PATH$integerDotProductAccumulatingSaturating16BitMixedSignednessAccelerated = PathElement.groupElement("integerDotProductAccumulatingSaturating16BitMixedSignednessAccelerated");
    public static final PathElement PATH$integerDotProductAccumulatingSaturating32BitUnsignedAccelerated = PathElement.groupElement("integerDotProductAccumulatingSaturating32BitUnsignedAccelerated");
    public static final PathElement PATH$integerDotProductAccumulatingSaturating32BitSignedAccelerated = PathElement.groupElement("integerDotProductAccumulatingSaturating32BitSignedAccelerated");
    public static final PathElement PATH$integerDotProductAccumulatingSaturating32BitMixedSignednessAccelerated = PathElement.groupElement("integerDotProductAccumulatingSaturating32BitMixedSignednessAccelerated");
    public static final PathElement PATH$integerDotProductAccumulatingSaturating64BitUnsignedAccelerated = PathElement.groupElement("integerDotProductAccumulatingSaturating64BitUnsignedAccelerated");
    public static final PathElement PATH$integerDotProductAccumulatingSaturating64BitSignedAccelerated = PathElement.groupElement("integerDotProductAccumulatingSaturating64BitSignedAccelerated");
    public static final PathElement PATH$integerDotProductAccumulatingSaturating64BitMixedSignednessAccelerated = PathElement.groupElement("integerDotProductAccumulatingSaturating64BitMixedSignednessAccelerated");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$integerDotProduct8BitUnsignedAccelerated = (OfInt) LAYOUT.select(PATH$integerDotProduct8BitUnsignedAccelerated);
    public static final OfInt LAYOUT$integerDotProduct8BitSignedAccelerated = (OfInt) LAYOUT.select(PATH$integerDotProduct8BitSignedAccelerated);
    public static final OfInt LAYOUT$integerDotProduct8BitMixedSignednessAccelerated = (OfInt) LAYOUT.select(PATH$integerDotProduct8BitMixedSignednessAccelerated);
    public static final OfInt LAYOUT$integerDotProduct4x8BitPackedUnsignedAccelerated = (OfInt) LAYOUT.select(PATH$integerDotProduct4x8BitPackedUnsignedAccelerated);
    public static final OfInt LAYOUT$integerDotProduct4x8BitPackedSignedAccelerated = (OfInt) LAYOUT.select(PATH$integerDotProduct4x8BitPackedSignedAccelerated);
    public static final OfInt LAYOUT$integerDotProduct4x8BitPackedMixedSignednessAccelerated = (OfInt) LAYOUT.select(PATH$integerDotProduct4x8BitPackedMixedSignednessAccelerated);
    public static final OfInt LAYOUT$integerDotProduct16BitUnsignedAccelerated = (OfInt) LAYOUT.select(PATH$integerDotProduct16BitUnsignedAccelerated);
    public static final OfInt LAYOUT$integerDotProduct16BitSignedAccelerated = (OfInt) LAYOUT.select(PATH$integerDotProduct16BitSignedAccelerated);
    public static final OfInt LAYOUT$integerDotProduct16BitMixedSignednessAccelerated = (OfInt) LAYOUT.select(PATH$integerDotProduct16BitMixedSignednessAccelerated);
    public static final OfInt LAYOUT$integerDotProduct32BitUnsignedAccelerated = (OfInt) LAYOUT.select(PATH$integerDotProduct32BitUnsignedAccelerated);
    public static final OfInt LAYOUT$integerDotProduct32BitSignedAccelerated = (OfInt) LAYOUT.select(PATH$integerDotProduct32BitSignedAccelerated);
    public static final OfInt LAYOUT$integerDotProduct32BitMixedSignednessAccelerated = (OfInt) LAYOUT.select(PATH$integerDotProduct32BitMixedSignednessAccelerated);
    public static final OfInt LAYOUT$integerDotProduct64BitUnsignedAccelerated = (OfInt) LAYOUT.select(PATH$integerDotProduct64BitUnsignedAccelerated);
    public static final OfInt LAYOUT$integerDotProduct64BitSignedAccelerated = (OfInt) LAYOUT.select(PATH$integerDotProduct64BitSignedAccelerated);
    public static final OfInt LAYOUT$integerDotProduct64BitMixedSignednessAccelerated = (OfInt) LAYOUT.select(PATH$integerDotProduct64BitMixedSignednessAccelerated);
    public static final OfInt LAYOUT$integerDotProductAccumulatingSaturating8BitUnsignedAccelerated = (OfInt) LAYOUT.select(PATH$integerDotProductAccumulatingSaturating8BitUnsignedAccelerated);
    public static final OfInt LAYOUT$integerDotProductAccumulatingSaturating8BitSignedAccelerated = (OfInt) LAYOUT.select(PATH$integerDotProductAccumulatingSaturating8BitSignedAccelerated);
    public static final OfInt LAYOUT$integerDotProductAccumulatingSaturating8BitMixedSignednessAccelerated = (OfInt) LAYOUT.select(PATH$integerDotProductAccumulatingSaturating8BitMixedSignednessAccelerated);
    public static final OfInt LAYOUT$integerDotProductAccumulatingSaturating4x8BitPackedUnsignedAccelerated = (OfInt) LAYOUT.select(PATH$integerDotProductAccumulatingSaturating4x8BitPackedUnsignedAccelerated);
    public static final OfInt LAYOUT$integerDotProductAccumulatingSaturating4x8BitPackedSignedAccelerated = (OfInt) LAYOUT.select(PATH$integerDotProductAccumulatingSaturating4x8BitPackedSignedAccelerated);
    public static final OfInt LAYOUT$integerDotProductAccumulatingSaturating4x8BitPackedMixedSignednessAccelerated = (OfInt) LAYOUT.select(PATH$integerDotProductAccumulatingSaturating4x8BitPackedMixedSignednessAccelerated);
    public static final OfInt LAYOUT$integerDotProductAccumulatingSaturating16BitUnsignedAccelerated = (OfInt) LAYOUT.select(PATH$integerDotProductAccumulatingSaturating16BitUnsignedAccelerated);
    public static final OfInt LAYOUT$integerDotProductAccumulatingSaturating16BitSignedAccelerated = (OfInt) LAYOUT.select(PATH$integerDotProductAccumulatingSaturating16BitSignedAccelerated);
    public static final OfInt LAYOUT$integerDotProductAccumulatingSaturating16BitMixedSignednessAccelerated = (OfInt) LAYOUT.select(PATH$integerDotProductAccumulatingSaturating16BitMixedSignednessAccelerated);
    public static final OfInt LAYOUT$integerDotProductAccumulatingSaturating32BitUnsignedAccelerated = (OfInt) LAYOUT.select(PATH$integerDotProductAccumulatingSaturating32BitUnsignedAccelerated);
    public static final OfInt LAYOUT$integerDotProductAccumulatingSaturating32BitSignedAccelerated = (OfInt) LAYOUT.select(PATH$integerDotProductAccumulatingSaturating32BitSignedAccelerated);
    public static final OfInt LAYOUT$integerDotProductAccumulatingSaturating32BitMixedSignednessAccelerated = (OfInt) LAYOUT.select(PATH$integerDotProductAccumulatingSaturating32BitMixedSignednessAccelerated);
    public static final OfInt LAYOUT$integerDotProductAccumulatingSaturating64BitUnsignedAccelerated = (OfInt) LAYOUT.select(PATH$integerDotProductAccumulatingSaturating64BitUnsignedAccelerated);
    public static final OfInt LAYOUT$integerDotProductAccumulatingSaturating64BitSignedAccelerated = (OfInt) LAYOUT.select(PATH$integerDotProductAccumulatingSaturating64BitSignedAccelerated);
    public static final OfInt LAYOUT$integerDotProductAccumulatingSaturating64BitMixedSignednessAccelerated = (OfInt) LAYOUT.select(PATH$integerDotProductAccumulatingSaturating64BitMixedSignednessAccelerated);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$integerDotProduct8BitUnsignedAccelerated = LAYOUT$integerDotProduct8BitUnsignedAccelerated.byteSize();
    public static final long SIZE$integerDotProduct8BitSignedAccelerated = LAYOUT$integerDotProduct8BitSignedAccelerated.byteSize();
    public static final long SIZE$integerDotProduct8BitMixedSignednessAccelerated = LAYOUT$integerDotProduct8BitMixedSignednessAccelerated.byteSize();
    public static final long SIZE$integerDotProduct4x8BitPackedUnsignedAccelerated = LAYOUT$integerDotProduct4x8BitPackedUnsignedAccelerated.byteSize();
    public static final long SIZE$integerDotProduct4x8BitPackedSignedAccelerated = LAYOUT$integerDotProduct4x8BitPackedSignedAccelerated.byteSize();
    public static final long SIZE$integerDotProduct4x8BitPackedMixedSignednessAccelerated = LAYOUT$integerDotProduct4x8BitPackedMixedSignednessAccelerated.byteSize();
    public static final long SIZE$integerDotProduct16BitUnsignedAccelerated = LAYOUT$integerDotProduct16BitUnsignedAccelerated.byteSize();
    public static final long SIZE$integerDotProduct16BitSignedAccelerated = LAYOUT$integerDotProduct16BitSignedAccelerated.byteSize();
    public static final long SIZE$integerDotProduct16BitMixedSignednessAccelerated = LAYOUT$integerDotProduct16BitMixedSignednessAccelerated.byteSize();
    public static final long SIZE$integerDotProduct32BitUnsignedAccelerated = LAYOUT$integerDotProduct32BitUnsignedAccelerated.byteSize();
    public static final long SIZE$integerDotProduct32BitSignedAccelerated = LAYOUT$integerDotProduct32BitSignedAccelerated.byteSize();
    public static final long SIZE$integerDotProduct32BitMixedSignednessAccelerated = LAYOUT$integerDotProduct32BitMixedSignednessAccelerated.byteSize();
    public static final long SIZE$integerDotProduct64BitUnsignedAccelerated = LAYOUT$integerDotProduct64BitUnsignedAccelerated.byteSize();
    public static final long SIZE$integerDotProduct64BitSignedAccelerated = LAYOUT$integerDotProduct64BitSignedAccelerated.byteSize();
    public static final long SIZE$integerDotProduct64BitMixedSignednessAccelerated = LAYOUT$integerDotProduct64BitMixedSignednessAccelerated.byteSize();
    public static final long SIZE$integerDotProductAccumulatingSaturating8BitUnsignedAccelerated = LAYOUT$integerDotProductAccumulatingSaturating8BitUnsignedAccelerated.byteSize();
    public static final long SIZE$integerDotProductAccumulatingSaturating8BitSignedAccelerated = LAYOUT$integerDotProductAccumulatingSaturating8BitSignedAccelerated.byteSize();
    public static final long SIZE$integerDotProductAccumulatingSaturating8BitMixedSignednessAccelerated = LAYOUT$integerDotProductAccumulatingSaturating8BitMixedSignednessAccelerated.byteSize();
    public static final long SIZE$integerDotProductAccumulatingSaturating4x8BitPackedUnsignedAccelerated = LAYOUT$integerDotProductAccumulatingSaturating4x8BitPackedUnsignedAccelerated.byteSize();
    public static final long SIZE$integerDotProductAccumulatingSaturating4x8BitPackedSignedAccelerated = LAYOUT$integerDotProductAccumulatingSaturating4x8BitPackedSignedAccelerated.byteSize();
    public static final long SIZE$integerDotProductAccumulatingSaturating4x8BitPackedMixedSignednessAccelerated = LAYOUT$integerDotProductAccumulatingSaturating4x8BitPackedMixedSignednessAccelerated.byteSize();
    public static final long SIZE$integerDotProductAccumulatingSaturating16BitUnsignedAccelerated = LAYOUT$integerDotProductAccumulatingSaturating16BitUnsignedAccelerated.byteSize();
    public static final long SIZE$integerDotProductAccumulatingSaturating16BitSignedAccelerated = LAYOUT$integerDotProductAccumulatingSaturating16BitSignedAccelerated.byteSize();
    public static final long SIZE$integerDotProductAccumulatingSaturating16BitMixedSignednessAccelerated = LAYOUT$integerDotProductAccumulatingSaturating16BitMixedSignednessAccelerated.byteSize();
    public static final long SIZE$integerDotProductAccumulatingSaturating32BitUnsignedAccelerated = LAYOUT$integerDotProductAccumulatingSaturating32BitUnsignedAccelerated.byteSize();
    public static final long SIZE$integerDotProductAccumulatingSaturating32BitSignedAccelerated = LAYOUT$integerDotProductAccumulatingSaturating32BitSignedAccelerated.byteSize();
    public static final long SIZE$integerDotProductAccumulatingSaturating32BitMixedSignednessAccelerated = LAYOUT$integerDotProductAccumulatingSaturating32BitMixedSignednessAccelerated.byteSize();
    public static final long SIZE$integerDotProductAccumulatingSaturating64BitUnsignedAccelerated = LAYOUT$integerDotProductAccumulatingSaturating64BitUnsignedAccelerated.byteSize();
    public static final long SIZE$integerDotProductAccumulatingSaturating64BitSignedAccelerated = LAYOUT$integerDotProductAccumulatingSaturating64BitSignedAccelerated.byteSize();
    public static final long SIZE$integerDotProductAccumulatingSaturating64BitMixedSignednessAccelerated = LAYOUT$integerDotProductAccumulatingSaturating64BitMixedSignednessAccelerated.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$integerDotProduct8BitUnsignedAccelerated = LAYOUT.byteOffset(PATH$integerDotProduct8BitUnsignedAccelerated);
    public static final long OFFSET$integerDotProduct8BitSignedAccelerated = LAYOUT.byteOffset(PATH$integerDotProduct8BitSignedAccelerated);
    public static final long OFFSET$integerDotProduct8BitMixedSignednessAccelerated = LAYOUT.byteOffset(PATH$integerDotProduct8BitMixedSignednessAccelerated);
    public static final long OFFSET$integerDotProduct4x8BitPackedUnsignedAccelerated = LAYOUT.byteOffset(PATH$integerDotProduct4x8BitPackedUnsignedAccelerated);
    public static final long OFFSET$integerDotProduct4x8BitPackedSignedAccelerated = LAYOUT.byteOffset(PATH$integerDotProduct4x8BitPackedSignedAccelerated);
    public static final long OFFSET$integerDotProduct4x8BitPackedMixedSignednessAccelerated = LAYOUT.byteOffset(PATH$integerDotProduct4x8BitPackedMixedSignednessAccelerated);
    public static final long OFFSET$integerDotProduct16BitUnsignedAccelerated = LAYOUT.byteOffset(PATH$integerDotProduct16BitUnsignedAccelerated);
    public static final long OFFSET$integerDotProduct16BitSignedAccelerated = LAYOUT.byteOffset(PATH$integerDotProduct16BitSignedAccelerated);
    public static final long OFFSET$integerDotProduct16BitMixedSignednessAccelerated = LAYOUT.byteOffset(PATH$integerDotProduct16BitMixedSignednessAccelerated);
    public static final long OFFSET$integerDotProduct32BitUnsignedAccelerated = LAYOUT.byteOffset(PATH$integerDotProduct32BitUnsignedAccelerated);
    public static final long OFFSET$integerDotProduct32BitSignedAccelerated = LAYOUT.byteOffset(PATH$integerDotProduct32BitSignedAccelerated);
    public static final long OFFSET$integerDotProduct32BitMixedSignednessAccelerated = LAYOUT.byteOffset(PATH$integerDotProduct32BitMixedSignednessAccelerated);
    public static final long OFFSET$integerDotProduct64BitUnsignedAccelerated = LAYOUT.byteOffset(PATH$integerDotProduct64BitUnsignedAccelerated);
    public static final long OFFSET$integerDotProduct64BitSignedAccelerated = LAYOUT.byteOffset(PATH$integerDotProduct64BitSignedAccelerated);
    public static final long OFFSET$integerDotProduct64BitMixedSignednessAccelerated = LAYOUT.byteOffset(PATH$integerDotProduct64BitMixedSignednessAccelerated);
    public static final long OFFSET$integerDotProductAccumulatingSaturating8BitUnsignedAccelerated = LAYOUT.byteOffset(PATH$integerDotProductAccumulatingSaturating8BitUnsignedAccelerated);
    public static final long OFFSET$integerDotProductAccumulatingSaturating8BitSignedAccelerated = LAYOUT.byteOffset(PATH$integerDotProductAccumulatingSaturating8BitSignedAccelerated);
    public static final long OFFSET$integerDotProductAccumulatingSaturating8BitMixedSignednessAccelerated = LAYOUT.byteOffset(PATH$integerDotProductAccumulatingSaturating8BitMixedSignednessAccelerated);
    public static final long OFFSET$integerDotProductAccumulatingSaturating4x8BitPackedUnsignedAccelerated = LAYOUT.byteOffset(PATH$integerDotProductAccumulatingSaturating4x8BitPackedUnsignedAccelerated);
    public static final long OFFSET$integerDotProductAccumulatingSaturating4x8BitPackedSignedAccelerated = LAYOUT.byteOffset(PATH$integerDotProductAccumulatingSaturating4x8BitPackedSignedAccelerated);
    public static final long OFFSET$integerDotProductAccumulatingSaturating4x8BitPackedMixedSignednessAccelerated = LAYOUT.byteOffset(PATH$integerDotProductAccumulatingSaturating4x8BitPackedMixedSignednessAccelerated);
    public static final long OFFSET$integerDotProductAccumulatingSaturating16BitUnsignedAccelerated = LAYOUT.byteOffset(PATH$integerDotProductAccumulatingSaturating16BitUnsignedAccelerated);
    public static final long OFFSET$integerDotProductAccumulatingSaturating16BitSignedAccelerated = LAYOUT.byteOffset(PATH$integerDotProductAccumulatingSaturating16BitSignedAccelerated);
    public static final long OFFSET$integerDotProductAccumulatingSaturating16BitMixedSignednessAccelerated = LAYOUT.byteOffset(PATH$integerDotProductAccumulatingSaturating16BitMixedSignednessAccelerated);
    public static final long OFFSET$integerDotProductAccumulatingSaturating32BitUnsignedAccelerated = LAYOUT.byteOffset(PATH$integerDotProductAccumulatingSaturating32BitUnsignedAccelerated);
    public static final long OFFSET$integerDotProductAccumulatingSaturating32BitSignedAccelerated = LAYOUT.byteOffset(PATH$integerDotProductAccumulatingSaturating32BitSignedAccelerated);
    public static final long OFFSET$integerDotProductAccumulatingSaturating32BitMixedSignednessAccelerated = LAYOUT.byteOffset(PATH$integerDotProductAccumulatingSaturating32BitMixedSignednessAccelerated);
    public static final long OFFSET$integerDotProductAccumulatingSaturating64BitUnsignedAccelerated = LAYOUT.byteOffset(PATH$integerDotProductAccumulatingSaturating64BitUnsignedAccelerated);
    public static final long OFFSET$integerDotProductAccumulatingSaturating64BitSignedAccelerated = LAYOUT.byteOffset(PATH$integerDotProductAccumulatingSaturating64BitSignedAccelerated);
    public static final long OFFSET$integerDotProductAccumulatingSaturating64BitMixedSignednessAccelerated = LAYOUT.byteOffset(PATH$integerDotProductAccumulatingSaturating64BitMixedSignednessAccelerated);
}
