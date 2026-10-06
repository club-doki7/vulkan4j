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

/// Represents a pointer to a <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSamplerCreateInfo.html"><code>VkSamplerCreateInfo</code></a> structure in native memory.
///
/// ## Structure
///
/// {@snippet lang=c :
/// typedef struct VkSamplerCreateInfo {
///     VkStructureType sType; // @link substring="VkStructureType" target="VkStructureType" @link substring="sType" target="#sType"
///     void const* pNext; // optional // @link substring="pNext" target="#pNext"
///     VkSamplerCreateFlags flags; // optional // @link substring="VkSamplerCreateFlags" target="VkSamplerCreateFlags" @link substring="flags" target="#flags"
///     VkFilter magFilter; // @link substring="VkFilter" target="VkFilter" @link substring="magFilter" target="#magFilter"
///     VkFilter minFilter; // @link substring="VkFilter" target="VkFilter" @link substring="minFilter" target="#minFilter"
///     VkSamplerMipmapMode mipmapMode; // @link substring="VkSamplerMipmapMode" target="VkSamplerMipmapMode" @link substring="mipmapMode" target="#mipmapMode"
///     VkSamplerAddressMode addressModeU; // @link substring="VkSamplerAddressMode" target="VkSamplerAddressMode" @link substring="addressModeU" target="#addressModeU"
///     VkSamplerAddressMode addressModeV; // @link substring="VkSamplerAddressMode" target="VkSamplerAddressMode" @link substring="addressModeV" target="#addressModeV"
///     VkSamplerAddressMode addressModeW; // @link substring="VkSamplerAddressMode" target="VkSamplerAddressMode" @link substring="addressModeW" target="#addressModeW"
///     float mipLodBias; // @link substring="mipLodBias" target="#mipLodBias"
///     VkBool32 anisotropyEnable; // @link substring="anisotropyEnable" target="#anisotropyEnable"
///     float maxAnisotropy; // @link substring="maxAnisotropy" target="#maxAnisotropy"
///     VkBool32 compareEnable; // @link substring="compareEnable" target="#compareEnable"
///     VkCompareOp compareOp; // @link substring="VkCompareOp" target="VkCompareOp" @link substring="compareOp" target="#compareOp"
///     float minLod; // @link substring="minLod" target="#minLod"
///     float maxLod; // @link substring="maxLod" target="#maxLod"
///     VkBorderColor borderColor; // @link substring="VkBorderColor" target="VkBorderColor" @link substring="borderColor" target="#borderColor"
///     VkBool32 unnormalizedCoordinates; // @link substring="unnormalizedCoordinates" target="#unnormalizedCoordinates"
/// } VkSamplerCreateInfo;
/// }
///
/// ## Auto initialization
///
/// This structure has the following members that can be automatically initialized:
/// - `sType = VK_STRUCTURE_TYPE_SAMPLER_CREATE_INFO`
///
/// The {@code allocate} ({@link VkSamplerCreateInfo#allocate(Arena)}, {@link VkSamplerCreateInfo#allocate(Arena, long)})
/// functions will automatically initialize these fields. Also, you may call {@link VkSamplerCreateInfo#autoInit}
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
/// @see <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSamplerCreateInfo.html"><code>VkSamplerCreateInfo</code></a>
@ValueBasedCandidate
@UnsafeConstructor
public record VkSamplerCreateInfo(@NotNull MemorySegment segment) implements IVkSamplerCreateInfo {
    /// Represents a pointer to / an array of <a href="https://registry.khronos.org/vulkan/specs/latest/man/html/VkSamplerCreateInfo.html"><code>VkSamplerCreateInfo</code></a> structure(s) in native memory.
    ///
    /// Technically speaking, this type has no difference with {@link VkSamplerCreateInfo}. This type
    /// is introduced mainly for user to distinguish between a pointer to a single structure
    /// and a pointer to (potentially) an array of structure(s). APIs should use interface
    /// IVkSamplerCreateInfo to handle both types uniformly. See package level documentation for more
    /// details.
    ///
    /// ## Contracts
    ///
    /// The property {@link #segment()} should always be not-null
    /// ({@code segment != NULL && !segment.equals(MemorySegment.NULL)}), and properly aligned to
    /// {@code VkSamplerCreateInfo.LAYOUT.byteAlignment()} bytes. To represent null pointer, you may use a Java
    /// {@code null} instead. See the documentation of {@link IPointer#segment()} for more details.
    ///
    /// The constructor of this class is marked as {@link UnsafeConstructor}, because it does not
    /// perform any runtime check. The constructor can be useful for automatic code generators.
    @ValueBasedCandidate
    @UnsafeConstructor
    public record Ptr(@NotNull MemorySegment segment) implements IVkSamplerCreateInfo, Iterable<VkSamplerCreateInfo> {
        public long size() {
            return segment.byteSize() / VkSamplerCreateInfo.BYTES;
        }

        /// Returns (a pointer to) the structure at the given index.
        ///
        /// Note that unlike {@code read} series functions ({@link IntPtr#read()} for
        /// example), modification on returned structure will be reflected on the original
        /// structure array. So this function is called {@code at} to explicitly
        /// indicate that the returned structure is a view of the original structure.
        public @NotNull VkSamplerCreateInfo at(long index) {
            return new VkSamplerCreateInfo(segment.asSlice(index * VkSamplerCreateInfo.BYTES, VkSamplerCreateInfo.BYTES));
        }

        public VkSamplerCreateInfo.Ptr at(long index, @NotNull Consumer<@NotNull VkSamplerCreateInfo> consumer) {
            consumer.accept(at(index));
            return this;
        }

        public void write(long index, @NotNull VkSamplerCreateInfo value) {
            MemorySegment s = segment.asSlice(index * VkSamplerCreateInfo.BYTES, VkSamplerCreateInfo.BYTES);
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
            return new Ptr(segment.reinterpret(newSize * VkSamplerCreateInfo.BYTES));
        }

        public @NotNull Ptr offset(long offset) {
            return new Ptr(segment.asSlice(offset * VkSamplerCreateInfo.BYTES));
        }

        /// Note that this function uses the {@link List#subList(int, int)} semantics (left inclusive,
        /// right exclusive interval), not {@link MemorySegment#asSlice(long, long)} semantics
        /// (offset + newSize). Be careful with the difference
        public @NotNull Ptr slice(long start, long end) {
            return new Ptr(segment.asSlice(
                start * VkSamplerCreateInfo.BYTES,
                (end - start) * VkSamplerCreateInfo.BYTES
            ));
        }

        public Ptr slice(long end) {
            return new Ptr(segment.asSlice(0, end * VkSamplerCreateInfo.BYTES));
        }

        public VkSamplerCreateInfo[] toArray() {
            VkSamplerCreateInfo[] ret = new VkSamplerCreateInfo[(int) size()];
            for (long i = 0; i < size(); i++) {
                ret[(int) i] = at(i);
            }
            return ret;
        }

        @Override
        public @NotNull Iterator<VkSamplerCreateInfo> iterator() {
            return new Iter(this.segment());
        }

        /// An iterator over the structures.
        private static final class Iter implements Iterator<VkSamplerCreateInfo> {
            Iter(@NotNull MemorySegment segment) {
                this.segment = segment;
            }

            @Override
            public boolean hasNext() {
                return segment.byteSize() >= VkSamplerCreateInfo.BYTES;
            }

            @Override
            public VkSamplerCreateInfo next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                VkSamplerCreateInfo ret = new VkSamplerCreateInfo(segment.asSlice(0, VkSamplerCreateInfo.BYTES));
                segment = segment.asSlice(VkSamplerCreateInfo.BYTES);
                return ret;
            }

            private @NotNull MemorySegment segment;
        }
    }

    public static VkSamplerCreateInfo allocate(Arena arena) {
        VkSamplerCreateInfo ret = new VkSamplerCreateInfo(arena.allocate(LAYOUT));
        ret.sType(VkStructureType.SAMPLER_CREATE_INFO);
        return ret;
    }

    public static VkSamplerCreateInfo.Ptr allocate(Arena arena, long count) {
        MemorySegment segment = arena.allocate(LAYOUT, count);
        VkSamplerCreateInfo.Ptr ret = new VkSamplerCreateInfo.Ptr(segment);
        for (long i = 0; i < count; i++) {
            ret.at(i).sType(VkStructureType.SAMPLER_CREATE_INFO);
        }
        return ret;
    }

    public static VkSamplerCreateInfo clone(Arena arena, VkSamplerCreateInfo src) {
        VkSamplerCreateInfo ret = allocate(arena);
        ret.segment.copyFrom(src.segment);
        return ret;
    }

    public void autoInit() {
        sType(VkStructureType.SAMPLER_CREATE_INFO);
    }

    public @EnumType(VkStructureType.class) int sType() {
        return segment.get(LAYOUT$sType, OFFSET$sType);
    }

    public VkSamplerCreateInfo sType(@EnumType(VkStructureType.class) int value) {
        segment.set(LAYOUT$sType, OFFSET$sType, value);
        return this;
    }

    public @Pointer(comment="void*") @NotNull MemorySegment pNext() {
        return segment.get(LAYOUT$pNext, OFFSET$pNext);
    }

    public VkSamplerCreateInfo pNext(@Pointer(comment="void*") @NotNull MemorySegment value) {
        segment.set(LAYOUT$pNext, OFFSET$pNext, value);
        return this;
    }

    public VkSamplerCreateInfo pNext(@Nullable IPointer pointer) {
        pNext(pointer != null ? pointer.segment() : MemorySegment.NULL);
        return this;
    }

    public @Bitmask(VkSamplerCreateFlags.class) int flags() {
        return segment.get(LAYOUT$flags, OFFSET$flags);
    }

    public VkSamplerCreateInfo flags(@Bitmask(VkSamplerCreateFlags.class) int value) {
        segment.set(LAYOUT$flags, OFFSET$flags, value);
        return this;
    }

    public @EnumType(VkFilter.class) int magFilter() {
        return segment.get(LAYOUT$magFilter, OFFSET$magFilter);
    }

    public VkSamplerCreateInfo magFilter(@EnumType(VkFilter.class) int value) {
        segment.set(LAYOUT$magFilter, OFFSET$magFilter, value);
        return this;
    }

    public @EnumType(VkFilter.class) int minFilter() {
        return segment.get(LAYOUT$minFilter, OFFSET$minFilter);
    }

    public VkSamplerCreateInfo minFilter(@EnumType(VkFilter.class) int value) {
        segment.set(LAYOUT$minFilter, OFFSET$minFilter, value);
        return this;
    }

    public @EnumType(VkSamplerMipmapMode.class) int mipmapMode() {
        return segment.get(LAYOUT$mipmapMode, OFFSET$mipmapMode);
    }

    public VkSamplerCreateInfo mipmapMode(@EnumType(VkSamplerMipmapMode.class) int value) {
        segment.set(LAYOUT$mipmapMode, OFFSET$mipmapMode, value);
        return this;
    }

    public @EnumType(VkSamplerAddressMode.class) int addressModeU() {
        return segment.get(LAYOUT$addressModeU, OFFSET$addressModeU);
    }

    public VkSamplerCreateInfo addressModeU(@EnumType(VkSamplerAddressMode.class) int value) {
        segment.set(LAYOUT$addressModeU, OFFSET$addressModeU, value);
        return this;
    }

    public @EnumType(VkSamplerAddressMode.class) int addressModeV() {
        return segment.get(LAYOUT$addressModeV, OFFSET$addressModeV);
    }

    public VkSamplerCreateInfo addressModeV(@EnumType(VkSamplerAddressMode.class) int value) {
        segment.set(LAYOUT$addressModeV, OFFSET$addressModeV, value);
        return this;
    }

    public @EnumType(VkSamplerAddressMode.class) int addressModeW() {
        return segment.get(LAYOUT$addressModeW, OFFSET$addressModeW);
    }

    public VkSamplerCreateInfo addressModeW(@EnumType(VkSamplerAddressMode.class) int value) {
        segment.set(LAYOUT$addressModeW, OFFSET$addressModeW, value);
        return this;
    }

    public float mipLodBias() {
        return segment.get(LAYOUT$mipLodBias, OFFSET$mipLodBias);
    }

    public VkSamplerCreateInfo mipLodBias(float value) {
        segment.set(LAYOUT$mipLodBias, OFFSET$mipLodBias, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int anisotropyEnable() {
        return segment.get(LAYOUT$anisotropyEnable, OFFSET$anisotropyEnable);
    }

    public VkSamplerCreateInfo anisotropyEnable(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$anisotropyEnable, OFFSET$anisotropyEnable, value);
        return this;
    }

    public float maxAnisotropy() {
        return segment.get(LAYOUT$maxAnisotropy, OFFSET$maxAnisotropy);
    }

    public VkSamplerCreateInfo maxAnisotropy(float value) {
        segment.set(LAYOUT$maxAnisotropy, OFFSET$maxAnisotropy, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int compareEnable() {
        return segment.get(LAYOUT$compareEnable, OFFSET$compareEnable);
    }

    public VkSamplerCreateInfo compareEnable(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$compareEnable, OFFSET$compareEnable, value);
        return this;
    }

    public @EnumType(VkCompareOp.class) int compareOp() {
        return segment.get(LAYOUT$compareOp, OFFSET$compareOp);
    }

    public VkSamplerCreateInfo compareOp(@EnumType(VkCompareOp.class) int value) {
        segment.set(LAYOUT$compareOp, OFFSET$compareOp, value);
        return this;
    }

    public float minLod() {
        return segment.get(LAYOUT$minLod, OFFSET$minLod);
    }

    public VkSamplerCreateInfo minLod(float value) {
        segment.set(LAYOUT$minLod, OFFSET$minLod, value);
        return this;
    }

    public float maxLod() {
        return segment.get(LAYOUT$maxLod, OFFSET$maxLod);
    }

    public VkSamplerCreateInfo maxLod(float value) {
        segment.set(LAYOUT$maxLod, OFFSET$maxLod, value);
        return this;
    }

    public @EnumType(VkBorderColor.class) int borderColor() {
        return segment.get(LAYOUT$borderColor, OFFSET$borderColor);
    }

    public VkSamplerCreateInfo borderColor(@EnumType(VkBorderColor.class) int value) {
        segment.set(LAYOUT$borderColor, OFFSET$borderColor, value);
        return this;
    }

    public @NativeType("VkBool32") @Unsigned int unnormalizedCoordinates() {
        return segment.get(LAYOUT$unnormalizedCoordinates, OFFSET$unnormalizedCoordinates);
    }

    public VkSamplerCreateInfo unnormalizedCoordinates(@NativeType("VkBool32") @Unsigned int value) {
        segment.set(LAYOUT$unnormalizedCoordinates, OFFSET$unnormalizedCoordinates, value);
        return this;
    }

    public static final StructLayout LAYOUT = NativeLayout.structLayout(
        ValueLayout.JAVA_INT.withName("sType"),
        ValueLayout.ADDRESS.withName("pNext"),
        ValueLayout.JAVA_INT.withName("flags"),
        ValueLayout.JAVA_INT.withName("magFilter"),
        ValueLayout.JAVA_INT.withName("minFilter"),
        ValueLayout.JAVA_INT.withName("mipmapMode"),
        ValueLayout.JAVA_INT.withName("addressModeU"),
        ValueLayout.JAVA_INT.withName("addressModeV"),
        ValueLayout.JAVA_INT.withName("addressModeW"),
        ValueLayout.JAVA_FLOAT.withName("mipLodBias"),
        ValueLayout.JAVA_INT.withName("anisotropyEnable"),
        ValueLayout.JAVA_FLOAT.withName("maxAnisotropy"),
        ValueLayout.JAVA_INT.withName("compareEnable"),
        ValueLayout.JAVA_INT.withName("compareOp"),
        ValueLayout.JAVA_FLOAT.withName("minLod"),
        ValueLayout.JAVA_FLOAT.withName("maxLod"),
        ValueLayout.JAVA_INT.withName("borderColor"),
        ValueLayout.JAVA_INT.withName("unnormalizedCoordinates")
    );
    public static final long BYTES = LAYOUT.byteSize();

    public static final PathElement PATH$sType = PathElement.groupElement("sType");
    public static final PathElement PATH$pNext = PathElement.groupElement("pNext");
    public static final PathElement PATH$flags = PathElement.groupElement("flags");
    public static final PathElement PATH$magFilter = PathElement.groupElement("magFilter");
    public static final PathElement PATH$minFilter = PathElement.groupElement("minFilter");
    public static final PathElement PATH$mipmapMode = PathElement.groupElement("mipmapMode");
    public static final PathElement PATH$addressModeU = PathElement.groupElement("addressModeU");
    public static final PathElement PATH$addressModeV = PathElement.groupElement("addressModeV");
    public static final PathElement PATH$addressModeW = PathElement.groupElement("addressModeW");
    public static final PathElement PATH$mipLodBias = PathElement.groupElement("mipLodBias");
    public static final PathElement PATH$anisotropyEnable = PathElement.groupElement("anisotropyEnable");
    public static final PathElement PATH$maxAnisotropy = PathElement.groupElement("maxAnisotropy");
    public static final PathElement PATH$compareEnable = PathElement.groupElement("compareEnable");
    public static final PathElement PATH$compareOp = PathElement.groupElement("compareOp");
    public static final PathElement PATH$minLod = PathElement.groupElement("minLod");
    public static final PathElement PATH$maxLod = PathElement.groupElement("maxLod");
    public static final PathElement PATH$borderColor = PathElement.groupElement("borderColor");
    public static final PathElement PATH$unnormalizedCoordinates = PathElement.groupElement("unnormalizedCoordinates");

    public static final OfInt LAYOUT$sType = (OfInt) LAYOUT.select(PATH$sType);
    public static final AddressLayout LAYOUT$pNext = (AddressLayout) LAYOUT.select(PATH$pNext);
    public static final OfInt LAYOUT$flags = (OfInt) LAYOUT.select(PATH$flags);
    public static final OfInt LAYOUT$magFilter = (OfInt) LAYOUT.select(PATH$magFilter);
    public static final OfInt LAYOUT$minFilter = (OfInt) LAYOUT.select(PATH$minFilter);
    public static final OfInt LAYOUT$mipmapMode = (OfInt) LAYOUT.select(PATH$mipmapMode);
    public static final OfInt LAYOUT$addressModeU = (OfInt) LAYOUT.select(PATH$addressModeU);
    public static final OfInt LAYOUT$addressModeV = (OfInt) LAYOUT.select(PATH$addressModeV);
    public static final OfInt LAYOUT$addressModeW = (OfInt) LAYOUT.select(PATH$addressModeW);
    public static final OfFloat LAYOUT$mipLodBias = (OfFloat) LAYOUT.select(PATH$mipLodBias);
    public static final OfInt LAYOUT$anisotropyEnable = (OfInt) LAYOUT.select(PATH$anisotropyEnable);
    public static final OfFloat LAYOUT$maxAnisotropy = (OfFloat) LAYOUT.select(PATH$maxAnisotropy);
    public static final OfInt LAYOUT$compareEnable = (OfInt) LAYOUT.select(PATH$compareEnable);
    public static final OfInt LAYOUT$compareOp = (OfInt) LAYOUT.select(PATH$compareOp);
    public static final OfFloat LAYOUT$minLod = (OfFloat) LAYOUT.select(PATH$minLod);
    public static final OfFloat LAYOUT$maxLod = (OfFloat) LAYOUT.select(PATH$maxLod);
    public static final OfInt LAYOUT$borderColor = (OfInt) LAYOUT.select(PATH$borderColor);
    public static final OfInt LAYOUT$unnormalizedCoordinates = (OfInt) LAYOUT.select(PATH$unnormalizedCoordinates);

    public static final long SIZE$sType = LAYOUT$sType.byteSize();
    public static final long SIZE$pNext = LAYOUT$pNext.byteSize();
    public static final long SIZE$flags = LAYOUT$flags.byteSize();
    public static final long SIZE$magFilter = LAYOUT$magFilter.byteSize();
    public static final long SIZE$minFilter = LAYOUT$minFilter.byteSize();
    public static final long SIZE$mipmapMode = LAYOUT$mipmapMode.byteSize();
    public static final long SIZE$addressModeU = LAYOUT$addressModeU.byteSize();
    public static final long SIZE$addressModeV = LAYOUT$addressModeV.byteSize();
    public static final long SIZE$addressModeW = LAYOUT$addressModeW.byteSize();
    public static final long SIZE$mipLodBias = LAYOUT$mipLodBias.byteSize();
    public static final long SIZE$anisotropyEnable = LAYOUT$anisotropyEnable.byteSize();
    public static final long SIZE$maxAnisotropy = LAYOUT$maxAnisotropy.byteSize();
    public static final long SIZE$compareEnable = LAYOUT$compareEnable.byteSize();
    public static final long SIZE$compareOp = LAYOUT$compareOp.byteSize();
    public static final long SIZE$minLod = LAYOUT$minLod.byteSize();
    public static final long SIZE$maxLod = LAYOUT$maxLod.byteSize();
    public static final long SIZE$borderColor = LAYOUT$borderColor.byteSize();
    public static final long SIZE$unnormalizedCoordinates = LAYOUT$unnormalizedCoordinates.byteSize();

    public static final long OFFSET$sType = LAYOUT.byteOffset(PATH$sType);
    public static final long OFFSET$pNext = LAYOUT.byteOffset(PATH$pNext);
    public static final long OFFSET$flags = LAYOUT.byteOffset(PATH$flags);
    public static final long OFFSET$magFilter = LAYOUT.byteOffset(PATH$magFilter);
    public static final long OFFSET$minFilter = LAYOUT.byteOffset(PATH$minFilter);
    public static final long OFFSET$mipmapMode = LAYOUT.byteOffset(PATH$mipmapMode);
    public static final long OFFSET$addressModeU = LAYOUT.byteOffset(PATH$addressModeU);
    public static final long OFFSET$addressModeV = LAYOUT.byteOffset(PATH$addressModeV);
    public static final long OFFSET$addressModeW = LAYOUT.byteOffset(PATH$addressModeW);
    public static final long OFFSET$mipLodBias = LAYOUT.byteOffset(PATH$mipLodBias);
    public static final long OFFSET$anisotropyEnable = LAYOUT.byteOffset(PATH$anisotropyEnable);
    public static final long OFFSET$maxAnisotropy = LAYOUT.byteOffset(PATH$maxAnisotropy);
    public static final long OFFSET$compareEnable = LAYOUT.byteOffset(PATH$compareEnable);
    public static final long OFFSET$compareOp = LAYOUT.byteOffset(PATH$compareOp);
    public static final long OFFSET$minLod = LAYOUT.byteOffset(PATH$minLod);
    public static final long OFFSET$maxLod = LAYOUT.byteOffset(PATH$maxLod);
    public static final long OFFSET$borderColor = LAYOUT.byteOffset(PATH$borderColor);
    public static final long OFFSET$unnormalizedCoordinates = LAYOUT.byteOffset(PATH$unnormalizedCoordinates);
}
